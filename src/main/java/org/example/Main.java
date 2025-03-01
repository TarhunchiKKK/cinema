package org.example;

import java.util.HashMap;
import java.util.Map;
import org.example.employees.EmployeesConsoleDriver;
import org.example.films.FilmsConsoleDriver;
import org.example.halls.HallsConsoleDriver;
import org.example.profiles.ProfilesConsoleDriver;
import org.example.seanses.SeansesConsoleDriver;
import org.example.shared.classes.ConsoleDriver;
import org.example.shared.utils.ConsoleReader;
import org.example.visitors.VisitorsConsoleDriver;

public class Main {
    private static Map<Integer, ConsoleDriver<?>> consoleDrivers = new HashMap<>();

    private static Integer exitCode = 0;

    public static void main(String[] args) {
        setupConsoleDrivers();

        while (true) {
            Integer choice = getNextChoice();

            if (choice == exitCode) {
                return;
            }

            ConsoleDriver<?> driver = consoleDrivers.get(choice);

            if (driver != null) {
                driver.start();
            }
        }
    }

    private static void setupConsoleDrivers() {
        consoleDrivers.put(1, new FilmsConsoleDriver());
        consoleDrivers.put(2, new SeansesConsoleDriver());
        consoleDrivers.put(3, new HallsConsoleDriver());
        consoleDrivers.put(4, new VisitorsConsoleDriver());
        consoleDrivers.put(5, new EmployeesConsoleDriver());
        consoleDrivers.put(6, new ProfilesConsoleDriver());
    }

    private static Integer getNextChoice() {
        System.out.println("1. Фильмы");
        System.out.println("2. Сеансы");
        System.out.println("3. Залы");
        System.out.println("4. Посетители");
        System.out.println("5. Сотрудники");
        System.out.println("6. Профили");
        System.out.println("0. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }
}