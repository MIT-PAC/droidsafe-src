package android.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import java.util.Collections;
import java.util.List;

public class AccessibilityNodeInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "C62243493B3195CCB3CA5EBD27BBE8A1")

    private AccessibilityNodeInfo mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "B94200C48C7563C1FA86222302A87F95", hash_generated_field = "12FC58788D16ADAE0F5394F898FD4D99")

    private boolean mIsInPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "61DB78BD493651DCACB5FB89D74B835B", hash_generated_field = "F484C63B720CA97398F62D332F1EF674")

    private boolean mSealed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "33C37173D4FB16E9C2705DDC9871E235", hash_generated_field = "3F1B7BC9DC0772DFCA42C4ED21C8C0B3")

    private int mAccessibilityViewId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "AE07E63782A3DEF23A551D477FAC2C5B", hash_generated_field = "5DFC012BAE7B65B646562BF7E0C7F019")

    private int mAccessibilityWindowId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "615FE12157FB42EA8FEFDA0C9776E388", hash_generated_field = "ABBA6AEAFA3976D0777A287768B773F5")

    private int mParentAccessibilityViewId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "ED189995ED191C4589F06A64BF0FDC1E", hash_generated_field = "1B6EE350CEE9B789577F337242F99452")

    private int mBooleanProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "48B2C313D890E0D9A3FF0100964C217F", hash_generated_field = "9CF6A61B50A2B7EE6285AD95BD9992FE")

    private Rect mBoundsInParent = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "F6756A24324F7884089A690FFAF75E3A", hash_generated_field = "DFC5360F216E3032B82B0051D92FF875")

    private Rect mBoundsInScreen = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6A9DFBEC5628781E76307C090C363D49")

    private CharSequence mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "E65EE2088107B60FFFC2528EC1FA049B")

    private CharSequence mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "073D0187C9F61FAD4E5B0B851BDDC2B3", hash_generated_field = "8594C4137F32107058E48C17931382B5")

    private CharSequence mContentDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "56BB1D059EE24D6976234EF3223694E5", hash_generated_field = "6EE62237A17F69CD965F14880008505D")

    private SparseIntArray mChildAccessibilityIds = new SparseIntArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "C268D719F2F67098628D1A8EEBB72B48", hash_generated_field = "BAF3D762CB2D0F96BFE73E57C2472173")

    private int mActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_field = "8EAF73743CC459D107527502BC394C97", hash_generated_field = "19848A63CACE6F8B90BC11DC69A6EB80")

    private int mConnectionId = UNDEFINED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.632 -0400", hash_original_method = "EB9F4328D2282B04E1BD31B0186E73D5", hash_generated_method = "176EFD0A62B716335FDF7CEAA647EEC5")
    private  AccessibilityNodeInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.633 -0400", hash_original_method = "D6E0A07A0224052514955EB47C47B111", hash_generated_method = "C23446C48003D369C9072D325F17D89E")
    public void setSource(View source) {
        enforceNotSealed();
        mAccessibilityViewId = source.getAccessibilityViewId();
        mAccessibilityWindowId = source.getAccessibilityWindowId();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mAccessibilityViewId = source.getAccessibilityViewId();
        //mAccessibilityWindowId = source.getAccessibilityWindowId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.633 -0400", hash_original_method = "6C41AAD35FD64A253FB83D406AD6C88C", hash_generated_method = "12CA2CC85BEA1258F412CBAB4A4EDEF7")
    public int getWindowId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_79447965 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_79447965;
        // ---------- Original Method ----------
        //return mAccessibilityWindowId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.633 -0400", hash_original_method = "7C8926FBBCF561C891F2F5FFEAFED8AF", hash_generated_method = "0C360DF75AA03E5C136D956B484D68FA")
    public int getChildCount() {
        int var319A3D2E0BF4719DB1F3ABFECD3065BB_1192726766 = (mChildAccessibilityIds.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496725262 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496725262;
        // ---------- Original Method ----------
        //return mChildAccessibilityIds.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.634 -0400", hash_original_method = "E9093B8E79E0C35ACECC8F5F72DA0B71", hash_generated_method = "AF36B724AD92ECBAC1DB4C03B520B68F")
    public AccessibilityNodeInfo getChild(int index) {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_480403184 = null; //Variable for return #1
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_622275970 = null; //Variable for return #2
        enforceSealed();
        int childAccessibilityViewId;
        childAccessibilityViewId = mChildAccessibilityIds.get(index);
        {
            boolean varB4030DB148F9B166EB2AAB9777FB5D27_2034445899 = (!canPerformRequestOverConnection(childAccessibilityViewId));
            {
                varB4EAC82CA7396A68D541C85D26508E83_480403184 = null;
            } //End block
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        varB4EAC82CA7396A68D541C85D26508E83_622275970 = client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, childAccessibilityViewId);
        addTaint(index);
        AccessibilityNodeInfo varA7E53CE21691AB073D9660D615818899_1518787789; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1518787789 = varB4EAC82CA7396A68D541C85D26508E83_480403184;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1518787789 = varB4EAC82CA7396A68D541C85D26508E83_622275970;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1518787789.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1518787789;
        // ---------- Original Method ----------
        //enforceSealed();
        //final int childAccessibilityViewId = mChildAccessibilityIds.get(index);
        //if (!canPerformRequestOverConnection(childAccessibilityViewId)) {
            //return null;
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                //mAccessibilityWindowId, childAccessibilityViewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.634 -0400", hash_original_method = "DCE0377A8D2F3327097D2FFFE36C9D81", hash_generated_method = "254B5818495C2A7937D575AB571B1B83")
    public void addChild(View child) {
        enforceNotSealed();
        int childAccessibilityViewId;
        childAccessibilityViewId = child.getAccessibilityViewId();
        int index;
        index = mChildAccessibilityIds.size();
        mChildAccessibilityIds.put(index, childAccessibilityViewId);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //enforceNotSealed();
        //final int childAccessibilityViewId = child.getAccessibilityViewId();
        //final int index = mChildAccessibilityIds.size();
        //mChildAccessibilityIds.put(index, childAccessibilityViewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.635 -0400", hash_original_method = "60E376BAD814E27A83B622ADA78DD695", hash_generated_method = "F8FD31582D4CB2843A6F89678F73D280")
    public int getActions() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202045105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202045105;
        // ---------- Original Method ----------
        //return mActions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.635 -0400", hash_original_method = "62A0FADACCC1DF1A8E35D414239187E3", hash_generated_method = "08C8909FE1EC08FC2D37082D7B66DC91")
    public void addAction(int action) {
        enforceNotSealed();
        mActions |= action;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mActions |= action;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.636 -0400", hash_original_method = "CDA2E61C3267971FAEFED5DF1BBF4146", hash_generated_method = "BF8061D40FFEFCD93DF94AF140961E8F")
    public boolean performAction(int action) {
        enforceSealed();
        {
            boolean var721560EFD3BEE97481FFB7EC61BDACA3_893653353 = (!canPerformRequestOverConnection(mAccessibilityViewId));
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        boolean var7A46E79558E217C344F969075A75CE02_121017300 = (client.performAccessibilityAction(mConnectionId, mAccessibilityWindowId,
                mAccessibilityViewId, action));
        addTaint(action);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1571178837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1571178837;
        // ---------- Original Method ----------
        //enforceSealed();
        //if (!canPerformRequestOverConnection(mAccessibilityViewId)) {
            //return false;
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.performAccessibilityAction(mConnectionId, mAccessibilityWindowId,
                //mAccessibilityViewId, action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.653 -0400", hash_original_method = "DAAF9FBDD74DB58981A13A4C1D5FEB20", hash_generated_method = "A92C26B6A8BBF00F31F53E6556208154")
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text) {
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_52750003 = null; //Variable for return #1
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_1206159404 = null; //Variable for return #2
        enforceSealed();
        {
            boolean var721560EFD3BEE97481FFB7EC61BDACA3_1594795059 = (!canPerformRequestOverConnection(mAccessibilityViewId));
            {
                varB4EAC82CA7396A68D541C85D26508E83_52750003 = Collections.emptyList();
            } //End block
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        varB4EAC82CA7396A68D541C85D26508E83_1206159404 = client.findAccessibilityNodeInfosByViewText(mConnectionId, text,
                mAccessibilityWindowId, mAccessibilityViewId);
        addTaint(text.getTaint());
        List<AccessibilityNodeInfo> varA7E53CE21691AB073D9660D615818899_1523991252; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1523991252 = varB4EAC82CA7396A68D541C85D26508E83_52750003;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1523991252 = varB4EAC82CA7396A68D541C85D26508E83_1206159404;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1523991252.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1523991252;
        // ---------- Original Method ----------
        //enforceSealed();
        //if (!canPerformRequestOverConnection(mAccessibilityViewId)) {
            //return Collections.emptyList();
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.findAccessibilityNodeInfosByViewText(mConnectionId, text,
                //mAccessibilityWindowId, mAccessibilityViewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.660 -0400", hash_original_method = "F4DB109D13E56E0D98A6319CC588873D", hash_generated_method = "8C7C59856F994F6DAD4510A9D842A69A")
    public AccessibilityNodeInfo getParent() {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_75671441 = null; //Variable for return #1
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_331831854 = null; //Variable for return #2
        enforceSealed();
        {
            boolean varE5EB0B5D9D4BC6B936730052406791C1_1809474750 = (!canPerformRequestOverConnection(mParentAccessibilityViewId));
            {
                varB4EAC82CA7396A68D541C85D26508E83_75671441 = null;
            } //End block
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        varB4EAC82CA7396A68D541C85D26508E83_331831854 = client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, mParentAccessibilityViewId);
        AccessibilityNodeInfo varA7E53CE21691AB073D9660D615818899_1671004712; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1671004712 = varB4EAC82CA7396A68D541C85D26508E83_75671441;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1671004712 = varB4EAC82CA7396A68D541C85D26508E83_331831854;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1671004712.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1671004712;
        // ---------- Original Method ----------
        //enforceSealed();
        //if (!canPerformRequestOverConnection(mParentAccessibilityViewId)) {
            //return null;
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                //mAccessibilityWindowId, mParentAccessibilityViewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.661 -0400", hash_original_method = "0FE0BB8E7E891FFE4D867C8196AE43B4", hash_generated_method = "256BE2BB0D6BEB9BC66C3F9B14E2875E")
    public void setParent(View parent) {
        enforceNotSealed();
        mParentAccessibilityViewId = parent.getAccessibilityViewId();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mParentAccessibilityViewId = parent.getAccessibilityViewId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.663 -0400", hash_original_method = "908AD8B1395D82502A9E3BA629915EF5", hash_generated_method = "50A3FCFE786BB8EAC72B918CF76B31D7")
    public void getBoundsInParent(Rect outBounds) {
        outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                mBoundsInParent.right, mBoundsInParent.bottom);
        addTaint(outBounds.getTaint());
        // ---------- Original Method ----------
        //outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                //mBoundsInParent.right, mBoundsInParent.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.666 -0400", hash_original_method = "DC2A2D1F16BCFDB8F09D047ED8729F2A", hash_generated_method = "29B8C67796D4B0620EC99AD2E50D3A7F")
    public void setBoundsInParent(Rect bounds) {
        enforceNotSealed();
        mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.666 -0400", hash_original_method = "2F98E8EF78DCE8F1C352462875EB84AE", hash_generated_method = "2454C53EA419C285996ED467B6FC2879")
    public void getBoundsInScreen(Rect outBounds) {
        outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                mBoundsInScreen.right, mBoundsInScreen.bottom);
        addTaint(outBounds.getTaint());
        // ---------- Original Method ----------
        //outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                //mBoundsInScreen.right, mBoundsInScreen.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.667 -0400", hash_original_method = "770F78071B2EB9D2396840AB4AD2ADB5", hash_generated_method = "0D2011E9F8AE45F813C5588B18FF80BA")
    public void setBoundsInScreen(Rect bounds) {
        enforceNotSealed();
        mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.667 -0400", hash_original_method = "67B4AEAF1632FE4AAC04770D8458ACB9", hash_generated_method = "88BDC16703006DEB427B99FF2DC1A5F5")
    public boolean isCheckable() {
        boolean var3266C6B4E549BCADC450908FD96A217C_120832586 = (getBooleanProperty(PROPERTY_CHECKABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1686756480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1686756480;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.667 -0400", hash_original_method = "516AC58EA6CB8A6948778CD704999386", hash_generated_method = "99873B0DA6A752907003B1A45549B048")
    public void setCheckable(boolean checkable) {
        setBooleanProperty(PROPERTY_CHECKABLE, checkable);
        addTaint(checkable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CHECKABLE, checkable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.674 -0400", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "987FE10E7544DBC0843C49077F8BDF2B")
    public boolean isChecked() {
        boolean var452C23D949DE68DF158EF7F75ABFD98B_1920415401 = (getBooleanProperty(PROPERTY_CHECKED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1830302355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1830302355;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.674 -0400", hash_original_method = "930075A9DA99BE3539B9BAFC112A5160", hash_generated_method = "7B50F8EEFC991F22DFE85D84B226B03B")
    public void setChecked(boolean checked) {
        setBooleanProperty(PROPERTY_CHECKED, checked);
        addTaint(checked);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CHECKED, checked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.674 -0400", hash_original_method = "BEA45F3FF1A12FCE09D72D148357CE2C", hash_generated_method = "D220BA0E68D2F275D8058AB912937A1F")
    public boolean isFocusable() {
        boolean varAEDFD7054BC897AF8637C74153A7FF42_1771448773 = (getBooleanProperty(PROPERTY_FOCUSABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254342639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_254342639;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FOCUSABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.678 -0400", hash_original_method = "A4FE2C9F5A8AC78848A5BB7FA1A98C8F", hash_generated_method = "CF5AA9A35146B6E9DE18F4B04E0FCF09")
    public void setFocusable(boolean focusable) {
        setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
        addTaint(focusable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.679 -0400", hash_original_method = "3CD3FFF6959365D82FD80FF1FA237F64", hash_generated_method = "EA5EF8431FA70117DDF2439E4421F1E3")
    public boolean isFocused() {
        boolean var62148897FE29AC5CF93DA794C2584E47_387239861 = (getBooleanProperty(PROPERTY_FOCUSED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1286909472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1286909472;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FOCUSED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.679 -0400", hash_original_method = "6C2B5793CEDC3F6B1248DAB365B53404", hash_generated_method = "CF9D6D51D488151C8D916057757CA8A8")
    public void setFocused(boolean focused) {
        setBooleanProperty(PROPERTY_FOCUSED, focused);
        addTaint(focused);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_FOCUSED, focused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.679 -0400", hash_original_method = "0C97805A247814CF6CABD75572FD40C1", hash_generated_method = "A07490F624D37555823C27FEB5EB68A7")
    public boolean isSelected() {
        boolean var4935841C6821896C6C87075392A6DADA_2060831327 = (getBooleanProperty(PROPERTY_SELECTED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097352863 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097352863;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SELECTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.680 -0400", hash_original_method = "0890254D4AC82258F1AAEA57F8827B54", hash_generated_method = "936DA108DE4F9C5A6C22B004D6AD49F6")
    public void setSelected(boolean selected) {
        setBooleanProperty(PROPERTY_SELECTED, selected);
        addTaint(selected);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_SELECTED, selected);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.681 -0400", hash_original_method = "9E42D14BA1D4CF35C9E8D228C35BEE02", hash_generated_method = "2742B3DAB6D6EE75A4CFFE5365E0AE70")
    public boolean isClickable() {
        boolean var619B1840FC15914C5C371F60FFBB44CD_1023467433 = (getBooleanProperty(PROPERTY_CLICKABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274514213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_274514213;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CLICKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.681 -0400", hash_original_method = "2AB4084D18C97615027F882B075290EA", hash_generated_method = "0DD09E0A98FFB5CA51FAEF087050469C")
    public void setClickable(boolean clickable) {
        setBooleanProperty(PROPERTY_CLICKABLE, clickable);
        addTaint(clickable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CLICKABLE, clickable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.691 -0400", hash_original_method = "30EDA8A2E8A402543ACC7CC56FF92053", hash_generated_method = "00FA6A44D75B12C85104FEF47127D4A5")
    public boolean isLongClickable() {
        boolean var28D1637359B227432B5AA37481E68E9B_582517059 = (getBooleanProperty(PROPERTY_LONG_CLICKABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_80066719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_80066719;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_LONG_CLICKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.691 -0400", hash_original_method = "BBEB96E07778625102E9D70952371D0D", hash_generated_method = "6A497E2FA2B35AE888413DE38EDC126D")
    public void setLongClickable(boolean longClickable) {
        setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
        addTaint(longClickable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.691 -0400", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "098B310A79E2672947371FC139AA984B")
    public boolean isEnabled() {
        boolean var8448E9D671258D44185D3F547D298C9D_396203805 = (getBooleanProperty(PROPERTY_ENABLED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193715755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193715755;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.692 -0400", hash_original_method = "2D7E6331314DB7964C417618AC2EB5EA", hash_generated_method = "F9109DCFC5010B7ABD14FA7D9299726B")
    public void setEnabled(boolean enabled) {
        setBooleanProperty(PROPERTY_ENABLED, enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_ENABLED, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.692 -0400", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "003800300CE4976D5F087F0C4697A6B3")
    public boolean isPassword() {
        boolean var087326F76FF21A482620141C52E3B799_1513337457 = (getBooleanProperty(PROPERTY_PASSWORD));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1217000530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1217000530;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_PASSWORD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.692 -0400", hash_original_method = "4C0E98701874539EDF8F49BF5002C98F", hash_generated_method = "3B1C80CD992BF98FDDEE4A82DFB332A9")
    public void setPassword(boolean password) {
        setBooleanProperty(PROPERTY_PASSWORD, password);
        addTaint(password);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_PASSWORD, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.692 -0400", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "1C1B29C92EF49EB5283D63197162D66C")
    public boolean isScrollable() {
        boolean varCF570E94288645DBC38E8B422354A739_940931382 = (getBooleanProperty(PROPERTY_SCROLLABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938647541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938647541;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SCROLLABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.698 -0400", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "7A2E32DEB4A97AE38DFA3F9DC84484E1")
    public void setScrollable(boolean scrollable) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
        addTaint(scrollable);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.698 -0400", hash_original_method = "6D18CADAD3BE855C953B6A82043EA347", hash_generated_method = "52170F935B34772D9C835787E8327003")
    public CharSequence getPackageName() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_454799974 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_454799974 = mPackageName;
        varB4EAC82CA7396A68D541C85D26508E83_454799974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_454799974;
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.703 -0400", hash_original_method = "D35D1C42C7BD5A2BDF03FC6BDBDF64EE", hash_generated_method = "0EF63785D6B95ACB6D9D44BFD3B5249A")
    public void setPackageName(CharSequence packageName) {
        enforceNotSealed();
        mPackageName = packageName;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mPackageName = packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.704 -0400", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "A18E090D23927019CF6A8D1F2AD42ED8")
    public CharSequence getClassName() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_198754206 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_198754206 = mClassName;
        varB4EAC82CA7396A68D541C85D26508E83_198754206.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_198754206;
        // ---------- Original Method ----------
        //return mClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.704 -0400", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "14CBE69F155F8289009D8E6C29D09E01")
    public void setClassName(CharSequence className) {
        enforceNotSealed();
        mClassName = className;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mClassName = className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.705 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "3CC2FF293511D18EAEAE7D970BDFF165")
    public CharSequence getText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1065082649 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1065082649 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_1065082649.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1065082649;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.705 -0400", hash_original_method = "B470A357BC33F6D7BBE8C746674F6216", hash_generated_method = "1E87990391DAA5C0EC810623044152A5")
    public void setText(CharSequence text) {
        enforceNotSealed();
        mText = text;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mText = text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.705 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "5193CDE653BA1F9C51DD02DEC2FE8B96")
    public CharSequence getContentDescription() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1639229656 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1639229656 = mContentDescription;
        varB4EAC82CA7396A68D541C85D26508E83_1639229656.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1639229656;
        // ---------- Original Method ----------
        //return mContentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.714 -0400", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "3B296FA70F852F0CC9CE451463E87DC3")
    public void setContentDescription(CharSequence contentDescription) {
        enforceNotSealed();
        mContentDescription = contentDescription;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mContentDescription = contentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.715 -0400", hash_original_method = "08ED9648E2048980BB715C0F95464D97", hash_generated_method = "3EFC6C3DFB821640B00D6D3A44A8E65E")
    private boolean getBooleanProperty(int property) {
        addTaint(property);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1212231222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1212231222;
        // ---------- Original Method ----------
        //return (mBooleanProperties & property) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.715 -0400", hash_original_method = "AF4B29064CFE4EC4A14EBB7B9CA58D1B", hash_generated_method = "386107379A26A87BA42022D0B304E282")
    private void setBooleanProperty(int property, boolean value) {
        enforceNotSealed();
        {
            mBooleanProperties |= property;
        } //End block
        {
            mBooleanProperties &= ~property;
        } //End block
        addTaint(value);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //if (value) {
            //mBooleanProperties |= property;
        //} else {
            //mBooleanProperties &= ~property;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.716 -0400", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "F7C7CF110AFA05BD358D80D700ADEDC6")
    public void setConnectionId(int connectionId) {
        enforceNotSealed();
        mConnectionId = connectionId;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mConnectionId = connectionId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.716 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7A5722A75FC24A99C333E27160F01F2A")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519307125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519307125;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.724 -0400", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "0D7B5E4D59CD0A6DD9DDC234474696D4")
    public void setSealed(boolean sealed) {
        mSealed = sealed;
        // ---------- Original Method ----------
        //mSealed = sealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.725 -0400", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "9376E140FCB38A3CB7D767F6C9A9A3DE")
    public boolean isSealed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623903509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_623903509;
        // ---------- Original Method ----------
        //return mSealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.725 -0400", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "33B52A59E48A21B9C98A3873AAE888AD")
    protected void enforceSealed() {
        {
            boolean varD513186271CF3A3D5E081DE87E878208_533274537 = (!isSealed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.725 -0400", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "EABF3F0A9ACE9A0023C8861A9802B3A5")
    protected void enforceNotSealed() {
        {
            boolean varA822B3442F37011C427DDD3B23C1201F_2110102937 = (isSealed());
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

    
        public static AccessibilityNodeInfo obtain(View source) {
        AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
        info.setSource(source);
        return info;
    }

    
        public static AccessibilityNodeInfo obtain() {
        synchronized (sPoolLock) {
            if (sPool != null) {
                AccessibilityNodeInfo info = sPool;
                sPool = sPool.mNext;
                sPoolSize--;
                info.mNext = null;
                info.mIsInPool = false;
                return info;
            }
            return new AccessibilityNodeInfo();
        }
    }

    
        public static AccessibilityNodeInfo obtain(AccessibilityNodeInfo info) {
        AccessibilityNodeInfo infoClone = AccessibilityNodeInfo.obtain();
        infoClone.init(info);
        return infoClone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.736 -0400", hash_original_method = "E5AEF2A1BB846A92BC2380F50D2ACE39", hash_generated_method = "B8D0E4AEBBE679DC192A6A9B217301F4")
    public void recycle() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Info already recycled!");
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
            //throw new IllegalStateException("Info already recycled!");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.740 -0400", hash_original_method = "CE4668F7872E1547EB7B822B86C2AD44", hash_generated_method = "671E687CBB3A4031A2C05F02CD981DC3")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(isSealed() ? 1 : 0);
        parcel.writeInt(mAccessibilityViewId);
        parcel.writeInt(mAccessibilityWindowId);
        parcel.writeInt(mParentAccessibilityViewId);
        parcel.writeInt(mConnectionId);
        SparseIntArray childIds;
        childIds = mChildAccessibilityIds;
        int childIdsSize;
        childIdsSize = childIds.size();
        parcel.writeInt(childIdsSize);
        {
            int i;
            i = 0;
            {
                parcel.writeInt(childIds.valueAt(i));
            } //End block
        } //End collapsed parenthetic
        parcel.writeInt(mBoundsInParent.top);
        parcel.writeInt(mBoundsInParent.bottom);
        parcel.writeInt(mBoundsInParent.left);
        parcel.writeInt(mBoundsInParent.right);
        parcel.writeInt(mBoundsInScreen.top);
        parcel.writeInt(mBoundsInScreen.bottom);
        parcel.writeInt(mBoundsInScreen.left);
        parcel.writeInt(mBoundsInScreen.right);
        parcel.writeInt(mActions);
        parcel.writeInt(mBooleanProperties);
        TextUtils.writeToParcel(mPackageName, parcel, flags);
        TextUtils.writeToParcel(mClassName, parcel, flags);
        TextUtils.writeToParcel(mText, parcel, flags);
        TextUtils.writeToParcel(mContentDescription, parcel, flags);
        recycle();
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.746 -0400", hash_original_method = "84525B5DDEB8A0E58F9024DAD2E7A518", hash_generated_method = "F71AB9EF3C0B3B92859569069D17129D")
    private void init(AccessibilityNodeInfo other) {
        mSealed = other.mSealed;
        mAccessibilityViewId = other.mAccessibilityViewId;
        mParentAccessibilityViewId = other.mParentAccessibilityViewId;
        mAccessibilityWindowId = other.mAccessibilityWindowId;
        mConnectionId = other.mConnectionId;
        mBoundsInParent.set(other.mBoundsInParent);
        mBoundsInScreen.set(other.mBoundsInScreen);
        mPackageName = other.mPackageName;
        mClassName = other.mClassName;
        mText = other.mText;
        mContentDescription = other.mContentDescription;
        mActions= other.mActions;
        mBooleanProperties = other.mBooleanProperties;
        mChildAccessibilityIds = other.mChildAccessibilityIds.clone();
        // ---------- Original Method ----------
        //mSealed = other.mSealed;
        //mAccessibilityViewId = other.mAccessibilityViewId;
        //mParentAccessibilityViewId = other.mParentAccessibilityViewId;
        //mAccessibilityWindowId = other.mAccessibilityWindowId;
        //mConnectionId = other.mConnectionId;
        //mBoundsInParent.set(other.mBoundsInParent);
        //mBoundsInScreen.set(other.mBoundsInScreen);
        //mPackageName = other.mPackageName;
        //mClassName = other.mClassName;
        //mText = other.mText;
        //mContentDescription = other.mContentDescription;
        //mActions= other.mActions;
        //mBooleanProperties = other.mBooleanProperties;
        //mChildAccessibilityIds = other.mChildAccessibilityIds.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.753 -0400", hash_original_method = "98923D5E356E47505C0A26C0C57920A8", hash_generated_method = "08D32F9AEF640C07DA2EADC3839292F6")
    private void initFromParcel(Parcel parcel) {
        mSealed = (parcel.readInt()  == 1);
        mAccessibilityViewId = parcel.readInt();
        mAccessibilityWindowId = parcel.readInt();
        mParentAccessibilityViewId = parcel.readInt();
        mConnectionId = parcel.readInt();
        SparseIntArray childIds;
        childIds = mChildAccessibilityIds;
        int childrenSize;
        childrenSize = parcel.readInt();
        {
            int i;
            i = 0;
            {
                int childId;
                childId = parcel.readInt();
                childIds.put(i, childId);
            } //End block
        } //End collapsed parenthetic
        mBoundsInParent.top = parcel.readInt();
        mBoundsInParent.bottom = parcel.readInt();
        mBoundsInParent.left = parcel.readInt();
        mBoundsInParent.right = parcel.readInt();
        mBoundsInScreen.top = parcel.readInt();
        mBoundsInScreen.bottom = parcel.readInt();
        mBoundsInScreen.left = parcel.readInt();
        mBoundsInScreen.right = parcel.readInt();
        mActions = parcel.readInt();
        mBooleanProperties = parcel.readInt();
        mPackageName = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mClassName = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mContentDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.754 -0400", hash_original_method = "566B1830900B4F3B865C25C43FCDC943", hash_generated_method = "5FE2D15D610736AC6C78827AD3CDAC8C")
    private void clear() {
        mSealed = false;
        mAccessibilityViewId = UNDEFINED;
        mParentAccessibilityViewId = UNDEFINED;
        mAccessibilityWindowId = UNDEFINED;
        mConnectionId = UNDEFINED;
        mChildAccessibilityIds.clear();
        mBoundsInParent.set(0, 0, 0, 0);
        mBoundsInScreen.set(0, 0, 0, 0);
        mBooleanProperties = 0;
        mPackageName = null;
        mClassName = null;
        mText = null;
        mContentDescription = null;
        mActions = 0;
        // ---------- Original Method ----------
        //mSealed = false;
        //mAccessibilityViewId = UNDEFINED;
        //mParentAccessibilityViewId = UNDEFINED;
        //mAccessibilityWindowId = UNDEFINED;
        //mConnectionId = UNDEFINED;
        //mChildAccessibilityIds.clear();
        //mBoundsInParent.set(0, 0, 0, 0);
        //mBoundsInScreen.set(0, 0, 0, 0);
        //mBooleanProperties = 0;
        //mPackageName = null;
        //mClassName = null;
        //mText = null;
        //mContentDescription = null;
        //mActions = 0;
    }

    
        private static String getActionSymbolicName(int action) {
        switch (action) {
            case ACTION_FOCUS:
                return "ACTION_FOCUS";
            case ACTION_CLEAR_FOCUS:
                return "ACTION_CLEAR_FOCUS";
            case ACTION_SELECT:
                return "ACTION_SELECT";
            case ACTION_CLEAR_SELECTION:
                return "ACTION_CLEAR_SELECTION";
            default:
                throw new IllegalArgumentException("Unknown action: " + action);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.765 -0400", hash_original_method = "554416B444549B4EB33FDEE3DD8518FA", hash_generated_method = "E1000B0D445570280A45C617AF55FA7D")
    private boolean canPerformRequestOverConnection(int accessibilityViewId) {
        addTaint(accessibilityViewId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_13474418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_13474418;
        // ---------- Original Method ----------
        //return (mConnectionId != UNDEFINED && mAccessibilityWindowId != UNDEFINED
                //&& accessibilityViewId != UNDEFINED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.770 -0400", hash_original_method = "75F2609B8EC69930F0DC5E65EF5711F8", hash_generated_method = "74B4C426383B9F38D194466EE97659AD")
    @Override
    public boolean equals(Object object) {
        {
            boolean var9B6B3A9EF19915DD9EB4EA755CD0D0E4_1802897815 = (getClass() != object.getClass());
        } //End collapsed parenthetic
        AccessibilityNodeInfo other;
        other = (AccessibilityNodeInfo) object;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_264333180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_264333180;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (object == null) {
            //return false;
        //}
        //if (getClass() != object.getClass()) {
            //return false;
        //}
        //AccessibilityNodeInfo other = (AccessibilityNodeInfo) object;
        //if (mAccessibilityViewId != other.mAccessibilityViewId) {
            //return false;
        //}
        //if (mAccessibilityWindowId != other.mAccessibilityWindowId) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.771 -0400", hash_original_method = "5729DB4BFFEF2935F7B53D1FC3170C4A", hash_generated_method = "A37040439191BB0D09CDE4AB822C63BD")
    @Override
    public int hashCode() {
        int prime;
        prime = 31;
        int result;
        result = 1;
        result = prime * result + mAccessibilityViewId;
        result = prime * result + mAccessibilityWindowId;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103311330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103311330;
        // ---------- Original Method ----------
        //final int prime = 31;
        //int result = 1;
        //result = prime * result + mAccessibilityViewId;
        //result = prime * result + mAccessibilityWindowId;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_method = "9C50A737351E97FBF1CC9E56A50E9FD3", hash_generated_method = "8D15117164A734EDF79F4FD0EE817A18")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_412666931 = null; //Variable for return #1
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append(super.toString());
        {
            builder.append("; accessibilityId: " + mAccessibilityViewId);
            builder.append("; parentAccessibilityId: " + mParentAccessibilityViewId);
            SparseIntArray childIds;
            childIds = mChildAccessibilityIds;
            builder.append("; childAccessibilityIds: [");
            {
                int i, count;
                i = 0;
                count = childIds.size();
                {
                    builder.append(childIds.valueAt(i));
                    {
                        builder.append(", ");
                    } //End block
                } //End block
            } //End collapsed parenthetic
            builder.append("]");
        } //End block
        builder.append("; boundsInParent: " + mBoundsInParent);
        builder.append("; boundsInScreen: " + mBoundsInScreen);
        builder.append("; packageName: ").append(mPackageName);
        builder.append("; className: ").append(mClassName);
        builder.append("; text: ").append(mText);
        builder.append("; contentDescription: ").append(mContentDescription);
        builder.append("; checkable: ").append(isCheckable());
        builder.append("; checked: ").append(isChecked());
        builder.append("; focusable: ").append(isFocusable());
        builder.append("; focused: ").append(isFocused());
        builder.append("; selected: ").append(isSelected());
        builder.append("; clickable: ").append(isClickable());
        builder.append("; longClickable: ").append(isLongClickable());
        builder.append("; enabled: ").append(isEnabled());
        builder.append("; password: ").append(isPassword());
        builder.append("; scrollable: " + isScrollable());
        builder.append("; [");
        {
            int actionBits;
            actionBits = mActions;
            {
                int action;
                action = 1 << Integer.numberOfTrailingZeros(actionBits);
                actionBits &= ~action;
                builder.append(getActionSymbolicName(action));
                {
                    builder.append(", ");
                } //End block
            } //End block
        } //End collapsed parenthetic
        builder.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_412666931 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_412666931.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_412666931;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "B0556DBFDA5EBCB4F93633B3431D8471", hash_generated_field = "33A8DCF77DD546A1C2829AFEA3F697C8")

    private static int UNDEFINED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "88C2D1887EB31B570369B487597D045B", hash_generated_field = "F5FAE335945DC9AAC45448FAE7461FBF")

    public static final int ACTION_FOCUS =  0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "1BA8A453AF0935765BB13E51D3B78770", hash_generated_field = "4E51052F791AAD7CED4606387206AC02")

    public static final int ACTION_CLEAR_FOCUS =  0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "1B92A207713BC68EA97823DAC23B10A2", hash_generated_field = "D94F4C12E9D93257353DF25CED690B59")

    public static final int ACTION_SELECT =  0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "61076BF1E4699C26E8B0724E793847FD", hash_generated_field = "A07F23DA35D396F8F58D59EF3496C08F")

    public static final int ACTION_CLEAR_SELECTION =  0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "2952DB6A1EE12860CC22261E1477371D", hash_generated_field = "5F467088866DED4ED5BF9349E80EAB8C")

    private static int PROPERTY_CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "F490FD4A70BE77AE161F0E5C29DF1AF3", hash_generated_field = "0061D7780C2905EA7B98A6B1EAAF13E7")

    private static int PROPERTY_CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "62ADE40F8DB68365DB214E92E9E3C9D9", hash_generated_field = "C7EC3A2F897D689849A0C03C4D3CCE2F")

    private static int PROPERTY_FOCUSABLE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "F58CA985C15744C3D2AC1BBE5342F64F", hash_generated_field = "9E485CF21D2513BDE25E4E8CA9C95FE0")

    private static int PROPERTY_FOCUSED = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "877449C6F565D61D170EA3697E57F097", hash_generated_field = "869071895A14D68F7EF9ED3D1314AE71")

    private static int PROPERTY_SELECTED = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "FDA536785DFC7FAA2E67586DFB7024C1", hash_generated_field = "111D224563C4FC9C3EA5B531815E9B8E")

    private static int PROPERTY_CLICKABLE = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "FEB81DAE0699A15E1D1209D84EB998E1", hash_generated_field = "69CAD638BA12BE724F2C1A3A9C8BC1EF")

    private static int PROPERTY_LONG_CLICKABLE = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "882D26A64C775BC28801858A34F7A9B1", hash_generated_field = "BD1643DB3F5286E8ED2CAE59086612C0")

    private static int PROPERTY_ENABLED = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "E08214375BA496133727F5F83EA10446", hash_generated_field = "B88E9CF5AA3AA583DEFA9DE834885650")

    private static int PROPERTY_PASSWORD = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "580A2D6BD2EEDF34BC991B74664F5C7B", hash_generated_field = "2378EAA9A91C2FB3670B5B1B4C2CC71C")

    private static int PROPERTY_SCROLLABLE = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "1E360684FB05B3013BF83AB3BCE86677", hash_generated_field = "F9E6424A85600FAD3501B067FDAEB6DA")

    private static int MAX_POOL_SIZE = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "0948632EF09E2DCA187883CC60BCD1E4", hash_generated_field = "D17501A54B3B4439D5926B465D95D3AD")

    private static Object sPoolLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "50C4A0969A9F745384C40275BD9580FD")

    private static AccessibilityNodeInfo sPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "F402B52BA7964DFA741C4EF5BBB4414B", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.860 -0400", hash_original_field = "5097BB38EB77934CDA5C991495565266", hash_generated_field = "CB2EF8290F0A294F0EAA84E012A5BB22")

    public static final Parcelable.Creator<AccessibilityNodeInfo> CREATOR =
            new Parcelable.Creator<AccessibilityNodeInfo>() {
        public AccessibilityNodeInfo createFromParcel(Parcel parcel) {
            AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
            info.initFromParcel(parcel);
            return info;
        }

        public AccessibilityNodeInfo[] newArray(int size) {
            return new AccessibilityNodeInfo[size];
        }
    };
}

