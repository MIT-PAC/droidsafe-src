package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.TextUtils;

public class QuoteSpan implements LeadingMarginSpan, ParcelableSpan {
    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.900 -0400", hash_original_method = "7152FED56017453956A1C017DE8477BE", hash_generated_method = "B1FC0E64911AD70D2C36AA9A795566DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public QuoteSpan() {
        super();
        mColor = 0xff0000ff;
        // ---------- Original Method ----------
        //mColor = 0xff0000ff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.901 -0400", hash_original_method = "4E894B64A8966BC763843058D0706996", hash_generated_method = "B9D36DF1C290F72F3AA83FABF6D9D22C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public QuoteSpan(int color) {
        super();
        dsTaint.addTaint(color);
        // ---------- Original Method ----------
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.901 -0400", hash_original_method = "4AD2E1D19CE8BCCBC25D1F8A03F5DD71", hash_generated_method = "3AFE1D84FF2E370A9F88DDE9B635772C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public QuoteSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.901 -0400", hash_original_method = "91516A2AC14E144F9D08D31960E0CDBA", hash_generated_method = "486BBAF04B73C8F5277AD7EBCF935A39")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.QUOTE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.901 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.901 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "DAA3747B1D479B36DA20B141F586B8AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mColor);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.902 -0400", hash_original_method = "43BEB8B89AD2425C976FAD6ED1828A38", hash_generated_method = "3AD7F267254881933AD7E54505AC8E9F")
    @DSModeled(DSC.SAFE)
    public int getColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.902 -0400", hash_original_method = "0C0816FE65D1CAB7203AAB3FE043AC6B", hash_generated_method = "F2721079302B1F06F1E7592738B3896C")
    @DSModeled(DSC.SAFE)
    public int getLeadingMargin(boolean first) {
        dsTaint.addTaint(first);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return STRIPE_WIDTH + GAP_WIDTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.902 -0400", hash_original_method = "ED0B802F772E913D8F0EA056A6340C94", hash_generated_method = "13BF4FC702D70180361A14306EC5A565")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom,
                                  CharSequence text, int start, int end,
                                  boolean first, Layout layout) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(layout.dsTaint);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(baseline);
        dsTaint.addTaint(first);
        dsTaint.addTaint(end);
        dsTaint.addTaint(top);
        dsTaint.addTaint(x);
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

    
    private static final int STRIPE_WIDTH = 2;
    private static final int GAP_WIDTH = 2;
}

