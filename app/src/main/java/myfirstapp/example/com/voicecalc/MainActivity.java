package myfirstapp.example.com.voicecalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button type,voice,aboutme;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        type=findViewById(R.id.bttype);
        voice=findViewById(R.id.btvoice);
        aboutme=findViewById(R.id.btaboutme);

        type.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DisplayMessageActivity.class));
            }
        });

        voice.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VoiceActivity.class));
            }
        });

        aboutme.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Aboutme.class));
            }
        });
    }
}

/** Called when the user taps the Send button
 public void sendMessage(View view) {
 Intent intent = new Intent(this, DisplayMessageActivity.class);
 EditText editText = findViewById(R.id.editText);
 String message = editText.getText().toString();
 intent.putExtra(EXTRA_MESSAGE, message);
 startActivity(intent);
 }*/

//EditText editText = findViewById(R.id.editText);
//String message = editText.getText().toString();
//intent.putExtra(EXTRA_MESSAGE, message);