package com.mitchelllustig.cyrwheelnbdgenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mitchelllustig.cyrwheelnbdgenerator.Generator.DataSet;
import com.mitchelllustig.cyrwheelnbdgenerator.Generator.Generator;

import java.io.IOException;
import java.io.InputStream;

public class GeneratorActivity extends AppCompatActivity {

    TextView output;
    Button generate;

    Generator generator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_generator);
        output = (TextView)findViewById(R.id.output);
        generate = (Button)findViewById(R.id.generate);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String combo = generator.generate();
                output.setText(combo);
            }
        });

        String dataJson = loadJSONFromAsset("CyrWheel.json");
        Gson gson = new Gson();
        DataSet dataSet = gson.fromJson(dataJson, DataSet.class);
        generator = new Generator(dataSet);

    }

    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
