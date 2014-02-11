package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.516 -0500", hash_original_field = "85EA99D3EE3FBF5630E4D962E96A8E74", hash_generated_field = "D79E3C9C1DA0C971841E3A3F777DEEAC")
    
    private static final int NO_ICON = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.521 -0500", hash_original_field = "90654049052F718180E995FFF6612EFC", hash_generated_field = "943315568AC97A95BEE7FD4A533D08C8")

    private static final int CHECKABLE      = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.523 -0500", hash_original_field = "DDAF50494EDE92B5A907F7788646DD1D", hash_generated_field = "79E18373E7678760190793C5FAA4E940")

    private static final int CHECKED        = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.525 -0500", hash_original_field = "3133F3AB867F08EB7F5C188557ADF8DE", hash_generated_field = "80F27CAAB6801F818B589E02F88FCA4D")

    private static final int EXCLUSIVE      = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.528 -0500", hash_original_field = "D1A8B498453E3580610DDDDF65EDF69E", hash_generated_field = "14D725A9241DDEAEF12149E98726A5C2")

    private static final int HIDDEN         = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.530 -0500", hash_original_field = "9E28E33B02832F7297D3046B6A7FB712", hash_generated_field = "9D7A6896B452AD15AEC725047E2938A0")

    private static final int ENABLED        = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.485 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private  int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.487 -0500", hash_original_field = "9C43571C45B8BC34B7C8A06B2271F04A", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private  int mGroup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.489 -0500", hash_original_field = "F6DD8D04E6975C66628782A471D540ED", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private  int mCategoryOrder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.492 -0500", hash_original_field = "3D9DE4CD049B86E1600012D5AF1467A8", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private  int mOrdering;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.494 -0500", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")
    
    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.496 -0500", hash_original_field = "FA3171B1888A35931DDF94EF6B72DFBA", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.499 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.501 -0500", hash_original_field = "48B12B8F5B9FDB1D830B92E86520B6F6", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.503 -0500", hash_original_field = "4416434619B59B48D8ADBB443F744028", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.506 -0500", hash_original_field = "E7758D8423F0CD19BF50F0B56DC871A4", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")
    
    private Drawable mIconDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.509 -0500", hash_original_field = "90FECF5DA6E08407086BFE725E64094A", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.511 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")
    
    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.513 -0500", hash_original_field = "E14C5536FD73A354B761BD4CA9460340", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")
    
    private MenuItem.OnMenuItemClickListener mClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.518 -0500", hash_original_field = "87B4121714640703C04C2D7C1C71B5DF", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")
    
    private int mFlags = ENABLED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.532 -0500", hash_original_method = "ABBA9423D74CB077EE46D2E3EFD8A9A3", hash_generated_method = "F14EB0A2E6AFE443C272F5F67E6F72D0")
    
public ActionMenuItem(Context context, int group, int id, int categoryOrder, int ordering,
            CharSequence title) {
        mContext = context;
        mId = id;
        mGroup = group;
        mCategoryOrder = categoryOrder;
        mOrdering = ordering;
        mTitle = title;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.535 -0500", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "C6CC3463628F299A61B99559C4F6FF3E")
    @DSVerified
    @DSSafe(DSCat.GUI)

public char getAlphabeticShortcut() {
        return mShortcutAlphabeticChar;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.537 -0500", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "92A3BA6D09A85A547821EFB39597530D")
    @DSVerified
    @DSSafe(DSCat.GUI)

public int getGroupId() {
        return mGroup;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.540 -0500", hash_original_method = "E45C59E22635FD55A8824D390FC98A96", hash_generated_method = "1C89A96420FD278FBEA6A239DD23BEEC")
    @DSVerified
    @DSSafe(DSCat.GUI)

public Drawable getIcon() {
        return mIconDrawable;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.542 -0500", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "7CE6D2E5920E17BB1B744A5090D635BC")
    @DSVerified
    @DSSpec(DSCat.INTENT_EXCHANGE)

public Intent getIntent() {
        return mIntent;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.544 -0500", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "DA81E2FAC9BA8C312C462D283E81A734")
    @DSVerified
    @DSSafe(DSCat.GUI)
    
public int getItemId() {
        return mId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.547 -0500", hash_original_method = "D505DD9DA217AD48C3FB7728B16EAF3B", hash_generated_method = "1F7584093424AA16137441E5ACE98B7D")
    @DSVerified
    @DSSafe(DSCat.GUI)
    
public ContextMenuInfo getMenuInfo() {
        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.549 -0500", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "C2D13B8EBB073B93C575296CDD9268AC")
    @DSVerified
    @DSSafe(DSCat.GUI)
    
public char getNumericShortcut() {
        return mShortcutNumericChar;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.551 -0500", hash_original_method = "FF535D1B11FC0F0766CD26B9FF10F186", hash_generated_method = "441C827BEB7449A539BA6B3998C1E0A3")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public int getOrder() {
        return mOrdering;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.553 -0500", hash_original_method = "772A0AA7AD2F04B178AEEA64C07E8BF0", hash_generated_method = "C4E8D2D80C36F19E3FBB84A9617BE54E")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public SubMenu getSubMenu() {
        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.556 -0500", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "E948C46F1704FC1F24545ED5A725BEE6")
    @DSVerified
    @DSSafe(DSCat.GUI)
public CharSequence getTitle() {
        return mTitle;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.558 -0500", hash_original_method = "AE18A80D188B13895AC76378DAF3976F", hash_generated_method = "233DD3341101EB181D148A2A944FE56F")
    @DSVerified
    @DSSafe(DSCat.GUI)
    
public CharSequence getTitleCondensed() {
        return mTitleCondensed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.560 -0500", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "C47A8DBA8C06C24113E67B7BE29255AD")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public boolean hasSubMenu() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.562 -0500", hash_original_method = "ED15661074DADD4461D34783FBB8C8E2", hash_generated_method = "4D4D2BACD9A2D4FC6EC65CDB8693BCD4")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public boolean isCheckable() {
        return (mFlags & CHECKABLE) != 0; 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.564 -0500", hash_original_method = "76E21D72539001F6EF2A57161392D665", hash_generated_method = "1105175507D07D475281024C6047C785")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public boolean isChecked() {
        return (mFlags & CHECKED) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.567 -0500", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "AECBB7E5FCE868E97452BAD92DC2A2C3")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public boolean isEnabled() {
        return (mFlags & ENABLED) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.569 -0500", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "1B80F4020608615FA89A7EFC550036C6")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public boolean isVisible() {
        return (mFlags & HIDDEN) == 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.571 -0500", hash_original_method = "7379DA8B69266F5EBF9FDADEBDD8B3A5", hash_generated_method = "17C8DE4872FC17137E8F92A3C1778BFA")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public MenuItem setAlphabeticShortcut(char alphaChar) {
        mShortcutAlphabeticChar = alphaChar;
        return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.573 -0500", hash_original_method = "00566BB0E7762EC9407CFB205264961E", hash_generated_method = "3D97996810DFC56DFAF4BE51775EC6D1")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public MenuItem setCheckable(boolean checkable) {
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        return this;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.575 -0500", hash_original_method = "38C8FF82F2D3210CC276B1181111BFDA", hash_generated_method = "373D4BEEE4A8DC133924EB71ABDB0102")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public ActionMenuItem setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.577 -0500", hash_original_method = "5A966E6072519B52A8CEABF5F32ED38A", hash_generated_method = "CD6B6578F627F288A229F9FE34770672")
    @DSVerified
    @DSSafe(DSCat.GUI)
    
public MenuItem setChecked(boolean checked) {
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.580 -0500", hash_original_method = "3B4A922D22D692F4E29B7172DE89A0AD", hash_generated_method = "EF9FD37E4E438319825677AAA235AA07")
    @DSVerified
    @DSSafe(DSCat.GUI)
    
public MenuItem setEnabled(boolean enabled) {
        mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.582 -0500", hash_original_method = "F52277830906BCEFECA5EA80235FDCAB", hash_generated_method = "A3FF17C4369DAAC21F4AB9A5E2317BAE")
    @DSVerified
    @DSSafe(DSCat.GUI)
public MenuItem setIcon(Drawable icon) {
        mIconDrawable = icon;
        mIconResId = NO_ICON;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.584 -0500", hash_original_method = "5010B90C9AB4414DB888D97ADDAE2333", hash_generated_method = "57AE400D2F0B6C6EAF9E302CBF45A861")
    
public MenuItem setIcon(int iconRes) {
        mIconResId = iconRes;
        mIconDrawable = mContext.getResources().getDrawable(iconRes);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.586 -0500", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "FC870B7BE66B774D28C4327475BB97C9")
    @DSVerified
    @DSSafe(DSCat.GUI)
public MenuItem setIntent(Intent intent) {
        mIntent = intent;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.589 -0500", hash_original_method = "1F2FCA18D7E58148E8935254347BE744", hash_generated_method = "9A11968E5B67837A36F1855A8F2C030E")
    @DSVerified
    @DSSafe(DSCat.GUI)

public MenuItem setNumericShortcut(char numericChar) {
        mShortcutNumericChar = numericChar;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.591 -0500", hash_original_method = "6601271ADD9A6C6B3D832752A2C4336F", hash_generated_method = "894ACD498E90675E27BBC4312345266C")
    @DSVerified("callback modeled")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        mClickListener = menuItemClickListener;
        if (mClickListener != null)
            mClickListener.onMenuItemClick(this);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.594 -0500", hash_original_method = "656EFF8CD4994CD73006E38A783E9B74", hash_generated_method = "E46C1055E4F85E80482B5021DEEC1A7B")
    @DSVerified
    @DSSafe(DSCat.GUI)
public MenuItem setShortcut(char numericChar, char alphaChar) {
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = alphaChar;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.596 -0500", hash_original_method = "E3AEA6168BB1F22DFC2A4192F0EFD72E", hash_generated_method = "879896A60705751E89B8C9C78545FFAA")

    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setTitle(CharSequence title) {
        mTitle = title;
        return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.598 -0500", hash_original_method = "93E35E6A1799E092E053E5DD222DC093", hash_generated_method = "65DB2B1B966A5B5A9E0477A63230C599")
    
public MenuItem setTitle(int title) {
        mTitle = mContext.getResources().getString(title);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.600 -0500", hash_original_method = "DC9EFDDD12206C16928994FD6B9EA83A", hash_generated_method = "9C044CBB9429962F683468D926AF511E")
    
public MenuItem setTitleCondensed(CharSequence title) {
        mTitleCondensed = title;
        return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.603 -0500", hash_original_method = "6A802D7132DF936AE104E3A9B00DB973", hash_generated_method = "F79EF35C7116F4D80FA380FC369FA52D")
    
public MenuItem setVisible(boolean visible) {
        mFlags = (mFlags & HIDDEN) | (visible ? 0 : HIDDEN);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.605 -0500", hash_original_method = "AA032C02BB6C3B5A9CA83C7C80BC2006", hash_generated_method = "CB02673D8CDB17FE62F1FC3131156653")
    
public boolean invoke() {
        if (mClickListener != null && mClickListener.onMenuItemClick(this)) {
            return true;
        }
        
        if (mIntent != null) {
            mContext.startActivity(mIntent);
            return true;
        }
        
        return false;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.607 -0500", hash_original_method = "7271F034C654DB6347336274A9D03801", hash_generated_method = "EA2228D1739DD7B5887F04EF03C3D127")
    
public void setShowAsAction(int show) {
        // Do nothing. ActionMenuItems always show as action buttons.
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.609 -0500", hash_original_method = "493F4A0F304908668D2BEC1F7D0E334B", hash_generated_method = "48D9778F556A1BFC0C699BC5BFB3CCC7")
    
public MenuItem setActionView(View actionView) {
        throw new UnsupportedOperationException();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.612 -0500", hash_original_method = "DDC728D00ABE6AC1AC6555673541B67E", hash_generated_method = "079D331D6B7B4A65C7CAD1B0AC46E07F")
    
public View getActionView() {
        return null;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.614 -0500", hash_original_method = "38A20BA0D11F10392D85500804B1A43F", hash_generated_method = "44D1643A1680E023254E9B4CBD44B596")
    
@Override
    public MenuItem setActionView(int resId) {
        throw new UnsupportedOperationException();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.616 -0500", hash_original_method = "FE44B196FF60CED75746223A767C8615", hash_generated_method = "97E48161197A5EBA52329872E2A7DE6C")
    
@Override
    public ActionProvider getActionProvider() {
        return null;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.618 -0500", hash_original_method = "4ABFFD9ECFCE20F6052063E7AA9E942A", hash_generated_method = "1459D882F8B4F02FC73C102E86BC9EE6")
    
@Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.620 -0500", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "E3AEDEFC029A2CDBBEAF6794D67209CE")
    
@Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.622 -0500", hash_original_method = "E3EFEFBDC234312A7FEC732911F191DE", hash_generated_method = "30BA6579DC5E4995E9EAA743EA45E6A5")
    
@Override
    public boolean expandActionView() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.625 -0500", hash_original_method = "A369693BDACA70A4B3FDAADB36135262", hash_generated_method = "2624D05CDE3897B300131D8B0F4D09D0")
    @DSVerified
    @DSSafe(DSCat.GUI)
@Override
    public boolean collapseActionView() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.627 -0500", hash_original_method = "6EAD6F9611A0523E2504074954E6B02A", hash_generated_method = "0B58F86E07A527AC75EBC8CD68481FF2")
    @DSVerified
    @DSSafe(DSCat.GUI)

@Override
    public boolean isActionViewExpanded() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.630 -0500", hash_original_method = "DC2EA5E6DB4BFE29B2697085EABCD856", hash_generated_method = "52E46C6841A34720ABE367F18686B7D8")
    @DSVerified("callback modeled")
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        // No need to save the listener; ActionMenuItem does not support collapsing items.
        if (listener != null) {
            listener.onMenuItemActionCollapse(this);
            listener.onMenuItemActionExpand(this);
        }
        return this;
    }
}

