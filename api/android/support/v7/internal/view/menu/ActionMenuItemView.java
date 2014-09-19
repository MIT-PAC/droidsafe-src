/*
 * Copyright (C) 2010 The Android Open Source Project
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
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.CompatTextView;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * @hide
 */
public class ActionMenuItemView extends CompatTextView
        implements MenuView.ItemView, View.OnClickListener, View.OnLongClickListener,
        ActionMenuView.ActionMenuChildView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.399 -0400", hash_original_field = "5E900415DC83EB4A21128A5F009D6AD3", hash_generated_field = "59FAE62321B2FBA7C3D29B6855696300")


    private static final String TAG = "ActionMenuItemView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.410 -0400", hash_original_field = "DBB703567F4F0AD8C976E510ACED07CC", hash_generated_field = "B32E7CB0DF6786FBC4DDA7C50169A79B")


    private MenuItemImpl mItemData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.416 -0400", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.422 -0400", hash_original_field = "D2DFC3A60DC024AFBB674A2D69ECB436", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.430 -0400", hash_original_field = "3873EAC5176BA972832B90424E16F31B", hash_generated_field = "FCA7C24D10E4756C2F866687779CE7A2")

    private MenuBuilder.ItemInvoker mItemInvoker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.446 -0400", hash_original_field = "0702D0132C7EEE9027A2928CF259A952", hash_generated_field = "026998B37BE3694ADAD845A945E977A5")


    private boolean mAllowTextWithIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.454 -0400", hash_original_field = "D4382F3ED434DC2AD3ED58497C2CF171", hash_generated_field = "8BCC0CCB20D7838DC0FF6BF986026A67")

    private boolean mExpandedFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.460 -0400", hash_original_field = "B5D566AA92521F570066E8773A24B0C0", hash_generated_field = "ED0C6BF081117F2A257C521DB4125AB9")

    private int mMinWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.467 -0400", hash_original_field = "2AB637240101089B21F4844E70E70B9E", hash_generated_field = "C131A093D39A32BE98FB33A5D2719904")

    private int mSavedPaddingLeft;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.475 -0400", hash_original_method = "A9C9E45D494EF4E28228859D4DA5948C", hash_generated_method = "91AFDFED7E9E4BB957665A65DA1425D2")
    
public ActionMenuItemView(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.483 -0400", hash_original_method = "414C1C737BA41080151B3C84CB3C1FDA", hash_generated_method = "87214AEC09D948C7F0D6DC9CACBE6A85")
    
public ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.502 -0400", hash_original_method = "5500807090AC69F9FE4CCAE3E27D34BC", hash_generated_method = "4207BAAE2DAB4B711B7EFC0D7C69FF63")
    
public ActionMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        final Resources res = context.getResources();
        mAllowTextWithIcon = res.getBoolean(
                android.support.v7.appcompat.R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray a = context.obtainStyledAttributes(attrs,
                android.support.v7.appcompat.R.styleable.ActionMenuItemView, 0, 0);
        mMinWidth = a.getDimensionPixelSize(
                R.styleable.ActionMenuItemView_android_minWidth, 0);
        a.recycle();

        setOnClickListener(this);
        setOnLongClickListener(this);

        setTransformationMethod(new AllCapsTransformationMethod());

        mSavedPaddingLeft = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.512 -0400", hash_original_method = "F35454F1D92A4775A94051EBE6A6FC2F", hash_generated_method = "31A77FFD010DD1F271989E0936196595")
    
@Override
    public void setPadding(int l, int t, int r, int b) {
        mSavedPaddingLeft = l;
        super.setPadding(l, t, r, b);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.519 -0400", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "B0B9AF9FA2DDD827E4877533896893E2")
    
public MenuItemImpl getItemData() {
        return mItemData;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.558 -0400", hash_original_method = "F3ADD2CA2E2A1F1636EEF9ECFE1172AF", hash_generated_method = "3BD3E26FCD7FBA7C893F1862F0D48A86")
    
public void initialize(MenuItemImpl itemData, int menuType) {
        mItemData = itemData;

        setIcon(itemData.getIcon());
        setTitle(itemData.getTitleForItemView(this)); // Title only takes effect if there is no icon
        setId(itemData.getItemId());

        setVisibility(itemData.isVisible() ? View.VISIBLE : View.GONE);
        setEnabled(itemData.isEnabled());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.566 -0400", hash_original_method = "B665A21C15F294A662D29A2BA3A7A359", hash_generated_method = "65B53CE5C8BCAADCAFE5306720FD4967")
    
public void onClick(View v) {
        if (mItemInvoker != null) {
            mItemInvoker.invokeItem(mItemData);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.573 -0400", hash_original_method = "D4B10D907261C4745939FD5942191820", hash_generated_method = "4783FD42B5554823B93906301DBAAE90")
    
public void setItemInvoker(MenuBuilder.ItemInvoker invoker) {
        mItemInvoker = invoker;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.579 -0400", hash_original_method = "A2F62AB27113ADE9EE493677370BEC6F", hash_generated_method = "EAF4F3B980307BACF84AAB2557327ACE")
    
public boolean prefersCondensedTitle() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.587 -0400", hash_original_method = "206C9D092F8D2CE8A945E1A45B818CB4", hash_generated_method = "190A86B6FCC2D0FB7D679FA2B212DD27")
    
public void setCheckable(boolean checkable) {
        // TODO Support checkable action items
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.593 -0400", hash_original_method = "98D5E38367DB01B2323D3E891737183A", hash_generated_method = "FD79D39CDBCB9A353A0E4D9EECD3BA27")
    
public void setChecked(boolean checked) {
        // TODO Support checkable action items
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.603 -0400", hash_original_method = "4B7C35F58E3B5D585DF448A46B8AF434", hash_generated_method = "C1C279B2A64D79787BDEE19FDD350769")
    
public void setExpandedFormat(boolean expandedFormat) {
        if (mExpandedFormat != expandedFormat) {
            mExpandedFormat = expandedFormat;
            if (mItemData != null) {
                mItemData.actionFormatChanged();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.611 -0400", hash_original_method = "78929A2ED0A9B50DFA4E11E3E3810E89", hash_generated_method = "6B0784586522D5DF776D9F2880678965")
    
private void updateTextButtonVisibility() {
        boolean visible = !TextUtils.isEmpty(mTitle);
        visible &= mIcon == null ||
                (mItemData.showsTextAsAction() && (mAllowTextWithIcon || mExpandedFormat));

        setText(visible ? mTitle : null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.621 -0400", hash_original_method = "BC3EB91626A3C866EB6D8A60C3997455", hash_generated_method = "D5ACFABEC3E1732DEB6F1F60D1E7345E")
    
public void setIcon(Drawable icon) {
        mIcon = icon;
        setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);

        updateTextButtonVisibility();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.629 -0400", hash_original_method = "9EAD604ADB1D4A5592653CDC25C03213", hash_generated_method = "4A708C44397566E5C649F115FE4957CF")
    
public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.637 -0400", hash_original_method = "85A41D343B47A7443CFB0CEF90E94BCA", hash_generated_method = "A602A3D9225E44DB42D70BA9D23108A5")
    
public void setShortcut(boolean showShortcut, char shortcutKey) {
        // Action buttons don't show text for shortcut keys.
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.644 -0400", hash_original_method = "826A85A4B958D464F222316151EFD6CA", hash_generated_method = "E83A1B8C7E958E3880E551277E930313")
    
public void setTitle(CharSequence title) {
        mTitle = title;

        setContentDescription(mTitle);
        updateTextButtonVisibility();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.650 -0400", hash_original_method = "C76AE16CD3DCE07A39A065D6C2B5EB3F", hash_generated_method = "FAD9516926F7D312A8FE978C46B59F8A")
    
public boolean showsIcon() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.658 -0400", hash_original_method = "6E6CD62A341ADB3BA1A0AA59225DD877", hash_generated_method = "FE88FE30B1A5236EA1B105EE42CE4F1F")
    
public boolean needsDividerBefore() {
        return hasText() && mItemData.getIcon() == null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.664 -0400", hash_original_method = "20C5403BD48B33FD0977D6BAA2D766A2", hash_generated_method = "A0E113A1C8848D7BFCD7B37E8887D853")
    
public boolean needsDividerAfter() {
        return hasText();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.682 -0400", hash_original_method = "10936D3B137771DD6A653DC8F3F943BC", hash_generated_method = "426553A69A4B123A45A4CE5BF91333E1")
    
@Override
    public boolean onLongClick(View v) {
        if (hasText()) {
            // Don't show the cheat sheet for items that already show text.
            return false;
        }

        final int[] screenPos = new int[2];
        final Rect displayFrame = new Rect();
        getLocationOnScreen(screenPos);
        getWindowVisibleDisplayFrame(displayFrame);

        final Context context = getContext();
        final int width = getWidth();
        final int height = getHeight();
        final int midy = screenPos[1] + height / 2;
        final int screenWidth = context.getResources().getDisplayMetrics().widthPixels;

        Toast cheatSheet = Toast.makeText(context, mItemData.getTitle(), Toast.LENGTH_SHORT);
        if (midy < displayFrame.height()) {
            // Show along the top; follow action buttons
            cheatSheet.setGravity(Gravity.TOP | Gravity.RIGHT,
                    screenWidth - screenPos[0] - width / 2, height);
        } else {
            // Show along the bottom center
            cheatSheet.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, height);
        }
        cheatSheet.show();
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 14:23:36.699 -0400", hash_original_method = "A017C47B0C51DF5D158A72400C12A1B8", hash_generated_method = "2CA251D1B6A8E2536BCD9277C25E8A2E")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final boolean textVisible = hasText();
        if (textVisible && mSavedPaddingLeft >= 0) {
            super.setPadding(mSavedPaddingLeft, getPaddingTop(),
                    getPaddingRight(), getPaddingBottom());
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        final int oldMeasuredWidth = getMeasuredWidth();
        final int targetWidth = widthMode == MeasureSpec.AT_MOST ? Math.min(widthSize, mMinWidth)
                : mMinWidth;

        if (widthMode != MeasureSpec.EXACTLY && mMinWidth > 0 && oldMeasuredWidth < targetWidth) {
            // Remeasure at exactly the minimum width.
            super.onMeasure(MeasureSpec.makeMeasureSpec(targetWidth, MeasureSpec.EXACTLY),
                    heightMeasureSpec);
        }

        if (!textVisible && mIcon != null) {
            // TextView won't center compound drawables in both dimensions without
            // a little coercion. Pad in to center the icon after we've measured.
            final int w = getMeasuredWidth();
            final int dw = mIcon.getIntrinsicWidth();
            super.setPadding((w - dw) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    private class AllCapsTransformationMethod implements TransformationMethod {
        private Locale mLocale;

        public AllCapsTransformationMethod() {
            mLocale = getContext().getResources().getConfiguration().locale;
        }

        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source != null ? source.toString().toUpperCase(mLocale) : null;
        }

        @Override
        public void onFocusChanged(View view, CharSequence sourceText, boolean focused,
                int direction, Rect previouslyFocusedRect) {
        }
    }
}
