package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.ColorFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Log;
import android.os.SystemClock;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import com.android.internal.R;

public class AnimatedRotateDrawable extends Drawable implements Drawable.Callback, Runnable, Animatable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.487 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "FE6E5F6D52B9C115F35C89BDFFFA8B21")

    private AnimatedRotateState mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.488 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.488 -0400", hash_original_field = "A400194F6090059653517E4AAABDEC7F", hash_generated_field = "0FCE98F0DE619D64A68E05CE83D6979D")

    private float mCurrentDegrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.488 -0400", hash_original_field = "B954C9EDAC21852B96AD8DA47FB0BB4A", hash_generated_field = "94CC63D1D9940286EFAAE48CDCD55743")

    private float mIncrement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.488 -0400", hash_original_field = "EDF4C7A103D013E4C010EA6C8903F47F", hash_generated_field = "E765B9874E0B1A54BCA423FC936F9647")

    private boolean mRunning;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.489 -0400", hash_original_method = "69ED55E7C9BDFB1CF0205590E3E993B2", hash_generated_method = "5F987BF114CD8F7A8EE74075FD2E9C32")
    public  AnimatedRotateDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.489 -0400", hash_original_method = "AB41A646EB91FDEF71B00BCF9A828D48", hash_generated_method = "A63703D8323CBA74C528AB39CAA25753")
    private  AnimatedRotateDrawable(AnimatedRotateState rotateState, Resources res) {
        mState = new AnimatedRotateState(rotateState, this, res);
        init();
        // ---------- Original Method ----------
        //mState = new AnimatedRotateState(rotateState, this, res);
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.490 -0400", hash_original_method = "10C2A2E1B80AA77427356DB5B80319DC", hash_generated_method = "F27ED2B4B87CAB4102083D4DF8A03422")
    private void init() {
        final AnimatedRotateState state = mState;
        mIncrement = 360.0f / state.mFramesCount;
        final Drawable drawable = state.mDrawable;
    if(drawable != null)        
        {
            drawable.setFilterBitmap(true);
    if(drawable instanceof BitmapDrawable)            
            {
                ((BitmapDrawable) drawable).setAntiAlias(true);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final AnimatedRotateState state = mState;
        //mIncrement = 360.0f / state.mFramesCount;
        //final Drawable drawable = state.mDrawable;
        //if (drawable != null) {
            //drawable.setFilterBitmap(true);
            //if (drawable instanceof BitmapDrawable) {
                //((BitmapDrawable) drawable).setAntiAlias(true);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.490 -0400", hash_original_method = "5DFCBA38220408C5DABBFEFD0FA87F8B", hash_generated_method = "CFC639B98F7269EDC9F72FA1455B88EC")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        int saveCount = canvas.save();
        final AnimatedRotateState st = mState;
        final Drawable drawable = st.mDrawable;
        final Rect bounds = drawable.getBounds();
        int w = bounds.right - bounds.left;
        int h = bounds.bottom - bounds.top;
        float px = st.mPivotXRel ? (w * st.mPivotX) : st.mPivotX;
        float py = st.mPivotYRel ? (h * st.mPivotY) : st.mPivotY;
        canvas.rotate(mCurrentDegrees, px + bounds.left, py + bounds.top);
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
        // ---------- Original Method ----------
        //int saveCount = canvas.save();
        //final AnimatedRotateState st = mState;
        //final Drawable drawable = st.mDrawable;
        //final Rect bounds = drawable.getBounds();
        //int w = bounds.right - bounds.left;
        //int h = bounds.bottom - bounds.top;
        //float px = st.mPivotXRel ? (w * st.mPivotX) : st.mPivotX;
        //float py = st.mPivotYRel ? (h * st.mPivotY) : st.mPivotY;
        //canvas.rotate(mCurrentDegrees, px + bounds.left, py + bounds.top);
        //drawable.draw(canvas);
        //canvas.restoreToCount(saveCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.491 -0400", hash_original_method = "1FA1E7775B3C135CAFD58A0739A38376", hash_generated_method = "F53E253610DF9C8B99EA3FA20AA220CB")
    public void start() {
    if(!mRunning)        
        {
            mRunning = true;
            nextFrame();
        } //End block
        // ---------- Original Method ----------
        //if (!mRunning) {
            //mRunning = true;
            //nextFrame();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.491 -0400", hash_original_method = "9B01F7CABB2406558D1BC0A57268160A", hash_generated_method = "DE4674A61A26FAFB8EEC5D6045E39EA4")
    public void stop() {
        mRunning = false;
        unscheduleSelf(this);
        // ---------- Original Method ----------
        //mRunning = false;
        //unscheduleSelf(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.492 -0400", hash_original_method = "57CB6888179AFBC1686AC8B460D38FA6", hash_generated_method = "F8C3FB414434B0F703F0AB1887F53A20")
    public boolean isRunning() {
        boolean varEDF4C7A103D013E4C010EA6C8903F47F_152215261 = (mRunning);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1285931739 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1285931739;
        // ---------- Original Method ----------
        //return mRunning;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.492 -0400", hash_original_method = "7EB3E4BAE2A62EDC6364E7CD5F30E825", hash_generated_method = "186E401AF8BB6D7DC716D6E328839E6A")
    private void nextFrame() {
        unscheduleSelf(this);
        scheduleSelf(this, SystemClock.uptimeMillis() + mState.mFrameDuration);
        // ---------- Original Method ----------
        //unscheduleSelf(this);
        //scheduleSelf(this, SystemClock.uptimeMillis() + mState.mFrameDuration);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.492 -0400", hash_original_method = "47627FAA36D08729C94EAD6CAAA95F6C", hash_generated_method = "B72324DC5BF99CE998CCD4E6FD3A5032")
    public void run() {
        mCurrentDegrees += mIncrement;
    if(mCurrentDegrees > (360.0f - mIncrement))        
        {
            mCurrentDegrees = 0.0f;
        } //End block
        invalidateSelf();
        nextFrame();
        // ---------- Original Method ----------
        //mCurrentDegrees += mIncrement;
        //if (mCurrentDegrees > (360.0f - mIncrement)) {
            //mCurrentDegrees = 0.0f;
        //}
        //invalidateSelf();
        //nextFrame();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.493 -0400", hash_original_method = "183F775A408D23F991FB2833203EEE63", hash_generated_method = "C146112A823EB48F795EAADAD730CC81")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        addTaint(visible);
        mState.mDrawable.setVisible(visible, restart);
        boolean changed = super.setVisible(visible, restart);
    if(visible)        
        {
    if(changed || restart)            
            {
                mCurrentDegrees = 0.0f;
                nextFrame();
            } //End block
        } //End block
        else
        {
            unscheduleSelf(this);
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1161818725 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842976214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842976214;
        // ---------- Original Method ----------
        //mState.mDrawable.setVisible(visible, restart);
        //boolean changed = super.setVisible(visible, restart);
        //if (visible) {
            //if (changed || restart) {
                //mCurrentDegrees = 0.0f;
                //nextFrame();
            //}
        //} else {
            //unscheduleSelf(this);
        //}
        //return changed;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.493 -0400", hash_original_method = "CE08CCF44A5C011BE03C2CE7D256555D", hash_generated_method = "A4EEC2109DDA0A9251ECA736814A28EF")
    public Drawable getDrawable() {
Drawable varF9B456849C7B5DD9BFF89D3152C1C062_1806429315 =         mState.mDrawable;
        varF9B456849C7B5DD9BFF89D3152C1C062_1806429315.addTaint(taint);
        return varF9B456849C7B5DD9BFF89D3152C1C062_1806429315;
        // ---------- Original Method ----------
        //return mState.mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.494 -0400", hash_original_method = "1BF1269A7F11A078222AE5900C6EC170", hash_generated_method = "36359C36D7D460C32715B2D5F1A4AAA9")
    @Override
    public int getChangingConfigurations() {
        int varCA8871A6EDE3F4B0D8A4B17E69E2053A_624881209 = (super.getChangingConfigurations()
                | mState.mChangingConfigurations
                | mState.mDrawable.getChangingConfigurations());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_792625050 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_792625050;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mState.mChangingConfigurations
                //| mState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.494 -0400", hash_original_method = "E07BF10440452C45B5D504184A6B58C8", hash_generated_method = "68F834CF4165EF4981B94A9CBE9C5228")
    @Override
    public void setAlpha(int alpha) {
        addTaint(alpha);
        mState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.495 -0400", hash_original_method = "6C570D1758B788EA390E83E99A76EB36", hash_generated_method = "365B8162BDD6CCD1CC66E3D3F2067B09")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        mState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.495 -0400", hash_original_method = "7CC935EC38A8A9ED900F61C0DE237712", hash_generated_method = "C223B770C3FAD217C42751CADE9DB9C0")
    @Override
    public int getOpacity() {
        int var161C5DA78E90AA18FD3124A4BA1D9E8F_101118504 = (mState.mDrawable.getOpacity());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585794485 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585794485;
        // ---------- Original Method ----------
        //return mState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.495 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CEDEB5E33EFE6B1A6A0CCC10DBF093")
    public void invalidateDrawable(Drawable who) {
        addTaint(who.getTaint());
        final Callback callback = getCallback();
    if(callback != null)        
        {
            callback.invalidateDrawable(this);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.496 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "7093C805993ACF54047727682755EE99")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        addTaint(when);
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        final Callback callback = getCallback();
    if(callback != null)        
        {
            callback.scheduleDrawable(this, what, when);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.497 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "FFEE17E462526EA539C05FAA6C36C1E2")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        final Callback callback = getCallback();
    if(callback != null)        
        {
            callback.unscheduleDrawable(this, what);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.497 -0400", hash_original_method = "02BC41BDC3ED3CF2C30379FA10185DFA", hash_generated_method = "0B02B39F97557A9CFEB4B5D61763EFC0")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        boolean varF707B1D7F228AD4D878139788C1C8F59_1398800016 = (mState.mDrawable.getPadding(padding));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_393282613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_393282613;
        // ---------- Original Method ----------
        //return mState.mDrawable.getPadding(padding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.498 -0400", hash_original_method = "6F66CB18BCF39D7C34F81BD35385E69D", hash_generated_method = "A721CBC506F5D9F967CE8F49007DA852")
    @Override
    public boolean isStateful() {
        boolean varE0911C7B30E7CAD8B191C4C55DB434C2_745556308 = (mState.mDrawable.isStateful());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1486116994 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1486116994;
        // ---------- Original Method ----------
        //return mState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.498 -0400", hash_original_method = "EF65F96F81169D8EC042745FACAE10FF", hash_generated_method = "61A746B15B90FF8190213271494AC871")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        mState.mDrawable.setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //mState.mDrawable.setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.499 -0400", hash_original_method = "5B4218C80F47B6E11FBBAA9FF9621C9F", hash_generated_method = "0A51C58249FC508FB32573FA47961515")
    @Override
    public int getIntrinsicWidth() {
        int var7ADDEA45D249CEE98356EBBA52B14675_1193318490 = (mState.mDrawable.getIntrinsicWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633076319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633076319;
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.499 -0400", hash_original_method = "D5692643A14F3CC0D08138E7C727B99D", hash_generated_method = "8ED1ABC0BBE082E33993436DD1A6CC10")
    @Override
    public int getIntrinsicHeight() {
        int varE3F3C2B9CA67A8CAF781F2B0B6453BD5_1046435822 = (mState.mDrawable.getIntrinsicHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980445342 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980445342;
        // ---------- Original Method ----------
        //return mState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.499 -0400", hash_original_method = "810CA52F78245136A3D7374C4FDCA32A", hash_generated_method = "3B7762D9935CFD9B3F5563942CB2162B")
    @Override
    public ConstantState getConstantState() {
    if(mState.canConstantState())        
        {
            mState.mChangingConfigurations = getChangingConfigurations();
ConstantState var8B975C85F13BECB9FD4D21A5F3C8A56D_384543928 =             mState;
            var8B975C85F13BECB9FD4D21A5F3C8A56D_384543928.addTaint(taint);
            return var8B975C85F13BECB9FD4D21A5F3C8A56D_384543928;
        } //End block
ConstantState var540C13E9E156B687226421B24F2DF178_1566120816 =         null;
        var540C13E9E156B687226421B24F2DF178_1566120816.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1566120816;
        // ---------- Original Method ----------
        //if (mState.canConstantState()) {
            //mState.mChangingConfigurations = getChangingConfigurations();
            //return mState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.501 -0400", hash_original_method = "A622CEEF500B9000EB94812A972E6C45", hash_generated_method = "A5B443DA327678016AF5811AE96EC94A")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        final TypedArray a = r.obtainAttributes(attrs, R.styleable.AnimatedRotateDrawable);
        super.inflateWithAttributes(r, parser, a, R.styleable.AnimatedRotateDrawable_visible);
        TypedValue tv = a.peekValue(R.styleable.AnimatedRotateDrawable_pivotX);
        final boolean pivotXRel = tv.type == TypedValue.TYPE_FRACTION;
        final float pivotX = pivotXRel ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();
        tv = a.peekValue(R.styleable.AnimatedRotateDrawable_pivotY);
        final boolean pivotYRel = tv.type == TypedValue.TYPE_FRACTION;
        final float pivotY = pivotYRel ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();
        setFramesCount(a.getInt(R.styleable.AnimatedRotateDrawable_framesCount, 12));
        setFramesDuration(a.getInt(R.styleable.AnimatedRotateDrawable_frameDuration, 150));
        final int res = a.getResourceId(R.styleable.AnimatedRotateDrawable_drawable, 0);
        Drawable drawable = null;
    if(res > 0)        
        {
            drawable = r.getDrawable(res);
        } //End block
        a.recycle();
        int outerDepth = parser.getDepth();
        int type;
        while
((type = parser.next()) != XmlPullParser.END_DOCUMENT &&
               (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth))        
        {
    if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } //End block
    if((drawable = Drawable.createFromXmlInner(r, parser, attrs)) == null)            
            {
            } //End block
        } //End block
    if(drawable == null)        
        {
        } //End block
        final AnimatedRotateState rotateState = mState;
        rotateState.mDrawable = drawable;
        rotateState.mPivotXRel = pivotXRel;
        rotateState.mPivotX = pivotX;
        rotateState.mPivotYRel = pivotYRel;
        rotateState.mPivotY = pivotY;
        init();
    if(drawable != null)        
        {
            drawable.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.502 -0400", hash_original_method = "B458BF95D94A39224F760F42AF094AE9", hash_generated_method = "C62AE0432E269CE7FBBF9D025C9EDB42")
    public void setFramesCount(int framesCount) {
        mState.mFramesCount = framesCount;
        mIncrement = 360.0f / mState.mFramesCount;
        // ---------- Original Method ----------
        //mState.mFramesCount = framesCount;
        //mIncrement = 360.0f / mState.mFramesCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.502 -0400", hash_original_method = "CDF8A4A058FBB62E5E21EBF9FD2DD694", hash_generated_method = "A03827D13AD31602F15D5BCB5CBA16BF")
    public void setFramesDuration(int framesDuration) {
        mState.mFrameDuration = framesDuration;
        // ---------- Original Method ----------
        //mState.mFrameDuration = framesDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.503 -0400", hash_original_method = "1ABB3B56372A1EBF2E80045724D492E3", hash_generated_method = "4C1E29DA857B46E0C7491C07119A244C")
    @Override
    public Drawable mutate() {
    if(!mMutated && super.mutate() == this)        
        {
            mState.mDrawable.mutate();
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_429107094 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_429107094.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_429107094;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class AnimatedRotateState extends Drawable.ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.503 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.503 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.504 -0400", hash_original_field = "7F7BDD395B2683F1C3CE6FF4D28782A1", hash_generated_field = "C85378C704A40C3EFC15605BD9C2CCB0")

        boolean mPivotXRel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.504 -0400", hash_original_field = "D66A9F2EFD98D68E75A6EA9E5E5D83DE", hash_generated_field = "5936761CCB9106C6D82A6436A57EC343")

        float mPivotX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.504 -0400", hash_original_field = "71E602433C1B915117E3827218A7F552", hash_generated_field = "4EE5D55A1588E348C8DE32B74EC377A0")

        boolean mPivotYRel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.504 -0400", hash_original_field = "0AD24014D3E582A643E83C27A45B1B51", hash_generated_field = "6CE864DEEFD86BFE91AA6D818A7F55C0")

        float mPivotY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.504 -0400", hash_original_field = "ACF20957D6502920CE28BD5E78CCEE92", hash_generated_field = "0644D880B120B0F98D7BCA0C2E0486B2")

        int mFrameDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.504 -0400", hash_original_field = "E1762CF88059E9A4F6ACDD6D1B47D33D", hash_generated_field = "5ECD6AC9A9CB96CB01ACA98AF1EE1385")

        int mFramesCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.504 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.504 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.506 -0400", hash_original_method = "1B1F90708B07C46F9FB4F0410B3AE108", hash_generated_method = "99EC3C5CF0BB130A2551D39D4BACAD65")
        public  AnimatedRotateState(AnimatedRotateState source, AnimatedRotateDrawable owner,
                Resources res) {
            addTaint(owner.getTaint());
    if(source != null)            
            {
    if(res != null)                
                {
                    mDrawable = source.mDrawable.getConstantState().newDrawable(res);
                } //End block
                else
                {
                    mDrawable = source.mDrawable.getConstantState().newDrawable();
                } //End block
                mDrawable.setCallback(owner);
                mPivotXRel = source.mPivotXRel;
                mPivotX = source.mPivotX;
                mPivotYRel = source.mPivotYRel;
                mPivotY = source.mPivotY;
                mFramesCount = source.mFramesCount;
                mFrameDuration = source.mFrameDuration;
                mCanConstantState = mCheckedConstantState = true;
            } //End block
            // ---------- Original Method ----------
            //if (source != null) {
                //if (res != null) {
                    //mDrawable = source.mDrawable.getConstantState().newDrawable(res);
                //} else {
                    //mDrawable = source.mDrawable.getConstantState().newDrawable();
                //}
                //mDrawable.setCallback(owner);
                //mPivotXRel = source.mPivotXRel;
                //mPivotX = source.mPivotX;
                //mPivotYRel = source.mPivotYRel;
                //mPivotY = source.mPivotY;
                //mFramesCount = source.mFramesCount;
                //mFrameDuration = source.mFrameDuration;
                //mCanConstantState = mCheckedConstantState = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.508 -0400", hash_original_method = "90513075AAF61DC02051F8AF573AA026", hash_generated_method = "5E36AFD4473296BCFDD96313F9068CA7")
        @Override
        public Drawable newDrawable() {
Drawable varE1D853D4D98CC10B802EE89D0C6FA623_1408088255 =             new AnimatedRotateDrawable(this, null);
            varE1D853D4D98CC10B802EE89D0C6FA623_1408088255.addTaint(taint);
            return varE1D853D4D98CC10B802EE89D0C6FA623_1408088255;
            // ---------- Original Method ----------
            //return new AnimatedRotateDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.509 -0400", hash_original_method = "8E62ECEB973FF3825859D252B23F201A", hash_generated_method = "2165E2CBDFC900CB861A7C1B56BF2B1B")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var1D65B721316462C507882262DDF59C8D_666503942 =             new AnimatedRotateDrawable(this, res);
            var1D65B721316462C507882262DDF59C8D_666503942.addTaint(taint);
            return var1D65B721316462C507882262DDF59C8D_666503942;
            // ---------- Original Method ----------
            //return new AnimatedRotateDrawable(this, res);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.510 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "6F7E308B8F34B1B50F72EC0ACB08F521")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_609679811 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62648006 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62648006;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.511 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "BBA6CFC9D373BF00EBD3A953F30B4B55")
        public boolean canConstantState() {
    if(!mCheckedConstantState)            
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var7C8FD9809F31C20B8422D623B0EC0C4F_370502646 = (mCanConstantState);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817416339 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_817416339;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
}

