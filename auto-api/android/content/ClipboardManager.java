package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final static Object sStaticLock = new Object();
    private static IClipboard sService;
    private final Context mContext;
    private final ArrayList<OnPrimaryClipChangedListener> mPrimaryClipChangedListeners
             = new ArrayList<OnPrimaryClipChangedListener>();
    private final IOnPrimaryClipChangedListener.Stub mPrimaryClipChangedServiceListener = new IOnPrimaryClipChangedListener.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.220 -0400", hash_original_method = "70003E26F597B4FA21D37DAC4C2F415E", hash_generated_method = "BE500062A9A332800F01C1022AA4A5CF")
        @DSModeled(DSC.SAFE)
        public void dispatchPrimaryClipChanged() {
            mHandler.sendEmptyMessage(MSG_REPORT_PRIMARY_CLIP_CHANGED);
            // ---------- Original Method ----------
            //mHandler.sendEmptyMessage(MSG_REPORT_PRIMARY_CLIP_CHANGED);
        }

        
}; //Transformed anonymous class
    static final int MSG_REPORT_PRIMARY_CLIP_CHANGED = 1;
    private final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.220 -0400", hash_original_method = "5AAF932430F5A3E1179C80D13696BD76", hash_generated_method = "E42C9B2A1693EF16136B71E826730C5D")
        @DSModeled(DSC.SAFE)
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.220 -0400", hash_original_method = "97558C16BA3BDE6476EDF618E25B9B81", hash_generated_method = "DD2390161D9982773C570FCA6E235604")
    @DSModeled(DSC.SAFE)
    public ClipboardManager(Context context, Handler handler) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.220 -0400", hash_original_method = "B823D91CB0BDECA7B94A432D3169CF0F", hash_generated_method = "E46EEAD91E5B0F8A4FFB94615D67E32E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.221 -0400", hash_original_method = "9758ADBACC2D859F954394BF2EAF123A", hash_generated_method = "CEF815EBAB0CE8305FC887A985315819")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.221 -0400", hash_original_method = "50B348CB23C6EF42B3CBE9B194465F2B", hash_generated_method = "35AEBA82A4B5C5E98FD78BA298566600")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClipData getPrimaryClip() {
        try 
        {
            ClipData var3225996981D61B82C5D11E20D0A48EDA_195102504 = (getService().getPrimaryClip(mContext.getPackageName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.221 -0400", hash_original_method = "678ECBBFE5F09A43CDAAF81F6FD5AC97", hash_generated_method = "AA0810B4927DC720AA915AD0EDBA770D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClipDescription getPrimaryClipDescription() {
        try 
        {
            ClipDescription var1832F070027C37D41B4E6F1F2F661056_229416776 = (getService().getPrimaryClipDescription());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.222 -0400", hash_original_method = "CBBCF938F0063A19991B3E7A8193FD4F", hash_generated_method = "2895226C495ABD96A43B4E1DB34D04C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasPrimaryClip() {
        try 
        {
            boolean var3C757C01DE776AE9A44F6650B0C4FBA6_312406455 = (getService().hasPrimaryClip());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.222 -0400", hash_original_method = "E5044C03AB4AD3DC9569B565F2008B98", hash_generated_method = "6F05C42B550D0B572B0E7A952B33926C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addPrimaryClipChangedListener(OnPrimaryClipChangedListener what) {
        dsTaint.addTaint(what.dsTaint);
        {
            {
                boolean var6174F040073C34898448239A43E2EAFC_1042692121 = (mPrimaryClipChangedListeners.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.222 -0400", hash_original_method = "7128B19124A44EC27CC4C323B8513057", hash_generated_method = "363E8E532DB3C08198969CFF02386B0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePrimaryClipChangedListener(OnPrimaryClipChangedListener what) {
        dsTaint.addTaint(what.dsTaint);
        {
            mPrimaryClipChangedListeners.remove(what);
            {
                boolean var6174F040073C34898448239A43E2EAFC_978063716 = (mPrimaryClipChangedListeners.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.223 -0400", hash_original_method = "D9D561BF0732BC43D4A46DB226A10D9C", hash_generated_method = "D1196E4F7F3F4E948A87798448AC4913")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getText() {
        ClipData clip;
        clip = getPrimaryClip();
        {
            boolean var199BC11988A51D31CFFDE3AC3DC661B9_366128889 = (clip != null && clip.getItemCount() > 0);
            {
                CharSequence var2FE90B321F188CF62C49319BD130D036_211673062 = (clip.getItemAt(0).coerceToText(mContext));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.223 -0400", hash_original_method = "31E7EB6BE33A923560F7B9C2B2D8F3DA", hash_generated_method = "735975AD23BBD7499A7CCC1A76E0DD57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(CharSequence text) {
        dsTaint.addTaint(text);
        setPrimaryClip(ClipData.newPlainText(null, text));
        // ---------- Original Method ----------
        //setPrimaryClip(ClipData.newPlainText(null, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.223 -0400", hash_original_method = "9F22D463FB706DEB91BA1565CF5CF48D", hash_generated_method = "DED6059799CD7627E9C50A7A609190C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasText() {
        try 
        {
            boolean var5090D494BD5C885F44AA60AE07CD9967_1845709158 = (getService().hasClipboardText());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.224 -0400", hash_original_method = "0985A14308F67055EBA5FC0B7343D794", hash_generated_method = "3D4FC277411AC7E4B639DB5443176DFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void reportPrimaryClipChanged() {
        Object[] listeners;
        {
            final int N;
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
    
}


