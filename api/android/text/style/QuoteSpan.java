package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.TextUtils;

public class QuoteSpan implements LeadingMarginSpan, ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.244 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.244 -0400", hash_original_method = "7152FED56017453956A1C017DE8477BE", hash_generated_method = "B1FC0E64911AD70D2C36AA9A795566DE")
    public  QuoteSpan() {
        super();
        mColor = 0xff0000ff;
        // ---------- Original Method ----------
        //mColor = 0xff0000ff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.245 -0400", hash_original_method = "4E894B64A8966BC763843058D0706996", hash_generated_method = "CE96CFCA16C64DAFE0B2647269D1901B")
    public  QuoteSpan(int color) {
        super();
        mColor = color;
        // ---------- Original Method ----------
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.245 -0400", hash_original_method = "4AD2E1D19CE8BCCBC25D1F8A03F5DD71", hash_generated_method = "363E859350F26FF2EA6C7AA4654BCC93")
    public  QuoteSpan(Parcel src) {
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.246 -0400", hash_original_method = "91516A2AC14E144F9D08D31960E0CDBA", hash_generated_method = "9284706459DB63B210768E87D70C8B45")
    public int getSpanTypeId() {
        int varD0BBA295D33C7CDCACBE0304F9EB4D0A_583758158 = (TextUtils.QUOTE_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936841126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936841126;
        // ---------- Original Method ----------
        //return TextUtils.QUOTE_SPAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.246 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3EA7DF6F6ED72A739B8D316D543E1D2F")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_549280221 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655332199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655332199;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.246 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "2AA9C9BA7FF737DFF4D6096156FE1247")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mColor);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.246 -0400", hash_original_method = "43BEB8B89AD2425C976FAD6ED1828A38", hash_generated_method = "75E5C0A459ADCC0DD7F411A6BF318428")
    public int getColor() {
        int varD2A5DB085B68088532B9E8FB544C2EAD_908608403 = (mColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034451676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034451676;
        // ---------- Original Method ----------
        //return mColor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.247 -0400", hash_original_method = "0C0816FE65D1CAB7203AAB3FE043AC6B", hash_generated_method = "55376475431187F29EC47868996750AD")
    public int getLeadingMargin(boolean first) {
        addTaint(first);
        int varE9ED6A52D5464CA3C68CD7B4E4DCA573_1800376459 = (STRIPE_WIDTH + GAP_WIDTH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193683839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193683839;
        // ---------- Original Method ----------
        //return STRIPE_WIDTH + GAP_WIDTH;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.247 -0400", hash_original_method = "ED0B802F772E913D8F0EA056A6340C94", hash_generated_method = "CB41745BC6F9C428947752B840CC187E")
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom,
                                  CharSequence text, int start, int end,
                                  boolean first, Layout layout) {
        addTaint(layout.getTaint());
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
        Paint.Style style = p.getStyle();
        int color = p.getColor();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.248 -0400", hash_original_field = "7C1C6F9301CDF74995EDF7CECDF051A4", hash_generated_field = "D30589795BDA1B839BB8F37F184231C0")

    private static final int STRIPE_WIDTH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.248 -0400", hash_original_field = "1690EC89381B98678F6C4A3BC82F2565", hash_generated_field = "4B089EDD5D083F3AC7633F77D2ADA6D3")

    private static final int GAP_WIDTH = 2;
}

