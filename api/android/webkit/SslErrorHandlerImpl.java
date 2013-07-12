package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.LinkedList;
import java.util.ListIterator;

class SslErrorHandlerImpl extends SslErrorHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.190 -0400", hash_original_field = "0924E7DA0697C861A386D2C4A20421F8", hash_generated_field = "1DFA7AE1BD952C18E1D76D9BAFCEAA92")

    private LinkedList<LoadListener> mLoaderQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.190 -0400", hash_original_field = "5AE885C01691F4B0DD5E72501AD24BAD", hash_generated_field = "0EBBEDC3B7330F6D7F551BA5F56946AB")

    private Bundle mSslPrefTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.190 -0400", hash_original_field = "724999CCACCD38C69F8741CE438C0D2D", hash_generated_field = "0823A225A6B98AC84669033E96217862")

    private SslErrorHandler mOriginHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.190 -0400", hash_original_field = "FD98EF1D956356B754B181390D5904EB", hash_generated_field = "575F6C3ED9DF00A745593F15FF93C229")

    private LoadListener mLoadListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.191 -0400", hash_original_method = "A9D6B0D7435532871C80AFF391EAC1F3", hash_generated_method = "D5C6DF2322CEE0B4504A01219ED4C7CE")
      SslErrorHandlerImpl() {
        mLoaderQueue = new LinkedList<LoadListener>();
        mSslPrefTable = new Bundle();
        mOriginHandler = null;
        mLoadListener = null;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.192 -0400", hash_original_method = "91EB591AB70C8A379D1426222FA143D7", hash_generated_method = "A88A0B916C7B5A9C81213D0D94E1F0CE")
    private  SslErrorHandlerImpl(SslErrorHandler origin, LoadListener listener) {
        mOriginHandler = origin;
        mLoadListener = listener;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.193 -0400", hash_original_method = "325914DF32EF22A63CA2688A9A750F18", hash_generated_method = "D63105C2C8701C1D85ED39AB6E6A320D")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case HANDLE_RESPONSE:
        LoadListener loader = (LoadListener) msg.obj;
        synchronized
(SslErrorHandlerImpl.this)        {
            handleSslErrorResponse(loader, loader.sslError(),
                            msg.arg1 == 1);
            mLoaderQueue.remove(loader);
            fastProcessQueuedSslErrors();
        } 
        break;
}
        
        
            
                
                
                    
                            
                    
                    
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.194 -0400", hash_original_method = "D029A1C8EDAAF4B35F26BECE197613A0", hash_generated_method = "C59A66C2AE0BBAE79FF625EAB48EA1AE")
    synchronized boolean saveState(Bundle outState) {
        addTaint(outState.getTaint());
        boolean success = (outState != null);
    if(success)        
        {
            outState.putBundle("ssl-error-handler", mSslPrefTable);
        } 
        boolean var260CA9DD8A4577FC00B7BD5810298076_941514654 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490628408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490628408;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.194 -0400", hash_original_method = "6F02B2C09ACF8BBAEA47573C8A17837E", hash_generated_method = "A5D7373BE1BFA9FC92E09588A96F327F")
    synchronized boolean restoreState(Bundle inState) {
        boolean success = (inState != null);
    if(success)        
        {
            success = inState.containsKey("ssl-error-handler");
    if(success)            
            {
                mSslPrefTable = inState.getBundle("ssl-error-handler");
            } 
        } 
        boolean var260CA9DD8A4577FC00B7BD5810298076_1053901191 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223767814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223767814;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.195 -0400", hash_original_method = "1C1564A7BC8E1B5AD415E60E6B0CBA09", hash_generated_method = "5E67DCC1BF128A2422A3A2FE824DEC86")
    synchronized void clear() {
        mSslPrefTable.clear();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.195 -0400", hash_original_method = "C8D7B9DA233B276F8D5E9642BE0FE843", hash_generated_method = "AEA7DA25B1C8A43E2B79C774457AE9FB")
    synchronized void handleSslErrorRequest(LoadListener loader) {
        addTaint(loader.getTaint());
    if(DebugFlags.SSL_ERROR_HANDLER)        
        {
        } 
    if(!loader.cancelled())        
        {
            mLoaderQueue.offer(loader);
    if(loader == mLoaderQueue.peek())            
            {
                fastProcessQueuedSslErrors();
            } 
        } 
        
        
            
                  
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.196 -0400", hash_original_method = "F91D7F8A2853C263C312AB7E69DBEB4B", hash_generated_method = "B4DE2BACD6F67AB5A92727D44B3A7CAA")
    synchronized boolean checkSslPrefTable(LoadListener loader,
            SslError error) {
        addTaint(error.getTaint());
        addTaint(loader.getTaint());
        final String host = loader.host();
        final int primary = error.getPrimaryError();
    if(DebugFlags.SSL_ERROR_HANDLER)        
        {
        } 
    if(mSslPrefTable.containsKey(host) && primary <= mSslPrefTable.getInt(host))        
        {
    if(!loader.cancelled())            
            {
                loader.handleSslErrorResponse(true);
            } 
            boolean varB326B5062B2F0E69046810717534CB09_1904213828 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1031450909 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1031450909;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1011821723 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689491973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689491973;
        
        
        
        
            
            
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.196 -0400", hash_original_method = "04F6EA99CF8E9997D9FE1719C2DB77FD", hash_generated_method = "67FCDED5D0C1B4C5F9B74414677CA070")
     void fastProcessQueuedSslErrors() {
        while
(processNextLoader())        
        ;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.197 -0400", hash_original_method = "C17562BADC30EBD8B8536D75F1BFCDF6", hash_generated_method = "F38D723407E5ADD5F82ADA4B2D794930")
    private synchronized boolean processNextLoader() {
        LoadListener loader = mLoaderQueue.peek();
    if(loader != null)        
        {
    if(loader.cancelled())            
            {
                mLoaderQueue.remove(loader);
                boolean varB326B5062B2F0E69046810717534CB09_1778576240 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_491358044 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_491358044;
            } 
            SslError error = loader.sslError();
    if(DebugFlags.SSL_ERROR_HANDLER)            
            {
            } 
    if(checkSslPrefTable(loader, error))            
            {
                mLoaderQueue.remove(loader);
                boolean varB326B5062B2F0E69046810717534CB09_66378145 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415678294 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_415678294;
            } 
            CallbackProxy proxy = loader.getFrame().getCallbackProxy();
            proxy.onReceivedSslError(new SslErrorHandlerImpl(this, loader), error);
        } 
        boolean var68934A3E9455FA72420237EB05902327_454049905 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_545803346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_545803346;
        
        
        
            
                
                
            
            
            
                
            
            
                
                
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.197 -0400", hash_original_method = "ED6C618278238A667ACAB98E6417F45B", hash_generated_method = "BFB346E78F75DDB0B1D1346783FC5E66")
    public void proceed() {
        mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                HANDLE_RESPONSE, 1, 0, mLoadListener));
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.197 -0400", hash_original_method = "12C4CCCD01DBAE6BF230314E9D5755CB", hash_generated_method = "5AA488227E2C0BB28A147339A287A4AF")
    public void cancel() {
        mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                HANDLE_RESPONSE, 0, 0, mLoadListener));
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.198 -0400", hash_original_method = "5796F22078D6113D133FA1EE0019F75A", hash_generated_method = "F66E3BECF9A78C0EF81DAAA57486DF99")
    synchronized void handleSslErrorResponse(LoadListener loader,
            SslError error, boolean proceed) {
        addTaint(proceed);
        addTaint(error.getTaint());
        addTaint(loader.getTaint());
    if(DebugFlags.SSL_ERROR_HANDLER)        
        {
        } 
    if(DebugFlags.SSL_ERROR_HANDLER)        
        {
        } 
    if(!loader.cancelled())        
        {
    if(proceed)            
            {
                int primary = error.getPrimaryError();
                String host = loader.host();
    if(DebugFlags.SSL_ERROR_HANDLER)                
                {
                } 
                boolean hasKey = mSslPrefTable.containsKey(host);
    if(!hasKey || primary > mSslPrefTable.getInt(host))                
                {
                    mSslPrefTable.putInt(host, primary);
                } 
            } 
            loader.handleSslErrorResponse(proceed);
        } 
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.198 -0400", hash_original_field = "9C0E52F6EA09A89CC23A82A807E7244F", hash_generated_field = "F098064C2753AB544D48EBBEF82B0BA4")

    private static final String LOGTAG = "network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.198 -0400", hash_original_field = "3FDB2EE9DFDF8CF9920BB9704639148D", hash_generated_field = "C766379B3EEFF589AF6549B30B31F022")

    private static final int HANDLE_RESPONSE = 100;
}

