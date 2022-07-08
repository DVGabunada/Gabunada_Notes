package com.example.gabunada_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Note> notes;
    ArrayAdapter<Note> notes_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapterMethod();
        btnAddListenerMethod();
        etNoteEnterListenerMethod();
    }

    private void etNoteEnterListenerMethod(){
        EditText etNote = findViewById(R.id.etNote);
        etNote.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN|| keyEvent.getAction() == KeyEvent.ACTION_DOWN
                    || keyEvent.getAction() == KeyEvent.KEYCODE_NUMPAD_ENTER){
                    String note = etNote.getText().toString();
                    notes.add(new Note(note));
                    notes_adapter.notifyDataSetChanged();
                    etNote.setText("");
                    return true;
                }
                return false;
            }
        });
    }

    private void btnAddListenerMethod(){
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNote = findViewById(R.id.etNote);
                String note = etNote.getText().toString();
                notes.add(new Note(note));
                notes_adapter.notifyDataSetChanged();
                etNote.setText("");

            }
        });
    }

    private void setListAdapterMethod() {
        ListView lvList = findViewById(R.id.lvList);
        notes = new ArrayList<Note>();
        notes.add(new Note("First Note"));
        notes.add(new Note("Second Note"));

        notes_adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, notes);
        lvList.setAdapter(notes_adapter);

        notes.add(new Note("Dan Vincent B. Gabunada"));

    }
}