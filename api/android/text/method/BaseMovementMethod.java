package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.Layout;
import android.text.Spannable;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class BaseMovementMethod implements MovementMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.048 -0400", hash_original_method = "1DE84F8ABE7124ECFD52F353C5E545C4", hash_generated_method = "1DE84F8ABE7124ECFD52F353C5E545C4")
    public BaseMovementMethod ()
    {
        //Synthesized constructor
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.863 -0500", hash_original_method = "3C8541B244B3E418A0704604E985C4F6", hash_generated_method = "C9BDE731E03F05D1E757A2C04DE589A6")
    
@Override
    public boolean canSelectArbitrarily() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.865 -0500", hash_original_method = "D13D908BA0DAF76C398D062F3F380F09", hash_generated_method = "80DC1FE0265D7B2C02EA7F3E1BE388D9")
    
@Override
    public void initialize(TextView widget, Spannable text) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.868 -0500", hash_original_method = "51F4180929D179462C8A792E383BE4DE", hash_generated_method = "45BA70CDC4A249457544609BE9762F8A")
    
@Override
    public boolean onKeyDown(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        final int movementMetaState = getMovementMetaState(text, event);
        boolean handled = handleMovementKey(widget, text, keyCode, movementMetaState, event);
        if (handled) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(text);
            MetaKeyKeyListener.resetLockedMeta(text);
        }
        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.872 -0500", hash_original_method = "8FECF2F4DB21657DC257EBEAC5D3F348", hash_generated_method = "A0C416AF0141C160E812C466ECCCC69D")
    
@Override
    public boolean onKeyOther(TextView widget, Spannable text, KeyEvent event) {
        final int movementMetaState = getMovementMetaState(text, event);
        final int keyCode = event.getKeyCode();
        if (keyCode != KeyEvent.KEYCODE_UNKNOWN
                && event.getAction() == KeyEvent.ACTION_MULTIPLE) {
            final int repeat = event.getRepeatCount();
            boolean handled = false;
            for (int i = 0; i < repeat; i++) {
                if (!handleMovementKey(widget, text, keyCode, movementMetaState, event)) {
                    break;
                }
                handled = true;
            }
            if (handled) {
                MetaKeyKeyListener.adjustMetaAfterKeypress(text);
                MetaKeyKeyListener.resetLockedMeta(text);
            }
            return handled;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.875 -0500", hash_original_method = "03F6AD3B58EDAE8DF6A1CC395F5B54B3", hash_generated_method = "EDE6B65072C59E6624786A523FE07C74")
    
@Override
    public boolean onKeyUp(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.878 -0500", hash_original_method = "AC3F1CB1818DDCB7BD27F03C760797A7", hash_generated_method = "74FCDE654B415637E0A05DBC012C5C05")
    
@Override
    public void onTakeFocus(TextView widget, Spannable text, int direction) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.881 -0500", hash_original_method = "136932FCA27B55C4FFFE4C0F482F5C95", hash_generated_method = "EB0C348A6555611E6E0934E272C352F8")
    
@Override
    public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.884 -0500", hash_original_method = "B091339813AE51B8A0FCC53026E81FDE", hash_generated_method = "5647BE26D0EC98219CD91F2C2BCED968")
    
@Override
    public boolean onTrackballEvent(TextView widget, Spannable text, MotionEvent event) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.887 -0500", hash_original_method = "F7B7D807C9903B237C0BDFCF28378E9E", hash_generated_method = "F039EA22B31464B1FA624D7F86B30527")
    
@Override
    public boolean onGenericMotionEvent(TextView widget, Spannable text, MotionEvent event) {
        if ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_SCROLL: {
                    final float vscroll;
                    final float hscroll;
                    if ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0) {
                        vscroll = 0;
                        hscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                    } else {
                        vscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                        hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                    }

                    boolean handled = false;
                    if (hscroll < 0) {
                        handled |= scrollLeft(widget, text, (int)Math.ceil(-hscroll));
                    } else if (hscroll > 0) {
                        handled |= scrollRight(widget, text, (int)Math.ceil(hscroll));
                    }
                    if (vscroll < 0) {
                        handled |= scrollUp(widget, text, (int)Math.ceil(-vscroll));
                    } else if (vscroll > 0) {
                        handled |= scrollDown(widget, text, (int)Math.ceil(vscroll));
                    }
                    return handled;
                }
            }
        }
        return false;
    }

    /**
     * Gets the meta state used for movement using the modifiers tracked by the text
     * buffer as well as those present in the key event.
     *
     * The movement meta state excludes the state of locked modifiers or the SHIFT key
     * since they are not used by movement actions (but they may be used for selection).
     *
     * @param buffer The text buffer.
     * @param event The key event.
     * @return The keyboard meta states used for movement.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.891 -0500", hash_original_method = "DBF5E10955F96650BAEE8C94618C2948", hash_generated_method = "10607B4D5EF2FBF5A3DD385D641184F5")
    
protected int getMovementMetaState(Spannable buffer, KeyEvent event) {
        // We ignore locked modifiers and SHIFT.
        int metaState = (event.getMetaState() | MetaKeyKeyListener.getMetaState(buffer))
                & ~(MetaKeyKeyListener.META_ALT_LOCKED | MetaKeyKeyListener.META_SYM_LOCKED);
        return KeyEvent.normalizeMetaState(metaState) & ~KeyEvent.META_SHIFT_MASK;
    }

    /**
     * Performs a movement key action.
     * The default implementation decodes the key down and invokes movement actions
     * such as {@link #down} and {@link #up}.
     * {@link #onKeyDown(TextView, Spannable, int, KeyEvent)} calls this method once
     * to handle an {@link KeyEvent#ACTION_DOWN}.
     * {@link #onKeyOther(TextView, Spannable, KeyEvent)} calls this method repeatedly
     * to handle each repetition of an {@link KeyEvent#ACTION_MULTIPLE}.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @param event The key event.
     * @param keyCode The key code.
     * @param movementMetaState The keyboard meta states used for movement.
     * @param event The key event.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.895 -0500", hash_original_method = "53B656A1E8393E8F576933E71ADE5872", hash_generated_method = "FC35E750B02F4D33CAFD6BC2C3791C62")
    
protected boolean handleMovementKey(TextView widget, Spannable buffer,
            int keyCode, int movementMetaState, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    return left(widget, buffer);
                } else if (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON)) {
                    return leftWord(widget, buffer);
                } else if (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON)) {
                    return lineStart(widget, buffer);
                }
                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    return right(widget, buffer);
                } else if (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON)) {
                    return rightWord(widget, buffer);
                } else if (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON)) {
                    return lineEnd(widget, buffer);
                }
                break;

            case KeyEvent.KEYCODE_DPAD_UP:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    return up(widget, buffer);
                } else if (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON)) {
                    return top(widget, buffer);
                }
                break;

            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    return down(widget, buffer);
                } else if (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON)) {
                    return bottom(widget, buffer);
                }
                break;

            case KeyEvent.KEYCODE_PAGE_UP:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    return pageUp(widget, buffer);
                } else if (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON)) {
                    return top(widget, buffer);
                }
                break;

            case KeyEvent.KEYCODE_PAGE_DOWN:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    return pageDown(widget, buffer);
                } else if (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_ALT_ON)) {
                    return bottom(widget, buffer);
                }
                break;

            case KeyEvent.KEYCODE_MOVE_HOME:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    return home(widget, buffer);
                } else if (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON)) {
                    return top(widget, buffer);
                }
                break;

            case KeyEvent.KEYCODE_MOVE_END:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    return end(widget, buffer);
                } else if (KeyEvent.metaStateHasModifiers(movementMetaState,
                        KeyEvent.META_CTRL_ON)) {
                    return bottom(widget, buffer);
                }
                break;
        }
        return false;
    }

    /**
     * Performs a left movement action.
     * Moves the cursor or scrolls left by one character.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.898 -0500", hash_original_method = "176341E451B55C50C4D903315018153A", hash_generated_method = "9A326B7B865FA7C0667B1A1DA60FEAA8")
    
protected boolean left(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs a right movement action.
     * Moves the cursor or scrolls right by one character.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.901 -0500", hash_original_method = "68CC4A5755726297BC90EB8071236539", hash_generated_method = "C5BE334319C46F9911B52B73C8B29B15")
    
protected boolean right(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs an up movement action.
     * Moves the cursor or scrolls up by one line.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.904 -0500", hash_original_method = "4C3F0CF20A3CBF82271A73533254C678", hash_generated_method = "ECFEA25F0D89855BF10D19CCE99981F3")
    
protected boolean up(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs a down movement action.
     * Moves the cursor or scrolls down by one line.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.907 -0500", hash_original_method = "FDACBEC8690232193991EC2D654F498C", hash_generated_method = "D078A3B56DA2FD79425B2C4793E3686C")
    
protected boolean down(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs a page-up movement action.
     * Moves the cursor or scrolls up by one page.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.909 -0500", hash_original_method = "C9503F691DAF48A1F140F42890F719F7", hash_generated_method = "75295CDB136ABB1BD43FCC77F4FB771E")
    
protected boolean pageUp(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs a page-down movement action.
     * Moves the cursor or scrolls down by one page.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.912 -0500", hash_original_method = "EA27CD9461C85470B182D05F37CF9E99", hash_generated_method = "32B1F400463B2CFDF4B1DE0CA45358C7")
    
protected boolean pageDown(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs a top movement action.
     * Moves the cursor or scrolls to the top of the buffer.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.915 -0500", hash_original_method = "3F6686FAC1641E4D3DFFC3F0DB33E5B2", hash_generated_method = "216981D45436EB231A375BC2B77503BC")
    
protected boolean top(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs a bottom movement action.
     * Moves the cursor or scrolls to the bottom of the buffer.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.917 -0500", hash_original_method = "721AC2C980F4969C548FB1DE5C82C277", hash_generated_method = "209B4EBCE5294A6F4D5520F2CC807DB7")
    
protected boolean bottom(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs a line-start movement action.
     * Moves the cursor or scrolls to the start of the line.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.921 -0500", hash_original_method = "A4B1F2E867C9A510C601A243C52C492E", hash_generated_method = "833AD7BCDDF03DA1695D3173C8995B22")
    
protected boolean lineStart(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs an line-end movement action.
     * Moves the cursor or scrolls to the end of the line.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.924 -0500", hash_original_method = "A632F71919730AFFFF566F700D39B7D0", hash_generated_method = "932F9A6FF8031B05F90EB37CC4A15E26")
    
protected boolean lineEnd(TextView widget, Spannable buffer) {
        return false;
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.927 -0500", hash_original_method = "1043D0C7BC940A703E52A54D62DB9381", hash_generated_method = "ABEC348E4AB1FBAD61E24AF82C83BDF4")
    
protected boolean leftWord(TextView widget, Spannable buffer) {
        return false;
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.930 -0500", hash_original_method = "8D9EF29844655A160F605C571CBB67AE", hash_generated_method = "C36238ACEFFA30B64DEB8C8A3A1BA88B")
    
protected boolean rightWord(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs a home movement action.
     * Moves the cursor or scrolls to the start of the line or to the top of the
     * document depending on whether the insertion point is being moved or
     * the document is being scrolled.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.933 -0500", hash_original_method = "8E23D2BEC9459FE2CC91B2DD463DCF3F", hash_generated_method = "BC6CB065EB0B7AF2B43A5A8E99968917")
    
protected boolean home(TextView widget, Spannable buffer) {
        return false;
    }

    /**
     * Performs an end movement action.
     * Moves the cursor or scrolls to the start of the line or to the top of the
     * document depending on whether the insertion point is being moved or
     * the document is being scrolled.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.936 -0500", hash_original_method = "6807F0AF3535B8AAE125BEB8D24FA4BA", hash_generated_method = "7DA2859FCE2DEDE70AE86606F0E044B7")
    
protected boolean end(TextView widget, Spannable buffer) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.938 -0500", hash_original_method = "772DAE7A7DE9A4DC4AD657418C90F32E", hash_generated_method = "96238F5327E3F29FBECB2BEE47F6BB01")
    
private int getTopLine(TextView widget) {
        return widget.getLayout().getLineForVertical(widget.getScrollY());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.941 -0500", hash_original_method = "653A8A6EB137C95052F7EAEBCC41BD55", hash_generated_method = "B27F0DFF495893D0320AAD9700B2D49B")
    
private int getBottomLine(TextView widget) {
        return widget.getLayout().getLineForVertical(widget.getScrollY() + getInnerHeight(widget));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.943 -0500", hash_original_method = "C7082848D94AD1EC4FC0EC3514A56C71", hash_generated_method = "C8AA96D913F98A1E20A52773D7850BE0")
    
private int getInnerWidth(TextView widget) {
        return widget.getWidth() - widget.getTotalPaddingLeft() - widget.getTotalPaddingRight();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.946 -0500", hash_original_method = "232D6784857554322EB1F91BB9F6CC48", hash_generated_method = "1686F68590931348ED9EE24E7339A5D1")
    
private int getInnerHeight(TextView widget) {
        return widget.getHeight() - widget.getTotalPaddingTop() - widget.getTotalPaddingBottom();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.948 -0500", hash_original_method = "BCC9C4F3EEFF08511FB2E9A20E83B404", hash_generated_method = "4E285E25EBCE89BB8D1B109797CC140D")
    
private int getCharacterWidth(TextView widget) {
        return (int) Math.ceil(widget.getPaint().getFontSpacing());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.952 -0500", hash_original_method = "32AF158BA043ADAC837409A280E9071B", hash_generated_method = "E18D91E4CE6A7280CA567B61D79EC809")
    
private int getScrollBoundsLeft(TextView widget) {
        final Layout layout = widget.getLayout();
        final int topLine = getTopLine(widget);
        final int bottomLine = getBottomLine(widget);
        if (topLine > bottomLine) {
            return 0;
        }
        int left = Integer.MAX_VALUE;
        for (int line = topLine; line <= bottomLine; line++) {
            final int lineLeft = (int) Math.floor(layout.getLineLeft(line));
            if (lineLeft < left) {
                left = lineLeft;
            }
        }
        return left;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.956 -0500", hash_original_method = "F8CD0B2B66ECC22BDFE1C77AF25A13D6", hash_generated_method = "0B6499BF7B356F177185367BC5CFD4C0")
    
private int getScrollBoundsRight(TextView widget) {
        final Layout layout = widget.getLayout();
        final int topLine = getTopLine(widget);
        final int bottomLine = getBottomLine(widget);
        if (topLine > bottomLine) {
            return 0;
        }
        int right = Integer.MIN_VALUE;
        for (int line = topLine; line <= bottomLine; line++) {
            final int lineRight = (int) Math.ceil(layout.getLineRight(line));
            if (lineRight > right) {
                right = lineRight;
            }
        }
        return right;
    }

    /**
     * Performs a scroll left action.
     * Scrolls left by the specified number of characters.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @param amount The number of characters to scroll by.  Must be at least 1.
     * @return True if the event was handled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.959 -0500", hash_original_method = "99A2FC579527B2CEA9AC5A41AD01795F", hash_generated_method = "825533999D7EA8EAEDCD7568EFF8EDFC")
    
protected boolean scrollLeft(TextView widget, Spannable buffer, int amount) {
        final int minScrollX = getScrollBoundsLeft(widget);
        int scrollX = widget.getScrollX();
        if (scrollX > minScrollX) {
            scrollX = Math.max(scrollX - getCharacterWidth(widget) * amount, minScrollX);
            widget.scrollTo(scrollX, widget.getScrollY());
            return true;
        }
        return false;
    }

    /**
     * Performs a scroll right action.
     * Scrolls right by the specified number of characters.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @param amount The number of characters to scroll by.  Must be at least 1.
     * @return True if the event was handled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.962 -0500", hash_original_method = "34082555FFD2A1D5F6DB38655C7C2C48", hash_generated_method = "886C25356038296C284B1375A6AAF279")
    
protected boolean scrollRight(TextView widget, Spannable buffer, int amount) {
        final int maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX = widget.getScrollX();
        if (scrollX < maxScrollX) {
            scrollX = Math.min(scrollX + getCharacterWidth(widget) * amount, maxScrollX);
            widget.scrollTo(scrollX, widget.getScrollY());
            return true;
        }
        return false;
    }

    /**
     * Performs a scroll up action.
     * Scrolls up by the specified number of lines.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @param amount The number of lines to scroll by.  Must be at least 1.
     * @return True if the event was handled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.965 -0500", hash_original_method = "A3AFC4271D337C51C9B090DAD80C0547", hash_generated_method = "66D44934BBD9D417F0DC3C1EA648ECE2")
    
protected boolean scrollUp(TextView widget, Spannable buffer, int amount) {
        final Layout layout = widget.getLayout();
        final int top = widget.getScrollY();
        int topLine = layout.getLineForVertical(top);
        if (layout.getLineTop(topLine) == top) {
            // If the top line is partially visible, bring it all the way
            // into view; otherwise, bring the previous line into view.
            topLine -= 1;
        }
        if (topLine >= 0) {
            topLine = Math.max(topLine - amount + 1, 0);
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
            return true;
        }
        return false;
    }

    /**
     * Performs a scroll down action.
     * Scrolls down by the specified number of lines.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @param amount The number of lines to scroll by.  Must be at least 1.
     * @return True if the event was handled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.969 -0500", hash_original_method = "0BF828F72F7601E47AA52D725EC1C4EF", hash_generated_method = "EE6573A2B8B4EA11640B079D92F4EA4B")
    
protected boolean scrollDown(TextView widget, Spannable buffer, int amount) {
        final Layout layout = widget.getLayout();
        final int innerHeight = getInnerHeight(widget);
        final int bottom = widget.getScrollY() + innerHeight;
        int bottomLine = layout.getLineForVertical(bottom);
        if (layout.getLineTop(bottomLine + 1) < bottom + 1) {
            // Less than a pixel of this line is out of view,
            // so we must have tried to make it entirely in view
            // and now want the next line to be in view instead.
            bottomLine += 1;
        }
        final int limit = layout.getLineCount() - 1;
        if (bottomLine <= limit) {
            bottomLine = Math.min(bottomLine + amount - 1, limit);
            Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(bottomLine + 1) - innerHeight);
            return true;
        }
        return false;
    }

    /**
     * Performs a scroll page up action.
     * Scrolls up by one page.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.972 -0500", hash_original_method = "961665135E04FC2BFD71FE9A7899CD8F", hash_generated_method = "FA197A67FA9AFD61E253F9571020120A")
    
protected boolean scrollPageUp(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        final int top = widget.getScrollY() - getInnerHeight(widget);
        int topLine = layout.getLineForVertical(top);
        if (topLine >= 0) {
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(topLine));
            return true;
        }
        return false;
    }

    /**
     * Performs a scroll page up action.
     * Scrolls down by one page.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.975 -0500", hash_original_method = "FC4FA64E8CF6D16D369F4D51265A00D0", hash_generated_method = "91C873E2F616E76DAD27EEAF82611155")
    
protected boolean scrollPageDown(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        final int innerHeight = getInnerHeight(widget);
        final int bottom = widget.getScrollY() + innerHeight + innerHeight;
        int bottomLine = layout.getLineForVertical(bottom);
        if (bottomLine <= layout.getLineCount() - 1) {
            Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(bottomLine + 1) - innerHeight);
            return true;
        }
        return false;
    }

    /**
     * Performs a scroll to top action.
     * Scrolls to the top of the document.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.978 -0500", hash_original_method = "7CF9A5A04E9D7FD8D1056DC0F832B9EF", hash_generated_method = "31FD44C4E00A41800110B338F11EDAE7")
    
protected boolean scrollTop(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        if (getTopLine(widget) >= 0) {
            Touch.scrollTo(widget, layout, widget.getScrollX(), layout.getLineTop(0));
            return true;
        }
        return false;
    }

    /**
     * Performs a scroll to bottom action.
     * Scrolls to the bottom of the document.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.981 -0500", hash_original_method = "FCBCF26A13DC616293A73F9223FE45DF", hash_generated_method = "B090F47999C9CA9426C27A20092B34E2")
    
protected boolean scrollBottom(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        final int lineCount = layout.getLineCount();
        if (getBottomLine(widget) <= lineCount - 1) {
            Touch.scrollTo(widget, layout, widget.getScrollX(),
                    layout.getLineTop(lineCount) - getInnerHeight(widget));
            return true;
        }
        return false;
    }

    /**
     * Performs a scroll to line start action.
     * Scrolls to the start of the line.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.984 -0500", hash_original_method = "FDDC66476559B51E1C65BE36B03CFE74", hash_generated_method = "A720B7259EAC4DB25E0D2344508477F8")
    
protected boolean scrollLineStart(TextView widget, Spannable buffer) {
        final int minScrollX = getScrollBoundsLeft(widget);
        int scrollX = widget.getScrollX();
        if (scrollX > minScrollX) {
            widget.scrollTo(minScrollX, widget.getScrollY());
            return true;
        }
        return false;
    }

    /**
     * Performs a scroll to line end action.
     * Scrolls to the end of the line.
     *
     * @param widget The text view.
     * @param buffer The text buffer.
     * @return True if the event was handled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.987 -0500", hash_original_method = "83871D5A105C781298F6AD1F6CCA2A68", hash_generated_method = "C249710EF074815F212BBD44972F73A4")
    
protected boolean scrollLineEnd(TextView widget, Spannable buffer) {
        final int maxScrollX = getScrollBoundsRight(widget) - getInnerWidth(widget);
        int scrollX = widget.getScrollX();
        if (scrollX < maxScrollX) {
            widget.scrollTo(maxScrollX, widget.getScrollY());
            return true;
        }
        return false;
    }
    
}

