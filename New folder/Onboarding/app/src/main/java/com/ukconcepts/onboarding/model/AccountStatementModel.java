package com.ukconcepts.onboarding.model;

public class AccountStatementModel {

    public String DATE;
    public String PINNO;
    public String PREMIUM;

    public AccountStatementModel(String date, String pinno, String premium
    ) {
        this.DATE = date;
        this.PINNO = pinno;
        this.PREMIUM = premium;

    }

    public String getDATE() {
        return DATE;
    }

    public String getPINNO() {
        return PINNO;
    }

    public String getPREMIUM() {
        return PREMIUM;
    }

}