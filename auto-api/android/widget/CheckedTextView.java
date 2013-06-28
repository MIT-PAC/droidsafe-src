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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.207 -0400", hash_original_field = "B7985199D35C1155A55567C458443B15", hash_generated_field = "5B3EF9355FF9C7031B185F0E3C8A05A3")

    private boolean mChecked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.207 -0400", hash_original_field = "8E42736531499FEAFD90DF42FF8EDA89", hash_generated_field = "56D9A5B5697E1794767C7AC768CAFE0C")

    private int mCheckMarkResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.207 -0400", hash_original_field = "550B61CA95009D77CE3932CF1B84D700", hash_generated_field = "C10062341C3645D6C852294631265BE5")

    private Drawable mCheckMarkDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.207 -0400", hash_original_field = "71B6E943F69F1AE17D88D60525D4C0CB", hash_generated_field = "79F756395206E1EEB26019E0D87C14AB")

    private int mBasePadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.207 -0400", hash_original_field = "C8C9C178BA68779160D68C33A60A4C89", hash_generated_field = "66183B11F152F514120E9BC4BB1F25CE")

    private int mCheckMarkWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.207 -0400", hash_original_field = "51D95399A36ED4034B2FC9D634C13862", hash_generated_field = "C623C63EB2FF5407B90C6E9E1CE126E8")

    private boolean mNeedRequestlayout;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.208 -0400", hash_original_method = "D98B8279143D8DB42D11ECE4C668DA6C", hash_generated_method = "C1A1B30DB9754943DFDDE64EE8731EFE")
    public  CheckedTextView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.208 -0400", hash_original_method = "36596E5D7755B07B6F1DB63ABEA718CD", hash_generated_method = "E9CFF49B6FD8550595DD63F2D74A4EE6")
    public  CheckedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.208 -0400", hash_original_method = "B58B3AE8D95B44872F8433BF803A9C37", hash_generated_method = "7605CC3DC0482A743A622DC906839952")
    public  CheckedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.CheckedTextView, defStyle, 0);
        Drawable d = a.getDrawable(R.styleable.CheckedTextView_checkMark);
        {
            setCheckMarkDrawable(d);
        } //End block
        boolean checked = a.getBoolean(R.styleable.CheckedTextView_checked, false);
        setChecked(checked);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.209 -0400", hash_original_method = "E1B1AD330E2148117F43C315FF6D1DED", hash_generated_method = "3679ED1F891BEC88079198707411C40A")
    public void toggle() {
        setChecked(!mChecked);
        // ---------- Original Method ----------
        //setChecked(!mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.209 -0400", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "0384A21347F2A8BD0C18AD3ACA64A9C9")
    @ViewDebug.ExportedProperty
    public boolean isChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_169220658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_169220658;
        // ---------- Original Method ----------
        //return mChecked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.209 -0400", hash_original_method = "F58397C66404D0D65BC532CFA70D8C12", hash_generated_method = "53C7BE272317B4DDDF43F0B0DDB00511")
    public void setChecked(boolean checked) {
        {
            mChecked = checked;
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if (mChecked != checked) {
            //mChecked = checked;
            //refreshDrawableState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.209 -0400", hash_original_method = "3FCCCD2AA960312D010B10C25B3E1D95", hash_generated_method = "9352105494D84FC5704F1C8C13D33FB7")
    public void setCheckMarkDrawable(int resid) {
        mCheckMarkResource = resid;
        Drawable d = null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.210 -0400", hash_original_method = "93DA6C15D035807E73845CA0E25952EE", hash_generated_method = "FAC80602BB1A2528C04BBDA3A6E8FDC2")
    public void setCheckMarkDrawable(Drawable d) {
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
        mCheckMarkDrawable = d;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.210 -0400", hash_original_method = "7617145132345CC873AC9F4B73DFB7CD", hash_generated_method = "54F9C2E0E3E1117BFA66CF5FDA4FE37C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.211 -0400", hash_original_method = "7A1CD8A3A060B0E646E3DFF2DD87386A", hash_generated_method = "55F122B04E8CF3F17D1F88AEAE81FF29")
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
        mBasePadding = mPaddingRight;
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        //super.setPadding(left, top, right, bottom);
        //mBasePadding = mPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.211 -0400", hash_original_method = "B19E130BF4CF411642FF2978EAC8260B", hash_generated_method = "DA0B299B86D4268D4B46672405588144")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDraw(canvas);
        final Drawable checkMarkDrawable = mCheckMarkDrawable;
        {
            final int verticalGravity = getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
            final int height = checkMarkDrawable.getIntrinsicHeight();
            int y = 0;
            //Begin case Gravity.BOTTOM 
            y = getHeight() - height;
            //End case Gravity.BOTTOM 
            //Begin case Gravity.CENTER_VERTICAL 
            y = (getHeight() - height) / 2;
            //End case Gravity.CENTER_VERTICAL 
            int right = getWidth();
            checkMarkDrawable.setBounds(
                    right - mPaddingRight,
                    y, 
                    right - mPaddingRight + mCheckMarkWidth,
                    y + height);
            checkMarkDrawable.draw(canvas);
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.212 -0400", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "E38D9A26D93C1911D049590DDADCA421")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_1049913462 = (isChecked());
            {
                mergeDrawableStates(drawableState, CHECKED_STATE_SET);
            } //End block
        } //End collapsed parenthetic
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1767333738 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1767333738;
        // ---------- Original Method ----------
        //final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        //if (isChecked()) {
            //mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        //}
        //return drawableState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.212 -0400", hash_original_method = "856DABB8A541BB631DA077FA70F1A5D5", hash_generated_method = "2CF52B334B92448A055D811B503E9FDF")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            int[] myDrawableState = getDrawableState();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.213 -0400", hash_original_method = "E1DFB2AF73729EA8AA28BE1E77594577", hash_generated_method = "C5E84CDB159FDC21AE91720249A51759")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityEvent(event);
        event.setChecked(mChecked);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setChecked(mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.213 -0400", hash_original_method = "800F92BFA9EDE937B28EAF651D664B90", hash_generated_method = "1E9E6510BEF82BC9E7F95982E7F4BBA7")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPopulateAccessibilityEvent(event);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_1343938498 = (isChecked());
            {
                event.getText().add(mContext.getString(R.string.radiobutton_selected));
            } //End block
            {
                event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //if (isChecked()) {
            //event.getText().add(mContext.getString(R.string.radiobutton_selected));
        //} else {
            //event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.213 -0400", hash_original_method = "31E71954214D2E567F10971C83F42BE3", hash_generated_method = "33692B24ECBE73993DF36A49ECD612AC")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityNodeInfo(info);
        info.setChecked(mChecked);
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setChecked(mChecked);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.214 -0400", hash_original_field = "312B7CC8C1FC8133C5B1FE8103106614", hash_generated_field = "648B080756031EA789B9ECD9F36CC170")

    private static final int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
}

