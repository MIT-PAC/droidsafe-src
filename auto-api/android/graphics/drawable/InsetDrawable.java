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
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;

public class InsetDrawable extends Drawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.132 -0400", hash_original_field = "692D46240E2C79BE643C2665EC4B2520", hash_generated_field = "3AE2C9F0AA2C9F1010956C331820EBD8")

    private InsetState mInsetState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.132 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.132 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.132 -0400", hash_original_method = "F48DBEE10522FF6B015323744245900F", hash_generated_method = "DDE232BCCCC6C70EAA4019D4AF233073")
      InsetDrawable() {
        this(null, null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.133 -0400", hash_original_method = "2918696D36F33B173FD0AA17323912B6", hash_generated_method = "F516FC568E70638930A753F88AED5958")
    public  InsetDrawable(Drawable drawable, int inset) {
        this(drawable, inset, inset, inset, inset);
        addTaint(drawable.getTaint());
        addTaint(inset);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.133 -0400", hash_original_method = "410D0B69961CD6B4D438C72969BE5ACA", hash_generated_method = "B12F7AAED084552C5CFCA183DE3BD2DB")
    public  InsetDrawable(Drawable drawable, int insetLeft, int insetTop,
                         int insetRight, int insetBottom) {
        this(null, null);
        mInsetState.mDrawable = drawable;
        mInsetState.mInsetLeft = insetLeft;
        mInsetState.mInsetTop = insetTop;
        mInsetState.mInsetRight = insetRight;
        mInsetState.mInsetBottom = insetBottom;
        {
            drawable.setCallback(this);
        } 
        
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.134 -0400", hash_original_method = "125D08C0C0AD10DE80234690E438546C", hash_generated_method = "D3D8132F753D7CBE37A3E6171E0E9075")
    private  InsetDrawable(InsetState state, Resources res) {
        mInsetState = new InsetState(state, this, res);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.135 -0400", hash_original_method = "308C72D2B889366D58587F5D48DD90DC", hash_generated_method = "64A3C077FBE3BDBD3187A0A000483EC3")
    @Override
    public void inflate(Resources r, XmlPullParser parser,
                                  AttributeSet attrs) throws XmlPullParserException, IOException {
        int type;
        TypedArray a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.InsetDrawable);
        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.InsetDrawable_visible);
        int drawableRes = a.getResourceId(com.android.internal.R.styleable.
                                    InsetDrawable_drawable, 0);
        int inLeft = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetLeft, 0);
        int inTop = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetTop, 0);
        int inRight = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetRight, 0);
        int inBottom = a.getDimensionPixelOffset(com.android.internal.R.styleable.
                                    InsetDrawable_insetBottom, 0);
        a.recycle();
        Drawable dr;
        {
            dr = r.getDrawable(drawableRes);
        } 
        {
            {
                boolean var6B5B5852701B8FCC2CE942637EBFE70C_513373144 = ((type=parser.next()) == XmlPullParser.TEXT);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <inset> tag requires a 'drawable' attribute or "
                        + "child tag defining a drawable");
            } 
            dr = Drawable.createFromXmlInner(r, parser, attrs);
        } 
        mInsetState.mDrawable = dr;
        mInsetState.mInsetLeft = inLeft;
        mInsetState.mInsetRight = inRight;
        mInsetState.mInsetTop = inTop;
        mInsetState.mInsetBottom = inBottom;
        {
            dr.setCallback(this);
        } 
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.136 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "8ECAF0D2D820C2FF9A9BDD02B639272A")
    public void invalidateDrawable(Drawable who) {
        final Callback callback = getCallback();
        {
            callback.invalidateDrawable(this);
        } 
        addTaint(who.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.136 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "261415614362F98B81BBEF59F2B1EFAD")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        final Callback callback = getCallback();
        {
            callback.scheduleDrawable(this, what, when);
        } 
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        addTaint(when);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.137 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "A952BE855FAD5CA31947C201D24F3FD9")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        final Callback callback = getCallback();
        {
            callback.unscheduleDrawable(this, what);
        } 
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.137 -0400", hash_original_method = "5D957288FBCBF53EE4FDA5CCA4D587F6", hash_generated_method = "DDC1BB677D2FDD30A29668EC6FA6B286")
    @Override
    public void draw(Canvas canvas) {
        mInsetState.mDrawable.draw(canvas);
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.137 -0400", hash_original_method = "5E6B5E9F59EDAB724B1161E1868DCBF2", hash_generated_method = "2D5C95A3C10603F3EC343DBDAE2139C5")
    @Override
    public int getChangingConfigurations() {
        int var61EF387ADAB9AB2D890E9E42218FD44A_1528412062 = (super.getChangingConfigurations()
                | mInsetState.mChangingConfigurations
                | mInsetState.mDrawable.getChangingConfigurations());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174630162 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174630162;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.138 -0400", hash_original_method = "453C0F994CC6F9573C64E5784E899FE5", hash_generated_method = "74E9C1774D93F9665DA167B47D3CB548")
    @Override
    public boolean getPadding(Rect padding) {
        boolean pad = mInsetState.mDrawable.getPadding(padding);
        padding.left += mInsetState.mInsetLeft;
        padding.right += mInsetState.mInsetRight;
        padding.top += mInsetState.mInsetTop;
        padding.bottom += mInsetState.mInsetBottom;
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1624982593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1624982593;
        
        
        
        
        
        
        
                    
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.138 -0400", hash_original_method = "EFF30D1C1A84058D8C292EB91F9472BE", hash_generated_method = "9D3C7F62CF34D0D044C1A2DA4577F6E6")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        mInsetState.mDrawable.setVisible(visible, restart);
        boolean var9D015C67047440F1849257F892B1DD1F_1242637250 = (super.setVisible(visible, restart));
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068693698 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068693698;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.139 -0400", hash_original_method = "B23A5809007626F95D6E0E75FACEBCF9", hash_generated_method = "2DB5D0F9927235609F5B5403BE4C0B30")
    @Override
    public void setAlpha(int alpha) {
        mInsetState.mDrawable.setAlpha(alpha);
        addTaint(alpha);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.139 -0400", hash_original_method = "06DFACBA6F5F88BE2848B90C2DE93101", hash_generated_method = "15B428D72E537C686D0BB3487E0C3605")
    @Override
    public void setColorFilter(ColorFilter cf) {
        mInsetState.mDrawable.setColorFilter(cf);
        addTaint(cf.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.139 -0400", hash_original_method = "84C32146675D5EBE47A9CF2427DBDE28", hash_generated_method = "43D38577EE02345D2D4D6A801F2A0A34")
    @Override
    public int getOpacity() {
        int varBEAEEE19271DBC4B9E294A9607E28C8B_1646488749 = (mInsetState.mDrawable.getOpacity());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49323991 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49323991;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.140 -0400", hash_original_method = "043A29D2ADB29827582E75471CD5479B", hash_generated_method = "0EDE69923E0A0A648952312E6934A638")
    @Override
    public boolean isStateful() {
        boolean varBA951C8D6B94B7E63AFFEFE558352D27_1079225806 = (mInsetState.mDrawable.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1723637575 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1723637575;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.140 -0400", hash_original_method = "246AAD5F68D871EA63688A0B06577CD4", hash_generated_method = "1F53314E1F9388764D0B823411AAF193")
    @Override
    protected boolean onStateChange(int[] state) {
        
        boolean changed = mInsetState.mDrawable.setState(state);
        onBoundsChange(getBounds());
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123561567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123561567;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.141 -0400", hash_original_method = "95EBA24DAC30ACDEC92CAFB7918B63D7", hash_generated_method = "D8864A9B00166B2AC49155695B4313B7")
    @Override
    protected void onBoundsChange(Rect bounds) {
        
        final Rect r = mTmpRect;
        r.set(bounds);
        r.left += mInsetState.mInsetLeft;
        r.top += mInsetState.mInsetTop;
        r.right -= mInsetState.mInsetRight;
        r.bottom -= mInsetState.mInsetBottom;
        mInsetState.mDrawable.setBounds(r.left, r.top, r.right, r.bottom);
        addTaint(bounds.getTaint());
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.141 -0400", hash_original_method = "AB4853FCC2E61C4308CEBFB5AE69B700", hash_generated_method = "EF9EAAE681DDEE8851FE607582F1B01F")
    @Override
    public int getIntrinsicWidth() {
        int varD77C9A288011CB8161A5891EAD9C1592_719764138 = (mInsetState.mDrawable.getIntrinsicWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106808998 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106808998;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.141 -0400", hash_original_method = "29FF5B29153AE16681DB19A374B63115", hash_generated_method = "B25BEB92B4727D929F68ADF27A618124")
    @Override
    public int getIntrinsicHeight() {
        int var5F2B6F0755F35B09C0CED510B2920689_533901692 = (mInsetState.mDrawable.getIntrinsicHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925243129 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925243129;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.142 -0400", hash_original_method = "1E9E2DEF1AEF301447A2F1B1CB9B55FF", hash_generated_method = "1B2927499B3530F885C368B04A23F56A")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_605555163 = null; 
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_671936868 = null; 
        {
            boolean varDF5C3001CFA292CC1683AFE8A4C4D7A6_837688037 = (mInsetState.canConstantState());
            {
                mInsetState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_605555163 = mInsetState;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_671936868 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_1909217302; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1909217302 = varB4EAC82CA7396A68D541C85D26508E83_605555163;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1909217302 = varB4EAC82CA7396A68D541C85D26508E83_671936868;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1909217302.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1909217302;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.143 -0400", hash_original_method = "22F293566220E6F3A8D3A4AE196709E5", hash_generated_method = "E75BC67D7C0C0D746B9571E53522B5DB")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_56973901 = null; 
        {
            boolean varC94B19053599294E7944C8C841976773_344228711 = (!mMutated && super.mutate() == this);
            {
                mInsetState.mDrawable.mutate();
                mMutated = true;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_56973901 = this;
        varB4EAC82CA7396A68D541C85D26508E83_56973901.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_56973901;
        
        
            
            
        
        
    }

    
    final static class InsetState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.143 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "38BA53DD394F85639C99ED8E666FF8FB")

        Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.143 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.143 -0400", hash_original_field = "0661D6C227585E45459B91C5D242ACDF", hash_generated_field = "E2BE4EAC7479E12B8AD15F8A1DC878B0")

        int mInsetLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.143 -0400", hash_original_field = "7C1DAF4ABF7868C1680EB9D50A37BCF1", hash_generated_field = "BDC766ACBEF4E33A22B4884B070885A7")

        int mInsetTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.143 -0400", hash_original_field = "2A242A7F704CF1F009B3DCF034A62B32", hash_generated_field = "858AD29F4440BFB10D0903CBBA92AF5F")

        int mInsetRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.143 -0400", hash_original_field = "1BF559D66726A6CAAC1A1E589C5D2017", hash_generated_field = "637B8F5F49094B17B0B21610CF248426")

        int mInsetBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.143 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "04605894B57F7B3414AF620BF4AC040E")

        boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.143 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "09212A3A30B7E6D48DEECC4F4639CCBC")

        boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.144 -0400", hash_original_method = "758BE6D06942564382533B70A9D03639", hash_generated_method = "2C50C7EFE727D0458A162A0FD19AAFDA")
          InsetState(InsetState orig, InsetDrawable owner, Resources res) {
            {
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable(res);
                } 
                {
                    mDrawable = orig.mDrawable.getConstantState().newDrawable();
                } 
                mDrawable.setCallback(owner);
                mInsetLeft = orig.mInsetLeft;
                mInsetTop = orig.mInsetTop;
                mInsetRight = orig.mInsetRight;
                mInsetBottom = orig.mInsetBottom;
                mCheckedConstantState = mCanConstantState = true;
            } 
            addTaint(owner.getTaint());
            
            
                
                    
                
                    
                
                
                
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.146 -0400", hash_original_method = "6B31FDACEACBBE413B6F897E56BE7FF9", hash_generated_method = "A33307DDEDDA53E81195B97ECC8AE66D")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_302499184 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_302499184 = new InsetDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_302499184.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_302499184;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.147 -0400", hash_original_method = "51EF496D1F925226C92A50925EFC08B6", hash_generated_method = "9FCE2209EC6515F98754887904608E19")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_602635686 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_602635686 = new InsetDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_602635686.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_602635686;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.148 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "F393AEF13D954070F0DA3B2A49E9BDD5")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206090117 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206090117;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.149 -0400", hash_original_method = "8D2A3A495FE794F654E28C73CF35A2A1", hash_generated_method = "BA052AF9DC8BFA11F8CE3C074AC1DAD9")
         boolean canConstantState() {
            {
                mCanConstantState = mDrawable.getConstantState() != null;
                mCheckedConstantState = true;
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1840059873 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1840059873;
            
            
                
                
            
            
        }

        
    }


    
}

