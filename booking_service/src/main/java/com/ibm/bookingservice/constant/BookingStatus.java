package com.ibm.bookingservice.constant;

public enum BookingStatus {
    CREATED("Created"), ALLOCATED("Allocated"), NOT_AVAILABLE("Not Available");

    private String status;

    BookingStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
