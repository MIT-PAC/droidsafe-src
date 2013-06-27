package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements MenuView.ItemView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.165 -0400", hash_original_field = "1F6C4899836DE7690E2FFD7BA4FE83E4", hash_generated_field = "B32E7CB0DF6786FBC4DDA7C50169A79B")

    private MenuItemImpl mItemData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.165 -0400", hash_original_field = "1BF6A6ADCCEDB69D0EE1AAE044F85531", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

    private ImageView mIconView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.165 -0400", hash_original_field = "A4EF38169B001665B17E66B285798128", hash_generated_field = "1E1826A601ADC976D83D58732642409A")

    private RadioButton mRadioButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.165 -0400", hash_original_field = "5F3FDB05EE6E2581CC95AB22CADCE47B", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.165 -0400", hash_original_field = "2236170DBB8A1A0270695F788C63BC5D", hash_generated_field = "7182F33F1ED89613270531B36C5FCCCD")

    private CheckBox mCheckBox;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.166 -0400", hash_original_field = "A46903C597C0BA431004FA7DB3836B95", hash_generated_field = "464E2E9B43628F927166B4B52A641B27")

    private TextView mShortcutView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.166 -0400", hash_original_field = "0FD12110A291B3958F114906D990C478", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")

    private Drawable mBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.166 -0400", hash_original_field = "2FB2E5650EED06BEBF40BB55A12238EF", hash_generated_field = "E1363564E2F8BE551770EA738359CA9A")

    private int mTextAppearance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.166 -0400", hash_original_field = "A40BA604A2EA30F7C4E7BFCB28412D34", hash_generated_field = "FABF004F46FE66709A563A85D0AA3A43")

    private Context mTextAppearanceContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.166 -0400", hash_original_field = "28879E0CCEDE5485B8A1C37C65F9AB90", hash_generated_field = "9F1A05DC3E20F6FB26386A8F9EF3BC7B")

    private boolean mPreserveIconSpacing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.166 -0400", hash_original_field = "D417060AEF6C309AF8AA66E156667CBC", hash_generated_field = "184D07E5D4523A6E0D44D4B7FCCF9501")

    private int mMenuType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.166 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.166 -0400", hash_original_field = "EB2F9A6DA3D97AE9E64619D6EA497A82", hash_generated_field = "341BE8DFD6FC410A2B4B3CF1435D4B11")

    private boolean mForceShowIcon;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.168 -0400", hash_original_method = "C8B59316A7D022025F82FC9BA82661FF", hash_generated_method = "FDB3D82517EDA4EB61FF1613F3CE471B")
    public  ListMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        TypedArray a;
        a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.MenuView, defStyle, 0);
        mBackground = a.getDrawable(com.android.internal.R.styleable.MenuView_itemBackground);
        mTextAppearance = a.getResourceId(com.android.internal.R.styleable.
                                          MenuView_itemTextAppearance, -1);
        mPreserveIconSpacing = a.getBoolean(
                com.android.internal.R.styleable.MenuView_preserveIconSpacing, false);
        mTextAppearanceContext = context;
        a.recycle();
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //TypedArray a =
            //context.obtainStyledAttributes(
                //attrs, com.android.internal.R.styleable.MenuView, defStyle, 0);
        //mBackground = a.getDrawable(com.android.internal.R.styleable.MenuView_itemBackground);
        //mTextAppearance = a.getResourceId(com.android.internal.R.styleable.
                                          //MenuView_itemTextAppearance, -1);
        //mPreserveIconSpacing = a.getBoolean(
                //com.android.internal.R.styleable.MenuView_preserveIconSpacing, false);
        //mTextAppearanceContext = context;
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.168 -0400", hash_original_method = "8379DAC15AF7C56B575365B6BA969EC4", hash_generated_method = "291482D1F85F56CF49C8DF95F7B45362")
    public  ListMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.169 -0400", hash_original_method = "85E45C4D26BDFDA8B8A891EEA2149544", hash_generated_method = "AA5A4A8ED5FBBADB5F442414B3DFD0B8")
    @Override
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        setBackgroundDrawable(mBackground);
        mTitleView = (TextView) findViewById(com.android.internal.R.id.title);
        {
            mTitleView.setTextAppearance(mTextAppearanceContext,
                                         mTextAppearance);
        } //End block
        mShortcutView = (TextView) findViewById(com.android.internal.R.id.shortcut);
        // ---------- Original Method ----------
        //super.onFinishInflate();
        //setBackgroundDrawable(mBackground);
        //mTitleView = (TextView) findViewById(com.android.internal.R.id.title);
        //if (mTextAppearance != -1) {
            //mTitleView.setTextAppearance(mTextAppearanceContext,
                                         //mTextAppearance);
        //}
        //mShortcutView = (TextView) findViewById(com.android.internal.R.id.shortcut);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.178 -0400", hash_original_method = "5092F6390AF72578BEED6176B75C91D1", hash_generated_method = "ECA5DB92E6F45AE6E8CEA972B9504B66")
    public void initialize(MenuItemImpl itemData, int menuType) {
        mItemData = itemData;
        mMenuType = menuType;
        setVisibility(itemData.isVisible() ? View.VISIBLE : View.GONE);
        setTitle(itemData.getTitleForItemView(this));
        setCheckable(itemData.isCheckable());
        setShortcut(itemData.shouldShowShortcut(), itemData.getShortcut());
        setIcon(itemData.getIcon());
        setEnabled(itemData.isEnabled());
        // ---------- Original Method ----------
        //mItemData = itemData;
        //mMenuType = menuType;
        //setVisibility(itemData.isVisible() ? View.VISIBLE : View.GONE);
        //setTitle(itemData.getTitleForItemView(this));
        //setCheckable(itemData.isCheckable());
        //setShortcut(itemData.shouldShowShortcut(), itemData.getShortcut());
        //setIcon(itemData.getIcon());
        //setEnabled(itemData.isEnabled());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.180 -0400", hash_original_method = "D8A614357C6F3F0E863735D7939D36DF", hash_generated_method = "000029833D7B44F7160178B4662C1051")
    public void setForceShowIcon(boolean forceShow) {
        mPreserveIconSpacing = mForceShowIcon = forceShow;
        // ---------- Original Method ----------
        //mPreserveIconSpacing = mForceShowIcon = forceShow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.181 -0400", hash_original_method = "D643CEDDD2281EA2D982E86A77F53965", hash_generated_method = "A595FA713CB013E048261B3C6B4E800F")
    public void setTitle(CharSequence title) {
        {
            mTitleView.setText(title);
            {
                boolean var6A26BDD4CD8F66D96EADF8E7F98C3BBA_148429530 = (mTitleView.getVisibility() != VISIBLE);
                mTitleView.setVisibility(VISIBLE);
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varC348C04616DB2B7E7ED08834EC89EED5_640058637 = (mTitleView.getVisibility() != GONE);
                mTitleView.setVisibility(GONE);
            } //End collapsed parenthetic
        } //End block
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //if (title != null) {
            //mTitleView.setText(title);
            //if (mTitleView.getVisibility() != VISIBLE) mTitleView.setVisibility(VISIBLE);
        //} else {
            //if (mTitleView.getVisibility() != GONE) mTitleView.setVisibility(GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.185 -0400", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "2AA18F5FFFF50F7534637EEC71035E26")
    public MenuItemImpl getItemData() {
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_343621585 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_343621585 = mItemData;
        varB4EAC82CA7396A68D541C85D26508E83_343621585.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_343621585;
        // ---------- Original Method ----------
        //return mItemData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.186 -0400", hash_original_method = "10ED998AF45E09E3692DBD756F730611", hash_generated_method = "775087C96DCDCA0177E5D97124B05282")
    public void setCheckable(boolean checkable) {
        CompoundButton compoundButton;
        CompoundButton otherCompoundButton;
        {
            boolean varF8952D6A877D25B9B8F7070EA145D1B5_1528360573 = (mItemData.isExclusiveCheckable());
            {
                {
                    insertRadioButton();
                } //End block
                compoundButton = mRadioButton;
                otherCompoundButton = mCheckBox;
            } //End block
            {
                {
                    insertCheckBox();
                } //End block
                compoundButton = mCheckBox;
                otherCompoundButton = mRadioButton;
            } //End block
        } //End collapsed parenthetic
        {
            compoundButton.setChecked(mItemData.isChecked());
            int newVisibility;
            newVisibility = VISIBLE;
            newVisibility = GONE;
            {
                boolean var278E62155688BDD429E0506E96C362DB_1963573622 = (compoundButton.getVisibility() != newVisibility);
                {
                    compoundButton.setVisibility(newVisibility);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varC7C687FF6B837D6E269EE292464FDC93_1467759719 = (otherCompoundButton != null && otherCompoundButton.getVisibility() != GONE);
                {
                    otherCompoundButton.setVisibility(GONE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mCheckBox.setVisibility(GONE);
            mRadioButton.setVisibility(GONE);
        } //End block
        addTaint(checkable);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.196 -0400", hash_original_method = "1046275995CFEC2A71A54D8E1F9C97CC", hash_generated_method = "64B7500DB51671BE957079B73BBA381D")
    public void setChecked(boolean checked) {
        CompoundButton compoundButton;
        {
            boolean varF8952D6A877D25B9B8F7070EA145D1B5_411813153 = (mItemData.isExclusiveCheckable());
            {
                {
                    insertRadioButton();
                } //End block
                compoundButton = mRadioButton;
            } //End block
            {
                {
                    insertCheckBox();
                } //End block
                compoundButton = mCheckBox;
            } //End block
        } //End collapsed parenthetic
        compoundButton.setChecked(checked);
        addTaint(checked);
        // ---------- Original Method ----------
        //CompoundButton compoundButton;
        //if (mItemData.isExclusiveCheckable()) {
            //if (mRadioButton == null) {
                //insertRadioButton();
            //}
            //compoundButton = mRadioButton;
        //} else {
            //if (mCheckBox == null) {
                //insertCheckBox();
            //}
            //compoundButton = mCheckBox;
        //}
        //compoundButton.setChecked(checked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.197 -0400", hash_original_method = "4983CC204EB78339386267D8C73D5694", hash_generated_method = "797F901974E6E727AA171A9D69ED6954")
    public void setShortcut(boolean showShortcut, char shortcutKey) {
        int newVisibility;
        boolean varDFF96C752F3D6BAFE34E00DB9989B640_621563330 = ((showShortcut && mItemData.shouldShowShortcut()));
        newVisibility = VISIBLE;
        newVisibility = GONE;
        {
            mShortcutView.setText(mItemData.getShortcutLabel());
        } //End block
        {
            boolean varBC84E88EF5B81A3829D08C1817D35065_451330010 = (mShortcutView.getVisibility() != newVisibility);
            {
                mShortcutView.setVisibility(newVisibility);
            } //End block
        } //End collapsed parenthetic
        addTaint(showShortcut);
        addTaint(shortcutKey);
        // ---------- Original Method ----------
        //final int newVisibility = (showShortcut && mItemData.shouldShowShortcut())
                //? VISIBLE : GONE;
        //if (newVisibility == VISIBLE) {
            //mShortcutView.setText(mItemData.getShortcutLabel());
        //}
        //if (mShortcutView.getVisibility() != newVisibility) {
            //mShortcutView.setVisibility(newVisibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.197 -0400", hash_original_method = "19EB37BE18B7BC088A147E31A5EAA2CE", hash_generated_method = "E1D5420FC15800FAD378613773AE35B2")
    public void setIcon(Drawable icon) {
        boolean showIcon;
        showIcon = mItemData.shouldShowIcon() || mForceShowIcon;
        {
            insertIconView();
        } //End block
        {
            mIconView.setImageDrawable(showIcon ? icon : null);
            {
                boolean var0C43E4EEEC50619525D9BC5009577965_1977011071 = (mIconView.getVisibility() != VISIBLE);
                {
                    mIconView.setVisibility(VISIBLE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mIconView.setVisibility(GONE);
        } //End block
        addTaint(icon.getTaint());
        // ---------- Original Method ----------
        //final boolean showIcon = mItemData.shouldShowIcon() || mForceShowIcon;
        //if (!showIcon && !mPreserveIconSpacing) {
            //return;
        //}
        //if (mIconView == null && icon == null && !mPreserveIconSpacing) {
            //return;
        //}
        //if (mIconView == null) {
            //insertIconView();
        //}
        //if (icon != null || mPreserveIconSpacing) {
            //mIconView.setImageDrawable(showIcon ? icon : null);
            //if (mIconView.getVisibility() != VISIBLE) {
                //mIconView.setVisibility(VISIBLE);
            //}
        //} else {
            //mIconView.setVisibility(GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.205 -0400", hash_original_method = "EB04FE2393D8303D2CC7459EB64C837F", hash_generated_method = "BB47830A1B45397C818424959B496F91")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            ViewGroup.LayoutParams lp;
            lp = getLayoutParams();
            LayoutParams iconLp;
            iconLp = (LayoutParams) mIconView.getLayoutParams();
            {
                iconLp.width = lp.height;
            } //End block
        } //End block
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        //if (mIconView != null && mPreserveIconSpacing) {
            //ViewGroup.LayoutParams lp = getLayoutParams();
            //LayoutParams iconLp = (LayoutParams) mIconView.getLayoutParams();
            //if (lp.height > 0 && iconLp.width <= 0) {
                //iconLp.width = lp.height;
            //}
        //}
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.205 -0400", hash_original_method = "10F5F40E2932688DF3201248310D8E11", hash_generated_method = "3503FA395AFA160FD4E41B314EFF81E9")
    private void insertIconView() {
        LayoutInflater inflater;
        inflater = getInflater();
        mIconView = (ImageView) inflater.inflate(com.android.internal.R.layout.list_menu_item_icon,
                this, false);
        addView(mIconView, 0);
        // ---------- Original Method ----------
        //LayoutInflater inflater = getInflater();
        //mIconView = (ImageView) inflater.inflate(com.android.internal.R.layout.list_menu_item_icon,
                //this, false);
        //addView(mIconView, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.205 -0400", hash_original_method = "3AE05F112F28FE467A439CFB98DC5418", hash_generated_method = "88CD62338A5E7100AC7958E8AF0DC612")
    private void insertRadioButton() {
        LayoutInflater inflater;
        inflater = getInflater();
        mRadioButton =
                (RadioButton) inflater.inflate(com.android.internal.R.layout.list_menu_item_radio,
                this, false);
        addView(mRadioButton);
        // ---------- Original Method ----------
        //LayoutInflater inflater = getInflater();
        //mRadioButton =
                //(RadioButton) inflater.inflate(com.android.internal.R.layout.list_menu_item_radio,
                //this, false);
        //addView(mRadioButton);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.206 -0400", hash_original_method = "C1CFD343D3CE36D4657F4BFD8E338B9A", hash_generated_method = "CDF71946A2BDFBB91FE6D2311D3BE6B3")
    private void insertCheckBox() {
        LayoutInflater inflater;
        inflater = getInflater();
        mCheckBox =
                (CheckBox) inflater.inflate(com.android.internal.R.layout.list_menu_item_checkbox,
                this, false);
        addView(mCheckBox);
        // ---------- Original Method ----------
        //LayoutInflater inflater = getInflater();
        //mCheckBox =
                //(CheckBox) inflater.inflate(com.android.internal.R.layout.list_menu_item_checkbox,
                //this, false);
        //addView(mCheckBox);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.206 -0400", hash_original_method = "D007E81C6798ACEA5420D15C2FEE6142", hash_generated_method = "4763A253F40F180AA89F7E1F9366FB05")
    public boolean prefersCondensedTitle() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_641940459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_641940459;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.206 -0400", hash_original_method = "21090C746FF264700C0D2226436C9966", hash_generated_method = "288A6058BE2EF79738D5695900013261")
    public boolean showsIcon() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062002909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062002909;
        // ---------- Original Method ----------
        //return mForceShowIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.207 -0400", hash_original_method = "800EDA97716EBA1ECAA54C866B1D88CB", hash_generated_method = "4169CAC56B539CF93BF299CFFCF045F3")
    private LayoutInflater getInflater() {
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_120758448 = null; //Variable for return #1
        {
            mInflater = LayoutInflater.from(mContext);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_120758448 = mInflater;
        varB4EAC82CA7396A68D541C85D26508E83_120758448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_120758448;
        // ---------- Original Method ----------
        //if (mInflater == null) {
            //mInflater = LayoutInflater.from(mContext);
        //}
        //return mInflater;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.207 -0400", hash_original_field = "8F8A929A0D2BDFDBCD8B6C7D83D38186", hash_generated_field = "30FEBF476D6395983591F5CE4FCF2B7C")

    private static String TAG = "ListMenuItemView";
}

