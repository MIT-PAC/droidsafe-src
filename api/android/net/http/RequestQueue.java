package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.673 -0400", hash_original_field = "8673F7F02EF7B3B9DEB1A224A23932BB", hash_generated_field = "1758DBA360E4E3B600ADDDCE5E66E218")

    private LinkedHashMap<HttpHost, LinkedList<Request>> mPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.674 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.674 -0400", hash_original_field = "9F8C80ADD03363D444D5DD543187AC5D", hash_generated_field = "7E2C9159191DF9FFA295FC8E90223677")

    private ActivePool mActivePool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.674 -0400", hash_original_field = "EB205FDB4F9378FA441222BF6F7ABE71", hash_generated_field = "7F6315533CCAF46DEA5C0B5CCAC3EBAB")

    private ConnectivityManager mConnectivityManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.674 -0400", hash_original_field = "4E55F1B55468F140FC44ACD1C350CF05", hash_generated_field = "99742757777505E14871D3515FDC7109")

    private HttpHost mProxyHost = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.674 -0400", hash_original_field = "6316EE14E7E9EE85C930ED2A15CC2BB7", hash_generated_field = "EAF3975B1E21B046C1D30C80F39B0ACA")

    private BroadcastReceiver mProxyChangeReceiver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.674 -0400", hash_original_method = "7E78DB3349CECCEABE79A47BDE45F2E4", hash_generated_method = "DDF29BFAAE46044224D6EEEA2BBC483F")
    public  RequestQueue(Context context) {
        this(context, CONNECTION_COUNT);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.675 -0400", hash_original_method = "A7CEC9D1667C71B6ADD3849E74F98CAD", hash_generated_method = "C4F46365E49B566B692619AA850CA5BF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.677 -0400", hash_original_method = "192F6D29BBECFA47E09E7D8D48EF8859", hash_generated_method = "594ACF5A0ECD5DFE13B98A64ACF9A22D")
    public synchronized void enablePlatformNotifications() {
    if(HttpLog.LOGV)        
        HttpLog.v("RequestQueue.enablePlatformNotifications() network");
    if(mProxyChangeReceiver == null)        
        {
            mProxyChangeReceiver =
                    new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.677 -0400", hash_original_method = "3CB2B7FAEA507C11972A385D868E1E52", hash_generated_method = "39B2053AFDC104DA6EED7A6360A4419B")
        @Override
        public void onReceive(Context ctx, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(ctx.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.677 -0400", hash_original_method = "B133918A77AADD577D84EC4FDA196DDC", hash_generated_method = "181E88C32E61E9366766F80CD603E4F1")
    public synchronized void disablePlatformNotifications() {
    if(HttpLog.LOGV)        
        HttpLog.v("RequestQueue.disablePlatformNotifications() network");
    if(mProxyChangeReceiver != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.678 -0400", hash_original_method = "381746B4CF404D7B9FDB43420AECD746", hash_generated_method = "AA0DEE308FC4D49B4E041CCBD7EC4FF6")
    private synchronized void setProxyConfig() {
        NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
    if(info != null && info.getType() == ConnectivityManager.TYPE_WIFI)        
        {
            mProxyHost = null;
        } //End block
        else
        {
            String host = Proxy.getHost(mContext);
    if(HttpLog.LOGV)            
            HttpLog.v("RequestQueue.setProxyConfig " + host);
    if(host == null)            
            {
                mProxyHost = null;
            } //End block
            else
            {
                mActivePool.disablePersistence();
                mProxyHost = new HttpHost(host, Proxy.getPort(mContext), "http");
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.678 -0400", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "084372DFE7CA0B56BF0EB5EF203AD846")
    public HttpHost getProxyHost() {
HttpHost var15255B0340E21149253E1579997EBD34_359031802 =         mProxyHost;
        var15255B0340E21149253E1579997EBD34_359031802.addTaint(taint);
        return var15255B0340E21149253E1579997EBD34_359031802;
        // ---------- Original Method ----------
        //return mProxyHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.679 -0400", hash_original_method = "D4465F27265450A81D8D5C54F66A3578", hash_generated_method = "220E522F762860FAFC965970F257FC67")
    public RequestHandle queueRequest(
            String url, String method,
            Map<String, String> headers, EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        addTaint(bodyLength);
        addTaint(bodyProvider.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(headers.getTaint());
        addTaint(method.getTaint());
        addTaint(url.getTaint());
        WebAddress uri = new WebAddress(url);
RequestHandle varDB478C081515AED8AECC176C7F352B76_1695290928 =         queueRequest(url, uri, method, headers, eventHandler,
                            bodyProvider, bodyLength);
        varDB478C081515AED8AECC176C7F352B76_1695290928.addTaint(taint);
        return varDB478C081515AED8AECC176C7F352B76_1695290928;
        // ---------- Original Method ----------
        //WebAddress uri = new WebAddress(url);
        //return queueRequest(url, uri, method, headers, eventHandler,
                            //bodyProvider, bodyLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.680 -0400", hash_original_method = "5EE74AB0AE90D0DA727E01E7B767B670", hash_generated_method = "E751576FE79ED5E5871A59A4937FB539")
    public RequestHandle queueRequest(
            String url, WebAddress uri, String method, Map<String, String> headers,
            EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        addTaint(bodyLength);
        addTaint(bodyProvider.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(headers.getTaint());
        addTaint(method.getTaint());
        addTaint(uri.getTaint());
        addTaint(url.getTaint());
    if(HttpLog.LOGV)        
        HttpLog.v("RequestQueue.queueRequest " + uri);
    if(eventHandler == null)        
        {
            eventHandler = new LoggingEventHandler();
        } //End block
        Request req;
        HttpHost httpHost = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        req = new Request(method, httpHost, mProxyHost, uri.getPath(), bodyProvider,
                          bodyLength, eventHandler, headers);
        queueRequest(req, false);
        mActivePool.mTotalRequest++;
        mActivePool.startConnectionThread();
RequestHandle var8559CD00D8E4603D5FEA793C2784B90A_534343132 =         new RequestHandle(
                this, url, uri, method, headers, bodyProvider, bodyLength,
                req);
        var8559CD00D8E4603D5FEA793C2784B90A_534343132.addTaint(taint);
        return var8559CD00D8E4603D5FEA793C2784B90A_534343132;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.680 -0400", hash_original_method = "5ADB9D7A6CBFB38DBDB876B33452D400", hash_generated_method = "4D357B7837BFE811EFD6D282D5907C8F")
    public RequestHandle queueSynchronousRequest(String url, WebAddress uri,
            String method, Map<String, String> headers,
            EventHandler eventHandler, InputStream bodyProvider,
            int bodyLength) {
        addTaint(bodyLength);
        addTaint(bodyProvider.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(headers.getTaint());
        addTaint(method.getTaint());
        addTaint(uri.getTaint());
        addTaint(url.getTaint());
    if(HttpLog.LOGV)        
        {
            HttpLog.v("RequestQueue.dispatchSynchronousRequest " + uri);
        } //End block
        HttpHost host = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        Request req = new Request(method, host, mProxyHost, uri.getPath(),
                bodyProvider, bodyLength, eventHandler, headers);
        host = determineHost(host);
        Connection conn = Connection.getConnection(mContext, host, mProxyHost,
                new SyncFeeder());
RequestHandle var918025ACFB3D287C100E8BF8D8B74BBF_1357878958 =         new RequestHandle(this, url, uri, method, headers, bodyProvider,
                bodyLength, req, conn);
        var918025ACFB3D287C100E8BF8D8B74BBF_1357878958.addTaint(taint);
        return var918025ACFB3D287C100E8BF8D8B74BBF_1357878958;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.681 -0400", hash_original_method = "19FC52B8DC895C49DAE0ECA4EB6CA639", hash_generated_method = "C81A703B5C7A46C130B6E410F29DDEA5")
    private HttpHost determineHost(HttpHost host) {
        addTaint(host.getTaint());
HttpHost var19C0EEEDCED1F1045F88B2BB828B81A8_2131477199 =         (mProxyHost == null || "https".equals(host.getSchemeName()))
                ? host : mProxyHost;
        var19C0EEEDCED1F1045F88B2BB828B81A8_2131477199.addTaint(taint);
        return var19C0EEEDCED1F1045F88B2BB828B81A8_2131477199;
        // ---------- Original Method ----------
        //return (mProxyHost == null || "https".equals(host.getSchemeName()))
                //? host : mProxyHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.681 -0400", hash_original_method = "EFE82EE341DC6BD22EFE3AAE27ABB231", hash_generated_method = "7857B8461799E1811A9A86073ACD29EB")
    synchronized boolean requestsPending() {
        boolean var2603AB3951DAB26BE16828FF1AEB90D2_1368849489 = (!mPending.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_450051394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_450051394;
        // ---------- Original Method ----------
        //return !mPending.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.681 -0400", hash_original_method = "5E944A5C3AFB2FB0842C37E33C83D8D2", hash_generated_method = "D4CF51E327DCBA3902760087C7F82492")
    synchronized void dump() {
        HttpLog.v("dump()");
        StringBuilder dump = new StringBuilder();
        int count = 0;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter;
    if(!mPending.isEmpty())        
        {
            iter = mPending.entrySet().iterator();
            while
(iter.hasNext())            
            {
                Map.Entry<HttpHost, LinkedList<Request>> entry = iter.next();
                String hostName = entry.getKey().getHostName();
                StringBuilder line = new StringBuilder("p" + count++ + " " + hostName + " ");
                LinkedList<Request> reqList = entry.getValue();
                ListIterator reqIter = reqList.listIterator(0);
                while
(iter.hasNext())                
                {
                    Request request = (Request)iter.next();
                    line.append(request + " ");
                } //End block
                dump.append(line);
                dump.append("\n");
            } //End block
        } //End block
        HttpLog.v(dump.toString());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.682 -0400", hash_original_method = "8F04B443A564D50EFFE076AEA97295A7", hash_generated_method = "68D1744B150C54AC8B63730C527D3676")
    public synchronized Request getRequest() {
        Request ret = null;
    if(!mPending.isEmpty())        
        {
            ret = removeFirst(mPending);
        } //End block
    if(HttpLog.LOGV)        
        HttpLog.v("RequestQueue.getRequest() => " + ret);
Request varEDFF4FBBF053B5DC2B444ADFA049EE0F_726015460 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_726015460.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_726015460;
        // ---------- Original Method ----------
        //Request ret = null;
        //if (!mPending.isEmpty()) {
            //ret = removeFirst(mPending);
        //}
        //if (HttpLog.LOGV) HttpLog.v("RequestQueue.getRequest() => " + ret);
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.682 -0400", hash_original_method = "871E1F4E9BD2BA7BA6F72CE2CEEFAC66", hash_generated_method = "C822BAB76E87F89E6C3A818AD1C6912C")
    public synchronized Request getRequest(HttpHost host) {
        addTaint(host.getTaint());
        Request ret = null;
    if(mPending.containsKey(host))        
        {
            LinkedList<Request> reqList = mPending.get(host);
            ret = reqList.removeFirst();
    if(reqList.isEmpty())            
            {
                mPending.remove(host);
            } //End block
        } //End block
    if(HttpLog.LOGV)        
        HttpLog.v("RequestQueue.getRequest(" + host + ") => " + ret);
Request varEDFF4FBBF053B5DC2B444ADFA049EE0F_972052173 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_972052173.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_972052173;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.683 -0400", hash_original_method = "A6996F44457236E27DB2C5C55302FCBE", hash_generated_method = "17253E194047F93460262EC2DA432A62")
    public synchronized boolean haveRequest(HttpHost host) {
        addTaint(host.getTaint());
        boolean varDAB11781A1423E90151BB1EE3CA90568_612466762 = (mPending.containsKey(host));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_499743903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_499743903;
        // ---------- Original Method ----------
        //return mPending.containsKey(host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.683 -0400", hash_original_method = "5DF1C437E9ED58A9D928A0798F1B9425", hash_generated_method = "0323CA7E82824397A6419D20C5A2C875")
    public void requeueRequest(Request request) {
        addTaint(request.getTaint());
        queueRequest(request, true);
        // ---------- Original Method ----------
        //queueRequest(request, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.683 -0400", hash_original_method = "36DEBCDEC4EFDB8CF8346CFD81066CDA", hash_generated_method = "305FCD4CBF7749B7023C16A68C3F0EFC")
    public void shutdown() {
        mActivePool.shutdown();
        // ---------- Original Method ----------
        //mActivePool.shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.684 -0400", hash_original_method = "99743D8700F7CD0272109FAA55D49D1A", hash_generated_method = "3B457BA9EC0B2C0EDE023D845A18E33F")
    protected synchronized void queueRequest(Request request, boolean head) {
        addTaint(head);
        addTaint(request.getTaint());
        HttpHost host = request.mProxyHost == null ? request.mHost : request.mProxyHost;
        LinkedList<Request> reqList;
    if(mPending.containsKey(host))        
        {
            reqList = mPending.get(host);
        } //End block
        else
        {
            reqList = new LinkedList<Request>();
            mPending.put(host, reqList);
        } //End block
    if(head)        
        {
            reqList.addFirst(request);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.684 -0400", hash_original_method = "D615BD22372BF27837008A0B674B3672", hash_generated_method = "68F8461F4FB60C27086B594BAC5A2D5C")
    public void startTiming() {
        mActivePool.startTiming();
        // ---------- Original Method ----------
        //mActivePool.startTiming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.684 -0400", hash_original_method = "93BD6698DCB4A99EC2C52A706270C860", hash_generated_method = "79A321F150AAF5DF19960FC8264B094B")
    public void stopTiming() {
        mActivePool.stopTiming();
        // ---------- Original Method ----------
        //mActivePool.stopTiming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.685 -0400", hash_original_method = "F363C5354CB9B81208E7FAC033526D24", hash_generated_method = "D675847D513141581729C6DEB371C3D5")
    private Request removeFirst(LinkedHashMap<HttpHost, LinkedList<Request>> requestQueue) {
        addTaint(requestQueue.getTaint());
        Request ret = null;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter = requestQueue.entrySet().iterator();
    if(iter.hasNext())        
        {
            Map.Entry<HttpHost, LinkedList<Request>> entry = iter.next();
            LinkedList<Request> reqList = entry.getValue();
            ret = reqList.removeFirst();
    if(reqList.isEmpty())            
            {
                requestQueue.remove(entry.getKey());
            } //End block
        } //End block
Request varEDFF4FBBF053B5DC2B444ADFA049EE0F_688352929 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_688352929.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_688352929;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.685 -0400", hash_original_field = "60138ABD5009ABCE16930B0D3EFB1698", hash_generated_field = "A911064E545F525658232640AFA7D0B9")

        ConnectionThread[] mThreads;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.685 -0400", hash_original_field = "BCC3AD91A8AEAB3BF27A9A0FF3DB98E2", hash_generated_field = "448266124930497935AABDA6EA3530AA")

        IdleCache mIdleCache;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.685 -0400", hash_original_field = "397ADEECCD7CDE5D457B08965AB7F279", hash_generated_field = "04EBA439DE54BE9E4E88BA35E3F14E1F")

        private int mTotalRequest;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.685 -0400", hash_original_field = "71A1084ED0F70B17E36C243F38A17E13", hash_generated_field = "75F51D982E39DA7109E095FB57E24560")

        private int mTotalConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.685 -0400", hash_original_field = "17F39E7D585A12BB1F9266F8CE91D153", hash_generated_field = "3B7FD818552FF5D0D780F585667ED47F")

        private int mConnectionCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.686 -0400", hash_original_method = "EC748BA333F005CC68E7979CEA362A8D", hash_generated_method = "C46BCCCE19D83A91CB1BF9ABA350389C")
          ActivePool(int connectionCount) {
            mIdleCache = new IdleCache();
            mConnectionCount = connectionCount;
            mThreads = new ConnectionThread[mConnectionCount];
for(int i = 0;i < mConnectionCount;i++)
            {
                mThreads[i] = new ConnectionThread(
                        mContext, i, this, RequestQueue.this);
            } //End block
            // ---------- Original Method ----------
            //mIdleCache = new IdleCache();
            //mConnectionCount = connectionCount;
            //mThreads = new ConnectionThread[mConnectionCount];
            //for (int i = 0; i < mConnectionCount; i++) {
                //mThreads[i] = new ConnectionThread(
                        //mContext, i, this, RequestQueue.this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.686 -0400", hash_original_method = "1219F5054D15C8BA85E10250B0465A48", hash_generated_method = "6D1048883FED29B08FB36DCECE80367F")
         void startup() {
for(int i = 0;i < mConnectionCount;i++)
            {
                mThreads[i].start();
            } //End block
            // ---------- Original Method ----------
            //for (int i = 0; i < mConnectionCount; i++) {
                //mThreads[i].start();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.687 -0400", hash_original_method = "3DBC0C51372089E9236025C3C2E89B00", hash_generated_method = "9F7383B45D7E3FCBF17E3D46BEDBADE2")
         void shutdown() {
for(int i = 0;i < mConnectionCount;i++)
            {
                mThreads[i].requestStop();
            } //End block
            // ---------- Original Method ----------
            //for (int i = 0; i < mConnectionCount; i++) {
                //mThreads[i].requestStop();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.687 -0400", hash_original_method = "918E02281CDA2E4E4F9A4B76A9977FCD", hash_generated_method = "749B486725B8DAA063F61BBB3EB7A76A")
         void startConnectionThread() {
            synchronized
(RequestQueue.this)            {
                RequestQueue.this.notify();
            } //End block
            // ---------- Original Method ----------
            //synchronized (RequestQueue.this) {
                //RequestQueue.this.notify();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.688 -0400", hash_original_method = "D2A094DDB6185336258EAA22554B8B48", hash_generated_method = "21E13D9D80F5B8BB04A4D522CD6332C3")
        public void startTiming() {
for(int i = 0;i < mConnectionCount;i++)
            {
                ConnectionThread rt = mThreads[i];
                rt.mCurrentThreadTime = -1;
                rt.mTotalThreadTime = 0;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.688 -0400", hash_original_method = "24B30AFE4309F082BC585F8C48779E08", hash_generated_method = "268B654B52A2ABD9F7EE8B5DD970C8CB")
        public void stopTiming() {
            int totalTime = 0;
for(int i = 0;i < mConnectionCount;i++)
            {
                ConnectionThread rt = mThreads[i];
    if(rt.mCurrentThreadTime != -1)                
                {
                    totalTime += rt.mTotalThreadTime;
                } //End block
                rt.mCurrentThreadTime = 0;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.689 -0400", hash_original_method = "D3242BE060800C50D95BDC78717491BA", hash_generated_method = "610B148FD859C984B153CB4209B6DA9F")
         void logState() {
            StringBuilder dump = new StringBuilder();
for(int i = 0;i < mConnectionCount;i++)
            {
                dump.append(mThreads[i] + "\n");
            } //End block
            HttpLog.v(dump.toString());
            // ---------- Original Method ----------
            //StringBuilder dump = new StringBuilder();
            //for (int i = 0; i < mConnectionCount; i++) {
                //dump.append(mThreads[i] + "\n");
            //}
            //HttpLog.v(dump.toString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.689 -0400", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "F6E17A7EA6301338AE3291B6EFF4E41F")
        public HttpHost getProxyHost() {
HttpHost var15255B0340E21149253E1579997EBD34_822075218 =             mProxyHost;
            var15255B0340E21149253E1579997EBD34_822075218.addTaint(taint);
            return var15255B0340E21149253E1579997EBD34_822075218;
            // ---------- Original Method ----------
            //return mProxyHost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.689 -0400", hash_original_method = "0E1F656010AA811F93614A0AAB8C062E", hash_generated_method = "ECC8AF705E85A64198AC334DEB1AB547")
         void disablePersistence() {
for(int i = 0;i < mConnectionCount;i++)
            {
                Connection connection = mThreads[i].mConnection;
    if(connection != null)                
                connection.setCanPersist(false);
            } //End block
            mIdleCache.clear();
            // ---------- Original Method ----------
            //for (int i = 0; i < mConnectionCount; i++) {
                //Connection connection = mThreads[i].mConnection;
                //if (connection != null) connection.setCanPersist(false);
            //}
            //mIdleCache.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.690 -0400", hash_original_method = "4350BDA0BFA960DC6ECB5B267907B720", hash_generated_method = "81EB16D3F08BC3017FE05791B3C39D36")
         ConnectionThread getThread(HttpHost host) {
            addTaint(host.getTaint());
            synchronized
(RequestQueue.this)            {
for(int i = 0;i < mThreads.length;i++)
                {
                    ConnectionThread ct = mThreads[i];
                    Connection connection = ct.mConnection;
    if(connection != null && connection.mHost.equals(host))                    
                    {
ConnectionThread varB6CBF65560612EA4D10B4B8A9201976F_1750286351 =                         ct;
                        varB6CBF65560612EA4D10B4B8A9201976F_1750286351.addTaint(taint);
                        return varB6CBF65560612EA4D10B4B8A9201976F_1750286351;
                    } //End block
                } //End block
            } //End block
ConnectionThread var540C13E9E156B687226421B24F2DF178_541950288 =             null;
            var540C13E9E156B687226421B24F2DF178_541950288.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_541950288;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.691 -0400", hash_original_method = "FFEAD5D96A31C5526086E61D15C11F62", hash_generated_method = "7BB212CCE69B2FB4E25DDABC5C41D582")
        public Connection getConnection(Context context, HttpHost host) {
            addTaint(host.getTaint());
            addTaint(context.getTaint());
            host = RequestQueue.this.determineHost(host);
            Connection con = mIdleCache.getConnection(host);
    if(con == null)            
            {
                mTotalConnection++;
                con = Connection.getConnection(mContext, host, mProxyHost,
                        RequestQueue.this);
            } //End block
Connection var8C72E06494C6F3A2714DD6C271334307_874088963 =             con;
            var8C72E06494C6F3A2714DD6C271334307_874088963.addTaint(taint);
            return var8C72E06494C6F3A2714DD6C271334307_874088963;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.692 -0400", hash_original_method = "3E0E4C6417BA7E6D1B1D779C38F1AA9A", hash_generated_method = "AE8C840B488766342BF9B252343322D2")
        public boolean recycleConnection(Connection connection) {
            addTaint(connection.getTaint());
            boolean varAB7EA3F212DBB7905E700DE869E9E595_1110766092 = (mIdleCache.cacheConnection(connection.getHost(), connection));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386837899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386837899;
            // ---------- Original Method ----------
            //return mIdleCache.cacheConnection(connection.getHost(), connection);
        }

        
    }


    
    private static class SyncFeeder implements RequestFeeder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.692 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

        private Request mRequest;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.692 -0400", hash_original_method = "4463F8298E503AEAFD22486DF3099826", hash_generated_method = "E6A6A8CDE9B9C9FF0F1FF74192A505FE")
          SyncFeeder() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.692 -0400", hash_original_method = "E0C38BA5AF5E9B7363BEA9E204F697F3", hash_generated_method = "676C8F60B0B045163F3733919BDC1C5F")
        public Request getRequest() {
            Request r = mRequest;
            mRequest = null;
Request var4C1F3C86A0E56B6E375080F5F710547E_882872732 =             r;
            var4C1F3C86A0E56B6E375080F5F710547E_882872732.addTaint(taint);
            return var4C1F3C86A0E56B6E375080F5F710547E_882872732;
            // ---------- Original Method ----------
            //Request r = mRequest;
            //mRequest = null;
            //return r;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.693 -0400", hash_original_method = "DE8B4E1CA9B86F476AFDBAF1FF7FD442", hash_generated_method = "E8ED40D5E3114FE69FF619FED7C16224")
        public Request getRequest(HttpHost host) {
            addTaint(host.getTaint());
Request var01ADE12A033EFEF3CBB95891FA1C0137_1970911134 =             getRequest();
            var01ADE12A033EFEF3CBB95891FA1C0137_1970911134.addTaint(taint);
            return var01ADE12A033EFEF3CBB95891FA1C0137_1970911134;
            // ---------- Original Method ----------
            //return getRequest();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.693 -0400", hash_original_method = "30BE3F23DCE5F30BFE4C540BF8AE4D20", hash_generated_method = "581B1602D239DBAC3822C08DA8D66ECC")
        public boolean haveRequest(HttpHost host) {
            addTaint(host.getTaint());
            boolean var0CCCD6C8160146A28E0277A86C41082D_298210427 = (mRequest != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_263856405 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_263856405;
            // ---------- Original Method ----------
            //return mRequest != null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.693 -0400", hash_original_method = "D0AA652C1F1A28EE12BADC892C348224", hash_generated_method = "0490D711BBE9F89E677FF31CE7FA801F")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.693 -0400", hash_original_field = "D46855AAE2E017E8DAECB4EE7F509FE5", hash_generated_field = "37BB035DE4DBFD177A6ADC5B8C105D95")

    private static final int CONNECTION_COUNT = 4;
}

