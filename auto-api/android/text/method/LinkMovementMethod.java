package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class LinkMovementMethod extends ScrollingMovementMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.163 -0400", hash_original_method = "B3A5612136836A9B554B3E87D4EB3C2A", hash_generated_method = "B3A5612136836A9B554B3E87D4EB3C2A")
    public LinkMovementMethod ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.164 -0400", hash_original_method = "EAC6053DC7B638435B8A062A6CFD4DD9", hash_generated_method = "3A8CE9F95EC116DD0A3FA6A370D2FA0B")
    @Override
    protected boolean handleMovementKey(TextView widget, Spannable buffer, int keyCode,
            int movementMetaState, KeyEvent event) {
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1496120211 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                {
                    boolean varF6FE42E90BAF425E381550FC32B0C387_237136030 = (event.getAction() == KeyEvent.ACTION_DOWN &&
                            event.getRepeatCount() == 0 && action(CLICK, widget, buffer));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        boolean varB3AE6E56434D9D50711491B13D9952B2_1217871715 = (super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(keyCode);
        addTaint(movementMetaState);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403095448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_403095448;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.164 -0400", hash_original_method = "DEEB2C7A1B47C25BB65A22E0D0293968", hash_generated_method = "D5326F3D772EBBF73B1C819B377B3563")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        {
            boolean varE64CA9CEB925EA218697FDBD4F926B48_642895174 = (action(UP, widget, buffer));
        } //End collapsed parenthetic
        boolean var8BF68FDFBBA26F608C7F4ACC37669153_120517937 = (super.up(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858796672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858796672;
        // ---------- Original Method ----------
        //if (action(UP, widget, buffer)) {
            //return true;
        //}
        //return super.up(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.165 -0400", hash_original_method = "DC8F45CAA2BC57E786411FE04BC3C168", hash_generated_method = "FDFA2A3F7E48BAB5BED7A2773A18823C")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        {
            boolean varE8D7719ACA1D02B0100470568BB4C916_1327867047 = (action(DOWN, widget, buffer));
        } //End collapsed parenthetic
        boolean var1106673C2DE4E1DB99F7B6A7D781E70F_431308496 = (super.down(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_701830316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_701830316;
        // ---------- Original Method ----------
        //if (action(DOWN, widget, buffer)) {
            //return true;
        //}
        //return super.down(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.165 -0400", hash_original_method = "D5E4F0AD4C6B30D49FECD80AA6B7EBFC", hash_generated_method = "65F47876828DA2D2647DCFB06038D02D")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        {
            boolean varE64CA9CEB925EA218697FDBD4F926B48_1996864437 = (action(UP, widget, buffer));
        } //End collapsed parenthetic
        boolean var2D6DEC17E909EC320D00767D819652B7_1562286310 = (super.left(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1674378971 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1674378971;
        // ---------- Original Method ----------
        //if (action(UP, widget, buffer)) {
            //return true;
        //}
        //return super.left(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.166 -0400", hash_original_method = "3EDE278FB61BAB62DCA4BE9235F80F2F", hash_generated_method = "00BFDEAB9F6CEC116C78AC34C73C6994")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        {
            boolean varE8D7719ACA1D02B0100470568BB4C916_1422104034 = (action(DOWN, widget, buffer));
        } //End collapsed parenthetic
        boolean var00B384AD8C6FBF74137BA035D38C45B0_116796000 = (super.right(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659512832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659512832;
        // ---------- Original Method ----------
        //if (action(DOWN, widget, buffer)) {
            //return true;
        //}
        //return super.right(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.167 -0400", hash_original_method = "0A452BAD56CDA444E4158895C806016D", hash_generated_method = "4C4787FCE7CFADDD863F439EBA6FF99F")
    private boolean action(int what, TextView widget, Spannable buffer) {
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
        {
            {
                boolean var8A212F74A2EA8746F0CF95B97AC8C572_1588250192 = (buffer.getSpanStart(FROM_BELOW) >= 0);
                {
                    selStart = selEnd = buffer.length();
                } //End block
            } //End collapsed parenthetic
        } //End block
        selStart = selEnd = Integer.MAX_VALUE;
        selStart = selEnd = -1;
        //Begin case CLICK 
        ClickableSpan[] link = buffer.getSpans(selStart, selEnd, ClickableSpan.class);
        //End case CLICK 
        //Begin case CLICK 
        link[0].onClick(widget);
        //End case CLICK 
        //Begin case UP 
        int beststart;
        int bestend;
        //End case UP 
        //Begin case UP 
        beststart = -1;
        //End case UP 
        //Begin case UP 
        bestend = -1;
        //End case UP 
        //Begin case UP 
        {
            int i = 0;
            {
                int end = buffer.getSpanEnd(candidates[i]);
                {
                    {
                        beststart = buffer.getSpanStart(candidates[i]);
                        bestend = end;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        //End case UP 
        //Begin case UP 
        {
            Selection.setSelection(buffer, bestend, beststart);
        } //End block
        //End case UP 
        //Begin case DOWN 
        beststart = Integer.MAX_VALUE;
        //End case DOWN 
        //Begin case DOWN 
        bestend = Integer.MAX_VALUE;
        //End case DOWN 
        //Begin case DOWN 
        {
            int i = 0;
            {
                int start = buffer.getSpanStart(candidates[i]);
                {
                    {
                        beststart = start;
                        bestend = buffer.getSpanEnd(candidates[i]);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        //End case DOWN 
        //Begin case DOWN 
        {
            Selection.setSelection(buffer, beststart, bestend);
        } //End block
        //End case DOWN 
        addTaint(what);
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134225697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_134225697;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.168 -0400", hash_original_method = "716D5739D0947DCFD6D35AD5A0BFDB34", hash_generated_method = "BB35AA1E74C3E4FC086E18FB19A4E504")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer,
                                MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int action = event.getAction();
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
            {
                {
                    link[0].onClick(widget);
                } //End block
                {
                    Selection.setSelection(buffer,
                                           buffer.getSpanStart(link[0]),
                                           buffer.getSpanEnd(link[0]));
                } //End block
            } //End block
            {
                Selection.removeSelection(buffer);
            } //End block
        } //End block
        boolean var360CC7D6B1D34D7800C39299960FF099_797516254 = (super.onTouchEvent(widget, buffer, event));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835056359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_835056359;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.168 -0400", hash_original_method = "BC80F942D1A798557294BA9927A105D9", hash_generated_method = "E2DAA8148FC63C645EBCD8B245348AEE")
    @Override
    public void initialize(TextView widget, Spannable text) {
        Selection.removeSelection(text);
        text.removeSpan(FROM_BELOW);
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //Selection.removeSelection(text);
        //text.removeSpan(FROM_BELOW);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.169 -0400", hash_original_method = "6C6520056B7F5B60C4D7D2F6B3DF20A3", hash_generated_method = "89F00ACACA0713F1D012C67E6E64764C")
    @Override
    public void onTakeFocus(TextView view, Spannable text, int dir) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Selection.removeSelection(text);
        {
            text.setSpan(FROM_BELOW, 0, 0, Spannable.SPAN_POINT_POINT);
        } //End block
        {
            text.removeSpan(FROM_BELOW);
        } //End block
        addTaint(view.getTaint());
        addTaint(text.getTaint());
        addTaint(dir);
        // ---------- Original Method ----------
        //Selection.removeSelection(text);
        //if ((dir & View.FOCUS_BACKWARD) != 0) {
            //text.setSpan(FROM_BELOW, 0, 0, Spannable.SPAN_POINT_POINT);
        //} else {
            //text.removeSpan(FROM_BELOW);
        //}
    }

    
    public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new LinkMovementMethod();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.169 -0400", hash_original_field = "AEA6BB697612C14C51A79E9CFA21DC31", hash_generated_field = "6FB5DA6B2AF6BF80368409D7FF54CC6A")

    private static final int CLICK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.169 -0400", hash_original_field = "BB9B400A39E81C072445DD7E18989525", hash_generated_field = "EC8AEC99BBE1BC8384D565C229BB1462")

    private static final int UP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.169 -0400", hash_original_field = "E8E051F8F75ABA1F885AEF65503C2035", hash_generated_field = "6AE4D177B2DB3104A0A9B15227A3C932")

    private static final int DOWN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.169 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "5C8690E8B8CE0CD00F319A05C58A587E")

    private static LinkMovementMethod sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.169 -0400", hash_original_field = "B236084866C6826D9F22FF17A6C17A12", hash_generated_field = "54773BA033D24C029BBEB44F5F051E52")

    private static Object FROM_BELOW = new NoCopySpan.Concrete();
}

