package android.view.accessibility;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.os.Parcelable;
import android.view.View;





public class AccessibilityRecord {

    /**
     * Returns a cached instance if such is available or a new one is
     * instantiated. The instance is initialized with data from the
     * given record.
     *
     * @return An instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.636 -0500", hash_original_method = "2CFD6EBEFF813BB567E469C3740E6AAE", hash_generated_method = "832DDE9481661F774B1DBC74C9B1C36D")
    public static AccessibilityRecord obtain(AccessibilityRecord record) {
       AccessibilityRecord clone = AccessibilityRecord.obtain();
       clone.init(record);
       return clone;
    }

    /**
     * Returns a cached instance if such is available or a new one is
     * instantiated.
     *
     * @return An instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.637 -0500", hash_original_method = "F52296A1A788DF4272F6650232B88A31", hash_generated_method = "60B1C824D4E6E3CA5E531FDBE67AE447")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.570 -0500", hash_original_field = "8BF5B7BB2C741E6F51882B1E85E5F169", hash_generated_field = "1E642CC81E6D04170ACE577F1365D5E0")


    private static final int UNDEFINED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.571 -0500", hash_original_field = "C0F91523AF6FACADA47007AC27ECA341", hash_generated_field = "727FEBC84A7763294879AC67CE69F107")


    private static final int PROPERTY_CHECKED = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.572 -0500", hash_original_field = "93DBDCFAD69E463227DC2E570C5602BF", hash_generated_field = "BF6BC93B5E6FD2F1AFC97468EC9F79A2")

    private static final int PROPERTY_ENABLED = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.573 -0500", hash_original_field = "CA7265AD1F719D87BF97A2143971AB69", hash_generated_field = "FA0A04EBDA8C2BEA18119B785E04F584")

    private static final int PROPERTY_PASSWORD = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.574 -0500", hash_original_field = "2DCE9397A26965F8DBFE69B8320FE299", hash_generated_field = "DEC42BEDF17E472B8EB1D0FC5AA34896")

    private static final int PROPERTY_FULL_SCREEN = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.574 -0500", hash_original_field = "ECCAF436F444B1BC37B4F333C6A5B5F8", hash_generated_field = "92A0ADDFB1EC36FCD4578FA35BE2DB19")

    private static final int PROPERTY_SCROLLABLE = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.575 -0500", hash_original_field = "3257F81BBFE679E3360141AA5EA9D518", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")

    private static final int MAX_POOL_SIZE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.576 -0500", hash_original_field = "80BD8A730C8BC829BD11E3A3CFC39CA3", hash_generated_field = "515CCCD8D6622177DD93BECF774D048D")

    private static final Object sPoolLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.577 -0500", hash_original_field = "61A561AF38DE1231C077E187A0113CA1", hash_generated_field = "6EC2D88EC753CBA217CDEA5A4EB759FF")

    private static AccessibilityRecord sPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.578 -0500", hash_original_field = "4147A9532CCAB604E1A40F8F844CAE62", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.579 -0500", hash_original_field = "183631822D163F64D2D52827F1EE7BE5", hash_generated_field = "819E660F8F7271EBD249CE0B621A6CFF")

    private AccessibilityRecord mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.579 -0500", hash_original_field = "2CE23EB289B3963F8F89CE4E1DF951CB", hash_generated_field = "12FC58788D16ADAE0F5394F898FD4D99")

    private boolean mIsInPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.580 -0500", hash_original_field = "4B6C132CC4E1DABC021AFE92BC996668", hash_generated_field = "4B6C132CC4E1DABC021AFE92BC996668")


    boolean mSealed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.581 -0500", hash_original_field = "16EB928A608E490EDABD6C313699F6E2", hash_generated_field = "16EB928A608E490EDABD6C313699F6E2")

    int mBooleanProperties;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.582 -0500", hash_original_field = "61B6204A7C251AA3D27E9B50A9355A30", hash_generated_field = "61B6204A7C251AA3D27E9B50A9355A30")

    int mCurrentItemIndex = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.582 -0500", hash_original_field = "F76D3264C191AE325187C60C1ABBC344", hash_generated_field = "F76D3264C191AE325187C60C1ABBC344")

    int mItemCount = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.583 -0500", hash_original_field = "EF145018DE8E629EE83018E54FFFED11", hash_generated_field = "EF145018DE8E629EE83018E54FFFED11")

    int mFromIndex = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.584 -0500", hash_original_field = "51A8B4D9E0617CE3451D67583416EB43", hash_generated_field = "51A8B4D9E0617CE3451D67583416EB43")

    int mToIndex = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.584 -0500", hash_original_field = "72E164DE5C696E5476091A9DD43D6C8D", hash_generated_field = "72E164DE5C696E5476091A9DD43D6C8D")

    int mScrollX = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.585 -0500", hash_original_field = "53E5DA241F46897B4A82791606381914", hash_generated_field = "53E5DA241F46897B4A82791606381914")

    int mScrollY = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.586 -0500", hash_original_field = "8B3E5A0AFE1301DC07049E45EAB257E2", hash_generated_field = "8B3E5A0AFE1301DC07049E45EAB257E2")

    int mMaxScrollX = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.587 -0500", hash_original_field = "8B1EEF0BAF8B84D80086BC17A2C41C6C", hash_generated_field = "8B1EEF0BAF8B84D80086BC17A2C41C6C")

    int mMaxScrollY = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.588 -0500", hash_original_field = "D24F8B9BED9E4999FEFD1D6BDD0A4524", hash_generated_field = "D24F8B9BED9E4999FEFD1D6BDD0A4524")


    int mAddedCount= UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.588 -0500", hash_original_field = "A726B2E71548B632DFBFAFCC74F6ADEA", hash_generated_field = "A726B2E71548B632DFBFAFCC74F6ADEA")

    int mRemovedCount = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.589 -0500", hash_original_field = "3B1E05A74215A57B8C30C232B3E92D50", hash_generated_field = "3B1E05A74215A57B8C30C232B3E92D50")

    int mSourceViewId = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.590 -0500", hash_original_field = "831206FA2F666A93060BCB2DBBE12AE5", hash_generated_field = "831206FA2F666A93060BCB2DBBE12AE5")

    int mSourceWindowId = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.590 -0500", hash_original_field = "607E22FB74B4A9750077B62E99C7097B", hash_generated_field = "607E22FB74B4A9750077B62E99C7097B")


    CharSequence mClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.591 -0500", hash_original_field = "1D344C00C8D6A0BCC2A3B840B08C53BD", hash_generated_field = "1D344C00C8D6A0BCC2A3B840B08C53BD")

    CharSequence mContentDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.592 -0500", hash_original_field = "6FED3330A012BA7D2A27B5EF6045F2F0", hash_generated_field = "6FED3330A012BA7D2A27B5EF6045F2F0")

    CharSequence mBeforeText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.592 -0500", hash_original_field = "4C8F8687F0917167B5FF9B39C6545ED3", hash_generated_field = "4C8F8687F0917167B5FF9B39C6545ED3")

    Parcelable mParcelableData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.593 -0500", hash_original_field = "138B9E96AA00DB5CE70BF8BD81DA37C5", hash_generated_field = "868BA7C98D63B508230C0EC76DFD4DD7")


    final List<CharSequence> mText = new ArrayList<CharSequence>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.594 -0500", hash_original_field = "8B5A4110581AEE7B543A400E2F63419C", hash_generated_field = "8B5A4110581AEE7B543A400E2F63419C")


    int mConnectionId = UNDEFINED;

    /*
     * Hide constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.594 -0500", hash_original_method = "47B5C6FFA7A08624EFFE67BFFC3F0DF4", hash_generated_method = "47B5C6FFA7A08624EFFE67BFFC3F0DF4")
    AccessibilityRecord() {
    }

    /**
     * Sets the event source.
     *
     * @param source The source.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.595 -0500", hash_original_method = "948A1D8CF51CA12DCE9E50B8B6FDE838", hash_generated_method = "99A3EBFCDD6EA24818F3FC9C5AE08CD8")
    public void setSource(View source) {
        enforceNotSealed();
        if (source != null) {
            mSourceWindowId = source.getAccessibilityWindowId();
            mSourceViewId = source.getAccessibilityViewId();
        } else {
            mSourceWindowId = UNDEFINED;
            mSourceViewId = UNDEFINED;
        }
    }

    /**
     * Gets the {@link AccessibilityNodeInfo} of the event source.
     * <p>
     *   <strong>Note:</strong> It is a client responsibility to recycle the received info
     *   by calling {@link AccessibilityNodeInfo#recycle() AccessibilityNodeInfo#recycle()}
     *   to avoid creating of multiple instances.
     * </p>
     * @return The info of the source.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.596 -0500", hash_original_method = "D6229F18D386359B7D2ED64A724CE545", hash_generated_method = "E3F4DD62F8EC4943796CD11E7138B5E7")
    public AccessibilityNodeInfo getSource() {
        enforceSealed();
        if (mConnectionId == UNDEFINED || mSourceWindowId == UNDEFINED
                || mSourceViewId == UNDEFINED) {
            return null;
        }
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        return client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId, mSourceWindowId,
                mSourceViewId);
    }

    /**
     * Gets the id of the window from which the event comes from.
     *
     * @return The window id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.597 -0500", hash_original_method = "0167B817243C7300A3E7B07356FC6F77", hash_generated_method = "1970707F9305C75751844A4DD97577B4")
    public int getWindowId() {
        return mSourceWindowId;
    }

    /**
     * Gets if the source is checked.
     *
     * @return True if the view is checked, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.597 -0500", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "D9CD50EE9CC4C5741F1B86BD0C60AA6A")
    public boolean isChecked() {
        return getBooleanProperty(PROPERTY_CHECKED);
    }

    /**
     * Sets if the source is checked.
     *
     * @param isChecked True if the view is checked, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.598 -0500", hash_original_method = "EF363FCE51C9C9A497BD6E689D39B09F", hash_generated_method = "024065D6DB32E5E4B39EDBB43CA9EC86")
    public void setChecked(boolean isChecked) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_CHECKED, isChecked);
    }

    /**
     * Gets if the source is enabled.
     *
     * @return True if the view is enabled, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.600 -0500", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "F197DE3582D7DA20C6044E50A654B0C1")
    public boolean isEnabled() {
        return getBooleanProperty(PROPERTY_ENABLED);
    }

    /**
     * Sets if the source is enabled.
     *
     * @param isEnabled True if the view is enabled, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.600 -0500", hash_original_method = "0EAAA686E8658459FDC66C98C4B45340", hash_generated_method = "39F43A8EBABC7BA4E0751BB77CB14027")
    public void setEnabled(boolean isEnabled) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_ENABLED, isEnabled);
    }

    /**
     * Gets if the source is a password field.
     *
     * @return True if the view is a password field, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.601 -0500", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "E655A327F19083075E83F5EF7D96B406")
    public boolean isPassword() {
        return getBooleanProperty(PROPERTY_PASSWORD);
    }

    /**
     * Sets if the source is a password field.
     *
     * @param isPassword True if the view is a password field, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.602 -0500", hash_original_method = "8EDA15203F993D6B021832D12354DB70", hash_generated_method = "3E5EE04693246BC59D57449808EA771D")
    public void setPassword(boolean isPassword) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_PASSWORD, isPassword);
    }

    /**
     * Gets if the source is taking the entire screen.
     *
     * @return True if the source is full screen, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.603 -0500", hash_original_method = "C1D751586747941BBE1AE366FE4E3AB5", hash_generated_method = "E9500D5A561ED92F5CC7985376ABE226")
    public boolean isFullScreen() {
        return getBooleanProperty(PROPERTY_FULL_SCREEN);
    }

    /**
     * Sets if the source is taking the entire screen.
     *
     * @param isFullScreen True if the source is full screen, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.604 -0500", hash_original_method = "8C2BD0FA889006F174A45F3038D20EAE", hash_generated_method = "76FB1ED5F32B5037A395E7539EA6DA2B")
    public void setFullScreen(boolean isFullScreen) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_FULL_SCREEN, isFullScreen);
    }

    /**
     * Gets if the source is scrollable.
     *
     * @return True if the source is scrollable, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.604 -0500", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "E07D899195A0F34DC826BBB3CFA25B61")
    public boolean isScrollable() {
        return getBooleanProperty(PROPERTY_SCROLLABLE);
    }

    /**
     * Sets if the source is scrollable.
     *
     * @param scrollable True if the source is scrollable, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.605 -0500", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "12E034E4311AAEA337DF8A82E5AB3864")
    public void setScrollable(boolean scrollable) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
    }

    /**
     * Gets the number of items that can be visited.
     *
     * @return The number of items.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.606 -0500", hash_original_method = "5653D3A6C559AE9B846DF6E2B5CE39F8", hash_generated_method = "5ECD654FB9BAD57A8D73E391C83C3123")
    public int getItemCount() {
        return mItemCount;
    }

    /**
     * Sets the number of items that can be visited.
     *
     * @param itemCount The number of items.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.607 -0500", hash_original_method = "F4CC562DD5B544AF052C8C7ADD17F3DB", hash_generated_method = "116735580D91EAE92D3C91673D7E4E9F")
    public void setItemCount(int itemCount) {
        enforceNotSealed();
        mItemCount = itemCount;
    }

    /**
     * Gets the index of the source in the list of items the can be visited.
     *
     * @return The current item index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.608 -0500", hash_original_method = "C835140CBE8B50DDD89D13B9DB62A1BF", hash_generated_method = "D5D998EF569924DC3C010FBED5F40CBB")
    public int getCurrentItemIndex() {
        return mCurrentItemIndex;
    }

    /**
     * Sets the index of the source in the list of items that can be visited.
     *
     * @param currentItemIndex The current item index.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.608 -0500", hash_original_method = "05A5E897DB8527242E13FEF032CE111F", hash_generated_method = "B16C45DA22270441A95D9890EE01D5D5")
    public void setCurrentItemIndex(int currentItemIndex) {
        enforceNotSealed();
        mCurrentItemIndex = currentItemIndex;
    }

    /**
     * Gets the index of the first character of the changed sequence,
     * or the beginning of a text selection or the index of the first
     * visible item when scrolling.
     *
     * @return The index of the first character or selection
     *        start or the first visible item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.609 -0500", hash_original_method = "67718C1B588EB57EF05CD90DC3F200D7", hash_generated_method = "4E7F112F58B3AE1475FFA92EB92ECD13")
    public int getFromIndex() {
        return mFromIndex;
    }

    /**
     * Sets the index of the first character of the changed sequence
     * or the beginning of a text selection or the index of the first
     * visible item when scrolling.
     *
     * @param fromIndex The index of the first character or selection
     *        start or the first visible item.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.610 -0500", hash_original_method = "BBFD31D579F6E6D46645245CC5F2E354", hash_generated_method = "7E1E3EB41AFFF97FD32BB5D10A3EE109")
    public void setFromIndex(int fromIndex) {
        enforceNotSealed();
        mFromIndex = fromIndex;
    }

    /**
     * Gets the index of text selection end or the index of the last
     * visible item when scrolling.
     *
     * @return The index of selection end or last item index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.611 -0500", hash_original_method = "579D16111E248F454AD7B48F20E18451", hash_generated_method = "2D826AB68D0EEE2CE59753918C365117")
    public int getToIndex() {
        return mToIndex;
    }

    /**
     * Sets the index of text selection end or the index of the last
     * visible item when scrolling.
     *
     * @param toIndex The index of selection end or last item index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.611 -0500", hash_original_method = "E568A8356EF0E74107283370C7553269", hash_generated_method = "FD64A6A68903263361DB0F7B9693A10A")
    public void setToIndex(int toIndex) {
        enforceNotSealed();
        mToIndex = toIndex;
    }

    /**
     * Gets the scroll offset of the source left edge in pixels.
     *
     * @return The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.612 -0500", hash_original_method = "37E422003D62C4BD4746E9CFAAF79E84", hash_generated_method = "2966D4C64459925C83CB122456D7422D")
    public int getScrollX() {
        return mScrollX;
    }

    /**
     * Sets the scroll offset of the source left edge in pixels.
     *
     * @param scrollX The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.613 -0500", hash_original_method = "39929F8426D84CFC2AAA2E35AFA69688", hash_generated_method = "3F9B251AFE287F55128062A012571B0D")
    public void setScrollX(int scrollX) {
        enforceNotSealed();
        mScrollX = scrollX;
    }

    /**
     * Gets the scroll offset of the source top edge in pixels.
     *
     * @return The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.614 -0500", hash_original_method = "1E7AE64F8D32210A6E2C97F4869FB31A", hash_generated_method = "783DF9D98F417D8B625FF8CC53D68860")
    public int getScrollY() {
        return mScrollY;
    }

    /**
     * Sets the scroll offset of the source top edge in pixels.
     *
     * @param scrollY The scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.614 -0500", hash_original_method = "3D3AC5EAAB87E771122FE10290862D68", hash_generated_method = "CA2C10E297B35E93AB522BF272C6A55A")
    public void setScrollY(int scrollY) {
        enforceNotSealed();
        mScrollY = scrollY;
    }

    /**
     * Gets the max scroll offset of the source left edge in pixels.
     *
     * @return The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.615 -0500", hash_original_method = "C4A2F5E4142D8D5EA688446E7513363C", hash_generated_method = "FC8C8B13FB9786F06B237F79CC9DE44D")
    public int getMaxScrollX() {
        return mMaxScrollX;
    }
    /**
     * Sets the max scroll offset of the source left edge in pixels.
     *
     * @param maxScrollX The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.616 -0500", hash_original_method = "EE977B785E6D4A7CA733252D06CF32E9", hash_generated_method = "C2DA57E8F40DD4C9A466F4C1AD09BE85")
    public void setMaxScrollX(int maxScrollX) {
        enforceNotSealed();
        mMaxScrollX = maxScrollX;
    }

    /**
     * Gets the max scroll offset of the source top edge in pixels.
     *
     * @return The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.617 -0500", hash_original_method = "A3ECA44A0D4150097FAA989997DF13C5", hash_generated_method = "CEFA4C74AA3CC80669494263F97F0A86")
    public int getMaxScrollY() {
        return mMaxScrollY;
    }

    /**
     * Sets the max scroll offset of the source top edge in pixels.
     *
     * @param maxScrollY The max scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.618 -0500", hash_original_method = "49077E92EA018330C2FB0B17E183D4A7", hash_generated_method = "DC8DB112A963D4DD8E318244F0B8840E")
    public void setMaxScrollY(int maxScrollY) {
        enforceNotSealed();
        mMaxScrollY = maxScrollY;
    }

    /**
     * Gets the number of added characters.
     *
     * @return The number of added characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.619 -0500", hash_original_method = "49E2E44D8419AC51B09A77AC8668D279", hash_generated_method = "97DEE091452250D9492F94DE1B9CB7EB")
    public int getAddedCount() {
        return mAddedCount;
    }

    /**
     * Sets the number of added characters.
     *
     * @param addedCount The number of added characters.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.620 -0500", hash_original_method = "72BB1C08DFA71715A3D1B3E3C0F3D07A", hash_generated_method = "16DCC119DBAD44984751C43034BBF01F")
    public void setAddedCount(int addedCount) {
        enforceNotSealed();
        mAddedCount = addedCount;
    }

    /**
     * Gets the number of removed characters.
     *
     * @return The number of removed characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.621 -0500", hash_original_method = "EBD9E1156BBECE10FD62678D5B5AE958", hash_generated_method = "18F3685DDB7CC812F66D38EC4E0ACA55")
    public int getRemovedCount() {
        return mRemovedCount;
    }

    /**
     * Sets the number of removed characters.
     *
     * @param removedCount The number of removed characters.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.622 -0500", hash_original_method = "A6A70AD3A3D0C21790CD56D9B41496A2", hash_generated_method = "100F236D74FE8B5CC7DDFEF6CF131078")
    public void setRemovedCount(int removedCount) {
        enforceNotSealed();
        mRemovedCount = removedCount;
    }

    /**
     * Gets the class name of the source.
     *
     * @return The class name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.623 -0500", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "26599164AEA75289AA6AEFE666301F84")
    public CharSequence getClassName() {
        return mClassName;
    }

    /**
     * Sets the class name of the source.
     *
     * @param className The lass name.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.623 -0500", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "FED8F14A8D334A8BA08886C8CE2F0CE9")
    public void setClassName(CharSequence className) {
        enforceNotSealed();
        mClassName = className;
    }

    /**
     * Gets the text of the event. The index in the list represents the priority
     * of the text. Specifically, the lower the index the higher the priority.
     *
     * @return The text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.624 -0500", hash_original_method = "DC632160826FC3F04AF23253967928B9", hash_generated_method = "379A6D4AD7B63386276D4CACD9E2EDDC")
    public List<CharSequence> getText() {
        return mText;
    }

    /**
     * Sets the text before a change.
     *
     * @return The text before the change.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.625 -0500", hash_original_method = "FE2FD614296585A25D259709588FAD5E", hash_generated_method = "A052B70B6CA03CBA54AC63E969604818")
    public CharSequence getBeforeText() {
        return mBeforeText;
    }

    /**
     * Sets the text before a change.
     *
     * @param beforeText The text before the change.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.626 -0500", hash_original_method = "D6F685CC2DDAD1DA7E7B88F32900AE37", hash_generated_method = "A8FDE895D2647C140185E48ECB9677A9")
    public void setBeforeText(CharSequence beforeText) {
        enforceNotSealed();
        mBeforeText = beforeText;
    }

    /**
     * Gets the description of the source.
     *
     * @return The description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.627 -0500", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "F956064663F9FEBB2E9D4DEF23399995")
    public CharSequence getContentDescription() {
        return mContentDescription;
    }

    /**
     * Sets the description of the source.
     *
     * @param contentDescription The description.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.628 -0500", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "E1714B81DD2746B9FD1113A5037215C7")
    public void setContentDescription(CharSequence contentDescription) {
        enforceNotSealed();
        mContentDescription = contentDescription;
    }

    /**
     * Gets the {@link Parcelable} data.
     *
     * @return The parcelable data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.629 -0500", hash_original_method = "336F04D02E102717408E8DD7ED329D8E", hash_generated_method = "0D4F1F165FBD3575FEEFEB96DD34A0B0")
    public Parcelable getParcelableData() {
        return mParcelableData;
    }

    /**
     * Sets the {@link Parcelable} data of the event.
     *
     * @param parcelableData The parcelable data.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.630 -0500", hash_original_method = "1574FBF11672419A058C271D89F97C62", hash_generated_method = "0B0BD5A07D321AFA5EB96E57C2C44645")
    public void setParcelableData(Parcelable parcelableData) {
        enforceNotSealed();
        mParcelableData = parcelableData;
    }

    /**
     * Sets the unique id of the IAccessibilityServiceConnection over which
     * this instance can send requests to the system.
     *
     * @param connectionId The connection id.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.631 -0500", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "BC4D7D397131B35AD8A5BAEE310B718C")
    public void setConnectionId(int connectionId) {
        enforceNotSealed();
        mConnectionId = connectionId;
    }

    /**
     * Sets if this instance is sealed.
     *
     * @param sealed Whether is sealed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.631 -0500", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "D19C5B16DCE00646203E99ED6C851A4E")
    public void setSealed(boolean sealed) {
        mSealed = sealed;
    }

    /**
     * Gets if this instance is sealed.
     *
     * @return Whether is sealed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.632 -0500", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "AF3422E1C079F6B2A15130B45797502F")
    boolean isSealed() {
        return mSealed;
    }

    /**
     * Enforces that this instance is sealed.
     *
     * @throws IllegalStateException If this instance is not sealed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.633 -0500", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "0309B89A8A5C20FB439CB65AA9DE3FAA")
    void enforceSealed() {
        if (!isSealed()) {
            throw new IllegalStateException("Cannot perform this "
                    + "action on a not sealed instance.");
        }
    }

    /**
     * Enforces that this instance is not sealed.
     *
     * @throws IllegalStateException If this instance is sealed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.634 -0500", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "9B7C20934D3E00C37812C7E94DAAB15E")
    void enforceNotSealed() {
        if (isSealed()) {
            throw new IllegalStateException("Cannot perform this "
                    + "action on an sealed instance.");
        }
    }

    /**
     * Gets the value of a boolean property.
     *
     * @param property The property.
     * @return The value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.634 -0500", hash_original_method = "4FB14FE7E8FA7F40071202FB709EF8E4", hash_generated_method = "241BDD7624E9B30D6E3564D25E7F1CFC")
    private boolean getBooleanProperty(int property) {
        return (mBooleanProperties & property) == property;
    }

    /**
     * Sets a boolean property.
     *
     * @param property The property.
     * @param value The value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.635 -0500", hash_original_method = "1E3C58B2EEBD5BD671884B4ADC3ACB2F", hash_generated_method = "222E98F89D8BBC5E2EB4330004D08654")
    private void setBooleanProperty(int property, boolean value) {
        if (value) {
            mBooleanProperties |= property;
        } else {
            mBooleanProperties &= ~property;
        }
    }

    /**
     * Return an instance back to be reused.
     * <p>
     * <strong>Note:</strong> You must not touch the object after calling this function.
     *
     * @throws IllegalStateException If the record is already recycled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.638 -0500", hash_original_method = "0FDD4277FFE3E2F2D99D4BAB0780A409", hash_generated_method = "04AA46A4E4C0F0C192EB028637BC5E4B")
    public void recycle() {
        if (mIsInPool) {
            throw new IllegalStateException("Record already recycled!");
        }
        clear();
        synchronized (sPoolLock) {
            if (sPoolSize <= MAX_POOL_SIZE) {
                mNext = sPool;
                sPool = this;
                mIsInPool = true;
                sPoolSize++;
            }
        }
    }

    /**
     * Initialize this record from another one.
     *
     * @param record The to initialize from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.639 -0500", hash_original_method = "EC9B4AFBEF6A967243E7EC5889FB4591", hash_generated_method = "EC9B4AFBEF6A967243E7EC5889FB4591")
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

    /**
     * Clears the state of this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.639 -0500", hash_original_method = "F6BD36F7AA33E2CDDBD8ECFA17198BE9", hash_generated_method = "F6BD36F7AA33E2CDDBD8ECFA17198BE9")
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:25.640 -0500", hash_original_method = "6984D5C42FE7046E0FC00D15FC78323D", hash_generated_method = "34417318D830F13732943775069038EE")
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
        return builder.toString();
    }
}

