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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.987 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "DE8577C1C990964647332D172A1FAC00")

    public Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.987 -0400", hash_original_field = "234538FD1AA7874AA9BF9A74C915B767", hash_generated_field = "B91D2FDD736D033C029D0603CE28FBCE")

    private String mInterfaceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.987 -0400", hash_original_field = "8BC81D2880C6CD7E31E637F74B0BA064", hash_generated_field = "C88ABD8EA4625ED773565A151DB8DE4F")

    private String mMetaDataName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.987 -0400", hash_original_field = "C76B08DE0209353DDF7319EC6A7EB3FA", hash_generated_field = "374C38096FB7BF7D602CD01609A2DAA2")

    private String mAttributesName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.988 -0400", hash_original_field = "847F2739E3E711FFCA1141D641686ACB", hash_generated_field = "AA271C9427511B8D13F10BA447FF9707")

    private XmlSerializerAndParser<V> mSerializerAndParser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.988 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "08412B605BBED453196A027B12C1C901")

    private AtomicReference<BroadcastReceiver> mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.988 -0400", hash_original_field = "4C7B88166487ADA33722EB33BE7F1BA3", hash_generated_field = "7B88287937D2F8332B319EA97FDE5E9F")

    private final Object mServicesLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.988 -0400", hash_original_field = "1C789CA3285862B792BE459D4A7BFFB7", hash_generated_field = "7C9830B84CCB22FE7159A16CB3E4930F")

    private HashMap<V, Integer> mPersistentServices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.988 -0400", hash_original_field = "C0CCF58937AD4C0942DADD568B3D8426", hash_generated_field = "DCB3C355B6846AF6DF6115B3AE075C00")

    private Map<V, ServiceInfo<V>> mServices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.988 -0400", hash_original_field = "FF3387FD79B8747652A6B4DDB199BB60", hash_generated_field = "D5A26748B2EA05973DF9D609AA73C24C")

    private boolean mPersistentServicesFileDidNotExist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.988 -0400", hash_original_field = "5D71BE5CE04F6705CCE043C0E843BC9E", hash_generated_field = "7849E3F4879F6E3972ADF7CA59BBDAD5")

    private AtomicFile mPersistentServicesFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.988 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "7901EBDD1689EB7A4EBB997D88C95CD2")

    private RegisteredServicesCacheListener<V> mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.988 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.989 -0400", hash_original_method = "1931A7A6B7925D0DE2D2487C8FB155F2", hash_generated_method = "EDD12DA8E664BF69E295FD53796EDD52")
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.368 -0400", hash_original_method = "EB7158F459E2A057373DBB2E8C73133E", hash_generated_method = "054E57837B8D73AE1189BC75274DCCE4")
    public void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        Map<V, ServiceInfo<V>> services;
        {
            services = mServices;
        } //End block
        fout.println("RegisteredServicesCache: " + services.size() + " services");
        {
            Iterator<ServiceInfo<V>> var7025787026F785F48DDDCE829924C4A1_752909425 = (services.values()).iterator();
            var7025787026F785F48DDDCE829924C4A1_752909425.hasNext();
            ServiceInfo info = var7025787026F785F48DDDCE829924C4A1_752909425.next();
            {
                fout.println("  " + info);
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(fout.getTaint());
        addTaint(args[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.991 -0400", hash_original_method = "D8F0001D796B123F3D4D73C4471FA428", hash_generated_method = "2254E3CDC62396603AFDB2B2D58380D7")
    public RegisteredServicesCacheListener<V> getListener() {
        RegisteredServicesCacheListener<V> varB4EAC82CA7396A68D541C85D26508E83_1388598669 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1388598669 = mListener;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1388598669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1388598669;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mListener;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.992 -0400", hash_original_method = "C8A12F3C71D9DEAC88B94A90B0132AEE", hash_generated_method = "7D74B051DA0DB06708B58C38535007B7")
    public void setListener(RegisteredServicesCacheListener<V> listener, Handler handler) {
        {
            handler = new Handler(mContext.getMainLooper());
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.394 -0400", hash_original_method = "06355F437BD90B9C1EBE1920422258C6", hash_generated_method = "61196F41E63EAD00889E36A31C231DBA")
    private void notifyListener(final V type, final boolean removed) {
        {
            boolean varF4C79785E609264B93BBE9F12FEBD33F_675747917 = (Log.isLoggable(TAG, Log.VERBOSE));
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
        final RegisteredServicesCacheListener<V> listener2;
        listener2 = listener;
        handler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.393 -0400", hash_original_method = "895F39B4216C41C2813EBDFABEA40262", hash_generated_method = "2A8550E57F5B9632D66DC046840BC57C")
            public void run() {
                listener2.onServiceChanged(type, removed);
                // ---------- Original Method ----------
                //listener2.onServiceChanged(type, removed);
            }
});
        addTaint(type.getTaint());
        addTaint(removed);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.994 -0400", hash_original_method = "E22FC6668AC77A4961A8F001D76B9B4E", hash_generated_method = "C3F4B0B4A7A231A722C120160FBE9792")
    public ServiceInfo<V> getServiceInfo(V type) {
        ServiceInfo<V> varB4EAC82CA7396A68D541C85D26508E83_1578494415 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1578494415 = mServices.get(type);
        } //End block
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1578494415.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1578494415;
        // ---------- Original Method ----------
        //synchronized (mServicesLock) {
            //return mServices.get(type);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.995 -0400", hash_original_method = "314682D3D2B2D41D6F4464EB59320735", hash_generated_method = "89986EFC040BD9FFD11C7CAFB1ED1C65")
    public Collection<ServiceInfo<V>> getAllServices() {
        Collection<ServiceInfo<V>> varB4EAC82CA7396A68D541C85D26508E83_1887232905 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1887232905 = Collections.unmodifiableCollection(mServices.values());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1887232905.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1887232905;
        // ---------- Original Method ----------
        //synchronized (mServicesLock) {
            //return Collections.unmodifiableCollection(mServices.values());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.995 -0400", hash_original_method = "1776E8B4D21775792D782A371FDFF29B", hash_generated_method = "2104EE0FBDA059145AA206BC93E8D94D")
    public void close() {
        final BroadcastReceiver receiver = mReceiver.getAndSet(null);
        {
            mContext.unregisterReceiver(receiver);
        } //End block
        // ---------- Original Method ----------
        //final BroadcastReceiver receiver = mReceiver.getAndSet(null);
        //if (receiver != null) {
            //mContext.unregisterReceiver(receiver);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.996 -0400", hash_original_method = "675DD0BF255C7F4136F548B1BE5CB74C", hash_generated_method = "710309C54F62D88190DF4D67D48AFA6A")
    @Override
    protected void finalize() throws Throwable {
        {
            boolean var75AC7ECB75B8274DEA99433CCB7DBB46_1888578964 = (mReceiver.get() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.560 -0400", hash_original_method = "30EEE88D5EBEE3E7BF1A3FE6896BBA6C", hash_generated_method = "372AEEC1D15B4FCE4B7522119616C3A8")
    private boolean inSystemImage(int callerUid) {
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
        addTaint(callerUid);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705745829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_705745829;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.070 -0400", hash_original_method = "7FD7D9F6A29EBA7075A2BE7C2AD27E68", hash_generated_method = "0B2EA63949517333C216185715287A66")
     void generateServicesMap() {
        PackageManager pm = mContext.getPackageManager();
        ArrayList<ServiceInfo<V>> serviceInfos = new ArrayList<ServiceInfo<V>>();
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(new Intent(mInterfaceName),
                PackageManager.GET_META_DATA);
        {
            Iterator<ResolveInfo> varA26DD4CAE8F7472DF523963F56C59876_1448612014 = (resolveInfos).iterator();
            varA26DD4CAE8F7472DF523963F56C59876_1448612014.hasNext();
            ResolveInfo resolveInfo = varA26DD4CAE8F7472DF523963F56C59876_1448612014.next();
            {
                try 
                {
                    ServiceInfo<V> info = parseServiceInfo(resolveInfo);
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
            StringBuilder changes = new StringBuilder();
            {
                Iterator<ServiceInfo<V>> varCFA2B5D1E414C218AEDC68D715B2E73A_1076283719 = (serviceInfos).iterator();
                varCFA2B5D1E414C218AEDC68D715B2E73A_1076283719.hasNext();
                ServiceInfo<V> info = varCFA2B5D1E414C218AEDC68D715B2E73A_1076283719.next();
                {
                    Integer previousUid = mPersistentServices.get(info.type);
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
                            boolean var0C9C1F857EF1208EE3C75B6103EF6F6E_1735096921 = (Log.isLoggable(TAG, Log.VERBOSE));
                            {
                                changes.append("  Existing service (nop): ").append(info).append("\n");
                            } //End block
                        } //End collapsed parenthetic
                        mServices.put(info.type, info);
                    } //End block
                    {
                        boolean varFFAC02DEE0E1E3674D809CA7792CA55B_2071900412 = (inSystemImage(info.uid)
                        || !containsTypeAndUid(serviceInfos, info.type, previousUid));
                        {
                            {
                                boolean var9C1BBD037092FAA8D8EF40AEC0D204EC_850370798 = (inSystemImage(info.uid));
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
            ArrayList<V> toBeRemoved = Lists.newArrayList();
            {
                Iterator<V> var0964F743B99F50D551F8712F91E0FAE4_637566036 = (mPersistentServices.keySet()).iterator();
                var0964F743B99F50D551F8712F91E0FAE4_637566036.hasNext();
                V v1 = var0964F743B99F50D551F8712F91E0FAE4_637566036.next();
                {
                    {
                        boolean var782F6FA2593CD8E4A57F47314DF440ED_907763547 = (!containsType(serviceInfos, v1));
                        {
                            toBeRemoved.add(v1);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<V> var4ED29A64238BA26508EAA0639F6AE81B_1744419549 = (toBeRemoved).iterator();
                var4ED29A64238BA26508EAA0639F6AE81B_1744419549.hasNext();
                V v1 = var4ED29A64238BA26508EAA0639F6AE81B_1744419549.next();
                {
                    mPersistentServices.remove(v1);
                    changes.append("  Service removed: ").append(v1).append("\n");
                    notifyListener(v1, true );
                } //End block
            } //End collapsed parenthetic
            {
                boolean var88EF2C068462606A6455AC462FD87C3D_18898500 = (changes.length() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.070 -0400", hash_original_method = "45DA6CE662A637B1B0A1C5B390B75450", hash_generated_method = "2D7DD132B4F8628ED63FFF4E5898B466")
    private boolean containsType(ArrayList<ServiceInfo<V>> serviceInfos, V type) {
        {
            int i = 0;
            int N = serviceInfos.size();
            {
                {
                    boolean var19D4157B53D1E602542AEC1E5D8AFE4E_1104828602 = (serviceInfos.get(i).type.equals(type));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(serviceInfos.getTaint());
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1380654537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1380654537;
        // ---------- Original Method ----------
        //for (int i = 0, N = serviceInfos.size(); i < N; i++) {
            //if (serviceInfos.get(i).type.equals(type)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.071 -0400", hash_original_method = "39F2D99D837C3B52D94DD556DC01CC72", hash_generated_method = "2AB7CBE55D995473EDF75F7B9DAD8ADC")
    private boolean containsTypeAndUid(ArrayList<ServiceInfo<V>> serviceInfos, V type, int uid) {
        {
            int i = 0;
            int N = serviceInfos.size();
            {
                final ServiceInfo<V> serviceInfo = serviceInfos.get(i);
                {
                    boolean varEECDA5A56FBEAF4B1891AEDA0C05785A_1554264232 = (serviceInfo.type.equals(type) && serviceInfo.uid == uid);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(serviceInfos.getTaint());
        addTaint(type.getTaint());
        addTaint(uid);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637359149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637359149;
        // ---------- Original Method ----------
        //for (int i = 0, N = serviceInfos.size(); i < N; i++) {
            //final ServiceInfo<V> serviceInfo = serviceInfos.get(i);
            //if (serviceInfo.type.equals(type) && serviceInfo.uid == uid) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.072 -0400", hash_original_method = "05773225026B5770A572BEDCCA950685", hash_generated_method = "E854679E523497ACE215AE4566595D64")
    private ServiceInfo<V> parseServiceInfo(ResolveInfo service) throws XmlPullParserException, IOException {
        ServiceInfo<V> varB4EAC82CA7396A68D541C85D26508E83_1790397890 = null; //Variable for return #1
        ServiceInfo<V> varB4EAC82CA7396A68D541C85D26508E83_493890650 = null; //Variable for return #2
        android.content.pm.ServiceInfo si = service.serviceInfo;
        ComponentName componentName = new ComponentName(si.packageName, si.name);
        PackageManager pm = mContext.getPackageManager();
        XmlResourceParser parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, mMetaDataName);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("No " + mMetaDataName + " meta-data");
            } //End block
            AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_1757194776 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName = parser.getName();
            {
                boolean var4614475AA84F3A612636E9B8BB763FC4_1821228542 = (!mAttributesName.equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Meta-data does not start with " + mAttributesName +  " tag");
                } //End block
            } //End collapsed parenthetic
            V v = parseServiceAttributes(pm.getResourcesForApplication(si.applicationInfo),
                    si.packageName, attrs);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1790397890 = null;
            } //End block
            final android.content.pm.ServiceInfo serviceInfo = service.serviceInfo;
            final ApplicationInfo applicationInfo = serviceInfo.applicationInfo;
            final int uid = applicationInfo.uid;
            varB4EAC82CA7396A68D541C85D26508E83_493890650 = new ServiceInfo<V>(v, componentName, uid);
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
        addTaint(service.getTaint());
        ServiceInfo<V> varA7E53CE21691AB073D9660D615818899_1989046591; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1989046591 = varB4EAC82CA7396A68D541C85D26508E83_1790397890;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1989046591 = varB4EAC82CA7396A68D541C85D26508E83_493890650;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1989046591.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1989046591;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.075 -0400", hash_original_method = "AEFFF388F6549F52CCF36E0502C98B34", hash_generated_method = "BE8677B969FBC702909865666FEB985C")
    private void readPersistentServicesLocked() {
        mPersistentServices = Maps.newHashMap();
        FileInputStream fis = null;
        try 
        {
            mPersistentServicesFileDidNotExist = !mPersistentServicesFile.getBaseFile().exists();
            fis = mPersistentServicesFile.openRead();
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(fis, null);
            int eventType = parser.getEventType();
            {
                eventType = parser.next();
            } //End block
            String tagName = parser.getName();
            {
                boolean var106A6D458E946398C30D87C7C805F5DF_680096520 = ("services".equals(tagName));
                {
                    eventType = parser.next();
                    {
                        {
                            boolean varBCBD3D3BAD308BC777A538581FB9DF5A_1749026774 = (eventType == XmlPullParser.START_TAG && parser.getDepth() == 2);
                            {
                                tagName = parser.getName();
                                {
                                    boolean varD2612B40A5B8CF52C3C3ECA00544992E_1005244300 = ("service".equals(tagName));
                                    {
                                        V service = mSerializerAndParser.createFromXml(parser);
                                        String uidString = parser.getAttributeValue(null, "uid");
                                        int uid = Integer.parseInt(uidString);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.089 -0400", hash_original_method = "EE98DCC48BA776AAD27AD82ED0CDBCAD", hash_generated_method = "6C33FBDED303B05C7DDDD68B3830BDF6")
    private void writePersistentServicesLocked() {
        FileOutputStream fos = null;
        try 
        {
            fos = mPersistentServicesFile.startWrite();
            XmlSerializer out = new FastXmlSerializer();
            out.setOutput(fos, "utf-8");
            out.startDocument(null, true);
            out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            out.startTag(null, "services");
            {
                Iterator<Map.Entry<V, Integer>> var4DDAADA76137DCE9017BA19DADD5174B_196224874 = (mPersistentServices.entrySet()).iterator();
                var4DDAADA76137DCE9017BA19DADD5174B_196224874.hasNext();
                Map.Entry<V, Integer> service = var4DDAADA76137DCE9017BA19DADD5174B_196224874.next();
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.089 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "1C0901F7CD197CB5951F2E539CF1A8AE")

        public V type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.089 -0400", hash_original_field = "FE439837C9D0340925B5F19E11F6264D", hash_generated_field = "98D1E72DA94B9A47D9FBC8AE55A2CAA0")

        public ComponentName componentName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.090 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.090 -0400", hash_original_method = "472602FD5FE378647A180CDF60A7A18E", hash_generated_method = "66D8FFD3C91D0CDC48CEBF75A2EFFF69")
        public  ServiceInfo(V type, ComponentName componentName, int uid) {
            this.type = type;
            this.componentName = componentName;
            this.uid = uid;
            // ---------- Original Method ----------
            //this.type = type;
            //this.componentName = componentName;
            //this.uid = uid;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.092 -0400", hash_original_method = "72B8806B88D8BA2A16DDBB10DB9489CE", hash_generated_method = "11709B7A95FDB080B6B9CE172D276DAD")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1418450295 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1418450295 = "ServiceInfo: " + type + ", " + componentName + ", uid " + uid;
            varB4EAC82CA7396A68D541C85D26508E83_1418450295.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1418450295;
            // ---------- Original Method ----------
            //return "ServiceInfo: " + type + ", " + componentName + ", uid " + uid;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.092 -0400", hash_original_field = "799B1C7045AB9A1990EA02A1923DD877", hash_generated_field = "E87B09140D2B39BDC1A082AB48B400E2")

    private static final String TAG = "PackageManager";
    // orphaned legacy method
    @Override
            public void onReceive(Context context1, Intent intent) {
                generateServicesMap();
            }
    
}

