package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ComponentName;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.util.AttributeSet;
import android.util.Xml;
import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import com.android.internal.os.AtomicFile;
import com.android.internal.util.FastXmlSerializer;
import com.google.android.collect.Maps;
import com.google.android.collect.Lists;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public abstract class RegisteredServicesCache<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.298 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "DE8577C1C990964647332D172A1FAC00")

    public Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.298 -0400", hash_original_field = "234538FD1AA7874AA9BF9A74C915B767", hash_generated_field = "B91D2FDD736D033C029D0603CE28FBCE")

    private String mInterfaceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.298 -0400", hash_original_field = "8BC81D2880C6CD7E31E637F74B0BA064", hash_generated_field = "C88ABD8EA4625ED773565A151DB8DE4F")

    private String mMetaDataName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.298 -0400", hash_original_field = "C76B08DE0209353DDF7319EC6A7EB3FA", hash_generated_field = "374C38096FB7BF7D602CD01609A2DAA2")

    private String mAttributesName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.299 -0400", hash_original_field = "847F2739E3E711FFCA1141D641686ACB", hash_generated_field = "AA271C9427511B8D13F10BA447FF9707")

    private XmlSerializerAndParser<V> mSerializerAndParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.299 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "08412B605BBED453196A027B12C1C901")

    private AtomicReference<BroadcastReceiver> mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.299 -0400", hash_original_field = "4C7B88166487ADA33722EB33BE7F1BA3", hash_generated_field = "7B88287937D2F8332B319EA97FDE5E9F")

    private final Object mServicesLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.299 -0400", hash_original_field = "1C789CA3285862B792BE459D4A7BFFB7", hash_generated_field = "7C9830B84CCB22FE7159A16CB3E4930F")

    private HashMap<V, Integer> mPersistentServices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.299 -0400", hash_original_field = "C0CCF58937AD4C0942DADD568B3D8426", hash_generated_field = "DCB3C355B6846AF6DF6115B3AE075C00")

    private Map<V, ServiceInfo<V>> mServices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.299 -0400", hash_original_field = "FF3387FD79B8747652A6B4DDB199BB60", hash_generated_field = "D5A26748B2EA05973DF9D609AA73C24C")

    private boolean mPersistentServicesFileDidNotExist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.299 -0400", hash_original_field = "5D71BE5CE04F6705CCE043C0E843BC9E", hash_generated_field = "7849E3F4879F6E3972ADF7CA59BBDAD5")

    private AtomicFile mPersistentServicesFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.299 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "7901EBDD1689EB7A4EBB997D88C95CD2")

    private RegisteredServicesCacheListener<V> mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.299 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.302 -0400", hash_original_method = "1931A7A6B7925D0DE2D2487C8FB155F2", hash_generated_method = "EDD12DA8E664BF69E295FD53796EDD52")
    public  RegisteredServicesCache(Context context, String interfaceName, String metaDataName,
            String attributeName, XmlSerializerAndParser<V> serializerAndParser) {
        mContext = context;
        mInterfaceName = interfaceName;
        mMetaDataName = metaDataName;
        mAttributesName = attributeName;
        mSerializerAndParser = serializerAndParser;
        File dataDir = Environment.getDataDirectory();
        File systemDir = new File(dataDir, "system");
        File syncDir = new File(systemDir, "registered_services");
        mPersistentServicesFile = new AtomicFile(new File(syncDir, interfaceName + ".xml"));
        generateServicesMap();
        final BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context1, Intent intent) {
                generateServicesMap();
            }
        };
        mReceiver = new AtomicReference<BroadcastReceiver>(receiver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_CHANGED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        intentFilter.addDataScheme("package");
        mContext.registerReceiver(receiver, intentFilter);
        IntentFilter sdFilter = new IntentFilter();
        sdFilter.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE);
        sdFilter.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE);
        mContext.registerReceiver(receiver, sdFilter);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.303 -0400", hash_original_method = "EB7158F459E2A057373DBB2E8C73133E", hash_generated_method = "D63E23565C71278CBC2105E7E4B25692")
    public void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(fout.getTaint());
        addTaint(fd.getTaint());
        Map<V, ServiceInfo<V>> services;
        synchronized
(mServicesLock)        {
            services = mServices;
        } 
        fout.println("RegisteredServicesCache: " + services.size() + " services");
for(ServiceInfo info : services.values())
        {
            fout.println("  " + info);
        } 
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.303 -0400", hash_original_method = "D8F0001D796B123F3D4D73C4471FA428", hash_generated_method = "89D3F4D6562D6A7723D6E301DDE02602")
    public RegisteredServicesCacheListener<V> getListener() {
        synchronized
(this)        {
RegisteredServicesCacheListener<V> varB7C366B3FCCD3E2168CA30DDDB430A4F_1127172539 =             mListener;
            varB7C366B3FCCD3E2168CA30DDDB430A4F_1127172539.addTaint(taint);
            return varB7C366B3FCCD3E2168CA30DDDB430A4F_1127172539;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.304 -0400", hash_original_method = "C8A12F3C71D9DEAC88B94A90B0132AEE", hash_generated_method = "5E1D5051212EBB7B17A2E01D3087DA7D")
    public void setListener(RegisteredServicesCacheListener<V> listener, Handler handler) {
    if(handler == null)        
        {
            handler = new Handler(mContext.getMainLooper());
        } 
        synchronized
(this)        {
            mHandler = handler;
            mListener = listener;
        } 
        
        
            
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.305 -0400", hash_original_method = "06355F437BD90B9C1EBE1920422258C6", hash_generated_method = "06ED244919B68CADB0FCF2BECEAAE642")
    private void notifyListener(final V type, final boolean removed) {
        addTaint(removed);
        addTaint(type.getTaint());
    if(Log.isLoggable(TAG, Log.VERBOSE))        
        {
            Log.d(TAG, "notifyListener: " + type + " is " + (removed ? "removed" : "added"));
        } 
        RegisteredServicesCacheListener<V> listener;
        Handler handler;
        synchronized
(this)        {
            listener = mListener;
            handler = mHandler;
        } 
    if(listener == null)        
        {
            return;
        } 
        final RegisteredServicesCacheListener<V> listener2 = listener;
        handler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.305 -0400", hash_original_method = "895F39B4216C41C2813EBDFABEA40262", hash_generated_method = "2A8550E57F5B9632D66DC046840BC57C")
        public void run() {
            listener2.onServiceChanged(type, removed);
            
            
        }
});
        
        
            
        
        
        
        
            
            
        
        
            
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.306 -0400", hash_original_method = "E22FC6668AC77A4961A8F001D76B9B4E", hash_generated_method = "9B642575404DE76A1EBF6263C639389D")
    public ServiceInfo<V> getServiceInfo(V type) {
        addTaint(type.getTaint());
        synchronized
(mServicesLock)        {
ServiceInfo<V> var17D506CF4FAD98387DEE85476DC28B5A_912680204 =             mServices.get(type);
            var17D506CF4FAD98387DEE85476DC28B5A_912680204.addTaint(taint);
            return var17D506CF4FAD98387DEE85476DC28B5A_912680204;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.306 -0400", hash_original_method = "314682D3D2B2D41D6F4464EB59320735", hash_generated_method = "9C7098D9018A278558D7422990720E70")
    public Collection<ServiceInfo<V>> getAllServices() {
        synchronized
(mServicesLock)        {
Collection<ServiceInfo<V>> var01EADE7461BB4905E6FEDFBECC0D286A_1055063893 =             Collections.unmodifiableCollection(mServices.values());
            var01EADE7461BB4905E6FEDFBECC0D286A_1055063893.addTaint(taint);
            return var01EADE7461BB4905E6FEDFBECC0D286A_1055063893;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.307 -0400", hash_original_method = "1776E8B4D21775792D782A371FDFF29B", hash_generated_method = "2140358EBF9B6CF521EC1F6B949CBD73")
    public void close() {
        final BroadcastReceiver receiver = mReceiver.getAndSet(null);
    if(receiver != null)        
        {
            mContext.unregisterReceiver(receiver);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.307 -0400", hash_original_method = "675DD0BF255C7F4136F548B1BE5CB74C", hash_generated_method = "25A9A4B58434BD863E2C490BA5DB8F1B")
    @Override
    protected void finalize() throws Throwable {
    if(mReceiver.get() != null)        
        {
        } 
        close();
        super.finalize();
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.308 -0400", hash_original_method = "30EEE88D5EBEE3E7BF1A3FE6896BBA6C", hash_generated_method = "440CC14BFCA00208D4860418D436EF4F")
    private boolean inSystemImage(int callerUid) {
        addTaint(callerUid);
        String[] packages = mContext.getPackageManager().getPackagesForUid(callerUid);
for(String name : packages)
        {
            try 
            {
                PackageInfo packageInfo = mContext.getPackageManager().getPackageInfo(name, 0 );
    if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_241611383 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351253747 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_351253747;
                } 
            } 
            catch (PackageManager.NameNotFoundException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1143900197 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1959158653 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1959158653;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_770747462 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809983860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809983860;
        
        
        
            
                
                        
                
                    
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.309 -0400", hash_original_method = "7FD7D9F6A29EBA7075A2BE7C2AD27E68", hash_generated_method = "44DB6FEB9E3A22E5F8DCB6563D037A9D")
     void generateServicesMap() {
        PackageManager pm = mContext.getPackageManager();
        ArrayList<ServiceInfo<V>> serviceInfos = new ArrayList<ServiceInfo<V>>();
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(new Intent(mInterfaceName),
                PackageManager.GET_META_DATA);
for(ResolveInfo resolveInfo : resolveInfos)
        {
            try 
            {
                ServiceInfo<V> info = parseServiceInfo(resolveInfo);
    if(info == null)                
                {
                    continue;
                } 
                serviceInfos.add(info);
            } 
            catch (XmlPullParserException e)
            {
            } 
            catch (IOException e)
            {
            } 
        } 
        synchronized
(mServicesLock)        {
    if(mPersistentServices == null)            
            {
                readPersistentServicesLocked();
            } 
            mServices = Maps.newHashMap();
            StringBuilder changes = new StringBuilder();
for(ServiceInfo<V> info : serviceInfos)
            {
                Integer previousUid = mPersistentServices.get(info.type);
    if(previousUid == null)                
                {
                    changes.append("  New service added: ").append(info).append("\n");
                    mServices.put(info.type, info);
                    mPersistentServices.put(info.type, info.uid);
    if(!mPersistentServicesFileDidNotExist)                    
                    {
                        notifyListener(info.type, false );
                    } 
                } 
                else
    if(previousUid == info.uid)                
                {
    if(Log.isLoggable(TAG, Log.VERBOSE))                    
                    {
                        changes.append("  Existing service (nop): ").append(info).append("\n");
                    } 
                    mServices.put(info.type, info);
                } 
                else
    if(inSystemImage(info.uid)
                        || !containsTypeAndUid(serviceInfos, info.type, previousUid))                
                {
    if(inSystemImage(info.uid))                    
                    {
                        changes.append("  System service replacing existing: ").append(info)
                                .append("\n");
                    } 
                    else
                    {
                        changes.append("  Existing service replacing a removed service: ")
                                .append(info).append("\n");
                    } 
                    mServices.put(info.type, info);
                    mPersistentServices.put(info.type, info.uid);
                    notifyListener(info.type, false );
                } 
                else
                {
                    changes.append("  Existing service with new uid ignored: ").append(info)
                            .append("\n");
                } 
            } 
            ArrayList<V> toBeRemoved = Lists.newArrayList();
for(V v1 : mPersistentServices.keySet())
            {
    if(!containsType(serviceInfos, v1))                
                {
                    toBeRemoved.add(v1);
                } 
            } 
for(V v1 : toBeRemoved)
            {
                mPersistentServices.remove(v1);
                changes.append("  Service removed: ").append(v1).append("\n");
                notifyListener(v1, true );
            } 
    if(changes.length() > 0)            
            {
                Log.d(TAG, "generateServicesMap(" + mInterfaceName + "): " +
                        serviceInfos.size() + " services:\n" + changes);
                writePersistentServicesLocked();
            } 
            else
            {
                Log.d(TAG, "generateServicesMap(" + mInterfaceName + "): " +
                        serviceInfos.size() + " services unchanged");
            } 
            mPersistentServicesFileDidNotExist = false;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.311 -0400", hash_original_method = "45DA6CE662A637B1B0A1C5B390B75450", hash_generated_method = "98E9C271EB735F96D7EB093A8AFE81BC")
    private boolean containsType(ArrayList<ServiceInfo<V>> serviceInfos, V type) {
        addTaint(type.getTaint());
        addTaint(serviceInfos.getTaint());
for(int i = 0, N = serviceInfos.size();i < N;i++)
        {
    if(serviceInfos.get(i).type.equals(type))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1112860063 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_778082936 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_778082936;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1234799973 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387789143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_387789143;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.312 -0400", hash_original_method = "39F2D99D837C3B52D94DD556DC01CC72", hash_generated_method = "968A4278EE0F570D4D3E45F3DB4F6DFA")
    private boolean containsTypeAndUid(ArrayList<ServiceInfo<V>> serviceInfos, V type, int uid) {
        addTaint(uid);
        addTaint(type.getTaint());
        addTaint(serviceInfos.getTaint());
for(int i = 0, N = serviceInfos.size();i < N;i++)
        {
            final ServiceInfo<V> serviceInfo = serviceInfos.get(i);
    if(serviceInfo.type.equals(type) && serviceInfo.uid == uid)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1736112450 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495731628 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_495731628;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1850856783 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398235120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398235120;
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.314 -0400", hash_original_method = "05773225026B5770A572BEDCCA950685", hash_generated_method = "F7D1548799A3A2E67BC95649E6D6FE7C")
    private ServiceInfo<V> parseServiceInfo(ResolveInfo service) throws XmlPullParserException, IOException {
        addTaint(service.getTaint());
        android.content.pm.ServiceInfo si = service.serviceInfo;
        ComponentName componentName = new ComponentName(si.packageName, si.name);
        PackageManager pm = mContext.getPackageManager();
        XmlResourceParser parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, mMetaDataName);
    if(parser == null)            
            {
                XmlPullParserException var95BB56C5DE56B4BDF53EBEFA6B676EBE_324550711 = new XmlPullParserException("No " + mMetaDataName + " meta-data");
                var95BB56C5DE56B4BDF53EBEFA6B676EBE_324550711.addTaint(taint);
                throw var95BB56C5DE56B4BDF53EBEFA6B676EBE_324550711;
            } 
            AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG)            
            {
            } 
            String nodeName = parser.getName();
    if(!mAttributesName.equals(nodeName))            
            {
                XmlPullParserException var8E5C999F953BBE8E0285A3211C1F9189_576581430 = new XmlPullParserException(
                        "Meta-data does not start with " + mAttributesName +  " tag");
                var8E5C999F953BBE8E0285A3211C1F9189_576581430.addTaint(taint);
                throw var8E5C999F953BBE8E0285A3211C1F9189_576581430;
            } 
            V v = parseServiceAttributes(pm.getResourcesForApplication(si.applicationInfo),
                    si.packageName, attrs);
    if(v == null)            
            {
ServiceInfo<V> var540C13E9E156B687226421B24F2DF178_1520700474 =                 null;
                var540C13E9E156B687226421B24F2DF178_1520700474.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1520700474;
            } 
            final android.content.pm.ServiceInfo serviceInfo = service.serviceInfo;
            final ApplicationInfo applicationInfo = serviceInfo.applicationInfo;
            final int uid = applicationInfo.uid;
ServiceInfo<V> var34F12F499D790BEB43A634C29A234DB8_834937039 =             new ServiceInfo<V>(v, componentName, uid);
            var34F12F499D790BEB43A634C29A234DB8_834937039.addTaint(taint);
            return var34F12F499D790BEB43A634C29A234DB8_834937039;
        } 
        catch (NameNotFoundException e)
        {
            XmlPullParserException var4053B6FE06E8EE292A126000654E7DC8_2081263244 = new XmlPullParserException(
                    "Unable to load resources for pacakge " + si.packageName);
            var4053B6FE06E8EE292A126000654E7DC8_2081263244.addTaint(taint);
            throw var4053B6FE06E8EE292A126000654E7DC8_2081263244;
        } 
        finally 
        {
    if(parser != null)            
            parser.close();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.315 -0400", hash_original_method = "AEFFF388F6549F52CCF36E0502C98B34", hash_generated_method = "3C7200E89B1FEDE25C0D2102CF801A1F")
    private void readPersistentServicesLocked() {
        mPersistentServices = Maps.newHashMap();
    if(mSerializerAndParser == null)        
        {
            return;
        } 
        FileInputStream fis = null;
        try 
        {
            mPersistentServicesFileDidNotExist = !mPersistentServicesFile.getBaseFile().exists();
    if(mPersistentServicesFileDidNotExist)            
            {
                return;
            } 
            fis = mPersistentServicesFile.openRead();
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(fis, null);
            int eventType = parser.getEventType();
            while
(eventType != XmlPullParser.START_TAG)            
            {
                eventType = parser.next();
            } 
            String tagName = parser.getName();
    if("services".equals(tagName))            
            {
                eventType = parser.next();
                do {
                    {
    if(eventType == XmlPullParser.START_TAG && parser.getDepth() == 2)                        
                        {
                            tagName = parser.getName();
    if("service".equals(tagName))                            
                            {
                                V service = mSerializerAndParser.createFromXml(parser);
    if(service == null)                                
                                {
                                    break;
                                } 
                                String uidString = parser.getAttributeValue(null, "uid");
                                int uid = Integer.parseInt(uidString);
                                mPersistentServices.put(service, uid);
                            } 
                        } 
                        eventType = parser.next();
                    } 
} while (eventType != XmlPullParser.END_DOCUMENT);
            } 
        } 
        catch (Exception e)
        {
        } 
        finally 
        {
    if(fis != null)            
            {
                try 
                {
                    fis.close();
                } 
                catch (java.io.IOException e1)
                {
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.317 -0400", hash_original_method = "EE98DCC48BA776AAD27AD82ED0CDBCAD", hash_generated_method = "B48FD1310EFCBD075BD6C7C79A42333B")
    private void writePersistentServicesLocked() {
    if(mSerializerAndParser == null)        
        {
            return;
        } 
        FileOutputStream fos = null;
        try 
        {
            fos = mPersistentServicesFile.startWrite();
            XmlSerializer out = new FastXmlSerializer();
            out.setOutput(fos, "utf-8");
            out.startDocument(null, true);
            out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            out.startTag(null, "services");
for(Map.Entry<V, Integer> service : mPersistentServices.entrySet())
            {
                out.startTag(null, "service");
                out.attribute(null, "uid", Integer.toString(service.getValue()));
                mSerializerAndParser.writeAsXml(service.getKey(), out);
                out.endTag(null, "service");
            } 
            out.endTag(null, "services");
            out.endDocument();
            mPersistentServicesFile.finishWrite(fos);
        } 
        catch (java.io.IOException e1)
        {
    if(fos != null)            
            {
                mPersistentServicesFile.failWrite(fos);
            } 
        } 
        
        
    }

    
    public abstract V parseServiceAttributes(Resources res,
            String packageName, AttributeSet attrs);

    
    public static class ServiceInfo<V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.317 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "1C0901F7CD197CB5951F2E539CF1A8AE")

        public V type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.317 -0400", hash_original_field = "FE439837C9D0340925B5F19E11F6264D", hash_generated_field = "98D1E72DA94B9A47D9FBC8AE55A2CAA0")

        public ComponentName componentName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.317 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.318 -0400", hash_original_method = "472602FD5FE378647A180CDF60A7A18E", hash_generated_method = "66D8FFD3C91D0CDC48CEBF75A2EFFF69")
        public  ServiceInfo(V type, ComponentName componentName, int uid) {
            this.type = type;
            this.componentName = componentName;
            this.uid = uid;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.318 -0400", hash_original_method = "72B8806B88D8BA2A16DDBB10DB9489CE", hash_generated_method = "C2BDEB9FD77A1DAF9A297F438DB51824")
        @Override
        public String toString() {
String varC4E2D8367AC7DBE709E4A97317782E38_1785173697 =             "ServiceInfo: " + type + ", " + componentName + ", uid " + uid;
            varC4E2D8367AC7DBE709E4A97317782E38_1785173697.addTaint(taint);
            return varC4E2D8367AC7DBE709E4A97317782E38_1785173697;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.319 -0400", hash_original_field = "799B1C7045AB9A1990EA02A1923DD877", hash_generated_field = "E87B09140D2B39BDC1A082AB48B400E2")

    private static final String TAG = "PackageManager";
}

