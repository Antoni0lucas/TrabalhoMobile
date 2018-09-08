package com.example.lucasnascimento.trabalho1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton1, toggleButton2;
    private Button btnDisplay;
    EditText editText4;
    EditText editView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();



    }
    public void addListenerOnButton(){
        toggleButton1 = (ToggleButton)findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton)findViewById(R.id.toggleButton2);
        btnDisplay = (Button)findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("toggleButton : ").append(toggleButton1.getText());
                result.append("\ntoggleButton2 : ").append(toggleButton2.getText());

                Toast.makeText(MainActivity.this, result.toString(),
                    Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void onClickButton2(View view){

        editText4 = findViewById(R.id.editText4);
        editView = findViewById( R.id.editView);

        String editText = editText4.getText().toString();
        editText4.setText("");
        String ediView = editView.getText().toString();
        ediView += " - " + editText4;

        editView.setText( ediView );

        Log.d("MainActivity", editText);
    }

    public void ir (View view){
        Intent intent = new Intent( this, Activity2.class);
        startActivity (intent);
    }
}
