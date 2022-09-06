package android.example.com.aakashmodel;

public class ReportCard {
    private String mName;

    private String mCPlusPlus;

    private String mPython;

    private String mJava;

    public String getName() {
        return mName;
    }

    public String getCPlusPlus() {
        return mCPlusPlus;
    }

    public String getPython() {
        return mPython;
    }

    public String getJava() {
        return mJava;
    }

    public ReportCard(String name, String CPlusPlus, String python, String java) {
        mName = name;
        mCPlusPlus = CPlusPlus;
        mPython = python;
        mJava = java;
    }
}
