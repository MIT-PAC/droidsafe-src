package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.text.Editable;
import android.text.GetChars;
import android.text.Spannable;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.view.View;

public abstract class ReplacementTransformationMethod implements TransformationMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.899 -0400", hash_original_method = "1B7B28F98DAC94187572CC248AC52BB7", hash_generated_method = "1B7B28F98DAC94187572CC248AC52BB7")
    public ReplacementTransformationMethod ()
    {
        //Synthesized constructor
    }


    protected abstract char[] getOriginal();

    
    protected abstract char[] getReplacement();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.900 -0400", hash_original_method = "194DC730C60A1F45F368AD90A104F0FE", hash_generated_method = "D4A5BF3DABADE06EF1E9551501B369E7")
    public CharSequence getTransformation(CharSequence source, View v) {
        addTaint(v.getTaint());
        addTaint(source.getTaint());
        char[] original = getOriginal();
        char[] replacement = getReplacement();
    if(!(source instanceof Editable))        
        {
            boolean doNothing = true;
            int n = original.length;
for(int i = 0;i < n;i++)
            {
    if(TextUtils.indexOf(source, original[i]) >= 0)                
                {
                    doNothing = false;
                    break;
                } //End block
            } //End block
    if(doNothing)            
            {
CharSequence var87D92E4D22D3928BDE6A72969186AF86_297558527 =                 source;
                var87D92E4D22D3928BDE6A72969186AF86_297558527.addTaint(taint);
                return var87D92E4D22D3928BDE6A72969186AF86_297558527;
            } //End block
    if(!(source instanceof Spannable))            
            {
    if(source instanceof Spanned)                
                {
CharSequence var9E7570C979D39715F7EE038B1A45D20D_510698981 =                     new SpannedString(new SpannedReplacementCharSequence(
                                                        (Spanned) source,
                                                        original, replacement));
                    var9E7570C979D39715F7EE038B1A45D20D_510698981.addTaint(taint);
                    return var9E7570C979D39715F7EE038B1A45D20D_510698981;
                } //End block
                else
                {
CharSequence varF85F8A286DE5E8F9739D0C80DF338810_971015473 =                     new ReplacementCharSequence(source,
                                                       original,
                                                       replacement).toString();
                    varF85F8A286DE5E8F9739D0C80DF338810_971015473.addTaint(taint);
                    return varF85F8A286DE5E8F9739D0C80DF338810_971015473;
                } //End block
            } //End block
        } //End block
    if(source instanceof Spanned)        
        {
CharSequence var0A88A6362D54875F6CD556A667CEC802_1033734766 =             new SpannedReplacementCharSequence((Spanned) source,
                                                      original, replacement);
            var0A88A6362D54875F6CD556A667CEC802_1033734766.addTaint(taint);
            return var0A88A6362D54875F6CD556A667CEC802_1033734766;
        } //End block
        else
        {
CharSequence varCD506DB4E74DA4B564FA03112F99BB17_1907547577 =             new ReplacementCharSequence(source, original, replacement);
            varCD506DB4E74DA4B564FA03112F99BB17_1907547577.addTaint(taint);
            return varCD506DB4E74DA4B564FA03112F99BB17_1907547577;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.901 -0400", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "F6B7EB031AD974B960E9E01380665FE1")
    public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(focused);
        addTaint(sourceText.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    private static class ReplacementCharSequence implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.901 -0400", hash_original_field = "8526EC2FF812D96CA9274ACA8998FC20", hash_generated_field = "FC1254D314CD4AAE23C5354189DEA616")

        private char[] mOriginal;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.901 -0400", hash_original_field = "05B11DD59B8E9A2C20387164079C6C37", hash_generated_field = "82418157EFFFE0C2D72794E96D9A0F0E")

        private char[] mReplacement;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.901 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.902 -0400", hash_original_method = "F89FC48B18F547DBB1705366EEF3AC7C", hash_generated_method = "7440FAA0F491D27D7D153C80FF2CC4EE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.902 -0400", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "6FA971910968BB408E8DD8E9CAA3FE8F")
        public int length() {
            int var9E844678846AA17EBC2ADB2098AEA729_230838726 = (mSource.length());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681744191 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681744191;
            // ---------- Original Method ----------
            //return mSource.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.902 -0400", hash_original_method = "F5CDEE5D506853CF95A4D9E8A551C716", hash_generated_method = "2783DFA7C82FF947182ED75EBFD745D6")
        public char charAt(int i) {
            addTaint(i);
            char c = mSource.charAt(i);
            int n = mOriginal.length;
for(int j = 0;j < n;j++)
            {
    if(c == mOriginal[j])                
                {
                    c = mReplacement[j];
                } //End block
            } //End block
            char var4A8A08F09D37B73795649038408B5F33_551565862 = (c);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1304563526 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1304563526;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.903 -0400", hash_original_method = "16B48B66F40BC5C2F3D95D2C2FC575C8", hash_generated_method = "EFCA1027956DBE2F75F8A3F9086D60A6")
        public CharSequence subSequence(int start, int end) {
            addTaint(end);
            addTaint(start);
            char[] c = new char[end - start];
            getChars(start, end, c, 0);
CharSequence varB221E45F434F915AFB96577CA5936EA6_1900545842 =             new String(c);
            varB221E45F434F915AFB96577CA5936EA6_1900545842.addTaint(taint);
            return varB221E45F434F915AFB96577CA5936EA6_1900545842;
            // ---------- Original Method ----------
            //char[] c = new char[end - start];
            //getChars(start, end, c, 0);
            //return new String(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.903 -0400", hash_original_method = "C6C9F4F28222CB23CDD8D19463D6DD00", hash_generated_method = "B36A50811D881931BADC29A2A96EFE60")
        public String toString() {
            char[] c = new char[length()];
            getChars(0, length(), c, 0);
String varB221E45F434F915AFB96577CA5936EA6_352666195 =             new String(c);
            varB221E45F434F915AFB96577CA5936EA6_352666195.addTaint(taint);
            return varB221E45F434F915AFB96577CA5936EA6_352666195;
            // ---------- Original Method ----------
            //char[] c = new char[length()];
            //getChars(0, length(), c, 0);
            //return new String(c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.904 -0400", hash_original_method = "296CE0E87E188E4485863573C8375539", hash_generated_method = "B804FF7FEB807AF660AA728EA5370F61")
        public void getChars(int start, int end, char[] dest, int off) {
            addTaint(off);
            addTaint(dest[0]);
            addTaint(end);
            addTaint(start);
            TextUtils.getChars(mSource, start, end, dest, off);
            int offend = end - start + off;
            int n = mOriginal.length;
for(int i = off;i < offend;i++)
            {
                char c = dest[i];
for(int j = 0;j < n;j++)
                {
    if(c == mOriginal[j])                    
                    {
                        dest[i] = mReplacement[j];
                    } //End block
                } //End block
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.905 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.905 -0400", hash_original_method = "CAA9811C5358881331EB71A9EC7C0C0E", hash_generated_method = "5950D708106BF6DE3B32B87F9AA6BC2A")
        public  SpannedReplacementCharSequence(Spanned source, char[] original,
                                              char[] replacement) {
            super(source, original, replacement);
            addTaint(replacement[0]);
            addTaint(original[0]);
            mSpanned = source;
            // ---------- Original Method ----------
            //mSpanned = source;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.905 -0400", hash_original_method = "C46F3FF4F9C2D4E0959AE37E95AA6C52", hash_generated_method = "C752E2DD80E4B8B5CC92F21BF67BD4B5")
        public CharSequence subSequence(int start, int end) {
            addTaint(end);
            addTaint(start);
CharSequence varE28690A64C217C05112E541C85F69946_980270610 =             new SpannedString(this).subSequence(start, end);
            varE28690A64C217C05112E541C85F69946_980270610.addTaint(taint);
            return varE28690A64C217C05112E541C85F69946_980270610;
            // ---------- Original Method ----------
            //return new SpannedString(this).subSequence(start, end);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.906 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "4B5A7989958696ABBE610F78ECCC65DF")
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            addTaint(type.getTaint());
            addTaint(end);
            addTaint(start);
T[] varF03F51B4D510CEB709FCAEAB771CF011_1458673821 =             mSpanned.getSpans(start, end, type);
            varF03F51B4D510CEB709FCAEAB771CF011_1458673821.addTaint(taint);
            return varF03F51B4D510CEB709FCAEAB771CF011_1458673821;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.906 -0400", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "B63B5C5B53F873FEC6B76898662668A9")
        public int getSpanStart(Object tag) {
            addTaint(tag.getTaint());
            int var800F360D0EFE39368ED5E50C7D513A55_424013490 = (mSpanned.getSpanStart(tag));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652244404 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652244404;
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.906 -0400", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "4A3F4F530959AC31D0BD5ED3A3BF99BC")
        public int getSpanEnd(Object tag) {
            addTaint(tag.getTaint());
            int var7238B1DBF5539E6FFFB0C5533E719DCF_941980489 = (mSpanned.getSpanEnd(tag));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437591639 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437591639;
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.907 -0400", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "3536B8543DAA97C00134D78FB54431A1")
        public int getSpanFlags(Object tag) {
            addTaint(tag.getTaint());
            int var55E53B9FA7449A4A00466336ED252163_70781273 = (mSpanned.getSpanFlags(tag));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_158295982 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_158295982;
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.907 -0400", hash_original_method = "0259540B9EDC3EBDD85F9EA3B2A19C33", hash_generated_method = "C1B481FF44B0E47E35956C45C4055E5D")
        public int nextSpanTransition(int start, int end, Class type) {
            addTaint(type.getTaint());
            addTaint(end);
            addTaint(start);
            int var69794DFBCD367E9F529E44E71CBFF48F_1365474931 = (mSpanned.nextSpanTransition(start, end, type));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363182445 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363182445;
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, end, type);
        }

        
    }


    
}

