import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


class Classes {

    public static int square(int x) {
        return x * x;
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static boolean isPositive(int x) {
        return x > 0;
    }
}


class SquareTest {
    @Test
    void testPositive() {
        assertEquals(25, Classes.square(5));
    }

    @Test
    void testZero() {
        assertEquals(0, Classes.square(0));
    }

    @Test
    void testNegative() {
        assertEquals(9, Classes.square(-3));
    }
}

class MaxTest {
    @Test
    void testFirstBigger() {
        assertEquals(10, Classes.max(10, 3));
    }

    @Test
    void testSecondBigger() {
        assertEquals(8, Classes.max(2, 8));
    }

    @Test
    void testEqual() {
        assertEquals(5, Classes.max(5, 5));
    }
}

class IsPositiveTest {
    @Test
    void testPositive() {
        assertTrue(Classes.isPositive(5));
    }

    @Test
    void testNegative() {
        assertFalse(Classes.isPositive(-3));
    }

    @Test
    void testZero() {
        assertFalse(Classes.isPositive(0));
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("square(5)  = " + Classes.square(5));
        System.out.println("square(0)  = " + Classes.square(0));
        System.out.println("square(-3) = " + Classes.square(-3));

        System.out.println("max(10, 3) = " + Classes.max(10, 3));
        System.out.println("max(2, 8)  = " + Classes.max(2, 8));
        System.out.println("max(5, 5)  = " + Classes.max(5, 5));

        System.out.println("isPositive(5)  = " + Classes.isPositive(5));
        System.out.println("isPositive(-3) = " + Classes.isPositive(-3));
        System.out.println("isPositive(0)  = " + Classes.isPositive(0));
    }
}