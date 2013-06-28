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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.516 -0400", hash_original_method = "1B7B28F98DAC94187572CC248AC52BB7", hash_generated_method = "1B7B28F98DAC94187572CC248AC52BB7")
    public ReplacementTransformationMethod ()
    {
        //Synthesized constructor
    }


    protected abstract char[] getOriginal();

    
    protected abstract char[] getReplacement();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.517 -0400", hash_original_method = "194DC730C60A1F45F368AD90A104F0FE", hash_generated_method = "A25323051E5E7AFB2DD3ACC15729361A")
    public CharSequence getTransformation(CharSequence source, View v) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2023825514 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1842933060 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_402184729 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_162320255 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2085419203 = null; //Variable for return #5
        char[] original = getOriginal();
        char[] replacement = getReplacement();
        {
            boolean doNothing = true;
            int n = original.length;
            {
                int i = 0;
                {
                    {
                        boolean var5D9E69D176AC23816183A8DC001D54D2_601117502 = (TextUtils.indexOf(source, original[i]) >= 0);
                        {
                            doNothing = false;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                varB4EAC82CA7396A68D541C85D26508E83_2023825514 = source;
            } //End block
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1842933060 = new SpannedString(new SpannedReplacementCharSequence(
                                                        (Spanned) source,
                                                        original, replacement));
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_402184729 = new ReplacementCharSequence(source,
                                                       original,
                                                       replacement).toString();
                } //End block
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_162320255 = new SpannedReplacementCharSequence((Spanned) source,
                                                      original, replacement);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2085419203 = new ReplacementCharSequence(source, original, replacement);
        } //End block
        addTaint(source.getTaint());
        addTaint(v.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_81269541; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_81269541 = varB4EAC82CA7396A68D541C85D26508E83_2023825514;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_81269541 = varB4EAC82CA7396A68D541C85D26508E83_1842933060;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_81269541 = varB4EAC82CA7396A68D541C85D26508E83_402184729;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_81269541 = varB4EAC82CA7396A68D541C85D26508E83_162320255;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_81269541 = varB4EAC82CA7396A68D541C85D26508E83_2085419203;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_81269541.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_81269541;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.518 -0400", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "BBF679B18897E2BF5AC3F72CB72D0972")
    public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(view.getTaint());
        addTaint(sourceText.getTaint());
        addTaint(focused);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        // ---------- Original Method ----------
    }

    
    private static class ReplacementCharSequence implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.518 -0400", hash_original_field = "8526EC2FF812D96CA9274ACA8998FC20", hash_generated_field = "FC1254D314CD4AAE23C5354189DEA616")

        private char[] mOriginal;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.518 -0400", hash_original_field = "05B11DD59B8E9A2C20387164079C6C37", hash_generated_field = "82418157EFFFE0C2D72794E96D9A0F0E")

        private char[] mReplacement;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.518 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.518 -0400", hash_original_method = "F89FC48B18F547DBB1705366EEF3AC7C", hash_generated_method = "7440FAA0F491D27D7D153C80FF2CC4EE")
        public  ReplacementCharSequence(CharSequence source, char[] original,
                                       char[] replacement) {
            mSource = source;
            mOriginal = original;
            mReplacement = replacement;
            // ---------- Original Method ----------
            //mSource = source;
            //mOriginal = original;
            //mReplacement = replacement;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.519 -0400", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "A033C1ABCD96C18F169BDB3ADCC43CE6")
        public int length() {
            int var2AA1AAF84029D80557A421966334F312_828819366 = (mSource.length());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756079230 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756079230;
            // ---------- Original Method ----------
            //return mSource.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.519 -0400", hash_original_method = "F5CDEE5D506853CF95A4D9E8A551C716", hash_generated_method = "C86F4EA809119FBFF35161C9C2BEA741")
        public char charAt(int i) {
            char c = mSource.charAt(i);
            int n = mOriginal.length;
            {
                int j = 0;
                {
                    {
                        c = mReplacement[j];
                    } //End block
                } //End block
            } //End collapsed parenthetic
            addTaint(i);
            char varA87DEB01C5F539E6BDA34829C8EF2368_590626575 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_590626575;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.520 -0400", hash_original_method = "16B48B66F40BC5C2F3D95D2C2FC575C8", hash_generated_method = "B6F0EF8688D9F4DEB51C65E631FA7F25")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1101256113 = null; //Variable for return #1
            char[] c = new char[end - start];
            getChars(start, end, c, 0);
            varB4EAC82CA7396A68D541C85D26508E83_1101256113 = new String(c);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_1101256113.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1101256113;
            // ---------- Original Method ----------
            //char[] c = new char[end - start];
            //getChars(start, end, c, 0);
            //return new String(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.521 -0400", hash_original_method = "C6C9F4F28222CB23CDD8D19463D6DD00", hash_generated_method = "FFF5D8DFD59484424A0F50FBB36B4306")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_410274997 = null; //Variable for return #1
            char[] c = new char[length()];
            getChars(0, length(), c, 0);
            varB4EAC82CA7396A68D541C85D26508E83_410274997 = new String(c);
            varB4EAC82CA7396A68D541C85D26508E83_410274997.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_410274997;
            // ---------- Original Method ----------
            //char[] c = new char[length()];
            //getChars(0, length(), c, 0);
            //return new String(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.521 -0400", hash_original_method = "296CE0E87E188E4485863573C8375539", hash_generated_method = "7A46D5CD16DCDE3FA7F33B1DDEC5838A")
        public void getChars(int start, int end, char[] dest, int off) {
            TextUtils.getChars(mSource, start, end, dest, off);
            int offend = end - start + off;
            int n = mOriginal.length;
            {
                int i = off;
                {
                    char c = dest[i];
                    {
                        int j = 0;
                        {
                            {
                                dest[i] = mReplacement[j];
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            addTaint(start);
            addTaint(end);
            addTaint(dest[0]);
            addTaint(off);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.521 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.522 -0400", hash_original_method = "CAA9811C5358881331EB71A9EC7C0C0E", hash_generated_method = "D7FD18C185DDF616159BDB6EC24D122B")
        public  SpannedReplacementCharSequence(Spanned source, char[] original,
                                              char[] replacement) {
            super(source, original, replacement);
            mSpanned = source;
            addTaint(original[0]);
            addTaint(replacement[0]);
            // ---------- Original Method ----------
            //mSpanned = source;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.522 -0400", hash_original_method = "C46F3FF4F9C2D4E0959AE37E95AA6C52", hash_generated_method = "2B2067F7A25BA1C8CAE56F9A868755BB")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_199180593 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_199180593 = new SpannedString(this).subSequence(start, end);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_199180593.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_199180593;
            // ---------- Original Method ----------
            //return new SpannedString(this).subSequence(start, end);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.523 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "02608DF5EC9EC684F46C9C0B6B4DBB21")
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1775755442 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1775755442 = mSpanned.getSpans(start, end, type);
            addTaint(start);
            addTaint(end);
            addTaint(type.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1775755442.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1775755442;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.523 -0400", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "FEF47F561E192F2B9A29DEA69506FC84")
        public int getSpanStart(Object tag) {
            int varD7924E7B7A12FA5A3B050A8325F5D9BE_1451511518 = (mSpanned.getSpanStart(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149452194 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149452194;
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.523 -0400", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "FB5F34DB55E30A61518F9AA9D677F99A")
        public int getSpanEnd(Object tag) {
            int varFDD9D023F9FB8A63C470934B7C2E8224_499984647 = (mSpanned.getSpanEnd(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178876343 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178876343;
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.524 -0400", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "67364AC2F456EF880B92EB9A1F0F90B9")
        public int getSpanFlags(Object tag) {
            int var689A4E26E56E6EC55263E3776149ED4A_1625103782 = (mSpanned.getSpanFlags(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_415934933 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_415934933;
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.524 -0400", hash_original_method = "0259540B9EDC3EBDD85F9EA3B2A19C33", hash_generated_method = "B060D3507BA221F5D59E37377C7D196F")
        public int nextSpanTransition(int start, int end, Class type) {
            int var5119F035B8E56D52F8F813C80B67C353_1944703665 = (mSpanned.nextSpanTransition(start, end, type));
            addTaint(start);
            addTaint(end);
            addTaint(type.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263323806 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263323806;
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, end, type);
        }

        
    }


    
}

