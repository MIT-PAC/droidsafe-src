package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.TypedValue;
import dalvik.system.CloseGuard;

public abstract class Animation implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.540 -0400", hash_original_field = "385457F169B7B8F3F055692484147005", hash_generated_field = "2B949884EB9BE3C788B16B27F6DA2E53")

    boolean mEnded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "5D947BF952E8653BAADEA609028A78F9")

    boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "575296D4A6E3181FC1FFE583DB23FE3E", hash_generated_field = "F5A90569EED95B6137362B9C24B64AD6")

    boolean mCycleFlip = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "D7228C282593CDC77734D668B23541D3")

    boolean mInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "3B491B352FA7FEC4F42E4EA841B4CBA0", hash_generated_field = "138DAF4C12E534C03F3D363580B12729")

    boolean mFillBefore = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "92913E273E0279A4A85EB0A92416C3BF", hash_generated_field = "0713D9CEE65AF19CBD303F718622380C")

    boolean mFillAfter = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "7CB365868E8AE80F9F2E13E360299B47", hash_generated_field = "CD0E2560F62E160B1797BA608E99A525")

    boolean mFillEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "1336377597E871AC0DE1145EFBE093CD", hash_generated_field = "81105A88481A5B0AE717E10F26F868BC")

    long mStartTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "3DABB18D4F451E36446933F4C828ACE8", hash_generated_field = "EA2AC6F7F17E9F5AC720129EC7B5A165")

    long mStartOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "CFDA69B4AD03D72FC4B0627E39231164")

    long mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "7400544E99BDB4AB399DABF03F346DE6", hash_generated_field = "8CAB60CAF9F0EC867720B208BC5D4CD6")

    int mRepeatCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "791E2D6BDEEED2FC776C97D105DDD2D3", hash_generated_field = "0909517ECD26F075EDEABEF3C36497E6")

    int mRepeated = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "31336EA85735F5B517DD430F87691118", hash_generated_field = "496B647F2BFAD8D2A4745DD01043EBB9")

    int mRepeatMode = RESTART;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "A1326AE9004157E0812422F0F20CD6F9")

    Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "A82325198CD06548448A0D3238E6DB44")

    AnimationListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.541 -0400", hash_original_field = "E675CAC16E3A7934B1BE5FDBE7138A04", hash_generated_field = "388F873F7FDD1B97364C31A2829DAA2F")

    private int mZAdjustment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_field = "F28F2DF30FA0A384EA442393DFFC03BB", hash_generated_field = "CC64588E1E08B8E0993874A8A69D251D")

    private int mBackgroundColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_field = "925897ADD5A4443B43C8F6FBC4424E0E", hash_generated_field = "55C0C2A62CD0016DB863EA4C86F92AB3")

    private float mScaleFactor = 1f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_field = "1B09FDB0A2E6AC18E9F1DBBB8735A0FE", hash_generated_field = "78F07B4146BD29D0652AD1623F0B1A21")

    private boolean mDetachWallpaper = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_field = "9200F97640525BADE0F5210B0BECB3CA", hash_generated_field = "EB7123F1E56B8FC7DB4670361B61F3BB")

    private boolean mMore = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_field = "68FEBF6A9F472E86EE32DBD86FFC61CF", hash_generated_field = "1A1B781F58C47FD588A3C25DEC073F2E")

    private boolean mOneMoreTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_field = "FD5E22922C653BFDA6DEA53809D83FA6", hash_generated_field = "1281DD848D4CAC286B7C56B469674D23")

    RectF mPreviousRegion = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_field = "5C3A8A09251061EEBB701527D514B5F2", hash_generated_field = "B8EF1E9F1F3FA3BF5EA38E9CC57EEE1D")

    RectF mRegion = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_field = "04EC513F4EC68C8BA1280847D108F54D", hash_generated_field = "96FFB41D18FE51CA2378656E6B610C99")

    Transformation mTransformation = new Transformation();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_field = "706404C2835CDB3C1939F923BB10605F", hash_generated_field = "82E7EE1C48131039EC27409DAF0D59C0")

    Transformation mPreviousTransformation = new Transformation();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.542 -0400", hash_original_method = "F5207BDCC3F51BB57C76C57DBA5A0AD4", hash_generated_method = "F05BFA516EF987BB837572F17670E4BF")
    public  Animation() {
        ensureInterpolator();
        // ---------- Original Method ----------
        //ensureInterpolator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.543 -0400", hash_original_method = "325850FA9042895E97F9004576A85DF0", hash_generated_method = "BC526CA0AEAC0C5F917F7EADA7EA0398")
    public  Animation(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.Animation);
        setDuration((long) a.getInt(com.android.internal.R.styleable.Animation_duration, 0));
        setStartOffset((long) a.getInt(com.android.internal.R.styleable.Animation_startOffset, 0));
        setFillEnabled(a.getBoolean(com.android.internal.R.styleable.Animation_fillEnabled, mFillEnabled));
        setFillBefore(a.getBoolean(com.android.internal.R.styleable.Animation_fillBefore, mFillBefore));
        setFillAfter(a.getBoolean(com.android.internal.R.styleable.Animation_fillAfter, mFillAfter));
        setRepeatCount(a.getInt(com.android.internal.R.styleable.Animation_repeatCount, mRepeatCount));
        setRepeatMode(a.getInt(com.android.internal.R.styleable.Animation_repeatMode, RESTART));
        setZAdjustment(a.getInt(com.android.internal.R.styleable.Animation_zAdjustment, ZORDER_NORMAL));
        setBackgroundColor(a.getInt(com.android.internal.R.styleable.Animation_background, 0));
        setDetachWallpaper(a.getBoolean(com.android.internal.R.styleable.Animation_detachWallpaper, false));
        final int resID = a.getResourceId(com.android.internal.R.styleable.Animation_interpolator, 0);
        a.recycle();
    if(resID > 0)        
        {
            setInterpolator(context, resID);
        } //End block
        ensureInterpolator();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.544 -0400", hash_original_method = "7BC58C079EA752AD7803A7DE0B66531B", hash_generated_method = "FBD4CFA50E52A538C305C4099A493B90")
    @Override
    protected Animation clone() throws CloneNotSupportedException {
        final Animation animation = (Animation) super.clone();
        animation.mPreviousRegion = new RectF();
        animation.mRegion = new RectF();
        animation.mTransformation = new Transformation();
        animation.mPreviousTransformation = new Transformation();
Animation var1D3E9F798E82851E6201AD690FEA4543_853892618 =         animation;
        var1D3E9F798E82851E6201AD690FEA4543_853892618.addTaint(taint);
        return var1D3E9F798E82851E6201AD690FEA4543_853892618;
        // ---------- Original Method ----------
        //final Animation animation = (Animation) super.clone();
        //animation.mPreviousRegion = new RectF();
        //animation.mRegion = new RectF();
        //animation.mTransformation = new Transformation();
        //animation.mPreviousTransformation = new Transformation();
        //return animation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.544 -0400", hash_original_method = "3AB995FAF173BC91AA72FEE328D0BE86", hash_generated_method = "8D4043FB51D478DAAF7B549EEBB6A8F3")
    public void reset() {
        mPreviousRegion.setEmpty();
        mPreviousTransformation.clear();
        mInitialized = false;
        mCycleFlip = false;
        mRepeated = 0;
        mMore = true;
        mOneMoreTime = true;
        // ---------- Original Method ----------
        //mPreviousRegion.setEmpty();
        //mPreviousTransformation.clear();
        //mInitialized = false;
        //mCycleFlip = false;
        //mRepeated = 0;
        //mMore = true;
        //mOneMoreTime = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.545 -0400", hash_original_method = "E313CF9FDC4A243810ECD11633502833", hash_generated_method = "7DCA98592D10FEF02347863ABB62475E")
    public void cancel() {
    if(mStarted && !mEnded)        
        {
    if(mListener != null)            
            mListener.onAnimationEnd(this);
            mEnded = true;
            guard.close();
        } //End block
        mStartTime = Long.MIN_VALUE;
        mMore = mOneMoreTime = false;
        // ---------- Original Method ----------
        //if (mStarted && !mEnded) {
            //if (mListener != null) mListener.onAnimationEnd(this);
            //mEnded = true;
            //guard.close();
        //}
        //mStartTime = Long.MIN_VALUE;
        //mMore = mOneMoreTime = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.545 -0400", hash_original_method = "BA118FB94C8A2A7F04D6CE25751A9CE0", hash_generated_method = "EABFF5C032B25525517DC724151C7582")
    public void detach() {
    if(mStarted && !mEnded)        
        {
            mEnded = true;
            guard.close();
    if(mListener != null)            
            mListener.onAnimationEnd(this);
        } //End block
        // ---------- Original Method ----------
        //if (mStarted && !mEnded) {
            //mEnded = true;
            //guard.close();
            //if (mListener != null) mListener.onAnimationEnd(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.546 -0400", hash_original_method = "130A49FBCE1398CCC055AA736C1B7B6D", hash_generated_method = "717A67344D31F609E72194E0833206DC")
    public boolean isInitialized() {
        boolean var57006E58594DC862E67D1855FDF16FEE_1993586729 = (mInitialized);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_240380535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_240380535;
        // ---------- Original Method ----------
        //return mInitialized;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.546 -0400", hash_original_method = "9B9AA705D4796FA141302715AF35F1C7", hash_generated_method = "1466AD62711EB1308AA4122A1AE85EA2")
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        addTaint(parentHeight);
        addTaint(parentWidth);
        addTaint(height);
        addTaint(width);
        reset();
        mInitialized = true;
        // ---------- Original Method ----------
        //reset();
        //mInitialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.547 -0400", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "FBCFFDB8934B412FCF947D3B533DE793")
    public void setInterpolator(Context context, int resID) {
        addTaint(resID);
        addTaint(context.getTaint());
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.547 -0400", hash_original_method = "4EEF3DF2F4BA4D9B865A07AD850625E7", hash_generated_method = "AA450A6BACD2D2A4B441CFF1CF324E18")
    public void setInterpolator(Interpolator i) {
        mInterpolator = i;
        // ---------- Original Method ----------
        //mInterpolator = i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.547 -0400", hash_original_method = "BF0ACB3E237AAE7044714380D4DED735", hash_generated_method = "424940C4F5E7DA004B724B16B7141A9B")
    public void setStartOffset(long startOffset) {
        mStartOffset = startOffset;
        // ---------- Original Method ----------
        //mStartOffset = startOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.548 -0400", hash_original_method = "C4FADDE7E113E13802025E54418B7E99", hash_generated_method = "FB25F2BCDEBDA76AC02AF537E17BE790")
    public void setDuration(long durationMillis) {
    if(durationMillis < 0)        
        {
            IllegalArgumentException var51691CB242FE64069838AA5B45CC3CE2_161830330 = new IllegalArgumentException("Animation duration cannot be negative");
            var51691CB242FE64069838AA5B45CC3CE2_161830330.addTaint(taint);
            throw var51691CB242FE64069838AA5B45CC3CE2_161830330;
        } //End block
        mDuration = durationMillis;
        // ---------- Original Method ----------
        //if (durationMillis < 0) {
            //throw new IllegalArgumentException("Animation duration cannot be negative");
        //}
        //mDuration = durationMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.549 -0400", hash_original_method = "448C869CF9265A7FCC7AB9AE39BBC12A", hash_generated_method = "611813BC3A9C9482D1D1856050DC63EA")
    public void restrictDuration(long durationMillis) {
    if(mStartOffset > durationMillis)        
        {
            mStartOffset = durationMillis;
            mDuration = 0;
            mRepeatCount = 0;
            return;
        } //End block
        long dur = mDuration + mStartOffset;
    if(dur > durationMillis)        
        {
            mDuration = durationMillis-mStartOffset;
            dur = durationMillis;
        } //End block
    if(mDuration <= 0)        
        {
            mDuration = 0;
            mRepeatCount = 0;
            return;
        } //End block
    if(mRepeatCount < 0 || mRepeatCount > durationMillis
                || (dur*mRepeatCount) > durationMillis)        
        {
            mRepeatCount = (int)(durationMillis/dur) - 1;
    if(mRepeatCount < 0)            
            {
                mRepeatCount = 0;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mStartOffset > durationMillis) {
            //mStartOffset = durationMillis;
            //mDuration = 0;
            //mRepeatCount = 0;
            //return;
        //}
        //long dur = mDuration + mStartOffset;
        //if (dur > durationMillis) {
            //mDuration = durationMillis-mStartOffset;
            //dur = durationMillis;
        //}
        //if (mDuration <= 0) {
            //mDuration = 0;
            //mRepeatCount = 0;
            //return;
        //}
        //if (mRepeatCount < 0 || mRepeatCount > durationMillis
                //|| (dur*mRepeatCount) > durationMillis) {
            //mRepeatCount = (int)(durationMillis/dur) - 1;
            //if (mRepeatCount < 0) {
                //mRepeatCount = 0;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.550 -0400", hash_original_method = "7B723F7D723B2ADF0E8C91EC6AA68330", hash_generated_method = "C4880321253D48FFDAEDC63441B30760")
    public void scaleCurrentDuration(float scale) {
        mDuration = (long) (mDuration * scale);
        mStartOffset = (long) (mStartOffset * scale);
        // ---------- Original Method ----------
        //mDuration = (long) (mDuration * scale);
        //mStartOffset = (long) (mStartOffset * scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.551 -0400", hash_original_method = "C5F2E1E5B86432971DA671FBAF722042", hash_generated_method = "F61EFA6E5B483C91A8AD0B877BECA980")
    public void setStartTime(long startTimeMillis) {
        mStartTime = startTimeMillis;
        mStarted = mEnded = false;
        mCycleFlip = false;
        mRepeated = 0;
        mMore = true;
        // ---------- Original Method ----------
        //mStartTime = startTimeMillis;
        //mStarted = mEnded = false;
        //mCycleFlip = false;
        //mRepeated = 0;
        //mMore = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.551 -0400", hash_original_method = "95CC5B32D25F554AB1041684F2D9EFB3", hash_generated_method = "C2C0CAF344BAFEE463FD4717BEBB205F")
    public void start() {
        setStartTime(-1);
        // ---------- Original Method ----------
        //setStartTime(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.551 -0400", hash_original_method = "66165BC7696DE4F74728FD45F7498148", hash_generated_method = "A6131EE72377D167A51760B30339E8DF")
    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
        // ---------- Original Method ----------
        //setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.551 -0400", hash_original_method = "DDD317A37915E8A65D2BE1E304EF578A", hash_generated_method = "17D1360A733DBD458CAB0359A395CE7B")
    public void setRepeatMode(int repeatMode) {
        mRepeatMode = repeatMode;
        // ---------- Original Method ----------
        //mRepeatMode = repeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.552 -0400", hash_original_method = "A134D6BEB9FF1047810E15F38A519E7E", hash_generated_method = "D6D45FE79F87C73238980F7EB2231048")
    public void setRepeatCount(int repeatCount) {
    if(repeatCount < 0)        
        {
            repeatCount = INFINITE;
        } //End block
        mRepeatCount = repeatCount;
        // ---------- Original Method ----------
        //if (repeatCount < 0) {
            //repeatCount = INFINITE;
        //}
        //mRepeatCount = repeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.552 -0400", hash_original_method = "99447AF68D215B648170642F948B1397", hash_generated_method = "87477991FDAD36AEC66173E3E4B5D6A0")
    public boolean isFillEnabled() {
        boolean varE5FF4E923688C3F9E16F2FEB30EFF09C_681144119 = (mFillEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399144874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399144874;
        // ---------- Original Method ----------
        //return mFillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.552 -0400", hash_original_method = "FD550D09AAFA6DFC07B09135F2C7B62C", hash_generated_method = "039C156EB130A31B2B3D2DDB452A9F4E")
    public void setFillEnabled(boolean fillEnabled) {
        mFillEnabled = fillEnabled;
        // ---------- Original Method ----------
        //mFillEnabled = fillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.552 -0400", hash_original_method = "4449C3292A8570D114A58B4E08D55011", hash_generated_method = "E22ACD6422C750DD61089037D6A5467E")
    public void setFillBefore(boolean fillBefore) {
        mFillBefore = fillBefore;
        // ---------- Original Method ----------
        //mFillBefore = fillBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.552 -0400", hash_original_method = "4CCE59DDFB007D2C725E384A84210333", hash_generated_method = "49F55925CC5A820D4B8135937231E53B")
    public void setFillAfter(boolean fillAfter) {
        mFillAfter = fillAfter;
        // ---------- Original Method ----------
        //mFillAfter = fillAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.552 -0400", hash_original_method = "B53AFA13C43018FC57757729E8C6F5B9", hash_generated_method = "468123765E68AF71806CFB4882A6CCA9")
    public void setZAdjustment(int zAdjustment) {
        mZAdjustment = zAdjustment;
        // ---------- Original Method ----------
        //mZAdjustment = zAdjustment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.552 -0400", hash_original_method = "5CC3CCDE182714D1D24D814D03E78D72", hash_generated_method = "1D031963F8D9249329C42FBB1A944D82")
    public void setBackgroundColor(int bg) {
        mBackgroundColor = bg;
        // ---------- Original Method ----------
        //mBackgroundColor = bg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.553 -0400", hash_original_method = "209B3580CB795CD8B9886E8B498D1959", hash_generated_method = "3098E8AAA554C12639E32487F160918A")
    protected float getScaleFactor() {
        float var43B25FDCBE078DC3DA65BC88CAA3AACD_1060335745 = (mScaleFactor);
                float var546ADE640B6EDFBC8A086EF31347E768_1986629841 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1986629841;
        // ---------- Original Method ----------
        //return mScaleFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.553 -0400", hash_original_method = "DC51879EADA1EC63F555D590C58841F2", hash_generated_method = "FA1E152176E4962E1A592137B68096BA")
    public void setDetachWallpaper(boolean detachWallpaper) {
        mDetachWallpaper = detachWallpaper;
        // ---------- Original Method ----------
        //mDetachWallpaper = detachWallpaper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.553 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "95389A6A7BEC0D6C9329C4D6C1B6A376")
    public Interpolator getInterpolator() {
Interpolator var9FA301F6AF154FEBBB2C7439D021F894_1909354309 =         mInterpolator;
        var9FA301F6AF154FEBBB2C7439D021F894_1909354309.addTaint(taint);
        return var9FA301F6AF154FEBBB2C7439D021F894_1909354309;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.553 -0400", hash_original_method = "62DE33F2E1C7C51F234B4CE29FC5DCED", hash_generated_method = "85281B517FF76F6DEB0B313A485D5F82")
    public long getStartTime() {
        long var4FBE52F16DA5DC1AFB86B1520E59C2C0_1973622375 = (mStartTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1072792829 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1072792829;
        // ---------- Original Method ----------
        //return mStartTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.553 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "F4A9A866B3E5A276141B90A0D95742D1")
    public long getDuration() {
        long var25395741BFE51A7D136A5C7109AAD2D8_1878708752 = (mDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_19731866 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_19731866;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.553 -0400", hash_original_method = "F15F7E68559FE94D65E8E77E2E4D8AE9", hash_generated_method = "5CA39B57BE60F6970ECB7AE247E5415F")
    public long getStartOffset() {
        long var3DABB18D4F451E36446933F4C828ACE8_1147395210 = (mStartOffset);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_297056502 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_297056502;
        // ---------- Original Method ----------
        //return mStartOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.553 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "4D535CFF3776432A3E605EB799ED4A9F")
    public int getRepeatMode() {
        int var0F7262183FEB856E4BA3C1C837CA6BEF_1003974285 = (mRepeatMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1928636227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1928636227;
        // ---------- Original Method ----------
        //return mRepeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.553 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "B221D2C1E22B282E813E5B05AEA34747")
    public int getRepeatCount() {
        int varF545692334BC1E20E53D9FB0B2CFFF33_678098811 = (mRepeatCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179345908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179345908;
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.553 -0400", hash_original_method = "EC25BC6D19EE141C12788801543B6178", hash_generated_method = "DCC2FFEDD163C31650431A5DDF9C88CF")
    public boolean getFillBefore() {
        boolean varA57F0DAA555C436F2FAABBF143AC9430_1097136815 = (mFillBefore);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130540597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130540597;
        // ---------- Original Method ----------
        //return mFillBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.553 -0400", hash_original_method = "6D667DA3C62337EC4E4606350728AE89", hash_generated_method = "259B6BBCFC82BFEFB0EE20A27DAA5E36")
    public boolean getFillAfter() {
        boolean var01298A1E71844424D6B5C82979029B11_656655169 = (mFillAfter);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_430499337 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_430499337;
        // ---------- Original Method ----------
        //return mFillAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.554 -0400", hash_original_method = "409F6F7832CADDC17E7E5231CAA22AC6", hash_generated_method = "9C091EE10850E11CDD6342C73DFCCAEE")
    public int getZAdjustment() {
        int varE675CAC16E3A7934B1BE5FDBE7138A04_1284110482 = (mZAdjustment);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702952391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702952391;
        // ---------- Original Method ----------
        //return mZAdjustment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.554 -0400", hash_original_method = "FAF00526A7BA7C979C907792653A05BB", hash_generated_method = "829501D23F9D6693493C0D5A7156109A")
    public int getBackgroundColor() {
        int varF28F2DF30FA0A384EA442393DFFC03BB_1219673283 = (mBackgroundColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686132029 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686132029;
        // ---------- Original Method ----------
        //return mBackgroundColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.554 -0400", hash_original_method = "E6A00B836A83DBDC739846B44941121A", hash_generated_method = "AF9516C8A6DF0B6F87CFC15ED0D6D301")
    public boolean getDetachWallpaper() {
        boolean varE33318853D6859ECBDE23F3B978DD05B_1327002549 = (mDetachWallpaper);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055268820 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055268820;
        // ---------- Original Method ----------
        //return mDetachWallpaper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.554 -0400", hash_original_method = "06611FABC5DAE0D86003F0AC94713BBE", hash_generated_method = "27A82BD4F1FC060CD9475063DE688FB4")
    public boolean willChangeTransformationMatrix() {
        boolean varB326B5062B2F0E69046810717534CB09_929968828 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_187473539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_187473539;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.554 -0400", hash_original_method = "75ECA58382FCAFBFF99662736FC361D6", hash_generated_method = "5D26F91DD7BFEB91B8D7C0D1DB79F059")
    public boolean willChangeBounds() {
        boolean varB326B5062B2F0E69046810717534CB09_2028597991 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485053480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_485053480;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.554 -0400", hash_original_method = "93175FBEC8620A1D25367C53936C85B5", hash_generated_method = "B6B2E431FB5A3DE909C2B13E925B35BF")
    public void setAnimationListener(AnimationListener listener) {
        mListener = listener;
        // ---------- Original Method ----------
        //mListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.554 -0400", hash_original_method = "B0865E74040125EA32BE48261064C937", hash_generated_method = "793ED1247E55BB87475DDB7CEC9F20FF")
    protected void ensureInterpolator() {
    if(mInterpolator == null)        
        {
            mInterpolator = new AccelerateDecelerateInterpolator();
        } //End block
        // ---------- Original Method ----------
        //if (mInterpolator == null) {
            //mInterpolator = new AccelerateDecelerateInterpolator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.555 -0400", hash_original_method = "B3F1AB6DDEFF92B122293B4363A1C456", hash_generated_method = "3557BD6580CC9672965E7694951408E8")
    public long computeDurationHint() {
        long var0B2285DA4F2EC970D16574DF97CEF337_78742673 = ((getStartOffset() + getDuration()) * (getRepeatCount() + 1));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_968254163 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_968254163;
        // ---------- Original Method ----------
        //return (getStartOffset() + getDuration()) * (getRepeatCount() + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.556 -0400", hash_original_method = "1D66EEFFAD10DF7675973FFD0CA72C11", hash_generated_method = "CC7559D9EBB207D41320FA9BE8C6A199")
    public boolean getTransformation(long currentTime, Transformation outTransformation) {
        addTaint(outTransformation.getTaint());
    if(mStartTime == -1)        
        {
            mStartTime = currentTime;
        } //End block
        final long startOffset = getStartOffset();
        final long duration = mDuration;
        float normalizedTime;
    if(duration != 0)        
        {
            normalizedTime = ((float) (currentTime - (mStartTime + startOffset))) /
                    (float) duration;
        } //End block
        else
        {
            normalizedTime = currentTime < mStartTime ? 0.0f : 1.0f;
        } //End block
        final boolean expired = normalizedTime >= 1.0f;
        mMore = !expired;
    if(!mFillEnabled)        
        normalizedTime = Math.max(Math.min(normalizedTime, 1.0f), 0.0f);
    if((normalizedTime >= 0.0f || mFillBefore) && (normalizedTime <= 1.0f || mFillAfter))        
        {
    if(!mStarted)            
            {
    if(mListener != null)                
                {
                    mListener.onAnimationStart(this);
                } //End block
                mStarted = true;
    if(USE_CLOSEGUARD)                
                {
                    guard.open("cancel or detach or getTransformation");
                } //End block
            } //End block
    if(mFillEnabled)            
            normalizedTime = Math.max(Math.min(normalizedTime, 1.0f), 0.0f);
    if(mCycleFlip)            
            {
                normalizedTime = 1.0f - normalizedTime;
            } //End block
            final float interpolatedTime = mInterpolator.getInterpolation(normalizedTime);
            applyTransformation(interpolatedTime, outTransformation);
        } //End block
    if(expired)        
        {
    if(mRepeatCount == mRepeated)            
            {
    if(!mEnded)                
                {
                    mEnded = true;
                    guard.close();
    if(mListener != null)                    
                    {
                        mListener.onAnimationEnd(this);
                    } //End block
                } //End block
            } //End block
            else
            {
    if(mRepeatCount > 0)                
                {
                    mRepeated++;
                } //End block
    if(mRepeatMode == REVERSE)                
                {
                    mCycleFlip = !mCycleFlip;
                } //End block
                mStartTime = -1;
                mMore = true;
    if(mListener != null)                
                {
                    mListener.onAnimationRepeat(this);
                } //End block
            } //End block
        } //End block
    if(!mMore && mOneMoreTime)        
        {
            mOneMoreTime = false;
            boolean varB326B5062B2F0E69046810717534CB09_1984804703 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938149744 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_938149744;
        } //End block
        boolean var2BB16EA2A1F64B8DD4082465F69C1230_644784423 = (mMore);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687135426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687135426;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.557 -0400", hash_original_method = "2D55A6E78A3D329DDFA1835011833D50", hash_generated_method = "AA2812D13C3042EFD6CAD2AFF142882C")
    public boolean getTransformation(long currentTime, Transformation outTransformation,
            float scale) {
        addTaint(outTransformation.getTaint());
        addTaint(currentTime);
        mScaleFactor = scale;
        boolean var4E7B36E16262D8BA477F30DBF30A8521_1494403962 = (getTransformation(currentTime, outTransformation));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25956989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_25956989;
        // ---------- Original Method ----------
        //mScaleFactor = scale;
        //return getTransformation(currentTime, outTransformation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.557 -0400", hash_original_method = "777CAD815D79C7ADA7276922FB123EB2", hash_generated_method = "47333EF2A0E196751C55D2174CE185AC")
    public boolean hasStarted() {
        boolean var7103AE9E2C0D3B676C4EDC763D39DFCF_920178164 = (mStarted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120221774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120221774;
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.557 -0400", hash_original_method = "D01D8338B537AF4FCC0E5AB769C5FB0B", hash_generated_method = "2B809D8A6EFDA722BE1B5B8FB2B70FA1")
    public boolean hasEnded() {
        boolean var9645CB566FAC236D8286C163216D1BCB_1502064035 = (mEnded);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598317930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_598317930;
        // ---------- Original Method ----------
        //return mEnded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.557 -0400", hash_original_method = "073EBA254DBED3B6D4C21030E1884802", hash_generated_method = "EA7FCB6EB179329E3F6B8D6B79676AEC")
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        addTaint(t.getTaint());
        addTaint(interpolatedTime);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.558 -0400", hash_original_method = "51B92BC0266A1C2F3581A8B430ACF6F7", hash_generated_method = "232C564B87F2043CEADF6DB446480753")
    protected float resolveSize(int type, float value, int size, int parentSize) {
        addTaint(parentSize);
        addTaint(size);
        addTaint(value);
        addTaint(type);
switch(type){
        case ABSOLUTE:
        float var2063C1608D6E0BAF80249C42E2BE5804_2017287885 = (value);
                float var546ADE640B6EDFBC8A086EF31347E768_872243843 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_872243843;
        case RELATIVE_TO_SELF:
        float var8B76DEA5B6F7FD8A6E0EBCEF3434C65B_2037851072 = (size * value);
                float var546ADE640B6EDFBC8A086EF31347E768_357685169 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_357685169;
        case RELATIVE_TO_PARENT:
        float varE0DDEAB69353EEB211A9AF46D666697C_1763909937 = (parentSize * value);
                float var546ADE640B6EDFBC8A086EF31347E768_1292889501 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1292889501;
        default:
        float var2063C1608D6E0BAF80249C42E2BE5804_1352988863 = (value);
                float var546ADE640B6EDFBC8A086EF31347E768_1243539134 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1243539134;
}
        // ---------- Original Method ----------
        //switch (type) {
            //case ABSOLUTE:
                //return value;
            //case RELATIVE_TO_SELF:
                //return size * value;
            //case RELATIVE_TO_PARENT:
                //return parentSize * value;
            //default:
                //return value;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.559 -0400", hash_original_method = "CF5E77120A30A36E6B295FA946811571", hash_generated_method = "7298B4134AF9D7C22EC5B952093B299A")
    public void getInvalidateRegion(int left, int top, int right, int bottom,
            RectF invalidate, Transformation transformation) {
        addTaint(transformation.getTaint());
        addTaint(invalidate.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        final RectF tempRegion = mRegion;
        final RectF previousRegion = mPreviousRegion;
        invalidate.set(left, top, right, bottom);
        transformation.getMatrix().mapRect(invalidate);
        invalidate.inset(-1.0f, -1.0f);
        tempRegion.set(invalidate);
        invalidate.union(previousRegion);
        previousRegion.set(tempRegion);
        final Transformation tempTransformation = mTransformation;
        final Transformation previousTransformation = mPreviousTransformation;
        tempTransformation.set(transformation);
        transformation.set(previousTransformation);
        previousTransformation.set(tempTransformation);
        // ---------- Original Method ----------
        //final RectF tempRegion = mRegion;
        //final RectF previousRegion = mPreviousRegion;
        //invalidate.set(left, top, right, bottom);
        //transformation.getMatrix().mapRect(invalidate);
        //invalidate.inset(-1.0f, -1.0f);
        //tempRegion.set(invalidate);
        //invalidate.union(previousRegion);
        //previousRegion.set(tempRegion);
        //final Transformation tempTransformation = mTransformation;
        //final Transformation previousTransformation = mPreviousTransformation;
        //tempTransformation.set(transformation);
        //transformation.set(previousTransformation);
        //previousTransformation.set(tempTransformation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.559 -0400", hash_original_method = "CE5BD1162FB4278724A9276A03F0A96A", hash_generated_method = "ED2C6D2087CE238AB85C759D8587D6EB")
    public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        final RectF region = mPreviousRegion;
        region.set(left, top, right, bottom);
        region.inset(-1.0f, -1.0f);
    if(mFillBefore)        
        {
            final Transformation previousTransformation = mPreviousTransformation;
            applyTransformation(mInterpolator.getInterpolation(0.0f), previousTransformation);
        } //End block
        // ---------- Original Method ----------
        //final RectF region = mPreviousRegion;
        //region.set(left, top, right, bottom);
        //region.inset(-1.0f, -1.0f);
        //if (mFillBefore) {
            //final Transformation previousTransformation = mPreviousTransformation;
            //applyTransformation(mInterpolator.getInterpolation(0.0f), previousTransformation);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.560 -0400", hash_original_method = "F91EB5DE0AE774B21AEF523039CEDA53", hash_generated_method = "4FC404922D16035511CDB345D355CC3C")
    protected void finalize() throws Throwable {
        try 
        {
    if(guard != null)            
            {
                guard.warnIfOpen();
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (guard != null) {
                //guard.warnIfOpen();
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.561 -0400", hash_original_method = "00F0E38B38876C14DBBEFF57F3DE3ED9", hash_generated_method = "AC9DDA694A82A364410DBB8A596E9922")
    public boolean hasAlpha() {
        boolean var68934A3E9455FA72420237EB05902327_320537372 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645545122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_645545122;
        // ---------- Original Method ----------
        //return false;
    }

    
    protected static class Description {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.561 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

        public int type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D18E7B5EA79EF395F5CA2EA5D5CA9DE3")

        public float value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_method = "670F11C8AD1CA46EBC3158EE54497D14", hash_generated_method = "670F11C8AD1CA46EBC3158EE54497D14")
        public Description ()
        {
            //Synthesized constructor
        }


                static Description parseValue(TypedValue value) {
            Description d = new Description();
            if (value == null) {
                d.type = ABSOLUTE;
                d.value = 0;
            } else {
                if (value.type == TypedValue.TYPE_FRACTION) {
                    d.type = (value.data & TypedValue.COMPLEX_UNIT_MASK) ==
                            TypedValue.COMPLEX_UNIT_FRACTION_PARENT ?
                                    RELATIVE_TO_PARENT : RELATIVE_TO_SELF;
                    d.value = TypedValue.complexToFloat(value.data);
                    return d;
                } else if (value.type == TypedValue.TYPE_FLOAT) {
                    d.type = ABSOLUTE;
                    d.value = value.getFloat();
                    return d;
                } else if (value.type >= TypedValue.TYPE_FIRST_INT &&
                        value.type <= TypedValue.TYPE_LAST_INT) {
                    d.type = ABSOLUTE;
                    d.value = value.data;
                    return d;
                }
            }
            d.type = ABSOLUTE;
            d.value = 0.0f;
            return d;
        }

        
    }


    
    public static interface AnimationListener {
        
        void onAnimationStart(Animation animation);

        
        void onAnimationEnd(Animation animation);

        
        void onAnimationRepeat(Animation animation);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "5E2F9BDAA8CE14DD954BF40FD55E2AF3", hash_generated_field = "285D35A4B336A34C53955AE44424AC64")

    public static final int INFINITE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "5F06E0F5187ED0CBFC4EF9E7B4D64EDE", hash_generated_field = "9FE7B7E5ED52768DD1C53DC895EC1A0D")

    public static final int RESTART = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "6BAA62FAC35E1F188A65C74FED662C34", hash_generated_field = "6790E6439C0E7615743240DF9A7C010E")

    public static final int REVERSE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "B7885BEA16E2C3D5A16948F21ED88A9B", hash_generated_field = "235BF0C9710820F28A2E28648164C2B7")

    public static final int START_ON_FIRST_FRAME = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "44E04D91FE2BFE1F31811DB66E9C836C", hash_generated_field = "4BC65DE722DF4CE40D49EFB427E9C12C")

    public static final int ABSOLUTE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "219D336140A6E021A396EE6EE22DE977", hash_generated_field = "2A99BA87ACDDCA9C9FB386FFFB6151EA")

    public static final int RELATIVE_TO_SELF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "B2090255989CB8D4FD1631A94AC1C505", hash_generated_field = "39CEF3E15FF6FF8064031A5B0E218AC6")

    public static final int RELATIVE_TO_PARENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "7FA539E5204221B4DD49472A7D30AF76", hash_generated_field = "350B866462D7A5796C6E66AE9D7BB305")

    public static final int ZORDER_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "FD7E0AA2F7D8EA9A2563E4EA47FB2ED2", hash_generated_field = "63A9791B289181049B87F13C581D3AF7")

    public static final int ZORDER_TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "AE8A81D06EA1A8383F625ACE662B6050", hash_generated_field = "6655EB233E0907175F6FC1DFBCF648DD")

    public static final int ZORDER_BOTTOM = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.562 -0400", hash_original_field = "7A767933C81D15E050EC63E36B098FFF", hash_generated_field = "5160DD832DA627994F79F0E39BF3B141")

    private static final boolean USE_CLOSEGUARD = SystemProperties.getBoolean("log.closeguard.Animation", false);
}

