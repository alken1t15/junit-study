import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    public void createCar() {
        car = new Car("Skoda", "ABC-1234", 2019, "Maxim Korablev");
    }

    @Test
    void getManufacturer() {
        assertEquals("Skoda", car.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("ABC-1234", car.getNumber());
    }

    @Test
    void setNumber() {
        car.setNumber("ABCD-1234");
        assertEquals("ABCD-1234", car.getNumber());
    }

    @ParameterizedTest
//            Если нужно для более 1 параметра
    @CsvSource({"'ABCD-123','ABCD-123'", "'DEF-456','DEF-456'"})
//            Если нужно передать для 1 параметра
//    @ValueSource(strings = {"ABC-123","DEF-456","DFG-434"})
//    @NullSource
//    @EmptySource
    void testSetNumberMultipleValues(String number, String x) {
        car.setNumber(number);
        assertEquals(number, car.getNumber());
    }

    @Test
    void getYear() {
        assertEquals(2019, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Maxim Korablev", car.getOwner());
    }

    @Test
    void setOwner() {
        car.setOwner("Andrej Kirilov");
        assertEquals("Andrej Kirilov", car.getOwner());
    }

    @Test
    void getListOfOwners() {
        assertArrayEquals(new String[]{"Maxim Korablev"}, car.getOwners().toArray());
    }

    @Test
    void getListOfTwoOwners() {
        car.setOwner("Andrej Kirilov");
        assertArrayEquals(new String[]{"Maxim Korablev", "Andrej Kirilov"}, car.getOwners().toArray());
    }

    @Test
    public void testPrivateMethod() {
        try {
            Method method = Car.class.getDeclaredMethod("testMethod", null);
            method.setAccessible(true);

            assertEquals(method.invoke(car).toString(), "abc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPrivateMethodWithArgument() {
        try {
            Method method = Car.class.getDeclaredMethod("testMethod", String.class);
            method.setAccessible(true);

            assertEquals(method.invoke(car, "abd").toString(), "abd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void showCarInfo() {
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            Car car1 = new Car();
            ArrayList<Car> cars = new ArrayList<>();
            cars.add(new Car("Skoda", "ABC-1234", 2019, "Maxim Korablev"));
//            cars.add(new Car("Audi", "AEF-1234", 2023, "NIKITA TOP"));
//            cars.add(new Car("BMV", "GGG-1234", 2014, "NIKITA KLOVN"));
            car1.showInfo(cars);
            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("[manufacturer='" + "Skoda" + '\'' +
                ", number='" + "ABC-1234" + '\'' +
                ", year=" + 2019 +
                ", owner='" + "Maxim Korablev']\r\n", consoleOutput);
    }

    @ParameterizedTest()
    @DisplayName("Test demonstrates how test data could be loaded from file")
    @CsvFileSource(resources = "/test-data.csv", delimiter = '|', numLinesToSkip = 1)
    public void testNumbers(String input, String expected) {
        car.setNumber(input);
        assertEquals(expected, car.getNumber());
    }

    @Test
    void getTestData() {
        Exception exception = assertThrows(Exception.class, () -> {
            car.throwException();
        });
        assertEquals("!!!", exception.getMessage());
    }
}