package android.graphics.drawable;

// Droidsafe Imports
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ClipDrawable extends Drawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.469 -0400", hash_original_field = "D8BC1207877FB9E05003BB32CB0428B4", hash_generated_field = "AB4FF940C8217DFA5B7A6EF2CC01064E")

    private ClipState mClipState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.469 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.469 -0400", hash_original_method = "E02759DF2D4F91913B09748266B3DC55", hash_generated_method = "2B186D8FB2296E2181BF9479B3E0E4E2")
      ClipDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.470 -0400", hash_original_method = "5201E74D3B1AF986B1DE2C301B497FD9", hash_generated_method = "66CE8596D6C8FF092D446B0A1E09F43E")
    public  ClipDrawable(Drawable drawable, int gravity, int orientation) {
        this(null, null);
        mClipState.mDrawable = drawable;
        mClipState.mGravity = gravity;
        mClipState.mOrientation = orientation;
        if(drawable != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.471 -0400", hash_original_method = "F385B151B35BFC6DCEF1AAF1F3B81836", hash_generated_method = "9297ED1FDF6C3519ACB39D77D3FE54B0")
    private  ClipDrawable(ClipState state, Resources res) {
        mClipState = new ClipState(state, this, res);
        // ---------- Original Method ----------
        //mClipState = new ClipState(state, this, res);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.473 -0400", hash_original_method = "35E10192FDDDDD39EA519306C2BA1E53", hash_generated_method = "019366ABE352711C758006AF17898AFF")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        super.inflate(r, parser, attrs);
        int type;
        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ClipDrawable);
        int orientation = a.getInt(
                com.android.internal.R.styleable.ClipDrawable_clipOrientation,
                HORIZONTAL);
        int g = a.getInt(com.android.internal.R.styleable.ClipDrawable_gravity, Gravity.LEFT);
        Drawable dr = a.getDrawable(com.android.internal.R.styleable.ClipDrawable_drawable);
        a.recycle();
        final int outerDepth = parser.getDepth();
        while
((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth))        
        {
            if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } //End block
            dr = Drawable.createFromXmlInner(r, parser, attrs);
        } //End block
        if(dr == null)        
        {
            IllegalArgumentException var24122855E105F0E00697E686EAD0C150_183338075 = new IllegalArgumentException("No drawable specified for <clip>");
            var24122855E105F0E00697E686EAD0C150_183338075.addTaint(taint);
            throw var24122855E105F0E00697E686EAD0C150_183338075;
        } //End block
        mClipState.mDrawable = dr;
        mClipState.mOrientation = orientation;
        mClipState.mGravity = g;
        dr.setCallback(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.473 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CEDEB5E33EFE6B1A6A0CCC10DBF093")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.474 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "7093C805993ACF54047727682755EE99")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.476 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "FFEE17E462526EA539C05FAA6C36C1E2")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.476 -0400", hash_original_method = "67F829CCE512EF7E67F091FC7A5204DA", hash_generated_method = "22D80E61FF2DFF49788E8845D2C1EC90")
    @Override
    public int getChangingConfigurations() {
        int varA579551422F04D11F8B29077427D6F57_1655470123 = (super.getChangingConfigurations()
                | mClipState.mChangingConfigurations
                | mClipState.mDrawable.getChangingConfigurations());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229633764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229633764;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mClipState.mChangingConfigurations
                //| mClipState.mDrawable.getChangingConfigurations();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.477 -0400", hash_original_method = "EBC5879EAC2AD881F46A140E8365AA28", hash_generated_method = "7712F4BB7A50A3FF64E30E0B184AE029")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        boolean varFAD4DE32C6B8F653D6791E8363C960D8_1385876423 = (mClipState.mDrawable.getPadding(padding));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_629637926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_629637926;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getPadding(padding);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.477 -0400", hash_original_method = "BCB1CA235EA7FE91BD623275B8F06E4E", hash_generated_method = "A8D4A3AA22B1C9A1249477696AF695DD")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        addTaint(visible);
        mClipState.mDrawable.setVisible(visible, restart);
        boolean varDDF69A03BCD0C3664F5E7921DE2D1E4B_2044753027 = (super.setVisible(visible, restart));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449504834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_449504834;
        // ---------- Original Method ----------
        //mClipState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.478 -0400", hash_original_method = "8A8063C7E15313BD8D8740621EFCD055", hash_generated_method = "C6BBD33AE4A4514B1B19A4C0444D6170")
    @Override
    public void setAlpha(int alpha) {
        addTaint(alpha);
        mClipState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setAlpha(alpha);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.478 -0400", hash_original_method = "4805CD50FD09C28529E6873146205090", hash_generated_method = "A4F877D61DCA0564CAD93E05E9184794")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        mClipState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setColorFilter(cf);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.479 -0400", hash_original_method = "D50D875832F26A4F5A2E593F0458B980", hash_generated_method = "D6C729BD70A2C6EEDEB2F6159D728418")
    @Override
    public int getOpacity() {
        int varA0663EE53A6484329F4090CE1A842FF9_441425531 = (mClipState.mDrawable.getOpacity());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664299327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664299327;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getOpacity();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.479 -0400", hash_original_method = "A8A44DACBEBFA3295CF5300D7DD6141E", hash_generated_method = "E3B54ACF232CD58382AEA26685E82BE0")
    @Override
    public boolean isStateful() {
        boolean var06634F57997190D9423CD1B53977327B_864497100 = (mClipState.mDrawable.isStateful());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604885174 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_604885174;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.isStateful();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.480 -0400", hash_original_method = "F2335EB963F31FC1C9D5098F086ABEDC", hash_generated_method = "9EF3C08785840344AB3D8F4F0E608B2B")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state[0]);
        boolean var565A9662AF4C302699F949B3B7E23CD6_1590584451 = (mClipState.mDrawable.setState(state));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116405027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116405027;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.setState(state);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.480 -0400", hash_original_method = "205025D2BBBB226C56B3B5E3828C12A2", hash_generated_method = "9914D2A46C623FD068670254786E4600")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        mClipState.mDrawable.setLevel(level);
        invalidateSelf();
        boolean varB326B5062B2F0E69046810717534CB09_25613044 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50876812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50876812;
        // ---------- Original Method ----------
        //mClipState.mDrawable.setLevel(level);
        //invalidateSelf();
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.480 -0400", hash_original_method = "3381996765F462751820E570B6825F64", hash_generated_method = "37A1FA29FAAC696B6A2A4E30BF85A824")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        mClipState.mDrawable.setBounds(bounds);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setBounds(bounds);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.481 -0400", hash_original_method = "0FB9453D484502FB8FF0BB7F530F2AA8", hash_generated_method = "7ADF341AFC565D079D0B2D1346E1C92D")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        if(mClipState.mDrawable.getLevel() == 0)        
        {
            return;
        } //End block
        final Rect r = mTmpRect;
        final Rect bounds = getBounds();
        int level = getLevel();
        int w = bounds.width();
        final int iw = 0;
        if((mClipState.mOrientation & HORIZONTAL) != 0)        
        {
            w -= (w - iw) * (10000 - level) / 10000;
        } //End block
        int h = bounds.height();
        final int ih = 0;
        if((mClipState.mOrientation & VERTICAL) != 0)        
        {
            h -= (h - ih) * (10000 - level) / 10000;
        } //End block
        final int layoutDirection = getResolvedLayoutDirectionSelf();
        Gravity.apply(mClipState.mGravity, w, h, bounds, r, layoutDirection);
        if(w > 0 && h > 0)        
        {
            canvas.save();
            canvas.clipRect(r);
            mClipState.mDrawable.draw(canvas);
            canvas.restore();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.482 -0400", hash_original_method = "042D8C5B60AD594AE3EBCE13D95C97E6", hash_generated_method = "9C6073276F33531DA595739DCE6363D5")
    @Override
    public int getIntrinsicWidth() {
        int varDC1F62030896E05E1ACD4CC4B795F2A9_459253953 = (mClipState.mDrawable.getIntrinsicWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585065721 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585065721;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getIntrinsicWidth();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.482 -0400", hash_original_method = "2200041BC151EB15073098E0A2FD1970", hash_generated_method = "B895FAE92436C289E2AB2B181E5CDC5A")
    @Override
    public int getIntrinsicHeight() {
        int var20B1C804A1A79CAEFE1CD47195C7C192_287554761 = (mClipState.mDrawable.getIntrinsicHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844101532 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844101532;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getIntrinsicHeight();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.483 -0400", hash_original_method = "80C96E88400AA50FF8906D46C3CD5A6C", hash_generated_method = "BEBA750C7C33EF56061D5C67A3973675")
    @Override
    public ConstantState getConstantState() {
        if(mClipState.canConstantState())        
        {
            mClipState.mChangingConfigurations = getChangingConfigurations();
ConstantState var554FB556EE34346538C6DF0B021DA4DA_2081178726 =             mClipState;
            var554FB556EE34346538C6DF0B021DA4DA_2081178726.addTaint(taint);
            return var554FB556EE34346538C6DF0B021DA4DA_2081178726;
        } //End block
ConstantState var540C13E9E156B687226421B24F2DF178_117239021 =         null;
        var540C13E9E156B687226421B24F2DF178_117239021.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_117239021;
        // ---------- Original Method ----------
        //if (mClipState.canConstantState()) {
            //mClipState.mChangingConfigurations = getChangingConfigurations();
            //return mClipState;
        //}
        //return null;
    }

    
    final static class ClipState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.483 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.483 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.483 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "9D3FC5FADE012FDDFCCC496073866451")

        int mOrientation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.483 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "E8D24DE70DE8CB945622B4CE486A90EA")

        int mGravity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.483 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.483 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.485 -0400", hash_original_method = "DA3973DF13E25909CBF5E61AD4C16433", hash_generated_method = "689FCEF3A0D00C31651659142BCC3A91")
          ClipState(ClipState orig, ClipDrawable owner, Resources res) {
            addTaint(owner.getTaint());
            if(orig != null)            
            {
                if(res != null)                
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                } //End block
                else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.485 -0400", hash_original_method = "9DFA0AF157AD09F9E42E54EF8A59DA7F", hash_generated_method = "BA708CB0F22856866628409AC0DB06C9")
        @Override
        public Drawable newDrawable() {
Drawable var4ADEB656555E71C7D3E57F86EA7792A5_1847098529 =             new ClipDrawable(this, null);
            var4ADEB656555E71C7D3E57F86EA7792A5_1847098529.addTaint(taint);
            return var4ADEB656555E71C7D3E57F86EA7792A5_1847098529;
            // ---------- Original Method ----------
            //return new ClipDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.486 -0400", hash_original_method = "9FB9989AA654F677F07C2F4A3C4B1057", hash_generated_method = "C82735F4F6E10528F5C42318B20CAE60")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable varD81A884AF21461479E81269050DAF7A2_1451999110 =             new ClipDrawable(this, res);
            varD81A884AF21461479E81269050DAF7A2_1451999110.addTaint(taint);
            return varD81A884AF21461479E81269050DAF7A2_1451999110;
            // ---------- Original Method ----------
            //return new ClipDrawable(this, res);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.486 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "EC505A13F0ADA5270E1F44DA3200F76F")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_665827443 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418259959 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418259959;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.487 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "6C2CFB376580037E698F268D0156223D")
         boolean canConstantState() {
            if(!mCheckedConstantState)            
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var7C8FD9809F31C20B8422D623B0EC0C4F_1494886426 = (mCanConstantState);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_498712706 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_498712706;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.487 -0400", hash_original_field = "ADE21E8CF32C67ED4C28B09E01F03C1C", hash_generated_field = "EACA224B8385161B605A2E64A4D16B8A")

    public static final int HORIZONTAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.487 -0400", hash_original_field = "B0CF86328088A747FB6317893A81E46E", hash_generated_field = "D756A470A2986330BFAB916722475532")

    public static final int VERTICAL = 2;
}

