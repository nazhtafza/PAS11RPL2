package com.example.pasganjil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Detail extends AppCompatActivity {
    Realm realm;
    RealmHelper realmHelper;
    ModelRealm TimModel;


    Bundle extras;
    String team;
    String liga;
    String deskripsi;
    String poster;
    String id;

    TextView tvjudul;
    ImageView ivposter;
    TextView tvdesc;
    Button btnbookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        extras = getIntent().getExtras();
        tvjudul = (TextView)findViewById(R.id.tvjudul);
        tvdesc = (TextView)findViewById(R.id.txtdeskripsi);
        ivposter = (ImageView) findViewById(R.id.ivposter);
        btnbookmark = (Button) findViewById(R.id.btnbookmark);

        if (extras != null) {
            team = extras.getString("judul");
            id = extras.getString("id");
            liga = extras.getString("date");
            deskripsi = extras.getString("deskripsi");
            poster = extras.getString("path");
            tvjudul.setText(team);
            tvdesc.setText(deskripsi);
            Glide.with(Detail.this)
                    .load(poster)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivposter);
            // and get whatever type user account id is
        }

        //Set up Realm
        Realm.init(Detail.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        btnbookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimModel = new ModelRealm();
                TimModel.setstrDescriptionEN(deskripsi);
                TimModel.setstrTeam(team);
                TimModel.setstrLeague(liga);
                TimModel.setstrTeamBadge(poster);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(TimModel);

            }
        });
    }
}