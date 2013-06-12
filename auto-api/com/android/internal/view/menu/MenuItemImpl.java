package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = "MenuItemImpl";
    private static final int SHOW_AS_ACTION_MASK = SHOW_AS_ACTION_NEVER |
            SHOW_AS_ACTION_IF_ROOM |
            SHOW_AS_ACTION_ALWAYS;
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
    private MenuBuilder mMenu;
    private SubMenuBuilder mSubMenu;
    private Runnable mItemCallback;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private int mFlags = ENABLED;
    private static final int CHECKABLE      = 0x00000001;
    private static final int CHECKED        = 0x00000002;
    private static final int EXCLUSIVE      = 0x00000004;
    private static final int HIDDEN         = 0x00000008;
    private static final int ENABLED        = 0x00000010;
    private static final int IS_ACTION      = 0x00000020;
    private int mShowAsAction = SHOW_AS_ACTION_NEVER;
    private View mActionView;
    private ActionProvider mActionProvider;
    private OnActionExpandListener mOnActionExpandListener;
    private boolean mIsActionViewExpanded = false;
    static final int NO_ICON = 0;
    private ContextMenuInfo mMenuInfo;
    private static String sPrependShortcutLabel;
    private static String sEnterShortcutLabel;
    private static String sDeleteShortcutLabel;
    private static String sSpaceShortcutLabel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.094 -0400", hash_original_method = "64F6A72F78EB0039947A0530C3919D96", hash_generated_method = "D790CED62CFD672B0FE8EE85DBD3DAAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     MenuItemImpl(MenuBuilder menu, int group, int id, int categoryOrder, int ordering,
            CharSequence title, int showAsAction) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(showAsAction);
        dsTaint.addTaint(title);
        dsTaint.addTaint(categoryOrder);
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(ordering);
        dsTaint.addTaint(group);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "DCB176B376623FC7561DCD073EB66D0A", hash_generated_method = "C4995D654B488CC6557A7C1D51AFFC5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean invoke() {
        {
            boolean var88913A92E58559334515FB7FBA94C39B_687417280 = (mClickListener != null &&
            mClickListener.onMenuItemClick(this));
        } //End collapsed parenthetic
        {
            boolean varFE751BCD088421286FAC3C070DC91E76_464095664 = (mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this));
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
            boolean varB61D100D9A52D650CE9068160A94F50D_491351032 = (mActionProvider != null && mActionProvider.onPerformDefaultAction());
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "E32CA29A0BC5585D61D4BBFAF71A27EB")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "D7CDC1A4A52E7AA2B30AF0AEE42BB489", hash_generated_method = "6082D6A224353E2FF93B51CF0B4DACEE")
    @DSModeled(DSC.SAFE)
    public MenuItem setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            mFlags |= ENABLED;
        } //End block
        {
            mFlags &= ~ENABLED;
        } //End block
        mMenu.onItemsChanged(false);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (enabled) {
            //mFlags |= ENABLED;
        //} else {
            //mFlags &= ~ENABLED;
        //}
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "E063D9C68E88EF71230BC9BD0243E414")
    @DSModeled(DSC.SAFE)
    public int getGroupId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "DAEFE846B41B5087878A3AAFF744F241")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "C3905BED22935FA2186A402E1BBD1829", hash_generated_method = "174375E369E745378A62FF5A6D3B0242")
    @DSModeled(DSC.SAFE)
    public int getOrder() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCategoryOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "92E8F82AA50FD1AD58335B2DC7895A83", hash_generated_method = "8CB2CC02FDB7B25486829C4D876AB0D5")
    @DSModeled(DSC.SAFE)
    public int getOrdering() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "0171D0DC4EAD6361737CA1E97CC20C8A")
    @DSModeled(DSC.SPEC)
    public Intent getIntent() {
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "67A8F58500F639E3C2BA2AF25177D226")
    @DSModeled(DSC.SPEC)
    public MenuItem setIntent(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "C32C9CAC3047604A3F615D0E2B0A3D92", hash_generated_method = "8C594E3C976B6B91346EED5A52CC21D4")
    @DSModeled(DSC.SAFE)
     Runnable getCallback() {
        return (Runnable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItemCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "CAD9375B57D68888676D597787CB9AA1", hash_generated_method = "BE248BF3593F3F83FE637707D3A6BF92")
    @DSModeled(DSC.SAFE)
    public MenuItem setCallback(Runnable callback) {
        dsTaint.addTaint(callback.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mItemCallback = callback;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "CCF1DD0A2E8362AA5D0888505330AF45")
    @DSModeled(DSC.SAFE)
    public char getAlphabeticShortcut() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "88D9907A20D6B14742A0B31CE890DEE4", hash_generated_method = "A93DA8AB53C5D7273E6F0A563C9A3655")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        dsTaint.addTaint(alphaChar);
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        mMenu.onItemsChanged(false);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mShortcutAlphabeticChar == alphaChar) return this;
        //mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "62A686696B6AFEEF4B85985129BACD03")
    @DSModeled(DSC.SAFE)
    public char getNumericShortcut() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.095 -0400", hash_original_method = "C979D44A5E5C9CB1A686CC5CF090F436", hash_generated_method = "DF8A53F983A8E649D5D84830B73D9600")
    @DSModeled(DSC.SAFE)
    public MenuItem setNumericShortcut(char numericChar) {
        dsTaint.addTaint(numericChar);
        mMenu.onItemsChanged(false);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mShortcutNumericChar == numericChar) return this;
        //mShortcutNumericChar = numericChar;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "0C4A5B3F8F292031B8A33F43134542C3", hash_generated_method = "2105F7DB7735AEC944E8ABA19DE7DD7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        dsTaint.addTaint(numericChar);
        dsTaint.addTaint(alphaChar);
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        mMenu.onItemsChanged(false);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "D96803BF052A5945B7D152CA36FE6B7E", hash_generated_method = "CE024C5B0C879797EA133AF8E9AC1659")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     char getShortcut() {
        char var657EE3268E63EFD9A824FD06F69F72DE_1381695007 = ((mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return (mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "BC454AC179D3698A29B0357FA131C3B2", hash_generated_method = "283EE680B5AF4AABF3F1BAABAF835AEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getShortcutLabel() {
        char shortcut;
        shortcut = getShortcut();
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
        String var806458D832AB974D230FEE4CBBDBD390_1516221475 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "10F1B2AEF5DA21C52B4C4E0F70D42C6B", hash_generated_method = "38E5A9B7AE4670F3148E8DD87E85C399")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean shouldShowShortcut() {
        boolean varE0C4140F2C4952AC2F09D9F0558D1D66_1330780398 = (mMenu.isShortcutsVisible() && (getShortcut() != 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mMenu.isShortcutsVisible() && (getShortcut() != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "4569B511D747F82913D0DE9D1EF62E55", hash_generated_method = "F3002149C184A736D3D5EA92CA29D7E4")
    @DSModeled(DSC.SAFE)
    public SubMenu getSubMenu() {
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSubMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "4556386DBA75360C55B0D4465EB5905E", hash_generated_method = "9BBB09F8D385D044F846ECAA95D9B435")
    @DSModeled(DSC.SAFE)
    public boolean hasSubMenu() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSubMenu != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "84077AC2D714BDDE1A3A80B85CC9BFB0", hash_generated_method = "F41F355A507676E452CFF3B13FEB1666")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setSubMenu(SubMenuBuilder subMenu) {
        dsTaint.addTaint(subMenu.dsTaint);
        subMenu.setHeaderTitle(getTitle());
        // ---------- Original Method ----------
        //mSubMenu = subMenu;
        //subMenu.setHeaderTitle(getTitle());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "0A6BE5D0D35FD6215D2B10A924F4FC85")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "6C0965535A50DC1B1EFB814EBEDF6248", hash_generated_method = "40E13FF9F330D01A07E1A7ACA13A0AE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        dsTaint.addTaint(itemView.dsTaint);
        {
            boolean varA4D68830F744C4DC311F6DB8FD325B22_1800986462 = (((itemView != null) && itemView.prefersCondensedTitle()));
            Object varAED2D6883DC1A87E28E84F4535154BE8_2058722725 = (getTitleCondensed());
            Object var2C2BE257D2C558DB946931AF1162AD92_835626112 = (getTitle());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ((itemView != null) && itemView.prefersCondensedTitle())
                //? getTitleCondensed()
                //: getTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "1E48645B8578DDF9EFFB5676592C549A", hash_generated_method = "AA64725C55D9CA17E1293D9750E39772")
    @DSModeled(DSC.SAFE)
    public MenuItem setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        mMenu.onItemsChanged(false);
        {
            mSubMenu.setHeaderTitle(title);
        } //End block
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mTitle = title;
        //mMenu.onItemsChanged(false);
        //if (mSubMenu != null) {
            //mSubMenu.setHeaderTitle(title);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "504EB589769814F693A853F99C8002C5", hash_generated_method = "A92CFF511573E34A13D93DA12DCA444A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setTitle(int title) {
        dsTaint.addTaint(title);
        MenuItem var6F47C6284B902D378BD928420C2A1C93_2027474445 = (setTitle(mMenu.getContext().getString(title)));
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return setTitle(mMenu.getContext().getString(title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "2F32534D1148FE277B46E47FA445D759", hash_generated_method = "52B9C992C49A073D662D724167D9FDB0")
    @DSModeled(DSC.SAFE)
    public CharSequence getTitleCondensed() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitleCondensed != null ? mTitleCondensed : mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "A10897990E671CAED83F82CF9B7ADDEE", hash_generated_method = "0D7ABBC42CFB9DD4695E3328F273507C")
    @DSModeled(DSC.SAFE)
    public MenuItem setTitleCondensed(CharSequence title) {
        dsTaint.addTaint(title);
        {
            title = mTitle;
        } //End block
        mMenu.onItemsChanged(false);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //if (title == null) {
            //title = mTitle;
        //}
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.096 -0400", hash_original_method = "77C51DB63A44599458883D3753A34CC1", hash_generated_method = "FC0BBD5FCCB156DD2825F73D0AEE54FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getIcon() {
        {
            Drawable var28BD42A9C075D44A93318B34E420FA3E_984328237 = (mMenu.getResources().getDrawable(mIconResId));
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mIconDrawable != null) {
            //return mIconDrawable;
        //}
        //if (mIconResId != NO_ICON) {
            //return mMenu.getResources().getDrawable(mIconResId);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "BD8BE6A7204F93A97A4B1462396F9006", hash_generated_method = "65FFB9A165806E73D4A90F7968C1F14F")
    @DSModeled(DSC.SAFE)
    public MenuItem setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        mIconResId = NO_ICON;
        mMenu.onItemsChanged(false);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mIconResId = NO_ICON;
        //mIconDrawable = icon;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "6CA4716E877DA09BBA89FF884DD9F3E1", hash_generated_method = "C97A2BB82DA48F3A207205739FC403BB")
    @DSModeled(DSC.SAFE)
    public MenuItem setIcon(int iconResId) {
        dsTaint.addTaint(iconResId);
        mIconDrawable = null;
        mMenu.onItemsChanged(false);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mIconDrawable = null;
        //mIconResId = iconResId;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "03294EC000E2E3A998710BD4D5DBC105", hash_generated_method = "810C7C15F549B2155ED2E4E212EDBFC3")
    @DSModeled(DSC.SAFE)
    public boolean isCheckable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) == CHECKABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "97D03B8420DC0405BDED5AEBB6194B4D", hash_generated_method = "033FC4FDB2EF60E98C90DDF3C1EDAAD5")
    @DSModeled(DSC.SAFE)
    public MenuItem setCheckable(boolean checkable) {
        dsTaint.addTaint(checkable);
        final int oldFlags;
        oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        {
            mMenu.onItemsChanged(false);
        } //End block
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //if (oldFlags != mFlags) {
            //mMenu.onItemsChanged(false);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "D48B0A4B4830ACC112B29145FA304FB9", hash_generated_method = "DD2FFC7FFC7F9AD2765AE9CC8D14AE64")
    @DSModeled(DSC.SAFE)
    public void setExclusiveCheckable(boolean exclusive) {
        dsTaint.addTaint(exclusive);
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "09CA122F8C23D0DDA91200023A557A5D", hash_generated_method = "EAB893D13041C6D9B24CDA33B0764959")
    @DSModeled(DSC.SAFE)
    public boolean isExclusiveCheckable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & EXCLUSIVE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "153A3CA3675B13C11B20504065FC3BF7", hash_generated_method = "50A9D62265A7297A8220434469ABB3B3")
    @DSModeled(DSC.SAFE)
    public boolean isChecked() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) == CHECKED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "9107E25FB1CB75DAB92AC94A4D8833A7", hash_generated_method = "084FA746CE77D412A9263D110294E7C0")
    @DSModeled(DSC.SAFE)
    public MenuItem setChecked(boolean checked) {
        dsTaint.addTaint(checked);
        {
            mMenu.setExclusiveItemChecked(this);
        } //End block
        {
            setCheckedInt(checked);
        } //End block
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ((mFlags & EXCLUSIVE) != 0) {
            //mMenu.setExclusiveItemChecked(this);
        //} else {
            //setCheckedInt(checked);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "F4E3FA5EA691BD61029F7B342451D96B", hash_generated_method = "8AE72CEB486FA870427FD9316F4F7F93")
    @DSModeled(DSC.SAFE)
     void setCheckedInt(boolean checked) {
        dsTaint.addTaint(checked);
        final int oldFlags;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "9435EE6BB8E414380D267B05FC5BB087")
    @DSModeled(DSC.SAFE)
    public boolean isVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "6BBB65AE1F8C0F9A0552DC908B4D29C9", hash_generated_method = "CAB5B086AAA77C38E4148E2DA1A6BFF7")
    @DSModeled(DSC.SAFE)
     boolean setVisibleInt(boolean shown) {
        dsTaint.addTaint(shown);
        final int oldFlags;
        oldFlags = mFlags;
        mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        //return oldFlags != mFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "C575291A3325EE507AB9F55E92185E54", hash_generated_method = "AE9D2E0E4FCCBB6F771A5B4C0F86933E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setVisible(boolean shown) {
        dsTaint.addTaint(shown);
        {
            boolean var888A88BADDB15852039C5C93445B7B9E_472775516 = (setVisibleInt(shown));
            mMenu.onItemVisibleChanged(this);
        } //End collapsed parenthetic
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (setVisibleInt(shown)) mMenu.onItemVisibleChanged(this);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "1DDD55F9AC5A73432BCD73A94619FD45", hash_generated_method = "6806C6AAC6CEB6F4ED7E1E31BBD73895")
    @DSModeled(DSC.SAFE)
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        dsTaint.addTaint(clickListener.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mClickListener = clickListener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.097 -0400", hash_original_method = "233A3AFEB21203525FBA5B1CF441183E", hash_generated_method = "6311879492B97CA4C32A87887BC74AEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varC6496DC86907F8C671345E69EEAD3B22_694758006 = (mTitle.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "B6421912A15ECCB29CB28DC744FEB4DF", hash_generated_method = "2B5C0F4A4E809538364D9AEAD01B7653")
    @DSModeled(DSC.SAFE)
     void setMenuInfo(ContextMenuInfo menuInfo) {
        dsTaint.addTaint(menuInfo.dsTaint);
        // ---------- Original Method ----------
        //mMenuInfo = menuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "A0E326FAE2703231717DF34591A2C639", hash_generated_method = "F0F386FC83B23B8751C3C2A739DF6264")
    @DSModeled(DSC.SAFE)
    public ContextMenuInfo getMenuInfo() {
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMenuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "221F1892BBAF0D6C0448BF9B80F29C7C", hash_generated_method = "F3067B7E53D7355576D6424B0A7CA8FA")
    @DSModeled(DSC.SAFE)
    public void actionFormatChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mMenu.onItemActionRequestChanged(this);
        // ---------- Original Method ----------
        //mMenu.onItemActionRequestChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "B7358CCF217D02273B220AA1E4900E11", hash_generated_method = "0FDEF2AF7FF243C79BD752643AD74A7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean shouldShowIcon() {
        boolean var70F98333FA0948733960A5795635FA78_597957643 = (mMenu.getOptionalIconsVisible());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mMenu.getOptionalIconsVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "8639B741C99124BF9C4FC28DBCA735D7", hash_generated_method = "EE81FFD07CD65096809ACEAB5099867A")
    @DSModeled(DSC.SAFE)
    public boolean isActionButton() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & IS_ACTION) == IS_ACTION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "D20AA9738309FEFC21F93C6653D8A4BB", hash_generated_method = "BC25F9CF5262D04756D9095D3E03CAFD")
    @DSModeled(DSC.SAFE)
    public boolean requestsActionButton() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_IF_ROOM) == SHOW_AS_ACTION_IF_ROOM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "A0218090F414AFC2516DB1AFD001E557", hash_generated_method = "A98A3EE7FE4827FEDCBCB76708F5FFBF")
    @DSModeled(DSC.SAFE)
    public boolean requiresActionButton() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_ALWAYS) == SHOW_AS_ACTION_ALWAYS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "7A64484A152776341109FA7C71AB82BB", hash_generated_method = "B801021772A4928C7F34078173493111")
    @DSModeled(DSC.SAFE)
    public void setIsActionButton(boolean isActionButton) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(isActionButton);
        {
            mFlags |= IS_ACTION;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "D19EFCF4D4C49A6F9A7B8D6E601DFE3B", hash_generated_method = "53334C1ACEF4C8EEC82D521CE7738852")
    @DSModeled(DSC.SAFE)
    public boolean showsTextAsAction() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_WITH_TEXT) == SHOW_AS_ACTION_WITH_TEXT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "6034AD3E3F15BF95CED1827A99F9830A", hash_generated_method = "49C50494F174584E04493C42EFD061CB")
    @DSModeled(DSC.SAFE)
    public void setShowAsAction(int actionEnum) {
        dsTaint.addTaint(actionEnum);
        //Begin case default 
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM,"
                        + " and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        //End case default 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "9511E068798AA5E04A674F02DC2F7567", hash_generated_method = "16D42ABA3D216B3D9F72F60559404B5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setActionView(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(view.dsTaint);
        mActionProvider = null;
        {
            boolean var9383E447CCD31AC0A55E5ECF75C1C296_146304490 = (view != null && view.getId() == View.NO_ID && mId > 0);
            {
                view.setId(mId);
            } //End block
        } //End collapsed parenthetic
        mMenu.onItemActionRequestChanged(this);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mActionView = view;
        //mActionProvider = null;
        //if (view != null && view.getId() == View.NO_ID && mId > 0) {
            //view.setId(mId);
        //}
        //mMenu.onItemActionRequestChanged(this);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "B057E2C488C14BC05DF25DD2F229F8B2", hash_generated_method = "E978A163DC3C030832A08FC78F769E5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setActionView(int resId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(resId);
        final Context context;
        context = mMenu.getContext();
        final LayoutInflater inflater;
        inflater = LayoutInflater.from(context);
        setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Context context = mMenu.getContext();
        //final LayoutInflater inflater = LayoutInflater.from(context);
        //setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "404D78F2C7005B21FAAA5C37E608175C", hash_generated_method = "D24A0210AB9F16EEF94E13098A6D0DB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mActionView = mActionProvider.onCreateActionView();
        } //End block
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "F6993BB94930E20BEF3D6DE6883E2D9B", hash_generated_method = "1AB75C3438AB0F37AB93E5250356CD96")
    @DSModeled(DSC.SAFE)
    public ActionProvider getActionProvider() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (ActionProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActionProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.098 -0400", hash_original_method = "C59B6F24EC844FBD609E594809339FFA", hash_generated_method = "048E363F425A1C29E10CC2C1A81DD5FF")
    @DSModeled(DSC.SAFE)
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(actionProvider.dsTaint);
        mActionView = null;
        mMenu.onItemsChanged(true);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mActionView = null;
        //mActionProvider = actionProvider;
        //mMenu.onItemsChanged(true);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.099 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "EEB15F587C0FE2E1E93B850E6867D250")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.099 -0400", hash_original_method = "9242B1434B9CD0ACB88D22E492AB3A81", hash_generated_method = "83571773E9798E7F01362E98C7A72872")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean expandActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var81D84D08096DF9E1FCCD4F85A3884372_1096590574 = (mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionExpand(this));
            {
                boolean var38AC753AE765E96CBE659CBBA5A8A723_347740598 = (mMenu.expandItemActionView(this));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.099 -0400", hash_original_method = "DB0EB37C3626C85F2C23377923AB6063", hash_generated_method = "5A49526795ED2F8223CCE4EB30C960CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean collapseActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varA0F65C9905152D79B43E3C0EEE82344B_40070713 = (mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionCollapse(this));
            {
                boolean var690A803F41D0DAB576A6FB2B9FAC7EC4_1670021602 = (mMenu.collapseItemActionView(this));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.099 -0400", hash_original_method = "B1FCAF7D5B88EED4E84E6E84EBEC9EE4", hash_generated_method = "5BFBAAC33C5A72613A5B04B769C44F68")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(listener.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mOnActionExpandListener = listener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.099 -0400", hash_original_method = "DAFC43ECD0E5D06566AA28ACE3B5E472", hash_generated_method = "708EBEABEBAF625403C6930666E75447")
    @DSModeled(DSC.SAFE)
    public boolean hasCollapsibleActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) != 0 && mActionView != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.099 -0400", hash_original_method = "A7B0C8C0A6B0446C22F6521CC0C60064", hash_generated_method = "5AE4A806603888D8549C1AAE2FAA654F")
    @DSModeled(DSC.SAFE)
    public void setActionViewExpanded(boolean isExpanded) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(isExpanded);
        mMenu.onItemsChanged(false);
        // ---------- Original Method ----------
        //mIsActionViewExpanded = isExpanded;
        //mMenu.onItemsChanged(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.099 -0400", hash_original_method = "618A94DE2810D1D688B3A7F878D1125A", hash_generated_method = "406D0EF758FF41453345F238FA67E23D")
    @DSModeled(DSC.SAFE)
    public boolean isActionViewExpanded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsActionViewExpanded;
    }

    
}


