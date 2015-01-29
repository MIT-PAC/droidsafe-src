package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import android.view.Display;

import com.android.internal.app.IUsageStats;
import com.android.internal.os.PkgUsageStats;
import com.android.internal.util.MemInfoReader;

public class ActivityManager {
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.529 -0500", hash_original_method = "0BAD5E2BAC82418DEF60529619F507F9", hash_generated_method = "698224FB703F43FC09B0409324077D5D")
    
static public int staticGetMemoryClass() {
        // Really brain dead right now -- just take this from the configured
        // vm heap size, and assume it is in megabytes and thus ends with "m".
        String vmHeapSize = SystemProperties.get("dalvik.vm.heapgrowthlimit", "");
        if (vmHeapSize != null && !"".equals(vmHeapSize)) {
            return Integer.parseInt(vmHeapSize.substring(0, vmHeapSize.length()-1));
        }
        return staticGetLargeMemoryClass();
    }
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.533 -0500", hash_original_method = "D5DE26C76366228A47CE9C0908FBCDED", hash_generated_method = "437245CBE14226872FF712F719CB64A1")
    
static public int staticGetLargeMemoryClass() {
        // Really brain dead right now -- just take this from the configured
        // vm heap size, and assume it is in megabytes and thus ends with "m".
        String vmHeapSize = SystemProperties.get("dalvik.vm.heapsize", "16m");
        return Integer.parseInt(vmHeapSize.substring(0, vmHeapSize.length()-1));
    }
    
    /**
     * Used by persistent processes to determine if they are running on a
     * higher-end device so should be okay using hardware drawing acceleration
     * (which tends to consume a lot more RAM).
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.536 -0500", hash_original_method = "439624820785E6C7317999C60D151459", hash_generated_method = "F7F19A6C08AE391E002BBAC268DDC691")
    
static public boolean isHighEndGfx(Display display) {
        MemInfoReader reader = new MemInfoReader();
        reader.readMemInfo();
        if (reader.getTotalSize() >= (512*1024*1024)) {
            // If the device has at least 512MB RAM available to the kernel,
            // we can afford the overhead of graphics acceleration.
            return true;
        }
        Point p = new Point();
        display.getRealSize(p);
        int pixels = p.x * p.y;
        if (pixels >= (1024*600)) {
            // If this is a sufficiently large screen, then there are enough
            // pixels on it that we'd really like to use hw drawing.
            return true;
        }
        return false;
    }

    /**
     * Use to decide whether the running device can be considered a "large
     * RAM" device.  Exactly what memory limit large RAM is will vary, but
     * it essentially means there is plenty of RAM to have lots of background
     * processes running under decent loads.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.538 -0500", hash_original_method = "68A91D72405A4CE5DF9B72D6FF4E6DC9", hash_generated_method = "CD365C287D094C537219CE8949A95CAD")
    
static public boolean isLargeRAM() {
        MemInfoReader reader = new MemInfoReader();
        reader.readMemInfo();
        if (reader.getTotalSize() >= (640*1024*1024)) {
            // Currently 640MB RAM available to the kernel is the point at
            // which we have plenty of RAM to spare.
            return true;
        }
        return false;
    }

    /**
     * Returns "true" if the user interface is currently being messed with
     * by a monkey.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.947 -0500", hash_original_method = "03688D49C7EA4499A5ECC87E8FAFC0E6", hash_generated_method = "1BD01B4CCE15FE5F5E68F115FFC02FD3")
    
public static boolean isUserAMonkey() {
        try {
            return ActivityManagerNative.getDefault().isUserAMonkey();
        } catch (RemoteException e) {
        }
        return false;
    }

    /**
     * Returns "true" if device is running in a test harness.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.949 -0500", hash_original_method = "B24CD2C7FF3B887A2D7E4705F48A60B3", hash_generated_method = "AD4C9EC03B4473759DDBFA6016BEFB25")
    
public static boolean isRunningInTestHarness() {
        return SystemProperties.getBoolean("ro.test_harness", false);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.487 -0500", hash_original_field = "B6B35287999BB2A538C536A2022AF63C", hash_generated_field = "C1ACB3A50DAA45E925C793ECFC62F195")

    private static String TAG = "ActivityManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.489 -0500", hash_original_field = "7A06C0A50B73200DDC70097F2AFFF800", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.498 -0500", hash_original_field = "05DCC181EA765FA9D33ABDE4CD3D16F0", hash_generated_field = "C16804AA577FC6CC8AED78F613B9B4A2")

    public static final int COMPAT_MODE_ALWAYS = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.501 -0500", hash_original_field = "C152EA094B6054FAE5597C64303D2CFF", hash_generated_field = "E7F4E1704AC1CA2E7F7AB5C73B5CC1FC")

    public static final int COMPAT_MODE_NEVER = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.503 -0500", hash_original_field = "CB1334CA7A819D329527FAAA20E67F86", hash_generated_field = "E6FB0DE41BD13A12D8C1FD83A17A8386")

    public static final int COMPAT_MODE_UNKNOWN = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.505 -0500", hash_original_field = "D40D1A89A85A497D4B82B567C550EEDC", hash_generated_field = "2C263FE55B5A2E3B8C053FFD33D5C145")

    public static final int COMPAT_MODE_DISABLED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.507 -0500", hash_original_field = "82D8117F676EDC2FCA0B22A17ADDCD2B", hash_generated_field = "E7FF3DAED2069A006F3DA08E24DB5234")

    public static final int COMPAT_MODE_ENABLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.510 -0500", hash_original_field = "BAB49745E6C43807022109A1D6290A2F", hash_generated_field = "9091AED5EDF419D09EF4B705217D4E96")

    public static final int COMPAT_MODE_TOGGLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.575 -0500", hash_original_field = "1D5927FF0FD2D57CFDE390DE70B42D5A", hash_generated_field = "2242B54F4B4FEE2151042282E6383BC1")

    public static final int RECENT_WITH_EXCLUDED = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.577 -0500", hash_original_field = "34C842E70DB4D8D6BB07DD6DF603B330", hash_generated_field = "07C68D9E69886FCCDB7162A95AE039AB")

    public static final int RECENT_IGNORE_UNAVAILABLE = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.629 -0500", hash_original_field = "42B0ABB6C92D1DB66C55FB0ADB41CE7C", hash_generated_field = "F9D136F9AAF3BD2649A8DB3952F9FEFD")

    public static final int REMOVE_TASK_KILL_PROCESS = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.668 -0500", hash_original_field = "054A2B0AE55B0B42331A35A52BB81A6A", hash_generated_field = "F905711F81704086241D937BB8F72E15")

    public static final int MOVE_TASK_WITH_HOME = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.671 -0500", hash_original_field = "F8FD438C9E83267FBDE9CEC80BAA8C88", hash_generated_field = "C1B1346ED585E8734FB3050A443502A1")

    public static final int MOVE_TASK_NO_USER_ACTION = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.492 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.494 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private  Handler mHandler;
        
@DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:36.844 -0400", hash_original_method = "5B4171109A2201F1FE14E6225146AB80", hash_generated_method = "8ADD7487E2C46628C6CC7A69BA117746")
      ActivityManager(Context context, Handler handler) {
        mContext = context;
        mHandler = handler;
        //addTaint(context.getTaint());
        //addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //mContext = context;
        //mHandler = handler;
    }
        
    // used by modeling to provide shortcut to ActivityManager from getSystemService
    
    public ActivityManager(Context context) {
        mContext = context;
        mHandler = new Handler();
        //addTaint(context.getTaint());
        // ---------- Original Method ----------
        //mContext = context;
        //mHandler = handler;
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.512 -0500", hash_original_method = "BCFF8F5D8C51374E31DC49464CB803A5", hash_generated_method = "7147E5D063D453632BAA10DFE32BD995")
    
public int getFrontActivityScreenCompatMode() {
        try {
            return ActivityManagerNative.getDefault().getFrontActivityScreenCompatMode();
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
            return 0;
        }
    }

    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.514 -0500", hash_original_method = "1AD781893C5FA74DDB5BF5981AAFC282", hash_generated_method = "1BCE96E8EEF6FC4B3C89D0A6B176B773")
    
public void setFrontActivityScreenCompatMode(int mode) {
        try {
            ActivityManagerNative.getDefault().setFrontActivityScreenCompatMode(mode);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
        }
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.517 -0500", hash_original_method = "08DE0842CE89FB88CEE40B6F1F1D5D8A", hash_generated_method = "FC34AB39A4DB3E8277789D547942BC21")
    
public int getPackageScreenCompatMode(String packageName) {
        try {
            return ActivityManagerNative.getDefault().getPackageScreenCompatMode(packageName);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
            return 0;
        }
    }

    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.519 -0500", hash_original_method = "6272BC343B5B54EAA927E2C6A7A229FA", hash_generated_method = "C6A9A04F5260B1F4DBB8EDAE25A389F8")
    
public void setPackageScreenCompatMode(String packageName, int mode) {
        try {
            ActivityManagerNative.getDefault().setPackageScreenCompatMode(packageName, mode);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
        }
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.521 -0500", hash_original_method = "43CD4547C63AA5BA08A4BB7431262A61", hash_generated_method = "C8218C0A35214662E3CB614E20A24E22")
    
public boolean getPackageAskScreenCompat(String packageName) {
        try {
            return ActivityManagerNative.getDefault().getPackageAskScreenCompat(packageName);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
            return false;
        }
    }

    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.524 -0500", hash_original_method = "3BC1D3C0234B303E106B1ACB51D8D800", hash_generated_method = "BFDF5B5127E7B8E1B3922B52FBADDAB7")
    
public void setPackageAskScreenCompat(String packageName, boolean ask) {
        try {
            ActivityManagerNative.getDefault().setPackageAskScreenCompat(packageName, ask);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
        }
    }

    /**
     * Return the approximate per-application memory class of the current
     * device.  This gives you an idea of how hard a memory limit you should
     * impose on your application to let the overall system work best.  The
     * returned value is in megabytes; the baseline Android memory class is
     * 16 (which happens to be the Java heap limit of those devices); some
     * device with more memory may return 24 or even higher numbers.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.526 -0500", hash_original_method = "B7DBD08AF6CFCEAABC628A74B78E8B6F", hash_generated_method = "2A65ECED72771E6A999F1DB95B197E00")
    
public int getMemoryClass() {
        return staticGetMemoryClass();
    }
    
    /**
     * Return the approximate per-application memory class of the current
     * device when an application is running with a large heap.  This is the
     * space available for memory-intensive applications; most applications
     * should not need this amount of memory, and should instead stay with the
     * {@link #getMemoryClass()} limit.  The returned value is in megabytes.
     * This may be the same size as {@link #getMemoryClass()} on memory
     * constrained devices, or it may be significantly larger on devices with
     * a large amount of available RAM.
     *
     * <p>The is the size of the application's Dalvik heap if it has
     * specified <code>android:largeHeap="true"</code> in its manifest.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.531 -0500", hash_original_method = "50F084ADAAFF8EB942A9D9EB0C93D87F", hash_generated_method = "52BB61958CE79139C1D107CBBC67DD7B")
    
public int getLargeMemoryClass() {
        return staticGetLargeMemoryClass();
    }

    /**
     * Return a list of the tasks that the user has recently launched, with
     * the most recent being first and older ones after in order.
     * 
     * @param maxNum The maximum number of entries to return in the list.  The
     * actual number returned may be smaller, depending on how many tasks the
     * user has started and the maximum number the system can remember.
     * @param flags Information about what to return.  May be any combination
     * of {@link #RECENT_WITH_EXCLUDED} and {@link #RECENT_IGNORE_UNAVAILABLE}.
     * 
     * @return Returns a list of RecentTaskInfo records describing each of
     * the recent tasks.
     * 
     * @throws SecurityException Throws SecurityException if the caller does
     * not hold the {@link android.Manifest.permission#GET_TASKS} permission.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.580 -0500", hash_original_method = "F8BE7228FE8A06DB7E3F7EC0517EBE16", hash_generated_method = "9400E85ACDB142B0C8BF5AC206C1533C")
    
public List<RecentTaskInfo> getRecentTasks(int maxNum, int flags)
            throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().getRecentTasks(maxNum,
                    flags);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
            return null;
        }
    }
    
    /**
     * Return a list of the tasks that are currently running, with
     * the most recent being first and older ones after in order.  Note that
     * "running" does not mean any of the task's code is currently loaded or
     * activity -- the task may have been frozen by the system, so that it
     * can be restarted in its previous state when next brought to the
     * foreground.
     * 
     * @param maxNum The maximum number of entries to return in the list.  The
     * actual number returned may be smaller, depending on how many tasks the
     * user has started.
     *
     * @param flags Optional flags
     * @param receiver Optional receiver for delayed thumbnails
     *
     * @return Returns a list of RunningTaskInfo records describing each of
     * the running tasks.
     * 
     * Some thumbnails may not be available at the time of this call. The optional
     * receiver may be used to receive those thumbnails.
     *
     * @throws SecurityException Throws SecurityException if the caller does
     * not hold the {@link android.Manifest.permission#GET_TASKS} permission.
     *
     * @hide
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.OS_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.622 -0500", hash_original_method = "324273237D89470A473FD6EC5C103A40", hash_generated_method = "4CC0E1DB103FC85AF064A4B9351776BF")
    
public List<RunningTaskInfo> getRunningTasks(int maxNum, int flags, IThumbnailReceiver receiver)
            throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().getTasks(maxNum, flags, receiver);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
            return null;
        }
    }

    /**
     * Return a list of the tasks that are currently running, with
     * the most recent being first and older ones after in order.  Note that
     * "running" does not mean any of the task's code is currently loaded or
     * activity -- the task may have been frozen by the system, so that it
     * can be restarted in its previous state when next brought to the
     * foreground.
     *
     * @param maxNum The maximum number of entries to return in the list.  The
     * actual number returned may be smaller, depending on how many tasks the
     * user has started.
     *
     * @return Returns a list of RunningTaskInfo records describing each of
     * the running tasks.
     *
     * @throws SecurityException Throws SecurityException if the caller does
     * not hold the {@link android.Manifest.permission#GET_TASKS} permission.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.624 -0500", hash_original_method = "048E08D6499B0F81FA41B243F96225CE", hash_generated_method = "9EA36A3CB742AACDBA1BFA26BA5542A6")
    
public List<RunningTaskInfo> getRunningTasks(int maxNum)
            throws SecurityException {
        return getRunningTasks(maxNum, 0, null);
    }

    /**
     * Remove some end of a task's activity stack that is not part of
     * the main application.  The selected activities will be finished, so
     * they are no longer part of the main task.
     *
     * @param taskId The identifier of the task.
     * @param subTaskIndex The number of the sub-task; this corresponds
     * to the index of the thumbnail returned by {@link #getTaskThumbnails(int)}.
     * @return Returns true if the sub-task was found and was removed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.626 -0500", hash_original_method = "06417D4703E772AA57E4535D9CA52E2C", hash_generated_method = "99B4ACAFFAB3664C2AC840E93AE48F1B")
    
public boolean removeSubTask(int taskId, int subTaskIndex)
            throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().removeSubTask(taskId, subTaskIndex);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
            return false;
        }
    }

    /**
     * Completely remove the given task.
     *
     * @param taskId Identifier of the task to be removed.
     * @param flags Additional operational flags.  May be 0 or
     * {@link #REMOVE_TASK_KILL_PROCESS}.
     * @return Returns true if the given task was found and removed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.631 -0500", hash_original_method = "B1BB833FCE4ABF3667361FA6F055417F", hash_generated_method = "F20742DB08905530B79687A0FFA2E895")
    
public boolean removeTask(int taskId, int flags)
            throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().removeTask(taskId, flags);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
            return false;
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.666 -0500", hash_original_method = "90A15739ABCD71E20C2601B2E690D2DC", hash_generated_method = "6252835B4565FE0875A176AAEF54E3C3")
    
public TaskThumbnails getTaskThumbnails(int id) throws SecurityException {
        try {
            return ActivityManagerNative.getDefault().getTaskThumbnails(id);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
            return null;
        }
    }

    /**
     * Ask that the task associated with a given task ID be moved to the
     * front of the stack, so it is now visible to the user.  Requires that
     * the caller hold permission {@link android.Manifest.permission#REORDER_TASKS}
     * or a SecurityException will be thrown.
     *
     * @param taskId The identifier of the task to be moved, as found in
     * {@link RunningTaskInfo} or {@link RecentTaskInfo}.
     * @param flags Additional operational flags, 0 or more of
     * {@link #MOVE_TASK_WITH_HOME}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.673 -0500", hash_original_method = "68F3ECC95EA33C5EF7CED37FFBD163D9", hash_generated_method = "CAF5F1E1BF298879AFDC44600BB51B1D")
    
public void moveTaskToFront(int taskId, int flags) {
        try {
            ActivityManagerNative.getDefault().moveTaskToFront(taskId, flags);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
        }
    }

    /**
     * Return a list of the services that are currently running.
     * 
     * @param maxNum The maximum number of entries to return in the list.  The
     * actual number returned may be smaller, depending on how many services
     * are running.
     * 
     * @return Returns a list of RunningServiceInfo records describing each of
     * the running tasks.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.741 -0500", hash_original_method = "93643A575557EDD801C5647B318BA97A", hash_generated_method = "730538D1525354C0CB955120CEF75E1F")    
public List<RunningServiceInfo> getRunningServices(int maxNum)
            throws SecurityException {
        try {
            return ActivityManagerNative.getDefault()
                    .getServices(maxNum, 0);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
            return null;
        }
    }
    
    /**
     * Returns a PendingIntent you can start to show a control panel for the
     * given running service.  If the service does not have a control panel,
     * null is returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.743 -0500", hash_original_method = "3F37B5EEA2E0ADFF7012B4DB8D3BC71C", hash_generated_method = "905C130F701F2C78078A137D52E4A68A")
    
public PendingIntent getRunningServiceControlPanel(ComponentName service)
            throws SecurityException {
        try {
            return ActivityManagerNative.getDefault()
                    .getRunningServiceControlPanel(service);
        } catch (RemoteException e) {
            // System dead, we will be dead too soon!
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.784 -0500", hash_original_method = "B6E6E4E46821E411AC60EE30A7424576", hash_generated_method = "D3AFD48869499E450DE55BF65294FCAC")
    
public void getMemoryInfo(MemoryInfo outInfo) {
        try {
            ActivityManagerNative.getDefault().getMemoryInfo(outInfo);
        } catch (RemoteException e) {
        }
    }
    
    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.787 -0500", hash_original_method = "F72074CE1B364F8B93C8BBDF31501500", hash_generated_method = "28430D2F5899EE912948A49B909DD9E6")
    
public boolean clearApplicationUserData(String packageName, IPackageDataObserver observer) {
        try {
            return ActivityManagerNative.getDefault().clearApplicationUserData(packageName, 
                    observer);
        } catch (RemoteException e) {
            return false;
        }
    }
    
    public static class RecentTaskInfo implements Parcelable {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:36.904 -0400", hash_original_field = "DA99927A07743B1B8E96157497F59A82", hash_generated_field = "144243CA012A4B8ABF03F2F1B5702AF7")

        public static final Creator<RecentTaskInfo> CREATOR
                = new Creator<RecentTaskInfo>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.563 -0500", hash_original_method = "754BED839284C604C75BEECB20D1E8CF", hash_generated_method = "E9C8B4C150B27D66C91B9D392B5FFB1D")
            
public RecentTaskInfo createFromParcel(Parcel source) {
                return new RecentTaskInfo(source);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.566 -0500", hash_original_method = "D970AC33B35E94C08348859E4EC02E6C", hash_generated_method = "1B39F7B1C92C02CD16057DA98615F8B4")
            
public RecentTaskInfo[] newArray(int size) {
                return new RecentTaskInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.541 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.543 -0500", hash_original_field = "14686643FB9EDDFBCA070ABDEBB26129", hash_generated_field = "45FD448AF1C8BBB4AAEF0A2F3C76D8D5")

        public int persistentId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.545 -0500", hash_original_field = "801D914DA0208FCA9E5199BAB4309340", hash_generated_field = "19F03161095B5D5B4369A44839D909E6")

        public Intent baseIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.548 -0500", hash_original_field = "5A606E53EEAE8AC894271EEEC4D12C80", hash_generated_field = "33781CF46949A55BB10919B7C8D1FCE2")

        public ComponentName origActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.550 -0500", hash_original_field = "4C2BAB005F4C5A1BF9E436D5BA36EABB", hash_generated_field = "D2E00B0C52A0AFC2C3ECD84ACC639853")

        public CharSequence description;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.552 -0500", hash_original_method = "C08B7337C6B109635FE340903513A97B", hash_generated_method = "C8BAF0032B31A63722E1DD90A87A7D2A")
        
public RecentTaskInfo() {
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.571 -0500", hash_original_method = "1CABC845DDD8B9A1DEC9FF64F1615AFC", hash_generated_method = "1AD0449B79898A3A9244263697D6320D")
        
private RecentTaskInfo(Parcel source) {
            readFromParcel(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.554 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.556 -0500", hash_original_method = "A024AE935060D48D15B6110668C59DDF", hash_generated_method = "5FC8B5C660AB23A97C6AACE082FD0EFC")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeInt(persistentId);
            if (baseIntent != null) {
                dest.writeInt(1);
                baseIntent.writeToParcel(dest, 0);
            } else {
                dest.writeInt(0);
            }
            ComponentName.writeToParcel(origActivity, dest);
            TextUtils.writeToParcel(description, dest,
                    Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.559 -0500", hash_original_method = "F67217ABAEC36040C8F444901EE65BC8", hash_generated_method = "C2C99AD2DF31DD945A670ED303FBE6BE")
        
public void readFromParcel(Parcel source) {
            id = source.readInt();
            persistentId = source.readInt();
            if (source.readInt() != 0) {
                baseIntent = Intent.CREATOR.createFromParcel(source);
            } else {
                baseIntent = null;
            }
            origActivity = ComponentName.readFromParcel(source);
            description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        }
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
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:36.919 -0400", hash_original_field = "B9911C96575F25BA7EB7A3422AE8B6F1", hash_generated_field = "8DCFCF5E1FAAD8B612615CB5CB186FEC")

        public static final Creator<RunningTaskInfo> CREATOR = new Creator<RunningTaskInfo>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.610 -0500", hash_original_method = "289D74B80F1DDE34702D81134C81DC0D", hash_generated_method = "B4F64693C30029455BF6E13BD00A18D9")
            
public RunningTaskInfo createFromParcel(Parcel source) {
                return new RunningTaskInfo(source);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.613 -0500", hash_original_method = "87B1B374C2173B951C96C3D08DE2EEAE", hash_generated_method = "A52719C233F2DABD3C7F75467B8EBC35")
            
public RunningTaskInfo[] newArray(int size) {
                return new RunningTaskInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.583 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.585 -0500", hash_original_field = "95D2340EA431180101EE2A9EC15A7B0B", hash_generated_field = "706934E85A3C10660FC2C5B7806ED0A6")

        public ComponentName baseActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.587 -0500", hash_original_field = "160C31458D250A570842CC80958FE783", hash_generated_field = "E1E2B3D4624F0E478C8CD581F117A622")

        public ComponentName topActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.589 -0500", hash_original_field = "671EE8F19CE89CCA3E5285825682D0E2", hash_generated_field = "78966E97EF5212F19E857E6A323EA39E")

        public Bitmap thumbnail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.592 -0500", hash_original_field = "4C2BAB005F4C5A1BF9E436D5BA36EABB", hash_generated_field = "D2E00B0C52A0AFC2C3ECD84ACC639853")

        public CharSequence description;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.594 -0500", hash_original_field = "42AF1506659AB892B8E4BBC66314CC30", hash_generated_field = "4C423F6359C67873078893E7E4F87908")

        public int numActivities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.596 -0500", hash_original_field = "B6C3E812576727C96C1A038D0D48FE6D", hash_generated_field = "76E787CD7EF42C186801DE136C1FAB80")

        public int numRunning;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.598 -0500", hash_original_method = "6DA0A8D9CEF41C0CB91D2D95D7E71D44", hash_generated_method = "BA76DBDFB4A16796C3F11F47498425E8")
        
public RunningTaskInfo() {
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.617 -0500", hash_original_method = "A0900FA369CFAE0B339B23849E0D0E54", hash_generated_method = "DC1A40177A07D6E5C742624D53CCD2F5")
        
private RunningTaskInfo(Parcel source) {
            readFromParcel(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.600 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.604 -0500", hash_original_method = "224D236A6A210D9CABF5D7D423C96E97", hash_generated_method = "D157A3711B1E2F0974BC1BEEAF5EEB2F")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            ComponentName.writeToParcel(baseActivity, dest);
            ComponentName.writeToParcel(topActivity, dest);
            if (thumbnail != null) {
                dest.writeInt(1);
                thumbnail.writeToParcel(dest, 0);
            } else {
                dest.writeInt(0);
            }
            TextUtils.writeToParcel(description, dest,
                    Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            dest.writeInt(numActivities);
            dest.writeInt(numRunning);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.607 -0500", hash_original_method = "1A58A87C00619395DA7F7A454E1E03D5", hash_generated_method = "9D55B6AD1AA10F1EFA303332BBB6D37C")
        
public void readFromParcel(Parcel source) {
            id = source.readInt();
            baseActivity = ComponentName.readFromParcel(source);
            topActivity = ComponentName.readFromParcel(source);
            if (source.readInt() != 0) {
                thumbnail = Bitmap.CREATOR.createFromParcel(source);
            } else {
                thumbnail = null;
            }
            description = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            numActivities = source.readInt();
            numRunning = source.readInt();
        }
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.659 -0500", hash_original_field = "0D0E90E785E7E36440F0FAEB5BF0DF21", hash_generated_field = "A7CA2C3264BCA3B8EB9304642C9D25D2")

        public static final Creator<TaskThumbnails> CREATOR = new Creator<TaskThumbnails>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            public TaskThumbnails createFromParcel(Parcel source) {
                return new TaskThumbnails(source);
            }
            public TaskThumbnails[] newArray(int size) {
                return new TaskThumbnails[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.634 -0500", hash_original_field = "4BACE67746330042D5DAF1CCB54B9190", hash_generated_field = "5F56FA9AC5C1789807151046ACFA6F30")

        public Bitmap mainThumbnail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.636 -0500", hash_original_field = "6406357CFD8F220660894067E9EF968A", hash_generated_field = "B493724A74ED3FB14A03B4D585258CEB")

        public int numSubThumbbails;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.638 -0500", hash_original_field = "60ED97CAB35B3472FCB1C66D0D76D2C6", hash_generated_field = "F26B03B078059BC2048093DDC93DD417")

        public IThumbnailRetriever retriever;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.641 -0500", hash_original_method = "EB2263C71F650A09D4909FB1B34C782F", hash_generated_method = "A382AFF0C24491FA3D072C8401121437")
        
public TaskThumbnails() {
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.662 -0500", hash_original_method = "0FEFA86B10CDE25FCF4328B39BD2F7D5", hash_generated_method = "44E48EC08B3FE4557C9B0FAB306E76BF")
        
private TaskThumbnails(Parcel source) {
            readFromParcel(source);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.643 -0500", hash_original_method = "C8A1C6791C443D43BB18F989CA6219B6", hash_generated_method = "A682F3C0E63282513A4027F898482BFD")
        
public Bitmap getSubThumbnail(int index) {
            try {
                return retriever.getThumbnail(index);
            } catch (RemoteException e) {
                return null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.645 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.647 -0500", hash_original_method = "1641949793D35FD49D0AD46DB3E00603", hash_generated_method = "E0DBFE1F972950FDB8CBE569DDEF98B8")
        
public void writeToParcel(Parcel dest, int flags) {
            if (mainThumbnail != null) {
                dest.writeInt(1);
                mainThumbnail.writeToParcel(dest, 0);
            } else {
                dest.writeInt(0);
            }
            dest.writeInt(numSubThumbbails);
            dest.writeStrongInterface(retriever);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.650 -0500", hash_original_method = "19A7C144CCAE5CD51406B760DF512EA1", hash_generated_method = "F7F504BCD77550531026AD6F36F7C4C3")
        
public void readFromParcel(Parcel source) {
            if (source.readInt() != 0) {
                mainThumbnail = Bitmap.CREATOR.createFromParcel(source);
            } else {
                mainThumbnail = null;
            }
            numSubThumbbails = source.readInt();
            retriever = IThumbnailRetriever.Stub.asInterface(source.readStrongBinder());
        }
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.700 -0500", hash_original_field = "96CCA988EF3323D868CD174581F3C681", hash_generated_field = "C5EE28BB616EBCBE67B4A8F8CA4F4F8C")

        public static final int FLAG_STARTED = 1<<0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.703 -0500", hash_original_field = "925E5741B70970F9FE8C645C527F0FA5", hash_generated_field = "829940B23BDE846C789CE2452F9F2213")

        public static final int FLAG_FOREGROUND = 1<<1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.705 -0500", hash_original_field = "8121B01D953C7097B555F4AE58CFE6EC", hash_generated_field = "A8B50094DCEC06B9ED9EBA4201DB4EF0")

        public static final int FLAG_SYSTEM_PROCESS = 1<<2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.708 -0500", hash_original_field = "2040A6F74D76EB980A6EA598BFEE8CF6", hash_generated_field = "BA474CA4A54C5FFAAAC838F19039B567")

        public static final int FLAG_PERSISTENT_PROCESS = 1<<3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:36.952 -0400", hash_original_field = "AD64936DA7390A375DCEFDC8BEB2A286", hash_generated_field = "45AB20E66E709306D076BBEB8007B79C")

        public static final Creator<RunningServiceInfo> CREATOR = new Creator<RunningServiceInfo>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.728 -0500", hash_original_method = "E255B8128AC8F9856A7419AECFDCF636", hash_generated_method = "EF4AE1DA8271928E110E47E48AB49FB3")
            
public RunningServiceInfo createFromParcel(Parcel source) {
                return new RunningServiceInfo(source);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.731 -0500", hash_original_method = "FD3ED620F54DFB73AA55E8F30DE37B83", hash_generated_method = "358D1C882338CB9DB63DCA4EAFDA90A0")
            
public RunningServiceInfo[] newArray(int size) {
                return new RunningServiceInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.676 -0500", hash_original_field = "1E7096081D12946ED86F5D69FFB986CE", hash_generated_field = "7437D6C257B93451B3453DAF54B89FA5")

        public ComponentName service;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.678 -0500", hash_original_field = "3D9A6B8E69012AA56F160CA7CCE3CF4F", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.680 -0500", hash_original_field = "12FA9B6FF5DE3157A8BC781F3445534B", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.682 -0500", hash_original_field = "BFDF50732A419D5C8064BCDB24E99549", hash_generated_field = "5CB999C89045E47AAA039EC43EA8EFD0")

        public String process;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.685 -0500", hash_original_field = "D9EC3CA4AEAEA3802A1AD13971A64AD3", hash_generated_field = "C92541C3D7058FCBBE46B97331B1DC61")

        public boolean foreground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.687 -0500", hash_original_field = "5515C79B54BF30D692F4E76155C8E67D", hash_generated_field = "97CA36905CF396E537D491E932056860")

        public long activeSince;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.689 -0500", hash_original_field = "0C7D8D807BDABCFE1F54B46D208D363B", hash_generated_field = "C0D67C1D1506D281491B9E92F436947F")

        public boolean started;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.691 -0500", hash_original_field = "F82D508F5D5F5CC333629FB18F4D3519", hash_generated_field = "D21158F500DD41CD27566BC52C1CC2A3")

        public int clientCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.693 -0500", hash_original_field = "6BB7572847B5CC428364193140B6BBD7", hash_generated_field = "14132D33689AF670E5EB24E340EA0A1A")

        public int crashCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.696 -0500", hash_original_field = "8ACCABD665018D0B0ADB92886C338E51", hash_generated_field = "126A413BC4E906D9E97E7626D6F4396F")

        public long lastActivityTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.698 -0500", hash_original_field = "1D4BF0082A902D1B27CDCA70D4FFD383", hash_generated_field = "86B8197832B5D22734B4FAA009117212")

        public long restarting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.711 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

        public int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.713 -0500", hash_original_field = "F7C24D2FAF9A79A2A8635857BCB016A3", hash_generated_field = "EB1A871976ECAE165274E12319BA7914")

        public String clientPackage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.715 -0500", hash_original_field = "8D35AB155F416D396BF08D5DAD8EE263", hash_generated_field = "E322FF71A4FA039913D2A08C5BB78D14")

        public int clientLabel;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.718 -0500", hash_original_method = "621426751430068D32289E518662756C", hash_generated_method = "46CFC49EE8BA41524B35A3152203501D")
        
public RunningServiceInfo() {
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.735 -0500", hash_original_method = "35E5A4903D7EB9EB66480EDFA6F47A72", hash_generated_method = "66D0A7D163DD1D2DDD3D2067E967C09C")
        
private RunningServiceInfo(Parcel source) {
            readFromParcel(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.720 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.723 -0500", hash_original_method = "048D37EC670A88D2663FCC084087D5E3", hash_generated_method = "21251E31D432B92AD733BA2F789EAB8E")
        
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
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.725 -0500", hash_original_method = "264C3E4C1DAB76B38CA08CE45829A86C", hash_generated_method = "0602F056EFE5F85E3D71C20B1D22C28A")
        
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
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:36.965 -0400", hash_original_field = "7B937244499DDD6DE8E8DD078A54CA42", hash_generated_field = "8D5A5BE61EBADDE649E9CD81EA9451BA")

        public static final Creator<MemoryInfo> CREATOR
                = new Creator<MemoryInfo>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.773 -0500", hash_original_method = "83921F47BB880779DC0FD4AB57F3B1E1", hash_generated_method = "495A301237E8C89DBCB599934CDB78DC")
            
public MemoryInfo createFromParcel(Parcel source) {
                return new MemoryInfo(source);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.776 -0500", hash_original_method = "15F51E1DA13C1BB1AA9F8A3C297A7987", hash_generated_method = "6BF372C605ED1E982EE449D3C3BB4350")
            
public MemoryInfo[] newArray(int size) {
                return new MemoryInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.746 -0500", hash_original_field = "9E997FE1CCF667D9F1EB1826A834A184", hash_generated_field = "E0A63B0ECBFDEA27BFA2BB9F80EC4972")

        public long availMem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.748 -0500", hash_original_field = "BC0B5D3EA5116B94FB9AF1A2B823526A", hash_generated_field = "3AD4922D5CDF05DAE16A9D0357EE49D4")

        public long threshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.750 -0500", hash_original_field = "48C722DA7B38FE8AF79D5DFB42A7D999", hash_generated_field = "89F0C9AF19D837FDB8D1580447013400")

        public boolean lowMemory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.753 -0500", hash_original_field = "95C60D0802AD05597DEBB00593DC4EC5", hash_generated_field = "47547EF5278B9404AA6B7A5D0AA184CF")

        public long hiddenAppThreshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.755 -0500", hash_original_field = "9AD44677B786AE6B7F35804AFC440BCB", hash_generated_field = "FAF5E05BB790D37C3A76457DA8B44C8A")

        public long secondaryServerThreshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.758 -0500", hash_original_field = "4D988F3E1B811EB868A1C9B90DC635CA", hash_generated_field = "EDF9D0A31FBE606DFDBA889793F7BAA8")

        public long visibleAppThreshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.760 -0500", hash_original_field = "4F14E3CAB5FE5C7A2E0787CCFB96470E", hash_generated_field = "400B18A3CE750D836C4243EC67DB5154")

        public long foregroundAppThreshold;

        @DSComment("no impact")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.762 -0500", hash_original_method = "09AE2D253AD01F5533857164DB70587D", hash_generated_method = "1FF0633BAB808AAABE7DEEC0DAD3D78E")
        
public MemoryInfo() {
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.780 -0500", hash_original_method = "EAA33F4FBF3C878879D517CBC8FFA048", hash_generated_method = "8AE129BE4DE87B957565DCB16A2274BA")
        
private MemoryInfo(Parcel source) {
            readFromParcel(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.765 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.767 -0500", hash_original_method = "F89D0A9B79191784D882D224AE236CD7", hash_generated_method = "86BE3B2092E904C1A2D1F5CDBCB1895D")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(availMem);
            dest.writeLong(threshold);
            dest.writeInt(lowMemory ? 1 : 0);
            dest.writeLong(hiddenAppThreshold);
            dest.writeLong(secondaryServerThreshold);
            dest.writeLong(visibleAppThreshold);
            dest.writeLong(foregroundAppThreshold);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.769 -0500", hash_original_method = "63344B29322BA9906ACD5F2C274D4AFB", hash_generated_method = "EB8AF7DBD5A93EAADAC707BF4323E679")
        
public void readFromParcel(Parcel source) {
            availMem = source.readLong();
            threshold = source.readLong();
            lowMemory = source.readInt() != 0;
            hiddenAppThreshold = source.readLong();
            secondaryServerThreshold = source.readLong();
            visibleAppThreshold = source.readLong();
            foregroundAppThreshold = source.readLong();
        }
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.790 -0500", hash_original_field = "3619BBC96356F263661221785A00D6E9", hash_generated_field = "B8303B3F0D63DDF614BF107FEB77E81A")

        public static final int NO_ERROR = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.792 -0500", hash_original_field = "B1D92ACB15E33DB0113A93705814F2D7", hash_generated_field = "D6C8797DBA9046BA0CC1344E61A997BE")

        public static final int CRASHED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.795 -0500", hash_original_field = "703D3AE940EB91DB448B06A06D4114AD", hash_generated_field = "2448698F79AC41420B9885070178CA3F")

        public static final int NOT_RESPONDING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.833 -0500", hash_original_field = "91AB574E33C21EA70276AD1217009353", hash_generated_field = "B4E73E729A49A48B48C5C4D400C68AB6")
        
        public static final Creator<ProcessErrorStateInfo> CREATOR = 
                new Creator<ProcessErrorStateInfo>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            public ProcessErrorStateInfo createFromParcel(Parcel source) {
                return new ProcessErrorStateInfo(source);
            }
            public ProcessErrorStateInfo[] newArray(int size) {
                return new ProcessErrorStateInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.797 -0500", hash_original_field = "52CC77DA42C05991371830F11786DDB3", hash_generated_field = "D12C7475F57008D4BAD02590CD186B34")

        public int condition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.799 -0500", hash_original_field = "182AC29DC74CEB0C6C89C5576E47A4DD", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

        public String processName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.801 -0500", hash_original_field = "3D9A6B8E69012AA56F160CA7CCE3CF4F", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.804 -0500", hash_original_field = "12FA9B6FF5DE3157A8BC781F3445534B", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.807 -0500", hash_original_field = "FFCA994A2F44B678330E924D8C87385D", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

        public String tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.809 -0500", hash_original_field = "62B4AADF60D6E2245314B055E52400D2", hash_generated_field = "25D58ED094C8F824891E3926D1AD1DE0")

        public String shortMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.811 -0500", hash_original_field = "1EA04FD5C765FA04F0CD8E9EF194250E", hash_generated_field = "49D67D73AE5A1199A388FF4309BAA1C4")

        public String longMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.813 -0500", hash_original_field = "43939ED17E777DB55D0797009C2B6B15", hash_generated_field = "5AD16E48548E8F81D0DFF7F4F7B69945")

        public String stackTrace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.816 -0500", hash_original_field = "93FC50EAE5904F827553E289B094C1D2", hash_generated_field = "4DE692F5BEA1FD9E7196CC9316DED961")

        public byte[] crashData = null;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.818 -0500", hash_original_method = "5ED73996FC5896C9F894604FFBFF8609", hash_generated_method = "1FBDA850A41B9F94754C5E3BC554DF24")
        
public ProcessErrorStateInfo() {
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.836 -0500", hash_original_method = "94E8D1B421B7A163DD1B499E5670983F", hash_generated_method = "06B34152BE015139D83BDCD98F1CE8F2")
        
private ProcessErrorStateInfo(Parcel source) {
            readFromParcel(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.820 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.823 -0500", hash_original_method = "38EC9879A184B274D068BE64A2E942B7", hash_generated_method = "560F9D55BFF89BCC7A33DF5DDD9841F7")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(condition);
            dest.writeString(processName);
            dest.writeInt(pid);
            dest.writeInt(uid);
            dest.writeString(tag);
            dest.writeString(shortMsg);
            dest.writeString(longMsg);
            dest.writeString(stackTrace);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.825 -0500", hash_original_method = "7EE07760084269563BF2AEE27C9085AD", hash_generated_method = "3B1B562A4FD884DDCF4E16AFE4FEAC77")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.852 -0500", hash_original_field = "9BE6615EBB56D9C8259444171E5CDE46", hash_generated_field = "1647EC87F14B5F86D8632AD2EF6C5824")

        public static final int FLAG_CANT_SAVE_STATE = 1<<0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.855 -0500", hash_original_field = "2A161824D20846A441CDBDA6AA52E418", hash_generated_field = "9BC36C98B31AD9692879EF62506317FF")

        public static final int FLAG_PERSISTENT = 1<<1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.861 -0500", hash_original_field = "E556AF0016A98119F59F4AB5496AA9B8", hash_generated_field = "7C08C761DEDE62BEC8E3019EE74226FD")

        public static final int IMPORTANCE_FOREGROUND = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.863 -0500", hash_original_field = "96BAF1FAB6988D9BAC868CE356D0C49D", hash_generated_field = "97CEF1AC776B153D10A3107635843A21")

        public static final int IMPORTANCE_VISIBLE = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.866 -0500", hash_original_field = "CF9B05DE5A001ECDC1FB4A0E59E2BB15", hash_generated_field = "B7BB82F7798AA2A5C18FBB6185BB2314")

        public static final int IMPORTANCE_PERCEPTIBLE = 130;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.868 -0500", hash_original_field = "FB492F68273D6FEB0453C141E7205B8F", hash_generated_field = "92BC51E78DA32D79D62ACCE3A407504B")

        public static final int IMPORTANCE_CANT_SAVE_STATE = 170;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.871 -0500", hash_original_field = "21666A294118B232DF2B4A6930F17550", hash_generated_field = "306ED1F4972465B2A3462F89635BFAEA")

        public static final int IMPORTANCE_SERVICE = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.873 -0500", hash_original_field = "E65F6D6CCB284B3713C7EE1396246B35", hash_generated_field = "07BEC37BDBA9E0367125D8904629A332")

        public static final int IMPORTANCE_BACKGROUND = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.876 -0500", hash_original_field = "94CD096F8DC9A6FD60F4B580D3E8B30E", hash_generated_field = "3215C32A2347C30D0BEC8CBF9EE1DB8B")

        public static final int IMPORTANCE_EMPTY = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.883 -0500", hash_original_field = "467703D37CFFFBC2FB1AC9EE489F4A33", hash_generated_field = "277DB1ED9D8523A313B00F353F323926")

        public static final int REASON_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.885 -0500", hash_original_field = "8B845DA63EC2D7EF1E86FD80DC991218", hash_generated_field = "0D2FAA89DE8DF8459E547156CCFB7D13")

        public static final int REASON_PROVIDER_IN_USE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.887 -0500", hash_original_field = "0D55A93DE7354FFDAF51EA1E2130ED73", hash_generated_field = "6620F40FC4D40B586E72B275F99528E5")

        public static final int REASON_SERVICE_IN_USE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.918 -0500", hash_original_field = "7E2C8075040E69EE35A8468DD047D60C", hash_generated_field = "A62C347FADB0FAEE0097CA208AB4C94F")

        public static final Creator<RunningAppProcessInfo> CREATOR = 
            new Creator<RunningAppProcessInfo>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            public RunningAppProcessInfo createFromParcel(Parcel source) {
                return new RunningAppProcessInfo(source);
            }
            public RunningAppProcessInfo[] newArray(int size) {
                return new RunningAppProcessInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.843 -0500", hash_original_field = "182AC29DC74CEB0C6C89C5576E47A4DD", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

        public String processName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.846 -0500", hash_original_field = "3D9A6B8E69012AA56F160CA7CCE3CF4F", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.848 -0500", hash_original_field = "12FA9B6FF5DE3157A8BC781F3445534B", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.850 -0500", hash_original_field = "2BE81690646EA68733088EE25DEF3CC6", hash_generated_field = "BC83CA44BBF502028F4847713C5A8FFF")

        public String pkgList[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.857 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

        public int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.878 -0500", hash_original_field = "51B5AA453434F32A9260B0256AFAE53E", hash_generated_field = "1C80947C985BAA8B2788455C14DF757E")

        public int importance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.880 -0500", hash_original_field = "47ABFFC8D862FEACDA159FDA0FBAA12D", hash_generated_field = "935836E7F696020DF2282617A2CDE798")

        public int lru;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.890 -0500", hash_original_field = "A50050B4DC942AEF0731CDDF5253953B", hash_generated_field = "0640A813252163D85213DF91BD542354")

        public int importanceReasonCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.893 -0500", hash_original_field = "CFDEF1E9E53E6515E7C56CAC319FA75C", hash_generated_field = "3F6331CE06F746B4BCE72993297280D9")

        public int importanceReasonPid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.895 -0500", hash_original_field = "65C2FF8D2A993EED7343A06FF83B3D4D", hash_generated_field = "AB8C5FA34744BF22AFDA5ED2E8ACFB6B")

        public ComponentName importanceReasonComponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.897 -0500", hash_original_field = "123D7E9C95448F51E7181464C16A43A8", hash_generated_field = "1CAAED6E0A748938FD5E5DBFF194111F")

        public int importanceReasonImportance;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.899 -0500", hash_original_method = "037D75A14244F6412C20718AD220CDB7", hash_generated_method = "F4DAACECB0EFD58E0FCAC4F8BB162B60")
        
public RunningAppProcessInfo() {
            importance = IMPORTANCE_FOREGROUND;
            importanceReasonCode = REASON_UNKNOWN;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.902 -0500", hash_original_method = "09307CF5135B482F1E6BA3C6F777D6D1", hash_generated_method = "CCB37C46F339C5189858A28AD61C28FF")
        
public RunningAppProcessInfo(String pProcessName, int pPid, String pArr[]) {
            processName = pProcessName;
            pid = pPid;
            pkgList = pArr;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.921 -0500", hash_original_method = "224713C5B1CB6C52B9BDAF058DA172D4", hash_generated_method = "49438AA0211EE51C65FB945BDC9173FD")
        
private RunningAppProcessInfo(Parcel source) {
            readFromParcel(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.904 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.907 -0500", hash_original_method = "DDF0D3D0D0B3E35B68DDE155F98679B3", hash_generated_method = "DE83D9B8BD94E1616547A0FAEA49FAEC")
        
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
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.910 -0500", hash_original_method = "41C420DA0EF6445C06E1F94D547B6411", hash_generated_method = "E9D27EE4094F22E4377B1B61F1D41081")
        
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
        // orphaned legacy method
        public RunningAppProcessInfo createFromParcel(Parcel source) {
                return new RunningAppProcessInfo(source);
            }
        
        // orphaned legacy method
        public RunningAppProcessInfo[] newArray(int size) {
                return new RunningAppProcessInfo[size];
            }
        
    }
    
    /**
     * Returns a list of any processes that are currently in an error condition.  The result 
     * will be null if all processes are running properly at this time.
     * 
     * @return Returns a list of ProcessErrorStateInfo records, or null if there are no
     * current error conditions (it will not return an empty list).  This list ordering is not
     * specified.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.840 -0500", hash_original_method = "F53E97F522CAE83DA0CBCF957085AF2C", hash_generated_method = "E3595DD9BF7FB62750F6222551E2A07E")
    
public List<ProcessErrorStateInfo> getProcessesInErrorState() {
        try {
            return ActivityManagerNative.getDefault().getProcessesInErrorState();
        } catch (RemoteException e) {
            return null;
        }
    }
    
    /**
     * Returns a list of application processes installed on external media
     * that are running on the device.
     *
     * @return Returns a list of ApplicationInfo records, or null if none
     * This list ordering is not specified.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.926 -0500", hash_original_method = "5737B6241A3389A78D86162B5C5BDB02", hash_generated_method = "3F3F5E427564E12662B6A5EA495C0309")
    
public List<ApplicationInfo> getRunningExternalApplications() {
        try {
            return ActivityManagerNative.getDefault().getRunningExternalApplications();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Returns a list of application processes that are running on the device.
     * 
     * @return Returns a list of RunningAppProcessInfo records, or null if there are no
     * running processes (it will not return an empty list).  This list ordering is not
     * specified.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.928 -0500", hash_original_method = "BB41AA7EC02A452F0653300FBA1EFF8A", hash_generated_method = "9EC32489CD95F6B4ED507EAF40FA8F6E")
    
public List<RunningAppProcessInfo> getRunningAppProcesses() {
        try {
            return ActivityManagerNative.getDefault().getRunningAppProcesses();
        } catch (RemoteException e) {
            return null;
        }
    }
    
    /**
     * Return information about the memory usage of one or more processes.
     * 
     * @param pids The pids of the processes whose memory usage is to be
     * retrieved.
     * @return Returns an array of memory information, one for each
     * requested pid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.931 -0500", hash_original_method = "BA29C29542BF4FC0E2178C81FA222823", hash_generated_method = "C292EA387AFEAD4AAD3B516037441D24")
    
public Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) {
        try {
            return ActivityManagerNative.getDefault().getProcessMemoryInfo(pids);
        } catch (RemoteException e) {
            return null;
        }
    }
    
    /**
     * @deprecated This is now just a wrapper for
     * {@link #killBackgroundProcesses(String)}; the previous behavior here
     * is no longer available to applications because it allows them to
     * break other applications by removing their alarms, stopping their
     * services, etc.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.933 -0500", hash_original_method = "AB97F58AF8359C056EB136FA16E11328", hash_generated_method = "0078A7D92638C2846BFA990B9B9BA043")
    
@Deprecated
    public void restartPackage(String packageName) {
        killBackgroundProcesses(packageName);
    }
    
    /**
     * Have the system immediately kill all background processes associated
     * with the given package.  This is the same as the kernel killing those
     * processes to reclaim memory; the system will take care of restarting
     * these processes in the future as needed.
     * 
     * <p>You must hold the permission
     * {@link android.Manifest.permission#KILL_BACKGROUND_PROCESSES} to be able to
     * call this method.
     * 
     * @param packageName The name of the package whose processes are to
     * be killed.
     */
    @DSSpec(DSCat.OS_LOW_LEVEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.935 -0500", hash_original_method = "BAC028425422747AF2B8DB952F37E411", hash_generated_method = "1AAF601EE353DA161CF094E1A45BC193")
    
public void killBackgroundProcesses(String packageName) {
        try {
            ActivityManagerNative.getDefault().killBackgroundProcesses(packageName);
        } catch (RemoteException e) {
        }
    }
    
    /**
     * Have the system perform a force stop of everything associated with
     * the given application package.  All processes that share its uid
     * will be killed, all services it has running stopped, all activities
     * removed, etc.  In addition, a {@link Intent#ACTION_PACKAGE_RESTARTED}
     * broadcast will be sent, so that any of its registered alarms can
     * be stopped, notifications removed, etc.
     * 
     * <p>You must hold the permission
     * {@link android.Manifest.permission#FORCE_STOP_PACKAGES} to be able to
     * call this method.
     * 
     * @param packageName The name of the package to be stopped.
     * 
     * @hide This is not available to third party applications due to
     * it allowing them to break other applications by stopping their
     * services, removing their alarms, etc.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.937 -0500", hash_original_method = "F30C6D9D6BE88E1DA2EC5D39F1D44538", hash_generated_method = "DE3FFB9ADC17258CB50998AC8CC837FE")
    
public void forceStopPackage(String packageName) {
        try {
            ActivityManagerNative.getDefault().forceStopPackage(packageName);
        } catch (RemoteException e) {
        }
    }
    
    /**
     * Get the device configuration attributes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.939 -0500", hash_original_method = "002CA49339A7476A8E8EF41ECCC37BDD", hash_generated_method = "B98F41EE884ECD470B7FFFD2442DC678")
    
public ConfigurationInfo getDeviceConfigurationInfo() {
        try {
            return ActivityManagerNative.getDefault().getDeviceConfigurationInfo();
        } catch (RemoteException e) {
        }
        return null;
    }

    /**
     * Get the preferred density of icons for the launcher. This is used when
     * custom drawables are created (e.g., for shortcuts).
     *
     * @return density in terms of DPI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.942 -0500", hash_original_method = "E6A8DEADBC97DC6A083D1FDDD3BF2E4E", hash_generated_method = "E42C12E45B8F008EFA277E1635B3A100")
    
public int getLauncherLargeIconDensity() {
        final Resources res = mContext.getResources();
        final int density = res.getDisplayMetrics().densityDpi;

        if ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            return density;
        }

        switch (density) {
            case DisplayMetrics.DENSITY_LOW:
                return DisplayMetrics.DENSITY_MEDIUM;
            case DisplayMetrics.DENSITY_MEDIUM:
                return DisplayMetrics.DENSITY_HIGH;
            case DisplayMetrics.DENSITY_HIGH:
                return DisplayMetrics.DENSITY_XHIGH;
            case DisplayMetrics.DENSITY_XHIGH:
                return DisplayMetrics.DENSITY_MEDIUM * 2;
            default:
                return density;
        }
    }

    /**
     * Get the preferred launcher icon size. This is used when custom drawables
     * are created (e.g., for shortcuts).
     *
     * @return dimensions of square icons in terms of pixels
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.944 -0500", hash_original_method = "1ABECD33DDCEDD9654A62357CF29D109", hash_generated_method = "EBB978165087C19E26C36D61882BC16F")
    
public int getLauncherLargeIconSize() {
        final Resources res = mContext.getResources();
        final int size = res.getDimensionPixelSize(android.R.dimen.app_icon_size);

        if ((res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                != Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            return size;
        }

        final int density = res.getDisplayMetrics().densityDpi;

        switch (density) {
            case DisplayMetrics.DENSITY_LOW:
                return (size * DisplayMetrics.DENSITY_MEDIUM) / DisplayMetrics.DENSITY_LOW;
            case DisplayMetrics.DENSITY_MEDIUM:
                return (size * DisplayMetrics.DENSITY_HIGH) / DisplayMetrics.DENSITY_MEDIUM;
            case DisplayMetrics.DENSITY_HIGH:
                return (size * DisplayMetrics.DENSITY_XHIGH) / DisplayMetrics.DENSITY_HIGH;
            case DisplayMetrics.DENSITY_XHIGH:
                return (size * DisplayMetrics.DENSITY_MEDIUM * 2) / DisplayMetrics.DENSITY_XHIGH;
            default:
                return size;
        }
    }

    /**
     * Returns the launch count of each installed package.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.952 -0500", hash_original_method = "2575FA7FD2518D90A93FBC6E066D35C1", hash_generated_method = "45F620370F10841A9529E9278FB76218")
    
public Map<String, Integer> getAllPackageLaunchCounts() {
        try {
            IUsageStats usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
            if (usageStatsService == null) {
                return new HashMap<String, Integer>();
            }

            PkgUsageStats[] allPkgUsageStats = usageStatsService.getAllPkgUsageStats();
            if (allPkgUsageStats == null) {
                return new HashMap<String, Integer>();
            }

            Map<String, Integer> launchCounts = new HashMap<String, Integer>();
            for (PkgUsageStats pkgUsageStats : allPkgUsageStats) {
                launchCounts.put(pkgUsageStats.packageName, pkgUsageStats.launchCount);
            }

            return launchCounts;
        } catch (RemoteException e) {
            Log.w(TAG, "Could not query launch counts", e);
            return new HashMap<String, Integer>();
        }
    }

    /**
     * Returns the usage statistics of each installed package.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.954 -0500", hash_original_method = "97D195D4FE7E8BCA1AFB9969B53F0E5E", hash_generated_method = "6926BB531D1845BB835A389339F5ADD4")
    
public PkgUsageStats[] getAllPackageUsageStats() {
        try {
            IUsageStats usageStatsService = IUsageStats.Stub.asInterface(
                    ServiceManager.getService("usagestats"));
            if (usageStatsService != null) {
                return usageStatsService.getAllPkgUsageStats();
            }
        } catch (RemoteException e) {
            Log.w(TAG, "Could not query usage stats", e);
        }
        return new PkgUsageStats[0];
    }

    /**
     * @param userid the user's id. Zero indicates the default user 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:30.957 -0500", hash_original_method = "5F692D6C0F0BEC319B49459A73599D4B", hash_generated_method = "AB949617D5CE894996F2624C8969D9A8")
    
public boolean switchUser(int userid) {
        try {
            return ActivityManagerNative.getDefault().switchUser(userid);
        } catch (RemoteException e) {
            return false;
        }
    }
}

