package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.500 -0400", hash_original_field = "2D1FE34192530332F56868A0998C61E0", hash_generated_field = "1B46C06B589E11041FD605EA02E6FD03")

    private ScaleState mScaleState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.500 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.501 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.501 -0400", hash_original_method = "514942F1E0299625DD7C1CF4A65C7704", hash_generated_method = "EC158C9898C13743C5AABD0B773303D8")
      ScaleDrawable() {
        this(null, null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.501 -0400", hash_original_method = "70D37B4EA14F56A15F832FEAF48A06AB", hash_generated_method = "1073325E7E75732B2C3B81CE7280D839")
    public  ScaleDrawable(Drawable drawable, int gravity, float scaleWidth, float scaleHeight) {
        this(null, null);
        mScaleState.mDrawable = drawable;
        mScaleState.mGravity = gravity;
        mScaleState.mScaleWidth = scaleWidth;
        mScaleState.mScaleHeight = scaleHeight;
        {
            drawable.setCallback(this);
        } 
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.502 -0400", hash_original_method = "044BA74036106E0DA1F4FE69AE9E5ADC", hash_generated_method = "6721B4F6DF11F5114CA467CA4B12E797")
    private  ScaleDrawable(ScaleState state, Resources res) {
        mScaleState = new ScaleState(state, this, res);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.503 -0400", hash_original_method = "AEF970ED5616036B7E8018EB225E392F", hash_generated_method = "7B907333841F0A55C4F2563F619CACB0")
    public Drawable getDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1305078885 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1305078885 = mScaleState.mDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_1305078885.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1305078885;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.504 -0400", hash_original_method = "49F4934EE2B25F6F115AF16904B4D689", hash_generated_method = "16A556836CB94D2584F31B84E5E20D9D")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);
        int type;
        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ScaleDrawable);
        float sw = getPercent(a, com.android.internal.R.styleable.ScaleDrawable_scaleWidth);
        float sh = getPercent(a, com.android.internal.R.styleable.ScaleDrawable_scaleHeight);
        int g = a.getInt(com.android.internal.R.styleable.ScaleDrawable_scaleGravity, Gravity.LEFT);
        boolean min = a.getBoolean(
                com.android.internal.R.styleable.ScaleDrawable_useIntrinsicSizeAsMinimum, false);
        Drawable dr = a.getDrawable(com.android.internal.R.styleable.ScaleDrawable_drawable);
        a.recycle();
        final int outerDepth = parser.getDepth();
        {
            boolean var09B6D7ADFBD75C31FC39E543D494D2B2_1582174109 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No drawable specified for <scale>");
        } 
        mScaleState.mDrawable = dr;
        mScaleState.mScaleWidth = sw;
        mScaleState.mScaleHeight = sh;
        mScaleState.mGravity = g;
        mScaleState.mUseIntrinsicSizeAsMin = min;
        {
            dr.setCallback(this);
        } 
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.505 -0400", hash_original_method = "DF6A36F8E9590497BD97E858748A70C0", hash_generated_method = "80D55B912027B7B4353087ACEF1E311C")
    public void invalidateDrawable(Drawable who) {
        {
            boolean varB8E7F14DBE199F8ABFBF8F9EE31B80A9_299679874 = (getCallback() != null);
            {
                getCallback().invalidateDrawable(this);
            } 
        } 
        addTaint(who.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.505 -0400", hash_original_method = "18649734DD6C42C2C51CF25B20D68FBF", hash_generated_method = "E0FCF9887AFA50E5FBD31589F9A92CB1")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        {
            boolean varB8E7F14DBE199F8ABFBF8F9EE31B80A9_1055068350 = (getCallback() != null);
            {
                getCallback().scheduleDrawable(this, what, when);
            } 
        } 
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        addTaint(when);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.506 -0400", hash_original_method = "8711E8318CA3821644E7E9EDAB95B5BC", hash_generated_method = "9AEF022E77C7A763ED16A660F963FA76")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        {
            boolean varB8E7F14DBE199F8ABFBF8F9EE31B80A9_1706967792 = (getCallback() != null);
            {
                getCallback().unscheduleDrawable(this, what);
            } 
        } 
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.506 -0400", hash_original_method = "ADD59FF7C9EB5B0D687113ACE781DE45", hash_generated_method = "B5C81E551E09E09DB888491A0DE23C28")
    @Override
    public void draw(Canvas canvas) {
        {
            boolean var7358356BD51883D862E8E6D8E4009D07_1163297548 = (mScaleState.mDrawable.getLevel() != 0);
            mScaleState.mDrawable.draw(canvas);
        } 
        addTaint(canvas.getTaint());
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.506 -0400", hash_original_method = "E88B2D3506B9FB1C95A0FECA8D5B6D9F", hash_generated_method = "7E2BF7712A26B1DBEB01B85F0436977D")
    @Override
    public int getChangingConfigurations() {
        int var612C20DFF67BAB9BD785BA1BD3D9443E_751490102 = (super.getChangingConfigurations()
                | mScaleState.mChangingConfigurations
                | mScaleState.mDrawable.getChangingConfigurations());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480017450 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480017450;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.507 -0400", hash_original_method = "2834251DB4FA1276891A806CA1B46D6D", hash_generated_method = "EF7849F63039971A7C3C7E551EB92870")
    @Override
    public boolean getPadding(Rect padding) {
        boolean var1532CFD2CDCF4ECD604CC172D7C7AE2D_1058376916 = (mScaleState.mDrawable.getPadding(padding));
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_957669865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_957669865;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.507 -0400", hash_original_method = "DF926DDC801D2CA5859468C5FAF6E2DB", hash_generated_method = "E786471D97D4F79237BBF4B8642BF68E")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        mScaleState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_407465144 = (super.setVisible(visible, restart));
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_720267776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_720267776;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.508 -0400", hash_original_method = "A9094AF2E7BD2624EE02834D750BE346", hash_generated_method = "09FA72BDC3A1D34CA19DEF9C5A90324B")
    @Override
    public void setAlpha(int alpha) {
        mScaleState.mDrawable.setAlpha(alpha);
        addTaint(alpha);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.508 -0400", hash_original_method = "2F836B47975A4E15DB5892CD09923112", hash_generated_method = "4E957712A0F08FB64F19FFB603648278")
    @Override
    public void setColorFilter(ColorFilter cf) {
        mScaleState.mDrawable.setColorFilter(cf);
        addTaint(cf.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.508 -0400", hash_original_method = "80BFCB126A2061429F3FFA03D49A8EF5", hash_generated_method = "077B62A0EEFB6659D43BC531E8B24ACA")
    @Override
    public int getOpacity() {
        int varF4977642C540CF84B049D0A6C04853BB_599931944 = (mScaleState.mDrawable.getOpacity());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677880122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677880122;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.509 -0400", hash_original_method = "0B20FD6DAF06E7B53C037B30AA0A67FB", hash_generated_method = "13188D383539B3737DD3A39AF2A40DAE")
    @Override
    public boolean isStateful() {
        boolean var737BE650B153F47A71DDD22A0760476E_1198413486 = (mScaleState.mDrawable.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1749786756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1749786756;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.509 -0400", hash_original_method = "53615D161AB187EDCCE7BACA4EBD5437", hash_generated_method = "67D1C0C54F6D4DE60BE47078F9F18D9E")
    @Override
    protected boolean onStateChange(int[] state) {
        
        boolean changed = mScaleState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_94650299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_94650299;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.509 -0400", hash_original_method = "60A547B14486DD6AB0D2DFD460195C57", hash_generated_method = "FA21A653D7BB4A2A27C4F7F1D2EA1C2B")
    @Override
    protected boolean onLevelChange(int level) {
        
        mScaleState.mDrawable.setLevel(level);
        onBoundsChange(getBounds());
        invalidateSelf();
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_635341681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_635341681;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.510 -0400", hash_original_method = "07137BB41A1EF8F3D963DF117D82A94E", hash_generated_method = "A154ABCF51B2FAC1D17A325CB289113C")
    @Override
    protected void onBoundsChange(Rect bounds) {
        
        final Rect r = mTmpRect;
        final boolean min = mScaleState.mUseIntrinsicSizeAsMin;
        int level = getLevel();
        int w = bounds.width();
        {
            int iw;
            iw = mScaleState.mDrawable.getIntrinsicWidth();
            iw = 0;
            w -= (int) ((w - iw) * (10000 - level) * mScaleState.mScaleWidth / 10000);
        } 
        int h = bounds.height();
        {
            int ih;
            ih = mScaleState.mDrawable.getIntrinsicHeight();
            ih = 0;
            h -= (int) ((h - ih) * (10000 - level) * mScaleState.mScaleHeight / 10000);
        } 
        final int layoutDirection = getResolvedLayoutDirectionSelf();
        Gravity.apply(mScaleState.mGravity, w, h, bounds, r, layoutDirection);
        {
            mScaleState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
        } 
        addTaint(bounds.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.510 -0400", hash_original_method = "707D1CC9562C9896640A756558D656DB", hash_generated_method = "268EA4CC3C6DE53A8F8E90C445665A0C")
    @Override
    public int getIntrinsicWidth() {
        int var7D4BA5BA8C669B0C5F882713B5CD9F2F_794522225 = (mScaleState.mDrawable.getIntrinsicWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228718389 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228718389;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.511 -0400", hash_original_method = "974D81B98CAEE5C460DF640DA8AD364B", hash_generated_method = "D58A01E73B3B289E41BA897012C37182")
    @Override
    public int getIntrinsicHeight() {
        int var648D37C654A92FDAC5B6A248AE646274_621360251 = (mScaleState.mDrawable.getIntrinsicHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889596993 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889596993;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.511 -0400", hash_original_method = "F60FC330EC8290C7F4098E941B339581", hash_generated_method = "0C1552D8A623BA74A16F039CFACC70B1")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1974107399 = null; 
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_706990366 = null; 
        {
            boolean var2E18AB2C604DBA57BAF25385D4A8DA81_1593226667 = (mScaleState.canConstantState());
            {
                mScaleState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_1974107399 = mScaleState;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_706990366 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_2079553993; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2079553993 = varB4EAC82CA7396A68D541C85D26508E83_1974107399;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2079553993 = varB4EAC82CA7396A68D541C85D26508E83_706990366;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2079553993.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2079553993;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.512 -0400", hash_original_method = "9ABDABB0B6579EA1F785C22EF86AAE91", hash_generated_method = "CA4EB1E8D154E0946552240390D8EDB7")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_876818545 = null; 
        {
            boolean varC94B19053599294E7944C8C841976773_318327158 = (!mMutated && super.mutate() == this);
            {
                mScaleState.mDrawable.mutate();
                mMutated = true;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_876818545 = this;
        varB4EAC82CA7396A68D541C85D26508E83_876818545.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_876818545;
        
        
            
            
        
        
    }

    
    final static class ScaleState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.512 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.512 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.512 -0400", hash_original_field = "CD273D700DE8BE19C70F514281E9F484", hash_generated_field = "BE62C65ADB73C09453C986440B687A2B")

        float mScaleWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.512 -0400", hash_original_field = "B7DF5EF785A593829B5CF83A707A45D2", hash_generated_field = "34CDE4EA9566E05D3D0D966D1D0818AB")

        float mScaleHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.512 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "E8D24DE70DE8CB945622B4CE486A90EA")

        int mGravity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.512 -0400", hash_original_field = "F9EF06587AEDB2DA6BE03CDD584CD1BE", hash_generated_field = "28A7B0326EF7D610D5240DD7AC8F8125")

        boolean mUseIntrinsicSizeAsMin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.513 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.513 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.513 -0400", hash_original_method = "35CFE1A9959D60B5E323A5A7C20CFF5D", hash_generated_method = "97D661CB0E38742BB8A6379E7C58CA29")
          ScaleState(ScaleState orig, ScaleDrawable owner, Resources res) {
            {
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                } 
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable();
                } 
                mDrawable.setCallback(owner);
                mScaleWidth = orig.mScaleWidth;
                mScaleHeight = orig.mScaleHeight;
                mGravity = orig.mGravity;
                mUseIntrinsicSizeAsMin = orig.mUseIntrinsicSizeAsMin;
                mCheckedConstantState = mCanConstantState = true;
            } 
            addTaint(owner.getTaint());
            
            
                
                    
                
                    
                
                
                
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.514 -0400", hash_original_method = "5066D62B21872517357C79E834FBAD6A", hash_generated_method = "554B4E9AA39DAD05D85B2DD99687E0C4")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1834104498 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1834104498 = new ScaleDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_1834104498.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1834104498;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.516 -0400", hash_original_method = "449170E73BA9730DCC0B8E2FFEB867F7", hash_generated_method = "506164670AEAF840F9F8487BB837C336")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_71187059 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_71187059 = new ScaleDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_71187059.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_71187059;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.517 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "0A7CD6F569E334FE40471A991616904A")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_627588843 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_627588843;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.517 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "8883CDFE580C4E38F480C3C61452AB1E")
         boolean canConstantState() {
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_981138623 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_981138623;
            
            
                
                
            
            
        }

        
    }


    
}

