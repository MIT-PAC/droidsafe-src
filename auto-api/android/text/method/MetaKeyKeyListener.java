package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.KeyCharacterMap;

public abstract class MetaKeyKeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.386 -0400", hash_original_method = "7B5E2B2AC9A55C5898DE5BC7403307FE", hash_generated_method = "7B5E2B2AC9A55C5898DE5BC7403307FE")
        public MetaKeyKeyListener ()
    {
    }


        public static void resetMetaState(Spannable text) {
        text.removeSpan(CAP);
        text.removeSpan(ALT);
        text.removeSpan(SYM);
        text.removeSpan(SELECTING);
    }

    
        public static final int getMetaState(CharSequence text) {
        return getActive(text, CAP, META_SHIFT_ON, META_CAP_LOCKED) |
               getActive(text, ALT, META_ALT_ON, META_ALT_LOCKED) |
               getActive(text, SYM, META_SYM_ON, META_SYM_LOCKED) |
               getActive(text, SELECTING, META_SELECTING, META_SELECTING);
    }

    
        public static final int getMetaState(CharSequence text, int meta) {
        switch (meta) {
            case META_SHIFT_ON:
                return getActive(text, CAP, 1, 2);
            case META_ALT_ON:
                return getActive(text, ALT, 1, 2);
            case META_SYM_ON:
                return getActive(text, SYM, 1, 2);
            case META_SELECTING:
                return getActive(text, SELECTING, 1, 2);
            default:
                return 0;
        }
    }

    
        private static int getActive(CharSequence text, Object meta,
                                 int on, int lock) {
        if (!(text instanceof Spanned)) {
            return 0;
        }
        Spanned sp = (Spanned) text;
        int flag = sp.getSpanFlags(meta);
        if (flag == LOCKED) {
            return lock;
        } else if (flag != 0) {
            return on;
        } else {
            return 0;
        }
    }

    
        public static void adjustMetaAfterKeypress(Spannable content) {
        adjust(content, CAP);
        adjust(content, ALT);
        adjust(content, SYM);
    }

    
        public static boolean isMetaTracker(CharSequence text, Object what) {
        return what == CAP || what == ALT || what == SYM ||
               what == SELECTING;
    }

    
        public static boolean isSelectingMetaTracker(CharSequence text, Object what) {
        return what == SELECTING;
    }

    
        private static void adjust(Spannable content, Object what) {
        int current = content.getSpanFlags(what);
        if (current == PRESSED)
            content.setSpan(what, 0, 0, USED);
        else if (current == RELEASED)
            content.removeSpan(what);
    }

    
        protected static void resetLockedMeta(Spannable content) {
        resetLock(content, CAP);
        resetLock(content, ALT);
        resetLock(content, SYM);
        resetLock(content, SELECTING);
    }

    
        private static void resetLock(Spannable content, Object what) {
        int current = content.getSpanFlags(what);
        if (current == LOCKED)
            content.removeSpan(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.388 -0400", hash_original_method = "624DA77F613D89E75494C45A9B699A03", hash_generated_method = "FB579B778DA82786901004F1A2047BC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyDown(View view, Editable content, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        {
            press(content, CAP);
        } //End block
        {
            press(content, ALT);
        } //End block
        {
            press(content, SYM);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT || keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT) {
            //press(content, CAP);
            //return true;
        //}
        //if (keyCode == KeyEvent.KEYCODE_ALT_LEFT || keyCode == KeyEvent.KEYCODE_ALT_RIGHT
                //|| keyCode == KeyEvent.KEYCODE_NUM) {
            //press(content, ALT);
            //return true;
        //}
        //if (keyCode == KeyEvent.KEYCODE_SYM) {
            //press(content, SYM);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.389 -0400", hash_original_method = "04CA7F5473BAF6356CB45A56F068D921", hash_generated_method = "E0285D6A0C44E3186C120C08B0D214EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void press(Editable content, Object what) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(what.dsTaint);
        int state;
        state = content.getSpanFlags(what);
        ;
        content.setSpan(what, 0, 0, LOCKED);
        ;
        content.removeSpan(what);
        content.setSpan(what, 0, 0, PRESSED);
        // ---------- Original Method ----------
        //int state = content.getSpanFlags(what);
        //if (state == PRESSED)
            //; 
        //else if (state == RELEASED)
            //content.setSpan(what, 0, 0, LOCKED);
        //else if (state == USED)
            //; 
        //else if (state == LOCKED)
            //content.removeSpan(what);
        //else
            //content.setSpan(what, 0, 0, PRESSED);
    }

    
        public static void startSelecting(View view, Spannable content) {
        content.setSpan(SELECTING, 0, 0, PRESSED);
    }

    
        public static void stopSelecting(View view, Spannable content) {
        content.removeSpan(SELECTING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.389 -0400", hash_original_method = "B6764DC3BD8B6ED5267E5A941E3F8260", hash_generated_method = "66CB9CC396E27269B2BA19DB9D0EE325")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyUp(View view, Editable content, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        {
            release(content, CAP, event);
        } //End block
        {
            release(content, ALT, event);
        } //End block
        {
            release(content, SYM, event);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT || keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT) {
            //release(content, CAP, event);
            //return true;
        //}
        //if (keyCode == KeyEvent.KEYCODE_ALT_LEFT || keyCode == KeyEvent.KEYCODE_ALT_RIGHT
                //|| keyCode == KeyEvent.KEYCODE_NUM) {
            //release(content, ALT, event);
            //return true;
        //}
        //if (keyCode == KeyEvent.KEYCODE_SYM) {
            //release(content, SYM, event);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.398 -0400", hash_original_method = "E71400F62D0FFB0C9763693B0DBF0337", hash_generated_method = "C250673C989D8AF0C55D6C47EEB28AC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void release(Editable content, Object what, KeyEvent event) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        int current;
        current = content.getSpanFlags(what);
        {
            Object varC699C33CC3F83C4F539EF7C49D3EF2D4_796323377 = (event.getKeyCharacterMap().getModifierBehavior());
            //Begin case KeyCharacterMap.MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED 
            content.removeSpan(what);
            content.setSpan(what, 0, 0, RELEASED);
            //End case KeyCharacterMap.MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED 
            //Begin case default 
            content.removeSpan(what);
            //End case default 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int current = content.getSpanFlags(what);
        //switch (event.getKeyCharacterMap().getModifierBehavior()) {
            //case KeyCharacterMap.MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED:
                //if (current == USED)
                    //content.removeSpan(what);
                //else if (current == PRESSED)
                    //content.setSpan(what, 0, 0, RELEASED);
                //break;
            //default:
                //content.removeSpan(what);
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.398 -0400", hash_original_method = "A6CA9AE4F5FD679B652E94F0868BFDE8", hash_generated_method = "DA439D7395714D25D42B38ED4E2F61C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearMetaKeyState(View view, Editable content, int states) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(states);
        dsTaint.addTaint(view.dsTaint);
        clearMetaKeyState(content, states);
        // ---------- Original Method ----------
        //clearMetaKeyState(content, states);
    }

    
        public static void clearMetaKeyState(Editable content, int states) {
        if ((states&META_SHIFT_ON) != 0) content.removeSpan(CAP);
        if ((states&META_ALT_ON) != 0) content.removeSpan(ALT);
        if ((states&META_SYM_ON) != 0) content.removeSpan(SYM);
        if ((states&META_SELECTING) != 0) content.removeSpan(SELECTING);
    }

    
        public static long resetLockedMeta(long state) {
        if ((state & META_CAP_LOCKED) != 0) {
            state &= ~META_SHIFT_MASK;
        }
        if ((state & META_ALT_LOCKED) != 0) {
            state &= ~META_ALT_MASK;
        }
        if ((state & META_SYM_LOCKED) != 0) {
            state &= ~META_SYM_MASK;
        }
        return state;
    }

    
        public static final int getMetaState(long state) {
        int result = 0;
        if ((state & META_CAP_LOCKED) != 0) {
            result |= META_CAP_LOCKED;
        } else if ((state & META_SHIFT_ON) != 0) {
            result |= META_SHIFT_ON;
        }
        if ((state & META_ALT_LOCKED) != 0) {
            result |= META_ALT_LOCKED;
        } else if ((state & META_ALT_ON) != 0) {
            result |= META_ALT_ON;
        }
        if ((state & META_SYM_LOCKED) != 0) {
            result |= META_SYM_LOCKED;
        } else if ((state & META_SYM_ON) != 0) {
            result |= META_SYM_ON;
        }
        return result;
    }

    
        public static final int getMetaState(long state, int meta) {
        switch (meta) {
            case META_SHIFT_ON:
                if ((state & META_CAP_LOCKED) != 0) return 2;
                if ((state & META_SHIFT_ON) != 0) return 1;
                return 0;
            case META_ALT_ON:
                if ((state & META_ALT_LOCKED) != 0) return 2;
                if ((state & META_ALT_ON) != 0) return 1;
                return 0;
            case META_SYM_ON:
                if ((state & META_SYM_LOCKED) != 0) return 2;
                if ((state & META_SYM_ON) != 0) return 1;
                return 0;
            default:
                return 0;
        }
    }

    
        public static long adjustMetaAfterKeypress(long state) {
        if ((state & META_CAP_PRESSED) != 0) {
            state = (state & ~META_SHIFT_MASK) | META_SHIFT_ON | META_CAP_USED;
        } else if ((state & META_CAP_RELEASED) != 0) {
            state &= ~META_SHIFT_MASK;
        }
        if ((state & META_ALT_PRESSED) != 0) {
            state = (state & ~META_ALT_MASK) | META_ALT_ON | META_ALT_USED;
        } else if ((state & META_ALT_RELEASED) != 0) {
            state &= ~META_ALT_MASK;
        }
        if ((state & META_SYM_PRESSED) != 0) {
            state = (state & ~META_SYM_MASK) | META_SYM_ON | META_SYM_USED;
        } else if ((state & META_SYM_RELEASED) != 0) {
            state &= ~META_SYM_MASK;
        }
        return state;
    }

    
        public static long handleKeyDown(long state, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT || keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT) {
            return press(state, META_SHIFT_ON, META_SHIFT_MASK,
                    META_CAP_LOCKED, META_CAP_PRESSED, META_CAP_RELEASED, META_CAP_USED);
        }
        if (keyCode == KeyEvent.KEYCODE_ALT_LEFT || keyCode == KeyEvent.KEYCODE_ALT_RIGHT
                || keyCode == KeyEvent.KEYCODE_NUM) {
            return press(state, META_ALT_ON, META_ALT_MASK,
                    META_ALT_LOCKED, META_ALT_PRESSED, META_ALT_RELEASED, META_ALT_USED);
        }
        if (keyCode == KeyEvent.KEYCODE_SYM) {
            return press(state, META_SYM_ON, META_SYM_MASK,
                    META_SYM_LOCKED, META_SYM_PRESSED, META_SYM_RELEASED, META_SYM_USED);
        }
        return state;
    }

    
        private static long press(long state, int what, long mask,
            long locked, long pressed, long released, long used) {
        if ((state & pressed) != 0) {
        } else if ((state & released) != 0) {
            state = (state &~ mask) | what | locked;
        } else if ((state & used) != 0) {
        } else if ((state & locked) != 0) {
            state &= ~mask;
        } else {
            state |= what | pressed;
        }
        return state;
    }

    
        public static long handleKeyUp(long state, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT || keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT) {
            return release(state, META_SHIFT_ON, META_SHIFT_MASK,
                    META_CAP_PRESSED, META_CAP_RELEASED, META_CAP_USED, event);
        }
        if (keyCode == KeyEvent.KEYCODE_ALT_LEFT || keyCode == KeyEvent.KEYCODE_ALT_RIGHT
                || keyCode == KeyEvent.KEYCODE_NUM) {
            return release(state, META_ALT_ON, META_ALT_MASK,
                    META_ALT_PRESSED, META_ALT_RELEASED, META_ALT_USED, event);
        }
        if (keyCode == KeyEvent.KEYCODE_SYM) {
            return release(state, META_SYM_ON, META_SYM_MASK,
                    META_SYM_PRESSED, META_SYM_RELEASED, META_SYM_USED, event);
        }
        return state;
    }

    
        private static long release(long state, int what, long mask,
            long pressed, long released, long used, KeyEvent event) {
        switch (event.getKeyCharacterMap().getModifierBehavior()) {
            case KeyCharacterMap.MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED:
                if ((state & used) != 0) {
                    state &= ~mask;
                } else if ((state & pressed) != 0) {
                    state |= what | released;
                }
                break;
            default:
                state &= ~mask;
                break;
        }
        return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.400 -0400", hash_original_method = "DB6E28AB316658FAB51CA26FDC440ADD", hash_generated_method = "AC39BBF4C21513713F7A1CF41351F30D")
    @DSModeled(DSC.SAFE)
    public long clearMetaKeyState(long state, int which) {
        dsTaint.addTaint(which);
        dsTaint.addTaint(state);
        {
            state &= ~META_SHIFT_MASK;
        } //End block
        {
            state &= ~META_ALT_MASK;
        } //End block
        {
            state &= ~META_SYM_MASK;
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if ((which & META_SHIFT_ON) != 0 && (state & META_CAP_LOCKED) != 0) {
            //state &= ~META_SHIFT_MASK;
        //}
        //if ((which & META_ALT_ON) != 0 && (state & META_ALT_LOCKED) != 0) {
            //state &= ~META_ALT_MASK;
        //}
        //if ((which & META_SYM_ON) != 0 && (state & META_SYM_LOCKED) != 0) {
            //state &= ~META_SYM_MASK;
        //}
        //return state;
    }

    
    public static final int META_SHIFT_ON = KeyEvent.META_SHIFT_ON;
    public static final int META_ALT_ON = KeyEvent.META_ALT_ON;
    public static final int META_SYM_ON = KeyEvent.META_SYM_ON;
    public static final int META_CAP_LOCKED = KeyEvent.META_CAP_LOCKED;
    public static final int META_ALT_LOCKED = KeyEvent.META_ALT_LOCKED;
    public static final int META_SYM_LOCKED = KeyEvent.META_SYM_LOCKED;
    public static final int META_SELECTING = KeyEvent.META_SELECTING;
    private static final long META_CAP_USED = 1L << 32;
    private static final long META_ALT_USED = 1L << 33;
    private static final long META_SYM_USED = 1L << 34;
    private static final long META_CAP_PRESSED = 1L << 40;
    private static final long META_ALT_PRESSED = 1L << 41;
    private static final long META_SYM_PRESSED = 1L << 42;
    private static final long META_CAP_RELEASED = 1L << 48;
    private static final long META_ALT_RELEASED = 1L << 49;
    private static final long META_SYM_RELEASED = 1L << 50;
    private static final long META_SHIFT_MASK = META_SHIFT_ON
            | META_CAP_LOCKED | META_CAP_USED
            | META_CAP_PRESSED | META_CAP_RELEASED;
    private static final long META_ALT_MASK = META_ALT_ON
            | META_ALT_LOCKED | META_ALT_USED
            | META_ALT_PRESSED | META_ALT_RELEASED;
    private static final long META_SYM_MASK = META_SYM_ON
            | META_SYM_LOCKED | META_SYM_USED
            | META_SYM_PRESSED | META_SYM_RELEASED;
    private static final Object CAP = new NoCopySpan.Concrete();
    private static final Object ALT = new NoCopySpan.Concrete();
    private static final Object SYM = new NoCopySpan.Concrete();
    private static final Object SELECTING = new NoCopySpan.Concrete();
    private static final int PRESSED = 
        Spannable.SPAN_MARK_MARK | (1 << Spannable.SPAN_USER_SHIFT);
    private static final int RELEASED = 
        Spannable.SPAN_MARK_MARK | (2 << Spannable.SPAN_USER_SHIFT);
    private static final int USED = 
        Spannable.SPAN_MARK_MARK | (3 << Spannable.SPAN_USER_SHIFT);
    private static final int LOCKED = 
        Spannable.SPAN_MARK_MARK | (4 << Spannable.SPAN_USER_SHIFT);
}

