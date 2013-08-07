package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;





public class ActionMenuItem implements MenuItem {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.826 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.826 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private int mGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.826 -0400", hash_original_field = "B75BDC891F05DF8D9F77776476EBCDD6", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private int mCategoryOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.826 -0400", hash_original_field = "CCC67011C0B9AB1BA64ACA217793FF17", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private int mOrdering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.827 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.827 -0400", hash_original_field = "793CD2D3A29DBCA3B6EE3D2D5CF29A55", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.827 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.827 -0400", hash_original_field = "5CA918862E899FBE57CD8F3D0DB44604", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.827 -0400", hash_original_field = "FAC611210B68F831D4A3B699FB58A971", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.827 -0400", hash_original_field = "EF18AFCEFBAD21F6B816E931AD814543", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.827 -0400", hash_original_field = "37AC3635461CA62872231C85492F3A9C", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.827 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.827 -0400", hash_original_field = "C7443C6F6983E9AE465DCA4986300561", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")

    private MenuItem.OnMenuItemClickListener mClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.827 -0400", hash_original_field = "25DDE236B20D5D6403355424CC7CFB83", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.829 -0400", hash_original_method = "ABBA9423D74CB077EE46D2E3EFD8A9A3", hash_generated_method = "2B1848CDC73B1B0F61B0B979382F628F")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.829 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "8E7E8F3594ECE2679032A6279C043F91")
    public char getAlphabeticShortcut() {
        char varFAC611210B68F831D4A3B699FB58A971_952115904 = (mShortcutAlphabeticChar);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1590591615 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1590591615;
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.829 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "8C33F7EE2EB5A2F63487D7D642C34822")
    public int getGroupId() {
        int var21346FE9F16EBAFFE8F776F66247523D_23926260 = (mGroup);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92915949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92915949;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.830 -0400", hash_original_method = "E45C59E22635FD55A8824D390FC98A96", hash_generated_method = "D74D182E2148D14F1359983F15C95AD9")
    public Drawable getIcon() {
Drawable var5B92DD146545638DBC028505FF353915_2794661 =         mIconDrawable;
        var5B92DD146545638DBC028505FF353915_2794661.addTaint(taint);
        return var5B92DD146545638DBC028505FF353915_2794661;
        // ---------- Original Method ----------
        //return mIconDrawable;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.830 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "090176771560B8DC7E67C817E3AF1A72")
    public Intent getIntent() {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_1913354253 =         mIntent;
        var4DCF8E3D75AE0B94CDA94656DCE16BCE_1913354253.addTaint(taint);
        return var4DCF8E3D75AE0B94CDA94656DCE16BCE_1913354253;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.830 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "0EC1125F3F57E9C7F9A96428D991CCBD")
    public int getItemId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_1647815309 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003071593 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003071593;
        // ---------- Original Method ----------
        //return mId;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.830 -0400", hash_original_method = "D505DD9DA217AD48C3FB7728B16EAF3B", hash_generated_method = "297FE63E5A8FB7E6637E0B66F7D01EB8")
    public ContextMenuInfo getMenuInfo() {
ContextMenuInfo var540C13E9E156B687226421B24F2DF178_1847634057 =         null;
        var540C13E9E156B687226421B24F2DF178_1847634057.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1847634057;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.831 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "AB8E2493B6FBB0405850466A9778391E")
    public char getNumericShortcut() {
        char var5CA918862E899FBE57CD8F3D0DB44604_534568684 = (mShortcutNumericChar);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1846035355 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1846035355;
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.831 -0400", hash_original_method = "FF535D1B11FC0F0766CD26B9FF10F186", hash_generated_method = "16EC48D0383FFF4D9EA2BD13EBB5DA60")
    public int getOrder() {
        int varCCC67011C0B9AB1BA64ACA217793FF17_2072048356 = (mOrdering);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1141668445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1141668445;
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.831 -0400", hash_original_method = "772A0AA7AD2F04B178AEEA64C07E8BF0", hash_generated_method = "2B20FAA6994D0D6E8CC674E9C28FCDC7")
    public SubMenu getSubMenu() {
SubMenu var540C13E9E156B687226421B24F2DF178_499749172 =         null;
        var540C13E9E156B687226421B24F2DF178_499749172.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_499749172;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.831 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "40E77BE512EEA5BC254F14E6D3789FCD")
    public CharSequence getTitle() {
CharSequence var4FE0D95ADE4B4BDFA36D55D8B62A6C49_851651790 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_851651790.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_851651790;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.831 -0400", hash_original_method = "AE18A80D188B13895AC76378DAF3976F", hash_generated_method = "F0009BEAA5E2624DB34929BBAF4E9CAA")
    public CharSequence getTitleCondensed() {
CharSequence varBCA7390F9AEC6E24DD518E20540C2E17_1660833569 =         mTitleCondensed;
        varBCA7390F9AEC6E24DD518E20540C2E17_1660833569.addTaint(taint);
        return varBCA7390F9AEC6E24DD518E20540C2E17_1660833569;
        // ---------- Original Method ----------
        //return mTitleCondensed;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.832 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "9FF0E67A65FDCF9AF8189922206B1B18")
    public boolean hasSubMenu() {
        boolean var68934A3E9455FA72420237EB05902327_461148143 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1414354335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1414354335;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.832 -0400", hash_original_method = "ED15661074DADD4461D34783FBB8C8E2", hash_generated_method = "1E327D9EDE37A6C2C8FC428E2FDB573E")
    public boolean isCheckable() {
        boolean varC157B5585E4115E9AEEC58466169BC3C_1487570071 = ((mFlags & CHECKABLE) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1095002833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1095002833;
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) != 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.832 -0400", hash_original_method = "76E21D72539001F6EF2A57161392D665", hash_generated_method = "B9539900DF60A62EA2681D573D5BC767")
    public boolean isChecked() {
        boolean varD707F6BB2050D9495FE0212AEF8A142A_9667345 = ((mFlags & CHECKED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_219919014 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_219919014;
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) != 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.832 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "D822BF83D5D44F384B4B95592893DFC7")
    public boolean isEnabled() {
        boolean varB87D9597EA81BF64B4340D9A8EF353D6_1443000837 = ((mFlags & ENABLED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1730256928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1730256928;
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.833 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "08405869066CBC8703F5DC5B7D6ADFCB")
    public boolean isVisible() {
        boolean varE913D4BE32099E3F386AB8D84C78AB5D_1865799815 = ((mFlags & HIDDEN) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829874659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_829874659;
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.833 -0400", hash_original_method = "7379DA8B69266F5EBF9FDADEBDD8B3A5", hash_generated_method = "E9FFDC8850E62A64CB5B8C880D3F566C")
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        mShortcutAlphabeticChar = alphaChar;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1526910479 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1526910479.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1526910479;
        // ---------- Original Method ----------
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.833 -0400", hash_original_method = "00566BB0E7762EC9407CFB205264961E", hash_generated_method = "BC46387161907BDE3525CF0404B37A40")
    public MenuItem setCheckable(boolean checkable) {
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_439513233 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_439513233.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_439513233;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.834 -0400", hash_original_method = "38C8FF82F2D3210CC276B1181111BFDA", hash_generated_method = "3DAB4A33A7AC55057F4B696A64BEB392")
    public ActionMenuItem setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
ActionMenuItem var72A74007B2BE62B849F475C7BDA4658B_886924569 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_886924569.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_886924569;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.834 -0400", hash_original_method = "5A966E6072519B52A8CEABF5F32ED38A", hash_generated_method = "C7B4E7758ED9F7B1286D7F888BA9D237")
    public MenuItem setChecked(boolean checked) {
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_19081595 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_19081595.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_19081595;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.835 -0400", hash_original_method = "3B4A922D22D692F4E29B7172DE89A0AD", hash_generated_method = "DF4533767956B8572505BAA37AAB7D4C")
    public MenuItem setEnabled(boolean enabled) {
        mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1224017203 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1224017203.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1224017203;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.835 -0400", hash_original_method = "F52277830906BCEFECA5EA80235FDCAB", hash_generated_method = "1797A31C1879C529CCAE10FA698DCA8E")
    public MenuItem setIcon(Drawable icon) {
        mIconDrawable = icon;
        mIconResId = NO_ICON;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_464234592 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_464234592.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_464234592;
        // ---------- Original Method ----------
        //mIconDrawable = icon;
        //mIconResId = NO_ICON;
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.835 -0400", hash_original_method = "5010B90C9AB4414DB888D97ADDAE2333", hash_generated_method = "9719EE16FF12CFF0D970965E99ED6052")
    public MenuItem setIcon(int iconRes) {
        mIconResId = iconRes;
        mIconDrawable = mContext.getResources().getDrawable(iconRes);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1488565132 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1488565132.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1488565132;
        // ---------- Original Method ----------
        //mIconResId = iconRes;
        //mIconDrawable = mContext.getResources().getDrawable(iconRes);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.835 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "B1E0BD2314F69B1FD0C7FDB2AA73DEA9")
    public MenuItem setIntent(Intent intent) {
        mIntent = intent;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_187669125 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_187669125.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_187669125;
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.835 -0400", hash_original_method = "1F2FCA18D7E58148E8935254347BE744", hash_generated_method = "4CDD39575EB6372E125A0D72382FD404")
    public MenuItem setNumericShortcut(char numericChar) {
        mShortcutNumericChar = numericChar;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_762511346 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_762511346.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_762511346;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.835 -0400", hash_original_method = "6601271ADD9A6C6B3D832752A2C4336F", hash_generated_method = "0999133113C82663551C4EE19F20F0D0")
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        mClickListener = menuItemClickListener;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_630519136 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_630519136.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_630519136;
        // ---------- Original Method ----------
        //mClickListener = menuItemClickListener;
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.836 -0400", hash_original_method = "656EFF8CD4994CD73006E38A783E9B74", hash_generated_method = "E10C625975F08C20DC90590BB69BBD5F")
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = alphaChar;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_879333206 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_879333206.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_879333206;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.836 -0400", hash_original_method = "E3AEA6168BB1F22DFC2A4192F0EFD72E", hash_generated_method = "13BDF32A8D34D41FDB74ED4C6722C7D3")
    public MenuItem setTitle(CharSequence title) {
        mTitle = title;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1868846490 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1868846490.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1868846490;
        // ---------- Original Method ----------
        //mTitle = title;
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.836 -0400", hash_original_method = "93E35E6A1799E092E053E5DD222DC093", hash_generated_method = "4F6ED690C3493297574273E43C65DAC5")
    public MenuItem setTitle(int title) {
        mTitle = mContext.getResources().getString(title);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1829108813 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1829108813.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1829108813;
        // ---------- Original Method ----------
        //mTitle = mContext.getResources().getString(title);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.836 -0400", hash_original_method = "DC9EFDDD12206C16928994FD6B9EA83A", hash_generated_method = "F616C4601D64FC230A067E132C2F84E7")
    public MenuItem setTitleCondensed(CharSequence title) {
        mTitleCondensed = title;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1190751433 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1190751433.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1190751433;
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.836 -0400", hash_original_method = "6A802D7132DF936AE104E3A9B00DB973", hash_generated_method = "C3692E2F20510D42102A00FC8C75639B")
    public MenuItem setVisible(boolean visible) {
        mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1567445367 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1567445367.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1567445367;
        // ---------- Original Method ----------
        //mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.836 -0400", hash_original_method = "AA032C02BB6C3B5A9CA83C7C80BC2006", hash_generated_method = "62DF0D4464D097803E9F59E0FBADAC1D")
    public boolean invoke() {
        if(mClickListener != null && mClickListener.onMenuItemClick(this))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1008104990 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_551936742 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_551936742;
        } //End block
        if(mIntent != null)        
        {
            mContext.startActivity(mIntent);
            boolean varB326B5062B2F0E69046810717534CB09_502701328 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50837063 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_50837063;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1878197055 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075120802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075120802;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.836 -0400", hash_original_method = "7271F034C654DB6347336274A9D03801", hash_generated_method = "B653C2950442B0D58FDD376972B81792")
    public void setShowAsAction(int show) {
        addTaint(show);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.837 -0400", hash_original_method = "493F4A0F304908668D2BEC1F7D0E334B", hash_generated_method = "5AF4386313F639FF8656E9E738D98838")
    public MenuItem setActionView(View actionView) {
        addTaint(actionView.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_22135433 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_22135433.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_22135433;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.837 -0400", hash_original_method = "DDC728D00ABE6AC1AC6555673541B67E", hash_generated_method = "06D5011C32EE6DDF1BA47A94E91A49E1")
    public View getActionView() {
View var540C13E9E156B687226421B24F2DF178_2124566551 =         null;
        var540C13E9E156B687226421B24F2DF178_2124566551.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2124566551;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.837 -0400", hash_original_method = "38A20BA0D11F10392D85500804B1A43F", hash_generated_method = "A49B11AF553E5DFCEE71195EF9AB3C9B")
    @Override
    public MenuItem setActionView(int resId) {
        addTaint(resId);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2085005584 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2085005584.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2085005584;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.837 -0400", hash_original_method = "FE44B196FF60CED75746223A767C8615", hash_generated_method = "159C0361A0E3EF2690B571DD118F9932")
    @Override
    public ActionProvider getActionProvider() {
ActionProvider var540C13E9E156B687226421B24F2DF178_1916035657 =         null;
        var540C13E9E156B687226421B24F2DF178_1916035657.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1916035657;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.837 -0400", hash_original_method = "4ABFFD9ECFCE20F6052063E7AA9E942A", hash_generated_method = "BE0E6582005601044EABDB8A7AA468D8")
    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        addTaint(actionProvider.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1356639162 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1356639162.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1356639162;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.837 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "D780092A22C5C32E47ACEE857AC71FE5")
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        addTaint(actionEnum);
        setShowAsAction(actionEnum);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1988959920 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1988959920.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1988959920;
        // ---------- Original Method ----------
        //setShowAsAction(actionEnum);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.837 -0400", hash_original_method = "E3EFEFBDC234312A7FEC732911F191DE", hash_generated_method = "624235A5B4D633DCFE37E070ABBBFEE6")
    @Override
    public boolean expandActionView() {
        boolean var68934A3E9455FA72420237EB05902327_1639844861 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_107193400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_107193400;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.837 -0400", hash_original_method = "A369693BDACA70A4B3FDAADB36135262", hash_generated_method = "9603EF8BCF68FD565428F4E543D3AF72")
    @Override
    public boolean collapseActionView() {
        boolean var68934A3E9455FA72420237EB05902327_1001715078 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913825419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913825419;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.837 -0400", hash_original_method = "6EAD6F9611A0523E2504074954E6B02A", hash_generated_method = "5DA434BD17D581FA0ACD19C2C0176E66")
    @Override
    public boolean isActionViewExpanded() {
        boolean var68934A3E9455FA72420237EB05902327_1608416983 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_232109027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_232109027;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.838 -0400", hash_original_method = "DC2EA5E6DB4BFE29B2697085EABCD856", hash_generated_method = "20EC613EE5FDD323BE8FA97B3CB5538D")
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        addTaint(listener.getTaint());
MenuItem var72A74007B2BE62B849F475C7BDA4658B_294126237 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_294126237.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_294126237;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.838 -0400", hash_original_field = "3DA77B226EB38F673406BB1FC10EE04A", hash_generated_field = "D79E3C9C1DA0C971841E3A3F777DEEAC")

    private static final int NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.838 -0400", hash_original_field = "44D8ACA63E51B6F3484CCFC3C401596B", hash_generated_field = "943315568AC97A95BEE7FD4A533D08C8")

    private static final int CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.838 -0400", hash_original_field = "AA8FA6BAC5A05627B79C947C0D232729", hash_generated_field = "79E18373E7678760190793C5FAA4E940")

    private static final int CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.838 -0400", hash_original_field = "4BD83E56EE2A97900ECC9A6A8944AED1", hash_generated_field = "80F27CAAB6801F818B589E02F88FCA4D")

    private static final int EXCLUSIVE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.838 -0400", hash_original_field = "9C15CE115096770F474A2620CC59E12C", hash_generated_field = "14D725A9241DDEAEF12149E98726A5C2")

    private static final int HIDDEN = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.838 -0400", hash_original_field = "DF3D10857D57E28E203991699F280170", hash_generated_field = "9D7A6896B452AD15AEC725047E2938A0")

    private static final int ENABLED = 0x00000010;
}

