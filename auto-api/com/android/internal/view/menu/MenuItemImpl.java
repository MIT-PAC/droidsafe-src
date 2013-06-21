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
    private int mId;
    private int mGroup;
    private int mCategoryOrder;
    private int mOrdering;
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
    private int mShowAsAction = SHOW_AS_ACTION_NEVER;
    private View mActionView;
    private ActionProvider mActionProvider;
    private OnActionExpandListener mOnActionExpandListener;
    private boolean mIsActionViewExpanded = false;
    private ContextMenuInfo mMenuInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.688 -0400", hash_original_method = "64F6A72F78EB0039947A0530C3919D96", hash_generated_method = "8AEF7E7F214C5EBC2502ADAEF570816F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     MenuItemImpl(MenuBuilder menu, int group, int id, int categoryOrder, int ordering,
            CharSequence title, int showAsAction) {
        dsTaint.addTaint(showAsAction);
        dsTaint.addTaint(id);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.690 -0400", hash_original_method = "DCB176B376623FC7561DCD073EB66D0A", hash_generated_method = "B5A58A00F684C48D732BE679E23C1E5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean invoke() {
        {
            boolean var88913A92E58559334515FB7FBA94C39B_719833312 = (mClickListener != null &&
            mClickListener.onMenuItemClick(this));
        } //End collapsed parenthetic
        {
            boolean varFE751BCD088421286FAC3C070DC91E76_282342139 = (mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this));
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
            boolean varB61D100D9A52D650CE9068160A94F50D_574078491 = (mActionProvider != null && mActionProvider.onPerformDefaultAction());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.691 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "E7FFCA7493FA630D6A1EBA84DC34A9DB")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.691 -0400", hash_original_method = "D7CDC1A4A52E7AA2B30AF0AEE42BB489", hash_generated_method = "CAF0F80E64F4D65D4DDED98E480E9A1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.691 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "E879054FEFD042D4B17928844215A6E1")
    @DSModeled(DSC.SAFE)
    public int getGroupId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.692 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "2CABBBF91E1C6E21B73C754CF0AB2847")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.692 -0400", hash_original_method = "C3905BED22935FA2186A402E1BBD1829", hash_generated_method = "5110C451F34EF7C62D25A2D67A262970")
    @DSModeled(DSC.SAFE)
    public int getOrder() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCategoryOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.692 -0400", hash_original_method = "92E8F82AA50FD1AD58335B2DC7895A83", hash_generated_method = "4BF8F3B86660A809C34148E03C829F6F")
    @DSModeled(DSC.SAFE)
    public int getOrdering() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.693 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "22770DE3BF38836C28544CA3834587CE")
    @DSModeled(DSC.SPEC)
    public Intent getIntent() {
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.693 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "4A30A418C6C4212003E8BF4506D92B34")
    @DSModeled(DSC.SPEC)
    public MenuItem setIntent(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.693 -0400", hash_original_method = "C32C9CAC3047604A3F615D0E2B0A3D92", hash_generated_method = "462869AB9804D6B086041E7CFA6F94E4")
    @DSModeled(DSC.SAFE)
     Runnable getCallback() {
        return (Runnable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItemCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.693 -0400", hash_original_method = "CAD9375B57D68888676D597787CB9AA1", hash_generated_method = "B19B30AFAE73CE0420861FD6C0F65AD4")
    @DSModeled(DSC.SAFE)
    public MenuItem setCallback(Runnable callback) {
        dsTaint.addTaint(callback.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mItemCallback = callback;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.694 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "05B79725D1238EBE991AE5FA4060A9B9")
    @DSModeled(DSC.SAFE)
    public char getAlphabeticShortcut() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.695 -0400", hash_original_method = "88D9907A20D6B14742A0B31CE890DEE4", hash_generated_method = "1AC5898071B01D69BA22F3942F1A0859")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.695 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "9844DB6DC34580EB38269876CA6DF2CF")
    @DSModeled(DSC.SAFE)
    public char getNumericShortcut() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.696 -0400", hash_original_method = "C979D44A5E5C9CB1A686CC5CF090F436", hash_generated_method = "1C84FF63833DBF02D43DE8CD7ADC338D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.696 -0400", hash_original_method = "0C4A5B3F8F292031B8A33F43134542C3", hash_generated_method = "FC24B8B9BAAAA65CC05B451FF690AB07")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.696 -0400", hash_original_method = "D96803BF052A5945B7D152CA36FE6B7E", hash_generated_method = "0659614C9EBAE8AA7A881C636D38ED48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     char getShortcut() {
        char var657EE3268E63EFD9A824FD06F69F72DE_1511495976 = ((mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return (mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.697 -0400", hash_original_method = "BC454AC179D3698A29B0357FA131C3B2", hash_generated_method = "75D336818AA39FB7EA639CA9E8C1CD31")
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
        String var806458D832AB974D230FEE4CBBDBD390_10850097 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.697 -0400", hash_original_method = "10F1B2AEF5DA21C52B4C4E0F70D42C6B", hash_generated_method = "916CF91A598D4B405482932EDD1848E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean shouldShowShortcut() {
        boolean varE0C4140F2C4952AC2F09D9F0558D1D66_1180197344 = (mMenu.isShortcutsVisible() && (getShortcut() != 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mMenu.isShortcutsVisible() && (getShortcut() != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.697 -0400", hash_original_method = "4569B511D747F82913D0DE9D1EF62E55", hash_generated_method = "CE2DD0F881ECB8BC03C188BAB6A96337")
    @DSModeled(DSC.SAFE)
    public SubMenu getSubMenu() {
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSubMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.697 -0400", hash_original_method = "4556386DBA75360C55B0D4465EB5905E", hash_generated_method = "203E5E6118020A800949EE1EE0AC22DF")
    @DSModeled(DSC.SAFE)
    public boolean hasSubMenu() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSubMenu != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.698 -0400", hash_original_method = "84077AC2D714BDDE1A3A80B85CC9BFB0", hash_generated_method = "89400A06DDBB00F955D7CB09DB74C177")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setSubMenu(SubMenuBuilder subMenu) {
        dsTaint.addTaint(subMenu.dsTaint);
        subMenu.setHeaderTitle(getTitle());
        // ---------- Original Method ----------
        //mSubMenu = subMenu;
        //subMenu.setHeaderTitle(getTitle());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.698 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "3D2FD52C3EFF13F3769111A7696CDF86")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.698 -0400", hash_original_method = "6C0965535A50DC1B1EFB814EBEDF6248", hash_generated_method = "FF89B7D460BB1FFED3583C19E6706044")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        dsTaint.addTaint(itemView.dsTaint);
        {
            boolean varA4D68830F744C4DC311F6DB8FD325B22_809268042 = (((itemView != null) && itemView.prefersCondensedTitle()));
            Object varAED2D6883DC1A87E28E84F4535154BE8_1121491961 = (getTitleCondensed());
            Object var2C2BE257D2C558DB946931AF1162AD92_1086119374 = (getTitle());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ((itemView != null) && itemView.prefersCondensedTitle())
                //? getTitleCondensed()
                //: getTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.698 -0400", hash_original_method = "1E48645B8578DDF9EFFB5676592C549A", hash_generated_method = "B12FF79A07A24B0A88726D18B3ABE924")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.699 -0400", hash_original_method = "504EB589769814F693A853F99C8002C5", hash_generated_method = "AD2FA134293BDC375B054597BC19D85E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setTitle(int title) {
        dsTaint.addTaint(title);
        MenuItem var6F47C6284B902D378BD928420C2A1C93_1940830419 = (setTitle(mMenu.getContext().getString(title)));
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return setTitle(mMenu.getContext().getString(title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.699 -0400", hash_original_method = "2F32534D1148FE277B46E47FA445D759", hash_generated_method = "D4F64B7B07B1F101B4B929D0407A7E94")
    @DSModeled(DSC.SAFE)
    public CharSequence getTitleCondensed() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitleCondensed != null ? mTitleCondensed : mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.699 -0400", hash_original_method = "A10897990E671CAED83F82CF9B7ADDEE", hash_generated_method = "D01C71D76EF26A94C5C33DCB5D28D6CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.699 -0400", hash_original_method = "77C51DB63A44599458883D3753A34CC1", hash_generated_method = "DEBEA5DD22ABC507F6A00211C4C5D7E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getIcon() {
        {
            Drawable var28BD42A9C075D44A93318B34E420FA3E_1040821780 = (mMenu.getResources().getDrawable(mIconResId));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.700 -0400", hash_original_method = "BD8BE6A7204F93A97A4B1462396F9006", hash_generated_method = "AFE5FC31083D427381653482CFFB1407")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.700 -0400", hash_original_method = "6CA4716E877DA09BBA89FF884DD9F3E1", hash_generated_method = "00E2E74F1415219FF85A014E0584DA18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.700 -0400", hash_original_method = "03294EC000E2E3A998710BD4D5DBC105", hash_generated_method = "87683E84E83812748D6FED47BAD06D9E")
    @DSModeled(DSC.SAFE)
    public boolean isCheckable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) == CHECKABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.700 -0400", hash_original_method = "97D03B8420DC0405BDED5AEBB6194B4D", hash_generated_method = "923CC391E8113DCE7AB804706EA9CF8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setCheckable(boolean checkable) {
        dsTaint.addTaint(checkable);
        int oldFlags;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.700 -0400", hash_original_method = "D48B0A4B4830ACC112B29145FA304FB9", hash_generated_method = "9E0CBF0A1AD470B4587ABB7473275373")
    @DSModeled(DSC.SAFE)
    public void setExclusiveCheckable(boolean exclusive) {
        dsTaint.addTaint(exclusive);
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.701 -0400", hash_original_method = "09CA122F8C23D0DDA91200023A557A5D", hash_generated_method = "0151A97876CF5C90B8D14075A4F5DDAA")
    @DSModeled(DSC.SAFE)
    public boolean isExclusiveCheckable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & EXCLUSIVE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.701 -0400", hash_original_method = "153A3CA3675B13C11B20504065FC3BF7", hash_generated_method = "E50EED3600A1339B58482DE901CCB963")
    @DSModeled(DSC.SAFE)
    public boolean isChecked() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) == CHECKED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.701 -0400", hash_original_method = "9107E25FB1CB75DAB92AC94A4D8833A7", hash_generated_method = "9B91339B75173770F6B24A6FA953A302")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.701 -0400", hash_original_method = "F4E3FA5EA691BD61029F7B342451D96B", hash_generated_method = "3446354E19D34FC5999EA56970751C4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setCheckedInt(boolean checked) {
        dsTaint.addTaint(checked);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.701 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "68E08BFD8E0FA8B2882DCFD0A5870F43")
    @DSModeled(DSC.SAFE)
    public boolean isVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.702 -0400", hash_original_method = "6BBB65AE1F8C0F9A0552DC908B4D29C9", hash_generated_method = "B20AE61F3DAA45A49150077B08B3787E")
    @DSModeled(DSC.SAFE)
     boolean setVisibleInt(boolean shown) {
        dsTaint.addTaint(shown);
        int oldFlags;
        oldFlags = mFlags;
        mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        //return oldFlags != mFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.702 -0400", hash_original_method = "C575291A3325EE507AB9F55E92185E54", hash_generated_method = "3356D192FAF7EA44B7244664961D409F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setVisible(boolean shown) {
        dsTaint.addTaint(shown);
        {
            boolean var888A88BADDB15852039C5C93445B7B9E_925457097 = (setVisibleInt(shown));
            mMenu.onItemVisibleChanged(this);
        } //End collapsed parenthetic
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (setVisibleInt(shown)) mMenu.onItemVisibleChanged(this);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.702 -0400", hash_original_method = "1DDD55F9AC5A73432BCD73A94619FD45", hash_generated_method = "9EDE60E600BB199796A2B7DDF908F027")
    @DSModeled(DSC.SAFE)
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        dsTaint.addTaint(clickListener.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mClickListener = clickListener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.702 -0400", hash_original_method = "233A3AFEB21203525FBA5B1CF441183E", hash_generated_method = "C10CBFBC2B8CC924FAA49E50F8CFC645")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varC6496DC86907F8C671345E69EEAD3B22_1135702620 = (mTitle.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.703 -0400", hash_original_method = "B6421912A15ECCB29CB28DC744FEB4DF", hash_generated_method = "B314049B59FBD8E75EC8D7BCA34B1A34")
    @DSModeled(DSC.SAFE)
     void setMenuInfo(ContextMenuInfo menuInfo) {
        dsTaint.addTaint(menuInfo.dsTaint);
        // ---------- Original Method ----------
        //mMenuInfo = menuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.703 -0400", hash_original_method = "A0E326FAE2703231717DF34591A2C639", hash_generated_method = "644BF60455A9A8797825A193DDE7ED3C")
    @DSModeled(DSC.SAFE)
    public ContextMenuInfo getMenuInfo() {
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMenuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.703 -0400", hash_original_method = "221F1892BBAF0D6C0448BF9B80F29C7C", hash_generated_method = "AA105CD9041C087568465B6F262D8004")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void actionFormatChanged() {
        mMenu.onItemActionRequestChanged(this);
        // ---------- Original Method ----------
        //mMenu.onItemActionRequestChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.703 -0400", hash_original_method = "B7358CCF217D02273B220AA1E4900E11", hash_generated_method = "982F8C23DC12F60BA036B64FF1E280F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean shouldShowIcon() {
        boolean var70F98333FA0948733960A5795635FA78_1961049258 = (mMenu.getOptionalIconsVisible());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mMenu.getOptionalIconsVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.703 -0400", hash_original_method = "8639B741C99124BF9C4FC28DBCA735D7", hash_generated_method = "6CB7804F3F3052090F48C43546BC1344")
    @DSModeled(DSC.SAFE)
    public boolean isActionButton() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & IS_ACTION) == IS_ACTION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.703 -0400", hash_original_method = "D20AA9738309FEFC21F93C6653D8A4BB", hash_generated_method = "630DCD262ECC9C28EC1FBEFA09F9C6A4")
    @DSModeled(DSC.SAFE)
    public boolean requestsActionButton() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_IF_ROOM) == SHOW_AS_ACTION_IF_ROOM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.704 -0400", hash_original_method = "A0218090F414AFC2516DB1AFD001E557", hash_generated_method = "F32B2ADFA410DF884ADCF8D1FCF63754")
    @DSModeled(DSC.SAFE)
    public boolean requiresActionButton() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_ALWAYS) == SHOW_AS_ACTION_ALWAYS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.704 -0400", hash_original_method = "7A64484A152776341109FA7C71AB82BB", hash_generated_method = "84DAA9C125D124E67A872B420D07652A")
    @DSModeled(DSC.SAFE)
    public void setIsActionButton(boolean isActionButton) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.714 -0400", hash_original_method = "D19EFCF4D4C49A6F9A7B8D6E601DFE3B", hash_generated_method = "B28E41D0E91A05AEC8F9EBA0D0F21864")
    @DSModeled(DSC.SAFE)
    public boolean showsTextAsAction() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_WITH_TEXT) == SHOW_AS_ACTION_WITH_TEXT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.714 -0400", hash_original_method = "6034AD3E3F15BF95CED1827A99F9830A", hash_generated_method = "DA53E10AE2CE40917943617042862B6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShowAsAction(int actionEnum) {
        dsTaint.addTaint(actionEnum);
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM,"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.717 -0400", hash_original_method = "9511E068798AA5E04A674F02DC2F7567", hash_generated_method = "5DD4EE791E17DF65106FF0F040C2F696")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setActionView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mActionProvider = null;
        {
            boolean var9383E447CCD31AC0A55E5ECF75C1C296_1847773234 = (view != null && view.getId() == View.NO_ID && mId > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.718 -0400", hash_original_method = "B057E2C488C14BC05DF25DD2F229F8B2", hash_generated_method = "CC556CE5E8F4B3A8BAD7B67DBCD9CF26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setActionView(int resId) {
        dsTaint.addTaint(resId);
        Context context;
        context = mMenu.getContext();
        LayoutInflater inflater;
        inflater = LayoutInflater.from(context);
        setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Context context = mMenu.getContext();
        //final LayoutInflater inflater = LayoutInflater.from(context);
        //setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.720 -0400", hash_original_method = "404D78F2C7005B21FAAA5C37E608175C", hash_generated_method = "E80015A40CC32A9203A819F8135604C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getActionView() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.721 -0400", hash_original_method = "F6993BB94930E20BEF3D6DE6883E2D9B", hash_generated_method = "4DD23EBA5BFA98459A9251E7C7E7D50C")
    @DSModeled(DSC.SAFE)
    public ActionProvider getActionProvider() {
        return (ActionProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActionProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.722 -0400", hash_original_method = "C59B6F24EC844FBD609E594809339FFA", hash_generated_method = "8A879086C4C9BFA04786956CF30E44AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setActionProvider(ActionProvider actionProvider) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.724 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "1C1C1C69DBD40F35B643D516F736ED95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        dsTaint.addTaint(actionEnum);
        setShowAsAction(actionEnum);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //setShowAsAction(actionEnum);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.724 -0400", hash_original_method = "9242B1434B9CD0ACB88D22E492AB3A81", hash_generated_method = "A50363455F18C68E603A8ED08793E02D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean expandActionView() {
        {
            boolean var81D84D08096DF9E1FCCD4F85A3884372_414271627 = (mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionExpand(this));
            {
                boolean var38AC753AE765E96CBE659CBBA5A8A723_1909267129 = (mMenu.expandItemActionView(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.724 -0400", hash_original_method = "DB0EB37C3626C85F2C23377923AB6063", hash_generated_method = "024136A205353B33A829AD5A917D46D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean collapseActionView() {
        {
            boolean varA0F65C9905152D79B43E3C0EEE82344B_1572796701 = (mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionCollapse(this));
            {
                boolean var690A803F41D0DAB576A6FB2B9FAC7EC4_1291497863 = (mMenu.collapseItemActionView(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.725 -0400", hash_original_method = "B1FCAF7D5B88EED4E84E6E84EBEC9EE4", hash_generated_method = "0F6F6ADCE25BF139AAE5AE262BA3D753")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mOnActionExpandListener = listener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.725 -0400", hash_original_method = "DAFC43ECD0E5D06566AA28ACE3B5E472", hash_generated_method = "DC776E7163FFCDCC89B72534B20E877C")
    @DSModeled(DSC.SAFE)
    public boolean hasCollapsibleActionView() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) != 0 && mActionView != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.725 -0400", hash_original_method = "A7B0C8C0A6B0446C22F6521CC0C60064", hash_generated_method = "37644B7499A7A8A91B8E77B6D1072F81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setActionViewExpanded(boolean isExpanded) {
        dsTaint.addTaint(isExpanded);
        mMenu.onItemsChanged(false);
        // ---------- Original Method ----------
        //mIsActionViewExpanded = isExpanded;
        //mMenu.onItemsChanged(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.725 -0400", hash_original_method = "618A94DE2810D1D688B3A7F878D1125A", hash_generated_method = "FA7EC98BAC4BE4CE7DAEBBB9AF0EDB05")
    @DSModeled(DSC.SAFE)
    public boolean isActionViewExpanded() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsActionViewExpanded;
    }

    
    private static final String TAG = "MenuItemImpl";
    private static final int SHOW_AS_ACTION_MASK = SHOW_AS_ACTION_NEVER |
            SHOW_AS_ACTION_IF_ROOM |
            SHOW_AS_ACTION_ALWAYS;
    private static final int CHECKABLE      = 0x00000001;
    private static final int CHECKED        = 0x00000002;
    private static final int EXCLUSIVE      = 0x00000004;
    private static final int HIDDEN         = 0x00000008;
    private static final int ENABLED        = 0x00000010;
    private static final int IS_ACTION      = 0x00000020;
    static final int NO_ICON = 0;
    private static String sPrependShortcutLabel;
    private static String sEnterShortcutLabel;
    private static String sDeleteShortcutLabel;
    private static String sSpaceShortcutLabel;
}

