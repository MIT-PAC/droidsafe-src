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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.997 -0400", hash_original_method = "B3A5612136836A9B554B3E87D4EB3C2A", hash_generated_method = "B3A5612136836A9B554B3E87D4EB3C2A")
    public LinkMovementMethod ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.998 -0400", hash_original_method = "EAC6053DC7B638435B8A062A6CFD4DD9", hash_generated_method = "76EA3D9149F6FFE9A64DBCBA35DC4997")
    @Override
    protected boolean handleMovementKey(TextView widget, Spannable buffer, int keyCode,
            int movementMetaState, KeyEvent event) {
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_341768722 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                {
                    boolean varF6FE42E90BAF425E381550FC32B0C387_1498342204 = (event.getAction() == KeyEvent.ACTION_DOWN &&
                            event.getRepeatCount() == 0 && action(CLICK, widget, buffer));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        boolean varB3AE6E56434D9D50711491B13D9952B2_4498872 = (super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(keyCode);
        addTaint(movementMetaState);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_673755347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_673755347;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.999 -0400", hash_original_method = "DEEB2C7A1B47C25BB65A22E0D0293968", hash_generated_method = "D45D8D0B175AFA5B9ED96E3BCFC6CA58")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        {
            boolean varE64CA9CEB925EA218697FDBD4F926B48_936783340 = (action(UP, widget, buffer));
        } //End collapsed parenthetic
        boolean var8BF68FDFBBA26F608C7F4ACC37669153_1823306923 = (super.up(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_227536325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_227536325;
        // ---------- Original Method ----------
        //if (action(UP, widget, buffer)) {
            //return true;
        //}
        //return super.up(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.000 -0400", hash_original_method = "DC8F45CAA2BC57E786411FE04BC3C168", hash_generated_method = "7E879101D2BFF64DA42F60F630100EA2")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        {
            boolean varE8D7719ACA1D02B0100470568BB4C916_1838839221 = (action(DOWN, widget, buffer));
        } //End collapsed parenthetic
        boolean var1106673C2DE4E1DB99F7B6A7D781E70F_1827090521 = (super.down(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146910411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146910411;
        // ---------- Original Method ----------
        //if (action(DOWN, widget, buffer)) {
            //return true;
        //}
        //return super.down(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.000 -0400", hash_original_method = "D5E4F0AD4C6B30D49FECD80AA6B7EBFC", hash_generated_method = "0D7054582A0847E1782A6F9A000462D2")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        {
            boolean varE64CA9CEB925EA218697FDBD4F926B48_1477237131 = (action(UP, widget, buffer));
        } //End collapsed parenthetic
        boolean var2D6DEC17E909EC320D00767D819652B7_961324102 = (super.left(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_77282964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_77282964;
        // ---------- Original Method ----------
        //if (action(UP, widget, buffer)) {
            //return true;
        //}
        //return super.left(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.000 -0400", hash_original_method = "3EDE278FB61BAB62DCA4BE9235F80F2F", hash_generated_method = "E0FC7F315BA22502D80201AD0313849E")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        {
            boolean varE8D7719ACA1D02B0100470568BB4C916_1257661222 = (action(DOWN, widget, buffer));
        } //End collapsed parenthetic
        boolean var00B384AD8C6FBF74137BA035D38C45B0_1999024746 = (super.right(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757237119 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_757237119;
        // ---------- Original Method ----------
        //if (action(DOWN, widget, buffer)) {
            //return true;
        //}
        //return super.right(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.032 -0400", hash_original_method = "0A452BAD56CDA444E4158895C806016D", hash_generated_method = "2E586F326CB839CFDE270A9EDC4664F4")
    private boolean action(int what, TextView widget, Spannable buffer) {
        Layout layout;
        layout = widget.getLayout();
        int padding;
        padding = widget.getTotalPaddingTop() +
                      widget.getTotalPaddingBottom();
        int areatop;
        areatop = widget.getScrollY();
        int areabot;
        areabot = areatop + widget.getHeight() - padding;
        int linetop;
        linetop = layout.getLineForVertical(areatop);
        int linebot;
        linebot = layout.getLineForVertical(areabot);
        int first;
        first = layout.getLineStart(linetop);
        int last;
        last = layout.getLineEnd(linebot);
        ClickableSpan[] candidates;
        candidates = buffer.getSpans(first, last, ClickableSpan.class);
        int a;
        a = Selection.getSelectionStart(buffer);
        int b;
        b = Selection.getSelectionEnd(buffer);
        int selStart;
        selStart = Math.min(a, b);
        int selEnd;
        selEnd = Math.max(a, b);
        {
            {
                boolean var8A212F74A2EA8746F0CF95B97AC8C572_805994932 = (buffer.getSpanStart(FROM_BELOW) >= 0);
                {
                    selStart = selEnd = buffer.length();
                } //End block
            } //End collapsed parenthetic
        } //End block
        selStart = selEnd = Integer.MAX_VALUE;
        selStart = selEnd = -1;
        //Begin case CLICK 
        ClickableSpan[] link;
        link = buffer.getSpans(selStart, selEnd, ClickableSpan.class);
        //End case CLICK 
        //Begin case CLICK 
        link[0].onClick(widget);
        //End case CLICK 
        //Begin case UP 
        int beststart, bestend;
        //End case UP 
        //Begin case UP 
        beststart = -1;
        //End case UP 
        //Begin case UP 
        bestend = -1;
        //End case UP 
        //Begin case UP 
        {
            int i;
            i = 0;
            {
                int end;
                end = buffer.getSpanEnd(candidates[i]);
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
            int i;
            i = 0;
            {
                int start;
                start = buffer.getSpanStart(candidates[i]);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446247473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_446247473;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.034 -0400", hash_original_method = "716D5739D0947DCFD6D35AD5A0BFDB34", hash_generated_method = "B4FD89E9784DDC16F6125AF438D9AC35")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer,
                                MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int action;
        action = event.getAction();
        {
            int x;
            x = (int) event.getX();
            int y;
            y = (int) event.getY();
            x -= widget.getTotalPaddingLeft();
            y -= widget.getTotalPaddingTop();
            x += widget.getScrollX();
            y += widget.getScrollY();
            Layout layout;
            layout = widget.getLayout();
            int line;
            line = layout.getLineForVertical(y);
            int off;
            off = layout.getOffsetForHorizontal(line, x);
            ClickableSpan[] link;
            link = buffer.getSpans(off, off, ClickableSpan.class);
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
        boolean var360CC7D6B1D34D7800C39299960FF099_472214168 = (super.onTouchEvent(widget, buffer, event));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1031671373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1031671373;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.034 -0400", hash_original_method = "BC80F942D1A798557294BA9927A105D9", hash_generated_method = "E2DAA8148FC63C645EBCD8B245348AEE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.035 -0400", hash_original_method = "6C6520056B7F5B60C4D7D2F6B3DF20A3", hash_generated_method = "89F00ACACA0713F1D012C67E6E64764C")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.035 -0400", hash_original_field = "AEA6BB697612C14C51A79E9CFA21DC31", hash_generated_field = "36466592D53BCC5AF365FCCAC59313AD")

    private static int CLICK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.035 -0400", hash_original_field = "BB9B400A39E81C072445DD7E18989525", hash_generated_field = "C86459EEC5EE51FAE8E192F1C1C4D67B")

    private static int UP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.035 -0400", hash_original_field = "E8E051F8F75ABA1F885AEF65503C2035", hash_generated_field = "89C1D3161F0D86ABB90FC5A5FE62A8D2")

    private static int DOWN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.035 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "5C8690E8B8CE0CD00F319A05C58A587E")

    private static LinkMovementMethod sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.035 -0400", hash_original_field = "B236084866C6826D9F22FF17A6C17A12", hash_generated_field = "54773BA033D24C029BBEB44F5F051E52")

    private static Object FROM_BELOW = new NoCopySpan.Concrete();
}

