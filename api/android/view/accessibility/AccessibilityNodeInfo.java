package android.view.accessibility;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Collections;
import java.util.List;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;





public class AccessibilityNodeInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.384 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "C62243493B3195CCB3CA5EBD27BBE8A1")

    private AccessibilityNodeInfo mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.384 -0400", hash_original_field = "B94200C48C7563C1FA86222302A87F95", hash_generated_field = "12FC58788D16ADAE0F5394F898FD4D99")

    private boolean mIsInPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.384 -0400", hash_original_field = "61DB78BD493651DCACB5FB89D74B835B", hash_generated_field = "F484C63B720CA97398F62D332F1EF674")

    private boolean mSealed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "33C37173D4FB16E9C2705DDC9871E235", hash_generated_field = "3F1B7BC9DC0772DFCA42C4ED21C8C0B3")

    private int mAccessibilityViewId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "AE07E63782A3DEF23A551D477FAC2C5B", hash_generated_field = "5DFC012BAE7B65B646562BF7E0C7F019")

    private int mAccessibilityWindowId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "615FE12157FB42EA8FEFDA0C9776E388", hash_generated_field = "ABBA6AEAFA3976D0777A287768B773F5")

    private int mParentAccessibilityViewId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "ED189995ED191C4589F06A64BF0FDC1E", hash_generated_field = "1B6EE350CEE9B789577F337242F99452")

    private int mBooleanProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "48B2C313D890E0D9A3FF0100964C217F", hash_generated_field = "D5987B3B232B41265934DB1B170A316C")

    private final Rect mBoundsInParent = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "F6756A24324F7884089A690FFAF75E3A", hash_generated_field = "EF4F29E41A2E9E11614CC0EF1E072CFA")

    private final Rect mBoundsInScreen = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6A9DFBEC5628781E76307C090C363D49")

    private CharSequence mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "E65EE2088107B60FFFC2528EC1FA049B")

    private CharSequence mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "073D0187C9F61FAD4E5B0B851BDDC2B3", hash_generated_field = "8594C4137F32107058E48C17931382B5")

    private CharSequence mContentDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "56BB1D059EE24D6976234EF3223694E5", hash_generated_field = "6EE62237A17F69CD965F14880008505D")

    private SparseIntArray mChildAccessibilityIds = new SparseIntArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "C268D719F2F67098628D1A8EEBB72B48", hash_generated_field = "BAF3D762CB2D0F96BFE73E57C2472173")

    private int mActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_field = "8EAF73743CC459D107527502BC394C97", hash_generated_field = "19848A63CACE6F8B90BC11DC69A6EB80")

    private int mConnectionId = UNDEFINED;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.385 -0400", hash_original_method = "EB9F4328D2282B04E1BD31B0186E73D5", hash_generated_method = "176EFD0A62B716335FDF7CEAA647EEC5")
    private  AccessibilityNodeInfo() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.386 -0400", hash_original_method = "D6E0A07A0224052514955EB47C47B111", hash_generated_method = "C23446C48003D369C9072D325F17D89E")
    public void setSource(View source) {
        enforceNotSealed();
        mAccessibilityViewId = source.getAccessibilityViewId();
        mAccessibilityWindowId = source.getAccessibilityWindowId();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mAccessibilityViewId = source.getAccessibilityViewId();
        //mAccessibilityWindowId = source.getAccessibilityWindowId();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.386 -0400", hash_original_method = "6C41AAD35FD64A253FB83D406AD6C88C", hash_generated_method = "0314E7497556528C7BEE1CF8A2AD865B")
    public int getWindowId() {
        int var4365E7DC00132D2F9694DBF9D3BF42BE_2060822590 = (mAccessibilityWindowId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456311493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456311493;
        // ---------- Original Method ----------
        //return mAccessibilityWindowId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.387 -0400", hash_original_method = "7C8926FBBCF561C891F2F5FFEAFED8AF", hash_generated_method = "FC372434425283BA1E30077BAC9B6EF9")
    public int getChildCount() {
        int var5D1E30E57B62486D8CA9962766CA491C_369021406 = (mChildAccessibilityIds.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499956986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499956986;
        // ---------- Original Method ----------
        //return mChildAccessibilityIds.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.387 -0400", hash_original_method = "E9093B8E79E0C35ACECC8F5F72DA0B71", hash_generated_method = "AB69457CAA0DD64BA7A5CEA6A3A1431D")
    public AccessibilityNodeInfo getChild(int index) {
        addTaint(index);
        enforceSealed();
        final int childAccessibilityViewId = mChildAccessibilityIds.get(index);
        if(!canPerformRequestOverConnection(childAccessibilityViewId))        
        {
AccessibilityNodeInfo var540C13E9E156B687226421B24F2DF178_397563775 =             null;
            var540C13E9E156B687226421B24F2DF178_397563775.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_397563775;
        } //End block
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
AccessibilityNodeInfo varC92A35B1643EA8CF5301A4EFBCC684DC_602632359 =         client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, childAccessibilityViewId);
        varC92A35B1643EA8CF5301A4EFBCC684DC_602632359.addTaint(taint);
        return varC92A35B1643EA8CF5301A4EFBCC684DC_602632359;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.387 -0400", hash_original_method = "DCE0377A8D2F3327097D2FFFE36C9D81", hash_generated_method = "BD4B92A107FDDCBC0E14F32811FCFF60")
    public void addChild(View child) {
        addTaint(child.getTaint());
        enforceNotSealed();
        final int childAccessibilityViewId = child.getAccessibilityViewId();
        final int index = mChildAccessibilityIds.size();
        mChildAccessibilityIds.put(index, childAccessibilityViewId);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //final int childAccessibilityViewId = child.getAccessibilityViewId();
        //final int index = mChildAccessibilityIds.size();
        //mChildAccessibilityIds.put(index, childAccessibilityViewId);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.388 -0400", hash_original_method = "60E376BAD814E27A83B622ADA78DD695", hash_generated_method = "033E56FD0DDC49D78A87913D1EA57131")
    public int getActions() {
        int varC268D719F2F67098628D1A8EEBB72B48_1175559353 = (mActions);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544208112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544208112;
        // ---------- Original Method ----------
        //return mActions;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.388 -0400", hash_original_method = "62A0FADACCC1DF1A8E35D414239187E3", hash_generated_method = "08C8909FE1EC08FC2D37082D7B66DC91")
    public void addAction(int action) {
        enforceNotSealed();
        mActions |= action;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mActions |= action;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.389 -0400", hash_original_method = "CDA2E61C3267971FAEFED5DF1BBF4146", hash_generated_method = "9272315A58C2AB0E6A1EE547C03431C5")
    public boolean performAction(int action) {
        addTaint(action);
        enforceSealed();
        if(!canPerformRequestOverConnection(mAccessibilityViewId))        
        {
            boolean var68934A3E9455FA72420237EB05902327_8553826 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199938997 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_199938997;
        } //End block
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        boolean varF8C007BA421563050B5765A0A57C1C7B_465564560 = (client.performAccessibilityAction(mConnectionId, mAccessibilityWindowId,
                mAccessibilityViewId, action));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_214813683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_214813683;
        // ---------- Original Method ----------
        //enforceSealed();
        //if (!canPerformRequestOverConnection(mAccessibilityViewId)) {
            //return false;
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.performAccessibilityAction(mConnectionId, mAccessibilityWindowId,
                //mAccessibilityViewId, action);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.389 -0400", hash_original_method = "DAAF9FBDD74DB58981A13A4C1D5FEB20", hash_generated_method = "C645B3EC3536571F347855CE09A99F18")
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text) {
        addTaint(text.getTaint());
        enforceSealed();
        if(!canPerformRequestOverConnection(mAccessibilityViewId))        
        {
List<AccessibilityNodeInfo> varB803AB532741AA7D5C2F301CCDDD25F2_2141794551 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_2141794551.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_2141794551;
        } //End block
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
List<AccessibilityNodeInfo> var0BA4ADB9E06655681ABD80E4AD625760_1372051889 =         client.findAccessibilityNodeInfosByViewText(mConnectionId, text,
                mAccessibilityWindowId, mAccessibilityViewId);
        var0BA4ADB9E06655681ABD80E4AD625760_1372051889.addTaint(taint);
        return var0BA4ADB9E06655681ABD80E4AD625760_1372051889;
        // ---------- Original Method ----------
        //enforceSealed();
        //if (!canPerformRequestOverConnection(mAccessibilityViewId)) {
            //return Collections.emptyList();
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.findAccessibilityNodeInfosByViewText(mConnectionId, text,
                //mAccessibilityWindowId, mAccessibilityViewId);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.390 -0400", hash_original_method = "F4DB109D13E56E0D98A6319CC588873D", hash_generated_method = "998701D60D62F934E6888A1A1924B73C")
    public AccessibilityNodeInfo getParent() {
        enforceSealed();
        if(!canPerformRequestOverConnection(mParentAccessibilityViewId))        
        {
AccessibilityNodeInfo var540C13E9E156B687226421B24F2DF178_736233054 =             null;
            var540C13E9E156B687226421B24F2DF178_736233054.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_736233054;
        } //End block
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
AccessibilityNodeInfo var4BAC5B2C9014A2530437B0CC89547791_341583154 =         client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, mParentAccessibilityViewId);
        var4BAC5B2C9014A2530437B0CC89547791_341583154.addTaint(taint);
        return var4BAC5B2C9014A2530437B0CC89547791_341583154;
        // ---------- Original Method ----------
        //enforceSealed();
        //if (!canPerformRequestOverConnection(mParentAccessibilityViewId)) {
            //return null;
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                //mAccessibilityWindowId, mParentAccessibilityViewId);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.390 -0400", hash_original_method = "0FE0BB8E7E891FFE4D867C8196AE43B4", hash_generated_method = "256BE2BB0D6BEB9BC66C3F9B14E2875E")
    public void setParent(View parent) {
        enforceNotSealed();
        mParentAccessibilityViewId = parent.getAccessibilityViewId();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mParentAccessibilityViewId = parent.getAccessibilityViewId();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.391 -0400", hash_original_method = "908AD8B1395D82502A9E3BA629915EF5", hash_generated_method = "5F3B2BBB3BE49ABB0E5AA2CF3915EC85")
    public void getBoundsInParent(Rect outBounds) {
        addTaint(outBounds.getTaint());
        outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                mBoundsInParent.right, mBoundsInParent.bottom);
        // ---------- Original Method ----------
        //outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                //mBoundsInParent.right, mBoundsInParent.bottom);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.391 -0400", hash_original_method = "DC2A2D1F16BCFDB8F09D047ED8729F2A", hash_generated_method = "F835ED4D5158A9BE035A6CFD7ABE79A1")
    public void setBoundsInParent(Rect bounds) {
        addTaint(bounds.getTaint());
        enforceNotSealed();
        mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.391 -0400", hash_original_method = "2F98E8EF78DCE8F1C352462875EB84AE", hash_generated_method = "0BA652C6FFD6B93C1CB6C4EC8741924A")
    public void getBoundsInScreen(Rect outBounds) {
        addTaint(outBounds.getTaint());
        outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                mBoundsInScreen.right, mBoundsInScreen.bottom);
        // ---------- Original Method ----------
        //outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                //mBoundsInScreen.right, mBoundsInScreen.bottom);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.391 -0400", hash_original_method = "770F78071B2EB9D2396840AB4AD2ADB5", hash_generated_method = "D89ADD2FB5FA4D799825110421408724")
    public void setBoundsInScreen(Rect bounds) {
        addTaint(bounds.getTaint());
        enforceNotSealed();
        mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.392 -0400", hash_original_method = "67B4AEAF1632FE4AAC04770D8458ACB9", hash_generated_method = "4D7A2FB02D5EA4A100884BB734F9ADFF")
    public boolean isCheckable() {
        boolean varBC9E295E9CB1845D5EC7B0DF92A879CA_1675996888 = (getBooleanProperty(PROPERTY_CHECKABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70045193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_70045193;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKABLE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.392 -0400", hash_original_method = "516AC58EA6CB8A6948778CD704999386", hash_generated_method = "27A04C6C0E2BE77453736691268FF7BE")
    public void setCheckable(boolean checkable) {
        addTaint(checkable);
        setBooleanProperty(PROPERTY_CHECKABLE, checkable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CHECKABLE, checkable);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.392 -0400", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "3B16C5E4C89B8AAB17AFBD610AF2DB9E")
    public boolean isChecked() {
        boolean var6A0CD5272E311D05E98BCF36FBF20ACD_40738581 = (getBooleanProperty(PROPERTY_CHECKED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680993365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680993365;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.392 -0400", hash_original_method = "930075A9DA99BE3539B9BAFC112A5160", hash_generated_method = "EA43055B40090857B3766252675AAB1D")
    public void setChecked(boolean checked) {
        addTaint(checked);
        setBooleanProperty(PROPERTY_CHECKED, checked);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CHECKED, checked);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.393 -0400", hash_original_method = "BEA45F3FF1A12FCE09D72D148357CE2C", hash_generated_method = "509F5215E2854ED50FFB27366034D160")
    public boolean isFocusable() {
        boolean var67DF1ABBEF8C636E92D7C3AE3FF97500_1921009218 = (getBooleanProperty(PROPERTY_FOCUSABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622249499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622249499;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FOCUSABLE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.393 -0400", hash_original_method = "A4FE2C9F5A8AC78848A5BB7FA1A98C8F", hash_generated_method = "4090F52816BCD71E568AF8076FFC6540")
    public void setFocusable(boolean focusable) {
        addTaint(focusable);
        setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.393 -0400", hash_original_method = "3CD3FFF6959365D82FD80FF1FA237F64", hash_generated_method = "422105B1BE8F75EAB27866C2ECB90468")
    public boolean isFocused() {
        boolean var3366B664013F9495A9131B12E7D50B66_26265094 = (getBooleanProperty(PROPERTY_FOCUSED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_330101473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_330101473;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FOCUSED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.393 -0400", hash_original_method = "6C2B5793CEDC3F6B1248DAB365B53404", hash_generated_method = "50D41A5F3F2F3BF53B302C67F45AA1F9")
    public void setFocused(boolean focused) {
        addTaint(focused);
        setBooleanProperty(PROPERTY_FOCUSED, focused);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_FOCUSED, focused);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.394 -0400", hash_original_method = "0C97805A247814CF6CABD75572FD40C1", hash_generated_method = "699FAE776A22A81AC4875410BA14B831")
    public boolean isSelected() {
        boolean varDB3E340F3D04BA3CF77E3092256ED4F4_521006131 = (getBooleanProperty(PROPERTY_SELECTED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934662126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_934662126;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SELECTED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.394 -0400", hash_original_method = "0890254D4AC82258F1AAEA57F8827B54", hash_generated_method = "5AAE31F12BF68ABBB9B371527D946FC7")
    public void setSelected(boolean selected) {
        addTaint(selected);
        setBooleanProperty(PROPERTY_SELECTED, selected);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_SELECTED, selected);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.394 -0400", hash_original_method = "9E42D14BA1D4CF35C9E8D228C35BEE02", hash_generated_method = "BEB79B144416ED308B31C80168D8F817")
    public boolean isClickable() {
        boolean var60255C3994BDBE0BF0261DAE666DA6C7_1243573189 = (getBooleanProperty(PROPERTY_CLICKABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933350944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_933350944;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CLICKABLE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.394 -0400", hash_original_method = "2AB4084D18C97615027F882B075290EA", hash_generated_method = "AF22AFE3FA955EBAACB8EF04820ECD66")
    public void setClickable(boolean clickable) {
        addTaint(clickable);
        setBooleanProperty(PROPERTY_CLICKABLE, clickable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CLICKABLE, clickable);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.395 -0400", hash_original_method = "30EDA8A2E8A402543ACC7CC56FF92053", hash_generated_method = "379BC777FBC71B0980ECE77CCB6E1DF7")
    public boolean isLongClickable() {
        boolean varD73C24CE6499A1AB3A4BC7051E354876_1659091209 = (getBooleanProperty(PROPERTY_LONG_CLICKABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_301434998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_301434998;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_LONG_CLICKABLE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.395 -0400", hash_original_method = "BBEB96E07778625102E9D70952371D0D", hash_generated_method = "1B6206F977A5E2F6499185EED16BB7CF")
    public void setLongClickable(boolean longClickable) {
        addTaint(longClickable);
        setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.395 -0400", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "22C94441D2190ADEBCE3A832DFDDE964")
    public boolean isEnabled() {
        boolean var6F818D4AF1185DC3F7931FBEF22B2D47_1705945342 = (getBooleanProperty(PROPERTY_ENABLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425500224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425500224;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_ENABLED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.395 -0400", hash_original_method = "2D7E6331314DB7964C417618AC2EB5EA", hash_generated_method = "02DC15FCA8C2C9C2308DB5CB38A1619C")
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        setBooleanProperty(PROPERTY_ENABLED, enabled);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_ENABLED, enabled);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.395 -0400", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "F23C1A6BCFF4A8F371551D1714A392B5")
    public boolean isPassword() {
        boolean varC159D45C2E73AC687CB90727F00FD786_58851454 = (getBooleanProperty(PROPERTY_PASSWORD));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648043029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_648043029;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_PASSWORD);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.395 -0400", hash_original_method = "4C0E98701874539EDF8F49BF5002C98F", hash_generated_method = "924CABD916C3529C0E1109585A09387C")
    public void setPassword(boolean password) {
        addTaint(password);
        setBooleanProperty(PROPERTY_PASSWORD, password);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_PASSWORD, password);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.395 -0400", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "8014CA4A9EAB497B6F8D397E72CD7A26")
    public boolean isScrollable() {
        boolean varA6FFE50E93EDBB77B0E8F1D4016517C5_213458775 = (getBooleanProperty(PROPERTY_SCROLLABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708896133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708896133;
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SCROLLABLE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.396 -0400", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "EAEA71709D852AD68EE8493BBFF49557")
    public void setScrollable(boolean scrollable) {
        addTaint(scrollable);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.396 -0400", hash_original_method = "6D18CADAD3BE855C953B6A82043EA347", hash_generated_method = "5B20AD8AF7E94F36B2837A7F6D97D4C4")
    public CharSequence getPackageName() {
CharSequence var5601F77C1E784C31FA233AB799182FA6_1454201180 =         mPackageName;
        var5601F77C1E784C31FA233AB799182FA6_1454201180.addTaint(taint);
        return var5601F77C1E784C31FA233AB799182FA6_1454201180;
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.396 -0400", hash_original_method = "D35D1C42C7BD5A2BDF03FC6BDBDF64EE", hash_generated_method = "0EF63785D6B95ACB6D9D44BFD3B5249A")
    public void setPackageName(CharSequence packageName) {
        enforceNotSealed();
        mPackageName = packageName;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mPackageName = packageName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.396 -0400", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "8C136F7C56B36E64EA572DAA44B40A8C")
    public CharSequence getClassName() {
CharSequence varDD9C2143734A2F5CB66BF5CFBE75CE5F_1854961307 =         mClassName;
        varDD9C2143734A2F5CB66BF5CFBE75CE5F_1854961307.addTaint(taint);
        return varDD9C2143734A2F5CB66BF5CFBE75CE5F_1854961307;
        // ---------- Original Method ----------
        //return mClassName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.396 -0400", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "14CBE69F155F8289009D8E6C29D09E01")
    public void setClassName(CharSequence className) {
        enforceNotSealed();
        mClassName = className;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mClassName = className;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.396 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "DD659105AD184E5DE74A7F8FB969360B")
    public CharSequence getText() {
CharSequence var7F7ECB4B14362FFBA020956966B29A66_1188647292 =         mText;
        var7F7ECB4B14362FFBA020956966B29A66_1188647292.addTaint(taint);
        return var7F7ECB4B14362FFBA020956966B29A66_1188647292;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.396 -0400", hash_original_method = "B470A357BC33F6D7BBE8C746674F6216", hash_generated_method = "1E87990391DAA5C0EC810623044152A5")
    public void setText(CharSequence text) {
        enforceNotSealed();
        mText = text;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mText = text;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.396 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "C24D63C53F3C5E6AF3BA92B545CC3702")
    public CharSequence getContentDescription() {
CharSequence varDF4802B31F5D315C6875E7B89F1B2E58_1586228216 =         mContentDescription;
        varDF4802B31F5D315C6875E7B89F1B2E58_1586228216.addTaint(taint);
        return varDF4802B31F5D315C6875E7B89F1B2E58_1586228216;
        // ---------- Original Method ----------
        //return mContentDescription;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.396 -0400", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "3B296FA70F852F0CC9CE451463E87DC3")
    public void setContentDescription(CharSequence contentDescription) {
        enforceNotSealed();
        mContentDescription = contentDescription;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mContentDescription = contentDescription;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.396 -0400", hash_original_method = "08ED9648E2048980BB715C0F95464D97", hash_generated_method = "9D2983288BEEA98AF48C43DECADB2BD9")
    private boolean getBooleanProperty(int property) {
        addTaint(property);
        boolean varBDC6E0D6839B183B2AD4B3EE6D6FF06C_1849489460 = ((mBooleanProperties & property) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1723770420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1723770420;
        // ---------- Original Method ----------
        //return (mBooleanProperties & property) != 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.397 -0400", hash_original_method = "AF4B29064CFE4EC4A14EBB7B9CA58D1B", hash_generated_method = "65624F481E0F4E60D4A401EB502142E3")
    private void setBooleanProperty(int property, boolean value) {
        addTaint(value);
        enforceNotSealed();
        if(value)        
        {
            mBooleanProperties |= property;
        } //End block
        else
        {
            mBooleanProperties &= ~property;
        } //End block
        // ---------- Original Method ----------
        //enforceNotSealed();
        //if (value) {
            //mBooleanProperties |= property;
        //} else {
            //mBooleanProperties &= ~property;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.397 -0400", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "F7C7CF110AFA05BD358D80D700ADEDC6")
    public void setConnectionId(int connectionId) {
        enforceNotSealed();
        mConnectionId = connectionId;
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mConnectionId = connectionId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.397 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "435C09EE736BC98ABC87E3B7385ED9A0")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1929852255 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123692368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123692368;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.397 -0400", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "0D7B5E4D59CD0A6DD9DDC234474696D4")
    public void setSealed(boolean sealed) {
        mSealed = sealed;
        // ---------- Original Method ----------
        //mSealed = sealed;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.397 -0400", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "2D58CB732AC163B21BF04D0628194F0F")
    public boolean isSealed() {
        boolean var61DB78BD493651DCACB5FB89D74B835B_1011956767 = (mSealed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383800527 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383800527;
        // ---------- Original Method ----------
        //return mSealed;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.397 -0400", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "2CC82539D951B611ABE4609F734F0292")
    protected void enforceSealed() {
        if(!isSealed())        
        {
            IllegalStateException var652F71AFD0D5CCAA2788B927EF140BB3_1880913833 = new IllegalStateException("Cannot perform this "
                    + "action on a not sealed instance.");
            var652F71AFD0D5CCAA2788B927EF140BB3_1880913833.addTaint(taint);
            throw var652F71AFD0D5CCAA2788B927EF140BB3_1880913833;
        } //End block
        // ---------- Original Method ----------
        //if (!isSealed()) {
            //throw new IllegalStateException("Cannot perform this "
                    //+ "action on a not sealed instance.");
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.398 -0400", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "FF1346978F4D4BDE72338E78A54B1EAE")
    protected void enforceNotSealed() {
        if(isSealed())        
        {
            IllegalStateException var6C39E2F044A2DBD4DB7485B565A80573_1239177364 = new IllegalStateException("Cannot perform this "
                    + "action on an sealed instance.");
            var6C39E2F044A2DBD4DB7485B565A80573_1239177364.addTaint(taint);
            throw var6C39E2F044A2DBD4DB7485B565A80573_1239177364;
        } //End block
        // ---------- Original Method ----------
        //if (isSealed()) {
            //throw new IllegalStateException("Cannot perform this "
                    //+ "action on an sealed instance.");
        //}
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.398 -0400", hash_original_method = "E5AEF2A1BB846A92BC2380F50D2ACE39", hash_generated_method = "D1D51852E3220EF312FEE6B9E9394220")
    public void recycle() {
        if(mIsInPool)        
        {
            IllegalStateException var5026995F17B50D98874CDB53EAB74C93_42120297 = new IllegalStateException("Info already recycled!");
            var5026995F17B50D98874CDB53EAB74C93_42120297.addTaint(taint);
            throw var5026995F17B50D98874CDB53EAB74C93_42120297;
        } //End block
        clear();
        synchronized
(sPoolLock)        {
            if(sPoolSize <= MAX_POOL_SIZE)            
            {
                mNext = sPool;
                sPool = this;
                mIsInPool = true;
                sPoolSize++;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.399 -0400", hash_original_method = "CE4668F7872E1547EB7B822B86C2AD44", hash_generated_method = "CBC60F766D076F8D4D92C29B7AAA9DBA")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeInt(isSealed() ? 1 : 0);
        parcel.writeInt(mAccessibilityViewId);
        parcel.writeInt(mAccessibilityWindowId);
        parcel.writeInt(mParentAccessibilityViewId);
        parcel.writeInt(mConnectionId);
        SparseIntArray childIds = mChildAccessibilityIds;
        final int childIdsSize = childIds.size();
        parcel.writeInt(childIdsSize);
for(int i = 0;i < childIdsSize;i++)
        {
            parcel.writeInt(childIds.valueAt(i));
        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.401 -0400", hash_original_method = "84525B5DDEB8A0E58F9024DAD2E7A518", hash_generated_method = "F71AB9EF3C0B3B92859569069D17129D")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.403 -0400", hash_original_method = "98923D5E356E47505C0A26C0C57920A8", hash_generated_method = "7CD998505F9549607B916B52A1EC0A74")
    private void initFromParcel(Parcel parcel) {
        mSealed = (parcel.readInt()  == 1);
        mAccessibilityViewId = parcel.readInt();
        mAccessibilityWindowId = parcel.readInt();
        mParentAccessibilityViewId = parcel.readInt();
        mConnectionId = parcel.readInt();
        SparseIntArray childIds = mChildAccessibilityIds;
        final int childrenSize = parcel.readInt();
for(int i = 0;i < childrenSize;i++)
        {
            final int childId = parcel.readInt();
            childIds.put(i, childId);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.404 -0400", hash_original_method = "566B1830900B4F3B865C25C43FCDC943", hash_generated_method = "5FE2D15D610736AC6C78827AD3CDAC8C")
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

    
    @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.404 -0400", hash_original_method = "554416B444549B4EB33FDEE3DD8518FA", hash_generated_method = "9A5A8FF01BEDD95680DE60C538C690A8")
    private boolean canPerformRequestOverConnection(int accessibilityViewId) {
        addTaint(accessibilityViewId);
        boolean varFD6256A1C3017C95DE4F0A873AFE797C_1341176957 = ((mConnectionId != UNDEFINED && mAccessibilityWindowId != UNDEFINED
                && accessibilityViewId != UNDEFINED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1437530047 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1437530047;
        // ---------- Original Method ----------
        //return (mConnectionId != UNDEFINED && mAccessibilityWindowId != UNDEFINED
                //&& accessibilityViewId != UNDEFINED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.405 -0400", hash_original_method = "75F2609B8EC69930F0DC5E65EF5711F8", hash_generated_method = "CCEE73D683E60A9CCC126F9BB5E76CF9")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_954249682 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_581060258 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_581060258;
        } //End block
        if(object == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1881571744 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_781923360 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_781923360;
        } //End block
        if(getClass() != object.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1881903110 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656487586 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656487586;
        } //End block
        AccessibilityNodeInfo other = (AccessibilityNodeInfo) object;
        if(mAccessibilityViewId != other.mAccessibilityViewId)        
        {
            boolean var68934A3E9455FA72420237EB05902327_58245952 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1546365386 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1546365386;
        } //End block
        if(mAccessibilityWindowId != other.mAccessibilityWindowId)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1022041158 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2085430504 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2085430504;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1457423353 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_371726963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_371726963;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.407 -0400", hash_original_method = "5729DB4BFFEF2935F7B53D1FC3170C4A", hash_generated_method = "97A7C2F5D38F005BE51929D24119A8B5")
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + mAccessibilityViewId;
        result = prime * result + mAccessibilityWindowId;
        int varB4A88417B3D0170D754C647C30B7216A_2033592671 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391809973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391809973;
        // ---------- Original Method ----------
        //final int prime = 31;
        //int result = 1;
        //result = prime * result + mAccessibilityViewId;
        //result = prime * result + mAccessibilityWindowId;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.409 -0400", hash_original_method = "9C50A737351E97FBF1CC9E56A50E9FD3", hash_generated_method = "EBECC98BDBA686BBC1EDA24217FB9074")
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        if(DEBUG)        
        {
            builder.append("; accessibilityId: " + mAccessibilityViewId);
            builder.append("; parentAccessibilityId: " + mParentAccessibilityViewId);
            SparseIntArray childIds = mChildAccessibilityIds;
            builder.append("; childAccessibilityIds: [");
for(int i = 0, count = childIds.size();i < count;i++)
            {
                builder.append(childIds.valueAt(i));
                if(i < count - 1)                
                {
                    builder.append(", ");
                } //End block
            } //End block
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
for(int actionBits = mActions;actionBits != 0;)
        {
            final int action = 1 << Integer.numberOfTrailingZeros(actionBits);
            actionBits &= ~action;
            builder.append(getActionSymbolicName(action));
            if(actionBits != 0)            
            {
                builder.append(", ");
            } //End block
        } //End block
        builder.append("]");
String varF4CF030572656354ACFDF83FEE21D7A6_1482787541 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_1482787541.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_1482787541;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "B0556DBFDA5EBCB4F93633B3431D8471", hash_generated_field = "1E642CC81E6D04170ACE577F1365D5E0")

    private static final int UNDEFINED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "88C2D1887EB31B570369B487597D045B", hash_generated_field = "F5FAE335945DC9AAC45448FAE7461FBF")

    public static final int ACTION_FOCUS =  0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "1BA8A453AF0935765BB13E51D3B78770", hash_generated_field = "4E51052F791AAD7CED4606387206AC02")

    public static final int ACTION_CLEAR_FOCUS =  0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "1B92A207713BC68EA97823DAC23B10A2", hash_generated_field = "D94F4C12E9D93257353DF25CED690B59")

    public static final int ACTION_SELECT =  0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "61076BF1E4699C26E8B0724E793847FD", hash_generated_field = "A07F23DA35D396F8F58D59EF3496C08F")

    public static final int ACTION_CLEAR_SELECTION =  0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "2952DB6A1EE12860CC22261E1477371D", hash_generated_field = "2DB9EAF69D88F72EF9DAB34982534C44")

    private static final int PROPERTY_CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "F490FD4A70BE77AE161F0E5C29DF1AF3", hash_generated_field = "B133AF653A50358AF697DF69A4A6823C")

    private static final int PROPERTY_CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "62ADE40F8DB68365DB214E92E9E3C9D9", hash_generated_field = "64C6A22B8C6EA12FFA53959DB5CB1AC7")

    private static final int PROPERTY_FOCUSABLE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "F58CA985C15744C3D2AC1BBE5342F64F", hash_generated_field = "8DD47CFB08AAE2F1FFE148EF01196F3B")

    private static final int PROPERTY_FOCUSED = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "877449C6F565D61D170EA3697E57F097", hash_generated_field = "A5A68047420291080F1C615B0F6E29B0")

    private static final int PROPERTY_SELECTED = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.410 -0400", hash_original_field = "FDA536785DFC7FAA2E67586DFB7024C1", hash_generated_field = "50075B897D9CD8F5C6101FBAEA5D5142")

    private static final int PROPERTY_CLICKABLE = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.411 -0400", hash_original_field = "FEB81DAE0699A15E1D1209D84EB998E1", hash_generated_field = "01EE91AFAC64BC9573F67B7E369DF9C3")

    private static final int PROPERTY_LONG_CLICKABLE = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.411 -0400", hash_original_field = "882D26A64C775BC28801858A34F7A9B1", hash_generated_field = "1BB05872028AC7F04961CEA7EB5D55AD")

    private static final int PROPERTY_ENABLED = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.411 -0400", hash_original_field = "E08214375BA496133727F5F83EA10446", hash_generated_field = "FA6F7D63DA0F9656A53E3D8231C0BA60")

    private static final int PROPERTY_PASSWORD = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.411 -0400", hash_original_field = "580A2D6BD2EEDF34BC991B74664F5C7B", hash_generated_field = "AE0657BD515267A0780C3CEA30967A65")

    private static final int PROPERTY_SCROLLABLE = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.411 -0400", hash_original_field = "1E360684FB05B3013BF83AB3BCE86677", hash_generated_field = "2494066B81BE88B9C03D3B2C56E53F2B")

    private static final int MAX_POOL_SIZE = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.411 -0400", hash_original_field = "0948632EF09E2DCA187883CC60BCD1E4", hash_generated_field = "515CCCD8D6622177DD93BECF774D048D")

    private static final Object sPoolLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.411 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "50C4A0969A9F745384C40275BD9580FD")

    private static AccessibilityNodeInfo sPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.411 -0400", hash_original_field = "F402B52BA7964DFA741C4EF5BBB4414B", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.411 -0400", hash_original_field = "5097BB38EB77934CDA5C991495565266", hash_generated_field = "CB2EF8290F0A294F0EAA84E012A5BB22")

    public static final Parcelable.Creator<AccessibilityNodeInfo> CREATOR =
            new Parcelable.Creator<AccessibilityNodeInfo>() {
        public AccessibilityNodeInfo createFromParcel(Parcel parcel) {
            AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
            info.initFromParcel(parcel);
            return info;
        }

        @DSModeled(DSC.SAFE)
        public AccessibilityNodeInfo[] newArray(int size) {
            return new AccessibilityNodeInfo[size];
        }
    };
    // orphaned legacy method
    public AccessibilityNodeInfo createFromParcel(Parcel parcel) {
            AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
            info.initFromParcel(parcel);
            return info;
        }
    
    // orphaned legacy method
    public AccessibilityNodeInfo[] newArray(int size) {
            return new AccessibilityNodeInfo[size];
        }
    
}

