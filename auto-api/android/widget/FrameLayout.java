package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.RemoteViews.RemoteView;

public class FrameLayout extends ViewGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.881 -0400", hash_original_field = "1FCB44928A1025EC3CED7E7B3EF3CA14", hash_generated_field = "CB728A1909AFA591F1BDDDA61ED16AE9")

    @ViewDebug.ExportedProperty(category = "measurement") boolean mMeasureAllChildren = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.881 -0400", hash_original_field = "608C3DF594AB00F368FD836319FA63D9", hash_generated_field = "A72F2658D002524E6BC635CECCB7A486")

    @ViewDebug.ExportedProperty(category = "drawing") private Drawable mForeground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.881 -0400", hash_original_field = "163DEF20C09AF3EFBF33581A095EFFFA", hash_generated_field = "953C36407EBD0C47819218A9CD301BFA")

    @ViewDebug.ExportedProperty(category = "padding") private int mForegroundPaddingLeft = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.881 -0400", hash_original_field = "3E38F16ED2754CE9270D75FF554FFB91", hash_generated_field = "79EB2E4D0FF51658B0F50685CFDA1E31")

    @ViewDebug.ExportedProperty(category = "padding") private int mForegroundPaddingTop = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.882 -0400", hash_original_field = "43D1A02A009450CA17A6DAAF2EC3A367", hash_generated_field = "41B6F60E8078397FAD791043A7BFAB92")

    @ViewDebug.ExportedProperty(category = "padding") private int mForegroundPaddingRight = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.882 -0400", hash_original_field = "E2116DEE1EF56E95B28758C32371276E", hash_generated_field = "309B58BFECE3A3BF4BE0489CD3C93C7D")

    @ViewDebug.ExportedProperty(category = "padding") private int mForegroundPaddingBottom = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.882 -0400", hash_original_field = "19D950E97D0D17ED8E5107FA45A5A3B0", hash_generated_field = "14261C060FA7F5DC9FDD430F3E263596")

    private Rect mSelfBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.882 -0400", hash_original_field = "5DC2AE490540E20EED1B653091500A0D", hash_generated_field = "6ECFA54A2FC60D83D3602A8BAA388D43")

    private Rect mOverlayBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.882 -0400", hash_original_field = "6FF555F85E4962DD94530BDC37E356B9", hash_generated_field = "59774B948EFD2881A9D01560DFF26466")

    @ViewDebug.ExportedProperty(category = "drawing") private int mForegroundGravity = Gravity.FILL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.882 -0400", hash_original_field = "504607E01FB347D4A6F34C13ADE75485", hash_generated_field = "5A930F164A8718372DFF326C35C33BAD")

    @ViewDebug.ExportedProperty(category = "drawing") protected boolean mForegroundInPadding = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.882 -0400", hash_original_field = "2CFBC409048E72602D4793E5B8DE7094", hash_generated_field = "706D65F3F8C11FED0C0076CC57F566C1")

    boolean mForegroundBoundsChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.882 -0400", hash_original_field = "B41FFA5B615CB946BED9B60A62509618", hash_generated_field = "7E5D64581E42460011217B67B3660493")

    private ArrayList<View> mMatchParentChildren = new ArrayList<View>(1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.882 -0400", hash_original_method = "C65968E2416D9A27DB8533C5F0C75B69", hash_generated_method = "DC88EE0252523A908E923E25C3B661EA")
    public  FrameLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.883 -0400", hash_original_method = "874EEAD1D73BF9A0D133CBC5B921EDD8", hash_generated_method = "3F5803BB0525E8A44D5B9F835F6A54FF")
    public  FrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.884 -0400", hash_original_method = "CEC811F1E2979D1B9B78B672C02AD5D3", hash_generated_method = "480D549CACDEBD7AFAF649EB06962CB7")
    public  FrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.FrameLayout,
                    defStyle, 0);
        mForegroundGravity = a.getInt(
                com.android.internal.R.styleable.FrameLayout_foregroundGravity, mForegroundGravity);
        Drawable d;
        d = a.getDrawable(com.android.internal.R.styleable.FrameLayout_foreground);
        {
            setForeground(d);
        } //End block
        {
            boolean var060BD58CD70382001F4DF1DEF51F4B47_1905109819 = (a.getBoolean(com.android.internal.R.styleable.FrameLayout_measureAllChildren, false));
            {
                setMeasureAllChildren(true);
            } //End block
        } //End collapsed parenthetic
        mForegroundInPadding = a.getBoolean(
                com.android.internal.R.styleable.FrameLayout_foregroundInsidePadding, true);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.FrameLayout,
                    //defStyle, 0);
        //mForegroundGravity = a.getInt(
                //com.android.internal.R.styleable.FrameLayout_foregroundGravity, mForegroundGravity);
        //final Drawable d = a.getDrawable(com.android.internal.R.styleable.FrameLayout_foreground);
        //if (d != null) {
            //setForeground(d);
        //}
        //if (a.getBoolean(com.android.internal.R.styleable.FrameLayout_measureAllChildren, false)) {
            //setMeasureAllChildren(true);
        //}
        //mForegroundInPadding = a.getBoolean(
                //com.android.internal.R.styleable.FrameLayout_foregroundInsidePadding, true);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.885 -0400", hash_original_method = "8BC875BA00D5710711DB00A919CACCE0", hash_generated_method = "752E13E2A2B776A0B0D08FD4200B0D16")
    @android.view.RemotableViewMethod
    public void setForegroundGravity(int foregroundGravity) {
        {
            {
                foregroundGravity |= Gravity.START;
            } //End block
            {
                foregroundGravity |= Gravity.TOP;
            } //End block
            mForegroundGravity = foregroundGravity;
            {
                Rect padding;
                padding = new Rect();
                {
                    boolean varEC4E72B2B4FAF413CB9D2BD426568F5B_861764868 = (mForeground.getPadding(padding));
                    {
                        mForegroundPaddingLeft = padding.left;
                        mForegroundPaddingTop = padding.top;
                        mForegroundPaddingRight = padding.right;
                        mForegroundPaddingBottom = padding.bottom;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mForegroundPaddingLeft = 0;
                mForegroundPaddingTop = 0;
                mForegroundPaddingRight = 0;
                mForegroundPaddingBottom = 0;
            } //End block
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.885 -0400", hash_original_method = "10BAAC6631BEDC803E3228221401304B", hash_generated_method = "48212DF878B83B7B810FCCFC6EFDFF92")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        boolean var5DDC393BAE0536F27182E72C3FC3DFA4_1302069976 = (super.verifyDrawable(who) || (who == mForeground));
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1413916228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1413916228;
        // ---------- Original Method ----------
        //return super.verifyDrawable(who) || (who == mForeground);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.886 -0400", hash_original_method = "583607554001D9F198CD54104E44B797", hash_generated_method = "CB2D19DEF124A6EF8070C12F720EBEA8")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mForeground.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mForeground != null) mForeground.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.886 -0400", hash_original_method = "D0BDA221075CF616F9E9A9FBE3F4B88A", hash_generated_method = "2E4FCE18350CF6BCB1D02D35E42B81F2")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            boolean varF047BC408D282175FD6894DD2CA5E4AA_260982989 = (mForeground != null && mForeground.isStateful());
            {
                mForeground.setState(getDrawableState());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //if (mForeground != null && mForeground.isStateful()) {
            //mForeground.setState(getDrawableState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.887 -0400", hash_original_method = "988BCAE6A6E42EFDC25DEBC315DD1190", hash_generated_method = "767D59C76D4D98CEA6EA9E031AB9E640")
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_519359946 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_519359946 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        varB4EAC82CA7396A68D541C85D26508E83_519359946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_519359946;
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.888 -0400", hash_original_method = "9754375AE3C405E0761F3FE1F1DE65D9", hash_generated_method = "31714C9826A0027B8AD9B8A2F2580F78")
    public void setForeground(Drawable drawable) {
        {
            {
                mForeground.setCallback(null);
                unscheduleDrawable(mForeground);
            } //End block
            mForeground = drawable;
            mForegroundPaddingLeft = 0;
            mForegroundPaddingTop = 0;
            mForegroundPaddingRight = 0;
            mForegroundPaddingBottom = 0;
            {
                setWillNotDraw(false);
                drawable.setCallback(this);
                {
                    boolean var7A233AAD91A9FC1732BFC704C20F2EC0_1806874539 = (drawable.isStateful());
                    {
                        drawable.setState(getDrawableState());
                    } //End block
                } //End collapsed parenthetic
                {
                    Rect padding;
                    padding = new Rect();
                    {
                        boolean var640F577FE90036D5B7F6C5FBC863E5E1_1468695678 = (drawable.getPadding(padding));
                        {
                            mForegroundPaddingLeft = padding.left;
                            mForegroundPaddingTop = padding.top;
                            mForegroundPaddingRight = padding.right;
                            mForegroundPaddingBottom = padding.bottom;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                setWillNotDraw(true);
            } //End block
            requestLayout();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.892 -0400", hash_original_method = "8DDBBCB9F2E6942D000521EEF66C0D86", hash_generated_method = "BA2222277412BDF8E526D818EBA79CC8")
    public Drawable getForeground() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_260684805 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_260684805 = mForeground;
        varB4EAC82CA7396A68D541C85D26508E83_260684805.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_260684805;
        // ---------- Original Method ----------
        //return mForeground;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.893 -0400", hash_original_method = "FF3A696BD56D74C1EF72BB71EC65ECEC", hash_generated_method = "2A662AEF4BB3A0DC2B83E4F4DC083AC4")
    private int getPaddingLeftWithForeground() {
        {
            Object var8418F173DB412201BC8297CCEF71A2D0_965397188 = (Math.max(mPaddingLeft, mForegroundPaddingLeft));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685238559 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685238559;
        // ---------- Original Method ----------
        //return mForegroundInPadding ? Math.max(mPaddingLeft, mForegroundPaddingLeft) :
            //mPaddingLeft + mForegroundPaddingLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.894 -0400", hash_original_method = "6F38D617A9DA11062600EF5C115E1518", hash_generated_method = "2A132BAB8958785C25E0B5F01850E7D8")
    private int getPaddingRightWithForeground() {
        {
            Object varDF068A7244503D471731ABCFF3C011C6_2036942176 = (Math.max(mPaddingRight, mForegroundPaddingRight));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749897551 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749897551;
        // ---------- Original Method ----------
        //return mForegroundInPadding ? Math.max(mPaddingRight, mForegroundPaddingRight) :
            //mPaddingRight + mForegroundPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.894 -0400", hash_original_method = "9A91E9D92D71EE5460C3A06ABC1FBD77", hash_generated_method = "538ACA7AA31D2C23F89D44223F478B68")
    private int getPaddingTopWithForeground() {
        {
            Object varEC4D518B0257A4830CF6F1BBCA4DFEDC_1602162489 = (Math.max(mPaddingTop, mForegroundPaddingTop));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704885615 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704885615;
        // ---------- Original Method ----------
        //return mForegroundInPadding ? Math.max(mPaddingTop, mForegroundPaddingTop) :
            //mPaddingTop + mForegroundPaddingTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.895 -0400", hash_original_method = "6BA199CF08BDB4F9A10CECB43AC6A7C1", hash_generated_method = "49403B46F74BB1D0F2A1E928F4397D2C")
    private int getPaddingBottomWithForeground() {
        {
            Object varD5F18AAE1C8F95C812828DD0D3D39BCF_261818371 = (Math.max(mPaddingBottom, mForegroundPaddingBottom));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228929423 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228929423;
        // ---------- Original Method ----------
        //return mForegroundInPadding ? Math.max(mPaddingBottom, mForegroundPaddingBottom) :
            //mPaddingBottom + mForegroundPaddingBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.898 -0400", hash_original_method = "5535255FB97D5EBC35FC058E1C30F774", hash_generated_method = "5795C5E25CE82A0C0483B5C7B402F92C")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int count;
        count = getChildCount();
        boolean measureMatchParentChildren;
        measureMatchParentChildren = MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.EXACTLY ||
                MeasureSpec.getMode(heightMeasureSpec) != MeasureSpec.EXACTLY;
        mMatchParentChildren.clear();
        int maxHeight;
        maxHeight = 0;
        int maxWidth;
        maxWidth = 0;
        int childState;
        childState = 0;
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var52D84F7738B8AF8E899201F04FE0F413_1804104272 = (mMeasureAllChildren || child.getVisibility() != GONE);
                    {
                        measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
                        LayoutParams lp;
                        lp = (LayoutParams) child.getLayoutParams();
                        maxWidth = Math.max(maxWidth,
                        child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin);
                        maxHeight = Math.max(maxHeight,
                        child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin);
                        childState = combineMeasuredStates(childState, child.getMeasuredState());
                        {
                            {
                                mMatchParentChildren.add(child);
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        maxWidth += getPaddingLeftWithForeground() + getPaddingRightWithForeground();
        maxHeight += getPaddingTopWithForeground() + getPaddingBottomWithForeground();
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        Drawable drawable;
        drawable = getForeground();
        {
            maxHeight = Math.max(maxHeight, drawable.getMinimumHeight());
            maxWidth = Math.max(maxWidth, drawable.getMinimumWidth());
        } //End block
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                resolveSizeAndState(maxHeight, heightMeasureSpec,
                        childState << MEASURED_HEIGHT_STATE_SHIFT));
        count = mMatchParentChildren.size();
        {
            {
                int i;
                i = 0;
                {
                    View child;
                    child = mMatchParentChildren.get(i);
                    MarginLayoutParams lp;
                    lp = (MarginLayoutParams) child.getLayoutParams();
                    int childWidthMeasureSpec;
                    int childHeightMeasureSpec;
                    {
                        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth() -
                            getPaddingLeftWithForeground() - getPaddingRightWithForeground() -
                            lp.leftMargin - lp.rightMargin,
                            MeasureSpec.EXACTLY);
                    } //End block
                    {
                        childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                            getPaddingLeftWithForeground() + getPaddingRightWithForeground() +
                            lp.leftMargin + lp.rightMargin,
                            lp.width);
                    } //End block
                    {
                        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight() -
                            getPaddingTopWithForeground() - getPaddingBottomWithForeground() -
                            lp.topMargin - lp.bottomMargin,
                            MeasureSpec.EXACTLY);
                    } //End block
                    {
                        childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec,
                            getPaddingTopWithForeground() + getPaddingBottomWithForeground() +
                            lp.topMargin + lp.bottomMargin,
                            lp.height);
                    } //End block
                    child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.902 -0400", hash_original_method = "E7FA69BF1895927226A22DFF32FA5B4F", hash_generated_method = "0B487664CC163C27C510C43C55E63F69")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int count;
        count = getChildCount();
        int parentLeft;
        parentLeft = getPaddingLeftWithForeground();
        int parentRight;
        parentRight = right - left - getPaddingRightWithForeground();
        int parentTop;
        parentTop = getPaddingTopWithForeground();
        int parentBottom;
        parentBottom = bottom - top - getPaddingBottomWithForeground();
        mForegroundBoundsChanged = true;
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1296632410 = (child.getVisibility() != GONE);
                    {
                        LayoutParams lp;
                        lp = (LayoutParams) child.getLayoutParams();
                        int width;
                        width = child.getMeasuredWidth();
                        int height;
                        height = child.getMeasuredHeight();
                        int childLeft;
                        int childTop;
                        int gravity;
                        gravity = lp.gravity;
                        {
                            gravity = DEFAULT_CHILD_GRAVITY;
                        } //End block
                        int layoutDirection;
                        layoutDirection = getResolvedLayoutDirection();
                        int absoluteGravity;
                        absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
                        int verticalGravity;
                        verticalGravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;
                        //Begin case Gravity.LEFT 
                        childLeft = parentLeft + lp.leftMargin;
                        //End case Gravity.LEFT 
                        //Begin case Gravity.CENTER_HORIZONTAL 
                        childLeft = parentLeft + (parentRight - parentLeft - width) / 2 +
                        lp.leftMargin - lp.rightMargin;
                        //End case Gravity.CENTER_HORIZONTAL 
                        //Begin case Gravity.RIGHT 
                        childLeft = parentRight - width - lp.rightMargin;
                        //End case Gravity.RIGHT 
                        //Begin case default 
                        childLeft = parentLeft + lp.leftMargin;
                        //End case default 
                        //Begin case Gravity.TOP 
                        childTop = parentTop + lp.topMargin;
                        //End case Gravity.TOP 
                        //Begin case Gravity.CENTER_VERTICAL 
                        childTop = parentTop + (parentBottom - parentTop - height) / 2 +
                        lp.topMargin - lp.bottomMargin;
                        //End case Gravity.CENTER_VERTICAL 
                        //Begin case Gravity.BOTTOM 
                        childTop = parentBottom - height - lp.bottomMargin;
                        //End case Gravity.BOTTOM 
                        //Begin case default 
                        childTop = parentTop + lp.topMargin;
                        //End case default 
                        child.layout(childLeft, childTop, childLeft + width, childTop + height);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(changed);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.902 -0400", hash_original_method = "4AC6B20E904606B8A51AEBBB15006C72", hash_generated_method = "BE4B6509F1E2A843DAFF11D6A4A4998C")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSizeChanged(w, h, oldw, oldh);
        mForegroundBoundsChanged = true;
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, oldw, oldh);
        //mForegroundBoundsChanged = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.903 -0400", hash_original_method = "6D753914B55367AEDC866ACE8B2692D8", hash_generated_method = "8626D9F14F0C746ECA03AEF3123EBB36")
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        {
            Drawable foreground;
            foreground = mForeground;
            {
                mForegroundBoundsChanged = false;
                Rect selfBounds;
                selfBounds = mSelfBounds;
                Rect overlayBounds;
                overlayBounds = mOverlayBounds;
                int w;
                w = mRight-mLeft;
                int h;
                h = mBottom-mTop;
                {
                    selfBounds.set(0, 0, w, h);
                } //End block
                {
                    selfBounds.set(mPaddingLeft, mPaddingTop, w - mPaddingRight, h - mPaddingBottom);
                } //End block
                int layoutDirection;
                layoutDirection = getResolvedLayoutDirection();
                Gravity.apply(mForegroundGravity, foreground.getIntrinsicWidth(),
                        foreground.getIntrinsicHeight(), selfBounds, overlayBounds,
                        layoutDirection);
                foreground.setBounds(overlayBounds);
            } //End block
            foreground.draw(canvas);
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.976 -0400", hash_original_method = "89E57DF442BD7C3C4F7FCB93934115A6", hash_generated_method = "E138172EE06E80DB25AFC00487B37D34")
    @Override
    public boolean gatherTransparentRegion(Region region) {
        boolean opaque;
        opaque = super.gatherTransparentRegion(region);
        {
            applyDrawableToTransparentRegion(mForeground, region);
        } //End block
        addTaint(region.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_926931586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_926931586;
        // ---------- Original Method ----------
        //boolean opaque = super.gatherTransparentRegion(region);
        //if (region != null && mForeground != null) {
            //applyDrawableToTransparentRegion(mForeground, region);
        //}
        //return opaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.977 -0400", hash_original_method = "F157652BCC07DCD3C1A1E63F95BA7504", hash_generated_method = "35F4313BD098BAEC40FB26B8C2BFA441")
    @android.view.RemotableViewMethod
    public void setMeasureAllChildren(boolean measureAll) {
        mMeasureAllChildren = measureAll;
        // ---------- Original Method ----------
        //mMeasureAllChildren = measureAll;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.977 -0400", hash_original_method = "E2FDB5CCBB08727222AD77E37CF74AF8", hash_generated_method = "065E837A56FE6A5ADCD77AA6CF44F705")
    @Deprecated
    public boolean getConsiderGoneChildrenWhenMeasuring() {
        boolean var9F57B6D4A5A1C146ADB9D4B74E243376_1676465655 = (getMeasureAllChildren());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_531494621 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_531494621;
        // ---------- Original Method ----------
        //return getMeasureAllChildren();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.978 -0400", hash_original_method = "52ECFF8459DAA24A15017A3D3C6FE0BF", hash_generated_method = "3D0C1A495C0714097F396643769F2FF6")
    public boolean getMeasureAllChildren() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955202723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_955202723;
        // ---------- Original Method ----------
        //return mMeasureAllChildren;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.988 -0400", hash_original_method = "A40DD32EC45E4EF4D9BB874732A909D0", hash_generated_method = "18BC343890FA49CCFAD0513EEB418A5F")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_944953124 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_944953124 = new FrameLayout.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_944953124.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_944953124;
        // ---------- Original Method ----------
        //return new FrameLayout.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.991 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "70A7D0E6699FE41235F8B7DCA4D0E01E")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146258902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146258902;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.991 -0400", hash_original_method = "E5E3FCBA546B7CFE2F525BEFE910A396", hash_generated_method = "AD691899FEF836434C518BB3D32BE2CB")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951488717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951488717;
        // ---------- Original Method ----------
        //return p instanceof LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.992 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "90D7229C0E8E36CE4C0947849F9B9DFD")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_2033424454 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2033424454 = new LayoutParams(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2033424454.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2033424454;
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    public static class LayoutParams extends MarginLayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.992 -0400", hash_original_field = "CF0F2AF9EE62920A17A205053A2F0423", hash_generated_field = "5DA573F10ADDA42A543DD86752A07C7B")

        public int gravity = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.992 -0400", hash_original_method = "8477494D7C126F8EB5E8F09916E06813", hash_generated_method = "ABC85F238D6D86B603112F260B606AD9")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a;
            a = c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.FrameLayout_Layout);
            gravity = a.getInt(com.android.internal.R.styleable.FrameLayout_Layout_layout_gravity, -1);
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            //TypedArray a = c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.FrameLayout_Layout);
            //gravity = a.getInt(com.android.internal.R.styleable.FrameLayout_Layout_layout_gravity, -1);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.993 -0400", hash_original_method = "B179862558DB9232A546423CE2E9C45B", hash_generated_method = "B7C15C290F0CE95521BABC50AEDAF12F")
        public  LayoutParams(int width, int height) {
            super(width, height);
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.993 -0400", hash_original_method = "DAE5F643078D3DA273ACC6BEF5E44EF2", hash_generated_method = "C357A3787BC69F6F5D2217C4533A3061")
        public  LayoutParams(int width, int height, int gravity) {
            super(width, height);
            this.gravity = gravity;
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
            //this.gravity = gravity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.999 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.005 -0400", hash_original_method = "600A366FF17B7D40DFA738E77A628E8F", hash_generated_method = "B2D13AC5BD03A134B95617DAFA8D7AF6")
        public  LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.005 -0400", hash_original_field = "7B8936C6ACB113C10746D2FF6B47F698", hash_generated_field = "264A56041FEEDBB004DB4A5AADCAF96B")

    private static int DEFAULT_CHILD_GRAVITY = Gravity.TOP | Gravity.LEFT;
}

