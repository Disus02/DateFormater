package ru.sapteh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Program {
    public static void main(String[] args) throws IOException, ParseException {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        Date date=calendar.getTime();

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату экзамена: ");
        String strDateExz= buffer.readLine();

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dateExz=dateFormat.parse(strDateExz);

        int quantityDay = (int)((dateExz.getTime()-date.getTime())/1000/24/60/60);

        String result = switch (dateExz.compareTo(date)){
            case 0 -> "Сегодня экзамен";
            case 1 -> "До экзамена осталось " + quantityDay + addStr(quantityDay);
            case -1 -> "Экзамен был " + Math.abs(quantityDay) + addStr(quantityDay) + " назад";
            default -> "Not input";
        };
        System.out.println(result);
    }

    public static String addStr(int quantityDay){
        quantityDay=quantityDay % 10;
        return switch (Math.abs(quantityDay)) {
            case 1 -> " день";
            case 2, 3, 4 -> " дня";
            default -> " дней";
        };
    }
}
