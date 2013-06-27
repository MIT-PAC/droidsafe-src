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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.733 -0400", hash_original_field = "B37A65C8E4C16F5F00CB3D4C405B1D2D", hash_generated_field = "824B06D572005F1C1B35E543BCE5CB91")

    private IMountService mMountService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.733 -0400", hash_original_field = "5692822DD64189A155C0B07187EEFFB3", hash_generated_field = "E3C963BED00097FA8564C04087A24015")

    Looper mTgtLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.733 -0400", hash_original_field = "F81851926FFC4DCF86E6D654AB1BBAAA", hash_generated_field = "5F09598E7B5B6EF08AE05EA113FDAB16")

    private MountServiceBinderListener mBinderListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.734 -0400", hash_original_field = "8E1997AA994FFA9E245B45EC4669EE3A", hash_generated_field = "D62245B7A50796BE5B27202ED9DFC7AD")

    private List<ListenerDelegate> mListeners = new ArrayList<ListenerDelegate>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.734 -0400", hash_original_field = "356408C1C2A45791A2F283870313B4EF", hash_generated_field = "DB866E672A95EB99F13427C8A16BC707")

    private AtomicInteger mNextNonce = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.734 -0400", hash_original_field = "7E22501E409D142941C1EB6DB191FCD0", hash_generated_field = "862CF9AA2BB183362C3BAEB048BA0B51")

    private ObbActionListener mObbActionListener = new ObbActionListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.735 -0400", hash_original_method = "1751DA8EA422A6A8B82F8F3E4926F05B", hash_generated_method = "644DBA139D4FD17AD5CAB43DB66A804D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.735 -0400", hash_original_method = "E880709C72C5FA3A0762DDC8432351B1", hash_generated_method = "3995C829333A55E83A8486A2121892B5")
    private int getNextNonce() {
        int var6CB6DA04F0730EF8B511B3B8FFC9F8A7_1814885594 = (mNextNonce.getAndIncrement());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1978293695 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1978293695;
        // ---------- Original Method ----------
        //return mNextNonce.getAndIncrement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.751 -0400", hash_original_method = "99C6C81E5E38E1D6866033383A8A6E37", hash_generated_method = "261295FAA3F7F640339DD8222D623EE2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.754 -0400", hash_original_method = "3AB3B2EFDC587B358784DA10414214BD", hash_generated_method = "4C049FD0CE429A296DBAD1B37DCEA354")
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
                        boolean var59EE92861E91E921B93BC86C1074CE98_1917800951 = (l.getListener() == listener);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.755 -0400", hash_original_method = "5EB71443ECA98B5E7A476E0AE8AAD3AD", hash_generated_method = "368A1289ED4737EFAE8CBE8CEAC0A1AF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.756 -0400", hash_original_method = "663240D4ECB8ED0B06161F54AFBC5E98", hash_generated_method = "C629A41C3AD430654F399A0AC242904F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.761 -0400", hash_original_method = "09220D6F0F0E5ED3096951AEB948E338", hash_generated_method = "C4E8EBE31ED2F53EF4530FE9FCA6B76D")
    public boolean isUsbMassStorageConnected() {
        try 
        {
            boolean varB76AEDE2DC40626AB3B07AE1ACEABEB7_819794594 = (mMountService.isUsbMassStorageConnected());
        } //End block
        catch (Exception ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866245969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866245969;
        // ---------- Original Method ----------
        //try {
            //return mMountService.isUsbMassStorageConnected();
        //} catch (Exception ex) {
            //Log.e(TAG, "Failed to get UMS connection state", ex);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.770 -0400", hash_original_method = "D60840A90A5B0A49A8865BA4D2E3CCDB", hash_generated_method = "EA5DF4D75140AAC25E90A430A2B09191")
    public boolean isUsbMassStorageEnabled() {
        try 
        {
            boolean varA4535BADAA0FB8D2BE957451B086D7B1_264331335 = (mMountService.isUsbMassStorageEnabled());
        } //End block
        catch (RemoteException rex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136446233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136446233;
        // ---------- Original Method ----------
        //try {
            //return mMountService.isUsbMassStorageEnabled();
        //} catch (RemoteException rex) {
            //Log.e(TAG, "Failed to get UMS enable state", rex);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.771 -0400", hash_original_method = "534072486045B703901D00BD8CC513FF", hash_generated_method = "21E288A6E48F4DFB94DFBDEF9893F50D")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1414234972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1414234972;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.772 -0400", hash_original_method = "49ADFC5746B1589055920681F4A3DF66", hash_generated_method = "58E1AE3D8B3349A3C1F2A59E2487E650")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_490473366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_490473366;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.781 -0400", hash_original_method = "4111120C74906E4EF74CC0B96E5C85EA", hash_generated_method = "8B61AF0A44666402B811CF0ECF61B187")
    public boolean isObbMounted(String filename) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } //End block
        try 
        {
            boolean var5CFC3377858B4598A6454628DE929077_736107769 = (mMountService.isObbMounted(filename));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(filename.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1975309996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1975309996;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.782 -0400", hash_original_method = "4524FA5E45068B5E619708F061E65DAB", hash_generated_method = "B1A5F1E49FB5ED638FEFB84A26B543E0")
    public String getMountedObbPath(String filename) {
        String varB4EAC82CA7396A68D541C85D26508E83_1658381302 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2075376199 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1658381302 = mMountService.getMountedObbPath(filename);
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_2075376199 = null;
        addTaint(filename.getTaint());
        String varA7E53CE21691AB073D9660D615818899_352620883; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_352620883 = varB4EAC82CA7396A68D541C85D26508E83_1658381302;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_352620883 = varB4EAC82CA7396A68D541C85D26508E83_2075376199;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_352620883.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_352620883;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.786 -0400", hash_original_method = "9BA3F19D0DE55EC9B6B86E9B817FE10B", hash_generated_method = "C728FE76E1BB72B41854AECA4DD2D2AF")
    public String getVolumeState(String mountPoint) {
        String varB4EAC82CA7396A68D541C85D26508E83_777524464 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_670941595 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_777524464 = mMountService.getVolumeState(mountPoint);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_670941595 = null;
        } //End block
        addTaint(mountPoint.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1233940540; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1233940540 = varB4EAC82CA7396A68D541C85D26508E83_777524464;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1233940540 = varB4EAC82CA7396A68D541C85D26508E83_670941595;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1233940540.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1233940540;
        // ---------- Original Method ----------
        //try {
            //return mMountService.getVolumeState(mountPoint);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Failed to get volume state", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.812 -0400", hash_original_method = "7E321C52EE616E46A0C899410949AC4D", hash_generated_method = "D5A22FFDBB38207F24F6647034A81DDB")
    public StorageVolume[] getVolumeList() {
        StorageVolume[] varB4EAC82CA7396A68D541C85D26508E83_880391682 = null; //Variable for return #1
        StorageVolume[] varB4EAC82CA7396A68D541C85D26508E83_765456154 = null; //Variable for return #2
        StorageVolume[] varB4EAC82CA7396A68D541C85D26508E83_354691468 = null; //Variable for return #3
        try 
        {
            Parcelable[] list;
            list = mMountService.getVolumeList();
            varB4EAC82CA7396A68D541C85D26508E83_880391682 = new StorageVolume[0];
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
            varB4EAC82CA7396A68D541C85D26508E83_765456154 = result;
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_354691468 = null;
        } //End block
        StorageVolume[] varA7E53CE21691AB073D9660D615818899_40705603; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_40705603 = varB4EAC82CA7396A68D541C85D26508E83_880391682;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_40705603 = varB4EAC82CA7396A68D541C85D26508E83_765456154;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_40705603 = varB4EAC82CA7396A68D541C85D26508E83_354691468;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_40705603.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_40705603;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.813 -0400", hash_original_method = "32FCB28C74C473CB8B8088CF6B7B3DD3", hash_generated_method = "71C1664AC6A7F827BA617EC6A3CCE93B")
    public String[] getVolumePaths() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2050540661 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1136296746 = null; //Variable for return #2
        StorageVolume[] volumes;
        volumes = getVolumeList();
        varB4EAC82CA7396A68D541C85D26508E83_2050540661 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1136296746 = paths;
        String[] varA7E53CE21691AB073D9660D615818899_2011721425; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2011721425 = varB4EAC82CA7396A68D541C85D26508E83_2050540661;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2011721425 = varB4EAC82CA7396A68D541C85D26508E83_1136296746;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2011721425.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2011721425;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.814 -0400", hash_original_method = "2B96EE5216074DC94A336B5EA39CF13F", hash_generated_method = "2B96EE5216074DC94A336B5EA39CF13F")
        public MountServiceBinderListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.814 -0400", hash_original_method = "3247F72E228BC8CA6CB0EFFDE0587175", hash_generated_method = "14B4A544BD0BC44DD729E25E16BBFAA3")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.815 -0400", hash_original_method = "3412F22C5256750E7F040A232BDF8730", hash_generated_method = "7DF0E83AE95274F7CD39FDADA81B4077")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.815 -0400", hash_original_field = "F5548429C14A65BFC2537D3DA1DC8B9A", hash_generated_field = "B401ACBFDEFD68175AFBDCAE004213C6")

        @SuppressWarnings("hiding") private SparseArray<ObbListenerDelegate> mListeners = new SparseArray<ObbListenerDelegate>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.815 -0400", hash_original_method = "A19676FD811ED2BA9E2295E50F44897A", hash_generated_method = "A19676FD811ED2BA9E2295E50F44897A")
        public ObbActionListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.816 -0400", hash_original_method = "DBB9E3A59C6BF6EF37DBBFBCC6A9357E", hash_generated_method = "05A2EFE999F637A2BA18F6B76B747425")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.816 -0400", hash_original_method = "8B6662593D8FF2E95312263F2E6C8A4E", hash_generated_method = "D3BEDA2DBAB2CC81D52064650CE87BD6")
        public int addListener(OnObbStateChangeListener listener) {
            ObbListenerDelegate delegate;
            delegate = new ObbListenerDelegate(listener);
            {
                mListeners.put(delegate.nonce, delegate);
            } //End block
            addTaint(listener.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_318462557 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_318462557;
            // ---------- Original Method ----------
            //final ObbListenerDelegate delegate = new ObbListenerDelegate(listener);
            //synchronized (mListeners) {
                //mListeners.put(delegate.nonce, delegate);
            //}
            //return delegate.nonce;
        }

        
    }


    
    private class ObbListenerDelegate {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.820 -0400", hash_original_field = "CFA53EA895A869226B9A782B15E824C5", hash_generated_field = "9765B2BB1BD930598C2982AB60432360")

        private WeakReference<OnObbStateChangeListener> mObbEventListenerRef;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.820 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.820 -0400", hash_original_field = "CB584E44C43ED6BD0BC2D9C7E242837D", hash_generated_field = "025203DA6E702827C569DA1096B5E235")

        private int nonce;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.849 -0400", hash_original_method = "669DF05D8F2AD5FF486346330C6EAF78", hash_generated_method = "17A4AD1F85D436023586EF5B77C94F54")
          ObbListenerDelegate(OnObbStateChangeListener listener) {
            nonce = getNextNonce();
            mObbEventListenerRef = new WeakReference<OnObbStateChangeListener>(listener);
            mHandler = new Handler(mTgtLooper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.822 -0400", hash_original_method = "DAAB8678F7ABEFF803CFD82CEA9641F0", hash_generated_method = "3CC64C6EF5EC5D9EA5D50841D1458B8B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.850 -0400", hash_original_method = "834954D068AF2864C85CCAD9D321B725", hash_generated_method = "5FDB83AC007356FB827C48993F6C1FA3")
         OnObbStateChangeListener getListener() {
            OnObbStateChangeListener varB4EAC82CA7396A68D541C85D26508E83_1853356600 = null; //Variable for return #1
            OnObbStateChangeListener varB4EAC82CA7396A68D541C85D26508E83_1680838136 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1853356600 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1680838136 = mObbEventListenerRef.get();
            OnObbStateChangeListener varA7E53CE21691AB073D9660D615818899_1910993361; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1910993361 = varB4EAC82CA7396A68D541C85D26508E83_1853356600;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1910993361 = varB4EAC82CA7396A68D541C85D26508E83_1680838136;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1910993361.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1910993361;
            // ---------- Original Method ----------
            //if (mObbEventListenerRef == null) {
                //return null;
            //}
            //return mObbEventListenerRef.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.850 -0400", hash_original_method = "E278FF9F38CD6580E6FCEF436B6AB830", hash_generated_method = "7B4F15309C8D4E9EB03B1B388E0805C9")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.851 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "58104DC4D068DCE57A6D46AB8F30ECAD")

        public String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.851 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "47895903500EF3C437D3B693442F9718")

        public int state;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.851 -0400", hash_original_method = "B6A5FB82143B81E65B529E1CD0C6BFE8", hash_generated_method = "D7B87FD5151A53761078D39156714F78")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.854 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "C86344D57FB924DFB1BCA88A74120A66")

        private Message mMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.974 -0400", hash_original_method = "546E2CE4C7A72D6081E7A50312A352DB", hash_generated_method = "5CD343B512863C315F98F2AEA9C011F5")
        public  StorageEvent(int what) {
            mMessage = Message.obtain();
            mMessage.what = what;
            mMessage.obj = this;
            // ---------- Original Method ----------
            //mMessage = Message.obtain();
            //mMessage.what = what;
            //mMessage.obj = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.975 -0400", hash_original_method = "237083C18B821DBF98088C4FF8F2E015", hash_generated_method = "5A2581870BC0E64449C6FE42305A0761")
        public Message getMessage() {
            Message varB4EAC82CA7396A68D541C85D26508E83_279719330 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_279719330 = mMessage;
            varB4EAC82CA7396A68D541C85D26508E83_279719330.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_279719330;
            // ---------- Original Method ----------
            //return mMessage;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.975 -0400", hash_original_field = "1564EF349AB04E42B8AE80445E8A296E", hash_generated_field = "23C449B6581E1ED10138FAC889CCC113")

        static int EVENT_UMS_CONNECTION_CHANGED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.975 -0400", hash_original_field = "C5FC45E4D75061C27D49818F135CA8F5", hash_generated_field = "783F7A50DDFA22BF9419EB6D4EC1053A")

        static int EVENT_STORAGE_STATE_CHANGED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.975 -0400", hash_original_field = "4455CDC446630A55078BE82059DCDB56", hash_generated_field = "F321B2D9DAABC826821F5DE747858166")

        static int EVENT_OBB_STATE_CHANGED = 3;
    }


    
    private class UmsConnectionChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.978 -0400", hash_original_field = "E4894CA167B08880BFC35862F18575EB", hash_generated_field = "5C92C83D4651FA2CBBBE9F57619106E0")

        public boolean available;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.978 -0400", hash_original_method = "DA139192DF79A1B6AF4FBD170F57C738", hash_generated_method = "455690CD38D17C90E3960C0D3AE6FBD7")
        public  UmsConnectionChangedStorageEvent(boolean a) {
            super(EVENT_UMS_CONNECTION_CHANGED);
            available = a;
            // ---------- Original Method ----------
            //available = a;
        }

        
    }


    
    private class StorageStateChangedStorageEvent extends StorageEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.981 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "58104DC4D068DCE57A6D46AB8F30ECAD")

        public String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.982 -0400", hash_original_field = "72D6992B63A3C6CEDED7A4F910A17DB4", hash_generated_field = "BCBDB4C878C0401D1D7D5840C50DA786")

        public String oldState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.982 -0400", hash_original_field = "C12B256FB80BF45233F7969DDAD635A8", hash_generated_field = "BBB1EB05FA22C108537691E37AFB1F82")

        public String newState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.982 -0400", hash_original_method = "492691CEB211515F22C314109DCC65E2", hash_generated_method = "AEFC7259D8036A6EC5FA18B5B26F25C2")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.983 -0400", hash_original_field = "FF21AF7F25ACB77348D1744416043B3F", hash_generated_field = "7A1C33253FE6C5A1C1F7242C2999F45E")

        StorageEventListener mStorageEventListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.983 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.992 -0400", hash_original_method = "9AED46AC5CC711FE51A627C97DCCA6A0", hash_generated_method = "FF9B21A7759B5F8E44DB716441F33451")
          ListenerDelegate(StorageEventListener listener) {
            mStorageEventListener = listener;
            mHandler = new Handler(mTgtLooper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.992 -0400", hash_original_method = "366C40A0CA9BA10DE636D79A04377DDA", hash_generated_method = "E5730FF1F36BC3FC94771E188044AA5E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.994 -0400", hash_original_method = "DA2EC644741ABB32C38C92FF70A87DA0", hash_generated_method = "44544D72AECB64C0D558EE6FBCC01725")
         StorageEventListener getListener() {
            StorageEventListener varB4EAC82CA7396A68D541C85D26508E83_278722707 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_278722707 = mStorageEventListener;
            varB4EAC82CA7396A68D541C85D26508E83_278722707.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_278722707;
            // ---------- Original Method ----------
            //return mStorageEventListener;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.994 -0400", hash_original_method = "2B1B76FC8373F60078A15952F701EC30", hash_generated_method = "87DFDF226B0DA1AD7E45CA1C72941D4A")
         void sendShareAvailabilityChanged(boolean available) {
            UmsConnectionChangedStorageEvent e;
            e = new UmsConnectionChangedStorageEvent(available);
            mHandler.sendMessage(e.getMessage());
            addTaint(available);
            // ---------- Original Method ----------
            //UmsConnectionChangedStorageEvent e = new UmsConnectionChangedStorageEvent(available);
            //mHandler.sendMessage(e.getMessage());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.995 -0400", hash_original_method = "6996CC17777F13485A3BD31F01C08054", hash_generated_method = "5E6E3C7DC1A120B7BEE2F3373C5F8C1E")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.995 -0400", hash_original_field = "414DE376B4CE8230DB4AAE54D9434AD8", hash_generated_field = "C6C444618DC359497E4CF0D3E88391F5")

    private static String TAG = "StorageManager";
}

