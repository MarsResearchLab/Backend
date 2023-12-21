package kr.ac.konkuk.marsresearchlab.domain.stock.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_price_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Column(name = "stock_price_date", nullable = false)
    private LocalDate date;

    @Column(name = "stock_price_open", nullable = false)
    private int open;

    @Column(name = "stock_price_high", nullable = false)
    private int high;

    @Column(name = "stock_price_low", nullable = false)
    private int low;

    @Column(name = "stock_price_close", nullable = false)
    private int close;

    @Column(name = "stock_price_volume", nullable = false)
    private int volume;
}
