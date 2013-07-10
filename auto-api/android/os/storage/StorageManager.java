package android.os.storage;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StorageManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.619 -0400", hash_original_field = "B37A65C8E4C16F5F00CB3D4C405B1D2D", hash_generated_field = "824B06D572005F1C1B35E543BCE5CB91")

    private IMountService mMountService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.619 -0400", hash_original_field = "5692822DD64189A155C0B07187EEFFB3", hash_generated_field = "E3C963BED00097FA8564C04087A24015")

    Looper mTgtLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.619 -0400", hash_original_field = "F81851926FFC4DCF86E6D654AB1BBAAA", hash_generated_field = "5F09598E7B5B6EF08AE05EA113FDAB16")

    private MountServiceBinderListener mBinderListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.619 -0400", hash_original_field = "8E1997AA994FFA9E245B45EC4669EE3A", hash_generated_field = "D62245B7A50796BE5B27202ED9DFC7AD")

    private List<ListenerDelegate> mListeners = new ArrayList<ListenerDelegate>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.619 -0400", hash_original_field = "356408C1C2A45791A2F283870313B4EF", hash_generated_field = "E8636BBC4F419661BC591AE94E3D2193")

    final private AtomicInteger mNextNonce = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.619 -0400", hash_original_field = "7E22501E409D142941C1EB6DB191FCD0", hash_generated_field = "AE3A24000EF445332EEED071836A65E2")

    private final ObbActionListener mObbActionListener = new ObbActionListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.619 -0400", hash_original_method = "1751DA8EA422A6A8B82F8F3E4926F05B", hash_generated_method = "644DBA139D4FD17AD5CAB43DB66A804D")
    public  StorageManager(Looper tgtLooper) throws RemoteException {
        mMountService = IMountService.Stub.asInterface(ServiceManager.getService("mount"));
        mTgtLooper = tgtLooper;
        mBinderListener = new MountServiceBinderListener();
        mMountService.registerListener(mBinderListener);
        
        
        
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.620 -0400", hash_original_method = "E880709C72C5FA3A0762DDC8432351B1", hash_generated_method = "61D189D47E8A188A2B4A9BC905467F66")
    private int getNextNonce() {
        int var6CB6DA04F0730EF8B511B3B8FFC9F8A7_1143340214 = (mNextNonce.getAndIncrement());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267821622 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267821622;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.620 -0400", hash_original_method = "99C6C81E5E38E1D6866033383A8A6E37", hash_generated_method = "261295FAA3F7F640339DD8222D623EE2")
    public void registerListener(StorageEventListener listener) {
        
        {
            mListeners.add(new ListenerDelegate(listener));
        } 
        addTaint(listener.getTaint());
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.620 -0400", hash_original_method = "3AB3B2EFDC587B358784DA10414214BD", hash_generated_method = "D7903AC65473A1D7C1ED179138027340")
    public void unregisterListener(StorageEventListener listener) {
        {
            final int size = mListeners.size();
            {
                int i = 0;
                {
                    ListenerDelegate l = mListeners.get(i);
                    {
                        boolean var59EE92861E91E921B93BC86C1074CE98_846921384 = (l.getListener() == listener);
                        {
                            mListeners.remove(i);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(listener.getTaint());
        
        
            
        
        
            
            
                
                
                    
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.621 -0400", hash_original_method = "5EB71443ECA98B5E7A476E0AE8AAD3AD", hash_generated_method = "368A1289ED4737EFAE8CBE8CEAC0A1AF")
    public void enableUsbMassStorage() {
        try 
        {
            mMountService.setUsbMassStorageEnabled(true);
        } 
        catch (Exception ex)
        { }
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.621 -0400", hash_original_method = "663240D4ECB8ED0B06161F54AFBC5E98", hash_generated_method = "C629A41C3AD430654F399A0AC242904F")
    public void disableUsbMassStorage() {
        try 
        {
            mMountService.setUsbMassStorageEnabled(false);
        } 
        catch (Exception ex)
        { }
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.622 -0400", hash_original_method = "09220D6F0F0E5ED3096951AEB948E338", hash_generated_method = "67C1119D5AF49B7788F046A2DB8B7D36")
    public boolean isUsbMassStorageConnected() {
        try 
        {
            boolean varB76AEDE2DC40626AB3B07AE1ACEABEB7_324175083 = (mMountService.isUsbMassStorageConnected());
        } 
        catch (Exception ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059199225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059199225;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.622 -0400", hash_original_method = "D60840A90A5B0A49A8865BA4D2E3CCDB", hash_generated_method = "810527B436919F629F9E454B2A753575")
    public boolean isUsbMassStorageEnabled() {
        try 
        {
            boolean varA4535BADAA0FB8D2BE957451B086D7B1_1461630903 = (mMountService.isUsbMassStorageEnabled());
        } 
        catch (RemoteException rex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310703412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310703412;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.623 -0400", hash_original_method = "534072486045B703901D00BD8CC513FF", hash_generated_method = "973D992B2EAF92D6737C065E91D0F39D")
    public boolean mountObb(String filename, String key, OnObbStateChangeListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener cannot be null");
        } 
        try 
        {
            final int nonce = mObbActionListener.addListener(listener);
            mMountService.mountObb(filename, key, mObbActionListener, nonce);
        } 
        catch (RemoteException e)
        { }
        addTaint(filename.getTaint());
        addTaint(key.getTaint());
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703820753 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_703820753;
        
        
            
        
        
            
        
        
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.623 -0400", hash_original_method = "49ADFC5746B1589055920681F4A3DF66", hash_generated_method = "7DA54CF843DD215E37E154A40418B0B3")
    public boolean unmountObb(String filename, boolean force, OnObbStateChangeListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener cannot be null");
        } 
        try 
        {
            final int nonce = mObbActionListener.addListener(listener);
            mMountService.unmountObb(filename, force, mObbActionListener, nonce);
        } 
        catch (RemoteException e)
        { }
        addTaint(filename.getTaint());
        addTaint(force);
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446096185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_446096185;
        
        
            
        
        
            
        
        
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.624 -0400", hash_original_method = "4111120C74906E4EF74CC0B96E5C85EA", hash_generated_method = "A0FED9B1F19676467666C2837F2F2D09")
    public boolean isObbMounted(String filename) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } 
        try 
        {
            boolean var5CFC3377858B4598A6454628DE929077_34228097 = (mMountService.isObbMounted(filename));
        } 
        catch (RemoteException e)
        { }
        addTaint(filename.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131569606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131569606;
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.625 -0400", hash_original_method = "4524FA5E45068B5E619708F061E65DAB", hash_generated_method = "46FA9B9FEC526FFB61ABC9F85950D515")
    public String getMountedObbPath(String filename) {
        String varB4EAC82CA7396A68D541C85D26508E83_2144553183 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1028381460 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2144553183 = mMountService.getMountedObbPath(filename);
        } 
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1028381460 = null;
        addTaint(filename.getTaint());
        String varA7E53CE21691AB073D9660D615818899_808961141; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_808961141 = varB4EAC82CA7396A68D541C85D26508E83_2144553183;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_808961141 = varB4EAC82CA7396A68D541C85D26508E83_1028381460;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_808961141.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_808961141;
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.626 -0400", hash_original_method = "9BA3F19D0DE55EC9B6B86E9B817FE10B", hash_generated_method = "502E714B775DA40DEB952141246B948D")
    public String getVolumeState(String mountPoint) {
        String varB4EAC82CA7396A68D541C85D26508E83_509108127 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_871295433 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_509108127 = mMountService.getVolumeState(mountPoint);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_871295433 = null;
        } 
        addTaint(mountPoint.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1299423872; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1299423872 = varB4EAC82CA7396A68D541C85D26508E83_509108127;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1299423872 = varB4EAC82CA7396A68D541C85D26508E83_871295433;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1299423872.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1299423872;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.629 -0400", hash_original_method = "7E321C52EE616E46A0C899410949AC4D", hash_generated_method = "8B048A450F68B2D48AED03340326179F")
    public StorageVolume[] getVolumeList() {
        StorageVolume[] varB4EAC82CA7396A68D541C85D26508E83_480131972 = null; 
        StorageVolume[] varB4EAC82CA7396A68D541C85D26508E83_1802384223 = null; 
        StorageVolume[] varB4EAC82CA7396A68D541C85D26508E83_1905394522 = null; 
        try 
        {
            Parcelable[] list = mMountService.getVolumeList();
            varB4EAC82CA7396A68D541C85D26508E83_480131972 = new StorageVolume[0];
            int length = list.length;
            StorageVolume[] result = new StorageVolume[length];
            {
                int i = 0;
                {
                    result[i] = (StorageVolume)list[i];
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1802384223 = result;
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1905394522 = null;
        } 
        StorageVolume[] varA7E53CE21691AB073D9660D615818899_738928030; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_738928030 = varB4EAC82CA7396A68D541C85D26508E83_480131972;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_738928030 = varB4EAC82CA7396A68D541C85D26508E83_1802384223;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_738928030 = varB4EAC82CA7396A68D541C85D26508E83_1905394522;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_738928030.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_738928030;
        
        
            
            
            
            
            
                
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.630 -0400", hash_original_method = "32FCB28C74C473CB8B8088CF6B7B3DD3", hash_generated_method = "2930B1117784AAD2CCE5BBBA95E21752")
    public String[] getVolumePaths() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1490173180 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_536736077 = null; 
        StorageVolume[] volumes = getVolumeList();
        varB4EAC82CA7396A68D541C85D26508E83_1490173180 = null;
        int count = volumes.length;
        String[] paths = new String[count];
        {
            int i = 0;
            {
                paths[i] = volumes[i].getPath();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_536736077 = paths;
        String[] varA7E53CE21691AB073D9660D615818899_1702114993; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1702114993 = varB4EAC82CA7396A68D541C85D26508E83_1490173180;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1702114993 = varB4EAC82CA7396A68D541C85D26508E83_536736077;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1702114993.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1702114993;
        
        
        
        
        
        
            
        
        
    }

    
    private class MountServiceBinderListener extends IMountServiceListener.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.631 -0400", hash_original_method = "2B96EE5216074DC94A336B5EA39CF13F", hash_generated_method = "2B96EE5216074DC94A336B5EA39CF13F")
        public MountServiceBinderListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.631 -0400", hash_original_method = "3247F72E228BC8CA6CB0EFFDE0587175", hash_generated_method = "2114030590F787A2E8E6CD855E519E15")
        public void onUsbMassStorageConnectionChanged(boolean available) {
            
            final int size = mListeners.size();
            {
                int i = 0;
                {
                    mListeners.get(i).sendShareAvailabilityChanged(available);
                } 
            } 
            addTaint(available);
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.632 -0400", hash_original_method = "3412F22C5256750E7F040A232BDF8730", hash_generated_method = "3FC8EAB6B3EC3EC0FB6EED6141011252")
        public void onStorageStateChanged(String path, String oldState, String newState) {
            
            final int size = mListeners.size();
            {
                int i = 0;
                {
                    mListeners.get(i).sendStorageStateChanged(path, oldState, newState);
                } 
            } 
            addTaint(path.getTaint());
            addTaint(oldState.getTaint());
            addTaint(newState.getTaint());
            
            
            
                
            
        }

        
    }


    
    private class ObbActionListener extends IObbActionListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.632 -0400", hash_original_field = "F5548429C14A65BFC2537D3DA1DC8B9A", hash_generated_field = "B401ACBFDEFD68175AFBDCAE004213C6")

        @SuppressWarnings("hiding") private SparseArray<ObbListenerDelegate> mListeners = new SparseArray<ObbListenerDelegate>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.632 -0400", hash_original_method = "A19676FD811ED2BA9E2295E50F44897A", hash_generated_method = "A19676FD811ED2BA9E2295E50F44897A")
        public ObbActionListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.633 -0400", hash_original_method = "DBB9E3A59C6BF6EF37DBBFBCC6A9357E", hash_generated_method = "05A2EFE999F637A2BA18F6B76B747425")
        @Override
        public void onObbResult(String filename, int nonce, int status) {
            
            ObbListenerDelegate delegate;
            {
                delegate = mListeners.get(nonce);
                {
                    mListeners.remove(nonce);
                } 
            } 
            {
                delegate.sendObbStateChanged(filename, status);
            } 
            addTaint(filename.getTaint());
            addTaint(nonce);
            addTaint(status);
            
            
            
                
                
                    
                
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.633 -0400", hash_original_method = "8B6662593D8FF2E95312263F2E6C8A4E", hash_generated_method = "0438EF73F5E611E5B8C7FA8BA4139EC2")
        public int addListener(OnObbStateChangeListener listener) {
            final ObbListenerDelegate delegate = new ObbListenerDelegate(listener);
            {
                mListeners.put(delegate.nonce, delegate);
            } 
            addTaint(listener.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150690288 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150690288;
            
            
            
                
            
            
        }

        
    }


    
    private class ObbListenerDelegate {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.633 -0400", hash_original_field = "CFA53EA895A869226B9A782B15E824C5", hash_generated_field = "9765B2BB1BD930598C2982AB60432360")

        private WeakReference<OnObbStateChangeListener> mObbEventListenerRef;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.633 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.633 -0400", hash_original_field = "CB584E44C43ED6BD0BC2D9C7E242837D", hash_generated_field = "025203DA6E702827C569DA1096B5E235")

        private int nonce;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.634 -0400", hash_original_method = "669DF05D8F2AD5FF486346330C6EAF78", hash_generated_method = "A12E0FF591F21CBA8E1548BB56096181")
          ObbListenerDelegate(OnObbStateChangeListener listener) {
            nonce = getNextNonce();
            mObbEventListenerRef = new WeakReference<OnObbStateChangeListener>(listener);
            mHandler = new Handler(mTgtLooper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.634 -0400", hash_original_method = "DAAB8678F7ABEFF803CFD82CEA9641F0", hash_generated_method = "63D5F3975254E82C451496AEF3E89248")
                @Override
                public void handleMessage(Message msg) {
                    final OnObbStateChangeListener changeListener = getListener();
                    StorageEvent e = (StorageEvent) msg.obj;
                    {
                        ObbStateChangedStorageEvent ev = (ObbStateChangedStorageEvent) e;
                        changeListener.onObbStateChange(ev.path, ev.state);
                    } 
                    addTaint(msg.getTaint());
                    
                    
                    
                        
                    
                    
                    
                        
                        
                    
                        
                    
                }
};
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.635 -0400", hash_original_method = "834954D068AF2864C85CCAD9D321B725", hash_generated_method = "46326C726A7FD91D5904E9B348C2F903")
         OnObbStateChangeListener getListener() {
            OnObbStateChangeListener varB4EAC82CA7396A68D541C85D26508E83_1459074535 = null; 
            OnObbStateChangeListener varB4EAC82CA7396A68D541C85D26508E83_713209004 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1459074535 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_713209004 = mObbEventListenerRef.get();
            OnObbStateChangeListener varA7E53CE21691AB073D9660D615818899_1487440158; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1487440158 = varB4EAC82CA7396A68D541C85D26508E83_1459074535;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1487440158 = varB4EAC82CA7396A68D541C85D26508E83_713209004;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1487440158.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1487440158;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.636 -0400", hash_original_method = "E278FF9F38CD6580E6FCEF436B6AB830", hash_generated_method = "CA9CEACEE95334F2784E137CA2818CA8")
         void sendObbStateChanged(String path, int state) {
            ObbStateChangedStorageEvent e = new ObbStateChangedStorageEvent(path, state);
            mHandler.sendMessage(e.getMessage());
            addTaint(path.getTaint());
            addTaint(state);
            
            
            
        }

        
    }


    
    private class ObbStateChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.636 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "58104DC4D068DCE57A6D46AB8F30ECAD")

        public String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.636 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "47895903500EF3C437D3B693442F9718")

        public int state;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.637 -0400", hash_original_method = "B6A5FB82143B81E65B529E1CD0C6BFE8", hash_generated_method = "D7B87FD5151A53761078D39156714F78")
        public  ObbStateChangedStorageEvent(String path, int state) {
            super(EVENT_OBB_STATE_CHANGED);
            this.path = path;
            this.state = state;
            
            
            
        }

        
    }


    
    private class StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.637 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "C86344D57FB924DFB1BCA88A74120A66")

        private Message mMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.638 -0400", hash_original_method = "546E2CE4C7A72D6081E7A50312A352DB", hash_generated_method = "5CD343B512863C315F98F2AEA9C011F5")
        public  StorageEvent(int what) {
            mMessage = Message.obtain();
            mMessage.what = what;
            mMessage.obj = this;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.639 -0400", hash_original_method = "237083C18B821DBF98088C4FF8F2E015", hash_generated_method = "D1DADB007C951BD9369B10FD9DA3FEE8")
        public Message getMessage() {
            Message varB4EAC82CA7396A68D541C85D26508E83_39022023 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_39022023 = mMessage;
            varB4EAC82CA7396A68D541C85D26508E83_39022023.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_39022023;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.639 -0400", hash_original_field = "1564EF349AB04E42B8AE80445E8A296E", hash_generated_field = "F25F6D444BE5A1CFBE4DF466A9A1F864")

        static final int EVENT_UMS_CONNECTION_CHANGED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.639 -0400", hash_original_field = "C5FC45E4D75061C27D49818F135CA8F5", hash_generated_field = "583879D14E1BDFFE9CB4B6C78D72E1EC")

        static final int EVENT_STORAGE_STATE_CHANGED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.639 -0400", hash_original_field = "4455CDC446630A55078BE82059DCDB56", hash_generated_field = "C550BF0DE2FD736DF2E8992E748ECE57")

        static final int EVENT_OBB_STATE_CHANGED = 3;
    }


    
    private class UmsConnectionChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.639 -0400", hash_original_field = "E4894CA167B08880BFC35862F18575EB", hash_generated_field = "5C92C83D4651FA2CBBBE9F57619106E0")

        public boolean available;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.640 -0400", hash_original_method = "DA139192DF79A1B6AF4FBD170F57C738", hash_generated_method = "455690CD38D17C90E3960C0D3AE6FBD7")
        public  UmsConnectionChangedStorageEvent(boolean a) {
            super(EVENT_UMS_CONNECTION_CHANGED);
            available = a;
            
            
        }

        
    }


    
    private class StorageStateChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.640 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "58104DC4D068DCE57A6D46AB8F30ECAD")

        public String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.640 -0400", hash_original_field = "72D6992B63A3C6CEDED7A4F910A17DB4", hash_generated_field = "BCBDB4C878C0401D1D7D5840C50DA786")

        public String oldState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.640 -0400", hash_original_field = "C12B256FB80BF45233F7969DDAD635A8", hash_generated_field = "BBB1EB05FA22C108537691E37AFB1F82")

        public String newState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.640 -0400", hash_original_method = "492691CEB211515F22C314109DCC65E2", hash_generated_method = "AEFC7259D8036A6EC5FA18B5B26F25C2")
        public  StorageStateChangedStorageEvent(String p, String oldS, String newS) {
            super(EVENT_STORAGE_STATE_CHANGED);
            path = p;
            oldState = oldS;
            newState = newS;
            
            
            
            
        }

        
    }


    
    private class ListenerDelegate {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.640 -0400", hash_original_field = "FF21AF7F25ACB77348D1744416043B3F", hash_generated_field = "7A1C33253FE6C5A1C1F7242C2999F45E")

        StorageEventListener mStorageEventListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.640 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.641 -0400", hash_original_method = "9AED46AC5CC711FE51A627C97DCCA6A0", hash_generated_method = "CCEE60AC4D09846978B3E72AAC7C1E4E")
          ListenerDelegate(StorageEventListener listener) {
            mStorageEventListener = listener;
            mHandler = new Handler(mTgtLooper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.641 -0400", hash_original_method = "366C40A0CA9BA10DE636D79A04377DDA", hash_generated_method = "45F398E838E36473B1370EE28D61690A")
                @Override
                public void handleMessage(Message msg) {
                    StorageEvent e = (StorageEvent) msg.obj;
                    {
                        UmsConnectionChangedStorageEvent ev = (UmsConnectionChangedStorageEvent) e;
                        mStorageEventListener.onUsbMassStorageConnectionChanged(ev.available);
                    } 
                    {
                        StorageStateChangedStorageEvent ev = (StorageStateChangedStorageEvent) e;
                        mStorageEventListener.onStorageStateChanged(ev.path, ev.oldState, ev.newState);
                    } 
                    addTaint(msg.getTaint());
                    
                    
                    
                        
                        
                    
                        
                        
                    
                        
                    
                }
};
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.642 -0400", hash_original_method = "DA2EC644741ABB32C38C92FF70A87DA0", hash_generated_method = "809A21ACCA352D78A486265201ED6F79")
         StorageEventListener getListener() {
            StorageEventListener varB4EAC82CA7396A68D541C85D26508E83_1541215320 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1541215320 = mStorageEventListener;
            varB4EAC82CA7396A68D541C85D26508E83_1541215320.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1541215320;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.642 -0400", hash_original_method = "2B1B76FC8373F60078A15952F701EC30", hash_generated_method = "D4100C023C2F814E807413DDBB36C4DC")
         void sendShareAvailabilityChanged(boolean available) {
            UmsConnectionChangedStorageEvent e = new UmsConnectionChangedStorageEvent(available);
            mHandler.sendMessage(e.getMessage());
            addTaint(available);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.643 -0400", hash_original_method = "6996CC17777F13485A3BD31F01C08054", hash_generated_method = "5839E7325F9D3B5B6AD3129CC80CAB72")
         void sendStorageStateChanged(String path, String oldState, String newState) {
            StorageStateChangedStorageEvent e = new StorageStateChangedStorageEvent(path, oldState, newState);
            mHandler.sendMessage(e.getMessage());
            addTaint(path.getTaint());
            addTaint(oldState.getTaint());
            addTaint(newState.getTaint());
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.643 -0400", hash_original_field = "414DE376B4CE8230DB4AAE54D9434AD8", hash_generated_field = "666FAAC497550CA891D002F26E180573")

    private static final String TAG = "StorageManager";
}

