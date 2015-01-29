package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

public class PasswordTransformationMethod implements TransformationMethod, TextWatcher {

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.836 -0500", hash_original_method = "AA586779493D0903CD5D98EFA63FCB15", hash_generated_method = "15A79EC119B711DE3CE66CEF2A96A5AC")
    
public static PasswordTransformationMethod getInstance() {
        if (sInstance != null)
            return sInstance;

        sInstance = new PasswordTransformationMethod();
        return sInstance;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.850 -0500", hash_original_method = "6C010EB424FCB8CA68C1612A5903637F", hash_generated_method = "164DA6C47BD2D6A76ADCAD98E5918974")
    
private static void removeVisibleSpans(Spannable sp) {
        Visible[] old = sp.getSpans(0, sp.length(), Visible.class);
        for (int i = 0; i < old.length; i++) {
            sp.removeSpan(old[i]);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.898 -0500", hash_original_field = "F9A096E457BF4DBE8BDA2B5A971BDD43", hash_generated_field = "1FFE1A33712E744FBA36248DA7E399EB")

    private static PasswordTransformationMethod sInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.901 -0500", hash_original_field = "D233CB3C5DA5D67DABE4BD8181A5C4FB", hash_generated_field = "C2C57B7CF6BBB168D84B800403D461E8")

    private static char DOT = '\u2022';
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.520 -0400", hash_original_method = "D8EF6B070A80A550C154BD7630CF21E0", hash_generated_method = "D8EF6B070A80A550C154BD7630CF21E0")
    public PasswordTransformationMethod ()
    {
        //Synthesized constructor
    }
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.832 -0500", hash_original_method = "46C31F1840FDB44A1F40EC87B2DB5960", hash_generated_method = "6F5BB88E5202740C45B7E1BE13CC66A3")
    
public CharSequence getTransformation(CharSequence source, View view) {
        if (source instanceof Spannable) {
            Spannable sp = (Spannable) source;

            /*
             * Remove any references to other views that may still be
             * attached.  This will happen when you flip the screen
             * while a password field is showing; there will still
             * be references to the old EditText in the text.
             */
            ViewReference[] vr = sp.getSpans(0, sp.length(),
                                             ViewReference.class);
            for (int i = 0; i < vr.length; i++) {
                sp.removeSpan(vr[i]);
            }

            removeVisibleSpans(sp);

            sp.setSpan(new ViewReference(view), 0, 0,
                       Spannable.SPAN_POINT_POINT);
        }

        return new PasswordCharSequence(source);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.838 -0500", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "AE3A8B08EEC13AABB2ABA2B67ABDF3FC")
    
public void beforeTextChanged(CharSequence s, int start,
                                  int count, int after) {
        // This callback isn't used.
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.842 -0500", hash_original_method = "E9233B27956FDFC70D77F5557A52BB47", hash_generated_method = "2B3F1DB612245BBF5F597E99F112FCCC")
    
public void onTextChanged(CharSequence s, int start,
                              int before, int count) {
        if (s instanceof Spannable) {
            Spannable sp = (Spannable) s;
            ViewReference[] vr = sp.getSpans(0, s.length(),
                                             ViewReference.class);
            if (vr.length == 0) {
                return;
            }

            /*
             * There should generally only be one ViewReference in the text,
             * but make sure to look through all of them if necessary in case
             * something strange is going on.  (We might still end up with
             * multiple ViewReferences if someone moves text from one password
             * field to another.)
             */
            View v = null;
            for (int i = 0; v == null && i < vr.length; i++) {
                v = vr[i].get();
            }

            if (v == null) {
                return;
            }

            int pref = TextKeyListener.getInstance().getPrefs(v.getContext());
            if ((pref & TextKeyListener.SHOW_PASSWORD) != 0) {
                if (count > 0) {
                    removeVisibleSpans(sp);

                    if (count == 1) {
                        sp.setSpan(new Visible(sp, this), start, start + count,
                                   Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            }
        }
    }
    
    private static class PasswordCharSequence implements CharSequence, GetChars {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.872 -0500", hash_original_field = "EBB181D64752DA6F9BB9A9E1DB00BBD4", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.854 -0500", hash_original_method = "4CDD8381D1031BF5EFE2F94225E565AD", hash_generated_method = "172FA83AAFF0B372C914B8903421CA79")
        
public PasswordCharSequence(CharSequence source) {
            mSource = source;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.857 -0500", hash_original_method = "FE3E30D6F998A38B269E405486258D53", hash_generated_method = "2718F2DD1771250DF29BF44C4628A630")
        
public int length() {
            return mSource.length();
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.860 -0500", hash_original_method = "9EC5613B57D481274808D46BD66F08EC", hash_generated_method = "1E0A0845D6A0BA9F9D848D44E9318E5A")
        
public char charAt(int i) {
            if (mSource instanceof Spanned) {
                Spanned sp = (Spanned) mSource;

                int st = sp.getSpanStart(TextKeyListener.ACTIVE);
                int en = sp.getSpanEnd(TextKeyListener.ACTIVE);

                if (i >= st && i < en) {
                    return mSource.charAt(i);
                }

                Visible[] visible = sp.getSpans(0, sp.length(), Visible.class);

                for (int a = 0; a < visible.length; a++) {
                    if (sp.getSpanStart(visible[a].mTransformer) >= 0) {
                        st = sp.getSpanStart(visible[a]);
                        en = sp.getSpanEnd(visible[a]);

                        if (i >= st && i < en) {
                            return mSource.charAt(i);
                        }
                    }
                }
            }

            return DOT;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.863 -0500", hash_original_method = "D736D7B90470DFC8C923D4B5D62B4D1D", hash_generated_method = "AD56006EF135C03737EF8A0AA3AFFC1A")
        
public CharSequence subSequence(int start, int end) {
            char[] buf = new char[end - start];

            getChars(start, end, buf, 0);
            return new String(buf);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.866 -0500", hash_original_method = "814020AAFF189164368E5EE6B0F105D9", hash_generated_method = "A5417B0278FB33D6DA20891854F0B0C7")
        
public String toString() {
            return subSequence(0, length()).toString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.869 -0500", hash_original_method = "B2B91CFAAB9E07A038BB0750D42A99E3", hash_generated_method = "A0279A9A57B0795C3DB936BAE496C9B4")
        
public void getChars(int start, int end, char[] dest, int off) {
            TextUtils.getChars(mSource, start, end, dest, off);

            int st = -1, en = -1;
            int nvisible = 0;
            int[] starts = null, ends = null;

            if (mSource instanceof Spanned) {
                Spanned sp = (Spanned) mSource;

                st = sp.getSpanStart(TextKeyListener.ACTIVE);
                en = sp.getSpanEnd(TextKeyListener.ACTIVE);

                Visible[] visible = sp.getSpans(0, sp.length(), Visible.class);
                nvisible = visible.length;
                starts = new int[nvisible];
                ends = new int[nvisible];

                for (int i = 0; i < nvisible; i++) {
                    if (sp.getSpanStart(visible[i].mTransformer) >= 0) {
                        starts[i] = sp.getSpanStart(visible[i]);
                        ends[i] = sp.getSpanEnd(visible[i]);
                    }
                }
            }

            for (int i = start; i < end; i++) {
                if (! (i >= st && i < en)) {
                    boolean visible = false;

                    for (int a = 0; a < nvisible; a++) {
                        if (i >= starts[a] && i < ends[a]) {
                            visible = true;
                            break;
                        }
                    }

                    if (!visible) {
                        dest[i - start + off] = DOT;
                    }
                }
            }
        }
        
    }
    
    private static class Visible extends Handler implements UpdateLayout, Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.885 -0500", hash_original_field = "071D340B69B4C02750694E000D06B19D", hash_generated_field = "9BDF71D4F7023B7CA73EE663EDAF283F")

        private Spannable mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.888 -0500", hash_original_field = "88D6027FCCB55372770CD3F0744ABFA8", hash_generated_field = "ACBDFE8CB9902234B1CF9642C13663A8")

        private PasswordTransformationMethod mTransformer;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.879 -0500", hash_original_method = "FF4274DAFF106899CDED6A946D5BF028", hash_generated_method = "B1DD0B4736B0E0C32B1DA59815B96DC0")
        
public Visible(Spannable sp, PasswordTransformationMethod ptm) {
            mText = sp;
            mTransformer = ptm;
            postAtTime(this, SystemClock.uptimeMillis() + 1500);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.882 -0500", hash_original_method = "C8775617BEE64680D27DACE05ECB8A14", hash_generated_method = "A92442E8F9C1AF5B3A11D2EFF5D4C7E3")
        
public void run() {
            mText.removeSpan(this);
        }
        
    }
    
    private static class ViewReference extends WeakReference<View> implements NoCopySpan {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.893 -0500", hash_original_method = "8A425A895F2F15617289F8E7C481E0F9", hash_generated_method = "32C09C84E993DB72736F91D4F9FF9F9E")
        
public ViewReference(View v) {
            super(v);
        }
        
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.844 -0500", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "BCC5CE13C93AE0C11949F22689C8EE7B")
    
public void afterTextChanged(Editable s) {
        // This callback isn't used.
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.847 -0500", hash_original_method = "D64B8AB73A1F5CA65D62622D3C82E686", hash_generated_method = "6B672CB949B078F48F94F200F8FE6288")
    
public void onFocusChanged(View view, CharSequence sourceText,
                               boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        if (!focused) {
            if (sourceText instanceof Spannable) {
                Spannable sp = (Spannable) sourceText;

                removeVisibleSpans(sp);
            }
        }
    }
}

