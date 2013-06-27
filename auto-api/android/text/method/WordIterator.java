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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.269 -0400", hash_original_field = "18E347BCBCDD07E01563671B6BDE7905", hash_generated_field = "C0B8B41E10B6EC8767D645F51D421276")

    private String mString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.269 -0400", hash_original_field = "AAA1668480E5CC9F624C9ACFAC1E336C", hash_generated_field = "0BBD7CD100EB425800EA2CBA37261EAE")

    private int mOffsetShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.269 -0400", hash_original_field = "D0DDF189DBD48BEB487B547FA441AE98", hash_generated_field = "3FDD48BD1B9B72C0290CDC044056432E")

    private BreakIterator mIterator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.270 -0400", hash_original_method = "AB8CC8AEC36CC88806001A57825CD492", hash_generated_method = "F6A3B701594167B73AD57D2CAA166CCE")
    public  WordIterator() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.271 -0400", hash_original_method = "2A66FD73F959B53947CB4E0B8EDD927F", hash_generated_method = "947127AB01A128D57F4F13C6D40967B8")
    public  WordIterator(Locale locale) {
        mIterator = BreakIterator.getWordInstance(locale);
        // ---------- Original Method ----------
        //mIterator = BreakIterator.getWordInstance(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.302 -0400", hash_original_method = "2DDA1ACFC823FC1E605D540F8F620C39", hash_generated_method = "CC5DD6AB4D1BE7CCB7692833410230E5")
    public void setCharSequence(CharSequence charSequence, int start, int end) {
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
        addTaint(end);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.302 -0400", hash_original_method = "17B38EF0704190E954BC6997CBD1C0A2", hash_generated_method = "29CCAF9BAF810B7A8CBE2AA10CE6628F")
    public int preceding(int offset) {
        int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        {
            shiftedOffset = mIterator.preceding(shiftedOffset);
            {
                boolean varA0D6CF585DE1570EA7F3E44E7DD22466_1900798063 = (isOnLetterOrDigit(shiftedOffset));
            } //End collapsed parenthetic
        } //End block
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709071833 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709071833;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.303 -0400", hash_original_method = "DA3F9C05695BD8FAB846E8868344998B", hash_generated_method = "A5D840DEBAA2C79674AF1B605AB047C3")
    public int following(int offset) {
        int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        {
            shiftedOffset = mIterator.following(shiftedOffset);
            {
                boolean var1A6C2F729F39D012AD39EC3D2AA37043_167744885 = (isAfterLetterOrDigit(shiftedOffset));
            } //End collapsed parenthetic
        } //End block
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165270788 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165270788;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.313 -0400", hash_original_method = "0D432F790B6324713F4FDAF5BC7F832D", hash_generated_method = "485A087882CE6C47E2BE7575209CAC8A")
    public int getBeginning(int offset) {
        int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
        {
            boolean var286F63C1A1ACC72F5129580E231B3F19_1423370575 = (isOnLetterOrDigit(shiftedOffset));
            {
                {
                    boolean varB4B4C05081CBE63E902D225AEECF6D8B_866861209 = (mIterator.isBoundary(shiftedOffset));
                    {
                        int var0A2878D3CBF57DD815ED8A1F32FCD48E_951959522 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var06ADDEE422599DDFA75CE6C849AE5C97_1217892377 = (isAfterLetterOrDigit(shiftedOffset));
                    {
                        int var0A2878D3CBF57DD815ED8A1F32FCD48E_765043575 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1343837852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1343837852;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.314 -0400", hash_original_method = "BDAE18DC1A45A79C9134EA83087086A0", hash_generated_method = "D69F22AF709487D51FD49A6F67F22DC4")
    public int getEnd(int offset) {
        int shiftedOffset;
        shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
        {
            boolean varD9CBCC7E3838E9931857B4F04B672176_1889975032 = (isAfterLetterOrDigit(shiftedOffset));
            {
                {
                    boolean varB4B4C05081CBE63E902D225AEECF6D8B_2063233776 = (mIterator.isBoundary(shiftedOffset));
                    {
                        int varF4B4DE286A47D4A70E1CFDBAB0A64D1A_2079342338 = (mIterator.following(shiftedOffset) + mOffsetShift);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var5BE6A27E5B96D50DA4647B360B2874CE_1015100575 = (isOnLetterOrDigit(shiftedOffset));
                    {
                        int varF4B4DE286A47D4A70E1CFDBAB0A64D1A_1081234924 = (mIterator.following(shiftedOffset) + mOffsetShift);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589589590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589589590;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.315 -0400", hash_original_method = "60A45BC82DD7A1F2C5F7476F31AEBCCE", hash_generated_method = "47306C8231462F972A48E1E5F15505DC")
    private boolean isAfterLetterOrDigit(int shiftedOffset) {
        {
            boolean varF5393482EF6F317B07B1C94DACFBF909_1191807518 = (shiftedOffset >= 1 && shiftedOffset <= mString.length());
            {
                int codePoint;
                codePoint = mString.codePointBefore(shiftedOffset);
                {
                    boolean varD6606A5963F93B6F3C8BBCF888FAF831_1679691519 = (Character.isLetterOrDigit(codePoint));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(shiftedOffset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_350994202 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_350994202;
        // ---------- Original Method ----------
        //if (shiftedOffset >= 1 && shiftedOffset <= mString.length()) {
            //final int codePoint = mString.codePointBefore(shiftedOffset);
            //if (Character.isLetterOrDigit(codePoint)) return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.332 -0400", hash_original_method = "C811EDD4D225F2A549F13F257AE33EBA", hash_generated_method = "6250274294F00C01E85B5319DE377AEE")
    private boolean isOnLetterOrDigit(int shiftedOffset) {
        {
            boolean varC25052DD31B57AC010FD859A0CFC1253_1434668626 = (shiftedOffset >= 0 && shiftedOffset < mString.length());
            {
                int codePoint;
                codePoint = mString.codePointAt(shiftedOffset);
                {
                    boolean varD6606A5963F93B6F3C8BBCF888FAF831_656209550 = (Character.isLetterOrDigit(codePoint));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(shiftedOffset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_774148688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_774148688;
        // ---------- Original Method ----------
        //if (shiftedOffset >= 0 && shiftedOffset < mString.length()) {
            //final int codePoint = mString.codePointAt(shiftedOffset);
            //if (Character.isLetterOrDigit(codePoint)) return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.333 -0400", hash_original_method = "715BE561E387B8F91746DB56405B0D1C", hash_generated_method = "A8F96721758E27BA5AFB381AE8C791B7")
    private void checkOffsetIsValid(int shiftedOffset) {
        {
            boolean var07121F6B0236069059E5A0DA04661899_251469580 = (shiftedOffset < 0 || shiftedOffset > mString.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid offset: " + (shiftedOffset + mOffsetShift) +
                    ". Valid range is [" + mOffsetShift + ", " + (mString.length() + mOffsetShift) +
                    "]");
            } //End block
        } //End collapsed parenthetic
        addTaint(shiftedOffset);
        // ---------- Original Method ----------
        //if (shiftedOffset < 0 || shiftedOffset > mString.length()) {
            //throw new IllegalArgumentException("Invalid offset: " + (shiftedOffset + mOffsetShift) +
                    //". Valid range is [" + mOffsetShift + ", " + (mString.length() + mOffsetShift) +
                    //"]");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.333 -0400", hash_original_field = "BBBC6FD050DCA304328F0C35252C11AD", hash_generated_field = "054ECD79A14836BF14A9CE7CD90DF7A0")

    private static int WINDOW_WIDTH = 50;
}

