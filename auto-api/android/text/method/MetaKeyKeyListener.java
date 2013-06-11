package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.text.Editable;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.KeyCharacterMap;

public abstract class MetaKeyKeyListener {
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "8AF64E1EA84DF175FDB50570C8CEC5BF", hash_generated_method = "21B6D80DCB62FCFE1606C3D631A5E0D3")
    public static void resetMetaState(Spannable text) {
        text.removeSpan(CAP);
        text.removeSpan(ALT);
        text.removeSpan(SYM);
        text.removeSpan(SELECTING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "A3D3969A4E5BE158AB30CE45C881503B", hash_generated_method = "8E6859C3B9FCD0D9EC9A4DF8B984938E")
    public static final int getMetaState(CharSequence text) {
        return getActive(text, CAP, META_SHIFT_ON, META_CAP_LOCKED) |
               getActive(text, ALT, META_ALT_ON, META_ALT_LOCKED) |
               getActive(text, SYM, META_SYM_ON, META_SYM_LOCKED) |
               getActive(text, SELECTING, META_SELECTING, META_SELECTING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "BC173CC5F32A7F644973716C59DAC229", hash_generated_method = "247FA46B8CB62E86008EA7F4E88B98D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "DC7E5B320979169FEF23BC2039331A57", hash_generated_method = "A0EED6475A72BC8D44D20E76C1138C0B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "32802909F6EBAD9D75292258771F56F1", hash_generated_method = "3BA613D5324C3D37BC1D540DE0F7918B")
    public static void adjustMetaAfterKeypress(Spannable content) {
        adjust(content, CAP);
        adjust(content, ALT);
        adjust(content, SYM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "8BA6018CB8A318230609528649963F72", hash_generated_method = "C565AB3185A2854C0E70614435A35BCC")
    public static boolean isMetaTracker(CharSequence text, Object what) {
        return what == CAP || what == ALT || what == SYM ||
               what == SELECTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "F9AD5FB516FC92F512EBE4470BCD6254", hash_generated_method = "D291075F019491CDE84D4F2AF5684185")
    public static boolean isSelectingMetaTracker(CharSequence text, Object what) {
        return what == SELECTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "3BF97564F386FB083018A6AA958725D3", hash_generated_method = "5E00F607FF0F01F7DEB1EE4F8138FBE9")
    private static void adjust(Spannable content, Object what) {
        int current = content.getSpanFlags(what);
        if (current == PRESSED)
            content.setSpan(what, 0, 0, USED);
        else if (current == RELEASED)
            content.removeSpan(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "85EDDF72490A9BF1E58EACB23506A0DF", hash_generated_method = "D3EF5707B9CCEF81D998C8F2A719679C")
    protected static void resetLockedMeta(Spannable content) {
        resetLock(content, CAP);
        resetLock(content, ALT);
        resetLock(content, SYM);
        resetLock(content, SELECTING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "F385B7A10FE4F8593841A972238FB62B", hash_generated_method = "B877076FE3F00B59975203659B35F9FA")
    private static void resetLock(Spannable content, Object what) {
        int current = content.getSpanFlags(what);
        if (current == LOCKED)
            content.removeSpan(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.087 -0400", hash_original_method = "624DA77F613D89E75494C45A9B699A03", hash_generated_method = "6C59D29E66BDF7E511114713B3FD4E44")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.088 -0400", hash_original_method = "04CA7F5473BAF6356CB45A56F068D921", hash_generated_method = "3350D3409477E1F21E1E0BF2D192A083")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.088 -0400", hash_original_method = "FCE3F0DACA962344761C11774B544CCF", hash_generated_method = "942ABB0BCF583B3FE6A77B7D88C3097A")
    public static void startSelecting(View view, Spannable content) {
        content.setSpan(SELECTING, 0, 0, PRESSED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.088 -0400", hash_original_method = "F1455B908B6FB899340003D4BDACF2B8", hash_generated_method = "FBBD4F88CF121B7225FC51054D2EC033")
    public static void stopSelecting(View view, Spannable content) {
        content.removeSpan(SELECTING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.088 -0400", hash_original_method = "B6764DC3BD8B6ED5267E5A941E3F8260", hash_generated_method = "2A0036848330F494F028E4FB265EE4DA")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.088 -0400", hash_original_method = "E71400F62D0FFB0C9763693B0DBF0337", hash_generated_method = "128EBAFB74DE3FAAFC5361718C33BA3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void release(Editable content, Object what, KeyEvent event) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        int current;
        current = content.getSpanFlags(what);
        {
            Object varC699C33CC3F83C4F539EF7C49D3EF2D4_1725771686 = (event.getKeyCharacterMap().getModifierBehavior());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.088 -0400", hash_original_method = "A6CA9AE4F5FD679B652E94F0868BFDE8", hash_generated_method = "560269675451926AB73EF8BDB07DF964")
    @DSModeled(DSC.SAFE)
    public void clearMetaKeyState(View view, Editable content, int states) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(states);
        dsTaint.addTaint(view.dsTaint);
        clearMetaKeyState(content, states);
        // ---------- Original Method ----------
        //clearMetaKeyState(content, states);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.088 -0400", hash_original_method = "3BBDACC08BE9E524CFC4AC125A516AAF", hash_generated_method = "95EE6EA7D6BE7E57EFCD5FCA500C6C89")
    public static void clearMetaKeyState(Editable content, int states) {
        if ((states&META_SHIFT_ON) != 0) content.removeSpan(CAP);
        if ((states&META_ALT_ON) != 0) content.removeSpan(ALT);
        if ((states&META_SYM_ON) != 0) content.removeSpan(SYM);
        if ((states&META_SELECTING) != 0) content.removeSpan(SELECTING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.088 -0400", hash_original_method = "0D999DF67FD3DA664CB224325BB4CDF3", hash_generated_method = "BA088125197E885C0F007722531AC093")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.089 -0400", hash_original_method = "8759945C5194DF9FDA8684974019087A", hash_generated_method = "C6021809A3234588E9A91CEFDF648670")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.089 -0400", hash_original_method = "9198ADB45CCF6407614EAE29C1436072", hash_generated_method = "6CB187D36897895866179D6DBBA7DC2E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.089 -0400", hash_original_method = "85D05E4D48A450B763B6DAAD57350FCF", hash_generated_method = "55662DC866222A7973725C5362BC602B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.089 -0400", hash_original_method = "9974C6A3EEB89F79A5040D80CF59B71F", hash_generated_method = "599015E0527571C431A15827FA2EB1AB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.089 -0400", hash_original_method = "A4E9062BCF162F20B883EE858916DF72", hash_generated_method = "5FBAF66988C99D2A9A9F7200F182FD38")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.089 -0400", hash_original_method = "2D3829F01E07E80E02365A68C6B16FCB", hash_generated_method = "F10381060CF01AE740B456044757E6C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.089 -0400", hash_original_method = "10C2625F1E262859011D37FDCAF1A563", hash_generated_method = "4588BB36D600BCDD1612130EDB7E26E3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.089 -0400", hash_original_method = "DB6E28AB316658FAB51CA26FDC440ADD", hash_generated_method = "A775C076889A8B8B24052A6900988D96")
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

    
}


