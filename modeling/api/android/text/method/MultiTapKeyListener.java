package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.method.TextKeyListener.Capitalize;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;

public class MultiTapKeyListener extends BaseKeyListener implements SpanWatcher {

    /**
     * Returns a new or existing instance with the specified capitalization
     * and correction properties.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.538 -0500", hash_original_method = "4E97B9F33E3690A393012BAC99D71702", hash_generated_method = "B24A55E3524250C9BCDCFC246ADEB9DA")
    
public static MultiTapKeyListener getInstance(boolean autotext,
                                                  Capitalize cap) {
        int off = cap.ordinal() * 2 + (autotext ? 1 : 0);

        if (sInstance[off] == null) {
            sInstance[off] = new MultiTapKeyListener(cap, autotext);
        }

        return sInstance[off];
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.553 -0500", hash_original_method = "A9D9431F8F7C49BD7FCC39C25DD87181", hash_generated_method = "7E0919A985C3A4E00333092011633B3C")
    
private static void removeTimeouts(Spannable buf) {
        Timeout[] timeout = buf.getSpans(0, buf.length(), Timeout.class);

        for (int i = 0; i < timeout.length; i++) {
            Timeout t = timeout[i];

            t.removeCallbacks(t);
            t.mBuffer = null;
            buf.removeSpan(t);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.522 -0500", hash_original_field = "5805C0CE1B91B00306C2FDDA14D5C69C", hash_generated_field = "5AAB138DC3461610E21934C9916D10E2")

    private static MultiTapKeyListener[] sInstance =
        new MultiTapKeyListener[Capitalize.values().length * 2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.526 -0500", hash_original_field = "ECA101F9529E11568760EB2314D83FC5", hash_generated_field = "7F64AC2635E34AEAB242631B33213228")

    private static final SparseArray<String> sRecs = new SparseArray<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.528 -0500", hash_original_field = "917533800E906A4D91677293540D1184", hash_generated_field = "7D23761C8705FAE591EE2FF3599940B6")

    private Capitalize mCapitalize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.531 -0500", hash_original_field = "CD7A811405529AA08CC45A606C53B887", hash_generated_field = "C101024EE87082E36D969AEA4683627E")

    private boolean mAutoText;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.535 -0500", hash_original_method = "6BE005A7E4D72D3CA2FBB167C1B244A8", hash_generated_method = "8D24403BFBA744B4861BCC7F16F4C8DE")
    
public MultiTapKeyListener(Capitalize cap,
                               boolean autotext) {
        mCapitalize = cap;
        mAutoText = autotext;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.542 -0500", hash_original_method = "0F62DAE08CCEDDF88EBED8C62070D6C5", hash_generated_method = "0B7F1FA09C054D9B934295C3C2A89BD2")
    
public int getInputType() {
        return makeTextContentType(mCapitalize, mAutoText);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.547 -0500", hash_original_method = "A5D3B5CD1C27B709A733246605C23357", hash_generated_method = "BFF86FA97AEA614221DE67AA43F95E56")
    
public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        int selStart, selEnd;
        int pref = 0;

        if (view != null) {
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

        // now for the multitap cases...

        // Try to increment the character we were working on before
        // if we have one and it's still the same key.

        int rec = (content.getSpanFlags(TextKeyListener.ACTIVE)
                    & Spannable.SPAN_USER) >>> Spannable.SPAN_USER_SHIFT;

        if (activeStart == selStart && activeEnd == selEnd &&
            selEnd - selStart == 1 &&
            rec >= 0 && rec < sRecs.size()) {
            if (keyCode == KeyEvent.KEYCODE_STAR) {
                char current = content.charAt(selStart);

                if (Character.isLowerCase(current)) {
                    content.replace(selStart, selEnd,
                                    String.valueOf(current).toUpperCase());
                    removeTimeouts(content);
                    new Timeout(content); // for its side effects

                    return true;
                }
                if (Character.isUpperCase(current)) {
                    content.replace(selStart, selEnd,
                                    String.valueOf(current).toLowerCase());
                    removeTimeouts(content);
                    new Timeout(content); // for its side effects

                    return true;
                }
            }

            if (sRecs.indexOfKey(keyCode) == rec) {
                String val = sRecs.valueAt(rec);
                char ch = content.charAt(selStart);
                int ix = val.indexOf(ch);

                if (ix >= 0) {
                    ix = (ix + 1) % (val.length());

                    content.replace(selStart, selEnd, val, ix, ix + 1);
                    removeTimeouts(content);
                    new Timeout(content); // for its side effects

                    return true;
                }
            }

            // Is this key one we know about at all?  If so, acknowledge
            // that the selection is our fault but the key has changed
            // or the text no longer matches, so move the selection over
            // so that it inserts instead of replaces.

            rec = sRecs.indexOfKey(keyCode);

            if (rec >= 0) {
                Selection.setSelection(content, selEnd, selEnd);
                selStart = selEnd;
            }
        } else {
            rec = sRecs.indexOfKey(keyCode);
        }

        if (rec >= 0) {
            // We have a valid key.  Replace the selection or insertion point
            // with the first character for that key, and remember what
            // record it came from for next time.

            String val = sRecs.valueAt(rec);

            int off = 0;
            if ((pref & TextKeyListener.AUTO_CAP) != 0 &&
                TextKeyListener.shouldCap(mCapitalize, content, selStart)) {
                for (int i = 0; i < val.length(); i++) {
                    if (Character.isUpperCase(val.charAt(i))) {
                        off = i;
                        break;
                    }
                }
            }

            if (selStart != selEnd) {
                Selection.setSelection(content, selEnd);
            }

            content.setSpan(OLD_SEL_START, selStart, selStart,
                            Spannable.SPAN_MARK_MARK);

            content.replace(selStart, selEnd, val, off, off + 1);

            int oldStart = content.getSpanStart(OLD_SEL_START);
            selEnd = Selection.getSelectionEnd(content);

            if (selEnd != oldStart) {
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
            new Timeout(content); // for its side effects

            // Set up the callback so we can remove the timeout if the
            // cursor moves.

            if (content.getSpanStart(this) < 0) {
                KeyListener[] methods = content.getSpans(0, content.length(),
                                                    KeyListener.class);
                for (Object method : methods) {
                    content.removeSpan(method);
                }
                content.setSpan(this, 0, content.length(),
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            }

            return true;
        }

        return super.onKeyDown(view, content, keyCode, event);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.550 -0500", hash_original_method = "32D49D04D14DFD2D5D5762D6E8E59602", hash_generated_method = "159301206BA9C3461ABFA90A03E86E49")
    
public void onSpanChanged(Spannable buf,
                              Object what, int s, int e, int start, int stop) {
        if (what == Selection.SELECTION_END) {
            buf.removeSpan(TextKeyListener.ACTIVE);
            removeTimeouts(buf);
        }
    }
    
    private class Timeout extends Handler implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.564 -0500", hash_original_field = "2E9B92BEB3F58CC9235E27C030F0082B", hash_generated_field = "18D0F939AB26C87C5090868F3237476C")

        private Editable mBuffer;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.558 -0500", hash_original_method = "3DB3951CA009929F9B4A37752F403591", hash_generated_method = "E7DCEC8AB791586EB937CA795193DAF7")
        
public Timeout(Editable buffer) {
            mBuffer = buffer;
            mBuffer.setSpan(Timeout.this, 0, mBuffer.length(),
                            Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            postAtTime(this, SystemClock.uptimeMillis() + 2000);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.561 -0500", hash_original_method = "9422E834C74E9D65E1B16C1853183F4B", hash_generated_method = "9DFFBED0D2474352FDD7AB21BBC6F531")
        
public void run() {
            Spannable buf = mBuffer;

            if (buf != null) {
                int st = Selection.getSelectionStart(buf);
                int en = Selection.getSelectionEnd(buf);

                int start = buf.getSpanStart(TextKeyListener.ACTIVE);
                int end = buf.getSpanEnd(TextKeyListener.ACTIVE);

                if (st == start && en == end) {
                    Selection.setSelection(buf, Selection.getSelectionEnd(buf));
                }

                buf.removeSpan(Timeout.this);
            }
        }
        
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.568 -0500", hash_original_method = "A7E02D03E9AB7CF614DD169102D03FAF", hash_generated_method = "D0D44080BF1B8B0853634EBEFA340901")
    
public void onSpanAdded(Spannable s, Object what, int start, int end) { }
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.571 -0500", hash_original_method = "2C716670C272F54C9EB4064D90DB3C4E", hash_generated_method = "5B4B7AFD86AC085C95BBA97BAFF2BD93")
    
public void onSpanRemoved(Spannable s, Object what, int start, int end) { }
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

