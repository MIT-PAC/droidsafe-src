package android.content;

// Droidsafe Imports
import java.util.ArrayList;

import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class ClipboardManager extends android.text.ClipboardManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.624 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.624 -0400", hash_original_field = "C4FB4E35010BD7489930A3D26DDC0ADA", hash_generated_field = "E56DE56B7E953844281AFE87E0843DAB")

    private final ArrayList<OnPrimaryClipChangedListener> mPrimaryClipChangedListeners = new ArrayList<OnPrimaryClipChangedListener>();
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.625 -0400", hash_original_method = "97558C16BA3BDE6476EDF618E25B9B81", hash_generated_method = "96F575CB12FC3C55C0854FEB3CCF2F69")
    public  ClipboardManager(Context context, Handler handler) {
        addTaint(handler.getTaint());
        mContext = context;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.626 -0400", hash_original_method = "9758ADBACC2D859F954394BF2EAF123A", hash_generated_method = "C077EDAF3AC2928AD4E7AFB596B32944")
    public void setPrimaryClip(ClipData clip) {
        addTaint(clip.getTaint());
        try 
        {
            getService().setPrimaryClip(clip);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //getService().setPrimaryClip(clip);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.626 -0400", hash_original_method = "50B348CB23C6EF42B3CBE9B194465F2B", hash_generated_method = "24220148FE65856C592F74ED73BA6506")
    public ClipData getPrimaryClip() {
        try 
        {
ClipData varEA460A7A81D36BB15FF7AEC2DAF2CE12_171279541 =             getService().getPrimaryClip(mContext.getPackageName());
            varEA460A7A81D36BB15FF7AEC2DAF2CE12_171279541.addTaint(taint);
            return varEA460A7A81D36BB15FF7AEC2DAF2CE12_171279541;
        } //End block
        catch (RemoteException e)
        {
ClipData var540C13E9E156B687226421B24F2DF178_545734480 =             null;
            var540C13E9E156B687226421B24F2DF178_545734480.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_545734480;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getService().getPrimaryClip(mContext.getPackageName());
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.627 -0400", hash_original_method = "678ECBBFE5F09A43CDAAF81F6FD5AC97", hash_generated_method = "704FF651ED764C9525F0ED440D21720B")
    public ClipDescription getPrimaryClipDescription() {
        try 
        {
ClipDescription var44B2C124A428D0DD59ED267CFD8E15D8_425307479 =             getService().getPrimaryClipDescription();
            var44B2C124A428D0DD59ED267CFD8E15D8_425307479.addTaint(taint);
            return var44B2C124A428D0DD59ED267CFD8E15D8_425307479;
        } //End block
        catch (RemoteException e)
        {
ClipDescription var540C13E9E156B687226421B24F2DF178_1435410999 =             null;
            var540C13E9E156B687226421B24F2DF178_1435410999.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1435410999;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getService().getPrimaryClipDescription();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.627 -0400", hash_original_method = "CBBCF938F0063A19991B3E7A8193FD4F", hash_generated_method = "1375A678BBEED1A85DEB94E8E862EDEB")
    public boolean hasPrimaryClip() {
        try 
        {
            boolean var5B2E53189D3D8689EE1BFBF67B84E4B5_84439701 = (getService().hasPrimaryClip());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_683102368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_683102368;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1095926709 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403260613 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_403260613;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getService().hasPrimaryClip();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.628 -0400", hash_original_method = "E5044C03AB4AD3DC9569B565F2008B98", hash_generated_method = "819B78AB9B22DA84A62C55B5ED2112B6")
    public void addPrimaryClipChangedListener(OnPrimaryClipChangedListener what) {
        addTaint(what.getTaint());
        synchronized
(mPrimaryClipChangedListeners)        {
            if(mPrimaryClipChangedListeners.size() == 0)            
            {
                try 
                {
                    getService().addPrimaryClipChangedListener(
                            mPrimaryClipChangedServiceListener);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.629 -0400", hash_original_method = "7128B19124A44EC27CC4C323B8513057", hash_generated_method = "51F1EB6BAFC7BCAF35B59826C1946785")
    public void removePrimaryClipChangedListener(OnPrimaryClipChangedListener what) {
        addTaint(what.getTaint());
        synchronized
(mPrimaryClipChangedListeners)        {
            mPrimaryClipChangedListeners.remove(what);
            if(mPrimaryClipChangedListeners.size() == 0)            
            {
                try 
                {
                    getService().removePrimaryClipChangedListener(
                            mPrimaryClipChangedServiceListener);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.630 -0400", hash_original_method = "D9D561BF0732BC43D4A46DB226A10D9C", hash_generated_method = "44E0A88568964D30A7D02B36B8DAB8F9")
    public CharSequence getText() {
        ClipData clip = getPrimaryClip();
        if(clip != null && clip.getItemCount() > 0)        
        {
CharSequence varEC8188868AFABB27F958E34809640CFA_512205563 =             clip.getItemAt(0).coerceToText(mContext);
            varEC8188868AFABB27F958E34809640CFA_512205563.addTaint(taint);
            return varEC8188868AFABB27F958E34809640CFA_512205563;
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_1275150104 =         null;
        var540C13E9E156B687226421B24F2DF178_1275150104.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1275150104;
        // ---------- Original Method ----------
        //ClipData clip = getPrimaryClip();
        //if (clip != null && clip.getItemCount() > 0) {
            //return clip.getItemAt(0).coerceToText(mContext);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.631 -0400", hash_original_method = "31E7EB6BE33A923560F7B9C2B2D8F3DA", hash_generated_method = "C96AC0747FF8EFA657ED007F391D47D9")
    public void setText(CharSequence text) {
        addTaint(text.getTaint());
        setPrimaryClip(ClipData.newPlainText(null, text));
        // ---------- Original Method ----------
        //setPrimaryClip(ClipData.newPlainText(null, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.631 -0400", hash_original_method = "9F22D463FB706DEB91BA1565CF5CF48D", hash_generated_method = "6A820A34513066EC8AF7FC23B1968216")
    public boolean hasText() {
        try 
        {
            boolean var81667AFC854212260A8335B5C89C7E10_109749694 = (getService().hasClipboardText());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295373327 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_295373327;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1234005393 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659167610 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_659167610;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getService().hasClipboardText();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.632 -0400", hash_original_method = "0985A14308F67055EBA5FC0B7343D794", hash_generated_method = "7EDD6759F2C02959CCE3BB1729937FBB")
     void reportPrimaryClipChanged() {
        Object[] listeners;
        synchronized
(mPrimaryClipChangedListeners)        {
            final int N = mPrimaryClipChangedListeners.size();
            if(N <= 0)            
            {
                return;
            } //End block
            listeners = mPrimaryClipChangedListeners.toArray();
        } //End block
for(int i=0;i<listeners.length;i++)
        {
            ((OnPrimaryClipChangedListener)listeners[i]).onPrimaryClipChanged();
        } //End block
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.633 -0400", hash_original_field = "6F01FC6BDB2E7BC12F6360B41E8B2316", hash_generated_field = "F842219FC69FE9ACCBA41EF52147C0D4")

    private final static Object sStaticLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.633 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "7DAD8437C868C87DD2CEB4861B4C57D1")

    private static IClipboard sService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.633 -0400", hash_original_field = "0EDC3B36A8AD58E17D93760B7667D1D3", hash_generated_field = "3C04989ED0EDFEE643DF5780498583F4")

    static final int MSG_REPORT_PRIMARY_CLIP_CHANGED = 1;
}

