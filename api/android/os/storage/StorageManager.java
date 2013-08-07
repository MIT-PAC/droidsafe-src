package android.os.storage;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.SparseArray;





public class StorageManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.065 -0400", hash_original_field = "B37A65C8E4C16F5F00CB3D4C405B1D2D", hash_generated_field = "824B06D572005F1C1B35E543BCE5CB91")

    private IMountService mMountService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.065 -0400", hash_original_field = "5692822DD64189A155C0B07187EEFFB3", hash_generated_field = "E3C963BED00097FA8564C04087A24015")

    Looper mTgtLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.065 -0400", hash_original_field = "F81851926FFC4DCF86E6D654AB1BBAAA", hash_generated_field = "5F09598E7B5B6EF08AE05EA113FDAB16")

    private MountServiceBinderListener mBinderListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.065 -0400", hash_original_field = "8E1997AA994FFA9E245B45EC4669EE3A", hash_generated_field = "D62245B7A50796BE5B27202ED9DFC7AD")

    private List<ListenerDelegate> mListeners = new ArrayList<ListenerDelegate>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.066 -0400", hash_original_field = "356408C1C2A45791A2F283870313B4EF", hash_generated_field = "E8636BBC4F419661BC591AE94E3D2193")

    final private AtomicInteger mNextNonce = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.066 -0400", hash_original_field = "7E22501E409D142941C1EB6DB191FCD0", hash_generated_field = "AE3A24000EF445332EEED071836A65E2")

    private final ObbActionListener mObbActionListener = new ObbActionListener();
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.066 -0400", hash_original_method = "1751DA8EA422A6A8B82F8F3E4926F05B", hash_generated_method = "42B5B1F86354DDB212884BE19E30C173")
    public  StorageManager(Looper tgtLooper) throws RemoteException {
        mMountService = IMountService.Stub.asInterface(ServiceManager.getService("mount"));
        if(mMountService == null)        
        {
            return;
        } //End block
        mTgtLooper = tgtLooper;
        mBinderListener = new MountServiceBinderListener();
        mMountService.registerListener(mBinderListener);
        // ---------- Original Method ----------
        //mMountService = IMountService.Stub.asInterface(ServiceManager.getService("mount"));
        //if (mMountService == null) {
            //Log.e(TAG, "Unable to connect to mount service! - is it running yet?");
            //return;
        //}
        //mTgtLooper = tgtLooper;
        //mBinderListener = new MountServiceBinderListener();
        //mMountService.registerListener(mBinderListener);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.067 -0400", hash_original_method = "E880709C72C5FA3A0762DDC8432351B1", hash_generated_method = "D2C2E713385AF1193DE7985D35017373")
    private int getNextNonce() {
        int varF17C7CA92AB3E11E07554CE3600EEE39_679676827 = (mNextNonce.getAndIncrement());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873709800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873709800;
        // ---------- Original Method ----------
        //return mNextNonce.getAndIncrement();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.067 -0400", hash_original_method = "99C6C81E5E38E1D6866033383A8A6E37", hash_generated_method = "A9DB10DE2A9C23118659BEBF39A888AB")
    public void registerListener(StorageEventListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(listener.getTaint());
        if(listener == null)        
        {
            return;
        } //End block
        synchronized
(mListeners)        {
            mListeners.add(new ListenerDelegate(listener));
        } //End block
        // ---------- Original Method ----------
        //if (listener == null) {
            //return;
        //}
        //synchronized (mListeners) {
            //mListeners.add(new ListenerDelegate(listener));
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.068 -0400", hash_original_method = "3AB3B2EFDC587B358784DA10414214BD", hash_generated_method = "F9B27539C17BEDC602562E17022AACFA")
    public void unregisterListener(StorageEventListener listener) {
        addTaint(listener.getTaint());
        if(listener == null)        
        {
            return;
        } //End block
        synchronized
(mListeners)        {
            final int size = mListeners.size();
for(int i=0;i<size;i++)
            {
                ListenerDelegate l = mListeners.get(i);
                if(l.getListener() == listener)                
                {
                    mListeners.remove(i);
                    break;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (listener == null) {
            //return;
        //}
        //synchronized (mListeners) {
            //final int size = mListeners.size();
            //for (int i=0 ; i<size ; i++) {
                //ListenerDelegate l = mListeners.get(i);
                //if (l.getListener() == listener) {
                    //mListeners.remove(i);
                    //break;
                //}
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.068 -0400", hash_original_method = "5EB71443ECA98B5E7A476E0AE8AAD3AD", hash_generated_method = "515D0C5145970309938C634DF9201311")
    public void enableUsbMassStorage() {
        try 
        {
            mMountService.setUsbMassStorageEnabled(true);
        } //End block
        catch (Exception ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mMountService.setUsbMassStorageEnabled(true);
        //} catch (Exception ex) {
            //Log.e(TAG, "Failed to enable UMS", ex);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.069 -0400", hash_original_method = "663240D4ECB8ED0B06161F54AFBC5E98", hash_generated_method = "F672D3156A9AB066614E0A47A20BF4E2")
    public void disableUsbMassStorage() {
        try 
        {
            mMountService.setUsbMassStorageEnabled(false);
        } //End block
        catch (Exception ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mMountService.setUsbMassStorageEnabled(false);
        //} catch (Exception ex) {
            //Log.e(TAG, "Failed to disable UMS", ex);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.069 -0400", hash_original_method = "09220D6F0F0E5ED3096951AEB948E338", hash_generated_method = "C9A5CBE9914AF3500C7EEC9B0ED17FBE")
    public boolean isUsbMassStorageConnected() {
        try 
        {
            boolean varC125BD4E4540DF7BF627DAC332790CCC_1505912686 = (mMountService.isUsbMassStorageConnected());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1618536686 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1618536686;
        } //End block
        catch (Exception ex)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_278428493 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609987964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609987964;
        // ---------- Original Method ----------
        //try {
            //return mMountService.isUsbMassStorageConnected();
        //} catch (Exception ex) {
            //Log.e(TAG, "Failed to get UMS connection state", ex);
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.069 -0400", hash_original_method = "D60840A90A5B0A49A8865BA4D2E3CCDB", hash_generated_method = "26361634816D27E23EC8EB7FC4DC22D6")
    public boolean isUsbMassStorageEnabled() {
        try 
        {
            boolean var996FFC1DB90C8C5CC1E0E677BC837271_915702413 = (mMountService.isUsbMassStorageEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1800226683 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1800226683;
        } //End block
        catch (RemoteException rex)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1559005794 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1971967157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1971967157;
        // ---------- Original Method ----------
        //try {
            //return mMountService.isUsbMassStorageEnabled();
        //} catch (RemoteException rex) {
            //Log.e(TAG, "Failed to get UMS enable state", rex);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.070 -0400", hash_original_method = "534072486045B703901D00BD8CC513FF", hash_generated_method = "4BEF998E0CAC5058771D34305EFB7725")
    public boolean mountObb(String filename, String key, OnObbStateChangeListener listener) {
        addTaint(listener.getTaint());
        addTaint(key.getTaint());
        addTaint(filename.getTaint());
        if(filename == null)        
        {
            IllegalArgumentException varE5D084DE90EB64D0C8D7A6EE830EF430_1247494190 = new IllegalArgumentException("filename cannot be null");
            varE5D084DE90EB64D0C8D7A6EE830EF430_1247494190.addTaint(taint);
            throw varE5D084DE90EB64D0C8D7A6EE830EF430_1247494190;
        } //End block
        if(listener == null)        
        {
            IllegalArgumentException var17149778A254271D1845C418D4DDF7E3_966481953 = new IllegalArgumentException("listener cannot be null");
            var17149778A254271D1845C418D4DDF7E3_966481953.addTaint(taint);
            throw var17149778A254271D1845C418D4DDF7E3_966481953;
        } //End block
        try 
        {
            final int nonce = mObbActionListener.addListener(listener);
            mMountService.mountObb(filename, key, mObbActionListener, nonce);
            boolean varB326B5062B2F0E69046810717534CB09_603592140 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616748324 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616748324;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1917692560 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715103510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715103510;
        // ---------- Original Method ----------
        //if (filename == null) {
            //throw new IllegalArgumentException("filename cannot be null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener cannot be null");
        //}
        //try {
            //final int nonce = mObbActionListener.addListener(listener);
            //mMountService.mountObb(filename, key, mObbActionListener, nonce);
            //return true;
        //} catch (RemoteException e) {
            //Log.e(TAG, "Failed to mount OBB", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.071 -0400", hash_original_method = "49ADFC5746B1589055920681F4A3DF66", hash_generated_method = "B58A7E223C6902898997E7FC518AE603")
    public boolean unmountObb(String filename, boolean force, OnObbStateChangeListener listener) {
        addTaint(listener.getTaint());
        addTaint(force);
        addTaint(filename.getTaint());
        if(filename == null)        
        {
            IllegalArgumentException varE5D084DE90EB64D0C8D7A6EE830EF430_1351068798 = new IllegalArgumentException("filename cannot be null");
            varE5D084DE90EB64D0C8D7A6EE830EF430_1351068798.addTaint(taint);
            throw varE5D084DE90EB64D0C8D7A6EE830EF430_1351068798;
        } //End block
        if(listener == null)        
        {
            IllegalArgumentException var17149778A254271D1845C418D4DDF7E3_2010428439 = new IllegalArgumentException("listener cannot be null");
            var17149778A254271D1845C418D4DDF7E3_2010428439.addTaint(taint);
            throw var17149778A254271D1845C418D4DDF7E3_2010428439;
        } //End block
        try 
        {
            final int nonce = mObbActionListener.addListener(listener);
            mMountService.unmountObb(filename, force, mObbActionListener, nonce);
            boolean varB326B5062B2F0E69046810717534CB09_634435993 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1553470263 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1553470263;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_55059256 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_545937422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_545937422;
        // ---------- Original Method ----------
        //if (filename == null) {
            //throw new IllegalArgumentException("filename cannot be null");
        //}
        //if (listener == null) {
            //throw new IllegalArgumentException("listener cannot be null");
        //}
        //try {
            //final int nonce = mObbActionListener.addListener(listener);
            //mMountService.unmountObb(filename, force, mObbActionListener, nonce);
            //return true;
        //} catch (RemoteException e) {
            //Log.e(TAG, "Failed to mount OBB", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.072 -0400", hash_original_method = "4111120C74906E4EF74CC0B96E5C85EA", hash_generated_method = "BE44C5620F935728291D7B21551A2975")
    public boolean isObbMounted(String filename) {
        addTaint(filename.getTaint());
        if(filename == null)        
        {
            IllegalArgumentException varE5D084DE90EB64D0C8D7A6EE830EF430_1347173489 = new IllegalArgumentException("filename cannot be null");
            varE5D084DE90EB64D0C8D7A6EE830EF430_1347173489.addTaint(taint);
            throw varE5D084DE90EB64D0C8D7A6EE830EF430_1347173489;
        } //End block
        try 
        {
            boolean varFA4570C50619C718929E2DA7D33A31E5_1831126411 = (mMountService.isObbMounted(filename));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2095620421 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2095620421;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1508690479 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308666408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308666408;
        // ---------- Original Method ----------
        //if (filename == null) {
            //throw new IllegalArgumentException("filename cannot be null");
        //}
        //try {
            //return mMountService.isObbMounted(filename);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Failed to check if OBB is mounted", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.073 -0400", hash_original_method = "4524FA5E45068B5E619708F061E65DAB", hash_generated_method = "BD4C608C7A42F6849EF663D4BACFDC09")
    public String getMountedObbPath(String filename) {
        addTaint(filename.getTaint());
        if(filename == null)        
        {
            IllegalArgumentException varE5D084DE90EB64D0C8D7A6EE830EF430_1295490398 = new IllegalArgumentException("filename cannot be null");
            varE5D084DE90EB64D0C8D7A6EE830EF430_1295490398.addTaint(taint);
            throw varE5D084DE90EB64D0C8D7A6EE830EF430_1295490398;
        } //End block
        try 
        {
String var9435347AB9BFACE72FF856025DB5F289_1967252447 =             mMountService.getMountedObbPath(filename);
            var9435347AB9BFACE72FF856025DB5F289_1967252447.addTaint(taint);
            return var9435347AB9BFACE72FF856025DB5F289_1967252447;
        } //End block
        catch (RemoteException e)
        {
        } //End block
String var540C13E9E156B687226421B24F2DF178_943358471 =         null;
        var540C13E9E156B687226421B24F2DF178_943358471.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_943358471;
        // ---------- Original Method ----------
        //if (filename == null) {
            //throw new IllegalArgumentException("filename cannot be null");
        //}
        //try {
            //return mMountService.getMountedObbPath(filename);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Failed to find mounted path for OBB", e);
        //}
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.073 -0400", hash_original_method = "9BA3F19D0DE55EC9B6B86E9B817FE10B", hash_generated_method = "24CD9EE3C56ABA24EBF2E62DE851B74F")
    public String getVolumeState(String mountPoint) {
        addTaint(mountPoint.getTaint());
        try 
        {
String var56CD6C6B849E2ECC1076CBB7B5EF2887_1420786250 =             mMountService.getVolumeState(mountPoint);
            var56CD6C6B849E2ECC1076CBB7B5EF2887_1420786250.addTaint(taint);
            return var56CD6C6B849E2ECC1076CBB7B5EF2887_1420786250;
        } //End block
        catch (RemoteException e)
        {
String var540C13E9E156B687226421B24F2DF178_2103583109 =             null;
            var540C13E9E156B687226421B24F2DF178_2103583109.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2103583109;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mMountService.getVolumeState(mountPoint);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Failed to get volume state", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.074 -0400", hash_original_method = "7E321C52EE616E46A0C899410949AC4D", hash_generated_method = "C2240FD04729B49E24DBF431832572A8")
    public StorageVolume[] getVolumeList() {
        try 
        {
            Parcelable[] list = mMountService.getVolumeList();
            if(list == null)            
            {
StorageVolume[] varBFB4120FBFD8A09418DEA018C35F36DA_1259249855 =             new StorageVolume[0];
            varBFB4120FBFD8A09418DEA018C35F36DA_1259249855.addTaint(taint);
            return varBFB4120FBFD8A09418DEA018C35F36DA_1259249855;
            }
            int length = list.length;
            StorageVolume[] result = new StorageVolume[length];
for(int i = 0;i < length;i++)
            {
                result[i] = (StorageVolume)list[i];
            } //End block
StorageVolume[] varDC838461EE2FA0CA4C9BBB70A15456B0_864981235 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_864981235.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_864981235;
        } //End block
        catch (RemoteException e)
        {
StorageVolume[] var540C13E9E156B687226421B24F2DF178_1531371435 =             null;
            var540C13E9E156B687226421B24F2DF178_1531371435.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1531371435;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Parcelable[] list = mMountService.getVolumeList();
            //if (list == null) return new StorageVolume[0];
            //int length = list.length;
            //StorageVolume[] result = new StorageVolume[length];
            //for (int i = 0; i < length; i++) {
                //result[i] = (StorageVolume)list[i];
            //}
            //return result;
        //} catch (RemoteException e) {
            //Log.e(TAG, "Failed to get volume list", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.075 -0400", hash_original_method = "32FCB28C74C473CB8B8088CF6B7B3DD3", hash_generated_method = "9C08E64E79C44E067A8D35571B3E634A")
    public String[] getVolumePaths() {
        StorageVolume[] volumes = getVolumeList();
        if(volumes == null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_1615329362 =         null;
        var540C13E9E156B687226421B24F2DF178_1615329362.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1615329362;
        }
        int count = volumes.length;
        String[] paths = new String[count];
for(int i = 0;i < count;i++)
        {
            paths[i] = volumes[i].getPath();
        } //End block
String[] var8B4D6CF8BBF4DB57F1BB90F2C89984B1_1223356005 =         paths;
        var8B4D6CF8BBF4DB57F1BB90F2C89984B1_1223356005.addTaint(taint);
        return var8B4D6CF8BBF4DB57F1BB90F2C89984B1_1223356005;
        // ---------- Original Method ----------
        //StorageVolume[] volumes = getVolumeList();
        //if (volumes == null) return null;
        //int count = volumes.length;
        //String[] paths = new String[count];
        //for (int i = 0; i < count; i++) {
            //paths[i] = volumes[i].getPath();
        //}
        //return paths;
    }

    
    private class MountServiceBinderListener extends IMountServiceListener.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.075 -0400", hash_original_method = "2B96EE5216074DC94A336B5EA39CF13F", hash_generated_method = "2B96EE5216074DC94A336B5EA39CF13F")
        public MountServiceBinderListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.075 -0400", hash_original_method = "3247F72E228BC8CA6CB0EFFDE0587175", hash_generated_method = "A00097831F4AFE00836623180CBA9AF6")
        public void onUsbMassStorageConnectionChanged(boolean available) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(available);
            final int size = mListeners.size();
for(int i = 0;i < size;i++)
            {
                mListeners.get(i).sendShareAvailabilityChanged(available);
            } //End block
            // ---------- Original Method ----------
            //final int size = mListeners.size();
            //for (int i = 0; i < size; i++) {
                //mListeners.get(i).sendShareAvailabilityChanged(available);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.075 -0400", hash_original_method = "3412F22C5256750E7F040A232BDF8730", hash_generated_method = "C18F1537470C818B09833135EFD30C5F")
        public void onStorageStateChanged(String path, String oldState, String newState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(newState.getTaint());
            addTaint(oldState.getTaint());
            addTaint(path.getTaint());
            final int size = mListeners.size();
for(int i = 0;i < size;i++)
            {
                mListeners.get(i).sendStorageStateChanged(path, oldState, newState);
            } //End block
            // ---------- Original Method ----------
            //final int size = mListeners.size();
            //for (int i = 0; i < size; i++) {
                //mListeners.get(i).sendStorageStateChanged(path, oldState, newState);
            //}
        }

        
    }


    
    private class ObbActionListener extends IObbActionListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.076 -0400", hash_original_field = "F5548429C14A65BFC2537D3DA1DC8B9A", hash_generated_field = "B401ACBFDEFD68175AFBDCAE004213C6")

        @SuppressWarnings("hiding") private SparseArray<ObbListenerDelegate> mListeners = new SparseArray<ObbListenerDelegate>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.076 -0400", hash_original_method = "A19676FD811ED2BA9E2295E50F44897A", hash_generated_method = "A19676FD811ED2BA9E2295E50F44897A")
        public ObbActionListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.076 -0400", hash_original_method = "DBB9E3A59C6BF6EF37DBBFBCC6A9357E", hash_generated_method = "651D4E4A131CFAC8FAFA1CCE7A0D773B")
        @Override
        public void onObbResult(String filename, int nonce, int status) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(status);
            addTaint(nonce);
            addTaint(filename.getTaint());
            ObbListenerDelegate delegate;
            synchronized
(mListeners)            {
                delegate = mListeners.get(nonce);
                if(delegate != null)                
                {
                    mListeners.remove(nonce);
                } //End block
            } //End block
            if(delegate != null)            
            {
                delegate.sendObbStateChanged(filename, status);
            } //End block
            // ---------- Original Method ----------
            //final ObbListenerDelegate delegate;
            //synchronized (mListeners) {
                //delegate = mListeners.get(nonce);
                //if (delegate != null) {
                    //mListeners.remove(nonce);
                //}
            //}
            //if (delegate != null) {
                //delegate.sendObbStateChanged(filename, status);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.077 -0400", hash_original_method = "8B6662593D8FF2E95312263F2E6C8A4E", hash_generated_method = "2A4A75DBC4271A43EDEA44277B2912E3")
        public int addListener(OnObbStateChangeListener listener) {
            addTaint(listener.getTaint());
            final ObbListenerDelegate delegate = new ObbListenerDelegate(listener);
            synchronized
(mListeners)            {
                mListeners.put(delegate.nonce, delegate);
            } //End block
            int varC67461545013B5F131CD98ABBB8A4FBA_702586406 = (delegate.nonce);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690456459 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690456459;
            // ---------- Original Method ----------
            //final ObbListenerDelegate delegate = new ObbListenerDelegate(listener);
            //synchronized (mListeners) {
                //mListeners.put(delegate.nonce, delegate);
            //}
            //return delegate.nonce;
        }

        
    }


    
    private class ObbListenerDelegate {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.077 -0400", hash_original_field = "CFA53EA895A869226B9A782B15E824C5", hash_generated_field = "9765B2BB1BD930598C2982AB60432360")

        private WeakReference<OnObbStateChangeListener> mObbEventListenerRef;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.077 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.077 -0400", hash_original_field = "CB584E44C43ED6BD0BC2D9C7E242837D", hash_generated_field = "025203DA6E702827C569DA1096B5E235")

        private int nonce;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.078 -0400", hash_original_method = "669DF05D8F2AD5FF486346330C6EAF78", hash_generated_method = "DA09D4C568A5A5BD724CCE7EC826DE9C")
          ObbListenerDelegate(OnObbStateChangeListener listener) {
            nonce = getNextNonce();
            mObbEventListenerRef = new WeakReference<OnObbStateChangeListener>(listener);
            mHandler = new Handler(mTgtLooper) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.078 -0400", hash_original_method = "DAAB8678F7ABEFF803CFD82CEA9641F0", hash_generated_method = "58491B527D6BFAE6854AF10E2154DFC9")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
                final OnObbStateChangeListener changeListener = getListener();
                if(changeListener == null)                
                {
                    return;
                } //End block
                StorageEvent e = (StorageEvent) msg.obj;
                if(msg.what == StorageEvent.EVENT_OBB_STATE_CHANGED)                
                {
                    ObbStateChangedStorageEvent ev = (ObbStateChangedStorageEvent) e;
                    changeListener.onObbStateChange(ev.path, ev.state);
                } //End block
                else
                {
                } //End block
                // ---------- Original Method ----------
                //final OnObbStateChangeListener changeListener = getListener();
                //if (changeListener == null) {
                        //return;
                    //}
                //StorageEvent e = (StorageEvent) msg.obj;
                //if (msg.what == StorageEvent.EVENT_OBB_STATE_CHANGED) {
                        //ObbStateChangedStorageEvent ev = (ObbStateChangedStorageEvent) e;
                        //changeListener.onObbStateChange(ev.path, ev.state);
                    //} else {
                        //Log.e(TAG, "Unsupported event " + msg.what);
                    //}
            }
};
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.078 -0400", hash_original_method = "834954D068AF2864C85CCAD9D321B725", hash_generated_method = "F9FE1E4DB54C2545F19A9754F59A1E06")
         OnObbStateChangeListener getListener() {
            if(mObbEventListenerRef == null)            
            {
OnObbStateChangeListener var540C13E9E156B687226421B24F2DF178_2036034865 =                 null;
                var540C13E9E156B687226421B24F2DF178_2036034865.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_2036034865;
            } //End block
OnObbStateChangeListener varCF4F6E9DEC208F220177AFF7A2E8BD7A_91045438 =             mObbEventListenerRef.get();
            varCF4F6E9DEC208F220177AFF7A2E8BD7A_91045438.addTaint(taint);
            return varCF4F6E9DEC208F220177AFF7A2E8BD7A_91045438;
            // ---------- Original Method ----------
            //if (mObbEventListenerRef == null) {
                //return null;
            //}
            //return mObbEventListenerRef.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.078 -0400", hash_original_method = "E278FF9F38CD6580E6FCEF436B6AB830", hash_generated_method = "6DEBFD25277C0EC31E213CE1AC291962")
         void sendObbStateChanged(String path, int state) {
            addTaint(state);
            addTaint(path.getTaint());
            ObbStateChangedStorageEvent e = new ObbStateChangedStorageEvent(path, state);
            mHandler.sendMessage(e.getMessage());
            // ---------- Original Method ----------
            //ObbStateChangedStorageEvent e = new ObbStateChangedStorageEvent(path, state);
            //mHandler.sendMessage(e.getMessage());
        }

        
    }


    
    private class ObbStateChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.079 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "58104DC4D068DCE57A6D46AB8F30ECAD")

        public String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.079 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "47895903500EF3C437D3B693442F9718")

        public int state;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.079 -0400", hash_original_method = "B6A5FB82143B81E65B529E1CD0C6BFE8", hash_generated_method = "D7B87FD5151A53761078D39156714F78")
        public  ObbStateChangedStorageEvent(String path, int state) {
            super(EVENT_OBB_STATE_CHANGED);
            this.path = path;
            this.state = state;
            // ---------- Original Method ----------
            //this.path = path;
            //this.state = state;
        }

        
    }


    
    private class StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.080 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "C86344D57FB924DFB1BCA88A74120A66")

        private Message mMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.081 -0400", hash_original_method = "546E2CE4C7A72D6081E7A50312A352DB", hash_generated_method = "5CD343B512863C315F98F2AEA9C011F5")
        public  StorageEvent(int what) {
            mMessage = Message.obtain();
            mMessage.what = what;
            mMessage.obj = this;
            // ---------- Original Method ----------
            //mMessage = Message.obtain();
            //mMessage.what = what;
            //mMessage.obj = this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.082 -0400", hash_original_method = "237083C18B821DBF98088C4FF8F2E015", hash_generated_method = "4F361928DAE5EB0CFF21640335B8F18D")
        public Message getMessage() {
Message varF433E876D1576C042493660DEE33CDC1_1737579052 =             mMessage;
            varF433E876D1576C042493660DEE33CDC1_1737579052.addTaint(taint);
            return varF433E876D1576C042493660DEE33CDC1_1737579052;
            // ---------- Original Method ----------
            //return mMessage;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.082 -0400", hash_original_field = "1564EF349AB04E42B8AE80445E8A296E", hash_generated_field = "F25F6D444BE5A1CFBE4DF466A9A1F864")

        static final int EVENT_UMS_CONNECTION_CHANGED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.082 -0400", hash_original_field = "C5FC45E4D75061C27D49818F135CA8F5", hash_generated_field = "583879D14E1BDFFE9CB4B6C78D72E1EC")

        static final int EVENT_STORAGE_STATE_CHANGED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.082 -0400", hash_original_field = "4455CDC446630A55078BE82059DCDB56", hash_generated_field = "C550BF0DE2FD736DF2E8992E748ECE57")

        static final int EVENT_OBB_STATE_CHANGED = 3;
    }


    
    private class UmsConnectionChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.082 -0400", hash_original_field = "E4894CA167B08880BFC35862F18575EB", hash_generated_field = "5C92C83D4651FA2CBBBE9F57619106E0")

        public boolean available;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.083 -0400", hash_original_method = "DA139192DF79A1B6AF4FBD170F57C738", hash_generated_method = "455690CD38D17C90E3960C0D3AE6FBD7")
        public  UmsConnectionChangedStorageEvent(boolean a) {
            super(EVENT_UMS_CONNECTION_CHANGED);
            available = a;
            // ---------- Original Method ----------
            //available = a;
        }

        
    }


    
    private class StorageStateChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.083 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "58104DC4D068DCE57A6D46AB8F30ECAD")

        public String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.083 -0400", hash_original_field = "72D6992B63A3C6CEDED7A4F910A17DB4", hash_generated_field = "BCBDB4C878C0401D1D7D5840C50DA786")

        public String oldState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.083 -0400", hash_original_field = "C12B256FB80BF45233F7969DDAD635A8", hash_generated_field = "BBB1EB05FA22C108537691E37AFB1F82")

        public String newState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.084 -0400", hash_original_method = "492691CEB211515F22C314109DCC65E2", hash_generated_method = "AEFC7259D8036A6EC5FA18B5B26F25C2")
        public  StorageStateChangedStorageEvent(String p, String oldS, String newS) {
            super(EVENT_STORAGE_STATE_CHANGED);
            path = p;
            oldState = oldS;
            newState = newS;
            // ---------- Original Method ----------
            //path = p;
            //oldState = oldS;
            //newState = newS;
        }

        
    }


    
    private class ListenerDelegate {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.084 -0400", hash_original_field = "FF21AF7F25ACB77348D1744416043B3F", hash_generated_field = "7A1C33253FE6C5A1C1F7242C2999F45E")

        StorageEventListener mStorageEventListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.084 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.085 -0400", hash_original_method = "9AED46AC5CC711FE51A627C97DCCA6A0", hash_generated_method = "4BDF51206D9C521E57479CA6E4CEA118")
          ListenerDelegate(StorageEventListener listener) {
            mStorageEventListener = listener;
            mHandler = new Handler(mTgtLooper) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.084 -0400", hash_original_method = "366C40A0CA9BA10DE636D79A04377DDA", hash_generated_method = "2E18563152040950832F72FBC36E136A")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
                StorageEvent e = (StorageEvent) msg.obj;
                if(msg.what == StorageEvent.EVENT_UMS_CONNECTION_CHANGED)                
                {
                    UmsConnectionChangedStorageEvent ev = (UmsConnectionChangedStorageEvent) e;
                    mStorageEventListener.onUsbMassStorageConnectionChanged(ev.available);
                } //End block
                else
                if(msg.what == StorageEvent.EVENT_STORAGE_STATE_CHANGED)                
                {
                    StorageStateChangedStorageEvent ev = (StorageStateChangedStorageEvent) e;
                    mStorageEventListener.onStorageStateChanged(ev.path, ev.oldState, ev.newState);
                } //End block
                else
                {
                } //End block
                // ---------- Original Method ----------
                //StorageEvent e = (StorageEvent) msg.obj;
                //if (msg.what == StorageEvent.EVENT_UMS_CONNECTION_CHANGED) {
                        //UmsConnectionChangedStorageEvent ev = (UmsConnectionChangedStorageEvent) e;
                        //mStorageEventListener.onUsbMassStorageConnectionChanged(ev.available);
                    //} else if (msg.what == StorageEvent.EVENT_STORAGE_STATE_CHANGED) {
                        //StorageStateChangedStorageEvent ev = (StorageStateChangedStorageEvent) e;
                        //mStorageEventListener.onStorageStateChanged(ev.path, ev.oldState, ev.newState);
                    //} else {
                        //Log.e(TAG, "Unsupported event " + msg.what);
                    //}
            }
};
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.085 -0400", hash_original_method = "DA2EC644741ABB32C38C92FF70A87DA0", hash_generated_method = "14F9989F27446BDBD63667A618B9C120")
         StorageEventListener getListener() {
StorageEventListener varE7702B5CA1C4D4B989CA9AA0E2DA9878_419910665 =             mStorageEventListener;
            varE7702B5CA1C4D4B989CA9AA0E2DA9878_419910665.addTaint(taint);
            return varE7702B5CA1C4D4B989CA9AA0E2DA9878_419910665;
            // ---------- Original Method ----------
            //return mStorageEventListener;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.085 -0400", hash_original_method = "2B1B76FC8373F60078A15952F701EC30", hash_generated_method = "02E226889414FA9CC2064DE3C95335B0")
         void sendShareAvailabilityChanged(boolean available) {
            addTaint(available);
            UmsConnectionChangedStorageEvent e = new UmsConnectionChangedStorageEvent(available);
            mHandler.sendMessage(e.getMessage());
            // ---------- Original Method ----------
            //UmsConnectionChangedStorageEvent e = new UmsConnectionChangedStorageEvent(available);
            //mHandler.sendMessage(e.getMessage());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.085 -0400", hash_original_method = "6996CC17777F13485A3BD31F01C08054", hash_generated_method = "2EC0C513477C5698507768AD75CBBFE7")
         void sendStorageStateChanged(String path, String oldState, String newState) {
            addTaint(newState.getTaint());
            addTaint(oldState.getTaint());
            addTaint(path.getTaint());
            StorageStateChangedStorageEvent e = new StorageStateChangedStorageEvent(path, oldState, newState);
            mHandler.sendMessage(e.getMessage());
            // ---------- Original Method ----------
            //StorageStateChangedStorageEvent e = new StorageStateChangedStorageEvent(path, oldState, newState);
            //mHandler.sendMessage(e.getMessage());
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.085 -0400", hash_original_field = "414DE376B4CE8230DB4AAE54D9434AD8", hash_generated_field = "666FAAC497550CA891D002F26E180573")

    private static final String TAG = "StorageManager";
}

