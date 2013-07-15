package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.677 -0400", hash_original_field = "D8BC1207877FB9E05003BB32CB0428B4", hash_generated_field = "AB4FF940C8217DFA5B7A6EF2CC01064E")

    private ClipState mClipState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.677 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.677 -0400", hash_original_method = "E02759DF2D4F91913B09748266B3DC55", hash_generated_method = "2B186D8FB2296E2181BF9479B3E0E4E2")
      ClipDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.678 -0400", hash_original_method = "5201E74D3B1AF986B1DE2C301B497FD9", hash_generated_method = "66CE8596D6C8FF092D446B0A1E09F43E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.679 -0400", hash_original_method = "F385B151B35BFC6DCEF1AAF1F3B81836", hash_generated_method = "9297ED1FDF6C3519ACB39D77D3FE54B0")
    private  ClipDrawable(ClipState state, Resources res) {
        mClipState = new ClipState(state, this, res);
        // ---------- Original Method ----------
        //mClipState = new ClipState(state, this, res);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.681 -0400", hash_original_method = "35E10192FDDDDD39EA519306C2BA1E53", hash_generated_method = "9C747E5585DF5F4FE9454B1E4C4E9226")
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
            IllegalArgumentException var24122855E105F0E00697E686EAD0C150_281762344 = new IllegalArgumentException("No drawable specified for <clip>");
            var24122855E105F0E00697E686EAD0C150_281762344.addTaint(taint);
            throw var24122855E105F0E00697E686EAD0C150_281762344;
        } //End block
        mClipState.mDrawable = dr;
        mClipState.mOrientation = orientation;
        mClipState.mGravity = g;
        dr.setCallback(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.682 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CEDEB5E33EFE6B1A6A0CCC10DBF093")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.683 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "7093C805993ACF54047727682755EE99")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.686 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "FFEE17E462526EA539C05FAA6C36C1E2")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.686 -0400", hash_original_method = "67F829CCE512EF7E67F091FC7A5204DA", hash_generated_method = "EA924C9431A8D1450120AEABE26176ED")
    @Override
    public int getChangingConfigurations() {
        int varA579551422F04D11F8B29077427D6F57_1676090353 = (super.getChangingConfigurations()
                | mClipState.mChangingConfigurations
                | mClipState.mDrawable.getChangingConfigurations());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718601003 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718601003;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mClipState.mChangingConfigurations
                //| mClipState.mDrawable.getChangingConfigurations();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.687 -0400", hash_original_method = "EBC5879EAC2AD881F46A140E8365AA28", hash_generated_method = "42C91072C4B8C06D2986A2A148C11CCD")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        boolean varFAD4DE32C6B8F653D6791E8363C960D8_1423895593 = (mClipState.mDrawable.getPadding(padding));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1376588959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1376588959;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getPadding(padding);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.688 -0400", hash_original_method = "BCB1CA235EA7FE91BD623275B8F06E4E", hash_generated_method = "A3BFA1EB9B440A32C0A1935F4356B671")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        addTaint(visible);
        mClipState.mDrawable.setVisible(visible, restart);
        boolean varDDF69A03BCD0C3664F5E7921DE2D1E4B_611428188 = (super.setVisible(visible, restart));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1246986906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1246986906;
        // ---------- Original Method ----------
        //mClipState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.688 -0400", hash_original_method = "8A8063C7E15313BD8D8740621EFCD055", hash_generated_method = "C6BBD33AE4A4514B1B19A4C0444D6170")
    @Override
    public void setAlpha(int alpha) {
        addTaint(alpha);
        mClipState.mDrawable.setAlpha(alpha);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setAlpha(alpha);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.689 -0400", hash_original_method = "4805CD50FD09C28529E6873146205090", hash_generated_method = "A4F877D61DCA0564CAD93E05E9184794")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        mClipState.mDrawable.setColorFilter(cf);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setColorFilter(cf);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.689 -0400", hash_original_method = "D50D875832F26A4F5A2E593F0458B980", hash_generated_method = "31497C7B96EFF506BF9425F665221436")
    @Override
    public int getOpacity() {
        int varA0663EE53A6484329F4090CE1A842FF9_1274593284 = (mClipState.mDrawable.getOpacity());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182281577 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182281577;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getOpacity();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.690 -0400", hash_original_method = "A8A44DACBEBFA3295CF5300D7DD6141E", hash_generated_method = "494DA4B2705A8D7247299E9FFD0FE61E")
    @Override
    public boolean isStateful() {
        boolean var06634F57997190D9423CD1B53977327B_1763855838 = (mClipState.mDrawable.isStateful());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2094344868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2094344868;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.isStateful();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.691 -0400", hash_original_method = "F2335EB963F31FC1C9D5098F086ABEDC", hash_generated_method = "96A4783BE6D1A7B7A7A059170BA27020")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state[0]);
        boolean var565A9662AF4C302699F949B3B7E23CD6_2092467930 = (mClipState.mDrawable.setState(state));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_556009631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_556009631;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.setState(state);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.692 -0400", hash_original_method = "205025D2BBBB226C56B3B5E3828C12A2", hash_generated_method = "A5CB2B2FC087A54281F0F5AA4697EE50")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        mClipState.mDrawable.setLevel(level);
        invalidateSelf();
        boolean varB326B5062B2F0E69046810717534CB09_2116636406 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105532899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105532899;
        // ---------- Original Method ----------
        //mClipState.mDrawable.setLevel(level);
        //invalidateSelf();
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.693 -0400", hash_original_method = "3381996765F462751820E570B6825F64", hash_generated_method = "37A1FA29FAAC696B6A2A4E30BF85A824")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        mClipState.mDrawable.setBounds(bounds);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setBounds(bounds);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.694 -0400", hash_original_method = "0FB9453D484502FB8FF0BB7F530F2AA8", hash_generated_method = "7ADF341AFC565D079D0B2D1346E1C92D")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.695 -0400", hash_original_method = "042D8C5B60AD594AE3EBCE13D95C97E6", hash_generated_method = "36F52641D2C53A6D61820BCC32D335CE")
    @Override
    public int getIntrinsicWidth() {
        int varDC1F62030896E05E1ACD4CC4B795F2A9_1369990015 = (mClipState.mDrawable.getIntrinsicWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439508540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439508540;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getIntrinsicWidth();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.695 -0400", hash_original_method = "2200041BC151EB15073098E0A2FD1970", hash_generated_method = "022276BA3BBCF3E6AF98F86FAFE1E65B")
    @Override
    public int getIntrinsicHeight() {
        int var20B1C804A1A79CAEFE1CD47195C7C192_466563496 = (mClipState.mDrawable.getIntrinsicHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_18446096 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_18446096;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getIntrinsicHeight();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.695 -0400", hash_original_method = "80C96E88400AA50FF8906D46C3CD5A6C", hash_generated_method = "0B38EE3525861FC78C39241964D9F000")
    @Override
    public ConstantState getConstantState() {
    if(mClipState.canConstantState())        
        {
            mClipState.mChangingConfigurations = getChangingConfigurations();
ConstantState var554FB556EE34346538C6DF0B021DA4DA_251813578 =             mClipState;
            var554FB556EE34346538C6DF0B021DA4DA_251813578.addTaint(taint);
            return var554FB556EE34346538C6DF0B021DA4DA_251813578;
        } //End block
ConstantState var540C13E9E156B687226421B24F2DF178_1576210544 =         null;
        var540C13E9E156B687226421B24F2DF178_1576210544.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1576210544;
        // ---------- Original Method ----------
        //if (mClipState.canConstantState()) {
            //mClipState.mChangingConfigurations = getChangingConfigurations();
            //return mClipState;
        //}
        //return null;
    }

    
    final static class ClipState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.696 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.696 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.696 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "9D3FC5FADE012FDDFCCC496073866451")

        int mOrientation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.696 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "E8D24DE70DE8CB945622B4CE486A90EA")

        int mGravity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.696 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.696 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.697 -0400", hash_original_method = "DA3973DF13E25909CBF5E61AD4C16433", hash_generated_method = "689FCEF3A0D00C31651659142BCC3A91")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.698 -0400", hash_original_method = "9DFA0AF157AD09F9E42E54EF8A59DA7F", hash_generated_method = "FD105E933BCE83E83981A7F96761F3D6")
        @Override
        public Drawable newDrawable() {
Drawable var4ADEB656555E71C7D3E57F86EA7792A5_619401826 =             new ClipDrawable(this, null);
            var4ADEB656555E71C7D3E57F86EA7792A5_619401826.addTaint(taint);
            return var4ADEB656555E71C7D3E57F86EA7792A5_619401826;
            // ---------- Original Method ----------
            //return new ClipDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.698 -0400", hash_original_method = "9FB9989AA654F677F07C2F4A3C4B1057", hash_generated_method = "20CCE9FAC151A14220EF7A8003176521")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable varD81A884AF21461479E81269050DAF7A2_1922971291 =             new ClipDrawable(this, res);
            varD81A884AF21461479E81269050DAF7A2_1922971291.addTaint(taint);
            return varD81A884AF21461479E81269050DAF7A2_1922971291;
            // ---------- Original Method ----------
            //return new ClipDrawable(this, res);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.698 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "68E1FC4B55448DCAE6F8874429A612B2")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1976516196 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907033989 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907033989;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.699 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "35E9244EF42EDAA9B3E8340122DCF687")
         boolean canConstantState() {
    if(!mCheckedConstantState)            
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var7C8FD9809F31C20B8422D623B0EC0C4F_117518038 = (mCanConstantState);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779068342 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779068342;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.699 -0400", hash_original_field = "ADE21E8CF32C67ED4C28B09E01F03C1C", hash_generated_field = "EACA224B8385161B605A2E64A4D16B8A")

    public static final int HORIZONTAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.700 -0400", hash_original_field = "B0CF86328088A747FB6317893A81E46E", hash_generated_field = "D756A470A2986330BFAB916722475532")

    public static final int VERTICAL = 2;
}

