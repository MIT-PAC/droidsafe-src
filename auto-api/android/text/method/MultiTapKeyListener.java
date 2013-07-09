package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.KeyEvent;
import android.view.View;
import android.os.Handler;
import android.os.SystemClock;
import android.text.*;
import android.text.method.TextKeyListener.Capitalize;
import android.util.SparseArray;

public class MultiTapKeyListener extends BaseKeyListener implements SpanWatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.262 -0400", hash_original_field = "3D1DE554C8D876872742134AF6F3B39A", hash_generated_field = "7D23761C8705FAE591EE2FF3599940B6")

    private Capitalize mCapitalize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.262 -0400", hash_original_field = "3D18F8DF226A678B64C4D4C4D035A79A", hash_generated_field = "C101024EE87082E36D969AEA4683627E")

    private boolean mAutoText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.263 -0400", hash_original_method = "6BE005A7E4D72D3CA2FBB167C1B244A8", hash_generated_method = "ACE10D57511C93DA67E8E32A11F686A8")
    public  MultiTapKeyListener(Capitalize cap,
                               boolean autotext) {
        mCapitalize = cap;
        mAutoText = autotext;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static MultiTapKeyListener getInstance(boolean autotext,
                                                  Capitalize cap) {
        int off = cap.ordinal() * 2 + (autotext ? 1 : 0);
        if (sInstance[off] == null) {
            sInstance[off] = new MultiTapKeyListener(cap, autotext);
        }
        return sInstance[off];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.263 -0400", hash_original_method = "0F62DAE08CCEDDF88EBED8C62070D6C5", hash_generated_method = "CE223E4BFA5D3F51D6A8C2C9E2434CE2")
    public int getInputType() {
        int var761B1FE077E1E2212DB3E7575B066EB4_883524537 = (makeTextContentType(mCapitalize, mAutoText));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368275540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368275540;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.283 -0400", hash_original_method = "A5D3B5CD1C27B709A733246605C23357", hash_generated_method = "DA00DBBECFA1920775DE05222B910D85")
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        
        int selStart;
        int selEnd;
        int pref = 0;
        {
            pref = TextKeyListener.getInstance().getPrefs(view.getContext());
        } 
        {
            int a = Selection.getSelectionStart(content);
            int b = Selection.getSelectionEnd(content);
            selStart = Math.min(a, b);
            selEnd = Math.max(a, b);
        } 
        int activeStart = content.getSpanStart(TextKeyListener.ACTIVE);
        int activeEnd = content.getSpanEnd(TextKeyListener.ACTIVE);
        int rec = (content.getSpanFlags(TextKeyListener.ACTIVE)
                    & Spannable.SPAN_USER) >>> Spannable.SPAN_USER_SHIFT;
        {
            boolean varDDC7153FA60C68067F93081F3508D30C_257285838 = (activeStart == selStart && activeEnd == selEnd &&
            selEnd - selStart == 1 &&
            rec >= 0 && rec < sRecs.size());
            {
                {
                    char current = content.charAt(selStart);
                    {
                        boolean var48D5769F4FEB6CCF6AE2A520BE0C7E12_2099264854 = (Character.isLowerCase(current));
                        {
                            content.replace(selStart, selEnd,
                                    String.valueOf(current).toUpperCase());
                            removeTimeouts(content);
                            new Timeout(content);
                        } 
                    } 
                    {
                        boolean varA4A8BEA93337021ED4F924C9AED72D94_1414893766 = (Character.isUpperCase(current));
                        {
                            content.replace(selStart, selEnd,
                                    String.valueOf(current).toLowerCase());
                            removeTimeouts(content);
                            new Timeout(content);
                        } 
                    } 
                } 
                {
                    boolean var9134ACFA70B8D3CDF322E502E8A7178E_1251734345 = (sRecs.indexOfKey(keyCode) == rec);
                    {
                        String val = sRecs.valueAt(rec);
                        char ch = content.charAt(selStart);
                        int ix = val.indexOf(ch);
                        {
                            ix = (ix + 1) % (val.length());
                            content.replace(selStart, selEnd, val, ix, ix + 1);
                            removeTimeouts(content);
                            new Timeout(content);
                        } 
                    } 
                } 
                rec = sRecs.indexOfKey(keyCode);
                {
                    Selection.setSelection(content, selEnd, selEnd);
                    selStart = selEnd;
                } 
            } 
            {
                rec = sRecs.indexOfKey(keyCode);
            } 
        } 
        {
            String val = sRecs.valueAt(rec);
            int off = 0;
            {
                boolean var704C9751199C3A4ED254303F8894F254_834649931 = ((pref & TextKeyListener.AUTO_CAP) != 0 &&
                TextKeyListener.shouldCap(mCapitalize, content, selStart));
                {
                    {
                        int i = 0;
                        boolean var09BDEFA85CE819926774F0C47D2613EC_1248750095 = (i < val.length());
                        {
                            {
                                boolean var35387AA0E3A3FB9F9E99322F4F894FE7_255767974 = (Character.isUpperCase(val.charAt(i)));
                                {
                                    off = i;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                Selection.setSelection(content, selEnd);
            } 
            content.setSpan(OLD_SEL_START, selStart, selStart,
                            Spannable.SPAN_MARK_MARK);
            content.replace(selStart, selEnd, val, off, off + 1);
            int oldStart = content.getSpanStart(OLD_SEL_START);
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
            } 
            removeTimeouts(content);
            new Timeout(content);
            {
                boolean var5509939079676AB7B7E61F12CE04A4CA_792719459 = (content.getSpanStart(this) < 0);
                {
                    KeyListener[] methods = content.getSpans(0, content.length(),
                                                    KeyListener.class);
                    {
                        Object method = methods[0];
                        {
                            content.removeSpan(method);
                        } 
                    } 
                    content.setSpan(this, 0, content.length(),
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                } 
            } 
        } 
        boolean var250B4652E205BB567180858BBC354846_798807301 = (super.onKeyDown(view, content, keyCode, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_650974291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_650974291;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.283 -0400", hash_original_method = "32D49D04D14DFD2D5D5762D6E8E59602", hash_generated_method = "EA480FB765F446E2BD875D4224CC19DE")
    public void onSpanChanged(Spannable buf,
                              Object what, int s, int e, int start, int stop) {
        
        {
            buf.removeSpan(TextKeyListener.ACTIVE);
            removeTimeouts(buf);
        } 
        addTaint(buf.getTaint());
        addTaint(what.getTaint());
        addTaint(s);
        addTaint(e);
        addTaint(start);
        addTaint(stop);
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void removeTimeouts(Spannable buf) {
        Timeout[] timeout = buf.getSpans(0, buf.length(), Timeout.class);
        for (int i = 0; i < timeout.length; i++) {
            Timeout t = timeout[i];
            t.removeCallbacks(t);
            t.mBuffer = null;
            buf.removeSpan(t);
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.284 -0400", hash_original_method = "A7E02D03E9AB7CF614DD169102D03FAF", hash_generated_method = "7B286C8C34C0CB912482A9582E50ADC8")
    public void onSpanAdded(Spannable s, Object what, int start, int end) {
        
        addTaint(s.getTaint());
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.284 -0400", hash_original_method = "2C716670C272F54C9EB4064D90DB3C4E", hash_generated_method = "F033A2BD7F1AB312500D2F37A623D63A")
    public void onSpanRemoved(Spannable s, Object what, int start, int end) {
        
        addTaint(s.getTaint());
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        
    }

    
    private class Timeout extends Handler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.285 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "18D0F939AB26C87C5090868F3237476C")

        private Editable mBuffer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.285 -0400", hash_original_method = "3DB3951CA009929F9B4A37752F403591", hash_generated_method = "64C6F8B09FC3C1E1F1031D1DBB78A20B")
        public  Timeout(Editable buffer) {
            mBuffer = buffer;
            mBuffer.setSpan(Timeout.this, 0, mBuffer.length(),
                            Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            postAtTime(this, SystemClock.uptimeMillis() + 2000);
            
            
            
                            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.285 -0400", hash_original_method = "9422E834C74E9D65E1B16C1853183F4B", hash_generated_method = "AF35C58A9713263B1D1E3392E03911A3")
        public void run() {
            Spannable buf = mBuffer;
            {
                int st = Selection.getSelectionStart(buf);
                int en = Selection.getSelectionEnd(buf);
                int start = buf.getSpanStart(TextKeyListener.ACTIVE);
                int end = buf.getSpanEnd(TextKeyListener.ACTIVE);
                {
                    Selection.setSelection(buf, Selection.getSelectionEnd(buf));
                } 
                buf.removeSpan(Timeout.this);
            } 
            
            
            
                
                
                
                
                
                    
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.286 -0400", hash_original_field = "43E438C3156C9CB6EDABF4B28A3B32D7", hash_generated_field = "5AAB138DC3461610E21934C9916D10E2")

    private static MultiTapKeyListener[] sInstance = new MultiTapKeyListener[Capitalize.values().length * 2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.286 -0400", hash_original_field = "87BF90205519DDCD40EDB80D3CA7E5FC", hash_generated_field = "7F64AC2635E34AEAB242631B33213228")

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

