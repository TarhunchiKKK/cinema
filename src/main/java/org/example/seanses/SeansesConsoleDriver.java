package org.example.seanses;

import java.util.Date;
import org.example.shared.classes.ConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class SeansesConsoleDriver extends ConsoleDriver<Seans> {
    public SeansesConsoleDriver() {
        super.repository = new SeansesRepository();
    }

    protected Integer getNextChoice() {
        System.out.println("1. Все сеансы");
        System.out.println("2. Добавление ссеанса");
        System.out.println("3. Обновление сеанса");
        System.out.println("4. Удаление сеанса");
        System.out.println("0. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    protected Seans input() {
        ConsoleReader console = new ConsoleReader();
        Date date = console.readDate("Дата показа(гггг-мм-дд): ");
        Float price = console.readFloat("Цена: ");
        Integer duration = console.readInt("Длительность(минуты): ");

        return new Seans(date, price, duration);
    }

    protected Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID сеанса: ");
    }
}
