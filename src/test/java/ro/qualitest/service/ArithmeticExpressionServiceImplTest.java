package ro.qualitest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import ro.qualitest.dto.EOperationType;
import ro.qualitest.dto.Operation;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArithmeticExpressionServiceImplTest {

    @InjectMocks
    private ArithmeticExpressionServiceImpl arithmeticExpression;
    @Mock
    private OperationSpliterService spliterService;

    @Test
    public void test01() {

        when(spliterService.split("1+1")).thenReturn(Operation.builder()
                .left(1).op(EOperationType.ADD).right("1").build());
        when(spliterService.split("1")).thenReturn(Operation.builder()
                .left(1).build());

        final BigDecimal actualResult = arithmeticExpression.calculate("1+1");

        assertEquals(2, actualResult.intValue());
    }

}