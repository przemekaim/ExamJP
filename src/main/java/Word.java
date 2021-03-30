public class Word {
    private final String polishWord;
    private final String japaneseWord;

    public Word(String polishWord, String japaneseWord) {
        this.polishWord = polishWord;
        this.japaneseWord = japaneseWord;
    }

    public String getPolishWord() {
        return polishWord;
    }

    public String getJapaneseWord() {
        return japaneseWord;
    }

}
