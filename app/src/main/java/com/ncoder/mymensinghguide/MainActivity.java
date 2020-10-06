package com.ncoder.mymensinghguide;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    
    LinearLayout emergency,travel,doctor,bank,food,place,education,hotel,fastFood,shopping,about,developer;

    LinearLayout holderLayout,ExitScreen;

    TextView yes,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        holderLayout = findViewById(R.id.mainHolder);
        holderLayout.setVisibility(View.VISIBLE);
        ExitScreen = findViewById(R.id.exitID);
        ExitScreen.setVisibility(View.GONE);
        
        emergency = findViewById(R.id.emergencyID);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),Emergency.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        travel = findViewById(R.id.travelID);
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),TravelSection.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        doctor = findViewById(R.id.doctorID);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),Doctor.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });


        bank = findViewById(R.id.bankID);
        bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),BankSection.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });


        food = findViewById(R.id.famousFoodID);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),FamousFood.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });


        place = findViewById(R.id.famousPlaceID);
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),FamousPlace.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });



        education = findViewById(R.id.educationID);
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),EducationSection.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });


        hotel = findViewById(R.id.hotelID);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),HotelSection.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fastFood = findViewById(R.id.fastfoodID);
        fastFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),FastFoodsection.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });


        shopping = findViewById(R.id.shoppingID);
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),ShoppingSection.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        about = findViewById(R.id.aboutID);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    Intent intent = new Intent(getApplicationContext(),AboutSection.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        developer = findViewById(R.id.developerID);
        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkConnected())
                {
                    String url = "https://nahindcoder.blogspot.com";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    overridePendingTransition(R.anim.myanim2,R.anim.slider_2);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ইন্টারনেট সংযোগ নেই !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        


        yes = findViewById(R.id.yesTextID);
        no = findViewById(R.id.noTextID);
    }


    /* function for checking net connection */
    private boolean isNetworkConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
        assert cm != null;
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    @Override
    public void onBackPressed() {

            holderLayout.setVisibility(View.GONE);
            ExitScreen.setVisibility(View.VISIBLE);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityCompat.finishAffinity(MainActivity.this);
                    overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                    finish();
                }
            });

            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ExitScreen.setVisibility(View.GONE);
                    holderLayout.setVisibility(View.VISIBLE);
                }
            });




    }
}