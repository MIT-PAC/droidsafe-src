package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.KeyCharacterMap;

public abstract class MetaKeyKeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.215 -0400", hash_original_method = "50168EE5CC1513DB2EA8BA89DC077CDF", hash_generated_method = "50168EE5CC1513DB2EA8BA89DC077CDF")
    public MetaKeyKeyListener ()
    {
        
    }


    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void adjustMetaAfterKeypress(Spannable content) {
        adjust(content, CAP);
        adjust(content, ALT);
        adjust(content, SYM);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isMetaTracker(CharSequence text, Object what) {
        return what == CAP || what == ALT || what == SYM ||
               what == SELECTING;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isSelectingMetaTracker(CharSequence text, Object what) {
        return what == SELECTING;
    }

    
    @DSModeled(DSC.SAFE)
    private static void adjust(Spannable content, Object what) {
        int current = content.getSpanFlags(what);
        if (current == PRESSED)
            content.setSpan(what, 0, 0, USED);
        else if (current == RELEASED)
            content.removeSpan(what);
    }

    
    @DSModeled(DSC.SAFE)
    protected static void resetLockedMeta(Spannable content) {
        resetLock(content, CAP);
        resetLock(content, ALT);
        resetLock(content, SYM);
        resetLock(content, SELECTING);
    }

    
    @DSModeled(DSC.SAFE)
    private static void resetLock(Spannable content, Object what) {
        int current = content.getSpanFlags(what);
        if (current == LOCKED)
            content.removeSpan(what);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.218 -0400", hash_original_method = "624DA77F613D89E75494C45A9B699A03", hash_generated_method = "28A86F201295BA88A07BAA955089683F")
    public boolean onKeyDown(View view, Editable content, int keyCode, KeyEvent event) {
        
        {
            press(content, CAP);
        } 
        {
            press(content, ALT);
        } 
        {
            press(content, SYM);
        } 
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711377986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711377986;
        
        
            
            
        
        
                
            
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.219 -0400", hash_original_method = "04CA7F5473BAF6356CB45A56F068D921", hash_generated_method = "A96D2DB60223ECE2FB8FD5684C07CFB8")
    private void press(Editable content, Object what) {
        int state = content.getSpanFlags(what);
        ;
        content.setSpan(what, 0, 0, LOCKED);
        ;
        content.removeSpan(what);
        content.setSpan(what, 0, 0, PRESSED);
        addTaint(content.getTaint());
        addTaint(what.getTaint());
        
        
        
            
        
            
        
            
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    public static void startSelecting(View view, Spannable content) {
        content.setSpan(SELECTING, 0, 0, PRESSED);
    }

    
    @DSModeled(DSC.SAFE)
    public static void stopSelecting(View view, Spannable content) {
        content.removeSpan(SELECTING);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.220 -0400", hash_original_method = "B6764DC3BD8B6ED5267E5A941E3F8260", hash_generated_method = "F5365FB48A6D761E37E1A822494AC3AB")
    public boolean onKeyUp(View view, Editable content, int keyCode, KeyEvent event) {
        
        {
            release(content, CAP, event);
        } 
        {
            release(content, ALT, event);
        } 
        {
            release(content, SYM, event);
        } 
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_622444065 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_622444065;
        
        
            
            
        
        
                
            
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.220 -0400", hash_original_method = "E71400F62D0FFB0C9763693B0DBF0337", hash_generated_method = "041DC3327E85891F51162C147909018D")
    private void release(Editable content, Object what, KeyEvent event) {
        int current = content.getSpanFlags(what);
        {
            Object varC699C33CC3F83C4F539EF7C49D3EF2D4_1913850831 = (event.getKeyCharacterMap().getModifierBehavior());
            
            content.removeSpan(what);
            content.setSpan(what, 0, 0, RELEASED);
            
            
            content.removeSpan(what);
            
        } 
        addTaint(content.getTaint());
        addTaint(what.getTaint());
        addTaint(event.getTaint());
        
        
        
            
                
                    
                
                    
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.221 -0400", hash_original_method = "A6CA9AE4F5FD679B652E94F0868BFDE8", hash_generated_method = "65C7EB6E1C3E4A667E7C05183CE85EC6")
    public void clearMetaKeyState(View view, Editable content, int states) {
        clearMetaKeyState(content, states);
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(states);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void clearMetaKeyState(Editable content, int states) {
        if ((states&META_SHIFT_ON) != 0) content.removeSpan(CAP);
        if ((states&META_ALT_ON) != 0) content.removeSpan(ALT);
        if ((states&META_SYM_ON) != 0) content.removeSpan(SYM);
        if ((states&META_SELECTING) != 0) content.removeSpan(SELECTING);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_method = "DB6E28AB316658FAB51CA26FDC440ADD", hash_generated_method = "D9DFE54C9CA44FE11588E01AA242716A")
    public long clearMetaKeyState(long state, int which) {
        {
            state &= ~META_SHIFT_MASK;
        } 
        {
            state &= ~META_ALT_MASK;
        } 
        {
            state &= ~META_SYM_MASK;
        } 
        addTaint(state);
        addTaint(which);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1105519962 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1105519962;
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "8F5B55B772D92F8792B90E409D4B27C3", hash_generated_field = "50FB6A77E614B1ED8B296A53624D1C28")

    public static final int META_SHIFT_ON = KeyEvent.META_SHIFT_ON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "FF331A178435FEBFBEE4C481B76BC537", hash_generated_field = "A7D01BF2B90736D77B6C1B9C8A14691C")

    public static final int META_ALT_ON = KeyEvent.META_ALT_ON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "6B8B27FBAB54B68B42B6A0B6E51A6D0D", hash_generated_field = "E66DF9B973124964B6BEE6AE2D11CD98")

    public static final int META_SYM_ON = KeyEvent.META_SYM_ON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "0D5AA65A3E884AE9964C9AEBA871ADEF", hash_generated_field = "447FC51E6AE0E3B16DE40EBC9DBC960D")

    public static final int META_CAP_LOCKED = KeyEvent.META_CAP_LOCKED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "39DDF795094797E41B9430C15F3C2ACF", hash_generated_field = "B0A84D4062148CA880301CFD297B7593")

    public static final int META_ALT_LOCKED = KeyEvent.META_ALT_LOCKED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "448C9B31CE416D03EF94AF4488286183", hash_generated_field = "3C3F8EAFF71797500355E92C6A4E9521")

    public static final int META_SYM_LOCKED = KeyEvent.META_SYM_LOCKED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "1ED26409AB4D6DF9C88E02A355634ADD", hash_generated_field = "33B69A2A6949E560C4902EDA1683DBA6")

    public static final int META_SELECTING = KeyEvent.META_SELECTING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "99D91A41C4635DB48DAB61B05F4DDE9A", hash_generated_field = "207E37EA7D1BA1AC149E1839C5EDE820")

    private static final long META_CAP_USED = 1L << 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "C1B1EAE67A7538C4BE2A22F87F8B3E47", hash_generated_field = "416E18F4CAACD41547A511274199372C")

    private static final long META_ALT_USED = 1L << 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "C6FC98E5512281852DBF3D0B6F88577A", hash_generated_field = "F4636ABDD216B71C7F174060386EFF53")

    private static final long META_SYM_USED = 1L << 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "CF8AAF82FD124D8B5499CEA8E496FE5A", hash_generated_field = "51CD84D505E6D4831202FD0007A27D43")

    private static final long META_CAP_PRESSED = 1L << 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "BE8F44CB72788609DCCD6498A969F32B", hash_generated_field = "B17461FACE3B2089532657AE6E58FCC5")

    private static final long META_ALT_PRESSED = 1L << 41;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "8086DA2C9DF5C55842EC1EF49F304FE7", hash_generated_field = "7B9C1B5E3D25B14EF67E916D0C6FECAF")

    private static final long META_SYM_PRESSED = 1L << 42;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "C4765B8A2FB18BED49BCAA8C2E5179C1", hash_generated_field = "65E05A712966D9C21718EAAECA8D41F7")

    private static final long META_CAP_RELEASED = 1L << 48;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "29903D661A821F70A6821CA54DE3A005", hash_generated_field = "93CFE14245B5D84462927164A9DC73E4")

    private static final long META_ALT_RELEASED = 1L << 49;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "F4429F05EEECAB84CCF6A5FC72BA1976", hash_generated_field = "96DB514097F9CB132B57424F1BAC7FB5")

    private static final long META_SYM_RELEASED = 1L << 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "2A97A0DD0A63C7C4F489F03391936363", hash_generated_field = "4C64A1C928F979D257FB830FA9A9CA3C")

    private static final long META_SHIFT_MASK = META_SHIFT_ON
            | META_CAP_LOCKED | META_CAP_USED
            | META_CAP_PRESSED | META_CAP_RELEASED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "E40973594DBB43CB75AC4E1F085614B9", hash_generated_field = "4D41DD10A09A8496CAB18AAC9D3C0814")

    private static final long META_ALT_MASK = META_ALT_ON
            | META_ALT_LOCKED | META_ALT_USED
            | META_ALT_PRESSED | META_ALT_RELEASED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "675BAD4ED50DEEAF348822540914F46C", hash_generated_field = "5969AB589085121EAD361C0B2E6B806B")

    private static final long META_SYM_MASK = META_SYM_ON
            | META_SYM_LOCKED | META_SYM_USED
            | META_SYM_PRESSED | META_SYM_RELEASED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "37AC59D8FA2118D968D1F4F29050ED98", hash_generated_field = "32785D8650D9452EBAC9F402F8F67AC3")

    private static final Object CAP = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "22CA4A1457EAEFA47D0D55B01FF7D429", hash_generated_field = "B88F90E026963AEBF638FEDCBEAB9636")

    private static final Object ALT = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "B71E9730FDB596A0D5FDBC70A2A6CB9C", hash_generated_field = "B87091EF52B26B0E1B6D750562987C06")

    private static final Object SYM = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "92DA59F9BEBF0A784F734657550B9E98", hash_generated_field = "3C09E31C92AB1AD9D12FD85F60EB25B1")

    private static final Object SELECTING = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "4102CE345AC150291BA05E018466CCBF", hash_generated_field = "202BC3B94B3A5615EE126335905630FB")

    private static final int PRESSED = Spannable.SPAN_MARK_MARK | (1 << Spannable.SPAN_USER_SHIFT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "78B305ACDA268B59FA932F2801ABEC69", hash_generated_field = "BC66E5DC8BB3C6648B931311058232F7")

    private static final int RELEASED = Spannable.SPAN_MARK_MARK | (2 << Spannable.SPAN_USER_SHIFT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "93C97F4DAFF20F05A6BB3ADAD355F03C", hash_generated_field = "C61D469DE0E04078B7D762DE922DEDE9")

    private static final int USED = Spannable.SPAN_MARK_MARK | (3 << Spannable.SPAN_USER_SHIFT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.223 -0400", hash_original_field = "AA52AB61F94B838F79681AF3D1D93FCE", hash_generated_field = "101707FF248EB2BB713DED8E5B8324C3")

    private static final int LOCKED = Spannable.SPAN_MARK_MARK | (4 << Spannable.SPAN_USER_SHIFT);
}

