/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
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

/**
 * The item view for each item in the ListView-based MenuViews.
 *
 * @hide
 */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.208 -0400", hash_original_field = "53B00E23D91B0BDBA59BEB68DD2FF51B", hash_generated_field = "F05248E8BF4768CA949BBA4F641B42C3")


    private static final String TAG = "ListMenuItemView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.211 -0400", hash_original_field = "DBB703567F4F0AD8C976E510ACED07CC", hash_generated_field = "B32E7CB0DF6786FBC4DDA7C50169A79B")

    private MenuItemImpl mItemData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.214 -0400", hash_original_field = "069158469BB60C88A2C4A541C6AFB8D2", hash_generated_field = "411E3339296CF54457E86988903AF1A7")


    private ImageView mIconView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.217 -0400", hash_original_field = "E360002A71982849632CAD48DFDDC3F3", hash_generated_field = "1E1826A601ADC976D83D58732642409A")

    private RadioButton mRadioButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.219 -0400", hash_original_field = "B3B1177DB6C3A24EAC74C6705FD25300", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.226 -0400", hash_original_field = "476FA6AA33AC7D978E9C914FAF8C4885", hash_generated_field = "7182F33F1ED89613270531B36C5FCCCD")

    private CheckBox mCheckBox;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.228 -0400", hash_original_field = "FD42D5DFF831282A734A9A1CA7E9A0C6", hash_generated_field = "464E2E9B43628F927166B4B52A641B27")

    private TextView mShortcutView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.231 -0400", hash_original_field = "1414D97CE5ED674A74A05A07F83AE3BF", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")


    private Drawable mBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.234 -0400", hash_original_field = "12897BEF89A4C72FECFFDFE7F1200971", hash_generated_field = "E1363564E2F8BE551770EA738359CA9A")

    private int mTextAppearance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.237 -0400", hash_original_field = "79934C5A9636D82AF51CC71C9BB83C43", hash_generated_field = "FABF004F46FE66709A563A85D0AA3A43")

    private Context mTextAppearanceContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.239 -0400", hash_original_field = "9A78AF9FF266DCF45093E360F2A20F63", hash_generated_field = "9F1A05DC3E20F6FB26386A8F9EF3BC7B")

    private boolean mPreserveIconSpacing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.241 -0400", hash_original_field = "22F461EF8744442EF12B7F711AEC30B1", hash_generated_field = "184D07E5D4523A6E0D44D4B7FCCF9501")


    private int mMenuType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.245 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.248 -0400", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.250 -0400", hash_original_field = "346196818A9B2A3ADB36739C20BD24C8", hash_generated_field = "341BE8DFD6FC410A2B4B3CF1435D4B11")


    private boolean mForceShowIcon;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.256 -0400", hash_original_method = "F0D7160D1018424AA338D93AEF27BD36", hash_generated_method = "DFDF14C047DC9C4FFA2750A952BBA2E0")
    
public ListMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        mContext = context;

        TypedArray a =
                context.obtainStyledAttributes(
                        attrs, R.styleable.MenuView, defStyle, 0);

        mBackground = a.getDrawable(R.styleable.MenuView_android_itemBackground);
        mTextAppearance = a.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        mPreserveIconSpacing = a.getBoolean(
                R.styleable.MenuView_android_preserveIconSpacing, false);
        mTextAppearanceContext = context;

        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.260 -0400", hash_original_method = "8379DAC15AF7C56B575365B6BA969EC4", hash_generated_method = "3ECE3954132A49C62527952B04FFC2A2")
    
public ListMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.263 -0400", hash_original_method = "DB7C5E7077C30DB0BA9CE1495AD2B4DC", hash_generated_method = "20C699118ABE4E12B3FF6F77357449C5")
    
@Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        setBackgroundDrawable(mBackground);

        mTitleView = (TextView) findViewById(R.id.title);
        if (mTextAppearance != -1) {
            mTitleView.setTextAppearance(mTextAppearanceContext,
                    mTextAppearance);
        }

        mShortcutView = (TextView) findViewById(R.id.shortcut);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.273 -0400", hash_original_method = "5092F6390AF72578BEED6176B75C91D1", hash_generated_method = "7911FEF4A7F230EDC0B8526B7BE80C89")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.277 -0400", hash_original_method = "D8A614357C6F3F0E863735D7939D36DF", hash_generated_method = "6DD6B415652CE63B767EE032FF05A7D7")
    
public void setForceShowIcon(boolean forceShow) {
        mPreserveIconSpacing = mForceShowIcon = forceShow;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.280 -0400", hash_original_method = "F9C8E88E6F7AAE066C620089EA36E275", hash_generated_method = "601F6882DD50239A96E8BEB021E621A3")
    
public void setTitle(CharSequence title) {
        if (title != null) {
            mTitleView.setText(title);

            if (mTitleView.getVisibility() != VISIBLE) {
                mTitleView.setVisibility(VISIBLE);
            }
        } else {
            if (mTitleView.getVisibility() != GONE) {
                mTitleView.setVisibility(GONE);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.283 -0400", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "B0B9AF9FA2DDD827E4877533896893E2")
    
public MenuItemImpl getItemData() {
        return mItemData;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.290 -0400", hash_original_method = "D3A05B2439AF83F299F71F6C85E9A78F", hash_generated_method = "6F2CF1306B402931FCB158878F9DAAFE")
    
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
            if (mCheckBox != null) {
                mCheckBox.setVisibility(GONE);
            }
            if (mRadioButton != null) {
                mRadioButton.setVisibility(GONE);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.294 -0400", hash_original_method = "1046275995CFEC2A71A54D8E1F9C97CC", hash_generated_method = "9CDEE5FCF8D835063BD3B1E6EF07C449")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.298 -0400", hash_original_method = "4983CC204EB78339386267D8C73D5694", hash_generated_method = "ED46BFB4DF5F65769866569317E67734")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.302 -0400", hash_original_method = "19EB37BE18B7BC088A147E31A5EAA2CE", hash_generated_method = "1A97A7AF0D3F0302F262777608BAACE8")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.306 -0400", hash_original_method = "EB04FE2393D8303D2CC7459EB64C837F", hash_generated_method = "77AF6BC34B8BB654C8BD14BCCE5C8515")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.309 -0400", hash_original_method = "35CA27D07FB7EB07F716F7C7F710ADB0", hash_generated_method = "04372A21006BBF945D03B95F4833A833")
    
private void insertIconView() {
        LayoutInflater inflater = getInflater();
        mIconView = (ImageView) inflater.inflate(R.layout.abc_list_menu_item_icon,
                this, false);
        addView(mIconView, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.312 -0400", hash_original_method = "5925628F3187B2AAF2991F2F15DDC599", hash_generated_method = "EDD55994341CB427EC41C0EDF96752FD")
    
private void insertRadioButton() {
        LayoutInflater inflater = getInflater();
        mRadioButton =
                (RadioButton) inflater.inflate(R.layout.abc_list_menu_item_radio,
                        this, false);
        addView(mRadioButton);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.315 -0400", hash_original_method = "47EB9FC4A3B88BE7792183B30C944B2E", hash_generated_method = "57F724A57D834279E40FA7D386A88195")
    
private void insertCheckBox() {
        LayoutInflater inflater = getInflater();
        mCheckBox =
                (CheckBox) inflater.inflate(R.layout.abc_list_menu_item_checkbox,
                        this, false);
        addView(mCheckBox);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.318 -0400", hash_original_method = "D007E81C6798ACEA5420D15C2FEE6142", hash_generated_method = "7037D9B13AFECD0CB38506EA0B1A035D")
    
public boolean prefersCondensedTitle() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.320 -0400", hash_original_method = "21090C746FF264700C0D2226436C9966", hash_generated_method = "F455E4A55396E10659BD5AA52E577314")
    
public boolean showsIcon() {
        return mForceShowIcon;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-26 16:52:19.323 -0400", hash_original_method = "800EDA97716EBA1ECAA54C866B1D88CB", hash_generated_method = "376EA249D7AB6A6A8275F0E352AE441C")
    
private LayoutInflater getInflater() {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(mContext);
        }
        return mInflater;
    }
}

