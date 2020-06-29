package br.com.unipar.fgts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvDtPagamento;
    private TextView tvValorPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


         tvDtPagamento = findViewById(R.id.editDtPagamento);
         tvValorPagamento = findViewById(R.id.editValorPagamento);


        Bundle bundle = getIntent().getExtras();

        tvDtPagamento.setText(bundle.getString("DtPagamento"));
        tvValorPagamento.setText("R$ " + bundle.getString("SaldoReceber"));


    }
}