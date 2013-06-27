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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.836 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.836 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private int mGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.836 -0400", hash_original_field = "B75BDC891F05DF8D9F77776476EBCDD6", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private int mCategoryOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.836 -0400", hash_original_field = "CCC67011C0B9AB1BA64ACA217793FF17", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private int mOrdering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.836 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.837 -0400", hash_original_field = "793CD2D3A29DBCA3B6EE3D2D5CF29A55", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.837 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.837 -0400", hash_original_field = "5CA918862E899FBE57CD8F3D0DB44604", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.837 -0400", hash_original_field = "FAC611210B68F831D4A3B699FB58A971", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.837 -0400", hash_original_field = "EF18AFCEFBAD21F6B816E931AD814543", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.837 -0400", hash_original_field = "37AC3635461CA62872231C85492F3A9C", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.837 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.837 -0400", hash_original_field = "C7443C6F6983E9AE465DCA4986300561", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")

    private MenuItem.OnMenuItemClickListener mClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.837 -0400", hash_original_field = "25DDE236B20D5D6403355424CC7CFB83", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.847 -0400", hash_original_method = "ABBA9423D74CB077EE46D2E3EFD8A9A3", hash_generated_method = "2B1848CDC73B1B0F61B0B979382F628F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.848 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "A85AA321A69D9BAEF809D13B24400DBB")
    public char getAlphabeticShortcut() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1381876405 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1381876405;
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.903 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "CF529B95F643E64813EED2E511CEE121")
    public int getGroupId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2043714533 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2043714533;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.903 -0400", hash_original_method = "E45C59E22635FD55A8824D390FC98A96", hash_generated_method = "6B37F932ABF0119982DC056EB55F2747")
    public Drawable getIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1093429347 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1093429347 = mIconDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_1093429347.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1093429347;
        // ---------- Original Method ----------
        //return mIconDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.903 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "C2F2C9D14D93EEBDD4A9B3FBDB0A0ADA")
    public Intent getIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1178180288 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1178180288 = mIntent;
        varB4EAC82CA7396A68D541C85D26508E83_1178180288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1178180288;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.904 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "849C95A73389C0759448AF0294E04F5A")
    public int getItemId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526789277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526789277;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.904 -0400", hash_original_method = "D505DD9DA217AD48C3FB7728B16EAF3B", hash_generated_method = "348A0A2D7DD39892DC3A94C8804E570A")
    public ContextMenuInfo getMenuInfo() {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_2040735345 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2040735345 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2040735345.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2040735345;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.904 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "317BED623E54B6871A73CBE3C6618089")
    public char getNumericShortcut() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_843692514 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_843692514;
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.904 -0400", hash_original_method = "FF535D1B11FC0F0766CD26B9FF10F186", hash_generated_method = "EA8E4D959F53C6C6B5F825CB85309529")
    public int getOrder() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1637512307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1637512307;
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.905 -0400", hash_original_method = "772A0AA7AD2F04B178AEEA64C07E8BF0", hash_generated_method = "EDA8610910EAC9D10BDDC631EEDF0085")
    public SubMenu getSubMenu() {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_2036096274 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2036096274 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2036096274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2036096274;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.906 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "7E4F20A8D22226D3AD0ADE9343D7B5D9")
    public CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_898020285 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_898020285 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_898020285.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_898020285;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.906 -0400", hash_original_method = "AE18A80D188B13895AC76378DAF3976F", hash_generated_method = "9169F7B2E59666AF92785D75D7DCE93D")
    public CharSequence getTitleCondensed() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1608645987 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1608645987 = mTitleCondensed;
        varB4EAC82CA7396A68D541C85D26508E83_1608645987.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1608645987;
        // ---------- Original Method ----------
        //return mTitleCondensed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.906 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "2743628FABD663DA759350EA35106503")
    public boolean hasSubMenu() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_603772048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_603772048;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.907 -0400", hash_original_method = "ED15661074DADD4461D34783FBB8C8E2", hash_generated_method = "F3115EF29B53435249CB0858BC3C59BC")
    public boolean isCheckable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_631568886 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_631568886;
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.907 -0400", hash_original_method = "76E21D72539001F6EF2A57161392D665", hash_generated_method = "D7458D9B4214DB533355CAA5FB88FCB1")
    public boolean isChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942116124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_942116124;
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.907 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "B61FC8960C99F78BBA34920BB13F6772")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_652188528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_652188528;
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.907 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "8078B48EDE3177D6A34E9229477A8A34")
    public boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1553671972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1553671972;
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.914 -0400", hash_original_method = "7379DA8B69266F5EBF9FDADEBDD8B3A5", hash_generated_method = "5193065E86E199CCDDBFD5A347A47C61")
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1128777090 = null; //Variable for return #1
        mShortcutAlphabeticChar = alphaChar;
        varB4EAC82CA7396A68D541C85D26508E83_1128777090 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1128777090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1128777090;
        // ---------- Original Method ----------
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.915 -0400", hash_original_method = "00566BB0E7762EC9407CFB205264961E", hash_generated_method = "38DE613C55C8F37B27200A871F96895B")
    public MenuItem setCheckable(boolean checkable) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1194081924 = null; //Variable for return #1
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        varB4EAC82CA7396A68D541C85D26508E83_1194081924 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1194081924.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1194081924;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.916 -0400", hash_original_method = "38C8FF82F2D3210CC276B1181111BFDA", hash_generated_method = "1666DEC778C0046BF7589B08B38BFA36")
    public ActionMenuItem setExclusiveCheckable(boolean exclusive) {
        ActionMenuItem varB4EAC82CA7396A68D541C85D26508E83_1383324091 = null; //Variable for return #1
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        varB4EAC82CA7396A68D541C85D26508E83_1383324091 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1383324091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1383324091;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.916 -0400", hash_original_method = "5A966E6072519B52A8CEABF5F32ED38A", hash_generated_method = "A4D1D55AF2E4B08B9EB84A622DA3394A")
    public MenuItem setChecked(boolean checked) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_40726967 = null; //Variable for return #1
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        varB4EAC82CA7396A68D541C85D26508E83_40726967 = this;
        varB4EAC82CA7396A68D541C85D26508E83_40726967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_40726967;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.922 -0400", hash_original_method = "3B4A922D22D692F4E29B7172DE89A0AD", hash_generated_method = "0B159D6ADDE7E6E7A2467CFD2D8EED15")
    public MenuItem setEnabled(boolean enabled) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_24180839 = null; //Variable for return #1
        mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        varB4EAC82CA7396A68D541C85D26508E83_24180839 = this;
        varB4EAC82CA7396A68D541C85D26508E83_24180839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_24180839;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.926 -0400", hash_original_method = "F52277830906BCEFECA5EA80235FDCAB", hash_generated_method = "9C74556D005D64C604D48C46504E955B")
    public MenuItem setIcon(Drawable icon) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_164739950 = null; //Variable for return #1
        mIconDrawable = icon;
        mIconResId = NO_ICON;
        varB4EAC82CA7396A68D541C85D26508E83_164739950 = this;
        varB4EAC82CA7396A68D541C85D26508E83_164739950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_164739950;
        // ---------- Original Method ----------
        //mIconDrawable = icon;
        //mIconResId = NO_ICON;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.930 -0400", hash_original_method = "5010B90C9AB4414DB888D97ADDAE2333", hash_generated_method = "622DF33BCED6DD1A54D3443704B32F6D")
    public MenuItem setIcon(int iconRes) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2129855317 = null; //Variable for return #1
        mIconResId = iconRes;
        mIconDrawable = mContext.getResources().getDrawable(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_2129855317 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2129855317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2129855317;
        // ---------- Original Method ----------
        //mIconResId = iconRes;
        //mIconDrawable = mContext.getResources().getDrawable(iconRes);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.931 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "A8DFA802523AFCAD1D1C3D484709B145")
    public MenuItem setIntent(Intent intent) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2008196747 = null; //Variable for return #1
        mIntent = intent;
        varB4EAC82CA7396A68D541C85D26508E83_2008196747 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2008196747.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2008196747;
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.931 -0400", hash_original_method = "1F2FCA18D7E58148E8935254347BE744", hash_generated_method = "72309F33DE7AD9C45CA2FEBA612A1E2F")
    public MenuItem setNumericShortcut(char numericChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1690204768 = null; //Variable for return #1
        mShortcutNumericChar = numericChar;
        varB4EAC82CA7396A68D541C85D26508E83_1690204768 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1690204768.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1690204768;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.943 -0400", hash_original_method = "6601271ADD9A6C6B3D832752A2C4336F", hash_generated_method = "8FA3AE7FBC687D2D31691AFDD3396F47")
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_687452787 = null; //Variable for return #1
        mClickListener = menuItemClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_687452787 = this;
        varB4EAC82CA7396A68D541C85D26508E83_687452787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_687452787;
        // ---------- Original Method ----------
        //mClickListener = menuItemClickListener;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.944 -0400", hash_original_method = "656EFF8CD4994CD73006E38A783E9B74", hash_generated_method = "EF3C479404A05547F93C88056063F1EC")
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_603797385 = null; //Variable for return #1
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = alphaChar;
        varB4EAC82CA7396A68D541C85D26508E83_603797385 = this;
        varB4EAC82CA7396A68D541C85D26508E83_603797385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_603797385;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.944 -0400", hash_original_method = "E3AEA6168BB1F22DFC2A4192F0EFD72E", hash_generated_method = "9E345EDB4D2F0AAA6310D38358F8577F")
    public MenuItem setTitle(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_553714174 = null; //Variable for return #1
        mTitle = title;
        varB4EAC82CA7396A68D541C85D26508E83_553714174 = this;
        varB4EAC82CA7396A68D541C85D26508E83_553714174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_553714174;
        // ---------- Original Method ----------
        //mTitle = title;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.944 -0400", hash_original_method = "93E35E6A1799E092E053E5DD222DC093", hash_generated_method = "169E9B164787ABEE03E059BB09FCCAD4")
    public MenuItem setTitle(int title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_301395217 = null; //Variable for return #1
        mTitle = mContext.getResources().getString(title);
        varB4EAC82CA7396A68D541C85D26508E83_301395217 = this;
        varB4EAC82CA7396A68D541C85D26508E83_301395217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_301395217;
        // ---------- Original Method ----------
        //mTitle = mContext.getResources().getString(title);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.945 -0400", hash_original_method = "DC9EFDDD12206C16928994FD6B9EA83A", hash_generated_method = "205BE11295EDF222FB0175892DC986A8")
    public MenuItem setTitleCondensed(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_524154888 = null; //Variable for return #1
        mTitleCondensed = title;
        varB4EAC82CA7396A68D541C85D26508E83_524154888 = this;
        varB4EAC82CA7396A68D541C85D26508E83_524154888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_524154888;
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.952 -0400", hash_original_method = "6A802D7132DF936AE104E3A9B00DB973", hash_generated_method = "B7A971F598DDB9DB4CE640002A199FD4")
    public MenuItem setVisible(boolean visible) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1305903697 = null; //Variable for return #1
        mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        varB4EAC82CA7396A68D541C85D26508E83_1305903697 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1305903697.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1305903697;
        // ---------- Original Method ----------
        //mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.953 -0400", hash_original_method = "AA032C02BB6C3B5A9CA83C7C80BC2006", hash_generated_method = "B7635E57C9D47208CF3449C6BA1B89A9")
    public boolean invoke() {
        {
            boolean var891D05C799AF985A1D37CA302BA21D09_1343027477 = (mClickListener != null && mClickListener.onMenuItemClick(this));
        } //End collapsed parenthetic
        {
            mContext.startActivity(mIntent);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771897904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771897904;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.953 -0400", hash_original_method = "7271F034C654DB6347336274A9D03801", hash_generated_method = "B653C2950442B0D58FDD376972B81792")
    public void setShowAsAction(int show) {
        addTaint(show);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.953 -0400", hash_original_method = "493F4A0F304908668D2BEC1F7D0E334B", hash_generated_method = "BA08ADEE346BC051C6218CEDE04E3807")
    public MenuItem setActionView(View actionView) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(actionView.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.966 -0400", hash_original_method = "DDC728D00ABE6AC1AC6555673541B67E", hash_generated_method = "B015660A3C4311E4AADDCE36EC57446F")
    public View getActionView() {
        View varB4EAC82CA7396A68D541C85D26508E83_2002778082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2002778082 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2002778082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2002778082;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.966 -0400", hash_original_method = "38A20BA0D11F10392D85500804B1A43F", hash_generated_method = "448A9257775AF5F62A7776AE4EE1E431")
    @Override
    public MenuItem setActionView(int resId) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(resId);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.969 -0400", hash_original_method = "FE44B196FF60CED75746223A767C8615", hash_generated_method = "5547BBE96D28924BCF91CA10F04C907A")
    @Override
    public ActionProvider getActionProvider() {
        ActionProvider varB4EAC82CA7396A68D541C85D26508E83_1863914623 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1863914623 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1863914623.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1863914623;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.970 -0400", hash_original_method = "4ABFFD9ECFCE20F6052063E7AA9E942A", hash_generated_method = "49BE8A6BA2F3F3547E77B8CDDDCF7D34")
    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(actionProvider.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.970 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "AF93672E746AC06CFF234E3CF66E2711")
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_441586225 = null; //Variable for return #1
        setShowAsAction(actionEnum);
        varB4EAC82CA7396A68D541C85D26508E83_441586225 = this;
        addTaint(actionEnum);
        varB4EAC82CA7396A68D541C85D26508E83_441586225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_441586225;
        // ---------- Original Method ----------
        //setShowAsAction(actionEnum);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.971 -0400", hash_original_method = "E3EFEFBDC234312A7FEC732911F191DE", hash_generated_method = "FDA71BCE72996E8330891C6CA3C29AAE")
    @Override
    public boolean expandActionView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2091399500 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2091399500;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.972 -0400", hash_original_method = "A369693BDACA70A4B3FDAADB36135262", hash_generated_method = "0873657BE6EC7216A2646DCC949FF8F0")
    @Override
    public boolean collapseActionView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697259886 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697259886;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.972 -0400", hash_original_method = "6EAD6F9611A0523E2504074954E6B02A", hash_generated_method = "083D856BF2DCC1692333DF9B43AA4832")
    @Override
    public boolean isActionViewExpanded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354607115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354607115;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.972 -0400", hash_original_method = "DC2EA5E6DB4BFE29B2697085EABCD856", hash_generated_method = "B79EC185BDC14320B6F60FC47982AB88")
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_771250931 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_771250931 = this;
        addTaint(listener.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_771250931.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_771250931;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.972 -0400", hash_original_field = "3DA77B226EB38F673406BB1FC10EE04A", hash_generated_field = "BAB198D311D959669D5A182A98AEB956")

    private static int NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.972 -0400", hash_original_field = "44D8ACA63E51B6F3484CCFC3C401596B", hash_generated_field = "CF5C64A78A33C6C0B820D00EBAEA0E8C")

    private static int CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.972 -0400", hash_original_field = "AA8FA6BAC5A05627B79C947C0D232729", hash_generated_field = "411C8EC520AC74F640455BDE89EF2D9A")

    private static int CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.983 -0400", hash_original_field = "4BD83E56EE2A97900ECC9A6A8944AED1", hash_generated_field = "49D3CE30F0A77467706408512140A513")

    private static int EXCLUSIVE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.983 -0400", hash_original_field = "9C15CE115096770F474A2620CC59E12C", hash_generated_field = "19B01B6D2439A0ADD3907E2E58A77176")

    private static int HIDDEN = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.983 -0400", hash_original_field = "DF3D10857D57E28E203991699F280170", hash_generated_field = "E7D0E1C5A80CDDBE92E49AF457D7D219")

    private static int ENABLED = 0x00000010;
}

