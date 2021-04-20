package ro.qualitest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ArithmeticExpressionServiceImplTest {

    @InjectMocks
    private ArithmeticExpressionServiceImpl arithmeticExpression;

    @Test
    public void test01() {
        final BigDecimal actualResult = arithmeticExpression.calculate("1+1");
        assertEquals(2, actualResult.intValue());
    }

}