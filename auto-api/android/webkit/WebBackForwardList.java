package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.ArrayList;

public class WebBackForwardList implements Cloneable, Serializable {
    private int mCurrentIndex;
    private ArrayList<WebHistoryItem> mArray;
    private boolean mClearPending;
    private CallbackProxy mCallbackProxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.902 -0400", hash_original_method = "E1648D2B4FFD2451814681FC87C9187A", hash_generated_method = "FEF20510FFFEBCB4D0265E82A8719671")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     WebBackForwardList(CallbackProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        mCurrentIndex = -1;
        mArray = new ArrayList<WebHistoryItem>();
        // ---------- Original Method ----------
        //mCurrentIndex = -1;
        //mArray = new ArrayList<WebHistoryItem>();
        //mCallbackProxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.902 -0400", hash_original_method = "5230E69659F0505E7D194D2488C74C74", hash_generated_method = "D9BF77259A4110CBCC3134273AFD1B5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized WebHistoryItem getCurrentItem() {
        WebHistoryItem var160A4DD612F38B9D179A2A22BEC7322D_1766840253 = (getItemAtIndex(mCurrentIndex));
        return (WebHistoryItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getItemAtIndex(mCurrentIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.903 -0400", hash_original_method = "2A2A2AA161DBB8DEEC2045188BE5DE03", hash_generated_method = "EECE07B1C41FCAC2719F8F9BB576C89F")
    @DSModeled(DSC.SAFE)
    public synchronized int getCurrentIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCurrentIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.903 -0400", hash_original_method = "D9B5D5CD50BAA8A173683EE2BD19F40F", hash_generated_method = "05A652342E16B3BEA4F70E1E9020A22B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized WebHistoryItem getItemAtIndex(int index) {
        dsTaint.addTaint(index);
        {
            boolean varA5D78388D1DB5757C5FDBD9AC04CD754_460355995 = (index < 0 || index >= getSize());
        } //End collapsed parenthetic
        WebHistoryItem var3652A3B7BFEC5A937F6D54FEADE63A5B_1820271630 = (mArray.get(index));
        return (WebHistoryItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (index < 0 || index >= getSize()) {
            //return null;
        //}
        //return mArray.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.903 -0400", hash_original_method = "7A631E875D902776AD0C3E21989EE281", hash_generated_method = "9340D3D836D0221B877D513995B2C43E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getSize() {
        int var7455E58CFFC61945CF91CF5A14C68819_1047735739 = (mArray.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mArray.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.903 -0400", hash_original_method = "7F0DA21FF2FDC3954DD60BB35F4D7E5E", hash_generated_method = "FD3EA87E0200D54A51503BD7F9A0EE2C")
    @DSModeled(DSC.SAFE)
    synchronized void setClearPending() {
        mClearPending = true;
        // ---------- Original Method ----------
        //mClearPending = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.903 -0400", hash_original_method = "18F3D3D2A3274FA9BAB45BC52054A870", hash_generated_method = "5C2DC5EFAB26B5596B00659E1C1C27AC")
    @DSModeled(DSC.SAFE)
    synchronized boolean getClearPending() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClearPending;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.903 -0400", hash_original_method = "CF7A7A96F9B6499845E300F4AB5BE8D8", hash_generated_method = "A2A9556F1A9AF6C855DCA742B1354430")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void addHistoryItem(WebHistoryItem item) {
        dsTaint.addTaint(item.dsTaint);
        int size;
        size = mArray.size();
        int newPos;
        newPos = mCurrentIndex;
        {
            {
                int i;
                i = size - 1;
                {
                    WebHistoryItem h;
                    h = mArray.remove(i);
                } //End block
            } //End collapsed parenthetic
        } //End block
        mArray.add(item);
        {
            mCallbackProxy.onNewHistoryItem(item);
        } //End block
        // ---------- Original Method ----------
        //++mCurrentIndex;
        //final int size = mArray.size();
        //final int newPos = mCurrentIndex;
        //if (newPos != size) {
            //for (int i = size - 1; i >= newPos; i--) {
                //final WebHistoryItem h = mArray.remove(i);
            //}
        //}
        //mArray.add(item);
        //if (mCallbackProxy != null) {
            //mCallbackProxy.onNewHistoryItem(item);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.904 -0400", hash_original_method = "86E2ECBC2C9AC2A7DC658CB964CA32CA", hash_generated_method = "FDA8B982BBD0B916DBFEE1EA489A30FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void close(int nativeFrame) {
        dsTaint.addTaint(nativeFrame);
        mArray.clear();
        mCurrentIndex = -1;
        nativeClose(nativeFrame);
        mClearPending = false;
        // ---------- Original Method ----------
        //mArray.clear();
        //mCurrentIndex = -1;
        //nativeClose(nativeFrame);
        //mClearPending = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.904 -0400", hash_original_method = "7D1DAF4A518C34619CF3BEB7A8646574", hash_generated_method = "09226C6A3B71EAE46EA31F11B09CDA5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void removeHistoryItem(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        WebHistoryItem h;
        h = mArray.remove(index);
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_BACK_FORWARD_LIST && (index != 0)) {
            //throw new AssertionError();
        //}
        //final WebHistoryItem h = mArray.remove(index);
        //mCurrentIndex--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.966 -0400", hash_original_method = "26B3CB37F20A0B53C2CE3E9A4CAEEB23", hash_generated_method = "D3F1917E5B68004758F9AA35A517C6FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected synchronized WebBackForwardList clone() {
        WebBackForwardList l;
        l = new WebBackForwardList(null);
        {
            l.addHistoryItem(getCurrentItem());
        } //End block
        l.mCurrentIndex = mCurrentIndex;
        int size;
        size = getSize();
        l.mArray = new ArrayList<WebHistoryItem>(size);
        {
            int i;
            i = 0;
            {
                l.mArray.add(mArray.get(i).clone());
            } //End block
        } //End collapsed parenthetic
        return (WebBackForwardList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //WebBackForwardList l = new WebBackForwardList(null);
        //if (mClearPending) {
            //l.addHistoryItem(getCurrentItem());
            //return l;
        //}
        //l.mCurrentIndex = mCurrentIndex;
        //int size = getSize();
        //l.mArray = new ArrayList<WebHistoryItem>(size);
        //for (int i = 0; i < size; i++) {
            //l.mArray.add(mArray.get(i).clone());
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.966 -0400", hash_original_method = "CB94BF4CFE461E0C4E4AA1BED49D9ED0", hash_generated_method = "01FD5FC1C85CBE90BE7996D553309F21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void setCurrentIndex(int newIndex) {
        dsTaint.addTaint(newIndex);
        {
            mCallbackProxy.onIndexChanged(getItemAtIndex(newIndex), newIndex);
        } //End block
        // ---------- Original Method ----------
        //mCurrentIndex = newIndex;
        //if (mCallbackProxy != null) {
            //mCallbackProxy.onIndexChanged(getItemAtIndex(newIndex), newIndex);
        //}
    }

    
        static synchronized void restoreIndex(int nativeFrame,
            int index) {
    }

    
        private static void nativeClose(int nativeFrame) {
    }

    
}

