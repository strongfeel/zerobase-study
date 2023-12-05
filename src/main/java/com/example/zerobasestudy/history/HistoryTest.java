package com.example.zerobasestudy.history;

import com.example.zerobasestudy.db.HistoryDto;
import com.example.zerobasestudy.history.HistoryService;

import java.util.List;

public class HistoryTest {
    public static void main(String[] args) {

        HistoryDto historyDto = new HistoryDto();

        HistoryService historyService = new HistoryService();

        boolean result = historyService.historyAdd(historyDto); // 히스토리 추가

        boolean result2 = historyService.withdraw(historyDto);

        List<HistoryDto> historyDtoList = historyService.getList();
    }
}
