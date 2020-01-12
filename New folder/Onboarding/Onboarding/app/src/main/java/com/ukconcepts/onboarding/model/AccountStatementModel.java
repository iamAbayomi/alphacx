package com.ukconcepts.onboarding.model;

public class AccountStatementModel {

    public String SNO;
    public String DATE;
    public String PINNO;
    public String PREMIUM;
    public String RUNNINBALANCE;

    public  AccountStatementModel(){

    }

    public AccountStatementModel(String sno, String date, String pinno, String premium,
                                 String runninbalance){
        this.SNO = sno;
        this.DATE = date;
        this.PINNO = pinno;
        this.PREMIUM = premium;
        this.RUNNINBALANCE = runninbalance;

    }

    public String getSNO() {
        return SNO;
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

    public String getRUNNINBALANCE() {
        return RUNNINBALANCE;
    }


    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public void setPINNO(String PINNO) {
        this.PINNO = PINNO;
    }

    public void setPREMIUM(String PREMIUM) {
        this.PREMIUM = PREMIUM;
    }

    public void setRUNNINBALANCE(String RUNNINBALANCE) {
        this.RUNNINBALANCE = RUNNINBALANCE;
    }
}
