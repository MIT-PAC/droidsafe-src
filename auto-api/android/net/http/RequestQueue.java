package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.WebAddress;
import android.os.Handler;
import android.os.Message;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import org.apache.http.HttpHost;

public class RequestQueue implements RequestFeeder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.702 -0400", hash_original_field = "8673F7F02EF7B3B9DEB1A224A23932BB", hash_generated_field = "1758DBA360E4E3B600ADDDCE5E66E218")

    private LinkedHashMap<HttpHost, LinkedList<Request>> mPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.702 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.702 -0400", hash_original_field = "9F8C80ADD03363D444D5DD543187AC5D", hash_generated_field = "7E2C9159191DF9FFA295FC8E90223677")

    private ActivePool mActivePool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.702 -0400", hash_original_field = "EB205FDB4F9378FA441222BF6F7ABE71", hash_generated_field = "7F6315533CCAF46DEA5C0B5CCAC3EBAB")

    private ConnectivityManager mConnectivityManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.702 -0400", hash_original_field = "4E55F1B55468F140FC44ACD1C350CF05", hash_generated_field = "99742757777505E14871D3515FDC7109")

    private HttpHost mProxyHost = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.703 -0400", hash_original_field = "6316EE14E7E9EE85C930ED2A15CC2BB7", hash_generated_field = "EAF3975B1E21B046C1D30C80F39B0ACA")

    private BroadcastReceiver mProxyChangeReceiver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.703 -0400", hash_original_method = "7E78DB3349CECCEABE79A47BDE45F2E4", hash_generated_method = "DDF29BFAAE46044224D6EEEA2BBC483F")
    public  RequestQueue(Context context) {
        this(context, CONNECTION_COUNT);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.722 -0400", hash_original_method = "A7CEC9D1667C71B6ADD3849E74F98CAD", hash_generated_method = "C4F46365E49B566B692619AA850CA5BF")
    public  RequestQueue(Context context, int connectionCount) {
        mContext = context;
        mPending = new LinkedHashMap<HttpHost, LinkedList<Request>>(32);
        mActivePool = new ActivePool(connectionCount);
        mActivePool.startup();
        mConnectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // ---------- Original Method ----------
        //mContext = context;
        //mPending = new LinkedHashMap<HttpHost, LinkedList<Request>>(32);
        //mActivePool = new ActivePool(connectionCount);
        //mActivePool.startup();
        //mConnectivityManager = (ConnectivityManager)
                //context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.725 -0400", hash_original_method = "192F6D29BBECFA47E09E7D8D48EF8859", hash_generated_method = "6AC866403343E90444F2A8B106C0CDB6")
    public synchronized void enablePlatformNotifications() {
        HttpLog.v("RequestQueue.enablePlatformNotifications() network");
        {
            mProxyChangeReceiver =
                    new BroadcastReceiver() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.724 -0400", hash_original_method = "3CB2B7FAEA507C11972A385D868E1E52", hash_generated_method = "50705C8A9D00ADEEB2A67E3959DD9EA8")
                @Override
                public void onReceive(Context ctx, Intent intent) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    setProxyConfig();
                    addTaint(ctx.getTaint());
                    addTaint(intent.getTaint());
                    // ---------- Original Method ----------
                    //setProxyConfig();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.726 -0400", hash_original_method = "B133918A77AADD577D84EC4FDA196DDC", hash_generated_method = "A37E9AEDA43DF86F46832B3F924735F1")
    public synchronized void disablePlatformNotifications() {
        HttpLog.v("RequestQueue.disablePlatformNotifications() network");
        {
            mContext.unregisterReceiver(mProxyChangeReceiver);
            mProxyChangeReceiver = null;
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) HttpLog.v("RequestQueue.disablePlatformNotifications() network");
        //if (mProxyChangeReceiver != null) {
            //mContext.unregisterReceiver(mProxyChangeReceiver);
            //mProxyChangeReceiver = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.741 -0400", hash_original_method = "381746B4CF404D7B9FDB43420AECD746", hash_generated_method = "1BEB87335E4FE809447D1221A1BA9B8C")
    private synchronized void setProxyConfig() {
        NetworkInfo info;
        info = mConnectivityManager.getActiveNetworkInfo();
        {
            boolean var24FBA6C722421408BD9DC8A74F9723F7_962505943 = (info != null && info.getType() == ConnectivityManager.TYPE_WIFI);
            {
                mProxyHost = null;
            } //End block
            {
                String host;
                host = Proxy.getHost(mContext);
                HttpLog.v("RequestQueue.setProxyConfig " + host);
                {
                    mProxyHost = null;
                } //End block
                {
                    mActivePool.disablePersistence();
                    mProxyHost = new HttpHost(host, Proxy.getPort(mContext), "http");
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
        //if (info != null && info.getType() == ConnectivityManager.TYPE_WIFI) {
            //mProxyHost = null;
        //} else {
            //String host = Proxy.getHost(mContext);
            //if (HttpLog.LOGV) HttpLog.v("RequestQueue.setProxyConfig " + host);
            //if (host == null) {
                //mProxyHost = null;
            //} else {
                //mActivePool.disablePersistence();
                //mProxyHost = new HttpHost(host, Proxy.getPort(mContext), "http");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.742 -0400", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "A49785DE091DEB35EEAA5A02DFAFA5CB")
    public HttpHost getProxyHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_2054832157 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2054832157 = mProxyHost;
        varB4EAC82CA7396A68D541C85D26508E83_2054832157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2054832157;
        // ---------- Original Method ----------
        //return mProxyHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.747 -0400", hash_original_method = "D4465F27265450A81D8D5C54F66A3578", hash_generated_method = "B0A89248EF3A300F1ED366F11CC2D0FF")
    public RequestHandle queueRequest(
            String url, String method,
            Map<String, String> headers, EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        RequestHandle varB4EAC82CA7396A68D541C85D26508E83_1894512575 = null; //Variable for return #1
        WebAddress uri;
        uri = new WebAddress(url);
        varB4EAC82CA7396A68D541C85D26508E83_1894512575 = queueRequest(url, uri, method, headers, eventHandler,
                            bodyProvider, bodyLength);
        addTaint(url.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        varB4EAC82CA7396A68D541C85D26508E83_1894512575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1894512575;
        // ---------- Original Method ----------
        //WebAddress uri = new WebAddress(url);
        //return queueRequest(url, uri, method, headers, eventHandler,
                            //bodyProvider, bodyLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.775 -0400", hash_original_method = "5EE74AB0AE90D0DA727E01E7B767B670", hash_generated_method = "13218724F62F8F1879562CED2944C44B")
    public RequestHandle queueRequest(
            String url, WebAddress uri, String method, Map<String, String> headers,
            EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        RequestHandle varB4EAC82CA7396A68D541C85D26508E83_292931357 = null; //Variable for return #1
        HttpLog.v("RequestQueue.queueRequest " + uri);
        {
            eventHandler = new LoggingEventHandler();
        } //End block
        Request req;
        HttpHost httpHost;
        httpHost = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        req = new Request(method, httpHost, mProxyHost, uri.getPath(), bodyProvider,
                          bodyLength, eventHandler, headers);
        queueRequest(req, false);
        mActivePool.startConnectionThread();
        varB4EAC82CA7396A68D541C85D26508E83_292931357 = new RequestHandle(
                this, url, uri, method, headers, bodyProvider, bodyLength,
                req);
        addTaint(url.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        varB4EAC82CA7396A68D541C85D26508E83_292931357.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_292931357;
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) HttpLog.v("RequestQueue.queueRequest " + uri);
        //if (eventHandler == null) {
            //eventHandler = new LoggingEventHandler();
        //}
        //Request req;
        //HttpHost httpHost = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        //req = new Request(method, httpHost, mProxyHost, uri.getPath(), bodyProvider,
                          //bodyLength, eventHandler, headers);
        //queueRequest(req, false);
        //mActivePool.mTotalRequest++;
        //mActivePool.startConnectionThread();
        //return new RequestHandle(
                //this, url, uri, method, headers, bodyProvider, bodyLength,
                //req);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.778 -0400", hash_original_method = "5ADB9D7A6CBFB38DBDB876B33452D400", hash_generated_method = "9A0B61013B4701DAE43DC9459FBFB575")
    public RequestHandle queueSynchronousRequest(String url, WebAddress uri,
            String method, Map<String, String> headers,
            EventHandler eventHandler, InputStream bodyProvider,
            int bodyLength) {
        RequestHandle varB4EAC82CA7396A68D541C85D26508E83_84082007 = null; //Variable for return #1
        {
            HttpLog.v("RequestQueue.dispatchSynchronousRequest " + uri);
        } //End block
        HttpHost host;
        host = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        Request req;
        req = new Request(method, host, mProxyHost, uri.getPath(),
                bodyProvider, bodyLength, eventHandler, headers);
        host = determineHost(host);
        Connection conn;
        conn = Connection.getConnection(mContext, host, mProxyHost,
                new SyncFeeder());
        varB4EAC82CA7396A68D541C85D26508E83_84082007 = new RequestHandle(this, url, uri, method, headers, bodyProvider,
                bodyLength, req, conn);
        addTaint(url.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        varB4EAC82CA7396A68D541C85D26508E83_84082007.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_84082007;
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("RequestQueue.dispatchSynchronousRequest " + uri);
        //}
        //HttpHost host = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        //Request req = new Request(method, host, mProxyHost, uri.getPath(),
                //bodyProvider, bodyLength, eventHandler, headers);
        //host = determineHost(host);
        //Connection conn = Connection.getConnection(mContext, host, mProxyHost,
                //new SyncFeeder());
        //return new RequestHandle(this, url, uri, method, headers, bodyProvider,
                //bodyLength, req, conn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.782 -0400", hash_original_method = "19FC52B8DC895C49DAE0ECA4EB6CA639", hash_generated_method = "ACCB3D683BC072C146000E15091BA2C3")
    private HttpHost determineHost(HttpHost host) {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_2017485843 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2017485843 = (mProxyHost == null || "https".equals(host.getSchemeName()))
                ? host : mProxyHost;
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2017485843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2017485843;
        // ---------- Original Method ----------
        //return (mProxyHost == null || "https".equals(host.getSchemeName()))
                //? host : mProxyHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.783 -0400", hash_original_method = "EFE82EE341DC6BD22EFE3AAE27ABB231", hash_generated_method = "0BEF15767CFBFF689B38F9AD89C4AC79")
    synchronized boolean requestsPending() {
        boolean var7133BF04DDB95C8FD1854EE006C98F4A_1407712717 = (!mPending.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461134037 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_461134037;
        // ---------- Original Method ----------
        //return !mPending.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.810 -0400", hash_original_method = "5E944A5C3AFB2FB0842C37E33C83D8D2", hash_generated_method = "23A5DCCDCA55A1A360763DDA20F3AC38")
    synchronized void dump() {
        HttpLog.v("dump()");
        StringBuilder dump;
        dump = new StringBuilder();
        int count;
        count = 0;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter;
        {
            boolean varE9BD97FE1B3E4E52EC25D85BE293A34F_2000397933 = (!mPending.isEmpty());
            {
                iter = mPending.entrySet().iterator();
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_1660113914 = (iter.hasNext());
                    {
                        Map.Entry<HttpHost, LinkedList<Request>> entry;
                        entry = iter.next();
                        String hostName;
                        hostName = entry.getKey().getHostName();
                        StringBuilder line;
                        line = new StringBuilder("p" + count++ + " " + hostName + " ");
                        LinkedList<Request> reqList;
                        reqList = entry.getValue();
                        ListIterator reqIter;
                        reqIter = reqList.listIterator(0);
                        {
                            boolean var2F830C38CE34700FE85FC99A1EFA70EF_1663340359 = (iter.hasNext());
                            {
                                Request request;
                                request = (Request)iter.next();
                                line.append(request + " ");
                            } //End block
                        } //End collapsed parenthetic
                        dump.append(line);
                        dump.append("\n");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        HttpLog.v(dump.toString());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.811 -0400", hash_original_method = "8F04B443A564D50EFFE076AEA97295A7", hash_generated_method = "24A46DDD3C1785896CAA20B94ECB5428")
    public synchronized Request getRequest() {
        Request varB4EAC82CA7396A68D541C85D26508E83_1709868889 = null; //Variable for return #1
        Request ret;
        ret = null;
        {
            boolean varE9BD97FE1B3E4E52EC25D85BE293A34F_1550427108 = (!mPending.isEmpty());
            {
                ret = removeFirst(mPending);
            } //End block
        } //End collapsed parenthetic
        HttpLog.v("RequestQueue.getRequest() => " + ret);
        varB4EAC82CA7396A68D541C85D26508E83_1709868889 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_1709868889.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1709868889;
        // ---------- Original Method ----------
        //Request ret = null;
        //if (!mPending.isEmpty()) {
            //ret = removeFirst(mPending);
        //}
        //if (HttpLog.LOGV) HttpLog.v("RequestQueue.getRequest() => " + ret);
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.834 -0400", hash_original_method = "871E1F4E9BD2BA7BA6F72CE2CEEFAC66", hash_generated_method = "FDE35DF1A0B45700165A31EE481D8989")
    public synchronized Request getRequest(HttpHost host) {
        Request varB4EAC82CA7396A68D541C85D26508E83_942573606 = null; //Variable for return #1
        Request ret;
        ret = null;
        {
            boolean varE7ABDF5A35A014790A801A2680C4A1A8_538636101 = (mPending.containsKey(host));
            {
                LinkedList<Request> reqList;
                reqList = mPending.get(host);
                ret = reqList.removeFirst();
                {
                    boolean var4CB5D81D4471F38D594288457A576223_1656255216 = (reqList.isEmpty());
                    {
                        mPending.remove(host);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        HttpLog.v("RequestQueue.getRequest(" + host + ") => " + ret);
        varB4EAC82CA7396A68D541C85D26508E83_942573606 = ret;
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_942573606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_942573606;
        // ---------- Original Method ----------
        //Request ret = null;
        //if (mPending.containsKey(host)) {
            //LinkedList<Request> reqList = mPending.get(host);
            //ret = reqList.removeFirst();
            //if (reqList.isEmpty()) {
                //mPending.remove(host);
            //}
        //}
        //if (HttpLog.LOGV) HttpLog.v("RequestQueue.getRequest(" + host + ") => " + ret);
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.835 -0400", hash_original_method = "A6996F44457236E27DB2C5C55302FCBE", hash_generated_method = "1CE8F2C63DEE0DD6CBDEC985BA1E7027")
    public synchronized boolean haveRequest(HttpHost host) {
        boolean var0F2263933ABF4CF4E5A684F5D02ACF6E_390481258 = (mPending.containsKey(host));
        addTaint(host.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932088431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932088431;
        // ---------- Original Method ----------
        //return mPending.containsKey(host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.835 -0400", hash_original_method = "5DF1C437E9ED58A9D928A0798F1B9425", hash_generated_method = "08E6B360C8DA7DA38817DD6704BA0DFA")
    public void requeueRequest(Request request) {
        queueRequest(request, true);
        addTaint(request.getTaint());
        // ---------- Original Method ----------
        //queueRequest(request, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.848 -0400", hash_original_method = "36DEBCDEC4EFDB8CF8346CFD81066CDA", hash_generated_method = "305FCD4CBF7749B7023C16A68C3F0EFC")
    public void shutdown() {
        mActivePool.shutdown();
        // ---------- Original Method ----------
        //mActivePool.shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.860 -0400", hash_original_method = "99743D8700F7CD0272109FAA55D49D1A", hash_generated_method = "ED27190796D43195891E9E1E917184E4")
    protected synchronized void queueRequest(Request request, boolean head) {
        HttpHost host;
        host = request.mHost;
        host = request.mProxyHost;
        LinkedList<Request> reqList;
        {
            boolean varE7ABDF5A35A014790A801A2680C4A1A8_669859884 = (mPending.containsKey(host));
            {
                reqList = mPending.get(host);
            } //End block
            {
                reqList = new LinkedList<Request>();
                mPending.put(host, reqList);
            } //End block
        } //End collapsed parenthetic
        {
            reqList.addFirst(request);
        } //End block
        {
            reqList.add(request);
        } //End block
        addTaint(request.getTaint());
        addTaint(head);
        // ---------- Original Method ----------
        //HttpHost host = request.mProxyHost == null ? request.mHost : request.mProxyHost;
        //LinkedList<Request> reqList;
        //if (mPending.containsKey(host)) {
            //reqList = mPending.get(host);
        //} else {
            //reqList = new LinkedList<Request>();
            //mPending.put(host, reqList);
        //}
        //if (head) {
            //reqList.addFirst(request);
        //} else {
            //reqList.add(request);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.868 -0400", hash_original_method = "D615BD22372BF27837008A0B674B3672", hash_generated_method = "68F8461F4FB60C27086B594BAC5A2D5C")
    public void startTiming() {
        mActivePool.startTiming();
        // ---------- Original Method ----------
        //mActivePool.startTiming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.868 -0400", hash_original_method = "93BD6698DCB4A99EC2C52A706270C860", hash_generated_method = "79A321F150AAF5DF19960FC8264B094B")
    public void stopTiming() {
        mActivePool.stopTiming();
        // ---------- Original Method ----------
        //mActivePool.stopTiming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.871 -0400", hash_original_method = "F363C5354CB9B81208E7FAC033526D24", hash_generated_method = "FE31FB07CAECC6D7A14A3FE565BA57E6")
    private Request removeFirst(LinkedHashMap<HttpHost, LinkedList<Request>> requestQueue) {
        Request varB4EAC82CA7396A68D541C85D26508E83_1018034652 = null; //Variable for return #1
        Request ret;
        ret = null;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter;
        iter = requestQueue.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1482881757 = (iter.hasNext());
            {
                Map.Entry<HttpHost, LinkedList<Request>> entry;
                entry = iter.next();
                LinkedList<Request> reqList;
                reqList = entry.getValue();
                ret = reqList.removeFirst();
                {
                    boolean var4CB5D81D4471F38D594288457A576223_1082574033 = (reqList.isEmpty());
                    {
                        requestQueue.remove(entry.getKey());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1018034652 = ret;
        addTaint(requestQueue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1018034652.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1018034652;
        // ---------- Original Method ----------
        //Request ret = null;
        //Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter = requestQueue.entrySet().iterator();
        //if (iter.hasNext()) {
            //Map.Entry<HttpHost, LinkedList<Request>> entry = iter.next();
            //LinkedList<Request> reqList = entry.getValue();
            //ret = reqList.removeFirst();
            //if (reqList.isEmpty()) {
                //requestQueue.remove(entry.getKey());
            //}
        //}
        //return ret;
    }

    
    class ActivePool implements ConnectionManager {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.871 -0400", hash_original_field = "60138ABD5009ABCE16930B0D3EFB1698", hash_generated_field = "A911064E545F525658232640AFA7D0B9")

        ConnectionThread[] mThreads;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.871 -0400", hash_original_field = "BCC3AD91A8AEAB3BF27A9A0FF3DB98E2", hash_generated_field = "448266124930497935AABDA6EA3530AA")

        IdleCache mIdleCache;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.871 -0400", hash_original_field = "397ADEECCD7CDE5D457B08965AB7F279", hash_generated_field = "04EBA439DE54BE9E4E88BA35E3F14E1F")

        private int mTotalRequest;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.871 -0400", hash_original_field = "71A1084ED0F70B17E36C243F38A17E13", hash_generated_field = "75F51D982E39DA7109E095FB57E24560")

        private int mTotalConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.871 -0400", hash_original_field = "17F39E7D585A12BB1F9266F8CE91D153", hash_generated_field = "3B7FD818552FF5D0D780F585667ED47F")

        private int mConnectionCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.889 -0400", hash_original_method = "EC748BA333F005CC68E7979CEA362A8D", hash_generated_method = "B38A4FE9ED7E9298CB521164C9C43190")
          ActivePool(int connectionCount) {
            mIdleCache = new IdleCache();
            mConnectionCount = connectionCount;
            mThreads = new ConnectionThread[mConnectionCount];
            {
                int i;
                i = 0;
                {
                    mThreads[i] = new ConnectionThread(
                        mContext, i, this, RequestQueue.this);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mIdleCache = new IdleCache();
            //mConnectionCount = connectionCount;
            //mThreads = new ConnectionThread[mConnectionCount];
            //for (int i = 0; i < mConnectionCount; i++) {
                //mThreads[i] = new ConnectionThread(
                        //mContext, i, this, RequestQueue.this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.890 -0400", hash_original_method = "1219F5054D15C8BA85E10250B0465A48", hash_generated_method = "1BB28F7E38886C3DBE5995B22251C175")
         void startup() {
            {
                int i;
                i = 0;
                {
                    mThreads[i].start();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //for (int i = 0; i < mConnectionCount; i++) {
                //mThreads[i].start();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.891 -0400", hash_original_method = "3DBC0C51372089E9236025C3C2E89B00", hash_generated_method = "E82FFEBE61CA2E58FB3F0915D6F92AF2")
         void shutdown() {
            {
                int i;
                i = 0;
                {
                    mThreads[i].requestStop();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //for (int i = 0; i < mConnectionCount; i++) {
                //mThreads[i].requestStop();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.909 -0400", hash_original_method = "918E02281CDA2E4E4F9A4B76A9977FCD", hash_generated_method = "93ED36BBC12CB79B45E5B7EF40B30B82")
         void startConnectionThread() {
            {
                Object varE793CDC2A4AC9B4DAF10C6DB63F4C18F_1467745095 = (RequestQueue.this);
                {
                    RequestQueue.this.notify();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //synchronized (RequestQueue.this) {
                //RequestQueue.this.notify();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.910 -0400", hash_original_method = "D2A094DDB6185336258EAA22554B8B48", hash_generated_method = "C54585CFFBB2B71991366508D9BC4E00")
        public void startTiming() {
            {
                int i;
                i = 0;
                {
                    ConnectionThread rt;
                    rt = mThreads[i];
                    rt.mCurrentThreadTime = -1;
                    rt.mTotalThreadTime = 0;
                } //End block
            } //End collapsed parenthetic
            mTotalRequest = 0;
            mTotalConnection = 0;
            // ---------- Original Method ----------
            //for (int i = 0; i < mConnectionCount; i++) {
                //ConnectionThread rt = mThreads[i];
                //rt.mCurrentThreadTime = -1;
                //rt.mTotalThreadTime = 0;
            //}
            //mTotalRequest = 0;
            //mTotalConnection = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.911 -0400", hash_original_method = "24B30AFE4309F082BC585F8C48779E08", hash_generated_method = "9515CACA13243312FF76F6525D9F1CCA")
        public void stopTiming() {
            int totalTime;
            totalTime = 0;
            {
                int i;
                i = 0;
                {
                    ConnectionThread rt;
                    rt = mThreads[i];
                    {
                        totalTime += rt.mTotalThreadTime;
                    } //End block
                    rt.mCurrentThreadTime = 0;
                } //End block
            } //End collapsed parenthetic
            Log.d("Http", "Http thread used " + totalTime + " ms " + " for "
                    + mTotalRequest + " requests and " + mTotalConnection
                    + " new connections");
            // ---------- Original Method ----------
            //int totalTime = 0;
            //for (int i = 0; i < mConnectionCount; i++) {
                //ConnectionThread rt = mThreads[i];
                //if (rt.mCurrentThreadTime != -1) {
                    //totalTime += rt.mTotalThreadTime;
                //}
                //rt.mCurrentThreadTime = 0;
            //}
            //Log.d("Http", "Http thread used " + totalTime + " ms " + " for "
                    //+ mTotalRequest + " requests and " + mTotalConnection
                    //+ " new connections");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.912 -0400", hash_original_method = "D3242BE060800C50D95BDC78717491BA", hash_generated_method = "24D243CD3D83957535E182E64D50C0C7")
         void logState() {
            StringBuilder dump;
            dump = new StringBuilder();
            {
                int i;
                i = 0;
                {
                    dump.append(mThreads[i] + "\n");
                } //End block
            } //End collapsed parenthetic
            HttpLog.v(dump.toString());
            // ---------- Original Method ----------
            //StringBuilder dump = new StringBuilder();
            //for (int i = 0; i < mConnectionCount; i++) {
                //dump.append(mThreads[i] + "\n");
            //}
            //HttpLog.v(dump.toString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.929 -0400", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "ADA5C87B198291014F580486087AD52C")
        public HttpHost getProxyHost() {
            HttpHost varB4EAC82CA7396A68D541C85D26508E83_317960672 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_317960672 = mProxyHost;
            varB4EAC82CA7396A68D541C85D26508E83_317960672.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_317960672;
            // ---------- Original Method ----------
            //return mProxyHost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.930 -0400", hash_original_method = "0E1F656010AA811F93614A0AAB8C062E", hash_generated_method = "779113E9A71F4407FA3C3183C08BF088")
         void disablePersistence() {
            {
                int i;
                i = 0;
                {
                    Connection connection;
                    connection = mThreads[i].mConnection;
                    connection.setCanPersist(false);
                } //End block
            } //End collapsed parenthetic
            mIdleCache.clear();
            // ---------- Original Method ----------
            //for (int i = 0; i < mConnectionCount; i++) {
                //Connection connection = mThreads[i].mConnection;
                //if (connection != null) connection.setCanPersist(false);
            //}
            //mIdleCache.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.932 -0400", hash_original_method = "4350BDA0BFA960DC6ECB5B267907B720", hash_generated_method = "BCF90A203FE01729F37B782EA922EB91")
         ConnectionThread getThread(HttpHost host) {
            ConnectionThread varB4EAC82CA7396A68D541C85D26508E83_895176855 = null; //Variable for return #1
            ConnectionThread varB4EAC82CA7396A68D541C85D26508E83_285144515 = null; //Variable for return #2
            {
                Object varE793CDC2A4AC9B4DAF10C6DB63F4C18F_1335889543 = (RequestQueue.this);
                {
                    {
                        int i;
                        i = 0;
                        {
                            ConnectionThread ct;
                            ct = mThreads[i];
                            Connection connection;
                            connection = ct.mConnection;
                            {
                                boolean var8E44A46CE9E7F837465A12630555EC7E_1063123561 = (connection != null && connection.mHost.equals(host));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_895176855 = ct;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_285144515 = null;
            addTaint(host.getTaint());
            ConnectionThread varA7E53CE21691AB073D9660D615818899_1618226809; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1618226809 = varB4EAC82CA7396A68D541C85D26508E83_895176855;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1618226809 = varB4EAC82CA7396A68D541C85D26508E83_285144515;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1618226809.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1618226809;
            // ---------- Original Method ----------
            //synchronized(RequestQueue.this) {
                //for (int i = 0; i < mThreads.length; i++) {
                    //ConnectionThread ct = mThreads[i];
                    //Connection connection = ct.mConnection;
                    //if (connection != null && connection.mHost.equals(host)) {
                        //return ct;
                    //}
                //}
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.949 -0400", hash_original_method = "FFEAD5D96A31C5526086E61D15C11F62", hash_generated_method = "3957E328A52EDCAC7D9C259F9031CD14")
        public Connection getConnection(Context context, HttpHost host) {
            Connection varB4EAC82CA7396A68D541C85D26508E83_1990585995 = null; //Variable for return #1
            host = RequestQueue.this.determineHost(host);
            Connection con;
            con = mIdleCache.getConnection(host);
            {
                con = Connection.getConnection(mContext, host, mProxyHost,
                        RequestQueue.this);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1990585995 = con;
            addTaint(context.getTaint());
            addTaint(host.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1990585995.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1990585995;
            // ---------- Original Method ----------
            //host = RequestQueue.this.determineHost(host);
            //Connection con = mIdleCache.getConnection(host);
            //if (con == null) {
                //mTotalConnection++;
                //con = Connection.getConnection(mContext, host, mProxyHost,
                        //RequestQueue.this);
            //}
            //return con;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.950 -0400", hash_original_method = "3E0E4C6417BA7E6D1B1D779C38F1AA9A", hash_generated_method = "F4CBE07F176285F14D5E4F97623215B6")
        public boolean recycleConnection(Connection connection) {
            boolean var4F646DF14443B5F9866FC8556E35664C_670441492 = (mIdleCache.cacheConnection(connection.getHost(), connection));
            addTaint(connection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_376605097 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_376605097;
            // ---------- Original Method ----------
            //return mIdleCache.cacheConnection(connection.getHost(), connection);
        }

        
    }


    
    private static class SyncFeeder implements RequestFeeder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.950 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

        private Request mRequest;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.951 -0400", hash_original_method = "4463F8298E503AEAFD22486DF3099826", hash_generated_method = "E6A6A8CDE9B9C9FF0F1FF74192A505FE")
          SyncFeeder() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.967 -0400", hash_original_method = "E0C38BA5AF5E9B7363BEA9E204F697F3", hash_generated_method = "DF565CCEDC42603FAEB6F5BA6AA18E4D")
        public Request getRequest() {
            Request varB4EAC82CA7396A68D541C85D26508E83_1179872669 = null; //Variable for return #1
            Request r;
            r = mRequest;
            mRequest = null;
            varB4EAC82CA7396A68D541C85D26508E83_1179872669 = r;
            varB4EAC82CA7396A68D541C85D26508E83_1179872669.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1179872669;
            // ---------- Original Method ----------
            //Request r = mRequest;
            //mRequest = null;
            //return r;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.972 -0400", hash_original_method = "DE8B4E1CA9B86F476AFDBAF1FF7FD442", hash_generated_method = "CDA09E5B08683C52DBC677794C942146")
        public Request getRequest(HttpHost host) {
            Request varB4EAC82CA7396A68D541C85D26508E83_988982396 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_988982396 = getRequest();
            addTaint(host.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_988982396.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_988982396;
            // ---------- Original Method ----------
            //return getRequest();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.973 -0400", hash_original_method = "30BE3F23DCE5F30BFE4C540BF8AE4D20", hash_generated_method = "3844FDF2A8571768AB8A9681E2FE027F")
        public boolean haveRequest(HttpHost host) {
            addTaint(host.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1012238606 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1012238606;
            // ---------- Original Method ----------
            //return mRequest != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.973 -0400", hash_original_method = "D0AA652C1F1A28EE12BADC892C348224", hash_generated_method = "0490D711BBE9F89E677FF31CE7FA801F")
        public void requeueRequest(Request r) {
            mRequest = r;
            // ---------- Original Method ----------
            //mRequest = r;
        }

        
    }


    
    interface ConnectionManager {
        HttpHost getProxyHost();
        Connection getConnection(Context context, HttpHost host);
        boolean recycleConnection(Connection connection);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.974 -0400", hash_original_field = "D46855AAE2E017E8DAECB4EE7F509FE5", hash_generated_field = "8FC4B5B1665F40EFDEEBB781E921350F")

    private static int CONNECTION_COUNT = 4;
}

