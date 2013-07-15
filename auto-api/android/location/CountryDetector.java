package android.location;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.HashMap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

public class CountryDetector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.141 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "586490950C196F388A8EA4D62FE86E5C")

    private ICountryDetector mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.141 -0400", hash_original_field = "2F2828353527044AFD6820F84A8A1FAB", hash_generated_field = "65263F123FD412210E5CA4FCF1CC12CD")

    private HashMap<CountryListener, ListenerTransport> mListeners;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.141 -0400", hash_original_method = "1A7B373E04EF53B30E08B7B8CC03780E", hash_generated_method = "D989B224CC275E8895828F0A793F6A43")
    public  CountryDetector(ICountryDetector service) {
        mService = service;
        mListeners = new HashMap<CountryListener, ListenerTransport>();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.142 -0400", hash_original_method = "8394DE101C334DCA17E1726BC4AA658C", hash_generated_method = "DD68B83355600A09ECFC0462B847B2CC")
    public Country detectCountry() {
        Country varB4EAC82CA7396A68D541C85D26508E83_1588117364 = null; 
        Country varB4EAC82CA7396A68D541C85D26508E83_1717035490 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1588117364 = mService.detectCountry();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1717035490 = null;
        } 
        Country varA7E53CE21691AB073D9660D615818899_1266217035; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1266217035 = varB4EAC82CA7396A68D541C85D26508E83_1588117364;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1266217035 = varB4EAC82CA7396A68D541C85D26508E83_1717035490;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1266217035.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1266217035;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.143 -0400", hash_original_method = "BC3AED2375940B210F4240F1B5BF489C", hash_generated_method = "BBF3B87E4686F7A6E75A3701462E9147")
    public void addCountryListener(CountryListener listener, Looper looper) {
        {
            {
                boolean var3A0ACFAC25F57F83126FEF2364554697_359557737 = (!mListeners.containsKey(listener));
                {
                    ListenerTransport transport = new ListenerTransport(listener, looper);
                    try 
                    {
                        mService.addCountryListener(transport);
                        mListeners.put(listener, transport);
                    } 
                    catch (RemoteException e)
                    { }
                } 
            } 
        } 
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        
        
            
                
                
                    
                    
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.144 -0400", hash_original_method = "956D6A58CF004E8191495221FE8E06DD", hash_generated_method = "1CF73A47AF48EEDA20939AE1910FD700")
    public void removeCountryListener(CountryListener listener) {
        {
            ListenerTransport transport = mListeners.get(listener);
            {
                try 
                {
                    mListeners.remove(listener);
                    mService.removeCountryListener(transport);
                } 
                catch (RemoteException e)
                { }
            } 
        } 
        addTaint(listener.getTaint());
        
        
            
            
                
                    
                    
                
                    
                
            
        
    }

    
    private final static class ListenerTransport extends ICountryListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.144 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "C83CBAAD111326C8688E466E2DD9969D")

        private CountryListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.144 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.144 -0400", hash_original_method = "B76186AFC83B6C77A78C283544EECE09", hash_generated_method = "B194B4D0779AF318FDA32BCB6517C613")
        public  ListenerTransport(CountryListener listener, Looper looper) {
            mListener = listener;
            {
                mHandler = new Handler(looper);
            } 
            {
                mHandler = new Handler();
            } 
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.145 -0400", hash_original_method = "F95DEB9AF970A5D9353FC83CA6F7013A", hash_generated_method = "01700522904EB1772145B96755B0D1DA")
        public void onCountryDetected(final Country country) {
            
            mHandler.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.145 -0400", hash_original_method = "80BD55FB6767C94F80935DEF8974CD11", hash_generated_method = "0AA61EE6BBE285205045685EB9F88C6A")
                public void run() {
                    mListener.onCountryDetected(country);
                    
                    
                }
});
            addTaint(country.getTaint());
            
            
                
                    
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.145 -0400", hash_original_field = "6FDAD09C5B83FE076E966D1B24E66234", hash_generated_field = "FDDD7BCA9CDA28F5A3E99818FA3CA6DE")

    private final static String TAG = "CountryDetector";
}

