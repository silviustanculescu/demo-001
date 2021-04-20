package ro.qualitest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ArithmeticExpressionServiceImpl implements ArithmeticExpressionService<String, BigDecimal> {

    @Autowired
    private OperationSpliterService sppliterService;

    @Override
    public BigDecimal calculate(final String source) {
        //assume the expression is valid !! only numbers and operators (from validation layer)
        return null;
       // BigDecimal result = calculate(split(source));

    }



}
