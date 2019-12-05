package life.lsx.mycommunity.model;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @ClassName LocalDateTest
 * @Description TODO
 * @Author lsx
 * @Date 2019/12/5 16:41
 * @Version 1.0
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.parse("2019/11/02",DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("LocalDate.now(): "+localDate);
        int year = localDate.getYear();
        System.out.println("localDate.getYear(): "+year);
        LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime.now(): "+localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime.now(): "+localDateTime);
        System.out.println("LocalDate.parse(\"2019/11/02\",DateTimeFormatter.ofPattern(\"yyyy/MM/dd\")): "+localDate1);
        Instant instant = Instant.now();
        System.out.println("Instant.now(): "+instant);
        Duration threeMinutes = Duration.ofMinutes(3);
        System.out.println("Duration.ofMinutes(3): "+threeMinutes);
        threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println("Duration.of(3, ChronoUnit.MINUTES): "+threeMinutes);
        Period tenDays = Period.ofDays(10);
        System.out.println("Period.ofDays(10): "+tenDays);
        Period threeWeeks = Period.ofWeeks(3);
        System.out.println("Period.ofWeeks(3): "+threeWeeks);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        System.out.println("Period.of(2, 6, 1): "+twoYearsSixMonthsOneDay);

        LocalDate s=LocalDate.of(1985,03,05);
        LocalDate now =LocalDate.now();
        Period be=Period.between(s,now);
        System.out.println(be.getYears());
        System.out.println(be.getMonths());
        System.out.println(be.getDays());
    }
}
