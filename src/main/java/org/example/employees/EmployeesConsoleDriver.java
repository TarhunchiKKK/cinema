package org.example.employees;

import org.example.shared.interfaces.IConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class EmployeesConsoleDriver implements IConsoleDriver {
    private EmployeesRepository repository = new EmployeesRepository();

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
        System.out.println("1. Все сотрудники");
        System.out.println("2. Добавление сотрудника");
        System.out.println("3. Обновление сотрудника");
        System.out.println("4. Удаление сотрудника");
        System.out.println("5. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    private Employee input() {
        ConsoleReader console = new ConsoleReader();
        String fio = console.readLine("ФИО: ");
        String post = console.readLine("Должность: ");
        Float experience = console.readFloat("Опыт: ");

        return new Employee(this.defaultId, fio, post, experience);
    }

    private Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID сотрудника: ");
    }

    private void handleCreate() {
        Employee employee = this.input();
        this.repository.create(employee);
    }

    private void handlePrint() {
        for (Employee employee : this.repository.findAll()) {
            System.out.println(employee);
        }
    }

    private void handleUpdate() {
        Long id = this.inputId();

        Employee employee = this.input();
        employee.setId(id);

        this.repository.update(employee);
    }

    private void handleDelete() {
        Long id = this.inputId();
        this.repository.delete(id);
    }
}
