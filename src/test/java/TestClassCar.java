import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassCar {

    @Test
    // @DisabledOnOs(OS.MAC) // �� ����� ������ �� �� ����� ��������� ����
    @EnabledOnOs(OS.WINDOWS) // ������ �� ������������ �������
    @EnabledOnJre(JRE.JAVA_17) // ������ �� ����������� ������ JAVA
    public void getCarYear() {
        Car car = new Car("2000", "blue", 2020, "����");
        assertEquals(2020, car.getYear());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT) // ��������� �� �����������
    public void getCarWeight() {
        Car car = new Car("2000", "blue", 2020, "����");
        assertEquals("blue", car.getNumber());
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD) // ���������  �����������
    public void getCarOwner() {
        Car car = new Car("2000", "blue", 2020, "����");
        assertEquals("����", car.getOwner());
    }
}