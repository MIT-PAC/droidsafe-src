package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.TextUtils;

public class QuoteSpan implements LeadingMarginSpan, ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.827 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.828 -0400", hash_original_method = "7152FED56017453956A1C017DE8477BE", hash_generated_method = "B1FC0E64911AD70D2C36AA9A795566DE")
    public  QuoteSpan() {
        super();
        mColor = 0xff0000ff;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.828 -0400", hash_original_method = "4E894B64A8966BC763843058D0706996", hash_generated_method = "CE96CFCA16C64DAFE0B2647269D1901B")
    public  QuoteSpan(int color) {
        super();
        mColor = color;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.829 -0400", hash_original_method = "4AD2E1D19CE8BCCBC25D1F8A03F5DD71", hash_generated_method = "363E859350F26FF2EA6C7AA4654BCC93")
    public  QuoteSpan(Parcel src) {
        mColor = src.readInt();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.829 -0400", hash_original_method = "91516A2AC14E144F9D08D31960E0CDBA", hash_generated_method = "B2E4A97E5DA93AD973C98AA7AF143943")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237637471 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237637471;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.830 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DEBD72EEA29758CCAF758BBC12DACBCC")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877672294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877672294;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.830 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "4434B22B71E34F3AE6C4E59891B471B8")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mColor);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.831 -0400", hash_original_method = "43BEB8B89AD2425C976FAD6ED1828A38", hash_generated_method = "3FE1F51A0A211C0D05C0C43C33DF2ABB")
    public int getColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_369484337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_369484337;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.831 -0400", hash_original_method = "0C0816FE65D1CAB7203AAB3FE043AC6B", hash_generated_method = "B7CA3553AEC1523B010F08DED8F510CE")
    public int getLeadingMargin(boolean first) {
        addTaint(first);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917622844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917622844;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.832 -0400", hash_original_method = "ED0B802F772E913D8F0EA056A6340C94", hash_generated_method = "B8FCE06D5767BD9C6BBBF5DDEB07AF78")
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom,
                                  CharSequence text, int start, int end,
                                  boolean first, Layout layout) {
        Paint.Style style = p.getStyle();
        int color = p.getColor();
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
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.832 -0400", hash_original_field = "7C1C6F9301CDF74995EDF7CECDF051A4", hash_generated_field = "D30589795BDA1B839BB8F37F184231C0")

    private static final int STRIPE_WIDTH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.832 -0400", hash_original_field = "1690EC89381B98678F6C4A3BC82F2565", hash_generated_field = "4B089EDD5D083F3AC7633F77D2ADA6D3")

    private static final int GAP_WIDTH = 2;
}

