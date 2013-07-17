package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

public class CountryDetector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.930 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "586490950C196F388A8EA4D62FE86E5C")

    private ICountryDetector mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.930 -0400", hash_original_field = "2F2828353527044AFD6820F84A8A1FAB", hash_generated_field = "65263F123FD412210E5CA4FCF1CC12CD")

    private HashMap<CountryListener, ListenerTransport> mListeners;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.931 -0400", hash_original_method = "1A7B373E04EF53B30E08B7B8CC03780E", hash_generated_method = "D989B224CC275E8895828F0A793F6A43")
    public  CountryDetector(ICountryDetector service) {
        mService = service;
        mListeners = new HashMap<CountryListener, ListenerTransport>();
        // ---------- Original Method ----------
        //mService = service;
        //mListeners = new HashMap<CountryListener, ListenerTransport>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.931 -0400", hash_original_method = "8394DE101C334DCA17E1726BC4AA658C", hash_generated_method = "F9759DDC29A257DD54750E89238CF667")
    public Country detectCountry() {
        try 
        {
Country varD673DCCCB3DEFF407B3D1CE2BFD6E6FD_1149556871 =             mService.detectCountry();
            varD673DCCCB3DEFF407B3D1CE2BFD6E6FD_1149556871.addTaint(taint);
            return varD673DCCCB3DEFF407B3D1CE2BFD6E6FD_1149556871;
        } //End block
        catch (RemoteException e)
        {
Country var540C13E9E156B687226421B24F2DF178_1357408776 =             null;
            var540C13E9E156B687226421B24F2DF178_1357408776.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1357408776;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.detectCountry();
        //} catch (RemoteException e) {
            //Log.e(TAG, "detectCountry: RemoteException", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.932 -0400", hash_original_method = "BC3AED2375940B210F4240F1B5BF489C", hash_generated_method = "EB2C37E8DA52A78DBC61A09D959779C9")
    public void addCountryListener(CountryListener listener, Looper looper) {
        addTaint(looper.getTaint());
        addTaint(listener.getTaint());
        synchronized
(mListeners)        {
            if(!mListeners.containsKey(listener))            
            {
                ListenerTransport transport = new ListenerTransport(listener, looper);
                try 
                {
                    mService.addCountryListener(transport);
                    mListeners.put(listener, transport);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.933 -0400", hash_original_method = "956D6A58CF004E8191495221FE8E06DD", hash_generated_method = "E6087B886F6F040EBA7A2A6E97E5B538")
    public void removeCountryListener(CountryListener listener) {
        addTaint(listener.getTaint());
        synchronized
(mListeners)        {
            ListenerTransport transport = mListeners.get(listener);
            if(transport != null)            
            {
                try 
                {
                    mListeners.remove(listener);
                    mService.removeCountryListener(transport);
                } //End block
                catch (RemoteException e)
                {
                } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.934 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "C83CBAAD111326C8688E466E2DD9969D")

        private CountryListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.934 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.936 -0400", hash_original_method = "B76186AFC83B6C77A78C283544EECE09", hash_generated_method = "4159405EEFEEC31A8DF84904495E69EA")
        public  ListenerTransport(CountryListener listener, Looper looper) {
            mListener = listener;
            if(looper != null)            
            {
                mHandler = new Handler(looper);
            } //End block
            else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.937 -0400", hash_original_method = "F95DEB9AF970A5D9353FC83CA6F7013A", hash_generated_method = "6E25ECA6DE0FEF76506A107D81C59D91")
        public void onCountryDetected(final Country country) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(country.getTaint());
            mHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.937 -0400", hash_original_method = "80BD55FB6767C94F80935DEF8974CD11", hash_generated_method = "0AA61EE6BBE285205045685EB9F88C6A")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.937 -0400", hash_original_field = "6FDAD09C5B83FE076E966D1B24E66234", hash_generated_field = "FDDD7BCA9CDA28F5A3E99818FA3CA6DE")

    private final static String TAG = "CountryDetector";
}

