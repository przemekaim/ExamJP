import java.util.*;
import java.util.stream.Collectors;

public class Spliterator {
    public static List<Word> split(List<String> stringToSplit) {
        return stringToSplit.stream()
                .map(s -> s.split("\\t+"))
                .peek(Spliterator::checkFormat)
                .map(s -> new Word(s[0], s[1]))
                .collect(Collectors.toList());
    }

    private static void checkFormat(String[] tokens) {
        if (tokens.length != 2)
            throw new IllegalArgumentException("Each polish and japanese word should be separated with tab and new line at the end.");
    }
}