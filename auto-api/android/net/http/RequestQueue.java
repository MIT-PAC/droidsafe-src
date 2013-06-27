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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.872 -0400", hash_original_field = "8673F7F02EF7B3B9DEB1A224A23932BB", hash_generated_field = "1758DBA360E4E3B600ADDDCE5E66E218")

    private LinkedHashMap<HttpHost, LinkedList<Request>> mPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.884 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.884 -0400", hash_original_field = "9F8C80ADD03363D444D5DD543187AC5D", hash_generated_field = "7E2C9159191DF9FFA295FC8E90223677")

    private ActivePool mActivePool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.884 -0400", hash_original_field = "EB205FDB4F9378FA441222BF6F7ABE71", hash_generated_field = "7F6315533CCAF46DEA5C0B5CCAC3EBAB")

    private ConnectivityManager mConnectivityManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.884 -0400", hash_original_field = "4E55F1B55468F140FC44ACD1C350CF05", hash_generated_field = "99742757777505E14871D3515FDC7109")

    private HttpHost mProxyHost = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.884 -0400", hash_original_field = "6316EE14E7E9EE85C930ED2A15CC2BB7", hash_generated_field = "EAF3975B1E21B046C1D30C80F39B0ACA")

    private BroadcastReceiver mProxyChangeReceiver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.885 -0400", hash_original_method = "7E78DB3349CECCEABE79A47BDE45F2E4", hash_generated_method = "DDF29BFAAE46044224D6EEEA2BBC483F")
    public  RequestQueue(Context context) {
        this(context, CONNECTION_COUNT);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.886 -0400", hash_original_method = "A7CEC9D1667C71B6ADD3849E74F98CAD", hash_generated_method = "C4F46365E49B566B692619AA850CA5BF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.896 -0400", hash_original_method = "192F6D29BBECFA47E09E7D8D48EF8859", hash_generated_method = "06CDA5498E378A584C32ACF6A8B16483")
    public synchronized void enablePlatformNotifications() {
        HttpLog.v("RequestQueue.enablePlatformNotifications() network");
        {
            mProxyChangeReceiver =
                    new BroadcastReceiver() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.896 -0400", hash_original_method = "3CB2B7FAEA507C11972A385D868E1E52", hash_generated_method = "50705C8A9D00ADEEB2A67E3959DD9EA8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.897 -0400", hash_original_method = "B133918A77AADD577D84EC4FDA196DDC", hash_generated_method = "A37E9AEDA43DF86F46832B3F924735F1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.914 -0400", hash_original_method = "381746B4CF404D7B9FDB43420AECD746", hash_generated_method = "A52A0D784CFDD8E0BEC2304B57C7FEF6")
    private synchronized void setProxyConfig() {
        NetworkInfo info;
        info = mConnectivityManager.getActiveNetworkInfo();
        {
            boolean var24FBA6C722421408BD9DC8A74F9723F7_790800107 = (info != null && info.getType() == ConnectivityManager.TYPE_WIFI);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.935 -0400", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "B579A928B82FDC85C02342368575CB60")
    public HttpHost getProxyHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1543348391 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1543348391 = mProxyHost;
        varB4EAC82CA7396A68D541C85D26508E83_1543348391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1543348391;
        // ---------- Original Method ----------
        //return mProxyHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.947 -0400", hash_original_method = "D4465F27265450A81D8D5C54F66A3578", hash_generated_method = "2667990C0D555E620DB1543F95F326FE")
    public RequestHandle queueRequest(
            String url, String method,
            Map<String, String> headers, EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        RequestHandle varB4EAC82CA7396A68D541C85D26508E83_224762361 = null; //Variable for return #1
        WebAddress uri;
        uri = new WebAddress(url);
        varB4EAC82CA7396A68D541C85D26508E83_224762361 = queueRequest(url, uri, method, headers, eventHandler,
                            bodyProvider, bodyLength);
        addTaint(url.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        varB4EAC82CA7396A68D541C85D26508E83_224762361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_224762361;
        // ---------- Original Method ----------
        //WebAddress uri = new WebAddress(url);
        //return queueRequest(url, uri, method, headers, eventHandler,
                            //bodyProvider, bodyLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.953 -0400", hash_original_method = "5EE74AB0AE90D0DA727E01E7B767B670", hash_generated_method = "4D820FFED62F2A8847C31967C99D678D")
    public RequestHandle queueRequest(
            String url, WebAddress uri, String method, Map<String, String> headers,
            EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        RequestHandle varB4EAC82CA7396A68D541C85D26508E83_559141409 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_559141409 = new RequestHandle(
                this, url, uri, method, headers, bodyProvider, bodyLength,
                req);
        addTaint(url.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        varB4EAC82CA7396A68D541C85D26508E83_559141409.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_559141409;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.956 -0400", hash_original_method = "5ADB9D7A6CBFB38DBDB876B33452D400", hash_generated_method = "F24AFFE3C2D5279C41709D655CC7246C")
    public RequestHandle queueSynchronousRequest(String url, WebAddress uri,
            String method, Map<String, String> headers,
            EventHandler eventHandler, InputStream bodyProvider,
            int bodyLength) {
        RequestHandle varB4EAC82CA7396A68D541C85D26508E83_1874901796 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1874901796 = new RequestHandle(this, url, uri, method, headers, bodyProvider,
                bodyLength, req, conn);
        addTaint(url.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        varB4EAC82CA7396A68D541C85D26508E83_1874901796.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1874901796;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.968 -0400", hash_original_method = "19FC52B8DC895C49DAE0ECA4EB6CA639", hash_generated_method = "68B003AC7711A5CCB9BDEFF17C2DF896")
    private HttpHost determineHost(HttpHost host) {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1035226867 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1035226867 = (mProxyHost == null || "https".equals(host.getSchemeName()))
                ? host : mProxyHost;
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1035226867.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1035226867;
        // ---------- Original Method ----------
        //return (mProxyHost == null || "https".equals(host.getSchemeName()))
                //? host : mProxyHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.968 -0400", hash_original_method = "EFE82EE341DC6BD22EFE3AAE27ABB231", hash_generated_method = "EF2DAD90B60B5C8011D3BD4B0EE4C56B")
    synchronized boolean requestsPending() {
        boolean var7133BF04DDB95C8FD1854EE006C98F4A_1324931104 = (!mPending.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1714468412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1714468412;
        // ---------- Original Method ----------
        //return !mPending.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.970 -0400", hash_original_method = "5E944A5C3AFB2FB0842C37E33C83D8D2", hash_generated_method = "7644EA6EEAF908D9828E74120036A860")
    synchronized void dump() {
        HttpLog.v("dump()");
        StringBuilder dump;
        dump = new StringBuilder();
        int count;
        count = 0;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter;
        {
            boolean varE9BD97FE1B3E4E52EC25D85BE293A34F_1468822979 = (!mPending.isEmpty());
            {
                iter = mPending.entrySet().iterator();
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_1136274789 = (iter.hasNext());
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
                            boolean var2F830C38CE34700FE85FC99A1EFA70EF_954093403 = (iter.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.986 -0400", hash_original_method = "8F04B443A564D50EFFE076AEA97295A7", hash_generated_method = "E7694B038F285F05949B1C1FFB066062")
    public synchronized Request getRequest() {
        Request varB4EAC82CA7396A68D541C85D26508E83_63364714 = null; //Variable for return #1
        Request ret;
        ret = null;
        {
            boolean varE9BD97FE1B3E4E52EC25D85BE293A34F_1650461038 = (!mPending.isEmpty());
            {
                ret = removeFirst(mPending);
            } //End block
        } //End collapsed parenthetic
        HttpLog.v("RequestQueue.getRequest() => " + ret);
        varB4EAC82CA7396A68D541C85D26508E83_63364714 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_63364714.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_63364714;
        // ---------- Original Method ----------
        //Request ret = null;
        //if (!mPending.isEmpty()) {
            //ret = removeFirst(mPending);
        //}
        //if (HttpLog.LOGV) HttpLog.v("RequestQueue.getRequest() => " + ret);
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.997 -0400", hash_original_method = "871E1F4E9BD2BA7BA6F72CE2CEEFAC66", hash_generated_method = "A742C18BFCA4121724A3B1382EC56CF8")
    public synchronized Request getRequest(HttpHost host) {
        Request varB4EAC82CA7396A68D541C85D26508E83_1823950359 = null; //Variable for return #1
        Request ret;
        ret = null;
        {
            boolean varE7ABDF5A35A014790A801A2680C4A1A8_44201908 = (mPending.containsKey(host));
            {
                LinkedList<Request> reqList;
                reqList = mPending.get(host);
                ret = reqList.removeFirst();
                {
                    boolean var4CB5D81D4471F38D594288457A576223_159323737 = (reqList.isEmpty());
                    {
                        mPending.remove(host);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        HttpLog.v("RequestQueue.getRequest(" + host + ") => " + ret);
        varB4EAC82CA7396A68D541C85D26508E83_1823950359 = ret;
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1823950359.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1823950359;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.009 -0400", hash_original_method = "A6996F44457236E27DB2C5C55302FCBE", hash_generated_method = "61B469D5F70DAE3FDE541895D158D40F")
    public synchronized boolean haveRequest(HttpHost host) {
        boolean var0F2263933ABF4CF4E5A684F5D02ACF6E_334319732 = (mPending.containsKey(host));
        addTaint(host.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499809725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499809725;
        // ---------- Original Method ----------
        //return mPending.containsKey(host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.010 -0400", hash_original_method = "5DF1C437E9ED58A9D928A0798F1B9425", hash_generated_method = "08E6B360C8DA7DA38817DD6704BA0DFA")
    public void requeueRequest(Request request) {
        queueRequest(request, true);
        addTaint(request.getTaint());
        // ---------- Original Method ----------
        //queueRequest(request, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.011 -0400", hash_original_method = "36DEBCDEC4EFDB8CF8346CFD81066CDA", hash_generated_method = "305FCD4CBF7749B7023C16A68C3F0EFC")
    public void shutdown() {
        mActivePool.shutdown();
        // ---------- Original Method ----------
        //mActivePool.shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.030 -0400", hash_original_method = "99743D8700F7CD0272109FAA55D49D1A", hash_generated_method = "4E16E799E6C8CA921B4CBFBF51CD2815")
    protected synchronized void queueRequest(Request request, boolean head) {
        HttpHost host;
        host = request.mHost;
        host = request.mProxyHost;
        LinkedList<Request> reqList;
        {
            boolean varE7ABDF5A35A014790A801A2680C4A1A8_75612014 = (mPending.containsKey(host));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.031 -0400", hash_original_method = "D615BD22372BF27837008A0B674B3672", hash_generated_method = "68F8461F4FB60C27086B594BAC5A2D5C")
    public void startTiming() {
        mActivePool.startTiming();
        // ---------- Original Method ----------
        //mActivePool.startTiming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.060 -0400", hash_original_method = "93BD6698DCB4A99EC2C52A706270C860", hash_generated_method = "79A321F150AAF5DF19960FC8264B094B")
    public void stopTiming() {
        mActivePool.stopTiming();
        // ---------- Original Method ----------
        //mActivePool.stopTiming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.062 -0400", hash_original_method = "F363C5354CB9B81208E7FAC033526D24", hash_generated_method = "DFC274760EF6EB650287130BF16E0598")
    private Request removeFirst(LinkedHashMap<HttpHost, LinkedList<Request>> requestQueue) {
        Request varB4EAC82CA7396A68D541C85D26508E83_270475936 = null; //Variable for return #1
        Request ret;
        ret = null;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter;
        iter = requestQueue.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_625453353 = (iter.hasNext());
            {
                Map.Entry<HttpHost, LinkedList<Request>> entry;
                entry = iter.next();
                LinkedList<Request> reqList;
                reqList = entry.getValue();
                ret = reqList.removeFirst();
                {
                    boolean var4CB5D81D4471F38D594288457A576223_674998445 = (reqList.isEmpty());
                    {
                        requestQueue.remove(entry.getKey());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_270475936 = ret;
        addTaint(requestQueue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_270475936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_270475936;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.062 -0400", hash_original_field = "60138ABD5009ABCE16930B0D3EFB1698", hash_generated_field = "A911064E545F525658232640AFA7D0B9")

        ConnectionThread[] mThreads;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.063 -0400", hash_original_field = "BCC3AD91A8AEAB3BF27A9A0FF3DB98E2", hash_generated_field = "448266124930497935AABDA6EA3530AA")

        IdleCache mIdleCache;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.063 -0400", hash_original_field = "397ADEECCD7CDE5D457B08965AB7F279", hash_generated_field = "04EBA439DE54BE9E4E88BA35E3F14E1F")

        private int mTotalRequest;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.063 -0400", hash_original_field = "71A1084ED0F70B17E36C243F38A17E13", hash_generated_field = "75F51D982E39DA7109E095FB57E24560")

        private int mTotalConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.063 -0400", hash_original_field = "17F39E7D585A12BB1F9266F8CE91D153", hash_generated_field = "3B7FD818552FF5D0D780F585667ED47F")

        private int mConnectionCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.065 -0400", hash_original_method = "EC748BA333F005CC68E7979CEA362A8D", hash_generated_method = "B38A4FE9ED7E9298CB521164C9C43190")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.066 -0400", hash_original_method = "1219F5054D15C8BA85E10250B0465A48", hash_generated_method = "1BB28F7E38886C3DBE5995B22251C175")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.090 -0400", hash_original_method = "3DBC0C51372089E9236025C3C2E89B00", hash_generated_method = "E82FFEBE61CA2E58FB3F0915D6F92AF2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.091 -0400", hash_original_method = "918E02281CDA2E4E4F9A4B76A9977FCD", hash_generated_method = "8390888CEE8460C9EF7974C3B944841A")
         void startConnectionThread() {
            {
                Object varE793CDC2A4AC9B4DAF10C6DB63F4C18F_27767908 = (RequestQueue.this);
                {
                    RequestQueue.this.notify();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //synchronized (RequestQueue.this) {
                //RequestQueue.this.notify();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.092 -0400", hash_original_method = "D2A094DDB6185336258EAA22554B8B48", hash_generated_method = "C54585CFFBB2B71991366508D9BC4E00")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.108 -0400", hash_original_method = "24B30AFE4309F082BC585F8C48779E08", hash_generated_method = "9515CACA13243312FF76F6525D9F1CCA")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.120 -0400", hash_original_method = "D3242BE060800C50D95BDC78717491BA", hash_generated_method = "24D243CD3D83957535E182E64D50C0C7")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.121 -0400", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "FCD3DEF010BFC763467F769061FDCCD4")
        public HttpHost getProxyHost() {
            HttpHost varB4EAC82CA7396A68D541C85D26508E83_1456747565 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1456747565 = mProxyHost;
            varB4EAC82CA7396A68D541C85D26508E83_1456747565.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1456747565;
            // ---------- Original Method ----------
            //return mProxyHost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.122 -0400", hash_original_method = "0E1F656010AA811F93614A0AAB8C062E", hash_generated_method = "779113E9A71F4407FA3C3183C08BF088")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.144 -0400", hash_original_method = "4350BDA0BFA960DC6ECB5B267907B720", hash_generated_method = "5B27C1402A57B9DA17D980AC13E9ECEA")
         ConnectionThread getThread(HttpHost host) {
            ConnectionThread varB4EAC82CA7396A68D541C85D26508E83_1180694706 = null; //Variable for return #1
            ConnectionThread varB4EAC82CA7396A68D541C85D26508E83_1946820941 = null; //Variable for return #2
            {
                Object varE793CDC2A4AC9B4DAF10C6DB63F4C18F_2004495631 = (RequestQueue.this);
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
                                boolean var8E44A46CE9E7F837465A12630555EC7E_424391579 = (connection != null && connection.mHost.equals(host));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1180694706 = ct;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1946820941 = null;
            addTaint(host.getTaint());
            ConnectionThread varA7E53CE21691AB073D9660D615818899_1468769011; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1468769011 = varB4EAC82CA7396A68D541C85D26508E83_1180694706;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1468769011 = varB4EAC82CA7396A68D541C85D26508E83_1946820941;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1468769011.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1468769011;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.148 -0400", hash_original_method = "FFEAD5D96A31C5526086E61D15C11F62", hash_generated_method = "BAB170E45DED70A482B02510F4C6F4F9")
        public Connection getConnection(Context context, HttpHost host) {
            Connection varB4EAC82CA7396A68D541C85D26508E83_13488631 = null; //Variable for return #1
            host = RequestQueue.this.determineHost(host);
            Connection con;
            con = mIdleCache.getConnection(host);
            {
                con = Connection.getConnection(mContext, host, mProxyHost,
                        RequestQueue.this);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_13488631 = con;
            addTaint(context.getTaint());
            addTaint(host.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_13488631.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_13488631;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.163 -0400", hash_original_method = "3E0E4C6417BA7E6D1B1D779C38F1AA9A", hash_generated_method = "C47705FCE83BFDD6F3E2A6712561B22F")
        public boolean recycleConnection(Connection connection) {
            boolean var4F646DF14443B5F9866FC8556E35664C_1402012937 = (mIdleCache.cacheConnection(connection.getHost(), connection));
            addTaint(connection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_267495371 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_267495371;
            // ---------- Original Method ----------
            //return mIdleCache.cacheConnection(connection.getHost(), connection);
        }

        
    }


    
    private static class SyncFeeder implements RequestFeeder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.163 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

        private Request mRequest;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.163 -0400", hash_original_method = "4463F8298E503AEAFD22486DF3099826", hash_generated_method = "E6A6A8CDE9B9C9FF0F1FF74192A505FE")
          SyncFeeder() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.164 -0400", hash_original_method = "E0C38BA5AF5E9B7363BEA9E204F697F3", hash_generated_method = "1A71222E933766C4CD8023FBAD4197FE")
        public Request getRequest() {
            Request varB4EAC82CA7396A68D541C85D26508E83_533501033 = null; //Variable for return #1
            Request r;
            r = mRequest;
            mRequest = null;
            varB4EAC82CA7396A68D541C85D26508E83_533501033 = r;
            varB4EAC82CA7396A68D541C85D26508E83_533501033.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_533501033;
            // ---------- Original Method ----------
            //Request r = mRequest;
            //mRequest = null;
            //return r;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.165 -0400", hash_original_method = "DE8B4E1CA9B86F476AFDBAF1FF7FD442", hash_generated_method = "A193D49AA11F0A76725471817CDB6F86")
        public Request getRequest(HttpHost host) {
            Request varB4EAC82CA7396A68D541C85D26508E83_1186803039 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1186803039 = getRequest();
            addTaint(host.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1186803039.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1186803039;
            // ---------- Original Method ----------
            //return getRequest();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.168 -0400", hash_original_method = "30BE3F23DCE5F30BFE4C540BF8AE4D20", hash_generated_method = "B7A0C920B3F08004C3B6B529206A4725")
        public boolean haveRequest(HttpHost host) {
            addTaint(host.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971659064 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_971659064;
            // ---------- Original Method ----------
            //return mRequest != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.168 -0400", hash_original_method = "D0AA652C1F1A28EE12BADC892C348224", hash_generated_method = "0490D711BBE9F89E677FF31CE7FA801F")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.168 -0400", hash_original_field = "D46855AAE2E017E8DAECB4EE7F509FE5", hash_generated_field = "8FC4B5B1665F40EFDEEBB781E921350F")

    private static int CONNECTION_COUNT = 4;
}

