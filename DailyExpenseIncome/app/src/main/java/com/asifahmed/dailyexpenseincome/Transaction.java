package com.asifahmed.dailyexpenseincome;

public class Transaction {

    private String amount;
    private String txn_type;
    private String txn_purpose;
    private String date;
    private String time;
    private String desc;


    public Transaction(String amount, String txn_type, String txn_purpose, String date, String time, String desc) {
        this.amount = amount;
        this.txn_type = txn_type;
        this.txn_purpose = txn_purpose;
        this.date = date;
        this.time = time;
        this.desc = desc;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTxn_type() {
        return txn_type;
    }

    public void setTxn_type(String txn_type) {
        this.txn_type = txn_type;
    }

    public String getTxn_purpose() {
        return txn_purpose;
    }

    public void setTxn_purpose(String txn_purpose) {
        this.txn_purpose = txn_purpose;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String time) {
        this.desc = desc;
    }
}
