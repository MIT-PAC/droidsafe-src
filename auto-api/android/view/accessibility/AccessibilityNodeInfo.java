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
    private AccessibilityNodeInfo mNext;
    private boolean mIsInPool;
    private boolean mSealed;
    private int mAccessibilityViewId = UNDEFINED;
    private int mAccessibilityWindowId = UNDEFINED;
    private int mParentAccessibilityViewId = UNDEFINED;
    private int mBooleanProperties;
    private Rect mBoundsInParent = new Rect();
    private Rect mBoundsInScreen = new Rect();
    private CharSequence mPackageName;
    private CharSequence mClassName;
    private CharSequence mText;
    private CharSequence mContentDescription;
    private SparseIntArray mChildAccessibilityIds = new SparseIntArray();
    private int mActions;
    private int mConnectionId = UNDEFINED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.855 -0400", hash_original_method = "EB9F4328D2282B04E1BD31B0186E73D5", hash_generated_method = "176EFD0A62B716335FDF7CEAA647EEC5")
    @DSModeled(DSC.SAFE)
    private AccessibilityNodeInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.856 -0400", hash_original_method = "D6E0A07A0224052514955EB47C47B111", hash_generated_method = "ED2C89B43D5497DD98BB9B10A659E3C8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.856 -0400", hash_original_method = "6C41AAD35FD64A253FB83D406AD6C88C", hash_generated_method = "2A12EC298887AC1033F9DDBE33EB70E0")
    @DSModeled(DSC.SAFE)
    public int getWindowId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAccessibilityWindowId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.856 -0400", hash_original_method = "7C8926FBBCF561C891F2F5FFEAFED8AF", hash_generated_method = "404F84205C95DA2D6A7FE4912CE247E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getChildCount() {
        int var319A3D2E0BF4719DB1F3ABFECD3065BB_1001298155 = (mChildAccessibilityIds.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mChildAccessibilityIds.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.857 -0400", hash_original_method = "E9093B8E79E0C35ACECC8F5F72DA0B71", hash_generated_method = "6493ABDAAB4A6400D05F18950C3BFCE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityNodeInfo getChild(int index) {
        dsTaint.addTaint(index);
        enforceSealed();
        int childAccessibilityViewId;
        childAccessibilityViewId = mChildAccessibilityIds.get(index);
        {
            boolean varB4030DB148F9B166EB2AAB9777FB5D27_1861978267 = (!canPerformRequestOverConnection(childAccessibilityViewId));
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        AccessibilityNodeInfo varECEB5B6F0EEE2D787D8B3FDFF3BEB73A_1759388469 = (client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.857 -0400", hash_original_method = "DCE0377A8D2F3327097D2FFFE36C9D81", hash_generated_method = "4F2A004FFB4835DE61B85AE3FAA7FC34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addChild(View child) {
        dsTaint.addTaint(child.dsTaint);
        enforceNotSealed();
        int childAccessibilityViewId;
        childAccessibilityViewId = child.getAccessibilityViewId();
        int index;
        index = mChildAccessibilityIds.size();
        mChildAccessibilityIds.put(index, childAccessibilityViewId);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //final int childAccessibilityViewId = child.getAccessibilityViewId();
        //final int index = mChildAccessibilityIds.size();
        //mChildAccessibilityIds.put(index, childAccessibilityViewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.858 -0400", hash_original_method = "60E376BAD814E27A83B622ADA78DD695", hash_generated_method = "C00CF4D58CAA6F9E36C6595CF5099034")
    @DSModeled(DSC.SAFE)
    public int getActions() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.858 -0400", hash_original_method = "62A0FADACCC1DF1A8E35D414239187E3", hash_generated_method = "38FE4FC6AD71651828E0558EB5CF6CE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addAction(int action) {
        dsTaint.addTaint(action);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mActions |= action;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.859 -0400", hash_original_method = "CDA2E61C3267971FAEFED5DF1BBF4146", hash_generated_method = "9A1B25CAD9350D1A3FE09F3FC871173A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performAction(int action) {
        dsTaint.addTaint(action);
        enforceSealed();
        {
            boolean var721560EFD3BEE97481FFB7EC61BDACA3_2109231001 = (!canPerformRequestOverConnection(mAccessibilityViewId));
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        boolean var7A46E79558E217C344F969075A75CE02_790439222 = (client.performAccessibilityAction(mConnectionId, mAccessibilityWindowId,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.859 -0400", hash_original_method = "DAAF9FBDD74DB58981A13A4C1D5FEB20", hash_generated_method = "F72AD763BB1B499DF47AC050B8241BFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text) {
        dsTaint.addTaint(text);
        enforceSealed();
        {
            boolean var721560EFD3BEE97481FFB7EC61BDACA3_1634076675 = (!canPerformRequestOverConnection(mAccessibilityViewId));
            {
                List<AccessibilityNodeInfo> varEAE3A1AA7930C0E7706565D9D889BA86_1772505005 = (Collections.emptyList());
            } //End block
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        List<AccessibilityNodeInfo> varA4FD6A3FF643C71BBE45DF66C19AE4E3_1173149400 = (client.findAccessibilityNodeInfosByViewText(mConnectionId, text,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.859 -0400", hash_original_method = "F4DB109D13E56E0D98A6319CC588873D", hash_generated_method = "8E54614366977E74DE8472E47DEFF4E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityNodeInfo getParent() {
        enforceSealed();
        {
            boolean varE5EB0B5D9D4BC6B936730052406791C1_405063275 = (!canPerformRequestOverConnection(mParentAccessibilityViewId));
        } //End collapsed parenthetic
        AccessibilityInteractionClient client;
        client = AccessibilityInteractionClient.getInstance();
        AccessibilityNodeInfo var286BAA33D1F06FDFC30B8C28E61AA77E_2100626364 = (client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.860 -0400", hash_original_method = "0FE0BB8E7E891FFE4D867C8196AE43B4", hash_generated_method = "EFA60468C26DAC93C8D05480D6DB2515")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParent(View parent) {
        dsTaint.addTaint(parent.dsTaint);
        enforceNotSealed();
        mParentAccessibilityViewId = parent.getAccessibilityViewId();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mParentAccessibilityViewId = parent.getAccessibilityViewId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.860 -0400", hash_original_method = "908AD8B1395D82502A9E3BA629915EF5", hash_generated_method = "E0FF4041F309B94F7FDE0B07A862C7EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getBoundsInParent(Rect outBounds) {
        dsTaint.addTaint(outBounds.dsTaint);
        outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                mBoundsInParent.right, mBoundsInParent.bottom);
        // ---------- Original Method ----------
        //outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                //mBoundsInParent.right, mBoundsInParent.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.860 -0400", hash_original_method = "DC2A2D1F16BCFDB8F09D047ED8729F2A", hash_generated_method = "D5DEBD8483FD4005DE978D9C8E33D323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBoundsInParent(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        enforceNotSealed();
        mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.860 -0400", hash_original_method = "2F98E8EF78DCE8F1C352462875EB84AE", hash_generated_method = "D1F9AF37378E0E3B3AF39065BA6BF822")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getBoundsInScreen(Rect outBounds) {
        dsTaint.addTaint(outBounds.dsTaint);
        outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                mBoundsInScreen.right, mBoundsInScreen.bottom);
        // ---------- Original Method ----------
        //outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                //mBoundsInScreen.right, mBoundsInScreen.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.860 -0400", hash_original_method = "770F78071B2EB9D2396840AB4AD2ADB5", hash_generated_method = "57846D1B5CECC8AD584BC4CDFF100DA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBoundsInScreen(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        enforceNotSealed();
        mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.861 -0400", hash_original_method = "67B4AEAF1632FE4AAC04770D8458ACB9", hash_generated_method = "3913CD9801ADA5F3822CD743436D0AD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCheckable() {
        boolean var3266C6B4E549BCADC450908FD96A217C_693868532 = (getBooleanProperty(PROPERTY_CHECKABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.861 -0400", hash_original_method = "516AC58EA6CB8A6948778CD704999386", hash_generated_method = "52F9198B4812A04334C84CAB9484AB5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCheckable(boolean checkable) {
        dsTaint.addTaint(checkable);
        setBooleanProperty(PROPERTY_CHECKABLE, checkable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CHECKABLE, checkable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.861 -0400", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "9B9E5D746483F81E591BC842EFFBE74D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isChecked() {
        boolean var452C23D949DE68DF158EF7F75ABFD98B_573359526 = (getBooleanProperty(PROPERTY_CHECKED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CHECKED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.861 -0400", hash_original_method = "930075A9DA99BE3539B9BAFC112A5160", hash_generated_method = "C1B6314F4ED94BEAE9D6F8CAFAE8E85C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChecked(boolean checked) {
        dsTaint.addTaint(checked);
        setBooleanProperty(PROPERTY_CHECKED, checked);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CHECKED, checked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.861 -0400", hash_original_method = "BEA45F3FF1A12FCE09D72D148357CE2C", hash_generated_method = "6CB22C879531ECE507D97D4F9311C335")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFocusable() {
        boolean varAEDFD7054BC897AF8637C74153A7FF42_19237993 = (getBooleanProperty(PROPERTY_FOCUSABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FOCUSABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.861 -0400", hash_original_method = "A4FE2C9F5A8AC78848A5BB7FA1A98C8F", hash_generated_method = "3DEC6344B67A23ECF374CC17630C703E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFocusable(boolean focusable) {
        dsTaint.addTaint(focusable);
        setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.862 -0400", hash_original_method = "3CD3FFF6959365D82FD80FF1FA237F64", hash_generated_method = "618301471674B809A84BD49BE3DCD2C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFocused() {
        boolean var62148897FE29AC5CF93DA794C2584E47_941741846 = (getBooleanProperty(PROPERTY_FOCUSED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_FOCUSED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.862 -0400", hash_original_method = "6C2B5793CEDC3F6B1248DAB365B53404", hash_generated_method = "8CA77E390420784DA11F4B5612B8D769")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFocused(boolean focused) {
        dsTaint.addTaint(focused);
        setBooleanProperty(PROPERTY_FOCUSED, focused);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_FOCUSED, focused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.862 -0400", hash_original_method = "0C97805A247814CF6CABD75572FD40C1", hash_generated_method = "6D173D0F8001D5B19ACDBA63FA0913AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSelected() {
        boolean var4935841C6821896C6C87075392A6DADA_1522493039 = (getBooleanProperty(PROPERTY_SELECTED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SELECTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.862 -0400", hash_original_method = "0890254D4AC82258F1AAEA57F8827B54", hash_generated_method = "05A954B938B2AB43DC1CB21C351F7E48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelected(boolean selected) {
        dsTaint.addTaint(selected);
        setBooleanProperty(PROPERTY_SELECTED, selected);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_SELECTED, selected);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.862 -0400", hash_original_method = "9E42D14BA1D4CF35C9E8D228C35BEE02", hash_generated_method = "AC7A05679D3C58CF14CD8F6A9C26D59E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isClickable() {
        boolean var619B1840FC15914C5C371F60FFBB44CD_1136733396 = (getBooleanProperty(PROPERTY_CLICKABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_CLICKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.862 -0400", hash_original_method = "2AB4084D18C97615027F882B075290EA", hash_generated_method = "841A8E8AABFF3632D084B3AF4CE1F7B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setClickable(boolean clickable) {
        dsTaint.addTaint(clickable);
        setBooleanProperty(PROPERTY_CLICKABLE, clickable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_CLICKABLE, clickable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.863 -0400", hash_original_method = "30EDA8A2E8A402543ACC7CC56FF92053", hash_generated_method = "B7FCD14C04B36AFC86B0459C37968607")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLongClickable() {
        boolean var28D1637359B227432B5AA37481E68E9B_565356995 = (getBooleanProperty(PROPERTY_LONG_CLICKABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_LONG_CLICKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.863 -0400", hash_original_method = "BBEB96E07778625102E9D70952371D0D", hash_generated_method = "C1865FCF7ACE5E610A07CA81CBC06111")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLongClickable(boolean longClickable) {
        dsTaint.addTaint(longClickable);
        setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.863 -0400", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "9CB996140959B20B536EC30B3790D979")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEnabled() {
        boolean var8448E9D671258D44185D3F547D298C9D_180150818 = (getBooleanProperty(PROPERTY_ENABLED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.863 -0400", hash_original_method = "2D7E6331314DB7964C417618AC2EB5EA", hash_generated_method = "E0EB4DE9E49E68BC0B6762665E3C9EC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setBooleanProperty(PROPERTY_ENABLED, enabled);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_ENABLED, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.863 -0400", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "02C9869E347F02CF9175B00367E5AADD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPassword() {
        boolean var087326F76FF21A482620141C52E3B799_1757380309 = (getBooleanProperty(PROPERTY_PASSWORD));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_PASSWORD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.863 -0400", hash_original_method = "4C0E98701874539EDF8F49BF5002C98F", hash_generated_method = "E91BF731BBD00C023430F060DF1A2E25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPassword(boolean password) {
        dsTaint.addTaint(password);
        setBooleanProperty(PROPERTY_PASSWORD, password);
        // ---------- Original Method ----------
        //setBooleanProperty(PROPERTY_PASSWORD, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.864 -0400", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "C12CC5C44D14E11DDB0E7FC271FC5B83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isScrollable() {
        boolean varCF570E94288645DBC38E8B422354A739_572916414 = (getBooleanProperty(PROPERTY_SCROLLABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBooleanProperty(PROPERTY_SCROLLABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.864 -0400", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "D8B810265087701C3DF7BB7DD56E5473")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScrollable(boolean scrollable) {
        dsTaint.addTaint(scrollable);
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.864 -0400", hash_original_method = "6D18CADAD3BE855C953B6A82043EA347", hash_generated_method = "CD722F946C542A3B895B3882B105FF9E")
    @DSModeled(DSC.SAFE)
    public CharSequence getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.864 -0400", hash_original_method = "D35D1C42C7BD5A2BDF03FC6BDBDF64EE", hash_generated_method = "94F40AC64FAB7A22E2507BB659B7B7D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPackageName(CharSequence packageName) {
        dsTaint.addTaint(packageName);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mPackageName = packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.864 -0400", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "92BAFB9E596A443858B6DBBAE4786BBD")
    @DSModeled(DSC.SAFE)
    public CharSequence getClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.864 -0400", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "B33515DF9F1ECF95475D2E8432869927")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setClassName(CharSequence className) {
        dsTaint.addTaint(className);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mClassName = className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.865 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "0EE8DAE8D11C9C0940FB60F3DE0E7055")
    @DSModeled(DSC.SAFE)
    public CharSequence getText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.865 -0400", hash_original_method = "B470A357BC33F6D7BBE8C746674F6216", hash_generated_method = "233F9E1ECE0CC94D0331EAA4CA34F4B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(CharSequence text) {
        dsTaint.addTaint(text);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mText = text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.865 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "9AEA7AC2805E6F06BD7FB29C1CE6CB3E")
    @DSModeled(DSC.SAFE)
    public CharSequence getContentDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mContentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.865 -0400", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "27B6A796EC9466494B8247B308B7B50B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentDescription(CharSequence contentDescription) {
        dsTaint.addTaint(contentDescription);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mContentDescription = contentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.865 -0400", hash_original_method = "08ED9648E2048980BB715C0F95464D97", hash_generated_method = "7CBE899E6AFB3F2691BA3E206882354D")
    @DSModeled(DSC.SAFE)
    private boolean getBooleanProperty(int property) {
        dsTaint.addTaint(property);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mBooleanProperties & property) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.865 -0400", hash_original_method = "AF4B29064CFE4EC4A14EBB7B9CA58D1B", hash_generated_method = "79B0C5E67D43D8E7585B41C89E17D385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.866 -0400", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "106AC060BF8BA5C5BDEA27C0EA5A64E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setConnectionId(int connectionId) {
        dsTaint.addTaint(connectionId);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mConnectionId = connectionId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.866 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.866 -0400", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "8C1F70D90B9EE6D4B4AAA6944A3DDD0A")
    @DSModeled(DSC.SAFE)
    public void setSealed(boolean sealed) {
        dsTaint.addTaint(sealed);
        // ---------- Original Method ----------
        //mSealed = sealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.866 -0400", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "3DDBCEE282605CD8DE2E905925991B2E")
    @DSModeled(DSC.SAFE)
    public boolean isSealed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSealed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.866 -0400", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "49425CBE9A968E1672CEF120C665CD1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void enforceSealed() {
        {
            boolean varD513186271CF3A3D5E081DE87E878208_1502382744 = (!isSealed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.866 -0400", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "EA2D5EE4083D6CCE5903399B5D331A36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void enforceNotSealed() {
        {
            boolean varA822B3442F37011C427DDD3B23C1201F_1190278463 = (isSealed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.867 -0400", hash_original_method = "E5AEF2A1BB846A92BC2380F50D2ACE39", hash_generated_method = "B8D0E4AEBBE679DC192A6A9B217301F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.867 -0400", hash_original_method = "CE4668F7872E1547EB7B822B86C2AD44", hash_generated_method = "871A3EA9CDB139F7B14F7C80711C768D")
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.868 -0400", hash_original_method = "84525B5DDEB8A0E58F9024DAD2E7A518", hash_generated_method = "2FC6D08BA8E264F720802FE42EC4AFCA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.868 -0400", hash_original_method = "98923D5E356E47505C0A26C0C57920A8", hash_generated_method = "0B2010455594B29B2ED29F5683BB9D17")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.869 -0400", hash_original_method = "566B1830900B4F3B865C25C43FCDC943", hash_generated_method = "5FE2D15D610736AC6C78827AD3CDAC8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.869 -0400", hash_original_method = "554416B444549B4EB33FDEE3DD8518FA", hash_generated_method = "22ED0DCA6A328EBFC49914D53CD2FB3A")
    @DSModeled(DSC.SAFE)
    private boolean canPerformRequestOverConnection(int accessibilityViewId) {
        dsTaint.addTaint(accessibilityViewId);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mConnectionId != UNDEFINED && mAccessibilityWindowId != UNDEFINED
                //&& accessibilityViewId != UNDEFINED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.869 -0400", hash_original_method = "75F2609B8EC69930F0DC5E65EF5711F8", hash_generated_method = "9450CC2077D0B6B5F107D3FDC4143E57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var9B6B3A9EF19915DD9EB4EA755CD0D0E4_1933629287 = (getClass() != object.getClass());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.869 -0400", hash_original_method = "5729DB4BFFEF2935F7B53D1FC3170C4A", hash_generated_method = "A3FF73D79802253B64B240CBE0348F2D")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        int prime;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.870 -0400", hash_original_method = "9C50A737351E97FBF1CC9E56A50E9FD3", hash_generated_method = "1F06CED966B8D5BF758F80C4C45D8823")
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
        String var687AAF24B90629C9BFCFE9608FDCE6E7_1601059867 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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
    public static final Parcelable.Creator<AccessibilityNodeInfo> CREATOR = new Parcelable.Creator<AccessibilityNodeInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.870 -0400", hash_original_method = "41FF7B589DD370C35E95646D230DB9E3", hash_generated_method = "9746EE2C26591B5B6BA8B7E8B7698FE3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.871 -0400", hash_original_method = "307ED09D70799D6E59BE60B4F21A4B77", hash_generated_method = "B4622BFD24026585EE58F1C493C780B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AccessibilityNodeInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            AccessibilityNodeInfo[] var7732FDE0667105EFE359EAF2A933E6B3_779945648 = (new AccessibilityNodeInfo[size]);
            return (AccessibilityNodeInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AccessibilityNodeInfo[size];
        }

        
}; //Transformed anonymous class
}

