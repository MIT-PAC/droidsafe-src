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
    private static int UNDEFINED = -1;
    private static int PROPERTY_CHECKED = 0x00000001;
    private static int PROPERTY_ENABLED = 0x00000002;
    private static int PROPERTY_PASSWORD = 0x00000004;
    private static int PROPERTY_FULL_SCREEN = 0x00000080;
    private static int PROPERTY_SCROLLABLE = 0x00000100;
    private static int MAX_POOL_SIZE = 10;
    private static Object sPoolLock = new Object();
    private static AccessibilityRecord sPool;
    private static int sPoolSize;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:57.940 -0400", hash_original_method = "47B5C6FFA7A08624EFFE67BFFC3F0DF4", hash_generated_method = "AE66FFCD837E967ACB14FC0D7C52BE4D")
    @DSModeled(DSC.SAFE)
     AccessibilityRecord() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:57.955 -0400", hash_original_method = "948A1D8CF51CA12DCE9E50B8B6FDE838", hash_generated_method = "604FC8CB2A60A2FAC392F9AE6270C090")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:57.975 -0400", hash_original_method = "D6229F18D386359B7D2ED64A724CE545", hash_generated_method = "EED110E637A426AB3C4E2B491992DF0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityNodeInfo getSource() {
        enforceSealed();
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        AccessibilityNodeInfo var7DA618B898F7B8D2FCA7873B64F0C97D_889916285 = (client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId, mSourceWindowId,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:57.986 -0400", hash_original_method = "0167B817243C7300A3E7B07356FC6F77", hash_generated_method = "4D689A99D9641C33A36456C5A9D3AF94")
    @DSModeled(DSC.SAFE)
    public int getWindowId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSourceWindowId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:57.993 -0400", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "B790E4B2A7354D7D21B5F6BF7F92CF36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isChecked() {
        boolean var452C23D949DE68DF158EF7F75ABFD98B_726417645 = (getBooleanProperty(PROPERTY_CHECKED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.008 -0400", hash_original_method = "EF363FCE51C9C9A497BD6E689D39B09F", hash_generated_method = "DFAD6A3CF71B576D5A0CAAA69DC760F3")
    @DSModeled(DSC.SAFE)
    public void setChecked(boolean isChecked) {
        dsTaint.addTaint(isChecked);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_CHECKED, isChecked);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_CHECKED, isChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.014 -0400", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "DEC5A1F96A50EA1F81F4B88A944E9826")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEnabled() {
        boolean var8448E9D671258D44185D3F547D298C9D_2093812373 = (getBooleanProperty(PROPERTY_ENABLED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.022 -0400", hash_original_method = "0EAAA686E8658459FDC66C98C4B45340", hash_generated_method = "FC5731939216F7F32D0279BB917D738E")
    @DSModeled(DSC.SAFE)
    public void setEnabled(boolean isEnabled) {
        dsTaint.addTaint(isEnabled);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_ENABLED, isEnabled);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_ENABLED, isEnabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.031 -0400", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "1167ADABAD9FA3F176C21F36EE6B4E7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPassword() {
        boolean var087326F76FF21A482620141C52E3B799_255146258 = (getBooleanProperty(PROPERTY_PASSWORD));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_PASSWORD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.037 -0400", hash_original_method = "8EDA15203F993D6B021832D12354DB70", hash_generated_method = "BD3F3DCFD036BB23FB8D3E16174175BE")
    @DSModeled(DSC.SAFE)
    public void setPassword(boolean isPassword) {
        dsTaint.addTaint(isPassword);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_PASSWORD, isPassword);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_PASSWORD, isPassword);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.042 -0400", hash_original_method = "C1D751586747941BBE1AE366FE4E3AB5", hash_generated_method = "CBC4CD8217224E2F7E366428284AE899")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFullScreen() {
        boolean var6C792059DAE3AE110DFF2A2C39B7D991_900907995 = (getBooleanProperty(PROPERTY_FULL_SCREEN));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FULL_SCREEN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.048 -0400", hash_original_method = "8C2BD0FA889006F174A45F3038D20EAE", hash_generated_method = "8806B7E720EEAC0713836069FF1D269F")
    @DSModeled(DSC.SAFE)
    public void setFullScreen(boolean isFullScreen) {
        dsTaint.addTaint(isFullScreen);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_FULL_SCREEN, isFullScreen);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_FULL_SCREEN, isFullScreen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.054 -0400", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "B2D8A1BD2F8214D4705CED1B78FAC6AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isScrollable() {
        boolean varCF570E94288645DBC38E8B422354A739_1919273434 = (getBooleanProperty(PROPERTY_SCROLLABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SCROLLABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.064 -0400", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "0850F71CA259FACEE144F98ECE7B78BC")
    @DSModeled(DSC.SAFE)
    public void setScrollable(boolean scrollable) {
        dsTaint.addTaint(scrollable);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.074 -0400", hash_original_method = "5653D3A6C559AE9B846DF6E2B5CE39F8", hash_generated_method = "410E198342767BAB3D319A2FC8C49834")
    @DSModeled(DSC.SAFE)
    public int getItemCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.084 -0400", hash_original_method = "F4CC562DD5B544AF052C8C7ADD17F3DB", hash_generated_method = "E9AA6345E568EC50816532B7C04F3F3B")
    @DSModeled(DSC.SAFE)
    public void setItemCount(int itemCount) {
        dsTaint.addTaint(itemCount);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mItemCount = itemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.089 -0400", hash_original_method = "C835140CBE8B50DDD89D13B9DB62A1BF", hash_generated_method = "28590F706F30A2BEDDCFFDBEE7D4B9E4")
    @DSModeled(DSC.SAFE)
    public int getCurrentItemIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCurrentItemIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.109 -0400", hash_original_method = "05A5E897DB8527242E13FEF032CE111F", hash_generated_method = "07A631977D0333743155EDD5B64C0CD8")
    @DSModeled(DSC.SAFE)
    public void setCurrentItemIndex(int currentItemIndex) {
        dsTaint.addTaint(currentItemIndex);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mCurrentItemIndex = currentItemIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.115 -0400", hash_original_method = "67718C1B588EB57EF05CD90DC3F200D7", hash_generated_method = "CFA13E3D93BB24CC7CA6584ED2AB332E")
    @DSModeled(DSC.SAFE)
    public int getFromIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFromIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.120 -0400", hash_original_method = "BBFD31D579F6E6D46645245CC5F2E354", hash_generated_method = "3BE7C1159EA33E2684EE8A3FD2F2E14F")
    @DSModeled(DSC.SAFE)
    public void setFromIndex(int fromIndex) {
        dsTaint.addTaint(fromIndex);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mFromIndex = fromIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.127 -0400", hash_original_method = "579D16111E248F454AD7B48F20E18451", hash_generated_method = "2A93E74392C4E40D3A33B0EB065C04C9")
    @DSModeled(DSC.SAFE)
    public int getToIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mToIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.148 -0400", hash_original_method = "E568A8356EF0E74107283370C7553269", hash_generated_method = "27C2BDBE5D448DCDB25A2E663413B6A6")
    @DSModeled(DSC.SAFE)
    public void setToIndex(int toIndex) {
        dsTaint.addTaint(toIndex);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mToIndex = toIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.151 -0400", hash_original_method = "37E422003D62C4BD4746E9CFAAF79E84", hash_generated_method = "A96BDE8BCB61E7C750771BD1DC73C3E1")
    @DSModeled(DSC.SAFE)
    public int getScrollX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.156 -0400", hash_original_method = "39929F8426D84CFC2AAA2E35AFA69688", hash_generated_method = "DF95D82D638F59F1743028485A3F7749")
    @DSModeled(DSC.SAFE)
    public void setScrollX(int scrollX) {
        dsTaint.addTaint(scrollX);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mScrollX = scrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.160 -0400", hash_original_method = "1E7AE64F8D32210A6E2C97F4869FB31A", hash_generated_method = "79E5410CEFC73EF50840CB23B17CBFE7")
    @DSModeled(DSC.SAFE)
    public int getScrollY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.165 -0400", hash_original_method = "3D3AC5EAAB87E771122FE10290862D68", hash_generated_method = "C6AC1EE6AD9BCA4CB05283F5CEA54D42")
    @DSModeled(DSC.SAFE)
    public void setScrollY(int scrollY) {
        dsTaint.addTaint(scrollY);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mScrollY = scrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.169 -0400", hash_original_method = "C4A2F5E4142D8D5EA688446E7513363C", hash_generated_method = "5582D466EFA96A527D79F76BB7CFB0A7")
    @DSModeled(DSC.SAFE)
    public int getMaxScrollX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaxScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.177 -0400", hash_original_method = "EE977B785E6D4A7CA733252D06CF32E9", hash_generated_method = "19D05835EDC3E7C784F8E71A195DDB53")
    @DSModeled(DSC.SAFE)
    public void setMaxScrollX(int maxScrollX) {
        dsTaint.addTaint(maxScrollX);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mMaxScrollX = maxScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.181 -0400", hash_original_method = "A3ECA44A0D4150097FAA989997DF13C5", hash_generated_method = "7191134A1EE87F66817727381E2DF1FF")
    @DSModeled(DSC.SAFE)
    public int getMaxScrollY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaxScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.186 -0400", hash_original_method = "49077E92EA018330C2FB0B17E183D4A7", hash_generated_method = "F2849D5BC8B147CB6786CBC118586A4B")
    @DSModeled(DSC.SAFE)
    public void setMaxScrollY(int maxScrollY) {
        dsTaint.addTaint(maxScrollY);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mMaxScrollY = maxScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.189 -0400", hash_original_method = "49E2E44D8419AC51B09A77AC8668D279", hash_generated_method = "BF6852D8067237B29D808EEA753B818D")
    @DSModeled(DSC.SAFE)
    public int getAddedCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAddedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.194 -0400", hash_original_method = "72BB1C08DFA71715A3D1B3E3C0F3D07A", hash_generated_method = "58580431E50FE2251426FDF9C0C4A2B5")
    @DSModeled(DSC.SAFE)
    public void setAddedCount(int addedCount) {
        dsTaint.addTaint(addedCount);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mAddedCount = addedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.198 -0400", hash_original_method = "EBD9E1156BBECE10FD62678D5B5AE958", hash_generated_method = "04054DC343F1A6C99DED7892AD5CAD2C")
    @DSModeled(DSC.SAFE)
    public int getRemovedCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRemovedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.203 -0400", hash_original_method = "A6A70AD3A3D0C21790CD56D9B41496A2", hash_generated_method = "995748DDCD01448E42C2F7DC69BC120B")
    @DSModeled(DSC.SAFE)
    public void setRemovedCount(int removedCount) {
        dsTaint.addTaint(removedCount);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mRemovedCount = removedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.206 -0400", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "12CE1D95578FBA95E1F895EE94145459")
    @DSModeled(DSC.SAFE)
    public CharSequence getClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.211 -0400", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "2C46E507B75E23042E778D4AE2B45B7E")
    @DSModeled(DSC.SAFE)
    public void setClassName(CharSequence className) {
        dsTaint.addTaint(className);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mClassName = className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.218 -0400", hash_original_method = "DC632160826FC3F04AF23253967928B9", hash_generated_method = "B23FCE40747A25A2A7F055AAA4E7CC8F")
    @DSModeled(DSC.SAFE)
    public List<CharSequence> getText() {
        return (List<CharSequence>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.221 -0400", hash_original_method = "FE2FD614296585A25D259709588FAD5E", hash_generated_method = "1174CC241E011A61A8AEE20E07324235")
    @DSModeled(DSC.SAFE)
    public CharSequence getBeforeText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mBeforeText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.226 -0400", hash_original_method = "D6F685CC2DDAD1DA7E7B88F32900AE37", hash_generated_method = "7F81BFA984E4168561F8CB72779843C0")
    @DSModeled(DSC.SAFE)
    public void setBeforeText(CharSequence beforeText) {
        dsTaint.addTaint(beforeText);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBeforeText = beforeText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.237 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "BA259797571A91EE13C632E0DC69BD69")
    @DSModeled(DSC.SAFE)
    public CharSequence getContentDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mContentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.243 -0400", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "29AD0327AF051099033CDEE322133B3F")
    @DSModeled(DSC.SAFE)
    public void setContentDescription(CharSequence contentDescription) {
        dsTaint.addTaint(contentDescription);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mContentDescription = contentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.247 -0400", hash_original_method = "336F04D02E102717408E8DD7ED329D8E", hash_generated_method = "5AEE8233115BDB3409D99B38998833CA")
    @DSModeled(DSC.SAFE)
    public Parcelable getParcelableData() {
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParcelableData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.252 -0400", hash_original_method = "1574FBF11672419A058C271D89F97C62", hash_generated_method = "8EA40882E12623A25AFA01254BC9D13A")
    @DSModeled(DSC.SAFE)
    public void setParcelableData(Parcelable parcelableData) {
        dsTaint.addTaint(parcelableData.dsTaint);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mParcelableData = parcelableData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.256 -0400", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "87868CC6B164ACB8CE0AE855BAB59D61")
    @DSModeled(DSC.SAFE)
    public void setConnectionId(int connectionId) {
        dsTaint.addTaint(connectionId);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mConnectionId = connectionId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.260 -0400", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "8165B32CA8C940B710DEA5069E3A1731")
    @DSModeled(DSC.SAFE)
    public void setSealed(boolean sealed) {
        dsTaint.addTaint(sealed);
        // ---------- Original Method ----------
        //mSealed = sealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.264 -0400", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "828032B3E1CE17EE738C4463AF96053F")
    @DSModeled(DSC.SAFE)
     boolean isSealed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.268 -0400", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "E068477E381E00835B94FDA9DDE0C9BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void enforceSealed() {
        {
            boolean varD513186271CF3A3D5E081DE87E878208_52370460 = (!isSealed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.272 -0400", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "A4ECECC224AFD3146764E8460B3AE8AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void enforceNotSealed() {
        {
            boolean varA822B3442F37011C427DDD3B23C1201F_773757531 = (isSealed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.277 -0400", hash_original_method = "4FB14FE7E8FA7F40071202FB709EF8E4", hash_generated_method = "445FDB2FA182453B7B4C195F04F1753A")
    @DSModeled(DSC.SAFE)
    private boolean getBooleanProperty(int property) {
        dsTaint.addTaint(property);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mBooleanProperties & property) == property;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.283 -0400", hash_original_method = "1E3C58B2EEBD5BD671884B4ADC3ACB2F", hash_generated_method = "557336CCF08BEBA954A3FE05B8EB2ACD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.290 -0400", hash_original_method = "2CFD6EBEFF813BB567E469C3740E6AAE", hash_generated_method = "832DDE9481661F774B1DBC74C9B1C36D")
    public static AccessibilityRecord obtain(AccessibilityRecord record) {
        AccessibilityRecord clone = AccessibilityRecord.obtain();
        clone.init(record);
        return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.293 -0400", hash_original_method = "F52296A1A788DF4272F6650232B88A31", hash_generated_method = "60B1C824D4E6E3CA5E531FDBE67AE447")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.300 -0400", hash_original_method = "0FDD4277FFE3E2F2D99D4BAB0780A409", hash_generated_method = "4237D3A49392E74C7D2D8B384C75EC0A")
    @DSModeled(DSC.SAFE)
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
                sPoolSize++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.317 -0400", hash_original_method = "EC9B4AFBEF6A967243E7EC5889FB4591", hash_generated_method = "45814C37FCCB363111AF4579C022794C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.330 -0400", hash_original_method = "F6BD36F7AA33E2CDDBD8ECFA17198BE9", hash_generated_method = "A63E9610042BE3F775BDBEE817FE6E28")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:23:58.353 -0400", hash_original_method = "6984D5C42FE7046E0FC00D15FC78323D", hash_generated_method = "94A98956A48C475C64FD85885298DEF2")
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
        String var687AAF24B90629C9BFCFE9608FDCE6E7_312290234 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


