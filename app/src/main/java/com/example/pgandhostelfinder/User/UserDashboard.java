package com.example.pgandhostelfinder.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pgandhostelfinder.R;
import com.example.pgandhostelfinder.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.example.pgandhostelfinder.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.example.pgandhostelfinder.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.pgandhostelfinder.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.pgandhostelfinder.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.pgandhostelfinder.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler;
    RecyclerView mostViewedRecycler;
    RecyclerView categoriesRecycler;
    RecyclerView.Adapter adapter;
    ImageView menuIcon;
    LinearLayout contentView;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler();
        mostViewedRecycler = findViewById(R.id.mv_recycler);
        mostViewedRecycler();
        categoriesRecycler = findViewById(R.id.categories_recycler);
        categoriesRecycler();
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        navigationDrawer();

    }

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.home_background));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1-diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    private void categoriesRecycler() {
        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();

        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.hostel, "Hostels"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.pg, "PGs"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.flat, "Flats"));

        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setAdapter(adapter);
    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedHelperClasses = new ArrayList<>();

        mostViewedHelperClasses.add(new MostViewedHelperClass(R.drawable.madhav, "Madhav Gurukul", "Grow with Nature. Learn with Nature."));
        mostViewedHelperClasses.add(new MostViewedHelperClass(R.drawable.amikrupa, "AmiKrupa Girls Hostel", "We take care like our own child."));
        mostViewedHelperClasses.add(new MostViewedHelperClass(R.drawable.pushpkamal, "Pushpkamal Boys Hostel", "We have very friendly environment"));
        mostViewedHelperClasses.add(new MostViewedHelperClass(R.drawable.rs, "R. S. Girls Hostel", "We treat them like our daughters."));

        adapter = new MostViewedAdapter(mostViewedHelperClasses);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.avd, "Atmiya Vidhya Dham", "Also known as Harisaurabh hostel. We provide all the facilities."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.madhav, "Madhav Gurukul", "Grow with Nature. Learn with Nature."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.amikrupa, "Ami Krupa Hostel", " We keep girls as our own daughters with atmost care."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.ns, "Narayan Swaroop Residency", "We have friendly atmosphere here."));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }

}
