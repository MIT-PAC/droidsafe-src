package android.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import java.util.Collections;
import java.util.List;

public class AccessibilityNodeInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.221 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "C62243493B3195CCB3CA5EBD27BBE8A1")

    private AccessibilityNodeInfo mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.221 -0400", hash_original_field = "B94200C48C7563C1FA86222302A87F95", hash_generated_field = "12FC58788D16ADAE0F5394F898FD4D99")

    private boolean mIsInPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "61DB78BD493651DCACB5FB89D74B835B", hash_generated_field = "F484C63B720CA97398F62D332F1EF674")

    private boolean mSealed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "33C37173D4FB16E9C2705DDC9871E235", hash_generated_field = "3F1B7BC9DC0772DFCA42C4ED21C8C0B3")

    private int mAccessibilityViewId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "AE07E63782A3DEF23A551D477FAC2C5B", hash_generated_field = "5DFC012BAE7B65B646562BF7E0C7F019")

    private int mAccessibilityWindowId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "615FE12157FB42EA8FEFDA0C9776E388", hash_generated_field = "ABBA6AEAFA3976D0777A287768B773F5")

    private int mParentAccessibilityViewId = UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "ED189995ED191C4589F06A64BF0FDC1E", hash_generated_field = "1B6EE350CEE9B789577F337242F99452")

    private int mBooleanProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "48B2C313D890E0D9A3FF0100964C217F", hash_generated_field = "D5987B3B232B41265934DB1B170A316C")

    private final Rect mBoundsInParent = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "F6756A24324F7884089A690FFAF75E3A", hash_generated_field = "EF4F29E41A2E9E11614CC0EF1E072CFA")

    private final Rect mBoundsInScreen = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6A9DFBEC5628781E76307C090C363D49")

    private CharSequence mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "E65EE2088107B60FFFC2528EC1FA049B")

    private CharSequence mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "073D0187C9F61FAD4E5B0B851BDDC2B3", hash_generated_field = "8594C4137F32107058E48C17931382B5")

    private CharSequence mContentDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.222 -0400", hash_original_field = "56BB1D059EE24D6976234EF3223694E5", hash_generated_field = "6EE62237A17F69CD965F14880008505D")

    private SparseIntArray mChildAccessibilityIds = new SparseIntArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.223 -0400", hash_original_field = "C268D719F2F67098628D1A8EEBB72B48", hash_generated_field = "BAF3D762CB2D0F96BFE73E57C2472173")

    private int mActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.223 -0400", hash_original_field = "8EAF73743CC459D107527502BC394C97", hash_generated_field = "19848A63CACE6F8B90BC11DC69A6EB80")

    private int mConnectionId = UNDEFINED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.223 -0400", hash_original_method = "EB9F4328D2282B04E1BD31B0186E73D5", hash_generated_method = "176EFD0A62B716335FDF7CEAA647EEC5")
    private  AccessibilityNodeInfo() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.224 -0400", hash_original_method = "D6E0A07A0224052514955EB47C47B111", hash_generated_method = "C23446C48003D369C9072D325F17D89E")
    public void setSource(View source) {
        enforceNotSealed();
        mAccessibilityViewId = source.getAccessibilityViewId();
        mAccessibilityWindowId = source.getAccessibilityWindowId();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.224 -0400", hash_original_method = "6C41AAD35FD64A253FB83D406AD6C88C", hash_generated_method = "00AB5507BBB009DA1B969C29F2131EBD")
    public int getWindowId() {
        int var4365E7DC00132D2F9694DBF9D3BF42BE_707599006 = (mAccessibilityWindowId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723551142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723551142;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.224 -0400", hash_original_method = "7C8926FBBCF561C891F2F5FFEAFED8AF", hash_generated_method = "17837ACE5F365DB615CFA0F498DFEA3A")
    public int getChildCount() {
        int var5D1E30E57B62486D8CA9962766CA491C_343704354 = (mChildAccessibilityIds.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065077142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065077142;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.224 -0400", hash_original_method = "E9093B8E79E0C35ACECC8F5F72DA0B71", hash_generated_method = "2322C2D5D85B8AC165A393CD903906FE")
    public AccessibilityNodeInfo getChild(int index) {
        addTaint(index);
        enforceSealed();
        final int childAccessibilityViewId = mChildAccessibilityIds.get(index);
    if(!canPerformRequestOverConnection(childAccessibilityViewId))        
        {
AccessibilityNodeInfo var540C13E9E156B687226421B24F2DF178_330092476 =             null;
            var540C13E9E156B687226421B24F2DF178_330092476.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_330092476;
        } 
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
AccessibilityNodeInfo varC92A35B1643EA8CF5301A4EFBCC684DC_546952771 =         client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, childAccessibilityViewId);
        varC92A35B1643EA8CF5301A4EFBCC684DC_546952771.addTaint(taint);
        return varC92A35B1643EA8CF5301A4EFBCC684DC_546952771;
        
        
        
        
            
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.225 -0400", hash_original_method = "DCE0377A8D2F3327097D2FFFE36C9D81", hash_generated_method = "BD4B92A107FDDCBC0E14F32811FCFF60")
    public void addChild(View child) {
        addTaint(child.getTaint());
        enforceNotSealed();
        final int childAccessibilityViewId = child.getAccessibilityViewId();
        final int index = mChildAccessibilityIds.size();
        mChildAccessibilityIds.put(index, childAccessibilityViewId);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.225 -0400", hash_original_method = "60E376BAD814E27A83B622ADA78DD695", hash_generated_method = "6612C756793CC59B500CB09120516F41")
    public int getActions() {
        int varC268D719F2F67098628D1A8EEBB72B48_798803174 = (mActions);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991046153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991046153;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.226 -0400", hash_original_method = "62A0FADACCC1DF1A8E35D414239187E3", hash_generated_method = "08C8909FE1EC08FC2D37082D7B66DC91")
    public void addAction(int action) {
        enforceNotSealed();
        mActions |= action;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.226 -0400", hash_original_method = "CDA2E61C3267971FAEFED5DF1BBF4146", hash_generated_method = "CDD60CC2141D87D6410BC836D3E7BBFA")
    public boolean performAction(int action) {
        addTaint(action);
        enforceSealed();
    if(!canPerformRequestOverConnection(mAccessibilityViewId))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1804584095 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1536126289 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1536126289;
        } 
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        boolean varF8C007BA421563050B5765A0A57C1C7B_137781269 = (client.performAccessibilityAction(mConnectionId, mAccessibilityWindowId,
                mAccessibilityViewId, action));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1082254545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1082254545;
        
        
        
            
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.227 -0400", hash_original_method = "DAAF9FBDD74DB58981A13A4C1D5FEB20", hash_generated_method = "6ACAFE65614A16C90E314556B7B1C72D")
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text) {
        addTaint(text.getTaint());
        enforceSealed();
    if(!canPerformRequestOverConnection(mAccessibilityViewId))        
        {
List<AccessibilityNodeInfo> varB803AB532741AA7D5C2F301CCDDD25F2_1966435343 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_1966435343.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_1966435343;
        } 
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
List<AccessibilityNodeInfo> var0BA4ADB9E06655681ABD80E4AD625760_2033824068 =         client.findAccessibilityNodeInfosByViewText(mConnectionId, text,
                mAccessibilityWindowId, mAccessibilityViewId);
        var0BA4ADB9E06655681ABD80E4AD625760_2033824068.addTaint(taint);
        return var0BA4ADB9E06655681ABD80E4AD625760_2033824068;
        
        
        
            
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.227 -0400", hash_original_method = "F4DB109D13E56E0D98A6319CC588873D", hash_generated_method = "F595EDF3C42CE4FD9157E57ADD309D8A")
    public AccessibilityNodeInfo getParent() {
        enforceSealed();
    if(!canPerformRequestOverConnection(mParentAccessibilityViewId))        
        {
AccessibilityNodeInfo var540C13E9E156B687226421B24F2DF178_1274161678 =             null;
            var540C13E9E156B687226421B24F2DF178_1274161678.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1274161678;
        } 
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
AccessibilityNodeInfo var4BAC5B2C9014A2530437B0CC89547791_1827911268 =         client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, mParentAccessibilityViewId);
        var4BAC5B2C9014A2530437B0CC89547791_1827911268.addTaint(taint);
        return var4BAC5B2C9014A2530437B0CC89547791_1827911268;
        
        
        
            
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.228 -0400", hash_original_method = "0FE0BB8E7E891FFE4D867C8196AE43B4", hash_generated_method = "256BE2BB0D6BEB9BC66C3F9B14E2875E")
    public void setParent(View parent) {
        enforceNotSealed();
        mParentAccessibilityViewId = parent.getAccessibilityViewId();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.228 -0400", hash_original_method = "908AD8B1395D82502A9E3BA629915EF5", hash_generated_method = "5F3B2BBB3BE49ABB0E5AA2CF3915EC85")
    public void getBoundsInParent(Rect outBounds) {
        addTaint(outBounds.getTaint());
        outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                mBoundsInParent.right, mBoundsInParent.bottom);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.228 -0400", hash_original_method = "DC2A2D1F16BCFDB8F09D047ED8729F2A", hash_generated_method = "F835ED4D5158A9BE035A6CFD7ABE79A1")
    public void setBoundsInParent(Rect bounds) {
        addTaint(bounds.getTaint());
        enforceNotSealed();
        mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.229 -0400", hash_original_method = "2F98E8EF78DCE8F1C352462875EB84AE", hash_generated_method = "0BA652C6FFD6B93C1CB6C4EC8741924A")
    public void getBoundsInScreen(Rect outBounds) {
        addTaint(outBounds.getTaint());
        outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                mBoundsInScreen.right, mBoundsInScreen.bottom);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.229 -0400", hash_original_method = "770F78071B2EB9D2396840AB4AD2ADB5", hash_generated_method = "D89ADD2FB5FA4D799825110421408724")
    public void setBoundsInScreen(Rect bounds) {
        addTaint(bounds.getTaint());
        enforceNotSealed();
        mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.230 -0400", hash_original_method = "67B4AEAF1632FE4AAC04770D8458ACB9", hash_generated_method = "9444BEA9D54B91E49224B6683085FA0F")
    public boolean isCheckable() {
        boolean varBC9E295E9CB1845D5EC7B0DF92A879CA_896493166 = (getBooleanProperty(PROPERTY_CHECKABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_467476676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_467476676;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.230 -0400", hash_original_method = "516AC58EA6CB8A6948778CD704999386", hash_generated_method = "27A04C6C0E2BE77453736691268FF7BE")
    public void setCheckable(boolean checkable) {
        addTaint(checkable);
        setBooleanProperty(PROPERTY_CHECKABLE, checkable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.230 -0400", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "346D6FF1B3B477E20709957F0785BE8D")
    public boolean isChecked() {
        boolean var6A0CD5272E311D05E98BCF36FBF20ACD_1247663361 = (getBooleanProperty(PROPERTY_CHECKED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_831387795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_831387795;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.231 -0400", hash_original_method = "930075A9DA99BE3539B9BAFC112A5160", hash_generated_method = "EA43055B40090857B3766252675AAB1D")
    public void setChecked(boolean checked) {
        addTaint(checked);
        setBooleanProperty(PROPERTY_CHECKED, checked);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.231 -0400", hash_original_method = "BEA45F3FF1A12FCE09D72D148357CE2C", hash_generated_method = "B6C4C0689ED4FCD265F3C0EDC7A63F69")
    public boolean isFocusable() {
        boolean var67DF1ABBEF8C636E92D7C3AE3FF97500_1686848755 = (getBooleanProperty(PROPERTY_FOCUSABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779956618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779956618;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.232 -0400", hash_original_method = "A4FE2C9F5A8AC78848A5BB7FA1A98C8F", hash_generated_method = "4090F52816BCD71E568AF8076FFC6540")
    public void setFocusable(boolean focusable) {
        addTaint(focusable);
        setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.232 -0400", hash_original_method = "3CD3FFF6959365D82FD80FF1FA237F64", hash_generated_method = "AC466B63CF536996D2FA62A9CC994CDA")
    public boolean isFocused() {
        boolean var3366B664013F9495A9131B12E7D50B66_493097681 = (getBooleanProperty(PROPERTY_FOCUSED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92356540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92356540;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.233 -0400", hash_original_method = "6C2B5793CEDC3F6B1248DAB365B53404", hash_generated_method = "50D41A5F3F2F3BF53B302C67F45AA1F9")
    public void setFocused(boolean focused) {
        addTaint(focused);
        setBooleanProperty(PROPERTY_FOCUSED, focused);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.233 -0400", hash_original_method = "0C97805A247814CF6CABD75572FD40C1", hash_generated_method = "43D2F8D12314AAC23D8505B66E25FE55")
    public boolean isSelected() {
        boolean varDB3E340F3D04BA3CF77E3092256ED4F4_277068964 = (getBooleanProperty(PROPERTY_SELECTED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500832122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500832122;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.234 -0400", hash_original_method = "0890254D4AC82258F1AAEA57F8827B54", hash_generated_method = "5AAE31F12BF68ABBB9B371527D946FC7")
    public void setSelected(boolean selected) {
        addTaint(selected);
        setBooleanProperty(PROPERTY_SELECTED, selected);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.234 -0400", hash_original_method = "9E42D14BA1D4CF35C9E8D228C35BEE02", hash_generated_method = "760080E3D5A2D0C112A947C34C5E95ED")
    public boolean isClickable() {
        boolean var60255C3994BDBE0BF0261DAE666DA6C7_373625748 = (getBooleanProperty(PROPERTY_CLICKABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546233503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_546233503;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.234 -0400", hash_original_method = "2AB4084D18C97615027F882B075290EA", hash_generated_method = "AF22AFE3FA955EBAACB8EF04820ECD66")
    public void setClickable(boolean clickable) {
        addTaint(clickable);
        setBooleanProperty(PROPERTY_CLICKABLE, clickable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.235 -0400", hash_original_method = "30EDA8A2E8A402543ACC7CC56FF92053", hash_generated_method = "07AA5DADE4A017542A759E51CF9C2D6E")
    public boolean isLongClickable() {
        boolean varD73C24CE6499A1AB3A4BC7051E354876_1506453290 = (getBooleanProperty(PROPERTY_LONG_CLICKABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1426847302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1426847302;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.235 -0400", hash_original_method = "BBEB96E07778625102E9D70952371D0D", hash_generated_method = "1B6206F977A5E2F6499185EED16BB7CF")
    public void setLongClickable(boolean longClickable) {
        addTaint(longClickable);
        setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.235 -0400", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "A6E40CEC2CD2AE517E81492CA3B6166C")
    public boolean isEnabled() {
        boolean var6F818D4AF1185DC3F7931FBEF22B2D47_1502436004 = (getBooleanProperty(PROPERTY_ENABLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252098004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_252098004;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.235 -0400", hash_original_method = "2D7E6331314DB7964C417618AC2EB5EA", hash_generated_method = "02DC15FCA8C2C9C2308DB5CB38A1619C")
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        setBooleanProperty(PROPERTY_ENABLED, enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.235 -0400", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "2FAE6F61E21DE9B89C9AB944F4B61365")
    public boolean isPassword() {
        boolean varC159D45C2E73AC687CB90727F00FD786_552391402 = (getBooleanProperty(PROPERTY_PASSWORD));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295911910 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_295911910;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.236 -0400", hash_original_method = "4C0E98701874539EDF8F49BF5002C98F", hash_generated_method = "924CABD916C3529C0E1109585A09387C")
    public void setPassword(boolean password) {
        addTaint(password);
        setBooleanProperty(PROPERTY_PASSWORD, password);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.236 -0400", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "38F2B32CBDB4CD336A32706E26CB2BE2")
    public boolean isScrollable() {
        boolean varA6FFE50E93EDBB77B0E8F1D4016517C5_101884930 = (getBooleanProperty(PROPERTY_SCROLLABLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_304838437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_304838437;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.236 -0400", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "EAEA71709D852AD68EE8493BBFF49557")
    public void setScrollable(boolean scrollable) {
        addTaint(scrollable);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.236 -0400", hash_original_method = "6D18CADAD3BE855C953B6A82043EA347", hash_generated_method = "BDE7F865570AC27E178B9519A0F75FA7")
    public CharSequence getPackageName() {
CharSequence var5601F77C1E784C31FA233AB799182FA6_2100529234 =         mPackageName;
        var5601F77C1E784C31FA233AB799182FA6_2100529234.addTaint(taint);
        return var5601F77C1E784C31FA233AB799182FA6_2100529234;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.237 -0400", hash_original_method = "D35D1C42C7BD5A2BDF03FC6BDBDF64EE", hash_generated_method = "0EF63785D6B95ACB6D9D44BFD3B5249A")
    public void setPackageName(CharSequence packageName) {
        enforceNotSealed();
        mPackageName = packageName;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.237 -0400", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "8EC7AFE1F4D246E7D73B5DB043354012")
    public CharSequence getClassName() {
CharSequence varDD9C2143734A2F5CB66BF5CFBE75CE5F_1650103374 =         mClassName;
        varDD9C2143734A2F5CB66BF5CFBE75CE5F_1650103374.addTaint(taint);
        return varDD9C2143734A2F5CB66BF5CFBE75CE5F_1650103374;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.237 -0400", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "14CBE69F155F8289009D8E6C29D09E01")
    public void setClassName(CharSequence className) {
        enforceNotSealed();
        mClassName = className;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.238 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "336B25CDB41ADDF7130E8AB3DFD6A56A")
    public CharSequence getText() {
CharSequence var7F7ECB4B14362FFBA020956966B29A66_1720038575 =         mText;
        var7F7ECB4B14362FFBA020956966B29A66_1720038575.addTaint(taint);
        return var7F7ECB4B14362FFBA020956966B29A66_1720038575;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.238 -0400", hash_original_method = "B470A357BC33F6D7BBE8C746674F6216", hash_generated_method = "1E87990391DAA5C0EC810623044152A5")
    public void setText(CharSequence text) {
        enforceNotSealed();
        mText = text;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.238 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "E82CB75E1509701F41B8BA79CFCDF464")
    public CharSequence getContentDescription() {
CharSequence varDF4802B31F5D315C6875E7B89F1B2E58_600849131 =         mContentDescription;
        varDF4802B31F5D315C6875E7B89F1B2E58_600849131.addTaint(taint);
        return varDF4802B31F5D315C6875E7B89F1B2E58_600849131;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.238 -0400", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "3B296FA70F852F0CC9CE451463E87DC3")
    public void setContentDescription(CharSequence contentDescription) {
        enforceNotSealed();
        mContentDescription = contentDescription;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.238 -0400", hash_original_method = "08ED9648E2048980BB715C0F95464D97", hash_generated_method = "F852FEC7FDBC0884A7DEEEDC2FEB7C1A")
    private boolean getBooleanProperty(int property) {
        addTaint(property);
        boolean varBDC6E0D6839B183B2AD4B3EE6D6FF06C_1234089150 = ((mBooleanProperties & property) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_52899118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_52899118;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.239 -0400", hash_original_method = "AF4B29064CFE4EC4A14EBB7B9CA58D1B", hash_generated_method = "65624F481E0F4E60D4A401EB502142E3")
    private void setBooleanProperty(int property, boolean value) {
        addTaint(value);
        enforceNotSealed();
    if(value)        
        {
            mBooleanProperties |= property;
        } 
        else
        {
            mBooleanProperties &= ~property;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.240 -0400", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "F7C7CF110AFA05BD358D80D700ADEDC6")
    public void setConnectionId(int connectionId) {
        enforceNotSealed();
        mConnectionId = connectionId;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.241 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "100DEB31BE1DB33ACD35A1F6C2E094D9")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1322460443 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255295534 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255295534;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.241 -0400", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "0D7B5E4D59CD0A6DD9DDC234474696D4")
    public void setSealed(boolean sealed) {
        mSealed = sealed;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.241 -0400", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "E39BD19696860D73DADB0D72FF020133")
    public boolean isSealed() {
        boolean var61DB78BD493651DCACB5FB89D74B835B_1861216774 = (mSealed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2041059910 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2041059910;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.242 -0400", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "348948A89F24F7D7826C0BC39B56E3C8")
    protected void enforceSealed() {
    if(!isSealed())        
        {
            IllegalStateException var652F71AFD0D5CCAA2788B927EF140BB3_882546863 = new IllegalStateException("Cannot perform this "
                    + "action on a not sealed instance.");
            var652F71AFD0D5CCAA2788B927EF140BB3_882546863.addTaint(taint);
            throw var652F71AFD0D5CCAA2788B927EF140BB3_882546863;
        } 
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.242 -0400", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "B5CAA1195E12C2A726EDBEEEAD4DC587")
    protected void enforceNotSealed() {
    if(isSealed())        
        {
            IllegalStateException var6C39E2F044A2DBD4DB7485B565A80573_1053483646 = new IllegalStateException("Cannot perform this "
                    + "action on an sealed instance.");
            var6C39E2F044A2DBD4DB7485B565A80573_1053483646.addTaint(taint);
            throw var6C39E2F044A2DBD4DB7485B565A80573_1053483646;
        } 
        
        
            
                    
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.244 -0400", hash_original_method = "E5AEF2A1BB846A92BC2380F50D2ACE39", hash_generated_method = "830BAAA2F1EB198C2BE1D5FB6DA861FC")
    public void recycle() {
    if(mIsInPool)        
        {
            IllegalStateException var5026995F17B50D98874CDB53EAB74C93_903554693 = new IllegalStateException("Info already recycled!");
            var5026995F17B50D98874CDB53EAB74C93_903554693.addTaint(taint);
            throw var5026995F17B50D98874CDB53EAB74C93_903554693;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.245 -0400", hash_original_method = "CE4668F7872E1547EB7B822B86C2AD44", hash_generated_method = "CBC60F766D076F8D4D92C29B7AAA9DBA")
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.247 -0400", hash_original_method = "84525B5DDEB8A0E58F9024DAD2E7A518", hash_generated_method = "F71AB9EF3C0B3B92859569069D17129D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.250 -0400", hash_original_method = "98923D5E356E47505C0A26C0C57920A8", hash_generated_method = "7CD998505F9549607B916B52A1EC0A74")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.251 -0400", hash_original_method = "566B1830900B4F3B865C25C43FCDC943", hash_generated_method = "5FE2D15D610736AC6C78827AD3CDAC8C")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.252 -0400", hash_original_method = "554416B444549B4EB33FDEE3DD8518FA", hash_generated_method = "11767EAB40CD656C609270D4CAA35AEE")
    private boolean canPerformRequestOverConnection(int accessibilityViewId) {
        addTaint(accessibilityViewId);
        boolean varFD6256A1C3017C95DE4F0A873AFE797C_619991770 = ((mConnectionId != UNDEFINED && mAccessibilityWindowId != UNDEFINED
                && accessibilityViewId != UNDEFINED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406529282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406529282;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.252 -0400", hash_original_method = "75F2609B8EC69930F0DC5E65EF5711F8", hash_generated_method = "A041689FEB1CF3D8C8BD99514F838CCA")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1645281488 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103346182 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103346182;
        } 
    if(object == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1016189152 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815603677 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815603677;
        } 
    if(getClass() != object.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1518504421 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_73732886 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_73732886;
        } 
        AccessibilityNodeInfo other = (AccessibilityNodeInfo) object;
    if(mAccessibilityViewId != other.mAccessibilityViewId)        
        {
            boolean var68934A3E9455FA72420237EB05902327_552406160 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1621838483 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1621838483;
        } 
    if(mAccessibilityWindowId != other.mAccessibilityWindowId)        
        {
            boolean var68934A3E9455FA72420237EB05902327_749584458 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_328989906 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_328989906;
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1782178351 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882992101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_882992101;
        
        
            
        
        
            
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.253 -0400", hash_original_method = "5729DB4BFFEF2935F7B53D1FC3170C4A", hash_generated_method = "2820665BB74C25BD84F5B400139974D7")
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + mAccessibilityViewId;
        result = prime * result + mAccessibilityWindowId;
        int varB4A88417B3D0170D754C647C30B7216A_2090619536 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_829024381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_829024381;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.256 -0400", hash_original_method = "9C50A737351E97FBF1CC9E56A50E9FD3", hash_generated_method = "B934965B94D9403765550839E75A4ABA")
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
for(int actionBits = mActions;actionBits != 0;)
        {
            final int action = 1 << Integer.numberOfTrailingZeros(actionBits);
            actionBits &= ~action;
            builder.append(getActionSymbolicName(action));
    if(actionBits != 0)            
            {
                builder.append(", ");
            } 
        } 
        builder.append("]");
String varF4CF030572656354ACFDF83FEE21D7A6_967464876 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_967464876.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_967464876;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.256 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.256 -0400", hash_original_field = "B0556DBFDA5EBCB4F93633B3431D8471", hash_generated_field = "1E642CC81E6D04170ACE577F1365D5E0")

    private static final int UNDEFINED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.256 -0400", hash_original_field = "88C2D1887EB31B570369B487597D045B", hash_generated_field = "F5FAE335945DC9AAC45448FAE7461FBF")

    public static final int ACTION_FOCUS =  0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "1BA8A453AF0935765BB13E51D3B78770", hash_generated_field = "4E51052F791AAD7CED4606387206AC02")

    public static final int ACTION_CLEAR_FOCUS =  0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "1B92A207713BC68EA97823DAC23B10A2", hash_generated_field = "D94F4C12E9D93257353DF25CED690B59")

    public static final int ACTION_SELECT =  0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "61076BF1E4699C26E8B0724E793847FD", hash_generated_field = "A07F23DA35D396F8F58D59EF3496C08F")

    public static final int ACTION_CLEAR_SELECTION =  0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "2952DB6A1EE12860CC22261E1477371D", hash_generated_field = "2DB9EAF69D88F72EF9DAB34982534C44")

    private static final int PROPERTY_CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "F490FD4A70BE77AE161F0E5C29DF1AF3", hash_generated_field = "B133AF653A50358AF697DF69A4A6823C")

    private static final int PROPERTY_CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "62ADE40F8DB68365DB214E92E9E3C9D9", hash_generated_field = "64C6A22B8C6EA12FFA53959DB5CB1AC7")

    private static final int PROPERTY_FOCUSABLE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "F58CA985C15744C3D2AC1BBE5342F64F", hash_generated_field = "8DD47CFB08AAE2F1FFE148EF01196F3B")

    private static final int PROPERTY_FOCUSED = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "877449C6F565D61D170EA3697E57F097", hash_generated_field = "A5A68047420291080F1C615B0F6E29B0")

    private static final int PROPERTY_SELECTED = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "FDA536785DFC7FAA2E67586DFB7024C1", hash_generated_field = "50075B897D9CD8F5C6101FBAEA5D5142")

    private static final int PROPERTY_CLICKABLE = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "FEB81DAE0699A15E1D1209D84EB998E1", hash_generated_field = "01EE91AFAC64BC9573F67B7E369DF9C3")

    private static final int PROPERTY_LONG_CLICKABLE = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "882D26A64C775BC28801858A34F7A9B1", hash_generated_field = "1BB05872028AC7F04961CEA7EB5D55AD")

    private static final int PROPERTY_ENABLED = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "E08214375BA496133727F5F83EA10446", hash_generated_field = "FA6F7D63DA0F9656A53E3D8231C0BA60")

    private static final int PROPERTY_PASSWORD = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "580A2D6BD2EEDF34BC991B74664F5C7B", hash_generated_field = "AE0657BD515267A0780C3CEA30967A65")

    private static final int PROPERTY_SCROLLABLE = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "1E360684FB05B3013BF83AB3BCE86677", hash_generated_field = "2494066B81BE88B9C03D3B2C56E53F2B")

    private static final int MAX_POOL_SIZE = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.257 -0400", hash_original_field = "0948632EF09E2DCA187883CC60BCD1E4", hash_generated_field = "515CCCD8D6622177DD93BECF774D048D")

    private static final Object sPoolLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.258 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "50C4A0969A9F745384C40275BD9580FD")

    private static AccessibilityNodeInfo sPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.258 -0400", hash_original_field = "F402B52BA7964DFA741C4EF5BBB4414B", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.258 -0400", hash_original_field = "5097BB38EB77934CDA5C991495565266", hash_generated_field = "CB2EF8290F0A294F0EAA84E012A5BB22")

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

