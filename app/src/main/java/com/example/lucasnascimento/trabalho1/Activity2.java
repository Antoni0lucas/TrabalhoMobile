package com.example.lucasnascimento.trabalho1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private static final String TAG = "Activity2";
    private ArrayList<Usuario> usuarios;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Lucas", "1234"));
        usuarios.add(new Usuario("Antonio", "5678"));

        String user = usuarios.get(0).getNome().toString();
        Toast.makeText(this, user, Toast.LENGTH_SHORT).show();

        //Aucomplete

        String harry[] = {"A pedra filosofal", "Camara Secreta", "Prisioneiro de Askaban", "Calice de fogo"};

        AutoCompleteTextView autotext = (AutoCompleteTextView) findViewById(R.id.autoc);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, harry);

        autotext.setThreshold(1);
        autotext.setAdapter(adapter);

        //Spinner

        final Spinner spn = (Spinner) findViewById(R.id.spn);

        final String potter[] = {"A pedra filosofal", "Camara Secreta", "Prisioneiro de Askaban", "Calice de fogo"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, potter);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spn.setAdapter(adapter1);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int p = spn.getSelectedItemPosition();
                Toast.makeText(getApplicationContext(), "Você selecionou: " + potter[+position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Radio Button
    final RadioGroup rdgroup = (RadioGroup) findViewById(R.id.radioGroup);
    Button btnSelec = (Button) findViewById(R.id.btnSelec);

        btnSelec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rdgroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(id);
                Toast.makeText(Activity2.this, "Você selecionou: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }

        });
    }
    public void Avancar (View view){
        Intent intent = new Intent( this, Ativity3.class);
        startActivity (intent);
    }
}



