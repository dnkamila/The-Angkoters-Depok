package ppla01.the_angkoters_depok;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class MainActivity extends FragmentActivity {
    GoogleMap googleMap;
    MarkerOptions markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        googleMap = mapFragment.getMap();

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                googleMap.clear();

                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                googleMap.addMarker(markerOptions);

                new ReverseGeocodingTask(getBaseContext()).execute(latLng);
            }
        });
    }

    private class ReverseGeocodingTask extends AsyncTask<LatLng, Void, String> {
        Context mContext;

        public ReverseGeocodingTask(Context context){
            super();
            mContext = context;
        }

        // Finding address using reverse geocoding
        @Override
        protected String doInBackground(LatLng... params) {
            Geocoder geocoder = new Geocoder(mContext);
            double latitude = params[0].latitude;
            double longitude = params[0].longitude;

            List<Address> addresses = null;
            String addressText="";

            try {
                addresses = geocoder.getFromLocation(latitude, longitude,1);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(addresses != null && addresses.size() > 0 ){
                Address address = addresses.get(0);

                addressText = String.format("%s, %s, %s",
                        address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
                        address.getLocality(),
                        address.getCountryName());
            }

            return addressText;
        }

        @Override
        protected void onPostExecute(String addressText) {
            TextView textView = (TextView) findViewById(R.id.location);
            textView.setText(addressText);
        }
    }
}
