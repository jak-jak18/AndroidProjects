package com.example.android.pe1;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.graphics.drawable.LayerDrawable;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int bitmaps[]= {R.drawable.artist, R.drawable.pick, R.drawable.ic_launcher, R.drawable.up};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        artistpage();
        //new ServletPostAsyncTask().execute(new Pair<Context, String>(this, "jak jak"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void artistsearch(View view) {
        setContentView(R.layout.artist_search);
    }

    public void artistpage(){
        setContentView(R.layout.artist_page);
        Context context = getApplicationContext();

        LinearLayout course_display = (LinearLayout) findViewById(R.id.course_display);
        ImageView item;
        int len = bitmaps.length;
        for (int i = 0; i < len; ++i) {
            item = new ImageView(context);
            item.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            item.setLayoutParams(new ViewGroup.LayoutParams(150, 300));
            item.setPadding(5,0,5,0);
            item.setImageResource(bitmaps[i]);

            course_display.setPadding(20, 35, 35, 35);
//            course_display.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//            course_display.setDividerPadding(5);
            course_display.addView(item);
//            course_display.setLayoutParams(new ViewGroup.MarginLayoutParams(5,5).setMargins(5,5,5,5));
//            LayoutParams layoutParams = new LayoutParams(75, 150);
//            layoutParams.setMargins(5, 5, 5, 5);
//            course_display.setLayoutParams(layoutParams);
            //course_display.setLayoutParams(new FrameLayout.LayoutParams(75, 150));
        }

        //AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                //R.animator.property_animator);
        //Resources res = (Resources) getResources();
        //Drawable image = (Drawable) res.getDrawable(R.drawable.pick);
        //set.setTarget(image);
        //set.start();r
        String text = getString(R.string.artist_info);

        Drawable dIcon = getResources().getDrawable(R.drawable.pick);
        int leftMargin = dIcon.getIntrinsicWidth() + 10;

        ImageButton icon = (ImageButton) findViewById(R.id.imageButton6);

        SpannableString ss = new SpannableString(text);
        ss.setSpan(new MyLeadingMarginSpan2(3, leftMargin), 0, ss.length(), 0);

        TextView messageView = (TextView) findViewById(R.id.textView2);
        messageView.setText(ss);

        ImageView image = (ImageView) findViewById(R.id.imageButton6);
        Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
        image.startAnimation(hyperspaceJump);

    }

    //public void up(View view){
        //setContentView(R.layout.tester);
        //int newwidth;
        //Resources res = getResources();
        //GradientDrawable image = (GradientDrawable) res.getDrawable(R.drawable.outer_shape);
        //newwidth = image.getIntrinsicWidth() + 60;
        //image.setSize(newwidth,image.getIntrinsicHeight());
        //Resources res = getResources();
        //GradientDrawable shape = (GradientDrawable) res.getDrawable(R.drawable.outer_shape);
        //ImageView shape = (ImageView) findViewById(R.id.imageView2);
        //Animator set = AnimatorInflater.loadAnimator(this, R.animator.expand_right);
        //ObjectAnimator set = ObjectAnimator.ofInt(shape, "width", 80, 140);
        //set.setDuration(700);
        //set.setTarget(shape);
        //set.start();

        //ImageView image = (ImageView) findViewById(R.id.imageView2);
        //Animation expand_right_anim = AnimationUtils.loadAnimation(this, R.anim.expand_right_anim);
        //image.startAnimation(expand_right_anim);
    //}

    public void tester(View view){
        setContentView(R.layout.tester);
        ImageView view1 = (ImageView) findViewById(R.id.imageView2);
        Drawable new_image = (Drawable) getResources().getDrawable(R.drawable.up);
        view1.setImageDrawable(new_image);
        
        Resources res = getResources();
        GradientDrawable shape = (GradientDrawable) res.getDrawable(R.drawable.outer_shape);
        Animator set = AnimatorInflater.loadAnimator(this, R.animator.color_change);
        set.setTarget(shape);
        set.start();
    }

    public void up(View view){
        View bottom= findViewById(R.id.bottom);
        Animator setbottom = AnimatorInflater.loadAnimator(this, R.animator.expand_up);
        setbottom.setTarget(bottom);
        setbottom.start();

        View top= findViewById(R.id.top);
        Animator settop = AnimatorInflater.loadAnimator(this, R.animator.expand_down);
        settop.setTarget(top);
        settop.start();
    }

    public void down(View view){
        View top= findViewById(R.id.top);
        Animator settop = AnimatorInflater.loadAnimator(this, R.animator.expand_up);
        settop.setTarget(top);
        settop.start();

        View bottom= findViewById(R.id.bottom);
        Animator setbottom = AnimatorInflater.loadAnimator(this, R.animator.expand_down);
        setbottom.setTarget(bottom);
        setbottom.start();
    }

    public void expand_down(View Drawable){
        //int newwidth;
        //Resources res = getResources();
        //GradientDrawable image = (GradientDrawable) res.getDrawable(R.drawable.outer_shape);
       // newwidth = image.getIntrinsicWidth() + 60;
        //image.setSize(newwidth,image.getIntrinsicHeight());
        //image.setColor(0x804392FF);
        setContentView(R.layout.artist_page);
        //image.setGradientCenter(1,1);
        //setContentView(R.layout.tester);
        //LayerDrawable res = (LayerDrawable) getDrawable(R.drawable.testerdraw);
        //newwidth = res.findDrawableByLayerId(R.id.inner_shape).getIntrinsicWidth()+ 20;
        //image.setIntrinsicWidth(newwidth);
        //setContentView(R.layout.artist_page);

        //Drawable image = res.getDrawable(R.drawable.testerdraw);
        //Drawable image = getResources().getDrawable(R.drawable.testerdraw);
        //Drawable image = getResources().getDrawable(R.drawable.testerdraw).findDrawablebyLayerId(R.id.inner_shape);
        //Shape w = (Shape) findViewById(R.id.inner_shape);
        //Resources res = getResources();
        //LayerDrawable res = (LayerDrawable) getDrawable(R.drawable.testerdraw).findDrawableByLayerId(R.id.inner_shape);
        //R.id.inner_shape.putfloat(width);
    }

}
