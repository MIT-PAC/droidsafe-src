package android.location;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import com.android.internal.location.DummyLocationProvider;






public class LocationManager {
    private ILocationManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.981 -0400", hash_original_field = "E2A11423CD47DDE43A56192D7AD5E343", hash_generated_field = "267657B565621B0ADE15AB65C02CB118")

    private final HashMap<GpsStatus.Listener, GpsStatusListenerTransport> mGpsStatusListeners = new HashMap<GpsStatus.Listener, GpsStatusListenerTransport>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.981 -0400", hash_original_field = "6E4D80FCEA0E3887597BCFB0AAD138B3", hash_generated_field = "02F0F8A71DAB2C0D57E5F8A9755AD81D")

    private final HashMap<GpsStatus.NmeaListener, GpsStatusListenerTransport> mNmeaListeners = new HashMap<GpsStatus.NmeaListener, GpsStatusListenerTransport>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.981 -0400", hash_original_field = "32B45E8E9C286292F46EB969FF97E787", hash_generated_field = "67298A043ECF767C436304F77EB3BADE")

    private final GpsStatus mGpsStatus = new GpsStatus();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.981 -0400", hash_original_field = "64782091A962E40B4E33605344BA5307", hash_generated_field = "806CFA905E48C4B7D75890759825B149")

    private HashMap<LocationListener,ListenerTransport> mListeners = new HashMap<LocationListener,ListenerTransport>();
    
    @DSModeled(DSC.BAN)
	public LocationManager(ILocationManager service) {
        mService = service;
        addTaint(service.getTaint());
    }

    @DSModeled(DSC.BAN)
    public LocationManager() {
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.982 -0400", hash_original_method = "F4540EAD4F3CF2106C64C62C1DCA569C", hash_generated_method = "E6B9FBD61969F58B1DACCB8EE5D070EE")
    private LocationProvider createProvider(String name, Bundle info) {
        addTaint(info.getTaint());
        addTaint(name.getTaint());
        DummyLocationProvider provider = new DummyLocationProvider(name, mService);
        provider.setRequiresNetwork(info.getBoolean("network"));
        provider.setRequiresSatellite(info.getBoolean("satellite"));
        provider.setRequiresCell(info.getBoolean("cell"));
        provider.setHasMonetaryCost(info.getBoolean("cost"));
        provider.setSupportsAltitude(info.getBoolean("altitude"));
        provider.setSupportsSpeed(info.getBoolean("speed"));
        provider.setSupportsBearing(info.getBoolean("bearing"));
        provider.setPowerRequirement(info.getInt("power"));
        provider.setAccuracy(info.getInt("accuracy"));
LocationProvider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1270444639 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_1270444639.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1270444639;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.983 -0400", hash_original_method = "4EC410201344BFF6367B3FC4DEB2ECDD", hash_generated_method = "A931231A1710B4E21FD6F3423F8042AC")
    public List<String> getAllProviders() {
        if(false)        
        {
            Log.d(TAG, "getAllProviders");
        } //End block
        try 
        {
List<String> var8F05184B04C79079625D0D845BCD2D2B_1083548472 =             mService.getAllProviders();
            var8F05184B04C79079625D0D845BCD2D2B_1083548472.addTaint(taint);
            return var8F05184B04C79079625D0D845BCD2D2B_1083548472;
        } //End block
        catch (RemoteException ex)
        {
        } //End block
List<String> var540C13E9E156B687226421B24F2DF178_900123746 =         null;
        var540C13E9E156B687226421B24F2DF178_900123746.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_900123746;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.983 -0400", hash_original_method = "229C505A2DE7B350090013A910A6BB48", hash_generated_method = "511255615A119CADF274154B8875D15E")
    public List<String> getProviders(boolean enabledOnly) {
        addTaint(enabledOnly);
        try 
        {
List<String> var1814699AB3EBC0A36A6E6D7894EACDDE_1167187148 =             mService.getProviders(null, enabledOnly);
            var1814699AB3EBC0A36A6E6D7894EACDDE_1167187148.addTaint(taint);
            return var1814699AB3EBC0A36A6E6D7894EACDDE_1167187148;
        } //End block
        catch (RemoteException ex)
        {
        } //End block
List<String> var540C13E9E156B687226421B24F2DF178_1086257911 =         null;
        var540C13E9E156B687226421B24F2DF178_1086257911.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1086257911;
        // ---------- Original Method ----------
        //try {
            //return mService.getProviders(null, enabledOnly);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getProviders: RemoteException", ex);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.984 -0400", hash_original_method = "14AFABFCECA2A03E46C22CB46D5D2D56", hash_generated_method = "9182A3684B77698001103FED7C276619")
    public LocationProvider getProvider(String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException varF15D181B466A7CB11A2B97401D2E8520_1270238470 = new IllegalArgumentException("name==null");
            varF15D181B466A7CB11A2B97401D2E8520_1270238470.addTaint(taint);
            throw varF15D181B466A7CB11A2B97401D2E8520_1270238470;
        } //End block
        try 
        {
            Bundle info = mService.getProviderInfo(name);
            if(info == null)            
            {
LocationProvider var540C13E9E156B687226421B24F2DF178_66464258 =                 null;
                var540C13E9E156B687226421B24F2DF178_66464258.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_66464258;
            } //End block
LocationProvider var75766B94E411138F2572F277B04DC19A_425164831 =             createProvider(name, info);
            var75766B94E411138F2572F277B04DC19A_425164831.addTaint(taint);
            return var75766B94E411138F2572F277B04DC19A_425164831;
        } //End block
        catch (RemoteException ex)
        {
        } //End block
LocationProvider var540C13E9E156B687226421B24F2DF178_473222543 =         null;
        var540C13E9E156B687226421B24F2DF178_473222543.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_473222543;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.984 -0400", hash_original_method = "03CC9524D6FEF78A1BD79E07965ADEF5", hash_generated_method = "E79158A9A50FC9B770992955E1C648E7")
    public List<String> getProviders(Criteria criteria, boolean enabledOnly) {
        addTaint(enabledOnly);
        addTaint(criteria.getTaint());
        if(criteria == null)        
        {
            IllegalArgumentException varD3D4F40C13681232B432D0335FB0E944_744413505 = new IllegalArgumentException("criteria==null");
            varD3D4F40C13681232B432D0335FB0E944_744413505.addTaint(taint);
            throw varD3D4F40C13681232B432D0335FB0E944_744413505;
        } //End block
        try 
        {
List<String> var03CBF3D3FC4216DE34B5A7CE16E25B23_1129354207 =             mService.getProviders(criteria, enabledOnly);
            var03CBF3D3FC4216DE34B5A7CE16E25B23_1129354207.addTaint(taint);
            return var03CBF3D3FC4216DE34B5A7CE16E25B23_1129354207;
        } //End block
        catch (RemoteException ex)
        {
        } //End block
List<String> var540C13E9E156B687226421B24F2DF178_1117669684 =         null;
        var540C13E9E156B687226421B24F2DF178_1117669684.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1117669684;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.985 -0400", hash_original_method = "E63BBD2716EE0B4343F6D6F30C802349", hash_generated_method = "E28EE753773C8CDB37549A581EED3C9D")
    public String getBestProvider(Criteria criteria, boolean enabledOnly) {
        addTaint(enabledOnly);
        addTaint(criteria.getTaint());
        if(criteria == null)        
        {
            IllegalArgumentException varD3D4F40C13681232B432D0335FB0E944_940645537 = new IllegalArgumentException("criteria==null");
            varD3D4F40C13681232B432D0335FB0E944_940645537.addTaint(taint);
            throw varD3D4F40C13681232B432D0335FB0E944_940645537;
        } //End block
        try 
        {
String var3B09553E785870666C2E0A4FEECF373B_1737539485 =             mService.getBestProvider(criteria, enabledOnly);
            var3B09553E785870666C2E0A4FEECF373B_1737539485.addTaint(taint);
            return var3B09553E785870666C2E0A4FEECF373B_1737539485;
        } //End block
        catch (RemoteException ex)
        {
        } //End block
String var540C13E9E156B687226421B24F2DF178_11489280 =         null;
        var540C13E9E156B687226421B24F2DF178_11489280.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_11489280;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.985 -0400", hash_original_method = "79B0FCFC5B63DF5D944678DA62AFE363", hash_generated_method = "52636F7D8FC2E80863E9DF747C3029E6")
    public void requestLocationUpdates(String provider,
        long minTime, float minDistance, LocationListener listener) {
        addTaint(listener.getTaint());
        addTaint(minDistance);
        addTaint(minTime);
        addTaint(provider.getTaint());
        if(provider == null)        
        {
            IllegalArgumentException var3740E938BA9AB726EFDC662393650C35_812000166 = new IllegalArgumentException("provider==null");
            var3740E938BA9AB726EFDC662393650C35_812000166.addTaint(taint);
            throw var3740E938BA9AB726EFDC662393650C35_812000166;
        } //End block
        if(listener == null)        
        {
            IllegalArgumentException var7043C6EA473A5549851069BB129512CC_735567496 = new IllegalArgumentException("listener==null");
            var7043C6EA473A5549851069BB129512CC_735567496.addTaint(taint);
            throw var7043C6EA473A5549851069BB129512CC_735567496;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.986 -0400", hash_original_method = "FA80C6D3E17A94A62F4AA64272188CF2", hash_generated_method = "FF61B45260E9C671979ED17DC3018942")
    public void requestLocationUpdates(String provider,
        long minTime, float minDistance, LocationListener listener,
        Looper looper) {
        addTaint(looper.getTaint());
        addTaint(listener.getTaint());
        addTaint(minDistance);
        addTaint(minTime);
        addTaint(provider.getTaint());
        if(provider == null)        
        {
            IllegalArgumentException var3740E938BA9AB726EFDC662393650C35_1090428403 = new IllegalArgumentException("provider==null");
            var3740E938BA9AB726EFDC662393650C35_1090428403.addTaint(taint);
            throw var3740E938BA9AB726EFDC662393650C35_1090428403;
        } //End block
        if(listener == null)        
        {
            IllegalArgumentException var7043C6EA473A5549851069BB129512CC_1421586102 = new IllegalArgumentException("listener==null");
            var7043C6EA473A5549851069BB129512CC_1421586102.addTaint(taint);
            throw var7043C6EA473A5549851069BB129512CC_1421586102;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.986 -0400", hash_original_method = "2A4D2871A80639591D176F262A5FC273", hash_generated_method = "D07291A86469A90F8EED1D03845871AC")
    public void requestLocationUpdates(long minTime, float minDistance,
            Criteria criteria, LocationListener listener, Looper looper) {
        addTaint(looper.getTaint());
        addTaint(listener.getTaint());
        addTaint(criteria.getTaint());
        addTaint(minDistance);
        addTaint(minTime);
        if(criteria == null)        
        {
            IllegalArgumentException varD3D4F40C13681232B432D0335FB0E944_1435200664 = new IllegalArgumentException("criteria==null");
            varD3D4F40C13681232B432D0335FB0E944_1435200664.addTaint(taint);
            throw varD3D4F40C13681232B432D0335FB0E944_1435200664;
        } //End block
        if(listener == null)        
        {
            IllegalArgumentException var7043C6EA473A5549851069BB129512CC_1838057662 = new IllegalArgumentException("listener==null");
            var7043C6EA473A5549851069BB129512CC_1838057662.addTaint(taint);
            throw var7043C6EA473A5549851069BB129512CC_1838057662;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.987 -0400", hash_original_method = "7527D3AF7E08617A40988967AFB4FC4D", hash_generated_method = "324B2DB34138E35B89555069BC343BA8")
    private void _requestLocationUpdates(String provider, Criteria criteria, long minTime,
            float minDistance, boolean singleShot, LocationListener listener, Looper looper) {
        addTaint(looper.getTaint());
        addTaint(listener.getTaint());
        addTaint(singleShot);
        addTaint(minDistance);
        addTaint(minTime);
        addTaint(criteria.getTaint());
        addTaint(provider.getTaint());
        if(minTime < 0L)        
        {
            minTime = 0L;
        } //End block
        if(minDistance < 0.0f)        
        {
            minDistance = 0.0f;
        } //End block
        try 
        {
            synchronized
(mListeners)            {
                ListenerTransport transport = mListeners.get(listener);
                if(transport == null)                
                {
                    transport = new ListenerTransport(listener, looper);
                } //End block
                mListeners.put(listener, transport);
                mService.requestLocationUpdates(provider, criteria, minTime, minDistance, singleShot, transport);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.988 -0400", hash_original_method = "C7C08F02B5B72D29F482122DD6AFB995", hash_generated_method = "1B8E013FF99F20568ECC6627928160A6")
    public void requestLocationUpdates(String provider,
            long minTime, float minDistance, PendingIntent intent) {
        addTaint(intent.getTaint());
        addTaint(minDistance);
        addTaint(minTime);
        addTaint(provider.getTaint());
        if(provider == null)        
        {
            IllegalArgumentException var3740E938BA9AB726EFDC662393650C35_1901692192 = new IllegalArgumentException("provider==null");
            var3740E938BA9AB726EFDC662393650C35_1901692192.addTaint(taint);
            throw var3740E938BA9AB726EFDC662393650C35_1901692192;
        } //End block
        if(intent == null)        
        {
            IllegalArgumentException var3AB8E7FC8BA32C0031AF65BB60BCBA3B_2050384827 = new IllegalArgumentException("intent==null");
            var3AB8E7FC8BA32C0031AF65BB60BCBA3B_2050384827.addTaint(taint);
            throw var3AB8E7FC8BA32C0031AF65BB60BCBA3B_2050384827;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.988 -0400", hash_original_method = "2F287C6E75A45C2A01B3C0BCBDE67B57", hash_generated_method = "6D5D9046B72D3BC836D4E65ED1DB10EF")
    public void requestLocationUpdates(long minTime, float minDistance, Criteria criteria, PendingIntent intent) {
        addTaint(intent.getTaint());
        addTaint(criteria.getTaint());
        addTaint(minDistance);
        addTaint(minTime);
        if(criteria == null)        
        {
            IllegalArgumentException varD3D4F40C13681232B432D0335FB0E944_1454259176 = new IllegalArgumentException("criteria==null");
            varD3D4F40C13681232B432D0335FB0E944_1454259176.addTaint(taint);
            throw varD3D4F40C13681232B432D0335FB0E944_1454259176;
        } //End block
        if(intent == null)        
        {
            IllegalArgumentException var3AB8E7FC8BA32C0031AF65BB60BCBA3B_258581282 = new IllegalArgumentException("intent==null");
            var3AB8E7FC8BA32C0031AF65BB60BCBA3B_258581282.addTaint(taint);
            throw var3AB8E7FC8BA32C0031AF65BB60BCBA3B_258581282;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.989 -0400", hash_original_method = "21FA37E7FC7084DE02389BC0809F92F8", hash_generated_method = "547776629047CCC5CFE06266ED0BE550")
    private void _requestLocationUpdates(String provider, Criteria criteria,
            long minTime, float minDistance, boolean singleShot, PendingIntent intent) {
        addTaint(intent.getTaint());
        addTaint(singleShot);
        addTaint(minDistance);
        addTaint(minTime);
        addTaint(criteria.getTaint());
        addTaint(provider.getTaint());
        if(minTime < 0L)        
        {
            minTime = 0L;
        } //End block
        if(minDistance < 0.0f)        
        {
            minDistance = 0.0f;
        } //End block
        try 
        {
            mService.requestLocationUpdatesPI(provider, criteria, minTime, minDistance, singleShot, intent);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.989 -0400", hash_original_method = "E82A66C4B675428C8689D564FEFE46C0", hash_generated_method = "32B30A032FD8F3B24E0A45395558B63E")
    public void requestSingleUpdate(String provider, LocationListener listener, Looper looper) {
        addTaint(looper.getTaint());
        addTaint(listener.getTaint());
        addTaint(provider.getTaint());
        if(provider == null)        
        {
            IllegalArgumentException var3740E938BA9AB726EFDC662393650C35_1864199505 = new IllegalArgumentException("provider==null");
            var3740E938BA9AB726EFDC662393650C35_1864199505.addTaint(taint);
            throw var3740E938BA9AB726EFDC662393650C35_1864199505;
        } //End block
        if(listener == null)        
        {
            IllegalArgumentException var7043C6EA473A5549851069BB129512CC_1634310362 = new IllegalArgumentException("listener==null");
            var7043C6EA473A5549851069BB129512CC_1634310362.addTaint(taint);
            throw var7043C6EA473A5549851069BB129512CC_1634310362;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.989 -0400", hash_original_method = "A942F553EBD5189FF7258B50664EDDE9", hash_generated_method = "44607D8F15554C816032A189C64257A0")
    public void requestSingleUpdate(Criteria criteria, LocationListener listener, Looper looper) {
        addTaint(looper.getTaint());
        addTaint(listener.getTaint());
        addTaint(criteria.getTaint());
        if(criteria == null)        
        {
            IllegalArgumentException varD3D4F40C13681232B432D0335FB0E944_1415017309 = new IllegalArgumentException("criteria==null");
            varD3D4F40C13681232B432D0335FB0E944_1415017309.addTaint(taint);
            throw varD3D4F40C13681232B432D0335FB0E944_1415017309;
        } //End block
        if(listener == null)        
        {
            IllegalArgumentException var7043C6EA473A5549851069BB129512CC_518173413 = new IllegalArgumentException("listener==null");
            var7043C6EA473A5549851069BB129512CC_518173413.addTaint(taint);
            throw var7043C6EA473A5549851069BB129512CC_518173413;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.990 -0400", hash_original_method = "71C843DE562F708F58659EAA42FBA5B9", hash_generated_method = "741A45910A27C993B38DEAF13ECCE815")
    public void requestSingleUpdate(String provider, PendingIntent intent) {
        addTaint(intent.getTaint());
        addTaint(provider.getTaint());
        if(provider == null)        
        {
            IllegalArgumentException var3740E938BA9AB726EFDC662393650C35_18634129 = new IllegalArgumentException("provider==null");
            var3740E938BA9AB726EFDC662393650C35_18634129.addTaint(taint);
            throw var3740E938BA9AB726EFDC662393650C35_18634129;
        } //End block
        if(intent == null)        
        {
            IllegalArgumentException var3AB8E7FC8BA32C0031AF65BB60BCBA3B_2091097182 = new IllegalArgumentException("intent==null");
            var3AB8E7FC8BA32C0031AF65BB60BCBA3B_2091097182.addTaint(taint);
            throw var3AB8E7FC8BA32C0031AF65BB60BCBA3B_2091097182;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.990 -0400", hash_original_method = "6685F769C73037425B092AE6FD387007", hash_generated_method = "418A5EF762C53F857A80EA405672092C")
    public void requestSingleUpdate(Criteria criteria, PendingIntent intent) {
        addTaint(intent.getTaint());
        addTaint(criteria.getTaint());
        if(criteria == null)        
        {
            IllegalArgumentException varD3D4F40C13681232B432D0335FB0E944_291109050 = new IllegalArgumentException("criteria==null");
            varD3D4F40C13681232B432D0335FB0E944_291109050.addTaint(taint);
            throw varD3D4F40C13681232B432D0335FB0E944_291109050;
        } //End block
        if(intent == null)        
        {
            IllegalArgumentException var3AB8E7FC8BA32C0031AF65BB60BCBA3B_2129841567 = new IllegalArgumentException("intent==null");
            var3AB8E7FC8BA32C0031AF65BB60BCBA3B_2129841567.addTaint(taint);
            throw var3AB8E7FC8BA32C0031AF65BB60BCBA3B_2129841567;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.991 -0400", hash_original_method = "C6393138E31F9EAAF3B1058E5B49E67E", hash_generated_method = "2DDB2476AE078956D672565AB4B7FE12")
    public void removeUpdates(LocationListener listener) {
        addTaint(listener.getTaint());
        if(listener == null)        
        {
            IllegalArgumentException var7043C6EA473A5549851069BB129512CC_740079453 = new IllegalArgumentException("listener==null");
            var7043C6EA473A5549851069BB129512CC_740079453.addTaint(taint);
            throw var7043C6EA473A5549851069BB129512CC_740079453;
        } //End block
        if(false)        
        {
            Log.d(TAG, "removeUpdates: listener = " + listener);
        } //End block
        try 
        {
            ListenerTransport transport = mListeners.remove(listener);
            if(transport != null)            
            {
                mService.removeUpdates(transport);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.991 -0400", hash_original_method = "53855AAE83CDCFDE219D3895B886D007", hash_generated_method = "E7582A04E798A86C01C8789F01298031")
    public void removeUpdates(PendingIntent intent) {
        addTaint(intent.getTaint());
        if(intent == null)        
        {
            IllegalArgumentException var3AB8E7FC8BA32C0031AF65BB60BCBA3B_733401039 = new IllegalArgumentException("intent==null");
            var3AB8E7FC8BA32C0031AF65BB60BCBA3B_733401039.addTaint(taint);
            throw var3AB8E7FC8BA32C0031AF65BB60BCBA3B_733401039;
        } //End block
        if(false)        
        {
            Log.d(TAG, "removeUpdates: intent = " + intent);
        } //End block
        try 
        {
            mService.removeUpdatesPI(intent);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.992 -0400", hash_original_method = "8F5138780FDD6FE26D92FDF1DF02DE4E", hash_generated_method = "B2A2AFF905C7EDB66920A2EBED19BF34")
    public void addProximityAlert(double latitude, double longitude,
        float radius, long expiration, PendingIntent intent) {
        addTaint(intent.getTaint());
        addTaint(expiration);
        addTaint(radius);
        addTaint(longitude);
        addTaint(latitude);
        if(false)        
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
        {
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.992 -0400", hash_original_method = "4A48D6353D1407BC4C3112124D5D3B7A", hash_generated_method = "D71B72D7A19FE42EC60E6813F635C11D")
    public void removeProximityAlert(PendingIntent intent) {
        addTaint(intent.getTaint());
        if(false)        
        {
            Log.d(TAG, "removeProximityAlert: intent = " + intent);
        } //End block
        try 
        {
            mService.removeProximityAlert(intent);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.992 -0400", hash_original_method = "A73A17F882D5C0CB78BFCF12E6BF5D56", hash_generated_method = "7560E8AC301D6BADBC67F80E473B5490")
    public boolean isProviderEnabled(String provider) {
        addTaint(provider.getTaint());
        if(provider == null)        
        {
            IllegalArgumentException var3740E938BA9AB726EFDC662393650C35_1580794890 = new IllegalArgumentException("provider==null");
            var3740E938BA9AB726EFDC662393650C35_1580794890.addTaint(taint);
            throw var3740E938BA9AB726EFDC662393650C35_1580794890;
        } //End block
        try 
        {
            boolean var2A2AA02B230E677DCE91C6E05A45AE75_1346673743 = (mService.isProviderEnabled(provider));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118460689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118460689;
        } //End block
        catch (RemoteException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1752738212 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_168496599 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_168496599;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.993 -0400", hash_original_method = "C11453A15D8C96574C829BE27A4B0DFD", hash_generated_method = "7B70CBDE081B95E75A69268514229255")
    public Location getLastKnownLocation(String provider) {
        addTaint(provider.getTaint());
        if(provider == null)        
        {
            IllegalArgumentException var3740E938BA9AB726EFDC662393650C35_408376459 = new IllegalArgumentException("provider==null");
            var3740E938BA9AB726EFDC662393650C35_408376459.addTaint(taint);
            throw var3740E938BA9AB726EFDC662393650C35_408376459;
        } //End block
        try 
        {
Location var94D744E5CB62D5F61288405519195D94_1241647484 =             mService.getLastKnownLocation(provider);
            var94D744E5CB62D5F61288405519195D94_1241647484.addTaint(taint);
            return var94D744E5CB62D5F61288405519195D94_1241647484;
        } //End block
        catch (RemoteException ex)
        {
Location var540C13E9E156B687226421B24F2DF178_1859180586 =             null;
            var540C13E9E156B687226421B24F2DF178_1859180586.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1859180586;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.993 -0400", hash_original_method = "03E8D8A5CD41A64BA401E8781419DF72", hash_generated_method = "507E7DF9EC740B536EC16566D621D282")
    public void addTestProvider(String name, boolean requiresNetwork, boolean requiresSatellite,
        boolean requiresCell, boolean hasMonetaryCost, boolean supportsAltitude,
        boolean supportsSpeed, boolean supportsBearing, int powerRequirement, int accuracy) {
        addTaint(accuracy);
        addTaint(powerRequirement);
        addTaint(supportsBearing);
        addTaint(supportsSpeed);
        addTaint(supportsAltitude);
        addTaint(hasMonetaryCost);
        addTaint(requiresCell);
        addTaint(requiresSatellite);
        addTaint(requiresNetwork);
        addTaint(name.getTaint());
        try 
        {
            mService.addTestProvider(name, requiresNetwork, requiresSatellite, requiresCell,
                hasMonetaryCost, supportsAltitude, supportsSpeed, supportsBearing, powerRequirement,
                accuracy);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.addTestProvider(name, requiresNetwork, requiresSatellite, requiresCell,
                //hasMonetaryCost, supportsAltitude, supportsSpeed, supportsBearing, powerRequirement,
                //accuracy);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "addTestProvider: RemoteException", ex);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.994 -0400", hash_original_method = "498EE4F1DD4EF06996FBFECAF808CC3B", hash_generated_method = "52B8F46CF5EA9EE694EC3A864DF079C2")
    public void removeTestProvider(String provider) {
        addTaint(provider.getTaint());
        try 
        {
            mService.removeTestProvider(provider);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.removeTestProvider(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "removeTestProvider: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.994 -0400", hash_original_method = "68207A112A1E7BBE4826B19769FC12DA", hash_generated_method = "5E17B10F4532FBA3517B9CDBF5871A2B")
    public void setTestProviderLocation(String provider, Location loc) {
        addTaint(loc.getTaint());
        addTaint(provider.getTaint());
        try 
        {
            mService.setTestProviderLocation(provider, loc);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setTestProviderLocation(provider, loc);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "setTestProviderLocation: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.994 -0400", hash_original_method = "7CA7069D9943855589356239516DA9AF", hash_generated_method = "919301D25966F80F8A4E325869320DF6")
    public void clearTestProviderLocation(String provider) {
        addTaint(provider.getTaint());
        try 
        {
            mService.clearTestProviderLocation(provider);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.clearTestProviderLocation(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "clearTestProviderLocation: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.995 -0400", hash_original_method = "48C675867948B21786DBAE4C1AE4920C", hash_generated_method = "6DCE32312510FC2656C70C7F2D574FB6")
    public void setTestProviderEnabled(String provider, boolean enabled) {
        addTaint(enabled);
        addTaint(provider.getTaint());
        try 
        {
            mService.setTestProviderEnabled(provider, enabled);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setTestProviderEnabled(provider, enabled);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "setTestProviderEnabled: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.995 -0400", hash_original_method = "A7FE0DFAA40049E1860E732454FD3827", hash_generated_method = "21A79DA8F378D2557A06FFF5D14B1AA5")
    public void clearTestProviderEnabled(String provider) {
        addTaint(provider.getTaint());
        try 
        {
            mService.clearTestProviderEnabled(provider);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.clearTestProviderEnabled(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "clearTestProviderEnabled: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.995 -0400", hash_original_method = "03886DE73D19ECB6C62373F8D9D58CA9", hash_generated_method = "25FCF6AB32E70FCD9F1EDE8114BAC8C7")
    public void setTestProviderStatus(String provider, int status, Bundle extras, long updateTime) {
        addTaint(updateTime);
        addTaint(extras.getTaint());
        addTaint(status);
        addTaint(provider.getTaint());
        try 
        {
            mService.setTestProviderStatus(provider, status, extras, updateTime);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setTestProviderStatus(provider, status, extras, updateTime);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "setTestProviderStatus: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.996 -0400", hash_original_method = "013DF8509B89AA0EABD8A254078FCC60", hash_generated_method = "0A371DA62B5AEE3942F1782553618C66")
    public void clearTestProviderStatus(String provider) {
        addTaint(provider.getTaint());
        try 
        {
            mService.clearTestProviderStatus(provider);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.clearTestProviderStatus(provider);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "clearTestProviderStatus: RemoteException", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.996 -0400", hash_original_method = "735E28281E7A2112C9B0A11E7D511734", hash_generated_method = "B685064BBE8E4850C9C170B0F4B2ED9D")
    public boolean addGpsStatusListener(GpsStatus.Listener listener) {
        addTaint(listener.getTaint());
        boolean result;
        if(mGpsStatusListeners.get(listener) != null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_439663451 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945618585 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945618585;
        } //End block
        try 
        {
            GpsStatusListenerTransport transport = new GpsStatusListenerTransport(listener);
            result = mService.addGpsStatusListener(transport);
            if(result)            
            {
                mGpsStatusListeners.put(listener, transport);
            } //End block
        } //End block
        catch (RemoteException e)
        {
            result = false;
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_1100937642 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1638954325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1638954325;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.997 -0400", hash_original_method = "BE93B3D03F00A664B96E561F38428949", hash_generated_method = "6F9122063858A2356605854F16D96125")
    public void removeGpsStatusListener(GpsStatus.Listener listener) {
        addTaint(listener.getTaint());
        try 
        {
            GpsStatusListenerTransport transport = mGpsStatusListeners.remove(listener);
            if(transport != null)            
            {
                mService.removeGpsStatusListener(transport);
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.997 -0400", hash_original_method = "69F227E2B854C20A513354DE72686880", hash_generated_method = "08A97064C42272463BBC5380C65D92B8")
    public boolean addNmeaListener(GpsStatus.NmeaListener listener) {
        addTaint(listener.getTaint());
        boolean result;
        if(mNmeaListeners.get(listener) != null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1848280334 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1205602442 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1205602442;
        } //End block
        try 
        {
            GpsStatusListenerTransport transport = new GpsStatusListenerTransport(listener);
            result = mService.addGpsStatusListener(transport);
            if(result)            
            {
                mNmeaListeners.put(listener, transport);
            } //End block
        } //End block
        catch (RemoteException e)
        {
            result = false;
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_2097994085 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_665609524 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_665609524;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.998 -0400", hash_original_method = "B4F97B229D6634102324704B9EDD8365", hash_generated_method = "BA4CCB516D951E409418DAB89BFD4E00")
    public void removeNmeaListener(GpsStatus.NmeaListener listener) {
        addTaint(listener.getTaint());
        try 
        {
            GpsStatusListenerTransport transport = mNmeaListeners.remove(listener);
            if(transport != null)            
            {
                mService.removeGpsStatusListener(transport);
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.998 -0400", hash_original_method = "58632EF952FC4DB3D625E7340D0B4D49", hash_generated_method = "E96F15D0274998BDD5BDC13518EC6C5D")
    public GpsStatus getGpsStatus(GpsStatus status) {
        addTaint(status.getTaint());
        if(status == null)        
        {
            status = new GpsStatus();
        } //End block
        status.setStatus(mGpsStatus);
GpsStatus var62D3D5D442782C1992154E821A40FA75_1740037446 =         status;
        var62D3D5D442782C1992154E821A40FA75_1740037446.addTaint(taint);
        return var62D3D5D442782C1992154E821A40FA75_1740037446;
        // ---------- Original Method ----------
        //if (status == null) {
            //status = new GpsStatus();
       //}
        //status.setStatus(mGpsStatus);
        //return status;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.999 -0400", hash_original_method = "A7B31AF326321489C7AFBE2F446F3E30", hash_generated_method = "CA48BCEAA483F098B2DDD1A001CFFDB7")
    public boolean sendExtraCommand(String provider, String command, Bundle extras) {
        addTaint(extras.getTaint());
        addTaint(command.getTaint());
        addTaint(provider.getTaint());
        try 
        {
            boolean var084E25188FDAC5368E5B559C2E044FF7_552758735 = (mService.sendExtraCommand(provider, command, extras));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703384874 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_703384874;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1241528863 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_359514888 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_359514888;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.sendExtraCommand(provider, command, extras);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in sendExtraCommand: ", e);
            //return false;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.999 -0400", hash_original_method = "486A02DD90A0BB213EFD64094D84B261", hash_generated_method = "306AC3B7E8A3F0216FC925ED69C72C30")
    public boolean sendNiResponse(int notifId, int userResponse) {
        addTaint(userResponse);
        addTaint(notifId);
        try 
        {
            boolean varFF109F67D44047D08F856E3EE6A94888_28914796 = (mService.sendNiResponse(notifId, userResponse));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_289478153 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_289478153;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_55926775 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_917786289 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_917786289;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.sendNiResponse(notifId, userResponse);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in sendNiResponse: ", e);
            //return false;
        //}
    }

    
    private class ListenerTransport extends ILocationListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.999 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "88C676C20BB164A41FD7C10E7FA78223")

        private LocationListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.999 -0400", hash_original_field = "56BAC178F3086AD35CDD4674A0CF1FF6", hash_generated_field = "4100173B517AAB1135352B9F9C7AE096")

        private Handler mListenerHandler;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.004 -0400", hash_original_method = "5AF1CAA1D5EED50BE6CA5764BFEB7286", hash_generated_method = "7697D37666ECBD1F4AE179EBFE8CA895")
          ListenerTransport(LocationListener listener, Looper looper) {
            mListener = listener;
            if(looper == null)            
            {
                mListenerHandler = new Handler() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.003 -0400", hash_original_method = "2788B827BF69A5605D676A806900279A", hash_generated_method = "B29FAE19F43EA72A9B37167689337DBD")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
                _handleMessage(msg);
                // ---------- Original Method ----------
                //_handleMessage(msg);
            }
};
            } //End block
            else
            {
                mListenerHandler = new Handler(looper) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.004 -0400", hash_original_method = "2788B827BF69A5605D676A806900279A", hash_generated_method = "B29FAE19F43EA72A9B37167689337DBD")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.004 -0400", hash_original_method = "A17E439126795FFA0E8C33868ED647C4", hash_generated_method = "373A4637FE7597C2709F21CB18D6F182")
        public void onLocationChanged(Location location) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(location.getTaint());
            Message msg = Message.obtain();
            msg.what = TYPE_LOCATION_CHANGED;
            msg.obj = location;
            mListenerHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.what = TYPE_LOCATION_CHANGED;
            //msg.obj = location;
            //mListenerHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.005 -0400", hash_original_method = "BF8F7C90ADE4983F5319C798EB4A7E9F", hash_generated_method = "083C901E323FDDADFE053B8000ADE8D1")
        public void onStatusChanged(String provider, int status, Bundle extras) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(extras.getTaint());
            addTaint(status);
            addTaint(provider.getTaint());
            Message msg = Message.obtain();
            msg.what = TYPE_STATUS_CHANGED;
            Bundle b = new Bundle();
            b.putString("provider", provider);
            b.putInt("status", status);
            if(extras != null)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.005 -0400", hash_original_method = "812D643BCDC2A4502FF3E1F391BA3BAF", hash_generated_method = "725ABBEFB45083351BB2BEA3889FA9CD")
        public void onProviderEnabled(String provider) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(provider.getTaint());
            Message msg = Message.obtain();
            msg.what = TYPE_PROVIDER_ENABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.what = TYPE_PROVIDER_ENABLED;
            //msg.obj = provider;
            //mListenerHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.006 -0400", hash_original_method = "E15FA24A6514F29CC56145BCCEFEF320", hash_generated_method = "A5BEF2B3B4DDD1BF0C8C30B6570A5460")
        public void onProviderDisabled(String provider) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(provider.getTaint());
            Message msg = Message.obtain();
            msg.what = TYPE_PROVIDER_DISABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.what = TYPE_PROVIDER_DISABLED;
            //msg.obj = provider;
            //mListenerHandler.sendMessage(msg);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.006 -0400", hash_original_method = "B4AFFA03A7F956D43DB0E44DEB20B60F", hash_generated_method = "15A6796DAAF4A1912417AF601BBACA6D")
        private void _handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case TYPE_LOCATION_CHANGED:
            Location location = new Location((Location) msg.obj);
            mListener.onLocationChanged(location);
            break;
            case TYPE_STATUS_CHANGED:
            Bundle b = (Bundle) msg.obj;
            String provider = b.getString("provider");
            int status = b.getInt("status");
            Bundle extras = b.getBundle("extras");
            mListener.onStatusChanged(provider, status, extras);
            break;
            case TYPE_PROVIDER_ENABLED:
            mListener.onProviderEnabled((String) msg.obj);
            break;
            case TYPE_PROVIDER_DISABLED:
            mListener.onProviderDisabled((String) msg.obj);
            break;
}            try 
            {
                mService.locationCallbackFinished(this);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.006 -0400", hash_original_field = "8C0B89388C7AF37135B00419CA7E9C92", hash_generated_field = "A0CA98E69FE18B704F4EDD23AF7F79E8")

        private static final int TYPE_LOCATION_CHANGED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.006 -0400", hash_original_field = "45E66B86E7431FAC1292C89E91493801", hash_generated_field = "8D044298B4BF37557EF84C728C50DFD4")

        private static final int TYPE_STATUS_CHANGED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.006 -0400", hash_original_field = "4D8B289A7864C6EE1ACDD3C1B058CE4F", hash_generated_field = "5E93656B2A797E677A4A922D41C08F3D")

        private static final int TYPE_PROVIDER_ENABLED = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.007 -0400", hash_original_field = "DD4E410FD111EAFC75B3615EB43DD4E3", hash_generated_field = "8BABDDB91091B99E5C494EDC7D408D8A")

        private static final int TYPE_PROVIDER_DISABLED = 4;
    }


    
    private class GpsStatusListenerTransport extends IGpsStatusListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.007 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "3564D5BECCC467DBB563E9174E6839FA")

        private GpsStatus.Listener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.007 -0400", hash_original_field = "6A914A5E364626F0BE69C7CA16741AC2", hash_generated_field = "C56AA1FA4293F00EF5AC3280F7CE1BCE")

        private GpsStatus.NmeaListener mNmeaListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.007 -0400", hash_original_field = "C91213C9D8B8761834B23071597A3455", hash_generated_field = "BDE0A966016D1F7F3E0759437CA71854")

        private ArrayList<Nmea> mNmeaBuffer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.008 -0400", hash_original_field = "1388D92E53A0B03AA5E995A7DC696BD0", hash_generated_field = "4720EC15678BF4030E408554AC619E18")

        private final Handler mGpsHandler = new Handler() {            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.008 -0400", hash_original_method = "3A4C26C18C998E8AD28D793D2B4D73AC", hash_generated_method = "E1DFFD73DC4C7189279ACF9161C46352")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
                if(msg.what == NMEA_RECEIVED)                
                {
                    synchronized
(mNmeaBuffer)                    {
                        int length = mNmeaBuffer.size();
for(int i = 0;i < length;i++)
                        {
                            Nmea nmea = mNmeaBuffer.get(i);
                            mNmeaListener.onNmeaReceived(nmea.mTimestamp, nmea.mNmea);
                        } //End block
                        mNmeaBuffer.clear();
                    } //End block
                } //End block
                else
                {
                    synchronized
(mGpsStatus)                    {
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

            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.008 -0400", hash_original_method = "F4C48E1C52D52EE2A00BB4471F3F104F", hash_generated_method = "5BD8573A0E58EE341269EDADEAA6CD32")
          GpsStatusListenerTransport(GpsStatus.Listener listener) {
            mListener = listener;
            mNmeaListener = null;
            // ---------- Original Method ----------
            //mListener = listener;
            //mNmeaListener = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.009 -0400", hash_original_method = "2F84EC7497CDA44BC0A09FBB4C2AE91B", hash_generated_method = "A64C791C45CA47B3BFECF96C00EDA552")
          GpsStatusListenerTransport(GpsStatus.NmeaListener listener) {
            mNmeaListener = listener;
            mListener = null;
            mNmeaBuffer = new ArrayList<Nmea>();
            // ---------- Original Method ----------
            //mNmeaListener = listener;
            //mListener = null;
            //mNmeaBuffer = new ArrayList<Nmea>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.009 -0400", hash_original_method = "03DD372B4F74F556A5CFC2950F002742", hash_generated_method = "EA299A85CCF224B3DE48BF56ACD52F67")
        public void onGpsStarted() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if(mListener != null)            
            {
                Message msg = Message.obtain();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.010 -0400", hash_original_method = "30C4A680AA9F7AF81E647400DEBA508E", hash_generated_method = "621E18683864DAB5C335FEE34B88D737")
        public void onGpsStopped() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if(mListener != null)            
            {
                Message msg = Message.obtain();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.011 -0400", hash_original_method = "E5DFF9ED39044E57371BE0E746E84457", hash_generated_method = "B236AE554935F09EA49455EE63390EE9")
        public void onFirstFix(int ttff) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ttff);
            if(mListener != null)            
            {
                mGpsStatus.setTimeToFirstFix(ttff);
                Message msg = Message.obtain();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.011 -0400", hash_original_method = "6F6B969ADA567E96DFAB5A585780E70F", hash_generated_method = "FD7EAAC0B167BF408BD785B4FE9AF83C")
        public void onSvStatusChanged(int svCount, int[] prns, float[] snrs,
                float[] elevations, float[] azimuths, int ephemerisMask,
                int almanacMask, int usedInFixMask) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(usedInFixMask);
            addTaint(almanacMask);
            addTaint(ephemerisMask);
            addTaint(azimuths[0]);
            addTaint(elevations[0]);
            addTaint(snrs[0]);
            addTaint(prns[0]);
            addTaint(svCount);
            if(mListener != null)            
            {
                mGpsStatus.setStatus(svCount, prns, snrs, elevations, azimuths,
                        ephemerisMask, almanacMask, usedInFixMask);
                Message msg = Message.obtain();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.012 -0400", hash_original_method = "D97F778C22B6B561834B5A8A67FE2F57", hash_generated_method = "992A67D64037BEEF35715BB67D0356A4")
        public void onNmeaReceived(long timestamp, String nmea) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(nmea.getTaint());
            addTaint(timestamp);
            if(mNmeaListener != null)            
            {
                synchronized
(mNmeaBuffer)                {
                    mNmeaBuffer.add(new Nmea(timestamp, nmea));
                } //End block
                Message msg = Message.obtain();
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.012 -0400", hash_original_field = "D0D8C7FFAD5AE68F861E40D637EC0463", hash_generated_field = "1D358F2CB412AAF1346451355CB8F3E3")

            long mTimestamp;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.012 -0400", hash_original_field = "5C868597A7B87315895D9C109908E910", hash_generated_field = "24AFD15E5AD8DD2E9530B1A85650CD93")

            String mNmea;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.013 -0400", hash_original_method = "7FAFEC38F5688F1D1ACFE15C845DEFCA", hash_generated_method = "2C01B97CF53E8C2E9DE64A323D518081")
              Nmea(long timestamp, String nmea) {
                mTimestamp = timestamp;
                mNmea = nmea;
                // ---------- Original Method ----------
                //mTimestamp = timestamp;
                //mNmea = nmea;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.013 -0400", hash_original_field = "D84CD7AC433F52E58A4CCA5B3DB61EAD", hash_generated_field = "6899010D64F70B3018C0CDC68B38D232")

        private static final int NMEA_RECEIVED = 1000;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.013 -0400", hash_original_field = "3DCB34AD9AF783DB01BF473D53795CF0", hash_generated_field = "28DF91E101BF22ECD70A2547DFBB55A7")

    private static final String TAG = "LocationManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.013 -0400", hash_original_field = "6EB3A04D83D3EB53836000A2B31706D3", hash_generated_field = "6A1159950B5F0D81FE05A0592F2DB1B2")

    public static final String NETWORK_PROVIDER = "network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.013 -0400", hash_original_field = "5511BBE363BBFBEF2A13CD3903A63DBA", hash_generated_field = "4C2280586138D33EB30E26156BDCB654")

    public static final String GPS_PROVIDER = "gps";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.014 -0400", hash_original_field = "1A76AC2B2F74ECACC05EB5A2C9A17D65", hash_generated_field = "F221EEFFFB6FF66793F94043F74CBC0B")

    public static final String PASSIVE_PROVIDER = "passive";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.014 -0400", hash_original_field = "1219C70453A4B51E7467604E9D21E2F1", hash_generated_field = "F9B4EC13158580C5DB06971A10A5663C")

    public static final String KEY_PROXIMITY_ENTERING = "entering";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.014 -0400", hash_original_field = "8BBFDB3591EF0B7BAF1E2C35BEE723C2", hash_generated_field = "F215A34B782985F96320EA9F9AC24ECE")

    public static final String KEY_STATUS_CHANGED = "status";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.014 -0400", hash_original_field = "EFC775B399B41180A7DFD2652A75BD6F", hash_generated_field = "E53B94E70159BE067785CDCFE51933F1")

    public static final String KEY_PROVIDER_ENABLED = "providerEnabled";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.014 -0400", hash_original_field = "BBB9637E7AD41C030E894E86C191AECF", hash_generated_field = "B9A8BCBF7A8975A62A8159DDE6821E45")

    public static final String KEY_LOCATION_CHANGED = "location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.014 -0400", hash_original_field = "400BD7DF293767AC387D02375DE71183", hash_generated_field = "4011D28AFA5049A3F8B84DAE600CE7B1")

    public static final String GPS_ENABLED_CHANGE_ACTION =
        "android.location.GPS_ENABLED_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.014 -0400", hash_original_field = "116A7AA128E8BD79F2FF79BDFA6FC928", hash_generated_field = "F1DA53484EFF7310FA2C5CCD96A5903D")

    public static final String PROVIDERS_CHANGED_ACTION =
        "android.location.PROVIDERS_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.014 -0400", hash_original_field = "DDA3CF7A2BE453FBAF12CC5166836588", hash_generated_field = "0ED670DE81E8FA835AC8A157321FBD93")

    public static final String GPS_FIX_CHANGE_ACTION =
        "android.location.GPS_FIX_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.015 -0400", hash_original_field = "494BD1FE78539565E73D758923F5ABF3", hash_generated_field = "AAD29DA0DDBC5FD40952BC68A7746945")

    public static final String EXTRA_GPS_ENABLED = "enabled";
}

