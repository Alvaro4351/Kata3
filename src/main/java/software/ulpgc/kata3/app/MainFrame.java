package software.ulpgc.kata3.app;

import software.ulpgc.kata3.architecture.control.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private final JFreeBarchartDisplay display;

    public MainFrame(){
        this.setTitle("Kata 3");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, menu());
        this.add(display = statisticpanel());
        commands = new HashMap<>();
    }

    private Component menu() {
        JPanel panel = new JPanel();
        panel.add(toogle());
        return panel;
    }

    private Component toogle() {
        JButton button = new JButton("toggle");
        button.addActionListener(e -> commands.get("toggle").execute());
        return button;
    }

    private JFreeBarchartDisplay statisticpanel() {
        return new JFreeBarchartDisplay();
    }

    public Command put(String key, Command value){
        return commands.put(key, value);
    }

    public JFreeBarchartDisplay getDisplay(){
        return display;
    }
}
