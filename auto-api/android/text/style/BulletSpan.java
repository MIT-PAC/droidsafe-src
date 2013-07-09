package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.706 -0400", hash_original_field = "B765BF6214DEB59F97DB91EE90AF17D2", hash_generated_field = "CF0863D60EF1715AF0282F6FEF7CAEA5")

    private int mGapWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.706 -0400", hash_original_field = "1E7D70EDDA276397610E1F5A2D8E6BFB", hash_generated_field = "B31953859FB6A7EDF8C33055E9345363")

    private boolean mWantColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.706 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.706 -0400", hash_original_method = "F333B1FCD15ED8238A329F687C815603", hash_generated_method = "20A8517CDEC0FF183CEEC5E7CE07B6B1")
    public  BulletSpan() {
        mGapWidth = STANDARD_GAP_WIDTH;
        mWantColor = false;
        mColor = 0;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.707 -0400", hash_original_method = "5B0962B90C33EFC1A7FAF035AC11CB4A", hash_generated_method = "4ACC823AF3A5799EE596B467B6C6CBB2")
    public  BulletSpan(int gapWidth) {
        mGapWidth = gapWidth;
        mWantColor = false;
        mColor = 0;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.707 -0400", hash_original_method = "49E46CCFEED0864DEF606DCF0C6D9BFC", hash_generated_method = "8B91A604CD1AE956B220887A498E6E72")
    public  BulletSpan(int gapWidth, int color) {
        mGapWidth = gapWidth;
        mWantColor = true;
        mColor = color;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.708 -0400", hash_original_method = "2310754227525D5B1AC7AB495FD8FC46", hash_generated_method = "514629213F2127D7DAD5A8A732F42B78")
    public  BulletSpan(Parcel src) {
        mGapWidth = src.readInt();
        mWantColor = src.readInt() != 0;
        mColor = src.readInt();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.708 -0400", hash_original_method = "487ABDFFC7C87077FB337ABC7D22F575", hash_generated_method = "A24BFBB8A25B1F13CA75EB5C5FBBD4D8")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213519245 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213519245;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.709 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FFA472789CC617292D7B6410EEA61E00")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_453217591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_453217591;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.709 -0400", hash_original_method = "D1CA1ADAD215DD7AD321DC70F751BAEF", hash_generated_method = "CF7B0CF6206A97868C94BFDBF700FC7D")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mGapWidth);
        dest.writeInt(mWantColor ? 1 : 0);
        dest.writeInt(mColor);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.710 -0400", hash_original_method = "77C9B4F0913BD5D8F7E0CF3C61E7D063", hash_generated_method = "6E2F9C5CFC9A1E3C579AB345521A3538")
    public int getLeadingMargin(boolean first) {
        addTaint(first);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567450331 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567450331;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.711 -0400", hash_original_method = "BA5CC5CF550A22429CB3793943786FE7", hash_generated_method = "8C84D18DEC9B655D19188633D4D728BB")
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom,
                                  CharSequence text, int start, int end,
                                  boolean first, Layout l) {
        {
            boolean var9C445D2A270FA828F0E7484B7E09E929_923915697 = (((Spanned) text).getSpanStart(this) == start);
            {
                Paint.Style style = p.getStyle();
                int oldcolor = 0;
                {
                    oldcolor = p.getColor();
                    p.setColor(mColor);
                } 
                p.setStyle(Paint.Style.FILL);
                {
                    boolean var51BCA5F22E99A00EFCAD3A10FC8AFDC7_797440737 = (c.isHardwareAccelerated());
                    {
                        {
                            sBulletPath = new Path();
                            sBulletPath.addCircle(0.0f, 0.0f, 1.2f * BULLET_RADIUS, Direction.CW);
                        } 
                        c.save();
                        c.translate(x + dir * BULLET_RADIUS, (top + bottom) / 2.0f);
                        c.drawPath(sBulletPath, p);
                        c.restore();
                    } 
                    {
                        c.drawCircle(x + dir * BULLET_RADIUS, (top + bottom) / 2.0f, BULLET_RADIUS, p);
                    } 
                } 
                {
                    p.setColor(oldcolor);
                } 
                p.setStyle(style);
            } 
        } 
        addTaint(c.getTaint());
        addTaint(p.getTaint());
        addTaint(x);
        addTaint(dir);
        addTaint(top);
        addTaint(baseline);
        addTaint(bottom);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(first);
        addTaint(l.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.711 -0400", hash_original_field = "75A57BF3BC1DA53B4112BF7B6639CFC6", hash_generated_field = "AE2FB42565AB6A2C235F3647E11BA323")

    private static final int BULLET_RADIUS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.711 -0400", hash_original_field = "B40694C5083969AA72D7A335AC7B5381", hash_generated_field = "F4B31C45F9E1D3EC191C9041DEBF8AA4")

    private static Path sBulletPath = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.711 -0400", hash_original_field = "118332E46CF1AB3A4E9A28425FC06241", hash_generated_field = "9CDB5553168DBC9FCCC1E43A7348D62B")

    public static final int STANDARD_GAP_WIDTH = 2;
}

