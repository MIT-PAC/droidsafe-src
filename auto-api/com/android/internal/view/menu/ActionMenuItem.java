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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private int mGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "B75BDC891F05DF8D9F77776476EBCDD6", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private int mCategoryOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "CCC67011C0B9AB1BA64ACA217793FF17", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private int mOrdering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "793CD2D3A29DBCA3B6EE3D2D5CF29A55", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "5CA918862E899FBE57CD8F3D0DB44604", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "FAC611210B68F831D4A3B699FB58A971", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "EF18AFCEFBAD21F6B816E931AD814543", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "37AC3635461CA62872231C85492F3A9C", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.856 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.857 -0400", hash_original_field = "C7443C6F6983E9AE465DCA4986300561", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")

    private MenuItem.OnMenuItemClickListener mClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.857 -0400", hash_original_field = "25DDE236B20D5D6403355424CC7CFB83", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.857 -0400", hash_original_method = "ABBA9423D74CB077EE46D2E3EFD8A9A3", hash_generated_method = "2B1848CDC73B1B0F61B0B979382F628F")
    public  ActionMenuItem(Context context, int group, int id, int categoryOrder, int ordering,
            CharSequence title) {
        mContext = context;
        mId = id;
        mGroup = group;
        mCategoryOrder = categoryOrder;
        mOrdering = ordering;
        mTitle = title;
        // ---------- Original Method ----------
        //mContext = context;
        //mId = id;
        //mGroup = group;
        //mCategoryOrder = categoryOrder;
        //mOrdering = ordering;
        //mTitle = title;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.857 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "B17928CFC3F0B1F0B1587D97E36484F4")
    public char getAlphabeticShortcut() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1140318025 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1140318025;
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.858 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "D9FD265AA3625AA1AFEDE72BB4C9DE02")
    public int getGroupId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179075928 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179075928;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.858 -0400", hash_original_method = "E45C59E22635FD55A8824D390FC98A96", hash_generated_method = "139921DF654B0FCF9DD06B8151E0387B")
    public Drawable getIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1103514303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1103514303 = mIconDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_1103514303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1103514303;
        // ---------- Original Method ----------
        //return mIconDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.875 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "9FCC217E157AB66D83A4C2C5FEE9C871")
    public Intent getIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2068956146 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2068956146 = mIntent;
        varB4EAC82CA7396A68D541C85D26508E83_2068956146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2068956146;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.876 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "A98F5A9E617FCB532B4F8A23C1D478A3")
    public int getItemId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1685710702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1685710702;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.877 -0400", hash_original_method = "D505DD9DA217AD48C3FB7728B16EAF3B", hash_generated_method = "863AEF227D9A116BC14C792AE59AABB0")
    public ContextMenuInfo getMenuInfo() {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_1448970436 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1448970436 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1448970436.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1448970436;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.877 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "418712C7303872574E97FB99E76F5362")
    public char getNumericShortcut() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1329172318 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1329172318;
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.878 -0400", hash_original_method = "FF535D1B11FC0F0766CD26B9FF10F186", hash_generated_method = "0C25FC06F08D96899B5EC6833A8BABB4")
    public int getOrder() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914199326 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914199326;
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.878 -0400", hash_original_method = "772A0AA7AD2F04B178AEEA64C07E8BF0", hash_generated_method = "A444ED37B96662B7D74C8DB977A701F1")
    public SubMenu getSubMenu() {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1200169208 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1200169208 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1200169208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1200169208;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.890 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "0D005A716A3A8F84F56EFCE220901D5E")
    public CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_316109493 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_316109493 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_316109493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_316109493;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.890 -0400", hash_original_method = "AE18A80D188B13895AC76378DAF3976F", hash_generated_method = "9CCD573A6EE1EEC4EC4CC3C296A30E4E")
    public CharSequence getTitleCondensed() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_443128932 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_443128932 = mTitleCondensed;
        varB4EAC82CA7396A68D541C85D26508E83_443128932.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_443128932;
        // ---------- Original Method ----------
        //return mTitleCondensed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.891 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "6DEED727D6C37997FFCB445C856B0DEA")
    public boolean hasSubMenu() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724940583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_724940583;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.891 -0400", hash_original_method = "ED15661074DADD4461D34783FBB8C8E2", hash_generated_method = "51311AC0A175735353672526EFD6580A")
    public boolean isCheckable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803023481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_803023481;
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.891 -0400", hash_original_method = "76E21D72539001F6EF2A57161392D665", hash_generated_method = "EF0342E4FB9C6D22590313185A5B3F5D")
    public boolean isChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1878958211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1878958211;
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.914 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "2F6D9F21089AAEE9EE225F809440B3BD")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1636770744 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1636770744;
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.914 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "187CEA9A0A9AB3E411A11FEB4DC508D0")
    public boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1124352136 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1124352136;
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.915 -0400", hash_original_method = "7379DA8B69266F5EBF9FDADEBDD8B3A5", hash_generated_method = "09B4384742F761C28F9AA65E23D746BC")
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1112687145 = null; //Variable for return #1
        mShortcutAlphabeticChar = alphaChar;
        varB4EAC82CA7396A68D541C85D26508E83_1112687145 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1112687145.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1112687145;
        // ---------- Original Method ----------
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.916 -0400", hash_original_method = "00566BB0E7762EC9407CFB205264961E", hash_generated_method = "10C88E6F548BC5518DB903F9E846ED47")
    public MenuItem setCheckable(boolean checkable) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1334603244 = null; //Variable for return #1
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        varB4EAC82CA7396A68D541C85D26508E83_1334603244 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1334603244.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1334603244;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.916 -0400", hash_original_method = "38C8FF82F2D3210CC276B1181111BFDA", hash_generated_method = "4ECD5882EFF026A7E43A271E8FB00943")
    public ActionMenuItem setExclusiveCheckable(boolean exclusive) {
        ActionMenuItem varB4EAC82CA7396A68D541C85D26508E83_1389370967 = null; //Variable for return #1
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        varB4EAC82CA7396A68D541C85D26508E83_1389370967 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1389370967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1389370967;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.937 -0400", hash_original_method = "5A966E6072519B52A8CEABF5F32ED38A", hash_generated_method = "21291EAF8A9AFA628794E2E12B4FD12C")
    public MenuItem setChecked(boolean checked) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_42724282 = null; //Variable for return #1
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        varB4EAC82CA7396A68D541C85D26508E83_42724282 = this;
        varB4EAC82CA7396A68D541C85D26508E83_42724282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_42724282;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.938 -0400", hash_original_method = "3B4A922D22D692F4E29B7172DE89A0AD", hash_generated_method = "3950F3FFFB184330A6266E92E5CCE67E")
    public MenuItem setEnabled(boolean enabled) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_168533140 = null; //Variable for return #1
        mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        varB4EAC82CA7396A68D541C85D26508E83_168533140 = this;
        varB4EAC82CA7396A68D541C85D26508E83_168533140.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_168533140;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.939 -0400", hash_original_method = "F52277830906BCEFECA5EA80235FDCAB", hash_generated_method = "471EA25488403A0DC19F9AEFEE47A9FB")
    public MenuItem setIcon(Drawable icon) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_582197100 = null; //Variable for return #1
        mIconDrawable = icon;
        mIconResId = NO_ICON;
        varB4EAC82CA7396A68D541C85D26508E83_582197100 = this;
        varB4EAC82CA7396A68D541C85D26508E83_582197100.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_582197100;
        // ---------- Original Method ----------
        //mIconDrawable = icon;
        //mIconResId = NO_ICON;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.941 -0400", hash_original_method = "5010B90C9AB4414DB888D97ADDAE2333", hash_generated_method = "095D21F77D227F014FA35DEC03846DF8")
    public MenuItem setIcon(int iconRes) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_379511510 = null; //Variable for return #1
        mIconResId = iconRes;
        mIconDrawable = mContext.getResources().getDrawable(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_379511510 = this;
        varB4EAC82CA7396A68D541C85D26508E83_379511510.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_379511510;
        // ---------- Original Method ----------
        //mIconResId = iconRes;
        //mIconDrawable = mContext.getResources().getDrawable(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.960 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "A984D88A3E8F8AF047C958177F36D64D")
    public MenuItem setIntent(Intent intent) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_514658694 = null; //Variable for return #1
        mIntent = intent;
        varB4EAC82CA7396A68D541C85D26508E83_514658694 = this;
        varB4EAC82CA7396A68D541C85D26508E83_514658694.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_514658694;
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.971 -0400", hash_original_method = "1F2FCA18D7E58148E8935254347BE744", hash_generated_method = "662DD8273987174B003C21DCEF8B3D01")
    public MenuItem setNumericShortcut(char numericChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1883881780 = null; //Variable for return #1
        mShortcutNumericChar = numericChar;
        varB4EAC82CA7396A68D541C85D26508E83_1883881780 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1883881780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1883881780;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.973 -0400", hash_original_method = "6601271ADD9A6C6B3D832752A2C4336F", hash_generated_method = "27CDF4C2A95FA60CE84EAB8445021DEE")
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_195702363 = null; //Variable for return #1
        mClickListener = menuItemClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_195702363 = this;
        varB4EAC82CA7396A68D541C85D26508E83_195702363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_195702363;
        // ---------- Original Method ----------
        //mClickListener = menuItemClickListener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.978 -0400", hash_original_method = "656EFF8CD4994CD73006E38A783E9B74", hash_generated_method = "DB81FCB54DC664033A40CB006074F130")
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2132520691 = null; //Variable for return #1
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = alphaChar;
        varB4EAC82CA7396A68D541C85D26508E83_2132520691 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2132520691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2132520691;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.983 -0400", hash_original_method = "E3AEA6168BB1F22DFC2A4192F0EFD72E", hash_generated_method = "FD477657E5134F0CF05B832752A0DF52")
    public MenuItem setTitle(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1616235274 = null; //Variable for return #1
        mTitle = title;
        varB4EAC82CA7396A68D541C85D26508E83_1616235274 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1616235274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1616235274;
        // ---------- Original Method ----------
        //mTitle = title;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.984 -0400", hash_original_method = "93E35E6A1799E092E053E5DD222DC093", hash_generated_method = "E48C138C3EDD138426492423606CFC74")
    public MenuItem setTitle(int title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1763370004 = null; //Variable for return #1
        mTitle = mContext.getResources().getString(title);
        varB4EAC82CA7396A68D541C85D26508E83_1763370004 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1763370004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1763370004;
        // ---------- Original Method ----------
        //mTitle = mContext.getResources().getString(title);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.993 -0400", hash_original_method = "DC9EFDDD12206C16928994FD6B9EA83A", hash_generated_method = "F15C8307BF11373E67B7A13CD588CFDE")
    public MenuItem setTitleCondensed(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_838279679 = null; //Variable for return #1
        mTitleCondensed = title;
        varB4EAC82CA7396A68D541C85D26508E83_838279679 = this;
        varB4EAC82CA7396A68D541C85D26508E83_838279679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_838279679;
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.994 -0400", hash_original_method = "6A802D7132DF936AE104E3A9B00DB973", hash_generated_method = "11348D449655B1CDE59D24BEFB35E1D1")
    public MenuItem setVisible(boolean visible) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_449205563 = null; //Variable for return #1
        mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        varB4EAC82CA7396A68D541C85D26508E83_449205563 = this;
        varB4EAC82CA7396A68D541C85D26508E83_449205563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_449205563;
        // ---------- Original Method ----------
        //mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.994 -0400", hash_original_method = "AA032C02BB6C3B5A9CA83C7C80BC2006", hash_generated_method = "3E4013DB7B6F599D6E247350E7416639")
    public boolean invoke() {
        {
            boolean var891D05C799AF985A1D37CA302BA21D09_849264741 = (mClickListener != null && mClickListener.onMenuItemClick(this));
        } //End collapsed parenthetic
        {
            mContext.startActivity(mIntent);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104420646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104420646;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.994 -0400", hash_original_method = "7271F034C654DB6347336274A9D03801", hash_generated_method = "B653C2950442B0D58FDD376972B81792")
    public void setShowAsAction(int show) {
        addTaint(show);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.003 -0400", hash_original_method = "493F4A0F304908668D2BEC1F7D0E334B", hash_generated_method = "BA08ADEE346BC051C6218CEDE04E3807")
    public MenuItem setActionView(View actionView) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(actionView.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.003 -0400", hash_original_method = "DDC728D00ABE6AC1AC6555673541B67E", hash_generated_method = "DFA1687541C12DC1D2B379862CC3688E")
    public View getActionView() {
        View varB4EAC82CA7396A68D541C85D26508E83_230731116 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_230731116 = null;
        varB4EAC82CA7396A68D541C85D26508E83_230731116.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_230731116;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.020 -0400", hash_original_method = "38A20BA0D11F10392D85500804B1A43F", hash_generated_method = "448A9257775AF5F62A7776AE4EE1E431")
    @Override
    public MenuItem setActionView(int resId) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(resId);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.020 -0400", hash_original_method = "FE44B196FF60CED75746223A767C8615", hash_generated_method = "F0C7EEAB7A59EB7CC22EFB70002A66CE")
    @Override
    public ActionProvider getActionProvider() {
        ActionProvider varB4EAC82CA7396A68D541C85D26508E83_1297378101 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1297378101 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1297378101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1297378101;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.021 -0400", hash_original_method = "4ABFFD9ECFCE20F6052063E7AA9E942A", hash_generated_method = "49BE8A6BA2F3F3547E77B8CDDDCF7D34")
    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(actionProvider.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.021 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "25F68F134CC36E6AAA3279F9B5C1A213")
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_177175098 = null; //Variable for return #1
        setShowAsAction(actionEnum);
        varB4EAC82CA7396A68D541C85D26508E83_177175098 = this;
        addTaint(actionEnum);
        varB4EAC82CA7396A68D541C85D26508E83_177175098.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_177175098;
        // ---------- Original Method ----------
        //setShowAsAction(actionEnum);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.033 -0400", hash_original_method = "E3EFEFBDC234312A7FEC732911F191DE", hash_generated_method = "3EDDD5D9D709BB4D0E566478D2FBE826")
    @Override
    public boolean expandActionView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2012038235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2012038235;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.034 -0400", hash_original_method = "A369693BDACA70A4B3FDAADB36135262", hash_generated_method = "297C565C00724F559D24C4F5BE7DD63E")
    @Override
    public boolean collapseActionView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1468618836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1468618836;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.034 -0400", hash_original_method = "6EAD6F9611A0523E2504074954E6B02A", hash_generated_method = "1B51B83EB0E0CF88D83913B8EFC03DBA")
    @Override
    public boolean isActionViewExpanded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140536582 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140536582;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.035 -0400", hash_original_method = "DC2EA5E6DB4BFE29B2697085EABCD856", hash_generated_method = "4EE546D6DF9A0A94B4E67848D3E29CAC")
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_453486569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_453486569 = this;
        addTaint(listener.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_453486569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_453486569;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.035 -0400", hash_original_field = "3DA77B226EB38F673406BB1FC10EE04A", hash_generated_field = "BAB198D311D959669D5A182A98AEB956")

    private static int NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.035 -0400", hash_original_field = "44D8ACA63E51B6F3484CCFC3C401596B", hash_generated_field = "CF5C64A78A33C6C0B820D00EBAEA0E8C")

    private static int CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.035 -0400", hash_original_field = "AA8FA6BAC5A05627B79C947C0D232729", hash_generated_field = "411C8EC520AC74F640455BDE89EF2D9A")

    private static int CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.035 -0400", hash_original_field = "4BD83E56EE2A97900ECC9A6A8944AED1", hash_generated_field = "49D3CE30F0A77467706408512140A513")

    private static int EXCLUSIVE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.035 -0400", hash_original_field = "9C15CE115096770F474A2620CC59E12C", hash_generated_field = "19B01B6D2439A0ADD3907E2E58A77176")

    private static int HIDDEN = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.035 -0400", hash_original_field = "DF3D10857D57E28E203991699F280170", hash_generated_field = "E7D0E1C5A80CDDBE92E49AF457D7D219")

    private static int ENABLED = 0x00000010;
}

