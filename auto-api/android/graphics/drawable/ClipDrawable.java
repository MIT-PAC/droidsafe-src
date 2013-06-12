package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.view.Gravity;
import android.util.AttributeSet;
import android.view.View;
import java.io.IOException;

public class ClipDrawable extends Drawable implements Drawable.Callback {
    private ClipState mClipState;
    private final Rect mTmpRect = new Rect();
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.069 -0400", hash_original_method = "E02759DF2D4F91913B09748266B3DC55", hash_generated_method = "3EF0FC81B012C9126B51B5A38DFA83FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ClipDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.069 -0400", hash_original_method = "5201E74D3B1AF986B1DE2C301B497FD9", hash_generated_method = "466AF6D819F0D98EF741AD464BA0FD2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClipDrawable(Drawable drawable, int gravity, int orientation) {
        this(null, null);
        dsTaint.addTaint(orientation);
        dsTaint.addTaint(drawable.dsTaint);
        dsTaint.addTaint(gravity);
        mClipState.mDrawable = drawable;
        mClipState.mGravity = gravity;
        mClipState.mOrientation = orientation;
        {
            drawable.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        //mClipState.mDrawable = drawable;
        //mClipState.mGravity = gravity;
        //mClipState.mOrientation = orientation;
        //if (drawable != null) {
            //drawable.setCallback(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.070 -0400", hash_original_method = "F385B151B35BFC6DCEF1AAF1F3B81836", hash_generated_method = "A1029522F983EFEE37E6E8CFF131D32D")
    @DSModeled(DSC.SAFE)
    private ClipDrawable(ClipState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        mClipState = new ClipState(state, this, res);
        // ---------- Original Method ----------
        //mClipState = new ClipState(state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.070 -0400", hash_original_method = "35E10192FDDDDD39EA519306C2BA1E53", hash_generated_method = "5B722C91DFC3CD9FE93C2EE4ACE5DADD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        super.inflate(r, parser, attrs);
        int type;
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ClipDrawable);
        int orientation;
        orientation = a.getInt(
                com.android.internal.R.styleable.ClipDrawable_clipOrientation,
                HORIZONTAL);
        int g;
        g = a.getInt(com.android.internal.R.styleable.ClipDrawable_gravity, Gravity.LEFT);
        Drawable dr;
        dr = a.getDrawable(com.android.internal.R.styleable.ClipDrawable_drawable);
        a.recycle();
        final int outerDepth;
        outerDepth = parser.getDepth();
        {
            boolean var09B6D7ADFBD75C31FC39E543D494D2B2_202071878 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            } //End block
        } //End collapsed parenthetic
        {
            throw new IllegalArgumentException("No drawable specified for <clip>");
        } //End block
        mClipState.mDrawable = dr;
        mClipState.mOrientation = orientation;
        mClipState.mGravity = g;
        dr.setCallback(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.070 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "D7A125D884399668326B167A1A20D259")
    @DSModeled(DSC.SAFE)
    public void invalidateDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        final Callback callback;
        callback = getCallback();
        {
            callback.invalidateDrawable(this);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.070 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "4140553D1B4A660A5BFE5C63C152BF16")
    @DSModeled(DSC.SAFE)
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
        dsTaint.addTaint(who.dsTaint);
        final Callback callback;
        callback = getCallback();
        {
            callback.scheduleDrawable(this, what, when);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.070 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "EEC35E08D6CEB726288E36993E6C764A")
    @DSModeled(DSC.SAFE)
    public void unscheduleDrawable(Drawable who, Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        final Callback callback;
        callback = getCallback();
        {
            callback.unscheduleDrawable(this, what);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.071 -0400", hash_original_method = "67F829CCE512EF7E67F091FC7A5204DA", hash_generated_method = "7DE3D932D28D5DB66D3B0FA6C54A8A24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int varDFC98A828F1E5DD4ACFDD09BE75CDD44_979147474 = (super.getChangingConfigurations()
                | mClipState.mChangingConfigurations
                | mClipState.mDrawable.getChangingConfigurations());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mClipState.mChangingConfigurations
                //| mClipState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.071 -0400", hash_original_method = "EBC5879EAC2AD881F46A140E8365AA28", hash_generated_method = "B8945927C5417AE891476C540E3B1244")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        boolean varFA0EE5B84D41E6EA15329494EE34AF85_676004672 = (mClipState.mDrawable.getPadding(padding));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getPadding(padding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.071 -0400", hash_original_method = "BCB1CA235EA7FE91BD623275B8F06E4E", hash_generated_method = "B6B0BDD002643F7D848DAD955585AB19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
        mClipState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_754078670 = (super.setVisible(visible, restart));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mClipState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.071 -0400", hash_original_method = "8A8063C7E15313BD8D8740621EFCD055", hash_generated_method = "4CB012D5F461C5394ECC4B5BFD926DD3")
    @DSModeled(DSC.SAFE)
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        mClipState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.071 -0400", hash_original_method = "4805CD50FD09C28529E6873146205090", hash_generated_method = "3B6240FF9071FD2F6D80775540D57671")
    @DSModeled(DSC.SAFE)
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        mClipState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.071 -0400", hash_original_method = "D50D875832F26A4F5A2E593F0458B980", hash_generated_method = "25C28FDF435EDA40B4F71042241B6231")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        int var7EBA07C3058A7D8780045D81DE96085D_590513137 = (mClipState.mDrawable.getOpacity());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.072 -0400", hash_original_method = "A8A44DACBEBFA3295CF5300D7DD6141E", hash_generated_method = "72F7509626B1CD9B48AF154ED5386DB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isStateful() {
        boolean var82D4A15835FEB45AECBB70076CB3548B_1391672340 = (mClipState.mDrawable.isStateful());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.072 -0400", hash_original_method = "F2335EB963F31FC1C9D5098F086ABEDC", hash_generated_method = "ED67D3B2E68F9918580B7CAED680F194")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state);
        boolean var818D62B4D5CE213BE71279F3D8049039_1330778490 = (mClipState.mDrawable.setState(state));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.setState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.072 -0400", hash_original_method = "205025D2BBBB226C56B3B5E3828C12A2", hash_generated_method = "E840B8D9AEA8664B3AB5D0E362289E5E")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        mClipState.mDrawable.setLevel(level);
        invalidateSelf();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mClipState.mDrawable.setLevel(level);
        //invalidateSelf();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.072 -0400", hash_original_method = "3381996765F462751820E570B6825F64", hash_generated_method = "77ABBBB6127F4787A347FFD4688CC5C6")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        mClipState.mDrawable.setBounds(bounds);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setBounds(bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.072 -0400", hash_original_method = "0FB9453D484502FB8FF0BB7F530F2AA8", hash_generated_method = "53DD53B1FCE1528F3591945CF4F11FDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean varDC16A1B821C9D811C92DD71CA522B4C3_932332827 = (mClipState.mDrawable.getLevel() == 0);
        } //End collapsed parenthetic
        final Rect r;
        r = mTmpRect;
        final Rect bounds;
        bounds = getBounds();
        int level;
        level = getLevel();
        int w;
        w = bounds.width();
        final int iw;
        iw = 0;
        {
            w -= (w - iw) * (10000 - level) / 10000;
        } //End block
        int h;
        h = bounds.height();
        final int ih;
        ih = 0;
        {
            h -= (h - ih) * (10000 - level) / 10000;
        } //End block
        final int layoutDirection;
        layoutDirection = getResolvedLayoutDirectionSelf();
        Gravity.apply(mClipState.mGravity, w, h, bounds, r, layoutDirection);
        {
            canvas.save();
            canvas.clipRect(r);
            mClipState.mDrawable.draw(canvas);
            canvas.restore();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.073 -0400", hash_original_method = "042D8C5B60AD594AE3EBCE13D95C97E6", hash_generated_method = "4A00144B9AF4B5456BE7E7356675B059")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicWidth() {
        int var2B71D04AE1D94A4FC1FA398B882D5481_1863565367 = (mClipState.mDrawable.getIntrinsicWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.073 -0400", hash_original_method = "2200041BC151EB15073098E0A2FD1970", hash_generated_method = "1690C2E267490E8A54B369D957513084")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicHeight() {
        int varBF36CBCE367F887A243D5F42A43AE8CC_1928241888 = (mClipState.mDrawable.getIntrinsicHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.073 -0400", hash_original_method = "80C96E88400AA50FF8906D46C3CD5A6C", hash_generated_method = "FA5598EEA7F29B612FA3AE43AF3DF1C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        {
            boolean var4D1BD4C813EBF81C269213C640D8A496_474857896 = (mClipState.canConstantState());
            {
                mClipState.mChangingConfigurations = getChangingConfigurations();
            } //End block
        } //End collapsed parenthetic
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mClipState.canConstantState()) {
            //mClipState.mChangingConfigurations = getChangingConfigurations();
            //return mClipState;
        //}
        //return null;
    }

    
    final static class ClipState extends ConstantState {
        Drawable mDrawable;
        int mChangingConfigurations;
        int mOrientation;
        int mGravity;
        private boolean mCheckedConstantState;
        private boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.073 -0400", hash_original_method = "DA3973DF13E25909CBF5E61AD4C16433", hash_generated_method = "DD13D92634EC3E9F1B2B73BAC79AFB4F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ClipState(ClipState orig, ClipDrawable owner, Resources res) {
            dsTaint.addTaint(res.dsTaint);
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(orig.dsTaint);
            {
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                } //End block
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable();
                } //End block
                mDrawable.setCallback(owner);
                mOrientation = orig.mOrientation;
                mGravity = orig.mGravity;
                mCheckedConstantState = mCanConstantState = true;
            } //End block
            // ---------- Original Method ----------
            //if (orig != null) {
                //if (res != null) {
                    //mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                //} else {
                    //mDrawable = orig.mDrawable.getConstantState().newDrawable();
                //}
                //mDrawable.setCallback(owner);
                //mOrientation = orig.mOrientation;
                //mGravity = orig.mGravity;
                //mCheckedConstantState = mCanConstantState = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.073 -0400", hash_original_method = "9DFA0AF157AD09F9E42E54EF8A59DA7F", hash_generated_method = "C3736784B5437AA8F4617DF585964FFB")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable() {
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ClipDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.073 -0400", hash_original_method = "9FB9989AA654F677F07C2F4A3C4B1057", hash_generated_method = "6B698AD7642675012DE080574F3CB993")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ClipDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.074 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "2D59F41488F7278F18877F131EF0D371")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.074 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "09FA6CC8A4987398242D2989273392A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean canConstantState() {
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
}


