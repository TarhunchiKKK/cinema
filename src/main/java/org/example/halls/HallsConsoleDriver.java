package org.example.halls;

import org.example.shared.classes.ConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class HallsConsoleDriver extends ConsoleDriver<Hall> {
    public HallsConsoleDriver() {
        super.repository = new HallsRepository();
    }

    protected Integer getNextChoice() {
        System.out.println("1. Все залы");
        System.out.println("2. Добавление зала");
        System.out.println("3. Обновление зала");
        System.out.println("4. Удаление зала");
        System.out.println("0. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    protected Hall input() {
        ConsoleReader console = new ConsoleReader();
        String type = console.readLine("Тип зала: ");
        Integer seatsCount = console.readInt("Количество мест: : ");
        return new Hall(type, seatsCount);
    }

    protected Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID зала: ");
    }
}
