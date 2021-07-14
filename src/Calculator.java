package readability;

import java.util.Scanner;

public class Calculator {

    private Stats textStats;

    Calculator(Stats textStats) {
        this.textStats = textStats;
    }

    public void analyze() {
        printStats();
        calculateScores(readApproach());
    }

    private void printStats() {
        System.out.println("\nThe text is:\n" + textStats.text +
                "\nWords: " + textStats.words +
                "\nSentences: " + textStats.sentences +
                "\nCharacters: " + textStats.characters +
                "\nSyllables: " + textStats.syllables +
                "\nPolysyllables: " + textStats.polysyllables);
    }

    private String readApproach() {
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        return new Scanner(System.in).next().toUpperCase();
    }

    private void calculateScores(String approach) {
        switch (approach) {
            case ("ARI"):
                Scores.calculateARI(textStats);
                break;
            case ("FK"):
                Scores.calculateFK(textStats);
                break;
            case ("SMOG"):
                Scores.calculateSMOG(textStats);
                break;
            case ("CL"):
                Scores.calculateCL(textStats);
                break;
            case ("ALL"):
                System.out.printf("%nThis text should be understood in average by %.2f-year-olds.%n",
                        (double) Scores.calculateAge(Scores.calculateARI(textStats))
                                + Scores.calculateAge(Scores.calculateFK(textStats))
                                + Scores.calculateAge(Scores.calculateSMOG(textStats))
                                + Scores.calculateAge(Scores.calculateCL(textStats))
                                / 4);
                break;
            default:
                calculateScores(readApproach());
        }
    }
}
