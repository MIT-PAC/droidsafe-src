package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Rect;
import android.text.Editable;
import android.text.GetChars;
import android.text.Spannable;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.view.View;

public abstract class ReplacementTransformationMethod implements TransformationMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.669 -0400", hash_original_method = "B17F65175FF40B8BBE4A804240F7E3CD", hash_generated_method = "B17F65175FF40B8BBE4A804240F7E3CD")
        public ReplacementTransformationMethod ()
    {
    }


    protected abstract char[] getOriginal();

    
    protected abstract char[] getReplacement();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.670 -0400", hash_original_method = "194DC730C60A1F45F368AD90A104F0FE", hash_generated_method = "9F0AA5689AC10889593ABD32419BDDB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTransformation(CharSequence source, View v) {
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(source);
        char[] original;
        original = getOriginal();
        char[] replacement;
        replacement = getReplacement();
        {
            boolean doNothing;
            doNothing = true;
            int n;
            n = original.length;
            {
                int i;
                i = 0;
                {
                    {
                        boolean var5D9E69D176AC23816183A8DC001D54D2_1655065635 = (TextUtils.indexOf(source, original[i]) >= 0);
                        {
                            doNothing = false;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                {
                    CharSequence var669E31D05E8234FFAC75FF4CE4A28DAA_1235827320 = (new SpannedString(new SpannedReplacementCharSequence(
                                                        (Spanned) source,
                                                        original, replacement)));
                } //End block
                {
                    CharSequence varB82880E63536362973A5B3FC32A17ACF_985340875 = (new ReplacementCharSequence(source,
                                                       original,
                                                       replacement).toString());
                } //End block
            } //End block
        } //End block
        {
            CharSequence varC6F8901BA71AA866F5FE35E7103D72D8_410849582 = (new SpannedReplacementCharSequence((Spanned) source,
                                                      original, replacement));
        } //End block
        {
            CharSequence var069727547B22154FF553EC63F8A3ED40_1707428814 = (new ReplacementCharSequence(source, original, replacement));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.670 -0400", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "23495149C93C84951AFCB2F4B17330A5")
    @DSModeled(DSC.SAFE)
    public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(sourceText);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        dsTaint.addTaint(focused);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static class ReplacementCharSequence implements CharSequence, GetChars {
        private char[] mOriginal, mReplacement;
        private CharSequence mSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.670 -0400", hash_original_method = "F89FC48B18F547DBB1705366EEF3AC7C", hash_generated_method = "4216698B3A8E4C8C4ACAB4DB24BD748A")
        @DSModeled(DSC.SAFE)
        public ReplacementCharSequence(CharSequence source, char[] original,
                                       char[] replacement) {
            dsTaint.addTaint(replacement[0]);
            dsTaint.addTaint(source);
            dsTaint.addTaint(original[0]);
            // ---------- Original Method ----------
            //mSource = source;
            //mOriginal = original;
            //mReplacement = replacement;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.671 -0400", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "2DBABE0E16F1523566F381BCC4A6C4C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int length() {
            int var2AA1AAF84029D80557A421966334F312_1056314299 = (mSource.length());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSource.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.671 -0400", hash_original_method = "F5CDEE5D506853CF95A4D9E8A551C716", hash_generated_method = "2804862C2DAECB12EC24FA4E8A87C3D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char charAt(int i) {
            dsTaint.addTaint(i);
            char c;
            c = mSource.charAt(i);
            int n;
            n = mOriginal.length;
            {
                int j;
                j = 0;
                {
                    {
                        c = mReplacement[j];
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //char c = mSource.charAt(i);
            //int n = mOriginal.length;
            //for (int j = 0; j < n; j++) {
                //if (c == mOriginal[j]) {
                    //c = mReplacement[j];
                //}
            //}
            //return c;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.671 -0400", hash_original_method = "16B48B66F40BC5C2F3D95D2C2FC575C8", hash_generated_method = "E4BF5F569B9A84F9C3BCF4F6D0C95364")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CharSequence subSequence(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            char[] c;
            c = new char[end - start];
            getChars(start, end, c, 0);
            CharSequence varB864288B483FBEC03BC969CD741571C3_1619983093 = (new String(c));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //char[] c = new char[end - start];
            //getChars(start, end, c, 0);
            //return new String(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.678 -0400", hash_original_method = "C6C9F4F28222CB23CDD8D19463D6DD00", hash_generated_method = "6A81B37CD7100D76AC9CECD3C0CD34FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            char[] c;
            c = new char[length()];
            getChars(0, length(), c, 0);
            String varB864288B483FBEC03BC969CD741571C3_1778134949 = (new String(c));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //char[] c = new char[length()];
            //getChars(0, length(), c, 0);
            //return new String(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.679 -0400", hash_original_method = "296CE0E87E188E4485863573C8375539", hash_generated_method = "F53796F4683650574A6BF94A8BB5470C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void getChars(int start, int end, char[] dest, int off) {
            dsTaint.addTaint(dest[0]);
            dsTaint.addTaint(start);
            dsTaint.addTaint(off);
            dsTaint.addTaint(end);
            TextUtils.getChars(mSource, start, end, dest, off);
            int offend;
            offend = end - start + off;
            int n;
            n = mOriginal.length;
            {
                int i;
                i = off;
                {
                    char c;
                    c = dest[i];
                    {
                        int j;
                        j = 0;
                        {
                            {
                                dest[i] = mReplacement[j];
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //TextUtils.getChars(mSource, start, end, dest, off);
            //int offend = end - start + off;
            //int n = mOriginal.length;
            //for (int i = off; i < offend; i++) {
                //char c = dest[i];
                //for (int j = 0; j < n; j++) {
                    //if (c == mOriginal[j]) {
                        //dest[i] = mReplacement[j];
                    //}
                //}
            //}
        }

        
    }


    
    private static class SpannedReplacementCharSequence extends ReplacementCharSequence implements Spanned {
        private Spanned mSpanned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.679 -0400", hash_original_method = "CAA9811C5358881331EB71A9EC7C0C0E", hash_generated_method = "9BAB1169F107B5EA88B910554427716F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SpannedReplacementCharSequence(Spanned source, char[] original,
                                              char[] replacement) {
            super(source, original, replacement);
            dsTaint.addTaint(replacement[0]);
            dsTaint.addTaint(source.dsTaint);
            dsTaint.addTaint(original[0]);
            // ---------- Original Method ----------
            //mSpanned = source;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.679 -0400", hash_original_method = "C46F3FF4F9C2D4E0959AE37E95AA6C52", hash_generated_method = "E939AA750C3F13F7FD79FEE17AF78490")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CharSequence subSequence(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            CharSequence varDEE5A68118C9F1DD28A7A5311566DBD7_1885179930 = (new SpannedString(this).subSequence(start, end));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return new SpannedString(this).subSequence(start, end);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.679 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "44EE813753CE694AA28A3D9F4123C72C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(type.dsTaint);
            dsTaint.addTaint(end);
            T[] varD7D8544F4A8114420D7401F18A483DF9_1077872450 = (mSpanned.getSpans(start, end, type));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.680 -0400", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "24610582EFEB1A23A2F63A98E6980FD2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getSpanStart(Object tag) {
            dsTaint.addTaint(tag.dsTaint);
            int varD7924E7B7A12FA5A3B050A8325F5D9BE_2140072587 = (mSpanned.getSpanStart(tag));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.680 -0400", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "3EAD2E81FBF25F9D549037CCFDA0508F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getSpanEnd(Object tag) {
            dsTaint.addTaint(tag.dsTaint);
            int varFDD9D023F9FB8A63C470934B7C2E8224_2001539573 = (mSpanned.getSpanEnd(tag));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.680 -0400", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "3FDCE95D3D1A35ACADDD854BDB7B5534")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getSpanFlags(Object tag) {
            dsTaint.addTaint(tag.dsTaint);
            int var689A4E26E56E6EC55263E3776149ED4A_1201196652 = (mSpanned.getSpanFlags(tag));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.680 -0400", hash_original_method = "0259540B9EDC3EBDD85F9EA3B2A19C33", hash_generated_method = "64AACD49141EEDBC07312A489BC0B131")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int nextSpanTransition(int start, int end, Class type) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(type.dsTaint);
            dsTaint.addTaint(end);
            int var5119F035B8E56D52F8F813C80B67C353_855418437 = (mSpanned.nextSpanTransition(start, end, type));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, end, type);
        }

        
    }


    
}

