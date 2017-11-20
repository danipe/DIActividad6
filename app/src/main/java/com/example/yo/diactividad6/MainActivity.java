package com.example.yo.diactividad6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.editNombre);
        ed2 = (EditText) findViewById(R.id.editLocal);
        registerForContextMenu(ed1);
        registerForContextMenu(ed2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.copy_paste, menu);
    }

    public void cambiarColor(View v) {
        System.out.println(v.getBackground());
        findViewById(R.id.MainLayout).setBackground(v.getBackground());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dropdown, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.preferenciasMenu) {
            Intent pref = new Intent(this, Preferencias.class);
            startActivity(pref);
        }
        return true;
    }

    public void abrir( View v ) {
        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.floridaoberta.com/"));
        startActivity(browse);
    }

    public void seleccionar(View v) {
        Intent pref = new Intent(this, Seleccionar.class);
        startActivity(pref);
    }

}
