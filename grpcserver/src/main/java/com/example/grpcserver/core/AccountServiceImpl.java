package com.example.grpcserver.core;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse;
import com.example.common.api.accountBalanceAverageByStateResponse.BalanceAverageByStateResponse;
import com.example.common.api.accountCommon.GenderCommon;
import com.example.common.api.accountCommon.StateCommon;
import com.example.common.api.accountRequest.AccountRequest;
import com.example.common.api.accountResponse.AccountResponse;
import com.example.common.core.account.AccountServiceGrpc;
import com.example.grpcserver.db.AccountDAO;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

public class AccountServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {

  private final AccountDAO accountDAO;

  public AccountServiceImpl(AccountDAO accountDAO) {
    this.accountDAO = accountDAO;
  }

  @Override
  public void findAll(Empty request, StreamObserver<AccountResponse> responseObserver) {
    accountDAO.findAll().stream().forEach(account -> {
      responseObserver.onNext(AccountResponse.newBuilder()
          .setAccountNumber(account.getAccountNumber())
          .setBalance(account.getBalance())
          .setFirstname(account.getFirstname())
          .setLastname(account.getLastname())
          .setAge(account.getAge())
          .setGender(GenderCommon.valueOf(account.getGender()))
          .setAddress(account.getAddress())
          .setEmployer(account.getEmployer())
          .setEmail(account.getEmail())
          .setCity(account.getCity())
          .setState(StateCommon.valueOf(account.getState()))
          .build());
    });
    responseObserver.onCompleted();
  }

  @Override
  public void findAllByStateAndAverage(Empty request,
      StreamObserver<AccountBalanceAverageByStateResponse> responseObserver) {
        AccountBalanceAverageByState accountBalanceAverageByState = accountDAO.findAllByStateAndAverage();
        List<BalanceAverageByStateResponse> builders = accountBalanceAverageByState.getAverageByStates().stream()
                                                                                   .map(balanceAverageByState -> BalanceAverageByStateResponse.newBuilder()
                        .setState(balanceAverageByState.getState().name())
                        .setDocCount(balanceAverageByState.getDocCount())
                        .setBalanceAverage(balanceAverageByState.getBalanceAverage()).build())
                                                                                   .collect(Collectors.toList());
        responseObserver.onNext(AccountBalanceAverageByStateResponse.newBuilder()
                .addAllBalanceAverageByStateResponse(builders)
                .setMaxBalance(accountBalanceAverageByState.getMaxBalance().longValue())
                .setMinBalance(accountBalanceAverageByState.getMinBalance().longValue())
                .build());
        responseObserver.onCompleted();
  }

  @Override
  public void create(AccountRequest request, StreamObserver<AccountResponse> responseObserver) {
        long accountNumber = UUID.randomUUID().getMostSignificantBits();
        Account account = accountDAO.create(
                new Account(accountNumber, request.getBalance(), request.getFirstname()
                        , request.getLastname(), request.getAge(), request.getGender().name()
                        , request.getAddress(), request.getEmployer(), request.getEmail(), request.getCity()
                        , request.getState().name()));
        responseObserver.onNext(AccountResponse.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(account.getBalance())
                .setAge(account.getAge())
                .setAddress(account.getAddress())
                .setCity(account.getCity())
                .setEmail(account.getEmail())
                .setEmployer(account.getEmployer())
                .setFirstname(account.getFirstname())
                .setLastname(account.getLastname())
                .setGender(GenderCommon.valueOf(account.getGender()))
                .setState(StateCommon.valueOf(account.getState()))
                .build());
  }
}
