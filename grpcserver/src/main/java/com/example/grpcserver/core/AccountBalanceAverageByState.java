package com.example.grpcserver.core;

import java.util.List;
import lombok.Getter;

@Getter
public class AccountBalanceAverageByState {

  private final List<BalanceAverageByState> averageByStates;
  private final Double maxBalance;
  private final Double minBalance;

  public AccountBalanceAverageByState(List<BalanceAverageByState> averageByStates,
      Double maxBalance, Double minBalance) {
    this.averageByStates = averageByStates;
    this.maxBalance = maxBalance;
    this.minBalance = minBalance;
  }
}
