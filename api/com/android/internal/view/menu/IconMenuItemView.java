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

package com.android.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.android.internal.view.menu.MenuBuilder.ItemInvoker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.widget.TextView;
import android.text.Layout;

/**
 * The item view for each item in the {@link IconMenuView}.  
 */
public final class IconMenuItemView extends TextView implements MenuView.ItemView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.120 -0400", hash_original_field = "F40A65A0161E245EB9410D7A796FE9B3", hash_generated_field = "0FC0F1E74EFFD499D7E9EC90666C1A5B")

    
    private static final int NO_ALPHA = 0xFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.134 -0400", hash_original_field = "59B421A8FE3BC25F62030250529693D7", hash_generated_field = "FC531438BE18962F76B22C0A35F07352")

    
    private static String sPrependShortcutLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.121 -0400", hash_original_field = "DCCB6493F341F9AED8C66CE3143E378A", hash_generated_field = "F84531E38F2FCF9F5A9F318DF05E11F8")

    
    private IconMenuView mIconMenuView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.122 -0400", hash_original_field = "04D7C0759CCBFA2E3CE809820984D44F", hash_generated_field = "D2D54C24932B8B9548FB244B0C3E4266")

    
    private ItemInvoker mItemInvoker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.123 -0400", hash_original_field = "DBB703567F4F0AD8C976E510ACED07CC", hash_generated_field = "B32E7CB0DF6786FBC4DDA7C50169A79B")

    private MenuItemImpl mItemData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.125 -0400", hash_original_field = "D2DFC3A60DC024AFBB674A2D69ECB436", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")
 
    
    private Drawable mIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.126 -0400", hash_original_field = "12897BEF89A4C72FECFFDFE7F1200971", hash_generated_field = "E1363564E2F8BE551770EA738359CA9A")

    
    private int mTextAppearance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.127 -0400", hash_original_field = "79934C5A9636D82AF51CC71C9BB83C43", hash_generated_field = "FABF004F46FE66709A563A85D0AA3A43")

    private Context mTextAppearanceContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.128 -0400", hash_original_field = "C7A330BE7142327056539F5ED284903D", hash_generated_field = "BE45430B4E582ECC76FDAE96B324FF18")

    
    private float mDisabledAlpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.129 -0400", hash_original_field = "4FF807289BB442CD7A293263C1B97554", hash_generated_field = "7F2AAB3196817165636438306614137E")


    private Rect mPositionIconAvailable = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.130 -0400", hash_original_field = "55A7AB3ED9A573FE7433EBFE5919291E", hash_generated_field = "8094973E932B3E44C1D67FDB46FBAE57")

    private Rect mPositionIconOutput = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.131 -0400", hash_original_field = "0808000BC906BBFFF9347349D6CEF4D2", hash_generated_field = "B974C6A55EADCFD20CCECF43CCCF46A3")

    
    private boolean mShortcutCaptionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.132 -0400", hash_original_field = "5829ED07E1B99332CFBD705AF3039B46", hash_generated_field = "9F852047E3713B4D362B0C9DE43574F4")

    private String mShortcutCaption;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.135 -0400", hash_original_method = "333E717CC82B8C7442AB1D0ECD021DDF", hash_generated_method = "6F6B0D78E1CF377096D851457BF351AE")
    
public IconMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);

        if (sPrependShortcutLabel == null) {
            /*
             * Views should only be constructed from the UI thread, so no
             * synchronization needed
             */
            sPrependShortcutLabel = getResources().getString(
                    com.android.internal.R.string.prepend_shortcut_label);
        }
        
        TypedArray a =
            context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.MenuView, defStyle, 0);

        mDisabledAlpha = a.getFloat(
                com.android.internal.R.styleable.MenuView_itemIconDisabledAlpha, 0.8f);
        mTextAppearance = a.getResourceId(com.android.internal.R.styleable.
                                          MenuView_itemTextAppearance, -1);
        mTextAppearanceContext = context;
        
        a.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.136 -0400", hash_original_method = "E8E8FF94AF2AEB616F5543925159C808", hash_generated_method = "9F99E7611BDC55B34DAF01DA96E1EDFE")
    
public IconMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * Initializes with the provided title and icon
     * @param title The title of this item
     * @param icon The icon of this item
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.137 -0400", hash_original_method = "D3EA499101C50F733538C7F2C71C7FCD", hash_generated_method = "D3EA499101C50F733538C7F2C71C7FCD")
    
void initialize(CharSequence title, Drawable icon) {
        setClickable(true);
        setFocusable(true);

        if (mTextAppearance != -1) {
            setTextAppearance(mTextAppearanceContext, mTextAppearance);
        }

        setTitle(title);
        setIcon(icon);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.138 -0400", hash_original_method = "1099F31E7523CC7CE24BCA918A71DE6A", hash_generated_method = "D25EF1F9C6321798341D05841121A1A4")
    
public void initialize(MenuItemImpl itemData, int menuType) {
        mItemData = itemData;

        initialize(itemData.getTitleForItemView(this), itemData.getIcon());
        
        setVisibility(itemData.isVisible() ? View.VISIBLE : View.GONE);
        setEnabled(itemData.isEnabled());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.139 -0400", hash_original_method = "408343F1CCEA5C2B74621865B3C13CF2", hash_generated_method = "ECC659F3F98CDE0401A24D2F3783E581")
    
public void setItemData(MenuItemImpl data) {
        mItemData = data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.141 -0400", hash_original_method = "1F3E4D754C7CA6574366D8D8716081C5", hash_generated_method = "62DA26937A87071F2A6E8E4CD9260695")
    
@Override
    public boolean performClick() {
        // Let the view's click listener have top priority (the More button relies on this)
        if (super.performClick()) {
            return true;
        }
        
        if ((mItemInvoker != null) && (mItemInvoker.invokeItem(mItemData))) {
            playSoundEffect(SoundEffectConstants.CLICK);
            return true;
        } else {
            return false;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.142 -0400", hash_original_method = "435DDD074156E5F8AC666AFC90F64B0C", hash_generated_method = "41B36929FF4D4DD9424680F0B7234956")
    
public void setTitle(CharSequence title) {
        
        if (mShortcutCaptionMode) {
            /*
             * Don't set the title directly since it will replace the
             * shortcut+title being shown. Instead, re-set the shortcut caption
             * mode so the new title is shown.
             */
            setCaptionMode(true);
            
        } else if (title != null) {
            setText(title);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.144 -0400", hash_original_method = "268E65D83193F6DFB62FB02E39B8BA58", hash_generated_method = "0DDB4C70222FDBA6A04A4A7707F7542D")
    
void setCaptionMode(boolean shortcut) {
        /*
         * If there is no item model, don't do any of the below (for example,
         * the 'More' item doesn't have a model)
         */
        if (mItemData == null) {
            return;
        }
        
        mShortcutCaptionMode = shortcut && (mItemData.shouldShowShortcut());
        
        CharSequence text = mItemData.getTitleForItemView(this);
        
        if (mShortcutCaptionMode) {
            
            if (mShortcutCaption == null) {
                mShortcutCaption = mItemData.getShortcutLabel();
            }

            text = mShortcutCaption;
        }
        
        setText(text);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.145 -0400", hash_original_method = "E86E1C6C90B3F8C756031A3C4EFA1265", hash_generated_method = "8D8A66C0F742CE02CB018A0CE0959DB5")
    
public void setIcon(Drawable icon) {
        mIcon = icon;
        
        if (icon != null) {
            
            /* Set the bounds of the icon since setCompoundDrawables needs it. */
            icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            
            // Set the compound drawables
            setCompoundDrawables(null, icon, null, null);
            
            // When there is an icon, make sure the text is at the bottom
            setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);

            /*
             * Request a layout to reposition the icon. The positioning of icon
             * depends on this TextView's line bounds, which is only available
             * after a layout.
             */  
            requestLayout();
        } else {
            setCompoundDrawables(null, null, null, null);
            
            // When there is no icon, make sure the text is centered vertically
            setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.146 -0400", hash_original_method = "F13132D83BCDECF7A96B81A8D9495932", hash_generated_method = "8CDC6550165C8F21FA08C4ADBBD2172B")
    
public void setItemInvoker(ItemInvoker itemInvoker) {
        mItemInvoker = itemInvoker;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.147 -0400", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "D1C17884E9F7977F4763F1A17C014F10")
    
@ViewDebug.CapturedViewProperty(retrieveReturn = true)
    public MenuItemImpl getItemData() {
        return mItemData;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.148 -0400", hash_original_method = "18E20B37C2037D9678EE3D5F626F477A", hash_generated_method = "E6C900E83CDB7B761468A040E831FD07")
    
@Override
    public void setVisibility(int v) {
        super.setVisibility(v);
        
        if (mIconMenuView != null) {
            // On visibility change, mark the IconMenuView to refresh itself eventually
            mIconMenuView.markStaleChildren();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.149 -0400", hash_original_method = "F41FC72E52D0D0429768759B38C272E5", hash_generated_method = "F41FC72E52D0D0429768759B38C272E5")
    
void setIconMenuView(IconMenuView iconMenuView) {
        mIconMenuView = iconMenuView;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.150 -0400", hash_original_method = "952F4BA8D09FBA47BFF7AA31D6EF11F8", hash_generated_method = "343015883A6EFFEB067405740779F734")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();

        if (mItemData != null && mIcon != null) {
            // When disabled, the not-focused state and the pressed state should
            // drop alpha on the icon
            final boolean isInAlphaState = !mItemData.isEnabled() && (isPressed() || !isFocused());
            mIcon.setAlpha(isInAlphaState ? (int) (mDisabledAlpha * NO_ALPHA) : NO_ALPHA);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.152 -0400", hash_original_method = "EC240A91CEC2FCFB14C22517271B909F", hash_generated_method = "0721A4F272FE0DD7848803E05D365B79")
    
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        
        positionIcon();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.154 -0400", hash_original_method = "B52C5A42BAF189526CC4D81203333F26", hash_generated_method = "3C93DC11486E6740832CE81CCFBCA8B0")
    
@Override
    protected void onTextChanged(CharSequence text, int start, int before, int after) {
        super.onTextChanged(text, start, before, after);

        // our layout params depend on the length of the text
        setLayoutParams(getTextAppropriateLayoutParams());
    }

    /**
     * @return layout params appropriate for this view.  If layout params already exist, it will
     *         augment them to be appropriate to the current text size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.155 -0400", hash_original_method = "1A7B65F16ED9AD94820131969E68B65D", hash_generated_method = "B5D36B8EF166B7CC7690845B054E6658")
    
IconMenuView.LayoutParams getTextAppropriateLayoutParams() {
        IconMenuView.LayoutParams lp = (IconMenuView.LayoutParams) getLayoutParams();
        if (lp == null) {
            // Default layout parameters
            lp = new IconMenuView.LayoutParams(
                    IconMenuView.LayoutParams.MATCH_PARENT, IconMenuView.LayoutParams.MATCH_PARENT);
        }

        // Set the desired width of item
        lp.desiredWidth = (int) Layout.getDesiredWidth(getText(), getPaint());

        return lp;
    }

    /**
     * Positions the icon vertically (horizontal centering is taken care of by
     * the TextView's gravity).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.156 -0400", hash_original_method = "4276555C70F21953C97B2894725A8F05", hash_generated_method = "B783FCAA93D26A5952251AD52CA88D25")
    
private void positionIcon() {
        
        if (mIcon == null) {
            return;
        }
        
        // We reuse the output rectangle as a temp rect
        Rect tmpRect = mPositionIconOutput;
        getLineBounds(0, tmpRect);
        mPositionIconAvailable.set(0, 0, getWidth(), tmpRect.top);
        final int layoutDirection = getResolvedLayoutDirection();
        Gravity.apply(Gravity.CENTER_VERTICAL | Gravity.LEFT, mIcon.getIntrinsicWidth(), mIcon
                .getIntrinsicHeight(), mPositionIconAvailable, mPositionIconOutput,
                layoutDirection);
        mIcon.setBounds(mPositionIconOutput);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.157 -0400", hash_original_method = "206C9D092F8D2CE8A945E1A45B818CB4", hash_generated_method = "706B117279D8EB3DCAEBCDCA07941E24")
    
public void setCheckable(boolean checkable) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.158 -0400", hash_original_method = "98D5E38367DB01B2323D3E891737183A", hash_generated_method = "6E4010A95DDAC0F1431C1795FCBB8CE0")
    
public void setChecked(boolean checked) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.159 -0400", hash_original_method = "BBB3858AAFDAD9070C5F59311E1CA341", hash_generated_method = "7FC2EC447762FA1F351F130D16A8DF5D")
    
public void setShortcut(boolean showShortcut, char shortcutKey) {
        
        if (mShortcutCaptionMode) {
            /*
             * Shortcut has changed and we're showing it right now, need to
             * update (clear the old one first).
             */
            mShortcutCaption = null;
            setCaptionMode(true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.160 -0400", hash_original_method = "A2F62AB27113ADE9EE493677370BEC6F", hash_generated_method = "EAF4F3B980307BACF84AAB2557327ACE")
    
public boolean prefersCondensedTitle() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.161 -0400", hash_original_method = "C76AE16CD3DCE07A39A065D6C2B5EB3F", hash_generated_method = "FAD9516926F7D312A8FE978C46B59F8A")
    
public boolean showsIcon() {
        return true;
    }

}
