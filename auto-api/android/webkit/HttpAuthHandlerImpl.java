package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ListIterator;
import java.util.LinkedList;

class HttpAuthHandlerImpl extends HttpAuthHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.924 -0400", hash_original_field = "92BCA70246F96A0F4366A7F1448D9E16", hash_generated_field = "E0FAA2A6C497494B58133B8740B95CC3")

    private Network mNetwork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.924 -0400", hash_original_field = "0924E7DA0697C861A386D2C4A20421F8", hash_generated_field = "1DFA7AE1BD952C18E1D76D9BAFCEAA92")

    private LinkedList<LoadListener> mLoaderQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.924 -0400", hash_original_field = "98833F887433A020D9AC475903355379", hash_generated_field = "FBA1E121D7E2FF697782F001BE51E87B")

    Object mRequestInFlightLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.924 -0400", hash_original_field = "8CD96C4C1FB9EADAE7C8DEFDA59DF052", hash_generated_field = "D45D4B46CC19E8188195D2A11D8D61D7")

    boolean mRequestInFlight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.924 -0400", hash_original_field = "2FB3EB7CD104D0E14FE0487884A12591", hash_generated_field = "F6C0B2A92BAD484AE3E9DE7409D6C7A8")

    String mUsername;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.924 -0400", hash_original_field = "5C6B7EE711155A7472DA571800057A96", hash_generated_field = "6E680D0312272F1C50F2E99ACBEA882B")

    String mPassword;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.924 -0400", hash_original_method = "DD7F5BEFB1D050713E2D554BF9DDD08D", hash_generated_method = "8911D217534BAC31E2F8A0A202A6FEB6")
      HttpAuthHandlerImpl(Network network) {
        mNetwork = network;
        mLoaderQueue = new LinkedList<LoadListener>();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.925 -0400", hash_original_method = "92EA526117BA58D828A346DC2F14E6C7", hash_generated_method = "B6ECC97991ACBFA8B203A90A435F3C66")
    @Override
    public void handleMessage(Message msg) {
        LoadListener loader = null;
        {
            loader = mLoaderQueue.poll();
        } 
        
        String username = msg.getData().getString("username");
        
        
        String password = msg.getData().getString("password");
        
        
        loader.handleAuthResponse(username, password);
        
        
        loader.handleAuthResponse(null, null);
        
        processNextLoader();
        addTaint(msg.getTaint());
        
        
        
            
        
        
        
            
                
                
                
                
            
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.925 -0400", hash_original_method = "633BAC1354102784355BBDC241836385", hash_generated_method = "31ED78E36F5BEE0BD746378F349CE30A")
    private boolean handleResponseForSynchronousRequest(String username, String password) {
        LoadListener loader = null;
        {
            loader = mLoaderQueue.peek();
        } 
        {
            boolean var221166D89B647BFDA3D85F45A3E4348F_376835623 = (loader.isSynchronous());
            {
                mUsername = username;
                mPassword = password;
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1743385297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1743385297;
        
        
        
            
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.925 -0400", hash_original_method = "D0913A95E2E0984BDC30D85F1A6DD6EF", hash_generated_method = "C96FDDEB25AEAE33C868369E88FC51C0")
    private void signalRequestComplete() {
        {
            mRequestInFlight = false;
            mRequestInFlightLock.notify();
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.926 -0400", hash_original_method = "3FC26787C5211E44D8B34B9447EFC8D6", hash_generated_method = "73B0212023C036597A5161C8288DA1C7")
    public void proceed(String username, String password) {
        {
            boolean var48EB5472B994D58361A4636BAEC97DA1_1315528789 = (handleResponseForSynchronousRequest(username, password));
            {
                signalRequestComplete();
            } 
        } 
        Message msg = obtainMessage(AUTH_PROCEED);
        msg.getData().putString("username", username);
        msg.getData().putString("password", password);
        sendMessage(msg);
        signalRequestComplete();
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        
        
            
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.926 -0400", hash_original_method = "1C78A3648C04874A6B02C5BA2CA8304A", hash_generated_method = "39AFB90B1C151792BEA7D066D91A65D2")
    public void cancel() {
        {
            boolean varE3A4C0A30ABB3BD770ADE223EB4A6CC1_369243076 = (handleResponseForSynchronousRequest(null, null));
            {
                signalRequestComplete();
            } 
        } 
        sendMessage(obtainMessage(AUTH_CANCEL));
        signalRequestComplete();
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.927 -0400", hash_original_method = "0DB7D7C368B555F88B0E01139A6FA13A", hash_generated_method = "B6BD55B1A77BDC752E82F0C273DFEAEB")
    public boolean useHttpAuthUsernamePassword() {
        LoadListener loader = null;
        {
            loader = mLoaderQueue.peek();
        } 
        {
            boolean varE8520BA1038614FF7EE7C51C46F527D1_338659491 = (!loader.authCredentialsInvalid());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1778602136 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1778602136;
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.927 -0400", hash_original_method = "69FA3518C12F8613622C8FCCAB6F2AF7", hash_generated_method = "65061F02FB88C5942BEE9D0C3D81B731")
     void handleAuthRequest(LoadListener loader) {
        {
            boolean var221166D89B647BFDA3D85F45A3E4348F_415806107 = (loader.isSynchronous());
            {
                waitForRequestToComplete();
                {
                    mLoaderQueue.addFirst(loader);
                } 
                processNextLoader();
                waitForRequestToComplete();
                {
                    mLoaderQueue.poll();
                } 
                loader.handleAuthResponse(mUsername, mPassword);
            } 
        } 
        boolean processNext = false;
        {
            mLoaderQueue.offer(loader);
            processNext =
                (mLoaderQueue.size() == 1);
        } 
        {
            processNextLoader();
        } 
        addTaint(loader.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.927 -0400", hash_original_method = "886E13332A9209796D68B57BD4AA101D", hash_generated_method = "8E8DD249AB23742088627630533DAA85")
    private void waitForRequestToComplete() {
        {
            {
                try 
                {
                    mRequestInFlightLock.wait();
                } 
                catch (InterruptedException e)
                { }
            } 
        } 
        
        
            
                
                    
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.928 -0400", hash_original_method = "915750F5CD3DA8563236F4856CDF7624", hash_generated_method = "37BBD98BB102B001E8404FC664779A20")
    private void processNextLoader() {
        LoadListener loader = null;
        {
            loader = mLoaderQueue.peek();
        } 
        {
            {
                mRequestInFlight = true;
            } 
            CallbackProxy proxy = loader.getFrame().getCallbackProxy();
            String hostname;
            boolean varB1DB9B9D9A13B0735B7565BED708C327_1165585488 = (loader.proxyAuthenticate());
            hostname = mNetwork.getProxyHostname();
            hostname = loader.host();
            String realm = loader.realm();
            proxy.onReceivedHttpAuthRequest(this, hostname, realm);
        } 
        
        
        
            
        
        
            
                
                
            
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void onReceivedCredentials(LoadListener loader,
            String host, String realm, String username, String password) {
        
        CallbackProxy proxy = loader.getFrame().getCallbackProxy();
        proxy.onReceivedHttpAuthCredentials(host, realm, username, password);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.928 -0400", hash_original_field = "9C0E52F6EA09A89CC23A82A807E7244F", hash_generated_field = "F098064C2753AB544D48EBBEF82B0BA4")

    private static final String LOGTAG = "network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.928 -0400", hash_original_field = "9A2AE89924929921CDB39F682EE97CD7", hash_generated_field = "307137EC37CD63DF6594FE42EBE00E97")

    private static final int AUTH_PROCEED = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.928 -0400", hash_original_field = "2075C787E601ADE7A2B6630E2147FC94", hash_generated_field = "F401DC0DF68B8C3DD6861879E588C39D")

    private static final int AUTH_CANCEL = 200;
}

