package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.LinkedList;

import android.os.Message;





class HttpAuthHandlerImpl extends HttpAuthHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.139 -0400", hash_original_field = "92BCA70246F96A0F4366A7F1448D9E16", hash_generated_field = "E0FAA2A6C497494B58133B8740B95CC3")

    private Network mNetwork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.139 -0400", hash_original_field = "0924E7DA0697C861A386D2C4A20421F8", hash_generated_field = "1DFA7AE1BD952C18E1D76D9BAFCEAA92")

    private LinkedList<LoadListener> mLoaderQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.139 -0400", hash_original_field = "98833F887433A020D9AC475903355379", hash_generated_field = "FBA1E121D7E2FF697782F001BE51E87B")

    Object mRequestInFlightLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.139 -0400", hash_original_field = "8CD96C4C1FB9EADAE7C8DEFDA59DF052", hash_generated_field = "D45D4B46CC19E8188195D2A11D8D61D7")

    boolean mRequestInFlight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.139 -0400", hash_original_field = "2FB3EB7CD104D0E14FE0487884A12591", hash_generated_field = "F6C0B2A92BAD484AE3E9DE7409D6C7A8")

    String mUsername;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.139 -0400", hash_original_field = "5C6B7EE711155A7472DA571800057A96", hash_generated_field = "6E680D0312272F1C50F2E99ACBEA882B")

    String mPassword;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.139 -0400", hash_original_method = "DD7F5BEFB1D050713E2D554BF9DDD08D", hash_generated_method = "8911D217534BAC31E2F8A0A202A6FEB6")
      HttpAuthHandlerImpl(Network network) {
        mNetwork = network;
        mLoaderQueue = new LinkedList<LoadListener>();
        // ---------- Original Method ----------
        //mNetwork = network;
        //mLoaderQueue = new LinkedList<LoadListener>();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.139 -0400", hash_original_method = "92EA526117BA58D828A346DC2F14E6C7", hash_generated_method = "EEDDE2A84B78114E4954787EAB574E6D")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        LoadListener loader = null;
        synchronized
(mLoaderQueue)        {
            loader = mLoaderQueue.poll();
        } //End block
switch(msg.what){
        case AUTH_PROCEED:
        String username = msg.getData().getString("username");
        String password = msg.getData().getString("password");
        loader.handleAuthResponse(username, password);
        break;
        case AUTH_CANCEL:
        loader.handleAuthResponse(null, null);
        break;
}        processNextLoader();
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.140 -0400", hash_original_method = "633BAC1354102784355BBDC241836385", hash_generated_method = "2E7EFD070BB3E1E03B8C1B62FF5996FA")
    private boolean handleResponseForSynchronousRequest(String username, String password) {
        LoadListener loader = null;
        synchronized
(mLoaderQueue)        {
            loader = mLoaderQueue.peek();
        } //End block
        if(loader.isSynchronous())        
        {
            mUsername = username;
            mPassword = password;
            boolean varB326B5062B2F0E69046810717534CB09_681284736 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792862280 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792862280;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_646531196 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1767787750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1767787750;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.140 -0400", hash_original_method = "D0913A95E2E0984BDC30D85F1A6DD6EF", hash_generated_method = "E45C4BF2EF286DDD894B985A2244BF2F")
    private void signalRequestComplete() {
        synchronized
(mRequestInFlightLock)        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.140 -0400", hash_original_method = "3FC26787C5211E44D8B34B9447EFC8D6", hash_generated_method = "9BC27FCF7D7513655235C49E72BCDC7D")
    public void proceed(String username, String password) {
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        if(handleResponseForSynchronousRequest(username, password))        
        {
            signalRequestComplete();
            return;
        } //End block
        Message msg = obtainMessage(AUTH_PROCEED);
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.140 -0400", hash_original_method = "1C78A3648C04874A6B02C5BA2CA8304A", hash_generated_method = "AA3B7C319F1C5E900CE0E0A8E8340AE3")
    public void cancel() {
        if(handleResponseForSynchronousRequest(null, null))        
        {
            signalRequestComplete();
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.140 -0400", hash_original_method = "0DB7D7C368B555F88B0E01139A6FA13A", hash_generated_method = "1EED165875B4F44B31DAB6B5D9D6C0D2")
    public boolean useHttpAuthUsernamePassword() {
        LoadListener loader = null;
        synchronized
(mLoaderQueue)        {
            loader = mLoaderQueue.peek();
        } //End block
        if(loader != null)        
        {
            boolean var57BC040E0145AC5D927430883EC45B16_170719956 = (!loader.authCredentialsInvalid());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_52907667 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_52907667;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_393466346 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1171947045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1171947045;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.141 -0400", hash_original_method = "69FA3518C12F8613622C8FCCAB6F2AF7", hash_generated_method = "43A72805B00AF86B41128D7DB7626C67")
     void handleAuthRequest(LoadListener loader) {
        addTaint(loader.getTaint());
        if(loader.isSynchronous())        
        {
            waitForRequestToComplete();
            synchronized
(mLoaderQueue)            {
                mLoaderQueue.addFirst(loader);
            } //End block
            processNextLoader();
            waitForRequestToComplete();
            synchronized
(mLoaderQueue)            {
                mLoaderQueue.poll();
            } //End block
            loader.handleAuthResponse(mUsername, mPassword);
            return;
        } //End block
        boolean processNext = false;
        synchronized
(mLoaderQueue)        {
            mLoaderQueue.offer(loader);
            processNext =
                (mLoaderQueue.size() == 1);
        } //End block
        if(processNext)        
        {
            processNextLoader();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.141 -0400", hash_original_method = "886E13332A9209796D68B57BD4AA101D", hash_generated_method = "80F37B4D2EEE68ACA221FB51A2F201B9")
    private void waitForRequestToComplete() {
        synchronized
(mRequestInFlightLock)        {
            while
(mRequestInFlight)            
            {
                try 
                {
                    mRequestInFlightLock.wait();
                } //End block
                catch (InterruptedException e)
                {
                } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.141 -0400", hash_original_method = "915750F5CD3DA8563236F4856CDF7624", hash_generated_method = "D4A75886C029AED430F0DA1108C43AF1")
    private void processNextLoader() {
        LoadListener loader = null;
        synchronized
(mLoaderQueue)        {
            loader = mLoaderQueue.peek();
        } //End block
        if(loader != null)        
        {
            synchronized
(mRequestInFlightLock)            {
                mRequestInFlight = true;
            } //End block
            CallbackProxy proxy = loader.getFrame().getCallbackProxy();
            String hostname = loader.proxyAuthenticate() ?
                mNetwork.getProxyHostname() : loader.host();
            String realm = loader.realm();
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

    
    @DSModeled(DSC.BAN)
    public static void onReceivedCredentials(LoadListener loader,
            String host, String realm, String username, String password) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        CallbackProxy proxy = loader.getFrame().getCallbackProxy();
        proxy.onReceivedHttpAuthCredentials(host, realm, username, password);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.141 -0400", hash_original_field = "9C0E52F6EA09A89CC23A82A807E7244F", hash_generated_field = "F098064C2753AB544D48EBBEF82B0BA4")

    private static final String LOGTAG = "network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.141 -0400", hash_original_field = "9A2AE89924929921CDB39F682EE97CD7", hash_generated_field = "307137EC37CD63DF6594FE42EBE00E97")

    private static final int AUTH_PROCEED = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.141 -0400", hash_original_field = "2075C787E601ADE7A2B6630E2147FC94", hash_generated_field = "F401DC0DF68B8C3DD6861879E588C39D")

    private static final int AUTH_CANCEL = 200;
}

