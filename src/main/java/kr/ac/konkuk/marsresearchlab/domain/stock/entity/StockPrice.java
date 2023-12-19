package kr.ac.konkuk.marsresearchlab.domain.stock.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_price_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Column(name = "stock_price_date", nullable = false)
    private Date date;

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
