package android.view.accessibility;

// Droidsafe Imports
import java.util.Collections;
import java.util.List;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class AccessibilityNodeInfo implements Parcelable {
    private static final boolean DEBUG = false;
    private static final int UNDEFINED = -1;
    public static final int ACTION_FOCUS =  0x00000001;
    public static final int ACTION_CLEAR_FOCUS =  0x00000002;
    public static final int ACTION_SELECT =  0x00000004;
    public static final int ACTION_CLEAR_SELECTION =  0x00000008;
    private static final int PROPERTY_CHECKABLE = 0x00000001;
    private static final int PROPERTY_CHECKED = 0x00000002;
    private static final int PROPERTY_FOCUSABLE = 0x00000004;
    private static final int PROPERTY_FOCUSED = 0x00000008;
    private static final int PROPERTY_SELECTED = 0x00000010;
    private static final int PROPERTY_CLICKABLE = 0x00000020;
    private static final int PROPERTY_LONG_CLICKABLE = 0x00000040;
    private static final int PROPERTY_ENABLED = 0x00000080;
    private static final int PROPERTY_PASSWORD = 0x00000100;
    private static final int PROPERTY_SCROLLABLE = 0x00000200;
    private static final int MAX_POOL_SIZE = 50;
    private static final Object sPoolLock = new Object();
    private static AccessibilityNodeInfo sPool;
    private static int sPoolSize;
    private AccessibilityNodeInfo mNext;
    private boolean mIsInPool;
    private boolean mSealed;
    private int mAccessibilityViewId = UNDEFINED;
    private int mAccessibilityWindowId = UNDEFINED;
    private int mParentAccessibilityViewId = UNDEFINED;
    private int mBooleanProperties;
    private final Rect mBoundsInParent = new Rect();
    private final Rect mBoundsInScreen = new Rect();
    private CharSequence mPackageName;
    private CharSequence mClassName;
    private CharSequence mText;
    private CharSequence mContentDescription;
    private SparseIntArray mChildAccessibilityIds = new SparseIntArray();
    private int mActions;
    private int mConnectionId = UNDEFINED;
    public static final Parcelable.Creator<AccessibilityNodeInfo> CREATOR = new Parcelable.Creator<AccessibilityNodeInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.780 -0400", hash_original_method = "41FF7B589DD370C35E95646D230DB9E3", hash_generated_method = "DDD5A8BE71E45D3821D7C34C485258F5")
        @DSModeled(DSC.SAFE)
        public AccessibilityNodeInfo createFromParcel(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            AccessibilityNodeInfo info;
            info = AccessibilityNodeInfo.obtain();
            info.initFromParcel(parcel);
            return (AccessibilityNodeInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
            //info.initFromParcel(parcel);
            //return info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.780 -0400", hash_original_method = "307ED09D70799D6E59BE60B4F21A4B77", hash_generated_method = "E48C74D6B4C9FE57B94AC9F4C58545D6")
        @DSModeled(DSC.SAFE)
        public AccessibilityNodeInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (AccessibilityNodeInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AccessibilityNodeInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.780 -0400", hash_original_method = "EB9F4328D2282B04E1BD31B0186E73D5", hash_generated_method = "2D4C155423AB7A87978A8DFCDD9A1AA5")
    @DSModeled(DSC.SAFE)
    private AccessibilityNodeInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.781 -0400", hash_original_method = "D6E0A07A0224052514955EB47C47B111", hash_generated_method = "24C63CD6161F09A143B683399F866922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSource(View source) {
        dsTaint.addTaint(source.dsTaint);
        enforceNotSealed();
        mAccessibilityViewId = source.getAccessibilityViewId();
        mAccessibilityWindowId = source.getAccessibilityWindowId();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mAccessibilityViewId = source.getAccessibilityViewId();
        //mAccessibilityWindowId = source.getAccessibilityWindowId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.781 -0400", hash_original_method = "6C41AAD35FD64A253FB83D406AD6C88C", hash_generated_method = "57A622A9F1343C55F88B3424FDEA034B")
    @DSModeled(DSC.SAFE)
    public int getWindowId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAccessibilityWindowId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.781 -0400", hash_original_method = "7C8926FBBCF561C891F2F5FFEAFED8AF", hash_generated_method = "EBE1844D3EC6046BB3886D3330822512")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getChildCount() {
        int var319A3D2E0BF4719DB1F3ABFECD3065BB_468328620 = (mChildAccessibilityIds.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mChildAccessibilityIds.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.781 -0400", hash_original_method = "E9093B8E79E0C35ACECC8F5F72DA0B71", hash_generated_method = "A2AEF885E9999A38E3E9E61F755CB20C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityNodeInfo getChild(int index) {
        dsTaint.addTaint(index);
        enforceSealed();
        final int childAccessibilityViewId;
        childAccessibilityViewId = mChildAccessibilityIds.get(index);
        {
            boolean varB4030DB148F9B166EB2AAB9777FB5D27_1429356790 = (!canPerformRequestOverConnection(childAccessibilityViewId));
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        AccessibilityNodeInfo varECEB5B6F0EEE2D787D8B3FDFF3BEB73A_2006610830 = (client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, childAccessibilityViewId));
        return (AccessibilityNodeInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.781 -0400", hash_original_method = "DCE0377A8D2F3327097D2FFFE36C9D81", hash_generated_method = "5650691465820791B80AEAAD1A623F46")
    @DSModeled(DSC.SAFE)
    public void addChild(View child) {
        dsTaint.addTaint(child.dsTaint);
        enforceNotSealed();
        final int childAccessibilityViewId;
        childAccessibilityViewId = child.getAccessibilityViewId();
        final int index;
        index = mChildAccessibilityIds.size();
        mChildAccessibilityIds.put(index, childAccessibilityViewId);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //final int childAccessibilityViewId = child.getAccessibilityViewId();
        //final int index = mChildAccessibilityIds.size();
        //mChildAccessibilityIds.put(index, childAccessibilityViewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.781 -0400", hash_original_method = "60E376BAD814E27A83B622ADA78DD695", hash_generated_method = "2A6143946AC58AF43CBD5982DCC5CFFB")
    @DSModeled(DSC.SAFE)
    public int getActions() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.781 -0400", hash_original_method = "62A0FADACCC1DF1A8E35D414239187E3", hash_generated_method = "40DBDCEC00393CD6D3C53F4D889C1AD4")
    @DSModeled(DSC.SAFE)
    public void addAction(int action) {
        dsTaint.addTaint(action);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mActions |= action;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.781 -0400", hash_original_method = "CDA2E61C3267971FAEFED5DF1BBF4146", hash_generated_method = "941AF84A8191CCB4782E0F8088504F5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performAction(int action) {
        dsTaint.addTaint(action);
        enforceSealed();
        {
            boolean var721560EFD3BEE97481FFB7EC61BDACA3_398043643 = (!canPerformRequestOverConnection(mAccessibilityViewId));
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        boolean var7A46E79558E217C344F969075A75CE02_1272303736 = (client.performAccessibilityAction(mConnectionId, mAccessibilityWindowId,
                mAccessibilityViewId, action));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //enforceSealed();
        //if (!canPerformRequestOverConnection(mAccessibilityViewId)) {
            //return false;
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.performAccessibilityAction(mConnectionId, mAccessibilityWindowId,
                //mAccessibilityViewId, action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.781 -0400", hash_original_method = "DAAF9FBDD74DB58981A13A4C1D5FEB20", hash_generated_method = "513D45D553A3CA5E947E3E7E557AC827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text) {
        dsTaint.addTaint(text);
        enforceSealed();
        {
            boolean var721560EFD3BEE97481FFB7EC61BDACA3_698063525 = (!canPerformRequestOverConnection(mAccessibilityViewId));
            {
                List<AccessibilityNodeInfo> varEAE3A1AA7930C0E7706565D9D889BA86_484119499 = (Collections.emptyList());
            } //End block
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        List<AccessibilityNodeInfo> varA4FD6A3FF643C71BBE45DF66C19AE4E3_928214070 = (client.findAccessibilityNodeInfosByViewText(mConnectionId, text,
                mAccessibilityWindowId, mAccessibilityViewId));
        return (List<AccessibilityNodeInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //enforceSealed();
        //if (!canPerformRequestOverConnection(mAccessibilityViewId)) {
            //return Collections.emptyList();
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.findAccessibilityNodeInfosByViewText(mConnectionId, text,
                //mAccessibilityWindowId, mAccessibilityViewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "F4DB109D13E56E0D98A6319CC588873D", hash_generated_method = "349EB1EB4AF24DD989D921712ED1FC85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityNodeInfo getParent() {
        enforceSealed();
        {
            boolean varE5EB0B5D9D4BC6B936730052406791C1_169091433 = (!canPerformRequestOverConnection(mParentAccessibilityViewId));
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        AccessibilityNodeInfo var286BAA33D1F06FDFC30B8C28E61AA77E_513009145 = (client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, mParentAccessibilityViewId));
        return (AccessibilityNodeInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //enforceSealed();
        //if (!canPerformRequestOverConnection(mParentAccessibilityViewId)) {
            //return null;
        //}
        //AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        //return client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                //mAccessibilityWindowId, mParentAccessibilityViewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "0FE0BB8E7E891FFE4D867C8196AE43B4", hash_generated_method = "79B9CA3164BEC28F510F264704F751F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParent(View parent) {
        dsTaint.addTaint(parent.dsTaint);
        enforceNotSealed();
        mParentAccessibilityViewId = parent.getAccessibilityViewId();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mParentAccessibilityViewId = parent.getAccessibilityViewId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "908AD8B1395D82502A9E3BA629915EF5", hash_generated_method = "BF1E18072C63D3F44957A81F2AEC4EB5")
    @DSModeled(DSC.SAFE)
    public void getBoundsInParent(Rect outBounds) {
        dsTaint.addTaint(outBounds.dsTaint);
        outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                mBoundsInParent.right, mBoundsInParent.bottom);
        // ---------- Original Method ----------
        //outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                //mBoundsInParent.right, mBoundsInParent.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "DC2A2D1F16BCFDB8F09D047ED8729F2A", hash_generated_method = "0D0600824DD59D2661455C39B4C15461")
    @DSModeled(DSC.SAFE)
    public void setBoundsInParent(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        enforceNotSealed();
        mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "2F98E8EF78DCE8F1C352462875EB84AE", hash_generated_method = "A2BDF6CEC79A64E56379369C96B1DF92")
    @DSModeled(DSC.SAFE)
    public void getBoundsInScreen(Rect outBounds) {
        dsTaint.addTaint(outBounds.dsTaint);
        outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                mBoundsInScreen.right, mBoundsInScreen.bottom);
        // ---------- Original Method ----------
        //outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                //mBoundsInScreen.right, mBoundsInScreen.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "770F78071B2EB9D2396840AB4AD2ADB5", hash_generated_method = "8161233E2C449BC479A051DB8C3564D1")
    @DSModeled(DSC.SAFE)
    public void setBoundsInScreen(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        enforceNotSealed();
        mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "67B4AEAF1632FE4AAC04770D8458ACB9", hash_generated_method = "22E28D14BE9C0D2CB00E02C1B63F7064")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCheckable() {
        boolean var3266C6B4E549BCADC450908FD96A217C_1528875683 = (getBooleanProperty(PROPERTY_CHECKABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "516AC58EA6CB8A6948778CD704999386", hash_generated_method = "9CAABF2095CC5C195A4DB0C156635CA2")
    @DSModeled(DSC.SAFE)
    public void setCheckable(boolean checkable) {
        dsTaint.addTaint(checkable);
        setBooleanProperty(PROPERTY_CHECKABLE, checkable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CHECKABLE, checkable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "A1F7A877BF168091FCAB203448CE4BAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isChecked() {
        boolean var452C23D949DE68DF158EF7F75ABFD98B_618664716 = (getBooleanProperty(PROPERTY_CHECKED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "930075A9DA99BE3539B9BAFC112A5160", hash_generated_method = "44B5E92146073AE8323EA3240C8B5653")
    @DSModeled(DSC.SAFE)
    public void setChecked(boolean checked) {
        dsTaint.addTaint(checked);
        setBooleanProperty(PROPERTY_CHECKED, checked);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CHECKED, checked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "BEA45F3FF1A12FCE09D72D148357CE2C", hash_generated_method = "B5A657A4223F4F8174E84A57F80815C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFocusable() {
        boolean varAEDFD7054BC897AF8637C74153A7FF42_1860804511 = (getBooleanProperty(PROPERTY_FOCUSABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FOCUSABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.782 -0400", hash_original_method = "A4FE2C9F5A8AC78848A5BB7FA1A98C8F", hash_generated_method = "198F6DF388EF05522E8FC383FECAF3B0")
    @DSModeled(DSC.SAFE)
    public void setFocusable(boolean focusable) {
        dsTaint.addTaint(focusable);
        setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "3CD3FFF6959365D82FD80FF1FA237F64", hash_generated_method = "BC240994916DE563971D9C9804BE56F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFocused() {
        boolean var62148897FE29AC5CF93DA794C2584E47_399874401 = (getBooleanProperty(PROPERTY_FOCUSED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FOCUSED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "6C2B5793CEDC3F6B1248DAB365B53404", hash_generated_method = "BBE3C2B196181C1DF8A63CF4ACD3CC80")
    @DSModeled(DSC.SAFE)
    public void setFocused(boolean focused) {
        dsTaint.addTaint(focused);
        setBooleanProperty(PROPERTY_FOCUSED, focused);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_FOCUSED, focused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "0C97805A247814CF6CABD75572FD40C1", hash_generated_method = "AFF358E726233988C4F9F6EB193BF596")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSelected() {
        boolean var4935841C6821896C6C87075392A6DADA_858427751 = (getBooleanProperty(PROPERTY_SELECTED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SELECTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "0890254D4AC82258F1AAEA57F8827B54", hash_generated_method = "8FC1162038211B916676A200E67103CA")
    @DSModeled(DSC.SAFE)
    public void setSelected(boolean selected) {
        dsTaint.addTaint(selected);
        setBooleanProperty(PROPERTY_SELECTED, selected);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_SELECTED, selected);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "9E42D14BA1D4CF35C9E8D228C35BEE02", hash_generated_method = "C20381D411FF1BF17F1B756391F53CC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isClickable() {
        boolean var619B1840FC15914C5C371F60FFBB44CD_818206972 = (getBooleanProperty(PROPERTY_CLICKABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CLICKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "2AB4084D18C97615027F882B075290EA", hash_generated_method = "7F0DE3A42F740EEE86B8782B6CB44EEC")
    @DSModeled(DSC.SAFE)
    public void setClickable(boolean clickable) {
        dsTaint.addTaint(clickable);
        setBooleanProperty(PROPERTY_CLICKABLE, clickable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CLICKABLE, clickable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "30EDA8A2E8A402543ACC7CC56FF92053", hash_generated_method = "456F851766F946FB8A5887C8C93F91B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLongClickable() {
        boolean var28D1637359B227432B5AA37481E68E9B_1077825642 = (getBooleanProperty(PROPERTY_LONG_CLICKABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_LONG_CLICKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "BBEB96E07778625102E9D70952371D0D", hash_generated_method = "4B3A2F83DC515F71EC1EB448B938023F")
    @DSModeled(DSC.SAFE)
    public void setLongClickable(boolean longClickable) {
        dsTaint.addTaint(longClickable);
        setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "4313AB5E2BBF28BDCA0A20122EF1AC89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEnabled() {
        boolean var8448E9D671258D44185D3F547D298C9D_319508886 = (getBooleanProperty(PROPERTY_ENABLED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "2D7E6331314DB7964C417618AC2EB5EA", hash_generated_method = "497D74370F7B57BD8B88405415B9AD33")
    @DSModeled(DSC.SAFE)
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setBooleanProperty(PROPERTY_ENABLED, enabled);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_ENABLED, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "E643205BC5F3B76AB4D385A5ABED2D9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPassword() {
        boolean var087326F76FF21A482620141C52E3B799_435783900 = (getBooleanProperty(PROPERTY_PASSWORD));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_PASSWORD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "4C0E98701874539EDF8F49BF5002C98F", hash_generated_method = "AD0FFAD7C4ED189E916EFC23A79F7850")
    @DSModeled(DSC.SAFE)
    public void setPassword(boolean password) {
        dsTaint.addTaint(password);
        setBooleanProperty(PROPERTY_PASSWORD, password);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_PASSWORD, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.783 -0400", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "EB32DD1CDF3E2B8EC69A1E2FBB084C05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isScrollable() {
        boolean varCF570E94288645DBC38E8B422354A739_888121085 = (getBooleanProperty(PROPERTY_SCROLLABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SCROLLABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "0850F71CA259FACEE144F98ECE7B78BC")
    @DSModeled(DSC.SAFE)
    public void setScrollable(boolean scrollable) {
        dsTaint.addTaint(scrollable);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "6D18CADAD3BE855C953B6A82043EA347", hash_generated_method = "D637177C30044592FDB477C6E548F55A")
    @DSModeled(DSC.SAFE)
    public CharSequence getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "D35D1C42C7BD5A2BDF03FC6BDBDF64EE", hash_generated_method = "2C12139E6B97593030C215D96D9E800E")
    @DSModeled(DSC.SAFE)
    public void setPackageName(CharSequence packageName) {
        dsTaint.addTaint(packageName);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mPackageName = packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "12CE1D95578FBA95E1F895EE94145459")
    @DSModeled(DSC.SAFE)
    public CharSequence getClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "2C46E507B75E23042E778D4AE2B45B7E")
    @DSModeled(DSC.SAFE)
    public void setClassName(CharSequence className) {
        dsTaint.addTaint(className);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mClassName = className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "928F7BAE9EC962F9C33EAB96518969CD")
    @DSModeled(DSC.SAFE)
    public CharSequence getText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "B470A357BC33F6D7BBE8C746674F6216", hash_generated_method = "C74DE7D56D07354B52A9E74F6059A2F5")
    @DSModeled(DSC.SAFE)
    public void setText(CharSequence text) {
        dsTaint.addTaint(text);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mText = text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "BA259797571A91EE13C632E0DC69BD69")
    @DSModeled(DSC.SAFE)
    public CharSequence getContentDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mContentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "29AD0327AF051099033CDEE322133B3F")
    @DSModeled(DSC.SAFE)
    public void setContentDescription(CharSequence contentDescription) {
        dsTaint.addTaint(contentDescription);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mContentDescription = contentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "08ED9648E2048980BB715C0F95464D97", hash_generated_method = "E9C9F69C1D94ED1339AC9F0DD9A13DC8")
    @DSModeled(DSC.SAFE)
    private boolean getBooleanProperty(int property) {
        dsTaint.addTaint(property);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mBooleanProperties & property) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "AF4B29064CFE4EC4A14EBB7B9CA58D1B", hash_generated_method = "90A2A38D054373AAE7274EB9ED3582B8")
    @DSModeled(DSC.SAFE)
    private void setBooleanProperty(int property, boolean value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(property);
        enforceNotSealed();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "D9917649F2317A013B65475AA20D26D5")
    @DSModeled(DSC.SAFE)
    public void setConnectionId(int connectionId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(connectionId);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mConnectionId = connectionId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.784 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.785 -0400", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "8165B32CA8C940B710DEA5069E3A1731")
    @DSModeled(DSC.SAFE)
    public void setSealed(boolean sealed) {
        dsTaint.addTaint(sealed);
        // ---------- Original Method ----------
        //mSealed = sealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.785 -0400", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "347CC7607CED3FC1170E8AFF68A5A4CB")
    @DSModeled(DSC.SAFE)
    public boolean isSealed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.785 -0400", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "5B93FB9EA7BAF4C0767BCCA3CF6C7758")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void enforceSealed() {
        {
            boolean varD513186271CF3A3D5E081DE87E878208_1166950985 = (!isSealed());
            {
                throw new IllegalStateException("Cannot perform this "
                    + "action on a not sealed instance.");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isSealed()) {
            //throw new IllegalStateException("Cannot perform this "
                    //+ "action on a not sealed instance.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.785 -0400", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "427D1C3FE374149DCE58C768306265AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void enforceNotSealed() {
        {
            boolean varA822B3442F37011C427DDD3B23C1201F_623275196 = (isSealed());
            {
                throw new IllegalStateException("Cannot perform this "
                    + "action on an sealed instance.");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isSealed()) {
            //throw new IllegalStateException("Cannot perform this "
                    //+ "action on an sealed instance.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.785 -0400", hash_original_method = "5950FF2359622B18F5A5CA611CFB5FEA", hash_generated_method = "6166B14C683B9315F9D6F2BDCDD2DABC")
    public static AccessibilityNodeInfo obtain(View source) {
        AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
        info.setSource(source);
        return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.785 -0400", hash_original_method = "C6E435CA3C22ED725F4C5C94B55E086B", hash_generated_method = "462547FFF946A9E7DDF12A274E3611A8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.785 -0400", hash_original_method = "37F85E23627B3CF97E9C182F8136E0AB", hash_generated_method = "77DAFE88B40246CEB31DA46F7F2DDFCB")
    public static AccessibilityNodeInfo obtain(AccessibilityNodeInfo info) {
        AccessibilityNodeInfo infoClone = AccessibilityNodeInfo.obtain();
        infoClone.init(info);
        return infoClone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.785 -0400", hash_original_method = "E5AEF2A1BB846A92BC2380F50D2ACE39", hash_generated_method = "C024999449DFA965C44D9B0775F3FE2B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.785 -0400", hash_original_method = "CE4668F7872E1547EB7B822B86C2AD44", hash_generated_method = "43D9489DD7A039A4E54323C8FD6B4171")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeInt(isSealed() ? 1 : 0);
        parcel.writeInt(mAccessibilityViewId);
        parcel.writeInt(mAccessibilityWindowId);
        parcel.writeInt(mParentAccessibilityViewId);
        parcel.writeInt(mConnectionId);
        SparseIntArray childIds;
        childIds = mChildAccessibilityIds;
        final int childIdsSize;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.786 -0400", hash_original_method = "84525B5DDEB8A0E58F9024DAD2E7A518", hash_generated_method = "D28C2CA37FD14509EEA2F9B8B80EFCC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(AccessibilityNodeInfo other) {
        dsTaint.addTaint(other.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.786 -0400", hash_original_method = "98923D5E356E47505C0A26C0C57920A8", hash_generated_method = "94D8FAAA2ED84326757E0B7963727844")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initFromParcel(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        mSealed = (parcel.readInt()  == 1);
        mAccessibilityViewId = parcel.readInt();
        mAccessibilityWindowId = parcel.readInt();
        mParentAccessibilityViewId = parcel.readInt();
        mConnectionId = parcel.readInt();
        SparseIntArray childIds;
        childIds = mChildAccessibilityIds;
        final int childrenSize;
        childrenSize = parcel.readInt();
        {
            int i;
            i = 0;
            {
                final int childId;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.786 -0400", hash_original_method = "566B1830900B4F3B865C25C43FCDC943", hash_generated_method = "709100C3F0C69252629378F677E7DCC7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.786 -0400", hash_original_method = "9281FA443503FD33DEEF9EAD3B753685", hash_generated_method = "391A03671E05FAA090F547861109E519")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.786 -0400", hash_original_method = "554416B444549B4EB33FDEE3DD8518FA", hash_generated_method = "B1BEDD9D9657B57C27F177D16C71D1D6")
    @DSModeled(DSC.SAFE)
    private boolean canPerformRequestOverConnection(int accessibilityViewId) {
        dsTaint.addTaint(accessibilityViewId);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mConnectionId != UNDEFINED && mAccessibilityWindowId != UNDEFINED
                //&& accessibilityViewId != UNDEFINED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.786 -0400", hash_original_method = "75F2609B8EC69930F0DC5E65EF5711F8", hash_generated_method = "9F24FA3EEF0298A2F291444C99F96D87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var9B6B3A9EF19915DD9EB4EA755CD0D0E4_143955334 = (getClass() != object.getClass());
        } //End collapsed parenthetic
        AccessibilityNodeInfo other;
        other = (AccessibilityNodeInfo) object;
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.787 -0400", hash_original_method = "5729DB4BFFEF2935F7B53D1FC3170C4A", hash_generated_method = "476627F8622061912830D03047CAB140")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        final int prime;
        prime = 31;
        int result;
        result = 1;
        result = prime * result + mAccessibilityViewId;
        result = prime * result + mAccessibilityWindowId;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int prime = 31;
        //int result = 1;
        //result = prime * result + mAccessibilityViewId;
        //result = prime * result + mAccessibilityWindowId;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.787 -0400", hash_original_method = "9C50A737351E97FBF1CC9E56A50E9FD3", hash_generated_method = "3EA8BD40D4B884669FA404148F9E7BB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
                final int action;
                action = 1 << Integer.numberOfTrailingZeros(actionBits);
                actionBits &= ~action;
                builder.append(getActionSymbolicName(action));
                {
                    builder.append(", ");
                } //End block
            } //End block
        } //End collapsed parenthetic
        builder.append("]");
        String var687AAF24B90629C9BFCFE9608FDCE6E7_1342495553 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


