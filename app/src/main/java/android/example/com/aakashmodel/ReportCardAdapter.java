package android.example.com.aakashmodel;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ReportCardAdapter extends ArrayAdapter<ReportCard>{
    /**getView method of ArrayAdapter it is method that called by AdapterView(ListView, GridView) by default when
     * a View item coming on screen and pass position of item, scrabview and parent view(Adapter View) in input
     * params*/
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;//convertView is ScrabView passed by AdapterView(ListView, GridView etc.)
        if(listItemView == null) {//If scrab view is null then inflate new item layout object hierarchy and store
            //in listItemView variable which points to root element of layout object hierarchy of item in Recycler
            //View List
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.report_card_item, parent, false);
        }

        //Get currentReportCard item data object from data source in the ReportCardAdapter object using getItem(index)
        //method
        ReportCard currentReportCard = getItem(position);

        //TextView object by casting of findViewById(id of View from item layout View Hierarchy) for name of student
        TextView name = (TextView) listItemView.findViewById(R.id.name);
        //change name state value with currentReportCard object name variable value
        name.setText("Name: " + currentReportCard.getName());

        //TextView object for C++ grade
        TextView cPlusPlus = (TextView) listItemView.findViewById(R.id.cPlusPlus);
        //TextView text attribute value with currentReportCard cPlusPlus variable value
        cPlusPlus.setText("C++ Grade: " + currentReportCard.getCPlusPlus());

        //TextView object for C++ grade
        TextView python = (TextView) listItemView.findViewById(R.id.python);
        //TextView text attribute value with currentReportCard cPlusPlus variable value
        python.setText("Python Grade: " + currentReportCard.getPython());

        //TextView object for C++ grade
        TextView java = (TextView) listItemView.findViewById(R.id.java);
        //TextView text attribute value with currentReportCard cPlusPlus variable value
        java.setText("Java Grade: " + currentReportCard.getJava());

        //Return listItemView that reference to root of item layout object hierarchy
        return listItemView;
    }

    /**Constructor function of custom adapter with context(instance of activity where the adapter instance
     * declared and datasource from which the item View object hierarchy generated */
    public ReportCardAdapter(Context context, ArrayList<ReportCard> dataOfReportCard) {
        super(context, 0, dataOfReportCard);
    }
}
