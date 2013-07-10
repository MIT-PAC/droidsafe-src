package android.location;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.807 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "172E00EA90AE9807366F5CA34B42799B")

    private ILocationManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.807 -0400", hash_original_field = "E2A11423CD47DDE43A56192D7AD5E343", hash_generated_field = "267657B565621B0ADE15AB65C02CB118")

    private final HashMap<GpsStatus.Listener, GpsStatusListenerTransport> mGpsStatusListeners = new HashMap<GpsStatus.Listener, GpsStatusListenerTransport>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.807 -0400", hash_original_field = "6E4D80FCEA0E3887597BCFB0AAD138B3", hash_generated_field = "02F0F8A71DAB2C0D57E5F8A9755AD81D")

    private final HashMap<GpsStatus.NmeaListener, GpsStatusListenerTransport> mNmeaListeners = new HashMap<GpsStatus.NmeaListener, GpsStatusListenerTransport>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.807 -0400", hash_original_field = "32B45E8E9C286292F46EB969FF97E787", hash_generated_field = "67298A043ECF767C436304F77EB3BADE")

    private final GpsStatus mGpsStatus = new GpsStatus();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.807 -0400", hash_original_field = "64782091A962E40B4E33605344BA5307", hash_generated_field = "806CFA905E48C4B7D75890759825B149")

    private HashMap<LocationListener,ListenerTransport> mListeners = new HashMap<LocationListener,ListenerTransport>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.807 -0400", hash_original_method = "1755E60A5AAD43AA8D18158DFDE91956", hash_generated_method = "2E87374DE599AAD38A38C4273DFE7501")
    public  LocationManager(ILocationManager service) {
        mService = service;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.808 -0400", hash_original_method = "F4540EAD4F3CF2106C64C62C1DCA569C", hash_generated_method = "EBC64841F0E978908065887418161F8C")
    private LocationProvider createProvider(String name, Bundle info) {
        LocationProvider varB4EAC82CA7396A68D541C85D26508E83_1041305507 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_1041305507 = provider;
        addTaint(name.getTaint());
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1041305507.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1041305507;
        
        
            
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.809 -0400", hash_original_method = "4EC410201344BFF6367B3FC4DEB2ECDD", hash_generated_method = "C5401BFB6FFF56AE54A93F785528BA34")
    public List<String> getAllProviders() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1658135258 = null; 
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1883443363 = null; 
        {
            Log.d(TAG, "getAllProviders");
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1658135258 = mService.getAllProviders();
        } 
        catch (RemoteException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1883443363 = null;
        List<String> varA7E53CE21691AB073D9660D615818899_321241727; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_321241727 = varB4EAC82CA7396A68D541C85D26508E83_1658135258;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_321241727 = varB4EAC82CA7396A68D541C85D26508E83_1883443363;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_321241727.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_321241727;
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.810 -0400", hash_original_method = "229C505A2DE7B350090013A910A6BB48", hash_generated_method = "DB3CDB5440E01A5B693CC2BCEECBF60B")
    public List<String> getProviders(boolean enabledOnly) {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_479032703 = null; 
        List<String> varB4EAC82CA7396A68D541C85D26508E83_333918716 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_479032703 = mService.getProviders(null, enabledOnly);
        } 
        catch (RemoteException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_333918716 = null;
        addTaint(enabledOnly);
        List<String> varA7E53CE21691AB073D9660D615818899_264983932; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_264983932 = varB4EAC82CA7396A68D541C85D26508E83_479032703;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_264983932 = varB4EAC82CA7396A68D541C85D26508E83_333918716;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_264983932.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_264983932;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.811 -0400", hash_original_method = "14AFABFCECA2A03E46C22CB46D5D2D56", hash_generated_method = "6F4C3845431D84C1FE7E2BC627FA4291")
    public LocationProvider getProvider(String name) {
        LocationProvider varB4EAC82CA7396A68D541C85D26508E83_1425115592 = null; 
        LocationProvider varB4EAC82CA7396A68D541C85D26508E83_562543230 = null; 
        LocationProvider varB4EAC82CA7396A68D541C85D26508E83_1743498038 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name==null");
        } 
        try 
        {
            Bundle info = mService.getProviderInfo(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1425115592 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_562543230 = createProvider(name, info);
        } 
        catch (RemoteException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1743498038 = null;
        addTaint(name.getTaint());
        LocationProvider varA7E53CE21691AB073D9660D615818899_1187125240; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1187125240 = varB4EAC82CA7396A68D541C85D26508E83_1425115592;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1187125240 = varB4EAC82CA7396A68D541C85D26508E83_562543230;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1187125240 = varB4EAC82CA7396A68D541C85D26508E83_1743498038;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1187125240.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1187125240;
        
        
            
        
        
            
            
                
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.812 -0400", hash_original_method = "03CC9524D6FEF78A1BD79E07965ADEF5", hash_generated_method = "A5A76AD26F41F593213E495C5A471467")
    public List<String> getProviders(Criteria criteria, boolean enabledOnly) {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_395413540 = null; 
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1409679352 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_395413540 = mService.getProviders(criteria, enabledOnly);
        } 
        catch (RemoteException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1409679352 = null;
        addTaint(criteria.getTaint());
        addTaint(enabledOnly);
        List<String> varA7E53CE21691AB073D9660D615818899_1368037673; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1368037673 = varB4EAC82CA7396A68D541C85D26508E83_395413540;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1368037673 = varB4EAC82CA7396A68D541C85D26508E83_1409679352;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1368037673.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1368037673;
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.813 -0400", hash_original_method = "E63BBD2716EE0B4343F6D6F30C802349", hash_generated_method = "F62182E5C0D5804615E7AD80EEEAA44A")
    public String getBestProvider(Criteria criteria, boolean enabledOnly) {
        String varB4EAC82CA7396A68D541C85D26508E83_621879854 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1621320830 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_621879854 = mService.getBestProvider(criteria, enabledOnly);
        } 
        catch (RemoteException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1621320830 = null;
        addTaint(criteria.getTaint());
        addTaint(enabledOnly);
        String varA7E53CE21691AB073D9660D615818899_357668427; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_357668427 = varB4EAC82CA7396A68D541C85D26508E83_621879854;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_357668427 = varB4EAC82CA7396A68D541C85D26508E83_1621320830;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_357668427.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_357668427;
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.813 -0400", hash_original_method = "79B0FCFC5B63DF5D944678DA62AFE363", hash_generated_method = "63ED3FB20C4AB203DDD5100353C700CF")
    public void requestLocationUpdates(String provider,
        long minTime, float minDistance, LocationListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } 
        _requestLocationUpdates(provider, null, minTime, minDistance, false, listener, null);
        addTaint(provider.getTaint());
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(listener.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.813 -0400", hash_original_method = "FA80C6D3E17A94A62F4AA64272188CF2", hash_generated_method = "DCF3276B2265C2B778294438751EE42D")
    public void requestLocationUpdates(String provider,
        long minTime, float minDistance, LocationListener listener,
        Looper looper) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } 
        _requestLocationUpdates(provider, null, minTime, minDistance, false, listener, looper);
        addTaint(provider.getTaint());
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.814 -0400", hash_original_method = "2A4D2871A80639591D176F262A5FC273", hash_generated_method = "C329A04AC70B5C97E76A304D4D1CD8E3")
    public void requestLocationUpdates(long minTime, float minDistance,
            Criteria criteria, LocationListener listener, Looper looper) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } 
        _requestLocationUpdates(null, criteria, minTime, minDistance, false, listener, looper);
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(criteria.getTaint());
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.814 -0400", hash_original_method = "7527D3AF7E08617A40988967AFB4FC4D", hash_generated_method = "E228B97BE99896FFA4C4F28490FEC4E0")
    private void _requestLocationUpdates(String provider, Criteria criteria, long minTime,
            float minDistance, boolean singleShot, LocationListener listener, Looper looper) {
        {
            minTime = 0L;
        } 
        {
            minDistance = 0.0f;
        } 
        try 
        {
            {
                ListenerTransport transport = mListeners.get(listener);
                {
                    transport = new ListenerTransport(listener, looper);
                } 
                mListeners.put(listener, transport);
                mService.requestLocationUpdates(provider, criteria, minTime, minDistance, singleShot, transport);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        addTaint(criteria.getTaint());
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(singleShot);
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        
        
            
        
        
            
        
        
            
                
                
                    
                
                
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.815 -0400", hash_original_method = "C7C08F02B5B72D29F482122DD6AFB995", hash_generated_method = "14F9C1F47E9083E3815711169B16E072")
    public void requestLocationUpdates(String provider,
            long minTime, float minDistance, PendingIntent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } 
        _requestLocationUpdates(provider, null, minTime, minDistance, false, intent);
        addTaint(provider.getTaint());
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(intent.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.815 -0400", hash_original_method = "2F287C6E75A45C2A01B3C0BCBDE67B57", hash_generated_method = "4F946C6D20051B69FBD2BF2606C79A0C")
    public void requestLocationUpdates(long minTime, float minDistance, Criteria criteria, PendingIntent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } 
        _requestLocationUpdates(null, criteria, minTime, minDistance, false, intent);
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(criteria.getTaint());
        addTaint(intent.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.816 -0400", hash_original_method = "21FA37E7FC7084DE02389BC0809F92F8", hash_generated_method = "B3E831E4E45EDE98A7E9A16997512DE4")
    private void _requestLocationUpdates(String provider, Criteria criteria,
            long minTime, float minDistance, boolean singleShot, PendingIntent intent) {
        {
            minTime = 0L;
        } 
        {
            minDistance = 0.0f;
        } 
        try 
        {
            mService.requestLocationUpdatesPI(provider, criteria, minTime, minDistance, singleShot, intent);
        } 
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        addTaint(criteria.getTaint());
        addTaint(minTime);
        addTaint(minDistance);
        addTaint(singleShot);
        addTaint(intent.getTaint());
        
        
            
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.816 -0400", hash_original_method = "E82A66C4B675428C8689D564FEFE46C0", hash_generated_method = "F19DE49BF6331EA244F39CFB8D0FBD29")
    public void requestSingleUpdate(String provider, LocationListener listener, Looper looper) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } 
        _requestLocationUpdates(provider, null, 0L, 0.0f, true, listener, looper);
        addTaint(provider.getTaint());
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.816 -0400", hash_original_method = "A942F553EBD5189FF7258B50664EDDE9", hash_generated_method = "99CBC770D3DC9B15D7C94D09BAAA1EEC")
    public void requestSingleUpdate(Criteria criteria, LocationListener listener, Looper looper) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } 
        _requestLocationUpdates(null, criteria, 0L, 0.0f, true, listener, looper);
        addTaint(criteria.getTaint());
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.817 -0400", hash_original_method = "71C843DE562F708F58659EAA42FBA5B9", hash_generated_method = "B4C95378AB61C8A1E8786EBB5FB47C8D")
    public void requestSingleUpdate(String provider, PendingIntent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } 
        _requestLocationUpdates(provider, null, 0L, 0.0f, true, intent);
        addTaint(provider.getTaint());
        addTaint(intent.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.817 -0400", hash_original_method = "6685F769C73037425B092AE6FD387007", hash_generated_method = "D97DC1617FD0F80B27BD32E1DA957BBF")
    public void requestSingleUpdate(Criteria criteria, PendingIntent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("criteria==null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } 
        _requestLocationUpdates(null, criteria, 0L, 0.0f, true, intent);
        addTaint(criteria.getTaint());
        addTaint(intent.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.818 -0400", hash_original_method = "C6393138E31F9EAAF3B1058E5B49E67E", hash_generated_method = "C9DA675DF58E62D39F4F8873325A7DDF")
    public void removeUpdates(LocationListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener==null");
        } 
        {
            Log.d(TAG, "removeUpdates: listener = " + listener);
        } 
        try 
        {
            ListenerTransport transport = mListeners.remove(listener);
            {
                mService.removeUpdates(transport);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(listener.getTaint());
        
        
            
        
        
            
        
        
            
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.818 -0400", hash_original_method = "53855AAE83CDCFDE219D3895B886D007", hash_generated_method = "1B689277393CD63B2DC8D38566A36E8C")
    public void removeUpdates(PendingIntent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("intent==null");
        } 
        {
            Log.d(TAG, "removeUpdates: intent = " + intent);
        } 
        try 
        {
            mService.removeUpdatesPI(intent);
        } 
        catch (RemoteException ex)
        { }
        addTaint(intent.getTaint());
        
        
            
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.818 -0400", hash_original_method = "8F5138780FDD6FE26D92FDF1DF02DE4E", hash_generated_method = "D3FFD24B57C9142639115167B95E924F")
    public void addProximityAlert(double latitude, double longitude,
        float radius, long expiration, PendingIntent intent) {
        {
            Log.d(TAG, "addProximityAlert: latitude = " + latitude +
                ", longitude = " + longitude + ", radius = " + radius +
                ", expiration = " + expiration +
                ", intent = " + intent);
        } 
        try 
        {
            mService.addProximityAlert(latitude, longitude, radius,
                                       expiration, intent);
        } 
        catch (RemoteException ex)
        { }
        addTaint(latitude);
        addTaint(longitude);
        addTaint(radius);
        addTaint(expiration);
        addTaint(intent.getTaint());
        
        
            
                
                
                
        
        
            
                                       
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.819 -0400", hash_original_method = "4A48D6353D1407BC4C3112124D5D3B7A", hash_generated_method = "7EFF49511586B94EE4017C6AD29ABA02")
    public void removeProximityAlert(PendingIntent intent) {
        {
            Log.d(TAG, "removeProximityAlert: intent = " + intent);
        } 
        try 
        {
            mService.removeProximityAlert(intent);
        } 
        catch (RemoteException ex)
        { }
        addTaint(intent.getTaint());
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.820 -0400", hash_original_method = "A73A17F882D5C0CB78BFCF12E6BF5D56", hash_generated_method = "E38A35A0515864778A674C14DE0B589E")
    public boolean isProviderEnabled(String provider) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } 
        try 
        {
            boolean var2CACBF2D859EB1EA82940C38019F9178_855808504 = (mService.isProviderEnabled(provider));
        } 
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1024589343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1024589343;
        
        
            
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.821 -0400", hash_original_method = "C11453A15D8C96574C829BE27A4B0DFD", hash_generated_method = "C640EB666C4CB89BB382B4700E2A8507")
    public Location getLastKnownLocation(String provider) {
        Location varB4EAC82CA7396A68D541C85D26508E83_245039790 = null; 
        Location varB4EAC82CA7396A68D541C85D26508E83_499452235 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("provider==null");
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_245039790 = mService.getLastKnownLocation(provider);
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_499452235 = null;
        } 
        addTaint(provider.getTaint());
        Location varA7E53CE21691AB073D9660D615818899_1766093507; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1766093507 = varB4EAC82CA7396A68D541C85D26508E83_245039790;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1766093507 = varB4EAC82CA7396A68D541C85D26508E83_499452235;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1766093507.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1766093507;
        
        
            
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.822 -0400", hash_original_method = "03E8D8A5CD41A64BA401E8781419DF72", hash_generated_method = "8B8370CE6672C16304653BFEF715F652")
    public void addTestProvider(String name, boolean requiresNetwork, boolean requiresSatellite,
        boolean requiresCell, boolean hasMonetaryCost, boolean supportsAltitude,
        boolean supportsSpeed, boolean supportsBearing, int powerRequirement, int accuracy) {
        try 
        {
            mService.addTestProvider(name, requiresNetwork, requiresSatellite, requiresCell,
                hasMonetaryCost, supportsAltitude, supportsSpeed, supportsBearing, powerRequirement,
                accuracy);
        } 
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
        
        
            
                
                
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.823 -0400", hash_original_method = "498EE4F1DD4EF06996FBFECAF808CC3B", hash_generated_method = "DB7B730DD21D394472A7081A28DF4EEF")
    public void removeTestProvider(String provider) {
        try 
        {
            mService.removeTestProvider(provider);
        } 
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.823 -0400", hash_original_method = "68207A112A1E7BBE4826B19769FC12DA", hash_generated_method = "B5AAAB03A7FF9C820152C53498C9B832")
    public void setTestProviderLocation(String provider, Location loc) {
        try 
        {
            mService.setTestProviderLocation(provider, loc);
        } 
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        addTaint(loc.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.824 -0400", hash_original_method = "7CA7069D9943855589356239516DA9AF", hash_generated_method = "58BDF925E48A33639E0A08B7CD3F334F")
    public void clearTestProviderLocation(String provider) {
        try 
        {
            mService.clearTestProviderLocation(provider);
        } 
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.824 -0400", hash_original_method = "48C675867948B21786DBAE4C1AE4920C", hash_generated_method = "C8D94E85CD6628BD1E4CB12AAC55182A")
    public void setTestProviderEnabled(String provider, boolean enabled) {
        try 
        {
            mService.setTestProviderEnabled(provider, enabled);
        } 
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        addTaint(enabled);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.825 -0400", hash_original_method = "A7FE0DFAA40049E1860E732454FD3827", hash_generated_method = "89EAC726392531DB876F24AF9274B070")
    public void clearTestProviderEnabled(String provider) {
        try 
        {
            mService.clearTestProviderEnabled(provider);
        } 
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.825 -0400", hash_original_method = "03886DE73D19ECB6C62373F8D9D58CA9", hash_generated_method = "9ABC9FF5C7EBE314AACA9E9FD913BB5A")
    public void setTestProviderStatus(String provider, int status, Bundle extras, long updateTime) {
        try 
        {
            mService.setTestProviderStatus(provider, status, extras, updateTime);
        } 
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        addTaint(status);
        addTaint(extras.getTaint());
        addTaint(updateTime);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.825 -0400", hash_original_method = "013DF8509B89AA0EABD8A254078FCC60", hash_generated_method = "4CEB055CE9744AF337A9ACB53070D196")
    public void clearTestProviderStatus(String provider) {
        try 
        {
            mService.clearTestProviderStatus(provider);
        } 
        catch (RemoteException ex)
        { }
        addTaint(provider.getTaint());
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.826 -0400", hash_original_method = "735E28281E7A2112C9B0A11E7D511734", hash_generated_method = "6122409BFF7C6AE4149743427C449BFA")
    public boolean addGpsStatusListener(GpsStatus.Listener listener) {
        boolean result;
        {
            boolean var5F2513550597BAA97D4D74F98C95E02D_1276904718 = (mGpsStatusListeners.get(listener) != null);
        } 
        try 
        {
            GpsStatusListenerTransport transport = new GpsStatusListenerTransport(listener);
            result = mService.addGpsStatusListener(transport);
            {
                mGpsStatusListeners.put(listener, transport);
            } 
        } 
        catch (RemoteException e)
        {
            result = false;
        } 
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517456167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517456167;
        
        
        
            
        
        
            
            
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.826 -0400", hash_original_method = "BE93B3D03F00A664B96E561F38428949", hash_generated_method = "42482E4A5053FD5F30B6680B30DDFADF")
    public void removeGpsStatusListener(GpsStatus.Listener listener) {
        try 
        {
            GpsStatusListenerTransport transport = mGpsStatusListeners.remove(listener);
            {
                mService.removeGpsStatusListener(transport);
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(listener.getTaint());
        
        
            
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.827 -0400", hash_original_method = "69F227E2B854C20A513354DE72686880", hash_generated_method = "DB676A092E6E290DD96199DA34AFF403")
    public boolean addNmeaListener(GpsStatus.NmeaListener listener) {
        boolean result;
        {
            boolean var94A6474BA2F49BF4171CA676610F86BC_796830146 = (mNmeaListeners.get(listener) != null);
        } 
        try 
        {
            GpsStatusListenerTransport transport = new GpsStatusListenerTransport(listener);
            result = mService.addGpsStatusListener(transport);
            {
                mNmeaListeners.put(listener, transport);
            } 
        } 
        catch (RemoteException e)
        {
            result = false;
        } 
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1445569520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1445569520;
        
        
        
            
        
        
            
            
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.827 -0400", hash_original_method = "B4F97B229D6634102324704B9EDD8365", hash_generated_method = "BFD0822774C14B2B7911A9E5492AA2A1")
    public void removeNmeaListener(GpsStatus.NmeaListener listener) {
        try 
        {
            GpsStatusListenerTransport transport = mNmeaListeners.remove(listener);
            {
                mService.removeGpsStatusListener(transport);
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(listener.getTaint());
        
        
            
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.828 -0400", hash_original_method = "58632EF952FC4DB3D625E7340D0B4D49", hash_generated_method = "30F41790199C723E668FD096A30BF45C")
    public GpsStatus getGpsStatus(GpsStatus status) {
        GpsStatus varB4EAC82CA7396A68D541C85D26508E83_1104151849 = null; 
        {
            status = new GpsStatus();
        } 
        status.setStatus(mGpsStatus);
        varB4EAC82CA7396A68D541C85D26508E83_1104151849 = status;
        addTaint(status.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1104151849.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1104151849;
        
        
            
       
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.828 -0400", hash_original_method = "A7B31AF326321489C7AFBE2F446F3E30", hash_generated_method = "8C40072739B4D9F3A05A2C235B6CFC46")
    public boolean sendExtraCommand(String provider, String command, Bundle extras) {
        try 
        {
            boolean var54C526BCA32BFB67E2D9FD83D51E8E2C_1856389128 = (mService.sendExtraCommand(provider, command, extras));
        } 
        catch (RemoteException e)
        { }
        addTaint(provider.getTaint());
        addTaint(command.getTaint());
        addTaint(extras.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457231479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_457231479;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.829 -0400", hash_original_method = "486A02DD90A0BB213EFD64094D84B261", hash_generated_method = "D2F4FB1149BFF52C70C27CBB6FE6E50D")
    public boolean sendNiResponse(int notifId, int userResponse) {
        try 
        {
            boolean var5F2B4C98AB0C6ADE0371DA0514391756_1694921297 = (mService.sendNiResponse(notifId, userResponse));
        } 
        catch (RemoteException e)
        { }
        addTaint(notifId);
        addTaint(userResponse);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962803931 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_962803931;
        
        
            
        
            
            
        
    }

    
    private class ListenerTransport extends ILocationListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.829 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "88C676C20BB164A41FD7C10E7FA78223")

        private LocationListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.829 -0400", hash_original_field = "56BAC178F3086AD35CDD4674A0CF1FF6", hash_generated_field = "4100173B517AAB1135352B9F9C7AE096")

        private Handler mListenerHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.831 -0400", hash_original_method = "5AF1CAA1D5EED50BE6CA5764BFEB7286", hash_generated_method = "1D518A0D9D66ACD0329E1C2B0456DD9A")
          ListenerTransport(LocationListener listener, Looper looper) {
            mListener = listener;
            {
                mListenerHandler = new Handler() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.830 -0400", hash_original_method = "2788B827BF69A5605D676A806900279A", hash_generated_method = "F91A923F1693A66EB7CBCB63C96E490F")
                    @Override
                    public void handleMessage(Message msg) {
                        _handleMessage(msg);
                        addTaint(msg.getTaint());
                        
                        
                    }
};
            } 
            {
                mListenerHandler = new Handler(looper) {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.830 -0400", hash_original_method = "2788B827BF69A5605D676A806900279A", hash_generated_method = "F91A923F1693A66EB7CBCB63C96E490F")
                    @Override
                    public void handleMessage(Message msg) {
                        _handleMessage(msg);
                        addTaint(msg.getTaint());
                        
                        
                    }
};
            } 
            
            
            
                
                    
                    
                        
                    
                
            
                
                    
                    
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.831 -0400", hash_original_method = "A17E439126795FFA0E8C33868ED647C4", hash_generated_method = "10B6C7117611F23D7DCE7E7E7D231CFB")
        public void onLocationChanged(Location location) {
            
            Message msg = Message.obtain();
            msg.what = TYPE_LOCATION_CHANGED;
            msg.obj = location;
            mListenerHandler.sendMessage(msg);
            addTaint(location.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.833 -0400", hash_original_method = "BF8F7C90ADE4983F5319C798EB4A7E9F", hash_generated_method = "073AA05D8F50360DE3E948E78E8E11E2")
        public void onStatusChanged(String provider, int status, Bundle extras) {
            
            Message msg = Message.obtain();
            msg.what = TYPE_STATUS_CHANGED;
            Bundle b = new Bundle();
            b.putString("provider", provider);
            b.putInt("status", status);
            {
                b.putBundle("extras", extras);
            } 
            msg.obj = b;
            mListenerHandler.sendMessage(msg);
            addTaint(provider.getTaint());
            addTaint(status);
            addTaint(extras.getTaint());
            
            
            
            
            
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.833 -0400", hash_original_method = "812D643BCDC2A4502FF3E1F391BA3BAF", hash_generated_method = "C6C144210386CD6965C55E9F4DEFD6B7")
        public void onProviderEnabled(String provider) {
            
            Message msg = Message.obtain();
            msg.what = TYPE_PROVIDER_ENABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
            addTaint(provider.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.834 -0400", hash_original_method = "E15FA24A6514F29CC56145BCCEFEF320", hash_generated_method = "DD103E51EFB2D47AF6CB5A704964A204")
        public void onProviderDisabled(String provider) {
            
            Message msg = Message.obtain();
            msg.what = TYPE_PROVIDER_DISABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
            addTaint(provider.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.834 -0400", hash_original_method = "B4AFFA03A7F956D43DB0E44DEB20B60F", hash_generated_method = "174654A49E5101F6F6165E5A7755902C")
        private void _handleMessage(Message msg) {
            
            Location location = new Location((Location) msg.obj);
            
            
            mListener.onLocationChanged(location);
            
            
            Bundle b = (Bundle) msg.obj;
            
            
            String provider = b.getString("provider");
            
            
            int status = b.getInt("status");
            
            
            Bundle extras = b.getBundle("extras");
            
            
            mListener.onStatusChanged(provider, status, extras);
            
            
            mListener.onProviderEnabled((String) msg.obj);
            
            
            mListener.onProviderDisabled((String) msg.obj);
            
            try 
            {
                mService.locationCallbackFinished(this);
            } 
            catch (RemoteException e)
            { }
            addTaint(msg.getTaint());
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.941 -0400", hash_original_field = "8C0B89388C7AF37135B00419CA7E9C92", hash_generated_field = "4F6331E1C38728042E99BC19ED065FE7")

        private static final int TYPE_LOCATION_CHANGED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.941 -0400", hash_original_field = "45E66B86E7431FAC1292C89E91493801", hash_generated_field = "0E0EB8CF48239791BC17B65E42FD0D5E")

        private static final int TYPE_STATUS_CHANGED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.955 -0400", hash_original_field = "4D8B289A7864C6EE1ACDD3C1B058CE4F", hash_generated_field = "1DEB2ED8E0755ECCDC1E6866C8E41AA3")

        private static final int TYPE_PROVIDER_ENABLED = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.955 -0400", hash_original_field = "DD4E410FD111EAFC75B3615EB43DD4E3", hash_generated_field = "AAA8F4CC1C231AA942B04F54800111F8")

        private static final int TYPE_PROVIDER_DISABLED = 4;
    }


    
    private class GpsStatusListenerTransport extends IGpsStatusListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.834 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "3564D5BECCC467DBB563E9174E6839FA")

        private GpsStatus.Listener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.834 -0400", hash_original_field = "6A914A5E364626F0BE69C7CA16741AC2", hash_generated_field = "C56AA1FA4293F00EF5AC3280F7CE1BCE")

        private GpsStatus.NmeaListener mNmeaListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.834 -0400", hash_original_field = "C91213C9D8B8761834B23071597A3455", hash_generated_field = "BDE0A966016D1F7F3E0759437CA71854")

        private ArrayList<Nmea> mNmeaBuffer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.835 -0400", hash_original_field = "1388D92E53A0B03AA5E995A7DC696BD0", hash_generated_field = "F55E5094A9DE85B4B224D9C2B4E5F989")

        private final Handler mGpsHandler = new Handler() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.835 -0400", hash_original_method = "3A4C26C18C998E8AD28D793D2B4D73AC", hash_generated_method = "B0F8CA736BF9D9112DC736C5C2554810")
            @Override
            public void handleMessage(Message msg) {
                {
                    {
                        int length = mNmeaBuffer.size();
                        {
                            int i = 0;
                            {
                                Nmea nmea = mNmeaBuffer.get(i);
                                mNmeaListener.onNmeaReceived(nmea.mTimestamp, nmea.mNmea);
                            } 
                        } 
                        mNmeaBuffer.clear();
                    } 
                } 
                {
                    {
                        mListener.onGpsStatusChanged(msg.what);
                    } 
                } 
                addTaint(msg.getTaint());
                
                
                    
                        
                        
                            
                            
                        
                        
                    
                
                    
                        
                    
                
            }

            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.835 -0400", hash_original_method = "F4C48E1C52D52EE2A00BB4471F3F104F", hash_generated_method = "5BD8573A0E58EE341269EDADEAA6CD32")
          GpsStatusListenerTransport(GpsStatus.Listener listener) {
            mListener = listener;
            mNmeaListener = null;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.836 -0400", hash_original_method = "2F84EC7497CDA44BC0A09FBB4C2AE91B", hash_generated_method = "A64C791C45CA47B3BFECF96C00EDA552")
          GpsStatusListenerTransport(GpsStatus.NmeaListener listener) {
            mNmeaListener = listener;
            mListener = null;
            mNmeaBuffer = new ArrayList<Nmea>();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.836 -0400", hash_original_method = "03DD372B4F74F556A5CFC2950F002742", hash_generated_method = "731D150F922A7BEDBFD1894AA6280D9A")
        public void onGpsStarted() {
            
            {
                Message msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_STARTED;
                mGpsHandler.sendMessage(msg);
            } 
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.837 -0400", hash_original_method = "30C4A680AA9F7AF81E647400DEBA508E", hash_generated_method = "49A31FE2574B1950E3B981BA07CBE119")
        public void onGpsStopped() {
            
            {
                Message msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_STOPPED;
                mGpsHandler.sendMessage(msg);
            } 
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.837 -0400", hash_original_method = "E5DFF9ED39044E57371BE0E746E84457", hash_generated_method = "AC4530AE5CD7D443C19B24F15BD473C1")
        public void onFirstFix(int ttff) {
            
            {
                mGpsStatus.setTimeToFirstFix(ttff);
                Message msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_FIRST_FIX;
                mGpsHandler.sendMessage(msg);
            } 
            addTaint(ttff);
            
            
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.837 -0400", hash_original_method = "6F6B969ADA567E96DFAB5A585780E70F", hash_generated_method = "DE01092A72831895849BAEE55E3D7D4E")
        public void onSvStatusChanged(int svCount, int[] prns, float[] snrs,
                float[] elevations, float[] azimuths, int ephemerisMask,
                int almanacMask, int usedInFixMask) {
            
            {
                mGpsStatus.setStatus(svCount, prns, snrs, elevations, azimuths,
                        ephemerisMask, almanacMask, usedInFixMask);
                Message msg = Message.obtain();
                msg.what = GpsStatus.GPS_EVENT_SATELLITE_STATUS;
                mGpsHandler.removeMessages(GpsStatus.GPS_EVENT_SATELLITE_STATUS);
                mGpsHandler.sendMessage(msg);
            } 
            addTaint(svCount);
            addTaint(prns[0]);
            addTaint(snrs[0]);
            addTaint(elevations[0]);
            addTaint(azimuths[0]);
            addTaint(ephemerisMask);
            addTaint(almanacMask);
            addTaint(usedInFixMask);
            
            
                
                        
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.838 -0400", hash_original_method = "D97F778C22B6B561834B5A8A67FE2F57", hash_generated_method = "602A567CA8A55204BEAAB0D8BD2D6E0F")
        public void onNmeaReceived(long timestamp, String nmea) {
            
            {
                {
                    mNmeaBuffer.add(new Nmea(timestamp, nmea));
                } 
                Message msg = Message.obtain();
                msg.what = NMEA_RECEIVED;
                mGpsHandler.removeMessages(NMEA_RECEIVED);
                mGpsHandler.sendMessage(msg);
            } 
            addTaint(timestamp);
            addTaint(nmea.getTaint());
            
            
                
                    
                
                
                
                
                
            
        }

        
        private class Nmea {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.838 -0400", hash_original_field = "D0D8C7FFAD5AE68F861E40D637EC0463", hash_generated_field = "1D358F2CB412AAF1346451355CB8F3E3")

            long mTimestamp;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.838 -0400", hash_original_field = "5C868597A7B87315895D9C109908E910", hash_generated_field = "24AFD15E5AD8DD2E9530B1A85650CD93")

            String mNmea;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.838 -0400", hash_original_method = "7FAFEC38F5688F1D1ACFE15C845DEFCA", hash_generated_method = "2C01B97CF53E8C2E9DE64A323D518081")
              Nmea(long timestamp, String nmea) {
                mTimestamp = timestamp;
                mNmea = nmea;
                
                
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.003 -0400", hash_original_field = "D84CD7AC433F52E58A4CCA5B3DB61EAD", hash_generated_field = "42BA11FDC6A92AFB50048B81B8856AC7")

        private static final int NMEA_RECEIVED = 1000;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.838 -0400", hash_original_field = "3DCB34AD9AF783DB01BF473D53795CF0", hash_generated_field = "28DF91E101BF22ECD70A2547DFBB55A7")

    private static final String TAG = "LocationManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.838 -0400", hash_original_field = "6EB3A04D83D3EB53836000A2B31706D3", hash_generated_field = "6A1159950B5F0D81FE05A0592F2DB1B2")

    public static final String NETWORK_PROVIDER = "network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.838 -0400", hash_original_field = "5511BBE363BBFBEF2A13CD3903A63DBA", hash_generated_field = "4C2280586138D33EB30E26156BDCB654")

    public static final String GPS_PROVIDER = "gps";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.838 -0400", hash_original_field = "1A76AC2B2F74ECACC05EB5A2C9A17D65", hash_generated_field = "F221EEFFFB6FF66793F94043F74CBC0B")

    public static final String PASSIVE_PROVIDER = "passive";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.838 -0400", hash_original_field = "1219C70453A4B51E7467604E9D21E2F1", hash_generated_field = "F9B4EC13158580C5DB06971A10A5663C")

    public static final String KEY_PROXIMITY_ENTERING = "entering";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.839 -0400", hash_original_field = "8BBFDB3591EF0B7BAF1E2C35BEE723C2", hash_generated_field = "F215A34B782985F96320EA9F9AC24ECE")

    public static final String KEY_STATUS_CHANGED = "status";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.839 -0400", hash_original_field = "EFC775B399B41180A7DFD2652A75BD6F", hash_generated_field = "E53B94E70159BE067785CDCFE51933F1")

    public static final String KEY_PROVIDER_ENABLED = "providerEnabled";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.839 -0400", hash_original_field = "BBB9637E7AD41C030E894E86C191AECF", hash_generated_field = "B9A8BCBF7A8975A62A8159DDE6821E45")

    public static final String KEY_LOCATION_CHANGED = "location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.839 -0400", hash_original_field = "400BD7DF293767AC387D02375DE71183", hash_generated_field = "4011D28AFA5049A3F8B84DAE600CE7B1")

    public static final String GPS_ENABLED_CHANGE_ACTION =
        "android.location.GPS_ENABLED_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.839 -0400", hash_original_field = "116A7AA128E8BD79F2FF79BDFA6FC928", hash_generated_field = "F1DA53484EFF7310FA2C5CCD96A5903D")

    public static final String PROVIDERS_CHANGED_ACTION =
        "android.location.PROVIDERS_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.839 -0400", hash_original_field = "DDA3CF7A2BE453FBAF12CC5166836588", hash_generated_field = "0ED670DE81E8FA835AC8A157321FBD93")

    public static final String GPS_FIX_CHANGE_ACTION =
        "android.location.GPS_FIX_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.839 -0400", hash_original_field = "494BD1FE78539565E73D758923F5ABF3", hash_generated_field = "AAD29DA0DDBC5FD40952BC68A7746945")

    public static final String EXTRA_GPS_ENABLED = "enabled";
}

