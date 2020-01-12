package com.ukconcepts.onboarding.check_balance;

public class CheckBalanceModel {

    private String accountNo;
    private String accountBalance;

    public CheckBalanceModel(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }


}
