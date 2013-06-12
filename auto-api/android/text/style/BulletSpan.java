package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final int mGapWidth;
    private final boolean mWantColor;
    private final int mColor;
    private static final int BULLET_RADIUS = 3;
    private static Path sBulletPath = null;
    public static final int STANDARD_GAP_WIDTH = 2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.299 -0400", hash_original_method = "F333B1FCD15ED8238A329F687C815603", hash_generated_method = "3B2F7CAAE5FA9DF7A316FECC005070E1")
    @DSModeled(DSC.SAFE)
    public BulletSpan() {
        mGapWidth = STANDARD_GAP_WIDTH;
        mWantColor = false;
        mColor = 0;
        // ---------- Original Method ----------
        //mGapWidth = STANDARD_GAP_WIDTH;
        //mWantColor = false;
        //mColor = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.299 -0400", hash_original_method = "5B0962B90C33EFC1A7FAF035AC11CB4A", hash_generated_method = "25E66A5F69A6648A3A494B6E10C835C5")
    @DSModeled(DSC.SAFE)
    public BulletSpan(int gapWidth) {
        dsTaint.addTaint(gapWidth);
        mWantColor = false;
        mColor = 0;
        mGapWidth = gapWidth;
        // ---------- Original Method ----------
        //mGapWidth = gapWidth;
        //mWantColor = false;
        //mColor = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.299 -0400", hash_original_method = "49E46CCFEED0864DEF606DCF0C6D9BFC", hash_generated_method = "D86C8DAF84AA53C862B31D107CFFD3E0")
    @DSModeled(DSC.SAFE)
    public BulletSpan(int gapWidth, int color) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(gapWidth);
        mWantColor = true;
        mGapWidth = gapWidth;
        mColor = color;
        // ---------- Original Method ----------
        //mGapWidth = gapWidth;
        //mWantColor = true;
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.299 -0400", hash_original_method = "2310754227525D5B1AC7AB495FD8FC46", hash_generated_method = "13ADA3EDCB057D44DAE3D81E26AB173D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BulletSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mGapWidth = src.readInt();
        mWantColor = src.readInt() != 0;
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mGapWidth = src.readInt();
        //mWantColor = src.readInt() != 0;
        //mColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.299 -0400", hash_original_method = "487ABDFFC7C87077FB337ABC7D22F575", hash_generated_method = "3D92DA39AFD9FF8786E4B63AEF7D2329")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.BULLET_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.299 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.299 -0400", hash_original_method = "D1CA1ADAD215DD7AD321DC70F751BAEF", hash_generated_method = "19A136AF893E9ADAB8DE005BF8F149A8")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mGapWidth);
        dest.writeInt(mWantColor ? 1 : 0);
        dest.writeInt(mColor);
        // ---------- Original Method ----------
        //dest.writeInt(mGapWidth);
        //dest.writeInt(mWantColor ? 1 : 0);
        //dest.writeInt(mColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.299 -0400", hash_original_method = "77C9B4F0913BD5D8F7E0CF3C61E7D063", hash_generated_method = "E4156631ABC0EE46F950D71ADFD70FD3")
    @DSModeled(DSC.SAFE)
    public int getLeadingMargin(boolean first) {
        dsTaint.addTaint(first);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 2 * BULLET_RADIUS + mGapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.300 -0400", hash_original_method = "BA5CC5CF550A22429CB3793943786FE7", hash_generated_method = "55874BF8EDC9A6240BA36CA2D4156AAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom,
                                  CharSequence text, int start, int end,
                                  boolean first, Layout l) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(start);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(baseline);
        dsTaint.addTaint(first);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        dsTaint.addTaint(top);
        {
            boolean var9C445D2A270FA828F0E7484B7E09E929_757720473 = (((Spanned) text).getSpanStart(this) == start);
            {
                Paint.Style style;
                style = p.getStyle();
                int oldcolor;
                oldcolor = 0;
                {
                    oldcolor = p.getColor();
                    p.setColor(mColor);
                } //End block
                p.setStyle(Paint.Style.FILL);
                {
                    boolean var51BCA5F22E99A00EFCAD3A10FC8AFDC7_935395578 = (c.isHardwareAccelerated());
                    {
                        {
                            sBulletPath = new Path();
                            sBulletPath.addCircle(0.0f, 0.0f, 1.2f * BULLET_RADIUS, Direction.CW);
                        } //End block
                        c.save();
                        c.translate(x + dir * BULLET_RADIUS, (top + bottom) / 2.0f);
                        c.drawPath(sBulletPath, p);
                        c.restore();
                    } //End block
                    {
                        c.drawCircle(x + dir * BULLET_RADIUS, (top + bottom) / 2.0f, BULLET_RADIUS, p);
                    } //End block
                } //End collapsed parenthetic
                {
                    p.setColor(oldcolor);
                } //End block
                p.setStyle(style);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


