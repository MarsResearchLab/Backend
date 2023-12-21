package kr.ac.konkuk.marsresearchlab.domain.stock.controller;

import kr.ac.konkuk.marsresearchlab.domain.stock.dto.StockDetailResponseDto;
import kr.ac.konkuk.marsresearchlab.domain.stock.dto.StockListResponseDto;
import kr.ac.konkuk.marsresearchlab.domain.stock.entity.Stock;
import kr.ac.konkuk.marsresearchlab.domain.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
@RestController
public class StockController {

    private final StockService stockService;

    @GetMapping("")
    public ResponseEntity<List<StockListResponseDto>> getStocks(Pageable pageable) {
        log.info("get Stocks List");
        log.info("pageable: {}", pageable);
        return ResponseEntity.ok(stockService.getStocks(pageable));
    }

    @GetMapping("/{stockId}")
    public ResponseEntity<StockDetailResponseDto> getStock(@PathVariable Long stockId) {
        log.info("get Stock Detail: {}", stockId);
        return ResponseEntity.ok(stockService.getStock(stockId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<StockListResponseDto>> searchStocks(@RequestParam String keyword, Pageable pageable) {
        log.info("search Stocks: {}", keyword);
        return ResponseEntity.ok(stockService.searchStocks(keyword, pageable));
    }
}
