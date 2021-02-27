package br.feevale.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CalculatorAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<Operation> operations;

    public CalculatorAdapter(List<Operation> operations, Context context){
        this.operations = operations;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.operations.size();
    }

    @Override
    public Object getItem(int position) {
        return operations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.calculator_item, null);
        TextView txtNum1 = v.findViewById(R.id.txtNum1);
        TextView txtNum2 = v.findViewById(R.id.txtNum2);
        TextView txtResult = v.findViewById(R.id.txtResult);

        Operation item = operations.get(position);
        txtNum1.setText(Float.toString(item.getNum1()));
        txtNum2.setText(item.getsOperation() + Float.toString(item.getNum2()));
        txtResult.setText(Float.toString(item.getResult()));
        return v;
    }
}
