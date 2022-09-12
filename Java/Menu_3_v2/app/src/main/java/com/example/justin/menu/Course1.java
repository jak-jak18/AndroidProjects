package com.example.justin.menu;

/**
 * Created by Justin on 7/15/2015.
 */
public class Course1 {

    public String course;
    public int image0;
    public int image1;
    public int image2;

    public Course1(String course, int image0, int image1, int image2){
        this.course = course;
        this.image0 = image0;
        this.image1 = image1;
        this.image2 = image2;
    }

    public static final Course1[] COURSE1 = {
            new Course1("Variation 1", R.mipmap.salad, R.mipmap.soup, R.mipmap.sandwich),
            new Course1("Variation 2", R.mipmap.sandwich, R.mipmap.pizza, R.mipmap.pie),
            new Course1("Variation 3", R.mipmap.pie, R.mipmap.salad, R.mipmap.pizza),
    };

}
