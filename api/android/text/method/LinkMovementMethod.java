package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.253 -0500", hash_original_method = "E6667732641B60A61EDAFC105088D919", hash_generated_method = "3FAE972164C2BC90980C47B735216463")
    
public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new LinkMovementMethod();

        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.216 -0500", hash_original_field = "BFE26440D532419995FCE7B0A2421859", hash_generated_field = "6FB5DA6B2AF6BF80368409D7FF54CC6A")

    private static final int CLICK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.219 -0500", hash_original_field = "F4046E95E9225FD71026957A6FB3B8D8", hash_generated_field = "EC8AEC99BBE1BC8384D565C229BB1462")

    private static final int UP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.222 -0500", hash_original_field = "A436DB474A6FC6B2AE74AC5CDCC112F2", hash_generated_field = "6AE4D177B2DB3104A0A9B15227A3C932")

    private static final int DOWN = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.256 -0500", hash_original_field = "525E86D7D2033AF00777147B256D873C", hash_generated_field = "5C8690E8B8CE0CD00F319A05C58A587E")

    private static LinkMovementMethod sInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.260 -0500", hash_original_field = "A2365DCE78D3F7CF917687D2EA1870FE", hash_generated_field = "54773BA033D24C029BBEB44F5F051E52")

    private static Object FROM_BELOW = new NoCopySpan.Concrete();
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.298 -0400", hash_original_method = "B3A5612136836A9B554B3E87D4EB3C2A", hash_generated_method = "B3A5612136836A9B554B3E87D4EB3C2A")
    public LinkMovementMethod ()
    {
        //Synthesized constructor
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.225 -0500", hash_original_method = "EAC6053DC7B638435B8A062A6CFD4DD9", hash_generated_method = "3F0D88CBF1107BB335972B76722A99F3")
    
@Override
    protected boolean handleMovementKey(TextView widget, Spannable buffer, int keyCode,
            int movementMetaState, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN &&
                            event.getRepeatCount() == 0 && action(CLICK, widget, buffer)) {
                        return true;
                    }
                }
                break;
        }
        return super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.228 -0500", hash_original_method = "DEEB2C7A1B47C25BB65A22E0D0293968", hash_generated_method = "DCB37E71936B44A24B9D69B4ACF71150")
    
@Override
    protected boolean up(TextView widget, Spannable buffer) {
        if (action(UP, widget, buffer)) {
            return true;
        }

        return super.up(widget, buffer);
    }
        
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.231 -0500", hash_original_method = "DC8F45CAA2BC57E786411FE04BC3C168", hash_generated_method = "24E6B96257C02F2F0F7FC1458738B134")
    
@Override
    protected boolean down(TextView widget, Spannable buffer) {
        if (action(DOWN, widget, buffer)) {
            return true;
        }

        return super.down(widget, buffer);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.234 -0500", hash_original_method = "D5E4F0AD4C6B30D49FECD80AA6B7EBFC", hash_generated_method = "4E5A6F781725612914CAAD6540F76916")
    
@Override
    protected boolean left(TextView widget, Spannable buffer) {
        if (action(UP, widget, buffer)) {
            return true;
        }

        return super.left(widget, buffer);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.237 -0500", hash_original_method = "3EDE278FB61BAB62DCA4BE9235F80F2F", hash_generated_method = "2DCB6925FE4991E294AA479C254C2226")
    
@Override
    protected boolean right(TextView widget, Spannable buffer) {
        if (action(DOWN, widget, buffer)) {
            return true;
        }

        return super.right(widget, buffer);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.241 -0500", hash_original_method = "0A452BAD56CDA444E4158895C806016D", hash_generated_method = "8D352A07813EE35C4133DA80FEAE70D4")
    
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

        if (selStart < 0) {
            if (buffer.getSpanStart(FROM_BELOW) >= 0) {
                selStart = selEnd = buffer.length();
            }
        }

        if (selStart > last)
            selStart = selEnd = Integer.MAX_VALUE;
        if (selEnd < first)
            selStart = selEnd = -1;

        switch (what) {
        case CLICK:
            if (selStart == selEnd) {
                return false;
            }

            ClickableSpan[] link = buffer.getSpans(selStart, selEnd, ClickableSpan.class);

            if (link.length != 1)
                return false;

            link[0].onClick(widget);
            break;

        case UP:
            int beststart, bestend;

            beststart = -1;
            bestend = -1;

            for (int i = 0; i < candidates.length; i++) {
                int end = buffer.getSpanEnd(candidates[i]);

                if (end < selEnd || selStart == selEnd) {
                    if (end > bestend) {
                        beststart = buffer.getSpanStart(candidates[i]);
                        bestend = end;
                    }
                }
            }

            if (beststart >= 0) {
                Selection.setSelection(buffer, bestend, beststart);
                return true;
            }

            break;

        case DOWN:
            beststart = Integer.MAX_VALUE;
            bestend = Integer.MAX_VALUE;

            for (int i = 0; i < candidates.length; i++) {
                int start = buffer.getSpanStart(candidates[i]);

                if (start > selStart || selStart == selEnd) {
                    if (start < beststart) {
                        beststart = start;
                        bestend = buffer.getSpanEnd(candidates[i]);
                    }
                }
            }

            if (bestend < Integer.MAX_VALUE) {
                Selection.setSelection(buffer, beststart, bestend);
                return true;
            }

            break;
        }

        return false;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.245 -0500", hash_original_method = "716D5739D0947DCFD6D35AD5A0BFDB34", hash_generated_method = "ABB66E2322BCED3E1465CB14328626C4")
    
@Override
    public boolean onTouchEvent(TextView widget, Spannable buffer,
                                MotionEvent event) {
        int action = event.getAction();

        if (action == MotionEvent.ACTION_UP ||
            action == MotionEvent.ACTION_DOWN) {
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

            if (link.length != 0) {
                if (action == MotionEvent.ACTION_UP) {
                    link[0].onClick(widget);
                } else if (action == MotionEvent.ACTION_DOWN) {
                    Selection.setSelection(buffer,
                                           buffer.getSpanStart(link[0]),
                                           buffer.getSpanEnd(link[0]));
                }

                return true;
            } else {
                Selection.removeSelection(buffer);
            }
        }

        return super.onTouchEvent(widget, buffer, event);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.248 -0500", hash_original_method = "BC80F942D1A798557294BA9927A105D9", hash_generated_method = "158EBD5CF3B4FD8ABC42BA62CC01543C")
    
@Override
    public void initialize(TextView widget, Spannable text) {
        Selection.removeSelection(text);
        text.removeSpan(FROM_BELOW);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.251 -0500", hash_original_method = "6C6520056B7F5B60C4D7D2F6B3DF20A3", hash_generated_method = "66CB086A8A7092DF66208D7B45EA0484")
    
@Override
    public void onTakeFocus(TextView view, Spannable text, int dir) {
        Selection.removeSelection(text);

        if ((dir & View.FOCUS_BACKWARD) != 0) {
            text.setSpan(FROM_BELOW, 0, 0, Spannable.SPAN_POINT_POINT);
        } else {
            text.removeSpan(FROM_BELOW);
        }
    }
}

