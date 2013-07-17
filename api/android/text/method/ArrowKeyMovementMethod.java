package android.text.method;

// Droidsafe Imports
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
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.894 -0400", hash_original_method = "4B84DCFAF96B2ABE0CEB1C58A836BE09", hash_generated_method = "4B84DCFAF96B2ABE0CEB1C58A836BE09")
    public ArrowKeyMovementMethod ()
    {
        //Synthesized constructor
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.895 -0400", hash_original_method = "71AB0E1C222F7165F2E5407A96AE4AA1", hash_generated_method = "7692B9851082B1AA7ABD74C6DA0A6CD3")
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
                boolean varC56E066302D447F0261041371EBAA85F_1259580911 = (widget.showContextMenu());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194976417 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194976417;
            } //End block
        } //End block
        break;
}        boolean var81BE3D34F6BFBB381F0A6A34F7C131D2_1523163185 = (super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163847866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163847866;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.896 -0400", hash_original_method = "EF44D7EB21450A63AD253DA49BF056E0", hash_generated_method = "35177EFA6139A8C490F1F25B34B08E09")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        if(isSelecting(buffer))        
        {
            boolean varFCD66EDD8AB84CF088A7CCA6F828FE77_1862694282 = (Selection.extendLeft(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1864362377 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1864362377;
        } //End block
        else
        {
            boolean varF20EF2C8D6EF73EB2C98A061EA12AE98_782860477 = (Selection.moveLeft(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1675218892 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1675218892;
        } //End block
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendLeft(buffer, layout);
        //} else {
            //return Selection.moveLeft(buffer, layout);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.897 -0400", hash_original_method = "B7F7970A1171CA8F77BB045891103F0E", hash_generated_method = "D97ABEA89FB4EDD5321A649C00851C77")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        if(isSelecting(buffer))        
        {
            boolean var9C58A23C24995F0749D10F2F96B1CE28_315140963 = (Selection.extendRight(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1514585676 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1514585676;
        } //End block
        else
        {
            boolean var57F4031F955E7713006B5056BD7D3E5D_1242344235 = (Selection.moveRight(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_992130237 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_992130237;
        } //End block
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendRight(buffer, layout);
        //} else {
            //return Selection.moveRight(buffer, layout);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.897 -0400", hash_original_method = "66883526BDCDE7C41943B5DCF27F9554", hash_generated_method = "B1E276D4AB6954BE7D038D9EBE27ADD4")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        if(isSelecting(buffer))        
        {
            boolean varB7101C6D36EEA2CB4B37068AA1D0E6E7_2084962693 = (Selection.extendUp(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_408421912 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_408421912;
        } //End block
        else
        {
            boolean varAE3032785198BB80DE52B6AF135201CD_1234420959 = (Selection.moveUp(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955067872 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_955067872;
        } //End block
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendUp(buffer, layout);
        //} else {
            //return Selection.moveUp(buffer, layout);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.898 -0400", hash_original_method = "6DF71BB34A28EC828AC8FDD5308B170F", hash_generated_method = "73E7D74F5AA54683D7A536E556A58471")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        if(isSelecting(buffer))        
        {
            boolean var270A039876E91576AC8EA21143DC38C2_1425851800 = (Selection.extendDown(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339443919 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_339443919;
        } //End block
        else
        {
            boolean varD01F565718FD1D118D0BB464F738A1B8_1109597773 = (Selection.moveDown(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_364588135 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_364588135;
        } //End block
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendDown(buffer, layout);
        //} else {
            //return Selection.moveDown(buffer, layout);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.898 -0400", hash_original_method = "0758556D4F657617BD5DD9C53A72AD4E", hash_generated_method = "D4541A9BFB1A42CA277B5E05DBF0C02F")
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
            } //End block
            else
            {
                Selection.moveUp(buffer, layout);
            } //End block
            if(Selection.getSelectionEnd(buffer) == previousSelectionEnd)            
            {
                break;
            } //End block
            handled = true;
            if(getCurrentLineTop(buffer, layout) <= targetY)            
            {
                break;
            } //End block
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_492118473 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660821468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_660821468;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.900 -0400", hash_original_method = "A67CFCD6529729C61F17F48248354AB4", hash_generated_method = "D128EA229EF1E5DDBFBC7467B975C639")
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
            } //End block
            else
            {
                Selection.moveDown(buffer, layout);
            } //End block
            if(Selection.getSelectionEnd(buffer) == previousSelectionEnd)            
            {
                break;
            } //End block
            handled = true;
            if(getCurrentLineTop(buffer, layout) >= targetY)            
            {
                break;
            } //End block
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1782643607 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261741189 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_261741189;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.901 -0400", hash_original_method = "06E1F50FC60AD51807CA9DABCD3FCC05", hash_generated_method = "4A473578CF07632D57E3266E4235FB58")
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        if(isSelecting(buffer))        
        {
            Selection.extendSelection(buffer, 0);
        } //End block
        else
        {
            Selection.setSelection(buffer, 0);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1957357209 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1138445584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1138445584;
        // ---------- Original Method ----------
        //if (isSelecting(buffer)) {
            //Selection.extendSelection(buffer, 0);
        //} else {
            //Selection.setSelection(buffer, 0);
        //}
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.901 -0400", hash_original_method = "BBC6BB5270095971A5BCCB29BC5686E5", hash_generated_method = "A56A4821203F63563C3166FA2687CE4E")
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        if(isSelecting(buffer))        
        {
            Selection.extendSelection(buffer, buffer.length());
        } //End block
        else
        {
            Selection.setSelection(buffer, buffer.length());
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2113753948 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839356826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839356826;
        // ---------- Original Method ----------
        //if (isSelecting(buffer)) {
            //Selection.extendSelection(buffer, buffer.length());
        //} else {
            //Selection.setSelection(buffer, buffer.length());
        //}
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.902 -0400", hash_original_method = "7B8F77C5EC46A68660F722ECA60D096A", hash_generated_method = "4790CA52F8A667ACE131E0A5DC62DB72")
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        if(isSelecting(buffer))        
        {
            boolean var2DAA703E12FB726C1D3804DE4620FD0F_1956371862 = (Selection.extendToLeftEdge(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1357391319 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1357391319;
        } //End block
        else
        {
            boolean var62AE663D2D6FCB8885D11BFCD2981F4F_1811497271 = (Selection.moveToLeftEdge(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967131691 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967131691;
        } //End block
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendToLeftEdge(buffer, layout);
        //} else {
            //return Selection.moveToLeftEdge(buffer, layout);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.902 -0400", hash_original_method = "35F3ADFF6FA8FAD8E2E9FED3F3766C71", hash_generated_method = "018D6D86520F1CFDD9589765EE62CEB7")
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final Layout layout = widget.getLayout();
        if(isSelecting(buffer))        
        {
            boolean varDC3362CDA449003058E4B6149D7D4763_2146450961 = (Selection.extendToRightEdge(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_468233644 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_468233644;
        } //End block
        else
        {
            boolean var832E3F1F2C8FA8F9758AB1B37329D235_707564192 = (Selection.moveToRightEdge(buffer, layout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1392759130 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1392759130;
        } //End block
        // ---------- Original Method ----------
        //final Layout layout = widget.getLayout();
        //if (isSelecting(buffer)) {
            //return Selection.extendToRightEdge(buffer, layout);
        //} else {
            //return Selection.moveToRightEdge(buffer, layout);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.903 -0400", hash_original_method = "67D023CBFAD79BEA97EFF9BE9D5119F7", hash_generated_method = "4EE867843F421ED436D336CB55239208")
    @Override
    protected boolean leftWord(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final int selectionEnd = widget.getSelectionEnd();
        final WordIterator wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        boolean var6C3ACA7457AB2395596265599E9BA2EF_1803050273 = (Selection.moveToPreceding(buffer, wordIterator, isSelecting(buffer)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500689970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500689970;
        // ---------- Original Method ----------
        //final int selectionEnd = widget.getSelectionEnd();
        //final WordIterator wordIterator = widget.getWordIterator();
        //wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        //return Selection.moveToPreceding(buffer, wordIterator, isSelecting(buffer));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.903 -0400", hash_original_method = "117E80B3C82F659E45802A24AF653E84", hash_generated_method = "1FE192C0094BAAFCBD6573C13A615B8A")
    @Override
    protected boolean rightWord(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        final int selectionEnd = widget.getSelectionEnd();
        final WordIterator wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        boolean varB680B200FB18AAEECA2EC2C75D15A32C_1318352492 = (Selection.moveToFollowing(buffer, wordIterator, isSelecting(buffer)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_709829862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_709829862;
        // ---------- Original Method ----------
        //final int selectionEnd = widget.getSelectionEnd();
        //final WordIterator wordIterator = widget.getWordIterator();
        //wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        //return Selection.moveToFollowing(buffer, wordIterator, isSelecting(buffer));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.903 -0400", hash_original_method = "DA5AF1C545D6EFE1C03B36F52D97E891", hash_generated_method = "1C25D1B1FD2622CE7475A3FD25A25125")
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean var8A4EC837595EF2ADA26279838B03A6B4_1782130194 = (lineStart(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267853363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267853363;
        // ---------- Original Method ----------
        //return lineStart(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.903 -0400", hash_original_method = "ED4119443F83D3A11CB1CCD10457DD79", hash_generated_method = "F52A606AB92FEFA5B43FE032973BE312")
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        boolean varA7A846A276FEA3FA92892DE21D931845_266854037 = (lineEnd(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894286905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_894286905;
        // ---------- Original Method ----------
        //return lineEnd(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.904 -0400", hash_original_method = "775DDAA4B9285FEC985F9D7EBE9B59EB", hash_generated_method = "082ED3A056DDD7F320EB0B9CD4B754FA")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        } //End block
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
                } //End block
            } //End block
            else
            if(action == MotionEvent.ACTION_MOVE)            
            {
                if(isSelecting(buffer) && handled)                
                {
                    widget.cancelLongPress();
                    int offset = widget.getOffsetForPosition(event.getX(), event.getY());
                    Selection.extendSelection(buffer, offset);
                    boolean varB326B5062B2F0E69046810717534CB09_928331221 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_91327421 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_91327421;
                } //End block
            } //End block
            else
            if(action == MotionEvent.ACTION_UP)            
            {
                if((initialScrollY >= 0 && initialScrollY != widget.getScrollY()) ||
                    (initialScrollX >= 0 && initialScrollX != widget.getScrollX()))                
                {
                    widget.moveCursorToVisibleOffset();
                    boolean varB326B5062B2F0E69046810717534CB09_1733038144 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_342617672 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_342617672;
                } //End block
                int offset = widget.getOffsetForPosition(event.getX(), event.getY());
                if(isSelecting(buffer))                
                {
                    buffer.removeSpan(LAST_TAP_DOWN);
                    Selection.extendSelection(buffer, offset);
                } //End block
                else
                if(!widget.shouldIgnoreActionUpEvent())                
                {
                    Selection.setSelection(buffer, offset);
                } //End block
                MetaKeyKeyListener.adjustMetaAfterKeypress(buffer);
                MetaKeyKeyListener.resetLockedMeta(buffer);
                boolean varB326B5062B2F0E69046810717534CB09_1954436380 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105506731 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_105506731;
            } //End block
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_625756476 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235712348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235712348;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.905 -0400", hash_original_method = "1CF42BC1A6BA86440BF6AECA28532C33", hash_generated_method = "84288304CDB4644401990908B7B06179")
    @Override
    public boolean canSelectArbitrarily() {
        boolean varB326B5062B2F0E69046810717534CB09_2135877255 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_392642991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_392642991;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.905 -0400", hash_original_method = "B727A4A512DEA5751C53503018F86261", hash_generated_method = "91D011071EC7F2928471332F8F91EBE7")
    @Override
    public void initialize(TextView widget, Spannable text) {
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        Selection.setSelection(text, 0);
        // ---------- Original Method ----------
        //Selection.setSelection(text, 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.906 -0400", hash_original_method = "0BB03034B6278DCF1B976D7F50A71CD4", hash_generated_method = "BC175C19A41AF77E2B82986D7A8471AA")
    @Override
    public void onTakeFocus(TextView view, Spannable text, int dir) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dir);
        addTaint(text.getTaint());
        addTaint(view.getTaint());
        if((dir & (View.FOCUS_FORWARD | View.FOCUS_DOWN)) != 0)        
        {
            if(view.getLayout() == null)            
            {
                Selection.setSelection(text, text.length());
            } //End block
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new ArrowKeyMovementMethod();
        }
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.906 -0400", hash_original_field = "6D16EFACA8F0862D0BBB4C96C142A56C", hash_generated_field = "C1D458E78FA0EB0FEAAB09CC3F93FF9B")

    private static final Object LAST_TAP_DOWN = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.906 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "94586F1D0C81A1F26D9B8315CD4A2D36")

    private static ArrowKeyMovementMethod sInstance;
}

