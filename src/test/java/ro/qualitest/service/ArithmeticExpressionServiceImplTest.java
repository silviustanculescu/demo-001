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
    public void testCalculate_Add2Tokens() {

        when(spliterService.split("1+1")).thenReturn(Operation.builder()
                .left(1).op(EOperationType.ADD).right("1").build());
        when(spliterService.split("1")).thenReturn(Operation.builder()
                .left(1).build());

        final BigDecimal actualResult = arithmeticExpression.calculate("1+1");

        assertEquals(2, actualResult.intValue());
    }

    @Test
    public void testCalculate_Add3Tokens() {

        when(spliterService.split("1+1+7")).thenReturn(Operation.builder()
                .left(1).op(EOperationType.ADD).right("1+7").build());
        when(spliterService.split("1+7")).thenReturn(Operation.builder()
                .left(1).op(EOperationType.ADD).right("7").build());
        when(spliterService.split("7")).thenReturn(Operation.builder()
                .left(7).build());

        final BigDecimal actualResult = arithmeticExpression.calculate("1+1+7");

        assertEquals(9, actualResult.intValue());
    }

    @Test
    public void testCalculate_Add_Substract4Tokens() {

        when(spliterService.split("8+1-5+7")).thenReturn(Operation.builder()
                .left(8).op(EOperationType.ADD).right("1-5+7").build());
        when(spliterService.split("1-5+7")).thenReturn(Operation.builder()
                .left(1).op(EOperationType.SUBSTRACT).right("5+7").build());
        when(spliterService.split("5+7")).thenReturn(Operation.builder()
                .left(5).op(EOperationType.ADD).right("7").build());
        when(spliterService.split("7")).thenReturn(Operation.builder()
                .left(7).build());

        final BigDecimal actualResult = arithmeticExpression.calculate("8+1-5+7");

        assertEquals(11, actualResult.intValue());
    }

}