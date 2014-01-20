package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.LinkedList;

import android.os.Message;

class HttpAuthHandlerImpl extends HttpAuthHandler {

    /**
     * Informs the WebView of a new set of credentials.
     * @hide Pending API council review
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.158 -0500", hash_original_method = "4B44553A53A441875D6B8FA3F401ACD7", hash_generated_method = "90E61E8A6A5B7EB05B10B4E4B65BA202")
    
public static void onReceivedCredentials(LoadListener loader,
            String host, String realm, String username, String password) {
        CallbackProxy proxy = loader.getFrame().getCallbackProxy();
        proxy.onReceivedHttpAuthCredentials(host, realm, username, password);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.115 -0500", hash_original_field = "B8F296222D99B13B57A30F4500AF7F3D", hash_generated_field = "F098064C2753AB544D48EBBEF82B0BA4")

    private static final String LOGTAG = "network";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.122 -0500", hash_original_field = "E9D881E02215A8BBF09D194599456251", hash_generated_field = "307137EC37CD63DF6594FE42EBE00E97")

    private static final int AUTH_PROCEED = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.124 -0500", hash_original_field = "045152497BFA4A982403F0B8726255D1", hash_generated_field = "F401DC0DF68B8C3DD6861879E588C39D")

    private static final int AUTH_CANCEL = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.118 -0500", hash_original_field = "C72A50F72B23F13DD3F117A7D73CF25A", hash_generated_field = "E0FAA2A6C497494B58133B8740B95CC3")

    private Network mNetwork;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.120 -0500", hash_original_field = "3716B531CEC47234F4A7CC60510C3140", hash_generated_field = "1DFA7AE1BD952C18E1D76D9BAFCEAA92")

    private LinkedList<LoadListener> mLoaderQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.126 -0500", hash_original_field = "FBA1E121D7E2FF697782F001BE51E87B", hash_generated_field = "D468A9162853AFD45B8189DDD2C42C6C")

    // onReceivedHttpAuthRequest(). We can't use a single Boolean object for
    // both the lock and the state, because Boolean is immutable.
    Object mRequestInFlightLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.128 -0500", hash_original_field = "D45D4B46CC19E8188195D2A11D8D61D7", hash_generated_field = "D45D4B46CC19E8188195D2A11D8D61D7")

    boolean mRequestInFlight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.129 -0500", hash_original_field = "F6C0B2A92BAD484AE3E9DE7409D6C7A8", hash_generated_field = "F6C0B2A92BAD484AE3E9DE7409D6C7A8")

    String mUsername;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.132 -0500", hash_original_field = "6E680D0312272F1C50F2E99ACBEA882B", hash_generated_field = "6E680D0312272F1C50F2E99ACBEA882B")

    String mPassword;

    /**
     * Creates a new HTTP authentication handler with an empty
     * loader queue
     *
     * @param network The parent network object
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.134 -0500", hash_original_method = "DD7F5BEFB1D050713E2D554BF9DDD08D", hash_generated_method = "DD7F5BEFB1D050713E2D554BF9DDD08D")
    
HttpAuthHandlerImpl(Network network) {
        mNetwork = network;
        mLoaderQueue = new LinkedList<LoadListener>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.137 -0500", hash_original_method = "92EA526117BA58D828A346DC2F14E6C7", hash_generated_method = "BE888BC2460B85EAE15CD490B47AAED3")
    
@Override
    public void handleMessage(Message msg) {
        LoadListener loader = null;
        synchronized (mLoaderQueue) {
            loader = mLoaderQueue.poll();
        }
        assert(loader.isSynchronous() == false);

        switch (msg.what) {
            case AUTH_PROCEED:
                String username = msg.getData().getString("username");
                String password = msg.getData().getString("password");

                loader.handleAuthResponse(username, password);
                break;

            case AUTH_CANCEL:
                loader.handleAuthResponse(null, null);
                break;
        }

        processNextLoader();
    }

    /**
     * Helper method used to unblock handleAuthRequest(), which in the case of a
     * synchronous request will wait for proxy.onReceivedHttpAuthRequest() to
     * call back to either proceed() or cancel().
     *
     * @param username The username to use for authentication
     * @param password The password to use for authentication
     * @return True if the request is synchronous and handleAuthRequest() has
     * been unblocked
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.139 -0500", hash_original_method = "633BAC1354102784355BBDC241836385", hash_generated_method = "A13785571FD4CA7158438247806281C0")
    
private boolean handleResponseForSynchronousRequest(String username, String password) {
        LoadListener loader = null;
        synchronized (mLoaderQueue) {
            loader = mLoaderQueue.peek();
        }
        if (loader.isSynchronous()) {
            mUsername = username;
            mPassword = password;
            return true;
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.142 -0500", hash_original_method = "D0913A95E2E0984BDC30D85F1A6DD6EF", hash_generated_method = "20E0AF4EC1044960CFCE5137C7502180")
    
private void signalRequestComplete() {
        synchronized (mRequestInFlightLock) {
            assert(mRequestInFlight);
            mRequestInFlight = false;
            mRequestInFlightLock.notify();
        }
    }

    /**
     * Proceed with the authorization with the given credentials
     *
     * May be called on the UI thread, rather than the WebCore thread.
     *
     * @param username The username to use for authentication
     * @param password The password to use for authentication
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.144 -0500", hash_original_method = "3FC26787C5211E44D8B34B9447EFC8D6", hash_generated_method = "B838F3BEB517760673229A9E3A0C82D7")
    
public void proceed(String username, String password) {
        if (handleResponseForSynchronousRequest(username, password)) {
            signalRequestComplete();
            return;
        }
        Message msg = obtainMessage(AUTH_PROCEED);
        msg.getData().putString("username", username);
        msg.getData().putString("password", password);
        sendMessage(msg);
        signalRequestComplete();
    }

    /**
     * Cancel the authorization request
     *
     * May be called on the UI thread, rather than the WebCore thread.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.146 -0500", hash_original_method = "1C78A3648C04874A6B02C5BA2CA8304A", hash_generated_method = "8D68F5485B633B11ECD1D0A455A715D8")
    
public void cancel() {
        if (handleResponseForSynchronousRequest(null, null)) {
            signalRequestComplete();
            return;
        }
        sendMessage(obtainMessage(AUTH_CANCEL));
        signalRequestComplete();
    }

    /**
     * @return True if we can use user credentials on record
     * (ie, if we did not fail trying to use them last time)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.149 -0500", hash_original_method = "0DB7D7C368B555F88B0E01139A6FA13A", hash_generated_method = "4BB912EDC4EA19123D41B3D471D061E8")
    
public boolean useHttpAuthUsernamePassword() {
        LoadListener loader = null;
        synchronized (mLoaderQueue) {
            loader = mLoaderQueue.peek();
        }
        if (loader != null) {
            return !loader.authCredentialsInvalid();
        }

        return false;
    }

    /**
     * Enqueues the loader, if the loader is the only element
     * in the queue, starts processing the loader
     *
     * @param loader The loader that resulted in this http
     * authentication request
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.151 -0500", hash_original_method = "69FA3518C12F8613622C8FCCAB6F2AF7", hash_generated_method = "402483C5CBEEB73E864556E7BE42590F")
    
void handleAuthRequest(LoadListener loader) {
        // The call to proxy.onReceivedHttpAuthRequest() may be asynchronous. If
        // the request is synchronous, we must block here until we have a
        // response.
        if (loader.isSynchronous()) {
            // If there's a request in flight, wait for it to complete. The
            // response will queue a message on this thread.
            waitForRequestToComplete();
            // Make a request to the proxy for this request, jumping the queue.
            // We use the queue so that the loader is present in
            // useHttpAuthUsernamePassword().
            synchronized (mLoaderQueue) {
                mLoaderQueue.addFirst(loader);
            }
            processNextLoader();
            // Wait for this request to complete.
            waitForRequestToComplete();
            // Pop the loader from the queue.
            synchronized (mLoaderQueue) {
                assert(mLoaderQueue.peek() == loader);
                mLoaderQueue.poll();
            }
            // Call back.
            loader.handleAuthResponse(mUsername, mPassword);
            // The message queued by the response from the last asynchronous
            // request, if present, will start the next request.
            return;
        }

        boolean processNext = false;

        synchronized (mLoaderQueue) {
            mLoaderQueue.offer(loader);
            processNext =
                (mLoaderQueue.size() == 1);
        }

        if (processNext) {
            processNextLoader();
        }
    }

    /**
     * Wait for the request in flight, if any, to complete
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.153 -0500", hash_original_method = "886E13332A9209796D68B57BD4AA101D", hash_generated_method = "D2CF3E934D1AFF5F16088D62551FCDBD")
    
private void waitForRequestToComplete() {
        synchronized (mRequestInFlightLock) {
            while (mRequestInFlight) {
                try {
                    mRequestInFlightLock.wait();
                } catch(InterruptedException e) {
                    Log.e(LOGTAG, "Interrupted while waiting for request to complete");
                }
            }
        }
    }

    /**
     * Process the next loader in the queue (helper method)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.156 -0500", hash_original_method = "915750F5CD3DA8563236F4856CDF7624", hash_generated_method = "9BD8A92E1B6E56BFF9D1B998641A3453")
    
private void processNextLoader() {
        LoadListener loader = null;
        synchronized (mLoaderQueue) {
            loader = mLoaderQueue.peek();
        }
        if (loader != null) {
            synchronized (mRequestInFlightLock) {
                assert(mRequestInFlight == false);
                mRequestInFlight = true;
            }

            CallbackProxy proxy = loader.getFrame().getCallbackProxy();

            String hostname = loader.proxyAuthenticate() ?
                mNetwork.getProxyHostname() : loader.host();

            String realm = loader.realm();

            proxy.onReceivedHttpAuthRequest(this, hostname, realm);
        }
    }
}

