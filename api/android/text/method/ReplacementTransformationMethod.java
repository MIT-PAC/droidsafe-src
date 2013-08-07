package android.text.method;

// Droidsafe Imports
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
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.683 -0400", hash_original_method = "1B7B28F98DAC94187572CC248AC52BB7", hash_generated_method = "1B7B28F98DAC94187572CC248AC52BB7")
    public ReplacementTransformationMethod ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    protected abstract char[] getOriginal();

    
    @DSModeled(DSC.SAFE)
    protected abstract char[] getReplacement();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.685 -0400", hash_original_method = "194DC730C60A1F45F368AD90A104F0FE", hash_generated_method = "3F7AA177DC4A4B0031A700470B2837BD")
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
CharSequence var87D92E4D22D3928BDE6A72969186AF86_1836585518 =                 source;
                var87D92E4D22D3928BDE6A72969186AF86_1836585518.addTaint(taint);
                return var87D92E4D22D3928BDE6A72969186AF86_1836585518;
            } //End block
            if(!(source instanceof Spannable))            
            {
                if(source instanceof Spanned)                
                {
CharSequence var9E7570C979D39715F7EE038B1A45D20D_1920438031 =                     new SpannedString(new SpannedReplacementCharSequence(
                                                        (Spanned) source,
                                                        original, replacement));
                    var9E7570C979D39715F7EE038B1A45D20D_1920438031.addTaint(taint);
                    return var9E7570C979D39715F7EE038B1A45D20D_1920438031;
                } //End block
                else
                {
CharSequence varF85F8A286DE5E8F9739D0C80DF338810_1006833850 =                     new ReplacementCharSequence(source,
                                                       original,
                                                       replacement).toString();
                    varF85F8A286DE5E8F9739D0C80DF338810_1006833850.addTaint(taint);
                    return varF85F8A286DE5E8F9739D0C80DF338810_1006833850;
                } //End block
            } //End block
        } //End block
        if(source instanceof Spanned)        
        {
CharSequence var0A88A6362D54875F6CD556A667CEC802_151924485 =             new SpannedReplacementCharSequence((Spanned) source,
                                                      original, replacement);
            var0A88A6362D54875F6CD556A667CEC802_151924485.addTaint(taint);
            return var0A88A6362D54875F6CD556A667CEC802_151924485;
        } //End block
        else
        {
CharSequence varCD506DB4E74DA4B564FA03112F99BB17_145110673 =             new ReplacementCharSequence(source, original, replacement);
            varCD506DB4E74DA4B564FA03112F99BB17_145110673.addTaint(taint);
            return varCD506DB4E74DA4B564FA03112F99BB17_145110673;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.687 -0400", hash_original_method = "13D8211EBDC6D4196EF2DDB70ED5CACD", hash_generated_method = "F6B7EB031AD974B960E9E01380665FE1")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.688 -0400", hash_original_field = "8526EC2FF812D96CA9274ACA8998FC20", hash_generated_field = "FC1254D314CD4AAE23C5354189DEA616")

        private char[] mOriginal;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.688 -0400", hash_original_field = "05B11DD59B8E9A2C20387164079C6C37", hash_generated_field = "82418157EFFFE0C2D72794E96D9A0F0E")

        private char[] mReplacement;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.688 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.689 -0400", hash_original_method = "F89FC48B18F547DBB1705366EEF3AC7C", hash_generated_method = "7440FAA0F491D27D7D153C80FF2CC4EE")
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.690 -0400", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "A86838B3F4609228C3B0175662F0BA00")
        public int length() {
            int var9E844678846AA17EBC2ADB2098AEA729_665831049 = (mSource.length());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_100041787 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_100041787;
            // ---------- Original Method ----------
            //return mSource.length();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.691 -0400", hash_original_method = "F5CDEE5D506853CF95A4D9E8A551C716", hash_generated_method = "36AE3F69DD3C5B36FD321C9C2908F9BC")
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
            char var4A8A08F09D37B73795649038408B5F33_1487356660 = (c);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1031291291 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1031291291;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.691 -0400", hash_original_method = "16B48B66F40BC5C2F3D95D2C2FC575C8", hash_generated_method = "B465125DBEF7AB3DB660A81A5F5DED15")
        public CharSequence subSequence(int start, int end) {
            addTaint(end);
            addTaint(start);
            char[] c = new char[end - start];
            getChars(start, end, c, 0);
CharSequence varB221E45F434F915AFB96577CA5936EA6_1626842987 =             new String(c);
            varB221E45F434F915AFB96577CA5936EA6_1626842987.addTaint(taint);
            return varB221E45F434F915AFB96577CA5936EA6_1626842987;
            // ---------- Original Method ----------
            //char[] c = new char[end - start];
            //getChars(start, end, c, 0);
            //return new String(c);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.692 -0400", hash_original_method = "C6C9F4F28222CB23CDD8D19463D6DD00", hash_generated_method = "EE3F51595888ABCB8A043B0147A6D4DF")
        public String toString() {
            char[] c = new char[length()];
            getChars(0, length(), c, 0);
String varB221E45F434F915AFB96577CA5936EA6_1060617736 =             new String(c);
            varB221E45F434F915AFB96577CA5936EA6_1060617736.addTaint(taint);
            return varB221E45F434F915AFB96577CA5936EA6_1060617736;
            // ---------- Original Method ----------
            //char[] c = new char[length()];
            //getChars(0, length(), c, 0);
            //return new String(c);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.692 -0400", hash_original_method = "296CE0E87E188E4485863573C8375539", hash_generated_method = "B804FF7FEB807AF660AA728EA5370F61")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.693 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.693 -0400", hash_original_method = "CAA9811C5358881331EB71A9EC7C0C0E", hash_generated_method = "5950D708106BF6DE3B32B87F9AA6BC2A")
        public  SpannedReplacementCharSequence(Spanned source, char[] original,
                                              char[] replacement) {
            super(source, original, replacement);
            addTaint(replacement[0]);
            addTaint(original[0]);
            mSpanned = source;
            // ---------- Original Method ----------
            //mSpanned = source;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.694 -0400", hash_original_method = "C46F3FF4F9C2D4E0959AE37E95AA6C52", hash_generated_method = "7FBF4E39156FDF79D02D8974428A8135")
        public CharSequence subSequence(int start, int end) {
            addTaint(end);
            addTaint(start);
CharSequence varE28690A64C217C05112E541C85F69946_862224860 =             new SpannedString(this).subSequence(start, end);
            varE28690A64C217C05112E541C85F69946_862224860.addTaint(taint);
            return varE28690A64C217C05112E541C85F69946_862224860;
            // ---------- Original Method ----------
            //return new SpannedString(this).subSequence(start, end);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.694 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "758D85525E0EBDD586EED24B4A89DE1C")
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            addTaint(type.getTaint());
            addTaint(end);
            addTaint(start);
T[] varF03F51B4D510CEB709FCAEAB771CF011_117357119 =             mSpanned.getSpans(start, end, type);
            varF03F51B4D510CEB709FCAEAB771CF011_117357119.addTaint(taint);
            return varF03F51B4D510CEB709FCAEAB771CF011_117357119;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.695 -0400", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "8DF963A663EBDEB1A1248E4830BABF40")
        public int getSpanStart(Object tag) {
            addTaint(tag.getTaint());
            int var800F360D0EFE39368ED5E50C7D513A55_553880003 = (mSpanned.getSpanStart(tag));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1721053925 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1721053925;
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(tag);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.695 -0400", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "C36984062F596714E5EBF8F99D7D6D60")
        public int getSpanEnd(Object tag) {
            addTaint(tag.getTaint());
            int var7238B1DBF5539E6FFFB0C5533E719DCF_1631684308 = (mSpanned.getSpanEnd(tag));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295706081 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295706081;
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(tag);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.696 -0400", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "15FAFDC9B4AC5E8BD3C607E643283FC7")
        public int getSpanFlags(Object tag) {
            addTaint(tag.getTaint());
            int var55E53B9FA7449A4A00466336ED252163_647553437 = (mSpanned.getSpanFlags(tag));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693031569 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693031569;
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(tag);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.697 -0400", hash_original_method = "0259540B9EDC3EBDD85F9EA3B2A19C33", hash_generated_method = "4A2E6EB3EE4781E862107A77EF81F68B")
        public int nextSpanTransition(int start, int end, Class type) {
            addTaint(type.getTaint());
            addTaint(end);
            addTaint(start);
            int var69794DFBCD367E9F529E44E71CBFF48F_392944131 = (mSpanned.nextSpanTransition(start, end, type));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59514497 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59514497;
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, end, type);
        }

        
    }


    
}

