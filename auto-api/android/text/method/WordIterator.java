package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import java.text.BreakIterator;
import java.util.Locale;

public class WordIterator implements Selection.PositionIterator {
    private String mString;
    private int mOffsetShift;
    private BreakIterator mIterator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.805 -0400", hash_original_method = "AB8CC8AEC36CC88806001A57825CD492", hash_generated_method = "F6A3B701594167B73AD57D2CAA166CCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WordIterator() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.805 -0400", hash_original_method = "2A66FD73F959B53947CB4E0B8EDD927F", hash_generated_method = "FE2053638BE24F7943964CA740C91075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WordIterator(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        mIterator = BreakIterator.getWordInstance(locale);
        // ---------- Original Method ----------
        //mIterator = BreakIterator.getWordInstance(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.805 -0400", hash_original_method = "2DDA1ACFC823FC1E605D540F8F620C39", hash_generated_method = "706CE1B1EEFF4581A7BAD306B412B7C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCharSequence(CharSequence charSequence, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(charSequence);
        dsTaint.addTaint(end);
        mOffsetShift = Math.max(0, start - WINDOW_WIDTH);
        int windowEnd;
        windowEnd = Math.min(charSequence.length(), end + WINDOW_WIDTH);
        {
            mString = ((SpannableStringBuilder) charSequence).substring(mOffsetShift, windowEnd);
        } //End block
        {
            mString = charSequence.subSequence(mOffsetShift, windowEnd).toString();
        } //End block
        mIterator.setText(mString);
        // ---------- Original Method ----------
        //mOffsetShift = Math.max(0, start - WINDOW_WIDTH);
        //final int windowEnd = Math.min(charSequence.length(), end + WINDOW_WIDTH);
        //if (charSequence instanceof SpannableStringBuilder) {
            //mString = ((SpannableStringBuilder) charSequence).substring(mOffsetShift, windowEnd);
        //} else {
            //mString = charSequence.subSequence(mOffsetShift, windowEnd).toString();
        //}
        //mIterator.setText(mString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.806 -0400", hash_original_method = "17B38EF0704190E954BC6997CBD1C0A2", hash_generated_method = "62B23523ED5AD2D9048DF22E3EE67307")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int preceding(int offset) {
        dsTaint.addTaint(offset);
        int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        {
            shiftedOffset = mIterator.preceding(shiftedOffset);
            {
                boolean varA0D6CF585DE1570EA7F3E44E7DD22466_825977160 = (isOnLetterOrDigit(shiftedOffset));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int shiftedOffset = offset - mOffsetShift;
        //do {
            //shiftedOffset = mIterator.preceding(shiftedOffset);
            //if (shiftedOffset == BreakIterator.DONE) {
                //return BreakIterator.DONE;
            //}
            //if (isOnLetterOrDigit(shiftedOffset)) {
                //return shiftedOffset + mOffsetShift;
            //}
        //} while (true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.806 -0400", hash_original_method = "DA3F9C05695BD8FAB846E8868344998B", hash_generated_method = "AD3241288171D76FA208081A2E00FCE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int following(int offset) {
        dsTaint.addTaint(offset);
        int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        {
            shiftedOffset = mIterator.following(shiftedOffset);
            {
                boolean var1A6C2F729F39D012AD39EC3D2AA37043_2027829391 = (isAfterLetterOrDigit(shiftedOffset));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int shiftedOffset = offset - mOffsetShift;
        //do {
            //shiftedOffset = mIterator.following(shiftedOffset);
            //if (shiftedOffset == BreakIterator.DONE) {
                //return BreakIterator.DONE;
            //}
            //if (isAfterLetterOrDigit(shiftedOffset)) {
                //return shiftedOffset + mOffsetShift;
            //}
        //} while (true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.807 -0400", hash_original_method = "0D432F790B6324713F4FDAF5BC7F832D", hash_generated_method = "9E36971CDB2CE318398ABDF199EA4B95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBeginning(int offset) {
        dsTaint.addTaint(offset);
        int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
        {
            boolean var286F63C1A1ACC72F5129580E231B3F19_1794840743 = (isOnLetterOrDigit(shiftedOffset));
            {
                {
                    boolean varB4B4C05081CBE63E902D225AEECF6D8B_1127959981 = (mIterator.isBoundary(shiftedOffset));
                    {
                        int var0A2878D3CBF57DD815ED8A1F32FCD48E_1751949700 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var06ADDEE422599DDFA75CE6C849AE5C97_349078605 = (isAfterLetterOrDigit(shiftedOffset));
                    {
                        int var0A2878D3CBF57DD815ED8A1F32FCD48E_1333424294 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int shiftedOffset = offset - mOffsetShift;
        //checkOffsetIsValid(shiftedOffset);
        //if (isOnLetterOrDigit(shiftedOffset)) {
            //if (mIterator.isBoundary(shiftedOffset)) {
                //return shiftedOffset + mOffsetShift;
            //} else {
                //return mIterator.preceding(shiftedOffset) + mOffsetShift;
            //}
        //} else {
            //if (isAfterLetterOrDigit(shiftedOffset)) {
                //return mIterator.preceding(shiftedOffset) + mOffsetShift;
            //}
        //}
        //return BreakIterator.DONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.807 -0400", hash_original_method = "BDAE18DC1A45A79C9134EA83087086A0", hash_generated_method = "1BD261B68FA2F654948A18688B19B91B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getEnd(int offset) {
        dsTaint.addTaint(offset);
        int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
        {
            boolean varD9CBCC7E3838E9931857B4F04B672176_555574313 = (isAfterLetterOrDigit(shiftedOffset));
            {
                {
                    boolean varB4B4C05081CBE63E902D225AEECF6D8B_850989301 = (mIterator.isBoundary(shiftedOffset));
                    {
                        int varF4B4DE286A47D4A70E1CFDBAB0A64D1A_2009571402 = (mIterator.following(shiftedOffset) + mOffsetShift);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var5BE6A27E5B96D50DA4647B360B2874CE_145639208 = (isOnLetterOrDigit(shiftedOffset));
                    {
                        int varF4B4DE286A47D4A70E1CFDBAB0A64D1A_1465026053 = (mIterator.following(shiftedOffset) + mOffsetShift);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int shiftedOffset = offset - mOffsetShift;
        //checkOffsetIsValid(shiftedOffset);
        //if (isAfterLetterOrDigit(shiftedOffset)) {
            //if (mIterator.isBoundary(shiftedOffset)) {
                //return shiftedOffset + mOffsetShift;
            //} else {
                //return mIterator.following(shiftedOffset) + mOffsetShift;
            //}
        //} else {
            //if (isOnLetterOrDigit(shiftedOffset)) {
                //return mIterator.following(shiftedOffset) + mOffsetShift;
            //}
        //}
        //return BreakIterator.DONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.808 -0400", hash_original_method = "60A45BC82DD7A1F2C5F7476F31AEBCCE", hash_generated_method = "77E39FA66DB8EB9DA991F857B9836D54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isAfterLetterOrDigit(int shiftedOffset) {
        dsTaint.addTaint(shiftedOffset);
        {
            boolean varF5393482EF6F317B07B1C94DACFBF909_636265494 = (shiftedOffset >= 1 && shiftedOffset <= mString.length());
            {
                int codePoint;
                codePoint = mString.codePointBefore(shiftedOffset);
                {
                    boolean varD6606A5963F93B6F3C8BBCF888FAF831_726799151 = (Character.isLetterOrDigit(codePoint));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (shiftedOffset >= 1 && shiftedOffset <= mString.length()) {
            //final int codePoint = mString.codePointBefore(shiftedOffset);
            //if (Character.isLetterOrDigit(codePoint)) return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.808 -0400", hash_original_method = "C811EDD4D225F2A549F13F257AE33EBA", hash_generated_method = "0C507801136EDD2F0735E2204FFA3B78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isOnLetterOrDigit(int shiftedOffset) {
        dsTaint.addTaint(shiftedOffset);
        {
            boolean varC25052DD31B57AC010FD859A0CFC1253_1739168873 = (shiftedOffset >= 0 && shiftedOffset < mString.length());
            {
                int codePoint;
                codePoint = mString.codePointAt(shiftedOffset);
                {
                    boolean varD6606A5963F93B6F3C8BBCF888FAF831_122613123 = (Character.isLetterOrDigit(codePoint));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (shiftedOffset >= 0 && shiftedOffset < mString.length()) {
            //final int codePoint = mString.codePointAt(shiftedOffset);
            //if (Character.isLetterOrDigit(codePoint)) return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.808 -0400", hash_original_method = "715BE561E387B8F91746DB56405B0D1C", hash_generated_method = "FA6117A9ED72A5338E4205B1F09031CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOffsetIsValid(int shiftedOffset) {
        dsTaint.addTaint(shiftedOffset);
        {
            boolean var07121F6B0236069059E5A0DA04661899_1410758040 = (shiftedOffset < 0 || shiftedOffset > mString.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid offset: " + (shiftedOffset + mOffsetShift) +
                    ". Valid range is [" + mOffsetShift + ", " + (mString.length() + mOffsetShift) +
                    "]");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (shiftedOffset < 0 || shiftedOffset > mString.length()) {
            //throw new IllegalArgumentException("Invalid offset: " + (shiftedOffset + mOffsetShift) +
                    //". Valid range is [" + mOffsetShift + ", " + (mString.length() + mOffsetShift) +
                    //"]");
        //}
    }

    
    private static final int WINDOW_WIDTH = 50;
}

