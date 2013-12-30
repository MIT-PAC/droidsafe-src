package android.view.accessibility;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.view.IWindow;
import android.view.View;





public final class AccessibilityManager {

    
    @DSModeled(DSC.SPEC)
    public static AccessibilityManager getInstance(Context context) {
        synchronized (sInstanceSync) {
            if (sInstance == null) {
                sInstance = new AccessibilityManager(context);
            }
        }
        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.965 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.968 -0500", hash_original_field = "0C2874A8C4EEF3323242B9F8AD02225D", hash_generated_field = "E825D3EC7EE0EA6950AFB69AFDFEF59C")


    private static final String LOG_TAG = "AccessibilityManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.970 -0500", hash_original_field = "E22923E7FCE73AEAED2E820C387A5EAD", hash_generated_field = "D5243A58F1614AE46E8FCF29704BEB96")

    public static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.972 -0500", hash_original_field = "DBD40589BEA270CF25FB78875CE602AB", hash_generated_field = "EAA50D440451540D7B157284465828FF")

    public static final int STATE_FLAG_TOUCH_EXPLORATION_ENABLED = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.975 -0500", hash_original_field = "B108A6778E6AB8D2378E5FD484DC59BE", hash_generated_field = "550354BCFF9C29DC9E7F54237EA2AF6B")


    static final Object sInstanceSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.978 -0500", hash_original_field = "13B270C942FDD8A394C54D6B7A199692", hash_generated_field = "5EF143443483818ABB8A01E6EB178491")


    private static AccessibilityManager sInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.981 -0500", hash_original_field = "FC7EAD3DCAAA9F15D0A79C8F69BDDF7E", hash_generated_field = "F6343BB13CD9B2F97A55F219B8CBF5AA")


    private static final int DO_SET_STATE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.983 -0500", hash_original_field = "08912AD6B563D3650D4698A9BA0A6C64", hash_generated_field = "08912AD6B563D3650D4698A9BA0A6C64")


     IAccessibilityManager mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.985 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")


     Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.987 -0500", hash_original_field = "B3AD351453F3622D7B00E4C698290AE5", hash_generated_field = "B3AD351453F3622D7B00E4C698290AE5")


    boolean mIsEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.989 -0500", hash_original_field = "1A7CE13BB5E9D8ACA2C85DA567CD9FE9", hash_generated_field = "1A7CE13BB5E9D8ACA2C85DA567CD9FE9")


    boolean mIsTouchExplorationEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.991 -0500", hash_original_field = "515B5BC58FF2988B66C3FE1217453DF2", hash_generated_field = "E13D5254D1B46564E3456F969FF8EC0B")


    final CopyOnWriteArrayList<AccessibilityStateChangeListener> mAccessibilityStateChangeListeners =
        new CopyOnWriteArrayList<AccessibilityStateChangeListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_field = "376001492716029F3EB64333857C8E7A", hash_generated_field = "5889DF2B944E03DD1D8B216326E04C15")

    final IAccessibilityManagerClient.Stub mClient = new IAccessibilityManagerClient.Stub() {        
        @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_method = "146496CFF3CBEBB0FB17DF578BCDB32A", hash_generated_method = "48E4850B433B838533EE453914DCF418")
        public void setState(int state) {
            mHandler.obtainMessage(DO_SET_STATE, state, 0).sendToTarget();
            addTaint(state);
            
            
        }

        
};
    //used by getSystemService
    @DSModeled(DSC.BAN)
    public  AccessibilityManager(Context context) {
        addTaint(context.getTaint());
    }
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.313 -0400", hash_original_method = "3479AC0BFEAC12F432B7D77CBEFC979B", hash_generated_method = "C6F032E5BE56CE806F8E82AF6F80B7BD")
    public  AccessibilityManager(Context context, IAccessibilityManager service) {
        mHandler = new MyHandler(context.getMainLooper());
        mService = service;
        try 
        {
            final int stateFlags = mService.addClient(mClient);
            setState(stateFlags);
        } //End block
        catch (RemoteException re)
        {
        } //End block

        addTaint(context.getTaint());
        addTaint(service.getTaint());

        // ---------- Original Method ----------
        //mHandler = new MyHandler(context.getMainLooper());
        //mService = service;
        //try {
            //final int stateFlags = mService.addClient(mClient);
            //setState(stateFlags);
        //} catch (RemoteException re) {
            //Log.e(LOG_TAG, "AccessibilityManagerService is dead", re);
        //}
    }

    /**
     * Returns if the accessibility in the system is enabled.
     *
     * @return True if accessibility is enabled, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.014 -0500", hash_original_method = "20CDD5F21F40208C5206265F82FC5959", hash_generated_method = "B15AAE05D6977C39D7FBDF72C26E365F")
    
public boolean isEnabled() {
        synchronized (mHandler) {
            return mIsEnabled;
        }
    }

    /**
     * Returns if the touch exploration in the system is enabled.
     *
     * @return True if touch exploration is enabled, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.016 -0500", hash_original_method = "7B07E9E942D9981C7AD5D7B1A6A19F18", hash_generated_method = "A8718A2CC02C3A5AB9AF5C341ABC3A78")
    
public boolean isTouchExplorationEnabled() {
        synchronized (mHandler) {
            return mIsTouchExplorationEnabled;
        }
    }

    /**
     * Returns the client interface this instance registers in
     * the centralized accessibility manager service.
     *
     * @return The client.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.018 -0500", hash_original_method = "D3FF4CE091F652B646DDDB1D1AF726B0", hash_generated_method = "375BBA472B129BBB4312C8CF8687327F")
    
public IAccessibilityManagerClient getClient() {
       return (IAccessibilityManagerClient) mClient.asBinder();
    }

    /**
     * Sends an {@link AccessibilityEvent}.
     *
     * @param event The event to send.
     *
     * @throws IllegalStateException if accessibility is not enabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.021 -0500", hash_original_method = "ECD9D39E5E16C36757C6B1E94F274A8A", hash_generated_method = "CA5BF0D0ADC7B8C240FD07115789791C")
    
public void sendAccessibilityEvent(AccessibilityEvent event) {
        if (!mIsEnabled) {
            throw new IllegalStateException("Accessibility off. Did you forget to check that?");
        }
        boolean doRecycle = false;
        try {
            event.setEventTime(SystemClock.uptimeMillis());
            // it is possible that this manager is in the same process as the service but
            // client using it is called through Binder from another process. Example: MMS
            // app adds a SMS notification and the NotificationManagerService calls this method
            long identityToken = Binder.clearCallingIdentity();
            doRecycle = mService.sendAccessibilityEvent(event);
            Binder.restoreCallingIdentity(identityToken);
            if (DEBUG) {
                Log.i(LOG_TAG, event + " sent");
            }
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error during sending " + event + " ", re);
        } finally {
            if (doRecycle) {
                event.recycle();
            }
        }
    }

    /**
     * Requests feedback interruption from all accessibility services.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.025 -0500", hash_original_method = "EF4501E929C209DC672EAD3D7D48095E", hash_generated_method = "A386C28E08009459B0FAA91CFD80D678")
    
public void interrupt() {
        if (!mIsEnabled) {
            throw new IllegalStateException("Accessibility off. Did you forget to check that?");
        }
        try {
            mService.interrupt();
            if (DEBUG) {
                Log.i(LOG_TAG, "Requested interrupt from all services");
            }
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error while requesting interrupt from all services. ", re);
        }
    }

    /**
     * Returns the {@link ServiceInfo}s of the installed accessibility services.
     *
     * @return An unmodifiable list with {@link ServiceInfo}s.
     *
     * @deprecated Use {@link #getInstalledAccessibilityServiceList()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.027 -0500", hash_original_method = "E2D6992D14607757295701B76C880C8C", hash_generated_method = "D61CF7B1D236D6FF1A3DE7EBF6566E1D")
    
@Deprecated
    public List<ServiceInfo> getAccessibilityServiceList() {
        List<AccessibilityServiceInfo> infos = getInstalledAccessibilityServiceList();
        List<ServiceInfo> services = new ArrayList<ServiceInfo>();
        final int infoCount = infos.size();
        for (int i = 0; i < infoCount; i++) {
            AccessibilityServiceInfo info = infos.get(i);
            services.add(info.getResolveInfo().serviceInfo);
        }
        return Collections.unmodifiableList(services);
    }

    /**
     * Returns the {@link AccessibilityServiceInfo}s of the installed accessibility services.
     *
     * @return An unmodifiable list with {@link AccessibilityServiceInfo}s.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.030 -0500", hash_original_method = "4069133ECADF858B249C4B9AC03C2D2A", hash_generated_method = "BEC0F9CC527984268D14449285115DD1")
    
public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList() {
        List<AccessibilityServiceInfo> services = null;
        try {
            services = mService.getInstalledAccessibilityServiceList();
            if (DEBUG) {
                Log.i(LOG_TAG, "Installed AccessibilityServices " + services);
            }
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error while obtaining the installed AccessibilityServices. ", re);
        }
        return Collections.unmodifiableList(services);
    }

    /**
     * Returns the {@link AccessibilityServiceInfo}s of the enabled accessibility services
     * for a given feedback type.
     *
     * @param feedbackTypeFlags The feedback type flags.
     * @return An unmodifiable list with {@link AccessibilityServiceInfo}s.
     *
     * @see AccessibilityServiceInfo#FEEDBACK_AUDIBLE
     * @see AccessibilityServiceInfo#FEEDBACK_GENERIC
     * @see AccessibilityServiceInfo#FEEDBACK_HAPTIC
     * @see AccessibilityServiceInfo#FEEDBACK_SPOKEN
     * @see AccessibilityServiceInfo#FEEDBACK_VISUAL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.033 -0500", hash_original_method = "0B36972F320E6D77C70DA2DE64F6CDA9", hash_generated_method = "DC96427724681BD4AFE1360F7CC3ED88")
    
public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
            int feedbackTypeFlags) {
        List<AccessibilityServiceInfo> services = null;
        try {
            services = mService.getEnabledAccessibilityServiceList(feedbackTypeFlags);
            if (DEBUG) {
                Log.i(LOG_TAG, "Installed AccessibilityServices " + services);
            }
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error while obtaining the installed AccessibilityServices. ", re);
        }
        return Collections.unmodifiableList(services);
    }

    
    class MyHandler extends Handler {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.003 -0500", hash_original_method = "BE3CF03EB466316B0B79DDBF94893ACA", hash_generated_method = "BE3CF03EB466316B0B79DDBF94893ACA")
        
MyHandler(Looper mainLooper) {
            super(mainLooper);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.006 -0500", hash_original_method = "0702CD151ACA01CFBFFCD70D188AF2A1", hash_generated_method = "4CA7F646E83EF44DBE3CA3B1BDEF6AA3")
        
@Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case DO_SET_STATE :
                    setState(message.arg1);
                    return;
                default :
                    Log.w(LOG_TAG, "Unknown message type: " + message.what);
            }
        }

        
    }


    
    public interface AccessibilityStateChangeListener {

        
        public void onAccessibilityStateChanged(boolean enabled);
    }

    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.318 -0400", hash_original_method = "30ACA46B7331464EC3BADA9B88DE998C", hash_generated_method = "717A666E6BC15313F7DC671F3F29079E")
    public boolean addAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        if (listener != null) {
            addTaint(listener.getTaint());
            listener.onAccessibilityStateChanged(getTaintBoolean());
        }
        
        boolean var2C5A5236155593B4358D863171B0BDD6_1251272144 = (mAccessibilityStateChangeListeners.add(listener));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575558927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575558927;
        // ---------- Original Method ----------
        //return mAccessibilityStateChangeListeners.add(listener);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.318 -0400", hash_original_method = "253F741B79F5A62D71C9725DE0D51542", hash_generated_method = "DA685E6A5AB504A56BB127F89E0AE3B5")
    public boolean removeAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        if (listener != null) {
            addTaint(listener.getTaint());
            listener.onAccessibilityStateChanged(getTaintBoolean());
        }
        boolean var85C8C39FFA5F20612971B1AF401EF0C0_758093597 = (mAccessibilityStateChangeListeners.remove(listener));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999281333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_999281333;
        // ---------- Original Method ----------
        //return mAccessibilityStateChangeListeners.remove(listener);
    }

    /**
     * Sets the current state.
     *
     * @param stateFlags The state flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.039 -0500", hash_original_method = "65E953E454D63C10E4D3E41696E8FA2A", hash_generated_method = "C5616768C499A11AF8B52B2C2F376BC1")
    
private void setState(int stateFlags) {
        final boolean accessibilityEnabled = (stateFlags & STATE_FLAG_ACCESSIBILITY_ENABLED) != 0;
        setAccessibilityState(accessibilityEnabled);
        mIsTouchExplorationEnabled = (stateFlags & STATE_FLAG_TOUCH_EXPLORATION_ENABLED) != 0;
    }

    /**
     * Sets the enabled state.
     *
     * @param isEnabled The accessibility state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.042 -0500", hash_original_method = "CA4E9E314C9F349802EC965B01AC173F", hash_generated_method = "03C3EB8F91DC52E734DE42CBAF91ADD6")
    
private void setAccessibilityState(boolean isEnabled) {
        synchronized (mHandler) {
            if (isEnabled != mIsEnabled) {
                mIsEnabled = isEnabled;
                notifyAccessibilityStateChanged();
            }
        }
    }

    /**
     * Notifies the registered {@link AccessibilityStateChangeListener}s.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.044 -0500", hash_original_method = "4BD0E63D4E32757CA8C2FA20BBC17929", hash_generated_method = "4DFDE6489411D7E80509FDDE91300D99")
    
private void notifyAccessibilityStateChanged() {
        final int listenerCount = mAccessibilityStateChangeListeners.size();
        for (int i = 0; i < listenerCount; i++) {
            mAccessibilityStateChangeListeners.get(i).onAccessibilityStateChanged(mIsEnabled);
        }
    }

    /**
     * Adds an accessibility interaction connection interface for a given window.
     * @param windowToken The window token to which a connection is added.
     * @param connection The connection.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.047 -0500", hash_original_method = "418C3E6E38CD336BB574D60AEBCE4154", hash_generated_method = "13052BA932EA5F57F83F130152D9B8CE")
    
public int addAccessibilityInteractionConnection(IWindow windowToken,
            IAccessibilityInteractionConnection connection) {
        try {
            return mService.addAccessibilityInteractionConnection(windowToken, connection);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error while adding an accessibility interaction connection. ", re);
        }
        return View.NO_ID;
    }

    /**
     * Removed an accessibility interaction connection interface for a given window.
     * @param windowToken The window token to which a connection is removed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.049 -0500", hash_original_method = "E001917337970813CAF9F9A342D31C5B", hash_generated_method = "FF0123A809F3B60CDB3C09F1FB3E4F8D")
    
public void removeAccessibilityInteractionConnection(IWindow windowToken) {
        try {
            mService.removeAccessibilityInteractionConnection(windowToken);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error while removing an accessibility interaction connection. ", re);
        }
    }
}

