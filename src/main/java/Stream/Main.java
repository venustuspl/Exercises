package Stream;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Car1", 1972);
        Car car2 = new Car("Car2", 1912);
        Car car3 = new Car("Car3", 1952);
        Car car4 = new Car("Car4", 1932);
        Car car5 = new Car("Car5", 1982);
        Car car6 = new Car("Car6", 1942);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);


        List<Car> result = cars.stream()
                .sorted(Comparator.comparingInt(Car::getYear))
                .collect(Collectors.toList());

        for (Car entry : result) {
            System.out.println(entry.getName() + " " + entry.getYear());
        }

        System.out.println("-----------");
        List<String> names = cars.stream()
                //.map(Car::getName)
                .map(c -> c.getName())
                .collect(Collectors.toList());

        for (String entry : names) {
            System.out.print(entry + " ");
        }
        System.out.println("\n-----------");
        int years = cars.stream()
                //.map(Car::getName)
                .filter(c -> c.getYear() > 1980)
                .mapToInt(c -> c.getYear())
                .sum();

        System.out.println(years);

        System.out.println("\n-----------");
        OptionalDouble years2 = IntStream.range(0, cars.size())
                .map(c -> cars.get(c).getYear())
                .average();

        System.out.println(years2);

        System.out.println("End of the program.");
    }
}