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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.364 -0400", hash_original_field = "3D1DE554C8D876872742134AF6F3B39A", hash_generated_field = "7D23761C8705FAE591EE2FF3599940B6")

    private Capitalize mCapitalize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.364 -0400", hash_original_field = "3D18F8DF226A678B64C4D4C4D035A79A", hash_generated_field = "C101024EE87082E36D969AEA4683627E")

    private boolean mAutoText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.365 -0400", hash_original_method = "6BE005A7E4D72D3CA2FBB167C1B244A8", hash_generated_method = "ACE10D57511C93DA67E8E32A11F686A8")
    public  MultiTapKeyListener(Capitalize cap,
                               boolean autotext) {
        mCapitalize = cap;
        mAutoText = autotext;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.365 -0400", hash_original_method = "0F62DAE08CCEDDF88EBED8C62070D6C5", hash_generated_method = "E072191D9C1D376F6AE52E6DE6C96B9E")
    public int getInputType() {
        int var761B1FE077E1E2212DB3E7575B066EB4_781183610 = (makeTextContentType(mCapitalize, mAutoText));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965811363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965811363;
        // ---------- Original Method ----------
        //return makeTextContentType(mCapitalize, mAutoText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.814 -0400", hash_original_method = "A5D3B5CD1C27B709A733246605C23357", hash_generated_method = "A08EDBFE2730F5BEC228C6D4AAC10348")
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
            boolean varDDC7153FA60C68067F93081F3508D30C_493206791 = (activeStart == selStart && activeEnd == selEnd &&
            selEnd - selStart == 1 &&
            rec >= 0 && rec < sRecs.size());
            {
                {
                    char current;
                    current = content.charAt(selStart);
                    {
                        boolean var48D5769F4FEB6CCF6AE2A520BE0C7E12_1159712619 = (Character.isLowerCase(current));
                        {
                            content.replace(selStart, selEnd,
                                    String.valueOf(current).toUpperCase());
                            removeTimeouts(content);
                            new Timeout(content);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varA4A8BEA93337021ED4F924C9AED72D94_1116321257 = (Character.isUpperCase(current));
                        {
                            content.replace(selStart, selEnd,
                                    String.valueOf(current).toLowerCase());
                            removeTimeouts(content);
                            new Timeout(content);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var9134ACFA70B8D3CDF322E502E8A7178E_1669957688 = (sRecs.indexOfKey(keyCode) == rec);
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
                boolean var704C9751199C3A4ED254303F8894F254_1432524264 = ((pref & TextKeyListener.AUTO_CAP) != 0 &&
                TextKeyListener.shouldCap(mCapitalize, content, selStart));
                {
                    {
                        int i;
                        i = 0;
                        boolean var09BDEFA85CE819926774F0C47D2613EC_402441548 = (i < val.length());
                        {
                            {
                                boolean var35387AA0E3A3FB9F9E99322F4F894FE7_1794634436 = (Character.isUpperCase(val.charAt(i)));
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
                boolean var5509939079676AB7B7E61F12CE04A4CA_1170743803 = (content.getSpanStart(this) < 0);
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
        boolean var250B4652E205BB567180858BBC354846_1356803591 = (super.onKeyDown(view, content, keyCode, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_605908870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_605908870;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.816 -0400", hash_original_method = "32D49D04D14DFD2D5D5762D6E8E59602", hash_generated_method = "EA480FB765F446E2BD875D4224CC19DE")
    public void onSpanChanged(Spannable buf,
                              Object what, int s, int e, int start, int stop) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            buf.removeSpan(TextKeyListener.ACTIVE);
            removeTimeouts(buf);
        } //End block
        addTaint(buf.getTaint());
        addTaint(what.getTaint());
        addTaint(s);
        addTaint(e);
        addTaint(start);
        addTaint(stop);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.828 -0400", hash_original_method = "A7E02D03E9AB7CF614DD169102D03FAF", hash_generated_method = "7B286C8C34C0CB912482A9582E50ADC8")
    public void onSpanAdded(Spannable s, Object what, int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(s.getTaint());
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.829 -0400", hash_original_method = "2C716670C272F54C9EB4064D90DB3C4E", hash_generated_method = "F033A2BD7F1AB312500D2F37A623D63A")
    public void onSpanRemoved(Spannable s, Object what, int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(s.getTaint());
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
    }

    
    private class Timeout extends Handler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.829 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "18D0F939AB26C87C5090868F3237476C")

        private Editable mBuffer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.830 -0400", hash_original_method = "3DB3951CA009929F9B4A37752F403591", hash_generated_method = "64C6F8B09FC3C1E1F1031D1DBB78A20B")
        public  Timeout(Editable buffer) {
            mBuffer = buffer;
            mBuffer.setSpan(Timeout.this, 0, mBuffer.length(),
                            Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            postAtTime(this, SystemClock.uptimeMillis() + 2000);
            // ---------- Original Method ----------
            //mBuffer = buffer;
            //mBuffer.setSpan(Timeout.this, 0, mBuffer.length(),
                            //Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            //postAtTime(this, SystemClock.uptimeMillis() + 2000);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.830 -0400", hash_original_method = "9422E834C74E9D65E1B16C1853183F4B", hash_generated_method = "F3D86BB8C2ECDE4F38C1371B79DA5A68")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.830 -0400", hash_original_field = "43E438C3156C9CB6EDABF4B28A3B32D7", hash_generated_field = "5AAB138DC3461610E21934C9916D10E2")

    private static MultiTapKeyListener[] sInstance = new MultiTapKeyListener[Capitalize.values().length * 2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.830 -0400", hash_original_field = "87BF90205519DDCD40EDB80D3CA7E5FC", hash_generated_field = "3D8F8FB021202F5109351C714E99D70E")

    private static SparseArray<String> sRecs = new SparseArray<String>();
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

