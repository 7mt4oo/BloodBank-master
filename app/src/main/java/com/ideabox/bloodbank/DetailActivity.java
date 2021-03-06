package com.ideabox.bloodbank;

import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    DonerData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra("Id", 0);
        data = dbHelper.getDonerDetail(this, id);

        TextView name = (TextView) findViewById(R.id.name);
        TextView bloodgrp = (TextView) findViewById(R.id.bloodgrp);
        TextView phone = (TextView) findViewById(R.id.phone);
        TextView email = (TextView) findViewById(R.id.email);
        TextView city = (TextView) findViewById(R.id.city);
        TextView area = (TextView) findViewById(R.id.area);
        TextView addr = (TextView) findViewById(R.id.addr);

        name.setText(data.full_name);
        bloodgrp.setText(bloodgrp.getText() + data.bloodgrp);
        phone.setText(phone.getText() + data.phone);
        email.setText(email.getText() + data.email);
        city.setText(city.getText() + data.city);
        area.setText(area.getText() + data.area);
        addr.setText(addr.getText() + data.addr);

    }

    public void call(View v) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + data.phone));
        startActivity(intent);

    }
}
