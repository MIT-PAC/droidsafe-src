package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    public Context mContext;
    private String mInterfaceName;
    private String mMetaDataName;
    private String mAttributesName;
    private XmlSerializerAndParser<V> mSerializerAndParser;
    private AtomicReference<BroadcastReceiver> mReceiver;
    private Object mServicesLock = new Object();
    private HashMap<V, Integer> mPersistentServices;
    private Map<V, ServiceInfo<V>> mServices;
    private boolean mPersistentServicesFileDidNotExist;
    private AtomicFile mPersistentServicesFile;
    private RegisteredServicesCacheListener<V> mListener;
    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.802 -0400", hash_original_method = "1931A7A6B7925D0DE2D2487C8FB155F2", hash_generated_method = "BDD2DB2A386C7AD6BAF98D9E6F28560E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RegisteredServicesCache(Context context, String interfaceName, String metaDataName,
            String attributeName, XmlSerializerAndParser<V> serializerAndParser) {
        dsTaint.addTaint(attributeName);
        dsTaint.addTaint(interfaceName);
        dsTaint.addTaint(metaDataName);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(serializerAndParser.dsTaint);
        File dataDir;
        dataDir = Environment.getDataDirectory();
        File systemDir;
        systemDir = new File(dataDir, "system");
        File syncDir;
        syncDir = new File(systemDir, "registered_services");
        mPersistentServicesFile = new AtomicFile(new File(syncDir, interfaceName + ".xml"));
        generateServicesMap();
        BroadcastReceiver receiver;
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context1, Intent intent) {
                generateServicesMap();
            }
        };
        mReceiver = new AtomicReference<BroadcastReceiver>(receiver);
        IntentFilter intentFilter;
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_CHANGED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        intentFilter.addDataScheme("package");
        mContext.registerReceiver(receiver, intentFilter);
        IntentFilter sdFilter;
        sdFilter = new IntentFilter();
        sdFilter.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE);
        sdFilter.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE);
        mContext.registerReceiver(receiver, sdFilter);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.807 -0400", hash_original_method = "EB7158F459E2A057373DBB2E8C73133E", hash_generated_method = "1C9C5113B34F6C9BAB8BDE9F97A0CA40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        dsTaint.addTaint(fout.dsTaint);
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        Map<V, ServiceInfo<V>> services;
        {
            services = mServices;
        } //End block
        fout.println("RegisteredServicesCache: " + services.size() + " services");
        {
            Iterator<ServiceInfo> var7025787026F785F48DDDCE829924C4A1_556633636 = (services.values()).iterator();
            var7025787026F785F48DDDCE829924C4A1_556633636.hasNext();
            ServiceInfo info = var7025787026F785F48DDDCE829924C4A1_556633636.next();
            {
                fout.println("  " + info);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.808 -0400", hash_original_method = "D8F0001D796B123F3D4D73C4471FA428", hash_generated_method = "995C28B16A6EA79BBDE4819C8A3260A1")
    @DSModeled(DSC.SAFE)
    public RegisteredServicesCacheListener<V> getListener() {
        return (RegisteredServicesCacheListener<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mListener;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.808 -0400", hash_original_method = "C8A12F3C71D9DEAC88B94A90B0132AEE", hash_generated_method = "C7B445A7296F665A96FA596EC1AA28FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setListener(RegisteredServicesCacheListener<V> listener, Handler handler) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        {
            handler = new Handler(mContext.getMainLooper());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.809 -0400", hash_original_method = "06355F437BD90B9C1EBE1920422258C6", hash_generated_method = "D6F0251CAF38B99CF6AED21CC012BCC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyListener(final V type, final boolean removed) {
        dsTaint.addTaint(removed);
        dsTaint.addTaint(type.dsTaint);
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_1378806802 = (Log.isLoggable(TAG, Log.VERBOSE));
            {
                Log.d(TAG, "notifyListener: " + type + " is " + (removed ? "removed" : "added"));
            } //End block
        } //End collapsed parenthetic
        RegisteredServicesCacheListener<V> listener;
        Handler handler;
        {
            listener = mListener;
            handler = mHandler;
        } //End block
        RegisteredServicesCacheListener<V> listener2;
        listener2 = listener;
        handler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.808 -0400", hash_original_method = "895F39B4216C41C2813EBDFABEA40262", hash_generated_method = "2A8550E57F5B9632D66DC046840BC57C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.809 -0400", hash_original_method = "E22FC6668AC77A4961A8F001D76B9B4E", hash_generated_method = "7C40A9CE840D044BE6A9FE6F804F2DE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceInfo<V> getServiceInfo(V type) {
        dsTaint.addTaint(type.dsTaint);
        {
            ServiceInfo<V> varDF0F01D798B7BCEDFCC01953EF3C7B61_659623105 = (mServices.get(type));
        } //End block
        return (ServiceInfo<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mServicesLock) {
            //return mServices.get(type);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.809 -0400", hash_original_method = "314682D3D2B2D41D6F4464EB59320735", hash_generated_method = "75AAADAC2D4604E7AF3B7915F6BA0E9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<ServiceInfo<V>> getAllServices() {
        {
            Collection<ServiceInfo<V>> var379514467E2D8E7248934E0221353A4A_94930869 = (Collections.unmodifiableCollection(mServices.values()));
        } //End block
        return (Collection<ServiceInfo<V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mServicesLock) {
            //return Collections.unmodifiableCollection(mServices.values());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.809 -0400", hash_original_method = "1776E8B4D21775792D782A371FDFF29B", hash_generated_method = "7FB440D00A46874D8D142A0110C6AB84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        BroadcastReceiver receiver;
        receiver = mReceiver.getAndSet(null);
        {
            mContext.unregisterReceiver(receiver);
        } //End block
        // ---------- Original Method ----------
        //final BroadcastReceiver receiver = mReceiver.getAndSet(null);
        //if (receiver != null) {
            //mContext.unregisterReceiver(receiver);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.810 -0400", hash_original_method = "675DD0BF255C7F4136F548B1BE5CB74C", hash_generated_method = "18F16C0B8631645F9DB662A0AE81FFA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        {
            boolean var75AC7ECB75B8274DEA99433CCB7DBB46_1205814160 = (mReceiver.get() != null);
        } //End collapsed parenthetic
        close();
        super.finalize();
        // ---------- Original Method ----------
        //if (mReceiver.get() != null) {
            //Log.e(TAG, "RegisteredServicesCache finalized without being closed");
        //}
        //close();
        //super.finalize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.815 -0400", hash_original_method = "30EEE88D5EBEE3E7BF1A3FE6896BBA6C", hash_generated_method = "D5200443877A40F418FBDEF901399E94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean inSystemImage(int callerUid) {
        dsTaint.addTaint(callerUid);
        String[] packages;
        packages = mContext.getPackageManager().getPackagesForUid(callerUid);
        {
            String name = packages[0];
            {
                try 
                {
                    PackageInfo packageInfo;
                    packageInfo = mContext.getPackageManager().getPackageInfo(name, 0 );
                } //End block
                catch (PackageManager.NameNotFoundException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.879 -0400", hash_original_method = "7FD7D9F6A29EBA7075A2BE7C2AD27E68", hash_generated_method = "670AE23D8B073300E4FC0F619BC6F45E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void generateServicesMap() {
        PackageManager pm;
        pm = mContext.getPackageManager();
        ArrayList<ServiceInfo<V>> serviceInfos;
        serviceInfos = new ArrayList<ServiceInfo<V>>();
        List<ResolveInfo> resolveInfos;
        resolveInfos = pm.queryIntentServices(new Intent(mInterfaceName),
                PackageManager.GET_META_DATA);
        {
            Iterator<ResolveInfo> varA26DD4CAE8F7472DF523963F56C59876_567336227 = (resolveInfos).iterator();
            varA26DD4CAE8F7472DF523963F56C59876_567336227.hasNext();
            ResolveInfo resolveInfo = varA26DD4CAE8F7472DF523963F56C59876_567336227.next();
            {
                try 
                {
                    ServiceInfo<V> info;
                    info = parseServiceInfo(resolveInfo);
                    serviceInfos.add(info);
                } //End block
                catch (XmlPullParserException e)
                { }
                catch (IOException e)
                { }
            } //End block
        } //End collapsed parenthetic
        {
            {
                readPersistentServicesLocked();
            } //End block
            mServices = Maps.newHashMap();
            StringBuilder changes;
            changes = new StringBuilder();
            {
                Iterator<ServiceInfo<V>> varCFA2B5D1E414C218AEDC68D715B2E73A_1402355510 = (serviceInfos).iterator();
                varCFA2B5D1E414C218AEDC68D715B2E73A_1402355510.hasNext();
                ServiceInfo<V> info = varCFA2B5D1E414C218AEDC68D715B2E73A_1402355510.next();
                {
                    Integer previousUid;
                    previousUid = mPersistentServices.get(info.type);
                    {
                        changes.append("  New service added: ").append(info).append("\n");
                        mServices.put(info.type, info);
                        mPersistentServices.put(info.type, info.uid);
                        {
                            notifyListener(info.type, false );
                        } //End block
                    } //End block
                    {
                        {
                            boolean var0C9C1F857EF1208EE3C75B6103EF6F6E_1750008452 = (Log.isLoggable(TAG, Log.VERBOSE));
                            {
                                changes.append("  Existing service (nop): ").append(info).append("\n");
                            } //End block
                        } //End collapsed parenthetic
                        mServices.put(info.type, info);
                    } //End block
                    {
                        boolean varFFAC02DEE0E1E3674D809CA7792CA55B_1625545595 = (inSystemImage(info.uid)
                        || !containsTypeAndUid(serviceInfos, info.type, previousUid));
                        {
                            {
                                boolean var9C1BBD037092FAA8D8EF40AEC0D204EC_496863389 = (inSystemImage(info.uid));
                                {
                                    changes.append("  System service replacing existing: ").append(info)
                                .append("\n");
                                } //End block
                                {
                                    changes.append("  Existing service replacing a removed service: ")
                                .append(info).append("\n");
                                } //End block
                            } //End collapsed parenthetic
                            mServices.put(info.type, info);
                            mPersistentServices.put(info.type, info.uid);
                            notifyListener(info.type, false );
                        } //End block
                        {
                            changes.append("  Existing service with new uid ignored: ").append(info)
                            .append("\n");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            ArrayList<V> toBeRemoved;
            toBeRemoved = Lists.newArrayList();
            {
                Iterator<V> var0964F743B99F50D551F8712F91E0FAE4_1220247616 = (mPersistentServices.keySet()).iterator();
                var0964F743B99F50D551F8712F91E0FAE4_1220247616.hasNext();
                V v1 = var0964F743B99F50D551F8712F91E0FAE4_1220247616.next();
                {
                    {
                        boolean var782F6FA2593CD8E4A57F47314DF440ED_543618496 = (!containsType(serviceInfos, v1));
                        {
                            toBeRemoved.add(v1);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<V> var4ED29A64238BA26508EAA0639F6AE81B_1179506413 = (toBeRemoved).iterator();
                var4ED29A64238BA26508EAA0639F6AE81B_1179506413.hasNext();
                V v1 = var4ED29A64238BA26508EAA0639F6AE81B_1179506413.next();
                {
                    mPersistentServices.remove(v1);
                    changes.append("  Service removed: ").append(v1).append("\n");
                    notifyListener(v1, true );
                } //End block
            } //End collapsed parenthetic
            {
                boolean var88EF2C068462606A6455AC462FD87C3D_1298012361 = (changes.length() > 0);
                {
                    Log.d(TAG, "generateServicesMap(" + mInterfaceName + "): " +
                        serviceInfos.size() + " services:\n" + changes);
                    writePersistentServicesLocked();
                } //End block
                {
                    Log.d(TAG, "generateServicesMap(" + mInterfaceName + "): " +
                        serviceInfos.size() + " services unchanged");
                } //End block
            } //End collapsed parenthetic
            mPersistentServicesFileDidNotExist = false;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.880 -0400", hash_original_method = "45DA6CE662A637B1B0A1C5B390B75450", hash_generated_method = "E68EC2068E82F469C4B4C4BD989CFB7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean containsType(ArrayList<ServiceInfo<V>> serviceInfos, V type) {
        dsTaint.addTaint(serviceInfos.dsTaint);
        dsTaint.addTaint(type.dsTaint);
        {
            int i, N;
            i = 0;
            N = serviceInfos.size();
            {
                {
                    boolean var19D4157B53D1E602542AEC1E5D8AFE4E_1927053591 = (serviceInfos.get(i).type.equals(type));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (int i = 0, N = serviceInfos.size(); i < N; i++) {
            //if (serviceInfos.get(i).type.equals(type)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.880 -0400", hash_original_method = "39F2D99D837C3B52D94DD556DC01CC72", hash_generated_method = "E4F992142FF4404385D087B7CB0CFBA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean containsTypeAndUid(ArrayList<ServiceInfo<V>> serviceInfos, V type, int uid) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(serviceInfos.dsTaint);
        dsTaint.addTaint(type.dsTaint);
        {
            int i, N;
            i = 0;
            N = serviceInfos.size();
            {
                ServiceInfo<V> serviceInfo;
                serviceInfo = serviceInfos.get(i);
                {
                    boolean varEECDA5A56FBEAF4B1891AEDA0C05785A_2127064266 = (serviceInfo.type.equals(type) && serviceInfo.uid == uid);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (int i = 0, N = serviceInfos.size(); i < N; i++) {
            //final ServiceInfo<V> serviceInfo = serviceInfos.get(i);
            //if (serviceInfo.type.equals(type) && serviceInfo.uid == uid) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.881 -0400", hash_original_method = "05773225026B5770A572BEDCCA950685", hash_generated_method = "4576292D9311373668C2981CB498FF82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ServiceInfo<V> parseServiceInfo(ResolveInfo service) throws XmlPullParserException, IOException {
        dsTaint.addTaint(service.dsTaint);
        android.content.pm.ServiceInfo si;
        si = service.serviceInfo;
        ComponentName componentName;
        componentName = new ComponentName(si.packageName, si.name);
        PackageManager pm;
        pm = mContext.getPackageManager();
        XmlResourceParser parser;
        parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, mMetaDataName);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("No " + mMetaDataName + " meta-data");
            } //End block
            AttributeSet attrs;
            attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_598319023 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean var4614475AA84F3A612636E9B8BB763FC4_1306504650 = (!mAttributesName.equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Meta-data does not start with " + mAttributesName +  " tag");
                } //End block
            } //End collapsed parenthetic
            V v;
            v = parseServiceAttributes(pm.getResourcesForApplication(si.applicationInfo),
                    si.packageName, attrs);
            android.content.pm.ServiceInfo serviceInfo;
            serviceInfo = service.serviceInfo;
            ApplicationInfo applicationInfo;
            applicationInfo = serviceInfo.applicationInfo;
            int uid;
            uid = applicationInfo.uid;
            ServiceInfo<V> varEAA08D60E7D0E6AC0CBF38B892D4F78E_75606006 = (new ServiceInfo<V>(v, componentName, uid));
        } //End block
        catch (NameNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    "Unable to load resources for pacakge " + si.packageName);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        return (ServiceInfo<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.882 -0400", hash_original_method = "AEFFF388F6549F52CCF36E0502C98B34", hash_generated_method = "FA166CA3E73AF9F370C53CF366BF1857")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readPersistentServicesLocked() {
        mPersistentServices = Maps.newHashMap();
        FileInputStream fis;
        fis = null;
        try 
        {
            mPersistentServicesFileDidNotExist = !mPersistentServicesFile.getBaseFile().exists();
            fis = mPersistentServicesFile.openRead();
            XmlPullParser parser;
            parser = Xml.newPullParser();
            parser.setInput(fis, null);
            int eventType;
            eventType = parser.getEventType();
            {
                eventType = parser.next();
            } //End block
            String tagName;
            tagName = parser.getName();
            {
                boolean var106A6D458E946398C30D87C7C805F5DF_1468933697 = ("services".equals(tagName));
                {
                    eventType = parser.next();
                    {
                        {
                            boolean varBCBD3D3BAD308BC777A538581FB9DF5A_982664032 = (eventType == XmlPullParser.START_TAG && parser.getDepth() == 2);
                            {
                                tagName = parser.getName();
                                {
                                    boolean varD2612B40A5B8CF52C3C3ECA00544992E_1382427306 = ("service".equals(tagName));
                                    {
                                        V service;
                                        service = mSerializerAndParser.createFromXml(parser);
                                        String uidString;
                                        uidString = parser.getAttributeValue(null, "uid");
                                        int uid;
                                        uid = Integer.parseInt(uidString);
                                        mPersistentServices.put(service, uid);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        eventType = parser.next();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (Exception e)
        { }
        finally 
        {
            {
                try 
                {
                    fis.close();
                } //End block
                catch (java.io.IOException e1)
                { }
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.895 -0400", hash_original_method = "EE98DCC48BA776AAD27AD82ED0CDBCAD", hash_generated_method = "1E81E103CA4BCF8654490BBBFFED7562")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writePersistentServicesLocked() {
        FileOutputStream fos;
        fos = null;
        try 
        {
            fos = mPersistentServicesFile.startWrite();
            XmlSerializer out;
            out = new FastXmlSerializer();
            out.setOutput(fos, "utf-8");
            out.startDocument(null, true);
            out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            out.startTag(null, "services");
            {
                Iterator<Map.Entry<V, Integer>> var4DDAADA76137DCE9017BA19DADD5174B_698357725 = (mPersistentServices.entrySet()).iterator();
                var4DDAADA76137DCE9017BA19DADD5174B_698357725.hasNext();
                Map.Entry<V, Integer> service = var4DDAADA76137DCE9017BA19DADD5174B_698357725.next();
                {
                    out.startTag(null, "service");
                    out.attribute(null, "uid", Integer.toString(service.getValue()));
                    mSerializerAndParser.writeAsXml(service.getKey(), out);
                    out.endTag(null, "service");
                } //End block
            } //End collapsed parenthetic
            out.endTag(null, "services");
            out.endDocument();
            mPersistentServicesFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
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
        public V type;
        public ComponentName componentName;
        public int uid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.896 -0400", hash_original_method = "472602FD5FE378647A180CDF60A7A18E", hash_generated_method = "5CFDDC51EF571A7973B35C0C2B74CFAB")
        @DSModeled(DSC.SAFE)
        public ServiceInfo(V type, ComponentName componentName, int uid) {
            dsTaint.addTaint(uid);
            dsTaint.addTaint(componentName.dsTaint);
            dsTaint.addTaint(type.dsTaint);
            // ---------- Original Method ----------
            //this.type = type;
            //this.componentName = componentName;
            //this.uid = uid;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.896 -0400", hash_original_method = "72B8806B88D8BA2A16DDBB10DB9489CE", hash_generated_method = "7793F7FD4E3766419E9A1A02B66041AA")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "ServiceInfo: " + type + ", " + componentName + ", uid " + uid;
        }

        
    }


    
    private static final String TAG = "PackageManager";
}

