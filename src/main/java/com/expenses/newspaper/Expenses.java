package com.expenses.newspaper;

import com.expenses.category.Category;

public class Expenses {

    Category category = new Category();
    public  void totalExpense(String NewsPapaer,String paperName){
        category.selectProduct(NewsPapaer,paperName);

    }
    public static  void main(String args[]){
        Expenses exp = new Expenses();
        System.out.println("Select the category and product");
        exp.totalExpense("NewsPapaer","VK,HT,TOI");
    }


}
