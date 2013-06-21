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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.787 -0400", hash_original_method = "EEEDE2897B343E661DCADEF62AF22FE6", hash_generated_method = "F1C848F8AF26FE08D9D26F297768BB85")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.787 -0400", hash_original_method = "CFA2D90FFED13BED8AFF4C56CD396197", hash_generated_method = "A486A454AA6EE6D26ABBF7F89EA12278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setQwertyMode(boolean isQwerty) {
        dsTaint.addTaint(isQwerty);
        mParentMenu.setQwertyMode(isQwerty);
        // ---------- Original Method ----------
        //mParentMenu.setQwertyMode(isQwerty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.787 -0400", hash_original_method = "136516E019CDEFE0F3C3ED762AF8783A", hash_generated_method = "7BC96F559F7D4C0B67536A77D7891265")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isQwertyMode() {
        boolean var3B005D98B32D113BBD14F7F9E193234A_692548226 = (mParentMenu.isQwertyMode());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.isQwertyMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.788 -0400", hash_original_method = "A904D66AD1D8E748B65C9C8C5EEC3261", hash_generated_method = "730E53437CC9CECDDA8E51CC41CC8263")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setShortcutsVisible(boolean shortcutsVisible) {
        dsTaint.addTaint(shortcutsVisible);
        mParentMenu.setShortcutsVisible(shortcutsVisible);
        // ---------- Original Method ----------
        //mParentMenu.setShortcutsVisible(shortcutsVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.788 -0400", hash_original_method = "71E56F7ABFBB449375F493931D31DE57", hash_generated_method = "083E9D793ED6B130C72BEAA656DA8998")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isShortcutsVisible() {
        boolean varA901CE1A51BE913879EE45BAB0549677_2081231034 = (mParentMenu.isShortcutsVisible());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.isShortcutsVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.788 -0400", hash_original_method = "EFEC7F93A39736AF8130A49104B9A895", hash_generated_method = "A4DAA3614473C8E3F663A7A834690551")
    @DSModeled(DSC.SAFE)
    public Menu getParentMenu() {
        return (Menu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.788 -0400", hash_original_method = "B68A5ADECB21212250B72B1DD0399FE9", hash_generated_method = "7B199B9F491E796EB6A05058C34D3DE9")
    @DSModeled(DSC.SAFE)
    public MenuItem getItem() {
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.788 -0400", hash_original_method = "DBA24265560DE072BE0F453E574665D3", hash_generated_method = "20EC4863487455FDDF5124FF97392C83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setCallback(Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        mParentMenu.setCallback(callback);
        // ---------- Original Method ----------
        //mParentMenu.setCallback(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.789 -0400", hash_original_method = "DFDE0312E92BA6118839C252C79690F8", hash_generated_method = "E4B78C56F0C280CB6676FCF1E6F2066C")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuBuilder getRootMenu() {
        return (MenuBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.789 -0400", hash_original_method = "9000096E0EC4FB2931429080284C8422", hash_generated_method = "99AA97B6B109753B1B7987CC0EE9F165")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        boolean varA47B83B06577C0DBF4F94D7167DF129F_1819051402 = (super.dispatchMenuItemSelected(menu, item) ||
                mParentMenu.dispatchMenuItemSelected(menu, item));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.dispatchMenuItemSelected(menu, item) ||
                //mParentMenu.dispatchMenuItemSelected(menu, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.789 -0400", hash_original_method = "0AF009FB156FDD26BF7D5688EA94EA96", hash_generated_method = "31D0D206BD64BD3A82A59561B6870A22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        mItem.setIcon(icon);
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mItem.setIcon(icon);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.789 -0400", hash_original_method = "8258AA953D162B52749278DD498F9224", hash_generated_method = "EED45CEF1A38F07CF0D7866A3B14B0A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setIcon(int iconRes) {
        dsTaint.addTaint(iconRes);
        mItem.setIcon(iconRes);
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mItem.setIcon(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.789 -0400", hash_original_method = "56E209FCA945BF27944112A810A882F0", hash_generated_method = "106E77750DF74D398F472A8D5E68D7DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        SubMenu var6F49407167CF768E097BE84486D8ED33_253054834 = ((SubMenu) super.setHeaderIconInt(icon));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.790 -0400", hash_original_method = "B3CB9177AFB254AB1F0E1AAE3F32477D", hash_generated_method = "96B6EC169816DA84DDF354EA15708009")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderIcon(int iconRes) {
        dsTaint.addTaint(iconRes);
        SubMenu var5F0CDAD7A4D06FD649262DBC611FB04D_341428003 = ((SubMenu) super.setHeaderIconInt(iconRes));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(iconRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.790 -0400", hash_original_method = "044E20C877A5479948C767280A86F92C", hash_generated_method = "39B87B9C738C519A6BC04A890221CE59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderTitle(CharSequence title) {
        dsTaint.addTaint(title);
        SubMenu varEE1EBC8E05ABF2B3897A4B8BE5DADF10_90027287 = ((SubMenu) super.setHeaderTitleInt(title));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.790 -0400", hash_original_method = "E2D8E4BE5C0093B8E518BA6E44543D65", hash_generated_method = "FE8630800A2AE61817292C28E6E97FA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderTitle(int titleRes) {
        dsTaint.addTaint(titleRes);
        SubMenu var199F253623B53248E312D25A27936E1D_1410629347 = ((SubMenu) super.setHeaderTitleInt(titleRes));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(titleRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.790 -0400", hash_original_method = "3CB652CBB5FA246B423F36AF77586ECC", hash_generated_method = "46158A4E3477134D254AF946D1A786A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu setHeaderView(View view) {
        dsTaint.addTaint(view.dsTaint);
        SubMenu var36B524B67A251113E9AD0A1FADFC74BE_829275842 = ((SubMenu) super.setHeaderViewInt(view));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderViewInt(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.790 -0400", hash_original_method = "6E97D9D8BEFE428705B38823DA7B3E98", hash_generated_method = "9DB9EA7FB1449394F14416462AB78ED0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean expandItemActionView(MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        boolean var406E6D975E168DB5206C037C3DFF6FB4_552506635 = (mParentMenu.expandItemActionView(item));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.expandItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.791 -0400", hash_original_method = "D98ED83F7F18D17C88DF80DBBB24B50B", hash_generated_method = "6A2D33EA8E8028F0B5B5546D5CFAD022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean collapseItemActionView(MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        boolean var07F33A0D08DA72720335DFC7B52656A0_994111505 = (mParentMenu.collapseItemActionView(item));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParentMenu.collapseItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.791 -0400", hash_original_method = "2F8B587BD2C060C35373EC0A47CA21D2", hash_generated_method = "052A14F36BC401C7A3BD71BC41E4F957")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getActionViewStatesKey() {
        int itemId;
        itemId = mItem.getItemId();
        itemId = 0;
        String varFA607475296DAFFA2B32EB0718E9F8D5_397355884 = (super.getActionViewStatesKey() + ":" + itemId);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final int itemId = mItem != null ? mItem.getItemId() : 0;
        //if (itemId == 0) {
            //return null;
        //}
        //return super.getActionViewStatesKey() + ":" + itemId;
    }

    
}

