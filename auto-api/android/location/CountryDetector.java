package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

public class CountryDetector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.905 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "586490950C196F388A8EA4D62FE86E5C")

    private ICountryDetector mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.905 -0400", hash_original_field = "2F2828353527044AFD6820F84A8A1FAB", hash_generated_field = "65263F123FD412210E5CA4FCF1CC12CD")

    private HashMap<CountryListener, ListenerTransport> mListeners;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.906 -0400", hash_original_method = "1A7B373E04EF53B30E08B7B8CC03780E", hash_generated_method = "D989B224CC275E8895828F0A793F6A43")
    public  CountryDetector(ICountryDetector service) {
        mService = service;
        mListeners = new HashMap<CountryListener, ListenerTransport>();
        // ---------- Original Method ----------
        //mService = service;
        //mListeners = new HashMap<CountryListener, ListenerTransport>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.907 -0400", hash_original_method = "8394DE101C334DCA17E1726BC4AA658C", hash_generated_method = "D367DC568368A9520956A0925CC25846")
    public Country detectCountry() {
        Country varB4EAC82CA7396A68D541C85D26508E83_2141054746 = null; //Variable for return #1
        Country varB4EAC82CA7396A68D541C85D26508E83_272780287 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2141054746 = mService.detectCountry();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_272780287 = null;
        } //End block
        Country varA7E53CE21691AB073D9660D615818899_697876247; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_697876247 = varB4EAC82CA7396A68D541C85D26508E83_2141054746;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_697876247 = varB4EAC82CA7396A68D541C85D26508E83_272780287;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_697876247.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_697876247;
        // ---------- Original Method ----------
        //try {
            //return mService.detectCountry();
        //} catch (RemoteException e) {
            //Log.e(TAG, "detectCountry: RemoteException", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.911 -0400", hash_original_method = "BC3AED2375940B210F4240F1B5BF489C", hash_generated_method = "F7972527D20278201E8E698257645509")
    public void addCountryListener(CountryListener listener, Looper looper) {
        {
            {
                boolean var3A0ACFAC25F57F83126FEF2364554697_125224589 = (!mListeners.containsKey(listener));
                {
                    ListenerTransport transport;
                    transport = new ListenerTransport(listener, looper);
                    try 
                    {
                        mService.addCountryListener(transport);
                        mListeners.put(listener, transport);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(listener.getTaint());
        addTaint(looper.getTaint());
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //if (!mListeners.containsKey(listener)) {
                //ListenerTransport transport = new ListenerTransport(listener, looper);
                //try {
                    //mService.addCountryListener(transport);
                    //mListeners.put(listener, transport);
                //} catch (RemoteException e) {
                    //Log.e(TAG, "addCountryListener: RemoteException", e);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.918 -0400", hash_original_method = "956D6A58CF004E8191495221FE8E06DD", hash_generated_method = "9F2880CB367CCA23F4D71BBF134155C8")
    public void removeCountryListener(CountryListener listener) {
        {
            ListenerTransport transport;
            transport = mListeners.get(listener);
            {
                try 
                {
                    mListeners.remove(listener);
                    mService.removeCountryListener(transport);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //synchronized (mListeners) {
            //ListenerTransport transport = mListeners.get(listener);
            //if (transport != null) {
                //try {
                    //mListeners.remove(listener);
                    //mService.removeCountryListener(transport);
                //} catch (RemoteException e) {
                    //Log.e(TAG, "removeCountryListener: RemoteException", e);
                //}
            //}
        //}
    }

    
    private final static class ListenerTransport extends ICountryListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.918 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "C83CBAAD111326C8688E466E2DD9969D")

        private CountryListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.918 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.919 -0400", hash_original_method = "B76186AFC83B6C77A78C283544EECE09", hash_generated_method = "B194B4D0779AF318FDA32BCB6517C613")
        public  ListenerTransport(CountryListener listener, Looper looper) {
            mListener = listener;
            {
                mHandler = new Handler(looper);
            } //End block
            {
                mHandler = new Handler();
            } //End block
            // ---------- Original Method ----------
            //mListener = listener;
            //if (looper != null) {
                //mHandler = new Handler(looper);
            //} else {
                //mHandler = new Handler();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.014 -0400", hash_original_method = "F95DEB9AF970A5D9353FC83CA6F7013A", hash_generated_method = "487A55F8852DC7CCCE67C68503F6E0A4")
        public void onCountryDetected(final Country country) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mHandler.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.014 -0400", hash_original_method = "80BD55FB6767C94F80935DEF8974CD11", hash_generated_method = "0AA61EE6BBE285205045685EB9F88C6A")
                public void run() {
                    mListener.onCountryDetected(country);
                    // ---------- Original Method ----------
                    //mListener.onCountryDetected(country);
                }
});
            addTaint(country.getTaint());
            // ---------- Original Method ----------
            //mHandler.post(new Runnable() {
                //public void run() {
                    //mListener.onCountryDetected(country);
                //}
            //});
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.015 -0400", hash_original_field = "6FDAD09C5B83FE076E966D1B24E66234", hash_generated_field = "763929DD89C9C8642C366B486EDC7661")

    private static String TAG = "CountryDetector";
}

