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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.866 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "2B2C8DD5949DF96120E12CE686443E54")

    private SpinnerPopup mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.866 -0400", hash_original_field = "DB8AEAB3B92BDCB9C1750435FF08F347", hash_generated_field = "C1900A4CF75F2ED95144B24FDA148887")

    private DropDownAdapter mTempAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.866 -0400", hash_original_field = "56AD5481B6A7DF9BE8EA5BE42BC8A2A2", hash_generated_field = "9F13B49ED3B4F15DF1C39EF57B2A0772")

    int mDropDownWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.866 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "ACF14A395FB2702990553CD0EFA1BDCC")

    private int mGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.866 -0400", hash_original_field = "D8AB3D4F1D71BCDC94E13C76C2E7EAF9", hash_generated_field = "7967DE792AA6967947AC34B6AC2CC5E6")

    private boolean mDisableChildrenWhenDisabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.866 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.866 -0400", hash_original_method = "B5C06F1AC4F38C2FF014EC091685338D", hash_generated_method = "FE480488CFAF338D190465CF15135132")
    public  Spinner(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.867 -0400", hash_original_method = "6645D47A83FEF1D160E35889A652939D", hash_generated_method = "0D03D4C496A1494E34A485DD66255BCF")
    public  Spinner(Context context, int mode) {
        this(context, null, com.android.internal.R.attr.spinnerStyle, mode);
        addTaint(context.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.867 -0400", hash_original_method = "B198D16CD1474762E3B97C016462CA6F", hash_generated_method = "98E558EE3E07124E17F8FA31D1D4AFB1")
    public  Spinner(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.spinnerStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.867 -0400", hash_original_method = "78C6FE6C5EEF3610339F87F7F649A015", hash_generated_method = "DAC30882A8EB10DA8D36BFB5483AEA1B")
    public  Spinner(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, MODE_THEME);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.872 -0400", hash_original_method = "290E4CD98FA983594AD8D129D824FCAE", hash_generated_method = "44434A41826F67C5E844C08BDC854A07")
    public  Spinner(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle);
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
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        addTaint(mode);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.873 -0400", hash_original_method = "E89DC933CAA3948ECC7191CDEBCA4F7F", hash_generated_method = "4B8944D259DF8F9C9A5C7F4E5FD1F2FC")
    @Override
    public void setEnabled(boolean enabled) {
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
        addTaint(enabled);
        // ---------- Original Method ----------
        //super.setEnabled(enabled);
        //if (mDisableChildrenWhenDisabled) {
            //final int count = getChildCount();
            //for (int i = 0; i < count; i++) {
                //getChildAt(i).setEnabled(enabled);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.873 -0400", hash_original_method = "2D67806CEC3CAAEAC987F460E7189BA9", hash_generated_method = "581B3A8CC2ADFBD090B1DE0FBFA07032")
    public void setGravity(int gravity) {
        {
            {
                gravity |= Gravity.LEFT;
            } //End block
            mGravity = gravity;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.874 -0400", hash_original_method = "60241601236C86A9296272064A15234D", hash_generated_method = "B3BAD5DA17A85B926BCB91F9E8FEBA88")
    @Override
    public void setAdapter(SpinnerAdapter adapter) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.874 -0400", hash_original_method = "50D7CC7A93B993E2A6FF522D575BAEB5", hash_generated_method = "A1C0190CB2218604354FCCA4FBC96BDB")
    @Override
    public int getBaseline() {
        View child;
        child = null;
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1707764482 = (getChildCount() > 0);
            {
                child = getChildAt(0);
            } //End block
            {
                boolean var64E96C628F62864AA686A96BEDED1403_1506193068 = (mAdapter != null && mAdapter.getCount() > 0);
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
                Object var54BA034BC30EE04F32CE30794275A01A_1702463415 = (child.getTop() + childBaseline);
            } //End flattened ternary
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1921221764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1921221764;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.881 -0400", hash_original_method = "B6F13EE08FDC85FB02DBBB6CA125C601", hash_generated_method = "C21E678661C39D4297507FE08C416751")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        {
            boolean varD929D8531D595F5EA0B4A8A252DF969D_2083280254 = (mPopup != null && mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.881 -0400", hash_original_method = "AE9F9278138E36A1F7A0C4102CD0DE5F", hash_generated_method = "7F5AC0D830F3AD8737EF0FF5E2239EB7")
    @Override
    public void setOnItemClickListener(OnItemClickListener l) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
        addTaint(l.getTaint());
        // ---------- Original Method ----------
        //throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.882 -0400", hash_original_method = "EC8AF316641014792672178145DBD315", hash_generated_method = "3A0B97B42150E6A33DC2F9FBE093679C")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        {
            boolean var5BB94CDAE497737B2AF326771BF24CAC_28838890 = (mPopup != null && MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST);
            {
                int measuredWidth;
                measuredWidth = getMeasuredWidth();
                setMeasuredDimension(Math.min(Math.max(measuredWidth,
                    measureContentWidth(getAdapter(), getBackground())),
                    MeasureSpec.getSize(widthMeasureSpec)),
                    getMeasuredHeight());
            } //End block
        } //End collapsed parenthetic
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.882 -0400", hash_original_method = "2F25E46AB3A307ED9F0C91E6C81BDCD4", hash_generated_method = "65ACF9A64D756E5637EB155848E3E853")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onLayout(changed, l, t, r, b);
        mInLayout = true;
        layout(0, false);
        mInLayout = false;
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //super.onLayout(changed, l, t, r, b);
        //mInLayout = true;
        //layout(0, false);
        //mInLayout = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.884 -0400", hash_original_method = "26F25590D97768D2F385154C131B8E76", hash_generated_method = "64EC9F21AA1C45CB3B2B6A087A009428")
    @Override
     void layout(int delta, boolean animate) {
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
        addTaint(delta);
        addTaint(animate);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.885 -0400", hash_original_method = "16A0D15DF35F8329F5BE73262CE9B509", hash_generated_method = "9A966E884001AD0C4495034E64EEA591")
    private View makeAndAddView(int position) {
        View varB4EAC82CA7396A68D541C85D26508E83_827022572 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_632775294 = null; //Variable for return #2
        View child;
        {
            child = mRecycler.get(position);
            {
                setUpChild(child);
                varB4EAC82CA7396A68D541C85D26508E83_827022572 = child;
            } //End block
        } //End block
        child = mAdapter.getView(position, null, this);
        setUpChild(child);
        varB4EAC82CA7396A68D541C85D26508E83_632775294 = child;
        addTaint(position);
        View varA7E53CE21691AB073D9660D615818899_579504142; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_579504142 = varB4EAC82CA7396A68D541C85D26508E83_827022572;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_579504142 = varB4EAC82CA7396A68D541C85D26508E83_632775294;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_579504142.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_579504142;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.951 -0400", hash_original_method = "EA422D8BE64CA8F3FB87FB3D4E23C7FB", hash_generated_method = "96CB89B84DD8225016F6EF9C9DEF7615")
    private void setUpChild(View child) {
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
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.951 -0400", hash_original_method = "DE0583C7611D1F2BE10915793A501A4C", hash_generated_method = "E4306F937D60990552B5B0A0A6B1AF2A")
    @Override
    public boolean performClick() {
        boolean handled;
        handled = super.performClick();
        {
            handled = true;
            {
                boolean varE54135B8CA552C10B65F25C1BE9A982D_1520573633 = (!mPopup.isShowing());
                {
                    mPopup.show();
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632042341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632042341;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.952 -0400", hash_original_method = "21A8DBFD7E0EEAC4158875C988469F50", hash_generated_method = "4747EBD4AE52098FE6F53157784D7F32")
    public void onClick(DialogInterface dialog, int which) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setSelection(which);
        dialog.dismiss();
        addTaint(dialog.getTaint());
        addTaint(which);
        // ---------- Original Method ----------
        //setSelection(which);
        //dialog.dismiss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.952 -0400", hash_original_method = "82831FCEC8FF5E5499EA6A36B12A66DA", hash_generated_method = "5244C7309714851D8F9FA9A60609AE32")
    public void setPrompt(CharSequence prompt) {
        mPopup.setPromptText(prompt);
        addTaint(prompt.getTaint());
        // ---------- Original Method ----------
        //mPopup.setPromptText(prompt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.952 -0400", hash_original_method = "21AEC72317B46CB2881CC90C11A2AA6E", hash_generated_method = "282CDD662BB137828E37FF9AB97BDF04")
    public void setPromptId(int promptId) {
        setPrompt(getContext().getText(promptId));
        addTaint(promptId);
        // ---------- Original Method ----------
        //setPrompt(getContext().getText(promptId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.953 -0400", hash_original_method = "07472705288FF1B8FBB0DCE1C944E4ED", hash_generated_method = "E34A2A1B22659F443B569C3EE1505448")
    public CharSequence getPrompt() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_453187778 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_453187778 = mPopup.getHintText();
        varB4EAC82CA7396A68D541C85D26508E83_453187778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_453187778;
        // ---------- Original Method ----------
        //return mPopup.getHintText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.955 -0400", hash_original_method = "EB37E42D6ACA63E84337B27962C39033", hash_generated_method = "5304D08CFA84F7681CA6694F75F8209D")
     int measureContentWidth(SpinnerAdapter adapter, Drawable background) {
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
                    boolean var4600A482EC7CE1FD745D42F74A7EF908_542625504 = (itemView.getLayoutParams() == null);
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
        addTaint(adapter.getTaint());
        addTaint(background.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583681820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583681820;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.955 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "3308AF23407F136C8CF926C7FBD8DC1B")

        private SpinnerAdapter mAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.955 -0400", hash_original_field = "B8EAD9E776B81483E5E8A661601F6AA8", hash_generated_field = "EBBA0833135A672B66F462D046DC0A24")

        private ListAdapter mListAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.955 -0400", hash_original_method = "FD9BEBCCABA72AC6ECD15A9F9D903ED1", hash_generated_method = "4F13D325278085D7E9669A4AB3B420B2")
        public  DropDownAdapter(SpinnerAdapter adapter) {
            this.mAdapter = adapter;
            {
                this.mListAdapter = (ListAdapter) adapter;
            } //End block
            // ---------- Original Method ----------
            //this.mAdapter = adapter;
            //if (adapter instanceof ListAdapter) {
                //this.mListAdapter = (ListAdapter) adapter;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.957 -0400", hash_original_method = "7176E9532C0349D7016ABE3301806E2C", hash_generated_method = "E6DBCDE338BC2077D333E6ED5DA69BB8")
        public int getCount() {
            {
                Object var067BB5993A461EDA4265964116724952_672636936 = (mAdapter.getCount());
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1562508116 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1562508116;
            // ---------- Original Method ----------
            //return mAdapter == null ? 0 : mAdapter.getCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.959 -0400", hash_original_method = "E5529375AE985E64AC9FCAEB196D1278", hash_generated_method = "4119D9FA30E396E4ECB7BC1CECE7F24E")
        public Object getItem(int position) {
            Object varB4EAC82CA7396A68D541C85D26508E83_975795460 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_975795460 = mAdapter == null ? null : mAdapter.getItem(position);
            addTaint(position);
            varB4EAC82CA7396A68D541C85D26508E83_975795460.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_975795460;
            // ---------- Original Method ----------
            //return mAdapter == null ? null : mAdapter.getItem(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.960 -0400", hash_original_method = "516B3E26F5C00C4BD8BAF28DFF38500C", hash_generated_method = "750C4B9335C5FEFA49927724C7149FD5")
        public long getItemId(int position) {
            {
                Object varE791D48808E44BBA8A766C8461C5A401_2013830375 = (mAdapter.getItemId(position));
            } //End flattened ternary
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_904549676 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_904549676;
            // ---------- Original Method ----------
            //return mAdapter == null ? -1 : mAdapter.getItemId(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.974 -0400", hash_original_method = "A9F8983A232A0A246637701F010ACE34", hash_generated_method = "60C8446C5CED7B10A079F5EDE1C02115")
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_1782619688 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1782619688 = getDropDownView(position, convertView, parent);
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1782619688.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1782619688;
            // ---------- Original Method ----------
            //return getDropDownView(position, convertView, parent);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.975 -0400", hash_original_method = "F097CA4C24B6E5261C3C9C12681A60CA", hash_generated_method = "ACFF47E0407E6E1965B129D3857E908D")
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_696473585 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_696473585 = mAdapter == null ? null :
                    mAdapter.getDropDownView(position, convertView, parent);
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_696473585.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_696473585;
            // ---------- Original Method ----------
            //return mAdapter == null ? null :
                    //mAdapter.getDropDownView(position, convertView, parent);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.975 -0400", hash_original_method = "EE546908428E55FCCB0B2F98C659D31B", hash_generated_method = "44C3FE469489219DF4B927146BFE9116")
        public boolean hasStableIds() {
            boolean var92A5B2B773F784D23AACADEC549061AE_509152811 = (mAdapter != null && mAdapter.hasStableIds());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883380923 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_883380923;
            // ---------- Original Method ----------
            //return mAdapter != null && mAdapter.hasStableIds();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.983 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "394F8D6D1C3E11D04B82C1A93DEB883B")
        public void registerDataSetObserver(DataSetObserver observer) {
            //DSFIXME: CODE0010: Possible callback registration function detected
            {
                mAdapter.registerDataSetObserver(observer);
            } //End block
            addTaint(observer.getTaint());
            // ---------- Original Method ----------
            //if (mAdapter != null) {
                //mAdapter.registerDataSetObserver(observer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.983 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "CA1E1CE41BA81DA1B5FFC90A490DA640")
        public void unregisterDataSetObserver(DataSetObserver observer) {
            {
                mAdapter.unregisterDataSetObserver(observer);
            } //End block
            addTaint(observer.getTaint());
            // ---------- Original Method ----------
            //if (mAdapter != null) {
                //mAdapter.unregisterDataSetObserver(observer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.984 -0400", hash_original_method = "C6F9771E1B3DE27F3DC1DA3F2DDBE42B", hash_generated_method = "E884435764909684E0209C24E1335B3E")
        public boolean areAllItemsEnabled() {
            ListAdapter adapter;
            adapter = mListAdapter;
            {
                boolean var985642AB936091C75C15CA5EE89CD4ED_260091835 = (adapter.areAllItemsEnabled());
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654965519 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654965519;
            // ---------- Original Method ----------
            //final ListAdapter adapter = mListAdapter;
            //if (adapter != null) {
                //return adapter.areAllItemsEnabled();
            //} else {
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.984 -0400", hash_original_method = "5A692D7025642F2703B563EEC7270EF6", hash_generated_method = "348D074810EB8C6AF6D9503CC6FBB922")
        public boolean isEnabled(int position) {
            ListAdapter adapter;
            adapter = mListAdapter;
            {
                boolean var1B060CF70AEECE4FB915FA202647B0B7_322417513 = (adapter.isEnabled(position));
            } //End block
            addTaint(position);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1072641577 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1072641577;
            // ---------- Original Method ----------
            //final ListAdapter adapter = mListAdapter;
            //if (adapter != null) {
                //return adapter.isEnabled(position);
            //} else {
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.985 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "FDF3DEE55964EDDF933F1FC8BA1D57C2")
        public int getItemViewType(int position) {
            addTaint(position);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843041583 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843041583;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.985 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "EEDFEAB06452FD43FE16E9B5E1697A21")
        public int getViewTypeCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113085762 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113085762;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.985 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "42B34B5E5CFFE11CB88C7CF6341A974A")
        public boolean isEmpty() {
            boolean var1E308F1B2924DF35832B0C6653D5399D_590568801 = (getCount() == 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997183643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997183643;
            // ---------- Original Method ----------
            //return getCount() == 0;
        }

        
    }


    
    private class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.996 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "8A66D18866E05C57D866195195114C43")

        private AlertDialog mPopup;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.996 -0400", hash_original_field = "B8EAD9E776B81483E5E8A661601F6AA8", hash_generated_field = "EBBA0833135A672B66F462D046DC0A24")

        private ListAdapter mListAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.996 -0400", hash_original_field = "902D3ABF16579BBC81B141476B035DD1", hash_generated_field = "D9DA4C057AA02B144FF3C40EB2E94890")

        private CharSequence mPrompt;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.996 -0400", hash_original_method = "CE7B674B2EA3FB97987A0C722722E738", hash_generated_method = "CE7B674B2EA3FB97987A0C722722E738")
        public DialogPopup ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.997 -0400", hash_original_method = "FC11027C394F91EA6C471943F011BB6E", hash_generated_method = "DAF71925B3E5CA09CBFAAD2BB2738DDA")
        public void dismiss() {
            mPopup.dismiss();
            mPopup = null;
            // ---------- Original Method ----------
            //mPopup.dismiss();
            //mPopup = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.997 -0400", hash_original_method = "BD26E62421B18C78E84EB8F1A09EE4AA", hash_generated_method = "C3D283E69EF7E76D3401BD49D4270076")
        public boolean isShowing() {
            {
                Object var064AFD47A2F0375BD3A49E11623DCB44_2091886529 = (mPopup.isShowing());
            } //End flattened ternary
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811754594 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_811754594;
            // ---------- Original Method ----------
            //return mPopup != null ? mPopup.isShowing() : false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.998 -0400", hash_original_method = "8403FBCA2C28723FD059691B00D88CE1", hash_generated_method = "2A0FFE64737AEA0CAA4489A819F70A16")
        public void setAdapter(ListAdapter adapter) {
            mListAdapter = adapter;
            // ---------- Original Method ----------
            //mListAdapter = adapter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.998 -0400", hash_original_method = "9624F776B01A0F54225A1B393847DC0B", hash_generated_method = "BB0F0F2687998277E739EA69AA391DAB")
        public void setPromptText(CharSequence hintText) {
            mPrompt = hintText;
            // ---------- Original Method ----------
            //mPrompt = hintText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.007 -0400", hash_original_method = "2D362FF1EB68D3106D16676724B21A20", hash_generated_method = "C2DE4A6898B9023568ADBA631755F4FE")
        public CharSequence getHintText() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_825884664 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_825884664 = mPrompt;
            varB4EAC82CA7396A68D541C85D26508E83_825884664.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_825884664;
            // ---------- Original Method ----------
            //return mPrompt;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.010 -0400", hash_original_method = "FCDD379DF322C9BE95870CB90106F42A", hash_generated_method = "CDBDB05C7384CC6C823A427D804A09D2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.010 -0400", hash_original_method = "611F98047F020130E79D369CDAEB53F1", hash_generated_method = "20A80883BB81CEF2BE9AA01C09089F02")
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            setSelection(which);
            dismiss();
            addTaint(dialog.getTaint());
            addTaint(which);
            // ---------- Original Method ----------
            //setSelection(which);
            //dismiss();
        }

        
    }


    
    private class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.010 -0400", hash_original_field = "E1CABE1E2EB0E02B938A46A1B7A0EBFD", hash_generated_field = "1FDB4027FDC409C38C96D7C7129240A3")

        private CharSequence mHintText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.010 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

        private ListAdapter mAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.024 -0400", hash_original_method = "9F2E5A3A347BB64B0E4347185558EFBB", hash_generated_method = "D768F09A975D52D832D0D5802FF46969")
        public  DropdownPopup(Context context, AttributeSet attrs, int defStyleRes) {
            super(context, attrs, 0, defStyleRes);
            setAnchorView(Spinner.this);
            setModal(true);
            setPromptPosition(POSITION_PROMPT_ABOVE);
            setOnItemClickListener(new OnItemClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.011 -0400", hash_original_method = "BF22134BB65D55D48C7DDDF1370D6ED2", hash_generated_method = "2159CDD10341E819E3C4AB7B64FB1945")
                public void onItemClick(AdapterView parent, View v, int position, long id) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    Spinner.this.setSelection(position);
                    dismiss();
                    addTaint(parent.getTaint());
                    addTaint(v.getTaint());
                    addTaint(position);
                    addTaint(id);
                    // ---------- Original Method ----------
                    //Spinner.this.setSelection(position);
                    //dismiss();
                }
});
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            addTaint(defStyleRes);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.026 -0400", hash_original_method = "3FC404C9DE24A7B182849EFCFBFDCEFF", hash_generated_method = "3B91B048A8013001F176DA62B9199C4B")
        @Override
        public void setAdapter(ListAdapter adapter) {
            super.setAdapter(adapter);
            mAdapter = adapter;
            // ---------- Original Method ----------
            //super.setAdapter(adapter);
            //mAdapter = adapter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.026 -0400", hash_original_method = "708F2EB27A8EC2C1F7F8C9DF82B35D6E", hash_generated_method = "2BD776783216D116FC3E9BA43DF0AE97")
        public CharSequence getHintText() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_921907275 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_921907275 = mHintText;
            varB4EAC82CA7396A68D541C85D26508E83_921907275.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_921907275;
            // ---------- Original Method ----------
            //return mHintText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.027 -0400", hash_original_method = "5C072498C5CF07F19C35B82F77A3E1EC", hash_generated_method = "16E5231AF70EBF4E19AB1B172E7CB522")
        public void setPromptText(CharSequence hintText) {
            mHintText = hintText;
            // ---------- Original Method ----------
            //mHintText = hintText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.031 -0400", hash_original_method = "831D1D82273C571177D94CDCC1E5A7C8", hash_generated_method = "5ED85223FCBB2217E1DCAC23CB5A6589")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "90FDE6788399EEB8CFA584A2AD13CBE5", hash_generated_field = "17276AD5EEFA44CEC4EF69D10E11AE20")

    private static String TAG = "Spinner";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "78512CB4B8E7A1ED8A337810241ABF54", hash_generated_field = "84DFB7C236A85A577AAD4D069CA75BAF")

    private static int MAX_ITEMS_MEASURED = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "347C2CAB737F0CAF3BCAEC15CF42EBD2", hash_generated_field = "03A8B0FB324BD4C85C18EC4F45126C80")

    public static final int MODE_DIALOG = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "CB25F0D23E25C135EA3A64B2382813EF", hash_generated_field = "77CCFBFBDA82C84B44434E6E2C506BCB")

    public static final int MODE_DROPDOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.032 -0400", hash_original_field = "6ED8E1287CB86C092F8B2D91FE966865", hash_generated_field = "8848A9146685720D8A0BCBF80CFEC974")

    private static int MODE_THEME = -1;
}

