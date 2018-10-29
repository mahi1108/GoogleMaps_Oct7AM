package cubex.mahesh.googlemaps_oct7am

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sFrag = supportFragmentManager.
                findFragmentById(R.id.frag1) as SupportMapFragment
        sFrag.getMapAsync(object:OnMapReadyCallback{
            override fun onMapReady(gMap: GoogleMap?) {

                gMap!!.mapType = GoogleMap.MAP_TYPE_NORMAL

                var lManager:LocationManager = getSystemService(
                        Context.LOCATION_SERVICE) as LocationManager
                lManager.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        1000.toLong(),1.toFloat(),
                        object : LocationListener {
                            override fun onLocationChanged(l: Location?) {
                                    var lati = l!!.latitude
                                    var longi = l!!.longitude

                                var options:MarkerOptions = MarkerOptions()
                                options.position(LatLng(lati,longi))
                                gMap.addMarker(options)

                            }

                            override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
                            }

                            override fun onProviderEnabled(p0: String?) {
                            }

                            override fun onProviderDisabled(p0: String?) {
                            }

                        })

            }
        })
    }
}
