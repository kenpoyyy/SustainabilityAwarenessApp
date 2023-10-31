package com.example.sustainabilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Article2 extends AppCompatActivity {

    /* Variable Declaration */
    TextView article2Content;
    TextView article2Citation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article2);

        article2Content = findViewById(R.id.article2content);
        article2Citation = findViewById(R.id.article2citation);

        String content = "Purpose\n" +
                "The purpose of this paper is to examine what the term sustainable fashion means from the perspective of micro-organisations, experts, and consumers.\n" +
                "\n" +
                "Design/methodology/approach\n" +
                "This research is qualitative in nature, utilising a multi-methods case study approach (semi-structured interviews, semiotics, questionnaires). Grounded analysis was applied to analyse the data.\n" +
                "\n" +
                "Findings\n" +
                "Findings indicate that interpretation of sustainable fashion is context and person dependent. A matrix of key criteria provides the opportunity to find common elements.\n" +
                "\n" +
                "Research limitations/implications\n" +
                "Due to the nature of this research the sample size is limited and may not be generalised. Data were collected in the UK and are limited to a geographical region.\n" +
                "\n" +
                "Practical implications\n" +
                "An important implication is that defining sustainable fashion is vital in order to avoid challenges, such as greenwashing, which were faced in other industries that have a longer history in sustainable practices. Micro-organisations should take advantage of identifying key sustainable fashion criteria, which will enable them to promote their fashion collections more effectively.\n" +
                "\n" +
                "Social implications\n" +
                "The criteria identified provide assurance for consumers that sustainable fashion is produced with social aspects in mind (fair wages, good working conditions).\n" +
                "\n" +
                "Originality/value\n" +
                "The paper proposes a matrix that allows micro-organisations to clearly identify their collections as sustainable.";
        String citation = "Henninger, C.E., Alevizou, P.J. and Oates, C.J. (2016), What is sustainable fashion?, Journal of Fashion Marketing and Management, Vol. 20 No. 4, pp. 400-416." + "\n\n"
                + "https://doi.org/10.1108/JFMM-07-2015-0052" + "\n";

        /* Method calling */
        article2Content.setText(content);
        article2Citation.setText(citation);

    }
}