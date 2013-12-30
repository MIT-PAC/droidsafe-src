package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;





public class ArrowKeyMovementMethod extends BaseMovementMethod implements MovementMethod {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.988 -0500", hash_original_method = "10FB2C5181FC75DCDE827D6825AC823C", hash_generated_method = "3DF60ED1FB680D7B0FC31C6971FBC7AB")
    
private static boolean isSelecting(Spannable buffer) {
        return ((MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SHIFT_ON) == 1) ||
                (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.991 -0500", hash_original_method = "B32CF67C9FC1D2460F3CDAFFC02432C6", hash_generated_method = "E50627C444B7462E735DEC4717099E16")
    
private static int getCurrentLineTop(Spannable buffer, Layout layout) {
        return layout.getLineTop(layout.getLineForOffset(Selection.getSelectionEnd(buffer)));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.994 -0500", hash_original_method = "198FB1E56D73131196EB8E515A75F310", hash_generated_method = "271BE0BC2287054435F970D404F258B1")
    
private static int getPageHeight(TextView widget) {
        // This calculation does not take into account the view transformations that
        // may have been applied to the child or its containers.  In case of scaling or
        // rotation, the calculated page height may be incorrect.
        final Rect rect = new Rect();
        return widget.getGlobalVisibleRect(rect) ? rect.height() : 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.056 -0500", hash_original_method = "1DB0A35A4E73C95F823446362F035621", hash_generated_method = "7D06961535B06F9469B80E24BBEF2437")
    
public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new ArrowKeyMovementMethod();
        }

        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.058 -0500", hash_original_field = "D9BC76BBD95C2B4D84D70C80192606E6", hash_generated_field = "C1D458E78FA0EB0FEAAB09CC3F93FF9B")


    private static final Object LAST_TAP_DOWN = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.061 -0500", hash_original_field = "78B60DB7CF60EF81374663AFB63ABCCA", hash_generated_field = "94586F1D0C81A1F26D9B8315CD4A2D36")

    private static ArrowKeyMovementMethod sInstance;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.894 -0400", hash_original_method = "4B84DCFAF96B2ABE0CEB1C58A836BE09", hash_generated_method = "4B84DCFAF96B2ABE0CEB1C58A836BE09")
    public ArrowKeyMovementMethod ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.997 -0500", hash_original_method = "71AB0E1C222F7165F2E5407A96AE4AA1", hash_generated_method = "AD008803C5DEC225924E42963C1DD035")
    
@Override
    protected boolean handleMovementKey(TextView widget, Spannable buffer, int keyCode,
            int movementMetaState, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
                if (KeyEvent.metaStateHasNoModifiers(movementMetaState)) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN
                            && event.getRepeatCount() == 0
                            && MetaKeyKeyListener.getMetaState(buffer,
                                        MetaKeyKeyListener.META_SELECTING) != 0) {
                        return widget.showContextMenu();
                    }
                }
                break;
        }
        return super.handleMovementKey(widget, buffer, keyCode, movementMetaState, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.000 -0500", hash_original_method = "EF44D7EB21450A63AD253DA49BF056E0", hash_generated_method = "2923A4360DD180307E8DD9EAE24D99B9")
    
@Override
    protected boolean left(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        if (isSelecting(buffer)) {
            return Selection.extendLeft(buffer, layout);
        } else {
            return Selection.moveLeft(buffer, layout);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.003 -0500", hash_original_method = "B7F7970A1171CA8F77BB045891103F0E", hash_generated_method = "C93313F8F85F3A91BF71FC222F29D0BD")
    
@Override
    protected boolean right(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        if (isSelecting(buffer)) {
            return Selection.extendRight(buffer, layout);
        } else {
            return Selection.moveRight(buffer, layout);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.006 -0500", hash_original_method = "66883526BDCDE7C41943B5DCF27F9554", hash_generated_method = "EE05CD81F3D31F8040959449146205F8")
    
@Override
    protected boolean up(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        if (isSelecting(buffer)) {
            return Selection.extendUp(buffer, layout);
        } else {
            return Selection.moveUp(buffer, layout);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.008 -0500", hash_original_method = "6DF71BB34A28EC828AC8FDD5308B170F", hash_generated_method = "28BDC083EA9B61B2AA23401428DB56AC")
    
@Override
    protected boolean down(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        if (isSelecting(buffer)) {
            return Selection.extendDown(buffer, layout);
        } else {
            return Selection.moveDown(buffer, layout);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.012 -0500", hash_original_method = "0758556D4F657617BD5DD9C53A72AD4E", hash_generated_method = "18C7DD2029C6D38AEF80FFFCD972E5F1")
    
@Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        final boolean selecting = isSelecting(buffer);
        final int targetY = getCurrentLineTop(buffer, layout) - getPageHeight(widget);
        boolean handled = false;
        for (;;) {
            final int previousSelectionEnd = Selection.getSelectionEnd(buffer);
            if (selecting) {
                Selection.extendUp(buffer, layout);
            } else {
                Selection.moveUp(buffer, layout);
            }
            if (Selection.getSelectionEnd(buffer) == previousSelectionEnd) {
                break;
            }
            handled = true;
            if (getCurrentLineTop(buffer, layout) <= targetY) {
                break;
            }
        }
        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.016 -0500", hash_original_method = "A67CFCD6529729C61F17F48248354AB4", hash_generated_method = "682B492D361A75EB33E97B6CE2972799")
    
@Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        final boolean selecting = isSelecting(buffer);
        final int targetY = getCurrentLineTop(buffer, layout) + getPageHeight(widget);
        boolean handled = false;
        for (;;) {
            final int previousSelectionEnd = Selection.getSelectionEnd(buffer);
            if (selecting) {
                Selection.extendDown(buffer, layout);
            } else {
                Selection.moveDown(buffer, layout);
            }
            if (Selection.getSelectionEnd(buffer) == previousSelectionEnd) {
                break;
            }
            handled = true;
            if (getCurrentLineTop(buffer, layout) >= targetY) {
                break;
            }
        }
        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.018 -0500", hash_original_method = "06E1F50FC60AD51807CA9DABCD3FCC05", hash_generated_method = "31E8DE7D41FE9FB90CA746DC7C5CC980")
    
@Override
    protected boolean top(TextView widget, Spannable buffer) {
        if (isSelecting(buffer)) {
            Selection.extendSelection(buffer, 0);
        } else {
            Selection.setSelection(buffer, 0);
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.021 -0500", hash_original_method = "BBC6BB5270095971A5BCCB29BC5686E5", hash_generated_method = "075B422EE3ACF926645DB60741A5F622")
    
@Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        if (isSelecting(buffer)) {
            Selection.extendSelection(buffer, buffer.length());
        } else {
            Selection.setSelection(buffer, buffer.length());
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.025 -0500", hash_original_method = "7B8F77C5EC46A68660F722ECA60D096A", hash_generated_method = "43E56F0EBBAB82202561EF21DC4C8DA9")
    
@Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        if (isSelecting(buffer)) {
            return Selection.extendToLeftEdge(buffer, layout);
        } else {
            return Selection.moveToLeftEdge(buffer, layout);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.028 -0500", hash_original_method = "35F3ADFF6FA8FAD8E2E9FED3F3766C71", hash_generated_method = "A60933A52518F3053334F8B7FCBE0DBD")
    
@Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        final Layout layout = widget.getLayout();
        if (isSelecting(buffer)) {
            return Selection.extendToRightEdge(buffer, layout);
        } else {
            return Selection.moveToRightEdge(buffer, layout);
        }
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.031 -0500", hash_original_method = "67D023CBFAD79BEA97EFF9BE9D5119F7", hash_generated_method = "D3ED49C1C72D7513360EF0A84862A7F2")
    
@Override
    protected boolean leftWord(TextView widget, Spannable buffer) {
        final int selectionEnd = widget.getSelectionEnd();
        final WordIterator wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        return Selection.moveToPreceding(buffer, wordIterator, isSelecting(buffer));
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.034 -0500", hash_original_method = "117E80B3C82F659E45802A24AF653E84", hash_generated_method = "FEBF9CC1713CFF52A6D4C5DAF0F27DCB")
    
@Override
    protected boolean rightWord(TextView widget, Spannable buffer) {
        final int selectionEnd = widget.getSelectionEnd();
        final WordIterator wordIterator = widget.getWordIterator();
        wordIterator.setCharSequence(buffer, selectionEnd, selectionEnd);
        return Selection.moveToFollowing(buffer, wordIterator, isSelecting(buffer));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.036 -0500", hash_original_method = "DA5AF1C545D6EFE1C03B36F52D97E891", hash_generated_method = "D91370DD31591252B9D05AFE4AD55480")
    
@Override
    protected boolean home(TextView widget, Spannable buffer) {
        return lineStart(widget, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.039 -0500", hash_original_method = "ED4119443F83D3A11CB1CCD10457DD79", hash_generated_method = "91E6B3274C388164023DF62D54467F8B")
    
@Override
    protected boolean end(TextView widget, Spannable buffer) {
        return lineEnd(widget, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.043 -0500", hash_original_method = "775DDAA4B9285FEC985F9D7EBE9B59EB", hash_generated_method = "3EE5DF01D151E72731C42950F399E4F7")
    
@Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        int initialScrollX = -1;
        int initialScrollY = -1;
        final int action = event.getAction();

        if (action == MotionEvent.ACTION_UP) {
            initialScrollX = Touch.getInitialScrollX(widget, buffer);
            initialScrollY = Touch.getInitialScrollY(widget, buffer);
        }

        boolean handled = Touch.onTouchEvent(widget, buffer, event);

        if (widget.isFocused() && !widget.didTouchFocusSelect()) {
            if (action == MotionEvent.ACTION_DOWN) {
              if (isSelecting(buffer)) {
                  int offset = widget.getOffsetForPosition(event.getX(), event.getY());

                  buffer.setSpan(LAST_TAP_DOWN, offset, offset, Spannable.SPAN_POINT_POINT);

                  // Disallow intercepting of the touch events, so that
                  // users can scroll and select at the same time.
                  // without this, users would get booted out of select
                  // mode once the view detected it needed to scroll.
                  widget.getParent().requestDisallowInterceptTouchEvent(true);
              }
            } else if (action == MotionEvent.ACTION_MOVE) {
                if (isSelecting(buffer) && handled) {
                    // Before selecting, make sure we've moved out of the "slop".
                    // handled will be true, if we're in select mode AND we're
                    // OUT of the slop

                    // Turn long press off while we're selecting. User needs to
                    // re-tap on the selection to enable long press
                    widget.cancelLongPress();

                    // Update selection as we're moving the selection area.

                    // Get the current touch position
                    int offset = widget.getOffsetForPosition(event.getX(), event.getY());

                    Selection.extendSelection(buffer, offset);
                    return true;
                }
            } else if (action == MotionEvent.ACTION_UP) {
                // If we have scrolled, then the up shouldn't move the cursor,
                // but we do need to make sure the cursor is still visible at
                // the current scroll offset to avoid the scroll jumping later
                // to show it.
                if ((initialScrollY >= 0 && initialScrollY != widget.getScrollY()) ||
                    (initialScrollX >= 0 && initialScrollX != widget.getScrollX())) {
                    widget.moveCursorToVisibleOffset();
                    return true;
                }

                int offset = widget.getOffsetForPosition(event.getX(), event.getY());
                if (isSelecting(buffer)) {
                    buffer.removeSpan(LAST_TAP_DOWN);
                    Selection.extendSelection(buffer, offset);
                } else if (!widget.shouldIgnoreActionUpEvent()) {
                    Selection.setSelection(buffer, offset);
                }

                MetaKeyKeyListener.adjustMetaAfterKeypress(buffer);
                MetaKeyKeyListener.resetLockedMeta(buffer);

                return true;
            }
        }

        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.046 -0500", hash_original_method = "1CF42BC1A6BA86440BF6AECA28532C33", hash_generated_method = "A03889865A448A1B07E2B3670E7E6E1D")
    
@Override
    public boolean canSelectArbitrarily() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.049 -0500", hash_original_method = "B727A4A512DEA5751C53503018F86261", hash_generated_method = "087D542741BA75F0162FA67292D33FDC")
    
@Override
    public void initialize(TextView widget, Spannable text) {
        Selection.setSelection(text, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:01.052 -0500", hash_original_method = "0BB03034B6278DCF1B976D7F50A71CD4", hash_generated_method = "CFD0CA292D33FB755F120809ED308230")
    
@Override
    public void onTakeFocus(TextView view, Spannable text, int dir) {
        if ((dir & (View.FOCUS_FORWARD | View.FOCUS_DOWN)) != 0) {
            if (view.getLayout() == null) {
                // This shouldn't be null, but do something sensible if it is.
                Selection.setSelection(text, text.length());
            }
        } else {
            Selection.setSelection(text, text.length());
        }
    }
}

