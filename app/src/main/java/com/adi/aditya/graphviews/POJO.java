package com.adi.aditya.graphviews;

public class POJO {
    private int txtvw1;
    private int txtvw2;

    //constructor
    public POJO(String txtvw1, String txtvw2) {
        this.txtvw1 = Integer.parseInt(txtvw1);
        this.txtvw2 = Integer.parseInt(txtvw2);
    }

    public POJO(int txtvw1, int txtvw2) {
        this.txtvw1 = txtvw1;
        this.txtvw2 = txtvw2;
    }

    //getter and setter methods

    public int getTxtvw1() {
        return txtvw1;
    }

    public void setTxtvw1(int txtvw1) {
        this.txtvw1 = txtvw1;
    }

    public int getTxtvw2() {
        return txtvw2;
    }

    public void setTxtvw2(int txtvw2) {
        this.txtvw2 = txtvw2;
    }
}
