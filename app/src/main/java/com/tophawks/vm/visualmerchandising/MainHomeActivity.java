package com.tophawks.vm.visualmerchandising;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tophawks.vm.visualmerchandising.Activities.StockManagementHomePage;
import com.tophawks.vm.visualmerchandising.Activities.VisualMerchandisingHomePage;
import com.tophawks.vm.visualmerchandising.Modules.AttendanceManagement.AttendanceHomeActivity;
import com.tophawks.vm.visualmerchandising.Modules.SalesManagement.SalesHomeActivity;

public class MainHomeActivity extends AppCompatActivity {

    private Button attendanceButton;
    private Button salesButton;
    private Button stockButton;
    private Button vmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        attendanceButton = (Button) findViewById(R.id.attendancebutton);
        salesButton = (Button) findViewById(R.id.salesbutton);
        stockButton = (Button) findViewById(R.id.stockbutton);
        vmButton = (Button) findViewById(R.id.vmbutton);

        attendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AttendanceHomeActivity.class);
                startActivity(intent);
            }
        });

        salesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalesHomeActivity.class);
                startActivity(intent);
            }
        });

        stockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StockManagementHomePage.class);
                startActivity(intent);
            }
        });

        vmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VisualMerchandisingHomePage.class);
                startActivity(intent);
            }
        });

    }
}
