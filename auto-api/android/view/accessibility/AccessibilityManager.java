package android.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
import android.util.Log;
import android.view.IWindow;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AccessibilityManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "08912AD6B563D3650D4698A9BA0A6C64")

    IAccessibilityManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_field = "1D09076915F0C1B535F8F7A6899A12CD", hash_generated_field = "B3AD351453F3622D7B00E4C698290AE5")

    boolean mIsEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_field = "CC9FEDC5C3C4EEA9B9546C6E636B6B06", hash_generated_field = "1A7CE13BB5E9D8ACA2C85DA567CD9FE9")

    boolean mIsTouchExplorationEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_field = "252DF980FDC54FEB3852D04E9F87DD5A", hash_generated_field = "E13D5254D1B46564E3456F969FF8EC0B")

    final CopyOnWriteArrayList<AccessibilityStateChangeListener> mAccessibilityStateChangeListeners = new CopyOnWriteArrayList<AccessibilityStateChangeListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_field = "376001492716029F3EB64333857C8E7A", hash_generated_field = "5889DF2B944E03DD1D8B216326E04C15")

    final IAccessibilityManagerClient.Stub mClient = new IAccessibilityManagerClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_method = "146496CFF3CBEBB0FB17DF578BCDB32A", hash_generated_method = "48E4850B433B838533EE453914DCF418")
        public void setState(int state) {
            mHandler.obtainMessage(DO_SET_STATE, state, 0).sendToTarget();
            addTaint(state);
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.208 -0400", hash_original_method = "3479AC0BFEAC12F432B7D77CBEFC979B", hash_generated_method = "F6BCF05E5310892B84E5C279CCF9AFEE")
    public  AccessibilityManager(Context context, IAccessibilityManager service) {
        mHandler = new MyHandler(context.getMainLooper());
        mService = service;
        try 
        {
            final int stateFlags = mService.addClient(mClient);
            setState(stateFlags);
        } 
        catch (RemoteException re)
        { }
        
        
        
        
            
            
        
            
        
    }

    
        public static AccessibilityManager getInstance(Context context) {
        synchronized (sInstanceSync) {
            if (sInstance == null) {
                IBinder iBinder = ServiceManager.getService(Context.ACCESSIBILITY_SERVICE);
                IAccessibilityManager service = IAccessibilityManager.Stub.asInterface(iBinder);
                sInstance = new AccessibilityManager(context, service);
            }
        }
        return sInstance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.208 -0400", hash_original_method = "20CDD5F21F40208C5206265F82FC5959", hash_generated_method = "D54BA4FCBFE3AE0A35A45AF9A47AC9ED")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1548684764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1548684764;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.209 -0400", hash_original_method = "7B07E9E942D9981C7AD5D7B1A6A19F18", hash_generated_method = "F9B11075B24426FF99D39B97EBFC2739")
    public boolean isTouchExplorationEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369734560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369734560;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.209 -0400", hash_original_method = "D3FF4CE091F652B646DDDB1D1AF726B0", hash_generated_method = "9FC5F7168768DE16E9AF134FC819FB4B")
    public IAccessibilityManagerClient getClient() {
        IAccessibilityManagerClient varB4EAC82CA7396A68D541C85D26508E83_1818732298 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1818732298 = (IAccessibilityManagerClient) mClient.asBinder();
        varB4EAC82CA7396A68D541C85D26508E83_1818732298.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1818732298;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.210 -0400", hash_original_method = "ECD9D39E5E16C36757C6B1E94F274A8A", hash_generated_method = "99C851279FD147227A4114E3503E9366")
    public void sendAccessibilityEvent(AccessibilityEvent event) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Accessibility off. Did you forget to check that?");
        } 
        boolean doRecycle = false;
        try 
        {
            event.setEventTime(SystemClock.uptimeMillis());
            long identityToken = Binder.clearCallingIdentity();
            doRecycle = mService.sendAccessibilityEvent(event);
            Binder.restoreCallingIdentity(identityToken);
        } 
        catch (RemoteException re)
        { }
        finally 
        {
            {
                event.recycle();
            } 
        } 
        addTaint(event.getTaint());
        
        
            
        
        
        
            
            
            
            
            
                
            
        
            
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.211 -0400", hash_original_method = "EF4501E929C209DC672EAD3D7D48095E", hash_generated_method = "3D284480B69B1A51ABF5F61A5BB5D1E2")
    public void interrupt() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Accessibility off. Did you forget to check that?");
        } 
        try 
        {
            mService.interrupt();
        } 
        catch (RemoteException re)
        { }
        
        
            
        
        
            
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.211 -0400", hash_original_method = "E2D6992D14607757295701B76C880C8C", hash_generated_method = "F2F5584F39280382196CBEFC6C9819E0")
    @Deprecated
    public List<ServiceInfo> getAccessibilityServiceList() {
        List<ServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_1164796734 = null; 
        List<AccessibilityServiceInfo> infos = getInstalledAccessibilityServiceList();
        List<ServiceInfo> services = new ArrayList<ServiceInfo>();
        final int infoCount = infos.size();
        {
            int i = 0;
            {
                AccessibilityServiceInfo info = infos.get(i);
                services.add(info.getResolveInfo().serviceInfo);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1164796734 = Collections.unmodifiableList(services);
        varB4EAC82CA7396A68D541C85D26508E83_1164796734.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1164796734;
        
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.212 -0400", hash_original_method = "4069133ECADF858B249C4B9AC03C2D2A", hash_generated_method = "10FB003240809CB0B1C609C0BC08D896")
    public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList() {
        List<AccessibilityServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_1311905096 = null; 
        List<AccessibilityServiceInfo> services = null;
        try 
        {
            services = mService.getInstalledAccessibilityServiceList();
        } 
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1311905096 = Collections.unmodifiableList(services);
        varB4EAC82CA7396A68D541C85D26508E83_1311905096.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1311905096;
        
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.213 -0400", hash_original_method = "0B36972F320E6D77C70DA2DE64F6CDA9", hash_generated_method = "BCCCA3CB02522A037DDEC48E8E53B182")
    public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
            int feedbackTypeFlags) {
        List<AccessibilityServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_1440183149 = null; 
        List<AccessibilityServiceInfo> services = null;
        try 
        {
            services = mService.getEnabledAccessibilityServiceList(feedbackTypeFlags);
        } 
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1440183149 = Collections.unmodifiableList(services);
        addTaint(feedbackTypeFlags);
        varB4EAC82CA7396A68D541C85D26508E83_1440183149.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1440183149;
        
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.213 -0400", hash_original_method = "30ACA46B7331464EC3BADA9B88DE998C", hash_generated_method = "808DA6EF3ACFAC59ADEA6447D7D23979")
    public boolean addAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        boolean var5A6F0CD479BEDEBB83364E80A3AE764B_1926714115 = (mAccessibilityStateChangeListeners.add(listener));
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899885401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_899885401;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.214 -0400", hash_original_method = "253F741B79F5A62D71C9725DE0D51542", hash_generated_method = "49B190FED1B56A1BC9A630BEDE0D06B1")
    public boolean removeAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        boolean var24C74D594D11A5BCE73EC77DEA6464EE_530856107 = (mAccessibilityStateChangeListeners.remove(listener));
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1582380869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1582380869;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.214 -0400", hash_original_method = "65E953E454D63C10E4D3E41696E8FA2A", hash_generated_method = "CD7FB30D2F079A4A9E6FCC3343D8BA25")
    private void setState(int stateFlags) {
        final boolean accessibilityEnabled = (stateFlags & STATE_FLAG_ACCESSIBILITY_ENABLED) != 0;
        setAccessibilityState(accessibilityEnabled);
        mIsTouchExplorationEnabled = (stateFlags & STATE_FLAG_TOUCH_EXPLORATION_ENABLED) != 0;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.214 -0400", hash_original_method = "CA4E9E314C9F349802EC965B01AC173F", hash_generated_method = "3719C41A172A25E4503937B4BDEC2AD2")
    private void setAccessibilityState(boolean isEnabled) {
        {
            {
                mIsEnabled = isEnabled;
                notifyAccessibilityStateChanged();
            } 
        } 
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.215 -0400", hash_original_method = "4BD0E63D4E32757CA8C2FA20BBC17929", hash_generated_method = "BA96AF441B248CB369B78FA53258EDE6")
    private void notifyAccessibilityStateChanged() {
        final int listenerCount = mAccessibilityStateChangeListeners.size();
        {
            int i = 0;
            {
                mAccessibilityStateChangeListeners.get(i).onAccessibilityStateChanged(mIsEnabled);
            } 
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.215 -0400", hash_original_method = "418C3E6E38CD336BB574D60AEBCE4154", hash_generated_method = "F9598C749EA68472AC8FF93E2EBCB898")
    public int addAccessibilityInteractionConnection(IWindow windowToken,
            IAccessibilityInteractionConnection connection) {
        try 
        {
            int var37F2D9A8621328C65259B1F23C1AB2E7_959674056 = (mService.addAccessibilityInteractionConnection(windowToken, connection));
        } 
        catch (RemoteException re)
        { }
        addTaint(windowToken.getTaint());
        addTaint(connection.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_251894880 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_251894880;
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.215 -0400", hash_original_method = "E001917337970813CAF9F9A342D31C5B", hash_generated_method = "1386E3C3F10A10CC37C3027C01EF7B94")
    public void removeAccessibilityInteractionConnection(IWindow windowToken) {
        try 
        {
            mService.removeAccessibilityInteractionConnection(windowToken);
        } 
        catch (RemoteException re)
        { }
        addTaint(windowToken.getTaint());
        
        
            
        
            
        
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.216 -0400", hash_original_method = "BE3CF03EB466316B0B79DDBF94893ACA", hash_generated_method = "9F59FB64EB9EF78D31A1B6F20DE629FC")
          MyHandler(Looper mainLooper) {
            super(mainLooper);
            addTaint(mainLooper.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.216 -0400", hash_original_method = "0702CD151ACA01CFBFFCD70D188AF2A1", hash_generated_method = "373230158FA4C73B8339CEDC434F5FA7")
        @Override
        public void handleMessage(Message message) {
            
            setState(message.arg1);
            
            addTaint(message.getTaint());
            
            
                
                    
                    
                
                    
            
        }

        
    }


    
    public interface AccessibilityStateChangeListener {

        
        public void onAccessibilityStateChanged(boolean enabled);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.216 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.216 -0400", hash_original_field = "4D24D329B0EF5D2D82578F930D7403E7", hash_generated_field = "E825D3EC7EE0EA6950AFB69AFDFEF59C")

    private static final String LOG_TAG = "AccessibilityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.216 -0400", hash_original_field = "85D1072A753C43092378F05B5DF305A6", hash_generated_field = "D5243A58F1614AE46E8FCF29704BEB96")

    public static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.216 -0400", hash_original_field = "D43BF5D0C31189C57D1C555D72E0BB9B", hash_generated_field = "EAA50D440451540D7B157284465828FF")

    public static final int STATE_FLAG_TOUCH_EXPLORATION_ENABLED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.216 -0400", hash_original_field = "CD6BA09F49DD0FBBBD875FEDA92BCBA8", hash_generated_field = "550354BCFF9C29DC9E7F54237EA2AF6B")

    static final Object sInstanceSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.216 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "5EF143443483818ABB8A01E6EB178491")

    private static AccessibilityManager sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.216 -0400", hash_original_field = "93C67DEE8D16722A1A8FF5FADBEF1717", hash_generated_field = "F6343BB13CD9B2F97A55F219B8CBF5AA")

    private static final int DO_SET_STATE = 10;
}

