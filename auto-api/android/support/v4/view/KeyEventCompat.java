package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.KeyEvent;

public class KeyEventCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.358 -0400", hash_original_method = "532007D9C650EDCB29F8F1C752472985", hash_generated_method = "532007D9C650EDCB29F8F1C752472985")
    public KeyEventCompat ()
    {
        
    }


    public static int normalizeMetaState(int metaState) {
        return IMPL.normalizeMetaState(metaState);
    }

    
    public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        return IMPL.metaStateHasModifiers(metaState, modifiers);
    }

    
    public static boolean metaStateHasNoModifiers(int metaState) {
        return IMPL.metaStateHasNoModifiers(metaState);
    }

    
    public static boolean hasModifiers(KeyEvent event, int modifiers) {
        return IMPL.metaStateHasModifiers(event.getMetaState(), modifiers);
    }

    
    public static boolean hasNoModifiers(KeyEvent event) {
        return IMPL.metaStateHasNoModifiers(event.getMetaState());
    }

    
    static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.360 -0400", hash_original_method = "6346EE5F678CD82673E4481506E12189", hash_generated_method = "6346EE5F678CD82673E4481506E12189")
        public BaseKeyEventVersionImpl ()
        {
            
        }


        private static int metaStateFilterDirectionalModifiers(int metaState,
                int modifiers, int basic, int left, int right) {
            final boolean wantBasic = (modifiers & basic) != 0;
            final int directional = left | right;
            final boolean wantLeftOrRight = (modifiers & directional) != 0;
            if (wantBasic) {
                if (wantLeftOrRight) {
                    throw new IllegalArgumentException("bad arguments");
                }
                return metaState & ~directional;
            } else if (wantLeftOrRight) {
                return metaState & ~basic;
            } else {
                return metaState;
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.363 -0400", hash_original_method = "30C53A116B74264C0199431DE5B4E778", hash_generated_method = "6D2DE63E8DC546C090065FF980898B59")
        @Override
        public int normalizeMetaState(int metaState) {
            {
                metaState |= KeyEvent.META_SHIFT_ON;
            } 
            {
                metaState |= KeyEvent.META_ALT_ON;
            } 
            addTaint(metaState);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865334765 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865334765;
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.366 -0400", hash_original_method = "0CE5E00AA00E801EB34027CB09D6334C", hash_generated_method = "7CA7A19D0BA9C3125FB64BF7354AF3F9")
        @Override
        public boolean metaStateHasModifiers(int metaState, int modifiers) {
            metaState = normalizeMetaState(metaState) & META_MODIFIER_MASK;
            metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                    KeyEvent.META_SHIFT_ON, KeyEvent.META_SHIFT_LEFT_ON, KeyEvent.META_SHIFT_RIGHT_ON);
            metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                    KeyEvent.META_ALT_ON, KeyEvent.META_ALT_LEFT_ON, KeyEvent.META_ALT_RIGHT_ON);
            addTaint(metaState);
            addTaint(modifiers);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_658991198 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_658991198;
            
            
            
                    
            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.368 -0400", hash_original_method = "39D9C16C68B6F41FF034537B98CA7050", hash_generated_method = "F6BC86F94EC1FC4210037AE404B7F1A1")
        @Override
        public boolean metaStateHasNoModifiers(int metaState) {
            boolean varCFA9AD4B231DFEF23314B0282F3C1F99_608597637 = ((normalizeMetaState(metaState) & META_MODIFIER_MASK) == 0);
            addTaint(metaState);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984979809 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_984979809;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.368 -0400", hash_original_field = "BE8F3CCBA1B253A44AA4F0E975485B28", hash_generated_field = "913556817D5EFA7875193E6E3E72B16C")

        private static final int META_MODIFIER_MASK = KeyEvent.META_SHIFT_ON | KeyEvent.META_SHIFT_LEFT_ON | KeyEvent.META_SHIFT_RIGHT_ON
                | KeyEvent.META_ALT_ON | KeyEvent.META_ALT_LEFT_ON | KeyEvent.META_ALT_RIGHT_ON
                | KeyEvent.META_SYM_ON;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.369 -0400", hash_original_field = "3B72F7ABD24AF4206EC83B55B3F8178D", hash_generated_field = "AFCEC372F74E853379098AF8C7BB078B")

        private static final int META_ALL_MASK = META_MODIFIER_MASK;
    }


    
    static class HoneycombKeyEventVersionImpl implements KeyEventVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.370 -0400", hash_original_method = "C9F0128F3261973D5584669E422DE07F", hash_generated_method = "C9F0128F3261973D5584669E422DE07F")
        public HoneycombKeyEventVersionImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.371 -0400", hash_original_method = "2773B3FD163B459273C4B0CFE530AF81", hash_generated_method = "91972F8D7517DEC876EA0C2063808D16")
        @Override
        public int normalizeMetaState(int metaState) {
            int varE68E51AB6FA80F11C4A7CD55B59CE3B0_1281664186 = (KeyEventCompatHoneycomb.normalizeMetaState(metaState));
            addTaint(metaState);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940524852 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940524852;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.372 -0400", hash_original_method = "F8279AD984F6DC9126A16EB459D6633B", hash_generated_method = "7053F0E56DEE090F14D830E1CBC80A55")
        @Override
        public boolean metaStateHasModifiers(int metaState, int modifiers) {
            boolean var2A7077BF9A34F1613C395E8AFA449DA8_1565262169 = (KeyEventCompatHoneycomb.metaStateHasModifiers(metaState, modifiers));
            addTaint(metaState);
            addTaint(modifiers);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687671602 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687671602;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.374 -0400", hash_original_method = "98D19D2BC4AF3D8F42A3B8EFF1645FBD", hash_generated_method = "FEBC8F6881D7EA7829C60B748AD66785")
        @Override
        public boolean metaStateHasNoModifiers(int metaState) {
            boolean var27A1536B8D60F4287D9022F60B6CC173_628790470 = (KeyEventCompatHoneycomb.metaStateHasNoModifiers(metaState));
            addTaint(metaState);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313192537 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_313192537;
            
            
        }

        
    }


    
    interface KeyEventVersionImpl {
        public int normalizeMetaState(int metaState);
        public boolean metaStateHasModifiers(int metaState, int modifiers);
        public boolean metaStateHasNoModifiers(int metaState);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.375 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "8BC9A90D0CC72A26BB6A0C00C70BEEDE")

    static KeyEventVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombKeyEventVersionImpl();
        } else {
            IMPL = new BaseKeyEventVersionImpl();
        }
    }
    
}

