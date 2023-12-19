package kr.ac.konkuk.marsresearchlab.domain.stock.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class StockPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_prediction_id", nullable = false)
    private Long id;

    @Column(name = "stock_prediction_date", nullable = false)
    private Date date;

    @Column(name = "stock_prediction_price", nullable = false)
    private int price;
}
