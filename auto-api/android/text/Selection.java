package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.text.BreakIterator;

public class Selection {
    public static final Object SELECTION_START = new START();
    public static final Object SELECTION_END = new END();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.136 -0400", hash_original_method = "B8D298D1C681D859448C141B901530AF", hash_generated_method = "739CA6CE5E4124A40B2110E6662C3657")
    @DSModeled(DSC.SAFE)
    private Selection() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.136 -0400", hash_original_method = "AE65575D1ABDE1468485A6F2E77003DF", hash_generated_method = "D35AE340663B53F8EC961C428B476F9F")
    public static final int getSelectionStart(CharSequence text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if (text instanceof Spanned)
            return ((Spanned) text).getSpanStart(SELECTION_START);
        else
            return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.136 -0400", hash_original_method = "C524353125947C233CA15DF73D6EE511", hash_generated_method = "53C1F9AE5BE00F2F5247D92B71530E7B")
    public static final int getSelectionEnd(CharSequence text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if (text instanceof Spanned)
            return ((Spanned) text).getSpanStart(SELECTION_END);
        else
            return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.137 -0400", hash_original_method = "B4BEDEE094AF6C1F006DC5BB80D1A16C", hash_generated_method = "03FCB152C5EF6A02C1048394FAB60B6E")
    public static void setSelection(Spannable text, int start, int stop) {
        int ostart = getSelectionStart(text);
        int oend = getSelectionEnd(text);
        if (ostart != start || oend != stop) {
            text.setSpan(SELECTION_START, start, start,
                         Spanned.SPAN_POINT_POINT|Spanned.SPAN_INTERMEDIATE);
            text.setSpan(SELECTION_END, stop, stop,
                         Spanned.SPAN_POINT_POINT);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.137 -0400", hash_original_method = "3915D6810DC93FECF1A478B2D9E7D4AB", hash_generated_method = "1FB3050D4C3B69ED05E56D2A516E307D")
    public static final void setSelection(Spannable text, int index) {
        setSelection(text, index, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.137 -0400", hash_original_method = "8AAF0061684BDEF24CE121D97D50E331", hash_generated_method = "E808B5198D0B9FCCFED1EFDBDBBE90F8")
    public static final void selectAll(Spannable text) {
        setSelection(text, 0, text.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.137 -0400", hash_original_method = "E4C321E604F2ECE719104EDDFB63BDB0", hash_generated_method = "97EDE3A00D372C1E022DEA42CBECF36D")
    public static final void extendSelection(Spannable text, int index) {
        if (text.getSpanStart(SELECTION_END) != index)
            text.setSpan(SELECTION_END, index, index, Spanned.SPAN_POINT_POINT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.137 -0400", hash_original_method = "5C9161DAB06FFC26DEFD08AA2119CE87", hash_generated_method = "DF42BB6135AF97EE930FF5F92ECA4DE9")
    public static final void removeSelection(Spannable text) {
        text.removeSpan(SELECTION_START);
        text.removeSpan(SELECTION_END);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.137 -0400", hash_original_method = "84659E8D2499E9B94C3C9DA87DC894C2", hash_generated_method = "DC7FA337B39E7DD93E4BD8DE4974DF9B")
    public static boolean moveUp(Spannable text, Layout layout) {
        int start = getSelectionStart(text);
        int end = getSelectionEnd(text);
        if (start != end) {
            int min = Math.min(start, end);
            int max = Math.max(start, end);
            setSelection(text, min);
            if (min == 0 && max == text.length()) {
                return false;
            }
            return true;
        } else {
            int line = layout.getLineForOffset(end);
            if (line > 0) {
                int move;
                if (layout.getParagraphDirection(line) ==
                    layout.getParagraphDirection(line - 1)) {
                    float h = layout.getPrimaryHorizontal(end);
                    move = layout.getOffsetForHorizontal(line - 1, h);
                } else {
                    move = layout.getLineStart(line - 1);
                }
                setSelection(text, move);
                return true;
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.137 -0400", hash_original_method = "16FEA497919EDD0949C38B06DA431485", hash_generated_method = "B770E97AF6168177C3A5D599944FDB55")
    public static boolean moveDown(Spannable text, Layout layout) {
        int start = getSelectionStart(text);
        int end = getSelectionEnd(text);
        if (start != end) {
            int min = Math.min(start, end);
            int max = Math.max(start, end);
            setSelection(text, max);
            if (min == 0 && max == text.length()) {
                return false;
            }
            return true;
        } else {
            int line = layout.getLineForOffset(end);
            if (line < layout.getLineCount() - 1) {
                int move;
                if (layout.getParagraphDirection(line) ==
                    layout.getParagraphDirection(line + 1)) {
                    float h = layout.getPrimaryHorizontal(end);
                    move = layout.getOffsetForHorizontal(line + 1, h);
                } else {
                    move = layout.getLineStart(line + 1);
                }
                setSelection(text, move);
                return true;
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.137 -0400", hash_original_method = "886D06C73B41A96130122C99A87D9A1E", hash_generated_method = "4190EB8DA3AE329C2739407B96628590")
    public static boolean moveLeft(Spannable text, Layout layout) {
        int start = getSelectionStart(text);
        int end = getSelectionEnd(text);
        if (start != end) {
            setSelection(text, chooseHorizontal(layout, -1, start, end));
            return true;
        } else {
            int to = layout.getOffsetToLeftOf(end);
            if (to != end) {
                setSelection(text, to);
                return true;
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.137 -0400", hash_original_method = "9878C4D1EA7E15D640972CB1C1B47BC2", hash_generated_method = "D45E049D95259AA05C4617233DD50152")
    public static boolean moveRight(Spannable text, Layout layout) {
        int start = getSelectionStart(text);
        int end = getSelectionEnd(text);
        if (start != end) {
            setSelection(text, chooseHorizontal(layout, 1, start, end));
            return true;
        } else {
            int to = layout.getOffsetToRightOf(end);
            if (to != end) {
                setSelection(text, to);
                return true;
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "E0C7099B2739F7871176C3DD136C07EE", hash_generated_method = "031A84DC1E4017CCFF80BEE627C951B4")
    public static boolean extendUp(Spannable text, Layout layout) {
        int end = getSelectionEnd(text);
        int line = layout.getLineForOffset(end);
        if (line > 0) {
            int move;
            if (layout.getParagraphDirection(line) ==
                layout.getParagraphDirection(line - 1)) {
                float h = layout.getPrimaryHorizontal(end);
                move = layout.getOffsetForHorizontal(line - 1, h);
            } else {
                move = layout.getLineStart(line - 1);
            }
            extendSelection(text, move);
            return true;
        } else if (end != 0) {
            extendSelection(text, 0);
            return true;
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "00BC0D111EC862FAD13350B5AA0F9D1E", hash_generated_method = "8F5AE5B486AF4193870583EF801ADCBF")
    public static boolean extendDown(Spannable text, Layout layout) {
        int end = getSelectionEnd(text);
        int line = layout.getLineForOffset(end);
        if (line < layout.getLineCount() - 1) {
            int move;
            if (layout.getParagraphDirection(line) ==
                layout.getParagraphDirection(line + 1)) {
                float h = layout.getPrimaryHorizontal(end);
                move = layout.getOffsetForHorizontal(line + 1, h);
            } else {
                move = layout.getLineStart(line + 1);
            }
            extendSelection(text, move);
            return true;
        } else if (end != text.length()) {
            extendSelection(text, text.length());
            return true;
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "56F4C3294792FD89446A0D99FADD3C38", hash_generated_method = "C4A40F34D299E55140E287CC22E06772")
    public static boolean extendLeft(Spannable text, Layout layout) {
        int end = getSelectionEnd(text);
        int to = layout.getOffsetToLeftOf(end);
        if (to != end) {
            extendSelection(text, to);
            return true;
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "3BC49CCCD30F263AA88A2744E391B929", hash_generated_method = "09D232183D4CC67F935005DB307BCCA5")
    public static boolean extendRight(Spannable text, Layout layout) {
        int end = getSelectionEnd(text);
        int to = layout.getOffsetToRightOf(end);
        if (to != end) {
            extendSelection(text, to);
            return true;
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "0205BF019FC2C9F6FBB3FC9FD7721842", hash_generated_method = "8FA04AFF17B2B1ECA5B854C03423C165")
    public static boolean extendToLeftEdge(Spannable text, Layout layout) {
        int where = findEdge(text, layout, -1);
        extendSelection(text, where);
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "8B8687D591C13058BF74488988B33F93", hash_generated_method = "531C7964741A55E964E5AA1DBEC4EFF6")
    public static boolean extendToRightEdge(Spannable text, Layout layout) {
        int where = findEdge(text, layout, 1);
        extendSelection(text, where);
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "76B52FCF8809A1E40B9E883EF3C172AF", hash_generated_method = "FDC375983A80F8ACB4428CDA9490E01E")
    public static boolean moveToLeftEdge(Spannable text, Layout layout) {
        int where = findEdge(text, layout, -1);
        setSelection(text, where);
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "5ECFFBE13B414364AEA3F0C4E45F8BE1", hash_generated_method = "EE78B3531CE59EB2F4FF16BB35556050")
    public static boolean moveToRightEdge(Spannable text, Layout layout) {
        int where = findEdge(text, layout, 1);
        setSelection(text, where);
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "F362C82CE246817BBC3C68655D1E1FEE", hash_generated_method = "2DDF5734C0EA6AF1A7012B0008041261")
    public static boolean moveToPreceding(
            Spannable text, PositionIterator iter, boolean extendSelection) {
        final int offset = iter.preceding(getSelectionEnd(text));
        if (offset != PositionIterator.DONE) {
            if (extendSelection) {
                extendSelection(text, offset);
            } else {
                setSelection(text, offset);
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "F8C047CC8FE41957278F180243A8CFE3", hash_generated_method = "E9B280F71AC1B7416BB174209F2AEE7B")
    public static boolean moveToFollowing(
            Spannable text, PositionIterator iter, boolean extendSelection) {
        final int offset = iter.following(getSelectionEnd(text));
        if (offset != PositionIterator.DONE) {
            if (extendSelection) {
                extendSelection(text, offset);
            } else {
                setSelection(text, offset);
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "748B9EA4D88C0F8475DB2702F051E182", hash_generated_method = "8406E785C606EDAA865448941FF72854")
    private static int findEdge(Spannable text, Layout layout, int dir) {
        int pt = getSelectionEnd(text);
        int line = layout.getLineForOffset(pt);
        int pdir = layout.getParagraphDirection(line);
        if (dir * pdir < 0) {
            return layout.getLineStart(line);
        } else {
            int end = layout.getLineEnd(line);
            if (line == layout.getLineCount() - 1)
                return end;
            else
                return end - 1;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.138 -0400", hash_original_method = "2FFC3983C19ED05EF29E3BFCF82D23B0", hash_generated_method = "B398D607E03A54DE0D72476BBAC53A4D")
    private static int chooseHorizontal(Layout layout, int direction,
                                        int off1, int off2) {
        int line1 = layout.getLineForOffset(off1);
        int line2 = layout.getLineForOffset(off2);
        if (line1 == line2) {
            float h1 = layout.getPrimaryHorizontal(off1);
            float h2 = layout.getPrimaryHorizontal(off2);
            if (direction < 0) {
                if (h1 < h2)
                    return off1;
                else
                    return off2;
            } else {
                if (h1 > h2)
                    return off1;
                else
                    return off2;
            }
        } else {
            int line = layout.getLineForOffset(off1);
            int textdir = layout.getParagraphDirection(line);
            if (textdir == direction)
                return Math.max(off1, off2);
            else
                return Math.min(off1, off2);
        }
    }

    
    private static final class START implements NoCopySpan {
        
    }


    
    private static final class END implements NoCopySpan {
        
    }


    
    public static interface PositionIterator {
        public static final int DONE = BreakIterator.DONE;

        public int preceding(int position);
        public int following(int position);
    }
    
}


