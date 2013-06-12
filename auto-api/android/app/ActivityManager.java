package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static String TAG = "ActivityManager";
    private static boolean localLOGV = false;
    private final Context mContext;
    private final Handler mHandler;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.905 -0400", hash_original_method = "5B4171109A2201F1FE14E6225146AB80", hash_generated_method = "5E16DF085F48C17E4878B4B9472FEA79")
    @DSModeled(DSC.SAFE)
     ActivityManager(Context context, Handler handler) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        mContext = context;
        mHandler = handler;
        // ---------- Original Method ----------
        //mContext = context;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.905 -0400", hash_original_method = "BCFF8F5D8C51374E31DC49464CB803A5", hash_generated_method = "61DB3FBF582B8D88D6BA49D963676847")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFrontActivityScreenCompatMode() {
        try 
        {
            int var6D57FFF049EDBBD675CB42E6E5881F63_265626937 = (ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.906 -0400", hash_original_method = "1AD781893C5FA74DDB5BF5981AAFC282", hash_generated_method = "54EFC726908A071D34C0575165BAA6E8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.906 -0400", hash_original_method = "08DE0842CE89FB88CEE40B6F1F1D5D8A", hash_generated_method = "5704C14807F884CD2A5F20B11079BFEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPackageScreenCompatMode(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            int var4970DBBC19CF020D2AB9E07CA6C5607B_794654768 = (ActivityManagerNative.getDefault().getPackageScreenCompatMode(packageName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.907 -0400", hash_original_method = "6272BC343B5B54EAA927E2C6A7A229FA", hash_generated_method = "75EC392A1DD790CF8848E9C2533C3B7C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.907 -0400", hash_original_method = "43CD4547C63AA5BA08A4BB7431262A61", hash_generated_method = "5A123E6305C7F21BAC29F5E90AB9D625")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getPackageAskScreenCompat(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            boolean var8E89A0F6D10823A8701FE5BBBD1FE149_2021169865 = (ActivityManagerNative.getDefault().getPackageAskScreenCompat(packageName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.908 -0400", hash_original_method = "3BC1D3C0234B303E106B1ACB51D8D800", hash_generated_method = "C47A7AB138486414FA021BBF68ED5C6E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.908 -0400", hash_original_method = "B7DBD08AF6CFCEAABC628A74B78E8B6F", hash_generated_method = "D07375CC19D000B93AA4F7F7D0185011")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMemoryClass() {
        int var9862DFF8105689D1FAD16F0A2A7D04D2_611345889 = (staticGetMemoryClass());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return staticGetMemoryClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.909 -0400", hash_original_method = "0BAD5E2BAC82418DEF60529619F507F9", hash_generated_method = "E5423F9463EEC9125DA27B0C5B1C0238")
    static public int staticGetMemoryClass() {
        String vmHeapSize = SystemProperties.get("dalvik.vm.heapgrowthlimit", "");
        if (vmHeapSize != null && !"".equals(vmHeapSize)) {
            return Integer.parseInt(vmHeapSize.substring(0, vmHeapSize.length()-1));
        }
        return staticGetLargeMemoryClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.909 -0400", hash_original_method = "50F084ADAAFF8EB942A9D9EB0C93D87F", hash_generated_method = "1912B5D57334FBD804BB846CBD3EF834")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLargeMemoryClass() {
        int var69D319CAE7493EBEEA5EC841CBB29C6C_946238295 = (staticGetLargeMemoryClass());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return staticGetLargeMemoryClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.910 -0400", hash_original_method = "D5DE26C76366228A47CE9C0908FBCDED", hash_generated_method = "92F5BE76FC0C65507C2A3D675D3253AE")
    static public int staticGetLargeMemoryClass() {
        String vmHeapSize = SystemProperties.get("dalvik.vm.heapsize", "16m");
        return Integer.parseInt(vmHeapSize.substring(0, vmHeapSize.length()-1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.910 -0400", hash_original_method = "439624820785E6C7317999C60D151459", hash_generated_method = "15CDE9B8F7ED0780DE8E94B76800E00D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.911 -0400", hash_original_method = "68A91D72405A4CE5DF9B72D6FF4E6DC9", hash_generated_method = "A3987591DF10460FED0F899EAEDF9991")
    static public boolean isLargeRAM() {
        MemInfoReader reader = new MemInfoReader();
        reader.readMemInfo();
        if (reader.getTotalSize() >= (640*1024*1024)) {
            return true;
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.911 -0400", hash_original_method = "F8BE7228FE8A06DB7E3F7EC0517EBE16", hash_generated_method = "DBA00792C93E16378CC9D7002BC700EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<RecentTaskInfo> getRecentTasks(int maxNum, int flags) throws SecurityException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(maxNum);
        try 
        {
            List<RecentTaskInfo> var26C34576422CD3AA6F64606A10610CD6_308827508 = (ActivityManagerNative.getDefault().getRecentTasks(maxNum,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.912 -0400", hash_original_method = "324273237D89470A473FD6EC5C103A40", hash_generated_method = "B4E22B0A78B6F693D3B4BBE327A21016")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<RunningTaskInfo> getRunningTasks(int maxNum, int flags, IThumbnailReceiver receiver) throws SecurityException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(maxNum);
        try 
        {
            List<RunningTaskInfo> varE0092079F64DEAD6D1D4101A8E7ADCD0_498844190 = (ActivityManagerNative.getDefault().getTasks(maxNum, flags, receiver));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.912 -0400", hash_original_method = "048E08D6499B0F81FA41B243F96225CE", hash_generated_method = "88F004088BAB42CF7D9AC3B35BED6D57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<RunningTaskInfo> getRunningTasks(int maxNum) throws SecurityException {
        dsTaint.addTaint(maxNum);
        List<RunningTaskInfo> var2DF5CA28CDF194C5DCBEA41663028194_1679813403 = (getRunningTasks(maxNum, 0, null));
        return (List<RunningTaskInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getRunningTasks(maxNum, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.913 -0400", hash_original_method = "06417D4703E772AA57E4535D9CA52E2C", hash_generated_method = "AD02558A0C4434D41AAA820171E7EB16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeSubTask(int taskId, int subTaskIndex) throws SecurityException {
        dsTaint.addTaint(taskId);
        dsTaint.addTaint(subTaskIndex);
        try 
        {
            boolean var07CF28A51B530B1C42F191E5697D370C_940138229 = (ActivityManagerNative.getDefault().removeSubTask(taskId, subTaskIndex));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.914 -0400", hash_original_method = "B1BB833FCE4ABF3667361FA6F055417F", hash_generated_method = "0555985E1887B6DBCC0EBCE1182AC8CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeTask(int taskId, int flags) throws SecurityException {
        dsTaint.addTaint(taskId);
        dsTaint.addTaint(flags);
        try 
        {
            boolean varE06E21935A507F8A824839E5F554648C_1497859369 = (ActivityManagerNative.getDefault().removeTask(taskId, flags));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.914 -0400", hash_original_method = "90A15739ABCD71E20C2601B2E690D2DC", hash_generated_method = "1548B62A34862E50F618F783340C9D44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TaskThumbnails getTaskThumbnails(int id) throws SecurityException {
        dsTaint.addTaint(id);
        try 
        {
            TaskThumbnails var5B632D12431BADBB3E85B2C4C0A1E560_1940772954 = (ActivityManagerNative.getDefault().getTaskThumbnails(id));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.915 -0400", hash_original_method = "68F3ECC95EA33C5EF7CED37FFBD163D9", hash_generated_method = "701BE803BB230F4C04E7AF0A29B9A106")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.915 -0400", hash_original_method = "93643A575557EDD801C5647B318BA97A", hash_generated_method = "A24E199DF16061D281D669E04E4E2B63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<RunningServiceInfo> getRunningServices(int maxNum) throws SecurityException {
        dsTaint.addTaint(maxNum);
        try 
        {
            List<RunningServiceInfo> var906A88D4420C6DBB6E72B2196F3B3C79_258798461 = (ActivityManagerNative.getDefault()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.916 -0400", hash_original_method = "3F37B5EEA2E0ADFF7012B4DB8D3BC71C", hash_generated_method = "8020AD47ECD4F3A234060D527BD6102B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PendingIntent getRunningServiceControlPanel(ComponentName service) throws SecurityException {
        dsTaint.addTaint(service.dsTaint);
        try 
        {
            PendingIntent var2B1F7394D13D9BCE30265B30D995C712_1867361335 = (ActivityManagerNative.getDefault()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.916 -0400", hash_original_method = "B6E6E4E46821E411AC60EE30A7424576", hash_generated_method = "6FE44E422478B02898DAE8837B85A078")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.917 -0400", hash_original_method = "F72074CE1B364F8B93C8BBDF31501500", hash_generated_method = "24A9A662C40FFC88181072E101ADBCB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clearApplicationUserData(String packageName, IPackageDataObserver observer) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            boolean var6850AED94B5983BF09E13F93CF984187_678564826 = (ActivityManagerNative.getDefault().clearApplicationUserData(packageName, 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.918 -0400", hash_original_method = "F53E97F522CAE83DA0CBCF957085AF2C", hash_generated_method = "98AD4ABF7153EA742A9D1229F9E211AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ProcessErrorStateInfo> getProcessesInErrorState() {
        try 
        {
            List<ProcessErrorStateInfo> var21830C4C4064299EF5EAAEF44E9533E0_1925571824 = (ActivityManagerNative.getDefault().getProcessesInErrorState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.919 -0400", hash_original_method = "5737B6241A3389A78D86162B5C5BDB02", hash_generated_method = "4EA029A4B9C6AAE499817E3A80090757")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ApplicationInfo> getRunningExternalApplications() {
        try 
        {
            List<ApplicationInfo> varA73169A7478F77D402570A5B0E1FF006_1244315380 = (ActivityManagerNative.getDefault().getRunningExternalApplications());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.920 -0400", hash_original_method = "BB41AA7EC02A452F0653300FBA1EFF8A", hash_generated_method = "D744FDB965DF4229FBEF2FA909DD76D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<RunningAppProcessInfo> getRunningAppProcesses() {
        try 
        {
            List<RunningAppProcessInfo> var8BA730091C8E2B4321BB5C84DF3EB143_511980310 = (ActivityManagerNative.getDefault().getRunningAppProcesses());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.921 -0400", hash_original_method = "BA29C29542BF4FC0E2178C81FA222823", hash_generated_method = "8148E8364A219A182ABC59E055A78CE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) {
        dsTaint.addTaint(pids);
        try 
        {
            Debug.MemoryInfo[] var72A4E7F6179FD37B2A53189E6AD76F09_1901624735 = (ActivityManagerNative.getDefault().getProcessMemoryInfo(pids));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.921 -0400", hash_original_method = "AB97F58AF8359C056EB136FA16E11328", hash_generated_method = "ECAFDBFE4C28864B624A0B1845E456FB")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void restartPackage(String packageName) {
        dsTaint.addTaint(packageName);
        killBackgroundProcesses(packageName);
        // ---------- Original Method ----------
        //killBackgroundProcesses(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.922 -0400", hash_original_method = "BAC028425422747AF2B8DB952F37E411", hash_generated_method = "691B2F1E796F266878AE038AC8F12032")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.923 -0400", hash_original_method = "F30C6D9D6BE88E1DA2EC5D39F1D44538", hash_generated_method = "DD0653A153459BA52347103C6C60AC6E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.924 -0400", hash_original_method = "002CA49339A7476A8E8EF41ECCC37BDD", hash_generated_method = "4A845FED58F72A2F3A4794C9D65406F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConfigurationInfo getDeviceConfigurationInfo() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        try 
        {
            ConfigurationInfo var9A01BB6CE6372EDF72014ACCA11C22C3_2062184400 = (ActivityManagerNative.getDefault().getDeviceConfigurationInfo());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.925 -0400", hash_original_method = "E6A8DEADBC97DC6A083D1FDDD3BF2E4E", hash_generated_method = "E721EBBA5B604F785A2231A3C81DC889")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLauncherLargeIconDensity() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final Resources res;
        res = mContext.getResources();
        final int density;
        density = res.getDisplayMetrics().densityDpi;
        {
            boolean varE01F796B7DD545CA1852C72371851054_1138987648 = ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.926 -0400", hash_original_method = "1ABECD33DDCEDD9654A62357CF29D109", hash_generated_method = "A631A0D3375D89D818A3DAFB51B92163")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLauncherLargeIconSize() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final Resources res;
        res = mContext.getResources();
        final int size;
        size = res.getDimensionPixelSize(android.R.dimen.app_icon_size);
        {
            boolean varE01F796B7DD545CA1852C72371851054_1538806873 = ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE);
        } //End collapsed parenthetic
        final int density;
        density = res.getDisplayMetrics().densityDpi;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.927 -0400", hash_original_method = "03688D49C7EA4499A5ECC87E8FAFC0E6", hash_generated_method = "1BD01B4CCE15FE5F5E68F115FFC02FD3")
    public static boolean isUserAMonkey() {
        try {
            return ActivityManagerNative.getDefault().isUserAMonkey();
        } catch (RemoteException e) {
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.928 -0400", hash_original_method = "B24CD2C7FF3B887A2D7E4705F48A60B3", hash_generated_method = "AD4C9EC03B4473759DDBFA6016BEFB25")
    public static boolean isRunningInTestHarness() {
        return SystemProperties.getBoolean("ro.test_harness", false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.929 -0400", hash_original_method = "2575FA7FD2518D90A93FBC6E066D35C1", hash_generated_method = "580248ED7A859D5E792126447576E15F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Map<String, Integer> getAllPackageLaunchCounts() {
        try 
        {
            IUsageStats usageStatsService;
            usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
            PkgUsageStats[] allPkgUsageStats;
            allPkgUsageStats = usageStatsService.getAllPkgUsageStats();
            Map<String, Integer> launchCounts;
            launchCounts = new HashMap<String, Integer>();
            {
                PkgUsageStats pkgUsageStats = allPkgUsageStats[0];
                {
                    launchCounts.put(pkgUsageStats.packageName, pkgUsageStats.launchCount);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        { }
        return (Map<String, Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.930 -0400", hash_original_method = "97D195D4FE7E8BCA1AFB9969B53F0E5E", hash_generated_method = "E660882E48619CE01ABB0023B6B769A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PkgUsageStats[] getAllPackageUsageStats() {
        try 
        {
            IUsageStats usageStatsService;
            usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
            {
                PkgUsageStats[] varBAFDD5C3196C35C285B9E383CDC82FF9_597382081 = (usageStatsService.getAllPkgUsageStats());
            } //End block
        } //End block
        catch (RemoteException e)
        { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.931 -0400", hash_original_method = "5F692D6C0F0BEC319B49459A73599D4B", hash_generated_method = "90363BC2548451917635977B5C1A3470")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean switchUser(int userid) {
        dsTaint.addTaint(userid);
        try 
        {
            boolean var2D87E0C1C61F5F6722509A3C54C5660D_1167694855 = (ActivityManagerNative.getDefault().switchUser(userid));
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
        public static final Creator<RecentTaskInfo> CREATOR = new Creator<RecentTaskInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.932 -0400", hash_original_method = "754BED839284C604C75BEECB20D1E8CF", hash_generated_method = "DCC02579F79993A1E2E031E698175299")
            @DSModeled(DSC.SAFE)
            public RecentTaskInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                return (RecentTaskInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RecentTaskInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.932 -0400", hash_original_method = "D970AC33B35E94C08348859E4EC02E6C", hash_generated_method = "9AA1D485721D59D4A8A1B418B5CA4330")
            @DSModeled(DSC.SAFE)
            public RecentTaskInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                return (RecentTaskInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RecentTaskInfo[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.933 -0400", hash_original_method = "C08B7337C6B109635FE340903513A97B", hash_generated_method = "A77170FD7E21200D87524658945CB42E")
        @DSModeled(DSC.SAFE)
        public RecentTaskInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.934 -0400", hash_original_method = "1CABC845DDD8B9A1DEC9FF64F1615AFC", hash_generated_method = "A2EEF2AF33BD2397BABD26E9F310B7B8")
        @DSModeled(DSC.SAFE)
        private RecentTaskInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.934 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.935 -0400", hash_original_method = "A024AE935060D48D15B6110668C59DDF", hash_generated_method = "B076856FDD97439DE748226FC48A9FDD")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.937 -0400", hash_original_method = "F67217ABAEC36040C8F444901EE65BC8", hash_generated_method = "9F14778692E44DCABF7E68E627B29DBA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            id = source.readInt();
            persistentId = source.readInt();
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_466642694 = (source.readInt() != 0);
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

        
    }


    
    public static class RunningTaskInfo implements Parcelable {
        public int id;
        public ComponentName baseActivity;
        public ComponentName topActivity;
        public Bitmap thumbnail;
        public CharSequence description;
        public int numActivities;
        public int numRunning;
        public static final Creator<RunningTaskInfo> CREATOR = new Creator<RunningTaskInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.938 -0400", hash_original_method = "289D74B80F1DDE34702D81134C81DC0D", hash_generated_method = "DABAE3F4D9DEC4CCFA4DC7D49A6C058A")
            @DSModeled(DSC.SAFE)
            public RunningTaskInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                return (RunningTaskInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningTaskInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.939 -0400", hash_original_method = "87B1B374C2173B951C96C3D08DE2EEAE", hash_generated_method = "17087CF1446746719445E4454574731C")
            @DSModeled(DSC.SAFE)
            public RunningTaskInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                return (RunningTaskInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningTaskInfo[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.939 -0400", hash_original_method = "6DA0A8D9CEF41C0CB91D2D95D7E71D44", hash_generated_method = "A00468204BD448D8ACF80F92CE9BBF68")
        @DSModeled(DSC.SAFE)
        public RunningTaskInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.940 -0400", hash_original_method = "A0900FA369CFAE0B339B23849E0D0E54", hash_generated_method = "D063C4E88FFBBB2C9216A404EECFDD53")
        @DSModeled(DSC.SAFE)
        private RunningTaskInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.940 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.941 -0400", hash_original_method = "224D236A6A210D9CABF5D7D423C96E97", hash_generated_method = "8146690DBD1C9A07B0517B1A3EBE5219")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.943 -0400", hash_original_method = "1A58A87C00619395DA7F7A454E1E03D5", hash_generated_method = "00EB73242DA7E4E622B51CD9E00E43C6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            id = source.readInt();
            baseActivity = ComponentName.readFromParcel(source);
            topActivity = ComponentName.readFromParcel(source);
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_683802721 = (source.readInt() != 0);
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

        
    }


    
    public static class TaskThumbnails implements Parcelable {
        public Bitmap mainThumbnail;
        public int numSubThumbbails;
        public IThumbnailRetriever retriever;
        public static final Creator<TaskThumbnails> CREATOR = new Creator<TaskThumbnails>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.943 -0400", hash_original_method = "D293F4B5B5D1E8DEC87E5785C502F4A1", hash_generated_method = "9744DBEC828453395EEB85919CF8E045")
            @DSModeled(DSC.SAFE)
            public TaskThumbnails createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                return (TaskThumbnails)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new TaskThumbnails(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.944 -0400", hash_original_method = "32482EB33A7D57DC46F839E5FD8415A1", hash_generated_method = "CE771A42006691486CED5B5138ADFEB7")
            @DSModeled(DSC.SAFE)
            public TaskThumbnails[] newArray(int size) {
                dsTaint.addTaint(size);
                return (TaskThumbnails[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new TaskThumbnails[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.944 -0400", hash_original_method = "EB2263C71F650A09D4909FB1B34C782F", hash_generated_method = "71FF6DF34EEC4EB82EB990715ACFDE79")
        @DSModeled(DSC.SAFE)
        public TaskThumbnails() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.945 -0400", hash_original_method = "0FEFA86B10CDE25FCF4328B39BD2F7D5", hash_generated_method = "F053103AC098E97D06645182B90AB5C1")
        @DSModeled(DSC.SAFE)
        private TaskThumbnails(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.945 -0400", hash_original_method = "C8A1C6791C443D43BB18F989CA6219B6", hash_generated_method = "8A676CA04AC460103BD1A63D74596F9E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bitmap getSubThumbnail(int index) {
            dsTaint.addTaint(index);
            try 
            {
                Bitmap var68E445C93AEE27D5BFCA67096C8050B5_177316707 = (retriever.getThumbnail(index));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.946 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.946 -0400", hash_original_method = "1641949793D35FD49D0AD46DB3E00603", hash_generated_method = "155C4E462E40A01C4A94D9E3B4FBE86B")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.947 -0400", hash_original_method = "19A7C144CCAE5CD51406B760DF512EA1", hash_generated_method = "E41BA7E6DB4FDF121D1DF70417C0BE6E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_931844687 = (source.readInt() != 0);
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
        public static final int FLAG_STARTED = 1<<0;
        public static final int FLAG_FOREGROUND = 1<<1;
        public static final int FLAG_SYSTEM_PROCESS = 1<<2;
        public static final int FLAG_PERSISTENT_PROCESS = 1<<3;
        public int flags;
        public String clientPackage;
        public int clientLabel;
        public static final Creator<RunningServiceInfo> CREATOR = new Creator<RunningServiceInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.948 -0400", hash_original_method = "E255B8128AC8F9856A7419AECFDCF636", hash_generated_method = "F6E55A5286C21F1A0C3BF1374BF5706F")
            @DSModeled(DSC.SAFE)
            public RunningServiceInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                return (RunningServiceInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningServiceInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.948 -0400", hash_original_method = "FD3ED620F54DFB73AA55E8F30DE37B83", hash_generated_method = "A4DA6D441AB39B84D5D5F3026E19BEB9")
            @DSModeled(DSC.SAFE)
            public RunningServiceInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                return (RunningServiceInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningServiceInfo[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.949 -0400", hash_original_method = "621426751430068D32289E518662756C", hash_generated_method = "4C034224787D515760D957854524B900")
        @DSModeled(DSC.SAFE)
        public RunningServiceInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.949 -0400", hash_original_method = "35E5A4903D7EB9EB66480EDFA6F47A72", hash_generated_method = "AD778B61C9B0F774DB06CA1C6B484A08")
        @DSModeled(DSC.SAFE)
        private RunningServiceInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.949 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.950 -0400", hash_original_method = "048D37EC670A88D2663FCC084087D5E3", hash_generated_method = "93B70A6E470CE0583BE35BE56431A3C0")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.952 -0400", hash_original_method = "264C3E4C1DAB76B38CA08CE45829A86C", hash_generated_method = "4499C325D1CD21686AC5C7C6C9007704")
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

        
    }


    
    public static class MemoryInfo implements Parcelable {
        public long availMem;
        public long threshold;
        public boolean lowMemory;
        public long hiddenAppThreshold;
        public long secondaryServerThreshold;
        public long visibleAppThreshold;
        public long foregroundAppThreshold;
        public static final Creator<MemoryInfo> CREATOR = new Creator<MemoryInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.952 -0400", hash_original_method = "83921F47BB880779DC0FD4AB57F3B1E1", hash_generated_method = "B611F41F62E50BA3B46021808792C460")
            @DSModeled(DSC.SAFE)
            public MemoryInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                return (MemoryInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new MemoryInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.953 -0400", hash_original_method = "15F51E1DA13C1BB1AA9F8A3C297A7987", hash_generated_method = "10FBEB26B0431A1763072A515665C82C")
            @DSModeled(DSC.SAFE)
            public MemoryInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                return (MemoryInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new MemoryInfo[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.953 -0400", hash_original_method = "09AE2D253AD01F5533857164DB70587D", hash_generated_method = "1B8A9DB070B9C5EE97692E3C2182BBFA")
        @DSModeled(DSC.SAFE)
        public MemoryInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.954 -0400", hash_original_method = "EAA33F4FBF3C878879D517CBC8FFA048", hash_generated_method = "45707563C7C263D0E9F46A063A1DEF08")
        @DSModeled(DSC.SAFE)
        private MemoryInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.954 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.955 -0400", hash_original_method = "F89D0A9B79191784D882D224AE236CD7", hash_generated_method = "9AF6CD2E4B7E45B3993545474614F350")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.956 -0400", hash_original_method = "63344B29322BA9906ACD5F2C274D4AFB", hash_generated_method = "FB74758E198345557EFD9E66617BDDB5")
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

        
    }


    
    public static class ProcessErrorStateInfo implements Parcelable {
        public static final int NO_ERROR = 0;
        public static final int CRASHED = 1;
        public static final int NOT_RESPONDING = 2;
        public int condition;
        public String processName;
        public int pid;
        public int uid;
        public String tag;
        public String shortMsg;
        public String longMsg;
        public String stackTrace;
        public byte[] crashData = null;
        public static final Creator<ProcessErrorStateInfo> CREATOR = new Creator<ProcessErrorStateInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.956 -0400", hash_original_method = "07B9A1AE51A67C5D4F0A79E60F9AF9EC", hash_generated_method = "FFF26AC404C680645DCCA9231C66282A")
            @DSModeled(DSC.SAFE)
            public ProcessErrorStateInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                return (ProcessErrorStateInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new ProcessErrorStateInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.957 -0400", hash_original_method = "7FF60EC2BC9C16F2A15285777268F35B", hash_generated_method = "B2937B1C1AB67CA8772DA3BEA853FBD7")
            @DSModeled(DSC.SAFE)
            public ProcessErrorStateInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                return (ProcessErrorStateInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new ProcessErrorStateInfo[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.957 -0400", hash_original_method = "5ED73996FC5896C9F894604FFBFF8609", hash_generated_method = "A00F72E13D03B2E2079D10155B143311")
        @DSModeled(DSC.SAFE)
        public ProcessErrorStateInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.957 -0400", hash_original_method = "94E8D1B421B7A163DD1B499E5670983F", hash_generated_method = "B0E7D727D1C71ED27573A113552B1D0F")
        @DSModeled(DSC.SAFE)
        private ProcessErrorStateInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.958 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.958 -0400", hash_original_method = "38EC9879A184B274D068BE64A2E942B7", hash_generated_method = "250A73FDE3E8C2741719EED82BB48057")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.959 -0400", hash_original_method = "7EE07760084269563BF2AEE27C9085AD", hash_generated_method = "7E474D7C36171DD3F7EFD0ADD9AFA121")
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

        
    }


    
    public static class RunningAppProcessInfo implements Parcelable {
        public String processName;
        public int pid;
        public int uid;
        public String pkgList[];
        public static final int FLAG_CANT_SAVE_STATE = 1<<0;
        public static final int FLAG_PERSISTENT = 1<<1;
        public int flags;
        public static final int IMPORTANCE_FOREGROUND = 100;
        public static final int IMPORTANCE_VISIBLE = 200;
        public static final int IMPORTANCE_PERCEPTIBLE = 130;
        public static final int IMPORTANCE_CANT_SAVE_STATE = 170;
        public static final int IMPORTANCE_SERVICE = 300;
        public static final int IMPORTANCE_BACKGROUND = 400;
        public static final int IMPORTANCE_EMPTY = 500;
        public int importance;
        public int lru;
        public static final int REASON_UNKNOWN = 0;
        public static final int REASON_PROVIDER_IN_USE = 1;
        public static final int REASON_SERVICE_IN_USE = 2;
        public int importanceReasonCode;
        public int importanceReasonPid;
        public ComponentName importanceReasonComponent;
        public int importanceReasonImportance;
        public static final Creator<RunningAppProcessInfo> CREATOR = new Creator<RunningAppProcessInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.960 -0400", hash_original_method = "A770AC12CE4BE94620C93B553EEF1E54", hash_generated_method = "F06BF6020A586DF4F209AC5F42DA7E89")
            @DSModeled(DSC.SAFE)
            public RunningAppProcessInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                return (RunningAppProcessInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningAppProcessInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.960 -0400", hash_original_method = "D1ED3F98A48A1EB116D00D47762C4476", hash_generated_method = "5BB5DD61478F95BE8CCCB71083B6503F")
            @DSModeled(DSC.SAFE)
            public RunningAppProcessInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                return (RunningAppProcessInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new RunningAppProcessInfo[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.961 -0400", hash_original_method = "037D75A14244F6412C20718AD220CDB7", hash_generated_method = "B773345B9DA7CD55EC5125BC59FB789A")
        @DSModeled(DSC.SAFE)
        public RunningAppProcessInfo() {
            importance = IMPORTANCE_FOREGROUND;
            importanceReasonCode = REASON_UNKNOWN;
            // ---------- Original Method ----------
            //importance = IMPORTANCE_FOREGROUND;
            //importanceReasonCode = REASON_UNKNOWN;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.961 -0400", hash_original_method = "09307CF5135B482F1E6BA3C6F777D6D1", hash_generated_method = "D50E5DF1C6A45CA8BBB780ED4556310E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.961 -0400", hash_original_method = "224713C5B1CB6C52B9BDAF058DA172D4", hash_generated_method = "8B0AB27D120A1C2461F0AAFCCA403ED5")
        @DSModeled(DSC.SAFE)
        private RunningAppProcessInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.962 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.963 -0400", hash_original_method = "DDF0D3D0D0B3E35B68DDE155F98679B3", hash_generated_method = "70FD6860C9AD11BBE04BF6E5514A9A2D")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.964 -0400", hash_original_method = "41C420DA0EF6445C06E1F94D547B6411", hash_generated_method = "5E95954FC9DD43BC8948A8F0C9F39C16")
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

        
    }


    
}


