package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.019 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.019 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.020 -0400", hash_original_method = "5B4171109A2201F1FE14E6225146AB80", hash_generated_method = "8ADD7487E2C46628C6CC7A69BA117746")
      ActivityManager(Context context, Handler handler) {
        mContext = context;
        mHandler = handler;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.021 -0400", hash_original_method = "BCFF8F5D8C51374E31DC49464CB803A5", hash_generated_method = "6CE3390A2CF5B7AE6C51DBF75DEEF0AB")
    public int getFrontActivityScreenCompatMode() {
        try 
        {
            int var6D57FFF049EDBBD675CB42E6E5881F63_169015730 = (ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode());
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471723324 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471723324;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.022 -0400", hash_original_method = "1AD781893C5FA74DDB5BF5981AAFC282", hash_generated_method = "45A9A05AC09544DC3BCAA5225B37664D")
    public void setFrontActivityScreenCompatMode(int mode) {
        try 
        {
            ActivityManagerNative.getDefault().setFrontActivityScreenCompatMode(mode);
        } 
        catch (RemoteException e)
        { }
        addTaint(mode);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.023 -0400", hash_original_method = "08DE0842CE89FB88CEE40B6F1F1D5D8A", hash_generated_method = "E09A0FB8AEFED3D22F6D9530E2B1192C")
    public int getPackageScreenCompatMode(String packageName) {
        try 
        {
            int var4970DBBC19CF020D2AB9E07CA6C5607B_265904213 = (ActivityManagerNative.getDefault().getPackageScreenCompatMode(packageName));
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124008537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124008537;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.023 -0400", hash_original_method = "6272BC343B5B54EAA927E2C6A7A229FA", hash_generated_method = "F7868BA9DC961380C8CFFDB247A2B274")
    public void setPackageScreenCompatMode(String packageName, int mode) {
        try 
        {
            ActivityManagerNative.getDefault().setPackageScreenCompatMode(packageName, mode);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(mode);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.024 -0400", hash_original_method = "43CD4547C63AA5BA08A4BB7431262A61", hash_generated_method = "C9B96B9E8B83395B10856CA33D4A8EB7")
    public boolean getPackageAskScreenCompat(String packageName) {
        try 
        {
            boolean var8E89A0F6D10823A8701FE5BBBD1FE149_1983313565 = (ActivityManagerNative.getDefault().getPackageAskScreenCompat(packageName));
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_13524758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_13524758;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.025 -0400", hash_original_method = "3BC1D3C0234B303E106B1ACB51D8D800", hash_generated_method = "5F1A65070AAEF92A55E16D6A3AD742E6")
    public void setPackageAskScreenCompat(String packageName, boolean ask) {
        try 
        {
            ActivityManagerNative.getDefault().setPackageAskScreenCompat(packageName, ask);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(ask);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.025 -0400", hash_original_method = "B7DBD08AF6CFCEAABC628A74B78E8B6F", hash_generated_method = "979E595270484714EF0BD0EABF09B429")
    public int getMemoryClass() {
        int var9862DFF8105689D1FAD16F0A2A7D04D2_1743729835 = (staticGetMemoryClass());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803315864 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803315864;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static public int staticGetMemoryClass() {
        String vmHeapSize = SystemProperties.get("dalvik.vm.heapgrowthlimit", "");
        if (vmHeapSize != null && !"".equals(vmHeapSize)) {
            return Integer.parseInt(vmHeapSize.substring(0, vmHeapSize.length()-1));
        }
        return staticGetLargeMemoryClass();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.026 -0400", hash_original_method = "50F084ADAAFF8EB942A9D9EB0C93D87F", hash_generated_method = "55645F07C4C8D57949230C8C2E9A3339")
    public int getLargeMemoryClass() {
        int var69D319CAE7493EBEEA5EC841CBB29C6C_529699585 = (staticGetLargeMemoryClass());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146318145 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146318145;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static public int staticGetLargeMemoryClass() {
        String vmHeapSize = SystemProperties.get("dalvik.vm.heapsize", "16m");
        return Integer.parseInt(vmHeapSize.substring(0, vmHeapSize.length()-1));
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    static public boolean isLargeRAM() {
        MemInfoReader reader = new MemInfoReader();
        reader.readMemInfo();
        if (reader.getTotalSize() >= (640*1024*1024)) {
            return true;
        }
        return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.028 -0400", hash_original_method = "F8BE7228FE8A06DB7E3F7EC0517EBE16", hash_generated_method = "674C0B70085289B1769297300823C42B")
    public List<RecentTaskInfo> getRecentTasks(int maxNum, int flags) throws SecurityException {
        List<RecentTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_1916390342 = null; 
        List<RecentTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_520121874 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1916390342 = ActivityManagerNative.getDefault().getRecentTasks(maxNum,
                    flags);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_520121874 = null;
        } 
        addTaint(maxNum);
        addTaint(flags);
        List<RecentTaskInfo> varA7E53CE21691AB073D9660D615818899_1602029236; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1602029236 = varB4EAC82CA7396A68D541C85D26508E83_1916390342;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1602029236 = varB4EAC82CA7396A68D541C85D26508E83_520121874;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1602029236.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1602029236;
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.030 -0400", hash_original_method = "324273237D89470A473FD6EC5C103A40", hash_generated_method = "F39C6E09745292344B97F5646314F00C")
    public List<RunningTaskInfo> getRunningTasks(int maxNum, int flags, IThumbnailReceiver receiver) throws SecurityException {
        List<RunningTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_1997871953 = null; 
        List<RunningTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_962701541 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1997871953 = ActivityManagerNative.getDefault().getTasks(maxNum, flags, receiver);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_962701541 = null;
        } 
        addTaint(maxNum);
        addTaint(flags);
        addTaint(receiver.getTaint());
        List<RunningTaskInfo> varA7E53CE21691AB073D9660D615818899_294091813; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_294091813 = varB4EAC82CA7396A68D541C85D26508E83_1997871953;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_294091813 = varB4EAC82CA7396A68D541C85D26508E83_962701541;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_294091813.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_294091813;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.031 -0400", hash_original_method = "048E08D6499B0F81FA41B243F96225CE", hash_generated_method = "9674B18E5AA80595545F0A7B22E68E2B")
    public List<RunningTaskInfo> getRunningTasks(int maxNum) throws SecurityException {
        List<RunningTaskInfo> varB4EAC82CA7396A68D541C85D26508E83_1960314857 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1960314857 = getRunningTasks(maxNum, 0, null);
        addTaint(maxNum);
        varB4EAC82CA7396A68D541C85D26508E83_1960314857.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1960314857;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.032 -0400", hash_original_method = "06417D4703E772AA57E4535D9CA52E2C", hash_generated_method = "032656F35ABA6ACB6A979B63A1D16187")
    public boolean removeSubTask(int taskId, int subTaskIndex) throws SecurityException {
        try 
        {
            boolean var07CF28A51B530B1C42F191E5697D370C_1858413878 = (ActivityManagerNative.getDefault().removeSubTask(taskId, subTaskIndex));
        } 
        catch (RemoteException e)
        { }
        addTaint(taskId);
        addTaint(subTaskIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_386513249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_386513249;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.034 -0400", hash_original_method = "B1BB833FCE4ABF3667361FA6F055417F", hash_generated_method = "60A3932F9A02BA5BA2A7E2B348F484FA")
    public boolean removeTask(int taskId, int flags) throws SecurityException {
        try 
        {
            boolean varE06E21935A507F8A824839E5F554648C_1199876888 = (ActivityManagerNative.getDefault().removeTask(taskId, flags));
        } 
        catch (RemoteException e)
        { }
        addTaint(taskId);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402393737 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402393737;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.036 -0400", hash_original_method = "90A15739ABCD71E20C2601B2E690D2DC", hash_generated_method = "F3D6BCF44C1FE0F491F4ED385DE29B96")
    public TaskThumbnails getTaskThumbnails(int id) throws SecurityException {
        TaskThumbnails varB4EAC82CA7396A68D541C85D26508E83_2097368933 = null; 
        TaskThumbnails varB4EAC82CA7396A68D541C85D26508E83_1933909064 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2097368933 = ActivityManagerNative.getDefault().getTaskThumbnails(id);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1933909064 = null;
        } 
        addTaint(id);
        TaskThumbnails varA7E53CE21691AB073D9660D615818899_382198491; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_382198491 = varB4EAC82CA7396A68D541C85D26508E83_2097368933;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_382198491 = varB4EAC82CA7396A68D541C85D26508E83_1933909064;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_382198491.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_382198491;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.037 -0400", hash_original_method = "68F3ECC95EA33C5EF7CED37FFBD163D9", hash_generated_method = "3817E9D5930F1E27CA1C1C30435A6CAE")
    public void moveTaskToFront(int taskId, int flags) {
        try 
        {
            ActivityManagerNative.getDefault().moveTaskToFront(taskId, flags);
        } 
        catch (RemoteException e)
        { }
        addTaint(taskId);
        addTaint(flags);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.039 -0400", hash_original_method = "93643A575557EDD801C5647B318BA97A", hash_generated_method = "1674116C58CC7D0D3D19BBCD4944E9CA")
    public List<RunningServiceInfo> getRunningServices(int maxNum) throws SecurityException {
        List<RunningServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_846400479 = null; 
        List<RunningServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_1202351948 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_846400479 = ActivityManagerNative.getDefault()
                    .getServices(maxNum, 0);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1202351948 = null;
        } 
        addTaint(maxNum);
        List<RunningServiceInfo> varA7E53CE21691AB073D9660D615818899_173431190; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_173431190 = varB4EAC82CA7396A68D541C85D26508E83_846400479;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_173431190 = varB4EAC82CA7396A68D541C85D26508E83_1202351948;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_173431190.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_173431190;
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.040 -0400", hash_original_method = "3F37B5EEA2E0ADFF7012B4DB8D3BC71C", hash_generated_method = "B91FB5027C7B0B28C1588954010A823D")
    public PendingIntent getRunningServiceControlPanel(ComponentName service) throws SecurityException {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_856962038 = null; 
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_736445918 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_856962038 = ActivityManagerNative.getDefault()
                    .getRunningServiceControlPanel(service);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_736445918 = null;
        } 
        addTaint(service.getTaint());
        PendingIntent varA7E53CE21691AB073D9660D615818899_278117552; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_278117552 = varB4EAC82CA7396A68D541C85D26508E83_856962038;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_278117552 = varB4EAC82CA7396A68D541C85D26508E83_736445918;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_278117552.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_278117552;
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.041 -0400", hash_original_method = "B6E6E4E46821E411AC60EE30A7424576", hash_generated_method = "D9A0C6359BA0CC2573E3A02B9F1C0C85")
    public void getMemoryInfo(MemoryInfo outInfo) {
        try 
        {
            ActivityManagerNative.getDefault().getMemoryInfo(outInfo);
        } 
        catch (RemoteException e)
        { }
        addTaint(outInfo.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.043 -0400", hash_original_method = "F72074CE1B364F8B93C8BBDF31501500", hash_generated_method = "9475BDA59CFACE29C15C391128B31E75")
    public boolean clearApplicationUserData(String packageName, IPackageDataObserver observer) {
        try 
        {
            boolean var6850AED94B5983BF09E13F93CF984187_766936949 = (ActivityManagerNative.getDefault().clearApplicationUserData(packageName, 
                    observer));
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2011234275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2011234275;
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.045 -0400", hash_original_method = "F53E97F522CAE83DA0CBCF957085AF2C", hash_generated_method = "4697B63C404A534BCD5B90BF0413C828")
    public List<ProcessErrorStateInfo> getProcessesInErrorState() {
        List<ProcessErrorStateInfo> varB4EAC82CA7396A68D541C85D26508E83_1832651555 = null; 
        List<ProcessErrorStateInfo> varB4EAC82CA7396A68D541C85D26508E83_554186424 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1832651555 = ActivityManagerNative.getDefault().getProcessesInErrorState();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_554186424 = null;
        } 
        List<ProcessErrorStateInfo> varA7E53CE21691AB073D9660D615818899_1736746946; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1736746946 = varB4EAC82CA7396A68D541C85D26508E83_1832651555;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1736746946 = varB4EAC82CA7396A68D541C85D26508E83_554186424;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1736746946.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1736746946;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.047 -0400", hash_original_method = "5737B6241A3389A78D86162B5C5BDB02", hash_generated_method = "8E67BEF53AB26CAF6D778D040F463068")
    public List<ApplicationInfo> getRunningExternalApplications() {
        List<ApplicationInfo> varB4EAC82CA7396A68D541C85D26508E83_1840113386 = null; 
        List<ApplicationInfo> varB4EAC82CA7396A68D541C85D26508E83_78927457 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1840113386 = ActivityManagerNative.getDefault().getRunningExternalApplications();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_78927457 = null;
        } 
        List<ApplicationInfo> varA7E53CE21691AB073D9660D615818899_1301403161; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1301403161 = varB4EAC82CA7396A68D541C85D26508E83_1840113386;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1301403161 = varB4EAC82CA7396A68D541C85D26508E83_78927457;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1301403161.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1301403161;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.050 -0400", hash_original_method = "BB41AA7EC02A452F0653300FBA1EFF8A", hash_generated_method = "50A46EE76564BD2329CBFF90DAACCDAA")
    public List<RunningAppProcessInfo> getRunningAppProcesses() {
        List<RunningAppProcessInfo> varB4EAC82CA7396A68D541C85D26508E83_325700236 = null; 
        List<RunningAppProcessInfo> varB4EAC82CA7396A68D541C85D26508E83_836419734 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_325700236 = ActivityManagerNative.getDefault().getRunningAppProcesses();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_836419734 = null;
        } 
        List<RunningAppProcessInfo> varA7E53CE21691AB073D9660D615818899_871743211; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_871743211 = varB4EAC82CA7396A68D541C85D26508E83_325700236;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_871743211 = varB4EAC82CA7396A68D541C85D26508E83_836419734;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_871743211.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_871743211;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.051 -0400", hash_original_method = "BA29C29542BF4FC0E2178C81FA222823", hash_generated_method = "A841AAE2E1396D67372C46E17F483CE2")
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) {
        Debug.MemoryInfo[] varB4EAC82CA7396A68D541C85D26508E83_948591984 = null; 
        Debug.MemoryInfo[] varB4EAC82CA7396A68D541C85D26508E83_20340257 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_948591984 = ActivityManagerNative.getDefault().getProcessMemoryInfo(pids);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_20340257 = null;
        } 
        addTaint(pids[0]);
        Debug.MemoryInfo[] varA7E53CE21691AB073D9660D615818899_19572056; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_19572056 = varB4EAC82CA7396A68D541C85D26508E83_948591984;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_19572056 = varB4EAC82CA7396A68D541C85D26508E83_20340257;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_19572056.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_19572056;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.052 -0400", hash_original_method = "AB97F58AF8359C056EB136FA16E11328", hash_generated_method = "A84F25691E8C63A8F8ADC70FCC60AA45")
    @Deprecated
    public void restartPackage(String packageName) {
        killBackgroundProcesses(packageName);
        addTaint(packageName.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.053 -0400", hash_original_method = "BAC028425422747AF2B8DB952F37E411", hash_generated_method = "A4DCAD0F3AEED91C85AE580BF5DA9D0D")
    public void killBackgroundProcesses(String packageName) {
        try 
        {
            ActivityManagerNative.getDefault().killBackgroundProcesses(packageName);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.054 -0400", hash_original_method = "F30C6D9D6BE88E1DA2EC5D39F1D44538", hash_generated_method = "8DE82AE1790A9B608CDC0CA6AF645768")
    public void forceStopPackage(String packageName) {
        try 
        {
            ActivityManagerNative.getDefault().forceStopPackage(packageName);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.057 -0400", hash_original_method = "002CA49339A7476A8E8EF41ECCC37BDD", hash_generated_method = "A31099B3BC1407A470FD7812B672D0D5")
    public ConfigurationInfo getDeviceConfigurationInfo() {
        ConfigurationInfo varB4EAC82CA7396A68D541C85D26508E83_1967256331 = null; 
        ConfigurationInfo varB4EAC82CA7396A68D541C85D26508E83_2031251103 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1967256331 = ActivityManagerNative.getDefault().getDeviceConfigurationInfo();
        } 
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_2031251103 = null;
        ConfigurationInfo varA7E53CE21691AB073D9660D615818899_1085521791; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1085521791 = varB4EAC82CA7396A68D541C85D26508E83_1967256331;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1085521791 = varB4EAC82CA7396A68D541C85D26508E83_2031251103;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1085521791.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1085521791;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.058 -0400", hash_original_method = "E6A8DEADBC97DC6A083D1FDDD3BF2E4E", hash_generated_method = "CC1116343443D376DD82FDEAA1E6CEA4")
    public int getLauncherLargeIconDensity() {
        final Resources res = mContext.getResources();
        final int density = res.getDisplayMetrics().densityDpi;
        {
            boolean varE01F796B7DD545CA1852C72371851054_901891330 = ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768367515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768367515;
        
        
        
        
                
            
        
        
            
                
            
                
            
                
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.059 -0400", hash_original_method = "1ABECD33DDCEDD9654A62357CF29D109", hash_generated_method = "0F611A49A1DC598AD43EB54DB11F3BAB")
    public int getLauncherLargeIconSize() {
        final Resources res = mContext.getResources();
        final int size = res.getDimensionPixelSize(android.R.dimen.app_icon_size);
        {
            boolean varE01F796B7DD545CA1852C72371851054_1950826719 = ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE);
        } 
        final int density = res.getDisplayMetrics().densityDpi;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_501661073 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_501661073;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isUserAMonkey() {
        try {
            return ActivityManagerNative.getDefault().isUserAMonkey();
        } catch (RemoteException e) {
        }
        return false;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isRunningInTestHarness() {
        return SystemProperties.getBoolean("ro.test_harness", false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:40.196 -0400", hash_original_method = "2575FA7FD2518D90A93FBC6E066D35C1", hash_generated_method = "81C06201AC6E5010A7FD105C1E83B7AC")
    public Map<String, Integer> getAllPackageLaunchCounts() {
        Map<String, Integer> varB4EAC82CA7396A68D541C85D26508E83_1536185650 = null; 
        Map<String, Integer> varB4EAC82CA7396A68D541C85D26508E83_112190957 = null; 
        Map<String, Integer> varB4EAC82CA7396A68D541C85D26508E83_1257369091 = null; 
        Map<String, Integer> varB4EAC82CA7396A68D541C85D26508E83_518505529 = null; 
        try 
        {
            IUsageStats usageStatsService;
            usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1536185650 = new HashMap<String, Integer>();
            } 
            PkgUsageStats[] allPkgUsageStats;
            allPkgUsageStats = usageStatsService.getAllPkgUsageStats();
            {
                varB4EAC82CA7396A68D541C85D26508E83_112190957 = new HashMap<String, Integer>();
            } 
            Map<String, Integer> launchCounts;
            launchCounts = new HashMap<String, Integer>();
            {
                PkgUsageStats pkgUsageStats = allPkgUsageStats[0];
                {
                    launchCounts.put(pkgUsageStats.packageName, pkgUsageStats.launchCount);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1257369091 = launchCounts;
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_518505529 = new HashMap<String, Integer>();
        } 
        Map<String, Integer> varA7E53CE21691AB073D9660D615818899_1658309039; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1658309039 = varB4EAC82CA7396A68D541C85D26508E83_1536185650;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1658309039 = varB4EAC82CA7396A68D541C85D26508E83_112190957;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1658309039 = varB4EAC82CA7396A68D541C85D26508E83_1257369091;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1658309039 = varB4EAC82CA7396A68D541C85D26508E83_518505529;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1658309039.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1658309039;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.061 -0400", hash_original_method = "97D195D4FE7E8BCA1AFB9969B53F0E5E", hash_generated_method = "5E8BCDB2DB3C326B588082C160F17826")
    public PkgUsageStats[] getAllPackageUsageStats() {
        PkgUsageStats[] varB4EAC82CA7396A68D541C85D26508E83_156569116 = null; 
        PkgUsageStats[] varB4EAC82CA7396A68D541C85D26508E83_1281699375 = null; 
        try 
        {
            IUsageStats usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_156569116 = usageStatsService.getAllPkgUsageStats();
            } 
        } 
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1281699375 = new PkgUsageStats[0];
        PkgUsageStats[] varA7E53CE21691AB073D9660D615818899_1717462693; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1717462693 = varB4EAC82CA7396A68D541C85D26508E83_156569116;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1717462693 = varB4EAC82CA7396A68D541C85D26508E83_1281699375;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1717462693.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1717462693;
        
        
            
                    
            
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.063 -0400", hash_original_method = "5F692D6C0F0BEC319B49459A73599D4B", hash_generated_method = "330725428DB2D51C4D398F4B3D01CE43")
    public boolean switchUser(int userid) {
        try 
        {
            boolean var2D87E0C1C61F5F6722509A3C54C5660D_1028905837 = (ActivityManagerNative.getDefault().switchUser(userid));
        } 
        catch (RemoteException e)
        { }
        addTaint(userid);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070686624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070686624;
        
        
            
        
            
        
    }

    
    public static class RecentTaskInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.063 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.064 -0400", hash_original_field = "4C2CDFF3CA319DD68A3483A4CF59EA28", hash_generated_field = "45FD448AF1C8BBB4AAEF0A2F3C76D8D5")

        public int persistentId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.064 -0400", hash_original_field = "5516160C4AFEB3607228EDA7CF505DA4", hash_generated_field = "19F03161095B5D5B4369A44839D909E6")

        public Intent baseIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.064 -0400", hash_original_field = "50B95CD9B73499236EB8892142F4BF6E", hash_generated_field = "33781CF46949A55BB10919B7C8D1FCE2")

        public ComponentName origActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.064 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "D2E00B0C52A0AFC2C3ECD84ACC639853")

        public CharSequence description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.066 -0400", hash_original_method = "C08B7337C6B109635FE340903513A97B", hash_generated_method = "3151CC50C901E54C1039F8A4558613C1")
        public  RecentTaskInfo() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.066 -0400", hash_original_method = "1CABC845DDD8B9A1DEC9FF64F1615AFC", hash_generated_method = "6343DA72E3031300D8C1A124BFDF2490")
        private  RecentTaskInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.067 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "866FCDCD88E448847A0FE7C8CF7AF762")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233037427 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233037427;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.068 -0400", hash_original_method = "A024AE935060D48D15B6110668C59DDF", hash_generated_method = "0BF19E261D38CC388BB62C5E1402C04B")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeInt(persistentId);
            {
                dest.writeInt(1);
                baseIntent.writeToParcel(dest, 0);
            } 
            {
                dest.writeInt(0);
            } 
            ComponentName.writeToParcel(origActivity, dest);
            TextUtils.writeToParcel(description, dest,
                    Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
                
                
            
                
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.069 -0400", hash_original_method = "F67217ABAEC36040C8F444901EE65BC8", hash_generated_method = "5BAF897D190C9C64C109FA4DE49FFBB2")
        public void readFromParcel(Parcel source) {
            id = source.readInt();
            persistentId = source.readInt();
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_1362776294 = (source.readInt() != 0);
                {
                    baseIntent = Intent.CREATOR.createFromParcel(source);
                } 
                {
                    baseIntent = null;
                } 
            } 
            origActivity = ComponentName.readFromParcel(source);
            description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            
            
            
            
                
            
                
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.069 -0400", hash_original_field = "DA99927A07743B1B8E96157497F59A82", hash_generated_field = "144243CA012A4B8ABF03F2F1B5702AF7")

        public static final Creator<RecentTaskInfo> CREATOR
                = new Creator<RecentTaskInfo>() {
            public RecentTaskInfo createFromParcel(Parcel source) {
                return new RecentTaskInfo(source);
            }
            public RecentTaskInfo[] newArray(int size) {
                return new RecentTaskInfo[size];
            }
        };
        
        public RecentTaskInfo createFromParcel(Parcel source) {
                return new RecentTaskInfo(source);
            }
        
        
        public RecentTaskInfo[] newArray(int size) {
                return new RecentTaskInfo[size];
            }
        
    }


    
    public static class RunningTaskInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.069 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.070 -0400", hash_original_field = "F6CEE472EAA2684591EBF9247DDF7CD8", hash_generated_field = "706934E85A3C10660FC2C5B7806ED0A6")

        public ComponentName baseActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.070 -0400", hash_original_field = "754F1F12013FFC78FF843281317AD0A9", hash_generated_field = "E1E2B3D4624F0E478C8CD581F117A622")

        public ComponentName topActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.070 -0400", hash_original_field = "951D4DFF3C22E9FCC4A2707009F45EA8", hash_generated_field = "78966E97EF5212F19E857E6A323EA39E")

        public Bitmap thumbnail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.070 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "D2E00B0C52A0AFC2C3ECD84ACC639853")

        public CharSequence description;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.070 -0400", hash_original_field = "94FBBA8E700FC03C18CC3D15C947FAE5", hash_generated_field = "4C423F6359C67873078893E7E4F87908")

        public int numActivities;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.070 -0400", hash_original_field = "8C7843D564F548CECBC331DDEA9E6A6F", hash_generated_field = "76E787CD7EF42C186801DE136C1FAB80")

        public int numRunning;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.071 -0400", hash_original_method = "6DA0A8D9CEF41C0CB91D2D95D7E71D44", hash_generated_method = "00FB201893D0BF493904CEE004049E1E")
        public  RunningTaskInfo() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.071 -0400", hash_original_method = "A0900FA369CFAE0B339B23849E0D0E54", hash_generated_method = "8E4FFC44DACDCC9CBA26262278C4D8E8")
        private  RunningTaskInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.072 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "CB75E4D559FF12887904D65F1E9FC562")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088702904 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088702904;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.073 -0400", hash_original_method = "224D236A6A210D9CABF5D7D423C96E97", hash_generated_method = "1D016E9D5230848064157F30570EF06A")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            ComponentName.writeToParcel(baseActivity, dest);
            ComponentName.writeToParcel(topActivity, dest);
            {
                dest.writeInt(1);
                thumbnail.writeToParcel(dest, 0);
            } 
            {
                dest.writeInt(0);
            } 
            TextUtils.writeToParcel(description, dest,
                    Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            dest.writeInt(numActivities);
            dest.writeInt(numRunning);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
            
                
                
            
                
            
            
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.075 -0400", hash_original_method = "1A58A87C00619395DA7F7A454E1E03D5", hash_generated_method = "BE1AA73D2A5F47D097022D2BF7950C06")
        public void readFromParcel(Parcel source) {
            id = source.readInt();
            baseActivity = ComponentName.readFromParcel(source);
            topActivity = ComponentName.readFromParcel(source);
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_475865395 = (source.readInt() != 0);
                {
                    thumbnail = Bitmap.CREATOR.createFromParcel(source);
                } 
                {
                    thumbnail = null;
                } 
            } 
            description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            numActivities = source.readInt();
            numRunning = source.readInt();
            
            
            
            
            
                
            
                
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.075 -0400", hash_original_field = "B9911C96575F25BA7EB7A3422AE8B6F1", hash_generated_field = "8DCFCF5E1FAAD8B612615CB5CB186FEC")

        public static final Creator<RunningTaskInfo> CREATOR = new Creator<RunningTaskInfo>() {
            public RunningTaskInfo createFromParcel(Parcel source) {
                return new RunningTaskInfo(source);
            }
            public RunningTaskInfo[] newArray(int size) {
                return new RunningTaskInfo[size];
            }
        };
        
        public RunningTaskInfo createFromParcel(Parcel source) {
                return new RunningTaskInfo(source);
            }
        
        
        public RunningTaskInfo[] newArray(int size) {
                return new RunningTaskInfo[size];
            }
        
    }


    
    public static class TaskThumbnails implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.076 -0400", hash_original_field = "A04B656670F0FC97E22C1CDFD7F3E1C2", hash_generated_field = "5F56FA9AC5C1789807151046ACFA6F30")

        public Bitmap mainThumbnail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.076 -0400", hash_original_field = "E8B61C2BAEABE799CF0E0D2E9C2E9DBA", hash_generated_field = "B493724A74ED3FB14A03B4D585258CEB")

        public int numSubThumbbails;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.076 -0400", hash_original_field = "36DDD37AE3EA18F3B624E48455871F81", hash_generated_field = "F26B03B078059BC2048093DDC93DD417")

        public IThumbnailRetriever retriever;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.077 -0400", hash_original_method = "EB2263C71F650A09D4909FB1B34C782F", hash_generated_method = "1036CA739667021DAECAC8857E8C6B4B")
        public  TaskThumbnails() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.077 -0400", hash_original_method = "0FEFA86B10CDE25FCF4328B39BD2F7D5", hash_generated_method = "EAA1C3B2F4AD40A92EF4EAF706A12906")
        private  TaskThumbnails(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.079 -0400", hash_original_method = "C8A1C6791C443D43BB18F989CA6219B6", hash_generated_method = "0F2AB61375583385D3416DE70C2D281A")
        public Bitmap getSubThumbnail(int index) {
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_207372580 = null; 
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_1432961055 = null; 
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_207372580 = retriever.getThumbnail(index);
            } 
            catch (RemoteException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1432961055 = null;
            } 
            addTaint(index);
            Bitmap varA7E53CE21691AB073D9660D615818899_914227280; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_914227280 = varB4EAC82CA7396A68D541C85D26508E83_207372580;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_914227280 = varB4EAC82CA7396A68D541C85D26508E83_1432961055;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_914227280.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_914227280;
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.079 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A78D64EC8A55E874698980414E735BA1")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_849089139 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_849089139;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.080 -0400", hash_original_method = "1641949793D35FD49D0AD46DB3E00603", hash_generated_method = "6AB7CF3EB39990DAB269010FEE23B929")
        public void writeToParcel(Parcel dest, int flags) {
            {
                dest.writeInt(1);
                mainThumbnail.writeToParcel(dest, 0);
            } 
            {
                dest.writeInt(0);
            } 
            dest.writeInt(numSubThumbbails);
            dest.writeStrongInterface(retriever);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
                
                
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.081 -0400", hash_original_method = "19A7C144CCAE5CD51406B760DF512EA1", hash_generated_method = "BBEBFBDCE8AB4E11936FF2F8961B5255")
        public void readFromParcel(Parcel source) {
            {
                boolean varCD45DF3165DBB462488DC9800D3FFD9B_645943316 = (source.readInt() != 0);
                {
                    mainThumbnail = Bitmap.CREATOR.createFromParcel(source);
                } 
                {
                    mainThumbnail = null;
                } 
            } 
            numSubThumbbails = source.readInt();
            retriever = IThumbnailRetriever.Stub.asInterface(source.readStrongBinder());
            
            
                
            
                
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.081 -0400", hash_original_field = "4F6854EC28C10C68ABB672C395CA9C17", hash_generated_field = "A7CA2C3264BCA3B8EB9304642C9D25D2")

        public static final Creator<TaskThumbnails> CREATOR = new Creator<TaskThumbnails>() {
            public TaskThumbnails createFromParcel(Parcel source) {
                return new TaskThumbnails(source);
            }
            public TaskThumbnails[] newArray(int size) {
                return new TaskThumbnails[size];
            }
        };
        
        public TaskThumbnails createFromParcel(Parcel source) {
                return new TaskThumbnails(source);
            }
        
        
        public TaskThumbnails[] newArray(int size) {
                return new TaskThumbnails[size];
            }
        
    }


    
    public static class RunningServiceInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.081 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "7437D6C257B93451B3453DAF54B89FA5")

        public ComponentName service;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.082 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.082 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.082 -0400", hash_original_field = "5075140835D0BC504791C76B04C33D2B", hash_generated_field = "5CB999C89045E47AAA039EC43EA8EFD0")

        public String process;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.082 -0400", hash_original_field = "0FA009A743944A032EB54727ACEC48D6", hash_generated_field = "C92541C3D7058FCBBE46B97331B1DC61")

        public boolean foreground;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.082 -0400", hash_original_field = "2D46EB4EB6B83A1C450824B45B32C27A", hash_generated_field = "97CA36905CF396E537D491E932056860")

        public long activeSince;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.082 -0400", hash_original_field = "3BEBB2F89180B03FA5AE736665F648D9", hash_generated_field = "C0D67C1D1506D281491B9E92F436947F")

        public boolean started;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.083 -0400", hash_original_field = "CBA189F1D71714C066EA167B8A6AB3F5", hash_generated_field = "D21158F500DD41CD27566BC52C1CC2A3")

        public int clientCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.083 -0400", hash_original_field = "FCE2B0B390C578D2C38F670A9DD71E31", hash_generated_field = "14132D33689AF670E5EB24E340EA0A1A")

        public int crashCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.083 -0400", hash_original_field = "56991C1B63E5D7315D12B164F548278C", hash_generated_field = "126A413BC4E906D9E97E7626D6F4396F")

        public long lastActivityTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.083 -0400", hash_original_field = "A96E39B0C2CE86E83FEC80D073185ED0", hash_generated_field = "86B8197832B5D22734B4FAA009117212")

        public long restarting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.083 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

        public int flags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.084 -0400", hash_original_field = "9C3D569D866B7814BCD25623021A8F08", hash_generated_field = "EB1A871976ECAE165274E12319BA7914")

        public String clientPackage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.084 -0400", hash_original_field = "079D8F063684CAF3DDEEC8873031178D", hash_generated_field = "E322FF71A4FA039913D2A08C5BB78D14")

        public int clientLabel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.084 -0400", hash_original_method = "621426751430068D32289E518662756C", hash_generated_method = "822CEFC1BD8FA9077CAB00884D317765")
        public  RunningServiceInfo() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.085 -0400", hash_original_method = "35E5A4903D7EB9EB66480EDFA6F47A72", hash_generated_method = "A40622EFC2B889119ECB5BC3A2E83D61")
        private  RunningServiceInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.086 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7EB5D83F0ED7422C01EF70299103500F")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232502832 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232502832;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.087 -0400", hash_original_method = "048D37EC670A88D2663FCC084087D5E3", hash_generated_method = "E41679A34EC2E47A5E6D1587C1ADFE22")
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
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.089 -0400", hash_original_method = "264C3E4C1DAB76B38CA08CE45829A86C", hash_generated_method = "DD78297D77B49BEF3DC4CE1566C885A4")
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
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.089 -0400", hash_original_field = "6D9DB860035C68DDD8F2027972602A14", hash_generated_field = "C5EE28BB616EBCBE67B4A8F8CA4F4F8C")

        public static final int FLAG_STARTED = 1<<0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.090 -0400", hash_original_field = "D87893D0147F0F1E098475CAC202BBF2", hash_generated_field = "829940B23BDE846C789CE2452F9F2213")

        public static final int FLAG_FOREGROUND = 1<<1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.090 -0400", hash_original_field = "5B5C76863E4B1F71B19824790CDBF7E5", hash_generated_field = "A8B50094DCEC06B9ED9EBA4201DB4EF0")

        public static final int FLAG_SYSTEM_PROCESS = 1<<2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.090 -0400", hash_original_field = "888DD4FCC0586AC0A3A963599166EC86", hash_generated_field = "BA474CA4A54C5FFAAAC838F19039B567")

        public static final int FLAG_PERSISTENT_PROCESS = 1<<3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.090 -0400", hash_original_field = "AD64936DA7390A375DCEFDC8BEB2A286", hash_generated_field = "45AB20E66E709306D076BBEB8007B79C")

        public static final Creator<RunningServiceInfo> CREATOR = new Creator<RunningServiceInfo>() {
            public RunningServiceInfo createFromParcel(Parcel source) {
                return new RunningServiceInfo(source);
            }
            public RunningServiceInfo[] newArray(int size) {
                return new RunningServiceInfo[size];
            }
        };
        
        public RunningServiceInfo createFromParcel(Parcel source) {
                return new RunningServiceInfo(source);
            }
        
        
        public RunningServiceInfo[] newArray(int size) {
                return new RunningServiceInfo[size];
            }
        
    }


    
    public static class MemoryInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.090 -0400", hash_original_field = "A881BE324808EBD1B87AA2B1BA15C73F", hash_generated_field = "E0A63B0ECBFDEA27BFA2BB9F80EC4972")

        public long availMem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.091 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "3AD4922D5CDF05DAE16A9D0357EE49D4")

        public long threshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.091 -0400", hash_original_field = "6EE91D8EF2E43AB5F55BD97D16635869", hash_generated_field = "89F0C9AF19D837FDB8D1580447013400")

        public boolean lowMemory;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.091 -0400", hash_original_field = "EB795083CACED746E6838A97949112F7", hash_generated_field = "47547EF5278B9404AA6B7A5D0AA184CF")

        public long hiddenAppThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.091 -0400", hash_original_field = "1366179F43BE6174CFADE53A285608CC", hash_generated_field = "FAF5E05BB790D37C3A76457DA8B44C8A")

        public long secondaryServerThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.091 -0400", hash_original_field = "CF68EA128EB80A4FBFF9F378B2803CE4", hash_generated_field = "EDF9D0A31FBE606DFDBA889793F7BAA8")

        public long visibleAppThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.091 -0400", hash_original_field = "0372204543482C679B3EC94B27134E3D", hash_generated_field = "400B18A3CE750D836C4243EC67DB5154")

        public long foregroundAppThreshold;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.092 -0400", hash_original_method = "09AE2D253AD01F5533857164DB70587D", hash_generated_method = "FF74B0D10914F28AB3E573FB192E254D")
        public  MemoryInfo() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.092 -0400", hash_original_method = "EAA33F4FBF3C878879D517CBC8FFA048", hash_generated_method = "D931D7EDEB60DF8546056BCA530CF0B7")
        private  MemoryInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.093 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FAA78BCA1E57292229E83609A6221B1E")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838263863 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838263863;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.094 -0400", hash_original_method = "F89D0A9B79191784D882D224AE236CD7", hash_generated_method = "0EAEE8ADC1B25D2228EA758BB11C4D91")
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
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.095 -0400", hash_original_method = "63344B29322BA9906ACD5F2C274D4AFB", hash_generated_method = "BC66AADD41130FA5D032784C56DC61C2")
        public void readFromParcel(Parcel source) {
            availMem = source.readLong();
            threshold = source.readLong();
            lowMemory = source.readInt() != 0;
            hiddenAppThreshold = source.readLong();
            secondaryServerThreshold = source.readLong();
            visibleAppThreshold = source.readLong();
            foregroundAppThreshold = source.readLong();
            
            
            
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.095 -0400", hash_original_field = "7B937244499DDD6DE8E8DD078A54CA42", hash_generated_field = "8D5A5BE61EBADDE649E9CD81EA9451BA")

        public static final Creator<MemoryInfo> CREATOR
                = new Creator<MemoryInfo>() {
            public MemoryInfo createFromParcel(Parcel source) {
                return new MemoryInfo(source);
            }
            public MemoryInfo[] newArray(int size) {
                return new MemoryInfo[size];
            }
        };
        
        public MemoryInfo createFromParcel(Parcel source) {
                return new MemoryInfo(source);
            }
        
        
        public MemoryInfo[] newArray(int size) {
                return new MemoryInfo[size];
            }
        
    }


    
    public static class ProcessErrorStateInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.095 -0400", hash_original_field = "3F9178C25B78ED8BED19091BCB62E266", hash_generated_field = "D12C7475F57008D4BAD02590CD186B34")

        public int condition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.096 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

        public String processName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.096 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.096 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.096 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

        public String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.096 -0400", hash_original_field = "A726C22E14A9C0DF4193537FB24D5DAF", hash_generated_field = "25D58ED094C8F824891E3926D1AD1DE0")

        public String shortMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.097 -0400", hash_original_field = "A31E91D860568FF036E728EC468229E1", hash_generated_field = "49D67D73AE5A1199A388FF4309BAA1C4")

        public String longMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.097 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "5AD16E48548E8F81D0DFF7F4F7B69945")

        public String stackTrace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.097 -0400", hash_original_field = "2F55CDAEC7168EE01704826F3CB21BF8", hash_generated_field = "4DE692F5BEA1FD9E7196CC9316DED961")

        public byte[] crashData = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.098 -0400", hash_original_method = "5ED73996FC5896C9F894604FFBFF8609", hash_generated_method = "3E55B7B14A298521D7B421AC3B025230")
        public  ProcessErrorStateInfo() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.099 -0400", hash_original_method = "94E8D1B421B7A163DD1B499E5670983F", hash_generated_method = "69D04C39525C6467D032D3938D2BA420")
        private  ProcessErrorStateInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.100 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6649B544D5A611A3201A51CB57A35E45")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412884851 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412884851;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.100 -0400", hash_original_method = "38EC9879A184B274D068BE64A2E942B7", hash_generated_method = "AA969BCC5C910D3517709C2EA0A9AB49")
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
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.101 -0400", hash_original_method = "7EE07760084269563BF2AEE27C9085AD", hash_generated_method = "6FF9C96E0672E5AF8E3073FD70A01A17")
        public void readFromParcel(Parcel source) {
            condition = source.readInt();
            processName = source.readString();
            pid = source.readInt();
            uid = source.readInt();
            tag = source.readString();
            shortMsg = source.readString();
            longMsg = source.readString();
            stackTrace = source.readString();
            
            
            
            
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.102 -0400", hash_original_field = "1B1949A508D4DA61D498C0A487C31F8F", hash_generated_field = "B8303B3F0D63DDF614BF107FEB77E81A")

        public static final int NO_ERROR = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.102 -0400", hash_original_field = "C842307260156DD524A8D7E2F162ACA3", hash_generated_field = "D6C8797DBA9046BA0CC1344E61A997BE")

        public static final int CRASHED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.102 -0400", hash_original_field = "67C3978F0F1FD3CF84AD70936693AE63", hash_generated_field = "2448698F79AC41420B9885070178CA3F")

        public static final int NOT_RESPONDING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.102 -0400", hash_original_field = "E578354A70C72AB1928323E0F806EC32", hash_generated_field = "B4E73E729A49A48B48C5C4D400C68AB6")

        public static final Creator<ProcessErrorStateInfo> CREATOR = 
                new Creator<ProcessErrorStateInfo>() {
            public ProcessErrorStateInfo createFromParcel(Parcel source) {
                return new ProcessErrorStateInfo(source);
            }
            public ProcessErrorStateInfo[] newArray(int size) {
                return new ProcessErrorStateInfo[size];
            }
        };
        
        public ProcessErrorStateInfo createFromParcel(Parcel source) {
                return new ProcessErrorStateInfo(source);
            }
        
        
        public ProcessErrorStateInfo[] newArray(int size) {
                return new ProcessErrorStateInfo[size];
            }
        
    }


    
    public static class RunningAppProcessInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.102 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

        public String processName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.103 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.103 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.103 -0400", hash_original_field = "91F81EBEC4F6E55EB9E1B725B7DEA854", hash_generated_field = "BC83CA44BBF502028F4847713C5A8FFF")

        public String pkgList[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.103 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

        public int flags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.103 -0400", hash_original_field = "7170F2678A3E108BAAC4FA8744F39743", hash_generated_field = "1C80947C985BAA8B2788455C14DF757E")

        public int importance;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.103 -0400", hash_original_field = "DBA3799464B52D8C7CE5446E998D2BD0", hash_generated_field = "935836E7F696020DF2282617A2CDE798")

        public int lru;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.104 -0400", hash_original_field = "179393AD83D5570C33B7F375CFD74B8C", hash_generated_field = "0640A813252163D85213DF91BD542354")

        public int importanceReasonCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.104 -0400", hash_original_field = "34F48A93A5B8ED84B9FC41D36732F609", hash_generated_field = "3F6331CE06F746B4BCE72993297280D9")

        public int importanceReasonPid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.104 -0400", hash_original_field = "F93D3851B3B84F3F0AA9FCDDEB568C55", hash_generated_field = "AB8C5FA34744BF22AFDA5ED2E8ACFB6B")

        public ComponentName importanceReasonComponent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.104 -0400", hash_original_field = "D3F6C4EF0BD40835CEE10C4FA0BC387E", hash_generated_field = "1CAAED6E0A748938FD5E5DBFF194111F")

        public int importanceReasonImportance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.105 -0400", hash_original_method = "037D75A14244F6412C20718AD220CDB7", hash_generated_method = "EBA9A2537661CB41AD3E24299B24227D")
        public  RunningAppProcessInfo() {
            importance = IMPORTANCE_FOREGROUND;
            importanceReasonCode = REASON_UNKNOWN;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.105 -0400", hash_original_method = "09307CF5135B482F1E6BA3C6F777D6D1", hash_generated_method = "BB2D23B80AE96EA10DC760D829F3AF98")
        public  RunningAppProcessInfo(String pProcessName, int pPid, String pArr[]) {
            processName = pProcessName;
            pid = pPid;
            pkgList = pArr;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.106 -0400", hash_original_method = "224713C5B1CB6C52B9BDAF058DA172D4", hash_generated_method = "D0964969E76FCC86D2A9723ABA5E1DB6")
        private  RunningAppProcessInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.107 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E070702521E0229CCC5D3CF3A0C1667B")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029133945 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029133945;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.107 -0400", hash_original_method = "DDF0D3D0D0B3E35B68DDE155F98679B3", hash_generated_method = "D95FCB59AC223F26DC609E55AC67081A")
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
            
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.109 -0400", hash_original_method = "41C420DA0EF6445C06E1F94D547B6411", hash_generated_method = "6CEE33DDD5B34CFCAE50871715C114F5")
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
            
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.110 -0400", hash_original_field = "0C516D85DC95E1D7DBD9453D10915D62", hash_generated_field = "1647EC87F14B5F86D8632AD2EF6C5824")

        public static final int FLAG_CANT_SAVE_STATE = 1<<0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.110 -0400", hash_original_field = "79ABBEDFF5172FB955837B0C1965363B", hash_generated_field = "9BC36C98B31AD9692879EF62506317FF")

        public static final int FLAG_PERSISTENT = 1<<1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.110 -0400", hash_original_field = "357C7469C019E384BE9CE5D00A1CF3AA", hash_generated_field = "7C08C761DEDE62BEC8E3019EE74226FD")

        public static final int IMPORTANCE_FOREGROUND = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.110 -0400", hash_original_field = "9D5CFDC69DF8BA78DFE40629C7097D1B", hash_generated_field = "97CEF1AC776B153D10A3107635843A21")

        public static final int IMPORTANCE_VISIBLE = 200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.111 -0400", hash_original_field = "54F856D70C0E57CD964573BE1DFFFA2C", hash_generated_field = "B7BB82F7798AA2A5C18FBB6185BB2314")

        public static final int IMPORTANCE_PERCEPTIBLE = 130;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.111 -0400", hash_original_field = "87D4522C595B475672D59B8C88ADA1DB", hash_generated_field = "92BC51E78DA32D79D62ACCE3A407504B")

        public static final int IMPORTANCE_CANT_SAVE_STATE = 170;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.111 -0400", hash_original_field = "C609A3A34C642445A2EC8D79DE86612E", hash_generated_field = "306ED1F4972465B2A3462F89635BFAEA")

        public static final int IMPORTANCE_SERVICE = 300;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.111 -0400", hash_original_field = "0E1619FDE106CDF39C943149380B9AC9", hash_generated_field = "07BEC37BDBA9E0367125D8904629A332")

        public static final int IMPORTANCE_BACKGROUND = 400;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.111 -0400", hash_original_field = "BE271B13E2E9B7D77301DCBADCD0495F", hash_generated_field = "3215C32A2347C30D0BEC8CBF9EE1DB8B")

        public static final int IMPORTANCE_EMPTY = 500;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.112 -0400", hash_original_field = "594C5172577F9EDBDC1FE8A52ADB4B96", hash_generated_field = "277DB1ED9D8523A313B00F353F323926")

        public static final int REASON_UNKNOWN = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.112 -0400", hash_original_field = "07B2AF54D6C2EBDCEEACEF8594720AF8", hash_generated_field = "0D2FAA89DE8DF8459E547156CCFB7D13")

        public static final int REASON_PROVIDER_IN_USE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.112 -0400", hash_original_field = "50D549146D67D3EB13EB6CC2884408FB", hash_generated_field = "6620F40FC4D40B586E72B275F99528E5")

        public static final int REASON_SERVICE_IN_USE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.112 -0400", hash_original_field = "961684DCD5DF2C909DB5D05DEB0CF60C", hash_generated_field = "A62C347FADB0FAEE0097CA208AB4C94F")

        public static final Creator<RunningAppProcessInfo> CREATOR = 
            new Creator<RunningAppProcessInfo>() {
            public RunningAppProcessInfo createFromParcel(Parcel source) {
                return new RunningAppProcessInfo(source);
            }
            public RunningAppProcessInfo[] newArray(int size) {
                return new RunningAppProcessInfo[size];
            }
        };
        
        public RunningAppProcessInfo createFromParcel(Parcel source) {
                return new RunningAppProcessInfo(source);
            }
        
        
        public RunningAppProcessInfo[] newArray(int size) {
                return new RunningAppProcessInfo[size];
            }
        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.112 -0400", hash_original_field = "ED9918AAF9E33787BD2314FF60B55E2B", hash_generated_field = "C1ACB3A50DAA45E925C793ECFC62F195")

    private static String TAG = "ActivityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.113 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.113 -0400", hash_original_field = "0AA6BCFB0349530FC4361F030D247674", hash_generated_field = "C16804AA577FC6CC8AED78F613B9B4A2")

    public static final int COMPAT_MODE_ALWAYS = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.113 -0400", hash_original_field = "E005DAD989D6069B7F9C2761E7745EB7", hash_generated_field = "E7F4E1704AC1CA2E7F7AB5C73B5CC1FC")

    public static final int COMPAT_MODE_NEVER = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.113 -0400", hash_original_field = "6D32C580C7B0B3047871A405BF7653A7", hash_generated_field = "E6FB0DE41BD13A12D8C1FD83A17A8386")

    public static final int COMPAT_MODE_UNKNOWN = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.113 -0400", hash_original_field = "27AD56F2D373DA988FA5050E60A92EFF", hash_generated_field = "2C263FE55B5A2E3B8C053FFD33D5C145")

    public static final int COMPAT_MODE_DISABLED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.113 -0400", hash_original_field = "E4387FDACCA273C42D06029AE9D72FC0", hash_generated_field = "E7FF3DAED2069A006F3DA08E24DB5234")

    public static final int COMPAT_MODE_ENABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.114 -0400", hash_original_field = "C5FCDF4F54877B0601FD28082CBA8A9E", hash_generated_field = "9091AED5EDF419D09EF4B705217D4E96")

    public static final int COMPAT_MODE_TOGGLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.114 -0400", hash_original_field = "0565BAD5E12D959BAF62D241FB1476D8", hash_generated_field = "2242B54F4B4FEE2151042282E6383BC1")

    public static final int RECENT_WITH_EXCLUDED = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.114 -0400", hash_original_field = "790CDBE1E611701E4AA2E21493F99FD1", hash_generated_field = "07C68D9E69886FCCDB7162A95AE039AB")

    public static final int RECENT_IGNORE_UNAVAILABLE = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.114 -0400", hash_original_field = "A539421EFFBB0F7BBACC7DDF8F4B1387", hash_generated_field = "F9D136F9AAF3BD2649A8DB3952F9FEFD")

    public static final int REMOVE_TASK_KILL_PROCESS = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.114 -0400", hash_original_field = "F00667FF1E3452F88502B375236D07BF", hash_generated_field = "F905711F81704086241D937BB8F72E15")

    public static final int MOVE_TASK_WITH_HOME = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:14.115 -0400", hash_original_field = "881212394691AFD32C931C74BC9A99C8", hash_generated_field = "C1B1346ED585E8734FB3050A443502A1")

    public static final int MOVE_TASK_NO_USER_ACTION = 0x00000002;
}

