package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.KeyEvent;
import android.view.View;
import android.os.Handler;
import android.os.SystemClock;
import android.text.*;
import android.text.method.TextKeyListener.Capitalize;
import android.util.SparseArray;

public class MultiTapKeyListener extends BaseKeyListener implements SpanWatcher {
    private Capitalize mCapitalize;
    private boolean mAutoText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.462 -0400", hash_original_method = "6BE005A7E4D72D3CA2FBB167C1B244A8", hash_generated_method = "9721557216ECB1720790B7DD62DF4E4A")
    @DSModeled(DSC.SAFE)
    public MultiTapKeyListener(Capitalize cap,
                               boolean autotext) {
        dsTaint.addTaint(autotext);
        dsTaint.addTaint(cap.dsTaint);
        // ---------- Original Method ----------
        //mCapitalize = cap;
        //mAutoText = autotext;
    }

    
        public static MultiTapKeyListener getInstance(boolean autotext,
                                                  Capitalize cap) {
        int off = cap.ordinal() * 2 + (autotext ? 1 : 0);
        if (sInstance[off] == null) {
            sInstance[off] = new MultiTapKeyListener(cap, autotext);
        }
        return sInstance[off];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.462 -0400", hash_original_method = "0F62DAE08CCEDDF88EBED8C62070D6C5", hash_generated_method = "F0340FEC7ED52C88FEABC5D62B6A4AB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInputType() {
        int var761B1FE077E1E2212DB3E7575B066EB4_1043856422 = (makeTextContentType(mCapitalize, mAutoText));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return makeTextContentType(mCapitalize, mAutoText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.498 -0400", hash_original_method = "A5D3B5CD1C27B709A733246605C23357", hash_generated_method = "3D784B9798B2647905DF26BC79C586A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        int selStart, selEnd;
        int pref;
        pref = 0;
        {
            pref = TextKeyListener.getInstance().getPrefs(view.getContext());
        } //End block
        {
            int a;
            a = Selection.getSelectionStart(content);
            int b;
            b = Selection.getSelectionEnd(content);
            selStart = Math.min(a, b);
            selEnd = Math.max(a, b);
        } //End block
        int activeStart;
        activeStart = content.getSpanStart(TextKeyListener.ACTIVE);
        int activeEnd;
        activeEnd = content.getSpanEnd(TextKeyListener.ACTIVE);
        int rec;
        rec = (content.getSpanFlags(TextKeyListener.ACTIVE)
                    & Spannable.SPAN_USER) >>> Spannable.SPAN_USER_SHIFT;
        {
            boolean varDDC7153FA60C68067F93081F3508D30C_947496100 = (activeStart == selStart && activeEnd == selEnd &&
            selEnd - selStart == 1 &&
            rec >= 0 && rec < sRecs.size());
            {
                {
                    char current;
                    current = content.charAt(selStart);
                    {
                        boolean var48D5769F4FEB6CCF6AE2A520BE0C7E12_238880931 = (Character.isLowerCase(current));
                        {
                            content.replace(selStart, selEnd,
                                    String.valueOf(current).toUpperCase());
                            removeTimeouts(content);
                            new Timeout(content);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varA4A8BEA93337021ED4F924C9AED72D94_28546745 = (Character.isUpperCase(current));
                        {
                            content.replace(selStart, selEnd,
                                    String.valueOf(current).toLowerCase());
                            removeTimeouts(content);
                            new Timeout(content);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var9134ACFA70B8D3CDF322E502E8A7178E_2022594254 = (sRecs.indexOfKey(keyCode) == rec);
                    {
                        String val;
                        val = sRecs.valueAt(rec);
                        char ch;
                        ch = content.charAt(selStart);
                        int ix;
                        ix = val.indexOf(ch);
                        {
                            ix = (ix + 1) % (val.length());
                            content.replace(selStart, selEnd, val, ix, ix + 1);
                            removeTimeouts(content);
                            new Timeout(content);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                rec = sRecs.indexOfKey(keyCode);
                {
                    Selection.setSelection(content, selEnd, selEnd);
                    selStart = selEnd;
                } //End block
            } //End block
            {
                rec = sRecs.indexOfKey(keyCode);
            } //End block
        } //End collapsed parenthetic
        {
            String val;
            val = sRecs.valueAt(rec);
            int off;
            off = 0;
            {
                boolean var704C9751199C3A4ED254303F8894F254_1625744598 = ((pref & TextKeyListener.AUTO_CAP) != 0 &&
                TextKeyListener.shouldCap(mCapitalize, content, selStart));
                {
                    {
                        int i;
                        i = 0;
                        boolean var09BDEFA85CE819926774F0C47D2613EC_1274329838 = (i < val.length());
                        {
                            {
                                boolean var35387AA0E3A3FB9F9E99322F4F894FE7_19919539 = (Character.isUpperCase(val.charAt(i)));
                                {
                                    off = i;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                Selection.setSelection(content, selEnd);
            } //End block
            content.setSpan(OLD_SEL_START, selStart, selStart,
                            Spannable.SPAN_MARK_MARK);
            content.replace(selStart, selEnd, val, off, off + 1);
            int oldStart;
            oldStart = content.getSpanStart(OLD_SEL_START);
            selEnd = Selection.getSelectionEnd(content);
            {
                Selection.setSelection(content, oldStart, selEnd);
                content.setSpan(TextKeyListener.LAST_TYPED, 
                                oldStart, selEnd,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                content.setSpan(TextKeyListener.ACTIVE,
                            oldStart, selEnd,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE |
                            (rec << Spannable.SPAN_USER_SHIFT));
            } //End block
            removeTimeouts(content);
            new Timeout(content);
            {
                boolean var5509939079676AB7B7E61F12CE04A4CA_1641571961 = (content.getSpanStart(this) < 0);
                {
                    KeyListener[] methods;
                    methods = content.getSpans(0, content.length(),
                                                    KeyListener.class);
                    {
                        Object method = methods[0];
                        {
                            content.removeSpan(method);
                        } //End block
                    } //End collapsed parenthetic
                    content.setSpan(this, 0, content.length(),
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var250B4652E205BB567180858BBC354846_1989302331 = (super.onKeyDown(view, content, keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.499 -0400", hash_original_method = "32D49D04D14DFD2D5D5762D6E8E59602", hash_generated_method = "399AF4317AB7851EDABD8A9D92A0EE9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onSpanChanged(Spannable buf,
                              Object what, int s, int e, int start, int stop) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(stop);
        dsTaint.addTaint(e);
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(buf.dsTaint);
        {
            buf.removeSpan(TextKeyListener.ACTIVE);
            removeTimeouts(buf);
        } //End block
        // ---------- Original Method ----------
        //if (what == Selection.SELECTION_END) {
            //buf.removeSpan(TextKeyListener.ACTIVE);
            //removeTimeouts(buf);
        //}
    }

    
        private static void removeTimeouts(Spannable buf) {
        Timeout[] timeout = buf.getSpans(0, buf.length(), Timeout.class);
        for (int i = 0; i < timeout.length; i++) {
            Timeout t = timeout[i];
            t.removeCallbacks(t);
            t.mBuffer = null;
            buf.removeSpan(t);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.499 -0400", hash_original_method = "A7E02D03E9AB7CF614DD169102D03FAF", hash_generated_method = "C22D61E999AA1E9951E285D7DC2268B9")
    @DSModeled(DSC.SAFE)
    public void onSpanAdded(Spannable s, Object what, int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.500 -0400", hash_original_method = "2C716670C272F54C9EB4064D90DB3C4E", hash_generated_method = "ED0028870DFADED4E715BEB8F9C515AF")
    @DSModeled(DSC.SAFE)
    public void onSpanRemoved(Spannable s, Object what, int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
    private class Timeout extends Handler implements Runnable {
        private Editable mBuffer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.500 -0400", hash_original_method = "3DB3951CA009929F9B4A37752F403591", hash_generated_method = "B7D7C2FD16FCD49F10FFB789A628C893")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Timeout(Editable buffer) {
            dsTaint.addTaint(buffer.dsTaint);
            mBuffer.setSpan(Timeout.this, 0, mBuffer.length(),
                            Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            postAtTime(this, SystemClock.uptimeMillis() + 2000);
            // ---------- Original Method ----------
            //mBuffer = buffer;
            //mBuffer.setSpan(Timeout.this, 0, mBuffer.length(),
                            //Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            //postAtTime(this, SystemClock.uptimeMillis() + 2000);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.500 -0400", hash_original_method = "9422E834C74E9D65E1B16C1853183F4B", hash_generated_method = "F3D86BB8C2ECDE4F38C1371B79DA5A68")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            Spannable buf;
            buf = mBuffer;
            {
                int st;
                st = Selection.getSelectionStart(buf);
                int en;
                en = Selection.getSelectionEnd(buf);
                int start;
                start = buf.getSpanStart(TextKeyListener.ACTIVE);
                int end;
                end = buf.getSpanEnd(TextKeyListener.ACTIVE);
                {
                    Selection.setSelection(buf, Selection.getSelectionEnd(buf));
                } //End block
                buf.removeSpan(Timeout.this);
            } //End block
            // ---------- Original Method ----------
            //Spannable buf = mBuffer;
            //if (buf != null) {
                //int st = Selection.getSelectionStart(buf);
                //int en = Selection.getSelectionEnd(buf);
                //int start = buf.getSpanStart(TextKeyListener.ACTIVE);
                //int end = buf.getSpanEnd(TextKeyListener.ACTIVE);
                //if (st == start && en == end) {
                    //Selection.setSelection(buf, Selection.getSelectionEnd(buf));
                //}
                //buf.removeSpan(Timeout.this);
            //}
        }

        
    }


    
    private static MultiTapKeyListener[] sInstance =
        new MultiTapKeyListener[Capitalize.values().length * 2];
    private static final SparseArray<String> sRecs = new SparseArray<String>();
    static {
        sRecs.put(KeyEvent.KEYCODE_1,     ".,1!@#$%^&*:/?'=()");
        sRecs.put(KeyEvent.KEYCODE_2,     "abc2ABC");
        sRecs.put(KeyEvent.KEYCODE_3,     "def3DEF");
        sRecs.put(KeyEvent.KEYCODE_4,     "ghi4GHI");
        sRecs.put(KeyEvent.KEYCODE_5,     "jkl5JKL");
        sRecs.put(KeyEvent.KEYCODE_6,     "mno6MNO");
        sRecs.put(KeyEvent.KEYCODE_7,     "pqrs7PQRS");
        sRecs.put(KeyEvent.KEYCODE_8,     "tuv8TUV");
        sRecs.put(KeyEvent.KEYCODE_9,     "wxyz9WXYZ");
        sRecs.put(KeyEvent.KEYCODE_0,     "0+");
        sRecs.put(KeyEvent.KEYCODE_POUND, " ");
    }
    
}

