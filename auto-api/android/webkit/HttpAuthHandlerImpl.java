package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ListIterator;
import java.util.LinkedList;

class HttpAuthHandlerImpl extends HttpAuthHandler {
    private Network mNetwork;
    private LinkedList<LoadListener> mLoaderQueue;
    Object mRequestInFlightLock = new Object();
    boolean mRequestInFlight;
    String mUsername;
    String mPassword;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.375 -0400", hash_original_method = "DD7F5BEFB1D050713E2D554BF9DDD08D", hash_generated_method = "91A7255CEC92CA24696AFFD91CDA5A55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HttpAuthHandlerImpl(Network network) {
        dsTaint.addTaint(network.dsTaint);
        mLoaderQueue = new LinkedList<LoadListener>();
        // ---------- Original Method ----------
        //mNetwork = network;
        //mLoaderQueue = new LinkedList<LoadListener>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.375 -0400", hash_original_method = "92EA526117BA58D828A346DC2F14E6C7", hash_generated_method = "D6C30D8654B8632DED0FB61D6E5A5097")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        LoadListener loader;
        loader = null;
        {
            loader = mLoaderQueue.poll();
        } //End block
        //Begin case AUTH_PROCEED 
        String username;
        username = msg.getData().getString("username");
        //End case AUTH_PROCEED 
        //Begin case AUTH_PROCEED 
        String password;
        password = msg.getData().getString("password");
        //End case AUTH_PROCEED 
        //Begin case AUTH_PROCEED 
        loader.handleAuthResponse(username, password);
        //End case AUTH_PROCEED 
        //Begin case AUTH_CANCEL 
        loader.handleAuthResponse(null, null);
        //End case AUTH_CANCEL 
        processNextLoader();
        // ---------- Original Method ----------
        //LoadListener loader = null;
        //synchronized (mLoaderQueue) {
            //loader = mLoaderQueue.poll();
        //}
        //assert(loader.isSynchronous() == false);
        //switch (msg.what) {
            //case AUTH_PROCEED:
                //String username = msg.getData().getString("username");
                //String password = msg.getData().getString("password");
                //loader.handleAuthResponse(username, password);
                //break;
            //case AUTH_CANCEL:
                //loader.handleAuthResponse(null, null);
                //break;
        //}
        //processNextLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.375 -0400", hash_original_method = "633BAC1354102784355BBDC241836385", hash_generated_method = "F15CE8E7F915DB96F8572779E071B3C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleResponseForSynchronousRequest(String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(password);
        LoadListener loader;
        loader = null;
        {
            loader = mLoaderQueue.peek();
        } //End block
        {
            boolean var221166D89B647BFDA3D85F45A3E4348F_1911862389 = (loader.isSynchronous());
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //LoadListener loader = null;
        //synchronized (mLoaderQueue) {
            //loader = mLoaderQueue.peek();
        //}
        //if (loader.isSynchronous()) {
            //mUsername = username;
            //mPassword = password;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.376 -0400", hash_original_method = "D0913A95E2E0984BDC30D85F1A6DD6EF", hash_generated_method = "C96FDDEB25AEAE33C868369E88FC51C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void signalRequestComplete() {
        {
            mRequestInFlight = false;
            mRequestInFlightLock.notify();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mRequestInFlightLock) {
            //assert(mRequestInFlight);
            //mRequestInFlight = false;
            //mRequestInFlightLock.notify();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.376 -0400", hash_original_method = "3FC26787C5211E44D8B34B9447EFC8D6", hash_generated_method = "6D08F3943969EA5809EBBEA84CC26196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void proceed(String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(password);
        {
            boolean var48EB5472B994D58361A4636BAEC97DA1_1103714622 = (handleResponseForSynchronousRequest(username, password));
            {
                signalRequestComplete();
            } //End block
        } //End collapsed parenthetic
        Message msg;
        msg = obtainMessage(AUTH_PROCEED);
        msg.getData().putString("username", username);
        msg.getData().putString("password", password);
        sendMessage(msg);
        signalRequestComplete();
        // ---------- Original Method ----------
        //if (handleResponseForSynchronousRequest(username, password)) {
            //signalRequestComplete();
            //return;
        //}
        //Message msg = obtainMessage(AUTH_PROCEED);
        //msg.getData().putString("username", username);
        //msg.getData().putString("password", password);
        //sendMessage(msg);
        //signalRequestComplete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.376 -0400", hash_original_method = "1C78A3648C04874A6B02C5BA2CA8304A", hash_generated_method = "969F446E6C9CC4DBE5DE1C83CCE88DD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        {
            boolean varE3A4C0A30ABB3BD770ADE223EB4A6CC1_1210237397 = (handleResponseForSynchronousRequest(null, null));
            {
                signalRequestComplete();
            } //End block
        } //End collapsed parenthetic
        sendMessage(obtainMessage(AUTH_CANCEL));
        signalRequestComplete();
        // ---------- Original Method ----------
        //if (handleResponseForSynchronousRequest(null, null)) {
            //signalRequestComplete();
            //return;
        //}
        //sendMessage(obtainMessage(AUTH_CANCEL));
        //signalRequestComplete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.377 -0400", hash_original_method = "0DB7D7C368B555F88B0E01139A6FA13A", hash_generated_method = "02D3F2C01920C8B861359BDDC9CB2CFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean useHttpAuthUsernamePassword() {
        LoadListener loader;
        loader = null;
        {
            loader = mLoaderQueue.peek();
        } //End block
        {
            boolean varE8520BA1038614FF7EE7C51C46F527D1_237004449 = (!loader.authCredentialsInvalid());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //LoadListener loader = null;
        //synchronized (mLoaderQueue) {
            //loader = mLoaderQueue.peek();
        //}
        //if (loader != null) {
            //return !loader.authCredentialsInvalid();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.377 -0400", hash_original_method = "69FA3518C12F8613622C8FCCAB6F2AF7", hash_generated_method = "4CE48F371E6BE89D04C504CF4850425D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleAuthRequest(LoadListener loader) {
        dsTaint.addTaint(loader.dsTaint);
        {
            boolean var221166D89B647BFDA3D85F45A3E4348F_363957544 = (loader.isSynchronous());
            {
                waitForRequestToComplete();
                {
                    mLoaderQueue.addFirst(loader);
                } //End block
                processNextLoader();
                waitForRequestToComplete();
                {
                    mLoaderQueue.poll();
                } //End block
                loader.handleAuthResponse(mUsername, mPassword);
            } //End block
        } //End collapsed parenthetic
        boolean processNext;
        processNext = false;
        {
            mLoaderQueue.offer(loader);
            processNext =
                (mLoaderQueue.size() == 1);
        } //End block
        {
            processNextLoader();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.377 -0400", hash_original_method = "886E13332A9209796D68B57BD4AA101D", hash_generated_method = "8E8DD249AB23742088627630533DAA85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void waitForRequestToComplete() {
        {
            {
                try 
                {
                    mRequestInFlightLock.wait();
                } //End block
                catch (InterruptedException e)
                { }
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mRequestInFlightLock) {
            //while (mRequestInFlight) {
                //try {
                    //mRequestInFlightLock.wait();
                //} catch(InterruptedException e) {
                    //Log.e(LOGTAG, "Interrupted while waiting for request to complete");
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.377 -0400", hash_original_method = "915750F5CD3DA8563236F4856CDF7624", hash_generated_method = "9BDA32409177497871AD820071FE6DC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processNextLoader() {
        LoadListener loader;
        loader = null;
        {
            loader = mLoaderQueue.peek();
        } //End block
        {
            {
                mRequestInFlight = true;
            } //End block
            CallbackProxy proxy;
            proxy = loader.getFrame().getCallbackProxy();
            String hostname;
            boolean varB1DB9B9D9A13B0735B7565BED708C327_160179586 = (loader.proxyAuthenticate());
            hostname = mNetwork.getProxyHostname();
            hostname = loader.host();
            String realm;
            realm = loader.realm();
            proxy.onReceivedHttpAuthRequest(this, hostname, realm);
        } //End block
        // ---------- Original Method ----------
        //LoadListener loader = null;
        //synchronized (mLoaderQueue) {
            //loader = mLoaderQueue.peek();
        //}
        //if (loader != null) {
            //synchronized (mRequestInFlightLock) {
                //assert(mRequestInFlight == false);
                //mRequestInFlight = true;
            //}
            //CallbackProxy proxy = loader.getFrame().getCallbackProxy();
            //String hostname = loader.proxyAuthenticate() ?
                //mNetwork.getProxyHostname() : loader.host();
            //String realm = loader.realm();
            //proxy.onReceivedHttpAuthRequest(this, hostname, realm);
        //}
    }

    
        public static void onReceivedCredentials(LoadListener loader,
            String host, String realm, String username, String password) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        CallbackProxy proxy = loader.getFrame().getCallbackProxy();
        proxy.onReceivedHttpAuthCredentials(host, realm, username, password);
    }

    
    private static final String LOGTAG = "network";
    private static final int AUTH_PROCEED = 100;
    private static final int AUTH_CANCEL = 200;
}

