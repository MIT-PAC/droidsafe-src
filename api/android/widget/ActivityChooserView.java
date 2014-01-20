package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ActivityChooserModel.ActivityChooserModelClient;

import com.android.internal.R;

public class ActivityChooserView extends ViewGroup implements ActivityChooserModelClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.809 -0500", hash_original_field = "3F351B3FFE95814B5FCDF7093922C09C", hash_generated_field = "693752B4212B867133E03234F672DAB4")

    private  ActivityChooserViewAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.812 -0500", hash_original_field = "5F7F864DF881DE2C32D18CBBF247398B", hash_generated_field = "56C5A3BFBAA3C4CF09CF9C52EF52DD5C")

    private  Callbacks mCallbacks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.814 -0500", hash_original_field = "F4B1FE41D7FEEA54B1C2F06D9CA84B89", hash_generated_field = "15A85E7B2533D5C1858324D4690F18CE")

    private  LinearLayout mActivityChooserContent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.816 -0500", hash_original_field = "1D6AD35FC2C33762935586ED0B8C5754", hash_generated_field = "2CCC7C8CA771AD7217D2AFD6C98780B1")

    private  Drawable mActivityChooserContentBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.819 -0500", hash_original_field = "E4BA8FBEB535AFC704E8B17A0F664D29", hash_generated_field = "3CE55FDBD0D926D55E38007406C4DF14")

    private  FrameLayout mExpandActivityOverflowButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.821 -0500", hash_original_field = "384E3CAAB14F9963DF9008EEAF1C073A", hash_generated_field = "433B613895F9A9778E53C598D01BA2AB")

    private  ImageView mExpandActivityOverflowButtonImage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.823 -0500", hash_original_field = "9B62C3262343F53DB60F87EFB9948CFE", hash_generated_field = "2804585A9E453E27976F3FDF1A270905")

    private  FrameLayout mDefaultActivityButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.825 -0500", hash_original_field = "059EDE42A29D1D3E6C101016D537F42D", hash_generated_field = "A19ECBBBF75A40B339DC4A95C030E78B")

    private  ImageView mDefaultActivityButtonImage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.828 -0500", hash_original_field = "5B538EC0DE554B078568B7505C7993AE", hash_generated_field = "6549412A83E8736AC71A3C4F42B2776F")

    private  int mListPopupMaxWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.829 -0500", hash_original_field = "94389E96F8958E34938A4C66FB6778B1", hash_generated_field = "94389E96F8958E34938A4C66FB6778B1")

    ActionProvider mProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.555 -0400", hash_original_field = "E2DFFEE4700584126C30F533416180E4", hash_generated_field = "E3CC1E1FF392AFD93A20524A892FFE2D")

    private final DataSetObserver mModelDataSetOberver = new DataSetObserver() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.555 -0400", hash_original_method = "D32F752C027D2B93516AB0AF431CE07C", hash_generated_method = "D9FEC22D26AFC73436AFDEEE1426D33F")
        @Override
        public void onChanged() {
            
            super.onChanged();
            mAdapter.notifyDataSetChanged();
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.555 -0400", hash_original_method = "0D3B938F42D9BBAAA5442D3FB85ABED0", hash_generated_method = "339192657B2FC07CDF5B74397DFBCE1B")
        @Override
        public void onInvalidated() {
            
            super.onInvalidated();
            mAdapter.notifyDataSetInvalidated();
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_field = "5EF451EC8A0E03D344AD0776D0D040B4", hash_generated_field = "6C78DAD49C1A9E04692D0D35D8767C86")

    private final OnGlobalLayoutListener mOnGlobalLayoutListener = new OnGlobalLayoutListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_method = "B9295CF4AC3C2667F7355FBB8B3B9DC6", hash_generated_method = "A8DAFB1F81F49A42ED919BCD38D786B6")
        @Override
        public void onGlobalLayout() {
            
            {
                boolean var86D2C12CD473A200156C05DF07DBDDED_1247933307 = (isShowingPopup());
                {
                    {
                        boolean var87DC1C3C75E5DCFD494722F4CBC795CB_1948454925 = (!isShown());
                        {
                            getListPopupWindow().dismiss();
                        } 
                        {
                            getListPopupWindow().show();
                            {
                                mProvider.subUiVisibilityChanged(true);
                            } 
                        } 
                    } 
                } 
            }
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.845 -0500", hash_original_field = "BB013E7DF74239BB99B193DBA10B6B74", hash_generated_field = "B18FE4D2C1F5F5724780B69F0C631713")

    private ListPopupWindow mListPopupWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.847 -0500", hash_original_field = "A814A01FB60554553F2F3B14C367F7B8", hash_generated_field = "5A4179E23C1E43233D6280AC184F1638")

    private PopupWindow.OnDismissListener mOnDismissListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.849 -0500", hash_original_field = "2ED08702AFE65988152D8183044C6A80", hash_generated_field = "FB5A63E1FFE964D7D3DF45A85F8B7265")

    private boolean mIsSelectingDefaultActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.851 -0500", hash_original_field = "EBECD9BBECE734BE93A6CE80ACC853B4", hash_generated_field = "04519B5943EE67A9C7EEE82652B59883")

    private int mInitialActivityCount = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.853 -0500", hash_original_field = "3395A79183756ED462089216FAF67ED2", hash_generated_field = "A725E70F25078818B1BC03DF5AE609A6")

    private boolean mIsAttachedToWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.856 -0500", hash_original_field = "48C1C82D82D12C44A39558AE8E8B16EC", hash_generated_field = "2EB4D3D3AA67879C726AB0ABB6BA9C6A")

    private int mDefaultActionButtonContentDescription;

    /**
     * Create a new instance.
     *
     * @param context The application environment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.858 -0500", hash_original_method = "B1417C53B7334442AE372C957DCB8F0C", hash_generated_method = "E063C2FA1E7EEC72A2E6214EEDDC4ECF")
    
public ActivityChooserView(Context context) {
        this(context, null);
    }

    /**
     * Create a new instance.
     *
     * @param context The application environment.
     * @param attrs A collection of attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.861 -0500", hash_original_method = "5446B591236758FE1022AC56CCF4E7CA", hash_generated_method = "9C4D4A982224BB1AC65996BF330FC39F")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.867 -0500", hash_original_method = "82640F6029B5DED0016360DF13353C92", hash_generated_method = "3C7C5249E80AC7ABA84B7084BC923A6F")
    
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

        LayoutInflater inflater = LayoutInflater.from(mContext);
        inflater.inflate(R.layout.activity_chooser_view, this, true);

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
              resources.getDimensionPixelSize(com.android.internal.R.dimen.config_prefDialogWidth));
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.870 -0500", hash_original_method = "200277448D26D5459B7D9186C5FC6866", hash_generated_method = "7CA8C25435FCB0A49E836568E8AAB8C5")
    
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
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.872 -0500", hash_original_method = "40C8CFBBBEC7CE8C6DC800BBA1A8260F", hash_generated_method = "7E55EEEF5F724AD763B80D49887231E9")
    
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
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.874 -0500", hash_original_method = "0A5827A88A56386A8A69EC0550F49C43", hash_generated_method = "2828483A0CF08B7BEA13658480E18851")
    
public void setExpandActivityOverflowButtonContentDescription(int resourceId) {
        CharSequence contentDescription = mContext.getString(resourceId);
        mExpandActivityOverflowButtonImage.setContentDescription(contentDescription);
    }

    /**
     * Set the provider hosting this view, if applicable.
     * @hide Internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.876 -0500", hash_original_method = "4EB99ACA5BA34A284707803087697EF8", hash_generated_method = "E583E02C257A95EA5D22D959FF7F2B78")
    
public void setProvider(ActionProvider provider) {
        mProvider = provider;
    }

    /**
     * Shows the popup window with activities.
     *
     * @return True if the popup was shown, false if already showing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.878 -0500", hash_original_method = "D9F80F56BE7AEC83902DD1E82500AB90", hash_generated_method = "D00C2CF8DC2D9DAFE18E478CD85DD206")
    
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
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.881 -0500", hash_original_method = "3AECC6260DA21BAD7E8B15E74C7BA72C", hash_generated_method = "F392C09D31983111498AB59E23767E46")
    
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
            popupWindow.getListView().setContentDescription(mContext.getString(
                    R.string.activitychooserview_choose_application));
        }
    }

    /**
     * Dismisses the popup window with activities.
     *
     * @return True if dismissed, false if already dismissed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.884 -0500", hash_original_method = "D685C2FA386E3559D94DAB46E30EF0B9", hash_generated_method = "C2DDB97E7C57BEF40BF526EA65D8CE24")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.886 -0500", hash_original_method = "E45D6D96430861522854D560F5CA6F0B", hash_generated_method = "1DD86CA2457166B3F593DEB15897F714")
    
public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.889 -0500", hash_original_method = "F599B3D6D046BF4212D64A5D6A7F3811", hash_generated_method = "1BDC73DC6EFA2005BFFC48DBE183556D")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(mModelDataSetOberver);
        }
        mIsAttachedToWindow = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.891 -0500", hash_original_method = "589218240FC22193C94953AC6574E4EA", hash_generated_method = "12472C786CFBC9BBDD4C98E2C97ECEB9")
    
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
        mIsAttachedToWindow = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.893 -0500", hash_original_method = "77C33EEC897BED8B2A12DF2072C37646", hash_generated_method = "9D1D1B5FDBCAA73E25941C2C046FB3E1")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.895 -0500", hash_original_method = "C5A31C6F2FD14D87574B0913D4F6A2F2", hash_generated_method = "E5997C7136C378E58D16F839619CC16B")
    
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        mActivityChooserContent.layout(0, 0, right - left, bottom - top);
        if (getListPopupWindow().isShowing()) {
            showPopupUnchecked(mAdapter.getMaxActivityCount());
        } else {
            dismissPopup();
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.897 -0500", hash_original_method = "5EF19A4E1889AB1FC4A984C090B7713C", hash_generated_method = "78F3FD24DEDB33DAFFEC7DBCFD7398C8")
    
public ActivityChooserModel getDataModel() {
        return mAdapter.getDataModel();
    }

    /**
     * Sets a listener to receive a callback when the popup is dismissed.
     *
     * @param listener The listener to be notified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.899 -0500", hash_original_method = "3D692CC2129791FB098BE485AC739689", hash_generated_method = "646CA777CA3BD94B548B89AA5ECE5C37")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.902 -0500", hash_original_method = "861F24EC23ECA4CA4EF104A377B2D34D", hash_generated_method = "054A6C06A17160E95993F310B8213C63")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.904 -0500", hash_original_method = "A16FFC5DB1EC302B931A83E3D5524FB1", hash_generated_method = "C629AA06D356B9FEAB0CA181CB732ECF")
    
public void setDefaultActionButtonContentDescription(int resourceId) {
        mDefaultActionButtonContentDescription = resourceId;
    }

    /**
     * Gets the list popup window which is lazily initialized.
     *
     * @return The popup.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.906 -0500", hash_original_method = "A13663EF62899FD593D247A6177CE71D", hash_generated_method = "560AF4251C87CB0E76394EEC66EDDE2F")
    
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
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.909 -0500", hash_original_method = "D65ED5C5B81BB78866247BEAE65AB728", hash_generated_method = "34E36C8EBAFBBEDFE1CC6C6EAD7638E1")
    
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
        if (activityCount > 0 && historySize > 0) {
            mDefaultActivityButton.setVisibility(VISIBLE);
            ResolveInfo activity = mAdapter.getDefaultActivity();
            PackageManager packageManager = mContext.getPackageManager();
            mDefaultActivityButtonImage.setImageDrawable(activity.loadIcon(packageManager));
            if (mDefaultActionButtonContentDescription != 0) {
                CharSequence label = activity.loadLabel(packageManager);
                String contentDescription = mContext.getString(
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
    
    private class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.274 -0400", hash_original_method = "BBA4719757F5E3331C7832D116B199C8", hash_generated_method = "BBA4719757F5E3331C7832D116B199C8")
        public Callbacks ()
        {
            //Synthesized constructor
        }

        // AdapterView#OnItemClickListener
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.912 -0500", hash_original_method = "674D57987B8C667CB3D7FFB12FCDD905", hash_generated_method = "E4C0C4C38F74A766C702A9760A1B64E9")
        
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
                            mContext.startActivity(launchIntent);
                        }
                    }
                } break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        // View.OnClickListener
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.915 -0500", hash_original_method = "B05554F780928527AD52A76E48C9B5FF", hash_generated_method = "E4483F53EB2A9A71231215BC72C66341")
        
public void onClick(View view) {
            if (view == mDefaultActivityButton) {
                dismissPopup();
                ResolveInfo defaultActivity = mAdapter.getDefaultActivity();
                final int index = mAdapter.getDataModel().getActivityIndex(defaultActivity);
                Intent launchIntent = mAdapter.getDataModel().chooseActivity(index);
                if (launchIntent != null) {
                    mContext.startActivity(launchIntent);
                }
            } else if (view == mExpandActivityOverflowButton) {
                mIsSelectingDefaultActivity = false;
                showPopupUnchecked(mInitialActivityCount);
            } else {
                throw new IllegalArgumentException();
            }
        }

        // OnLongClickListener#onLongClick
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.918 -0500", hash_original_method = "FB2F3C2103372446E9D5711FBCAD6598", hash_generated_method = "9298A64270E0D1D940C21EBDBE178027")
        
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.921 -0500", hash_original_method = "D25064A646F02B95A775BA0461A79BFD", hash_generated_method = "9C935B337FDC78BE000FA77E6CF4F0F1")
        
public void onDismiss() {
            notifyOnDismissListener();
            if (mProvider != null) {
                mProvider.subUiVisibilityChanged(false);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.923 -0500", hash_original_method = "5021FB127D2DB881B8B1C45B5E11E195", hash_generated_method = "243392C772A9BC77EF67532E254E8061")
        
private void notifyOnDismissListener() {
            if (mOnDismissListener != null) {
                mOnDismissListener.onDismiss();
            }
        }
        
    }
    
    private class ActivityChooserViewAdapter extends BaseAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.929 -0500", hash_original_field = "637563A4CADCC421032776B7189E324F", hash_generated_field = "76769A97B1782495BC5DE9799BE9BD4F")

        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.931 -0500", hash_original_field = "A01E68BDA61400E3F0BC1E4CE42834B7", hash_generated_field = "A9C0946733D648F3335EA0A2B5A4F65D")

        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.934 -0500", hash_original_field = "9AD9638BB19AF056A73B14D2A3109AFA", hash_generated_field = "383E306DC665688B3D7C808185F54821")

        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.936 -0500", hash_original_field = "F67F8A5777A6E708B0365D294FE72C46", hash_generated_field = "79F678647BCDD97164F6B347EC57B1D5")

        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.939 -0500", hash_original_field = "A9B4060812AC9104573074A9C76E375F", hash_generated_field = "68D4CDA5BEF3FD9B9DF66A65A3536699")

        private static final int ITEM_VIEW_TYPE_COUNT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.941 -0500", hash_original_field = "33F010D74E93C92C18F988460F8E8539", hash_generated_field = "4B23A60A5EE2A01D93FA935950453A89")

        private ActivityChooserModel mDataModel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.943 -0500", hash_original_field = "C3BF0369BC4EA7E33A042F1DE10F4C47", hash_generated_field = "7E27524CCC6935FAB8F88BAF1C6AE0A3")

        private int mMaxActivityCount = MAX_ACTIVITY_COUNT_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.945 -0500", hash_original_field = "E8C0AF4A67574319BEFFF1ED0F2B0CD9", hash_generated_field = "E8EE97CA68AAFA64A18B7D487730ED89")

        private boolean mShowDefaultActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.947 -0500", hash_original_field = "0BBADB85C94CD3C7B8DC6376EF1F6982", hash_generated_field = "F496D5B1359B104FF475E03332F1A6A6")

        private boolean mHighlightDefaultActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.950 -0500", hash_original_field = "27B08A4BFB3CF0904C5B6F5ECE831169", hash_generated_field = "41BD5170A6AC3F68C312DE8FD93FC32C")

        private boolean mShowFooterView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.279 -0400", hash_original_method = "BA43971C492C1B02A22C4BF340770F66", hash_generated_method = "BA43971C492C1B02A22C4BF340770F66")
        public ActivityChooserViewAdapter ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.952 -0500", hash_original_method = "ACCCD73AF35EBCB0E150696E3946651D", hash_generated_method = "FB868E69217D4B640F34F2441B3AE491")
        
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

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.955 -0500", hash_original_method = "39EE4EFF86EDF87DA80E694DA09810EF", hash_generated_method = "AFFE9FD217FBC5DC418B59F0EDC2003B")
        
@Override
        public int getItemViewType(int position) {
            if (mShowFooterView && position == getCount() - 1) {
                return ITEM_VIEW_TYPE_FOOTER;
            } else {
                return ITEM_VIEW_TYPE_ACTIVITY;
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.957 -0500", hash_original_method = "A69A431394F21E5FD61198963B3D5202", hash_generated_method = "20AE410B16A1786EC19C6948092E52B9")
        
@Override
        public int getViewTypeCount() {
            return ITEM_VIEW_TYPE_COUNT;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.959 -0500", hash_original_method = "1BE11BD9F55247D049566CF39D6E3C60", hash_generated_method = "3F1664B2F078CC0C835E0AA6CD11DA20")
        
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

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.962 -0500", hash_original_method = "F3D4BDC985376DF5677372C13824236A", hash_generated_method = "BB8CF48BFC2A326C1F085E177B2C4AC4")
        
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

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.964 -0500", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "86EF76D6295D66F6DBBE39DCDBA9A1C9")
        
public long getItemId(int position) {
            return position;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.968 -0500", hash_original_method = "6D38E6A963432D636038206F8FE6305D", hash_generated_method = "72FAC188CB494C428DA4BE64066D15F1")
        
public View getView(int position, View convertView, ViewGroup parent) {
            final int itemViewType = getItemViewType(position);
            switch (itemViewType) {
                case ITEM_VIEW_TYPE_FOOTER:
                    if (convertView == null || convertView.getId() != ITEM_VIEW_TYPE_FOOTER) {
                        convertView = LayoutInflater.from(getContext()).inflate(
                                R.layout.activity_chooser_view_list_item, parent, false);
                        convertView.setId(ITEM_VIEW_TYPE_FOOTER);
                        TextView titleView = (TextView) convertView.findViewById(R.id.title);
                        titleView.setText(mContext.getString(
                                R.string.activity_chooser_view_see_all));
                    }
                    return convertView;
                case ITEM_VIEW_TYPE_ACTIVITY:
                    if (convertView == null || convertView.getId() != R.id.list_item) {
                        convertView = LayoutInflater.from(getContext()).inflate(
                                R.layout.activity_chooser_view_list_item, parent, false);
                    }
                    PackageManager packageManager = mContext.getPackageManager();
                    // Set the icon
                    ImageView iconView = (ImageView) convertView.findViewById(R.id.icon);
                    ResolveInfo activity = (ResolveInfo) getItem(position);
                    iconView.setImageDrawable(activity.loadIcon(packageManager));
                    // Set the title.
                    TextView titleView = (TextView) convertView.findViewById(R.id.title);
                    titleView.setText(activity.loadLabel(packageManager));
                    // Highlight the default.
                    if (mShowDefaultActivity && position == 0 && mHighlightDefaultActivity) {
                        convertView.setActivated(true);
                    } else {
                        convertView.setActivated(false);
                    }
                    return convertView;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.971 -0500", hash_original_method = "E7848C130F305A2BB53DDDF9782AAF0B", hash_generated_method = "E5D3A90612DD6F3F197FB8C767EF2B11")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.973 -0500", hash_original_method = "EE079429AB45DD891FDFB8F4CAB39411", hash_generated_method = "3020F04B40F6977C333D532F8EA9AAD6")
        
public void setMaxActivityCount(int maxActivityCount) {
            if (mMaxActivityCount != maxActivityCount) {
                mMaxActivityCount = maxActivityCount;
                notifyDataSetChanged();
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.975 -0500", hash_original_method = "D919FDFCC3B420966F5D4C74A721F1BF", hash_generated_method = "7F765F26FE94A734EA8E9C715E1C66E7")
        
public ResolveInfo getDefaultActivity() {
            return mDataModel.getDefaultActivity();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.977 -0500", hash_original_method = "4D9F28247FB57368F2D0E306E2284064", hash_generated_method = "E1D650572D7F0EAE82C4BBE3D262FBFC")
        
public void setShowFooterView(boolean showFooterView) {
            if (mShowFooterView != showFooterView) {
                mShowFooterView = showFooterView;
                notifyDataSetChanged();
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.979 -0500", hash_original_method = "31736EA607A445202315EB7B50B5EA80", hash_generated_method = "5E3784ADE901B7AD8BE9FD82E60E244A")
        
public int getActivityCount() {
            return mDataModel.getActivityCount();
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.981 -0500", hash_original_method = "1D0D91D46AAECCD7C2767CF25FDA64BD", hash_generated_method = "5020D9D3163C0DDB1CAD86A4F375AC44")
        
public int getHistorySize() {
            return mDataModel.getHistorySize();
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.983 -0500", hash_original_method = "3E4531A24528D01DAB939C9C71B2C3DE", hash_generated_method = "392495D86C791FE80270745B8217253A")
        
public int getMaxActivityCount() {
            return mMaxActivityCount;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.985 -0500", hash_original_method = "5525C6AC91C9709046E305FD9A15863B", hash_generated_method = "5EF3A5B97BCC3C6483416DFFF51C45B6")
        
public ActivityChooserModel getDataModel() {
            return mDataModel;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.988 -0500", hash_original_method = "A23AAFB309F0D7012150D94437C8B43A", hash_generated_method = "2137907D30CB4D6541F4551250C70D86")
        
public void setShowDefaultActivity(boolean showDefaultActivity,
                boolean highlightDefaultActivity) {
            if (mShowDefaultActivity != showDefaultActivity
                    || mHighlightDefaultActivity != highlightDefaultActivity) {
                mShowDefaultActivity = showDefaultActivity;
                mHighlightDefaultActivity = highlightDefaultActivity;
                notifyDataSetChanged();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.991 -0500", hash_original_method = "1922E89BA39A7DE83F0D6E6EABDFE98E", hash_generated_method = "004A5EB89A6746438B25064007278E11")
        
public boolean getShowDefaultActivity() {
            return mShowDefaultActivity;
        }
    }
    
}

