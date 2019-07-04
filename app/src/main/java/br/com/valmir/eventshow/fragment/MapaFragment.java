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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.valmir.eventshow.R;

// Início da Classe

public class MapaFragment extends Fragment {

    private Context context;

   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_mapa, container, false); //>>> Grara tela de mapa

// Habilita o mapa e envia a camera para as coordenada indicadas

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                mMap.clear(); // >>> limpa as marcações antigas

// Ponto inicial da camera

                CameraPosition googlePlex = CameraPosition.builder()
                        .target(new LatLng(-22.95069737, -47.05503613))
                        .zoom(10)
                        .bearing(0)
                        .tilt(45)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null);

// coordenadas dos eventos

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-22.9504903, -47.05474))
                        .title("IX SEMINÁRIO NACIONAL DO CENTRO DE MEMÓRIA")
                );

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-22.95096412, -47.05161095))
                        .title("Kotlin everywhare")
                );

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-22.84731292, -47.08768398))
                        .title("am_be_do"));

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-22.84717945, -47.08618194))
                        .title("Liderança Avançada em Campinas"));
            }
        });

        return rootView;
    }

    // TODO entender e comentar

    private BitmapDescriptor bitmapDescriptor(Context context,int vectorResId){
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public static MapaFragment newInstance() {
        return new MapaFragment();
    }
}