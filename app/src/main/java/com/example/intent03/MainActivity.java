package com.example.intent03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private  static  final int SET_REQUEST = 100;
    TextView textview_output;
    EditText edittext_opd1,edittext_opd2;
    Button button_caculate_op;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext_opd1=findViewById(R.id.edittext_opd1);
        edittext_opd1=findViewById(R.id.edittext_opd2);
        textview_output=findViewById(R.id.textview_output);
        button_caculate_op=findViewById(R.id.button_choice_op);

        button_caculate_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Activity_OP.class);
                Bundle b = new Bundle();
                b.putString("OPERAND_01",edittext_opd1.getText().toString());
                b.putString("OPERAND_02",edittext_opd2.getText().toString());

            i.putExtras(b);
            startActivityForResult(i,SET_REQUEST);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if(requestCode == SET_REQUEST){
            if(resultCode==RESULT_OK){
                Bundle b=i.getExtras();
                Double answer = b.getDouble("CACULATE_RESULT");
                textview_output.setText("運算結果="+answer.toString());
            }

        }

    }
}