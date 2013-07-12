package android.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityRecord {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "819E660F8F7271EBD249CE0B621A6CFF")

    private AccessibilityRecord mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "B94200C48C7563C1FA86222302A87F95", hash_generated_field = "12FC58788D16ADAE0F5394F898FD4D99")

    private boolean mIsInPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "61DB78BD493651DCACB5FB89D74B835B", hash_generated_field = "4B6C132CC4E1DABC021AFE92BC996668")

    boolean mSealed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "ED189995ED191C4589F06A64BF0FDC1E", hash_generated_field = "16EB928A608E490EDABD6C313699F6E2")

    int mBooleanProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "6FC9E35F3B461C2AB815F1E74909AB74", hash_generated_field = "61B6204A7C251AA3D27E9B50A9355A30")

    int mCurrentItemIndex = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "FCEDF646E8D09C460F2CCD9149618B7F", hash_generated_field = "F76D3264C191AE325187C60C1ABBC344")

    int mItemCount = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "E8DE381698608B73A16DD8D4A6221B8A", hash_generated_field = "EF145018DE8E629EE83018E54FFFED11")

    int mFromIndex = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "59A3DFB0D8439F689AF183C3AFCF6E6D", hash_generated_field = "51A8B4D9E0617CE3451D67583416EB43")

    int mToIndex = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "E37A685408290AEE3440FEEB511CFFC2", hash_generated_field = "72E164DE5C696E5476091A9DD43D6C8D")

    int mScrollX = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "AF8920A6914CAF7B59573D1EA96D84D4", hash_generated_field = "53E5DA241F46897B4A82791606381914")

    int mScrollY = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "FB4DA30E56CA7C84DEC95D6B31F790CE", hash_generated_field = "8B3E5A0AFE1301DC07049E45EAB257E2")

    int mMaxScrollX = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "731FDD0D49EB1631EB16352CD5DA8E25", hash_generated_field = "8B1EEF0BAF8B84D80086BC17A2C41C6C")

    int mMaxScrollY = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "CE5889B119B9D7A1D5FA8A750F2418CB", hash_generated_field = "D24F8B9BED9E4999FEFD1D6BDD0A4524")

    int mAddedCount = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "FF2342BAE899D71AD563D8FFE11D610A", hash_generated_field = "A726B2E71548B632DFBFAFCC74F6ADEA")

    int mRemovedCount = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.287 -0400", hash_original_field = "214C99E3A67E2DCCA15F1A7872516260", hash_generated_field = "3B1E05A74215A57B8C30C232B3E92D50")

    int mSourceViewId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.288 -0400", hash_original_field = "CC544EBF7996F79C6A0EFEAC592FA4E9", hash_generated_field = "831206FA2F666A93060BCB2DBBE12AE5")

    int mSourceWindowId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.288 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "607E22FB74B4A9750077B62E99C7097B")

    CharSequence mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.288 -0400", hash_original_field = "073D0187C9F61FAD4E5B0B851BDDC2B3", hash_generated_field = "1D344C00C8D6A0BCC2A3B840B08C53BD")

    CharSequence mContentDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.288 -0400", hash_original_field = "8F45542597C289D2929CD8F63821BE5A", hash_generated_field = "6FED3330A012BA7D2A27B5EF6045F2F0")

    CharSequence mBeforeText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.288 -0400", hash_original_field = "2A709DDD372D330C1BAA3EF44C00D074", hash_generated_field = "4C8F8687F0917167B5FF9B39C6545ED3")

    Parcelable mParcelableData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.288 -0400", hash_original_field = "635946FFFF3DBBC2187F69B62B4F0623", hash_generated_field = "868BA7C98D63B508230C0EC76DFD4DD7")

    final List<CharSequence> mText = new ArrayList<CharSequence>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.288 -0400", hash_original_field = "8EAF73743CC459D107527502BC394C97", hash_generated_field = "8B5A4110581AEE7B543A400E2F63419C")

    int mConnectionId = UNDEFINED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.288 -0400", hash_original_method = "47B5C6FFA7A08624EFFE67BFFC3F0DF4", hash_generated_method = "49EEADD37CBD0DA6FCCFEC65E1335A11")
      AccessibilityRecord() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.289 -0400", hash_original_method = "948A1D8CF51CA12DCE9E50B8B6FDE838", hash_generated_method = "7884B3EC4543596D2EECC9FE6DF3310A")
    public void setSource(View source) {
        enforceNotSealed();
    if(source != null)        
        {
            mSourceWindowId = source.getAccessibilityWindowId();
            mSourceViewId = source.getAccessibilityViewId();
        } 
        else
        {
            mSourceWindowId = UNDEFINED;
            mSourceViewId = UNDEFINED;
        } 
        
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.289 -0400", hash_original_method = "D6229F18D386359B7D2ED64A724CE545", hash_generated_method = "5FD7AA8BCC62539F57175F4C3ED799B8")
    public AccessibilityNodeInfo getSource() {
        enforceSealed();
    if(mConnectionId == UNDEFINED || mSourceWindowId == UNDEFINED
                || mSourceViewId == UNDEFINED)        
        {
AccessibilityNodeInfo var540C13E9E156B687226421B24F2DF178_1608262043 =             null;
            var540C13E9E156B687226421B24F2DF178_1608262043.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1608262043;
        } 
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
AccessibilityNodeInfo var621B0621CDB78401249870185393BC57_1174779756 =         client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId, mSourceWindowId,
                mSourceViewId);
        var621B0621CDB78401249870185393BC57_1174779756.addTaint(taint);
        return var621B0621CDB78401249870185393BC57_1174779756;
        
        
        
                
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.290 -0400", hash_original_method = "0167B817243C7300A3E7B07356FC6F77", hash_generated_method = "C7F5F455B60851F9C1D000268CB89ABC")
    public int getWindowId() {
        int varC9AE2C28DB057C703A59EF81BFE5FA78_516421763 = (mSourceWindowId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_12684840 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_12684840;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.290 -0400", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "30EF1FCC92729FB62A2DD807B622C6B6")
    public boolean isChecked() {
        boolean var6A0CD5272E311D05E98BCF36FBF20ACD_77914733 = (getBooleanProperty(PROPERTY_CHECKED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1770302013 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1770302013;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.291 -0400", hash_original_method = "EF363FCE51C9C9A497BD6E689D39B09F", hash_generated_method = "5EB45A776185527F2588B31EFF529188")
    public void setChecked(boolean isChecked) {
        addTaint(isChecked);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_CHECKED, isChecked);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.291 -0400", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "DE802ED4B0220DED653A6F720325C8C6")
    public boolean isEnabled() {
        boolean var6F818D4AF1185DC3F7931FBEF22B2D47_112812443 = (getBooleanProperty(PROPERTY_ENABLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2133487692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2133487692;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.291 -0400", hash_original_method = "0EAAA686E8658459FDC66C98C4B45340", hash_generated_method = "1BEFE9C5C829189C2A37C3273E9F9570")
    public void setEnabled(boolean isEnabled) {
        addTaint(isEnabled);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_ENABLED, isEnabled);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.292 -0400", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "77C5001BF3E0032D1B93CB147D6669F0")
    public boolean isPassword() {
        boolean varC159D45C2E73AC687CB90727F00FD786_204758894 = (getBooleanProperty(PROPERTY_PASSWORD));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659671592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659671592;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.292 -0400", hash_original_method = "8EDA15203F993D6B021832D12354DB70", hash_generated_method = "C7AF001103A7B4696830B695D07B86B4")
    public void setPassword(boolean isPassword) {
        addTaint(isPassword);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_PASSWORD, isPassword);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.292 -0400", hash_original_method = "C1D751586747941BBE1AE366FE4E3AB5", hash_generated_method = "6DD55BDE1726E70F705A60A5E962325B")
    public boolean isFullScreen() {
        boolean var20B7A22B6E97B858868FA1BE6F19CD37_1359077074 = (getBooleanProperty(PROPERTY_FULL_SCREEN));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_262128896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_262128896;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.293 -0400", hash_original_method = "8C2BD0FA889006F174A45F3038D20EAE", hash_generated_method = "8DAA2D61D06378E836D54A7C935B1BFB")
    public void setFullScreen(boolean isFullScreen) {
        addTaint(isFullScreen);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_FULL_SCREEN, isFullScreen);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.293 -0400", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "7D3EDF0C24E94A4943C5C5ED6212E613")
    public boolean isScrollable() {
        boolean varA6FFE50E93EDBB77B0E8F1D4016517C5_1657279086 = (getBooleanProperty(PROPERTY_SCROLLABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316940153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316940153;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.293 -0400", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "EAEA71709D852AD68EE8493BBFF49557")
    public void setScrollable(boolean scrollable) {
        addTaint(scrollable);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.293 -0400", hash_original_method = "5653D3A6C559AE9B846DF6E2B5CE39F8", hash_generated_method = "E7A6903216273FBF54DE16CD1B450C67")
    public int getItemCount() {
        int varA7392E7FB156CE90DBA601C30BDAD9A0_1719842523 = (mItemCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833015390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833015390;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.294 -0400", hash_original_method = "F4CC562DD5B544AF052C8C7ADD17F3DB", hash_generated_method = "39F44303466A5C8F7F39F778FFDDD0CE")
    public void setItemCount(int itemCount) {
        enforceNotSealed();
        mItemCount = itemCount;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.294 -0400", hash_original_method = "C835140CBE8B50DDD89D13B9DB62A1BF", hash_generated_method = "0AFC4BF852651ABBDB9D1D88D6B35395")
    public int getCurrentItemIndex() {
        int var489E1BE47B1553BA23654F484D8112C8_1366834136 = (mCurrentItemIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080257466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080257466;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.295 -0400", hash_original_method = "05A5E897DB8527242E13FEF032CE111F", hash_generated_method = "19B5132C68FB734C1499EBDF515D3B3D")
    public void setCurrentItemIndex(int currentItemIndex) {
        enforceNotSealed();
        mCurrentItemIndex = currentItemIndex;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.295 -0400", hash_original_method = "67718C1B588EB57EF05CD90DC3F200D7", hash_generated_method = "21A4792D98436D15C2FBC9F702A93FD7")
    public int getFromIndex() {
        int varCB7DD4A683E75326E3BF4E3710D5827C_1692571490 = (mFromIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922651533 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922651533;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.328 -0400", hash_original_method = "BBFD31D579F6E6D46645245CC5F2E354", hash_generated_method = "36496D5056D8AB0FE7C2BEDCB6F05346")
    public void setFromIndex(int fromIndex) {
        enforceNotSealed();
        mFromIndex = fromIndex;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.328 -0400", hash_original_method = "579D16111E248F454AD7B48F20E18451", hash_generated_method = "16B78B1D8012236C188D9125A8313505")
    public int getToIndex() {
        int var30B0FE5CDEB065565B0FD203973CA877_402901844 = (mToIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660184686 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660184686;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.328 -0400", hash_original_method = "E568A8356EF0E74107283370C7553269", hash_generated_method = "FDAB56CA01587F7337EEE204C7CAA2F3")
    public void setToIndex(int toIndex) {
        enforceNotSealed();
        mToIndex = toIndex;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.328 -0400", hash_original_method = "37E422003D62C4BD4746E9CFAAF79E84", hash_generated_method = "F3524D6B77CD6F174AC22AFC30CCB78A")
    public int getScrollX() {
        int var9DC8F9676E14E93147EBEA37CE364B55_925578323 = (mScrollX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316692831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316692831;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.329 -0400", hash_original_method = "39929F8426D84CFC2AAA2E35AFA69688", hash_generated_method = "C87434146081ADE968226CDF7649BD4F")
    public void setScrollX(int scrollX) {
        enforceNotSealed();
        mScrollX = scrollX;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.329 -0400", hash_original_method = "1E7AE64F8D32210A6E2C97F4869FB31A", hash_generated_method = "B000ABE021696B43073B73C4F50F47F6")
    public int getScrollY() {
        int var4ABBFD585ECE4FE40BECD8E0C30C4E5E_827535923 = (mScrollY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111771598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111771598;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.329 -0400", hash_original_method = "3D3AC5EAAB87E771122FE10290862D68", hash_generated_method = "24692C5BE0019BBEB295B48727960D47")
    public void setScrollY(int scrollY) {
        enforceNotSealed();
        mScrollY = scrollY;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.329 -0400", hash_original_method = "C4A2F5E4142D8D5EA688446E7513363C", hash_generated_method = "AF623E5D1861D1573E9041781BA2CC3A")
    public int getMaxScrollX() {
        int varC00A0F4C697A08175EC089AD320E18B8_264582708 = (mMaxScrollX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558111361 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558111361;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.329 -0400", hash_original_method = "EE977B785E6D4A7CA733252D06CF32E9", hash_generated_method = "33A6260074AAD8E975DFFFE9A91EDE8C")
    public void setMaxScrollX(int maxScrollX) {
        enforceNotSealed();
        mMaxScrollX = maxScrollX;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.329 -0400", hash_original_method = "A3ECA44A0D4150097FAA989997DF13C5", hash_generated_method = "C7B7239AC834082F56FB370B11362875")
    public int getMaxScrollY() {
        int var4DF13F6FEC2D0410B23C6B671B7C8F76_877357441 = (mMaxScrollY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21972183 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21972183;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.330 -0400", hash_original_method = "49077E92EA018330C2FB0B17E183D4A7", hash_generated_method = "078D9BF7E9E30261FD815908FC98FAD6")
    public void setMaxScrollY(int maxScrollY) {
        enforceNotSealed();
        mMaxScrollY = maxScrollY;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.330 -0400", hash_original_method = "49E2E44D8419AC51B09A77AC8668D279", hash_generated_method = "84CA8BCC800DAFA3E19B4D320916AC40")
    public int getAddedCount() {
        int varA6326B95254B685CD68E188862F5C34D_1050310980 = (mAddedCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1731090971 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1731090971;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.330 -0400", hash_original_method = "72BB1C08DFA71715A3D1B3E3C0F3D07A", hash_generated_method = "65B8104DFF6DF1C0C5382DF1AE842743")
    public void setAddedCount(int addedCount) {
        enforceNotSealed();
        mAddedCount = addedCount;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.330 -0400", hash_original_method = "EBD9E1156BBECE10FD62678D5B5AE958", hash_generated_method = "D2320C915CB1121E36683E1644218EC8")
    public int getRemovedCount() {
        int var4058B4F06CD15570EE422A4BBAEB7D02_1960170556 = (mRemovedCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411750968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411750968;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.330 -0400", hash_original_method = "A6A70AD3A3D0C21790CD56D9B41496A2", hash_generated_method = "9F643C3F276AF08806F5F7A1AFD79D6C")
    public void setRemovedCount(int removedCount) {
        enforceNotSealed();
        mRemovedCount = removedCount;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.330 -0400", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "8781318D075A3187E9C71EA163E3ADB5")
    public CharSequence getClassName() {
CharSequence varDD9C2143734A2F5CB66BF5CFBE75CE5F_277822884 =         mClassName;
        varDD9C2143734A2F5CB66BF5CFBE75CE5F_277822884.addTaint(taint);
        return varDD9C2143734A2F5CB66BF5CFBE75CE5F_277822884;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.331 -0400", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "14CBE69F155F8289009D8E6C29D09E01")
    public void setClassName(CharSequence className) {
        enforceNotSealed();
        mClassName = className;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.331 -0400", hash_original_method = "DC632160826FC3F04AF23253967928B9", hash_generated_method = "9F3A6F96EA07E4A7E958CFE6F2E0F65D")
    public List<CharSequence> getText() {
List<CharSequence> var7F7ECB4B14362FFBA020956966B29A66_1417021931 =         mText;
        var7F7ECB4B14362FFBA020956966B29A66_1417021931.addTaint(taint);
        return var7F7ECB4B14362FFBA020956966B29A66_1417021931;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.331 -0400", hash_original_method = "FE2FD614296585A25D259709588FAD5E", hash_generated_method = "4BD40D63CD66CF5EFC97C049238ABB2E")
    public CharSequence getBeforeText() {
CharSequence varA52E2B9C078522648046C50A3900A0D8_1236596936 =         mBeforeText;
        varA52E2B9C078522648046C50A3900A0D8_1236596936.addTaint(taint);
        return varA52E2B9C078522648046C50A3900A0D8_1236596936;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.331 -0400", hash_original_method = "D6F685CC2DDAD1DA7E7B88F32900AE37", hash_generated_method = "8E48EFEC23F26302C038E1E38FECF921")
    public void setBeforeText(CharSequence beforeText) {
        enforceNotSealed();
        mBeforeText = beforeText;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.331 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "F546D166031EFD6E8C8030965E140032")
    public CharSequence getContentDescription() {
CharSequence varDF4802B31F5D315C6875E7B89F1B2E58_111592182 =         mContentDescription;
        varDF4802B31F5D315C6875E7B89F1B2E58_111592182.addTaint(taint);
        return varDF4802B31F5D315C6875E7B89F1B2E58_111592182;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.331 -0400", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "3B296FA70F852F0CC9CE451463E87DC3")
    public void setContentDescription(CharSequence contentDescription) {
        enforceNotSealed();
        mContentDescription = contentDescription;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.331 -0400", hash_original_method = "336F04D02E102717408E8DD7ED329D8E", hash_generated_method = "E77A0A9DA0FB92B46C9D5CCB5AB1C280")
    public Parcelable getParcelableData() {
Parcelable var3C4A19D3B16D6B0D181314FD46225D0B_133304446 =         mParcelableData;
        var3C4A19D3B16D6B0D181314FD46225D0B_133304446.addTaint(taint);
        return var3C4A19D3B16D6B0D181314FD46225D0B_133304446;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.331 -0400", hash_original_method = "1574FBF11672419A058C271D89F97C62", hash_generated_method = "89FC1C8E2F27EF4EB43A98729811FB64")
    public void setParcelableData(Parcelable parcelableData) {
        enforceNotSealed();
        mParcelableData = parcelableData;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.332 -0400", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "F7C7CF110AFA05BD358D80D700ADEDC6")
    public void setConnectionId(int connectionId) {
        enforceNotSealed();
        mConnectionId = connectionId;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.332 -0400", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "0D7B5E4D59CD0A6DD9DDC234474696D4")
    public void setSealed(boolean sealed) {
        mSealed = sealed;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.332 -0400", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "506F9770BD964585130447CB24DE4FF6")
     boolean isSealed() {
        boolean var61DB78BD493651DCACB5FB89D74B835B_677858330 = (mSealed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457605213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_457605213;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.332 -0400", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "BAC92D8EC39058F26D6F957DAFFA6484")
     void enforceSealed() {
    if(!isSealed())        
        {
            IllegalStateException var652F71AFD0D5CCAA2788B927EF140BB3_1895722460 = new IllegalStateException("Cannot perform this "
                    + "action on a not sealed instance.");
            var652F71AFD0D5CCAA2788B927EF140BB3_1895722460.addTaint(taint);
            throw var652F71AFD0D5CCAA2788B927EF140BB3_1895722460;
        } 
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.332 -0400", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "4DA4BCAEF7679E73CF25CE8059809EB7")
     void enforceNotSealed() {
    if(isSealed())        
        {
            IllegalStateException var6C39E2F044A2DBD4DB7485B565A80573_1315668960 = new IllegalStateException("Cannot perform this "
                    + "action on an sealed instance.");
            var6C39E2F044A2DBD4DB7485B565A80573_1315668960.addTaint(taint);
            throw var6C39E2F044A2DBD4DB7485B565A80573_1315668960;
        } 
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.333 -0400", hash_original_method = "4FB14FE7E8FA7F40071202FB709EF8E4", hash_generated_method = "4768C782E00868758C34DD942C31818C")
    private boolean getBooleanProperty(int property) {
        addTaint(property);
        boolean var5D0AB9348D762CC2C1F8CBEC21E95FEF_753581754 = ((mBooleanProperties & property) == property);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551094030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551094030;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.333 -0400", hash_original_method = "1E3C58B2EEBD5BD671884B4ADC3ACB2F", hash_generated_method = "95C48EDB697FC48992ED6C6F994F1F64")
    private void setBooleanProperty(int property, boolean value) {
        addTaint(value);
    if(value)        
        {
            mBooleanProperties |= property;
        } 
        else
        {
            mBooleanProperties &= ~property;
        } 
        
        
            
        
            
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.334 -0400", hash_original_method = "0FDD4277FFE3E2F2D99D4BAB0780A409", hash_generated_method = "180CC3EEBB6F6B36302F4C0CB7CA7166")
    public void recycle() {
    if(mIsInPool)        
        {
            IllegalStateException varD5FBBAEC1C9F4FB9B48FC9CC3399D76F_257193778 = new IllegalStateException("Record already recycled!");
            varD5FBBAEC1C9F4FB9B48FC9CC3399D76F_257193778.addTaint(taint);
            throw varD5FBBAEC1C9F4FB9B48FC9CC3399D76F_257193778;
        } 
        clear();
        synchronized
(sPoolLock)        {
    if(sPoolSize <= MAX_POOL_SIZE)            
            {
                mNext = sPool;
                sPool = this;
                mIsInPool = true;
                sPoolSize++;
            } 
        } 
        
        
            
        
        
        
            
                
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.334 -0400", hash_original_method = "EC9B4AFBEF6A967243E7EC5889FB4591", hash_generated_method = "5A0A1932A91C027A05D8759B7A4BAA62")
     void init(AccessibilityRecord record) {
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_method = "F6BD36F7AA33E2CDDBD8ECFA17198BE9", hash_generated_method = "600B4D1FB38108C343C4EA3361FB0CDE")
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_method = "6984D5C42FE7046E0FC00D15FC78323D", hash_generated_method = "B06136FB59E73B571896298135EF7043")
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
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
String varF4CF030572656354ACFDF83FEE21D7A6_1352806788 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_1352806788.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_1352806788;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_field = "B0556DBFDA5EBCB4F93633B3431D8471", hash_generated_field = "1E642CC81E6D04170ACE577F1365D5E0")

    private static final int UNDEFINED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_field = "32B2EF6C9DC4E60D2DD2682FEB6CB9F3", hash_generated_field = "727FEBC84A7763294879AC67CE69F107")

    private static final int PROPERTY_CHECKED = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_field = "FCDC2713E65D4BDA73499EB44DE11CA7", hash_generated_field = "BF6BC93B5E6FD2F1AFC97468EC9F79A2")

    private static final int PROPERTY_ENABLED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_field = "6C1E4FE788B54270AFC3AABC67D5405E", hash_generated_field = "FA0A04EBDA8C2BEA18119B785E04F584")

    private static final int PROPERTY_PASSWORD = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_field = "53410DDF32C823031A788F87D641C4F5", hash_generated_field = "DEC42BEDF17E472B8EB1D0FC5AA34896")

    private static final int PROPERTY_FULL_SCREEN = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_field = "BDCC0030924174C6E15D3AED86AE3CDE", hash_generated_field = "92A0ADDFB1EC36FCD4578FA35BE2DB19")

    private static final int PROPERTY_SCROLLABLE = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_field = "EB2583C9A133F7C44A9BFAD1B17484D6", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")

    private static final int MAX_POOL_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_field = "0948632EF09E2DCA187883CC60BCD1E4", hash_generated_field = "515CCCD8D6622177DD93BECF774D048D")

    private static final Object sPoolLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "6EC2D88EC753CBA217CDEA5A4EB759FF")

    private static AccessibilityRecord sPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.335 -0400", hash_original_field = "F402B52BA7964DFA741C4EF5BBB4414B", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
}

