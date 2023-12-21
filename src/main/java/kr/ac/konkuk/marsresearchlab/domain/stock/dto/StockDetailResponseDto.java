package kr.ac.konkuk.marsresearchlab.domain.stock.dto;

import kr.ac.konkuk.marsresearchlab.domain.stock.entity.Stock;
import kr.ac.konkuk.marsresearchlab.domain.stock.entity.StockPrediction;
import kr.ac.konkuk.marsresearchlab.domain.stock.entity.StockPrice;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class StockDetailResponseDto {
    private Long id;
    private String name;
    private String code;

    private List<Integer> last15DaysPrices;
    private List<Integer> next5DaysPredictions;
    private boolean isPredicted;
    private boolean isFavorite;

    @Builder
    public StockDetailResponseDto(Long id, String name, String code, List<StockPrice> last15DaysPrices, List<StockPrediction> next5DaysPredictions) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.last15DaysPrices = last15DaysPrices.stream()
                .map(StockPrice::getClose)
                .toList();
        this.next5DaysPredictions = next5DaysPredictions.stream()
                .map(StockPrediction::getPrice)
                .toList();
        this.isPredicted = next5DaysPredictions.size() > 0;
    }

    public static StockDetailResponseDto of(Stock stock) {
        return StockDetailResponseDto.builder()
                .id(stock.getId())
                .name(stock.getName())
                .code(stock.getCode())
                .last15DaysPrices(stock.getLast15DaysPrices())
                .next5DaysPredictions(stock.getNext5DaysPredictions())
                .build();
    }

}
