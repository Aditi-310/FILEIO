package com.example.fileio;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GetUserDetails {
    public static void main(String[] args) {
        Scanner scanner = null;
        System.out.print("Enter user id or username: ");
        String input = new Scanner(System.in).nextLine();
        try {
            scanner = new Scanner(new FileReader("users.csv"));
            while (scanner.hasNextLine()) {
                String userData = scanner.nextLine();
                String[] user = userData.split(",");
                if (user[2].equals(input) || user[1].equals(input)) {
                    System.out.println("User Details: " + userData);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
