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

public interface LeadingMarginSpan
extends ParagraphStyle
{
    
    public int getLeadingMargin(boolean first);
    
    public void drawLeadingMargin(Canvas c, Paint p,
                                  int x, int dir,
                                  int top, int baseline, int bottom,
                                  CharSequence text, int start, int end,
                                  boolean first, Layout layout);
    
    public interface LeadingMarginSpan2 extends LeadingMarginSpan, WrapTogetherSpan {
        
        public int getLeadingMarginLineCount();
    };
    
    public static class Standard implements LeadingMarginSpan, ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.251 -0500", hash_original_field = "95AB0A3DB664B7AFA487CCFB4C4CEFA4", hash_generated_field = "5FC7CAD03BEE7042F9F94E256ECA3936")

        private  int mFirst, mRest;
        
        /**
         * Constructor taking separate indents for the first and subsequent
         * lines.
         * 
         * @param first the indent for the first line of the paragraph
         * @param rest the indent for the remaining lines of the paragraph
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.254 -0500", hash_original_method = "E4322DC08758D1156C7649A46E737C12", hash_generated_method = "4170CC5AAF9A4CF7BF4365EB4DD94EBE")
        
public Standard(int first, int rest) {
            mFirst = first;
            mRest = rest;
        }

        /**
         * Constructor taking an indent for all lines.
         * @param every the indent of each line
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.258 -0500", hash_original_method = "97E8791ED853CD53EBF63C6C0A6CBCF5", hash_generated_method = "60A9F75006C1430F9FEADE9B5632FAF5")
        
public Standard(int every) {
            this(every, every);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.261 -0500", hash_original_method = "5691F7E036E5CA8525875CB90EDEC1FA", hash_generated_method = "2AEF3AC5AF25451379F26A06E897D8A2")
        
public Standard(Parcel src) {
            mFirst = src.readInt();
            mRest = src.readInt();
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.263 -0500", hash_original_method = "E4A248EAEF7F5505BB63EF903EE82A9C", hash_generated_method = "2CCDBBD91D2A7FB14559B406D0998734")
        
public int getSpanTypeId() {
            return TextUtils.LEADING_MARGIN_SPAN;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.266 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.269 -0500", hash_original_method = "AE8B874C7A6C454A0801C9E1E371EC4A", hash_generated_method = "68B312BE279EA01D12793A6C05F3868E")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(mFirst);
            dest.writeInt(mRest);
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.271 -0500", hash_original_method = "C031E4EC1BEA687C1A76A6F271C64683", hash_generated_method = "73D1C024547E7D82C890EC308EE6F5E3")
        
public int getLeadingMargin(boolean first) {
            return first ? mFirst : mRest;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:10.274 -0500", hash_original_method = "7A6ADECBC198581CEA5B1F0F652E6137", hash_generated_method = "92D9CA97AEFC03E248678E5ACC24005D")
        
public void drawLeadingMargin(Canvas c, Paint p,
                                      int x, int dir,
                                      int top, int baseline, int bottom,
                                      CharSequence text, int start, int end,
                                      boolean first, Layout layout) {
            ;
        }
    }
}
