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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.726 -0400", hash_original_field = "B5511BE86004FD786AD61B3EC2325802", hash_generated_field = "4E1BCCB50336F81563C7D93F9E630BE3")

    private MenuBuilder mParentMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.744 -0400", hash_original_field = "0045FF96E492E7641E5BE2BDA9F7127C", hash_generated_field = "C38EAFECFFC50960A865217D34B85EF5")

    private MenuItemImpl mItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.745 -0400", hash_original_method = "EEEDE2897B343E661DCADEF62AF22FE6", hash_generated_method = "6D5B64BBA05E82C143A075B58DF3D2E3")
    public  SubMenuBuilder(Context context, MenuBuilder parentMenu, MenuItemImpl item) {
        super(context);
        mParentMenu = parentMenu;
        mItem = item;
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //mParentMenu = parentMenu;
        //mItem = item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.745 -0400", hash_original_method = "CFA2D90FFED13BED8AFF4C56CD396197", hash_generated_method = "E725C480A313EC44C414F37ADA1B3F6C")
    @Override
    public void setQwertyMode(boolean isQwerty) {
        mParentMenu.setQwertyMode(isQwerty);
        addTaint(isQwerty);
        // ---------- Original Method ----------
        //mParentMenu.setQwertyMode(isQwerty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.746 -0400", hash_original_method = "136516E019CDEFE0F3C3ED762AF8783A", hash_generated_method = "DC903F7CF7FFF4C7226C5CBB6E5B14F5")
    @Override
    public boolean isQwertyMode() {
        boolean var3B005D98B32D113BBD14F7F9E193234A_1517720140 = (mParentMenu.isQwertyMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1575809010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1575809010;
        // ---------- Original Method ----------
        //return mParentMenu.isQwertyMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.746 -0400", hash_original_method = "A904D66AD1D8E748B65C9C8C5EEC3261", hash_generated_method = "6CDCBF40522B0281BB221C44A8F76306")
    @Override
    public void setShortcutsVisible(boolean shortcutsVisible) {
        mParentMenu.setShortcutsVisible(shortcutsVisible);
        addTaint(shortcutsVisible);
        // ---------- Original Method ----------
        //mParentMenu.setShortcutsVisible(shortcutsVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.746 -0400", hash_original_method = "71E56F7ABFBB449375F493931D31DE57", hash_generated_method = "B1EE18A3CAB6C172DE1BFA70FDF7BB75")
    @Override
    public boolean isShortcutsVisible() {
        boolean varA901CE1A51BE913879EE45BAB0549677_841893624 = (mParentMenu.isShortcutsVisible());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_175960712 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_175960712;
        // ---------- Original Method ----------
        //return mParentMenu.isShortcutsVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.747 -0400", hash_original_method = "EFEC7F93A39736AF8130A49104B9A895", hash_generated_method = "91D18E0F9F07ABD9CD0F8E5202A088EE")
    public Menu getParentMenu() {
        Menu varB4EAC82CA7396A68D541C85D26508E83_1854180541 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1854180541 = mParentMenu;
        varB4EAC82CA7396A68D541C85D26508E83_1854180541.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1854180541;
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.747 -0400", hash_original_method = "B68A5ADECB21212250B72B1DD0399FE9", hash_generated_method = "431638C1BB947D1854205E822F73A472")
    public MenuItem getItem() {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_306785327 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_306785327 = mItem;
        varB4EAC82CA7396A68D541C85D26508E83_306785327.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_306785327;
        // ---------- Original Method ----------
        //return mItem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.747 -0400", hash_original_method = "DBA24265560DE072BE0F453E574665D3", hash_generated_method = "790F603C9613481B61CB9FA6D1ED51C5")
    @Override
    public void setCallback(Callback callback) {
        mParentMenu.setCallback(callback);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //mParentMenu.setCallback(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.775 -0400", hash_original_method = "DFDE0312E92BA6118839C252C79690F8", hash_generated_method = "9B6D4B7BD4C1D835B323706DD2AB9E2B")
    @Override
    public MenuBuilder getRootMenu() {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_997123776 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_997123776 = mParentMenu;
        varB4EAC82CA7396A68D541C85D26508E83_997123776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_997123776;
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.776 -0400", hash_original_method = "9000096E0EC4FB2931429080284C8422", hash_generated_method = "44672ECE12E85CF48965AB6348314F26")
    @Override
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        boolean varA47B83B06577C0DBF4F94D7167DF129F_700275781 = (super.dispatchMenuItemSelected(menu, item) ||
                mParentMenu.dispatchMenuItemSelected(menu, item));
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2088314402 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2088314402;
        // ---------- Original Method ----------
        //return super.dispatchMenuItemSelected(menu, item) ||
                //mParentMenu.dispatchMenuItemSelected(menu, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.777 -0400", hash_original_method = "0AF009FB156FDD26BF7D5688EA94EA96", hash_generated_method = "F19609347FAD7220D3BEA4FD4F770A42")
    public SubMenu setIcon(Drawable icon) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_98430330 = null; //Variable for return #1
        mItem.setIcon(icon);
        varB4EAC82CA7396A68D541C85D26508E83_98430330 = this;
        addTaint(icon.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_98430330.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_98430330;
        // ---------- Original Method ----------
        //mItem.setIcon(icon);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.778 -0400", hash_original_method = "8258AA953D162B52749278DD498F9224", hash_generated_method = "E264FF9D50A56490E0A137FA93004979")
    public SubMenu setIcon(int iconRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1687813367 = null; //Variable for return #1
        mItem.setIcon(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_1687813367 = this;
        addTaint(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_1687813367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1687813367;
        // ---------- Original Method ----------
        //mItem.setIcon(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.778 -0400", hash_original_method = "56E209FCA945BF27944112A810A882F0", hash_generated_method = "F3CA8829477B28CE9E9DB2F862F50E78")
    public SubMenu setHeaderIcon(Drawable icon) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_772051012 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_772051012 = (SubMenu) super.setHeaderIconInt(icon);
        addTaint(icon.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_772051012.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_772051012;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.779 -0400", hash_original_method = "B3CB9177AFB254AB1F0E1AAE3F32477D", hash_generated_method = "292B78A04C51406638E72EBA41B80734")
    public SubMenu setHeaderIcon(int iconRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_431747945 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_431747945 = (SubMenu) super.setHeaderIconInt(iconRes);
        addTaint(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_431747945.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_431747945;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(iconRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.779 -0400", hash_original_method = "044E20C877A5479948C767280A86F92C", hash_generated_method = "8BDF664F8BA8E1EE94077F2739380F7B")
    public SubMenu setHeaderTitle(CharSequence title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_2113938488 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2113938488 = (SubMenu) super.setHeaderTitleInt(title);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2113938488.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2113938488;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.780 -0400", hash_original_method = "E2D8E4BE5C0093B8E518BA6E44543D65", hash_generated_method = "D4FDE235EED917B1B81F5357E0DA6BCB")
    public SubMenu setHeaderTitle(int titleRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1226486692 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1226486692 = (SubMenu) super.setHeaderTitleInt(titleRes);
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_1226486692.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226486692;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(titleRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.780 -0400", hash_original_method = "3CB652CBB5FA246B423F36AF77586ECC", hash_generated_method = "B2C96406A7B4FFEABD913BE53FDE0650")
    public SubMenu setHeaderView(View view) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1632490435 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1632490435 = (SubMenu) super.setHeaderViewInt(view);
        addTaint(view.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1632490435.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1632490435;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderViewInt(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.781 -0400", hash_original_method = "6E97D9D8BEFE428705B38823DA7B3E98", hash_generated_method = "9F9F4E596F1F2BB1E87050FA1C88BF5F")
    @Override
    public boolean expandItemActionView(MenuItemImpl item) {
        boolean var406E6D975E168DB5206C037C3DFF6FB4_1968313242 = (mParentMenu.expandItemActionView(item));
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354865530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_354865530;
        // ---------- Original Method ----------
        //return mParentMenu.expandItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.781 -0400", hash_original_method = "D98ED83F7F18D17C88DF80DBBB24B50B", hash_generated_method = "3898D00786B6EF616266D6BBFFE858F6")
    @Override
    public boolean collapseItemActionView(MenuItemImpl item) {
        boolean var07F33A0D08DA72720335DFC7B52656A0_1675985687 = (mParentMenu.collapseItemActionView(item));
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1204936907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1204936907;
        // ---------- Original Method ----------
        //return mParentMenu.collapseItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.792 -0400", hash_original_method = "2F8B587BD2C060C35373EC0A47CA21D2", hash_generated_method = "4D80360F7B56DB68A8B439EDD091CE73")
    @Override
    public String getActionViewStatesKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1916258586 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_96956256 = null; //Variable for return #2
        int itemId;
        itemId = mItem.getItemId();
        itemId = 0;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1916258586 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_96956256 = super.getActionViewStatesKey() + ":" + itemId;
        String varA7E53CE21691AB073D9660D615818899_507858772; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_507858772 = varB4EAC82CA7396A68D541C85D26508E83_1916258586;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_507858772 = varB4EAC82CA7396A68D541C85D26508E83_96956256;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_507858772.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_507858772;
        // ---------- Original Method ----------
        //final int itemId = mItem != null ? mItem.getItemId() : 0;
        //if (itemId == 0) {
            //return null;
        //}
        //return super.getActionViewStatesKey() + ":" + itemId;
    }

    
}

