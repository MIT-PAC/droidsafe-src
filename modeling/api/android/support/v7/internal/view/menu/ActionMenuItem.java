/*
 * Copyright (C) 2010 The Android Open Source Project
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
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/**
 * @hide
 */
public class ActionMenuItem implements SupportMenuItem {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.868 -0400", hash_original_field = "85EA99D3EE3FBF5630E4D962E96A8E74", hash_generated_field = "D79E3C9C1DA0C971841E3A3F777DEEAC")

    private static final int NO_ICON = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.873 -0400", hash_original_field = "90654049052F718180E995FFF6612EFC", hash_generated_field = "943315568AC97A95BEE7FD4A533D08C8")

    private static final int CHECKABLE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.877 -0400", hash_original_field = "DDAF50494EDE92B5A907F7788646DD1D", hash_generated_field = "79E18373E7678760190793C5FAA4E940")

    private static final int CHECKED = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.880 -0400", hash_original_field = "3133F3AB867F08EB7F5C188557ADF8DE", hash_generated_field = "80F27CAAB6801F818B589E02F88FCA4D")

    private static final int EXCLUSIVE = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.883 -0400", hash_original_field = "D1A8B498453E3580610DDDDF65EDF69E", hash_generated_field = "14D725A9241DDEAEF12149E98726A5C2")

    private static final int HIDDEN = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.886 -0400", hash_original_field = "9E28E33B02832F7297D3046B6A7FB712", hash_generated_field = "9D7A6896B452AD15AEC725047E2938A0")

    private static final int ENABLED = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.825 -0400", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private  int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.829 -0400", hash_original_field = "9C43571C45B8BC34B7C8A06B2271F04A", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private  int mGroup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.831 -0400", hash_original_field = "F6DD8D04E6975C66628782A471D540ED", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private  int mCategoryOrder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.834 -0400", hash_original_field = "3D9DE4CD049B86E1600012D5AF1467A8", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private  int mOrdering;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.838 -0400", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.841 -0400", hash_original_field = "FA3171B1888A35931DDF94EF6B72DFBA", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.844 -0400", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.847 -0400", hash_original_field = "48B12B8F5B9FDB1D830B92E86520B6F6", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.850 -0400", hash_original_field = "4416434619B59B48D8ADBB443F744028", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.853 -0400", hash_original_field = "E7758D8423F0CD19BF50F0B56DC871A4", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.857 -0400", hash_original_field = "90FECF5DA6E08407086BFE725E64094A", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.860 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.865 -0400", hash_original_field = "824951867F9D04F82A57AB05007E48C8", hash_generated_field = "3EA27FC031A87D971F00BEBBF2171166")

    private SupportMenuItem.OnMenuItemClickListener mClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.870 -0400", hash_original_field = "87B4121714640703C04C2D7C1C71B5DF", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.891 -0400", hash_original_method = "ABBA9423D74CB077EE46D2E3EFD8A9A3", hash_generated_method = "F14EB0A2E6AFE443C272F5F67E6F72D0")
    
public ActionMenuItem(Context context, int group, int id, int categoryOrder, int ordering,
            CharSequence title) {
        mContext = context;
        mId = id;
        mGroup = group;
        mCategoryOrder = categoryOrder;
        mOrdering = ordering;
        mTitle = title;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.894 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "C6CC3463628F299A61B99559C4F6FF3E")
    
public char getAlphabeticShortcut() {
        return mShortcutAlphabeticChar;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.897 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "92A3BA6D09A85A547821EFB39597530D")
    
public int getGroupId() {
        return mGroup;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.899 -0400", hash_original_method = "E45C59E22635FD55A8824D390FC98A96", hash_generated_method = "1C89A96420FD278FBEA6A239DD23BEEC")
    
public Drawable getIcon() {
        return mIconDrawable;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.902 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "7CE6D2E5920E17BB1B744A5090D635BC")
    
public Intent getIntent() {
        return mIntent;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.905 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "DA81E2FAC9BA8C312C462D283E81A734")
    
public int getItemId() {
        return mId;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.909 -0400", hash_original_method = "D505DD9DA217AD48C3FB7728B16EAF3B", hash_generated_method = "1F7584093424AA16137441E5ACE98B7D")
    
public ContextMenuInfo getMenuInfo() {
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.912 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "C2D13B8EBB073B93C575296CDD9268AC")
    
public char getNumericShortcut() {
        return mShortcutNumericChar;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.915 -0400", hash_original_method = "FF535D1B11FC0F0766CD26B9FF10F186", hash_generated_method = "441C827BEB7449A539BA6B3998C1E0A3")
    
public int getOrder() {
        return mOrdering;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.918 -0400", hash_original_method = "772A0AA7AD2F04B178AEEA64C07E8BF0", hash_generated_method = "C4E8D2D80C36F19E3FBB84A9617BE54E")
    
public SubMenu getSubMenu() {
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.921 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "E948C46F1704FC1F24545ED5A725BEE6")
    
public CharSequence getTitle() {
        return mTitle;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.924 -0400", hash_original_method = "AE18A80D188B13895AC76378DAF3976F", hash_generated_method = "233DD3341101EB181D148A2A944FE56F")
    
public CharSequence getTitleCondensed() {
        return mTitleCondensed;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.927 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "C47A8DBA8C06C24113E67B7BE29255AD")
    
public boolean hasSubMenu() {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.929 -0400", hash_original_method = "ED15661074DADD4461D34783FBB8C8E2", hash_generated_method = "4D4D2BACD9A2D4FC6EC65CDB8693BCD4")
    
public boolean isCheckable() {
        return (mFlags & CHECKABLE) != 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.932 -0400", hash_original_method = "76E21D72539001F6EF2A57161392D665", hash_generated_method = "1105175507D07D475281024C6047C785")
    
public boolean isChecked() {
        return (mFlags & CHECKED) != 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.935 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "AECBB7E5FCE868E97452BAD92DC2A2C3")
    
public boolean isEnabled() {
        return (mFlags & ENABLED) != 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.939 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "1B80F4020608615FA89A7EFC550036C6")
    
public boolean isVisible() {
        return (mFlags & HIDDEN) == 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.942 -0400", hash_original_method = "7379DA8B69266F5EBF9FDADEBDD8B3A5", hash_generated_method = "17C8DE4872FC17137E8F92A3C1778BFA")
    
public MenuItem setAlphabeticShortcut(char alphaChar) {
        mShortcutAlphabeticChar = alphaChar;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.946 -0400", hash_original_method = "00566BB0E7762EC9407CFB205264961E", hash_generated_method = "3D97996810DFC56DFAF4BE51775EC6D1")
    
public MenuItem setCheckable(boolean checkable) {
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.949 -0400", hash_original_method = "38C8FF82F2D3210CC276B1181111BFDA", hash_generated_method = "373D4BEEE4A8DC133924EB71ABDB0102")
    
public ActionMenuItem setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.951 -0400", hash_original_method = "5A966E6072519B52A8CEABF5F32ED38A", hash_generated_method = "CD6B6578F627F288A229F9FE34770672")
    
public MenuItem setChecked(boolean checked) {
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.954 -0400", hash_original_method = "3B4A922D22D692F4E29B7172DE89A0AD", hash_generated_method = "EF9FD37E4E438319825677AAA235AA07")
    
public MenuItem setEnabled(boolean enabled) {
        mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.957 -0400", hash_original_method = "F52277830906BCEFECA5EA80235FDCAB", hash_generated_method = "A3FF17C4369DAAC21F4AB9A5E2317BAE")
    
public MenuItem setIcon(Drawable icon) {
        mIconDrawable = icon;
        mIconResId = NO_ICON;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.960 -0400", hash_original_method = "5010B90C9AB4414DB888D97ADDAE2333", hash_generated_method = "57AE400D2F0B6C6EAF9E302CBF45A861")
    
public MenuItem setIcon(int iconRes) {
        mIconResId = iconRes;
        mIconDrawable = mContext.getResources().getDrawable(iconRes);
        return this;
    }

    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.963 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "FC870B7BE66B774D28C4327475BB97C9")
    
public MenuItem setIntent(Intent intent) {
        mIntent = intent;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.966 -0400", hash_original_method = "1F2FCA18D7E58148E8935254347BE744", hash_generated_method = "9A11968E5B67837A36F1855A8F2C030E")
    
public MenuItem setNumericShortcut(char numericChar) {
        mShortcutNumericChar = numericChar;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.968 -0400", hash_original_method = "6601271ADD9A6C6B3D832752A2C4336F", hash_generated_method = "894ACD498E90675E27BBC4312345266C")
    
public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        mClickListener = menuItemClickListener;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.971 -0400", hash_original_method = "656EFF8CD4994CD73006E38A783E9B74", hash_generated_method = "E46C1055E4F85E80482B5021DEEC1A7B")
    
public MenuItem setShortcut(char numericChar, char alphaChar) {
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = alphaChar;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.974 -0400", hash_original_method = "E3AEA6168BB1F22DFC2A4192F0EFD72E", hash_generated_method = "879896A60705751E89B8C9C78545FFAA")
    
public MenuItem setTitle(CharSequence title) {
        mTitle = title;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.977 -0400", hash_original_method = "93E35E6A1799E092E053E5DD222DC093", hash_generated_method = "65DB2B1B966A5B5A9E0477A63230C599")
    
public MenuItem setTitle(int title) {
        mTitle = mContext.getResources().getString(title);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.979 -0400", hash_original_method = "DC9EFDDD12206C16928994FD6B9EA83A", hash_generated_method = "9C044CBB9429962F683468D926AF511E")
    
public MenuItem setTitleCondensed(CharSequence title) {
        mTitleCondensed = title;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.982 -0400", hash_original_method = "6A802D7132DF936AE104E3A9B00DB973", hash_generated_method = "F79EF35C7116F4D80FA380FC369FA52D")
    
public MenuItem setVisible(boolean visible) {
        mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.986 -0400", hash_original_method = "AA032C02BB6C3B5A9CA83C7C80BC2006", hash_generated_method = "CB02673D8CDB17FE62F1FC3131156653")
    
public boolean invoke() {
        if (mClickListener != null && mClickListener.onMenuItemClick(this)) {
            return true;
        }

        if (mIntent != null) {
            mContext.startActivity(mIntent);
            return true;
        }

        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.991 -0400", hash_original_method = "7271F034C654DB6347336274A9D03801", hash_generated_method = "EA2228D1739DD7B5887F04EF03C3D127")
    
public void setShowAsAction(int show) {
        // Do nothing. ActionMenuItems always show as action buttons.
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.994 -0400", hash_original_method = "E8AF862257175D09B2EEFD3BB8A83280", hash_generated_method = "54A6B44547F2582CE78FFF0EE29DF216")
    
public SupportMenuItem setActionView(View actionView) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.997 -0400", hash_original_method = "DDC728D00ABE6AC1AC6555673541B67E", hash_generated_method = "079D331D6B7B4A65C7CAD1B0AC46E07F")
    
public View getActionView() {
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.000 -0400", hash_original_method = "868AB39547F7C8707D921F783D2F06D6", hash_generated_method = "9443FB04DEAC7EED23E0DF6A9F42F6EB")
    
@Override
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.003 -0400", hash_original_method = "EA67B4A3C967E1E6A30F905BE7F71C09", hash_generated_method = "8DE9007C087DDB189A99947677D0C9F5")
    
@Override
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.006 -0400", hash_original_method = "D79720C70AE4E3B9F928BB1D54D80232", hash_generated_method = "1917B661FDAFADED61DC27EAABD62ECE")
    
@Override
    public SupportMenuItem setActionView(int resId) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.009 -0400", hash_original_method = "255783F2B7AB6FE993F93043DA905125", hash_generated_method = "4023F4C021E6E75EC4DE7834C7CFBCCD")
    
@Override
    public ActionProvider getSupportActionProvider() {
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.012 -0400", hash_original_method = "352ADC875992AE87D93DAEF16322430A", hash_generated_method = "02186585BF735AB05A5F7B8703C19D9A")
    
@Override
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.016 -0400", hash_original_method = "3398CED1854459D9FDF9286F9129F1C2", hash_generated_method = "9805991145FD68D7A27BC8455902404E")
    
@Override
    public SupportMenuItem setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.019 -0400", hash_original_method = "E3EFEFBDC234312A7FEC732911F191DE", hash_generated_method = "30BA6579DC5E4995E9EAA743EA45E6A5")
    
@Override
    public boolean expandActionView() {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.021 -0400", hash_original_method = "A369693BDACA70A4B3FDAADB36135262", hash_generated_method = "2624D05CDE3897B300131D8B0F4D09D0")
    
@Override
    public boolean collapseActionView() {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.024 -0400", hash_original_method = "6EAD6F9611A0523E2504074954E6B02A", hash_generated_method = "0B58F86E07A527AC75EBC8CD68481FF2")
    
@Override
    public boolean isActionViewExpanded() {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.027 -0400", hash_original_method = "58D0AF31E8D5DEBDC94191683C59B1C2", hash_generated_method = "63D044E5F71B0381C8FE299725A3B4EC")
    
@Override
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:35.030 -0400", hash_original_method = "5D0C6AC6A426D800B6114059F3C7B7B0", hash_generated_method = "AE89A987A2B9E3669D5709FD1CE6A745")
    
@Override
    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener listener) {
        // No need to save the listener; ActionMenuItem does not support collapsing items.
        return this;
    }
}
