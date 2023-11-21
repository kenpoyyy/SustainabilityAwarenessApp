package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class ShoppingGuide extends AppCompatActivity implements SelectListener{

    /* Variable Declaration */
    ImageView backbtn_shopguide;
    RecyclerView recyclerView;
    List<ProductItem> productItems;
    ProductAdapter productAdapter;
    List<ProductInfo> productInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_guide);
        
        displayItem();

        /* Assignment Statement */
        backbtn_shopguide = (android.widget.ImageView) findViewById(R.id.backbtn_shopguide);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_shopguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomepage();
            }
        });
    }

    private void displayItem() {

        recyclerView=findViewById(R.id.product_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2,RecyclerView.VERTICAL,false));
        productItems=new ArrayList<>();
        //add in items
        productItems.add(new ProductItem("Bamboo Spoons","SustainableSG","28.90",R.drawable.bamboon_spoon));


        productAdapter=new ProductAdapter(this,this,productItems);
        recyclerView.setAdapter(productAdapter);

    }

    /* Method */
    public void openHomepage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent= new Intent(ShoppingGuide.this,ShoppingGuidePage2.class);

        intent.putExtra("NAME1",productInfo.get(position).getProductName1());
        intent.putExtra("NAME2",productInfo.get(position).getProductName2());
        intent.putExtra("PRICE1",productInfo.get(position).getPrice());
        intent.putExtra("PRICE2",productInfo.get(position).getPrice2());
        intent.putExtra("BRAND",productInfo.get(position).getBrand());
        intent.putExtra("DESCRIPTION1",productInfo.get(position).getDescription1());
        intent.putExtra("DESCRIPTION2",productInfo.get(position).getDescription2());
        intent.putExtra("IMAGE1",productInfo.get(position).getImage1());
        intent.putExtra("IMAGE2",productInfo.get(position).getImage2());
        intent.putExtra("BUTTON1",productInfo.get(position).getButton1());
        intent.putExtra("BUTTON2",productInfo.get(position).getButton2());
        intent.putExtra("REVIEW",productInfo.get(position).getReviews());
        intent.putExtra("RATING",productInfo.get(position).getRating());

        startActivity(intent);
    }


}