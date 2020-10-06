package com.ncoder.mymensinghguide;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import pl.droidsonroids.gif.GifImageView;

public class Emergency extends AppCompatActivity {
    ImageButton btn;
    private TextView textView;
    public WebView wb;

    GifImageView loadingGif,live;
    String identity="";

    public EditText edtphncall;
    String telNum;
    ImageButton btnphncall;

    LinearLayout noInternetLayout;
    LinearLayout webViewLinearLayout;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        Objects.requireNonNull(getSupportActionBar()).hide();





        noInternetLayout = findViewById(R.id.noInternetID);
        webViewLinearLayout = findViewById(R.id.WebViewLayoutID);
        webViewLinearLayout.setVisibility(View.VISIBLE);


        //code for initializing loading layout
        loadingGif =  findViewById(R.id.gif_loadingID);
        live = findViewById(R.id.gif_liveID);




        /* code for continuously checking internet connection starts*/

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isNetworkConnected())
                {
                    noInternetLayout.setVisibility(View.GONE);
                    live.setVisibility(View.VISIBLE);
                    webViewLinearLayout.setVisibility(View.VISIBLE);
                }
                else
                {
                    live.setVisibility(View.GONE);
                    webViewLinearLayout.setVisibility(View.GONE);
                    noInternetLayout.setVisibility(View.VISIBLE);

                }
                handler.postDelayed(this, 2000);
            }
        }, 5000);

        /* code for continuously checking internet connection ends*/




        //code for back button
        btn=findViewById(R.id.backButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wb.canGoBack())
                {
                    if(isNetworkConnected())
                    {
                        wb.goBack();
                        live.setVisibility(View.VISIBLE);
                    }else
                    {
                        live.setVisibility(View.GONE);
                        Toast.makeText(Emergency.this, "সংযোগ বিচ্ছিন্ন হয়ে গেছে !!", Toast.LENGTH_SHORT).show();
                    }
                }else {

                    if(isNetworkConnected())
                    {
                        live.setVisibility(View.VISIBLE);
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
                        finish();

                    }else
                    {
                        live.setVisibility(View.GONE);
                        Toast.makeText(Emergency.this, "সংযোগ বিচ্ছিন্ন হয়ে গেছে !!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        /*code for web view **/

        wb=findViewById(R.id.wb_about);
        WebSettings webSettings =wb.getSettings();
        webSettings.setJavaScriptEnabled(true);


        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);

        wb.setWebChromeClient(new Emergency.MyChrome());



        /*code for zoom started **/

        wb.getSettings().setSupportZoom(true);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.getSettings().setDisplayZoomControls(false);

        /* code for zoom ended **/


        //location starts
        wb.getSettings().setGeolocationEnabled(true);
        wb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);


        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        },0);




        //location ends

        /* code for no internet connection **/

        wb.setWebViewClient(new WebViewClient(){


            //location starts
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                wb.loadUrl(url);
                return true;
            }
            //location ends
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl){
                wb.loadUrl("file:///android_asset/error_emergency.html");
                Toast.makeText(Emergency.this, "সংযোগ বিচ্ছিন্ন হয়ে গেছে !!", Toast.LENGTH_SHORT).show();
            }
        });


        /* code for full screen **/
        if (savedInstanceState==null)
        {
            wb.post(new Runnable() {
                @Override
                public void run() {

                    wb.loadUrl("https://shebaabd24.blogspot.com/p/emergency.html");
                }
            });
        }
        /* code for full screen **/

        textView=findViewById(R.id.txt);



        /* code for calling **/
        edtphncall=findViewById(R.id.edtphncall);
        btnphncall= findViewById(R.id.btnphncall);
        btnphncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_CALL);
                telNum = edtphncall.getText().toString();

                if (telNum.length()==0) {

                    edtphncall.setError("কোনো ফোন নাম্বার প্রবেশ করান নি !!");
                    Toast.makeText(Emergency.this, "কোনো ফোন নাম্বার প্রবেশ করান নি !!", Toast.LENGTH_SHORT).show();
                    //intentCall.setData(Uri.parse("tel:0000"));
                    //Toast.makeText(getApplicationContext(),"Please Enter Num",Toast.LENGTH_SHORT).show();

                } else {
                    if(telNum.length()==11)
                    {
                        identity = telNum.substring( 0,3 );
                        if(identity.contains( "017" ) || identity.contains( "016" )
                                || identity.contains( "018" ) || identity.contains( "019" ) || identity.contains( "013" )
                        ){
                            intentCall.setData(Uri.parse("tel:" + telNum));
                            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                Toast.makeText(getApplicationContext(), "Please grant permission", Toast.LENGTH_SHORT).show();
                                requestPermission();
                            } else {
                                startActivity(intentCall);
                            }
                        }else{
                            edtphncall.setError("ভুল নাম্বার প্রবেশ করিয়েছেন !");
                            Toast.makeText(Emergency.this, "ভুল নাম্বার প্রবেশ করিয়েছেন !", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        edtphncall.setError("ভুল নাম্বার প্রবেশ করিয়েছেন !");
                        Toast.makeText(Emergency.this, "ভুল নাম্বার প্রবেশ করিয়েছেন !", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });

    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(Emergency.this, new String[]{Manifest.permission.CALL_PHONE}, 1);

    }



    /** code for full screen **/
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState )
    {
        super.onSaveInstanceState(outState);
        wb.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        wb.restoreState(savedInstanceState);
    }



    private class MyChrome extends WebChromeClient {

        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        //location starts

        @Override
        public void onGeolocationPermissionsShowPrompt(String origin, android.webkit.GeolocationPermissions.Callback callback){
            Log.d("Location","callback");
            callback.invoke(origin,true,false);
        }

        //location ends



        /**code for progress bar starts**/

        public void onProgressChanged(WebView view, int progress)
        {
            /* Make the bar disappear after URL is loaded, and changes string to Loading... */
            if (progress!=100)
            {

                textView.setText("লোড হচ্ছে.......");
                live.setVisibility(View.GONE);
                loadingGif.setVisibility(View.VISIBLE);
                setProgress(progress * 100);

            }
            if (progress==100)
            {
                textView.setText("");
                loadingGif.setVisibility(View.GONE);
                live.setVisibility(View.VISIBLE);
            }
        }
        /**code for progress bar ended**/


        public Bitmap getDefaultVideoPoster()
        {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView()
        {
            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
        {
            if (this.mCustomView != null)
            {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }
    /* code for full screen  ended**/


    /* code for back pressed started **/

    /** code for back pressed started **/

    @Override public void onBackPressed()
    {
        if (wb.canGoBack())
        {
            wb.goBack();
        }
        else
        {
            // super.onBackPressed();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slider_1,R.anim.slider_2);
            finish();
        }
    }
    /** code for back pressed ended **/

    /* function for checking net connection */
    private boolean isNetworkConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Emergency.CONNECTIVITY_SERVICE);
        assert cm != null;
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}