package ro.qualitest.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ArithmeticExpressionServiceImpl implements ArithmeticExpressionService<String, BigDecimal> {

    @Override
    public BigDecimal calculate(final String source) {
        //assume the expression is valid !!

        return null;
    }
}
