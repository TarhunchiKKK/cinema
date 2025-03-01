package org.example.visitors;

import org.example.shared.classes.ConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class VisitorsConsoleDriver extends ConsoleDriver<Visitor> {
    public VisitorsConsoleDriver() {
        super.repository = new VisitorsRepository();
    }

    protected Integer getNextChoice() {
        System.out.println("1. Все посетители");
        System.out.println("2. Добавление посетителя");
        System.out.println("3. Обновление посетителя");
        System.out.println("4. Удаление посетителя");
        System.out.println("0. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    protected Visitor input() {
        ConsoleReader console = new ConsoleReader();
        String fio = console.readLine("ФИО: ");
        Integer age = console.readInt("Возраст: ");

        return new Visitor(fio, age);
    }

    protected Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID посетителя: ");
    }
}
