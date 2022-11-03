package ru.mkim.sleep;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : medvezhonokok
 * @mailto : nocap239@gmail.com
 * @created : 03.11.2022, четверг
 **/
public class RunScript {
    private final static String PATH = "your_path_to_sleep.sh ";

    public static void run(String count, JTextField textField) {
        try {
            String command = PATH + count.replace("Enter count of min-s to sleep: ", "").replace(" ", "");
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream())
            );
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            StringBuilder text = new StringBuilder();
            while (reader.ready()) {
                text.append(reader.readLine()).append("\n");
            }

            textField.setText(String.valueOf(text));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
