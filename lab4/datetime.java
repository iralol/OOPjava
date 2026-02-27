public class datetime {
    // ======================
    // Гишүүн өгөгдөл
    // ======================
    private int year;
    private int month;
    private int day;

    // ======================
    // Байгуулагч
    // ======================
    public datetime(String dt) {
        // 1919.05.21 | 1919/05/21 | 1919-05-21 зэргийг дэмжинэ
        String[] values = dt.split("[-./]");
        year = Integer.parseInt(values[0]);
        month = Integer.parseInt(values[1]);
        day = Integer.parseInt(values[2]);
    }

    // ======================
    // YearCode
    // ======================
    private int getyearcode(int year) {
        int y = year % 100;
        return (y + y / 4) % 7;
    }

    // ======================
    // MonthCode
    // ======================
    private int getmonthcode(int month) {
        switch (month) {
            case 1:  return 0; // January
            case 2:  return 3; // February
            case 3:  return 3; // March
            case 4:  return 6; // April
            case 5:  return 1; // May
            case 6:  return 4; // June
            case 7:  return 6; // July
            case 8:  return 2; // August
            case 9:  return 5; // September
            case 10: return 0; // October
            case 11: return 3; // November
            case 12: return 5; // December
            default: return 0;
        }
    }

    // ======================
    // CenturyCode
    // ======================
    private int getcenturycode(int century) {
        switch (century) {
            case 17: return 4;
            case 18: return 2;
            case 19: return 0;
            case 20: return 6;
            case 21: return 4;
            case 22: return 2;
            case 23: return 0;
            default: return 0;
        }
    }

    // ======================
    // LeapYearCode
    // ======================
    private int getleapyearcode(int year, int month) {
        boolean isLeap =
                (year % 4 == 0 && year % 100 != 0) ||
                (year % 400 == 0);

        if (isLeap && (month == 1 || month == 2)) {
            return 1;
        }
        return 0;
    }

    // ======================
    // DayOfWeek code (0–6)
    // ======================
    private int dayofweek() {
        int yearCode = getyearcode(year);
        int monthCode = getmonthcode(month);
        int centuryCode = getcenturycode(year / 100);
        int leapYearCode = getleapyearcode(year, month);

        return (yearCode + monthCode + centuryCode + day - leapYearCode) % 7;
    }

    // ======================
    // Гариг хэвлэх
    // ======================
    public void printdayofweek() {
        String[] days = {
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };

        int code = dayofweek();
        System.out.println(
                year + " onii " + month + "-r sariin " + day +
                " bol " + days[code]
        );
    }
}
