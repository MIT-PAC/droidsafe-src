package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.699 -0400", hash_original_field = "C6ED19C522463B2CF739046573EC7132", hash_generated_field = "B9AD435137DADE0845830F9270F70E30")

    private int mHandleId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.699 -0400", hash_original_field = "AC8B7583E813EED1C21F8860B3D85710", hash_generated_field = "55C049408744B8FDCA992B53F6C10120")

    private int mContentId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.699 -0400", hash_original_field = "D82B253C7CDC2B84A5A684E7A5D691F6", hash_generated_field = "E8BA56C7C02F14BBB3AD7861D24F7F39")

    private View mHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "96ABFA2B593174DC149815D6ACBFCC27", hash_generated_field = "4B574DDB85BB6C11F0A70911E19AC509")

    private View mContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "6D96B0D1B61CFC8FD94C785D9E288B33", hash_generated_field = "E13DB1E02187FBC368ECF4DA682C95E3")

    private final Rect mFrame = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "0A89D8FCE7D2669FA3F23739A2CDAE80", hash_generated_field = "29D89654815C4DD328FBCD4EFB3E81BC")

    private final Rect mInvalidate = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "1E1CC85914707D75E1771795C8BD6A9B", hash_generated_field = "D311D33EB50C15583CB88C72ABD7A592")

    private boolean mTracking;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "80D5808411DAD55FEAC29271D9ADA1EC", hash_generated_field = "B5B87526C0568F2B5D294787B25B0638")

    private boolean mLocked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "151A20A8D7084F60EB7F7A4B44844050", hash_generated_field = "69CBC6FC9EE367E3A738852DD60DDD6D")

    private boolean mVertical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "EA52AC187B90D5B6EA1A48C8DE714672", hash_generated_field = "7103A8DBA0A4F81C284E960B8CC80DC4")

    private boolean mExpanded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "435A94F9B20F3982BB0BB972CA302392", hash_generated_field = "B1973EFB8675E47C91EFC7050FA0F3E7")

    private int mBottomOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "03B884ED1433CDF1C2D6C09E4C78942A", hash_generated_field = "C866368CF90BA3451D3AE94F894C480D")

    private int mTopOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "D7780604354036B250401D9369D690EA", hash_generated_field = "C8B4AAC92CD2AD37DCE54B5FB83FCF5E")

    private int mHandleHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "5B7D7E647393BB6E70B31E2D06091F68", hash_generated_field = "91C21C968A54CD3CAEDEC430B21D840F")

    private int mHandleWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "945C558E4C116F27F298188048930EFA", hash_generated_field = "8C460F25BFF7952FBBB3F43AEC58A8FA")

    private OnDrawerOpenListener mOnDrawerOpenListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "BDD843F2B4160F0B263A0E3975A40EDA", hash_generated_field = "5DCED40BC5E93EB3FC4EFFDBD1ABA1EB")

    private OnDrawerCloseListener mOnDrawerCloseListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.700 -0400", hash_original_field = "A024E903FFEB36E0D5DC9DD7B746926D", hash_generated_field = "37934535BE40303F2E70D52E12C88C10")

    private OnDrawerScrollListener mOnDrawerScrollListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "34612B09D81F66D505F9CAE8A696C61F", hash_generated_field = "7069DE3AC2B814F5CD0DDE1ECAA02151")

    private final Handler mHandler = new SlidingHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "95408A0B27B9EE13B14B4AA27CD3602B", hash_generated_field = "8AD4D7FBE4447EC74EB11F3023272F93")

    private float mAnimatedAcceleration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "0E2A0F8F90B3975E5096671276739588", hash_generated_field = "A3DCEBEE17BC3A7805BCCDB2CDB21638")

    private float mAnimatedVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "E4D3D3B4319A729EBABD6E676333F0A3", hash_generated_field = "EB408CD5971BBE43AB4D89C037F921CA")

    private float mAnimationPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "3D14A4458FAB915CA967C4DF00B44EE9", hash_generated_field = "4E4838736F5AD37BA1D45768FFDEC2FB")

    private long mAnimationLastTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "98A905339071B2C35302448215791E60", hash_generated_field = "C3A7AD453ACABDFDD13FABA569D1CFD9")

    private long mCurrentAnimationTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "A027DA8473A24221B234F45287B539BF", hash_generated_field = "5BD29BDFC5E30A8221E0EED91CB7C9FB")

    private int mTouchDelta;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "4CBE2C29B096DEAFE05278D33E5C3A71", hash_generated_field = "854092FC87CCBE5E499FE3FB8F6394C7")

    private boolean mAnimating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "A7B684224E671E055DB70978A094621F", hash_generated_field = "A90D0780F4DA532FBB44DC2AE89D77C7")

    private boolean mAllowSingleTap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "86D97357F7BE8AFF226C2882D067E5C4", hash_generated_field = "77014DC90A0F680C78080EF9CA98C818")

    private boolean mAnimateOnClick;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "9A22335A92C6C44BDD8FD0B54C0529B3", hash_generated_field = "C8ECFBCB177EF04D92E685DE7FC65E03")

    private int mTapThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "183A057DB41845FF71512F0615584A5B", hash_generated_field = "883ADAEF9FFCFF03EA632160D4AD8FA4")

    private int mMaximumTapVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "E075028EFAFE9CED391102CA4740643B", hash_generated_field = "E86298FF1379F6B0C1EE27F5B5493C15")

    private int mMaximumMinorVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "4AACD31CB8ECF34A46216114BFD3D24B", hash_generated_field = "986D3718748EC5493FDCC588323CD655")

    private int mMaximumMajorVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "9F332E76BBF79DFC3FAD2AEF9EE6F3D7", hash_generated_field = "47A315E9052A5B52B83853E58F6237E7")

    private int mMaximumAcceleration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.701 -0400", hash_original_field = "1C689C208726A9AF6AF39E966C0909D7", hash_generated_field = "09D9CEAD7D76C9A46A88D2130E1F15F9")

    private int mVelocityUnits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.702 -0400", hash_original_method = "0C587242BBF05ECC28F9594E1E56F522", hash_generated_method = "754407A3BF3BEC1FD73C6B7FF4089749")
    public  SlidingDrawer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.705 -0400", hash_original_method = "C8EE8FBE152C147E7717480946CCA8E7", hash_generated_method = "C8E5EB388BC49CB4A0A569D70F2F9900")
    public  SlidingDrawer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SlidingDrawer, defStyle, 0);
        int orientation = a.getInt(R.styleable.SlidingDrawer_orientation, ORIENTATION_VERTICAL);
        mVertical = orientation == ORIENTATION_VERTICAL;
        mBottomOffset = (int) a.getDimension(R.styleable.SlidingDrawer_bottomOffset, 0.0f);
        mTopOffset = (int) a.getDimension(R.styleable.SlidingDrawer_topOffset, 0.0f);
        mAllowSingleTap = a.getBoolean(R.styleable.SlidingDrawer_allowSingleTap, true);
        mAnimateOnClick = a.getBoolean(R.styleable.SlidingDrawer_animateOnClick, true);
        int handleId = a.getResourceId(R.styleable.SlidingDrawer_handle, 0);
    if(handleId == 0)        
        {
            IllegalArgumentException var5439235E872863ACF4B62EBE88E47C5E_1426086338 = new IllegalArgumentException("The handle attribute is required and must refer "
                    + "to a valid child.");
            var5439235E872863ACF4B62EBE88E47C5E_1426086338.addTaint(taint);
            throw var5439235E872863ACF4B62EBE88E47C5E_1426086338;
        } //End block
        int contentId = a.getResourceId(R.styleable.SlidingDrawer_content, 0);
    if(contentId == 0)        
        {
            IllegalArgumentException varBEA526F4B61D519C6E6EE36231747F04_151090703 = new IllegalArgumentException("The content attribute is required and must refer "
                    + "to a valid child.");
            varBEA526F4B61D519C6E6EE36231747F04_151090703.addTaint(taint);
            throw varBEA526F4B61D519C6E6EE36231747F04_151090703;
        } //End block
    if(handleId == contentId)        
        {
            IllegalArgumentException var2C5F7E1F10CCC54D942352B64341DD00_38200066 = new IllegalArgumentException("The content and handle attributes must refer "
                    + "to different children.");
            var2C5F7E1F10CCC54D942352B64341DD00_38200066.addTaint(taint);
            throw var2C5F7E1F10CCC54D942352B64341DD00_38200066;
        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.707 -0400", hash_original_method = "D4721D394CC37BD7B7DC0DFF43B7CD6B", hash_generated_method = "4EA6BE7541C6FF9223C23C84D3819389")
    @Override
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mHandle = findViewById(mHandleId);
    if(mHandle == null)        
        {
            IllegalArgumentException var0D245C5A21E1FE8AC78DA7281CE3CBB5_1133535871 = new IllegalArgumentException("The handle attribute is must refer to an"
                    + " existing child.");
            var0D245C5A21E1FE8AC78DA7281CE3CBB5_1133535871.addTaint(taint);
            throw var0D245C5A21E1FE8AC78DA7281CE3CBB5_1133535871;
        } //End block
        mHandle.setOnClickListener(new DrawerToggler());
        mContent = findViewById(mContentId);
    if(mContent == null)        
        {
            IllegalArgumentException var1E82C79EE502EF847EC1FA156599A707_1887401833 = new IllegalArgumentException("The content attribute is must refer to an" 
                    + " existing child.");
            var1E82C79EE502EF847EC1FA156599A707_1887401833.addTaint(taint);
            throw var1E82C79EE502EF847EC1FA156599A707_1887401833;
        } //End block
        mContent.setVisibility(View.GONE);
        // ---------- Original Method ----------
        //mHandle = findViewById(mHandleId);
        //if (mHandle == null) {
            //throw new IllegalArgumentException("The handle attribute is must refer to an"
                    //+ " existing child.");
        //}
        //mHandle.setOnClickListener(new DrawerToggler());
        //mContent = findViewById(mContentId);
        //if (mContent == null) {
            //throw new IllegalArgumentException("The content attribute is must refer to an" 
                    //+ " existing child.");
        //}
        //mContent.setVisibility(View.GONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.708 -0400", hash_original_method = "45D03353ADB6FD3256F7B7DABD84ED03", hash_generated_method = "4FDFD1279B97E7BC72A2DE4605360469")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
    if(widthSpecMode == MeasureSpec.UNSPECIFIED || heightSpecMode == MeasureSpec.UNSPECIFIED)        
        {
            RuntimeException var40119E22CBC60A0B042BB3392F9C3E11_572998653 = new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
            var40119E22CBC60A0B042BB3392F9C3E11_572998653.addTaint(taint);
            throw var40119E22CBC60A0B042BB3392F9C3E11_572998653;
        } //End block
        final View handle = mHandle;
        measureChild(handle, widthMeasureSpec, heightMeasureSpec);
    if(mVertical)        
        {
            int height = heightSpecSize - handle.getMeasuredHeight() - mTopOffset;
            mContent.measure(MeasureSpec.makeMeasureSpec(widthSpecSize, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
        } //End block
        else
        {
            int width = widthSpecSize - handle.getMeasuredWidth() - mTopOffset;
            mContent.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(heightSpecSize, MeasureSpec.EXACTLY));
        } //End block
        setMeasuredDimension(widthSpecSize, heightSpecSize);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.709 -0400", hash_original_method = "A279E67FA1A6901C21F6D4D49CA58425", hash_generated_method = "B69575D4E5911D1F64B02E2E88A02685")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        final long drawingTime = getDrawingTime();
        final View handle = mHandle;
        final boolean isVertical = mVertical;
        drawChild(canvas, handle, drawingTime);
    if(mTracking || mAnimating)        
        {
            final Bitmap cache = mContent.getDrawingCache();
    if(cache != null)            
            {
    if(isVertical)                
                {
                    canvas.drawBitmap(cache, 0, handle.getBottom(), null);
                } //End block
                else
                {
                    canvas.drawBitmap(cache, handle.getRight(), 0, null);
                } //End block
            } //End block
            else
            {
                canvas.save();
                canvas.translate(isVertical ? 0 : handle.getLeft() - mTopOffset,
                        isVertical ? handle.getTop() - mTopOffset : 0);
                drawChild(canvas, mContent, drawingTime);
                canvas.restore();
            } //End block
        } //End block
        else
    if(mExpanded)        
        {
            drawChild(canvas, mContent, drawingTime);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.710 -0400", hash_original_method = "5CD9193E39A65D0460D4DE7F7A8E61BB", hash_generated_method = "3DC995BB7BB6F0FD711E20DF3A25781A")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
    if(mTracking)        
        {
            return;
        } //End block
        final int width = r - l;
        final int height = b - t;
        final View handle = mHandle;
        int childWidth = handle.getMeasuredWidth();
        int childHeight = handle.getMeasuredHeight();
        int childLeft;
        int childTop;
        final View content = mContent;
    if(mVertical)        
        {
            childLeft = (width - childWidth) / 2;
            childTop = mExpanded ? mTopOffset : height - childHeight + mBottomOffset;
            content.layout(0, mTopOffset + childHeight, content.getMeasuredWidth(),
                    mTopOffset + childHeight + content.getMeasuredHeight());
        } //End block
        else
        {
            childLeft = mExpanded ? mTopOffset : width - childWidth + mBottomOffset;
            childTop = (height - childHeight) / 2;
            content.layout(mTopOffset + childWidth, 0,
                    mTopOffset + childWidth + content.getMeasuredWidth(),
                    content.getMeasuredHeight());
        } //End block
        handle.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
        mHandleHeight = handle.getHeight();
        mHandleWidth = handle.getWidth();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.711 -0400", hash_original_method = "DEC86D4E986198170B4E32A8C9B969F8", hash_generated_method = "3484DF20282D25F766F2ED10CE755950")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
    if(mLocked)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1677126134 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81310261 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_81310261;
        } //End block
        final int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        final Rect frame = mFrame;
        final View handle = mHandle;
        handle.getHitRect(frame);
    if(!mTracking && !frame.contains((int) x, (int) y))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1683473240 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052964576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052964576;
        } //End block
    if(action == MotionEvent.ACTION_DOWN)        
        {
            mTracking = true;
            handle.setPressed(true);
            prepareContent();
    if(mOnDrawerScrollListener != null)            
            {
                mOnDrawerScrollListener.onScrollStarted();
            } //End block
    if(mVertical)            
            {
                final int top = mHandle.getTop();
                mTouchDelta = (int) y - top;
                prepareTracking(top);
            } //End block
            else
            {
                final int left = mHandle.getLeft();
                mTouchDelta = (int) x - left;
                prepareTracking(left);
            } //End block
            mVelocityTracker.addMovement(event);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_17160114 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373799542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_373799542;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.714 -0400", hash_original_method = "BD859C70C763183DAB172469AFBE0279", hash_generated_method = "CE829700E8AE535786DFA2169FBE205B")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
    if(mLocked)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1937624116 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1037596541 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1037596541;
        } //End block
    if(mTracking)        
        {
            mVelocityTracker.addMovement(event);
            final int action = event.getAction();
switch(action){
            case MotionEvent.ACTION_MOVE:
            moveHandle((int) (mVertical ? event.getY() : event.getX()) - mTouchDelta);
            break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
            {
                final VelocityTracker velocityTracker = mVelocityTracker;
                velocityTracker.computeCurrentVelocity(mVelocityUnits);
                float yVelocity = velocityTracker.getYVelocity();
                float xVelocity = velocityTracker.getXVelocity();
                boolean negative;
                final boolean vertical = mVertical;
    if(vertical)                
                {
                    negative = yVelocity < 0;
    if(xVelocity < 0)                    
                    {
                        xVelocity = -xVelocity;
                    } //End block
    if(xVelocity > mMaximumMinorVelocity)                    
                    {
                        xVelocity = mMaximumMinorVelocity;
                    } //End block
                } //End block
                else
                {
                    negative = xVelocity < 0;
    if(yVelocity < 0)                    
                    {
                        yVelocity = -yVelocity;
                    } //End block
    if(yVelocity > mMaximumMinorVelocity)                    
                    {
                        yVelocity = mMaximumMinorVelocity;
                    } //End block
                } //End block
                float velocity = (float) Math.hypot(xVelocity, yVelocity);
    if(negative)                
                {
                    velocity = -velocity;
                } //End block
                final int top = mHandle.getTop();
                final int left = mHandle.getLeft();
    if(Math.abs(velocity) < mMaximumTapVelocity)                
                {
    if(vertical ? (mExpanded && top < mTapThreshold + mTopOffset) ||
                                (!mExpanded && top > mBottomOffset + mBottom - mTop -
                                        mHandleHeight - mTapThreshold) :
                                (mExpanded && left < mTapThreshold + mTopOffset) ||
                                (!mExpanded && left > mBottomOffset + mRight - mLeft -
                                        mHandleWidth - mTapThreshold))                    
                    {
    if(mAllowSingleTap)                        
                        {
                            playSoundEffect(SoundEffectConstants.CLICK);
    if(mExpanded)                            
                            {
                                animateClose(vertical ? top : left);
                            } //End block
                            else
                            {
                                animateOpen(vertical ? top : left);
                            } //End block
                        } //End block
                        else
                        {
                            performFling(vertical ? top : left, velocity, false);
                        } //End block
                    } //End block
                    else
                    {
                        performFling(vertical ? top : left, velocity, false);
                    } //End block
                } //End block
                else
                {
                    performFling(vertical ? top : left, velocity, false);
                } //End block
            } //End block
            break;
}
        } //End block
        boolean varCDCADA0FF00F152B6F2B05FCBD754767_2009570073 = (mTracking || mAnimating || super.onTouchEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1475972568 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1475972568;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.715 -0400", hash_original_method = "88CBA816EA18A335641DE4CDFF39F34A", hash_generated_method = "B4CA1930A20B771C06C344DC0BD8E1E3")
    private void animateClose(int position) {
        addTaint(position);
        prepareTracking(position);
        performFling(position, mMaximumAcceleration, true);
        // ---------- Original Method ----------
        //prepareTracking(position);
        //performFling(position, mMaximumAcceleration, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.715 -0400", hash_original_method = "C2A732DFCC58ACB6BBE028A7D0745854", hash_generated_method = "B9B2C10D5AFA205190B830FA8287A839")
    private void animateOpen(int position) {
        addTaint(position);
        prepareTracking(position);
        performFling(position, -mMaximumAcceleration, true);
        // ---------- Original Method ----------
        //prepareTracking(position);
        //performFling(position, -mMaximumAcceleration, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.717 -0400", hash_original_method = "D605C0C7A0239DE60A633AEEC0D2A029", hash_generated_method = "72A319FCFE2C9862A4586ED91FB67874")
    private void performFling(int position, float velocity, boolean always) {
        addTaint(always);
        mAnimationPosition = position;
        mAnimatedVelocity = velocity;
    if(mExpanded)        
        {
    if(always || (velocity > mMaximumMajorVelocity ||
                    (position > mTopOffset + (mVertical ? mHandleHeight : mHandleWidth) &&
                            velocity > -mMaximumMajorVelocity)))            
            {
                mAnimatedAcceleration = mMaximumAcceleration;
    if(velocity < 0)                
                {
                    mAnimatedVelocity = 0;
                } //End block
            } //End block
            else
            {
                mAnimatedAcceleration = -mMaximumAcceleration;
    if(velocity > 0)                
                {
                    mAnimatedVelocity = 0;
                } //End block
            } //End block
        } //End block
        else
        {
    if(!always && (velocity > mMaximumMajorVelocity ||
                    (position > (mVertical ? getHeight() : getWidth()) / 2 &&
                            velocity > -mMaximumMajorVelocity)))            
            {
                mAnimatedAcceleration = mMaximumAcceleration;
    if(velocity < 0)                
                {
                    mAnimatedVelocity = 0;
                } //End block
            } //End block
            else
            {
                mAnimatedAcceleration = -mMaximumAcceleration;
    if(velocity > 0)                
                {
                    mAnimatedVelocity = 0;
                } //End block
            } //End block
        } //End block
        long now = SystemClock.uptimeMillis();
        mAnimationLastTime = now;
        mCurrentAnimationTime = now + ANIMATION_FRAME_DURATION;
        mAnimating = true;
        mHandler.removeMessages(MSG_ANIMATE);
        mHandler.sendMessageAtTime(mHandler.obtainMessage(MSG_ANIMATE), mCurrentAnimationTime);
        stopTracking();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.719 -0400", hash_original_method = "59A44BD10421444D4E6898819BFB6759", hash_generated_method = "B0117B393D003F6670CDF6A5B86DCE83")
    private void prepareTracking(int position) {
        addTaint(position);
        mTracking = true;
        mVelocityTracker = VelocityTracker.obtain();
        boolean opening = !mExpanded;
    if(opening)        
        {
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
        } //End block
        else
        {
    if(mAnimating)            
            {
                mAnimating = false;
                mHandler.removeMessages(MSG_ANIMATE);
            } //End block
            moveHandle(position);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.720 -0400", hash_original_method = "EB5E8744EDA67A38CC286A32349D536F", hash_generated_method = "4A6FD9BE13D0975406D1561B630FD014")
    private void moveHandle(int position) {
        addTaint(position);
        final View handle = mHandle;
    if(mVertical)        
        {
    if(position == EXPANDED_FULL_OPEN)            
            {
                handle.offsetTopAndBottom(mTopOffset - handle.getTop());
                invalidate();
            } //End block
            else
    if(position == COLLAPSED_FULL_CLOSED)            
            {
                handle.offsetTopAndBottom(mBottomOffset + mBottom - mTop -
                        mHandleHeight - handle.getTop());
                invalidate();
            } //End block
            else
            {
                final int top = handle.getTop();
                int deltaY = position - top;
    if(position < mTopOffset)                
                {
                    deltaY = mTopOffset - top;
                } //End block
                else
    if(deltaY > mBottomOffset + mBottom - mTop - mHandleHeight - top)                
                {
                    deltaY = mBottomOffset + mBottom - mTop - mHandleHeight - top;
                } //End block
                handle.offsetTopAndBottom(deltaY);
                final Rect frame = mFrame;
                final Rect region = mInvalidate;
                handle.getHitRect(frame);
                region.set(frame);
                region.union(frame.left, frame.top - deltaY, frame.right, frame.bottom - deltaY);
                region.union(0, frame.bottom - deltaY, getWidth(),
                        frame.bottom - deltaY + mContent.getHeight());
                invalidate(region);
            } //End block
        } //End block
        else
        {
    if(position == EXPANDED_FULL_OPEN)            
            {
                handle.offsetLeftAndRight(mTopOffset - handle.getLeft());
                invalidate();
            } //End block
            else
    if(position == COLLAPSED_FULL_CLOSED)            
            {
                handle.offsetLeftAndRight(mBottomOffset + mRight - mLeft -
                        mHandleWidth - handle.getLeft());
                invalidate();
            } //End block
            else
            {
                final int left = handle.getLeft();
                int deltaX = position - left;
    if(position < mTopOffset)                
                {
                    deltaX = mTopOffset - left;
                } //End block
                else
    if(deltaX > mBottomOffset + mRight - mLeft - mHandleWidth - left)                
                {
                    deltaX = mBottomOffset + mRight - mLeft - mHandleWidth - left;
                } //End block
                handle.offsetLeftAndRight(deltaX);
                final Rect frame = mFrame;
                final Rect region = mInvalidate;
                handle.getHitRect(frame);
                region.set(frame);
                region.union(frame.left - deltaX, frame.top, frame.right - deltaX, frame.bottom);
                region.union(frame.right - deltaX, 0,
                        frame.right - deltaX + mContent.getWidth(), getHeight());
                invalidate(region);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.721 -0400", hash_original_method = "8AB257947D81E84CE88DA2BD3F113967", hash_generated_method = "FB35F7E9C02172C82A89EF62200B97BB")
    private void prepareContent() {
    if(mAnimating)        
        {
            return;
        } //End block
        final View content = mContent;
    if(content.isLayoutRequested())        
        {
    if(mVertical)            
            {
                final int childHeight = mHandleHeight;
                int height = mBottom - mTop - childHeight - mTopOffset;
                content.measure(MeasureSpec.makeMeasureSpec(mRight - mLeft, MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                content.layout(0, mTopOffset + childHeight, content.getMeasuredWidth(),
                        mTopOffset + childHeight + content.getMeasuredHeight());
            } //End block
            else
            {
                final int childWidth = mHandle.getWidth();
                int width = mRight - mLeft - childWidth - mTopOffset;
                content.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(mBottom - mTop, MeasureSpec.EXACTLY));
                content.layout(childWidth + mTopOffset, 0,
                        mTopOffset + childWidth + content.getMeasuredWidth(),
                        content.getMeasuredHeight());
            } //End block
        } //End block
        content.getViewTreeObserver().dispatchOnPreDraw();
    if(!content.isHardwareAccelerated())        
        content.buildDrawingCache();
        content.setVisibility(View.GONE);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.722 -0400", hash_original_method = "211492025B22CF1DCBA38CDE66604CEE", hash_generated_method = "CA3520032B72423EE1C42195F479A543")
    private void stopTracking() {
        mHandle.setPressed(false);
        mTracking = false;
    if(mOnDrawerScrollListener != null)        
        {
            mOnDrawerScrollListener.onScrollEnded();
        } //End block
    if(mVelocityTracker != null)        
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
        // ---------- Original Method ----------
        //mHandle.setPressed(false);
        //mTracking = false;
        //if (mOnDrawerScrollListener != null) {
            //mOnDrawerScrollListener.onScrollEnded();
        //}
        //if (mVelocityTracker != null) {
            //mVelocityTracker.recycle();
            //mVelocityTracker = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.722 -0400", hash_original_method = "1985F913D861388A154BC055CAF12D3C", hash_generated_method = "084F8BA0CE6ED3CCE121770A45D51751")
    private void doAnimation() {
    if(mAnimating)        
        {
            incrementAnimation();
    if(mAnimationPosition >= mBottomOffset + (mVertical ? getHeight() : getWidth()) - 1)            
            {
                mAnimating = false;
                closeDrawer();
            } //End block
            else
    if(mAnimationPosition < mTopOffset)            
            {
                mAnimating = false;
                openDrawer();
            } //End block
            else
            {
                moveHandle((int) mAnimationPosition);
                mCurrentAnimationTime += ANIMATION_FRAME_DURATION;
                mHandler.sendMessageAtTime(mHandler.obtainMessage(MSG_ANIMATE),
                        mCurrentAnimationTime);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAnimating) {
            //incrementAnimation();
            //if (mAnimationPosition >= mBottomOffset + (mVertical ? getHeight() : getWidth()) - 1) {
                //mAnimating = false;
                //closeDrawer();
            //} else if (mAnimationPosition < mTopOffset) {
                //mAnimating = false;
                //openDrawer();
            //} else {
                //moveHandle((int) mAnimationPosition);
                //mCurrentAnimationTime += ANIMATION_FRAME_DURATION;
                //mHandler.sendMessageAtTime(mHandler.obtainMessage(MSG_ANIMATE),
                        //mCurrentAnimationTime);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.723 -0400", hash_original_method = "D38E54734013AFEACE31D553AEEA44A0", hash_generated_method = "67E532C08C34AFBB41200F884128FA5C")
    private void incrementAnimation() {
        long now = SystemClock.uptimeMillis();
        float t = (now - mAnimationLastTime) / 1000.0f;
        final float position = mAnimationPosition;
        final float v = mAnimatedVelocity;
        final float a = mAnimatedAcceleration;
        mAnimationPosition = position + (v * t) + (0.5f * a * t * t);
        mAnimatedVelocity = v + (a * t);
        mAnimationLastTime = now;
        // ---------- Original Method ----------
        //long now = SystemClock.uptimeMillis();
        //float t = (now - mAnimationLastTime) / 1000.0f;
        //final float position = mAnimationPosition;
        //final float v = mAnimatedVelocity;
        //final float a = mAnimatedAcceleration;
        //mAnimationPosition = position + (v * t) + (0.5f * a * t * t);
        //mAnimatedVelocity = v + (a * t);
        //mAnimationLastTime = now;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.724 -0400", hash_original_method = "03CAF29C80FE37AB685D8DAE18F070E8", hash_generated_method = "18E946E9C2C4A3F7300BEF32BD1960E8")
    public void toggle() {
    if(!mExpanded)        
        {
            openDrawer();
        } //End block
        else
        {
            closeDrawer();
        } //End block
        invalidate();
        requestLayout();
        // ---------- Original Method ----------
        //if (!mExpanded) {
            //openDrawer();
        //} else {
            //closeDrawer();
        //}
        //invalidate();
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.724 -0400", hash_original_method = "43E4720445BBEABBD21F59D3B8D3127A", hash_generated_method = "CBA6DCEF393570FCD0D64AD893C374E6")
    public void animateToggle() {
    if(!mExpanded)        
        {
            animateOpen();
        } //End block
        else
        {
            animateClose();
        } //End block
        // ---------- Original Method ----------
        //if (!mExpanded) {
            //animateOpen();
        //} else {
            //animateClose();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.724 -0400", hash_original_method = "5DD756EDEA96CF75D5A9F7EAA046E366", hash_generated_method = "8C3BDDE630CDCAD63FEB8A7201FE9C26")
    public void open() {
        openDrawer();
        invalidate();
        requestLayout();
        sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        // ---------- Original Method ----------
        //openDrawer();
        //invalidate();
        //requestLayout();
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.724 -0400", hash_original_method = "3C4BA0CB6A211EA5F01C92F64D60529B", hash_generated_method = "DC98EEA1C46B2004CB28C649153D850E")
    public void close() {
        closeDrawer();
        invalidate();
        requestLayout();
        // ---------- Original Method ----------
        //closeDrawer();
        //invalidate();
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.725 -0400", hash_original_method = "14EAEC241F22C4A095DF4C0D05999E3B", hash_generated_method = "2397603D1E1ED336634F6F798C415A7E")
    public void animateClose() {
        prepareContent();
        final OnDrawerScrollListener scrollListener = mOnDrawerScrollListener;
    if(scrollListener != null)        
        {
            scrollListener.onScrollStarted();
        } //End block
        animateClose(mVertical ? mHandle.getTop() : mHandle.getLeft());
    if(scrollListener != null)        
        {
            scrollListener.onScrollEnded();
        } //End block
        // ---------- Original Method ----------
        //prepareContent();
        //final OnDrawerScrollListener scrollListener = mOnDrawerScrollListener;
        //if (scrollListener != null) {
            //scrollListener.onScrollStarted();
        //}
        //animateClose(mVertical ? mHandle.getTop() : mHandle.getLeft());
        //if (scrollListener != null) {
            //scrollListener.onScrollEnded();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.725 -0400", hash_original_method = "DF9AA0E5A29CC27A1E0772A609A87271", hash_generated_method = "E2928348EB80AB40965D3FAD1B440F2B")
    public void animateOpen() {
        prepareContent();
        final OnDrawerScrollListener scrollListener = mOnDrawerScrollListener;
    if(scrollListener != null)        
        {
            scrollListener.onScrollStarted();
        } //End block
        animateOpen(mVertical ? mHandle.getTop() : mHandle.getLeft());
        sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
    if(scrollListener != null)        
        {
            scrollListener.onScrollEnded();
        } //End block
        // ---------- Original Method ----------
        //prepareContent();
        //final OnDrawerScrollListener scrollListener = mOnDrawerScrollListener;
        //if (scrollListener != null) {
            //scrollListener.onScrollStarted();
        //}
        //animateOpen(mVertical ? mHandle.getTop() : mHandle.getLeft());
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        //if (scrollListener != null) {
            //scrollListener.onScrollEnded();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.726 -0400", hash_original_method = "1255865AE0DB052085CB21C8279D10AA", hash_generated_method = "0DE3464BE219B2823A96571BE1036781")
    private void closeDrawer() {
        moveHandle(COLLAPSED_FULL_CLOSED);
        mContent.setVisibility(View.GONE);
        mContent.destroyDrawingCache();
    if(!mExpanded)        
        {
            return;
        } //End block
        mExpanded = false;
    if(mOnDrawerCloseListener != null)        
        {
            mOnDrawerCloseListener.onDrawerClosed();
        } //End block
        // ---------- Original Method ----------
        //moveHandle(COLLAPSED_FULL_CLOSED);
        //mContent.setVisibility(View.GONE);
        //mContent.destroyDrawingCache();
        //if (!mExpanded) {
            //return;
        //}
        //mExpanded = false;
        //if (mOnDrawerCloseListener != null) {
            //mOnDrawerCloseListener.onDrawerClosed();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.726 -0400", hash_original_method = "68D1245B0829B631CA56B61B1EFB607E", hash_generated_method = "0541D688A2F251CE752456E450069118")
    private void openDrawer() {
        moveHandle(EXPANDED_FULL_OPEN);
        mContent.setVisibility(View.VISIBLE);
    if(mExpanded)        
        {
            return;
        } //End block
        mExpanded = true;
    if(mOnDrawerOpenListener != null)        
        {
            mOnDrawerOpenListener.onDrawerOpened();
        } //End block
        // ---------- Original Method ----------
        //moveHandle(EXPANDED_FULL_OPEN);
        //mContent.setVisibility(View.VISIBLE);
        //if (mExpanded) {
            //return;
        //}
        //mExpanded = true;
        //if (mOnDrawerOpenListener != null) {
            //mOnDrawerOpenListener.onDrawerOpened();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.726 -0400", hash_original_method = "2D7D8ECE305828F8F9DDACE01A4242C8", hash_generated_method = "E0B3A9851C5CE8512DC9E29CB4D86103")
    public void setOnDrawerOpenListener(OnDrawerOpenListener onDrawerOpenListener) {
        mOnDrawerOpenListener = onDrawerOpenListener;
        // ---------- Original Method ----------
        //mOnDrawerOpenListener = onDrawerOpenListener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.727 -0400", hash_original_method = "C6CA4E8603B3A8F496AF48C05AA699E0", hash_generated_method = "D9344A1513C556879AF916B3DDD50A11")
    public void setOnDrawerCloseListener(OnDrawerCloseListener onDrawerCloseListener) {
        mOnDrawerCloseListener = onDrawerCloseListener;
        // ---------- Original Method ----------
        //mOnDrawerCloseListener = onDrawerCloseListener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.727 -0400", hash_original_method = "F07CA388B1E1CC74CA965772D9BCDE7A", hash_generated_method = "0BFCFBDA38F914A759C4F0D488769B85")
    public void setOnDrawerScrollListener(OnDrawerScrollListener onDrawerScrollListener) {
        mOnDrawerScrollListener = onDrawerScrollListener;
        // ---------- Original Method ----------
        //mOnDrawerScrollListener = onDrawerScrollListener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.727 -0400", hash_original_method = "AE3D3479E28037BEE2B8772FADCA394B", hash_generated_method = "94AB984A2429AFC7BDDF36D4FF0F276E")
    public View getHandle() {
View varD901D87B73FFED5C94BAE428F6AEDBC4_2043823957 =         mHandle;
        varD901D87B73FFED5C94BAE428F6AEDBC4_2043823957.addTaint(taint);
        return varD901D87B73FFED5C94BAE428F6AEDBC4_2043823957;
        // ---------- Original Method ----------
        //return mHandle;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.728 -0400", hash_original_method = "383B97EB3876FB14240EC86DEF6C8427", hash_generated_method = "DD1C0840FF39634C85FCBF1774A491F4")
    public View getContent() {
View var5A3DC7582C8B2D33F643D83FF89F34A9_1984457952 =         mContent;
        var5A3DC7582C8B2D33F643D83FF89F34A9_1984457952.addTaint(taint);
        return var5A3DC7582C8B2D33F643D83FF89F34A9_1984457952;
        // ---------- Original Method ----------
        //return mContent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.728 -0400", hash_original_method = "2AEB4587AE0C07EB559A85B7E1ABA252", hash_generated_method = "E314C470674ECCC8403E0DBB0C6B63EB")
    public void unlock() {
        mLocked = false;
        // ---------- Original Method ----------
        //mLocked = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.728 -0400", hash_original_method = "32E6B7DBEEDBFAF28CCF0157F60F94F0", hash_generated_method = "AEE9AFA1D471F580D02FECAFDC04CE19")
    public void lock() {
        mLocked = true;
        // ---------- Original Method ----------
        //mLocked = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.728 -0400", hash_original_method = "A0663ABB788C8A0905C7EF76DE01C422", hash_generated_method = "4036FD1AAC322E0D562D830B86462887")
    public boolean isOpened() {
        boolean varEA52AC187B90D5B6EA1A48C8DE714672_2099520313 = (mExpanded);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971851830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_971851830;
        // ---------- Original Method ----------
        //return mExpanded;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.728 -0400", hash_original_method = "E24D6C05B3C8D3641FA197063B5CFCA4", hash_generated_method = "942325D77D986BE8C59ADFDA2F99BF57")
    public boolean isMoving() {
        boolean var060E86913631F7A7ACCFE3F8B176ED56_2036179173 = (mTracking || mAnimating);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1548641141 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1548641141;
        // ---------- Original Method ----------
        //return mTracking || mAnimating;
    }

    
    private class DrawerToggler implements OnClickListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.728 -0400", hash_original_method = "8DAFF423CC5901B0B532AD847FEA0938", hash_generated_method = "8DAFF423CC5901B0B532AD847FEA0938")
        public DrawerToggler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.729 -0400", hash_original_method = "D5ABF7EB3B9C4ED77CCCF3551465E2CF", hash_generated_method = "069C64D09D02AEAEBE2B605AA2A44B1B")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
    if(mLocked)            
            {
                return;
            } //End block
    if(mAnimateOnClick)            
            {
                animateToggle();
            } //End block
            else
            {
                toggle();
            } //End block
            // ---------- Original Method ----------
            //if (mLocked) {
                //return;
            //}
            //if (mAnimateOnClick) {
                //animateToggle();
            //} else {
                //toggle();
            //}
        }

        
    }


    
    private class SlidingHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.729 -0400", hash_original_method = "44797BB1CCD092762141D42397C614B8", hash_generated_method = "44797BB1CCD092762141D42397C614B8")
        public SlidingHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.729 -0400", hash_original_method = "8F95C74EDA64D211CE1AA49DFEDA489B", hash_generated_method = "8FB2B4565BD9734AB995452301554422")
        public void handleMessage(Message m) {
            addTaint(m.getTaint());
switch(m.what){
            case MSG_ANIMATE:
            doAnimation();
            break;
}
            // ---------- Original Method ----------
            //switch (m.what) {
                //case MSG_ANIMATE:
                    //doAnimation();
                    //break;
            //}
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.729 -0400", hash_original_field = "A6CC1B6AEA2BE897C12E626DF5D2D63F", hash_generated_field = "F5AA8D432C85B67F2F1A59A2F86C9B4F")

    public static final int ORIENTATION_HORIZONTAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.729 -0400", hash_original_field = "338593D0B5B8B58D823B3D6199A92CB2", hash_generated_field = "F0C280EF3D60F4930A958E8EA2B6AC4A")

    public static final int ORIENTATION_VERTICAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.729 -0400", hash_original_field = "9B435E92942D9C27D32C9EB050452AA1", hash_generated_field = "EF82FF38C70F34E835AAF92E9AE79EDE")

    private static final int TAP_THRESHOLD = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.730 -0400", hash_original_field = "FE0CDE50763253377B35F9726E8DE3D6", hash_generated_field = "D63B1940B01FABB1E3D03EB23FE92832")

    private static final float MAXIMUM_TAP_VELOCITY = 100.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.730 -0400", hash_original_field = "0FD89D0074F07DD696CED4BF30058E03", hash_generated_field = "3CE2263AFD5CC3F61D8EFDE0F528424B")

    private static final float MAXIMUM_MINOR_VELOCITY = 150.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.730 -0400", hash_original_field = "96E25579294B038967D0BB1B11513950", hash_generated_field = "9699AD213AD4F0D7F391F37EE0845A2D")

    private static final float MAXIMUM_MAJOR_VELOCITY = 200.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.730 -0400", hash_original_field = "E0AF561A05ACCDBC7B8A1919868F8BE4", hash_generated_field = "4793378A0C07082335C6CA4C8526E5BF")

    private static final float MAXIMUM_ACCELERATION = 2000.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.730 -0400", hash_original_field = "C5701D703B43C8AE7764A39D356D9237", hash_generated_field = "E448E4650222F119FB5A37956DC5373B")

    private static final int VELOCITY_UNITS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.730 -0400", hash_original_field = "88F1BBB7429BC1E69CA59568E35AACBC", hash_generated_field = "EE1617BC1FEDDA2BA932DADB3D158B26")

    private static final int MSG_ANIMATE = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.730 -0400", hash_original_field = "5C192592BBEDA8CCE9299B5B3A7C51C6", hash_generated_field = "2D5E1661995D2C98C7D09C38F816B311")

    private static final int ANIMATION_FRAME_DURATION = 1000 / 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.730 -0400", hash_original_field = "03AE50985D656765800AAEE4B8102910", hash_generated_field = "E6DD03D94ACD8E70EDDDE338DBF27AAF")

    private static final int EXPANDED_FULL_OPEN = -10001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.730 -0400", hash_original_field = "559ACB38837CA0A128A330A9C1707CE9", hash_generated_field = "B95F2443D5297E62D43F7D70D6A2C6EF")

    private static final int COLLAPSED_FULL_CLOSED = -10002;
}

