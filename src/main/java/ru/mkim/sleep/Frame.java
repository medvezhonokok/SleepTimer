package ru.mkim.sleep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : medvezhonokok
 * @mailto : nocap239@gmail.com
 * @created : 03.11.2022, четверг
 **/
public class Frame extends JFrame implements ActionListener {
    public static JTextField textField;

    public Frame(String title) throws HeadlessException {
        super(title);
        init();
        add(textField);
        getContentPane().setBackground(new Color(0, 82, 0));
        setLayout(null);
        setSize(440, 80);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        textField = new JTextField();
        textField.setBounds(10, 10, 420, 30);
        textField.addActionListener(this);
        textField.setText("Enter count of min-s to sleep: ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == textField) {
            RunScript.run(textField.getText(), textField);
            Timer timer = new Timer(2000, e1 -> dispose());
            timer.start();
        }
    }
}
