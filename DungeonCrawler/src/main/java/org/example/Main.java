package org.example;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        try {
            System.setProperty(
                    "freetts.voices",
                    "com.sun.speech.freetts.en.us"
                            + ".cmu_us_kal.KevinVoiceDirectory");

            Central.registerEngineCentral(
                    "com.sun.speech.freetts"
                            + ".jsapi.FreeTTSEngineCentral");

            Synthesizer synthesizer
                    = Central.createSynthesizer(
                    new SynthesizerModeDesc(Locale.US));

            synthesizer.allocate();

            synthesizer.resume();

            System.out.println("***************************");
            System.out.println("Welcome to Dungeon Crawler.");
            synthesizer.speakPlainText("Welcome to Dungeon Crawler.", null);
            System.out.println();

            Scenario scenario = Scenario.builder().build();
            scenario.generateAttributes();

            synthesizer.speakPlainText(scenario.describe(), null);

            System.out.println();
            System.out.println("Thank you for using Dungeon Crawler.");
            synthesizer.speakPlainText("Thank you for using Dungeon Crawler.", null);
            System.out.println("***************************");

            synthesizer.waitEngineState(
                    Synthesizer.QUEUE_EMPTY);

            synthesizer.deallocate();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
