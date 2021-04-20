package ro.qualitest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import ro.qualitest.dto.Operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class OperationSpliterServiceTest {

    @InjectMocks
    private OperationSpliterService service;

    @Test
    public void testOperation() {

        final Operation actualResult = service.split("11+3");

        assertEquals(11, actualResult.getLeft().intValue());
        assertEquals("+", actualResult.getOp().getOp());
        assertEquals("3", actualResult.getRight());
    }

    @Test
    public void testOperationOne() {

        final Operation actualResult = service.split("1133");

        assertEquals(1133, actualResult.getLeft().intValue());
        assertNull( actualResult.getOp());
        assertNull(actualResult.getRight());
    }
}