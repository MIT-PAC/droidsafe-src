package android.support.v4.view;

// Droidsafe Imports
import android.view.KeyEvent;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class KeyEventCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.239 -0400", hash_original_method = "532007D9C650EDCB29F8F1C752472985", hash_generated_method = "532007D9C650EDCB29F8F1C752472985")
    public KeyEventCompat ()
    {
        //Synthesized constructor
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.241 -0400", hash_original_method = "6346EE5F678CD82673E4481506E12189", hash_generated_method = "6346EE5F678CD82673E4481506E12189")
        public BaseKeyEventVersionImpl ()
        {
            //Synthesized constructor
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.242 -0400", hash_original_method = "30C53A116B74264C0199431DE5B4E778", hash_generated_method = "CC3BDFA052A5C7AEEE28385F67083658")
        @Override
        public int normalizeMetaState(int metaState) {
            addTaint(metaState);
            if((metaState & (KeyEvent.META_SHIFT_LEFT_ON | KeyEvent.META_SHIFT_RIGHT_ON)) != 0)            
            {
                metaState |= KeyEvent.META_SHIFT_ON;
            } //End block
            if((metaState & (KeyEvent.META_ALT_LEFT_ON | KeyEvent.META_ALT_RIGHT_ON)) != 0)            
            {
                metaState |= KeyEvent.META_ALT_ON;
            } //End block
            int varF131E554CCF28EF881A6EA23A415DF20_1867494060 = (metaState & META_ALL_MASK);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326527195 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326527195;
            // ---------- Original Method ----------
            //if ((metaState & (KeyEvent.META_SHIFT_LEFT_ON | KeyEvent.META_SHIFT_RIGHT_ON)) != 0) {
                //metaState |= KeyEvent.META_SHIFT_ON;
            //}
            //if ((metaState & (KeyEvent.META_ALT_LEFT_ON | KeyEvent.META_ALT_RIGHT_ON)) != 0) {
                //metaState |= KeyEvent.META_ALT_ON;
            //}
            //return metaState & META_ALL_MASK;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.243 -0400", hash_original_method = "0CE5E00AA00E801EB34027CB09D6334C", hash_generated_method = "F69F76906622706185BDF0EAF85E77DB")
        @Override
        public boolean metaStateHasModifiers(int metaState, int modifiers) {
            addTaint(modifiers);
            addTaint(metaState);
            metaState = normalizeMetaState(metaState) & META_MODIFIER_MASK;
            metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                    KeyEvent.META_SHIFT_ON, KeyEvent.META_SHIFT_LEFT_ON, KeyEvent.META_SHIFT_RIGHT_ON);
            metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                    KeyEvent.META_ALT_ON, KeyEvent.META_ALT_LEFT_ON, KeyEvent.META_ALT_RIGHT_ON);
            boolean varCD773534CA1F36F227DA1CEA986BE996_878898713 = (metaState == modifiers);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949220326 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_949220326;
            // ---------- Original Method ----------
            //metaState = normalizeMetaState(metaState) & META_MODIFIER_MASK;
            //metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                    //KeyEvent.META_SHIFT_ON, KeyEvent.META_SHIFT_LEFT_ON, KeyEvent.META_SHIFT_RIGHT_ON);
            //metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                    //KeyEvent.META_ALT_ON, KeyEvent.META_ALT_LEFT_ON, KeyEvent.META_ALT_RIGHT_ON);
            //return metaState == modifiers;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.244 -0400", hash_original_method = "39D9C16C68B6F41FF034537B98CA7050", hash_generated_method = "139A93C590E561D532950562094ECB3D")
        @Override
        public boolean metaStateHasNoModifiers(int metaState) {
            addTaint(metaState);
            boolean var600430DD8972DEA8208090E063259253_405827005 = ((normalizeMetaState(metaState) & META_MODIFIER_MASK) == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2010527306 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2010527306;
            // ---------- Original Method ----------
            //return (normalizeMetaState(metaState) & META_MODIFIER_MASK) == 0;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.244 -0400", hash_original_field = "BE8F3CCBA1B253A44AA4F0E975485B28", hash_generated_field = "913556817D5EFA7875193E6E3E72B16C")

        private static final int META_MODIFIER_MASK = KeyEvent.META_SHIFT_ON | KeyEvent.META_SHIFT_LEFT_ON | KeyEvent.META_SHIFT_RIGHT_ON
                | KeyEvent.META_ALT_ON | KeyEvent.META_ALT_LEFT_ON | KeyEvent.META_ALT_RIGHT_ON
                | KeyEvent.META_SYM_ON;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.244 -0400", hash_original_field = "3B72F7ABD24AF4206EC83B55B3F8178D", hash_generated_field = "AFCEC372F74E853379098AF8C7BB078B")

        private static final int META_ALL_MASK = META_MODIFIER_MASK;
    }


    
    static class HoneycombKeyEventVersionImpl implements KeyEventVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.244 -0400", hash_original_method = "C9F0128F3261973D5584669E422DE07F", hash_generated_method = "C9F0128F3261973D5584669E422DE07F")
        public HoneycombKeyEventVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.244 -0400", hash_original_method = "2773B3FD163B459273C4B0CFE530AF81", hash_generated_method = "170A9391CBA532B99009E5F47B097DF1")
        @Override
        public int normalizeMetaState(int metaState) {
            addTaint(metaState);
            int var99D2B3D9E8AC7FD8B0600C8F657F3E74_1631583396 = (KeyEventCompatHoneycomb.normalizeMetaState(metaState));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351838709 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351838709;
            // ---------- Original Method ----------
            //return KeyEventCompatHoneycomb.normalizeMetaState(metaState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.245 -0400", hash_original_method = "F8279AD984F6DC9126A16EB459D6633B", hash_generated_method = "C84D9154602100EA487884852FFD3D71")
        @Override
        public boolean metaStateHasModifiers(int metaState, int modifiers) {
            addTaint(modifiers);
            addTaint(metaState);
            boolean varC060CA608D194BFD7BCEA744C6EB1BF3_857363023 = (KeyEventCompatHoneycomb.metaStateHasModifiers(metaState, modifiers));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400941729 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400941729;
            // ---------- Original Method ----------
            //return KeyEventCompatHoneycomb.metaStateHasModifiers(metaState, modifiers);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.245 -0400", hash_original_method = "98D19D2BC4AF3D8F42A3B8EFF1645FBD", hash_generated_method = "72A9873F59F8D58027EADF50EEB7D792")
        @Override
        public boolean metaStateHasNoModifiers(int metaState) {
            addTaint(metaState);
            boolean varC84BF0FD6DAF8F4BBB4B3AE6A5E3787F_1518390836 = (KeyEventCompatHoneycomb.metaStateHasNoModifiers(metaState));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_245481951 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_245481951;
            // ---------- Original Method ----------
            //return KeyEventCompatHoneycomb.metaStateHasNoModifiers(metaState);
        }

        
    }


    
    interface KeyEventVersionImpl {
        public int normalizeMetaState(int metaState);
        public boolean metaStateHasModifiers(int metaState, int modifiers);
        public boolean metaStateHasNoModifiers(int metaState);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.245 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "8BC9A90D0CC72A26BB6A0C00C70BEEDE")

    static KeyEventVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombKeyEventVersionImpl();
        } else {
            IMPL = new BaseKeyEventVersionImpl();
        }
    }
    
}

