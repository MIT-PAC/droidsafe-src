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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private int mGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "B75BDC891F05DF8D9F77776476EBCDD6", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private int mCategoryOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "CCC67011C0B9AB1BA64ACA217793FF17", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private int mOrdering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "793CD2D3A29DBCA3B6EE3D2D5CF29A55", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "5CA918862E899FBE57CD8F3D0DB44604", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "FAC611210B68F831D4A3B699FB58A971", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "EF18AFCEFBAD21F6B816E931AD814543", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "37AC3635461CA62872231C85492F3A9C", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.766 -0400", hash_original_field = "C7443C6F6983E9AE465DCA4986300561", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")

    private MenuItem.OnMenuItemClickListener mClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.767 -0400", hash_original_field = "25DDE236B20D5D6403355424CC7CFB83", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.767 -0400", hash_original_method = "ABBA9423D74CB077EE46D2E3EFD8A9A3", hash_generated_method = "2B1848CDC73B1B0F61B0B979382F628F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.767 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "3DE3FE5FEAB0A5F3AC382DE029D4DD9E")
    public char getAlphabeticShortcut() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1495874068 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1495874068;
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.767 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "E037A8029A987C97D41AEA44AAD7AE44")
    public int getGroupId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390073911 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390073911;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.768 -0400", hash_original_method = "E45C59E22635FD55A8824D390FC98A96", hash_generated_method = "F23AF6F9E2AC2C626DB7943AB5F862BB")
    public Drawable getIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_668490172 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_668490172 = mIconDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_668490172.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_668490172;
        // ---------- Original Method ----------
        //return mIconDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.768 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "3D294C14DC3C9722DC252607C6C7C7F3")
    public Intent getIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_87948168 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_87948168 = mIntent;
        varB4EAC82CA7396A68D541C85D26508E83_87948168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_87948168;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.768 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "52208ED7931279F9A26BB2BE1EE144B8")
    public int getItemId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983660147 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983660147;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.769 -0400", hash_original_method = "D505DD9DA217AD48C3FB7728B16EAF3B", hash_generated_method = "A3FB98712BD517587ADD5BDF02AA2E00")
    public ContextMenuInfo getMenuInfo() {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_1426568066 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1426568066 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1426568066.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1426568066;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.769 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "D4CDAF4A59ACF96200BFBFF49244DD60")
    public char getNumericShortcut() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1864545772 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1864545772;
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.769 -0400", hash_original_method = "FF535D1B11FC0F0766CD26B9FF10F186", hash_generated_method = "B885AE3AF2684E4AB5914E8F5AAAA7F3")
    public int getOrder() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412385757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412385757;
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.769 -0400", hash_original_method = "772A0AA7AD2F04B178AEEA64C07E8BF0", hash_generated_method = "CE52F70570C37A7744C664FFEA26E45B")
    public SubMenu getSubMenu() {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_200321391 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_200321391 = null;
        varB4EAC82CA7396A68D541C85D26508E83_200321391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_200321391;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.770 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "5EDC849E7C75AE0B61302F3316662354")
    public CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1402552556 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1402552556 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_1402552556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1402552556;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.770 -0400", hash_original_method = "AE18A80D188B13895AC76378DAF3976F", hash_generated_method = "99ADC682B22CEB81047213141E40C353")
    public CharSequence getTitleCondensed() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1486891518 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1486891518 = mTitleCondensed;
        varB4EAC82CA7396A68D541C85D26508E83_1486891518.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1486891518;
        // ---------- Original Method ----------
        //return mTitleCondensed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.771 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "A78BEE6F6922395F1CA2C79A65916572")
    public boolean hasSubMenu() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_893039634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_893039634;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.771 -0400", hash_original_method = "ED15661074DADD4461D34783FBB8C8E2", hash_generated_method = "C36D27A156A86B79A36065F5A0DFF452")
    public boolean isCheckable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763851539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763851539;
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.772 -0400", hash_original_method = "76E21D72539001F6EF2A57161392D665", hash_generated_method = "949CCA9981F87C9B37C6CE93B7711B70")
    public boolean isChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_275279918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_275279918;
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.772 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "995BE0BBAF368C23DDED9FBAC5A69B06")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870442641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870442641;
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.773 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "A83625A37CBCFFAB037C24742404C3B9")
    public boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1348709684 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1348709684;
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.774 -0400", hash_original_method = "7379DA8B69266F5EBF9FDADEBDD8B3A5", hash_generated_method = "A4C8A001533261E2E9A91D88EB7BB93C")
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1640447789 = null; //Variable for return #1
        mShortcutAlphabeticChar = alphaChar;
        varB4EAC82CA7396A68D541C85D26508E83_1640447789 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1640447789.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1640447789;
        // ---------- Original Method ----------
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.775 -0400", hash_original_method = "00566BB0E7762EC9407CFB205264961E", hash_generated_method = "D188266AB37A7F056D8BE58E007195D9")
    public MenuItem setCheckable(boolean checkable) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2146880706 = null; //Variable for return #1
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        varB4EAC82CA7396A68D541C85D26508E83_2146880706 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2146880706.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2146880706;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.776 -0400", hash_original_method = "38C8FF82F2D3210CC276B1181111BFDA", hash_generated_method = "FCFDCA113795228BB823E0E4E9F0903B")
    public ActionMenuItem setExclusiveCheckable(boolean exclusive) {
        ActionMenuItem varB4EAC82CA7396A68D541C85D26508E83_1877431677 = null; //Variable for return #1
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        varB4EAC82CA7396A68D541C85D26508E83_1877431677 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1877431677.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1877431677;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.777 -0400", hash_original_method = "5A966E6072519B52A8CEABF5F32ED38A", hash_generated_method = "7FBA222A5ED28A9B9EFF21D32B143B3D")
    public MenuItem setChecked(boolean checked) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1823975676 = null; //Variable for return #1
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        varB4EAC82CA7396A68D541C85D26508E83_1823975676 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1823975676.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1823975676;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.778 -0400", hash_original_method = "3B4A922D22D692F4E29B7172DE89A0AD", hash_generated_method = "96C4FDA348970A66FFD91DF23BDE24EF")
    public MenuItem setEnabled(boolean enabled) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1952222296 = null; //Variable for return #1
        mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        varB4EAC82CA7396A68D541C85D26508E83_1952222296 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1952222296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1952222296;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.779 -0400", hash_original_method = "F52277830906BCEFECA5EA80235FDCAB", hash_generated_method = "CA1F37B513D7A1BD9523F2F8F91C51FC")
    public MenuItem setIcon(Drawable icon) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1048672584 = null; //Variable for return #1
        mIconDrawable = icon;
        mIconResId = NO_ICON;
        varB4EAC82CA7396A68D541C85D26508E83_1048672584 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1048672584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1048672584;
        // ---------- Original Method ----------
        //mIconDrawable = icon;
        //mIconResId = NO_ICON;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.780 -0400", hash_original_method = "5010B90C9AB4414DB888D97ADDAE2333", hash_generated_method = "99E8BBAF85D229A06B8B366206EAB24E")
    public MenuItem setIcon(int iconRes) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1703151219 = null; //Variable for return #1
        mIconResId = iconRes;
        mIconDrawable = mContext.getResources().getDrawable(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_1703151219 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1703151219.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1703151219;
        // ---------- Original Method ----------
        //mIconResId = iconRes;
        //mIconDrawable = mContext.getResources().getDrawable(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.780 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "59FC10EF3C0958884316453F281B8EDF")
    public MenuItem setIntent(Intent intent) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1328619044 = null; //Variable for return #1
        mIntent = intent;
        varB4EAC82CA7396A68D541C85D26508E83_1328619044 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1328619044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1328619044;
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.781 -0400", hash_original_method = "1F2FCA18D7E58148E8935254347BE744", hash_generated_method = "D7A1027E1C8C86CBFB4E9B91DEF37E79")
    public MenuItem setNumericShortcut(char numericChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1114945300 = null; //Variable for return #1
        mShortcutNumericChar = numericChar;
        varB4EAC82CA7396A68D541C85D26508E83_1114945300 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1114945300.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1114945300;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.783 -0400", hash_original_method = "6601271ADD9A6C6B3D832752A2C4336F", hash_generated_method = "F448E04BE932BCA568F8CCC6C2A6AAD9")
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1174987062 = null; //Variable for return #1
        mClickListener = menuItemClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_1174987062 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1174987062.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1174987062;
        // ---------- Original Method ----------
        //mClickListener = menuItemClickListener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.783 -0400", hash_original_method = "656EFF8CD4994CD73006E38A783E9B74", hash_generated_method = "23C7EF3805E8325639A78BAF23C8A38D")
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2042882566 = null; //Variable for return #1
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = alphaChar;
        varB4EAC82CA7396A68D541C85D26508E83_2042882566 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2042882566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2042882566;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.784 -0400", hash_original_method = "E3AEA6168BB1F22DFC2A4192F0EFD72E", hash_generated_method = "6426E35207624BFA7AE266DE918BA136")
    public MenuItem setTitle(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2132293 = null; //Variable for return #1
        mTitle = title;
        varB4EAC82CA7396A68D541C85D26508E83_2132293 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2132293.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2132293;
        // ---------- Original Method ----------
        //mTitle = title;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.785 -0400", hash_original_method = "93E35E6A1799E092E053E5DD222DC093", hash_generated_method = "14CD93D3D45BFCB66FD54E3B524E746A")
    public MenuItem setTitle(int title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1355347646 = null; //Variable for return #1
        mTitle = mContext.getResources().getString(title);
        varB4EAC82CA7396A68D541C85D26508E83_1355347646 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1355347646.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1355347646;
        // ---------- Original Method ----------
        //mTitle = mContext.getResources().getString(title);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.785 -0400", hash_original_method = "DC9EFDDD12206C16928994FD6B9EA83A", hash_generated_method = "A294F0C223164899645388F8CB1DC6D7")
    public MenuItem setTitleCondensed(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_89112658 = null; //Variable for return #1
        mTitleCondensed = title;
        varB4EAC82CA7396A68D541C85D26508E83_89112658 = this;
        varB4EAC82CA7396A68D541C85D26508E83_89112658.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_89112658;
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.786 -0400", hash_original_method = "6A802D7132DF936AE104E3A9B00DB973", hash_generated_method = "602AD0264E8CB26B693BA242FD9FD25D")
    public MenuItem setVisible(boolean visible) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1611744340 = null; //Variable for return #1
        mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        varB4EAC82CA7396A68D541C85D26508E83_1611744340 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1611744340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1611744340;
        // ---------- Original Method ----------
        //mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.786 -0400", hash_original_method = "AA032C02BB6C3B5A9CA83C7C80BC2006", hash_generated_method = "343B986C60A2E511A1485E9332185401")
    public boolean invoke() {
        {
            boolean var891D05C799AF985A1D37CA302BA21D09_333331576 = (mClickListener != null && mClickListener.onMenuItemClick(this));
        } //End collapsed parenthetic
        {
            mContext.startActivity(mIntent);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256915605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256915605;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.786 -0400", hash_original_method = "7271F034C654DB6347336274A9D03801", hash_generated_method = "B653C2950442B0D58FDD376972B81792")
    public void setShowAsAction(int show) {
        addTaint(show);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.787 -0400", hash_original_method = "493F4A0F304908668D2BEC1F7D0E334B", hash_generated_method = "BA08ADEE346BC051C6218CEDE04E3807")
    public MenuItem setActionView(View actionView) {
    	throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.787 -0400", hash_original_method = "DDC728D00ABE6AC1AC6555673541B67E", hash_generated_method = "86A2ED3F6502B70A709B51125C20F2DF")
    public View getActionView() {
        View varB4EAC82CA7396A68D541C85D26508E83_290432853 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_290432853 = null;
        varB4EAC82CA7396A68D541C85D26508E83_290432853.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_290432853;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.788 -0400", hash_original_method = "38A20BA0D11F10392D85500804B1A43F", hash_generated_method = "448A9257775AF5F62A7776AE4EE1E431")
    @Override
    public MenuItem setActionView(int resId) {
    	throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.788 -0400", hash_original_method = "FE44B196FF60CED75746223A767C8615", hash_generated_method = "9863E8874B31E84E78C2FCFB4A09F1D0")
    @Override
    public ActionProvider getActionProvider() {
        ActionProvider varB4EAC82CA7396A68D541C85D26508E83_25676335 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_25676335 = null;
        varB4EAC82CA7396A68D541C85D26508E83_25676335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_25676335;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.789 -0400", hash_original_method = "4ABFFD9ECFCE20F6052063E7AA9E942A", hash_generated_method = "49BE8A6BA2F3F3547E77B8CDDDCF7D34")
    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
    	throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.789 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "40FDC53F215DDB4D0C2A618F3BFDD903")
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1062086624 = null; //Variable for return #1
        setShowAsAction(actionEnum);
        varB4EAC82CA7396A68D541C85D26508E83_1062086624 = this;
        addTaint(actionEnum);
        varB4EAC82CA7396A68D541C85D26508E83_1062086624.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1062086624;
        // ---------- Original Method ----------
        //setShowAsAction(actionEnum);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.789 -0400", hash_original_method = "E3EFEFBDC234312A7FEC732911F191DE", hash_generated_method = "235970D7AB5DEFCA75DACF12B5503CB7")
    @Override
    public boolean expandActionView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_35793286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_35793286;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.790 -0400", hash_original_method = "A369693BDACA70A4B3FDAADB36135262", hash_generated_method = "419A2A6D984EF765AE075AC27193E6D2")
    @Override
    public boolean collapseActionView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1456065903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1456065903;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.790 -0400", hash_original_method = "6EAD6F9611A0523E2504074954E6B02A", hash_generated_method = "A20BE7A94849AA4062B914C3107CFF59")
    @Override
    public boolean isActionViewExpanded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531307401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531307401;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.790 -0400", hash_original_method = "DC2EA5E6DB4BFE29B2697085EABCD856", hash_generated_method = "C760CD09FD1106821598F27251EBE42C")
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_914320809 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_914320809 = this;
        addTaint(listener.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_914320809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_914320809;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.790 -0400", hash_original_field = "3DA77B226EB38F673406BB1FC10EE04A", hash_generated_field = "D79E3C9C1DA0C971841E3A3F777DEEAC")

    private static final int NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.790 -0400", hash_original_field = "44D8ACA63E51B6F3484CCFC3C401596B", hash_generated_field = "943315568AC97A95BEE7FD4A533D08C8")

    private static final int CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.791 -0400", hash_original_field = "AA8FA6BAC5A05627B79C947C0D232729", hash_generated_field = "79E18373E7678760190793C5FAA4E940")

    private static final int CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.791 -0400", hash_original_field = "4BD83E56EE2A97900ECC9A6A8944AED1", hash_generated_field = "80F27CAAB6801F818B589E02F88FCA4D")

    private static final int EXCLUSIVE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.791 -0400", hash_original_field = "9C15CE115096770F474A2620CC59E12C", hash_generated_field = "14D725A9241DDEAEF12149E98726A5C2")

    private static final int HIDDEN = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.791 -0400", hash_original_field = "DF3D10857D57E28E203991699F280170", hash_generated_field = "9D7A6896B452AD15AEC725047E2938A0")

    private static final int ENABLED = 0x00000010;
}

