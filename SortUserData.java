package com.example.fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortUserData {
    public static void main(String[] args) {
        Scanner scanner = null;
        List<String> users = new ArrayList<>();
        try{
            scanner = new Scanner(new FileReader("users.csv"));
            while(scanner.hasNextLine()){
                String userData = scanner.nextLine();
                users.add(userData);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }
        // Sort the users data based on the firstName
        Collections.sort(users, (str1,str2) -> {
            String[] user1 = str1.split(",");
            String[] user2 = str2.split(",");
            return user1[0].compareTo(user2[0]);
        });
        // Write the sorted users data to users-sorted.csv
        try {
            FileWriter writer = new FileWriter("users-sorted.csv");
            for(String user : users){
                writer.write(user);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}