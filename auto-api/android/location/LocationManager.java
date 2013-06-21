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
    private ILocationManager mService;
    private HashMap<GpsStatus.Listener, GpsStatusListenerTransport> mGpsStatusListeners =
            new HashMap<GpsStatus.Listener, GpsStatusListenerTransport>();
    private HashMap<GpsStatus.NmeaListener, GpsStatusListenerTransport> mNmeaListeners =
            new HashMap<GpsStatus.NmeaListener, GpsStatusListenerTransport>();
    private GpsStatus mGpsStatus = new GpsStatus();
    private HashMap<LocationListener,ListenerTransport> mListeners =
        new HashMap<LocationListener,ListenerTransport>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.938 -0400", hash_original_method = "1755E60A5AAD43AA8D18158DFDE91956", hash_generated_method = "72056CD935AF20BE97B1392EB2231B96")
    @DSModeled(DSC.SAFE)
    public LocationManager(ILocationManager service) {
        dsTaint.addTaint(service.dsTaint);
        // ---------- Original Method ----------
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.939 -0400", hash_original_method = "F4540EAD4F3CF2106C64C62C1DCA569C", hash_generated_method = "629961B302DC72C1F9C82A7858924F7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private LocationProvider createProvider(String name, Bundle info) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(info.dsTaint);
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
        return (LocationProvider)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.946 -0400", hash_original_method = "4EC410201344BFF6367B3FC4DEB2ECDD", hash_generated_method = "03D625D18F92249ED490989EA49EE802")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> getAllProviders() {
        {
            Log.d(TAG, "getAllProviders");
        } //End block
        try 
        {
            List<String> var33881D182946EB1514BEA2C19028450B_422487933 = (mService.getAllProviders());
        } //End block
        catch (RemoteException ex)
        { }
        return (List<String>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.950 -0400", hash_original_method = "229C505A2DE7B350090013A910A6BB48", hash_generated_method = "08CA28F0CC6F63F18479134026444C05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> getProviders(boolean enabledOnly) {
        dsTaint.addTaint(enabledOnly);
        try 
        {
            List<String> var27ECBAEE95BE941A87B7148937077462_330155067 = (mService.getProviders(null, enabledOnly));
        } //End block
        catch (RemoteException ex)
        { }
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getProviders(null, enabledOnly);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getProviders: RemoteException", ex);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.951 -0400", hash_original_method = "14AFABFCECA2A03E46C22CB46D5D2D56", hash_generated_method = "7915FFF1EB10763C7B1DBFE812C7A9A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LocationProvider getProvider(String name) {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name==null");
        } //End block
        try 
        {
            Bundle info;
            info = mService.getProviderInfo(name);
            LocationProvider varA7E50435837969DA620ABCBC4F9479A7_230590284 = (createProvider(name, info));
        } //End block
        catch (RemoteException ex)
        { }
        return (LocationProvider)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.951 -0400", hash_original_method = "03CC9524D6FEF78A1BD79E07965ADEF5", hash_generated_method = "B6B5545B08DAAF7FFE6CC0E0617C79BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> getProviders(Criteria criteria, boolean enabledOnly) {
        dsTaint.addTaint(criteria.dsTaint);
        dsTaint.addTaint(enabledOnly);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        try 
        {
            List<String> var024CFBB60A0D2681FBBDC45AF768AA33_395419847 = (mService.getProviders(criteria, enabledOnly));
        } //End block
        catch (RemoteException ex)
        { }
        return (List<String>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.952 -0400", hash_original_method = "E63BBD2716EE0B4343F6D6F30C802349", hash_generated_method = "40C08B07419DE9B57DE71C3675F37956")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getBestProvider(Criteria criteria, boolean enabledOnly) {
        dsTaint.addTaint(criteria.dsTaint);
        dsTaint.addTaint(enabledOnly);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        try 
        {
            String var2DFB526BCE470423660BF3B36D7D3012_1162443477 = (mService.getBestProvider(criteria, enabledOnly));
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.953 -0400", hash_original_method = "79B0FCFC5B63DF5D944678DA62AFE363", hash_generated_method = "DE51D82D3F9CADA70068CAF37179A688")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestLocationUpdates(String provider,
        long minTime, float minDistance, LocationListener listener) {
        dsTaint.addTaint(minTime);
        dsTaint.addTaint(minDistance);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(provider);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        _requestLocationUpdates(provider, null, minTime, minDistance, false, listener, null);
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //_requestLocationUpdates(provider, null, minTime, minDistance, false, listener, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.956 -0400", hash_original_method = "FA80C6D3E17A94A62F4AA64272188CF2", hash_generated_method = "17EE69C89AFE36581F6AD28199C8681E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestLocationUpdates(String provider,
        long minTime, float minDistance, LocationListener listener,
        Looper looper) {
        dsTaint.addTaint(minTime);
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(minDistance);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(provider);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        _requestLocationUpdates(provider, null, minTime, minDistance, false, listener, looper);
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //_requestLocationUpdates(provider, null, minTime, minDistance, false, listener, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.958 -0400", hash_original_method = "2A4D2871A80639591D176F262A5FC273", hash_generated_method = "20D92B4827569E6BBE3E1719297F1076")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestLocationUpdates(long minTime, float minDistance,
            Criteria criteria, LocationListener listener, Looper looper) {
        dsTaint.addTaint(minTime);
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(criteria.dsTaint);
        dsTaint.addTaint(minDistance);
        dsTaint.addTaint(listener.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        _requestLocationUpdates(null, criteria, minTime, minDistance, false, listener, looper);
        // ---------- Original Method ----------
        //if (criteria == null) {
            //throw new IllegalArgumentException("criteria==null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //_requestLocationUpdates(null, criteria, minTime, minDistance, false, listener, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.959 -0400", hash_original_method = "7527D3AF7E08617A40988967AFB4FC4D", hash_generated_method = "B4E5EAE8D86CB8D2DA0C3676FCDD66C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _requestLocationUpdates(String provider, Criteria criteria, long minTime,
            float minDistance, boolean singleShot, LocationListener listener, Looper looper) {
        dsTaint.addTaint(singleShot);
        dsTaint.addTaint(minTime);
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(minDistance);
        dsTaint.addTaint(criteria.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(provider);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.959 -0400", hash_original_method = "C7C08F02B5B72D29F482122DD6AFB995", hash_generated_method = "B6AD21D82C15EB91BDFD5AC3A928141A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestLocationUpdates(String provider,
            long minTime, float minDistance, PendingIntent intent) {
        dsTaint.addTaint(minTime);
        dsTaint.addTaint(minDistance);
        dsTaint.addTaint(provider);
        dsTaint.addTaint(intent.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } //End block
        _requestLocationUpdates(provider, null, minTime, minDistance, false, intent);
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //if (intent == null) {
            //throw new IllegalArgumentException("intent==null");
        //}
        //_requestLocationUpdates(provider, null, minTime, minDistance, false, intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.959 -0400", hash_original_method = "2F287C6E75A45C2A01B3C0BCBDE67B57", hash_generated_method = "995251A56DD3DCCB6A7ADF375999E6B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestLocationUpdates(long minTime, float minDistance, Criteria criteria, PendingIntent intent) {
        dsTaint.addTaint(minTime);
        dsTaint.addTaint(criteria.dsTaint);
        dsTaint.addTaint(minDistance);
        dsTaint.addTaint(intent.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } //End block
        _requestLocationUpdates(null, criteria, minTime, minDistance, false, intent);
        // ---------- Original Method ----------
        //if (criteria == null) {
            //throw new IllegalArgumentException("criteria==null");
        //}
        //if (intent == null) {
            //throw new IllegalArgumentException("intent==null");
        //}
        //_requestLocationUpdates(null, criteria, minTime, minDistance, false, intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.960 -0400", hash_original_method = "21FA37E7FC7084DE02389BC0809F92F8", hash_generated_method = "4A7A20C71A1D2DD8D4EEA54DFDCB5AF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _requestLocationUpdates(String provider, Criteria criteria,
            long minTime, float minDistance, boolean singleShot, PendingIntent intent) {
        dsTaint.addTaint(singleShot);
        dsTaint.addTaint(minTime);
        dsTaint.addTaint(minDistance);
        dsTaint.addTaint(criteria.dsTaint);
        dsTaint.addTaint(provider);
        dsTaint.addTaint(intent.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.960 -0400", hash_original_method = "E82A66C4B675428C8689D564FEFE46C0", hash_generated_method = "C320D695892075C3B360431DA1DBB89D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestSingleUpdate(String provider, LocationListener listener, Looper looper) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(provider);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        _requestLocationUpdates(provider, null, 0L, 0.0f, true, listener, looper);
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //_requestLocationUpdates(provider, null, 0L, 0.0f, true, listener, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.960 -0400", hash_original_method = "A942F553EBD5189FF7258B50664EDDE9", hash_generated_method = "6EA9C1AB8AD4D5EC78D5B889C55C6864")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestSingleUpdate(Criteria criteria, LocationListener listener, Looper looper) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(criteria.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } //End block
        _requestLocationUpdates(null, criteria, 0L, 0.0f, true, listener, looper);
        // ---------- Original Method ----------
        //if (criteria == null) {
            //throw new IllegalArgumentException("criteria==null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener==null");
        //}
        //_requestLocationUpdates(null, criteria, 0L, 0.0f, true, listener, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.960 -0400", hash_original_method = "71C843DE562F708F58659EAA42FBA5B9", hash_generated_method = "094C4A13C4DA701AC71127ECC6A2D33B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestSingleUpdate(String provider, PendingIntent intent) {
        dsTaint.addTaint(provider);
        dsTaint.addTaint(intent.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } //End block
        _requestLocationUpdates(provider, null, 0L, 0.0f, true, intent);
        // ---------- Original Method ----------
        //if (provider == null) {
            //throw new IllegalArgumentException("provider==null");
        //}
        //if (intent == null) {
            //throw new IllegalArgumentException("intent==null");
        //}
        //_requestLocationUpdates(provider, null, 0L, 0.0f, true, intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.961 -0400", hash_original_method = "6685F769C73037425B092AE6FD387007", hash_generated_method = "5F2958C8EBC02A96D7BE9BF98B02C599")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestSingleUpdate(Criteria criteria, PendingIntent intent) {
        dsTaint.addTaint(criteria.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } //End block
        _requestLocationUpdates(null, criteria, 0L, 0.0f, true, intent);
        // ---------- Original Method ----------
        //if (criteria == null) {
            //throw new IllegalArgumentException("criteria==null");
        //}
        //if (intent == null) {
            //throw new IllegalArgumentException("intent==null");
        //}
        //_requestLocationUpdates(null, criteria, 0L, 0.0f, true, intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.961 -0400", hash_original_method = "C6393138E31F9EAAF3B1058E5B49E67E", hash_generated_method = "ECD9B328B6276B0BEE503CFF6324D233")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeUpdates(LocationListener listener) {
        dsTaint.addTaint(listener.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.961 -0400", hash_original_method = "53855AAE83CDCFDE219D3895B886D007", hash_generated_method = "127160EAFD3E78EB52C70019F1B42E1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeUpdates(PendingIntent intent) {
        dsTaint.addTaint(intent.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.962 -0400", hash_original_method = "8F5138780FDD6FE26D92FDF1DF02DE4E", hash_generated_method = "F8C4459024C1ECA1065F480963F84D6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addProximityAlert(double latitude, double longitude,
        float radius, long expiration, PendingIntent intent) {
        dsTaint.addTaint(expiration);
        dsTaint.addTaint(radius);
        dsTaint.addTaint(longitude);
        dsTaint.addTaint(latitude);
        dsTaint.addTaint(intent.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.962 -0400", hash_original_method = "4A48D6353D1407BC4C3112124D5D3B7A", hash_generated_method = "D247B2AEAFEF153880AAC22A8D23B3E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeProximityAlert(PendingIntent intent) {
        dsTaint.addTaint(intent.dsTaint);
        {
            Log.d(TAG, "removeProximityAlert: intent = " + intent);
        } //End block
        try 
        {
            mService.removeProximityAlert(intent);
        } //End block
        catch (RemoteException ex)
        { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.963 -0400", hash_original_method = "A73A17F882D5C0CB78BFCF12E6BF5D56", hash_generated_method = "73D17BB45E39CDC5643F77EAFFAD2350")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isProviderEnabled(String provider) {
        dsTaint.addTaint(provider);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        try 
        {
            boolean var2CACBF2D859EB1EA82940C38019F9178_1047356865 = (mService.isProviderEnabled(provider));
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.963 -0400", hash_original_method = "C11453A15D8C96574C829BE27A4B0DFD", hash_generated_method = "F45ECF04C3FD97DEB7D7481718105166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Location getLastKnownLocation(String provider) {
        dsTaint.addTaint(provider);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } //End block
        try 
        {
            Location var44A3A3D7DF18245B739141D75E1C6FB4_781916757 = (mService.getLastKnownLocation(provider));
        } //End block
        catch (RemoteException ex)
        { }
        return (Location)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.963 -0400", hash_original_method = "03E8D8A5CD41A64BA401E8781419DF72", hash_generated_method = "282F0AEE06884135096F43BA7A30A373")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addTestProvider(String name, boolean requiresNetwork, boolean requiresSatellite,
        boolean requiresCell, boolean hasMonetaryCost, boolean supportsAltitude,
        boolean supportsSpeed, boolean supportsBearing, int powerRequirement, int accuracy) {
        dsTaint.addTaint(supportsSpeed);
        dsTaint.addTaint(requiresSatellite);
        dsTaint.addTaint(supportsBearing);
        dsTaint.addTaint(name);
        dsTaint.addTaint(hasMonetaryCost);
        dsTaint.addTaint(powerRequirement);
        dsTaint.addTaint(supportsAltitude);
        dsTaint.addTaint(requiresCell);
        dsTaint.addTaint(accuracy);
        dsTaint.addTaint(requiresNetwork);
        try 
        {
            mService.addTestProvider(name, requiresNetwork, requiresSatellite, requiresCell,
                hasMonetaryCost, supportsAltitude, supportsSpeed, supportsBearing, powerRequirement,
                accuracy);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.addTestProvider(name, requiresNetwork, requiresSatellite, requiresCell,
                //hasMonetaryCost, supportsAltitude, supportsSpeed, supportsBearing, powerRequirement,
                //accuracy);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "addTestProvider: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.964 -0400", hash_original_method = "498EE4F1DD4EF06996FBFECAF808CC3B", hash_generated_method = "3DCE954E78954A8283C7F5CBA5957858")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeTestProvider(String provider) {
        dsTaint.addTaint(provider);
        try 
        {
            mService.removeTestProvider(provider);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.removeTestProvider(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "removeTestProvider: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.964 -0400", hash_original_method = "68207A112A1E7BBE4826B19769FC12DA", hash_generated_method = "C090D9EE5B34BEA6C201C13282D5D323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTestProviderLocation(String provider, Location loc) {
        dsTaint.addTaint(loc.dsTaint);
        dsTaint.addTaint(provider);
        try 
        {
            mService.setTestProviderLocation(provider, loc);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setTestProviderLocation(provider, loc);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "setTestProviderLocation: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.964 -0400", hash_original_method = "7CA7069D9943855589356239516DA9AF", hash_generated_method = "C2E8771B4D0EE6278D98C284F333754C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearTestProviderLocation(String provider) {
        dsTaint.addTaint(provider);
        try 
        {
            mService.clearTestProviderLocation(provider);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.clearTestProviderLocation(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "clearTestProviderLocation: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.964 -0400", hash_original_method = "48C675867948B21786DBAE4C1AE4920C", hash_generated_method = "482CD6C7E1DF9C71EEBD1207A8C9DB71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTestProviderEnabled(String provider, boolean enabled) {
        dsTaint.addTaint(enabled);
        dsTaint.addTaint(provider);
        try 
        {
            mService.setTestProviderEnabled(provider, enabled);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setTestProviderEnabled(provider, enabled);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "setTestProviderEnabled: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.965 -0400", hash_original_method = "A7FE0DFAA40049E1860E732454FD3827", hash_generated_method = "7A1849BE0B0CBDBC9C36958D91DAD9B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearTestProviderEnabled(String provider) {
        dsTaint.addTaint(provider);
        try 
        {
            mService.clearTestProviderEnabled(provider);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.clearTestProviderEnabled(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "clearTestProviderEnabled: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.965 -0400", hash_original_method = "03886DE73D19ECB6C62373F8D9D58CA9", hash_generated_method = "C294E2771DEB529D8AAAD8BEE9C5BCAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTestProviderStatus(String provider, int status, Bundle extras, long updateTime) {
        dsTaint.addTaint(updateTime);
        dsTaint.addTaint(status);
        dsTaint.addTaint(provider);
        dsTaint.addTaint(extras.dsTaint);
        try 
        {
            mService.setTestProviderStatus(provider, status, extras, updateTime);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setTestProviderStatus(provider, status, extras, updateTime);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "setTestProviderStatus: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.965 -0400", hash_original_method = "013DF8509B89AA0EABD8A254078FCC60", hash_generated_method = "B90FF411EDC871A2031B55EBACBCFE3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearTestProviderStatus(String provider) {
        dsTaint.addTaint(provider);
        try 
        {
            mService.clearTestProviderStatus(provider);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.clearTestProviderStatus(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "clearTestProviderStatus: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.966 -0400", hash_original_method = "735E28281E7A2112C9B0A11E7D511734", hash_generated_method = "14D950DE17051332BDE3FF5C64806BC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addGpsStatusListener(GpsStatus.Listener listener) {
        dsTaint.addTaint(listener.dsTaint);
        boolean result;
        {
            boolean var5F2513550597BAA97D4D74F98C95E02D_2050827898 = (mGpsStatusListeners.get(listener) != null);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.966 -0400", hash_original_method = "BE93B3D03F00A664B96E561F38428949", hash_generated_method = "CBC04F6D69EA87C3F75249759EE9810E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeGpsStatusListener(GpsStatus.Listener listener) {
        dsTaint.addTaint(listener.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.967 -0400", hash_original_method = "69F227E2B854C20A513354DE72686880", hash_generated_method = "EED658A663D44467D80AAD94A7432D18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addNmeaListener(GpsStatus.NmeaListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        boolean result;
        {
            boolean var94A6474BA2F49BF4171CA676610F86BC_498880201 = (mNmeaListeners.get(listener) != null);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.967 -0400", hash_original_method = "B4F97B229D6634102324704B9EDD8365", hash_generated_method = "335758B2FA99D36BF3C7003454C92CE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeNmeaListener(GpsStatus.NmeaListener listener) {
        dsTaint.addTaint(listener.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.967 -0400", hash_original_method = "58632EF952FC4DB3D625E7340D0B4D49", hash_generated_method = "63EAB61FCD439C1E8EBC7E8078E11503")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GpsStatus getGpsStatus(GpsStatus status) {
        dsTaint.addTaint(status.dsTaint);
        {
            status = new GpsStatus();
        } //End block
        status.setStatus(mGpsStatus);
        return (GpsStatus)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (status == null) {
            //status = new GpsStatus();
       //}
        //status.setStatus(mGpsStatus);
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.967 -0400", hash_original_method = "A7B31AF326321489C7AFBE2F446F3E30", hash_generated_method = "11D923CE2D70E3920A6CC723300A80A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sendExtraCommand(String provider, String command, Bundle extras) {
        dsTaint.addTaint(command);
        dsTaint.addTaint(provider);
        dsTaint.addTaint(extras.dsTaint);
        try 
        {
            boolean var54C526BCA32BFB67E2D9FD83D51E8E2C_1391630157 = (mService.sendExtraCommand(provider, command, extras));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.sendExtraCommand(provider, command, extras);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in sendExtraCommand: ", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.968 -0400", hash_original_method = "486A02DD90A0BB213EFD64094D84B261", hash_generated_method = "CF70C9192CA4EB2DB64AA539B59DAFE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sendNiResponse(int notifId, int userResponse) {
        dsTaint.addTaint(userResponse);
        dsTaint.addTaint(notifId);
        try 
        {
            boolean var5F2B4C98AB0C6ADE0371DA0514391756_50647048 = (mService.sendNiResponse(notifId, userResponse));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.sendNiResponse(notifId, userResponse);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in sendNiResponse: ", e);
            //return false;
        //}
    }

    
    private class ListenerTransport extends ILocationListener.Stub {
        private LocationListener mListener;
        private Handler mListenerHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.978 -0400", hash_original_method = "5AF1CAA1D5EED50BE6CA5764BFEB7286", hash_generated_method = "2B3948E3BBD594A645927936B3BDDBB3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ListenerTransport(LocationListener listener, Looper looper) {
            dsTaint.addTaint(looper.dsTaint);
            dsTaint.addTaint(listener.dsTaint);
            {
                mListenerHandler = new Handler() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.968 -0400", hash_original_method = "2788B827BF69A5605D676A806900279A", hash_generated_method = "1E1CCA9DB52DB950112D49425332AC24")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void handleMessage(Message msg) {
                        dsTaint.addTaint(msg.dsTaint);
                        _handleMessage(msg);
                        // ---------- Original Method ----------
                        //_handleMessage(msg);
                    }
};
            } //End block
            {
                mListenerHandler = new Handler(looper) {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.978 -0400", hash_original_method = "2788B827BF69A5605D676A806900279A", hash_generated_method = "1E1CCA9DB52DB950112D49425332AC24")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void handleMessage(Message msg) {
                        dsTaint.addTaint(msg.dsTaint);
                        _handleMessage(msg);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.980 -0400", hash_original_method = "A17E439126795FFA0E8C33868ED647C4", hash_generated_method = "86749498CDB4ECDE84C67510662AC471")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onLocationChanged(Location location) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(location.dsTaint);
            Message msg;
            msg = Message.obtain();
            msg.what = TYPE_LOCATION_CHANGED;
            msg.obj = location;
            mListenerHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.what = TYPE_LOCATION_CHANGED;
            //msg.obj = location;
            //mListenerHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.983 -0400", hash_original_method = "BF8F7C90ADE4983F5319C798EB4A7E9F", hash_generated_method = "D9D015F3BB971B3FCC14551550CB3555")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onStatusChanged(String provider, int status, Bundle extras) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(status);
            dsTaint.addTaint(provider);
            dsTaint.addTaint(extras.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.985 -0400", hash_original_method = "812D643BCDC2A4502FF3E1F391BA3BAF", hash_generated_method = "BF163D1E0ABCF15B43816A477BC936A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onProviderEnabled(String provider) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(provider);
            Message msg;
            msg = Message.obtain();
            msg.what = TYPE_PROVIDER_ENABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.what = TYPE_PROVIDER_ENABLED;
            //msg.obj = provider;
            //mListenerHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.988 -0400", hash_original_method = "E15FA24A6514F29CC56145BCCEFEF320", hash_generated_method = "4B91D76BF2FC7E985510B39123E6C5DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onProviderDisabled(String provider) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(provider);
            Message msg;
            msg = Message.obtain();
            msg.what = TYPE_PROVIDER_DISABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.what = TYPE_PROVIDER_DISABLED;
            //msg.obj = provider;
            //mListenerHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.991 -0400", hash_original_method = "B4AFFA03A7F956D43DB0E44DEB20B60F", hash_generated_method = "6F6224E0745CBC4424B046A383940356")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void _handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final int TYPE_LOCATION_CHANGED = 1;
        private static final int TYPE_STATUS_CHANGED = 2;
        private static final int TYPE_PROVIDER_ENABLED = 3;
        private static final int TYPE_PROVIDER_DISABLED = 4;
    }


    
    private class GpsStatusListenerTransport extends IGpsStatusListener.Stub {
        private GpsStatus.Listener mListener;
        private GpsStatus.NmeaListener mNmeaListener;
        private ArrayList<Nmea> mNmeaBuffer;
        private final Handler mGpsHandler = new Handler() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.992 -0400", hash_original_method = "3A4C26C18C998E8AD28D793D2B4D73AC", hash_generated_method = "E9009AA990BD527781EBEEF61E03D680")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void handleMessage(Message msg) {
                dsTaint.addTaint(msg.dsTaint);
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

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.993 -0400", hash_original_method = "F4C48E1C52D52EE2A00BB4471F3F104F", hash_generated_method = "244638B14D360C40F83BE1B54908C77E")
        @DSModeled(DSC.SAFE)
         GpsStatusListenerTransport(GpsStatus.Listener listener) {
            dsTaint.addTaint(listener.dsTaint);
            mNmeaListener = null;
            // ---------- Original Method ----------
            //mListener = listener;
            //mNmeaListener = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.993 -0400", hash_original_method = "2F84EC7497CDA44BC0A09FBB4C2AE91B", hash_generated_method = "5B08CF9C90DB6BC0D39B997717871F90")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         GpsStatusListenerTransport(GpsStatus.NmeaListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            mListener = null;
            mNmeaBuffer = new ArrayList<Nmea>();
            // ---------- Original Method ----------
            //mNmeaListener = listener;
            //mListener = null;
            //mNmeaBuffer = new ArrayList<Nmea>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.994 -0400", hash_original_method = "03DD372B4F74F556A5CFC2950F002742", hash_generated_method = "F953C1733E6F0044D9DD1C141F224C4E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.994 -0400", hash_original_method = "30C4A680AA9F7AF81E647400DEBA508E", hash_generated_method = "18F747EE3747CC12C7795B67D48B597C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.994 -0400", hash_original_method = "E5DFF9ED39044E57371BE0E746E84457", hash_generated_method = "A47CEEF0F120044D9336E15BD99E52FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onFirstFix(int ttff) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ttff);
            {
                mGpsStatus.setTimeToFirstFix(ttff);
                Message msg;
                msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_FIRST_FIX;
                mGpsHandler.sendMessage(msg);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                //mGpsStatus.setTimeToFirstFix(ttff);
                //Message msg = Message.obtain();
                //msg.what = GpsStatus.GPS_EVENT_FIRST_FIX;
                //mGpsHandler.sendMessage(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.995 -0400", hash_original_method = "6F6B969ADA567E96DFAB5A585780E70F", hash_generated_method = "3CB2CB5876D5725B3CED206B22C1CF00")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onSvStatusChanged(int svCount, int[] prns, float[] snrs,
                float[] elevations, float[] azimuths, int ephemerisMask,
                int almanacMask, int usedInFixMask) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(svCount);
            dsTaint.addTaint(almanacMask);
            dsTaint.addTaint(azimuths[0]);
            dsTaint.addTaint(ephemerisMask);
            dsTaint.addTaint(elevations[0]);
            dsTaint.addTaint(snrs[0]);
            dsTaint.addTaint(prns[0]);
            dsTaint.addTaint(usedInFixMask);
            {
                mGpsStatus.setStatus(svCount, prns, snrs, elevations, azimuths,
                        ephemerisMask, almanacMask, usedInFixMask);
                Message msg;
                msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_SATELLITE_STATUS;
                mGpsHandler.removeMessages(GpsStatus.GPS_EVENT_SATELLITE_STATUS);
                mGpsHandler.sendMessage(msg);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.995 -0400", hash_original_method = "D97F778C22B6B561834B5A8A67FE2F57", hash_generated_method = "CD2C0196E9B47A3FDC7FE4C2540CEBB5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onNmeaReceived(long timestamp, String nmea) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(timestamp);
            dsTaint.addTaint(nmea);
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
            long mTimestamp;
            String mNmea;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.996 -0400", hash_original_method = "7FAFEC38F5688F1D1ACFE15C845DEFCA", hash_generated_method = "5EA045F75D3097F71835C6110AE48E5C")
            @DSModeled(DSC.SAFE)
             Nmea(long timestamp, String nmea) {
                dsTaint.addTaint(timestamp);
                dsTaint.addTaint(nmea);
                // ---------- Original Method ----------
                //mTimestamp = timestamp;
                //mNmea = nmea;
            }

            
        }


        
        private static final int NMEA_RECEIVED = 1000;
    }


    
    private static final String TAG = "LocationManager";
    public static final String NETWORK_PROVIDER = "network";
    public static final String GPS_PROVIDER = "gps";
    public static final String PASSIVE_PROVIDER = "passive";
    public static final String KEY_PROXIMITY_ENTERING = "entering";
    public static final String KEY_STATUS_CHANGED = "status";
    public static final String KEY_PROVIDER_ENABLED = "providerEnabled";
    public static final String KEY_LOCATION_CHANGED = "location";
    public static final String GPS_ENABLED_CHANGE_ACTION =
        "android.location.GPS_ENABLED_CHANGE";
    public static final String PROVIDERS_CHANGED_ACTION =
        "android.location.PROVIDERS_CHANGED";
    public static final String GPS_FIX_CHANGE_ACTION =
        "android.location.GPS_FIX_CHANGE";
    public static final String EXTRA_GPS_ENABLED = "enabled";
}

