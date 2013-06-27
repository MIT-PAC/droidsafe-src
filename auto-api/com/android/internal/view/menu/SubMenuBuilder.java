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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.408 -0400", hash_original_field = "B5511BE86004FD786AD61B3EC2325802", hash_generated_field = "4E1BCCB50336F81563C7D93F9E630BE3")

    private MenuBuilder mParentMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.408 -0400", hash_original_field = "0045FF96E492E7641E5BE2BDA9F7127C", hash_generated_field = "C38EAFECFFC50960A865217D34B85EF5")

    private MenuItemImpl mItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.408 -0400", hash_original_method = "EEEDE2897B343E661DCADEF62AF22FE6", hash_generated_method = "6D5B64BBA05E82C143A075B58DF3D2E3")
    public  SubMenuBuilder(Context context, MenuBuilder parentMenu, MenuItemImpl item) {
        super(context);
        mParentMenu = parentMenu;
        mItem = item;
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //mParentMenu = parentMenu;
        //mItem = item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.409 -0400", hash_original_method = "CFA2D90FFED13BED8AFF4C56CD396197", hash_generated_method = "E725C480A313EC44C414F37ADA1B3F6C")
    @Override
    public void setQwertyMode(boolean isQwerty) {
        mParentMenu.setQwertyMode(isQwerty);
        addTaint(isQwerty);
        // ---------- Original Method ----------
        //mParentMenu.setQwertyMode(isQwerty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.409 -0400", hash_original_method = "136516E019CDEFE0F3C3ED762AF8783A", hash_generated_method = "300B8FCE2FE13E663952501691148F7A")
    @Override
    public boolean isQwertyMode() {
        boolean var3B005D98B32D113BBD14F7F9E193234A_2116911535 = (mParentMenu.isQwertyMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_720786156 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_720786156;
        // ---------- Original Method ----------
        //return mParentMenu.isQwertyMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.409 -0400", hash_original_method = "A904D66AD1D8E748B65C9C8C5EEC3261", hash_generated_method = "6CDCBF40522B0281BB221C44A8F76306")
    @Override
    public void setShortcutsVisible(boolean shortcutsVisible) {
        mParentMenu.setShortcutsVisible(shortcutsVisible);
        addTaint(shortcutsVisible);
        // ---------- Original Method ----------
        //mParentMenu.setShortcutsVisible(shortcutsVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.409 -0400", hash_original_method = "71E56F7ABFBB449375F493931D31DE57", hash_generated_method = "18E4249AE9017949D73513D187416F11")
    @Override
    public boolean isShortcutsVisible() {
        boolean varA901CE1A51BE913879EE45BAB0549677_1101116449 = (mParentMenu.isShortcutsVisible());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874115338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874115338;
        // ---------- Original Method ----------
        //return mParentMenu.isShortcutsVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.410 -0400", hash_original_method = "EFEC7F93A39736AF8130A49104B9A895", hash_generated_method = "A736DBAF3E40083777897E1B6E5A6905")
    public Menu getParentMenu() {
        Menu varB4EAC82CA7396A68D541C85D26508E83_507270072 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_507270072 = mParentMenu;
        varB4EAC82CA7396A68D541C85D26508E83_507270072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_507270072;
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.410 -0400", hash_original_method = "B68A5ADECB21212250B72B1DD0399FE9", hash_generated_method = "EB527F86C88BC0B561C3A41B04E19C38")
    public MenuItem getItem() {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1070431873 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1070431873 = mItem;
        varB4EAC82CA7396A68D541C85D26508E83_1070431873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1070431873;
        // ---------- Original Method ----------
        //return mItem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.410 -0400", hash_original_method = "DBA24265560DE072BE0F453E574665D3", hash_generated_method = "790F603C9613481B61CB9FA6D1ED51C5")
    @Override
    public void setCallback(Callback callback) {
        mParentMenu.setCallback(callback);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //mParentMenu.setCallback(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.411 -0400", hash_original_method = "DFDE0312E92BA6118839C252C79690F8", hash_generated_method = "390DF03700F65B41B1C7283FCF6A07A4")
    @Override
    public MenuBuilder getRootMenu() {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1812303660 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1812303660 = mParentMenu;
        varB4EAC82CA7396A68D541C85D26508E83_1812303660.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1812303660;
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.411 -0400", hash_original_method = "9000096E0EC4FB2931429080284C8422", hash_generated_method = "18E0FFCE8FFC6ACE803784540C0A2F8D")
    @Override
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        boolean varA47B83B06577C0DBF4F94D7167DF129F_1060957819 = (super.dispatchMenuItemSelected(menu, item) ||
                mParentMenu.dispatchMenuItemSelected(menu, item));
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_255364755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_255364755;
        // ---------- Original Method ----------
        //return super.dispatchMenuItemSelected(menu, item) ||
                //mParentMenu.dispatchMenuItemSelected(menu, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.415 -0400", hash_original_method = "0AF009FB156FDD26BF7D5688EA94EA96", hash_generated_method = "4458259999FCC1F0A2D8D76666BBD7D7")
    public SubMenu setIcon(Drawable icon) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_268740943 = null; //Variable for return #1
        mItem.setIcon(icon);
        varB4EAC82CA7396A68D541C85D26508E83_268740943 = this;
        addTaint(icon.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_268740943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_268740943;
        // ---------- Original Method ----------
        //mItem.setIcon(icon);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.416 -0400", hash_original_method = "8258AA953D162B52749278DD498F9224", hash_generated_method = "263AC6D0B60A885E732FE3BC442E89A7")
    public SubMenu setIcon(int iconRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_685100983 = null; //Variable for return #1
        mItem.setIcon(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_685100983 = this;
        addTaint(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_685100983.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_685100983;
        // ---------- Original Method ----------
        //mItem.setIcon(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.416 -0400", hash_original_method = "56E209FCA945BF27944112A810A882F0", hash_generated_method = "BAD95FD6AAB7253D5323BB25F1D0960F")
    public SubMenu setHeaderIcon(Drawable icon) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1849210281 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1849210281 = (SubMenu) super.setHeaderIconInt(icon);
        addTaint(icon.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1849210281.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1849210281;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.423 -0400", hash_original_method = "B3CB9177AFB254AB1F0E1AAE3F32477D", hash_generated_method = "0C4A2FA2FE9F8739DBEF0C4FE293341B")
    public SubMenu setHeaderIcon(int iconRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_455732706 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_455732706 = (SubMenu) super.setHeaderIconInt(iconRes);
        addTaint(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_455732706.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_455732706;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(iconRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.427 -0400", hash_original_method = "044E20C877A5479948C767280A86F92C", hash_generated_method = "5DFDA0F80B7C6D76C8841BB1E03160E8")
    public SubMenu setHeaderTitle(CharSequence title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_13830977 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_13830977 = (SubMenu) super.setHeaderTitleInt(title);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_13830977.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_13830977;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.428 -0400", hash_original_method = "E2D8E4BE5C0093B8E518BA6E44543D65", hash_generated_method = "3B904314CA30AACAD6F7CF3BBF8440A3")
    public SubMenu setHeaderTitle(int titleRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_450246849 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_450246849 = (SubMenu) super.setHeaderTitleInt(titleRes);
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_450246849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_450246849;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(titleRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.428 -0400", hash_original_method = "3CB652CBB5FA246B423F36AF77586ECC", hash_generated_method = "8F1197D4EC7D7C06213C85AD5456C154")
    public SubMenu setHeaderView(View view) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_769940499 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_769940499 = (SubMenu) super.setHeaderViewInt(view);
        addTaint(view.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_769940499.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_769940499;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderViewInt(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.428 -0400", hash_original_method = "6E97D9D8BEFE428705B38823DA7B3E98", hash_generated_method = "2571B36995CD98CF702174A7A559249D")
    @Override
    public boolean expandItemActionView(MenuItemImpl item) {
        boolean var406E6D975E168DB5206C037C3DFF6FB4_1940787434 = (mParentMenu.expandItemActionView(item));
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1786639580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1786639580;
        // ---------- Original Method ----------
        //return mParentMenu.expandItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.429 -0400", hash_original_method = "D98ED83F7F18D17C88DF80DBBB24B50B", hash_generated_method = "0B8299D0D1F99F67EE847951E9FD22B8")
    @Override
    public boolean collapseItemActionView(MenuItemImpl item) {
        boolean var07F33A0D08DA72720335DFC7B52656A0_1247938411 = (mParentMenu.collapseItemActionView(item));
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751139635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751139635;
        // ---------- Original Method ----------
        //return mParentMenu.collapseItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.429 -0400", hash_original_method = "2F8B587BD2C060C35373EC0A47CA21D2", hash_generated_method = "66FBA360A49E1D5A78DA92189CE50BF9")
    @Override
    public String getActionViewStatesKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1358289220 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1103085999 = null; //Variable for return #2
        int itemId;
        itemId = mItem.getItemId();
        itemId = 0;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1358289220 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1103085999 = super.getActionViewStatesKey() + ":" + itemId;
        String varA7E53CE21691AB073D9660D615818899_224385852; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_224385852 = varB4EAC82CA7396A68D541C85D26508E83_1358289220;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_224385852 = varB4EAC82CA7396A68D541C85D26508E83_1103085999;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_224385852.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_224385852;
        // ---------- Original Method ----------
        //final int itemId = mItem != null ? mItem.getItemId() : 0;
        //if (itemId == 0) {
            //return null;
        //}
        //return super.getActionViewStatesKey() + ":" + itemId;
    }

    
}

