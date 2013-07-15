package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ActionMenuItem implements MenuItem {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private int mGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "B75BDC891F05DF8D9F77776476EBCDD6", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private int mCategoryOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "CCC67011C0B9AB1BA64ACA217793FF17", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private int mOrdering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "793CD2D3A29DBCA3B6EE3D2D5CF29A55", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "5CA918862E899FBE57CD8F3D0DB44604", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "FAC611210B68F831D4A3B699FB58A971", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "EF18AFCEFBAD21F6B816E931AD814543", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.753 -0400", hash_original_field = "37AC3635461CA62872231C85492F3A9C", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.754 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.754 -0400", hash_original_field = "C7443C6F6983E9AE465DCA4986300561", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")

    private MenuItem.OnMenuItemClickListener mClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.754 -0400", hash_original_field = "25DDE236B20D5D6403355424CC7CFB83", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.755 -0400", hash_original_method = "ABBA9423D74CB077EE46D2E3EFD8A9A3", hash_generated_method = "2B1848CDC73B1B0F61B0B979382F628F")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.755 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "E776E1B3813739E526C834073C719961")
    public char getAlphabeticShortcut() {
        char varFAC611210B68F831D4A3B699FB58A971_1530000105 = (mShortcutAlphabeticChar);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1539488782 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1539488782;
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.755 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "90C4C0376956263543954A2016633CCF")
    public int getGroupId() {
        int var21346FE9F16EBAFFE8F776F66247523D_260337666 = (mGroup);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747119203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747119203;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.756 -0400", hash_original_method = "E45C59E22635FD55A8824D390FC98A96", hash_generated_method = "DCAC5CBE8262C762D551AF4EE03159BB")
    public Drawable getIcon() {
Drawable var5B92DD146545638DBC028505FF353915_1866602258 =         mIconDrawable;
        var5B92DD146545638DBC028505FF353915_1866602258.addTaint(taint);
        return var5B92DD146545638DBC028505FF353915_1866602258;
        // ---------- Original Method ----------
        //return mIconDrawable;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.756 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "1798804AEEAB475CBE77DE2C9A42EB4B")
    public Intent getIntent() {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_2030288709 =         mIntent;
        var4DCF8E3D75AE0B94CDA94656DCE16BCE_2030288709.addTaint(taint);
        return var4DCF8E3D75AE0B94CDA94656DCE16BCE_2030288709;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.756 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "B2DD8B5BAB4E5C0F2E06E9D05C5E7EFC")
    public int getItemId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_663123691 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587148083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587148083;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.757 -0400", hash_original_method = "D505DD9DA217AD48C3FB7728B16EAF3B", hash_generated_method = "36344011CBA2B51E96B000FAFC5E3FB1")
    public ContextMenuInfo getMenuInfo() {
ContextMenuInfo var540C13E9E156B687226421B24F2DF178_291909506 =         null;
        var540C13E9E156B687226421B24F2DF178_291909506.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_291909506;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.757 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "4B972B3BF0EBA84E536D9A59417743B2")
    public char getNumericShortcut() {
        char var5CA918862E899FBE57CD8F3D0DB44604_225452278 = (mShortcutNumericChar);
                char varA87DEB01C5F539E6BDA34829C8EF2368_2131548840 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2131548840;
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.757 -0400", hash_original_method = "FF535D1B11FC0F0766CD26B9FF10F186", hash_generated_method = "AAB897DFC50F55672DA871F1AB6F9544")
    public int getOrder() {
        int varCCC67011C0B9AB1BA64ACA217793FF17_1637316394 = (mOrdering);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811105749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811105749;
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.757 -0400", hash_original_method = "772A0AA7AD2F04B178AEEA64C07E8BF0", hash_generated_method = "D959492CB35B47AD4C00251BE468AD36")
    public SubMenu getSubMenu() {
SubMenu var540C13E9E156B687226421B24F2DF178_1416206521 =         null;
        var540C13E9E156B687226421B24F2DF178_1416206521.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1416206521;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.758 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "546AEBDE5CFB7B2CA84857A4A665A3EF")
    public CharSequence getTitle() {
CharSequence var4FE0D95ADE4B4BDFA36D55D8B62A6C49_370939294 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_370939294.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_370939294;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.758 -0400", hash_original_method = "AE18A80D188B13895AC76378DAF3976F", hash_generated_method = "325F2179646EE9B9252EF0F26BB3D3E1")
    public CharSequence getTitleCondensed() {
CharSequence varBCA7390F9AEC6E24DD518E20540C2E17_1557066968 =         mTitleCondensed;
        varBCA7390F9AEC6E24DD518E20540C2E17_1557066968.addTaint(taint);
        return varBCA7390F9AEC6E24DD518E20540C2E17_1557066968;
        // ---------- Original Method ----------
        //return mTitleCondensed;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.758 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "C84F1FACB2B2C13ADDC9880A626D13C1")
    public boolean hasSubMenu() {
        boolean var68934A3E9455FA72420237EB05902327_999948634 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2070089786 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2070089786;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.758 -0400", hash_original_method = "ED15661074DADD4461D34783FBB8C8E2", hash_generated_method = "85AD397E233B1BD90A0327AF2A9060EF")
    public boolean isCheckable() {
        boolean varC157B5585E4115E9AEEC58466169BC3C_1769853947 = ((mFlags & CHECKABLE) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_37115598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_37115598;
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.759 -0400", hash_original_method = "76E21D72539001F6EF2A57161392D665", hash_generated_method = "141B1E32F0F3ED120050A67F600BCB9B")
    public boolean isChecked() {
        boolean varD707F6BB2050D9495FE0212AEF8A142A_923727008 = ((mFlags & CHECKED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481620428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_481620428;
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.759 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "DBA85A4415DB36A78F43B3F270A001CC")
    public boolean isEnabled() {
        boolean varB87D9597EA81BF64B4340D9A8EF353D6_135099225 = ((mFlags & ENABLED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1222673230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1222673230;
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.759 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "34190A009E30053B4A636A40EC80FFF6")
    public boolean isVisible() {
        boolean varE913D4BE32099E3F386AB8D84C78AB5D_189923212 = ((mFlags & HIDDEN) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1393235713 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1393235713;
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.783 -0400", hash_original_method = "7379DA8B69266F5EBF9FDADEBDD8B3A5", hash_generated_method = "FD9535B74D3FD224AB09DE8F9E4F1098")
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        mShortcutAlphabeticChar = alphaChar;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_352975098 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_352975098.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_352975098;
        // ---------- Original Method ----------
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.784 -0400", hash_original_method = "00566BB0E7762EC9407CFB205264961E", hash_generated_method = "D8BC52C360CE63B3808396F32D20CB03")
    public MenuItem setCheckable(boolean checkable) {
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1223258037 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1223258037.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1223258037;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.784 -0400", hash_original_method = "38C8FF82F2D3210CC276B1181111BFDA", hash_generated_method = "3295F0D21CE8BF8A2AFE4AA2D79535EF")
    public ActionMenuItem setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
ActionMenuItem var72A74007B2BE62B849F475C7BDA4658B_402140456 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_402140456.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_402140456;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.784 -0400", hash_original_method = "5A966E6072519B52A8CEABF5F32ED38A", hash_generated_method = "503166AB1EC08E76A34E28462AFA66B9")
    public MenuItem setChecked(boolean checked) {
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1762641030 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1762641030.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1762641030;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.785 -0400", hash_original_method = "3B4A922D22D692F4E29B7172DE89A0AD", hash_generated_method = "0B6AE989347EAF20B914015DB95EA024")
    public MenuItem setEnabled(boolean enabled) {
        mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1912164139 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1912164139.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1912164139;
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.786 -0400", hash_original_method = "F52277830906BCEFECA5EA80235FDCAB", hash_generated_method = "96260668D29CD7CA97BBE23D4FA1E2C7")
    public MenuItem setIcon(Drawable icon) {
        mIconDrawable = icon;
        mIconResId = NO_ICON;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_633580451 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_633580451.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_633580451;
        // ---------- Original Method ----------
        //mIconDrawable = icon;
        //mIconResId = NO_ICON;
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.786 -0400", hash_original_method = "5010B90C9AB4414DB888D97ADDAE2333", hash_generated_method = "F6C6C7A0ECBD294B5B309249C45AF0B0")
    public MenuItem setIcon(int iconRes) {
        mIconResId = iconRes;
        mIconDrawable = mContext.getResources().getDrawable(iconRes);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1166478023 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1166478023.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1166478023;
        // ---------- Original Method ----------
        //mIconResId = iconRes;
        //mIconDrawable = mContext.getResources().getDrawable(iconRes);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.787 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "EDD380023CDB9DE3E441B40F75E81EC3")
    public MenuItem setIntent(Intent intent) {
        mIntent = intent;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1325860932 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1325860932.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1325860932;
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.787 -0400", hash_original_method = "1F2FCA18D7E58148E8935254347BE744", hash_generated_method = "D7E4B632DCD80118A7D8FEE6AB0B9C14")
    public MenuItem setNumericShortcut(char numericChar) {
        mShortcutNumericChar = numericChar;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_622809184 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_622809184.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_622809184;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.787 -0400", hash_original_method = "6601271ADD9A6C6B3D832752A2C4336F", hash_generated_method = "5CFDA0C47C8459366D1E227A30FB23D4")
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        mClickListener = menuItemClickListener;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1870758486 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1870758486.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1870758486;
        // ---------- Original Method ----------
        //mClickListener = menuItemClickListener;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.788 -0400", hash_original_method = "656EFF8CD4994CD73006E38A783E9B74", hash_generated_method = "1907DEC34B76D4CBE86C90BCE9FE1414")
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = alphaChar;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1968393051 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1968393051.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1968393051;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //mShortcutAlphabeticChar = alphaChar;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.788 -0400", hash_original_method = "E3AEA6168BB1F22DFC2A4192F0EFD72E", hash_generated_method = "1A21AE9FC8BC34A1E9F45BB5C1D434F9")
    public MenuItem setTitle(CharSequence title) {
        mTitle = title;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1113484946 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1113484946.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1113484946;
        // ---------- Original Method ----------
        //mTitle = title;
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.788 -0400", hash_original_method = "93E35E6A1799E092E053E5DD222DC093", hash_generated_method = "16047296163614D95E9F1AE1DB022B92")
    public MenuItem setTitle(int title) {
        mTitle = mContext.getResources().getString(title);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_991273786 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_991273786.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_991273786;
        // ---------- Original Method ----------
        //mTitle = mContext.getResources().getString(title);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.789 -0400", hash_original_method = "DC9EFDDD12206C16928994FD6B9EA83A", hash_generated_method = "6E603FE85EC8BED38975F31C0746057A")
    public MenuItem setTitleCondensed(CharSequence title) {
        mTitleCondensed = title;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_235181889 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_235181889.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_235181889;
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.789 -0400", hash_original_method = "6A802D7132DF936AE104E3A9B00DB973", hash_generated_method = "E611C3982F07A31009EB3C0D07E4E044")
    public MenuItem setVisible(boolean visible) {
        mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_821034763 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_821034763.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_821034763;
        // ---------- Original Method ----------
        //mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.789 -0400", hash_original_method = "AA032C02BB6C3B5A9CA83C7C80BC2006", hash_generated_method = "44D1D4666605F5E3B5A6AF80EA93249C")
    public boolean invoke() {
    if(mClickListener != null && mClickListener.onMenuItemClick(this))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_322806816 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1464190797 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1464190797;
        } //End block
    if(mIntent != null)        
        {
            mContext.startActivity(mIntent);
            boolean varB326B5062B2F0E69046810717534CB09_1073583102 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663448281 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_663448281;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_160215608 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742234993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_742234993;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.790 -0400", hash_original_method = "7271F034C654DB6347336274A9D03801", hash_generated_method = "B653C2950442B0D58FDD376972B81792")
    public void setShowAsAction(int show) {
        addTaint(show);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.790 -0400", hash_original_method = "493F4A0F304908668D2BEC1F7D0E334B", hash_generated_method = "71CE1607EA430739C193A490F2CE690D")
    public MenuItem setActionView(View actionView) {
        addTaint(actionView.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1928050692 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1928050692.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1928050692;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.790 -0400", hash_original_method = "DDC728D00ABE6AC1AC6555673541B67E", hash_generated_method = "D78E98B4E09DA01BF6C87D791C8A798B")
    public View getActionView() {
View var540C13E9E156B687226421B24F2DF178_289712553 =         null;
        var540C13E9E156B687226421B24F2DF178_289712553.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_289712553;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.790 -0400", hash_original_method = "38A20BA0D11F10392D85500804B1A43F", hash_generated_method = "3EB9F3A95DB900539DBEBD508E8EED20")
    @Override
    public MenuItem setActionView(int resId) {
        addTaint(resId);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1740739093 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1740739093.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1740739093;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.791 -0400", hash_original_method = "FE44B196FF60CED75746223A767C8615", hash_generated_method = "1E27B95BE0E031D9BED828A1B00600E8")
    @Override
    public ActionProvider getActionProvider() {
ActionProvider var540C13E9E156B687226421B24F2DF178_1145633161 =         null;
        var540C13E9E156B687226421B24F2DF178_1145633161.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1145633161;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.791 -0400", hash_original_method = "4ABFFD9ECFCE20F6052063E7AA9E942A", hash_generated_method = "A205C7ED5AA04551E34EE2B3E2C929AD")
    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        addTaint(actionProvider.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1077763655 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1077763655.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1077763655;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.791 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "FD3AB54D618DA00F69715825DDC0D15A")
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        addTaint(actionEnum);
        setShowAsAction(actionEnum);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1064332003 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1064332003.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1064332003;
        // ---------- Original Method ----------
        //setShowAsAction(actionEnum);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.791 -0400", hash_original_method = "E3EFEFBDC234312A7FEC732911F191DE", hash_generated_method = "BCEB614D66BDD84FE38FD5FE23CE03A5")
    @Override
    public boolean expandActionView() {
        boolean var68934A3E9455FA72420237EB05902327_1669180829 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412134399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412134399;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.792 -0400", hash_original_method = "A369693BDACA70A4B3FDAADB36135262", hash_generated_method = "712B12132524404EC5D70CEF092A18D5")
    @Override
    public boolean collapseActionView() {
        boolean var68934A3E9455FA72420237EB05902327_1774903996 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_308706827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_308706827;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.792 -0400", hash_original_method = "6EAD6F9611A0523E2504074954E6B02A", hash_generated_method = "9F431E47EAC9C928D092497FBCD4EE8C")
    @Override
    public boolean isActionViewExpanded() {
        boolean var68934A3E9455FA72420237EB05902327_1349008144 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308903338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308903338;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.792 -0400", hash_original_method = "DC2EA5E6DB4BFE29B2697085EABCD856", hash_generated_method = "EDE10401B8F9A3EB91F350CC1C3D6D36")
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        addTaint(listener.getTaint());
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1181856790 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1181856790.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1181856790;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.792 -0400", hash_original_field = "3DA77B226EB38F673406BB1FC10EE04A", hash_generated_field = "D79E3C9C1DA0C971841E3A3F777DEEAC")

    private static final int NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.792 -0400", hash_original_field = "44D8ACA63E51B6F3484CCFC3C401596B", hash_generated_field = "943315568AC97A95BEE7FD4A533D08C8")

    private static final int CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.792 -0400", hash_original_field = "AA8FA6BAC5A05627B79C947C0D232729", hash_generated_field = "79E18373E7678760190793C5FAA4E940")

    private static final int CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.792 -0400", hash_original_field = "4BD83E56EE2A97900ECC9A6A8944AED1", hash_generated_field = "80F27CAAB6801F818B589E02F88FCA4D")

    private static final int EXCLUSIVE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.792 -0400", hash_original_field = "9C15CE115096770F474A2620CC59E12C", hash_generated_field = "14D725A9241DDEAEF12149E98726A5C2")

    private static final int HIDDEN = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.793 -0400", hash_original_field = "DF3D10857D57E28E203991699F280170", hash_generated_field = "9D7A6896B452AD15AEC725047E2938A0")

    private static final int ENABLED = 0x00000010;
}

