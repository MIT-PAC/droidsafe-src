package android.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.152 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "08912AD6B563D3650D4698A9BA0A6C64")

    IAccessibilityManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.152 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.152 -0400", hash_original_field = "1D09076915F0C1B535F8F7A6899A12CD", hash_generated_field = "B3AD351453F3622D7B00E4C698290AE5")

    boolean mIsEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.152 -0400", hash_original_field = "CC9FEDC5C3C4EEA9B9546C6E636B6B06", hash_generated_field = "1A7CE13BB5E9D8ACA2C85DA567CD9FE9")

    boolean mIsTouchExplorationEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.152 -0400", hash_original_field = "252DF980FDC54FEB3852D04E9F87DD5A", hash_generated_field = "E13D5254D1B46564E3456F969FF8EC0B")

    final CopyOnWriteArrayList<AccessibilityStateChangeListener> mAccessibilityStateChangeListeners = new CopyOnWriteArrayList<AccessibilityStateChangeListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_field = "376001492716029F3EB64333857C8E7A", hash_generated_field = "5889DF2B944E03DD1D8B216326E04C15")

    final IAccessibilityManagerClient.Stub mClient = new IAccessibilityManagerClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.207 -0400", hash_original_method = "146496CFF3CBEBB0FB17DF578BCDB32A", hash_generated_method = "48E4850B433B838533EE453914DCF418")
        public void setState(int state) {
            mHandler.obtainMessage(DO_SET_STATE, state, 0).sendToTarget();
            addTaint(state);
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.153 -0400", hash_original_method = "3479AC0BFEAC12F432B7D77CBEFC979B", hash_generated_method = "C6F032E5BE56CE806F8E82AF6F80B7BD")
    public  AccessibilityManager(Context context, IAccessibilityManager service) {
        mHandler = new MyHandler(context.getMainLooper());
        mService = service;
        try 
        {
            final int stateFlags = mService.addClient(mClient);
            setState(stateFlags);
        } 
        catch (RemoteException re)
        {
        } 
        
        
        
        
            
            
        
            
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.154 -0400", hash_original_method = "20CDD5F21F40208C5206265F82FC5959", hash_generated_method = "256636AA5D4BCBB851B5FF1A745305CF")
    public boolean isEnabled() {
        synchronized
(mHandler)        {
            boolean var1D09076915F0C1B535F8F7A6899A12CD_210896214 = (mIsEnabled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_337394764 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_337394764;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.155 -0400", hash_original_method = "7B07E9E942D9981C7AD5D7B1A6A19F18", hash_generated_method = "E94172307C2CEF33AF2B1CAB05AB5B3A")
    public boolean isTouchExplorationEnabled() {
        synchronized
(mHandler)        {
            boolean varCC9FEDC5C3C4EEA9B9546C6E636B6B06_1888133147 = (mIsTouchExplorationEnabled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252887295 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_252887295;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.155 -0400", hash_original_method = "D3FF4CE091F652B646DDDB1D1AF726B0", hash_generated_method = "D83C6C118DCDEBF5973E954C98B6B891")
    public IAccessibilityManagerClient getClient() {
IAccessibilityManagerClient var0B90A2BCE1CB89BF0EC0C688F79755B8_2072276043 =         (IAccessibilityManagerClient) mClient.asBinder();
        var0B90A2BCE1CB89BF0EC0C688F79755B8_2072276043.addTaint(taint);
        return var0B90A2BCE1CB89BF0EC0C688F79755B8_2072276043;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.156 -0400", hash_original_method = "ECD9D39E5E16C36757C6B1E94F274A8A", hash_generated_method = "FE30C5A232BB3F380F87E18BEE9114CF")
    public void sendAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
    if(!mIsEnabled)        
        {
            IllegalStateException var6475C4D7B3336019B637BA2F24732F01_931872411 = new IllegalStateException("Accessibility off. Did you forget to check that?");
            var6475C4D7B3336019B637BA2F24732F01_931872411.addTaint(taint);
            throw var6475C4D7B3336019B637BA2F24732F01_931872411;
        } 
        boolean doRecycle = false;
        try 
        {
            event.setEventTime(SystemClock.uptimeMillis());
            long identityToken = Binder.clearCallingIdentity();
            doRecycle = mService.sendAccessibilityEvent(event);
            Binder.restoreCallingIdentity(identityToken);
    if(DEBUG)            
            {
            } 
        } 
        catch (RemoteException re)
        {
        } 
        finally 
        {
    if(doRecycle)            
            {
                event.recycle();
            } 
        } 
        
        
            
        
        
        
            
            
            
            
            
                
            
        
            
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.157 -0400", hash_original_method = "EF4501E929C209DC672EAD3D7D48095E", hash_generated_method = "893EDA5758D2B1EB35F9A3024A660ACD")
    public void interrupt() {
    if(!mIsEnabled)        
        {
            IllegalStateException var6475C4D7B3336019B637BA2F24732F01_10333248 = new IllegalStateException("Accessibility off. Did you forget to check that?");
            var6475C4D7B3336019B637BA2F24732F01_10333248.addTaint(taint);
            throw var6475C4D7B3336019B637BA2F24732F01_10333248;
        } 
        try 
        {
            mService.interrupt();
    if(DEBUG)            
            {
            } 
        } 
        catch (RemoteException re)
        {
        } 
        
        
            
        
        
            
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.158 -0400", hash_original_method = "E2D6992D14607757295701B76C880C8C", hash_generated_method = "5F9D8DBC63F00ED120B351ADC3255D19")
    @Deprecated
    public List<ServiceInfo> getAccessibilityServiceList() {
        List<AccessibilityServiceInfo> infos = getInstalledAccessibilityServiceList();
        List<ServiceInfo> services = new ArrayList<ServiceInfo>();
        final int infoCount = infos.size();
for(int i = 0;i < infoCount;i++)
        {
            AccessibilityServiceInfo info = infos.get(i);
            services.add(info.getResolveInfo().serviceInfo);
        } 
List<ServiceInfo> var74779B63588794B1BDB8F8A951D65A09_905557457 =         Collections.unmodifiableList(services);
        var74779B63588794B1BDB8F8A951D65A09_905557457.addTaint(taint);
        return var74779B63588794B1BDB8F8A951D65A09_905557457;
        
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.158 -0400", hash_original_method = "4069133ECADF858B249C4B9AC03C2D2A", hash_generated_method = "815161A78E471056F8246019627EF4BC")
    public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList() {
        List<AccessibilityServiceInfo> services = null;
        try 
        {
            services = mService.getInstalledAccessibilityServiceList();
    if(DEBUG)            
            {
            } 
        } 
        catch (RemoteException re)
        {
        } 
List<AccessibilityServiceInfo> var74779B63588794B1BDB8F8A951D65A09_1656576863 =         Collections.unmodifiableList(services);
        var74779B63588794B1BDB8F8A951D65A09_1656576863.addTaint(taint);
        return var74779B63588794B1BDB8F8A951D65A09_1656576863;
        
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.159 -0400", hash_original_method = "0B36972F320E6D77C70DA2DE64F6CDA9", hash_generated_method = "0FFB5850DC35ABD1EFF42AFA808A774F")
    public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
            int feedbackTypeFlags) {
        addTaint(feedbackTypeFlags);
        List<AccessibilityServiceInfo> services = null;
        try 
        {
            services = mService.getEnabledAccessibilityServiceList(feedbackTypeFlags);
    if(DEBUG)            
            {
            } 
        } 
        catch (RemoteException re)
        {
        } 
List<AccessibilityServiceInfo> var74779B63588794B1BDB8F8A951D65A09_1096540779 =         Collections.unmodifiableList(services);
        var74779B63588794B1BDB8F8A951D65A09_1096540779.addTaint(taint);
        return var74779B63588794B1BDB8F8A951D65A09_1096540779;
        
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.160 -0400", hash_original_method = "30ACA46B7331464EC3BADA9B88DE998C", hash_generated_method = "B23D760D618AD4755C53A3EEB17AA448")
    public boolean addAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        addTaint(listener.getTaint());
        boolean var2C5A5236155593B4358D863171B0BDD6_1583330803 = (mAccessibilityStateChangeListeners.add(listener));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339645961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_339645961;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.160 -0400", hash_original_method = "253F741B79F5A62D71C9725DE0D51542", hash_generated_method = "BDEB53434EC3A003E0190688297FB377")
    public boolean removeAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        addTaint(listener.getTaint());
        boolean var85C8C39FFA5F20612971B1AF401EF0C0_53521128 = (mAccessibilityStateChangeListeners.remove(listener));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_535310138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_535310138;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.161 -0400", hash_original_method = "65E953E454D63C10E4D3E41696E8FA2A", hash_generated_method = "CD7FB30D2F079A4A9E6FCC3343D8BA25")
    private void setState(int stateFlags) {
        final boolean accessibilityEnabled = (stateFlags & STATE_FLAG_ACCESSIBILITY_ENABLED) != 0;
        setAccessibilityState(accessibilityEnabled);
        mIsTouchExplorationEnabled = (stateFlags & STATE_FLAG_TOUCH_EXPLORATION_ENABLED) != 0;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.161 -0400", hash_original_method = "CA4E9E314C9F349802EC965B01AC173F", hash_generated_method = "7FD8E95E6E03D3673E0477AF17EF494F")
    private void setAccessibilityState(boolean isEnabled) {
        synchronized
(mHandler)        {
    if(isEnabled != mIsEnabled)            
            {
                mIsEnabled = isEnabled;
                notifyAccessibilityStateChanged();
            } 
        } 
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.161 -0400", hash_original_method = "4BD0E63D4E32757CA8C2FA20BBC17929", hash_generated_method = "5418C76B4D1EF870B1CDEA4E8A5BE8B3")
    private void notifyAccessibilityStateChanged() {
        final int listenerCount = mAccessibilityStateChangeListeners.size();
for(int i = 0;i < listenerCount;i++)
        {
            mAccessibilityStateChangeListeners.get(i).onAccessibilityStateChanged(mIsEnabled);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.162 -0400", hash_original_method = "418C3E6E38CD336BB574D60AEBCE4154", hash_generated_method = "90BBAD80E57223F43872B191720315B2")
    public int addAccessibilityInteractionConnection(IWindow windowToken,
            IAccessibilityInteractionConnection connection) {
        addTaint(connection.getTaint());
        addTaint(windowToken.getTaint());
        try 
        {
            int var945A9B0E1DAFACBDF82326BF6F30DAD2_912312639 = (mService.addAccessibilityInteractionConnection(windowToken, connection));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237968345 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237968345;
        } 
        catch (RemoteException re)
        {
        } 
        int var90ACE5ECCD5C32263347610AED8D56A0_1017876542 = (View.NO_ID);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427353310 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427353310;
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.162 -0400", hash_original_method = "E001917337970813CAF9F9A342D31C5B", hash_generated_method = "178637070F75B2D0FA1B015D379BA7D7")
    public void removeAccessibilityInteractionConnection(IWindow windowToken) {
        addTaint(windowToken.getTaint());
        try 
        {
            mService.removeAccessibilityInteractionConnection(windowToken);
        } 
        catch (RemoteException re)
        {
        } 
        
        
            
        
            
        
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.163 -0400", hash_original_method = "BE3CF03EB466316B0B79DDBF94893ACA", hash_generated_method = "9F59FB64EB9EF78D31A1B6F20DE629FC")
          MyHandler(Looper mainLooper) {
            super(mainLooper);
            addTaint(mainLooper.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.163 -0400", hash_original_method = "0702CD151ACA01CFBFFCD70D188AF2A1", hash_generated_method = "22BA34687424D83226C0C8CF992D611D")
        @Override
        public void handleMessage(Message message) {
            addTaint(message.getTaint());
switch(message.what){
            case DO_SET_STATE :
            setState(message.arg1);
            return;
            default :
}
            
            
                
                    
                    
                
                    
            
        }

        
    }


    
    public interface AccessibilityStateChangeListener {

        
        public void onAccessibilityStateChanged(boolean enabled);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.163 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.163 -0400", hash_original_field = "4D24D329B0EF5D2D82578F930D7403E7", hash_generated_field = "E825D3EC7EE0EA6950AFB69AFDFEF59C")

    private static final String LOG_TAG = "AccessibilityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.163 -0400", hash_original_field = "85D1072A753C43092378F05B5DF305A6", hash_generated_field = "D5243A58F1614AE46E8FCF29704BEB96")

    public static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.163 -0400", hash_original_field = "D43BF5D0C31189C57D1C555D72E0BB9B", hash_generated_field = "EAA50D440451540D7B157284465828FF")

    public static final int STATE_FLAG_TOUCH_EXPLORATION_ENABLED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.163 -0400", hash_original_field = "CD6BA09F49DD0FBBBD875FEDA92BCBA8", hash_generated_field = "550354BCFF9C29DC9E7F54237EA2AF6B")

    static final Object sInstanceSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.163 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "5EF143443483818ABB8A01E6EB178491")

    private static AccessibilityManager sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.163 -0400", hash_original_field = "93C67DEE8D16722A1A8FF5FADBEF1717", hash_generated_field = "F6343BB13CD9B2F97A55F219B8CBF5AA")

    private static final int DO_SET_STATE = 10;
}

