package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private SpinnerPopup mPopup;
    private DropDownAdapter mTempAdapter;
    int mDropDownWidth;
    private int mGravity;
    private boolean mDisableChildrenWhenDisabled;
    private Rect mTempRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.600 -0400", hash_original_method = "B5C06F1AC4F38C2FF014EC091685338D", hash_generated_method = "5DFB1D7C46C5F546DD8CCDC0A73D7EEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Spinner(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.600 -0400", hash_original_method = "6645D47A83FEF1D160E35889A652939D", hash_generated_method = "22F07A2F7A1904B80028F63929DA5B69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Spinner(Context context, int mode) {
        this(context, null, com.android.internal.R.attr.spinnerStyle, mode);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.601 -0400", hash_original_method = "B198D16CD1474762E3B97C016462CA6F", hash_generated_method = "6928B6CEFE2EDAB0D389719EFEC46078")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Spinner(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.spinnerStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.601 -0400", hash_original_method = "78C6FE6C5EEF3610339F87F7F649A015", hash_generated_method = "2EC0220BA79B942328E3470B1881116B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Spinner(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, MODE_THEME);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.601 -0400", hash_original_method = "290E4CD98FA983594AD8D129D824FCAE", hash_generated_method = "64F4D3DBA06C61B15DC8F7AD8A6D1FBA")
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
            int verticalOffset;
            verticalOffset = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.Spinner_dropDownVerticalOffset, 0);
            {
                popup.setVerticalOffset(verticalOffset);
            } //End block
            int horizontalOffset;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.602 -0400", hash_original_method = "E89DC933CAA3948ECC7191CDEBCA4F7F", hash_generated_method = "C43BF69E7B5F55E36D95526F9BA19F79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        super.setEnabled(enabled);
        {
            int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.602 -0400", hash_original_method = "2D67806CEC3CAAEAC987F460E7189BA9", hash_generated_method = "14FAD25C8AD96C2871908FD577039DF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.602 -0400", hash_original_method = "60241601236C86A9296272064A15234D", hash_generated_method = "2163314AAB251367EA3BC9A218DBD7A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.603 -0400", hash_original_method = "50D7CC7A93B993E2A6FF522D575BAEB5", hash_generated_method = "CBD44F727BC2E07D41F495DFB3462054")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getBaseline() {
        View child;
        child = null;
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1271897132 = (getChildCount() > 0);
            {
                child = getChildAt(0);
            } //End block
            {
                boolean var64E96C628F62864AA686A96BEDED1403_519158168 = (mAdapter != null && mAdapter.getCount() > 0);
                {
                    child = makeAndAddView(0);
                    mRecycler.put(0, child);
                    removeAllViewsInLayout();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            int childBaseline;
            childBaseline = child.getBaseline();
            {
                Object var54BA034BC30EE04F32CE30794275A01A_1561708128 = (child.getTop() + childBaseline);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.603 -0400", hash_original_method = "B6F13EE08FDC85FB02DBBB6CA125C601", hash_generated_method = "502444686B3F974FA99D9BF453ED3A7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        {
            boolean varD929D8531D595F5EA0B4A8A252DF969D_1220907523 = (mPopup != null && mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.603 -0400", hash_original_method = "AE9F9278138E36A1F7A0C4102CD0DE5F", hash_generated_method = "1845199B2C20DAF84978A647D0C64BBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setOnItemClickListener(OnItemClickListener l) {
        dsTaint.addTaint(l.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
        // ---------- Original Method ----------
        //throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.603 -0400", hash_original_method = "EC8AF316641014792672178145DBD315", hash_generated_method = "38040E8191C5C48536A48DD278924709")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        {
            boolean var5BB94CDAE497737B2AF326771BF24CAC_492433915 = (mPopup != null && MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST);
            {
                int measuredWidth;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.604 -0400", hash_original_method = "2F25E46AB3A307ED9F0C91E6C81BDCD4", hash_generated_method = "B4289DFEB84AA82DA645268BF74433BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.604 -0400", hash_original_method = "26F25590D97768D2F385154C131B8E76", hash_generated_method = "EB7BF0D3A264E8D868DF30EF69CD0FAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.604 -0400", hash_original_method = "16A0D15DF35F8329F5BE73262CE9B509", hash_generated_method = "20031CFDE4C8B94FB95D65AA58E1861D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.605 -0400", hash_original_method = "EA422D8BE64CA8F3FB87FB3D4E23C7FB", hash_generated_method = "1E080BCD5D1CB60F9CABD015697DAACE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.605 -0400", hash_original_method = "DE0583C7611D1F2BE10915793A501A4C", hash_generated_method = "B6F507C5211C1AA1856545C6C3B5B285")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performClick() {
        boolean handled;
        handled = super.performClick();
        {
            handled = true;
            {
                boolean varE54135B8CA552C10B65F25C1BE9A982D_1326043200 = (!mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.605 -0400", hash_original_method = "21A8DBFD7E0EEAC4158875C988469F50", hash_generated_method = "D201D46B69483327B28A8DCDC9F80860")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.606 -0400", hash_original_method = "82831FCEC8FF5E5499EA6A36B12A66DA", hash_generated_method = "5C47C82049F2723ED30595E9C7390A42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPrompt(CharSequence prompt) {
        dsTaint.addTaint(prompt);
        mPopup.setPromptText(prompt);
        // ---------- Original Method ----------
        //mPopup.setPromptText(prompt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.606 -0400", hash_original_method = "21AEC72317B46CB2881CC90C11A2AA6E", hash_generated_method = "5612ECE5BB42DA97A73B5E563418C617")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPromptId(int promptId) {
        dsTaint.addTaint(promptId);
        setPrompt(getContext().getText(promptId));
        // ---------- Original Method ----------
        //setPrompt(getContext().getText(promptId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.606 -0400", hash_original_method = "07472705288FF1B8FBB0DCE1C944E4ED", hash_generated_method = "A907827813D4F05CAA152B8E8A41B2BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getPrompt() {
        CharSequence varEAD4D3246139A44C91868D145211BCE9_1232593543 = (mPopup.getHintText());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPopup.getHintText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.607 -0400", hash_original_method = "EB37E42D6ACA63E84337B27962C39033", hash_generated_method = "33774B9A1E3951C938C8A49D01473A31")
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
        int widthMeasureSpec;
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int heightMeasureSpec;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int start;
        start = Math.max(0, getSelectedItemPosition());
        int end;
        end = Math.min(adapter.getCount(), start + MAX_ITEMS_MEASURED);
        int count;
        count = end - start;
        start = Math.max(0, start - (MAX_ITEMS_MEASURED - count));
        {
            int i;
            i = start;
            {
                int positionType;
                positionType = adapter.getItemViewType(i);
                {
                    itemType = positionType;
                    itemView = null;
                } //End block
                itemView = adapter.getView(i, itemView, this);
                {
                    boolean var4600A482EC7CE1FD745D42F74A7EF908_775018645 = (itemView.getLayoutParams() == null);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.607 -0400", hash_original_method = "FD9BEBCCABA72AC6ECD15A9F9D903ED1", hash_generated_method = "FFDD1ACE6AE9BE0569AC3490B60BAA11")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.607 -0400", hash_original_method = "7176E9532C0349D7016ABE3301806E2C", hash_generated_method = "BA2DA3F53AA277A2D91A2C82938603D7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getCount() {
            {
                Object var067BB5993A461EDA4265964116724952_1140132138 = (mAdapter.getCount());
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mAdapter == null ? 0 : mAdapter.getCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.608 -0400", hash_original_method = "E5529375AE985E64AC9FCAEB196D1278", hash_generated_method = "D62932E108AE15B61DE4A30286800F4F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object getItem(int position) {
            dsTaint.addTaint(position);
            {
                Object varD6C17F5D90F3D0E14A22AD816012CC23_913384152 = (mAdapter.getItem(position));
            } //End flattened ternary
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mAdapter == null ? null : mAdapter.getItem(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.608 -0400", hash_original_method = "516B3E26F5C00C4BD8BAF28DFF38500C", hash_generated_method = "1BF4D3DD39B204BE202A99923D5DD870")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long getItemId(int position) {
            dsTaint.addTaint(position);
            {
                Object varE791D48808E44BBA8A766C8461C5A401_890176328 = (mAdapter.getItemId(position));
            } //End flattened ternary
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return mAdapter == null ? -1 : mAdapter.getItemId(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.608 -0400", hash_original_method = "A9F8983A232A0A246637701F010ACE34", hash_generated_method = "C2D57C546BA602E0555BB8725659EACB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public View getView(int position, View convertView, ViewGroup parent) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(convertView.dsTaint);
            View var9569788A51D97012602F9405CA6C1E64_1400977727 = (getDropDownView(position, convertView, parent));
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getDropDownView(position, convertView, parent);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.608 -0400", hash_original_method = "F097CA4C24B6E5261C3C9C12681A60CA", hash_generated_method = "BDB9CCCDE42A625883D7CAACCA1E1577")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(convertView.dsTaint);
            {
                Object var87A92028A393B35FD309D903B514C2D4_340289199 = (mAdapter.getDropDownView(position, convertView, parent));
            } //End flattened ternary
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mAdapter == null ? null :
                    //mAdapter.getDropDownView(position, convertView, parent);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.609 -0400", hash_original_method = "EE546908428E55FCCB0B2F98C659D31B", hash_generated_method = "CF185C85B94359988ABC4FB9EBF8A07D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasStableIds() {
            boolean var92A5B2B773F784D23AACADEC549061AE_1737457364 = (mAdapter != null && mAdapter.hasStableIds());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mAdapter != null && mAdapter.hasStableIds();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.609 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "66B13A5EAF20D91B8AF17781BB09C95A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.609 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "4F3EC93856DE15D30B595D15C54F3C48")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void unregisterDataSetObserver(DataSetObserver observer) {
            dsTaint.addTaint(observer.dsTaint);
            {
                mAdapter.unregisterDataSetObserver(observer);
            } //End block
            // ---------- Original Method ----------
            //if (mAdapter != null) {
                //mAdapter.unregisterDataSetObserver(observer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.609 -0400", hash_original_method = "C6F9771E1B3DE27F3DC1DA3F2DDBE42B", hash_generated_method = "3940D5E7214FA235F2735B026E2E528B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean areAllItemsEnabled() {
            ListAdapter adapter;
            adapter = mListAdapter;
            {
                boolean var985642AB936091C75C15CA5EE89CD4ED_1252530651 = (adapter.areAllItemsEnabled());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.609 -0400", hash_original_method = "5A692D7025642F2703B563EEC7270EF6", hash_generated_method = "EC6BFC8A8F47F1A9BA43A8210BD0BDB5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isEnabled(int position) {
            dsTaint.addTaint(position);
            ListAdapter adapter;
            adapter = mListAdapter;
            {
                boolean var1B060CF70AEECE4FB915FA202647B0B7_1226306528 = (adapter.isEnabled(position));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.610 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "882AC502ACA966B0A25E3C5395424311")
        @DSModeled(DSC.SAFE)
        public int getItemViewType(int position) {
            dsTaint.addTaint(position);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.610 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "53C49EF97DA6F0C93968D7347515DA5D")
        @DSModeled(DSC.SAFE)
        public int getViewTypeCount() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.610 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "993B8FC5B9EAA9C9F318698F8C860219")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isEmpty() {
            boolean var1E308F1B2924DF35832B0C6653D5399D_1057179329 = (getCount() == 0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getCount() == 0;
        }

        
    }


    
    private class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private AlertDialog mPopup;
        private ListAdapter mListAdapter;
        private CharSequence mPrompt;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.610 -0400", hash_original_method = "A8E4FB4BF1BB411D9C3A10632B8E89C0", hash_generated_method = "A8E4FB4BF1BB411D9C3A10632B8E89C0")
                public DialogPopup ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.610 -0400", hash_original_method = "FC11027C394F91EA6C471943F011BB6E", hash_generated_method = "DAF71925B3E5CA09CBFAAD2BB2738DDA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dismiss() {
            mPopup.dismiss();
            mPopup = null;
            // ---------- Original Method ----------
            //mPopup.dismiss();
            //mPopup = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.611 -0400", hash_original_method = "BD26E62421B18C78E84EB8F1A09EE4AA", hash_generated_method = "3AC85DE20606FAC7110C4EA82FCDBA74")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isShowing() {
            {
                Object var064AFD47A2F0375BD3A49E11623DCB44_1800614303 = (mPopup.isShowing());
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mPopup != null ? mPopup.isShowing() : false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.611 -0400", hash_original_method = "8403FBCA2C28723FD059691B00D88CE1", hash_generated_method = "3633E035E0CF7B593B85992851898DC8")
        @DSModeled(DSC.SAFE)
        public void setAdapter(ListAdapter adapter) {
            dsTaint.addTaint(adapter.dsTaint);
            // ---------- Original Method ----------
            //mListAdapter = adapter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.612 -0400", hash_original_method = "9624F776B01A0F54225A1B393847DC0B", hash_generated_method = "233B129ECA410E9AC87C2D1FACA0649E")
        @DSModeled(DSC.SAFE)
        public void setPromptText(CharSequence hintText) {
            dsTaint.addTaint(hintText);
            // ---------- Original Method ----------
            //mPrompt = hintText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.612 -0400", hash_original_method = "2D362FF1EB68D3106D16676724B21A20", hash_generated_method = "191FDC4068390A0395E4629C161A08E8")
        @DSModeled(DSC.SAFE)
        public CharSequence getHintText() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mPrompt;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.613 -0400", hash_original_method = "FCDD379DF322C9BE95870CB90106F42A", hash_generated_method = "CDBDB05C7384CC6C823A427D804A09D2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.613 -0400", hash_original_method = "611F98047F020130E79D369CDAEB53F1", hash_generated_method = "93A2BEC26418BBA44FFEC1252397E78C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.614 -0400", hash_original_method = "9F2E5A3A347BB64B0E4347185558EFBB", hash_generated_method = "D73FAFE1B50903565E66F4A456182FCD")
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.614 -0400", hash_original_method = "BF22134BB65D55D48C7DDDF1370D6ED2", hash_generated_method = "597DF73726E49288889AAD7AF5289BA2")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void onItemClick(AdapterView parent, View v, int position, long id) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(id);
                    dsTaint.addTaint(position);
                    dsTaint.addTaint(v.dsTaint);
                    dsTaint.addTaint(parent.dsTaint);
                    Spinner.this.setSelection(position);
                    dismiss();
                    // ---------- Original Method ----------
                    //Spinner.this.setSelection(position);
                    //dismiss();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.614 -0400", hash_original_method = "3FC404C9DE24A7B182849EFCFBFDCEFF", hash_generated_method = "5A7F7F1F3E4B3488331868753C9667BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setAdapter(ListAdapter adapter) {
            dsTaint.addTaint(adapter.dsTaint);
            super.setAdapter(adapter);
            // ---------- Original Method ----------
            //super.setAdapter(adapter);
            //mAdapter = adapter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.614 -0400", hash_original_method = "708F2EB27A8EC2C1F7F8C9DF82B35D6E", hash_generated_method = "03B4697B5C1342B1718D5F796F18A19C")
        @DSModeled(DSC.SAFE)
        public CharSequence getHintText() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mHintText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.614 -0400", hash_original_method = "5C072498C5CF07F19C35B82F77A3E1EC", hash_generated_method = "4D8A321F1CD114490A160DF3485D1E09")
        @DSModeled(DSC.SAFE)
        public void setPromptText(CharSequence hintText) {
            dsTaint.addTaint(hintText);
            // ---------- Original Method ----------
            //mHintText = hintText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.615 -0400", hash_original_method = "831D1D82273C571177D94CDCC1E5A7C8", hash_generated_method = "5ED85223FCBB2217E1DCAC23CB5A6589")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void show() {
            int spinnerPaddingLeft;
            spinnerPaddingLeft = Spinner.this.getPaddingLeft();
            {
                int spinnerWidth;
                spinnerWidth = Spinner.this.getWidth();
                int spinnerPaddingRight;
                spinnerPaddingRight = Spinner.this.getPaddingRight();
                setContentWidth(Math.max(
                        measureContentWidth((SpinnerAdapter) mAdapter, getBackground()),
                        spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight));
            } //End block
            {
                int spinnerWidth;
                spinnerWidth = Spinner.this.getWidth();
                int spinnerPaddingRight;
                spinnerPaddingRight = Spinner.this.getPaddingRight();
                setContentWidth(spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight);
            } //End block
            {
                setContentWidth(mDropDownWidth);
            } //End block
            Drawable background;
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
    
    private static final String TAG = "Spinner";
    private static final int MAX_ITEMS_MEASURED = 15;
    public static final int MODE_DIALOG = 0;
    public static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
}

