package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Article1 extends AppCompatActivity {

    /* Variable Declaration */
    TextView article1Content;
    TextView article1Citation;
    private ImageView backbtn_article1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article1);

        /* Assignment Statement */
        article1Content = findViewById(R.id.article1content);
        article1Citation = findViewById(R.id.article1citation);
        backbtn_article1 = (android.widget.ImageView) findViewById(R.id.backbtn_article1);

        /* On Click Listener: Defines what happens when the image is clicked */
        backbtn_article1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArticlePage();
            }
        });


        /* String Contents "used for TextViews" */
        String content = "The topics of renewable energy and sustainable development are subjects of extensive discussion and passionate debate. The prevailing viewpoint suggests that renewable energy is essential for achieving sustainable development. It is believed that an abundant and economically viable source of renewable energy exists, which can be harnessed in an environmentally friendly manner. However, there are dissenting voices that argue in favor of fossil fuels, asserting that these resources are far from depleted. They argue that clean technologies, already developed, can enable the continued use of fossil fuels without harming the environment. Additionally, they contend that renewable energy sources present unresolved technical challenges and often have more adverse environmental and societal impacts than anticipated.\n" +
                "\n" +
                "Global warming and the accumulation of carbon dioxide are intimately linked to discussions of sustainability and energy. Most analyses tend to have a short-term focus, rarely extending beyond 2050 or 2100. Nevertheless, we anticipate that society will endure and remain viable well beyond these dates. Therefore, it is prudent to explore the implications of long-term sustainability. To prevent the discussion from becoming purely speculative, certain constraints must be imposed. Hence, we propose the concept of a \"sustainability steady state.\"\n" +
                "\n" +
                "A preliminary analysis, based on widely accepted data and the principles of mass and energy conservation, suggests that, regardless of the relationship between carbon dioxide buildup and global warming, the adoption of renewable energy sources, particularly direct solar energy, is unavoidable. This transition will need to be complemented by the judicious use of indirect solar energy, such as wind and bio-energy. While renewable sources contain energy on a scale far exceeding human society's needs, their utilization is challenging, with only a small fraction being ultimately harvestable. Significant technical, environmental, and societal obstacles must be overcome, including limitations on energy transmission and usage locations. Achieving this goal will also necessitate the development of \"wasteless technology\" and the recovery and recycling of materials, especially those that are challenging to extract from natural sources and may face shortages.\n" +
                "\n" +
                "In the long term, the adoption of \"renewable energy\" appears inevitable. However, it will require substantial effort, meticulous planning, and will not come without its share of difficulties.";

        String citation = "Ray, P. Renewable energy and sustainability. Clean Techn Environ Policy 21, 1517–1533 (2019)."
                + "\n\n" + "https://doi.org/10.1007/s10098-019-01739-4" + "\n\n" + "Image: Unsplash.com" +"\n";

        /* Method calling */
        article1Content.setText(content);
        article1Citation.setText(citation);
    }

    /* On Click Method */
    public void openArticlePage() {
        Intent intent = new Intent(this, ArticlesPage.class);
        startActivity(intent);
    }
}