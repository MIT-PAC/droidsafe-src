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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.734 -0400", hash_original_field = "11F35ED6948C3740873B941C47BA8C27", hash_generated_field = "0311A696B59887F86EF6109DBE0484CC")

    private int mCurrentIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.734 -0400", hash_original_field = "982501881A3C318D6605E92D3AB0ADBA", hash_generated_field = "65483EDB69D85E829A0A1D4D7EF789CD")

    private ArrayList<WebHistoryItem> mArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.734 -0400", hash_original_field = "78C6471919B09528C81DBDC9ECC0E774", hash_generated_field = "602E0BBCBCA5B94178C21F3474243E08")

    private boolean mClearPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.734 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.734 -0400", hash_original_method = "E1648D2B4FFD2451814681FC87C9187A", hash_generated_method = "7FB6F1394EADFBA10F9743A782787424")
      WebBackForwardList(CallbackProxy proxy) {
        mCurrentIndex = -1;
        mArray = new ArrayList<WebHistoryItem>();
        mCallbackProxy = proxy;
        // ---------- Original Method ----------
        //mCurrentIndex = -1;
        //mArray = new ArrayList<WebHistoryItem>();
        //mCallbackProxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.735 -0400", hash_original_method = "5230E69659F0505E7D194D2488C74C74", hash_generated_method = "A7DFB2D3E7D456744450E18D008BA068")
    public synchronized WebHistoryItem getCurrentItem() {
        WebHistoryItem varB4EAC82CA7396A68D541C85D26508E83_1257765941 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1257765941 = getItemAtIndex(mCurrentIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1257765941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1257765941;
        // ---------- Original Method ----------
        //return getItemAtIndex(mCurrentIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.735 -0400", hash_original_method = "2A2A2AA161DBB8DEEC2045188BE5DE03", hash_generated_method = "FF6A95510A4BB50BBDAFD9FA157B669C")
    public synchronized int getCurrentIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844729692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844729692;
        // ---------- Original Method ----------
        //return mCurrentIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.736 -0400", hash_original_method = "D9B5D5CD50BAA8A173683EE2BD19F40F", hash_generated_method = "66FC8CD31152127AC6FC4454CB164B2D")
    public synchronized WebHistoryItem getItemAtIndex(int index) {
        WebHistoryItem varB4EAC82CA7396A68D541C85D26508E83_454662076 = null; //Variable for return #1
        WebHistoryItem varB4EAC82CA7396A68D541C85D26508E83_1591749531 = null; //Variable for return #2
        {
            boolean varA5D78388D1DB5757C5FDBD9AC04CD754_858388223 = (index < 0 || index >= getSize());
            {
                varB4EAC82CA7396A68D541C85D26508E83_454662076 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1591749531 = mArray.get(index);
        addTaint(index);
        WebHistoryItem varA7E53CE21691AB073D9660D615818899_1620348554; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1620348554 = varB4EAC82CA7396A68D541C85D26508E83_454662076;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1620348554 = varB4EAC82CA7396A68D541C85D26508E83_1591749531;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1620348554.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1620348554;
        // ---------- Original Method ----------
        //if (index < 0 || index >= getSize()) {
            //return null;
        //}
        //return mArray.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.736 -0400", hash_original_method = "7A631E875D902776AD0C3E21989EE281", hash_generated_method = "34F0A364D70F4A7AD01583E412C68920")
    public synchronized int getSize() {
        int var7455E58CFFC61945CF91CF5A14C68819_136753502 = (mArray.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_219981201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_219981201;
        // ---------- Original Method ----------
        //return mArray.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.736 -0400", hash_original_method = "7F0DA21FF2FDC3954DD60BB35F4D7E5E", hash_generated_method = "FD3EA87E0200D54A51503BD7F9A0EE2C")
    synchronized void setClearPending() {
        mClearPending = true;
        // ---------- Original Method ----------
        //mClearPending = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.737 -0400", hash_original_method = "18F3D3D2A3274FA9BAB45BC52054A870", hash_generated_method = "0AE1F0E34E2FADFAEA4968C2833CA2B0")
    synchronized boolean getClearPending() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418960796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418960796;
        // ---------- Original Method ----------
        //return mClearPending;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.737 -0400", hash_original_method = "CF7A7A96F9B6499845E300F4AB5BE8D8", hash_generated_method = "99AE670B9B2EA0F9B8F2E06A5EC81577")
    synchronized void addHistoryItem(WebHistoryItem item) {
        final int size = mArray.size();
        final int newPos = mCurrentIndex;
        {
            {
                int i = size - 1;
                {
                    final WebHistoryItem h = mArray.remove(i);
                } //End block
            } //End collapsed parenthetic
        } //End block
        mArray.add(item);
        {
            mCallbackProxy.onNewHistoryItem(item);
        } //End block
        addTaint(item.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.737 -0400", hash_original_method = "86E2ECBC2C9AC2A7DC658CB964CA32CA", hash_generated_method = "A46CD0037D9289A5994F48D957F34B2B")
    synchronized void close(int nativeFrame) {
        mArray.clear();
        mCurrentIndex = -1;
        nativeClose(nativeFrame);
        mClearPending = false;
        addTaint(nativeFrame);
        // ---------- Original Method ----------
        //mArray.clear();
        //mCurrentIndex = -1;
        //nativeClose(nativeFrame);
        //mClearPending = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.738 -0400", hash_original_method = "7D1DAF4A518C34619CF3BEB7A8646574", hash_generated_method = "27F91065D6A8858AD4A092A9AF85D3CD")
    private synchronized void removeHistoryItem(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        final WebHistoryItem h = mArray.remove(index);
        addTaint(index);
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_BACK_FORWARD_LIST && (index != 0)) {
            //throw new AssertionError();
        //}
        //final WebHistoryItem h = mArray.remove(index);
        //mCurrentIndex--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.740 -0400", hash_original_method = "26B3CB37F20A0B53C2CE3E9A4CAEEB23", hash_generated_method = "50371AE3B4BD7FB5F5FD3680E85AC400")
    protected synchronized WebBackForwardList clone() {
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1470966807 = null; //Variable for return #1
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_93850745 = null; //Variable for return #2
        WebBackForwardList l = new WebBackForwardList(null);
        {
            l.addHistoryItem(getCurrentItem());
            varB4EAC82CA7396A68D541C85D26508E83_1470966807 = l;
        } //End block
        l.mCurrentIndex = mCurrentIndex;
        int size = getSize();
        l.mArray = new ArrayList<WebHistoryItem>(size);
        {
            int i = 0;
            {
                l.mArray.add(mArray.get(i).clone());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_93850745 = l;
        WebBackForwardList varA7E53CE21691AB073D9660D615818899_294893678; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_294893678 = varB4EAC82CA7396A68D541C85D26508E83_1470966807;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_294893678 = varB4EAC82CA7396A68D541C85D26508E83_93850745;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_294893678.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_294893678;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.740 -0400", hash_original_method = "CB94BF4CFE461E0C4E4AA1BED49D9ED0", hash_generated_method = "E68DE0CD184B9CF5D7DCE116FC81D35D")
    synchronized void setCurrentIndex(int newIndex) {
        mCurrentIndex = newIndex;
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

