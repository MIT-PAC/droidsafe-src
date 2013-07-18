package android.text.method;

// Droidsafe Imports
import java.lang.ref.WeakReference;

import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.GetChars;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.UpdateLayout;
import android.view.View;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PasswordTransformationMethod implements TransformationMethod, TextWatcher {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.520 -0400", hash_original_method = "D8EF6B070A80A550C154BD7630CF21E0", hash_generated_method = "D8EF6B070A80A550C154BD7630CF21E0")
    public PasswordTransformationMethod ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.521 -0400", hash_original_method = "46C31F1840FDB44A1F40EC87B2DB5960", hash_generated_method = "F634E4AED2B8BD30FD26A19DED20A89E")
    public CharSequence getTransformation(CharSequence source, View view) {
        addTaint(view.getTaint());
        addTaint(source.getTaint());
        if(source instanceof Spannable)        
        {
            Spannable sp = (Spannable) source;
            ViewReference[] vr = sp.getSpans(0, sp.length(),
                                             ViewReference.class);
for(int i = 0;i < vr.length;i++)
            {
                sp.removeSpan(vr[i]);
            } //End block
            removeVisibleSpans(sp);
            sp.setSpan(new ViewReference(view), 0, 0,
                       Spannable.SPAN_POINT_POINT);
        } //End block
CharSequence var68111183A5880BCEEE402DC0884C3127_1445109160 =         new PasswordCharSequence(source);
        var68111183A5880BCEEE402DC0884C3127_1445109160.addTaint(taint);
        return var68111183A5880BCEEE402DC0884C3127_1445109160;
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

    
    @DSModeled(DSC.SAFE)
    public static PasswordTransformationMethod getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new PasswordTransformationMethod();
        return sInstance;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.522 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "63445082BCC7E22464CE7B1B497FEB87")
    public void beforeTextChanged(CharSequence s, int start,
                                  int count, int after) {
        addTaint(after);
        addTaint(count);
        addTaint(start);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.523 -0400", hash_original_method = "E9233B27956FDFC70D77F5557A52BB47", hash_generated_method = "4F20B40A16DC180C1EDB2213A1D7D6B5")
    public void onTextChanged(CharSequence s, int start,
                              int before, int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(count);
        addTaint(before);
        addTaint(start);
        addTaint(s.getTaint());
        if(s instanceof Spannable)        
        {
            Spannable sp = (Spannable) s;
            ViewReference[] vr = sp.getSpans(0, s.length(),
                                             ViewReference.class);
            if(vr.length == 0)            
            {
                return;
            } //End block
            View v = null;
for(int i = 0;v == null && i < vr.length;i++)
            {
                v = vr[i].get();
            } //End block
            if(v == null)            
            {
                return;
            } //End block
            int pref = TextKeyListener.getInstance().getPrefs(v.getContext());
            if((pref & TextKeyListener.SHOW_PASSWORD) != 0)            
            {
                if(count > 0)                
                {
                    removeVisibleSpans(sp);
                    if(count == 1)                    
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.524 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B1E73F6E6A3A9E89AEF9681CB19F89E5")
    public void afterTextChanged(Editable s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.524 -0400", hash_original_method = "D64B8AB73A1F5CA65D62622D3C82E686", hash_generated_method = "FAEAA3C6FC2994A1670F5B504938EEBA")
    public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(focused);
        addTaint(sourceText.getTaint());
        addTaint(view.getTaint());
        if(!focused)        
        {
            if(sourceText instanceof Spannable)            
            {
                Spannable sp = (Spannable) sourceText;
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

    
    @DSModeled(DSC.SAFE)
    private static void removeVisibleSpans(Spannable sp) {
        Visible[] old = sp.getSpans(0, sp.length(), Visible.class);
        for (int i = 0; i < old.length; i++) {
            sp.removeSpan(old[i]);
        }
    }

    
    private static class PasswordCharSequence implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.525 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.526 -0400", hash_original_method = "4CDD8381D1031BF5EFE2F94225E565AD", hash_generated_method = "FCA0359EE87C92DA7B42CDF7637C2563")
        public  PasswordCharSequence(CharSequence source) {
            mSource = source;
            // ---------- Original Method ----------
            //mSource = source;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.526 -0400", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "85BB82BF79C1B59473B6C6505F5436AC")
        public int length() {
            int var9E844678846AA17EBC2ADB2098AEA729_2069438750 = (mSource.length());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050910779 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050910779;
            // ---------- Original Method ----------
            //return mSource.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.527 -0400", hash_original_method = "9EC5613B57D481274808D46BD66F08EC", hash_generated_method = "BA4DD4B62DB8BBA4931243E3E4B38520")
        public char charAt(int i) {
            addTaint(i);
            if(mSource instanceof Spanned)            
            {
                Spanned sp = (Spanned) mSource;
                int st = sp.getSpanStart(TextKeyListener.ACTIVE);
                int en = sp.getSpanEnd(TextKeyListener.ACTIVE);
                if(i >= st && i < en)                
                {
                    char var4AC3226952DDE65F5C401654FB7E1305_911227527 = (mSource.charAt(i));
                                        char varA87DEB01C5F539E6BDA34829C8EF2368_1804596990 = getTaintChar();
                    return varA87DEB01C5F539E6BDA34829C8EF2368_1804596990;
                } //End block
                Visible[] visible = sp.getSpans(0, sp.length(), Visible.class);
for(int a = 0;a < visible.length;a++)
                {
                    if(sp.getSpanStart(visible[a].mTransformer) >= 0)                    
                    {
                        st = sp.getSpanStart(visible[a]);
                        en = sp.getSpanEnd(visible[a]);
                        if(i >= st && i < en)                        
                        {
                            char var4AC3226952DDE65F5C401654FB7E1305_417683073 = (mSource.charAt(i));
                                                        char varA87DEB01C5F539E6BDA34829C8EF2368_885488052 = getTaintChar();
                            return varA87DEB01C5F539E6BDA34829C8EF2368_885488052;
                        } //End block
                    } //End block
                } //End block
            } //End block
            char var40679521B5DA0954B705341A2859F782_541504744 = (DOT);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_168334978 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_168334978;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.528 -0400", hash_original_method = "D736D7B90470DFC8C923D4B5D62B4D1D", hash_generated_method = "1E8C30D84279F6B9B98466E7BDD4D6E3")
        public CharSequence subSequence(int start, int end) {
            addTaint(end);
            addTaint(start);
            char[] buf = new char[end - start];
            getChars(start, end, buf, 0);
CharSequence var5B166C4D1D866639CF85033C2F7318C9_1296093723 =             new String(buf);
            var5B166C4D1D866639CF85033C2F7318C9_1296093723.addTaint(taint);
            return var5B166C4D1D866639CF85033C2F7318C9_1296093723;
            // ---------- Original Method ----------
            //char[] buf = new char[end - start];
            //getChars(start, end, buf, 0);
            //return new String(buf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.528 -0400", hash_original_method = "814020AAFF189164368E5EE6B0F105D9", hash_generated_method = "72ACA8AA43909EA28FA1DA05A97D40A2")
        public String toString() {
String var2E22F76A1DF5431AD85BD69F1EB550BE_1382145842 =             subSequence(0, length()).toString();
            var2E22F76A1DF5431AD85BD69F1EB550BE_1382145842.addTaint(taint);
            return var2E22F76A1DF5431AD85BD69F1EB550BE_1382145842;
            // ---------- Original Method ----------
            //return subSequence(0, length()).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.530 -0400", hash_original_method = "B2B91CFAAB9E07A038BB0750D42A99E3", hash_generated_method = "E5581EFE44659864D12E624E521BC640")
        public void getChars(int start, int end, char[] dest, int off) {
            addTaint(off);
            addTaint(dest[0]);
            addTaint(end);
            addTaint(start);
            TextUtils.getChars(mSource, start, end, dest, off);
            int st = -1;
            int en = -1;
            int nvisible = 0;
            int[] starts = null;
            int[] ends = null;
            if(mSource instanceof Spanned)            
            {
                Spanned sp = (Spanned) mSource;
                st = sp.getSpanStart(TextKeyListener.ACTIVE);
                en = sp.getSpanEnd(TextKeyListener.ACTIVE);
                Visible[] visible = sp.getSpans(0, sp.length(), Visible.class);
                nvisible = visible.length;
                starts = new int[nvisible];
                ends = new int[nvisible];
for(int i = 0;i < nvisible;i++)
                {
                    if(sp.getSpanStart(visible[i].mTransformer) >= 0)                    
                    {
                        starts[i] = sp.getSpanStart(visible[i]);
                        ends[i] = sp.getSpanEnd(visible[i]);
                    } //End block
                } //End block
            } //End block
for(int i = start;i < end;i++)
            {
                if(! (i >= st && i < en))                
                {
                    boolean visible = false;
for(int a = 0;a < nvisible;a++)
                    {
                        if(i >= starts[a] && i < ends[a])                        
                        {
                            visible = true;
                            break;
                        } //End block
                    } //End block
                    if(!visible)                    
                    {
                        dest[i - start + off] = DOT;
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class Visible extends Handler implements UpdateLayout, Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.530 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "9BDF71D4F7023B7CA73EE663EDAF283F")

        private Spannable mText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.530 -0400", hash_original_field = "61FB95124568F7A434DEA5AA0096E365", hash_generated_field = "ACBDFE8CB9902234B1CF9642C13663A8")

        private PasswordTransformationMethod mTransformer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.531 -0400", hash_original_method = "FF4274DAFF106899CDED6A946D5BF028", hash_generated_method = "F683F9098D8C1A03C876251A84ADB628")
        public  Visible(Spannable sp, PasswordTransformationMethod ptm) {
            mText = sp;
            mTransformer = ptm;
            postAtTime(this, SystemClock.uptimeMillis() + 1500);
            // ---------- Original Method ----------
            //mText = sp;
            //mTransformer = ptm;
            //postAtTime(this, SystemClock.uptimeMillis() + 1500);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.531 -0400", hash_original_method = "C8775617BEE64680D27DACE05ECB8A14", hash_generated_method = "CA165B97F3ECA7B262668016C7A9F1A7")
        public void run() {
            mText.removeSpan(this);
            // ---------- Original Method ----------
            //mText.removeSpan(this);
        }

        
    }


    
    private static class ViewReference extends WeakReference<View> implements NoCopySpan {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.531 -0400", hash_original_method = "8A425A895F2F15617289F8E7C481E0F9", hash_generated_method = "D83E3686AEBB4F4A1C147F503B454C57")
        public  ViewReference(View v) {
            super(v);
            addTaint(v.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.531 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "1FFE1A33712E744FBA36248DA7E399EB")

    private static PasswordTransformationMethod sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.531 -0400", hash_original_field = "AF809F6FE46B3A7862692317388406A1", hash_generated_field = "C2C57B7CF6BBB168D84B800403D461E8")

    private static char DOT = '\u2022';
}

