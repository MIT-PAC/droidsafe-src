package android.widget;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.395 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "2B2C8DD5949DF96120E12CE686443E54")

    private SpinnerPopup mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.395 -0400", hash_original_field = "DB8AEAB3B92BDCB9C1750435FF08F347", hash_generated_field = "C1900A4CF75F2ED95144B24FDA148887")

    private DropDownAdapter mTempAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.395 -0400", hash_original_field = "56AD5481B6A7DF9BE8EA5BE42BC8A2A2", hash_generated_field = "9F13B49ED3B4F15DF1C39EF57B2A0772")

    int mDropDownWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.395 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "ACF14A395FB2702990553CD0EFA1BDCC")

    private int mGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.395 -0400", hash_original_field = "D8AB3D4F1D71BCDC94E13C76C2E7EAF9", hash_generated_field = "7967DE792AA6967947AC34B6AC2CC5E6")

    private boolean mDisableChildrenWhenDisabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.395 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.395 -0400", hash_original_method = "B5C06F1AC4F38C2FF014EC091685338D", hash_generated_method = "FE480488CFAF338D190465CF15135132")
    public  Spinner(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.396 -0400", hash_original_method = "6645D47A83FEF1D160E35889A652939D", hash_generated_method = "5B105E6618A0C2ECFF588A781B718ACE")
    public  Spinner(Context context, int mode) {
        this(context, null, com.android.internal.R.attr.spinnerStyle, mode);
        addTaint(mode);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.396 -0400", hash_original_method = "B198D16CD1474762E3B97C016462CA6F", hash_generated_method = "1FD1B35FDE22AE79A29B21AB574BA4ED")
    public  Spinner(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.spinnerStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.396 -0400", hash_original_method = "78C6FE6C5EEF3610339F87F7F649A015", hash_generated_method = "E295D7B4DF75671C21E61A43AE8C9F6E")
    public  Spinner(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, MODE_THEME);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.398 -0400", hash_original_method = "290E4CD98FA983594AD8D129D824FCAE", hash_generated_method = "C5A23EE62EEE992CC969E649878D3D62")
    public  Spinner(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle);
        addTaint(mode);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Spinner, defStyle, 0);
        if(mode == MODE_THEME)        
        {
            mode = a.getInt(com.android.internal.R.styleable.Spinner_spinnerMode, MODE_DIALOG);
        } //End block
switch(mode){
        case MODE_DIALOG:
        {
            mPopup = new DialogPopup();
            break;
        } //End block
        case MODE_DROPDOWN:
        {
            DropdownPopup popup = new DropdownPopup(context, attrs, defStyle);
            mDropDownWidth = a.getLayoutDimension(
                    com.android.internal.R.styleable.Spinner_dropDownWidth,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            popup.setBackgroundDrawable(a.getDrawable(
                    com.android.internal.R.styleable.Spinner_popupBackground));
            final int verticalOffset = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.Spinner_dropDownVerticalOffset, 0);
            if(verticalOffset != 0)            
            {
                popup.setVerticalOffset(verticalOffset);
            } //End block
            final int horizontalOffset = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.Spinner_dropDownHorizontalOffset, 0);
            if(horizontalOffset != 0)            
            {
                popup.setHorizontalOffset(horizontalOffset);
            } //End block
            mPopup = popup;
            break;
        } //End block
}        mGravity = a.getInt(com.android.internal.R.styleable.Spinner_gravity, Gravity.CENTER);
        mPopup.setPromptText(a.getString(com.android.internal.R.styleable.Spinner_prompt));
        mDisableChildrenWhenDisabled = a.getBoolean(
                com.android.internal.R.styleable.Spinner_disableChildrenWhenDisabled, false);
        a.recycle();
        if(mTempAdapter != null)        
        {
            mPopup.setAdapter(mTempAdapter);
            mTempAdapter = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.400 -0400", hash_original_method = "E89DC933CAA3948ECC7191CDEBCA4F7F", hash_generated_method = "538DC556E2EF0F0B4B292623294F014A")
    @Override
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        super.setEnabled(enabled);
        if(mDisableChildrenWhenDisabled)        
        {
            final int count = getChildCount();
for(int i = 0;i < count;i++)
            {
                getChildAt(i).setEnabled(enabled);
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.401 -0400", hash_original_method = "2D67806CEC3CAAEAC987F460E7189BA9", hash_generated_method = "574844C25696B4D21ABD57B50EACC61C")
    public void setGravity(int gravity) {
        if(mGravity != gravity)        
        {
            if((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == 0)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.402 -0400", hash_original_method = "60241601236C86A9296272064A15234D", hash_generated_method = "AAAF0A0C52D3159C4E59A31150001286")
    @Override
    public void setAdapter(SpinnerAdapter adapter) {
        super.setAdapter(adapter);
        if(mPopup != null)        
        {
            mPopup.setAdapter(new DropDownAdapter(adapter));
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.403 -0400", hash_original_method = "50D7CC7A93B993E2A6FF522D575BAEB5", hash_generated_method = "65A4C05EAB6DBE4BE7AD3DAC1B5E88CA")
    @Override
    public int getBaseline() {
        View child = null;
        if(getChildCount() > 0)        
        {
            child = getChildAt(0);
        } //End block
        else
        if(mAdapter != null && mAdapter.getCount() > 0)        
        {
            child = makeAndAddView(0);
            mRecycler.put(0, child);
            removeAllViewsInLayout();
        } //End block
        if(child != null)        
        {
            final int childBaseline = child.getBaseline();
            int var6DD57D69AEB22D4D2F933B58EF61AAC4_1564800407 = (childBaseline >= 0 ? child.getTop() + childBaseline : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_112508138 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_112508138;
        } //End block
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_584809899 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338940714 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338940714;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.404 -0400", hash_original_method = "B6F13EE08FDC85FB02DBBB6CA125C601", hash_generated_method = "7C42324E894157B295EC6714F81C0CF8")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        if(mPopup != null && mPopup.isShowing())        
        {
            mPopup.dismiss();
        } //End block
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //if (mPopup != null && mPopup.isShowing()) {
            //mPopup.dismiss();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.405 -0400", hash_original_method = "AE9F9278138E36A1F7A0C4102CD0DE5F", hash_generated_method = "4231E434B44DF89B3C25D97DC8AD7A57")
    @Override
    public void setOnItemClickListener(OnItemClickListener l) {
        addTaint(l.getTaint());
        RuntimeException var4AA440995E8FDA88D81E06B057BF062D_1916628213 = new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
        var4AA440995E8FDA88D81E06B057BF062D_1916628213.addTaint(taint);
        throw var4AA440995E8FDA88D81E06B057BF062D_1916628213;
        // ---------- Original Method ----------
        //throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.406 -0400", hash_original_method = "EC8AF316641014792672178145DBD315", hash_generated_method = "71DB245565BD31984A55F06E3FE5D5B4")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(mPopup != null && MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST)        
        {
            final int measuredWidth = getMeasuredWidth();
            setMeasuredDimension(Math.min(Math.max(measuredWidth,
                    measureContentWidth(getAdapter(), getBackground())),
                    MeasureSpec.getSize(widthMeasureSpec)),
                    getMeasuredHeight());
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.406 -0400", hash_original_method = "2F25E46AB3A307ED9F0C91E6C81BDCD4", hash_generated_method = "323BD35E0292D6B6549E04FE095F2399")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.408 -0400", hash_original_method = "26F25590D97768D2F385154C131B8E76", hash_generated_method = "962C15B19FC0C3BEBD7571D5E6B8A311")
    @Override
     void layout(int delta, boolean animate) {
        addTaint(animate);
        addTaint(delta);
        int childrenLeft = mSpinnerPadding.left;
        int childrenWidth = mRight - mLeft - mSpinnerPadding.left - mSpinnerPadding.right;
        if(mDataChanged)        
        {
            handleDataChanged();
        } //End block
        if(mItemCount == 0)        
        {
            resetList();
            return;
        } //End block
        if(mNextSelectedPosition >= 0)        
        {
            setSelectedPositionInt(mNextSelectedPosition);
        } //End block
        recycleAllViews();
        removeAllViewsInLayout();
        mFirstPosition = mSelectedPosition;
        View sel = makeAndAddView(mSelectedPosition);
        int width = sel.getMeasuredWidth();
        int selectedOffset = childrenLeft;
switch(mGravity & Gravity.HORIZONTAL_GRAVITY_MASK){
        case Gravity.CENTER_HORIZONTAL:
        selectedOffset = childrenLeft + (childrenWidth / 2) - (width / 2);
        break;
        case Gravity.RIGHT:
        selectedOffset = childrenLeft + childrenWidth - width;
        break;
}        sel.offsetLeftAndRight(selectedOffset);
        mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        mDataChanged = false;
        mNeedSync = false;
        setNextSelectedPositionInt(mSelectedPosition);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.409 -0400", hash_original_method = "16A0D15DF35F8329F5BE73262CE9B509", hash_generated_method = "A148C161B0B8832BD9A772EF155625E0")
    private View makeAndAddView(int position) {
        addTaint(position);
        View child;
        if(!mDataChanged)        
        {
            child = mRecycler.get(position);
            if(child != null)            
            {
                setUpChild(child);
View var73902FD3E151130B4329B76EF04D2A54_752012215 =                 child;
                var73902FD3E151130B4329B76EF04D2A54_752012215.addTaint(taint);
                return var73902FD3E151130B4329B76EF04D2A54_752012215;
            } //End block
        } //End block
        child = mAdapter.getView(position, null, this);
        setUpChild(child);
View var73902FD3E151130B4329B76EF04D2A54_1203615473 =         child;
        var73902FD3E151130B4329B76EF04D2A54_1203615473.addTaint(taint);
        return var73902FD3E151130B4329B76EF04D2A54_1203615473;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.422 -0400", hash_original_method = "EA422D8BE64CA8F3FB87FB3D4E23C7FB", hash_generated_method = "53AC7C215039BABA1441D88DDD711E86")
    private void setUpChild(View child) {
        addTaint(child.getTaint());
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        if(lp == null)        
        {
            lp = generateDefaultLayoutParams();
        } //End block
        addViewInLayout(child, 0, lp);
        child.setSelected(hasFocus());
        if(mDisableChildrenWhenDisabled)        
        {
            child.setEnabled(isEnabled());
        } //End block
        int childHeightSpec = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec,
                mSpinnerPadding.top + mSpinnerPadding.bottom, lp.height);
        int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mSpinnerPadding.left + mSpinnerPadding.right, lp.width);
        child.measure(childWidthSpec, childHeightSpec);
        int childLeft;
        int childRight;
        int childTop = mSpinnerPadding.top
                + ((getMeasuredHeight() - mSpinnerPadding.bottom -
                        mSpinnerPadding.top - child.getMeasuredHeight()) / 2);
        int childBottom = childTop + child.getMeasuredHeight();
        int width = child.getMeasuredWidth();
        childLeft = 0;
        childRight = childLeft + width;
        child.layout(childLeft, childTop, childRight, childBottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.423 -0400", hash_original_method = "DE0583C7611D1F2BE10915793A501A4C", hash_generated_method = "310746E82B827C2338B5969DA00CC32B")
    @Override
    public boolean performClick() {
        boolean handled = super.performClick();
        if(!handled)        
        {
            handled = true;
            if(!mPopup.isShowing())            
            {
                mPopup.show();
            } //End block
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_992883194 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_145152223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_145152223;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.423 -0400", hash_original_method = "21A8DBFD7E0EEAC4158875C988469F50", hash_generated_method = "45E4EE2D286C2662F060389589EBB096")
    public void onClick(DialogInterface dialog, int which) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(which);
        addTaint(dialog.getTaint());
        setSelection(which);
        dialog.dismiss();
        // ---------- Original Method ----------
        //setSelection(which);
        //dialog.dismiss();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.423 -0400", hash_original_method = "82831FCEC8FF5E5499EA6A36B12A66DA", hash_generated_method = "E0E9B9E4367F942D99A5170E9D87AB30")
    public void setPrompt(CharSequence prompt) {
        addTaint(prompt.getTaint());
        mPopup.setPromptText(prompt);
        // ---------- Original Method ----------
        //mPopup.setPromptText(prompt);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.423 -0400", hash_original_method = "21AEC72317B46CB2881CC90C11A2AA6E", hash_generated_method = "6DE90886A409A29A5405C69691171373")
    public void setPromptId(int promptId) {
        addTaint(promptId);
        setPrompt(getContext().getText(promptId));
        // ---------- Original Method ----------
        //setPrompt(getContext().getText(promptId));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.423 -0400", hash_original_method = "07472705288FF1B8FBB0DCE1C944E4ED", hash_generated_method = "77630A5D79956C2D043C8816355589C1")
    public CharSequence getPrompt() {
CharSequence var660C90DFF4CC5BB8EC30A018F8548473_849550385 =         mPopup.getHintText();
        var660C90DFF4CC5BB8EC30A018F8548473_849550385.addTaint(taint);
        return var660C90DFF4CC5BB8EC30A018F8548473_849550385;
        // ---------- Original Method ----------
        //return mPopup.getHintText();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.423 -0400", hash_original_method = "EB37E42D6ACA63E84337B27962C39033", hash_generated_method = "8C1BB22F48DD848CA080565A4CC47962")
     int measureContentWidth(SpinnerAdapter adapter, Drawable background) {
        addTaint(background.getTaint());
        addTaint(adapter.getTaint());
        if(adapter == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_307539915 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020326117 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020326117;
        } //End block
        int width = 0;
        View itemView = null;
        int itemType = 0;
        final int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int start = Math.max(0, getSelectedItemPosition());
        final int end = Math.min(adapter.getCount(), start + MAX_ITEMS_MEASURED);
        final int count = end - start;
        start = Math.max(0, start - (MAX_ITEMS_MEASURED - count));
for(int i = start;i < end;i++)
        {
            final int positionType = adapter.getItemViewType(i);
            if(positionType != itemType)            
            {
                itemType = positionType;
                itemView = null;
            } //End block
            itemView = adapter.getView(i, itemView, this);
            if(itemView.getLayoutParams() == null)            
            {
                itemView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
            } //End block
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        } //End block
        if(background != null)        
        {
            background.getPadding(mTempRect);
            width += mTempRect.left + mTempRect.right;
        } //End block
        int varEAAE26A6FB20ED3EF54FB23BFA0B1FCC_1462492387 = (width);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669529802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669529802;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.424 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "3308AF23407F136C8CF926C7FBD8DC1B")

        private SpinnerAdapter mAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.424 -0400", hash_original_field = "B8EAD9E776B81483E5E8A661601F6AA8", hash_generated_field = "EBBA0833135A672B66F462D046DC0A24")

        private ListAdapter mListAdapter;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.424 -0400", hash_original_method = "FD9BEBCCABA72AC6ECD15A9F9D903ED1", hash_generated_method = "1D895BF314F3FF5266D86EE42B2D9555")
        public  DropDownAdapter(SpinnerAdapter adapter) {
            this.mAdapter = adapter;
            if(adapter instanceof ListAdapter)            
            {
                this.mListAdapter = (ListAdapter) adapter;
            } //End block
            // ---------- Original Method ----------
            //this.mAdapter = adapter;
            //if (adapter instanceof ListAdapter) {
                //this.mListAdapter = (ListAdapter) adapter;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.424 -0400", hash_original_method = "7176E9532C0349D7016ABE3301806E2C", hash_generated_method = "3826BFD2F583242478BAD59679D2D814")
        public int getCount() {
            int varE493E749D889C1C89CA9DD5144946D16_1024821345 = (mAdapter == null ? 0 : mAdapter.getCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955034839 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955034839;
            // ---------- Original Method ----------
            //return mAdapter == null ? 0 : mAdapter.getCount();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.424 -0400", hash_original_method = "E5529375AE985E64AC9FCAEB196D1278", hash_generated_method = "02D37B509D5FA8ED7F37BF1844164BDE")
        public Object getItem(int position) {
            addTaint(position);
Object var96DEDFAA2FEF81546397D7B866437E91_1312377056 =             mAdapter == null ? null : mAdapter.getItem(position);
            var96DEDFAA2FEF81546397D7B866437E91_1312377056.addTaint(taint);
            return var96DEDFAA2FEF81546397D7B866437E91_1312377056;
            // ---------- Original Method ----------
            //return mAdapter == null ? null : mAdapter.getItem(position);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.424 -0400", hash_original_method = "516B3E26F5C00C4BD8BAF28DFF38500C", hash_generated_method = "BB39E5151387CE62D21A655F80A98C9A")
        public long getItemId(int position) {
            addTaint(position);
            long var85A0C8FBD455921A3C1766783ED128AA_779201839 = (mAdapter == null ? -1 : mAdapter.getItemId(position));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1140338981 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1140338981;
            // ---------- Original Method ----------
            //return mAdapter == null ? -1 : mAdapter.getItemId(position);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.424 -0400", hash_original_method = "A9F8983A232A0A246637701F010ACE34", hash_generated_method = "840026BDBE8D84279D5FCBA2B8E3B502")
        public View getView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
View varC9778900F845CDEBC131D3259B01E458_1397561326 =             getDropDownView(position, convertView, parent);
            varC9778900F845CDEBC131D3259B01E458_1397561326.addTaint(taint);
            return varC9778900F845CDEBC131D3259B01E458_1397561326;
            // ---------- Original Method ----------
            //return getDropDownView(position, convertView, parent);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.424 -0400", hash_original_method = "F097CA4C24B6E5261C3C9C12681A60CA", hash_generated_method = "B4928F8591500EE7A00496BCA5E1C607")
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
View var462E579EA172B70D86B33F9C5EB9EE26_2090450754 =             mAdapter == null ? null :
                    mAdapter.getDropDownView(position, convertView, parent);
            var462E579EA172B70D86B33F9C5EB9EE26_2090450754.addTaint(taint);
            return var462E579EA172B70D86B33F9C5EB9EE26_2090450754;
            // ---------- Original Method ----------
            //return mAdapter == null ? null :
                    //mAdapter.getDropDownView(position, convertView, parent);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.424 -0400", hash_original_method = "EE546908428E55FCCB0B2F98C659D31B", hash_generated_method = "F7B4513E27B4F9C0161615BDD532AC25")
        public boolean hasStableIds() {
            boolean varABD62A89E81A93992CB212ED6F6240A4_1864206753 = (mAdapter != null && mAdapter.hasStableIds());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822272438 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_822272438;
            // ---------- Original Method ----------
            //return mAdapter != null && mAdapter.hasStableIds();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "32335E466B0703D3E78FB752261F1D23")
        public void registerDataSetObserver(DataSetObserver observer) {
            //DSFIXME: CODE0010: Possible callback registration function detected
            addTaint(observer.getTaint());
            if(mAdapter != null)            
            {
                mAdapter.registerDataSetObserver(observer);
            } //End block
            // ---------- Original Method ----------
            //if (mAdapter != null) {
                //mAdapter.registerDataSetObserver(observer);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "47FC584A630BA9EEE65988188E6FA0FB")
        public void unregisterDataSetObserver(DataSetObserver observer) {
            addTaint(observer.getTaint());
            if(mAdapter != null)            
            {
                mAdapter.unregisterDataSetObserver(observer);
            } //End block
            // ---------- Original Method ----------
            //if (mAdapter != null) {
                //mAdapter.unregisterDataSetObserver(observer);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_method = "C6F9771E1B3DE27F3DC1DA3F2DDBE42B", hash_generated_method = "9FE97189CEF502BE18028CD93DB988B7")
        public boolean areAllItemsEnabled() {
            final ListAdapter adapter = mListAdapter;
            if(adapter != null)            
            {
                boolean var4147A888FBE7A708EEE41544ED66BB9B_1342927585 = (adapter.areAllItemsEnabled());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918770072 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918770072;
            } //End block
            else
            {
                boolean varB326B5062B2F0E69046810717534CB09_95512439 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2091345612 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2091345612;
            } //End block
            // ---------- Original Method ----------
            //final ListAdapter adapter = mListAdapter;
            //if (adapter != null) {
                //return adapter.areAllItemsEnabled();
            //} else {
                //return true;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_method = "5A692D7025642F2703B563EEC7270EF6", hash_generated_method = "E908D3B8CFF13A138A0536F37A8B1332")
        public boolean isEnabled(int position) {
            addTaint(position);
            final ListAdapter adapter = mListAdapter;
            if(adapter != null)            
            {
                boolean var6FF3E7B244961D6C5FBA9E7223CBE7CC_1491326939 = (adapter.isEnabled(position));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1990863098 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1990863098;
            } //End block
            else
            {
                boolean varB326B5062B2F0E69046810717534CB09_1141260159 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1015740336 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1015740336;
            } //End block
            // ---------- Original Method ----------
            //final ListAdapter adapter = mListAdapter;
            //if (adapter != null) {
                //return adapter.isEnabled(position);
            //} else {
                //return true;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "CFEBBCD97B49346D8A35F6D96C4459F8")
        public int getItemViewType(int position) {
            addTaint(position);
            int varCFCD208495D565EF66E7DFF9F98764DA_1503221592 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793438320 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793438320;
            // ---------- Original Method ----------
            //return 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "80032E2559BAB7C822EC6F04C76A78AC")
        public int getViewTypeCount() {
            int varC4CA4238A0B923820DCC509A6F75849B_897989251 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484283507 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484283507;
            // ---------- Original Method ----------
            //return 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "89517C0DC522C924F4915BE5CE20C8FC")
        public boolean isEmpty() {
            boolean varA8BDE4853B46678F6434AC4599BE04DB_1610955809 = (getCount() == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453007763 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_453007763;
            // ---------- Original Method ----------
            //return getCount() == 0;
        }

        
    }


    
    private class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "8A66D18866E05C57D866195195114C43")

        private AlertDialog mPopup;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_field = "B8EAD9E776B81483E5E8A661601F6AA8", hash_generated_field = "EBBA0833135A672B66F462D046DC0A24")

        private ListAdapter mListAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_field = "902D3ABF16579BBC81B141476B035DD1", hash_generated_field = "D9DA4C057AA02B144FF3C40EB2E94890")

        private CharSequence mPrompt;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.425 -0400", hash_original_method = "CE7B674B2EA3FB97987A0C722722E738", hash_generated_method = "CE7B674B2EA3FB97987A0C722722E738")
        public DialogPopup ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.426 -0400", hash_original_method = "FC11027C394F91EA6C471943F011BB6E", hash_generated_method = "DAF71925B3E5CA09CBFAAD2BB2738DDA")
        public void dismiss() {
            mPopup.dismiss();
            mPopup = null;
            // ---------- Original Method ----------
            //mPopup.dismiss();
            //mPopup = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.426 -0400", hash_original_method = "BD26E62421B18C78E84EB8F1A09EE4AA", hash_generated_method = "EDFDF7B36836FEF345AB67B6811566AF")
        public boolean isShowing() {
            boolean var150F1752BC0DC283F944E1FEAB4EFCA1_1167031252 = (mPopup != null ? mPopup.isShowing() : false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221887321 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_221887321;
            // ---------- Original Method ----------
            //return mPopup != null ? mPopup.isShowing() : false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.426 -0400", hash_original_method = "8403FBCA2C28723FD059691B00D88CE1", hash_generated_method = "2A0FFE64737AEA0CAA4489A819F70A16")
        public void setAdapter(ListAdapter adapter) {
            mListAdapter = adapter;
            // ---------- Original Method ----------
            //mListAdapter = adapter;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.426 -0400", hash_original_method = "9624F776B01A0F54225A1B393847DC0B", hash_generated_method = "BB0F0F2687998277E739EA69AA391DAB")
        public void setPromptText(CharSequence hintText) {
            mPrompt = hintText;
            // ---------- Original Method ----------
            //mPrompt = hintText;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.426 -0400", hash_original_method = "2D362FF1EB68D3106D16676724B21A20", hash_generated_method = "4259D2492991B3F16E7BAAC2CB0D0E0E")
        public CharSequence getHintText() {
CharSequence var1FB7DF1267B72EDEFBAE28E644BD2FCE_743618714 =             mPrompt;
            var1FB7DF1267B72EDEFBAE28E644BD2FCE_743618714.addTaint(taint);
            return var1FB7DF1267B72EDEFBAE28E644BD2FCE_743618714;
            // ---------- Original Method ----------
            //return mPrompt;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.426 -0400", hash_original_method = "FCDD379DF322C9BE95870CB90106F42A", hash_generated_method = "AB0F0B7C4D9F4FAE44037FEB6E1A4661")
        public void show() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            if(mPrompt != null)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.426 -0400", hash_original_method = "611F98047F020130E79D369CDAEB53F1", hash_generated_method = "862EC6E1CC66DC47DFB51FC5C71069BB")
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
            setSelection(which);
            dismiss();
            // ---------- Original Method ----------
            //setSelection(which);
            //dismiss();
        }

        
    }


    
    private class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.426 -0400", hash_original_field = "E1CABE1E2EB0E02B938A46A1B7A0EBFD", hash_generated_field = "1FDB4027FDC409C38C96D7C7129240A3")

        private CharSequence mHintText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.426 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

        private ListAdapter mAdapter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.427 -0400", hash_original_method = "9F2E5A3A347BB64B0E4347185558EFBB", hash_generated_method = "6A1369C1BD8B56182060E09516F69577")
        public  DropdownPopup(Context context, AttributeSet attrs, int defStyleRes) {
            super(context, attrs, 0, defStyleRes);
            addTaint(defStyleRes);
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            setAnchorView(Spinner.this);
            setModal(true);
            setPromptPosition(POSITION_PROMPT_ABOVE);
            setOnItemClickListener(new OnItemClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.427 -0400", hash_original_method = "BF22134BB65D55D48C7DDDF1370D6ED2", hash_generated_method = "872A7E0392CDFBAEDAC72AD29E3F80FA")
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(id);
                addTaint(position);
                addTaint(v.getTaint());
                addTaint(parent.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.427 -0400", hash_original_method = "3FC404C9DE24A7B182849EFCFBFDCEFF", hash_generated_method = "3B91B048A8013001F176DA62B9199C4B")
        @Override
        public void setAdapter(ListAdapter adapter) {
            super.setAdapter(adapter);
            mAdapter = adapter;
            // ---------- Original Method ----------
            //super.setAdapter(adapter);
            //mAdapter = adapter;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.427 -0400", hash_original_method = "708F2EB27A8EC2C1F7F8C9DF82B35D6E", hash_generated_method = "AEB61BBA17469200D535E9977F1867B7")
        public CharSequence getHintText() {
CharSequence var0C76325C74E482106577E009928E6B9E_905401995 =             mHintText;
            var0C76325C74E482106577E009928E6B9E_905401995.addTaint(taint);
            return var0C76325C74E482106577E009928E6B9E_905401995;
            // ---------- Original Method ----------
            //return mHintText;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.427 -0400", hash_original_method = "5C072498C5CF07F19C35B82F77A3E1EC", hash_generated_method = "16E5231AF70EBF4E19AB1B172E7CB522")
        public void setPromptText(CharSequence hintText) {
            mHintText = hintText;
            // ---------- Original Method ----------
            //mHintText = hintText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.427 -0400", hash_original_method = "831D1D82273C571177D94CDCC1E5A7C8", hash_generated_method = "1B6CC1DB65A484493C5B606E72DB4630")
        @Override
        public void show() {
            final int spinnerPaddingLeft = Spinner.this.getPaddingLeft();
            if(mDropDownWidth == WRAP_CONTENT)            
            {
                final int spinnerWidth = Spinner.this.getWidth();
                final int spinnerPaddingRight = Spinner.this.getPaddingRight();
                setContentWidth(Math.max(
                        measureContentWidth((SpinnerAdapter) mAdapter, getBackground()),
                        spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight));
            } //End block
            else
            if(mDropDownWidth == MATCH_PARENT)            
            {
                final int spinnerWidth = Spinner.this.getWidth();
                final int spinnerPaddingRight = Spinner.this.getPaddingRight();
                setContentWidth(spinnerWidth - spinnerPaddingLeft - spinnerPaddingRight);
            } //End block
            else
            {
                setContentWidth(mDropDownWidth);
            } //End block
            final Drawable background = getBackground();
            int bgOffset = 0;
            if(background != null)            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.427 -0400", hash_original_field = "90FDE6788399EEB8CFA584A2AD13CBE5", hash_generated_field = "24196829F47AA90801DC8C1D4AB09CA2")

    private static final String TAG = "Spinner";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.427 -0400", hash_original_field = "78512CB4B8E7A1ED8A337810241ABF54", hash_generated_field = "66E10B160A98D63911CB4E37185B80B0")

    private static final int MAX_ITEMS_MEASURED = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.428 -0400", hash_original_field = "347C2CAB737F0CAF3BCAEC15CF42EBD2", hash_generated_field = "03A8B0FB324BD4C85C18EC4F45126C80")

    public static final int MODE_DIALOG = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.428 -0400", hash_original_field = "CB25F0D23E25C135EA3A64B2382813EF", hash_generated_field = "77CCFBFBDA82C84B44434E6E2C506BCB")

    public static final int MODE_DROPDOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.428 -0400", hash_original_field = "6ED8E1287CB86C092F8B2D91FE966865", hash_generated_field = "ABE6A4AE1BB7B3ECDF9A30C989D50FCE")

    private static final int MODE_THEME = -1;
}

