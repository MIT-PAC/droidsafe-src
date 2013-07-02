package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Handler;
import android.os.SystemClock;
import android.graphics.Rect;
import android.view.View;
import android.text.Editable;
import android.text.GetChars;
import android.text.NoCopySpan;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.Selection;
import android.text.Spanned;
import android.text.Spannable;
import android.text.style.UpdateLayout;
import java.lang.ref.WeakReference;

public class PasswordTransformationMethod implements TransformationMethod, TextWatcher {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.349 -0400", hash_original_method = "D8EF6B070A80A550C154BD7630CF21E0", hash_generated_method = "D8EF6B070A80A550C154BD7630CF21E0")
    public PasswordTransformationMethod ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.350 -0400", hash_original_method = "46C31F1840FDB44A1F40EC87B2DB5960", hash_generated_method = "4771AA5725C9B4E7D0D4347C56D127F2")
    public CharSequence getTransformation(CharSequence source, View view) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_981359392 = null; 
        {
            Spannable sp = (Spannable) source;
            ViewReference[] vr = sp.getSpans(0, sp.length(),
                                             ViewReference.class);
            {
                int i = 0;
                {
                    sp.removeSpan(vr[i]);
                } 
            } 
            removeVisibleSpans(sp);
            sp.setSpan(new ViewReference(view), 0, 0,
                       Spannable.SPAN_POINT_POINT);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_981359392 = new PasswordCharSequence(source);
        addTaint(source.getTaint());
        addTaint(view.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_981359392.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_981359392;
        
        
            
            
                                             
            
                
            
            
            
                       
        
        
    }

    
    public static PasswordTransformationMethod getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new PasswordTransformationMethod();
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.351 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "D46551DFD7C1F01B7CC6C2850BBA7577")
    public void beforeTextChanged(CharSequence s, int start,
                                  int count, int after) {
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(count);
        addTaint(after);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.351 -0400", hash_original_method = "E9233B27956FDFC70D77F5557A52BB47", hash_generated_method = "1AA7773B00C3CA80EF00CCBF7D8AD44C")
    public void onTextChanged(CharSequence s, int start,
                              int before, int count) {
        
        {
            Spannable sp = (Spannable) s;
            ViewReference[] vr = sp.getSpans(0, s.length(),
                                             ViewReference.class);
            View v = null;
            {
                int i = 0;
                {
                    v = vr[i].get();
                } 
            } 
            int pref = TextKeyListener.getInstance().getPrefs(v.getContext());
            {
                {
                    removeVisibleSpans(sp);
                    {
                        sp.setSpan(new Visible(sp, this), start, start + count,
                                   Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } 
                } 
            } 
        } 
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(count);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.352 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B1E73F6E6A3A9E89AEF9681CB19F89E5")
    public void afterTextChanged(Editable s) {
        addTaint(s.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.352 -0400", hash_original_method = "D64B8AB73A1F5CA65D62622D3C82E686", hash_generated_method = "CAD03482B712B19E777303DA29E90C67")
    public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        
        {
            {
                Spannable sp = (Spannable) sourceText;
                removeVisibleSpans(sp);
            } 
        } 
        addTaint(view.getTaint());
        addTaint(sourceText.getTaint());
        addTaint(focused);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        
        
            
                
                
            
        
    }

    
    private static void removeVisibleSpans(Spannable sp) {
        Visible[] old = sp.getSpans(0, sp.length(), Visible.class);
        for (int i = 0; i < old.length; i++) {
            sp.removeSpan(old[i]);
        }
    }

    
    private static class PasswordCharSequence implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.353 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.353 -0400", hash_original_method = "4CDD8381D1031BF5EFE2F94225E565AD", hash_generated_method = "FCA0359EE87C92DA7B42CDF7637C2563")
        public  PasswordCharSequence(CharSequence source) {
            mSource = source;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.354 -0400", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "95FB1E19A157F86E0227A8455703F803")
        public int length() {
            int var2AA1AAF84029D80557A421966334F312_1691387499 = (mSource.length());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567841780 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567841780;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.354 -0400", hash_original_method = "9EC5613B57D481274808D46BD66F08EC", hash_generated_method = "64F92DC7ED386677A9601F1D1C779FAC")
        public char charAt(int i) {
            {
                Spanned sp = (Spanned) mSource;
                int st = sp.getSpanStart(TextKeyListener.ACTIVE);
                int en = sp.getSpanEnd(TextKeyListener.ACTIVE);
                {
                    char var6112E6DEEAE6AD91FDB07D187D2DFF90_871269400 = (mSource.charAt(i));
                } 
                Visible[] visible = sp.getSpans(0, sp.length(), Visible.class);
                {
                    int a = 0;
                    {
                        {
                            boolean varA38F6BE6106024039E91E5A25B2BB2AE_2012367001 = (sp.getSpanStart(visible[a].mTransformer) >= 0);
                            {
                                st = sp.getSpanStart(visible[a]);
                                en = sp.getSpanEnd(visible[a]);
                                {
                                    char var7E935A3165243495E0C8BCA90A6554E7_1294931629 = (mSource.charAt(i));
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            addTaint(i);
            char varA87DEB01C5F539E6BDA34829C8EF2368_108919460 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_108919460;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.355 -0400", hash_original_method = "D736D7B90470DFC8C923D4B5D62B4D1D", hash_generated_method = "A5274150F4E7216AD983AF4DC2CC96DA")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_517238050 = null; 
            char[] buf = new char[end - start];
            getChars(start, end, buf, 0);
            varB4EAC82CA7396A68D541C85D26508E83_517238050 = new String(buf);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_517238050.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_517238050;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.355 -0400", hash_original_method = "814020AAFF189164368E5EE6B0F105D9", hash_generated_method = "C2AAE841A4A043D97B9EC2E64ADDF8CE")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_499911609 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_499911609 = subSequence(0, length()).toString();
            varB4EAC82CA7396A68D541C85D26508E83_499911609.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_499911609;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.356 -0400", hash_original_method = "B2B91CFAAB9E07A038BB0750D42A99E3", hash_generated_method = "14C34916E27BFA66A636191CCF7129BA")
        public void getChars(int start, int end, char[] dest, int off) {
            TextUtils.getChars(mSource, start, end, dest, off);
            int st = -1;
            int en = -1;
            int nvisible = 0;
            int[] starts = null;
            int[] ends = null;
            {
                Spanned sp = (Spanned) mSource;
                st = sp.getSpanStart(TextKeyListener.ACTIVE);
                en = sp.getSpanEnd(TextKeyListener.ACTIVE);
                Visible[] visible = sp.getSpans(0, sp.length(), Visible.class);
                nvisible = visible.length;
                starts = new int[nvisible];
                ends = new int[nvisible];
                {
                    int i = 0;
                    {
                        {
                            boolean varA2E72F20236EC480EA6F6CE8DA1A4C9E_1353009999 = (sp.getSpanStart(visible[i].mTransformer) >= 0);
                            {
                                starts[i] = sp.getSpanStart(visible[i]);
                                ends[i] = sp.getSpanEnd(visible[i]);
                            } 
                        } 
                    } 
                } 
            } 
            {
                int i = start;
                {
                    {
                        boolean visible = false;
                        {
                            int a = 0;
                            {
                                {
                                    visible = true;
                                } 
                            } 
                        } 
                        {
                            dest[i - start + off] = DOT;
                        } 
                    } 
                } 
            } 
            addTaint(start);
            addTaint(end);
            addTaint(dest[0]);
            addTaint(off);
            
            
        }

        
    }


    
    private static class Visible extends Handler implements UpdateLayout, Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.356 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "9BDF71D4F7023B7CA73EE663EDAF283F")

        private Spannable mText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.356 -0400", hash_original_field = "61FB95124568F7A434DEA5AA0096E365", hash_generated_field = "ACBDFE8CB9902234B1CF9642C13663A8")

        private PasswordTransformationMethod mTransformer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.357 -0400", hash_original_method = "FF4274DAFF106899CDED6A946D5BF028", hash_generated_method = "F683F9098D8C1A03C876251A84ADB628")
        public  Visible(Spannable sp, PasswordTransformationMethod ptm) {
            mText = sp;
            mTransformer = ptm;
            postAtTime(this, SystemClock.uptimeMillis() + 1500);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.357 -0400", hash_original_method = "C8775617BEE64680D27DACE05ECB8A14", hash_generated_method = "CA165B97F3ECA7B262668016C7A9F1A7")
        public void run() {
            mText.removeSpan(this);
            
            
        }

        
    }


    
    private static class ViewReference extends WeakReference<View> implements NoCopySpan {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.357 -0400", hash_original_method = "8A425A895F2F15617289F8E7C481E0F9", hash_generated_method = "D83E3686AEBB4F4A1C147F503B454C57")
        public  ViewReference(View v) {
            super(v);
            addTaint(v.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.357 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "1FFE1A33712E744FBA36248DA7E399EB")

    private static PasswordTransformationMethod sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.357 -0400", hash_original_field = "AF809F6FE46B3A7862692317388406A1", hash_generated_field = "C2C57B7CF6BBB168D84B800403D461E8")

    private static char DOT = '\u2022';
}

