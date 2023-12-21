package kr.ac.konkuk.marsresearchlab.domain.stock.repository;

import kr.ac.konkuk.marsresearchlab.domain.stock.entity.Stock;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findByCode(String code);

    @Query("SELECT s FROM Stock s WHERE s.name LIKE %:keyword%")
    List<Stock> findByNameContaining(@Param("keyword") String keyword, Pageable pageable);
}
