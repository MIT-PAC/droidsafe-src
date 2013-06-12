package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class CheckedTextView extends TextView implements Checkable {
    private boolean mChecked;
    private int mCheckMarkResource;
    private Drawable mCheckMarkDrawable;
    private int mBasePadding;
    private int mCheckMarkWidth;
    private boolean mNeedRequestlayout;
    private static final int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.478 -0400", hash_original_method = "D98B8279143D8DB42D11ECE4C668DA6C", hash_generated_method = "39870732C28CECEFA9BBFDB8938CFC59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CheckedTextView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.478 -0400", hash_original_method = "36596E5D7755B07B6F1DB63ABEA718CD", hash_generated_method = "44F6EDE1C9BF062DCDC6B1CF0B7227EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CheckedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.478 -0400", hash_original_method = "B58B3AE8D95B44872F8433BF803A9C37", hash_generated_method = "CE2FB9E83BB49A28D9FC8EF369F19687")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CheckedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                R.styleable.CheckedTextView, defStyle, 0);
        Drawable d;
        d = a.getDrawable(R.styleable.CheckedTextView_checkMark);
        {
            setCheckMarkDrawable(d);
        } //End block
        boolean checked;
        checked = a.getBoolean(R.styleable.CheckedTextView_checked, false);
        setChecked(checked);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //R.styleable.CheckedTextView, defStyle, 0);
        //Drawable d = a.getDrawable(R.styleable.CheckedTextView_checkMark);
        //if (d != null) {
            //setCheckMarkDrawable(d);
        //}
        //boolean checked = a.getBoolean(R.styleable.CheckedTextView_checked, false);
        //setChecked(checked);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.479 -0400", hash_original_method = "E1B1AD330E2148117F43C315FF6D1DED", hash_generated_method = "748E2465ECB3B083F2154EC31471B444")
    @DSModeled(DSC.SAFE)
    public void toggle() {
        setChecked(!mChecked);
        // ---------- Original Method ----------
        //setChecked(!mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.479 -0400", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "EC35F11159F3572257E55833AC69C170")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isChecked() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mChecked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.479 -0400", hash_original_method = "F58397C66404D0D65BC532CFA70D8C12", hash_generated_method = "DE9A82521783D73027E3AE01ADEBC803")
    @DSModeled(DSC.SAFE)
    public void setChecked(boolean checked) {
        dsTaint.addTaint(checked);
        {
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if (mChecked != checked) {
            //mChecked = checked;
            //refreshDrawableState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.479 -0400", hash_original_method = "3FCCCD2AA960312D010B10C25B3E1D95", hash_generated_method = "AB1E6B87F95F1F57232E7712F8EA7867")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCheckMarkDrawable(int resid) {
        dsTaint.addTaint(resid);
        Drawable d;
        d = null;
        {
            d = getResources().getDrawable(mCheckMarkResource);
        } //End block
        setCheckMarkDrawable(d);
        // ---------- Original Method ----------
        //if (resid != 0 && resid == mCheckMarkResource) {
            //return;
        //}
        //mCheckMarkResource = resid;
        //Drawable d = null;
        //if (mCheckMarkResource != 0) {
            //d = getResources().getDrawable(mCheckMarkResource);
        //}
        //setCheckMarkDrawable(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.479 -0400", hash_original_method = "93DA6C15D035807E73845CA0E25952EE", hash_generated_method = "B87301E26FE50D2CFEE5A307305208D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCheckMarkDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        {
            mCheckMarkDrawable.setCallback(null);
            unscheduleDrawable(mCheckMarkDrawable);
        } //End block
        mNeedRequestlayout = (d != mCheckMarkDrawable);
        {
            d.setCallback(this);
            d.setVisible(getVisibility() == VISIBLE, false);
            d.setState(CHECKED_STATE_SET);
            setMinHeight(d.getIntrinsicHeight());
            mCheckMarkWidth = d.getIntrinsicWidth();
            d.setState(getDrawableState());
        } //End block
        {
            mCheckMarkWidth = 0;
        } //End block
        resolvePadding();
        // ---------- Original Method ----------
        //if (mCheckMarkDrawable != null) {
            //mCheckMarkDrawable.setCallback(null);
            //unscheduleDrawable(mCheckMarkDrawable);
        //}
        //mNeedRequestlayout = (d != mCheckMarkDrawable);
        //if (d != null) {
            //d.setCallback(this);
            //d.setVisible(getVisibility() == VISIBLE, false);
            //d.setState(CHECKED_STATE_SET);
            //setMinHeight(d.getIntrinsicHeight());
            //mCheckMarkWidth = d.getIntrinsicWidth();
            //d.setState(getDrawableState());
        //} else {
            //mCheckMarkWidth = 0;
        //}
        //mCheckMarkDrawable = d;
        //resolvePadding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.479 -0400", hash_original_method = "7617145132345CC873AC9F4B73DFB7CD", hash_generated_method = "61982BB94A37A6584CF3E85601268990")
    @DSModeled(DSC.SAFE)
    @Override
    protected void resolvePadding() {
        super.resolvePadding();
        int newPadding;
        newPadding = mCheckMarkWidth + mBasePadding;
        newPadding = mBasePadding;
        mNeedRequestlayout |= (mPaddingRight != newPadding);
        mPaddingRight = newPadding;
        {
            requestLayout();
            mNeedRequestlayout = false;
        } //End block
        // ---------- Original Method ----------
        //super.resolvePadding();
        //int newPadding = (mCheckMarkDrawable != null) ?
                //mCheckMarkWidth + mBasePadding : mBasePadding;
        //mNeedRequestlayout |= (mPaddingRight != newPadding);
        //mPaddingRight = newPadding;
        //if (mNeedRequestlayout) {
            //requestLayout();
            //mNeedRequestlayout = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.479 -0400", hash_original_method = "7A1CD8A3A060B0E646E3DFF2DD87386A", hash_generated_method = "40E38B2CAC93F1C190DD66FD0BF5A408")
    @DSModeled(DSC.SAFE)
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        super.setPadding(left, top, right, bottom);
        mBasePadding = mPaddingRight;
        // ---------- Original Method ----------
        //super.setPadding(left, top, right, bottom);
        //mBasePadding = mPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.479 -0400", hash_original_method = "B19E130BF4CF411642FF2978EAC8260B", hash_generated_method = "4B4FC7939821872A2BA4A4D8F5FBD0DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        super.onDraw(canvas);
        final Drawable checkMarkDrawable;
        checkMarkDrawable = mCheckMarkDrawable;
        {
            final int verticalGravity;
            verticalGravity = getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
            final int height;
            height = checkMarkDrawable.getIntrinsicHeight();
            int y;
            y = 0;
            //Begin case Gravity.BOTTOM 
            y = getHeight() - height;
            //End case Gravity.BOTTOM 
            //Begin case Gravity.CENTER_VERTICAL 
            y = (getHeight() - height) / 2;
            //End case Gravity.CENTER_VERTICAL 
            int right;
            right = getWidth();
            checkMarkDrawable.setBounds(
                    right - mPaddingRight,
                    y, 
                    right - mPaddingRight + mCheckMarkWidth,
                    y + height);
            checkMarkDrawable.draw(canvas);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.479 -0400", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "2B5F25DEEC988270D63CD911DA792199")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        final int[] drawableState;
        drawableState = super.onCreateDrawableState(extraSpace + 1);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_2100564300 = (isChecked());
            {
                mergeDrawableStates(drawableState, CHECKED_STATE_SET);
            } //End block
        } //End collapsed parenthetic
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        //if (isChecked()) {
            //mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        //}
        //return drawableState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.480 -0400", hash_original_method = "856DABB8A541BB631DA077FA70F1A5D5", hash_generated_method = "13D55C440BE987CE2ACC001BD3BD9DA7")
    @DSModeled(DSC.SAFE)
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            int[] myDrawableState;
            myDrawableState = getDrawableState();
            mCheckMarkDrawable.setState(myDrawableState);
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //if (mCheckMarkDrawable != null) {
            //int[] myDrawableState = getDrawableState();
            //mCheckMarkDrawable.setState(myDrawableState);
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.480 -0400", hash_original_method = "E1DFB2AF73729EA8AA28BE1E77594577", hash_generated_method = "8EECC1F54290B5BC9C19C524FB94EAE3")
    @DSModeled(DSC.SAFE)
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onInitializeAccessibilityEvent(event);
        event.setChecked(mChecked);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setChecked(mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.480 -0400", hash_original_method = "800F92BFA9EDE937B28EAF651D664B90", hash_generated_method = "B07786B6D3844FD6F18D59CD7B98411B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onPopulateAccessibilityEvent(event);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_2622683 = (isChecked());
            {
                event.getText().add(mContext.getString(R.string.radiobutton_selected));
            } //End block
            {
                event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //if (isChecked()) {
            //event.getText().add(mContext.getString(R.string.radiobutton_selected));
        //} else {
            //event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.480 -0400", hash_original_method = "31E71954214D2E567F10971C83F42BE3", hash_generated_method = "7CE9975C7D4447E1AD520105635F91AE")
    @DSModeled(DSC.SAFE)
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(info.dsTaint);
        super.onInitializeAccessibilityNodeInfo(info);
        info.setChecked(mChecked);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setChecked(mChecked);
    }

    
}


