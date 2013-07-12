package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import java.text.BreakIterator;
import java.util.Locale;

public class WordIterator implements Selection.PositionIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.083 -0400", hash_original_field = "18E347BCBCDD07E01563671B6BDE7905", hash_generated_field = "C0B8B41E10B6EC8767D645F51D421276")

    private String mString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.083 -0400", hash_original_field = "AAA1668480E5CC9F624C9ACFAC1E336C", hash_generated_field = "0BBD7CD100EB425800EA2CBA37261EAE")

    private int mOffsetShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.083 -0400", hash_original_field = "D0DDF189DBD48BEB487B547FA441AE98", hash_generated_field = "3FDD48BD1B9B72C0290CDC044056432E")

    private BreakIterator mIterator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.084 -0400", hash_original_method = "AB8CC8AEC36CC88806001A57825CD492", hash_generated_method = "F6A3B701594167B73AD57D2CAA166CCE")
    public  WordIterator() {
        this(Locale.getDefault());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.084 -0400", hash_original_method = "2A66FD73F959B53947CB4E0B8EDD927F", hash_generated_method = "947127AB01A128D57F4F13C6D40967B8")
    public  WordIterator(Locale locale) {
        mIterator = BreakIterator.getWordInstance(locale);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.085 -0400", hash_original_method = "2DDA1ACFC823FC1E605D540F8F620C39", hash_generated_method = "7AD3B9AAC2855D8186DCC9D466D4D797")
    public void setCharSequence(CharSequence charSequence, int start, int end) {
        addTaint(end);
        mOffsetShift = Math.max(0, start - WINDOW_WIDTH);
        final int windowEnd = Math.min(charSequence.length(), end + WINDOW_WIDTH);
    if(charSequence instanceof SpannableStringBuilder)        
        {
            mString = ((SpannableStringBuilder) charSequence).substring(mOffsetShift, windowEnd);
        } 
        else
        {
            mString = charSequence.subSequence(mOffsetShift, windowEnd).toString();
        } 
        mIterator.setText(mString);
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.086 -0400", hash_original_method = "17B38EF0704190E954BC6997CBD1C0A2", hash_generated_method = "23C47998C97189F31C70C487F7F7259C")
    public int preceding(int offset) {
        addTaint(offset);
        int shiftedOffset = offset - mOffsetShift;
        do {
            {
                shiftedOffset = mIterator.preceding(shiftedOffset);
    if(shiftedOffset == BreakIterator.DONE)                
                {
                    int var114C01BA41DAA73483AF8C93FD9104CB_1717646799 = (BreakIterator.DONE);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568757905 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568757905;
                } 
    if(isOnLetterOrDigit(shiftedOffset))                
                {
                    int varA3EF7399AB14AAE9F4A10BE42FB12D91_882346635 = (shiftedOffset + mOffsetShift);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448974603 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448974603;
                } 
            } 
} while (true);
        
        
        
            
            
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.087 -0400", hash_original_method = "DA3F9C05695BD8FAB846E8868344998B", hash_generated_method = "168AB8EB8F069CE5722F58821BAAD40F")
    public int following(int offset) {
        addTaint(offset);
        int shiftedOffset = offset - mOffsetShift;
        do {
            {
                shiftedOffset = mIterator.following(shiftedOffset);
    if(shiftedOffset == BreakIterator.DONE)                
                {
                    int var114C01BA41DAA73483AF8C93FD9104CB_979488829 = (BreakIterator.DONE);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100109462 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100109462;
                } 
    if(isAfterLetterOrDigit(shiftedOffset))                
                {
                    int varA3EF7399AB14AAE9F4A10BE42FB12D91_804049755 = (shiftedOffset + mOffsetShift);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2126666904 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2126666904;
                } 
            } 
} while (true);
        
        
        
            
            
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.088 -0400", hash_original_method = "0D432F790B6324713F4FDAF5BC7F832D", hash_generated_method = "939FEBF3C0543B9493DAE287D916E8B4")
    public int getBeginning(int offset) {
        addTaint(offset);
        final int shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
    if(isOnLetterOrDigit(shiftedOffset))        
        {
    if(mIterator.isBoundary(shiftedOffset))            
            {
                int varA3EF7399AB14AAE9F4A10BE42FB12D91_110641110 = (shiftedOffset + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459808141 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459808141;
            } 
            else
            {
                int var0BC96385F29279814E25F6E0AEAF80F4_156534517 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683611389 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683611389;
            } 
        } 
        else
        {
    if(isAfterLetterOrDigit(shiftedOffset))            
            {
                int var0BC96385F29279814E25F6E0AEAF80F4_1400908006 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784779306 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784779306;
            } 
        } 
        int var114C01BA41DAA73483AF8C93FD9104CB_1580544431 = (BreakIterator.DONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006946190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006946190;
        
        
        
        
            
                
            
                
            
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.089 -0400", hash_original_method = "BDAE18DC1A45A79C9134EA83087086A0", hash_generated_method = "CB7A7E296E9D261AF1B8BED5EF4FC42E")
    public int getEnd(int offset) {
        addTaint(offset);
        final int shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
    if(isAfterLetterOrDigit(shiftedOffset))        
        {
    if(mIterator.isBoundary(shiftedOffset))            
            {
                int varA3EF7399AB14AAE9F4A10BE42FB12D91_663132190 = (shiftedOffset + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_730889154 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_730889154;
            } 
            else
            {
                int var52A222CF5C026FC84D25E95888DC21A7_582389 = (mIterator.following(shiftedOffset) + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209650109 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209650109;
            } 
        } 
        else
        {
    if(isOnLetterOrDigit(shiftedOffset))            
            {
                int var52A222CF5C026FC84D25E95888DC21A7_1950460910 = (mIterator.following(shiftedOffset) + mOffsetShift);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129019493 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129019493;
            } 
        } 
        int var114C01BA41DAA73483AF8C93FD9104CB_1609889484 = (BreakIterator.DONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315321937 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315321937;
        
        
        
        
            
                
            
                
            
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.090 -0400", hash_original_method = "60A45BC82DD7A1F2C5F7476F31AEBCCE", hash_generated_method = "BE8EE8729C102E6B34FD4A17426E6B48")
    private boolean isAfterLetterOrDigit(int shiftedOffset) {
        addTaint(shiftedOffset);
    if(shiftedOffset >= 1 && shiftedOffset <= mString.length())        
        {
            final int codePoint = mString.codePointBefore(shiftedOffset);
    if(Character.isLetterOrDigit(codePoint))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_46199249 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753352838 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_753352838;
            }
        } 
        boolean var68934A3E9455FA72420237EB05902327_560603786 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323124227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323124227;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.092 -0400", hash_original_method = "C811EDD4D225F2A549F13F257AE33EBA", hash_generated_method = "E3E1191D0D6037D48A19F4C38A2F67A6")
    private boolean isOnLetterOrDigit(int shiftedOffset) {
        addTaint(shiftedOffset);
    if(shiftedOffset >= 0 && shiftedOffset < mString.length())        
        {
            final int codePoint = mString.codePointAt(shiftedOffset);
    if(Character.isLetterOrDigit(codePoint))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1946829103 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572539576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_572539576;
            }
        } 
        boolean var68934A3E9455FA72420237EB05902327_1676103544 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026538688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026538688;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.093 -0400", hash_original_method = "715BE561E387B8F91746DB56405B0D1C", hash_generated_method = "8C88189C0A1C14B686527F7B5E01342E")
    private void checkOffsetIsValid(int shiftedOffset) {
        addTaint(shiftedOffset);
    if(shiftedOffset < 0 || shiftedOffset > mString.length())        
        {
            IllegalArgumentException var3DB8604E77FFD6EC4892940FFC67C204_1522036359 = new IllegalArgumentException("Invalid offset: " + (shiftedOffset + mOffsetShift) +
                    ". Valid range is [" + mOffsetShift + ", " + (mString.length() + mOffsetShift) +
                    "]");
            var3DB8604E77FFD6EC4892940FFC67C204_1522036359.addTaint(taint);
            throw var3DB8604E77FFD6EC4892940FFC67C204_1522036359;
        } 
        
        
            
                    
                    
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.094 -0400", hash_original_field = "BBBC6FD050DCA304328F0C35252C11AD", hash_generated_field = "F5FE4ACCABC3D0B58FEDE31DAF9A3648")

    private static final int WINDOW_WIDTH = 50;
}

