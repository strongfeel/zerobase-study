package com.example.zerobasestudy;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BgDto {
    private int BG_ID;
    private String BG_NAME;
    private String BG_PRI;
    private Timestamp BG_IN_DATE;
    private Timestamp BG_UPDATE;

    public BgDto() {
        super();
    }

    public BgDto(int BG_ID, String BG_NAME, String BG_PRI, Timestamp BG_IN_DATE, Timestamp BG_UPDATE) {
        super();
        this.BG_ID = BG_ID;
        this.BG_NAME = BG_NAME;
        this.BG_PRI = BG_PRI;
        this.BG_IN_DATE = BG_IN_DATE;
        this.BG_UPDATE = BG_UPDATE;
    }
}
