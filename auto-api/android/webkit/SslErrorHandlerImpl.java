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
    private LinkedList<LoadListener> mLoaderQueue;
    private Bundle mSslPrefTable;
    private SslErrorHandler mOriginHandler;
    private LoadListener mLoadListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.763 -0400", hash_original_method = "A9D6B0D7435532871C80AFF391EAC1F3", hash_generated_method = "D5C6DF2322CEE0B4504A01219ED4C7CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.763 -0400", hash_original_method = "91EB591AB70C8A379D1426222FA143D7", hash_generated_method = "32D01511E75C1869312E6C2A802CF0E2")
    @DSModeled(DSC.SAFE)
    private SslErrorHandlerImpl(SslErrorHandler origin, LoadListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(origin.dsTaint);
        // ---------- Original Method ----------
        //mOriginHandler = origin;
        //mLoadListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.763 -0400", hash_original_method = "325914DF32EF22A63CA2688A9A750F18", hash_generated_method = "347339DBE851708299C5FA29C57D16D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case HANDLE_RESPONSE 
        LoadListener loader;
        loader = (LoadListener) msg.obj;
        //End case HANDLE_RESPONSE 
        //Begin case HANDLE_RESPONSE 
        {
            Object varA01C5B011F8CB72025CD61FE1CF575D3_548867234 = (SslErrorHandlerImpl.this);
            {
                handleSslErrorResponse(loader, loader.sslError(),
                            msg.arg1 == 1);
                mLoaderQueue.remove(loader);
                fastProcessQueuedSslErrors();
            } //End block
        } //End collapsed parenthetic
        //End case HANDLE_RESPONSE 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.764 -0400", hash_original_method = "D029A1C8EDAAF4B35F26BECE197613A0", hash_generated_method = "1C354F3B2AD65645131605B403BBFD83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized boolean saveState(Bundle outState) {
        dsTaint.addTaint(outState.dsTaint);
        boolean success;
        success = (outState != null);
        {
            outState.putBundle("ssl-error-handler", mSslPrefTable);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean success = (outState != null);
        //if (success) {
            //outState.putBundle("ssl-error-handler", mSslPrefTable);
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.764 -0400", hash_original_method = "6F02B2C09ACF8BBAEA47573C8A17837E", hash_generated_method = "83AE0ED1338883C439045A17CEB0E9A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized boolean restoreState(Bundle inState) {
        dsTaint.addTaint(inState.dsTaint);
        boolean success;
        success = (inState != null);
        {
            success = inState.containsKey("ssl-error-handler");
            {
                mSslPrefTable = inState.getBundle("ssl-error-handler");
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.764 -0400", hash_original_method = "1C1564A7BC8E1B5AD415E60E6B0CBA09", hash_generated_method = "5E67DCC1BF128A2422A3A2FE824DEC86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void clear() {
        mSslPrefTable.clear();
        // ---------- Original Method ----------
        //mSslPrefTable.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.764 -0400", hash_original_method = "C8D7B9DA233B276F8D5E9642BE0FE843", hash_generated_method = "A28BDC9F53BE521889B206E2B6749D58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void handleSslErrorRequest(LoadListener loader) {
        dsTaint.addTaint(loader.dsTaint);
        {
            boolean var4CA682711E2F313295DD2C0DC4759245_76286825 = (!loader.cancelled());
            {
                mLoaderQueue.offer(loader);
                {
                    boolean var5A7C9FADECFA85DDBAA7E2DBAC8488F4_1738777964 = (loader == mLoaderQueue.peek());
                    {
                        fastProcessQueuedSslErrors();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.765 -0400", hash_original_method = "F91D7F8A2853C263C312AB7E69DBEB4B", hash_generated_method = "7D71F885D421098F2304EAA94FF91324")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized boolean checkSslPrefTable(LoadListener loader,
            SslError error) {
        dsTaint.addTaint(error.dsTaint);
        dsTaint.addTaint(loader.dsTaint);
        String host;
        host = loader.host();
        int primary;
        primary = error.getPrimaryError();
        {
            boolean var9D95C999D94E1CE612D5BC8693995EA5_1433802290 = (mSslPrefTable.containsKey(host) && primary <= mSslPrefTable.getInt(host));
            {
                {
                    boolean var9B23A35009EC718B2553DC7787FAADFC_1537165571 = (!loader.cancelled());
                    {
                        loader.handleSslErrorResponse(true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.765 -0400", hash_original_method = "04F6EA99CF8E9997D9FE1719C2DB77FD", hash_generated_method = "4A6F0487EE57E5F5DF613D3D09E13AC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void fastProcessQueuedSslErrors() {
        {
            boolean varC35987D150EBE78B368C54ADC1628B3E_617087851 = (processNextLoader());
            ;
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (processNextLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.765 -0400", hash_original_method = "C17562BADC30EBD8B8536D75F1BFCDF6", hash_generated_method = "93306A2EB1C09D2804D7C382BFABE19D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean processNextLoader() {
        LoadListener loader;
        loader = mLoaderQueue.peek();
        {
            {
                boolean var3CC72E1AB5EF7351D7DC244355DFC372_1663327994 = (loader.cancelled());
                {
                    mLoaderQueue.remove(loader);
                } //End block
            } //End collapsed parenthetic
            SslError error;
            error = loader.sslError();
            {
                boolean var62D43182C73FC9F796C77F406880B021_1677578519 = (checkSslPrefTable(loader, error));
                {
                    mLoaderQueue.remove(loader);
                } //End block
            } //End collapsed parenthetic
            CallbackProxy proxy;
            proxy = loader.getFrame().getCallbackProxy();
            proxy.onReceivedSslError(new SslErrorHandlerImpl(this, loader), error);
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.765 -0400", hash_original_method = "ED6C618278238A667ACAB98E6417F45B", hash_generated_method = "BFB346E78F75DDB0B1D1346783FC5E66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void proceed() {
        mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                HANDLE_RESPONSE, 1, 0, mLoadListener));
        // ---------- Original Method ----------
        //mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                //HANDLE_RESPONSE, 1, 0, mLoadListener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.766 -0400", hash_original_method = "12C4CCCD01DBAE6BF230314E9D5755CB", hash_generated_method = "5AA488227E2C0BB28A147339A287A4AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                HANDLE_RESPONSE, 0, 0, mLoadListener));
        // ---------- Original Method ----------
        //mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                //HANDLE_RESPONSE, 0, 0, mLoadListener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.766 -0400", hash_original_method = "5796F22078D6113D133FA1EE0019F75A", hash_generated_method = "ED75AFA8F771B195BABDC695EC5DC696")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void handleSslErrorResponse(LoadListener loader,
            SslError error, boolean proceed) {
        dsTaint.addTaint(error.dsTaint);
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(proceed);
        {
            boolean var4CA682711E2F313295DD2C0DC4759245_967296418 = (!loader.cancelled());
            {
                {
                    int primary;
                    primary = error.getPrimaryError();
                    String host;
                    host = loader.host();
                    boolean hasKey;
                    hasKey = mSslPrefTable.containsKey(host);
                    {
                        boolean varA566236BCFA27FF37E6F034EE75F2F7B_1841306418 = (!hasKey || primary > mSslPrefTable.getInt(host));
                        {
                            mSslPrefTable.putInt(host, primary);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                loader.handleSslErrorResponse(proceed);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final String LOGTAG = "network";
    private static final int HANDLE_RESPONSE = 100;
}

