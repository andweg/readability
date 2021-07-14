package readability;

public class Scores {

    static int[] ages = {6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 24, 25};

    static double calculateARI(Stats textStats) {
        double score = 4.71 * textStats.characters / textStats.words
                + 0.5 * textStats.words / textStats.sentences - 21.43;
        int age = calculateAge(score);
        System.out.printf("Automated Readability Index: %.2f (about %d-year-olds).%n", score, age);
        return score;
    }

    static double calculateFK(Stats textStats) {
        double score = 0.39 * textStats.words / textStats.sentences
                + 11.8 * textStats.syllables / textStats.words - 15.59;
        int age = calculateAge(score);
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).%n", score, age);
        return score;
    }

    static double calculateSMOG(Stats textStats) {
        double score = 1.043 *  Math.sqrt(((double) textStats.polysyllables * 30 / (double) textStats.sentences))
                + 3.1291;
        int age = calculateAge(score);
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d-year-olds).%n", score, age);
        return score;
    }

    static double calculateCL(Stats textStats) {
        double score = 0.0588 * textStats.characters / textStats.words * 100
                - 0.296 * textStats.sentences / textStats.words * 100 - 15.8;
        int age = calculateAge(score);
        System.out.printf("Coleman–Liau index: %.2f (about %d-year-olds).%n", score, age);
        return score;
    }

    static int calculateAge(double score) {
        return ages[Math.min(14, Math.max(1, (int) Math.ceil(score))) - 1];
    }
}
