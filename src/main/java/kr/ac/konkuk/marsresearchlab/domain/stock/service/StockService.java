package kr.ac.konkuk.marsresearchlab.domain.stock.service;

import kr.ac.konkuk.marsresearchlab.domain.stock.dto.StockDetailResponseDto;
import kr.ac.konkuk.marsresearchlab.domain.stock.dto.StockListResponseDto;
import kr.ac.konkuk.marsresearchlab.domain.stock.entity.Stock;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockService {

    List<StockListResponseDto> getStocks(Pageable pageable);

    StockDetailResponseDto getStock(Long stockId);

    List<StockListResponseDto> searchStocks(String keyword, Pageable pageable);
}
