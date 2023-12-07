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
}
