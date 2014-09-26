package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

public class Spinner extends AbsSpinner implements OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.997 -0500", hash_original_field = "C4AB240E6B4A8D3A229E006BF52962A4", hash_generated_field = "24196829F47AA90801DC8C1D4AB09CA2")

    private static final String TAG = "Spinner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.000 -0500", hash_original_field = "15ED1CD78B6153A00A977803E319F374", hash_generated_field = "66E10B160A98D63911CB4E37185B80B0")

    private static final int MAX_ITEMS_MEASURED = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.003 -0500", hash_original_field = "72A01AA21E7488FAE1D6F0F6BB5C1A4B", hash_generated_field = "03A8B0FB324BD4C85C18EC4F45126C80")

    public static final int MODE_DIALOG = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.006 -0500", hash_original_field = "C247C0D11111308BB9C5C788C053857C", hash_generated_field = "77CCFBFBDA82C84B44434E6E2C506BCB")

    public static final int MODE_DROPDOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.008 -0500", hash_original_field = "F86A2C755CE2EB59C5978239E3310EC9", hash_generated_field = "ABE6A4AE1BB7B3ECDF9A30C989D50FCE")

    private static final int MODE_THEME = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.011 -0500", hash_original_field = "FC14FC3442A2E6593D55C850EF3DFBFB", hash_generated_field = "2B2C8DD5949DF96120E12CE686443E54")
    
    private SpinnerPopup mPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.013 -0500", hash_original_field = "1F5BCC6FC4C6935B9E8358A75684BF85", hash_generated_field = "C1900A4CF75F2ED95144B24FDA148887")

    private DropDownAdapter mTempAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.015 -0500", hash_original_field = "9F13B49ED3B4F15DF1C39EF57B2A0772", hash_generated_field = "9F13B49ED3B4F15DF1C39EF57B2A0772")

    int mDropDownWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.017 -0500", hash_original_field = "E8D24DE70DE8CB945622B4CE486A90EA", hash_generated_field = "ACF14A395FB2702990553CD0EFA1BDCC")

    private int mGravity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.019 -0500", hash_original_field = "A54FEEB2C700F354FBCE3AFFCB9861AC", hash_generated_field = "7967DE792AA6967947AC34B6AC2CC5E6")

    private boolean mDisableChildrenWhenDisabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.021 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();

    /**
     * Construct a new spinner with the given context's theme.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     */
    @DSComment("Spinner")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.023 -0500", hash_original_method = "B5C06F1AC4F38C2FF014EC091685338D", hash_generated_method = "9633135D3E212869BBD31A4116325EE4")
    
public Spinner(Context context) {
        this(context, null);
    }

    /**
     * Construct a new spinner with the given context's theme and the supplied
     * mode of displaying choices. <code>mode</code> may be one of
     * {@link #MODE_DIALOG} or {@link #MODE_DROPDOWN}.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param mode Constant describing how the user will select choices from the spinner.
     * 
     * @see #MODE_DIALOG
     * @see #MODE_DROPDOWN
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.026 -0500", hash_original_method = "6645D47A83FEF1D160E35889A652939D", hash_generated_method = "DA85D8CE468418FD64CFD306A5904CC0")
    
public Spinner(Context context, int mode) {
        this(context, null, com.android.internal.R.attr.spinnerStyle, mode);
    }

    /**
     * Construct a new spinner with the given context's theme and the supplied attribute set.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param attrs The attributes of the XML tag that is inflating the view.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.028 -0500", hash_original_method = "B198D16CD1474762E3B97C016462CA6F", hash_generated_method = "C08B012582A75C24870F29F57E03955F")
    
public Spinner(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.spinnerStyle);
    }

    /**
     * Construct a new spinner with the given context's theme, the supplied attribute set,
     * and default style.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param attrs The attributes of the XML tag that is inflating the view.
     * @param defStyle The default style to apply to this view. If 0, no style
     *        will be applied (beyond what is included in the theme). This may
     *        either be an attribute resource, whose value will be retrieved
     *        from the current theme, or an explicit style resource.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.032 -0500", hash_original_method = "78C6FE6C5EEF3610339F87F7F649A015", hash_generated_method = "E39FAA2260431DDADB5946A0DF57CCAF")
    
public Spinner(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, MODE_THEME);
    }

    /**
     * Construct a new spinner with the given context's theme, the supplied attribute set,
     * and default style. <code>mode</code> may be one of {@link #MODE_DIALOG} or
     * {@link #MODE_DROPDOWN} and determines how the user will select choices from the spinner.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param attrs The attributes of the XML tag that is inflating the view.
     * @param defStyle The default style to apply to this view. If 0, no style
     *        will be applied (beyond what is included in the theme). This may
     *        either be an attribute resource, whose value will be retrieved
     *        from the current theme, or an explicit style resource.
     * @param mode Constant describing how the user will select choices from the spinner.
     * 
     * @see #MODE_DIALOG
     * @see #MODE_DROPDOWN
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.035 -0500", hash_original_method = "290E4CD98FA983594AD8D129D824FCAE", hash_generated_method = "73212B78678341BDA0AB90B73660B778")
    
public Spinner(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Spinner, defStyle, 0);

        if (mode == MODE_THEME) {
            mode = a.getInt(com.android.internal.R.styleable.Spinner_spinnerMode, MODE_DIALOG);
        }
        
        switch (mode) {
        case MODE_DIALOG: {
            mPopup = new DialogPopup();
            break;
        }

        case MODE_DROPDOWN: {
            DropdownPopup popup = new DropdownPopup(context, attrs, defStyle);

            mDropDownWidth = a.getLayoutDimension(
                    com.android.internal.R.styleable.Spinner_dropDownWidth,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            popup.setBackgroundDrawable(a.getDrawable(
                    com.android.internal.R.styleable.Spinner_popupBackground));
            final int verticalOffset = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.Spinner_dropDownVerticalOffset, 0);
            if (verticalOffset != 0) {
                popup.setVerticalOffset(verticalOffset);
            }

            final int horizontalOffset = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.Spinner_dropDownHorizontalOffset, 0);
            if (horizontalOffset != 0) {
                popup.setHorizontalOffset(horizontalOffset);
            }

            mPopup = popup;
            break;
        }
        }
        
        mGravity = a.getInt(com.android.internal.R.styleable.Spinner_gravity, Gravity.CENTER);

        mPopup.setPromptText(a.getString(com.android.internal.R.styleable.Spinner_prompt));

        mDisableChildrenWhenDisabled = a.getBoolean(
                com.android.internal.R.styleable.Spinner_disableChildrenWhenDisabled, false);

        a.recycle();

        // Base constructor can call setAdapter before we initialize mPopup.
        // Finish setting things up if this happened.
        if (mTempAdapter != null) {
            mPopup.setAdapter(mTempAdapter);
            mTempAdapter = null;
        }
    }

    @DSComment("Spinner")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.037 -0500", hash_original_method = "E89DC933CAA3948ECC7191CDEBCA4F7F", hash_generated_method = "F0FBAB05DA6BEA4CE4204261FC3F4E56")
    
@Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (mDisableChildrenWhenDisabled) {
            final int count = getChildCount();
            for (int i = 0; i < count; i++) {
                getChildAt(i).setEnabled(enabled);
            }
        }
    }

    /**
     * Describes how the selected item view is positioned. Currently only the horizontal component
     * is used. The default is determined by the current theme.
     *
     * @param gravity See {@link android.view.Gravity}
     *
     * @attr ref android.R.styleable#Spinner_gravity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.040 -0500", hash_original_method = "2D67806CEC3CAAEAC987F460E7189BA9", hash_generated_method = "0ACAAAD9C2B88C8D76C69DAC094734DE")
    
public void setGravity(int gravity) {
        if (mGravity != gravity) {
            if ((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == 0) {
                gravity |= Gravity.LEFT;
            }
            mGravity = gravity;
            requestLayout();
        }
    }

    @DSComment("Spinner")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.042 -0500", hash_original_method = "60241601236C86A9296272064A15234D", hash_generated_method = "C3B2D6E860B82141D2CA77EF0BF7E624")
    
@Override
    public void setAdapter(SpinnerAdapter adapter) {
        super.setAdapter(adapter);

        if (mPopup != null) {
            mPopup.setAdapter(new DropDownAdapter(adapter));
        } else {
            mTempAdapter = new DropDownAdapter(adapter);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.044 -0500", hash_original_method = "50D7CC7A93B993E2A6FF522D575BAEB5", hash_generated_method = "611E2DA9775E0C612F4D5EF38FAF5956")
    
@Override
    public int getBaseline() {
        View child = null;

        if (getChildCount() > 0) {
            child = getChildAt(0);
        } else if (mAdapter != null && mAdapter.getCount() > 0) {
            child = makeAndAddView(0);
            mRecycler.put(0, child);
            removeAllViewsInLayout();
        }

        if (child != null) {
            final int childBaseline = child.getBaseline();
            return childBaseline >= 0 ? child.getTop() + childBaseline : -1;
        } else {
            return -1;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.046 -0500", hash_original_method = "B6F13EE08FDC85FB02DBBB6CA125C601", hash_generated_method = "D6B0999677F0279AF30F74D5F6760851")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        
        if (mPopup != null && mPopup.isShowing()) {
            mPopup.dismiss();
        }
    }

    /**
     * <p>A spinner does not support item click events. Calling this method
     * will raise an exception.</p>
     *
     * @param l this listener will be ignored
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.048 -0500", hash_original_method = "AE9F9278138E36A1F7A0C4102CD0DE5F", hash_generated_method = "E4893921088FD20363D1609510E45D60")
   @DSSafe(DSCat.SAFE_OTHERS) 
    @DSVerified
@Override
    public void setOnItemClickListener(OnItemClickListener l) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.051 -0500", hash_original_method = "EC8AF316641014792672178145DBD315", hash_generated_method = "C942D9FF9C76DDC01EC6017A7AFA16C3")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mPopup != null && MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST) {
            final int measuredWidth = getMeasuredWidth();
            setMeasuredDimension(Math.min(Math.max(measuredWidth,
                    measureContentWidth(getAdapter(), getBackground())),
                    MeasureSpec.getSize(widthMeasureSpec)),
                    getMeasuredHeight());
        }
    }

    /**
     * @see android.view.View#onLayout(boolean,int,int,int,int)
     *
     * Creates and positions all views
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.054 -0500", hash_original_method = "2F25E46AB3A307ED9F0C91E6C81BDCD4", hash_generated_method = "C9E4EF58D52414D83168BE0C17CAEF46")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mInLayout = true;
        layout(0, false);
        mInLayout = false;
    }

    /**
     * Creates and positions all views for this Spinner.
     *
     * @param delta Change in the selected position. +1 moves selection is moving to the right,
     * so views are scrolling to the left. -1 means selection is moving to the left.
     */
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.057 -0500", hash_original_method = "26F25590D97768D2F385154C131B8E76", hash_generated_method = "FACBA9BBE286204464A611CECC467DDC")
    
@Override
    void layout(int delta, boolean animate) {
        int childrenLeft = mSpinnerPadding.left;
        int childrenWidth = mRight - mLeft - mSpinnerPadding.left - mSpinnerPadding.right;

        if (mDataChanged) {
            handleDataChanged();
        }

        // Handle the empty set by removing all views
        if (mItemCount == 0) {
            resetList();
            return;
        }

        if (mNextSelectedPosition >= 0) {
            setSelectedPositionInt(mNextSelectedPosition);
        }

        recycleAllViews();

        // Clear out old views
        removeAllViewsInLayout();

        // Make selected view and position it
        mFirstPosition = mSelectedPosition;
        View sel = makeAndAddView(mSelectedPosition);
        int width = sel.getMeasuredWidth();
        int selectedOffset = childrenLeft;
        switch (mGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
            case Gravity.CENTER_HORIZONTAL:
                selectedOffset = childrenLeft + (childrenWidth / 2) - (width / 2);
                break;
            case Gravity.RIGHT:
                selectedOffset = childrenLeft + childrenWidth - width;
                break;
        }
        sel.offsetLeftAndRight(selectedOffset);

        // Flush any cached views that did not get reused above
        mRecycler.clear();

        invalidate();

        checkSelectionChanged();

        mDataChanged = false;
        mNeedSync = false;
        setNextSelectedPositionInt(mSelectedPosition);
    }

    /**
     * Obtain a view, either by pulling an existing view from the recycler or
     * by getting a new one from the adapter. If we are animating, make sure
     * there is enough information in the view's layout parameters to animate
     * from the old to new positions.
     *
     * @param position Position in the spinner for the view to obtain
     * @return A view that has been added to the spinner
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.059 -0500", hash_original_method = "16A0D15DF35F8329F5BE73262CE9B509", hash_generated_method = "C19A613AD32C7950E4F49F5A1A23137C")
    
private View makeAndAddView(int position) {

        View child;

        if (!mDataChanged) {
            child = mRecycler.get(position);
            if (child != null) {
                // Position the view
                setUpChild(child);

                return child;
            }
        }

        // Nothing found in the recycler -- ask the adapter for a view
        child = mAdapter.getView(position, null, this);

        // Position the view
        setUpChild(child);

        return child;
    }

    /**
     * Helper for makeAndAddView to set the position of a view
     * and fill out its layout paramters.
     *
     * @param child The view to position
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.062 -0500", hash_original_method = "EA422D8BE64CA8F3FB87FB3D4E23C7FB", hash_generated_method = "42C99DC0A0404256B7A2C1BF9AB20CE8")
    
private void setUpChild(View child) {

        // Respect layout params that are already in the view. Otherwise
        // make some up...
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        if (lp == null) {
            lp = generateDefaultLayoutParams();
        }

        addViewInLayout(child, 0, lp);

        child.setSelected(hasFocus());
        if (mDisableChildrenWhenDisabled) {
            child.setEnabled(isEnabled());
        }

        // Get measure specs
        int childHeightSpec = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec,
                mSpinnerPadding.top + mSpinnerPadding.bottom, lp.height);
        int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mSpinnerPadding.left + mSpinnerPadding.right, lp.width);

        // Measure child
        child.measure(childWidthSpec, childHeightSpec);

        int childLeft;
        int childRight;

        // Position vertically based on gravity setting
        int childTop = mSpinnerPadding.top
                + ((getMeasuredHeight() - mSpinnerPadding.bottom -
                        mSpinnerPadding.top - child.getMeasuredHeight()) / 2);
        int childBottom = childTop + child.getMeasuredHeight();

        int width = child.getMeasuredWidth();
        childLeft = 0;
        childRight = childLeft + width;

        child.layout(childLeft, childTop, childRight, childBottom);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.065 -0500", hash_original_method = "DE0583C7611D1F2BE10915793A501A4C", hash_generated_method = "BED26375FFB74C4D31CC868D7993F631")
    
@Override
    public boolean performClick() {
        boolean handled = super.performClick();
        
        if (!handled) {
            handled = true;

            if (!mPopup.isShowing()) {
                mPopup.show();
            }
        }

        return handled;
    }
    
    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.079 -0500", hash_original_field = "F3411DF47899C6681AB924958C72D742", hash_generated_field = "3308AF23407F136C8CF926C7FBD8DC1B")

        private SpinnerAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.081 -0500", hash_original_field = "2CACD7266980B6DFC0CAE7F9BA8B8C48", hash_generated_field = "EBBA0833135A672B66F462D046DC0A24")

        private ListAdapter mListAdapter;

        /**
         * <p>Creates a new ListAdapter wrapper for the specified adapter.</p>
         *
         * @param adapter the Adapter to transform into a ListAdapter
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.084 -0500", hash_original_method = "FD9BEBCCABA72AC6ECD15A9F9D903ED1", hash_generated_method = "C07BEE24566658C9EAAB73C90E0A2FC9")
        
public DropDownAdapter(SpinnerAdapter adapter) {
            this.mAdapter = adapter;
            if (adapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) adapter;
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.086 -0500", hash_original_method = "7176E9532C0349D7016ABE3301806E2C", hash_generated_method = "ABAE663C8AC8F01A715ED84AE922B778")
        
public int getCount() {
            return mAdapter == null ? 0 : mAdapter.getCount();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.088 -0500", hash_original_method = "E5529375AE985E64AC9FCAEB196D1278", hash_generated_method = "F7E6CB401961A1E291BC7ABB39C301C3")
        
public Object getItem(int position) {
            return mAdapter == null ? null : mAdapter.getItem(position);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.090 -0500", hash_original_method = "516B3E26F5C00C4BD8BAF28DFF38500C", hash_generated_method = "B8F4839BD8D550183657C800480C87BD")
        
public long getItemId(int position) {
            return mAdapter == null ? -1 : mAdapter.getItemId(position);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.092 -0500", hash_original_method = "A9F8983A232A0A246637701F010ACE34", hash_generated_method = "03AFF81851DA0BC76885ED27D0C5048D")
        @DSVerified
        @DSSafe(DSCat.GUI)
public View getView(int position, View convertView, ViewGroup parent) {
            return getDropDownView(position, convertView, parent);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.095 -0500", hash_original_method = "F097CA4C24B6E5261C3C9C12681A60CA", hash_generated_method = "913C5CA37528A27E8EF4206A364B885C")
        @DSVerified
        @DSSafe(DSCat.GUI)   
public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return mAdapter == null ? null :
                    mAdapter.getDropDownView(position, convertView, parent);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.098 -0500", hash_original_method = "EE546908428E55FCCB0B2F98C659D31B", hash_generated_method = "8500215988217A55022DA9C9B63866B4")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public boolean hasStableIds() {
            return mAdapter != null && mAdapter.hasStableIds();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.100 -0500", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "B74E824CE2534F171C068A593B2FABFD")
        @DSVerified("Callback registration")
        @DSSafe(DSCat.ANDROID_CALLBACK)
public void registerDataSetObserver(DataSetObserver observer) {
            if (mAdapter != null) {
                mAdapter.registerDataSetObserver(observer);
            }
            if (observer != null) {
                observer.onChanged();
                observer.onInvalidated();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.102 -0500", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "1A40DA71628EA2969005B726C48A6DC9")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public void unregisterDataSetObserver(DataSetObserver observer) {
            if (mAdapter != null) {
                mAdapter.unregisterDataSetObserver(observer);
            }
        }

        /**
         * If the wrapped SpinnerAdapter is also a ListAdapter, delegate this call.
         * Otherwise, return true. 
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.104 -0500", hash_original_method = "C6F9771E1B3DE27F3DC1DA3F2DDBE42B", hash_generated_method = "9CD65AF04440386CF916AA4E6D43755F")
        
public boolean areAllItemsEnabled() {
            final ListAdapter adapter = mListAdapter;
            if (adapter != null) {
                return adapter.areAllItemsEnabled();
            } else {
                return true;
            }
        }

        /**
         * If the wrapped SpinnerAdapter is also a ListAdapter, delegate this call.
         * Otherwise, return true.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.107 -0500", hash_original_method = "5A692D7025642F2703B563EEC7270EF6", hash_generated_method = "E011B19A3542CE68D2FBEF3AAE19E48F")
        
public boolean isEnabled(int position) {
            final ListAdapter adapter = mListAdapter;
            if (adapter != null) {
                return adapter.isEnabled(position);
            } else {
                return true;
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.110 -0500", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "3610CA007643502BCB5C59065F70D2D6")
        
public int getItemViewType(int position) {
            return 0;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.112 -0500", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "2577B8C4DED14F5EF8C0214DED9A780B")
        
public int getViewTypeCount() {
            return 1;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.114 -0500", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "CD8A3F59B7B104167347DEF141D26EA8")
        
public boolean isEmpty() {
            return getCount() == 0;
        }
        
    }
    
    private class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.122 -0500", hash_original_field = "61F59CF4D78BDCFED50249BCBE572AFE", hash_generated_field = "8A66D18866E05C57D866195195114C43")

        private AlertDialog mPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.124 -0500", hash_original_field = "2CACD7266980B6DFC0CAE7F9BA8B8C48", hash_generated_field = "EBBA0833135A672B66F462D046DC0A24")

        private ListAdapter mListAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.127 -0500", hash_original_field = "81EB62D0EEAAEA0C154F7D9CCA67D1D6", hash_generated_field = "D9DA4C057AA02B144FF3C40EB2E94890")

        private CharSequence mPrompt;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_method = "CE7B674B2EA3FB97987A0C722722E738", hash_generated_method = "CE7B674B2EA3FB97987A0C722722E738")
        public DialogPopup ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.129 -0500", hash_original_method = "FC11027C394F91EA6C471943F011BB6E", hash_generated_method = "FB44024C47AFE3B15E046119E898AAF0")
        
public void dismiss() {
            mPopup.dismiss();
            mPopup = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.131 -0500", hash_original_method = "BD26E62421B18C78E84EB8F1A09EE4AA", hash_generated_method = "CD4DD9958A09B5EE16AB15E9AAF3347D")
        
public boolean isShowing() {
            return mPopup != null ? mPopup.isShowing() : false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.133 -0500", hash_original_method = "8403FBCA2C28723FD059691B00D88CE1", hash_generated_method = "FB46A4D60BCA34B418049BC3864C846B")
    @DSSafe(DSCat.SAFE_OTHERS)
public void setAdapter(ListAdapter adapter) {
            mListAdapter = adapter;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.135 -0500", hash_original_method = "9624F776B01A0F54225A1B393847DC0B", hash_generated_method = "94E11A15F9F0303F5F118981D9E970BA")
        
public void setPromptText(CharSequence hintText) {
            mPrompt = hintText;
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.137 -0500", hash_original_method = "2D362FF1EB68D3106D16676724B21A20", hash_generated_method = "ABF7BBA69C3858CDA612A3C2A354DA83")
        
public CharSequence getHintText() {
            return mPrompt;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.140 -0500", hash_original_method = "FCDD379DF322C9BE95870CB90106F42A", hash_generated_method = "510636E281AF47756916D21B74FFE065")
        
public void show() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            if (mPrompt != null) {
                builder.setTitle(mPrompt);
            }
            mPopup = builder.setSingleChoiceItems(mListAdapter,
                    getSelectedItemPosition(), this).show();
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.142 -0500", hash_original_method = "611F98047F020130E79D369CDAEB53F1", hash_generated_method = "29BB4B8794AAD089C07A4937CE90F0BE")
        
public void onClick(DialogInterface dialog, int which) {
            setSelection(which);
            dismiss();
        }
        
    }
    
    private class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.147 -0500", hash_original_field = "D9985579330390AE8290FE29DE0EF688", hash_generated_field = "1FDB4027FDC409C38C96D7C7129240A3")

        private CharSequence mHintText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.149 -0500", hash_original_field = "CBDD62EF585589E92C0E00AE9F4F22E2", hash_generated_field = "90F29768206AB431EA361CD94838716F")

        private ListAdapter mAdapter;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.155 -0500", hash_original_method = "9F2E5A3A347BB64B0E4347185558EFBB", hash_generated_method = "6A1EE1DE32C5237ACC26F3024F1C0F34")
        
public DropdownPopup(Context context, AttributeSet attrs, int defStyleRes) {
            super(context, attrs, 0, defStyleRes);

            setAnchorView(Spinner.this);
            setModal(true);
            setPromptPosition(POSITION_PROMPT_ABOVE);
            setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView parent, View v, int position, long id) {
                    Spinner.this.setSelection(position);
                    dismiss();
                }
            });
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.157 -0500", hash_original_method = "3FC404C9DE24A7B182849EFCFBFDCEFF", hash_generated_method = "8F7A85B96E0D8918BF13150F9EB14F1B")
        
@Override
        public void setAdapter(ListAdapter adapter) {
            super.setAdapter(adapter);
            mAdapter = adapter;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.160 -0500", hash_original_method = "708F2EB27A8EC2C1F7F8C9DF82B35D6E", hash_generated_method = "405D74EE7896C7D984D5B9BB270E8642")
        
public CharSequence getHintText() {
            return mHintText;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.162 -0500", hash_original_method = "5C072498C5CF07F19C35B82F77A3E1EC", hash_generated_method = "0B1B00BC95D2445E80A38945F44EF319")
        
public void setPromptText(CharSequence hintText) {
            // Hint text is ignored for dropdowns, but maintain it here.
            mHintText = hintText;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.165 -0500", hash_original_method = "831D1D82273C571177D94CDCC1E5A7C8", hash_generated_method = "C41F31F3D7A2C024ECC301E0413A7B9E")
        
@Override
        public void show() {
            final int spinnerPaddingLeft = Spinner.this.getPaddingLeft();
            if (mDropDownWidth == WRAP_CONTENT) {
                final int spinnerWidth = Spinner.this.getWidth();
                final int spinnerPaddingRight = Spinner.this.getPaddingRight();
                setContentWidth(Math.max(
                        measureContentWidth((SpinnerAdapter) mAdapter, getBackground()),
                        spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight));
            } else if (mDropDownWidth == MATCH_PARENT) {
                final int spinnerWidth = Spinner.this.getWidth();
                final int spinnerPaddingRight = Spinner.this.getPaddingRight();
                setContentWidth(spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight);
            } else {
                setContentWidth(mDropDownWidth);
            }
            final Drawable background = getBackground();
            int bgOffset = 0;
            if (background != null) {
                background.getPadding(mTempRect);
                bgOffset = -mTempRect.left;
            }
            setHorizontalOffset(bgOffset + spinnerPaddingLeft);
            setInputMethodMode(ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
            super.show();
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            setSelection(Spinner.this.getSelectedItemPosition());
        }
        
    }
    
    private interface SpinnerPopup {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void setAdapter(ListAdapter adapter);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void show();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void dismiss();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean isShowing();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void setPromptText(CharSequence hintText);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public CharSequence getHintText();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.067 -0500", hash_original_method = "21A8DBFD7E0EEAC4158875C988469F50", hash_generated_method = "1D6F32633F3775D14D8DA1877D92128C")
    
public void onClick(DialogInterface dialog, int which) {
        setSelection(which);
        dialog.dismiss();
    }

    /**
     * Sets the prompt to display when the dialog is shown.
     * @param prompt the prompt to set
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.069 -0500", hash_original_method = "82831FCEC8FF5E5499EA6A36B12A66DA", hash_generated_method = "DA3402CDD5C9B14C14A06E0299D74748")
    
public void setPrompt(CharSequence prompt) {
        mPopup.setPromptText(prompt);
    }

    /**
     * Sets the prompt to display when the dialog is shown.
     * @param promptId the resource ID of the prompt to display when the dialog is shown
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.071 -0500", hash_original_method = "21AEC72317B46CB2881CC90C11A2AA6E", hash_generated_method = "5286C94FB2EAD6E33D86CEEEEEAF9ED6")
    
public void setPromptId(int promptId) {
        setPrompt(getContext().getText(promptId));
    }

    /**
     * @return The prompt to display when the dialog is shown
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.073 -0500", hash_original_method = "07472705288FF1B8FBB0DCE1C944E4ED", hash_generated_method = "9ECC58AF25644B79F11D7F0915DCDF0D")
    
public CharSequence getPrompt() {
        return mPopup.getHintText();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.076 -0500", hash_original_method = "EB37E42D6ACA63E84337B27962C39033", hash_generated_method = "5D4F9D30A18F3DF5C0F75DDD5FD04597")
    
int measureContentWidth(SpinnerAdapter adapter, Drawable background) {
        if (adapter == null) {
            return 0;
        }

        int width = 0;
        View itemView = null;
        int itemType = 0;
        final int widthMeasureSpec =
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int heightMeasureSpec =
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);

        // Make sure the number of items we'll measure is capped. If it's a huge data set
        // with wildly varying sizes, oh well.
        int start = Math.max(0, getSelectedItemPosition());
        final int end = Math.min(adapter.getCount(), start + MAX_ITEMS_MEASURED);
        final int count = end - start;
        start = Math.max(0, start - (MAX_ITEMS_MEASURED - count));
        for (int i = start; i < end; i++) {
            final int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            itemView = adapter.getView(i, itemView, this);
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }

        // Add background padding to measured width
        if (background != null) {
            background.getPadding(mTempRect);
            width += mTempRect.left + mTempRect.right;
        }

        return width;
    }
}

