package com.example.arabulucuhesapmatik.enums;


public enum DisagreementType {
    AILE_HUKUKU(0),
    TICARI(1),
    ISCI(2),
    TUKETICI(3),
    DIGER(4);

    private int value;

    DisagreementType(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
