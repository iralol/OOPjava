package lab9;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class clock {
    private int year;
    private int month;
    private int day;
    private int time;  // hour
    private int minute;
    private int second;
    private LocalDateTime ldt;
    private DateTimeFormatter formatter;

    public clock() {
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    //Manually set the clock time
    public void setClock(int y, int mon, int d, int t, int min, int s) {
        this.ldt = LocalDateTime.of(y, mon, d, t, min, s);
        updateFieldsFromLdt();
        System.out.println("Clock Manual Configured DateTime is: " + ldt.format(formatter));
    }

    //Auto set the clock to current system time
    public void autoSetClock() {
        this.ldt = LocalDateTime.now();
        updateFieldsFromLdt();
        System.out.println("Clock Auto Configured DateTime is: " + ldt.format(formatter));
    }

    //Tick the clock for 1000 seconds (default)

    public void tickClock() {
        tickClock(1000);
    }

    //Overloaded tick method - advance clock by specified number of seconds

    public void tickClock(int tick) {
        System.out.println("-- Ticking clock --");
        for (int i = 0; i < tick; i++) {
            // Advance time by 1 second
            ldt = ldt.plusSeconds(1);
            updateFieldsFromLdt();
            
            // Print current time
            System.out.println(ldt.format(formatter));
            
            // Simulate real-time passage (1 second delay)
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Tick interrupted");
                break;
            }
        }
    }

    /**
     * Helper method to sync private fields with LocalDateTime
     */
    private void updateFieldsFromLdt() {
        this.year = ldt.getYear();
        this.month = ldt.getMonthValue();
        this.day = ldt.getDayOfMonth();
        this.time = ldt.getHour();
        this.minute = ldt.getMinute();
        this.second = ldt.getSecond();
    }

    // Optional: Getters for encapsulation demonstration
    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }
    public int getHour() { return time; }
    public int getMinute() { return minute; }
    public int getSecond() { return second; }
}

