package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.255 -0500", hash_original_field = "53B00E23D91B0BDBA59BEB68DD2FF51B", hash_generated_field = "F05248E8BF4768CA949BBA4F641B42C3")

    private static final String TAG = "ListMenuItemView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.257 -0500", hash_original_field = "DBB703567F4F0AD8C976E510ACED07CC", hash_generated_field = "B32E7CB0DF6786FBC4DDA7C50169A79B")

    private MenuItemImpl mItemData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.260 -0500", hash_original_field = "069158469BB60C88A2C4A541C6AFB8D2", hash_generated_field = "411E3339296CF54457E86988903AF1A7")
 
    
    private ImageView mIconView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.263 -0500", hash_original_field = "E360002A71982849632CAD48DFDDC3F3", hash_generated_field = "1E1826A601ADC976D83D58732642409A")

    private RadioButton mRadioButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.266 -0500", hash_original_field = "B3B1177DB6C3A24EAC74C6705FD25300", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.269 -0500", hash_original_field = "476FA6AA33AC7D978E9C914FAF8C4885", hash_generated_field = "7182F33F1ED89613270531B36C5FCCCD")

    private CheckBox mCheckBox;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.271 -0500", hash_original_field = "FD42D5DFF831282A734A9A1CA7E9A0C6", hash_generated_field = "464E2E9B43628F927166B4B52A641B27")

    private TextView mShortcutView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.274 -0500", hash_original_field = "1414D97CE5ED674A74A05A07F83AE3BF", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")

    
    private Drawable mBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.276 -0500", hash_original_field = "12897BEF89A4C72FECFFDFE7F1200971", hash_generated_field = "E1363564E2F8BE551770EA738359CA9A")

    private int mTextAppearance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.280 -0500", hash_original_field = "79934C5A9636D82AF51CC71C9BB83C43", hash_generated_field = "FABF004F46FE66709A563A85D0AA3A43")

    private Context mTextAppearanceContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.282 -0500", hash_original_field = "9A78AF9FF266DCF45093E360F2A20F63", hash_generated_field = "9F1A05DC3E20F6FB26386A8F9EF3BC7B")

    private boolean mPreserveIconSpacing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.284 -0500", hash_original_field = "22F461EF8744442EF12B7F711AEC30B1", hash_generated_field = "184D07E5D4523A6E0D44D4B7FCCF9501")

    
    private int mMenuType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.287 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    
    private LayoutInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.290 -0500", hash_original_field = "346196818A9B2A3ADB36739C20BD24C8", hash_generated_field = "341BE8DFD6FC410A2B4B3CF1435D4B11")


    private boolean mForceShowIcon;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.293 -0500", hash_original_method = "C8B59316A7D022025F82FC9BA82661FF", hash_generated_method = "5D90EA356D559FFECBA629AF8451A873")
    
public ListMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
    
        TypedArray a =
            context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.MenuView, defStyle, 0);
        
        mBackground = a.getDrawable(com.android.internal.R.styleable.MenuView_itemBackground);
        mTextAppearance = a.getResourceId(com.android.internal.R.styleable.
                                          MenuView_itemTextAppearance, -1);
        mPreserveIconSpacing = a.getBoolean(
                com.android.internal.R.styleable.MenuView_preserveIconSpacing, false);
        mTextAppearanceContext = context;
        
        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.296 -0500", hash_original_method = "8379DAC15AF7C56B575365B6BA969EC4", hash_generated_method = "3ECE3954132A49C62527952B04FFC2A2")
    
public ListMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.299 -0500", hash_original_method = "85E45C4D26BDFDA8B8A891EEA2149544", hash_generated_method = "B0D368C29975B8C8263B722A259774C8")
    
@Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        
        setBackgroundDrawable(mBackground);
        
        mTitleView = (TextView) findViewById(com.android.internal.R.id.title);
        if (mTextAppearance != -1) {
            mTitleView.setTextAppearance(mTextAppearanceContext,
                                         mTextAppearance);
        }
        
        mShortcutView = (TextView) findViewById(com.android.internal.R.id.shortcut);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.301 -0500", hash_original_method = "5092F6390AF72578BEED6176B75C91D1", hash_generated_method = "7911FEF4A7F230EDC0B8526B7BE80C89")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.304 -0500", hash_original_method = "D8A614357C6F3F0E863735D7939D36DF", hash_generated_method = "6DD6B415652CE63B767EE032FF05A7D7")
    
public void setForceShowIcon(boolean forceShow) {
        mPreserveIconSpacing = mForceShowIcon = forceShow;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.307 -0500", hash_original_method = "D643CEDDD2281EA2D982E86A77F53965", hash_generated_method = "F7A7AA68B81D8372BB137DFD0B06303B")
    
public void setTitle(CharSequence title) {
        if (title != null) {
            mTitleView.setText(title);
            
            if (mTitleView.getVisibility() != VISIBLE) mTitleView.setVisibility(VISIBLE);
        } else {
            if (mTitleView.getVisibility() != GONE) mTitleView.setVisibility(GONE);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.309 -0500", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "B0B9AF9FA2DDD827E4877533896893E2")
    
public MenuItemImpl getItemData() {
        return mItemData;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.313 -0500", hash_original_method = "10ED998AF45E09E3692DBD756F730611", hash_generated_method = "088A0999FBE652B72E59CAA6A3812BA2")
    
public void setCheckable(boolean checkable) {
        if (!checkable && mRadioButton == null && mCheckBox == null) {
            return;
        }
        
        // Depending on whether its exclusive check or not, the checkbox or
        // radio button will be the one in use (and the other will be otherCompoundButton)
        final CompoundButton compoundButton;
        final CompoundButton otherCompoundButton; 

        if (mItemData.isExclusiveCheckable()) {
            if (mRadioButton == null) {
                insertRadioButton();
            }
            compoundButton = mRadioButton;
            otherCompoundButton = mCheckBox;
        } else {
            if (mCheckBox == null) {
                insertCheckBox();
            }
            compoundButton = mCheckBox;
            otherCompoundButton = mRadioButton;
        }
        
        if (checkable) {
            compoundButton.setChecked(mItemData.isChecked());
            
            final int newVisibility = checkable ? VISIBLE : GONE;
            if (compoundButton.getVisibility() != newVisibility) {
                compoundButton.setVisibility(newVisibility);
            }
            
            // Make sure the other compound button isn't visible
            if (otherCompoundButton != null && otherCompoundButton.getVisibility() != GONE) {
                otherCompoundButton.setVisibility(GONE);
            }
        } else {
            if (mCheckBox != null) mCheckBox.setVisibility(GONE);
            if (mRadioButton != null) mRadioButton.setVisibility(GONE);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.316 -0500", hash_original_method = "1046275995CFEC2A71A54D8E1F9C97CC", hash_generated_method = "9CDEE5FCF8D835063BD3B1E6EF07C449")
    
public void setChecked(boolean checked) {
        CompoundButton compoundButton;
        
        if (mItemData.isExclusiveCheckable()) {
            if (mRadioButton == null) {
                insertRadioButton();
            }
            compoundButton = mRadioButton;
        } else {
            if (mCheckBox == null) {
                insertCheckBox();
            }
            compoundButton = mCheckBox;
        }
        
        compoundButton.setChecked(checked);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.318 -0500", hash_original_method = "4983CC204EB78339386267D8C73D5694", hash_generated_method = "ED46BFB4DF5F65769866569317E67734")
    
public void setShortcut(boolean showShortcut, char shortcutKey) {
        final int newVisibility = (showShortcut && mItemData.shouldShowShortcut())
                ? VISIBLE : GONE;

        if (newVisibility == VISIBLE) {
            mShortcutView.setText(mItemData.getShortcutLabel());
        }

        if (mShortcutView.getVisibility() != newVisibility) {
            mShortcutView.setVisibility(newVisibility);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.320 -0500", hash_original_method = "19EB37BE18B7BC088A147E31A5EAA2CE", hash_generated_method = "1A97A7AF0D3F0302F262777608BAACE8")
    
public void setIcon(Drawable icon) {
        final boolean showIcon = mItemData.shouldShowIcon() || mForceShowIcon;
        if (!showIcon && !mPreserveIconSpacing) {
            return;
        }
        
        if (mIconView == null && icon == null && !mPreserveIconSpacing) {
            return;
        }
        
        if (mIconView == null) {
            insertIconView();
        }
        
        if (icon != null || mPreserveIconSpacing) {
            mIconView.setImageDrawable(showIcon ? icon : null);

            if (mIconView.getVisibility() != VISIBLE) {
                mIconView.setVisibility(VISIBLE);
            }
        } else {
            mIconView.setVisibility(GONE);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.323 -0500", hash_original_method = "EB04FE2393D8303D2CC7459EB64C837F", hash_generated_method = "77AF6BC34B8BB654C8BD14BCCE5C8515")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mIconView != null && mPreserveIconSpacing) {
            // Enforce minimum icon spacing
            ViewGroup.LayoutParams lp = getLayoutParams();
            LayoutParams iconLp = (LayoutParams) mIconView.getLayoutParams();
            if (lp.height > 0 && iconLp.width <= 0) {
                iconLp.width = lp.height;
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.325 -0500", hash_original_method = "10F5F40E2932688DF3201248310D8E11", hash_generated_method = "65D823BAC85CEE4854CE993AA8856CC3")
    
private void insertIconView() {
        LayoutInflater inflater = getInflater();
        mIconView = (ImageView) inflater.inflate(com.android.internal.R.layout.list_menu_item_icon,
                this, false);
        addView(mIconView, 0);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.328 -0500", hash_original_method = "3AE05F112F28FE467A439CFB98DC5418", hash_generated_method = "81069E3DD0711088911BF7B3649166AF")
    
private void insertRadioButton() {
        LayoutInflater inflater = getInflater();
        mRadioButton =
                (RadioButton) inflater.inflate(com.android.internal.R.layout.list_menu_item_radio,
                this, false);
        addView(mRadioButton);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.330 -0500", hash_original_method = "C1CFD343D3CE36D4657F4BFD8E338B9A", hash_generated_method = "2B45440365DD1C5F85C37E2926E7151E")
    
private void insertCheckBox() {
        LayoutInflater inflater = getInflater();
        mCheckBox =
                (CheckBox) inflater.inflate(com.android.internal.R.layout.list_menu_item_checkbox,
                this, false);
        addView(mCheckBox);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.333 -0500", hash_original_method = "D007E81C6798ACEA5420D15C2FEE6142", hash_generated_method = "7037D9B13AFECD0CB38506EA0B1A035D")
    
public boolean prefersCondensedTitle() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.335 -0500", hash_original_method = "21090C746FF264700C0D2226436C9966", hash_generated_method = "F455E4A55396E10659BD5AA52E577314")
    
public boolean showsIcon() {
        return mForceShowIcon;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:38.337 -0500", hash_original_method = "800EDA97716EBA1ECAA54C866B1D88CB", hash_generated_method = "376EA249D7AB6A6A8275F0E352AE441C")
    
private LayoutInflater getInflater() {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(mContext);
        }
        return mInflater;
    }
}

