package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Spanned;
import android.text.TextUtils;

public class BulletSpan implements LeadingMarginSpan, ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.138 -0400", hash_original_field = "B765BF6214DEB59F97DB91EE90AF17D2", hash_generated_field = "CF0863D60EF1715AF0282F6FEF7CAEA5")

    private int mGapWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.138 -0400", hash_original_field = "1E7D70EDDA276397610E1F5A2D8E6BFB", hash_generated_field = "B31953859FB6A7EDF8C33055E9345363")

    private boolean mWantColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.138 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.139 -0400", hash_original_method = "F333B1FCD15ED8238A329F687C815603", hash_generated_method = "20A8517CDEC0FF183CEEC5E7CE07B6B1")
    public  BulletSpan() {
        mGapWidth = STANDARD_GAP_WIDTH;
        mWantColor = false;
        mColor = 0;
        // ---------- Original Method ----------
        //mGapWidth = STANDARD_GAP_WIDTH;
        //mWantColor = false;
        //mColor = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.139 -0400", hash_original_method = "5B0962B90C33EFC1A7FAF035AC11CB4A", hash_generated_method = "4ACC823AF3A5799EE596B467B6C6CBB2")
    public  BulletSpan(int gapWidth) {
        mGapWidth = gapWidth;
        mWantColor = false;
        mColor = 0;
        // ---------- Original Method ----------
        //mGapWidth = gapWidth;
        //mWantColor = false;
        //mColor = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.140 -0400", hash_original_method = "49E46CCFEED0864DEF606DCF0C6D9BFC", hash_generated_method = "8B91A604CD1AE956B220887A498E6E72")
    public  BulletSpan(int gapWidth, int color) {
        mGapWidth = gapWidth;
        mWantColor = true;
        mColor = color;
        // ---------- Original Method ----------
        //mGapWidth = gapWidth;
        //mWantColor = true;
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.140 -0400", hash_original_method = "2310754227525D5B1AC7AB495FD8FC46", hash_generated_method = "514629213F2127D7DAD5A8A732F42B78")
    public  BulletSpan(Parcel src) {
        mGapWidth = src.readInt();
        mWantColor = src.readInt() != 0;
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mGapWidth = src.readInt();
        //mWantColor = src.readInt() != 0;
        //mColor = src.readInt();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.141 -0400", hash_original_method = "487ABDFFC7C87077FB337ABC7D22F575", hash_generated_method = "5C084C9A5C4469C5E39311B4A54CBEBA")
    public int getSpanTypeId() {
        int var6AB8F49C46B377A2606471607E7ED458_878187425 = (TextUtils.BULLET_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103231317 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103231317;
        // ---------- Original Method ----------
        //return TextUtils.BULLET_SPAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.141 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6E6F7041041095079D18B2CC95DDC668")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1560468743 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682246741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682246741;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.141 -0400", hash_original_method = "D1CA1ADAD215DD7AD321DC70F751BAEF", hash_generated_method = "6FA2F406DF5220CDC31A040907A762E5")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mGapWidth);
        dest.writeInt(mWantColor ? 1 : 0);
        dest.writeInt(mColor);
        // ---------- Original Method ----------
        //dest.writeInt(mGapWidth);
        //dest.writeInt(mWantColor ? 1 : 0);
        //dest.writeInt(mColor);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.142 -0400", hash_original_method = "77C9B4F0913BD5D8F7E0CF3C61E7D063", hash_generated_method = "D851C68CF77EF9E96FCE650BC348B5B7")
    public int getLeadingMargin(boolean first) {
        addTaint(first);
        int var56C1E329B9F661A38D634CA2962DC7B4_467164054 = (2 * BULLET_RADIUS + mGapWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022421517 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022421517;
        // ---------- Original Method ----------
        //return 2 * BULLET_RADIUS + mGapWidth;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.143 -0400", hash_original_method = "BA5CC5CF550A22429CB3793943786FE7", hash_generated_method = "C4FEE5F3203BDCECE94F45D8901C4AAE")
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom,
                                  CharSequence text, int start, int end,
                                  boolean first, Layout l) {
        addTaint(l.getTaint());
        addTaint(first);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        addTaint(bottom);
        addTaint(baseline);
        addTaint(top);
        addTaint(dir);
        addTaint(x);
        addTaint(p.getTaint());
        addTaint(c.getTaint());
    if(((Spanned) text).getSpanStart(this) == start)        
        {
            Paint.Style style = p.getStyle();
            int oldcolor = 0;
    if(mWantColor)            
            {
                oldcolor = p.getColor();
                p.setColor(mColor);
            } //End block
            p.setStyle(Paint.Style.FILL);
    if(c.isHardwareAccelerated())            
            {
    if(sBulletPath == null)                
                {
                    sBulletPath = new Path();
                    sBulletPath.addCircle(0.0f, 0.0f, 1.2f * BULLET_RADIUS, Direction.CW);
                } //End block
                c.save();
                c.translate(x + dir * BULLET_RADIUS, (top + bottom) / 2.0f);
                c.drawPath(sBulletPath, p);
                c.restore();
            } //End block
            else
            {
                c.drawCircle(x + dir * BULLET_RADIUS, (top + bottom) / 2.0f, BULLET_RADIUS, p);
            } //End block
    if(mWantColor)            
            {
                p.setColor(oldcolor);
            } //End block
            p.setStyle(style);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.144 -0400", hash_original_field = "75A57BF3BC1DA53B4112BF7B6639CFC6", hash_generated_field = "AE2FB42565AB6A2C235F3647E11BA323")

    private static final int BULLET_RADIUS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.144 -0400", hash_original_field = "B40694C5083969AA72D7A335AC7B5381", hash_generated_field = "F4B31C45F9E1D3EC191C9041DEBF8AA4")

    private static Path sBulletPath = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.144 -0400", hash_original_field = "118332E46CF1AB3A4E9A28425FC06241", hash_generated_field = "9CDB5553168DBC9FCCC1E43A7348D62B")

    public static final int STANDARD_GAP_WIDTH = 2;
}

