import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> fileContent = Reader.read();
        List<Word> splitWords;
        if (fileContent != null) {
            splitWords = Spliterator.split(fileContent);
            Exam exam = new Exam(splitWords);
            exam.menu();
        }
    }
}
