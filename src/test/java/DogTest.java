import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    static Dog dog;

//    @BeforeEach
//    void prepareData(){
//         dog = new Dog("Альберт",2);
//    }

    @BeforeAll
    static void prepareData() {
        dog = new Dog("Альберт", 2);
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Альберт", dog.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        dog.setName("Роман");
        assertEquals("Альберт", dog.getName());
    }

    @org.junit.jupiter.api.Test
    void setNameIf() {
        Dog dog = new Dog("", 2);
        dog.setName("Роман");
        assertEquals("Роман", dog.getName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
    }

    @org.junit.jupiter.api.Test
    void setAge() {
    }
}