package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.*;
import android.text.method.TextKeyListener.Capitalize;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;

public class QwertyKeyListener extends BaseKeyListener {
    private Capitalize mAutoCap;
    private boolean mAutoText;
    private boolean mFullKeyboard;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.650 -0400", hash_original_method = "49C27B077A312737DD85C2ED4E150C41", hash_generated_method = "E67A9D0534E19A568BC8DA074E370F7B")
    @DSModeled(DSC.SAFE)
    private QwertyKeyListener(Capitalize cap, boolean autoText, boolean fullKeyboard) {
        dsTaint.addTaint(cap.dsTaint);
        dsTaint.addTaint(autoText);
        dsTaint.addTaint(fullKeyboard);
        // ---------- Original Method ----------
        //mAutoCap = cap;
        //mAutoText = autoText;
        //mFullKeyboard = fullKeyboard;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.650 -0400", hash_original_method = "603DCE8018B8306CEBEFEE75734ABE47", hash_generated_method = "8E214A4CE92201C69B6A4E535A6DE5E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public QwertyKeyListener(Capitalize cap, boolean autoText) {
        this(cap, autoText, false);
        dsTaint.addTaint(cap.dsTaint);
        dsTaint.addTaint(autoText);
        // ---------- Original Method ----------
    }

    
        public static QwertyKeyListener getInstance(boolean autoText, Capitalize cap) {
        int off = cap.ordinal() * 2 + (autoText ? 1 : 0);
        if (sInstance[off] == null) {
            sInstance[off] = new QwertyKeyListener(cap, autoText);
        }
        return sInstance[off];
    }

    
        public static QwertyKeyListener getInstanceForFullKeyboard() {
        if (sFullKeyboardInstance == null) {
            sFullKeyboardInstance = new QwertyKeyListener(Capitalize.NONE, false, true);
        }
        return sFullKeyboardInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.650 -0400", hash_original_method = "77B762D33BA1CBC4DB995B196C907EDB", hash_generated_method = "C68291240985790ED0E1B95EF0161358")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInputType() {
        int var9E11457640925EE0EF1D4E5A2BEB5EA9_876509057 = (makeTextContentType(mAutoCap, mAutoText));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return makeTextContentType(mAutoCap, mAutoText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.653 -0400", hash_original_method = "516B59E01E71ED9ADC80D2A022ED13A5", hash_generated_method = "0085A64FFB188E1BCE50DD60EF55BC74")
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
            {
                selStart = selEnd = 0;
                Selection.setSelection(content, 0, 0);
            } //End block
        } //End block
        int activeStart;
        activeStart = content.getSpanStart(TextKeyListener.ACTIVE);
        int activeEnd;
        activeEnd = content.getSpanEnd(TextKeyListener.ACTIVE);
        int i;
        i = event.getUnicodeChar(event.getMetaState() | getMetaState(content));
        {
            int count;
            count = event.getRepeatCount();
            {
                char c;
                c = content.charAt(selStart - 1);
                {
                    boolean varC5F1B2B62BD79001A5280F11DA6BEEE5_897094977 = (c == i || c == Character.toUpperCase(i) && view != null);
                    {
                        {
                            boolean var3A4CFAE07BB301A00CB69F8E4E4CC5E3_1895830567 = (showCharacterPicker(view, content, c, false, count));
                            {
                                resetMetaState(content);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                showCharacterPicker(view, content,
                                    KeyCharacterMap.PICKER_DIALOG_INPUT, true, 1);
            } //End block
            resetMetaState(content);
        } //End block
        {
            int start;
            {
                start = selEnd;
                {
                    boolean var5100BA0861E05BEDA363AB7F77660DF4_180101703 = (start > 0 && selEnd - start < 4 &&
                       Character.digit(content.charAt(start - 1), 16) >= 0);
                } //End collapsed parenthetic
            } //End block
            {
                start = selStart;
            } //End block
            int ch;
            ch = -1;
            try 
            {
                String hex;
                hex = TextUtils.substring(content, start, selEnd);
                ch = Integer.parseInt(hex, 16);
            } //End block
            catch (NumberFormatException nfe)
            { }
            {
                selStart = start;
                Selection.setSelection(content, selStart, selEnd);
                i = ch;
            } //End block
            {
                i = 0;
            } //End block
        } //End block
        {
            boolean dead;
            dead = false;
            {
                dead = true;
                i = i & KeyCharacterMap.COMBINING_ACCENT_MASK;
            } //End block
            {
                boolean replace;
                replace = false;
                {
                    char accent;
                    accent = content.charAt(selStart);
                    int composed;
                    composed = event.getDeadChar(accent, i);
                    {
                        i = composed;
                        replace = true;
                    } //End block
                } //End block
                {
                    Selection.setSelection(content, selEnd);
                    content.removeSpan(TextKeyListener.ACTIVE);
                    selStart = selEnd;
                } //End block
            } //End block
            {
                boolean varBE145749AB7392F6E9A13E60C4DFB571_1822625169 = ((pref & TextKeyListener.AUTO_CAP) != 0 &&
                Character.isLowerCase(i) && 
                TextKeyListener.shouldCap(mAutoCap, content, selStart));
                {
                    int where;
                    where = content.getSpanEnd(TextKeyListener.CAPPED);
                    int flags;
                    flags = content.getSpanFlags(TextKeyListener.CAPPED);
                    {
                        content.removeSpan(TextKeyListener.CAPPED);
                    } //End block
                    {
                        flags = i << 16;
                        i = Character.toUpperCase(i);
                        content.setSpan(TextKeyListener.CAPPED, 0, 0,
                                        Spannable.SPAN_MARK_MARK | flags);
                        content.setSpan(TextKeyListener.CAPPED,
                                        selStart - 1, selStart,
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE |
                                        flags);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                Selection.setSelection(content, selEnd);
            } //End block
            content.setSpan(OLD_SEL_START, selStart, selStart,
                            Spannable.SPAN_MARK_MARK);
            content.replace(selStart, selEnd, String.valueOf((char) i));
            int oldStart;
            oldStart = content.getSpanStart(OLD_SEL_START);
            selEnd = Selection.getSelectionEnd(content);
            {
                content.setSpan(TextKeyListener.LAST_TYPED,
                                oldStart, selEnd,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                {
                    Selection.setSelection(content, oldStart, selEnd);
                    content.setSpan(TextKeyListener.ACTIVE, oldStart, selEnd,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                } //End block
            } //End block
            adjustMetaAfterKeypress(content);
            {
                boolean var3DE8430D8F4467F6E16B3E1835A79473_250054823 = ((pref & TextKeyListener.AUTO_TEXT) != 0 && mAutoText &&
                (i == ' ' || i == '\t' || i == '\n' ||
                 i == ',' || i == '.' || i == '!' || i == '?' ||
                 i == '"' || Character.getType(i) == Character.END_PUNCTUATION) &&
                 content.getSpanEnd(TextKeyListener.INHIBIT_REPLACEMENT)
                     != oldStart);
                {
                    int x;
                    {
                        x = oldStart;
                        {
                            char c;
                            c = content.charAt(x - 1);
                            {
                                boolean var27F2B2DD6BB1AB52FA2903BF7730F518_726977019 = (c != '\'' && !Character.isLetter(c));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    String rep;
                    rep = getReplacement(content, x, oldStart, view);
                    {
                        Replaced[] repl;
                        repl = content.getSpans(0, content.length(),
                                                     Replaced.class);
                        {
                            int a;
                            a = 0;
                            content.removeSpan(repl[a]);
                        } //End collapsed parenthetic
                        char[] orig;
                        orig = new char[oldStart - x];
                        TextUtils.getChars(content, x, oldStart, orig, 0);
                        content.setSpan(new Replaced(orig), x, oldStart,
                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        content.replace(x, oldStart, rep);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                selEnd = Selection.getSelectionEnd(content);
                {
                    {
                        boolean var855207E6637B920B7394FBEF4F1152A4_108683331 = (content.charAt(selEnd - 1) == ' ' &&
                        content.charAt(selEnd - 2) == ' ');
                        {
                            char c;
                            c = content.charAt(selEnd - 3);
                            {
                                int j;
                                j = selEnd - 3;
                                {
                                    {
                                        boolean var3AE93F7ED5B3E713DF87CEC98770D44B_121303237 = (c == '"' ||
                                Character.getType(c) == Character.END_PUNCTUATION);
                                        {
                                            c = content.charAt(j - 1);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var27BE4AD8BD3DF20B46B4AD84D1293F53_735305666 = (Character.isLetter(c) || Character.isDigit(c));
                                {
                                    content.replace(selEnd - 2, selEnd - 1, ".");
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        {
            boolean var943341EBD10AE8248F41BC7B51FBBC77_524568334 = (keyCode == KeyEvent.KEYCODE_DEL
                && (event.hasNoModifiers() || event.hasModifiers(KeyEvent.META_ALT_ON))
                && selStart == selEnd);
            {
                int consider;
                consider = 1;
                {
                    boolean varD3AC9504E820E0CF7EE2AC672CB96D25_1909323749 = (content.getSpanEnd(TextKeyListener.LAST_TYPED) == selStart);
                    {
                        {
                            boolean var9091D3B32733FD0E4769CD319F1E9809_1635027495 = (content.charAt(selStart - 1) != '\n');
                            consider = 2;
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                Replaced[] repl;
                repl = content.getSpans(selStart - consider, selStart,
                                             Replaced.class);
                {
                    int st;
                    st = content.getSpanStart(repl[0]);
                    int en;
                    en = content.getSpanEnd(repl[0]);
                    String old;
                    old = new String(repl[0].mText);
                    content.removeSpan(repl[0]);
                    {
                        content.setSpan(TextKeyListener.INHIBIT_REPLACEMENT,
                                    en, en, Spannable.SPAN_POINT_POINT);
                        content.replace(st, en, old);
                        en = content.getSpanStart(TextKeyListener.INHIBIT_REPLACEMENT);
                        {
                            content.setSpan(TextKeyListener.INHIBIT_REPLACEMENT,
                                        en - 1, en,
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        } //End block
                        {
                            content.removeSpan(TextKeyListener.INHIBIT_REPLACEMENT);
                        } //End block
                        adjustMetaAfterKeypress(content);
                    } //End block
                    {
                        adjustMetaAfterKeypress(content);
                        boolean var58B6BB38A2D75494923DCF439D1D87C5_810094804 = (super.onKeyDown(view, content, keyCode, event));
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        boolean var250B4652E205BB567180858BBC354846_397379600 = (super.onKeyDown(view, content, keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.654 -0400", hash_original_method = "56CD99307A3C343252D0E9D8CB37E313", hash_generated_method = "83AB8FEDF31E15AD07AF8C40F770AB58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getReplacement(CharSequence src, int start, int end,
                                  View view) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(src);
        dsTaint.addTaint(end);
        int len;
        len = end - start;
        boolean changecase;
        changecase = false;
        String replacement;
        replacement = AutoText.get(src, start, end, view);
        {
            String key;
            key = TextUtils.substring(src, start, end).toLowerCase();
            replacement = AutoText.get(key, 0, end - start, view);
            changecase = true;
        } //End block
        int caps;
        caps = 0;
        {
            {
                int j;
                j = start;
                {
                    {
                        boolean var03EF0CF77F98DD2DEA4339D12B8D9487_1863569498 = (Character.isUpperCase(src.charAt(j)));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        String out;
        out = replacement;
        out = toTitleCase(replacement);
        out = replacement.toUpperCase();
        out = toTitleCase(replacement);
        {
            boolean varCA4381C3F2EBCEEA02732EC71859751E_1012513980 = (out.length() == len &&
            TextUtils.regionMatches(src, start, out, 0, len));
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static void markAsReplaced(Spannable content, int start, int end,
                                      String original) {
        Replaced[] repl = content.getSpans(0, content.length(), Replaced.class);
        for (int a = 0; a < repl.length; a++) {
            content.removeSpan(repl[a]);
        }
        int len = original.length();
        char[] orig = new char[len];
        original.getChars(0, len, orig, 0);
        content.setSpan(new Replaced(orig), start, end,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.655 -0400", hash_original_method = "2E7DB5AEEB189920125EB7B1E5F21218", hash_generated_method = "209B19B1363D9D8475D8A04DA41F4623")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean showCharacterPicker(View view, Editable content, char c,
                                        boolean insert, int count) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(count);
        dsTaint.addTaint(c);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(insert);
        String set;
        set = PICKER_SETS.get(c);
        {
            new CharacterPickerDialog(view.getContext(),
                                      view, content, set, insert).show();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String set = PICKER_SETS.get(c);
        //if (set == null) {
            //return false;
        //}
        //if (count == 1) {
            //new CharacterPickerDialog(view.getContext(),
                                      //view, content, set, insert).show();
        //}
        //return true;
    }

    
        private static String toTitleCase(String src) {
        return Character.toUpperCase(src.charAt(0)) + src.substring(1);
    }

    
    static class Replaced implements NoCopySpan {
        private char[] mText;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.656 -0400", hash_original_method = "573A0A1D2F4880FCE39DFE2EE4242AA3", hash_generated_method = "836243F12CA750BEF8B564A31FB010DF")
        @DSModeled(DSC.SAFE)
        public Replaced(char[] text) {
            dsTaint.addTaint(text[0]);
            // ---------- Original Method ----------
            //mText = text;
        }

        
    }


    
    private static QwertyKeyListener[] sInstance =
        new QwertyKeyListener[Capitalize.values().length * 2];
    private static QwertyKeyListener sFullKeyboardInstance;
    private static SparseArray<String> PICKER_SETS =
                        new SparseArray<String>();
    static {
        PICKER_SETS.put('A', "\u00C0\u00C1\u00C2\u00C4\u00C6\u00C3\u00C5\u0104\u0100");
        PICKER_SETS.put('C', "\u00C7\u0106\u010C");
        PICKER_SETS.put('D', "\u010E");
        PICKER_SETS.put('E', "\u00C8\u00C9\u00CA\u00CB\u0118\u011A\u0112");
        PICKER_SETS.put('G', "\u011E");
        PICKER_SETS.put('L', "\u0141");
        PICKER_SETS.put('I', "\u00CC\u00CD\u00CE\u00CF\u012A\u0130");
        PICKER_SETS.put('N', "\u00D1\u0143\u0147");
        PICKER_SETS.put('O', "\u00D8\u0152\u00D5\u00D2\u00D3\u00D4\u00D6\u014C");
        PICKER_SETS.put('R', "\u0158");
        PICKER_SETS.put('S', "\u015A\u0160\u015E");
        PICKER_SETS.put('T', "\u0164");
        PICKER_SETS.put('U', "\u00D9\u00DA\u00DB\u00DC\u016E\u016A");
        PICKER_SETS.put('Y', "\u00DD\u0178");
        PICKER_SETS.put('Z', "\u0179\u017B\u017D");
        PICKER_SETS.put('a', "\u00E0\u00E1\u00E2\u00E4\u00E6\u00E3\u00E5\u0105\u0101");
        PICKER_SETS.put('c', "\u00E7\u0107\u010D");
        PICKER_SETS.put('d', "\u010F");
        PICKER_SETS.put('e', "\u00E8\u00E9\u00EA\u00EB\u0119\u011B\u0113");
        PICKER_SETS.put('g', "\u011F");
        PICKER_SETS.put('i', "\u00EC\u00ED\u00EE\u00EF\u012B\u0131");
        PICKER_SETS.put('l', "\u0142");
        PICKER_SETS.put('n', "\u00F1\u0144\u0148");
        PICKER_SETS.put('o', "\u00F8\u0153\u00F5\u00F2\u00F3\u00F4\u00F6\u014D");
        PICKER_SETS.put('r', "\u0159");
        PICKER_SETS.put('s', "\u00A7\u00DF\u015B\u0161\u015F");
        PICKER_SETS.put('t', "\u0165");
        PICKER_SETS.put('u', "\u00F9\u00FA\u00FB\u00FC\u016F\u016B");
        PICKER_SETS.put('y', "\u00FD\u00FF");
        PICKER_SETS.put('z', "\u017A\u017C\u017E");
        PICKER_SETS.put(KeyCharacterMap.PICKER_DIALOG_INPUT,
                             "\u2026\u00A5\u2022\u00AE\u00A9\u00B1[]{}\\|");
        PICKER_SETS.put('/', "\\");
        PICKER_SETS.put('1', "\u00b9\u00bd\u2153\u00bc\u215b");
        PICKER_SETS.put('2', "\u00b2\u2154");
        PICKER_SETS.put('3', "\u00b3\u00be\u215c");
        PICKER_SETS.put('4', "\u2074");
        PICKER_SETS.put('5', "\u215d");
        PICKER_SETS.put('7', "\u215e");
        PICKER_SETS.put('0', "\u207f\u2205");
        PICKER_SETS.put('$', "\u00a2\u00a3\u20ac\u00a5\u20a3\u20a4\u20b1");
        PICKER_SETS.put('%', "\u2030");
        PICKER_SETS.put('*', "\u2020\u2021");
        PICKER_SETS.put('-', "\u2013\u2014");
        PICKER_SETS.put('+', "\u00b1");
        PICKER_SETS.put('(', "[{<");
        PICKER_SETS.put(')', "]}>");
        PICKER_SETS.put('!', "\u00a1");
        PICKER_SETS.put('"', "\u201c\u201d\u00ab\u00bb\u02dd");
        PICKER_SETS.put('?', "\u00bf");
        PICKER_SETS.put(',', "\u201a\u201e");
        PICKER_SETS.put('=', "\u2260\u2248\u221e");
        PICKER_SETS.put('<', "\u2264\u00ab\u2039");
        PICKER_SETS.put('>', "\u2265\u00bb\u203a");
    }
    
}

