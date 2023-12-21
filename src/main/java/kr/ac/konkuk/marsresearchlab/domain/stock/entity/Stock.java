package kr.ac.konkuk.marsresearchlab.domain.stock.entity;

import jakarta.persistence.*;
import kr.ac.konkuk.marsresearchlab.global.configs.base.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    Long id;

    @Column(name = "stock_code", nullable = false, unique = true, length = 45)
    private String code;

    @Column(name = "stock_isu_code")
    private String isuCode;

    @Column(name = "stock_name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "stock")
    private List<StockPrice> stockPrices = new ArrayList<>();

    @OneToMany(mappedBy = "stock")
    private List<StockPrediction> stockPredictions = new ArrayList<>();

    @Builder
    public Stock(Long id, String code, String name, Status status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.status = status;
    }

    public static Stock createStock(String code, String name) {
        return Stock.builder()
                .code(code)
                .name(name)
                .status(Status.ACTIVE)
                .build();
    }

    public int getLatestClosingPrice() {
        return this.stockPrices.stream()
                .max(Comparator.comparing(StockPrice::getDate))
                .map(StockPrice::getClose)
                .orElse(0);
    }

    public List<StockPrice> getLast15DaysPrices() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(16);

        return this.stockPrices.stream()
                .filter(stockPrice -> !stockPrice.getDate().isBefore(startDate) && !stockPrice.getDate().isAfter(endDate))
                .sorted(Comparator.comparing(StockPrice::getDate))
                .collect(Collectors.toList());
    }

    public List<StockPrediction> getNext5DaysPredictions() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(6);

        return this.stockPredictions.stream()
                .filter(stockPrediction -> !stockPrediction.getDate().isBefore(startDate) && !stockPrediction.getDate().isAfter(endDate))
                .sorted(Comparator.comparing(StockPrediction::getDate))
                .collect(Collectors.toList());
    }
}
