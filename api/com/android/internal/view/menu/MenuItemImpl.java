package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.view.menu.MenuView.ItemView;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;

public final class MenuItemImpl implements MenuItem {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.403 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private int mGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "B75BDC891F05DF8D9F77776476EBCDD6", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private int mCategoryOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "CCC67011C0B9AB1BA64ACA217793FF17", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private int mOrdering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "793CD2D3A29DBCA3B6EE3D2D5CF29A55", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "5CA918862E899FBE57CD8F3D0DB44604", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "FAC611210B68F831D4A3B699FB58A971", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "EF18AFCEFBAD21F6B816E931AD814543", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "37AC3635461CA62872231C85492F3A9C", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "E163EBF815349370E2BC91E219960B88", hash_generated_field = "CCE2E7E9B41EB859D026207A515694B8")

    private SubMenuBuilder mSubMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "2B7E0A3FBDE4E506B96DAB7C97214944", hash_generated_field = "E128AFA2E0B8F17E3CC9B8F36180ADD8")

    private Runnable mItemCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "C7443C6F6983E9AE465DCA4986300561", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")

    private MenuItem.OnMenuItemClickListener mClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "25DDE236B20D5D6403355424CC7CFB83", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "EE351B57987290D5C97C12334A4F5C8A", hash_generated_field = "7FED0AA513FCAFE5BBB64F7D855AC56C")

    private int mShowAsAction = SHOW_AS_ACTION_NEVER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.404 -0400", hash_original_field = "42ED82821F0D805CE8C635AE635639B9", hash_generated_field = "67E37FA198462CB2D5A9B9320B838135")

    private View mActionView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.405 -0400", hash_original_field = "6F151B4E913A23BC3B3F9FF725385336", hash_generated_field = "43987C5D315D6540F5B86319E4F6655F")

    private ActionProvider mActionProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.405 -0400", hash_original_field = "20990041D5CB5868F5C6A4F0A5C55C0F", hash_generated_field = "784094F6CF284A96EDEED4548B8FB05D")

    private OnActionExpandListener mOnActionExpandListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.405 -0400", hash_original_field = "07492CDCBB9799261CC2942AB3F6D415", hash_generated_field = "06A110AC8494F5C7468903392B66FD97")

    private boolean mIsActionViewExpanded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.405 -0400", hash_original_field = "17699AE07D9C5F03811167BB1003FF3E", hash_generated_field = "B7A128C3CB7F07DDB09B9D1855650533")

    private ContextMenuInfo mMenuInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.407 -0400", hash_original_method = "64F6A72F78EB0039947A0530C3919D96", hash_generated_method = "81F31BB5B03E1E465D2BB0C07E80756D")
      MenuItemImpl(MenuBuilder menu, int group, int id, int categoryOrder, int ordering,
            CharSequence title, int showAsAction) {
    if(sPrependShortcutLabel == null)        
        {
            sPrependShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.prepend_shortcut_label);
            sEnterShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_enter_shortcut_label);
            sDeleteShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_delete_shortcut_label);
            sSpaceShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_space_shortcut_label);
        } //End block
        mMenu = menu;
        mId = id;
        mGroup = group;
        mCategoryOrder = categoryOrder;
        mOrdering = ordering;
        mTitle = title;
        mShowAsAction = showAsAction;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.408 -0400", hash_original_method = "DCB176B376623FC7561DCD073EB66D0A", hash_generated_method = "45148CFA1ECF997A43D0E7C417FE8ECA")
    public boolean invoke() {
    if(mClickListener != null &&
            mClickListener.onMenuItemClick(this))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1034063881 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912018820 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912018820;
        } //End block
    if(mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_911714917 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2067151990 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2067151990;
        } //End block
    if(mItemCallback != null)        
        {
            mItemCallback.run();
            boolean varB326B5062B2F0E69046810717534CB09_1714071470 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341698718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341698718;
        } //End block
    if(mIntent != null)        
        {
            try 
            {
                mMenu.getContext().startActivity(mIntent);
                boolean varB326B5062B2F0E69046810717534CB09_1218955382 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631770717 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631770717;
            } //End block
            catch (ActivityNotFoundException e)
            {
            } //End block
        } //End block
    if(mActionProvider != null && mActionProvider.onPerformDefaultAction())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1531130386 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1767418665 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1767418665;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1481104875 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92612204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92612204;
        // ---------- Original Method ----------
        //if (mClickListener != null &&
            //mClickListener.onMenuItemClick(this)) {
            //return true;
        //}
        //if (mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this)) {
            //return true;
        //}
        //if (mItemCallback != null) {
            //mItemCallback.run();
            //return true;
        //}
        //if (mIntent != null) {
            //try {
                //mMenu.getContext().startActivity(mIntent);
                //return true;
            //} catch (ActivityNotFoundException e) {
                //Log.e(TAG, "Can't find activity to handle intent; ignoring", e);
            //}
        //}
        //if (mActionProvider != null && mActionProvider.onPerformDefaultAction()) {
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.408 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "1AF55D28EF69BD4FB25D05931DCA30A5")
    public boolean isEnabled() {
        boolean varB87D9597EA81BF64B4340D9A8EF353D6_621205227 = ((mFlags & ENABLED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2055008995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2055008995;
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.409 -0400", hash_original_method = "D7CDC1A4A52E7AA2B30AF0AEE42BB489", hash_generated_method = "E55D49E9B24DA4C6C184432A0AC9DA8B")
    public MenuItem setEnabled(boolean enabled) {
        addTaint(enabled);
    if(enabled)        
        {
            mFlags |= ENABLED;
        } //End block
        else
        {
            mFlags &= ~ENABLED;
        } //End block
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_347659813 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_347659813.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_347659813;
        // ---------- Original Method ----------
        //if (enabled) {
            //mFlags |= ENABLED;
        //} else {
            //mFlags &= ~ENABLED;
        //}
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.409 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "32BC825542837D28FDA844B39CFA0006")
    public int getGroupId() {
        int var21346FE9F16EBAFFE8F776F66247523D_2031065862 = (mGroup);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233544836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233544836;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.409 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "B7116BF25CB7BBFA9E5F7E537E6EA223")
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_818939132 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034633241 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034633241;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.410 -0400", hash_original_method = "C3905BED22935FA2186A402E1BBD1829", hash_generated_method = "D6F60F8C4BF1E869EFCC7781B80FD7A3")
    public int getOrder() {
        int varB75BDC891F05DF8D9F77776476EBCDD6_37379854 = (mCategoryOrder);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1986572670 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1986572670;
        // ---------- Original Method ----------
        //return mCategoryOrder;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.410 -0400", hash_original_method = "92E8F82AA50FD1AD58335B2DC7895A83", hash_generated_method = "737E4EE591368ED703CE05CB955F746F")
    public int getOrdering() {
        int varCCC67011C0B9AB1BA64ACA217793FF17_41051582 = (mOrdering);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747631668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747631668;
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.410 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "97FB5E29C8CF9D1C0B0CC64EB91532E5")
    public Intent getIntent() {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_39407309 =         mIntent;
        var4DCF8E3D75AE0B94CDA94656DCE16BCE_39407309.addTaint(taint);
        return var4DCF8E3D75AE0B94CDA94656DCE16BCE_39407309;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.410 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "10A3E5F5CDE26F379A1309D4DC492D1E")
    public MenuItem setIntent(Intent intent) {
        mIntent = intent;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1502693472 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1502693472.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1502693472;
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.411 -0400", hash_original_method = "C32C9CAC3047604A3F615D0E2B0A3D92", hash_generated_method = "B26F1A2FC26AD380B90A2AEF133D6CEA")
     Runnable getCallback() {
Runnable var994B3DDE084BD7BF79ED19A07059E09C_2106663295 =         mItemCallback;
        var994B3DDE084BD7BF79ED19A07059E09C_2106663295.addTaint(taint);
        return var994B3DDE084BD7BF79ED19A07059E09C_2106663295;
        // ---------- Original Method ----------
        //return mItemCallback;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.411 -0400", hash_original_method = "CAD9375B57D68888676D597787CB9AA1", hash_generated_method = "07538F6B1B24970575029FC1E267A67E")
    public MenuItem setCallback(Runnable callback) {
        mItemCallback = callback;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_936100750 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_936100750.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_936100750;
        // ---------- Original Method ----------
        //mItemCallback = callback;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.411 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "5292335907043F37CEAD6A84BD923B4D")
    public char getAlphabeticShortcut() {
        char varFAC611210B68F831D4A3B699FB58A971_1536536419 = (mShortcutAlphabeticChar);
                char varA87DEB01C5F539E6BDA34829C8EF2368_287148834 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_287148834;
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.421 -0400", hash_original_method = "88D9907A20D6B14742A0B31CE890DEE4", hash_generated_method = "548D8449E6AE35240B84E27DB60EC30D")
    public MenuItem setAlphabeticShortcut(char alphaChar) {
    if(mShortcutAlphabeticChar == alphaChar)        
        {
MenuItem var72A74007B2BE62B849F475C7BDA4658B_693117162 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_693117162.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_693117162;
        }
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1697307402 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1697307402.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1697307402;
        // ---------- Original Method ----------
        //if (mShortcutAlphabeticChar == alphaChar) return this;
        //mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.421 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "381CB0BED8DD681E5F917CC97D409020")
    public char getNumericShortcut() {
        char var5CA918862E899FBE57CD8F3D0DB44604_1285700735 = (mShortcutNumericChar);
                char varA87DEB01C5F539E6BDA34829C8EF2368_916496589 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_916496589;
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.422 -0400", hash_original_method = "C979D44A5E5C9CB1A686CC5CF090F436", hash_generated_method = "4E2363470C2BEA3663F1D058607F30E9")
    public MenuItem setNumericShortcut(char numericChar) {
    if(mShortcutNumericChar == numericChar)        
        {
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1410882203 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1410882203.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1410882203;
        }
        mShortcutNumericChar = numericChar;
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_783121824 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_783121824.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_783121824;
        // ---------- Original Method ----------
        //if (mShortcutNumericChar == numericChar) return this;
        //mShortcutNumericChar = numericChar;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.422 -0400", hash_original_method = "0C4A5B3F8F292031B8A33F43134542C3", hash_generated_method = "762328EC5918F9B6B46DAFB32F519744")
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_2088609620 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2088609620.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2088609620;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.422 -0400", hash_original_method = "D96803BF052A5945B7D152CA36FE6B7E", hash_generated_method = "9616BAD92C272F9968BAEE5C5886CE6D")
     char getShortcut() {
        char var15D8842BF948C8124ABD1C2CAA208C37_964977141 = ((mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1741676038 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1741676038;
        // ---------- Original Method ----------
        //return (mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.422 -0400", hash_original_method = "BC454AC179D3698A29B0357FA131C3B2", hash_generated_method = "82C6E6B2427D01107E617327AD0226EB")
     String getShortcutLabel() {
        char shortcut = getShortcut();
    if(shortcut == 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_226488407 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_226488407.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_226488407;
        } //End block
        StringBuilder sb = new StringBuilder(sPrependShortcutLabel);
switch(shortcut){
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
}String var2460B846747F8B22185AD8BE722266A5_21443523 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_21443523.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_21443523;
        // ---------- Original Method ----------
        //char shortcut = getShortcut();
        //if (shortcut == 0) {
            //return "";
        //}
        //StringBuilder sb = new StringBuilder(sPrependShortcutLabel);
        //switch (shortcut) {
            //case '\n':
                //sb.append(sEnterShortcutLabel);
                //break;
            //case '\b':
                //sb.append(sDeleteShortcutLabel);
                //break;
            //case ' ':
                //sb.append(sSpaceShortcutLabel);
                //break;
            //default:
                //sb.append(shortcut);
                //break;
        //}
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.422 -0400", hash_original_method = "10F1B2AEF5DA21C52B4C4E0F70D42C6B", hash_generated_method = "A564C3A43DC3CFD6CCD7F1AAFB924A18")
     boolean shouldShowShortcut() {
        boolean var85E954290E01E66D0EA0EB08C143A431_12322872 = (mMenu.isShortcutsVisible() && (getShortcut() != 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_168085752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_168085752;
        // ---------- Original Method ----------
        //return mMenu.isShortcutsVisible() && (getShortcut() != 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.422 -0400", hash_original_method = "4569B511D747F82913D0DE9D1EF62E55", hash_generated_method = "D382CEC9EED74537AF65EA568E2AA36C")
    public SubMenu getSubMenu() {
SubMenu varC083E519FF4D11870DD99D803CC3087D_586038809 =         mSubMenu;
        varC083E519FF4D11870DD99D803CC3087D_586038809.addTaint(taint);
        return varC083E519FF4D11870DD99D803CC3087D_586038809;
        // ---------- Original Method ----------
        //return mSubMenu;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.422 -0400", hash_original_method = "4556386DBA75360C55B0D4465EB5905E", hash_generated_method = "889DA499875CD9DDBAABC16311E5FDC7")
    public boolean hasSubMenu() {
        boolean var59EAA12D7074A8427FEE88E96B6727FC_1475645633 = (mSubMenu != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033501943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033501943;
        // ---------- Original Method ----------
        //return mSubMenu != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.423 -0400", hash_original_method = "84077AC2D714BDDE1A3A80B85CC9BFB0", hash_generated_method = "9BE0E7ADF2FF7A8D98A414C8B1B91CC8")
     void setSubMenu(SubMenuBuilder subMenu) {
        mSubMenu = subMenu;
        subMenu.setHeaderTitle(getTitle());
        // ---------- Original Method ----------
        //mSubMenu = subMenu;
        //subMenu.setHeaderTitle(getTitle());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.423 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "7BF42B885700DF0806050B8C008FF3E9")
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
CharSequence var4FE0D95ADE4B4BDFA36D55D8B62A6C49_1963901778 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_1963901778.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_1963901778;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.423 -0400", hash_original_method = "6C0965535A50DC1B1EFB814EBEDF6248", hash_generated_method = "AD46061AFF968DD416F37472C5589085")
     CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        addTaint(itemView.getTaint());
CharSequence varC8148C3D47075D36ED08877976FCC1CB_822220777 =         ((itemView != null) && itemView.prefersCondensedTitle())
                ? getTitleCondensed()
                : getTitle();
        varC8148C3D47075D36ED08877976FCC1CB_822220777.addTaint(taint);
        return varC8148C3D47075D36ED08877976FCC1CB_822220777;
        // ---------- Original Method ----------
        //return ((itemView != null) && itemView.prefersCondensedTitle())
                //? getTitleCondensed()
                //: getTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.424 -0400", hash_original_method = "1E48645B8578DDF9EFFB5676592C549A", hash_generated_method = "24E81D5D815DAEED8E7C8E0EAF42A306")
    public MenuItem setTitle(CharSequence title) {
        mTitle = title;
        mMenu.onItemsChanged(false);
    if(mSubMenu != null)        
        {
            mSubMenu.setHeaderTitle(title);
        } //End block
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1873506433 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1873506433.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1873506433;
        // ---------- Original Method ----------
        //mTitle = title;
        //mMenu.onItemsChanged(false);
        //if (mSubMenu != null) {
            //mSubMenu.setHeaderTitle(title);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.424 -0400", hash_original_method = "504EB589769814F693A853F99C8002C5", hash_generated_method = "C8FA617FF6A093C01D39955FA34F3AC1")
    public MenuItem setTitle(int title) {
        addTaint(title);
MenuItem var0E1869CCC2CA3BCD99ECDF58FF98A0E5_46085299 =         setTitle(mMenu.getContext().getString(title));
        var0E1869CCC2CA3BCD99ECDF58FF98A0E5_46085299.addTaint(taint);
        return var0E1869CCC2CA3BCD99ECDF58FF98A0E5_46085299;
        // ---------- Original Method ----------
        //return setTitle(mMenu.getContext().getString(title));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.424 -0400", hash_original_method = "2F32534D1148FE277B46E47FA445D759", hash_generated_method = "E470DB30B0F1FC2964D866A4F110C471")
    public CharSequence getTitleCondensed() {
CharSequence varCF2C43BCC97AC29D7C72C9E3E2C7AC7A_432699406 =         mTitleCondensed != null ? mTitleCondensed : mTitle;
        varCF2C43BCC97AC29D7C72C9E3E2C7AC7A_432699406.addTaint(taint);
        return varCF2C43BCC97AC29D7C72C9E3E2C7AC7A_432699406;
        // ---------- Original Method ----------
        //return mTitleCondensed != null ? mTitleCondensed : mTitle;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.424 -0400", hash_original_method = "A10897990E671CAED83F82CF9B7ADDEE", hash_generated_method = "CB92261FF4BD128F28A98D5D886AC76F")
    public MenuItem setTitleCondensed(CharSequence title) {
        mTitleCondensed = title;
    if(title == null)        
        {
            title = mTitle;
        } //End block
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_193843791 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_193843791.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_193843791;
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //if (title == null) {
            //title = mTitle;
        //}
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.424 -0400", hash_original_method = "77C51DB63A44599458883D3753A34CC1", hash_generated_method = "546961A6E42D18F7B6532B6AF8FDD378")
    public Drawable getIcon() {
    if(mIconDrawable != null)        
        {
Drawable var5B92DD146545638DBC028505FF353915_2125340045 =             mIconDrawable;
            var5B92DD146545638DBC028505FF353915_2125340045.addTaint(taint);
            return var5B92DD146545638DBC028505FF353915_2125340045;
        } //End block
    if(mIconResId != NO_ICON)        
        {
Drawable var21CC05CB12DD717B030220BB31472275_1807182089 =             mMenu.getResources().getDrawable(mIconResId);
            var21CC05CB12DD717B030220BB31472275_1807182089.addTaint(taint);
            return var21CC05CB12DD717B030220BB31472275_1807182089;
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_1938446005 =         null;
        var540C13E9E156B687226421B24F2DF178_1938446005.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1938446005;
        // ---------- Original Method ----------
        //if (mIconDrawable != null) {
            //return mIconDrawable;
        //}
        //if (mIconResId != NO_ICON) {
            //return mMenu.getResources().getDrawable(mIconResId);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.424 -0400", hash_original_method = "BD8BE6A7204F93A97A4B1462396F9006", hash_generated_method = "392ACB56FAF2B6EEA1D6B81FADAEC85B")
    public MenuItem setIcon(Drawable icon) {
        mIconResId = NO_ICON;
        mIconDrawable = icon;
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_2099891404 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2099891404.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2099891404;
        // ---------- Original Method ----------
        //mIconResId = NO_ICON;
        //mIconDrawable = icon;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.424 -0400", hash_original_method = "6CA4716E877DA09BBA89FF884DD9F3E1", hash_generated_method = "A1DAF8935BC78C89420F5F49FDE79988")
    public MenuItem setIcon(int iconResId) {
        mIconDrawable = null;
        mIconResId = iconResId;
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1080349298 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1080349298.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1080349298;
        // ---------- Original Method ----------
        //mIconDrawable = null;
        //mIconResId = iconResId;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.425 -0400", hash_original_method = "03294EC000E2E3A998710BD4D5DBC105", hash_generated_method = "34C02BC8845AC1E8972F7FB316D534EA")
    public boolean isCheckable() {
        boolean var6BB28F79584CC39AD277C56B84E68B02_342851467 = ((mFlags & CHECKABLE) == CHECKABLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439698519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439698519;
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) == CHECKABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.425 -0400", hash_original_method = "97D03B8420DC0405BDED5AEBB6194B4D", hash_generated_method = "2853502A5C1F0DF299A008D315150612")
    public MenuItem setCheckable(boolean checkable) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
    if(oldFlags != mFlags)        
        {
            mMenu.onItemsChanged(false);
        } //End block
MenuItem var72A74007B2BE62B849F475C7BDA4658B_704535667 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_704535667.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_704535667;
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //if (oldFlags != mFlags) {
            //mMenu.onItemsChanged(false);
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.425 -0400", hash_original_method = "D48B0A4B4830ACC112B29145FA304FB9", hash_generated_method = "72956FA378A284989864C014D06C7B79")
    public void setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.425 -0400", hash_original_method = "09CA122F8C23D0DDA91200023A557A5D", hash_generated_method = "E63B2026DC50D61F248B99E411978843")
    public boolean isExclusiveCheckable() {
        boolean var8096B85672A60979E0F73628CCE17272_1979876939 = ((mFlags & EXCLUSIVE) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619247983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619247983;
        // ---------- Original Method ----------
        //return (mFlags & EXCLUSIVE) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.425 -0400", hash_original_method = "153A3CA3675B13C11B20504065FC3BF7", hash_generated_method = "DE08A0D9142CF99A6ADBE1E63B5DEC40")
    public boolean isChecked() {
        boolean varCC46849F211A0B2A01D25E271291DD49_615892695 = ((mFlags & CHECKED) == CHECKED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1254503429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1254503429;
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) == CHECKED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.425 -0400", hash_original_method = "9107E25FB1CB75DAB92AC94A4D8833A7", hash_generated_method = "C3F011ED1913FF72B27C3A8D40F1DA04")
    public MenuItem setChecked(boolean checked) {
        addTaint(checked);
    if((mFlags & EXCLUSIVE) != 0)        
        {
            mMenu.setExclusiveItemChecked(this);
        } //End block
        else
        {
            setCheckedInt(checked);
        } //End block
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1226278648 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1226278648.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1226278648;
        // ---------- Original Method ----------
        //if ((mFlags & EXCLUSIVE) != 0) {
            //mMenu.setExclusiveItemChecked(this);
        //} else {
            //setCheckedInt(checked);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.425 -0400", hash_original_method = "F4E3FA5EA691BD61029F7B342451D96B", hash_generated_method = "9542732515D02F97052891CEB6960F5D")
     void setCheckedInt(boolean checked) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
    if(oldFlags != mFlags)        
        {
            mMenu.onItemsChanged(false);
        } //End block
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        //if (oldFlags != mFlags) {
            //mMenu.onItemsChanged(false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.426 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "EB4F6D490B175DEA218A173D4B20C0AA")
    public boolean isVisible() {
        boolean varE913D4BE32099E3F386AB8D84C78AB5D_10209880 = ((mFlags & HIDDEN) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831899497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831899497;
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.426 -0400", hash_original_method = "6BBB65AE1F8C0F9A0552DC908B4D29C9", hash_generated_method = "9670646BD4C59D52731EBCEC57A0F28E")
     boolean setVisibleInt(boolean shown) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        boolean var4B5C72ED6FA81B932732EC41C6FE39DB_511625533 = (oldFlags != mFlags);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739706301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_739706301;
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        //return oldFlags != mFlags;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.426 -0400", hash_original_method = "C575291A3325EE507AB9F55E92185E54", hash_generated_method = "9396A32B3509CBD5486BD81378C13B05")
    public MenuItem setVisible(boolean shown) {
        addTaint(shown);
    if(setVisibleInt(shown))        
        mMenu.onItemVisibleChanged(this);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1485160634 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1485160634.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1485160634;
        // ---------- Original Method ----------
        //if (setVisibleInt(shown)) mMenu.onItemVisibleChanged(this);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.426 -0400", hash_original_method = "1DDD55F9AC5A73432BCD73A94619FD45", hash_generated_method = "DF7E39ECFABEF6D74283776FEEC4C7CD")
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        mClickListener = clickListener;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_693104110 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_693104110.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_693104110;
        // ---------- Original Method ----------
        //mClickListener = clickListener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.426 -0400", hash_original_method = "233A3AFEB21203525FBA5B1CF441183E", hash_generated_method = "2FB8C2BB65EA534B9C54E40F80C40CEF")
    @Override
    public String toString() {
String varD16376414E90AD88020E4E5437397840_1534258515 =         mTitle.toString();
        varD16376414E90AD88020E4E5437397840_1534258515.addTaint(taint);
        return varD16376414E90AD88020E4E5437397840_1534258515;
        // ---------- Original Method ----------
        //return mTitle.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.426 -0400", hash_original_method = "B6421912A15ECCB29CB28DC744FEB4DF", hash_generated_method = "48D720FE3E7BA870AFBD08C536357B9E")
     void setMenuInfo(ContextMenuInfo menuInfo) {
        mMenuInfo = menuInfo;
        // ---------- Original Method ----------
        //mMenuInfo = menuInfo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.426 -0400", hash_original_method = "A0E326FAE2703231717DF34591A2C639", hash_generated_method = "5871FD35E8655E7F616AC3C97F67FCBC")
    public ContextMenuInfo getMenuInfo() {
ContextMenuInfo var05CE4E445EB5B7476BF0CDD0DC01EBEC_704290076 =         mMenuInfo;
        var05CE4E445EB5B7476BF0CDD0DC01EBEC_704290076.addTaint(taint);
        return var05CE4E445EB5B7476BF0CDD0DC01EBEC_704290076;
        // ---------- Original Method ----------
        //return mMenuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.426 -0400", hash_original_method = "221F1892BBAF0D6C0448BF9B80F29C7C", hash_generated_method = "AA105CD9041C087568465B6F262D8004")
    public void actionFormatChanged() {
        mMenu.onItemActionRequestChanged(this);
        // ---------- Original Method ----------
        //mMenu.onItemActionRequestChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.426 -0400", hash_original_method = "B7358CCF217D02273B220AA1E4900E11", hash_generated_method = "55567B59AF44D8721FF84B5ED32BB831")
    public boolean shouldShowIcon() {
        boolean var5E1F8CD1F4DACFEE1DFD21FC398A511F_476518822 = (mMenu.getOptionalIconsVisible());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_728929471 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_728929471;
        // ---------- Original Method ----------
        //return mMenu.getOptionalIconsVisible();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.426 -0400", hash_original_method = "8639B741C99124BF9C4FC28DBCA735D7", hash_generated_method = "ABEB51E6EABD7EA419500914AF9606DB")
    public boolean isActionButton() {
        boolean varDA2D3C3EC0D999656803688D27357310_1719076568 = ((mFlags & IS_ACTION) == IS_ACTION);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651718586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651718586;
        // ---------- Original Method ----------
        //return (mFlags & IS_ACTION) == IS_ACTION;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.427 -0400", hash_original_method = "D20AA9738309FEFC21F93C6653D8A4BB", hash_generated_method = "1120C94F950F14A48882D75E4A0074D3")
    public boolean requestsActionButton() {
        boolean var2CC5D29C4D044C456BC205735E1650B7_1639739545 = ((mShowAsAction & SHOW_AS_ACTION_IF_ROOM) == SHOW_AS_ACTION_IF_ROOM);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1539136031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1539136031;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_IF_ROOM) == SHOW_AS_ACTION_IF_ROOM;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.427 -0400", hash_original_method = "A0218090F414AFC2516DB1AFD001E557", hash_generated_method = "26BBB7A66DE2173470DC58EA085149B7")
    public boolean requiresActionButton() {
        boolean varAB926195308BD6E1AF5A6EF6FE78277F_1855109615 = ((mShowAsAction & SHOW_AS_ACTION_ALWAYS) == SHOW_AS_ACTION_ALWAYS);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637579426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637579426;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_ALWAYS) == SHOW_AS_ACTION_ALWAYS;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.427 -0400", hash_original_method = "7A64484A152776341109FA7C71AB82BB", hash_generated_method = "22EA4C09EF7A8C0A08DD3D77EDCD284E")
    public void setIsActionButton(boolean isActionButton) {
        addTaint(isActionButton);
    if(isActionButton)        
        {
            mFlags |= IS_ACTION;
        } //End block
        else
        {
            mFlags &= ~IS_ACTION;
        } //End block
        // ---------- Original Method ----------
        //if (isActionButton) {
            //mFlags |= IS_ACTION;
        //} else {
            //mFlags &= ~IS_ACTION;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.427 -0400", hash_original_method = "D19EFCF4D4C49A6F9A7B8D6E601DFE3B", hash_generated_method = "0C5842B8CDF999859B96CB0C7FE5D701")
    public boolean showsTextAsAction() {
        boolean var43B66AAB0F5FC6D3BFBA8260B2E22E71_327130652 = ((mShowAsAction & SHOW_AS_ACTION_WITH_TEXT) == SHOW_AS_ACTION_WITH_TEXT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474002438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474002438;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_WITH_TEXT) == SHOW_AS_ACTION_WITH_TEXT;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.427 -0400", hash_original_method = "6034AD3E3F15BF95CED1827A99F9830A", hash_generated_method = "1ADDD3A6B46CD94C66600F4BCC08B651")
    public void setShowAsAction(int actionEnum) {
switch(actionEnum & SHOW_AS_ACTION_MASK){
        case SHOW_AS_ACTION_ALWAYS:
        case SHOW_AS_ACTION_IF_ROOM:
        case SHOW_AS_ACTION_NEVER:
        break;
        default:
        IllegalArgumentException var7789CF77216A8CAA5E5E20DB36F22F7A_135596813 = new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM,"
                        + " and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        var7789CF77216A8CAA5E5E20DB36F22F7A_135596813.addTaint(taint);
        throw var7789CF77216A8CAA5E5E20DB36F22F7A_135596813;
}        mShowAsAction = actionEnum;
        mMenu.onItemActionRequestChanged(this);
        // ---------- Original Method ----------
        //switch (actionEnum & SHOW_AS_ACTION_MASK) {
            //case SHOW_AS_ACTION_ALWAYS:
            //case SHOW_AS_ACTION_IF_ROOM:
            //case SHOW_AS_ACTION_NEVER:
                //break;
            //default:
                //throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM,"
                        //+ " and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        //}
        //mShowAsAction = actionEnum;
        //mMenu.onItemActionRequestChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.427 -0400", hash_original_method = "9511E068798AA5E04A674F02DC2F7567", hash_generated_method = "4771506F522F86CB70F11646C2BFB13C")
    public MenuItem setActionView(View view) {
        mActionView = view;
        mActionProvider = null;
    if(view != null && view.getId() == View.NO_ID && mId > 0)        
        {
            view.setId(mId);
        } //End block
        mMenu.onItemActionRequestChanged(this);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_983107018 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_983107018.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_983107018;
        // ---------- Original Method ----------
        //mActionView = view;
        //mActionProvider = null;
        //if (view != null && view.getId() == View.NO_ID && mId > 0) {
            //view.setId(mId);
        //}
        //mMenu.onItemActionRequestChanged(this);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.427 -0400", hash_original_method = "B057E2C488C14BC05DF25DD2F229F8B2", hash_generated_method = "071C4FC5858ABB9A99F722410D46F4B8")
    public MenuItem setActionView(int resId) {
        addTaint(resId);
        final Context context = mMenu.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        setActionView(inflater.inflate(resId, new LinearLayout(context), false));
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1127014575 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1127014575.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1127014575;
        // ---------- Original Method ----------
        //final Context context = mMenu.getContext();
        //final LayoutInflater inflater = LayoutInflater.from(context);
        //setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.428 -0400", hash_original_method = "404D78F2C7005B21FAAA5C37E608175C", hash_generated_method = "E94D705EF27AFEC9733F0C5D831B1F4E")
    public View getActionView() {
    if(mActionView != null)        
        {
View var1CB7DEAB86EEBCB021D745E4C8E8D1D7_1972121844 =             mActionView;
            var1CB7DEAB86EEBCB021D745E4C8E8D1D7_1972121844.addTaint(taint);
            return var1CB7DEAB86EEBCB021D745E4C8E8D1D7_1972121844;
        } //End block
        else
    if(mActionProvider != null)        
        {
            mActionView = mActionProvider.onCreateActionView();
View var1CB7DEAB86EEBCB021D745E4C8E8D1D7_1794229074 =             mActionView;
            var1CB7DEAB86EEBCB021D745E4C8E8D1D7_1794229074.addTaint(taint);
            return var1CB7DEAB86EEBCB021D745E4C8E8D1D7_1794229074;
        } //End block
        else
        {
View var540C13E9E156B687226421B24F2DF178_1494445568 =             null;
            var540C13E9E156B687226421B24F2DF178_1494445568.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1494445568;
        } //End block
        // ---------- Original Method ----------
        //if (mActionView != null) {
            //return mActionView;
        //} else if (mActionProvider != null) {
            //mActionView = mActionProvider.onCreateActionView();
            //return mActionView;
        //} else {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.428 -0400", hash_original_method = "F6993BB94930E20BEF3D6DE6883E2D9B", hash_generated_method = "750B0095AB5CE7C84E60451E54014D46")
    public ActionProvider getActionProvider() {
ActionProvider var57BFCB16350F74344F74241EF039E23B_1429520026 =         mActionProvider;
        var57BFCB16350F74344F74241EF039E23B_1429520026.addTaint(taint);
        return var57BFCB16350F74344F74241EF039E23B_1429520026;
        // ---------- Original Method ----------
        //return mActionProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.428 -0400", hash_original_method = "C59B6F24EC844FBD609E594809339FFA", hash_generated_method = "F3F08640B517F4205C27F20E896355A3")
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        mActionView = null;
        mActionProvider = actionProvider;
        mMenu.onItemsChanged(true);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_225948242 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_225948242.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_225948242;
        // ---------- Original Method ----------
        //mActionView = null;
        //mActionProvider = actionProvider;
        //mMenu.onItemsChanged(true);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.428 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "9414B33892BF2E679FCF8D50B4690B5A")
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        addTaint(actionEnum);
        setShowAsAction(actionEnum);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_539111969 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_539111969.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_539111969;
        // ---------- Original Method ----------
        //setShowAsAction(actionEnum);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.428 -0400", hash_original_method = "9242B1434B9CD0ACB88D22E492AB3A81", hash_generated_method = "B1F165CA4FD8A7EBB8DF8929C3C2A199")
    @Override
    public boolean expandActionView() {
    if((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) == 0 || mActionView == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_975749507 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1332780283 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1332780283;
        } //End block
    if(mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionExpand(this))        
        {
            boolean var5CF2883D825F0938343481AA38A93254_534709993 = (mMenu.expandItemActionView(this));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50059925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_50059925;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1780716808 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064289953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064289953;
        // ---------- Original Method ----------
        //if ((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) == 0 || mActionView == null) {
            //return false;
        //}
        //if (mOnActionExpandListener == null ||
                //mOnActionExpandListener.onMenuItemActionExpand(this)) {
            //return mMenu.expandItemActionView(this);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.429 -0400", hash_original_method = "DB0EB37C3626C85F2C23377923AB6063", hash_generated_method = "818B9D5613BC049D735AA107B5822557")
    @Override
    public boolean collapseActionView() {
    if((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1919839667 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_556459898 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_556459898;
        } //End block
    if(mActionView == null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_688793197 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916862599 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_916862599;
        } //End block
    if(mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionCollapse(this))        
        {
            boolean var523891D3A624E518BB9246710B1EC309_190222079 = (mMenu.collapseItemActionView(this));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368502868 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_368502868;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_672038934 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857897819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_857897819;
        // ---------- Original Method ----------
        //if ((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) == 0) {
            //return false;
        //}
        //if (mActionView == null) {
            //return true;
        //}
        //if (mOnActionExpandListener == null ||
                //mOnActionExpandListener.onMenuItemActionCollapse(this)) {
            //return mMenu.collapseItemActionView(this);
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.429 -0400", hash_original_method = "B1FCAF7D5B88EED4E84E6E84EBEC9EE4", hash_generated_method = "FF7AB6C83770EFE0104A4927AE98100F")
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        mOnActionExpandListener = listener;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1441105435 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1441105435.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1441105435;
        // ---------- Original Method ----------
        //mOnActionExpandListener = listener;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.429 -0400", hash_original_method = "DAFC43ECD0E5D06566AA28ACE3B5E472", hash_generated_method = "AA774530F8F6A67E1D0CD0E2D60FA940")
    public boolean hasCollapsibleActionView() {
        boolean var14B2EBB734F3A0D0904865526E922815_657813896 = ((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) != 0 && mActionView != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519628154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519628154;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) != 0 && mActionView != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.429 -0400", hash_original_method = "A7B0C8C0A6B0446C22F6521CC0C60064", hash_generated_method = "407D942D4124D9AF1A9CE9B210935DCE")
    public void setActionViewExpanded(boolean isExpanded) {
        mIsActionViewExpanded = isExpanded;
        mMenu.onItemsChanged(false);
        // ---------- Original Method ----------
        //mIsActionViewExpanded = isExpanded;
        //mMenu.onItemsChanged(false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.429 -0400", hash_original_method = "618A94DE2810D1D688B3A7F878D1125A", hash_generated_method = "03E7F07D99B406AA17BBAD876B1C4931")
    public boolean isActionViewExpanded() {
        boolean var6AB54D1A890E4390150D59788F645FF0_1603321732 = (mIsActionViewExpanded);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578221519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578221519;
        // ---------- Original Method ----------
        //return mIsActionViewExpanded;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.429 -0400", hash_original_field = "25C064051816B881687ECD14B4BCA369", hash_generated_field = "8A8FA0202935EA55AD54CD7CFED45C98")

    private static final String TAG = "MenuItemImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.429 -0400", hash_original_field = "4853419C3DE5BA7DDAE9908E29DAA2CD", hash_generated_field = "11894259A35F1BBB9E7F27DD18921EDE")

    private static final int SHOW_AS_ACTION_MASK = SHOW_AS_ACTION_NEVER |
            SHOW_AS_ACTION_IF_ROOM |
            SHOW_AS_ACTION_ALWAYS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.429 -0400", hash_original_field = "44D8ACA63E51B6F3484CCFC3C401596B", hash_generated_field = "943315568AC97A95BEE7FD4A533D08C8")

    private static final int CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.429 -0400", hash_original_field = "AA8FA6BAC5A05627B79C947C0D232729", hash_generated_field = "79E18373E7678760190793C5FAA4E940")

    private static final int CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.429 -0400", hash_original_field = "4BD83E56EE2A97900ECC9A6A8944AED1", hash_generated_field = "80F27CAAB6801F818B589E02F88FCA4D")

    private static final int EXCLUSIVE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.430 -0400", hash_original_field = "9C15CE115096770F474A2620CC59E12C", hash_generated_field = "14D725A9241DDEAEF12149E98726A5C2")

    private static final int HIDDEN = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.430 -0400", hash_original_field = "DF3D10857D57E28E203991699F280170", hash_generated_field = "9D7A6896B452AD15AEC725047E2938A0")

    private static final int ENABLED = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.430 -0400", hash_original_field = "C13DDE3EDD00011B2AF4BB6C84FA15EF", hash_generated_field = "C127B9B1DB91997F1F1D61DE17C3AF8E")

    private static final int IS_ACTION = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.430 -0400", hash_original_field = "3DA77B226EB38F673406BB1FC10EE04A", hash_generated_field = "3EDC205933905E009C1CD4D66D782972")

    static final int NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.430 -0400", hash_original_field = "3610FD0730E1C31E028C448BDFDCFC99", hash_generated_field = "FC531438BE18962F76B22C0A35F07352")

    private static String sPrependShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.430 -0400", hash_original_field = "2CB65CBD30CCC1E5D6CABB5A16183588", hash_generated_field = "DF49530CB048FF09160A19CF46D02A0E")

    private static String sEnterShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.430 -0400", hash_original_field = "0CB32DA7DEC1629C84A2E3AFD8E4445A", hash_generated_field = "E00B0A704D720C24AE1BBC26B39D8B85")

    private static String sDeleteShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.430 -0400", hash_original_field = "8271EB0483099BFFDF8EDE47E409B11D", hash_generated_field = "9D3B92E22BB5269C378158F8ED50B0E4")

    private static String sSpaceShortcutLabel;
}

