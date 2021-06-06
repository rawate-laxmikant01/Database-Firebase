package com.example.database_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Recycler_view extends AppCompatActivity {
    RecyclerView rvdata;
    RecyclerViewAdapter recyclerViewAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    ArrayList<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rvdata=findViewById(R.id.rv_Data);
        firebaseDatabase=FirebaseDatabase.getInstance();
        reference=firebaseDatabase.getReference().child("data");

        list=new ArrayList<Model>();
        rvdata.setLayoutManager(new LinearLayoutManager(this));


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               // list.clear();
                for (DataSnapshot dataSnapshot :snapshot.getChildren()){
                    Model m=dataSnapshot.getValue(Model.class);
                    list.add(m);
                }
                recyclerViewAdapter=new RecyclerViewAdapter(list,Recycler_view.this);
                rvdata.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Recycler_view.this, "failed"+error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}