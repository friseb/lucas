package com.example.sitzplan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> students = new ArrayList<String>();

        String[] names = { "SF", "", "SX", "", "FSp", "MX", "FSt", "MK", "FH",
                "XB", "MT", "MP", "MK", "", "JZ", "", "FF", "KX", "NF", "TK",
                "ML", "", "HX", "SP", "XX", "MX", "MH", "" };

        for (String name : names)
        {
            students.add(new String(name));
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        String formattedDate = sdf.format(date);

        int seed = Integer.parseInt(formattedDate);

        Collections.shuffle(students, new Random(seed));

        
        int[][] rows = { { R.id.row11, R.id.row12, R.id.row13 },
                { R.id.row21, R.id.row22, R.id.row23 },
                { R.id.row31, R.id.row32, R.id.row33 },
                { R.id.row41, R.id.row42, R.id.row43 },
                { R.id.row51, R.id.row52 } };

        int j_len, z = 0;

        for (int i = 0; i < 5; i++)
        {
            j_len = 3;

            if (i == 4)
            {
                j_len = 2;
            }

            for (int j = 0; j < j_len; j++)
            {
                String text = students.get(z) + " " + students.get(z + 1);
                text = text.trim();

                TextView textView = (TextView) findViewById(rows[i][j]);
                textView.setText(text);

                z += 2;
            }
        }
    }
}
