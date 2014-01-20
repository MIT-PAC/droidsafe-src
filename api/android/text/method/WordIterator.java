package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.BreakIterator;
import java.util.Locale;

import android.text.Selection;
import android.text.SpannableStringBuilder;

public class WordIterator implements Selection.PositionIterator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.752 -0500", hash_original_field = "FE41FFC4BE7142B433FC121A1EC6188E", hash_generated_field = "F5FE4ACCABC3D0B58FEDE31DAF9A3648")

    private static final int WINDOW_WIDTH = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.755 -0500", hash_original_field = "0DD8A30A5B66E3389BB7F1641026A732", hash_generated_field = "C0B8B41E10B6EC8767D645F51D421276")

    private String mString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.757 -0500", hash_original_field = "57EF38B8D53BD974E124FC92AA2D585A", hash_generated_field = "0BBD7CD100EB425800EA2CBA37261EAE")

    private int mOffsetShift;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.761 -0500", hash_original_field = "375991621221DEB2B7274BC3764A961A", hash_generated_field = "3FDD48BD1B9B72C0290CDC044056432E")

    private BreakIterator mIterator;

    /**
     * Constructs a WordIterator using the default locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.764 -0500", hash_original_method = "AB8CC8AEC36CC88806001A57825CD492", hash_generated_method = "BC051192CB190142B14BAD493C862225")
    
public WordIterator() {
        this(Locale.getDefault());
    }

    /**
     * Constructs a new WordIterator for the specified locale.
     * @param locale The locale to be used when analysing the text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.767 -0500", hash_original_method = "2A66FD73F959B53947CB4E0B8EDD927F", hash_generated_method = "76DB0668E693AEB69AB10C966F2F110A")
    
public WordIterator(Locale locale) {
        mIterator = BreakIterator.getWordInstance(locale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.770 -0500", hash_original_method = "2DDA1ACFC823FC1E605D540F8F620C39", hash_generated_method = "0B6EC5686657DB2857741FC98DA72ABE")
    
public void setCharSequence(CharSequence charSequence, int start, int end) {
        mOffsetShift = Math.max(0, start - WINDOW_WIDTH);
        final int windowEnd = Math.min(charSequence.length(), end + WINDOW_WIDTH);

        if (charSequence instanceof SpannableStringBuilder) {
            mString = ((SpannableStringBuilder) charSequence).substring(mOffsetShift, windowEnd);
        } else {
            mString = charSequence.subSequence(mOffsetShift, windowEnd).toString();
        }
        mIterator.setText(mString);
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.773 -0500", hash_original_method = "17B38EF0704190E954BC6997CBD1C0A2", hash_generated_method = "1731388BEDA05414EF89F650AD625E6D")
    
public int preceding(int offset) {
        int shiftedOffset = offset - mOffsetShift;
        do {
            shiftedOffset = mIterator.preceding(shiftedOffset);
            if (shiftedOffset == BreakIterator.DONE) {
                return BreakIterator.DONE;
            }
            if (isOnLetterOrDigit(shiftedOffset)) {
                return shiftedOffset + mOffsetShift;
            }
        } while (true);
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.775 -0500", hash_original_method = "DA3F9C05695BD8FAB846E8868344998B", hash_generated_method = "25D4745AAAB4994EEC7E991F58C56637")
    
public int following(int offset) {
        int shiftedOffset = offset - mOffsetShift;
        do {
            shiftedOffset = mIterator.following(shiftedOffset);
            if (shiftedOffset == BreakIterator.DONE) {
                return BreakIterator.DONE;
            }
            if (isAfterLetterOrDigit(shiftedOffset)) {
                return shiftedOffset + mOffsetShift;
            }
        } while (true);
    }

    /** If <code>offset</code> is within a word, returns the index of the first character of that
     * word, otherwise returns BreakIterator.DONE.
     *
     * The offsets that are considered to be part of a word are the indexes of its characters,
     * <i>as well as</i> the index of its last character plus one.
     * If offset is the index of a low surrogate character, BreakIterator.DONE will be returned.
     *
     * Valid range for offset is [0..textLength] (note the inclusive upper bound).
     * The returned value is within [0..offset] or BreakIterator.DONE.
     *
     * @throws IllegalArgumentException is offset is not valid.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.778 -0500", hash_original_method = "0D432F790B6324713F4FDAF5BC7F832D", hash_generated_method = "0092725EEE705A5456AAEB4B50451A20")
    
public int getBeginning(int offset) {
        final int shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);

        if (isOnLetterOrDigit(shiftedOffset)) {
            if (mIterator.isBoundary(shiftedOffset)) {
                return shiftedOffset + mOffsetShift;
            } else {
                return mIterator.preceding(shiftedOffset) + mOffsetShift;
            }
        } else {
            if (isAfterLetterOrDigit(shiftedOffset)) {
                return mIterator.preceding(shiftedOffset) + mOffsetShift;
            }
        }
        return BreakIterator.DONE;
    }

    /** If <code>offset</code> is within a word, returns the index of the last character of that
     * word plus one, otherwise returns BreakIterator.DONE.
     *
     * The offsets that are considered to be part of a word are the indexes of its characters,
     * <i>as well as</i> the index of its last character plus one.
     * If offset is the index of a low surrogate character, BreakIterator.DONE will be returned.
     *
     * Valid range for offset is [0..textLength] (note the inclusive upper bound).
     * The returned value is within [offset..textLength] or BreakIterator.DONE.
     *
     * @throws IllegalArgumentException is offset is not valid.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.781 -0500", hash_original_method = "BDAE18DC1A45A79C9134EA83087086A0", hash_generated_method = "CB076793825B172EFF78A95E44AD4BBF")
    
public int getEnd(int offset) {
        final int shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);

        if (isAfterLetterOrDigit(shiftedOffset)) {
            if (mIterator.isBoundary(shiftedOffset)) {
                return shiftedOffset + mOffsetShift;
            } else {
                return mIterator.following(shiftedOffset) + mOffsetShift;
            }
        } else {
            if (isOnLetterOrDigit(shiftedOffset)) {
                return mIterator.following(shiftedOffset) + mOffsetShift;
            }
        }
        return BreakIterator.DONE;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.784 -0500", hash_original_method = "60A45BC82DD7A1F2C5F7476F31AEBCCE", hash_generated_method = "4ABE9F7FB81E2768955671133470FFD1")
    
private boolean isAfterLetterOrDigit(int shiftedOffset) {
        if (shiftedOffset >= 1 && shiftedOffset <= mString.length()) {
            final int codePoint = mString.codePointBefore(shiftedOffset);
            if (Character.isLetterOrDigit(codePoint)) return true;
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.787 -0500", hash_original_method = "C811EDD4D225F2A549F13F257AE33EBA", hash_generated_method = "C44238B73F17662F63C661AFFB2A5C16")
    
private boolean isOnLetterOrDigit(int shiftedOffset) {
        if (shiftedOffset >= 0 && shiftedOffset < mString.length()) {
            final int codePoint = mString.codePointAt(shiftedOffset);
            if (Character.isLetterOrDigit(codePoint)) return true;
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.790 -0500", hash_original_method = "715BE561E387B8F91746DB56405B0D1C", hash_generated_method = "22FA9B6C05DFECF8BD32D069E43BB8C7")
    
private void checkOffsetIsValid(int shiftedOffset) {
        if (shiftedOffset < 0 || shiftedOffset > mString.length()) {
            throw new IllegalArgumentException("Invalid offset: " + (shiftedOffset + mOffsetShift) +
                    ". Valid range is [" + mOffsetShift + ", " + (mString.length() + mOffsetShift) +
                    "]");
        }
    }
}

