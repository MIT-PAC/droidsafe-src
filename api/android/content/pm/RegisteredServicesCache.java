package android.content.pm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;

import com.android.internal.os.AtomicFile;
import com.android.internal.util.FastXmlSerializer;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;






public abstract class RegisteredServicesCache<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.550 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "DE8577C1C990964647332D172A1FAC00")

    public Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.550 -0400", hash_original_field = "234538FD1AA7874AA9BF9A74C915B767", hash_generated_field = "B91D2FDD736D033C029D0603CE28FBCE")

    private String mInterfaceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.550 -0400", hash_original_field = "8BC81D2880C6CD7E31E637F74B0BA064", hash_generated_field = "C88ABD8EA4625ED773565A151DB8DE4F")

    private String mMetaDataName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.550 -0400", hash_original_field = "C76B08DE0209353DDF7319EC6A7EB3FA", hash_generated_field = "374C38096FB7BF7D602CD01609A2DAA2")

    private String mAttributesName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.550 -0400", hash_original_field = "847F2739E3E711FFCA1141D641686ACB", hash_generated_field = "AA271C9427511B8D13F10BA447FF9707")

    private XmlSerializerAndParser<V> mSerializerAndParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.550 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "08412B605BBED453196A027B12C1C901")

    private AtomicReference<BroadcastReceiver> mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.550 -0400", hash_original_field = "4C7B88166487ADA33722EB33BE7F1BA3", hash_generated_field = "7B88287937D2F8332B319EA97FDE5E9F")

    private final Object mServicesLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.551 -0400", hash_original_field = "1C789CA3285862B792BE459D4A7BFFB7", hash_generated_field = "7C9830B84CCB22FE7159A16CB3E4930F")

    private HashMap<V, Integer> mPersistentServices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.551 -0400", hash_original_field = "C0CCF58937AD4C0942DADD568B3D8426", hash_generated_field = "DCB3C355B6846AF6DF6115B3AE075C00")

    private Map<V, ServiceInfo<V>> mServices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.551 -0400", hash_original_field = "FF3387FD79B8747652A6B4DDB199BB60", hash_generated_field = "D5A26748B2EA05973DF9D609AA73C24C")

    private boolean mPersistentServicesFileDidNotExist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.551 -0400", hash_original_field = "5D71BE5CE04F6705CCE043C0E843BC9E", hash_generated_field = "7849E3F4879F6E3972ADF7CA59BBDAD5")

    private AtomicFile mPersistentServicesFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.551 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "7901EBDD1689EB7A4EBB997D88C95CD2")

    private RegisteredServicesCacheListener<V> mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.551 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.553 -0400", hash_original_method = "1931A7A6B7925D0DE2D2487C8FB155F2", hash_generated_method = "EDD12DA8E664BF69E295FD53796EDD52")
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
            @DSModeled(DSC.SPEC)
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.555 -0400", hash_original_method = "EB7158F459E2A057373DBB2E8C73133E", hash_generated_method = "D63E23565C71278CBC2105E7E4B25692")
    public void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(fout.getTaint());
        addTaint(fd.getTaint());
        Map<V, ServiceInfo<V>> services;
        synchronized
(mServicesLock)        {
            services = mServices;
        } //End block
        fout.println("RegisteredServicesCache: " + services.size() + " services");
for(ServiceInfo info : services.values())
        {
            fout.println("  " + info);
        } //End block
        // ---------- Original Method ----------
        //Map<V, ServiceInfo<V>> services;
        //synchronized (mServicesLock) {
            //services = mServices;
        //}
        //fout.println("RegisteredServicesCache: " + services.size() + " services");
        //for (ServiceInfo info : services.values()) {
            //fout.println("  " + info);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.556 -0400", hash_original_method = "D8F0001D796B123F3D4D73C4471FA428", hash_generated_method = "BE20450A7E4F9EB1D504FCA0BBF9884F")
    public RegisteredServicesCacheListener<V> getListener() {
        synchronized
(this)        {
RegisteredServicesCacheListener<V> varB7C366B3FCCD3E2168CA30DDDB430A4F_1005083335 =             mListener;
            varB7C366B3FCCD3E2168CA30DDDB430A4F_1005083335.addTaint(taint);
            return varB7C366B3FCCD3E2168CA30DDDB430A4F_1005083335;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mListener;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.557 -0400", hash_original_method = "C8A12F3C71D9DEAC88B94A90B0132AEE", hash_generated_method = "5E1D5051212EBB7B17A2E01D3087DA7D")
    public void setListener(RegisteredServicesCacheListener<V> listener, Handler handler) {
        if(handler == null)        
        {
            handler = new Handler(mContext.getMainLooper());
        } //End block
        synchronized
(this)        {
            mHandler = handler;
            mListener = listener;
        } //End block
        // ---------- Original Method ----------
        //if (handler == null) {
            //handler = new Handler(mContext.getMainLooper());
        //}
        //synchronized (this) {
            //mHandler = handler;
            //mListener = listener;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.558 -0400", hash_original_method = "06355F437BD90B9C1EBE1920422258C6", hash_generated_method = "570A6CA1BF9B367ED575445B1CFE8D8F")
    private void notifyListener(final V type, final boolean removed) {
        addTaint(removed);
        addTaint(type.getTaint());
        if(Log.isLoggable(TAG, Log.VERBOSE))        
        {
            Log.d(TAG, "notifyListener: " + type + " is " + (removed ? "removed" : "added"));
        } //End block
        RegisteredServicesCacheListener<V> listener;
        Handler handler;
        synchronized
(this)        {
            listener = mListener;
            handler = mHandler;
        } //End block
        if(listener == null)        
        {
            return;
        } //End block
        final RegisteredServicesCacheListener<V> listener2 = listener;
        handler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.558 -0400", hash_original_method = "895F39B4216C41C2813EBDFABEA40262", hash_generated_method = "2A8550E57F5B9632D66DC046840BC57C")
        public void run() {
            listener2.onServiceChanged(type, removed);
            // ---------- Original Method ----------
            //listener2.onServiceChanged(type, removed);
        }
});
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.VERBOSE)) {
            //Log.d(TAG, "notifyListener: " + type + " is " + (removed ? "removed" : "added"));
        //}
        //RegisteredServicesCacheListener<V> listener;
        //Handler handler;
        //synchronized (this) {
            //listener = mListener;
            //handler = mHandler;
        //}
        //if (listener == null) {
            //return;
        //}
        //final RegisteredServicesCacheListener<V> listener2 = listener;
        //handler.post(new Runnable() {
            //public void run() {
                //listener2.onServiceChanged(type, removed);
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.559 -0400", hash_original_method = "E22FC6668AC77A4961A8F001D76B9B4E", hash_generated_method = "925AC3DE48230E25D929077E3B39E811")
    public ServiceInfo<V> getServiceInfo(V type) {
        addTaint(type.getTaint());
        synchronized
(mServicesLock)        {
ServiceInfo<V> var17D506CF4FAD98387DEE85476DC28B5A_1846805569 =             mServices.get(type);
            var17D506CF4FAD98387DEE85476DC28B5A_1846805569.addTaint(taint);
            return var17D506CF4FAD98387DEE85476DC28B5A_1846805569;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mServicesLock) {
            //return mServices.get(type);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.560 -0400", hash_original_method = "314682D3D2B2D41D6F4464EB59320735", hash_generated_method = "4025D81F246A53A29E580AC5B12FC29A")
    public Collection<ServiceInfo<V>> getAllServices() {
        synchronized
(mServicesLock)        {
Collection<ServiceInfo<V>> var01EADE7461BB4905E6FEDFBECC0D286A_1586203734 =             Collections.unmodifiableCollection(mServices.values());
            var01EADE7461BB4905E6FEDFBECC0D286A_1586203734.addTaint(taint);
            return var01EADE7461BB4905E6FEDFBECC0D286A_1586203734;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mServicesLock) {
            //return Collections.unmodifiableCollection(mServices.values());
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.560 -0400", hash_original_method = "1776E8B4D21775792D782A371FDFF29B", hash_generated_method = "2140358EBF9B6CF521EC1F6B949CBD73")
    public void close() {
        final BroadcastReceiver receiver = mReceiver.getAndSet(null);
        if(receiver != null)        
        {
            mContext.unregisterReceiver(receiver);
        } //End block
        // ---------- Original Method ----------
        //final BroadcastReceiver receiver = mReceiver.getAndSet(null);
        //if (receiver != null) {
            //mContext.unregisterReceiver(receiver);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.561 -0400", hash_original_method = "675DD0BF255C7F4136F548B1BE5CB74C", hash_generated_method = "25A9A4B58434BD863E2C490BA5DB8F1B")
    @Override
    protected void finalize() throws Throwable {
        if(mReceiver.get() != null)        
        {
        } //End block
        close();
        super.finalize();
        // ---------- Original Method ----------
        //if (mReceiver.get() != null) {
            //Log.e(TAG, "RegisteredServicesCache finalized without being closed");
        //}
        //close();
        //super.finalize();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.561 -0400", hash_original_method = "30EEE88D5EBEE3E7BF1A3FE6896BBA6C", hash_generated_method = "E3A43A8B1B3814CE0A407DAB5EF1C7AD")
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
                    boolean varB326B5062B2F0E69046810717534CB09_731506848 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1894199294 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1894199294;
                } //End block
            } //End block
            catch (PackageManager.NameNotFoundException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1922456047 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63313131 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_63313131;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1867995927 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1347260097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1347260097;
        // ---------- Original Method ----------
        //String[] packages = mContext.getPackageManager().getPackagesForUid(callerUid);
        //for (String name : packages) {
            //try {
                //PackageInfo packageInfo =
                        //mContext.getPackageManager().getPackageInfo(name, 0 );
                //if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                    //return true;
                //}
            //} catch (PackageManager.NameNotFoundException e) {
                //return false;
            //}
        //}
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.564 -0400", hash_original_method = "7FD7D9F6A29EBA7075A2BE7C2AD27E68", hash_generated_method = "44DB6FEB9E3A22E5F8DCB6563D037A9D")
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
                } //End block
                serviceInfos.add(info);
            } //End block
            catch (XmlPullParserException e)
            {
            } //End block
            catch (IOException e)
            {
            } //End block
        } //End block
        synchronized
(mServicesLock)        {
            if(mPersistentServices == null)            
            {
                readPersistentServicesLocked();
            } //End block
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
                    } //End block
                } //End block
                else
                if(previousUid == info.uid)                
                {
                    if(Log.isLoggable(TAG, Log.VERBOSE))                    
                    {
                        changes.append("  Existing service (nop): ").append(info).append("\n");
                    } //End block
                    mServices.put(info.type, info);
                } //End block
                else
                if(inSystemImage(info.uid)
                        || !containsTypeAndUid(serviceInfos, info.type, previousUid))                
                {
                    if(inSystemImage(info.uid))                    
                    {
                        changes.append("  System service replacing existing: ").append(info)
                                .append("\n");
                    } //End block
                    else
                    {
                        changes.append("  Existing service replacing a removed service: ")
                                .append(info).append("\n");
                    } //End block
                    mServices.put(info.type, info);
                    mPersistentServices.put(info.type, info.uid);
                    notifyListener(info.type, false );
                } //End block
                else
                {
                    changes.append("  Existing service with new uid ignored: ").append(info)
                            .append("\n");
                } //End block
            } //End block
            ArrayList<V> toBeRemoved = Lists.newArrayList();
for(V v1 : mPersistentServices.keySet())
            {
                if(!containsType(serviceInfos, v1))                
                {
                    toBeRemoved.add(v1);
                } //End block
            } //End block
for(V v1 : toBeRemoved)
            {
                mPersistentServices.remove(v1);
                changes.append("  Service removed: ").append(v1).append("\n");
                notifyListener(v1, true );
            } //End block
            if(changes.length() > 0)            
            {
                Log.d(TAG, "generateServicesMap(" + mInterfaceName + "): " +
                        serviceInfos.size() + " services:\n" + changes);
                writePersistentServicesLocked();
            } //End block
            else
            {
                Log.d(TAG, "generateServicesMap(" + mInterfaceName + "): " +
                        serviceInfos.size() + " services unchanged");
            } //End block
            mPersistentServicesFileDidNotExist = false;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.567 -0400", hash_original_method = "45DA6CE662A637B1B0A1C5B390B75450", hash_generated_method = "A05EE2ADC7C0B4466367FAC11D9D64B2")
    private boolean containsType(ArrayList<ServiceInfo<V>> serviceInfos, V type) {
        addTaint(type.getTaint());
        addTaint(serviceInfos.getTaint());
for(int i = 0, N = serviceInfos.size();i < N;i++)
        {
            if(serviceInfos.get(i).type.equals(type))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_2136554047 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2023791838 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2023791838;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_173046119 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2066954773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2066954773;
        // ---------- Original Method ----------
        //for (int i = 0, N = serviceInfos.size(); i < N; i++) {
            //if (serviceInfos.get(i).type.equals(type)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.568 -0400", hash_original_method = "39F2D99D837C3B52D94DD556DC01CC72", hash_generated_method = "4EDC63F50677F92E2336BCCF856D5D63")
    private boolean containsTypeAndUid(ArrayList<ServiceInfo<V>> serviceInfos, V type, int uid) {
        addTaint(uid);
        addTaint(type.getTaint());
        addTaint(serviceInfos.getTaint());
for(int i = 0, N = serviceInfos.size();i < N;i++)
        {
            final ServiceInfo<V> serviceInfo = serviceInfos.get(i);
            if(serviceInfo.type.equals(type) && serviceInfo.uid == uid)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_324847473 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762724215 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_762724215;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_985279503 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059807577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059807577;
        // ---------- Original Method ----------
        //for (int i = 0, N = serviceInfos.size(); i < N; i++) {
            //final ServiceInfo<V> serviceInfo = serviceInfos.get(i);
            //if (serviceInfo.type.equals(type) && serviceInfo.uid == uid) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.572 -0400", hash_original_method = "05773225026B5770A572BEDCCA950685", hash_generated_method = "FBA8F7DA4DB9690BAD0A282362DE0F45")
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
                XmlPullParserException var95BB56C5DE56B4BDF53EBEFA6B676EBE_860583818 = new XmlPullParserException("No " + mMetaDataName + " meta-data");
                var95BB56C5DE56B4BDF53EBEFA6B676EBE_860583818.addTaint(taint);
                throw var95BB56C5DE56B4BDF53EBEFA6B676EBE_860583818;
            } //End block
            AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG)            
            {
            } //End block
            String nodeName = parser.getName();
            if(!mAttributesName.equals(nodeName))            
            {
                XmlPullParserException var8E5C999F953BBE8E0285A3211C1F9189_83189673 = new XmlPullParserException(
                        "Meta-data does not start with " + mAttributesName +  " tag");
                var8E5C999F953BBE8E0285A3211C1F9189_83189673.addTaint(taint);
                throw var8E5C999F953BBE8E0285A3211C1F9189_83189673;
            } //End block
            V v = parseServiceAttributes(pm.getResourcesForApplication(si.applicationInfo),
                    si.packageName, attrs);
            if(v == null)            
            {
ServiceInfo<V> var540C13E9E156B687226421B24F2DF178_1320156889 =                 null;
                var540C13E9E156B687226421B24F2DF178_1320156889.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1320156889;
            } //End block
            final android.content.pm.ServiceInfo serviceInfo = service.serviceInfo;
            final ApplicationInfo applicationInfo = serviceInfo.applicationInfo;
            final int uid = applicationInfo.uid;
ServiceInfo<V> var34F12F499D790BEB43A634C29A234DB8_1933099905 =             new ServiceInfo<V>(v, componentName, uid);
            var34F12F499D790BEB43A634C29A234DB8_1933099905.addTaint(taint);
            return var34F12F499D790BEB43A634C29A234DB8_1933099905;
        } //End block
        catch (NameNotFoundException e)
        {
            XmlPullParserException var4053B6FE06E8EE292A126000654E7DC8_453556035 = new XmlPullParserException(
                    "Unable to load resources for pacakge " + si.packageName);
            var4053B6FE06E8EE292A126000654E7DC8_453556035.addTaint(taint);
            throw var4053B6FE06E8EE292A126000654E7DC8_453556035;
        } //End block
        finally 
        {
            if(parser != null)            
            parser.close();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.577 -0400", hash_original_method = "AEFFF388F6549F52CCF36E0502C98B34", hash_generated_method = "3C7200E89B1FEDE25C0D2102CF801A1F")
    private void readPersistentServicesLocked() {
        mPersistentServices = Maps.newHashMap();
        if(mSerializerAndParser == null)        
        {
            return;
        } //End block
        FileInputStream fis = null;
        try 
        {
            mPersistentServicesFileDidNotExist = !mPersistentServicesFile.getBaseFile().exists();
            if(mPersistentServicesFileDidNotExist)            
            {
                return;
            } //End block
            fis = mPersistentServicesFile.openRead();
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(fis, null);
            int eventType = parser.getEventType();
            while
(eventType != XmlPullParser.START_TAG)            
            {
                eventType = parser.next();
            } //End block
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
                                } //End block
                                String uidString = parser.getAttributeValue(null, "uid");
                                int uid = Integer.parseInt(uidString);
                                mPersistentServices.put(service, uid);
                            } //End block
                        } //End block
                        eventType = parser.next();
                    } //End block
} while (eventType != XmlPullParser.END_DOCUMENT);
            } //End block
        } //End block
        catch (Exception e)
        {
        } //End block
        finally 
        {
            if(fis != null)            
            {
                try 
                {
                    fis.close();
                } //End block
                catch (java.io.IOException e1)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.580 -0400", hash_original_method = "EE98DCC48BA776AAD27AD82ED0CDBCAD", hash_generated_method = "B48FD1310EFCBD075BD6C7C79A42333B")
    private void writePersistentServicesLocked() {
        if(mSerializerAndParser == null)        
        {
            return;
        } //End block
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
            } //End block
            out.endTag(null, "services");
            out.endDocument();
            mPersistentServicesFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
            if(fos != null)            
            {
                mPersistentServicesFile.failWrite(fos);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract V parseServiceAttributes(Resources res,
            String packageName, AttributeSet attrs);

    
    public static class ServiceInfo<V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.583 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "1C0901F7CD197CB5951F2E539CF1A8AE")

        public V type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.583 -0400", hash_original_field = "FE439837C9D0340925B5F19E11F6264D", hash_generated_field = "98D1E72DA94B9A47D9FBC8AE55A2CAA0")

        public ComponentName componentName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.583 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.584 -0400", hash_original_method = "472602FD5FE378647A180CDF60A7A18E", hash_generated_method = "66D8FFD3C91D0CDC48CEBF75A2EFFF69")
        public  ServiceInfo(V type, ComponentName componentName, int uid) {
            this.type = type;
            this.componentName = componentName;
            this.uid = uid;
            // ---------- Original Method ----------
            //this.type = type;
            //this.componentName = componentName;
            //this.uid = uid;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.584 -0400", hash_original_method = "72B8806B88D8BA2A16DDBB10DB9489CE", hash_generated_method = "DC47EF4DC640B505D161840A9C55E448")
        @Override
        public String toString() {
String varC4E2D8367AC7DBE709E4A97317782E38_1992012315 =             "ServiceInfo: " + type + ", " + componentName + ", uid " + uid;
            varC4E2D8367AC7DBE709E4A97317782E38_1992012315.addTaint(taint);
            return varC4E2D8367AC7DBE709E4A97317782E38_1992012315;
            // ---------- Original Method ----------
            //return "ServiceInfo: " + type + ", " + componentName + ", uid " + uid;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.585 -0400", hash_original_field = "799B1C7045AB9A1990EA02A1923DD877", hash_generated_field = "E87B09140D2B39BDC1A082AB48B400E2")

    private static final String TAG = "PackageManager";
}

