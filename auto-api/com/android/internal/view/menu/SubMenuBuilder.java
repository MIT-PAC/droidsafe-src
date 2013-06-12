package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuBuilder mParentMenu;
    private MenuItemImpl mItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.167 -0400", hash_original_method = "EEEDE2897B343E661DCADEF62AF22FE6", hash_generated_method = "EFDBBCE9CDAA8E075E7DC915B52E83C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenuBuilder(Context context, MenuBuilder parentMenu, MenuItemImpl item) {
        super(context);
        dsTaint.addTaint(parentMenu.dsTaint);
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mParentMenu = parentMenu;
        //mItem = item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.179 -0400", hash_original_method = "CFA2D90FFED13BED8AFF4C56CD396197", hash_generated_method = "C7947E387A07A3E5977DC5B2353A3D44")
    @DSModeled(DSC.SAFE)
    @Override
    public void setQwertyMode(boolean isQwerty) {
        dsTaint.addTaint(isQwerty);
        mParentMenu.setQwertyMode(isQwerty);
        // ---------- Original Method ----------
        //mParentMenu.setQwertyMode(isQwerty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.191 -0400", hash_original_method = "136516E019CDEFE0F3C3ED762AF8783A", hash_generated_method = "FA88939EAAF1B1FDD83779C4636F1AE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isQwertyMode() {
        boolean var3B005D98B32D113BBD14F7F9E193234A_284015928 = (mParentMenu.isQwertyMode());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.isQwertyMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.218 -0400", hash_original_method = "A904D66AD1D8E748B65C9C8C5EEC3261", hash_generated_method = "052924ECA3600985560DE64178428156")
    @DSModeled(DSC.SAFE)
    @Override
    public void setShortcutsVisible(boolean shortcutsVisible) {
        dsTaint.addTaint(shortcutsVisible);
        mParentMenu.setShortcutsVisible(shortcutsVisible);
        // ---------- Original Method ----------
        //mParentMenu.setShortcutsVisible(shortcutsVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.236 -0400", hash_original_method = "71E56F7ABFBB449375F493931D31DE57", hash_generated_method = "94C1EC2C02E6D2FA100AB34A6FDFE6D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isShortcutsVisible() {
        boolean varA901CE1A51BE913879EE45BAB0549677_866147613 = (mParentMenu.isShortcutsVisible());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.isShortcutsVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.242 -0400", hash_original_method = "EFEC7F93A39736AF8130A49104B9A895", hash_generated_method = "C41D1DB6F25B2FF51C5E0E7F76508713")
    @DSModeled(DSC.SAFE)
    public Menu getParentMenu() {
        return (Menu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.244 -0400", hash_original_method = "B68A5ADECB21212250B72B1DD0399FE9", hash_generated_method = "B57CFCA65FF1290EC45C3C21C5922CD6")
    @DSModeled(DSC.SAFE)
    public MenuItem getItem() {
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.280 -0400", hash_original_method = "DBA24265560DE072BE0F453E574665D3", hash_generated_method = "7961210ADED63DD33BC79AE8AC85F880")
    @DSModeled(DSC.SAFE)
    @Override
    public void setCallback(Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        mParentMenu.setCallback(callback);
        // ---------- Original Method ----------
        //mParentMenu.setCallback(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.285 -0400", hash_original_method = "DFDE0312E92BA6118839C252C79690F8", hash_generated_method = "7C6F68147982AFC8ECA62FF928111B63")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuBuilder getRootMenu() {
        return (MenuBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.314 -0400", hash_original_method = "9000096E0EC4FB2931429080284C8422", hash_generated_method = "DE4D2D2D92DBE029609AD18653591C54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(item.dsTaint);
        boolean varA47B83B06577C0DBF4F94D7167DF129F_1698727619 = (super.dispatchMenuItemSelected(menu, item) ||
                mParentMenu.dispatchMenuItemSelected(menu, item));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.dispatchMenuItemSelected(menu, item) ||
                //mParentMenu.dispatchMenuItemSelected(menu, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.333 -0400", hash_original_method = "0AF009FB156FDD26BF7D5688EA94EA96", hash_generated_method = "DD508259607A8451643776957B0C4664")
    @DSModeled(DSC.SAFE)
    public SubMenu setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        mItem.setIcon(icon);
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mItem.setIcon(icon);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.362 -0400", hash_original_method = "8258AA953D162B52749278DD498F9224", hash_generated_method = "DAB31F3EB2C8B2EC85EF32C84CBD33E9")
    @DSModeled(DSC.SAFE)
    public SubMenu setIcon(int iconRes) {
        dsTaint.addTaint(iconRes);
        mItem.setIcon(iconRes);
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mItem.setIcon(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.378 -0400", hash_original_method = "56E209FCA945BF27944112A810A882F0", hash_generated_method = "06FE6BF17C807F9F6241FD8DE691546C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        SubMenu var6F49407167CF768E097BE84486D8ED33_1447486527 = ((SubMenu) super.setHeaderIconInt(icon));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.402 -0400", hash_original_method = "B3CB9177AFB254AB1F0E1AAE3F32477D", hash_generated_method = "1A358752A93B87D7108413C0AEDA694A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderIcon(int iconRes) {
        dsTaint.addTaint(iconRes);
        SubMenu var5F0CDAD7A4D06FD649262DBC611FB04D_904828073 = ((SubMenu) super.setHeaderIconInt(iconRes));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(iconRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.420 -0400", hash_original_method = "044E20C877A5479948C767280A86F92C", hash_generated_method = "F462473546F788C02D4BE8673787AE54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderTitle(CharSequence title) {
        dsTaint.addTaint(title);
        SubMenu varEE1EBC8E05ABF2B3897A4B8BE5DADF10_1629244387 = ((SubMenu) super.setHeaderTitleInt(title));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.444 -0400", hash_original_method = "E2D8E4BE5C0093B8E518BA6E44543D65", hash_generated_method = "ACDA556CBFB4C26F856EE8153DCC8978")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderTitle(int titleRes) {
        dsTaint.addTaint(titleRes);
        SubMenu var199F253623B53248E312D25A27936E1D_1724685872 = ((SubMenu) super.setHeaderTitleInt(titleRes));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(titleRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.468 -0400", hash_original_method = "3CB652CBB5FA246B423F36AF77586ECC", hash_generated_method = "C8FADEDC67FE116BAC140759B87C374D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderView(View view) {
        dsTaint.addTaint(view.dsTaint);
        SubMenu var36B524B67A251113E9AD0A1FADFC74BE_241827782 = ((SubMenu) super.setHeaderViewInt(view));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderViewInt(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.501 -0400", hash_original_method = "6E97D9D8BEFE428705B38823DA7B3E98", hash_generated_method = "A53553DADA9F842C48884AE3E543C9B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean expandItemActionView(MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        boolean var406E6D975E168DB5206C037C3DFF6FB4_1723193392 = (mParentMenu.expandItemActionView(item));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.expandItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.506 -0400", hash_original_method = "D98ED83F7F18D17C88DF80DBBB24B50B", hash_generated_method = "247BD8375048C19592899943DD58E451")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean collapseItemActionView(MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        boolean var07F33A0D08DA72720335DFC7B52656A0_155768389 = (mParentMenu.collapseItemActionView(item));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.collapseItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.525 -0400", hash_original_method = "2F8B587BD2C060C35373EC0A47CA21D2", hash_generated_method = "F1EA22C435225BD82F14D082DF810D1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getActionViewStatesKey() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int itemId;
        itemId = mItem.getItemId();
        itemId = 0;
        String varFA607475296DAFFA2B32EB0718E9F8D5_1496100608 = (super.getActionViewStatesKey() + ":" + itemId);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final int itemId = mItem != null ? mItem.getItemId() : 0;
        //if (itemId == 0) {
            //return null;
        //}
        //return super.getActionViewStatesKey() + ":" + itemId;
    }

    
}


