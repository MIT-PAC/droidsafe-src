package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.*;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

public class ColorDrawable extends Drawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.718 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "FD7347C3EC0F5B546B9EA73CCF0BC637")

    private ColorState mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.718 -0400", hash_original_field = "1F593C5E1FA9C53F92379484654564D2", hash_generated_field = "90B0608AB53F75A0AC388611FFB8AF86")

    private final Paint mPaint = new Paint();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.718 -0400", hash_original_method = "54D21D729D42DC46694E67B89A565C46", hash_generated_method = "CE3A2ECE3ABD8585C34F7B80A3F3230E")
    public  ColorDrawable() {
        this(null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.719 -0400", hash_original_method = "2F37015D01FE06195FB00430A764BE1B", hash_generated_method = "44F4EA560FA044CAAAEA8DAA41878920")
    public  ColorDrawable(int color) {
        this(null);
        setColor(color);
        addTaint(color);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.719 -0400", hash_original_method = "7CD96EE67F31C94A04E847450668AE59", hash_generated_method = "792693C8A6C0FEC0E18C0A8180700E05")
    private  ColorDrawable(ColorState state) {
        mState = new ColorState(state);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.720 -0400", hash_original_method = "CCB9F44E02BA506AC13DF4A6CD3FA45F", hash_generated_method = "A1FFB4740C69DB29F82C112D7F272CCC")
    @Override
    public int getChangingConfigurations() {
        int var30AA64123BE85DE614C625863A9143B9_365619098 = (super.getChangingConfigurations() | mState.mChangingConfigurations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529310712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529310712;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.720 -0400", hash_original_method = "55968084A6009D3A7FE038F60520CF52", hash_generated_method = "6D86DF3FBB8B411B0928CA9DCB7A5969")
    @Override
    public void draw(Canvas canvas) {
        {
            mPaint.setColor(mState.mUseColor);
            canvas.drawRect(getBounds(), mPaint);
        } 
        addTaint(canvas.getTaint());
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.721 -0400", hash_original_method = "12CB188AAA441342DA340C647E5F4CB8", hash_generated_method = "BC1FE2B248D649E16D4E9E85BD0C8DC3")
    public int getColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33412012 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33412012;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.721 -0400", hash_original_method = "BF4E5D15208BCF2CD8D02BB100F40081", hash_generated_method = "039A10C3B8736F98303128795A3EDDD3")
    public void setColor(int color) {
        {
            invalidateSelf();
            mState.mBaseColor = mState.mUseColor = color;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.722 -0400", hash_original_method = "5CD88AD7EDD59028127023DB7F8765AB", hash_generated_method = "79B6A59DFC56FBF35DE6C58840F1546A")
    public int getAlpha() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543337096 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543337096;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.722 -0400", hash_original_method = "459E9D088A35A829F6316FAAD661A311", hash_generated_method = "BBD188E95D587FF20167EF4575B2BE97")
    public void setAlpha(int alpha) {
        alpha += alpha >> 7;
        int baseAlpha = mState.mBaseColor >>> 24;
        int useAlpha = baseAlpha * alpha >> 8;
        int oldUseColor = mState.mUseColor;
        mState.mUseColor = (mState.mBaseColor << 8 >>> 8) | (useAlpha << 24);
        {
            invalidateSelf();
        } 
        addTaint(alpha);
        
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.723 -0400", hash_original_method = "A617079D3CF57FB47B0EF9E1F05040EF", hash_generated_method = "607C53DAEBDA2ED67847FBFFF6FC8251")
    public void setColorFilter(ColorFilter colorFilter) {
        addTaint(colorFilter.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.724 -0400", hash_original_method = "B5DEC9C614B60B544E3B9333F2490C35", hash_generated_method = "5F902ADB8643ABEA99C19BB70B675660")
    public int getOpacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923479155 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923479155;
        
        
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.725 -0400", hash_original_method = "9E06540C925D15124E32C083B6C47AE0", hash_generated_method = "D0342F3EDBDB57296950F232B7982DDE")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);
        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ColorDrawable);
        int color = mState.mBaseColor;
        color = a.getColor(com.android.internal.R.styleable.ColorDrawable_color, color);
        mState.mBaseColor = mState.mUseColor = color;
        a.recycle();
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.726 -0400", hash_original_method = "4A867A0EE58AB54D1A1755C00D03A40D", hash_generated_method = "E39B1C3937A04901660FDFBFBE258CB7")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1249711572 = null; 
        mState.mChangingConfigurations = getChangingConfigurations();
        varB4EAC82CA7396A68D541C85D26508E83_1249711572 = mState;
        varB4EAC82CA7396A68D541C85D26508E83_1249711572.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1249711572;
        
        
        
    }

    
    final static class ColorState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.726 -0400", hash_original_field = "F9D7A8052A7F7429695D61773717DA07", hash_generated_field = "5AE93BCE3A5CA0AC335BC45A61DD8BC4")

        int mBaseColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.726 -0400", hash_original_field = "4783591E1058BDCE66FD9A2A1B4FDEE9", hash_generated_field = "FE9A913640A2B3D963243CB0B70E7356")

        int mUseColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.726 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.726 -0400", hash_original_method = "0E70F7D5221A41101F9B0C34DE630337", hash_generated_method = "EBF9FF5F53D81B7225666F8A85CC88A2")
          ColorState(ColorState state) {
            {
                mBaseColor = state.mBaseColor;
                mUseColor = state.mUseColor;
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.727 -0400", hash_original_method = "92EB93C0950DAF4E6DCB00F8ABBC1496", hash_generated_method = "931F8FE02801C1453647A5D7140D8737")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1944803609 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1944803609 = new ColorDrawable(this);
            varB4EAC82CA7396A68D541C85D26508E83_1944803609.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1944803609;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.727 -0400", hash_original_method = "03B9F081DCE7F9DB71B8311343C06715", hash_generated_method = "BFEE3BE88F73C12D8961C1578384A7D8")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1067213564 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1067213564 = new ColorDrawable(this);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1067213564.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1067213564;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.728 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "DBA60DB89FA86CD88C3C371C56ADB61C")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643336242 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643336242;
            
            
        }

        
    }


    
}

