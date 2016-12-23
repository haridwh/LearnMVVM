package com.skday.learnmvvm.SharedPrefs;

import android.content.Context;

import com.skday.learnmvvm.dao.DaoTask;

/**
 * Created by skday on 12/23/16.
 */

public class PrefTask {
    public static final String PREF_NAME = "Pref_Task";
    public static final String TASK = "Task";

    public static void setTask(DaoTask listTask, Context ctx){
        ComplexPreferences complexPreferences =
                ComplexPreferences.getComplexPreferences(ctx, PREF_NAME, 0);
        complexPreferences.putObject(TASK, listTask);
        complexPreferences.commit();
    }

    public static DaoTask getTask(Context ctx){
        ComplexPreferences complexPreferences =
                ComplexPreferences.getComplexPreferences(ctx,PREF_NAME,0);
        return complexPreferences.getObject(TASK, DaoTask.class);
    }

    public static String getJSON(Context ctx){
        ComplexPreferences complexPreferences =
                ComplexPreferences.getComplexPreferences(ctx, PREF_NAME, 0);
        return complexPreferences.getJSON(TASK);
    }

    public static void clearTask(Context ctx){
        ComplexPreferences complexPreferences =
                ComplexPreferences.getComplexPreferences(ctx, PREF_NAME, 0);
        complexPreferences.clearObject();
        complexPreferences.commit();
    }
}
