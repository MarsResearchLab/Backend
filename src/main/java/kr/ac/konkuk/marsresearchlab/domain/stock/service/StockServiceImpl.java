package kr.ac.konkuk.marsresearchlab.domain.stock.service;

import kr.ac.konkuk.marsresearchlab.domain.stock.dto.StockDetailResponseDto;
import kr.ac.konkuk.marsresearchlab.domain.stock.dto.StockListResponseDto;
import kr.ac.konkuk.marsresearchlab.domain.stock.entity.Stock;
import kr.ac.konkuk.marsresearchlab.domain.stock.repository.StockPriceRepository;
import kr.ac.konkuk.marsresearchlab.domain.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final StockPriceRepository stockPriceRepository;

    @Override
    public List<StockListResponseDto> getStocks(Pageable pageable) {
        return stockRepository.findAll(pageable).stream()
                .map(StockListResponseDto::of)
                .toList();
    }

    @Override
    public StockDetailResponseDto getStock(Long stockId) {
        Stock stock = stockRepository.findById(stockId).orElse(null);
        return StockDetailResponseDto.of(stock);
    }

    @Override
    public List<StockListResponseDto> searchStocks(String keyword, Pageable pageable) {
        return stockRepository.findByNameContaining(keyword, pageable).stream()
                .map(StockListResponseDto::of)
                .toList();
    }
}
