package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.android.internal.location.DummyLocationProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocationManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.548 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "172E00EA90AE9807366F5CA34B42799B")

    private ILocationManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.548 -0400", hash_original_field = "E2A11423CD47DDE43A56192D7AD5E343", hash_generated_field = "742B121B28E1A48FAD5F8ACEACDE3984")

    private HashMap<GpsStatus.Listener, GpsStatusListenerTransport> mGpsStatusListeners = new HashMap<GpsStatus.Listener, GpsStatusListenerTransport>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.548 -0400", hash_original_field = "6E4D80FCEA0E3887597BCFB0AAD138B3", hash_generated_field = "CDD45DA3F786FB6AA5CAF5B1A5D243F0")

    private HashMap<GpsStatus.NmeaListener, GpsStatusListenerTransport> mNmeaListeners = new HashMap<GpsStatus.NmeaListener, GpsStatusListenerTransport>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.566 -0400", hash_original_field = "32B45E8E9C286292F46EB969FF97E787", hash_generated_field = "062AA9FDB4B95D55755F53EFFC68E2B9")

    private GpsStatus mGpsStatus = new GpsStatus();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.566 -0400", hash_original_field = "64782091A962E40B4E33605344BA5307", hash_generated_field = "806CFA905E48C4B7D75890759825B149")

    private HashMap<LocationListener,ListenerTransport> mListeners = new HashMap<LocationListener,ListenerTransport>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.567 -0400", hash_original_method = "1755E60A5AAD43AA8D18158DFDE91956", hash_generated_method = "2E87374DE599AAD38A38C4273DFE7501")
    public  LocationManager(ILocationManager service) {
        mService = service;
        // ---------- Original Method ----------
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.569 -0400", hash_original_method = "F4540EAD4F3CF2106C64C62C1DCA569C", hash_generated_method = "60A4C1E446B0C1A7268F8C79D29AB960")
    private LocationProvider createProvider(String name, Bundle info) {
        LocationProvider varB4EAC82CA7396A68D541C85D26508E83_297427710 = null; //Variable for return #1
        DummyLocationProvider provider;
        provider = new DummyLocationProvider(name, mService);
        provider.setRequiresNetwork(info.getBoolean("network"));
        provider.setRequiresSatellite(info.getBoolean("satellite"));
        provider.setRequiresCell(info.getBoolean("cell"));
        provider.setHasMonetaryCost(info.getBoolean("cost"));
        provider.setSupportsAltitude(info.getBoolean("altitude"));
        provider.setSupportsSpeed(info.getBoolean("speed"));
        provider.setSupportsBearing(info.getBoolean("bearing"));
        provider.setPowerRequirement(info.getInt("power"));
        provider.setAccuracy(info.getInt("accuracy"));
        varB4EAC82CA7396A68D541C85D26508E83_297427710 = provider;
        addTaint(name.getTaint());
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_297427710.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_297427710;
        // ---------- Original Method ----------
        //DummyLocationProvider provider =
            //new DummyLocationProvider(name, mService);
        //provider.setRequiresNetwork(info.getBoolean("network"));
        //provider.setRequiresSatellite(info.getBoolean("satellite"));
        //provider.setRequiresCell(info.getBoolean("cell"));
        //provider.setHasMonetaryCost(info.getBoolean("cost"));
        //provider.setSupportsAltitude(info.getBoolean("altitude"));
        //provider.setSupportsSpeed(info.getBoolean("speed"));
        //provider.setSupportsBearing(info.getBoolean("bearing"));
        //provider.setPowerRequirement(info.getInt("power"));
        //provider.setAccuracy(info.getInt("accuracy"));
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.581 -0400", hash_original_method = "4EC410201344BFF6367B3FC4DEB2ECDD", hash_generated_method = "FF7574551AE7CB28665D3FA15DC92639")
    public List<String> getAllProviders() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_327922429 = null; //Variable for return #1
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1183422108 = null; //Variable for return #2
        {
            Log.d(TAG, "getAllProviders");
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_327922429 = mService.getAllProviders();
        } //End block
        catch (RemoteException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1183422108 = null;
        List<String> varA7E53CE21691AB073D9660D615818899_1753033802; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1753033802 = varB4EAC82CA7396A68D541C85D26508E83_327922429;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1753033802 = varB4EAC82CA7396A68D541C85D26508E83_1183422108;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1753033802.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1753033802;
        // ---------- Original Method ----------
        //if (false) {
            //Log.d(TAG, "getAllProviders");
        //}
        //try {
            //return mService.getAllProviders();
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getAllProviders: RemoteException", ex);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.601 -0400", hash_original_method = "229C505A2DE7B350090013A910A6BB48", hash_generated_method = "4025C92767A0353207380445C63CFF54")
    public List<String> getProviders(boolean enabledOnly) {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1259071209 = null; //Variable for return #1
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1275265618 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1259071209 = mService.getProviders(null, enabledOnly);
        } //End block
        catch (RemoteException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1275265618 = null;
        addTaint(enabledOnly);
        List<String> varA7E53CE21691AB073D9660D615818899_1173243270; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1173243270 = varB4EAC82CA7396A68D541C85D26508E83_1259071209;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1173243270 = varB4EAC82CA7396A68D541C85D26508E83_1275265618;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1173243270.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1173243270;
        // ---------- Original Method ----------
        //try {
            //return mService.getProviders(null, enabledOnly);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getProviders: RemoteException", ex);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.604 -0400", hash_original_method = "14AFABFCECA2A03E46C22CB46D5D2D56", hash_generated_method = "EDF18F30E92671C3B0F9386E89232203")
    public LocationProvider getProvider(String name) {
        LocationProvider varB4EAC82CA7396A68D541C85D26508E83_291045284 = null; //Variable for return #1
        LocationProvider varB4EAC82CA7396A68D541C85D26508E83_1059656552 = null; //Variable for return #2
        LocationProvider varB4EAC82CA7396A68D541C85D26508E83_52249769 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name==null");
        } //End block
        try 
        {
            Bundle info;
            info = mService.getProviderInfo(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_291045284 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1059656552 = createProvider(name, info);
        } //End block
        catch (RemoteException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_52249769 = null;
        addTaint(name.getTaint());
        LocationProvider varA7E53CE21691AB073D9660D615818899_818633568; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_818633568 = varB4EAC82CA7396A68D541C85D26508E83_291045284;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_818633568 = varB4EAC82CA7396A68D541C85D26508E83_1059656552;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_818633568 = varB4EAC82CA7396A68D541C85D26508E83_52249769;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_818633568.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_818633568;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("name==null");
        //}
        //try {
            //Bundle info = mService.getProviderInfo(name);
            //if (info == null) {
                //return null;
            //}
            //return createProvider(name, info);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getProvider: RemoteException", ex);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.615 -0400", hash_original_method = "03CC9524D6FEF78A1BD79E07965ADEF5", hash_generated_method = "374C80161A1CB17D11319D69754A2FCE")
    public List<String> getProviders(Criteria criteria, boolean enabledOnly) {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1457941180 = null; //Variable for return #1
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1588229187 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1457941180 = mService.getProviders(criteria, enabledOnly);
        } //End block
        catch (RemoteException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1588229187 = null;
        addTaint(criteria.getTaint());
        addTaint(enabledOnly);
        List<String> varA7E53CE21691AB073D9660D615818899_880702021; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_880702021 = varB4EAC82CA7396A68D541C85D26508E83_1457941180;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_880702021 = varB4EAC82CA7396A68D541C85D26508E83_1588229187;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_880702021.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_880702021;
        // ---------- Original Method ----------
        //if (criteria == null) {
            //throw new IllegalArgumentException("criteria==null");
        //}
        //try {
            //return mService.getProviders(criteria, enabledOnly);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getProviders: RemoteException", ex);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.636 -0400", hash_original_method = "E63BBD2716EE0B4343F6D6F30C802349", hash_generated_method = "D69C58202C4FCE9DD10CFE53DB85D9A7")
    public String getBestProvider(Criteria criteria, boolean enabledOnly) {
        String varB4EAC82CA7396A68D541C85D26508E83_2120226391 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1298090857 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2120226391 = mService.getBestProvider(criteria, enabledOnly);
        } //End block
        catch (RemoteException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1298090857 = null;
        addTaint(criteria.getTaint());
        addTaint(enabledOnly);
        String varA7E53CE21691AB073D9660D615818899_1693720985; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1693720985 = varB4EAC82CA7396A68D541C85D26508E83_2120226391;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1693720985 = varB4EAC82CA7396A68D541C85D26508E83_1298090857;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1693720985.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1693720985;
        // ---------- Original Method ----------
        //if (criteria == null) {
            //throw new IllegalArgumentException("criteria==null");
        //}
        //try {
            //return mService.getBestProvider(criteria, enabledOnly);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getBestProvider: RemoteException", ex);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.637 -0400", hash_original_method = "79B0FCFC5B63DF5D944678DA62AFE363", hash_generated_method = "63ED3FB20C4AB203DDD5100353C700CF")
    public void requestLocationUpdates(String provider,
        long minTime, float minDistance, LocationListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        _requestLocationUpdates(provider, null, minTime, minDistance, false, listener, null);
        addTaint(provider.getTaint());
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //_requestLocationUpdates(provider, null, minTime, minDistance, false, listener, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.646 -0400", hash_original_method = "FA80C6D3E17A94A62F4AA64272188CF2", hash_generated_method = "DCF3276B2265C2B778294438751EE42D")
    public void requestLocationUpdates(String provider,
        long minTime, float minDistance, LocationListener listener,
        Looper looper) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        _requestLocationUpdates(provider, null, minTime, minDistance, false, listener, looper);
        addTaint(provider.getTaint());
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //_requestLocationUpdates(provider, null, minTime, minDistance, false, listener, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.647 -0400", hash_original_method = "2A4D2871A80639591D176F262A5FC273", hash_generated_method = "C329A04AC70B5C97E76A304D4D1CD8E3")
    public void requestLocationUpdates(long minTime, float minDistance,
            Criteria criteria, LocationListener listener, Looper looper) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        _requestLocationUpdates(null, criteria, minTime, minDistance, false, listener, looper);
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(criteria.getTaint());
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        // ---------- Original Method ----------
        //if (criteria == null) {
            //throw new IllegalArgumentException("criteria==null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //_requestLocationUpdates(null, criteria, minTime, minDistance, false, listener, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.652 -0400", hash_original_method = "7527D3AF7E08617A40988967AFB4FC4D", hash_generated_method = "70492FF96A5A9F8680094EBCC9CAC3FB")
    private void _requestLocationUpdates(String provider, Criteria criteria, long minTime,
            float minDistance, boolean singleShot, LocationListener listener, Looper looper) {
        {
            minTime = 0L;
        } //End block
        {
            minDistance = 0.0f;
        } //End block
        try 
        {
            {
                ListenerTransport transport;
                transport = mListeners.get(listener);
                {
                    transport = new ListenerTransport(listener, looper);
                } //End block
                mListeners.put(listener, transport);
                mService.requestLocationUpdates(provider, criteria, minTime, minDistance, singleShot, transport);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        addTaint(criteria.getTaint());
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(singleShot);
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        // ---------- Original Method ----------
        //if (minTime < 0L) {
            //minTime = 0L;
        //}
        //if (minDistance < 0.0f) {
            //minDistance = 0.0f;
        //}
        //try {
            //synchronized (mListeners) {
                //ListenerTransport transport = mListeners.get(listener);
                //if (transport == null) {
                    //transport = new ListenerTransport(listener, looper);
                //}
                //mListeners.put(listener, transport);
                //mService.requestLocationUpdates(provider, criteria, minTime, minDistance, singleShot, transport);
            //}
        //} catch (RemoteException ex) {
            //Log.e(TAG, "requestLocationUpdates: DeadObjectException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.657 -0400", hash_original_method = "C7C08F02B5B72D29F482122DD6AFB995", hash_generated_method = "14F9C1F47E9083E3815711169B16E072")
    public void requestLocationUpdates(String provider,
            long minTime, float minDistance, PendingIntent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } //End block
        _requestLocationUpdates(provider, null, minTime, minDistance, false, intent);
        addTaint(provider.getTaint());
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //if (intent == null) {
            //throw new IllegalArgumentException("intent==null");
        //}
        //_requestLocationUpdates(provider, null, minTime, minDistance, false, intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.675 -0400", hash_original_method = "2F287C6E75A45C2A01B3C0BCBDE67B57", hash_generated_method = "4F946C6D20051B69FBD2BF2606C79A0C")
    public void requestLocationUpdates(long minTime, float minDistance, Criteria criteria, PendingIntent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } //End block
        _requestLocationUpdates(null, criteria, minTime, minDistance, false, intent);
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(criteria.getTaint());
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (criteria == null) {
            //throw new IllegalArgumentException("criteria==null");
        //}
        //if (intent == null) {
            //throw new IllegalArgumentException("intent==null");
        //}
        //_requestLocationUpdates(null, criteria, minTime, minDistance, false, intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.676 -0400", hash_original_method = "21FA37E7FC7084DE02389BC0809F92F8", hash_generated_method = "B3E831E4E45EDE98A7E9A16997512DE4")
    private void _requestLocationUpdates(String provider, Criteria criteria,
            long minTime, float minDistance, boolean singleShot, PendingIntent intent) {
        {
            minTime = 0L;
        } //End block
        {
            minDistance = 0.0f;
        } //End block
        try 
        {
            mService.requestLocationUpdatesPI(provider, criteria, minTime, minDistance, singleShot, intent);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        addTaint(criteria.getTaint());
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(singleShot);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (minTime < 0L) {
            //minTime = 0L;
        //}
        //if (minDistance < 0.0f) {
            //minDistance = 0.0f;
        //}
        //try {
            //mService.requestLocationUpdatesPI(provider, criteria, minTime, minDistance, singleShot, intent);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "requestLocationUpdates: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.677 -0400", hash_original_method = "E82A66C4B675428C8689D564FEFE46C0", hash_generated_method = "F19DE49BF6331EA244F39CFB8D0FBD29")
    public void requestSingleUpdate(String provider, LocationListener listener, Looper looper) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        _requestLocationUpdates(provider, null, 0L, 0.0f, true, listener, looper);
        addTaint(provider.getTaint());
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //_requestLocationUpdates(provider, null, 0L, 0.0f, true, listener, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.678 -0400", hash_original_method = "A942F553EBD5189FF7258B50664EDDE9", hash_generated_method = "99CBC770D3DC9B15D7C94D09BAAA1EEC")
    public void requestSingleUpdate(Criteria criteria, LocationListener listener, Looper looper) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        _requestLocationUpdates(null, criteria, 0L, 0.0f, true, listener, looper);
        addTaint(criteria.getTaint());
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        // ---------- Original Method ----------
        //if (criteria == null) {
            //throw new IllegalArgumentException("criteria==null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //_requestLocationUpdates(null, criteria, 0L, 0.0f, true, listener, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.682 -0400", hash_original_method = "71C843DE562F708F58659EAA42FBA5B9", hash_generated_method = "B4C95378AB61C8A1E8786EBB5FB47C8D")
    public void requestSingleUpdate(String provider, PendingIntent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } //End block
        _requestLocationUpdates(provider, null, 0L, 0.0f, true, intent);
        addTaint(provider.getTaint());
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //if (intent == null) {
            //throw new IllegalArgumentException("intent==null");
        //}
        //_requestLocationUpdates(provider, null, 0L, 0.0f, true, intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.683 -0400", hash_original_method = "6685F769C73037425B092AE6FD387007", hash_generated_method = "D97DC1617FD0F80B27BD32E1DA957BBF")
    public void requestSingleUpdate(Criteria criteria, PendingIntent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } //End block
        _requestLocationUpdates(null, criteria, 0L, 0.0f, true, intent);
        addTaint(criteria.getTaint());
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (criteria == null) {
            //throw new IllegalArgumentException("criteria==null");
        //}
        //if (intent == null) {
            //throw new IllegalArgumentException("intent==null");
        //}
        //_requestLocationUpdates(null, criteria, 0L, 0.0f, true, intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.691 -0400", hash_original_method = "C6393138E31F9EAAF3B1058E5B49E67E", hash_generated_method = "799D8BE80A658224ED9C694383F99894")
    public void removeUpdates(LocationListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        {
            Log.d(TAG, "removeUpdates: listener = " + listener);
        } //End block
        try 
        {
            ListenerTransport transport;
            transport = mListeners.remove(listener);
            {
                mService.removeUpdates(transport);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //if (false) {
            //Log.d(TAG, "removeUpdates: listener = " + listener);
        //}
        //try {
            //ListenerTransport transport = mListeners.remove(listener);
            //if (transport != null) {
                //mService.removeUpdates(transport);
            //}
        //} catch (RemoteException ex) {
            //Log.e(TAG, "removeUpdates: DeadObjectException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.692 -0400", hash_original_method = "53855AAE83CDCFDE219D3895B886D007", hash_generated_method = "1B689277393CD63B2DC8D38566A36E8C")
    public void removeUpdates(PendingIntent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } //End block
        {
            Log.d(TAG, "removeUpdates: intent = " + intent);
        } //End block
        try 
        {
            mService.removeUpdatesPI(intent);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (intent == null) {
            //throw new IllegalArgumentException("intent==null");
        //}
        //if (false) {
            //Log.d(TAG, "removeUpdates: intent = " + intent);
        //}
        //try {
            //mService.removeUpdatesPI(intent);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "removeUpdates: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.793 -0400", hash_original_method = "8F5138780FDD6FE26D92FDF1DF02DE4E", hash_generated_method = "D3FFD24B57C9142639115167B95E924F")
    public void addProximityAlert(double latitude, double longitude,
        float radius, long expiration, PendingIntent intent) {
        {
            Log.d(TAG, "addProximityAlert: latitude = " + latitude +
                ", longitude = " + longitude + ", radius = " + radius +
                ", expiration = " + expiration +
                ", intent = " + intent);
        } //End block
        try 
        {
            mService.addProximityAlert(latitude, longitude, radius,
                                       expiration, intent);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(latitude);
        addTaint(longitude);
        addTaint(radius);
        addTaint(expiration);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (false) {
            //Log.d(TAG, "addProximityAlert: latitude = " + latitude +
                //", longitude = " + longitude + ", radius = " + radius +
                //", expiration = " + expiration +
                //", intent = " + intent);
        //}
        //try {
            //mService.addProximityAlert(latitude, longitude, radius,
                                       //expiration, intent);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "addProximityAlert: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.796 -0400", hash_original_method = "4A48D6353D1407BC4C3112124D5D3B7A", hash_generated_method = "7EFF49511586B94EE4017C6AD29ABA02")
    public void removeProximityAlert(PendingIntent intent) {
        {
            Log.d(TAG, "removeProximityAlert: intent = " + intent);
        } //End block
        try 
        {
            mService.removeProximityAlert(intent);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (false) {
            //Log.d(TAG, "removeProximityAlert: intent = " + intent);
        //}
        //try {
            //mService.removeProximityAlert(intent);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "removeProximityAlert: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.796 -0400", hash_original_method = "A73A17F882D5C0CB78BFCF12E6BF5D56", hash_generated_method = "89452F68E5345E3F91548A54E79537CA")
    public boolean isProviderEnabled(String provider) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        try 
        {
            boolean var2CACBF2D859EB1EA82940C38019F9178_180061726 = (mService.isProviderEnabled(provider));
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166794478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166794478;
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //try {
            //return mService.isProviderEnabled(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "isProviderEnabled: RemoteException", ex);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.798 -0400", hash_original_method = "C11453A15D8C96574C829BE27A4B0DFD", hash_generated_method = "758A44E6222FF2C445EABE22363B3C3A")
    public Location getLastKnownLocation(String provider) {
        Location varB4EAC82CA7396A68D541C85D26508E83_1996586213 = null; //Variable for return #1
        Location varB4EAC82CA7396A68D541C85D26508E83_1595433036 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1996586213 = mService.getLastKnownLocation(provider);
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1595433036 = null;
        } //End block
        addTaint(provider.getTaint());
        Location varA7E53CE21691AB073D9660D615818899_714526202; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_714526202 = varB4EAC82CA7396A68D541C85D26508E83_1996586213;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_714526202 = varB4EAC82CA7396A68D541C85D26508E83_1595433036;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_714526202.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_714526202;
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //try {
            //return mService.getLastKnownLocation(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getLastKnowLocation: RemoteException", ex);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.799 -0400", hash_original_method = "03E8D8A5CD41A64BA401E8781419DF72", hash_generated_method = "8B8370CE6672C16304653BFEF715F652")
    public void addTestProvider(String name, boolean requiresNetwork, boolean requiresSatellite,
        boolean requiresCell, boolean hasMonetaryCost, boolean supportsAltitude,
        boolean supportsSpeed, boolean supportsBearing, int powerRequirement, int accuracy) {
        try 
        {
            mService.addTestProvider(name, requiresNetwork, requiresSatellite, requiresCell,
                hasMonetaryCost, supportsAltitude, supportsSpeed, supportsBearing, powerRequirement,
                accuracy);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(name.getTaint());
        addTaint(requiresNetwork);
        addTaint(requiresSatellite);
        addTaint(requiresCell);
        addTaint(hasMonetaryCost);
        addTaint(supportsAltitude);
        addTaint(supportsSpeed);
        addTaint(supportsBearing);
        addTaint(powerRequirement);
        addTaint(accuracy);
        // ---------- Original Method ----------
        //try {
            //mService.addTestProvider(name, requiresNetwork, requiresSatellite, requiresCell,
                //hasMonetaryCost, supportsAltitude, supportsSpeed, supportsBearing, powerRequirement,
                //accuracy);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "addTestProvider: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.819 -0400", hash_original_method = "498EE4F1DD4EF06996FBFECAF808CC3B", hash_generated_method = "DB7B730DD21D394472A7081A28DF4EEF")
    public void removeTestProvider(String provider) {
        try 
        {
            mService.removeTestProvider(provider);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.removeTestProvider(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "removeTestProvider: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.820 -0400", hash_original_method = "68207A112A1E7BBE4826B19769FC12DA", hash_generated_method = "B5AAAB03A7FF9C820152C53498C9B832")
    public void setTestProviderLocation(String provider, Location loc) {
        try 
        {
            mService.setTestProviderLocation(provider, loc);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        addTaint(loc.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.setTestProviderLocation(provider, loc);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "setTestProviderLocation: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.822 -0400", hash_original_method = "7CA7069D9943855589356239516DA9AF", hash_generated_method = "58BDF925E48A33639E0A08B7CD3F334F")
    public void clearTestProviderLocation(String provider) {
        try 
        {
            mService.clearTestProviderLocation(provider);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.clearTestProviderLocation(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "clearTestProviderLocation: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.861 -0400", hash_original_method = "48C675867948B21786DBAE4C1AE4920C", hash_generated_method = "C8D94E85CD6628BD1E4CB12AAC55182A")
    public void setTestProviderEnabled(String provider, boolean enabled) {
        try 
        {
            mService.setTestProviderEnabled(provider, enabled);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        addTaint(enabled);
        // ---------- Original Method ----------
        //try {
            //mService.setTestProviderEnabled(provider, enabled);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "setTestProviderEnabled: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.862 -0400", hash_original_method = "A7FE0DFAA40049E1860E732454FD3827", hash_generated_method = "89EAC726392531DB876F24AF9274B070")
    public void clearTestProviderEnabled(String provider) {
        try 
        {
            mService.clearTestProviderEnabled(provider);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.clearTestProviderEnabled(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "clearTestProviderEnabled: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.863 -0400", hash_original_method = "03886DE73D19ECB6C62373F8D9D58CA9", hash_generated_method = "9ABC9FF5C7EBE314AACA9E9FD913BB5A")
    public void setTestProviderStatus(String provider, int status, Bundle extras, long updateTime) {
        try 
        {
            mService.setTestProviderStatus(provider, status, extras, updateTime);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        addTaint(status);
        addTaint(extras.getTaint());
        addTaint(updateTime);
        // ---------- Original Method ----------
        //try {
            //mService.setTestProviderStatus(provider, status, extras, updateTime);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "setTestProviderStatus: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.868 -0400", hash_original_method = "013DF8509B89AA0EABD8A254078FCC60", hash_generated_method = "4CEB055CE9744AF337A9ACB53070D196")
    public void clearTestProviderStatus(String provider) {
        try 
        {
            mService.clearTestProviderStatus(provider);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.clearTestProviderStatus(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "clearTestProviderStatus: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.869 -0400", hash_original_method = "735E28281E7A2112C9B0A11E7D511734", hash_generated_method = "83CA888E3C7285A9A9FAA334487E93B6")
    public boolean addGpsStatusListener(GpsStatus.Listener listener) {
        boolean result;
        {
            boolean var5F2513550597BAA97D4D74F98C95E02D_971955471 = (mGpsStatusListeners.get(listener) != null);
        } //End collapsed parenthetic
        try 
        {
            GpsStatusListenerTransport transport;
            transport = new GpsStatusListenerTransport(listener);
            result = mService.addGpsStatusListener(transport);
            {
                mGpsStatusListeners.put(listener, transport);
            } //End block
        } //End block
        catch (RemoteException e)
        {
            result = false;
        } //End block
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1857875465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1857875465;
        // ---------- Original Method ----------
        //boolean result;
        //if (mGpsStatusListeners.get(listener) != null) {
            //return true;
        //}
        //try {
            //GpsStatusListenerTransport transport = new GpsStatusListenerTransport(listener);
            //result = mService.addGpsStatusListener(transport);
            //if (result) {
                //mGpsStatusListeners.put(listener, transport);
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in registerGpsStatusListener: ", e);
            //result = false;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.870 -0400", hash_original_method = "BE93B3D03F00A664B96E561F38428949", hash_generated_method = "DBDB76AE60DF98EA593E6B6CA3100029")
    public void removeGpsStatusListener(GpsStatus.Listener listener) {
        try 
        {
            GpsStatusListenerTransport transport;
            transport = mGpsStatusListeners.remove(listener);
            {
                mService.removeGpsStatusListener(transport);
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //try {
            //GpsStatusListenerTransport transport = mGpsStatusListeners.remove(listener);
            //if (transport != null) {
                //mService.removeGpsStatusListener(transport);
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in unregisterGpsStatusListener: ", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.871 -0400", hash_original_method = "69F227E2B854C20A513354DE72686880", hash_generated_method = "AFE391285DE6A6915B81B4C7F5A133FC")
    public boolean addNmeaListener(GpsStatus.NmeaListener listener) {
        boolean result;
        {
            boolean var94A6474BA2F49BF4171CA676610F86BC_712480503 = (mNmeaListeners.get(listener) != null);
        } //End collapsed parenthetic
        try 
        {
            GpsStatusListenerTransport transport;
            transport = new GpsStatusListenerTransport(listener);
            result = mService.addGpsStatusListener(transport);
            {
                mNmeaListeners.put(listener, transport);
            } //End block
        } //End block
        catch (RemoteException e)
        {
            result = false;
        } //End block
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2037881754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2037881754;
        // ---------- Original Method ----------
        //boolean result;
        //if (mNmeaListeners.get(listener) != null) {
            //return true;
        //}
        //try {
            //GpsStatusListenerTransport transport = new GpsStatusListenerTransport(listener);
            //result = mService.addGpsStatusListener(transport);
            //if (result) {
                //mNmeaListeners.put(listener, transport);
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in registerGpsStatusListener: ", e);
            //result = false;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.872 -0400", hash_original_method = "B4F97B229D6634102324704B9EDD8365", hash_generated_method = "ED19BF2AE30603C9F0F68B3F901CC267")
    public void removeNmeaListener(GpsStatus.NmeaListener listener) {
        try 
        {
            GpsStatusListenerTransport transport;
            transport = mNmeaListeners.remove(listener);
            {
                mService.removeGpsStatusListener(transport);
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //try {
            //GpsStatusListenerTransport transport = mNmeaListeners.remove(listener);
            //if (transport != null) {
                //mService.removeGpsStatusListener(transport);
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in unregisterGpsStatusListener: ", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.885 -0400", hash_original_method = "58632EF952FC4DB3D625E7340D0B4D49", hash_generated_method = "D3588D9C13AEE36A5BE4517CC14E3ABA")
    public GpsStatus getGpsStatus(GpsStatus status) {
        GpsStatus varB4EAC82CA7396A68D541C85D26508E83_721395937 = null; //Variable for return #1
        {
            status = new GpsStatus();
        } //End block
        status.setStatus(mGpsStatus);
        varB4EAC82CA7396A68D541C85D26508E83_721395937 = status;
        addTaint(status.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_721395937.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_721395937;
        // ---------- Original Method ----------
        //if (status == null) {
            //status = new GpsStatus();
       //}
        //status.setStatus(mGpsStatus);
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.886 -0400", hash_original_method = "A7B31AF326321489C7AFBE2F446F3E30", hash_generated_method = "8B197F5F233349563DE819714DE3FF16")
    public boolean sendExtraCommand(String provider, String command, Bundle extras) {
        try 
        {
            boolean var54C526BCA32BFB67E2D9FD83D51E8E2C_659889677 = (mService.sendExtraCommand(provider, command, extras));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(provider.getTaint());
        addTaint(command.getTaint());
        addTaint(extras.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121599252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_121599252;
        // ---------- Original Method ----------
        //try {
            //return mService.sendExtraCommand(provider, command, extras);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in sendExtraCommand: ", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.886 -0400", hash_original_method = "486A02DD90A0BB213EFD64094D84B261", hash_generated_method = "F16DFE8281EC1A4BBB7B655884007BEA")
    public boolean sendNiResponse(int notifId, int userResponse) {
        try 
        {
            boolean var5F2B4C98AB0C6ADE0371DA0514391756_1901903118 = (mService.sendNiResponse(notifId, userResponse));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(notifId);
        addTaint(userResponse);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_874395196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_874395196;
        // ---------- Original Method ----------
        //try {
            //return mService.sendNiResponse(notifId, userResponse);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in sendNiResponse: ", e);
            //return false;
        //}
    }

    
    private class ListenerTransport extends ILocationListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.887 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "88C676C20BB164A41FD7C10E7FA78223")

        private LocationListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.887 -0400", hash_original_field = "56BAC178F3086AD35CDD4674A0CF1FF6", hash_generated_field = "4100173B517AAB1135352B9F9C7AE096")

        private Handler mListenerHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.903 -0400", hash_original_method = "5AF1CAA1D5EED50BE6CA5764BFEB7286", hash_generated_method = "9B017CAF957220AB33796B98E52BDDFA")
          ListenerTransport(LocationListener listener, Looper looper) {
            mListener = listener;
            {
                mListenerHandler = new Handler() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.902 -0400", hash_original_method = "2788B827BF69A5605D676A806900279A", hash_generated_method = "F91A923F1693A66EB7CBCB63C96E490F")
                    @Override
                    public void handleMessage(Message msg) {
                        _handleMessage(msg);
                        addTaint(msg.getTaint());
                        // ---------- Original Method ----------
                        //_handleMessage(msg);
                    }
};
            } //End block
            {
                mListenerHandler = new Handler(looper) {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.903 -0400", hash_original_method = "2788B827BF69A5605D676A806900279A", hash_generated_method = "F91A923F1693A66EB7CBCB63C96E490F")
                    @Override
                    public void handleMessage(Message msg) {
                        _handleMessage(msg);
                        addTaint(msg.getTaint());
                        // ---------- Original Method ----------
                        //_handleMessage(msg);
                    }
};
            } //End block
            // ---------- Original Method ----------
            //mListener = listener;
            //if (looper == null) {
                //mListenerHandler = new Handler() {
                    //@Override
                    //public void handleMessage(Message msg) {
                        //_handleMessage(msg);
                    //}
                //};
            //} else {
                //mListenerHandler = new Handler(looper) {
                    //@Override
                    //public void handleMessage(Message msg) {
                        //_handleMessage(msg);
                    //}
                //};
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.904 -0400", hash_original_method = "A17E439126795FFA0E8C33868ED647C4", hash_generated_method = "B0D07C72179D9CF1C5498321D365BC82")
        public void onLocationChanged(Location location) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Message msg;
            msg = Message.obtain();
            msg.what = TYPE_LOCATION_CHANGED;
            msg.obj = location;
            mListenerHandler.sendMessage(msg);
            addTaint(location.getTaint());
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.what = TYPE_LOCATION_CHANGED;
            //msg.obj = location;
            //mListenerHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.921 -0400", hash_original_method = "BF8F7C90ADE4983F5319C798EB4A7E9F", hash_generated_method = "B175D5255A36DB54BBED666AADDBC9B7")
        public void onStatusChanged(String provider, int status, Bundle extras) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Message msg;
            msg = Message.obtain();
            msg.what = TYPE_STATUS_CHANGED;
            Bundle b;
            b = new Bundle();
            b.putString("provider", provider);
            b.putInt("status", status);
            {
                b.putBundle("extras", extras);
            } //End block
            msg.obj = b;
            mListenerHandler.sendMessage(msg);
            addTaint(provider.getTaint());
            addTaint(status);
            addTaint(extras.getTaint());
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.what = TYPE_STATUS_CHANGED;
            //Bundle b = new Bundle();
            //b.putString("provider", provider);
            //b.putInt("status", status);
            //if (extras != null) {
                //b.putBundle("extras", extras);
            //}
            //msg.obj = b;
            //mListenerHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.922 -0400", hash_original_method = "812D643BCDC2A4502FF3E1F391BA3BAF", hash_generated_method = "465BA8570919CBCD82D81D141AFE06B7")
        public void onProviderEnabled(String provider) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Message msg;
            msg = Message.obtain();
            msg.what = TYPE_PROVIDER_ENABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.what = TYPE_PROVIDER_ENABLED;
            //msg.obj = provider;
            //mListenerHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.939 -0400", hash_original_method = "E15FA24A6514F29CC56145BCCEFEF320", hash_generated_method = "910B1D3CDED746C7DF1CED4B4BA8A4B9")
        public void onProviderDisabled(String provider) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Message msg;
            msg = Message.obtain();
            msg.what = TYPE_PROVIDER_DISABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.what = TYPE_PROVIDER_DISABLED;
            //msg.obj = provider;
            //mListenerHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.941 -0400", hash_original_method = "B4AFFA03A7F956D43DB0E44DEB20B60F", hash_generated_method = "A814B85635D7C3203388FD7696078E60")
        private void _handleMessage(Message msg) {
            //Begin case TYPE_LOCATION_CHANGED 
            Location location;
            location = new Location((Location) msg.obj);
            //End case TYPE_LOCATION_CHANGED 
            //Begin case TYPE_LOCATION_CHANGED 
            mListener.onLocationChanged(location);
            //End case TYPE_LOCATION_CHANGED 
            //Begin case TYPE_STATUS_CHANGED 
            Bundle b;
            b = (Bundle) msg.obj;
            //End case TYPE_STATUS_CHANGED 
            //Begin case TYPE_STATUS_CHANGED 
            String provider;
            provider = b.getString("provider");
            //End case TYPE_STATUS_CHANGED 
            //Begin case TYPE_STATUS_CHANGED 
            int status;
            status = b.getInt("status");
            //End case TYPE_STATUS_CHANGED 
            //Begin case TYPE_STATUS_CHANGED 
            Bundle extras;
            extras = b.getBundle("extras");
            //End case TYPE_STATUS_CHANGED 
            //Begin case TYPE_STATUS_CHANGED 
            mListener.onStatusChanged(provider, status, extras);
            //End case TYPE_STATUS_CHANGED 
            //Begin case TYPE_PROVIDER_ENABLED 
            mListener.onProviderEnabled((String) msg.obj);
            //End case TYPE_PROVIDER_ENABLED 
            //Begin case TYPE_PROVIDER_DISABLED 
            mListener.onProviderDisabled((String) msg.obj);
            //End case TYPE_PROVIDER_DISABLED 
            try 
            {
                mService.locationCallbackFinished(this);
            } //End block
            catch (RemoteException e)
            { }
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.941 -0400", hash_original_field = "8C0B89388C7AF37135B00419CA7E9C92", hash_generated_field = "4F6331E1C38728042E99BC19ED065FE7")

        private static int TYPE_LOCATION_CHANGED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.941 -0400", hash_original_field = "45E66B86E7431FAC1292C89E91493801", hash_generated_field = "0E0EB8CF48239791BC17B65E42FD0D5E")

        private static int TYPE_STATUS_CHANGED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.955 -0400", hash_original_field = "4D8B289A7864C6EE1ACDD3C1B058CE4F", hash_generated_field = "1DEB2ED8E0755ECCDC1E6866C8E41AA3")

        private static int TYPE_PROVIDER_ENABLED = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.955 -0400", hash_original_field = "DD4E410FD111EAFC75B3615EB43DD4E3", hash_generated_field = "AAA8F4CC1C231AA942B04F54800111F8")

        private static int TYPE_PROVIDER_DISABLED = 4;
    }


    
    private class GpsStatusListenerTransport extends IGpsStatusListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.956 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "3564D5BECCC467DBB563E9174E6839FA")

        private GpsStatus.Listener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.956 -0400", hash_original_field = "6A914A5E364626F0BE69C7CA16741AC2", hash_generated_field = "C56AA1FA4293F00EF5AC3280F7CE1BCE")

        private GpsStatus.NmeaListener mNmeaListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.956 -0400", hash_original_field = "C91213C9D8B8761834B23071597A3455", hash_generated_field = "BDE0A966016D1F7F3E0759437CA71854")

        private ArrayList<Nmea> mNmeaBuffer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.957 -0400", hash_original_field = "1388D92E53A0B03AA5E995A7DC696BD0", hash_generated_field = "D23870A43FB99EF34F9CAE0020829786")

        private Handler mGpsHandler = new Handler() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.957 -0400", hash_original_method = "3A4C26C18C998E8AD28D793D2B4D73AC", hash_generated_method = "8BE126D3F571269090F5870A507B9C52")
            @Override
            public void handleMessage(Message msg) {
                {
                    {
                        int length;
                        length = mNmeaBuffer.size();
                        {
                            int i;
                            i = 0;
                            {
                                Nmea nmea;
                                nmea = mNmeaBuffer.get(i);
                                mNmeaListener.onNmeaReceived(nmea.mTimestamp, nmea.mNmea);
                            } //End block
                        } //End collapsed parenthetic
                        mNmeaBuffer.clear();
                    } //End block
                } //End block
                {
                    {
                        mListener.onGpsStatusChanged(msg.what);
                    } //End block
                } //End block
                addTaint(msg.getTaint());
                // ---------- Original Method ----------
                //if (msg.what == NMEA_RECEIVED) {
                    //synchronized (mNmeaBuffer) {
                        //int length = mNmeaBuffer.size();
                        //for (int i = 0; i < length; i++) {
                            //Nmea nmea = mNmeaBuffer.get(i);
                            //mNmeaListener.onNmeaReceived(nmea.mTimestamp, nmea.mNmea);
                        //}
                        //mNmeaBuffer.clear();
                    //}
                //} else {
                    //synchronized(mGpsStatus) {
                        //mListener.onGpsStatusChanged(msg.what);
                    //}
                //}
            }

            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.958 -0400", hash_original_method = "F4C48E1C52D52EE2A00BB4471F3F104F", hash_generated_method = "5BD8573A0E58EE341269EDADEAA6CD32")
          GpsStatusListenerTransport(GpsStatus.Listener listener) {
            mListener = listener;
            mNmeaListener = null;
            // ---------- Original Method ----------
            //mListener = listener;
            //mNmeaListener = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.965 -0400", hash_original_method = "2F84EC7497CDA44BC0A09FBB4C2AE91B", hash_generated_method = "A64C791C45CA47B3BFECF96C00EDA552")
          GpsStatusListenerTransport(GpsStatus.NmeaListener listener) {
            mNmeaListener = listener;
            mListener = null;
            mNmeaBuffer = new ArrayList<Nmea>();
            // ---------- Original Method ----------
            //mNmeaListener = listener;
            //mListener = null;
            //mNmeaBuffer = new ArrayList<Nmea>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.972 -0400", hash_original_method = "03DD372B4F74F556A5CFC2950F002742", hash_generated_method = "F953C1733E6F0044D9DD1C141F224C4E")
        public void onGpsStarted() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                Message msg;
                msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_STARTED;
                mGpsHandler.sendMessage(msg);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                //Message msg = Message.obtain();
                //msg.what = GpsStatus.GPS_EVENT_STARTED;
                //mGpsHandler.sendMessage(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.973 -0400", hash_original_method = "30C4A680AA9F7AF81E647400DEBA508E", hash_generated_method = "18F747EE3747CC12C7795B67D48B597C")
        public void onGpsStopped() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                Message msg;
                msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_STOPPED;
                mGpsHandler.sendMessage(msg);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                //Message msg = Message.obtain();
                //msg.what = GpsStatus.GPS_EVENT_STOPPED;
                //mGpsHandler.sendMessage(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.992 -0400", hash_original_method = "E5DFF9ED39044E57371BE0E746E84457", hash_generated_method = "0B5196F07DC7AFFA277FE47C44159183")
        public void onFirstFix(int ttff) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mGpsStatus.setTimeToFirstFix(ttff);
                Message msg;
                msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_FIRST_FIX;
                mGpsHandler.sendMessage(msg);
            } //End block
            addTaint(ttff);
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mGpsStatus.setTimeToFirstFix(ttff);
                //Message msg = Message.obtain();
                //msg.what = GpsStatus.GPS_EVENT_FIRST_FIX;
                //mGpsHandler.sendMessage(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.000 -0400", hash_original_method = "6F6B969ADA567E96DFAB5A585780E70F", hash_generated_method = "7E352262F7580F2577EDAF02D9A2E9D1")
        public void onSvStatusChanged(int svCount, int[] prns, float[] snrs,
                float[] elevations, float[] azimuths, int ephemerisMask,
                int almanacMask, int usedInFixMask) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mGpsStatus.setStatus(svCount, prns, snrs, elevations, azimuths,
                        ephemerisMask, almanacMask, usedInFixMask);
                Message msg;
                msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_SATELLITE_STATUS;
                mGpsHandler.removeMessages(GpsStatus.GPS_EVENT_SATELLITE_STATUS);
                mGpsHandler.sendMessage(msg);
            } //End block
            addTaint(svCount);
            addTaint(prns[0]);
            addTaint(snrs[0]);
            addTaint(elevations[0]);
            addTaint(azimuths[0]);
            addTaint(ephemerisMask);
            addTaint(almanacMask);
            addTaint(usedInFixMask);
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mGpsStatus.setStatus(svCount, prns, snrs, elevations, azimuths,
                        //ephemerisMask, almanacMask, usedInFixMask);
                //Message msg = Message.obtain();
                //msg.what = GpsStatus.GPS_EVENT_SATELLITE_STATUS;
                //mGpsHandler.removeMessages(GpsStatus.GPS_EVENT_SATELLITE_STATUS);
                //mGpsHandler.sendMessage(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.001 -0400", hash_original_method = "D97F778C22B6B561834B5A8A67FE2F57", hash_generated_method = "A094034040D8CA76767F65A5E20F946E")
        public void onNmeaReceived(long timestamp, String nmea) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                {
                    mNmeaBuffer.add(new Nmea(timestamp, nmea));
                } //End block
                Message msg;
                msg = Message.obtain();
                msg.what = NMEA_RECEIVED;
                mGpsHandler.removeMessages(NMEA_RECEIVED);
                mGpsHandler.sendMessage(msg);
            } //End block
            addTaint(timestamp);
            addTaint(nmea.getTaint());
            // ---------- Original Method ----------
            //if (mNmeaListener != null) {
                //synchronized (mNmeaBuffer) {
                    //mNmeaBuffer.add(new Nmea(timestamp, nmea));
                //}
                //Message msg = Message.obtain();
                //msg.what = NMEA_RECEIVED;
                //mGpsHandler.removeMessages(NMEA_RECEIVED);
                //mGpsHandler.sendMessage(msg);
            //}
        }

        
        private class Nmea {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.002 -0400", hash_original_field = "D0D8C7FFAD5AE68F861E40D637EC0463", hash_generated_field = "1D358F2CB412AAF1346451355CB8F3E3")

            long mTimestamp;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.002 -0400", hash_original_field = "5C868597A7B87315895D9C109908E910", hash_generated_field = "24AFD15E5AD8DD2E9530B1A85650CD93")

            String mNmea;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.003 -0400", hash_original_method = "7FAFEC38F5688F1D1ACFE15C845DEFCA", hash_generated_method = "2C01B97CF53E8C2E9DE64A323D518081")
              Nmea(long timestamp, String nmea) {
                mTimestamp = timestamp;
                mNmea = nmea;
                // ---------- Original Method ----------
                //mTimestamp = timestamp;
                //mNmea = nmea;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.003 -0400", hash_original_field = "D84CD7AC433F52E58A4CCA5B3DB61EAD", hash_generated_field = "42BA11FDC6A92AFB50048B81B8856AC7")

        private static int NMEA_RECEIVED = 1000;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.003 -0400", hash_original_field = "3DCB34AD9AF783DB01BF473D53795CF0", hash_generated_field = "E093EE195B042F0ED33D0AB1FE9B2AFD")

    private static String TAG = "LocationManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.003 -0400", hash_original_field = "6EB3A04D83D3EB53836000A2B31706D3", hash_generated_field = "6A1159950B5F0D81FE05A0592F2DB1B2")

    public static final String NETWORK_PROVIDER = "network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.003 -0400", hash_original_field = "5511BBE363BBFBEF2A13CD3903A63DBA", hash_generated_field = "4C2280586138D33EB30E26156BDCB654")

    public static final String GPS_PROVIDER = "gps";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.003 -0400", hash_original_field = "1A76AC2B2F74ECACC05EB5A2C9A17D65", hash_generated_field = "F221EEFFFB6FF66793F94043F74CBC0B")

    public static final String PASSIVE_PROVIDER = "passive";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.003 -0400", hash_original_field = "1219C70453A4B51E7467604E9D21E2F1", hash_generated_field = "F9B4EC13158580C5DB06971A10A5663C")

    public static final String KEY_PROXIMITY_ENTERING = "entering";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.003 -0400", hash_original_field = "8BBFDB3591EF0B7BAF1E2C35BEE723C2", hash_generated_field = "F215A34B782985F96320EA9F9AC24ECE")

    public static final String KEY_STATUS_CHANGED = "status";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.004 -0400", hash_original_field = "EFC775B399B41180A7DFD2652A75BD6F", hash_generated_field = "E53B94E70159BE067785CDCFE51933F1")

    public static final String KEY_PROVIDER_ENABLED = "providerEnabled";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.004 -0400", hash_original_field = "BBB9637E7AD41C030E894E86C191AECF", hash_generated_field = "B9A8BCBF7A8975A62A8159DDE6821E45")

    public static final String KEY_LOCATION_CHANGED = "location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.004 -0400", hash_original_field = "400BD7DF293767AC387D02375DE71183", hash_generated_field = "4011D28AFA5049A3F8B84DAE600CE7B1")

    public static final String GPS_ENABLED_CHANGE_ACTION =
        "android.location.GPS_ENABLED_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.004 -0400", hash_original_field = "116A7AA128E8BD79F2FF79BDFA6FC928", hash_generated_field = "F1DA53484EFF7310FA2C5CCD96A5903D")

    public static final String PROVIDERS_CHANGED_ACTION =
        "android.location.PROVIDERS_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.004 -0400", hash_original_field = "DDA3CF7A2BE453FBAF12CC5166836588", hash_generated_field = "0ED670DE81E8FA835AC8A157321FBD93")

    public static final String GPS_FIX_CHANGE_ACTION =
        "android.location.GPS_FIX_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.004 -0400", hash_original_field = "494BD1FE78539565E73D758923F5ABF3", hash_generated_field = "AAD29DA0DDBC5FD40952BC68A7746945")

    public static final String EXTRA_GPS_ENABLED = "enabled";
}

