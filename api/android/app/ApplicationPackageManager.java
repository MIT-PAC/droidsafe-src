package android.app;

// Droidsafe Imports
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.IPackageDataObserver;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.IPackageManager;
import android.content.pm.IPackageMoveObserver;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.InstrumentationInfo;
import android.content.pm.ManifestDigest;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.content.pm.VerifierDeviceIdentity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Process;
import android.os.RemoteException;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class ApplicationPackageManager extends PackageManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.469 -0400", hash_original_field = "D582EAEF778B662187C3776F3BC85DE5", hash_generated_field = "BB74ADCE9FCE390733990F175981A8B2")

    int mCachedSafeMode = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.469 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "9848C26EA3B1FE04FDB0411428C18F0B")

    private ContextImpl mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.470 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "7F4B9DC825AA12542DFD4F441E873557")

    private IPackageManager mPM;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.471 -0400", hash_original_method = "12FC21630330363415BEFB2BB747FDD4", hash_generated_method = "821E283AA9F20FD120BA751A1DBB238D")
      ApplicationPackageManager(ContextImpl context,
                              IPackageManager pm) {
        mContext = context;
        mPM = pm;
        // ---------- Original Method ----------
        //mContext = context;
        //mPM = pm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.472 -0400", hash_original_method = "B0DADC2DBFEC092F753C36E8DEB385A1", hash_generated_method = "FD90C3618FE777B56D7232C17DA7B48C")
    @Override
    public PackageInfo getPackageInfo(String packageName, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(packageName.getTaint());
        try 
        {
            PackageInfo pi = mPM.getPackageInfo(packageName, flags);
            if(pi != null)            
            {
PackageInfo var81D1A2E7B8C8FB24958425A15F743A98_1982188594 =                 pi;
                var81D1A2E7B8C8FB24958425A15F743A98_1982188594.addTaint(taint);
                return var81D1A2E7B8C8FB24958425A15F743A98_1982188594;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_361589164 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_361589164.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_361589164;
        } //End block
        NameNotFoundException var66F177309B3AAEEE242A13D4F2EC34A7_1512293150 = new NameNotFoundException(packageName);
        var66F177309B3AAEEE242A13D4F2EC34A7_1512293150.addTaint(taint);
        throw var66F177309B3AAEEE242A13D4F2EC34A7_1512293150;
        // ---------- Original Method ----------
        //try {
            //PackageInfo pi = mPM.getPackageInfo(packageName, flags);
            //if (pi != null) {
                //return pi;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.473 -0400", hash_original_method = "C5CDEAB4FF073C2ACB7E7915B56F1D0F", hash_generated_method = "0E8813ED6FA66F6ECFF550842832D87F")
    @Override
    public String[] currentToCanonicalPackageNames(String[] names) {
        addTaint(names[0].getTaint());
        try 
        {
String[] var4408DCF3960F805BCBC82CB95360A56D_826615468 =             mPM.currentToCanonicalPackageNames(names);
            var4408DCF3960F805BCBC82CB95360A56D_826615468.addTaint(taint);
            return var4408DCF3960F805BCBC82CB95360A56D_826615468;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_347453778 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_347453778.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_347453778;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.currentToCanonicalPackageNames(names);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.474 -0400", hash_original_method = "9BD980F14E9EC05077595EA826722236", hash_generated_method = "CF20090689F1D75715C5DDEAD2B007C2")
    @Override
    public String[] canonicalToCurrentPackageNames(String[] names) {
        addTaint(names[0].getTaint());
        try 
        {
String[] var7E7E7838A1BF04C6EBC5094AE21CEB27_642307562 =             mPM.canonicalToCurrentPackageNames(names);
            var7E7E7838A1BF04C6EBC5094AE21CEB27_642307562.addTaint(taint);
            return var7E7E7838A1BF04C6EBC5094AE21CEB27_642307562;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1587288802 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1587288802.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1587288802;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.canonicalToCurrentPackageNames(names);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.477 -0400", hash_original_method = "A679E3857CF73FF4B9C2EA4F09C7DBB7", hash_generated_method = "274D58AACBBF4DB343AA2A76062577D5")
    @Override
    public Intent getLaunchIntentForPackage(String packageName) {
        addTaint(packageName.getTaint());
        Intent intentToResolve = new Intent(Intent.ACTION_MAIN);
        intentToResolve.addCategory(Intent.CATEGORY_INFO);
        intentToResolve.setPackage(packageName);
        List<ResolveInfo> ris = queryIntentActivities(intentToResolve, 0);
        if(ris == null || ris.size() <= 0)        
        {
            intentToResolve.removeCategory(Intent.CATEGORY_INFO);
            intentToResolve.addCategory(Intent.CATEGORY_LAUNCHER);
            intentToResolve.setPackage(packageName);
            ris = queryIntentActivities(intentToResolve, 0);
        } //End block
        if(ris == null || ris.size() <= 0)        
        {
Intent var540C13E9E156B687226421B24F2DF178_680702703 =             null;
            var540C13E9E156B687226421B24F2DF178_680702703.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_680702703;
        } //End block
        Intent intent = new Intent(intentToResolve);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(ris.get(0).activityInfo.packageName,
                ris.get(0).activityInfo.name);
Intent var095937E5B36214360A2644916BF0E8DF_531210330 =         intent;
        var095937E5B36214360A2644916BF0E8DF_531210330.addTaint(taint);
        return var095937E5B36214360A2644916BF0E8DF_531210330;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.478 -0400", hash_original_method = "65CBA80193594BC7AC8CBF648823BDBA", hash_generated_method = "7209B0B555926FA79C1076E02693C272")
    @Override
    public int[] getPackageGids(String packageName) throws NameNotFoundException {
        addTaint(packageName.getTaint());
        try 
        {
            int[] gids = mPM.getPackageGids(packageName);
            if(gids == null || gids.length > 0)            
            {
                int[] var77DBC042260703938C8CA627F28C6CF5_1964733677 = (gids);
                                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_609705985 = {getTaintInt()};
                return varB4CCCA26F9DB9189C32F33E82D425CFB_609705985;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_373521507 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_373521507.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_373521507;
        } //End block
        NameNotFoundException var66F177309B3AAEEE242A13D4F2EC34A7_649254720 = new NameNotFoundException(packageName);
        var66F177309B3AAEEE242A13D4F2EC34A7_649254720.addTaint(taint);
        throw var66F177309B3AAEEE242A13D4F2EC34A7_649254720;
        // ---------- Original Method ----------
        //try {
            //int[] gids = mPM.getPackageGids(packageName);
            //if (gids == null || gids.length > 0) {
                //return gids;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.479 -0400", hash_original_method = "16E2B9223A8B92626D3604D0E58E2278", hash_generated_method = "2CFD0869AB67A397FF8F3DA5C57B924F")
    @Override
    public PermissionInfo getPermissionInfo(String name, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(name.getTaint());
        try 
        {
            PermissionInfo pi = mPM.getPermissionInfo(name, flags);
            if(pi != null)            
            {
PermissionInfo var81D1A2E7B8C8FB24958425A15F743A98_1968511890 =                 pi;
                var81D1A2E7B8C8FB24958425A15F743A98_1968511890.addTaint(taint);
                return var81D1A2E7B8C8FB24958425A15F743A98_1968511890;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_854812987 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_854812987.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_854812987;
        } //End block
        NameNotFoundException varF14FFD89079BEC8EEF84D16341E4DEE7_1774387601 = new NameNotFoundException(name);
        varF14FFD89079BEC8EEF84D16341E4DEE7_1774387601.addTaint(taint);
        throw varF14FFD89079BEC8EEF84D16341E4DEE7_1774387601;
        // ---------- Original Method ----------
        //try {
            //PermissionInfo pi = mPM.getPermissionInfo(name, flags);
            //if (pi != null) {
                //return pi;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.480 -0400", hash_original_method = "2283AA5BDEF3F8B3341260BB74FBE8C3", hash_generated_method = "E399A9C57D7AF7816459250ACDC4C244")
    @Override
    public List<PermissionInfo> queryPermissionsByGroup(String group, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(group.getTaint());
        try 
        {
            List<PermissionInfo> pi = mPM.queryPermissionsByGroup(group, flags);
            if(pi != null)            
            {
List<PermissionInfo> var81D1A2E7B8C8FB24958425A15F743A98_499573949 =                 pi;
                var81D1A2E7B8C8FB24958425A15F743A98_499573949.addTaint(taint);
                return var81D1A2E7B8C8FB24958425A15F743A98_499573949;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_405801295 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_405801295.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_405801295;
        } //End block
        NameNotFoundException varFC268ECE908C7CBE5529583AFF25E51B_272447402 = new NameNotFoundException(group);
        varFC268ECE908C7CBE5529583AFF25E51B_272447402.addTaint(taint);
        throw varFC268ECE908C7CBE5529583AFF25E51B_272447402;
        // ---------- Original Method ----------
        //try {
            //List<PermissionInfo> pi = mPM.queryPermissionsByGroup(group, flags);
            //if (pi != null) {
                //return pi;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(group);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.481 -0400", hash_original_method = "4E576FD7FE2DDB9674E042581657631F", hash_generated_method = "45B2643F56EEA9A0A8D73A1541C0CCE2")
    @Override
    public PermissionGroupInfo getPermissionGroupInfo(String name,
                                                      int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(name.getTaint());
        try 
        {
            PermissionGroupInfo pgi = mPM.getPermissionGroupInfo(name, flags);
            if(pgi != null)            
            {
PermissionGroupInfo var0069CE035D8ABD1A3D2A3A0632D80D0A_1410894735 =                 pgi;
                var0069CE035D8ABD1A3D2A3A0632D80D0A_1410894735.addTaint(taint);
                return var0069CE035D8ABD1A3D2A3A0632D80D0A_1410894735;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1850008590 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1850008590.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1850008590;
        } //End block
        NameNotFoundException varF14FFD89079BEC8EEF84D16341E4DEE7_627563183 = new NameNotFoundException(name);
        varF14FFD89079BEC8EEF84D16341E4DEE7_627563183.addTaint(taint);
        throw varF14FFD89079BEC8EEF84D16341E4DEE7_627563183;
        // ---------- Original Method ----------
        //try {
            //PermissionGroupInfo pgi = mPM.getPermissionGroupInfo(name, flags);
            //if (pgi != null) {
                //return pgi;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.482 -0400", hash_original_method = "DD7F1EBA9089D82A0EEA68FDD3DACC66", hash_generated_method = "1DA74785C5C592AC2A2B882965C8CA21")
    @Override
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        addTaint(flags);
        try 
        {
List<PermissionGroupInfo> var91C1646E85DCB698A1FBCFC4FD1F5BA2_751692064 =             mPM.getAllPermissionGroups(flags);
            var91C1646E85DCB698A1FBCFC4FD1F5BA2_751692064.addTaint(taint);
            return var91C1646E85DCB698A1FBCFC4FD1F5BA2_751692064;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1314278469 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1314278469.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1314278469;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.getAllPermissionGroups(flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.483 -0400", hash_original_method = "8999420BFE5728B346477621EA154ABF", hash_generated_method = "82B8F924F57430B0B3394B04B6A12DFE")
    @Override
    public ApplicationInfo getApplicationInfo(String packageName, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(packageName.getTaint());
        try 
        {
            ApplicationInfo ai = mPM.getApplicationInfo(packageName, flags);
            if(ai != null)            
            {
ApplicationInfo varF0D6783F85B950884EE206D023A357C0_1009180921 =                 ai;
                varF0D6783F85B950884EE206D023A357C0_1009180921.addTaint(taint);
                return varF0D6783F85B950884EE206D023A357C0_1009180921;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1903430919 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1903430919.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1903430919;
        } //End block
        NameNotFoundException var66F177309B3AAEEE242A13D4F2EC34A7_1921518803 = new NameNotFoundException(packageName);
        var66F177309B3AAEEE242A13D4F2EC34A7_1921518803.addTaint(taint);
        throw var66F177309B3AAEEE242A13D4F2EC34A7_1921518803;
        // ---------- Original Method ----------
        //try {
            //ApplicationInfo ai = mPM.getApplicationInfo(packageName, flags);
            //if (ai != null) {
                //return ai;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(packageName);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.485 -0400", hash_original_method = "9B4FC7EA40C0BB7AEEEEEF1D86D28DE8", hash_generated_method = "E21550E75151FD86D3D4A6142FDD0FE6")
    @Override
    public ActivityInfo getActivityInfo(ComponentName className, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(className.getTaint());
        try 
        {
            ActivityInfo ai = mPM.getActivityInfo(className, flags);
            if(ai != null)            
            {
ActivityInfo varF0D6783F85B950884EE206D023A357C0_2072173160 =                 ai;
                varF0D6783F85B950884EE206D023A357C0_2072173160.addTaint(taint);
                return varF0D6783F85B950884EE206D023A357C0_2072173160;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_65114099 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_65114099.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_65114099;
        } //End block
        NameNotFoundException var66DF60946F5E01AC15F21C65B4F5F4F4_2051937610 = new NameNotFoundException(className.toString());
        var66DF60946F5E01AC15F21C65B4F5F4F4_2051937610.addTaint(taint);
        throw var66DF60946F5E01AC15F21C65B4F5F4F4_2051937610;
        // ---------- Original Method ----------
        //try {
            //ActivityInfo ai = mPM.getActivityInfo(className, flags);
            //if (ai != null) {
                //return ai;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(className.toString());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.487 -0400", hash_original_method = "399255B19735D8EC733B05B14D3B4711", hash_generated_method = "3754C13F1FC1578A3C8B2ED96478534B")
    @Override
    public ActivityInfo getReceiverInfo(ComponentName className, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(className.getTaint());
        try 
        {
            ActivityInfo ai = mPM.getReceiverInfo(className, flags);
            if(ai != null)            
            {
ActivityInfo varF0D6783F85B950884EE206D023A357C0_355218881 =                 ai;
                varF0D6783F85B950884EE206D023A357C0_355218881.addTaint(taint);
                return varF0D6783F85B950884EE206D023A357C0_355218881;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_396036511 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_396036511.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_396036511;
        } //End block
        NameNotFoundException var66DF60946F5E01AC15F21C65B4F5F4F4_810809554 = new NameNotFoundException(className.toString());
        var66DF60946F5E01AC15F21C65B4F5F4F4_810809554.addTaint(taint);
        throw var66DF60946F5E01AC15F21C65B4F5F4F4_810809554;
        // ---------- Original Method ----------
        //try {
            //ActivityInfo ai = mPM.getReceiverInfo(className, flags);
            //if (ai != null) {
                //return ai;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(className.toString());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.488 -0400", hash_original_method = "50C1BC4F3995D229FF03E27E05E5BE36", hash_generated_method = "3309ED36135D45055F36D2A8C461CC8B")
    @Override
    public ServiceInfo getServiceInfo(ComponentName className, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(className.getTaint());
        try 
        {
            ServiceInfo si = mPM.getServiceInfo(className, flags);
            if(si != null)            
            {
ServiceInfo var316474D4DA67FD8479E170FE8E19F283_1108446954 =                 si;
                var316474D4DA67FD8479E170FE8E19F283_1108446954.addTaint(taint);
                return var316474D4DA67FD8479E170FE8E19F283_1108446954;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1026868656 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1026868656.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1026868656;
        } //End block
        NameNotFoundException var66DF60946F5E01AC15F21C65B4F5F4F4_1510603923 = new NameNotFoundException(className.toString());
        var66DF60946F5E01AC15F21C65B4F5F4F4_1510603923.addTaint(taint);
        throw var66DF60946F5E01AC15F21C65B4F5F4F4_1510603923;
        // ---------- Original Method ----------
        //try {
            //ServiceInfo si = mPM.getServiceInfo(className, flags);
            //if (si != null) {
                //return si;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(className.toString());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.489 -0400", hash_original_method = "895E4F29ECA72E6836B6F503A466760A", hash_generated_method = "E7A07A387F6F60F8DC69B08152B846F6")
    @Override
    public ProviderInfo getProviderInfo(ComponentName className, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(className.getTaint());
        try 
        {
            ProviderInfo pi = mPM.getProviderInfo(className, flags);
            if(pi != null)            
            {
ProviderInfo var81D1A2E7B8C8FB24958425A15F743A98_550184368 =                 pi;
                var81D1A2E7B8C8FB24958425A15F743A98_550184368.addTaint(taint);
                return var81D1A2E7B8C8FB24958425A15F743A98_550184368;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_916700709 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_916700709.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_916700709;
        } //End block
        NameNotFoundException var66DF60946F5E01AC15F21C65B4F5F4F4_890731530 = new NameNotFoundException(className.toString());
        var66DF60946F5E01AC15F21C65B4F5F4F4_890731530.addTaint(taint);
        throw var66DF60946F5E01AC15F21C65B4F5F4F4_890731530;
        // ---------- Original Method ----------
        //try {
            //ProviderInfo pi = mPM.getProviderInfo(className, flags);
            //if (pi != null) {
                //return pi;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(className.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.490 -0400", hash_original_method = "E90BE84736723B0914BD9D43484D5AAD", hash_generated_method = "C932B6DE7021C8544907151C59AB2F74")
    @Override
    public String[] getSystemSharedLibraryNames() {
        try 
        {
String[] varB1CFFA988E3DBD9614F638D068F4C165_188176036 =             mPM.getSystemSharedLibraryNames();
            varB1CFFA988E3DBD9614F638D068F4C165_188176036.addTaint(taint);
            return varB1CFFA988E3DBD9614F638D068F4C165_188176036;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_2146221950 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_2146221950.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_2146221950;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.getSystemSharedLibraryNames();
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.491 -0400", hash_original_method = "887B55B734ED0895C5FA7D7CF721CE58", hash_generated_method = "672DC17FB47C0C573D0AA94A29FA1D8C")
    @Override
    public FeatureInfo[] getSystemAvailableFeatures() {
        try 
        {
FeatureInfo[] varB0F22BA1AFC32A4106709CF6A7CA068D_494971639 =             mPM.getSystemAvailableFeatures();
            varB0F22BA1AFC32A4106709CF6A7CA068D_494971639.addTaint(taint);
            return varB0F22BA1AFC32A4106709CF6A7CA068D_494971639;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1224092773 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1224092773.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1224092773;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.getSystemAvailableFeatures();
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.492 -0400", hash_original_method = "8E2B8D0B6C29BED8B3E866F74247B636", hash_generated_method = "C3548E5C2DD55A58CA5B4CC6711C78D0")
    @Override
    public boolean hasSystemFeature(String name) {
        addTaint(name.getTaint());
        try 
        {
            boolean var37ADF61D22F136777D5E2BF32F95BB22_362450113 = (mPM.hasSystemFeature(name));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_165274926 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_165274926;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1373920024 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1373920024.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1373920024;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.hasSystemFeature(name);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.493 -0400", hash_original_method = "D191D3716589DABF1290937DD7F4276D", hash_generated_method = "8378C3C69E79CAD05DA445DFE09C247F")
    @Override
    public int checkPermission(String permName, String pkgName) {
        addTaint(pkgName.getTaint());
        addTaint(permName.getTaint());
        try 
        {
            int varDF0DA18627386C79194F175EB75BB229_1397547397 = (mPM.checkPermission(permName, pkgName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_3436689 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_3436689;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_46287263 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_46287263.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_46287263;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.checkPermission(permName, pkgName);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.494 -0400", hash_original_method = "7DE747A31A0FDE2C95A03117CF8EC1E2", hash_generated_method = "54AAC86C44CB1AFEC7510831B5C8E20C")
    @Override
    public boolean addPermission(PermissionInfo info) {
        addTaint(info.getTaint());
        try 
        {
            boolean var4D1C33C7B58570D1EC7C0220D2C194EB_1197375580 = (mPM.addPermission(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1497945425 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1497945425;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1452520973 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1452520973.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1452520973;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.addPermission(info);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.495 -0400", hash_original_method = "BE955F868C92CCDF8275E95FFE2C44B3", hash_generated_method = "15A0F63B6FAE029BD8F4373DB0361AE6")
    @Override
    public boolean addPermissionAsync(PermissionInfo info) {
        addTaint(info.getTaint());
        try 
        {
            boolean var8881271C5790813BCB37EA64363A8107_1279042878 = (mPM.addPermissionAsync(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322047599 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322047599;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1968375375 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1968375375.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1968375375;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.addPermissionAsync(info);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.497 -0400", hash_original_method = "3B9F25E30931EF93125264B719A2E2FF", hash_generated_method = "24B9688EB47E5FAC157223784CFC2006")
    @Override
    public void removePermission(String name) {
        addTaint(name.getTaint());
        try 
        {
            mPM.removePermission(name);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1934335404 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1934335404.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1934335404;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.removePermission(name);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.498 -0400", hash_original_method = "7DC6A4F902E735FA721489587F3384CC", hash_generated_method = "85B836F306201502C6278CF7F7F713C8")
    @Override
    public int checkSignatures(String pkg1, String pkg2) {
        addTaint(pkg2.getTaint());
        addTaint(pkg1.getTaint());
        try 
        {
            int var240C22D7ECE302ED357F18D25BCE9FC8_961879856 = (mPM.checkSignatures(pkg1, pkg2));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639406429 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639406429;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_976378443 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_976378443.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_976378443;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.checkSignatures(pkg1, pkg2);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.499 -0400", hash_original_method = "E51AFA66F0FA11E52A6A449B49344AE4", hash_generated_method = "BCC96CD69F1F0200E0612F055F83F793")
    @Override
    public int checkSignatures(int uid1, int uid2) {
        addTaint(uid2);
        addTaint(uid1);
        try 
        {
            int var29BBF1E11C597F71DD50DDF6CFC1E31E_2094269840 = (mPM.checkUidSignatures(uid1, uid2));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45269355 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45269355;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_485385067 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_485385067.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_485385067;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.checkUidSignatures(uid1, uid2);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.500 -0400", hash_original_method = "A565AD9EB181443BBE8F338808A2E4B9", hash_generated_method = "8CE9ED85AE6EBCBAA1D3242B50F7D36A")
    @Override
    public String[] getPackagesForUid(int uid) {
        addTaint(uid);
        try 
        {
String[] varD991A7FF694DD380F485AA5D6A4F3DB8_1230902820 =             mPM.getPackagesForUid(uid);
            varD991A7FF694DD380F485AA5D6A4F3DB8_1230902820.addTaint(taint);
            return varD991A7FF694DD380F485AA5D6A4F3DB8_1230902820;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1128032483 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1128032483.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1128032483;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.getPackagesForUid(uid);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.501 -0400", hash_original_method = "107797D329CAA491AA1A678294A11B0E", hash_generated_method = "5C5368C1796A9A61D50AC7F1F01AF285")
    @Override
    public String getNameForUid(int uid) {
        addTaint(uid);
        try 
        {
String var6CF9536D701B4110CD0A13C848A0721A_649886311 =             mPM.getNameForUid(uid);
            var6CF9536D701B4110CD0A13C848A0721A_649886311.addTaint(taint);
            return var6CF9536D701B4110CD0A13C848A0721A_649886311;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1529149729 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1529149729.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1529149729;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.getNameForUid(uid);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.503 -0400", hash_original_method = "BCD62F04CBDED38DF225700C99BB4852", hash_generated_method = "D7902E34DAE8A101B11B28F060C8A8A1")
    @Override
    public int getUidForSharedUser(String sharedUserName) throws NameNotFoundException {
        addTaint(sharedUserName.getTaint());
        try 
        {
            int uid = mPM.getUidForSharedUser(sharedUserName);
            if(uid != -1)            
            {
                int var9871D3A2C554B27151CACF1422EEC048_1787026130 = (uid);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512853745 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512853745;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_2018566068 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_2018566068.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_2018566068;
        } //End block
        NameNotFoundException var370BCF6F4CD709E6AA3B0E291A19BA32_1993479361 = new NameNotFoundException("No shared userid for user:"+sharedUserName);
        var370BCF6F4CD709E6AA3B0E291A19BA32_1993479361.addTaint(taint);
        throw var370BCF6F4CD709E6AA3B0E291A19BA32_1993479361;
        // ---------- Original Method ----------
        //try {
            //int uid = mPM.getUidForSharedUser(sharedUserName);
            //if(uid != -1) {
                //return uid;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException("No shared userid for user:"+sharedUserName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.505 -0400", hash_original_method = "2CD6168D318C89447F6184EBDE96189F", hash_generated_method = "A28C914C07CB823F94F28EE3A67F0DF0")
    @SuppressWarnings("unchecked")
    @Override
    public List<PackageInfo> getInstalledPackages(int flags) {
        addTaint(flags);
        try 
        {
            final List<PackageInfo> packageInfos = new ArrayList<PackageInfo>();
            PackageInfo lastItem = null;
            ParceledListSlice<PackageInfo> slice;
            do {
                {
                    final String lastKey = lastItem != null ? lastItem.packageName : null;
                    slice = mPM.getInstalledPackages(flags, lastKey);
                    lastItem = slice.populateList(packageInfos, PackageInfo.CREATOR);
                } //End block
} while (!slice.isLastSlice());
List<PackageInfo> var37101830B2D3C6C85473948F9AF68DFB_1382497186 =             packageInfos;
            var37101830B2D3C6C85473948F9AF68DFB_1382497186.addTaint(taint);
            return var37101830B2D3C6C85473948F9AF68DFB_1382497186;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_39736295 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_39736295.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_39736295;
        } //End block
        // ---------- Original Method ----------
        //try {
            //final List<PackageInfo> packageInfos = new ArrayList<PackageInfo>();
            //PackageInfo lastItem = null;
            //ParceledListSlice<PackageInfo> slice;
            //do {
                //final String lastKey = lastItem != null ? lastItem.packageName : null;
                //slice = mPM.getInstalledPackages(flags, lastKey);
                //lastItem = slice.populateList(packageInfos, PackageInfo.CREATOR);
            //} while (!slice.isLastSlice());
            //return packageInfos;
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.507 -0400", hash_original_method = "195CA5538214D0B5EDE14A1F47A96E96", hash_generated_method = "AA750D3E28D7B665895066A21808BF0B")
    @SuppressWarnings("unchecked")
    @Override
    public List<ApplicationInfo> getInstalledApplications(int flags) {
        addTaint(flags);
        try 
        {
            final List<ApplicationInfo> applicationInfos = new ArrayList<ApplicationInfo>();
            ApplicationInfo lastItem = null;
            ParceledListSlice<ApplicationInfo> slice;
            do {
                {
                    final String lastKey = lastItem != null ? lastItem.packageName : null;
                    slice = mPM.getInstalledApplications(flags, lastKey);
                    lastItem = slice.populateList(applicationInfos, ApplicationInfo.CREATOR);
                } //End block
} while (!slice.isLastSlice());
List<ApplicationInfo> var476DDE830C1E7D654398FCDB6BE91BEE_167813766 =             applicationInfos;
            var476DDE830C1E7D654398FCDB6BE91BEE_167813766.addTaint(taint);
            return var476DDE830C1E7D654398FCDB6BE91BEE_167813766;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1920070775 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1920070775.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1920070775;
        } //End block
        // ---------- Original Method ----------
        //try {
            //final List<ApplicationInfo> applicationInfos = new ArrayList<ApplicationInfo>();
            //ApplicationInfo lastItem = null;
            //ParceledListSlice<ApplicationInfo> slice;
            //do {
                //final String lastKey = lastItem != null ? lastItem.packageName : null;
                //slice = mPM.getInstalledApplications(flags, lastKey);
                //lastItem = slice.populateList(applicationInfos, ApplicationInfo.CREATOR);
            //} while (!slice.isLastSlice());
            //return applicationInfos;
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.508 -0400", hash_original_method = "0CD7CD39AE65A355BC33F2BA54C4DC37", hash_generated_method = "FEC78E457F734589ADC45025AF747C74")
    @Override
    public ResolveInfo resolveActivity(Intent intent, int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        try 
        {
ResolveInfo var53CD1929C11A1EFD4D6D1E47C7C7A408_491368764 =             mPM.resolveIntent(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
            var53CD1929C11A1EFD4D6D1E47C7C7A408_491368764.addTaint(taint);
            return var53CD1929C11A1EFD4D6D1E47C7C7A408_491368764;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1187367303 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1187367303.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1187367303;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.resolveIntent(
                //intent,
                //intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                //flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.510 -0400", hash_original_method = "613ED89A001624360A0EB6B3BD081707", hash_generated_method = "A298F7957AB6CB8A7341CC27BBC3B688")
    @Override
    public List<ResolveInfo> queryIntentActivities(Intent intent,
                                                   int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        try 
        {
List<ResolveInfo> var959EC25C5EAA6CFAF2C68E5802ED225B_721605581 =             mPM.queryIntentActivities(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
            var959EC25C5EAA6CFAF2C68E5802ED225B_721605581.addTaint(taint);
            return var959EC25C5EAA6CFAF2C68E5802ED225B_721605581;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1341614873 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1341614873.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1341614873;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.queryIntentActivities(
                //intent,
                //intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                //flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.512 -0400", hash_original_method = "9B955FD88A95F7C1CCD0CD1DFE6EC270", hash_generated_method = "C2F2476D2E19D24903430028346BAB3A")
    @Override
    public List<ResolveInfo> queryIntentActivityOptions(
        ComponentName caller, Intent[] specifics, Intent intent,
        int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        addTaint(specifics[0].getTaint());
        addTaint(caller.getTaint());
        final ContentResolver resolver = mContext.getContentResolver();
        String[] specificTypes = null;
        if(specifics != null)        
        {
            final int N = specifics.length;
for(int i=0;i<N;i++)
            {
                Intent sp = specifics[i];
                if(sp != null)                
                {
                    String t = sp.resolveTypeIfNeeded(resolver);
                    if(t != null)                    
                    {
                        if(specificTypes == null)                        
                        {
                            specificTypes = new String[N];
                        } //End block
                        specificTypes[i] = t;
                    } //End block
                } //End block
            } //End block
        } //End block
        try 
        {
List<ResolveInfo> var98A7E75C8E2130DCDDB36B3CBCB21C1D_1253778286 =             mPM.queryIntentActivityOptions(caller, specifics,
                                                  specificTypes, intent, intent.resolveTypeIfNeeded(resolver),
                                                  flags);
            var98A7E75C8E2130DCDDB36B3CBCB21C1D_1253778286.addTaint(taint);
            return var98A7E75C8E2130DCDDB36B3CBCB21C1D_1253778286;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_534734344 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_534734344.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_534734344;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.514 -0400", hash_original_method = "2B65A8BDA3BE53DC3296D1F5CA76CDFC", hash_generated_method = "D98C226CD8F20B7383C3E9591374F8E6")
    @Override
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        try 
        {
List<ResolveInfo> var8B6E5F8859DD8885402EF5F1767EE1FF_571363295 =             mPM.queryIntentReceivers(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
            var8B6E5F8859DD8885402EF5F1767EE1FF_571363295.addTaint(taint);
            return var8B6E5F8859DD8885402EF5F1767EE1FF_571363295;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1661541357 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1661541357.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1661541357;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.queryIntentReceivers(
                //intent,
                //intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                //flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.515 -0400", hash_original_method = "D7D4C733DB611C9D18D346868F9BD0BD", hash_generated_method = "49895F98A32ED15CE123135D4A923D4D")
    @Override
    public ResolveInfo resolveService(Intent intent, int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        try 
        {
ResolveInfo var8DF144ADA7D834C2B6445C66A11819F1_2124453721 =             mPM.resolveService(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
            var8DF144ADA7D834C2B6445C66A11819F1_2124453721.addTaint(taint);
            return var8DF144ADA7D834C2B6445C66A11819F1_2124453721;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_68171413 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_68171413.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_68171413;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.resolveService(
                //intent,
                //intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                //flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.516 -0400", hash_original_method = "EEB4EB852740846BAD76CCDE5FC0C613", hash_generated_method = "17F454501B84748CE6E38EF9F120463B")
    @Override
    public List<ResolveInfo> queryIntentServices(Intent intent, int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        try 
        {
List<ResolveInfo> varAA78B32437C8D73EC53A2D8EEABDF0C8_1970237976 =             mPM.queryIntentServices(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
            varAA78B32437C8D73EC53A2D8EEABDF0C8_1970237976.addTaint(taint);
            return varAA78B32437C8D73EC53A2D8EEABDF0C8_1970237976;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1161270672 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1161270672.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1161270672;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.queryIntentServices(
                //intent,
                //intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                //flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.517 -0400", hash_original_method = "3A6513CB26C2E0AF7DACFC2B8A5D560B", hash_generated_method = "E0F67741BB14569840DB6C2D60913801")
    @Override
    public ProviderInfo resolveContentProvider(String name,
                                               int flags) {
        addTaint(flags);
        addTaint(name.getTaint());
        try 
        {
ProviderInfo var9E926164775746E1973A744D08359501_690688923 =             mPM.resolveContentProvider(name, flags);
            var9E926164775746E1973A744D08359501_690688923.addTaint(taint);
            return var9E926164775746E1973A744D08359501_690688923;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1079757336 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1079757336.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1079757336;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.resolveContentProvider(name, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.518 -0400", hash_original_method = "7B04A4BE8EFECF5209DBE4F77CB67C42", hash_generated_method = "FCEBF775E14CF29FFA3000A496599CCA")
    @Override
    public List<ProviderInfo> queryContentProviders(String processName,
                                                    int uid, int flags) {
        addTaint(flags);
        addTaint(uid);
        addTaint(processName.getTaint());
        try 
        {
List<ProviderInfo> var649783037687051D01975EFAA3A897C3_91352090 =             mPM.queryContentProviders(processName, uid, flags);
            var649783037687051D01975EFAA3A897C3_91352090.addTaint(taint);
            return var649783037687051D01975EFAA3A897C3_91352090;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1870624849 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1870624849.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1870624849;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.queryContentProviders(processName, uid, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.520 -0400", hash_original_method = "3120887453BFC9391A593077A4EB2D8C", hash_generated_method = "42B41CA0AB7FAE8787366ABE6483D892")
    @Override
    public InstrumentationInfo getInstrumentationInfo(
        ComponentName className, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(className.getTaint());
        try 
        {
            InstrumentationInfo ii = mPM.getInstrumentationInfo(
                className, flags);
            if(ii != null)            
            {
InstrumentationInfo var271C06C7ED7711E7D563AD4C67B1449E_1260075864 =                 ii;
                var271C06C7ED7711E7D563AD4C67B1449E_1260075864.addTaint(taint);
                return var271C06C7ED7711E7D563AD4C67B1449E_1260075864;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_997214382 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_997214382.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_997214382;
        } //End block
        NameNotFoundException var66DF60946F5E01AC15F21C65B4F5F4F4_1052131427 = new NameNotFoundException(className.toString());
        var66DF60946F5E01AC15F21C65B4F5F4F4_1052131427.addTaint(taint);
        throw var66DF60946F5E01AC15F21C65B4F5F4F4_1052131427;
        // ---------- Original Method ----------
        //try {
            //InstrumentationInfo ii = mPM.getInstrumentationInfo(
                //className, flags);
            //if (ii != null) {
                //return ii;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(className.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.520 -0400", hash_original_method = "0CE547FAA1F9EB003838A9DE59E3AC72", hash_generated_method = "7A6B56C16E52615B08967A55A9E5EEFE")
    @Override
    public List<InstrumentationInfo> queryInstrumentation(
        String targetPackage, int flags) {
        addTaint(flags);
        addTaint(targetPackage.getTaint());
        try 
        {
List<InstrumentationInfo> varDACF4DF210DF604F3051E5EF852D2D12_156732982 =             mPM.queryInstrumentation(targetPackage, flags);
            varDACF4DF210DF604F3051E5EF852D2D12_156732982.addTaint(taint);
            return varDACF4DF210DF604F3051E5EF852D2D12_156732982;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_692663919 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_692663919.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_692663919;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.queryInstrumentation(targetPackage, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.523 -0400", hash_original_method = "350CC4BDDD2E42419F88F44C033409F6", hash_generated_method = "F07B89F10D82EC64570ABF24DBFB0C18")
    @Override
    public Drawable getDrawable(String packageName, int resid,
                                          ApplicationInfo appInfo) {
        addTaint(appInfo.getTaint());
        addTaint(resid);
        addTaint(packageName.getTaint());
        ResourceName name = new ResourceName(packageName, resid);
        Drawable dr = getCachedIcon(name);
        if(dr != null)        
        {
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1480282827 =             dr;
            varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1480282827.addTaint(taint);
            return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1480282827;
        } //End block
        if(appInfo == null)        
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
Drawable var540C13E9E156B687226421B24F2DF178_1409295962 =                 null;
                var540C13E9E156B687226421B24F2DF178_1409295962.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1409295962;
            } //End block
        } //End block
        try 
        {
            Resources r = getResourcesForApplication(appInfo);
            dr = r.getDrawable(resid);
            if(false)            
            {
                RuntimeException e = new RuntimeException("here");
                e.fillInStackTrace();
            } //End block
            if(DEBUG_ICONS){ }            putCachedIcon(name, dr);
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1074620209 =             dr;
            varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1074620209.addTaint(taint);
            return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1074620209;
        } //End block
        catch (NameNotFoundException e)
        {
        } //End block
        catch (Resources.NotFoundException e)
        {
        } //End block
        catch (RuntimeException e)
        {
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_1768820926 =         null;
        var540C13E9E156B687226421B24F2DF178_1768820926.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1768820926;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.524 -0400", hash_original_method = "E8823DE045849946097DF943F50B58DB", hash_generated_method = "46C1F14556851DD6B4ABE4CE1440A40D")
    @Override
    public Drawable getActivityIcon(ComponentName activityName) throws NameNotFoundException {
        addTaint(activityName.getTaint());
Drawable var0D423A11B11A8CD7FA1178796A4F2B7F_706346570 =         getActivityInfo(activityName, 0).loadIcon(this);
        var0D423A11B11A8CD7FA1178796A4F2B7F_706346570.addTaint(taint);
        return var0D423A11B11A8CD7FA1178796A4F2B7F_706346570;
        // ---------- Original Method ----------
        //return getActivityInfo(activityName, 0).loadIcon(this);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.525 -0400", hash_original_method = "EF5F409F30F5D50F1964B6AB6B7F75B7", hash_generated_method = "CF544CF96A7FE6F1BA2AFF32FA1D88B8")
    @Override
    public Drawable getActivityIcon(Intent intent) throws NameNotFoundException {
        addTaint(intent.getTaint());
        if(intent.getComponent() != null)        
        {
Drawable var748F36A39B1B34880A2295BB00CF09EE_1032866930 =             getActivityIcon(intent.getComponent());
            var748F36A39B1B34880A2295BB00CF09EE_1032866930.addTaint(taint);
            return var748F36A39B1B34880A2295BB00CF09EE_1032866930;
        } //End block
        ResolveInfo info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        if(info != null)        
        {
Drawable var990B62C26486EA3F0D8131DEA96B2165_1993540753 =             info.activityInfo.loadIcon(this);
            var990B62C26486EA3F0D8131DEA96B2165_1993540753.addTaint(taint);
            return var990B62C26486EA3F0D8131DEA96B2165_1993540753;
        } //End block
        NameNotFoundException varE2BCF5174B94F5AAA49C789D58CFD1E0_716807765 = new NameNotFoundException(intent.toUri(0));
        varE2BCF5174B94F5AAA49C789D58CFD1E0_716807765.addTaint(taint);
        throw varE2BCF5174B94F5AAA49C789D58CFD1E0_716807765;
        // ---------- Original Method ----------
        //if (intent.getComponent() != null) {
            //return getActivityIcon(intent.getComponent());
        //}
        //ResolveInfo info = resolveActivity(
            //intent, PackageManager.MATCH_DEFAULT_ONLY);
        //if (info != null) {
            //return info.activityInfo.loadIcon(this);
        //}
        //throw new NameNotFoundException(intent.toUri(0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.527 -0400", hash_original_method = "27F8B828FEA8943560AD77E4760B6964", hash_generated_method = "F65853D056BC03BDD939B40FA4341A96")
    @Override
    public Drawable getDefaultActivityIcon() {
Drawable var859ABD8972B57052B4D0C8A531A2DC09_1836509271 =         Resources.getSystem().getDrawable(
            com.android.internal.R.drawable.sym_def_app_icon);
        var859ABD8972B57052B4D0C8A531A2DC09_1836509271.addTaint(taint);
        return var859ABD8972B57052B4D0C8A531A2DC09_1836509271;
        // ---------- Original Method ----------
        //return Resources.getSystem().getDrawable(
            //com.android.internal.R.drawable.sym_def_app_icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.529 -0400", hash_original_method = "C2186A062EDEC18E9DD8F87E8E6291D1", hash_generated_method = "E4A6EDFCDEEFEF42F642A305D0DB1771")
    @Override
    public Drawable getApplicationIcon(ApplicationInfo info) {
        addTaint(info.getTaint());
Drawable varBD36481CAA11421D1D3A0F1FC1E02B60_1027711991 =         info.loadIcon(this);
        varBD36481CAA11421D1D3A0F1FC1E02B60_1027711991.addTaint(taint);
        return varBD36481CAA11421D1D3A0F1FC1E02B60_1027711991;
        // ---------- Original Method ----------
        //return info.loadIcon(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.531 -0400", hash_original_method = "49256B647BD52234F52BC973E3B03E0B", hash_generated_method = "4109FA170D48E49504871C015A263B9F")
    @Override
    public Drawable getApplicationIcon(String packageName) throws NameNotFoundException {
        addTaint(packageName.getTaint());
Drawable var574026DF4A89469F5BF04AF6F860243F_298367045 =         getApplicationIcon(getApplicationInfo(packageName, 0));
        var574026DF4A89469F5BF04AF6F860243F_298367045.addTaint(taint);
        return var574026DF4A89469F5BF04AF6F860243F_298367045;
        // ---------- Original Method ----------
        //return getApplicationIcon(getApplicationInfo(packageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.532 -0400", hash_original_method = "12128D2FB1F753A28280A7EF3E62F4B2", hash_generated_method = "2BA2DB34E7C1265CA6A0E17AC02BAFB2")
    @Override
    public Drawable getActivityLogo(ComponentName activityName) throws NameNotFoundException {
        addTaint(activityName.getTaint());
Drawable varE23F661D14D7DE981F8F4A7E8A778432_1214826621 =         getActivityInfo(activityName, 0).loadLogo(this);
        varE23F661D14D7DE981F8F4A7E8A778432_1214826621.addTaint(taint);
        return varE23F661D14D7DE981F8F4A7E8A778432_1214826621;
        // ---------- Original Method ----------
        //return getActivityInfo(activityName, 0).loadLogo(this);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.533 -0400", hash_original_method = "3B1A86BB5E25FB8EFA7A1AD1A88B3B01", hash_generated_method = "0004414D651B51F90513C3937D2AC9E1")
    @Override
    public Drawable getActivityLogo(Intent intent) throws NameNotFoundException {
        addTaint(intent.getTaint());
        if(intent.getComponent() != null)        
        {
Drawable var3562002FE3C5071329B46257497F8BD9_1370351581 =             getActivityLogo(intent.getComponent());
            var3562002FE3C5071329B46257497F8BD9_1370351581.addTaint(taint);
            return var3562002FE3C5071329B46257497F8BD9_1370351581;
        } //End block
        ResolveInfo info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        if(info != null)        
        {
Drawable varED1E9405C1D23EFCD3BA2615D991D076_4885604 =             info.activityInfo.loadLogo(this);
            varED1E9405C1D23EFCD3BA2615D991D076_4885604.addTaint(taint);
            return varED1E9405C1D23EFCD3BA2615D991D076_4885604;
        } //End block
        NameNotFoundException varE2BCF5174B94F5AAA49C789D58CFD1E0_1193941017 = new NameNotFoundException(intent.toUri(0));
        varE2BCF5174B94F5AAA49C789D58CFD1E0_1193941017.addTaint(taint);
        throw varE2BCF5174B94F5AAA49C789D58CFD1E0_1193941017;
        // ---------- Original Method ----------
        //if (intent.getComponent() != null) {
            //return getActivityLogo(intent.getComponent());
        //}
        //ResolveInfo info = resolveActivity(
            //intent, PackageManager.MATCH_DEFAULT_ONLY);
        //if (info != null) {
            //return info.activityInfo.loadLogo(this);
        //}
        //throw new NameNotFoundException(intent.toUri(0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.534 -0400", hash_original_method = "586E62978169D56092172114763F9AD3", hash_generated_method = "3F434528F6C6BBA729224A27AB23933E")
    @Override
    public Drawable getApplicationLogo(ApplicationInfo info) {
        addTaint(info.getTaint());
Drawable varDE726747D49680B2FA0EDF14A2BA0B2A_90103289 =         info.loadLogo(this);
        varDE726747D49680B2FA0EDF14A2BA0B2A_90103289.addTaint(taint);
        return varDE726747D49680B2FA0EDF14A2BA0B2A_90103289;
        // ---------- Original Method ----------
        //return info.loadLogo(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.534 -0400", hash_original_method = "6BC85FEDD3936A7851329E2331D0279D", hash_generated_method = "6008D85C62909658402C64E876B45409")
    @Override
    public Drawable getApplicationLogo(String packageName) throws NameNotFoundException {
        addTaint(packageName.getTaint());
Drawable varEA72FA4FF4DA7EB2107FAD8967663ED9_1277520572 =         getApplicationLogo(getApplicationInfo(packageName, 0));
        varEA72FA4FF4DA7EB2107FAD8967663ED9_1277520572.addTaint(taint);
        return varEA72FA4FF4DA7EB2107FAD8967663ED9_1277520572;
        // ---------- Original Method ----------
        //return getApplicationLogo(getApplicationInfo(packageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.535 -0400", hash_original_method = "E07E3E36CD8F79CF4FE12B9F33A40344", hash_generated_method = "78256B4E32222D35B6554B58B5A1E2F4")
    @Override
    public Resources getResourcesForActivity(
        ComponentName activityName) throws NameNotFoundException {
        addTaint(activityName.getTaint());
Resources var404E6134F0F48C247F1FD97ECE55C8D7_768455155 =         getResourcesForApplication(
            getActivityInfo(activityName, 0).applicationInfo);
        var404E6134F0F48C247F1FD97ECE55C8D7_768455155.addTaint(taint);
        return var404E6134F0F48C247F1FD97ECE55C8D7_768455155;
        // ---------- Original Method ----------
        //return getResourcesForApplication(
            //getActivityInfo(activityName, 0).applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.536 -0400", hash_original_method = "AC20F77416CABFA638F647DA9F2F230E", hash_generated_method = "32A667131BE4D736DA673D2DA2E21A20")
    @Override
    public Resources getResourcesForApplication(
        ApplicationInfo app) throws NameNotFoundException {
        addTaint(app.getTaint());
        if(app.packageName.equals("system"))        
        {
Resources var4F898A4732E2653A7AC6783BA2F7F31E_1303874479 =             mContext.mMainThread.getSystemContext().getResources();
            var4F898A4732E2653A7AC6783BA2F7F31E_1303874479.addTaint(taint);
            return var4F898A4732E2653A7AC6783BA2F7F31E_1303874479;
        } //End block
        Resources r = mContext.mMainThread.getTopLevelResources(
            app.uid == Process.myUid() ? app.sourceDir
            : app.publicSourceDir, mContext.mPackageInfo);
        if(r != null)        
        {
Resources var4C1F3C86A0E56B6E375080F5F710547E_1146474677 =             r;
            var4C1F3C86A0E56B6E375080F5F710547E_1146474677.addTaint(taint);
            return var4C1F3C86A0E56B6E375080F5F710547E_1146474677;
        } //End block
        NameNotFoundException varB62EA499239502213DE0ED312AC15705_2127077185 = new NameNotFoundException("Unable to open " + app.publicSourceDir);
        varB62EA499239502213DE0ED312AC15705_2127077185.addTaint(taint);
        throw varB62EA499239502213DE0ED312AC15705_2127077185;
        // ---------- Original Method ----------
        //if (app.packageName.equals("system")) {
            //return mContext.mMainThread.getSystemContext().getResources();
        //}
        //Resources r = mContext.mMainThread.getTopLevelResources(
            //app.uid == Process.myUid() ? app.sourceDir
            //: app.publicSourceDir, mContext.mPackageInfo);
        //if (r != null) {
            //return r;
        //}
        //throw new NameNotFoundException("Unable to open " + app.publicSourceDir);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.537 -0400", hash_original_method = "ACD444E0FC7FCEAEB5D1FF09DD4A5912", hash_generated_method = "0CBC070BBA25F9F12CDEBEF66DF9AB8E")
    @Override
    public Resources getResourcesForApplication(
        String appPackageName) throws NameNotFoundException {
        addTaint(appPackageName.getTaint());
Resources var4ECAD796BEBC2036726E2B4D3C6D94FC_1364128856 =         getResourcesForApplication(
            getApplicationInfo(appPackageName, 0));
        var4ECAD796BEBC2036726E2B4D3C6D94FC_1364128856.addTaint(taint);
        return var4ECAD796BEBC2036726E2B4D3C6D94FC_1364128856;
        // ---------- Original Method ----------
        //return getResourcesForApplication(
            //getApplicationInfo(appPackageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.538 -0400", hash_original_method = "6B2AA9A609FE89D703EEC81AF1FC0890", hash_generated_method = "44DB529C52BA19FE727992FDF91DAB81")
    @Override
    public boolean isSafeMode() {
        try 
        {
            if(mCachedSafeMode < 0)            
            {
                mCachedSafeMode = mPM.isSafeMode() ? 1 : 0;
            } //End block
            boolean varDFE9EA0892C8F91B8CB2C26127C7633F_1866195642 = (mCachedSafeMode != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_871574565 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_871574565;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1797732834 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1797732834.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1797732834;
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mCachedSafeMode < 0) {
                //mCachedSafeMode = mPM.isSafeMode() ? 1 : 0;
            //}
            //return mCachedSafeMode != 0;
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    static void configurationChanged() {
        synchronized (sSync) {
            sIconCache.clear();
            sStringCache.clear();
        }
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.540 -0400", hash_original_method = "805BC435FDAE098AFC4F53B40E89D7C1", hash_generated_method = "113AC83B03024E210A2E61C49E5FC61F")
    private Drawable getCachedIcon(ResourceName name) {
        addTaint(name.getTaint());
        synchronized
(sSync)        {
            WeakReference<Drawable.ConstantState> wr = sIconCache.get(name);
            if(DEBUG_ICONS){ }            if(wr != null)            
            {
                Drawable.ConstantState state = wr.get();
                if(state != null)                
                {
                    if(DEBUG_ICONS)                    
                    {
                    } //End block
Drawable var0CE7D3E7B0B3584DE52FC6510C98BEA7_2125435265 =                     state.newDrawable();
                    var0CE7D3E7B0B3584DE52FC6510C98BEA7_2125435265.addTaint(taint);
                    return var0CE7D3E7B0B3584DE52FC6510C98BEA7_2125435265;
                } //End block
                sIconCache.remove(name);
            } //End block
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_323226357 =         null;
        var540C13E9E156B687226421B24F2DF178_323226357.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_323226357;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.541 -0400", hash_original_method = "1ADDA1851B7207BD0D6C119E2C63D6A2", hash_generated_method = "AC3861F30662FDCC0F506F5C2283D5F8")
    private void putCachedIcon(ResourceName name, Drawable dr) {
        addTaint(dr.getTaint());
        addTaint(name.getTaint());
        synchronized
(sSync)        {
            sIconCache.put(name, new WeakReference<Drawable.ConstantState>(dr.getConstantState()));
            if(DEBUG_ICONS){ }
        } //End block
        // ---------- Original Method ----------
        //synchronized (sSync) {
            //sIconCache.put(name, new WeakReference<Drawable.ConstantState>(dr.getConstantState()));
            //if (DEBUG_ICONS) Log.v(TAG, "Added cached drawable state for " + name + ": " + dr);
        //}
    }

    
    @DSModeled(DSC.BAN)
    static void handlePackageBroadcast(int cmd, String[] pkgList, boolean hasPkgInfo) {
        boolean immediateGc = false;
        if (cmd == IApplicationThread.EXTERNAL_STORAGE_UNAVAILABLE) {
            immediateGc = true;
        }
        if (pkgList != null && (pkgList.length > 0)) {
            boolean needCleanup = false;
            for (String ssp : pkgList) {
                synchronized (sSync) {
                    if (sIconCache.size() > 0) {
                        Iterator<ResourceName> it = sIconCache.keySet().iterator();
                        while (it.hasNext()) {
                            ResourceName nm = it.next();
                            if (nm.packageName.equals(ssp)) {
                                it.remove();
                                needCleanup = true;
                            }
                        }
                    }
                    if (sStringCache.size() > 0) {
                        Iterator<ResourceName> it = sStringCache.keySet().iterator();
                        while (it.hasNext()) {
                            ResourceName nm = it.next();
                            if (nm.packageName.equals(ssp)) {
                                it.remove();
                                needCleanup = true;
                            }
                        }
                    }
                }
            }
            if (needCleanup || hasPkgInfo) {
                if (immediateGc) {
                    Runtime.getRuntime().gc();
                } else {
                    ActivityThread.currentActivityThread().scheduleGcIdler();
                }
            }
        }
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.544 -0400", hash_original_method = "B66098C8E55783775B73FA7D73879D41", hash_generated_method = "92B0CA613B75981B2E3008A65D7FF32C")
    private CharSequence getCachedString(ResourceName name) {
        addTaint(name.getTaint());
        synchronized
(sSync)        {
            WeakReference<CharSequence> wr = sStringCache.get(name);
            if(wr != null)            
            {
                CharSequence cs = wr.get();
                if(cs != null)                
                {
CharSequence varE661418CFE0D2CECDB5DF6FE0739403D_521395787 =                     cs;
                    varE661418CFE0D2CECDB5DF6FE0739403D_521395787.addTaint(taint);
                    return varE661418CFE0D2CECDB5DF6FE0739403D_521395787;
                } //End block
                sStringCache.remove(name);
            } //End block
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_175742070 =         null;
        var540C13E9E156B687226421B24F2DF178_175742070.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_175742070;
        // ---------- Original Method ----------
        //synchronized (sSync) {
            //WeakReference<CharSequence> wr = sStringCache.get(name);
            //if (wr != null) {   
                //CharSequence cs = wr.get();
                //if (cs != null) {
                    //return cs;
                //}
                //sStringCache.remove(name);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.545 -0400", hash_original_method = "70E4290F1842F0A45B89D50D6CDEDDBB", hash_generated_method = "0BE61ABF45CCAED0BAE893C4FC9BC606")
    private void putCachedString(ResourceName name, CharSequence cs) {
        addTaint(cs.getTaint());
        addTaint(name.getTaint());
        synchronized
(sSync)        {
            sStringCache.put(name, new WeakReference<CharSequence>(cs));
        } //End block
        // ---------- Original Method ----------
        //synchronized (sSync) {
            //sStringCache.put(name, new WeakReference<CharSequence>(cs));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.547 -0400", hash_original_method = "771B010EDE230C24A313E1F6F3869FDB", hash_generated_method = "BADD9F007555255B52A9A8A10440D8EB")
    @Override
    public CharSequence getText(String packageName, int resid,
                                ApplicationInfo appInfo) {
        addTaint(appInfo.getTaint());
        addTaint(resid);
        addTaint(packageName.getTaint());
        ResourceName name = new ResourceName(packageName, resid);
        CharSequence text = getCachedString(name);
        if(text != null)        
        {
CharSequence var79CC641C1148018540A26F7ADC424893_598554091 =             text;
            var79CC641C1148018540A26F7ADC424893_598554091.addTaint(taint);
            return var79CC641C1148018540A26F7ADC424893_598554091;
        } //End block
        if(appInfo == null)        
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
CharSequence var540C13E9E156B687226421B24F2DF178_948448427 =                 null;
                var540C13E9E156B687226421B24F2DF178_948448427.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_948448427;
            } //End block
        } //End block
        try 
        {
            Resources r = getResourcesForApplication(appInfo);
            text = r.getText(resid);
            putCachedString(name, text);
CharSequence var79CC641C1148018540A26F7ADC424893_400554648 =             text;
            var79CC641C1148018540A26F7ADC424893_400554648.addTaint(taint);
            return var79CC641C1148018540A26F7ADC424893_400554648;
        } //End block
        catch (NameNotFoundException e)
        {
        } //End block
        catch (RuntimeException e)
        {
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_941758096 =         null;
        var540C13E9E156B687226421B24F2DF178_941758096.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_941758096;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.548 -0400", hash_original_method = "F130C54905A9CE16326CF20EF6E93255", hash_generated_method = "EE462C9EB3093E3ECBE25541911E1415")
    @Override
    public XmlResourceParser getXml(String packageName, int resid,
                                    ApplicationInfo appInfo) {
        addTaint(appInfo.getTaint());
        addTaint(resid);
        addTaint(packageName.getTaint());
        if(appInfo == null)        
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
XmlResourceParser var540C13E9E156B687226421B24F2DF178_1387027633 =                 null;
                var540C13E9E156B687226421B24F2DF178_1387027633.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1387027633;
            } //End block
        } //End block
        try 
        {
            Resources r = getResourcesForApplication(appInfo);
XmlResourceParser var46FC7866FFAC31CEDC61632F8441D270_1340538318 =             r.getXml(resid);
            var46FC7866FFAC31CEDC61632F8441D270_1340538318.addTaint(taint);
            return var46FC7866FFAC31CEDC61632F8441D270_1340538318;
        } //End block
        catch (RuntimeException e)
        {
        } //End block
        catch (NameNotFoundException e)
        {
        } //End block
XmlResourceParser var540C13E9E156B687226421B24F2DF178_1458852341 =         null;
        var540C13E9E156B687226421B24F2DF178_1458852341.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1458852341;
        // ---------- Original Method ----------
        //if (appInfo == null) {
            //try {
                //appInfo = getApplicationInfo(packageName, 0);
            //} catch (NameNotFoundException e) {
                //return null;
            //}
        //}
        //try {
            //Resources r = getResourcesForApplication(appInfo);
            //return r.getXml(resid);
        //} catch (RuntimeException e) {
            //Log.w("PackageManager", "Failure retrieving xml 0x"
                  //+ Integer.toHexString(resid) + " in package "
                  //+ packageName, e);
        //} catch (NameNotFoundException e) {
            //Log.w("PackageManager", "Failure retrieving resources for "
                  //+ appInfo.packageName);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.550 -0400", hash_original_method = "4AFDE050276913F392973B277F54706D", hash_generated_method = "6C996E760AC4A78F59DF802A2BF4D994")
    @Override
    public CharSequence getApplicationLabel(ApplicationInfo info) {
        addTaint(info.getTaint());
CharSequence varE6B628DF4BADE921BC959EBAA37CE23C_1671011296 =         info.loadLabel(this);
        varE6B628DF4BADE921BC959EBAA37CE23C_1671011296.addTaint(taint);
        return varE6B628DF4BADE921BC959EBAA37CE23C_1671011296;
        // ---------- Original Method ----------
        //return info.loadLabel(this);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.551 -0400", hash_original_method = "99610A6DD5E10C01303307EBA6938AA8", hash_generated_method = "2A5B0EA45A3D6EA2D700B737770C1E15")
    @Override
    public void installPackage(Uri packageURI, IPackageInstallObserver observer, int flags,
                               String installerPackageName) {
        addTaint(installerPackageName.getTaint());
        addTaint(flags);
        addTaint(observer.getTaint());
        addTaint(packageURI.getTaint());
        try 
        {
            mPM.installPackage(packageURI, observer, flags, installerPackageName);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.installPackage(packageURI, observer, flags, installerPackageName);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.553 -0400", hash_original_method = "769145FCC72852B2314845C8A89A2DAD", hash_generated_method = "444D9A5DE967A3750EA4B71318F6E866")
    @Override
    public void installPackageWithVerification(Uri packageURI, IPackageInstallObserver observer,
            int flags, String installerPackageName, Uri verificationURI,
            ManifestDigest manifestDigest) {
        addTaint(manifestDigest.getTaint());
        addTaint(verificationURI.getTaint());
        addTaint(installerPackageName.getTaint());
        addTaint(flags);
        addTaint(observer.getTaint());
        addTaint(packageURI.getTaint());
        try 
        {
            mPM.installPackageWithVerification(packageURI, observer, flags, installerPackageName,
                    verificationURI, manifestDigest);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.installPackageWithVerification(packageURI, observer, flags, installerPackageName,
                    //verificationURI, manifestDigest);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.555 -0400", hash_original_method = "E593338881B3E45506EA974F446D2A6B", hash_generated_method = "62CA204D9551A58E7372CB12E6B5754E")
    @Override
    public void verifyPendingInstall(int id, int response) {
        addTaint(response);
        addTaint(id);
        try 
        {
            mPM.verifyPendingInstall(id, response);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.verifyPendingInstall(id, response);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.557 -0400", hash_original_method = "A168A8E169316429D31E261AD639AED4", hash_generated_method = "F58CD5A8DA31BE565243A0A5975D77BF")
    @Override
    public void setInstallerPackageName(String targetPackage,
            String installerPackageName) {
        addTaint(installerPackageName.getTaint());
        addTaint(targetPackage.getTaint());
        try 
        {
            mPM.setInstallerPackageName(targetPackage, installerPackageName);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.setInstallerPackageName(targetPackage, installerPackageName);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.558 -0400", hash_original_method = "D8F1CA3B8F90BF876B114DD825F09703", hash_generated_method = "03A2C558F2A010B045FEEADA53758B3C")
    @Override
    public void movePackage(String packageName, IPackageMoveObserver observer, int flags) {
        addTaint(flags);
        addTaint(observer.getTaint());
        addTaint(packageName.getTaint());
        try 
        {
            mPM.movePackage(packageName, observer, flags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.movePackage(packageName, observer, flags);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.559 -0400", hash_original_method = "13C0F9FC5FF4142BD538C8A3AADB3621", hash_generated_method = "39FD5AD63B59B0234EF327E7359EB04A")
    @Override
    public String getInstallerPackageName(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
String var485A510364D927E61B680212BA336E80_1663271006 =             mPM.getInstallerPackageName(packageName);
            var485A510364D927E61B680212BA336E80_1663271006.addTaint(taint);
            return var485A510364D927E61B680212BA336E80_1663271006;
        } //End block
        catch (RemoteException e)
        {
        } //End block
String var540C13E9E156B687226421B24F2DF178_168830914 =         null;
        var540C13E9E156B687226421B24F2DF178_168830914.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_168830914;
        // ---------- Original Method ----------
        //try {
            //return mPM.getInstallerPackageName(packageName);
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.560 -0400", hash_original_method = "6B4A8C0BA02325B97A4B696E509E27F1", hash_generated_method = "C4B0DF22FF374AD59393240959C2E93A")
    @Override
    public void deletePackage(String packageName, IPackageDeleteObserver observer, int flags) {
        addTaint(flags);
        addTaint(observer.getTaint());
        addTaint(packageName.getTaint());
        try 
        {
            mPM.deletePackage(packageName, observer, flags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.deletePackage(packageName, observer, flags);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.561 -0400", hash_original_method = "41D4F7CDEA8F3FA97A215E5DB5AE3B7F", hash_generated_method = "039208596E478E2ECAE772814A90F585")
    @Override
    public void clearApplicationUserData(String packageName,
                                         IPackageDataObserver observer) {
        addTaint(observer.getTaint());
        addTaint(packageName.getTaint());
        try 
        {
            mPM.clearApplicationUserData(packageName, observer);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.clearApplicationUserData(packageName, observer);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.561 -0400", hash_original_method = "9E003FA712762A764BBDA3187B8255C1", hash_generated_method = "5BC33433D6FF6317367938E5077B9381")
    @Override
    public void deleteApplicationCacheFiles(String packageName,
                                            IPackageDataObserver observer) {
        addTaint(observer.getTaint());
        addTaint(packageName.getTaint());
        try 
        {
            mPM.deleteApplicationCacheFiles(packageName, observer);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.deleteApplicationCacheFiles(packageName, observer);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.563 -0400", hash_original_method = "E7A7F0006F405C835ECAAE7B969343FA", hash_generated_method = "0DFC32E806D142AE27C062EF41564979")
    @Override
    public void freeStorageAndNotify(long idealStorageSize, IPackageDataObserver observer) {
        addTaint(observer.getTaint());
        addTaint(idealStorageSize);
        try 
        {
            mPM.freeStorageAndNotify(idealStorageSize, observer);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.freeStorageAndNotify(idealStorageSize, observer);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.565 -0400", hash_original_method = "8531AD2E443F843CDBBD03DDCC5F2882", hash_generated_method = "96740309BB7679BBF21F654441046A5F")
    @Override
    public void freeStorage(long freeStorageSize, IntentSender pi) {
        addTaint(pi.getTaint());
        addTaint(freeStorageSize);
        try 
        {
            mPM.freeStorage(freeStorageSize, pi);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.freeStorage(freeStorageSize, pi);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.566 -0400", hash_original_method = "00314015F36B785D35449EC7724DA4A0", hash_generated_method = "283CDB9FA37FC104E9108C08680C4FF1")
    @Override
    public void getPackageSizeInfo(String packageName,
                                   IPackageStatsObserver observer) {
        addTaint(observer.getTaint());
        addTaint(packageName.getTaint());
        try 
        {
            mPM.getPackageSizeInfo(packageName, observer);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.getPackageSizeInfo(packageName, observer);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.568 -0400", hash_original_method = "A9291C102B2FAAEF4C90A57E1B6DE098", hash_generated_method = "CEDBC66756B184FDFD6BD726CFE9C0B4")
    @Override
    public void addPackageToPreferred(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
            mPM.addPackageToPreferred(packageName);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.addPackageToPreferred(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.577 -0400", hash_original_method = "F1B5214867A85B15353BE55995A19BB6", hash_generated_method = "95F674AB1D65C5BD91757ED9E1C0D26D")
    @Override
    public void removePackageFromPreferred(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
            mPM.removePackageFromPreferred(packageName);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.removePackageFromPreferred(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.585 -0400", hash_original_method = "4A08CFB9ACE88EAEABD2D18F083F329D", hash_generated_method = "06B947CA5D69FFFBCF02637514BAA1EF")
    @Override
    public List<PackageInfo> getPreferredPackages(int flags) {
        addTaint(flags);
        try 
        {
List<PackageInfo> var02CECA28466431CD30D6FEB0418EEBD2_565030809 =             mPM.getPreferredPackages(flags);
            var02CECA28466431CD30D6FEB0418EEBD2_565030809.addTaint(taint);
            return var02CECA28466431CD30D6FEB0418EEBD2_565030809;
        } //End block
        catch (RemoteException e)
        {
        } //End block
List<PackageInfo> var85E52041F0F27DC16548B92A1451C09A_877577658 =         new ArrayList<PackageInfo>();
        var85E52041F0F27DC16548B92A1451C09A_877577658.addTaint(taint);
        return var85E52041F0F27DC16548B92A1451C09A_877577658;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPreferredPackages(flags);
        //} catch (RemoteException e) {
        //}
        //return new ArrayList<PackageInfo>();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.587 -0400", hash_original_method = "E5D2F7A75D600839A582F36FB9BA5425", hash_generated_method = "0CA7B05C47AD238DC8969FE5C9314B73")
    @Override
    public void addPreferredActivity(IntentFilter filter,
                                     int match, ComponentName[] set, ComponentName activity) {
        addTaint(activity.getTaint());
        addTaint(set[0].getTaint());
        addTaint(match);
        addTaint(filter.getTaint());
        try 
        {
            mPM.addPreferredActivity(filter, match, set, activity);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.addPreferredActivity(filter, match, set, activity);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.589 -0400", hash_original_method = "2885B1E40721D55CC13EAA30EB1BAE52", hash_generated_method = "9C7807BF4DEA56696EE16ECA89DE8227")
    @Override
    public void replacePreferredActivity(IntentFilter filter,
                                         int match, ComponentName[] set, ComponentName activity) {
        addTaint(activity.getTaint());
        addTaint(set[0].getTaint());
        addTaint(match);
        addTaint(filter.getTaint());
        try 
        {
            mPM.replacePreferredActivity(filter, match, set, activity);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.replacePreferredActivity(filter, match, set, activity);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.590 -0400", hash_original_method = "818084167B76F544DAE31D40EA850683", hash_generated_method = "47FF1463C70C2B3A5407D561B0CEF8EB")
    @Override
    public void clearPackagePreferredActivities(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
            mPM.clearPackagePreferredActivities(packageName);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.clearPackagePreferredActivities(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.592 -0400", hash_original_method = "9A1408660FD10D92BECBE2BE18AA9510", hash_generated_method = "D484C635F29EE67928A70B7D71A2124C")
    @Override
    public int getPreferredActivities(List<IntentFilter> outFilters,
                                      List<ComponentName> outActivities, String packageName) {
        addTaint(packageName.getTaint());
        addTaint(outActivities.getTaint());
        addTaint(outFilters.getTaint());
        try 
        {
            int var9855CC69D059D6BFAA02AAB67EC603BD_886744311 = (mPM.getPreferredActivities(outFilters, outActivities, packageName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672311610 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672311610;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1081518112 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258488746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258488746;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPreferredActivities(outFilters, outActivities, packageName);
        //} catch (RemoteException e) {
        //}
        //return 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.593 -0400", hash_original_method = "324289EEBFA692363CEA9B4C548C82A7", hash_generated_method = "175E90ECB2108950DE129925BC549CBB")
    @Override
    public void setComponentEnabledSetting(ComponentName componentName,
                                           int newState, int flags) {
        addTaint(flags);
        addTaint(newState);
        addTaint(componentName.getTaint());
        try 
        {
            mPM.setComponentEnabledSetting(componentName, newState, flags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.setComponentEnabledSetting(componentName, newState, flags);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.594 -0400", hash_original_method = "214E6E4C94F679DC0FE6A4159B821EAF", hash_generated_method = "FA46A94813224DFA10B5125B8E1D4D9B")
    @Override
    public int getComponentEnabledSetting(ComponentName componentName) {
        addTaint(componentName.getTaint());
        try 
        {
            int var82F6DDED4142FD46021C481C139BB7B9_405027899 = (mPM.getComponentEnabledSetting(componentName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020255297 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020255297;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var5719CD54023665EBD976CE3F1BF7827E_80367971 = (PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901641460 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901641460;
        // ---------- Original Method ----------
        //try {
            //return mPM.getComponentEnabledSetting(componentName);
        //} catch (RemoteException e) {
        //}
        //return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.598 -0400", hash_original_method = "893989AE0F295A10184FE7AD874B7991", hash_generated_method = "9AFCF0E334670CF211CE58750D6849C7")
    @Override
    public void setApplicationEnabledSetting(String packageName,
                                             int newState, int flags) {
        addTaint(flags);
        addTaint(newState);
        addTaint(packageName.getTaint());
        try 
        {
            mPM.setApplicationEnabledSetting(packageName, newState, flags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.setApplicationEnabledSetting(packageName, newState, flags);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.602 -0400", hash_original_method = "786754E395F784476E8D899ABD01121D", hash_generated_method = "CD715033C670FF47A3B61A06BB81435C")
    @Override
    public int getApplicationEnabledSetting(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
            int varED96627AAEA0BB660315B43819049B7C_1398267178 = (mPM.getApplicationEnabledSetting(packageName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456174855 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456174855;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var5719CD54023665EBD976CE3F1BF7827E_1270542206 = (PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161563353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161563353;
        // ---------- Original Method ----------
        //try {
            //return mPM.getApplicationEnabledSetting(packageName);
        //} catch (RemoteException e) {
        //}
        //return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.604 -0400", hash_original_method = "26D19368C79A5889D2D25A72A45789A8", hash_generated_method = "C0BAD32DAE9E0D2D77D5EDFB2BD1A99B")
    @Override
    public UserInfo createUser(String name, int flags) {
        addTaint(flags);
        addTaint(name.getTaint());
        try 
        {
UserInfo var30388AEABCB67D89C63024B4918EB97E_1891790794 =             mPM.createUser(name, flags);
            var30388AEABCB67D89C63024B4918EB97E_1891790794.addTaint(taint);
            return var30388AEABCB67D89C63024B4918EB97E_1891790794;
        } //End block
        catch (RemoteException e)
        {
        } //End block
UserInfo var540C13E9E156B687226421B24F2DF178_987036524 =         null;
        var540C13E9E156B687226421B24F2DF178_987036524.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_987036524;
        // ---------- Original Method ----------
        //try {
            //return mPM.createUser(name, flags);
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.606 -0400", hash_original_method = "D3989192690585F23E6C25734E0C3BDB", hash_generated_method = "68F8E936705911413E485755A6B68D23")
    @Override
    public List<UserInfo> getUsers() {
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        UserInfo primary = new UserInfo(0, "Root!",
                UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        users.add(primary);
List<UserInfo> varB587D448BB2B2711D4473D79B7F2AAC8_1680764632 =         users;
        varB587D448BB2B2711D4473D79B7F2AAC8_1680764632.addTaint(taint);
        return varB587D448BB2B2711D4473D79B7F2AAC8_1680764632;
        // ---------- Original Method ----------
        //ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        //UserInfo primary = new UserInfo(0, "Root!",
                //UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        //users.add(primary);
        //return users;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.607 -0400", hash_original_method = "7D391C716B6EBFD3B4233647A1DCBC34", hash_generated_method = "C2FBC0673B350D2369BCF52EE7FBB0E2")
    @Override
    public boolean removeUser(int id) {
        addTaint(id);
        try 
        {
            boolean var722621000620FBE206A993656F472659_1524130433 = (mPM.removeUser(id));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763810088 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_763810088;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_680652466 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1876485916 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1876485916;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.removeUser(id);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.608 -0400", hash_original_method = "C52981B6B26B608864F1952FFD2E785F", hash_generated_method = "768E22F6EBCD52428AB6C0593A94E9CB")
    @Override
    public void updateUserName(int id, String name) {
        addTaint(name.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.610 -0400", hash_original_method = "B193A8F9463928060D13777D952477CD", hash_generated_method = "4CD5B965E87522729F955C64A5544391")
    @Override
    public void updateUserFlags(int id, int flags) {
        addTaint(flags);
        addTaint(id);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.611 -0400", hash_original_method = "05FAEEF75E7B74D35A0F0687A4ACD32C", hash_generated_method = "78BCD582C6864EA4A9E3D3DC61EA6D40")
    @Override
    public VerifierDeviceIdentity getVerifierDeviceIdentity() {
        try 
        {
VerifierDeviceIdentity varE0E6AA86EC4C031775B3978DD0D941F0_1951987387 =             mPM.getVerifierDeviceIdentity();
            varE0E6AA86EC4C031775B3978DD0D941F0_1951987387.addTaint(taint);
            return varE0E6AA86EC4C031775B3978DD0D941F0_1951987387;
        } //End block
        catch (RemoteException e)
        {
        } //End block
VerifierDeviceIdentity var540C13E9E156B687226421B24F2DF178_1072286820 =         null;
        var540C13E9E156B687226421B24F2DF178_1072286820.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1072286820;
        // ---------- Original Method ----------
        //try {
            //return mPM.getVerifierDeviceIdentity();
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    private static final class ResourceName {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.612 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "6F92EE1B3BCDC0C4179CF5FD998BE046")

        String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.612 -0400", hash_original_field = "D4DDD8F15E145D654808CFEB3504E8E3", hash_generated_field = "5FB1FE173593F2C1352A3849ECD329FE")

        int iconId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.613 -0400", hash_original_method = "00C0083FA3192C6FB2E9C58DC21ABF99", hash_generated_method = "1E60D2B25AB72FD493F4CCEBE8E14228")
          ResourceName(String _packageName, int _iconId) {
            packageName = _packageName;
            iconId = _iconId;
            // ---------- Original Method ----------
            //packageName = _packageName;
            //iconId = _iconId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.613 -0400", hash_original_method = "1D7CABC5D0E2E4029539D2105E7113C1", hash_generated_method = "B5B6C95FC4FFD613321C1FA5C1219219")
          ResourceName(ApplicationInfo aInfo, int _iconId) {
            this(aInfo.packageName, _iconId);
            addTaint(_iconId);
            addTaint(aInfo.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.614 -0400", hash_original_method = "316DD832F87E78ED23C1ED370845ED19", hash_generated_method = "67B24523D8C521DE202670C63AD12EE4")
          ResourceName(ComponentInfo cInfo, int _iconId) {
            this(cInfo.applicationInfo.packageName, _iconId);
            addTaint(_iconId);
            addTaint(cInfo.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.614 -0400", hash_original_method = "B7E8883725512A2439D57072801DA2BC", hash_generated_method = "06291B753B76B4CEA06ADE21A9CF1417")
          ResourceName(ResolveInfo rInfo, int _iconId) {
            this(rInfo.activityInfo.applicationInfo.packageName, _iconId);
            addTaint(_iconId);
            addTaint(rInfo.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.616 -0400", hash_original_method = "77EA94B0E7A0581CD73B79023B92E268", hash_generated_method = "57480B76A580C97984D9F83612E4101C")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
            if(this == o)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_397763694 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_501068266 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_501068266;
            }
            if(o == null || getClass() != o.getClass())            
            {
            boolean var68934A3E9455FA72420237EB05902327_55758933 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1503117137 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1503117137;
            }
            ResourceName that = (ResourceName) o;
            if(iconId != that.iconId)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1226079244 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119488027 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119488027;
            }
            boolean varE27CADC8CB9A21C0E4B9A6064C0A95DE_358485529 = (!(packageName != null ?
                     !packageName.equals(that.packageName) : that.packageName != null));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_621491972 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_621491972;
            // ---------- Original Method ----------
            //if (this == o) return true;
            //if (o == null || getClass() != o.getClass()) return false;
            //ResourceName that = (ResourceName) o;
            //if (iconId != that.iconId) return false;
            //return !(packageName != null ?
                     //!packageName.equals(that.packageName) : that.packageName != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.618 -0400", hash_original_method = "FE96AD3461E654FCE4E8B88F254AC3EE", hash_generated_method = "1186C0F323677F0C9540A7BCFFCB1279")
        @Override
        public int hashCode() {
            int result;
            result = packageName.hashCode();
            result = 31 * result + iconId;
            int varB4A88417B3D0170D754C647C30B7216A_1082896784 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191723763 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191723763;
            // ---------- Original Method ----------
            //int result;
            //result = packageName.hashCode();
            //result = 31 * result + iconId;
            //return result;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.619 -0400", hash_original_method = "19C1C9668D8A7EEF540F3D9429936D14", hash_generated_method = "F3738F3F550808E7078B038C7FD8A414")
        @Override
        public String toString() {
String var2B4501D95CD6758F165DA6F1F56CC01F_248800462 =             "{ResourceName " + packageName + " / " + iconId + "}";
            var2B4501D95CD6758F165DA6F1F56CC01F_248800462.addTaint(taint);
            return var2B4501D95CD6758F165DA6F1F56CC01F_248800462;
            // ---------- Original Method ----------
            //return "{ResourceName " + packageName + " / " + iconId + "}";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.619 -0400", hash_original_field = "6567C925641831CFA00E9DD4884FA1D6", hash_generated_field = "9103478CE6502665DE73DD4F276104D2")

    private static final String TAG = "ApplicationPackageManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.620 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.620 -0400", hash_original_field = "C3489935DD7AFC611D460C12208E5765", hash_generated_field = "D9A207E7F6832116E237531F8566E278")

    private final static boolean DEBUG_ICONS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.620 -0400", hash_original_field = "2F49D49D71E16DE6B9E03ABB51788CD5", hash_generated_field = "589A8BDF0C7416090F474EA4E832C9BC")

    private static final Object sSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.620 -0400", hash_original_field = "86949C5674DAE04FF598125EDFB9A09B", hash_generated_field = "4B02A68E27DCF1DC814B05F533A46F39")

    private static HashMap<ResourceName, WeakReference<Drawable.ConstantState>> sIconCache = new HashMap<ResourceName, WeakReference<Drawable.ConstantState>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.620 -0400", hash_original_field = "C59A7EE72451F56F2C82359DD275010F", hash_generated_field = "F43C1D13F1C693E3CC3452E528CF10D8")

    private static HashMap<ResourceName, WeakReference<CharSequence>> sStringCache = new HashMap<ResourceName, WeakReference<CharSequence>>();
}

