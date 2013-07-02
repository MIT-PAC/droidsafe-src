package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.336 -0400", hash_original_field = "8673F7F02EF7B3B9DEB1A224A23932BB", hash_generated_field = "1758DBA360E4E3B600ADDDCE5E66E218")

    private LinkedHashMap<HttpHost, LinkedList<Request>> mPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.336 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.336 -0400", hash_original_field = "9F8C80ADD03363D444D5DD543187AC5D", hash_generated_field = "7E2C9159191DF9FFA295FC8E90223677")

    private ActivePool mActivePool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.336 -0400", hash_original_field = "EB205FDB4F9378FA441222BF6F7ABE71", hash_generated_field = "7F6315533CCAF46DEA5C0B5CCAC3EBAB")

    private ConnectivityManager mConnectivityManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.336 -0400", hash_original_field = "4E55F1B55468F140FC44ACD1C350CF05", hash_generated_field = "99742757777505E14871D3515FDC7109")

    private HttpHost mProxyHost = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.336 -0400", hash_original_field = "6316EE14E7E9EE85C930ED2A15CC2BB7", hash_generated_field = "EAF3975B1E21B046C1D30C80F39B0ACA")

    private BroadcastReceiver mProxyChangeReceiver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.337 -0400", hash_original_method = "7E78DB3349CECCEABE79A47BDE45F2E4", hash_generated_method = "DDF29BFAAE46044224D6EEEA2BBC483F")
    public  RequestQueue(Context context) {
        this(context, CONNECTION_COUNT);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.337 -0400", hash_original_method = "A7CEC9D1667C71B6ADD3849E74F98CAD", hash_generated_method = "C4F46365E49B566B692619AA850CA5BF")
    public  RequestQueue(Context context, int connectionCount) {
        mContext = context;
        mPending = new LinkedHashMap<HttpHost, LinkedList<Request>>(32);
        mActivePool = new ActivePool(connectionCount);
        mActivePool.startup();
        mConnectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        
        
        
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.338 -0400", hash_original_method = "192F6D29BBECFA47E09E7D8D48EF8859", hash_generated_method = "76FEDFB3372B70C8260AEFF8EB55F7A3")
    public synchronized void enablePlatformNotifications() {
        HttpLog.v("RequestQueue.enablePlatformNotifications() network");
        {
            mProxyChangeReceiver =
                    new BroadcastReceiver() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.338 -0400", hash_original_method = "3CB2B7FAEA507C11972A385D868E1E52", hash_generated_method = "50705C8A9D00ADEEB2A67E3959DD9EA8")
                @Override
                public void onReceive(Context ctx, Intent intent) {
                    
                    setProxyConfig();
                    addTaint(ctx.getTaint());
                    addTaint(intent.getTaint());
                    
                    
                }
};
            mContext.registerReceiver(mProxyChangeReceiver,
                                      new IntentFilter(Proxy.PROXY_CHANGE_ACTION));
        } 
        setProxyConfig();
        
        
        
            
                    
                        
                        
                            
                        
                    
            
                                      
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.338 -0400", hash_original_method = "B133918A77AADD577D84EC4FDA196DDC", hash_generated_method = "A37E9AEDA43DF86F46832B3F924735F1")
    public synchronized void disablePlatformNotifications() {
        HttpLog.v("RequestQueue.disablePlatformNotifications() network");
        {
            mContext.unregisterReceiver(mProxyChangeReceiver);
            mProxyChangeReceiver = null;
        } 
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.339 -0400", hash_original_method = "381746B4CF404D7B9FDB43420AECD746", hash_generated_method = "CD64FAE9321EC3B9C9BBBD7F4B0DE9BA")
    private synchronized void setProxyConfig() {
        NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
        {
            boolean var24FBA6C722421408BD9DC8A74F9723F7_497247293 = (info != null && info.getType() == ConnectivityManager.TYPE_WIFI);
            {
                mProxyHost = null;
            } 
            {
                String host = Proxy.getHost(mContext);
                HttpLog.v("RequestQueue.setProxyConfig " + host);
                {
                    mProxyHost = null;
                } 
                {
                    mActivePool.disablePersistence();
                    mProxyHost = new HttpHost(host, Proxy.getPort(mContext), "http");
                } 
            } 
        } 
        
        
        
            
        
            
            
            
                
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.340 -0400", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "D1F524E696F931CECE88102481354808")
    public HttpHost getProxyHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_1081479702 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1081479702 = mProxyHost;
        varB4EAC82CA7396A68D541C85D26508E83_1081479702.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1081479702;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.341 -0400", hash_original_method = "D4465F27265450A81D8D5C54F66A3578", hash_generated_method = "D71100226ED1300CA3ED03C5EE400945")
    public RequestHandle queueRequest(
            String url, String method,
            Map<String, String> headers, EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        RequestHandle varB4EAC82CA7396A68D541C85D26508E83_777518769 = null; 
        WebAddress uri = new WebAddress(url);
        varB4EAC82CA7396A68D541C85D26508E83_777518769 = queueRequest(url, uri, method, headers, eventHandler,
                            bodyProvider, bodyLength);
        addTaint(url.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        varB4EAC82CA7396A68D541C85D26508E83_777518769.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_777518769;
        
        
        
                            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.341 -0400", hash_original_method = "5EE74AB0AE90D0DA727E01E7B767B670", hash_generated_method = "E42DA219D7C6F3359AE49DB8F27368A7")
    public RequestHandle queueRequest(
            String url, WebAddress uri, String method, Map<String, String> headers,
            EventHandler eventHandler,
            InputStream bodyProvider, int bodyLength) {
        RequestHandle varB4EAC82CA7396A68D541C85D26508E83_1202445895 = null; 
        HttpLog.v("RequestQueue.queueRequest " + uri);
        {
            eventHandler = new LoggingEventHandler();
        } 
        Request req;
        HttpHost httpHost = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        req = new Request(method, httpHost, mProxyHost, uri.getPath(), bodyProvider,
                          bodyLength, eventHandler, headers);
        queueRequest(req, false);
        mActivePool.startConnectionThread();
        varB4EAC82CA7396A68D541C85D26508E83_1202445895 = new RequestHandle(
                this, url, uri, method, headers, bodyProvider, bodyLength,
                req);
        addTaint(url.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        varB4EAC82CA7396A68D541C85D26508E83_1202445895.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1202445895;
        
        
        
            
        
        
        
        
                          
        
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.342 -0400", hash_original_method = "5ADB9D7A6CBFB38DBDB876B33452D400", hash_generated_method = "2FBB1FD03D4B4F78B0345E3BF6A75253")
    public RequestHandle queueSynchronousRequest(String url, WebAddress uri,
            String method, Map<String, String> headers,
            EventHandler eventHandler, InputStream bodyProvider,
            int bodyLength) {
        RequestHandle varB4EAC82CA7396A68D541C85D26508E83_1084200540 = null; 
        {
            HttpLog.v("RequestQueue.dispatchSynchronousRequest " + uri);
        } 
        HttpHost host = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        Request req = new Request(method, host, mProxyHost, uri.getPath(),
                bodyProvider, bodyLength, eventHandler, headers);
        host = determineHost(host);
        Connection conn = Connection.getConnection(mContext, host, mProxyHost,
                new SyncFeeder());
        varB4EAC82CA7396A68D541C85D26508E83_1084200540 = new RequestHandle(this, url, uri, method, headers, bodyProvider,
                bodyLength, req, conn);
        addTaint(url.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(eventHandler.getTaint());
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        varB4EAC82CA7396A68D541C85D26508E83_1084200540.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1084200540;
        
        
            
        
        
        
                
        
        
                
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.343 -0400", hash_original_method = "19FC52B8DC895C49DAE0ECA4EB6CA639", hash_generated_method = "60EF57F53742A9E3DDEF6DB10A95341F")
    private HttpHost determineHost(HttpHost host) {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_490105118 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_490105118 = (mProxyHost == null || "https".equals(host.getSchemeName()))
                ? host : mProxyHost;
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_490105118.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_490105118;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.343 -0400", hash_original_method = "EFE82EE341DC6BD22EFE3AAE27ABB231", hash_generated_method = "49892FCEEA6FB988DC08DF2DC1CC6196")
    synchronized boolean requestsPending() {
        boolean var7133BF04DDB95C8FD1854EE006C98F4A_960655780 = (!mPending.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_979415553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_979415553;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.344 -0400", hash_original_method = "5E944A5C3AFB2FB0842C37E33C83D8D2", hash_generated_method = "7625A713B5BC90931CFAD875001249E6")
    synchronized void dump() {
        HttpLog.v("dump()");
        StringBuilder dump = new StringBuilder();
        int count = 0;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter;
        {
            boolean varE9BD97FE1B3E4E52EC25D85BE293A34F_1884792204 = (!mPending.isEmpty());
            {
                iter = mPending.entrySet().iterator();
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_2106251729 = (iter.hasNext());
                    {
                        Map.Entry<HttpHost, LinkedList<Request>> entry = iter.next();
                        String hostName = entry.getKey().getHostName();
                        StringBuilder line = new StringBuilder("p" + count++ + " " + hostName + " ");
                        LinkedList<Request> reqList = entry.getValue();
                        ListIterator reqIter = reqList.listIterator(0);
                        {
                            boolean var2F830C38CE34700FE85FC99A1EFA70EF_123228080 = (iter.hasNext());
                            {
                                Request request = (Request)iter.next();
                                line.append(request + " ");
                            } 
                        } 
                        dump.append(line);
                        dump.append("\n");
                    } 
                } 
            } 
        } 
        HttpLog.v(dump.toString());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.345 -0400", hash_original_method = "8F04B443A564D50EFFE076AEA97295A7", hash_generated_method = "2273C2ABB79D02E99684EBB4EABD673B")
    public synchronized Request getRequest() {
        Request varB4EAC82CA7396A68D541C85D26508E83_1943145871 = null; 
        Request ret = null;
        {
            boolean varE9BD97FE1B3E4E52EC25D85BE293A34F_1891824499 = (!mPending.isEmpty());
            {
                ret = removeFirst(mPending);
            } 
        } 
        HttpLog.v("RequestQueue.getRequest() => " + ret);
        varB4EAC82CA7396A68D541C85D26508E83_1943145871 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_1943145871.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1943145871;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.346 -0400", hash_original_method = "871E1F4E9BD2BA7BA6F72CE2CEEFAC66", hash_generated_method = "E7E9E5F925BCF4516A8FDA310FCCDDCE")
    public synchronized Request getRequest(HttpHost host) {
        Request varB4EAC82CA7396A68D541C85D26508E83_1476825780 = null; 
        Request ret = null;
        {
            boolean varE7ABDF5A35A014790A801A2680C4A1A8_1449677135 = (mPending.containsKey(host));
            {
                LinkedList<Request> reqList = mPending.get(host);
                ret = reqList.removeFirst();
                {
                    boolean var4CB5D81D4471F38D594288457A576223_2116886939 = (reqList.isEmpty());
                    {
                        mPending.remove(host);
                    } 
                } 
            } 
        } 
        HttpLog.v("RequestQueue.getRequest(" + host + ") => " + ret);
        varB4EAC82CA7396A68D541C85D26508E83_1476825780 = ret;
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1476825780.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1476825780;
        
        
        
            
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.346 -0400", hash_original_method = "A6996F44457236E27DB2C5C55302FCBE", hash_generated_method = "D22A90E745DF4769E48C9FE6E8A26535")
    public synchronized boolean haveRequest(HttpHost host) {
        boolean var0F2263933ABF4CF4E5A684F5D02ACF6E_1973822398 = (mPending.containsKey(host));
        addTaint(host.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1610930832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1610930832;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.346 -0400", hash_original_method = "5DF1C437E9ED58A9D928A0798F1B9425", hash_generated_method = "08E6B360C8DA7DA38817DD6704BA0DFA")
    public void requeueRequest(Request request) {
        queueRequest(request, true);
        addTaint(request.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.347 -0400", hash_original_method = "36DEBCDEC4EFDB8CF8346CFD81066CDA", hash_generated_method = "305FCD4CBF7749B7023C16A68C3F0EFC")
    public void shutdown() {
        mActivePool.shutdown();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.347 -0400", hash_original_method = "99743D8700F7CD0272109FAA55D49D1A", hash_generated_method = "CE754A62811DC0AB8CA03E0344AE90E1")
    protected synchronized void queueRequest(Request request, boolean head) {
        HttpHost host;
        host = request.mHost;
        host = request.mProxyHost;
        LinkedList<Request> reqList;
        {
            boolean varE7ABDF5A35A014790A801A2680C4A1A8_1027379063 = (mPending.containsKey(host));
            {
                reqList = mPending.get(host);
            } 
            {
                reqList = new LinkedList<Request>();
                mPending.put(host, reqList);
            } 
        } 
        {
            reqList.addFirst(request);
        } 
        {
            reqList.add(request);
        } 
        addTaint(request.getTaint());
        addTaint(head);
        
        
        
        
            
        
            
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.347 -0400", hash_original_method = "D615BD22372BF27837008A0B674B3672", hash_generated_method = "68F8461F4FB60C27086B594BAC5A2D5C")
    public void startTiming() {
        mActivePool.startTiming();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.348 -0400", hash_original_method = "93BD6698DCB4A99EC2C52A706270C860", hash_generated_method = "79A321F150AAF5DF19960FC8264B094B")
    public void stopTiming() {
        mActivePool.stopTiming();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.349 -0400", hash_original_method = "F363C5354CB9B81208E7FAC033526D24", hash_generated_method = "CAF6F88C6C542A90FBF839F4881CF651")
    private Request removeFirst(LinkedHashMap<HttpHost, LinkedList<Request>> requestQueue) {
        Request varB4EAC82CA7396A68D541C85D26508E83_1866987716 = null; 
        Request ret = null;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> iter = requestQueue.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_589845832 = (iter.hasNext());
            {
                Map.Entry<HttpHost, LinkedList<Request>> entry = iter.next();
                LinkedList<Request> reqList = entry.getValue();
                ret = reqList.removeFirst();
                {
                    boolean var4CB5D81D4471F38D594288457A576223_720626813 = (reqList.isEmpty());
                    {
                        requestQueue.remove(entry.getKey());
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1866987716 = ret;
        addTaint(requestQueue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1866987716.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1866987716;
        
        
        
        
            
            
            
            
                
            
        
        
    }

    
    class ActivePool implements ConnectionManager {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.349 -0400", hash_original_field = "60138ABD5009ABCE16930B0D3EFB1698", hash_generated_field = "A911064E545F525658232640AFA7D0B9")

        ConnectionThread[] mThreads;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.349 -0400", hash_original_field = "BCC3AD91A8AEAB3BF27A9A0FF3DB98E2", hash_generated_field = "448266124930497935AABDA6EA3530AA")

        IdleCache mIdleCache;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.349 -0400", hash_original_field = "397ADEECCD7CDE5D457B08965AB7F279", hash_generated_field = "04EBA439DE54BE9E4E88BA35E3F14E1F")

        private int mTotalRequest;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.349 -0400", hash_original_field = "71A1084ED0F70B17E36C243F38A17E13", hash_generated_field = "75F51D982E39DA7109E095FB57E24560")

        private int mTotalConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.349 -0400", hash_original_field = "17F39E7D585A12BB1F9266F8CE91D153", hash_generated_field = "3B7FD818552FF5D0D780F585667ED47F")

        private int mConnectionCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.350 -0400", hash_original_method = "EC748BA333F005CC68E7979CEA362A8D", hash_generated_method = "C8031DA7322322CAE4B92965188FAA47")
          ActivePool(int connectionCount) {
            mIdleCache = new IdleCache();
            mConnectionCount = connectionCount;
            mThreads = new ConnectionThread[mConnectionCount];
            {
                int i = 0;
                {
                    mThreads[i] = new ConnectionThread(
                        mContext, i, this, RequestQueue.this);
                } 
            } 
            
            
            
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.350 -0400", hash_original_method = "1219F5054D15C8BA85E10250B0465A48", hash_generated_method = "6BC70480EF5A48BBB40D99086BDD637E")
         void startup() {
            {
                int i = 0;
                {
                    mThreads[i].start();
                } 
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.351 -0400", hash_original_method = "3DBC0C51372089E9236025C3C2E89B00", hash_generated_method = "F7F417B425CD560532D0F08D4084B2A9")
         void shutdown() {
            {
                int i = 0;
                {
                    mThreads[i].requestStop();
                } 
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.352 -0400", hash_original_method = "918E02281CDA2E4E4F9A4B76A9977FCD", hash_generated_method = "E484D5C8C2B62B94CB097FD37716709E")
         void startConnectionThread() {
            {
                Object varE793CDC2A4AC9B4DAF10C6DB63F4C18F_484162854 = (RequestQueue.this);
                {
                    RequestQueue.this.notify();
                } 
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.353 -0400", hash_original_method = "D2A094DDB6185336258EAA22554B8B48", hash_generated_method = "8F0981B631F440E9FBD386E7A75F370F")
        public void startTiming() {
            {
                int i = 0;
                {
                    ConnectionThread rt = mThreads[i];
                    rt.mCurrentThreadTime = -1;
                    rt.mTotalThreadTime = 0;
                } 
            } 
            mTotalRequest = 0;
            mTotalConnection = 0;
            
            
                
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.353 -0400", hash_original_method = "24B30AFE4309F082BC585F8C48779E08", hash_generated_method = "D82CC963585A13D96B4D95519FB0AEC6")
        public void stopTiming() {
            int totalTime = 0;
            {
                int i = 0;
                {
                    ConnectionThread rt = mThreads[i];
                    {
                        totalTime += rt.mTotalThreadTime;
                    } 
                    rt.mCurrentThreadTime = 0;
                } 
            } 
            Log.d("Http", "Http thread used " + totalTime + " ms " + " for "
                    + mTotalRequest + " requests and " + mTotalConnection
                    + " new connections");
            
            
            
                
                
                    
                
                
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.354 -0400", hash_original_method = "D3242BE060800C50D95BDC78717491BA", hash_generated_method = "FB876A8B71D856957259FA7808FD728B")
         void logState() {
            StringBuilder dump = new StringBuilder();
            {
                int i = 0;
                {
                    dump.append(mThreads[i] + "\n");
                } 
            } 
            HttpLog.v(dump.toString());
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.354 -0400", hash_original_method = "36781366BC2C228EA97F354BC28E7BDA", hash_generated_method = "367E9611CC70D0B7CB274274CB5DB7D9")
        public HttpHost getProxyHost() {
            HttpHost varB4EAC82CA7396A68D541C85D26508E83_893076974 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_893076974 = mProxyHost;
            varB4EAC82CA7396A68D541C85D26508E83_893076974.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_893076974;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.355 -0400", hash_original_method = "0E1F656010AA811F93614A0AAB8C062E", hash_generated_method = "404F913249DC3E0287B849A16844AD40")
         void disablePersistence() {
            {
                int i = 0;
                {
                    Connection connection = mThreads[i].mConnection;
                    connection.setCanPersist(false);
                } 
            } 
            mIdleCache.clear();
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.355 -0400", hash_original_method = "4350BDA0BFA960DC6ECB5B267907B720", hash_generated_method = "0B481C083E9F6F4D92CD7974D3B626CA")
         ConnectionThread getThread(HttpHost host) {
            ConnectionThread varB4EAC82CA7396A68D541C85D26508E83_152523724 = null; 
            ConnectionThread varB4EAC82CA7396A68D541C85D26508E83_1484070703 = null; 
            {
                Object varE793CDC2A4AC9B4DAF10C6DB63F4C18F_700392559 = (RequestQueue.this);
                {
                    {
                        int i = 0;
                        {
                            ConnectionThread ct = mThreads[i];
                            Connection connection = ct.mConnection;
                            {
                                boolean var8E44A46CE9E7F837465A12630555EC7E_1848426044 = (connection != null && connection.mHost.equals(host));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_152523724 = ct;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1484070703 = null;
            addTaint(host.getTaint());
            ConnectionThread varA7E53CE21691AB073D9660D615818899_2038158987; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_2038158987 = varB4EAC82CA7396A68D541C85D26508E83_152523724;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2038158987 = varB4EAC82CA7396A68D541C85D26508E83_1484070703;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2038158987.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_2038158987;
            
            
                
                    
                    
                    
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.356 -0400", hash_original_method = "FFEAD5D96A31C5526086E61D15C11F62", hash_generated_method = "B1E466C3C515F77250B35836C19B33A3")
        public Connection getConnection(Context context, HttpHost host) {
            Connection varB4EAC82CA7396A68D541C85D26508E83_571829886 = null; 
            host = RequestQueue.this.determineHost(host);
            Connection con = mIdleCache.getConnection(host);
            {
                con = Connection.getConnection(mContext, host, mProxyHost,
                        RequestQueue.this);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_571829886 = con;
            addTaint(context.getTaint());
            addTaint(host.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_571829886.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_571829886;
            
            
            
            
                
                
                        
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.357 -0400", hash_original_method = "3E0E4C6417BA7E6D1B1D779C38F1AA9A", hash_generated_method = "683D7A73AD46F64D7080F2958A4E2EB3")
        public boolean recycleConnection(Connection connection) {
            boolean var4F646DF14443B5F9866FC8556E35664C_1312769965 = (mIdleCache.cacheConnection(connection.getHost(), connection));
            addTaint(connection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_569323155 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_569323155;
            
            
        }

        
    }


    
    private static class SyncFeeder implements RequestFeeder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.357 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

        private Request mRequest;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.357 -0400", hash_original_method = "4463F8298E503AEAFD22486DF3099826", hash_generated_method = "E6A6A8CDE9B9C9FF0F1FF74192A505FE")
          SyncFeeder() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.358 -0400", hash_original_method = "E0C38BA5AF5E9B7363BEA9E204F697F3", hash_generated_method = "775B69EAB26AB987768E0EE5B033EFD8")
        public Request getRequest() {
            Request varB4EAC82CA7396A68D541C85D26508E83_1904602906 = null; 
            Request r = mRequest;
            mRequest = null;
            varB4EAC82CA7396A68D541C85D26508E83_1904602906 = r;
            varB4EAC82CA7396A68D541C85D26508E83_1904602906.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1904602906;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.359 -0400", hash_original_method = "DE8B4E1CA9B86F476AFDBAF1FF7FD442", hash_generated_method = "29A2365F6BB9BCCB5640FA8F24A08A51")
        public Request getRequest(HttpHost host) {
            Request varB4EAC82CA7396A68D541C85D26508E83_2051391816 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2051391816 = getRequest();
            addTaint(host.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2051391816.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2051391816;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.359 -0400", hash_original_method = "30BE3F23DCE5F30BFE4C540BF8AE4D20", hash_generated_method = "DDC2BD9193F06E136813464E165E11E7")
        public boolean haveRequest(HttpHost host) {
            addTaint(host.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802048183 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802048183;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.359 -0400", hash_original_method = "D0AA652C1F1A28EE12BADC892C348224", hash_generated_method = "0490D711BBE9F89E677FF31CE7FA801F")
        public void requeueRequest(Request r) {
            mRequest = r;
            
            
        }

        
    }


    
    interface ConnectionManager {
        HttpHost getProxyHost();
        Connection getConnection(Context context, HttpHost host);
        boolean recycleConnection(Connection connection);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.360 -0400", hash_original_field = "D46855AAE2E017E8DAECB4EE7F509FE5", hash_generated_field = "37BB035DE4DBFD177A6ADC5B8C105D95")

    private static final int CONNECTION_COUNT = 4;
}

