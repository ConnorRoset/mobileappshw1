package edu.ualr.cpsc4399.cbroset.hw1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    static final int CELL_TO_FAHR_RESULT_REQUEST = 1;
    static final int FAHR_TO_CELL_RESULT_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void celToFahrClick(View view) {

        Intent intent = new Intent(this, CelToFahr.class);
        startActivityForResult(intent, CELL_TO_FAHR_RESULT_REQUEST);
    }

    public void fahrToCelClick(View view) {
        Intent intent = new Intent(this, FahrToCel.class);
        startActivityForResult(intent, FAHR_TO_CELL_RESULT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //check if celcius to fahrenheit
        if (requestCode == CELL_TO_FAHR_RESULT_REQUEST) {

            //check for good input
            if (resultCode == RESULT_OK) { //which activity? MainActivity or CelToFahr?
                String tempresult = data.getStringExtra("RESULT_CEL_TO_FAHR");
                String originalCel = data.getStringExtra("ORIGINAL_CEL");

                TextView chngtextview = (TextView) findViewById(R.id.CelToFahrResultTextView);
                chngtextview.setText(originalCel + " -> " + tempresult);
            }

            //bad input check
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
                TextView chngtextview = (TextView) findViewById(R.id.CelToFahrResultTextView);
                //assert(chngtextview!=null);
                chngtextview.setText(R.string.bad_input);
            }
        }

        //check if fahrenheit to celcius
        if (requestCode == FAHR_TO_CELL_RESULT_REQUEST) {

            //check for good input
            if (resultCode == RESULT_OK) {
                String tempresult = data.getStringExtra("RESULT_FAHR_TO_CEL");
                String originalFahr = data.getStringExtra("ORIGINAL_FAHR");

                TextView chngtextview = (TextView) findViewById(R.id.fahrToCellResultTextView);
                chngtextview.setText(originalFahr + " -> " + tempresult);
            }
            //bad input check
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
                TextView chngtextview = (TextView) findViewById(R.id.fahrToCellResultTextView);
                chngtextview.setText(R.string.bad_input);
            }
        }
    }
}
