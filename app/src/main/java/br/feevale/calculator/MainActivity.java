package br.feevale.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.view.KeyEvent.KEYCODE_NUMPAD_ADD;
import static android.view.KeyEvent.KEYCODE_NUMPAD_EQUALS;
import static android.view.KeyEvent.KEYCODE_PLUS;

public class MainActivity extends AppCompatActivity {
    Intent history;
    public static List<Operation> operations = new ArrayList<>();
    public static int operation = -1;
    private boolean pressedKey;
    private String lastKey;

    EditText edtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edtData = findViewById(R.id.edtData);
        this.edtData.setRawInputType(Configuration.KEYBOARD_12KEY);
        this.edtData.setText("0");
        operation = -1;
        // controle //
        this.pressedKey = false;
        this.lastKey = "";
        history = new Intent(getBaseContext(), HistoryActivity.class);
    }

    // altera operador visual //
    private void changeOperator(char ch){
        String tmp = this.edtData.getText().toString();
        String op = tmp.substring(tmp.length()-1, tmp.length());
        if (op.charAt(0) == ch){
            return;
        }
        if (op.equals("-") || op.equals("+") || op.equals("*") || op.equals("/")) {
            tmp = tmp.substring(0, tmp.length() - 1) + ch;
            if (this.edtData.isFocused()){
                tmp = tmp.substring(0, tmp.length() - 1);
                this.edtData.setText(tmp);
                return;
            }
        }
        this.edtData.setText(tmp);
    }

    // seta operador visual //
    private void setOperator(char ch){
        String tmp = this.edtData.getText().toString();
        tmp = tmp + ch;
        if (this.edtData.isFocused()){
            tmp = tmp.substring(0, tmp.length()-1);
        }
        this.edtData.setText(tmp);
    }

    // dynamic click //
    private void dynamicClick(int op, char ch){
        if (operation != -1){
            changeOperator(ch);
            operation = op;
            this.edtData.setSelection(this.edtData.getText().length());
            return;
        }
        setOperator(ch);
        operation = op;
        this.edtData.setSelection(this.edtData.getText().length());
    }

    private void setNumber(int x){
        int number = -1;
        if (this.pressedKey){
            this.pressedKey = false;
        }else{
            // na segunda passada limpa buffer //
            if (!this.lastKey.equals("")) {
                try{
                    number = Integer.parseInt(this.lastKey);
                }catch (NumberFormatException e){
                    number = -1;
                }
            }
            this.lastKey = "";
        }
        if (number == x){
            return;
        }
        if (this.edtData.getText().toString().equals("0")) {
            this.edtData.getText().clear();
        }
        this.edtData.setText(this.edtData.getText().toString() + x);
        this.edtData.setSelection(this.edtData.getText().length());
    }

    private boolean checkData(){
        if (this.edtData.getText().toString().equals("0")){
            return false;
        }
        return true;
    }

    public void onClickHistory(View v){
        startActivity(history);
    }

    public void onClickResult(View v){
        if (!this.edtData.getText().toString().equals("")) { // nao sou fã, mas nao achei nenhum "EmptyStr" como tem em delphi
            operations.add(new Operation(this.edtData.getText().toString(), operation));
            this.onClickClear(null);
            return;
        }
        Toast.makeText(getApplicationContext(), "Data can't be empty.", Toast.LENGTH_SHORT).show();
    }

    public void onClickSum(View v){
        if (!checkData()){
            return;
        }
        dynamicClick(0, '+');
    }

    public void onClickSub(View v){
        if (!checkData()){
            return;
        }
        dynamicClick(1, '-');
    }

    public void onClickDiv(View v){
        if (!checkData()){
            return;
        }
        dynamicClick(2, '/');
    }

    public void onClickMulti(View v){
        if (!checkData()){
            return;
        }
        dynamicClick(3, '*');
    }

    public void onClickOne(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            setNumber(1);
        }
    }

    public void onClickTwo(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            setNumber(2);
        }
    }

    public void onClickTree(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            setNumber(3);
        }
    }

    public void onClickFour(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            setNumber(4);
        }
    }

    public void onClickFive(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            setNumber(5);
        }
    }

    public void onClickSix(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            setNumber(6);
        }
    }

    public void onClickSeven(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            setNumber(7);
        }
    }

    public void onClickEight(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            setNumber(8);
        }
    }

    public void onClickNine(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            setNumber(9);
        }
    }

    public void onClickZero(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            setNumber(0);
        }
    }

    public void onClickDot(View v){
        if (this.edtData.isFocused()){
            this.edtData.setSelection(this.edtData.getText().length());
        }else {
            this.edtData.setText(this.edtData.getText().toString() + '.');
        }
    }

    public void onClickClear(View v){
        this.edtData.getText().clear();
        this.edtData.setText("0");
        operation = -1;
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event){
        Log.i("key pressed", String.valueOf(event.getKeyCode()));
        char tmp = (char) event.getUnicodeChar();
        // controle //
        if (lastKey == ""){
            this.lastKey = String.valueOf(tmp);
            this.pressedKey = true;
        }
        switch(tmp){
            case '+': this.onClickSum(null); break;     // +
            case '-': this.onClickSub(null); break;     // -
            case '/': this.onClickDiv(null); break;     // /
            case '*': this.onClickMulti(null); break;   // *
            case '1': this.onClickOne(null); break;     // 1
            case '2': this.onClickTwo(null); break;     // 2
            case '3': this.onClickTree(null); break;    // 3
            case '4': this.onClickFour(null); break;    // 4
            case '5': this.onClickFive(null); break;    // 5
            case '6': this.onClickSix(null); break;     // 6
            case '7': this.onClickSeven(null); break;   // 7
            case '8': this.onClickEight(null); break;   // 8
            case '9': this.onClickNine(null); break;    // 9
            case '0': this.onClickZero(null); break;    // 0
        }
        if (event.getKeyCode() == 66 && !this.lastKey.equals("ENTER")){
            this.onClickResult(null);
            this.lastKey = "ENTER";
        }
        return super.dispatchKeyEvent(event);
    }
}