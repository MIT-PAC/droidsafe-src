package android.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityRecord {
    private AccessibilityRecord mNext;
    private boolean mIsInPool;
    boolean mSealed;
    int mBooleanProperties;
    int mCurrentItemIndex = UNDEFINED;
    int mItemCount = UNDEFINED;
    int mFromIndex = UNDEFINED;
    int mToIndex = UNDEFINED;
    int mScrollX = UNDEFINED;
    int mScrollY = UNDEFINED;
    int mMaxScrollX = UNDEFINED;
    int mMaxScrollY = UNDEFINED;
    int mAddedCount= UNDEFINED;
    int mRemovedCount = UNDEFINED;
    int mSourceViewId = UNDEFINED;
    int mSourceWindowId = UNDEFINED;
    CharSequence mClassName;
    CharSequence mContentDescription;
    CharSequence mBeforeText;
    Parcelable mParcelableData;
    List<CharSequence> mText = new ArrayList<CharSequence>();
    int mConnectionId = UNDEFINED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.887 -0400", hash_original_method = "47B5C6FFA7A08624EFFE67BFFC3F0DF4", hash_generated_method = "49EEADD37CBD0DA6FCCFEC65E1335A11")
    @DSModeled(DSC.SAFE)
     AccessibilityRecord() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.887 -0400", hash_original_method = "948A1D8CF51CA12DCE9E50B8B6FDE838", hash_generated_method = "F49113530ECCB4F0D56A0E2AC8CAB959")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSource(View source) {
        dsTaint.addTaint(source.dsTaint);
        enforceNotSealed();
        {
            mSourceWindowId = source.getAccessibilityWindowId();
            mSourceViewId = source.getAccessibilityViewId();
        } //End block
        {
            mSourceWindowId = UNDEFINED;
            mSourceViewId = UNDEFINED;
        } //End block
        // ---------- Original Method ----------
        //enforceNotSealed();
        //if (source != null) {
            //mSourceWindowId = source.getAccessibilityWindowId();
            //mSourceViewId = source.getAccessibilityViewId();
        //} else {
            //mSourceWindowId = UNDEFINED;
            //mSourceViewId = UNDEFINED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.887 -0400", hash_original_method = "D6229F18D386359B7D2ED64A724CE545", hash_generated_method = "B4ADC1A46EEB9747046A340E9FBB2624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityNodeInfo getSource() {
        enforceSealed();
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        AccessibilityNodeInfo var7DA618B898F7B8D2FCA7873B64F0C97D_654584438 = (client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId, mSourceWindowId,
                mSourceViewId));
        return (AccessibilityNodeInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //enforceSealed();
        //if (mConnectionId == UNDEFINED || mSourceWindowId == UNDEFINED
                //|| mSourceViewId == UNDEFINED) {
            //return null;
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId, mSourceWindowId,
                //mSourceViewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.888 -0400", hash_original_method = "0167B817243C7300A3E7B07356FC6F77", hash_generated_method = "C2E49CC92EA268C209090F616ECFA943")
    @DSModeled(DSC.SAFE)
    public int getWindowId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSourceWindowId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.888 -0400", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "790B7B8BF5DBE6643E516E72DC3891E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isChecked() {
        boolean var452C23D949DE68DF158EF7F75ABFD98B_1561089128 = (getBooleanProperty(PROPERTY_CHECKED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.888 -0400", hash_original_method = "EF363FCE51C9C9A497BD6E689D39B09F", hash_generated_method = "4D53513BE1E6B2DE41D3C97F415D24AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChecked(boolean isChecked) {
        dsTaint.addTaint(isChecked);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_CHECKED, isChecked);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_CHECKED, isChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.888 -0400", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "26DFA0B849A8D7820D206947F0842F22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEnabled() {
        boolean var8448E9D671258D44185D3F547D298C9D_755341977 = (getBooleanProperty(PROPERTY_ENABLED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.888 -0400", hash_original_method = "0EAAA686E8658459FDC66C98C4B45340", hash_generated_method = "469592F4344CA82A4C2006A3B20C6222")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEnabled(boolean isEnabled) {
        dsTaint.addTaint(isEnabled);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_ENABLED, isEnabled);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_ENABLED, isEnabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.889 -0400", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "5E59128C0A389B28CE3AC555A3F56A07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPassword() {
        boolean var087326F76FF21A482620141C52E3B799_821509800 = (getBooleanProperty(PROPERTY_PASSWORD));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_PASSWORD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.889 -0400", hash_original_method = "8EDA15203F993D6B021832D12354DB70", hash_generated_method = "A6F87287B66FABAF43017E574280B9A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPassword(boolean isPassword) {
        dsTaint.addTaint(isPassword);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_PASSWORD, isPassword);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_PASSWORD, isPassword);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.889 -0400", hash_original_method = "C1D751586747941BBE1AE366FE4E3AB5", hash_generated_method = "89EF5245CFCBA9E2C343D053A099B5BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFullScreen() {
        boolean var6C792059DAE3AE110DFF2A2C39B7D991_1255927642 = (getBooleanProperty(PROPERTY_FULL_SCREEN));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FULL_SCREEN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.889 -0400", hash_original_method = "8C2BD0FA889006F174A45F3038D20EAE", hash_generated_method = "A57FAB59D8ECC2355DFA789CE241EA52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFullScreen(boolean isFullScreen) {
        dsTaint.addTaint(isFullScreen);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_FULL_SCREEN, isFullScreen);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_FULL_SCREEN, isFullScreen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.889 -0400", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "D8C1ACE61F95AFACF59793C1D1F25076")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isScrollable() {
        boolean varCF570E94288645DBC38E8B422354A739_1156485223 = (getBooleanProperty(PROPERTY_SCROLLABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SCROLLABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.889 -0400", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "D8B810265087701C3DF7BB7DD56E5473")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScrollable(boolean scrollable) {
        dsTaint.addTaint(scrollable);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.890 -0400", hash_original_method = "5653D3A6C559AE9B846DF6E2B5CE39F8", hash_generated_method = "077EF421BD91323389CB38CF4DF8085C")
    @DSModeled(DSC.SAFE)
    public int getItemCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.890 -0400", hash_original_method = "F4CC562DD5B544AF052C8C7ADD17F3DB", hash_generated_method = "7076D06FBB35622A0886E4D1FA200BD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setItemCount(int itemCount) {
        dsTaint.addTaint(itemCount);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mItemCount = itemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.890 -0400", hash_original_method = "C835140CBE8B50DDD89D13B9DB62A1BF", hash_generated_method = "A924D2BA52C93DB9B749BC31EEBD3860")
    @DSModeled(DSC.SAFE)
    public int getCurrentItemIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCurrentItemIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.890 -0400", hash_original_method = "05A5E897DB8527242E13FEF032CE111F", hash_generated_method = "0E1B4FD83EACCD2CE19C0E821C088142")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCurrentItemIndex(int currentItemIndex) {
        dsTaint.addTaint(currentItemIndex);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mCurrentItemIndex = currentItemIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.890 -0400", hash_original_method = "67718C1B588EB57EF05CD90DC3F200D7", hash_generated_method = "4C9FF816498CF3B9207908F0AA1B5BBB")
    @DSModeled(DSC.SAFE)
    public int getFromIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFromIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.891 -0400", hash_original_method = "BBFD31D579F6E6D46645245CC5F2E354", hash_generated_method = "E0139FA65F184268F6D46CD501806C38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFromIndex(int fromIndex) {
        dsTaint.addTaint(fromIndex);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mFromIndex = fromIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.891 -0400", hash_original_method = "579D16111E248F454AD7B48F20E18451", hash_generated_method = "F94569BD7B0AF4D09EDB5B3999175BC8")
    @DSModeled(DSC.SAFE)
    public int getToIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mToIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.891 -0400", hash_original_method = "E568A8356EF0E74107283370C7553269", hash_generated_method = "2723F79CF460DDFB820A0A2EC04350FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setToIndex(int toIndex) {
        dsTaint.addTaint(toIndex);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mToIndex = toIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.891 -0400", hash_original_method = "37E422003D62C4BD4746E9CFAAF79E84", hash_generated_method = "F36C51F62AFFBB80FFBDA1D3E2976F6D")
    @DSModeled(DSC.SAFE)
    public int getScrollX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.891 -0400", hash_original_method = "39929F8426D84CFC2AAA2E35AFA69688", hash_generated_method = "76D1B0C1D0C9DD42D4B97B61F2D3D083")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScrollX(int scrollX) {
        dsTaint.addTaint(scrollX);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mScrollX = scrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.892 -0400", hash_original_method = "1E7AE64F8D32210A6E2C97F4869FB31A", hash_generated_method = "677812F9DB5DBD86220E4FDF8F7417C5")
    @DSModeled(DSC.SAFE)
    public int getScrollY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.892 -0400", hash_original_method = "3D3AC5EAAB87E771122FE10290862D68", hash_generated_method = "F415AB29069F8120DED9D3AD92FC99A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScrollY(int scrollY) {
        dsTaint.addTaint(scrollY);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mScrollY = scrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.892 -0400", hash_original_method = "C4A2F5E4142D8D5EA688446E7513363C", hash_generated_method = "6CDFCBB7D5CD1627500442B77FCE28EE")
    @DSModeled(DSC.SAFE)
    public int getMaxScrollX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaxScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.892 -0400", hash_original_method = "EE977B785E6D4A7CA733252D06CF32E9", hash_generated_method = "D26BFB528A92AE90BECF8D5DCE4833E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaxScrollX(int maxScrollX) {
        dsTaint.addTaint(maxScrollX);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mMaxScrollX = maxScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.893 -0400", hash_original_method = "A3ECA44A0D4150097FAA989997DF13C5", hash_generated_method = "AE5A8328E63FC19DE5690CA8A7E7E3F2")
    @DSModeled(DSC.SAFE)
    public int getMaxScrollY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaxScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.894 -0400", hash_original_method = "49077E92EA018330C2FB0B17E183D4A7", hash_generated_method = "2CF3DAEA4737A4E23C74CE376C7F4D4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaxScrollY(int maxScrollY) {
        dsTaint.addTaint(maxScrollY);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mMaxScrollY = maxScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.894 -0400", hash_original_method = "49E2E44D8419AC51B09A77AC8668D279", hash_generated_method = "EA2E11EE21565ABF6E22F43D3E74685F")
    @DSModeled(DSC.SAFE)
    public int getAddedCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAddedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.894 -0400", hash_original_method = "72BB1C08DFA71715A3D1B3E3C0F3D07A", hash_generated_method = "A18B0124EF22D646C50FD2CBE43E3020")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAddedCount(int addedCount) {
        dsTaint.addTaint(addedCount);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mAddedCount = addedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.894 -0400", hash_original_method = "EBD9E1156BBECE10FD62678D5B5AE958", hash_generated_method = "E8EE4BAF8AC558620476EB2AE0960F9E")
    @DSModeled(DSC.SAFE)
    public int getRemovedCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRemovedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.894 -0400", hash_original_method = "A6A70AD3A3D0C21790CD56D9B41496A2", hash_generated_method = "3E379DFBA69E9CAB68EF7472EA123902")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRemovedCount(int removedCount) {
        dsTaint.addTaint(removedCount);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mRemovedCount = removedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.895 -0400", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "92BAFB9E596A443858B6DBBAE4786BBD")
    @DSModeled(DSC.SAFE)
    public CharSequence getClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.895 -0400", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "B33515DF9F1ECF95475D2E8432869927")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setClassName(CharSequence className) {
        dsTaint.addTaint(className);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mClassName = className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.895 -0400", hash_original_method = "DC632160826FC3F04AF23253967928B9", hash_generated_method = "46492B0FEC7112510F1F0613278ECF2D")
    @DSModeled(DSC.SAFE)
    public List<CharSequence> getText() {
        return (List<CharSequence>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.895 -0400", hash_original_method = "FE2FD614296585A25D259709588FAD5E", hash_generated_method = "0A5C78D978AF6945792DAFDDE015CCAB")
    @DSModeled(DSC.SAFE)
    public CharSequence getBeforeText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mBeforeText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.895 -0400", hash_original_method = "D6F685CC2DDAD1DA7E7B88F32900AE37", hash_generated_method = "AFD009AA649AD2043E21E474C6DCF834")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBeforeText(CharSequence beforeText) {
        dsTaint.addTaint(beforeText);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBeforeText = beforeText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.895 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "9AEA7AC2805E6F06BD7FB29C1CE6CB3E")
    @DSModeled(DSC.SAFE)
    public CharSequence getContentDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mContentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.896 -0400", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "27B6A796EC9466494B8247B308B7B50B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentDescription(CharSequence contentDescription) {
        dsTaint.addTaint(contentDescription);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mContentDescription = contentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.896 -0400", hash_original_method = "336F04D02E102717408E8DD7ED329D8E", hash_generated_method = "D01364F668A88217A16FFA943765AC42")
    @DSModeled(DSC.SAFE)
    public Parcelable getParcelableData() {
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParcelableData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.896 -0400", hash_original_method = "1574FBF11672419A058C271D89F97C62", hash_generated_method = "EE0C4F7BEDDF12C239636460C41260E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParcelableData(Parcelable parcelableData) {
        dsTaint.addTaint(parcelableData.dsTaint);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mParcelableData = parcelableData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.896 -0400", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "106AC060BF8BA5C5BDEA27C0EA5A64E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setConnectionId(int connectionId) {
        dsTaint.addTaint(connectionId);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mConnectionId = connectionId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.896 -0400", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "8C1F70D90B9EE6D4B4AAA6944A3DDD0A")
    @DSModeled(DSC.SAFE)
    public void setSealed(boolean sealed) {
        dsTaint.addTaint(sealed);
        // ---------- Original Method ----------
        //mSealed = sealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.896 -0400", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "72F194FE253BBFF9058DAC6ED476D758")
    @DSModeled(DSC.SAFE)
     boolean isSealed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.896 -0400", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "E5D1035B5DF35E10BFFA5F83EBA3C3DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void enforceSealed() {
        {
            boolean varD513186271CF3A3D5E081DE87E878208_464004692 = (!isSealed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot perform this "
                    + "action on a not sealed instance.");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isSealed()) {
            //throw new IllegalStateException("Cannot perform this "
                    //+ "action on a not sealed instance.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.897 -0400", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "EA2485C2C22876F38C6BF619D0EBA035")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void enforceNotSealed() {
        {
            boolean varA822B3442F37011C427DDD3B23C1201F_1509047265 = (isSealed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot perform this "
                    + "action on an sealed instance.");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isSealed()) {
            //throw new IllegalStateException("Cannot perform this "
                    //+ "action on an sealed instance.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.897 -0400", hash_original_method = "4FB14FE7E8FA7F40071202FB709EF8E4", hash_generated_method = "699C37C721C8462C8D4195AD2FA66E44")
    @DSModeled(DSC.SAFE)
    private boolean getBooleanProperty(int property) {
        dsTaint.addTaint(property);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mBooleanProperties & property) == property;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.897 -0400", hash_original_method = "1E3C58B2EEBD5BD671884B4ADC3ACB2F", hash_generated_method = "30D4BC8DE13362A7320F7D06F2AA6B30")
    @DSModeled(DSC.SAFE)
    private void setBooleanProperty(int property, boolean value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(property);
        {
            mBooleanProperties &= ~property;
        } //End block
        // ---------- Original Method ----------
        //if (value) {
            //mBooleanProperties |= property;
        //} else {
            //mBooleanProperties &= ~property;
        //}
    }

    
        public static AccessibilityRecord obtain(AccessibilityRecord record) {
        AccessibilityRecord clone = AccessibilityRecord.obtain();
        clone.init(record);
        return clone;
    }

    
        public static AccessibilityRecord obtain() {
        synchronized (sPoolLock) {
            if (sPool != null) {
                AccessibilityRecord record = sPool;
                sPool = sPool.mNext;
                sPoolSize--;
                record.mNext = null;
                record.mIsInPool = false;
                return record;
            }
            return new AccessibilityRecord();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.897 -0400", hash_original_method = "0FDD4277FFE3E2F2D99D4BAB0780A409", hash_generated_method = "E3B0E38298882DBC3E1301C60F0666D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void recycle() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Record already recycled!");
        } //End block
        clear();
        {
            {
                mNext = sPool;
                sPool = this;
                mIsInPool = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mIsInPool) {
            //throw new IllegalStateException("Record already recycled!");
        //}
        //clear();
        //synchronized (sPoolLock) {
            //if (sPoolSize <= MAX_POOL_SIZE) {
                //mNext = sPool;
                //sPool = this;
                //mIsInPool = true;
                //sPoolSize++;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.898 -0400", hash_original_method = "EC9B4AFBEF6A967243E7EC5889FB4591", hash_generated_method = "B7979EB5352DF3BC5408501F619F632D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void init(AccessibilityRecord record) {
        dsTaint.addTaint(record.dsTaint);
        mSealed = record.mSealed;
        mBooleanProperties = record.mBooleanProperties;
        mCurrentItemIndex = record.mCurrentItemIndex;
        mItemCount = record.mItemCount;
        mFromIndex = record.mFromIndex;
        mToIndex = record.mToIndex;
        mScrollX = record.mScrollX;
        mScrollY = record.mScrollY;
        mMaxScrollX = record.mMaxScrollX;
        mMaxScrollY = record.mMaxScrollY;
        mAddedCount = record.mAddedCount;
        mRemovedCount = record.mRemovedCount;
        mClassName = record.mClassName;
        mContentDescription = record.mContentDescription;
        mBeforeText = record.mBeforeText;
        mParcelableData = record.mParcelableData;
        mText.addAll(record.mText);
        mSourceWindowId = record.mSourceWindowId;
        mSourceViewId = record.mSourceViewId;
        mConnectionId = record.mConnectionId;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.898 -0400", hash_original_method = "F6BD36F7AA33E2CDDBD8ECFA17198BE9", hash_generated_method = "600B4D1FB38108C343C4EA3361FB0CDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clear() {
        mSealed = false;
        mBooleanProperties = 0;
        mCurrentItemIndex = UNDEFINED;
        mItemCount = UNDEFINED;
        mFromIndex = UNDEFINED;
        mToIndex = UNDEFINED;
        mScrollX = UNDEFINED;
        mScrollY = UNDEFINED;
        mMaxScrollX = UNDEFINED;
        mMaxScrollY = UNDEFINED;
        mAddedCount = UNDEFINED;
        mRemovedCount = UNDEFINED;
        mClassName = null;
        mContentDescription = null;
        mBeforeText = null;
        mParcelableData = null;
        mText.clear();
        mSourceViewId = UNDEFINED;
        mSourceWindowId = UNDEFINED;
        mConnectionId = UNDEFINED;
        // ---------- Original Method ----------
        //mSealed = false;
        //mBooleanProperties = 0;
        //mCurrentItemIndex = UNDEFINED;
        //mItemCount = UNDEFINED;
        //mFromIndex = UNDEFINED;
        //mToIndex = UNDEFINED;
        //mScrollX = UNDEFINED;
        //mScrollY = UNDEFINED;
        //mMaxScrollX = UNDEFINED;
        //mMaxScrollY = UNDEFINED;
        //mAddedCount = UNDEFINED;
        //mRemovedCount = UNDEFINED;
        //mClassName = null;
        //mContentDescription = null;
        //mBeforeText = null;
        //mParcelableData = null;
        //mText.clear();
        //mSourceViewId = UNDEFINED;
        //mSourceWindowId = UNDEFINED;
        //mConnectionId = UNDEFINED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.899 -0400", hash_original_method = "6984D5C42FE7046E0FC00D15FC78323D", hash_generated_method = "133FAFCE84E3CDB5A0B4604CA84420C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append(" [ ClassName: " + mClassName);
        builder.append("; Text: " + mText);
        builder.append("; ContentDescription: " + mContentDescription);
        builder.append("; ItemCount: " + mItemCount);
        builder.append("; CurrentItemIndex: " + mCurrentItemIndex);
        builder.append("; IsEnabled: " + getBooleanProperty(PROPERTY_ENABLED));
        builder.append("; IsPassword: " + getBooleanProperty(PROPERTY_PASSWORD));
        builder.append("; IsChecked: " + getBooleanProperty(PROPERTY_CHECKED));
        builder.append("; IsFullScreen: " + getBooleanProperty(PROPERTY_FULL_SCREEN));
        builder.append("; Scrollable: " + getBooleanProperty(PROPERTY_SCROLLABLE));
        builder.append("; BeforeText: " + mBeforeText);
        builder.append("; FromIndex: " + mFromIndex);
        builder.append("; ToIndex: " + mToIndex);
        builder.append("; ScrollX: " + mScrollX);
        builder.append("; ScrollY: " + mScrollY);
        builder.append("; MaxScrollX: " + mMaxScrollX);
        builder.append("; MaxScrollY: " + mMaxScrollY);
        builder.append("; AddedCount: " + mAddedCount);
        builder.append("; RemovedCount: " + mRemovedCount);
        builder.append("; ParcelableData: " + mParcelableData);
        builder.append(" ]");
        String var687AAF24B90629C9BFCFE9608FDCE6E7_1403269876 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final int UNDEFINED = -1;
    private static final int PROPERTY_CHECKED = 0x00000001;
    private static final int PROPERTY_ENABLED = 0x00000002;
    private static final int PROPERTY_PASSWORD = 0x00000004;
    private static final int PROPERTY_FULL_SCREEN = 0x00000080;
    private static final int PROPERTY_SCROLLABLE = 0x00000100;
    private static final int MAX_POOL_SIZE = 10;
    private static final Object sPoolLock = new Object();
    private static AccessibilityRecord sPool;
    private static int sPoolSize;
}

