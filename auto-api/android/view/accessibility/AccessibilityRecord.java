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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "819E660F8F7271EBD249CE0B621A6CFF")

    private AccessibilityRecord mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "B94200C48C7563C1FA86222302A87F95", hash_generated_field = "12FC58788D16ADAE0F5394F898FD4D99")

    private boolean mIsInPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "61DB78BD493651DCACB5FB89D74B835B", hash_generated_field = "4B6C132CC4E1DABC021AFE92BC996668")

    boolean mSealed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "ED189995ED191C4589F06A64BF0FDC1E", hash_generated_field = "16EB928A608E490EDABD6C313699F6E2")

    int mBooleanProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "6FC9E35F3B461C2AB815F1E74909AB74", hash_generated_field = "61B6204A7C251AA3D27E9B50A9355A30")

    int mCurrentItemIndex = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "FCEDF646E8D09C460F2CCD9149618B7F", hash_generated_field = "F76D3264C191AE325187C60C1ABBC344")

    int mItemCount = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "E8DE381698608B73A16DD8D4A6221B8A", hash_generated_field = "EF145018DE8E629EE83018E54FFFED11")

    int mFromIndex = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "59A3DFB0D8439F689AF183C3AFCF6E6D", hash_generated_field = "51A8B4D9E0617CE3451D67583416EB43")

    int mToIndex = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "E37A685408290AEE3440FEEB511CFFC2", hash_generated_field = "72E164DE5C696E5476091A9DD43D6C8D")

    int mScrollX = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "AF8920A6914CAF7B59573D1EA96D84D4", hash_generated_field = "53E5DA241F46897B4A82791606381914")

    int mScrollY = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "FB4DA30E56CA7C84DEC95D6B31F790CE", hash_generated_field = "8B3E5A0AFE1301DC07049E45EAB257E2")

    int mMaxScrollX = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "731FDD0D49EB1631EB16352CD5DA8E25", hash_generated_field = "8B1EEF0BAF8B84D80086BC17A2C41C6C")

    int mMaxScrollY = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "CE5889B119B9D7A1D5FA8A750F2418CB", hash_generated_field = "D24F8B9BED9E4999FEFD1D6BDD0A4524")

    int mAddedCount = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "FF2342BAE899D71AD563D8FFE11D610A", hash_generated_field = "A726B2E71548B632DFBFAFCC74F6ADEA")

    int mRemovedCount = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "214C99E3A67E2DCCA15F1A7872516260", hash_generated_field = "3B1E05A74215A57B8C30C232B3E92D50")

    int mSourceViewId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "CC544EBF7996F79C6A0EFEAC592FA4E9", hash_generated_field = "831206FA2F666A93060BCB2DBBE12AE5")

    int mSourceWindowId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "607E22FB74B4A9750077B62E99C7097B")

    CharSequence mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "073D0187C9F61FAD4E5B0B851BDDC2B3", hash_generated_field = "1D344C00C8D6A0BCC2A3B840B08C53BD")

    CharSequence mContentDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "8F45542597C289D2929CD8F63821BE5A", hash_generated_field = "6FED3330A012BA7D2A27B5EF6045F2F0")

    CharSequence mBeforeText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "2A709DDD372D330C1BAA3EF44C00D074", hash_generated_field = "4C8F8687F0917167B5FF9B39C6545ED3")

    Parcelable mParcelableData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "635946FFFF3DBBC2187F69B62B4F0623", hash_generated_field = "868BA7C98D63B508230C0EC76DFD4DD7")

    final List<CharSequence> mText = new ArrayList<CharSequence>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.563 -0400", hash_original_field = "8EAF73743CC459D107527502BC394C97", hash_generated_field = "8B5A4110581AEE7B543A400E2F63419C")

    int mConnectionId = UNDEFINED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.564 -0400", hash_original_method = "47B5C6FFA7A08624EFFE67BFFC3F0DF4", hash_generated_method = "49EEADD37CBD0DA6FCCFEC65E1335A11")
      AccessibilityRecord() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.594 -0400", hash_original_method = "948A1D8CF51CA12DCE9E50B8B6FDE838", hash_generated_method = "E59658F17BB7F1419C92AF6FB40C348F")
    public void setSource(View source) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.595 -0400", hash_original_method = "D6229F18D386359B7D2ED64A724CE545", hash_generated_method = "3A19610E576A222A27505CADAF531C06")
    public AccessibilityNodeInfo getSource() {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_1173257881 = null; //Variable for return #1
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_1884763684 = null; //Variable for return #2
        enforceSealed();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1173257881 = null;
        } //End block
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        varB4EAC82CA7396A68D541C85D26508E83_1884763684 = client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId, mSourceWindowId,
                mSourceViewId);
        AccessibilityNodeInfo varA7E53CE21691AB073D9660D615818899_852088004; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_852088004 = varB4EAC82CA7396A68D541C85D26508E83_1173257881;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_852088004 = varB4EAC82CA7396A68D541C85D26508E83_1884763684;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_852088004.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_852088004;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.595 -0400", hash_original_method = "0167B817243C7300A3E7B07356FC6F77", hash_generated_method = "25D8E9BB530ADBD0D12CC9D77E1D7112")
    public int getWindowId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189478772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189478772;
        // ---------- Original Method ----------
        //return mSourceWindowId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.596 -0400", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "7AF15801E780A862B367471F074C3C64")
    public boolean isChecked() {
        boolean var452C23D949DE68DF158EF7F75ABFD98B_1208396232 = (getBooleanProperty(PROPERTY_CHECKED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_390608146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_390608146;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.596 -0400", hash_original_method = "EF363FCE51C9C9A497BD6E689D39B09F", hash_generated_method = "7264C06EF6719AD3BADB9E6239B4980C")
    public void setChecked(boolean isChecked) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_CHECKED, isChecked);
        addTaint(isChecked);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_CHECKED, isChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.597 -0400", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "34BEA5CB7FD6739F391D221F4423B213")
    public boolean isEnabled() {
        boolean var8448E9D671258D44185D3F547D298C9D_1983998591 = (getBooleanProperty(PROPERTY_ENABLED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_113603560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_113603560;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.597 -0400", hash_original_method = "0EAAA686E8658459FDC66C98C4B45340", hash_generated_method = "4DB6461C57CFA0F779453E7DBBD87EF7")
    public void setEnabled(boolean isEnabled) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_ENABLED, isEnabled);
        addTaint(isEnabled);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_ENABLED, isEnabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.597 -0400", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "E338AEC9959D6A91840CCF298F2A0A39")
    public boolean isPassword() {
        boolean var087326F76FF21A482620141C52E3B799_2011606321 = (getBooleanProperty(PROPERTY_PASSWORD));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166509318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166509318;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_PASSWORD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.598 -0400", hash_original_method = "8EDA15203F993D6B021832D12354DB70", hash_generated_method = "80E25BA922AAEF4F0AA54580F1FB554C")
    public void setPassword(boolean isPassword) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_PASSWORD, isPassword);
        addTaint(isPassword);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_PASSWORD, isPassword);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.598 -0400", hash_original_method = "C1D751586747941BBE1AE366FE4E3AB5", hash_generated_method = "64C1F48A7F174A8C4716B11A8BBAED26")
    public boolean isFullScreen() {
        boolean var6C792059DAE3AE110DFF2A2C39B7D991_1515397415 = (getBooleanProperty(PROPERTY_FULL_SCREEN));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936670178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936670178;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FULL_SCREEN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.598 -0400", hash_original_method = "8C2BD0FA889006F174A45F3038D20EAE", hash_generated_method = "9846521B9D2F181C364126396FE99561")
    public void setFullScreen(boolean isFullScreen) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_FULL_SCREEN, isFullScreen);
        addTaint(isFullScreen);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_FULL_SCREEN, isFullScreen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.599 -0400", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "4BE45EE462E23B8677A336FC673DC25B")
    public boolean isScrollable() {
        boolean varCF570E94288645DBC38E8B422354A739_213051820 = (getBooleanProperty(PROPERTY_SCROLLABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398563189 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398563189;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SCROLLABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.599 -0400", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "7A2E32DEB4A97AE38DFA3F9DC84484E1")
    public void setScrollable(boolean scrollable) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
        addTaint(scrollable);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.599 -0400", hash_original_method = "5653D3A6C559AE9B846DF6E2B5CE39F8", hash_generated_method = "98E500A87E3A1E4D4B9F73E04582FE33")
    public int getItemCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867528022 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867528022;
        // ---------- Original Method ----------
        //return mItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.600 -0400", hash_original_method = "F4CC562DD5B544AF052C8C7ADD17F3DB", hash_generated_method = "39F44303466A5C8F7F39F778FFDDD0CE")
    public void setItemCount(int itemCount) {
        enforceNotSealed();
        mItemCount = itemCount;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mItemCount = itemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.600 -0400", hash_original_method = "C835140CBE8B50DDD89D13B9DB62A1BF", hash_generated_method = "C5EF661D66B0037C1104C4E021166A3B")
    public int getCurrentItemIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143735908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143735908;
        // ---------- Original Method ----------
        //return mCurrentItemIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.600 -0400", hash_original_method = "05A5E897DB8527242E13FEF032CE111F", hash_generated_method = "19B5132C68FB734C1499EBDF515D3B3D")
    public void setCurrentItemIndex(int currentItemIndex) {
        enforceNotSealed();
        mCurrentItemIndex = currentItemIndex;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mCurrentItemIndex = currentItemIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.601 -0400", hash_original_method = "67718C1B588EB57EF05CD90DC3F200D7", hash_generated_method = "1A4B15CBB34A8FF2BB56DC214CA28540")
    public int getFromIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081620487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081620487;
        // ---------- Original Method ----------
        //return mFromIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.601 -0400", hash_original_method = "BBFD31D579F6E6D46645245CC5F2E354", hash_generated_method = "36496D5056D8AB0FE7C2BEDCB6F05346")
    public void setFromIndex(int fromIndex) {
        enforceNotSealed();
        mFromIndex = fromIndex;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mFromIndex = fromIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.601 -0400", hash_original_method = "579D16111E248F454AD7B48F20E18451", hash_generated_method = "FB2C3DBF81192BAA5EFE3AEACA4FBBAC")
    public int getToIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486197499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486197499;
        // ---------- Original Method ----------
        //return mToIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.601 -0400", hash_original_method = "E568A8356EF0E74107283370C7553269", hash_generated_method = "FDAB56CA01587F7337EEE204C7CAA2F3")
    public void setToIndex(int toIndex) {
        enforceNotSealed();
        mToIndex = toIndex;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mToIndex = toIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.602 -0400", hash_original_method = "37E422003D62C4BD4746E9CFAAF79E84", hash_generated_method = "9B9C505317CB81C9A33A38F480002FA9")
    public int getScrollX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216177546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216177546;
        // ---------- Original Method ----------
        //return mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.602 -0400", hash_original_method = "39929F8426D84CFC2AAA2E35AFA69688", hash_generated_method = "C87434146081ADE968226CDF7649BD4F")
    public void setScrollX(int scrollX) {
        enforceNotSealed();
        mScrollX = scrollX;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mScrollX = scrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.602 -0400", hash_original_method = "1E7AE64F8D32210A6E2C97F4869FB31A", hash_generated_method = "22DC8A935BAD7A44CEBD887A88125E66")
    public int getScrollY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82840062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82840062;
        // ---------- Original Method ----------
        //return mScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.602 -0400", hash_original_method = "3D3AC5EAAB87E771122FE10290862D68", hash_generated_method = "24692C5BE0019BBEB295B48727960D47")
    public void setScrollY(int scrollY) {
        enforceNotSealed();
        mScrollY = scrollY;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mScrollY = scrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.603 -0400", hash_original_method = "C4A2F5E4142D8D5EA688446E7513363C", hash_generated_method = "D2A2709B7C5151E46A2AF0FA4DF9B97B")
    public int getMaxScrollX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003991263 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003991263;
        // ---------- Original Method ----------
        //return mMaxScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.603 -0400", hash_original_method = "EE977B785E6D4A7CA733252D06CF32E9", hash_generated_method = "33A6260074AAD8E975DFFFE9A91EDE8C")
    public void setMaxScrollX(int maxScrollX) {
        enforceNotSealed();
        mMaxScrollX = maxScrollX;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mMaxScrollX = maxScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.603 -0400", hash_original_method = "A3ECA44A0D4150097FAA989997DF13C5", hash_generated_method = "645A902FC1FAD89703A47BF25D989811")
    public int getMaxScrollY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222532958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222532958;
        // ---------- Original Method ----------
        //return mMaxScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.604 -0400", hash_original_method = "49077E92EA018330C2FB0B17E183D4A7", hash_generated_method = "078D9BF7E9E30261FD815908FC98FAD6")
    public void setMaxScrollY(int maxScrollY) {
        enforceNotSealed();
        mMaxScrollY = maxScrollY;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mMaxScrollY = maxScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.605 -0400", hash_original_method = "49E2E44D8419AC51B09A77AC8668D279", hash_generated_method = "EF90F18C9434CE1719521CA770DE678D")
    public int getAddedCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068458 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068458;
        // ---------- Original Method ----------
        //return mAddedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.605 -0400", hash_original_method = "72BB1C08DFA71715A3D1B3E3C0F3D07A", hash_generated_method = "65B8104DFF6DF1C0C5382DF1AE842743")
    public void setAddedCount(int addedCount) {
        enforceNotSealed();
        mAddedCount = addedCount;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mAddedCount = addedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.606 -0400", hash_original_method = "EBD9E1156BBECE10FD62678D5B5AE958", hash_generated_method = "41BF52B9C8B696F808E4DE8D07960A56")
    public int getRemovedCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353100465 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353100465;
        // ---------- Original Method ----------
        //return mRemovedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.606 -0400", hash_original_method = "A6A70AD3A3D0C21790CD56D9B41496A2", hash_generated_method = "9F643C3F276AF08806F5F7A1AFD79D6C")
    public void setRemovedCount(int removedCount) {
        enforceNotSealed();
        mRemovedCount = removedCount;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mRemovedCount = removedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.607 -0400", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "5E5774B7DE5C760FA902A53F09A48DAF")
    public CharSequence getClassName() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1741534038 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1741534038 = mClassName;
        varB4EAC82CA7396A68D541C85D26508E83_1741534038.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1741534038;
        // ---------- Original Method ----------
        //return mClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.607 -0400", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "14CBE69F155F8289009D8E6C29D09E01")
    public void setClassName(CharSequence className) {
        enforceNotSealed();
        mClassName = className;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mClassName = className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.608 -0400", hash_original_method = "DC632160826FC3F04AF23253967928B9", hash_generated_method = "95B36C8DC7140085E9CB1D5B7EB1239B")
    public List<CharSequence> getText() {
        List<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_365332677 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_365332677 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_365332677.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_365332677;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.608 -0400", hash_original_method = "FE2FD614296585A25D259709588FAD5E", hash_generated_method = "74377981EC1C792970442FD70D7D7D27")
    public CharSequence getBeforeText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_499519202 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_499519202 = mBeforeText;
        varB4EAC82CA7396A68D541C85D26508E83_499519202.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_499519202;
        // ---------- Original Method ----------
        //return mBeforeText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.609 -0400", hash_original_method = "D6F685CC2DDAD1DA7E7B88F32900AE37", hash_generated_method = "8E48EFEC23F26302C038E1E38FECF921")
    public void setBeforeText(CharSequence beforeText) {
        enforceNotSealed();
        mBeforeText = beforeText;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBeforeText = beforeText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.610 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "75948F203E5951C75572FF7CF9C7B03F")
    public CharSequence getContentDescription() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_680510953 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_680510953 = mContentDescription;
        varB4EAC82CA7396A68D541C85D26508E83_680510953.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680510953;
        // ---------- Original Method ----------
        //return mContentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.610 -0400", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "3B296FA70F852F0CC9CE451463E87DC3")
    public void setContentDescription(CharSequence contentDescription) {
        enforceNotSealed();
        mContentDescription = contentDescription;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mContentDescription = contentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.611 -0400", hash_original_method = "336F04D02E102717408E8DD7ED329D8E", hash_generated_method = "ED2E0E227139A989CB2225458A09EEC0")
    public Parcelable getParcelableData() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_293081954 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_293081954 = mParcelableData;
        varB4EAC82CA7396A68D541C85D26508E83_293081954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_293081954;
        // ---------- Original Method ----------
        //return mParcelableData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.611 -0400", hash_original_method = "1574FBF11672419A058C271D89F97C62", hash_generated_method = "89FC1C8E2F27EF4EB43A98729811FB64")
    public void setParcelableData(Parcelable parcelableData) {
        enforceNotSealed();
        mParcelableData = parcelableData;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mParcelableData = parcelableData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.611 -0400", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "F7C7CF110AFA05BD358D80D700ADEDC6")
    public void setConnectionId(int connectionId) {
        enforceNotSealed();
        mConnectionId = connectionId;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mConnectionId = connectionId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.612 -0400", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "0D7B5E4D59CD0A6DD9DDC234474696D4")
    public void setSealed(boolean sealed) {
        mSealed = sealed;
        // ---------- Original Method ----------
        //mSealed = sealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.612 -0400", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "EB385377ECCE9688D29944ADBB741190")
     boolean isSealed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742815652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_742815652;
        // ---------- Original Method ----------
        //return mSealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.612 -0400", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "A2EE9E350A4408CFFF5727829CAA98B8")
     void enforceSealed() {
        {
            boolean varD513186271CF3A3D5E081DE87E878208_209323865 = (!isSealed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.613 -0400", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "A1E39BC4CC31C68448F7010A3A047ED9")
     void enforceNotSealed() {
        {
            boolean varA822B3442F37011C427DDD3B23C1201F_1797658179 = (isSealed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.613 -0400", hash_original_method = "4FB14FE7E8FA7F40071202FB709EF8E4", hash_generated_method = "EA2253694B454986ECFD20C74E40FC25")
    private boolean getBooleanProperty(int property) {
        addTaint(property);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048084995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048084995;
        // ---------- Original Method ----------
        //return (mBooleanProperties & property) == property;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.613 -0400", hash_original_method = "1E3C58B2EEBD5BD671884B4ADC3ACB2F", hash_generated_method = "A5B03B4F4EA654785C16AC47CD8C3419")
    private void setBooleanProperty(int property, boolean value) {
        {
            mBooleanProperties |= property;
        } //End block
        {
            mBooleanProperties &= ~property;
        } //End block
        addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.621 -0400", hash_original_method = "0FDD4277FFE3E2F2D99D4BAB0780A409", hash_generated_method = "E3B0E38298882DBC3E1301C60F0666D3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.621 -0400", hash_original_method = "EC9B4AFBEF6A967243E7EC5889FB4591", hash_generated_method = "5A0A1932A91C027A05D8759B7A4BAA62")
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.622 -0400", hash_original_method = "F6BD36F7AA33E2CDDBD8ECFA17198BE9", hash_generated_method = "600B4D1FB38108C343C4EA3361FB0CDE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.624 -0400", hash_original_method = "6984D5C42FE7046E0FC00D15FC78323D", hash_generated_method = "C00EAA4FE88090589862BBB7987E58DE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1081945626 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1081945626 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1081945626.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1081945626;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.625 -0400", hash_original_field = "B0556DBFDA5EBCB4F93633B3431D8471", hash_generated_field = "1E642CC81E6D04170ACE577F1365D5E0")

    private static final int UNDEFINED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.625 -0400", hash_original_field = "32B2EF6C9DC4E60D2DD2682FEB6CB9F3", hash_generated_field = "727FEBC84A7763294879AC67CE69F107")

    private static final int PROPERTY_CHECKED = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.625 -0400", hash_original_field = "FCDC2713E65D4BDA73499EB44DE11CA7", hash_generated_field = "BF6BC93B5E6FD2F1AFC97468EC9F79A2")

    private static final int PROPERTY_ENABLED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.625 -0400", hash_original_field = "6C1E4FE788B54270AFC3AABC67D5405E", hash_generated_field = "FA0A04EBDA8C2BEA18119B785E04F584")

    private static final int PROPERTY_PASSWORD = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.625 -0400", hash_original_field = "53410DDF32C823031A788F87D641C4F5", hash_generated_field = "DEC42BEDF17E472B8EB1D0FC5AA34896")

    private static final int PROPERTY_FULL_SCREEN = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.625 -0400", hash_original_field = "BDCC0030924174C6E15D3AED86AE3CDE", hash_generated_field = "92A0ADDFB1EC36FCD4578FA35BE2DB19")

    private static final int PROPERTY_SCROLLABLE = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.625 -0400", hash_original_field = "EB2583C9A133F7C44A9BFAD1B17484D6", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")

    private static final int MAX_POOL_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.625 -0400", hash_original_field = "0948632EF09E2DCA187883CC60BCD1E4", hash_generated_field = "515CCCD8D6622177DD93BECF774D048D")

    private static final Object sPoolLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.625 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "6EC2D88EC753CBA217CDEA5A4EB759FF")

    private static AccessibilityRecord sPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.625 -0400", hash_original_field = "F402B52BA7964DFA741C4EF5BBB4414B", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
}

