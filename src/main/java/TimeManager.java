import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Аглиуллины on 11.09.2017.
 */
public class TimeManager {

    public static void putInterval() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("put");
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<5;i++)
        putInterval();

    }
    }


