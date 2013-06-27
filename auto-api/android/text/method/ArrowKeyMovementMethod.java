package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.168 -0400", hash_original_method = "4B84DCFAF96B2ABE0CEB1C58A836BE09", hash_generated_method = "4B84DCFAF96B2ABE0CEB1C58A836BE09")
    public ArrowKeyMovementMethod ()
    {
        //Synthesized constructor
    }


        private static boolean isSelecting(Spannable buffer) {
        return ((MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SHIFT_ON) == 1) ||
                (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0));
    }

    
        private static int getCurrentLineTop(Spannable buffer, Layout layout) {
        return layout.getLineTop(layout.getLineForOffset(Selection.getSelectionEnd(buffer)));
    }

    
        private static int getPageHeight(TextView widget) {
        final Rect rect = new Rect();
        return widget.getGlobalVisibleRect(rect) ? rect.height() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.182 -0400", hash_original_method = "71AB0E1C222F7165F2E5407A96AE4AA1", hash_generated_method = "416EDBA5DA8BE50977E5A12F52D13288")
    @Override
    protected boolean handleMovementKey(TextView widget, Spannable buffer, int keyCode,
            int movementMetaState, KeyEvent event) {
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_677592378 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                {
                    boolean var76939DA1EC207A63458F74083CB75919_1414099536 = (event.getAction() == KeyEvent.ACTION_DOWN
                            && event.getRepeatCount() == 0
                            && MetaKeyKeyListener.getMetaState(buffer,
                                        MetaKeyKeyListener.META_SELECTING) != 0);
                    {
                        boolean var73B0288BF23C1878DD5D23C7B8DE645A_834893214 = (widget.showContextMenu());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER 
        boolean varB3AE6E56434D9D50711491B13D9952B2_686328594 = (super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(keyCode);
        addTaint(movementMetaState);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350042093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350042093;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.183 -0400", hash_original_method = "EF44D7EB21450A63AD253DA49BF056E0", hash_generated_method = "E8019F98BB97315AE67402B6A81060F9")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_1378413143 = (isSelecting(buffer));
            {
                boolean varCDC07301B68653E82EF77D5D3E7D066F_1257766877 = (Selection.extendLeft(buffer, layout));
            } //End block
            {
                boolean varC4BF08D777B0A042F49FED3028D7D05A_1114514562 = (Selection.moveLeft(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794548657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_794548657;
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendLeft(buffer, layout);
        //} else {
            //return Selection.moveLeft(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.183 -0400", hash_original_method = "B7F7970A1171CA8F77BB045891103F0E", hash_generated_method = "53DCB3204DA299684B464245E2BCB608")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_1558968660 = (isSelecting(buffer));
            {
                boolean var67ECF37412B30F89073547F3C34324B4_1902053021 = (Selection.extendRight(buffer, layout));
            } //End block
            {
                boolean var8EC8DA8DE281B3C82BC4665C217C5696_348636939 = (Selection.moveRight(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1248613462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1248613462;
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendRight(buffer, layout);
        //} else {
            //return Selection.moveRight(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.184 -0400", hash_original_method = "66883526BDCDE7C41943B5DCF27F9554", hash_generated_method = "66DAB1B9684DE34FD93A8BB894370E20")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_297617235 = (isSelecting(buffer));
            {
                boolean varDE99DF773D51054F95D78312B8DB7CA7_370093811 = (Selection.extendUp(buffer, layout));
            } //End block
            {
                boolean var729357B9FFAC7F8AFC1E8A39E3C60461_936130544 = (Selection.moveUp(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361373616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361373616;
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendUp(buffer, layout);
        //} else {
            //return Selection.moveUp(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.184 -0400", hash_original_method = "6DF71BB34A28EC828AC8FDD5308B170F", hash_generated_method = "453EBFD449B0D0DC952F5EF65BDF8245")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_544680580 = (isSelecting(buffer));
            {
                boolean var1DF63A314E4C0F2F8159D81EED847F8F_2100425038 = (Selection.extendDown(buffer, layout));
            } //End block
            {
                boolean var952F4A80043476B1BF22E477488F97C8_201456472 = (Selection.moveDown(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1781495775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1781495775;
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendDown(buffer, layout);
        //} else {
            //return Selection.moveDown(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.196 -0400", hash_original_method = "0758556D4F657617BD5DD9C53A72AD4E", hash_generated_method = "5F21820D596918961D5B17603C23F6AA")
    @Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        boolean selecting;
        selecting = isSelecting(buffer);
        int targetY;
        targetY = getCurrentLineTop(buffer, layout) - getPageHeight(widget);
        boolean handled;
        handled = false;
        {
            int previousSelectionEnd;
            previousSelectionEnd = Selection.getSelectionEnd(buffer);
            {
                Selection.extendUp(buffer, layout);
            } //End block
            {
                Selection.moveUp(buffer, layout);
            } //End block
            {
                boolean var4733E7C82A69173F794B955030939C99_1656458321 = (Selection.getSelectionEnd(buffer) == previousSelectionEnd);
            } //End collapsed parenthetic
            handled = true;
            {
                boolean varB9CAEB7B78A7F0585D0C5FEFD36222F8_289915750 = (getCurrentLineTop(buffer, layout) <= targetY);
            } //End collapsed parenthetic
        } //End block
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_566699035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_566699035;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.201 -0400", hash_original_method = "A67CFCD6529729C61F17F48248354AB4", hash_generated_method = "827F07E2FB39ADC09C19D732B3EA2B16")
    @Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        boolean selecting;
        selecting = isSelecting(buffer);
        int targetY;
        targetY = getCurrentLineTop(buffer, layout) + getPageHeight(widget);
        boolean handled;
        handled = false;
        {
            int previousSelectionEnd;
            previousSelectionEnd = Selection.getSelectionEnd(buffer);
            {
                Selection.extendDown(buffer, layout);
            } //End block
            {
                Selection.moveDown(buffer, layout);
            } //End block
            {
                boolean var4733E7C82A69173F794B955030939C99_2073915257 = (Selection.getSelectionEnd(buffer) == previousSelectionEnd);
            } //End collapsed parenthetic
            handled = true;
            {
                boolean varF64B0272FDC6514D4788816B81B860EC_1846059328 = (getCurrentLineTop(buffer, layout) >= targetY);
            } //End collapsed parenthetic
        } //End block
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295002762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295002762;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.212 -0400", hash_original_method = "06E1F50FC60AD51807CA9DABCD3FCC05", hash_generated_method = "26A308ACD6B156908686B58A83A91771")
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_1798064056 = (isSelecting(buffer));
            {
                Selection.extendSelection(buffer, 0);
            } //End block
            {
                Selection.setSelection(buffer, 0);
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839023460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839023460;
        // ---------- Original Method ----------
        //if (isSelecting(buffer)) {
            //Selection.extendSelection(buffer, 0);
        //} else {
            //Selection.setSelection(buffer, 0);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.213 -0400", hash_original_method = "BBC6BB5270095971A5BCCB29BC5686E5", hash_generated_method = "673AADBDDE1D6FFB67CF197919E937F3")
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_905593763 = (isSelecting(buffer));
            {
                Selection.extendSelection(buffer, buffer.length());
            } //End block
            {
                Selection.setSelection(buffer, buffer.length());
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361284716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361284716;
        // ---------- Original Method ----------
        //if (isSelecting(buffer)) {
            //Selection.extendSelection(buffer, buffer.length());
        //} else {
            //Selection.setSelection(buffer, buffer.length());
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.214 -0400", hash_original_method = "7B8F77C5EC46A68660F722ECA60D096A", hash_generated_method = "73078F3C0A3F6E00713AA8509E7E0151")
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_681484886 = (isSelecting(buffer));
            {
                boolean var07305073A8F196E2FB7735E331F954A0_1263419249 = (Selection.extendToLeftEdge(buffer, layout));
            } //End block
            {
                boolean var839412FED6549C29C28824CEFDCE0017_402625014 = (Selection.moveToLeftEdge(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807588174 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_807588174;
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendToLeftEdge(buffer, layout);
        //} else {
            //return Selection.moveToLeftEdge(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.215 -0400", hash_original_method = "35F3ADFF6FA8FAD8E2E9FED3F3766C71", hash_generated_method = "EA695CA0EF31DA837D99E2CFCBD2A8AB")
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_1434829004 = (isSelecting(buffer));
            {
                boolean var781475A0D78601F054522A5C6B281C44_220331170 = (Selection.extendToRightEdge(buffer, layout));
            } //End block
            {
                boolean varC1D1956BB9F1FD7167AC12BE8515B8A9_1803145875 = (Selection.moveToRightEdge(buffer, layout));
            } //End block
        } //End collapsed parenthetic
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_536923453 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_536923453;
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendToRightEdge(buffer, layout);
        //} else {
            //return Selection.moveToRightEdge(buffer, layout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.226 -0400", hash_original_method = "67D023CBFAD79BEA97EFF9BE9D5119F7", hash_generated_method = "C3B415EC04E851CF7E10E8BDCBB6CA12")
    @Override
    protected boolean leftWord(TextView widget, Spannable buffer) {
        int selectionEnd;
        selectionEnd = widget.getSelectionEnd();
        WordIterator wordIterator;
        wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        boolean var00DC013268CCCEB562BE79BDEE107BFD_1281830833 = (Selection.moveToPreceding(buffer, wordIterator, isSelecting(buffer)));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142076248 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142076248;
        // ---------- Original Method ----------
        //final int selectionEnd = widget.getSelectionEnd();
        //final WordIterator wordIterator = widget.getWordIterator();
        //wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        //return Selection.moveToPreceding(buffer, wordIterator, isSelecting(buffer));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.227 -0400", hash_original_method = "117E80B3C82F659E45802A24AF653E84", hash_generated_method = "91BE15B056076289E8FB579567FFA054")
    @Override
    protected boolean rightWord(TextView widget, Spannable buffer) {
        int selectionEnd;
        selectionEnd = widget.getSelectionEnd();
        WordIterator wordIterator;
        wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        boolean var1663946D21B0253D2BA5F3A9E29A5557_1493999278 = (Selection.moveToFollowing(buffer, wordIterator, isSelecting(buffer)));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1068487479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1068487479;
        // ---------- Original Method ----------
        //final int selectionEnd = widget.getSelectionEnd();
        //final WordIterator wordIterator = widget.getWordIterator();
        //wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        //return Selection.moveToFollowing(buffer, wordIterator, isSelecting(buffer));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.228 -0400", hash_original_method = "DA5AF1C545D6EFE1C03B36F52D97E891", hash_generated_method = "6AD482F6E6374E8D43AC3E58B7D42269")
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        boolean var15D6AAE84B1824A04ABA9DFAD2A0EF2B_548957838 = (lineStart(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1393227702 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1393227702;
        // ---------- Original Method ----------
        //return lineStart(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.228 -0400", hash_original_method = "ED4119443F83D3A11CB1CCD10457DD79", hash_generated_method = "3C500FECC44CADF0B1631FEC7B8AEC59")
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        boolean var7D30E610B15E5CA72FE602D226D165B2_1767635506 = (lineEnd(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_402056927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_402056927;
        // ---------- Original Method ----------
        //return lineEnd(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.323 -0400", hash_original_method = "775DDAA4B9285FEC985F9D7EBE9B59EB", hash_generated_method = "B01C431495E8AA8F64EDC42CA7ED1BD5")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int initialScrollX;
        initialScrollX = -1;
        int initialScrollY;
        initialScrollY = -1;
        int action;
        action = event.getAction();
        {
            initialScrollX = Touch.getInitialScrollX(widget, buffer);
            initialScrollY = Touch.getInitialScrollY(widget, buffer);
        } //End block
        boolean handled;
        handled = Touch.onTouchEvent(widget, buffer, event);
        {
            boolean varB26B19C2F6D79EF4FEDF57316F6290F6_412098674 = (widget.isFocused() && !widget.didTouchFocusSelect());
            {
                {
                    {
                        boolean varEF5C4D8D9A9043E70D0670EF6B805231_1465663184 = (isSelecting(buffer));
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
                        boolean varF3BD3294A0EDF892E6B430CAE4F4B9A3_212958133 = (isSelecting(buffer) && handled);
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
                        boolean varA5065FE199EB21698026F41C929E052F_604147692 = ((initialScrollY >= 0 && initialScrollY != widget.getScrollY()) ||
                    (initialScrollX >= 0 && initialScrollX != widget.getScrollX()));
                        {
                            widget.moveCursorToVisibleOffset();
                        } //End block
                    } //End collapsed parenthetic
                    int offset;
                    offset = widget.getOffsetForPosition(event.getX(), event.getY());
                    {
                        boolean varEF5C4D8D9A9043E70D0670EF6B805231_1873394361 = (isSelecting(buffer));
                        {
                            buffer.removeSpan(LAST_TAP_DOWN);
                            Selection.extendSelection(buffer, offset);
                        } //End block
                        {
                            boolean var1DBE2387C29CB59C93933696E5F33161_1707704779 = (!widget.shouldIgnoreActionUpEvent());
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
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762825866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_762825866;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.324 -0400", hash_original_method = "1CF42BC1A6BA86440BF6AECA28532C33", hash_generated_method = "2C8CA34BB90DE2EFF82159950C77C662")
    @Override
    public boolean canSelectArbitrarily() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647145054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_647145054;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.324 -0400", hash_original_method = "B727A4A512DEA5751C53503018F86261", hash_generated_method = "29E09D79FC1A4650EC96DF690150D18B")
    @Override
    public void initialize(TextView widget, Spannable text) {
        Selection.setSelection(text, 0);
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //Selection.setSelection(text, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.325 -0400", hash_original_method = "0BB03034B6278DCF1B976D7F50A71CD4", hash_generated_method = "837B40B1ECEA314A76DB70BBA73A0E9D")
    @Override
    public void onTakeFocus(TextView view, Spannable text, int dir) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                boolean var6BAF94F53EEC1A5206B9365724449745_269077252 = (view.getLayout() == null);
                {
                    Selection.setSelection(text, text.length());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Selection.setSelection(text, text.length());
        } //End block
        addTaint(view.getTaint());
        addTaint(text.getTaint());
        addTaint(dir);
        // ---------- Original Method ----------
        //if ((dir & (View.FOCUS_FORWARD | View.FOCUS_DOWN)) != 0) {
            //if (view.getLayout() == null) {
                //Selection.setSelection(text, text.length());
            //}
        //} else {
            //Selection.setSelection(text, text.length());
        //}
    }

    
        public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new ArrowKeyMovementMethod();
        }
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.332 -0400", hash_original_field = "6D16EFACA8F0862D0BBB4C96C142A56C", hash_generated_field = "A1AD1D4306DEE4986BA70C0974BC7486")

    private static Object LAST_TAP_DOWN = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.332 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "94586F1D0C81A1F26D9B8315CD4A2D36")

    private static ArrowKeyMovementMethod sInstance;
}

