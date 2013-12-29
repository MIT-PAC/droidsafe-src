package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.TextUtils;





public class QuoteSpan implements LeadingMarginSpan, ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.062 -0500", hash_original_field = "31E56BD8B2275A61D20E89F31CB86962", hash_generated_field = "D30589795BDA1B839BB8F37F184231C0")

    private static final int STRIPE_WIDTH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.062 -0500", hash_original_field = "3DA9D7666761BF9EE5192EC985971AEB", hash_generated_field = "4B089EDD5D083F3AC7633F77D2ADA6D3")

    private static final int GAP_WIDTH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.063 -0500", hash_original_field = "CF1046E2EF6F9B2B63BE18A3B2BC71FD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")


    private  int mColor;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.064 -0500", hash_original_method = "7152FED56017453956A1C017DE8477BE", hash_generated_method = "34402F60A0BCEAA5BA74EB23EA94B0C8")
    public QuoteSpan() {
        super();
        mColor = 0xff0000ff;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.065 -0500", hash_original_method = "4E894B64A8966BC763843058D0706996", hash_generated_method = "CB3DF266432764832EF896243F542840")
    public QuoteSpan(int color) {
        super();
        mColor = color;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.066 -0500", hash_original_method = "4AD2E1D19CE8BCCBC25D1F8A03F5DD71", hash_generated_method = "E3B78769EE4DFC423E4A592C0360F2BA")
    public QuoteSpan(Parcel src) {
        mColor = src.readInt();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.067 -0500", hash_original_method = "91516A2AC14E144F9D08D31960E0CDBA", hash_generated_method = "FF0085C299826924E8034DB70E053C22")
    public int getSpanTypeId() {
        return TextUtils.QUOTE_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.068 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.068 -0500", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "5D25898D16D89B2F14A8038422877D91")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mColor);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.069 -0500", hash_original_method = "43BEB8B89AD2425C976FAD6ED1828A38", hash_generated_method = "7A0896AC75F29590ED428CB0809B3573")
    public int getColor() {
        return mColor;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.070 -0500", hash_original_method = "0C0816FE65D1CAB7203AAB3FE043AC6B", hash_generated_method = "543A620249B118248633B60068645BD8")
    public int getLeadingMargin(boolean first) {
        return STRIPE_WIDTH + GAP_WIDTH;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.071 -0500", hash_original_method = "ED0B802F772E913D8F0EA056A6340C94", hash_generated_method = "F9D80A44EDC084924685DEB5BFF786FC")
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
    }
}

