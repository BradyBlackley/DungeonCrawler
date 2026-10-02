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
            System.out.println();

            System.out.println("Describing creatures:");
            int loop = 0;
            while(loop < 5) {
                Creature creature = Creature.builder().build();
                creature.generateAttributes();
                System.out.println(creature.describe());
                synthesizer.speakPlainText(
                        creature.describe(), null);
                loop++;
            }

            System.out.println();
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
