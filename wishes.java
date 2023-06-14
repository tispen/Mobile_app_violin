package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class wishes extends AppCompatActivity implements View.OnClickListener{

    DBHelper dbHelper;
    TextView tvOut;
    EditText editName, editProg;
    Button btnDel, btnAdd, btnGet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishes);

        dbHelper = new DBHelper(this);

        tvOut = findViewById(R.id.tvOut);
        editName = findViewById(R.id.EditName);
        editProg = findViewById(R.id.EditProg);

        btnDel=findViewById(R.id.buttonDel);
        btnAdd=findViewById(R.id.buttonAdd);
        btnGet=findViewById(R.id.buttonGet);

        btnDel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnGet.setOnClickListener(this);

        this.setTitle("Notes of ideas");
        final Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                wishes.this.finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonDel:
                dbHelper.DelAll();
                break;
            case R.id.buttonAdd:
                String name = editName.getText().toString();
                String prog = editProg.getText().toString();

                Data data = new Data(name, prog);
                dbHelper.AddOne(data);
                break;
            case R.id.buttonGet:
                LinkedList<Data> list = dbHelper.GetAll();

                String text = "";
                for (Data d:list)
                    text = text + d.name + " в программе - " + d.prog +"  \n";

                tvOut.setText(text);
                break;
        }
    }
}
