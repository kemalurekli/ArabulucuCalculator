package com.example.arabulucuhesapmatik.enums;


public enum SubDisagreementType {
    TWO(0),
    THREE_OR_FIVE(1),
    SIX_OR_TEN(2),
    ELEVEN(3);

    private int value;

    SubDisagreementType(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
