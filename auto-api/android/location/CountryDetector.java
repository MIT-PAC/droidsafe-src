package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.HashMap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

public class CountryDetector {
    private final static String TAG = "CountryDetector";
    private final ICountryDetector mService;
    private final HashMap<CountryListener, ListenerTransport> mListeners;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.616 -0400", hash_original_method = "1A7B373E04EF53B30E08B7B8CC03780E", hash_generated_method = "02E93996FC8B35D4A37EE79AA1CED2E2")
    @DSModeled(DSC.SAFE)
    public CountryDetector(ICountryDetector service) {
        dsTaint.addTaint(service.dsTaint);
        mListeners = new HashMap<CountryListener, ListenerTransport>();
        mService = service;
        // ---------- Original Method ----------
        //mService = service;
        //mListeners = new HashMap<CountryListener, ListenerTransport>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.616 -0400", hash_original_method = "8394DE101C334DCA17E1726BC4AA658C", hash_generated_method = "09CD2B49A0DAE3235E59DA30DAFEA301")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Country detectCountry() {
        try 
        {
            Country var04B0366D9354921931B706B84452557D_420822764 = (mService.detectCountry());
        } //End block
        catch (RemoteException e)
        { }
        return (Country)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.detectCountry();
        //} catch (RemoteException e) {
            //Log.e(TAG, "detectCountry: RemoteException", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.616 -0400", hash_original_method = "BC3AED2375940B210F4240F1B5BF489C", hash_generated_method = "60009062D9A37F14B227A271CB4BAC92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addCountryListener(CountryListener listener, Looper looper) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                boolean var3A0ACFAC25F57F83126FEF2364554697_1663807780 = (!mListeners.containsKey(listener));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.616 -0400", hash_original_method = "956D6A58CF004E8191495221FE8E06DD", hash_generated_method = "4B276C3E8EB7D6A7351C77C13A626E3D")
    @DSModeled(DSC.SAFE)
    public void removeCountryListener(CountryListener listener) {
        dsTaint.addTaint(listener.dsTaint);
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
        private final CountryListener mListener;
        private final Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.617 -0400", hash_original_method = "B76186AFC83B6C77A78C283544EECE09", hash_generated_method = "8746C51AD2851850296044A92FC8C21A")
        @DSModeled(DSC.SAFE)
        public ListenerTransport(CountryListener listener, Looper looper) {
            dsTaint.addTaint(looper.dsTaint);
            dsTaint.addTaint(listener.dsTaint);
            {
                mHandler = new Handler(looper);
            } //End block
            mListener = listener;
            // ---------- Original Method ----------
            //mListener = listener;
            //if (looper != null) {
                //mHandler = new Handler(looper);
            //} else {
                //mHandler = new Handler();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.617 -0400", hash_original_method = "F95DEB9AF970A5D9353FC83CA6F7013A", hash_generated_method = "CB86DF072D8B14AC88CF324D38149FF3")
        @DSModeled(DSC.SAFE)
        public void onCountryDetected(final Country country) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(country.dsTaint);
            mHandler.post(new Runnable() {
                public void run() {
                    mListener.onCountryDetected(country);
                }
            });
            // ---------- Original Method ----------
            //mHandler.post(new Runnable() {
                //public void run() {
                    //mListener.onCountryDetected(country);
                //}
            //});
        }

        
    }


    
}


