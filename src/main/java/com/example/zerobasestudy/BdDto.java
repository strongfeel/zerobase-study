package com.example.zerobasestudy;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BdDto {
    private int B_ID;
    private String B_NAME;
    private String B_WIFINAME;
    private Timestamp B_IN_DATE;

    public BdDto(){
        super();
    }

    public BdDto(int B_ID, String B_NAME, String B_WIFINAME, Timestamp B_IN_DATE) {
        super();
        this.B_ID = B_ID;
        this.B_NAME = B_NAME;
        this.B_WIFINAME = B_WIFINAME;
        this.B_IN_DATE = B_IN_DATE;
    }
}


