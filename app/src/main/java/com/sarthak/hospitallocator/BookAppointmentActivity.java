package com.sarthak.hospitallocator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.sarthak.hospitallocator.activities.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BookAppointmentActivity extends AppCompatActivity {

    private TimePicker timePicker1;
    Button btnbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
btnbook = findViewById(R.id.btnbook);
        CalendarView v = new CalendarView( this );
        v.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public GregorianCalendar calendar;

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                this.calendar = new GregorianCalendar( year, month, dayOfMonth );


            }

        });

        timePicker1.is24HourView();
        timePicker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                int hour = timePicker.getCurrentHour();
                int min = timePicker.getCurrentMinute();
            }
        });

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookAppointmentActivity.this, "Booking is Confirmed", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

    }
}
