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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.832 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.841 -0400", hash_original_method = "7152FED56017453956A1C017DE8477BE", hash_generated_method = "B1FC0E64911AD70D2C36AA9A795566DE")
    public  QuoteSpan() {
        super();
        mColor = 0xff0000ff;
        // ---------- Original Method ----------
        //mColor = 0xff0000ff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.855 -0400", hash_original_method = "4E894B64A8966BC763843058D0706996", hash_generated_method = "CE96CFCA16C64DAFE0B2647269D1901B")
    public  QuoteSpan(int color) {
        super();
        mColor = color;
        // ---------- Original Method ----------
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.856 -0400", hash_original_method = "4AD2E1D19CE8BCCBC25D1F8A03F5DD71", hash_generated_method = "363E859350F26FF2EA6C7AA4654BCC93")
    public  QuoteSpan(Parcel src) {
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.856 -0400", hash_original_method = "91516A2AC14E144F9D08D31960E0CDBA", hash_generated_method = "F54843B46D2F0FE475F74B613A5647E3")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159387273 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159387273;
        // ---------- Original Method ----------
        //return TextUtils.QUOTE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.976 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A2667A3FE210BD069AEA06EF6B8F5EC0")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834774672 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834774672;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.977 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "4434B22B71E34F3AE6C4E59891B471B8")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mColor);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.978 -0400", hash_original_method = "43BEB8B89AD2425C976FAD6ED1828A38", hash_generated_method = "4860A0E4D7FFEA3343293AD8DCEAD72F")
    public int getColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127096813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127096813;
        // ---------- Original Method ----------
        //return mColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.978 -0400", hash_original_method = "0C0816FE65D1CAB7203AAB3FE043AC6B", hash_generated_method = "3A385C717B2DB4E07AE29CF3214FEBA1")
    public int getLeadingMargin(boolean first) {
        addTaint(first);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292324252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292324252;
        // ---------- Original Method ----------
        //return STRIPE_WIDTH + GAP_WIDTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.995 -0400", hash_original_method = "ED0B802F772E913D8F0EA056A6340C94", hash_generated_method = "CF0A0299C90E58BA9DDE6FC7ACBF0590")
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom,
                                  CharSequence text, int start, int end,
                                  boolean first, Layout layout) {
        Paint.Style style;
        style = p.getStyle();
        int color;
        color = p.getColor();
        p.setStyle(Paint.Style.FILL);
        p.setColor(mColor);
        c.drawRect(x, top, x + dir * STRIPE_WIDTH, bottom, p);
        p.setStyle(style);
        p.setColor(color);
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
        addTaint(layout.getTaint());
        // ---------- Original Method ----------
        //Paint.Style style = p.getStyle();
        //int color = p.getColor();
        //p.setStyle(Paint.Style.FILL);
        //p.setColor(mColor);
        //c.drawRect(x, top, x + dir * STRIPE_WIDTH, bottom, p);
        //p.setStyle(style);
        //p.setColor(color);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.995 -0400", hash_original_field = "7C1C6F9301CDF74995EDF7CECDF051A4", hash_generated_field = "9FFF3ABEC2773842BAB096FF4154AC61")

    private static int STRIPE_WIDTH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.995 -0400", hash_original_field = "1690EC89381B98678F6C4A3BC82F2565", hash_generated_field = "0573752704EBB1A3CD16A5356EB38E43")

    private static int GAP_WIDTH = 2;
}

