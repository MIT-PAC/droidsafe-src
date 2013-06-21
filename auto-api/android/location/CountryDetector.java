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
    private ICountryDetector mService;
    private HashMap<CountryListener, ListenerTransport> mListeners;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.529 -0400", hash_original_method = "1A7B373E04EF53B30E08B7B8CC03780E", hash_generated_method = "FFC106A43E0C347FC6D78D8EBC9C162F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CountryDetector(ICountryDetector service) {
        dsTaint.addTaint(service.dsTaint);
        mListeners = new HashMap<CountryListener, ListenerTransport>();
        // ---------- Original Method ----------
        //mService = service;
        //mListeners = new HashMap<CountryListener, ListenerTransport>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.530 -0400", hash_original_method = "8394DE101C334DCA17E1726BC4AA658C", hash_generated_method = "C85D47F932C41F929D286E4FF7A57932")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Country detectCountry() {
        try 
        {
            Country var04B0366D9354921931B706B84452557D_12122230 = (mService.detectCountry());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.532 -0400", hash_original_method = "BC3AED2375940B210F4240F1B5BF489C", hash_generated_method = "C26C17B8C5D7C01B1261B30CB76F12FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addCountryListener(CountryListener listener, Looper looper) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        {
            {
                boolean var3A0ACFAC25F57F83126FEF2364554697_864268548 = (!mListeners.containsKey(listener));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.532 -0400", hash_original_method = "956D6A58CF004E8191495221FE8E06DD", hash_generated_method = "B2D706C5D488830DD525B7C4321BF6C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private CountryListener mListener;
        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.533 -0400", hash_original_method = "B76186AFC83B6C77A78C283544EECE09", hash_generated_method = "EF740079D885ED854FAC83DBCA7A17D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ListenerTransport(CountryListener listener, Looper looper) {
            dsTaint.addTaint(looper.dsTaint);
            dsTaint.addTaint(listener.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.533 -0400", hash_original_method = "F95DEB9AF970A5D9353FC83CA6F7013A", hash_generated_method = "50463DCD1E6500B3CE2E9F5C2473EA94")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onCountryDetected(final Country country) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(country.dsTaint);
            mHandler.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.533 -0400", hash_original_method = "80BD55FB6767C94F80935DEF8974CD11", hash_generated_method = "0AA61EE6BBE285205045685EB9F88C6A")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    mListener.onCountryDetected(country);
                    // ---------- Original Method ----------
                    //mListener.onCountryDetected(country);
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


    
    private final static String TAG = "CountryDetector";
}

