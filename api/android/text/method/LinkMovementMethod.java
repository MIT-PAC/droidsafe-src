package android.text.method;

// Droidsafe Imports
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class LinkMovementMethod extends ScrollingMovementMethod {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.298 -0400", hash_original_method = "B3A5612136836A9B554B3E87D4EB3C2A", hash_generated_method = "B3A5612136836A9B554B3E87D4EB3C2A")
    public LinkMovementMethod ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.298 -0400", hash_original_method = "EAC6053DC7B638435B8A062A6CFD4DD9", hash_generated_method = "7C2464C42DEFB2923AE38B9593CAEDBC")
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
        case KeyEvent.KEYCODE_ENTER:
        if(KeyEvent.metaStateHasNoModifiers(movementMetaState))        
        {
            if(event.getAction() == KeyEvent.ACTION_DOWN &&
                            event.getRepeatCount() == 0 && action(CLICK, widget, buffer))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1755652210 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_189082706 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_189082706;
            } //End block
        } //End block
        break;
}        boolean var81BE3D34F6BFBB381F0A6A34F7C131D2_1208277753 = (super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116646597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116646597;
        // ---------- Original Method ----------
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_DPAD_CENTER:
            //case KeyEvent.KEYCODE_ENTER:
                //if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    //if (event.getAction() == KeyEvent.ACTION_DOWN &&
                            //event.getRepeatCount() == 0 && action(CLICK, widget, buffer)) {
                        //return true;
                    //}
                //}
                //break;
        //}
        //return super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.299 -0400", hash_original_method = "DEEB2C7A1B47C25BB65A22E0D0293968", hash_generated_method = "E47CB665ECF936398ECDA56774E84999")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        if(action(UP, widget, buffer))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1097396008 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_11339717 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_11339717;
        } //End block
        boolean var44A2C9F08458F9F74FA75B7A9AD73516_973665448 = (super.up(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1392155331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1392155331;
        // ---------- Original Method ----------
        //if (action(UP, widget, buffer)) {
            //return true;
        //}
        //return super.up(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.299 -0400", hash_original_method = "DC8F45CAA2BC57E786411FE04BC3C168", hash_generated_method = "3B1784EA39A9B3786FFA5E13808288FE")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        if(action(DOWN, widget, buffer))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_527388610 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188471701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_188471701;
        } //End block
        boolean var3B9BE81F034BFE7596D31D82F7BD4D64_315476608 = (super.down(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627729719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627729719;
        // ---------- Original Method ----------
        //if (action(DOWN, widget, buffer)) {
            //return true;
        //}
        //return super.down(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.299 -0400", hash_original_method = "D5E4F0AD4C6B30D49FECD80AA6B7EBFC", hash_generated_method = "7FC4457689216A438D8D7A3597EDBF31")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        if(action(UP, widget, buffer))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1991639665 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226081511 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226081511;
        } //End block
        boolean varEC6B4260B6C31AFC575031F77FEB2DC8_1179575223 = (super.left(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436701093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436701093;
        // ---------- Original Method ----------
        //if (action(UP, widget, buffer)) {
            //return true;
        //}
        //return super.left(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.300 -0400", hash_original_method = "3EDE278FB61BAB62DCA4BE9235F80F2F", hash_generated_method = "9F5E8425F09A4EA30373F0D17ACC66D9")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        if(action(DOWN, widget, buffer))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_827576541 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677331689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677331689;
        } //End block
        boolean var0A3A99C37B099D475BBE6D9100536188_712427762 = (super.right(widget, buffer));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977758646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_977758646;
        // ---------- Original Method ----------
        //if (action(DOWN, widget, buffer)) {
            //return true;
        //}
        //return super.right(widget, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.302 -0400", hash_original_method = "0A452BAD56CDA444E4158895C806016D", hash_generated_method = "CF87349C01D4B3291D8A095AA324F162")
    private boolean action(int what, TextView widget, Spannable buffer) {
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        addTaint(what);
        Layout layout = widget.getLayout();
        int padding = widget.getTotalPaddingTop() +
                      widget.getTotalPaddingBottom();
        int areatop = widget.getScrollY();
        int areabot = areatop + widget.getHeight() - padding;
        int linetop = layout.getLineForVertical(areatop);
        int linebot = layout.getLineForVertical(areabot);
        int first = layout.getLineStart(linetop);
        int last = layout.getLineEnd(linebot);
        ClickableSpan[] candidates = buffer.getSpans(first, last, ClickableSpan.class);
        int a = Selection.getSelectionStart(buffer);
        int b = Selection.getSelectionEnd(buffer);
        int selStart = Math.min(a, b);
        int selEnd = Math.max(a, b);
        if(selStart < 0)        
        {
            if(buffer.getSpanStart(FROM_BELOW) >= 0)            
            {
                selStart = selEnd = buffer.length();
            } //End block
        } //End block
        if(selStart > last)        
        selStart = selEnd = Integer.MAX_VALUE;
        if(selEnd < first)        
        selStart = selEnd = -1;
switch(what){
        case CLICK:
        if(selStart == selEnd)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1421154913 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1703613503 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1703613503;
        } //End block
        ClickableSpan[] link = buffer.getSpans(selStart, selEnd, ClickableSpan.class);
        if(link.length != 1)        
        {
        boolean var68934A3E9455FA72420237EB05902327_451101098 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16759679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16759679;
        }
        link[0].onClick(widget);
        break;
        case UP:
        int beststart;
        int bestend;
        beststart = -1;
        bestend = -1;
for(int i = 0;i < candidates.length;i++)
        {
            int end = buffer.getSpanEnd(candidates[i]);
            if(end < selEnd || selStart == selEnd)            
            {
                if(end > bestend)                
                {
                    beststart = buffer.getSpanStart(candidates[i]);
                    bestend = end;
                } //End block
            } //End block
        } //End block
        if(beststart >= 0)        
        {
            Selection.setSelection(buffer, bestend, beststart);
            boolean varB326B5062B2F0E69046810717534CB09_1026821737 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2127689875 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2127689875;
        } //End block
        break;
        case DOWN:
        beststart = Integer.MAX_VALUE;
        bestend = Integer.MAX_VALUE;
for(int i = 0;i < candidates.length;i++)
        {
            int start = buffer.getSpanStart(candidates[i]);
            if(start > selStart || selStart == selEnd)            
            {
                if(start < beststart)                
                {
                    beststart = start;
                    bestend = buffer.getSpanEnd(candidates[i]);
                } //End block
            } //End block
        } //End block
        if(bestend < Integer.MAX_VALUE)        
        {
            Selection.setSelection(buffer, beststart, bestend);
            boolean varB326B5062B2F0E69046810717534CB09_794963890 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847784521 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847784521;
        } //End block
        break;
}        boolean var68934A3E9455FA72420237EB05902327_410242158 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638141318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_638141318;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.302 -0400", hash_original_method = "716D5739D0947DCFD6D35AD5A0BFDB34", hash_generated_method = "C9038A111878064F34E8F722B483A349")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer,
                                MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(buffer.getTaint());
        addTaint(widget.getTaint());
        int action = event.getAction();
        if(action == MotionEvent.ACTION_UP ||
            action == MotionEvent.ACTION_DOWN)        
        {
            int x = (int) event.getX();
            int y = (int) event.getY();
            x -= widget.getTotalPaddingLeft();
            y -= widget.getTotalPaddingTop();
            x += widget.getScrollX();
            y += widget.getScrollY();
            Layout layout = widget.getLayout();
            int line = layout.getLineForVertical(y);
            int off = layout.getOffsetForHorizontal(line, x);
            ClickableSpan[] link = buffer.getSpans(off, off, ClickableSpan.class);
            if(link.length != 0)            
            {
                if(action == MotionEvent.ACTION_UP)                
                {
                    link[0].onClick(widget);
                } //End block
                else
                if(action == MotionEvent.ACTION_DOWN)                
                {
                    Selection.setSelection(buffer,
                                           buffer.getSpanStart(link[0]),
                                           buffer.getSpanEnd(link[0]));
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_602705234 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_728615143 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_728615143;
            } //End block
            else
            {
                Selection.removeSelection(buffer);
            } //End block
        } //End block
        boolean var9F78A7DAF573159A846644CC0EBBB1B3_660786982 = (super.onTouchEvent(widget, buffer, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354623696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354623696;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.302 -0400", hash_original_method = "BC80F942D1A798557294BA9927A105D9", hash_generated_method = "01D67762533FFB77C343B653F7A1690F")
    @Override
    public void initialize(TextView widget, Spannable text) {
        addTaint(text.getTaint());
        addTaint(widget.getTaint());
        Selection.removeSelection(text);
        text.removeSpan(FROM_BELOW);
        // ---------- Original Method ----------
        //Selection.removeSelection(text);
        //text.removeSpan(FROM_BELOW);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.303 -0400", hash_original_method = "6C6520056B7F5B60C4D7D2F6B3DF20A3", hash_generated_method = "AADD550428A8E4AA9B65AC7B9D421358")
    @Override
    public void onTakeFocus(TextView view, Spannable text, int dir) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dir);
        addTaint(text.getTaint());
        addTaint(view.getTaint());
        Selection.removeSelection(text);
        if((dir & View.FOCUS_BACKWARD) != 0)        
        {
            text.setSpan(FROM_BELOW, 0, 0, Spannable.SPAN_POINT_POINT);
        } //End block
        else
        {
            text.removeSpan(FROM_BELOW);
        } //End block
        // ---------- Original Method ----------
        //Selection.removeSelection(text);
        //if ((dir & View.FOCUS_BACKWARD) != 0) {
            //text.setSpan(FROM_BELOW, 0, 0, Spannable.SPAN_POINT_POINT);
        //} else {
            //text.removeSpan(FROM_BELOW);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new LinkMovementMethod();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.303 -0400", hash_original_field = "AEA6BB697612C14C51A79E9CFA21DC31", hash_generated_field = "6FB5DA6B2AF6BF80368409D7FF54CC6A")

    private static final int CLICK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.303 -0400", hash_original_field = "BB9B400A39E81C072445DD7E18989525", hash_generated_field = "EC8AEC99BBE1BC8384D565C229BB1462")

    private static final int UP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.303 -0400", hash_original_field = "E8E051F8F75ABA1F885AEF65503C2035", hash_generated_field = "6AE4D177B2DB3104A0A9B15227A3C932")

    private static final int DOWN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.303 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "5C8690E8B8CE0CD00F319A05C58A587E")

    private static LinkMovementMethod sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.303 -0400", hash_original_field = "B236084866C6826D9F22FF17A6C17A12", hash_generated_field = "54773BA033D24C029BBEB44F5F051E52")

    private static Object FROM_BELOW = new NoCopySpan.Concrete();
}

