package com.studio.gasolinaoualcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //instaciando ViewHolder
    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Identificando componentes na tela
        this.mViewHolder.editAlcool = findViewById(R.id.inputAlcool);
        this.mViewHolder.editGasolina = findViewById(R.id.inputGas);
        this.mViewHolder.botaoVerficar = findViewById(R.id.botaoVerificar);
        this.mViewHolder.resultadoShow = findViewById(R.id.showResultado);

        this.mViewHolder.botaoVerficar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //Verificar elementos
        if (v.getId() == R.id.botaoVerificar){
            //Recupera valores digitados
            String getTextoAlcool = this.mViewHolder.editAlcool.getText().toString();
            String getTextoGasolina = this.mViewHolder.editGasolina.getText().toString();
            if ("".equals(getTextoAlcool) || "".equals(getTextoGasolina)){
                //(getTextoAlcool.isEmpty() || getTextoGasolina.isEmpty())
                Toast.makeText(this,this.getString(R.string.informe_valor),Toast.LENGTH_LONG).show();
            }else {
                //converte String para Double
                Double valorAlcool = Double.parseDouble(getTextoAlcool);
                Double valorGasolina = Double.parseDouble(getTextoGasolina);

                //Verifica qual vale a pena abastecer
                Double resultado = valorAlcool / valorGasolina;

                if(resultado >= 0.7){
                    //Gasolina
                    this.mViewHolder.resultadoShow.setText("Utilize Gasolina");
                }else{
                    //Alcool
                    this.mViewHolder.resultadoShow.setText("Utilize Álcool");
                }

            }
        }


    }


    private static class ViewHolder {
        //Identificando componentes
        EditText editAlcool;
        EditText editGasolina;
        Button botaoVerficar;
        TextView resultadoShow;

    }
}
