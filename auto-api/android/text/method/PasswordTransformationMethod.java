package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static PasswordTransformationMethod sInstance;
    private static char DOT = '\u2022';
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.100 -0400", hash_original_method = "46C31F1840FDB44A1F40EC87B2DB5960", hash_generated_method = "82DB5FC409FA0A8865C3353125958279")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.100 -0400", hash_original_method = "AA586779493D0903CD5D98EFA63FCB15", hash_generated_method = "15A79EC119B711DE3CE66CEF2A96A5AC")
    public static PasswordTransformationMethod getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new PasswordTransformationMethod();
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.100 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "793050964D08C1174D57F8F1A6A4BBD2")
    @DSModeled(DSC.SAFE)
    public void beforeTextChanged(CharSequence s, int start,
                                  int count, int after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(s);
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.100 -0400", hash_original_method = "E9233B27956FDFC70D77F5557A52BB47", hash_generated_method = "4A812A05881FE267653F15EBF16D77A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onTextChanged(CharSequence s, int start,
                              int before, int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(s);
        dsTaint.addTaint(count);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.100 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "70C7C3A423EAFEF222D7D6A3D8B2625A")
    @DSModeled(DSC.SAFE)
    public void afterTextChanged(Editable s) {
        dsTaint.addTaint(s.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.100 -0400", hash_original_method = "D64B8AB73A1F5CA65D62622D3C82E686", hash_generated_method = "E84C039388E31CC2389B2162777705D7")
    @DSModeled(DSC.SAFE)
    public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(sourceText);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.100 -0400", hash_original_method = "6C010EB424FCB8CA68C1612A5903637F", hash_generated_method = "164DA6C47BD2D6A76ADCAD98E5918974")
    private static void removeVisibleSpans(Spannable sp) {
        Visible[] old = sp.getSpans(0, sp.length(), Visible.class);
        for (int i = 0; i < old.length; i++) {
            sp.removeSpan(old[i]);
        }
    }

    
    private static class PasswordCharSequence implements CharSequence, GetChars {
        private CharSequence mSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.100 -0400", hash_original_method = "4CDD8381D1031BF5EFE2F94225E565AD", hash_generated_method = "A598D99C5B7C2F8526FA224D2B934D1E")
        @DSModeled(DSC.SAFE)
        public PasswordCharSequence(CharSequence source) {
            dsTaint.addTaint(source);
            // ---------- Original Method ----------
            //mSource = source;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.100 -0400", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "552DBA7FCF9B32CAC348EE560D01A842")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int length() {
            int var2AA1AAF84029D80557A421966334F312_1662681599 = (mSource.length());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSource.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.101 -0400", hash_original_method = "9EC5613B57D481274808D46BD66F08EC", hash_generated_method = "78EDF1B570EF1513924779420ADBF680")
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
                    char var6112E6DEEAE6AD91FDB07D187D2DFF90_734973756 = (mSource.charAt(i));
                } //End block
                Visible[] visible;
                visible = sp.getSpans(0, sp.length(), Visible.class);
                {
                    int a;
                    a = 0;
                    {
                        {
                            boolean varA38F6BE6106024039E91E5A25B2BB2AE_1513441577 = (sp.getSpanStart(visible[a].mTransformer) >= 0);
                            {
                                st = sp.getSpanStart(visible[a]);
                                en = sp.getSpanEnd(visible[a]);
                                {
                                    char var7E935A3165243495E0C8BCA90A6554E7_1339706831 = (mSource.charAt(i));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.101 -0400", hash_original_method = "D736D7B90470DFC8C923D4B5D62B4D1D", hash_generated_method = "162C046FE4C6BAE15AD02D3466D04192")
        @DSModeled(DSC.SAFE)
        public CharSequence subSequence(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            char[] buf;
            buf = new char[end - start];
            getChars(start, end, buf, 0);
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //char[] buf = new char[end - start];
            //getChars(start, end, buf, 0);
            //return new String(buf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.101 -0400", hash_original_method = "814020AAFF189164368E5EE6B0F105D9", hash_generated_method = "673E983B8A87DAAA996829329314C641")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String var78AE35A7CE977CC9C9EE2DE46784539E_1270211574 = (subSequence(0, length()).toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return subSequence(0, length()).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.102 -0400", hash_original_method = "B2B91CFAAB9E07A038BB0750D42A99E3", hash_generated_method = "0E974B66737DF2426A57376415A4A995")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void getChars(int start, int end, char[] dest, int off) {
            dsTaint.addTaint(dest);
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
                            boolean varA2E72F20236EC480EA6F6CE8DA1A4C9E_380033086 = (sp.getSpanStart(visible[i].mTransformer) >= 0);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.102 -0400", hash_original_method = "FF4274DAFF106899CDED6A946D5BF028", hash_generated_method = "FB51D797A6639BA7C83C72DF59E03A94")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.102 -0400", hash_original_method = "C8775617BEE64680D27DACE05ECB8A14", hash_generated_method = "87003883AA3E19B380469DB059C3E8A3")
        @DSModeled(DSC.SAFE)
        public void run() {
            mText.removeSpan(this);
            // ---------- Original Method ----------
            //mText.removeSpan(this);
        }

        
    }


    
    private static class ViewReference extends WeakReference<View> implements NoCopySpan {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.102 -0400", hash_original_method = "8A425A895F2F15617289F8E7C481E0F9", hash_generated_method = "3A9668FAEEF6ECC8B0E00132E7D202C4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ViewReference(View v) {
            super(v);
            dsTaint.addTaint(v.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
}


