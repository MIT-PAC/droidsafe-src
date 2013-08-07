package android.text;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.BreakIterator;






public class Selection {
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.152 -0400", hash_original_method = "B8D298D1C681D859448C141B901530AF", hash_generated_method = "43EBC81447082EA8B9876FF117E2ADA5")
    private  Selection() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static final int getSelectionStart(CharSequence text) {
        if (text instanceof Spanned)
            return ((Spanned) text).getSpanStart(SELECTION_START);
        else
            return -1;
    }

    
    @DSModeled(DSC.SAFE)
    public static final int getSelectionEnd(CharSequence text) {
        if (text instanceof Spanned)
            return ((Spanned) text).getSpanStart(SELECTION_END);
        else
            return -1;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static final void setSelection(Spannable text, int index) {
        setSelection(text, index, index);
    }

    
    @DSModeled(DSC.SAFE)
    public static final void selectAll(Spannable text) {
        setSelection(text, 0, text.length());
    }

    
    @DSModeled(DSC.SAFE)
    public static final void extendSelection(Spannable text, int index) {
        if (text.getSpanStart(SELECTION_END) != index)
            text.setSpan(SELECTION_END, index, index, Spanned.SPAN_POINT_POINT);
    }

    
    @DSModeled(DSC.SAFE)
    public static final void removeSelection(Spannable text) {
        text.removeSpan(SELECTION_START);
        text.removeSpan(SELECTION_END);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static boolean extendLeft(Spannable text, Layout layout) {
        int end = getSelectionEnd(text);
        int to = layout.getOffsetToLeftOf(end);
        if (to != end) {
            extendSelection(text, to);
            return true;
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean extendRight(Spannable text, Layout layout) {
        int end = getSelectionEnd(text);
        int to = layout.getOffsetToRightOf(end);
        if (to != end) {
            extendSelection(text, to);
            return true;
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean extendToLeftEdge(Spannable text, Layout layout) {
        int where = findEdge(text, layout, -1);
        extendSelection(text, where);
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean extendToRightEdge(Spannable text, Layout layout) {
        int where = findEdge(text, layout, 1);
        extendSelection(text, where);
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean moveToLeftEdge(Spannable text, Layout layout) {
        int where = findEdge(text, layout, -1);
        setSelection(text, where);
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean moveToRightEdge(Spannable text, Layout layout) {
        int where = findEdge(text, layout, 1);
        setSelection(text, where);
        return true;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.156 -0400", hash_original_method = "BDCC342EB9C4EC0E36898772F96B3376", hash_generated_method = "BDCC342EB9C4EC0E36898772F96B3376")
        public START ()
        {
            //Synthesized constructor
        }


    }


    
    private static final class END implements NoCopySpan {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.157 -0400", hash_original_method = "6839406E8175B705075FBD95CC87C416", hash_generated_method = "6839406E8175B705075FBD95CC87C416")
        public END ()
        {
            //Synthesized constructor
        }


    }


    
    public static interface PositionIterator {
        public static final int DONE = BreakIterator.DONE;

        public int preceding(int position);
        public int following(int position);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.157 -0400", hash_original_field = "774417FE7444B450B49E50090115A9F8", hash_generated_field = "04FE8A24144505FFA1AFEFD56C38D3B7")

    public static final Object SELECTION_START = new START();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.157 -0400", hash_original_field = "4C94D592759CA3F5D554F033E438F59A", hash_generated_field = "158301B7D925B39059B5DF4E88882416")

    public static final Object SELECTION_END = new END();
}

