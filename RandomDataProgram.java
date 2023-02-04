package com.example.fileio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RandomDataProgram {

    public static void main(String[] args) throws InterruptedException {

        int count = 0;
        while (count < 10) {
            try {
                URL url = new URL("https://random-data-api.com/api/v2/users");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                int status = conn.getResponseCode();
                if (status != 200) {
                    throw new RuntimeException("HttpResponseCode: " + status);
                } else {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("users.csv", true));
                    Scanner sc = new Scanner(url.openStream());
                    String inline = "";
                    while (sc.hasNext()) {
                        inline += sc.nextLine();
                    }
                    bw.write(inline);
                    System.out.println("Data added to file");
                    bw.close();
                    sc.close();
                }
                Thread.sleep(1000);
                count++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}