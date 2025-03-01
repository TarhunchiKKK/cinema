package org.example.shared.classes;

import org.example.shared.interfaces.IHaveId;
import org.example.shared.interfaces.IPrintable;
import org.example.shared.interfaces.IRepository;

public abstract class ConsoleDriver<T extends IPrintable & IHaveId> {
    protected IRepository<T> repository;

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
                case 0:
                    return;
            }
        }
    }

    protected abstract Integer getNextChoice();

    protected abstract T input();

    protected abstract Long inputId();

    private void handleCreate() {
        T entity = this.input();
        this.repository.create(entity);
    }

    private void handlePrint() {
        for (T entity : this.repository.findAll()) {
            entity.print();
        }
    }

    private void handleUpdate() {
        Long id = this.inputId();

        T entity = this.input();
        entity.setId(id);

        this.repository.update(entity);
    }

    private void handleDelete() {
        Long id = this.inputId();
        this.repository.delete(id);
    }
}
