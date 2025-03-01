package org.example.profiles;

import org.example.shared.classes.ConsoleDriver;
import org.example.shared.utils.ConsoleReader;

public class ProfilesConsoleDriver extends ConsoleDriver<Profile> {
    public ProfilesConsoleDriver() {
        super.repository = new ProfilesRepository();
    }

    protected Integer getNextChoice() {
        System.out.println("1. Все профили");
        System.out.println("2. Создание профиля");
        System.out.println("3. Обновление профиля");
        System.out.println("4. Удаление профиля");
        System.out.println("0. Выход");

        ConsoleReader console = new ConsoleReader();
        return console.readInt("Выбор: ");
    }

    protected Profile input() {
        ConsoleReader console = new ConsoleReader();
        String email = console.readLine("Email: ");
        String password = console.readLine("Пароль: ");
        String role = console.readLine("Роль: ");

        return new Profile(email, password, role);
    }

    protected Long inputId() {
        ConsoleReader console = new ConsoleReader();
        return console.readLong("ID профиля: ");
    }
}
