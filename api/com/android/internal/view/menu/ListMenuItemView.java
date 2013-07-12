package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "1F6C4899836DE7690E2FFD7BA4FE83E4", hash_generated_field = "B32E7CB0DF6786FBC4DDA7C50169A79B")

    private MenuItemImpl mItemData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "1BF6A6ADCCEDB69D0EE1AAE044F85531", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

    private ImageView mIconView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "A4EF38169B001665B17E66B285798128", hash_generated_field = "1E1826A601ADC976D83D58732642409A")

    private RadioButton mRadioButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "5F3FDB05EE6E2581CC95AB22CADCE47B", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "2236170DBB8A1A0270695F788C63BC5D", hash_generated_field = "7182F33F1ED89613270531B36C5FCCCD")

    private CheckBox mCheckBox;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "A46903C597C0BA431004FA7DB3836B95", hash_generated_field = "464E2E9B43628F927166B4B52A641B27")

    private TextView mShortcutView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "0FD12110A291B3958F114906D990C478", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")

    private Drawable mBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "2FB2E5650EED06BEBF40BB55A12238EF", hash_generated_field = "E1363564E2F8BE551770EA738359CA9A")

    private int mTextAppearance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "A40BA604A2EA30F7C4E7BFCB28412D34", hash_generated_field = "FABF004F46FE66709A563A85D0AA3A43")

    private Context mTextAppearanceContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "28879E0CCEDE5485B8A1C37C65F9AB90", hash_generated_field = "9F1A05DC3E20F6FB26386A8F9EF3BC7B")

    private boolean mPreserveIconSpacing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "D417060AEF6C309AF8AA66E156667CBC", hash_generated_field = "184D07E5D4523A6E0D44D4B7FCCF9501")

    private int mMenuType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.110 -0400", hash_original_field = "EB2F9A6DA3D97AE9E64619D6EA497A82", hash_generated_field = "341BE8DFD6FC410A2B4B3CF1435D4B11")

    private boolean mForceShowIcon;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.111 -0400", hash_original_method = "C8B59316A7D022025F82FC9BA82661FF", hash_generated_method = "790CBF54259918251471EF4D3F7E522A")
    public  ListMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        TypedArray a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.MenuView, defStyle, 0);
        mBackground = a.getDrawable(com.android.internal.R.styleable.MenuView_itemBackground);
        mTextAppearance = a.getResourceId(com.android.internal.R.styleable.
                                          MenuView_itemTextAppearance, -1);
        mPreserveIconSpacing = a.getBoolean(
                com.android.internal.R.styleable.MenuView_preserveIconSpacing, false);
        mTextAppearanceContext = context;
        a.recycle();
        
        
            
                
        
        
                                          
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.112 -0400", hash_original_method = "8379DAC15AF7C56B575365B6BA969EC4", hash_generated_method = "2485AFEBA2411D31425AF1EBA22B081D")
    public  ListMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.112 -0400", hash_original_method = "85E45C4D26BDFDA8B8A891EEA2149544", hash_generated_method = "D5BBC55D73ED0BC6A03D3C4BE00465B1")
    @Override
    protected void onFinishInflate() {
        
        super.onFinishInflate();
        setBackgroundDrawable(mBackground);
        mTitleView = (TextView) findViewById(com.android.internal.R.id.title);
    if(mTextAppearance != -1)        
        {
            mTitleView.setTextAppearance(mTextAppearanceContext,
                                         mTextAppearance);
        } 
        mShortcutView = (TextView) findViewById(com.android.internal.R.id.shortcut);
        
        
        
        
        
            
                                         
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.113 -0400", hash_original_method = "5092F6390AF72578BEED6176B75C91D1", hash_generated_method = "ECA5DB92E6F45AE6E8CEA972B9504B66")
    public void initialize(MenuItemImpl itemData, int menuType) {
        mItemData = itemData;
        mMenuType = menuType;
        setVisibility(itemData.isVisible() ? View.VISIBLE : View.GONE);
        setTitle(itemData.getTitleForItemView(this));
        setCheckable(itemData.isCheckable());
        setShortcut(itemData.shouldShowShortcut(), itemData.getShortcut());
        setIcon(itemData.getIcon());
        setEnabled(itemData.isEnabled());
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.114 -0400", hash_original_method = "D8A614357C6F3F0E863735D7939D36DF", hash_generated_method = "000029833D7B44F7160178B4662C1051")
    public void setForceShowIcon(boolean forceShow) {
        mPreserveIconSpacing = mForceShowIcon = forceShow;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.114 -0400", hash_original_method = "D643CEDDD2281EA2D982E86A77F53965", hash_generated_method = "7B943DD86CEAEA3A765348DAB2E192F1")
    public void setTitle(CharSequence title) {
        addTaint(title.getTaint());
    if(title != null)        
        {
            mTitleView.setText(title);
    if(mTitleView.getVisibility() != VISIBLE)            
            mTitleView.setVisibility(VISIBLE);
        } 
        else
        {
    if(mTitleView.getVisibility() != GONE)            
            mTitleView.setVisibility(GONE);
        } 
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.115 -0400", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "4BEAB9BE339E7B27D302DE7D047E6DF3")
    public MenuItemImpl getItemData() {
MenuItemImpl varFD5535759C41B540EBDBAE602A671A91_1200045310 =         mItemData;
        varFD5535759C41B540EBDBAE602A671A91_1200045310.addTaint(taint);
        return varFD5535759C41B540EBDBAE602A671A91_1200045310;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.115 -0400", hash_original_method = "10ED998AF45E09E3692DBD756F730611", hash_generated_method = "806E03B3338CB9F1701D77FBC79CE4D5")
    public void setCheckable(boolean checkable) {
        addTaint(checkable);
    if(!checkable && mRadioButton == null && mCheckBox == null)        
        {
            return;
        } 
        CompoundButton compoundButton;
        CompoundButton otherCompoundButton;
    if(mItemData.isExclusiveCheckable())        
        {
    if(mRadioButton == null)            
            {
                insertRadioButton();
            } 
            compoundButton = mRadioButton;
            otherCompoundButton = mCheckBox;
        } 
        else
        {
    if(mCheckBox == null)            
            {
                insertCheckBox();
            } 
            compoundButton = mCheckBox;
            otherCompoundButton = mRadioButton;
        } 
    if(checkable)        
        {
            compoundButton.setChecked(mItemData.isChecked());
            final int newVisibility = checkable ? VISIBLE : GONE;
    if(compoundButton.getVisibility() != newVisibility)            
            {
                compoundButton.setVisibility(newVisibility);
            } 
    if(otherCompoundButton != null && otherCompoundButton.getVisibility() != GONE)            
            {
                otherCompoundButton.setVisibility(GONE);
            } 
        } 
        else
        {
    if(mCheckBox != null)            
            mCheckBox.setVisibility(GONE);
    if(mRadioButton != null)            
            mRadioButton.setVisibility(GONE);
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.116 -0400", hash_original_method = "1046275995CFEC2A71A54D8E1F9C97CC", hash_generated_method = "3F0AC1043DF9ABCF8904647F5CBC41D6")
    public void setChecked(boolean checked) {
        addTaint(checked);
        CompoundButton compoundButton;
    if(mItemData.isExclusiveCheckable())        
        {
    if(mRadioButton == null)            
            {
                insertRadioButton();
            } 
            compoundButton = mRadioButton;
        } 
        else
        {
    if(mCheckBox == null)            
            {
                insertCheckBox();
            } 
            compoundButton = mCheckBox;
        } 
        compoundButton.setChecked(checked);
        
        
        
            
                
            
            
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.117 -0400", hash_original_method = "4983CC204EB78339386267D8C73D5694", hash_generated_method = "BB3455A20D68F28C065108466A11990C")
    public void setShortcut(boolean showShortcut, char shortcutKey) {
        addTaint(shortcutKey);
        addTaint(showShortcut);
        final int newVisibility = (showShortcut && mItemData.shouldShowShortcut())
                ? VISIBLE : GONE;
    if(newVisibility == VISIBLE)        
        {
            mShortcutView.setText(mItemData.getShortcutLabel());
        } 
    if(mShortcutView.getVisibility() != newVisibility)        
        {
            mShortcutView.setVisibility(newVisibility);
        } 
        
        
                
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.117 -0400", hash_original_method = "19EB37BE18B7BC088A147E31A5EAA2CE", hash_generated_method = "EAD1FB0638B5D0F1469DDE8BA0FDDA40")
    public void setIcon(Drawable icon) {
        addTaint(icon.getTaint());
        final boolean showIcon = mItemData.shouldShowIcon() || mForceShowIcon;
    if(!showIcon && !mPreserveIconSpacing)        
        {
            return;
        } 
    if(mIconView == null && icon == null && !mPreserveIconSpacing)        
        {
            return;
        } 
    if(mIconView == null)        
        {
            insertIconView();
        } 
    if(icon != null || mPreserveIconSpacing)        
        {
            mIconView.setImageDrawable(showIcon ? icon : null);
    if(mIconView.getVisibility() != VISIBLE)            
            {
                mIconView.setVisibility(VISIBLE);
            } 
        } 
        else
        {
            mIconView.setVisibility(GONE);
        } 
        
        
        
            
        
        
            
        
        
            
        
        
            
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.118 -0400", hash_original_method = "EB04FE2393D8303D2CC7459EB64C837F", hash_generated_method = "003F4FA6D83937864129F6A58178C630")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
    if(mIconView != null && mPreserveIconSpacing)        
        {
            ViewGroup.LayoutParams lp = getLayoutParams();
            LayoutParams iconLp = (LayoutParams) mIconView.getLayoutParams();
    if(lp.height > 0 && iconLp.width <= 0)            
            {
                iconLp.width = lp.height;
            } 
        } 
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.118 -0400", hash_original_method = "10F5F40E2932688DF3201248310D8E11", hash_generated_method = "EC98767F367014966ED63E3EF0789564")
    private void insertIconView() {
        LayoutInflater inflater = getInflater();
        mIconView = (ImageView) inflater.inflate(com.android.internal.R.layout.list_menu_item_icon,
                this, false);
        addView(mIconView, 0);
        
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.119 -0400", hash_original_method = "3AE05F112F28FE467A439CFB98DC5418", hash_generated_method = "15CE423BB152D917B454510BB59793B1")
    private void insertRadioButton() {
        LayoutInflater inflater = getInflater();
        mRadioButton =
                (RadioButton) inflater.inflate(com.android.internal.R.layout.list_menu_item_radio,
                this, false);
        addView(mRadioButton);
        
        
        
                
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.119 -0400", hash_original_method = "C1CFD343D3CE36D4657F4BFD8E338B9A", hash_generated_method = "7247AEBE06DD9AC00AEB216787940048")
    private void insertCheckBox() {
        LayoutInflater inflater = getInflater();
        mCheckBox =
                (CheckBox) inflater.inflate(com.android.internal.R.layout.list_menu_item_checkbox,
                this, false);
        addView(mCheckBox);
        
        
        
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.119 -0400", hash_original_method = "D007E81C6798ACEA5420D15C2FEE6142", hash_generated_method = "97AE7F85F1963F4FACECCA4E0FEE12D6")
    public boolean prefersCondensedTitle() {
        boolean var68934A3E9455FA72420237EB05902327_331633612 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1794969941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1794969941;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.119 -0400", hash_original_method = "21090C746FF264700C0D2226436C9966", hash_generated_method = "B6DF46C14B4D959217B5F9FBEF56E716")
    public boolean showsIcon() {
        boolean varEB2F9A6DA3D97AE9E64619D6EA497A82_365679989 = (mForceShowIcon);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1673047205 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1673047205;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.120 -0400", hash_original_method = "800EDA97716EBA1ECAA54C866B1D88CB", hash_generated_method = "567616DC8FBEA465E6FFC4CD3C32029A")
    private LayoutInflater getInflater() {
    if(mInflater == null)        
        {
            mInflater = LayoutInflater.from(mContext);
        } 
LayoutInflater varBB634655A97E6A29040AA54B59F0E4B4_1926368093 =         mInflater;
        varBB634655A97E6A29040AA54B59F0E4B4_1926368093.addTaint(taint);
        return varBB634655A97E6A29040AA54B59F0E4B4_1926368093;
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.120 -0400", hash_original_field = "8F8A929A0D2BDFDBCD8B6C7D83D38186", hash_generated_field = "F05248E8BF4768CA949BBA4F641B42C3")

    private static final String TAG = "ListMenuItemView";
}

