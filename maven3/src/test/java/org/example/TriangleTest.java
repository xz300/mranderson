package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


public class TriangleTest {
    FunctionTriangle functionTriangle = new FunctionTriangle();
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Позитивная проверка")
    void trianglePositiveTest() throws Exception {
        logger.debug("Позитивная проверка");
        assertThat(functionTriangle.functionTriangleCal(2, 2, 2)).isNotNegative();
    }

    @Test
    @DisplayName("Негативная проверка с нулём")
    void checkExceptionZero() throws TriangleException {
        logger.debug("Негативная проверка");
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() ->
                functionTriangle.functionTriangleCal(1, 2, 0));
    }

    @Test
    @DisplayName("Негативная проверка с отрицательным значением")
    void checkExceptionWhenTriangleNegativeSide() {
        logger.debug("Проверка с отрицательным значением");
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() ->
                functionTriangle.functionTriangleCal(1, 2, -2));
    }

}
