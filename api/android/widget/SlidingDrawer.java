package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;





public class SlidingDrawer extends ViewGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.577 -0500", hash_original_field = "52A309EB0E3683A7462D15119396AD5F", hash_generated_field = "F5AA8D432C85B67F2F1A59A2F86C9B4F")

    public static final int ORIENTATION_HORIZONTAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.579 -0500", hash_original_field = "676F5EBA34BAB3502E0DFDCC4B4606F0", hash_generated_field = "F0C280EF3D60F4930A958E8EA2B6AC4A")

    public static final int ORIENTATION_VERTICAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.581 -0500", hash_original_field = "EADF3C7F3211EA17C7FCEBC67445B288", hash_generated_field = "EF82FF38C70F34E835AAF92E9AE79EDE")


    private static final int TAP_THRESHOLD = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.584 -0500", hash_original_field = "54B063A7D518B74A6B80D015E6553350", hash_generated_field = "D63B1940B01FABB1E3D03EB23FE92832")

    private static final float MAXIMUM_TAP_VELOCITY = 100.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.586 -0500", hash_original_field = "20118533161DD5750DD37B5DEA9E4FF8", hash_generated_field = "3CE2263AFD5CC3F61D8EFDE0F528424B")

    private static final float MAXIMUM_MINOR_VELOCITY = 150.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.588 -0500", hash_original_field = "89723E0F7B94A3C2FE40E9184B50994C", hash_generated_field = "9699AD213AD4F0D7F391F37EE0845A2D")

    private static final float MAXIMUM_MAJOR_VELOCITY = 200.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.591 -0500", hash_original_field = "4ACA44ACDBC842C6933B79872ECCAF62", hash_generated_field = "4793378A0C07082335C6CA4C8526E5BF")

    private static final float MAXIMUM_ACCELERATION = 2000.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.594 -0500", hash_original_field = "FADCEB008686ADC68F08BC69A26D6FB1", hash_generated_field = "E448E4650222F119FB5A37956DC5373B")

    private static final int VELOCITY_UNITS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.596 -0500", hash_original_field = "7CAD2A8D8718D307BE2F1F827FB38505", hash_generated_field = "EE1617BC1FEDDA2BA932DADB3D158B26")

    private static final int MSG_ANIMATE = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.599 -0500", hash_original_field = "23F28D8E9B94339414AB54A838946DD0", hash_generated_field = "2D5E1661995D2C98C7D09C38F816B311")

    private static final int ANIMATION_FRAME_DURATION = 1000 / 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.601 -0500", hash_original_field = "479381BF4F6561B8F12F5483DB06EB06", hash_generated_field = "E6DD03D94ACD8E70EDDDE338DBF27AAF")


    private static final int EXPANDED_FULL_OPEN = -10001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.604 -0500", hash_original_field = "7E13E789246F51504E39551DBDC0E584", hash_generated_field = "B95F2443D5297E62D43F7D70D6A2C6EF")

    private static final int COLLAPSED_FULL_CLOSED = -10002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.606 -0500", hash_original_field = "58CEF23BC59A1B596AC12727233F23D8", hash_generated_field = "B9AD435137DADE0845830F9270F70E30")


    private  int mHandleId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.608 -0500", hash_original_field = "C8C1FE0E40EAC80B8BC996A81A376870", hash_generated_field = "55C049408744B8FDCA992B53F6C10120")

    private  int mContentId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.610 -0500", hash_original_field = "3D74F3A4EE1AB90E12A43557D37ACE3B", hash_generated_field = "E8BA56C7C02F14BBB3AD7861D24F7F39")


    private View mHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.612 -0500", hash_original_field = "4CE2596198A762943CD94DB82034E59D", hash_generated_field = "4B574DDB85BB6C11F0A70911E19AC509")

    private View mContent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.614 -0500", hash_original_field = "753E8A74B879B742778E0A7049176AEA", hash_generated_field = "E13DB1E02187FBC368ECF4DA682C95E3")


    private final Rect mFrame = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.617 -0500", hash_original_field = "23ADE8F27ED17778584C1B8FC9D10B40", hash_generated_field = "29D89654815C4DD328FBCD4EFB3E81BC")

    private final Rect mInvalidate = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.619 -0500", hash_original_field = "ACEC7A15DC94F80958816699D55E41EE", hash_generated_field = "D311D33EB50C15583CB88C72ABD7A592")

    private boolean mTracking;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.621 -0500", hash_original_field = "0FC044439F53C0B63C6F216516EA8CB1", hash_generated_field = "B5B87526C0568F2B5D294787B25B0638")

    private boolean mLocked;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.623 -0500", hash_original_field = "507D8F8387EDC230B54D84A5AD8E5830", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")


    private VelocityTracker mVelocityTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.625 -0500", hash_original_field = "AD5BC26F1486924EA9EA9B5D19F29CAE", hash_generated_field = "69CBC6FC9EE367E3A738852DD60DDD6D")


    private boolean mVertical;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.627 -0500", hash_original_field = "236172BE4841A164C5722B3244AD96D9", hash_generated_field = "7103A8DBA0A4F81C284E960B8CC80DC4")

    private boolean mExpanded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.629 -0500", hash_original_field = "492FE736C66364258A12FFCAE0D748DE", hash_generated_field = "B1973EFB8675E47C91EFC7050FA0F3E7")

    private int mBottomOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.632 -0500", hash_original_field = "0FA1E2F0ACF407BC242D9741EC705CF3", hash_generated_field = "C866368CF90BA3451D3AE94F894C480D")

    private int mTopOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.634 -0500", hash_original_field = "BDB1C6B681744474BCEE5B1966BC02A5", hash_generated_field = "C8B4AAC92CD2AD37DCE54B5FB83FCF5E")

    private int mHandleHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.636 -0500", hash_original_field = "4344634FC6CF9660B9543004FB710110", hash_generated_field = "91C21C968A54CD3CAEDEC430B21D840F")

    private int mHandleWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.638 -0500", hash_original_field = "866C6A009FF333389CAB25DAA1ECAD17", hash_generated_field = "8C460F25BFF7952FBBB3F43AEC58A8FA")


    private OnDrawerOpenListener mOnDrawerOpenListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.640 -0500", hash_original_field = "730F28B8289D5CBA928FA0464D717DB4", hash_generated_field = "5DCED40BC5E93EB3FC4EFFDBD1ABA1EB")

    private OnDrawerCloseListener mOnDrawerCloseListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.643 -0500", hash_original_field = "41BA11F1888E5AC626B8B5E01C318006", hash_generated_field = "37934535BE40303F2E70D52E12C88C10")

    private OnDrawerScrollListener mOnDrawerScrollListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.645 -0500", hash_original_field = "B7D134B9BC94B6D202271833D74FA7D4", hash_generated_field = "7069DE3AC2B814F5CD0DDE1ECAA02151")


    private final Handler mHandler = new SlidingHandler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.648 -0500", hash_original_field = "22EAF753DB1C3FBB359C6E22C87A67DC", hash_generated_field = "8AD4D7FBE4447EC74EB11F3023272F93")

    private float mAnimatedAcceleration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.650 -0500", hash_original_field = "4FC7EC065C914DA98C69384D567998F6", hash_generated_field = "A3DCEBEE17BC3A7805BCCDB2CDB21638")

    private float mAnimatedVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.652 -0500", hash_original_field = "FFC22C32063F5770E6DA446F0EAB3DE5", hash_generated_field = "EB408CD5971BBE43AB4D89C037F921CA")

    private float mAnimationPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.653 -0500", hash_original_field = "F6A994EDCD32E3A9260D0FB9B0869FC4", hash_generated_field = "4E4838736F5AD37BA1D45768FFDEC2FB")

    private long mAnimationLastTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.656 -0500", hash_original_field = "E59120B989108765651E3D8CFB1761C8", hash_generated_field = "C3A7AD453ACABDFDD13FABA569D1CFD9")

    private long mCurrentAnimationTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.658 -0500", hash_original_field = "DCAC519D6C06B94E7D955EDA2E3F0D6D", hash_generated_field = "5BD29BDFC5E30A8221E0EED91CB7C9FB")

    private int mTouchDelta;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.660 -0500", hash_original_field = "1EF11B2E74F652844136498FA058D6D8", hash_generated_field = "854092FC87CCBE5E499FE3FB8F6394C7")

    private boolean mAnimating;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.662 -0500", hash_original_field = "9F1413A9AEFDBA3F39297365B137BF8C", hash_generated_field = "A90D0780F4DA532FBB44DC2AE89D77C7")

    private boolean mAllowSingleTap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.664 -0500", hash_original_field = "5AB3E573EEF930136AE0C9FFC7A331B9", hash_generated_field = "77014DC90A0F680C78080EF9CA98C818")

    private boolean mAnimateOnClick;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.667 -0500", hash_original_field = "0FCC7F3E333A28901CEA22B19FA7629A", hash_generated_field = "C8ECFBCB177EF04D92E685DE7FC65E03")


    private  int mTapThreshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.669 -0500", hash_original_field = "BC275EFC94F31A5D5408C763F8887282", hash_generated_field = "883ADAEF9FFCFF03EA632160D4AD8FA4")

    private  int mMaximumTapVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.672 -0500", hash_original_field = "A66AD618ABAC54C79C2C2C1758DD93DF", hash_generated_field = "E86298FF1379F6B0C1EE27F5B5493C15")

    private  int mMaximumMinorVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.674 -0500", hash_original_field = "895AF44188279F886951B0E940A141C9", hash_generated_field = "986D3718748EC5493FDCC588323CD655")

    private  int mMaximumMajorVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.676 -0500", hash_original_field = "E0591319C0B39DCB669CDCC463161385", hash_generated_field = "47A315E9052A5B52B83853E58F6237E7")

    private  int mMaximumAcceleration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.679 -0500", hash_original_field = "62E9D45BC75C3CA679B62FE73A2EDCAF", hash_generated_field = "09D9CEAD7D76C9A46A88D2130E1F15F9")

    private  int mVelocityUnits;

    /**
     * Creates a new SlidingDrawer from a specified set of attributes defined in XML.
     *
     * @param context The application's environment.
     * @param attrs The attributes defined in XML.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.688 -0500", hash_original_method = "0C587242BBF05ECC28F9594E1E56F522", hash_generated_method = "751231F7332979B8B118A367DDB23774")
    
public SlidingDrawer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * Creates a new SlidingDrawer from a specified set of attributes defined in XML.
     *
     * @param context The application's environment.
     * @param attrs The attributes defined in XML.
     * @param defStyle The style to apply to this widget.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.692 -0500", hash_original_method = "C8EE8FBE152C147E7717480946CCA8E7", hash_generated_method = "8E73886E17112DE14A0E5AD4F36CD4DA")
    
public SlidingDrawer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SlidingDrawer, defStyle, 0);

        int orientation = a.getInt(R.styleable.SlidingDrawer_orientation, ORIENTATION_VERTICAL);
        mVertical = orientation == ORIENTATION_VERTICAL;
        mBottomOffset = (int) a.getDimension(R.styleable.SlidingDrawer_bottomOffset, 0.0f);
        mTopOffset = (int) a.getDimension(R.styleable.SlidingDrawer_topOffset, 0.0f);
        mAllowSingleTap = a.getBoolean(R.styleable.SlidingDrawer_allowSingleTap, true);
        mAnimateOnClick = a.getBoolean(R.styleable.SlidingDrawer_animateOnClick, true);

        int handleId = a.getResourceId(R.styleable.SlidingDrawer_handle, 0);
        if (handleId == 0) {
            throw new IllegalArgumentException("The handle attribute is required and must refer "
                    + "to a valid child.");
        }

        int contentId = a.getResourceId(R.styleable.SlidingDrawer_content, 0);
        if (contentId == 0) {
            throw new IllegalArgumentException("The content attribute is required and must refer "
                    + "to a valid child.");
        }

        if (handleId == contentId) {
            throw new IllegalArgumentException("The content and handle attributes must refer "
                    + "to different children.");
        }

        mHandleId = handleId;
        mContentId = contentId;

        final float density = getResources().getDisplayMetrics().density;
        mTapThreshold = (int) (TAP_THRESHOLD * density + 0.5f);
        mMaximumTapVelocity = (int) (MAXIMUM_TAP_VELOCITY * density + 0.5f);
        mMaximumMinorVelocity = (int) (MAXIMUM_MINOR_VELOCITY * density + 0.5f);
        mMaximumMajorVelocity = (int) (MAXIMUM_MAJOR_VELOCITY * density + 0.5f);
        mMaximumAcceleration = (int) (MAXIMUM_ACCELERATION * density + 0.5f);
        mVelocityUnits = (int) (VELOCITY_UNITS * density + 0.5f);

        a.recycle();

        setAlwaysDrawnWithCacheEnabled(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.695 -0500", hash_original_method = "D4721D394CC37BD7B7DC0DFF43B7CD6B", hash_generated_method = "17478AD0185E999EC24054878C7A1B17")
    
@Override
    protected void onFinishInflate() {
        mHandle = findViewById(mHandleId);
        if (mHandle == null) {
            throw new IllegalArgumentException("The handle attribute is must refer to an"
                    + " existing child.");
        }
        mHandle.setOnClickListener(new DrawerToggler());

        mContent = findViewById(mContentId);
        if (mContent == null) {
            throw new IllegalArgumentException("The content attribute is must refer to an" 
                    + " existing child.");
        }
        mContent.setVisibility(View.GONE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.698 -0500", hash_original_method = "45D03353ADB6FD3256F7B7DABD84ED03", hash_generated_method = "F3AB18BB99F7F478D3AC76E915ED9CF0")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize =  MeasureSpec.getSize(widthMeasureSpec);

        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize =  MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.UNSPECIFIED || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            throw new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
        }

        final View handle = mHandle;
        measureChild(handle, widthMeasureSpec, heightMeasureSpec);

        if (mVertical) {
            int height = heightSpecSize - handle.getMeasuredHeight() - mTopOffset;
            mContent.measure(MeasureSpec.makeMeasureSpec(widthSpecSize, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
        } else {
            int width = widthSpecSize - handle.getMeasuredWidth() - mTopOffset;
            mContent.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(heightSpecSize, MeasureSpec.EXACTLY));
        }

        setMeasuredDimension(widthSpecSize, heightSpecSize);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.700 -0500", hash_original_method = "A279E67FA1A6901C21F6D4D49CA58425", hash_generated_method = "ACB17EAD87AD361A1E24DED8F5595B71")
    
@Override
    protected void dispatchDraw(Canvas canvas) {
        final long drawingTime = getDrawingTime();
        final View handle = mHandle;
        final boolean isVertical = mVertical;

        drawChild(canvas, handle, drawingTime);

        if (mTracking || mAnimating) {
            final Bitmap cache = mContent.getDrawingCache();
            if (cache != null) {
                if (isVertical) {
                    canvas.drawBitmap(cache, 0, handle.getBottom(), null);
                } else {
                    canvas.drawBitmap(cache, handle.getRight(), 0, null);                    
                }
            } else {
                canvas.save();
                canvas.translate(isVertical ? 0 : handle.getLeft() - mTopOffset,
                        isVertical ? handle.getTop() - mTopOffset : 0);
                drawChild(canvas, mContent, drawingTime);
                canvas.restore();
            }
        } else if (mExpanded) {
            drawChild(canvas, mContent, drawingTime);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.703 -0500", hash_original_method = "5CD9193E39A65D0460D4DE7F7A8E61BB", hash_generated_method = "E0156840C4BB395384A8118C9C133076")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mTracking) {
            return;
        }

        final int width = r - l;
        final int height = b - t;

        final View handle = mHandle;

        int childWidth = handle.getMeasuredWidth();
        int childHeight = handle.getMeasuredHeight();

        int childLeft;
        int childTop;

        final View content = mContent;

        if (mVertical) {
            childLeft = (width - childWidth) / 2;
            childTop = mExpanded ? mTopOffset : height - childHeight + mBottomOffset;

            content.layout(0, mTopOffset + childHeight, content.getMeasuredWidth(),
                    mTopOffset + childHeight + content.getMeasuredHeight());
        } else {
            childLeft = mExpanded ? mTopOffset : width - childWidth + mBottomOffset;
            childTop = (height - childHeight) / 2;

            content.layout(mTopOffset + childWidth, 0,
                    mTopOffset + childWidth + content.getMeasuredWidth(),
                    content.getMeasuredHeight());            
        }

        handle.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
        mHandleHeight = handle.getHeight();
        mHandleWidth = handle.getWidth();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.707 -0500", hash_original_method = "DEC86D4E986198170B4E32A8C9B969F8", hash_generated_method = "F224748B9A74CBC843CAEE7D680AA731")
    
@Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (mLocked) {
            return false;
        }

        final int action = event.getAction();

        float x = event.getX();
        float y = event.getY();

        final Rect frame = mFrame;
        final View handle = mHandle;

        handle.getHitRect(frame);
        if (!mTracking && !frame.contains((int) x, (int) y)) {
            return false;
        }

        if (action == MotionEvent.ACTION_DOWN) {
            mTracking = true;

            handle.setPressed(true);
            // Must be called before prepareTracking()
            prepareContent();

            // Must be called after prepareContent()
            if (mOnDrawerScrollListener != null) {
                mOnDrawerScrollListener.onScrollStarted();
            }

            if (mVertical) {
                final int top = mHandle.getTop();
                mTouchDelta = (int) y - top;
                prepareTracking(top);
            } else {
                final int left = mHandle.getLeft();
                mTouchDelta = (int) x - left;
                prepareTracking(left);
            }
            mVelocityTracker.addMovement(event);
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.710 -0500", hash_original_method = "BD859C70C763183DAB172469AFBE0279", hash_generated_method = "D2D4C6949EE4C21720B1AFDABE023F40")
    
@Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mLocked) {
            return true;
        }

        if (mTracking) {
            mVelocityTracker.addMovement(event);
            final int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_MOVE:
                    moveHandle((int) (mVertical ? event.getY() : event.getX()) - mTouchDelta);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL: {
                    final VelocityTracker velocityTracker = mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(mVelocityUnits);

                    float yVelocity = velocityTracker.getYVelocity();
                    float xVelocity = velocityTracker.getXVelocity();
                    boolean negative;

                    final boolean vertical = mVertical;
                    if (vertical) {
                        negative = yVelocity < 0;
                        if (xVelocity < 0) {
                            xVelocity = -xVelocity;
                        }
                        if (xVelocity > mMaximumMinorVelocity) {
                            xVelocity = mMaximumMinorVelocity;
                        }
                    } else {
                        negative = xVelocity < 0;
                        if (yVelocity < 0) {
                            yVelocity = -yVelocity;
                        }
                        if (yVelocity > mMaximumMinorVelocity) {
                            yVelocity = mMaximumMinorVelocity;
                        }
                    }

                    float velocity = (float) Math.hypot(xVelocity, yVelocity);
                    if (negative) {
                        velocity = -velocity;
                    }

                    final int top = mHandle.getTop();
                    final int left = mHandle.getLeft();

                    if (Math.abs(velocity) < mMaximumTapVelocity) {
                        if (vertical ? (mExpanded && top < mTapThreshold + mTopOffset) ||
                                (!mExpanded && top > mBottomOffset + mBottom - mTop -
                                        mHandleHeight - mTapThreshold) :
                                (mExpanded && left < mTapThreshold + mTopOffset) ||
                                (!mExpanded && left > mBottomOffset + mRight - mLeft -
                                        mHandleWidth - mTapThreshold)) {

                            if (mAllowSingleTap) {
                                playSoundEffect(SoundEffectConstants.CLICK);

                                if (mExpanded) {
                                    animateClose(vertical ? top : left);
                                } else {
                                    animateOpen(vertical ? top : left);
                                }
                            } else {
                                performFling(vertical ? top : left, velocity, false);
                            }

                        } else {
                            performFling(vertical ? top : left, velocity, false);
                        }
                    } else {
                        performFling(vertical ? top : left, velocity, false);
                    }
                }
                break;
            }
        }

        return mTracking || mAnimating || super.onTouchEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.713 -0500", hash_original_method = "88CBA816EA18A335641DE4CDFF39F34A", hash_generated_method = "CC659D4031C51EE2EEA89F98B8949C4B")
    
private void animateClose(int position) {
        prepareTracking(position);
        performFling(position, mMaximumAcceleration, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.716 -0500", hash_original_method = "C2A732DFCC58ACB6BBE028A7D0745854", hash_generated_method = "3B9A7238420469000CA2105B595BF88F")
    
private void animateOpen(int position) {
        prepareTracking(position);
        performFling(position, -mMaximumAcceleration, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.719 -0500", hash_original_method = "D605C0C7A0239DE60A633AEEC0D2A029", hash_generated_method = "DED1CF79DA92F2E40A3C75760D57B680")
    
private void performFling(int position, float velocity, boolean always) {
        mAnimationPosition = position;
        mAnimatedVelocity = velocity;

        if (mExpanded) {
            if (always || (velocity > mMaximumMajorVelocity ||
                    (position > mTopOffset + (mVertical ? mHandleHeight : mHandleWidth) &&
                            velocity > -mMaximumMajorVelocity))) {
                // We are expanded, but they didn't move sufficiently to cause
                // us to retract.  Animate back to the expanded position.
                mAnimatedAcceleration = mMaximumAcceleration;
                if (velocity < 0) {
                    mAnimatedVelocity = 0;
                }
            } else {
                // We are expanded and are now going to animate away.
                mAnimatedAcceleration = -mMaximumAcceleration;
                if (velocity > 0) {
                    mAnimatedVelocity = 0;
                }
            }
        } else {
            if (!always && (velocity > mMaximumMajorVelocity ||
                    (position > (mVertical ? getHeight() : getWidth()) / 2 &&
                            velocity > -mMaximumMajorVelocity))) {
                // We are collapsed, and they moved enough to allow us to expand.
                mAnimatedAcceleration = mMaximumAcceleration;
                if (velocity < 0) {
                    mAnimatedVelocity = 0;
                }
            } else {
                // We are collapsed, but they didn't move sufficiently to cause
                // us to retract.  Animate back to the collapsed position.
                mAnimatedAcceleration = -mMaximumAcceleration;
                if (velocity > 0) {
                    mAnimatedVelocity = 0;
                }
            }
        }

        long now = SystemClock.uptimeMillis();
        mAnimationLastTime = now;
        mCurrentAnimationTime = now + ANIMATION_FRAME_DURATION;
        mAnimating = true;
        mHandler.removeMessages(MSG_ANIMATE);
        mHandler.sendMessageAtTime(mHandler.obtainMessage(MSG_ANIMATE), mCurrentAnimationTime);
        stopTracking();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.721 -0500", hash_original_method = "59A44BD10421444D4E6898819BFB6759", hash_generated_method = "6C5D51D1BA1F85E73DA4BB26F1A34EDB")
    
private void prepareTracking(int position) {
        mTracking = true;
        mVelocityTracker = VelocityTracker.obtain();
        boolean opening = !mExpanded;
        if (opening) {
            mAnimatedAcceleration = mMaximumAcceleration;
            mAnimatedVelocity = mMaximumMajorVelocity;
            mAnimationPosition = mBottomOffset +
                    (mVertical ? getHeight() - mHandleHeight : getWidth() - mHandleWidth);
            moveHandle((int) mAnimationPosition);
            mAnimating = true;
            mHandler.removeMessages(MSG_ANIMATE);
            long now = SystemClock.uptimeMillis();
            mAnimationLastTime = now;
            mCurrentAnimationTime = now + ANIMATION_FRAME_DURATION;
            mAnimating = true;
        } else {
            if (mAnimating) {
                mAnimating = false;
                mHandler.removeMessages(MSG_ANIMATE);
            }
            moveHandle(position);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.725 -0500", hash_original_method = "EB5E8744EDA67A38CC286A32349D536F", hash_generated_method = "EE814491205B93C476F5975F5894BB5E")
    
private void moveHandle(int position) {
        final View handle = mHandle;

        if (mVertical) {
            if (position == EXPANDED_FULL_OPEN) {
                handle.offsetTopAndBottom(mTopOffset - handle.getTop());
                invalidate();
            } else if (position == COLLAPSED_FULL_CLOSED) {
                handle.offsetTopAndBottom(mBottomOffset + mBottom - mTop -
                        mHandleHeight - handle.getTop());
                invalidate();
            } else {
                final int top = handle.getTop();
                int deltaY = position - top;
                if (position < mTopOffset) {
                    deltaY = mTopOffset - top;
                } else if (deltaY > mBottomOffset + mBottom - mTop - mHandleHeight - top) {
                    deltaY = mBottomOffset + mBottom - mTop - mHandleHeight - top;
                }
                handle.offsetTopAndBottom(deltaY);

                final Rect frame = mFrame;
                final Rect region = mInvalidate;

                handle.getHitRect(frame);
                region.set(frame);

                region.union(frame.left, frame.top - deltaY, frame.right, frame.bottom - deltaY);
                region.union(0, frame.bottom - deltaY, getWidth(),
                        frame.bottom - deltaY + mContent.getHeight());

                invalidate(region);
            }
        } else {
            if (position == EXPANDED_FULL_OPEN) {
                handle.offsetLeftAndRight(mTopOffset - handle.getLeft());
                invalidate();
            } else if (position == COLLAPSED_FULL_CLOSED) {
                handle.offsetLeftAndRight(mBottomOffset + mRight - mLeft -
                        mHandleWidth - handle.getLeft());
                invalidate();
            } else {
                final int left = handle.getLeft();
                int deltaX = position - left;
                if (position < mTopOffset) {
                    deltaX = mTopOffset - left;
                } else if (deltaX > mBottomOffset + mRight - mLeft - mHandleWidth - left) {
                    deltaX = mBottomOffset + mRight - mLeft - mHandleWidth - left;
                }
                handle.offsetLeftAndRight(deltaX);

                final Rect frame = mFrame;
                final Rect region = mInvalidate;

                handle.getHitRect(frame);
                region.set(frame);

                region.union(frame.left - deltaX, frame.top, frame.right - deltaX, frame.bottom);
                region.union(frame.right - deltaX, 0,
                        frame.right - deltaX + mContent.getWidth(), getHeight());

                invalidate(region);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.728 -0500", hash_original_method = "8AB257947D81E84CE88DA2BD3F113967", hash_generated_method = "0534A9D62D3412A1F857567ADF43D91D")
    
private void prepareContent() {
        if (mAnimating) {
            return;
        }

        // Something changed in the content, we need to honor the layout request
        // before creating the cached bitmap
        final View content = mContent;
        if (content.isLayoutRequested()) {
            if (mVertical) {
                final int childHeight = mHandleHeight;
                int height = mBottom - mTop - childHeight - mTopOffset;
                content.measure(MeasureSpec.makeMeasureSpec(mRight - mLeft, MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                content.layout(0, mTopOffset + childHeight, content.getMeasuredWidth(),
                        mTopOffset + childHeight + content.getMeasuredHeight());
            } else {
                final int childWidth = mHandle.getWidth();
                int width = mRight - mLeft - childWidth - mTopOffset;
                content.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(mBottom - mTop, MeasureSpec.EXACTLY));
                content.layout(childWidth + mTopOffset, 0,
                        mTopOffset + childWidth + content.getMeasuredWidth(),
                        content.getMeasuredHeight());
            }
        }
        // Try only once... we should really loop but it's not a big deal
        // if the draw was cancelled, it will only be temporary anyway
        content.getViewTreeObserver().dispatchOnPreDraw();
        if (!content.isHardwareAccelerated()) content.buildDrawingCache();

        content.setVisibility(View.GONE);        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.730 -0500", hash_original_method = "211492025B22CF1DCBA38CDE66604CEE", hash_generated_method = "F4E43633A9008E5DEE65FA7D8A32D2BB")
    
private void stopTracking() {
        mHandle.setPressed(false);
        mTracking = false;

        if (mOnDrawerScrollListener != null) {
            mOnDrawerScrollListener.onScrollEnded();
        }

        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.733 -0500", hash_original_method = "1985F913D861388A154BC055CAF12D3C", hash_generated_method = "CFEEC89658CEE2DEA0041C3C868341F2")
    
private void doAnimation() {
        if (mAnimating) {
            incrementAnimation();
            if (mAnimationPosition >= mBottomOffset + (mVertical ? getHeight() : getWidth()) - 1) {
                mAnimating = false;
                closeDrawer();
            } else if (mAnimationPosition < mTopOffset) {
                mAnimating = false;
                openDrawer();
            } else {
                moveHandle((int) mAnimationPosition);
                mCurrentAnimationTime += ANIMATION_FRAME_DURATION;
                mHandler.sendMessageAtTime(mHandler.obtainMessage(MSG_ANIMATE),
                        mCurrentAnimationTime);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.736 -0500", hash_original_method = "D38E54734013AFEACE31D553AEEA44A0", hash_generated_method = "9019347A6BE3E8D70DFF87D260D20631")
    
private void incrementAnimation() {
        long now = SystemClock.uptimeMillis();
        float t = (now - mAnimationLastTime) / 1000.0f;                   // ms -> s
        final float position = mAnimationPosition;
        final float v = mAnimatedVelocity;                                // px/s
        final float a = mAnimatedAcceleration;                            // px/s/s
        mAnimationPosition = position + (v * t) + (0.5f * a * t * t);     // px
        mAnimatedVelocity = v + (a * t);                                  // px/s
        mAnimationLastTime = now;                                         // ms
    }

    /**
     * Toggles the drawer open and close. Takes effect immediately.
     *
     * @see #open()
     * @see #close()
     * @see #animateClose()
     * @see #animateOpen()
     * @see #animateToggle()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.738 -0500", hash_original_method = "03CAF29C80FE37AB685D8DAE18F070E8", hash_generated_method = "17466C3A7D02A709786E94929C3DAA22")
    
public void toggle() {
        if (!mExpanded) {
            openDrawer();
        } else {
            closeDrawer();
        }
        invalidate();
        requestLayout();
    }

    /**
     * Toggles the drawer open and close with an animation.
     *
     * @see #open()
     * @see #close()
     * @see #animateClose()
     * @see #animateOpen()
     * @see #toggle()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.740 -0500", hash_original_method = "43E4720445BBEABBD21F59D3B8D3127A", hash_generated_method = "2DEDD906478856E2335B9DE884793AE1")
    
public void animateToggle() {
        if (!mExpanded) {
            animateOpen();
        } else {
            animateClose();
        }
    }

    /**
     * Opens the drawer immediately.
     *
     * @see #toggle()
     * @see #close()
     * @see #animateOpen()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.742 -0500", hash_original_method = "5DD756EDEA96CF75D5A9F7EAA046E366", hash_generated_method = "D1042497AC0B7E6DD972E3F116404629")
    
public void open() {
        openDrawer();
        invalidate();
        requestLayout();

        sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
    }

    /**
     * Closes the drawer immediately.
     *
     * @see #toggle()
     * @see #open()
     * @see #animateClose()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.744 -0500", hash_original_method = "3C4BA0CB6A211EA5F01C92F64D60529B", hash_generated_method = "B18448B6BD243067A67198D058F9C922")
    
public void close() {
        closeDrawer();
        invalidate();
        requestLayout();
    }

    /**
     * Closes the drawer with an animation.
     *
     * @see #close()
     * @see #open()
     * @see #animateOpen()
     * @see #animateToggle()
     * @see #toggle()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.747 -0500", hash_original_method = "14EAEC241F22C4A095DF4C0D05999E3B", hash_generated_method = "62EF40E8A3B6AA850E360C87DAAEDBA6")
    
public void animateClose() {
        prepareContent();
        final OnDrawerScrollListener scrollListener = mOnDrawerScrollListener;
        if (scrollListener != null) {
            scrollListener.onScrollStarted();
        }
        animateClose(mVertical ? mHandle.getTop() : mHandle.getLeft());

        if (scrollListener != null) {
            scrollListener.onScrollEnded();
        }
    }

    
    private class DrawerToggler implements OnClickListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.228 -0400", hash_original_method = "8DAFF423CC5901B0B532AD847FEA0938", hash_generated_method = "8DAFF423CC5901B0B532AD847FEA0938")
        public DrawerToggler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.777 -0500", hash_original_method = "D5ABF7EB3B9C4ED77CCCF3551465E2CF", hash_generated_method = "727B91C4898CD276506D68BE399B823F")
        
public void onClick(View v) {
            if (mLocked) {
                return;
            }
            // mAllowSingleTap isn't relevant here; you're *always*
            // allowed to open/close the drawer by clicking with the
            // trackball.

            if (mAnimateOnClick) {
                animateToggle();
            } else {
                toggle();
            }
        }

        
    }


    
    private class SlidingHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.228 -0400", hash_original_method = "44797BB1CCD092762141D42397C614B8", hash_generated_method = "44797BB1CCD092762141D42397C614B8")
        public SlidingHandler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.782 -0500", hash_original_method = "8F95C74EDA64D211CE1AA49DFEDA489B", hash_generated_method = "3C037423DA10380ECA6255CE2502F12A")
        
public void handleMessage(Message m) {
            switch (m.what) {
                case MSG_ANIMATE:
                    doAnimation();
                    break;
            }
        }

        
    }


    
    public static interface OnDrawerOpenListener {
        
        public void onDrawerOpened();
    }
    
    public static interface OnDrawerCloseListener {
        
        public void onDrawerClosed();
    }
    
    public static interface OnDrawerScrollListener {
        
        public void onScrollStarted();

        
        public void onScrollEnded();
    }

    /**
     * Opens the drawer with an animation.
     *
     * @see #close()
     * @see #open()
     * @see #animateClose()
     * @see #animateToggle()
     * @see #toggle()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.749 -0500", hash_original_method = "DF9AA0E5A29CC27A1E0772A609A87271", hash_generated_method = "FA0813687ECC05C5EC4DAFAD4C951A49")
    
public void animateOpen() {
        prepareContent();
        final OnDrawerScrollListener scrollListener = mOnDrawerScrollListener;
        if (scrollListener != null) {
            scrollListener.onScrollStarted();
        }
        animateOpen(mVertical ? mHandle.getTop() : mHandle.getLeft());

        sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);

        if (scrollListener != null) {
            scrollListener.onScrollEnded();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.751 -0500", hash_original_method = "1255865AE0DB052085CB21C8279D10AA", hash_generated_method = "269772C95AA9A33D0CBC49ED89C9C958")
    
private void closeDrawer() {
        moveHandle(COLLAPSED_FULL_CLOSED);
        mContent.setVisibility(View.GONE);
        mContent.destroyDrawingCache();

        if (!mExpanded) {
            return;
        }

        mExpanded = false;
        if (mOnDrawerCloseListener != null) {
            mOnDrawerCloseListener.onDrawerClosed();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.754 -0500", hash_original_method = "68D1245B0829B631CA56B61B1EFB607E", hash_generated_method = "206622C78E0AB7E73B19AC7D6CC81D20")
    
private void openDrawer() {
        moveHandle(EXPANDED_FULL_OPEN);
        mContent.setVisibility(View.VISIBLE);

        if (mExpanded) {
            return;
        }

        mExpanded = true;

        if (mOnDrawerOpenListener != null) {
            mOnDrawerOpenListener.onDrawerOpened();
        }
    }

    /**
     * Sets the listener that receives a notification when the drawer becomes open.
     *
     * @param onDrawerOpenListener The listener to be notified when the drawer is opened.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.756 -0500", hash_original_method = "2D7D8ECE305828F8F9DDACE01A4242C8", hash_generated_method = "D6FFA1395174CE8347645892A04F5421")
    
public void setOnDrawerOpenListener(OnDrawerOpenListener onDrawerOpenListener) {
        mOnDrawerOpenListener = onDrawerOpenListener;
    }

    /**
     * Sets the listener that receives a notification when the drawer becomes close.
     *
     * @param onDrawerCloseListener The listener to be notified when the drawer is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.758 -0500", hash_original_method = "C6CA4E8603B3A8F496AF48C05AA699E0", hash_generated_method = "4670AB45233A93D870C9964E42685248")
    
public void setOnDrawerCloseListener(OnDrawerCloseListener onDrawerCloseListener) {
        mOnDrawerCloseListener = onDrawerCloseListener;
    }

    /**
     * Sets the listener that receives a notification when the drawer starts or ends
     * a scroll. A fling is considered as a scroll. A fling will also trigger a
     * drawer opened or drawer closed event.
     *
     * @param onDrawerScrollListener The listener to be notified when scrolling
     *        starts or stops.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.760 -0500", hash_original_method = "F07CA388B1E1CC74CA965772D9BCDE7A", hash_generated_method = "2B4DF2F0DD3D8D04512EAC392DA2C46C")
    
public void setOnDrawerScrollListener(OnDrawerScrollListener onDrawerScrollListener) {
        mOnDrawerScrollListener = onDrawerScrollListener;
    }

    /**
     * Returns the handle of the drawer.
     *
     * @return The View reprenseting the handle of the drawer, identified by
     *         the "handle" id in XML.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.762 -0500", hash_original_method = "AE3D3479E28037BEE2B8772FADCA394B", hash_generated_method = "C15CAF39DC63B69BEC12A9F99ED7DF3D")
    
public View getHandle() {
        return mHandle;
    }

    /**
     * Returns the content of the drawer.
     *
     * @return The View reprenseting the content of the drawer, identified by
     *         the "content" id in XML.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.765 -0500", hash_original_method = "383B97EB3876FB14240EC86DEF6C8427", hash_generated_method = "83357A10C9614090ED19AB7EA2BD4904")
    
public View getContent() {
        return mContent;
    }

    /**
     * Unlocks the SlidingDrawer so that touch events are processed.
     *
     * @see #lock() 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.767 -0500", hash_original_method = "2AEB4587AE0C07EB559A85B7E1ABA252", hash_generated_method = "C81F029296A9FFC2A9891B11F3F0DD18")
    
public void unlock() {
        mLocked = false;
    }

    /**
     * Locks the SlidingDrawer so that touch events are ignores.
     *
     * @see #unlock()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.769 -0500", hash_original_method = "32E6B7DBEEDBFAF28CCF0157F60F94F0", hash_generated_method = "5BA46E763BD1139815012A70CD2F6CF9")
    
public void lock() {
        mLocked = true;
    }

    /**
     * Indicates whether the drawer is currently fully opened.
     *
     * @return True if the drawer is opened, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.771 -0500", hash_original_method = "A0663ABB788C8A0905C7EF76DE01C422", hash_generated_method = "6E87EC9E538DD48E4F769CF9D44B0E45")
    
public boolean isOpened() {
        return mExpanded;
    }

    /**
     * Indicates whether the drawer is scrolling or flinging.
     *
     * @return True if the drawer is scroller or flinging, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:02.774 -0500", hash_original_method = "E24D6C05B3C8D3641FA197063B5CFCA4", hash_generated_method = "7C62376FC3BB93BADAEB790D22ADCEB0")
    
public boolean isMoving() {
        return mTracking || mAnimating;
    }
}

