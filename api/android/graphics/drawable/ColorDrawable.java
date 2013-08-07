package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.util.AttributeSet;





public class ColorDrawable extends Drawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.512 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "FD7347C3EC0F5B546B9EA73CCF0BC637")

    private ColorState mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.512 -0400", hash_original_field = "1F593C5E1FA9C53F92379484654564D2", hash_generated_field = "90B0608AB53F75A0AC388611FFB8AF86")

    private final Paint mPaint = new Paint();
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.512 -0400", hash_original_method = "54D21D729D42DC46694E67B89A565C46", hash_generated_method = "CE3A2ECE3ABD8585C34F7B80A3F3230E")
    public  ColorDrawable() {
        this(null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.512 -0400", hash_original_method = "2F37015D01FE06195FB00430A764BE1B", hash_generated_method = "472C4B9D696F34A3E1906624B0387238")
    public  ColorDrawable(int color) {
        this(null);
        addTaint(color);
        setColor(color);
        // ---------- Original Method ----------
        //setColor(color);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.513 -0400", hash_original_method = "7CD96EE67F31C94A04E847450668AE59", hash_generated_method = "792693C8A6C0FEC0E18C0A8180700E05")
    private  ColorDrawable(ColorState state) {
        mState = new ColorState(state);
        // ---------- Original Method ----------
        //mState = new ColorState(state);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.513 -0400", hash_original_method = "CCB9F44E02BA506AC13DF4A6CD3FA45F", hash_generated_method = "2C91BC293D5D17A6F4A554BA198A4804")
    @Override
    public int getChangingConfigurations() {
        int varA8C82B602AAC6FAEFF8C2D9CDCE4E8EA_2126990015 = (super.getChangingConfigurations() | mState.mChangingConfigurations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_258058366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_258058366;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations() | mState.mChangingConfigurations;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.514 -0400", hash_original_method = "55968084A6009D3A7FE038F60520CF52", hash_generated_method = "A69E03821D7ABBC0BA7311B64B2FC031")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        if((mState.mUseColor >>> 24) != 0)        
        {
            mPaint.setColor(mState.mUseColor);
            canvas.drawRect(getBounds(), mPaint);
        } //End block
        // ---------- Original Method ----------
        //if ((mState.mUseColor >>> 24) != 0) {
            //mPaint.setColor(mState.mUseColor);
            //canvas.drawRect(getBounds(), mPaint);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.514 -0400", hash_original_method = "12CB188AAA441342DA340C647E5F4CB8", hash_generated_method = "9BE47B751E9A17343683A095DAFC36BD")
    public int getColor() {
        int var04D41FDEDF15939E8CE4323AF0576B0B_1838273339 = (mState.mUseColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127369985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127369985;
        // ---------- Original Method ----------
        //return mState.mUseColor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.515 -0400", hash_original_method = "BF4E5D15208BCF2CD8D02BB100F40081", hash_generated_method = "5AF696FBDF35C99FD360BFD33E5FF701")
    public void setColor(int color) {
        if(mState.mBaseColor != color || mState.mUseColor != color)        
        {
            invalidateSelf();
            mState.mBaseColor = mState.mUseColor = color;
        } //End block
        // ---------- Original Method ----------
        //if (mState.mBaseColor != color || mState.mUseColor != color) {
            //invalidateSelf();
            //mState.mBaseColor = mState.mUseColor = color;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.516 -0400", hash_original_method = "5CD88AD7EDD59028127023DB7F8765AB", hash_generated_method = "717554763962AA8E80A4CF386C353752")
    public int getAlpha() {
        int varCCC2B71E02C5EB9BFB2D3C210D954BB8_188347213 = (mState.mUseColor >>> 24);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179153099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179153099;
        // ---------- Original Method ----------
        //return mState.mUseColor >>> 24;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.516 -0400", hash_original_method = "459E9D088A35A829F6316FAAD661A311", hash_generated_method = "0A4E461CC5854FB9B18BB688BEA5D0B6")
    public void setAlpha(int alpha) {
        addTaint(alpha);
        alpha += alpha >> 7;
        int baseAlpha = mState.mBaseColor >>> 24;
        int useAlpha = baseAlpha * alpha >> 8;
        int oldUseColor = mState.mUseColor;
        mState.mUseColor = (mState.mBaseColor << 8 >>> 8) | (useAlpha << 24);
        if(oldUseColor != mState.mUseColor)        
        {
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //alpha += alpha >> 7;
        //int baseAlpha = mState.mBaseColor >>> 24;
        //int useAlpha = baseAlpha * alpha >> 8;
        //int oldUseColor = mState.mUseColor;
        //mState.mUseColor = (mState.mBaseColor << 8 >>> 8) | (useAlpha << 24);
        //if (oldUseColor != mState.mUseColor) {
            //invalidateSelf();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.517 -0400", hash_original_method = "A617079D3CF57FB47B0EF9E1F05040EF", hash_generated_method = "607C53DAEBDA2ED67847FBFFF6FC8251")
    public void setColorFilter(ColorFilter colorFilter) {
        addTaint(colorFilter.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.518 -0400", hash_original_method = "B5DEC9C614B60B544E3B9333F2490C35", hash_generated_method = "286419D51263B12D560D82804E426879")
    public int getOpacity() {
switch(mState.mUseColor >>> 24){
        case 255:
        int var159D51265084B78CCBC493D119AF4EAE_1070621115 = (PixelFormat.OPAQUE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130462156 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130462156;
        case 0:
        int varBD6099BC0B51C182C215E6BE157DABC3_417933253 = (PixelFormat.TRANSPARENT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429979269 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429979269;
}        int var26C79996E92FCFBDC98A49C80BC91AD0_1173504863 = (PixelFormat.TRANSLUCENT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052825278 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052825278;
        // ---------- Original Method ----------
        //switch (mState.mUseColor >>> 24) {
            //case 255:
                //return PixelFormat.OPAQUE;
            //case 0:
                //return PixelFormat.TRANSPARENT;
        //}
        //return PixelFormat.TRANSLUCENT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.518 -0400", hash_original_method = "9E06540C925D15124E32C083B6C47AE0", hash_generated_method = "26A5763142E43AE386D98CC1D2863E66")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        super.inflate(r, parser, attrs);
        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ColorDrawable);
        int color = mState.mBaseColor;
        color = a.getColor(com.android.internal.R.styleable.ColorDrawable_color, color);
        mState.mBaseColor = mState.mUseColor = color;
        a.recycle();
        // ---------- Original Method ----------
        //super.inflate(r, parser, attrs);
        //TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ColorDrawable);
        //int color = mState.mBaseColor;
        //color = a.getColor(com.android.internal.R.styleable.ColorDrawable_color, color);
        //mState.mBaseColor = mState.mUseColor = color;
        //a.recycle();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.519 -0400", hash_original_method = "4A867A0EE58AB54D1A1755C00D03A40D", hash_generated_method = "6E76FB183E1101500D60F27E33ACE7CA")
    @Override
    public ConstantState getConstantState() {
        mState.mChangingConfigurations = getChangingConfigurations();
ConstantState var8B975C85F13BECB9FD4D21A5F3C8A56D_1563102392 =         mState;
        var8B975C85F13BECB9FD4D21A5F3C8A56D_1563102392.addTaint(taint);
        return var8B975C85F13BECB9FD4D21A5F3C8A56D_1563102392;
        // ---------- Original Method ----------
        //mState.mChangingConfigurations = getChangingConfigurations();
        //return mState;
    }

    
    final static class ColorState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.520 -0400", hash_original_field = "F9D7A8052A7F7429695D61773717DA07", hash_generated_field = "5AE93BCE3A5CA0AC335BC45A61DD8BC4")

        int mBaseColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.520 -0400", hash_original_field = "4783591E1058BDCE66FD9A2A1B4FDEE9", hash_generated_field = "FE9A913640A2B3D963243CB0B70E7356")

        int mUseColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.520 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.520 -0400", hash_original_method = "0E70F7D5221A41101F9B0C34DE630337", hash_generated_method = "9BFE0037D03507B8DF35E726AB8D93B1")
          ColorState(ColorState state) {
            if(state != null)            
            {
                mBaseColor = state.mBaseColor;
                mUseColor = state.mUseColor;
            } //End block
            // ---------- Original Method ----------
            //if (state != null) {
                //mBaseColor = state.mBaseColor;
                //mUseColor = state.mUseColor;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.521 -0400", hash_original_method = "92EB93C0950DAF4E6DCB00F8ABBC1496", hash_generated_method = "5DE79874FDEB102A15092D93CA03F189")
        @Override
        public Drawable newDrawable() {
Drawable var5002F1B2961599D4FF2B1F6F731A3C2C_1624887878 =             new ColorDrawable(this);
            var5002F1B2961599D4FF2B1F6F731A3C2C_1624887878.addTaint(taint);
            return var5002F1B2961599D4FF2B1F6F731A3C2C_1624887878;
            // ---------- Original Method ----------
            //return new ColorDrawable(this);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.521 -0400", hash_original_method = "03B9F081DCE7F9DB71B8311343C06715", hash_generated_method = "E3F150557626A71D40396BF86CC42F85")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var5002F1B2961599D4FF2B1F6F731A3C2C_768221823 =             new ColorDrawable(this);
            var5002F1B2961599D4FF2B1F6F731A3C2C_768221823.addTaint(taint);
            return var5002F1B2961599D4FF2B1F6F731A3C2C_768221823;
            // ---------- Original Method ----------
            //return new ColorDrawable(this);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.522 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "9F16E5D5524CB21607EC3B8979F867D5")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1453775284 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186295086 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186295086;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
}

