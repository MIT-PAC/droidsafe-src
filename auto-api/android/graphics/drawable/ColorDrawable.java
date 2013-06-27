package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.*;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

public class ColorDrawable extends Drawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.603 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "FD7347C3EC0F5B546B9EA73CCF0BC637")

    private ColorState mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.603 -0400", hash_original_field = "1F593C5E1FA9C53F92379484654564D2", hash_generated_field = "04B4E10AE3E38C24827628B090CB2FA5")

    private Paint mPaint = new Paint();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.604 -0400", hash_original_method = "54D21D729D42DC46694E67B89A565C46", hash_generated_method = "CE3A2ECE3ABD8585C34F7B80A3F3230E")
    public  ColorDrawable() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.604 -0400", hash_original_method = "2F37015D01FE06195FB00430A764BE1B", hash_generated_method = "44F4EA560FA044CAAAEA8DAA41878920")
    public  ColorDrawable(int color) {
        this(null);
        setColor(color);
        addTaint(color);
        // ---------- Original Method ----------
        //setColor(color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.605 -0400", hash_original_method = "7CD96EE67F31C94A04E847450668AE59", hash_generated_method = "792693C8A6C0FEC0E18C0A8180700E05")
    private  ColorDrawable(ColorState state) {
        mState = new ColorState(state);
        // ---------- Original Method ----------
        //mState = new ColorState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.605 -0400", hash_original_method = "CCB9F44E02BA506AC13DF4A6CD3FA45F", hash_generated_method = "6F814AF8B243FCABB9C493D660E1136D")
    @Override
    public int getChangingConfigurations() {
        int var30AA64123BE85DE614C625863A9143B9_1105529336 = (super.getChangingConfigurations() | mState.mChangingConfigurations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652557393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652557393;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations() | mState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.692 -0400", hash_original_method = "55968084A6009D3A7FE038F60520CF52", hash_generated_method = "6D86DF3FBB8B411B0928CA9DCB7A5969")
    @Override
    public void draw(Canvas canvas) {
        {
            mPaint.setColor(mState.mUseColor);
            canvas.drawRect(getBounds(), mPaint);
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //if ((mState.mUseColor >>> 24) != 0) {
            //mPaint.setColor(mState.mUseColor);
            //canvas.drawRect(getBounds(), mPaint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.693 -0400", hash_original_method = "12CB188AAA441342DA340C647E5F4CB8", hash_generated_method = "1A7FD60E4DD93D8C47C28362F24F1823")
    public int getColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643895172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643895172;
        // ---------- Original Method ----------
        //return mState.mUseColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.694 -0400", hash_original_method = "BF4E5D15208BCF2CD8D02BB100F40081", hash_generated_method = "039A10C3B8736F98303128795A3EDDD3")
    public void setColor(int color) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.708 -0400", hash_original_method = "5CD88AD7EDD59028127023DB7F8765AB", hash_generated_method = "1D3B4BD6B312B374F38FC07EBBEA085A")
    public int getAlpha() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175089794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175089794;
        // ---------- Original Method ----------
        //return mState.mUseColor >>> 24;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.709 -0400", hash_original_method = "459E9D088A35A829F6316FAAD661A311", hash_generated_method = "F3D30227F2B7A244C831DA215CDBD1A5")
    public void setAlpha(int alpha) {
        alpha += alpha >> 7;
        int baseAlpha;
        baseAlpha = mState.mBaseColor >>> 24;
        int useAlpha;
        useAlpha = baseAlpha * alpha >> 8;
        int oldUseColor;
        oldUseColor = mState.mUseColor;
        mState.mUseColor = (mState.mBaseColor << 8 >>> 8) | (useAlpha << 24);
        {
            invalidateSelf();
        } //End block
        addTaint(alpha);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.709 -0400", hash_original_method = "A617079D3CF57FB47B0EF9E1F05040EF", hash_generated_method = "607C53DAEBDA2ED67847FBFFF6FC8251")
    public void setColorFilter(ColorFilter colorFilter) {
        addTaint(colorFilter.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.732 -0400", hash_original_method = "B5DEC9C614B60B544E3B9333F2490C35", hash_generated_method = "41BC7FA0653AD49D6F6FD7B141841A0A")
    public int getOpacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209883800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209883800;
        // ---------- Original Method ----------
        //switch (mState.mUseColor >>> 24) {
            //case 255:
                //return PixelFormat.OPAQUE;
            //case 0:
                //return PixelFormat.TRANSPARENT;
        //}
        //return PixelFormat.TRANSLUCENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.734 -0400", hash_original_method = "9E06540C925D15124E32C083B6C47AE0", hash_generated_method = "5282784D8EFAAC808824F127E5688538")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ColorDrawable);
        int color;
        color = mState.mBaseColor;
        color = a.getColor(com.android.internal.R.styleable.ColorDrawable_color, color);
        mState.mBaseColor = mState.mUseColor = color;
        a.recycle();
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //super.inflate(r, parser, attrs);
        //TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ColorDrawable);
        //int color = mState.mBaseColor;
        //color = a.getColor(com.android.internal.R.styleable.ColorDrawable_color, color);
        //mState.mBaseColor = mState.mUseColor = color;
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.747 -0400", hash_original_method = "4A867A0EE58AB54D1A1755C00D03A40D", hash_generated_method = "B8689B597E46BB013052D352E18A7688")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1732039774 = null; //Variable for return #1
        mState.mChangingConfigurations = getChangingConfigurations();
        varB4EAC82CA7396A68D541C85D26508E83_1732039774 = mState;
        varB4EAC82CA7396A68D541C85D26508E83_1732039774.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1732039774;
        // ---------- Original Method ----------
        //mState.mChangingConfigurations = getChangingConfigurations();
        //return mState;
    }

    
    final static class ColorState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.747 -0400", hash_original_field = "F9D7A8052A7F7429695D61773717DA07", hash_generated_field = "5AE93BCE3A5CA0AC335BC45A61DD8BC4")

        int mBaseColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.747 -0400", hash_original_field = "4783591E1058BDCE66FD9A2A1B4FDEE9", hash_generated_field = "FE9A913640A2B3D963243CB0B70E7356")

        int mUseColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.747 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.748 -0400", hash_original_method = "0E70F7D5221A41101F9B0C34DE630337", hash_generated_method = "EBF9FF5F53D81B7225666F8A85CC88A2")
          ColorState(ColorState state) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.749 -0400", hash_original_method = "92EB93C0950DAF4E6DCB00F8ABBC1496", hash_generated_method = "F5A6F1BFFD68589D89AF357A5DD694FD")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_171069320 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_171069320 = new ColorDrawable(this);
            varB4EAC82CA7396A68D541C85D26508E83_171069320.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_171069320;
            // ---------- Original Method ----------
            //return new ColorDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.755 -0400", hash_original_method = "03B9F081DCE7F9DB71B8311343C06715", hash_generated_method = "2F145AAB42DC72DA286D0B191AF08001")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_617389825 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_617389825 = new ColorDrawable(this);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_617389825.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_617389825;
            // ---------- Original Method ----------
            //return new ColorDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.756 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "5AF4002FB2DC19FA6D564C8D6E34C4E1")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438679476 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438679476;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
}

