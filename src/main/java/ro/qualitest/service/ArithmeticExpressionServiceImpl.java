package ro.qualitest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.qualitest.dto.Operation;

import java.math.BigDecimal;

@Service
public class ArithmeticExpressionServiceImpl implements ArithmeticExpressionService<String, BigDecimal> {

    @Autowired
    private OperationSpliterService spliterService;

    @Override
    public BigDecimal calculate(final String source) {
        //assume the expression is valid !! only numbers and operators (from validation layer)

        BigDecimal result = doCalculate(source);
        return result;
    }

    private BigDecimal doCalculate(final String source) {
        final Operation operation  = spliterService.split(source);
        if (operation.getOp() == null) {
            return BigDecimal.valueOf(operation.getLeft());
        } else {
            return operation.getOp().execute(BigDecimal.valueOf(operation.getLeft()), doCalculate(operation.getRight()));
        }
    }
}
