package kr.ac.konkuk.marsresearchlab.domain.stock.entity;

import jakarta.persistence.*;
import kr.ac.konkuk.marsresearchlab.global.configs.base.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
}
