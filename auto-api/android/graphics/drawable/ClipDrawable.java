package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private Rect mTmpRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.979 -0400", hash_original_method = "E02759DF2D4F91913B09748266B3DC55", hash_generated_method = "2B186D8FB2296E2181BF9479B3E0E4E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ClipDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.980 -0400", hash_original_method = "5201E74D3B1AF986B1DE2C301B497FD9", hash_generated_method = "569B9689697CB49FF8CF86CF3D7979D3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.980 -0400", hash_original_method = "F385B151B35BFC6DCEF1AAF1F3B81836", hash_generated_method = "BF6DF3991C259FC5834FF19F5C54542D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ClipDrawable(ClipState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        mClipState = new ClipState(state, this, res);
        // ---------- Original Method ----------
        //mClipState = new ClipState(state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.981 -0400", hash_original_method = "35E10192FDDDDD39EA519306C2BA1E53", hash_generated_method = "8A113970623AECFE4593F129311AE493")
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
        int outerDepth;
        outerDepth = parser.getDepth();
        {
            boolean var09B6D7ADFBD75C31FC39E543D494D2B2_733948141 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No drawable specified for <clip>");
        } //End block
        mClipState.mDrawable = dr;
        mClipState.mOrientation = orientation;
        mClipState.mGravity = g;
        dr.setCallback(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.981 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CFE1796930DCF2EA1C09782362A302")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        Callback callback;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.981 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "5E91FE06A500769A5C043EEFE8B10766")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
        dsTaint.addTaint(who.dsTaint);
        Callback callback;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.983 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "E7D6D2791C5354C92F65E1B2A3B561B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unscheduleDrawable(Drawable who, Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        Callback callback;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.983 -0400", hash_original_method = "67F829CCE512EF7E67F091FC7A5204DA", hash_generated_method = "FB93BA4871A8A3AD7BC80683A74D5BE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int varDFC98A828F1E5DD4ACFDD09BE75CDD44_1488739983 = (super.getChangingConfigurations()
                | mClipState.mChangingConfigurations
                | mClipState.mDrawable.getChangingConfigurations());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mClipState.mChangingConfigurations
                //| mClipState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.984 -0400", hash_original_method = "EBC5879EAC2AD881F46A140E8365AA28", hash_generated_method = "20E9DBA4F8756314A4E947988196B6D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        boolean varFA0EE5B84D41E6EA15329494EE34AF85_478915607 = (mClipState.mDrawable.getPadding(padding));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getPadding(padding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.984 -0400", hash_original_method = "BCB1CA235EA7FE91BD623275B8F06E4E", hash_generated_method = "F84CD039818111D9D5A574B9DC4AF88A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
        mClipState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_1509694867 = (super.setVisible(visible, restart));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mClipState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.993 -0400", hash_original_method = "8A8063C7E15313BD8D8740621EFCD055", hash_generated_method = "0BEF4B5FA4481A69C27ED2B50B8FF073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        mClipState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.994 -0400", hash_original_method = "4805CD50FD09C28529E6873146205090", hash_generated_method = "8888211751099AC80162B92D4D9DC723")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        mClipState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.994 -0400", hash_original_method = "D50D875832F26A4F5A2E593F0458B980", hash_generated_method = "6E9B3A9B27055954A5B29B0E41E3293D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        int var7EBA07C3058A7D8780045D81DE96085D_2639527 = (mClipState.mDrawable.getOpacity());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.994 -0400", hash_original_method = "A8A44DACBEBFA3295CF5300D7DD6141E", hash_generated_method = "9E774882DC9DA35720B7F18A277D3344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isStateful() {
        boolean var82D4A15835FEB45AECBB70076CB3548B_1480681770 = (mClipState.mDrawable.isStateful());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.995 -0400", hash_original_method = "F2335EB963F31FC1C9D5098F086ABEDC", hash_generated_method = "58F1A990405D19807C14ACBD6578879E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state[0]);
        boolean var818D62B4D5CE213BE71279F3D8049039_620326806 = (mClipState.mDrawable.setState(state));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.setState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.995 -0400", hash_original_method = "205025D2BBBB226C56B3B5E3828C12A2", hash_generated_method = "C596E0D4AD0EAAD13BABA6C07A0B3E38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.995 -0400", hash_original_method = "3381996765F462751820E570B6825F64", hash_generated_method = "1E779D413275FE4FB84F15C51221F09A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        mClipState.mDrawable.setBounds(bounds);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setBounds(bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.996 -0400", hash_original_method = "0FB9453D484502FB8FF0BB7F530F2AA8", hash_generated_method = "88952187D6B6C5A375A35D2FE005B0C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean varDC16A1B821C9D811C92DD71CA522B4C3_1212257458 = (mClipState.mDrawable.getLevel() == 0);
        } //End collapsed parenthetic
        Rect r;
        r = mTmpRect;
        Rect bounds;
        bounds = getBounds();
        int level;
        level = getLevel();
        int w;
        w = bounds.width();
        int iw;
        iw = 0;
        {
            w -= (w - iw) * (10000 - level) / 10000;
        } //End block
        int h;
        h = bounds.height();
        int ih;
        ih = 0;
        {
            h -= (h - ih) * (10000 - level) / 10000;
        } //End block
        int layoutDirection;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.996 -0400", hash_original_method = "042D8C5B60AD594AE3EBCE13D95C97E6", hash_generated_method = "3EA8D5D1805DE9A02E84E6EBDB47D3D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicWidth() {
        int var2B71D04AE1D94A4FC1FA398B882D5481_205665844 = (mClipState.mDrawable.getIntrinsicWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.996 -0400", hash_original_method = "2200041BC151EB15073098E0A2FD1970", hash_generated_method = "DAE84B4A2EB60E3D6FFA84DAB13028E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicHeight() {
        int varBF36CBCE367F887A243D5F42A43AE8CC_16535707 = (mClipState.mDrawable.getIntrinsicHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.997 -0400", hash_original_method = "80C96E88400AA50FF8906D46C3CD5A6C", hash_generated_method = "7E5DE70A93D33AEF37D15DB4E83FF4FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        {
            boolean var4D1BD4C813EBF81C269213C640D8A496_302367694 = (mClipState.canConstantState());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.997 -0400", hash_original_method = "DA3973DF13E25909CBF5E61AD4C16433", hash_generated_method = "3E1F022558AE8934A036B92F18BA40E4")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.998 -0400", hash_original_method = "9DFA0AF157AD09F9E42E54EF8A59DA7F", hash_generated_method = "E89503D15CDD2B7804AE6A8B1CCBB922")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable var71BD9EE9E4F61A3212A551D6F25F0D39_616225681 = (new ClipDrawable(this, null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ClipDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.998 -0400", hash_original_method = "9FB9989AA654F677F07C2F4A3C4B1057", hash_generated_method = "B83A689985E9D86D553C10EFC381E29E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var5077B0567BCE14F5200CDDEB434F08D7_592632401 = (new ClipDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ClipDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.998 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.998 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "91841D4C432CEA46787D356B5812EFCD")
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


    
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
}

