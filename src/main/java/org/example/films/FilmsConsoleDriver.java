package org.example.films;

import org.example.shared.interfaces.IConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class FilmsConsoleDriver implements IConsoleDriver {
    private FilmsRepository repository = new FilmsRepository();

    private Long defaultId = 1l;

    public void start() {
        while (true) {
            switch (this.getNextChoice()) {
                case 1:
                    this.handlePrint();
                    break;
                case 2:
                    this.handleCreate();
                    break;
                case 3:
                    this.handleUpdate();
                    break;
                case 4:
                    this.handleDelete();
                    break;
                case 5:
                    return;
            }
        }
    }

    private Integer getNextChoice() {
        System.out.println("1. Все фильмы");
        System.out.println("2. Создание фильма");
        System.out.println("3. Обновление фильма");
        System.out.println("4. Удаление фильма");
        System.out.println("5. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    private Film input() {
        ConsoleReader console = new ConsoleReader();
        String title = console.readLine("Название: ");
        Integer year = console.readInt("Год выпуска: ");
        String country = console.readLine("Страна: ");

        return new Film(this.defaultId, title, year, country);
    }

    private Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID фильма: ");
    }

    private void handleCreate() {
        Film film = this.input();
        this.repository.create(film);
    }

    private void handlePrint() {
        for (Film film : this.repository.findAll()) {
            System.out.println(film);
        }
    }

    private void handleUpdate() {
        Long id = this.inputId();

        Film film = this.input();
        film.setId(id);

        this.repository.update(film);
    }

    private void handleDelete() {
        Long id = this.inputId();
        this.repository.delete(id);
    }
}
