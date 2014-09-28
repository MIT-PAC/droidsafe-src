/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;

/**
 * @hide
 */
public final class MenuItemImpl implements SupportMenuItem {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.340 -0400", hash_original_field = "C708DC845CCB118E0188D85691D8F99D", hash_generated_field = "8A8FA0202935EA55AD54CD7CFED45C98")

    private static final String TAG = "MenuItemImpl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.342 -0400", hash_original_field = "7981CDB2AE281F30AAC56F01F175B7B0", hash_generated_field = "11894259A35F1BBB9E7F27DD18921EDE")

    private static final int SHOW_AS_ACTION_MASK = SHOW_AS_ACTION_NEVER |
            SHOW_AS_ACTION_IF_ROOM |
            SHOW_AS_ACTION_ALWAYS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.382 -0400", hash_original_field = "90654049052F718180E995FFF6612EFC", hash_generated_field = "943315568AC97A95BEE7FD4A533D08C8")

    private static final int CHECKABLE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.384 -0400", hash_original_field = "DDAF50494EDE92B5A907F7788646DD1D", hash_generated_field = "79E18373E7678760190793C5FAA4E940")

    private static final int CHECKED = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.386 -0400", hash_original_field = "3133F3AB867F08EB7F5C188557ADF8DE", hash_generated_field = "80F27CAAB6801F818B589E02F88FCA4D")

    private static final int EXCLUSIVE = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.389 -0400", hash_original_field = "D1A8B498453E3580610DDDDF65EDF69E", hash_generated_field = "14D725A9241DDEAEF12149E98726A5C2")

    private static final int HIDDEN = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.391 -0400", hash_original_field = "9E28E33B02832F7297D3046B6A7FB712", hash_generated_field = "9D7A6896B452AD15AEC725047E2938A0")

    private static final int ENABLED = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.394 -0400", hash_original_field = "0E20AAD2047A12ADBDDA0DF4352992F8", hash_generated_field = "C127B9B1DB91997F1F1D61DE17C3AF8E")

    private static final int IS_ACTION = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.408 -0400", hash_original_field = "85EA99D3EE3FBF5630E4D962E96A8E74", hash_generated_field = "3EDC205933905E009C1CD4D66D782972")

    static final int NO_ICON = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.413 -0400", hash_original_field = "59B421A8FE3BC25F62030250529693D7", hash_generated_field = "FC531438BE18962F76B22C0A35F07352")

    private static String sPrependShortcutLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.415 -0400", hash_original_field = "E28D41981900365F630C914E443EB78B", hash_generated_field = "DF49530CB048FF09160A19CF46D02A0E")

    private static String sEnterShortcutLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.417 -0400", hash_original_field = "5B77358A1AAF43094E975F404FC13AC4", hash_generated_field = "E00B0A704D720C24AE1BBC26B39D8B85")

    private static String sDeleteShortcutLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.420 -0400", hash_original_field = "8910E496ECB4B5082B1A433A77F322E3", hash_generated_field = "9D3B92E22BB5269C378158F8ED50B0E4")

    private static String sSpaceShortcutLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.344 -0400", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private  int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.346 -0400", hash_original_field = "9C43571C45B8BC34B7C8A06B2271F04A", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private  int mGroup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.350 -0400", hash_original_field = "F6DD8D04E6975C66628782A471D540ED", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private  int mCategoryOrder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.352 -0400", hash_original_field = "3D9DE4CD049B86E1600012D5AF1467A8", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private  int mOrdering;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.355 -0400", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.357 -0400", hash_original_field = "FA3171B1888A35931DDF94EF6B72DFBA", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.359 -0400", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.361 -0400", hash_original_field = "48B12B8F5B9FDB1D830B92E86520B6F6", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.363 -0400", hash_original_field = "4416434619B59B48D8ADBB443F744028", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.365 -0400", hash_original_field = "E7758D8423F0CD19BF50F0B56DC871A4", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.368 -0400", hash_original_field = "90FECF5DA6E08407086BFE725E64094A", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.370 -0400", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.373 -0400", hash_original_field = "F72B98E23896D66B33476F874979B6CA", hash_generated_field = "CCE2E7E9B41EB859D026207A515694B8")

    private SubMenuBuilder mSubMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.375 -0400", hash_original_field = "1A7931F59B15F85E44E48C3C0BA36CF4", hash_generated_field = "E128AFA2E0B8F17E3CC9B8F36180ADD8")

    private Runnable mItemCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.377 -0400", hash_original_field = "824951867F9D04F82A57AB05007E48C8", hash_generated_field = "3EA27FC031A87D971F00BEBBF2171166")

    private SupportMenuItem.OnMenuItemClickListener mClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.380 -0400", hash_original_field = "87B4121714640703C04C2D7C1C71B5DF", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.396 -0400", hash_original_field = "69A7B4CA5D0B8456F60CBDC3F3253EA7", hash_generated_field = "7FED0AA513FCAFE5BBB64F7D855AC56C")

    private int mShowAsAction = SHOW_AS_ACTION_NEVER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.399 -0400", hash_original_field = "CF9B01C975925C0DA31724E1293F9F0D", hash_generated_field = "67E37FA198462CB2D5A9B9320B838135")

    private View mActionView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.401 -0400", hash_original_field = "F9AA1331F7CB2C9D557F643AF8FB1074", hash_generated_field = "43987C5D315D6540F5B86319E4F6655F")

    private ActionProvider mActionProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.403 -0400", hash_original_field = "B92970A6A1FC05716C00341B30F73879", hash_generated_field = "726FADE9CABDBF9EA8E6799ACE5DFDD8")

    private MenuItemCompat.OnActionExpandListener mOnActionExpandListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.406 -0400", hash_original_field = "B289A78D4D56C56810318DDEA40BF3FC", hash_generated_field = "06A110AC8494F5C7468903392B66FD97")

    private boolean mIsActionViewExpanded = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.410 -0400", hash_original_field = "90649C9C885A9727EF12DE68AC0B1F2F", hash_generated_field = "B7A128C3CB7F07DDB09B9D1855650533")

    private ContextMenuInfo mMenuInfo;

    /**
     * Instantiates this menu item.
     *
     * @param group         Item ordering grouping control. The item will be added after all other
     *                      items whose order is <= this number, and before any that are larger than
     *                      it. This can also be used to define groups of items for batch state
     *                      changes. Normally use 0.
     * @param id            Unique item ID. Use 0 if you do not need a unique ID.
     * @param categoryOrder The ordering for this item.
     * @param title         The text to display for the item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.423 -0400", hash_original_method = "67564F3278B2785B0D51A928B0CAEE16", hash_generated_method = "A5FD69BF8E7D51507AA60008AD522003")
    
MenuItemImpl(MenuBuilder menu, int group, int id, int categoryOrder, int ordering,
            CharSequence title, int showAsAction) {

        /*if (sPrependShortcutLabel == null) {
          // This is instantiated from the UI thread, so no chance of sync issues
          sPrependShortcutLabel = menu.getContext().getResources().getString(
              com.android.internal.R.string.prepend_shortcut_label);
          sEnterShortcutLabel = menu.getContext().getResources().getString(
              com.android.internal.R.string.menu_enter_shortcut_label);
          sDeleteShortcutLabel = menu.getContext().getResources().getString(
              com.android.internal.R.string.menu_delete_shortcut_label);
          sSpaceShortcutLabel = menu.getContext().getResources().getString(
              com.android.internal.R.string.menu_space_shortcut_label);
        }*/

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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.426 -0400", hash_original_method = "DCB176B376623FC7561DCD073EB66D0A", hash_generated_method = "BC07DF84425BB82DDA544CDA0E99B7FE")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.428 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "2C57F300102CAB2A746B3D79609388B9")
    
@Override
    public boolean isEnabled() {
        return (mFlags & ENABLED) != 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.430 -0400", hash_original_method = "D7CDC1A4A52E7AA2B30AF0AEE42BB489", hash_generated_method = "763E57CF74630D654CBE4F5929571C34")
    
@Override
    public MenuItem setEnabled(boolean enabled) {
        if (enabled) {
            mFlags |= ENABLED;
        } else {
            mFlags &= ~ENABLED;
        }

        mMenu.onItemsChanged(false);

        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.433 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "7B803AC3E76E8AF39F24F83919CC5D40")
    
@Override
    public int getGroupId() {
        return mGroup;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.435 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "A676524EE508536925146DBD28AB8631")
    
@Override
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return mId;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.438 -0400", hash_original_method = "C3905BED22935FA2186A402E1BBD1829", hash_generated_method = "2AC4705405B6CCC28C180774BD3FEBA9")
    
@Override
    public int getOrder() {
        return mCategoryOrder;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.440 -0400", hash_original_method = "92E8F82AA50FD1AD58335B2DC7895A83", hash_generated_method = "86ECFC944B9ECDE2A30AF3BDF41C6AF2")
    
public int getOrdering() {
        return mOrdering;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.443 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "400CFD47B6CF2F75AB75B42E934A8FA2")
    
@Override
    public Intent getIntent() {
        return mIntent;
    }

    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.445 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "3AB9F323AC40749159432422C283110F")
    
@Override
    public MenuItem setIntent(Intent intent) {
        mIntent = intent;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.447 -0400", hash_original_method = "C32C9CAC3047604A3F615D0E2B0A3D92", hash_generated_method = "C32C9CAC3047604A3F615D0E2B0A3D92")
    
Runnable getCallback() {
        return mItemCallback;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.449 -0400", hash_original_method = "CAD9375B57D68888676D597787CB9AA1", hash_generated_method = "0D75E48DE09605C569BED85BD011E981")
    
public MenuItem setCallback(Runnable callback) {
        mItemCallback = callback;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.452 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "7D85C8AF08C90061DDC55B4C6B863E3F")
    
@Override
    public char getAlphabeticShortcut() {
        return mShortcutAlphabeticChar;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.454 -0400", hash_original_method = "4C0044B917CA1F819AEEC42CC44C40C3", hash_generated_method = "350A686CBE1FDA6C3C3AF633A00AA884")
    
@Override
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        if (mShortcutAlphabeticChar == alphaChar) {
            return this;
        }

        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);

        mMenu.onItemsChanged(false);

        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.456 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "D8228298D400D97310D9CA7A591CE156")
    
@Override
    public char getNumericShortcut() {
        return mShortcutNumericChar;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.459 -0400", hash_original_method = "BE9041D99B892F7EFAFC66E15EB95BC7", hash_generated_method = "4DEF3040218D040CA6694418A76C5E36")
    
@Override
    public MenuItem setNumericShortcut(char numericChar) {
        if (mShortcutNumericChar == numericChar) {
            return this;
        }

        mShortcutNumericChar = numericChar;

        mMenu.onItemsChanged(false);

        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.461 -0400", hash_original_method = "0C4A5B3F8F292031B8A33F43134542C3", hash_generated_method = "D9900F829163403D7B56A3459CDF603B")
    
@Override
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);

        mMenu.onItemsChanged(false);

        return this;
    }

    /**
     * @return The active shortcut (based on QWERTY-mode of the menu).
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.463 -0400", hash_original_method = "FD3A801F4044283A1FD3F05BDD804175", hash_generated_method = "A84C588A30BAB7264584BC87D7726C8D")
    
char getShortcut() {
        //return (mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar);
        return mShortcutAlphabeticChar;
    }

    /**
     * @return The label to show for the shortcut. This includes the chording key (for example
     *         'Menu+a'). Also, any non-human readable characters should be human readable (for
     *         example 'Menu+enter').
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.466 -0400", hash_original_method = "BC454AC179D3698A29B0357FA131C3B2", hash_generated_method = "BC454AC179D3698A29B0357FA131C3B2")
    
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
     * @return Whether this menu item should be showing shortcuts (depends on whether the menu
     *         should show shortcuts and whether this item has a shortcut defined)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.468 -0400", hash_original_method = "10F1B2AEF5DA21C52B4C4E0F70D42C6B", hash_generated_method = "94CAC6D43EF5F3E660F3D52EFEF9FDCE")
    
boolean shouldShowShortcut() {
        // Show shortcuts if the menu is supposed to show shortcuts AND this item has a shortcut
        return mMenu.isShortcutsVisible() && (getShortcut() != 0);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.471 -0400", hash_original_method = "4569B511D747F82913D0DE9D1EF62E55", hash_generated_method = "56073C2BE51846EFA77A217C770B11ED")
    
@Override
    public SubMenu getSubMenu() {
        return mSubMenu;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.473 -0400", hash_original_method = "4556386DBA75360C55B0D4465EB5905E", hash_generated_method = "39B91AE7AE86FCE684E3CE43111B9300")
    
@Override
    public boolean hasSubMenu() {
        return mSubMenu != null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.475 -0400", hash_original_method = "84077AC2D714BDDE1A3A80B85CC9BFB0", hash_generated_method = "84077AC2D714BDDE1A3A80B85CC9BFB0")
    
void setSubMenu(SubMenuBuilder subMenu) {
        mSubMenu = subMenu;

        subMenu.setHeaderTitle(getTitle());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.477 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "C5F315CE5CC2BEAA47F192EA7B715B37")
    
@Override
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return mTitle;
    }

    /**
     * Gets the title for a particular {@link MenuView.ItemView}
     *
     * @param itemView The ItemView that is receiving the title
     * @return Either the title or condensed title based on what the ItemView prefers
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.479 -0400", hash_original_method = "6C0965535A50DC1B1EFB814EBEDF6248", hash_generated_method = "6C0965535A50DC1B1EFB814EBEDF6248")
    
CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        return ((itemView != null) && itemView.prefersCondensedTitle())
                ? getTitleCondensed()
                : getTitle();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.482 -0400", hash_original_method = "1E48645B8578DDF9EFFB5676592C549A", hash_generated_method = "65FAA261159BDE27A4F6BEB7F9A32359")
    
@Override
    public MenuItem setTitle(CharSequence title) {
        mTitle = title;

        mMenu.onItemsChanged(false);

        if (mSubMenu != null) {
            mSubMenu.setHeaderTitle(title);
        }

        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.485 -0400", hash_original_method = "504EB589769814F693A853F99C8002C5", hash_generated_method = "6C1DD82F99182F088AED9FF398D721D7")
    
@Override
    public MenuItem setTitle(int title) {
        return setTitle(mMenu.getContext().getString(title));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.487 -0400", hash_original_method = "2F32534D1148FE277B46E47FA445D759", hash_generated_method = "AE5E445BF5180305D4C53EA0378FE2A4")
    
@Override
    public CharSequence getTitleCondensed() {
        return mTitleCondensed != null ? mTitleCondensed : mTitle;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.490 -0400", hash_original_method = "A10897990E671CAED83F82CF9B7ADDEE", hash_generated_method = "8905F170EB11F87A1800097A2F315841")
    
@Override
    public MenuItem setTitleCondensed(CharSequence title) {
        mTitleCondensed = title;

        // Could use getTitle() in the loop below, but just cache what it would do here
        if (title == null) {
            title = mTitle;
        }

        mMenu.onItemsChanged(false);

        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.492 -0400", hash_original_method = "1E07F9DEEA18FBEFADBD61431B40D1C8", hash_generated_method = "264850AC73D54F9E1D93CDA7B79C6F9F")
    
@Override
    public Drawable getIcon() {
        if (mIconDrawable != null) {
            return mIconDrawable;
        }

        if (mIconResId != NO_ICON) {
            Drawable icon =  mMenu.getResources().getDrawable(mIconResId);
            mIconResId = NO_ICON;
            mIconDrawable = icon;
            return icon;
        }

        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.494 -0400", hash_original_method = "BD8BE6A7204F93A97A4B1462396F9006", hash_generated_method = "D4031FDE98DB6543B8E69D67C86418E2")
    
@Override
    public MenuItem setIcon(Drawable icon) {
        mIconResId = NO_ICON;
        mIconDrawable = icon;
        mMenu.onItemsChanged(false);

        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.497 -0400", hash_original_method = "6CA4716E877DA09BBA89FF884DD9F3E1", hash_generated_method = "3D173A68F27C2747871ABC7EBB916A8A")
    
@Override
    public MenuItem setIcon(int iconResId) {
        mIconDrawable = null;
        mIconResId = iconResId;

        // If we have a view, we need to push the Drawable to them
        mMenu.onItemsChanged(false);

        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.499 -0400", hash_original_method = "03294EC000E2E3A998710BD4D5DBC105", hash_generated_method = "7B1F8DFD0B12AE67C69289677E0F6A09")
    
@Override
    public boolean isCheckable() {
        return (mFlags & CHECKABLE) == CHECKABLE;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.502 -0400", hash_original_method = "97D03B8420DC0405BDED5AEBB6194B4D", hash_generated_method = "9E823CAF0CE24C3124109429B6D97B30")
    
@Override
    public MenuItem setCheckable(boolean checkable) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        if (oldFlags != mFlags) {
            mMenu.onItemsChanged(false);
        }

        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.505 -0400", hash_original_method = "D48B0A4B4830ACC112B29145FA304FB9", hash_generated_method = "D3E935207667584557FD554C5725658F")
    
public void setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.507 -0400", hash_original_method = "09CA122F8C23D0DDA91200023A557A5D", hash_generated_method = "554225F6F0A6FF90EDE7D50256C3AD37")
    
public boolean isExclusiveCheckable() {
        return (mFlags & EXCLUSIVE) != 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.510 -0400", hash_original_method = "153A3CA3675B13C11B20504065FC3BF7", hash_generated_method = "DBFBE220FB76D03A73D1013AC81CE97A")
    
@Override
    public boolean isChecked() {
        return (mFlags & CHECKED) == CHECKED;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.513 -0400", hash_original_method = "9107E25FB1CB75DAB92AC94A4D8833A7", hash_generated_method = "97D39DE05BE52C048A5A0BCD634E021A")
    
@Override
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.515 -0400", hash_original_method = "F4E3FA5EA691BD61029F7B342451D96B", hash_generated_method = "F4E3FA5EA691BD61029F7B342451D96B")
    
void setCheckedInt(boolean checked) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        if (oldFlags != mFlags) {
            mMenu.onItemsChanged(false);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.518 -0400", hash_original_method = "9BD16A434CC3C012852C7AB8BEFB242D", hash_generated_method = "A68EF48A32C43461716CC09762B11D6D")
    
@Override
    public boolean isVisible() {
        if (mActionProvider != null && mActionProvider.overridesItemVisibility()) {
            return (mFlags & HIDDEN) == 0 && mActionProvider.isVisible();
        }
        return (mFlags & HIDDEN) == 0;
    }

    /**
     * Changes the visibility of the item. This method DOES NOT notify the parent menu of a change
     * in this item, so this should only be called from methods that will eventually trigger this
     * change.  If unsure, use {@link #setVisible(boolean)} instead.
     *
     * @param shown Whether to show (true) or hide (false).
     * @return Whether the item's shown state was changed
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.520 -0400", hash_original_method = "6BBB65AE1F8C0F9A0552DC908B4D29C9", hash_generated_method = "6BBB65AE1F8C0F9A0552DC908B4D29C9")
    
boolean setVisibleInt(boolean shown) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        return oldFlags != mFlags;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.522 -0400", hash_original_method = "C575291A3325EE507AB9F55E92185E54", hash_generated_method = "B03B8C1B6E5110359A12053C6CBC91AD")
    
@Override
    public MenuItem setVisible(boolean shown) {
        // Try to set the shown state to the given state. If the shown state was changed
        // (i.e. the previous state isn't the same as given state), notify the parent menu that
        // the shown state has changed for this item
        if (setVisibleInt(shown)) mMenu.onItemVisibleChanged(this);

        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.524 -0400", hash_original_method = "1DDD55F9AC5A73432BCD73A94619FD45", hash_generated_method = "644DD3B1983CE856F55086F118B50B0B")
    
@Override
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        mClickListener = clickListener;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.526 -0400", hash_original_method = "233A3AFEB21203525FBA5B1CF441183E", hash_generated_method = "692A02ACADED5DD1B44A703CD8F1A6B2")
    
@Override
    public String toString() {
        return mTitle.toString();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.529 -0400", hash_original_method = "B6421912A15ECCB29CB28DC744FEB4DF", hash_generated_method = "B6421912A15ECCB29CB28DC744FEB4DF")
    
void setMenuInfo(ContextMenuInfo menuInfo) {
        mMenuInfo = menuInfo;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.531 -0400", hash_original_method = "A0E326FAE2703231717DF34591A2C639", hash_generated_method = "FA59671CADA14EA17380226A9F795CD4")
    
@Override
    public ContextMenuInfo getMenuInfo() {
        return mMenuInfo;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.534 -0400", hash_original_method = "221F1892BBAF0D6C0448BF9B80F29C7C", hash_generated_method = "DA9815F92346138FA502DA77B7085744")
    
public void actionFormatChanged() {
        mMenu.onItemActionRequestChanged(this);
    }

    /**
     * @return Whether the menu should show icons for menu items.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.536 -0400", hash_original_method = "B7358CCF217D02273B220AA1E4900E11", hash_generated_method = "1350EC7C09EBE34E79AE23ECFE5BD0CA")
    
public boolean shouldShowIcon() {
        return mMenu.getOptionalIconsVisible();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.538 -0400", hash_original_method = "8639B741C99124BF9C4FC28DBCA735D7", hash_generated_method = "EE8FFCBB2F111D3D9AE0BE12E04A8290")
    
public boolean isActionButton() {
        return (mFlags & IS_ACTION) == IS_ACTION;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.540 -0400", hash_original_method = "D20AA9738309FEFC21F93C6653D8A4BB", hash_generated_method = "81528B979D943264481E4DD8006DCAFC")
    
public boolean requestsActionButton() {
        return (mShowAsAction & SHOW_AS_ACTION_IF_ROOM) == SHOW_AS_ACTION_IF_ROOM;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.542 -0400", hash_original_method = "A0218090F414AFC2516DB1AFD001E557", hash_generated_method = "4A494F37BA03D3E800DE418D63DEDA90")
    
public boolean requiresActionButton() {
        return (mShowAsAction & SHOW_AS_ACTION_ALWAYS) == SHOW_AS_ACTION_ALWAYS;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.545 -0400", hash_original_method = "7A64484A152776341109FA7C71AB82BB", hash_generated_method = "5825456ADEC17EC32E0F1F559D5A7900")
    
public void setIsActionButton(boolean isActionButton) {
        if (isActionButton) {
            mFlags |= IS_ACTION;
        } else {
            mFlags &= ~IS_ACTION;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.547 -0400", hash_original_method = "D19EFCF4D4C49A6F9A7B8D6E601DFE3B", hash_generated_method = "52E20321AA1B567FEE364BC07ABCA6D8")
    
public boolean showsTextAsAction() {
        return (mShowAsAction & SHOW_AS_ACTION_WITH_TEXT) == SHOW_AS_ACTION_WITH_TEXT;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.549 -0400", hash_original_method = "6034AD3E3F15BF95CED1827A99F9830A", hash_generated_method = "61FA6312FB5E4022B402EFB670253D2A")
    
@Override
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.552 -0400", hash_original_method = "A8DDECC6D32A684A87BF24E58A6C33B6", hash_generated_method = "C9C025ED7E6545FC0B9DCDE20B68C96C")
    
@Override
    public SupportMenuItem setActionView(View view) {
        mActionView = view;
        mActionProvider = null;
        if (view != null && view.getId() == View.NO_ID && mId > 0) {
            view.setId(mId);
        }
        mMenu.onItemActionRequestChanged(this);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.555 -0400", hash_original_method = "3EABEB2C29BAEC5C0316A3561D10BB1F", hash_generated_method = "8BA141628F04DDEC72D45EDAA52FBFA1")
    
@Override
    public SupportMenuItem setActionView(int resId) {
        final Context context = mMenu.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.557 -0400", hash_original_method = "FE0883E0103E024379E3F5150B384F6C", hash_generated_method = "1242904D221DAEC81A605673CDCBCF68")
    
@Override
    public View getActionView() {
        if (mActionView != null) {
            return mActionView;
        } else if (mActionProvider != null) {
            mActionView = mActionProvider.onCreateActionView(this);
            return mActionView;
        } else {
            return null;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.560 -0400", hash_original_method = "03E55DE6531DE3C932E1B956D7AA69DC", hash_generated_method = "1A963A49359B17BDDAF785170612CBEA")
    
@Override
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException(
                "Implementation should use setSupportActionProvider!");
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.563 -0400", hash_original_method = "589F49869825A0F07FE6AA71C744CDAC", hash_generated_method = "D572526DCBC1A7C94978A789876D79EC")
    
@Override
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException(
                "Implementation should use getSupportActionProvider!");
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.566 -0400", hash_original_method = "FFF566010C3964783833EFB6BDB0AF2A", hash_generated_method = "60A48C2929B343ECE271B42FDB19C33F")
    
@Override
    public ActionProvider getSupportActionProvider() {
        return mActionProvider;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.571 -0400", hash_original_method = "F48505AE1E8843739A25A3BDF46619C6", hash_generated_method = "673B8917D5D7ECFCD07CDE909B35CC60")
    
@Override
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (mActionProvider == actionProvider) {
            return this;
        }

        mActionView = null;
        if (mActionProvider != null) {
            mActionProvider.setVisibilityListener(null);
        }
        mActionProvider = actionProvider;
        mMenu.onItemsChanged(true); // Measurement can be changed
        if (actionProvider != null) {
            actionProvider.setVisibilityListener(new ActionProvider.VisibilityListener() {
                @DSSafe(DSCat.SAFE_LIST)
        @Override
                public void onActionProviderVisibilityChanged(boolean isVisible) {
                    mMenu.onItemVisibleChanged(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.574 -0400", hash_original_method = "3398CED1854459D9FDF9286F9129F1C2", hash_generated_method = "9805991145FD68D7A27BC8455902404E")
    
@Override
    public SupportMenuItem setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.577 -0400", hash_original_method = "9242B1434B9CD0ACB88D22E492AB3A81", hash_generated_method = "785DF27EB9DB09B43BE88FA740E40BF8")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.579 -0400", hash_original_method = "DB0EB37C3626C85F2C23377923AB6063", hash_generated_method = "D3E84239EA5F45561CF06CF4B2CC2EAA")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.582 -0400", hash_original_method = "84BF3EF5AE6F231153F5FCC01ED19C15", hash_generated_method = "8E314BBBCA051C709592416949F7F865")
    
@Override
    public SupportMenuItem setSupportOnActionExpandListener(
            MenuItemCompat.OnActionExpandListener listener) {
        mOnActionExpandListener = listener;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.584 -0400", hash_original_method = "DAFC43ECD0E5D06566AA28ACE3B5E472", hash_generated_method = "DDDD51374CDE73A14FCDB2326D0AC600")
    
public boolean hasCollapsibleActionView() {
        return (mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) != 0 && mActionView != null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.586 -0400", hash_original_method = "A7B0C8C0A6B0446C22F6521CC0C60064", hash_generated_method = "24E928E7E2E1A6934EF8BCFFCA950B7D")
    
public void setActionViewExpanded(boolean isExpanded) {
        mIsActionViewExpanded = isExpanded;
        mMenu.onItemsChanged(false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.588 -0400", hash_original_method = "618A94DE2810D1D688B3A7F878D1125A", hash_generated_method = "37D869C9368926C9686D72B3BA9E8C34")
    
@Override
    public boolean isActionViewExpanded() {
        return mIsActionViewExpanded;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:39.591 -0400", hash_original_method = "DC0F0EC71E886262AD49BDC74EBBBC1D", hash_generated_method = "42740EB7D7899A34BA741DECB5C04C18")
    
@Override
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        throw new UnsupportedOperationException(
                "Implementation should use setSupportOnActionExpandListener!");
    }
}
