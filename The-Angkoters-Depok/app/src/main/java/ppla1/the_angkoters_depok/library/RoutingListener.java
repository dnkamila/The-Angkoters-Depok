package ppla1.the_angkoters_depok.library;

import com.google.android.gms.maps.model.PolylineOptions;

public interface RoutingListener {
    public void onRoutingFailure();

    public void onRoutingStart();

    public void onRoutingSuccess(PolylineOptions mPolyOptions, Route route);
}
