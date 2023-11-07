package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Article3 extends AppCompatActivity {

    /* Variable Declaration */
    TextView article3Content;
    TextView article3Citation;
    private ImageView backbtn_article3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article3);

        /* Assignment Statement */
        article3Content = findViewById(R.id.article3content);
        article3Citation = findViewById(R.id.article3citation);
        backbtn_article3 = (android.widget.ImageView) findViewById(R.id.backbtn_article3);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_article3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArticlePage();
            }
        });

        /* String Contents "used for TextViews" */
        String content = "“Conservation genomics” encompasses the idea that genome-scale data will improve the capacity of resource managers to protect species."
                + "\n\n" + "Although genetic approaches have long been used in conservation research, it has only recently become tractable to generate genome-wide data at a scale that is useful for conservation."
                + "\n\n" + "In this Review, we discuss how genome-scale data can inform species delineation in the face of admixture, facilitate evolution through the identification of adaptive alleles, and enhance evolutionary rescue based on genomic patterns of inbreeding."
                + "\n\n" +  "As genomic approaches become more widely adopted in conservation, we expect that they will have a positive impact on management and policy decisions.";

        String citation = "Supple, M.A., Shapiro, B. Conservation of biodiversity in the genomics era. Genome Biol 19, 131 (2018)."
                + "\n\n" + "https://doi.org/10.1186/s13059-018-1520-3" + "\n\n" + "Image: Unsplash.com" +"\n";

        /* Method calling */
        article3Content.setText(content);
        article3Citation.setText(citation);
    }

    /* On Click Method */
    public void openArticlePage() {
        Intent intent = new Intent(this, ArticlesPage.class);
        startActivity(intent);
    }
}