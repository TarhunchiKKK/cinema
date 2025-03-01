package org.example.employees;

import org.example.shared.classes.ConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class EmployeesConsoleDriver extends ConsoleDriver<Employee> {
    public EmployeesConsoleDriver() {
        super.repository = new EmployeesRepository();
    }

    protected Integer getNextChoice() {
        System.out.println("1. Все сотрудники");
        System.out.println("2. Добавление сотрудника");
        System.out.println("3. Обновление сотрудника");
        System.out.println("4. Удаление сотрудника");
        System.out.println("0. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    protected Employee input() {
        ConsoleReader console = new ConsoleReader();
        String fio = console.readLine("ФИО: ");
        String post = console.readLine("Должность: ");
        Float experience = console.readFloat("Опыт: ");

        return new Employee(fio, post, experience);
    }

    protected Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID сотрудника: ");
    }
}
