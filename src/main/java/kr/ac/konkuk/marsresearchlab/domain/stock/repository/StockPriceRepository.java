package kr.ac.konkuk.marsresearchlab.domain.stock.repository;

import kr.ac.konkuk.marsresearchlab.domain.stock.entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
}
