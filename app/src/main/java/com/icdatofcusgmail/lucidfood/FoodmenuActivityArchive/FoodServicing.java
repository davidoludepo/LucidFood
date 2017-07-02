package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by DAVID OGUNDEPO on 04/12/2017.
 *
 */

public class FoodServicing extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     *  @params 'name Used to name the worker thread, important only for debugging.
     *
     */
    public FoodServicing() {
        super("FoodServicing");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("FoodServicing","onStartCommand invoked");
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        Log.d("FoodServicing","onDestroy invoked");
        super.onDestroy();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("FoodServicing","onBind invoked");
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("FoodServicing","The Service has started ");
    }
}
