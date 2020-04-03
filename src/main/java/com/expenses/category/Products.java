package com.expenses.category;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public interface Products {
    public Double selectProduct (String category,String option);
    Map<DayOfWeek, Double> TOI = new HashMap<>();
    Map<DayOfWeek, Double> Hindu = new HashMap<>();
    Map<DayOfWeek, Double> ET = new HashMap<>();
    Map<DayOfWeek, Double> BM = new HashMap<>();
    Map<DayOfWeek, Double> HT = new HashMap<>();

}
