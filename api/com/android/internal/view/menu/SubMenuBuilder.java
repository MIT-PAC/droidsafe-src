package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;





public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.600 -0400", hash_original_field = "B5511BE86004FD786AD61B3EC2325802", hash_generated_field = "4E1BCCB50336F81563C7D93F9E630BE3")

    private MenuBuilder mParentMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.601 -0400", hash_original_field = "0045FF96E492E7641E5BE2BDA9F7127C", hash_generated_field = "C38EAFECFFC50960A865217D34B85EF5")

    private MenuItemImpl mItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.601 -0400", hash_original_method = "EEEDE2897B343E661DCADEF62AF22FE6", hash_generated_method = "E6B60EFACCF8AC096BBD97D9D9DE8F56")
    public  SubMenuBuilder(Context context, MenuBuilder parentMenu, MenuItemImpl item) {
        super(context);
        addTaint(context.getTaint());
        mParentMenu = parentMenu;
        mItem = item;
        // ---------- Original Method ----------
        //mParentMenu = parentMenu;
        //mItem = item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.601 -0400", hash_original_method = "CFA2D90FFED13BED8AFF4C56CD396197", hash_generated_method = "628192CC106C007AFAC1227042FF7F53")
    @Override
    public void setQwertyMode(boolean isQwerty) {
        addTaint(isQwerty);
        mParentMenu.setQwertyMode(isQwerty);
        // ---------- Original Method ----------
        //mParentMenu.setQwertyMode(isQwerty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.602 -0400", hash_original_method = "136516E019CDEFE0F3C3ED762AF8783A", hash_generated_method = "19AD3DA1C3FCC3A30A75E5F705FE76E0")
    @Override
    public boolean isQwertyMode() {
        boolean varD995D230E45CB8887C100072E7C2959F_775487030 = (mParentMenu.isQwertyMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_968160246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_968160246;
        // ---------- Original Method ----------
        //return mParentMenu.isQwertyMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.602 -0400", hash_original_method = "A904D66AD1D8E748B65C9C8C5EEC3261", hash_generated_method = "79E4CB159EE960C6D2776BB96509D65E")
    @Override
    public void setShortcutsVisible(boolean shortcutsVisible) {
        addTaint(shortcutsVisible);
        mParentMenu.setShortcutsVisible(shortcutsVisible);
        // ---------- Original Method ----------
        //mParentMenu.setShortcutsVisible(shortcutsVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.602 -0400", hash_original_method = "71E56F7ABFBB449375F493931D31DE57", hash_generated_method = "5E6322A0AFB39300C9DF92E9694E5D8B")
    @Override
    public boolean isShortcutsVisible() {
        boolean var4073E0CD81748E5654D8BEE884DCD5E9_107025108 = (mParentMenu.isShortcutsVisible());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1943429413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1943429413;
        // ---------- Original Method ----------
        //return mParentMenu.isShortcutsVisible();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.603 -0400", hash_original_method = "EFEC7F93A39736AF8130A49104B9A895", hash_generated_method = "83A8A3C337923D373A9A2F79247624E3")
    public Menu getParentMenu() {
Menu varF208CAAF42A19269A08D768D04E791E1_1786052350 =         mParentMenu;
        varF208CAAF42A19269A08D768D04E791E1_1786052350.addTaint(taint);
        return varF208CAAF42A19269A08D768D04E791E1_1786052350;
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.603 -0400", hash_original_method = "B68A5ADECB21212250B72B1DD0399FE9", hash_generated_method = "4D4467493EFA2D9B30EBF9AE6C9B7D0A")
    public MenuItem getItem() {
MenuItem varB8B55D922EB39771645EDB9C40F92DB5_299266433 =         mItem;
        varB8B55D922EB39771645EDB9C40F92DB5_299266433.addTaint(taint);
        return varB8B55D922EB39771645EDB9C40F92DB5_299266433;
        // ---------- Original Method ----------
        //return mItem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.604 -0400", hash_original_method = "DBA24265560DE072BE0F453E574665D3", hash_generated_method = "DB7ED4143AC45325969947F818F5BDA8")
    @Override
    public void setCallback(Callback callback) {
        addTaint(callback.getTaint());
        mParentMenu.setCallback(callback);
        // ---------- Original Method ----------
        //mParentMenu.setCallback(callback);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.604 -0400", hash_original_method = "DFDE0312E92BA6118839C252C79690F8", hash_generated_method = "1A6BEA14D29CE86857FD6F73493B0F52")
    @Override
    public MenuBuilder getRootMenu() {
MenuBuilder varF208CAAF42A19269A08D768D04E791E1_324417128 =         mParentMenu;
        varF208CAAF42A19269A08D768D04E791E1_324417128.addTaint(taint);
        return varF208CAAF42A19269A08D768D04E791E1_324417128;
        // ---------- Original Method ----------
        //return mParentMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.604 -0400", hash_original_method = "9000096E0EC4FB2931429080284C8422", hash_generated_method = "422D251E500BA8C2B7EC418E41465DB5")
    @Override
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean varE3174B04A8F0687FC9F07FA5E8F7EC92_860408614 = (super.dispatchMenuItemSelected(menu, item) ||
                mParentMenu.dispatchMenuItemSelected(menu, item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936954493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936954493;
        // ---------- Original Method ----------
        //return super.dispatchMenuItemSelected(menu, item) ||
                //mParentMenu.dispatchMenuItemSelected(menu, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.605 -0400", hash_original_method = "0AF009FB156FDD26BF7D5688EA94EA96", hash_generated_method = "570767E3BAEF89A9E26AF4FBA316FEC6")
    public SubMenu setIcon(Drawable icon) {
        addTaint(icon.getTaint());
        mItem.setIcon(icon);
SubMenu var72A74007B2BE62B849F475C7BDA4658B_1081420442 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1081420442.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1081420442;
        // ---------- Original Method ----------
        //mItem.setIcon(icon);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.605 -0400", hash_original_method = "8258AA953D162B52749278DD498F9224", hash_generated_method = "9A1284919C1C8C4ACAE77506790539E1")
    public SubMenu setIcon(int iconRes) {
        addTaint(iconRes);
        mItem.setIcon(iconRes);
SubMenu var72A74007B2BE62B849F475C7BDA4658B_582075715 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_582075715.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_582075715;
        // ---------- Original Method ----------
        //mItem.setIcon(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.605 -0400", hash_original_method = "56E209FCA945BF27944112A810A882F0", hash_generated_method = "B327BF777051F888B17EB9E42EACA737")
    public SubMenu setHeaderIcon(Drawable icon) {
        addTaint(icon.getTaint());
SubMenu var97F4EDDD5BAE9296D77C62210B3282BD_724263297 =         (SubMenu) super.setHeaderIconInt(icon);
        var97F4EDDD5BAE9296D77C62210B3282BD_724263297.addTaint(taint);
        return var97F4EDDD5BAE9296D77C62210B3282BD_724263297;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.605 -0400", hash_original_method = "B3CB9177AFB254AB1F0E1AAE3F32477D", hash_generated_method = "56034F675BDB8B055BB56A3A6C58998C")
    public SubMenu setHeaderIcon(int iconRes) {
        addTaint(iconRes);
SubMenu var795F46ADD5399CF35528DC3F178813AD_1952419057 =         (SubMenu) super.setHeaderIconInt(iconRes);
        var795F46ADD5399CF35528DC3F178813AD_1952419057.addTaint(taint);
        return var795F46ADD5399CF35528DC3F178813AD_1952419057;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderIconInt(iconRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.606 -0400", hash_original_method = "044E20C877A5479948C767280A86F92C", hash_generated_method = "F95CA032BB1E6D837A355AA5EE3FD090")
    public SubMenu setHeaderTitle(CharSequence title) {
        addTaint(title.getTaint());
SubMenu varC06140364D3E2369C22D1E22A57FCFF6_33850997 =         (SubMenu) super.setHeaderTitleInt(title);
        varC06140364D3E2369C22D1E22A57FCFF6_33850997.addTaint(taint);
        return varC06140364D3E2369C22D1E22A57FCFF6_33850997;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.606 -0400", hash_original_method = "E2D8E4BE5C0093B8E518BA6E44543D65", hash_generated_method = "FAB89C01BE60B9D5A4E2428B9F858EAE")
    public SubMenu setHeaderTitle(int titleRes) {
        addTaint(titleRes);
SubMenu varFCE46281593FBC2055B0F03413AC873C_413134114 =         (SubMenu) super.setHeaderTitleInt(titleRes);
        varFCE46281593FBC2055B0F03413AC873C_413134114.addTaint(taint);
        return varFCE46281593FBC2055B0F03413AC873C_413134114;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderTitleInt(titleRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.606 -0400", hash_original_method = "3CB652CBB5FA246B423F36AF77586ECC", hash_generated_method = "8C4A66A476C3EA62DE5ABC907382BA6C")
    public SubMenu setHeaderView(View view) {
        addTaint(view.getTaint());
SubMenu var018BD80D9611AACB04043AA4590875FA_123250262 =         (SubMenu) super.setHeaderViewInt(view);
        var018BD80D9611AACB04043AA4590875FA_123250262.addTaint(taint);
        return var018BD80D9611AACB04043AA4590875FA_123250262;
        // ---------- Original Method ----------
        //return (SubMenu) super.setHeaderViewInt(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.606 -0400", hash_original_method = "6E97D9D8BEFE428705B38823DA7B3E98", hash_generated_method = "A3E6EEC31B2F9C919CE118BDC8B4C78E")
    @Override
    public boolean expandItemActionView(MenuItemImpl item) {
        addTaint(item.getTaint());
        boolean var28B1E20F172049504707C87CEBC9CBAA_696483932 = (mParentMenu.expandItemActionView(item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_307833086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_307833086;
        // ---------- Original Method ----------
        //return mParentMenu.expandItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.607 -0400", hash_original_method = "D98ED83F7F18D17C88DF80DBBB24B50B", hash_generated_method = "63B4D1CECD49EE838FC09231FAEDAF88")
    @Override
    public boolean collapseItemActionView(MenuItemImpl item) {
        addTaint(item.getTaint());
        boolean var91064DE1D3289D616DC5D379565708CC_574233050 = (mParentMenu.collapseItemActionView(item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1214213211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1214213211;
        // ---------- Original Method ----------
        //return mParentMenu.collapseItemActionView(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.607 -0400", hash_original_method = "2F8B587BD2C060C35373EC0A47CA21D2", hash_generated_method = "87686FB90D9CEA44B0E5432D080AB2A9")
    @Override
    public String getActionViewStatesKey() {
        final int itemId = mItem != null ? mItem.getItemId() : 0;
        if(itemId == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_955382683 =             null;
            var540C13E9E156B687226421B24F2DF178_955382683.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_955382683;
        } //End block
String var4D0F444A49EDFBA8040B4459D86C8C87_1600102753 =         super.getActionViewStatesKey() + ":" + itemId;
        var4D0F444A49EDFBA8040B4459D86C8C87_1600102753.addTaint(taint);
        return var4D0F444A49EDFBA8040B4459D86C8C87_1600102753;
        // ---------- Original Method ----------
        //final int itemId = mItem != null ? mItem.getItemId() : 0;
        //if (itemId == 0) {
            //return null;
        //}
        //return super.getActionViewStatesKey() + ":" + itemId;
    }

    
}

