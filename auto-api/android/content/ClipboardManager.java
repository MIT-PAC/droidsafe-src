package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Message;
import android.os.RemoteException;
import android.os.Handler;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;
import java.util.ArrayList;

public class ClipboardManager extends android.text.ClipboardManager {
    private Context mContext;
    private ArrayList<OnPrimaryClipChangedListener> mPrimaryClipChangedListeners
             = new ArrayList<OnPrimaryClipChangedListener>();
    private final IOnPrimaryClipChangedListener.Stub mPrimaryClipChangedServiceListener = new IOnPrimaryClipChangedListener.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.059 -0400", hash_original_method = "70003E26F597B4FA21D37DAC4C2F415E", hash_generated_method = "F52487E39EC4F57260159A7A23B22DB7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchPrimaryClipChanged() {
            mHandler.sendEmptyMessage(MSG_REPORT_PRIMARY_CLIP_CHANGED);
            // ---------- Original Method ----------
            //mHandler.sendEmptyMessage(MSG_REPORT_PRIMARY_CLIP_CHANGED);
        }

        
}; //Transformed anonymous class
    private final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.060 -0400", hash_original_method = "5AAF932430F5A3E1179C80D13696BD76", hash_generated_method = "21912E96496EFBF611DCE316B8FCF5C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case MSG_REPORT_PRIMARY_CLIP_CHANGED 
            reportPrimaryClipChanged();
            //End case MSG_REPORT_PRIMARY_CLIP_CHANGED 
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case MSG_REPORT_PRIMARY_CLIP_CHANGED:
                    //reportPrimaryClipChanged();
            //}
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.060 -0400", hash_original_method = "97558C16BA3BDE6476EDF618E25B9B81", hash_generated_method = "EA6FDF912E51BEFDB07FF7C02B2FB79F")
    @DSModeled(DSC.SAFE)
    public ClipboardManager(Context context, Handler handler) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.061 -0400", hash_original_method = "9758ADBACC2D859F954394BF2EAF123A", hash_generated_method = "E1CB92D623771C5135D1CDB9C5DFF35C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPrimaryClip(ClipData clip) {
        dsTaint.addTaint(clip.dsTaint);
        try 
        {
            getService().setPrimaryClip(clip);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //getService().setPrimaryClip(clip);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.061 -0400", hash_original_method = "50B348CB23C6EF42B3CBE9B194465F2B", hash_generated_method = "8022F04DFEBC6C77AA9B78183405767E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClipData getPrimaryClip() {
        try 
        {
            ClipData var3225996981D61B82C5D11E20D0A48EDA_126943668 = (getService().getPrimaryClip(mContext.getPackageName()));
        } //End block
        catch (RemoteException e)
        { }
        return (ClipData)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return getService().getPrimaryClip(mContext.getPackageName());
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.062 -0400", hash_original_method = "678ECBBFE5F09A43CDAAF81F6FD5AC97", hash_generated_method = "ABC05265AC88E80B430BE32B09F5B2F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClipDescription getPrimaryClipDescription() {
        try 
        {
            ClipDescription var1832F070027C37D41B4E6F1F2F661056_1966644106 = (getService().getPrimaryClipDescription());
        } //End block
        catch (RemoteException e)
        { }
        return (ClipDescription)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return getService().getPrimaryClipDescription();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.062 -0400", hash_original_method = "CBBCF938F0063A19991B3E7A8193FD4F", hash_generated_method = "7747930F00C44FE43A723FC9BF1DD764")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasPrimaryClip() {
        try 
        {
            boolean var3C757C01DE776AE9A44F6650B0C4FBA6_323114701 = (getService().hasPrimaryClip());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return getService().hasPrimaryClip();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.063 -0400", hash_original_method = "E5044C03AB4AD3DC9569B565F2008B98", hash_generated_method = "7A40F748ABD358A873AC2391B15382F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addPrimaryClipChangedListener(OnPrimaryClipChangedListener what) {
        dsTaint.addTaint(what.dsTaint);
        {
            {
                boolean var6174F040073C34898448239A43E2EAFC_1794240692 = (mPrimaryClipChangedListeners.size() == 0);
                {
                    try 
                    {
                        getService().addPrimaryClipChangedListener(
                            mPrimaryClipChangedServiceListener);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            mPrimaryClipChangedListeners.add(what);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mPrimaryClipChangedListeners) {
            //if (mPrimaryClipChangedListeners.size() == 0) {
                //try {
                    //getService().addPrimaryClipChangedListener(
                            //mPrimaryClipChangedServiceListener);
                //} catch (RemoteException e) {
                //}
            //}
            //mPrimaryClipChangedListeners.add(what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.063 -0400", hash_original_method = "7128B19124A44EC27CC4C323B8513057", hash_generated_method = "2C9F0C89E7487B1A55738A96098BFF84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePrimaryClipChangedListener(OnPrimaryClipChangedListener what) {
        dsTaint.addTaint(what.dsTaint);
        {
            mPrimaryClipChangedListeners.remove(what);
            {
                boolean var6174F040073C34898448239A43E2EAFC_195341208 = (mPrimaryClipChangedListeners.size() == 0);
                {
                    try 
                    {
                        getService().removePrimaryClipChangedListener(
                            mPrimaryClipChangedServiceListener);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mPrimaryClipChangedListeners) {
            //mPrimaryClipChangedListeners.remove(what);
            //if (mPrimaryClipChangedListeners.size() == 0) {
                //try {
                    //getService().removePrimaryClipChangedListener(
                            //mPrimaryClipChangedServiceListener);
                //} catch (RemoteException e) {
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.064 -0400", hash_original_method = "D9D561BF0732BC43D4A46DB226A10D9C", hash_generated_method = "798F3C55BB0334D0C5BF0AD7DC08BC58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getText() {
        ClipData clip;
        clip = getPrimaryClip();
        {
            boolean var199BC11988A51D31CFFDE3AC3DC661B9_1048591046 = (clip != null && clip.getItemCount() > 0);
            {
                CharSequence var2FE90B321F188CF62C49319BD130D036_117372434 = (clip.getItemAt(0).coerceToText(mContext));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //ClipData clip = getPrimaryClip();
        //if (clip != null && clip.getItemCount() > 0) {
            //return clip.getItemAt(0).coerceToText(mContext);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.064 -0400", hash_original_method = "31E7EB6BE33A923560F7B9C2B2D8F3DA", hash_generated_method = "6BEE5BD243FFE34687672E77356A7D83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(CharSequence text) {
        dsTaint.addTaint(text);
        setPrimaryClip(ClipData.newPlainText(null, text));
        // ---------- Original Method ----------
        //setPrimaryClip(ClipData.newPlainText(null, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.065 -0400", hash_original_method = "9F22D463FB706DEB91BA1565CF5CF48D", hash_generated_method = "E06E996134C46D7B4A81B083AB16658B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasText() {
        try 
        {
            boolean var5090D494BD5C885F44AA60AE07CD9967_2015130167 = (getService().hasClipboardText());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return getService().hasClipboardText();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.065 -0400", hash_original_method = "0985A14308F67055EBA5FC0B7343D794", hash_generated_method = "CCF40207AA7C5CA7B9CFDA549D648159")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void reportPrimaryClipChanged() {
        Object[] listeners;
        {
            int N;
            N = mPrimaryClipChangedListeners.size();
            listeners = mPrimaryClipChangedListeners.toArray();
        } //End block
        {
            int i;
            i = 0;
            {
                ((OnPrimaryClipChangedListener)listeners[i]).onPrimaryClipChanged();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Object[] listeners;
        //synchronized (mPrimaryClipChangedListeners) {
            //final int N = mPrimaryClipChangedListeners.size();
            //if (N <= 0) {
                //return;
            //}
            //listeners = mPrimaryClipChangedListeners.toArray();
        //}
        //for (int i=0; i<listeners.length; i++) {
            //((OnPrimaryClipChangedListener)listeners[i]).onPrimaryClipChanged();
        //}
    }

    
    public interface OnPrimaryClipChangedListener {
        void onPrimaryClipChanged();
    }
    
    private final static Object sStaticLock = new Object();
    private static IClipboard sService;
    static final int MSG_REPORT_PRIMARY_CLIP_CHANGED = 1;
}

