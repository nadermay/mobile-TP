package com.example.users;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    SharedPreferences share;
    public static final String pref = "pref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameinput);
        email = findViewById(R.id.emailinput);

        share = getSharedPreferences(pref, Context.MODE_PRIVATE);

        if (share.contains(Name)) {
            name.setText(share.getString(Name, ""));
        }
        if (share.contains(Email)) {
            email.setText(share.getString(Email, ""));
        }
    }


    public void Save(View v) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = share.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.apply();
    }


    public void Clear(View v) {
        SharedPreferences.Editor editor = share.edit();
        editor.remove(Name);
        editor.remove(Email);
        editor.apply();
        name.setText("");
        email.setText("");
    }


    public void Get(View v) {
        if (share.contains(Name)) {
            name.setText(share.getString(Name, ""));
        }
        if (share.contains(Email)) {
            email.setText(share.getString(Email, ""));
        }
    }
}
