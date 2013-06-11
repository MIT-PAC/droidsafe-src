package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ActionMenuItem implements MenuItem {
    private final int mId;
    private final int mGroup;
    private final int mCategoryOrder;
    private final int mOrdering;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private Intent mIntent;
    private char mShortcutNumericChar;
    private char mShortcutAlphabeticChar;
    private Drawable mIconDrawable;
    private int mIconResId = NO_ICON;
    private Context mContext;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private static final int NO_ICON = 0;
    private int mFlags = ENABLED;
    private static final int CHECKABLE      = 0x00000001;
    private static final int CHECKED        = 0x00000002;
    private static final int EXCLUSIVE      = 0x00000004;
    private static final int HIDDEN         = 0x00000008;
    private static final int ENABLED        = 0x00000010;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.941 -0400", hash_original_method = "ABBA9423D74CB077EE46D2E3EFD8A9A3", hash_generated_method = "AB31EE27108865D36B8DD1863DF11F3D")
    @DSModeled(DSC.SAFE)
    public ActionMenuItem(Context context, int group, int id, int categoryOrder, int ordering,
            CharSequence title) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(title);
        dsTaint.addTaint(categoryOrder);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(ordering);
        dsTaint.addTaint(group);
        // ---------- Original Method ----------
        //mContext = context;
        //mId = id;
        //mGroup = group;
        //mCategoryOrder = categoryOrder;
        //mOrdering = ordering;
        //mTitle = title;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.941 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "CCF1DD0A2E8362AA5D0888505330AF45")
    @DSModeled(DSC.SAFE)
    public char getAlphabeticShortcut() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.941 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "E063D9C68E88EF71230BC9BD0243E414")
    @DSModeled(DSC.SAFE)
    public int getGroupId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.941 -0400", hash_original_method = "E45C59E22635FD55A8824D390FC98A96", hash_generated_method = "B31BB5884D3EC69F0A8DE2C68AE12325")
    @DSModeled(DSC.SAFE)
    public Drawable getIcon() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIconDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.941 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "0171D0DC4EAD6361737CA1E97CC20C8A")
    @DSModeled(DSC.SPEC)
    public Intent getIntent() {
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.941 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "1F1DC3E8065A24742E4BABCBBA2257A9")
    @DSModeled(DSC.SAFE)
    public int getItemId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.941 -0400", hash_original_method = "D505DD9DA217AD48C3FB7728B16EAF3B", hash_generated_method = "A7734E07E014764A1C5EC96BD98617D3")
    @DSModeled(DSC.SAFE)
    public ContextMenuInfo getMenuInfo() {
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "62A686696B6AFEEF4B85985129BACD03")
    @DSModeled(DSC.SAFE)
    public char getNumericShortcut() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "FF535D1B11FC0F0766CD26B9FF10F186", hash_generated_method = "9D7BEC9C9C8ACCF62B55FCA329D46F9E")
    @DSModeled(DSC.SAFE)
    public int getOrder() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "772A0AA7AD2F04B178AEEA64C07E8BF0", hash_generated_method = "22ED18D413BDD0A1C38C5036EF70860D")
    @DSModeled(DSC.SAFE)
    public SubMenu getSubMenu() {
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "C93F883BAA39D032555C8300A9C50A39")
    @DSModeled(DSC.SAFE)
    public CharSequence getTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "AE18A80D188B13895AC76378DAF3976F", hash_generated_method = "EE767F071F1A8E0577B9FE50F1D1EAB0")
    @DSModeled(DSC.SAFE)
    public CharSequence getTitleCondensed() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitleCondensed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "1E6C2AA5B9FBCD80A65C77C0B0D662F6")
    @DSModeled(DSC.SAFE)
    public boolean hasSubMenu() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "ED15661074DADD4461D34783FBB8C8E2", hash_generated_method = "93962FD01D180AD356873314758F926F")
    @DSModeled(DSC.SAFE)
    public boolean isCheckable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "76E21D72539001F6EF2A57161392D665", hash_generated_method = "06B8876581B1E2DF5BB8100AF1E6CFD5")
    @DSModeled(DSC.SAFE)
    public boolean isChecked() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "E32CA29A0BC5585D61D4BBFAF71A27EB")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "9435EE6BB8E414380D267B05FC5BB087")
    @DSModeled(DSC.SAFE)
    public boolean isVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "7379DA8B69266F5EBF9FDADEBDD8B3A5", hash_generated_method = "CBFDBA716C9386B15897D49490EFB622")
    @DSModeled(DSC.SAFE)
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        dsTaint.addTaint(alphaChar);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "00566BB0E7762EC9407CFB205264961E", hash_generated_method = "EF532BFC3FCCC9FF2C0C092C60F5AF01")
    @DSModeled(DSC.SAFE)
    public MenuItem setCheckable(boolean checkable) {
        dsTaint.addTaint(checkable);
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "38C8FF82F2D3210CC276B1181111BFDA", hash_generated_method = "92F9E14D2A3DD438BE2BCD3F3A326F2D")
    @DSModeled(DSC.SAFE)
    public ActionMenuItem setExclusiveCheckable(boolean exclusive) {
        dsTaint.addTaint(exclusive);
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        return (ActionMenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "5A966E6072519B52A8CEABF5F32ED38A", hash_generated_method = "BA7506F1F12346D38E973E717C7A6830")
    @DSModeled(DSC.SAFE)
    public MenuItem setChecked(boolean checked) {
        dsTaint.addTaint(checked);
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "3B4A922D22D692F4E29B7172DE89A0AD", hash_generated_method = "ABFAE3B392005A158615DF9E94A5DBAB")
    @DSModeled(DSC.SAFE)
    public MenuItem setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "F52277830906BCEFECA5EA80235FDCAB", hash_generated_method = "64A08C1ABB26AF308C0C982D2D4FDDEC")
    @DSModeled(DSC.SAFE)
    public MenuItem setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        mIconResId = NO_ICON;
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mIconDrawable = icon;
        //mIconResId = NO_ICON;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "5010B90C9AB4414DB888D97ADDAE2333", hash_generated_method = "7D616C66B4C642AA6DFCD33B16546A0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setIcon(int iconRes) {
        dsTaint.addTaint(iconRes);
        mIconDrawable = mContext.getResources().getDrawable(iconRes);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mIconResId = iconRes;
        //mIconDrawable = mContext.getResources().getDrawable(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "67A8F58500F639E3C2BA2AF25177D226")
    @DSModeled(DSC.SPEC)
    public MenuItem setIntent(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.942 -0400", hash_original_method = "1F2FCA18D7E58148E8935254347BE744", hash_generated_method = "8AA3A0B71E28D1BF29A7C3F4B8FC2FB5")
    @DSModeled(DSC.SAFE)
    public MenuItem setNumericShortcut(char numericChar) {
        dsTaint.addTaint(numericChar);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "6601271ADD9A6C6B3D832752A2C4336F", hash_generated_method = "6D614E1DD4C36246E5FFEEF2549429EA")
    @DSModeled(DSC.SAFE)
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        dsTaint.addTaint(menuItemClickListener.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mClickListener = menuItemClickListener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "656EFF8CD4994CD73006E38A783E9B74", hash_generated_method = "F0993ED7519963E9653073469383E251")
    @DSModeled(DSC.SAFE)
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        dsTaint.addTaint(numericChar);
        dsTaint.addTaint(alphaChar);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "E3AEA6168BB1F22DFC2A4192F0EFD72E", hash_generated_method = "B0B754B210494C592ED5536415CDBFEF")
    @DSModeled(DSC.SAFE)
    public MenuItem setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mTitle = title;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "93E35E6A1799E092E053E5DD222DC093", hash_generated_method = "D9D7C34BB083C5F3DA71DE5C60699312")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setTitle(int title) {
        dsTaint.addTaint(title);
        mTitle = mContext.getResources().getString(title);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mTitle = mContext.getResources().getString(title);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "DC9EFDDD12206C16928994FD6B9EA83A", hash_generated_method = "6B5263772BA5248A6D955AD1B6AF67D2")
    @DSModeled(DSC.SAFE)
    public MenuItem setTitleCondensed(CharSequence title) {
        dsTaint.addTaint(title);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "6A802D7132DF936AE104E3A9B00DB973", hash_generated_method = "00AF3C5FF9E1CE5C3EECE2A51ACF0743")
    @DSModeled(DSC.SAFE)
    public MenuItem setVisible(boolean visible) {
        dsTaint.addTaint(visible);
        mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "AA032C02BB6C3B5A9CA83C7C80BC2006", hash_generated_method = "4BE6825D3DE8A174EA65F923A8A42606")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean invoke() {
        {
            boolean var891D05C799AF985A1D37CA302BA21D09_1262528629 = (mClickListener != null && mClickListener.onMenuItemClick(this));
        } //End collapsed parenthetic
        {
            mContext.startActivity(mIntent);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mClickListener != null && mClickListener.onMenuItemClick(this)) {
            //return true;
        //}
        //if (mIntent != null) {
            //mContext.startActivity(mIntent);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "7271F034C654DB6347336274A9D03801", hash_generated_method = "E74EDF1561CF9EA72CCC5D0EA6C64B55")
    @DSModeled(DSC.SAFE)
    public void setShowAsAction(int show) {
        dsTaint.addTaint(show);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "493F4A0F304908668D2BEC1F7D0E334B", hash_generated_method = "BA229F6C41ACE8500ACAA2544B4FC7EB")
    @DSModeled(DSC.SAFE)
    public MenuItem setActionView(View actionView) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(actionView.dsTaint);
        throw new UnsupportedOperationException();
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "DDC728D00ABE6AC1AC6555673541B67E", hash_generated_method = "C77D3556CA68CF23B8B6C2789AA033EC")
    @DSModeled(DSC.SAFE)
    public View getActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "38A20BA0D11F10392D85500804B1A43F", hash_generated_method = "F99AD97DC110605B7250A6B0CF4FD38E")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuItem setActionView(int resId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(resId);
        throw new UnsupportedOperationException();
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "FE44B196FF60CED75746223A767C8615", hash_generated_method = "E3E08E799FD83836B37664EAE6708169")
    @DSModeled(DSC.SAFE)
    @Override
    public ActionProvider getActionProvider() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (ActionProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "4ABFFD9ECFCE20F6052063E7AA9E942A", hash_generated_method = "BB0ED5DC5CDA67A0ABE3F59135496787")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(actionProvider.dsTaint);
        throw new UnsupportedOperationException();
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "EEB15F587C0FE2E1E93B850E6867D250")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(actionEnum);
        setShowAsAction(actionEnum);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //setShowAsAction(actionEnum);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "E3EFEFBDC234312A7FEC732911F191DE", hash_generated_method = "553CAC386E366269C8EB2AC9AA1E5FA1")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean expandActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "A369693BDACA70A4B3FDAADB36135262", hash_generated_method = "2EA18EBE518AE957663DBAF8AA5F2989")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean collapseActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "6EAD6F9611A0523E2504074954E6B02A", hash_generated_method = "530C936F187EEF5DE33F1127FB71C6A8")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isActionViewExpanded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.943 -0400", hash_original_method = "DC2EA5E6DB4BFE29B2697085EABCD856", hash_generated_method = "3A3705B18B30E9EDBCDD8258BAA0B642")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(listener.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
}


