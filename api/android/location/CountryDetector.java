package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.HashMap;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;



public class CountryDetector {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.565 -0500", hash_original_field = "584F7D5060DB0ED0AEB7611B35D98E42", hash_generated_field = "FDDD7BCA9CDA28F5A3E99818FA3CA6DE")


    private final static String TAG = "CountryDetector";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.567 -0500", hash_original_field = "F4C0A0502A557D3E35711C29B17B7850", hash_generated_field = "586490950C196F388A8EA4D62FE86E5C")

    private  ICountryDetector mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.569 -0500", hash_original_field = "5BB883463A8D0A20D1A0593DE688A241", hash_generated_field = "65263F123FD412210E5CA4FCF1CC12CD")

    private  HashMap<CountryListener, ListenerTransport> mListeners;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.931 -0400", hash_original_method = "1A7B373E04EF53B30E08B7B8CC03780E", hash_generated_method = "D989B224CC275E8895828F0A793F6A43")
    public  CountryDetector(ICountryDetector service) {
        mService = service;
        mListeners = new HashMap<CountryListener, ListenerTransport>();
        addTaint(service.getTaint());
        // ---------- Original Method ----------
        //mService = service;
        //mListeners = new HashMap<CountryListener, ListenerTransport>();
    }
    
    //inject by hand modeling
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.931 -0400", hash_original_method = "1A7B373E04EF53B30E08B7B8CC03780E", hash_generated_method = "D989B224CC275E8895828F0A793F6A43")
    public  CountryDetector() {
        mListeners = new HashMap<CountryListener, ListenerTransport>();
        // ---------- Original Method ----------
        //mService = service;
        //mListeners = new HashMap<CountryListener, ListenerTransport>();
    }

    /**
     * Start detecting the country that the user is in.
     *
     * @return the country if it is available immediately, otherwise null will
     *         be returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.574 -0500", hash_original_method = "8394DE101C334DCA17E1726BC4AA658C", hash_generated_method = "1FDE26FDB473027380720CF1D7F05DF6")
    
public Country detectCountry() {
        try {
            return mService.detectCountry();
        } catch (RemoteException e) {
            Log.e(TAG, "detectCountry: RemoteException", e);
            return null;
        }
    }

    /**
     * Add a listener to receive the notification when the country is detected
     * or changed.
     *
     * @param listener will be called when the country is detected or changed.
     * @param looper a Looper object whose message queue will be used to
     *        implement the callback mechanism. If looper is null then the
     *        callbacks will be called on the main thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.577 -0500", hash_original_method = "BC3AED2375940B210F4240F1B5BF489C", hash_generated_method = "D22B3A115D5722AD9AEFD41FD8159508")
    
public void addCountryListener(CountryListener listener, Looper looper) {
        synchronized (mListeners) {
            if (!mListeners.containsKey(listener)) {
                ListenerTransport transport = new ListenerTransport(listener, looper);
                try {
                    mService.addCountryListener(transport);
                    mListeners.put(listener, transport);
                } catch (RemoteException e) {
                    Log.e(TAG, "addCountryListener: RemoteException", e);
                }
            }
        }
    }

    
    private final static class ListenerTransport extends ICountryListener.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.549 -0500", hash_original_field = "4377D948CF35F8478267CA973E916FF1", hash_generated_field = "C83CBAAD111326C8688E466E2DD9969D")


        private  CountryListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.552 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")


        private  Handler mHandler;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.555 -0500", hash_original_method = "B76186AFC83B6C77A78C283544EECE09", hash_generated_method = "E6C3BA6EB82C9D1E8A30C52FF2883174")
        
public ListenerTransport(CountryListener listener, Looper looper) {
            mListener = listener;
            if (looper != null) {
                mHandler = new Handler(looper);
            } else {
                mHandler = new Handler();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.560 -0500", hash_original_method = "F95DEB9AF970A5D9353FC83CA6F7013A", hash_generated_method = "0397EAC55ACDBCAE5F4C6309E9FD005F")
        
public void onCountryDetected(final Country country) {
            mHandler.post(new Runnable() {
                public void run() {
                    mListener.onCountryDetected(country);
                }
            });
        }

        
    }

    /**
     * Remove the listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.579 -0500", hash_original_method = "956D6A58CF004E8191495221FE8E06DD", hash_generated_method = "E88811BBBA48BA05CC3C91222C4A42AB")
    
public void removeCountryListener(CountryListener listener) {
        synchronized (mListeners) {
            ListenerTransport transport = mListeners.get(listener);
            if (transport != null) {
                try {
                    mListeners.remove(listener);
                    mService.removeCountryListener(transport);
                } catch (RemoteException e) {
                    Log.e(TAG, "removeCountryListener: RemoteException", e);
                }
            }
        }
    }
}

