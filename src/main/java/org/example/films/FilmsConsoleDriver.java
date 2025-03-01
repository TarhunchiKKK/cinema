package org.example.films;

import org.example.shared.classes.ConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class FilmsConsoleDriver extends ConsoleDriver<Film> {
    public FilmsConsoleDriver() {
        super.repository = new FilmsRepository();
    }

    protected Integer getNextChoice() {
        System.out.println("1. Все фильмы");
        System.out.println("2. Создание фильма");
        System.out.println("3. Обновление фильма");
        System.out.println("4. Удаление фильма");
        System.out.println("0. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    protected Film input() {
        ConsoleReader console = new ConsoleReader();
        String title = console.readLine("Название: ");
        Integer year = console.readInt("Год выпуска: ");
        String country = console.readLine("Страна: ");

        return new Film(title, year, country);
    }

    protected Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID фильма: ");
    }
}
