package com.example.menubar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();
    Intent eintent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(this,"You selected the menu1",Toast.LENGTH_LONG).show();
                return true;
            case R.id.bth:
                Toast.makeText(this,"You selected the Bluetooth",Toast.LENGTH_LONG).show();
                return true;
            case R.id.bttion:
                Toast.makeText(this,"You selected the Bluetooth ON",Toast.LENGTH_LONG).show();
                startActivityForResult(eintent, 1);
                return true;
            case R.id.bttoff:
                Toast.makeText(this,"You selected the Bluetooth OFF",Toast.LENGTH_LONG).show();
                bAdapter.disable();
                return true;
            case R.id.wfi:
                Toast.makeText(this,"You selected the Wifi",Toast.LENGTH_LONG).show();
                return true;
            case R.id.wifioff:
                Toast.makeText(this,"You selected the Wifi OFF",Toast.LENGTH_LONG).show();
                WifiManager wifi = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
                return true;
            case R.id.wifion:
                Toast.makeText(this,"You selected the Wifi ON",Toast.LENGTH_LONG);
                WifiManager wifi1 = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi1.setWifiEnabled(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
