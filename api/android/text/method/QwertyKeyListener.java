package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.*;
import android.text.method.TextKeyListener.Capitalize;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;

public class QwertyKeyListener extends BaseKeyListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.864 -0400", hash_original_field = "7B00CDF214A58D964DB1FD6D561A182A", hash_generated_field = "BEDDE5D3B36AFDA96122F6739A399D24")

    private Capitalize mAutoCap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.864 -0400", hash_original_field = "3D18F8DF226A678B64C4D4C4D035A79A", hash_generated_field = "C101024EE87082E36D969AEA4683627E")

    private boolean mAutoText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.865 -0400", hash_original_field = "E8D5C34ACA787EB4A26CCB5E05F46B2C", hash_generated_field = "3DB509C5642BF3C24769763A7E5EACB0")

    private boolean mFullKeyboard;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.865 -0400", hash_original_method = "49C27B077A312737DD85C2ED4E150C41", hash_generated_method = "25D87651643C9B230153ECA71855D847")
    private  QwertyKeyListener(Capitalize cap, boolean autoText, boolean fullKeyboard) {
        mAutoCap = cap;
        mAutoText = autoText;
        mFullKeyboard = fullKeyboard;
        // ---------- Original Method ----------
        //mAutoCap = cap;
        //mAutoText = autoText;
        //mFullKeyboard = fullKeyboard;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.866 -0400", hash_original_method = "603DCE8018B8306CEBEFEE75734ABE47", hash_generated_method = "FA006C201779DC6F947B6B1B5A38693F")
    public  QwertyKeyListener(Capitalize cap, boolean autoText) {
        this(cap, autoText, false);
        addTaint(autoText);
        addTaint(cap.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
    public static QwertyKeyListener getInstance(boolean autoText, Capitalize cap) {
        int off = cap.ordinal() * 2 + (autoText ? 1 : 0);
        if (sInstance[off] == null) {
            sInstance[off] = new QwertyKeyListener(cap, autoText);
        }
        return sInstance[off];
    }

    
        @DSModeled(DSC.SAFE)
    public static QwertyKeyListener getInstanceForFullKeyboard() {
        if (sFullKeyboardInstance == null) {
            sFullKeyboardInstance = new QwertyKeyListener(Capitalize.NONE, false, true);
        }
        return sFullKeyboardInstance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.867 -0400", hash_original_method = "77B762D33BA1CBC4DB995B196C907EDB", hash_generated_method = "4079F5B55317F5D74185BECCDA06C17C")
    public int getInputType() {
        int varE5795ACE23B9034FFE40B80EEAF10896_1758341616 = (makeTextContentType(mAutoCap, mAutoText));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527446907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527446907;
        // ---------- Original Method ----------
        //return makeTextContentType(mAutoCap, mAutoText);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.872 -0400", hash_original_method = "516B59E01E71ED9ADC80D2A022ED13A5", hash_generated_method = "E006B5C52189467876DC8C1FA5DFF268")
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        } //End block
        {
            int a = Selection.getSelectionStart(content);
            int b = Selection.getSelectionEnd(content);
            selStart = Math.min(a, b);
            selEnd = Math.max(a, b);
    if(selStart < 0 || selEnd < 0)            
            {
                selStart = selEnd = 0;
                Selection.setSelection(content, 0, 0);
            } //End block
        } //End block
        int activeStart = content.getSpanStart(TextKeyListener.ACTIVE);
        int activeEnd = content.getSpanEnd(TextKeyListener.ACTIVE);
        int i = event.getUnicodeChar(event.getMetaState() | getMetaState(content));
    if(!mFullKeyboard)        
        {
            int count = event.getRepeatCount();
    if(count > 0 && selStart == selEnd && selStart > 0)            
            {
                char c = content.charAt(selStart - 1);
    if(c == i || c == Character.toUpperCase(i) && view != null)                
                {
    if(showCharacterPicker(view, content, c, false, count))                    
                    {
                        resetMetaState(content);
                        boolean varB326B5062B2F0E69046810717534CB09_156411684 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_61299482 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_61299482;
                    } //End block
                } //End block
            } //End block
        } //End block
    if(i == KeyCharacterMap.PICKER_DIALOG_INPUT)        
        {
    if(view != null)            
            {
                showCharacterPicker(view, content,
                                    KeyCharacterMap.PICKER_DIALOG_INPUT, true, 1);
            } //End block
            resetMetaState(content);
            boolean varB326B5062B2F0E69046810717534CB09_922298341 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211707226 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_211707226;
        } //End block
    if(i == KeyCharacterMap.HEX_INPUT)        
        {
            int start;
    if(selStart == selEnd)            
            {
                start = selEnd;
                while
(start > 0 && selEnd - start < 4 &&
                       Character.digit(content.charAt(start - 1), 16) >= 0)                
                {
                    start--;
                } //End block
            } //End block
            else
            {
                start = selStart;
            } //End block
            int ch = -1;
            try 
            {
                String hex = TextUtils.substring(content, start, selEnd);
                ch = Integer.parseInt(hex, 16);
            } //End block
            catch (NumberFormatException nfe)
            {
            } //End block
    if(ch >= 0)            
            {
                selStart = start;
                Selection.setSelection(content, selStart, selEnd);
                i = ch;
            } //End block
            else
            {
                i = 0;
            } //End block
        } //End block
    if(i != 0)        
        {
            boolean dead = false;
    if((i & KeyCharacterMap.COMBINING_ACCENT) != 0)            
            {
                dead = true;
                i = i & KeyCharacterMap.COMBINING_ACCENT_MASK;
            } //End block
    if(activeStart == selStart && activeEnd == selEnd)            
            {
                boolean replace = false;
    if(selEnd - selStart - 1 == 0)                
                {
                    char accent = content.charAt(selStart);
                    int composed = event.getDeadChar(accent, i);
    if(composed != 0)                    
                    {
                        i = composed;
                        replace = true;
                    } //End block
                } //End block
    if(!replace)                
                {
                    Selection.setSelection(content, selEnd);
                    content.removeSpan(TextKeyListener.ACTIVE);
                    selStart = selEnd;
                } //End block
            } //End block
    if((pref & TextKeyListener.AUTO_CAP) != 0 &&
                Character.isLowerCase(i) && 
                TextKeyListener.shouldCap(mAutoCap, content, selStart))            
            {
                int where = content.getSpanEnd(TextKeyListener.CAPPED);
                int flags = content.getSpanFlags(TextKeyListener.CAPPED);
    if(where == selStart && (((flags >> 16) & 0xFFFF) == i))                
                {
                    content.removeSpan(TextKeyListener.CAPPED);
                } //End block
                else
                {
                    flags = i << 16;
                    i = Character.toUpperCase(i);
    if(selStart == 0)                    
                    content.setSpan(TextKeyListener.CAPPED, 0, 0,
                                        Spannable.SPAN_MARK_MARK | flags);
                    else
                    content.setSpan(TextKeyListener.CAPPED,
                                        selStart - 1, selStart,
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE |
                                        flags);
                } //End block
            } //End block
    if(selStart != selEnd)            
            {
                Selection.setSelection(content, selEnd);
            } //End block
            content.setSpan(OLD_SEL_START, selStart, selStart,
                            Spannable.SPAN_MARK_MARK);
            content.replace(selStart, selEnd, String.valueOf((char) i));
            int oldStart = content.getSpanStart(OLD_SEL_START);
            selEnd = Selection.getSelectionEnd(content);
    if(oldStart < selEnd)            
            {
                content.setSpan(TextKeyListener.LAST_TYPED,
                                oldStart, selEnd,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    if(dead)                
                {
                    Selection.setSelection(content, oldStart, selEnd);
                    content.setSpan(TextKeyListener.ACTIVE, oldStart, selEnd,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                } //End block
            } //End block
            adjustMetaAfterKeypress(content);
    if((pref & TextKeyListener.AUTO_TEXT) != 0 && mAutoText &&
                (i == ' ' || i == '\t' || i == '\n' ||
                 i == ',' || i == '.' || i == '!' || i == '?' ||
                 i == '"' || Character.getType(i) == Character.END_PUNCTUATION) &&
                 content.getSpanEnd(TextKeyListener.INHIBIT_REPLACEMENT)
                     != oldStart)            
            {
                int x;
for(x = oldStart;x > 0;x--)
                {
                    char c = content.charAt(x - 1);
    if(c != '\'' && !Character.isLetter(c))                    
                    {
                        break;
                    } //End block
                } //End block
                String rep = getReplacement(content, x, oldStart, view);
    if(rep != null)                
                {
                    Replaced[] repl = content.getSpans(0, content.length(),
                                                     Replaced.class);
for(int a = 0;a < repl.length;a++)
                    content.removeSpan(repl[a]);
                    char[] orig = new char[oldStart - x];
                    TextUtils.getChars(content, x, oldStart, orig, 0);
                    content.setSpan(new Replaced(orig), x, oldStart,
                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    content.replace(x, oldStart, rep);
                } //End block
            } //End block
    if((pref & TextKeyListener.AUTO_PERIOD) != 0 && mAutoText)            
            {
                selEnd = Selection.getSelectionEnd(content);
    if(selEnd - 3 >= 0)                
                {
    if(content.charAt(selEnd - 1) == ' ' &&
                        content.charAt(selEnd - 2) == ' ')                    
                    {
                        char c = content.charAt(selEnd - 3);
for(int j = selEnd - 3;j > 0;j--)
                        {
    if(c == '"' ||
                                Character.getType(c) == Character.END_PUNCTUATION)                            
                            {
                                c = content.charAt(j - 1);
                            } //End block
                            else
                            {
                                break;
                            } //End block
                        } //End block
    if(Character.isLetter(c) || Character.isDigit(c))                        
                        {
                            content.replace(selEnd - 2, selEnd - 1, ".");
                        } //End block
                    } //End block
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_299516280 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916975659 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_916975659;
        } //End block
        else
    if(keyCode == KeyEvent.KEYCODE_DEL
                && (event.hasNoModifiers() || event.hasModifiers(KeyEvent.META_ALT_ON))
                && selStart == selEnd)        
        {
            int consider = 1;
    if(content.getSpanEnd(TextKeyListener.LAST_TYPED) == selStart)            
            {
    if(content.charAt(selStart - 1) != '\n')                
                consider = 2;
            } //End block
            Replaced[] repl = content.getSpans(selStart - consider, selStart,
                                             Replaced.class);
    if(repl.length > 0)            
            {
                int st = content.getSpanStart(repl[0]);
                int en = content.getSpanEnd(repl[0]);
                String old = new String(repl[0].mText);
                content.removeSpan(repl[0]);
    if(selStart >= en)                
                {
                    content.setSpan(TextKeyListener.INHIBIT_REPLACEMENT,
                                    en, en, Spannable.SPAN_POINT_POINT);
                    content.replace(st, en, old);
                    en = content.getSpanStart(TextKeyListener.INHIBIT_REPLACEMENT);
    if(en - 1 >= 0)                    
                    {
                        content.setSpan(TextKeyListener.INHIBIT_REPLACEMENT,
                                        en - 1, en,
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } //End block
                    else
                    {
                        content.removeSpan(TextKeyListener.INHIBIT_REPLACEMENT);
                    } //End block
                    adjustMetaAfterKeypress(content);
                } //End block
                else
                {
                    adjustMetaAfterKeypress(content);
                    boolean var5F21C6842D9E32D23C5A1CD0B3EB473F_1321290803 = (super.onKeyDown(view, content, keyCode, event));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351066748 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_351066748;
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_730310242 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852364101 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852364101;
            } //End block
        } //End block
        boolean var5F21C6842D9E32D23C5A1CD0B3EB473F_837146795 = (super.onKeyDown(view, content, keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_569572632 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_569572632;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.876 -0400", hash_original_method = "56CD99307A3C343252D0E9D8CB37E313", hash_generated_method = "D6E3184FFD2722F5C47E7C5127C0B441")
    private String getReplacement(CharSequence src, int start, int end,
                                  View view) {
        addTaint(view.getTaint());
        addTaint(end);
        addTaint(start);
        addTaint(src.getTaint());
        int len = end - start;
        boolean changecase = false;
        String replacement = AutoText.get(src, start, end, view);
    if(replacement == null)        
        {
            String key = TextUtils.substring(src, start, end).toLowerCase();
            replacement = AutoText.get(key, 0, end - start, view);
            changecase = true;
    if(replacement == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1677611439 =             null;
            var540C13E9E156B687226421B24F2DF178_1677611439.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1677611439;
            }
        } //End block
        int caps = 0;
    if(changecase)        
        {
for(int j = start;j < end;j++)
            {
    if(Character.isUpperCase(src.charAt(j)))                
                caps++;
            } //End block
        } //End block
        String out;
    if(caps == 0)        
        out = replacement;
        else
    if(caps == 1)        
        out = toTitleCase(replacement);
        else
    if(caps == len)        
        out = replacement.toUpperCase();
        else
        out = toTitleCase(replacement);
    if(out.length() == len &&
            TextUtils.regionMatches(src, start, out, 0, len))        
        {
String var540C13E9E156B687226421B24F2DF178_1310292846 =         null;
        var540C13E9E156B687226421B24F2DF178_1310292846.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1310292846;
        }
String varFE81D892BE5757A0E16305825903D324_1953475984 =         out;
        varFE81D892BE5757A0E16305825903D324_1953475984.addTaint(taint);
        return varFE81D892BE5757A0E16305825903D324_1953475984;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.877 -0400", hash_original_method = "2E7DB5AEEB189920125EB7B1E5F21218", hash_generated_method = "C74005D828BFA17E45C4DE69C7E5F920")
    private boolean showCharacterPicker(View view, Editable content, char c,
                                        boolean insert, int count) {
        addTaint(count);
        addTaint(insert);
        addTaint(c);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        String set = PICKER_SETS.get(c);
    if(set == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1574624491 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426551582 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_426551582;
        } //End block
    if(count == 1)        
        {
            new CharacterPickerDialog(view.getContext(),
                                      view, content, set, insert).show();
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_622706103 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1116703319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1116703319;
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

    
        @DSModeled(DSC.SAFE)
    private static String toTitleCase(String src) {
        return Character.toUpperCase(src.charAt(0)) + src.substring(1);
    }

    
    static class Replaced implements NoCopySpan {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.878 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "6CB0C9E6186F94D00B15A6B38EEADB93")

        private char[] mText;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.878 -0400", hash_original_method = "573A0A1D2F4880FCE39DFE2EE4242AA3", hash_generated_method = "F3CF1157AFAB5B17CB35BAA0BE11F0EA")
        public  Replaced(char[] text) {
            mText = text;
            // ---------- Original Method ----------
            //mText = text;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.878 -0400", hash_original_field = "F9206C96BBCA189D22081DA724E73D1B", hash_generated_field = "A353237BA01032703B8EE72570666A29")

    private static QwertyKeyListener[] sInstance = new QwertyKeyListener[Capitalize.values().length * 2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.878 -0400", hash_original_field = "F53CA65E6FEC35EFA0729594589A1225", hash_generated_field = "651B32B3E93CD00CBF35BC8DCF79F33D")

    private static QwertyKeyListener sFullKeyboardInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.878 -0400", hash_original_field = "2CC1FA577466A7C6E331BBC4411C3419", hash_generated_field = "874843BFD3C716ACB6504590F54D3C63")

    private static SparseArray<String> PICKER_SETS = new SparseArray<String>();
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

