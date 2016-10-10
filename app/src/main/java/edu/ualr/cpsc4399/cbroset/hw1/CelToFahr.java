package edu.ualr.cpsc4399.cbroset.hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class CelToFahr extends AppCompatActivity {
    public static final double CELL_TO_FAHR_RESULT = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cel_to_fahr);
    }

    public void convertCelToFahr(View view) {
        //get the text from the textfield
        //convert it to fahrenheight
        double result =0.0;
        Intent returnIntent = new Intent();


        //extract the user input
        EditText et = (EditText) findViewById(R.id.celToFahrTF);

        if (et.getText().toString().matches("")) {
            setResult(CelToFahr.RESULT_CANCELED, returnIntent);
           // finish();
        }

        //build the intent to pass back

        //pass the result into the intent
        else {
            result = (Double.valueOf(et.getText().toString()));
            result = ((result * 9) / 5 ) + 32;
//            result = result / 5 ;
//            result = result + 32;
            String temp = String.format(Locale.US, "%.2f",result);

            returnIntent.putExtra("RESULT_CEL_TO_FAHR", temp);
            returnIntent.putExtra("ORIGINAL_CEL", et.getText().toString());
            //set flag that result is good
            setResult(CelToFahr.RESULT_OK, returnIntent);

            //close the activity

        }
        finish();
    }
}
