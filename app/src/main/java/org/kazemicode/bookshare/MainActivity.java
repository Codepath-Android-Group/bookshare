package org.kazemicode.bookshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds item to the action bar
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item.getItemId() == R.id.logout){
            //icon has been selected
            ParseUser.logOut();
            ParseUser currentUser = ParseUser.getCurrentUser(); //this will be null now
            //go to login activity
            if (currentUser == null){
                Log.i(TAG, "Logged Out...");
                goToLoginActivity();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToLoginActivity (){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}