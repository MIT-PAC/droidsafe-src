package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.KeyEvent;
import android.view.View;
import android.os.Handler;
import android.os.SystemClock;
import android.text.*;
import android.text.method.TextKeyListener.Capitalize;
import android.util.SparseArray;

public class MultiTapKeyListener extends BaseKeyListener implements SpanWatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.684 -0400", hash_original_field = "3D1DE554C8D876872742134AF6F3B39A", hash_generated_field = "7D23761C8705FAE591EE2FF3599940B6")

    private Capitalize mCapitalize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.684 -0400", hash_original_field = "3D18F8DF226A678B64C4D4C4D035A79A", hash_generated_field = "C101024EE87082E36D969AEA4683627E")

    private boolean mAutoText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.685 -0400", hash_original_method = "6BE005A7E4D72D3CA2FBB167C1B244A8", hash_generated_method = "ACE10D57511C93DA67E8E32A11F686A8")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.686 -0400", hash_original_method = "0F62DAE08CCEDDF88EBED8C62070D6C5", hash_generated_method = "3E4FFF5898B3E794EABECC41222E7DDA")
    public int getInputType() {
        int var89C976C03165A22A08FDF991404C4F1F_1625758688 = (makeTextContentType(mCapitalize, mAutoText));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605821558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605821558;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.690 -0400", hash_original_method = "A5D3B5CD1C27B709A733246605C23357", hash_generated_method = "F2363FEAADD933C88BBB48CEED64628D")
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        int selStart;
        int selEnd;
        int pref = 0;
    if(view != null)        
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
    if(activeStart == selStart && activeEnd == selEnd &&
            selEnd - selStart == 1 &&
            rec >= 0 && rec < sRecs.size())        
        {
    if(keyCode == KeyEvent.KEYCODE_STAR)            
            {
                char current = content.charAt(selStart);
    if(Character.isLowerCase(current))                
                {
                    content.replace(selStart, selEnd,
                                    String.valueOf(current).toUpperCase());
                    removeTimeouts(content);
                    new Timeout(content);
                    boolean varB326B5062B2F0E69046810717534CB09_1947923348 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_859468566 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_859468566;
                } 
    if(Character.isUpperCase(current))                
                {
                    content.replace(selStart, selEnd,
                                    String.valueOf(current).toLowerCase());
                    removeTimeouts(content);
                    new Timeout(content);
                    boolean varB326B5062B2F0E69046810717534CB09_2137161868 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322921690 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322921690;
                } 
            } 
    if(sRecs.indexOfKey(keyCode) == rec)            
            {
                String val = sRecs.valueAt(rec);
                char ch = content.charAt(selStart);
                int ix = val.indexOf(ch);
    if(ix >= 0)                
                {
                    ix = (ix + 1) % (val.length());
                    content.replace(selStart, selEnd, val, ix, ix + 1);
                    removeTimeouts(content);
                    new Timeout(content);
                    boolean varB326B5062B2F0E69046810717534CB09_450089925 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805948878 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_805948878;
                } 
            } 
            rec = sRecs.indexOfKey(keyCode);
    if(rec >= 0)            
            {
                Selection.setSelection(content, selEnd, selEnd);
                selStart = selEnd;
            } 
        } 
        else
        {
            rec = sRecs.indexOfKey(keyCode);
        } 
    if(rec >= 0)        
        {
            String val = sRecs.valueAt(rec);
            int off = 0;
    if((pref & TextKeyListener.AUTO_CAP) != 0 &&
                TextKeyListener.shouldCap(mCapitalize, content, selStart))            
            {
for(int i = 0;i < val.length();i++)
                {
    if(Character.isUpperCase(val.charAt(i)))                    
                    {
                        off = i;
                        break;
                    } 
                } 
            } 
    if(selStart != selEnd)            
            {
                Selection.setSelection(content, selEnd);
            } 
            content.setSpan(OLD_SEL_START, selStart, selStart,
                            Spannable.SPAN_MARK_MARK);
            content.replace(selStart, selEnd, val, off, off + 1);
            int oldStart = content.getSpanStart(OLD_SEL_START);
            selEnd = Selection.getSelectionEnd(content);
    if(selEnd != oldStart)            
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
    if(content.getSpanStart(this) < 0)            
            {
                KeyListener[] methods = content.getSpans(0, content.length(),
                                                    KeyListener.class);
for(Object method : methods)
                {
                    content.removeSpan(method);
                } 
                content.setSpan(this, 0, content.length(),
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            } 
            boolean varB326B5062B2F0E69046810717534CB09_2030037441 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347040701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_347040701;
        } 
        boolean var5F21C6842D9E32D23C5A1CD0B3EB473F_1511572048 = (super.onKeyDown(view, content, keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1813461385 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1813461385;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.693 -0400", hash_original_method = "32D49D04D14DFD2D5D5762D6E8E59602", hash_generated_method = "F68DAE41F814022918F8B4AA93EB4204")
    public void onSpanChanged(Spannable buf,
                              Object what, int s, int e, int start, int stop) {
        
        addTaint(stop);
        addTaint(start);
        addTaint(e);
        addTaint(s);
        addTaint(what.getTaint());
        addTaint(buf.getTaint());
    if(what == Selection.SELECTION_END)        
        {
            buf.removeSpan(TextKeyListener.ACTIVE);
            removeTimeouts(buf);
        } 
        
        
            
            
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.694 -0400", hash_original_method = "A7E02D03E9AB7CF614DD169102D03FAF", hash_generated_method = "0F24BCA6C9426B0673BF35264E746E85")
    public void onSpanAdded(Spannable s, Object what, int start, int end) {
        
        addTaint(end);
        addTaint(start);
        addTaint(what.getTaint());
        addTaint(s.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.695 -0400", hash_original_method = "2C716670C272F54C9EB4064D90DB3C4E", hash_generated_method = "A2BA261E44A26E34D865E62CBB58DEB1")
    public void onSpanRemoved(Spannable s, Object what, int start, int end) {
        
        addTaint(end);
        addTaint(start);
        addTaint(what.getTaint());
        addTaint(s.getTaint());
        
    }

    
    private class Timeout extends Handler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.695 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "18D0F939AB26C87C5090868F3237476C")

        private Editable mBuffer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.695 -0400", hash_original_method = "3DB3951CA009929F9B4A37752F403591", hash_generated_method = "64C6F8B09FC3C1E1F1031D1DBB78A20B")
        public  Timeout(Editable buffer) {
            mBuffer = buffer;
            mBuffer.setSpan(Timeout.this, 0, mBuffer.length(),
                            Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            postAtTime(this, SystemClock.uptimeMillis() + 2000);
            
            
            
                            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.696 -0400", hash_original_method = "9422E834C74E9D65E1B16C1853183F4B", hash_generated_method = "3D4B4364C0B718E3150F8DDBD285C60B")
        public void run() {
            Spannable buf = mBuffer;
    if(buf != null)            
            {
                int st = Selection.getSelectionStart(buf);
                int en = Selection.getSelectionEnd(buf);
                int start = buf.getSpanStart(TextKeyListener.ACTIVE);
                int end = buf.getSpanEnd(TextKeyListener.ACTIVE);
    if(st == start && en == end)                
                {
                    Selection.setSelection(buf, Selection.getSelectionEnd(buf));
                } 
                buf.removeSpan(Timeout.this);
            } 
            
            
            
                
                
                
                
                
                    
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.696 -0400", hash_original_field = "43E438C3156C9CB6EDABF4B28A3B32D7", hash_generated_field = "5AAB138DC3461610E21934C9916D10E2")

    private static MultiTapKeyListener[] sInstance = new MultiTapKeyListener[Capitalize.values().length * 2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.696 -0400", hash_original_field = "87BF90205519DDCD40EDB80D3CA7E5FC", hash_generated_field = "7F64AC2635E34AEAB242631B33213228")

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

