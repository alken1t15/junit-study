import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassCar {

    @Test
    // @DisabledOnOs(OS.MAC) // мю йюйни бепяхх лш ме унрхл гюосяйюрэ реяр
    @EnabledOnOs(OS.WINDOWS) // гюосяй мю нопедекеммни яхяреле
    @EnabledOnJre(JRE.JAVA_17) // гюосяй мю нопедекммни бепяхх JAVA
    public void getCarYear() {
        Car car = new Car("2000", "blue", 2020, "бЮЯЪ");
        assertEquals(2020, car.getYear());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT) // бшонкмърэ ме оюпюккекэмн
    public void getCarWeight() {
        Car car = new Car("2000", "blue", 2020, "бЮЯЪ");
        assertEquals("blue", car.getNumber());
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD) // бшонкмърэ  оюпюккекэмн
    public void getCarOwner() {
        Car car = new Car("2000", "blue", 2020, "бЮЯЪ");
        assertEquals("бЮЯЪ", car.getOwner());
    }
}