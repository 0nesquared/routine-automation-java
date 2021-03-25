package AllTasks;

import java.util.Date;

public class TimerThread extends Thread {

    DigitalClock dc;
    String time;

    public TimerThread(DigitalClock dc) {
        this.dc = dc;

        // starting the timer
        start();
    }

    public void run() {
        // updating the timer info
        while(true) {
            time = new Date().toString();
            this.dc.clockInfo.setText(time);
        }
    }

}
