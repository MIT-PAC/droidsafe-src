package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class ArrowKeyMovementMethod extends BaseMovementMethod implements MovementMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.289 -0400", hash_original_method = "4B84DCFAF96B2ABE0CEB1C58A836BE09", hash_generated_method = "4B84DCFAF96B2ABE0CEB1C58A836BE09")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.292 -0400", hash_original_method = "71AB0E1C222F7165F2E5407A96AE4AA1", hash_generated_method = "F26C2D402BD613CB4130C64BE827CD48")
    @Override
    protected boolean handleMovementKey(TextView widget, Spannable buffer, int keyCode,
            int movementMetaState, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(movementMetaState);
        addTaint(keyCode);
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_CENTER:
    if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
    if(event.getAction() == KeyEvent.ACTION_DOWN
                            && event.getRepeatCount() == 0
                            && MetaKeyKeyListener.getMetaState(buffer,
                                        MetaKeyKeyListener.META_SELECTING) != 0)            
            {
                boolean varC56E066302D447F0261041371EBAA85F_1404076269 = (widget.showContextMenu());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826758392 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_826758392;
            } 
        } 
        break;
}        boolean var81BE3D34F6BFBB381F0A6A34F7C131D2_285764492 = (super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_684614499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_684614499;
        
        
            
                
                    
                            
                            
                                        
                        
                    
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.293 -0400", hash_original_method = "EF44D7EB21450A63AD253DA49BF056E0", hash_generated_method = "C22896E02E91BD05510512141951C1D2")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
    if(isSelecting(buffer))        
        {
            boolean varFCD66EDD8AB84CF088A7CCA6F828FE77_615022974 = (Selection.extendLeft(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908799686 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_908799686;
        } 
        else
        {
            boolean varF20EF2C8D6EF73EB2C98A061EA12AE98_141881213 = (Selection.moveLeft(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238188758 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238188758;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.294 -0400", hash_original_method = "B7F7970A1171CA8F77BB045891103F0E", hash_generated_method = "219E182C4F7B5D964160FAAB29671B2D")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
    if(isSelecting(buffer))        
        {
            boolean var9C58A23C24995F0749D10F2F96B1CE28_1033914585 = (Selection.extendRight(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052331222 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052331222;
        } 
        else
        {
            boolean var57F4031F955E7713006B5056BD7D3E5D_825676777 = (Selection.moveRight(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_574593704 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_574593704;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.295 -0400", hash_original_method = "66883526BDCDE7C41943B5DCF27F9554", hash_generated_method = "47FCB4427761B179BCF476BD78D2CADE")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
    if(isSelecting(buffer))        
        {
            boolean varB7101C6D36EEA2CB4B37068AA1D0E6E7_1931416832 = (Selection.extendUp(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_540115436 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_540115436;
        } 
        else
        {
            boolean varAE3032785198BB80DE52B6AF135201CD_716789247 = (Selection.moveUp(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189341262 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189341262;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.296 -0400", hash_original_method = "6DF71BB34A28EC828AC8FDD5308B170F", hash_generated_method = "25632EB7638F89C4BA7BF9413A4DB324")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
    if(isSelecting(buffer))        
        {
            boolean var270A039876E91576AC8EA21143DC38C2_878443930 = (Selection.extendDown(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_881169278 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_881169278;
        } 
        else
        {
            boolean varD01F565718FD1D118D0BB464F738A1B8_976349718 = (Selection.moveDown(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_503982632 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_503982632;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.297 -0400", hash_original_method = "0758556D4F657617BD5DD9C53A72AD4E", hash_generated_method = "52CD78A043A829DF26B9439920EB781D")
    @Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final boolean selecting = isSelecting(buffer);
        final int targetY = getCurrentLineTop(buffer, layout) - getPageHeight(widget);
        boolean handled = false;
for(;;)
        {
            final int previousSelectionEnd = Selection.getSelectionEnd(buffer);
    if(selecting)            
            {
                Selection.extendUp(buffer, layout);
            } 
            else
            {
                Selection.moveUp(buffer, layout);
            } 
    if(Selection.getSelectionEnd(buffer) == previousSelectionEnd)            
            {
                break;
            } 
            handled = true;
    if(getCurrentLineTop(buffer, layout) <= targetY)            
            {
                break;
            } 
        } 
        boolean var98F0599AF776A1FE4101C199A40EEB8F_477376281 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1352679638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1352679638;
        
        
        
        
        
        
            
            
                
            
                
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.298 -0400", hash_original_method = "A67CFCD6529729C61F17F48248354AB4", hash_generated_method = "8ADDB1ED1ACAAA305BE12B108875D522")
    @Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        final boolean selecting = isSelecting(buffer);
        final int targetY = getCurrentLineTop(buffer, layout) + getPageHeight(widget);
        boolean handled = false;
for(;;)
        {
            final int previousSelectionEnd = Selection.getSelectionEnd(buffer);
    if(selecting)            
            {
                Selection.extendDown(buffer, layout);
            } 
            else
            {
                Selection.moveDown(buffer, layout);
            } 
    if(Selection.getSelectionEnd(buffer) == previousSelectionEnd)            
            {
                break;
            } 
            handled = true;
    if(getCurrentLineTop(buffer, layout) >= targetY)            
            {
                break;
            } 
        } 
        boolean var98F0599AF776A1FE4101C199A40EEB8F_840498166 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1237892137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1237892137;
        
        
        
        
        
        
            
            
                
            
                
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.299 -0400", hash_original_method = "06E1F50FC60AD51807CA9DABCD3FCC05", hash_generated_method = "D835696548C898DFE0CE285CC746CF5B")
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
    if(isSelecting(buffer))        
        {
            Selection.extendSelection(buffer, 0);
        } 
        else
        {
            Selection.setSelection(buffer, 0);
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1344933008 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1716475192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1716475192;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.299 -0400", hash_original_method = "BBC6BB5270095971A5BCCB29BC5686E5", hash_generated_method = "E788E3C03E9249E627B8399D1090B1AA")
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
    if(isSelecting(buffer))        
        {
            Selection.extendSelection(buffer, buffer.length());
        } 
        else
        {
            Selection.setSelection(buffer, buffer.length());
        } 
        boolean varB326B5062B2F0E69046810717534CB09_347594770 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899826440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_899826440;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.300 -0400", hash_original_method = "7B8F77C5EC46A68660F722ECA60D096A", hash_generated_method = "CB5311AF7AFDAACE5B58C2A2E5BBEEFE")
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
    if(isSelecting(buffer))        
        {
            boolean var2DAA703E12FB726C1D3804DE4620FD0F_784023405 = (Selection.extendToLeftEdge(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789436011 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789436011;
        } 
        else
        {
            boolean var62AE663D2D6FCB8885D11BFCD2981F4F_117130828 = (Selection.moveToLeftEdge(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739008852 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739008852;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.301 -0400", hash_original_method = "35F3ADFF6FA8FAD8E2E9FED3F3766C71", hash_generated_method = "755B69EBBEE8F82705FCB92B9AB5E8EE")
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
    if(isSelecting(buffer))        
        {
            boolean varDC3362CDA449003058E4B6149D7D4763_1627264688 = (Selection.extendToRightEdge(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724890647 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_724890647;
        } 
        else
        {
            boolean var832E3F1F2C8FA8F9758AB1B37329D235_2089765631 = (Selection.moveToRightEdge(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_696375653 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_696375653;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.302 -0400", hash_original_method = "67D023CBFAD79BEA97EFF9BE9D5119F7", hash_generated_method = "E19E507F758165F23D8E8335673CB032")
    @Override
    protected boolean leftWord(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final int selectionEnd = widget.getSelectionEnd();
        final WordIterator wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        boolean var6C3ACA7457AB2395596265599E9BA2EF_648761391 = (Selection.moveToPreceding(buffer, wordIterator, isSelecting(buffer)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1759380977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1759380977;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.302 -0400", hash_original_method = "117E80B3C82F659E45802A24AF653E84", hash_generated_method = "DADAFBC6A716D2856F161366FB3DFFB7")
    @Override
    protected boolean rightWord(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final int selectionEnd = widget.getSelectionEnd();
        final WordIterator wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        boolean varB680B200FB18AAEECA2EC2C75D15A32C_598168599 = (Selection.moveToFollowing(buffer, wordIterator, isSelecting(buffer)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1999417724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1999417724;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.303 -0400", hash_original_method = "DA5AF1C545D6EFE1C03B36F52D97E891", hash_generated_method = "33DEF298FD7F776D2DB5EFDABF4BF8EF")
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var8A4EC837595EF2ADA26279838B03A6B4_101780118 = (lineStart(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1814915621 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1814915621;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.303 -0400", hash_original_method = "ED4119443F83D3A11CB1CCD10457DD79", hash_generated_method = "EAB054DA555B9FF07A809A363E165D50")
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean varA7A846A276FEA3FA92892DE21D931845_1022400251 = (lineEnd(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046851969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046851969;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.305 -0400", hash_original_method = "775DDAA4B9285FEC985F9D7EBE9B59EB", hash_generated_method = "A2ACD71210AB07CEE9882A2DF5FF3A5F")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        
        addTaint(event.getTaint());
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        int initialScrollX = -1;
        int initialScrollY = -1;
        final int action = event.getAction();
    if(action == MotionEvent.ACTION_UP)        
        {
            initialScrollX = Touch.getInitialScrollX(widget, buffer);
            initialScrollY = Touch.getInitialScrollY(widget, buffer);
        } 
        boolean handled = Touch.onTouchEvent(widget, buffer, event);
    if(widget.isFocused() && !widget.didTouchFocusSelect())        
        {
    if(action == MotionEvent.ACTION_DOWN)            
            {
    if(isSelecting(buffer))                
                {
                    int offset = widget.getOffsetForPosition(event.getX(), event.getY());
                    buffer.setSpan(LAST_TAP_DOWN, offset, offset, Spannable.SPAN_POINT_POINT);
                    widget.getParent().requestDisallowInterceptTouchEvent(true);
                } 
            } 
            else
    if(action == MotionEvent.ACTION_MOVE)            
            {
    if(isSelecting(buffer) && handled)                
                {
                    widget.cancelLongPress();
                    int offset = widget.getOffsetForPosition(event.getX(), event.getY());
                    Selection.extendSelection(buffer, offset);
                    boolean varB326B5062B2F0E69046810717534CB09_1372975060 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1519791643 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1519791643;
                } 
            } 
            else
    if(action == MotionEvent.ACTION_UP)            
            {
    if((initialScrollY >= 0 && initialScrollY != widget.getScrollY()) ||
                    (initialScrollX >= 0 && initialScrollX != widget.getScrollX()))                
                {
                    widget.moveCursorToVisibleOffset();
                    boolean varB326B5062B2F0E69046810717534CB09_1383734500 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210932645 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_210932645;
                } 
                int offset = widget.getOffsetForPosition(event.getX(), event.getY());
    if(isSelecting(buffer))                
                {
                    buffer.removeSpan(LAST_TAP_DOWN);
                    Selection.extendSelection(buffer, offset);
                } 
                else
    if(!widget.shouldIgnoreActionUpEvent())                
                {
                    Selection.setSelection(buffer, offset);
                } 
                MetaKeyKeyListener.adjustMetaAfterKeypress(buffer);
                MetaKeyKeyListener.resetLockedMeta(buffer);
                boolean varB326B5062B2F0E69046810717534CB09_236864789 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387542770 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_387542770;
            } 
        } 
        boolean var98F0599AF776A1FE4101C199A40EEB8F_2076210908 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1540689791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1540689791;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.306 -0400", hash_original_method = "1CF42BC1A6BA86440BF6AECA28532C33", hash_generated_method = "A00214459CFF8AA779246681D0C89E75")
    @Override
    public boolean canSelectArbitrarily() {
        boolean varB326B5062B2F0E69046810717534CB09_1458890693 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_932964895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_932964895;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.306 -0400", hash_original_method = "B727A4A512DEA5751C53503018F86261", hash_generated_method = "91D011071EC7F2928471332F8F91EBE7")
    @Override
    public void initialize(TextView widget, Spannable text) {
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        Selection.setSelection(text, 0);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.307 -0400", hash_original_method = "0BB03034B6278DCF1B976D7F50A71CD4", hash_generated_method = "BC175C19A41AF77E2B82986D7A8471AA")
    @Override
    public void onTakeFocus(TextView view, Spannable text, int dir) {
        
        addTaint(dir);
        addTaint(text.getTaint());
        addTaint(view.getTaint());
    if((dir & (View.FOCUS_FORWARD | View.FOCUS_DOWN)) != 0)        
        {
    if(view.getLayout() == null)            
            {
                Selection.setSelection(text, text.length());
            } 
        } 
        else
        {
            Selection.setSelection(text, text.length());
        } 
        
        
            
                
            
        
            
        
    }

    
        @DSModeled(DSC.SAFE)
    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new ArrowKeyMovementMethod();
        }
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.307 -0400", hash_original_field = "6D16EFACA8F0862D0BBB4C96C142A56C", hash_generated_field = "C1D458E78FA0EB0FEAAB09CC3F93FF9B")

    private static final Object LAST_TAP_DOWN = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.307 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "94586F1D0C81A1F26D9B8315CD4A2D36")

    private static ArrowKeyMovementMethod sInstance;
}

