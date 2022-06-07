package com.example.grpcserver.db;

import com.example.grpcserver.core.Account;
import com.example.grpcserver.core.AccountBalanceAverageByState;
import com.example.grpcserver.core.BalanceAverageByState;
import com.example.grpcserver.core.State;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.ml.PostDataRequest;
import org.elasticsearch.client.ml.job.process.DataCounts;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.PipelineAggregatorBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.aggregations.pipeline.MaxBucketPipelineAggregationBuilder;
import org.elasticsearch.search.aggregations.pipeline.MinBucketPipelineAggregationBuilder;
import org.elasticsearch.search.aggregations.pipeline.ParsedBucketMetricValue;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class AccountDAO {

    private final RestHighLevelClient restHighLevelClient;

    public AccountDAO(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    public Account create(Account account) {
        PostDataRequest.JsonBuilder jsonBuilder = new PostDataRequest.JsonBuilder();
        try {
            String json = new ObjectMapper().writeValueAsString(account);
            jsonBuilder.addDoc(json);
            PostDataRequest postDataRequest = new PostDataRequest("account_indice", jsonBuilder);
            DataCounts dataCounts = restHighLevelClient.machineLearning().postData(postDataRequest, RequestOptions.DEFAULT).getDataCounts();
            System.out.println(dataCounts);
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        SearchRequest searchRequest = new SearchRequest("account_indice");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        List<Account> accounts = new ArrayList<>();
        try {
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            for (SearchHit hit : searchResponse.getHits().getHits()) {
                ObjectMapper objectMapper = new ObjectMapper();
                Account account = objectMapper.readValue(hit.getSourceAsString(), Account.class);
                accounts.add(account);
            }
            return accounts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AccountBalanceAverageByState findAllByStateAndAverage() {
        try {
            AvgAggregationBuilder avgAggregationBuilder = AggregationBuilders.avg("balance_avg").field("balance");
            TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("state_terms").field("state")
                    .subAggregation(avgAggregationBuilder);
            MaxBucketPipelineAggregationBuilder maxBalancePipeline = PipelineAggregatorBuilders.maxBucket("max_balance", "state_terms>balance_avg");
            MinBucketPipelineAggregationBuilder minBalancePipeline = PipelineAggregatorBuilders.minBucket("min_balance", "state_terms>balance_avg");

            SearchRequest searchRequest = new SearchRequest("account_indice");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.aggregation(termsAggregationBuilder)
                    .aggregation(maxBalancePipeline).aggregation(minBalancePipeline);
            searchRequest.source(searchSourceBuilder);

            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            Terms stateTerms = searchResponse.getAggregations().get("state_terms");
            ParsedBucketMetricValue maxBalance = searchResponse.getAggregations().get("max_balance");
            ParsedBucketMetricValue minBalance = searchResponse.getAggregations().get("min_balance");
            List<BalanceAverageByState> averageByStates = new ArrayList<>();
            for (Terms.Bucket bucket : stateTerms.getBuckets()) {
                Avg avg = bucket.getAggregations().get("balance_avg");
                BalanceAverageByState balanceAverageByState = new BalanceAverageByState(
                        State.valueOf(bucket.getKeyAsString()), bucket.getDocCount(), avg.getValue());
                averageByStates.add(balanceAverageByState);
            }
            return new AccountBalanceAverageByState(averageByStates, maxBalance.value(), minBalance.value());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
