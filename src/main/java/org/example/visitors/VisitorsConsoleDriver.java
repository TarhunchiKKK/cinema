package org.example.visitors;

import org.example.shared.interfaces.IConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class VisitorsConsoleDriver implements IConsoleDriver {
    private VisitorsRepository repository = new VisitorsRepository();

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
        System.out.println("1. Все посетители");
        System.out.println("2. Добавление посетителя");
        System.out.println("3. Обновление посетителя");
        System.out.println("4. Удаление посетителя");
        System.out.println("5. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    private Visitor input() {
        ConsoleReader console = new ConsoleReader();
        String fio = console.readLine("ФИО: ");
        Integer age = console.readInt("Возраст: ");

        return new Visitor(this.defaultId, fio, age);
    }

    private Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID посетителя: ");
    }

    private void handleCreate() {
        Visitor visitor = this.input();
        this.repository.create(visitor);
    }

    private void handlePrint() {
        for (Visitor visitor : this.repository.findAll()) {
            System.out.println(visitor);
        }
    }

    private void handleUpdate() {
        Long id = this.inputId();

        Visitor visitor = this.input();
        visitor.setId(id);

        this.repository.update(visitor);
    }

    private void handleDelete() {
        Long id = this.inputId();
        this.repository.delete(id);
    }
}
