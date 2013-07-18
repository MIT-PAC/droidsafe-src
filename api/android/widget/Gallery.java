package android.widget;

// Droidsafe Imports
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Transformation;

import com.android.internal.R;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Gallery extends AbsSpinner implements GestureDetector.OnGestureListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.959 -0400", hash_original_field = "6DC725832F5B3B080EE2613EA52A5C9F", hash_generated_field = "6908B47F1286FF0E8F257052A45F19C3")

    private int mSpacing = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.959 -0400", hash_original_field = "3515BA7A1D53977E7846189FAEF3BA75", hash_generated_field = "7DDC30AC361091A9B237602A7998D4FE")

    private int mAnimationDuration = 400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.959 -0400", hash_original_field = "005E6A2CE9829D8D9CADF3BF52E0A49C", hash_generated_field = "16F130EDB3F8F019BBCA898590B37D9A")

    private float mUnselectedAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.959 -0400", hash_original_field = "54B20719002B5E5AED4F9994135CC0BC", hash_generated_field = "E0ED55B65924CD7E2D39F0DD730F1D49")

    private int mLeftMost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.959 -0400", hash_original_field = "AC9EE6B57B9A56017AC3BD6C5D94B7C8", hash_generated_field = "943D3EE9E3A99AC4AE3E674CB5292A7B")

    private int mRightMost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.959 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "ACF14A395FB2702990553CD0EFA1BDCC")

    private int mGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.959 -0400", hash_original_field = "EBDAC0BE41D965D60A46156878A6BB30", hash_generated_field = "DA7C2146C29AB67A18FA4519D8BF6725")

    private GestureDetector mGestureDetector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.959 -0400", hash_original_field = "78D1B59E3E6030D35632C44F7E01DCBB", hash_generated_field = "48D58026A8B3F70D3312B75231403F47")

    private int mDownTouchPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.959 -0400", hash_original_field = "EC23162B75347EC5C6B61328EDA504CC", hash_generated_field = "E5931B84C9656513FA35F3B36B7A34ED")

    private View mDownTouchView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.959 -0400", hash_original_field = "FA9A86BA70D5703F05F951D15D2DD88A", hash_generated_field = "287089796DE9AC8B1BED30B6D71A8BCF")

    private FlingRunnable mFlingRunnable = new FlingRunnable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.960 -0400", hash_original_field = "CA72A41BFA85D123FCEBDA446C142B0D", hash_generated_field = "7D17FC7B784C4DFE85940485A53D6A7C")

    private Runnable mDisableSuppressSelectionChangedRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.960 -0400", hash_original_method = "6390BF84CDDE59DC47728D8159023DBB", hash_generated_method = "ECE2EF39C8709685F79A0417D45A4F28")
        @Override
        public void run() {
            mSuppressSelectionChanged = false;
            selectionChanged();
            // ---------- Original Method ----------
            //mSuppressSelectionChanged = false;
            //selectionChanged();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.960 -0400", hash_original_field = "9AFB09E196FF7F87E5C80A6F43D99221", hash_generated_field = "4F33C08AF070CABF3FDDD85E87BAE951")

    private boolean mShouldStopFling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.960 -0400", hash_original_field = "4353E8466E8A0746EB4E7997B626ADD3", hash_generated_field = "F58C1145D53A71FE5D77D5307858E3E5")

    private View mSelectedChild;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.960 -0400", hash_original_field = "0096B31040C4EE199999F90E8D2A3AB0", hash_generated_field = "32030A2B3ED2EA65C29B698806417240")

    private boolean mShouldCallbackDuringFling = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.960 -0400", hash_original_field = "6E6A94A73F886334D2EB99FD1FD167CF", hash_generated_field = "F31BFDB883A3EF2414ED5384B6FD1E82")

    private boolean mShouldCallbackOnUnselectedItemClick = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.960 -0400", hash_original_field = "5334D7CB4B10F097E2265C60D59BE66F", hash_generated_field = "DC1B7A71E07C07D553D8BFB5CAB0B978")

    private boolean mSuppressSelectionChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.961 -0400", hash_original_field = "7987FEB6B759521B7AE9DF20A3A41926", hash_generated_field = "E9741D547D745DB9FE491BC5B86C4FBF")

    private boolean mReceivedInvokeKeyDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.961 -0400", hash_original_field = "1CA13E81CA7384C6552732232F3C09B5", hash_generated_field = "66F1ED7DD74887E9F376183A8E9DD9C2")

    private AdapterContextMenuInfo mContextMenuInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.961 -0400", hash_original_field = "1BE9CE6C6C13D6507601D1D459282995", hash_generated_field = "853C1D061612824EBF4A0E2663C313BA")

    private boolean mIsFirstScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.961 -0400", hash_original_field = "C06F32324460C32F2BECD659C22F25A2", hash_generated_field = "DDDFBF43887528504DF780774BEC6E8B")

    private boolean mIsRtl = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.961 -0400", hash_original_method = "475E2614DCD8BCA86D0A9A2D522E9160", hash_generated_method = "3FE9C7B57E3A0C01D255C91313AD940B")
    public  Gallery(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.961 -0400", hash_original_method = "6F70D7EE2D6B35912A9443CBD20034EA", hash_generated_method = "87507E3BDD7D3CC1721F0A8C62DBA1E6")
    public  Gallery(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.galleryStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.962 -0400", hash_original_method = "D87B27451B638EC2EE79D6B32CF2AC05", hash_generated_method = "0AD7F16E2DD854A6BBC28CC7D4CA68ED")
    public  Gallery(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        mGestureDetector = new GestureDetector(context, this);
        mGestureDetector.setIsLongpressEnabled(true);
        TypedArray a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.Gallery, defStyle, 0);
        int index = a.getInt(com.android.internal.R.styleable.Gallery_gravity, -1);
        if(index >= 0)        
        {
            setGravity(index);
        } //End block
        int animationDuration = a.getInt(com.android.internal.R.styleable.Gallery_animationDuration, -1);
        if(animationDuration > 0)        
        {
            setAnimationDuration(animationDuration);
        } //End block
        int spacing = a.getDimensionPixelOffset(com.android.internal.R.styleable.Gallery_spacing, 0);
        setSpacing(spacing);
        float unselectedAlpha = a.getFloat(
                com.android.internal.R.styleable.Gallery_unselectedAlpha, 0.5f);
        setUnselectedAlpha(unselectedAlpha);
        a.recycle();
        mGroupFlags |= FLAG_USE_CHILD_DRAWING_ORDER;
        mGroupFlags |= FLAG_SUPPORT_STATIC_TRANSFORMATIONS;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.963 -0400", hash_original_method = "BF4DA518E23220545D4D17CD06D2812B", hash_generated_method = "D56B37D33A4BD574498F7D8C381FC944")
    public void setCallbackDuringFling(boolean shouldCallback) {
        mShouldCallbackDuringFling = shouldCallback;
        // ---------- Original Method ----------
        //mShouldCallbackDuringFling = shouldCallback;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.964 -0400", hash_original_method = "35BE7A0536455C2A0F09BBAE9D2D6389", hash_generated_method = "552C154AE8B581BE7D6F22B71B4C35B7")
    public void setCallbackOnUnselectedItemClick(boolean shouldCallback) {
        mShouldCallbackOnUnselectedItemClick = shouldCallback;
        // ---------- Original Method ----------
        //mShouldCallbackOnUnselectedItemClick = shouldCallback;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.965 -0400", hash_original_method = "C4B72670DAE1EC61056CA78802FA094C", hash_generated_method = "5F42FA869055CEC6FB96D8D2AF86E4BA")
    public void setAnimationDuration(int animationDurationMillis) {
        mAnimationDuration = animationDurationMillis;
        // ---------- Original Method ----------
        //mAnimationDuration = animationDurationMillis;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.965 -0400", hash_original_method = "5E8A11776A8EA8D02696ABF29BE14ED6", hash_generated_method = "98230DB68B4E7101A953393C53021668")
    public void setSpacing(int spacing) {
        mSpacing = spacing;
        // ---------- Original Method ----------
        //mSpacing = spacing;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.966 -0400", hash_original_method = "4DB3B67BF1B9A3FA2A4736C5F1CFBEA1", hash_generated_method = "763050E91CF0B8A093C85CDB8EAB65F9")
    public void setUnselectedAlpha(float unselectedAlpha) {
        mUnselectedAlpha = unselectedAlpha;
        // ---------- Original Method ----------
        //mUnselectedAlpha = unselectedAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.966 -0400", hash_original_method = "8BDE9EE3EBF8484A23D1B160F2ED960C", hash_generated_method = "86E4594D18D25E8E675E908705B6253B")
    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        addTaint(t.getTaint());
        addTaint(child.getTaint());
        t.clear();
        t.setAlpha(child == mSelectedChild ? 1.0f : mUnselectedAlpha);
        boolean varB326B5062B2F0E69046810717534CB09_1782280685 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966651867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_966651867;
        // ---------- Original Method ----------
        //t.clear();
        //t.setAlpha(child == mSelectedChild ? 1.0f : mUnselectedAlpha);
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.966 -0400", hash_original_method = "79AE40AE7044F70B8A2DE0C11DA2A6EC", hash_generated_method = "9745B508A3BE06F30BF4B302C64B6E06")
    @Override
    protected int computeHorizontalScrollExtent() {
        int varC4CA4238A0B923820DCC509A6F75849B_740469235 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1723392879 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1723392879;
        // ---------- Original Method ----------
        //return 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.967 -0400", hash_original_method = "2692EBC36C6BF52C61AC22E6B166DF8E", hash_generated_method = "24D63EAD378D245F0A29E7A292321DA1")
    @Override
    protected int computeHorizontalScrollOffset() {
        int var390A3127D73EBF1C2FE439B9B7D711F9_297048054 = (mSelectedPosition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505825596 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505825596;
        // ---------- Original Method ----------
        //return mSelectedPosition;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.967 -0400", hash_original_method = "80D0AAD3D44B58246BF39F244D8B4F36", hash_generated_method = "51C83EF092DB9C4FFB6AC541FFFBE7F0")
    @Override
    protected int computeHorizontalScrollRange() {
        int varA7392E7FB156CE90DBA601C30BDAD9A0_797857338 = (mItemCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090977783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090977783;
        // ---------- Original Method ----------
        //return mItemCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.967 -0400", hash_original_method = "E5E3FCBA546B7CFE2F525BEFE910A396", hash_generated_method = "B8FED4C31647A282DDF28D908C8C1E06")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var440AF75A2CDC0C5127161CA01BB77E89_164082402 = (p instanceof LayoutParams);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057607398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057607398;
        // ---------- Original Method ----------
        //return p instanceof LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.967 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "60D3D9EFF1D1A3FB8A518C1C58AED24F")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
ViewGroup.LayoutParams varB945D213E5036F8DDF9B40811234DF64_2066121916 =         new LayoutParams(p);
        varB945D213E5036F8DDF9B40811234DF64_2066121916.addTaint(taint);
        return varB945D213E5036F8DDF9B40811234DF64_2066121916;
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.968 -0400", hash_original_method = "1C9B9BBEC46A39865FCD3A7288415ECD", hash_generated_method = "DEF7E9896080A89AC3BDE2BF9251D455")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
ViewGroup.LayoutParams var023B3FAAA9940C6DE114BF4C9FED2D73_267481086 =         new LayoutParams(getContext(), attrs);
        var023B3FAAA9940C6DE114BF4C9FED2D73_267481086.addTaint(taint);
        return var023B3FAAA9940C6DE114BF4C9FED2D73_267481086;
        // ---------- Original Method ----------
        //return new LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.968 -0400", hash_original_method = "45A5836088105736B1AA4CBE86661268", hash_generated_method = "4F3794103DD78380ED8A30EDD6671BEA")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
ViewGroup.LayoutParams var0E5E9DBC9A91B6980D7680DC45274DA4_1757700585 =         new Gallery.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        var0E5E9DBC9A91B6980D7680DC45274DA4_1757700585.addTaint(taint);
        return var0E5E9DBC9A91B6980D7680DC45274DA4_1757700585;
        // ---------- Original Method ----------
        //return new Gallery.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                //ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.969 -0400", hash_original_method = "2F25E46AB3A307ED9F0C91E6C81BDCD4", hash_generated_method = "323BD35E0292D6B6549E04FE095F2399")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.969 -0400", hash_original_method = "44D3B1A6F440757321735895159CF3F5", hash_generated_method = "91039BE4F52E41A9E8A3581D34F79FC0")
    @Override
     int getChildHeight(View child) {
        addTaint(child.getTaint());
        int var4E2C59BAAB25C5B90D5B4A9309C0D212_122859431 = (child.getMeasuredHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886825249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886825249;
        // ---------- Original Method ----------
        //return child.getMeasuredHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.969 -0400", hash_original_method = "CF0F4FD99D6D1B74E2AB7A4A0D0FE283", hash_generated_method = "6B7C6CD7C1C68A9A20C58C4136D64E23")
     void trackMotionScroll(int deltaX) {
        addTaint(deltaX);
        if(getChildCount() == 0)        
        {
            return;
        } //End block
        boolean toLeft = deltaX < 0;
        int limitedDeltaX = getLimitedMotionScrollAmount(toLeft, deltaX);
        if(limitedDeltaX != deltaX)        
        {
            mFlingRunnable.endFling(false);
            onFinishedMovement();
        } //End block
        offsetChildrenLeftAndRight(limitedDeltaX);
        detachOffScreenChildren(toLeft);
        if(toLeft)        
        {
            fillToGalleryRight();
        } //End block
        else
        {
            fillToGalleryLeft();
        } //End block
        mRecycler.clear();
        setSelectionToCenterChild();
        onScrollChanged(0, 0, 0, 0);
        invalidate();
        // ---------- Original Method ----------
        //if (getChildCount() == 0) {
            //return;
        //}
        //boolean toLeft = deltaX < 0;
        //int limitedDeltaX = getLimitedMotionScrollAmount(toLeft, deltaX);
        //if (limitedDeltaX != deltaX) {
            //mFlingRunnable.endFling(false);
            //onFinishedMovement();
        //}
        //offsetChildrenLeftAndRight(limitedDeltaX);
        //detachOffScreenChildren(toLeft);
        //if (toLeft) {
            //fillToGalleryRight();
        //} else {
            //fillToGalleryLeft();
        //}
        //mRecycler.clear();
        //setSelectionToCenterChild();
        //onScrollChanged(0, 0, 0, 0);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.970 -0400", hash_original_method = "1E51C3862CE74D6B831F0305D11D86D1", hash_generated_method = "D2DADD0A92E17154EBE9D21A9EF47FCE")
     int getLimitedMotionScrollAmount(boolean motionToLeft, int deltaX) {
        addTaint(deltaX);
        addTaint(motionToLeft);
        int extremeItemPosition = motionToLeft != mIsRtl ? mItemCount - 1 : 0;
        View extremeChild = getChildAt(extremeItemPosition - mFirstPosition);
        if(extremeChild == null)        
        {
            int var0C3297563A2E9DA0C4E9D8AB04E8A05F_1373625164 = (deltaX);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250602541 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250602541;
        } //End block
        int extremeChildCenter = getCenterOfView(extremeChild);
        int galleryCenter = getCenterOfGallery();
        if(motionToLeft)        
        {
            if(extremeChildCenter <= galleryCenter)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_738530911 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665194868 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665194868;
            } //End block
        } //End block
        else
        {
            if(extremeChildCenter >= galleryCenter)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_552457037 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847376984 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847376984;
            } //End block
        } //End block
        int centerDifference = galleryCenter - extremeChildCenter;
        int var74BB1985A4DC14E6ADB864ED96B29CD8_466910475 = (motionToLeft
                ? Math.max(centerDifference, deltaX)
                : Math.min(centerDifference, deltaX));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96829918 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96829918;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.970 -0400", hash_original_method = "4EEE31555E188404F99AA8E4E9247689", hash_generated_method = "B4FF60E68B2B487C705498DA19B9CC64")
    private void offsetChildrenLeftAndRight(int offset) {
        addTaint(offset);
for(int i = getChildCount() - 1;i >= 0;i--)
        {
            getChildAt(i).offsetLeftAndRight(offset);
        } //End block
        // ---------- Original Method ----------
        //for (int i = getChildCount() - 1; i >= 0; i--) {
            //getChildAt(i).offsetLeftAndRight(offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.971 -0400", hash_original_method = "7DE2375AA3E30D760C22927E49BD5683", hash_generated_method = "7FB7AE1167B34CD3D717863FFCD38303")
    private int getCenterOfGallery() {
        int varCC504A711E41EAFC3DDCBC48F0B7AD18_80529671 = ((getWidth() - mPaddingLeft - mPaddingRight) / 2 + mPaddingLeft);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595749926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595749926;
        // ---------- Original Method ----------
        //return (getWidth() - mPaddingLeft - mPaddingRight) / 2 + mPaddingLeft;
    }

    
    private static int getCenterOfView(View view) {
        return view.getLeft() + view.getWidth() / 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.972 -0400", hash_original_method = "D8B7CD82B13D6307CBAC6FD1D2419AAD", hash_generated_method = "5C06473A32D7045E4B5A67B124CDA994")
    private void detachOffScreenChildren(boolean toLeft) {
        addTaint(toLeft);
        int numChildren = getChildCount();
        int firstPosition = mFirstPosition;
        int start = 0;
        int count = 0;
        if(toLeft)        
        {
            final int galleryLeft = mPaddingLeft;
for(int i = 0;i < numChildren;i++)
            {
                int n = mIsRtl ? (numChildren - 1 - i) : i;
                final View child = getChildAt(n);
                if(child.getRight() >= galleryLeft)                
                {
                    break;
                } //End block
                else
                {
                    start = n;
                    count++;
                    mRecycler.put(firstPosition + n, child);
                } //End block
            } //End block
            if(!mIsRtl)            
            {
                start = 0;
            } //End block
        } //End block
        else
        {
            final int galleryRight = getWidth() - mPaddingRight;
for(int i = numChildren - 1;i >= 0;i--)
            {
                int n = mIsRtl ? numChildren - 1 - i : i;
                final View child = getChildAt(n);
                if(child.getLeft() <= galleryRight)                
                {
                    break;
                } //End block
                else
                {
                    start = n;
                    count++;
                    mRecycler.put(firstPosition + n, child);
                } //End block
            } //End block
            if(mIsRtl)            
            {
                start = 0;
            } //End block
        } //End block
        detachViewsFromParent(start, count);
        if(toLeft != mIsRtl)        
        {
            mFirstPosition += count;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.973 -0400", hash_original_method = "7B136AF27CDBDA451A86F0C558D92536", hash_generated_method = "90E8F307021C25EE70741B197829E0ED")
    private void scrollIntoSlots() {
        if(getChildCount() == 0 || mSelectedChild == null)        
        return;
        int selectedCenter = getCenterOfView(mSelectedChild);
        int targetCenter = getCenterOfGallery();
        int scrollAmount = targetCenter - selectedCenter;
        if(scrollAmount != 0)        
        {
            mFlingRunnable.startUsingDistance(scrollAmount);
        } //End block
        else
        {
            onFinishedMovement();
        } //End block
        // ---------- Original Method ----------
        //if (getChildCount() == 0 || mSelectedChild == null) return;
        //int selectedCenter = getCenterOfView(mSelectedChild);
        //int targetCenter = getCenterOfGallery();
        //int scrollAmount = targetCenter - selectedCenter;
        //if (scrollAmount != 0) {
            //mFlingRunnable.startUsingDistance(scrollAmount);
        //} else {
            //onFinishedMovement();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.973 -0400", hash_original_method = "73E6CA1691599BC4ECD7D5DB3D8073AD", hash_generated_method = "5C57DDDE9F33A3D152E2C32BD3F093BD")
    private void onFinishedMovement() {
        if(mSuppressSelectionChanged)        
        {
            mSuppressSelectionChanged = false;
            super.selectionChanged();
        } //End block
        invalidate();
        // ---------- Original Method ----------
        //if (mSuppressSelectionChanged) {
            //mSuppressSelectionChanged = false;
            //super.selectionChanged();
        //}
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.974 -0400", hash_original_method = "FFD143793C4BF3C1C0F88DAC5604B8EB", hash_generated_method = "6CD3D165F124BFDFBEF515A6208448E1")
    @Override
     void selectionChanged() {
        if(!mSuppressSelectionChanged)        
        {
            super.selectionChanged();
        } //End block
        // ---------- Original Method ----------
        //if (!mSuppressSelectionChanged) {
            //super.selectionChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.975 -0400", hash_original_method = "99F459BBFD91AC2E00EAA95D53F6B222", hash_generated_method = "371A0B5DF13FABE807E30233DFA72111")
    private void setSelectionToCenterChild() {
        View selView = mSelectedChild;
        if(mSelectedChild == null)        
        return;
        int galleryCenter = getCenterOfGallery();
        if(selView.getLeft() <= galleryCenter && selView.getRight() >= galleryCenter)        
        {
            return;
        } //End block
        int closestEdgeDistance = Integer.MAX_VALUE;
        int newSelectedChildIndex = 0;
for(int i = getChildCount() - 1;i >= 0;i--)
        {
            View child = getChildAt(i);
            if(child.getLeft() <= galleryCenter && child.getRight() >=  galleryCenter)            
            {
                newSelectedChildIndex = i;
                break;
            } //End block
            int childClosestEdgeDistance = Math.min(Math.abs(child.getLeft() - galleryCenter),
                    Math.abs(child.getRight() - galleryCenter));
            if(childClosestEdgeDistance < closestEdgeDistance)            
            {
                closestEdgeDistance = childClosestEdgeDistance;
                newSelectedChildIndex = i;
            } //End block
        } //End block
        int newPos = mFirstPosition + newSelectedChildIndex;
        if(newPos != mSelectedPosition)        
        {
            setSelectedPositionInt(newPos);
            setNextSelectedPositionInt(newPos);
            checkSelectionChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.977 -0400", hash_original_method = "D35D4AE43FE4EA4BE64F388903B9B437", hash_generated_method = "62F0CD6BF227BFF161A754587C583AB0")
    @Override
     void layout(int delta, boolean animate) {
        addTaint(animate);
        addTaint(delta);
        mIsRtl = isLayoutRtl();
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
        detachAllViewsFromParent();
        mRightMost = 0;
        mLeftMost = 0;
        mFirstPosition = mSelectedPosition;
        View sel = makeAndAddView(mSelectedPosition, 0, 0, true);
        int selectedOffset = childrenLeft + (childrenWidth / 2) - (sel.getWidth() / 2);
        sel.offsetLeftAndRight(selectedOffset);
        fillToGalleryRight();
        fillToGalleryLeft();
        mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        mDataChanged = false;
        mNeedSync = false;
        setNextSelectedPositionInt(mSelectedPosition);
        updateSelectedItemMetadata();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.977 -0400", hash_original_method = "839F6A1D55F5AD62226A4A3F94B7F961", hash_generated_method = "CF59417698DD96E3E535A8FA747AB88D")
    private void fillToGalleryLeft() {
        if(mIsRtl)        
        {
            fillToGalleryLeftRtl();
        } //End block
        else
        {
            fillToGalleryLeftLtr();
        } //End block
        // ---------- Original Method ----------
        //if (mIsRtl) {
            //fillToGalleryLeftRtl();
        //} else {
            //fillToGalleryLeftLtr();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.979 -0400", hash_original_method = "D862865A48DB37456DB450C522985E2D", hash_generated_method = "DE2F6B56B29CD218FFD89F2B1B057F44")
    private void fillToGalleryLeftRtl() {
        int itemSpacing = mSpacing;
        int galleryLeft = mPaddingLeft;
        int numChildren = getChildCount();
        int numItems = mItemCount;
        View prevIterationView = getChildAt(numChildren - 1);
        int curPosition;
        int curRightEdge;
        if(prevIterationView != null)        
        {
            curPosition = mFirstPosition + numChildren;
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
        } //End block
        else
        {
            mFirstPosition = curPosition = mItemCount - 1;
            curRightEdge = mRight - mLeft - mPaddingRight;
            mShouldStopFling = true;
        } //End block
        while
(curRightEdge > galleryLeft && curPosition < mItemCount)        
        {
            prevIterationView = makeAndAddView(curPosition, curPosition - mSelectedPosition,
                    curRightEdge, false);
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
            curPosition++;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.980 -0400", hash_original_method = "0FAB0D6FB4467E7662D35717D4E5328D", hash_generated_method = "A3C95F025D7C8006032AD8DEEA2F5256")
    private void fillToGalleryLeftLtr() {
        int itemSpacing = mSpacing;
        int galleryLeft = mPaddingLeft;
        View prevIterationView = getChildAt(0);
        int curPosition;
        int curRightEdge;
        if(prevIterationView != null)        
        {
            curPosition = mFirstPosition - 1;
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
        } //End block
        else
        {
            curPosition = 0;
            curRightEdge = mRight - mLeft - mPaddingRight;
            mShouldStopFling = true;
        } //End block
        while
(curRightEdge > galleryLeft && curPosition >= 0)        
        {
            prevIterationView = makeAndAddView(curPosition, curPosition - mSelectedPosition,
                    curRightEdge, false);
            mFirstPosition = curPosition;
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
            curPosition--;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.980 -0400", hash_original_method = "4542FD5BB1889445E8F3BFB504C9CA2C", hash_generated_method = "BF1B560FCC8DA0BFA1C1397388A66E35")
    private void fillToGalleryRight() {
        if(mIsRtl)        
        {
            fillToGalleryRightRtl();
        } //End block
        else
        {
            fillToGalleryRightLtr();
        } //End block
        // ---------- Original Method ----------
        //if (mIsRtl) {
            //fillToGalleryRightRtl();
        //} else {
            //fillToGalleryRightLtr();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.981 -0400", hash_original_method = "ACF31DBB20E84F8382BE455EB92D3A14", hash_generated_method = "EA14D1A8DC752B45D2DF540AE62219B3")
    private void fillToGalleryRightRtl() {
        int itemSpacing = mSpacing;
        int galleryRight = mRight - mLeft - mPaddingRight;
        View prevIterationView = getChildAt(0);
        int curPosition;
        int curLeftEdge;
        if(prevIterationView != null)        
        {
            curPosition = mFirstPosition -1;
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
        } //End block
        else
        {
            curPosition = 0;
            curLeftEdge = mPaddingLeft;
            mShouldStopFling = true;
        } //End block
        while
(curLeftEdge < galleryRight && curPosition >= 0)        
        {
            prevIterationView = makeAndAddView(curPosition, curPosition - mSelectedPosition,
                    curLeftEdge, true);
            mFirstPosition = curPosition;
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
            curPosition--;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.983 -0400", hash_original_method = "79C0AF4129796B1D40A0EF3F484CF7D9", hash_generated_method = "A349FAC09FCEE91F15C48C76FD4BD257")
    private void fillToGalleryRightLtr() {
        int itemSpacing = mSpacing;
        int galleryRight = mRight - mLeft - mPaddingRight;
        int numChildren = getChildCount();
        int numItems = mItemCount;
        View prevIterationView = getChildAt(numChildren - 1);
        int curPosition;
        int curLeftEdge;
        if(prevIterationView != null)        
        {
            curPosition = mFirstPosition + numChildren;
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
        } //End block
        else
        {
            mFirstPosition = curPosition = mItemCount - 1;
            curLeftEdge = mPaddingLeft;
            mShouldStopFling = true;
        } //End block
        while
(curLeftEdge < galleryRight && curPosition < numItems)        
        {
            prevIterationView = makeAndAddView(curPosition, curPosition - mSelectedPosition,
                    curLeftEdge, true);
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
            curPosition++;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.985 -0400", hash_original_method = "EBA268158DBADCF4BD34E1D13045F6D1", hash_generated_method = "69F867DD57E626B1BAF7E04D28DD7E8B")
    private View makeAndAddView(int position, int offset, int x, boolean fromLeft) {
        addTaint(fromLeft);
        addTaint(x);
        addTaint(offset);
        addTaint(position);
        View child;
        if(!mDataChanged)        
        {
            child = mRecycler.get(position);
            if(child != null)            
            {
                int childLeft = child.getLeft();
                mRightMost = Math.max(mRightMost, childLeft 
                        + child.getMeasuredWidth());
                mLeftMost = Math.min(mLeftMost, childLeft);
                setUpChild(child, offset, x, fromLeft);
View var73902FD3E151130B4329B76EF04D2A54_808346937 =                 child;
                var73902FD3E151130B4329B76EF04D2A54_808346937.addTaint(taint);
                return var73902FD3E151130B4329B76EF04D2A54_808346937;
            } //End block
        } //End block
        child = mAdapter.getView(position, null, this);
        setUpChild(child, offset, x, fromLeft);
View var73902FD3E151130B4329B76EF04D2A54_2055962923 =         child;
        var73902FD3E151130B4329B76EF04D2A54_2055962923.addTaint(taint);
        return var73902FD3E151130B4329B76EF04D2A54_2055962923;
        // ---------- Original Method ----------
        //View child;
        //if (!mDataChanged) {
            //child = mRecycler.get(position);
            //if (child != null) {
                //int childLeft = child.getLeft();
                //mRightMost = Math.max(mRightMost, childLeft 
                        //+ child.getMeasuredWidth());
                //mLeftMost = Math.min(mLeftMost, childLeft);
                //setUpChild(child, offset, x, fromLeft);
                //return child;
            //}
        //}
        //child = mAdapter.getView(position, null, this);
        //setUpChild(child, offset, x, fromLeft);
        //return child;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.988 -0400", hash_original_method = "3126A82E5C4A08FF6B321D23FF86AF72", hash_generated_method = "A43DB38DDE069F981D30AA92F5B67AB0")
    private void setUpChild(View child, int offset, int x, boolean fromLeft) {
        addTaint(fromLeft);
        addTaint(x);
        addTaint(offset);
        addTaint(child.getTaint());
        Gallery.LayoutParams lp = (Gallery.LayoutParams) child.getLayoutParams();
        if(lp == null)        
        {
            lp = (Gallery.LayoutParams) generateDefaultLayoutParams();
        } //End block
        addViewInLayout(child, fromLeft != mIsRtl ? -1 : 0, lp);
        child.setSelected(offset == 0);
        int childHeightSpec = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec,
                mSpinnerPadding.top + mSpinnerPadding.bottom, lp.height);
        int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mSpinnerPadding.left + mSpinnerPadding.right, lp.width);
        child.measure(childWidthSpec, childHeightSpec);
        int childLeft;
        int childRight;
        int childTop = calculateTop(child, true);
        int childBottom = childTop + child.getMeasuredHeight();
        int width = child.getMeasuredWidth();
        if(fromLeft)        
        {
            childLeft = x;
            childRight = childLeft + width;
        } //End block
        else
        {
            childLeft = x - width;
            childRight = x;
        } //End block
        child.layout(childLeft, childTop, childRight, childBottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.990 -0400", hash_original_method = "D35AB7435540D0F4BFFD2328F86D6A01", hash_generated_method = "69434EDE0D44609078F6082A7FA7D1DF")
    private int calculateTop(View child, boolean duringLayout) {
        addTaint(duringLayout);
        addTaint(child.getTaint());
        int myHeight = duringLayout ? getMeasuredHeight() : getHeight();
        int childHeight = duringLayout ? child.getMeasuredHeight() : child.getHeight();
        int childTop = 0;
switch(mGravity){
        case Gravity.TOP:
        childTop = mSpinnerPadding.top;
        break;
        case Gravity.CENTER_VERTICAL:
        int availableSpace = myHeight - mSpinnerPadding.bottom
                    - mSpinnerPadding.top - childHeight;
        childTop = mSpinnerPadding.top + (availableSpace / 2);
        break;
        case Gravity.BOTTOM:
        childTop = myHeight - mSpinnerPadding.bottom - childHeight;
        break;
}        int var4B0473872FCF6B3BEF99D6F9DAA6D410_2002156395 = (childTop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681532455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681532455;
        // ---------- Original Method ----------
        //int myHeight = duringLayout ? getMeasuredHeight() : getHeight();
        //int childHeight = duringLayout ? child.getMeasuredHeight() : child.getHeight();
        //int childTop = 0;
        //switch (mGravity) {
        //case Gravity.TOP:
            //childTop = mSpinnerPadding.top;
            //break;
        //case Gravity.CENTER_VERTICAL:
            //int availableSpace = myHeight - mSpinnerPadding.bottom
                    //- mSpinnerPadding.top - childHeight;
            //childTop = mSpinnerPadding.top + (availableSpace / 2);
            //break;
        //case Gravity.BOTTOM:
            //childTop = myHeight - mSpinnerPadding.bottom - childHeight;
            //break;
        //}
        //return childTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.991 -0400", hash_original_method = "E3817DF605584D2699E850A6FB85E3EE", hash_generated_method = "555B368A6B70E5508A9B7C8BFDC1BB84")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean retValue = mGestureDetector.onTouchEvent(event);
        int action = event.getAction();
        if(action == MotionEvent.ACTION_UP)        
        {
            onUp();
        } //End block
        else
        if(action == MotionEvent.ACTION_CANCEL)        
        {
            onCancel();
        } //End block
        boolean var9C7BD17E8EB1C3D0F843684A79A18570_700732616 = (retValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873843393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_873843393;
        // ---------- Original Method ----------
        //boolean retValue = mGestureDetector.onTouchEvent(event);
        //int action = event.getAction();
        //if (action == MotionEvent.ACTION_UP) {
            //onUp();
        //} else if (action == MotionEvent.ACTION_CANCEL) {
            //onCancel();
        //}
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.991 -0400", hash_original_method = "19210549229636CE2242C372109B66CE", hash_generated_method = "E895B2B0562DF3BA9DB6CF88D6506240")
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(e.getTaint());
        if(mDownTouchPosition >= 0)        
        {
            scrollToChild(mDownTouchPosition - mFirstPosition);
            if(mShouldCallbackOnUnselectedItemClick || mDownTouchPosition == mSelectedPosition)            
            {
                performItemClick(mDownTouchView, mDownTouchPosition, mAdapter
                        .getItemId(mDownTouchPosition));
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_796043054 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446894453 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_446894453;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_761064687 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_498722750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_498722750;
        // ---------- Original Method ----------
        //if (mDownTouchPosition >= 0) {
            //scrollToChild(mDownTouchPosition - mFirstPosition);
            //if (mShouldCallbackOnUnselectedItemClick || mDownTouchPosition == mSelectedPosition) {
                //performItemClick(mDownTouchView, mDownTouchPosition, mAdapter
                        //.getItemId(mDownTouchPosition));
            //}
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.992 -0400", hash_original_method = "FF9AB11CCCE118D19142CC6F38731AB8", hash_generated_method = "6F6895EDB0B70E49FB52613EA164887F")
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(velocityY);
        addTaint(velocityX);
        addTaint(e2.getTaint());
        addTaint(e1.getTaint());
        if(!mShouldCallbackDuringFling)        
        {
            removeCallbacks(mDisableSuppressSelectionChangedRunnable);
            if(!mSuppressSelectionChanged)            
            mSuppressSelectionChanged = true;
        } //End block
        mFlingRunnable.startUsingVelocity((int) -velocityX);
        boolean varB326B5062B2F0E69046810717534CB09_1890804438 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_437104464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_437104464;
        // ---------- Original Method ----------
        //if (!mShouldCallbackDuringFling) {
            //removeCallbacks(mDisableSuppressSelectionChangedRunnable);
            //if (!mSuppressSelectionChanged) mSuppressSelectionChanged = true;
        //}
        //mFlingRunnable.startUsingVelocity((int) -velocityX);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.993 -0400", hash_original_method = "31AEC3B6889F8B31520E6C555165373C", hash_generated_method = "014DCC380256B4766AA86EE844F1C426")
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(distanceY);
        addTaint(distanceX);
        addTaint(e2.getTaint());
        addTaint(e1.getTaint());
        if(localLOGV){ }        mParent.requestDisallowInterceptTouchEvent(true);
        if(!mShouldCallbackDuringFling)        
        {
            if(mIsFirstScroll)            
            {
                if(!mSuppressSelectionChanged)                
                mSuppressSelectionChanged = true;
                postDelayed(mDisableSuppressSelectionChangedRunnable, SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT);
            } //End block
        } //End block
        else
        {
            if(mSuppressSelectionChanged)            
            mSuppressSelectionChanged = false;
        } //End block
        trackMotionScroll(-1 * (int) distanceX);
        mIsFirstScroll = false;
        boolean varB326B5062B2F0E69046810717534CB09_1713913497 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1541830786 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1541830786;
        // ---------- Original Method ----------
        //if (localLOGV) Log.v(TAG, String.valueOf(e2.getX() - e1.getX()));
        //mParent.requestDisallowInterceptTouchEvent(true);
        //if (!mShouldCallbackDuringFling) {
            //if (mIsFirstScroll) {
                //if (!mSuppressSelectionChanged) mSuppressSelectionChanged = true;
                //postDelayed(mDisableSuppressSelectionChangedRunnable, SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT);
            //}
        //} else {
            //if (mSuppressSelectionChanged) mSuppressSelectionChanged = false;
        //}
        //trackMotionScroll(-1 * (int) distanceX);
        //mIsFirstScroll = false;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.994 -0400", hash_original_method = "79E55760FD5CE82C40C265BE8CDD4846", hash_generated_method = "9B76033C58250AB1CE4E3B432876BC6F")
    @Override
    public boolean onDown(MotionEvent e) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mFlingRunnable.stop(false);
        mDownTouchPosition = pointToPosition((int) e.getX(), (int) e.getY());
        if(mDownTouchPosition >= 0)        
        {
            mDownTouchView = getChildAt(mDownTouchPosition - mFirstPosition);
            mDownTouchView.setPressed(true);
        } //End block
        mIsFirstScroll = true;
        boolean varB326B5062B2F0E69046810717534CB09_978988794 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737952753 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737952753;
        // ---------- Original Method ----------
        //mFlingRunnable.stop(false);
        //mDownTouchPosition = pointToPosition((int) e.getX(), (int) e.getY());
        //if (mDownTouchPosition >= 0) {
            //mDownTouchView = getChildAt(mDownTouchPosition - mFirstPosition);
            //mDownTouchView.setPressed(true);
        //}
        //mIsFirstScroll = true;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.994 -0400", hash_original_method = "DF867D53E770A9464F52B7BCD42362AA", hash_generated_method = "D6DC9AC0979E4C9A52A4EF75B8DE2FA7")
     void onUp() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mFlingRunnable.mScroller.isFinished())        
        {
            scrollIntoSlots();
        } //End block
        dispatchUnpress();
        // ---------- Original Method ----------
        //if (mFlingRunnable.mScroller.isFinished()) {
            //scrollIntoSlots();
        //}
        //dispatchUnpress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.994 -0400", hash_original_method = "BB906BFFF3DF010D02CEEC7D1D49931B", hash_generated_method = "1073DF63F78E31D42C25A568BFC2BB53")
     void onCancel() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onUp();
        // ---------- Original Method ----------
        //onUp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.994 -0400", hash_original_method = "950A20F4ED2CBD08065028F466CBAED0", hash_generated_method = "5A0F8F59CA19D0132F0BDC878AAF9F3C")
    @Override
    public void onLongPress(MotionEvent e) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(e.getTaint());
        if(mDownTouchPosition < 0)        
        {
            return;
        } //End block
        performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        long id = getItemIdAtPosition(mDownTouchPosition);
        dispatchLongPress(mDownTouchView, mDownTouchPosition, id);
        // ---------- Original Method ----------
        //if (mDownTouchPosition < 0) {
            //return;
        //}
        //performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        //long id = getItemIdAtPosition(mDownTouchPosition);
        //dispatchLongPress(mDownTouchView, mDownTouchPosition, id);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.994 -0400", hash_original_method = "54A2BF3809B435C5302401FC76B54B22", hash_generated_method = "D6238B30A6D80D1CDAF043F75E6DDF2F")
    @Override
    public void onShowPress(MotionEvent e) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.994 -0400", hash_original_method = "1D9BFD40F04CA79251504E98D313D5F0", hash_generated_method = "EAEC22E60462F167D2B83C37F43C1951")
    private void dispatchPress(View child) {
        addTaint(child.getTaint());
        if(child != null)        
        {
            child.setPressed(true);
        } //End block
        setPressed(true);
        // ---------- Original Method ----------
        //if (child != null) {
            //child.setPressed(true);
        //}
        //setPressed(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.994 -0400", hash_original_method = "E1E46A91FBA826DABF74EF3365F5DA5C", hash_generated_method = "FDD9C9A56D57371C39F9D63B3F2000C3")
    private void dispatchUnpress() {
for(int i = getChildCount() - 1;i >= 0;i--)
        {
            getChildAt(i).setPressed(false);
        } //End block
        setPressed(false);
        // ---------- Original Method ----------
        //for (int i = getChildCount() - 1; i >= 0; i--) {
            //getChildAt(i).setPressed(false);
        //}
        //setPressed(false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.994 -0400", hash_original_method = "64CD219059FB9E526665FE8867E1D4B8", hash_generated_method = "69A1E092A9FD19851CCBC34FC11C3A7F")
    @Override
    public void dispatchSetSelected(boolean selected) {
        addTaint(selected);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.994 -0400", hash_original_method = "E41129AA485100A2EB69B5BDBC887DF8", hash_generated_method = "F0F6296659BC5062FE1D057B54A05FA5")
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        addTaint(pressed);
        if(mSelectedChild != null)        
        {
            mSelectedChild.setPressed(pressed);
        } //End block
        // ---------- Original Method ----------
        //if (mSelectedChild != null) {
            //mSelectedChild.setPressed(pressed);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.994 -0400", hash_original_method = "9F181134B78CDA48AEB577EDC6EC32D7", hash_generated_method = "A472DE5C0E684468916232AA39A28483")
    @Override
    protected ContextMenuInfo getContextMenuInfo() {
ContextMenuInfo varE506317E2879F3E77DE1B46834975588_1636623534 =         mContextMenuInfo;
        varE506317E2879F3E77DE1B46834975588_1636623534.addTaint(taint);
        return varE506317E2879F3E77DE1B46834975588_1636623534;
        // ---------- Original Method ----------
        //return mContextMenuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.995 -0400", hash_original_method = "DF59CF50500B4E9CE839452AD8F1A8F9", hash_generated_method = "8340AE7C39AAC3A6949A81C0A7BC80FE")
    @Override
    public boolean showContextMenuForChild(View originalView) {
        addTaint(originalView.getTaint());
        final int longPressPosition = getPositionForView(originalView);
        if(longPressPosition < 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1047418029 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867514206 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_867514206;
        } //End block
        final long longPressId = mAdapter.getItemId(longPressPosition);
        boolean var8399A52E5D7853F9ED2C01A1A111BC3A_1141583524 = (dispatchLongPress(originalView, longPressPosition, longPressId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310770085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310770085;
        // ---------- Original Method ----------
        //final int longPressPosition = getPositionForView(originalView);
        //if (longPressPosition < 0) {
            //return false;
        //}
        //final long longPressId = mAdapter.getItemId(longPressPosition);
        //return dispatchLongPress(originalView, longPressPosition, longPressId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.995 -0400", hash_original_method = "13C9F6F3E3362B5D837B194E32B9E579", hash_generated_method = "C16E8F411293DC886A827A657A5317B5")
    @Override
    public boolean showContextMenu() {
        if(isPressed() && mSelectedPosition >= 0)        
        {
            int index = mSelectedPosition - mFirstPosition;
            View v = getChildAt(index);
            boolean varDC5C18B977CF23D054F9E04AAD215A68_1361927230 = (dispatchLongPress(v, mSelectedPosition, mSelectedRowId));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1017704935 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1017704935;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1655874935 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943619505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_943619505;
        // ---------- Original Method ----------
        //if (isPressed() && mSelectedPosition >= 0) {
            //int index = mSelectedPosition - mFirstPosition;
            //View v = getChildAt(index);
            //return dispatchLongPress(v, mSelectedPosition, mSelectedRowId);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.995 -0400", hash_original_method = "087BDC5665C59A77437D4D81045FF0E8", hash_generated_method = "0C8C679A5C304D287353FD59F90D131D")
    private boolean dispatchLongPress(View view, int position, long id) {
        boolean handled = false;
        if(mOnItemLongClickListener != null)        
        {
            handled = mOnItemLongClickListener.onItemLongClick(this, mDownTouchView,
                    mDownTouchPosition, id);
        } //End block
        if(!handled)        
        {
            mContextMenuInfo = new AdapterContextMenuInfo(view, position, id);
            handled = super.showContextMenuForChild(this);
        } //End block
        if(handled)        
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1755946203 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356041647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356041647;
        // ---------- Original Method ----------
        //boolean handled = false;
        //if (mOnItemLongClickListener != null) {
            //handled = mOnItemLongClickListener.onItemLongClick(this, mDownTouchView,
                    //mDownTouchPosition, id);
        //}
        //if (!handled) {
            //mContextMenuInfo = new AdapterContextMenuInfo(view, position, id);
            //handled = super.showContextMenuForChild(this);
        //}
        //if (handled) {
            //performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.996 -0400", hash_original_method = "3AE09BEF1C913F03964B3B1FAAECBEDB", hash_generated_method = "986E6300BF741C0D51D89B3FC48AB67C")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean var8219CC95284A1C3FDD4CE753F725A74F_1549137635 = (event.dispatch(this, null, null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938363488 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938363488;
        // ---------- Original Method ----------
        //return event.dispatch(this, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.996 -0400", hash_original_method = "869521EFCB7C5245B063DFB17EC10284", hash_generated_method = "AD2EFD5EE8B0F36C919A98951ACCC671")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_LEFT:
        if(movePrevious())        
        {
            playSoundEffect(SoundEffectConstants.NAVIGATION_LEFT);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_712167326 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961820152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961820152;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        if(moveNext())        
        {
            playSoundEffect(SoundEffectConstants.NAVIGATION_RIGHT);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1042475747 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1601839080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1601839080;
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_ENTER:
        mReceivedInvokeKeyDown = true;
}        boolean var947F0C250323B9F4475E02588E9A9740_155026302 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1969213330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1969213330;
        // ---------- Original Method ----------
        //switch (keyCode) {
        //case KeyEvent.KEYCODE_DPAD_LEFT:
            //if (movePrevious()) {
                //playSoundEffect(SoundEffectConstants.NAVIGATION_LEFT);
            //}
            //return true;
        //case KeyEvent.KEYCODE_DPAD_RIGHT:
            //if (moveNext()) {
                //playSoundEffect(SoundEffectConstants.NAVIGATION_RIGHT);
            //}
            //return true;
        //case KeyEvent.KEYCODE_DPAD_CENTER:
        //case KeyEvent.KEYCODE_ENTER:
            //mReceivedInvokeKeyDown = true;
        //}
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.996 -0400", hash_original_method = "35A1E5E2696C4EED13BCBB9C99C03D0D", hash_generated_method = "4072936F57EF7FF7947D1B3D641122B7")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_ENTER:
        {
            if(mReceivedInvokeKeyDown)            
            {
                if(mItemCount > 0)                
                {
                    dispatchPress(mSelectedChild);
                    postDelayed(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.996 -0400", hash_original_method = "258FEB3FDE513D1F7C9F200AA4FA4DE8", hash_generated_method = "A5FAEB5332F93BD50FB98CE51F955A84")
        @Override
        public void run() {
            dispatchUnpress();
            // ---------- Original Method ----------
            //dispatchUnpress();
        }
}, ViewConfiguration.getPressedStateDuration());
                    int selectedIndex = mSelectedPosition - mFirstPosition;
                    performItemClick(getChildAt(selectedIndex), mSelectedPosition, mAdapter
                            .getItemId(mSelectedPosition));
                } //End block
            } //End block
            mReceivedInvokeKeyDown = false;
            boolean varB326B5062B2F0E69046810717534CB09_126517236 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_11297118 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_11297118;
        } //End block
}        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_117296271 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1134498739 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1134498739;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.997 -0400", hash_original_method = "B9B4077A4E7C2CAD102566E406F7FE8F", hash_generated_method = "FFCD63B7426A07E6CC32DDD2F38EBF82")
     boolean movePrevious() {
        if(mItemCount > 0 && mSelectedPosition > 0)        
        {
            scrollToChild(mSelectedPosition - mFirstPosition - 1);
            boolean varB326B5062B2F0E69046810717534CB09_683439550 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_150952892 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_150952892;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_160036029 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_582914620 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_582914620;
        } //End block
        // ---------- Original Method ----------
        //if (mItemCount > 0 && mSelectedPosition > 0) {
            //scrollToChild(mSelectedPosition - mFirstPosition - 1);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.997 -0400", hash_original_method = "AB8E3EDC49D155A48AE82C24C38C480C", hash_generated_method = "C57328FF2A58B0044C9DB02D03A13E91")
     boolean moveNext() {
        if(mItemCount > 0 && mSelectedPosition < mItemCount - 1)        
        {
            scrollToChild(mSelectedPosition - mFirstPosition + 1);
            boolean varB326B5062B2F0E69046810717534CB09_1038075286 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1339327161 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1339327161;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_16717439 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1908995413 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1908995413;
        } //End block
        // ---------- Original Method ----------
        //if (mItemCount > 0 && mSelectedPosition < mItemCount - 1) {
            //scrollToChild(mSelectedPosition - mFirstPosition + 1);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.997 -0400", hash_original_method = "5A90FC6E5774B3D3ABB7606C34F54E47", hash_generated_method = "01351D6BD9707A7D96FEFCF3E17D85FC")
    private boolean scrollToChild(int childPosition) {
        addTaint(childPosition);
        View child = getChildAt(childPosition);
        if(child != null)        
        {
            int distance = getCenterOfGallery() - getCenterOfView(child);
            mFlingRunnable.startUsingDistance(distance);
            boolean varB326B5062B2F0E69046810717534CB09_1240416218 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509495339 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509495339;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_248475153 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1633963991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1633963991;
        // ---------- Original Method ----------
        //View child = getChildAt(childPosition);
        //if (child != null) {
            //int distance = getCenterOfGallery() - getCenterOfView(child);
            //mFlingRunnable.startUsingDistance(distance);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.997 -0400", hash_original_method = "82657633CA542FCF70C69B7A0BF2796A", hash_generated_method = "4D47807C7E1A72D37C57F4452896E08B")
    @Override
     void setSelectedPositionInt(int position) {
        addTaint(position);
        super.setSelectedPositionInt(position);
        updateSelectedItemMetadata();
        // ---------- Original Method ----------
        //super.setSelectedPositionInt(position);
        //updateSelectedItemMetadata();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.997 -0400", hash_original_method = "5BE8AB05B464B00AB61974AD30001B4B", hash_generated_method = "3020C447302D405D55A4A5260ACFBA31")
    private void updateSelectedItemMetadata() {
        View oldSelectedChild = mSelectedChild;
        View child = mSelectedChild = getChildAt(mSelectedPosition - mFirstPosition);
        if(child == null)        
        {
            return;
        } //End block
        child.setSelected(true);
        child.setFocusable(true);
        if(hasFocus())        
        {
            child.requestFocus();
        } //End block
        if(oldSelectedChild != null && oldSelectedChild != child)        
        {
            oldSelectedChild.setSelected(false);
            oldSelectedChild.setFocusable(false);
        } //End block
        // ---------- Original Method ----------
        //View oldSelectedChild = mSelectedChild;
        //View child = mSelectedChild = getChildAt(mSelectedPosition - mFirstPosition);
        //if (child == null) {
            //return;
        //}
        //child.setSelected(true);
        //child.setFocusable(true);
        //if (hasFocus()) {
            //child.requestFocus();
        //}
        //if (oldSelectedChild != null && oldSelectedChild != child) {
            //oldSelectedChild.setSelected(false);
            //oldSelectedChild.setFocusable(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.998 -0400", hash_original_method = "9F21F0E85C8E2888CEB908FEF2F39583", hash_generated_method = "E9FF7714D8371514AF730284D36BAA0E")
    public void setGravity(int gravity) {
        if(mGravity != gravity)        
        {
            mGravity = gravity;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mGravity != gravity) {
            //mGravity = gravity;
            //requestLayout();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.998 -0400", hash_original_method = "34F7E6D982F42148FE21035817D6C89A", hash_generated_method = "2FB53F2B8AA8CA6D2A82C51E9A366A27")
    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        addTaint(i);
        addTaint(childCount);
        int selectedIndex = mSelectedPosition - mFirstPosition;
        if(selectedIndex < 0)        
        {
        int var865C0C0B4AB0E063E5CAA3387C1A8741_254984424 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847318873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847318873;
        }
        if(i == childCount - 1)        
        {
            int varEA1250E55952DE7199AC5AC2A9953EC8_600390584 = (selectedIndex);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695143580 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695143580;
        } //End block
        else
        if(i >= selectedIndex)        
        {
            int var11C19633C6D7B85EEC5EFAFDD655392D_226054801 = (i + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755713651 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755713651;
        } //End block
        else
        {
            int var865C0C0B4AB0E063E5CAA3387C1A8741_1501726633 = (i);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2094198126 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2094198126;
        } //End block
        // ---------- Original Method ----------
        //int selectedIndex = mSelectedPosition - mFirstPosition;
        //if (selectedIndex < 0) return i;
        //if (i == childCount - 1) {
            //return selectedIndex;
        //} else if (i >= selectedIndex) {
            //return i + 1;
        //} else {
            //return i;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.998 -0400", hash_original_method = "4530040537B7815650EC9BAF20F8ED51", hash_generated_method = "D78048A2D652DE875B8E11F6F969E54D")
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(gainFocus);
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if(gainFocus && mSelectedChild != null)        
        {
            mSelectedChild.requestFocus(direction);
            mSelectedChild.setSelected(true);
        } //End block
        // ---------- Original Method ----------
        //super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        //if (gainFocus && mSelectedChild != null) {
            //mSelectedChild.requestFocus(direction);
            //mSelectedChild.setSelected(true);
        //}
    }

    
    private class FlingRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.998 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "AB39B37744A8B63C82246C1F6FE6730F")

        private Scroller mScroller;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.998 -0400", hash_original_field = "ED4C7C0AF2B4058DA7A81D6B00E1CF24", hash_generated_field = "F42B0D92269D459078CB705414F5747B")

        private int mLastFlingX;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.998 -0400", hash_original_method = "264C65CD320EB0D5C27B975805273D03", hash_generated_method = "3890D6A739BEE9F55D8EBDFF700BF0A2")
        public  FlingRunnable() {
            mScroller = new Scroller(getContext());
            // ---------- Original Method ----------
            //mScroller = new Scroller(getContext());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.998 -0400", hash_original_method = "3F5AABA0482FB6C4BDC6EF9DB417DE5D", hash_generated_method = "67FE411D3FD4C90A959B874B2370595A")
        private void startCommon() {
            removeCallbacks(this);
            // ---------- Original Method ----------
            //removeCallbacks(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.999 -0400", hash_original_method = "955705EE1931522BF2E85D1EE1E713EB", hash_generated_method = "5B82C33E8AEB8B35BB7EE4AC6B5C8648")
        public void startUsingVelocity(int initialVelocity) {
            addTaint(initialVelocity);
            if(initialVelocity == 0)            
            return;
            startCommon();
            int initialX = initialVelocity < 0 ? Integer.MAX_VALUE : 0;
            mLastFlingX = initialX;
            mScroller.fling(initialX, 0, initialVelocity, 0,
                    0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            post(this);
            // ---------- Original Method ----------
            //if (initialVelocity == 0) return;
            //startCommon();
            //int initialX = initialVelocity < 0 ? Integer.MAX_VALUE : 0;
            //mLastFlingX = initialX;
            //mScroller.fling(initialX, 0, initialVelocity, 0,
                    //0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            //post(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.999 -0400", hash_original_method = "6C25F473B54155D80760EA13DABD7B6F", hash_generated_method = "97E8F069F2F42EC47F5431EFC0D8E97A")
        public void startUsingDistance(int distance) {
            addTaint(distance);
            if(distance == 0)            
            return;
            startCommon();
            mLastFlingX = 0;
            mScroller.startScroll(0, 0, -distance, 0, mAnimationDuration);
            post(this);
            // ---------- Original Method ----------
            //if (distance == 0) return;
            //startCommon();
            //mLastFlingX = 0;
            //mScroller.startScroll(0, 0, -distance, 0, mAnimationDuration);
            //post(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.999 -0400", hash_original_method = "6E0F8E80A40548586D045381AEB2168E", hash_generated_method = "B3E0C402EB92914BCA135977FE9ED944")
        public void stop(boolean scrollIntoSlots) {
            addTaint(scrollIntoSlots);
            removeCallbacks(this);
            endFling(scrollIntoSlots);
            // ---------- Original Method ----------
            //removeCallbacks(this);
            //endFling(scrollIntoSlots);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.999 -0400", hash_original_method = "E61C8A0CE9EFA11B9E0089A9EE90DD3F", hash_generated_method = "532563EFCD2AEDD47CBCEF6552672C34")
        private void endFling(boolean scrollIntoSlots) {
            addTaint(scrollIntoSlots);
            mScroller.forceFinished(true);
            if(scrollIntoSlots)            
            scrollIntoSlots();
            // ---------- Original Method ----------
            //mScroller.forceFinished(true);
            //if (scrollIntoSlots) scrollIntoSlots();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.000 -0400", hash_original_method = "201C15A7F851961F5BCBCACEEAE4B252", hash_generated_method = "0C56B862C141A655018DFA1EA1BD82CA")
        @Override
        public void run() {
            if(mItemCount == 0)            
            {
                endFling(true);
                return;
            } //End block
            mShouldStopFling = false;
            final Scroller scroller = mScroller;
            boolean more = scroller.computeScrollOffset();
            final int x = scroller.getCurrX();
            int delta = mLastFlingX - x;
            if(delta > 0)            
            {
                mDownTouchPosition = mIsRtl ? (mFirstPosition + getChildCount() - 1) :
                    mFirstPosition;
                delta = Math.min(getWidth() - mPaddingLeft - mPaddingRight - 1, delta);
            } //End block
            else
            {
                int offsetToLast = getChildCount() - 1;
                mDownTouchPosition = mIsRtl ? mFirstPosition :
                    (mFirstPosition + getChildCount() - 1);
                delta = Math.max(-(getWidth() - mPaddingRight - mPaddingLeft - 1), delta);
            } //End block
            trackMotionScroll(delta);
            if(more && !mShouldStopFling)            
            {
                mLastFlingX = x;
                post(this);
            } //End block
            else
            {
                endFling(true);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.000 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "7441F800C0B184928DB48A9DD8178D32")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.000 -0400", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "503F8BCA6BB39449EFF41178BE64A21C")
        public  LayoutParams(int w, int h) {
            super(w, h);
            addTaint(h);
            addTaint(w);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.000 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.000 -0400", hash_original_field = "5BCA8DC133F932D88FE29EEBC5B02093", hash_generated_field = "86E3B6121245E31C4D677E593D737E58")

    private static final String TAG = "Gallery";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.000 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "761D2619615A389BF902F171CC86D6A4")

    private static final boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.000 -0400", hash_original_field = "A3AAF23DE154EF5561DF0F494D04F3A4", hash_generated_field = "F9ED17A16043F2269968A297C3B5536A")

    private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
}

