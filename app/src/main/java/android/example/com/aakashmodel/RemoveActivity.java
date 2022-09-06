package android.example.com.aakashmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RemoveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        //submit button for remove report card in layout resource file for RemoveActivity.java
        Button submitBtn = (Button) findViewById(R.id.remove_report_card);
        //set Listener and override onClick method of OnClickListener whenever click even occur on submitBtn View
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeReportCard();
            }
        });
    }

    public void removeReportCard() {
        //name EditText input field for user to type name of report card student
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        //store EditText input field user input in String type variable
        String name = nameEditText.getText().toString();

        //condition to avoid executing Database removeReportCard() method for nothing
        if(name.length() >= 1) {
            Database.removeReportCard(name);
            //Intent class explicit intent to MainActivity (Activity component) in same package
            Intent intentForMainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intentForMainActivity);
            //popup message using Toast class makeText() method
            Toast.makeText(getApplicationContext(), name + " Report Card Removed Successfully", Toast.LENGTH_LONG).show();

        } else {
            //TextView object for problem_dialog view in activity_remove.xml by casting return object of findView
            //ById(id of view) method and setVisibility with View.VISIBLE.
            TextView problemTextView = (TextView) findViewById(R.id.problem_dialog_remove);
            problemTextView.setText("*Problem: One or More Fields are Blank");
            problemTextView.setVisibility(View.VISIBLE);
        }
    }
}