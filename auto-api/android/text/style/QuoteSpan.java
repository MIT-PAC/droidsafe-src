package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Paint;
import android.graphics.Canvas;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.TextUtils;

public class QuoteSpan implements LeadingMarginSpan, ParcelableSpan {
    private static final int STRIPE_WIDTH = 2;
    private static final int GAP_WIDTH = 2;
    private final int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.308 -0400", hash_original_method = "7152FED56017453956A1C017DE8477BE", hash_generated_method = "4A992F5B92FD70558262BA5EDD573B43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public QuoteSpan() {
        super();
        mColor = 0xff0000ff;
        // ---------- Original Method ----------
        //mColor = 0xff0000ff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.308 -0400", hash_original_method = "4E894B64A8966BC763843058D0706996", hash_generated_method = "6E8185A5EC65F9BE04951A42F8D619A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public QuoteSpan(int color) {
        super();
        dsTaint.addTaint(color);
        // ---------- Original Method ----------
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.308 -0400", hash_original_method = "4AD2E1D19CE8BCCBC25D1F8A03F5DD71", hash_generated_method = "645EB9FAE1C1D51B60FB7CF70B67F9F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public QuoteSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.308 -0400", hash_original_method = "91516A2AC14E144F9D08D31960E0CDBA", hash_generated_method = "86F2536219E9CA864246A240E13CA22B")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.QUOTE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.308 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.308 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "8814D1F6A449877E0272DD2313D0AEC6")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mColor);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.308 -0400", hash_original_method = "43BEB8B89AD2425C976FAD6ED1828A38", hash_generated_method = "AA5DB43328696E5FB66598C97CBA3DD8")
    @DSModeled(DSC.SAFE)
    public int getColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.308 -0400", hash_original_method = "0C0816FE65D1CAB7203AAB3FE043AC6B", hash_generated_method = "77C0C9F16F719BD7E5ECE8DEDD377F2E")
    @DSModeled(DSC.SAFE)
    public int getLeadingMargin(boolean first) {
        dsTaint.addTaint(first);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return STRIPE_WIDTH + GAP_WIDTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.308 -0400", hash_original_method = "ED0B802F772E913D8F0EA056A6340C94", hash_generated_method = "4FE6F4FD6902AEE5150C14E9192F4DE8")
    @DSModeled(DSC.SAFE)
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom,
                                  CharSequence text, int start, int end,
                                  boolean first, Layout layout) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(start);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(layout.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(baseline);
        dsTaint.addTaint(first);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        dsTaint.addTaint(top);
        Paint.Style style;
        style = p.getStyle();
        int color;
        color = p.getColor();
        p.setStyle(Paint.Style.FILL);
        p.setColor(mColor);
        c.drawRect(x, top, x + dir * STRIPE_WIDTH, bottom, p);
        p.setStyle(style);
        p.setColor(color);
        // ---------- Original Method ----------
        //Paint.Style style = p.getStyle();
        //int color = p.getColor();
        //p.setStyle(Paint.Style.FILL);
        //p.setColor(mColor);
        //c.drawRect(x, top, x + dir * STRIPE_WIDTH, bottom, p);
        //p.setStyle(style);
        //p.setColor(color);
    }

    
}


