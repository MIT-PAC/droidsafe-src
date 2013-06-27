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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.589 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.589 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.603 -0400", hash_original_method = "5B4171109A2201F1FE14E6225146AB80", hash_generated_method = "8ADD7487E2C46628C6CC7A69BA117746")
      ActivityManager(Context context, Handler handler) {
        mContext = context;
        mHandler = handler;
        // ---------- Original Method ----------
        //mContext = context;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.622 -0400", hash_original_method = "BCFF8F5D8C51374E31DC49464CB803A5", hash_generated_method = "B04118BBF4CBA2F0E6AF9CBF4172A219")
    public int getFrontActivityScreenCompatMode() {
        try 
        {
            int var6D57FFF049EDBBD675CB42E6E5881F63_524731698 = (ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode());
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365639198 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365639198;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.624 -0400", hash_original_method = "1AD781893C5FA74DDB5BF5981AAFC282", hash_generated_method = "45A9A05AC09544DC3BCAA5225B37664D")
    public void setFrontActivityScreenCompatMode(int mode) {
        try 
        {
            ActivityManagerNative.getDefault().setFrontActivityScreenCompatMode(mode);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(mode);
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setFrontActivityScreenCompatMode(mode);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.642 -0400", hash_original_method = "08DE0842CE89FB88CEE40B6F1F1D5D8A", hash_generated_method = "29DE93C1034FF23E3B74BDB5A7D7BA39")
    public int getPackageScreenCompatMode(String packageName) {
        try 
        {
            int var4970DBBC19CF020D2AB9E07CA6C5607B_1375806072 = (ActivityManagerNative.getDefault().getPackageScreenCompatMode(packageName));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1002920008 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1002920008;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getPackageScreenCompatMode(packageName);
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.659 -0400", hash_original_method = "6272BC343B5B54EAA927E2C6A7A229FA", hash_generated_method = "F7868BA9DC961380C8CFFDB247A2B274")
    public void setPackageScreenCompatMode(String packageName, int mode) {
        try 
        {
            ActivityManagerNative.getDefault().setPackageScreenCompatMode(packageName, mode);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setPackageScreenCompatMode(packageName, mode);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.662 -0400", hash_original_method = "43CD4547C63AA5BA08A4BB7431262A61", hash_generated_method = "E3EC04968EDA0FE5B0E64E35B39BB242")
    public boolean getPackageAskScreenCompat(String packageName) {
        try 
        {
            boolean var8E89A0F6D10823A8701FE5BBBD1FE149_1651682156 = (ActivityManagerNative.getDefault().getPackageAskScreenCompat(packageName));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071126183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071126183;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getPackageAskScreenCompat(packageName);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.668 -0400", hash_original_method = "3BC1D3C0234B303E106B1ACB51D8D800", hash_generated_method = "5F1A65070AAEF92A55E16D6A3AD742E6")
    public void setPackageAskScreenCompat(String packageName, boolean ask) {
        try 
        {
            ActivityManagerNative.getDefault().setPackageAskScreenCompat(packageName, ask);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(ask);
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setPackageAskScreenCompat(packageName, ask);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.670 -0400", hash_original_method = "B7DBD08AF6CFCEAABC628A74B78E8B6F", hash_generated_method = "0EADC5F5ABF5D975EC8E3102A4F25C5F")
    public int getMemoryClass() {
        int var9862DFF8105689D1FAD16F0A2A7D04D2_290370118 = (staticGetMemoryClass());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1389802538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1389802538;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.692 -0400", hash_original_method = "50F084ADAAFF8EB942A9D9EB0C93D87F", hash_generated_method = "E505BFF7722DEE7DB957732B464913BC")
    public int getLargeMemoryClass() {
        int var69D319CAE7493EBEEA5EC841CBB29C6C_755116134 = (staticGetLargeMemoryClass());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051630810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051630810;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.721 -0400", hash_original_method = "F8BE7228FE8A06DB7E3F7EC0517EBE16", hash_generated_method = "EF302C19EAD363C392BB756F4B8440F6")
    public List<RecentTaskInfo> getRecentTasks(int maxNum, int flags) throws SecurityException {
        List<RecentTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_1090269124 = null; //Variable for return #1
        List<RecentTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_1522818255 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1090269124 = ActivityManagerNative.getDefault().getRecentTasks(maxNum,
                    flags);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1522818255 = null;
        } //End block
        addTaint(maxNum);
        addTaint(flags);
        List<RecentTaskInfo> varA7E53CE21691AB073D9660D615818899_1001999839; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1001999839 = varB4EAC82CA7396A68D541C85D26508E83_1090269124;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1001999839 = varB4EAC82CA7396A68D541C85D26508E83_1522818255;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1001999839.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1001999839;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getRecentTasks(maxNum,
                    //flags);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.738 -0400", hash_original_method = "324273237D89470A473FD6EC5C103A40", hash_generated_method = "63ECAB902E3F00C82A84952F11DBF309")
    public List<RunningTaskInfo> getRunningTasks(int maxNum, int flags, IThumbnailReceiver receiver) throws SecurityException {
        List<RunningTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_1117740531 = null; //Variable for return #1
        List<RunningTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_1428180331 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1117740531 = ActivityManagerNative.getDefault().getTasks(maxNum, flags, receiver);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1428180331 = null;
        } //End block
        addTaint(maxNum);
        addTaint(flags);
        addTaint(receiver.getTaint());
        List<RunningTaskInfo> varA7E53CE21691AB073D9660D615818899_735522763; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_735522763 = varB4EAC82CA7396A68D541C85D26508E83_1117740531;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_735522763 = varB4EAC82CA7396A68D541C85D26508E83_1428180331;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_735522763.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_735522763;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getTasks(maxNum, flags, receiver);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.747 -0400", hash_original_method = "048E08D6499B0F81FA41B243F96225CE", hash_generated_method = "00D808905D3A40FA6FE1DFDFE728DD29")
    public List<RunningTaskInfo> getRunningTasks(int maxNum) throws SecurityException {
        List<RunningTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_1909217336 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1909217336 = getRunningTasks(maxNum, 0, null);
        addTaint(maxNum);
        varB4EAC82CA7396A68D541C85D26508E83_1909217336.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1909217336;
        // ---------- Original Method ----------
        //return getRunningTasks(maxNum, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.763 -0400", hash_original_method = "06417D4703E772AA57E4535D9CA52E2C", hash_generated_method = "4B35548FBE91E2D23BC30624FD40768A")
    public boolean removeSubTask(int taskId, int subTaskIndex) throws SecurityException {
        try 
        {
            boolean var07CF28A51B530B1C42F191E5697D370C_1341555533 = (ActivityManagerNative.getDefault().removeSubTask(taskId, subTaskIndex));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(taskId);
        addTaint(subTaskIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_478401795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_478401795;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().removeSubTask(taskId, subTaskIndex);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.776 -0400", hash_original_method = "B1BB833FCE4ABF3667361FA6F055417F", hash_generated_method = "599C848BF95A3EE95F685B04D7C6D1FA")
    public boolean removeTask(int taskId, int flags) throws SecurityException {
        try 
        {
            boolean varE06E21935A507F8A824839E5F554648C_807275501 = (ActivityManagerNative.getDefault().removeTask(taskId, flags));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(taskId);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2093472727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2093472727;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().removeTask(taskId, flags);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.800 -0400", hash_original_method = "90A15739ABCD71E20C2601B2E690D2DC", hash_generated_method = "A363CA22B411D1371C2C755BEAA3F826")
    public TaskThumbnails getTaskThumbnails(int id) throws SecurityException {
        TaskThumbnails varB4EAC82CA7396A68D541C85D26508E83_607048371 = null; //Variable for return #1
        TaskThumbnails varB4EAC82CA7396A68D541C85D26508E83_143086999 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_607048371 = ActivityManagerNative.getDefault().getTaskThumbnails(id);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_143086999 = null;
        } //End block
        addTaint(id);
        TaskThumbnails varA7E53CE21691AB073D9660D615818899_1014192317; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1014192317 = varB4EAC82CA7396A68D541C85D26508E83_607048371;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1014192317 = varB4EAC82CA7396A68D541C85D26508E83_143086999;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1014192317.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1014192317;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getTaskThumbnails(id);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.816 -0400", hash_original_method = "68F3ECC95EA33C5EF7CED37FFBD163D9", hash_generated_method = "3817E9D5930F1E27CA1C1C30435A6CAE")
    public void moveTaskToFront(int taskId, int flags) {
        try 
        {
            ActivityManagerNative.getDefault().moveTaskToFront(taskId, flags);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(taskId);
        addTaint(flags);
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().moveTaskToFront(taskId, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.832 -0400", hash_original_method = "93643A575557EDD801C5647B318BA97A", hash_generated_method = "3C783E794B3CE015890F97C021002EED")
    public List<RunningServiceInfo> getRunningServices(int maxNum) throws SecurityException {
        List<RunningServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_1934288683 = null; //Variable for return #1
        List<RunningServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_2083678770 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1934288683 = ActivityManagerNative.getDefault()
                    .getServices(maxNum, 0);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2083678770 = null;
        } //End block
        addTaint(maxNum);
        List<RunningServiceInfo> varA7E53CE21691AB073D9660D615818899_654752449; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_654752449 = varB4EAC82CA7396A68D541C85D26508E83_1934288683;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_654752449 = varB4EAC82CA7396A68D541C85D26508E83_2083678770;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_654752449.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_654752449;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                    //.getServices(maxNum, 0);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.880 -0400", hash_original_method = "3F37B5EEA2E0ADFF7012B4DB8D3BC71C", hash_generated_method = "8034EB98490DC85A2CF3DD660573A73B")
    public PendingIntent getRunningServiceControlPanel(ComponentName service) throws SecurityException {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_962449794 = null; //Variable for return #1
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_412526593 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_962449794 = ActivityManagerNative.getDefault()
                    .getRunningServiceControlPanel(service);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_412526593 = null;
        } //End block
        addTaint(service.getTaint());
        PendingIntent varA7E53CE21691AB073D9660D615818899_1466048625; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1466048625 = varB4EAC82CA7396A68D541C85D26508E83_962449794;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1466048625 = varB4EAC82CA7396A68D541C85D26508E83_412526593;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1466048625.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1466048625;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                    //.getRunningServiceControlPanel(service);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.882 -0400", hash_original_method = "B6E6E4E46821E411AC60EE30A7424576", hash_generated_method = "D9A0C6359BA0CC2573E3A02B9F1C0C85")
    public void getMemoryInfo(MemoryInfo outInfo) {
        try 
        {
            ActivityManagerNative.getDefault().getMemoryInfo(outInfo);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(outInfo.getTaint());
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().getMemoryInfo(outInfo);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.894 -0400", hash_original_method = "F72074CE1B364F8B93C8BBDF31501500", hash_generated_method = "8974866C08AC3F561D36B526EF754A05")
    public boolean clearApplicationUserData(String packageName, IPackageDataObserver observer) {
        try 
        {
            boolean var6850AED94B5983BF09E13F93CF984187_1618016252 = (ActivityManagerNative.getDefault().clearApplicationUserData(packageName, 
                    observer));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934784182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_934784182;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().clearApplicationUserData(packageName, 
                    //observer);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.911 -0400", hash_original_method = "F53E97F522CAE83DA0CBCF957085AF2C", hash_generated_method = "8D00D019FF21F36A2862C231CCEF9775")
    public List<ProcessErrorStateInfo> getProcessesInErrorState() {
        List<ProcessErrorStateInfo> varB4EAC82CA7396A68D541C85D26508E83_628641120 = null; //Variable for return #1
        List<ProcessErrorStateInfo> varB4EAC82CA7396A68D541C85D26508E83_1783714017 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_628641120 = ActivityManagerNative.getDefault().getProcessesInErrorState();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1783714017 = null;
        } //End block
        List<ProcessErrorStateInfo> varA7E53CE21691AB073D9660D615818899_1346586704; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1346586704 = varB4EAC82CA7396A68D541C85D26508E83_628641120;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1346586704 = varB4EAC82CA7396A68D541C85D26508E83_1783714017;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1346586704.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1346586704;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getProcessesInErrorState();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.916 -0400", hash_original_method = "5737B6241A3389A78D86162B5C5BDB02", hash_generated_method = "DBD664BEA0819A3F085A05F94DCFF70A")
    public List<ApplicationInfo> getRunningExternalApplications() {
        List<ApplicationInfo> varB4EAC82CA7396A68D541C85D26508E83_405084628 = null; //Variable for return #1
        List<ApplicationInfo> varB4EAC82CA7396A68D541C85D26508E83_790128382 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_405084628 = ActivityManagerNative.getDefault().getRunningExternalApplications();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_790128382 = null;
        } //End block
        List<ApplicationInfo> varA7E53CE21691AB073D9660D615818899_1329448492; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1329448492 = varB4EAC82CA7396A68D541C85D26508E83_405084628;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1329448492 = varB4EAC82CA7396A68D541C85D26508E83_790128382;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1329448492.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1329448492;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getRunningExternalApplications();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.936 -0400", hash_original_method = "BB41AA7EC02A452F0653300FBA1EFF8A", hash_generated_method = "BD0A27EE231509D2817F162BC30258D4")
    public List<RunningAppProcessInfo> getRunningAppProcesses() {
        List<RunningAppProcessInfo> varB4EAC82CA7396A68D541C85D26508E83_1081233380 = null; //Variable for return #1
        List<RunningAppProcessInfo> varB4EAC82CA7396A68D541C85D26508E83_1228208061 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1081233380 = ActivityManagerNative.getDefault().getRunningAppProcesses();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1228208061 = null;
        } //End block
        List<RunningAppProcessInfo> varA7E53CE21691AB073D9660D615818899_1725092202; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1725092202 = varB4EAC82CA7396A68D541C85D26508E83_1081233380;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1725092202 = varB4EAC82CA7396A68D541C85D26508E83_1228208061;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1725092202.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1725092202;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getRunningAppProcesses();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.953 -0400", hash_original_method = "BA29C29542BF4FC0E2178C81FA222823", hash_generated_method = "CB740DD91528BB7ED834F496584C02D7")
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) {
        Debug.MemoryInfo[] varB4EAC82CA7396A68D541C85D26508E83_910468162 = null; //Variable for return #1
        Debug.MemoryInfo[] varB4EAC82CA7396A68D541C85D26508E83_182528460 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_910468162 = ActivityManagerNative.getDefault().getProcessMemoryInfo(pids);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_182528460 = null;
        } //End block
        addTaint(pids[0]);
        Debug.MemoryInfo[] varA7E53CE21691AB073D9660D615818899_1184894604; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1184894604 = varB4EAC82CA7396A68D541C85D26508E83_910468162;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1184894604 = varB4EAC82CA7396A68D541C85D26508E83_182528460;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1184894604.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1184894604;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getProcessMemoryInfo(pids);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.972 -0400", hash_original_method = "AB97F58AF8359C056EB136FA16E11328", hash_generated_method = "A84F25691E8C63A8F8ADC70FCC60AA45")
    @Deprecated
    public void restartPackage(String packageName) {
        killBackgroundProcesses(packageName);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
        //killBackgroundProcesses(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.986 -0400", hash_original_method = "BAC028425422747AF2B8DB952F37E411", hash_generated_method = "A4DCAD0F3AEED91C85AE580BF5DA9D0D")
    public void killBackgroundProcesses(String packageName) {
        try 
        {
            ActivityManagerNative.getDefault().killBackgroundProcesses(packageName);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().killBackgroundProcesses(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:39.988 -0400", hash_original_method = "F30C6D9D6BE88E1DA2EC5D39F1D44538", hash_generated_method = "8DE82AE1790A9B608CDC0CA6AF645768")
    public void forceStopPackage(String packageName) {
        try 
        {
            ActivityManagerNative.getDefault().forceStopPackage(packageName);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().forceStopPackage(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.007 -0400", hash_original_method = "002CA49339A7476A8E8EF41ECCC37BDD", hash_generated_method = "62C5E890F39D89EE685006E714AE8589")
    public ConfigurationInfo getDeviceConfigurationInfo() {
        ConfigurationInfo varB4EAC82CA7396A68D541C85D26508E83_430253106 = null; //Variable for return #1
        ConfigurationInfo varB4EAC82CA7396A68D541C85D26508E83_1304990142 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_430253106 = ActivityManagerNative.getDefault().getDeviceConfigurationInfo();
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1304990142 = null;
        ConfigurationInfo varA7E53CE21691AB073D9660D615818899_1719755608; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1719755608 = varB4EAC82CA7396A68D541C85D26508E83_430253106;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1719755608 = varB4EAC82CA7396A68D541C85D26508E83_1304990142;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1719755608.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1719755608;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getDeviceConfigurationInfo();
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.027 -0400", hash_original_method = "E6A8DEADBC97DC6A083D1FDDD3BF2E4E", hash_generated_method = "ED855A1AC46F23BE19F19ED078312278")
    public int getLauncherLargeIconDensity() {
        Resources res;
        res = mContext.getResources();
        int density;
        density = res.getDisplayMetrics().densityDpi;
        {
            boolean varE01F796B7DD545CA1852C72371851054_2119325199 = ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE);
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542255926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542255926;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.036 -0400", hash_original_method = "1ABECD33DDCEDD9654A62357CF29D109", hash_generated_method = "5AD01A840593E9806F371C08C769CE32")
    public int getLauncherLargeIconSize() {
        Resources res;
        res = mContext.getResources();
        int size;
        size = res.getDimensionPixelSize(android.R.dimen.app_icon_size);
        {
            boolean varE01F796B7DD545CA1852C72371851054_1786458258 = ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE);
        } //End collapsed parenthetic
        int density;
        density = res.getDisplayMetrics().densityDpi;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1818983668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1818983668;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.196 -0400", hash_original_method = "2575FA7FD2518D90A93FBC6E066D35C1", hash_generated_method = "81C06201AC6E5010A7FD105C1E83B7AC")
    public Map<String, Integer> getAllPackageLaunchCounts() {
        Map<String, Integer> varB4EAC82CA7396A68D541C85D26508E83_1536185650 = null; //Variable for return #1
        Map<String, Integer> varB4EAC82CA7396A68D541C85D26508E83_112190957 = null; //Variable for return #2
        Map<String, Integer> varB4EAC82CA7396A68D541C85D26508E83_1257369091 = null; //Variable for return #3
        Map<String, Integer> varB4EAC82CA7396A68D541C85D26508E83_518505529 = null; //Variable for return #4
        try 
        {
            IUsageStats usageStatsService;
            usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1536185650 = new HashMap<String, Integer>();
            } //End block
            PkgUsageStats[] allPkgUsageStats;
            allPkgUsageStats = usageStatsService.getAllPkgUsageStats();
            {
                varB4EAC82CA7396A68D541C85D26508E83_112190957 = new HashMap<String, Integer>();
            } //End block
            Map<String, Integer> launchCounts;
            launchCounts = new HashMap<String, Integer>();
            {
                Iterator<PkgUsageStats> varBE58BF7E38EBDF2D969BE0FA0EE8F65D_774375847 = (allPkgUsageStats).iterator();
                varBE58BF7E38EBDF2D969BE0FA0EE8F65D_774375847.hasNext();
                PkgUsageStats pkgUsageStats = varBE58BF7E38EBDF2D969BE0FA0EE8F65D_774375847.next();
                {
                    launchCounts.put(pkgUsageStats.packageName, pkgUsageStats.launchCount);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1257369091 = launchCounts;
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_518505529 = new HashMap<String, Integer>();
        } //End block
        Map<String, Integer> varA7E53CE21691AB073D9660D615818899_1658309039; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1658309039 = varB4EAC82CA7396A68D541C85D26508E83_1536185650;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1658309039 = varB4EAC82CA7396A68D541C85D26508E83_112190957;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1658309039 = varB4EAC82CA7396A68D541C85D26508E83_1257369091;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1658309039 = varB4EAC82CA7396A68D541C85D26508E83_518505529;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1658309039.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1658309039;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.218 -0400", hash_original_method = "97D195D4FE7E8BCA1AFB9969B53F0E5E", hash_generated_method = "E9EF6EF6183CCDC95DDBC0B9A20FCE76")
    public PkgUsageStats[] getAllPackageUsageStats() {
        PkgUsageStats[] varB4EAC82CA7396A68D541C85D26508E83_185161677 = null; //Variable for return #1
        PkgUsageStats[] varB4EAC82CA7396A68D541C85D26508E83_136645108 = null; //Variable for return #2
        try 
        {
            IUsageStats usageStatsService;
            usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_185161677 = usageStatsService.getAllPkgUsageStats();
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_136645108 = new PkgUsageStats[0];
        PkgUsageStats[] varA7E53CE21691AB073D9660D615818899_716582989; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_716582989 = varB4EAC82CA7396A68D541C85D26508E83_185161677;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_716582989 = varB4EAC82CA7396A68D541C85D26508E83_136645108;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_716582989.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_716582989;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.247 -0400", hash_original_method = "5F692D6C0F0BEC319B49459A73599D4B", hash_generated_method = "CD3636B4DCD4C9BCC8C548423218C8FF")
    public boolean switchUser(int userid) {
        try 
        {
            boolean var2D87E0C1C61F5F6722509A3C54C5660D_679363197 = (ActivityManagerNative.getDefault().switchUser(userid));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(userid);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16268911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16268911;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().switchUser(userid);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    public static class RecentTaskInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.249 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.249 -0400", hash_original_field = "4C2CDFF3CA319DD68A3483A4CF59EA28", hash_generated_field = "45FD448AF1C8BBB4AAEF0A2F3C76D8D5")

        public int persistentId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.249 -0400", hash_original_field = "5516160C4AFEB3607228EDA7CF505DA4", hash_generated_field = "19F03161095B5D5B4369A44839D909E6")

        public Intent baseIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.250 -0400", hash_original_field = "50B95CD9B73499236EB8892142F4BF6E", hash_generated_field = "33781CF46949A55BB10919B7C8D1FCE2")

        public ComponentName origActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.257 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "D2E00B0C52A0AFC2C3ECD84ACC639853")

        public CharSequence description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.259 -0400", hash_original_method = "C08B7337C6B109635FE340903513A97B", hash_generated_method = "3151CC50C901E54C1039F8A4558613C1")
        public  RecentTaskInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.260 -0400", hash_original_method = "1CABC845DDD8B9A1DEC9FF64F1615AFC", hash_generated_method = "6343DA72E3031300D8C1A124BFDF2490")
        private  RecentTaskInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.262 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "629887221E5C17C2E2B44B1BDB912F51")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149246350 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149246350;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.280 -0400", hash_original_method = "A024AE935060D48D15B6110668C59DDF", hash_generated_method = "0BF19E261D38CC388BB62C5E1402C04B")
        public void writeToParcel(Parcel dest, int flags) {
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
            addTaint(dest.getTaint());
            addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.306 -0400", hash_original_method = "F67217ABAEC36040C8F444901EE65BC8", hash_generated_method = "A300F18BBE8D3ECE5ADE0CAB93BD061E")
        public void readFromParcel(Parcel source) {
            id = source.readInt();
            persistentId = source.readInt();
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_1515923061 = (source.readInt() != 0);
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.307 -0400", hash_original_field = "DA99927A07743B1B8E96157497F59A82", hash_generated_field = "144243CA012A4B8ABF03F2F1B5702AF7")

        public static final Creator<RecentTaskInfo> CREATOR
                = new Creator<RecentTaskInfo>() {
            public RecentTaskInfo createFromParcel(Parcel source) {
                return new RecentTaskInfo(source);
            }
            public RecentTaskInfo[] newArray(int size) {
                return new RecentTaskInfo[size];
            }
        };
    }


    
    public static class RunningTaskInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.324 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.325 -0400", hash_original_field = "F6CEE472EAA2684591EBF9247DDF7CD8", hash_generated_field = "706934E85A3C10660FC2C5B7806ED0A6")

        public ComponentName baseActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.325 -0400", hash_original_field = "754F1F12013FFC78FF843281317AD0A9", hash_generated_field = "E1E2B3D4624F0E478C8CD581F117A622")

        public ComponentName topActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.348 -0400", hash_original_field = "951D4DFF3C22E9FCC4A2707009F45EA8", hash_generated_field = "78966E97EF5212F19E857E6A323EA39E")

        public Bitmap thumbnail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.349 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "D2E00B0C52A0AFC2C3ECD84ACC639853")

        public CharSequence description;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.349 -0400", hash_original_field = "94FBBA8E700FC03C18CC3D15C947FAE5", hash_generated_field = "4C423F6359C67873078893E7E4F87908")

        public int numActivities;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.349 -0400", hash_original_field = "8C7843D564F548CECBC331DDEA9E6A6F", hash_generated_field = "76E787CD7EF42C186801DE136C1FAB80")

        public int numRunning;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.374 -0400", hash_original_method = "6DA0A8D9CEF41C0CB91D2D95D7E71D44", hash_generated_method = "00FB201893D0BF493904CEE004049E1E")
        public  RunningTaskInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.375 -0400", hash_original_method = "A0900FA369CFAE0B339B23849E0D0E54", hash_generated_method = "8E4FFC44DACDCC9CBA26262278C4D8E8")
        private  RunningTaskInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.383 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "22416674D3AA586ABAAD6C416EC86373")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038418532 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038418532;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.401 -0400", hash_original_method = "224D236A6A210D9CABF5D7D423C96E97", hash_generated_method = "1D016E9D5230848064157F30570EF06A")
        public void writeToParcel(Parcel dest, int flags) {
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
            addTaint(dest.getTaint());
            addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.412 -0400", hash_original_method = "1A58A87C00619395DA7F7A454E1E03D5", hash_generated_method = "5A9A9189CDFF23C9EFA8B2B5A817D481")
        public void readFromParcel(Parcel source) {
            id = source.readInt();
            baseActivity = ComponentName.readFromParcel(source);
            topActivity = ComponentName.readFromParcel(source);
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_315078159 = (source.readInt() != 0);
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.414 -0400", hash_original_field = "B9911C96575F25BA7EB7A3422AE8B6F1", hash_generated_field = "8DCFCF5E1FAAD8B612615CB5CB186FEC")

        public static final Creator<RunningTaskInfo> CREATOR = new Creator<RunningTaskInfo>() {
            public RunningTaskInfo createFromParcel(Parcel source) {
                return new RunningTaskInfo(source);
            }
            public RunningTaskInfo[] newArray(int size) {
                return new RunningTaskInfo[size];
            }
        };
    }


    
    public static class TaskThumbnails implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.426 -0400", hash_original_field = "A04B656670F0FC97E22C1CDFD7F3E1C2", hash_generated_field = "5F56FA9AC5C1789807151046ACFA6F30")

        public Bitmap mainThumbnail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.427 -0400", hash_original_field = "E8B61C2BAEABE799CF0E0D2E9C2E9DBA", hash_generated_field = "B493724A74ED3FB14A03B4D585258CEB")

        public int numSubThumbbails;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.427 -0400", hash_original_field = "36DDD37AE3EA18F3B624E48455871F81", hash_generated_field = "F26B03B078059BC2048093DDC93DD417")

        public IThumbnailRetriever retriever;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.445 -0400", hash_original_method = "EB2263C71F650A09D4909FB1B34C782F", hash_generated_method = "1036CA739667021DAECAC8857E8C6B4B")
        public  TaskThumbnails() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.447 -0400", hash_original_method = "0FEFA86B10CDE25FCF4328B39BD2F7D5", hash_generated_method = "EAA1C3B2F4AD40A92EF4EAF706A12906")
        private  TaskThumbnails(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.478 -0400", hash_original_method = "C8A1C6791C443D43BB18F989CA6219B6", hash_generated_method = "18396C94DAF93534FDF859B6E05184E8")
        public Bitmap getSubThumbnail(int index) {
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_336537110 = null; //Variable for return #1
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_482186605 = null; //Variable for return #2
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_336537110 = retriever.getThumbnail(index);
            } //End block
            catch (RemoteException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_482186605 = null;
            } //End block
            addTaint(index);
            Bitmap varA7E53CE21691AB073D9660D615818899_1686347681; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1686347681 = varB4EAC82CA7396A68D541C85D26508E83_336537110;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1686347681 = varB4EAC82CA7396A68D541C85D26508E83_482186605;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1686347681.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1686347681;
            // ---------- Original Method ----------
            //try {
                //return retriever.getThumbnail(index);
            //} catch (RemoteException e) {
                //return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.493 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "897BCB4EC9A2AAD30547418361DD2664")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660576414 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660576414;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.506 -0400", hash_original_method = "1641949793D35FD49D0AD46DB3E00603", hash_generated_method = "6AB7CF3EB39990DAB269010FEE23B929")
        public void writeToParcel(Parcel dest, int flags) {
            {
                dest.writeInt(1);
                mainThumbnail.writeToParcel(dest, 0);
            } //End block
            {
                dest.writeInt(0);
            } //End block
            dest.writeInt(numSubThumbbails);
            dest.writeStrongInterface(retriever);
            addTaint(dest.getTaint());
            addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.522 -0400", hash_original_method = "19A7C144CCAE5CD51406B760DF512EA1", hash_generated_method = "3286096E156ABAC4885E7D993C4D69C5")
        public void readFromParcel(Parcel source) {
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_395353855 = (source.readInt() != 0);
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.532 -0400", hash_original_field = "4F6854EC28C10C68ABB672C395CA9C17", hash_generated_field = "A7CA2C3264BCA3B8EB9304642C9D25D2")

        public static final Creator<TaskThumbnails> CREATOR = new Creator<TaskThumbnails>() {
            public TaskThumbnails createFromParcel(Parcel source) {
                return new TaskThumbnails(source);
            }
            public TaskThumbnails[] newArray(int size) {
                return new TaskThumbnails[size];
            }
        };
    }


    
    public static class RunningServiceInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.533 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "7437D6C257B93451B3453DAF54B89FA5")

        public ComponentName service;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.533 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.542 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.542 -0400", hash_original_field = "5075140835D0BC504791C76B04C33D2B", hash_generated_field = "5CB999C89045E47AAA039EC43EA8EFD0")

        public String process;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.542 -0400", hash_original_field = "0FA009A743944A032EB54727ACEC48D6", hash_generated_field = "C92541C3D7058FCBBE46B97331B1DC61")

        public boolean foreground;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.543 -0400", hash_original_field = "2D46EB4EB6B83A1C450824B45B32C27A", hash_generated_field = "97CA36905CF396E537D491E932056860")

        public long activeSince;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.559 -0400", hash_original_field = "3BEBB2F89180B03FA5AE736665F648D9", hash_generated_field = "C0D67C1D1506D281491B9E92F436947F")

        public boolean started;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.560 -0400", hash_original_field = "CBA189F1D71714C066EA167B8A6AB3F5", hash_generated_field = "D21158F500DD41CD27566BC52C1CC2A3")

        public int clientCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.560 -0400", hash_original_field = "FCE2B0B390C578D2C38F670A9DD71E31", hash_generated_field = "14132D33689AF670E5EB24E340EA0A1A")

        public int crashCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.570 -0400", hash_original_field = "56991C1B63E5D7315D12B164F548278C", hash_generated_field = "126A413BC4E906D9E97E7626D6F4396F")

        public long lastActivityTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.571 -0400", hash_original_field = "A96E39B0C2CE86E83FEC80D073185ED0", hash_generated_field = "86B8197832B5D22734B4FAA009117212")

        public long restarting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.571 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

        public int flags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.583 -0400", hash_original_field = "9C3D569D866B7814BCD25623021A8F08", hash_generated_field = "EB1A871976ECAE165274E12319BA7914")

        public String clientPackage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.584 -0400", hash_original_field = "079D8F063684CAF3DDEEC8873031178D", hash_generated_field = "E322FF71A4FA039913D2A08C5BB78D14")

        public int clientLabel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.596 -0400", hash_original_method = "621426751430068D32289E518662756C", hash_generated_method = "822CEFC1BD8FA9077CAB00884D317765")
        public  RunningServiceInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.641 -0400", hash_original_method = "35E5A4903D7EB9EB66480EDFA6F47A72", hash_generated_method = "A40622EFC2B889119ECB5BC3A2E83D61")
        private  RunningServiceInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.642 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "AC01F08304D60D7F5435126C9B983838")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34855376 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34855376;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.651 -0400", hash_original_method = "048D37EC670A88D2663FCC084087D5E3", hash_generated_method = "E41679A34EC2E47A5E6D1587C1ADFE22")
        public void writeToParcel(Parcel dest, int flags) {
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
            addTaint(dest.getTaint());
            addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.683 -0400", hash_original_method = "264C3E4C1DAB76B38CA08CE45829A86C", hash_generated_method = "DD78297D77B49BEF3DC4CE1566C885A4")
        public void readFromParcel(Parcel source) {
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.684 -0400", hash_original_field = "6D9DB860035C68DDD8F2027972602A14", hash_generated_field = "C5EE28BB616EBCBE67B4A8F8CA4F4F8C")

        public static final int FLAG_STARTED = 1<<0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.685 -0400", hash_original_field = "D87893D0147F0F1E098475CAC202BBF2", hash_generated_field = "829940B23BDE846C789CE2452F9F2213")

        public static final int FLAG_FOREGROUND = 1<<1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.685 -0400", hash_original_field = "5B5C76863E4B1F71B19824790CDBF7E5", hash_generated_field = "A8B50094DCEC06B9ED9EBA4201DB4EF0")

        public static final int FLAG_SYSTEM_PROCESS = 1<<2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.698 -0400", hash_original_field = "888DD4FCC0586AC0A3A963599166EC86", hash_generated_field = "BA474CA4A54C5FFAAAC838F19039B567")

        public static final int FLAG_PERSISTENT_PROCESS = 1<<3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.698 -0400", hash_original_field = "AD64936DA7390A375DCEFDC8BEB2A286", hash_generated_field = "45AB20E66E709306D076BBEB8007B79C")

        public static final Creator<RunningServiceInfo> CREATOR = new Creator<RunningServiceInfo>() {
            public RunningServiceInfo createFromParcel(Parcel source) {
                return new RunningServiceInfo(source);
            }
            public RunningServiceInfo[] newArray(int size) {
                return new RunningServiceInfo[size];
            }
        };
    }


    
    public static class MemoryInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.855 -0400", hash_original_field = "A881BE324808EBD1B87AA2B1BA15C73F", hash_generated_field = "E0A63B0ECBFDEA27BFA2BB9F80EC4972")

        public long availMem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.856 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "3AD4922D5CDF05DAE16A9D0357EE49D4")

        public long threshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.857 -0400", hash_original_field = "6EE91D8EF2E43AB5F55BD97D16635869", hash_generated_field = "89F0C9AF19D837FDB8D1580447013400")

        public boolean lowMemory;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.857 -0400", hash_original_field = "EB795083CACED746E6838A97949112F7", hash_generated_field = "47547EF5278B9404AA6B7A5D0AA184CF")

        public long hiddenAppThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.858 -0400", hash_original_field = "1366179F43BE6174CFADE53A285608CC", hash_generated_field = "FAF5E05BB790D37C3A76457DA8B44C8A")

        public long secondaryServerThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.859 -0400", hash_original_field = "CF68EA128EB80A4FBFF9F378B2803CE4", hash_generated_field = "EDF9D0A31FBE606DFDBA889793F7BAA8")

        public long visibleAppThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.860 -0400", hash_original_field = "0372204543482C679B3EC94B27134E3D", hash_generated_field = "400B18A3CE750D836C4243EC67DB5154")

        public long foregroundAppThreshold;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.885 -0400", hash_original_method = "09AE2D253AD01F5533857164DB70587D", hash_generated_method = "FF74B0D10914F28AB3E573FB192E254D")
        public  MemoryInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.887 -0400", hash_original_method = "EAA33F4FBF3C878879D517CBC8FFA048", hash_generated_method = "D931D7EDEB60DF8546056BCA530CF0B7")
        private  MemoryInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.897 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B7DA78B7DCEC7CAC2CBD0445DC52D2E5")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449365503 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449365503;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.899 -0400", hash_original_method = "F89D0A9B79191784D882D224AE236CD7", hash_generated_method = "0EAEE8ADC1B25D2228EA758BB11C4D91")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(availMem);
            dest.writeLong(threshold);
            dest.writeInt(lowMemory ? 1 : 0);
            dest.writeLong(hiddenAppThreshold);
            dest.writeLong(secondaryServerThreshold);
            dest.writeLong(visibleAppThreshold);
            dest.writeLong(foregroundAppThreshold);
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //dest.writeLong(availMem);
            //dest.writeLong(threshold);
            //dest.writeInt(lowMemory ? 1 : 0);
            //dest.writeLong(hiddenAppThreshold);
            //dest.writeLong(secondaryServerThreshold);
            //dest.writeLong(visibleAppThreshold);
            //dest.writeLong(foregroundAppThreshold);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.920 -0400", hash_original_method = "63344B29322BA9906ACD5F2C274D4AFB", hash_generated_method = "BC66AADD41130FA5D032784C56DC61C2")
        public void readFromParcel(Parcel source) {
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.921 -0400", hash_original_field = "7B937244499DDD6DE8E8DD078A54CA42", hash_generated_field = "8D5A5BE61EBADDE649E9CD81EA9451BA")

        public static final Creator<MemoryInfo> CREATOR
                = new Creator<MemoryInfo>() {
            public MemoryInfo createFromParcel(Parcel source) {
                return new MemoryInfo(source);
            }
            public MemoryInfo[] newArray(int size) {
                return new MemoryInfo[size];
            }
        };
    }


    
    public static class ProcessErrorStateInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.922 -0400", hash_original_field = "3F9178C25B78ED8BED19091BCB62E266", hash_generated_field = "D12C7475F57008D4BAD02590CD186B34")

        public int condition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.922 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

        public String processName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.923 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.937 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.937 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

        public String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.938 -0400", hash_original_field = "A726C22E14A9C0DF4193537FB24D5DAF", hash_generated_field = "25D58ED094C8F824891E3926D1AD1DE0")

        public String shortMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.938 -0400", hash_original_field = "A31E91D860568FF036E728EC468229E1", hash_generated_field = "49D67D73AE5A1199A388FF4309BAA1C4")

        public String longMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.939 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "5AD16E48548E8F81D0DFF7F4F7B69945")

        public String stackTrace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.950 -0400", hash_original_field = "2F55CDAEC7168EE01704826F3CB21BF8", hash_generated_field = "4DE692F5BEA1FD9E7196CC9316DED961")

        public byte[] crashData = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.951 -0400", hash_original_method = "5ED73996FC5896C9F894604FFBFF8609", hash_generated_method = "3E55B7B14A298521D7B421AC3B025230")
        public  ProcessErrorStateInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.952 -0400", hash_original_method = "94E8D1B421B7A163DD1B499E5670983F", hash_generated_method = "69D04C39525C6467D032D3938D2BA420")
        private  ProcessErrorStateInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.960 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F4E1A2706C112ABA5F27BE5F92066173")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_560829972 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_560829972;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.979 -0400", hash_original_method = "38EC9879A184B274D068BE64A2E942B7", hash_generated_method = "AA969BCC5C910D3517709C2EA0A9AB49")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(condition);
            dest.writeString(processName);
            dest.writeInt(pid);
            dest.writeInt(uid);
            dest.writeString(tag);
            dest.writeString(shortMsg);
            dest.writeString(longMsg);
            dest.writeString(stackTrace);
            addTaint(dest.getTaint());
            addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.983 -0400", hash_original_method = "7EE07760084269563BF2AEE27C9085AD", hash_generated_method = "6FF9C96E0672E5AF8E3073FD70A01A17")
        public void readFromParcel(Parcel source) {
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.984 -0400", hash_original_field = "1B1949A508D4DA61D498C0A487C31F8F", hash_generated_field = "B8303B3F0D63DDF614BF107FEB77E81A")

        public static final int NO_ERROR = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.997 -0400", hash_original_field = "C842307260156DD524A8D7E2F162ACA3", hash_generated_field = "D6C8797DBA9046BA0CC1344E61A997BE")

        public static final int CRASHED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.998 -0400", hash_original_field = "67C3978F0F1FD3CF84AD70936693AE63", hash_generated_field = "2448698F79AC41420B9885070178CA3F")

        public static final int NOT_RESPONDING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.999 -0400", hash_original_field = "E578354A70C72AB1928323E0F806EC32", hash_generated_field = "B4E73E729A49A48B48C5C4D400C68AB6")

        public static final Creator<ProcessErrorStateInfo> CREATOR = 
                new Creator<ProcessErrorStateInfo>() {
            public ProcessErrorStateInfo createFromParcel(Parcel source) {
                return new ProcessErrorStateInfo(source);
            }
            public ProcessErrorStateInfo[] newArray(int size) {
                return new ProcessErrorStateInfo[size];
            }
        };
    }


    
    public static class RunningAppProcessInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.999 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

        public String processName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.010 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.011 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.011 -0400", hash_original_field = "91F81EBEC4F6E55EB9E1B725B7DEA854", hash_generated_field = "BC83CA44BBF502028F4847713C5A8FFF")

        public String pkgList[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.018 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

        public int flags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.019 -0400", hash_original_field = "7170F2678A3E108BAAC4FA8744F39743", hash_generated_field = "1C80947C985BAA8B2788455C14DF757E")

        public int importance;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.020 -0400", hash_original_field = "DBA3799464B52D8C7CE5446E998D2BD0", hash_generated_field = "935836E7F696020DF2282617A2CDE798")

        public int lru;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.021 -0400", hash_original_field = "179393AD83D5570C33B7F375CFD74B8C", hash_generated_field = "0640A813252163D85213DF91BD542354")

        public int importanceReasonCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.021 -0400", hash_original_field = "34F48A93A5B8ED84B9FC41D36732F609", hash_generated_field = "3F6331CE06F746B4BCE72993297280D9")

        public int importanceReasonPid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.039 -0400", hash_original_field = "F93D3851B3B84F3F0AA9FCDDEB568C55", hash_generated_field = "AB8C5FA34744BF22AFDA5ED2E8ACFB6B")

        public ComponentName importanceReasonComponent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.040 -0400", hash_original_field = "D3F6C4EF0BD40835CEE10C4FA0BC387E", hash_generated_field = "1CAAED6E0A748938FD5E5DBFF194111F")

        public int importanceReasonImportance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.050 -0400", hash_original_method = "037D75A14244F6412C20718AD220CDB7", hash_generated_method = "EBA9A2537661CB41AD3E24299B24227D")
        public  RunningAppProcessInfo() {
            importance = IMPORTANCE_FOREGROUND;
            importanceReasonCode = REASON_UNKNOWN;
            // ---------- Original Method ----------
            //importance = IMPORTANCE_FOREGROUND;
            //importanceReasonCode = REASON_UNKNOWN;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.065 -0400", hash_original_method = "09307CF5135B482F1E6BA3C6F777D6D1", hash_generated_method = "FC101465FBBE48A78A7DD657ACCB0EC9")
        public  RunningAppProcessInfo(String pProcessName, int pPid, String pArr[]) {
            processName = pProcessName;
            pid = pPid;
            pkgList = pArr;
            addTaint(pArr.getTaint());
            // ---------- Original Method ----------
            //processName = pProcessName;
            //pid = pPid;
            //pkgList = pArr;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.074 -0400", hash_original_method = "224713C5B1CB6C52B9BDAF058DA172D4", hash_generated_method = "D0964969E76FCC86D2A9723ABA5E1DB6")
        private  RunningAppProcessInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.075 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "22E0F314195F99701FF72E59005211AD")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901692440 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901692440;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.096 -0400", hash_original_method = "DDF0D3D0D0B3E35B68DDE155F98679B3", hash_generated_method = "D95FCB59AC223F26DC609E55AC67081A")
        public void writeToParcel(Parcel dest, int flags) {
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
            addTaint(dest.getTaint());
            addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.114 -0400", hash_original_method = "41C420DA0EF6445C06E1F94D547B6411", hash_generated_method = "6CEE33DDD5B34CFCAE50871715C114F5")
        public void readFromParcel(Parcel source) {
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.115 -0400", hash_original_field = "0C516D85DC95E1D7DBD9453D10915D62", hash_generated_field = "1647EC87F14B5F86D8632AD2EF6C5824")

        public static final int FLAG_CANT_SAVE_STATE = 1<<0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.118 -0400", hash_original_field = "79ABBEDFF5172FB955837B0C1965363B", hash_generated_field = "9BC36C98B31AD9692879EF62506317FF")

        public static final int FLAG_PERSISTENT = 1<<1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.118 -0400", hash_original_field = "357C7469C019E384BE9CE5D00A1CF3AA", hash_generated_field = "7C08C761DEDE62BEC8E3019EE74226FD")

        public static final int IMPORTANCE_FOREGROUND = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.119 -0400", hash_original_field = "9D5CFDC69DF8BA78DFE40629C7097D1B", hash_generated_field = "97CEF1AC776B153D10A3107635843A21")

        public static final int IMPORTANCE_VISIBLE = 200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.120 -0400", hash_original_field = "54F856D70C0E57CD964573BE1DFFFA2C", hash_generated_field = "B7BB82F7798AA2A5C18FBB6185BB2314")

        public static final int IMPORTANCE_PERCEPTIBLE = 130;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.137 -0400", hash_original_field = "87D4522C595B475672D59B8C88ADA1DB", hash_generated_field = "92BC51E78DA32D79D62ACCE3A407504B")

        public static final int IMPORTANCE_CANT_SAVE_STATE = 170;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.138 -0400", hash_original_field = "C609A3A34C642445A2EC8D79DE86612E", hash_generated_field = "306ED1F4972465B2A3462F89635BFAEA")

        public static final int IMPORTANCE_SERVICE = 300;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.138 -0400", hash_original_field = "0E1619FDE106CDF39C943149380B9AC9", hash_generated_field = "07BEC37BDBA9E0367125D8904629A332")

        public static final int IMPORTANCE_BACKGROUND = 400;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.139 -0400", hash_original_field = "BE271B13E2E9B7D77301DCBADCD0495F", hash_generated_field = "3215C32A2347C30D0BEC8CBF9EE1DB8B")

        public static final int IMPORTANCE_EMPTY = 500;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.152 -0400", hash_original_field = "594C5172577F9EDBDC1FE8A52ADB4B96", hash_generated_field = "277DB1ED9D8523A313B00F353F323926")

        public static final int REASON_UNKNOWN = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.152 -0400", hash_original_field = "07B2AF54D6C2EBDCEEACEF8594720AF8", hash_generated_field = "0D2FAA89DE8DF8459E547156CCFB7D13")

        public static final int REASON_PROVIDER_IN_USE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.153 -0400", hash_original_field = "50D549146D67D3EB13EB6CC2884408FB", hash_generated_field = "6620F40FC4D40B586E72B275F99528E5")

        public static final int REASON_SERVICE_IN_USE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.153 -0400", hash_original_field = "961684DCD5DF2C909DB5D05DEB0CF60C", hash_generated_field = "A62C347FADB0FAEE0097CA208AB4C94F")

        public static final Creator<RunningAppProcessInfo> CREATOR = 
            new Creator<RunningAppProcessInfo>() {
            public RunningAppProcessInfo createFromParcel(Parcel source) {
                return new RunningAppProcessInfo(source);
            }
            public RunningAppProcessInfo[] newArray(int size) {
                return new RunningAppProcessInfo[size];
            }
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.155 -0400", hash_original_field = "ED9918AAF9E33787BD2314FF60B55E2B", hash_generated_field = "C1ACB3A50DAA45E925C793ECFC62F195")

    private static String TAG = "ActivityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.155 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.168 -0400", hash_original_field = "0AA6BCFB0349530FC4361F030D247674", hash_generated_field = "C16804AA577FC6CC8AED78F613B9B4A2")

    public static final int COMPAT_MODE_ALWAYS = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.169 -0400", hash_original_field = "E005DAD989D6069B7F9C2761E7745EB7", hash_generated_field = "E7F4E1704AC1CA2E7F7AB5C73B5CC1FC")

    public static final int COMPAT_MODE_NEVER = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.169 -0400", hash_original_field = "6D32C580C7B0B3047871A405BF7653A7", hash_generated_field = "E6FB0DE41BD13A12D8C1FD83A17A8386")

    public static final int COMPAT_MODE_UNKNOWN = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.171 -0400", hash_original_field = "27AD56F2D373DA988FA5050E60A92EFF", hash_generated_field = "2C263FE55B5A2E3B8C053FFD33D5C145")

    public static final int COMPAT_MODE_DISABLED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.171 -0400", hash_original_field = "E4387FDACCA273C42D06029AE9D72FC0", hash_generated_field = "E7FF3DAED2069A006F3DA08E24DB5234")

    public static final int COMPAT_MODE_ENABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.171 -0400", hash_original_field = "C5FCDF4F54877B0601FD28082CBA8A9E", hash_generated_field = "9091AED5EDF419D09EF4B705217D4E96")

    public static final int COMPAT_MODE_TOGGLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.172 -0400", hash_original_field = "0565BAD5E12D959BAF62D241FB1476D8", hash_generated_field = "2242B54F4B4FEE2151042282E6383BC1")

    public static final int RECENT_WITH_EXCLUDED = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.189 -0400", hash_original_field = "790CDBE1E611701E4AA2E21493F99FD1", hash_generated_field = "07C68D9E69886FCCDB7162A95AE039AB")

    public static final int RECENT_IGNORE_UNAVAILABLE = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.190 -0400", hash_original_field = "A539421EFFBB0F7BBACC7DDF8F4B1387", hash_generated_field = "F9D136F9AAF3BD2649A8DB3952F9FEFD")

    public static final int REMOVE_TASK_KILL_PROCESS = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.191 -0400", hash_original_field = "F00667FF1E3452F88502B375236D07BF", hash_generated_field = "F905711F81704086241D937BB8F72E15")

    public static final int MOVE_TASK_WITH_HOME = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.192 -0400", hash_original_field = "881212394691AFD32C931C74BC9A99C8", hash_generated_field = "C1B1346ED585E8734FB3050A443502A1")

    public static final int MOVE_TASK_NO_USER_ACTION = 0x00000002;
}

