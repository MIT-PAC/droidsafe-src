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

public class ScaleDrawable extends Drawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.008 -0400", hash_original_field = "2D1FE34192530332F56868A0998C61E0", hash_generated_field = "1B46C06B589E11041FD605EA02E6FD03")

    private ScaleState mScaleState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.008 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.008 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "A9D5B7D1068DC6DDDEE02560E993CCF6")

    private Rect mTmpRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.017 -0400", hash_original_method = "514942F1E0299625DD7C1CF4A65C7704", hash_generated_method = "EC158C9898C13743C5AABD0B773303D8")
      ScaleDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.019 -0400", hash_original_method = "70D37B4EA14F56A15F832FEAF48A06AB", hash_generated_method = "1073325E7E75732B2C3B81CE7280D839")
    public  ScaleDrawable(Drawable drawable, int gravity, float scaleWidth, float scaleHeight) {
        this(null, null);
        mScaleState.mDrawable = drawable;
        mScaleState.mGravity = gravity;
        mScaleState.mScaleWidth = scaleWidth;
        mScaleState.mScaleHeight = scaleHeight;
        {
            drawable.setCallback(this);
        } //End block
        // ---------- Original Method ----------
        //mScaleState.mDrawable = drawable;
        //mScaleState.mGravity = gravity;
        //mScaleState.mScaleWidth = scaleWidth;
        //mScaleState.mScaleHeight = scaleHeight;
        //if (drawable != null) {
            //drawable.setCallback(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.022 -0400", hash_original_method = "044BA74036106E0DA1F4FE69AE9E5ADC", hash_generated_method = "6721B4F6DF11F5114CA467CA4B12E797")
    private  ScaleDrawable(ScaleState state, Resources res) {
        mScaleState = new ScaleState(state, this, res);
        // ---------- Original Method ----------
        //mScaleState = new ScaleState(state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.041 -0400", hash_original_method = "AEF970ED5616036B7E8018EB225E392F", hash_generated_method = "88542CD089229D3F2783D362AE161198")
    public Drawable getDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1814641976 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1814641976 = mScaleState.mDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_1814641976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1814641976;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable;
    }

    
        private static float getPercent(TypedArray a, int name) {
        String s = a.getString(name);
        if (s != null) {
            if (s.endsWith("%")) {
                String f = s.substring(0, s.length() - 1);
                return Float.parseFloat(f) / 100.0f;
            }
        }
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.063 -0400", hash_original_method = "49F4934EE2B25F6F115AF16904B4D689", hash_generated_method = "B92563F6378509E924106BE1871EE4A6")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);
        int type;
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ScaleDrawable);
        float sw;
        sw = getPercent(a, com.android.internal.R.styleable.ScaleDrawable_scaleWidth);
        float sh;
        sh = getPercent(a, com.android.internal.R.styleable.ScaleDrawable_scaleHeight);
        int g;
        g = a.getInt(com.android.internal.R.styleable.ScaleDrawable_scaleGravity, Gravity.LEFT);
        boolean min;
        min = a.getBoolean(
                com.android.internal.R.styleable.ScaleDrawable_useIntrinsicSizeAsMinimum, false);
        Drawable dr;
        dr = a.getDrawable(com.android.internal.R.styleable.ScaleDrawable_drawable);
        a.recycle();
        int outerDepth;
        outerDepth = parser.getDepth();
        {
            boolean var09B6D7ADFBD75C31FC39E543D494D2B2_573576884 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No drawable specified for <scale>");
        } //End block
        mScaleState.mDrawable = dr;
        mScaleState.mScaleWidth = sw;
        mScaleState.mScaleHeight = sh;
        mScaleState.mGravity = g;
        mScaleState.mUseIntrinsicSizeAsMin = min;
        {
            dr.setCallback(this);
        } //End block
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.064 -0400", hash_original_method = "DF6A36F8E9590497BD97E858748A70C0", hash_generated_method = "5301F3784DFD62FF854E0E6E43C78680")
    public void invalidateDrawable(Drawable who) {
        {
            boolean varB8E7F14DBE199F8ABFBF8F9EE31B80A9_1773292799 = (getCallback() != null);
            {
                getCallback().invalidateDrawable(this);
            } //End block
        } //End collapsed parenthetic
        addTaint(who.getTaint());
        // ---------- Original Method ----------
        //if (getCallback() != null) {
            //getCallback().invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.076 -0400", hash_original_method = "18649734DD6C42C2C51CF25B20D68FBF", hash_generated_method = "173D04047D117995840BD2371E559C3A")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        {
            boolean varB8E7F14DBE199F8ABFBF8F9EE31B80A9_488692718 = (getCallback() != null);
            {
                getCallback().scheduleDrawable(this, what, when);
            } //End block
        } //End collapsed parenthetic
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        addTaint(when);
        // ---------- Original Method ----------
        //if (getCallback() != null) {
            //getCallback().scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.081 -0400", hash_original_method = "8711E8318CA3821644E7E9EDAB95B5BC", hash_generated_method = "C86040E48F3E1E537168E78E3527860D")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        {
            boolean varB8E7F14DBE199F8ABFBF8F9EE31B80A9_1774048223 = (getCallback() != null);
            {
                getCallback().unscheduleDrawable(this, what);
            } //End block
        } //End collapsed parenthetic
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //if (getCallback() != null) {
            //getCallback().unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.082 -0400", hash_original_method = "ADD59FF7C9EB5B0D687113ACE781DE45", hash_generated_method = "33868F2FFE35D92DBC9B3CCDA860E6CF")
    @Override
    public void draw(Canvas canvas) {
        {
            boolean var7358356BD51883D862E8E6D8E4009D07_2082506872 = (mScaleState.mDrawable.getLevel() != 0);
            mScaleState.mDrawable.draw(canvas);
        } //End collapsed parenthetic
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //if (mScaleState.mDrawable.getLevel() != 0)
            //mScaleState.mDrawable.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.083 -0400", hash_original_method = "E88B2D3506B9FB1C95A0FECA8D5B6D9F", hash_generated_method = "58F8F690A330DEF5251881D74E72B8E8")
    @Override
    public int getChangingConfigurations() {
        int var612C20DFF67BAB9BD785BA1BD3D9443E_1976185385 = (super.getChangingConfigurations()
                | mScaleState.mChangingConfigurations
                | mScaleState.mDrawable.getChangingConfigurations());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_823952739 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_823952739;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mScaleState.mChangingConfigurations
                //| mScaleState.mDrawable.getChangingConfigurations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.084 -0400", hash_original_method = "2834251DB4FA1276891A806CA1B46D6D", hash_generated_method = "04DD5900E84881545EC5036EB5EA3DA3")
    @Override
    public boolean getPadding(Rect padding) {
        boolean var1532CFD2CDCF4ECD604CC172D7C7AE2D_2002311688 = (mScaleState.mDrawable.getPadding(padding));
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1462982796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1462982796;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getPadding(padding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.103 -0400", hash_original_method = "DF926DDC801D2CA5859468C5FAF6E2DB", hash_generated_method = "26575F26E8D06777EE6F6FCE748DCF5D")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        mScaleState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_1642696575 = (super.setVisible(visible, restart));
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_751732974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_751732974;
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setVisible(visible, restart);
        //return super.setVisible(visible, restart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.104 -0400", hash_original_method = "A9094AF2E7BD2624EE02834D750BE346", hash_generated_method = "09FA72BDC3A1D34CA19DEF9C5A90324B")
    @Override
    public void setAlpha(int alpha) {
        mScaleState.mDrawable.setAlpha(alpha);
        addTaint(alpha);
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setAlpha(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.109 -0400", hash_original_method = "2F836B47975A4E15DB5892CD09923112", hash_generated_method = "4E957712A0F08FB64F19FFB603648278")
    @Override
    public void setColorFilter(ColorFilter cf) {
        mScaleState.mDrawable.setColorFilter(cf);
        addTaint(cf.getTaint());
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setColorFilter(cf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.110 -0400", hash_original_method = "80BFCB126A2061429F3FFA03D49A8EF5", hash_generated_method = "F32BC73F38405B691E06A1EA520B9311")
    @Override
    public int getOpacity() {
        int varF4977642C540CF84B049D0A6C04853BB_489105940 = (mScaleState.mDrawable.getOpacity());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796307622 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796307622;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.110 -0400", hash_original_method = "0B20FD6DAF06E7B53C037B30AA0A67FB", hash_generated_method = "8B2252582CA881040DA90C3956F8FBF8")
    @Override
    public boolean isStateful() {
        boolean var737BE650B153F47A71DDD22A0760476E_1362712511 = (mScaleState.mDrawable.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817913940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_817913940;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.136 -0400", hash_original_method = "53615D161AB187EDCCE7BACA4EBD5437", hash_generated_method = "42D3EC8FA47BB060F80753E731C7195E")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean changed;
        changed = mScaleState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_652100880 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_652100880;
        // ---------- Original Method ----------
        //boolean changed = mScaleState.mDrawable.setState(state);
        //onBoundsChange(getBounds());
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.137 -0400", hash_original_method = "60A547B14486DD6AB0D2DFD460195C57", hash_generated_method = "94A046C9DFEB4A15F7CDEBEF73C11F5C")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mScaleState.mDrawable.setLevel(level);
        onBoundsChange(getBounds());
        invalidateSelf();
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_843103763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_843103763;
        // ---------- Original Method ----------
        //mScaleState.mDrawable.setLevel(level);
        //onBoundsChange(getBounds());
        //invalidateSelf();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.147 -0400", hash_original_method = "07137BB41A1EF8F3D963DF117D82A94E", hash_generated_method = "BD64B8319FE423121BEA63626CE1128F")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Rect r;
        r = mTmpRect;
        boolean min;
        min = mScaleState.mUseIntrinsicSizeAsMin;
        int level;
        level = getLevel();
        int w;
        w = bounds.width();
        {
            int iw;
            iw = mScaleState.mDrawable.getIntrinsicWidth();
            iw = 0;
            w -= (int) ((w - iw) * (10000 - level) * mScaleState.mScaleWidth / 10000);
        } //End block
        int h;
        h = bounds.height();
        {
            int ih;
            ih = mScaleState.mDrawable.getIntrinsicHeight();
            ih = 0;
            h -= (int) ((h - ih) * (10000 - level) * mScaleState.mScaleHeight / 10000);
        } //End block
        int layoutDirection;
        layoutDirection = getResolvedLayoutDirectionSelf();
        Gravity.apply(mScaleState.mGravity, w, h, bounds, r, layoutDirection);
        {
            mScaleState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
        } //End block
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.147 -0400", hash_original_method = "707D1CC9562C9896640A756558D656DB", hash_generated_method = "44EE296C22D251DBC0AD08DF9CCF6E22")
    @Override
    public int getIntrinsicWidth() {
        int var7D4BA5BA8C669B0C5F882713B5CD9F2F_1246396138 = (mScaleState.mDrawable.getIntrinsicWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390221888 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390221888;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.168 -0400", hash_original_method = "974D81B98CAEE5C460DF640DA8AD364B", hash_generated_method = "51B9FDD715BA82BB1BBF4F78C5EC2265")
    @Override
    public int getIntrinsicHeight() {
        int var648D37C654A92FDAC5B6A248AE646274_112763145 = (mScaleState.mDrawable.getIntrinsicHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911540717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911540717;
        // ---------- Original Method ----------
        //return mScaleState.mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.169 -0400", hash_original_method = "F60FC330EC8290C7F4098E941B339581", hash_generated_method = "FA545823CCB4EB819A80E00B269655EE")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_253457342 = null; //Variable for return #1
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_259352285 = null; //Variable for return #2
        {
            boolean var2E18AB2C604DBA57BAF25385D4A8DA81_1461734687 = (mScaleState.canConstantState());
            {
                mScaleState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_253457342 = mScaleState;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_259352285 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_1364471615; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1364471615 = varB4EAC82CA7396A68D541C85D26508E83_253457342;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1364471615 = varB4EAC82CA7396A68D541C85D26508E83_259352285;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1364471615.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1364471615;
        // ---------- Original Method ----------
        //if (mScaleState.canConstantState()) {
            //mScaleState.mChangingConfigurations = getChangingConfigurations();
            //return mScaleState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.171 -0400", hash_original_method = "9ABDABB0B6579EA1F785C22EF86AAE91", hash_generated_method = "6105F1A4429881D193AC9A93B977A4C9")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_648956312 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_465636280 = (!mMutated && super.mutate() == this);
            {
                mScaleState.mDrawable.mutate();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_648956312 = this;
        varB4EAC82CA7396A68D541C85D26508E83_648956312.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_648956312;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mScaleState.mDrawable.mutate();
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class ScaleState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.171 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.171 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.171 -0400", hash_original_field = "CD273D700DE8BE19C70F514281E9F484", hash_generated_field = "BE62C65ADB73C09453C986440B687A2B")

        float mScaleWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.171 -0400", hash_original_field = "B7DF5EF785A593829B5CF83A707A45D2", hash_generated_field = "34CDE4EA9566E05D3D0D966D1D0818AB")

        float mScaleHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.171 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "E8D24DE70DE8CB945622B4CE486A90EA")

        int mGravity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.172 -0400", hash_original_field = "F9EF06587AEDB2DA6BE03CDD584CD1BE", hash_generated_field = "28A7B0326EF7D610D5240DD7AC8F8125")

        boolean mUseIntrinsicSizeAsMin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.172 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.172 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.194 -0400", hash_original_method = "35CFE1A9959D60B5E323A5A7C20CFF5D", hash_generated_method = "97D661CB0E38742BB8A6379E7C58CA29")
          ScaleState(ScaleState orig, ScaleDrawable owner, Resources res) {
            {
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                } //End block
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable();
                } //End block
                mDrawable.setCallback(owner);
                mScaleWidth = orig.mScaleWidth;
                mScaleHeight = orig.mScaleHeight;
                mGravity = orig.mGravity;
                mUseIntrinsicSizeAsMin = orig.mUseIntrinsicSizeAsMin;
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
                //mScaleWidth = orig.mScaleWidth;
                //mScaleHeight = orig.mScaleHeight;
                //mGravity = orig.mGravity;
                //mUseIntrinsicSizeAsMin = orig.mUseIntrinsicSizeAsMin;
                //mCheckedConstantState = mCanConstantState = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.200 -0400", hash_original_method = "5066D62B21872517357C79E834FBAD6A", hash_generated_method = "574E20046998466CB20CCCAA430F4A5C")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1629650517 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1629650517 = new ScaleDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_1629650517.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1629650517;
            // ---------- Original Method ----------
            //return new ScaleDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.201 -0400", hash_original_method = "449170E73BA9730DCC0B8E2FFEB867F7", hash_generated_method = "C7A6824E6BDA200E2BEBBF0FA1390711")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1043524607 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1043524607 = new ScaleDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1043524607.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1043524607;
            // ---------- Original Method ----------
            //return new ScaleDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.202 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "DF0293FA2B28216257B78965E9FA346B")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095005034 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095005034;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.209 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "36360BC60AC54263E19AE6D946B7EF10")
         boolean canConstantState() {
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122548200 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122548200;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = mDrawable.getConstantState() != null;
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
}

