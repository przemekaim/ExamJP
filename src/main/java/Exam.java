import java.util.*;

public class Exam {
    private final List<Word> splitWords;
    private static boolean hasTime;
    private String answer;
    private String word;

    public Exam(List<Word> splitWords) {
        this.splitWords = splitWords;
        menu();
    }

    private void menu() {
        System.out.println("Wybierz tryb gry: ");
        System.out.println("1. Survival\n2. Vs time\n3. Fixed amount of questions.\n0. Exit");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1 -> survival();
            case 2 -> vsTime();
            case 3 -> fixedAmount();
            case 0 -> System.exit(0);
            default -> {
                System.err.println("Bad argument");
                System.exit(1);
            }
        }
    }

    private void survival() {
        int lifes = 3;
        boolean hasLifes = true;
        Scanner scanner = new Scanner(System.in);

        while (hasLifes) {
            word = getRandomWord();
            answer = scanner.nextLine();

            if (checkAnswer(answer, word)) {
                System.out.println("Correct!");
            } else {
                lifes--;
                System.out.println("Wrong! You have left: " + lifes);
                System.out.println("Correct answer: " + word);
            }

            if (lifes == 0)
                hasLifes = false;
        }
        System.exit(0);
    }

    private void vsTime() {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        hasTime = true;

        Timer.startTimer();
        while (hasTime) {
            word = getRandomWord();
            answer = scanner.nextLine();
            if(checkAnswer(answer, word))
                correctAnswers++;
        }
        System.out.println("You've got " + correctAnswers + " correct answers.");
        System.exit(0);
    }

    private void fixedAmount() {
        List<String> randomWords = new ArrayList<>(10);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++)
            randomWords.add(getRandomWord());

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");

        for (int i = 0; i < randomWords.size(); i++) {
            System.out.println(randomWords.get(i));
            answer = scanner.nextLine();
            if (answer.equals("-"))
                i = i - 2;
        }

    }

    private String getRandomWord() {
        Random random = new Random();
        int language; // 0 = polish, 1 = japanese
        int randomWord;
        randomWord = random.nextInt(splitWords.size());
        Word word = splitWords.get(randomWord);
        language = random.nextInt(2);

        if (language == 0) {
            System.out.println(word.getPolishWord());
            return word.getJapaneseWord();
        }
        else {
            System.out.println(word.getJapaneseWord());
            return word.getPolishWord();
        }
    }

    private boolean checkAnswer(String answer, String word) {
        return answer.equals(word);
    }

    public static void setTimeEnd() {
        hasTime = false;
    }
}
