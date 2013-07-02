package android.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.383 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "C62243493B3195CCB3CA5EBD27BBE8A1")

    private AccessibilityNodeInfo mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "B94200C48C7563C1FA86222302A87F95", hash_generated_field = "12FC58788D16ADAE0F5394F898FD4D99")

    private boolean mIsInPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "61DB78BD493651DCACB5FB89D74B835B", hash_generated_field = "F484C63B720CA97398F62D332F1EF674")

    private boolean mSealed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "33C37173D4FB16E9C2705DDC9871E235", hash_generated_field = "3F1B7BC9DC0772DFCA42C4ED21C8C0B3")

    private int mAccessibilityViewId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "AE07E63782A3DEF23A551D477FAC2C5B", hash_generated_field = "5DFC012BAE7B65B646562BF7E0C7F019")

    private int mAccessibilityWindowId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "615FE12157FB42EA8FEFDA0C9776E388", hash_generated_field = "ABBA6AEAFA3976D0777A287768B773F5")

    private int mParentAccessibilityViewId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "ED189995ED191C4589F06A64BF0FDC1E", hash_generated_field = "1B6EE350CEE9B789577F337242F99452")

    private int mBooleanProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "48B2C313D890E0D9A3FF0100964C217F", hash_generated_field = "D5987B3B232B41265934DB1B170A316C")

    private final Rect mBoundsInParent = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "F6756A24324F7884089A690FFAF75E3A", hash_generated_field = "EF4F29E41A2E9E11614CC0EF1E072CFA")

    private final Rect mBoundsInScreen = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6A9DFBEC5628781E76307C090C363D49")

    private CharSequence mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "E65EE2088107B60FFFC2528EC1FA049B")

    private CharSequence mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "073D0187C9F61FAD4E5B0B851BDDC2B3", hash_generated_field = "8594C4137F32107058E48C17931382B5")

    private CharSequence mContentDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "56BB1D059EE24D6976234EF3223694E5", hash_generated_field = "6EE62237A17F69CD965F14880008505D")

    private SparseIntArray mChildAccessibilityIds = new SparseIntArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "C268D719F2F67098628D1A8EEBB72B48", hash_generated_field = "BAF3D762CB2D0F96BFE73E57C2472173")

    private int mActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_field = "8EAF73743CC459D107527502BC394C97", hash_generated_field = "19848A63CACE6F8B90BC11DC69A6EB80")

    private int mConnectionId = UNDEFINED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.384 -0400", hash_original_method = "EB9F4328D2282B04E1BD31B0186E73D5", hash_generated_method = "176EFD0A62B716335FDF7CEAA647EEC5")
    private  AccessibilityNodeInfo() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.385 -0400", hash_original_method = "D6E0A07A0224052514955EB47C47B111", hash_generated_method = "C23446C48003D369C9072D325F17D89E")
    public void setSource(View source) {
        enforceNotSealed();
        mAccessibilityViewId = source.getAccessibilityViewId();
        mAccessibilityWindowId = source.getAccessibilityWindowId();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.385 -0400", hash_original_method = "6C41AAD35FD64A253FB83D406AD6C88C", hash_generated_method = "6C004043679CBE14FD198CFB035EE371")
    public int getWindowId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406304046 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406304046;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.385 -0400", hash_original_method = "7C8926FBBCF561C891F2F5FFEAFED8AF", hash_generated_method = "C725D7CF6FEF6A2FC70E1C470E112AB8")
    public int getChildCount() {
        int var319A3D2E0BF4719DB1F3ABFECD3065BB_2096230270 = (mChildAccessibilityIds.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994801780 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994801780;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.386 -0400", hash_original_method = "E9093B8E79E0C35ACECC8F5F72DA0B71", hash_generated_method = "FE46608D53E2C09FFF0E5721596FB3EF")
    public AccessibilityNodeInfo getChild(int index) {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_639126463 = null; 
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_1190302384 = null; 
        enforceSealed();
        final int childAccessibilityViewId = mChildAccessibilityIds.get(index);
        {
            boolean varB4030DB148F9B166EB2AAB9777FB5D27_658466813 = (!canPerformRequestOverConnection(childAccessibilityViewId));
            {
                varB4EAC82CA7396A68D541C85D26508E83_639126463 = null;
            } 
        } 
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        varB4EAC82CA7396A68D541C85D26508E83_1190302384 = client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, childAccessibilityViewId);
        addTaint(index);
        AccessibilityNodeInfo varA7E53CE21691AB073D9660D615818899_1993035596; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1993035596 = varB4EAC82CA7396A68D541C85D26508E83_639126463;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1993035596 = varB4EAC82CA7396A68D541C85D26508E83_1190302384;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1993035596.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1993035596;
        
        
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.386 -0400", hash_original_method = "DCE0377A8D2F3327097D2FFFE36C9D81", hash_generated_method = "F0944A8D2B43C78023AE3CC8D2847E9B")
    public void addChild(View child) {
        enforceNotSealed();
        final int childAccessibilityViewId = child.getAccessibilityViewId();
        final int index = mChildAccessibilityIds.size();
        mChildAccessibilityIds.put(index, childAccessibilityViewId);
        addTaint(child.getTaint());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.387 -0400", hash_original_method = "60E376BAD814E27A83B622ADA78DD695", hash_generated_method = "DFCA1DB6AA5A3F3891DD474FE3D034C1")
    public int getActions() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915993165 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915993165;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.387 -0400", hash_original_method = "62A0FADACCC1DF1A8E35D414239187E3", hash_generated_method = "08C8909FE1EC08FC2D37082D7B66DC91")
    public void addAction(int action) {
        enforceNotSealed();
        mActions |= action;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.388 -0400", hash_original_method = "CDA2E61C3267971FAEFED5DF1BBF4146", hash_generated_method = "10296F811C3D744E990E4DBDD2DE412D")
    public boolean performAction(int action) {
        enforceSealed();
        {
            boolean var721560EFD3BEE97481FFB7EC61BDACA3_541276957 = (!canPerformRequestOverConnection(mAccessibilityViewId));
        } 
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        boolean var7A46E79558E217C344F969075A75CE02_1407640782 = (client.performAccessibilityAction(mConnectionId, mAccessibilityWindowId,
                mAccessibilityViewId, action));
        addTaint(action);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650507928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650507928;
        
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.388 -0400", hash_original_method = "DAAF9FBDD74DB58981A13A4C1D5FEB20", hash_generated_method = "A3E4E742FBF03B564FA999F72164F14C")
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text) {
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_1182331140 = null; 
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_1663744416 = null; 
        enforceSealed();
        {
            boolean var721560EFD3BEE97481FFB7EC61BDACA3_243040206 = (!canPerformRequestOverConnection(mAccessibilityViewId));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1182331140 = Collections.emptyList();
            } 
        } 
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        varB4EAC82CA7396A68D541C85D26508E83_1663744416 = client.findAccessibilityNodeInfosByViewText(mConnectionId, text,
                mAccessibilityWindowId, mAccessibilityViewId);
        addTaint(text.getTaint());
        List<AccessibilityNodeInfo> varA7E53CE21691AB073D9660D615818899_1341384718; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1341384718 = varB4EAC82CA7396A68D541C85D26508E83_1182331140;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1341384718 = varB4EAC82CA7396A68D541C85D26508E83_1663744416;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1341384718.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1341384718;
        
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.389 -0400", hash_original_method = "F4DB109D13E56E0D98A6319CC588873D", hash_generated_method = "2B7FCC510850945AB4B16B6B2EF55167")
    public AccessibilityNodeInfo getParent() {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_1262632730 = null; 
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_338860949 = null; 
        enforceSealed();
        {
            boolean varE5EB0B5D9D4BC6B936730052406791C1_384036786 = (!canPerformRequestOverConnection(mParentAccessibilityViewId));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1262632730 = null;
            } 
        } 
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        varB4EAC82CA7396A68D541C85D26508E83_338860949 = client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, mParentAccessibilityViewId);
        AccessibilityNodeInfo varA7E53CE21691AB073D9660D615818899_1102254183; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1102254183 = varB4EAC82CA7396A68D541C85D26508E83_1262632730;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1102254183 = varB4EAC82CA7396A68D541C85D26508E83_338860949;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1102254183.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1102254183;
        
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.389 -0400", hash_original_method = "0FE0BB8E7E891FFE4D867C8196AE43B4", hash_generated_method = "256BE2BB0D6BEB9BC66C3F9B14E2875E")
    public void setParent(View parent) {
        enforceNotSealed();
        mParentAccessibilityViewId = parent.getAccessibilityViewId();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.390 -0400", hash_original_method = "908AD8B1395D82502A9E3BA629915EF5", hash_generated_method = "50A3FCFE786BB8EAC72B918CF76B31D7")
    public void getBoundsInParent(Rect outBounds) {
        outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                mBoundsInParent.right, mBoundsInParent.bottom);
        addTaint(outBounds.getTaint());
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.390 -0400", hash_original_method = "DC2A2D1F16BCFDB8F09D047ED8729F2A", hash_generated_method = "29B8C67796D4B0620EC99AD2E50D3A7F")
    public void setBoundsInParent(Rect bounds) {
        enforceNotSealed();
        mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        addTaint(bounds.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.390 -0400", hash_original_method = "2F98E8EF78DCE8F1C352462875EB84AE", hash_generated_method = "2454C53EA419C285996ED467B6FC2879")
    public void getBoundsInScreen(Rect outBounds) {
        outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                mBoundsInScreen.right, mBoundsInScreen.bottom);
        addTaint(outBounds.getTaint());
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.391 -0400", hash_original_method = "770F78071B2EB9D2396840AB4AD2ADB5", hash_generated_method = "0D2011E9F8AE45F813C5588B18FF80BA")
    public void setBoundsInScreen(Rect bounds) {
        enforceNotSealed();
        mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        addTaint(bounds.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.391 -0400", hash_original_method = "67B4AEAF1632FE4AAC04770D8458ACB9", hash_generated_method = "E040388F9ACF5C53CE808DC2056E5423")
    public boolean isCheckable() {
        boolean var3266C6B4E549BCADC450908FD96A217C_1292219266 = (getBooleanProperty(PROPERTY_CHECKABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_609228130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_609228130;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.391 -0400", hash_original_method = "516AC58EA6CB8A6948778CD704999386", hash_generated_method = "99873B0DA6A752907003B1A45549B048")
    public void setCheckable(boolean checkable) {
        setBooleanProperty(PROPERTY_CHECKABLE, checkable);
        addTaint(checkable);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.391 -0400", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "755B19A9F543D306E6575C6B6E7A11AD")
    public boolean isChecked() {
        boolean var452C23D949DE68DF158EF7F75ABFD98B_1105543451 = (getBooleanProperty(PROPERTY_CHECKED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388839037 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_388839037;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.392 -0400", hash_original_method = "930075A9DA99BE3539B9BAFC112A5160", hash_generated_method = "7B50F8EEFC991F22DFE85D84B226B03B")
    public void setChecked(boolean checked) {
        setBooleanProperty(PROPERTY_CHECKED, checked);
        addTaint(checked);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.392 -0400", hash_original_method = "BEA45F3FF1A12FCE09D72D148357CE2C", hash_generated_method = "322930A4A460F4A1072687BF44EFCDAC")
    public boolean isFocusable() {
        boolean varAEDFD7054BC897AF8637C74153A7FF42_187823969 = (getBooleanProperty(PROPERTY_FOCUSABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097350728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097350728;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.392 -0400", hash_original_method = "A4FE2C9F5A8AC78848A5BB7FA1A98C8F", hash_generated_method = "CF5AA9A35146B6E9DE18F4B04E0FCF09")
    public void setFocusable(boolean focusable) {
        setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
        addTaint(focusable);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.392 -0400", hash_original_method = "3CD3FFF6959365D82FD80FF1FA237F64", hash_generated_method = "65F2CA2896E10A0444B13C81F36163A0")
    public boolean isFocused() {
        boolean var62148897FE29AC5CF93DA794C2584E47_898831010 = (getBooleanProperty(PROPERTY_FOCUSED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685040645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685040645;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.393 -0400", hash_original_method = "6C2B5793CEDC3F6B1248DAB365B53404", hash_generated_method = "CF9D6D51D488151C8D916057757CA8A8")
    public void setFocused(boolean focused) {
        setBooleanProperty(PROPERTY_FOCUSED, focused);
        addTaint(focused);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.393 -0400", hash_original_method = "0C97805A247814CF6CABD75572FD40C1", hash_generated_method = "6860AA9FC3128C930C3D3232EB82F934")
    public boolean isSelected() {
        boolean var4935841C6821896C6C87075392A6DADA_1722724855 = (getBooleanProperty(PROPERTY_SELECTED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1603611861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1603611861;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.393 -0400", hash_original_method = "0890254D4AC82258F1AAEA57F8827B54", hash_generated_method = "936DA108DE4F9C5A6C22B004D6AD49F6")
    public void setSelected(boolean selected) {
        setBooleanProperty(PROPERTY_SELECTED, selected);
        addTaint(selected);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.393 -0400", hash_original_method = "9E42D14BA1D4CF35C9E8D228C35BEE02", hash_generated_method = "67269E0DAC1D320BD54E46EDAC89DDD9")
    public boolean isClickable() {
        boolean var619B1840FC15914C5C371F60FFBB44CD_647000786 = (getBooleanProperty(PROPERTY_CLICKABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025582734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025582734;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.394 -0400", hash_original_method = "2AB4084D18C97615027F882B075290EA", hash_generated_method = "0DD09E0A98FFB5CA51FAEF087050469C")
    public void setClickable(boolean clickable) {
        setBooleanProperty(PROPERTY_CLICKABLE, clickable);
        addTaint(clickable);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.394 -0400", hash_original_method = "30EDA8A2E8A402543ACC7CC56FF92053", hash_generated_method = "5B9C3B787BEA0D64EE01A237CD6DC30E")
    public boolean isLongClickable() {
        boolean var28D1637359B227432B5AA37481E68E9B_1578915454 = (getBooleanProperty(PROPERTY_LONG_CLICKABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627189405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627189405;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.394 -0400", hash_original_method = "BBEB96E07778625102E9D70952371D0D", hash_generated_method = "6A497E2FA2B35AE888413DE38EDC126D")
    public void setLongClickable(boolean longClickable) {
        setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
        addTaint(longClickable);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.394 -0400", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "3B765B19AF44262B5316BBEA9502DA31")
    public boolean isEnabled() {
        boolean var8448E9D671258D44185D3F547D298C9D_600261794 = (getBooleanProperty(PROPERTY_ENABLED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362533142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362533142;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.395 -0400", hash_original_method = "2D7E6331314DB7964C417618AC2EB5EA", hash_generated_method = "F9109DCFC5010B7ABD14FA7D9299726B")
    public void setEnabled(boolean enabled) {
        setBooleanProperty(PROPERTY_ENABLED, enabled);
        addTaint(enabled);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.395 -0400", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "6EF0EF527987FDF09B846E18A251D4AA")
    public boolean isPassword() {
        boolean var087326F76FF21A482620141C52E3B799_1715058559 = (getBooleanProperty(PROPERTY_PASSWORD));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_455342889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_455342889;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.395 -0400", hash_original_method = "4C0E98701874539EDF8F49BF5002C98F", hash_generated_method = "3B1C80CD992BF98FDDEE4A82DFB332A9")
    public void setPassword(boolean password) {
        setBooleanProperty(PROPERTY_PASSWORD, password);
        addTaint(password);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.395 -0400", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "139763C0BD34EC780E47ECE1C2F62591")
    public boolean isScrollable() {
        boolean varCF570E94288645DBC38E8B422354A739_2063515401 = (getBooleanProperty(PROPERTY_SCROLLABLE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1911255036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1911255036;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.396 -0400", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "7A2E32DEB4A97AE38DFA3F9DC84484E1")
    public void setScrollable(boolean scrollable) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
        addTaint(scrollable);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.397 -0400", hash_original_method = "6D18CADAD3BE855C953B6A82043EA347", hash_generated_method = "74DF818BD9C26D54152FC533F39EF119")
    public CharSequence getPackageName() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2047307859 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2047307859 = mPackageName;
        varB4EAC82CA7396A68D541C85D26508E83_2047307859.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2047307859;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.398 -0400", hash_original_method = "D35D1C42C7BD5A2BDF03FC6BDBDF64EE", hash_generated_method = "0EF63785D6B95ACB6D9D44BFD3B5249A")
    public void setPackageName(CharSequence packageName) {
        enforceNotSealed();
        mPackageName = packageName;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.399 -0400", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "33B5769A8F9252276961F01F08C1273B")
    public CharSequence getClassName() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1675398702 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1675398702 = mClassName;
        varB4EAC82CA7396A68D541C85D26508E83_1675398702.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1675398702;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.400 -0400", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "14CBE69F155F8289009D8E6C29D09E01")
    public void setClassName(CharSequence className) {
        enforceNotSealed();
        mClassName = className;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.400 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "D9FEBEE9C3AB5DFC5A79EB3616FF96DE")
    public CharSequence getText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_672556828 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_672556828 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_672556828.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_672556828;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.401 -0400", hash_original_method = "B470A357BC33F6D7BBE8C746674F6216", hash_generated_method = "1E87990391DAA5C0EC810623044152A5")
    public void setText(CharSequence text) {
        enforceNotSealed();
        mText = text;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.401 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "0BBE73DA41BC033C1A29CE631799498A")
    public CharSequence getContentDescription() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1271958123 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1271958123 = mContentDescription;
        varB4EAC82CA7396A68D541C85D26508E83_1271958123.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1271958123;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.402 -0400", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "3B296FA70F852F0CC9CE451463E87DC3")
    public void setContentDescription(CharSequence contentDescription) {
        enforceNotSealed();
        mContentDescription = contentDescription;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.402 -0400", hash_original_method = "08ED9648E2048980BB715C0F95464D97", hash_generated_method = "0CCBEEE78D84066008FE6390F0886EAF")
    private boolean getBooleanProperty(int property) {
        addTaint(property);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101402136 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_101402136;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.402 -0400", hash_original_method = "AF4B29064CFE4EC4A14EBB7B9CA58D1B", hash_generated_method = "386107379A26A87BA42022D0B304E282")
    private void setBooleanProperty(int property, boolean value) {
        enforceNotSealed();
        {
            mBooleanProperties |= property;
        } 
        {
            mBooleanProperties &= ~property;
        } 
        addTaint(value);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.403 -0400", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "F7C7CF110AFA05BD358D80D700ADEDC6")
    public void setConnectionId(int connectionId) {
        enforceNotSealed();
        mConnectionId = connectionId;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.403 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C044D1624E37DCDF803D90F41F3C8C27")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227868927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227868927;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.403 -0400", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "0D7B5E4D59CD0A6DD9DDC234474696D4")
    public void setSealed(boolean sealed) {
        mSealed = sealed;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.404 -0400", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "D77F4C414F439874D9973EB673438552")
    public boolean isSealed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660141410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_660141410;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.404 -0400", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "009873347E61D23BDD66B0AEE8EC9215")
    protected void enforceSealed() {
        {
            boolean varD513186271CF3A3D5E081DE87E878208_1019100662 = (!isSealed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot perform this "
                    + "action on a not sealed instance.");
            } 
        } 
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.404 -0400", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "9D7D60F3FDA6BDA018D506CC7F63244F")
    protected void enforceNotSealed() {
        {
            boolean varA822B3442F37011C427DDD3B23C1201F_830584892 = (isSealed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot perform this "
                    + "action on an sealed instance.");
            } 
        } 
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    public static AccessibilityNodeInfo obtain(View source) {
        AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
        info.setSource(source);
        return info;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static AccessibilityNodeInfo obtain(AccessibilityNodeInfo info) {
        AccessibilityNodeInfo infoClone = AccessibilityNodeInfo.obtain();
        infoClone.init(info);
        return infoClone;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.405 -0400", hash_original_method = "E5AEF2A1BB846A92BC2380F50D2ACE39", hash_generated_method = "B8D0E4AEBBE679DC192A6A9B217301F4")
    public void recycle() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Info already recycled!");
        } 
        clear();
        {
            {
                mNext = sPool;
                sPool = this;
                mIsInPool = true;
            } 
        } 
        
        
            
        
        
        
            
                
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.406 -0400", hash_original_method = "CE4668F7872E1547EB7B822B86C2AD44", hash_generated_method = "6EE31941CB268652C437DFA93D44A02F")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(isSealed() ? 1 : 0);
        parcel.writeInt(mAccessibilityViewId);
        parcel.writeInt(mAccessibilityWindowId);
        parcel.writeInt(mParentAccessibilityViewId);
        parcel.writeInt(mConnectionId);
        SparseIntArray childIds = mChildAccessibilityIds;
        final int childIdsSize = childIds.size();
        parcel.writeInt(childIdsSize);
        {
            int i = 0;
            {
                parcel.writeInt(childIds.valueAt(i));
            } 
        } 
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
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.406 -0400", hash_original_method = "84525B5DDEB8A0E58F9024DAD2E7A518", hash_generated_method = "F71AB9EF3C0B3B92859569069D17129D")
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.408 -0400", hash_original_method = "98923D5E356E47505C0A26C0C57920A8", hash_generated_method = "E4F8BAFCA4932653D8205ACF6F0CAAE4")
    private void initFromParcel(Parcel parcel) {
        mSealed = (parcel.readInt()  == 1);
        mAccessibilityViewId = parcel.readInt();
        mAccessibilityWindowId = parcel.readInt();
        mParentAccessibilityViewId = parcel.readInt();
        mConnectionId = parcel.readInt();
        SparseIntArray childIds = mChildAccessibilityIds;
        final int childrenSize = parcel.readInt();
        {
            int i = 0;
            {
                final int childId = parcel.readInt();
                childIds.put(i, childId);
            } 
        } 
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
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.408 -0400", hash_original_method = "566B1830900B4F3B865C25C43FCDC943", hash_generated_method = "5FE2D15D610736AC6C78827AD3CDAC8C")
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.410 -0400", hash_original_method = "554416B444549B4EB33FDEE3DD8518FA", hash_generated_method = "3E139A24274847992C0AE21F77D307FB")
    private boolean canPerformRequestOverConnection(int accessibilityViewId) {
        addTaint(accessibilityViewId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446335158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_446335158;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.411 -0400", hash_original_method = "75F2609B8EC69930F0DC5E65EF5711F8", hash_generated_method = "B64FE4E3D174EDFD6A4DF485E9847D37")
    @Override
    public boolean equals(Object object) {
        {
            boolean var9B6B3A9EF19915DD9EB4EA755CD0D0E4_1333316959 = (getClass() != object.getClass());
        } 
        AccessibilityNodeInfo other = (AccessibilityNodeInfo) object;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1435408888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1435408888;
        
        
            
        
        
            
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.411 -0400", hash_original_method = "5729DB4BFFEF2935F7B53D1FC3170C4A", hash_generated_method = "D04BEBB86ACBFB11ECB4F9CEC990068C")
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + mAccessibilityViewId;
        result = prime * result + mAccessibilityWindowId;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123402934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123402934;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_method = "9C50A737351E97FBF1CC9E56A50E9FD3", hash_generated_method = "657474B75D2229C590057A16A01062DB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1698792183 = null; 
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        {
            builder.append("; accessibilityId: " + mAccessibilityViewId);
            builder.append("; parentAccessibilityId: " + mParentAccessibilityViewId);
            SparseIntArray childIds = mChildAccessibilityIds;
            builder.append("; childAccessibilityIds: [");
            {
                int i = 0;
                int count = childIds.size();
                {
                    builder.append(childIds.valueAt(i));
                    {
                        builder.append(", ");
                    } 
                } 
            } 
            builder.append("]");
        } 
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
            int actionBits = mActions;
            {
                final int action = 1 << Integer.numberOfTrailingZeros(actionBits);
                actionBits &= ~action;
                builder.append(getActionSymbolicName(action));
                {
                    builder.append(", ");
                } 
            } 
        } 
        builder.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_1698792183 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1698792183.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1698792183;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "B0556DBFDA5EBCB4F93633B3431D8471", hash_generated_field = "1E642CC81E6D04170ACE577F1365D5E0")

    private static final int UNDEFINED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "88C2D1887EB31B570369B487597D045B", hash_generated_field = "F5FAE335945DC9AAC45448FAE7461FBF")

    public static final int ACTION_FOCUS =  0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "1BA8A453AF0935765BB13E51D3B78770", hash_generated_field = "4E51052F791AAD7CED4606387206AC02")

    public static final int ACTION_CLEAR_FOCUS =  0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "1B92A207713BC68EA97823DAC23B10A2", hash_generated_field = "D94F4C12E9D93257353DF25CED690B59")

    public static final int ACTION_SELECT =  0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "61076BF1E4699C26E8B0724E793847FD", hash_generated_field = "A07F23DA35D396F8F58D59EF3496C08F")

    public static final int ACTION_CLEAR_SELECTION =  0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "2952DB6A1EE12860CC22261E1477371D", hash_generated_field = "2DB9EAF69D88F72EF9DAB34982534C44")

    private static final int PROPERTY_CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "F490FD4A70BE77AE161F0E5C29DF1AF3", hash_generated_field = "B133AF653A50358AF697DF69A4A6823C")

    private static final int PROPERTY_CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "62ADE40F8DB68365DB214E92E9E3C9D9", hash_generated_field = "64C6A22B8C6EA12FFA53959DB5CB1AC7")

    private static final int PROPERTY_FOCUSABLE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "F58CA985C15744C3D2AC1BBE5342F64F", hash_generated_field = "8DD47CFB08AAE2F1FFE148EF01196F3B")

    private static final int PROPERTY_FOCUSED = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "877449C6F565D61D170EA3697E57F097", hash_generated_field = "A5A68047420291080F1C615B0F6E29B0")

    private static final int PROPERTY_SELECTED = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "FDA536785DFC7FAA2E67586DFB7024C1", hash_generated_field = "50075B897D9CD8F5C6101FBAEA5D5142")

    private static final int PROPERTY_CLICKABLE = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "FEB81DAE0699A15E1D1209D84EB998E1", hash_generated_field = "01EE91AFAC64BC9573F67B7E369DF9C3")

    private static final int PROPERTY_LONG_CLICKABLE = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "882D26A64C775BC28801858A34F7A9B1", hash_generated_field = "1BB05872028AC7F04961CEA7EB5D55AD")

    private static final int PROPERTY_ENABLED = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "E08214375BA496133727F5F83EA10446", hash_generated_field = "FA6F7D63DA0F9656A53E3D8231C0BA60")

    private static final int PROPERTY_PASSWORD = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "580A2D6BD2EEDF34BC991B74664F5C7B", hash_generated_field = "AE0657BD515267A0780C3CEA30967A65")

    private static final int PROPERTY_SCROLLABLE = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "1E360684FB05B3013BF83AB3BCE86677", hash_generated_field = "2494066B81BE88B9C03D3B2C56E53F2B")

    private static final int MAX_POOL_SIZE = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "0948632EF09E2DCA187883CC60BCD1E4", hash_generated_field = "515CCCD8D6622177DD93BECF774D048D")

    private static final Object sPoolLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "50C4A0969A9F745384C40275BD9580FD")

    private static AccessibilityNodeInfo sPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "F402B52BA7964DFA741C4EF5BBB4414B", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.413 -0400", hash_original_field = "5097BB38EB77934CDA5C991495565266", hash_generated_field = "CB2EF8290F0A294F0EAA84E012A5BB22")

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
    
    public AccessibilityNodeInfo createFromParcel(Parcel parcel) {
            AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
            info.initFromParcel(parcel);
            return info;
        }
    
    
    public AccessibilityNodeInfo[] newArray(int size) {
            return new AccessibilityNodeInfo[size];
        }
    
}

