package kr.ac.konkuk.marsresearchlab.domain.stock.dto;

import kr.ac.konkuk.marsresearchlab.domain.stock.entity.Stock;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StockListResponseDto {
    private Long id;
    private String name;
    private String code;
    private int latestClosingPrice;

    @Builder
    public StockListResponseDto(Long id, String name, String code, int latestClosingPrice) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.latestClosingPrice = latestClosingPrice;
    }

    public static StockListResponseDto of(Stock stock) {
        return StockListResponseDto.builder()
                .id(stock.getId())
                .name(stock.getName())
                .code(stock.getCode())
                .latestClosingPrice(stock.getLatestClosingPrice())
                .build();
    }
}
