package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.annotation.Widget;
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
    private static final String TAG = "Spinner";
    private static final int MAX_ITEMS_MEASURED = 15;
    public static final int MODE_DIALOG = 0;
    public static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private SpinnerPopup mPopup;
    private DropDownAdapter mTempAdapter;
    int mDropDownWidth;
    private int mGravity;
    private boolean mDisableChildrenWhenDisabled;
    private Rect mTempRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.409 -0400", hash_original_method = "B5C06F1AC4F38C2FF014EC091685338D", hash_generated_method = "3E498A6A58777E153D9DB18495A1A5C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Spinner(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.410 -0400", hash_original_method = "6645D47A83FEF1D160E35889A652939D", hash_generated_method = "CF83227A4622962283AF9F159FEF39B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Spinner(Context context, int mode) {
        this(context, null, com.android.internal.R.attr.spinnerStyle, mode);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.410 -0400", hash_original_method = "B198D16CD1474762E3B97C016462CA6F", hash_generated_method = "4D1426DD47ECBC515CCAB34BAA044641")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Spinner(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.spinnerStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.410 -0400", hash_original_method = "78C6FE6C5EEF3610339F87F7F649A015", hash_generated_method = "3AAAA99D866079972576F359FFB7F689")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Spinner(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, MODE_THEME);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.410 -0400", hash_original_method = "290E4CD98FA983594AD8D129D824FCAE", hash_generated_method = "F4C47E8290D958542390D84CE38B1ACF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Spinner(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(mode);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Spinner, defStyle, 0);
        {
            mode = a.getInt(com.android.internal.R.styleable.Spinner_spinnerMode, MODE_DIALOG);
        } //End block
        //Begin case MODE_DIALOG 
        {
            mPopup = new DialogPopup();
        } //End block
        //End case MODE_DIALOG 
        //Begin case MODE_DROPDOWN 
        {
            DropdownPopup popup;
            popup = new DropdownPopup(context, attrs, defStyle);
            mDropDownWidth = a.getLayoutDimension(
                    com.android.internal.R.styleable.Spinner_dropDownWidth,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            popup.setBackgroundDrawable(a.getDrawable(
                    com.android.internal.R.styleable.Spinner_popupBackground));
            final int verticalOffset;
            verticalOffset = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.Spinner_dropDownVerticalOffset, 0);
            {
                popup.setVerticalOffset(verticalOffset);
            } //End block
            final int horizontalOffset;
            horizontalOffset = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.Spinner_dropDownHorizontalOffset, 0);
            {
                popup.setHorizontalOffset(horizontalOffset);
            } //End block
            mPopup = popup;
        } //End block
        //End case MODE_DROPDOWN 
        mGravity = a.getInt(com.android.internal.R.styleable.Spinner_gravity, Gravity.CENTER);
        mPopup.setPromptText(a.getString(com.android.internal.R.styleable.Spinner_prompt));
        mDisableChildrenWhenDisabled = a.getBoolean(
                com.android.internal.R.styleable.Spinner_disableChildrenWhenDisabled, false);
        a.recycle();
        {
            mPopup.setAdapter(mTempAdapter);
            mTempAdapter = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.410 -0400", hash_original_method = "E89DC933CAA3948ECC7191CDEBCA4F7F", hash_generated_method = "67F1BFDD8B67424C61E7B28E91EE4925")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        super.setEnabled(enabled);
        {
            final int count;
            count = getChildCount();
            {
                int i;
                i = 0;
                {
                    getChildAt(i).setEnabled(enabled);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //super.setEnabled(enabled);
        //if (mDisableChildrenWhenDisabled) {
            //final int count = getChildCount();
            //for (int i = 0; i < count; i++) {
                //getChildAt(i).setEnabled(enabled);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.410 -0400", hash_original_method = "2D67806CEC3CAAEAC987F460E7189BA9", hash_generated_method = "EAD3CEF5CEDF5EF6C3D0D7773C412A6D")
    @DSModeled(DSC.SAFE)
    public void setGravity(int gravity) {
        dsTaint.addTaint(gravity);
        {
            {
                gravity |= Gravity.LEFT;
            } //End block
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mGravity != gravity) {
            //if ((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == 0) {
                //gravity |= Gravity.LEFT;
            //}
            //mGravity = gravity;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.410 -0400", hash_original_method = "60241601236C86A9296272064A15234D", hash_generated_method = "1EC9534E34DF3345B4E150266CDCBD72")
    @DSModeled(DSC.SAFE)
    @Override
    public void setAdapter(SpinnerAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        super.setAdapter(adapter);
        {
            mPopup.setAdapter(new DropDownAdapter(adapter));
        } //End block
        {
            mTempAdapter = new DropDownAdapter(adapter);
        } //End block
        // ---------- Original Method ----------
        //super.setAdapter(adapter);
        //if (mPopup != null) {
            //mPopup.setAdapter(new DropDownAdapter(adapter));
        //} else {
            //mTempAdapter = new DropDownAdapter(adapter);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.411 -0400", hash_original_method = "50D7CC7A93B993E2A6FF522D575BAEB5", hash_generated_method = "564DB6757C0CD179C5D53E1A6374D5E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getBaseline() {
        View child;
        child = null;
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1773132994 = (getChildCount() > 0);
            {
                child = getChildAt(0);
            } //End block
            {
                boolean var64E96C628F62864AA686A96BEDED1403_167181843 = (mAdapter != null && mAdapter.getCount() > 0);
                {
                    child = makeAndAddView(0);
                    mRecycler.put(0, child);
                    removeAllViewsInLayout();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            final int childBaseline;
            childBaseline = child.getBaseline();
            {
                Object var54BA034BC30EE04F32CE30794275A01A_958307518 = (child.getTop() + childBaseline);
            } //End flattened ternary
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //View child = null;
        //if (getChildCount() > 0) {
            //child = getChildAt(0);
        //} else if (mAdapter != null && mAdapter.getCount() > 0) {
            //child = makeAndAddView(0);
            //mRecycler.put(0, child);
            //removeAllViewsInLayout();
        //}
        //if (child != null) {
            //final int childBaseline = child.getBaseline();
            //return childBaseline >= 0 ? child.getTop() + childBaseline : -1;
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.411 -0400", hash_original_method = "B6F13EE08FDC85FB02DBBB6CA125C601", hash_generated_method = "175A9255341F721BC46A416F2DD0A3E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        {
            boolean varD929D8531D595F5EA0B4A8A252DF969D_2046444717 = (mPopup != null && mPopup.isShowing());
            {
                mPopup.dismiss();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //if (mPopup != null && mPopup.isShowing()) {
            //mPopup.dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.411 -0400", hash_original_method = "AE9F9278138E36A1F7A0C4102CD0DE5F", hash_generated_method = "7B9A278497DD9F529B2297EBED8B7F91")
    @DSModeled(DSC.SAFE)
    @Override
    public void setOnItemClickListener(OnItemClickListener l) {
        dsTaint.addTaint(l.dsTaint);
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
        // ---------- Original Method ----------
        //throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.411 -0400", hash_original_method = "EC8AF316641014792672178145DBD315", hash_generated_method = "32706211A2CD986D338163B9D548BB55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        {
            boolean var5BB94CDAE497737B2AF326771BF24CAC_1225628013 = (mPopup != null && MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST);
            {
                final int measuredWidth;
                measuredWidth = getMeasuredWidth();
                setMeasuredDimension(Math.min(Math.max(measuredWidth,
                    measureContentWidth(getAdapter(), getBackground())),
                    MeasureSpec.getSize(widthMeasureSpec)),
                    getMeasuredHeight());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //if (mPopup != null && MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST) {
            //final int measuredWidth = getMeasuredWidth();
            //setMeasuredDimension(Math.min(Math.max(measuredWidth,
                    //measureContentWidth(getAdapter(), getBackground())),
                    //MeasureSpec.getSize(widthMeasureSpec)),
                    //getMeasuredHeight());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.411 -0400", hash_original_method = "2F25E46AB3A307ED9F0C91E6C81BDCD4", hash_generated_method = "214D3B56166FBE5E9ABEBC0973896F5E")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        dsTaint.addTaint(changed);
        super.onLayout(changed, l, t, r, b);
        mInLayout = true;
        layout(0, false);
        mInLayout = false;
        // ---------- Original Method ----------
        //super.onLayout(changed, l, t, r, b);
        //mInLayout = true;
        //layout(0, false);
        //mInLayout = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.411 -0400", hash_original_method = "26F25590D97768D2F385154C131B8E76", hash_generated_method = "7A08AD4F906C9C8E91AB71CCECA9EFA4")
    @DSModeled(DSC.SAFE)
    @Override
     void layout(int delta, boolean animate) {
        dsTaint.addTaint(animate);
        dsTaint.addTaint(delta);
        int childrenLeft;
        childrenLeft = mSpinnerPadding.left;
        int childrenWidth;
        childrenWidth = mRight - mLeft - mSpinnerPadding.left - mSpinnerPadding.right;
        {
            handleDataChanged();
        } //End block
        {
            resetList();
        } //End block
        {
            setSelectedPositionInt(mNextSelectedPosition);
        } //End block
        recycleAllViews();
        removeAllViewsInLayout();
        mFirstPosition = mSelectedPosition;
        View sel;
        sel = makeAndAddView(mSelectedPosition);
        int width;
        width = sel.getMeasuredWidth();
        int selectedOffset;
        selectedOffset = childrenLeft;
        //Begin case Gravity.CENTER_HORIZONTAL 
        selectedOffset = childrenLeft + (childrenWidth / 2) - (width / 2);
        //End case Gravity.CENTER_HORIZONTAL 
        //Begin case Gravity.RIGHT 
        selectedOffset = childrenLeft + childrenWidth - width;
        //End case Gravity.RIGHT 
        sel.offsetLeftAndRight(selectedOffset);
        mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        mDataChanged = false;
        mNeedSync = false;
        setNextSelectedPositionInt(mSelectedPosition);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.412 -0400", hash_original_method = "16A0D15DF35F8329F5BE73262CE9B509", hash_generated_method = "883C5E85F041760686E08F0C2F955BF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View makeAndAddView(int position) {
        dsTaint.addTaint(position);
        View child;
        {
            child = mRecycler.get(position);
            {
                setUpChild(child);
            } //End block
        } //End block
        child = mAdapter.getView(position, null, this);
        setUpChild(child);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //View child;
        //if (!mDataChanged) {
            //child = mRecycler.get(position);
            //if (child != null) {
                //setUpChild(child);
                //return child;
            //}
        //}
        //child = mAdapter.getView(position, null, this);
        //setUpChild(child);
        //return child;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.412 -0400", hash_original_method = "EA422D8BE64CA8F3FB87FB3D4E23C7FB", hash_generated_method = "36FD351F4CC41457A23FC0188E85BAD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setUpChild(View child) {
        dsTaint.addTaint(child.dsTaint);
        ViewGroup.LayoutParams lp;
        lp = child.getLayoutParams();
        {
            lp = generateDefaultLayoutParams();
        } //End block
        addViewInLayout(child, 0, lp);
        child.setSelected(hasFocus());
        {
            child.setEnabled(isEnabled());
        } //End block
        int childHeightSpec;
        childHeightSpec = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec,
                mSpinnerPadding.top + mSpinnerPadding.bottom, lp.height);
        int childWidthSpec;
        childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mSpinnerPadding.left + mSpinnerPadding.right, lp.width);
        child.measure(childWidthSpec, childHeightSpec);
        int childLeft;
        int childRight;
        int childTop;
        childTop = mSpinnerPadding.top
                + ((getMeasuredHeight() - mSpinnerPadding.bottom -
                        mSpinnerPadding.top - child.getMeasuredHeight()) / 2);
        int childBottom;
        childBottom = childTop + child.getMeasuredHeight();
        int width;
        width = child.getMeasuredWidth();
        childLeft = 0;
        childRight = childLeft + width;
        child.layout(childLeft, childTop, childRight, childBottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.412 -0400", hash_original_method = "DE0583C7611D1F2BE10915793A501A4C", hash_generated_method = "AC7D7272610BC71015B8C7E85DD3BD13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performClick() {
        boolean handled;
        handled = super.performClick();
        {
            handled = true;
            {
                boolean varE54135B8CA552C10B65F25C1BE9A982D_930447615 = (!mPopup.isShowing());
                {
                    mPopup.show();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean handled = super.performClick();
        //if (!handled) {
            //handled = true;
            //if (!mPopup.isShowing()) {
                //mPopup.show();
            //}
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.412 -0400", hash_original_method = "21A8DBFD7E0EEAC4158875C988469F50", hash_generated_method = "F94E8F5BB542D775582BC6F1B15B861C")
    @DSModeled(DSC.SAFE)
    public void onClick(DialogInterface dialog, int which) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(which);
        dsTaint.addTaint(dialog.dsTaint);
        setSelection(which);
        dialog.dismiss();
        // ---------- Original Method ----------
        //setSelection(which);
        //dialog.dismiss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.412 -0400", hash_original_method = "82831FCEC8FF5E5499EA6A36B12A66DA", hash_generated_method = "460DB4AE7C51DF236BF2D9E6C78E30B9")
    @DSModeled(DSC.SAFE)
    public void setPrompt(CharSequence prompt) {
        dsTaint.addTaint(prompt);
        mPopup.setPromptText(prompt);
        // ---------- Original Method ----------
        //mPopup.setPromptText(prompt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.412 -0400", hash_original_method = "21AEC72317B46CB2881CC90C11A2AA6E", hash_generated_method = "67D7600FC78A278A2C8F5C2F5F8AEDC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPromptId(int promptId) {
        dsTaint.addTaint(promptId);
        setPrompt(getContext().getText(promptId));
        // ---------- Original Method ----------
        //setPrompt(getContext().getText(promptId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.412 -0400", hash_original_method = "07472705288FF1B8FBB0DCE1C944E4ED", hash_generated_method = "D986A634E67DBA4CE1FD2A5C9826610A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getPrompt() {
        CharSequence varEAD4D3246139A44C91868D145211BCE9_1636986135 = (mPopup.getHintText());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPopup.getHintText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "EB37E42D6ACA63E84337B27962C39033", hash_generated_method = "5AA571DF8AE4DBBC96B56F99CB529E3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int measureContentWidth(SpinnerAdapter adapter, Drawable background) {
        dsTaint.addTaint(background.dsTaint);
        dsTaint.addTaint(adapter.dsTaint);
        int width;
        width = 0;
        View itemView;
        itemView = null;
        int itemType;
        itemType = 0;
        final int widthMeasureSpec;
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int heightMeasureSpec;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int start;
        start = Math.max(0, getSelectedItemPosition());
        final int end;
        end = Math.min(adapter.getCount(), start + MAX_ITEMS_MEASURED);
        final int count;
        count = end - start;
        start = Math.max(0, start - (MAX_ITEMS_MEASURED - count));
        {
            int i;
            i = start;
            {
                final int positionType;
                positionType = adapter.getItemViewType(i);
                {
                    itemType = positionType;
                    itemView = null;
                } //End block
                itemView = adapter.getView(i, itemView, this);
                {
                    boolean var4600A482EC7CE1FD745D42F74A7EF908_2127686795 = (itemView.getLayoutParams() == null);
                    {
                        itemView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                    } //End block
                } //End collapsed parenthetic
                itemView.measure(widthMeasureSpec, heightMeasureSpec);
                width = Math.max(width, itemView.getMeasuredWidth());
            } //End block
        } //End collapsed parenthetic
        {
            background.getPadding(mTempRect);
            width += mTempRect.left + mTempRect.right;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "FD9BEBCCABA72AC6ECD15A9F9D903ED1", hash_generated_method = "0DBAA865ED638845389B75B24B5ED175")
        @DSModeled(DSC.SAFE)
        public DropDownAdapter(SpinnerAdapter adapter) {
            dsTaint.addTaint(adapter.dsTaint);
            {
                this.mListAdapter = (ListAdapter) adapter;
            } //End block
            // ---------- Original Method ----------
            //this.mAdapter = adapter;
            //if (adapter instanceof ListAdapter) {
                //this.mListAdapter = (ListAdapter) adapter;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "7176E9532C0349D7016ABE3301806E2C", hash_generated_method = "BBBB71B56AA7E8A357CB7099A65AA88B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getCount() {
            {
                Object var067BB5993A461EDA4265964116724952_1445216097 = (mAdapter.getCount());
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mAdapter == null ? 0 : mAdapter.getCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "E5529375AE985E64AC9FCAEB196D1278", hash_generated_method = "AEE4AF13C3A8B7045E17A138A69ADFC6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object getItem(int position) {
            dsTaint.addTaint(position);
            {
                Object varD6C17F5D90F3D0E14A22AD816012CC23_1707677939 = (mAdapter.getItem(position));
            } //End flattened ternary
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mAdapter == null ? null : mAdapter.getItem(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "516B3E26F5C00C4BD8BAF28DFF38500C", hash_generated_method = "EE974D4D9095C418A4B92B4C45FCC842")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long getItemId(int position) {
            dsTaint.addTaint(position);
            {
                Object varE791D48808E44BBA8A766C8461C5A401_1911925583 = (mAdapter.getItemId(position));
            } //End flattened ternary
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return mAdapter == null ? -1 : mAdapter.getItemId(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "A9F8983A232A0A246637701F010ACE34", hash_generated_method = "DDEB4AF0276DE672BEB77B8F753F52E9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public View getView(int position, View convertView, ViewGroup parent) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(convertView.dsTaint);
            View var9569788A51D97012602F9405CA6C1E64_333212527 = (getDropDownView(position, convertView, parent));
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getDropDownView(position, convertView, parent);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "F097CA4C24B6E5261C3C9C12681A60CA", hash_generated_method = "15C9AF78B670700BD830DC05A9A1CECF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(convertView.dsTaint);
            {
                Object var87A92028A393B35FD309D903B514C2D4_1429488383 = (mAdapter.getDropDownView(position, convertView, parent));
            } //End flattened ternary
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mAdapter == null ? null :
                    //mAdapter.getDropDownView(position, convertView, parent);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "EE546908428E55FCCB0B2F98C659D31B", hash_generated_method = "9D35314A1F208BCAEEC0090DE484BA75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasStableIds() {
            boolean var92A5B2B773F784D23AACADEC549061AE_801886399 = (mAdapter != null && mAdapter.hasStableIds());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mAdapter != null && mAdapter.hasStableIds();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "78D22EFC6DC87FE4BB21D4B0F978C6D3")
        @DSModeled(DSC.SAFE)
        public void registerDataSetObserver(DataSetObserver observer) {
            //DSFIXME: CODE0010: Possible callback registration function detected
            dsTaint.addTaint(observer.dsTaint);
            {
                mAdapter.registerDataSetObserver(observer);
            } //End block
            // ---------- Original Method ----------
            //if (mAdapter != null) {
                //mAdapter.registerDataSetObserver(observer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "3568947F1F8E1444315710336BCE09B1")
        @DSModeled(DSC.SAFE)
        public void unregisterDataSetObserver(DataSetObserver observer) {
            //DSFIXME: CODE0010: Possible callback registration function detected
            dsTaint.addTaint(observer.dsTaint);
            {
                mAdapter.unregisterDataSetObserver(observer);
            } //End block
            // ---------- Original Method ----------
            //if (mAdapter != null) {
                //mAdapter.unregisterDataSetObserver(observer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "C6F9771E1B3DE27F3DC1DA3F2DDBE42B", hash_generated_method = "0CA03BA1869CD166DDE3F670B7E27CED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean areAllItemsEnabled() {
            final ListAdapter adapter;
            adapter = mListAdapter;
            {
                boolean var985642AB936091C75C15CA5EE89CD4ED_1885914719 = (adapter.areAllItemsEnabled());
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //final ListAdapter adapter = mListAdapter;
            //if (adapter != null) {
                //return adapter.areAllItemsEnabled();
            //} else {
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.413 -0400", hash_original_method = "5A692D7025642F2703B563EEC7270EF6", hash_generated_method = "1D449153A9AE9F9DEEFC7E3E6E10AACF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isEnabled(int position) {
            dsTaint.addTaint(position);
            final ListAdapter adapter;
            adapter = mListAdapter;
            {
                boolean var1B060CF70AEECE4FB915FA202647B0B7_861089935 = (adapter.isEnabled(position));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //final ListAdapter adapter = mListAdapter;
            //if (adapter != null) {
                //return adapter.isEnabled(position);
            //} else {
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "B1EE40DAC12DCAF860DB008F9464A426")
        @DSModeled(DSC.SAFE)
        public int getItemViewType(int position) {
            dsTaint.addTaint(position);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "62D482665DDDE1A9270E005B7B346B4A")
        @DSModeled(DSC.SAFE)
        public int getViewTypeCount() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "8FCBCEDE5A5EE10F2504BFC728C737D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isEmpty() {
            boolean var1E308F1B2924DF35832B0C6653D5399D_65998277 = (getCount() == 0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getCount() == 0;
        }

        
    }


    
    private class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private AlertDialog mPopup;
        private ListAdapter mListAdapter;
        private CharSequence mPrompt;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "FC11027C394F91EA6C471943F011BB6E", hash_generated_method = "2E4305A6C0782377A4B11EF941C9FF3A")
        @DSModeled(DSC.SAFE)
        public void dismiss() {
            mPopup.dismiss();
            mPopup = null;
            // ---------- Original Method ----------
            //mPopup.dismiss();
            //mPopup = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "BD26E62421B18C78E84EB8F1A09EE4AA", hash_generated_method = "C0A5E719555DD65AA91CF0E016DC9205")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isShowing() {
            {
                Object var064AFD47A2F0375BD3A49E11623DCB44_1176590509 = (mPopup.isShowing());
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mPopup != null ? mPopup.isShowing() : false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "8403FBCA2C28723FD059691B00D88CE1", hash_generated_method = "FA4B635063AA0A7988FC76BD6822D305")
        @DSModeled(DSC.SAFE)
        public void setAdapter(ListAdapter adapter) {
            dsTaint.addTaint(adapter.dsTaint);
            // ---------- Original Method ----------
            //mListAdapter = adapter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "9624F776B01A0F54225A1B393847DC0B", hash_generated_method = "39123C3E3BD03B8730743ACE47331EED")
        @DSModeled(DSC.SAFE)
        public void setPromptText(CharSequence hintText) {
            dsTaint.addTaint(hintText);
            // ---------- Original Method ----------
            //mPrompt = hintText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "2D362FF1EB68D3106D16676724B21A20", hash_generated_method = "F2C36EE458E238271E47C59757D70BC0")
        @DSModeled(DSC.SAFE)
        public CharSequence getHintText() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mPrompt;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "FCDD379DF322C9BE95870CB90106F42A", hash_generated_method = "36735B36E6ADEB932B51AAE735681391")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void show() {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(getContext());
            {
                builder.setTitle(mPrompt);
            } //End block
            mPopup = builder.setSingleChoiceItems(mListAdapter,
                    getSelectedItemPosition(), this).show();
            // ---------- Original Method ----------
            //AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            //if (mPrompt != null) {
                //builder.setTitle(mPrompt);
            //}
            //mPopup = builder.setSingleChoiceItems(mListAdapter,
                    //getSelectedItemPosition(), this).show();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "611F98047F020130E79D369CDAEB53F1", hash_generated_method = "A70109F89D7DC1802BD63BB1EB54E4C7")
        @DSModeled(DSC.SAFE)
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(which);
            dsTaint.addTaint(dialog.dsTaint);
            setSelection(which);
            dismiss();
            // ---------- Original Method ----------
            //setSelection(which);
            //dismiss();
        }

        
    }


    
    private class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        private CharSequence mHintText;
        private ListAdapter mAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "9F2E5A3A347BB64B0E4347185558EFBB", hash_generated_method = "D770B716D808664228315AE85329BAF5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DropdownPopup(Context context, AttributeSet attrs, int defStyleRes) {
            super(context, attrs, 0, defStyleRes);
            dsTaint.addTaint(defStyleRes);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            setAnchorView(Spinner.this);
            setModal(true);
            setPromptPosition(POSITION_PROMPT_ABOVE);
            setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView parent, View v, int position, long id) {
                    Spinner.this.setSelection(position);
                    dismiss();
                }
            });
            // ---------- Original Method ----------
            //setAnchorView(Spinner.this);
            //setModal(true);
            //setPromptPosition(POSITION_PROMPT_ABOVE);
            //setOnItemClickListener(new OnItemClickListener() {
                //public void onItemClick(AdapterView parent, View v, int position, long id) {
                    //Spinner.this.setSelection(position);
                    //dismiss();
                //}
            //});
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "3FC404C9DE24A7B182849EFCFBFDCEFF", hash_generated_method = "B8E90B7CC766A4D34760AF2889226231")
        @DSModeled(DSC.SAFE)
        @Override
        public void setAdapter(ListAdapter adapter) {
            dsTaint.addTaint(adapter.dsTaint);
            super.setAdapter(adapter);
            // ---------- Original Method ----------
            //super.setAdapter(adapter);
            //mAdapter = adapter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "708F2EB27A8EC2C1F7F8C9DF82B35D6E", hash_generated_method = "3841667247E77961E28F5CD1475EB6A5")
        @DSModeled(DSC.SAFE)
        public CharSequence getHintText() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mHintText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.414 -0400", hash_original_method = "5C072498C5CF07F19C35B82F77A3E1EC", hash_generated_method = "0543464D0E634E5F93C5A9485C16967E")
        @DSModeled(DSC.SAFE)
        public void setPromptText(CharSequence hintText) {
            dsTaint.addTaint(hintText);
            // ---------- Original Method ----------
            //mHintText = hintText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.415 -0400", hash_original_method = "831D1D82273C571177D94CDCC1E5A7C8", hash_generated_method = "24D9D82FC94CD47EC83428842E79D4B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void show() {
            final int spinnerPaddingLeft;
            spinnerPaddingLeft = Spinner.this.getPaddingLeft();
            {
                final int spinnerWidth;
                spinnerWidth = Spinner.this.getWidth();
                final int spinnerPaddingRight;
                spinnerPaddingRight = Spinner.this.getPaddingRight();
                setContentWidth(Math.max(
                        measureContentWidth((SpinnerAdapter) mAdapter, getBackground()),
                        spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight));
            } //End block
            {
                final int spinnerWidth;
                spinnerWidth = Spinner.this.getWidth();
                final int spinnerPaddingRight;
                spinnerPaddingRight = Spinner.this.getPaddingRight();
                setContentWidth(spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight);
            } //End block
            {
                setContentWidth(mDropDownWidth);
            } //End block
            final Drawable background;
            background = getBackground();
            int bgOffset;
            bgOffset = 0;
            {
                background.getPadding(mTempRect);
                bgOffset = -mTempRect.left;
            } //End block
            setHorizontalOffset(bgOffset + spinnerPaddingLeft);
            setInputMethodMode(ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
            super.show();
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            setSelection(Spinner.this.getSelectedItemPosition());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private interface SpinnerPopup {
        public void setAdapter(ListAdapter adapter);
        
        
        public void show();
        
        
        public void dismiss();
        
        
        public boolean isShowing();
        
        
        public void setPromptText(CharSequence hintText);
        public CharSequence getHintText();
    }
    
}


