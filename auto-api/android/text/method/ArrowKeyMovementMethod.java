package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.918 -0400", hash_original_method = "4B84DCFAF96B2ABE0CEB1C58A836BE09", hash_generated_method = "4B84DCFAF96B2ABE0CEB1C58A836BE09")
    public ArrowKeyMovementMethod ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    private static boolean isSelecting(Spannable buffer) {
        return ((MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SHIFT_ON) == 1) ||
                (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0));
    }

    
    @DSModeled(DSC.SAFE)
    private static int getCurrentLineTop(Spannable buffer, Layout layout) {
        return layout.getLineTop(layout.getLineForOffset(Selection.getSelectionEnd(buffer)));
    }

    
    @DSModeled(DSC.SAFE)
    private static int getPageHeight(TextView widget) {
        final Rect rect = new Rect();
        return widget.getGlobalVisibleRect(rect) ? rect.height() : 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.919 -0400", hash_original_method = "71AB0E1C222F7165F2E5407A96AE4AA1", hash_generated_method = "29A34C2B16C4E6745CC119573428D96F")
    @Override
    protected boolean handleMovementKey(TextView widget, Spannable buffer, int keyCode,
            int movementMetaState, KeyEvent event) {
        
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1739352826 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                {
                    boolean var76939DA1EC207A63458F74083CB75919_1685248266 = (event.getAction() == KeyEvent.ACTION_DOWN
                            && event.getRepeatCount() == 0
                            && MetaKeyKeyListener.getMetaState(buffer,
                                        MetaKeyKeyListener.META_SELECTING) != 0);
                    {
                        boolean var73B0288BF23C1878DD5D23C7B8DE645A_614649542 = (widget.showContextMenu());
                    } 
                } 
            } 
        } 
        
        boolean varB3AE6E56434D9D50711491B13D9952B2_1107736899 = (super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(keyCode);
        addTaint(movementMetaState);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776796216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776796216;
        
        
            
                
                    
                            
                            
                                        
                        
                    
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.919 -0400", hash_original_method = "EF44D7EB21450A63AD253DA49BF056E0", hash_generated_method = "672AD7759C42368959CAD2C21ED62AC9")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_1443947530 = (isSelecting(buffer));
            {
                boolean varCDC07301B68653E82EF77D5D3E7D066F_1877700828 = (Selection.extendLeft(buffer, layout));
            } 
            {
                boolean varC4BF08D777B0A042F49FED3028D7D05A_496097403 = (Selection.moveLeft(buffer, layout));
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_577963481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_577963481;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.920 -0400", hash_original_method = "B7F7970A1171CA8F77BB045891103F0E", hash_generated_method = "63ED831B34CAF3550F75A680A1258FFA")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_655322763 = (isSelecting(buffer));
            {
                boolean var67ECF37412B30F89073547F3C34324B4_1130399882 = (Selection.extendRight(buffer, layout));
            } 
            {
                boolean var8EC8DA8DE281B3C82BC4665C217C5696_1308309550 = (Selection.moveRight(buffer, layout));
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1419523009 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1419523009;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.920 -0400", hash_original_method = "66883526BDCDE7C41943B5DCF27F9554", hash_generated_method = "B5C093608B4A436863500279A0EC256D")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_608716564 = (isSelecting(buffer));
            {
                boolean varDE99DF773D51054F95D78312B8DB7CA7_841611814 = (Selection.extendUp(buffer, layout));
            } 
            {
                boolean var729357B9FFAC7F8AFC1E8A39E3C60461_373022573 = (Selection.moveUp(buffer, layout));
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660679850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_660679850;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.921 -0400", hash_original_method = "6DF71BB34A28EC828AC8FDD5308B170F", hash_generated_method = "013AE3DBFC21E3BBE35E7084E3C89F74")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_59678020 = (isSelecting(buffer));
            {
                boolean var1DF63A314E4C0F2F8159D81EED847F8F_2132324656 = (Selection.extendDown(buffer, layout));
            } 
            {
                boolean var952F4A80043476B1BF22E477488F97C8_870717351 = (Selection.moveDown(buffer, layout));
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141710432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141710432;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.922 -0400", hash_original_method = "0758556D4F657617BD5DD9C53A72AD4E", hash_generated_method = "6FE2511D0E90E02590709B111211B326")
    @Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        final boolean selecting = isSelecting(buffer);
        final int targetY = getCurrentLineTop(buffer, layout) - getPageHeight(widget);
        boolean handled = false;
        {
            final int previousSelectionEnd = Selection.getSelectionEnd(buffer);
            {
                Selection.extendUp(buffer, layout);
            } 
            {
                Selection.moveUp(buffer, layout);
            } 
            {
                boolean var4733E7C82A69173F794B955030939C99_728003114 = (Selection.getSelectionEnd(buffer) == previousSelectionEnd);
            } 
            handled = true;
            {
                boolean varB9CAEB7B78A7F0585D0C5FEFD36222F8_855219540 = (getCurrentLineTop(buffer, layout) <= targetY);
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174478491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_174478491;
        
        
        
        
        
        
            
            
                
            
                
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.923 -0400", hash_original_method = "A67CFCD6529729C61F17F48248354AB4", hash_generated_method = "BB3688B0278F2402BD531C0B22859BC5")
    @Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        final boolean selecting = isSelecting(buffer);
        final int targetY = getCurrentLineTop(buffer, layout) + getPageHeight(widget);
        boolean handled = false;
        {
            final int previousSelectionEnd = Selection.getSelectionEnd(buffer);
            {
                Selection.extendDown(buffer, layout);
            } 
            {
                Selection.moveDown(buffer, layout);
            } 
            {
                boolean var4733E7C82A69173F794B955030939C99_565354911 = (Selection.getSelectionEnd(buffer) == previousSelectionEnd);
            } 
            handled = true;
            {
                boolean varF64B0272FDC6514D4788816B81B860EC_623262164 = (getCurrentLineTop(buffer, layout) >= targetY);
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_686958824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_686958824;
        
        
        
        
        
        
            
            
                
            
                
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.923 -0400", hash_original_method = "06E1F50FC60AD51807CA9DABCD3FCC05", hash_generated_method = "8132F1B2305E6646953269C72BAC1D3D")
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_759676403 = (isSelecting(buffer));
            {
                Selection.extendSelection(buffer, 0);
            } 
            {
                Selection.setSelection(buffer, 0);
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546330630 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_546330630;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.923 -0400", hash_original_method = "BBC6BB5270095971A5BCCB29BC5686E5", hash_generated_method = "CA019E55C47234089884142B72A3D70B")
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_195657179 = (isSelecting(buffer));
            {
                Selection.extendSelection(buffer, buffer.length());
            } 
            {
                Selection.setSelection(buffer, buffer.length());
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_493147139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_493147139;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.924 -0400", hash_original_method = "7B8F77C5EC46A68660F722ECA60D096A", hash_generated_method = "54FAF40F159B6D4090FBAAC79AFCBC98")
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_42829642 = (isSelecting(buffer));
            {
                boolean var07305073A8F196E2FB7735E331F954A0_1969482759 = (Selection.extendToLeftEdge(buffer, layout));
            } 
            {
                boolean var839412FED6549C29C28824CEFDCE0017_771535595 = (Selection.moveToLeftEdge(buffer, layout));
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_30494260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_30494260;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.924 -0400", hash_original_method = "35F3ADFF6FA8FAD8E2E9FED3F3766C71", hash_generated_method = "C0FB5162865D4CD0E9AEEF26761A1A6B")
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        {
            boolean varA39AC56FA77F4727AD58F987600717C2_1817964933 = (isSelecting(buffer));
            {
                boolean var781475A0D78601F054522A5C6B281C44_1085143863 = (Selection.extendToRightEdge(buffer, layout));
            } 
            {
                boolean varC1D1956BB9F1FD7167AC12BE8515B8A9_22594767 = (Selection.moveToRightEdge(buffer, layout));
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1834651243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1834651243;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.924 -0400", hash_original_method = "67D023CBFAD79BEA97EFF9BE9D5119F7", hash_generated_method = "1E54D8BE5BEB2334B7C48F8077273797")
    @Override
    protected boolean leftWord(TextView widget, Spannable buffer) {
        final int selectionEnd = widget.getSelectionEnd();
        final WordIterator wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        boolean var00DC013268CCCEB562BE79BDEE107BFD_755075614 = (Selection.moveToPreceding(buffer, wordIterator, isSelecting(buffer)));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584441106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_584441106;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.925 -0400", hash_original_method = "117E80B3C82F659E45802A24AF653E84", hash_generated_method = "AC31D0D7127C4140526E1E2C17183A3C")
    @Override
    protected boolean rightWord(TextView widget, Spannable buffer) {
        final int selectionEnd = widget.getSelectionEnd();
        final WordIterator wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        boolean var1663946D21B0253D2BA5F3A9E29A5557_903004112 = (Selection.moveToFollowing(buffer, wordIterator, isSelecting(buffer)));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1037380328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1037380328;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.925 -0400", hash_original_method = "DA5AF1C545D6EFE1C03B36F52D97E891", hash_generated_method = "5A2D1902D7628E053797734B16B03A84")
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        boolean var15D6AAE84B1824A04ABA9DFAD2A0EF2B_1786339521 = (lineStart(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1129845092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1129845092;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.925 -0400", hash_original_method = "ED4119443F83D3A11CB1CCD10457DD79", hash_generated_method = "64A179B013A706DBBCB035FA2C870389")
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        boolean var7D30E610B15E5CA72FE602D226D165B2_528293708 = (lineEnd(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809649038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809649038;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.926 -0400", hash_original_method = "775DDAA4B9285FEC985F9D7EBE9B59EB", hash_generated_method = "5CB83E4FC6D6613AB39ECE772F9D2A0D")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        
        int initialScrollX = -1;
        int initialScrollY = -1;
        final int action = event.getAction();
        {
            initialScrollX = Touch.getInitialScrollX(widget, buffer);
            initialScrollY = Touch.getInitialScrollY(widget, buffer);
        } 
        boolean handled = Touch.onTouchEvent(widget, buffer, event);
        {
            boolean varB26B19C2F6D79EF4FEDF57316F6290F6_179987913 = (widget.isFocused() && !widget.didTouchFocusSelect());
            {
                {
                    {
                        boolean varEF5C4D8D9A9043E70D0670EF6B805231_415376091 = (isSelecting(buffer));
                        {
                            int offset = widget.getOffsetForPosition(event.getX(), event.getY());
                            buffer.setSpan(LAST_TAP_DOWN, offset, offset, Spannable.SPAN_POINT_POINT);
                            widget.getParent().requestDisallowInterceptTouchEvent(true);
                        } 
                    } 
                } 
                {
                    {
                        boolean varF3BD3294A0EDF892E6B430CAE4F4B9A3_1178312996 = (isSelecting(buffer) && handled);
                        {
                            widget.cancelLongPress();
                            int offset = widget.getOffsetForPosition(event.getX(), event.getY());
                            Selection.extendSelection(buffer, offset);
                        } 
                    } 
                } 
                {
                    {
                        boolean varA5065FE199EB21698026F41C929E052F_684593023 = ((initialScrollY >= 0 && initialScrollY != widget.getScrollY()) ||
                    (initialScrollX >= 0 && initialScrollX != widget.getScrollX()));
                        {
                            widget.moveCursorToVisibleOffset();
                        } 
                    } 
                    int offset = widget.getOffsetForPosition(event.getX(), event.getY());
                    {
                        boolean varEF5C4D8D9A9043E70D0670EF6B805231_633277408 = (isSelecting(buffer));
                        {
                            buffer.removeSpan(LAST_TAP_DOWN);
                            Selection.extendSelection(buffer, offset);
                        } 
                        {
                            boolean var1DBE2387C29CB59C93933696E5F33161_1429589579 = (!widget.shouldIgnoreActionUpEvent());
                            {
                                Selection.setSelection(buffer, offset);
                            } 
                        } 
                    } 
                    MetaKeyKeyListener.adjustMetaAfterKeypress(buffer);
                    MetaKeyKeyListener.resetLockedMeta(buffer);
                } 
            } 
        } 
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239340234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239340234;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.926 -0400", hash_original_method = "1CF42BC1A6BA86440BF6AECA28532C33", hash_generated_method = "6FDBC162ACD08E6A956281D4EBB8553D")
    @Override
    public boolean canSelectArbitrarily() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1262361793 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1262361793;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.927 -0400", hash_original_method = "B727A4A512DEA5751C53503018F86261", hash_generated_method = "29E09D79FC1A4650EC96DF690150D18B")
    @Override
    public void initialize(TextView widget, Spannable text) {
        Selection.setSelection(text, 0);
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.927 -0400", hash_original_method = "0BB03034B6278DCF1B976D7F50A71CD4", hash_generated_method = "DA3A2B291A5537FCC17036A9E17899B4")
    @Override
    public void onTakeFocus(TextView view, Spannable text, int dir) {
        
        {
            {
                boolean var6BAF94F53EEC1A5206B9365724449745_2141363645 = (view.getLayout() == null);
                {
                    Selection.setSelection(text, text.length());
                } 
            } 
        } 
        {
            Selection.setSelection(text, text.length());
        } 
        addTaint(view.getTaint());
        addTaint(text.getTaint());
        addTaint(dir);
        
        
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new ArrowKeyMovementMethod();
        }
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.927 -0400", hash_original_field = "6D16EFACA8F0862D0BBB4C96C142A56C", hash_generated_field = "C1D458E78FA0EB0FEAAB09CC3F93FF9B")

    private static final Object LAST_TAP_DOWN = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.927 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "94586F1D0C81A1F26D9B8315CD4A2D36")

    private static ArrowKeyMovementMethod sInstance;
}

