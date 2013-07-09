package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.614 -0400", hash_original_field = "B5511BE86004FD786AD61B3EC2325802", hash_generated_field = "4E1BCCB50336F81563C7D93F9E630BE3")

    private MenuBuilder mParentMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.614 -0400", hash_original_field = "0045FF96E492E7641E5BE2BDA9F7127C", hash_generated_field = "C38EAFECFFC50960A865217D34B85EF5")

    private MenuItemImpl mItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.615 -0400", hash_original_method = "EEEDE2897B343E661DCADEF62AF22FE6", hash_generated_method = "6D5B64BBA05E82C143A075B58DF3D2E3")
    public  SubMenuBuilder(Context context, MenuBuilder parentMenu, MenuItemImpl item) {
        super(context);
        mParentMenu = parentMenu;
        mItem = item;
        addTaint(context.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.615 -0400", hash_original_method = "CFA2D90FFED13BED8AFF4C56CD396197", hash_generated_method = "E725C480A313EC44C414F37ADA1B3F6C")
    @Override
    public void setQwertyMode(boolean isQwerty) {
        mParentMenu.setQwertyMode(isQwerty);
        addTaint(isQwerty);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.615 -0400", hash_original_method = "136516E019CDEFE0F3C3ED762AF8783A", hash_generated_method = "69AA4265B54ECF937F22BE2BCE036E8E")
    @Override
    public boolean isQwertyMode() {
        boolean var3B005D98B32D113BBD14F7F9E193234A_1480480319 = (mParentMenu.isQwertyMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315006843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315006843;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.616 -0400", hash_original_method = "A904D66AD1D8E748B65C9C8C5EEC3261", hash_generated_method = "6CDCBF40522B0281BB221C44A8F76306")
    @Override
    public void setShortcutsVisible(boolean shortcutsVisible) {
        mParentMenu.setShortcutsVisible(shortcutsVisible);
        addTaint(shortcutsVisible);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.616 -0400", hash_original_method = "71E56F7ABFBB449375F493931D31DE57", hash_generated_method = "B2F9ED88ABD466E162B7E7EB9AD20C2A")
    @Override
    public boolean isShortcutsVisible() {
        boolean varA901CE1A51BE913879EE45BAB0549677_98292684 = (mParentMenu.isShortcutsVisible());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815916633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815916633;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.617 -0400", hash_original_method = "EFEC7F93A39736AF8130A49104B9A895", hash_generated_method = "9C645CF9AE962D7F6D81115C16BC134F")
    public Menu getParentMenu() {
        Menu varB4EAC82CA7396A68D541C85D26508E83_2108888541 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2108888541 = mParentMenu;
        varB4EAC82CA7396A68D541C85D26508E83_2108888541.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2108888541;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.617 -0400", hash_original_method = "B68A5ADECB21212250B72B1DD0399FE9", hash_generated_method = "7D6A227157F4687D5BB58F6568967CC8")
    public MenuItem getItem() {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1729967802 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1729967802 = mItem;
        varB4EAC82CA7396A68D541C85D26508E83_1729967802.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1729967802;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.618 -0400", hash_original_method = "DBA24265560DE072BE0F453E574665D3", hash_generated_method = "790F603C9613481B61CB9FA6D1ED51C5")
    @Override
    public void setCallback(Callback callback) {
        mParentMenu.setCallback(callback);
        addTaint(callback.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.618 -0400", hash_original_method = "DFDE0312E92BA6118839C252C79690F8", hash_generated_method = "5C5B60AF9493C81B425986F215AE4D48")
    @Override
    public MenuBuilder getRootMenu() {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_80273924 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_80273924 = mParentMenu;
        varB4EAC82CA7396A68D541C85D26508E83_80273924.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_80273924;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.618 -0400", hash_original_method = "9000096E0EC4FB2931429080284C8422", hash_generated_method = "F268E6F614EF6019448C690F5D7A8631")
    @Override
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        boolean varA47B83B06577C0DBF4F94D7167DF129F_361044825 = (super.dispatchMenuItemSelected(menu, item) ||
                mParentMenu.dispatchMenuItemSelected(menu, item));
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_359136408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_359136408;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.619 -0400", hash_original_method = "0AF009FB156FDD26BF7D5688EA94EA96", hash_generated_method = "C8CFA3C758AAC192DF45F89FCBDF038E")
    public SubMenu setIcon(Drawable icon) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_211004928 = null; 
        mItem.setIcon(icon);
        varB4EAC82CA7396A68D541C85D26508E83_211004928 = this;
        addTaint(icon.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_211004928.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_211004928;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.620 -0400", hash_original_method = "8258AA953D162B52749278DD498F9224", hash_generated_method = "F4A45A0C753BA0149B75568043653259")
    public SubMenu setIcon(int iconRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1167190259 = null; 
        mItem.setIcon(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_1167190259 = this;
        addTaint(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_1167190259.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1167190259;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.620 -0400", hash_original_method = "56E209FCA945BF27944112A810A882F0", hash_generated_method = "8822DAE681FC409F7F53EC88ABB260A5")
    public SubMenu setHeaderIcon(Drawable icon) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1095015461 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1095015461 = (SubMenu) super.setHeaderIconInt(icon);
        addTaint(icon.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1095015461.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1095015461;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.621 -0400", hash_original_method = "B3CB9177AFB254AB1F0E1AAE3F32477D", hash_generated_method = "2E7E88D9A26359A0BDFCDCBE4E99F9FC")
    public SubMenu setHeaderIcon(int iconRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_835632828 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_835632828 = (SubMenu) super.setHeaderIconInt(iconRes);
        addTaint(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_835632828.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_835632828;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.621 -0400", hash_original_method = "044E20C877A5479948C767280A86F92C", hash_generated_method = "6716A2864FACE9C1EDACC5807B95BB67")
    public SubMenu setHeaderTitle(CharSequence title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1767530019 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1767530019 = (SubMenu) super.setHeaderTitleInt(title);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1767530019.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1767530019;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.622 -0400", hash_original_method = "E2D8E4BE5C0093B8E518BA6E44543D65", hash_generated_method = "9D94022D3420FB2F296435B55AA986D3")
    public SubMenu setHeaderTitle(int titleRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_242709314 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_242709314 = (SubMenu) super.setHeaderTitleInt(titleRes);
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_242709314.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_242709314;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.623 -0400", hash_original_method = "3CB652CBB5FA246B423F36AF77586ECC", hash_generated_method = "5857048809AD640E7C7FDC9CE225CBCD")
    public SubMenu setHeaderView(View view) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1074263735 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1074263735 = (SubMenu) super.setHeaderViewInt(view);
        addTaint(view.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1074263735.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1074263735;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.623 -0400", hash_original_method = "6E97D9D8BEFE428705B38823DA7B3E98", hash_generated_method = "8A6AA9DE64D54AC00240F5CDA82A9DE4")
    @Override
    public boolean expandItemActionView(MenuItemImpl item) {
        boolean var406E6D975E168DB5206C037C3DFF6FB4_444806683 = (mParentMenu.expandItemActionView(item));
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1023805916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1023805916;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.623 -0400", hash_original_method = "D98ED83F7F18D17C88DF80DBBB24B50B", hash_generated_method = "1DC30383E76ABA35BE5125035A1CA880")
    @Override
    public boolean collapseItemActionView(MenuItemImpl item) {
        boolean var07F33A0D08DA72720335DFC7B52656A0_575424399 = (mParentMenu.collapseItemActionView(item));
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_503232672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_503232672;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.624 -0400", hash_original_method = "2F8B587BD2C060C35373EC0A47CA21D2", hash_generated_method = "ADC978E420E68042296EAFF75DD5DC7E")
    @Override
    public String getActionViewStatesKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_49465612 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_905723708 = null; 
        int itemId;
        itemId = mItem.getItemId();
        itemId = 0;
        {
            varB4EAC82CA7396A68D541C85D26508E83_49465612 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_905723708 = super.getActionViewStatesKey() + ":" + itemId;
        String varA7E53CE21691AB073D9660D615818899_1739171316; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1739171316 = varB4EAC82CA7396A68D541C85D26508E83_49465612;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1739171316 = varB4EAC82CA7396A68D541C85D26508E83_905723708;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1739171316.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1739171316;
        
        
        
            
        
        
    }

    
}

