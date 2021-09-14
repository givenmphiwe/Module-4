package given.Consultants.moveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Property;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        findViewById(R.id.users).setOnClickListener(this);
        findViewById(R.id.property).setOnClickListener(this);
        findViewById(R.id.trucks).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.users) {
            //open a new activity
            Intent intent = new Intent(this, Sign_in.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.property){
            //opening a new activity for property
            Intent intent1 = new Intent(this, Property_sign_in.class);
            startActivity(intent1);
        }

        if (view.getId() == R.id.trucks){
            //opening a new activity for property
            Intent intent2 = new Intent(Intent.ACTION_SEND);
            intent2.setType("text/plain");
            String Body = "Support Moveit";
            String Sub = "The learning process";
            intent2.putExtra(Intent.EXTRA_TEXT, Body);
            intent2.putExtra(Intent.EXTRA_TEXT, Sub);
            startActivity(Intent.createChooser(intent2,"Share"));
        }
    }
}
