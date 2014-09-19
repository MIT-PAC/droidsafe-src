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

package android.support.v7.internal.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.appcompat.R;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A ListPopupWindow anchors itself to a host view and displays a list of choices.
 *
 * <p>ListPopupWindow contains a number of tricky behaviors surrounding positioning, scrolling
 * parents to fit the dropdown, interacting sanely with the IME if present, and others.
 *
 * @see android.widget.AutoCompleteTextView
 * @see android.widget.Spinner
 *
 * @hide
 */
public class ListPopupWindow {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.327 -0400", hash_original_field = "9B22868DBB778B77630F608FF41CCE95", hash_generated_field = "0887B70F50539FED12873EB1C34B6CEE")


    private static final String TAG = "ListPopupWindow";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.329 -0400", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.331 -0400", hash_original_field = "63E31023FAF651A8B13F7E116CC0E635", hash_generated_field = "F8D801998654223FA4FA41D41E9F5E7A")

    private static final int EXPAND_LIST_TIMEOUT = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.394 -0400", hash_original_field = "5D4DDA54BDBCC4B2BCCBA859119EDD58", hash_generated_field = "513C25DC2079D3E3F448C17AD7E45103")

    public static final int POSITION_PROMPT_ABOVE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.397 -0400", hash_original_field = "22C7D2938BD863FDD9C2E4B7EB8903FA", hash_generated_field = "0DC2E01EB82FA75DF06F7820DDC407FC")

    public static final int POSITION_PROMPT_BELOW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.399 -0400", hash_original_field = "4F950873284673FB6933C0BCA03302F1", hash_generated_field = "E45F9503F4445E1C0398C7CBF50C48D5")

    public static final int FILL_PARENT = ViewGroup.LayoutParams.FILL_PARENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.401 -0400", hash_original_field = "966C6C7D7E8915D4E16EB7C44380872C", hash_generated_field = "09891BB8998BC15D0579567ED28F8125")

    public static final int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.404 -0400", hash_original_field = "51C805E580F4804E6EB846E2806A998C", hash_generated_field = "25DC4C7F5035D071A009268061A8DECC")

    public static final int INPUT_METHOD_FROM_FOCUSABLE = PopupWindow.INPUT_METHOD_FROM_FOCUSABLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.406 -0400", hash_original_field = "5234FA127C35862ABEA72AA56D02CE31", hash_generated_field = "BC380AA3102B060D07B4A59A29280852")

    public static final int INPUT_METHOD_NEEDED = PopupWindow.INPUT_METHOD_NEEDED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.409 -0400", hash_original_field = "6E80BB3A1EABC6287A401C3AB04C3CE7", hash_generated_field = "B45F005145864928FF3B5CE220951262")

    public static final int INPUT_METHOD_NOT_NEEDED = PopupWindow.INPUT_METHOD_NOT_NEEDED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.335 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.337 -0400", hash_original_field = "7E4C7D8A72122A6640DF0AA884C2245D", hash_generated_field = "DD5B28EB4059D1AC7E72BAEDE50FACDF")

    private PopupWindow mPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.338 -0400", hash_original_field = "CBDD62EF585589E92C0E00AE9F4F22E2", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.340 -0400", hash_original_field = "D2EA713CFF74C79305B1A85CAA4758A3", hash_generated_field = "680F69659AC661E81526EC1B57AD0760")

    private DropDownListView mDropDownList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.342 -0400", hash_original_field = "47629D9301A11E5A90DB7FD16C630178", hash_generated_field = "95C5FD2B2227A2419A547D55212619CB")


    private int mDropDownHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.344 -0400", hash_original_field = "1FBF54D200826BE24A98634613FB66C2", hash_generated_field = "DE8B8CD76D1AB415FF96E39AF3C5D34E")

    private int mDropDownWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.346 -0400", hash_original_field = "F488E81DEDCF27807554F505CB261AEB", hash_generated_field = "E0B55CC77CB214A3579F9BF96330095D")

    private int mDropDownHorizontalOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.348 -0400", hash_original_field = "34094FADF72E1CFF7A6E4691913199A5", hash_generated_field = "3B23099D02FB8FF58FFC662868C0BB03")

    private int mDropDownVerticalOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.351 -0400", hash_original_field = "B50C09E974CBAB52C3A2CAAC73824C09", hash_generated_field = "EF2837EA9E1F32EA5B98F304DCD2B02D")

    private boolean mDropDownVerticalOffsetSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.353 -0400", hash_original_field = "E408A4A94243B7CFBFDDDE18659D6637", hash_generated_field = "A2A88CD1765159B88DD7DB6DD2826AA7")


    private boolean mDropDownAlwaysVisible = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.355 -0400", hash_original_field = "38CCFB5B729C0D1016E8CD1FEEC6A290", hash_generated_field = "D1BD29312DE39A83C4D6D5BDC2010A61")

    private boolean mForceIgnoreOutsideTouch = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.357 -0400", hash_original_field = "B5EDBF08EC87E5E419CCBD4768539463", hash_generated_field = "B5EDBF08EC87E5E419CCBD4768539463")

    int mListItemExpandMaximum = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.359 -0400", hash_original_field = "5449FEC726829211DD8244A31A4FD026", hash_generated_field = "5F49A121459BF7DF82F93F51F66D9AFA")


    private View mPromptView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.361 -0400", hash_original_field = "CC2799DFE9A02CE4FAA05B620FA5203C", hash_generated_field = "D0EDBCF4B24F722A68C83DBD4FA7D38D")

    private int mPromptPosition = POSITION_PROMPT_ABOVE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.363 -0400", hash_original_field = "7F4E88E932CA04F746195B78340FAF19", hash_generated_field = "3BA4BCC5F225A10F755FE4D117871D40")


    private DataSetObserver mObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.364 -0400", hash_original_field = "9E0D6B2D2C41BFB970F7F40314CA67CA", hash_generated_field = "0AD13AB5208CE821A0A2BF31AEC73CB4")


    private View mDropDownAnchorView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.366 -0400", hash_original_field = "CF26749AC69E503F0E6CEE9E8D3F679D", hash_generated_field = "D7FBC36DD90F3884476AF7A145F7D085")


    private Drawable mDropDownListHighlight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.369 -0400", hash_original_field = "C3BCFE8177AEF338D4004A6DD4D2D8EF", hash_generated_field = "91F251C39E992AB6E9A1F97E1DB2D65A")


    private AdapterView.OnItemClickListener mItemClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.371 -0400", hash_original_field = "95D49B221C26B1A3334D3BD6A6E6E61A", hash_generated_field = "B20A14E839638431419A27C6FA2EB183")

    private AdapterView.OnItemSelectedListener mItemSelectedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.374 -0400", hash_original_field = "870EB41A3AD8AF770D57D2B2C2386419", hash_generated_field = "821F70C70BBBE64322F054DCBDCBD65D")


    private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.376 -0400", hash_original_field = "9EC385C13CED9DB47D8864C0559278A1", hash_generated_field = "C2DF6DA91E71FE1B73AF2F99DA491C65")

    private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.378 -0400", hash_original_field = "3770B47A24DD321648564621CF0B3704", hash_generated_field = "7119F706A3F3F75D0AB9F70CFDF2D458")

    private final PopupScrollListener mScrollListener = new PopupScrollListener();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.381 -0400", hash_original_field = "E2D3F2C921CE1BBE9E4E348336B0A9D5", hash_generated_field = "368F7081BBFDFED86D539FFD5855A591")

    private final ListSelectorHider mHideSelector = new ListSelectorHider();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.383 -0400", hash_original_field = "AF08E013791944040F11EFFF718596A9", hash_generated_field = "61A25C839F09B3FC31C414DE40E67DB5")

    private Runnable mShowDropDownRunnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.386 -0400", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")


    private Handler mHandler = new Handler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.388 -0400", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")


    private Rect mTempRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.390 -0400", hash_original_field = "35472579238A24390A4D232395567A7B", hash_generated_field = "2CBF8E91F49F039C5D23189C3E7CE590")


    private boolean mModal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.391 -0400", hash_original_field = "25224C4BC0BA1B889B916743A9183796", hash_generated_field = "1F66B12F4B6F8226A24764A3172D159B")


    private int mLayoutDirection;

    /**
     * Create a new, empty popup window capable of displaying items from a ListAdapter. Backgrounds
     * should be set using {@link #setBackgroundDrawable(Drawable)}.
     *
     * @param context Context used for contained views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.411 -0400", hash_original_method = "75D2B83A63B4BE8C358F5A7E0B96882C", hash_generated_method = "62AB15467CFBC10D50485837E9D2E1C7")
    
public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    /**
     * Create a new, empty popup window capable of displaying items from a ListAdapter. Backgrounds
     * should be set using {@link #setBackgroundDrawable(Drawable)}.
     *
     * @param context Context used for contained views.
     * @param attrs   Attributes from inflating parent views used to style the popup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.414 -0400", hash_original_method = "8885001789F1D4CE289E796C1869FCFB", hash_generated_method = "478D60271B161C867DCBC3FB9225FCCB")
    
public ListPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.listPopupWindowStyle);
    }

    /**
     * Create a new, empty popup window capable of displaying items from a ListAdapter. Backgrounds
     * should be set using {@link #setBackgroundDrawable(Drawable)}.
     *
     * @param context      Context used for contained views.
     * @param attrs        Attributes from inflating parent views used to style the popup.
     * @param defStyleAttr Default style attribute to use for popup content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.417 -0400", hash_original_method = "C9331549717A7360177AAE2F21A7587F", hash_generated_method = "03F0B9DB979273949B1516291C554DCC")
    
public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        mContext = context;
        mPopup = new PopupWindow(context, attrs, defStyleAttr);
        mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        // Set the default layout direction to match the default locale one
        final Locale locale = mContext.getResources().getConfiguration().locale;

    }

    /**
     * Sets the adapter that provides the data and the views to represent the data in this popup
     * window.
     *
     * @param adapter The adapter to use to create this window's content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.420 -0400", hash_original_method = "B55D1F7EE07C2CDF60B7B314069C1E48", hash_generated_method = "B764CB836CA397C20E9F89EB820E1329")
    
public void setAdapter(ListAdapter adapter) {
        if (mObserver == null) {
            mObserver = new PopupDataSetObserver();
        } else if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mObserver);
        }
        mAdapter = adapter;
        if (mAdapter != null) {
            adapter.registerDataSetObserver(mObserver);
        }

        if (mDropDownList != null) {
            mDropDownList.setAdapter(mAdapter);
        }
    }

    /**
     * Set where the optional prompt view should appear. The default is {@link
     * #POSITION_PROMPT_ABOVE}.
     *
     * @param position A position constant declaring where the prompt should be displayed.
     * @see #POSITION_PROMPT_ABOVE
     * @see #POSITION_PROMPT_BELOW
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.422 -0400", hash_original_method = "7CC61A3797371517F86E3D676D22847C", hash_generated_method = "F9B7E352B31FDFA171B19567C2207FC5")
    
public void setPromptPosition(int position) {
        mPromptPosition = position;
    }

    /**
     * @return Where the optional prompt view should appear.
     * @see #POSITION_PROMPT_ABOVE
     * @see #POSITION_PROMPT_BELOW
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.425 -0400", hash_original_method = "DF9D97B46096A1E4CCF9033CE8B43A47", hash_generated_method = "ED70513AB0BFFA1311B014B32D36D7DC")
    
public int getPromptPosition() {
        return mPromptPosition;
    }

    /**
     * Set whether this window should be modal when shown.
     *
     * <p>If a popup window is modal, it will receive all touch and key input. If the user touches
     * outside the popup window's content area the popup window will be dismissed.
     *
     * @param modal {@code true} if the popup window should be modal, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.427 -0400", hash_original_method = "320A57FA9129485B3F1A01EDA8808ED5", hash_generated_method = "6C2C1410866D1D61A1A62A8C0391C92E")
    
public void setModal(boolean modal) {
        mModal = true;
        mPopup.setFocusable(modal);
    }

    /**
     * Returns whether the popup window will be modal when shown.
     *
     * @return {@code true} if the popup window will be modal, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.429 -0400", hash_original_method = "195244B0122E9C532D039816F791192C", hash_generated_method = "E010DC4AD1AE58BC0D2925422A5D303B")
    
public boolean isModal() {
        return mModal;
    }

    /**
     * Forces outside touches to be ignored. Normally if {@link #isDropDownAlwaysVisible()} is
     * false, we allow outside touch to dismiss the dropdown. If this is set to true, then we ignore
     * outside touch even when the drop down is not set to always visible.
     *
     * @hide Used only by AutoCompleteTextView to handle some internal special cases.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.431 -0400", hash_original_method = "B51F6D3B2B582EB2529861E286FFBDAA", hash_generated_method = "3174FFB3813C26E1F0A01179B54B8139")
    
public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
    }

    /**
     * Sets whether the drop-down should remain visible under certain conditions.
     *
     * The drop-down will occupy the entire screen below {@link #getAnchorView} regardless of the
     * size or content of the list.  {@link #getBackground()} will fill any space that is not used
     * by the list.
     *
     * @param dropDownAlwaysVisible Whether to keep the drop-down visible.
     * @hide Only used by AutoCompleteTextView under special conditions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.433 -0400", hash_original_method = "0D7558B683A811B4FB459E3A92DCFACB", hash_generated_method = "CF697164CB7A979E67CC23BB02F0C16F")
    
public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        mDropDownAlwaysVisible = dropDownAlwaysVisible;
    }

    /**
     * @return Whether the drop-down is visible under special conditions.
     * @hide Only used by AutoCompleteTextView under special conditions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.435 -0400", hash_original_method = "452BC62A357E5A143092E81C66B09D6A", hash_generated_method = "D16C0015621EAF41B3CE3173EE0781BF")
    
public boolean isDropDownAlwaysVisible() {
        return mDropDownAlwaysVisible;
    }

    /**
     * Sets the operating mode for the soft input area.
     *
     * @param mode The desired mode, see {@link android.view.WindowManager.LayoutParams#softInputMode}
     *             for the full list
     * @see android.view.WindowManager.LayoutParams#softInputMode
     * @see #getSoftInputMode()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.437 -0400", hash_original_method = "E80B835CA17A4D3E815EC079FA1EE953", hash_generated_method = "6F33DB8F703DFF6D3352DF67AA4D9723")
    
public void setSoftInputMode(int mode) {
        mPopup.setSoftInputMode(mode);
    }

    /**
     * Returns the current value in {@link #setSoftInputMode(int)}.
     *
     * @see #setSoftInputMode(int)
     * @see android.view.WindowManager.LayoutParams#softInputMode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.440 -0400", hash_original_method = "EF5235E70AE7C9521CFD0F4410B9073C", hash_generated_method = "34F28FB52B6DAFF7E76E087895AE72A9")
    
public int getSoftInputMode() {
        return mPopup.getSoftInputMode();
    }

    /**
     * Sets a drawable to use as the list item selector.
     *
     * @param selector List selector drawable to use in the popup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.442 -0400", hash_original_method = "00D6E099D8DC922D12B17B03F893B884", hash_generated_method = "383695E39099FD03667C952B7D41FE4A")
    
public void setListSelector(Drawable selector) {
        mDropDownListHighlight = selector;
    }

    /**
     * @return The background drawable for the popup window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.444 -0400", hash_original_method = "48A20BD7A1656DF8848E524613AD69C1", hash_generated_method = "8361F633C9EE2A209A5F0E8043587AC9")
    
public Drawable getBackground() {
        return mPopup.getBackground();
    }

    /**
     * Sets a drawable to be the background for the popup window.
     *
     * @param d A drawable to set as the background.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.447 -0400", hash_original_method = "53EE8E67A046C4A20122C0C008F8CCAA", hash_generated_method = "3F2D5FAE7B7F15768348E05BF53B40CD")
    
public void setBackgroundDrawable(Drawable d) {
        mPopup.setBackgroundDrawable(d);
    }

    /**
     * Set an animation style to use when the popup window is shown or dismissed.
     *
     * @param animationStyle Animation style to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.449 -0400", hash_original_method = "CF4F09D135A7A5849055A447382D076E", hash_generated_method = "51C2A0238784BAF4CD2E35C1C31D1F1C")
    
public void setAnimationStyle(int animationStyle) {
        mPopup.setAnimationStyle(animationStyle);
    }

    /**
     * Returns the animation style that will be used when the popup window is shown or dismissed.
     *
     * @return Animation style that will be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.451 -0400", hash_original_method = "A53F654A1BF514C432C9F43DB9ED5E7B", hash_generated_method = "1306DC89DF94081356E55A19EE8661CD")
    
public int getAnimationStyle() {
        return mPopup.getAnimationStyle();
    }

    /**
     * Returns the view that will be used to anchor this popup.
     *
     * @return The popup's anchor view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.453 -0400", hash_original_method = "875C75F19631B214BE64A011FD6A41E4", hash_generated_method = "018CCB43785B73150669A8D96162E023")
    
public View getAnchorView() {
        return mDropDownAnchorView;
    }

    /**
     * Sets the popup's anchor view. This popup will always be positioned relative to the anchor
     * view when shown.
     *
     * @param anchor The view to use as an anchor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.455 -0400", hash_original_method = "91753F7FEC6E3180927B7B9D55B8E090", hash_generated_method = "05957B93E91DF796FD2FC16581760FF3")
    
public void setAnchorView(View anchor) {
        mDropDownAnchorView = anchor;
    }

    /**
     * @return The horizontal offset of the popup from its anchor in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.457 -0400", hash_original_method = "2C5F7D64A15BDC64E0A7D1677E996184", hash_generated_method = "13EFA9158560F614588B8F5CF120A6A9")
    
public int getHorizontalOffset() {
        return mDropDownHorizontalOffset;
    }

    /**
     * Set the horizontal offset of this popup from its anchor view in pixels.
     *
     * @param offset The horizontal offset of the popup from its anchor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.459 -0400", hash_original_method = "37914D7AC2B7A80AA5FE528B058A9DBC", hash_generated_method = "9895E3FFBA6000436D485FAD8DC69D5D")
    
public void setHorizontalOffset(int offset) {
        mDropDownHorizontalOffset = offset;
    }

    /**
     * @return The vertical offset of the popup from its anchor in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.461 -0400", hash_original_method = "06BDE5646BE562A7D86252C676418C82", hash_generated_method = "DA7FAA8E025244FD39561BA6F341391F")
    
public int getVerticalOffset() {
        if (!mDropDownVerticalOffsetSet) {
            return 0;
        }
        return mDropDownVerticalOffset;
    }

    /**
     * Set the vertical offset of this popup from its anchor view in pixels.
     *
     * @param offset The vertical offset of the popup from its anchor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.463 -0400", hash_original_method = "F61671411958DBF85FB58F84EEE162C4", hash_generated_method = "F2E0C247361B54640FD6BE9AB2AD3808")
    
public void setVerticalOffset(int offset) {
        mDropDownVerticalOffset = offset;
        mDropDownVerticalOffsetSet = true;
    }

    /**
     * @return The width of the popup window in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.465 -0400", hash_original_method = "6205F90E667ADE4444482E9AC195FB48", hash_generated_method = "52ADB8330CF1D99BDB9100B431908C2D")
    
public int getWidth() {
        return mDropDownWidth;
    }

    /**
     * Sets the width of the popup window in pixels. Can also be {@link #FILL_PARENT} or {@link
     * #WRAP_CONTENT}.
     *
     * @param width Width of the popup window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.467 -0400", hash_original_method = "1FDBBF009B47D57DAE1EE309EAA8DA19", hash_generated_method = "8822955A1449CC5CD1B2A22976B7B662")
    
public void setWidth(int width) {
        mDropDownWidth = width;
    }

    /**
     * Sets the width of the popup window by the size of its content. The final width may be larger
     * to accommodate styled window dressing.
     *
     * @param width Desired width of content in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.471 -0400", hash_original_method = "1CC81B1489D8EBDAA358E87EA72284F9", hash_generated_method = "B7561C3A7CA7F311BEEA8084196A7B42")
    
public void setContentWidth(int width) {
        Drawable popupBackground = mPopup.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(mTempRect);
            mDropDownWidth = mTempRect.left + mTempRect.right + width;
        } else {
            setWidth(width);
        }
    }

    /**
     * @return The height of the popup window in pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.473 -0400", hash_original_method = "2B0617362C23A2A1F29E0E83641579F9", hash_generated_method = "D37B95D83D167F9C4FBCCC7EF8DB8E0F")
    
public int getHeight() {
        return mDropDownHeight;
    }

    /**
     * Sets the height of the popup window in pixels. Can also be {@link #FILL_PARENT}.
     *
     * @param height Height of the popup window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.475 -0400", hash_original_method = "CAA84DCA25312E828BE740B15493FB25", hash_generated_method = "1307ECD2360B8192F17D2690E76D1BD3")
    
public void setHeight(int height) {
        mDropDownHeight = height;
    }

    /**
     * Sets a listener to receive events when a list item is clicked.
     *
     * @param clickListener Listener to register
     * @see ListView#setOnItemClickListener(android.widget.AdapterView.OnItemClickListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.478 -0400", hash_original_method = "500645EE5CDA87E171AAE4D175AC763E", hash_generated_method = "4F93B27CDA566E1947C562DDACAB23C1")
    
public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        mItemClickListener = clickListener;
    }

    /**
     * Sets a listener to receive events when a list item is selected.
     *
     * @param selectedListener Listener to register.
     * @see ListView#setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.480 -0400", hash_original_method = "77C1F384A6316C978289202E5719DEEE", hash_generated_method = "080AB42266AF6BB9870333E8AD2B5DFF")
    
public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener selectedListener) {
        mItemSelectedListener = selectedListener;
    }

    /**
     * Set a view to act as a user prompt for this popup window. Where the prompt view will appear
     * is controlled by {@link #setPromptPosition(int)}.
     *
     * @param prompt View to use as an informational prompt.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.482 -0400", hash_original_method = "F870D6C36930B52993EA962C5CEE4741", hash_generated_method = "9316FBCE25514633177B4C3FB50BD709")
    
public void setPromptView(View prompt) {
        boolean showing = isShowing();
        if (showing) {
            removePromptView();
        }
        mPromptView = prompt;
        if (showing) {
            show();
        }
    }

    /**
     * Post a {@link #show()} call to the UI thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.484 -0400", hash_original_method = "6F8BB8AB5CFBCAF655CCF7F8C4D42CCD", hash_generated_method = "348EE165671531E3C9C5D9CD3C8DCFB4")
    
public void postShow() {
        mHandler.post(mShowDropDownRunnable);
    }

    /**
     * Show the popup list. If the list is already showing, this method will recalculate the popup's
     * size and position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.488 -0400", hash_original_method = "D10CE17DC95AE21D783C9B3DBD60C86E", hash_generated_method = "D06AD8CA4EA9EB4EE4F0785C8756E630")
    
public void show() {
        int height = buildDropDown();

        int widthSpec = 0;
        int heightSpec = 0;

        boolean noInputMethod = isInputMethodNotNeeded();

        if (mPopup.isShowing()) {
            if (mDropDownWidth == ViewGroup.LayoutParams.FILL_PARENT) {
                // The call to PopupWindow's update method below can accept -1 for any
                // value you do not want to update.
                widthSpec = -1;
            } else if (mDropDownWidth == ViewGroup.LayoutParams.WRAP_CONTENT) {
                widthSpec = getAnchorView().getWidth();
            } else {
                widthSpec = mDropDownWidth;
            }

            if (mDropDownHeight == ViewGroup.LayoutParams.FILL_PARENT) {
                // The call to PopupWindow's update method below can accept -1 for any
                // value you do not want to update.
                heightSpec = noInputMethod ? height : ViewGroup.LayoutParams.FILL_PARENT;
                if (noInputMethod) {
                    mPopup.setWindowLayoutMode(
                            mDropDownWidth == ViewGroup.LayoutParams.FILL_PARENT ?
                                    ViewGroup.LayoutParams.FILL_PARENT : 0, 0);
                } else {
                    mPopup.setWindowLayoutMode(
                            mDropDownWidth == ViewGroup.LayoutParams.FILL_PARENT ?
                                    ViewGroup.LayoutParams.FILL_PARENT : 0,
                            ViewGroup.LayoutParams.FILL_PARENT);
                }
            } else if (mDropDownHeight == ViewGroup.LayoutParams.WRAP_CONTENT) {
                heightSpec = height;
            } else {
                heightSpec = mDropDownHeight;
            }

            mPopup.setOutsideTouchable(!mForceIgnoreOutsideTouch && !mDropDownAlwaysVisible);

            mPopup.update(getAnchorView(), mDropDownHorizontalOffset,
                    mDropDownVerticalOffset, widthSpec, heightSpec);
        } else {
            if (mDropDownWidth == ViewGroup.LayoutParams.FILL_PARENT) {
                widthSpec = ViewGroup.LayoutParams.FILL_PARENT;
            } else {
                if (mDropDownWidth == ViewGroup.LayoutParams.WRAP_CONTENT) {
                    mPopup.setWidth(getAnchorView().getWidth());
                } else {
                    mPopup.setWidth(mDropDownWidth);
                }
            }

            if (mDropDownHeight == ViewGroup.LayoutParams.FILL_PARENT) {
                heightSpec = ViewGroup.LayoutParams.FILL_PARENT;
            } else {
                if (mDropDownHeight == ViewGroup.LayoutParams.WRAP_CONTENT) {
                    mPopup.setHeight(height);
                } else {
                    mPopup.setHeight(mDropDownHeight);
                }
            }

            mPopup.setWindowLayoutMode(widthSpec, heightSpec);

            // use outside touchable to dismiss drop down when touching outside of it, so
            // only set this if the dropdown is not always visible
            mPopup.setOutsideTouchable(!mForceIgnoreOutsideTouch && !mDropDownAlwaysVisible);
            mPopup.setTouchInterceptor(mTouchInterceptor);
            mPopup.showAsDropDown(getAnchorView(),
                    mDropDownHorizontalOffset, mDropDownVerticalOffset);
            mDropDownList.setSelection(ListView.INVALID_POSITION);

            if (!mModal || mDropDownList.isInTouchMode()) {
                clearListSelection();
            }
            if (!mModal) {
                mHandler.post(mHideSelector);
            }
        }
    }

    /**
     * Dismiss the popup window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.490 -0400", hash_original_method = "B4B1B4676A26C0E0D07AD81974E2090B", hash_generated_method = "50D7A428D0408225B9A85847B875AC8B")
    
public void dismiss() {
        mPopup.dismiss();
        removePromptView();
        mPopup.setContentView(null);
        mDropDownList = null;
        mHandler.removeCallbacks(mResizePopupRunnable);
    }

    /**
     * Set a listener to receive a callback when the popup is dismissed.
     *
     * @param listener Listener that will be notified when the popup is dismissed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.492 -0400", hash_original_method = "C7BE29500BF4339E2FDC892E2A139524", hash_generated_method = "5C97EF6AB530266F013AE5B9157C4053")
    
public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        mPopup.setOnDismissListener(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.495 -0400", hash_original_method = "202D4492803683737094012DDF6DD86F", hash_generated_method = "3AA7D4B2D9BCE578A6C1E3296F0D706C")
    
private void removePromptView() {
        if (mPromptView != null) {
            final ViewParent parent = mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                final ViewGroup group = (ViewGroup) parent;
                group.removeView(mPromptView);
            }
        }
    }

    /**
     * Control how the popup operates with an input method: one of {@link
     * #INPUT_METHOD_FROM_FOCUSABLE}, {@link #INPUT_METHOD_NEEDED}, or {@link
     * #INPUT_METHOD_NOT_NEEDED}.
     *
     * <p>If the popup is showing, calling this method will take effect only the next time the popup
     * is shown or through a manual call to the {@link #show()} method.</p>
     *
     * @see #getInputMethodMode()
     * @see #show()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.497 -0400", hash_original_method = "288B7DB6446AD4FA82AB3ACE9506A35B", hash_generated_method = "664404492444FE4EDB8C9EF235897445")
    
public void setInputMethodMode(int mode) {
        mPopup.setInputMethodMode(mode);
    }

    /**
     * Return the current value in {@link #setInputMethodMode(int)}.
     *
     * @see #setInputMethodMode(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.499 -0400", hash_original_method = "341CBB053B214C5E0FB1B54637325DA3", hash_generated_method = "E24A5236B5374EA3523D770364798036")
    
public int getInputMethodMode() {
        return mPopup.getInputMethodMode();
    }

    /**
     * Set the selected position of the list. Only valid when {@link #isShowing()} == {@code true}.
     *
     * @param position List position to set as selected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.501 -0400", hash_original_method = "119CA9359C56E2DDD442B9A05EFE812C", hash_generated_method = "3B3BC52D181D5841E7CE1A55B23BB93A")
    
public void setSelection(int position) {
        DropDownListView list = mDropDownList;
        if (isShowing() && list != null) {
            list.mListSelectionHidden = false;
            list.setSelection(position);
            if (list.getChoiceMode() != ListView.CHOICE_MODE_NONE) {
                list.setItemChecked(position, true);
            }
        }
    }

    /**
     * Clear any current list selection. Only valid when {@link #isShowing()} == {@code true}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.504 -0400", hash_original_method = "9FE5053F258DDD587667D4A39E171317", hash_generated_method = "76BEFD456FBFF24DEC5EC451C7927F62")
    
public void clearListSelection() {
        final DropDownListView list = mDropDownList;
        if (list != null) {
            // WARNING: Please read the comment where mListSelectionHidden is declared
            list.mListSelectionHidden = true;
            //list.hideSelector();
            list.requestLayout();
        }
    }

    /**
     * @return {@code true} if the popup is currently showing, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.506 -0400", hash_original_method = "CA9C4C0CD645F38E1AAA797FE00ECFCE", hash_generated_method = "A74A360685D68080E9B081E8BB4886F7")
    
public boolean isShowing() {
        return mPopup.isShowing();
    }

    /**
     * @return {@code true} if this popup is configured to assume the user does not need to interact
     *         with the IME while it is showing, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.507 -0400", hash_original_method = "C5EEC00F4CE1C916DAF561B7CF397229", hash_generated_method = "304924423F1B5B5A901202A22B2D39F6")
    
public boolean isInputMethodNotNeeded() {
        return mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED;
    }

    /**
     * Perform an item click operation on the specified list adapter position.
     *
     * @param position Adapter position for performing the click
     * @return true if the click action could be performed, false if not. (e.g. if the popup was not
     *         showing, this method would return false.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.510 -0400", hash_original_method = "5D56F9149CAA09C31AB36A31C90B128D", hash_generated_method = "AE20ADFEF2EF4BCDBDC5219F11D53EF7")
    
public boolean performItemClick(int position) {
        if (isShowing()) {
            if (mItemClickListener != null) {
                final DropDownListView list = mDropDownList;
                final View child = list.getChildAt(position - list.getFirstVisiblePosition());
                final ListAdapter adapter = list.getAdapter();
                mItemClickListener.onItemClick(list, child, position, adapter.getItemId(position));
            }
            return true;
        }
        return false;
    }

    /**
     * @return The currently selected item or null if the popup is not showing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.512 -0400", hash_original_method = "E481FD4B78A135BB1B6DC4E83167B196", hash_generated_method = "6A17B03FB9691569A1AE097B83BBAA4F")
    
public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return mDropDownList.getSelectedItem();
    }

    /**
     * @return The position of the currently selected item or {@link ListView#INVALID_POSITION} if
     *         {@link #isShowing()} == {@code false}.
     * @see ListView#getSelectedItemPosition()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.515 -0400", hash_original_method = "055DCA84E8C7B3F34F7D7819C2CD5AC3", hash_generated_method = "8A3175CA69A3FA68DA6E161E8C3CEDF4")
    
public int getSelectedItemPosition() {
        if (!isShowing()) {
            return ListView.INVALID_POSITION;
        }
        return mDropDownList.getSelectedItemPosition();
    }

    /**
     * @return The ID of the currently selected item or {@link ListView#INVALID_ROW_ID} if {@link
     *         #isShowing()} == {@code false}.
     * @see ListView#getSelectedItemId()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.518 -0400", hash_original_method = "4492784EC84C61BD8D41E43112FEBCD0", hash_generated_method = "D3EEC71A6116CC51874E3E01EAFBD952")
    
public long getSelectedItemId() {
        if (!isShowing()) {
            return ListView.INVALID_ROW_ID;
        }
        return mDropDownList.getSelectedItemId();
    }

    /**
     * @return The View for the currently selected item or null if {@link #isShowing()} == {@code
     *         false}.
     * @see ListView#getSelectedView()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.520 -0400", hash_original_method = "A94FEEC1ECDAC3555C21CB10FFC68C47", hash_generated_method = "892A145AB2B636C1047E11E5595197C0")
    
public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return mDropDownList.getSelectedView();
    }

    /**
     * @return The {@link ListView} displayed within the popup window. Only valid when {@link
     *         #isShowing()} == {@code true}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.522 -0400", hash_original_method = "D21142DAF85C899FDAA3783E4BBEC12E", hash_generated_method = "7312C25846E6B9BBA3DB1F353BAB6BF7")
    
public ListView getListView() {
        return mDropDownList;
    }

    /**
     * The maximum number of list items that can be visible and still have the list expand when
     * touched.
     *
     * @param max Max number of items that can be visible and still allow the list to expand.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.524 -0400", hash_original_method = "21262ED785FC4787FB1F1DE7107BCA92", hash_generated_method = "21262ED785FC4787FB1F1DE7107BCA92")
    
void setListItemExpandMax(int max) {
        mListItemExpandMaximum = max;
    }

    /**
     * Filter key down events. By forwarding key down events to this function, views using non-modal
     * ListPopupWindow can have it handle key selection of items.
     *
     * @param keyCode keyCode param passed to the host view's onKeyDown
     * @param event   event param passed to the host view's onKeyDown
     * @return true if the event was handled, false if it was ignored.
     * @see #setModal(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.527 -0400", hash_original_method = "1BEE6F21F5202DCAF235DC49F611210B", hash_generated_method = "705AE10C98EF6BF2A08565DC97D4AC47")
    
public boolean onKeyDown(int keyCode, KeyEvent event) {
        // when the drop down is shown, we drive it directly
        if (isShowing()) {
            // the key events are forwarded to the list in the drop down view
            // note that ListView handles space but we don't want that to happen
            // also if selection is not currently in the drop down, then don't
            // let center or enter presses go there since that would cause it
            // to select one of its items
            if (keyCode != KeyEvent.KEYCODE_SPACE
                    && (mDropDownList.getSelectedItemPosition() >= 0
                    || (keyCode != KeyEvent.KEYCODE_ENTER
                    && keyCode != KeyEvent.KEYCODE_DPAD_CENTER))) {
                int curIndex = mDropDownList.getSelectedItemPosition();
                boolean consumed;

                final boolean below = !mPopup.isAboveAnchor();

                final ListAdapter adapter = mAdapter;

                boolean allEnabled;
                int firstItem = Integer.MAX_VALUE;
                int lastItem = Integer.MIN_VALUE;

                if (adapter != null) {
                    allEnabled = adapter.areAllItemsEnabled();
                    firstItem = allEnabled ? 0 :
                            mDropDownList.lookForSelectablePosition(0, true);
                    lastItem = allEnabled ? adapter.getCount() - 1 :
                            mDropDownList.lookForSelectablePosition(adapter.getCount() - 1, false);
                }

                if ((below && keyCode == KeyEvent.KEYCODE_DPAD_UP && curIndex <= firstItem) ||
                        (!below && keyCode == KeyEvent.KEYCODE_DPAD_DOWN && curIndex >= lastItem)) {
                    // When the selection is at the top, we block the key
                    // event to prevent focus from moving.
                    clearListSelection();
                    mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
                    show();
                    return true;
                } else {
                    // WARNING: Please read the comment where mListSelectionHidden
                    //          is declared
                    mDropDownList.mListSelectionHidden = false;
                }

                consumed = mDropDownList.onKeyDown(keyCode, event);
                if (DEBUG) {
                    Log.v(TAG, "Key down: code=" + keyCode + " list consumed=" + consumed);
                }

                if (consumed) {
                    // If it handled the key event, then the user is
                    // navigating in the list, so we should put it in front.
                    mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                    // Here's a little trick we need to do to make sure that
                    // the list view is actually showing its focus indicator,
                    // by ensuring it has focus and getting its window out
                    // of touch mode.
                    mDropDownList.requestFocusFromTouch();
                    show();

                    switch (keyCode) {
                        // avoid passing the focus from the text view to the
                        // next component
                        case KeyEvent.KEYCODE_ENTER:
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_DPAD_DOWN:
                        case KeyEvent.KEYCODE_DPAD_UP:
                            return true;
                    }
                } else {
                    if (below && keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
                        // when the selection is at the bottom, we block the
                        // event to avoid going to the next focusable widget
                        if (curIndex == lastItem) {
                            return true;
                        }
                    } else if (!below && keyCode == KeyEvent.KEYCODE_DPAD_UP &&
                            curIndex == firstItem) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Filter key down events. By forwarding key up events to this function, views using non-modal
     * ListPopupWindow can have it handle key selection of items.
     *
     * @param keyCode keyCode param passed to the host view's onKeyUp
     * @param event   event param passed to the host view's onKeyUp
     * @return true if the event was handled, false if it was ignored.
     * @see #setModal(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.530 -0400", hash_original_method = "CD01E8977B386E95EB43DA8A15EDF875", hash_generated_method = "38CE1FE25476BBCB139B3C9A4E2BE658")
    
public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (isShowing() && mDropDownList.getSelectedItemPosition() >= 0) {
            boolean consumed = mDropDownList.onKeyUp(keyCode, event);
            if (consumed) {
                switch (keyCode) {
                    // if the list accepts the key events and the key event
                    // was a click, the text view gets the selected item
                    // from the drop down as its content
                    case KeyEvent.KEYCODE_ENTER:
                    case KeyEvent.KEYCODE_DPAD_CENTER:
                        dismiss();
                        break;
                }
            }
            return consumed;
        }
        return false;
    }

    /**
     * <p>Builds the popup window's content and returns the height the popup should have. Returns -1
     * when the content already exists.</p>
     *
     * @return the content's height or -1 if content already exists
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.547 -0400", hash_original_method = "1B4455855C167883C1E8F6D78183240B", hash_generated_method = "E549967C6F52D04E95AC8746E202A053")
    
private int buildDropDown() {
        ViewGroup dropDownView;
        int otherHeights = 0;

        if (mDropDownList == null) {
            Context context = mContext;

            /**
             * This Runnable exists for the sole purpose of checking if the view layout has got
             * completed and if so call showDropDown to display the drop down. This is used to show
             * the drop down as soon as possible after user opens up the search dialog, without
             * waiting for the normal UI pipeline to do it's job which is slower than this method.
             */
            mShowDropDownRunnable = new Runnable() {
                public void run() {
                    // View layout should be all done before displaying the drop down.
                    View view = getAnchorView();
                    if (view != null && view.getWindowToken() != null) {
                        show();
                    }
                }
            };

            mDropDownList = new DropDownListView(context, !mModal);
            if (mDropDownListHighlight != null) {
                mDropDownList.setSelector(mDropDownListHighlight);
            }
            mDropDownList.setAdapter(mAdapter);
            mDropDownList.setOnItemClickListener(mItemClickListener);
            mDropDownList.setFocusable(true);
            mDropDownList.setFocusableInTouchMode(true);
            mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {

                    if (position != -1) {
                        DropDownListView dropDownList = mDropDownList;

                        if (dropDownList != null) {
                            dropDownList.mListSelectionHidden = false;
                        }
                    }
                }

                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
            mDropDownList.setOnScrollListener(mScrollListener);

            if (mItemSelectedListener != null) {
                mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
            }

            dropDownView = mDropDownList;

            View hintView = mPromptView;
            if (hintView != null) {
                // if a hint has been specified, we accomodate more space for it and
                // add a text view in the drop down menu, at the bottom of the list
                LinearLayout hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(LinearLayout.VERTICAL);

                LinearLayout.LayoutParams hintParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, 0, 1.0f
                );

                switch (mPromptPosition) {
                    case POSITION_PROMPT_BELOW:
                        hintContainer.addView(dropDownView, hintParams);
                        hintContainer.addView(hintView);
                        break;

                    case POSITION_PROMPT_ABOVE:
                        hintContainer.addView(hintView);
                        hintContainer.addView(dropDownView, hintParams);
                        break;

                    default:
                        Log.e(TAG, "Invalid hint position " + mPromptPosition);
                        break;
                }

                // measure the hint's height to find how much more vertical space
                // we need to add to the drop down's height
                int widthSpec = MeasureSpec.makeMeasureSpec(mDropDownWidth, MeasureSpec.AT_MOST);
                int heightSpec = MeasureSpec.UNSPECIFIED;
                hintView.measure(widthSpec, heightSpec);

                hintParams = (LinearLayout.LayoutParams) hintView.getLayoutParams();
                otherHeights = hintView.getMeasuredHeight() + hintParams.topMargin
                        + hintParams.bottomMargin;

                dropDownView = hintContainer;
            }

            mPopup.setContentView(dropDownView);
        } else {
            dropDownView = (ViewGroup) mPopup.getContentView();
            final View view = mPromptView;
            if (view != null) {
                LinearLayout.LayoutParams hintParams =
                        (LinearLayout.LayoutParams) view.getLayoutParams();
                otherHeights = view.getMeasuredHeight() + hintParams.topMargin
                        + hintParams.bottomMargin;
            }
        }

        // getMaxAvailableHeight() subtracts the padding, so we put it back
        // to get the available height for the whole window
        int padding = 0;
        Drawable background = mPopup.getBackground();
        if (background != null) {
            background.getPadding(mTempRect);
            padding = mTempRect.top + mTempRect.bottom;

            // If we don't have an explicit vertical offset, determine one from the window
            // background so that content will line up.
            if (!mDropDownVerticalOffsetSet) {
                mDropDownVerticalOffset = -mTempRect.top;
            }
        } else {
            mTempRect.setEmpty();
        }

        // Max height available on the screen for a popup.
        boolean ignoreBottomDecorations =
                mPopup.getInputMethodMode() == PopupWindow.INPUT_METHOD_NOT_NEEDED;
        final int maxHeight = getMaxAvailableHeight(
                getAnchorView(), mDropDownVerticalOffset, ignoreBottomDecorations);

        if (mDropDownAlwaysVisible || mDropDownHeight == ViewGroup.LayoutParams.FILL_PARENT) {
            return maxHeight + padding;
        }

        final int childWidthSpec;
        switch (mDropDownWidth) {
            case ViewGroup.LayoutParams.WRAP_CONTENT:
                childWidthSpec = MeasureSpec.makeMeasureSpec(
                        mContext.getResources().getDisplayMetrics().widthPixels -
                                (mTempRect.left + mTempRect.right),
                        MeasureSpec.AT_MOST);
                break;
            case ViewGroup.LayoutParams.FILL_PARENT:
                childWidthSpec = MeasureSpec.makeMeasureSpec(
                        mContext.getResources().getDisplayMetrics().widthPixels -
                                (mTempRect.left + mTempRect.right),
                        MeasureSpec.EXACTLY);
                break;
            default:
                childWidthSpec = MeasureSpec.makeMeasureSpec(mDropDownWidth, MeasureSpec.EXACTLY);
                break;
        }

        final int listContent = mDropDownList.measureHeightOfChildrenCompat(childWidthSpec,
                0, DropDownListView.NO_POSITION, maxHeight - otherHeights, -1);
        // add padding only if the list has items in it, that way we don't show
        // the popup if it is not needed
        if (listContent > 0) {
            otherHeights += padding;
        }

        return listContent + otherHeights;
    }

    /**
     * Copied from PopupWindow.java of JB
     *
     * Returns the maximum height that is available for the popup to be completely shown, optionally
     * ignoring any bottom decorations such as the input method. It is recommended that this height
     * be the maximum for the popup's height, otherwise it is possible that the popup will be
     * clipped.
     *
     * @param anchor                  The view on which the popup window must be anchored.
     * @param yOffset                 y offset from the view's bottom edge
     * @param ignoreBottomDecorations if true, the height returned will be all the way to the bottom
     *                                of the display, ignoring any bottom decorations
     * @return The maximum available height for the popup to be completely shown.
     * @hide Pending API council approval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.551 -0400", hash_original_method = "30B117DC125F3A321207CE7AF03D46F5", hash_generated_method = "1422ECB4C929E7ADD9DD972A6A8F7F88")
    
public int getMaxAvailableHeight(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        final Rect displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);

        int[] mDrawingLocation = new int[2];
        final int[] anchorPos = mDrawingLocation;
        anchor.getLocationOnScreen(anchorPos);

        int bottomEdge = displayFrame.bottom;
        if (ignoreBottomDecorations) {
            Resources res = anchor.getContext().getResources();
            bottomEdge = res.getDisplayMetrics().heightPixels;
        }
        final int distanceToBottom = bottomEdge - (anchorPos[1] + anchor.getHeight()) - yOffset;
        final int distanceToTop = anchorPos[1] - displayFrame.top + yOffset;

        // anchorPos[1] is distance from anchor to top of screen
        int returnedHeight = Math.max(distanceToBottom, distanceToTop);
        if (mPopup.getBackground() != null) {
            mPopup.getBackground().getPadding(mTempRect);
            returnedHeight -= mTempRect.top + mTempRect.bottom;
        }

        return returnedHeight;
    }

    /**
     * <p>Wrapper class for a ListView. This wrapper can hijack the focus to make sure the list uses
     * the appropriate drawables and states when displayed on screen within a drop down. The focus
     * is never actually passed to the drop down in this mode; the list only looks focused.</p>
     */
    private static class DropDownListView extends ListView {

        private static final String TAG = ListPopupWindow.TAG + ".DropDownListView";

        /*
        * WARNING: This is a workaround for a touch mode issue.
        *
        * Touch mode is propagated lazily to windows. This causes problems in
        * the following scenario:
        * - Type something in the AutoCompleteTextView and get some results
        * - Move down with the d-pad to select an item in the list
        * - Move up with the d-pad until the selection disappears
        * - Type more text in the AutoCompleteTextView *using the soft keyboard*
        *   and get new results; you are now in touch mode
        * - The selection comes back on the first item in the list, even though
        *   the list is supposed to be in touch mode
        *
        * Using the soft keyboard triggers the touch mode change but that change
        * is propagated to our window only after the first list layout, therefore
        * after the list attempts to resurrect the selection.
        *
        * The trick to work around this issue is to pretend the list is in touch
        * mode when we know that the selection should not appear, that is when
        * we know the user moved the selection away from the list.
        *
        * This boolean is set to true whenever we explicitly hide the list's
        * selection and reset to false whenever we know the user moved the
        * selection back to the list.
        *
        * When this boolean is true, isInTouchMode() returns true, otherwise it
        * returns super.isInTouchMode().
        */
        private boolean mListSelectionHidden;


        public static final int INVALID_POSITION = -1;

        static final int NO_POSITION = -1;


        /**
         * True if this wrapper should fake focus.
         */
        private boolean mHijackFocus;

        /**
         * <p>Creates a new list view wrapper.</p>
         *
         * @param context this view's context
         */
        public DropDownListView(Context context, boolean hijackFocus) {
            super(context, null, R.attr.dropDownListViewStyle);
            mHijackFocus = hijackFocus;
            setCacheColorHint(0); // Transparent, since the background drawable could be anything.
        }

        /**
         * Find a position that can be selected (i.e., is not a separator).
         *
         * @param position The starting position to look at.
         * @param lookDown Whether to look down for other positions.
         * @return The next selectable position starting at position and then searching either up or
         *         down. Returns {@link #INVALID_POSITION} if nothing can be found.
         */
        private int lookForSelectablePosition(int position, boolean lookDown) {
            final ListAdapter adapter = getAdapter();
            if (adapter == null || isInTouchMode()) {
                return INVALID_POSITION;
            }

            final int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (lookDown) {
                    position = Math.max(0, position);
                    while (position < count && !adapter.isEnabled(position)) {
                        position++;
                    }
                } else {
                    position = Math.min(position, count - 1);
                    while (position >= 0 && !adapter.isEnabled(position)) {
                        position--;
                    }
                }

                if (position < 0 || position >= count) {
                    return INVALID_POSITION;
                }
                return position;
            } else {
                if (position < 0 || position >= count) {
                    return INVALID_POSITION;
                }
                return position;
            }
        }

        @Override
        public boolean isInTouchMode() {
            // WARNING: Please read the comment where mListSelectionHidden is declared
            return (mHijackFocus && mListSelectionHidden) || super.isInTouchMode();
        }

        /**
         * <p>Returns the focus state in the drop down.</p>
         *
         * @return true always if hijacking focus
         */
        @Override
        public boolean hasWindowFocus() {
            return mHijackFocus || super.hasWindowFocus();
        }

        /**
         * <p>Returns the focus state in the drop down.</p>
         *
         * @return true always if hijacking focus
         */
        @Override
        public boolean isFocused() {
            return mHijackFocus || super.isFocused();
        }

        /**
         * <p>Returns the focus state in the drop down.</p>
         *
         * @return true always if hijacking focus
         */
        @Override
        public boolean hasFocus() {
            return mHijackFocus || super.hasFocus();
        }

        /**
         * Measures the height of the given range of children (inclusive) and returns the height
         * with this ListView's padding and divider heights included. If maxHeight is provided, the
         * measuring will stop when the current height reaches maxHeight.
         *
         * @param widthMeasureSpec             The width measure spec to be given to a child's
         *                                     {@link View#measure(int, int)}.
         * @param startPosition                The position of the first child to be shown.
         * @param endPosition                  The (inclusive) position of the last child to be
         *                                     shown. Specify {@link #NO_POSITION} if the last child
         *                                     should be the last available child from the adapter.
         * @param maxHeight                    The maximum height that will be returned (if all the
         *                                     children don't fit in this value, this value will be
         *                                     returned).
         * @param disallowPartialChildPosition In general, whether the returned height should only
         *                                     contain entire children. This is more powerful--it is
         *                                     the first inclusive position at which partial
         *                                     children will not be allowed. Example: it looks nice
         *                                     to have at least 3 completely visible children, and
         *                                     in portrait this will most likely fit; but in
         *                                     landscape there could be times when even 2 children
         *                                     can not be completely shown, so a value of 2
         *                                     (remember, inclusive) would be good (assuming
         *                                     startPosition is 0).
         * @return The height of this ListView with the given children.
         */
        final int measureHeightOfChildrenCompat(int widthMeasureSpec, int startPosition,
                int endPosition, final int maxHeight,
                int disallowPartialChildPosition) {

            final int paddingTop = getListPaddingTop();
            final int paddingBottom = getListPaddingBottom();
            final int paddingLeft = getListPaddingLeft();
            final int paddingRight = getListPaddingRight();
            final int reportedDividerHeight = getDividerHeight();
            final Drawable divider = getDivider();

            final ListAdapter adapter = getAdapter();

            if (adapter == null) {
                return paddingTop + paddingBottom;
            }

            // Include the padding of the list
            int returnedHeight = paddingTop + paddingBottom;
            final int dividerHeight = ((reportedDividerHeight > 0) && divider != null)
                    ? reportedDividerHeight : 0;

            // The previous height value that was less than maxHeight and contained
            // no partial children
            int prevHeightWithoutPartialChild = 0;

            View child = null;
            int viewType = 0;
            int count = adapter.getCount();
            for (int i = 0; i < count; i++) {
                int newType = adapter.getItemViewType(i);
                if (newType != viewType) {
                    child = null;
                    viewType = newType;
                }
                child = adapter.getView(i, child, this);
                ;

                // Compute child height spec
                int heightMeasureSpec;
                int childHeight = child.getLayoutParams().height;
                if (childHeight > 0) {
                    heightMeasureSpec = MeasureSpec
                            .makeMeasureSpec(childHeight, MeasureSpec.EXACTLY);
                } else {
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                }
                child.measure(widthMeasureSpec, heightMeasureSpec);

                if (i > 0) {
                    // Count the divider for all but one child
                    returnedHeight += dividerHeight;
                }

                returnedHeight += child.getMeasuredHeight();

                if (returnedHeight >= maxHeight) {
                    // We went over, figure out which height to return.  If returnedHeight >
                    // maxHeight, then the i'th position did not fit completely.
                    return (disallowPartialChildPosition >= 0) // Disallowing is enabled (> -1)
                            && (i > disallowPartialChildPosition) // We've past the min pos
                            && (prevHeightWithoutPartialChild > 0) // We have a prev height
                            && (returnedHeight != maxHeight) // i'th child did not fit completely
                            ? prevHeightWithoutPartialChild
                            : maxHeight;
                }

                if ((disallowPartialChildPosition >= 0) && (i >= disallowPartialChildPosition)) {
                    prevHeightWithoutPartialChild = returnedHeight;
                }
            }

            // At this point, we went through the range of children, and they each
            // completely fit, so return the returnedHeight
            return returnedHeight;
        }

    }

    private class PopupDataSetObserver extends DataSetObserver {

        @Override
        public void onChanged() {
            if (isShowing()) {
                // Resize the popup to fit new content
                show();
            }
        }

        @Override
        public void onInvalidated() {
            dismiss();
        }
    }

    private class ListSelectorHider implements Runnable {

        public void run() {
            clearListSelection();
        }
    }

    private class ResizePopupRunnable implements Runnable {

        public void run() {
            if (mDropDownList != null && mDropDownList.getCount() > mDropDownList.getChildCount() &&
                    mDropDownList.getChildCount() <= mListItemExpandMaximum) {
                mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                show();
            }
        }
    }

    private class PopupTouchInterceptor implements OnTouchListener {

        public boolean onTouch(View v, MotionEvent event) {
            final int action = event.getAction();
            final int x = (int) event.getX();
            final int y = (int) event.getY();

            if (action == MotionEvent.ACTION_DOWN &&
                    mPopup != null && mPopup.isShowing() &&
                    (x >= 0 && x < mPopup.getWidth() && y >= 0 && y < mPopup.getHeight())) {
                mHandler.postDelayed(mResizePopupRunnable, EXPAND_LIST_TIMEOUT);
            } else if (action == MotionEvent.ACTION_UP) {
                mHandler.removeCallbacks(mResizePopupRunnable);
            }
            return false;
        }
    }

    private class PopupScrollListener implements ListView.OnScrollListener {

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                int totalItemCount) {

        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == SCROLL_STATE_TOUCH_SCROLL &&
                    !isInputMethodNotNeeded() && mPopup.getContentView() != null) {
                mHandler.removeCallbacks(mResizePopupRunnable);
                mResizePopupRunnable.run();
            }
        }
    }
}