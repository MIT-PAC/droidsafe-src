package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Rect;
import android.text.Editable;
import android.text.GetChars;
import android.text.Spannable;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.view.View;

public abstract class ReplacementTransformationMethod implements TransformationMethod {
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.683 -0400", hash_original_method = "1B7B28F98DAC94187572CC248AC52BB7", hash_generated_method = "1B7B28F98DAC94187572CC248AC52BB7")
    public ReplacementTransformationMethod ()
    {
        //Synthesized constructor
    }
    /**
     * Returns the list of characters that are to be replaced by other
     * characters when displayed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.399 -0500", hash_original_method = "55EE05D5C51F3398002196D97174C16D", hash_generated_method = "2D5F18B916C26ECBC0D65B8AEFED9128")
    
protected abstract char[] getOriginal();
    /**
     * Returns a parallel array of replacement characters for the ones
     * that are to be replaced.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.402 -0500", hash_original_method = "3643E5A5E6264E9379DCCE07EDF81EE6", hash_generated_method = "FA11607C5568A335799F48B489079814")
    
protected abstract char[] getReplacement();

    /**
     * Returns a CharSequence that will mirror the contents of the
     * source CharSequence but with the characters in {@link #getOriginal}
     * replaced by ones from {@link #getReplacement}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.405 -0500", hash_original_method = "194DC730C60A1F45F368AD90A104F0FE", hash_generated_method = "95203B0678B88F2740A8A7DD052AC2B5")
    @DSVerified
public CharSequence getTransformation(CharSequence source, View v) {
        char[] original = getOriginal();
        char[] replacement = getReplacement();

        /*
         * Short circuit for faster display if the text will never change.
         */
        if (!(source instanceof Editable)) {
            /*
             * Check whether the text does not contain any of the
             * source characters so can be used unchanged.
             */
            boolean doNothing = true;
            int n = original.length;
            for (int i = 0; i < n; i++) {
                if (TextUtils.indexOf(source, original[i]) >= 0) {
                    doNothing = false;
                    break;
                }
            }
            if (doNothing) {
                return source;
            }

            if (!(source instanceof Spannable)) {
                /*
                 * The text contains some of the source characters,
                 * but they can be flattened out now instead of
                 * at display time.
                 */
                if (source instanceof Spanned) {
                    return new SpannedString(new SpannedReplacementCharSequence(
                                                        (Spanned) source,
                                                        original, replacement));
                } else {
                    return new ReplacementCharSequence(source,
                                                       original,
                                                       replacement).toString();
                }
            }
        }

        if (source instanceof Spanned) {
            return new SpannedReplacementCharSequence((Spanned) source,
                                                      original, replacement);
        } else {
            return new ReplacementCharSequence(source, original, replacement);
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.408 -0500", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "0F8E2FAE363C8E8BE7BE8F6653F0DCB8")
    
public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        // This callback isn't used.
    }
    
    private static class ReplacementCharSequence implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.688 -0400", hash_original_field = "8526EC2FF812D96CA9274ACA8998FC20", hash_generated_field = "FC1254D314CD4AAE23C5354189DEA616")

        private char[] mOriginal;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.688 -0400", hash_original_field = "05B11DD59B8E9A2C20387164079C6C37", hash_generated_field = "82418157EFFFE0C2D72794E96D9A0F0E")

        private char[] mReplacement;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.434 -0500", hash_original_field = "EBB181D64752DA6F9BB9A9E1DB00BBD4", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.415 -0500", hash_original_method = "F89FC48B18F547DBB1705366EEF3AC7C", hash_generated_method = "527809EB91F4BB27EAC8581D9458FF08")
        
public ReplacementCharSequence(CharSequence source, char[] original,
                                       char[] replacement) {
            mSource = source;
            mOriginal = original;
            mReplacement = replacement;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.418 -0500", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "2718F2DD1771250DF29BF44C4628A630")
        
public int length() {
            return mSource.length();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.421 -0500", hash_original_method = "F5CDEE5D506853CF95A4D9E8A551C716", hash_generated_method = "A08A5C49FE4360DA78BAB7E216493C94")
        
public char charAt(int i) {
            char c = mSource.charAt(i);

            int n = mOriginal.length;
            for (int j = 0; j < n; j++) {
                if (c == mOriginal[j]) {
                    c = mReplacement[j];
                }
            }

            return c;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.424 -0500", hash_original_method = "16B48B66F40BC5C2F3D95D2C2FC575C8", hash_generated_method = "C074C0F9E2C4C1C60C36F762D841D7C3")
        
public CharSequence subSequence(int start, int end) {
            char[] c = new char[end - start];

            getChars(start, end, c, 0);
            return new String(c);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.428 -0500", hash_original_method = "C6C9F4F28222CB23CDD8D19463D6DD00", hash_generated_method = "5A0AE2D63D4F4682071A07AA6E9E9219")
        
public String toString() {
            char[] c = new char[length()];

            getChars(0, length(), c, 0);
            return new String(c);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.431 -0500", hash_original_method = "296CE0E87E188E4485863573C8375539", hash_generated_method = "3DAD40810F8247973749E3F574ACB869")
        
public void getChars(int start, int end, char[] dest, int off) {
            TextUtils.getChars(mSource, start, end, dest, off);
            int offend = end - start + off;
            int n = mOriginal.length;

            for (int i = off; i < offend; i++) {
                char c = dest[i];

                for (int j = 0; j < n; j++) {
                    if (c == mOriginal[j]) {
                        dest[i] = mReplacement[j];
                    }
                }
            }
        }
        
    }
    
    private static class SpannedReplacementCharSequence extends ReplacementCharSequence implements Spanned {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.460 -0500", hash_original_field = "4D9A388EBF42337B3D4B4C24F8CD74B1", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.441 -0500", hash_original_method = "CAA9811C5358881331EB71A9EC7C0C0E", hash_generated_method = "D4CDDCC49CB612AF5A93F8DE5DB7F5B8")
        
public SpannedReplacementCharSequence(Spanned source, char[] original,
                                              char[] replacement) {
            super(source, original, replacement);
            mSpanned = source;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.444 -0500", hash_original_method = "C46F3FF4F9C2D4E0959AE37E95AA6C52", hash_generated_method = "C38C55CAF930AA5A31F2FE68B8DF9E0C")
        
public CharSequence subSequence(int start, int end) {
            return new SpannedString(this).subSequence(start, end);
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.694 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "758D85525E0EBDD586EED24B4A89DE1C")
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            addTaint(type.getTaint());
            addTaint(end);
            addTaint(start);
T[] varF03F51B4D510CEB709FCAEAB771CF011_117357119 =             mSpanned.getSpans(start, end, type);
            varF03F51B4D510CEB709FCAEAB771CF011_117357119.addTaint(getTaint());
            return varF03F51B4D510CEB709FCAEAB771CF011_117357119;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.449 -0500", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "2F1F23BF4970036AFC2624FBD0A76667")
        
public int getSpanStart(Object tag) {
            return mSpanned.getSpanStart(tag);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.452 -0500", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "352085C78F363920AB38A9623804477C")
        
public int getSpanEnd(Object tag) {
            return mSpanned.getSpanEnd(tag);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.455 -0500", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "94AA2E2AFBFE0A83C771FF66CD53D9D5")
        
public int getSpanFlags(Object tag) {
            return mSpanned.getSpanFlags(tag);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.458 -0500", hash_original_method = "0259540B9EDC3EBDD85F9EA3B2A19C33", hash_generated_method = "195753851AEF502B0F472C659604E7BD")
        
public int nextSpanTransition(int start, int end, Class type) {
            return mSpanned.nextSpanTransition(start, end, type);
        }
        
    }
    
}

