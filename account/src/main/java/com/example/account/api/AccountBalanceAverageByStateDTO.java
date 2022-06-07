package com.example.account.api;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountBalanceAverageByStateDTO {
    private final List<BalanceAverageByStateDTO> averageByStates;
    private final Long maxBalance;
    private final Long minBalance;

    public AccountBalanceAverageByStateDTO(List<BalanceAverageByStateDTO> balanceAverageByStateDTOS
        , Long maxBalance, Long minBalance) {
        this.averageByStates = balanceAverageByStateDTOS;
        this.maxBalance = maxBalance;
        this.minBalance = minBalance;
    }

}
