package com.ibm.bookingservice.enums;

public enum LocationStatusEnum {
    AVAILABLE("Available"), BOOKED("Booked");

    private final String value;

    LocationStatusEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
