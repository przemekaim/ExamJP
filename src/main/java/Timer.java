import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Timer {
    public static void startTimer() {
        Runnable runnable = Exam::setTimeEnd;

        Executors.newSingleThreadScheduledExecutor().schedule(
                runnable, 30, TimeUnit.SECONDS);
    }
}
//https://stackoverflow.com/questions/5710911/i-want-to-implement-a-timer-for-a-game-java
//https://stackoverflow.com/questions/14393423/how-to-make-a-countdown-timer-in-java
//https://stackoverflow.com/questions/25296718/repeat-an-action-every-2-seconds-in-java/25296852