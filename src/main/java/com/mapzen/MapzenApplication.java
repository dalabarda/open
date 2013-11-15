package com.mapzen;

import android.app.Application;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

public class MapzenApplication extends Application {

    // default to Reykjavik
    public static double[] DEFAULT_COORDINATES =  {
            Double.parseDouble("64.133333") * 1E6,
            Double.parseDouble("-21.933333") * 1E6
    };

    public static String LOG_TAG = "Mapzen: ";

    private static Location location;
    public static Location getLocation(Context context) {
        if(location == null) {
            LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String provider = locationManager.getBestProvider(criteria, false);
            location = locationManager.getLastKnownLocation(provider);
        }
        return location;
    }
}
