package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;

public class ClipboardManager extends android.text.ClipboardManager {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.353 -0500", hash_original_method = "B823D91CB0BDECA7B94A432D3169CF0F", hash_generated_method = "E46EEAD91E5B0F8A4FFB94615D67E32E")
    
static private IClipboard getService() {
        synchronized (sStaticLock) {
            if (sService != null) {
                return sService;
            }
            IBinder b = ServiceManager.getService("clipboard");
            sService = IClipboard.Stub.asInterface(b);
            return sService;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.329 -0500", hash_original_field = "70A71BD16E05A887B72D59F04116381D", hash_generated_field = "F842219FC69FE9ACCBA41EF52147C0D4")

    private final static Object sStaticLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.331 -0500", hash_original_field = "1EF768EB48A307001D0C0E9180D2C792", hash_generated_field = "7DAD8437C868C87DD2CEB4861B4C57D1")

    private static IClipboard sService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.344 -0500", hash_original_field = "1C8819E0457C61ABDAA5E1E45DE2C427", hash_generated_field = "3C04989ED0EDFEE643DF5780498583F4")

    static final int MSG_REPORT_PRIMARY_CLIP_CHANGED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.333 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.336 -0500", hash_original_field = "69431F5030A8CFD222EF228DFCC7DF2C", hash_generated_field = "E56DE56B7E953844281AFE87E0843DAB")

    private final ArrayList<OnPrimaryClipChangedListener> mPrimaryClipChangedListeners
             = new ArrayList<OnPrimaryClipChangedListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.140 -0400", hash_original_field = "6A00B923E2A779854F5FF695F32BEBAA", hash_generated_field = "C158487F60C521ACB68D79E0E9BC0FB8")

    private final IOnPrimaryClipChangedListener.Stub mPrimaryClipChangedServiceListener = new IOnPrimaryClipChangedListener.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.140 -0400", hash_original_method = "70003E26F597B4FA21D37DAC4C2F415E", hash_generated_method = "F52487E39EC4F57260159A7A23B22DB7")
        public void dispatchPrimaryClipChanged() {
            mHandler.sendEmptyMessage(MSG_REPORT_PRIMARY_CLIP_CHANGED);
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.141 -0400", hash_original_field = "A7B290A804ED4D1BFB9EEF0AABB57AC2", hash_generated_field = "F325ACE86B0A208FFE07C888493706E5")

    private final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.141 -0400", hash_original_method = "5AAF932430F5A3E1179C80D13696BD76", hash_generated_method = "FA752C471052CE88E1745A4EC756AD64")
        @Override
        public void handleMessage(Message msg) {
            
            reportPrimaryClipChanged();
            
            addTaint(msg.getTaint());
            
        }
        
};

    //for getSystemService
    
    public  ClipboardManager(Context context) {
        addTaint(context.getTaint());
        mContext = context;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.625 -0400", hash_original_method = "97558C16BA3BDE6476EDF618E25B9B81", hash_generated_method = "96F575CB12FC3C55C0854FEB3CCF2F69")
    public  ClipboardManager(Context context, Handler handler) {
        addTaint(handler.getTaint());
        addTaint(context.getTaint());
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    /**
     * Sets the current primary clip on the clipboard.  This is the clip that
     * is involved in normal cut and paste operations.
     *
     * @param clip The clipped data item to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.358 -0500", hash_original_method = "9758ADBACC2D859F954394BF2EAF123A", hash_generated_method = "7679C6F41286656564D6FD1432FC95FC")
    
public void setPrimaryClip(ClipData clip) {
        try {
            getService().setPrimaryClip(clip);
        } catch (RemoteException e) {
        }
    }

    /**
     * Returns the current primary clip on the clipboard.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.361 -0500", hash_original_method = "50B348CB23C6EF42B3CBE9B194465F2B", hash_generated_method = "7DDDA0056751537DC044752D3DE1A34C")
    
public ClipData getPrimaryClip() {
        try {
            return getService().getPrimaryClip(mContext.getPackageName());
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Returns a description of the current primary clip on the clipboard
     * but not a copy of its data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.363 -0500", hash_original_method = "678ECBBFE5F09A43CDAAF81F6FD5AC97", hash_generated_method = "CA11E7B1CBE4EC33585AD3095A9223D3")
    
public ClipDescription getPrimaryClipDescription() {
        try {
            return getService().getPrimaryClipDescription();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Returns true if there is currently a primary clip on the clipboard.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.365 -0500", hash_original_method = "CBBCF938F0063A19991B3E7A8193FD4F", hash_generated_method = "6F09A619FDA4D3D0D01D1806C7987F21")
    
public boolean hasPrimaryClip() {
        try {
            return getService().hasPrimaryClip();
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.368 -0500", hash_original_method = "E5044C03AB4AD3DC9569B565F2008B98", hash_generated_method = "F8652FD64D22F64F108BE481EA8913D3")
    
public void addPrimaryClipChangedListener(OnPrimaryClipChangedListener what) {
        synchronized (mPrimaryClipChangedListeners) {
            if (mPrimaryClipChangedListeners.size() == 0) {
                try {
                    getService().addPrimaryClipChangedListener(
                            mPrimaryClipChangedServiceListener);
                } catch (RemoteException e) {
                }
            }
            mPrimaryClipChangedListeners.add(what);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.370 -0500", hash_original_method = "7128B19124A44EC27CC4C323B8513057", hash_generated_method = "8BF6DFFBDB7DA5514BD9806E613C1054")
    
public void removePrimaryClipChangedListener(OnPrimaryClipChangedListener what) {
        synchronized (mPrimaryClipChangedListeners) {
            mPrimaryClipChangedListeners.remove(what);
            if (mPrimaryClipChangedListeners.size() == 0) {
                try {
                    getService().removePrimaryClipChangedListener(
                            mPrimaryClipChangedServiceListener);
                } catch (RemoteException e) {
                }
            }
        }
    }

    /**
     * @deprecated Use {@link #getPrimaryClip()} instead.  This retrieves
     * the primary clip and tries to coerce it to a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.372 -0500", hash_original_method = "D9D561BF0732BC43D4A46DB226A10D9C", hash_generated_method = "15ABA5238E08C544D4AF67B8DC71CA77")
    
public CharSequence getText() {
        ClipData clip = getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            return clip.getItemAt(0).coerceToText(mContext);
        }
        return null;
    }
    
    public interface OnPrimaryClipChangedListener {
        void onPrimaryClipChanged();
    }

    /**
     * @deprecated Use {@link #setPrimaryClip(ClipData)} instead.  This
     * creates a ClippedItem holding the given text and sets it as the
     * primary clip.  It has no label or icon.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.374 -0500", hash_original_method = "31E7EB6BE33A923560F7B9C2B2D8F3DA", hash_generated_method = "8F6424DC11A3E95CAE183109CBA05CFE")
    
public void setText(CharSequence text) {
        setPrimaryClip(ClipData.newPlainText(null, text));
    }

    /**
     * @deprecated Use {@link #hasPrimaryClip()} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.376 -0500", hash_original_method = "9F22D463FB706DEB91BA1565CF5CF48D", hash_generated_method = "9424FF4D96A4EC78AF9234EE6BCB8E85")
    
public boolean hasText() {
        try {
            return getService().hasClipboardText();
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.379 -0500", hash_original_method = "0985A14308F67055EBA5FC0B7343D794", hash_generated_method = "0985A14308F67055EBA5FC0B7343D794")
    
void reportPrimaryClipChanged() {
        Object[] listeners;

        synchronized (mPrimaryClipChangedListeners) {
            final int N = mPrimaryClipChangedListeners.size();
            if (N <= 0) {
                return;
            }
            listeners = mPrimaryClipChangedListeners.toArray();
        }

        for (int i=0; i<listeners.length; i++) {
            ((OnPrimaryClipChangedListener)listeners[i]).onPrimaryClipChanged();
        }
    }
}

