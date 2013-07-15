package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.201 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.202 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.203 -0400", hash_original_method = "5B4171109A2201F1FE14E6225146AB80", hash_generated_method = "8ADD7487E2C46628C6CC7A69BA117746")
      ActivityManager(Context context, Handler handler) {
        mContext = context;
        mHandler = handler;
        // ---------- Original Method ----------
        //mContext = context;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.206 -0400", hash_original_method = "BCFF8F5D8C51374E31DC49464CB803A5", hash_generated_method = "AA511CEF284171E9C10FFB191DEB239E")
    public int getFrontActivityScreenCompatMode() {
        try 
        {
            int var85EC4FE60F2667A907857E134B9CFFC9_252034279 = (ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1212573128 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1212573128;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1378936871 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059314516 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059314516;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.207 -0400", hash_original_method = "1AD781893C5FA74DDB5BF5981AAFC282", hash_generated_method = "292FBFDB967E21EB4FA781B8ED2465D7")
    public void setFrontActivityScreenCompatMode(int mode) {
        addTaint(mode);
        try 
        {
            ActivityManagerNative.getDefault().setFrontActivityScreenCompatMode(mode);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setFrontActivityScreenCompatMode(mode);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.208 -0400", hash_original_method = "08DE0842CE89FB88CEE40B6F1F1D5D8A", hash_generated_method = "F6000083F5FBD2EAA7F0847C9C4AF02E")
    public int getPackageScreenCompatMode(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
            int var23AEDB3E6A7B06B005D0239E9297E556_1475301198 = (ActivityManagerNative.getDefault().getPackageScreenCompatMode(packageName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_441572553 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_441572553;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_213663100 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885074591 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885074591;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getPackageScreenCompatMode(packageName);
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.209 -0400", hash_original_method = "6272BC343B5B54EAA927E2C6A7A229FA", hash_generated_method = "6B35E24D2497A6B3C5FCDFCA33B241FB")
    public void setPackageScreenCompatMode(String packageName, int mode) {
        addTaint(mode);
        addTaint(packageName.getTaint());
        try 
        {
            ActivityManagerNative.getDefault().setPackageScreenCompatMode(packageName, mode);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setPackageScreenCompatMode(packageName, mode);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.210 -0400", hash_original_method = "43CD4547C63AA5BA08A4BB7431262A61", hash_generated_method = "04C52000C4176B1D11373F7EAE7F44A9")
    public boolean getPackageAskScreenCompat(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
            boolean var29565157EE07737BBE501363FB3E67D6_513480165 = (ActivityManagerNative.getDefault().getPackageAskScreenCompat(packageName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_482948718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_482948718;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1610722665 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_140448322 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_140448322;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getPackageAskScreenCompat(packageName);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.212 -0400", hash_original_method = "3BC1D3C0234B303E106B1ACB51D8D800", hash_generated_method = "BF4BDAD98F7D8D6BBA3D593620CA942F")
    public void setPackageAskScreenCompat(String packageName, boolean ask) {
        addTaint(ask);
        addTaint(packageName.getTaint());
        try 
        {
            ActivityManagerNative.getDefault().setPackageAskScreenCompat(packageName, ask);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setPackageAskScreenCompat(packageName, ask);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.213 -0400", hash_original_method = "B7DBD08AF6CFCEAABC628A74B78E8B6F", hash_generated_method = "65F1F61BA1D63FAE34A719959848CB56")
    public int getMemoryClass() {
        int var7C0269C7BF81D9BBC3B9645D88A1F7A4_1723630000 = (staticGetMemoryClass());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424601544 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424601544;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.214 -0400", hash_original_method = "50F084ADAAFF8EB942A9D9EB0C93D87F", hash_generated_method = "AD7AD349F5E78509D06B2B81DEB44B4A")
    public int getLargeMemoryClass() {
        int var58F00E58ADDE6235C0F80A2D83E9CE86_1543189660 = (staticGetLargeMemoryClass());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635804437 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635804437;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.219 -0400", hash_original_method = "F8BE7228FE8A06DB7E3F7EC0517EBE16", hash_generated_method = "21448B4FC808A70DA3FB68A26CA5F4DA")
    public List<RecentTaskInfo> getRecentTasks(int maxNum, int flags) throws SecurityException {
        addTaint(flags);
        addTaint(maxNum);
        try 
        {
List<RecentTaskInfo> var40137D8CC172F88C3474F80F31994E8E_1562909253 =             ActivityManagerNative.getDefault().getRecentTasks(maxNum,
                    flags);
            var40137D8CC172F88C3474F80F31994E8E_1562909253.addTaint(taint);
            return var40137D8CC172F88C3474F80F31994E8E_1562909253;
        } //End block
        catch (RemoteException e)
        {
List<RecentTaskInfo> var540C13E9E156B687226421B24F2DF178_1572507275 =             null;
            var540C13E9E156B687226421B24F2DF178_1572507275.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1572507275;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getRecentTasks(maxNum,
                    //flags);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.220 -0400", hash_original_method = "324273237D89470A473FD6EC5C103A40", hash_generated_method = "EAC4117DBA3D2F585ED6917FBD891A93")
    public List<RunningTaskInfo> getRunningTasks(int maxNum, int flags, IThumbnailReceiver receiver) throws SecurityException {
        addTaint(receiver.getTaint());
        addTaint(flags);
        addTaint(maxNum);
        try 
        {
List<RunningTaskInfo> varFA1868C6A28ADCCCB0AC54F8108500C3_1870493029 =             ActivityManagerNative.getDefault().getTasks(maxNum, flags, receiver);
            varFA1868C6A28ADCCCB0AC54F8108500C3_1870493029.addTaint(taint);
            return varFA1868C6A28ADCCCB0AC54F8108500C3_1870493029;
        } //End block
        catch (RemoteException e)
        {
List<RunningTaskInfo> var540C13E9E156B687226421B24F2DF178_298061906 =             null;
            var540C13E9E156B687226421B24F2DF178_298061906.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_298061906;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getTasks(maxNum, flags, receiver);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.221 -0400", hash_original_method = "048E08D6499B0F81FA41B243F96225CE", hash_generated_method = "18C301EC432D22FFE3973087F40867A2")
    public List<RunningTaskInfo> getRunningTasks(int maxNum) throws SecurityException {
        addTaint(maxNum);
List<RunningTaskInfo> varF494B0EB5A0A149E15717B260CBB12D0_534902339 =         getRunningTasks(maxNum, 0, null);
        varF494B0EB5A0A149E15717B260CBB12D0_534902339.addTaint(taint);
        return varF494B0EB5A0A149E15717B260CBB12D0_534902339;
        // ---------- Original Method ----------
        //return getRunningTasks(maxNum, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.222 -0400", hash_original_method = "06417D4703E772AA57E4535D9CA52E2C", hash_generated_method = "6C180204EDB2C501C018113F0660D97D")
    public boolean removeSubTask(int taskId, int subTaskIndex) throws SecurityException {
        addTaint(subTaskIndex);
        addTaint(taskId);
        try 
        {
            boolean var197D5FC761D0A9B06C5DC41514936305_1665605511 = (ActivityManagerNative.getDefault().removeSubTask(taskId, subTaskIndex));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1051855515 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1051855515;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1237912855 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1898480350 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1898480350;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().removeSubTask(taskId, subTaskIndex);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.223 -0400", hash_original_method = "B1BB833FCE4ABF3667361FA6F055417F", hash_generated_method = "86EEACDFFB697D364DA76B3F6FBAB8F4")
    public boolean removeTask(int taskId, int flags) throws SecurityException {
        addTaint(flags);
        addTaint(taskId);
        try 
        {
            boolean varEB7E295219F88B8C13298587B70564E5_1932286576 = (ActivityManagerNative.getDefault().removeTask(taskId, flags));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_910270796 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_910270796;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1309388095 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1142995762 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1142995762;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().removeTask(taskId, flags);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.225 -0400", hash_original_method = "90A15739ABCD71E20C2601B2E690D2DC", hash_generated_method = "4C2797F0CB67B242F320F9F41366BB94")
    public TaskThumbnails getTaskThumbnails(int id) throws SecurityException {
        addTaint(id);
        try 
        {
TaskThumbnails varA77DEACFE74A359C0B0FFF07C1CD80A1_513824525 =             ActivityManagerNative.getDefault().getTaskThumbnails(id);
            varA77DEACFE74A359C0B0FFF07C1CD80A1_513824525.addTaint(taint);
            return varA77DEACFE74A359C0B0FFF07C1CD80A1_513824525;
        } //End block
        catch (RemoteException e)
        {
TaskThumbnails var540C13E9E156B687226421B24F2DF178_2134908251 =             null;
            var540C13E9E156B687226421B24F2DF178_2134908251.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2134908251;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getTaskThumbnails(id);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.226 -0400", hash_original_method = "68F3ECC95EA33C5EF7CED37FFBD163D9", hash_generated_method = "EF3FB2E2720982B73392D591C9C21199")
    public void moveTaskToFront(int taskId, int flags) {
        addTaint(flags);
        addTaint(taskId);
        try 
        {
            ActivityManagerNative.getDefault().moveTaskToFront(taskId, flags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().moveTaskToFront(taskId, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.229 -0400", hash_original_method = "93643A575557EDD801C5647B318BA97A", hash_generated_method = "1A56244082545AF0FF6BD0B2A106EAFA")
    public List<RunningServiceInfo> getRunningServices(int maxNum) throws SecurityException {
        addTaint(maxNum);
        try 
        {
List<RunningServiceInfo> varD378F9DE7055085E8F272534A9235CD7_1503561655 =             ActivityManagerNative.getDefault()
                    .getServices(maxNum, 0);
            varD378F9DE7055085E8F272534A9235CD7_1503561655.addTaint(taint);
            return varD378F9DE7055085E8F272534A9235CD7_1503561655;
        } //End block
        catch (RemoteException e)
        {
List<RunningServiceInfo> var540C13E9E156B687226421B24F2DF178_190884002 =             null;
            var540C13E9E156B687226421B24F2DF178_190884002.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_190884002;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                    //.getServices(maxNum, 0);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.230 -0400", hash_original_method = "3F37B5EEA2E0ADFF7012B4DB8D3BC71C", hash_generated_method = "10AA30611EF1A2AFFDFF6BA67D081CD0")
    public PendingIntent getRunningServiceControlPanel(ComponentName service) throws SecurityException {
        addTaint(service.getTaint());
        try 
        {
PendingIntent var213DD055D20310587F04A5D1E46185E0_994135193 =             ActivityManagerNative.getDefault()
                    .getRunningServiceControlPanel(service);
            var213DD055D20310587F04A5D1E46185E0_994135193.addTaint(taint);
            return var213DD055D20310587F04A5D1E46185E0_994135193;
        } //End block
        catch (RemoteException e)
        {
PendingIntent var540C13E9E156B687226421B24F2DF178_426205698 =             null;
            var540C13E9E156B687226421B24F2DF178_426205698.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_426205698;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                    //.getRunningServiceControlPanel(service);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.231 -0400", hash_original_method = "B6E6E4E46821E411AC60EE30A7424576", hash_generated_method = "EDAA90C91D42C8F58DED2EFAE6FC74E1")
    public void getMemoryInfo(MemoryInfo outInfo) {
        addTaint(outInfo.getTaint());
        try 
        {
            ActivityManagerNative.getDefault().getMemoryInfo(outInfo);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().getMemoryInfo(outInfo);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.236 -0400", hash_original_method = "F72074CE1B364F8B93C8BBDF31501500", hash_generated_method = "F36465ED1AB159D281335AAC823BBB65")
    public boolean clearApplicationUserData(String packageName, IPackageDataObserver observer) {
        addTaint(observer.getTaint());
        addTaint(packageName.getTaint());
        try 
        {
            boolean varF319C6EC0A38457C9A3E1D4EE569429B_1445504234 = (ActivityManagerNative.getDefault().clearApplicationUserData(packageName, 
                    observer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_214271346 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_214271346;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1851206584 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_569210911 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_569210911;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().clearApplicationUserData(packageName, 
                    //observer);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.247 -0400", hash_original_method = "F53E97F522CAE83DA0CBCF957085AF2C", hash_generated_method = "6AC2BF3865D7D57BC05863EBEA01D575")
    public List<ProcessErrorStateInfo> getProcessesInErrorState() {
        try 
        {
List<ProcessErrorStateInfo> var46705B02D2781B280397912B487DB235_968323652 =             ActivityManagerNative.getDefault().getProcessesInErrorState();
            var46705B02D2781B280397912B487DB235_968323652.addTaint(taint);
            return var46705B02D2781B280397912B487DB235_968323652;
        } //End block
        catch (RemoteException e)
        {
List<ProcessErrorStateInfo> var540C13E9E156B687226421B24F2DF178_1676101965 =             null;
            var540C13E9E156B687226421B24F2DF178_1676101965.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1676101965;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getProcessesInErrorState();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.255 -0400", hash_original_method = "5737B6241A3389A78D86162B5C5BDB02", hash_generated_method = "A5ABCA3368F5BBFFBD49B1E88A26A473")
    public List<ApplicationInfo> getRunningExternalApplications() {
        try 
        {
List<ApplicationInfo> var9D8ED15C0618F5471391B2043D92D50B_832243729 =             ActivityManagerNative.getDefault().getRunningExternalApplications();
            var9D8ED15C0618F5471391B2043D92D50B_832243729.addTaint(taint);
            return var9D8ED15C0618F5471391B2043D92D50B_832243729;
        } //End block
        catch (RemoteException e)
        {
List<ApplicationInfo> var540C13E9E156B687226421B24F2DF178_813140419 =             null;
            var540C13E9E156B687226421B24F2DF178_813140419.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_813140419;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getRunningExternalApplications();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.262 -0400", hash_original_method = "BB41AA7EC02A452F0653300FBA1EFF8A", hash_generated_method = "95B24944A650E4126F006C50060C7E3F")
    public List<RunningAppProcessInfo> getRunningAppProcesses() {
        try 
        {
List<RunningAppProcessInfo> varCD0D34372A7CD13D7400312057BCAF26_205683906 =             ActivityManagerNative.getDefault().getRunningAppProcesses();
            varCD0D34372A7CD13D7400312057BCAF26_205683906.addTaint(taint);
            return varCD0D34372A7CD13D7400312057BCAF26_205683906;
        } //End block
        catch (RemoteException e)
        {
List<RunningAppProcessInfo> var540C13E9E156B687226421B24F2DF178_393423956 =             null;
            var540C13E9E156B687226421B24F2DF178_393423956.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_393423956;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getRunningAppProcesses();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.264 -0400", hash_original_method = "BA29C29542BF4FC0E2178C81FA222823", hash_generated_method = "6EBE165818C10BB8B4E96ECE4309B8E0")
    public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) {
        addTaint(pids[0]);
        try 
        {
Debug.MemoryInfo[] varE9F2BC2BE5672A709A377F37802908A3_363889354 =             ActivityManagerNative.getDefault().getProcessMemoryInfo(pids);
            varE9F2BC2BE5672A709A377F37802908A3_363889354.addTaint(taint);
            return varE9F2BC2BE5672A709A377F37802908A3_363889354;
        } //End block
        catch (RemoteException e)
        {
Debug.MemoryInfo[] var540C13E9E156B687226421B24F2DF178_1026233107 =             null;
            var540C13E9E156B687226421B24F2DF178_1026233107.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1026233107;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getProcessMemoryInfo(pids);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.265 -0400", hash_original_method = "AB97F58AF8359C056EB136FA16E11328", hash_generated_method = "7475D0571E9FBA018F9BE0E931453FCB")
    @Deprecated
    public void restartPackage(String packageName) {
        addTaint(packageName.getTaint());
        killBackgroundProcesses(packageName);
        // ---------- Original Method ----------
        //killBackgroundProcesses(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.266 -0400", hash_original_method = "BAC028425422747AF2B8DB952F37E411", hash_generated_method = "025D332FF4406CA1D91600CD071FBB8F")
    public void killBackgroundProcesses(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
            ActivityManagerNative.getDefault().killBackgroundProcesses(packageName);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().killBackgroundProcesses(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.268 -0400", hash_original_method = "F30C6D9D6BE88E1DA2EC5D39F1D44538", hash_generated_method = "287707A9A0DA54CC140E51562378BA12")
    public void forceStopPackage(String packageName) {
        addTaint(packageName.getTaint());
        try 
        {
            ActivityManagerNative.getDefault().forceStopPackage(packageName);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().forceStopPackage(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.270 -0400", hash_original_method = "002CA49339A7476A8E8EF41ECCC37BDD", hash_generated_method = "69396D63FA55B69FF87A80ED2805DF28")
    public ConfigurationInfo getDeviceConfigurationInfo() {
        try 
        {
ConfigurationInfo var1BEBC3AD422C2B2DC4AFB98E2ED25E8C_199126559 =             ActivityManagerNative.getDefault().getDeviceConfigurationInfo();
            var1BEBC3AD422C2B2DC4AFB98E2ED25E8C_199126559.addTaint(taint);
            return var1BEBC3AD422C2B2DC4AFB98E2ED25E8C_199126559;
        } //End block
        catch (RemoteException e)
        {
        } //End block
ConfigurationInfo var540C13E9E156B687226421B24F2DF178_379805851 =         null;
        var540C13E9E156B687226421B24F2DF178_379805851.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_379805851;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getDeviceConfigurationInfo();
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.278 -0400", hash_original_method = "E6A8DEADBC97DC6A083D1FDDD3BF2E4E", hash_generated_method = "D327A2EF841210C8A7434F620554D314")
    public int getLauncherLargeIconDensity() {
        final Resources res = mContext.getResources();
        final int density = res.getDisplayMetrics().densityDpi;
    if((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE)        
        {
            int var35F3675343000D6BB5F10CE451A571A4_1591904123 = (density);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627482855 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627482855;
        } //End block
switch(density){
        case DisplayMetrics.DENSITY_LOW:
        int var658F3F952DCB16846B62366921BBE33F_1727367999 = (DisplayMetrics.DENSITY_MEDIUM);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205391294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205391294;
        case DisplayMetrics.DENSITY_MEDIUM:
        int varF85677EE4FC90D9415BA584A3AAD03B8_1338004153 = (DisplayMetrics.DENSITY_HIGH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652106683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652106683;
        case DisplayMetrics.DENSITY_HIGH:
        int varDFD5BAE37BC96891DBCCDB8FC8C34272_1224204143 = (DisplayMetrics.DENSITY_XHIGH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885404351 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885404351;
        case DisplayMetrics.DENSITY_XHIGH:
        int varB3B59E59C087E34E4AA96DD124782E0A_925014659 = (DisplayMetrics.DENSITY_MEDIUM * 2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_757059469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_757059469;
        default:
        int var35F3675343000D6BB5F10CE451A571A4_1307849489 = (density);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372836626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372836626;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.283 -0400", hash_original_method = "1ABECD33DDCEDD9654A62357CF29D109", hash_generated_method = "EC3419D7C670C83B1EEAFE888DD0BD0F")
    public int getLauncherLargeIconSize() {
        final Resources res = mContext.getResources();
        final int size = res.getDimensionPixelSize(android.R.dimen.app_icon_size);
    if((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE)        
        {
            int varF7BD60B75B29D79B660A2859395C1A24_653702990 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088458959 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088458959;
        } //End block
        final int density = res.getDisplayMetrics().densityDpi;
switch(density){
        case DisplayMetrics.DENSITY_LOW:
        int var12072AAB162715CBE00627C5F898A4E2_2111776756 = ((size * DisplayMetrics.DENSITY_MEDIUM) / DisplayMetrics.DENSITY_LOW);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_172218778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_172218778;
        case DisplayMetrics.DENSITY_MEDIUM:
        int var9E7E64BD11E4D3E5D090C0FD3849DC4D_680867235 = ((size * DisplayMetrics.DENSITY_HIGH) / DisplayMetrics.DENSITY_MEDIUM);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790983252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790983252;
        case DisplayMetrics.DENSITY_HIGH:
        int var5C287EF8B6D718FCC647715D139815A4_279919328 = ((size * DisplayMetrics.DENSITY_XHIGH) / DisplayMetrics.DENSITY_HIGH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261989457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261989457;
        case DisplayMetrics.DENSITY_XHIGH:
        int var63BEBD4D6EC34F99096E2C9B72AA71F2_1048218282 = ((size * DisplayMetrics.DENSITY_MEDIUM * 2) / DisplayMetrics.DENSITY_XHIGH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293899520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293899520;
        default:
        int varF7BD60B75B29D79B660A2859395C1A24_1578714334 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81487832 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81487832;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.287 -0400", hash_original_method = "2575FA7FD2518D90A93FBC6E066D35C1", hash_generated_method = "F0845CB8D9B1D1B3BF0F82214B353F78")
    public Map<String, Integer> getAllPackageLaunchCounts() {
        try 
        {
            IUsageStats usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
    if(usageStatsService == null)            
            {
Map<String, Integer> var7084C1AAB31A68AB6122451D4464DD6B_1983318254 =                 new HashMap<String, Integer>();
                var7084C1AAB31A68AB6122451D4464DD6B_1983318254.addTaint(taint);
                return var7084C1AAB31A68AB6122451D4464DD6B_1983318254;
            } //End block
            PkgUsageStats[] allPkgUsageStats = usageStatsService.getAllPkgUsageStats();
    if(allPkgUsageStats == null)            
            {
Map<String, Integer> var7084C1AAB31A68AB6122451D4464DD6B_402245011 =                 new HashMap<String, Integer>();
                var7084C1AAB31A68AB6122451D4464DD6B_402245011.addTaint(taint);
                return var7084C1AAB31A68AB6122451D4464DD6B_402245011;
            } //End block
            Map<String, Integer> launchCounts = new HashMap<String, Integer>();
for(PkgUsageStats pkgUsageStats : allPkgUsageStats)
            {
                launchCounts.put(pkgUsageStats.packageName, pkgUsageStats.launchCount);
            } //End block
Map<String, Integer> varE4AEB0B82BEBF7B4317AD5BD2009A8A3_1797754675 =             launchCounts;
            varE4AEB0B82BEBF7B4317AD5BD2009A8A3_1797754675.addTaint(taint);
            return varE4AEB0B82BEBF7B4317AD5BD2009A8A3_1797754675;
        } //End block
        catch (RemoteException e)
        {
Map<String, Integer> var7084C1AAB31A68AB6122451D4464DD6B_683334250 =             new HashMap<String, Integer>();
            var7084C1AAB31A68AB6122451D4464DD6B_683334250.addTaint(taint);
            return var7084C1AAB31A68AB6122451D4464DD6B_683334250;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.288 -0400", hash_original_method = "97D195D4FE7E8BCA1AFB9969B53F0E5E", hash_generated_method = "C71A7A08A4CC6D227AA51AD2C32916B2")
    public PkgUsageStats[] getAllPackageUsageStats() {
        try 
        {
            IUsageStats usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
    if(usageStatsService != null)            
            {
PkgUsageStats[] varF2054C496D383FD188971744EC896BCE_489341364 =                 usageStatsService.getAllPkgUsageStats();
                varF2054C496D383FD188971744EC896BCE_489341364.addTaint(taint);
                return varF2054C496D383FD188971744EC896BCE_489341364;
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
PkgUsageStats[] var381BAFB9B44AE92A1ACB9C805E12C8FF_1888856451 =         new PkgUsageStats[0];
        var381BAFB9B44AE92A1ACB9C805E12C8FF_1888856451.addTaint(taint);
        return var381BAFB9B44AE92A1ACB9C805E12C8FF_1888856451;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.290 -0400", hash_original_method = "5F692D6C0F0BEC319B49459A73599D4B", hash_generated_method = "9D49C9AF1E3AB3A1688617DB4C1C114D")
    public boolean switchUser(int userid) {
        addTaint(userid);
        try 
        {
            boolean var808AE75FB1C3653CD6B7ED2E21C574EE_1374091289 = (ActivityManagerNative.getDefault().switchUser(userid));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_797622400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_797622400;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1784291844 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21849700 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_21849700;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().switchUser(userid);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    public static class RecentTaskInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.292 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.293 -0400", hash_original_field = "4C2CDFF3CA319DD68A3483A4CF59EA28", hash_generated_field = "45FD448AF1C8BBB4AAEF0A2F3C76D8D5")

        public int persistentId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.293 -0400", hash_original_field = "5516160C4AFEB3607228EDA7CF505DA4", hash_generated_field = "19F03161095B5D5B4369A44839D909E6")

        public Intent baseIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.293 -0400", hash_original_field = "50B95CD9B73499236EB8892142F4BF6E", hash_generated_field = "33781CF46949A55BB10919B7C8D1FCE2")

        public ComponentName origActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.294 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "D2E00B0C52A0AFC2C3ECD84ACC639853")

        public CharSequence description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.294 -0400", hash_original_method = "C08B7337C6B109635FE340903513A97B", hash_generated_method = "3151CC50C901E54C1039F8A4558613C1")
        public  RecentTaskInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.295 -0400", hash_original_method = "1CABC845DDD8B9A1DEC9FF64F1615AFC", hash_generated_method = "47D9225FEE8F336C7E29D5C271D528EF")
        private  RecentTaskInfo(Parcel source) {
            addTaint(source.getTaint());
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.296 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2E400E1EAA5D5D443FCDFF35C1611995")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_247624941 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027453082 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027453082;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.297 -0400", hash_original_method = "A024AE935060D48D15B6110668C59DDF", hash_generated_method = "321882FE2925192DA8F2604DA4ADFD84")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeInt(id);
            dest.writeInt(persistentId);
    if(baseIntent != null)            
            {
                dest.writeInt(1);
                baseIntent.writeToParcel(dest, 0);
            } //End block
            else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.299 -0400", hash_original_method = "F67217ABAEC36040C8F444901EE65BC8", hash_generated_method = "737445A4B4398911F8EE4077C7D15577")
        public void readFromParcel(Parcel source) {
            id = source.readInt();
            persistentId = source.readInt();
    if(source.readInt() != 0)            
            {
                baseIntent = Intent.CREATOR.createFromParcel(source);
            } //End block
            else
            {
                baseIntent = null;
            } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.301 -0400", hash_original_field = "DA99927A07743B1B8E96157497F59A82", hash_generated_field = "144243CA012A4B8ABF03F2F1B5702AF7")

        public static final Creator<RecentTaskInfo> CREATOR
                = new Creator<RecentTaskInfo>() {
            public RecentTaskInfo createFromParcel(Parcel source) {
                return new RecentTaskInfo(source);
            }
            public RecentTaskInfo[] newArray(int size) {
                return new RecentTaskInfo[size];
            }
        };
        // orphaned legacy method
        public RecentTaskInfo createFromParcel(Parcel source) {
                return new RecentTaskInfo(source);
            }
        
        // orphaned legacy method
        public RecentTaskInfo[] newArray(int size) {
                return new RecentTaskInfo[size];
            }
        
    }


    
    public static class RunningTaskInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.305 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.306 -0400", hash_original_field = "F6CEE472EAA2684591EBF9247DDF7CD8", hash_generated_field = "706934E85A3C10660FC2C5B7806ED0A6")

        public ComponentName baseActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.307 -0400", hash_original_field = "754F1F12013FFC78FF843281317AD0A9", hash_generated_field = "E1E2B3D4624F0E478C8CD581F117A622")

        public ComponentName topActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.308 -0400", hash_original_field = "951D4DFF3C22E9FCC4A2707009F45EA8", hash_generated_field = "78966E97EF5212F19E857E6A323EA39E")

        public Bitmap thumbnail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.309 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "D2E00B0C52A0AFC2C3ECD84ACC639853")

        public CharSequence description;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.309 -0400", hash_original_field = "94FBBA8E700FC03C18CC3D15C947FAE5", hash_generated_field = "4C423F6359C67873078893E7E4F87908")

        public int numActivities;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.310 -0400", hash_original_field = "8C7843D564F548CECBC331DDEA9E6A6F", hash_generated_field = "76E787CD7EF42C186801DE136C1FAB80")

        public int numRunning;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.311 -0400", hash_original_method = "6DA0A8D9CEF41C0CB91D2D95D7E71D44", hash_generated_method = "00FB201893D0BF493904CEE004049E1E")
        public  RunningTaskInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.312 -0400", hash_original_method = "A0900FA369CFAE0B339B23849E0D0E54", hash_generated_method = "5D09BFF719877D9B50931091352F4493")
        private  RunningTaskInfo(Parcel source) {
            addTaint(source.getTaint());
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.313 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2D9C98A71D6D0287A8F3D6239C790B07")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_650137635 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545254515 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545254515;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.315 -0400", hash_original_method = "224D236A6A210D9CABF5D7D423C96E97", hash_generated_method = "3FBD53DC6DEC0BF6D2B6B899EA7DF3FA")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeInt(id);
            ComponentName.writeToParcel(baseActivity, dest);
            ComponentName.writeToParcel(topActivity, dest);
    if(thumbnail != null)            
            {
                dest.writeInt(1);
                thumbnail.writeToParcel(dest, 0);
            } //End block
            else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.319 -0400", hash_original_method = "1A58A87C00619395DA7F7A454E1E03D5", hash_generated_method = "923FADAABBFA979BD57174D14049CF75")
        public void readFromParcel(Parcel source) {
            id = source.readInt();
            baseActivity = ComponentName.readFromParcel(source);
            topActivity = ComponentName.readFromParcel(source);
    if(source.readInt() != 0)            
            {
                thumbnail = Bitmap.CREATOR.createFromParcel(source);
            } //End block
            else
            {
                thumbnail = null;
            } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.320 -0400", hash_original_field = "B9911C96575F25BA7EB7A3422AE8B6F1", hash_generated_field = "8DCFCF5E1FAAD8B612615CB5CB186FEC")

        public static final Creator<RunningTaskInfo> CREATOR = new Creator<RunningTaskInfo>() {
            public RunningTaskInfo createFromParcel(Parcel source) {
                return new RunningTaskInfo(source);
            }
            public RunningTaskInfo[] newArray(int size) {
                return new RunningTaskInfo[size];
            }
        };
        // orphaned legacy method
        public RunningTaskInfo createFromParcel(Parcel source) {
                return new RunningTaskInfo(source);
            }
        
        // orphaned legacy method
        public RunningTaskInfo[] newArray(int size) {
                return new RunningTaskInfo[size];
            }
        
    }


    
    public static class TaskThumbnails implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.322 -0400", hash_original_field = "A04B656670F0FC97E22C1CDFD7F3E1C2", hash_generated_field = "5F56FA9AC5C1789807151046ACFA6F30")

        public Bitmap mainThumbnail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.323 -0400", hash_original_field = "E8B61C2BAEABE799CF0E0D2E9C2E9DBA", hash_generated_field = "B493724A74ED3FB14A03B4D585258CEB")

        public int numSubThumbbails;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.323 -0400", hash_original_field = "36DDD37AE3EA18F3B624E48455871F81", hash_generated_field = "F26B03B078059BC2048093DDC93DD417")

        public IThumbnailRetriever retriever;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.324 -0400", hash_original_method = "EB2263C71F650A09D4909FB1B34C782F", hash_generated_method = "1036CA739667021DAECAC8857E8C6B4B")
        public  TaskThumbnails() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.324 -0400", hash_original_method = "0FEFA86B10CDE25FCF4328B39BD2F7D5", hash_generated_method = "B84CE83BF37AAE2D5444DEDF5AEBF090")
        private  TaskThumbnails(Parcel source) {
            addTaint(source.getTaint());
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.325 -0400", hash_original_method = "C8A1C6791C443D43BB18F989CA6219B6", hash_generated_method = "20057F8AC2021F627556FDF078025FC4")
        public Bitmap getSubThumbnail(int index) {
            addTaint(index);
            try 
            {
Bitmap var769843AE8CBBC01E399CD067844F9A42_808441125 =                 retriever.getThumbnail(index);
                var769843AE8CBBC01E399CD067844F9A42_808441125.addTaint(taint);
                return var769843AE8CBBC01E399CD067844F9A42_808441125;
            } //End block
            catch (RemoteException e)
            {
Bitmap var540C13E9E156B687226421B24F2DF178_475369158 =                 null;
                var540C13E9E156B687226421B24F2DF178_475369158.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_475369158;
            } //End block
            // ---------- Original Method ----------
            //try {
                //return retriever.getThumbnail(index);
            //} catch (RemoteException e) {
                //return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.326 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BC6F03A1818D82FB21DED0A509ECAC1B")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_2084835252 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253424922 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253424922;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.327 -0400", hash_original_method = "1641949793D35FD49D0AD46DB3E00603", hash_generated_method = "649E474CF53A49C585B6D248D5F44E31")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
    if(mainThumbnail != null)            
            {
                dest.writeInt(1);
                mainThumbnail.writeToParcel(dest, 0);
            } //End block
            else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.328 -0400", hash_original_method = "19A7C144CCAE5CD51406B760DF512EA1", hash_generated_method = "1C64A9953DE77D495AC2AFE2E389DEB7")
        public void readFromParcel(Parcel source) {
    if(source.readInt() != 0)            
            {
                mainThumbnail = Bitmap.CREATOR.createFromParcel(source);
            } //End block
            else
            {
                mainThumbnail = null;
            } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.329 -0400", hash_original_field = "4F6854EC28C10C68ABB672C395CA9C17", hash_generated_field = "A7CA2C3264BCA3B8EB9304642C9D25D2")

        public static final Creator<TaskThumbnails> CREATOR = new Creator<TaskThumbnails>() {
            public TaskThumbnails createFromParcel(Parcel source) {
                return new TaskThumbnails(source);
            }
            public TaskThumbnails[] newArray(int size) {
                return new TaskThumbnails[size];
            }
        };
        // orphaned legacy method
        public TaskThumbnails createFromParcel(Parcel source) {
                return new TaskThumbnails(source);
            }
        
        // orphaned legacy method
        public TaskThumbnails[] newArray(int size) {
                return new TaskThumbnails[size];
            }
        
    }


    
    public static class RunningServiceInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.330 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "7437D6C257B93451B3453DAF54B89FA5")

        public ComponentName service;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.331 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.331 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.332 -0400", hash_original_field = "5075140835D0BC504791C76B04C33D2B", hash_generated_field = "5CB999C89045E47AAA039EC43EA8EFD0")

        public String process;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.332 -0400", hash_original_field = "0FA009A743944A032EB54727ACEC48D6", hash_generated_field = "C92541C3D7058FCBBE46B97331B1DC61")

        public boolean foreground;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.333 -0400", hash_original_field = "2D46EB4EB6B83A1C450824B45B32C27A", hash_generated_field = "97CA36905CF396E537D491E932056860")

        public long activeSince;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.334 -0400", hash_original_field = "3BEBB2F89180B03FA5AE736665F648D9", hash_generated_field = "C0D67C1D1506D281491B9E92F436947F")

        public boolean started;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.334 -0400", hash_original_field = "CBA189F1D71714C066EA167B8A6AB3F5", hash_generated_field = "D21158F500DD41CD27566BC52C1CC2A3")

        public int clientCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.334 -0400", hash_original_field = "FCE2B0B390C578D2C38F670A9DD71E31", hash_generated_field = "14132D33689AF670E5EB24E340EA0A1A")

        public int crashCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.334 -0400", hash_original_field = "56991C1B63E5D7315D12B164F548278C", hash_generated_field = "126A413BC4E906D9E97E7626D6F4396F")

        public long lastActivityTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.335 -0400", hash_original_field = "A96E39B0C2CE86E83FEC80D073185ED0", hash_generated_field = "86B8197832B5D22734B4FAA009117212")

        public long restarting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.335 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

        public int flags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.335 -0400", hash_original_field = "9C3D569D866B7814BCD25623021A8F08", hash_generated_field = "EB1A871976ECAE165274E12319BA7914")

        public String clientPackage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.336 -0400", hash_original_field = "079D8F063684CAF3DDEEC8873031178D", hash_generated_field = "E322FF71A4FA039913D2A08C5BB78D14")

        public int clientLabel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.336 -0400", hash_original_method = "621426751430068D32289E518662756C", hash_generated_method = "822CEFC1BD8FA9077CAB00884D317765")
        public  RunningServiceInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.337 -0400", hash_original_method = "35E5A4903D7EB9EB66480EDFA6F47A72", hash_generated_method = "3641BE45D7DAED064DD09C2DF3D77E02")
        private  RunningServiceInfo(Parcel source) {
            addTaint(source.getTaint());
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.337 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "183C421E6BA130834990AE25991BCFC2")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1471210936 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108379696 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108379696;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.338 -0400", hash_original_method = "048D37EC670A88D2663FCC084087D5E3", hash_generated_method = "DC89A843B04BF96AEC3880A7C3A6139E")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.342 -0400", hash_original_method = "264C3E4C1DAB76B38CA08CE45829A86C", hash_generated_method = "DD78297D77B49BEF3DC4CE1566C885A4")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.344 -0400", hash_original_field = "6D9DB860035C68DDD8F2027972602A14", hash_generated_field = "C5EE28BB616EBCBE67B4A8F8CA4F4F8C")

        public static final int FLAG_STARTED = 1<<0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.344 -0400", hash_original_field = "D87893D0147F0F1E098475CAC202BBF2", hash_generated_field = "829940B23BDE846C789CE2452F9F2213")

        public static final int FLAG_FOREGROUND = 1<<1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.345 -0400", hash_original_field = "5B5C76863E4B1F71B19824790CDBF7E5", hash_generated_field = "A8B50094DCEC06B9ED9EBA4201DB4EF0")

        public static final int FLAG_SYSTEM_PROCESS = 1<<2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.345 -0400", hash_original_field = "888DD4FCC0586AC0A3A963599166EC86", hash_generated_field = "BA474CA4A54C5FFAAAC838F19039B567")

        public static final int FLAG_PERSISTENT_PROCESS = 1<<3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.345 -0400", hash_original_field = "AD64936DA7390A375DCEFDC8BEB2A286", hash_generated_field = "45AB20E66E709306D076BBEB8007B79C")

        public static final Creator<RunningServiceInfo> CREATOR = new Creator<RunningServiceInfo>() {
            public RunningServiceInfo createFromParcel(Parcel source) {
                return new RunningServiceInfo(source);
            }
            public RunningServiceInfo[] newArray(int size) {
                return new RunningServiceInfo[size];
            }
        };
        // orphaned legacy method
        public RunningServiceInfo createFromParcel(Parcel source) {
                return new RunningServiceInfo(source);
            }
        
        // orphaned legacy method
        public RunningServiceInfo[] newArray(int size) {
                return new RunningServiceInfo[size];
            }
        
    }


    
    public static class MemoryInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.346 -0400", hash_original_field = "A881BE324808EBD1B87AA2B1BA15C73F", hash_generated_field = "E0A63B0ECBFDEA27BFA2BB9F80EC4972")

        public long availMem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.346 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "3AD4922D5CDF05DAE16A9D0357EE49D4")

        public long threshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.347 -0400", hash_original_field = "6EE91D8EF2E43AB5F55BD97D16635869", hash_generated_field = "89F0C9AF19D837FDB8D1580447013400")

        public boolean lowMemory;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.347 -0400", hash_original_field = "EB795083CACED746E6838A97949112F7", hash_generated_field = "47547EF5278B9404AA6B7A5D0AA184CF")

        public long hiddenAppThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.347 -0400", hash_original_field = "1366179F43BE6174CFADE53A285608CC", hash_generated_field = "FAF5E05BB790D37C3A76457DA8B44C8A")

        public long secondaryServerThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.348 -0400", hash_original_field = "CF68EA128EB80A4FBFF9F378B2803CE4", hash_generated_field = "EDF9D0A31FBE606DFDBA889793F7BAA8")

        public long visibleAppThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.348 -0400", hash_original_field = "0372204543482C679B3EC94B27134E3D", hash_generated_field = "400B18A3CE750D836C4243EC67DB5154")

        public long foregroundAppThreshold;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.349 -0400", hash_original_method = "09AE2D253AD01F5533857164DB70587D", hash_generated_method = "FF74B0D10914F28AB3E573FB192E254D")
        public  MemoryInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.350 -0400", hash_original_method = "EAA33F4FBF3C878879D517CBC8FFA048", hash_generated_method = "138FA19B001BA4AC55AD2A691F2B65DF")
        private  MemoryInfo(Parcel source) {
            addTaint(source.getTaint());
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.351 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D95224592CF87E01C69CA3619EC7A1D4")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1313476518 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_66984583 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_66984583;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.354 -0400", hash_original_method = "F89D0A9B79191784D882D224AE236CD7", hash_generated_method = "5DFCC9E4FCFBF20D2556175A8DBE4ABC")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.360 -0400", hash_original_method = "63344B29322BA9906ACD5F2C274D4AFB", hash_generated_method = "BC66AADD41130FA5D032784C56DC61C2")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.361 -0400", hash_original_field = "7B937244499DDD6DE8E8DD078A54CA42", hash_generated_field = "8D5A5BE61EBADDE649E9CD81EA9451BA")

        public static final Creator<MemoryInfo> CREATOR
                = new Creator<MemoryInfo>() {
            public MemoryInfo createFromParcel(Parcel source) {
                return new MemoryInfo(source);
            }
            public MemoryInfo[] newArray(int size) {
                return new MemoryInfo[size];
            }
        };
        // orphaned legacy method
        public MemoryInfo createFromParcel(Parcel source) {
                return new MemoryInfo(source);
            }
        
        // orphaned legacy method
        public MemoryInfo[] newArray(int size) {
                return new MemoryInfo[size];
            }
        
    }


    
    public static class ProcessErrorStateInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.364 -0400", hash_original_field = "3F9178C25B78ED8BED19091BCB62E266", hash_generated_field = "D12C7475F57008D4BAD02590CD186B34")

        public int condition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.365 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

        public String processName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.365 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.365 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.365 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

        public String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.366 -0400", hash_original_field = "A726C22E14A9C0DF4193537FB24D5DAF", hash_generated_field = "25D58ED094C8F824891E3926D1AD1DE0")

        public String shortMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.366 -0400", hash_original_field = "A31E91D860568FF036E728EC468229E1", hash_generated_field = "49D67D73AE5A1199A388FF4309BAA1C4")

        public String longMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.366 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "5AD16E48548E8F81D0DFF7F4F7B69945")

        public String stackTrace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.367 -0400", hash_original_field = "2F55CDAEC7168EE01704826F3CB21BF8", hash_generated_field = "4DE692F5BEA1FD9E7196CC9316DED961")

        public byte[] crashData = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.367 -0400", hash_original_method = "5ED73996FC5896C9F894604FFBFF8609", hash_generated_method = "3E55B7B14A298521D7B421AC3B025230")
        public  ProcessErrorStateInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.368 -0400", hash_original_method = "94E8D1B421B7A163DD1B499E5670983F", hash_generated_method = "A35A2FFD921E883AD20CA4A8639ED773")
        private  ProcessErrorStateInfo(Parcel source) {
            addTaint(source.getTaint());
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.368 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6C2D634FDEA540475EAD5E9644D2BACF")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_2014749877 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408865066 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408865066;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.369 -0400", hash_original_method = "38EC9879A184B274D068BE64A2E942B7", hash_generated_method = "43404B0934AC1C5079D02D0C1B406402")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.372 -0400", hash_original_method = "7EE07760084269563BF2AEE27C9085AD", hash_generated_method = "6FF9C96E0672E5AF8E3073FD70A01A17")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.373 -0400", hash_original_field = "1B1949A508D4DA61D498C0A487C31F8F", hash_generated_field = "B8303B3F0D63DDF614BF107FEB77E81A")

        public static final int NO_ERROR = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.374 -0400", hash_original_field = "C842307260156DD524A8D7E2F162ACA3", hash_generated_field = "D6C8797DBA9046BA0CC1344E61A997BE")

        public static final int CRASHED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.374 -0400", hash_original_field = "67C3978F0F1FD3CF84AD70936693AE63", hash_generated_field = "2448698F79AC41420B9885070178CA3F")

        public static final int NOT_RESPONDING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.375 -0400", hash_original_field = "E578354A70C72AB1928323E0F806EC32", hash_generated_field = "B4E73E729A49A48B48C5C4D400C68AB6")

        public static final Creator<ProcessErrorStateInfo> CREATOR = 
                new Creator<ProcessErrorStateInfo>() {
            public ProcessErrorStateInfo createFromParcel(Parcel source) {
                return new ProcessErrorStateInfo(source);
            }
            public ProcessErrorStateInfo[] newArray(int size) {
                return new ProcessErrorStateInfo[size];
            }
        };
        // orphaned legacy method
        public ProcessErrorStateInfo createFromParcel(Parcel source) {
                return new ProcessErrorStateInfo(source);
            }
        
        // orphaned legacy method
        public ProcessErrorStateInfo[] newArray(int size) {
                return new ProcessErrorStateInfo[size];
            }
        
    }


    
    public static class RunningAppProcessInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.376 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

        public String processName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.376 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.376 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.377 -0400", hash_original_field = "91F81EBEC4F6E55EB9E1B725B7DEA854", hash_generated_field = "BC83CA44BBF502028F4847713C5A8FFF")

        public String pkgList[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.377 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

        public int flags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.377 -0400", hash_original_field = "7170F2678A3E108BAAC4FA8744F39743", hash_generated_field = "1C80947C985BAA8B2788455C14DF757E")

        public int importance;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.377 -0400", hash_original_field = "DBA3799464B52D8C7CE5446E998D2BD0", hash_generated_field = "935836E7F696020DF2282617A2CDE798")

        public int lru;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.378 -0400", hash_original_field = "179393AD83D5570C33B7F375CFD74B8C", hash_generated_field = "0640A813252163D85213DF91BD542354")

        public int importanceReasonCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.378 -0400", hash_original_field = "34F48A93A5B8ED84B9FC41D36732F609", hash_generated_field = "3F6331CE06F746B4BCE72993297280D9")

        public int importanceReasonPid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.378 -0400", hash_original_field = "F93D3851B3B84F3F0AA9FCDDEB568C55", hash_generated_field = "AB8C5FA34744BF22AFDA5ED2E8ACFB6B")

        public ComponentName importanceReasonComponent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.378 -0400", hash_original_field = "D3F6C4EF0BD40835CEE10C4FA0BC387E", hash_generated_field = "1CAAED6E0A748938FD5E5DBFF194111F")

        public int importanceReasonImportance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.379 -0400", hash_original_method = "037D75A14244F6412C20718AD220CDB7", hash_generated_method = "EBA9A2537661CB41AD3E24299B24227D")
        public  RunningAppProcessInfo() {
            importance = IMPORTANCE_FOREGROUND;
            importanceReasonCode = REASON_UNKNOWN;
            // ---------- Original Method ----------
            //importance = IMPORTANCE_FOREGROUND;
            //importanceReasonCode = REASON_UNKNOWN;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.381 -0400", hash_original_method = "09307CF5135B482F1E6BA3C6F777D6D1", hash_generated_method = "BB2D23B80AE96EA10DC760D829F3AF98")
        public  RunningAppProcessInfo(String pProcessName, int pPid, String pArr[]) {
            processName = pProcessName;
            pid = pPid;
            pkgList = pArr;
            // ---------- Original Method ----------
            //processName = pProcessName;
            //pid = pPid;
            //pkgList = pArr;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.382 -0400", hash_original_method = "224713C5B1CB6C52B9BDAF058DA172D4", hash_generated_method = "340013C0C3A8DD7A66C737B96311B201")
        private  RunningAppProcessInfo(Parcel source) {
            addTaint(source.getTaint());
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.384 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3CF290FD96EA98A2973ED95D03283F6F")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1331529340 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84379879 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84379879;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.385 -0400", hash_original_method = "DDF0D3D0D0B3E35B68DDE155F98679B3", hash_generated_method = "CEDF08416D24385EF3D9C0DBF02DA77B")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.387 -0400", hash_original_method = "41C420DA0EF6445C06E1F94D547B6411", hash_generated_method = "6CEE33DDD5B34CFCAE50871715C114F5")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.388 -0400", hash_original_field = "0C516D85DC95E1D7DBD9453D10915D62", hash_generated_field = "1647EC87F14B5F86D8632AD2EF6C5824")

        public static final int FLAG_CANT_SAVE_STATE = 1<<0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.388 -0400", hash_original_field = "79ABBEDFF5172FB955837B0C1965363B", hash_generated_field = "9BC36C98B31AD9692879EF62506317FF")

        public static final int FLAG_PERSISTENT = 1<<1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.388 -0400", hash_original_field = "357C7469C019E384BE9CE5D00A1CF3AA", hash_generated_field = "7C08C761DEDE62BEC8E3019EE74226FD")

        public static final int IMPORTANCE_FOREGROUND = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.389 -0400", hash_original_field = "9D5CFDC69DF8BA78DFE40629C7097D1B", hash_generated_field = "97CEF1AC776B153D10A3107635843A21")

        public static final int IMPORTANCE_VISIBLE = 200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.389 -0400", hash_original_field = "54F856D70C0E57CD964573BE1DFFFA2C", hash_generated_field = "B7BB82F7798AA2A5C18FBB6185BB2314")

        public static final int IMPORTANCE_PERCEPTIBLE = 130;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.392 -0400", hash_original_field = "87D4522C595B475672D59B8C88ADA1DB", hash_generated_field = "92BC51E78DA32D79D62ACCE3A407504B")

        public static final int IMPORTANCE_CANT_SAVE_STATE = 170;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.393 -0400", hash_original_field = "C609A3A34C642445A2EC8D79DE86612E", hash_generated_field = "306ED1F4972465B2A3462F89635BFAEA")

        public static final int IMPORTANCE_SERVICE = 300;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.394 -0400", hash_original_field = "0E1619FDE106CDF39C943149380B9AC9", hash_generated_field = "07BEC37BDBA9E0367125D8904629A332")

        public static final int IMPORTANCE_BACKGROUND = 400;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.394 -0400", hash_original_field = "BE271B13E2E9B7D77301DCBADCD0495F", hash_generated_field = "3215C32A2347C30D0BEC8CBF9EE1DB8B")

        public static final int IMPORTANCE_EMPTY = 500;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.395 -0400", hash_original_field = "594C5172577F9EDBDC1FE8A52ADB4B96", hash_generated_field = "277DB1ED9D8523A313B00F353F323926")

        public static final int REASON_UNKNOWN = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.395 -0400", hash_original_field = "07B2AF54D6C2EBDCEEACEF8594720AF8", hash_generated_field = "0D2FAA89DE8DF8459E547156CCFB7D13")

        public static final int REASON_PROVIDER_IN_USE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.395 -0400", hash_original_field = "50D549146D67D3EB13EB6CC2884408FB", hash_generated_field = "6620F40FC4D40B586E72B275F99528E5")

        public static final int REASON_SERVICE_IN_USE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.396 -0400", hash_original_field = "961684DCD5DF2C909DB5D05DEB0CF60C", hash_generated_field = "A62C347FADB0FAEE0097CA208AB4C94F")

        public static final Creator<RunningAppProcessInfo> CREATOR = 
            new Creator<RunningAppProcessInfo>() {
            public RunningAppProcessInfo createFromParcel(Parcel source) {
                return new RunningAppProcessInfo(source);
            }
            public RunningAppProcessInfo[] newArray(int size) {
                return new RunningAppProcessInfo[size];
            }
        };
        // orphaned legacy method
        public RunningAppProcessInfo createFromParcel(Parcel source) {
                return new RunningAppProcessInfo(source);
            }
        
        // orphaned legacy method
        public RunningAppProcessInfo[] newArray(int size) {
                return new RunningAppProcessInfo[size];
            }
        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.397 -0400", hash_original_field = "ED9918AAF9E33787BD2314FF60B55E2B", hash_generated_field = "C1ACB3A50DAA45E925C793ECFC62F195")

    private static String TAG = "ActivityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.397 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.398 -0400", hash_original_field = "0AA6BCFB0349530FC4361F030D247674", hash_generated_field = "C16804AA577FC6CC8AED78F613B9B4A2")

    public static final int COMPAT_MODE_ALWAYS = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.398 -0400", hash_original_field = "E005DAD989D6069B7F9C2761E7745EB7", hash_generated_field = "E7F4E1704AC1CA2E7F7AB5C73B5CC1FC")

    public static final int COMPAT_MODE_NEVER = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.399 -0400", hash_original_field = "6D32C580C7B0B3047871A405BF7653A7", hash_generated_field = "E6FB0DE41BD13A12D8C1FD83A17A8386")

    public static final int COMPAT_MODE_UNKNOWN = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.400 -0400", hash_original_field = "27AD56F2D373DA988FA5050E60A92EFF", hash_generated_field = "2C263FE55B5A2E3B8C053FFD33D5C145")

    public static final int COMPAT_MODE_DISABLED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.401 -0400", hash_original_field = "E4387FDACCA273C42D06029AE9D72FC0", hash_generated_field = "E7FF3DAED2069A006F3DA08E24DB5234")

    public static final int COMPAT_MODE_ENABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.402 -0400", hash_original_field = "C5FCDF4F54877B0601FD28082CBA8A9E", hash_generated_field = "9091AED5EDF419D09EF4B705217D4E96")

    public static final int COMPAT_MODE_TOGGLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.403 -0400", hash_original_field = "0565BAD5E12D959BAF62D241FB1476D8", hash_generated_field = "2242B54F4B4FEE2151042282E6383BC1")

    public static final int RECENT_WITH_EXCLUDED = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.405 -0400", hash_original_field = "790CDBE1E611701E4AA2E21493F99FD1", hash_generated_field = "07C68D9E69886FCCDB7162A95AE039AB")

    public static final int RECENT_IGNORE_UNAVAILABLE = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.406 -0400", hash_original_field = "A539421EFFBB0F7BBACC7DDF8F4B1387", hash_generated_field = "F9D136F9AAF3BD2649A8DB3952F9FEFD")

    public static final int REMOVE_TASK_KILL_PROCESS = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.407 -0400", hash_original_field = "F00667FF1E3452F88502B375236D07BF", hash_generated_field = "F905711F81704086241D937BB8F72E15")

    public static final int MOVE_TASK_WITH_HOME = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.407 -0400", hash_original_field = "881212394691AFD32C931C74BC9A99C8", hash_generated_field = "C1B1346ED585E8734FB3050A443502A1")

    public static final int MOVE_TASK_NO_USER_ACTION = 0x00000002;
}

