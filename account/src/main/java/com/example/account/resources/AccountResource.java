package com.example.account.resources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.example.account.api.AccountBalanceAverageByStateDTO;
import com.example.account.api.AccountDTO;
import com.example.account.api.BalanceAverageByStateDTO;
import com.example.account.core.Account;
import com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse;
import com.example.common.api.accountCommon.GenderCommon;
import com.example.common.api.accountCommon.StateCommon;
import com.example.common.api.accountRequest.AccountRequest;
import com.example.common.api.accountResponse.AccountResponse;
import com.example.common.core.account.AccountServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    private ManagedChannel externalServiceChannel;

    public AccountResource(ManagedChannel externalServiceChannel) {
        this.externalServiceChannel = externalServiceChannel;
    }

    @GET
    @Timed
    public List<Account> findAll() {
        AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub = AccountServiceGrpc.newBlockingStub(
            externalServiceChannel);
        Iterator<AccountResponse> accountResponses = accountServiceBlockingStub.findAll(Empty.newBuilder().build());
        List<Account> accounts = new ArrayList<>();
        accountResponses.forEachRemaining(accountResponse ->
                                              accounts.add(new Account(accountResponse.getAccountNumber()
                                                  , accountResponse.getBalance()
                                                  , accountResponse.getFirstname()
                                                  , accountResponse.getLastname()
                                                  , accountResponse.getAge()
                                                  , accountResponse.getGender().name()
                                                  , accountResponse.getAddress()
                                                  , accountResponse.getEmployer()
                                                  , accountResponse.getEmail()
                                                  , accountResponse.getCity()
                                                  , accountResponse.getState().name())));
        return accounts;
    }

    @POST
    public AccountDTO createAccount(AccountDTO accountDTO) {
        AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub = AccountServiceGrpc.newBlockingStub(
            externalServiceChannel);
        AccountResponse accountResponse = accountServiceBlockingStub
            .create(AccountRequest.newBuilder()
                                  .setBalance(accountDTO.getBalance())
                                  .setFirstname(accountDTO.getFirstname())
                                  .setLastname(accountDTO.getLastname())
                                  .setAge(accountDTO.getAge())
                                  .setGender(GenderCommon.valueOf(accountDTO.getGender()))
                                  .setAddress(accountDTO.getAddress())
                                  .setEmployer(accountDTO.getEmployer())
                                  .setEmail(accountDTO.getEmail())
                                  .setCity(accountDTO.getCity())
                                  .setState(StateCommon.valueOf(accountDTO.getState()))
                                  .build());
        accountDTO.setAccountNumber(accountResponse.getAccountNumber());
        return accountDTO;
    }

    @GET
    @Path("/average-by-state")
    public AccountBalanceAverageByStateDTO getAllAverageOfTheAccount() {
        AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub = AccountServiceGrpc.newBlockingStub(
            externalServiceChannel);
        AccountBalanceAverageByStateResponse response = accountServiceBlockingStub.findAllByStateAndAverage(
            Empty.newBuilder().build());
        List<BalanceAverageByStateDTO> balanceAverageByStateDTOS = response.getBalanceAverageByStateResponseList()
                                                                           .stream()
                                                                           .map(balanceAverageByStateResponse ->
                                                                                    new BalanceAverageByStateDTO(
                                                                                        balanceAverageByStateResponse.getState()
                                                                                        ,
                                                                                        balanceAverageByStateResponse.getDocCount()
                                                                                        ,
                                                                                        balanceAverageByStateResponse.getBalanceAverage()))
                                                                           .collect(Collectors.toList());
        return new AccountBalanceAverageByStateDTO(balanceAverageByStateDTOS
            , response.getMaxBalance(), response.getMinBalance());
    }
}
