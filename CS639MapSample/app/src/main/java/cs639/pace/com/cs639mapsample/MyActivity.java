package cs639.pace.com.cs639mapsample;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MyActivity extends FragmentActivity implements LocationListener{

    private  LocationManager mLocationManager;

    public static String getBestProvider(LocationManager locationManager){
        Criteria criteria = new Criteria();
        criteria.setAccuracy(criteria.ACCURACY_COARSE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setCostAllowed(true);
        return locationManager.getBestProvider(criteria,true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mLocationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        String provider = getBestProvider(mLocationManager);
        mLocationManager.requestLocationUpdates(provider, 60000, 100, this);

        MapFragment fragment = (MapFragment)this.getFragmentManager().findFragmentById(R.id.map_fragment);

        LatLng latlng = new LatLng(40.734641, -73.996181);
        float zoomlevel = 10.0f;
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latlng, zoomlevel);
        fragment.getMap().animateCamera(cameraUpdate);

        MarkerOptions marker = new MarkerOptions();
        marker.position(latlng);
        fragment.getMap().addMarker(marker);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
