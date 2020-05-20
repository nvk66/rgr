package main.webapp.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static DataBase instance;

    private List<Car> cars;
    private static final String FILE = "C:/myapps/laba3_oop/text.txt";

    private DataBase() {
        cars = new ArrayList<>();
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
            instance.read();
        }
        return instance;
    }

    public void add(Car car) {
        read();
        cars.add(car);
        write();
    }

    public void read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(FILE)))) {
            cars = (List<Car>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(FILE)))) {
            objectOutputStream.writeObject(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void test() {
        for (int i = 0; i < 10; i++) {
            cars.add(new Car("Cor", "cor"));
        }
        write();
    }
}
