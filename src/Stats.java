package readability;

public class Stats {

    String text;
    String[] wordsInText;
    long characters;
    long words;
    long sentences;
    long syllables;
    long polysyllables;

    public Stats(String text) {
        this.text = text;
        wordsInText = text.split("\\s+");
        characters = text.replaceAll("[\\s+]", "").length();
        words = wordsInText.length;
        sentences = text.split("[.!?]+").length;
        countSyllables(wordsInText);
    }

    private void countSyllables(String[] words) {
        for (String word : wordsInText) {
            long syllablesInWordCount = Math.max(1, word.toLowerCase()
                    .replaceAll("e$", "")
                    .replaceAll("[aeiouy]{2,}", "a")
                    .replaceAll("[^aeiouy]", "")
                    .length());
            if (syllablesInWordCount > 2) {
                polysyllables++;
            }
            syllables += syllablesInWordCount;
        }
    }
}