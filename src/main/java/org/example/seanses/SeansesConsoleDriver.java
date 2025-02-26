package org.example.seanses;

import java.util.Date;
import org.example.shared.interfaces.IConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class SeansesConsoleDriver implements IConsoleDriver {
    private SeansesRepository repository = new SeansesRepository();

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
        System.out.println("1. Все сеансы");
        System.out.println("2. Добавление ссеанса");
        System.out.println("3. Обновление сеанса");
        System.out.println("4. Удаление сеанса");
        System.out.println("5. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    private Seans input() {
        ConsoleReader console = new ConsoleReader();
        Date date = console.readDate("Дата показа(гггг-мм-дд): ");
        Float price = console.readFloat("Цена: ");
        Integer duration = console.readInt("Длительность(минуты): ");

        return new Seans(this.defaultId, date, price, duration);
    }

    private Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID сеанса: ");
    }

    private void handleCreate() {
        Seans seans = this.input();
        this.repository.create(seans);
    }

    private void handlePrint() {
        for (Seans seans : this.repository.findAll()) {
            System.out.println(seans);
        }
    }

    private void handleUpdate() {
        Long id = this.inputId();

        Seans seans = this.input();
        seans.setId(id);

        this.repository.update(seans);
    }

    private void handleDelete() {
        Long id = this.inputId();
        this.repository.delete(id);
    }
}
