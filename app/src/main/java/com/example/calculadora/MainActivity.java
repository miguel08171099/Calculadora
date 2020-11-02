package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textoPantallaPrincipal;
    TextView textoPantallaSecundaria;
    boolean anguloGrados = true;
    Button btnDegree;
    String ultimaOperacion = "";
    double resultadoFinal;
    double resultadoParcial;
    String medidaAngular = "d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onBtn0Click(android.view.View v) {
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaPrincipal.setText(textoPantallaPrincipal.getText() + "0");
    }
    public void onBtn1Click(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaPrincipal.setText(textoPantallaPrincipal.getText() + "1");
    }
    public void onBtn2Click(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaPrincipal.setText(textoPantallaPrincipal.getText() + "2");
    }
    public void onBtn3Click(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaPrincipal.setText(textoPantallaPrincipal.getText() + "3");
    }
    public void onBtn4Click(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaPrincipal.setText(textoPantallaPrincipal.getText() + "4");
    }
    public void onBtn5Click(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaPrincipal.setText(textoPantallaPrincipal.getText() + "5");
    }
    public void onBtn6Click(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaPrincipal.setText(textoPantallaPrincipal.getText() + "6");
    }
    public void onBtn7Click(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaPrincipal.setText(textoPantallaPrincipal.getText() + "7");
    }
    public void onBtn8Click(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaPrincipal.setText(textoPantallaPrincipal.getText() + "8");
    }
    public void onBtn9Click(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaPrincipal.setText(textoPantallaPrincipal.getText() + "9");
    }

    private double AcumulaParcial(){
        switch(ultimaOperacion){
            case "+":
                resultadoParcial = resultadoParcial + Integer.parseInt(textoPantallaPrincipal.getText().toString());
                break;
            case "-" :
                resultadoParcial = resultadoParcial - Integer.parseInt(textoPantallaPrincipal.getText().toString());
                break;
            case "x" :
                resultadoParcial = resultadoParcial * Integer.parseInt(textoPantallaPrincipal.getText().toString());
                break;
            case "/" :
                resultadoParcial = resultadoParcial / Integer.parseInt(textoPantallaPrincipal.getText().toString());
                break;
            default :
                resultadoParcial = Integer.parseInt(textoPantallaPrincipal.getText().toString());
        }
        return resultadoParcial;
    }

    public void onBtnSumaClick(View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaSecundaria = (TextView) findViewById(R.id.textoPantallaSecundaria);
        resultadoParcial = AcumulaParcial();

        textoPantallaSecundaria.setText(textoPantallaSecundaria.getText() + "" + textoPantallaPrincipal.getText() + "+");
        //textoPantallaSecundaria.setText(Double.toString(resultadoParcial));
        textoPantallaPrincipal.setText("");
        ultimaOperacion = "+";
        Log.d("MYAPP", String.valueOf(resultadoParcial)+" Al final");
    }
    public void onBtnRestaClick(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaSecundaria = (TextView) findViewById(R.id.textoPantallaSecundaria);
        resultadoParcial = AcumulaParcial();
        textoPantallaSecundaria.setText(textoPantallaSecundaria.getText() + "" + textoPantallaPrincipal.getText() + "-");
        textoPantallaPrincipal.setText("");
        ultimaOperacion = "-";
    }
    public void onBtnMultiplicacionClick(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaSecundaria = (TextView) findViewById(R.id.textoPantallaSecundaria);
        resultadoParcial = AcumulaParcial();
        textoPantallaSecundaria.setText(textoPantallaSecundaria.getText() + "" + textoPantallaPrincipal.getText() + "x");
        textoPantallaPrincipal.setText("");
        ultimaOperacion = "x";
    }
    public void onBtnDivisionClick(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaSecundaria = (TextView) findViewById(R.id.textoPantallaSecundaria);
        resultadoParcial = AcumulaParcial();
        textoPantallaSecundaria.setText(textoPantallaSecundaria.getText() + "" + textoPantallaPrincipal.getText() + "/");
        textoPantallaPrincipal.setText("");
        ultimaOperacion = "/";
    }

    double numeroEnRadianes = 0;
    private void CalcularRadianes(){
        if(anguloGrados)
            numeroEnRadianes = Integer.parseInt(textoPantallaPrincipal.getText().toString()) * (Math.PI/180);
        else
            numeroEnRadianes = Integer.parseInt(textoPantallaPrincipal.getText().toString());
    }
    public void onBtnSinusClick(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        CalcularRadianes();
        resultadoFinal = Math.sin(numeroEnRadianes);
        textoPantallaPrincipal.setText(Double.toString(resultadoFinal));
    }
    public void onBtnCosinusClick(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        CalcularRadianes();
        resultadoFinal = Math.cos(numeroEnRadianes);
        textoPantallaPrincipal.setText(Double.toString(resultadoFinal));
    }
    public void onBtnTangenteClick(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        CalcularRadianes();
        resultadoFinal = Math.tan(numeroEnRadianes);
        textoPantallaPrincipal.setText(Double.toString(resultadoFinal));
    }


    public void onBtnDegreeClick(android.view.View v){
        anguloGrados = !anguloGrados;
        btnDegree = (Button) findViewById(R.id.btnDegree);
        if (anguloGrados)
            btnDegree.setText("Deg");
        else
            btnDegree.setText("Rad");
    }

    public void onBtnDeleteClick(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaSecundaria = (TextView) findViewById(R.id.textoPantallaSecundaria);
        textoPantallaPrincipal.setText("");
        textoPantallaSecundaria.setText("");
        resultadoParcial = 0;
    }
    public void onBtnIgualClick(android.view.View v){
        textoPantallaPrincipal = (TextView) findViewById(R.id.textoPantallaPrincipal);
        textoPantallaSecundaria = (TextView) findViewById(R.id.textoPantallaSecundaria);
        resultadoFinal = AcumulaParcial();
        textoPantallaSecundaria.setText("");
        Log.d("MYAPP", String.valueOf(resultadoFinal));
        textoPantallaPrincipal.setText(Double.toString(resultadoFinal));
        resultadoParcial = 0;
    }
}