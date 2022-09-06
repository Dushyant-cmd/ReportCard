package android.example.com.aakashmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**setListeners() method add listeners on couple of Views in activity_main file by cast object to variable
         * and setOnClickListener and pass interface that is called by android on click event or other input
         * event and override corresponding method */
        setListeners();

        /**Set data in the ArrayList of ReportCard class instance type */
        if(Database.i <= 0) {//with this condition Recycler View List Item data object only add in ArrayList for once
            //because onCreate() only called by android when app is launched for first time and intent pass for
            // action main and MainActivity have Intent-Filter tag with action tag and name attribute value
            // android.intent.action.MAIN and category tag with name attribute android.intent.category.LAUNCHER.
            Database.setData();
            Database.i += 1;

        }

        /**Create instance for custom Adapter class ReportCardAdapter
         * @param context context is the instance of activity component so the Adapter will use activity theme
         * @param data it is ArrayList contains couple of ReportCard class objects stored data and allow to access
         * for View item in Recycler View List in MainActivity layout resource file named activity_main.xml */
        ArrayList<ReportCard> data = new ArrayList<>();
        data.add(new ReportCard("Dushyant", "A", "B", "C"));
        data.add(new ReportCard("Nikhil", "A", "B", "C"));
        data.add(new ReportCard("Gaurav", "A", "B", "C"));
        data.add(new ReportCard("Ajit", "A", "B", "C"));
        data.add(new ReportCard("Aman", "A", "B", "C"));
        data.add(new ReportCard("Harsh", "A", "B", "C"));

        ReportCardAdapter reportCardAdapter = new ReportCardAdapter(this, data);

        ListView adapterViewForMain = (ListView) findViewById(R.id.mainReportCardList);
        adapterViewForMain.setAdapter(reportCardAdapter);
    }

    public void setListeners() {
        /**ALL TextView in activity_main object casting to variable by find it from View hierarchy by id */
        TextView allTextView = (TextView) findViewById(R.id.all);
        /**setOnClickListener for click input event and Override onClick method with View v(input param) */
        allTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**Explicit intent(intent object pass to android to open an Activity component within same
                 * package with exact name of component for example you want to open new activity then pass
                 * byte code(.class) file of activity in intent constructor function)
                 * @param context context of app(instance of activity to use all style or theme that activity
                 * is using or inheriting
                 * @param activity name with .class extention is byte code file is Activity component in app
                 * call startActivity with intent object in params that start that activity*/
                Intent intentForReportActivity = new Intent(getApplicationContext(), ReportActivity.class);
                startActivity(intentForReportActivity);
            }
        });

        /**Create object for add button with casting using findViewById(id of view) */
        Button addBtn = (Button) findViewById(R.id.add_report_cards);
        /** SetOnClickListeners and Override onClick() method*/
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Explicit Intent(android.content class) instance with context and Activity component byte code
                //file to open it when addBtn click
                Intent intentForAddActivity = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intentForAddActivity);
            }
        });

        /**Button object by casting return object from findViewById(id of View in layout file) for remove button */
        Button removeBtn = (Button) findViewById(R.id.remove_report_cards);
        /**setOnClickListener and override input event default interface method */
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Explicit Intent class object(instance) to open RemoveActivity component
                Intent intentForRemoveActivity = new Intent(getApplicationContext(), RemoveActivity.class);
                startActivity(intentForRemoveActivity);
            }
        });
    }
}