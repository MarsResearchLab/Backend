package kr.ac.konkuk.marsresearchlab.domain.stock.repository;

import kr.ac.konkuk.marsresearchlab.domain.stock.entity.Stock;
import kr.ac.konkuk.marsresearchlab.global.configs.base.RepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@RepositoryTest
class StockRepositoryTest {

    @Autowired
    private StockRepository stockRepository;

    private Stock stock;

    @BeforeEach
    public void setup() {
        // Common setup code for each test
        stock = Stock.createStock(
                "TEST_CODE",
                "TestStockName"
        );
        stockRepository.save(stock);
    }

    @Test
    @DisplayName("주식을 코드로 조회한다.")
    public void testFindByCode_PositiveCase() {
        // When
        Stock foundStock = stockRepository.findByCode("TEST_CODE");
        // Then
        assertNotNull(foundStock);
        assertEquals("TEST_CODE", foundStock.getCode());
        assertEquals("TestStockName", foundStock.getName());
    }

    @Test
    @DisplayName("잘못된 코드로 주식을 조회할 경우 null을 반환한다.")
    public void testFindByCode_NegativeCase() {
        // When
        Stock foundStock = stockRepository.findByCode("WRONG_CODE");
        // Then
        assertNull(foundStock);
    }

}