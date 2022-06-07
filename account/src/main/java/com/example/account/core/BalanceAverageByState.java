package com.example.account.core;

import lombok.Getter;

@Getter
public class BalanceAverageByState {
    private final State state;
    private final Long docCount;
    private final Double balanceAverage;

    public BalanceAverageByState(State state, Long docCount, Double balanceAverage) {
        this.state = state;
        this.docCount = docCount;
        this.balanceAverage = balanceAverage;
    }

}
