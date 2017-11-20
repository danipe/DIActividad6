package com.example.yo.diactividad6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Preferencias extends AppCompatActivity {

    TextView botonTono, textoSilencioso;
    CheckBox silencioso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
        botonTono = (TextView) findViewById(R.id.botonTono);
        silencioso = (CheckBox) findViewById(R.id.silencioso);
        textoSilencioso = (TextView) findViewById(R.id.textSilencioso);
        registerForContextMenu(botonTono);
        botonTono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openContextMenu(view);
            }
        });
    }

    public void selecSilencioso(View v) {
        if(this.silencioso.isChecked()) {
            this.textoSilencioso.setVisibility(View.VISIBLE);
        } else {
            this.textoSilencioso.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, v.getId(), 0, "Clasico");
        menu.add(0, v.getId(), 0, "Marambo");
        menu.add(0, v.getId(), 0, "Piano");
        menu.add(0, v.getId(), 0, "Pitbull");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        TextView tonoSeleccionado = (TextView) findViewById(R.id.tonoSeleccionado);
        tonoSeleccionado.setText(item.getTitle());
        return true;
    }

    public void preferenciasAvanzadas(View v) {
        Intent avz = new Intent(this, PreferenciasAvanzadas.class);
        startActivity(avz);
    }
}
