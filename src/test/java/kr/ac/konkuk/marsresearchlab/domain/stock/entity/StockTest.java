package kr.ac.konkuk.marsresearchlab.domain.stock.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    @DisplayName("모든 정보를 올바른 형식으로 입력하면 주식이 생성된다")
    void createStock() {
        assertDoesNotThrow(
                () -> Stock.createStock("testCode", "testStockName")
        );
    }

    @Test
    @DisplayName("주식의 코드가 올바르게 반환된다")
    void getCode() {
        String expected = "testCode";
        Stock stock = Stock.createStock(expected, "testStockName");

        String actual = stock.getCode();

        assertEquals(expected, actual);
    }
}