package kr.ac.konkuk.marsresearchlab.domain.stock.repository;

import kr.ac.konkuk.marsresearchlab.domain.stock.entity.StockPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPredictionRepository extends JpaRepository<StockPrediction, Long> {
}
