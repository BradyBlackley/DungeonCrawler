package org.example;

import org.example.frames.DungeonCrawlerFrame;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DungeonCrawlerFrame frame = new DungeonCrawlerFrame();
            frame.setVisible(true);
        });
    }
}