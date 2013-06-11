package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class ArrowKeyMovementMethod extends BaseMovementMethod implements MovementMethod {
    private static final Object LAST_TAP_DOWN = new Object();
    private static ArrowKeyMovementMethod sInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.034 -0400", hash_original_method = "10FB2C5181FC75DCDE827D6825AC823C", hash_generated_method = "3DF60ED1FB680D7B0FC31C6971FBC7AB")
    private static boolean isSelecting(Spannable buffer) {
        return ((MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SHIFT_ON) == 1) ||
                (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.034 -0400", hash_original_method = "B32CF67C9FC1D2460F3CDAFFC02432C6", hash_generated_method = "E50627C444B7462E735DEC4717099E16")
    private static int getCurrentLineTop(Spannable buffer, Layout layout) {
        return layout.getLineTop(layout.getLineForOffset(Selection.getSelectionEnd(buffer)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.034 -0400", hash_original_method = "198FB1E56D73131196EB8E515A75F310", hash_generated_method = "C1537F7EF88680ACCCDC57FFB5D8EC81")
    private static int getPageHeight(TextView widget) {
        final Rect rect = new Rect();
        return widget.getGlobalVisibleRect(rect) ? rect.height() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.034 -0400", hash_original_method = "71AB0E1C222F7165F2E5407A96AE4AA1", hash_generated_method = "FFAA5D3B000E61732FE969ACDAC3FBD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean handleMovementKey(TextView widget, Spannable buffer, int keyCode,
            int movementMetaState, KeyEvent event) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        dsTaint.addTaint(movementMetaState);
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1021770688 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                {
                    boolean var76939DA1EC207A63458F74083CB75919_48615703 = (event.getAction() == KeyEvent.ACTION_DOWN
                            && event.getRepeatCount() == 0
                            && MetaKeyKeyListener.getMetaState(buffer,
                                        MetaKeyKeyListener.META_SELECTING) != 0);
                    {
                        boolean var73B0288BF23C1878DD5D23C7B8DE645A_1562273167 = (widget.showContextMenu());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER 
        boolean varB3AE6E56434D9D50711491B13D9952B2_1760566137 = (super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_DPAD_CENTER:
                //if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    //if (event.getAction() == KeyEvent.ACTION_DOWN
                            //&& event.getRepeatCount() == 0
                            //&& MetaKeyKeyListener.getMetaState(buffer,
                                        //MetaKeyKeyListener.META_SELECTING) != 0) {
                        //return widget.showContextMenu();
                    //}
                //}
                //break;
        //}
        //return super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.034 -0400", hash_original_method = "EF44D7EB21450A63AD253DA49BF056E0", hash_generated_method = "06B21ECFDAB7151FC7C5EA45E06DDD71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        final Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_1999045536 = (isSelecting(buffer));
            {
                boolean varCDC07301B68653E82EF77D5D3E7D066F_805465013 = (Selection.extendLeft(buffer, layout));
            } //End block
            {
                boolean varC4BF08D777B0A042F49FED3028D7D05A_544009416 = (Selection.moveLeft(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendLeft(buffer, layout);
        //} else {
            //return Selection.moveLeft(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.034 -0400", hash_original_method = "B7F7970A1171CA8F77BB045891103F0E", hash_generated_method = "D1F3BBC5DA79E72D7FF22F5307EBBF10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        final Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_2039044690 = (isSelecting(buffer));
            {
                boolean var67ECF37412B30F89073547F3C34324B4_1157619077 = (Selection.extendRight(buffer, layout));
            } //End block
            {
                boolean var8EC8DA8DE281B3C82BC4665C217C5696_1070989454 = (Selection.moveRight(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendRight(buffer, layout);
        //} else {
            //return Selection.moveRight(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.035 -0400", hash_original_method = "66883526BDCDE7C41943B5DCF27F9554", hash_generated_method = "BE82835F0C53296CE68AAA89CBB95274")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        final Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_2097307051 = (isSelecting(buffer));
            {
                boolean varDE99DF773D51054F95D78312B8DB7CA7_1356121030 = (Selection.extendUp(buffer, layout));
            } //End block
            {
                boolean var729357B9FFAC7F8AFC1E8A39E3C60461_618368296 = (Selection.moveUp(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendUp(buffer, layout);
        //} else {
            //return Selection.moveUp(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.035 -0400", hash_original_method = "6DF71BB34A28EC828AC8FDD5308B170F", hash_generated_method = "04372BADC60FCE57E931F5021B46D3D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        final Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_1289413294 = (isSelecting(buffer));
            {
                boolean var1DF63A314E4C0F2F8159D81EED847F8F_1717706945 = (Selection.extendDown(buffer, layout));
            } //End block
            {
                boolean var952F4A80043476B1BF22E477488F97C8_548723134 = (Selection.moveDown(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendDown(buffer, layout);
        //} else {
            //return Selection.moveDown(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.035 -0400", hash_original_method = "0758556D4F657617BD5DD9C53A72AD4E", hash_generated_method = "10C8BA7EE4A19CDFDC0DE308CDDED2C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        final Layout layout;
        layout = widget.getLayout();
        final boolean selecting;
        selecting = isSelecting(buffer);
        final int targetY;
        targetY = getCurrentLineTop(buffer, layout) - getPageHeight(widget);
        boolean handled;
        handled = false;
        {
            final int previousSelectionEnd;
            previousSelectionEnd = Selection.getSelectionEnd(buffer);
            {
                Selection.extendUp(buffer, layout);
            } //End block
            {
                Selection.moveUp(buffer, layout);
            } //End block
            {
                boolean var4733E7C82A69173F794B955030939C99_1286988058 = (Selection.getSelectionEnd(buffer) == previousSelectionEnd);
            } //End collapsed parenthetic
            handled = true;
            {
                boolean varB9CAEB7B78A7F0585D0C5FEFD36222F8_472803898 = (getCurrentLineTop(buffer, layout) <= targetY);
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //final boolean selecting = isSelecting(buffer);
        //final int targetY = getCurrentLineTop(buffer, layout) - getPageHeight(widget);
        //boolean handled = false;
        //for (;;) {
            //final int previousSelectionEnd = Selection.getSelectionEnd(buffer);
            //if (selecting) {
                //Selection.extendUp(buffer, layout);
            //} else {
                //Selection.moveUp(buffer, layout);
            //}
            //if (Selection.getSelectionEnd(buffer) == previousSelectionEnd) {
                //break;
            //}
            //handled = true;
            //if (getCurrentLineTop(buffer, layout) <= targetY) {
                //break;
            //}
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.035 -0400", hash_original_method = "A67CFCD6529729C61F17F48248354AB4", hash_generated_method = "4F09C075A9344E624BA73E7CA814FA79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        final Layout layout;
        layout = widget.getLayout();
        final boolean selecting;
        selecting = isSelecting(buffer);
        final int targetY;
        targetY = getCurrentLineTop(buffer, layout) + getPageHeight(widget);
        boolean handled;
        handled = false;
        {
            final int previousSelectionEnd;
            previousSelectionEnd = Selection.getSelectionEnd(buffer);
            {
                Selection.extendDown(buffer, layout);
            } //End block
            {
                Selection.moveDown(buffer, layout);
            } //End block
            {
                boolean var4733E7C82A69173F794B955030939C99_1084311550 = (Selection.getSelectionEnd(buffer) == previousSelectionEnd);
            } //End collapsed parenthetic
            handled = true;
            {
                boolean varF64B0272FDC6514D4788816B81B860EC_486710406 = (getCurrentLineTop(buffer, layout) >= targetY);
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //final boolean selecting = isSelecting(buffer);
        //final int targetY = getCurrentLineTop(buffer, layout) + getPageHeight(widget);
        //boolean handled = false;
        //for (;;) {
            //final int previousSelectionEnd = Selection.getSelectionEnd(buffer);
            //if (selecting) {
                //Selection.extendDown(buffer, layout);
            //} else {
                //Selection.moveDown(buffer, layout);
            //}
            //if (Selection.getSelectionEnd(buffer) == previousSelectionEnd) {
                //break;
            //}
            //handled = true;
            //if (getCurrentLineTop(buffer, layout) >= targetY) {
                //break;
            //}
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.035 -0400", hash_original_method = "06E1F50FC60AD51807CA9DABCD3FCC05", hash_generated_method = "2144B546212A99D1650759CE5C240DFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_790335349 = (isSelecting(buffer));
            {
                Selection.extendSelection(buffer, 0);
            } //End block
            {
                Selection.setSelection(buffer, 0);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isSelecting(buffer)) {
            //Selection.extendSelection(buffer, 0);
        //} else {
            //Selection.setSelection(buffer, 0);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.036 -0400", hash_original_method = "BBC6BB5270095971A5BCCB29BC5686E5", hash_generated_method = "91FFF5FE36238B91594E95052733436A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_834603444 = (isSelecting(buffer));
            {
                Selection.extendSelection(buffer, buffer.length());
            } //End block
            {
                Selection.setSelection(buffer, buffer.length());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isSelecting(buffer)) {
            //Selection.extendSelection(buffer, buffer.length());
        //} else {
            //Selection.setSelection(buffer, buffer.length());
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.036 -0400", hash_original_method = "7B8F77C5EC46A68660F722ECA60D096A", hash_generated_method = "8F614B00B710808436510C254750603D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        final Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_1550613823 = (isSelecting(buffer));
            {
                boolean var07305073A8F196E2FB7735E331F954A0_1643904027 = (Selection.extendToLeftEdge(buffer, layout));
            } //End block
            {
                boolean var839412FED6549C29C28824CEFDCE0017_1212145464 = (Selection.moveToLeftEdge(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendToLeftEdge(buffer, layout);
        //} else {
            //return Selection.moveToLeftEdge(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.036 -0400", hash_original_method = "35F3ADFF6FA8FAD8E2E9FED3F3766C71", hash_generated_method = "C5302118504024D8EBF81A5D3AAF3D9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        final Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_1034245667 = (isSelecting(buffer));
            {
                boolean var781475A0D78601F054522A5C6B281C44_913558867 = (Selection.extendToRightEdge(buffer, layout));
            } //End block
            {
                boolean varC1D1956BB9F1FD7167AC12BE8515B8A9_2091414893 = (Selection.moveToRightEdge(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendToRightEdge(buffer, layout);
        //} else {
            //return Selection.moveToRightEdge(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.036 -0400", hash_original_method = "67D023CBFAD79BEA97EFF9BE9D5119F7", hash_generated_method = "391364600CCAD486062A7AC2F9CDCC70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean leftWord(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        final int selectionEnd;
        selectionEnd = widget.getSelectionEnd();
        final WordIterator wordIterator;
        wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        boolean var00DC013268CCCEB562BE79BDEE107BFD_2132999941 = (Selection.moveToPreceding(buffer, wordIterator, isSelecting(buffer)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int selectionEnd = widget.getSelectionEnd();
        //final WordIterator wordIterator = widget.getWordIterator();
        //wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        //return Selection.moveToPreceding(buffer, wordIterator, isSelecting(buffer));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.036 -0400", hash_original_method = "117E80B3C82F659E45802A24AF653E84", hash_generated_method = "9DB824386EAE8B9F435DF120BCF33717")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean rightWord(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        final int selectionEnd;
        selectionEnd = widget.getSelectionEnd();
        final WordIterator wordIterator;
        wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        boolean var1663946D21B0253D2BA5F3A9E29A5557_1979947576 = (Selection.moveToFollowing(buffer, wordIterator, isSelecting(buffer)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int selectionEnd = widget.getSelectionEnd();
        //final WordIterator wordIterator = widget.getWordIterator();
        //wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        //return Selection.moveToFollowing(buffer, wordIterator, isSelecting(buffer));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.036 -0400", hash_original_method = "DA5AF1C545D6EFE1C03B36F52D97E891", hash_generated_method = "2B5B8EA0E7106F575EA510923EBD345A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var15D6AAE84B1824A04ABA9DFAD2A0EF2B_1790865992 = (lineStart(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return lineStart(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.036 -0400", hash_original_method = "ED4119443F83D3A11CB1CCD10457DD79", hash_generated_method = "2FCF6A4EA65CF5B3F9FF720BC3DA4B04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var7D30E610B15E5CA72FE602D226D165B2_82168851 = (lineEnd(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return lineEnd(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.037 -0400", hash_original_method = "775DDAA4B9285FEC985F9D7EBE9B59EB", hash_generated_method = "42243AC52C59374B47F419468443CD73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        int initialScrollX;
        initialScrollX = -1;
        int initialScrollY;
        initialScrollY = -1;
        final int action;
        action = event.getAction();
        {
            initialScrollX = Touch.getInitialScrollX(widget, buffer);
            initialScrollY = Touch.getInitialScrollY(widget, buffer);
        } //End block
        boolean handled;
        handled = Touch.onTouchEvent(widget, buffer, event);
        {
            boolean varB26B19C2F6D79EF4FEDF57316F6290F6_927167068 = (widget.isFocused() && !widget.didTouchFocusSelect());
            {
                {
                    {
                        boolean varEF5C4D8D9A9043E70D0670EF6B805231_1827673276 = (isSelecting(buffer));
                        {
                            int offset;
                            offset = widget.getOffsetForPosition(event.getX(), event.getY());
                            buffer.setSpan(LAST_TAP_DOWN, offset, offset, Spannable.SPAN_POINT_POINT);
                            widget.getParent().requestDisallowInterceptTouchEvent(true);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varF3BD3294A0EDF892E6B430CAE4F4B9A3_1746835115 = (isSelecting(buffer) && handled);
                        {
                            widget.cancelLongPress();
                            int offset;
                            offset = widget.getOffsetForPosition(event.getX(), event.getY());
                            Selection.extendSelection(buffer, offset);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varA5065FE199EB21698026F41C929E052F_1390033663 = ((initialScrollY >= 0 && initialScrollY != widget.getScrollY()) ||
                    (initialScrollX >= 0 && initialScrollX != widget.getScrollX()));
                        {
                            widget.moveCursorToVisibleOffset();
                        } //End block
                    } //End collapsed parenthetic
                    int offset;
                    offset = widget.getOffsetForPosition(event.getX(), event.getY());
                    {
                        boolean varEF5C4D8D9A9043E70D0670EF6B805231_394398229 = (isSelecting(buffer));
                        {
                            buffer.removeSpan(LAST_TAP_DOWN);
                            Selection.extendSelection(buffer, offset);
                        } //End block
                        {
                            boolean var1DBE2387C29CB59C93933696E5F33161_1912740718 = (!widget.shouldIgnoreActionUpEvent());
                            {
                                Selection.setSelection(buffer, offset);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    MetaKeyKeyListener.adjustMetaAfterKeypress(buffer);
                    MetaKeyKeyListener.resetLockedMeta(buffer);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.037 -0400", hash_original_method = "1CF42BC1A6BA86440BF6AECA28532C33", hash_generated_method = "BB235D7B650FF0F9E99037C5874F2CC2")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean canSelectArbitrarily() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.037 -0400", hash_original_method = "B727A4A512DEA5751C53503018F86261", hash_generated_method = "07F325B3F35AD8EA82F8E048FC24B37E")
    @DSModeled(DSC.SAFE)
    @Override
    public void initialize(TextView widget, Spannable text) {
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        Selection.setSelection(text, 0);
        // ---------- Original Method ----------
        //Selection.setSelection(text, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.037 -0400", hash_original_method = "0BB03034B6278DCF1B976D7F50A71CD4", hash_generated_method = "AE9C311AD370C09971A7FF9725C717FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onTakeFocus(TextView view, Spannable text, int dir) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(view.dsTaint);
        {
            {
                boolean var6BAF94F53EEC1A5206B9365724449745_2117602033 = (view.getLayout() == null);
                {
                    Selection.setSelection(text, text.length());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Selection.setSelection(text, text.length());
        } //End block
        // ---------- Original Method ----------
        //if ((dir & (View.FOCUS_FORWARD | View.FOCUS_DOWN)) != 0) {
            //if (view.getLayout() == null) {
                //Selection.setSelection(text, text.length());
            //}
        //} else {
            //Selection.setSelection(text, text.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.037 -0400", hash_original_method = "1DB0A35A4E73C95F823446362F035621", hash_generated_method = "7D06961535B06F9469B80E24BBEF2437")
    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new ArrowKeyMovementMethod();
        }
        return sInstance;
    }

    
}


