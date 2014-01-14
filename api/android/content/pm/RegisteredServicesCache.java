package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.838 -0500", hash_original_field = "B4667463F60DCD48849D657740F41408", hash_generated_field = "E87B09140D2B39BDC1A082AB48B400E2")

    private static final String TAG = "PackageManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.841 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "DE8577C1C990964647332D172A1FAC00")

    public  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.843 -0500", hash_original_field = "5D2D75DE4020ED94AFC743546E0FE97A", hash_generated_field = "B91D2FDD736D033C029D0603CE28FBCE")

    private  String mInterfaceName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.845 -0500", hash_original_field = "14D9835CB8E3698520D6D4C1A829ADCF", hash_generated_field = "C88ABD8EA4625ED773565A151DB8DE4F")

    private  String mMetaDataName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.847 -0500", hash_original_field = "CCC78B65C58E344249592D15FA403093", hash_generated_field = "374C38096FB7BF7D602CD01609A2DAA2")

    private  String mAttributesName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.849 -0500", hash_original_field = "05DC0947B30DEDA6773EF7DD9BB95925", hash_generated_field = "AA271C9427511B8D13F10BA447FF9707")

    private  XmlSerializerAndParser<V> mSerializerAndParser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.852 -0500", hash_original_field = "E7AE1CCD0500C980CD4567E2487E180A", hash_generated_field = "08412B605BBED453196A027B12C1C901")

    private  AtomicReference<BroadcastReceiver> mReceiver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.854 -0500", hash_original_field = "8BD1CBBF1BD26772FD8A64BF15463062", hash_generated_field = "7B88287937D2F8332B319EA97FDE5E9F")

    private final Object mServicesLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.856 -0500", hash_original_field = "B38CDB010801A35438D731CC1ACCF60E", hash_generated_field = "7C9830B84CCB22FE7159A16CB3E4930F")

    private HashMap<V, Integer> mPersistentServices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.858 -0500", hash_original_field = "C64B3BAEE40CDD609FF122FDE254E09C", hash_generated_field = "DCB3C355B6846AF6DF6115B3AE075C00")

    private Map<V, ServiceInfo<V>> mServices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.860 -0500", hash_original_field = "92D80FB30A87DBDCF8C9AEC45D5BA392", hash_generated_field = "D5A26748B2EA05973DF9D609AA73C24C")

    private boolean mPersistentServicesFileDidNotExist;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.863 -0500", hash_original_field = "7D7D970431BD52D556E45CCCD2EE8B10", hash_generated_field = "7849E3F4879F6E3972ADF7CA59BBDAD5")

    private  AtomicFile mPersistentServicesFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.865 -0500", hash_original_field = "686CD2426D4513A31A442F825D936F97", hash_generated_field = "7901EBDD1689EB7A4EBB997D88C95CD2")

    private RegisteredServicesCacheListener<V> mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.867 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.871 -0500", hash_original_method = "45D1595BD3BE881ACC04F9CBD9CBE57E", hash_generated_method = "A66C0B39FBC65772E7FDF805DF3CE268")
            
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.876 -0500", hash_original_method = "EB7158F459E2A057373DBB2E8C73133E", hash_generated_method = "90467D8421F42A2C31478EEB89A8D030")
    
public void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        Map<V, ServiceInfo<V>> services;
        synchronized (mServicesLock) {
            services = mServices;
        }
        fout.println("RegisteredServicesCache: " + services.size() + " services");
        for (ServiceInfo info : services.values()) {
            fout.println("  " + info);
        }
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.878 -0500", hash_original_method = "D8F0001D796B123F3D4D73C4471FA428", hash_generated_method = "B683D4E1159000788828D139458F35FF")
    
public RegisteredServicesCacheListener<V> getListener() {
        synchronized (this) {
            return mListener;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.880 -0500", hash_original_method = "C8A12F3C71D9DEAC88B94A90B0132AEE", hash_generated_method = "16A685D4A1131C34C000401DFC2327CC")
    
public void setListener(RegisteredServicesCacheListener<V> listener, Handler handler) {
        if (handler == null) {
            handler = new Handler(mContext.getMainLooper());
        }
        synchronized (this) {
            mHandler = handler;
            mListener = listener;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.885 -0500", hash_original_method = "06355F437BD90B9C1EBE1920422258C6", hash_generated_method = "43B64E2732F6C49872F4D8AE72DB5ECB")
    
private void notifyListener(final V type, final boolean removed) {
        if (Log.isLoggable(TAG, Log.VERBOSE)) {
            Log.d(TAG, "notifyListener: " + type + " is " + (removed ? "removed" : "added"));
        }
        RegisteredServicesCacheListener<V> listener;
        Handler handler; 
        synchronized (this) {
            listener = mListener;
            handler = mHandler;
        }
        if (listener == null) {
            return;
        }
        
        final RegisteredServicesCacheListener<V> listener2 = listener;
        handler.post(new Runnable() {
            public void run() {
                listener2.onServiceChanged(type, removed);
            }
        });
    }

    /**
     * Accessor for the registered authenticators.
     * @param type the account type of the authenticator
     * @return the AuthenticatorInfo that matches the account type or null if none is present
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.902 -0500", hash_original_method = "E22FC6668AC77A4961A8F001D76B9B4E", hash_generated_method = "E4F5EF4642FDC90700508079AB3A6F0F")
    
public ServiceInfo<V> getServiceInfo(V type) {
        synchronized (mServicesLock) {
            return mServices.get(type);
        }
    }

    /**
     * @return a collection of {@link RegisteredServicesCache.ServiceInfo} objects for all
     * registered authenticators.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.904 -0500", hash_original_method = "314682D3D2B2D41D6F4464EB59320735", hash_generated_method = "21A121AFA23BA1DC4860242D20466B19")
    
public Collection<ServiceInfo<V>> getAllServices() {
        synchronized (mServicesLock) {
            return Collections.unmodifiableCollection(mServices.values());
        }
    }

    /**
     * Stops the monitoring of package additions, removals and changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.906 -0500", hash_original_method = "1776E8B4D21775792D782A371FDFF29B", hash_generated_method = "12A4356975409EB29B9646BFC731B968")
    
public void close() {
        final BroadcastReceiver receiver = mReceiver.getAndSet(null);
        if (receiver != null) {
            mContext.unregisterReceiver(receiver);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.908 -0500", hash_original_method = "675DD0BF255C7F4136F548B1BE5CB74C", hash_generated_method = "1F62B79608478E76EA49831949F5396B")
    
@Override
    protected void finalize() throws Throwable {
        if (mReceiver.get() != null) {
            Log.e(TAG, "RegisteredServicesCache finalized without being closed");
        }
        close();
        super.finalize();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.911 -0500", hash_original_method = "30EEE88D5EBEE3E7BF1A3FE6896BBA6C", hash_generated_method = "F606EE98D0992ED4C3F358286CDF814C")
    
private boolean inSystemImage(int callerUid) {
        String[] packages = mContext.getPackageManager().getPackagesForUid(callerUid);
        for (String name : packages) {
            try {
                PackageInfo packageInfo =
                        mContext.getPackageManager().getPackageInfo(name, 0 /* flags */);
                if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.916 -0500", hash_original_method = "7FD7D9F6A29EBA7075A2BE7C2AD27E68", hash_generated_method = "D1A26803CE9935C1B7FA618F016CD4F8")
    
void generateServicesMap() {
        PackageManager pm = mContext.getPackageManager();
        ArrayList<ServiceInfo<V>> serviceInfos = new ArrayList<ServiceInfo<V>>();
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(new Intent(mInterfaceName),
                PackageManager.GET_META_DATA);
        for (ResolveInfo resolveInfo : resolveInfos) {
            try {
                ServiceInfo<V> info = parseServiceInfo(resolveInfo);
                if (info == null) {
                    Log.w(TAG, "Unable to load service info " + resolveInfo.toString());
                    continue;
                }
                serviceInfos.add(info);
            } catch (XmlPullParserException e) {
                Log.w(TAG, "Unable to load service info " + resolveInfo.toString(), e);
            } catch (IOException e) {
                Log.w(TAG, "Unable to load service info " + resolveInfo.toString(), e);
            }
        }

        synchronized (mServicesLock) {
            if (mPersistentServices == null) {
                readPersistentServicesLocked();
            }
            mServices = Maps.newHashMap();
            StringBuilder changes = new StringBuilder();
            for (ServiceInfo<V> info : serviceInfos) {
                // four cases:
                // - doesn't exist yet
                //   - add, notify user that it was added
                // - exists and the UID is the same
                //   - replace, don't notify user
                // - exists, the UID is different, and the new one is not a system package
                //   - ignore
                // - exists, the UID is different, and the new one is a system package
                //   - add, notify user that it was added
                Integer previousUid = mPersistentServices.get(info.type);
                if (previousUid == null) {
                    changes.append("  New service added: ").append(info).append("\n");
                    mServices.put(info.type, info);
                    mPersistentServices.put(info.type, info.uid);
                    if (!mPersistentServicesFileDidNotExist) {
                        notifyListener(info.type, false /* removed */);
                    }
                } else if (previousUid == info.uid) {
                    if (Log.isLoggable(TAG, Log.VERBOSE)) {
                        changes.append("  Existing service (nop): ").append(info).append("\n");
                    }
                    mServices.put(info.type, info);
                } else if (inSystemImage(info.uid)
                        || !containsTypeAndUid(serviceInfos, info.type, previousUid)) {
                    if (inSystemImage(info.uid)) {
                        changes.append("  System service replacing existing: ").append(info)
                                .append("\n");
                    } else {
                        changes.append("  Existing service replacing a removed service: ")
                                .append(info).append("\n");
                    }
                    mServices.put(info.type, info);
                    mPersistentServices.put(info.type, info.uid);
                    notifyListener(info.type, false /* removed */);
                } else {
                    // ignore
                    changes.append("  Existing service with new uid ignored: ").append(info)
                            .append("\n");
                }
            }

            ArrayList<V> toBeRemoved = Lists.newArrayList();
            for (V v1 : mPersistentServices.keySet()) {
                if (!containsType(serviceInfos, v1)) {
                    toBeRemoved.add(v1);
                }
            }
            for (V v1 : toBeRemoved) {
                mPersistentServices.remove(v1);
                changes.append("  Service removed: ").append(v1).append("\n");
                notifyListener(v1, true /* removed */);
            }
            if (changes.length() > 0) {
                Log.d(TAG, "generateServicesMap(" + mInterfaceName + "): " +
                        serviceInfos.size() + " services:\n" + changes);
                writePersistentServicesLocked();
            } else {
                Log.d(TAG, "generateServicesMap(" + mInterfaceName + "): " +
                        serviceInfos.size() + " services unchanged");
            }
            mPersistentServicesFileDidNotExist = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.918 -0500", hash_original_method = "45DA6CE662A637B1B0A1C5B390B75450", hash_generated_method = "79B91528470BFF2F55D0432291AAB77B")
    
private boolean containsType(ArrayList<ServiceInfo<V>> serviceInfos, V type) {
        for (int i = 0, N = serviceInfos.size(); i < N; i++) {
            if (serviceInfos.get(i).type.equals(type)) {
                return true;
            }
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.921 -0500", hash_original_method = "39F2D99D837C3B52D94DD556DC01CC72", hash_generated_method = "E42777FCF1E30D15460AC23EC824EDA6")
    
private boolean containsTypeAndUid(ArrayList<ServiceInfo<V>> serviceInfos, V type, int uid) {
        for (int i = 0, N = serviceInfos.size(); i < N; i++) {
            final ServiceInfo<V> serviceInfo = serviceInfos.get(i);
            if (serviceInfo.type.equals(type) && serviceInfo.uid == uid) {
                return true;
            }
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.924 -0500", hash_original_method = "05773225026B5770A572BEDCCA950685", hash_generated_method = "81FD6B917E1B7051257D0274693EE512")
    
private ServiceInfo<V> parseServiceInfo(ResolveInfo service)
            throws XmlPullParserException, IOException {
        android.content.pm.ServiceInfo si = service.serviceInfo;
        ComponentName componentName = new ComponentName(si.packageName, si.name);

        PackageManager pm = mContext.getPackageManager();

        XmlResourceParser parser = null;
        try {
            parser = si.loadXmlMetaData(pm, mMetaDataName);
            if (parser == null) {
                throw new XmlPullParserException("No " + mMetaDataName + " meta-data");
            }

            AttributeSet attrs = Xml.asAttributeSet(parser);

            int type;
            while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG) {
            }

            String nodeName = parser.getName();
            if (!mAttributesName.equals(nodeName)) {
                throw new XmlPullParserException(
                        "Meta-data does not start with " + mAttributesName +  " tag");
            }

            V v = parseServiceAttributes(pm.getResourcesForApplication(si.applicationInfo),
                    si.packageName, attrs);
            if (v == null) {
                return null;
            }
            final android.content.pm.ServiceInfo serviceInfo = service.serviceInfo;
            final ApplicationInfo applicationInfo = serviceInfo.applicationInfo;
            final int uid = applicationInfo.uid;
            return new ServiceInfo<V>(v, componentName, uid);
        } catch (NameNotFoundException e) {
            throw new XmlPullParserException(
                    "Unable to load resources for pacakge " + si.packageName);
        } finally {
            if (parser != null) parser.close();
        }
    }

    /**
     * Read all sync status back in to the initial engine state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.927 -0500", hash_original_method = "AEFFF388F6549F52CCF36E0502C98B34", hash_generated_method = "9DFE4CD666B1D5475582D92B6697321D")
    
private void readPersistentServicesLocked() {
        mPersistentServices = Maps.newHashMap();
        if (mSerializerAndParser == null) {
            return;
        }
        FileInputStream fis = null;
        try {
            mPersistentServicesFileDidNotExist = !mPersistentServicesFile.getBaseFile().exists();
            if (mPersistentServicesFileDidNotExist) {
                return;
            }
            fis = mPersistentServicesFile.openRead();
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(fis, null);
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.START_TAG) {
                eventType = parser.next();
            }
            String tagName = parser.getName();
            if ("services".equals(tagName)) {
                eventType = parser.next();
                do {
                    if (eventType == XmlPullParser.START_TAG && parser.getDepth() == 2) {
                        tagName = parser.getName();
                        if ("service".equals(tagName)) {
                            V service = mSerializerAndParser.createFromXml(parser);
                            if (service == null) {
                                break;
                            }
                            String uidString = parser.getAttributeValue(null, "uid");
                            int uid = Integer.parseInt(uidString);
                            mPersistentServices.put(service, uid);
                        }
                    }
                    eventType = parser.next();
                } while (eventType != XmlPullParser.END_DOCUMENT);
            }
        } catch (Exception e) {
            Log.w(TAG, "Error reading persistent services, starting from scratch", e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (java.io.IOException e1) {
                }
            }
        }
    }
    
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
    
    public static class ServiceInfo<V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.889 -0500", hash_original_field = "B7164ACA5B2367A3B9E43D782CBA3E64", hash_generated_field = "1C0901F7CD197CB5951F2E539CF1A8AE")

        public  V type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.891 -0500", hash_original_field = "E3D849549355C126FFF6430112CFAA0A", hash_generated_field = "98D1E72DA94B9A47D9FBC8AE55A2CAA0")

        public  ComponentName componentName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.894 -0500", hash_original_field = "12FA9B6FF5DE3157A8BC781F3445534B", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public  int uid;

        /** @hide */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.897 -0500", hash_original_method = "472602FD5FE378647A180CDF60A7A18E", hash_generated_method = "C2984020D2A151EA4BC4848160DECB6A")
        
public ServiceInfo(V type, ComponentName componentName, int uid) {
            this.type = type;
            this.componentName = componentName;
            this.uid = uid;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.899 -0500", hash_original_method = "72B8806B88D8BA2A16DDBB10DB9489CE", hash_generated_method = "05E41F03AEC02226355FA18523610500")
        
@Override
        public String toString() {
            return "ServiceInfo: " + type + ", " + componentName + ", uid " + uid;
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.932 -0500", hash_original_method = "259476DC514131AD7C2422832CE45DCB", hash_generated_method = "1A75B5302391BADF1F700C4CB696259C")
    
public abstract V parseServiceAttributes(Resources res,
            String packageName, AttributeSet attrs);
}

