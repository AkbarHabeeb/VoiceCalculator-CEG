package myfirstapp.example.com.voicecalc;

import android.content.ActivityNotFoundException;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import org.mariuszgromada.math.mxparser.*;

public class VoiceActivity extends AppCompatActivity
{
    private TextView txtSpeechInput;
    //private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
    }

    /**
     * Showing google speech input dialog
     * */
    public void getSpeechInput(View view)
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_prompt));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Receiving speech input
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null)
                {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    //txtSpeechInput.setText(result.get(0));

                    String change = result.get(0);
                    //change=change.replace("x","*");
                    //change=change.replace("X","*");

                    change=change.replace("to","2");
                    change=change.replace("tu","2");
                    change=change.replace("add","+");
                    change=change.replace("added","+");
                    change=change.replace("plus","+");

                    change=change.replace("sub","-");
                    change=change.replace("subtract","-");
                    change=change.replace("minus","-");

                    change=change.replace("times","*");
                    change=change.replace("into","*");
                    change=change.replace("in2","*");
                    change=change.replace("multiply by","*");
                    change=change.replace("star","*");

                    change=change.replace("divide by","/");
                    change=change.replace("divided   by","/");
                    change=change.replace("divide","/");

                    change=change.replace("equal","=");
                    change=change.replace("equals","=");

                    change=change.replace("open bracket","(");
                    change=change.replace("close bracket",")");

                    change=change.replace("square root","sqrt(");
                    change=change.replace("sqaure root of","sqrt(");

                    change=change.replace("powerof","^");
                    change=change.replace("power","^");
                    change=change.replace("to the power of","^");
                    change=change.replace("to the power","^");

                    //change=change.replace(" ","");


                    if(change.contains("="))
                    {
                        change=change.replace("=","");

                        Expression ex = new Expression(change);
                        Object ss = ex.calculate();
                        String s = ss.toString();

                        txtSpeechInput.setText(s);
                    }
                    else
                    {
                        txtSpeechInput.setText(change);
                    }
                }
                break;
        }
    }
}