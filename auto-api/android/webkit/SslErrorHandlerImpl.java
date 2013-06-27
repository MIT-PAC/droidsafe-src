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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.577 -0400", hash_original_field = "0924E7DA0697C861A386D2C4A20421F8", hash_generated_field = "1DFA7AE1BD952C18E1D76D9BAFCEAA92")

    private LinkedList<LoadListener> mLoaderQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.577 -0400", hash_original_field = "5AE885C01691F4B0DD5E72501AD24BAD", hash_generated_field = "0EBBEDC3B7330F6D7F551BA5F56946AB")

    private Bundle mSslPrefTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.577 -0400", hash_original_field = "724999CCACCD38C69F8741CE438C0D2D", hash_generated_field = "0823A225A6B98AC84669033E96217862")

    private SslErrorHandler mOriginHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.577 -0400", hash_original_field = "FD98EF1D956356B754B181390D5904EB", hash_generated_field = "575F6C3ED9DF00A745593F15FF93C229")

    private LoadListener mLoadListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.578 -0400", hash_original_method = "A9D6B0D7435532871C80AFF391EAC1F3", hash_generated_method = "D5C6DF2322CEE0B4504A01219ED4C7CE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.578 -0400", hash_original_method = "91EB591AB70C8A379D1426222FA143D7", hash_generated_method = "A88A0B916C7B5A9C81213D0D94E1F0CE")
    private  SslErrorHandlerImpl(SslErrorHandler origin, LoadListener listener) {
        mOriginHandler = origin;
        mLoadListener = listener;
        // ---------- Original Method ----------
        //mOriginHandler = origin;
        //mLoadListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.590 -0400", hash_original_method = "325914DF32EF22A63CA2688A9A750F18", hash_generated_method = "3349F05503A16BD66477386FEF3CA1FC")
    @Override
    public void handleMessage(Message msg) {
        //Begin case HANDLE_RESPONSE 
        LoadListener loader;
        loader = (LoadListener) msg.obj;
        //End case HANDLE_RESPONSE 
        //Begin case HANDLE_RESPONSE 
        {
            Object varA01C5B011F8CB72025CD61FE1CF575D3_285941884 = (SslErrorHandlerImpl.this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.591 -0400", hash_original_method = "D029A1C8EDAAF4B35F26BECE197613A0", hash_generated_method = "7EEF7B0ADE9A5D57A95EF65D6153BBDC")
    synchronized boolean saveState(Bundle outState) {
        boolean success;
        success = (outState != null);
        {
            outState.putBundle("ssl-error-handler", mSslPrefTable);
        } //End block
        addTaint(outState.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1826606006 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1826606006;
        // ---------- Original Method ----------
        //boolean success = (outState != null);
        //if (success) {
            //outState.putBundle("ssl-error-handler", mSslPrefTable);
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.591 -0400", hash_original_method = "6F02B2C09ACF8BBAEA47573C8A17837E", hash_generated_method = "D071FE34016218984D5665D3CBCC400E")
    synchronized boolean restoreState(Bundle inState) {
        boolean success;
        success = (inState != null);
        {
            success = inState.containsKey("ssl-error-handler");
            {
                mSslPrefTable = inState.getBundle("ssl-error-handler");
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1420051079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1420051079;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.592 -0400", hash_original_method = "1C1564A7BC8E1B5AD415E60E6B0CBA09", hash_generated_method = "5E67DCC1BF128A2422A3A2FE824DEC86")
    synchronized void clear() {
        mSslPrefTable.clear();
        // ---------- Original Method ----------
        //mSslPrefTable.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.592 -0400", hash_original_method = "C8D7B9DA233B276F8D5E9642BE0FE843", hash_generated_method = "8B3F2848A29F28334DE799C3A826D7DA")
    synchronized void handleSslErrorRequest(LoadListener loader) {
        {
            boolean var4CA682711E2F313295DD2C0DC4759245_529987380 = (!loader.cancelled());
            {
                mLoaderQueue.offer(loader);
                {
                    boolean var5A7C9FADECFA85DDBAA7E2DBAC8488F4_1814922834 = (loader == mLoaderQueue.peek());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.593 -0400", hash_original_method = "F91D7F8A2853C263C312AB7E69DBEB4B", hash_generated_method = "B5F6A74F80762493C51326DBEC521423")
    synchronized boolean checkSslPrefTable(LoadListener loader,
            SslError error) {
        String host;
        host = loader.host();
        int primary;
        primary = error.getPrimaryError();
        {
            boolean var9D95C999D94E1CE612D5BC8693995EA5_646501521 = (mSslPrefTable.containsKey(host) && primary <= mSslPrefTable.getInt(host));
            {
                {
                    boolean var9B23A35009EC718B2553DC7787FAADFC_2124501244 = (!loader.cancelled());
                    {
                        loader.handleSslErrorResponse(true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(loader.getTaint());
        addTaint(error.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325600115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325600115;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.593 -0400", hash_original_method = "04F6EA99CF8E9997D9FE1719C2DB77FD", hash_generated_method = "445EA3C44960C5825E561CE7CF641CE7")
     void fastProcessQueuedSslErrors() {
        {
            boolean varC35987D150EBE78B368C54ADC1628B3E_195470169 = (processNextLoader());
            ;
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (processNextLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.605 -0400", hash_original_method = "C17562BADC30EBD8B8536D75F1BFCDF6", hash_generated_method = "A7228FFDAC3F3BD3E3C78C3773F16DE5")
    private synchronized boolean processNextLoader() {
        LoadListener loader;
        loader = mLoaderQueue.peek();
        {
            {
                boolean var3CC72E1AB5EF7351D7DC244355DFC372_1425671759 = (loader.cancelled());
                {
                    mLoaderQueue.remove(loader);
                } //End block
            } //End collapsed parenthetic
            SslError error;
            error = loader.sslError();
            {
                boolean var62D43182C73FC9F796C77F406880B021_732232407 = (checkSslPrefTable(loader, error));
                {
                    mLoaderQueue.remove(loader);
                } //End block
            } //End collapsed parenthetic
            CallbackProxy proxy;
            proxy = loader.getFrame().getCallbackProxy();
            proxy.onReceivedSslError(new SslErrorHandlerImpl(this, loader), error);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1148563021 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1148563021;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.605 -0400", hash_original_method = "ED6C618278238A667ACAB98E6417F45B", hash_generated_method = "BFB346E78F75DDB0B1D1346783FC5E66")
    public void proceed() {
        mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                HANDLE_RESPONSE, 1, 0, mLoadListener));
        // ---------- Original Method ----------
        //mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                //HANDLE_RESPONSE, 1, 0, mLoadListener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.606 -0400", hash_original_method = "12C4CCCD01DBAE6BF230314E9D5755CB", hash_generated_method = "5AA488227E2C0BB28A147339A287A4AF")
    public void cancel() {
        mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                HANDLE_RESPONSE, 0, 0, mLoadListener));
        // ---------- Original Method ----------
        //mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                //HANDLE_RESPONSE, 0, 0, mLoadListener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.606 -0400", hash_original_method = "5796F22078D6113D133FA1EE0019F75A", hash_generated_method = "F8190B41779A2FE380CE18A8C35A6FF7")
    synchronized void handleSslErrorResponse(LoadListener loader,
            SslError error, boolean proceed) {
        {
            boolean var4CA682711E2F313295DD2C0DC4759245_1729247839 = (!loader.cancelled());
            {
                {
                    int primary;
                    primary = error.getPrimaryError();
                    String host;
                    host = loader.host();
                    boolean hasKey;
                    hasKey = mSslPrefTable.containsKey(host);
                    {
                        boolean varA566236BCFA27FF37E6F034EE75F2F7B_203653127 = (!hasKey || primary > mSslPrefTable.getInt(host));
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.606 -0400", hash_original_field = "9C0E52F6EA09A89CC23A82A807E7244F", hash_generated_field = "D6FF1579342774FD892BEA7EB0825E1D")

    private static String LOGTAG = "network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.606 -0400", hash_original_field = "3FDB2EE9DFDF8CF9920BB9704639148D", hash_generated_field = "CFE1CABA0F91762CA6D4FB348741EE19")

    private static int HANDLE_RESPONSE = 100;
}

