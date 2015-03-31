package ppla01.the_angkoters_depok;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements GoogleMap.OnMapClickListener, View.OnClickListener {
    GoogleMap googleMap;
    MarkerOptions markerOptions;
    LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        googleMap = mapFragment.getMap();

        googleMap.setOnMapClickListener(this);
        
        Button btn_nearby = (Button) findViewById(R.id.btn_nearby);
        btn_nearby.setOnClickListener(this);
    }

    @Override
    public void onMapClick(LatLng latLngIn) {
        latLng = latLngIn;

        googleMap.clear();

        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        googleMap.addMarker(markerOptions);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_nearby : new NearbyAngkotTask(getBaseContext()).execute(latLng);
        }
    }

    private class NearbyAngkotTask extends AsyncTask<LatLng, Void, String> {
        Context context;

        InputStream is = null ;

        public NearbyAngkotTask(Context baseContext) {
            context = baseContext;
        }

        @Override
        protected String doInBackground(LatLng... latLngs) {
            String result = "";
            double lat = latLngs[0].latitude;
            double lng = latLngs[0].longitude;

            try {
                String url = new String("http://the-angkoters-depok.com/index.php?action=nearby&lat=" + lat + "&lng=" + lng);

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);

                ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();

                httpPost.setEntity(new UrlEncodedFormEntity(param));

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();

                is =  httpEntity.getContent();
            } catch (Exception e) {
                // TODO: handle exception
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                String line = "";
                while((line = br.readLine())!=null) {
                    sb.append(line+"\n");
                }
                is.close();
                result = sb.toString();
            } catch (Exception e) {
                // TODO: handle exception
                Log.e("log_tag", "Error converting result "+e.toString());
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            /*try {
                JSONArray jsonArray = new JSONArray(result);
                String res = "";
                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = null;
                    jsonObject = jsonArray.getJSONObject(i);

                    res += jsonObject.getString("name");
                }
                TextView textView = (TextView) findViewById(R.id.text);
                textView.setText(res);
            } catch (Exception e) {
                // TODO: handle exception
                Log.e("log_tag", "Error parsing data "+e.toString());
            }*/
            Toast.makeText(context, "Finsih PHP", Toast.LENGTH_SHORT).show();
        }
    }
}
