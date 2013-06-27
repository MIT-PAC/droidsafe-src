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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.465 -0400", hash_original_method = "1B7B28F98DAC94187572CC248AC52BB7", hash_generated_method = "1B7B28F98DAC94187572CC248AC52BB7")
    public ReplacementTransformationMethod ()
    {
        //Synthesized constructor
    }


    protected abstract char[] getOriginal();

    
    protected abstract char[] getReplacement();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.480 -0400", hash_original_method = "194DC730C60A1F45F368AD90A104F0FE", hash_generated_method = "958E3593ADF7F80471086882FA9E80DD")
    public CharSequence getTransformation(CharSequence source, View v) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1515364695 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_390806434 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_317148317 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1370725737 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_580373797 = null; //Variable for return #5
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
                        boolean var5D9E69D176AC23816183A8DC001D54D2_1500278405 = (TextUtils.indexOf(source, original[i]) >= 0);
                        {
                            doNothing = false;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                varB4EAC82CA7396A68D541C85D26508E83_1515364695 = source;
            } //End block
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_390806434 = new SpannedString(new SpannedReplacementCharSequence(
                                                        (Spanned) source,
                                                        original, replacement));
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_317148317 = new ReplacementCharSequence(source,
                                                       original,
                                                       replacement).toString();
                } //End block
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1370725737 = new SpannedReplacementCharSequence((Spanned) source,
                                                      original, replacement);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_580373797 = new ReplacementCharSequence(source, original, replacement);
        } //End block
        addTaint(source.getTaint());
        addTaint(v.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_569878711; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_569878711 = varB4EAC82CA7396A68D541C85D26508E83_1515364695;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_569878711 = varB4EAC82CA7396A68D541C85D26508E83_390806434;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_569878711 = varB4EAC82CA7396A68D541C85D26508E83_317148317;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_569878711 = varB4EAC82CA7396A68D541C85D26508E83_1370725737;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_569878711 = varB4EAC82CA7396A68D541C85D26508E83_580373797;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_569878711.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_569878711;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.481 -0400", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "BBF679B18897E2BF5AC3F72CB72D0972")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.481 -0400", hash_original_field = "8526EC2FF812D96CA9274ACA8998FC20", hash_generated_field = "FC1254D314CD4AAE23C5354189DEA616")

        private char[] mOriginal;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.481 -0400", hash_original_field = "05B11DD59B8E9A2C20387164079C6C37", hash_generated_field = "82418157EFFFE0C2D72794E96D9A0F0E")

        private char[] mReplacement;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.481 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.482 -0400", hash_original_method = "F89FC48B18F547DBB1705366EEF3AC7C", hash_generated_method = "7440FAA0F491D27D7D153C80FF2CC4EE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.482 -0400", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "9CD4F8F4B7C4F10A3FAD435F622FDDDA")
        public int length() {
            int var2AA1AAF84029D80557A421966334F312_725892049 = (mSource.length());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578635651 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578635651;
            // ---------- Original Method ----------
            //return mSource.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.503 -0400", hash_original_method = "F5CDEE5D506853CF95A4D9E8A551C716", hash_generated_method = "563723D43B1CF513EC437C1A0C08E730")
        public char charAt(int i) {
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
            addTaint(i);
            char varA87DEB01C5F539E6BDA34829C8EF2368_1103357076 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1103357076;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.504 -0400", hash_original_method = "16B48B66F40BC5C2F3D95D2C2FC575C8", hash_generated_method = "863B2925F4C84638B3614DD8AA9765DC")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_901648023 = null; //Variable for return #1
            char[] c;
            c = new char[end - start];
            getChars(start, end, c, 0);
            varB4EAC82CA7396A68D541C85D26508E83_901648023 = new String(c);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_901648023.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_901648023;
            // ---------- Original Method ----------
            //char[] c = new char[end - start];
            //getChars(start, end, c, 0);
            //return new String(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.505 -0400", hash_original_method = "C6C9F4F28222CB23CDD8D19463D6DD00", hash_generated_method = "B88D3365DBCF17E3170DCFB253E3CFE7")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1225118711 = null; //Variable for return #1
            char[] c;
            c = new char[length()];
            getChars(0, length(), c, 0);
            varB4EAC82CA7396A68D541C85D26508E83_1225118711 = new String(c);
            varB4EAC82CA7396A68D541C85D26508E83_1225118711.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1225118711;
            // ---------- Original Method ----------
            //char[] c = new char[length()];
            //getChars(0, length(), c, 0);
            //return new String(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.506 -0400", hash_original_method = "296CE0E87E188E4485863573C8375539", hash_generated_method = "D03AC0BBDC876ABF7B349DD16EF958FD")
        public void getChars(int start, int end, char[] dest, int off) {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.506 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.523 -0400", hash_original_method = "CAA9811C5358881331EB71A9EC7C0C0E", hash_generated_method = "D7FD18C185DDF616159BDB6EC24D122B")
        public  SpannedReplacementCharSequence(Spanned source, char[] original,
                                              char[] replacement) {
            super(source, original, replacement);
            mSpanned = source;
            addTaint(original[0]);
            addTaint(replacement[0]);
            // ---------- Original Method ----------
            //mSpanned = source;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.523 -0400", hash_original_method = "C46F3FF4F9C2D4E0959AE37E95AA6C52", hash_generated_method = "E26B9273319D47EDDA9FD8F74AD1B79A")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_345610755 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_345610755 = new SpannedString(this).subSequence(start, end);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_345610755.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_345610755;
            // ---------- Original Method ----------
            //return new SpannedString(this).subSequence(start, end);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.524 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "E9680CFF03B6E3FE70BCA81884E55F8F")
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_224043532 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_224043532 = mSpanned.getSpans(start, end, type);
            addTaint(start);
            addTaint(end);
            addTaint(type.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_224043532.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_224043532;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.525 -0400", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "1F5E74B2A785D0ACDC18F0834D4A9E14")
        public int getSpanStart(Object tag) {
            int varD7924E7B7A12FA5A3B050A8325F5D9BE_13907602 = (mSpanned.getSpanStart(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521595054 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521595054;
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.526 -0400", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "37106CEBFD17A6DEE7A9D98A358D8BA3")
        public int getSpanEnd(Object tag) {
            int varFDD9D023F9FB8A63C470934B7C2E8224_1180698360 = (mSpanned.getSpanEnd(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041273728 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041273728;
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.527 -0400", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "1D2685F000A960CCE4096691CE4312DA")
        public int getSpanFlags(Object tag) {
            int var689A4E26E56E6EC55263E3776149ED4A_935467522 = (mSpanned.getSpanFlags(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051006090 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051006090;
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.527 -0400", hash_original_method = "0259540B9EDC3EBDD85F9EA3B2A19C33", hash_generated_method = "2A5229BA6DF8C941C870D44053275C78")
        public int nextSpanTransition(int start, int end, Class type) {
            int var5119F035B8E56D52F8F813C80B67C353_1477457869 = (mSpanned.nextSpanTransition(start, end, type));
            addTaint(start);
            addTaint(end);
            addTaint(type.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348351372 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348351372;
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, end, type);
        }

        
    }


    
}

