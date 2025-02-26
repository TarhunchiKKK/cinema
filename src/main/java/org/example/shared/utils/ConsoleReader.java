package org.example.shared.utils;

import java.util.Date;
import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner = new Scanner(System.in);

    private void printMessage(String message) {
        System.out.print(message);
    }

    public Integer readInt(String message) {
        this.printMessage(message);
        return Integer.parseInt(this.scanner.nextLine());
    }

    public Long readLong(String message) {
        this.printMessage(message);
        return Long.parseLong(this.scanner.nextLine());
    }

    public Float readFloat(String message) {
        this.printMessage(message);
        return Float.parseFloat(this.scanner.nextLine());
    }

    public String readLine(String message) {
        this.printMessage(message);
        return this.scanner.nextLine();
    }

    public Date readDate(String message) {
        this.printMessage(message);
        String input = this.scanner.nextLine();
        String[] parts = input.split("-");
        return new Date(Integer.parseInt(parts[2]) - 1900, Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[0]));
    }
}
