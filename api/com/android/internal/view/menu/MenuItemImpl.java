package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;





public final class MenuItemImpl implements MenuItem {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.160 -0500", hash_original_field = "C708DC845CCB118E0188D85691D8F99D", hash_generated_field = "8A8FA0202935EA55AD54CD7CFED45C98")

    private static final String TAG = "MenuItemImpl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.162 -0500", hash_original_field = "7981CDB2AE281F30AAC56F01F175B7B0", hash_generated_field = "11894259A35F1BBB9E7F27DD18921EDE")

    
    private static final int SHOW_AS_ACTION_MASK = SHOW_AS_ACTION_NEVER |
            SHOW_AS_ACTION_IF_ROOM |
            SHOW_AS_ACTION_ALWAYS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.208 -0500", hash_original_field = "90654049052F718180E995FFF6612EFC", hash_generated_field = "943315568AC97A95BEE7FD4A533D08C8")

    private static final int CHECKABLE      = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.211 -0500", hash_original_field = "DDAF50494EDE92B5A907F7788646DD1D", hash_generated_field = "79E18373E7678760190793C5FAA4E940")

    private static final int CHECKED        = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.213 -0500", hash_original_field = "3133F3AB867F08EB7F5C188557ADF8DE", hash_generated_field = "80F27CAAB6801F818B589E02F88FCA4D")

    private static final int EXCLUSIVE      = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.216 -0500", hash_original_field = "D1A8B498453E3580610DDDDF65EDF69E", hash_generated_field = "14D725A9241DDEAEF12149E98726A5C2")

    private static final int HIDDEN         = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.218 -0500", hash_original_field = "9E28E33B02832F7297D3046B6A7FB712", hash_generated_field = "9D7A6896B452AD15AEC725047E2938A0")

    private static final int ENABLED        = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.221 -0500", hash_original_field = "0E20AAD2047A12ADBDDA0DF4352992F8", hash_generated_field = "C127B9B1DB91997F1F1D61DE17C3AF8E")

    private static final int IS_ACTION      = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.235 -0500", hash_original_field = "85EA99D3EE3FBF5630E4D962E96A8E74", hash_generated_field = "3EDC205933905E009C1CD4D66D782972")

    static final int NO_ICON = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.240 -0500", hash_original_field = "59B421A8FE3BC25F62030250529693D7", hash_generated_field = "FC531438BE18962F76B22C0A35F07352")

    
    private static String sPrependShortcutLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.242 -0500", hash_original_field = "E28D41981900365F630C914E443EB78B", hash_generated_field = "DF49530CB048FF09160A19CF46D02A0E")

    private static String sEnterShortcutLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.245 -0500", hash_original_field = "5B77358A1AAF43094E975F404FC13AC4", hash_generated_field = "E00B0A704D720C24AE1BBC26B39D8B85")

    private static String sDeleteShortcutLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.247 -0500", hash_original_field = "8910E496ECB4B5082B1A433A77F322E3", hash_generated_field = "9D3B92E22BB5269C378158F8ED50B0E4")

    private static String sSpaceShortcutLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.165 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")


    private  int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.169 -0500", hash_original_field = "9C43571C45B8BC34B7C8A06B2271F04A", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private  int mGroup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.172 -0500", hash_original_field = "F6DD8D04E6975C66628782A471D540ED", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private  int mCategoryOrder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.174 -0500", hash_original_field = "3D9DE4CD049B86E1600012D5AF1467A8", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private  int mOrdering;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.176 -0500", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.178 -0500", hash_original_field = "FA3171B1888A35931DDF94EF6B72DFBA", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.181 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.183 -0500", hash_original_field = "48B12B8F5B9FDB1D830B92E86520B6F6", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.186 -0500", hash_original_field = "4416434619B59B48D8ADBB443F744028", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.189 -0500", hash_original_field = "E7758D8423F0CD19BF50F0B56DC871A4", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.191 -0500", hash_original_field = "90FECF5DA6E08407086BFE725E64094A", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")
 
    private int mIconResId = NO_ICON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.194 -0500", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.196 -0500", hash_original_field = "F72B98E23896D66B33476F874979B6CA", hash_generated_field = "CCE2E7E9B41EB859D026207A515694B8")

    private SubMenuBuilder mSubMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.198 -0500", hash_original_field = "1A7931F59B15F85E44E48C3C0BA36CF4", hash_generated_field = "E128AFA2E0B8F17E3CC9B8F36180ADD8")

    
    private Runnable mItemCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.202 -0500", hash_original_field = "E14C5536FD73A354B761BD4CA9460340", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")

    private MenuItem.OnMenuItemClickListener mClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.204 -0500", hash_original_field = "87B4121714640703C04C2D7C1C71B5DF", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")


    private int mFlags = ENABLED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.223 -0500", hash_original_field = "69A7B4CA5D0B8456F60CBDC3F3253EA7", hash_generated_field = "7FED0AA513FCAFE5BBB64F7D855AC56C")


    private int mShowAsAction = SHOW_AS_ACTION_NEVER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.225 -0500", hash_original_field = "CF9B01C975925C0DA31724E1293F9F0D", hash_generated_field = "67E37FA198462CB2D5A9B9320B838135")


    private View mActionView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.227 -0500", hash_original_field = "F9AA1331F7CB2C9D557F643AF8FB1074", hash_generated_field = "43987C5D315D6540F5B86319E4F6655F")

    private ActionProvider mActionProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.230 -0500", hash_original_field = "98F918054CAFFFDA6219B58A6C85B677", hash_generated_field = "784094F6CF284A96EDEED4548B8FB05D")

    private OnActionExpandListener mOnActionExpandListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.232 -0500", hash_original_field = "B289A78D4D56C56810318DDEA40BF3FC", hash_generated_field = "06A110AC8494F5C7468903392B66FD97")

    private boolean mIsActionViewExpanded = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.237 -0500", hash_original_field = "90649C9C885A9727EF12DE68AC0B1F2F", hash_generated_field = "B7A128C3CB7F07DDB09B9D1855650533")
 
    private ContextMenuInfo mMenuInfo;
    
    
    /**
     * Instantiates this menu item.
     *
     * @param menu
     * @param group Item ordering grouping control. The item will be added after
     *            all other items whose order is <= this number, and before any
     *            that are larger than it. This can also be used to define
     *            groups of items for batch state changes. Normally use 0.
     * @param id Unique item ID. Use 0 if you do not need a unique ID.
     * @param categoryOrder The ordering for this item.
     * @param title The text to display for the item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.250 -0500", hash_original_method = "64F6A72F78EB0039947A0530C3919D96", hash_generated_method = "A20B17C2FAE41E0FE8ECB3D168D178C1")
    
MenuItemImpl(MenuBuilder menu, int group, int id, int categoryOrder, int ordering,
            CharSequence title, int showAsAction) {

        if (sPrependShortcutLabel == null) {
            // This is instantiated from the UI thread, so no chance of sync issues 
            sPrependShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.prepend_shortcut_label);
            sEnterShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_enter_shortcut_label);
            sDeleteShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_delete_shortcut_label);
            sSpaceShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_space_shortcut_label);
        }
        
        mMenu = menu;
        mId = id;
        mGroup = group;
        mCategoryOrder = categoryOrder;
        mOrdering = ordering;
        mTitle = title;
        mShowAsAction = showAsAction;
    }
    
    /**
     * Invokes the item by calling various listeners or callbacks.
     * 
     * @return true if the invocation was handled, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.253 -0500", hash_original_method = "DCB176B376623FC7561DCD073EB66D0A", hash_generated_method = "BC07DF84425BB82DDA544CDA0E99B7FE")
    
public boolean invoke() {
        if (mClickListener != null &&
            mClickListener.onMenuItemClick(this)) {
            return true;
        }

        if (mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this)) {
            return true;
        }

        if (mItemCallback != null) {
            mItemCallback.run();
            return true;
        }

        if (mIntent != null) {
            try {
                mMenu.getContext().startActivity(mIntent);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e(TAG, "Can't find activity to handle intent; ignoring", e);
            }
        }

        if (mActionProvider != null && mActionProvider.onPerformDefaultAction()) {
            return true;
        }

        return false;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.255 -0500", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "AECBB7E5FCE868E97452BAD92DC2A2C3")
    
public boolean isEnabled() {
        return (mFlags & ENABLED) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.257 -0500", hash_original_method = "D7CDC1A4A52E7AA2B30AF0AEE42BB489", hash_generated_method = "027B24EBA2CBC69B4BE70A641C93A1FC")
    
public MenuItem setEnabled(boolean enabled) {
        if (enabled) {
            mFlags |= ENABLED;
        } else {
            mFlags &= ~ENABLED;
        }

        mMenu.onItemsChanged(false);
        
        return this;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.260 -0500", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "92A3BA6D09A85A547821EFB39597530D")
    
public int getGroupId() {
        return mGroup;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.262 -0500", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "1317CA6C177DD5E384638FF9B9D3B0E0")
    
@ViewDebug.CapturedViewProperty
    public int getItemId() {
        return mId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.264 -0500", hash_original_method = "C3905BED22935FA2186A402E1BBD1829", hash_generated_method = "20049C831CB934DCFE00AEED81052B69")
    
public int getOrder() {
        return mCategoryOrder;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.266 -0500", hash_original_method = "92E8F82AA50FD1AD58335B2DC7895A83", hash_generated_method = "86ECFC944B9ECDE2A30AF3BDF41C6AF2")
    
public int getOrdering() {
        return mOrdering; 
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.268 -0500", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "7CE6D2E5920E17BB1B744A5090D635BC")
    
public Intent getIntent() {
        return mIntent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.270 -0500", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "FC870B7BE66B774D28C4327475BB97C9")
    
public MenuItem setIntent(Intent intent) {
        mIntent = intent;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.272 -0500", hash_original_method = "C32C9CAC3047604A3F615D0E2B0A3D92", hash_generated_method = "C32C9CAC3047604A3F615D0E2B0A3D92")
    
Runnable getCallback() {
        return mItemCallback;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.274 -0500", hash_original_method = "CAD9375B57D68888676D597787CB9AA1", hash_generated_method = "0D75E48DE09605C569BED85BD011E981")
    
public MenuItem setCallback(Runnable callback) {
        mItemCallback = callback;
        return this;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.276 -0500", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "C6CC3463628F299A61B99559C4F6FF3E")
    
public char getAlphabeticShortcut() {
        return mShortcutAlphabeticChar;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.279 -0500", hash_original_method = "88D9907A20D6B14742A0B31CE890DEE4", hash_generated_method = "4765654F81D049EFED2FFE80F4792B0E")
    
public MenuItem setAlphabeticShortcut(char alphaChar) {
        if (mShortcutAlphabeticChar == alphaChar) return this;
        
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        
        mMenu.onItemsChanged(false);
        
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.281 -0500", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "C2D13B8EBB073B93C575296CDD9268AC")
    
public char getNumericShortcut() {
        return mShortcutNumericChar;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.283 -0500", hash_original_method = "C979D44A5E5C9CB1A686CC5CF090F436", hash_generated_method = "5CD656EAC51B1D24F28A2F01A6A15115")
    
public MenuItem setNumericShortcut(char numericChar) {
        if (mShortcutNumericChar == numericChar) return this;
        
        mShortcutNumericChar = numericChar;
        
        mMenu.onItemsChanged(false);
        
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.285 -0500", hash_original_method = "0C4A5B3F8F292031B8A33F43134542C3", hash_generated_method = "FCA4FEC30C9C14FC2320A6AA9492D3A7")
    
public MenuItem setShortcut(char numericChar, char alphaChar) {
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        
        mMenu.onItemsChanged(false);
        
        return this;
    }

    /**
     * @return The active shortcut (based on QWERTY-mode of the menu).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.287 -0500", hash_original_method = "D96803BF052A5945B7D152CA36FE6B7E", hash_generated_method = "D96803BF052A5945B7D152CA36FE6B7E")
    
char getShortcut() {
        return (mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar);
    }
    
    /**
     * @return The label to show for the shortcut. This includes the chording
     *         key (for example 'Menu+a'). Also, any non-human readable
     *         characters should be human readable (for example 'Menu+enter').
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.290 -0500", hash_original_method = "BC454AC179D3698A29B0357FA131C3B2", hash_generated_method = "BC454AC179D3698A29B0357FA131C3B2")
    
String getShortcutLabel() {

        char shortcut = getShortcut();
        if (shortcut == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder(sPrependShortcutLabel);
        switch (shortcut) {
        
            case '\n':
                sb.append(sEnterShortcutLabel);
                break;
            
            case '\b':
                sb.append(sDeleteShortcutLabel);
                break;
            
            case ' ':
                sb.append(sSpaceShortcutLabel);
                break;
            
            default:
                sb.append(shortcut);
                break;
        }
        
        return sb.toString();
    }
    
    /**
     * @return Whether this menu item should be showing shortcuts (depends on
     *         whether the menu should show shortcuts and whether this item has
     *         a shortcut defined)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.293 -0500", hash_original_method = "10F1B2AEF5DA21C52B4C4E0F70D42C6B", hash_generated_method = "94CAC6D43EF5F3E660F3D52EFEF9FDCE")
    
boolean shouldShowShortcut() {
        // Show shortcuts if the menu is supposed to show shortcuts AND this item has a shortcut
        return mMenu.isShortcutsVisible() && (getShortcut() != 0);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.295 -0500", hash_original_method = "4569B511D747F82913D0DE9D1EF62E55", hash_generated_method = "9FA931FE199DCF0DC73BBAF006E0DC11")
    
public SubMenu getSubMenu() {
        return mSubMenu;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.297 -0500", hash_original_method = "4556386DBA75360C55B0D4465EB5905E", hash_generated_method = "A025273C95280FA865C2AF35AB1B0983")
    
public boolean hasSubMenu() {
        return mSubMenu != null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.299 -0500", hash_original_method = "84077AC2D714BDDE1A3A80B85CC9BFB0", hash_generated_method = "84077AC2D714BDDE1A3A80B85CC9BFB0")
    
void setSubMenu(SubMenuBuilder subMenu) {
        mSubMenu = subMenu;
        
        subMenu.setHeaderTitle(getTitle());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.301 -0500", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "AD33569EACFD9ACB376C2E26B5A178EC")
    
@ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return mTitle;
    }

    /**
     * Gets the title for a particular {@link ItemView}
     * 
     * @param itemView The ItemView that is receiving the title
     * @return Either the title or condensed title based on what the ItemView
     *         prefers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.303 -0500", hash_original_method = "6C0965535A50DC1B1EFB814EBEDF6248", hash_generated_method = "6C0965535A50DC1B1EFB814EBEDF6248")
    
CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        return ((itemView != null) && itemView.prefersCondensedTitle())
                ? getTitleCondensed()
                : getTitle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.305 -0500", hash_original_method = "1E48645B8578DDF9EFFB5676592C549A", hash_generated_method = "B3C5E4C4CA24633B222C0AA21605F656")
    
public MenuItem setTitle(CharSequence title) {
        mTitle = title;

        mMenu.onItemsChanged(false);
        
        if (mSubMenu != null) {
            mSubMenu.setHeaderTitle(title);
        }
        
        return this;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.307 -0500", hash_original_method = "504EB589769814F693A853F99C8002C5", hash_generated_method = "9BDD30412EBF141D045C3D6538D7908E")
    
public MenuItem setTitle(int title) {
        return setTitle(mMenu.getContext().getString(title));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.309 -0500", hash_original_method = "2F32534D1148FE277B46E47FA445D759", hash_generated_method = "C8573BD766B461834936ABC5F1714FF2")
    
public CharSequence getTitleCondensed() {
        return mTitleCondensed != null ? mTitleCondensed : mTitle;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.312 -0500", hash_original_method = "A10897990E671CAED83F82CF9B7ADDEE", hash_generated_method = "616C3611A28651C6A686B47A93933AB4")
    
public MenuItem setTitleCondensed(CharSequence title) {
        mTitleCondensed = title;

        // Could use getTitle() in the loop below, but just cache what it would do here 
        if (title == null) {
            title = mTitle;
        }
        
        mMenu.onItemsChanged(false);
        
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.314 -0500", hash_original_method = "77C51DB63A44599458883D3753A34CC1", hash_generated_method = "4C19287DF61F38B92B725033F38CB73E")
    
public Drawable getIcon() {
        if (mIconDrawable != null) {
            return mIconDrawable;
        }

        if (mIconResId != NO_ICON) {
            return mMenu.getResources().getDrawable(mIconResId);
        }
        
        return null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.316 -0500", hash_original_method = "BD8BE6A7204F93A97A4B1462396F9006", hash_generated_method = "A0F08C1F6AA9D2103F406BCBC2F83967")
    
public MenuItem setIcon(Drawable icon) {
        mIconResId = NO_ICON;
        mIconDrawable = icon;
        mMenu.onItemsChanged(false);
        
        return this;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.318 -0500", hash_original_method = "6CA4716E877DA09BBA89FF884DD9F3E1", hash_generated_method = "024B9E77B053B556C416449FFB529A87")
    
public MenuItem setIcon(int iconResId) {
        mIconDrawable = null;
        mIconResId = iconResId;

        // If we have a view, we need to push the Drawable to them
        mMenu.onItemsChanged(false);
        
        return this;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.321 -0500", hash_original_method = "03294EC000E2E3A998710BD4D5DBC105", hash_generated_method = "6BB8DFB796F32A0DB2909EC761B5FEB5")
    
public boolean isCheckable() {
        return (mFlags & CHECKABLE) == CHECKABLE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.324 -0500", hash_original_method = "97D03B8420DC0405BDED5AEBB6194B4D", hash_generated_method = "16D37BDBBBC4140B8699764B9FC4BCA5")
    
public MenuItem setCheckable(boolean checkable) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        if (oldFlags != mFlags) {
            mMenu.onItemsChanged(false);
        }
        
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.326 -0500", hash_original_method = "D48B0A4B4830ACC112B29145FA304FB9", hash_generated_method = "D3E935207667584557FD554C5725658F")
    
public void setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.328 -0500", hash_original_method = "09CA122F8C23D0DDA91200023A557A5D", hash_generated_method = "554225F6F0A6FF90EDE7D50256C3AD37")
    
public boolean isExclusiveCheckable() {
        return (mFlags & EXCLUSIVE) != 0;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.330 -0500", hash_original_method = "153A3CA3675B13C11B20504065FC3BF7", hash_generated_method = "748FD27E624D2890342336929D3D93D9")
    
public boolean isChecked() {
        return (mFlags & CHECKED) == CHECKED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.333 -0500", hash_original_method = "9107E25FB1CB75DAB92AC94A4D8833A7", hash_generated_method = "9D33893CA7B07243796507819AE7861C")
    
public MenuItem setChecked(boolean checked) {
        if ((mFlags & EXCLUSIVE) != 0) {
            // Call the method on the Menu since it knows about the others in this
            // exclusive checkable group
            mMenu.setExclusiveItemChecked(this);
        } else {
            setCheckedInt(checked);
        }
        
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.335 -0500", hash_original_method = "F4E3FA5EA691BD61029F7B342451D96B", hash_generated_method = "F4E3FA5EA691BD61029F7B342451D96B")
    
void setCheckedInt(boolean checked) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        if (oldFlags != mFlags) {
            mMenu.onItemsChanged(false);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.337 -0500", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "1B80F4020608615FA89A7EFC550036C6")
    
public boolean isVisible() {
        return (mFlags & HIDDEN) == 0;
    }

    /**
     * Changes the visibility of the item. This method DOES NOT notify the
     * parent menu of a change in this item, so this should only be called from
     * methods that will eventually trigger this change.  If unsure, use {@link #setVisible(boolean)}
     * instead.
     * 
     * @param shown Whether to show (true) or hide (false).
     * @return Whether the item's shown state was changed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.339 -0500", hash_original_method = "6BBB65AE1F8C0F9A0552DC908B4D29C9", hash_generated_method = "6BBB65AE1F8C0F9A0552DC908B4D29C9")
    
boolean setVisibleInt(boolean shown) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        return oldFlags != mFlags;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.341 -0500", hash_original_method = "C575291A3325EE507AB9F55E92185E54", hash_generated_method = "6E848C8D6208474679BAEB6A78CEE3A1")
    
public MenuItem setVisible(boolean shown) {
        // Try to set the shown state to the given state. If the shown state was changed
        // (i.e. the previous state isn't the same as given state), notify the parent menu that
        // the shown state has changed for this item
        if (setVisibleInt(shown)) mMenu.onItemVisibleChanged(this);
        
        return this;
    }

   @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.344 -0500", hash_original_method = "1DDD55F9AC5A73432BCD73A94619FD45", hash_generated_method = "E14BB9B4DD44ECA082C114F4DB378189")
    
public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        mClickListener = clickListener;
        return this;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.347 -0500", hash_original_method = "233A3AFEB21203525FBA5B1CF441183E", hash_generated_method = "692A02ACADED5DD1B44A703CD8F1A6B2")
    
@Override
    public String toString() {
        return mTitle.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.349 -0500", hash_original_method = "B6421912A15ECCB29CB28DC744FEB4DF", hash_generated_method = "B6421912A15ECCB29CB28DC744FEB4DF")
    
void setMenuInfo(ContextMenuInfo menuInfo) {
        mMenuInfo = menuInfo;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.352 -0500", hash_original_method = "A0E326FAE2703231717DF34591A2C639", hash_generated_method = "4673B2B04DD4694F1B572CBC58F1735D")
    
public ContextMenuInfo getMenuInfo() {
        return mMenuInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.354 -0500", hash_original_method = "221F1892BBAF0D6C0448BF9B80F29C7C", hash_generated_method = "DA9815F92346138FA502DA77B7085744")
    
public void actionFormatChanged() {
        mMenu.onItemActionRequestChanged(this);
    }

    /**
     * @return Whether the menu should show icons for menu items.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.356 -0500", hash_original_method = "B7358CCF217D02273B220AA1E4900E11", hash_generated_method = "1350EC7C09EBE34E79AE23ECFE5BD0CA")
    
public boolean shouldShowIcon() {
        return mMenu.getOptionalIconsVisible();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.358 -0500", hash_original_method = "8639B741C99124BF9C4FC28DBCA735D7", hash_generated_method = "EE8FFCBB2F111D3D9AE0BE12E04A8290")
    
public boolean isActionButton() {
        return (mFlags & IS_ACTION) == IS_ACTION;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.360 -0500", hash_original_method = "D20AA9738309FEFC21F93C6653D8A4BB", hash_generated_method = "81528B979D943264481E4DD8006DCAFC")
    
public boolean requestsActionButton() {
        return (mShowAsAction & SHOW_AS_ACTION_IF_ROOM) == SHOW_AS_ACTION_IF_ROOM;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.362 -0500", hash_original_method = "A0218090F414AFC2516DB1AFD001E557", hash_generated_method = "4A494F37BA03D3E800DE418D63DEDA90")
    
public boolean requiresActionButton() {
        return (mShowAsAction & SHOW_AS_ACTION_ALWAYS) == SHOW_AS_ACTION_ALWAYS;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.364 -0500", hash_original_method = "7A64484A152776341109FA7C71AB82BB", hash_generated_method = "5825456ADEC17EC32E0F1F559D5A7900")
    
public void setIsActionButton(boolean isActionButton) {
        if (isActionButton) {
            mFlags |= IS_ACTION;
        } else {
            mFlags &= ~IS_ACTION;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.367 -0500", hash_original_method = "D19EFCF4D4C49A6F9A7B8D6E601DFE3B", hash_generated_method = "52E20321AA1B567FEE364BC07ABCA6D8")
    
public boolean showsTextAsAction() {
        return (mShowAsAction & SHOW_AS_ACTION_WITH_TEXT) == SHOW_AS_ACTION_WITH_TEXT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.369 -0500", hash_original_method = "6034AD3E3F15BF95CED1827A99F9830A", hash_generated_method = "B75CC5C30786C4E83BD58A0650648907")
    
public void setShowAsAction(int actionEnum) {
        switch (actionEnum & SHOW_AS_ACTION_MASK) {
            case SHOW_AS_ACTION_ALWAYS:
            case SHOW_AS_ACTION_IF_ROOM:
            case SHOW_AS_ACTION_NEVER:
                // Looks good!
                break;

            default:
                // Mutually exclusive options selected!
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM,"
                        + " and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        mShowAsAction = actionEnum;
        mMenu.onItemActionRequestChanged(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.372 -0500", hash_original_method = "9511E068798AA5E04A674F02DC2F7567", hash_generated_method = "382D7CCA4FE6DE9C185EA8F484E78EEE")
    
public MenuItem setActionView(View view) {
        mActionView = view;
        mActionProvider = null;
        if (view != null && view.getId() == View.NO_ID && mId > 0) {
            view.setId(mId);
        }
        mMenu.onItemActionRequestChanged(this);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.374 -0500", hash_original_method = "B057E2C488C14BC05DF25DD2F229F8B2", hash_generated_method = "B0ACBAF1ED33FC02011C5D4E6F02A8ED")
    
public MenuItem setActionView(int resId) {
        final Context context = mMenu.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.376 -0500", hash_original_method = "404D78F2C7005B21FAAA5C37E608175C", hash_generated_method = "E4B0C17417A0453A8883AE73F01D00D7")
    
public View getActionView() {
        if (mActionView != null) {
            return mActionView;
        } else if (mActionProvider != null) {
            mActionView = mActionProvider.onCreateActionView();
            return mActionView;
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.378 -0500", hash_original_method = "F6993BB94930E20BEF3D6DE6883E2D9B", hash_generated_method = "D1A91587D547510C5AAC64F83226C01D")
    
public ActionProvider getActionProvider() {
        return mActionProvider;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.380 -0500", hash_original_method = "C59B6F24EC844FBD609E594809339FFA", hash_generated_method = "0135C1CCCBDD38C575EC5B4FCC8F4CE0")
    
public MenuItem setActionProvider(ActionProvider actionProvider) {
        mActionView = null;
        mActionProvider = actionProvider;
        mMenu.onItemsChanged(true); // Measurement can be changed
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.383 -0500", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "E3AEDEFC029A2CDBBEAF6794D67209CE")
    
@Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.385 -0500", hash_original_method = "9242B1434B9CD0ACB88D22E492AB3A81", hash_generated_method = "785DF27EB9DB09B43BE88FA740E40BF8")
    
@Override
    public boolean expandActionView() {
        if ((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) == 0 || mActionView == null) {
            return false;
        }

        if (mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionExpand(this)) {
            return mMenu.expandItemActionView(this);
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.388 -0500", hash_original_method = "DB0EB37C3626C85F2C23377923AB6063", hash_generated_method = "D3E84239EA5F45561CF06CF4B2CC2EAA")
    
@Override
    public boolean collapseActionView() {
        if ((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) == 0) {
            return false;
        }
        if (mActionView == null) {
            // We're already collapsed if we have no action view.
            return true;
        }

        if (mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionCollapse(this)) {
            return mMenu.collapseItemActionView(this);
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.391 -0500", hash_original_method = "B1FCAF7D5B88EED4E84E6E84EBEC9EE4", hash_generated_method = "4DE1588451EEB40B14B63F3C72F480C0")
    
@Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        mOnActionExpandListener = listener;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.393 -0500", hash_original_method = "DAFC43ECD0E5D06566AA28ACE3B5E472", hash_generated_method = "DDDD51374CDE73A14FCDB2326D0AC600")
    
public boolean hasCollapsibleActionView() {
        return (mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) != 0 && mActionView != null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.395 -0500", hash_original_method = "A7B0C8C0A6B0446C22F6521CC0C60064", hash_generated_method = "24E928E7E2E1A6934EF8BCFFCA950B7D")
    
public void setActionViewExpanded(boolean isExpanded) {
        mIsActionViewExpanded = isExpanded;
        mMenu.onItemsChanged(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:33.397 -0500", hash_original_method = "618A94DE2810D1D688B3A7F878D1125A", hash_generated_method = "01EB0B4B0BFD97987FCC46F145106B1B")
    
public boolean isActionViewExpanded() {
        return mIsActionViewExpanded;
    }
}

