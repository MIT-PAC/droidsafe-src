package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.469 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.469 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private int mGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.469 -0400", hash_original_field = "B75BDC891F05DF8D9F77776476EBCDD6", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private int mCategoryOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.469 -0400", hash_original_field = "CCC67011C0B9AB1BA64ACA217793FF17", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private int mOrdering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.469 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.469 -0400", hash_original_field = "793CD2D3A29DBCA3B6EE3D2D5CF29A55", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.469 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.469 -0400", hash_original_field = "5CA918862E899FBE57CD8F3D0DB44604", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.469 -0400", hash_original_field = "FAC611210B68F831D4A3B699FB58A971", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.469 -0400", hash_original_field = "EF18AFCEFBAD21F6B816E931AD814543", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "37AC3635461CA62872231C85492F3A9C", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "E163EBF815349370E2BC91E219960B88", hash_generated_field = "CCE2E7E9B41EB859D026207A515694B8")

    private SubMenuBuilder mSubMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "2B7E0A3FBDE4E506B96DAB7C97214944", hash_generated_field = "E128AFA2E0B8F17E3CC9B8F36180ADD8")

    private Runnable mItemCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "C7443C6F6983E9AE465DCA4986300561", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")

    private MenuItem.OnMenuItemClickListener mClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "25DDE236B20D5D6403355424CC7CFB83", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "EE351B57987290D5C97C12334A4F5C8A", hash_generated_field = "7FED0AA513FCAFE5BBB64F7D855AC56C")

    private int mShowAsAction = SHOW_AS_ACTION_NEVER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "42ED82821F0D805CE8C635AE635639B9", hash_generated_field = "67E37FA198462CB2D5A9B9320B838135")

    private View mActionView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "6F151B4E913A23BC3B3F9FF725385336", hash_generated_field = "43987C5D315D6540F5B86319E4F6655F")

    private ActionProvider mActionProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "20990041D5CB5868F5C6A4F0A5C55C0F", hash_generated_field = "784094F6CF284A96EDEED4548B8FB05D")

    private OnActionExpandListener mOnActionExpandListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "07492CDCBB9799261CC2942AB3F6D415", hash_generated_field = "06A110AC8494F5C7468903392B66FD97")

    private boolean mIsActionViewExpanded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.470 -0400", hash_original_field = "17699AE07D9C5F03811167BB1003FF3E", hash_generated_field = "B7A128C3CB7F07DDB09B9D1855650533")

    private ContextMenuInfo mMenuInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.471 -0400", hash_original_method = "64F6A72F78EB0039947A0530C3919D96", hash_generated_method = "8588EB286C7E0A628C638CAD9C0C3E27")
      MenuItemImpl(MenuBuilder menu, int group, int id, int categoryOrder, int ordering,
            CharSequence title, int showAsAction) {
        {
            sPrependShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.prepend_shortcut_label);
            sEnterShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_enter_shortcut_label);
            sDeleteShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_delete_shortcut_label);
            sSpaceShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_space_shortcut_label);
        } 
        mMenu = menu;
        mId = id;
        mGroup = group;
        mCategoryOrder = categoryOrder;
        mOrdering = ordering;
        mTitle = title;
        mShowAsAction = showAsAction;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.471 -0400", hash_original_method = "DCB176B376623FC7561DCD073EB66D0A", hash_generated_method = "AE9C058BC1D7721E02FC6192E3A3CCFC")
    public boolean invoke() {
        {
            boolean var88913A92E58559334515FB7FBA94C39B_793151056 = (mClickListener != null &&
            mClickListener.onMenuItemClick(this));
        } 
        {
            boolean varFE751BCD088421286FAC3C070DC91E76_578440766 = (mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this));
        } 
        {
            mItemCallback.run();
        } 
        {
            try 
            {
                mMenu.getContext().startActivity(mIntent);
            } 
            catch (ActivityNotFoundException e)
            { }
        } 
        {
            boolean varB61D100D9A52D650CE9068160A94F50D_1383658373 = (mActionProvider != null && mActionProvider.onPerformDefaultAction());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1994679179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1994679179;
        
        
            
            
        
        
            
        
        
            
            
        
        
            
                
                
            
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.472 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "6DF9781E48AB50C52894DA823B66B138")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1662586885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1662586885;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.473 -0400", hash_original_method = "D7CDC1A4A52E7AA2B30AF0AEE42BB489", hash_generated_method = "5E8913F38FD4B86793B686E40BB65EA5")
    public MenuItem setEnabled(boolean enabled) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1672303408 = null; 
        {
            mFlags |= ENABLED;
        } 
        {
            mFlags &= ~ENABLED;
        } 
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_1672303408 = this;
        addTaint(enabled);
        varB4EAC82CA7396A68D541C85D26508E83_1672303408.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1672303408;
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.473 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "7146DFA9105660C112F2EB7E23F40C3D")
    public int getGroupId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360206553 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360206553;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.474 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "86356BA440F301DE8102279A0C28FE80")
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557126641 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557126641;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.474 -0400", hash_original_method = "C3905BED22935FA2186A402E1BBD1829", hash_generated_method = "85A2EB447E29F931FE5A444019C8C26B")
    public int getOrder() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_601265814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_601265814;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.475 -0400", hash_original_method = "92E8F82AA50FD1AD58335B2DC7895A83", hash_generated_method = "361CD33BC3D15B8351BA4ADDEA6C9650")
    public int getOrdering() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399354756 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399354756;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.477 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "197C45F5A936B818DA3D309B7C02570C")
    public Intent getIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_625572688 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_625572688 = mIntent;
        varB4EAC82CA7396A68D541C85D26508E83_625572688.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_625572688;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.479 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "81A2D2BD8170F0E53E10D9B36310C79C")
    public MenuItem setIntent(Intent intent) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1002396801 = null; 
        mIntent = intent;
        varB4EAC82CA7396A68D541C85D26508E83_1002396801 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1002396801.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1002396801;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.481 -0400", hash_original_method = "C32C9CAC3047604A3F615D0E2B0A3D92", hash_generated_method = "1BD1E5543F183D6B9269206F540E9A56")
     Runnable getCallback() {
        Runnable varB4EAC82CA7396A68D541C85D26508E83_435460220 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_435460220 = mItemCallback;
        varB4EAC82CA7396A68D541C85D26508E83_435460220.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_435460220;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.482 -0400", hash_original_method = "CAD9375B57D68888676D597787CB9AA1", hash_generated_method = "68E63B8834859FCC07F3FA24EDA44FF4")
    public MenuItem setCallback(Runnable callback) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1167744111 = null; 
        mItemCallback = callback;
        varB4EAC82CA7396A68D541C85D26508E83_1167744111 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1167744111.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1167744111;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.483 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "80DFEC63572C7028296A3149BF231BB9")
    public char getAlphabeticShortcut() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1166755220 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1166755220;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.484 -0400", hash_original_method = "88D9907A20D6B14742A0B31CE890DEE4", hash_generated_method = "ECE4685C4D3491080D493403E770F7DF")
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1524562853 = null; 
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1618318648 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1524562853 = this;
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_1618318648 = this;
        MenuItem varA7E53CE21691AB073D9660D615818899_1397128295; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1397128295 = varB4EAC82CA7396A68D541C85D26508E83_1524562853;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1397128295 = varB4EAC82CA7396A68D541C85D26508E83_1618318648;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1397128295.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1397128295;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.485 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "CC79EB3F2E75DE4901CAC9F666CE9420")
    public char getNumericShortcut() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1609901257 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1609901257;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.487 -0400", hash_original_method = "C979D44A5E5C9CB1A686CC5CF090F436", hash_generated_method = "9CD5320CD5B61ADDE5721D9D309A0A6E")
    public MenuItem setNumericShortcut(char numericChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2125518396 = null; 
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_793605357 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2125518396 = this;
        mShortcutNumericChar = numericChar;
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_793605357 = this;
        MenuItem varA7E53CE21691AB073D9660D615818899_1711046477; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1711046477 = varB4EAC82CA7396A68D541C85D26508E83_2125518396;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1711046477 = varB4EAC82CA7396A68D541C85D26508E83_793605357;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1711046477.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1711046477;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.488 -0400", hash_original_method = "0C4A5B3F8F292031B8A33F43134542C3", hash_generated_method = "9196E2C0DAA659BC73394693E0A61824")
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_21065924 = null; 
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_21065924 = this;
        varB4EAC82CA7396A68D541C85D26508E83_21065924.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_21065924;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.489 -0400", hash_original_method = "D96803BF052A5945B7D152CA36FE6B7E", hash_generated_method = "5F80A2D663887C4E3950D7EE74EBEFBC")
     char getShortcut() {
        char var657EE3268E63EFD9A824FD06F69F72DE_1541051115 = ((mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar)); 
        char varA87DEB01C5F539E6BDA34829C8EF2368_462387693 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_462387693;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.490 -0400", hash_original_method = "BC454AC179D3698A29B0357FA131C3B2", hash_generated_method = "2BD430F9C5A8F406FD142DCD09A8E4DF")
     String getShortcutLabel() {
        String varB4EAC82CA7396A68D541C85D26508E83_1453248131 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_388247692 = null; 
        char shortcut = getShortcut();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1453248131 = "";
        } 
        StringBuilder sb = new StringBuilder(sPrependShortcutLabel);
        
        sb.append(sEnterShortcutLabel);
        
        
        sb.append(sDeleteShortcutLabel);
        
        
        sb.append(sSpaceShortcutLabel);
        
        
        sb.append(shortcut);
        
        varB4EAC82CA7396A68D541C85D26508E83_388247692 = sb.toString();
        String varA7E53CE21691AB073D9660D615818899_1445017943; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1445017943 = varB4EAC82CA7396A68D541C85D26508E83_1453248131;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1445017943 = varB4EAC82CA7396A68D541C85D26508E83_388247692;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1445017943.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1445017943;
        
        
        
            
        
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.490 -0400", hash_original_method = "10F1B2AEF5DA21C52B4C4E0F70D42C6B", hash_generated_method = "DAD0D8AA96BD6E664C91AB0804D11984")
     boolean shouldShowShortcut() {
        boolean varE0C4140F2C4952AC2F09D9F0558D1D66_1042866000 = (mMenu.isShortcutsVisible() && (getShortcut() != 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043101790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043101790;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.491 -0400", hash_original_method = "4569B511D747F82913D0DE9D1EF62E55", hash_generated_method = "71F86A6BCFCEBC7C2ED98B5576FD501C")
    public SubMenu getSubMenu() {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_103638821 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_103638821 = mSubMenu;
        varB4EAC82CA7396A68D541C85D26508E83_103638821.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_103638821;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.491 -0400", hash_original_method = "4556386DBA75360C55B0D4465EB5905E", hash_generated_method = "D076C3CE0EBD2DD31A560C943B2E0C1E")
    public boolean hasSubMenu() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_733758009 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_733758009;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.492 -0400", hash_original_method = "84077AC2D714BDDE1A3A80B85CC9BFB0", hash_generated_method = "9BE0E7ADF2FF7A8D98A414C8B1B91CC8")
     void setSubMenu(SubMenuBuilder subMenu) {
        mSubMenu = subMenu;
        subMenu.setHeaderTitle(getTitle());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.492 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "C632648514A3B10FE0C86EB7D4E1E71F")
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1104437186 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1104437186 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_1104437186.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1104437186;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.493 -0400", hash_original_method = "6C0965535A50DC1B1EFB814EBEDF6248", hash_generated_method = "ABFC8C1854A11EFE8F5AE6FDFFE9B9DE")
     CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_144812782 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_144812782 = ((itemView != null) && itemView.prefersCondensedTitle())
                ? getTitleCondensed()
                : getTitle();
        addTaint(itemView.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_144812782.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_144812782;
        
        
                
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.494 -0400", hash_original_method = "1E48645B8578DDF9EFFB5676592C549A", hash_generated_method = "33F3C02995F09A5F1804086A14255D19")
    public MenuItem setTitle(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_102958936 = null; 
        mTitle = title;
        mMenu.onItemsChanged(false);
        {
            mSubMenu.setHeaderTitle(title);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_102958936 = this;
        varB4EAC82CA7396A68D541C85D26508E83_102958936.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_102958936;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.496 -0400", hash_original_method = "504EB589769814F693A853F99C8002C5", hash_generated_method = "9844B5F25B88D13A1DE021B6C5E35579")
    public MenuItem setTitle(int title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2042988314 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2042988314 = setTitle(mMenu.getContext().getString(title));
        addTaint(title);
        varB4EAC82CA7396A68D541C85D26508E83_2042988314.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2042988314;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.497 -0400", hash_original_method = "2F32534D1148FE277B46E47FA445D759", hash_generated_method = "BBD0C8F6F91339C20487895576957B66")
    public CharSequence getTitleCondensed() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1634873690 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1634873690 = mTitleCondensed != null ? mTitleCondensed : mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_1634873690.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1634873690;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.497 -0400", hash_original_method = "A10897990E671CAED83F82CF9B7ADDEE", hash_generated_method = "01CB9AFB750DC7D1D9CDEEA1CB69FCC0")
    public MenuItem setTitleCondensed(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1814236469 = null; 
        mTitleCondensed = title;
        {
            title = mTitle;
        } 
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_1814236469 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1814236469.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1814236469;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.498 -0400", hash_original_method = "77C51DB63A44599458883D3753A34CC1", hash_generated_method = "B37325B2211150AA4ED5C028296A2C82")
    public Drawable getIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1388820064 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1752792747 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_674096235 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1388820064 = mIconDrawable;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1752792747 = mMenu.getResources().getDrawable(mIconResId);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_674096235 = null;
        Drawable varA7E53CE21691AB073D9660D615818899_1800283601; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1800283601 = varB4EAC82CA7396A68D541C85D26508E83_1388820064;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1800283601 = varB4EAC82CA7396A68D541C85D26508E83_1752792747;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1800283601 = varB4EAC82CA7396A68D541C85D26508E83_674096235;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1800283601.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1800283601;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.499 -0400", hash_original_method = "BD8BE6A7204F93A97A4B1462396F9006", hash_generated_method = "7E911BB425B6D5088EF8183E4C117BD0")
    public MenuItem setIcon(Drawable icon) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_816044141 = null; 
        mIconResId = NO_ICON;
        mIconDrawable = icon;
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_816044141 = this;
        varB4EAC82CA7396A68D541C85D26508E83_816044141.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_816044141;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.499 -0400", hash_original_method = "6CA4716E877DA09BBA89FF884DD9F3E1", hash_generated_method = "0DA01DEC1165E840527E3D3D0DCA8A50")
    public MenuItem setIcon(int iconResId) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1333868825 = null; 
        mIconDrawable = null;
        mIconResId = iconResId;
        mMenu.onItemsChanged(false);
        varB4EAC82CA7396A68D541C85D26508E83_1333868825 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1333868825.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1333868825;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.500 -0400", hash_original_method = "03294EC000E2E3A998710BD4D5DBC105", hash_generated_method = "52DB1556F41493CC2A8ED32294E714A6")
    public boolean isCheckable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815601047 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815601047;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.501 -0400", hash_original_method = "97D03B8420DC0405BDED5AEBB6194B4D", hash_generated_method = "15A55A4E1903315B16513C4B7A558A12")
    public MenuItem setCheckable(boolean checkable) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_933408639 = null; 
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        {
            mMenu.onItemsChanged(false);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_933408639 = this;
        varB4EAC82CA7396A68D541C85D26508E83_933408639.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_933408639;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.501 -0400", hash_original_method = "D48B0A4B4830ACC112B29145FA304FB9", hash_generated_method = "72956FA378A284989864C014D06C7B79")
    public void setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.503 -0400", hash_original_method = "09CA122F8C23D0DDA91200023A557A5D", hash_generated_method = "3AF3D847F9A05CD1A2F92249369BE389")
    public boolean isExclusiveCheckable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_521623605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_521623605;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.504 -0400", hash_original_method = "153A3CA3675B13C11B20504065FC3BF7", hash_generated_method = "CF416FE0F1BCA8E070A78991E99435C9")
    public boolean isChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_152582781 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_152582781;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.506 -0400", hash_original_method = "9107E25FB1CB75DAB92AC94A4D8833A7", hash_generated_method = "7297E2AB1A7D2EE186DDAC94747F5C88")
    public MenuItem setChecked(boolean checked) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_867836570 = null; 
        {
            mMenu.setExclusiveItemChecked(this);
        } 
        {
            setCheckedInt(checked);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_867836570 = this;
        addTaint(checked);
        varB4EAC82CA7396A68D541C85D26508E83_867836570.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_867836570;
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.508 -0400", hash_original_method = "F4E3FA5EA691BD61029F7B342451D96B", hash_generated_method = "26B6707CAE85620A8D6095D83C01EA56")
     void setCheckedInt(boolean checked) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        {
            mMenu.onItemsChanged(false);
        } 
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.510 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "298E8FCBDC3EB4D97CD285F0C264EAC3")
    public boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856567321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856567321;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.511 -0400", hash_original_method = "6BBB65AE1F8C0F9A0552DC908B4D29C9", hash_generated_method = "6A1C5EDBB5D885D99866C3672D07B140")
     boolean setVisibleInt(boolean shown) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_250128097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_250128097;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.512 -0400", hash_original_method = "C575291A3325EE507AB9F55E92185E54", hash_generated_method = "B63BA738070F1BE9A094A7FB125E4A8F")
    public MenuItem setVisible(boolean shown) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2054509759 = null; 
        {
            boolean var888A88BADDB15852039C5C93445B7B9E_315548339 = (setVisibleInt(shown));
            mMenu.onItemVisibleChanged(this);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2054509759 = this;
        addTaint(shown);
        varB4EAC82CA7396A68D541C85D26508E83_2054509759.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2054509759;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.513 -0400", hash_original_method = "1DDD55F9AC5A73432BCD73A94619FD45", hash_generated_method = "1B9386801E94D9C675C07F633C72EA3A")
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_985561201 = null; 
        mClickListener = clickListener;
        varB4EAC82CA7396A68D541C85D26508E83_985561201 = this;
        varB4EAC82CA7396A68D541C85D26508E83_985561201.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_985561201;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.513 -0400", hash_original_method = "233A3AFEB21203525FBA5B1CF441183E", hash_generated_method = "45F9B780CB579C3C2A070B418581884E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1533659890 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1533659890 = mTitle.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1533659890.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1533659890;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.514 -0400", hash_original_method = "B6421912A15ECCB29CB28DC744FEB4DF", hash_generated_method = "48D720FE3E7BA870AFBD08C536357B9E")
     void setMenuInfo(ContextMenuInfo menuInfo) {
        mMenuInfo = menuInfo;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.515 -0400", hash_original_method = "A0E326FAE2703231717DF34591A2C639", hash_generated_method = "8E9C9BFBA3459084DB45899FE103266B")
    public ContextMenuInfo getMenuInfo() {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_799794578 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_799794578 = mMenuInfo;
        varB4EAC82CA7396A68D541C85D26508E83_799794578.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_799794578;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.515 -0400", hash_original_method = "221F1892BBAF0D6C0448BF9B80F29C7C", hash_generated_method = "AA105CD9041C087568465B6F262D8004")
    public void actionFormatChanged() {
        mMenu.onItemActionRequestChanged(this);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.516 -0400", hash_original_method = "B7358CCF217D02273B220AA1E4900E11", hash_generated_method = "E46DDD362CFF0707AFAF1C4872FEA830")
    public boolean shouldShowIcon() {
        boolean var70F98333FA0948733960A5795635FA78_713933018 = (mMenu.getOptionalIconsVisible());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710937136 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_710937136;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.516 -0400", hash_original_method = "8639B741C99124BF9C4FC28DBCA735D7", hash_generated_method = "D26B28797B2EAA47BAE34B4E9538779F")
    public boolean isActionButton() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856371505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856371505;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.517 -0400", hash_original_method = "D20AA9738309FEFC21F93C6653D8A4BB", hash_generated_method = "5787F6C571C6186F6BD0D9E8FFFAD2BC")
    public boolean requestsActionButton() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1508091715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1508091715;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.517 -0400", hash_original_method = "A0218090F414AFC2516DB1AFD001E557", hash_generated_method = "0A6E11C78ECC59AE99CC25C5A998B9B3")
    public boolean requiresActionButton() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968600858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968600858;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.518 -0400", hash_original_method = "7A64484A152776341109FA7C71AB82BB", hash_generated_method = "DA27F71957BEDA7B0193232ADA4F4B91")
    public void setIsActionButton(boolean isActionButton) {
        {
            mFlags |= IS_ACTION;
        } 
        {
            mFlags &= ~IS_ACTION;
        } 
        addTaint(isActionButton);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.518 -0400", hash_original_method = "D19EFCF4D4C49A6F9A7B8D6E601DFE3B", hash_generated_method = "B0C78C9718105DD4EFAE7BEC2779F2F1")
    public boolean showsTextAsAction() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1844500432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1844500432;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.518 -0400", hash_original_method = "6034AD3E3F15BF95CED1827A99F9830A", hash_generated_method = "E8D8563084B1CC50260BAE003759E5BE")
    public void setShowAsAction(int actionEnum) {
        
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM,"
                        + " and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        
        mShowAsAction = actionEnum;
        mMenu.onItemActionRequestChanged(this);
        
        
            
            
            
                
            
                
                        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.520 -0400", hash_original_method = "9511E068798AA5E04A674F02DC2F7567", hash_generated_method = "937B8AF134F439AC36C83D289520B721")
    public MenuItem setActionView(View view) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1071146143 = null; 
        mActionView = view;
        mActionProvider = null;
        {
            boolean var9383E447CCD31AC0A55E5ECF75C1C296_255722000 = (view != null && view.getId() == View.NO_ID && mId > 0);
            {
                view.setId(mId);
            } 
        } 
        mMenu.onItemActionRequestChanged(this);
        varB4EAC82CA7396A68D541C85D26508E83_1071146143 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1071146143.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1071146143;
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.521 -0400", hash_original_method = "B057E2C488C14BC05DF25DD2F229F8B2", hash_generated_method = "F0041BE805D07F2A604E1AF8AECEF4EC")
    public MenuItem setActionView(int resId) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1188388945 = null; 
        final Context context = mMenu.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        varB4EAC82CA7396A68D541C85D26508E83_1188388945 = this;
        addTaint(resId);
        varB4EAC82CA7396A68D541C85D26508E83_1188388945.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1188388945;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.522 -0400", hash_original_method = "404D78F2C7005B21FAAA5C37E608175C", hash_generated_method = "2287AD5E9A141E5DFCAEAD360DE10F7A")
    public View getActionView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1138091411 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1607460434 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1918676634 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1138091411 = mActionView;
        } 
        {
            mActionView = mActionProvider.onCreateActionView();
            varB4EAC82CA7396A68D541C85D26508E83_1607460434 = mActionView;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1918676634 = null;
        } 
        View varA7E53CE21691AB073D9660D615818899_199369385; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_199369385 = varB4EAC82CA7396A68D541C85D26508E83_1138091411;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_199369385 = varB4EAC82CA7396A68D541C85D26508E83_1607460434;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_199369385 = varB4EAC82CA7396A68D541C85D26508E83_1918676634;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_199369385.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_199369385;
        
        
            
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.522 -0400", hash_original_method = "F6993BB94930E20BEF3D6DE6883E2D9B", hash_generated_method = "1FBCAE670730215312FD975B8F1201E2")
    public ActionProvider getActionProvider() {
        ActionProvider varB4EAC82CA7396A68D541C85D26508E83_1707416262 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1707416262 = mActionProvider;
        varB4EAC82CA7396A68D541C85D26508E83_1707416262.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1707416262;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.523 -0400", hash_original_method = "C59B6F24EC844FBD609E594809339FFA", hash_generated_method = "0D5A884D7AD91C7AD8F7B834E3410838")
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_887482624 = null; 
        mActionView = null;
        mActionProvider = actionProvider;
        mMenu.onItemsChanged(true);
        varB4EAC82CA7396A68D541C85D26508E83_887482624 = this;
        varB4EAC82CA7396A68D541C85D26508E83_887482624.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_887482624;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.524 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "10C2E5D47CAC77E33FAA3244B5B15B7D")
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_660590526 = null; 
        setShowAsAction(actionEnum);
        varB4EAC82CA7396A68D541C85D26508E83_660590526 = this;
        addTaint(actionEnum);
        varB4EAC82CA7396A68D541C85D26508E83_660590526.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_660590526;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.525 -0400", hash_original_method = "9242B1434B9CD0ACB88D22E492AB3A81", hash_generated_method = "FF72BB34EBB361D4727EBE44C4BDA1FC")
    @Override
    public boolean expandActionView() {
        {
            boolean var81D84D08096DF9E1FCCD4F85A3884372_2030986166 = (mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionExpand(this));
            {
                boolean var38AC753AE765E96CBE659CBBA5A8A723_430723161 = (mMenu.expandItemActionView(this));
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_976458352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_976458352;
        
        
            
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.525 -0400", hash_original_method = "DB0EB37C3626C85F2C23377923AB6063", hash_generated_method = "C84A0F12DDE4A361D30D3846F108632C")
    @Override
    public boolean collapseActionView() {
        {
            boolean varA0F65C9905152D79B43E3C0EEE82344B_1855636183 = (mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionCollapse(this));
            {
                boolean var690A803F41D0DAB576A6FB2B9FAC7EC4_2014460126 = (mMenu.collapseItemActionView(this));
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1787808517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1787808517;
        
        
            
        
        
            
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.529 -0400", hash_original_method = "B1FCAF7D5B88EED4E84E6E84EBEC9EE4", hash_generated_method = "F887F8A8BA472EA41E778F3C502D8D3B")
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1696237698 = null; 
        mOnActionExpandListener = listener;
        varB4EAC82CA7396A68D541C85D26508E83_1696237698 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1696237698.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1696237698;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.530 -0400", hash_original_method = "DAFC43ECD0E5D06566AA28ACE3B5E472", hash_generated_method = "8936DD0AE12EB71CE2DA35D4E3406EDA")
    public boolean hasCollapsibleActionView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_520746924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_520746924;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.531 -0400", hash_original_method = "A7B0C8C0A6B0446C22F6521CC0C60064", hash_generated_method = "407D942D4124D9AF1A9CE9B210935DCE")
    public void setActionViewExpanded(boolean isExpanded) {
        mIsActionViewExpanded = isExpanded;
        mMenu.onItemsChanged(false);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.532 -0400", hash_original_method = "618A94DE2810D1D688B3A7F878D1125A", hash_generated_method = "5E67AF9FD6EA370185A3D94AF049F577")
    public boolean isActionViewExpanded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587076051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_587076051;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.532 -0400", hash_original_field = "25C064051816B881687ECD14B4BCA369", hash_generated_field = "8A8FA0202935EA55AD54CD7CFED45C98")

    private static final String TAG = "MenuItemImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.532 -0400", hash_original_field = "4853419C3DE5BA7DDAE9908E29DAA2CD", hash_generated_field = "11894259A35F1BBB9E7F27DD18921EDE")

    private static final int SHOW_AS_ACTION_MASK = SHOW_AS_ACTION_NEVER |
            SHOW_AS_ACTION_IF_ROOM |
            SHOW_AS_ACTION_ALWAYS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "44D8ACA63E51B6F3484CCFC3C401596B", hash_generated_field = "943315568AC97A95BEE7FD4A533D08C8")

    private static final int CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "AA8FA6BAC5A05627B79C947C0D232729", hash_generated_field = "79E18373E7678760190793C5FAA4E940")

    private static final int CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "4BD83E56EE2A97900ECC9A6A8944AED1", hash_generated_field = "80F27CAAB6801F818B589E02F88FCA4D")

    private static final int EXCLUSIVE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "9C15CE115096770F474A2620CC59E12C", hash_generated_field = "14D725A9241DDEAEF12149E98726A5C2")

    private static final int HIDDEN = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "DF3D10857D57E28E203991699F280170", hash_generated_field = "9D7A6896B452AD15AEC725047E2938A0")

    private static final int ENABLED = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "C13DDE3EDD00011B2AF4BB6C84FA15EF", hash_generated_field = "C127B9B1DB91997F1F1D61DE17C3AF8E")

    private static final int IS_ACTION = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "3DA77B226EB38F673406BB1FC10EE04A", hash_generated_field = "3EDC205933905E009C1CD4D66D782972")

    static final int NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "3610FD0730E1C31E028C448BDFDCFC99", hash_generated_field = "FC531438BE18962F76B22C0A35F07352")

    private static String sPrependShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "2CB65CBD30CCC1E5D6CABB5A16183588", hash_generated_field = "DF49530CB048FF09160A19CF46D02A0E")

    private static String sEnterShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "0CB32DA7DEC1629C84A2E3AFD8E4445A", hash_generated_field = "E00B0A704D720C24AE1BBC26B39D8B85")

    private static String sDeleteShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.533 -0400", hash_original_field = "8271EB0483099BFFDF8EDE47E409B11D", hash_generated_field = "9D3B92E22BB5269C378158F8ED50B0E4")

    private static String sSpaceShortcutLabel;
}

