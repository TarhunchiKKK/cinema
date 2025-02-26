package org.example.halls;

import org.example.shared.interfaces.IConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class HallsConsoleDriver implements IConsoleDriver {
    private HallsRepository repository = new HallsRepository();

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
        System.out.println("1. Все залы");
        System.out.println("2. Добавление зала");
        System.out.println("3. Обновление зала");
        System.out.println("4. Удаление зала");
        System.out.println("5. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    private Hall input() {
        ConsoleReader console = new ConsoleReader();
        String type = console.readLine("Тип зала: ");
        Integer seatsCount = console.readInt("Количество мест: : ");
        return new Hall(this.defaultId, type, seatsCount);
    }

    private Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID зала: ");
    }

    private void handleCreate() {
        Hall hall = this.input();
        this.repository.create(hall);
    }

    private void handlePrint() {
        for (Hall hall : this.repository.findAll()) {
            System.out.println(hall);
        }
    }

    private void handleUpdate() {
        Long id = this.inputId();

        Hall employee = this.input();
        employee.setId(id);

        this.repository.update(employee);
    }

    private void handleDelete() {
        Long id = this.inputId();
        this.repository.delete(id);
    }
}
