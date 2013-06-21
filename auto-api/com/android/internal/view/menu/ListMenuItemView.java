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
    private MenuItemImpl mItemData;
    private ImageView mIconView;
    private RadioButton mRadioButton;
    private TextView mTitleView;
    private CheckBox mCheckBox;
    private TextView mShortcutView;
    private Drawable mBackground;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private boolean mPreserveIconSpacing;
    private int mMenuType;
    private LayoutInflater mInflater;
    private boolean mForceShowIcon;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.502 -0400", hash_original_method = "C8B59316A7D022025F82FC9BA82661FF", hash_generated_method = "CC879797E6BC57F84654BF6ACEC41BE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.MenuView, defStyle, 0);
        mBackground = a.getDrawable(com.android.internal.R.styleable.MenuView_itemBackground);
        mTextAppearance = a.getResourceId(com.android.internal.R.styleable.
                                          MenuView_itemTextAppearance, -1);
        mPreserveIconSpacing = a.getBoolean(
                com.android.internal.R.styleable.MenuView_preserveIconSpacing, false);
        a.recycle();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.502 -0400", hash_original_method = "8379DAC15AF7C56B575365B6BA969EC4", hash_generated_method = "FDCD89E472D2672E987C4DF352C71038")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.502 -0400", hash_original_method = "85E45C4D26BDFDA8B8A891EEA2149544", hash_generated_method = "AA5A4A8ED5FBBADB5F442414B3DFD0B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.502 -0400", hash_original_method = "5092F6390AF72578BEED6176B75C91D1", hash_generated_method = "837B322B72F2E0B7697D69EED5D08B60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initialize(MenuItemImpl itemData, int menuType) {
        dsTaint.addTaint(itemData.dsTaint);
        dsTaint.addTaint(menuType);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.503 -0400", hash_original_method = "D8A614357C6F3F0E863735D7939D36DF", hash_generated_method = "D85F9B88DB358F9831FDFF2948F9AC06")
    @DSModeled(DSC.SAFE)
    public void setForceShowIcon(boolean forceShow) {
        dsTaint.addTaint(forceShow);
        mPreserveIconSpacing = mForceShowIcon = forceShow;
        // ---------- Original Method ----------
        //mPreserveIconSpacing = mForceShowIcon = forceShow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.503 -0400", hash_original_method = "D643CEDDD2281EA2D982E86A77F53965", hash_generated_method = "2AE7950767CD2FC4178B50A2104E7488")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        {
            mTitleView.setText(title);
            {
                boolean var6A26BDD4CD8F66D96EADF8E7F98C3BBA_1443011715 = (mTitleView.getVisibility() != VISIBLE);
                mTitleView.setVisibility(VISIBLE);
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varC348C04616DB2B7E7ED08834EC89EED5_401148814 = (mTitleView.getVisibility() != GONE);
                mTitleView.setVisibility(GONE);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (title != null) {
            //mTitleView.setText(title);
            //if (mTitleView.getVisibility() != VISIBLE) mTitleView.setVisibility(VISIBLE);
        //} else {
            //if (mTitleView.getVisibility() != GONE) mTitleView.setVisibility(GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.503 -0400", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "DEB2C950FA1C69F3293D4DDB2C352A9E")
    @DSModeled(DSC.SAFE)
    public MenuItemImpl getItemData() {
        return (MenuItemImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItemData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.503 -0400", hash_original_method = "10ED998AF45E09E3692DBD756F730611", hash_generated_method = "6029616675C8D94415486D1A93FCE050")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCheckable(boolean checkable) {
        dsTaint.addTaint(checkable);
        CompoundButton compoundButton;
        CompoundButton otherCompoundButton;
        {
            boolean varF8952D6A877D25B9B8F7070EA145D1B5_1424070793 = (mItemData.isExclusiveCheckable());
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
                boolean var278E62155688BDD429E0506E96C362DB_1849319752 = (compoundButton.getVisibility() != newVisibility);
                {
                    compoundButton.setVisibility(newVisibility);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varC7C687FF6B837D6E269EE292464FDC93_755211111 = (otherCompoundButton != null && otherCompoundButton.getVisibility() != GONE);
                {
                    otherCompoundButton.setVisibility(GONE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mCheckBox.setVisibility(GONE);
            mRadioButton.setVisibility(GONE);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.504 -0400", hash_original_method = "1046275995CFEC2A71A54D8E1F9C97CC", hash_generated_method = "9932C9945BA16FF20D68CC62D2BF92E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChecked(boolean checked) {
        dsTaint.addTaint(checked);
        CompoundButton compoundButton;
        {
            boolean varF8952D6A877D25B9B8F7070EA145D1B5_1255736921 = (mItemData.isExclusiveCheckable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.504 -0400", hash_original_method = "4983CC204EB78339386267D8C73D5694", hash_generated_method = "ADA6C698CAD08C1B3B03B82B9EC5607E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShortcut(boolean showShortcut, char shortcutKey) {
        dsTaint.addTaint(showShortcut);
        dsTaint.addTaint(shortcutKey);
        int newVisibility;
        boolean varDFF96C752F3D6BAFE34E00DB9989B640_1446121752 = ((showShortcut && mItemData.shouldShowShortcut()));
        newVisibility = VISIBLE;
        newVisibility = GONE;
        {
            mShortcutView.setText(mItemData.getShortcutLabel());
        } //End block
        {
            boolean varBC84E88EF5B81A3829D08C1817D35065_494875240 = (mShortcutView.getVisibility() != newVisibility);
            {
                mShortcutView.setVisibility(newVisibility);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.504 -0400", hash_original_method = "19EB37BE18B7BC088A147E31A5EAA2CE", hash_generated_method = "5986E99673BFE08D5C9AB36549AAD57B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        boolean showIcon;
        showIcon = mItemData.shouldShowIcon() || mForceShowIcon;
        {
            insertIconView();
        } //End block
        {
            mIconView.setImageDrawable(showIcon ? icon : null);
            {
                boolean var0C43E4EEEC50619525D9BC5009577965_2035683410 = (mIconView.getVisibility() != VISIBLE);
                {
                    mIconView.setVisibility(VISIBLE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mIconView.setVisibility(GONE);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.505 -0400", hash_original_method = "EB04FE2393D8303D2CC7459EB64C837F", hash_generated_method = "49AD565899E70F4516BC8272B259FCAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.505 -0400", hash_original_method = "10F5F40E2932688DF3201248310D8E11", hash_generated_method = "3503FA395AFA160FD4E41B314EFF81E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.505 -0400", hash_original_method = "3AE05F112F28FE467A439CFB98DC5418", hash_generated_method = "88CD62338A5E7100AC7958E8AF0DC612")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.505 -0400", hash_original_method = "C1CFD343D3CE36D4657F4BFD8E338B9A", hash_generated_method = "CDF71946A2BDFBB91FE6D2311D3BE6B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.505 -0400", hash_original_method = "D007E81C6798ACEA5420D15C2FEE6142", hash_generated_method = "5A734BF42906BD6A6AB9DE3255250740")
    @DSModeled(DSC.SAFE)
    public boolean prefersCondensedTitle() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.506 -0400", hash_original_method = "21090C746FF264700C0D2226436C9966", hash_generated_method = "70AE82A4E98EF56C226753FF3DF9DF2D")
    @DSModeled(DSC.SAFE)
    public boolean showsIcon() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mForceShowIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.506 -0400", hash_original_method = "800EDA97716EBA1ECAA54C866B1D88CB", hash_generated_method = "732641C7F9D0170537C67A6396415194")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private LayoutInflater getInflater() {
        {
            mInflater = LayoutInflater.from(mContext);
        } //End block
        return (LayoutInflater)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mInflater == null) {
            //mInflater = LayoutInflater.from(mContext);
        //}
        //return mInflater;
    }

    
    private static final String TAG = "ListMenuItemView";
}

