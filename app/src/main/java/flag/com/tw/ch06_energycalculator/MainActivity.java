package flag.com.tw.ch06_energycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    double[] energyRate = {3.1, 4.4, 13.2, 9.7, 5.1, 3.7};
    EditText weight, time;
    TextView total, txvRate;
    Spinner sports;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = (EditText) findViewById(R.id.weight);
        time = (EditText) findViewById(R.id.timeSpan);
        total = (TextView) findViewById(R.id.total);
        txvRate = (TextView) findViewById(R.id.txvRate);
        sports = (Spinner) findViewById(R.id.sports);
        sports.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        txvRate.setText(String.valueOf(energyRate[position]));
        calc(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void calc(View v){
        String w = weight.getText().toString();//取得體重
        String t = time.getText().toString();//取得時間


        if(w.isEmpty() || w.equals(".") || t.isEmpty() || t.equals(".")){
            //不能輸入空白或" . "
            total.setText("請輸入體重和時間");
            return;
        }

        int pos = sports.getSelectedItemPosition();

        //計算消耗能量 ＝ 能量消耗率 * 體重 * 運動時間
        long kcal = Math.round(energyRate[pos] * Double.parseDouble(w) * Double.parseDouble(t));

        total.setText(String.format("消耗能量 %d 千卡", kcal));
    }
}
