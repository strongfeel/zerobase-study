package com.example.zerobasestudy.db;

import java.util.Scanner;

public class DbHistoryTestMain {
    public static void main(String[] args) {

        DbHistoryService dbHistoryService = new DbHistoryService();
        //dbHistoryService.historyList();
        //dbHistoryService.dbInsert();
        //dbHistoryService.dbDelete();

        Scanner scanner = new Scanner(System.in);

        System.out.println("x값 입력: ");
        String x = scanner.next();
        System.out.println("y값 입력: ");
        String y = scanner.next();

        HistoryDto historyDto = new HistoryDto();
        historyDto.setX(x);
        historyDto.setY(y);

        dbHistoryService.dbInsert(historyDto);
    }
}
