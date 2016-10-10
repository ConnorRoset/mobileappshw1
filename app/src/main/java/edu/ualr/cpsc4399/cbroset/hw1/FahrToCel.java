package edu.ualr.cpsc4399.cbroset.hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class FahrToCel extends AppCompatActivity {
    public final static double FAHR_TO_CELL_RESULT = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fahr_to_cel);
    }

    public void convertFahrToCel(View view) {
        //collect fahr from textfield

        //convert to celcius
        Intent returnIntent = new Intent();
        double result = 0.0;
        EditText et = (EditText) findViewById(R.id.fahrToCellTF);

        if (et.getText().toString().matches("")) {

            setResult(FahrToCel.RESULT_CANCELED, returnIntent);
            //finish();
        } else {

            result = (Double.valueOf(et.getText().toString()));
            result = (result - 32) * 5 / 9;
            result = Math.round(result);
//            result = result * 5;
//            result = result / 9;
            String temp = String.format("%.2f",result);
            returnIntent.putExtra("RESULT_FAHR_TO_CEL", temp);
            returnIntent.putExtra("ORIGINAL_FAHR", et.getText().toString());

            //pass the intent
            //returnIntent.putExtra(MainActivity.result, String.valueOf(result));

            //close the activity
            setResult(FahrToCel.RESULT_OK, returnIntent);

        }
        finish();
    }

}
