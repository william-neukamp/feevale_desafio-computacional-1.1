package br.feevale.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    public ListView listOperations;
    public List<Operation> operations = new ArrayList<>();
    public CalculatorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        this.listOperations = findViewById(R.id.listData);
        this.operations = MainActivity.operations;
        adapter = new CalculatorAdapter(operations, getBaseContext());
        this.listOperations.setAdapter(adapter);
        this.adapter.notifyDataSetChanged();
    }

    public void OnClickBack(View v){
        finish();
    }
}