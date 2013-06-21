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
    private IMountService mMountService;
    Looper mTgtLooper;
    private MountServiceBinderListener mBinderListener;
    private List<ListenerDelegate> mListeners = new ArrayList<ListenerDelegate>();
    private AtomicInteger mNextNonce = new AtomicInteger(0);
    private ObbActionListener mObbActionListener = new ObbActionListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.514 -0400", hash_original_method = "1751DA8EA422A6A8B82F8F3E4926F05B", hash_generated_method = "9229222E337DAE3D687F07FEF073FF85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StorageManager(Looper tgtLooper) throws RemoteException {
        dsTaint.addTaint(tgtLooper.dsTaint);
        mMountService = IMountService.Stub.asInterface(ServiceManager.getService("mount"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.514 -0400", hash_original_method = "E880709C72C5FA3A0762DDC8432351B1", hash_generated_method = "FDAEA2555D2417F614E3685A6DBBA67B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getNextNonce() {
        int var6CB6DA04F0730EF8B511B3B8FFC9F8A7_301672589 = (mNextNonce.getAndIncrement());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextNonce.getAndIncrement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.514 -0400", hash_original_method = "99C6C81E5E38E1D6866033383A8A6E37", hash_generated_method = "49C849E483CF785E2052C91311AC6B50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerListener(StorageEventListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.515 -0400", hash_original_method = "3AB3B2EFDC587B358784DA10414214BD", hash_generated_method = "5C2DA97C10697EA7E16D408ADAE93D05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterListener(StorageEventListener listener) {
        dsTaint.addTaint(listener.dsTaint);
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
                        boolean var59EE92861E91E921B93BC86C1074CE98_819732578 = (l.getListener() == listener);
                        {
                            mListeners.remove(i);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.515 -0400", hash_original_method = "5EB71443ECA98B5E7A476E0AE8AAD3AD", hash_generated_method = "368A1289ED4737EFAE8CBE8CEAC0A1AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.515 -0400", hash_original_method = "663240D4ECB8ED0B06161F54AFBC5E98", hash_generated_method = "C629A41C3AD430654F399A0AC242904F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.515 -0400", hash_original_method = "09220D6F0F0E5ED3096951AEB948E338", hash_generated_method = "6703BCB0D7F394AE5F54643C769C58CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isUsbMassStorageConnected() {
        try 
        {
            boolean varB76AEDE2DC40626AB3B07AE1ACEABEB7_1815890398 = (mMountService.isUsbMassStorageConnected());
        } //End block
        catch (Exception ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mMountService.isUsbMassStorageConnected();
        //} catch (Exception ex) {
            //Log.e(TAG, "Failed to get UMS connection state", ex);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.516 -0400", hash_original_method = "D60840A90A5B0A49A8865BA4D2E3CCDB", hash_generated_method = "E96750BE316794D1E931B2AC9840D8CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isUsbMassStorageEnabled() {
        try 
        {
            boolean varA4535BADAA0FB8D2BE957451B086D7B1_1858433675 = (mMountService.isUsbMassStorageEnabled());
        } //End block
        catch (RemoteException rex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mMountService.isUsbMassStorageEnabled();
        //} catch (RemoteException rex) {
            //Log.e(TAG, "Failed to get UMS enable state", rex);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.516 -0400", hash_original_method = "534072486045B703901D00BD8CC513FF", hash_generated_method = "14F9262E48538532FC28468D9C6C5112")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean mountObb(String filename, String key, OnObbStateChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(filename);
        dsTaint.addTaint(key);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.516 -0400", hash_original_method = "49ADFC5746B1589055920681F4A3DF66", hash_generated_method = "6AFC916DA5EC3621288A806BECD50E76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean unmountObb(String filename, boolean force, OnObbStateChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(filename);
        dsTaint.addTaint(force);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.517 -0400", hash_original_method = "4111120C74906E4EF74CC0B96E5C85EA", hash_generated_method = "DF284BAA34AEF6F3F27AC7379640D69A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isObbMounted(String filename) {
        dsTaint.addTaint(filename);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } //End block
        try 
        {
            boolean var5CFC3377858B4598A6454628DE929077_1696102858 = (mMountService.isObbMounted(filename));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.517 -0400", hash_original_method = "4524FA5E45068B5E619708F061E65DAB", hash_generated_method = "38015BA4CCF55643DF08C1DC21343231")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMountedObbPath(String filename) {
        dsTaint.addTaint(filename);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("filename cannot be null");
        } //End block
        try 
        {
            String varB47424B0281411115A300AA4E479A3F0_1133049173 = (mMountService.getMountedObbPath(filename));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.517 -0400", hash_original_method = "9BA3F19D0DE55EC9B6B86E9B817FE10B", hash_generated_method = "C6854E54B2645B1DD1606332CD70F0FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVolumeState(String mountPoint) {
        dsTaint.addTaint(mountPoint);
        try 
        {
            String var20D4DD2ABF5CAA32D3B34B0C639EBFB0_1795248963 = (mMountService.getVolumeState(mountPoint));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return mMountService.getVolumeState(mountPoint);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Failed to get volume state", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.518 -0400", hash_original_method = "7E321C52EE616E46A0C899410949AC4D", hash_generated_method = "F530C2E2D797110FA7E1F1E07E7823E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StorageVolume[] getVolumeList() {
        try 
        {
            Parcelable[] list;
            list = mMountService.getVolumeList();
            StorageVolume[] var9FC9A1FE8C9C43E0D7FE9943D3FD9994_2127407127 = (new StorageVolume[0]);
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
        } //End block
        catch (RemoteException e)
        { }
        return (StorageVolume[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.518 -0400", hash_original_method = "32FCB28C74C473CB8B8088CF6B7B3DD3", hash_generated_method = "D293CE5F7AF753A2FB99FB3FE6EA18DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getVolumePaths() {
        StorageVolume[] volumes;
        volumes = getVolumeList();
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
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.519 -0400", hash_original_method = "2F199BF6DC05DE3B556459120AA85E06", hash_generated_method = "2F199BF6DC05DE3B556459120AA85E06")
                public MountServiceBinderListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.519 -0400", hash_original_method = "3247F72E228BC8CA6CB0EFFDE0587175", hash_generated_method = "FC666997DA74EC97E5828137DA736953")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onUsbMassStorageConnectionChanged(boolean available) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(available);
            int size;
            size = mListeners.size();
            {
                int i;
                i = 0;
                {
                    mListeners.get(i).sendShareAvailabilityChanged(available);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //final int size = mListeners.size();
            //for (int i = 0; i < size; i++) {
                //mListeners.get(i).sendShareAvailabilityChanged(available);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.520 -0400", hash_original_method = "3412F22C5256750E7F040A232BDF8730", hash_generated_method = "E3F547BA97C76A8DBF741B5DA5E3AECD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onStorageStateChanged(String path, String oldState, String newState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(oldState);
            dsTaint.addTaint(path);
            dsTaint.addTaint(newState);
            int size;
            size = mListeners.size();
            {
                int i;
                i = 0;
                {
                    mListeners.get(i).sendStorageStateChanged(path, oldState, newState);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //final int size = mListeners.size();
            //for (int i = 0; i < size; i++) {
                //mListeners.get(i).sendStorageStateChanged(path, oldState, newState);
            //}
        }

        
    }


    
    private class ObbActionListener extends IObbActionListener.Stub {
        @SuppressWarnings("hiding") private SparseArray<ObbListenerDelegate> mListeners = new SparseArray<ObbListenerDelegate>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.520 -0400", hash_original_method = "FD067654988FC402854609D2390B0FBB", hash_generated_method = "FD067654988FC402854609D2390B0FBB")
                public ObbActionListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.520 -0400", hash_original_method = "DBB9E3A59C6BF6EF37DBBFBCC6A9357E", hash_generated_method = "72979F790E87D0B43AE51BF177C977AE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onObbResult(String filename, int nonce, int status) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(status);
            dsTaint.addTaint(nonce);
            dsTaint.addTaint(filename);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.521 -0400", hash_original_method = "8B6662593D8FF2E95312263F2E6C8A4E", hash_generated_method = "23171E555EAF5CFFA345CD049233F963")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int addListener(OnObbStateChangeListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            ObbListenerDelegate delegate;
            delegate = new ObbListenerDelegate(listener);
            {
                mListeners.put(delegate.nonce, delegate);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //final ObbListenerDelegate delegate = new ObbListenerDelegate(listener);
            //synchronized (mListeners) {
                //mListeners.put(delegate.nonce, delegate);
            //}
            //return delegate.nonce;
        }

        
    }


    
    private class ObbListenerDelegate {
        private WeakReference<OnObbStateChangeListener> mObbEventListenerRef;
        private Handler mHandler;
        private int nonce;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.521 -0400", hash_original_method = "669DF05D8F2AD5FF486346330C6EAF78", hash_generated_method = "01042B7D7F17BB4A07A81F7E35D65338")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ObbListenerDelegate(OnObbStateChangeListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            nonce = getNextNonce();
            mObbEventListenerRef = new WeakReference<OnObbStateChangeListener>(listener);
            mHandler = new Handler(mTgtLooper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.521 -0400", hash_original_method = "DAAB8678F7ABEFF803CFD82CEA9641F0", hash_generated_method = "FC109E4CF73AA5D143ABD97ECD289E4E")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void handleMessage(Message msg) {
                    dsTaint.addTaint(msg.dsTaint);
                    OnObbStateChangeListener changeListener;
                    changeListener = getListener();
                    StorageEvent e;
                    e = (StorageEvent) msg.obj;
                    {
                        ObbStateChangedStorageEvent ev;
                        ev = (ObbStateChangedStorageEvent) e;
                        changeListener.onObbStateChange(ev.path, ev.state);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.522 -0400", hash_original_method = "834954D068AF2864C85CCAD9D321B725", hash_generated_method = "C91F955B84981D8FCB5EAF395B55858F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         OnObbStateChangeListener getListener() {
            OnObbStateChangeListener var17333ED3FBCB8BFB69FEEDD6C2A24AD1_685802682 = (mObbEventListenerRef.get());
            return (OnObbStateChangeListener)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mObbEventListenerRef == null) {
                //return null;
            //}
            //return mObbEventListenerRef.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.522 -0400", hash_original_method = "E278FF9F38CD6580E6FCEF436B6AB830", hash_generated_method = "79700F9804A17F5B3CDC5642981E081A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void sendObbStateChanged(String path, int state) {
            dsTaint.addTaint(state);
            dsTaint.addTaint(path);
            ObbStateChangedStorageEvent e;
            e = new ObbStateChangedStorageEvent(path, state);
            mHandler.sendMessage(e.getMessage());
            // ---------- Original Method ----------
            //ObbStateChangedStorageEvent e = new ObbStateChangedStorageEvent(path, state);
            //mHandler.sendMessage(e.getMessage());
        }

        
    }


    
    private class ObbStateChangedStorageEvent extends StorageEvent {
        public String path;
        public int state;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.522 -0400", hash_original_method = "B6A5FB82143B81E65B529E1CD0C6BFE8", hash_generated_method = "41E9AA6872F862690C0D80D1E938DA56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ObbStateChangedStorageEvent(String path, int state) {
            super(EVENT_OBB_STATE_CHANGED);
            dsTaint.addTaint(state);
            dsTaint.addTaint(path);
            // ---------- Original Method ----------
            //this.path = path;
            //this.state = state;
        }

        
    }


    
    private class StorageEvent {
        private Message mMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.523 -0400", hash_original_method = "546E2CE4C7A72D6081E7A50312A352DB", hash_generated_method = "AFB8A1631499C12A715646BE13A4C1C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StorageEvent(int what) {
            dsTaint.addTaint(what);
            mMessage = Message.obtain();
            mMessage.what = what;
            mMessage.obj = this;
            // ---------- Original Method ----------
            //mMessage = Message.obtain();
            //mMessage.what = what;
            //mMessage.obj = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.523 -0400", hash_original_method = "237083C18B821DBF98088C4FF8F2E015", hash_generated_method = "EA8B09A0899520DCCAC2E3D0FBD12646")
        @DSModeled(DSC.SAFE)
        public Message getMessage() {
            return (Message)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mMessage;
        }

        
        static final int EVENT_UMS_CONNECTION_CHANGED = 1;
        static final int EVENT_STORAGE_STATE_CHANGED = 2;
        static final int EVENT_OBB_STATE_CHANGED = 3;
    }


    
    private class UmsConnectionChangedStorageEvent extends StorageEvent {
        public boolean available;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.523 -0400", hash_original_method = "DA139192DF79A1B6AF4FBD170F57C738", hash_generated_method = "76C331BB65A2D35A4E0273DF225122BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UmsConnectionChangedStorageEvent(boolean a) {
            super(EVENT_UMS_CONNECTION_CHANGED);
            dsTaint.addTaint(a);
            // ---------- Original Method ----------
            //available = a;
        }

        
    }


    
    private class StorageStateChangedStorageEvent extends StorageEvent {
        public String path;
        public String oldState;
        public String newState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.523 -0400", hash_original_method = "492691CEB211515F22C314109DCC65E2", hash_generated_method = "746779096224AC3287716425A4706DD3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StorageStateChangedStorageEvent(String p, String oldS, String newS) {
            super(EVENT_STORAGE_STATE_CHANGED);
            dsTaint.addTaint(oldS);
            dsTaint.addTaint(newS);
            dsTaint.addTaint(p);
            // ---------- Original Method ----------
            //path = p;
            //oldState = oldS;
            //newState = newS;
        }

        
    }


    
    private class ListenerDelegate {
        StorageEventListener mStorageEventListener;
        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.524 -0400", hash_original_method = "9AED46AC5CC711FE51A627C97DCCA6A0", hash_generated_method = "91F3A8D27AC67C95832ACED9EC70D518")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ListenerDelegate(StorageEventListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            mHandler = new Handler(mTgtLooper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.524 -0400", hash_original_method = "366C40A0CA9BA10DE636D79A04377DDA", hash_generated_method = "C13F681191A0ECD57F3B148707C348EA")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void handleMessage(Message msg) {
                    dsTaint.addTaint(msg.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.524 -0400", hash_original_method = "DA2EC644741ABB32C38C92FF70A87DA0", hash_generated_method = "12F70046697DC6C14CB488F1D86D5D81")
        @DSModeled(DSC.SAFE)
         StorageEventListener getListener() {
            return (StorageEventListener)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mStorageEventListener;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.524 -0400", hash_original_method = "2B1B76FC8373F60078A15952F701EC30", hash_generated_method = "1C5C4A9A83D5D19B409511493924761A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void sendShareAvailabilityChanged(boolean available) {
            dsTaint.addTaint(available);
            UmsConnectionChangedStorageEvent e;
            e = new UmsConnectionChangedStorageEvent(available);
            mHandler.sendMessage(e.getMessage());
            // ---------- Original Method ----------
            //UmsConnectionChangedStorageEvent e = new UmsConnectionChangedStorageEvent(available);
            //mHandler.sendMessage(e.getMessage());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.525 -0400", hash_original_method = "6996CC17777F13485A3BD31F01C08054", hash_generated_method = "558961C165DA60B471C3FBAD3F2C1116")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void sendStorageStateChanged(String path, String oldState, String newState) {
            dsTaint.addTaint(oldState);
            dsTaint.addTaint(path);
            dsTaint.addTaint(newState);
            StorageStateChangedStorageEvent e;
            e = new StorageStateChangedStorageEvent(path, oldState, newState);
            mHandler.sendMessage(e.getMessage());
            // ---------- Original Method ----------
            //StorageStateChangedStorageEvent e = new StorageStateChangedStorageEvent(path, oldState, newState);
            //mHandler.sendMessage(e.getMessage());
        }

        
    }


    
    private static final String TAG = "StorageManager";
}

