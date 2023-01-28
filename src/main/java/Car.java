import java.util.ArrayList;
import java.util.List;

public class Car {
    private String manufacturer;
    private String number;
    private int year;
    private String owner;
    private ArrayList<String> owners = new ArrayList<>();

    public Car(){

    }

    public Car(String manufacturer, String number, int year, String owner) {
        this.manufacturer = manufacturer;
        this.number = number;
        this.year = year;
        this.owner = owner;
        owners.add(owner);
    }

    public String getManufacturer() {
        return manufacturer;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
        owners.add(owner);
    }

    public ArrayList<String> getOwners(){
        return owners;
    }

    private String testMethod(){
        return "abc";
    }

    private String testMethod(String a){
        return a;
    }

    @Override
    public String toString() {
        return "manufacturer='" + manufacturer + '\'' +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", owner='" + owner + '\'';
    }

    public void showInfo(List<Car> car){
        for(Car car1 : car){
            System.out.println(car);
        }
    }

    public void throwException() throws Exception{
        throw new Exception("!!!");
    }
}
