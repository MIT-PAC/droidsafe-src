package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.360 -0400", hash_original_method = "D98B8279143D8DB42D11ECE4C668DA6C", hash_generated_method = "CD794385C25CB51A9E9B5214C68D2DD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CheckedTextView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.360 -0400", hash_original_method = "36596E5D7755B07B6F1DB63ABEA718CD", hash_generated_method = "6129FCBEF2EBBC09A25E8F2DE0C41A67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CheckedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.360 -0400", hash_original_method = "B58B3AE8D95B44872F8433BF803A9C37", hash_generated_method = "3DE842E98CBAE41657531F0D1CCEE789")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.361 -0400", hash_original_method = "E1B1AD330E2148117F43C315FF6D1DED", hash_generated_method = "3679ED1F891BEC88079198707411C40A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void toggle() {
        setChecked(!mChecked);
        // ---------- Original Method ----------
        //setChecked(!mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.361 -0400", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "617B031E915555E011BB44555F369867")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isChecked() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mChecked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.361 -0400", hash_original_method = "F58397C66404D0D65BC532CFA70D8C12", hash_generated_method = "CB2182F7111ADCB84CECF6292D49EA13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.361 -0400", hash_original_method = "3FCCCD2AA960312D010B10C25B3E1D95", hash_generated_method = "EF6E1ABFD30743D91C8B11462C1E38F2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.362 -0400", hash_original_method = "93DA6C15D035807E73845CA0E25952EE", hash_generated_method = "ED390639B9E22192326E2E812C5646AD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.362 -0400", hash_original_method = "7617145132345CC873AC9F4B73DFB7CD", hash_generated_method = "54F9C2E0E3E1117BFA66CF5FDA4FE37C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.362 -0400", hash_original_method = "7A1CD8A3A060B0E646E3DFF2DD87386A", hash_generated_method = "F68FD08704297378AA2BECDB0847E879")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.363 -0400", hash_original_method = "B19E130BF4CF411642FF2978EAC8260B", hash_generated_method = "F9357D34D4140A4EE8BBB96C4899605D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        super.onDraw(canvas);
        Drawable checkMarkDrawable;
        checkMarkDrawable = mCheckMarkDrawable;
        {
            int verticalGravity;
            verticalGravity = getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
            int height;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.363 -0400", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "602D6AC90C1E6C0734A78FF8952CEB20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        int[] drawableState;
        drawableState = super.onCreateDrawableState(extraSpace + 1);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_900620222 = (isChecked());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.363 -0400", hash_original_method = "856DABB8A541BB631DA077FA70F1A5D5", hash_generated_method = "1D8708C85CB98371E29284849A2BA698")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.364 -0400", hash_original_method = "E1DFB2AF73729EA8AA28BE1E77594577", hash_generated_method = "E6ACD88241B33A8DDBF7251DC1B35F77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.364 -0400", hash_original_method = "800F92BFA9EDE937B28EAF651D664B90", hash_generated_method = "3C009400F7A153CD93A66C615AE9E4B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onPopulateAccessibilityEvent(event);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_705203883 = (isChecked());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.364 -0400", hash_original_method = "31E71954214D2E567F10971C83F42BE3", hash_generated_method = "8129B71F40411F81463DA2D6E4249B0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    private static final int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
}

