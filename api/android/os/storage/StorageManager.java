package android.os.storage;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.011 -0500", hash_original_field = "4FFA6AABE302BD622ED70CB179957D24", hash_generated_field = "666FAAC497550CA891D002F26E180573")

    private static final String TAG = "StorageManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.013 -0500", hash_original_field = "1AED0F53FD70627DC20E88694679CD73", hash_generated_field = "824B06D572005F1C1B35E543BCE5CB91")

    private IMountService mMountService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.015 -0500", hash_original_field = "E3C963BED00097FA8564C04087A24015", hash_generated_field = "E3C963BED00097FA8564C04087A24015")

    Looper mTgtLooper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.017 -0500", hash_original_field = "0428DC1C8F523713FF1210B891E217B1", hash_generated_field = "5F09598E7B5B6EF08AE05EA113FDAB16")

    private MountServiceBinderListener mBinderListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.020 -0500", hash_original_field = "53B21F5EC8762A658BBB16C4B55E582C", hash_generated_field = "D62245B7A50796BE5B27202ED9DFC7AD")

    private List<ListenerDelegate> mListeners = new ArrayList<ListenerDelegate>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.023 -0500", hash_original_field = "B5440E114F6E91371BC57B652A21F785", hash_generated_field = "E8636BBC4F419661BC591AE94E3D2193")

    final private AtomicInteger mNextNonce = new AtomicInteger(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.032 -0500", hash_original_field = "F8941EC9D1C7AB1FFE9DAC8E94340730", hash_generated_field = "AE3A24000EF445332EEED071836A65E2")

    private final ObbActionListener mObbActionListener = new ObbActionListener();

    /**
     * Constructs a StorageManager object through which an application can
     * can communicate with the systems mount service.
     * 
     * @param tgtLooper The {@android.os.Looper} which events will be received on.
     *
     * <p>Applications can get instance of this class by calling
     * {@link android.content.Context#getSystemService(java.lang.String)} with an argument
     * of {@link android.content.Context#STORAGE_SERVICE}.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.132 -0500", hash_original_method = "1751DA8EA422A6A8B82F8F3E4926F05B", hash_generated_method = "4029DB65867D78066586999C19B204AF")
    
public StorageManager(Looper tgtLooper) throws RemoteException {
        mMountService = IMountService.Stub.asInterface(ServiceManager.getService("mount"));
        if (mMountService == null) {
            Log.e(TAG, "Unable to connect to mount service! - is it running yet?");
            return;
        }
        mTgtLooper = tgtLooper;
        mBinderListener = new MountServiceBinderListener();
        mMountService.registerListener(mBinderListener);
    }
    
    //Added by manual modeling
    @DSModeled(DSC.BAN)
    public  StorageManager() {
        /*
        if (DroidSafeAndroidRuntime.control) {
            RemoteException ex = new RemoteException();
            ex.addTaint(getTaint());
            throw ex;
        }
        */
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.044 -0500", hash_original_method = "E880709C72C5FA3A0762DDC8432351B1", hash_generated_method = "1BDA18804B31B850A5DCE1FC2F7164A3")
    
private int getNextNonce() {
        return mNextNonce.getAndIncrement();
    }


    /**
     * Registers a {@link android.os.storage.StorageEventListener StorageEventListener}.
     *
     * @param listener A {@link android.os.storage.StorageEventListener StorageEventListener} object.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.134 -0500", hash_original_method = "99C6C81E5E38E1D6866033383A8A6E37", hash_generated_method = "2676283840BE4ED637EE660BA3A534DC")
    
public void registerListener(StorageEventListener listener) {
        if (listener == null) {
            return;
        }

        synchronized (mListeners) {
            mListeners.add(new ListenerDelegate(listener));
        }
    }

    /**
     * Unregisters a {@link android.os.storage.StorageEventListener StorageEventListener}.
     *
     * @param listener A {@link android.os.storage.StorageEventListener StorageEventListener} object.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.137 -0500", hash_original_method = "3AB3B2EFDC587B358784DA10414214BD", hash_generated_method = "DFCCA512FB143EBC6592A7B885F1AF80")
    
public void unregisterListener(StorageEventListener listener) {
        if (listener == null) {
            return;
        }

        synchronized (mListeners) {
            final int size = mListeners.size();
            for (int i=0 ; i<size ; i++) {
                ListenerDelegate l = mListeners.get(i);
                if (l.getListener() == listener) {
                    mListeners.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Enables USB Mass Storage (UMS) on the device.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.139 -0500", hash_original_method = "5EB71443ECA98B5E7A476E0AE8AAD3AD", hash_generated_method = "62CB1773BC4A8736669D2F5295750AC7")
    
public void enableUsbMassStorage() {
        try {
            mMountService.setUsbMassStorageEnabled(true);
        } catch (Exception ex) {
            Log.e(TAG, "Failed to enable UMS", ex);
        }
    }

    /**
     * Disables USB Mass Storage (UMS) on the device.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.141 -0500", hash_original_method = "663240D4ECB8ED0B06161F54AFBC5E98", hash_generated_method = "15CE50ABB94FDE3D22996CF27581D9F6")
    
public void disableUsbMassStorage() {
        try {
            mMountService.setUsbMassStorageEnabled(false);
        } catch (Exception ex) {
            Log.e(TAG, "Failed to disable UMS", ex);
        }
    }

    /**
     * Query if a USB Mass Storage (UMS) host is connected.
     * @return true if UMS host is connected.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.144 -0500", hash_original_method = "09220D6F0F0E5ED3096951AEB948E338", hash_generated_method = "166AC376709BDDAC5DCE7B2AB2EF199D")
    
public boolean isUsbMassStorageConnected() {
        try {
            return mMountService.isUsbMassStorageConnected();
        } catch (Exception ex) {
            Log.e(TAG, "Failed to get UMS connection state", ex);
        }
        return false;
    }

    /**
     * Query if a USB Mass Storage (UMS) is enabled on the device.
     * @return true if UMS host is enabled.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.146 -0500", hash_original_method = "D60840A90A5B0A49A8865BA4D2E3CCDB", hash_generated_method = "2A08F84E8DDA7BA51CCFD77423024341")
    
public boolean isUsbMassStorageEnabled() {
        try {
            return mMountService.isUsbMassStorageEnabled();
        } catch (RemoteException rex) {
            Log.e(TAG, "Failed to get UMS enable state", rex);
        }
        return false;
    }

    /**
     * Mount an Opaque Binary Blob (OBB) file. If a <code>key</code> is
     * specified, it is supplied to the mounting process to be used in any
     * encryption used in the OBB.
     * <p>
     * The OBB will remain mounted for as long as the StorageManager reference
     * is held by the application. As soon as this reference is lost, the OBBs
     * in use will be unmounted. The {@link OnObbStateChangeListener} registered
     * with this call will receive the success or failure of this operation.
     * <p>
     * <em>Note:</em> you can only mount OBB files for which the OBB tag on the
     * file matches a package ID that is owned by the calling program's UID.
     * That is, shared UID applications can attempt to mount any other
     * application's OBB that shares its UID.
     * 
     * @param filename the path to the OBB file
     * @param key secret used to encrypt the OBB; may be <code>null</code> if no
     *            encryption was used on the OBB.
     * @param listener will receive the success or failure of the operation
     * @return whether the mount call was successfully queued or not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.149 -0500", hash_original_method = "534072486045B703901D00BD8CC513FF", hash_generated_method = "FE12E897D3C4ABDCB8D1AFCD86B32D2B")
    
public boolean mountObb(String filename, String key, OnObbStateChangeListener listener) {
        if (filename == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }

        if (listener == null) {
            throw new IllegalArgumentException("listener cannot be null");
        }

        try {
            final int nonce = mObbActionListener.addListener(listener);
            mMountService.mountObb(filename, key, mObbActionListener, nonce);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to mount OBB", e);
        }

        return false;
    }

    /**
     * Unmount an Opaque Binary Blob (OBB) file asynchronously. If the
     * <code>force</code> flag is true, it will kill any application needed to
     * unmount the given OBB (even the calling application).
     * <p>
     * The {@link OnObbStateChangeListener} registered with this call will
     * receive the success or failure of this operation.
     * <p>
     * <em>Note:</em> you can only mount OBB files for which the OBB tag on the
     * file matches a package ID that is owned by the calling program's UID.
     * That is, shared UID applications can obtain access to any other
     * application's OBB that shares its UID.
     * <p>
     * 
     * @param filename path to the OBB file
     * @param force whether to kill any programs using this in order to unmount
     *            it
     * @param listener will receive the success or failure of the operation
     * @return whether the unmount call was successfully queued or not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.151 -0500", hash_original_method = "49ADFC5746B1589055920681F4A3DF66", hash_generated_method = "927825FD2C3F7ABCF1005F8D2B37C011")
    
public boolean unmountObb(String filename, boolean force, OnObbStateChangeListener listener) {
        if (filename == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }

        if (listener == null) {
            throw new IllegalArgumentException("listener cannot be null");
        }

        try {
            final int nonce = mObbActionListener.addListener(listener);
            mMountService.unmountObb(filename, force, mObbActionListener, nonce);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to mount OBB", e);
        }

        return false;
    }

    /**
     * Check whether an Opaque Binary Blob (OBB) is mounted or not.
     * 
     * @param filename path to OBB image
     * @return true if OBB is mounted; false if not mounted or on error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.153 -0500", hash_original_method = "4111120C74906E4EF74CC0B96E5C85EA", hash_generated_method = "5CE4857D25FF91B9771ACE3CA8E56D49")
    
public boolean isObbMounted(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }

        try {
            return mMountService.isObbMounted(filename);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to check if OBB is mounted", e);
        }

        return false;
    }

    /**
     * Check the mounted path of an Opaque Binary Blob (OBB) file. This will
     * give you the path to where you can obtain access to the internals of the
     * OBB.
     * 
     * @param filename path to OBB image
     * @return absolute path to mounted OBB image data or <code>null</code> if
     *         not mounted or exception encountered trying to read status
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.156 -0500", hash_original_method = "4524FA5E45068B5E619708F061E65DAB", hash_generated_method = "0F4BAE3ECC3FDE074D70F5170D657C41")
    
public String getMountedObbPath(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }

        try {
            return mMountService.getMountedObbPath(filename);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to find mounted path for OBB", e);
        }

        return null;
    }

    /**
     * Gets the state of a volume via its mountpoint.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.158 -0500", hash_original_method = "9BA3F19D0DE55EC9B6B86E9B817FE10B", hash_generated_method = "D81876DE63D0AD390F244C6C56BDEE91")
    
public String getVolumeState(String mountPoint) {
        try {
            return mMountService.getVolumeState(mountPoint);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get volume state", e);
            return null;
        }
    }

    /**
     * Returns list of all mountable volumes.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.160 -0500", hash_original_method = "7E321C52EE616E46A0C899410949AC4D", hash_generated_method = "A4186C0F929126F46AA2F6469447BA79")
    
public StorageVolume[] getVolumeList() {
        try {
            Parcelable[] list = mMountService.getVolumeList();
            if (list == null) return new StorageVolume[0];
            int length = list.length;
            StorageVolume[] result = new StorageVolume[length];
            for (int i = 0; i < length; i++) {
                result[i] = (StorageVolume)list[i];
            }
            return result;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get volume list", e);
            return null;
        }
    }

    
    private class MountServiceBinderListener extends IMountServiceListener.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.075 -0400", hash_original_method = "2B96EE5216074DC94A336B5EA39CF13F", hash_generated_method = "2B96EE5216074DC94A336B5EA39CF13F")
        public MountServiceBinderListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.026 -0500", hash_original_method = "3247F72E228BC8CA6CB0EFFDE0587175", hash_generated_method = "B6CDF41B8392D00636461509E8ACBF35")
        
public void onUsbMassStorageConnectionChanged(boolean available) {
            final int size = mListeners.size();
            for (int i = 0; i < size; i++) {
                mListeners.get(i).sendShareAvailabilityChanged(available);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.028 -0500", hash_original_method = "3412F22C5256750E7F040A232BDF8730", hash_generated_method = "750426AD55B9B0F2E3D1F3F0958781E9")
        
public void onStorageStateChanged(String path, String oldState, String newState) {
            final int size = mListeners.size();
            for (int i = 0; i < size; i++) {
                mListeners.get(i).sendStorageStateChanged(path, oldState, newState);
            }
        }

        
    }


    
    private class ObbActionListener extends IObbActionListener.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.034 -0500", hash_original_field = "23C5790839FDFB2DAD01EEE256FA3566", hash_generated_field = "B401ACBFDEFD68175AFBDCAE004213C6")

        @SuppressWarnings("hiding")
        private SparseArray<ObbListenerDelegate> mListeners = new SparseArray<ObbListenerDelegate>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.076 -0400", hash_original_method = "A19676FD811ED2BA9E2295E50F44897A", hash_generated_method = "A19676FD811ED2BA9E2295E50F44897A")
        public ObbActionListener ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.038 -0500", hash_original_method = "DBB9E3A59C6BF6EF37DBBFBCC6A9357E", hash_generated_method = "894F6BA3EC6B0139D5B22F5C240BC907")
        
@Override
        public void onObbResult(String filename, int nonce, int status) {
            final ObbListenerDelegate delegate;
            synchronized (mListeners) {
                delegate = mListeners.get(nonce);
                if (delegate != null) {
                    mListeners.remove(nonce);
                }
            }

            if (delegate != null) {
                delegate.sendObbStateChanged(filename, status);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.040 -0500", hash_original_method = "8B6662593D8FF2E95312263F2E6C8A4E", hash_generated_method = "E26E5F1ED0096FD7B4E0D244EF6DF5EA")
        
public int addListener(OnObbStateChangeListener listener) {
            final ObbListenerDelegate delegate = new ObbListenerDelegate(listener);

            synchronized (mListeners) {
                mListeners.put(delegate.nonce, delegate);
            }

            return delegate.nonce;
        }

        
    }


    
    private class ObbListenerDelegate {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.047 -0500", hash_original_field = "89BE479661C8257EB0C4B86BAF60CD99", hash_generated_field = "9765B2BB1BD930598C2982AB60432360")

        private  WeakReference<OnObbStateChangeListener> mObbEventListenerRef;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.049 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.052 -0500", hash_original_field = "5C0AC92679469CD4F266AD5EA3C62C10", hash_generated_field = "025203DA6E702827C569DA1096B5E235")


        private  int nonce;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.059 -0500", hash_original_method = "669DF05D8F2AD5FF486346330C6EAF78", hash_generated_method = "669DF05D8F2AD5FF486346330C6EAF78")
        
ObbListenerDelegate(OnObbStateChangeListener listener) {
            nonce = getNextNonce();
            mObbEventListenerRef = new WeakReference<OnObbStateChangeListener>(listener);
            mHandler = new Handler(mTgtLooper) {
                @Override
                public void handleMessage(Message msg) {
                    final OnObbStateChangeListener changeListener = getListener();
                    if (changeListener == null) {
                        return;
                    }

                    StorageEvent e = (StorageEvent) msg.obj;

                    if (msg.what == StorageEvent.EVENT_OBB_STATE_CHANGED) {
                        ObbStateChangedStorageEvent ev = (ObbStateChangedStorageEvent) e;
                        changeListener.onObbStateChange(ev.path, ev.state);
                    } else {
                        Log.e(TAG, "Unsupported event " + msg.what);
                    }
                }
            };
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.061 -0500", hash_original_method = "834954D068AF2864C85CCAD9D321B725", hash_generated_method = "834954D068AF2864C85CCAD9D321B725")
        
OnObbStateChangeListener getListener() {
            if (mObbEventListenerRef == null) {
                return null;
            }
            return mObbEventListenerRef.get();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.063 -0500", hash_original_method = "E278FF9F38CD6580E6FCEF436B6AB830", hash_generated_method = "E278FF9F38CD6580E6FCEF436B6AB830")
        
void sendObbStateChanged(String path, int state) {
            ObbStateChangedStorageEvent e = new ObbStateChangedStorageEvent(path, state);
            mHandler.sendMessage(e.getMessage());
        }

        
    }


    
    private class ObbStateChangedStorageEvent extends StorageEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.068 -0500", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "58104DC4D068DCE57A6D46AB8F30ECAD")

        public  String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.071 -0500", hash_original_field = "962E680994F097CBCF73193974918C63", hash_generated_field = "47895903500EF3C437D3B693442F9718")


        public  int state;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.073 -0500", hash_original_method = "B6A5FB82143B81E65B529E1CD0C6BFE8", hash_generated_method = "B874632B62AC079E6AA6018652B7E897")
        
public ObbStateChangedStorageEvent(String path, int state) {
            super(EVENT_OBB_STATE_CHANGED);
            this.path = path;
            this.state = state;
        }

        
    }


    
    private class StorageEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.077 -0500", hash_original_field = "1D0CB625E04594AF40C5EFDB4C571DCB", hash_generated_field = "F25F6D444BE5A1CFBE4DF466A9A1F864")

        static final int EVENT_UMS_CONNECTION_CHANGED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.080 -0500", hash_original_field = "8347F6BE42533287A205C5B8281902F3", hash_generated_field = "583879D14E1BDFFE9CB4B6C78D72E1EC")

        static final int EVENT_STORAGE_STATE_CHANGED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.083 -0500", hash_original_field = "71E4BFCB12515BFF148031FE2E958077", hash_generated_field = "C550BF0DE2FD736DF2E8992E748ECE57")

        static final int EVENT_OBB_STATE_CHANGED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.085 -0500", hash_original_field = "2D41D548AF5E6C9BAD3BF2AC7B0EDE61", hash_generated_field = "C86344D57FB924DFB1BCA88A74120A66")


        private Message mMessage;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.087 -0500", hash_original_method = "546E2CE4C7A72D6081E7A50312A352DB", hash_generated_method = "9F23D8C4297A1A2036D6FAE9022F5B35")
        
public StorageEvent(int what) {
            mMessage = Message.obtain();
            mMessage.what = what;
            mMessage.obj = this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.090 -0500", hash_original_method = "237083C18B821DBF98088C4FF8F2E015", hash_generated_method = "5056BEB71FDB17C74971DA0D39E93C75")
        
public Message getMessage() {
            return mMessage;
        }
    }


    
    private class UmsConnectionChangedStorageEvent extends StorageEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.094 -0500", hash_original_field = "661415AE147552A97B5A8383FA088351", hash_generated_field = "5C92C83D4651FA2CBBBE9F57619106E0")

        public boolean available;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.096 -0500", hash_original_method = "DA139192DF79A1B6AF4FBD170F57C738", hash_generated_method = "48C5906EC8CD71CC6F80D22783D8E10E")
        
public UmsConnectionChangedStorageEvent(boolean a) {
            super(EVENT_UMS_CONNECTION_CHANGED);
            available = a;
        }

        
    }


    
    private class StorageStateChangedStorageEvent extends StorageEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.101 -0500", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "58104DC4D068DCE57A6D46AB8F30ECAD")

        public String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.103 -0500", hash_original_field = "6E37E782D442014276C3C2F6D99603C8", hash_generated_field = "BCBDB4C878C0401D1D7D5840C50DA786")

        public String oldState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.106 -0500", hash_original_field = "39E0D75E86893E16E4C50E11A5D0482E", hash_generated_field = "BBB1EB05FA22C108537691E37AFB1F82")

        public String newState;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.108 -0500", hash_original_method = "492691CEB211515F22C314109DCC65E2", hash_generated_method = "C6F4B369500F4ACE514A82D44DFF202A")
        
public StorageStateChangedStorageEvent(String p, String oldS, String newS) {
            super(EVENT_STORAGE_STATE_CHANGED);
            path = p;
            oldState = oldS;
            newState = newS;
        }

        
    }


    
    private class ListenerDelegate {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.113 -0500", hash_original_field = "7A1C33253FE6C5A1C1F7242C2999F45E", hash_generated_field = "7A1C33253FE6C5A1C1F7242C2999F45E")

         StorageEventListener mStorageEventListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.115 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private  Handler mHandler;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.121 -0500", hash_original_method = "9AED46AC5CC711FE51A627C97DCCA6A0", hash_generated_method = "9AED46AC5CC711FE51A627C97DCCA6A0")
        
ListenerDelegate(StorageEventListener listener) {
            mStorageEventListener = listener;
            mHandler = new Handler(mTgtLooper) {
                @Override
                public void handleMessage(Message msg) {
                    StorageEvent e = (StorageEvent) msg.obj;

                    if (msg.what == StorageEvent.EVENT_UMS_CONNECTION_CHANGED) {
                        UmsConnectionChangedStorageEvent ev = (UmsConnectionChangedStorageEvent) e;
                        mStorageEventListener.onUsbMassStorageConnectionChanged(ev.available);
                    } else if (msg.what == StorageEvent.EVENT_STORAGE_STATE_CHANGED) {
                        StorageStateChangedStorageEvent ev = (StorageStateChangedStorageEvent) e;
                        mStorageEventListener.onStorageStateChanged(ev.path, ev.oldState, ev.newState);
                    } else {
                        Log.e(TAG, "Unsupported event " + msg.what);
                    }
                }
            };
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.123 -0500", hash_original_method = "DA2EC644741ABB32C38C92FF70A87DA0", hash_generated_method = "DA2EC644741ABB32C38C92FF70A87DA0")
        
StorageEventListener getListener() {
            return mStorageEventListener;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.125 -0500", hash_original_method = "2B1B76FC8373F60078A15952F701EC30", hash_generated_method = "2B1B76FC8373F60078A15952F701EC30")
        
void sendShareAvailabilityChanged(boolean available) {
            UmsConnectionChangedStorageEvent e = new UmsConnectionChangedStorageEvent(available);
            mHandler.sendMessage(e.getMessage());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.128 -0500", hash_original_method = "6996CC17777F13485A3BD31F01C08054", hash_generated_method = "6996CC17777F13485A3BD31F01C08054")
        
void sendStorageStateChanged(String path, String oldState, String newState) {
            StorageStateChangedStorageEvent e = new StorageStateChangedStorageEvent(path, oldState, newState);
            mHandler.sendMessage(e.getMessage());
        }

        
    }

    /**
     * Returns list of paths for all mountable volumes.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.163 -0500", hash_original_method = "32FCB28C74C473CB8B8088CF6B7B3DD3", hash_generated_method = "0482A7B4132D28A95CDD142BB4ACF07C")
    
public String[] getVolumePaths() {
        StorageVolume[] volumes = getVolumeList();
        if (volumes == null) return null;
        int count = volumes.length;
        String[] paths = new String[count];
        for (int i = 0; i < count; i++) {
            paths[i] = volumes[i].getPath();
        }
        return paths;
    }
}

