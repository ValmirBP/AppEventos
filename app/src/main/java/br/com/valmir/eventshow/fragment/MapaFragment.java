package br.com.valmir.eventshow.fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import android.view.View;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import br.com.valmir.eventshow.R;


public class MapaFragment extends Fragment {

    private Context context;

    // public MapFragment() {
        // Required empty public constructor
   // }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mapa, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                mMap.clear(); //clear old markers

                CameraPosition googlePlex = CameraPosition.builder()
                        .target(new LatLng(37.4219999,-122.0862462))
                        .zoom(10)
                        .bearing(0)
                        .tilt(45)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null);

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-22.9504903, -47.05474))
                        .title("IX SEMINÁRIO NACIONAL DO CENTRO DE MEMÓRIA")
                        );

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-22.95096412,-47.05161095))
                        .title("Kotlin everywhare")
                        );

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-22.84731292,-47.08768398))
                        .title("am_be_do"));

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-22.84717945,-47.08618194))
                        .title("Liderança Avançada em Campinas"));
            }
        });


        return rootView;

        private BitmapDescriptor bitmapDescriptor(Context context, int vectorResId); {
            Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
            vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
            Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            vectorDrawable.draw(canvas);
            return BitmapDescriptorFactory.fromBitmap(bitmap);
        }
//
//    MapView mapView;
//    GoogleMap map;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_mapa, container, false);
//
////        // Gets the MapView from the XML layout and creates it
////        mapView = (MapView) v.findViewById(R.id.map);
////        mapView.onCreate(savedInstanceState);
////
////        // Gets to GoogleMap from the MapView and does initialization stuff
////        map = mapView.getMap();
////        map.getUiSettings().setMyLocationButtonEnabled(false);
////        map.setMyLocationEnabled(true);
////
////        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
////        try {
////            MapsInitializer.initialize(this.getActivity());
////        } catch (GooglePlayServicesNotAvailableException e) {
////            e.printStackTrace();
////        }
////
////        // Updates the location and zoom of the MapView
////        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(43.1, -87.9), 10);
////        map.animateCamera(cameraUpdate);
//
//        return v;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        if (getActivity() == null) return;
//        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }
//
//    public static MapaFragment newInstance() {
//        return new MapaFragment();
//    }
//
//    @Override
//    public void onResume() {
//        if (mapView != null)
//            mapView.onResume();
//        super.onResume();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (mapView != null)
//            mapView.onDestroy();
//    }
//
//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        mapView.onLowMemory();
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        map = googleMap;
//
//        // Add a marker in Sydney, Australia, and move the camera.
//        LatLng sydney = new LatLng(-22.847726, -47.087329);
//        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        map.getUiSettings().setMyLocationButtonEnabled(false);
//        // TODO FAZER DEPOIS
////        map.setMyLocationEnabled(true);
//
////        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(43.1, -87.9), 10);
////        map.animateCamera(cameraUpdate);
//    }
}
