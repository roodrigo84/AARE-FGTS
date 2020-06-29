package br.com.unipar.fgts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {


    private EditText editCpf;
    private EditText editDataNascimento;
    private EditText editRendaMensal;
    public EditText editRenda;
    public TextView editValorPagamento;
    public TextView editDataPagamento;

    BigDecimal rendaMensal = new BigDecimal("0");
    private BigDecimal saldoReceber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCpf = findViewById(R.id.editCpf);
        editDataNascimento = findViewById(R.id.editDataNascimento);
        editRendaMensal = findViewById(R.id.editRendaMensal);

    }


    public void ConsultarSaldo (View view) {

        double Cpf = Double.parseDouble( editCpf.getText().toString());
        double DataNascimento = Double.parseDouble(editDataNascimento.getText().toString());
        double RendaMensal = Double.parseDouble( editRendaMensal.getText().toString());
        double Renda = Double.parseDouble(editRenda.getText().toString());
        String ValorPagamento = (editValorPagamento.getText().toString());
        double DtPagamento = Double.parseDouble(editDataPagamento.getText().toString());



        if (RendaMensal <= 5000) {
            Renda = RendaMensal * 0.7;
        } else {
            editValorPagamento.setText("Seu Auxilio foi Negado, sua renda é maior que R$5000,00");
        }
        if (Renda <= 475){
            editValorPagamento.setText("R$" + (Renda));
        } else {
            editValorPagamento.setText("R$475,00");
        }



        Intent intent = new Intent(this, MainActivity2.class);
        Bundle bundle = new Bundle();

        bundle.putString("dataPagamento", ValorPagamento);
        bundle.putString("saldoReceber", String.valueOf(saldoReceber));

        intent.putExtras(bundle);
        startActivity(intent);

    }
    public void LimparCampos (View view) {

        editCpf.setText("");
        editRendaMensal.setText("");
        editDataNascimento.setText("");


    }




}