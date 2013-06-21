package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.app.IUsageStats;
import com.android.internal.os.PkgUsageStats;
import com.android.internal.util.MemInfoReader;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.IPackageDataObserver;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Debug;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Slog;
import android.view.Display;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityManager {
    private Context mContext;
    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.380 -0400", hash_original_method = "5B4171109A2201F1FE14E6225146AB80", hash_generated_method = "B3E6E823A19D053211AE897745B4E102")
    @DSModeled(DSC.SAFE)
     ActivityManager(Context context, Handler handler) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.381 -0400", hash_original_method = "BCFF8F5D8C51374E31DC49464CB803A5", hash_generated_method = "2ADBE0709342C6F19DFC360B11A639E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFrontActivityScreenCompatMode() {
        try 
        {
            int var6D57FFF049EDBBD675CB42E6E5881F63_1512851723 = (ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.381 -0400", hash_original_method = "1AD781893C5FA74DDB5BF5981AAFC282", hash_generated_method = "3441318D623934E3D99C126BF6D7BB22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFrontActivityScreenCompatMode(int mode) {
        dsTaint.addTaint(mode);
        try 
        {
            ActivityManagerNative.getDefault().setFrontActivityScreenCompatMode(mode);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setFrontActivityScreenCompatMode(mode);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.382 -0400", hash_original_method = "08DE0842CE89FB88CEE40B6F1F1D5D8A", hash_generated_method = "3E1E155BAD738BEC0BA4B1F6F589E501")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPackageScreenCompatMode(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            int var4970DBBC19CF020D2AB9E07CA6C5607B_640745391 = (ActivityManagerNative.getDefault().getPackageScreenCompatMode(packageName));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getPackageScreenCompatMode(packageName);
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.382 -0400", hash_original_method = "6272BC343B5B54EAA927E2C6A7A229FA", hash_generated_method = "2D9D23EE618DB836FE43AF30B9DEE372")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPackageScreenCompatMode(String packageName, int mode) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(mode);
        try 
        {
            ActivityManagerNative.getDefault().setPackageScreenCompatMode(packageName, mode);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setPackageScreenCompatMode(packageName, mode);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.383 -0400", hash_original_method = "43CD4547C63AA5BA08A4BB7431262A61", hash_generated_method = "ED689D87FD29450B8319CC5A63A4839E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getPackageAskScreenCompat(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            boolean var8E89A0F6D10823A8701FE5BBBD1FE149_1043857624 = (ActivityManagerNative.getDefault().getPackageAskScreenCompat(packageName));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getPackageAskScreenCompat(packageName);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.383 -0400", hash_original_method = "3BC1D3C0234B303E106B1ACB51D8D800", hash_generated_method = "978A90A2369B8073D7D29B23AB879250")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPackageAskScreenCompat(String packageName, boolean ask) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(ask);
        try 
        {
            ActivityManagerNative.getDefault().setPackageAskScreenCompat(packageName, ask);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setPackageAskScreenCompat(packageName, ask);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.384 -0400", hash_original_method = "B7DBD08AF6CFCEAABC628A74B78E8B6F", hash_generated_method = "6D9897B49DFFA67872E1F9832755DBF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMemoryClass() {
        int var9862DFF8105689D1FAD16F0A2A7D04D2_1137826592 = (staticGetMemoryClass());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return staticGetMemoryClass();
    }

    
        static public int staticGetMemoryClass() {
        String vmHeapSize = SystemProperties.get("dalvik.vm.heapgrowthlimit", "");
        if (vmHeapSize != null && !"".equals(vmHeapSize)) {
            return Integer.parseInt(vmHeapSize.substring(0, vmHeapSize.length()-1));
        }
        return staticGetLargeMemoryClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.385 -0400", hash_original_method = "50F084ADAAFF8EB942A9D9EB0C93D87F", hash_generated_method = "6BE64B5C24ACB4BB638667560CC5B5C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLargeMemoryClass() {
        int var69D319CAE7493EBEEA5EC841CBB29C6C_1516307496 = (staticGetLargeMemoryClass());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return staticGetLargeMemoryClass();
    }

    
        static public int staticGetLargeMemoryClass() {
        String vmHeapSize = SystemProperties.get("dalvik.vm.heapsize", "16m");
        return Integer.parseInt(vmHeapSize.substring(0, vmHeapSize.length()-1));
    }

    
        static public boolean isHighEndGfx(Display display) {
        MemInfoReader reader = new MemInfoReader();
        reader.readMemInfo();
        if (reader.getTotalSize() >= (512*1024*1024)) {
            return true;
        }
        Point p = new Point();
        display.getRealSize(p);
        int pixels = p.x * p.y;
        if (pixels >= (1024*600)) {
            return true;
        }
        return false;
    }

    
        static public boolean isLargeRAM() {
        MemInfoReader reader = new MemInfoReader();
        reader.readMemInfo();
        if (reader.getTotalSize() >= (640*1024*1024)) {
            return true;
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.387 -0400", hash_original_method = "F8BE7228FE8A06DB7E3F7EC0517EBE16", hash_generated_method = "A63A09200F1E3C58CFEDD31C512AF96A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<RecentTaskInfo> getRecentTasks(int maxNum, int flags) throws SecurityException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(maxNum);
        try 
        {
            List<RecentTaskInfo> var26C34576422CD3AA6F64606A10610CD6_2050314820 = (ActivityManagerNative.getDefault().getRecentTasks(maxNum,
                    flags));
        } //End block
        catch (RemoteException e)
        { }
        return (List<RecentTaskInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getRecentTasks(maxNum,
                    //flags);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.388 -0400", hash_original_method = "324273237D89470A473FD6EC5C103A40", hash_generated_method = "E0845C5BFFD09969E2650FCCDCE2A0F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<RunningTaskInfo> getRunningTasks(int maxNum, int flags, IThumbnailReceiver receiver) throws SecurityException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(maxNum);
        try 
        {
            List<RunningTaskInfo> varE0092079F64DEAD6D1D4101A8E7ADCD0_2089883153 = (ActivityManagerNative.getDefault().getTasks(maxNum, flags, receiver));
        } //End block
        catch (RemoteException e)
        { }
        return (List<RunningTaskInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getTasks(maxNum, flags, receiver);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.388 -0400", hash_original_method = "048E08D6499B0F81FA41B243F96225CE", hash_generated_method = "007D9282FCE2E9DDCECB9657137F0152")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<RunningTaskInfo> getRunningTasks(int maxNum) throws SecurityException {
        dsTaint.addTaint(maxNum);
        List<RunningTaskInfo> var2DF5CA28CDF194C5DCBEA41663028194_1064143360 = (getRunningTasks(maxNum, 0, null));
        return (List<RunningTaskInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getRunningTasks(maxNum, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.389 -0400", hash_original_method = "06417D4703E772AA57E4535D9CA52E2C", hash_generated_method = "D3306FCB35EB5B203662BE46D637079B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeSubTask(int taskId, int subTaskIndex) throws SecurityException {
        dsTaint.addTaint(subTaskIndex);
        dsTaint.addTaint(taskId);
        try 
        {
            boolean var07CF28A51B530B1C42F191E5697D370C_92666530 = (ActivityManagerNative.getDefault().removeSubTask(taskId, subTaskIndex));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().removeSubTask(taskId, subTaskIndex);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.390 -0400", hash_original_method = "B1BB833FCE4ABF3667361FA6F055417F", hash_generated_method = "A2BF6EB768B330BBCFAF167765AC521F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeTask(int taskId, int flags) throws SecurityException {
        dsTaint.addTaint(taskId);
        dsTaint.addTaint(flags);
        try 
        {
            boolean varE06E21935A507F8A824839E5F554648C_1460366241 = (ActivityManagerNative.getDefault().removeTask(taskId, flags));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().removeTask(taskId, flags);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.390 -0400", hash_original_method = "90A15739ABCD71E20C2601B2E690D2DC", hash_generated_method = "0304E991E9883ECBDB8073277FFE606E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TaskThumbnails getTaskThumbnails(int id) throws SecurityException {
        dsTaint.addTaint(id);
        try 
        {
            TaskThumbnails var5B632D12431BADBB3E85B2C4C0A1E560_1140418704 = (ActivityManagerNative.getDefault().getTaskThumbnails(id));
        } //End block
        catch (RemoteException e)
        { }
        return (TaskThumbnails)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getTaskThumbnails(id);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.391 -0400", hash_original_method = "68F3ECC95EA33C5EF7CED37FFBD163D9", hash_generated_method = "DC4004A6F98AD53922716B93451E9671")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void moveTaskToFront(int taskId, int flags) {
        dsTaint.addTaint(taskId);
        dsTaint.addTaint(flags);
        try 
        {
            ActivityManagerNative.getDefault().moveTaskToFront(taskId, flags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().moveTaskToFront(taskId, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.391 -0400", hash_original_method = "93643A575557EDD801C5647B318BA97A", hash_generated_method = "F496C1653B39AF744517D2CDD6C3E5B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<RunningServiceInfo> getRunningServices(int maxNum) throws SecurityException {
        dsTaint.addTaint(maxNum);
        try 
        {
            List<RunningServiceInfo> var906A88D4420C6DBB6E72B2196F3B3C79_1138526343 = (ActivityManagerNative.getDefault()
                    .getServices(maxNum, 0));
        } //End block
        catch (RemoteException e)
        { }
        return (List<RunningServiceInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                    //.getServices(maxNum, 0);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.392 -0400", hash_original_method = "3F37B5EEA2E0ADFF7012B4DB8D3BC71C", hash_generated_method = "563CB69CA8261CA91CDE1DB6D5D59750")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PendingIntent getRunningServiceControlPanel(ComponentName service) throws SecurityException {
        dsTaint.addTaint(service.dsTaint);
        try 
        {
            PendingIntent var2B1F7394D13D9BCE30265B30D995C712_125969401 = (ActivityManagerNative.getDefault()
                    .getRunningServiceControlPanel(service));
        } //End block
        catch (RemoteException e)
        { }
        return (PendingIntent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                    //.getRunningServiceControlPanel(service);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.393 -0400", hash_original_method = "B6E6E4E46821E411AC60EE30A7424576", hash_generated_method = "A0CD8B49D91035A37C9A914356BF9E65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getMemoryInfo(MemoryInfo outInfo) {
        dsTaint.addTaint(outInfo.dsTaint);
        try 
        {
            ActivityManagerNative.getDefault().getMemoryInfo(outInfo);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().getMemoryInfo(outInfo);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.393 -0400", hash_original_method = "F72074CE1B364F8B93C8BBDF31501500", hash_generated_method = "792EFD7870D0A938D081A8A0F8E35F52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clearApplicationUserData(String packageName, IPackageDataObserver observer) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            boolean var6850AED94B5983BF09E13F93CF984187_1385202819 = (ActivityManagerNative.getDefault().clearApplicationUserData(packageName, 
                    observer));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().clearApplicationUserData(packageName, 
                    //observer);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.397 -0400", hash_original_method = "F53E97F522CAE83DA0CBCF957085AF2C", hash_generated_method = "DE832A8CB340935B0AA8AE52B9B28D4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ProcessErrorStateInfo> getProcessesInErrorState() {
        try 
        {
            List<ProcessErrorStateInfo> var21830C4C4064299EF5EAAEF44E9533E0_1571851128 = (ActivityManagerNative.getDefault().getProcessesInErrorState());
        } //End block
        catch (RemoteException e)
        { }
        return (List<ProcessErrorStateInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getProcessesInErrorState();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.401 -0400", hash_original_method = "5737B6241A3389A78D86162B5C5BDB02", hash_generated_method = "55DC4CCEAE49C4CE6D22C0039F6AEE02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ApplicationInfo> getRunningExternalApplications() {
        try 
        {
            List<ApplicationInfo> varA73169A7478F77D402570A5B0E1FF006_1505189253 = (ActivityManagerNative.getDefault().getRunningExternalApplications());
        } //End block
        catch (RemoteException e)
        { }
        return (List<ApplicationInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getRunningExternalApplications();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.402 -0400", hash_original_method = "BB41AA7EC02A452F0653300FBA1EFF8A", hash_generated_method = "B4384D88AFB6B963D921FBCF77FF81B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<RunningAppProcessInfo> getRunningAppProcesses() {
        try 
        {
            List<RunningAppProcessInfo> var8BA730091C8E2B4321BB5C84DF3EB143_892423492 = (ActivityManagerNative.getDefault().getRunningAppProcesses());
        } //End block
        catch (RemoteException e)
        { }
        return (List<RunningAppProcessInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getRunningAppProcesses();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.403 -0400", hash_original_method = "BA29C29542BF4FC0E2178C81FA222823", hash_generated_method = "1CC5C01BDBAA7783E5C725DA5465EAB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) {
        dsTaint.addTaint(pids[0]);
        try 
        {
            Debug.MemoryInfo[] var72A4E7F6179FD37B2A53189E6AD76F09_1554686125 = (ActivityManagerNative.getDefault().getProcessMemoryInfo(pids));
        } //End block
        catch (RemoteException e)
        { }
        return (Debug.MemoryInfo[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getProcessMemoryInfo(pids);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.405 -0400", hash_original_method = "AB97F58AF8359C056EB136FA16E11328", hash_generated_method = "7ABD9542A00FCFD97A968850A6554884")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void restartPackage(String packageName) {
        dsTaint.addTaint(packageName);
        killBackgroundProcesses(packageName);
        // ---------- Original Method ----------
        //killBackgroundProcesses(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.406 -0400", hash_original_method = "BAC028425422747AF2B8DB952F37E411", hash_generated_method = "49BEE698A78CED9B26DC2F5ADA75A0B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void killBackgroundProcesses(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            ActivityManagerNative.getDefault().killBackgroundProcesses(packageName);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().killBackgroundProcesses(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.407 -0400", hash_original_method = "F30C6D9D6BE88E1DA2EC5D39F1D44538", hash_generated_method = "AE84589B2AFAF48BD16F97FA09F01804")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void forceStopPackage(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            ActivityManagerNative.getDefault().forceStopPackage(packageName);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().forceStopPackage(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.407 -0400", hash_original_method = "002CA49339A7476A8E8EF41ECCC37BDD", hash_generated_method = "E7C9B9EFDD90915AD28EB09CA6696AB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConfigurationInfo getDeviceConfigurationInfo() {
        try 
        {
            ConfigurationInfo var9A01BB6CE6372EDF72014ACCA11C22C3_121430373 = (ActivityManagerNative.getDefault().getDeviceConfigurationInfo());
        } //End block
        catch (RemoteException e)
        { }
        return (ConfigurationInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getDeviceConfigurationInfo();
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.408 -0400", hash_original_method = "E6A8DEADBC97DC6A083D1FDDD3BF2E4E", hash_generated_method = "0AF4A280AF895B192F6DE2C10873F8CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLauncherLargeIconDensity() {
        Resources res;
        res = mContext.getResources();
        int density;
        density = res.getDisplayMetrics().densityDpi;
        {
            boolean varE01F796B7DD545CA1852C72371851054_100395864 = ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE);
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final Resources res = mContext.getResources();
        //final int density = res.getDisplayMetrics().densityDpi;
        //if ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                //!= Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            //return density;
        //}
        //switch (density) {
            //case DisplayMetrics.DENSITY_LOW:
                //return DisplayMetrics.DENSITY_MEDIUM;
            //case DisplayMetrics.DENSITY_MEDIUM:
                //return DisplayMetrics.DENSITY_HIGH;
            //case DisplayMetrics.DENSITY_HIGH:
                //return DisplayMetrics.DENSITY_XHIGH;
            //case DisplayMetrics.DENSITY_XHIGH:
                //return DisplayMetrics.DENSITY_MEDIUM * 2;
            //default:
                //return density;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.409 -0400", hash_original_method = "1ABECD33DDCEDD9654A62357CF29D109", hash_generated_method = "200C30F3391BA95D4C1DCEFC787C6745")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLauncherLargeIconSize() {
        Resources res;
        res = mContext.getResources();
        int size;
        size = res.getDimensionPixelSize(android.R.dimen.app_icon_size);
        {
            boolean varE01F796B7DD545CA1852C72371851054_695768113 = ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE);
        } //End collapsed parenthetic
        int density;
        density = res.getDisplayMetrics().densityDpi;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static boolean isUserAMonkey() {
        try {
            return ActivityManagerNative.getDefault().isUserAMonkey();
        } catch (RemoteException e) {
        }
        return false;
    }

    
        public static boolean isRunningInTestHarness() {
        return SystemProperties.getBoolean("ro.test_harness", false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.417 -0400", hash_original_method = "2575FA7FD2518D90A93FBC6E066D35C1", hash_generated_method = "8BB20C8EF1A089E3C4B3C18D40663E35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Map<String, Integer> getAllPackageLaunchCounts() {
        try 
        {
            IUsageStats usageStatsService;
            usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
            {
                Map<String, Integer> varE2EF074359A6EFF9F3A2866FEBE371E4_2072595822 = (new HashMap<String, Integer>());
            } //End block
            PkgUsageStats[] allPkgUsageStats;
            allPkgUsageStats = usageStatsService.getAllPkgUsageStats();
            {
                Map<String, Integer> varE2EF074359A6EFF9F3A2866FEBE371E4_645331469 = (new HashMap<String, Integer>());
            } //End block
            Map<String, Integer> launchCounts;
            launchCounts = new HashMap<String, Integer>();
            {
                Iterator<PkgUsageStats> varBE58BF7E38EBDF2D969BE0FA0EE8F65D_131224279 = (allPkgUsageStats).iterator();
                varBE58BF7E38EBDF2D969BE0FA0EE8F65D_131224279.hasNext();
                PkgUsageStats pkgUsageStats = varBE58BF7E38EBDF2D969BE0FA0EE8F65D_131224279.next();
                {
                    launchCounts.put(pkgUsageStats.packageName, pkgUsageStats.launchCount);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        {
            Map<String, Integer> var8BFDF47EE17777B99F54208F78485CC4_432573685 = (new HashMap<String, Integer>());
        } //End block
        return (Map<String, Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.418 -0400", hash_original_method = "97D195D4FE7E8BCA1AFB9969B53F0E5E", hash_generated_method = "EC88BA3D6FE570F1D483F1FAB1F54483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PkgUsageStats[] getAllPackageUsageStats() {
        try 
        {
            IUsageStats usageStatsService;
            usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
            {
                PkgUsageStats[] varBAFDD5C3196C35C285B9E383CDC82FF9_1190885689 = (usageStatsService.getAllPkgUsageStats());
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        PkgUsageStats[] varB50B0713829D32DB9D4BA86059EB0436_1933478293 = (new PkgUsageStats[0]);
        return (PkgUsageStats[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //IUsageStats usageStatsService = IUsageStats.Stub.asInterface(
                    //ServiceManager.getService("usagestats"));
            //if (usageStatsService != null) {
                //return usageStatsService.getAllPkgUsageStats();
            //}
        //} catch (RemoteException e) {
            //Log.w(TAG, "Could not query usage stats", e);
        //}
        //return new PkgUsageStats[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.419 -0400", hash_original_method = "5F692D6C0F0BEC319B49459A73599D4B", hash_generated_method = "4D6C71FDD929C3D0AAF621D49DCE140E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean switchUser(int userid) {
        dsTaint.addTaint(userid);
        try 
        {
            boolean var2D87E0C1C61F5F6722509A3C54C5660D_247452699 = (ActivityManagerNative.getDefault().switchUser(userid));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().switchUser(userid);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    public static class RecentTaskInfo implements Parcelable {
        public int id;
        public int persistentId;
        public Intent baseIntent;
        public ComponentName origActivity;
        public CharSequence description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.420 -0400", hash_original_method = "C08B7337C6B109635FE340903513A97B", hash_generated_method = "3151CC50C901E54C1039F8A4558613C1")
        @DSModeled(DSC.SAFE)
        public RecentTaskInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.421 -0400", hash_original_method = "1CABC845DDD8B9A1DEC9FF64F1615AFC", hash_generated_method = "CE268B8EF4BFC4BF05C1E18C19B70696")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private RecentTaskInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.422 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.423 -0400", hash_original_method = "A024AE935060D48D15B6110668C59DDF", hash_generated_method = "C55982A9B97B8A7288ABC9A7BA86DD93")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(id);
            dest.writeInt(persistentId);
            {
                dest.writeInt(1);
                baseIntent.writeToParcel(dest, 0);
            } //End block
            {
                dest.writeInt(0);
            } //End block
            ComponentName.writeToParcel(origActivity, dest);
            TextUtils.writeToParcel(description, dest,
                    Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            // ---------- Original Method ----------
            //dest.writeInt(id);
            //dest.writeInt(persistentId);
            //if (baseIntent != null) {
                //dest.writeInt(1);
                //baseIntent.writeToParcel(dest, 0);
            //} else {
                //dest.writeInt(0);
            //}
            //ComponentName.writeToParcel(origActivity, dest);
            //TextUtils.writeToParcel(description, dest,
                    //Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.504 -0400", hash_original_method = "F67217ABAEC36040C8F444901EE65BC8", hash_generated_method = "D10E7D35CE0B376DA951A027482300BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            id = source.readInt();
            persistentId = source.readInt();
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_2041840778 = (source.readInt() != 0);
                {
                    baseIntent = Intent.CREATOR.createFromParcel(source);
                } //End block
                {
                    baseIntent = null;
                } //End block
            } //End collapsed parenthetic
            origActivity = ComponentName.readFromParcel(source);
            description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            // ---------- Original Method ----------
            //id = source.readInt();
            //persistentId = source.readInt();
            //if (source.readInt() != 0) {
                //baseIntent = Intent.CREATOR.createFromParcel(source);
            //} else {
                //baseIntent = null;
            //}
            //origActivity = ComponentName.readFromParcel(source);
            //description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        }

        
        public static final Creator<RecentTaskInfo> CREATOR = new Creator<RecentTaskInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.505 -0400", hash_original_method = "754BED839284C604C75BEECB20D1E8CF", hash_generated_method = "94999372F24303F93028AA69147060CB")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public RecentTaskInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                RecentTaskInfo var366D6EC27AF5C2DB7D3C22B1523A96A3_1957322075 = (new RecentTaskInfo(source));
                return (RecentTaskInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RecentTaskInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.510 -0400", hash_original_method = "D970AC33B35E94C08348859E4EC02E6C", hash_generated_method = "03A624EE7D1560534C4CD8B3E5C1E666")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public RecentTaskInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                RecentTaskInfo[] var0DC66E4CA4EA597F0D9D6678FF206969_1634203563 = (new RecentTaskInfo[size]);
                return (RecentTaskInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RecentTaskInfo[size];
            }

            
}; //Transformed anonymous class
    }


    
    public static class RunningTaskInfo implements Parcelable {
        public int id;
        public ComponentName baseActivity;
        public ComponentName topActivity;
        public Bitmap thumbnail;
        public CharSequence description;
        public int numActivities;
        public int numRunning;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.511 -0400", hash_original_method = "6DA0A8D9CEF41C0CB91D2D95D7E71D44", hash_generated_method = "00FB201893D0BF493904CEE004049E1E")
        @DSModeled(DSC.SAFE)
        public RunningTaskInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.511 -0400", hash_original_method = "A0900FA369CFAE0B339B23849E0D0E54", hash_generated_method = "AF4A56E5574F28D8194E5AD2A12BDBF4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private RunningTaskInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.512 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.513 -0400", hash_original_method = "224D236A6A210D9CABF5D7D423C96E97", hash_generated_method = "299993D45E81AFF1FF92CAAA7F81725B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(id);
            ComponentName.writeToParcel(baseActivity, dest);
            ComponentName.writeToParcel(topActivity, dest);
            {
                dest.writeInt(1);
                thumbnail.writeToParcel(dest, 0);
            } //End block
            {
                dest.writeInt(0);
            } //End block
            TextUtils.writeToParcel(description, dest,
                    Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            dest.writeInt(numActivities);
            dest.writeInt(numRunning);
            // ---------- Original Method ----------
            //dest.writeInt(id);
            //ComponentName.writeToParcel(baseActivity, dest);
            //ComponentName.writeToParcel(topActivity, dest);
            //if (thumbnail != null) {
                //dest.writeInt(1);
                //thumbnail.writeToParcel(dest, 0);
            //} else {
                //dest.writeInt(0);
            //}
            //TextUtils.writeToParcel(description, dest,
                    //Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            //dest.writeInt(numActivities);
            //dest.writeInt(numRunning);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.513 -0400", hash_original_method = "1A58A87C00619395DA7F7A454E1E03D5", hash_generated_method = "3BA18BE6E3694B6921E5C80EDECD3F22")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            id = source.readInt();
            baseActivity = ComponentName.readFromParcel(source);
            topActivity = ComponentName.readFromParcel(source);
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_2132322140 = (source.readInt() != 0);
                {
                    thumbnail = Bitmap.CREATOR.createFromParcel(source);
                } //End block
                {
                    thumbnail = null;
                } //End block
            } //End collapsed parenthetic
            description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            numActivities = source.readInt();
            numRunning = source.readInt();
            // ---------- Original Method ----------
            //id = source.readInt();
            //baseActivity = ComponentName.readFromParcel(source);
            //topActivity = ComponentName.readFromParcel(source);
            //if (source.readInt() != 0) {
                //thumbnail = Bitmap.CREATOR.createFromParcel(source);
            //} else {
                //thumbnail = null;
            //}
            //description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            //numActivities = source.readInt();
            //numRunning = source.readInt();
        }

        
        public static final Creator<RunningTaskInfo> CREATOR = new Creator<RunningTaskInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.514 -0400", hash_original_method = "289D74B80F1DDE34702D81134C81DC0D", hash_generated_method = "EEFECB59E988B514C022690E97957DD5")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public RunningTaskInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                RunningTaskInfo varC8E9F6CEC0FC0F52579DF98D55DD4880_2080720563 = (new RunningTaskInfo(source));
                return (RunningTaskInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningTaskInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.515 -0400", hash_original_method = "87B1B374C2173B951C96C3D08DE2EEAE", hash_generated_method = "169C0993C90DDC8B0D9AE4635D34B1C2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public RunningTaskInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                RunningTaskInfo[] varC3A8431C821F8959F8FDA0AA0AA4600C_235226183 = (new RunningTaskInfo[size]);
                return (RunningTaskInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningTaskInfo[size];
            }

            
}; //Transformed anonymous class
    }


    
    public static class TaskThumbnails implements Parcelable {
        public Bitmap mainThumbnail;
        public int numSubThumbbails;
        public IThumbnailRetriever retriever;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.515 -0400", hash_original_method = "EB2263C71F650A09D4909FB1B34C782F", hash_generated_method = "1036CA739667021DAECAC8857E8C6B4B")
        @DSModeled(DSC.SAFE)
        public TaskThumbnails() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.517 -0400", hash_original_method = "0FEFA86B10CDE25FCF4328B39BD2F7D5", hash_generated_method = "0D0BE2DB70938BFC87CBE5DEBB3E8D16")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private TaskThumbnails(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.518 -0400", hash_original_method = "C8A1C6791C443D43BB18F989CA6219B6", hash_generated_method = "8A2EB574C7A26E25339E2BBEB33EB74F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bitmap getSubThumbnail(int index) {
            dsTaint.addTaint(index);
            try 
            {
                Bitmap var68E445C93AEE27D5BFCA67096C8050B5_846113082 = (retriever.getThumbnail(index));
            } //End block
            catch (RemoteException e)
            { }
            return (Bitmap)dsTaint.getTaint();
            // ---------- Original Method ----------
            //try {
                //return retriever.getThumbnail(index);
            //} catch (RemoteException e) {
                //return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.519 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.520 -0400", hash_original_method = "1641949793D35FD49D0AD46DB3E00603", hash_generated_method = "0768B6E06B9987EC49016C5CE01FDBC6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            {
                dest.writeInt(1);
                mainThumbnail.writeToParcel(dest, 0);
            } //End block
            {
                dest.writeInt(0);
            } //End block
            dest.writeInt(numSubThumbbails);
            dest.writeStrongInterface(retriever);
            // ---------- Original Method ----------
            //if (mainThumbnail != null) {
                //dest.writeInt(1);
                //mainThumbnail.writeToParcel(dest, 0);
            //} else {
                //dest.writeInt(0);
            //}
            //dest.writeInt(numSubThumbbails);
            //dest.writeStrongInterface(retriever);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.521 -0400", hash_original_method = "19A7C144CCAE5CD51406B760DF512EA1", hash_generated_method = "8A85FED5C6562FA11A37CFA94886759F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_611842467 = (source.readInt() != 0);
                {
                    mainThumbnail = Bitmap.CREATOR.createFromParcel(source);
                } //End block
                {
                    mainThumbnail = null;
                } //End block
            } //End collapsed parenthetic
            numSubThumbbails = source.readInt();
            retriever = IThumbnailRetriever.Stub.asInterface(source.readStrongBinder());
            // ---------- Original Method ----------
            //if (source.readInt() != 0) {
                //mainThumbnail = Bitmap.CREATOR.createFromParcel(source);
            //} else {
                //mainThumbnail = null;
            //}
            //numSubThumbbails = source.readInt();
            //retriever = IThumbnailRetriever.Stub.asInterface(source.readStrongBinder());
        }

        
        public static final Creator<TaskThumbnails> CREATOR = new Creator<TaskThumbnails>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.522 -0400", hash_original_method = "D293F4B5B5D1E8DEC87E5785C502F4A1", hash_generated_method = "F4933D663B2E5D0EDED9A9D596AC0F86")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public TaskThumbnails createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                TaskThumbnails var3FFCB8FCD2705F782CFC8F26D1E928C9_281827396 = (new TaskThumbnails(source));
                return (TaskThumbnails)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new TaskThumbnails(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.523 -0400", hash_original_method = "32482EB33A7D57DC46F839E5FD8415A1", hash_generated_method = "80D6762479A2F89BE80067209B245833")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public TaskThumbnails[] newArray(int size) {
                dsTaint.addTaint(size);
                TaskThumbnails[] var847D8D14FB3DF306C640B94A64D47E3A_767769308 = (new TaskThumbnails[size]);
                return (TaskThumbnails[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new TaskThumbnails[size];
            }

            
}; //Transformed anonymous class
    }


    
    public static class RunningServiceInfo implements Parcelable {
        public ComponentName service;
        public int pid;
        public int uid;
        public String process;
        public boolean foreground;
        public long activeSince;
        public boolean started;
        public int clientCount;
        public int crashCount;
        public long lastActivityTime;
        public long restarting;
        public int flags;
        public String clientPackage;
        public int clientLabel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.524 -0400", hash_original_method = "621426751430068D32289E518662756C", hash_generated_method = "822CEFC1BD8FA9077CAB00884D317765")
        @DSModeled(DSC.SAFE)
        public RunningServiceInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.524 -0400", hash_original_method = "35E5A4903D7EB9EB66480EDFA6F47A72", hash_generated_method = "ECD249336DC2770F375900E6DF4D77E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private RunningServiceInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.525 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.526 -0400", hash_original_method = "048D37EC670A88D2663FCC084087D5E3", hash_generated_method = "82DB61D1A4D014CA001E0CDA2695484C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            ComponentName.writeToParcel(service, dest);
            dest.writeInt(pid);
            dest.writeInt(uid);
            dest.writeString(process);
            dest.writeInt(foreground ? 1 : 0);
            dest.writeLong(activeSince);
            dest.writeInt(started ? 1 : 0);
            dest.writeInt(clientCount);
            dest.writeInt(crashCount);
            dest.writeLong(lastActivityTime);
            dest.writeLong(restarting);
            dest.writeInt(this.flags);
            dest.writeString(clientPackage);
            dest.writeInt(clientLabel);
            // ---------- Original Method ----------
            //ComponentName.writeToParcel(service, dest);
            //dest.writeInt(pid);
            //dest.writeInt(uid);
            //dest.writeString(process);
            //dest.writeInt(foreground ? 1 : 0);
            //dest.writeLong(activeSince);
            //dest.writeInt(started ? 1 : 0);
            //dest.writeInt(clientCount);
            //dest.writeInt(crashCount);
            //dest.writeLong(lastActivityTime);
            //dest.writeLong(restarting);
            //dest.writeInt(this.flags);
            //dest.writeString(clientPackage);
            //dest.writeInt(clientLabel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.526 -0400", hash_original_method = "264C3E4C1DAB76B38CA08CE45829A86C", hash_generated_method = "E7AA91EA354F9FB17D58EC19AEFDAED8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            service = ComponentName.readFromParcel(source);
            pid = source.readInt();
            uid = source.readInt();
            process = source.readString();
            foreground = source.readInt() != 0;
            activeSince = source.readLong();
            started = source.readInt() != 0;
            clientCount = source.readInt();
            crashCount = source.readInt();
            lastActivityTime = source.readLong();
            restarting = source.readLong();
            flags = source.readInt();
            clientPackage = source.readString();
            clientLabel = source.readInt();
            // ---------- Original Method ----------
            //service = ComponentName.readFromParcel(source);
            //pid = source.readInt();
            //uid = source.readInt();
            //process = source.readString();
            //foreground = source.readInt() != 0;
            //activeSince = source.readLong();
            //started = source.readInt() != 0;
            //clientCount = source.readInt();
            //crashCount = source.readInt();
            //lastActivityTime = source.readLong();
            //restarting = source.readLong();
            //flags = source.readInt();
            //clientPackage = source.readString();
            //clientLabel = source.readInt();
        }

        
        public static final int FLAG_STARTED = 1<<0;
        public static final int FLAG_FOREGROUND = 1<<1;
        public static final int FLAG_SYSTEM_PROCESS = 1<<2;
        public static final int FLAG_PERSISTENT_PROCESS = 1<<3;
        public static final Creator<RunningServiceInfo> CREATOR = new Creator<RunningServiceInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.527 -0400", hash_original_method = "E255B8128AC8F9856A7419AECFDCF636", hash_generated_method = "DE15F8DA14DE738C5A4CE6D0A6196355")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public RunningServiceInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                RunningServiceInfo varD5396DDC8CE2DBE2FF3ECC76E75E0682_274778208 = (new RunningServiceInfo(source));
                return (RunningServiceInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningServiceInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.528 -0400", hash_original_method = "FD3ED620F54DFB73AA55E8F30DE37B83", hash_generated_method = "310554C89C9E2382812B12E7A8F34664")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public RunningServiceInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                RunningServiceInfo[] var37281D4930B48C06F58F227B538E78CA_2067826259 = (new RunningServiceInfo[size]);
                return (RunningServiceInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningServiceInfo[size];
            }

            
}; //Transformed anonymous class
    }


    
    public static class MemoryInfo implements Parcelable {
        public long availMem;
        public long threshold;
        public boolean lowMemory;
        public long hiddenAppThreshold;
        public long secondaryServerThreshold;
        public long visibleAppThreshold;
        public long foregroundAppThreshold;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.528 -0400", hash_original_method = "09AE2D253AD01F5533857164DB70587D", hash_generated_method = "FF74B0D10914F28AB3E573FB192E254D")
        @DSModeled(DSC.SAFE)
        public MemoryInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.529 -0400", hash_original_method = "EAA33F4FBF3C878879D517CBC8FFA048", hash_generated_method = "59177374CF85231EEAEF1DAD1A5EE39A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private MemoryInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.529 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.530 -0400", hash_original_method = "F89D0A9B79191784D882D224AE236CD7", hash_generated_method = "F9C620AC508D321837F966CC72B2630A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeLong(availMem);
            dest.writeLong(threshold);
            dest.writeInt(lowMemory ? 1 : 0);
            dest.writeLong(hiddenAppThreshold);
            dest.writeLong(secondaryServerThreshold);
            dest.writeLong(visibleAppThreshold);
            dest.writeLong(foregroundAppThreshold);
            // ---------- Original Method ----------
            //dest.writeLong(availMem);
            //dest.writeLong(threshold);
            //dest.writeInt(lowMemory ? 1 : 0);
            //dest.writeLong(hiddenAppThreshold);
            //dest.writeLong(secondaryServerThreshold);
            //dest.writeLong(visibleAppThreshold);
            //dest.writeLong(foregroundAppThreshold);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.530 -0400", hash_original_method = "63344B29322BA9906ACD5F2C274D4AFB", hash_generated_method = "BE3C5F7EEE6514A66005ADF587AC69D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            availMem = source.readLong();
            threshold = source.readLong();
            lowMemory = source.readInt() != 0;
            hiddenAppThreshold = source.readLong();
            secondaryServerThreshold = source.readLong();
            visibleAppThreshold = source.readLong();
            foregroundAppThreshold = source.readLong();
            // ---------- Original Method ----------
            //availMem = source.readLong();
            //threshold = source.readLong();
            //lowMemory = source.readInt() != 0;
            //hiddenAppThreshold = source.readLong();
            //secondaryServerThreshold = source.readLong();
            //visibleAppThreshold = source.readLong();
            //foregroundAppThreshold = source.readLong();
        }

        
        public static final Creator<MemoryInfo> CREATOR = new Creator<MemoryInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.532 -0400", hash_original_method = "83921F47BB880779DC0FD4AB57F3B1E1", hash_generated_method = "B5633F215E705A2F010EDE0AAC55DC2E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public MemoryInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                MemoryInfo varB2BE3C5741554A81AA92EC3CD868A516_1991605453 = (new MemoryInfo(source));
                return (MemoryInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new MemoryInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.533 -0400", hash_original_method = "15F51E1DA13C1BB1AA9F8A3C297A7987", hash_generated_method = "71F8EAEB37899DB5E931AFA0C06563F7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public MemoryInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                MemoryInfo[] var83C4D7A2FE00961CCE7E750BDC9FCD35_764094057 = (new MemoryInfo[size]);
                return (MemoryInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new MemoryInfo[size];
            }

            
}; //Transformed anonymous class
    }


    
    public static class ProcessErrorStateInfo implements Parcelable {
        public int condition;
        public String processName;
        public int pid;
        public int uid;
        public String tag;
        public String shortMsg;
        public String longMsg;
        public String stackTrace;
        public byte[] crashData = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.534 -0400", hash_original_method = "5ED73996FC5896C9F894604FFBFF8609", hash_generated_method = "3E55B7B14A298521D7B421AC3B025230")
        @DSModeled(DSC.SAFE)
        public ProcessErrorStateInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.534 -0400", hash_original_method = "94E8D1B421B7A163DD1B499E5670983F", hash_generated_method = "F273E5BE6652BE4715E720D874282CF7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private ProcessErrorStateInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.535 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.536 -0400", hash_original_method = "38EC9879A184B274D068BE64A2E942B7", hash_generated_method = "C3F40BAAF6F271C7CF93BDCF392B5E07")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(condition);
            dest.writeString(processName);
            dest.writeInt(pid);
            dest.writeInt(uid);
            dest.writeString(tag);
            dest.writeString(shortMsg);
            dest.writeString(longMsg);
            dest.writeString(stackTrace);
            // ---------- Original Method ----------
            //dest.writeInt(condition);
            //dest.writeString(processName);
            //dest.writeInt(pid);
            //dest.writeInt(uid);
            //dest.writeString(tag);
            //dest.writeString(shortMsg);
            //dest.writeString(longMsg);
            //dest.writeString(stackTrace);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.536 -0400", hash_original_method = "7EE07760084269563BF2AEE27C9085AD", hash_generated_method = "158C72204EEBB79A7CA0A65BD5B5F5E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            condition = source.readInt();
            processName = source.readString();
            pid = source.readInt();
            uid = source.readInt();
            tag = source.readString();
            shortMsg = source.readString();
            longMsg = source.readString();
            stackTrace = source.readString();
            // ---------- Original Method ----------
            //condition = source.readInt();
            //processName = source.readString();
            //pid = source.readInt();
            //uid = source.readInt();
            //tag = source.readString();
            //shortMsg = source.readString();
            //longMsg = source.readString();
            //stackTrace = source.readString();
        }

        
        public static final int NO_ERROR = 0;
        public static final int CRASHED = 1;
        public static final int NOT_RESPONDING = 2;
        public static final Creator<ProcessErrorStateInfo> CREATOR = new Creator<ProcessErrorStateInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.537 -0400", hash_original_method = "07B9A1AE51A67C5D4F0A79E60F9AF9EC", hash_generated_method = "E367C5807FFBFB3C9468A1E1C2A4E2B8")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public ProcessErrorStateInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                ProcessErrorStateInfo varC1212714070B3D1CDBB174C275966DE5_706418223 = (new ProcessErrorStateInfo(source));
                return (ProcessErrorStateInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new ProcessErrorStateInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.537 -0400", hash_original_method = "7FF60EC2BC9C16F2A15285777268F35B", hash_generated_method = "A8865CD24C3CDDDA5C1573A250E32C8C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public ProcessErrorStateInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                ProcessErrorStateInfo[] var0906007A5BC1E7A4CB322172DB1E9D50_1813412661 = (new ProcessErrorStateInfo[size]);
                return (ProcessErrorStateInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new ProcessErrorStateInfo[size];
            }

            
}; //Transformed anonymous class
    }


    
    public static class RunningAppProcessInfo implements Parcelable {
        public String processName;
        public int pid;
        public int uid;
        public String pkgList[];
        public int flags;
        public int importance;
        public int lru;
        public int importanceReasonCode;
        public int importanceReasonPid;
        public ComponentName importanceReasonComponent;
        public int importanceReasonImportance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.538 -0400", hash_original_method = "037D75A14244F6412C20718AD220CDB7", hash_generated_method = "EBA9A2537661CB41AD3E24299B24227D")
        @DSModeled(DSC.SAFE)
        public RunningAppProcessInfo() {
            importance = IMPORTANCE_FOREGROUND;
            importanceReasonCode = REASON_UNKNOWN;
            // ---------- Original Method ----------
            //importance = IMPORTANCE_FOREGROUND;
            //importanceReasonCode = REASON_UNKNOWN;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.539 -0400", hash_original_method = "09307CF5135B482F1E6BA3C6F777D6D1", hash_generated_method = "CE161B391348F130CAF1DF0CE5BA33AD")
        @DSModeled(DSC.SAFE)
        public RunningAppProcessInfo(String pProcessName, int pPid, String pArr[]) {
            dsTaint.addTaint(pPid);
            dsTaint.addTaint(pArr);
            dsTaint.addTaint(pProcessName);
            pkgList = pArr;
            // ---------- Original Method ----------
            //processName = pProcessName;
            //pid = pPid;
            //pkgList = pArr;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.539 -0400", hash_original_method = "224713C5B1CB6C52B9BDAF058DA172D4", hash_generated_method = "C97DC43E0A14FAAA38890D3B79869937")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private RunningAppProcessInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.540 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.541 -0400", hash_original_method = "DDF0D3D0D0B3E35B68DDE155F98679B3", hash_generated_method = "19D2239C9034ED4D163FB5FDB091A2F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeString(processName);
            dest.writeInt(pid);
            dest.writeInt(uid);
            dest.writeStringArray(pkgList);
            dest.writeInt(this.flags);
            dest.writeInt(importance);
            dest.writeInt(lru);
            dest.writeInt(importanceReasonCode);
            dest.writeInt(importanceReasonPid);
            ComponentName.writeToParcel(importanceReasonComponent, dest);
            dest.writeInt(importanceReasonImportance);
            // ---------- Original Method ----------
            //dest.writeString(processName);
            //dest.writeInt(pid);
            //dest.writeInt(uid);
            //dest.writeStringArray(pkgList);
            //dest.writeInt(this.flags);
            //dest.writeInt(importance);
            //dest.writeInt(lru);
            //dest.writeInt(importanceReasonCode);
            //dest.writeInt(importanceReasonPid);
            //ComponentName.writeToParcel(importanceReasonComponent, dest);
            //dest.writeInt(importanceReasonImportance);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.542 -0400", hash_original_method = "41C420DA0EF6445C06E1F94D547B6411", hash_generated_method = "B6190DE7CABF0ECD18111F7911134D98")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            processName = source.readString();
            pid = source.readInt();
            uid = source.readInt();
            pkgList = source.readStringArray();
            flags = source.readInt();
            importance = source.readInt();
            lru = source.readInt();
            importanceReasonCode = source.readInt();
            importanceReasonPid = source.readInt();
            importanceReasonComponent = ComponentName.readFromParcel(source);
            importanceReasonImportance = source.readInt();
            // ---------- Original Method ----------
            //processName = source.readString();
            //pid = source.readInt();
            //uid = source.readInt();
            //pkgList = source.readStringArray();
            //flags = source.readInt();
            //importance = source.readInt();
            //lru = source.readInt();
            //importanceReasonCode = source.readInt();
            //importanceReasonPid = source.readInt();
            //importanceReasonComponent = ComponentName.readFromParcel(source);
            //importanceReasonImportance = source.readInt();
        }

        
        public static final int FLAG_CANT_SAVE_STATE = 1<<0;
        public static final int FLAG_PERSISTENT = 1<<1;
        public static final int IMPORTANCE_FOREGROUND = 100;
        public static final int IMPORTANCE_VISIBLE = 200;
        public static final int IMPORTANCE_PERCEPTIBLE = 130;
        public static final int IMPORTANCE_CANT_SAVE_STATE = 170;
        public static final int IMPORTANCE_SERVICE = 300;
        public static final int IMPORTANCE_BACKGROUND = 400;
        public static final int IMPORTANCE_EMPTY = 500;
        public static final int REASON_UNKNOWN = 0;
        public static final int REASON_PROVIDER_IN_USE = 1;
        public static final int REASON_SERVICE_IN_USE = 2;
        public static final Creator<RunningAppProcessInfo> CREATOR = new Creator<RunningAppProcessInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.543 -0400", hash_original_method = "A770AC12CE4BE94620C93B553EEF1E54", hash_generated_method = "B3F34BAB3C9C5CFD7D858D603AF7EBD2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public RunningAppProcessInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                RunningAppProcessInfo var4535AD2F2B60AA7789F6CBC35C19BB42_243684515 = (new RunningAppProcessInfo(source));
                return (RunningAppProcessInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningAppProcessInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:34.544 -0400", hash_original_method = "D1ED3F98A48A1EB116D00D47762C4476", hash_generated_method = "A57B168D25A206570E91BCC7E7B9D34B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public RunningAppProcessInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                RunningAppProcessInfo[] var87CE275BE946E7F3E4ABD9584298A724_1785988848 = (new RunningAppProcessInfo[size]);
                return (RunningAppProcessInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningAppProcessInfo[size];
            }

            
}; //Transformed anonymous class
    }


    
    private static String TAG = "ActivityManager";
    private static boolean localLOGV = false;
    public static final int COMPAT_MODE_ALWAYS = -1;
    public static final int COMPAT_MODE_NEVER = -2;
    public static final int COMPAT_MODE_UNKNOWN = -3;
    public static final int COMPAT_MODE_DISABLED = 0;
    public static final int COMPAT_MODE_ENABLED = 1;
    public static final int COMPAT_MODE_TOGGLE = 2;
    public static final int RECENT_WITH_EXCLUDED = 0x0001;
    public static final int RECENT_IGNORE_UNAVAILABLE = 0x0002;
    public static final int REMOVE_TASK_KILL_PROCESS = 0x0001;
    public static final int MOVE_TASK_WITH_HOME = 0x00000001;
    public static final int MOVE_TASK_NO_USER_ACTION = 0x00000002;
}

