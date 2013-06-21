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
    private LinkedHashMap<HttpHost, LinkedList<Request>> mPending;
    private Context mContext;
    private ActivePool mActivePool;
    private ConnectivityManager mConnectivityManager;
    private HttpHost mProxyHost = null;
    private BroadcastReceiver mProxyChangeReceiver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.063 -0400", hash_original_method = "7E78DB3349CECCEABE79A47BDE45F2E4", hash_generated_method = "10A7FAC539E06143EB59D8C56EBF526A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequestQueue(Context context) {
        this(context, CONNECTION_COUNT);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.063 -0400", hash_original_method = "A7CEC9D1667C71B6ADD3849E74F98CAD", hash_generated_method = "6D8ED153EAEFEA7990B2D61AF9D1D0E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequestQueue(Context context, int connectionCount) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(connectionCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.064 -0400", hash_original_method = "192F6D29BBECFA47E09E7D8D48EF8859", hash_generated_method = "F677E17289436EDA603A16872DC4D80D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void enablePlatformNotifications() {
        HttpLog.v("RequestQueue.enablePlatformNotifications() network");
        {
            mProxyChangeReceiver =
                    new BroadcastReceiver() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.064 -0400", hash_original_method = "3CB2B7FAEA507C11972A385D868E1E52", hash_generated_method = "DCE4CB1C98CD4EDD064BE728EB677B3B")
                @DSModeled(DSC.SPEC)
                @Override
                public void onReceive(Context ctx, Intent intent) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(ctx.dsTaint);
                    dsTaint.addTaint(intent.dsTaint);
                    setProxyConfig();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.064 -0400", hash_original_method = "B133918A77AADD577D84EC4FDA196DDC", hash_generated_method = "A37E9AEDA43DF86F46832B3F924735F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.065 -0400", hash_original_method = "381746B4CF404D7B9FDB43420AECD746", hash_generated_method = "2A57A9798942EA6CB19F83B6E2A88C1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void setProxyConfig() {
        NetworkInfo info;
        info = mConnectivityManager.getActiveNetworkInfo();
        {
            boolean var24FBA6C722421408BD9DC8A74F9723F7_307123613 = (info != null && info.getType() == ConnectivityManager.TYPE_WIFI);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.065 -0400", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "82A774F3BFB777AD63698CB0F1742A25")
    @DSModeled(DSC.SAFE)
    public HttpHost getProxyHost() {
        return (HttpHost)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mProxyHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.065 -0400", hash_original_method = "D4465F27265450A81D8D5C54F66A3578", hash_generated_method = "B11F1D7A8ECE6063015357E08C3989DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequestHandle queueRequest(
            String url, String method,
            Map<String, String> headers, EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(eventHandler.dsTaint);
        dsTaint.addTaint(bodyProvider.dsTaint);
        dsTaint.addTaint(bodyLength);
        dsTaint.addTaint(method);
        dsTaint.addTaint(url);
        WebAddress uri;
        uri = new WebAddress(url);
        RequestHandle var0CAAEFA32CFA1D659BB911931B630482_495737203 = (queueRequest(url, uri, method, headers, eventHandler,
                            bodyProvider, bodyLength));
        return (RequestHandle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //WebAddress uri = new WebAddress(url);
        //return queueRequest(url, uri, method, headers, eventHandler,
                            //bodyProvider, bodyLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.066 -0400", hash_original_method = "5EE74AB0AE90D0DA727E01E7B767B670", hash_generated_method = "A15153DA457BDCD26A3DAC887E9203DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequestHandle queueRequest(
            String url, WebAddress uri, String method, Map<String, String> headers,
            EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(eventHandler.dsTaint);
        dsTaint.addTaint(bodyProvider.dsTaint);
        dsTaint.addTaint(bodyLength);
        dsTaint.addTaint(method);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(url);
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
        RequestHandle varE0D8AFE581F0F0461478B29B4135BD99_2133911906 = (new RequestHandle(
                this, url, uri, method, headers, bodyProvider, bodyLength,
                req));
        return (RequestHandle)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.066 -0400", hash_original_method = "5ADB9D7A6CBFB38DBDB876B33452D400", hash_generated_method = "537AC13BEE73F1DBE0E6B8E5022AF602")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequestHandle queueSynchronousRequest(String url, WebAddress uri,
            String method, Map<String, String> headers,
            EventHandler eventHandler, InputStream bodyProvider,
            int bodyLength) {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(eventHandler.dsTaint);
        dsTaint.addTaint(bodyProvider.dsTaint);
        dsTaint.addTaint(bodyLength);
        dsTaint.addTaint(method);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(url);
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
        RequestHandle varF39FDB21E3190F65154062D7ED9DB7AF_1219640383 = (new RequestHandle(this, url, uri, method, headers, bodyProvider,
                bodyLength, req, conn));
        return (RequestHandle)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.067 -0400", hash_original_method = "19FC52B8DC895C49DAE0ECA4EB6CA639", hash_generated_method = "63F82E6E187928B763E14B5117B915E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HttpHost determineHost(HttpHost host) {
        dsTaint.addTaint(host.dsTaint);
        {
            boolean var45FD683D52967A3825FDE5FD66F77814_524758114 = ((mProxyHost == null || "https".equals(host.getSchemeName())));
        } //End flattened ternary
        return (HttpHost)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (mProxyHost == null || "https".equals(host.getSchemeName()))
                //? host : mProxyHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.067 -0400", hash_original_method = "EFE82EE341DC6BD22EFE3AAE27ABB231", hash_generated_method = "45AA08D13B95CF92A424106AFFE114AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized boolean requestsPending() {
        boolean var7133BF04DDB95C8FD1854EE006C98F4A_94050627 = (!mPending.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !mPending.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.067 -0400", hash_original_method = "5E944A5C3AFB2FB0842C37E33C83D8D2", hash_generated_method = "9DD496A1808B8EEBED394111AED4C2D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void dump() {
        HttpLog.v("dump()");
        StringBuilder dump;
        dump = new StringBuilder();
        int count;
        count = 0;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter;
        {
            boolean varE9BD97FE1B3E4E52EC25D85BE293A34F_1851584605 = (!mPending.isEmpty());
            {
                iter = mPending.entrySet().iterator();
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_513649798 = (iter.hasNext());
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
                            boolean var2F830C38CE34700FE85FC99A1EFA70EF_1154207236 = (iter.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.068 -0400", hash_original_method = "8F04B443A564D50EFFE076AEA97295A7", hash_generated_method = "8464DFE78D9B2DDBA4B09299A1E623D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Request getRequest() {
        Request ret;
        ret = null;
        {
            boolean varE9BD97FE1B3E4E52EC25D85BE293A34F_984629559 = (!mPending.isEmpty());
            {
                ret = removeFirst(mPending);
            } //End block
        } //End collapsed parenthetic
        HttpLog.v("RequestQueue.getRequest() => " + ret);
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Request ret = null;
        //if (!mPending.isEmpty()) {
            //ret = removeFirst(mPending);
        //}
        //if (HttpLog.LOGV) HttpLog.v("RequestQueue.getRequest() => " + ret);
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.068 -0400", hash_original_method = "871E1F4E9BD2BA7BA6F72CE2CEEFAC66", hash_generated_method = "9AD5F3029E31E7FF335A37CCF7403C28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Request getRequest(HttpHost host) {
        dsTaint.addTaint(host.dsTaint);
        Request ret;
        ret = null;
        {
            boolean varE7ABDF5A35A014790A801A2680C4A1A8_1695247818 = (mPending.containsKey(host));
            {
                LinkedList<Request> reqList;
                reqList = mPending.get(host);
                ret = reqList.removeFirst();
                {
                    boolean var4CB5D81D4471F38D594288457A576223_692455047 = (reqList.isEmpty());
                    {
                        mPending.remove(host);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        HttpLog.v("RequestQueue.getRequest(" + host + ") => " + ret);
        return (Request)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.068 -0400", hash_original_method = "A6996F44457236E27DB2C5C55302FCBE", hash_generated_method = "ADC470FD6D2097EBCB29C3C57B234199")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean haveRequest(HttpHost host) {
        dsTaint.addTaint(host.dsTaint);
        boolean var0F2263933ABF4CF4E5A684F5D02ACF6E_1679378782 = (mPending.containsKey(host));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPending.containsKey(host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.069 -0400", hash_original_method = "5DF1C437E9ED58A9D928A0798F1B9425", hash_generated_method = "0ADA9C2C4499FF5B0DC52C8BA2C39353")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requeueRequest(Request request) {
        dsTaint.addTaint(request.dsTaint);
        queueRequest(request, true);
        // ---------- Original Method ----------
        //queueRequest(request, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.069 -0400", hash_original_method = "36DEBCDEC4EFDB8CF8346CFD81066CDA", hash_generated_method = "305FCD4CBF7749B7023C16A68C3F0EFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdown() {
        mActivePool.shutdown();
        // ---------- Original Method ----------
        //mActivePool.shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.069 -0400", hash_original_method = "99743D8700F7CD0272109FAA55D49D1A", hash_generated_method = "9B96AEC9E2604035093EDA5747182298")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected synchronized void queueRequest(Request request, boolean head) {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(head);
        HttpHost host;
        host = request.mHost;
        host = request.mProxyHost;
        LinkedList<Request> reqList;
        {
            boolean varE7ABDF5A35A014790A801A2680C4A1A8_104524248 = (mPending.containsKey(host));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.070 -0400", hash_original_method = "D615BD22372BF27837008A0B674B3672", hash_generated_method = "68F8461F4FB60C27086B594BAC5A2D5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startTiming() {
        mActivePool.startTiming();
        // ---------- Original Method ----------
        //mActivePool.startTiming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.070 -0400", hash_original_method = "93BD6698DCB4A99EC2C52A706270C860", hash_generated_method = "79A321F150AAF5DF19960FC8264B094B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopTiming() {
        mActivePool.stopTiming();
        // ---------- Original Method ----------
        //mActivePool.stopTiming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.070 -0400", hash_original_method = "F363C5354CB9B81208E7FAC033526D24", hash_generated_method = "4867CB34C05826D01EBE9395A98ED4EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Request removeFirst(LinkedHashMap<HttpHost, LinkedList<Request>> requestQueue) {
        dsTaint.addTaint(requestQueue.dsTaint);
        Request ret;
        ret = null;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter;
        iter = requestQueue.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_154260304 = (iter.hasNext());
            {
                Map.Entry<HttpHost, LinkedList<Request>> entry;
                entry = iter.next();
                LinkedList<Request> reqList;
                reqList = entry.getValue();
                ret = reqList.removeFirst();
                {
                    boolean var4CB5D81D4471F38D594288457A576223_385658848 = (reqList.isEmpty());
                    {
                        requestQueue.remove(entry.getKey());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Request)dsTaint.getTaint();
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
        ConnectionThread[] mThreads;
        IdleCache mIdleCache;
        private int mTotalRequest;
        private int mTotalConnection;
        private int mConnectionCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.071 -0400", hash_original_method = "EC748BA333F005CC68E7979CEA362A8D", hash_generated_method = "B5A1F1E4085C5C978E0D014BC010826E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ActivePool(int connectionCount) {
            dsTaint.addTaint(connectionCount);
            mIdleCache = new IdleCache();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.071 -0400", hash_original_method = "1219F5054D15C8BA85E10250B0465A48", hash_generated_method = "1BB28F7E38886C3DBE5995B22251C175")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.071 -0400", hash_original_method = "3DBC0C51372089E9236025C3C2E89B00", hash_generated_method = "E82FFEBE61CA2E58FB3F0915D6F92AF2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.071 -0400", hash_original_method = "918E02281CDA2E4E4F9A4B76A9977FCD", hash_generated_method = "B72D0B456147230756E834C5843255B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startConnectionThread() {
            {
                Object varE793CDC2A4AC9B4DAF10C6DB63F4C18F_596334606 = (RequestQueue.this);
                {
                    RequestQueue.this.notify();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //synchronized (RequestQueue.this) {
                //RequestQueue.this.notify();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.072 -0400", hash_original_method = "D2A094DDB6185336258EAA22554B8B48", hash_generated_method = "C54585CFFBB2B71991366508D9BC4E00")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.072 -0400", hash_original_method = "24B30AFE4309F082BC585F8C48779E08", hash_generated_method = "9515CACA13243312FF76F6525D9F1CCA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.072 -0400", hash_original_method = "D3242BE060800C50D95BDC78717491BA", hash_generated_method = "24D243CD3D83957535E182E64D50C0C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.073 -0400", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "82A774F3BFB777AD63698CB0F1742A25")
        @DSModeled(DSC.SAFE)
        public HttpHost getProxyHost() {
            return (HttpHost)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mProxyHost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.073 -0400", hash_original_method = "0E1F656010AA811F93614A0AAB8C062E", hash_generated_method = "779113E9A71F4407FA3C3183C08BF088")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.073 -0400", hash_original_method = "4350BDA0BFA960DC6ECB5B267907B720", hash_generated_method = "515A1C0D1F61798EAB4B1B3580176BCC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ConnectionThread getThread(HttpHost host) {
            dsTaint.addTaint(host.dsTaint);
            {
                Object varE793CDC2A4AC9B4DAF10C6DB63F4C18F_1633407749 = (RequestQueue.this);
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
                                boolean var8E44A46CE9E7F837465A12630555EC7E_1285405553 = (connection != null && connection.mHost.equals(host));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return (ConnectionThread)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.074 -0400", hash_original_method = "FFEAD5D96A31C5526086E61D15C11F62", hash_generated_method = "1CD23CE476F32A44559158603CC66E80")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Connection getConnection(Context context, HttpHost host) {
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            host = RequestQueue.this.determineHost(host);
            Connection con;
            con = mIdleCache.getConnection(host);
            {
                con = Connection.getConnection(mContext, host, mProxyHost,
                        RequestQueue.this);
            } //End block
            return (Connection)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.074 -0400", hash_original_method = "3E0E4C6417BA7E6D1B1D779C38F1AA9A", hash_generated_method = "2C3986564DEB80873B44FBDDF9C2C6D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean recycleConnection(Connection connection) {
            dsTaint.addTaint(connection.dsTaint);
            boolean var4F646DF14443B5F9866FC8556E35664C_1129755617 = (mIdleCache.cacheConnection(connection.getHost(), connection));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIdleCache.cacheConnection(connection.getHost(), connection);
        }

        
    }


    
    private static class SyncFeeder implements RequestFeeder {
        private Request mRequest;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.074 -0400", hash_original_method = "4463F8298E503AEAFD22486DF3099826", hash_generated_method = "E6A6A8CDE9B9C9FF0F1FF74192A505FE")
        @DSModeled(DSC.SAFE)
         SyncFeeder() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.074 -0400", hash_original_method = "E0C38BA5AF5E9B7363BEA9E204F697F3", hash_generated_method = "CC9E867F22592DBCC5EB99ACAAD0987C")
        @DSModeled(DSC.SAFE)
        public Request getRequest() {
            Request r;
            r = mRequest;
            mRequest = null;
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Request r = mRequest;
            //mRequest = null;
            //return r;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.075 -0400", hash_original_method = "DE8B4E1CA9B86F476AFDBAF1FF7FD442", hash_generated_method = "7B7923A737AAB9F49DBEB411D0132FE0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Request getRequest(HttpHost host) {
            dsTaint.addTaint(host.dsTaint);
            Request var72FF1DECE169FF60D83CF09950F1E53B_2076196268 = (getRequest());
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getRequest();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.075 -0400", hash_original_method = "30BE3F23DCE5F30BFE4C540BF8AE4D20", hash_generated_method = "D2DBE403A2A34E0DED192BFB700CA277")
        @DSModeled(DSC.SAFE)
        public boolean haveRequest(HttpHost host) {
            dsTaint.addTaint(host.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mRequest != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.075 -0400", hash_original_method = "D0AA652C1F1A28EE12BADC892C348224", hash_generated_method = "A1F277B7A8806A4652E202FC726CEC5F")
        @DSModeled(DSC.SAFE)
        public void requeueRequest(Request r) {
            dsTaint.addTaint(r.dsTaint);
            // ---------- Original Method ----------
            //mRequest = r;
        }

        
    }


    
    interface ConnectionManager {
        HttpHost getProxyHost();
        Connection getConnection(Context context, HttpHost host);
        boolean recycleConnection(Connection connection);
    }
    
    private static final int CONNECTION_COUNT = 4;
}

