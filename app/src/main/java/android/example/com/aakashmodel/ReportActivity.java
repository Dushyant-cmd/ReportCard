package android.example.com.aakashmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        //Declared Custom ArrayAdapter instance
        ReportCardAdapter reportCardAdapter = new ReportCardAdapter(this, Database.getData());

        //Cast ListView(AdapterView) object from activity_report layout resource file to ListView type variable
        //using findViewById(id of View) method of AppCompatActivity class
        ListView listView = (ListView) findViewById(R.id.report_card_list);
        //set Adapter to AdapterView(ListView) object.
        listView.setAdapter(reportCardAdapter);
    }
}