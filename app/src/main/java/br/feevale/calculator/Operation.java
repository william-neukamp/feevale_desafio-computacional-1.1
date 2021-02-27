package br.feevale.calculator;

// TODO - fazer todos os metodos de somas encapsulados aqui dentro //
public class Operation {
    private float num1;
    private float num2;
    private int operation;
    private char sOperation;
    private float result;
    /*
    0 - adicao
    1 - subtracao
    2 - divisao
    3 - multiplicacao
    */

    public Operation(){
    }

    public Operation(float num1, float num2, int operation) {
        this.setNum1(num1);
        this.setNum2(num2);
        this.setOperation(operation);
    }

    // achei melhor encapsular tudo aqui pra não ficar uma salada de fruta no activity //
    public Operation(String data, int op){
        // teste //
        this.operation = op;
        switch (op){
            case 0: this.sOperation = '+'; break;
            case 1: this.sOperation = '-'; break;
            case 2: this.sOperation = '/'; break;
            case 3: this.sOperation = '*'; break;
        }
        this.num1 = Float.parseFloat(data.substring(0, data.indexOf(sOperation)));
        this.num2 = Float.parseFloat(data.substring(data.indexOf(sOperation)+1));
        // calcula resultado //
        this.result();
    }

    private void result(){
        switch(this.operation){
            case 0: this.result = num1 + num2; break;
            case 1: this.result = num1 - num2; break;
            case 2: this.result = num1 / num2; break;
            case 3: this.result = num1 * num2; break;
        }
    }

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public char getsOperation(){
        return this.sOperation;
    }

    public void setsOperation(char sOperation){
        this.sOperation = sOperation;
    }

    public Float getResult(){
        return this.result;
    }

}
