import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grand Line Treasure Hunt - Final Submission");
        MapPanel panel = new MapPanel();
        
        JButton startBtn = new JButton("🏴‍☠️ Start Treasure Race");
        
        // This is the "bridge" between the button and your logic
        startBtn.addActionListener(e -> {
            System.out.println("Race button clicked! Checking logic...");
            panel.runRace();
        });

        frame.setLayout(new BorderLayout());
        frame.add(new JLabel(" Left Click: Add Node | Right Click: Options"), BorderLayout.SOUTH);
        frame.add(startBtn, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}