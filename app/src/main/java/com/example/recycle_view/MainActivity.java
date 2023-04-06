package com.example.recycle_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> items;
    private Button btnAdd, btnDel;
    private EditText TxtAdd, TxtDel;

    public Random myrandom =new Random();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnins);
        btnDel = findViewById(R.id.btnRem);
        TxtAdd = findViewById(R.id.editadd);
        TxtDel = findViewById(R.id.editdel);

        generatedata();
        recyclerviewConfig();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = TxtAdd.getText().toString();
                if(TextUtils.isEmpty(val)){
                    TxtAdd.setError("Enter a number");
                }
                else {
                    Integer position = Integer.parseInt(val);
                    addCard(position);

                }

            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = TxtDel.getText().toString();
                if(TextUtils.isEmpty(val)){
                    TxtDel.setError("Enter a number");
                }
                else{
                    int position = Integer.parseInt(TxtDel.getText().toString());
                    deleteCard(position);
                }
            }
        });

    }

    private void generatedata() {
        items = new ArrayList<>();
        items.add(new Item(R.drawable.oner,"CLICKED AT BEACH"));
        items.add(new Item(R.drawable.twor,"CLICKED AT STREET"));
        items.add(new Item(R.drawable.threer,"CLICKED AT PARKING"));
        items.add(new Item(R.drawable.fourr,"CLICKED FROM DRONE"));
        items.add(new Item(R.drawable.fiver,"CLICKED AT PLAYGROUND"));
        items.add(new Item(R.drawable.sixr,"CLICKED AT GREENGROCER"));
    }


    private void recyclerviewConfig() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(items);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void addCard(int position){
        int myRan = myrandom.nextInt(6)+1;
        switch (myRan){
            case 1:items.add(position,new Item(R.drawable.oner,"CLICKED AT BEACH"));
                   adapter.notifyItemInserted(position);
                   break;
            case 2:items.add(position,new Item(R.drawable.twor,"CLICKED AT STREET"));
                   adapter.notifyItemInserted(position);
                   break;
            case 3:items.add(position,new Item(R.drawable.threer,"CLICKED AT PARKING"));
                   adapter.notifyItemInserted(position);
                   break;
            case 4:items.add(position,new Item(R.drawable.fourr,"CLICKED FROM DRONE"));
                   adapter.notifyItemInserted(position);
                   break;
            case 5:items.add(position,new Item(R.drawable.fiver,"CLICKED AT PLAYGROUND"));
                   adapter.notifyItemInserted(position);
                   break;
            case 6:items.add(position,new Item(R.drawable.sixr,"CLICKED AT GREENGROCER"));
                   adapter.notifyItemInserted(position);
                   break;

        }

    }
    public void deleteCard(int position){
        items.remove(position);
        adapter.notifyItemRemoved(position);

    }
}