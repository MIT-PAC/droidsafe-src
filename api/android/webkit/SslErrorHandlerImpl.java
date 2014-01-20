package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.LinkedList;

import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;

class SslErrorHandlerImpl extends SslErrorHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.087 -0500", hash_original_field = "B8F296222D99B13B57A30F4500AF7F3D", hash_generated_field = "F098064C2753AB544D48EBBEF82B0BA4")

    private static final String LOGTAG = "network";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.098 -0500", hash_original_field = "3B9AB7B503475250BCB386D020A76672", hash_generated_field = "C766379B3EEFF589AF6549B30B31F022")

    private static final int HANDLE_RESPONSE = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.089 -0500", hash_original_field = "3716B531CEC47234F4A7CC60510C3140", hash_generated_field = "1DFA7AE1BD952C18E1D76D9BAFCEAA92")

    private LinkedList<LoadListener> mLoaderQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.091 -0500", hash_original_field = "BE2ED35AB296A3F82F29A7392231CEAE", hash_generated_field = "0EBBEDC3B7330F6D7F551BA5F56946AB")

    private Bundle mSslPrefTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.093 -0500", hash_original_field = "A8F0EA7058C84D6CFBB5F92C9A9089A1", hash_generated_field = "0823A225A6B98AC84669033E96217862")

    private  SslErrorHandler mOriginHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.096 -0500", hash_original_field = "469095379AEB9651D259E87F1B97E396", hash_generated_field = "575F6C3ED9DF00A745593F15FF93C229")

    private  LoadListener mLoadListener;

    /**
     * Creates a new error handler with an empty loader queue.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.103 -0500", hash_original_method = "A9D6B0D7435532871C80AFF391EAC1F3", hash_generated_method = "D3243309923E5918CFAFBA2AA7C0AD41")
    
SslErrorHandlerImpl() {
        mLoaderQueue = new LinkedList<LoadListener>();
        mSslPrefTable = new Bundle();

        // These are used by client facing SslErrorHandlers.
        mOriginHandler = null;
        mLoadListener = null;
    }

    /**
     * Create a new error handler that will be passed to the client.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.105 -0500", hash_original_method = "91EB591AB70C8A379D1426222FA143D7", hash_generated_method = "12E40A961D71F26D2516FD836FFBE829")
    
private SslErrorHandlerImpl(SslErrorHandler origin, LoadListener listener) {
        mOriginHandler = origin;
        mLoadListener = listener;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.100 -0500", hash_original_method = "325914DF32EF22A63CA2688A9A750F18", hash_generated_method = "62D1DC511E386BB2988712BFF66519BE")
    
@Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case HANDLE_RESPONSE:
                LoadListener loader = (LoadListener) msg.obj;
                synchronized (SslErrorHandlerImpl.this) {
                    handleSslErrorResponse(loader, loader.sslError(),
                            msg.arg1 == 1);
                    mLoaderQueue.remove(loader);
                    fastProcessQueuedSslErrors();
                }
                break;
        }
    }

    /**
     * Saves this handler's state into a map.
     * @return True iff succeeds.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.108 -0500", hash_original_method = "D029A1C8EDAAF4B35F26BECE197613A0", hash_generated_method = "D1366F397A526323804F681633521417")
    
synchronized boolean saveState(Bundle outState) {
        boolean success = (outState != null);
        if (success) {
            // TODO?
            outState.putBundle("ssl-error-handler", mSslPrefTable);
        }

        return success;
    }

    /**
     * Restores this handler's state from a map.
     * @return True iff succeeds.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.110 -0500", hash_original_method = "6F02B2C09ACF8BBAEA47573C8A17837E", hash_generated_method = "3866773FC1B57104D50AFF562FA0371C")
    
synchronized boolean restoreState(Bundle inState) {
        boolean success = (inState != null);
        if (success) {
            success = inState.containsKey("ssl-error-handler");
            if (success) {
                mSslPrefTable = inState.getBundle("ssl-error-handler");
            }
        }

        return success;
    }

    /**
     * Clears SSL error preference table.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.112 -0500", hash_original_method = "1C1564A7BC8E1B5AD415E60E6B0CBA09", hash_generated_method = "55B98DA843890C785D4B1641D65B5257")
    
synchronized void clear() {
        mSslPrefTable.clear();
    }

    /**
     * Handles requests from the network stack about whether to proceed with a
     * load given an SSL error(s). We may ask the client what to do, or use a
     * cached response.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.115 -0500", hash_original_method = "C8D7B9DA233B276F8D5E9642BE0FE843", hash_generated_method = "898688DA6CEBCF20A15B69A419EFAFA7")
    
synchronized void handleSslErrorRequest(LoadListener loader) {
        if (DebugFlags.SSL_ERROR_HANDLER) {
            Log.v(LOGTAG, "SslErrorHandler.handleSslErrorRequest(): " +
                  "url=" + loader.url());
        }

        if (!loader.cancelled()) {
            mLoaderQueue.offer(loader);
            if (loader == mLoaderQueue.peek()) {
                fastProcessQueuedSslErrors();
            }
        }
    }

    /**
     * Check the preference table to see if we already have a 'proceed' decision
     * from the client for this host and for an error of equal or greater
     * severity than the supplied error. If so, instruct the loader to proceed
     * and return true. Otherwise return false.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.117 -0500", hash_original_method = "F91D7F8A2853C263C312AB7E69DBEB4B", hash_generated_method = "B39B373E6D4E05912089F1FD3E3FDC6C")
    
synchronized boolean checkSslPrefTable(LoadListener loader,
            SslError error) {
        final String host = loader.host();
        final int primary = error.getPrimaryError();

        if (DebugFlags.SSL_ERROR_HANDLER) {
            assert host != null;
            assert primary != -1;
        }

        if (mSslPrefTable.containsKey(host) && primary <= mSslPrefTable.getInt(host)) {
            if (!loader.cancelled()) {
                loader.handleSslErrorResponse(true);
            }
            return true;
        }
        return false;
    }

    /**
     * Processes queued SSL-error confirmation requests in
     * a tight loop while there is no need to ask the client.
     */
    /* package */@DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.119 -0500", hash_original_method = "04F6EA99CF8E9997D9FE1719C2DB77FD", hash_generated_method = "04F6EA99CF8E9997D9FE1719C2DB77FD")
    
void fastProcessQueuedSslErrors() {
        while (processNextLoader());
    }

    /**
     * Processes the next loader in the queue.
     * @return True iff should proceed to processing the
     * following loader in the queue
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.122 -0500", hash_original_method = "C17562BADC30EBD8B8536D75F1BFCDF6", hash_generated_method = "102FDA96883B8E136769EFD50368B807")
    
private synchronized boolean processNextLoader() {
        LoadListener loader = mLoaderQueue.peek();
        if (loader != null) {
            // if this loader has been cancelled
            if (loader.cancelled()) {
                // go to the following loader in the queue. Make sure this
                // loader has been removed from the queue.
                mLoaderQueue.remove(loader);
                return true;
            }

            SslError error = loader.sslError();

            if (DebugFlags.SSL_ERROR_HANDLER) {
                assert error != null;
            }

            // checkSslPrefTable() will instruct the loader to proceed if we
            // have a cached 'proceed' decision. It does not remove the loader
            // from the queue.
            if (checkSslPrefTable(loader, error)) {
                mLoaderQueue.remove(loader);
                return true;
            }

            // If we can not proceed based on a cached decision, ask the client.
            CallbackProxy proxy = loader.getFrame().getCallbackProxy();
            proxy.onReceivedSslError(new SslErrorHandlerImpl(this, loader), error);
        }

        // the queue must be empty, stop
        return false;
    }

    /**
     * Proceed with this load.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.124 -0500", hash_original_method = "ED6C618278238A667ACAB98E6417F45B", hash_generated_method = "71597F7B3899BE00601EB890117E0B47")
    
public void proceed() {
        mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                HANDLE_RESPONSE, 1, 0, mLoadListener));
    }

    /**
     * Cancel this load and all pending loads for the WebView that had the
     * error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.126 -0500", hash_original_method = "12C4CCCD01DBAE6BF230314E9D5755CB", hash_generated_method = "5E8DFC3B6C3D67D7793D9B0AC2C81A2F")
    
public void cancel() {
        mOriginHandler.sendMessage(mOriginHandler.obtainMessage(
                HANDLE_RESPONSE, 0, 0, mLoadListener));
    }

    /**
     * Handles the response from the client about whether to proceed with this
     * load. We save the response to be re-used in the future.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.129 -0500", hash_original_method = "5796F22078D6113D133FA1EE0019F75A", hash_generated_method = "FEA30C8A32DB3EAC28E626363CBC48A0")
    
synchronized void handleSslErrorResponse(LoadListener loader,
            SslError error, boolean proceed) {
        if (DebugFlags.SSL_ERROR_HANDLER) {
            assert loader != null;
            assert error != null;
        }

        if (DebugFlags.SSL_ERROR_HANDLER) {
            Log.v(LOGTAG, "SslErrorHandler.handleSslErrorResponse():"
                  + " proceed: " + proceed
                  + " url:" + loader.url());
        }

        if (!loader.cancelled()) {
            if (proceed) {
                // Update the SSL error preference table
                int primary = error.getPrimaryError();
                String host = loader.host();

                if (DebugFlags.SSL_ERROR_HANDLER) {
                    assert host != null;
                    assert primary != -1;
                }
                boolean hasKey = mSslPrefTable.containsKey(host);
                if (!hasKey || primary > mSslPrefTable.getInt(host)) {
                    mSslPrefTable.putInt(host, primary);
                }
            }
            loader.handleSslErrorResponse(proceed);
        }
    }
}

