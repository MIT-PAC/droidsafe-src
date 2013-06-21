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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.314 -0400", hash_original_method = "96C600DE4EA1A92D665E12480DADF3D3", hash_generated_method = "96C600DE4EA1A92D665E12480DADF3D3")
        public LinkMovementMethod ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.315 -0400", hash_original_method = "EAC6053DC7B638435B8A062A6CFD4DD9", hash_generated_method = "E796E99F05D18738D2DB8C05DA163352")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean handleMovementKey(TextView widget, Spannable buffer, int keyCode,
            int movementMetaState, KeyEvent event) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        dsTaint.addTaint(movementMetaState);
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            boolean varD311727E65FDD806D61A6271FF483A84_1274495794 = (KeyEvent.metaStateHasNoModifiers(movementMetaState));
            {
                {
                    boolean varF6FE42E90BAF425E381550FC32B0C387_1719089348 = (event.getAction() == KeyEvent.ACTION_DOWN &&
                            event.getRepeatCount() == 0 && action(CLICK, widget, buffer));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        boolean varB3AE6E56434D9D50711491B13D9952B2_2005976659 = (super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.315 -0400", hash_original_method = "DEEB2C7A1B47C25BB65A22E0D0293968", hash_generated_method = "C63E8BE7754FBD6EDE43342868055E7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        {
            boolean varE64CA9CEB925EA218697FDBD4F926B48_283347630 = (action(UP, widget, buffer));
        } //End collapsed parenthetic
        boolean var8BF68FDFBBA26F608C7F4ACC37669153_1991303205 = (super.up(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (action(UP, widget, buffer)) {
            //return true;
        //}
        //return super.up(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.316 -0400", hash_original_method = "DC8F45CAA2BC57E786411FE04BC3C168", hash_generated_method = "54824F0FBFBEFF06C664ADE6298200AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        {
            boolean varE8D7719ACA1D02B0100470568BB4C916_1086954471 = (action(DOWN, widget, buffer));
        } //End collapsed parenthetic
        boolean var1106673C2DE4E1DB99F7B6A7D781E70F_1603247969 = (super.down(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (action(DOWN, widget, buffer)) {
            //return true;
        //}
        //return super.down(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.316 -0400", hash_original_method = "D5E4F0AD4C6B30D49FECD80AA6B7EBFC", hash_generated_method = "03CE6606128112C60C651873B34A993F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        {
            boolean varE64CA9CEB925EA218697FDBD4F926B48_1122392933 = (action(UP, widget, buffer));
        } //End collapsed parenthetic
        boolean var2D6DEC17E909EC320D00767D819652B7_327191453 = (super.left(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (action(UP, widget, buffer)) {
            //return true;
        //}
        //return super.left(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.325 -0400", hash_original_method = "3EDE278FB61BAB62DCA4BE9235F80F2F", hash_generated_method = "4D53AAF011D0414FF5F81622C6E8029C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        {
            boolean varE8D7719ACA1D02B0100470568BB4C916_1396965475 = (action(DOWN, widget, buffer));
        } //End collapsed parenthetic
        boolean var00B384AD8C6FBF74137BA035D38C45B0_1738542753 = (super.right(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (action(DOWN, widget, buffer)) {
            //return true;
        //}
        //return super.right(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.326 -0400", hash_original_method = "0A452BAD56CDA444E4158895C806016D", hash_generated_method = "6371AFABAF50896C4C12172151DBC262")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean action(int what, TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(what);
        dsTaint.addTaint(widget.dsTaint);
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
                boolean var8A212F74A2EA8746F0CF95B97AC8C572_375213272 = (buffer.getSpanStart(FROM_BELOW) >= 0);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.327 -0400", hash_original_method = "716D5739D0947DCFD6D35AD5A0BFDB34", hash_generated_method = "4238BFB55562584960AABB887B873B26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer,
                                MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
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
        boolean var360CC7D6B1D34D7800C39299960FF099_1822799320 = (super.onTouchEvent(widget, buffer, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.328 -0400", hash_original_method = "BC80F942D1A798557294BA9927A105D9", hash_generated_method = "831BD227BAD4445AC3085EEC8513E8DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void initialize(TextView widget, Spannable text) {
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        Selection.removeSelection(text);
        text.removeSpan(FROM_BELOW);
        // ---------- Original Method ----------
        //Selection.removeSelection(text);
        //text.removeSpan(FROM_BELOW);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.328 -0400", hash_original_method = "6C6520056B7F5B60C4D7D2F6B3DF20A3", hash_generated_method = "2E1CC47685CAB517BBA93A4BD3717258")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onTakeFocus(TextView view, Spannable text, int dir) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(view.dsTaint);
        Selection.removeSelection(text);
        {
            text.setSpan(FROM_BELOW, 0, 0, Spannable.SPAN_POINT_POINT);
        } //End block
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

    
        public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new LinkMovementMethod();
        return sInstance;
    }

    
    private static final int CLICK = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private static LinkMovementMethod sInstance;
    private static Object FROM_BELOW = new NoCopySpan.Concrete();
}

