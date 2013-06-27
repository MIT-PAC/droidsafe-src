package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private int mGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "B75BDC891F05DF8D9F77776476EBCDD6", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private int mCategoryOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "CCC67011C0B9AB1BA64ACA217793FF17", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private int mOrdering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "793CD2D3A29DBCA3B6EE3D2D5CF29A55", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "5CA918862E899FBE57CD8F3D0DB44604", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "FAC611210B68F831D4A3B699FB58A971", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "EF18AFCEFBAD21F6B816E931AD814543", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "37AC3635461CA62872231C85492F3A9C", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.502 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.503 -0400", hash_original_field = "E163EBF815349370E2BC91E219960B88", hash_generated_field = "CCE2E7E9B41EB859D026207A515694B8")

    private SubMenuBuilder mSubMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.503 -0400", hash_original_field = "2B7E0A3FBDE4E506B96DAB7C97214944", hash_generated_field = "E128AFA2E0B8F17E3CC9B8F36180ADD8")

    private Runnable mItemCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.503 -0400", hash_original_field = "C7443C6F6983E9AE465DCA4986300561", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")

    private MenuItem.OnMenuItemClickListener mClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.503 -0400", hash_original_field = "25DDE236B20D5D6403355424CC7CFB83", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.503 -0400", hash_original_field = "EE351B57987290D5C97C12334A4F5C8A", hash_generated_field = "7FED0AA513FCAFE5BBB64F7D855AC56C")

    private int mShowAsAction = SHOW_AS_ACTION_NEVER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.503 -0400", hash_original_field = "42ED82821F0D805CE8C635AE635639B9", hash_generated_field = "67E37FA198462CB2D5A9B9320B838135")

    private View mActionView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.503 -0400", hash_original_field = "6F151B4E913A23BC3B3F9FF725385336", hash_generated_field = "43987C5D315D6540F5B86319E4F6655F")

    private ActionProvider mActionProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.503 -0400", hash_original_field = "20990041D5CB5868F5C6A4F0A5C55C0F", hash_generated_field = "784094F6CF284A96EDEED4548B8FB05D")

    private OnActionExpandListener mOnActionExpandListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.503 -0400", hash_original_field = "07492CDCBB9799261CC2942AB3F6D415", hash_generated_field = "06A110AC8494F5C7468903392B66FD97")

    private boolean mIsActionViewExpanded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.503 -0400", hash_original_field = "17699AE07D9C5F03811167BB1003FF3E", hash_generated_field = "B7A128C3CB7F07DDB09B9D1855650533")

    private ContextMenuInfo mMenuInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.504 -0400", hash_original_method = "64F6A72F78EB0039947A0530C3919D96", hash_generated_method = "8588EB286C7E0A628C638CAD9C0C3E27")
      MenuItemImpl(MenuBuilder menu, int group, int id, int categoryOrder, int ordering,
            CharSequence title, int showAsAction) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.519 -0400", hash_original_method = "DCB176B376623FC7561DCD073EB66D0A", hash_generated_method = "629E1F5A130CE3FF3B9E504D0978913D")
    public boolean invoke() {
        {
            boolean var88913A92E58559334515FB7FBA94C39B_1415485995 = (mClickListener != null &&
            mClickListener.onMenuItemClick(this));
        } //End collapsed parenthetic
        {
            boolean varFE751BCD088421286FAC3C070DC91E76_753824794 = (mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this));
        } //End collapsed parenthetic
        {
            mItemCallback.run();
        } //End block
        {
            try 
            {
                mMenu.getContext().startActivity(mIntent);
            } //End block
            catch (ActivityNotFoundException e)
            { }
        } //End block
        {
            boolean varB61D100D9A52D650CE9068160A94F50D_61038951 = (mActionProvider != null && mActionProvider.onPerformDefaultAction());
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1506615533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1506615533;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.520 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "34548E30408169515AB4B940F5B700FE")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_148366528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_148366528;
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.520 -0400", hash_original_method = "D7CDC1A4A52E7AA2B30AF0AEE42BB489", hash_generated_method = "679BCA419BE2FA49912AE5854DC89781")
    public MenuItem setEnabled(boolean enabled) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2068436374 = null; //Variable for return #1
        {
            mFlags |= ENABLED;
        } //End block
        {
            mFlags &= ~ENABLED;
        } //End block
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_2068436374 = this;
        addTaint(enabled);
        varB4EAC82CA7396A68D541C85D26508E83_2068436374.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2068436374;
        // ---------- Original Method ----------
        //if (enabled) {
            //mFlags |= ENABLED;
        //} else {
            //mFlags &= ~ENABLED;
        //}
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.521 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "F91B8114447A2D8DD15861D17AF24630")
    public int getGroupId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123686329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123686329;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.522 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "E9C09C533F6CFFD7822029D4D46DACC8")
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709890998 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709890998;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.525 -0400", hash_original_method = "C3905BED22935FA2186A402E1BBD1829", hash_generated_method = "2FF715E0C59A42187511A93E882E387B")
    public int getOrder() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050473549 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050473549;
        // ---------- Original Method ----------
        //return mCategoryOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.525 -0400", hash_original_method = "92E8F82AA50FD1AD58335B2DC7895A83", hash_generated_method = "2E7FB445815A066309625802CA24E56A")
    public int getOrdering() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742747318 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742747318;
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.525 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "340964E45127E30A893506CAB4ABB2A3")
    public Intent getIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1374978598 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1374978598 = mIntent;
        varB4EAC82CA7396A68D541C85D26508E83_1374978598.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1374978598;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.527 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "0FC3C1ABB91A311A52D162C7BFAD6960")
    public MenuItem setIntent(Intent intent) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_13513593 = null; //Variable for return #1
        mIntent = intent;
        varB4EAC82CA7396A68D541C85D26508E83_13513593 = this;
        varB4EAC82CA7396A68D541C85D26508E83_13513593.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_13513593;
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.527 -0400", hash_original_method = "C32C9CAC3047604A3F615D0E2B0A3D92", hash_generated_method = "F5830E98E7AF45148D5303110CE3E5EE")
     Runnable getCallback() {
        Runnable varB4EAC82CA7396A68D541C85D26508E83_83793759 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_83793759 = mItemCallback;
        varB4EAC82CA7396A68D541C85D26508E83_83793759.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_83793759;
        // ---------- Original Method ----------
        //return mItemCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.541 -0400", hash_original_method = "CAD9375B57D68888676D597787CB9AA1", hash_generated_method = "815FAF6DECBC56BEDB7CF91918F22510")
    public MenuItem setCallback(Runnable callback) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1236321453 = null; //Variable for return #1
        mItemCallback = callback;
        varB4EAC82CA7396A68D541C85D26508E83_1236321453 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1236321453.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1236321453;
        // ---------- Original Method ----------
        //mItemCallback = callback;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.541 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "902CC15AFEBB15ECD6895AE5E1B1B19C")
    public char getAlphabeticShortcut() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1175034560 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1175034560;
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.542 -0400", hash_original_method = "88D9907A20D6B14742A0B31CE890DEE4", hash_generated_method = "5FACCAEF92C9CD051DFD1DA015BD487B")
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2077930497 = null; //Variable for return #1
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1068490976 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_2077930497 = this;
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_1068490976 = this;
        MenuItem varA7E53CE21691AB073D9660D615818899_40716542; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_40716542 = varB4EAC82CA7396A68D541C85D26508E83_2077930497;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_40716542 = varB4EAC82CA7396A68D541C85D26508E83_1068490976;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_40716542.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_40716542;
        // ---------- Original Method ----------
        //if (mShortcutAlphabeticChar == alphaChar) return this;
        //mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.543 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "1B45FA5BA71551C0D58B624173403A6E")
    public char getNumericShortcut() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_609236305 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_609236305;
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.548 -0400", hash_original_method = "C979D44A5E5C9CB1A686CC5CF090F436", hash_generated_method = "31161915FC89E007907A152BCF4674FA")
    public MenuItem setNumericShortcut(char numericChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1596435681 = null; //Variable for return #1
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_732847861 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1596435681 = this;
        mShortcutNumericChar = numericChar;
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_732847861 = this;
        MenuItem varA7E53CE21691AB073D9660D615818899_410496633; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_410496633 = varB4EAC82CA7396A68D541C85D26508E83_1596435681;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_410496633 = varB4EAC82CA7396A68D541C85D26508E83_732847861;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_410496633.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_410496633;
        // ---------- Original Method ----------
        //if (mShortcutNumericChar == numericChar) return this;
        //mShortcutNumericChar = numericChar;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.552 -0400", hash_original_method = "0C4A5B3F8F292031B8A33F43134542C3", hash_generated_method = "7E952C9635B4920D25C92589F5084D66")
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1590616578 = null; //Variable for return #1
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_1590616578 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1590616578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1590616578;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.553 -0400", hash_original_method = "D96803BF052A5945B7D152CA36FE6B7E", hash_generated_method = "B32519493386B3B2E051085A138228A8")
     char getShortcut() {
        char var657EE3268E63EFD9A824FD06F69F72DE_31407003 = ((mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        char varA87DEB01C5F539E6BDA34829C8EF2368_432490545 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_432490545;
        // ---------- Original Method ----------
        //return (mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.560 -0400", hash_original_method = "BC454AC179D3698A29B0357FA131C3B2", hash_generated_method = "5E9F1B683810A75C5CA4384FEA9017F8")
     String getShortcutLabel() {
        String varB4EAC82CA7396A68D541C85D26508E83_30156603 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1042537349 = null; //Variable for return #2
        char shortcut;
        shortcut = getShortcut();
        {
            varB4EAC82CA7396A68D541C85D26508E83_30156603 = "";
        } //End block
        StringBuilder sb;
        sb = new StringBuilder(sPrependShortcutLabel);
        //Begin case '\n' 
        sb.append(sEnterShortcutLabel);
        //End case '\n' 
        //Begin case '\b' 
        sb.append(sDeleteShortcutLabel);
        //End case '\b' 
        //Begin case ' ' 
        sb.append(sSpaceShortcutLabel);
        //End case ' ' 
        //Begin case default 
        sb.append(shortcut);
        //End case default 
        varB4EAC82CA7396A68D541C85D26508E83_1042537349 = sb.toString();
        String varA7E53CE21691AB073D9660D615818899_1901432157; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1901432157 = varB4EAC82CA7396A68D541C85D26508E83_30156603;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1901432157 = varB4EAC82CA7396A68D541C85D26508E83_1042537349;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1901432157.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1901432157;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.560 -0400", hash_original_method = "10F1B2AEF5DA21C52B4C4E0F70D42C6B", hash_generated_method = "1569665B4058BA949E43A1CFA5FE0B41")
     boolean shouldShowShortcut() {
        boolean varE0C4140F2C4952AC2F09D9F0558D1D66_1816201455 = (mMenu.isShortcutsVisible() && (getShortcut() != 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1449246371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1449246371;
        // ---------- Original Method ----------
        //return mMenu.isShortcutsVisible() && (getShortcut() != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.571 -0400", hash_original_method = "4569B511D747F82913D0DE9D1EF62E55", hash_generated_method = "33ED614B88C106BE5D66212658B07DC2")
    public SubMenu getSubMenu() {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_2089260890 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2089260890 = mSubMenu;
        varB4EAC82CA7396A68D541C85D26508E83_2089260890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2089260890;
        // ---------- Original Method ----------
        //return mSubMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.571 -0400", hash_original_method = "4556386DBA75360C55B0D4465EB5905E", hash_generated_method = "BFBF6919D821C48C0673ED68EA1687AE")
    public boolean hasSubMenu() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805650916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_805650916;
        // ---------- Original Method ----------
        //return mSubMenu != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.571 -0400", hash_original_method = "84077AC2D714BDDE1A3A80B85CC9BFB0", hash_generated_method = "9BE0E7ADF2FF7A8D98A414C8B1B91CC8")
     void setSubMenu(SubMenuBuilder subMenu) {
        mSubMenu = subMenu;
        subMenu.setHeaderTitle(getTitle());
        // ---------- Original Method ----------
        //mSubMenu = subMenu;
        //subMenu.setHeaderTitle(getTitle());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.573 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "CC1C30620C8C1211E857AF3D69A4F9ED")
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_34143305 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_34143305 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_34143305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_34143305;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.574 -0400", hash_original_method = "6C0965535A50DC1B1EFB814EBEDF6248", hash_generated_method = "C82F2A811234D27AEE61596F48918E09")
     CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_502471580 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_502471580 = ((itemView != null) && itemView.prefersCondensedTitle())
                ? getTitleCondensed()
                : getTitle();
        addTaint(itemView.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_502471580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_502471580;
        // ---------- Original Method ----------
        //return ((itemView != null) && itemView.prefersCondensedTitle())
                //? getTitleCondensed()
                //: getTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.574 -0400", hash_original_method = "1E48645B8578DDF9EFFB5676592C549A", hash_generated_method = "479ACBAF21988DB6FC65A3BF7F0FCF9C")
    public MenuItem setTitle(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1301349843 = null; //Variable for return #1
        mTitle = title;
        mMenu.onItemsChanged(false);
        {
            mSubMenu.setHeaderTitle(title);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1301349843 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1301349843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1301349843;
        // ---------- Original Method ----------
        //mTitle = title;
        //mMenu.onItemsChanged(false);
        //if (mSubMenu != null) {
            //mSubMenu.setHeaderTitle(title);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.583 -0400", hash_original_method = "504EB589769814F693A853F99C8002C5", hash_generated_method = "CB6EFBCFB31F01BC0162C091E0F23C2A")
    public MenuItem setTitle(int title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_385349939 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_385349939 = setTitle(mMenu.getContext().getString(title));
        addTaint(title);
        varB4EAC82CA7396A68D541C85D26508E83_385349939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_385349939;
        // ---------- Original Method ----------
        //return setTitle(mMenu.getContext().getString(title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.584 -0400", hash_original_method = "2F32534D1148FE277B46E47FA445D759", hash_generated_method = "E76AD6E9A29BD136478791E0C5E91B76")
    public CharSequence getTitleCondensed() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1060919175 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1060919175 = mTitleCondensed != null ? mTitleCondensed : mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_1060919175.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1060919175;
        // ---------- Original Method ----------
        //return mTitleCondensed != null ? mTitleCondensed : mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.585 -0400", hash_original_method = "A10897990E671CAED83F82CF9B7ADDEE", hash_generated_method = "95E31019761C3567161A4DA3DF78478F")
    public MenuItem setTitleCondensed(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1281586719 = null; //Variable for return #1
        mTitleCondensed = title;
        {
            title = mTitle;
        } //End block
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_1281586719 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1281586719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1281586719;
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //if (title == null) {
            //title = mTitle;
        //}
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.586 -0400", hash_original_method = "77C51DB63A44599458883D3753A34CC1", hash_generated_method = "12247668105DB3BD2C465CC685562875")
    public Drawable getIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_917868304 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_390748647 = null; //Variable for return #2
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1757232302 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_917868304 = mIconDrawable;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_390748647 = mMenu.getResources().getDrawable(mIconResId);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1757232302 = null;
        Drawable varA7E53CE21691AB073D9660D615818899_1692873538; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1692873538 = varB4EAC82CA7396A68D541C85D26508E83_917868304;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1692873538 = varB4EAC82CA7396A68D541C85D26508E83_390748647;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1692873538 = varB4EAC82CA7396A68D541C85D26508E83_1757232302;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1692873538.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1692873538;
        // ---------- Original Method ----------
        //if (mIconDrawable != null) {
            //return mIconDrawable;
        //}
        //if (mIconResId != NO_ICON) {
            //return mMenu.getResources().getDrawable(mIconResId);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.586 -0400", hash_original_method = "BD8BE6A7204F93A97A4B1462396F9006", hash_generated_method = "AA689CB93F21252BFBF883C7A5E4377E")
    public MenuItem setIcon(Drawable icon) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1832608789 = null; //Variable for return #1
        mIconResId = NO_ICON;
        mIconDrawable = icon;
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_1832608789 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1832608789.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1832608789;
        // ---------- Original Method ----------
        //mIconResId = NO_ICON;
        //mIconDrawable = icon;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.598 -0400", hash_original_method = "6CA4716E877DA09BBA89FF884DD9F3E1", hash_generated_method = "FD6199F2A0E16CEC5F087D23C28095AA")
    public MenuItem setIcon(int iconResId) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1107361186 = null; //Variable for return #1
        mIconDrawable = null;
        mIconResId = iconResId;
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_1107361186 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1107361186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1107361186;
        // ---------- Original Method ----------
        //mIconDrawable = null;
        //mIconResId = iconResId;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.598 -0400", hash_original_method = "03294EC000E2E3A998710BD4D5DBC105", hash_generated_method = "1244470DB02F1F194B4B45B83B391D66")
    public boolean isCheckable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075427260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075427260;
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) == CHECKABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.602 -0400", hash_original_method = "97D03B8420DC0405BDED5AEBB6194B4D", hash_generated_method = "3C8D771804B33B30A81C50CF80D5E973")
    public MenuItem setCheckable(boolean checkable) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_137304539 = null; //Variable for return #1
        int oldFlags;
        oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        {
            mMenu.onItemsChanged(false);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_137304539 = this;
        varB4EAC82CA7396A68D541C85D26508E83_137304539.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_137304539;
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //if (oldFlags != mFlags) {
            //mMenu.onItemsChanged(false);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.606 -0400", hash_original_method = "D48B0A4B4830ACC112B29145FA304FB9", hash_generated_method = "72956FA378A284989864C014D06C7B79")
    public void setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.606 -0400", hash_original_method = "09CA122F8C23D0DDA91200023A557A5D", hash_generated_method = "F2CFEF7B5928D883AB5B3560571AF51E")
    public boolean isExclusiveCheckable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_56181614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_56181614;
        // ---------- Original Method ----------
        //return (mFlags & EXCLUSIVE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.606 -0400", hash_original_method = "153A3CA3675B13C11B20504065FC3BF7", hash_generated_method = "94A4C66DC2065CB968C15BFD3E85DF4B")
    public boolean isChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481673382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_481673382;
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) == CHECKED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.611 -0400", hash_original_method = "9107E25FB1CB75DAB92AC94A4D8833A7", hash_generated_method = "93C0B7AB104594615AB7203C11590221")
    public MenuItem setChecked(boolean checked) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1837948318 = null; //Variable for return #1
        {
            mMenu.setExclusiveItemChecked(this);
        } //End block
        {
            setCheckedInt(checked);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1837948318 = this;
        addTaint(checked);
        varB4EAC82CA7396A68D541C85D26508E83_1837948318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1837948318;
        // ---------- Original Method ----------
        //if ((mFlags & EXCLUSIVE) != 0) {
            //mMenu.setExclusiveItemChecked(this);
        //} else {
            //setCheckedInt(checked);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.611 -0400", hash_original_method = "F4E3FA5EA691BD61029F7B342451D96B", hash_generated_method = "EF9AC3BE227E434280EBFD65936A5D02")
     void setCheckedInt(boolean checked) {
        int oldFlags;
        oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.612 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "1ACBFA00E38AC3CA1493F2BCF30A33DC")
    public boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386960344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386960344;
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.612 -0400", hash_original_method = "6BBB65AE1F8C0F9A0552DC908B4D29C9", hash_generated_method = "373C050368F63C7B149F86A4704E84F9")
     boolean setVisibleInt(boolean shown) {
        int oldFlags;
        oldFlags = mFlags;
        mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649760307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_649760307;
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        //return oldFlags != mFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.612 -0400", hash_original_method = "C575291A3325EE507AB9F55E92185E54", hash_generated_method = "102AB6A7D6BBFCC9A4BAFB28DACA11F7")
    public MenuItem setVisible(boolean shown) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1528251909 = null; //Variable for return #1
        {
            boolean var888A88BADDB15852039C5C93445B7B9E_1901849028 = (setVisibleInt(shown));
            mMenu.onItemVisibleChanged(this);
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1528251909 = this;
        addTaint(shown);
        varB4EAC82CA7396A68D541C85D26508E83_1528251909.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1528251909;
        // ---------- Original Method ----------
        //if (setVisibleInt(shown)) mMenu.onItemVisibleChanged(this);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.619 -0400", hash_original_method = "1DDD55F9AC5A73432BCD73A94619FD45", hash_generated_method = "7342E3671F107BEEA73B55F2C30B941A")
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1854370764 = null; //Variable for return #1
        mClickListener = clickListener;
        varB4EAC82CA7396A68D541C85D26508E83_1854370764 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1854370764.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1854370764;
        // ---------- Original Method ----------
        //mClickListener = clickListener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.619 -0400", hash_original_method = "233A3AFEB21203525FBA5B1CF441183E", hash_generated_method = "411BD76487D6AE46F958E7A9840A45CF")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1838589636 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1838589636 = mTitle.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1838589636.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1838589636;
        // ---------- Original Method ----------
        //return mTitle.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.619 -0400", hash_original_method = "B6421912A15ECCB29CB28DC744FEB4DF", hash_generated_method = "48D720FE3E7BA870AFBD08C536357B9E")
     void setMenuInfo(ContextMenuInfo menuInfo) {
        mMenuInfo = menuInfo;
        // ---------- Original Method ----------
        //mMenuInfo = menuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.620 -0400", hash_original_method = "A0E326FAE2703231717DF34591A2C639", hash_generated_method = "2A9A1953B68D1B00AC11048846BC827C")
    public ContextMenuInfo getMenuInfo() {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_1634231189 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1634231189 = mMenuInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1634231189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1634231189;
        // ---------- Original Method ----------
        //return mMenuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.620 -0400", hash_original_method = "221F1892BBAF0D6C0448BF9B80F29C7C", hash_generated_method = "AA105CD9041C087568465B6F262D8004")
    public void actionFormatChanged() {
        mMenu.onItemActionRequestChanged(this);
        // ---------- Original Method ----------
        //mMenu.onItemActionRequestChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.620 -0400", hash_original_method = "B7358CCF217D02273B220AA1E4900E11", hash_generated_method = "5AD80D80C4D0A2C5AF7D3464781E6ACC")
    public boolean shouldShowIcon() {
        boolean var70F98333FA0948733960A5795635FA78_1648849865 = (mMenu.getOptionalIconsVisible());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045445225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045445225;
        // ---------- Original Method ----------
        //return mMenu.getOptionalIconsVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.632 -0400", hash_original_method = "8639B741C99124BF9C4FC28DBCA735D7", hash_generated_method = "FED811F7938B536D15F81A791154CFF6")
    public boolean isActionButton() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_549894697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_549894697;
        // ---------- Original Method ----------
        //return (mFlags & IS_ACTION) == IS_ACTION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.632 -0400", hash_original_method = "D20AA9738309FEFC21F93C6653D8A4BB", hash_generated_method = "2C1DBD337D5B4CBE189774BC30795A75")
    public boolean requestsActionButton() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090557076 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090557076;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_IF_ROOM) == SHOW_AS_ACTION_IF_ROOM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.632 -0400", hash_original_method = "A0218090F414AFC2516DB1AFD001E557", hash_generated_method = "98DCCCD005944F1F9B379FC5513F1795")
    public boolean requiresActionButton() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098907904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098907904;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_ALWAYS) == SHOW_AS_ACTION_ALWAYS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.633 -0400", hash_original_method = "7A64484A152776341109FA7C71AB82BB", hash_generated_method = "DA27F71957BEDA7B0193232ADA4F4B91")
    public void setIsActionButton(boolean isActionButton) {
        {
            mFlags |= IS_ACTION;
        } //End block
        {
            mFlags &= ~IS_ACTION;
        } //End block
        addTaint(isActionButton);
        // ---------- Original Method ----------
        //if (isActionButton) {
            //mFlags |= IS_ACTION;
        //} else {
            //mFlags &= ~IS_ACTION;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.634 -0400", hash_original_method = "D19EFCF4D4C49A6F9A7B8D6E601DFE3B", hash_generated_method = "78457E40A2203D719FEE13DC0B07287E")
    public boolean showsTextAsAction() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2051674987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2051674987;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_WITH_TEXT) == SHOW_AS_ACTION_WITH_TEXT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.634 -0400", hash_original_method = "6034AD3E3F15BF95CED1827A99F9830A", hash_generated_method = "E8D8563084B1CC50260BAE003759E5BE")
    public void setShowAsAction(int actionEnum) {
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM,"
                        + " and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        //End case default 
        mShowAsAction = actionEnum;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.637 -0400", hash_original_method = "9511E068798AA5E04A674F02DC2F7567", hash_generated_method = "2C3685BA3E3C447933C43A103C464095")
    public MenuItem setActionView(View view) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_417788732 = null; //Variable for return #1
        mActionView = view;
        mActionProvider = null;
        {
            boolean var9383E447CCD31AC0A55E5ECF75C1C296_1672312067 = (view != null && view.getId() == View.NO_ID && mId > 0);
            {
                view.setId(mId);
            } //End block
        } //End collapsed parenthetic
        mMenu.onItemActionRequestChanged(this);
        varB4EAC82CA7396A68D541C85D26508E83_417788732 = this;
        varB4EAC82CA7396A68D541C85D26508E83_417788732.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_417788732;
        // ---------- Original Method ----------
        //mActionView = view;
        //mActionProvider = null;
        //if (view != null && view.getId() == View.NO_ID && mId > 0) {
            //view.setId(mId);
        //}
        //mMenu.onItemActionRequestChanged(this);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.640 -0400", hash_original_method = "B057E2C488C14BC05DF25DD2F229F8B2", hash_generated_method = "D09E1231780ADF241C2EA8A32EC4A7BA")
    public MenuItem setActionView(int resId) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_567896522 = null; //Variable for return #1
        Context context;
        context = mMenu.getContext();
        LayoutInflater inflater;
        inflater = LayoutInflater.from(context);
        setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        varB4EAC82CA7396A68D541C85D26508E83_567896522 = this;
        addTaint(resId);
        varB4EAC82CA7396A68D541C85D26508E83_567896522.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_567896522;
        // ---------- Original Method ----------
        //final Context context = mMenu.getContext();
        //final LayoutInflater inflater = LayoutInflater.from(context);
        //setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.640 -0400", hash_original_method = "404D78F2C7005B21FAAA5C37E608175C", hash_generated_method = "3ECCE6131ED1A2AD528AFDB14078E780")
    public View getActionView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1981770480 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_732325667 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_799470022 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1981770480 = mActionView;
        } //End block
        {
            mActionView = mActionProvider.onCreateActionView();
            varB4EAC82CA7396A68D541C85D26508E83_732325667 = mActionView;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_799470022 = null;
        } //End block
        View varA7E53CE21691AB073D9660D615818899_2004920304; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2004920304 = varB4EAC82CA7396A68D541C85D26508E83_1981770480;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2004920304 = varB4EAC82CA7396A68D541C85D26508E83_732325667;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2004920304 = varB4EAC82CA7396A68D541C85D26508E83_799470022;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2004920304.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2004920304;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.641 -0400", hash_original_method = "F6993BB94930E20BEF3D6DE6883E2D9B", hash_generated_method = "0426576F5143643801742ADA32AB3B8F")
    public ActionProvider getActionProvider() {
        ActionProvider varB4EAC82CA7396A68D541C85D26508E83_802747822 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_802747822 = mActionProvider;
        varB4EAC82CA7396A68D541C85D26508E83_802747822.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_802747822;
        // ---------- Original Method ----------
        //return mActionProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.644 -0400", hash_original_method = "C59B6F24EC844FBD609E594809339FFA", hash_generated_method = "1BE6E9417036A185DFB8630712020C70")
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1823498326 = null; //Variable for return #1
        mActionView = null;
        mActionProvider = actionProvider;
        mMenu.onItemsChanged(true);
        varB4EAC82CA7396A68D541C85D26508E83_1823498326 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1823498326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1823498326;
        // ---------- Original Method ----------
        //mActionView = null;
        //mActionProvider = actionProvider;
        //mMenu.onItemsChanged(true);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.646 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "4239E93148B39871189648544DA426AF")
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_605905870 = null; //Variable for return #1
        setShowAsAction(actionEnum);
        varB4EAC82CA7396A68D541C85D26508E83_605905870 = this;
        addTaint(actionEnum);
        varB4EAC82CA7396A68D541C85D26508E83_605905870.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_605905870;
        // ---------- Original Method ----------
        //setShowAsAction(actionEnum);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.647 -0400", hash_original_method = "9242B1434B9CD0ACB88D22E492AB3A81", hash_generated_method = "2370671539A37215BD5157B6D3807E6B")
    @Override
    public boolean expandActionView() {
        {
            boolean var81D84D08096DF9E1FCCD4F85A3884372_675101903 = (mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionExpand(this));
            {
                boolean var38AC753AE765E96CBE659CBBA5A8A723_508952627 = (mMenu.expandItemActionView(this));
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918441496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918441496;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.648 -0400", hash_original_method = "DB0EB37C3626C85F2C23377923AB6063", hash_generated_method = "57623A334B72B47E29FFC3C96DF44E0C")
    @Override
    public boolean collapseActionView() {
        {
            boolean varA0F65C9905152D79B43E3C0EEE82344B_1238770484 = (mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionCollapse(this));
            {
                boolean var690A803F41D0DAB576A6FB2B9FAC7EC4_2055710538 = (mMenu.collapseItemActionView(this));
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484689460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484689460;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.663 -0400", hash_original_method = "B1FCAF7D5B88EED4E84E6E84EBEC9EE4", hash_generated_method = "C3BEEF4E7F0723C20E2D1C7ACB31E42A")
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_420005595 = null; //Variable for return #1
        mOnActionExpandListener = listener;
        varB4EAC82CA7396A68D541C85D26508E83_420005595 = this;
        varB4EAC82CA7396A68D541C85D26508E83_420005595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_420005595;
        // ---------- Original Method ----------
        //mOnActionExpandListener = listener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.664 -0400", hash_original_method = "DAFC43ECD0E5D06566AA28ACE3B5E472", hash_generated_method = "104FA9FBF9E2995C48735A1E1583F0C0")
    public boolean hasCollapsibleActionView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256133725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256133725;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) != 0 && mActionView != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.664 -0400", hash_original_method = "A7B0C8C0A6B0446C22F6521CC0C60064", hash_generated_method = "407D942D4124D9AF1A9CE9B210935DCE")
    public void setActionViewExpanded(boolean isExpanded) {
        mIsActionViewExpanded = isExpanded;
        mMenu.onItemsChanged(false);
        // ---------- Original Method ----------
        //mIsActionViewExpanded = isExpanded;
        //mMenu.onItemsChanged(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_method = "618A94DE2810D1D688B3A7F878D1125A", hash_generated_method = "184BAD97D453A11C8256B80BD9DFBDC1")
    public boolean isActionViewExpanded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167116552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167116552;
        // ---------- Original Method ----------
        //return mIsActionViewExpanded;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "25C064051816B881687ECD14B4BCA369", hash_generated_field = "046CF9782F77661C7173E19AF6F630E9")

    private static String TAG = "MenuItemImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "4853419C3DE5BA7DDAE9908E29DAA2CD", hash_generated_field = "169B425EEDCF30A851BB8FCB7BB78BBB")

    private static int SHOW_AS_ACTION_MASK = SHOW_AS_ACTION_NEVER |
            SHOW_AS_ACTION_IF_ROOM |
            SHOW_AS_ACTION_ALWAYS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "44D8ACA63E51B6F3484CCFC3C401596B", hash_generated_field = "CF5C64A78A33C6C0B820D00EBAEA0E8C")

    private static int CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "AA8FA6BAC5A05627B79C947C0D232729", hash_generated_field = "411C8EC520AC74F640455BDE89EF2D9A")

    private static int CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "4BD83E56EE2A97900ECC9A6A8944AED1", hash_generated_field = "49D3CE30F0A77467706408512140A513")

    private static int EXCLUSIVE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "9C15CE115096770F474A2620CC59E12C", hash_generated_field = "19B01B6D2439A0ADD3907E2E58A77176")

    private static int HIDDEN = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "DF3D10857D57E28E203991699F280170", hash_generated_field = "E7D0E1C5A80CDDBE92E49AF457D7D219")

    private static int ENABLED = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "C13DDE3EDD00011B2AF4BB6C84FA15EF", hash_generated_field = "A68BD35391302F3A0BBBA11BFFBD7057")

    private static int IS_ACTION = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "3DA77B226EB38F673406BB1FC10EE04A", hash_generated_field = "AE5CA217A8B53DC6C8F9BB8DE3A14CAE")

    static int NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "3610FD0730E1C31E028C448BDFDCFC99", hash_generated_field = "FC531438BE18962F76B22C0A35F07352")

    private static String sPrependShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "2CB65CBD30CCC1E5D6CABB5A16183588", hash_generated_field = "DF49530CB048FF09160A19CF46D02A0E")

    private static String sEnterShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "0CB32DA7DEC1629C84A2E3AFD8E4445A", hash_generated_field = "E00B0A704D720C24AE1BBC26B39D8B85")

    private static String sDeleteShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.665 -0400", hash_original_field = "8271EB0483099BFFDF8EDE47E409B11D", hash_generated_field = "9D3B92E22BB5269C378158F8ED50B0E4")

    private static String sSpaceShortcutLabel;
}

