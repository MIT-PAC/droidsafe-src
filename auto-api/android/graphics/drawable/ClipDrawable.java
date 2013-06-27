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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.607 -0400", hash_original_field = "D8BC1207877FB9E05003BB32CB0428B4", hash_generated_field = "AB4FF940C8217DFA5B7A6EF2CC01064E")

    private ClipState mClipState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.607 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "A9D5B7D1068DC6DDDEE02560E993CCF6")

    private Rect mTmpRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.607 -0400", hash_original_method = "E02759DF2D4F91913B09748266B3DC55", hash_generated_method = "2B186D8FB2296E2181BF9479B3E0E4E2")
      ClipDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.608 -0400", hash_original_method = "5201E74D3B1AF986B1DE2C301B497FD9", hash_generated_method = "15A33C9D4647E5B367A8011AFB2AE789")
    public  ClipDrawable(Drawable drawable, int gravity, int orientation) {
        this(null, null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.611 -0400", hash_original_method = "F385B151B35BFC6DCEF1AAF1F3B81836", hash_generated_method = "9297ED1FDF6C3519ACB39D77D3FE54B0")
    private  ClipDrawable(ClipState state, Resources res) {
        mClipState = new ClipState(state, this, res);
        // ---------- Original Method ----------
        //mClipState = new ClipState(state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.706 -0400", hash_original_method = "35E10192FDDDDD39EA519306C2BA1E53", hash_generated_method = "90509187FE1A75EEC9092200804D7707")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
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
            boolean var09B6D7ADFBD75C31FC39E543D494D2B2_1786187037 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
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
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.707 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "8C74E1ED724AA0C6A0C97462CE6BFB75")
    public void invalidateDrawable(Drawable who) {
        Callback callback;
        callback = getCallback();
        {
            callback.invalidateDrawable(this);
        } //End block
        addTaint(who.getTaint());
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.707 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "D0BA170008FFB5E5F5CAA53137A69B81")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Callback callback;
        callback = getCallback();
        {
            callback.scheduleDrawable(this, what, when);
        } //End block
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        addTaint(when);
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.711 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "F27A8BA34D960AEC80EA06B1020FC534")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        Callback callback;
        callback = getCallback();
        {
            callback.unscheduleDrawable(this, what);
        } //End block
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.712 -0400", hash_original_method = "67F829CCE512EF7E67F091FC7A5204DA", hash_generated_method = "4F4AEDCBBEBC16DA2404A5EF15EC71A7")
    @Override
    public int getChangingConfigurations() {
        int varDFC98A828F1E5DD4ACFDD09BE75CDD44_860745792 = (super.getChangingConfigurations()
                | mClipState.mChangingConfigurations
                | mClipState.mDrawable.getChangingConfigurations());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492411085 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492411085;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mClipState.mChangingConfigurations
                //| mClipState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.712 -0400", hash_original_method = "EBC5879EAC2AD881F46A140E8365AA28", hash_generated_method = "2F47FF12952586D20D735B6D9A77A73A")
    @Override
    public boolean getPadding(Rect padding) {
        boolean varFA0EE5B84D41E6EA15329494EE34AF85_1273316164 = (mClipState.mDrawable.getPadding(padding));
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1141990002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1141990002;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getPadding(padding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.713 -0400", hash_original_method = "BCB1CA235EA7FE91BD623275B8F06E4E", hash_generated_method = "0988D4FD6E19E71CBE02FE21C9DFEB66")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        mClipState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_1391632521 = (super.setVisible(visible, restart));
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691211074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691211074;
        // ---------- Original Method ----------
        //mClipState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.713 -0400", hash_original_method = "8A8063C7E15313BD8D8740621EFCD055", hash_generated_method = "674AFC95E0D9B166B7092E92B7698A95")
    @Override
    public void setAlpha(int alpha) {
        mClipState.mDrawable.setAlpha(alpha);
        addTaint(alpha);
        // ---------- Original Method ----------
        //mClipState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.737 -0400", hash_original_method = "4805CD50FD09C28529E6873146205090", hash_generated_method = "6E208365696512FC158D7281D2029286")
    @Override
    public void setColorFilter(ColorFilter cf) {
        mClipState.mDrawable.setColorFilter(cf);
        addTaint(cf.getTaint());
        // ---------- Original Method ----------
        //mClipState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.737 -0400", hash_original_method = "D50D875832F26A4F5A2E593F0458B980", hash_generated_method = "001551AE431BE992186A7D8ED701421F")
    @Override
    public int getOpacity() {
        int var7EBA07C3058A7D8780045D81DE96085D_346746190 = (mClipState.mDrawable.getOpacity());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1188937699 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1188937699;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.738 -0400", hash_original_method = "A8A44DACBEBFA3295CF5300D7DD6141E", hash_generated_method = "BC863871B562B77E70571AD8486440B9")
    @Override
    public boolean isStateful() {
        boolean var82D4A15835FEB45AECBB70076CB3548B_215663545 = (mClipState.mDrawable.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986378561 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_986378561;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.738 -0400", hash_original_method = "F2335EB963F31FC1C9D5098F086ABEDC", hash_generated_method = "BE89116C470D1DA2EC1E148ADCCD8785")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean var818D62B4D5CE213BE71279F3D8049039_1822152940 = (mClipState.mDrawable.setState(state));
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047445850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047445850;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.setState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.739 -0400", hash_original_method = "205025D2BBBB226C56B3B5E3828C12A2", hash_generated_method = "E7F7F627F449840C9F558841C299172E")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mClipState.mDrawable.setLevel(level);
        invalidateSelf();
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1089889605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1089889605;
        // ---------- Original Method ----------
        //mClipState.mDrawable.setLevel(level);
        //invalidateSelf();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.739 -0400", hash_original_method = "3381996765F462751820E570B6825F64", hash_generated_method = "EA5D51EC6114A47D567FD09920D3CFB0")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mClipState.mDrawable.setBounds(bounds);
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //mClipState.mDrawable.setBounds(bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.746 -0400", hash_original_method = "0FB9453D484502FB8FF0BB7F530F2AA8", hash_generated_method = "A0F81C0D9F33985ED1841F78FABA2BBB")
    @Override
    public void draw(Canvas canvas) {
        {
            boolean varDC16A1B821C9D811C92DD71CA522B4C3_495667482 = (mClipState.mDrawable.getLevel() == 0);
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
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.777 -0400", hash_original_method = "042D8C5B60AD594AE3EBCE13D95C97E6", hash_generated_method = "94105A9DA5130108E9E7ED41A1CE65D8")
    @Override
    public int getIntrinsicWidth() {
        int var2B71D04AE1D94A4FC1FA398B882D5481_1150117606 = (mClipState.mDrawable.getIntrinsicWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210711957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210711957;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.784 -0400", hash_original_method = "2200041BC151EB15073098E0A2FD1970", hash_generated_method = "F613B99C10C63FB9FE92885FC676FEE7")
    @Override
    public int getIntrinsicHeight() {
        int varBF36CBCE367F887A243D5F42A43AE8CC_1478384309 = (mClipState.mDrawable.getIntrinsicHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_544193065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_544193065;
        // ---------- Original Method ----------
        //return mClipState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.785 -0400", hash_original_method = "80C96E88400AA50FF8906D46C3CD5A6C", hash_generated_method = "04F90E4BA776C5379256B4A00CB4CABC")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1876798708 = null; //Variable for return #1
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1284428763 = null; //Variable for return #2
        {
            boolean var4D1BD4C813EBF81C269213C640D8A496_333537332 = (mClipState.canConstantState());
            {
                mClipState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_1876798708 = mClipState;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1284428763 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_223737794; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_223737794 = varB4EAC82CA7396A68D541C85D26508E83_1876798708;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_223737794 = varB4EAC82CA7396A68D541C85D26508E83_1284428763;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_223737794.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_223737794;
        // ---------- Original Method ----------
        //if (mClipState.canConstantState()) {
            //mClipState.mChangingConfigurations = getChangingConfigurations();
            //return mClipState;
        //}
        //return null;
    }

    
    final static class ClipState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.788 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.789 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.789 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "9D3FC5FADE012FDDFCCC496073866451")

        int mOrientation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.789 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "E8D24DE70DE8CB945622B4CE486A90EA")

        int mGravity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.789 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.789 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.808 -0400", hash_original_method = "DA3973DF13E25909CBF5E61AD4C16433", hash_generated_method = "5DC0E152685E72FB64312B4B24CA488D")
          ClipState(ClipState orig, ClipDrawable owner, Resources res) {
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
            addTaint(owner.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.826 -0400", hash_original_method = "9DFA0AF157AD09F9E42E54EF8A59DA7F", hash_generated_method = "48F322E989BED1BE43D73B24E2CD0ECB")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_774333621 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_774333621 = new ClipDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_774333621.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_774333621;
            // ---------- Original Method ----------
            //return new ClipDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.826 -0400", hash_original_method = "9FB9989AA654F677F07C2F4A3C4B1057", hash_generated_method = "3BD7D799617CFE5962474A7FAF4AEF46")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_213792947 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_213792947 = new ClipDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_213792947.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_213792947;
            // ---------- Original Method ----------
            //return new ClipDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.827 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "01707482B9D61D7232FEE4BBC3799D5C")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187937575 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187937575;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.840 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "430DA2CB0EEDD8CDA95470B91C1F892E")
         boolean canConstantState() {
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_714478939 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_714478939;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.841 -0400", hash_original_field = "ADE21E8CF32C67ED4C28B09E01F03C1C", hash_generated_field = "EACA224B8385161B605A2E64A4D16B8A")

    public static final int HORIZONTAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.841 -0400", hash_original_field = "B0CF86328088A747FB6317893A81E46E", hash_generated_field = "D756A470A2986330BFAB916722475532")

    public static final int VERTICAL = 2;
}

