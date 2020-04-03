package com.expenses.category;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Category implements Products {

    @Override
    public Double selectProduct(String category, String option) {
        Map<String, Map<DayOfWeek, Double>> Paper = new HashMap<>();

        YearMonth month = YearMonth.of(2020, 4);
        Double totalPrice = 0.0;
        Double PricePerpaper = 0.0;

        TOI.put(DayOfWeek.MONDAY, 3.0);
        TOI.put(DayOfWeek.TUESDAY, 3.0);
        TOI.put(DayOfWeek.WEDNESDAY, 3.0);
        TOI.put(DayOfWeek.THURSDAY, 3.0);
        TOI.put(DayOfWeek.FRIDAY, 3.0);
        TOI.put(DayOfWeek.SATURDAY, 5.0);
        TOI.put(DayOfWeek.SUNDAY, 6.0);

        Hindu.put(DayOfWeek.MONDAY, 2.5);
        Hindu.put(DayOfWeek.TUESDAY, 2.5);
        Hindu.put(DayOfWeek.WEDNESDAY, 2.5);
        Hindu.put(DayOfWeek.THURSDAY, 2.5);
        Hindu.put(DayOfWeek.FRIDAY, 2.5);
        Hindu.put(DayOfWeek.SATURDAY, 4.0);
        Hindu.put(DayOfWeek.SUNDAY, 4.0);

        ET.put(DayOfWeek.MONDAY, 2.0);
        ET.put(DayOfWeek.TUESDAY, 2.0);
        ET.put(DayOfWeek.WEDNESDAY, 2.0);
        ET.put(DayOfWeek.THURSDAY, 2.0);
        ET.put(DayOfWeek.FRIDAY, 2.0);
        ET.put(DayOfWeek.SATURDAY, 2.0);
        ET.put(DayOfWeek.SUNDAY, 10.0);

        BM.put(DayOfWeek.MONDAY, 1.5);
        BM.put(DayOfWeek.TUESDAY, 1.5);
        BM.put(DayOfWeek.WEDNESDAY, 1.5);
        BM.put(DayOfWeek.THURSDAY, 1.5);
        BM.put(DayOfWeek.FRIDAY, 1.5);
        BM.put(DayOfWeek.SATURDAY, 1.5);
        BM.put(DayOfWeek.SUNDAY, 1.5);

        HT.put(DayOfWeek.MONDAY, 2.0);
        HT.put(DayOfWeek.TUESDAY, 2.0);
        HT.put(DayOfWeek.WEDNESDAY, 2.0);
        HT.put(DayOfWeek.THURSDAY, 2.0);
        HT.put(DayOfWeek.FRIDAY, 2.0);
        HT.put(DayOfWeek.SATURDAY, 4.0);
        HT.put(DayOfWeek.SUNDAY, 4.0);

        List<String> paperName = Arrays.asList(option.split(","));
        for (String paper : paperName) {
            switch (paper) {
                case "TOI":
                    Paper.put("TOI", TOI);
                    break;
                case "Hindu":
                    Paper.put("Hindu", Hindu);
                    break;
                case "ET":
                    Paper.put("ET", ET);
                    break;
                case "BM":
                    Paper.put("BM", BM);
                    break;
                case "HT":
                    Paper.put("HT", HT);
                    break;
                default:
                    System.out.println("********* Invalid Newspaper name: "+ paper);
            }
        }
        for (Map.Entry<String, Map<DayOfWeek, Double>> papers : Paper.entrySet()) {
            for (Map.Entry<DayOfWeek, Double> mapPaperValue : papers.getValue().entrySet()) {
                LocalDate date = month.atDay(1).with(TemporalAdjusters.nextOrSame(mapPaperValue.getKey()));
                totalPrice = totalPrice + ((ChronoUnit.WEEKS.between(date, month.atEndOfMonth()) + 1) * mapPaperValue.getValue());
            }
            System.out.println("Total Monthly price for " + papers.getKey() + " :   " + totalPrice);
            System.out.println("**************************************************************************************");
            PricePerpaper = PricePerpaper + totalPrice;
            totalPrice = 0.0;
        }
        System.out.println("TotalPrice: " + PricePerpaper);
        return totalPrice;
    }
}







