/**
 *
 *
 *
 *
 */


package com.jikexueyuan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvScreen;
    private List<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScreen = (TextView) findViewById(R.id.textView);

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSub).setOnClickListener(this);
        findViewById(R.id.btnMul).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
        findViewById(R.id.btnEql).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                tvScreen.append("0");
                break;
            case R.id.btn1:
                tvScreen.append("1");
                break;
            case R.id.btn2:
                tvScreen.append("2");
                break;
            case R.id.btn3:
                tvScreen.append("3");
                break;
            case R.id.btn4:
                tvScreen.append("4");
                break;
            case R.id.btn5:
                tvScreen.append("5");
                break;
            case R.id.btn6:
                tvScreen.append("6");
                break;
            case R.id.btn7:
                tvScreen.append("7");
                break;
            case R.id.btn8:
                tvScreen.append("8");
                break;
            case R.id.btn9:
                tvScreen.append("9");
                break;
            case R.id.btnAdd:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Types.NUM));
                checkAndCompute();
                items.add(new Item(0, Types.ADD));
                tvScreen.setText("");
                break;
            case R.id.btnSub:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Types.NUM));
                checkAndCompute();
                items.add(new Item(0, Types.SUB));
                tvScreen.setText("");
                break;
            case R.id.btnMul:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Types.NUM));
                checkAndCompute();
                items.add(new Item(0, Types.MUL));
                tvScreen.setText("");
                break;
            case R.id.btnDiv:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Types.NUM));
                checkAndCompute();
                items.add(new Item(0, Types.DIV));
                tvScreen.setText("");
                break;
            case R.id.btnEql:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Types.NUM));
                checkAndCompute();
                tvScreen.setText(items.get(0).value + "");
                items.clear();
                break;
            case R.id.btnClear:
                tvScreen.setText("");
                items.clear();
                break;
        }
    }

    public void checkAndCompute() {
        if (items.size() >= 3) {

            double a = items.get(0).value;
            double b = items.get(2).value;
            int opt = items.get(1).type;

            items.clear();

            switch (opt) {
                case Types.ADD:
                    items.add(new Item(a + b, Types.NUM));
                    break;
                case Types.SUB:
                    items.add(new Item(a - b, Types.NUM));
                    break;
                case Types.MUL:
                    items.add(new Item(a * b, Types.NUM));
                    break;
                case Types.DIV:
                    items.add(new Item(a / b, Types.NUM));
                    break;
            }
        }
    }
}
