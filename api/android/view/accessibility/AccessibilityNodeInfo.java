package android.view.accessibility;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * Returns a cached instance if such is available otherwise a new one
     * and sets the source.
     *
     * @return An instance.
     *
     * @see #setSource(View)
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.373 -0500", hash_original_method = "5950FF2359622B18F5A5CA611CFB5FEA", hash_generated_method = "6166B14C683B9315F9D6F2BDCDD2DABC")
    
public static AccessibilityNodeInfo obtain(View source) {
        AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
        info.setSource(source);
        return info;
    }

    /**
     * Returns a cached instance if such is available otherwise a new one.
     *
     * @return An instance.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.376 -0500", hash_original_method = "C6E435CA3C22ED725F4C5C94B55E086B", hash_generated_method = "462547FFF946A9E7DDF12A274E3611A8")
    
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

    /**
     * Returns a cached instance if such is available or a new one is
     * create. The returned instance is initialized from the given
     * <code>info</code>.
     *
     * @param info The other info.
     * @return An instance.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.379 -0500", hash_original_method = "37F85E23627B3CF97E9C182F8136E0AB", hash_generated_method = "77DAFE88B40246CEB31DA46F7F2DDFCB")
    
public static AccessibilityNodeInfo obtain(AccessibilityNodeInfo info) {
        AccessibilityNodeInfo infoClone = AccessibilityNodeInfo.obtain();
        infoClone.init(info);
        return infoClone;
    }

    /**
     * Gets the human readable action symbolic name.
     *
     * @param action The action.
     * @return The symbolic name.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.396 -0500", hash_original_method = "9281FA443503FD33DEEF9EAD3B753685", hash_generated_method = "391A03671E05FAA090F547861109E519")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.165 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.167 -0500", hash_original_field = "8BF5B7BB2C741E6F51882B1E85E5F169", hash_generated_field = "1E642CC81E6D04170ACE577F1365D5E0")

    private static final int UNDEFINED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.170 -0500", hash_original_field = "617EB5A49831D4E42CC1FEF3965E4033", hash_generated_field = "F78F9523CB351E82CADC0E3370F65663")

    /**
     * Action that focuses the node.
     */
    public static final int ACTION_FOCUS =  0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.172 -0500", hash_original_field = "9F650D1FD27771928876D8E4DD202D99", hash_generated_field = "4E51052F791AAD7CED4606387206AC02")

    public static final int ACTION_CLEAR_FOCUS =  0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.175 -0500", hash_original_field = "0DF782BD9DC3375190032A37A32E539E", hash_generated_field = "D94F4C12E9D93257353DF25CED690B59")

    public static final int ACTION_SELECT =  0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.177 -0500", hash_original_field = "8ECD989E8F1471431728127462E951C5", hash_generated_field = "A07F23DA35D396F8F58D59EF3496C08F")

    public static final int ACTION_CLEAR_SELECTION =  0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.180 -0500", hash_original_field = "38F0402B48ACCE9E87A19E99B3A66AE7", hash_generated_field = "2DB9EAF69D88F72EF9DAB34982534C44")

    private static final int PROPERTY_CHECKABLE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.183 -0500", hash_original_field = "0C66AFF2D8541261A0B2A0D23AEB1E69", hash_generated_field = "B133AF653A50358AF697DF69A4A6823C")

    private static final int PROPERTY_CHECKED = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.185 -0500", hash_original_field = "49E3E358AA29C3AD234669A2FA4C469C", hash_generated_field = "64C6A22B8C6EA12FFA53959DB5CB1AC7")

    private static final int PROPERTY_FOCUSABLE = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.188 -0500", hash_original_field = "08EC8F6268976332C120F0B9D22FC7BB", hash_generated_field = "8DD47CFB08AAE2F1FFE148EF01196F3B")

    private static final int PROPERTY_FOCUSED = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.190 -0500", hash_original_field = "74CF890CD065BDBE23D187753D0A7969", hash_generated_field = "A5A68047420291080F1C615B0F6E29B0")

    private static final int PROPERTY_SELECTED = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.192 -0500", hash_original_field = "F297618FC587300F756F2A34160BF2F8", hash_generated_field = "50075B897D9CD8F5C6101FBAEA5D5142")

    private static final int PROPERTY_CLICKABLE = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.194 -0500", hash_original_field = "528BD59BECB8DA7CAF52F91EB817191A", hash_generated_field = "01EE91AFAC64BC9573F67B7E369DF9C3")

    private static final int PROPERTY_LONG_CLICKABLE = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.198 -0500", hash_original_field = "ECCDF9B47C1E97A3E852CF4D0F16B5B7", hash_generated_field = "1BB05872028AC7F04961CEA7EB5D55AD")

    private static final int PROPERTY_ENABLED = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.200 -0500", hash_original_field = "C0786D0423EDF8836488CCE13FD021DE", hash_generated_field = "FA6F7D63DA0F9656A53E3D8231C0BA60")

    private static final int PROPERTY_PASSWORD = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.202 -0500", hash_original_field = "7D256A2786E5EBE6C4EB5B84199DAAAB", hash_generated_field = "AE0657BD515267A0780C3CEA30967A65")

    private static final int PROPERTY_SCROLLABLE = 0x00000200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.205 -0500", hash_original_field = "049949A8E5D40809FED217BA72F0C373", hash_generated_field = "2494066B81BE88B9C03D3B2C56E53F2B")

    private static final int MAX_POOL_SIZE = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.207 -0500", hash_original_field = "80BD8A730C8BC829BD11E3A3CFC39CA3", hash_generated_field = "515CCCD8D6622177DD93BECF774D048D")

    private static final Object sPoolLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.209 -0500", hash_original_field = "EC4D898A704B82EB372D0FBB852B9908", hash_generated_field = "50C4A0969A9F745384C40275BD9580FD")

    private static AccessibilityNodeInfo sPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.212 -0500", hash_original_field = "4147A9532CCAB604E1A40F8F844CAE62", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.411 -0400", hash_original_field = "5097BB38EB77934CDA5C991495565266", hash_generated_field = "CB2EF8290F0A294F0EAA84E012A5BB22")

    public static final Parcelable.Creator<AccessibilityNodeInfo> CREATOR =
            new Parcelable.Creator<AccessibilityNodeInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.411 -0500", hash_original_method = "41FF7B589DD370C35E95646D230DB9E3", hash_generated_method = "080CA144001B0DA333F18A90DD55A2B7")
        
public AccessibilityNodeInfo createFromParcel(Parcel parcel) {
            AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain();
            info.initFromParcel(parcel);
            return info;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.414 -0500", hash_original_method = "307ED09D70799D6E59BE60B4F21A4B77", hash_generated_method = "AF3C75FACACE73CCD92B50950A4E1135")
        
public AccessibilityNodeInfo[] newArray(int size) {
            return new AccessibilityNodeInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.214 -0500", hash_original_field = "7529D89125C85FA10C2D8024D951EA47", hash_generated_field = "C62243493B3195CCB3CA5EBD27BBE8A1")

    private AccessibilityNodeInfo mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.216 -0500", hash_original_field = "2CE23EB289B3963F8F89CE4E1DF951CB", hash_generated_field = "12FC58788D16ADAE0F5394F898FD4D99")

    private boolean mIsInPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.218 -0500", hash_original_field = "4B6C132CC4E1DABC021AFE92BC996668", hash_generated_field = "F484C63B720CA97398F62D332F1EF674")

    private boolean mSealed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.220 -0500", hash_original_field = "48275E4942155336CA3DDC8D19E8772B", hash_generated_field = "3F1B7BC9DC0772DFCA42C4ED21C8C0B3")

    private int mAccessibilityViewId = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.223 -0500", hash_original_field = "BE34C9497CE4831C1EA5DF13C84DB600", hash_generated_field = "5DFC012BAE7B65B646562BF7E0C7F019")

    private int mAccessibilityWindowId = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.226 -0500", hash_original_field = "18BB325F818163EFF02D1FB0BA9227A9", hash_generated_field = "ABBA6AEAFA3976D0777A287768B773F5")

    private int mParentAccessibilityViewId = UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.228 -0500", hash_original_field = "16EB928A608E490EDABD6C313699F6E2", hash_generated_field = "1B6EE350CEE9B789577F337242F99452")

    private int mBooleanProperties;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.230 -0500", hash_original_field = "DEA0B3451F133FB75362A1CC217D3E78", hash_generated_field = "D5987B3B232B41265934DB1B170A316C")

    private final Rect mBoundsInParent = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.232 -0500", hash_original_field = "B90B8287DE71B1A5A3C8348F2171D8D7", hash_generated_field = "EF4F29E41A2E9E11614CC0EF1E072CFA")

    private final Rect mBoundsInScreen = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.234 -0500", hash_original_field = "70581C252521204037775F3EA9D8E9F2", hash_generated_field = "6A9DFBEC5628781E76307C090C363D49")

    private CharSequence mPackageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.236 -0500", hash_original_field = "607E22FB74B4A9750077B62E99C7097B", hash_generated_field = "E65EE2088107B60FFFC2528EC1FA049B")

    private CharSequence mClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.239 -0500", hash_original_field = "A59BBC07E5E46996D793B2F37E80BD24", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.241 -0500", hash_original_field = "1D344C00C8D6A0BCC2A3B840B08C53BD", hash_generated_field = "8594C4137F32107058E48C17931382B5")

    private CharSequence mContentDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.244 -0500", hash_original_field = "8B2E9631D2C0D0CC2ABBA65DD6419D0B", hash_generated_field = "6EE62237A17F69CD965F14880008505D")

    private SparseIntArray mChildAccessibilityIds = new SparseIntArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.246 -0500", hash_original_field = "27B51C507A07119354FCC2F31A698CD2", hash_generated_field = "BAF3D762CB2D0F96BFE73E57C2472173")

    private int mActions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.248 -0500", hash_original_field = "8B5A4110581AEE7B543A400E2F63419C", hash_generated_field = "19848A63CACE6F8B90BC11DC69A6EB80")

    private int mConnectionId = UNDEFINED;

    /**
     * Hide constructor from clients.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.251 -0500", hash_original_method = "EB9F4328D2282B04E1BD31B0186E73D5", hash_generated_method = "2CFD36155427B3DA96125C34DE1AD0E6")
    
private AccessibilityNodeInfo() {
        /* do nothing */
    }

    /**
     * Sets the source.
     *
     * @param source The info source.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.253 -0500", hash_original_method = "D6E0A07A0224052514955EB47C47B111", hash_generated_method = "B0768DD9771DC23834BE3F5048303A52")
    
public void setSource(View source) {
        enforceNotSealed();
        mAccessibilityViewId = source.getAccessibilityViewId();
        mAccessibilityWindowId = source.getAccessibilityWindowId();
    }

    /**
     * Gets the id of the window from which the info comes from.
     *
     * @return The window id.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.256 -0500", hash_original_method = "6C41AAD35FD64A253FB83D406AD6C88C", hash_generated_method = "7FA239C11065357F8BE2BF8E10A8B6DC")
    
public int getWindowId() {
        return mAccessibilityWindowId;
    }

    /**
     * Gets the number of children.
     *
     * @return The child count.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.258 -0500", hash_original_method = "7C8926FBBCF561C891F2F5FFEAFED8AF", hash_generated_method = "7336BD0E8C8F2AD3910E9826485E3136")
    
public int getChildCount() {
        return mChildAccessibilityIds.size();
    }

    /**
     * Get the child at given index.
     * <p>
     *   <strong>Note:</strong> It is a client responsibility to recycle the
     *     received info by calling {@link AccessibilityNodeInfo#recycle()}
     *     to avoid creating of multiple instances.
     * </p>
     *
     * @param index The child index.
     * @return The child node.
     *
     * @throws IllegalStateException If called outside of an AccessibilityService.
     *
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.260 -0500", hash_original_method = "E9093B8E79E0C35ACECC8F5F72DA0B71", hash_generated_method = "7C1F662C65428D59AF8FE6D0094E79E7")
    
public AccessibilityNodeInfo getChild(int index) {
        enforceSealed();
        final int childAccessibilityViewId = mChildAccessibilityIds.get(index);
        if (!canPerformRequestOverConnection(childAccessibilityViewId)) {
            return null;
        }
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        return client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, childAccessibilityViewId);
    }

    /**
     * Adds a child.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param child The child.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.262 -0500", hash_original_method = "DCE0377A8D2F3327097D2FFFE36C9D81", hash_generated_method = "5108978EA7B0FF79CAB1DF4D80148D91")
    
public void addChild(View child) {
        enforceNotSealed();
        final int childAccessibilityViewId = child.getAccessibilityViewId();
        final int index = mChildAccessibilityIds.size();
        mChildAccessibilityIds.put(index, childAccessibilityViewId);
    }

    /**
     * Gets the actions that can be performed on the node.
     *
     * @return The bit mask of with actions.
     *
     * @see AccessibilityNodeInfo#ACTION_FOCUS
     * @see AccessibilityNodeInfo#ACTION_CLEAR_FOCUS
     * @see AccessibilityNodeInfo#ACTION_SELECT
     * @see AccessibilityNodeInfo#ACTION_CLEAR_SELECTION
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.265 -0500", hash_original_method = "60E376BAD814E27A83B622ADA78DD695", hash_generated_method = "B97242529A14D415A2C43E774342A447")
    
public int getActions() {
        return mActions;
    }

    /**
     * Adds an action that can be performed on the node.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param action The action.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.267 -0500", hash_original_method = "62A0FADACCC1DF1A8E35D414239187E3", hash_generated_method = "484349B69F2AE787D617F1DC70959E6B")
    
public void addAction(int action) {
        enforceNotSealed();
        mActions |= action;
    }

    /**
     * Performs an action on the node.
     * <p>
     *   <strong>Note:</strong> An action can be performed only if the request is made
     *   from an {@link android.accessibilityservice.AccessibilityService}.
     * </p>
     *
     * @param action The action to perform.
     * @return True if the action was performed.
     *
     * @throws IllegalStateException If called outside of an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.269 -0500", hash_original_method = "CDA2E61C3267971FAEFED5DF1BBF4146", hash_generated_method = "C4E25EF5BE24BB112C6D27E03FDB35F7")
    
public boolean performAction(int action) {
        enforceSealed();
        if (!canPerformRequestOverConnection(mAccessibilityViewId)) {
            return false;
        }
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        return client.performAccessibilityAction(mConnectionId, mAccessibilityWindowId,
                mAccessibilityViewId, action);
    }

    /**
     * Finds {@link AccessibilityNodeInfo}s by text. The match is case
     * insensitive containment. The search is relative to this info i.e.
     * this info is the root of the traversed tree.
     *
     * <p>
     *   <strong>Note:</strong> It is a client responsibility to recycle the
     *     received info by calling {@link AccessibilityNodeInfo#recycle()}
     *     to avoid creating of multiple instances.
     * </p>
     *
     * @param text The searched text.
     * @return A list of node info.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.273 -0500", hash_original_method = "DAAF9FBDD74DB58981A13A4C1D5FEB20", hash_generated_method = "29C8DFED70CB9A41ED0DF39E558A517F")
    
public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text) {
        enforceSealed();
        if (!canPerformRequestOverConnection(mAccessibilityViewId)) {
            return Collections.emptyList();
        }
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        return client.findAccessibilityNodeInfosByViewText(mConnectionId, text,
                mAccessibilityWindowId, mAccessibilityViewId);
    }

    /**
     * Gets the parent.
     * <p>
     *   <strong>Note:</strong> It is a client responsibility to recycle the
     *     received info by calling {@link AccessibilityNodeInfo#recycle()}
     *     to avoid creating of multiple instances.
     * </p>
     *
     * @return The parent.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.275 -0500", hash_original_method = "F4DB109D13E56E0D98A6319CC588873D", hash_generated_method = "EA071BCDC57E94EA0FBFC36A75B68395")
    
public AccessibilityNodeInfo getParent() {
        enforceSealed();
        if (!canPerformRequestOverConnection(mParentAccessibilityViewId)) {
            return null;
        }
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance();
        return client.findAccessibilityNodeInfoByAccessibilityId(mConnectionId,
                mAccessibilityWindowId, mParentAccessibilityViewId);
    }

    /**
     * Sets the parent.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param parent The parent.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.278 -0500", hash_original_method = "0FE0BB8E7E891FFE4D867C8196AE43B4", hash_generated_method = "B862371144AE2D17ADD412F9AC4626C5")
    
public void setParent(View parent) {
        enforceNotSealed();
        mParentAccessibilityViewId = parent.getAccessibilityViewId();
    }

    /**
     * Gets the node bounds in parent coordinates.
     *
     * @param outBounds The output node bounds.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.280 -0500", hash_original_method = "908AD8B1395D82502A9E3BA629915EF5", hash_generated_method = "097ED502D94A8EABDA2926021E9593AB")
    
public void getBoundsInParent(Rect outBounds) {
        outBounds.set(mBoundsInParent.left, mBoundsInParent.top,
                mBoundsInParent.right, mBoundsInParent.bottom);
    }

    /**
     * Sets the node bounds in parent coordinates.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param bounds The node bounds.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.282 -0500", hash_original_method = "DC2A2D1F16BCFDB8F09D047ED8729F2A", hash_generated_method = "BB4DFEC82A270850989D1E81907DDAD5")
    
public void setBoundsInParent(Rect bounds) {
        enforceNotSealed();
        mBoundsInParent.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    /**
     * Gets the node bounds in screen coordinates.
     *
     * @param outBounds The output node bounds.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.285 -0500", hash_original_method = "2F98E8EF78DCE8F1C352462875EB84AE", hash_generated_method = "AEDBB033D07B1445DA0AE23CCEBAFC1B")
    
public void getBoundsInScreen(Rect outBounds) {
        outBounds.set(mBoundsInScreen.left, mBoundsInScreen.top,
                mBoundsInScreen.right, mBoundsInScreen.bottom);
    }

    /**
     * Sets the node bounds in screen coordinates.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param bounds The node bounds.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.287 -0500", hash_original_method = "770F78071B2EB9D2396840AB4AD2ADB5", hash_generated_method = "04DB0EE04ED4620E2D4573D5295ECDF8")
    
public void setBoundsInScreen(Rect bounds) {
        enforceNotSealed();
        mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    /**
     * Gets whether this node is checkable.
     *
     * @return True if the node is checkable.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.289 -0500", hash_original_method = "67B4AEAF1632FE4AAC04770D8458ACB9", hash_generated_method = "8766A25A720CD31004A298C1394F1744")
    
public boolean isCheckable() {
        return getBooleanProperty(PROPERTY_CHECKABLE);
    }

    /**
     * Sets whether this node is checkable.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param checkable True if the node is checkable.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.291 -0500", hash_original_method = "516AC58EA6CB8A6948778CD704999386", hash_generated_method = "4862A301DEE8D182A6712253F9109D40")
    
public void setCheckable(boolean checkable) {
        setBooleanProperty(PROPERTY_CHECKABLE, checkable);
    }

    /**
     * Gets whether this node is checked.
     *
     * @return True if the node is checked.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.294 -0500", hash_original_method = "5A67E197C5983AA9D4F6364A1A3A1EA0", hash_generated_method = "D9CD50EE9CC4C5741F1B86BD0C60AA6A")
    
public boolean isChecked() {
        return getBooleanProperty(PROPERTY_CHECKED);
    }

    /**
     * Sets whether this node is checked.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param checked True if the node is checked.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.296 -0500", hash_original_method = "930075A9DA99BE3539B9BAFC112A5160", hash_generated_method = "E3F1ADAF5AA4E7375D26140A03C7C90F")
    
public void setChecked(boolean checked) {
        setBooleanProperty(PROPERTY_CHECKED, checked);
    }

    /**
     * Gets whether this node is focusable.
     *
     * @return True if the node is focusable.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.298 -0500", hash_original_method = "BEA45F3FF1A12FCE09D72D148357CE2C", hash_generated_method = "FD3F79F70B251E4A14F02A622C256052")
    
public boolean isFocusable() {
        return getBooleanProperty(PROPERTY_FOCUSABLE);
    }

    /**
     * Sets whether this node is focusable.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param focusable True if the node is focusable.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.301 -0500", hash_original_method = "A4FE2C9F5A8AC78848A5BB7FA1A98C8F", hash_generated_method = "134AF0816CBDF82D5886CE028A3B9EB8")
    
public void setFocusable(boolean focusable) {
        setBooleanProperty(PROPERTY_FOCUSABLE, focusable);
    }

    /**
     * Gets whether this node is focused.
     *
     * @return True if the node is focused.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.303 -0500", hash_original_method = "3CD3FFF6959365D82FD80FF1FA237F64", hash_generated_method = "E80F12D445B25F55B6F9568407812C4E")
    
public boolean isFocused() {
        return getBooleanProperty(PROPERTY_FOCUSED);
    }

    /**
     * Sets whether this node is focused.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param focused True if the node is focused.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.305 -0500", hash_original_method = "6C2B5793CEDC3F6B1248DAB365B53404", hash_generated_method = "556C06FB803FC6F62DE8D25C00AF067B")
    
public void setFocused(boolean focused) {
        setBooleanProperty(PROPERTY_FOCUSED, focused);
    }

    /**
     * Gets whether this node is selected.
     *
     * @return True if the node is selected.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.307 -0500", hash_original_method = "0C97805A247814CF6CABD75572FD40C1", hash_generated_method = "757A39203D2893FD9ADFD6F0F1221CB5")
    
public boolean isSelected() {
        return getBooleanProperty(PROPERTY_SELECTED);
    }

    /**
     * Sets whether this node is selected.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param selected True if the node is selected.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.309 -0500", hash_original_method = "0890254D4AC82258F1AAEA57F8827B54", hash_generated_method = "3F08ADF8B86A84D31BD7B7C6BD7E0AEA")
    
public void setSelected(boolean selected) {
        setBooleanProperty(PROPERTY_SELECTED, selected);
    }

    /**
     * Gets whether this node is clickable.
     *
     * @return True if the node is clickable.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.312 -0500", hash_original_method = "9E42D14BA1D4CF35C9E8D228C35BEE02", hash_generated_method = "2506025912135D07C3655F3858D23D3C")
    
public boolean isClickable() {
        return getBooleanProperty(PROPERTY_CLICKABLE);
    }

    /**
     * Sets whether this node is clickable.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param clickable True if the node is clickable.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.314 -0500", hash_original_method = "2AB4084D18C97615027F882B075290EA", hash_generated_method = "587A02CEC97FDC23A4227EAE10EAE6C1")
    
public void setClickable(boolean clickable) {
        setBooleanProperty(PROPERTY_CLICKABLE, clickable);
    }

    /**
     * Gets whether this node is long clickable.
     *
     * @return True if the node is long clickable.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.317 -0500", hash_original_method = "30EDA8A2E8A402543ACC7CC56FF92053", hash_generated_method = "CDA58C7A453680B4915870F14726B7C2")
    
public boolean isLongClickable() {
        return getBooleanProperty(PROPERTY_LONG_CLICKABLE);
    }

    /**
     * Sets whether this node is long clickable.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param longClickable True if the node is long clickable.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.319 -0500", hash_original_method = "BBEB96E07778625102E9D70952371D0D", hash_generated_method = "3A6C1DB697D2E264D8ADA130FC8FA2BB")
    
public void setLongClickable(boolean longClickable) {
        setBooleanProperty(PROPERTY_LONG_CLICKABLE, longClickable);
    }

    /**
     * Gets whether this node is enabled.
     *
     * @return True if the node is enabled.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.322 -0500", hash_original_method = "BBEF4BC19B4322B516FB3983E945CAF6", hash_generated_method = "F197DE3582D7DA20C6044E50A654B0C1")
    
public boolean isEnabled() {
        return getBooleanProperty(PROPERTY_ENABLED);
    }

    /**
     * Sets whether this node is enabled.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param enabled True if the node is enabled.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.324 -0500", hash_original_method = "2D7E6331314DB7964C417618AC2EB5EA", hash_generated_method = "A6C15B8E32077183A0CADDAA94492167")
    
public void setEnabled(boolean enabled) {
        setBooleanProperty(PROPERTY_ENABLED, enabled);
    }

    /**
     * Gets whether this node is a password.
     *
     * @return True if the node is a password.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.326 -0500", hash_original_method = "8ACE5368F7F34FD7A997EC13F4BFCCE5", hash_generated_method = "E655A327F19083075E83F5EF7D96B406")
    
public boolean isPassword() {
        return getBooleanProperty(PROPERTY_PASSWORD);
    }

    /**
     * Sets whether this node is a password.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param password True if the node is a password.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.328 -0500", hash_original_method = "4C0E98701874539EDF8F49BF5002C98F", hash_generated_method = "4999C0531E23CE05A038C8BD67D1727E")
    
public void setPassword(boolean password) {
        setBooleanProperty(PROPERTY_PASSWORD, password);
    }

    /**
     * Gets if the node is scrollable.
     *
     * @return True if the node is scrollable, false otherwise.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.331 -0500", hash_original_method = "F5E2B33BAA7F2110DB7AE2D50276D662", hash_generated_method = "E07D899195A0F34DC826BBB3CFA25B61")
    
public boolean isScrollable() {
        return getBooleanProperty(PROPERTY_SCROLLABLE);
    }

    /**
     * Sets if the node is scrollable.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param scrollable True if the node is scrollable, false otherwise.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.333 -0500", hash_original_method = "C8E19EB47E895659C0D234F60CD63E87", hash_generated_method = "12E034E4311AAEA337DF8A82E5AB3864")
    
public void setScrollable(boolean scrollable) {
        enforceNotSealed();
        setBooleanProperty(PROPERTY_SCROLLABLE, scrollable);
    }

    /**
     * Gets the package this node comes from.
     *
     * @return The package name.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.336 -0500", hash_original_method = "6D18CADAD3BE855C953B6A82043EA347", hash_generated_method = "62E16594ED1E4D773FC387EB5B07A489")
    
public CharSequence getPackageName() {
        return mPackageName;
    }

    /**
     * Sets the package this node comes from.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param packageName The package name.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.338 -0500", hash_original_method = "D35D1C42C7BD5A2BDF03FC6BDBDF64EE", hash_generated_method = "194D21D70E7FE29679C690B456C3D46C")
    
public void setPackageName(CharSequence packageName) {
        enforceNotSealed();
        mPackageName = packageName;
    }

    /**
     * Gets the class this node comes from.
     *
     * @return The class name.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.340 -0500", hash_original_method = "3625856433EBE1C9C9A90132A3C58D3F", hash_generated_method = "26599164AEA75289AA6AEFE666301F84")
    
public CharSequence getClassName() {
        return mClassName;
    }

    /**
     * Sets the class this node comes from.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param className The class name.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.343 -0500", hash_original_method = "435BCAB2D716154C6ED3D9D2DD11028E", hash_generated_method = "FED8F14A8D334A8BA08886C8CE2F0CE9")
    
public void setClassName(CharSequence className) {
        enforceNotSealed();
        mClassName = className;
    }

    /**
     * Gets the text of this node.
     *
     * @return The text.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.345 -0500", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "3C5AE00E10DCE5E04049FCC58EEF7C48")
    
public CharSequence getText() {
        return mText;
    }

    /**
     * Sets the text of this node.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param text The text.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.347 -0500", hash_original_method = "B470A357BC33F6D7BBE8C746674F6216", hash_generated_method = "367BBC284555BC89661C3294BC7AFFFD")
    
public void setText(CharSequence text) {
        enforceNotSealed();
        mText = text;
    }

    /**
     * Gets the content description of this node.
     *
     * @return The content description.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.349 -0500", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "F956064663F9FEBB2E9D4DEF23399995")
    
public CharSequence getContentDescription() {
        return mContentDescription;
    }

    /**
     * Sets the content description of this node.
     * <p>
     *   <strong>Note:</strong> Cannot be called from an
     *   {@link android.accessibilityservice.AccessibilityService}.
     *   This class is made immutable before being delivered to an AccessibilityService.
     * </p>
     *
     * @param contentDescription The content description.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("View state info")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.352 -0500", hash_original_method = "85E1231CCD16E203B9FBFBDBF6F7490E", hash_generated_method = "E1714B81DD2746B9FD1113A5037215C7")
    
public void setContentDescription(CharSequence contentDescription) {
        enforceNotSealed();
        mContentDescription = contentDescription;
    }

    /**
     * Gets the value of a boolean property.
     *
     * @param property The property.
     * @return The value.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.354 -0500", hash_original_method = "08ED9648E2048980BB715C0F95464D97", hash_generated_method = "722E5652297D2701C0DDED881D11EBE2")
    
private boolean getBooleanProperty(int property) {
        return (mBooleanProperties & property) != 0;
    }

    /**
     * Sets a boolean property.
     *
     * @param property The property.
     * @param value The value.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.356 -0500", hash_original_method = "AF4B29064CFE4EC4A14EBB7B9CA58D1B", hash_generated_method = "5034AB41514D2117BB56974500CD2E7A")
    
private void setBooleanProperty(int property, boolean value) {
        enforceNotSealed();
        if (value) {
            mBooleanProperties |= property;
        } else {
            mBooleanProperties &= ~property;
        }
    }

    /**
     * Sets the unique id of the IAccessibilityServiceConnection over which
     * this instance can send requests to the system.
     *
     * @param connectionId The connection id.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.358 -0500", hash_original_method = "0D9114E83A94DAB2C664FA6E45C487C9", hash_generated_method = "BC4D7D397131B35AD8A5BAEE310B718C")
    
public void setConnectionId(int connectionId) {
        enforceNotSealed();
        mConnectionId = connectionId;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.361 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Sets if this instance is sealed.
     *
     * @param sealed Whether is sealed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.363 -0500", hash_original_method = "7730BDD0DFF4FE8B243CA8BC305ED86E", hash_generated_method = "D19C5B16DCE00646203E99ED6C851A4E")
    
public void setSealed(boolean sealed) {
        mSealed = sealed;
    }

    /**
     * Gets if this instance is sealed.
     *
     * @return Whether is sealed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.365 -0500", hash_original_method = "AF3422E1C079F6B2A15130B45797502F", hash_generated_method = "F23B568E45220201E3D8D9529E5C4B1C")
    
public boolean isSealed() {
        return mSealed;
    }

    /**
     * Enforces that this instance is sealed.
     *
     * @throws IllegalStateException If this instance is not sealed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.368 -0500", hash_original_method = "0309B89A8A5C20FB439CB65AA9DE3FAA", hash_generated_method = "C604CEA8A3BAA88EE6676A4CDACE3183")
    
protected void enforceSealed() {
        if (!isSealed()) {
            throw new IllegalStateException("Cannot perform this "
                    + "action on a not sealed instance.");
        }
    }

    /**
     * Enforces that this instance is not sealed.
     *
     * @throws IllegalStateException If this instance is sealed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.371 -0500", hash_original_method = "9B7C20934D3E00C37812C7E94DAAB15E", hash_generated_method = "8D6BEA9AE61E0A5A192D26A24FF1BFC1")
    
protected void enforceNotSealed() {
        if (isSealed()) {
            throw new IllegalStateException("Cannot perform this "
                    + "action on an sealed instance.");
        }
    }

    /**
     * Return an instance back to be reused.
     * <p>
     * <strong>Note:</strong> You must not touch the object after calling this function.
     *
     * @throws IllegalStateException If the info is already recycled.
     */
    @DSComment("no relevant action/ recycle the node for reuse")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.382 -0500", hash_original_method = "E5AEF2A1BB846A92BC2380F50D2ACE39", hash_generated_method = "28E3232D4639B15DA8B0278859F6B718")
    
public void recycle() {
        if (mIsInPool) {
            throw new IllegalStateException("Info already recycled!");
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
     * {@inheritDoc}
     * <p>
     *   <strong>Note:</strong> After the instance is written to a parcel it
     *      is recycled. You must not touch the object after calling this function.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.385 -0500", hash_original_method = "CE4668F7872E1547EB7B822B86C2AD44", hash_generated_method = "4702C75306CD7D2A7AAA5B0E1291FEC2")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(isSealed() ? 1 : 0);
        parcel.writeInt(mAccessibilityViewId);
        parcel.writeInt(mAccessibilityWindowId);
        parcel.writeInt(mParentAccessibilityViewId);
        parcel.writeInt(mConnectionId);

        SparseIntArray childIds = mChildAccessibilityIds;
        final int childIdsSize = childIds.size();
        parcel.writeInt(childIdsSize);
        for (int i = 0; i < childIdsSize; i++) {
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

        // Since instances of this class are fetched via synchronous i.e. blocking
        // calls in IPCs we always recycle as soon as the instance is marshaled.
        recycle();
    }

    /**
     * Initializes this instance from another one.
     *
     * @param other The other instance.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.387 -0500", hash_original_method = "84525B5DDEB8A0E58F9024DAD2E7A518", hash_generated_method = "3B025416C0341984FEB74CA30FB3B7FC")
    
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

    /**
     * Creates a new instance from a {@link Parcel}.
     *
     * @param parcel A parcel containing the state of a {@link AccessibilityNodeInfo}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.391 -0500", hash_original_method = "98923D5E356E47505C0A26C0C57920A8", hash_generated_method = "EC619F199FF71492D62428352C5E07E2")
    
private void initFromParcel(Parcel parcel) {
        mSealed = (parcel.readInt()  == 1);
        mAccessibilityViewId = parcel.readInt();
        mAccessibilityWindowId = parcel.readInt();
        mParentAccessibilityViewId = parcel.readInt();
        mConnectionId = parcel.readInt();

        SparseIntArray childIds = mChildAccessibilityIds;
        final int childrenSize = parcel.readInt();
        for (int i = 0; i < childrenSize; i++) {
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

    /**
     * Clears the state of this instance.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.393 -0500", hash_original_method = "566B1830900B4F3B865C25C43FCDC943", hash_generated_method = "47DE232BB9CC3750C4E0F95FF7F436AA")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.398 -0500", hash_original_method = "554416B444549B4EB33FDEE3DD8518FA", hash_generated_method = "B64BAFB1492494C16331DCA440BBD62E")
    
private boolean canPerformRequestOverConnection(int accessibilityViewId) {
        return (mConnectionId != UNDEFINED && mAccessibilityWindowId != UNDEFINED
                && accessibilityViewId != UNDEFINED);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.400 -0500", hash_original_method = "75F2609B8EC69930F0DC5E65EF5711F8", hash_generated_method = "547EDF81AA61F05F1F04339744629523")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        AccessibilityNodeInfo other = (AccessibilityNodeInfo) object;
        if (mAccessibilityViewId != other.mAccessibilityViewId) {
            return false;
        }
        if (mAccessibilityWindowId != other.mAccessibilityWindowId) {
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.403 -0500", hash_original_method = "5729DB4BFFEF2935F7B53D1FC3170C4A", hash_generated_method = "2F767CA7830A519E1F2E22BC73A1E407")
    
@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + mAccessibilityViewId;
        result = prime * result + mAccessibilityWindowId;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:50.408 -0500", hash_original_method = "9C50A737351E97FBF1CC9E56A50E9FD3", hash_generated_method = "50579DAE0D98816BD095F00DF2AC90C3")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());

        if (DEBUG) {
            builder.append("; accessibilityId: " + mAccessibilityViewId);
            builder.append("; parentAccessibilityId: " + mParentAccessibilityViewId);
            SparseIntArray childIds = mChildAccessibilityIds;
            builder.append("; childAccessibilityIds: [");
            for (int i = 0, count = childIds.size(); i < count; i++) {
                builder.append(childIds.valueAt(i));
                if (i < count - 1) {
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

        for (int actionBits = mActions; actionBits != 0;) {
            final int action = 1 << Integer.numberOfTrailingZeros(actionBits);
            actionBits &= ~action;
            builder.append(getActionSymbolicName(action));
            if (actionBits != 0) {
                builder.append(", ");
            }
        }

        builder.append("]");

        return builder.toString();
    }
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

