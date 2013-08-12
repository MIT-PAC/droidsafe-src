package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.ArrayList;






public class WebBackForwardList implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.333 -0400", hash_original_field = "11F35ED6948C3740873B941C47BA8C27", hash_generated_field = "0311A696B59887F86EF6109DBE0484CC")

    private int mCurrentIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.333 -0400", hash_original_field = "982501881A3C318D6605E92D3AB0ADBA", hash_generated_field = "65483EDB69D85E829A0A1D4D7EF789CD")

    private ArrayList<WebHistoryItem> mArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.333 -0400", hash_original_field = "78C6471919B09528C81DBDC9ECC0E774", hash_generated_field = "602E0BBCBCA5B94178C21F3474243E08")

    private boolean mClearPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.333 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.333 -0400", hash_original_method = "E1648D2B4FFD2451814681FC87C9187A", hash_generated_method = "7FB6F1394EADFBA10F9743A782787424")
      WebBackForwardList(CallbackProxy proxy) {
        mCurrentIndex = -1;
        mArray = new ArrayList<WebHistoryItem>();
        mCallbackProxy = proxy;
        // ---------- Original Method ----------
        //mCurrentIndex = -1;
        //mArray = new ArrayList<WebHistoryItem>();
        //mCallbackProxy = proxy;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.333 -0400", hash_original_method = "5230E69659F0505E7D194D2488C74C74", hash_generated_method = "59F1AC66CF7549F14667DAE5912DCD50")
    public synchronized WebHistoryItem getCurrentItem() {
WebHistoryItem var2F460A70B42FEDF7C169E372B218C579_127847532 =         getItemAtIndex(mCurrentIndex);
        var2F460A70B42FEDF7C169E372B218C579_127847532.addTaint(taint);
        return var2F460A70B42FEDF7C169E372B218C579_127847532;
        // ---------- Original Method ----------
        //return getItemAtIndex(mCurrentIndex);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.333 -0400", hash_original_method = "2A2A2AA161DBB8DEEC2045188BE5DE03", hash_generated_method = "8119F3B3B31DB2590FD00A08C9EB817D")
    public synchronized int getCurrentIndex() {
        int var11F35ED6948C3740873B941C47BA8C27_1588454366 = (mCurrentIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_486030323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_486030323;
        // ---------- Original Method ----------
        //return mCurrentIndex;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.333 -0400", hash_original_method = "D9B5D5CD50BAA8A173683EE2BD19F40F", hash_generated_method = "81B8951AA689C266901A422AF049F1F0")
    public synchronized WebHistoryItem getItemAtIndex(int index) {
        addTaint(index);
        if(index < 0 || index >= getSize())        
        {
WebHistoryItem var540C13E9E156B687226421B24F2DF178_936916444 =             null;
            var540C13E9E156B687226421B24F2DF178_936916444.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_936916444;
        } //End block
WebHistoryItem varDDBCB502A256E36ED75BFBF3E3E9916A_2024253930 =         mArray.get(index);
        varDDBCB502A256E36ED75BFBF3E3E9916A_2024253930.addTaint(taint);
        return varDDBCB502A256E36ED75BFBF3E3E9916A_2024253930;
        // ---------- Original Method ----------
        //if (index < 0 || index >= getSize()) {
            //return null;
        //}
        //return mArray.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.333 -0400", hash_original_method = "7A631E875D902776AD0C3E21989EE281", hash_generated_method = "DF5073A8B7DA1CA71FF8E72AF2361160")
    public synchronized int getSize() {
        int var09B3B0655913A7D2FE658AF63313F205_826921240 = (mArray.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1188625712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1188625712;
        // ---------- Original Method ----------
        //return mArray.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.333 -0400", hash_original_method = "7F0DA21FF2FDC3954DD60BB35F4D7E5E", hash_generated_method = "FD3EA87E0200D54A51503BD7F9A0EE2C")
    synchronized void setClearPending() {
        mClearPending = true;
        // ---------- Original Method ----------
        //mClearPending = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.334 -0400", hash_original_method = "18F3D3D2A3274FA9BAB45BC52054A870", hash_generated_method = "FDA10A63EC6EE1C69CB2308B4CFC77A7")
    synchronized boolean getClearPending() {
        boolean var78C6471919B09528C81DBDC9ECC0E774_744588415 = (mClearPending);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400778519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400778519;
        // ---------- Original Method ----------
        //return mClearPending;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.334 -0400", hash_original_method = "CF7A7A96F9B6499845E300F4AB5BE8D8", hash_generated_method = "0EBF114574A821F9EBFED5E717064E47")
    synchronized void addHistoryItem(WebHistoryItem item) {
        addTaint(item.getTaint());
        ++mCurrentIndex;
        final int size = mArray.size();
        final int newPos = mCurrentIndex;
        if(newPos != size)        
        {
for(int i = size - 1;i >= newPos;i--)
            {
                final WebHistoryItem h = mArray.remove(i);
            } //End block
        } //End block
        mArray.add(item);
        if(mCallbackProxy != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.334 -0400", hash_original_method = "86E2ECBC2C9AC2A7DC658CB964CA32CA", hash_generated_method = "9A78312A1ABE2FA1B90D2D6CC52770E0")
    synchronized void close(int nativeFrame) {
        addTaint(nativeFrame);
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.334 -0400", hash_original_method = "7D1DAF4A518C34619CF3BEB7A8646574", hash_generated_method = "48FDB3F786FB036DDF89F892D8FEA57F")
    private synchronized void removeHistoryItem(int index) {
        addTaint(index);
        if(DebugFlags.WEB_BACK_FORWARD_LIST && (index != 0))        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1390165437 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1390165437.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1390165437;
        } //End block
        final WebHistoryItem h = mArray.remove(index);
        mCurrentIndex--;
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_BACK_FORWARD_LIST && (index != 0)) {
            //throw new AssertionError();
        //}
        //final WebHistoryItem h = mArray.remove(index);
        //mCurrentIndex--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.335 -0400", hash_original_method = "26B3CB37F20A0B53C2CE3E9A4CAEEB23", hash_generated_method = "FC2E17FFE574BB426814D814AC1F4D1D")
    protected synchronized WebBackForwardList clone() {
        WebBackForwardList l = new WebBackForwardList(null);
        if(mClearPending)        
        {
            l.addHistoryItem(getCurrentItem());
WebBackForwardList var792FD495AAD83D144D2F19BF9BB22987_1387748180 =             l;
            var792FD495AAD83D144D2F19BF9BB22987_1387748180.addTaint(taint);
            return var792FD495AAD83D144D2F19BF9BB22987_1387748180;
        } //End block
        l.mCurrentIndex = mCurrentIndex;
        int size = getSize();
        l.mArray = new ArrayList<WebHistoryItem>(size);
for(int i = 0;i < size;i++)
        {
            l.mArray.add(mArray.get(i).clone());
        } //End block
WebBackForwardList var792FD495AAD83D144D2F19BF9BB22987_1238368654 =         l;
        var792FD495AAD83D144D2F19BF9BB22987_1238368654.addTaint(taint);
        return var792FD495AAD83D144D2F19BF9BB22987_1238368654;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.335 -0400", hash_original_method = "CB94BF4CFE461E0C4E4AA1BED49D9ED0", hash_generated_method = "848B6222628DB7C6DA7EF60D17A25E36")
    synchronized void setCurrentIndex(int newIndex) {
        mCurrentIndex = newIndex;
        if(mCallbackProxy != null)        
        {
            mCallbackProxy.onIndexChanged(getItemAtIndex(newIndex), newIndex);
        } //End block
        // ---------- Original Method ----------
        //mCurrentIndex = newIndex;
        //if (mCallbackProxy != null) {
            //mCallbackProxy.onIndexChanged(getItemAtIndex(newIndex), newIndex);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    static synchronized void restoreIndex(int nativeFrame,
            int index) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClose(int nativeFrame) {
    }

    
}

