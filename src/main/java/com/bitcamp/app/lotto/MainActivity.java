package com.bitcamp.app.lotto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView result = findViewById(R.id.result_lotto);
        findViewById(R.id.lotto_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] lottoNum = new int[6];
                String lotto_result = "";
                for(int i = 0; i < 6; i++){
                    lottoNum[i] = (int)(Math.random() * 45 + 1);
                    if(i == 0){
                        continue;
                    } else {
                        for(int j = 0; j < i; j++) {
                            if(lottoNum[i] == lottoNum[j]){
                                i--;
                                break;
                            }
                        }
                    }
                }
                Arrays.sort(lottoNum);
                for(int i = 0; i < 6; i++){
                    if(i != 5) {
                        lotto_result += lottoNum[i] + ", ";
                    } else {
                        lotto_result += lottoNum[i];
                    }
                }
                result.setText(lotto_result);
            }
        });
    }
}
