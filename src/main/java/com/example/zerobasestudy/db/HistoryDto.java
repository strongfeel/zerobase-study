package com.example.zerobasestudy.db;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class HistoryDto {
    private int H_ID;
    private String X;
    private String Y;
    private Timestamp H_DATE;

    //생성자
    public HistoryDto() {
        super();
    }

    //매개변수 생성자
    public HistoryDto(int H_ID, String X, String Y, Timestamp H_DATE) {
        super();
        this.H_ID = H_ID;
        this.X = X;
        this.Y = Y;
        this.H_DATE = H_DATE;
    }
}
