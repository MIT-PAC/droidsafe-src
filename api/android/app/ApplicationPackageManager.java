package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.content.pm.ManifestDigest;
import android.content.pm.VerifierDeviceIdentity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class ApplicationPackageManager extends PackageManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.464 -0400", hash_original_field = "D582EAEF778B662187C3776F3BC85DE5", hash_generated_field = "BB74ADCE9FCE390733990F175981A8B2")

    int mCachedSafeMode = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.465 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "9848C26EA3B1FE04FDB0411428C18F0B")

    private ContextImpl mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.465 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "7F4B9DC825AA12542DFD4F441E873557")

    private IPackageManager mPM;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.466 -0400", hash_original_method = "12FC21630330363415BEFB2BB747FDD4", hash_generated_method = "821E283AA9F20FD120BA751A1DBB238D")
      ApplicationPackageManager(ContextImpl context,
                              IPackageManager pm) {
        mContext = context;
        mPM = pm;
        // ---------- Original Method ----------
        //mContext = context;
        //mPM = pm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.468 -0400", hash_original_method = "B0DADC2DBFEC092F753C36E8DEB385A1", hash_generated_method = "5E62BD499A845F3C1D2432ED01FA3AD3")
    @Override
    public PackageInfo getPackageInfo(String packageName, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(packageName.getTaint());
        try 
        {
            PackageInfo pi = mPM.getPackageInfo(packageName, flags);
    if(pi != null)            
            {
PackageInfo var81D1A2E7B8C8FB24958425A15F743A98_1931378959 =                 pi;
                var81D1A2E7B8C8FB24958425A15F743A98_1931378959.addTaint(taint);
                return var81D1A2E7B8C8FB24958425A15F743A98_1931378959;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_828088072 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_828088072.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_828088072;
        } //End block
        NameNotFoundException var66F177309B3AAEEE242A13D4F2EC34A7_263820311 = new NameNotFoundException(packageName);
        var66F177309B3AAEEE242A13D4F2EC34A7_263820311.addTaint(taint);
        throw var66F177309B3AAEEE242A13D4F2EC34A7_263820311;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.470 -0400", hash_original_method = "C5CDEAB4FF073C2ACB7E7915B56F1D0F", hash_generated_method = "67CDC2F16BD6A36F5155400286991B85")
    @Override
    public String[] currentToCanonicalPackageNames(String[] names) {
        addTaint(names[0].getTaint());
        try 
        {
String[] var4408DCF3960F805BCBC82CB95360A56D_345392059 =             mPM.currentToCanonicalPackageNames(names);
            var4408DCF3960F805BCBC82CB95360A56D_345392059.addTaint(taint);
            return var4408DCF3960F805BCBC82CB95360A56D_345392059;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1494032888 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1494032888.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1494032888;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.currentToCanonicalPackageNames(names);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.471 -0400", hash_original_method = "9BD980F14E9EC05077595EA826722236", hash_generated_method = "EFC617A27C8F31CFE1454198818A5F55")
    @Override
    public String[] canonicalToCurrentPackageNames(String[] names) {
        addTaint(names[0].getTaint());
        try 
        {
String[] var7E7E7838A1BF04C6EBC5094AE21CEB27_662491329 =             mPM.canonicalToCurrentPackageNames(names);
            var7E7E7838A1BF04C6EBC5094AE21CEB27_662491329.addTaint(taint);
            return var7E7E7838A1BF04C6EBC5094AE21CEB27_662491329;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1257813933 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1257813933.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1257813933;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.canonicalToCurrentPackageNames(names);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.472 -0400", hash_original_method = "A679E3857CF73FF4B9C2EA4F09C7DBB7", hash_generated_method = "175E8C5788F2B45A5A2DA85B6D6DC5A1")
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
Intent var540C13E9E156B687226421B24F2DF178_557340218 =             null;
            var540C13E9E156B687226421B24F2DF178_557340218.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_557340218;
        } //End block
        Intent intent = new Intent(intentToResolve);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(ris.get(0).activityInfo.packageName,
                ris.get(0).activityInfo.name);
Intent var095937E5B36214360A2644916BF0E8DF_537370416 =         intent;
        var095937E5B36214360A2644916BF0E8DF_537370416.addTaint(taint);
        return var095937E5B36214360A2644916BF0E8DF_537370416;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.473 -0400", hash_original_method = "65CBA80193594BC7AC8CBF648823BDBA", hash_generated_method = "73E8B891BA91C80641DC9E36033E604D")
    @Override
    public int[] getPackageGids(String packageName) throws NameNotFoundException {
        addTaint(packageName.getTaint());
        try 
        {
            int[] gids = mPM.getPackageGids(packageName);
    if(gids == null || gids.length > 0)            
            {
                int[] var77DBC042260703938C8CA627F28C6CF5_487975044 = (gids);
                                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_111334216 = {getTaintInt()};
                return varB4CCCA26F9DB9189C32F33E82D425CFB_111334216;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1790360271 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1790360271.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1790360271;
        } //End block
        NameNotFoundException var66F177309B3AAEEE242A13D4F2EC34A7_1868221454 = new NameNotFoundException(packageName);
        var66F177309B3AAEEE242A13D4F2EC34A7_1868221454.addTaint(taint);
        throw var66F177309B3AAEEE242A13D4F2EC34A7_1868221454;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.474 -0400", hash_original_method = "16E2B9223A8B92626D3604D0E58E2278", hash_generated_method = "6075730DF7141AD6A5B9C9707E2D59DF")
    @Override
    public PermissionInfo getPermissionInfo(String name, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(name.getTaint());
        try 
        {
            PermissionInfo pi = mPM.getPermissionInfo(name, flags);
    if(pi != null)            
            {
PermissionInfo var81D1A2E7B8C8FB24958425A15F743A98_797634930 =                 pi;
                var81D1A2E7B8C8FB24958425A15F743A98_797634930.addTaint(taint);
                return var81D1A2E7B8C8FB24958425A15F743A98_797634930;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1803951295 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1803951295.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1803951295;
        } //End block
        NameNotFoundException varF14FFD89079BEC8EEF84D16341E4DEE7_711624631 = new NameNotFoundException(name);
        varF14FFD89079BEC8EEF84D16341E4DEE7_711624631.addTaint(taint);
        throw varF14FFD89079BEC8EEF84D16341E4DEE7_711624631;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.475 -0400", hash_original_method = "2283AA5BDEF3F8B3341260BB74FBE8C3", hash_generated_method = "D74156453BC56183F79D9CC4A6C15C17")
    @Override
    public List<PermissionInfo> queryPermissionsByGroup(String group, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(group.getTaint());
        try 
        {
            List<PermissionInfo> pi = mPM.queryPermissionsByGroup(group, flags);
    if(pi != null)            
            {
List<PermissionInfo> var81D1A2E7B8C8FB24958425A15F743A98_830352108 =                 pi;
                var81D1A2E7B8C8FB24958425A15F743A98_830352108.addTaint(taint);
                return var81D1A2E7B8C8FB24958425A15F743A98_830352108;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_896365434 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_896365434.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_896365434;
        } //End block
        NameNotFoundException varFC268ECE908C7CBE5529583AFF25E51B_1301686459 = new NameNotFoundException(group);
        varFC268ECE908C7CBE5529583AFF25E51B_1301686459.addTaint(taint);
        throw varFC268ECE908C7CBE5529583AFF25E51B_1301686459;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.476 -0400", hash_original_method = "4E576FD7FE2DDB9674E042581657631F", hash_generated_method = "07EAE48D4BBA44702C9BC0335E34E519")
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
PermissionGroupInfo var0069CE035D8ABD1A3D2A3A0632D80D0A_620127698 =                 pgi;
                var0069CE035D8ABD1A3D2A3A0632D80D0A_620127698.addTaint(taint);
                return var0069CE035D8ABD1A3D2A3A0632D80D0A_620127698;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_88695078 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_88695078.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_88695078;
        } //End block
        NameNotFoundException varF14FFD89079BEC8EEF84D16341E4DEE7_598367772 = new NameNotFoundException(name);
        varF14FFD89079BEC8EEF84D16341E4DEE7_598367772.addTaint(taint);
        throw varF14FFD89079BEC8EEF84D16341E4DEE7_598367772;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.477 -0400", hash_original_method = "DD7F1EBA9089D82A0EEA68FDD3DACC66", hash_generated_method = "2E6C38E8D27F31387BC9C67D3D10901D")
    @Override
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        addTaint(flags);
        try 
        {
List<PermissionGroupInfo> var91C1646E85DCB698A1FBCFC4FD1F5BA2_1700745431 =             mPM.getAllPermissionGroups(flags);
            var91C1646E85DCB698A1FBCFC4FD1F5BA2_1700745431.addTaint(taint);
            return var91C1646E85DCB698A1FBCFC4FD1F5BA2_1700745431;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_2036592120 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_2036592120.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_2036592120;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.getAllPermissionGroups(flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.478 -0400", hash_original_method = "8999420BFE5728B346477621EA154ABF", hash_generated_method = "CF40A3E988D0B4F02A528C5EBCF0C240")
    @Override
    public ApplicationInfo getApplicationInfo(String packageName, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(packageName.getTaint());
        try 
        {
            ApplicationInfo ai = mPM.getApplicationInfo(packageName, flags);
    if(ai != null)            
            {
ApplicationInfo varF0D6783F85B950884EE206D023A357C0_908217089 =                 ai;
                varF0D6783F85B950884EE206D023A357C0_908217089.addTaint(taint);
                return varF0D6783F85B950884EE206D023A357C0_908217089;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1592079965 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1592079965.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1592079965;
        } //End block
        NameNotFoundException var66F177309B3AAEEE242A13D4F2EC34A7_896391791 = new NameNotFoundException(packageName);
        var66F177309B3AAEEE242A13D4F2EC34A7_896391791.addTaint(taint);
        throw var66F177309B3AAEEE242A13D4F2EC34A7_896391791;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.480 -0400", hash_original_method = "9B4FC7EA40C0BB7AEEEEEF1D86D28DE8", hash_generated_method = "9E857E75207012D5CBD811957FEFEB06")
    @Override
    public ActivityInfo getActivityInfo(ComponentName className, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(className.getTaint());
        try 
        {
            ActivityInfo ai = mPM.getActivityInfo(className, flags);
    if(ai != null)            
            {
ActivityInfo varF0D6783F85B950884EE206D023A357C0_1985263562 =                 ai;
                varF0D6783F85B950884EE206D023A357C0_1985263562.addTaint(taint);
                return varF0D6783F85B950884EE206D023A357C0_1985263562;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_792909198 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_792909198.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_792909198;
        } //End block
        NameNotFoundException var66DF60946F5E01AC15F21C65B4F5F4F4_1536415948 = new NameNotFoundException(className.toString());
        var66DF60946F5E01AC15F21C65B4F5F4F4_1536415948.addTaint(taint);
        throw var66DF60946F5E01AC15F21C65B4F5F4F4_1536415948;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.482 -0400", hash_original_method = "399255B19735D8EC733B05B14D3B4711", hash_generated_method = "CB9A99559EAD8F6E25D57D6644F381E2")
    @Override
    public ActivityInfo getReceiverInfo(ComponentName className, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(className.getTaint());
        try 
        {
            ActivityInfo ai = mPM.getReceiverInfo(className, flags);
    if(ai != null)            
            {
ActivityInfo varF0D6783F85B950884EE206D023A357C0_354165559 =                 ai;
                varF0D6783F85B950884EE206D023A357C0_354165559.addTaint(taint);
                return varF0D6783F85B950884EE206D023A357C0_354165559;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1183152737 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1183152737.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1183152737;
        } //End block
        NameNotFoundException var66DF60946F5E01AC15F21C65B4F5F4F4_1072638161 = new NameNotFoundException(className.toString());
        var66DF60946F5E01AC15F21C65B4F5F4F4_1072638161.addTaint(taint);
        throw var66DF60946F5E01AC15F21C65B4F5F4F4_1072638161;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.483 -0400", hash_original_method = "50C1BC4F3995D229FF03E27E05E5BE36", hash_generated_method = "F5435ECFEEB22550E6DCCFEDD937F50E")
    @Override
    public ServiceInfo getServiceInfo(ComponentName className, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(className.getTaint());
        try 
        {
            ServiceInfo si = mPM.getServiceInfo(className, flags);
    if(si != null)            
            {
ServiceInfo var316474D4DA67FD8479E170FE8E19F283_2040483510 =                 si;
                var316474D4DA67FD8479E170FE8E19F283_2040483510.addTaint(taint);
                return var316474D4DA67FD8479E170FE8E19F283_2040483510;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_105354508 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_105354508.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_105354508;
        } //End block
        NameNotFoundException var66DF60946F5E01AC15F21C65B4F5F4F4_1869622855 = new NameNotFoundException(className.toString());
        var66DF60946F5E01AC15F21C65B4F5F4F4_1869622855.addTaint(taint);
        throw var66DF60946F5E01AC15F21C65B4F5F4F4_1869622855;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.484 -0400", hash_original_method = "895E4F29ECA72E6836B6F503A466760A", hash_generated_method = "B3C3ECE3D921362BC1D0461791CC5259")
    @Override
    public ProviderInfo getProviderInfo(ComponentName className, int flags) throws NameNotFoundException {
        addTaint(flags);
        addTaint(className.getTaint());
        try 
        {
            ProviderInfo pi = mPM.getProviderInfo(className, flags);
    if(pi != null)            
            {
ProviderInfo var81D1A2E7B8C8FB24958425A15F743A98_771986342 =                 pi;
                var81D1A2E7B8C8FB24958425A15F743A98_771986342.addTaint(taint);
                return var81D1A2E7B8C8FB24958425A15F743A98_771986342;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1871371364 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1871371364.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1871371364;
        } //End block
        NameNotFoundException var66DF60946F5E01AC15F21C65B4F5F4F4_1582642897 = new NameNotFoundException(className.toString());
        var66DF60946F5E01AC15F21C65B4F5F4F4_1582642897.addTaint(taint);
        throw var66DF60946F5E01AC15F21C65B4F5F4F4_1582642897;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.485 -0400", hash_original_method = "E90BE84736723B0914BD9D43484D5AAD", hash_generated_method = "F8AA3E76B51141AF3D313FC264FC3C23")
    @Override
    public String[] getSystemSharedLibraryNames() {
        try 
        {
String[] varB1CFFA988E3DBD9614F638D068F4C165_68668543 =             mPM.getSystemSharedLibraryNames();
            varB1CFFA988E3DBD9614F638D068F4C165_68668543.addTaint(taint);
            return varB1CFFA988E3DBD9614F638D068F4C165_68668543;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_241228956 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_241228956.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_241228956;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.getSystemSharedLibraryNames();
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.486 -0400", hash_original_method = "887B55B734ED0895C5FA7D7CF721CE58", hash_generated_method = "C7929D8869366576D51FB580C50E79C8")
    @Override
    public FeatureInfo[] getSystemAvailableFeatures() {
        try 
        {
FeatureInfo[] varB0F22BA1AFC32A4106709CF6A7CA068D_692482226 =             mPM.getSystemAvailableFeatures();
            varB0F22BA1AFC32A4106709CF6A7CA068D_692482226.addTaint(taint);
            return varB0F22BA1AFC32A4106709CF6A7CA068D_692482226;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_195371368 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_195371368.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_195371368;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.getSystemAvailableFeatures();
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.487 -0400", hash_original_method = "8E2B8D0B6C29BED8B3E866F74247B636", hash_generated_method = "BEC61D355A56CC58233461F4DD98328D")
    @Override
    public boolean hasSystemFeature(String name) {
        addTaint(name.getTaint());
        try 
        {
            boolean var37ADF61D22F136777D5E2BF32F95BB22_62197703 = (mPM.hasSystemFeature(name));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1876931615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1876931615;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_458761396 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_458761396.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_458761396;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.hasSystemFeature(name);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.489 -0400", hash_original_method = "D191D3716589DABF1290937DD7F4276D", hash_generated_method = "A2D5627CFB67F89BA3DE00FB0D371DB8")
    @Override
    public int checkPermission(String permName, String pkgName) {
        addTaint(pkgName.getTaint());
        addTaint(permName.getTaint());
        try 
        {
            int varDF0DA18627386C79194F175EB75BB229_1977010427 = (mPM.checkPermission(permName, pkgName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737763785 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737763785;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1988969486 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1988969486.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1988969486;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.checkPermission(permName, pkgName);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.490 -0400", hash_original_method = "7DE747A31A0FDE2C95A03117CF8EC1E2", hash_generated_method = "9802A9A9EC61566DC0210A32DE684893")
    @Override
    public boolean addPermission(PermissionInfo info) {
        addTaint(info.getTaint());
        try 
        {
            boolean var4D1C33C7B58570D1EC7C0220D2C194EB_636757550 = (mPM.addPermission(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1126041681 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1126041681;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_2145059016 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_2145059016.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_2145059016;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.addPermission(info);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.494 -0400", hash_original_method = "BE955F868C92CCDF8275E95FFE2C44B3", hash_generated_method = "659C8A24DA6C3EAB78E23739B073828F")
    @Override
    public boolean addPermissionAsync(PermissionInfo info) {
        addTaint(info.getTaint());
        try 
        {
            boolean var8881271C5790813BCB37EA64363A8107_1226497474 = (mPM.addPermissionAsync(info));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1422318536 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1422318536;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_817520980 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_817520980.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_817520980;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.addPermissionAsync(info);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.497 -0400", hash_original_method = "3B9F25E30931EF93125264B719A2E2FF", hash_generated_method = "3459C7ED2236B75D213363495C00A0EC")
    @Override
    public void removePermission(String name) {
        addTaint(name.getTaint());
        try 
        {
            mPM.removePermission(name);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1159957539 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1159957539.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1159957539;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.removePermission(name);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.499 -0400", hash_original_method = "7DC6A4F902E735FA721489587F3384CC", hash_generated_method = "FBCD82A8B399A6A950972C806B35598F")
    @Override
    public int checkSignatures(String pkg1, String pkg2) {
        addTaint(pkg2.getTaint());
        addTaint(pkg1.getTaint());
        try 
        {
            int var240C22D7ECE302ED357F18D25BCE9FC8_2062707236 = (mPM.checkSignatures(pkg1, pkg2));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607320115 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607320115;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_2134641300 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_2134641300.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_2134641300;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.checkSignatures(pkg1, pkg2);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.500 -0400", hash_original_method = "E51AFA66F0FA11E52A6A449B49344AE4", hash_generated_method = "3A8E6DCA92AAF69C89F42CCB46717242")
    @Override
    public int checkSignatures(int uid1, int uid2) {
        addTaint(uid2);
        addTaint(uid1);
        try 
        {
            int var29BBF1E11C597F71DD50DDF6CFC1E31E_1407981519 = (mPM.checkUidSignatures(uid1, uid2));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860215760 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860215760;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1175943273 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1175943273.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1175943273;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.checkUidSignatures(uid1, uid2);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.501 -0400", hash_original_method = "A565AD9EB181443BBE8F338808A2E4B9", hash_generated_method = "5D276278FD67D5A4EFC7FDC8DFF50BB7")
    @Override
    public String[] getPackagesForUid(int uid) {
        addTaint(uid);
        try 
        {
String[] varD991A7FF694DD380F485AA5D6A4F3DB8_926799975 =             mPM.getPackagesForUid(uid);
            varD991A7FF694DD380F485AA5D6A4F3DB8_926799975.addTaint(taint);
            return varD991A7FF694DD380F485AA5D6A4F3DB8_926799975;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1614406062 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1614406062.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1614406062;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.getPackagesForUid(uid);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.504 -0400", hash_original_method = "107797D329CAA491AA1A678294A11B0E", hash_generated_method = "BDE3F49E9EBB920D1BCDCC1960EDCF43")
    @Override
    public String getNameForUid(int uid) {
        addTaint(uid);
        try 
        {
String var6CF9536D701B4110CD0A13C848A0721A_1156724852 =             mPM.getNameForUid(uid);
            var6CF9536D701B4110CD0A13C848A0721A_1156724852.addTaint(taint);
            return var6CF9536D701B4110CD0A13C848A0721A_1156724852;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_970687700 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_970687700.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_970687700;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.getNameForUid(uid);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.506 -0400", hash_original_method = "BCD62F04CBDED38DF225700C99BB4852", hash_generated_method = "C19A4B18E0E047153B51BA64C2B3AB8D")
    @Override
    public int getUidForSharedUser(String sharedUserName) throws NameNotFoundException {
        addTaint(sharedUserName.getTaint());
        try 
        {
            int uid = mPM.getUidForSharedUser(sharedUserName);
    if(uid != -1)            
            {
                int var9871D3A2C554B27151CACF1422EEC048_1889846354 = (uid);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861056960 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861056960;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1573608890 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1573608890.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1573608890;
        } //End block
        NameNotFoundException var370BCF6F4CD709E6AA3B0E291A19BA32_1156711572 = new NameNotFoundException("No shared userid for user:"+sharedUserName);
        var370BCF6F4CD709E6AA3B0E291A19BA32_1156711572.addTaint(taint);
        throw var370BCF6F4CD709E6AA3B0E291A19BA32_1156711572;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.508 -0400", hash_original_method = "2CD6168D318C89447F6184EBDE96189F", hash_generated_method = "C50158BDF51EAFBE9A5983353522ECDD")
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
List<PackageInfo> var37101830B2D3C6C85473948F9AF68DFB_1259713759 =             packageInfos;
            var37101830B2D3C6C85473948F9AF68DFB_1259713759.addTaint(taint);
            return var37101830B2D3C6C85473948F9AF68DFB_1259713759;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_38815402 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_38815402.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_38815402;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.510 -0400", hash_original_method = "195CA5538214D0B5EDE14A1F47A96E96", hash_generated_method = "8BE6113F22612DB7E11EEC888E86932D")
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
List<ApplicationInfo> var476DDE830C1E7D654398FCDB6BE91BEE_105482440 =             applicationInfos;
            var476DDE830C1E7D654398FCDB6BE91BEE_105482440.addTaint(taint);
            return var476DDE830C1E7D654398FCDB6BE91BEE_105482440;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1371806882 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1371806882.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1371806882;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.511 -0400", hash_original_method = "0CD7CD39AE65A355BC33F2BA54C4DC37", hash_generated_method = "F4274A646A8A98F29BFAC8FC3584B4D2")
    @Override
    public ResolveInfo resolveActivity(Intent intent, int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        try 
        {
ResolveInfo var53CD1929C11A1EFD4D6D1E47C7C7A408_726382075 =             mPM.resolveIntent(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
            var53CD1929C11A1EFD4D6D1E47C7C7A408_726382075.addTaint(taint);
            return var53CD1929C11A1EFD4D6D1E47C7C7A408_726382075;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_608488195 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_608488195.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_608488195;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.513 -0400", hash_original_method = "613ED89A001624360A0EB6B3BD081707", hash_generated_method = "86B40F2CBD512BAB82D72B3D349A34C3")
    @Override
    public List<ResolveInfo> queryIntentActivities(Intent intent,
                                                   int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        try 
        {
List<ResolveInfo> var959EC25C5EAA6CFAF2C68E5802ED225B_1998220899 =             mPM.queryIntentActivities(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
            var959EC25C5EAA6CFAF2C68E5802ED225B_1998220899.addTaint(taint);
            return var959EC25C5EAA6CFAF2C68E5802ED225B_1998220899;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1617110175 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1617110175.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1617110175;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.514 -0400", hash_original_method = "9B955FD88A95F7C1CCD0CD1DFE6EC270", hash_generated_method = "BFCD3AE0D4FA6AB1F9F62A38E32B7899")
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
List<ResolveInfo> var98A7E75C8E2130DCDDB36B3CBCB21C1D_1492114016 =             mPM.queryIntentActivityOptions(caller, specifics,
                                                  specificTypes, intent, intent.resolveTypeIfNeeded(resolver),
                                                  flags);
            var98A7E75C8E2130DCDDB36B3CBCB21C1D_1492114016.addTaint(taint);
            return var98A7E75C8E2130DCDDB36B3CBCB21C1D_1492114016;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_348896618 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_348896618.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_348896618;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.519 -0400", hash_original_method = "2B65A8BDA3BE53DC3296D1F5CA76CDFC", hash_generated_method = "6ABA1D55E471F1437CA85036FE0228A1")
    @Override
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        try 
        {
List<ResolveInfo> var8B6E5F8859DD8885402EF5F1767EE1FF_284700824 =             mPM.queryIntentReceivers(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
            var8B6E5F8859DD8885402EF5F1767EE1FF_284700824.addTaint(taint);
            return var8B6E5F8859DD8885402EF5F1767EE1FF_284700824;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1025237045 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1025237045.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1025237045;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.522 -0400", hash_original_method = "D7D4C733DB611C9D18D346868F9BD0BD", hash_generated_method = "C65DEB5B24439D36D3EEB2647CEF05D9")
    @Override
    public ResolveInfo resolveService(Intent intent, int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        try 
        {
ResolveInfo var8DF144ADA7D834C2B6445C66A11819F1_1907245111 =             mPM.resolveService(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
            var8DF144ADA7D834C2B6445C66A11819F1_1907245111.addTaint(taint);
            return var8DF144ADA7D834C2B6445C66A11819F1_1907245111;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1215136547 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1215136547.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1215136547;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.525 -0400", hash_original_method = "EEB4EB852740846BAD76CCDE5FC0C613", hash_generated_method = "BFE3CF3D4203AB3D86267A7DEBC429ED")
    @Override
    public List<ResolveInfo> queryIntentServices(Intent intent, int flags) {
        addTaint(flags);
        addTaint(intent.getTaint());
        try 
        {
List<ResolveInfo> varAA78B32437C8D73EC53A2D8EEABDF0C8_62359032 =             mPM.queryIntentServices(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
            varAA78B32437C8D73EC53A2D8EEABDF0C8_62359032.addTaint(taint);
            return varAA78B32437C8D73EC53A2D8EEABDF0C8_62359032;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1841577965 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1841577965.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1841577965;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.527 -0400", hash_original_method = "3A6513CB26C2E0AF7DACFC2B8A5D560B", hash_generated_method = "41AA8FF0F8AA2200BEAE0D8DA71DD611")
    @Override
    public ProviderInfo resolveContentProvider(String name,
                                               int flags) {
        addTaint(flags);
        addTaint(name.getTaint());
        try 
        {
ProviderInfo var9E926164775746E1973A744D08359501_185272934 =             mPM.resolveContentProvider(name, flags);
            var9E926164775746E1973A744D08359501_185272934.addTaint(taint);
            return var9E926164775746E1973A744D08359501_185272934;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_368359187 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_368359187.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_368359187;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.resolveContentProvider(name, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.528 -0400", hash_original_method = "7B04A4BE8EFECF5209DBE4F77CB67C42", hash_generated_method = "792C32449900F924825A043B36F5110D")
    @Override
    public List<ProviderInfo> queryContentProviders(String processName,
                                                    int uid, int flags) {
        addTaint(flags);
        addTaint(uid);
        addTaint(processName.getTaint());
        try 
        {
List<ProviderInfo> var649783037687051D01975EFAA3A897C3_1648267626 =             mPM.queryContentProviders(processName, uid, flags);
            var649783037687051D01975EFAA3A897C3_1648267626.addTaint(taint);
            return var649783037687051D01975EFAA3A897C3_1648267626;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1008786795 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1008786795.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1008786795;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.queryContentProviders(processName, uid, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.529 -0400", hash_original_method = "3120887453BFC9391A593077A4EB2D8C", hash_generated_method = "C919073F7EB1BBC28BA4AB0E3D6E7EFC")
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
InstrumentationInfo var271C06C7ED7711E7D563AD4C67B1449E_116175564 =                 ii;
                var271C06C7ED7711E7D563AD4C67B1449E_116175564.addTaint(taint);
                return var271C06C7ED7711E7D563AD4C67B1449E_116175564;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1524248328 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1524248328.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1524248328;
        } //End block
        NameNotFoundException var66DF60946F5E01AC15F21C65B4F5F4F4_776811291 = new NameNotFoundException(className.toString());
        var66DF60946F5E01AC15F21C65B4F5F4F4_776811291.addTaint(taint);
        throw var66DF60946F5E01AC15F21C65B4F5F4F4_776811291;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.530 -0400", hash_original_method = "0CE547FAA1F9EB003838A9DE59E3AC72", hash_generated_method = "06D4EA81CCF149411C559F150A6809A5")
    @Override
    public List<InstrumentationInfo> queryInstrumentation(
        String targetPackage, int flags) {
        addTaint(flags);
        addTaint(targetPackage.getTaint());
        try 
        {
List<InstrumentationInfo> varDACF4DF210DF604F3051E5EF852D2D12_885964872 =             mPM.queryInstrumentation(targetPackage, flags);
            varDACF4DF210DF604F3051E5EF852D2D12_885964872.addTaint(taint);
            return varDACF4DF210DF604F3051E5EF852D2D12_885964872;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_1490742880 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_1490742880.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_1490742880;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.queryInstrumentation(targetPackage, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.536 -0400", hash_original_method = "350CC4BDDD2E42419F88F44C033409F6", hash_generated_method = "8A8EC72F45CF73E3B0BDA55575B02B95")
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
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_837455667 =             dr;
            varDA2FE1A9D9D8285A7F4D54668C2E4AE3_837455667.addTaint(taint);
            return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_837455667;
        } //End block
    if(appInfo == null)        
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
Drawable var540C13E9E156B687226421B24F2DF178_1768487441 =                 null;
                var540C13E9E156B687226421B24F2DF178_1768487441.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1768487441;
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
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1148731257 =             dr;
            varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1148731257.addTaint(taint);
            return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1148731257;
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
Drawable var540C13E9E156B687226421B24F2DF178_2116883715 =         null;
        var540C13E9E156B687226421B24F2DF178_2116883715.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2116883715;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.538 -0400", hash_original_method = "E8823DE045849946097DF943F50B58DB", hash_generated_method = "4BA239BFFDB492EFCD01F0DF10C1857D")
    @Override
    public Drawable getActivityIcon(ComponentName activityName) throws NameNotFoundException {
        addTaint(activityName.getTaint());
Drawable var0D423A11B11A8CD7FA1178796A4F2B7F_715556877 =         getActivityInfo(activityName, 0).loadIcon(this);
        var0D423A11B11A8CD7FA1178796A4F2B7F_715556877.addTaint(taint);
        return var0D423A11B11A8CD7FA1178796A4F2B7F_715556877;
        // ---------- Original Method ----------
        //return getActivityInfo(activityName, 0).loadIcon(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.539 -0400", hash_original_method = "EF5F409F30F5D50F1964B6AB6B7F75B7", hash_generated_method = "BBDB7990CDE5AC800373BC61EEA38587")
    @Override
    public Drawable getActivityIcon(Intent intent) throws NameNotFoundException {
        addTaint(intent.getTaint());
    if(intent.getComponent() != null)        
        {
Drawable var748F36A39B1B34880A2295BB00CF09EE_1462640224 =             getActivityIcon(intent.getComponent());
            var748F36A39B1B34880A2295BB00CF09EE_1462640224.addTaint(taint);
            return var748F36A39B1B34880A2295BB00CF09EE_1462640224;
        } //End block
        ResolveInfo info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
    if(info != null)        
        {
Drawable var990B62C26486EA3F0D8131DEA96B2165_1258807304 =             info.activityInfo.loadIcon(this);
            var990B62C26486EA3F0D8131DEA96B2165_1258807304.addTaint(taint);
            return var990B62C26486EA3F0D8131DEA96B2165_1258807304;
        } //End block
        NameNotFoundException varE2BCF5174B94F5AAA49C789D58CFD1E0_1447075604 = new NameNotFoundException(intent.toUri(0));
        varE2BCF5174B94F5AAA49C789D58CFD1E0_1447075604.addTaint(taint);
        throw varE2BCF5174B94F5AAA49C789D58CFD1E0_1447075604;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.541 -0400", hash_original_method = "27F8B828FEA8943560AD77E4760B6964", hash_generated_method = "A02761560DFBCCEC18B7681C836851C5")
    @Override
    public Drawable getDefaultActivityIcon() {
Drawable var859ABD8972B57052B4D0C8A531A2DC09_8901988 =         Resources.getSystem().getDrawable(
            com.android.internal.R.drawable.sym_def_app_icon);
        var859ABD8972B57052B4D0C8A531A2DC09_8901988.addTaint(taint);
        return var859ABD8972B57052B4D0C8A531A2DC09_8901988;
        // ---------- Original Method ----------
        //return Resources.getSystem().getDrawable(
            //com.android.internal.R.drawable.sym_def_app_icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.544 -0400", hash_original_method = "C2186A062EDEC18E9DD8F87E8E6291D1", hash_generated_method = "E3E7C0A6C78AE8E82E7D3D6294FB2E2E")
    @Override
    public Drawable getApplicationIcon(ApplicationInfo info) {
        addTaint(info.getTaint());
Drawable varBD36481CAA11421D1D3A0F1FC1E02B60_415066773 =         info.loadIcon(this);
        varBD36481CAA11421D1D3A0F1FC1E02B60_415066773.addTaint(taint);
        return varBD36481CAA11421D1D3A0F1FC1E02B60_415066773;
        // ---------- Original Method ----------
        //return info.loadIcon(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.547 -0400", hash_original_method = "49256B647BD52234F52BC973E3B03E0B", hash_generated_method = "0CA3822293D2C079A0A1653EBC164FDF")
    @Override
    public Drawable getApplicationIcon(String packageName) throws NameNotFoundException {
        addTaint(packageName.getTaint());
Drawable var574026DF4A89469F5BF04AF6F860243F_1465985448 =         getApplicationIcon(getApplicationInfo(packageName, 0));
        var574026DF4A89469F5BF04AF6F860243F_1465985448.addTaint(taint);
        return var574026DF4A89469F5BF04AF6F860243F_1465985448;
        // ---------- Original Method ----------
        //return getApplicationIcon(getApplicationInfo(packageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.548 -0400", hash_original_method = "12128D2FB1F753A28280A7EF3E62F4B2", hash_generated_method = "01CAEBCC99024F137781286634B8EEDC")
    @Override
    public Drawable getActivityLogo(ComponentName activityName) throws NameNotFoundException {
        addTaint(activityName.getTaint());
Drawable varE23F661D14D7DE981F8F4A7E8A778432_1316197640 =         getActivityInfo(activityName, 0).loadLogo(this);
        varE23F661D14D7DE981F8F4A7E8A778432_1316197640.addTaint(taint);
        return varE23F661D14D7DE981F8F4A7E8A778432_1316197640;
        // ---------- Original Method ----------
        //return getActivityInfo(activityName, 0).loadLogo(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.550 -0400", hash_original_method = "3B1A86BB5E25FB8EFA7A1AD1A88B3B01", hash_generated_method = "2A80931DE83924C23539D79F6A9E0458")
    @Override
    public Drawable getActivityLogo(Intent intent) throws NameNotFoundException {
        addTaint(intent.getTaint());
    if(intent.getComponent() != null)        
        {
Drawable var3562002FE3C5071329B46257497F8BD9_1126836147 =             getActivityLogo(intent.getComponent());
            var3562002FE3C5071329B46257497F8BD9_1126836147.addTaint(taint);
            return var3562002FE3C5071329B46257497F8BD9_1126836147;
        } //End block
        ResolveInfo info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
    if(info != null)        
        {
Drawable varED1E9405C1D23EFCD3BA2615D991D076_1156521182 =             info.activityInfo.loadLogo(this);
            varED1E9405C1D23EFCD3BA2615D991D076_1156521182.addTaint(taint);
            return varED1E9405C1D23EFCD3BA2615D991D076_1156521182;
        } //End block
        NameNotFoundException varE2BCF5174B94F5AAA49C789D58CFD1E0_1978602101 = new NameNotFoundException(intent.toUri(0));
        varE2BCF5174B94F5AAA49C789D58CFD1E0_1978602101.addTaint(taint);
        throw varE2BCF5174B94F5AAA49C789D58CFD1E0_1978602101;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.552 -0400", hash_original_method = "586E62978169D56092172114763F9AD3", hash_generated_method = "5A87B3CEE7C90AE324B87D4EF8FC0D53")
    @Override
    public Drawable getApplicationLogo(ApplicationInfo info) {
        addTaint(info.getTaint());
Drawable varDE726747D49680B2FA0EDF14A2BA0B2A_447205991 =         info.loadLogo(this);
        varDE726747D49680B2FA0EDF14A2BA0B2A_447205991.addTaint(taint);
        return varDE726747D49680B2FA0EDF14A2BA0B2A_447205991;
        // ---------- Original Method ----------
        //return info.loadLogo(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.553 -0400", hash_original_method = "6BC85FEDD3936A7851329E2331D0279D", hash_generated_method = "ADDB93B89897D2F416C22635FF11EABA")
    @Override
    public Drawable getApplicationLogo(String packageName) throws NameNotFoundException {
        addTaint(packageName.getTaint());
Drawable varEA72FA4FF4DA7EB2107FAD8967663ED9_369351687 =         getApplicationLogo(getApplicationInfo(packageName, 0));
        varEA72FA4FF4DA7EB2107FAD8967663ED9_369351687.addTaint(taint);
        return varEA72FA4FF4DA7EB2107FAD8967663ED9_369351687;
        // ---------- Original Method ----------
        //return getApplicationLogo(getApplicationInfo(packageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.555 -0400", hash_original_method = "E07E3E36CD8F79CF4FE12B9F33A40344", hash_generated_method = "E9E70D59450A086FF99EC6D07D7BB957")
    @Override
    public Resources getResourcesForActivity(
        ComponentName activityName) throws NameNotFoundException {
        addTaint(activityName.getTaint());
Resources var404E6134F0F48C247F1FD97ECE55C8D7_352632488 =         getResourcesForApplication(
            getActivityInfo(activityName, 0).applicationInfo);
        var404E6134F0F48C247F1FD97ECE55C8D7_352632488.addTaint(taint);
        return var404E6134F0F48C247F1FD97ECE55C8D7_352632488;
        // ---------- Original Method ----------
        //return getResourcesForApplication(
            //getActivityInfo(activityName, 0).applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.556 -0400", hash_original_method = "AC20F77416CABFA638F647DA9F2F230E", hash_generated_method = "9469339A9DBE3BC72F3616590047C16B")
    @Override
    public Resources getResourcesForApplication(
        ApplicationInfo app) throws NameNotFoundException {
        addTaint(app.getTaint());
    if(app.packageName.equals("system"))        
        {
Resources var4F898A4732E2653A7AC6783BA2F7F31E_1628893308 =             mContext.mMainThread.getSystemContext().getResources();
            var4F898A4732E2653A7AC6783BA2F7F31E_1628893308.addTaint(taint);
            return var4F898A4732E2653A7AC6783BA2F7F31E_1628893308;
        } //End block
        Resources r = mContext.mMainThread.getTopLevelResources(
            app.uid == Process.myUid() ? app.sourceDir
            : app.publicSourceDir, mContext.mPackageInfo);
    if(r != null)        
        {
Resources var4C1F3C86A0E56B6E375080F5F710547E_550440603 =             r;
            var4C1F3C86A0E56B6E375080F5F710547E_550440603.addTaint(taint);
            return var4C1F3C86A0E56B6E375080F5F710547E_550440603;
        } //End block
        NameNotFoundException varB62EA499239502213DE0ED312AC15705_2033057916 = new NameNotFoundException("Unable to open " + app.publicSourceDir);
        varB62EA499239502213DE0ED312AC15705_2033057916.addTaint(taint);
        throw varB62EA499239502213DE0ED312AC15705_2033057916;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.558 -0400", hash_original_method = "ACD444E0FC7FCEAEB5D1FF09DD4A5912", hash_generated_method = "F53A548BAF42FB08B40C70DD036E30D5")
    @Override
    public Resources getResourcesForApplication(
        String appPackageName) throws NameNotFoundException {
        addTaint(appPackageName.getTaint());
Resources var4ECAD796BEBC2036726E2B4D3C6D94FC_1670424932 =         getResourcesForApplication(
            getApplicationInfo(appPackageName, 0));
        var4ECAD796BEBC2036726E2B4D3C6D94FC_1670424932.addTaint(taint);
        return var4ECAD796BEBC2036726E2B4D3C6D94FC_1670424932;
        // ---------- Original Method ----------
        //return getResourcesForApplication(
            //getApplicationInfo(appPackageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.559 -0400", hash_original_method = "6B2AA9A609FE89D703EEC81AF1FC0890", hash_generated_method = "F2711DC06FBB017F89BAA07EBFA92CC1")
    @Override
    public boolean isSafeMode() {
        try 
        {
    if(mCachedSafeMode < 0)            
            {
                mCachedSafeMode = mPM.isSafeMode() ? 1 : 0;
            } //End block
            boolean varDFE9EA0892C8F91B8CB2C26127C7633F_1384105387 = (mCachedSafeMode != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660609240 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660609240;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var79079410F479E45F5EDE00A04B1BB448_967591999 = new RuntimeException("Package manager has died", e);
            var79079410F479E45F5EDE00A04B1BB448_967591999.addTaint(taint);
            throw var79079410F479E45F5EDE00A04B1BB448_967591999;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.562 -0400", hash_original_method = "805BC435FDAE098AFC4F53B40E89D7C1", hash_generated_method = "1645948CFCE7074B6A2875A16B6EC861")
    private Drawable getCachedIcon(ResourceName name) {
        addTaint(name.getTaint());
        synchronized
(sSync)        {
            WeakReference<Drawable.ConstantState> wr = sIconCache.get(name);
    if(DEBUG_ICONS){ }    if(wr != null)            
            {
                Drawable.ConstantState state = wr.get();
    if(state != null)                
                {
    if(DEBUG_ICONS)                    
                    {
                    } //End block
Drawable var0CE7D3E7B0B3584DE52FC6510C98BEA7_1564384141 =                     state.newDrawable();
                    var0CE7D3E7B0B3584DE52FC6510C98BEA7_1564384141.addTaint(taint);
                    return var0CE7D3E7B0B3584DE52FC6510C98BEA7_1564384141;
                } //End block
                sIconCache.remove(name);
            } //End block
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_716524834 =         null;
        var540C13E9E156B687226421B24F2DF178_716524834.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_716524834;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.564 -0400", hash_original_method = "1ADDA1851B7207BD0D6C119E2C63D6A2", hash_generated_method = "AC3861F30662FDCC0F506F5C2283D5F8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.569 -0400", hash_original_method = "B66098C8E55783775B73FA7D73879D41", hash_generated_method = "94134107A668F6EA901AFFE0A5C3180E")
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
CharSequence varE661418CFE0D2CECDB5DF6FE0739403D_755004644 =                     cs;
                    varE661418CFE0D2CECDB5DF6FE0739403D_755004644.addTaint(taint);
                    return varE661418CFE0D2CECDB5DF6FE0739403D_755004644;
                } //End block
                sStringCache.remove(name);
            } //End block
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_1323915232 =         null;
        var540C13E9E156B687226421B24F2DF178_1323915232.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1323915232;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.571 -0400", hash_original_method = "70E4290F1842F0A45B89D50D6CDEDDBB", hash_generated_method = "0BE61ABF45CCAED0BAE893C4FC9BC606")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.575 -0400", hash_original_method = "771B010EDE230C24A313E1F6F3869FDB", hash_generated_method = "EABD77D8347E3FF097344544DD8E8C61")
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
CharSequence var79CC641C1148018540A26F7ADC424893_1427929623 =             text;
            var79CC641C1148018540A26F7ADC424893_1427929623.addTaint(taint);
            return var79CC641C1148018540A26F7ADC424893_1427929623;
        } //End block
    if(appInfo == null)        
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
CharSequence var540C13E9E156B687226421B24F2DF178_367707013 =                 null;
                var540C13E9E156B687226421B24F2DF178_367707013.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_367707013;
            } //End block
        } //End block
        try 
        {
            Resources r = getResourcesForApplication(appInfo);
            text = r.getText(resid);
            putCachedString(name, text);
CharSequence var79CC641C1148018540A26F7ADC424893_1740617980 =             text;
            var79CC641C1148018540A26F7ADC424893_1740617980.addTaint(taint);
            return var79CC641C1148018540A26F7ADC424893_1740617980;
        } //End block
        catch (NameNotFoundException e)
        {
        } //End block
        catch (RuntimeException e)
        {
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_1507544531 =         null;
        var540C13E9E156B687226421B24F2DF178_1507544531.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1507544531;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.578 -0400", hash_original_method = "F130C54905A9CE16326CF20EF6E93255", hash_generated_method = "CA253F9476DB14F3F5FF21F43C3A1ABE")
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
XmlResourceParser var540C13E9E156B687226421B24F2DF178_675007006 =                 null;
                var540C13E9E156B687226421B24F2DF178_675007006.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_675007006;
            } //End block
        } //End block
        try 
        {
            Resources r = getResourcesForApplication(appInfo);
XmlResourceParser var46FC7866FFAC31CEDC61632F8441D270_267251407 =             r.getXml(resid);
            var46FC7866FFAC31CEDC61632F8441D270_267251407.addTaint(taint);
            return var46FC7866FFAC31CEDC61632F8441D270_267251407;
        } //End block
        catch (RuntimeException e)
        {
        } //End block
        catch (NameNotFoundException e)
        {
        } //End block
XmlResourceParser var540C13E9E156B687226421B24F2DF178_1918316013 =         null;
        var540C13E9E156B687226421B24F2DF178_1918316013.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1918316013;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.579 -0400", hash_original_method = "4AFDE050276913F392973B277F54706D", hash_generated_method = "D0FEA45180AAB533385C4AF9F047AEA0")
    @Override
    public CharSequence getApplicationLabel(ApplicationInfo info) {
        addTaint(info.getTaint());
CharSequence varE6B628DF4BADE921BC959EBAA37CE23C_1225538538 =         info.loadLabel(this);
        varE6B628DF4BADE921BC959EBAA37CE23C_1225538538.addTaint(taint);
        return varE6B628DF4BADE921BC959EBAA37CE23C_1225538538;
        // ---------- Original Method ----------
        //return info.loadLabel(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.580 -0400", hash_original_method = "99610A6DD5E10C01303307EBA6938AA8", hash_generated_method = "2A5B0EA45A3D6EA2D700B737770C1E15")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.581 -0400", hash_original_method = "769145FCC72852B2314845C8A89A2DAD", hash_generated_method = "444D9A5DE967A3750EA4B71318F6E866")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.582 -0400", hash_original_method = "E593338881B3E45506EA974F446D2A6B", hash_generated_method = "62CA204D9551A58E7372CB12E6B5754E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.583 -0400", hash_original_method = "A168A8E169316429D31E261AD639AED4", hash_generated_method = "F58CD5A8DA31BE565243A0A5975D77BF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.585 -0400", hash_original_method = "D8F1CA3B8F90BF876B114DD825F09703", hash_generated_method = "03A2C558F2A010B045FEEADA53758B3C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.586 -0400", hash_original_method = "13C0F9FC5FF4142BD538C8A3AADB3621", hash_generated_method = "9DDD8AFAF91E096423E588E645359712")
    @Override
    public String getInstallerPackageName(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
String var485A510364D927E61B680212BA336E80_1598383468 =             mPM.getInstallerPackageName(packageName);
            var485A510364D927E61B680212BA336E80_1598383468.addTaint(taint);
            return var485A510364D927E61B680212BA336E80_1598383468;
        } //End block
        catch (RemoteException e)
        {
        } //End block
String var540C13E9E156B687226421B24F2DF178_773552441 =         null;
        var540C13E9E156B687226421B24F2DF178_773552441.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_773552441;
        // ---------- Original Method ----------
        //try {
            //return mPM.getInstallerPackageName(packageName);
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.588 -0400", hash_original_method = "6B4A8C0BA02325B97A4B696E509E27F1", hash_generated_method = "C4B0DF22FF374AD59393240959C2E93A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.589 -0400", hash_original_method = "41D4F7CDEA8F3FA97A215E5DB5AE3B7F", hash_generated_method = "039208596E478E2ECAE772814A90F585")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.590 -0400", hash_original_method = "9E003FA712762A764BBDA3187B8255C1", hash_generated_method = "5BC33433D6FF6317367938E5077B9381")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.592 -0400", hash_original_method = "E7A7F0006F405C835ECAAE7B969343FA", hash_generated_method = "0DFC32E806D142AE27C062EF41564979")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.593 -0400", hash_original_method = "8531AD2E443F843CDBBD03DDCC5F2882", hash_generated_method = "96740309BB7679BBF21F654441046A5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.595 -0400", hash_original_method = "00314015F36B785D35449EC7724DA4A0", hash_generated_method = "283CDB9FA37FC104E9108C08680C4FF1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.596 -0400", hash_original_method = "A9291C102B2FAAEF4C90A57E1B6DE098", hash_generated_method = "CEDBC66756B184FDFD6BD726CFE9C0B4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.598 -0400", hash_original_method = "F1B5214867A85B15353BE55995A19BB6", hash_generated_method = "95F674AB1D65C5BD91757ED9E1C0D26D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.600 -0400", hash_original_method = "4A08CFB9ACE88EAEABD2D18F083F329D", hash_generated_method = "2289EF2C36D85B37C0A47D194EDFC0A2")
    @Override
    public List<PackageInfo> getPreferredPackages(int flags) {
        addTaint(flags);
        try 
        {
List<PackageInfo> var02CECA28466431CD30D6FEB0418EEBD2_1017084194 =             mPM.getPreferredPackages(flags);
            var02CECA28466431CD30D6FEB0418EEBD2_1017084194.addTaint(taint);
            return var02CECA28466431CD30D6FEB0418EEBD2_1017084194;
        } //End block
        catch (RemoteException e)
        {
        } //End block
List<PackageInfo> var85E52041F0F27DC16548B92A1451C09A_1394019903 =         new ArrayList<PackageInfo>();
        var85E52041F0F27DC16548B92A1451C09A_1394019903.addTaint(taint);
        return var85E52041F0F27DC16548B92A1451C09A_1394019903;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPreferredPackages(flags);
        //} catch (RemoteException e) {
        //}
        //return new ArrayList<PackageInfo>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.601 -0400", hash_original_method = "E5D2F7A75D600839A582F36FB9BA5425", hash_generated_method = "0CA7B05C47AD238DC8969FE5C9314B73")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.604 -0400", hash_original_method = "2885B1E40721D55CC13EAA30EB1BAE52", hash_generated_method = "9C7807BF4DEA56696EE16ECA89DE8227")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.605 -0400", hash_original_method = "818084167B76F544DAE31D40EA850683", hash_generated_method = "47FF1463C70C2B3A5407D561B0CEF8EB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.607 -0400", hash_original_method = "9A1408660FD10D92BECBE2BE18AA9510", hash_generated_method = "C9B2835B7C4D271C306D117C2930165A")
    @Override
    public int getPreferredActivities(List<IntentFilter> outFilters,
                                      List<ComponentName> outActivities, String packageName) {
        addTaint(packageName.getTaint());
        addTaint(outActivities.getTaint());
        addTaint(outFilters.getTaint());
        try 
        {
            int var9855CC69D059D6BFAA02AAB67EC603BD_1710710787 = (mPM.getPreferredActivities(outFilters, outActivities, packageName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143131528 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143131528;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1796639145 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_182086926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_182086926;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPreferredActivities(outFilters, outActivities, packageName);
        //} catch (RemoteException e) {
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.608 -0400", hash_original_method = "324289EEBFA692363CEA9B4C548C82A7", hash_generated_method = "175E90ECB2108950DE129925BC549CBB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.609 -0400", hash_original_method = "214E6E4C94F679DC0FE6A4159B821EAF", hash_generated_method = "327D4A049B11F56EAB0F8167CD6B22DD")
    @Override
    public int getComponentEnabledSetting(ComponentName componentName) {
        addTaint(componentName.getTaint());
        try 
        {
            int var82F6DDED4142FD46021C481C139BB7B9_723158169 = (mPM.getComponentEnabledSetting(componentName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_948729903 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_948729903;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var5719CD54023665EBD976CE3F1BF7827E_95727993 = (PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_464905214 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_464905214;
        // ---------- Original Method ----------
        //try {
            //return mPM.getComponentEnabledSetting(componentName);
        //} catch (RemoteException e) {
        //}
        //return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.610 -0400", hash_original_method = "893989AE0F295A10184FE7AD874B7991", hash_generated_method = "9AFCF0E334670CF211CE58750D6849C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.611 -0400", hash_original_method = "786754E395F784476E8D899ABD01121D", hash_generated_method = "E39C84EDEBB2DA40889656A78E8671D2")
    @Override
    public int getApplicationEnabledSetting(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
            int varED96627AAEA0BB660315B43819049B7C_872751081 = (mPM.getApplicationEnabledSetting(packageName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852326016 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852326016;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var5719CD54023665EBD976CE3F1BF7827E_114038996 = (PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275118582 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275118582;
        // ---------- Original Method ----------
        //try {
            //return mPM.getApplicationEnabledSetting(packageName);
        //} catch (RemoteException e) {
        //}
        //return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.611 -0400", hash_original_method = "26D19368C79A5889D2D25A72A45789A8", hash_generated_method = "5B4FACE291B3743B58B2A7B0BFB201F6")
    @Override
    public UserInfo createUser(String name, int flags) {
        addTaint(flags);
        addTaint(name.getTaint());
        try 
        {
UserInfo var30388AEABCB67D89C63024B4918EB97E_1167467122 =             mPM.createUser(name, flags);
            var30388AEABCB67D89C63024B4918EB97E_1167467122.addTaint(taint);
            return var30388AEABCB67D89C63024B4918EB97E_1167467122;
        } //End block
        catch (RemoteException e)
        {
        } //End block
UserInfo var540C13E9E156B687226421B24F2DF178_942799385 =         null;
        var540C13E9E156B687226421B24F2DF178_942799385.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_942799385;
        // ---------- Original Method ----------
        //try {
            //return mPM.createUser(name, flags);
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.612 -0400", hash_original_method = "D3989192690585F23E6C25734E0C3BDB", hash_generated_method = "971C6A5773E28E2CA43F9C50FD3F02F5")
    @Override
    public List<UserInfo> getUsers() {
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        UserInfo primary = new UserInfo(0, "Root!",
                UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        users.add(primary);
List<UserInfo> varB587D448BB2B2711D4473D79B7F2AAC8_1099939617 =         users;
        varB587D448BB2B2711D4473D79B7F2AAC8_1099939617.addTaint(taint);
        return varB587D448BB2B2711D4473D79B7F2AAC8_1099939617;
        // ---------- Original Method ----------
        //ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        //UserInfo primary = new UserInfo(0, "Root!",
                //UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        //users.add(primary);
        //return users;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.614 -0400", hash_original_method = "7D391C716B6EBFD3B4233647A1DCBC34", hash_generated_method = "686BDFEC2AC7B57082B42E99E91E9BAE")
    @Override
    public boolean removeUser(int id) {
        addTaint(id);
        try 
        {
            boolean var722621000620FBE206A993656F472659_1396786964 = (mPM.removeUser(id));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273313728 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273313728;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1406430878 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744951921 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_744951921;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mPM.removeUser(id);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.615 -0400", hash_original_method = "C52981B6B26B608864F1952FFD2E785F", hash_generated_method = "768E22F6EBCD52428AB6C0593A94E9CB")
    @Override
    public void updateUserName(int id, String name) {
        addTaint(name.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.616 -0400", hash_original_method = "B193A8F9463928060D13777D952477CD", hash_generated_method = "4CD5B965E87522729F955C64A5544391")
    @Override
    public void updateUserFlags(int id, int flags) {
        addTaint(flags);
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.618 -0400", hash_original_method = "05FAEEF75E7B74D35A0F0687A4ACD32C", hash_generated_method = "D7F409BA880335DF49F329855BE8BFA9")
    @Override
    public VerifierDeviceIdentity getVerifierDeviceIdentity() {
        try 
        {
VerifierDeviceIdentity varE0E6AA86EC4C031775B3978DD0D941F0_1616098019 =             mPM.getVerifierDeviceIdentity();
            varE0E6AA86EC4C031775B3978DD0D941F0_1616098019.addTaint(taint);
            return varE0E6AA86EC4C031775B3978DD0D941F0_1616098019;
        } //End block
        catch (RemoteException e)
        {
        } //End block
VerifierDeviceIdentity var540C13E9E156B687226421B24F2DF178_888868691 =         null;
        var540C13E9E156B687226421B24F2DF178_888868691.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_888868691;
        // ---------- Original Method ----------
        //try {
            //return mPM.getVerifierDeviceIdentity();
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    private static final class ResourceName {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.619 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "6F92EE1B3BCDC0C4179CF5FD998BE046")

        String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.620 -0400", hash_original_field = "D4DDD8F15E145D654808CFEB3504E8E3", hash_generated_field = "5FB1FE173593F2C1352A3849ECD329FE")

        int iconId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.621 -0400", hash_original_method = "00C0083FA3192C6FB2E9C58DC21ABF99", hash_generated_method = "1E60D2B25AB72FD493F4CCEBE8E14228")
          ResourceName(String _packageName, int _iconId) {
            packageName = _packageName;
            iconId = _iconId;
            // ---------- Original Method ----------
            //packageName = _packageName;
            //iconId = _iconId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.624 -0400", hash_original_method = "1D7CABC5D0E2E4029539D2105E7113C1", hash_generated_method = "B5B6C95FC4FFD613321C1FA5C1219219")
          ResourceName(ApplicationInfo aInfo, int _iconId) {
            this(aInfo.packageName, _iconId);
            addTaint(_iconId);
            addTaint(aInfo.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.626 -0400", hash_original_method = "316DD832F87E78ED23C1ED370845ED19", hash_generated_method = "67B24523D8C521DE202670C63AD12EE4")
          ResourceName(ComponentInfo cInfo, int _iconId) {
            this(cInfo.applicationInfo.packageName, _iconId);
            addTaint(_iconId);
            addTaint(cInfo.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.627 -0400", hash_original_method = "B7E8883725512A2439D57072801DA2BC", hash_generated_method = "06291B753B76B4CEA06ADE21A9CF1417")
          ResourceName(ResolveInfo rInfo, int _iconId) {
            this(rInfo.activityInfo.applicationInfo.packageName, _iconId);
            addTaint(_iconId);
            addTaint(rInfo.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.630 -0400", hash_original_method = "77EA94B0E7A0581CD73B79023B92E268", hash_generated_method = "7126D11D641E70991B209317F4B4E79F")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
    if(this == o)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_2040127832 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1929306882 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1929306882;
            }
    if(o == null || getClass() != o.getClass())            
            {
            boolean var68934A3E9455FA72420237EB05902327_571706075 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314205726 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314205726;
            }
            ResourceName that = (ResourceName) o;
    if(iconId != that.iconId)            
            {
            boolean var68934A3E9455FA72420237EB05902327_481834748 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932572697 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932572697;
            }
            boolean varE27CADC8CB9A21C0E4B9A6064C0A95DE_1813651140 = (!(packageName != null ?
                     !packageName.equals(that.packageName) : that.packageName != null));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1390771554 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1390771554;
            // ---------- Original Method ----------
            //if (this == o) return true;
            //if (o == null || getClass() != o.getClass()) return false;
            //ResourceName that = (ResourceName) o;
            //if (iconId != that.iconId) return false;
            //return !(packageName != null ?
                     //!packageName.equals(that.packageName) : that.packageName != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.630 -0400", hash_original_method = "FE96AD3461E654FCE4E8B88F254AC3EE", hash_generated_method = "0A6AA223DA2F24E6EAA6172E66AC07B2")
        @Override
        public int hashCode() {
            int result;
            result = packageName.hashCode();
            result = 31 * result + iconId;
            int varB4A88417B3D0170D754C647C30B7216A_379793665 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_76200900 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_76200900;
            // ---------- Original Method ----------
            //int result;
            //result = packageName.hashCode();
            //result = 31 * result + iconId;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.631 -0400", hash_original_method = "19C1C9668D8A7EEF540F3D9429936D14", hash_generated_method = "A1ECE9EE59FB553E853384C992BA45DD")
        @Override
        public String toString() {
String var2B4501D95CD6758F165DA6F1F56CC01F_82687100 =             "{ResourceName " + packageName + " / " + iconId + "}";
            var2B4501D95CD6758F165DA6F1F56CC01F_82687100.addTaint(taint);
            return var2B4501D95CD6758F165DA6F1F56CC01F_82687100;
            // ---------- Original Method ----------
            //return "{ResourceName " + packageName + " / " + iconId + "}";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.631 -0400", hash_original_field = "6567C925641831CFA00E9DD4884FA1D6", hash_generated_field = "9103478CE6502665DE73DD4F276104D2")

    private static final String TAG = "ApplicationPackageManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.631 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.631 -0400", hash_original_field = "C3489935DD7AFC611D460C12208E5765", hash_generated_field = "D9A207E7F6832116E237531F8566E278")

    private final static boolean DEBUG_ICONS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.632 -0400", hash_original_field = "2F49D49D71E16DE6B9E03ABB51788CD5", hash_generated_field = "589A8BDF0C7416090F474EA4E832C9BC")

    private static final Object sSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.632 -0400", hash_original_field = "86949C5674DAE04FF598125EDFB9A09B", hash_generated_field = "4B02A68E27DCF1DC814B05F533A46F39")

    private static HashMap<ResourceName, WeakReference<Drawable.ConstantState>> sIconCache = new HashMap<ResourceName, WeakReference<Drawable.ConstantState>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.632 -0400", hash_original_field = "C59A7EE72451F56F2C82359DD275010F", hash_generated_field = "F43C1D13F1C693E3CC3452E528CF10D8")

    private static HashMap<ResourceName, WeakReference<CharSequence>> sStringCache = new HashMap<ResourceName, WeakReference<CharSequence>>();
}

