package com.sarthak.hospitallocator;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.sarthak.hospitallocator.activities.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BookAppointmentActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    private TimePicker timePicker1;
    Button btnbook;
    String time  = "15:30";
    String date = "19:06:2018";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        databaseHelper = new DatabaseHelper(this);

        Intent intent  =  getIntent();
        final String place =  intent.getStringExtra("place");
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        btnbook = findViewById(R.id.btnbook);

//        CalendarView v = new CalendarView( this );
//        v.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
//            public GregorianCalendar calendar;
//
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                this.calendar = new GregorianCalendar( year, month, dayOfMonth );
//
//                String y = String.valueOf(year);
//                String m = String.valueOf(month);
//                String d= String.valueOf(dayOfMonth);
//                date =  d+":"+m+":"+y;
//
//            }
//
//        });

        DatePicker datePicker = (DatePicker) findViewById(R.id.calendarView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                    int day = datePicker.getDayOfMonth();
                    int month = datePicker.getMonth() + 1;
                    int year = datePicker.getYear();

                    String y = String.valueOf(year);
                    String m = String.valueOf(month);
                    String d= String.valueOf(day);
                    date =  d+":"+m+":"+y;

                }
            });
        }

        timePicker1.is24HourView();
        timePicker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                int hour = timePicker.getCurrentHour();
                int min = timePicker.getCurrentMinute();

                String h = String.valueOf(hour);
                String m = String.valueOf(min);
                time = h+":"+m;

            }
        });

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = databaseHelper.insertData(place, date, time);
                if(check){
                    Toast.makeText(BookAppointmentActivity.this, "Appointment is Confirmed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(BookAppointmentActivity.this, "Please try again later", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }

            }
        });

    }
}
