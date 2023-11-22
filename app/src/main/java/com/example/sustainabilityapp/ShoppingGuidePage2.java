package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

public class ShoppingGuidePage2 extends AppCompatActivity {

    /* Variable Declaration */
    private ImageView backbtn_shopguide2;

    private List<ProductInfo> productList;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_guide_page2);


        //add product
        addProductItem();

        //set values
        inputValue();

        /* Assignment Statement */
        backbtn_shopguide2 = (android.widget.ImageView) findViewById(R.id.backbtn_shopguide2);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_shopguide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShopGuide();
            }
        });
    }



    private void inputValue() {

        TextView productName1=findViewById(R.id.itemName);
        TextView productName2=findViewById(R.id.textView19);
        TextView price=findViewById(R.id.productDetails1);
        TextView brand=findViewById(R.id.productDetails2);
        TextView description1=findViewById(R.id.productcontent1);
        TextView description2=findViewById(R.id.productcontent2);
        TextView price2=findViewById(R.id.textView30);
        TextView reviews=findViewById(R.id.customerReview);
        ImageView image1=findViewById(R.id.imageView45);
        ImageView image2=findViewById(R.id.imageView46);
        Button button1=findViewById(R.id.buybtn1);
        Button button2=findViewById(R.id.signUpbtn1);
        RatingBar rating=findViewById(R.id.customerRating);


        productName1.setText(Objects.requireNonNull(getIntent().getStringExtra("NAME1")));
        productName2.setText(Objects.requireNonNull(getIntent().getStringExtra("NAME2")));
        price.setText(Objects.requireNonNull(getIntent().getStringExtra("PRICE1")));
        price2.setText(Objects.requireNonNull(getIntent().getStringExtra("PRICE2")));
        brand.setText(getIntent().getStringExtra("BRAND"));
        description1.setText(getIntent().getStringExtra("DESCRIPTION1"));
        description2.setText(getIntent().getStringExtra("DESCRIPTION2"));
        int IMAGE1 = getIntent().getIntExtra("IMAGE1", 0);
        image1.setImageAlpha(IMAGE1);
        int IMAGE2 =getIntent().getIntExtra("IMAGE2",0);
        image2.setImageAlpha(IMAGE2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // get the URL
                    String url = getIntent().getStringExtra("BUTTON1");

                    // Create an Intent with ACTION_VIEW and the URL
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                    // Start the activity with the Intent
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // get the URL
                    String url =getIntent().getStringExtra("BUTTON2");

                    // Create an Intent with ACTION_VIEW and the URL
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                    // Start the activity with the Intent
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        reviews.setText(getIntent().getStringExtra("REVIEW"));
        rating.getRating();

    }


    private void addProductItem() {
        ProductInfo product1=new ProductInfo("Bamboo Spoon","28.9 SGD","SustainableSG","Made from bamboo, a natural and renewable source, these eco-friendly and reusable spoons will bring you a step closer towards a more sustainable Singapore and a more environmentally responsible you!","Not only are these spoons made to last, they are wax-free and uncoated to keep your food away from unpleasant odours and harmful toxins. Dish out delicious meals for your loved ones while saving the environment, one stir at a time.",
                "Wood Spoon","2200 JPY"," Bamboo spoons are a sustainable choice, as bamboo grows rapidly and requires minimal resources. This makes them an eco-friendly alternative to plastic or metal utensils. Their biodegradability also ensures a lower environmental impact, contributing positively to efforts in reducing waste and promoting sustainable living practices.","https://sustainablesg.com/products/across-the-land-bamboo-spoons","https://sustainablesg.com/products/across-the-land-bamboo-spoons",R.drawable.bamboon_spoon,R.drawable.wood_spoon,4);


        productList.add(product1);
    }



    /* Method */
    public void openShopGuide() {
        Intent intent = new Intent(this, ShoppingGuide.class);
        startActivity(intent);
    }
}