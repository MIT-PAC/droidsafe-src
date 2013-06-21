package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.534 -0400", hash_original_method = "CA057484861C427726D716A4E12EC2E3", hash_generated_method = "CA057484861C427726D716A4E12EC2E3")
        public PasswordTransformationMethod ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.535 -0400", hash_original_method = "46C31F1840FDB44A1F40EC87B2DB5960", hash_generated_method = "25B0799276DB695D34A68E66244BC688")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTransformation(CharSequence source, View view) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(view.dsTaint);
        {
            Spannable sp;
            sp = (Spannable) source;
            ViewReference[] vr;
            vr = sp.getSpans(0, sp.length(),
                                             ViewReference.class);
            {
                int i;
                i = 0;
                {
                    sp.removeSpan(vr[i]);
                } //End block
            } //End collapsed parenthetic
            removeVisibleSpans(sp);
            sp.setSpan(new ViewReference(view), 0, 0,
                       Spannable.SPAN_POINT_POINT);
        } //End block
        CharSequence var5BB8260899EF3411D8339398038E781A_721960318 = (new PasswordCharSequence(source));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (source instanceof Spannable) {
            //Spannable sp = (Spannable) source;
            //ViewReference[] vr = sp.getSpans(0, sp.length(),
                                             //ViewReference.class);
            //for (int i = 0; i < vr.length; i++) {
                //sp.removeSpan(vr[i]);
            //}
            //removeVisibleSpans(sp);
            //sp.setSpan(new ViewReference(view), 0, 0,
                       //Spannable.SPAN_POINT_POINT);
        //}
        //return new PasswordCharSequence(source);
    }

    
        public static PasswordTransformationMethod getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new PasswordTransformationMethod();
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.535 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "6037A3A1E287DC3D909FC0A30E71C281")
    @DSModeled(DSC.SAFE)
    public void beforeTextChanged(CharSequence s, int start,
                                  int count, int after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(count);
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.542 -0400", hash_original_method = "E9233B27956FDFC70D77F5557A52BB47", hash_generated_method = "AA057ABBD102CF576BAD0D19161A8A74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onTextChanged(CharSequence s, int start,
                              int before, int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(count);
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(before);
        {
            Spannable sp;
            sp = (Spannable) s;
            ViewReference[] vr;
            vr = sp.getSpans(0, s.length(),
                                             ViewReference.class);
            View v;
            v = null;
            {
                int i;
                i = 0;
                {
                    v = vr[i].get();
                } //End block
            } //End collapsed parenthetic
            int pref;
            pref = TextKeyListener.getInstance().getPrefs(v.getContext());
            {
                {
                    removeVisibleSpans(sp);
                    {
                        sp.setSpan(new Visible(sp, this), start, start + count,
                                   Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.542 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "E1E9B48623236A758AA5D88D665C2448")
    @DSModeled(DSC.SAFE)
    public void afterTextChanged(Editable s) {
        dsTaint.addTaint(s.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.543 -0400", hash_original_method = "D64B8AB73A1F5CA65D62622D3C82E686", hash_generated_method = "89D725477DB913D5FA3A72AF9A394E42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(sourceText);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        dsTaint.addTaint(focused);
        dsTaint.addTaint(view.dsTaint);
        {
            {
                Spannable sp;
                sp = (Spannable) sourceText;
                removeVisibleSpans(sp);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!focused) {
            //if (sourceText instanceof Spannable) {
                //Spannable sp = (Spannable) sourceText;
                //removeVisibleSpans(sp);
            //}
        //}
    }

    
        private static void removeVisibleSpans(Spannable sp) {
        Visible[] old = sp.getSpans(0, sp.length(), Visible.class);
        for (int i = 0; i < old.length; i++) {
            sp.removeSpan(old[i]);
        }
    }

    
    private static class PasswordCharSequence implements CharSequence, GetChars {
        private CharSequence mSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.543 -0400", hash_original_method = "4CDD8381D1031BF5EFE2F94225E565AD", hash_generated_method = "BD4DD060B53D8CC7D324572DFAF650D0")
        @DSModeled(DSC.SAFE)
        public PasswordCharSequence(CharSequence source) {
            dsTaint.addTaint(source);
            // ---------- Original Method ----------
            //mSource = source;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.543 -0400", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "92209A5AD727CB6B58E1C0A7842EBCF4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int length() {
            int var2AA1AAF84029D80557A421966334F312_1387299007 = (mSource.length());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSource.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.543 -0400", hash_original_method = "9EC5613B57D481274808D46BD66F08EC", hash_generated_method = "E6C8572BC3C00D8B7B0C7DFACA8C55B7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char charAt(int i) {
            dsTaint.addTaint(i);
            {
                Spanned sp;
                sp = (Spanned) mSource;
                int st;
                st = sp.getSpanStart(TextKeyListener.ACTIVE);
                int en;
                en = sp.getSpanEnd(TextKeyListener.ACTIVE);
                {
                    char var6112E6DEEAE6AD91FDB07D187D2DFF90_568984415 = (mSource.charAt(i));
                } //End block
                Visible[] visible;
                visible = sp.getSpans(0, sp.length(), Visible.class);
                {
                    int a;
                    a = 0;
                    {
                        {
                            boolean varA38F6BE6106024039E91E5A25B2BB2AE_1348878938 = (sp.getSpanStart(visible[a].mTransformer) >= 0);
                            {
                                st = sp.getSpanStart(visible[a]);
                                en = sp.getSpanEnd(visible[a]);
                                {
                                    char var7E935A3165243495E0C8BCA90A6554E7_1174961935 = (mSource.charAt(i));
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.544 -0400", hash_original_method = "D736D7B90470DFC8C923D4B5D62B4D1D", hash_generated_method = "9DEEF512CF09BE37662ACB3F7255CC7E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CharSequence subSequence(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            char[] buf;
            buf = new char[end - start];
            getChars(start, end, buf, 0);
            CharSequence varD058E064058731988E6FE4650A392B5A_1266812180 = (new String(buf));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //char[] buf = new char[end - start];
            //getChars(start, end, buf, 0);
            //return new String(buf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.544 -0400", hash_original_method = "814020AAFF189164368E5EE6B0F105D9", hash_generated_method = "7221D8B463B931AE6CDA3ECD2C0046C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String var78AE35A7CE977CC9C9EE2DE46784539E_1316304269 = (subSequence(0, length()).toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return subSequence(0, length()).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.545 -0400", hash_original_method = "B2B91CFAAB9E07A038BB0750D42A99E3", hash_generated_method = "0BBCA77C0EC6F3184DEF13A9D6CB1EB5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void getChars(int start, int end, char[] dest, int off) {
            dsTaint.addTaint(dest[0]);
            dsTaint.addTaint(start);
            dsTaint.addTaint(off);
            dsTaint.addTaint(end);
            TextUtils.getChars(mSource, start, end, dest, off);
            int st, en;
            st = -1;
            en = -1;
            int nvisible;
            nvisible = 0;
            int[] starts, ends;
            starts = null;
            ends = null;
            {
                Spanned sp;
                sp = (Spanned) mSource;
                st = sp.getSpanStart(TextKeyListener.ACTIVE);
                en = sp.getSpanEnd(TextKeyListener.ACTIVE);
                Visible[] visible;
                visible = sp.getSpans(0, sp.length(), Visible.class);
                nvisible = visible.length;
                starts = new int[nvisible];
                ends = new int[nvisible];
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean varA2E72F20236EC480EA6F6CE8DA1A4C9E_102809831 = (sp.getSpanStart(visible[i].mTransformer) >= 0);
                            {
                                starts[i] = sp.getSpanStart(visible[i]);
                                ends[i] = sp.getSpanEnd(visible[i]);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                int i;
                i = start;
                {
                    {
                        boolean visible;
                        visible = false;
                        {
                            int a;
                            a = 0;
                            {
                                {
                                    visible = true;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        {
                            dest[i - start + off] = DOT;
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class Visible extends Handler implements UpdateLayout, Runnable {
        private Spannable mText;
        private PasswordTransformationMethod mTransformer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.545 -0400", hash_original_method = "FF4274DAFF106899CDED6A946D5BF028", hash_generated_method = "6D80A9C02D38AF8B67AE6DAC8AC2F255")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Visible(Spannable sp, PasswordTransformationMethod ptm) {
            dsTaint.addTaint(sp.dsTaint);
            dsTaint.addTaint(ptm.dsTaint);
            postAtTime(this, SystemClock.uptimeMillis() + 1500);
            // ---------- Original Method ----------
            //mText = sp;
            //mTransformer = ptm;
            //postAtTime(this, SystemClock.uptimeMillis() + 1500);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.545 -0400", hash_original_method = "C8775617BEE64680D27DACE05ECB8A14", hash_generated_method = "CA165B97F3ECA7B262668016C7A9F1A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            mText.removeSpan(this);
            // ---------- Original Method ----------
            //mText.removeSpan(this);
        }

        
    }


    
    private static class ViewReference extends WeakReference<View> implements NoCopySpan {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.545 -0400", hash_original_method = "8A425A895F2F15617289F8E7C481E0F9", hash_generated_method = "39519B149EE6707E82EEF2A8755B4526")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ViewReference(View v) {
            super(v);
            dsTaint.addTaint(v.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static PasswordTransformationMethod sInstance;
    private static char DOT = '\u2022';
}

