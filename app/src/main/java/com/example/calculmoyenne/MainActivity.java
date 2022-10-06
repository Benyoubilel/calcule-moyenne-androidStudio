package com.example.calculmoyenne;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText notedc, noteds, notetp;
    TextView result;
    String moyenneResult;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notedc = findViewById(R.id.notedc);
        noteds = findViewById(R.id.noteds);
        notetp = findViewById(R.id.notetp);
        result = findViewById(R.id.result);


    }

    public double pourc(double note, double pour) {
        return (note * pour) / 100;
    }


    public void CalculerMoyenne(View view) {
        // convertion du champs de saisie en text
        String n1 = notedc.getText().toString();
        String n2 = noteds.getText().toString();
        String n3 = notetp.getText().toString();
        //convertion du text en number
        double ndc = Double.parseDouble(n1);
        double nds = Double.parseDouble(n2);
        double ntp = Double.parseDouble(n3);

        //calcule de note selon le pourcentage
        double ndcf = pourc(ndc, 40);
        double ndsf = pourc(nds, 60);
        double ntpf = pourc(ntp, 20);

        double sumDSDC = ndcf + ndsf;
        double ndsdcf = pourc(sumDSDC, 80);
        //resultat du calcule moyenne
        double moyenne = ndsdcf + ntpf;

        moyenneResult = "Votre Moyenne est: " + moyenne;

        result.setText(moyenneResult);
    }
}