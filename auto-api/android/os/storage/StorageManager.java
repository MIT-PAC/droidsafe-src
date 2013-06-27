package android.os.storage;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.000 -0400", hash_original_field = "B37A65C8E4C16F5F00CB3D4C405B1D2D", hash_generated_field = "824B06D572005F1C1B35E543BCE5CB91")

    private IMountService mMountService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.000 -0400", hash_original_field = "5692822DD64189A155C0B07187EEFFB3", hash_generated_field = "E3C963BED00097FA8564C04087A24015")

    Looper mTgtLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.000 -0400", hash_original_field = "F81851926FFC4DCF86E6D654AB1BBAAA", hash_generated_field = "5F09598E7B5B6EF08AE05EA113FDAB16")

    private MountServiceBinderListener mBinderListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.000 -0400", hash_original_field = "8E1997AA994FFA9E245B45EC4669EE3A", hash_generated_field = "D62245B7A50796BE5B27202ED9DFC7AD")

    private List<ListenerDelegate> mListeners = new ArrayList<ListenerDelegate>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.000 -0400", hash_original_field = "356408C1C2A45791A2F283870313B4EF", hash_generated_field = "DB866E672A95EB99F13427C8A16BC707")

    private AtomicInteger mNextNonce = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.000 -0400", hash_original_field = "7E22501E409D142941C1EB6DB191FCD0", hash_generated_field = "862CF9AA2BB183362C3BAEB048BA0B51")

    private ObbActionListener mObbActionListener = new ObbActionListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.001 -0400", hash_original_method = "1751DA8EA422A6A8B82F8F3E4926F05B", hash_generated_method = "644DBA139D4FD17AD5CAB43DB66A804D")
    public  StorageManager(Looper tgtLooper) throws RemoteException {
        mMountService = IMountService.Stub.asInterface(ServiceManager.getService("mount"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.010 -0400", hash_original_method = "E880709C72C5FA3A0762DDC8432351B1", hash_generated_method = "45B8C5E030E1B88290EEE40D5D17A0AA")
    private int getNextNonce() {
        int var6CB6DA04F0730EF8B511B3B8FFC9F8A7_1184994435 = (mNextNonce.getAndIncrement());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988269305 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988269305;
        // ---------- Original Method ----------
        //return mNextNonce.getAndIncrement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.010 -0400", hash_original_method = "99C6C81E5E38E1D6866033383A8A6E37", hash_generated_method = "261295FAA3F7F640339DD8222D623EE2")
    public void registerListener(StorageEventListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            mListeners.add(new ListenerDelegate(listener));
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (listener == null) {
            //return;
        //}
        //synchronized (mListeners) {
            //mListeners.add(new ListenerDelegate(listener));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.011 -0400", hash_original_method = "3AB3B2EFDC587B358784DA10414214BD", hash_generated_method = "DC8A724CC18F23D0966D82AB25C2202A")
    public void unregisterListener(StorageEventListener listener) {
        {
            int size;
            size = mListeners.size();
            {
                int i;
                i = 0;
                {
                    ListenerDelegate l;
                    l = mListeners.get(i);
                    {
                        boolean var59EE92861E91E921B93BC86C1074CE98_466171780 = (l.getListener() == listener);
                        {
                            mListeners.remove(i);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(listener.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.015 -0400", hash_original_method = "5EB71443ECA98B5E7A476E0AE8AAD3AD", hash_generated_method = "368A1289ED4737EFAE8CBE8CEAC0A1AF")
    public void enableUsbMassStorage() {
        try 
        {
            mMountService.setUsbMassStorageEnabled(true);
        } //End block
        catch (Exception ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mMountService.setUsbMassStorageEnabled(true);
        //} catch (Exception ex) {
            //Log.e(TAG, "Failed to enable UMS", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.029 -0400", hash_original_method = "663240D4ECB8ED0B06161F54AFBC5E98", hash_generated_method = "C629A41C3AD430654F399A0AC242904F")
    public void disableUsbMassStorage() {
        try 
        {
            mMountService.setUsbMassStorageEnabled(false);
        } //End block
        catch (Exception ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mMountService.setUsbMassStorageEnabled(false);
        //} catch (Exception ex) {
            //Log.e(TAG, "Failed to disable UMS", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.030 -0400", hash_original_method = "09220D6F0F0E5ED3096951AEB948E338", hash_generated_method = "F080FA779C120CB3454B2CD0C1F38094")
    public boolean isUsbMassStorageConnected() {
        try 
        {
            boolean varB76AEDE2DC40626AB3B07AE1ACEABEB7_549239395 = (mMountService.isUsbMassStorageConnected());
        } //End block
        catch (Exception ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349055859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349055859;
        // ---------- Original Method ----------
        //try {
            //return mMountService.isUsbMassStorageConnected();
        //} catch (Exception ex) {
            //Log.e(TAG, "Failed to get UMS connection state", ex);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.031 -0400", hash_original_method = "D60840A90A5B0A49A8865BA4D2E3CCDB", hash_generated_method = "316BCA538559B2270B920AF03C61E4FD")
    public boolean isUsbMassStorageEnabled() {
        try 
        {
            boolean varA4535BADAA0FB8D2BE957451B086D7B1_1041938384 = (mMountService.isUsbMassStorageEnabled());
        } //End block
        catch (RemoteException rex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756836016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_756836016;
        // ---------- Original Method ----------
        //try {
            //return mMountService.isUsbMassStorageEnabled();
        //} catch (RemoteException rex) {
            //Log.e(TAG, "Failed to get UMS enable state", rex);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.032 -0400", hash_original_method = "534072486045B703901D00BD8CC513FF", hash_generated_method = "3192FBAD34239E8B6D7A48982FBBC467")
    public boolean mountObb(String filename, String key, OnObbStateChangeListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener cannot be null");
        } //End block
        try 
        {
            int nonce;
            nonce = mObbActionListener.addListener(listener);
            mMountService.mountObb(filename, key, mObbActionListener, nonce);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(filename.getTaint());
        addTaint(key.getTaint());
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1769068733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1769068733;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.039 -0400", hash_original_method = "49ADFC5746B1589055920681F4A3DF66", hash_generated_method = "DEFA0F68ABF72D39473DFAA4D25D9064")
    public boolean unmountObb(String filename, boolean force, OnObbStateChangeListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("listener cannot be null");
        } //End block
        try 
        {
            int nonce;
            nonce = mObbActionListener.addListener(listener);
            mMountService.unmountObb(filename, force, mObbActionListener, nonce);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(filename.getTaint());
        addTaint(force);
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_463732648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_463732648;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.049 -0400", hash_original_method = "4111120C74906E4EF74CC0B96E5C85EA", hash_generated_method = "CAF6FF33DDCC27DC954C075C2147F3D9")
    public boolean isObbMounted(String filename) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } //End block
        try 
        {
            boolean var5CFC3377858B4598A6454628DE929077_1723590614 = (mMountService.isObbMounted(filename));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(filename.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_836599250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_836599250;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.054 -0400", hash_original_method = "4524FA5E45068B5E619708F061E65DAB", hash_generated_method = "002333BF2059A9554A00D9F7C2A3F926")
    public String getMountedObbPath(String filename) {
        String varB4EAC82CA7396A68D541C85D26508E83_1800773138 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1506853351 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1800773138 = mMountService.getMountedObbPath(filename);
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1506853351 = null;
        addTaint(filename.getTaint());
        String varA7E53CE21691AB073D9660D615818899_827593200; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_827593200 = varB4EAC82CA7396A68D541C85D26508E83_1800773138;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_827593200 = varB4EAC82CA7396A68D541C85D26508E83_1506853351;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_827593200.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_827593200;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.055 -0400", hash_original_method = "9BA3F19D0DE55EC9B6B86E9B817FE10B", hash_generated_method = "8C71EBFE242126A145F55E12D2F41415")
    public String getVolumeState(String mountPoint) {
        String varB4EAC82CA7396A68D541C85D26508E83_1839588298 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_353608531 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1839588298 = mMountService.getVolumeState(mountPoint);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_353608531 = null;
        } //End block
        addTaint(mountPoint.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1071935829; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1071935829 = varB4EAC82CA7396A68D541C85D26508E83_1839588298;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1071935829 = varB4EAC82CA7396A68D541C85D26508E83_353608531;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1071935829.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1071935829;
        // ---------- Original Method ----------
        //try {
            //return mMountService.getVolumeState(mountPoint);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Failed to get volume state", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.060 -0400", hash_original_method = "7E321C52EE616E46A0C899410949AC4D", hash_generated_method = "6C3A30B0C6D2A4C90123DB87665C37DC")
    public StorageVolume[] getVolumeList() {
        StorageVolume[] varB4EAC82CA7396A68D541C85D26508E83_1556553691 = null; //Variable for return #1
        StorageVolume[] varB4EAC82CA7396A68D541C85D26508E83_1230852620 = null; //Variable for return #2
        StorageVolume[] varB4EAC82CA7396A68D541C85D26508E83_1247771393 = null; //Variable for return #3
        try 
        {
            Parcelable[] list;
            list = mMountService.getVolumeList();
            varB4EAC82CA7396A68D541C85D26508E83_1556553691 = new StorageVolume[0];
            int length;
            length = list.length;
            StorageVolume[] result;
            result = new StorageVolume[length];
            {
                int i;
                i = 0;
                {
                    result[i] = (StorageVolume)list[i];
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1230852620 = result;
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1247771393 = null;
        } //End block
        StorageVolume[] varA7E53CE21691AB073D9660D615818899_1907532463; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1907532463 = varB4EAC82CA7396A68D541C85D26508E83_1556553691;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1907532463 = varB4EAC82CA7396A68D541C85D26508E83_1230852620;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1907532463 = varB4EAC82CA7396A68D541C85D26508E83_1247771393;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1907532463.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1907532463;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.084 -0400", hash_original_method = "32FCB28C74C473CB8B8088CF6B7B3DD3", hash_generated_method = "FCBF1F5FD18D6F62D3182BB3A45484CC")
    public String[] getVolumePaths() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1458892099 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_751106367 = null; //Variable for return #2
        StorageVolume[] volumes;
        volumes = getVolumeList();
        varB4EAC82CA7396A68D541C85D26508E83_1458892099 = null;
        int count;
        count = volumes.length;
        String[] paths;
        paths = new String[count];
        {
            int i;
            i = 0;
            {
                paths[i] = volumes[i].getPath();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_751106367 = paths;
        String[] varA7E53CE21691AB073D9660D615818899_90930716; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_90930716 = varB4EAC82CA7396A68D541C85D26508E83_1458892099;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_90930716 = varB4EAC82CA7396A68D541C85D26508E83_751106367;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_90930716.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_90930716;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.084 -0400", hash_original_method = "2B96EE5216074DC94A336B5EA39CF13F", hash_generated_method = "2B96EE5216074DC94A336B5EA39CF13F")
        public MountServiceBinderListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.085 -0400", hash_original_method = "3247F72E228BC8CA6CB0EFFDE0587175", hash_generated_method = "14B4A544BD0BC44DD729E25E16BBFAA3")
        public void onUsbMassStorageConnectionChanged(boolean available) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            int size;
            size = mListeners.size();
            {
                int i;
                i = 0;
                {
                    mListeners.get(i).sendShareAvailabilityChanged(available);
                } //End block
            } //End collapsed parenthetic
            addTaint(available);
            // ---------- Original Method ----------
            //final int size = mListeners.size();
            //for (int i = 0; i < size; i++) {
                //mListeners.get(i).sendShareAvailabilityChanged(available);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.085 -0400", hash_original_method = "3412F22C5256750E7F040A232BDF8730", hash_generated_method = "7DF0E83AE95274F7CD39FDADA81B4077")
        public void onStorageStateChanged(String path, String oldState, String newState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            int size;
            size = mListeners.size();
            {
                int i;
                i = 0;
                {
                    mListeners.get(i).sendStorageStateChanged(path, oldState, newState);
                } //End block
            } //End collapsed parenthetic
            addTaint(path.getTaint());
            addTaint(oldState.getTaint());
            addTaint(newState.getTaint());
            // ---------- Original Method ----------
            //final int size = mListeners.size();
            //for (int i = 0; i < size; i++) {
                //mListeners.get(i).sendStorageStateChanged(path, oldState, newState);
            //}
        }

        
    }


    
    private class ObbActionListener extends IObbActionListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.086 -0400", hash_original_field = "F5548429C14A65BFC2537D3DA1DC8B9A", hash_generated_field = "B401ACBFDEFD68175AFBDCAE004213C6")

        @SuppressWarnings("hiding") private SparseArray<ObbListenerDelegate> mListeners = new SparseArray<ObbListenerDelegate>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.086 -0400", hash_original_method = "A19676FD811ED2BA9E2295E50F44897A", hash_generated_method = "A19676FD811ED2BA9E2295E50F44897A")
        public ObbActionListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.087 -0400", hash_original_method = "DBB9E3A59C6BF6EF37DBBFBCC6A9357E", hash_generated_method = "05A2EFE999F637A2BA18F6B76B747425")
        @Override
        public void onObbResult(String filename, int nonce, int status) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            ObbListenerDelegate delegate;
            {
                delegate = mListeners.get(nonce);
                {
                    mListeners.remove(nonce);
                } //End block
            } //End block
            {
                delegate.sendObbStateChanged(filename, status);
            } //End block
            addTaint(filename.getTaint());
            addTaint(nonce);
            addTaint(status);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.087 -0400", hash_original_method = "8B6662593D8FF2E95312263F2E6C8A4E", hash_generated_method = "C92B316CBE1D4E782750EA8C097D57FC")
        public int addListener(OnObbStateChangeListener listener) {
            ObbListenerDelegate delegate;
            delegate = new ObbListenerDelegate(listener);
            {
                mListeners.put(delegate.nonce, delegate);
            } //End block
            addTaint(listener.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089682910 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089682910;
            // ---------- Original Method ----------
            //final ObbListenerDelegate delegate = new ObbListenerDelegate(listener);
            //synchronized (mListeners) {
                //mListeners.put(delegate.nonce, delegate);
            //}
            //return delegate.nonce;
        }

        
    }


    
    private class ObbListenerDelegate {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.109 -0400", hash_original_field = "CFA53EA895A869226B9A782B15E824C5", hash_generated_field = "9765B2BB1BD930598C2982AB60432360")

        private WeakReference<OnObbStateChangeListener> mObbEventListenerRef;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.109 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.109 -0400", hash_original_field = "CB584E44C43ED6BD0BC2D9C7E242837D", hash_generated_field = "025203DA6E702827C569DA1096B5E235")

        private int nonce;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.112 -0400", hash_original_method = "669DF05D8F2AD5FF486346330C6EAF78", hash_generated_method = "8EFFEEAC095DA1CAD1663AD4760041CA")
          ObbListenerDelegate(OnObbStateChangeListener listener) {
            nonce = getNextNonce();
            mObbEventListenerRef = new WeakReference<OnObbStateChangeListener>(listener);
            mHandler = new Handler(mTgtLooper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.112 -0400", hash_original_method = "DAAB8678F7ABEFF803CFD82CEA9641F0", hash_generated_method = "3CC64C6EF5EC5D9EA5D50841D1458B8B")
                @Override
                public void handleMessage(Message msg) {
                    OnObbStateChangeListener changeListener;
                    changeListener = getListener();
                    StorageEvent e;
                    e = (StorageEvent) msg.obj;
                    {
                        ObbStateChangedStorageEvent ev;
                        ev = (ObbStateChangedStorageEvent) e;
                        changeListener.onObbStateChange(ev.path, ev.state);
                    } //End block
                    addTaint(msg.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.132 -0400", hash_original_method = "834954D068AF2864C85CCAD9D321B725", hash_generated_method = "701327DA10426944A00620E7EA0FF7E2")
         OnObbStateChangeListener getListener() {
            OnObbStateChangeListener varB4EAC82CA7396A68D541C85D26508E83_1564935666 = null; //Variable for return #1
            OnObbStateChangeListener varB4EAC82CA7396A68D541C85D26508E83_1617246810 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1564935666 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1617246810 = mObbEventListenerRef.get();
            OnObbStateChangeListener varA7E53CE21691AB073D9660D615818899_1916767541; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1916767541 = varB4EAC82CA7396A68D541C85D26508E83_1564935666;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1916767541 = varB4EAC82CA7396A68D541C85D26508E83_1617246810;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1916767541.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1916767541;
            // ---------- Original Method ----------
            //if (mObbEventListenerRef == null) {
                //return null;
            //}
            //return mObbEventListenerRef.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.143 -0400", hash_original_method = "E278FF9F38CD6580E6FCEF436B6AB830", hash_generated_method = "7B4F15309C8D4E9EB03B1B388E0805C9")
         void sendObbStateChanged(String path, int state) {
            ObbStateChangedStorageEvent e;
            e = new ObbStateChangedStorageEvent(path, state);
            mHandler.sendMessage(e.getMessage());
            addTaint(path.getTaint());
            addTaint(state);
            // ---------- Original Method ----------
            //ObbStateChangedStorageEvent e = new ObbStateChangedStorageEvent(path, state);
            //mHandler.sendMessage(e.getMessage());
        }

        
    }


    
    private class ObbStateChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.143 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "58104DC4D068DCE57A6D46AB8F30ECAD")

        public String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.143 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "47895903500EF3C437D3B693442F9718")

        public int state;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.144 -0400", hash_original_method = "B6A5FB82143B81E65B529E1CD0C6BFE8", hash_generated_method = "D7B87FD5151A53761078D39156714F78")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.144 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "C86344D57FB924DFB1BCA88A74120A66")

        private Message mMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.145 -0400", hash_original_method = "546E2CE4C7A72D6081E7A50312A352DB", hash_generated_method = "5CD343B512863C315F98F2AEA9C011F5")
        public  StorageEvent(int what) {
            mMessage = Message.obtain();
            mMessage.what = what;
            mMessage.obj = this;
            // ---------- Original Method ----------
            //mMessage = Message.obtain();
            //mMessage.what = what;
            //mMessage.obj = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.145 -0400", hash_original_method = "237083C18B821DBF98088C4FF8F2E015", hash_generated_method = "B45DCAB0D7884651A2F2E839F3B97B75")
        public Message getMessage() {
            Message varB4EAC82CA7396A68D541C85D26508E83_581793928 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_581793928 = mMessage;
            varB4EAC82CA7396A68D541C85D26508E83_581793928.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_581793928;
            // ---------- Original Method ----------
            //return mMessage;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.146 -0400", hash_original_field = "1564EF349AB04E42B8AE80445E8A296E", hash_generated_field = "23C449B6581E1ED10138FAC889CCC113")

        static int EVENT_UMS_CONNECTION_CHANGED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.146 -0400", hash_original_field = "C5FC45E4D75061C27D49818F135CA8F5", hash_generated_field = "783F7A50DDFA22BF9419EB6D4EC1053A")

        static int EVENT_STORAGE_STATE_CHANGED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.146 -0400", hash_original_field = "4455CDC446630A55078BE82059DCDB56", hash_generated_field = "F321B2D9DAABC826821F5DE747858166")

        static int EVENT_OBB_STATE_CHANGED = 3;
    }


    
    private class UmsConnectionChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.146 -0400", hash_original_field = "E4894CA167B08880BFC35862F18575EB", hash_generated_field = "5C92C83D4651FA2CBBBE9F57619106E0")

        public boolean available;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.147 -0400", hash_original_method = "DA139192DF79A1B6AF4FBD170F57C738", hash_generated_method = "455690CD38D17C90E3960C0D3AE6FBD7")
        public  UmsConnectionChangedStorageEvent(boolean a) {
            super(EVENT_UMS_CONNECTION_CHANGED);
            available = a;
            // ---------- Original Method ----------
            //available = a;
        }

        
    }


    
    private class StorageStateChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.163 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "58104DC4D068DCE57A6D46AB8F30ECAD")

        public String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.163 -0400", hash_original_field = "72D6992B63A3C6CEDED7A4F910A17DB4", hash_generated_field = "BCBDB4C878C0401D1D7D5840C50DA786")

        public String oldState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.164 -0400", hash_original_field = "C12B256FB80BF45233F7969DDAD635A8", hash_generated_field = "BBB1EB05FA22C108537691E37AFB1F82")

        public String newState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.164 -0400", hash_original_method = "492691CEB211515F22C314109DCC65E2", hash_generated_method = "AEFC7259D8036A6EC5FA18B5B26F25C2")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.165 -0400", hash_original_field = "FF21AF7F25ACB77348D1744416043B3F", hash_generated_field = "7A1C33253FE6C5A1C1F7242C2999F45E")

        StorageEventListener mStorageEventListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.165 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.184 -0400", hash_original_method = "9AED46AC5CC711FE51A627C97DCCA6A0", hash_generated_method = "D1B59958E71F5408EA5C2714F2E926F7")
          ListenerDelegate(StorageEventListener listener) {
            mStorageEventListener = listener;
            mHandler = new Handler(mTgtLooper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.183 -0400", hash_original_method = "366C40A0CA9BA10DE636D79A04377DDA", hash_generated_method = "E5730FF1F36BC3FC94771E188044AA5E")
                @Override
                public void handleMessage(Message msg) {
                    StorageEvent e;
                    e = (StorageEvent) msg.obj;
                    {
                        UmsConnectionChangedStorageEvent ev;
                        ev = (UmsConnectionChangedStorageEvent) e;
                        mStorageEventListener.onUsbMassStorageConnectionChanged(ev.available);
                    } //End block
                    {
                        StorageStateChangedStorageEvent ev;
                        ev = (StorageStateChangedStorageEvent) e;
                        mStorageEventListener.onStorageStateChanged(ev.path, ev.oldState, ev.newState);
                    } //End block
                    addTaint(msg.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.189 -0400", hash_original_method = "DA2EC644741ABB32C38C92FF70A87DA0", hash_generated_method = "5F6F25B9793468CF1FA3A15DF4454372")
         StorageEventListener getListener() {
            StorageEventListener varB4EAC82CA7396A68D541C85D26508E83_1142297832 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1142297832 = mStorageEventListener;
            varB4EAC82CA7396A68D541C85D26508E83_1142297832.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1142297832;
            // ---------- Original Method ----------
            //return mStorageEventListener;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.204 -0400", hash_original_method = "2B1B76FC8373F60078A15952F701EC30", hash_generated_method = "87DFDF226B0DA1AD7E45CA1C72941D4A")
         void sendShareAvailabilityChanged(boolean available) {
            UmsConnectionChangedStorageEvent e;
            e = new UmsConnectionChangedStorageEvent(available);
            mHandler.sendMessage(e.getMessage());
            addTaint(available);
            // ---------- Original Method ----------
            //UmsConnectionChangedStorageEvent e = new UmsConnectionChangedStorageEvent(available);
            //mHandler.sendMessage(e.getMessage());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.205 -0400", hash_original_method = "6996CC17777F13485A3BD31F01C08054", hash_generated_method = "5E6E3C7DC1A120B7BEE2F3373C5F8C1E")
         void sendStorageStateChanged(String path, String oldState, String newState) {
            StorageStateChangedStorageEvent e;
            e = new StorageStateChangedStorageEvent(path, oldState, newState);
            mHandler.sendMessage(e.getMessage());
            addTaint(path.getTaint());
            addTaint(oldState.getTaint());
            addTaint(newState.getTaint());
            // ---------- Original Method ----------
            //StorageStateChangedStorageEvent e = new StorageStateChangedStorageEvent(path, oldState, newState);
            //mHandler.sendMessage(e.getMessage());
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.205 -0400", hash_original_field = "414DE376B4CE8230DB4AAE54D9434AD8", hash_generated_field = "C6C444618DC359497E4CF0D3E88391F5")

    private static String TAG = "StorageManager";
}

