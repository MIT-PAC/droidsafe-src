package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.text.Selection;
import android.text.SpannableStringBuilder;
import java.text.BreakIterator;
import java.util.Locale;

public class WordIterator implements Selection.PositionIterator {
    private static final int WINDOW_WIDTH = 50;
    private String mString;
    private int mOffsetShift;
    private BreakIterator mIterator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.121 -0400", hash_original_method = "AB8CC8AEC36CC88806001A57825CD492", hash_generated_method = "8AE457BB1467B550371F706E1F2AFCBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WordIterator() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.121 -0400", hash_original_method = "2A66FD73F959B53947CB4E0B8EDD927F", hash_generated_method = "F9ACD2924649FD133C1B3A9A249B30F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WordIterator(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        mIterator = BreakIterator.getWordInstance(locale);
        // ---------- Original Method ----------
        //mIterator = BreakIterator.getWordInstance(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.122 -0400", hash_original_method = "2DDA1ACFC823FC1E605D540F8F620C39", hash_generated_method = "FF09DAD09B33CE5E071B87E4426CE5E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCharSequence(CharSequence charSequence, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(charSequence);
        dsTaint.addTaint(end);
        mOffsetShift = Math.max(0, start - WINDOW_WIDTH);
        final int windowEnd;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.122 -0400", hash_original_method = "17B38EF0704190E954BC6997CBD1C0A2", hash_generated_method = "F2B698879FBF28C7E52727E75B184526")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int preceding(int offset) {
        dsTaint.addTaint(offset);
        int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        {
            shiftedOffset = mIterator.preceding(shiftedOffset);
            {
                boolean varA0D6CF585DE1570EA7F3E44E7DD22466_2049913616 = (isOnLetterOrDigit(shiftedOffset));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.122 -0400", hash_original_method = "DA3F9C05695BD8FAB846E8868344998B", hash_generated_method = "6B25265B6D158EB1FDB04BA3B5F148E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int following(int offset) {
        dsTaint.addTaint(offset);
        int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        {
            shiftedOffset = mIterator.following(shiftedOffset);
            {
                boolean var1A6C2F729F39D012AD39EC3D2AA37043_1770826882 = (isAfterLetterOrDigit(shiftedOffset));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.122 -0400", hash_original_method = "0D432F790B6324713F4FDAF5BC7F832D", hash_generated_method = "15488DBFEA82EC82AD5B061D779462E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBeginning(int offset) {
        dsTaint.addTaint(offset);
        final int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
        {
            boolean var286F63C1A1ACC72F5129580E231B3F19_689336799 = (isOnLetterOrDigit(shiftedOffset));
            {
                {
                    boolean varB4B4C05081CBE63E902D225AEECF6D8B_975554942 = (mIterator.isBoundary(shiftedOffset));
                    {
                        int var0A2878D3CBF57DD815ED8A1F32FCD48E_1108552432 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var06ADDEE422599DDFA75CE6C849AE5C97_171150491 = (isAfterLetterOrDigit(shiftedOffset));
                    {
                        int var0A2878D3CBF57DD815ED8A1F32FCD48E_278608940 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.122 -0400", hash_original_method = "BDAE18DC1A45A79C9134EA83087086A0", hash_generated_method = "58FEC67195F1AE1FA2D8DC00F02376B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getEnd(int offset) {
        dsTaint.addTaint(offset);
        final int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
        {
            boolean varD9CBCC7E3838E9931857B4F04B672176_708216487 = (isAfterLetterOrDigit(shiftedOffset));
            {
                {
                    boolean varB4B4C05081CBE63E902D225AEECF6D8B_500618812 = (mIterator.isBoundary(shiftedOffset));
                    {
                        int varF4B4DE286A47D4A70E1CFDBAB0A64D1A_209069668 = (mIterator.following(shiftedOffset) + mOffsetShift);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var5BE6A27E5B96D50DA4647B360B2874CE_291160203 = (isOnLetterOrDigit(shiftedOffset));
                    {
                        int varF4B4DE286A47D4A70E1CFDBAB0A64D1A_1403426635 = (mIterator.following(shiftedOffset) + mOffsetShift);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.123 -0400", hash_original_method = "60A45BC82DD7A1F2C5F7476F31AEBCCE", hash_generated_method = "FE540ADA94F272BD6B20994D7E7B6A32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isAfterLetterOrDigit(int shiftedOffset) {
        dsTaint.addTaint(shiftedOffset);
        {
            boolean varF5393482EF6F317B07B1C94DACFBF909_35873410 = (shiftedOffset >= 1 && shiftedOffset <= mString.length());
            {
                final int codePoint;
                codePoint = mString.codePointBefore(shiftedOffset);
                {
                    boolean varD6606A5963F93B6F3C8BBCF888FAF831_1011379908 = (Character.isLetterOrDigit(codePoint));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.123 -0400", hash_original_method = "C811EDD4D225F2A549F13F257AE33EBA", hash_generated_method = "7B5DBF4846956969CB7C98C71A24E725")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isOnLetterOrDigit(int shiftedOffset) {
        dsTaint.addTaint(shiftedOffset);
        {
            boolean varC25052DD31B57AC010FD859A0CFC1253_1755449359 = (shiftedOffset >= 0 && shiftedOffset < mString.length());
            {
                final int codePoint;
                codePoint = mString.codePointAt(shiftedOffset);
                {
                    boolean varD6606A5963F93B6F3C8BBCF888FAF831_1739561593 = (Character.isLetterOrDigit(codePoint));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.123 -0400", hash_original_method = "715BE561E387B8F91746DB56405B0D1C", hash_generated_method = "D200F09E2C1E76933EC73C0BDC57D7AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOffsetIsValid(int shiftedOffset) {
        dsTaint.addTaint(shiftedOffset);
        {
            boolean var07121F6B0236069059E5A0DA04661899_157016221 = (shiftedOffset < 0 || shiftedOffset > mString.length());
            {
                throw new IllegalArgumentException("Invalid offset: " + (shiftedOffset + mOffsetShift) +
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

    
}


