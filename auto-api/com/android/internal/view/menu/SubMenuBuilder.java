package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.123 -0400", hash_original_method = "EEEDE2897B343E661DCADEF62AF22FE6", hash_generated_method = "EFDBBCE9CDAA8E075E7DC915B52E83C0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.123 -0400", hash_original_method = "CFA2D90FFED13BED8AFF4C56CD396197", hash_generated_method = "C7947E387A07A3E5977DC5B2353A3D44")
    @DSModeled(DSC.SAFE)
    @Override
    public void setQwertyMode(boolean isQwerty) {
        dsTaint.addTaint(isQwerty);
        mParentMenu.setQwertyMode(isQwerty);
        // ---------- Original Method ----------
        //mParentMenu.setQwertyMode(isQwerty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "136516E019CDEFE0F3C3ED762AF8783A", hash_generated_method = "F0349EDC106303E4A487F8F69E951AF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isQwertyMode() {
        boolean var3B005D98B32D113BBD14F7F9E193234A_1343794708 = (mParentMenu.isQwertyMode());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.isQwertyMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "A904D66AD1D8E748B65C9C8C5EEC3261", hash_generated_method = "052924ECA3600985560DE64178428156")
    @DSModeled(DSC.SAFE)
    @Override
    public void setShortcutsVisible(boolean shortcutsVisible) {
        dsTaint.addTaint(shortcutsVisible);
        mParentMenu.setShortcutsVisible(shortcutsVisible);
        // ---------- Original Method ----------
        //mParentMenu.setShortcutsVisible(shortcutsVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "71E56F7ABFBB449375F493931D31DE57", hash_generated_method = "97451994018E7B944830BC51C93D6625")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isShortcutsVisible() {
        boolean varA901CE1A51BE913879EE45BAB0549677_221913669 = (mParentMenu.isShortcutsVisible());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.isShortcutsVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "EFEC7F93A39736AF8130A49104B9A895", hash_generated_method = "C41D1DB6F25B2FF51C5E0E7F76508713")
    @DSModeled(DSC.SAFE)
    public Menu getParentMenu() {
        return (Menu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "B68A5ADECB21212250B72B1DD0399FE9", hash_generated_method = "B57CFCA65FF1290EC45C3C21C5922CD6")
    @DSModeled(DSC.SAFE)
    public MenuItem getItem() {
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "DBA24265560DE072BE0F453E574665D3", hash_generated_method = "7961210ADED63DD33BC79AE8AC85F880")
    @DSModeled(DSC.SAFE)
    @Override
    public void setCallback(Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        mParentMenu.setCallback(callback);
        // ---------- Original Method ----------
        //mParentMenu.setCallback(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "DFDE0312E92BA6118839C252C79690F8", hash_generated_method = "7C6F68147982AFC8ECA62FF928111B63")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuBuilder getRootMenu() {
        return (MenuBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "9000096E0EC4FB2931429080284C8422", hash_generated_method = "1D5A4882FCB0DD5C6B61630B2F160288")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(item.dsTaint);
        boolean varA47B83B06577C0DBF4F94D7167DF129F_353880886 = (super.dispatchMenuItemSelected(menu, item) ||
                mParentMenu.dispatchMenuItemSelected(menu, item));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.dispatchMenuItemSelected(menu, item) ||
                //mParentMenu.dispatchMenuItemSelected(menu, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "0AF009FB156FDD26BF7D5688EA94EA96", hash_generated_method = "DD508259607A8451643776957B0C4664")
    @DSModeled(DSC.SAFE)
    public SubMenu setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        mItem.setIcon(icon);
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mItem.setIcon(icon);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "8258AA953D162B52749278DD498F9224", hash_generated_method = "DAB31F3EB2C8B2EC85EF32C84CBD33E9")
    @DSModeled(DSC.SAFE)
    public SubMenu setIcon(int iconRes) {
        dsTaint.addTaint(iconRes);
        mItem.setIcon(iconRes);
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mItem.setIcon(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "56E209FCA945BF27944112A810A882F0", hash_generated_method = "67CEEC69CA90A15927BD1BA366E8EBE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        SubMenu var6F49407167CF768E097BE84486D8ED33_2027517431 = ((SubMenu) super.setHeaderIconInt(icon));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "B3CB9177AFB254AB1F0E1AAE3F32477D", hash_generated_method = "E72EAB7AB7A166463E30CE2AF3894450")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderIcon(int iconRes) {
        dsTaint.addTaint(iconRes);
        SubMenu var5F0CDAD7A4D06FD649262DBC611FB04D_842288732 = ((SubMenu) super.setHeaderIconInt(iconRes));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(iconRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "044E20C877A5479948C767280A86F92C", hash_generated_method = "D3941ECE98A7D47082034C2546501B7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderTitle(CharSequence title) {
        dsTaint.addTaint(title);
        SubMenu varEE1EBC8E05ABF2B3897A4B8BE5DADF10_270431709 = ((SubMenu) super.setHeaderTitleInt(title));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "E2D8E4BE5C0093B8E518BA6E44543D65", hash_generated_method = "36D46F3571F23BE97B1A3B5A4C503213")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderTitle(int titleRes) {
        dsTaint.addTaint(titleRes);
        SubMenu var199F253623B53248E312D25A27936E1D_447346812 = ((SubMenu) super.setHeaderTitleInt(titleRes));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(titleRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "3CB652CBB5FA246B423F36AF77586ECC", hash_generated_method = "12976229B000EF63240D69B99CAB4FFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderView(View view) {
        dsTaint.addTaint(view.dsTaint);
        SubMenu var36B524B67A251113E9AD0A1FADFC74BE_938754781 = ((SubMenu) super.setHeaderViewInt(view));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderViewInt(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "6E97D9D8BEFE428705B38823DA7B3E98", hash_generated_method = "F93FBAB2B41597A08CE50947CE8A1D0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean expandItemActionView(MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        boolean var406E6D975E168DB5206C037C3DFF6FB4_1125541946 = (mParentMenu.expandItemActionView(item));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.expandItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "D98ED83F7F18D17C88DF80DBBB24B50B", hash_generated_method = "29211866975328D2ADF85D02864907DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean collapseItemActionView(MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        boolean var07F33A0D08DA72720335DFC7B52656A0_1261139764 = (mParentMenu.collapseItemActionView(item));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.collapseItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.124 -0400", hash_original_method = "2F8B587BD2C060C35373EC0A47CA21D2", hash_generated_method = "CCC1A3DFCD221FA39E64B440238D8928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getActionViewStatesKey() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final int itemId;
        itemId = mItem.getItemId();
        itemId = 0;
        String varFA607475296DAFFA2B32EB0718E9F8D5_1180254176 = (super.getActionViewStatesKey() + ":" + itemId);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final int itemId = mItem != null ? mItem.getItemId() : 0;
        //if (itemId == 0) {
            //return null;
        //}
        //return super.getActionViewStatesKey() + ":" + itemId;
    }

    
}


