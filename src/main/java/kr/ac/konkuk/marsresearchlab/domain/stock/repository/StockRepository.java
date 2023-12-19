package kr.ac.konkuk.marsresearchlab.domain.stock.repository;

import kr.ac.konkuk.marsresearchlab.domain.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findByCode(String code);
}
