/*
 * Copyright (C) 2013 The Android Open Source Project
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
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * This class is a view for choosing an activity for handling a given {@link Intent}.
 * <p>
 * The view is composed of two adjacent buttons:
 * <ul>
 * <li>
 * The left button is an immediate action and allows one click activity choosing.
 * Tapping this button immediately executes the intent without requiring any further
 * user input. Long press on this button shows a popup for changing the default
 * activity.
 * </li>
 * <li>
 * The right button is an overflow action and provides an optimized menu
 * of additional activities. Tapping this button shows a popup anchored to this
 * view, listing the most frequently used activities. This list is initially
 * limited to a small number of items in frequency used order. The last item,
 * "Show all..." serves as an affordance to display all available activities.
 * </li>
 * </ul>
 * </p>
 *
 * @hide
 */
public class ActivityChooserView extends ViewGroup implements
        ActivityChooserModel.ActivityChooserModelClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:37.893 -0400", hash_original_field = "3F351B3FFE95814B5FCDF7093922C09C", hash_generated_field = "693752B4212B867133E03234F672DAB4")

    private  ActivityChooserViewAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:37.903 -0400", hash_original_field = "5F7F864DF881DE2C32D18CBBF247398B", hash_generated_field = "56C5A3BFBAA3C4CF09CF9C52EF52DD5C")

    private  Callbacks mCallbacks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:37.910 -0400", hash_original_field = "F4B1FE41D7FEEA54B1C2F06D9CA84B89", hash_generated_field = "15A85E7B2533D5C1858324D4690F18CE")

    private  LinearLayout mActivityChooserContent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:37.918 -0400", hash_original_field = "1D6AD35FC2C33762935586ED0B8C5754", hash_generated_field = "2CCC7C8CA771AD7217D2AFD6C98780B1")

    private  Drawable mActivityChooserContentBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:37.925 -0400", hash_original_field = "E4BA8FBEB535AFC704E8B17A0F664D29", hash_generated_field = "3CE55FDBD0D926D55E38007406C4DF14")

    private  FrameLayout mExpandActivityOverflowButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:37.945 -0400", hash_original_field = "384E3CAAB14F9963DF9008EEAF1C073A", hash_generated_field = "433B613895F9A9778E53C598D01BA2AB")

    private  ImageView mExpandActivityOverflowButtonImage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:37.952 -0400", hash_original_field = "9B62C3262343F53DB60F87EFB9948CFE", hash_generated_field = "2804585A9E453E27976F3FDF1A270905")

    private  FrameLayout mDefaultActivityButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:37.959 -0400", hash_original_field = "059EDE42A29D1D3E6C101016D537F42D", hash_generated_field = "A19ECBBBF75A40B339DC4A95C030E78B")

    private  ImageView mDefaultActivityButtonImage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:37.966 -0400", hash_original_field = "5B538EC0DE554B078568B7505C7993AE", hash_generated_field = "6549412A83E8736AC71A3C4F42B2776F")

    private  int mListPopupMaxWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:37.973 -0400", hash_original_field = "94389E96F8958E34938A4C66FB6778B1", hash_generated_field = "94389E96F8958E34938A4C66FB6778B1")

    ActionProvider mProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.005 -0400", hash_original_field = "09755A9BFD6333D414AB56EB1E508D8B", hash_generated_field = "B8A39ACD3E69298CE4A5E870F69B2D54")

    private final DataSetObserver mModelDataSetOberver = new DataSetObserver() {

        @Override
        public void onChanged() {
            super.onChanged();
            mAdapter.notifyDataSetChanged();
        }
        @Override
        public void onInvalidated() {
            super.onInvalidated();
            mAdapter.notifyDataSetInvalidated();
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.026 -0400", hash_original_field = "D6FE6EA2CF5DEBD2D9A3C74AECA0D735", hash_generated_field = "9E7F8DDC611EBE09DFB04DB1A5EFB590")


    private final OnGlobalLayoutListener mOnGlobalLayoutListener = new OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            if (isShowingPopup()) {
                if (!isShown()) {
                    getListPopupWindow().dismiss();
                } else {
                    getListPopupWindow().show();
                    if (mProvider != null) {
                        mProvider.subUiVisibilityChanged(true);
                    }
                }
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.033 -0400", hash_original_field = "BB013E7DF74239BB99B193DBA10B6B74", hash_generated_field = "B18FE4D2C1F5F5724780B69F0C631713")

    private ListPopupWindow mListPopupWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.040 -0400", hash_original_field = "A814A01FB60554553F2F3B14C367F7B8", hash_generated_field = "5A4179E23C1E43233D6280AC184F1638")

    private PopupWindow.OnDismissListener mOnDismissListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.046 -0400", hash_original_field = "2ED08702AFE65988152D8183044C6A80", hash_generated_field = "FB5A63E1FFE964D7D3DF45A85F8B7265")

    private boolean mIsSelectingDefaultActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.055 -0400", hash_original_field = "EBECD9BBECE734BE93A6CE80ACC853B4", hash_generated_field = "04519B5943EE67A9C7EEE82652B59883")

    private int mInitialActivityCount = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.061 -0400", hash_original_field = "3395A79183756ED462089216FAF67ED2", hash_generated_field = "A725E70F25078818B1BC03DF5AE609A6")

    private boolean mIsAttachedToWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.067 -0400", hash_original_field = "48C1C82D82D12C44A39558AE8E8B16EC", hash_generated_field = "2EB4D3D3AA67879C726AB0ABB6BA9C6A")

    private int mDefaultActionButtonContentDescription;

        /**
         * Create a new instance.
         *
         * @param context The application environment.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.074 -0400", hash_original_method = "B1417C53B7334442AE372C957DCB8F0C", hash_generated_method = "E063C2FA1E7EEC72A2E6214EEDDC4ECF")
    
public ActivityChooserView(Context context) {
            this(context, null);
    }

    /**
     * Create a new instance.
     *
     * @param context The application environment.
     * @param attrs A collection of attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.081 -0400", hash_original_method = "5446B591236758FE1022AC56CCF4E7CA", hash_generated_method = "9C4D4A982224BB1AC65996BF330FC39F")
    
public ActivityChooserView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * Create a new instance.
     *
     * @param context The application environment.
     * @param attrs A collection of attributes.
     * @param defStyle The default style to apply to this view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.117 -0400", hash_original_method = "33AD01C1613CE1E96666F2B60FFD15EE", hash_generated_method = "F35F597957425AB1D750C1621F887523")
    
public ActivityChooserView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray attributesArray = context.obtainStyledAttributes(attrs,
                R.styleable.ActivityChooserView, defStyle, 0);

        mInitialActivityCount = attributesArray.getInt(
                R.styleable.ActivityChooserView_initialActivityCount,
                ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_DEFAULT);

        Drawable expandActivityOverflowButtonDrawable = attributesArray.getDrawable(
                R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);

        attributesArray.recycle();

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.abc_activity_chooser_view, this, true);

        mCallbacks = new Callbacks();

        mActivityChooserContent = (LinearLayout) findViewById(R.id.activity_chooser_view_content);
        mActivityChooserContentBackground = mActivityChooserContent.getBackground();

        mDefaultActivityButton = (FrameLayout) findViewById(R.id.default_activity_button);
        mDefaultActivityButton.setOnClickListener(mCallbacks);
        mDefaultActivityButton.setOnLongClickListener(mCallbacks);
        mDefaultActivityButtonImage = (ImageView) mDefaultActivityButton.findViewById(R.id.image);

        mExpandActivityOverflowButton = (FrameLayout) findViewById(R.id.expand_activities_button);
        mExpandActivityOverflowButton.setOnClickListener(mCallbacks);
        mExpandActivityOverflowButtonImage =
                (ImageView) mExpandActivityOverflowButton.findViewById(R.id.image);
        mExpandActivityOverflowButtonImage.setImageDrawable(expandActivityOverflowButtonDrawable);

        mAdapter = new ActivityChooserViewAdapter();
        mAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                updateAppearance();
            }
        });

        Resources resources = context.getResources();
        mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2,
                resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.124 -0400", hash_original_method = "200277448D26D5459B7D9186C5FC6866", hash_generated_method = "7CA8C25435FCB0A49E836568E8AAB8C5")
    
public void setActivityChooserModel(ActivityChooserModel dataModel) {
        mAdapter.setDataModel(dataModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    /**
     * Sets the background for the button that expands the activity
     * overflow list.
     *
     * <strong>Note:</strong> Clients would like to set this drawable
     * as a clue about the action the chosen activity will perform. For
     * example, if a share activity is to be chosen the drawable should
     * give a clue that sharing is to be performed.
     *
     * @param drawable The drawable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.130 -0400", hash_original_method = "40C8CFBBBEC7CE8C6DC800BBA1A8260F", hash_generated_method = "7E55EEEF5F724AD763B80D49887231E9")
    
public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    /**
     * Sets the content description for the button that expands the activity
     * overflow list.
     *
     * description as a clue about the action performed by the button.
     * For example, if a share activity is to be chosen the content
     * description should be something like "Share with".
     *
     * @param resourceId The content description resource id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.138 -0400", hash_original_method = "95620C68F93300AE0B72DB3EFBB12F8B", hash_generated_method = "244BF47F9E96CBBE6A993B50E71697B0")
    
public void setExpandActivityOverflowButtonContentDescription(int resourceId) {
        CharSequence contentDescription = getContext().getString(resourceId);
        mExpandActivityOverflowButtonImage.setContentDescription(contentDescription);
    }

    /**
     * Set the provider hosting this view, if applicable.
     * @hide Internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.146 -0400", hash_original_method = "4EB99ACA5BA34A284707803087697EF8", hash_generated_method = "E583E02C257A95EA5D22D959FF7F2B78")
    
public void setProvider(ActionProvider provider) {
        mProvider = provider;
    }

    /**
     * Shows the popup window with activities.
     *
     * @return True if the popup was shown, false if already showing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.152 -0400", hash_original_method = "D9F80F56BE7AEC83902DD1E82500AB90", hash_generated_method = "D00C2CF8DC2D9DAFE18E478CD85DD206")
    
public boolean showPopup() {
        if (isShowingPopup() || !mIsAttachedToWindow) {
            return false;
        }
        mIsSelectingDefaultActivity = false;
        showPopupUnchecked(mInitialActivityCount);
        return true;
    }

    /**
     * Shows the popup no matter if it was already showing.
     *
     * @param maxActivityCount The max number of activities to display.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.166 -0400", hash_original_method = "9CE94D17A12EDE30B7CAE8D136113E99", hash_generated_method = "650813DD8E487A5BC9B795C4E00B486D")
    
private void showPopupUnchecked(int maxActivityCount) {
        if (mAdapter.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }

        getViewTreeObserver().addOnGlobalLayoutListener(mOnGlobalLayoutListener);

        final boolean defaultActivityButtonShown =
                mDefaultActivityButton.getVisibility() == VISIBLE;

        final int activityCount = mAdapter.getActivityCount();
        final int maxActivityCountOffset = defaultActivityButtonShown ? 1 : 0;
        if (maxActivityCount != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED
                && activityCount > maxActivityCount + maxActivityCountOffset) {
            mAdapter.setShowFooterView(true);
            mAdapter.setMaxActivityCount(maxActivityCount - 1);
        } else {
            mAdapter.setShowFooterView(false);
            mAdapter.setMaxActivityCount(maxActivityCount);
        }

        ListPopupWindow popupWindow = getListPopupWindow();
        if (!popupWindow.isShowing()) {
            if (mIsSelectingDefaultActivity || !defaultActivityButtonShown) {
                mAdapter.setShowDefaultActivity(true, defaultActivityButtonShown);
            } else {
                mAdapter.setShowDefaultActivity(false, false);
            }
            final int contentWidth = Math.min(mAdapter.measureContentWidth(), mListPopupMaxWidth);
            popupWindow.setContentWidth(contentWidth);
            popupWindow.show();
            if (mProvider != null) {
                mProvider.subUiVisibilityChanged(true);
            }
            popupWindow.getListView().setContentDescription(getContext().getString(
                    R.string.abc_activitychooserview_choose_application));
        }
    }

    /**
     * Dismisses the popup window with activities.
     *
     * @return True if dismissed, false if already dismissed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.173 -0400", hash_original_method = "D685C2FA386E3559D94DAB46E30EF0B9", hash_generated_method = "C2DDB97E7C57BEF40BF526EA65D8CE24")
    
public boolean dismissPopup() {
        if (isShowingPopup()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
            }
        }
        return true;
    }

    /**
     * Gets whether the popup window with activities is shown.
     *
     * @return True if the popup is shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.179 -0400", hash_original_method = "E45D6D96430861522854D560F5CA6F0B", hash_generated_method = "1DD86CA2457166B3F593DEB15897F714")
    
public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.187 -0400", hash_original_method = "F599B3D6D046BF4212D64A5D6A7F3811", hash_generated_method = "1BDC73DC6EFA2005BFFC48DBE183556D")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(mModelDataSetOberver);
        }
        mIsAttachedToWindow = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.195 -0400", hash_original_method = "7E71CDA0F3C2B578254DD70E83EDE25B", hash_generated_method = "04802FD12C01A71E9635A75F6A9852D2")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(mModelDataSetOberver);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        mIsAttachedToWindow = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.204 -0400", hash_original_method = "77C33EEC897BED8B2A12DF2072C37646", hash_generated_method = "9D1D1B5FDBCAA73E25941C2C046FB3E1")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View child = mActivityChooserContent;
        // If the default action is not visible we want to be as tall as the
        // ActionBar so if this widget is used in the latter it will look as
        // a normal action button.
        if (mDefaultActivityButton.getVisibility() != VISIBLE) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec),
                    MeasureSpec.EXACTLY);
        }
        measureChild(child, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(child.getMeasuredWidth(), child.getMeasuredHeight());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.213 -0400", hash_original_method = "DE0A4DAF9285E57B16E745D48F5BA106", hash_generated_method = "0725EE94DBE541619A3C55516C19556B")
    
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        mActivityChooserContent.layout(0, 0, right - left, bottom - top);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.218 -0400", hash_original_method = "5EF19A4E1889AB1FC4A984C090B7713C", hash_generated_method = "78F3FD24DEDB33DAFFEC7DBCFD7398C8")
    
public ActivityChooserModel getDataModel() {
        return mAdapter.getDataModel();
    }

    /**
     * Sets a listener to receive a callback when the popup is dismissed.
     *
     * @param listener The listener to be notified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.224 -0400", hash_original_method = "3D692CC2129791FB098BE485AC739689", hash_generated_method = "646CA777CA3BD94B548B89AA5ECE5C37")
    
public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        mOnDismissListener = listener;
    }

    /**
     * Sets the initial count of items shown in the activities popup
     * i.e. the items before the popup is expanded. This is an upper
     * bound since it is not guaranteed that such number of intent
     * handlers exist.
     *
     * @param itemCount The initial popup item count.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.230 -0400", hash_original_method = "861F24EC23ECA4CA4EF104A377B2D34D", hash_generated_method = "054A6C06A17160E95993F310B8213C63")
    
public void setInitialActivityCount(int itemCount) {
        mInitialActivityCount = itemCount;
    }

    /**
     * Sets a content description of the default action button. This
     * resource should be a string taking one formatting argument and
     * will be used for formatting the content description of the button
     * dynamically as the default target changes. For example, a resource
     * pointing to the string "share with %1$s" will result in a content
     * description "share with Bluetooth" for the Bluetooth activity.
     *
     * @param resourceId The resource id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.235 -0400", hash_original_method = "A16FFC5DB1EC302B931A83E3D5524FB1", hash_generated_method = "C629AA06D356B9FEAB0CA181CB732ECF")
    
public void setDefaultActionButtonContentDescription(int resourceId) {
        mDefaultActionButtonContentDescription = resourceId;
    }

    /**
     * Gets the list popup window which is lazily initialized.
     *
     * @return The popup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.241 -0400", hash_original_method = "A13663EF62899FD593D247A6177CE71D", hash_generated_method = "560AF4251C87CB0E76394EEC66EDDE2F")
    
private ListPopupWindow getListPopupWindow() {
        if (mListPopupWindow == null) {
            mListPopupWindow = new ListPopupWindow(getContext());
            mListPopupWindow.setAdapter(mAdapter);
            mListPopupWindow.setAnchorView(ActivityChooserView.this);
            mListPopupWindow.setModal(true);
            mListPopupWindow.setOnItemClickListener(mCallbacks);
            mListPopupWindow.setOnDismissListener(mCallbacks);
        }
        return mListPopupWindow;
    }

    /**
     * Updates the buttons state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:30:38.250 -0400", hash_original_method = "27AB5F2A5A8B2AC4357EE65702D51A87", hash_generated_method = "5F18116A5451AEF5520523E56814353B")
    
private void updateAppearance() {
        // Expand overflow button.
        if (mAdapter.getCount() > 0) {
            mExpandActivityOverflowButton.setEnabled(true);
        } else {
            mExpandActivityOverflowButton.setEnabled(false);
        }
        // Default activity button.
        final int activityCount = mAdapter.getActivityCount();
        final int historySize = mAdapter.getHistorySize();
        if (activityCount==1 || activityCount > 1 && historySize > 0) {
            mDefaultActivityButton.setVisibility(VISIBLE);
            ResolveInfo activity = mAdapter.getDefaultActivity();
            PackageManager packageManager = getContext().getPackageManager();
            mDefaultActivityButtonImage.setImageDrawable(activity.loadIcon(packageManager));
            if (mDefaultActionButtonContentDescription != 0) {
                CharSequence label = activity.loadLabel(packageManager);
                String contentDescription = getContext().getString(
                        mDefaultActionButtonContentDescription, label);
                mDefaultActivityButton.setContentDescription(contentDescription);
            }
        } else {
            mDefaultActivityButton.setVisibility(View.GONE);
        }
        // Activity chooser content.
        if (mDefaultActivityButton.getVisibility() == VISIBLE) {
            mActivityChooserContent.setBackgroundDrawable(mActivityChooserContentBackground);
        } else {
            mActivityChooserContent.setBackgroundDrawable(null);
        }
    }

    /**
     * Interface implementation to avoid publishing them in the APIs.
     */
    private class Callbacks implements AdapterView.OnItemClickListener,
            View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {

        // AdapterView#OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ActivityChooserViewAdapter adapter = (ActivityChooserViewAdapter) parent.getAdapter();
            final int itemViewType = adapter.getItemViewType(position);
            switch (itemViewType) {
                case ActivityChooserViewAdapter.ITEM_VIEW_TYPE_FOOTER: {
                    showPopupUnchecked(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                } break;
                case ActivityChooserViewAdapter.ITEM_VIEW_TYPE_ACTIVITY: {
                    dismissPopup();
                    if (mIsSelectingDefaultActivity) {
                        // The item at position zero is the default already.
                        if (position > 0) {
                            mAdapter.getDataModel().setDefaultActivity(position);
                        }
                    } else {
                        // If the default target is not shown in the list, the first
                        // item in the model is default action => adjust index
                        position = mAdapter.getShowDefaultActivity() ? position : position + 1;
                        Intent launchIntent = mAdapter.getDataModel().chooseActivity(position);
                        if (launchIntent != null) {
                            launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                            getContext().startActivity(launchIntent);
                        }
                    }
                } break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        // View.OnClickListener
        public void onClick(View view) {
            if (view == mDefaultActivityButton) {
                dismissPopup();
                ResolveInfo defaultActivity = mAdapter.getDefaultActivity();
                final int index = mAdapter.getDataModel().getActivityIndex(defaultActivity);
                Intent launchIntent = mAdapter.getDataModel().chooseActivity(index);
                if (launchIntent != null) {
                    launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                    getContext().startActivity(launchIntent);
                }
            } else if (view == mExpandActivityOverflowButton) {
                mIsSelectingDefaultActivity = false;
                showPopupUnchecked(mInitialActivityCount);
            } else {
                throw new IllegalArgumentException();
            }
        }

        // OnLongClickListener#onLongClick
        @Override
        public boolean onLongClick(View view) {
            if (view == mDefaultActivityButton) {
                if (mAdapter.getCount() > 0) {
                    mIsSelectingDefaultActivity = true;
                    showPopupUnchecked(mInitialActivityCount);
                }
            } else {
                throw new IllegalArgumentException();
            }
            return true;
        }

        // PopUpWindow.OnDismissListener#onDismiss
        public void onDismiss() {
            notifyOnDismissListener();
            if (mProvider != null) {
                mProvider.subUiVisibilityChanged(false);
            }
        }

        private void notifyOnDismissListener() {
            if (mOnDismissListener != null) {
                mOnDismissListener.onDismiss();
            }
        }
    }

    /**
     * Adapter for backing the list of activities shown in the popup.
     */
    private class ActivityChooserViewAdapter extends BaseAdapter {

        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;

        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;

        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;

        private static final int ITEM_VIEW_TYPE_FOOTER = 1;

        private static final int ITEM_VIEW_TYPE_COUNT = 3;

        private ActivityChooserModel mDataModel;

        private int mMaxActivityCount = MAX_ACTIVITY_COUNT_DEFAULT;

        private boolean mShowDefaultActivity;

        private boolean mHighlightDefaultActivity;

        private boolean mShowFooterView;

        public void setDataModel(ActivityChooserModel dataModel) {
            ActivityChooserModel oldDataModel = mAdapter.getDataModel();
            if (oldDataModel != null && isShown()) {
                oldDataModel.unregisterObserver(mModelDataSetOberver);
            }
            mDataModel = dataModel;
            if (dataModel != null && isShown()) {
                dataModel.registerObserver(mModelDataSetOberver);
            }
            notifyDataSetChanged();
        }

        @Override
        public int getItemViewType(int position) {
            if (mShowFooterView && position == getCount() - 1) {
                return ITEM_VIEW_TYPE_FOOTER;
            } else {
                return ITEM_VIEW_TYPE_ACTIVITY;
            }
        }

        @Override
        public int getViewTypeCount() {
            return ITEM_VIEW_TYPE_COUNT;
        }

        public int getCount() {
            int count = 0;
            int activityCount = mDataModel.getActivityCount();
            if (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null) {
                activityCount--;
            }
            count = Math.min(activityCount, mMaxActivityCount);
            if (mShowFooterView) {
                count++;
            }
            return count;
        }

        public Object getItem(int position) {
            final int itemViewType = getItemViewType(position);
            switch (itemViewType) {
                case ITEM_VIEW_TYPE_FOOTER:
                    return null;
                case ITEM_VIEW_TYPE_ACTIVITY:
                    if (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null) {
                        position++;
                    }
                    return mDataModel.getActivity(position);
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            final int itemViewType = getItemViewType(position);
            switch (itemViewType) {
                case ITEM_VIEW_TYPE_FOOTER:
                    if (convertView == null || convertView.getId() != ITEM_VIEW_TYPE_FOOTER) {
                        convertView = LayoutInflater.from(getContext()).inflate(
                                R.layout.abc_activity_chooser_view_list_item, parent, false);
                        convertView.setId(ITEM_VIEW_TYPE_FOOTER);
                        TextView titleView = (TextView) convertView.findViewById(R.id.title);
                        titleView.setText(getContext().getString(
                                R.string.abc_activity_chooser_view_see_all));
                    }
                    return convertView;
                case ITEM_VIEW_TYPE_ACTIVITY:
                    if (convertView == null || convertView.getId() != R.id.list_item) {
                        convertView = LayoutInflater.from(getContext()).inflate(
                                R.layout.abc_activity_chooser_view_list_item, parent, false);
                    }
                    PackageManager packageManager = getContext().getPackageManager();
                    // Set the icon
                    ImageView iconView = (ImageView) convertView.findViewById(R.id.icon);
                    ResolveInfo activity = (ResolveInfo) getItem(position);
                    iconView.setImageDrawable(activity.loadIcon(packageManager));
                    // Set the title.
                    TextView titleView = (TextView) convertView.findViewById(R.id.title);
                    titleView.setText(activity.loadLabel(packageManager));
                    // Highlight the default.
                    if (mShowDefaultActivity && position == 0 && mHighlightDefaultActivity) {
                        //TODO convertView.setActivated(true);
                    } else {
                        //TODO convertView.setActivated(false);
                    }
                    return convertView;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int measureContentWidth() {
            // The user may have specified some of the target not to be shown but we
            // want to measure all of them since after expansion they should fit.
            final int oldMaxActivityCount = mMaxActivityCount;
            mMaxActivityCount = MAX_ACTIVITY_COUNT_UNLIMITED;

            int contentWidth = 0;
            View itemView = null;

            final int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            final int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            final int count = getCount();

            for (int i = 0; i < count; i++) {
                itemView = getView(i, itemView, null);
                itemView.measure(widthMeasureSpec, heightMeasureSpec);
                contentWidth = Math.max(contentWidth, itemView.getMeasuredWidth());
            }

            mMaxActivityCount = oldMaxActivityCount;

            return contentWidth;
        }

        public void setMaxActivityCount(int maxActivityCount) {
            if (mMaxActivityCount != maxActivityCount) {
                mMaxActivityCount = maxActivityCount;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo getDefaultActivity() {
            return mDataModel.getDefaultActivity();
        }

        public void setShowFooterView(boolean showFooterView) {
            if (mShowFooterView != showFooterView) {
                mShowFooterView = showFooterView;
                notifyDataSetChanged();
            }
        }

        public int getActivityCount() {
            return mDataModel.getActivityCount();
        }

        public int getHistorySize() {
            return mDataModel.getHistorySize();
        }

        public int getMaxActivityCount() {
            return mMaxActivityCount;
        }

        public ActivityChooserModel getDataModel() {
            return mDataModel;
        }

        public void setShowDefaultActivity(boolean showDefaultActivity,
                boolean highlightDefaultActivity) {
            if (mShowDefaultActivity != showDefaultActivity
                    || mHighlightDefaultActivity != highlightDefaultActivity) {
                mShowDefaultActivity = showDefaultActivity;
                mHighlightDefaultActivity = highlightDefaultActivity;
                notifyDataSetChanged();
            }
        }

        public boolean getShowDefaultActivity() {
            return mShowDefaultActivity;
        }
    }
}