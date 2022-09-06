package android.example.com.aakashmodel;

import java.util.ArrayList;
import android.example.com.aakashmodel.ReportCard;
import android.util.Log;

public class Database {
    static int i = 0;
    //Data source for Recycler View List Adapter(in our case custom Adapter named ReportCardAdapter)
    static ArrayList<ReportCard> data = new ArrayList<>();//It must static to accessed anywhere just be the class

    //store ReportCard(for View item data) custom class objects in data(ArrayList)
    public static void setData() {
        data.add(new ReportCard("Dushyant", "A", "B", "C"));
        data.add(new ReportCard("Nikhil", "A", "B", "C"));
        data.add(new ReportCard("Gaurav", "A", "B", "C"));
        data.add(new ReportCard("Ajit", "A", "B", "C"));
        data.add(new ReportCard("Aman", "A", "B", "C"));
        data.add(new ReportCard("Harsh", "A", "B", "C"));
        data.add(new ReportCard("Abhishek", "A", "B", "C"));
        data.add(new ReportCard("Dristi", "A", "B", "C"));
        data.add(new ReportCard("Aditya", "A", "B", "C"));
        data.add(new ReportCard("Yadav", "A", "B", "C"));
    }

    //return the data ArrayList of ReportCard type and its also static to be called from anywhere in package
    //just by Database class name so we don't have to create new instance to use ArrayList again and again
    public static ArrayList<ReportCard> getData() {
        return data;
    }

    /**Add ReportCard class instance in the data(ArrayList of ReportCard type) and pass input params in constructor
     * of ReportCard class constructor
     * @param name name of student in report card
     * @param cPlusPlus c++ grade of student
     * @param python python grade
     * @param java java grade*/
    public static void addReportCard(String name, String cPlusPlus, String python, String java) {
        data.add(new ReportCard(name, cPlusPlus, python, java));
    }

    /**This method to remove object from data ArrayList for input parameter object
     * @param name name of student to remove ReportCard*/
    public static void removeReportCard(String name) {
        for(int i=0; i<data.size(); i++) {
            String nameInReportCard = data.get(i).getName();
            if(nameInReportCard.equals(name)) {
                data.remove(data.get(i));
                break;
            };
        }
    }
}
