package com.example.account.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceAverageByStateDTO {
    private final String state;
    private final Long docCount;
    private final Double balanceAverage;

    public BalanceAverageByStateDTO(String state, Long docCount, Double balanceAverage) {
        this.state = state;
        this.docCount = docCount;
        this.balanceAverage = balanceAverage;
    }

}
