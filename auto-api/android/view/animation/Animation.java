package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.TypedValue;
import dalvik.system.CloseGuard;

public abstract class Animation implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "385457F169B7B8F3F055692484147005", hash_generated_field = "2B949884EB9BE3C788B16B27F6DA2E53")

    boolean mEnded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "5D947BF952E8653BAADEA609028A78F9")

    boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "575296D4A6E3181FC1FFE583DB23FE3E", hash_generated_field = "F5A90569EED95B6137362B9C24B64AD6")

    boolean mCycleFlip = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "D7228C282593CDC77734D668B23541D3")

    boolean mInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "3B491B352FA7FEC4F42E4EA841B4CBA0", hash_generated_field = "138DAF4C12E534C03F3D363580B12729")

    boolean mFillBefore = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "92913E273E0279A4A85EB0A92416C3BF", hash_generated_field = "0713D9CEE65AF19CBD303F718622380C")

    boolean mFillAfter = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "7CB365868E8AE80F9F2E13E360299B47", hash_generated_field = "CD0E2560F62E160B1797BA608E99A525")

    boolean mFillEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "1336377597E871AC0DE1145EFBE093CD", hash_generated_field = "81105A88481A5B0AE717E10F26F868BC")

    long mStartTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "3DABB18D4F451E36446933F4C828ACE8", hash_generated_field = "EA2AC6F7F17E9F5AC720129EC7B5A165")

    long mStartOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "CFDA69B4AD03D72FC4B0627E39231164")

    long mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "7400544E99BDB4AB399DABF03F346DE6", hash_generated_field = "8CAB60CAF9F0EC867720B208BC5D4CD6")

    int mRepeatCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "791E2D6BDEEED2FC776C97D105DDD2D3", hash_generated_field = "0909517ECD26F075EDEABEF3C36497E6")

    int mRepeated = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "31336EA85735F5B517DD430F87691118", hash_generated_field = "496B647F2BFAD8D2A4745DD01043EBB9")

    int mRepeatMode = RESTART;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "A1326AE9004157E0812422F0F20CD6F9")

    Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "A82325198CD06548448A0D3238E6DB44")

    AnimationListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "E675CAC16E3A7934B1BE5FDBE7138A04", hash_generated_field = "388F873F7FDD1B97364C31A2829DAA2F")

    private int mZAdjustment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "F28F2DF30FA0A384EA442393DFFC03BB", hash_generated_field = "CC64588E1E08B8E0993874A8A69D251D")

    private int mBackgroundColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "925897ADD5A4443B43C8F6FBC4424E0E", hash_generated_field = "55C0C2A62CD0016DB863EA4C86F92AB3")

    private float mScaleFactor = 1f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "1B09FDB0A2E6AC18E9F1DBBB8735A0FE", hash_generated_field = "78F07B4146BD29D0652AD1623F0B1A21")

    private boolean mDetachWallpaper = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "9200F97640525BADE0F5210B0BECB3CA", hash_generated_field = "EB7123F1E56B8FC7DB4670361B61F3BB")

    private boolean mMore = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "68FEBF6A9F472E86EE32DBD86FFC61CF", hash_generated_field = "1A1B781F58C47FD588A3C25DEC073F2E")

    private boolean mOneMoreTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "FD5E22922C653BFDA6DEA53809D83FA6", hash_generated_field = "1281DD848D4CAC286B7C56B469674D23")

    RectF mPreviousRegion = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "5C3A8A09251061EEBB701527D514B5F2", hash_generated_field = "B8EF1E9F1F3FA3BF5EA38E9CC57EEE1D")

    RectF mRegion = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "04EC513F4EC68C8BA1280847D108F54D", hash_generated_field = "96FFB41D18FE51CA2378656E6B610C99")

    Transformation mTransformation = new Transformation();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "706404C2835CDB3C1939F923BB10605F", hash_generated_field = "82E7EE1C48131039EC27409DAF0D59C0")

    Transformation mPreviousTransformation = new Transformation();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.293 -0400", hash_original_method = "F5207BDCC3F51BB57C76C57DBA5A0AD4", hash_generated_method = "F05BFA516EF987BB837572F17670E4BF")
    public  Animation() {
        ensureInterpolator();
        // ---------- Original Method ----------
        //ensureInterpolator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.294 -0400", hash_original_method = "325850FA9042895E97F9004576A85DF0", hash_generated_method = "2EA5E9F0C9A5ADC5E88247CE3F34EE5B")
    public  Animation(Context context, AttributeSet attrs) {
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
        {
            setInterpolator(context, resID);
        } //End block
        ensureInterpolator();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.296 -0400", hash_original_method = "7BC58C079EA752AD7803A7DE0B66531B", hash_generated_method = "37E82FD88498EFB2430B67368524C4C2")
    @Override
    protected Animation clone() throws CloneNotSupportedException {
        Animation varB4EAC82CA7396A68D541C85D26508E83_1434874697 = null; //Variable for return #1
        final Animation animation = (Animation) super.clone();
        animation.mPreviousRegion = new RectF();
        animation.mRegion = new RectF();
        animation.mTransformation = new Transformation();
        animation.mPreviousTransformation = new Transformation();
        varB4EAC82CA7396A68D541C85D26508E83_1434874697 = animation;
        varB4EAC82CA7396A68D541C85D26508E83_1434874697.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1434874697;
        // ---------- Original Method ----------
        //final Animation animation = (Animation) super.clone();
        //animation.mPreviousRegion = new RectF();
        //animation.mRegion = new RectF();
        //animation.mTransformation = new Transformation();
        //animation.mPreviousTransformation = new Transformation();
        //return animation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.297 -0400", hash_original_method = "3AB995FAF173BC91AA72FEE328D0BE86", hash_generated_method = "8D4043FB51D478DAAF7B549EEBB6A8F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.297 -0400", hash_original_method = "E313CF9FDC4A243810ECD11633502833", hash_generated_method = "29EBB71A23A64A845C7799973E35B096")
    public void cancel() {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.297 -0400", hash_original_method = "BA118FB94C8A2A7F04D6CE25751A9CE0", hash_generated_method = "A4DDB9C862465695F447293D473853D9")
    public void detach() {
        {
            mEnded = true;
            guard.close();
            mListener.onAnimationEnd(this);
        } //End block
        // ---------- Original Method ----------
        //if (mStarted && !mEnded) {
            //mEnded = true;
            //guard.close();
            //if (mListener != null) mListener.onAnimationEnd(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.298 -0400", hash_original_method = "130A49FBCE1398CCC055AA736C1B7B6D", hash_generated_method = "BA960E3EFCDE2FBB1F87D08213947CD5")
    public boolean isInitialized() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685694877 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685694877;
        // ---------- Original Method ----------
        //return mInitialized;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.298 -0400", hash_original_method = "9B9AA705D4796FA141302715AF35F1C7", hash_generated_method = "0E1DD8F087025F1DAC5F770E507E57C8")
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        reset();
        mInitialized = true;
        addTaint(width);
        addTaint(height);
        addTaint(parentWidth);
        addTaint(parentHeight);
        // ---------- Original Method ----------
        //reset();
        //mInitialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.298 -0400", hash_original_method = "2C6481DDCCEAC913795356C9BF1AF628", hash_generated_method = "7E5A07BF3C19F4781C14EC826407278C")
    public void setInterpolator(Context context, int resID) {
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        addTaint(context.getTaint());
        addTaint(resID);
        // ---------- Original Method ----------
        //setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.299 -0400", hash_original_method = "4EEF3DF2F4BA4D9B865A07AD850625E7", hash_generated_method = "AA450A6BACD2D2A4B441CFF1CF324E18")
    public void setInterpolator(Interpolator i) {
        mInterpolator = i;
        // ---------- Original Method ----------
        //mInterpolator = i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.299 -0400", hash_original_method = "BF0ACB3E237AAE7044714380D4DED735", hash_generated_method = "424940C4F5E7DA004B724B16B7141A9B")
    public void setStartOffset(long startOffset) {
        mStartOffset = startOffset;
        // ---------- Original Method ----------
        //mStartOffset = startOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.299 -0400", hash_original_method = "C4FADDE7E113E13802025E54418B7E99", hash_generated_method = "81497F212C76A06DD129BF8A4487F18C")
    public void setDuration(long durationMillis) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Animation duration cannot be negative");
        } //End block
        mDuration = durationMillis;
        // ---------- Original Method ----------
        //if (durationMillis < 0) {
            //throw new IllegalArgumentException("Animation duration cannot be negative");
        //}
        //mDuration = durationMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.300 -0400", hash_original_method = "448C869CF9265A7FCC7AB9AE39BBC12A", hash_generated_method = "1F798CF76AB8AB87BB735D4383C5C2D8")
    public void restrictDuration(long durationMillis) {
        {
            mStartOffset = durationMillis;
            mDuration = 0;
            mRepeatCount = 0;
        } //End block
        long dur = mDuration + mStartOffset;
        {
            mDuration = durationMillis-mStartOffset;
            dur = durationMillis;
        } //End block
        {
            mDuration = 0;
            mRepeatCount = 0;
        } //End block
        {
            mRepeatCount = (int)(durationMillis/dur) - 1;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.301 -0400", hash_original_method = "7B723F7D723B2ADF0E8C91EC6AA68330", hash_generated_method = "C4880321253D48FFDAEDC63441B30760")
    public void scaleCurrentDuration(float scale) {
        mDuration = (long) (mDuration * scale);
        mStartOffset = (long) (mStartOffset * scale);
        // ---------- Original Method ----------
        //mDuration = (long) (mDuration * scale);
        //mStartOffset = (long) (mStartOffset * scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.301 -0400", hash_original_method = "C5F2E1E5B86432971DA671FBAF722042", hash_generated_method = "F61EFA6E5B483C91A8AD0B877BECA980")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.301 -0400", hash_original_method = "95CC5B32D25F554AB1041684F2D9EFB3", hash_generated_method = "C2C0CAF344BAFEE463FD4717BEBB205F")
    public void start() {
        setStartTime(-1);
        // ---------- Original Method ----------
        //setStartTime(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.301 -0400", hash_original_method = "66165BC7696DE4F74728FD45F7498148", hash_generated_method = "A6131EE72377D167A51760B30339E8DF")
    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
        // ---------- Original Method ----------
        //setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.302 -0400", hash_original_method = "DDD317A37915E8A65D2BE1E304EF578A", hash_generated_method = "17D1360A733DBD458CAB0359A395CE7B")
    public void setRepeatMode(int repeatMode) {
        mRepeatMode = repeatMode;
        // ---------- Original Method ----------
        //mRepeatMode = repeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.302 -0400", hash_original_method = "A134D6BEB9FF1047810E15F38A519E7E", hash_generated_method = "17728B39FDE776D685AAE4873225CC0B")
    public void setRepeatCount(int repeatCount) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.302 -0400", hash_original_method = "99447AF68D215B648170642F948B1397", hash_generated_method = "BFCAF2C4EA01E99B692D012450AC9511")
    public boolean isFillEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1297627172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1297627172;
        // ---------- Original Method ----------
        //return mFillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.303 -0400", hash_original_method = "FD550D09AAFA6DFC07B09135F2C7B62C", hash_generated_method = "039C156EB130A31B2B3D2DDB452A9F4E")
    public void setFillEnabled(boolean fillEnabled) {
        mFillEnabled = fillEnabled;
        // ---------- Original Method ----------
        //mFillEnabled = fillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.303 -0400", hash_original_method = "4449C3292A8570D114A58B4E08D55011", hash_generated_method = "E22ACD6422C750DD61089037D6A5467E")
    public void setFillBefore(boolean fillBefore) {
        mFillBefore = fillBefore;
        // ---------- Original Method ----------
        //mFillBefore = fillBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.303 -0400", hash_original_method = "4CCE59DDFB007D2C725E384A84210333", hash_generated_method = "49F55925CC5A820D4B8135937231E53B")
    public void setFillAfter(boolean fillAfter) {
        mFillAfter = fillAfter;
        // ---------- Original Method ----------
        //mFillAfter = fillAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.303 -0400", hash_original_method = "B53AFA13C43018FC57757729E8C6F5B9", hash_generated_method = "468123765E68AF71806CFB4882A6CCA9")
    public void setZAdjustment(int zAdjustment) {
        mZAdjustment = zAdjustment;
        // ---------- Original Method ----------
        //mZAdjustment = zAdjustment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.304 -0400", hash_original_method = "5CC3CCDE182714D1D24D814D03E78D72", hash_generated_method = "1D031963F8D9249329C42FBB1A944D82")
    public void setBackgroundColor(int bg) {
        mBackgroundColor = bg;
        // ---------- Original Method ----------
        //mBackgroundColor = bg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.304 -0400", hash_original_method = "209B3580CB795CD8B9886E8B498D1959", hash_generated_method = "190E58B5464A9C58B72343E721CD53F1")
    protected float getScaleFactor() {
        float var546ADE640B6EDFBC8A086EF31347E768_2075526055 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2075526055;
        // ---------- Original Method ----------
        //return mScaleFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.304 -0400", hash_original_method = "DC51879EADA1EC63F555D590C58841F2", hash_generated_method = "FA1E152176E4962E1A592137B68096BA")
    public void setDetachWallpaper(boolean detachWallpaper) {
        mDetachWallpaper = detachWallpaper;
        // ---------- Original Method ----------
        //mDetachWallpaper = detachWallpaper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.305 -0400", hash_original_method = "8AA04851FFB5BE49EA5890940035B142", hash_generated_method = "F7AE33B30206993FD37B6F8DD354353C")
    public Interpolator getInterpolator() {
        Interpolator varB4EAC82CA7396A68D541C85D26508E83_1286550586 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1286550586 = mInterpolator;
        varB4EAC82CA7396A68D541C85D26508E83_1286550586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1286550586;
        // ---------- Original Method ----------
        //return mInterpolator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.306 -0400", hash_original_method = "62DE33F2E1C7C51F234B4CE29FC5DCED", hash_generated_method = "6409E89C90A5D30EB22B801ADA278904")
    public long getStartTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_798894967 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_798894967;
        // ---------- Original Method ----------
        //return mStartTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.306 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "73986ECC4AC8F68AF6ACD6F4F45EBDFE")
    public long getDuration() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_289924778 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_289924778;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.306 -0400", hash_original_method = "F15F7E68559FE94D65E8E77E2E4D8AE9", hash_generated_method = "2FE821297F2CC82EB444080C8A1BCECD")
    public long getStartOffset() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1399820928 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1399820928;
        // ---------- Original Method ----------
        //return mStartOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.307 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "B1E056EB8D73F930C1B5E1C12A8553B1")
    public int getRepeatMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924299137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924299137;
        // ---------- Original Method ----------
        //return mRepeatMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.307 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "063CE2146BC8AD082894F295EBE5B733")
    public int getRepeatCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428143230 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428143230;
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.308 -0400", hash_original_method = "EC25BC6D19EE141C12788801543B6178", hash_generated_method = "E243BAA40B6ABD6706AB976FC0EAC9AA")
    public boolean getFillBefore() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064606391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064606391;
        // ---------- Original Method ----------
        //return mFillBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.309 -0400", hash_original_method = "6D667DA3C62337EC4E4606350728AE89", hash_generated_method = "2E5E73D49E11554ADC93957912CF69D0")
    public boolean getFillAfter() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2093785870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2093785870;
        // ---------- Original Method ----------
        //return mFillAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.309 -0400", hash_original_method = "409F6F7832CADDC17E7E5231CAA22AC6", hash_generated_method = "7AA73543ABE0E1F6F3E90CBEB1BB15E3")
    public int getZAdjustment() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216918620 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216918620;
        // ---------- Original Method ----------
        //return mZAdjustment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.310 -0400", hash_original_method = "FAF00526A7BA7C979C907792653A05BB", hash_generated_method = "7C262231D3778801010D78AE20486BC0")
    public int getBackgroundColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933622127 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933622127;
        // ---------- Original Method ----------
        //return mBackgroundColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.310 -0400", hash_original_method = "E6A00B836A83DBDC739846B44941121A", hash_generated_method = "7070FDCCC094A2DED04D09A0C852B79A")
    public boolean getDetachWallpaper() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_414096179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_414096179;
        // ---------- Original Method ----------
        //return mDetachWallpaper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.310 -0400", hash_original_method = "06611FABC5DAE0D86003F0AC94713BBE", hash_generated_method = "3A85713774EC29B39EBF4964206D8AB5")
    public boolean willChangeTransformationMatrix() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286995666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_286995666;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.310 -0400", hash_original_method = "75ECA58382FCAFBFF99662736FC361D6", hash_generated_method = "4DE0B054FC0F70F124CFB5771E121264")
    public boolean willChangeBounds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253726378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_253726378;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.311 -0400", hash_original_method = "93175FBEC8620A1D25367C53936C85B5", hash_generated_method = "B6B2E431FB5A3DE909C2B13E925B35BF")
    public void setAnimationListener(AnimationListener listener) {
        mListener = listener;
        // ---------- Original Method ----------
        //mListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.311 -0400", hash_original_method = "B0865E74040125EA32BE48261064C937", hash_generated_method = "4EBFE9C6B0075792054082D9C6D06DB7")
    protected void ensureInterpolator() {
        {
            mInterpolator = new AccelerateDecelerateInterpolator();
        } //End block
        // ---------- Original Method ----------
        //if (mInterpolator == null) {
            //mInterpolator = new AccelerateDecelerateInterpolator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.311 -0400", hash_original_method = "B3F1AB6DDEFF92B122293B4363A1C456", hash_generated_method = "F42B5642E382AC59C623681D420A552C")
    public long computeDurationHint() {
        long varABD0FCA997F16598E25E81E01A20B151_59052014 = ((getStartOffset() + getDuration()) * (getRepeatCount() + 1));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_285552487 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_285552487;
        // ---------- Original Method ----------
        //return (getStartOffset() + getDuration()) * (getRepeatCount() + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.312 -0400", hash_original_method = "1D66EEFFAD10DF7675973FFD0CA72C11", hash_generated_method = "D1BA1697EA3D4BA2BD0350DBDD884481")
    public boolean getTransformation(long currentTime, Transformation outTransformation) {
        {
            mStartTime = currentTime;
        } //End block
        final long startOffset = getStartOffset();
        final long duration = mDuration;
        float normalizedTime;
        {
            normalizedTime = ((float) (currentTime - (mStartTime + startOffset))) /
                    (float) duration;
        } //End block
        {
            normalizedTime = currentTime < mStartTime ? 0.0f : 1.0f;
        } //End block
        final boolean expired = normalizedTime >= 1.0f;
        mMore = !expired;
        normalizedTime = Math.max(Math.min(normalizedTime, 1.0f), 0.0f);
        {
            {
                {
                    mListener.onAnimationStart(this);
                } //End block
                mStarted = true;
                {
                    guard.open("cancel or detach or getTransformation");
                } //End block
            } //End block
            normalizedTime = Math.max(Math.min(normalizedTime, 1.0f), 0.0f);
            {
                normalizedTime = 1.0f - normalizedTime;
            } //End block
            final float interpolatedTime = mInterpolator.getInterpolation(normalizedTime);
            applyTransformation(interpolatedTime, outTransformation);
        } //End block
        {
            {
                {
                    mEnded = true;
                    guard.close();
                    {
                        mListener.onAnimationEnd(this);
                    } //End block
                } //End block
            } //End block
            {
                {
                    mCycleFlip = !mCycleFlip;
                } //End block
                mStartTime = -1;
                mMore = true;
                {
                    mListener.onAnimationRepeat(this);
                } //End block
            } //End block
        } //End block
        {
            mOneMoreTime = false;
        } //End block
        addTaint(outTransformation.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622984857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622984857;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.313 -0400", hash_original_method = "2D55A6E78A3D329DDFA1835011833D50", hash_generated_method = "83B612CD2C461756337C939F648301BB")
    public boolean getTransformation(long currentTime, Transformation outTransformation,
            float scale) {
        mScaleFactor = scale;
        boolean var0C8BADD9759052F94EFF38E8FDC1128E_1145549776 = (getTransformation(currentTime, outTransformation));
        addTaint(currentTime);
        addTaint(outTransformation.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046397989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046397989;
        // ---------- Original Method ----------
        //mScaleFactor = scale;
        //return getTransformation(currentTime, outTransformation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.313 -0400", hash_original_method = "777CAD815D79C7ADA7276922FB123EB2", hash_generated_method = "BC4752E5D8CB8AE49DAA8DE4AA13F736")
    public boolean hasStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193180434 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193180434;
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.313 -0400", hash_original_method = "D01D8338B537AF4FCC0E5AB769C5FB0B", hash_generated_method = "1BFEBBD77CFD89C813368E8EC0569ED5")
    public boolean hasEnded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138046036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138046036;
        // ---------- Original Method ----------
        //return mEnded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.314 -0400", hash_original_method = "073EBA254DBED3B6D4C21030E1884802", hash_generated_method = "B7B2109EE959D94E663269015881B45D")
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        addTaint(interpolatedTime);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.314 -0400", hash_original_method = "51B92BC0266A1C2F3581A8B430ACF6F7", hash_generated_method = "9EBC984FB55E64E3EA196917AD9733A6")
    protected float resolveSize(int type, float value, int size, int parentSize) {
        addTaint(type);
        addTaint(value);
        addTaint(size);
        addTaint(parentSize);
        float var546ADE640B6EDFBC8A086EF31347E768_404310443 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_404310443;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.314 -0400", hash_original_method = "CF5E77120A30A36E6B295FA946811571", hash_generated_method = "B613564BDD618B3001F78F2C29E17419")
    public void getInvalidateRegion(int left, int top, int right, int bottom,
            RectF invalidate, Transformation transformation) {
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
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(invalidate.getTaint());
        addTaint(transformation.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.315 -0400", hash_original_method = "CE5BD1162FB4278724A9276A03F0A96A", hash_generated_method = "A519A1DE388F44E72D3111DA3DD747E8")
    public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
        final RectF region = mPreviousRegion;
        region.set(left, top, right, bottom);
        region.inset(-1.0f, -1.0f);
        {
            final Transformation previousTransformation = mPreviousTransformation;
            applyTransformation(mInterpolator.getInterpolation(0.0f), previousTransformation);
        } //End block
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        //final RectF region = mPreviousRegion;
        //region.set(left, top, right, bottom);
        //region.inset(-1.0f, -1.0f);
        //if (mFillBefore) {
            //final Transformation previousTransformation = mPreviousTransformation;
            //applyTransformation(mInterpolator.getInterpolation(0.0f), previousTransformation);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.315 -0400", hash_original_method = "F91EB5DE0AE774B21AEF523039CEDA53", hash_generated_method = "FF262FB1B8FCA7802500418216B369E9")
    protected void finalize() throws Throwable {
        try 
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.316 -0400", hash_original_method = "00F0E38B38876C14DBBEFF57F3DE3ED9", hash_generated_method = "4E64C84B55552483A3702B6A0A71912E")
    public boolean hasAlpha() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255308606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255308606;
        // ---------- Original Method ----------
        //return false;
    }

    
    protected static class Description {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.316 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

        public int type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.316 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D18E7B5EA79EF395F5CA2EA5D5CA9DE3")

        public float value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.316 -0400", hash_original_method = "670F11C8AD1CA46EBC3158EE54497D14", hash_generated_method = "670F11C8AD1CA46EBC3158EE54497D14")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "5E2F9BDAA8CE14DD954BF40FD55E2AF3", hash_generated_field = "285D35A4B336A34C53955AE44424AC64")

    public static final int INFINITE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "5F06E0F5187ED0CBFC4EF9E7B4D64EDE", hash_generated_field = "9FE7B7E5ED52768DD1C53DC895EC1A0D")

    public static final int RESTART = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "6BAA62FAC35E1F188A65C74FED662C34", hash_generated_field = "6790E6439C0E7615743240DF9A7C010E")

    public static final int REVERSE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "B7885BEA16E2C3D5A16948F21ED88A9B", hash_generated_field = "235BF0C9710820F28A2E28648164C2B7")

    public static final int START_ON_FIRST_FRAME = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "44E04D91FE2BFE1F31811DB66E9C836C", hash_generated_field = "4BC65DE722DF4CE40D49EFB427E9C12C")

    public static final int ABSOLUTE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "219D336140A6E021A396EE6EE22DE977", hash_generated_field = "2A99BA87ACDDCA9C9FB386FFFB6151EA")

    public static final int RELATIVE_TO_SELF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "B2090255989CB8D4FD1631A94AC1C505", hash_generated_field = "39CEF3E15FF6FF8064031A5B0E218AC6")

    public static final int RELATIVE_TO_PARENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "7FA539E5204221B4DD49472A7D30AF76", hash_generated_field = "350B866462D7A5796C6E66AE9D7BB305")

    public static final int ZORDER_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "FD7E0AA2F7D8EA9A2563E4EA47FB2ED2", hash_generated_field = "63A9791B289181049B87F13C581D3AF7")

    public static final int ZORDER_TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "AE8A81D06EA1A8383F625ACE662B6050", hash_generated_field = "6655EB233E0907175F6FC1DFBCF648DD")

    public static final int ZORDER_BOTTOM = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.317 -0400", hash_original_field = "7A767933C81D15E050EC63E36B098FFF", hash_generated_field = "5160DD832DA627994F79F0E39BF3B141")

    private static final boolean USE_CLOSEGUARD = SystemProperties.getBoolean("log.closeguard.Animation", false);
}

