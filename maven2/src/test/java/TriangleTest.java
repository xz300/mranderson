import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    FunctionTriangle functionTriangle = new FunctionTriangle();

    @Test
    void testGivenEvenNumberWhenCheckIsEvenThenTrue() {
        boolean result = functionTriangle.main(2);
        Assertions.assertTrue(result);
    }
}
