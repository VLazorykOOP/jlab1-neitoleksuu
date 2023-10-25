
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarProgram {
    public static String findDayOfWeek(int day, int month, int year) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = String.format("%02d-%02d-%04d", day, month, year);
        try {
            Date date = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

            return daysOfWeek[dayOfWeek];
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findDayOfMonth(int day, int month, int year) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        if (day > 0 && day <= 31 && month > 0 && month <= 12) {
            if (day <= getDaysInMonth(month, year)) {
                return String.format("%d %s, %04d", day, monthNames[month - 1], year);
            }
        }
        return null;
    }

    private static int getDaysInMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) {
        int day = 32;
        int month = 2; // February
        int year = 2002;

        String dayOfWeekResult = findDayOfWeek(day, month, year);
        String dayOfMonthResult = findDayOfMonth(day, month, year);

        System.out.println("For the input: " + day + "/" + month + "/" + year);
        System.out.println("Day of the week: " + dayOfWeekResult);
        System.out.println("Day of the month: " + dayOfMonthResult);
    }
}
