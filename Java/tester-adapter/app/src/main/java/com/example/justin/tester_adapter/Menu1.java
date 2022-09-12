package com.example.justin.tester_adapter;

/**
 * Created by Justin on 10/24/2015.
 */
public class Menu1 {

    public String course;
    public String course_items [][];

    public Menu1(String course, String course_items[][]){
        this.course = course;
        this.course_items = course_items;
    }

    static String course1 = "Sandwich";
    static public String course_items1 [][]= {
            {"Turkey Sandwich", "The best sandwich I make", "Whole wheat bread, turkey, swiss cheese, mayo, grey poupon"},
            {"Bread Basket Corned Beef Sandwich", "The best sandwich ever", "Rye bread, Corned Beef, thousand islands dressing, cole slaw"},
    };

    static String course2 = "Soup";
    static public String course_items2[][] ={
            {"Tomato Soup", "Homemade tomato soup with fresh tomato and cream", "Tomatoes, vegetable broth, cream, assorted spices"},
            {"New England Clam Chowder", "Could compete with the chowder made in Boston", "Cream based, assorted vegetables, potatoes, clam meat"}

    };

    public static final Menu1 menu1[] ={
            new Menu1(course1, course_items1),
            new Menu1(course2, course_items2),
            new Menu1(course1, course_items1),
            new Menu1(course2, course_items2),
    };

}
