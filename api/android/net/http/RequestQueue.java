package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

import org.apache.http.HttpHost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.WebAddress;
import android.util.Log;

public class RequestQueue implements RequestFeeder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.229 -0500", hash_original_field = "3B336A0182CCCB8357C14CA1832B3D52", hash_generated_field = "37BB035DE4DBFD177A6ADC5B8C105D95")

    private static final int CONNECTION_COUNT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.216 -0500", hash_original_field = "CC5B30229A6F0F76FACE40C38D357746", hash_generated_field = "1758DBA360E4E3B600ADDDCE5E66E218")

    private  LinkedHashMap<HttpHost, LinkedList<Request>> mPending;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.218 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.220 -0500", hash_original_field = "DD9A4A5CCD55A305148DD79BD0EEA840", hash_generated_field = "7E2C9159191DF9FFA295FC8E90223677")

    private  ActivePool mActivePool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.222 -0500", hash_original_field = "CA1A36F4D12176AE64160855BE8A2913", hash_generated_field = "7F6315533CCAF46DEA5C0B5CCAC3EBAB")

    private  ConnectivityManager mConnectivityManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.224 -0500", hash_original_field = "D1D639C5596FCF5BCCB2D8DE2062557E", hash_generated_field = "99742757777505E14871D3515FDC7109")

    private HttpHost mProxyHost = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.227 -0500", hash_original_field = "BBC3BB7DCD4ABB1C5FDFA673C3A087C1", hash_generated_field = "EAF3975B1E21B046C1D30C80F39B0ACA")

    private BroadcastReceiver mProxyChangeReceiver;

    /**
     * A RequestQueue class instance maintains a set of queued
     * requests.  It orders them, makes the requests against HTTP
     * servers, and makes callbacks to supplied eventHandlers as data
     * is read.  It supports request prioritization, connection reuse
     * and pipelining.
     *
     * @param context application context
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.274 -0500", hash_original_method = "7E78DB3349CECCEABE79A47BDE45F2E4", hash_generated_method = "9B988754EC24B3F7C80BCEEDCF39E762")
    
public RequestQueue(Context context) {
        this(context, CONNECTION_COUNT);
    }

    /**
     * A RequestQueue class instance maintains a set of queued
     * requests.  It orders them, makes the requests against HTTP
     * servers, and makes callbacks to supplied eventHandlers as data
     * is read.  It supports request prioritization, connection reuse
     * and pipelining.
     *
     * @param context application context
     * @param connectionCount The number of simultaneous connections 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.277 -0500", hash_original_method = "A7CEC9D1667C71B6ADD3849E74F98CAD", hash_generated_method = "7824C06A57E6DCD8D51C71251CBFC6DE")
    
public RequestQueue(Context context, int connectionCount) {
        mContext = context;

        mPending = new LinkedHashMap<HttpHost, LinkedList<Request>>(32);

        mActivePool = new ActivePool(connectionCount);
        mActivePool.startup();

        mConnectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.853 -0400", hash_original_method = "192F6D29BBECFA47E09E7D8D48EF8859", hash_generated_method = "2E4A107819364196942A449FCCD44C9A")
    public synchronized void enablePlatformNotifications() {
        if(HttpLog.LOGV)        
        HttpLog.v("RequestQueue.enablePlatformNotifications() network");
        if(mProxyChangeReceiver == null)        
        {
            mProxyChangeReceiver =
                    new BroadcastReceiver() {
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.280 -0500", hash_original_method = "3CB2B7FAEA507C11972A385D868E1E52", hash_generated_method = "C33F7949724EF2C6F408910899572C6C")
                
@Override
                        public void onReceive(Context ctx, Intent intent) {
                            setProxyConfig();
                        }
};
            mContext.registerReceiver(mProxyChangeReceiver,
                                      new IntentFilter(Proxy.PROXY_CHANGE_ACTION));
        } //End block
        setProxyConfig();
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) HttpLog.v("RequestQueue.enablePlatformNotifications() network");
        //if (mProxyChangeReceiver == null) {
            //mProxyChangeReceiver =
                    //new BroadcastReceiver() {
                        //@Override
                        //public void onReceive(Context ctx, Intent intent) {
                            //setProxyConfig();
                        //}
                    //};
            //mContext.registerReceiver(mProxyChangeReceiver,
                                      //new IntentFilter(Proxy.PROXY_CHANGE_ACTION));
        //}
        //setProxyConfig();
    }

    /**
     * If platform notifications have been enabled, call this method
     * to disable before destroying RequestQueue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.285 -0500", hash_original_method = "B133918A77AADD577D84EC4FDA196DDC", hash_generated_method = "9CC67D9F424BC4790695BD844B065BAE")
    
public synchronized void disablePlatformNotifications() {
        if (HttpLog.LOGV) HttpLog.v("RequestQueue.disablePlatformNotifications() network");

        if (mProxyChangeReceiver != null) {
            mContext.unregisterReceiver(mProxyChangeReceiver);
            mProxyChangeReceiver = null;
        }
    }

    /**
     * Because our IntentReceiver can run within a different thread,
     * synchronize setting the proxy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.287 -0500", hash_original_method = "381746B4CF404D7B9FDB43420AECD746", hash_generated_method = "401A74B2C59723BB96BCE7B323DDB294")
    
private synchronized void setProxyConfig() {
        NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
        if (info != null && info.getType() == ConnectivityManager.TYPE_WIFI) {
            mProxyHost = null;
        } else {
            String host = Proxy.getHost(mContext);
            if (HttpLog.LOGV) HttpLog.v("RequestQueue.setProxyConfig " + host);
            if (host == null) {
                mProxyHost = null;
            } else {
                mActivePool.disablePersistence();
                mProxyHost = new HttpHost(host, Proxy.getPort(mContext), "http");
            }
        }
    }

    /**
     * used by webkit
     * @return proxy host if set, null otherwise
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.289 -0500", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "4BC88B0C4F8420EA46933C51803C4057")
    
public HttpHost getProxyHost() {
        return mProxyHost;
    }

    /**
     * Queues an HTTP request
     * @param url The url to load.
     * @param method "GET" or "POST."
     * @param headers A hashmap of http headers.
     * @param eventHandler The event handler for handling returned
     * data.  Callbacks will be made on the supplied instance.
     * @param bodyProvider InputStream providing HTTP body, null if none
     * @param bodyLength length of body, must be 0 if bodyProvider is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.292 -0500", hash_original_method = "D4465F27265450A81D8D5C54F66A3578", hash_generated_method = "3A6E42FB1521BD32472E1B8D14D5F154")
    
public RequestHandle queueRequest(
            String url, String method,
            Map<String, String> headers, EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        WebAddress uri = new WebAddress(url);
        return queueRequest(url, uri, method, headers, eventHandler,
                            bodyProvider, bodyLength);
    }

    /**
     * Queues an HTTP request
     * @param url The url to load.
     * @param uri The uri of the url to load.
     * @param method "GET" or "POST."
     * @param headers A hashmap of http headers.
     * @param eventHandler The event handler for handling returned
     * data.  Callbacks will be made on the supplied instance.
     * @param bodyProvider InputStream providing HTTP body, null if none
     * @param bodyLength length of body, must be 0 if bodyProvider is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.295 -0500", hash_original_method = "5EE74AB0AE90D0DA727E01E7B767B670", hash_generated_method = "B8937CF203BE98232FA77F52D93F9C1D")
    
public RequestHandle queueRequest(
            String url, WebAddress uri, String method, Map<String, String> headers,
            EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {

        if (HttpLog.LOGV) HttpLog.v("RequestQueue.queueRequest " + uri);

        // Ensure there is an eventHandler set
        if (eventHandler == null) {
            eventHandler = new LoggingEventHandler();
        }

        /* Create and queue request */
        Request req;
        HttpHost httpHost = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());

        // set up request
        req = new Request(method, httpHost, mProxyHost, uri.getPath(), bodyProvider,
                          bodyLength, eventHandler, headers);

        queueRequest(req, false);

        mActivePool.mTotalRequest++;

        // dump();
        mActivePool.startConnectionThread();

        return new RequestHandle(
                this, url, uri, method, headers, bodyProvider, bodyLength,
                req);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.313 -0500", hash_original_method = "5ADB9D7A6CBFB38DBDB876B33452D400", hash_generated_method = "CB1B5F93CAE15BABBDB2E8095587B0BC")
    
public RequestHandle queueSynchronousRequest(String url, WebAddress uri,
            String method, Map<String, String> headers,
            EventHandler eventHandler, InputStream bodyProvider,
            int bodyLength) {
        if (HttpLog.LOGV) {
            HttpLog.v("RequestQueue.dispatchSynchronousRequest " + uri);
        }

        HttpHost host = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());

        Request req = new Request(method, host, mProxyHost, uri.getPath(),
                bodyProvider, bodyLength, eventHandler, headers);

        // Open a new connection that uses our special RequestFeeder
        // implementation.
        host = determineHost(host);
        Connection conn = Connection.getConnection(mContext, host, mProxyHost,
                new SyncFeeder());

        // TODO: I would like to process the request here but LoadListener
        // needs a RequestHandle to process some messages.
        return new RequestHandle(this, url, uri, method, headers, bodyProvider,
                bodyLength, req, conn);

    }

    // Chooses between the proxy and the request's host.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.316 -0500", hash_original_method = "19FC52B8DC895C49DAE0ECA4EB6CA639", hash_generated_method = "1FB9EE31513A97342E093BC26F601324")
    
private HttpHost determineHost(HttpHost host) {
        // There used to be a comment in ConnectionThread about t-mob's proxy
        // being really bad about https. But, HttpsConnection actually looks
        // for a proxy and connects through it anyway. I think that this check
        // is still valid because if a site is https, we will use
        // HttpsConnection rather than HttpConnection if the proxy address is
        // not secure.
        return (mProxyHost == null || "https".equals(host.getSchemeName()))
                ? host : mProxyHost;
    }

    /**
     * @return true iff there are any non-active requests pending
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.318 -0500", hash_original_method = "EFE82EE341DC6BD22EFE3AAE27ABB231", hash_generated_method = "4731BE1B4112D1C43085365BEE4FB6A3")
    
synchronized boolean requestsPending() {
        return !mPending.isEmpty();
    }

    /**
     * debug tool: prints request queue to log
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.321 -0500", hash_original_method = "5E944A5C3AFB2FB0842C37E33C83D8D2", hash_generated_method = "F8482D0B2DB6C94B3879481A48D509CB")
    
synchronized void dump() {
        HttpLog.v("dump()");
        StringBuilder dump = new StringBuilder();
        int count = 0;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter;

        // mActivePool.log(dump);

        if (!mPending.isEmpty()) {
            iter = mPending.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<HttpHost, LinkedList<Request>> entry = iter.next();
                String hostName = entry.getKey().getHostName();
                StringBuilder line = new StringBuilder("p" + count++ + " " + hostName + " ");

                LinkedList<Request> reqList = entry.getValue();
                ListIterator reqIter = reqList.listIterator(0);
                while (iter.hasNext()) {
                    Request request = (Request)iter.next();
                    line.append(request + " ");
                }
                dump.append(line);
                dump.append("\n");
            }
        }
        HttpLog.v(dump.toString());
    }

    /*
     * RequestFeeder implementation
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.323 -0500", hash_original_method = "8F04B443A564D50EFFE076AEA97295A7", hash_generated_method = "C5662E3D0008E6019496C6C0594DABDB")
    
public synchronized Request getRequest() {
        Request ret = null;

        if (!mPending.isEmpty()) {
            ret = removeFirst(mPending);
        }
        if (HttpLog.LOGV) HttpLog.v("RequestQueue.getRequest() => " + ret);
        return ret;
    }

    /**
     * @return a request for given host if possible
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.326 -0500", hash_original_method = "871E1F4E9BD2BA7BA6F72CE2CEEFAC66", hash_generated_method = "68016E68CF819C1B2617E31465E380F1")
    
public synchronized Request getRequest(HttpHost host) {
        Request ret = null;

        if (mPending.containsKey(host)) {
            LinkedList<Request> reqList = mPending.get(host);
            ret = reqList.removeFirst();
            if (reqList.isEmpty()) {
                mPending.remove(host);
            }
        }
        if (HttpLog.LOGV) HttpLog.v("RequestQueue.getRequest(" + host + ") => " + ret);
        return ret;
    }

    /**
     * @return true if a request for this host is available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.328 -0500", hash_original_method = "A6996F44457236E27DB2C5C55302FCBE", hash_generated_method = "9F2D86667C70BE0CC819723EB92B8E24")
    
public synchronized boolean haveRequest(HttpHost host) {
        return mPending.containsKey(host);
    }

    /**
     * Put request back on head of queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.330 -0500", hash_original_method = "5DF1C437E9ED58A9D928A0798F1B9425", hash_generated_method = "CC7A054AA0A68649C978C241FCBC25A6")
    
public void requeueRequest(Request request) {
        queueRequest(request, true);
    }

    /**
     * This must be called to cleanly shutdown RequestQueue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.332 -0500", hash_original_method = "36DEBCDEC4EFDB8CF8346CFD81066CDA", hash_generated_method = "BF70AD9076074D5BD40DC7300E29BE75")
    
public void shutdown() {
        mActivePool.shutdown();
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.335 -0500", hash_original_method = "99743D8700F7CD0272109FAA55D49D1A", hash_generated_method = "352B9F00E36246627B621AEAD7D6FEC1")
    
protected synchronized void queueRequest(Request request, boolean head) {
        HttpHost host = request.mProxyHost == null ? request.mHost : request.mProxyHost;
        LinkedList<Request> reqList;
        if (mPending.containsKey(host)) {
            reqList = mPending.get(host);
        } else {
            reqList = new LinkedList<Request>();
            mPending.put(host, reqList);
        }
        if (head) {
            reqList.addFirst(request);
        } else {
            reqList.add(request);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.337 -0500", hash_original_method = "D615BD22372BF27837008A0B674B3672", hash_generated_method = "54286DD993225353067BB88F7051F1F0")
    
public void startTiming() {
        mActivePool.startTiming();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.339 -0500", hash_original_method = "93BD6698DCB4A99EC2C52A706270C860", hash_generated_method = "4C4409DEDF51FBF2C545B06B5245AF82")
    
public void stopTiming() {
        mActivePool.stopTiming();
    }
    
    class ActivePool implements ConnectionManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.232 -0500", hash_original_field = "A911064E545F525658232640AFA7D0B9", hash_generated_field = "A911064E545F525658232640AFA7D0B9")

        ConnectionThread[] mThreads;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.234 -0500", hash_original_field = "448266124930497935AABDA6EA3530AA", hash_generated_field = "448266124930497935AABDA6EA3530AA")

        IdleCache mIdleCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.236 -0500", hash_original_field = "5D14188A729D4F2635BB53973FC26F5B", hash_generated_field = "04EBA439DE54BE9E4E88BA35E3F14E1F")

        private int mTotalRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.238 -0500", hash_original_field = "29B740AAB1531020789DC6ED7C636BBB", hash_generated_field = "75F51D982E39DA7109E095FB57E24560")

        private int mTotalConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.240 -0500", hash_original_field = "51B542A005E95DBCFE4B0C39F78FEBF7", hash_generated_field = "3B7FD818552FF5D0D780F585667ED47F")

        private int mConnectionCount;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.244 -0500", hash_original_method = "EC748BA333F005CC68E7979CEA362A8D", hash_generated_method = "EC748BA333F005CC68E7979CEA362A8D")
        
ActivePool(int connectionCount) {
            mIdleCache = new IdleCache();
            mConnectionCount = connectionCount;
            mThreads = new ConnectionThread[mConnectionCount];

            for (int i = 0; i < mConnectionCount; i++) {
                mThreads[i] = new ConnectionThread(
                        mContext, i, this, RequestQueue.this);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.246 -0500", hash_original_method = "1219F5054D15C8BA85E10250B0465A48", hash_generated_method = "1219F5054D15C8BA85E10250B0465A48")
        
void startup() {
            for (int i = 0; i < mConnectionCount; i++) {
                mThreads[i].start();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.248 -0500", hash_original_method = "3DBC0C51372089E9236025C3C2E89B00", hash_generated_method = "3DBC0C51372089E9236025C3C2E89B00")
        
void shutdown() {
            for (int i = 0; i < mConnectionCount; i++) {
                mThreads[i].requestStop();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.250 -0500", hash_original_method = "918E02281CDA2E4E4F9A4B76A9977FCD", hash_generated_method = "918E02281CDA2E4E4F9A4B76A9977FCD")
        
void startConnectionThread() {
            synchronized (RequestQueue.this) {
                RequestQueue.this.notify();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.253 -0500", hash_original_method = "D2A094DDB6185336258EAA22554B8B48", hash_generated_method = "D95F1D6CAAAB43B5AFB93B1D0A546232")
        
public void startTiming() {
            for (int i = 0; i < mConnectionCount; i++) {
                ConnectionThread rt = mThreads[i];
                rt.mCurrentThreadTime = -1;
                rt.mTotalThreadTime = 0;
            }
            mTotalRequest = 0;
            mTotalConnection = 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.255 -0500", hash_original_method = "24B30AFE4309F082BC585F8C48779E08", hash_generated_method = "FAB46EE208B5B4B4942B4BBF57426E64")
        
public void stopTiming() {
            int totalTime = 0;
            for (int i = 0; i < mConnectionCount; i++) {
                ConnectionThread rt = mThreads[i];
                if (rt.mCurrentThreadTime != -1) {
                    totalTime += rt.mTotalThreadTime;
                }
                rt.mCurrentThreadTime = 0;
            }
            Log.d("Http", "Http thread used " + totalTime + " ms " + " for "
                    + mTotalRequest + " requests and " + mTotalConnection
                    + " new connections");
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.258 -0500", hash_original_method = "D3242BE060800C50D95BDC78717491BA", hash_generated_method = "D3242BE060800C50D95BDC78717491BA")
        
void logState() {
            StringBuilder dump = new StringBuilder();
            for (int i = 0; i < mConnectionCount; i++) {
                dump.append(mThreads[i] + "\n");
            }
            HttpLog.v(dump.toString());
        }

        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.260 -0500", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "4BC88B0C4F8420EA46933C51803C4057")
        
public HttpHost getProxyHost() {
            return mProxyHost;
        }

        /**
         * Turns off persistence on all live connections
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.262 -0500", hash_original_method = "0E1F656010AA811F93614A0AAB8C062E", hash_generated_method = "0E1F656010AA811F93614A0AAB8C062E")
        
void disablePersistence() {
            for (int i = 0; i < mConnectionCount; i++) {
                Connection connection = mThreads[i].mConnection;
                if (connection != null) connection.setCanPersist(false);
            }
            mIdleCache.clear();
        }

        /* Linear lookup -- okay for small thread counts.  Might use
           private HashMap<HttpHost, LinkedList<ConnectionThread>> mActiveMap;
           if this turns out to be a hotspot */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.264 -0500", hash_original_method = "4350BDA0BFA960DC6ECB5B267907B720", hash_generated_method = "4350BDA0BFA960DC6ECB5B267907B720")
        
ConnectionThread getThread(HttpHost host) {
            synchronized(RequestQueue.this) {
                for (int i = 0; i < mThreads.length; i++) {
                    ConnectionThread ct = mThreads[i];
                    Connection connection = ct.mConnection;
                    if (connection != null && connection.mHost.equals(host)) {
                        return ct;
                    }
                }
            }
            return null;
        }

        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.266 -0500", hash_original_method = "FFEAD5D96A31C5526086E61D15C11F62", hash_generated_method = "5ECF59203E07C45B00F91B0521BC4B5D")
        
public Connection getConnection(Context context, HttpHost host) {
            host = RequestQueue.this.determineHost(host);
            Connection con = mIdleCache.getConnection(host);
            if (con == null) {
                mTotalConnection++;
                con = Connection.getConnection(mContext, host, mProxyHost,
                        RequestQueue.this);
            }
            return con;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.268 -0500", hash_original_method = "3E0E4C6417BA7E6D1B1D779C38F1AA9A", hash_generated_method = "C254158E655D6CCB04C5662DF25E1C10")
        
public boolean recycleConnection(Connection connection) {
            return mIdleCache.cacheConnection(connection.getHost(), connection);
        }
        
    }
    
    private static class SyncFeeder implements RequestFeeder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.297 -0500", hash_original_field = "480419B6BBB9A26A6DD8401352CF0FEE", hash_generated_field = "CD1358C024850E376AE84FBA2FC6F2A1")

        // requeued into the RequestFeeder.
        private Request mRequest;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.300 -0500", hash_original_method = "4463F8298E503AEAFD22486DF3099826", hash_generated_method = "4463F8298E503AEAFD22486DF3099826")
        
SyncFeeder() {
        }
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.303 -0500", hash_original_method = "E0C38BA5AF5E9B7363BEA9E204F697F3", hash_generated_method = "C74EDD87A503CBBE7FA9739CE06E1684")
        
public Request getRequest() {
            Request r = mRequest;
            mRequest = null;
            return r;
        }
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.305 -0500", hash_original_method = "DE8B4E1CA9B86F476AFDBAF1FF7FD442", hash_generated_method = "8784B9E19CB677C96570406E17C21CA8")
        
public Request getRequest(HttpHost host) {
            return getRequest();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.307 -0500", hash_original_method = "30BE3F23DCE5F30BFE4C540BF8AE4D20", hash_generated_method = "E010020BF5DDEF5F7A71F33D94A57257")
        
public boolean haveRequest(HttpHost host) {
            return mRequest != null;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.309 -0500", hash_original_method = "D0AA652C1F1A28EE12BADC892C348224", hash_generated_method = "29897C1614521FB8AA91A4D3E1AAEE23")
        
public void requeueRequest(Request r) {
            mRequest = r;
        }
        
    }
    
    interface ConnectionManager {
        HttpHost getProxyHost();
        Connection getConnection(Context context, HttpHost host);
        boolean recycleConnection(Connection connection);
    }

    /* helper */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.341 -0500", hash_original_method = "F363C5354CB9B81208E7FAC033526D24", hash_generated_method = "815D37DEB1C4D2F5ECFD6CB9AC1080AB")
    
private Request removeFirst(LinkedHashMap<HttpHost, LinkedList<Request>> requestQueue) {
        Request ret = null;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter = requestQueue.entrySet().iterator();
        if (iter.hasNext()) {
            Map.Entry<HttpHost, LinkedList<Request>> entry = iter.next();
            LinkedList<Request> reqList = entry.getValue();
            ret = reqList.removeFirst();
            if (reqList.isEmpty()) {
                requestQueue.remove(entry.getKey());
            }
        }
        return ret;
    }
}

