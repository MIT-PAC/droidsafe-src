package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import java.text.BreakIterator;
import java.util.Locale;

public class WordIterator implements Selection.PositionIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.874 -0400", hash_original_field = "18E347BCBCDD07E01563671B6BDE7905", hash_generated_field = "C0B8B41E10B6EC8767D645F51D421276")

    private String mString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.874 -0400", hash_original_field = "AAA1668480E5CC9F624C9ACFAC1E336C", hash_generated_field = "0BBD7CD100EB425800EA2CBA37261EAE")

    private int mOffsetShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.874 -0400", hash_original_field = "D0DDF189DBD48BEB487B547FA441AE98", hash_generated_field = "3FDD48BD1B9B72C0290CDC044056432E")

    private BreakIterator mIterator;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.874 -0400", hash_original_method = "AB8CC8AEC36CC88806001A57825CD492", hash_generated_method = "F6A3B701594167B73AD57D2CAA166CCE")
    public  WordIterator() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.875 -0400", hash_original_method = "2A66FD73F959B53947CB4E0B8EDD927F", hash_generated_method = "947127AB01A128D57F4F13C6D40967B8")
    public  WordIterator(Locale locale) {
        mIterator = BreakIterator.getWordInstance(locale);
        // ---------- Original Method ----------
        //mIterator = BreakIterator.getWordInstance(locale);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.876 -0400", hash_original_method = "2DDA1ACFC823FC1E605D540F8F620C39", hash_generated_method = "7AD3B9AAC2855D8186DCC9D466D4D797")
    public void setCharSequence(CharSequence charSequence, int start, int end) {
        addTaint(end);
        mOffsetShift = Math.max(0, start - WINDOW_WIDTH);
        final int windowEnd = Math.min(charSequence.length(), end + WINDOW_WIDTH);
        if(charSequence instanceof SpannableStringBuilder)        
        {
            mString = ((SpannableStringBuilder) charSequence).substring(mOffsetShift, windowEnd);
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.876 -0400", hash_original_method = "17B38EF0704190E954BC6997CBD1C0A2", hash_generated_method = "8F2F5AEB761E0ADDEA79A1B258695593")
    public int preceding(int offset) {
        addTaint(offset);
        int shiftedOffset = offset - mOffsetShift;
        do {
            {
                shiftedOffset = mIterator.preceding(shiftedOffset);
                if(shiftedOffset == BreakIterator.DONE)                
                {
                    int var114C01BA41DAA73483AF8C93FD9104CB_1094916061 = (BreakIterator.DONE);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548536624 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548536624;
                } //End block
                if(isOnLetterOrDigit(shiftedOffset))                
                {
                    int varA3EF7399AB14AAE9F4A10BE42FB12D91_955178248 = (shiftedOffset + mOffsetShift);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717957178 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717957178;
                } //End block
            } //End block
} while (true);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.877 -0400", hash_original_method = "DA3F9C05695BD8FAB846E8868344998B", hash_generated_method = "803A6D508A5248D043C7A9E4E5490A63")
    public int following(int offset) {
        addTaint(offset);
        int shiftedOffset = offset - mOffsetShift;
        do {
            {
                shiftedOffset = mIterator.following(shiftedOffset);
                if(shiftedOffset == BreakIterator.DONE)                
                {
                    int var114C01BA41DAA73483AF8C93FD9104CB_42637625 = (BreakIterator.DONE);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59394897 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59394897;
                } //End block
                if(isAfterLetterOrDigit(shiftedOffset))                
                {
                    int varA3EF7399AB14AAE9F4A10BE42FB12D91_1767774820 = (shiftedOffset + mOffsetShift);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567166623 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567166623;
                } //End block
            } //End block
} while (true);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.877 -0400", hash_original_method = "0D432F790B6324713F4FDAF5BC7F832D", hash_generated_method = "2CA1DBCE71E8B18AAB1432C02D29284A")
    public int getBeginning(int offset) {
        addTaint(offset);
        final int shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
        if(isOnLetterOrDigit(shiftedOffset))        
        {
            if(mIterator.isBoundary(shiftedOffset))            
            {
                int varA3EF7399AB14AAE9F4A10BE42FB12D91_948323943 = (shiftedOffset + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304364931 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304364931;
            } //End block
            else
            {
                int var0BC96385F29279814E25F6E0AEAF80F4_74117913 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689986071 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689986071;
            } //End block
        } //End block
        else
        {
            if(isAfterLetterOrDigit(shiftedOffset))            
            {
                int var0BC96385F29279814E25F6E0AEAF80F4_436803229 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420683198 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420683198;
            } //End block
        } //End block
        int var114C01BA41DAA73483AF8C93FD9104CB_1887937513 = (BreakIterator.DONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786736392 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786736392;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.879 -0400", hash_original_method = "BDAE18DC1A45A79C9134EA83087086A0", hash_generated_method = "464C8352B7847CB3A93B1AE8FF4EA3CA")
    public int getEnd(int offset) {
        addTaint(offset);
        final int shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
        if(isAfterLetterOrDigit(shiftedOffset))        
        {
            if(mIterator.isBoundary(shiftedOffset))            
            {
                int varA3EF7399AB14AAE9F4A10BE42FB12D91_805303847 = (shiftedOffset + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1874257805 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1874257805;
            } //End block
            else
            {
                int var52A222CF5C026FC84D25E95888DC21A7_1702556874 = (mIterator.following(shiftedOffset) + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_750194938 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_750194938;
            } //End block
        } //End block
        else
        {
            if(isOnLetterOrDigit(shiftedOffset))            
            {
                int var52A222CF5C026FC84D25E95888DC21A7_391842776 = (mIterator.following(shiftedOffset) + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852529107 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852529107;
            } //End block
        } //End block
        int var114C01BA41DAA73483AF8C93FD9104CB_45120549 = (BreakIterator.DONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724920828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724920828;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.880 -0400", hash_original_method = "60A45BC82DD7A1F2C5F7476F31AEBCCE", hash_generated_method = "BE79C95FEA4DD821688F087065BF904F")
    private boolean isAfterLetterOrDigit(int shiftedOffset) {
        addTaint(shiftedOffset);
        if(shiftedOffset >= 1 && shiftedOffset <= mString.length())        
        {
            final int codePoint = mString.codePointBefore(shiftedOffset);
            if(Character.isLetterOrDigit(codePoint))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_679920483 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1388727355 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1388727355;
            }
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_170557231 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1346767433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1346767433;
        // ---------- Original Method ----------
        //if (shiftedOffset >= 1 && shiftedOffset <= mString.length()) {
            //final int codePoint = mString.codePointBefore(shiftedOffset);
            //if (Character.isLetterOrDigit(codePoint)) return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.880 -0400", hash_original_method = "C811EDD4D225F2A549F13F257AE33EBA", hash_generated_method = "EAC8BF6E8FB70EE4F24EFF4B3B388A02")
    private boolean isOnLetterOrDigit(int shiftedOffset) {
        addTaint(shiftedOffset);
        if(shiftedOffset >= 0 && shiftedOffset < mString.length())        
        {
            final int codePoint = mString.codePointAt(shiftedOffset);
            if(Character.isLetterOrDigit(codePoint))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1118192898 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2012347294 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2012347294;
            }
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_129416386 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2109966271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2109966271;
        // ---------- Original Method ----------
        //if (shiftedOffset >= 0 && shiftedOffset < mString.length()) {
            //final int codePoint = mString.codePointAt(shiftedOffset);
            //if (Character.isLetterOrDigit(codePoint)) return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.881 -0400", hash_original_method = "715BE561E387B8F91746DB56405B0D1C", hash_generated_method = "832ED0977DDDB84C63D02725D8B451C1")
    private void checkOffsetIsValid(int shiftedOffset) {
        addTaint(shiftedOffset);
        if(shiftedOffset < 0 || shiftedOffset > mString.length())        
        {
            IllegalArgumentException var3DB8604E77FFD6EC4892940FFC67C204_998291774 = new IllegalArgumentException("Invalid offset: " + (shiftedOffset + mOffsetShift) +
                    ". Valid range is [" + mOffsetShift + ", " + (mString.length() + mOffsetShift) +
                    "]");
            var3DB8604E77FFD6EC4892940FFC67C204_998291774.addTaint(taint);
            throw var3DB8604E77FFD6EC4892940FFC67C204_998291774;
        } //End block
        // ---------- Original Method ----------
        //if (shiftedOffset < 0 || shiftedOffset > mString.length()) {
            //throw new IllegalArgumentException("Invalid offset: " + (shiftedOffset + mOffsetShift) +
                    //". Valid range is [" + mOffsetShift + ", " + (mString.length() + mOffsetShift) +
                    //"]");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.881 -0400", hash_original_field = "BBBC6FD050DCA304328F0C35252C11AD", hash_generated_field = "F5FE4ACCABC3D0B58FEDE31DAF9A3648")

    private static final int WINDOW_WIDTH = 50;
}

