package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.LinkedList;
import java.util.ListIterator;

class SslErrorHandlerImpl extends SslErrorHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.558 -0400", hash_original_field = "0924E7DA0697C861A386D2C4A20421F8", hash_generated_field = "1DFA7AE1BD952C18E1D76D9BAFCEAA92")

    private LinkedList<LoadListener> mLoaderQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.558 -0400", hash_original_field = "5AE885C01691F4B0DD5E72501AD24BAD", hash_generated_field = "0EBBEDC3B7330F6D7F551BA5F56946AB")

    private Bundle mSslPrefTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.558 -0400", hash_original_field = "724999CCACCD38C69F8741CE438C0D2D", hash_generated_field = "0823A225A6B98AC84669033E96217862")

    private SslErrorHandler mOriginHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.558 -0400", hash_original_field = "FD98EF1D956356B754B181390D5904EB", hash_generated_field = "575F6C3ED9DF00A745593F15FF93C229")

    private LoadListener mLoadListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.559 -0400", hash_original_method = "A9D6B0D7435532871C80AFF391EAC1F3", hash_generated_method = "D5C6DF2322CEE0B4504A01219ED4C7CE")
      SslErrorHandlerImpl() {
        mLoaderQueue = new LinkedList<LoadListener>();
        mSslPrefTable = new Bundle();
        mOriginHandler = null;
        mLoadListener = null;
        // ---------- Original Method ----------
        //mLoaderQueue = new LinkedList<LoadListener>();
        //mSslPrefTable = new Bundle();
        //mOriginHandler = null;
        //mLoadListener = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.559 -0400", hash_original_method = "91EB591AB70C8A379D1426222FA143D7", hash_generated_method = "A88A0B916C7B5A9C81213D0D94E1F0CE")
    private  SslErrorHandlerImpl(SslErrorHandler origin, LoadListener listener) {
        mOriginHandler = origin;
        mLoadListener = listener;
        // ---------- Original Method ----------
        //mOriginHandler = origin;
        //mLoadListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.560 -0400", hash_original_method = "325914DF32EF22A63CA2688A9A750F18", hash_generated_method = "23A9669684AB88CD91D77D463F27353B")
    @Override
    public void handleMessage(Message msg) {
        //Begin case HANDLE_RESPONSE 
        LoadListener loader = (LoadListener) msg.obj;
        //End case HANDLE_RESPONSE 
        //Begin case HANDLE_RESPONSE 
        {
            Object varA01C5B011F8CB72025CD61FE1CF575D3_2137355498 = (SslErrorHandlerImpl.this);
            {
                handleSslErrorResponse(loader, loader.sslError(),
                            msg.arg1 == 1);
                mLoaderQueue.remove(loader);
                fastProcessQueuedSslErrors();
            } //End block
        } //End collapsed parenthetic
        //End case HANDLE_RESPONSE 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //switch (msg.what) {
            //case HANDLE_RESPONSE:
                //LoadListener loader = (LoadListener) msg.obj;
                //synchronized (SslErrorHandlerImpl.this) {
                    //handleSslErrorResponse(loader, loader.sslError(),
                            //msg.arg1 == 1);
                    //mLoaderQueue.remove(loader);
                    //fastProcessQueuedSslErrors();
                //}
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.560 -0400", hash_original_method = "D029A1C8EDAAF4B35F26BECE197613A0", hash_generated_method = "B29CB289D50C561423650107BB09F92A")
    synchronized boolean saveState(Bundle outState) {
        boolean success = (outState != null);
        {
            outState.putBundle("ssl-error-handler", mSslPrefTable);
        } //End block
        addTaint(outState.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130288637 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130288637;
        // ---------- Original Method ----------
        //boolean success = (outState != null);
        //if (success) {
            //outState.putBundle("ssl-error-handler", mSslPrefTable);
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.561 -0400", hash_original_method = "6F02B2C09ACF8BBAEA47573C8A17837E", hash_generated_method = "3E4BE60749AF73CA2D51308A111297E5")
    synchronized boolean restoreState(Bundle inState) {
        boolean success = (inState != null);
        {
            success = inState.containsKey("ssl-error-handler");
            {
                mSslPrefTable = inState.getBundle("ssl-error-handler");
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1235692183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1235692183;
        // ---------- Original Method ----------
        //boolean success = (inState != null);
        //if (success) {
            //success = inState.containsKey("ssl-error-handler");
            //if (success) {
                //mSslPrefTable = inState.getBundle("ssl-error-handler");
            //}
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.561 -0400", hash_original_method = "1C1564A7BC8E1B5AD415E60E6B0CBA09", hash_generated_method = "5E67DCC1BF128A2422A3A2FE824DEC86")
    synchronized void clear() {
        mSslPrefTable.clear();
        // ---------- Original Method ----------
        //mSslPrefTable.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.562 -0400", hash_original_method = "C8D7B9DA233B276F8D5E9642BE0FE843", hash_generated_method = "E8B47B44E2183941B5E6DA58D1D3E277")
    synchronized void handleSslErrorRequest(LoadListener loader) {
        {
            boolean var4CA682711E2F313295DD2C0DC4759245_1632796213 = (!loader.cancelled());
            {
                mLoaderQueue.offer(loader);
                {
                    boolean var5A7C9FADECFA85DDBAA7E2DBAC8488F4_34534903 = (loader == mLoaderQueue.peek());
                    {
                        fastProcessQueuedSslErrors();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(loader.getTaint());
        // ---------- Original Method ----------
        //if (DebugFlags.SSL_ERROR_HANDLER) {
            //Log.v(LOGTAG, "SslErrorHandler.handleSslErrorRequest(): " +
                  //"url=" + loader.url());
        //}
        //if (!loader.cancelled()) {
            //mLoaderQueue.offer(loader);
            //if (loader == mLoaderQueue.peek()) {
                //fastProcessQueuedSslErrors();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.563 -0400", hash_original_method = "F91D7F8A2853C263C312AB7E69DBEB4B", hash_generated_method = "397E6A300900442136E4372160D6EA29")
    synchronized boolean checkSslPrefTable(LoadListener loader,
            SslError error) {
        final String host = loader.host();
        final int primary = error.getPrimaryError();
        {
            boolean var9D95C999D94E1CE612D5BC8693995EA5_697653596 = (mSslPrefTable.containsKey(host) && primary <= mSslPrefTable.getInt(host));
            {
                {
                    boolean var9B23A35009EC718B2553DC7787FAADFC_1135636439 = (!loader.cancelled());
                    {
                        loader.handleSslErrorResponse(true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(loader.getTaint());
        addTaint(error.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356721868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356721868;
        // ---------- Original Method ----------
        //final String host = loader.host();
        //final int primary = error.getPrimaryError();
        //if (DebugFlags.SSL_ERROR_HANDLER) {
            //assert host != null;
            //assert primary != -1;
        //}
        //if (mSslPrefTable.containsKey(host) && primary <= mSslPrefTable.getInt(host)) {
            //if (!loader.cancelled()) {
                //loader.handleSslErrorResponse(true);
            //}
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.563 -0400", hash_original_method = "04F6EA99CF8E9997D9FE1719C2DB77FD", hash_generated_method = "9E924A17E654373E86FF1B017C8DCEF3")
     void fastProcessQueuedSslErrors() {
        {
            boolean varC35987D150EBE78B368C54ADC1628B3E_1229828633 = (processNextLoader());
            ;
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (processNextLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.564 -0400", hash_original_method = "C17562BADC30EBD8B8536D75F1BFCDF6", hash_generated_method = "EBE38BD2501649EF8F33B11DDEF517B4")
    private synchronized boolean processNextLoader() {
        LoadListener loader = mLoaderQueue.peek();
        {
            {
                boolean var3CC72E1AB5EF7351D7DC244355DFC372_2050281669 = (loader.cancelled());
                {
                    mLoaderQueue.remove(loader);
                } //End block
            } //End collapsed parenthetic
            SslError error = loader.sslError();
            {
                boolean var62D43182C73FC9F796C77F406880B021_1726562270 = (checkSslPrefTable(loader, error));
                {
                    mLoaderQueue.remove(loader);
                } //End block
            } //End collapsed parenthetic
            CallbackProxy proxy = loader.getFrame().getCallbackProxy();
            proxy.onReceivedSslError(new SslErrorHandlerImpl(this, loader), error);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_825816863 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_825816863;
        // ---------- Original Method ----------
        //LoadListener loader = mLoaderQueue.peek();
        //if (loader != null) {
            //if (loader.cancelled()) {
                //mLoaderQueue.remove(loader);
                //return true;
            //}
            //SslError error = loader.sslError();
            //if (DebugFlags.SSL_ERROR_HANDLER) {
                //assert error != null;
            //}
            //if (checkSslPrefTable(loader, error)) {
                //mLoaderQueue.remove(loader);
                //return true;
            //}
            //CallbackProxy proxy = loader.getFrame().getCallbackProxy();
            //proxy.onReceivedSslError(new SslErrorHandlerImpl(this, loader), error);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.564 -0400", hash_original_method = "ED6C618278238A667ACAB98E6417F45B", hash_generated_method = "BFB346E78F75DDB0B1D1346783FC5E66")
    public void proceed() {
        mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                HANDLE_RESPONSE, 1, 0, mLoadListener));
        // ---------- Original Method ----------
        //mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                //HANDLE_RESPONSE, 1, 0, mLoadListener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.564 -0400", hash_original_method = "12C4CCCD01DBAE6BF230314E9D5755CB", hash_generated_method = "5AA488227E2C0BB28A147339A287A4AF")
    public void cancel() {
        mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                HANDLE_RESPONSE, 0, 0, mLoadListener));
        // ---------- Original Method ----------
        //mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                //HANDLE_RESPONSE, 0, 0, mLoadListener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.565 -0400", hash_original_method = "5796F22078D6113D133FA1EE0019F75A", hash_generated_method = "63713F36337DDFC69AF438842348A9C8")
    synchronized void handleSslErrorResponse(LoadListener loader,
            SslError error, boolean proceed) {
        {
            boolean var4CA682711E2F313295DD2C0DC4759245_50476690 = (!loader.cancelled());
            {
                {
                    int primary = error.getPrimaryError();
                    String host = loader.host();
                    boolean hasKey = mSslPrefTable.containsKey(host);
                    {
                        boolean varA566236BCFA27FF37E6F034EE75F2F7B_1096602528 = (!hasKey || primary > mSslPrefTable.getInt(host));
                        {
                            mSslPrefTable.putInt(host, primary);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                loader.handleSslErrorResponse(proceed);
            } //End block
        } //End collapsed parenthetic
        addTaint(loader.getTaint());
        addTaint(error.getTaint());
        addTaint(proceed);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.565 -0400", hash_original_field = "9C0E52F6EA09A89CC23A82A807E7244F", hash_generated_field = "F098064C2753AB544D48EBBEF82B0BA4")

    private static final String LOGTAG = "network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.565 -0400", hash_original_field = "3FDB2EE9DFDF8CF9920BB9704639148D", hash_generated_field = "C766379B3EEFF589AF6549B30B31F022")

    private static final int HANDLE_RESPONSE = 100;
}

