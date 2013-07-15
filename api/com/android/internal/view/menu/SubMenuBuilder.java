package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.541 -0400", hash_original_field = "B5511BE86004FD786AD61B3EC2325802", hash_generated_field = "4E1BCCB50336F81563C7D93F9E630BE3")

    private MenuBuilder mParentMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.541 -0400", hash_original_field = "0045FF96E492E7641E5BE2BDA9F7127C", hash_generated_field = "C38EAFECFFC50960A865217D34B85EF5")

    private MenuItemImpl mItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.541 -0400", hash_original_method = "EEEDE2897B343E661DCADEF62AF22FE6", hash_generated_method = "E6B60EFACCF8AC096BBD97D9D9DE8F56")
    public  SubMenuBuilder(Context context, MenuBuilder parentMenu, MenuItemImpl item) {
        super(context);
        addTaint(context.getTaint());
        mParentMenu = parentMenu;
        mItem = item;
        // ---------- Original Method ----------
        //mParentMenu = parentMenu;
        //mItem = item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.541 -0400", hash_original_method = "CFA2D90FFED13BED8AFF4C56CD396197", hash_generated_method = "628192CC106C007AFAC1227042FF7F53")
    @Override
    public void setQwertyMode(boolean isQwerty) {
        addTaint(isQwerty);
        mParentMenu.setQwertyMode(isQwerty);
        // ---------- Original Method ----------
        //mParentMenu.setQwertyMode(isQwerty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.541 -0400", hash_original_method = "136516E019CDEFE0F3C3ED762AF8783A", hash_generated_method = "768340AE4867350CB2733DDE7679908D")
    @Override
    public boolean isQwertyMode() {
        boolean varD995D230E45CB8887C100072E7C2959F_1965306344 = (mParentMenu.isQwertyMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_437857295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_437857295;
        // ---------- Original Method ----------
        //return mParentMenu.isQwertyMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.541 -0400", hash_original_method = "A904D66AD1D8E748B65C9C8C5EEC3261", hash_generated_method = "79E4CB159EE960C6D2776BB96509D65E")
    @Override
    public void setShortcutsVisible(boolean shortcutsVisible) {
        addTaint(shortcutsVisible);
        mParentMenu.setShortcutsVisible(shortcutsVisible);
        // ---------- Original Method ----------
        //mParentMenu.setShortcutsVisible(shortcutsVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.541 -0400", hash_original_method = "71E56F7ABFBB449375F493931D31DE57", hash_generated_method = "BCBBD202103877B23CF5A6478CFF42DE")
    @Override
    public boolean isShortcutsVisible() {
        boolean var4073E0CD81748E5654D8BEE884DCD5E9_403185 = (mParentMenu.isShortcutsVisible());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_709357062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_709357062;
        // ---------- Original Method ----------
        //return mParentMenu.isShortcutsVisible();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.542 -0400", hash_original_method = "EFEC7F93A39736AF8130A49104B9A895", hash_generated_method = "90CD870133FC87AECCB31999792D3994")
    public Menu getParentMenu() {
Menu varF208CAAF42A19269A08D768D04E791E1_733320622 =         mParentMenu;
        varF208CAAF42A19269A08D768D04E791E1_733320622.addTaint(taint);
        return varF208CAAF42A19269A08D768D04E791E1_733320622;
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.542 -0400", hash_original_method = "B68A5ADECB21212250B72B1DD0399FE9", hash_generated_method = "F67E638FD9757A0DAB487BFE6909832A")
    public MenuItem getItem() {
MenuItem varB8B55D922EB39771645EDB9C40F92DB5_1891286340 =         mItem;
        varB8B55D922EB39771645EDB9C40F92DB5_1891286340.addTaint(taint);
        return varB8B55D922EB39771645EDB9C40F92DB5_1891286340;
        // ---------- Original Method ----------
        //return mItem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.542 -0400", hash_original_method = "DBA24265560DE072BE0F453E574665D3", hash_generated_method = "DB7ED4143AC45325969947F818F5BDA8")
    @Override
    public void setCallback(Callback callback) {
        addTaint(callback.getTaint());
        mParentMenu.setCallback(callback);
        // ---------- Original Method ----------
        //mParentMenu.setCallback(callback);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.542 -0400", hash_original_method = "DFDE0312E92BA6118839C252C79690F8", hash_generated_method = "9A200FA2681F212731B998B5937826EF")
    @Override
    public MenuBuilder getRootMenu() {
MenuBuilder varF208CAAF42A19269A08D768D04E791E1_387127469 =         mParentMenu;
        varF208CAAF42A19269A08D768D04E791E1_387127469.addTaint(taint);
        return varF208CAAF42A19269A08D768D04E791E1_387127469;
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.542 -0400", hash_original_method = "9000096E0EC4FB2931429080284C8422", hash_generated_method = "53798575035D5DB09E57F5F024FFBF55")
    @Override
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean varE3174B04A8F0687FC9F07FA5E8F7EC92_429528570 = (super.dispatchMenuItemSelected(menu, item) ||
                mParentMenu.dispatchMenuItemSelected(menu, item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159199252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159199252;
        // ---------- Original Method ----------
        //return super.dispatchMenuItemSelected(menu, item) ||
                //mParentMenu.dispatchMenuItemSelected(menu, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.542 -0400", hash_original_method = "0AF009FB156FDD26BF7D5688EA94EA96", hash_generated_method = "27D02755C9794124AED24AC81980236B")
    public SubMenu setIcon(Drawable icon) {
        addTaint(icon.getTaint());
        mItem.setIcon(icon);
SubMenu var72A74007B2BE62B849F475C7BDA4658B_989215832 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_989215832.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_989215832;
        // ---------- Original Method ----------
        //mItem.setIcon(icon);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.542 -0400", hash_original_method = "8258AA953D162B52749278DD498F9224", hash_generated_method = "AF2B5BCBC3EDCF11407EDCCF513D7186")
    public SubMenu setIcon(int iconRes) {
        addTaint(iconRes);
        mItem.setIcon(iconRes);
SubMenu var72A74007B2BE62B849F475C7BDA4658B_1813874634 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1813874634.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1813874634;
        // ---------- Original Method ----------
        //mItem.setIcon(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.542 -0400", hash_original_method = "56E209FCA945BF27944112A810A882F0", hash_generated_method = "EDFDE72286116EA8A32BE786AFD230F8")
    public SubMenu setHeaderIcon(Drawable icon) {
        addTaint(icon.getTaint());
SubMenu var97F4EDDD5BAE9296D77C62210B3282BD_1120644958 =         (SubMenu) super.setHeaderIconInt(icon);
        var97F4EDDD5BAE9296D77C62210B3282BD_1120644958.addTaint(taint);
        return var97F4EDDD5BAE9296D77C62210B3282BD_1120644958;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.542 -0400", hash_original_method = "B3CB9177AFB254AB1F0E1AAE3F32477D", hash_generated_method = "E6C38BD4E75BB2183D315C32280B2499")
    public SubMenu setHeaderIcon(int iconRes) {
        addTaint(iconRes);
SubMenu var795F46ADD5399CF35528DC3F178813AD_1366462558 =         (SubMenu) super.setHeaderIconInt(iconRes);
        var795F46ADD5399CF35528DC3F178813AD_1366462558.addTaint(taint);
        return var795F46ADD5399CF35528DC3F178813AD_1366462558;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(iconRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.542 -0400", hash_original_method = "044E20C877A5479948C767280A86F92C", hash_generated_method = "C4A00C141E4B8B16B8951FC3A9458FDB")
    public SubMenu setHeaderTitle(CharSequence title) {
        addTaint(title.getTaint());
SubMenu varC06140364D3E2369C22D1E22A57FCFF6_1630603497 =         (SubMenu) super.setHeaderTitleInt(title);
        varC06140364D3E2369C22D1E22A57FCFF6_1630603497.addTaint(taint);
        return varC06140364D3E2369C22D1E22A57FCFF6_1630603497;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.543 -0400", hash_original_method = "E2D8E4BE5C0093B8E518BA6E44543D65", hash_generated_method = "30610145B7B2E7E017435B0378D9294C")
    public SubMenu setHeaderTitle(int titleRes) {
        addTaint(titleRes);
SubMenu varFCE46281593FBC2055B0F03413AC873C_563869976 =         (SubMenu) super.setHeaderTitleInt(titleRes);
        varFCE46281593FBC2055B0F03413AC873C_563869976.addTaint(taint);
        return varFCE46281593FBC2055B0F03413AC873C_563869976;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(titleRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.543 -0400", hash_original_method = "3CB652CBB5FA246B423F36AF77586ECC", hash_generated_method = "3DFFCDD5DCB6A7D266DE2643E0563096")
    public SubMenu setHeaderView(View view) {
        addTaint(view.getTaint());
SubMenu var018BD80D9611AACB04043AA4590875FA_1575234677 =         (SubMenu) super.setHeaderViewInt(view);
        var018BD80D9611AACB04043AA4590875FA_1575234677.addTaint(taint);
        return var018BD80D9611AACB04043AA4590875FA_1575234677;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderViewInt(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.543 -0400", hash_original_method = "6E97D9D8BEFE428705B38823DA7B3E98", hash_generated_method = "BBAE5EE48C7CB3B34FD9A2A05057886B")
    @Override
    public boolean expandItemActionView(MenuItemImpl item) {
        addTaint(item.getTaint());
        boolean var28B1E20F172049504707C87CEBC9CBAA_364522488 = (mParentMenu.expandItemActionView(item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989655860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_989655860;
        // ---------- Original Method ----------
        //return mParentMenu.expandItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.543 -0400", hash_original_method = "D98ED83F7F18D17C88DF80DBBB24B50B", hash_generated_method = "B1B650ECC8BCDBEA78FF45BF8BA2EF79")
    @Override
    public boolean collapseItemActionView(MenuItemImpl item) {
        addTaint(item.getTaint());
        boolean var91064DE1D3289D616DC5D379565708CC_203845310 = (mParentMenu.collapseItemActionView(item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188242606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188242606;
        // ---------- Original Method ----------
        //return mParentMenu.collapseItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.543 -0400", hash_original_method = "2F8B587BD2C060C35373EC0A47CA21D2", hash_generated_method = "9CE0EB547AD8172D0B3A3EDB4F0C658A")
    @Override
    public String getActionViewStatesKey() {
        final int itemId = mItem != null ? mItem.getItemId() : 0;
    if(itemId == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_1142621257 =             null;
            var540C13E9E156B687226421B24F2DF178_1142621257.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1142621257;
        } //End block
String var4D0F444A49EDFBA8040B4459D86C8C87_237136054 =         super.getActionViewStatesKey() + ":" + itemId;
        var4D0F444A49EDFBA8040B4459D86C8C87_237136054.addTaint(taint);
        return var4D0F444A49EDFBA8040B4459D86C8C87_237136054;
        // ---------- Original Method ----------
        //final int itemId = mItem != null ? mItem.getItemId() : 0;
        //if (itemId == 0) {
            //return null;
        //}
        //return super.getActionViewStatesKey() + ":" + itemId;
    }

    
}

