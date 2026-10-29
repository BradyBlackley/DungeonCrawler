package org.example.frames;

import org.example.Scenario;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.Objects;

public class DungeonCrawlerFrame extends JFrame {

    private final JTextArea storyArea;
    private Synthesizer synthesizer;
    private final JCheckBox ttsEnabled;

    public DungeonCrawlerFrame() {
        setTitle("Dungeon Crawler");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/dungeon-crawler-icon.png"))
        );
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        ttsEnabled = new JCheckBox("Enable Text-to-Speech");
        ttsEnabled.setSelected(false);
        JPanel topPanel = new JPanel();

        JButton generateButton = new JButton("Generate Story");

        storyArea = new JTextArea();
        storyArea.setEditable(false);
        storyArea.setLineWrap(true);
        storyArea.setWrapStyleWord(true);

        topPanel.add(generateButton);
        topPanel.add(ttsEnabled);

        JScrollPane scrollPane = new JScrollPane(storyArea);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(generateButton, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        initializeTTS();

        generateButton.addActionListener(e -> generateStory());
    }

    private void initializeTTS() {
        try {
            System.setProperty(
                    "freetts.voices",
                    "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory"
            );

            Central.registerEngineCentral(
                    "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral"
            );

            synthesizer = Central.createSynthesizer(
                    new SynthesizerModeDesc(Locale.US)
            );

            synthesizer.allocate();
            synthesizer.resume();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Failed to initialize FreeTTS: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void generateStory() {
        try {
            Scenario scenario = Scenario.builder().build();
            scenario.generateAttributes();

            String story = scenario.describe();

            storyArea.setText(story);

            if (ttsEnabled.isSelected() && synthesizer != null) {
                synthesizer.speakPlainText(story, null);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}