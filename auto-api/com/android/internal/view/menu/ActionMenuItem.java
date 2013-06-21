package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private Context mContext;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private int mFlags = ENABLED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.324 -0400", hash_original_method = "ABBA9423D74CB077EE46D2E3EFD8A9A3", hash_generated_method = "9D6EC030798E7E53CF2278568D4895FD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.324 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "05B79725D1238EBE991AE5FA4060A9B9")
    @DSModeled(DSC.SAFE)
    public char getAlphabeticShortcut() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.325 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "E879054FEFD042D4B17928844215A6E1")
    @DSModeled(DSC.SAFE)
    public int getGroupId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.325 -0400", hash_original_method = "E45C59E22635FD55A8824D390FC98A96", hash_generated_method = "86C6445723726D22E4CD4C7FCFCCAA4A")
    @DSModeled(DSC.SAFE)
    public Drawable getIcon() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIconDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.325 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "22770DE3BF38836C28544CA3834587CE")
    @DSModeled(DSC.SPEC)
    public Intent getIntent() {
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.325 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "BF2DDDDEF3B326601A0003ACC859FED9")
    @DSModeled(DSC.SAFE)
    public int getItemId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.325 -0400", hash_original_method = "D505DD9DA217AD48C3FB7728B16EAF3B", hash_generated_method = "D92C82A7609C038F7F38A5615723A6EE")
    @DSModeled(DSC.SAFE)
    public ContextMenuInfo getMenuInfo() {
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.325 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "9844DB6DC34580EB38269876CA6DF2CF")
    @DSModeled(DSC.SAFE)
    public char getNumericShortcut() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.325 -0400", hash_original_method = "FF535D1B11FC0F0766CD26B9FF10F186", hash_generated_method = "FAF7CC8F6EDAAD293A4D761F81CCBA21")
    @DSModeled(DSC.SAFE)
    public int getOrder() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.326 -0400", hash_original_method = "772A0AA7AD2F04B178AEEA64C07E8BF0", hash_generated_method = "8CE22AD0242A8C40ADFBE26EE9284634")
    @DSModeled(DSC.SAFE)
    public SubMenu getSubMenu() {
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.326 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "7A540A7B0E4496A8FAF388C1F1064A47")
    @DSModeled(DSC.SAFE)
    public CharSequence getTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.326 -0400", hash_original_method = "AE18A80D188B13895AC76378DAF3976F", hash_generated_method = "860F65F859134C7C45485AE12AB83DAF")
    @DSModeled(DSC.SAFE)
    public CharSequence getTitleCondensed() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitleCondensed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.326 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "20C765D3C01C10AF786EFC952B2BCCA5")
    @DSModeled(DSC.SAFE)
    public boolean hasSubMenu() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.326 -0400", hash_original_method = "ED15661074DADD4461D34783FBB8C8E2", hash_generated_method = "4C5F8F02F3F5BAC927FA61CB7B7326EB")
    @DSModeled(DSC.SAFE)
    public boolean isCheckable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.326 -0400", hash_original_method = "76E21D72539001F6EF2A57161392D665", hash_generated_method = "4EC76706D2F10AA90AA3109225BAD0D0")
    @DSModeled(DSC.SAFE)
    public boolean isChecked() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.327 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "E7FFCA7493FA630D6A1EBA84DC34A9DB")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.327 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "68E08BFD8E0FA8B2882DCFD0A5870F43")
    @DSModeled(DSC.SAFE)
    public boolean isVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.327 -0400", hash_original_method = "7379DA8B69266F5EBF9FDADEBDD8B3A5", hash_generated_method = "8A90DA373833F0E1F619808A31E62FC1")
    @DSModeled(DSC.SAFE)
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        dsTaint.addTaint(alphaChar);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.327 -0400", hash_original_method = "00566BB0E7762EC9407CFB205264961E", hash_generated_method = "D54CA21DB078C6D5D274CA84DE2DA7AB")
    @DSModeled(DSC.SAFE)
    public MenuItem setCheckable(boolean checkable) {
        dsTaint.addTaint(checkable);
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.327 -0400", hash_original_method = "38C8FF82F2D3210CC276B1181111BFDA", hash_generated_method = "75E09D35D86C11942D0B3B956017A161")
    @DSModeled(DSC.SAFE)
    public ActionMenuItem setExclusiveCheckable(boolean exclusive) {
        dsTaint.addTaint(exclusive);
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        return (ActionMenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.327 -0400", hash_original_method = "5A966E6072519B52A8CEABF5F32ED38A", hash_generated_method = "0E456C00DDD345F11E46202B0770D793")
    @DSModeled(DSC.SAFE)
    public MenuItem setChecked(boolean checked) {
        dsTaint.addTaint(checked);
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.328 -0400", hash_original_method = "3B4A922D22D692F4E29B7172DE89A0AD", hash_generated_method = "3D9BA22F29E03E8A35586DB4611760BD")
    @DSModeled(DSC.SAFE)
    public MenuItem setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.328 -0400", hash_original_method = "F52277830906BCEFECA5EA80235FDCAB", hash_generated_method = "BDE22FBA2EE77F8D62338604710D98B3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.328 -0400", hash_original_method = "5010B90C9AB4414DB888D97ADDAE2333", hash_generated_method = "0BF630AD7F9E8367B6EF3AE75603D3AC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.329 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "4A30A418C6C4212003E8BF4506D92B34")
    @DSModeled(DSC.SPEC)
    public MenuItem setIntent(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.329 -0400", hash_original_method = "1F2FCA18D7E58148E8935254347BE744", hash_generated_method = "FE19D293C44479517C0432E700C01030")
    @DSModeled(DSC.SAFE)
    public MenuItem setNumericShortcut(char numericChar) {
        dsTaint.addTaint(numericChar);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.329 -0400", hash_original_method = "6601271ADD9A6C6B3D832752A2C4336F", hash_generated_method = "2CAFDA2CB8DE1DAC15993674765DDCDA")
    @DSModeled(DSC.SAFE)
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        dsTaint.addTaint(menuItemClickListener.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mClickListener = menuItemClickListener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.329 -0400", hash_original_method = "656EFF8CD4994CD73006E38A783E9B74", hash_generated_method = "F99A107A4F7D09F641FED89AE2343233")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.329 -0400", hash_original_method = "E3AEA6168BB1F22DFC2A4192F0EFD72E", hash_generated_method = "E011B3129B85291DCBB91E598C620B28")
    @DSModeled(DSC.SAFE)
    public MenuItem setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mTitle = title;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.329 -0400", hash_original_method = "93E35E6A1799E092E053E5DD222DC093", hash_generated_method = "6AC76FAA7FF3F20214622F4F70CDFDD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setTitle(int title) {
        dsTaint.addTaint(title);
        mTitle = mContext.getResources().getString(title);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mTitle = mContext.getResources().getString(title);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.330 -0400", hash_original_method = "DC9EFDDD12206C16928994FD6B9EA83A", hash_generated_method = "28216156E2B87BF06ED058C7FE2784A1")
    @DSModeled(DSC.SAFE)
    public MenuItem setTitleCondensed(CharSequence title) {
        dsTaint.addTaint(title);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.330 -0400", hash_original_method = "6A802D7132DF936AE104E3A9B00DB973", hash_generated_method = "66B45E2236D5E7EE6BF35012860BB130")
    @DSModeled(DSC.SAFE)
    public MenuItem setVisible(boolean visible) {
        dsTaint.addTaint(visible);
        mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.330 -0400", hash_original_method = "AA032C02BB6C3B5A9CA83C7C80BC2006", hash_generated_method = "D2E96CCE58C5A2830FC0085D2BF12EDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean invoke() {
        {
            boolean var891D05C799AF985A1D37CA302BA21D09_787497333 = (mClickListener != null && mClickListener.onMenuItemClick(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.330 -0400", hash_original_method = "7271F034C654DB6347336274A9D03801", hash_generated_method = "BFFF7AAAE170C7D4586AB2C5BA7A777A")
    @DSModeled(DSC.SAFE)
    public void setShowAsAction(int show) {
        dsTaint.addTaint(show);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.330 -0400", hash_original_method = "493F4A0F304908668D2BEC1F7D0E334B", hash_generated_method = "CB74D71BA027BDF2EE696FEC93D54BCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem setActionView(View actionView) {
        dsTaint.addTaint(actionView.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.331 -0400", hash_original_method = "DDC728D00ABE6AC1AC6555673541B67E", hash_generated_method = "BDF745BC95530EF94209BC34C216A0F5")
    @DSModeled(DSC.SAFE)
    public View getActionView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.331 -0400", hash_original_method = "38A20BA0D11F10392D85500804B1A43F", hash_generated_method = "D0AE13066C392AC69E28689991CDBDAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public MenuItem setActionView(int resId) {
        dsTaint.addTaint(resId);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.331 -0400", hash_original_method = "FE44B196FF60CED75746223A767C8615", hash_generated_method = "2E7C32915E66F84CB662761C90607DF9")
    @DSModeled(DSC.SAFE)
    @Override
    public ActionProvider getActionProvider() {
        return (ActionProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.331 -0400", hash_original_method = "4ABFFD9ECFCE20F6052063E7AA9E942A", hash_generated_method = "514805A5C796B7BBB9A6E71FCADB9518")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        dsTaint.addTaint(actionProvider.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.331 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "1C1C1C69DBD40F35B643D516F736ED95")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.331 -0400", hash_original_method = "E3EFEFBDC234312A7FEC732911F191DE", hash_generated_method = "5298E0ACA59E2E55F1B0E590A5C81623")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean expandActionView() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.332 -0400", hash_original_method = "A369693BDACA70A4B3FDAADB36135262", hash_generated_method = "D53DE692B4B0BB47B2DA6A15EED28FC3")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean collapseActionView() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.332 -0400", hash_original_method = "6EAD6F9611A0523E2504074954E6B02A", hash_generated_method = "821EC4CAD6ECB73F0EE2E1CC78949EE1")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isActionViewExpanded() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.332 -0400", hash_original_method = "DC2EA5E6DB4BFE29B2697085EABCD856", hash_generated_method = "B6104A1AE47E34E35222044E201D6E25")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    private static final int NO_ICON = 0;
    private static final int CHECKABLE      = 0x00000001;
    private static final int CHECKED        = 0x00000002;
    private static final int EXCLUSIVE      = 0x00000004;
    private static final int HIDDEN         = 0x00000008;
    private static final int ENABLED        = 0x00000010;
}

