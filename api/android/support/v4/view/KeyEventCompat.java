package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.KeyEvent;

public class KeyEventCompat {

    // -------------------------------------------------------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.913 -0500", hash_original_method = "E8349ABDADBC992226D468F337E5445D", hash_generated_method = "07A97D7ACE856A0375E03E292BAD6C95")
    
public static int normalizeMetaState(int metaState) {
        return IMPL.normalizeMetaState(metaState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.916 -0500", hash_original_method = "3CE05E6B558DBB2C1B3F782D7F65E5E2", hash_generated_method = "6DE8B6A725AAE8B0CDE486BD8E835660")
    
public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        return IMPL.metaStateHasModifiers(metaState, modifiers);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.918 -0500", hash_original_method = "7D14DDC1AD0050C76B07AC3FF657CFA1", hash_generated_method = "428EFD88539E07C6072424F2B4344E2A")
    
public static boolean metaStateHasNoModifiers(int metaState) {
        return IMPL.metaStateHasNoModifiers(metaState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.920 -0500", hash_original_method = "3459CD70A7471F910F70EFC30C291EC4", hash_generated_method = "E98B8C680069F3DBBF1CE6913C768C7D")
    
public static boolean hasModifiers(KeyEvent event, int modifiers) {
        return IMPL.metaStateHasModifiers(event.getMetaState(), modifiers);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.923 -0500", hash_original_method = "53CEAEB414B0F10FB842AFA317D8BBA2", hash_generated_method = "AEF3647D1E5748BCE037970C04A9E6AB")
    
public static boolean hasNoModifiers(KeyEvent event) {
        return IMPL.metaStateHasNoModifiers(event.getMetaState());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.911 -0500", hash_original_field = "49ED0D05159F507ACCC32A40A6511184", hash_generated_field = "8BC9A90D0CC72A26BB6A0C00C70BEEDE")

    static  KeyEventVersionImpl IMPL;
    
    static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.889 -0500", hash_original_method = "52D694C249868DCBEBE202496FB48D64", hash_generated_method = "82C9F02639134520E1D0026D80D88D31")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.883 -0500", hash_original_field = "28053FDB3D5A5299AE9DE128F4660DA0", hash_generated_field = "913556817D5EFA7875193E6E3E72B16C")

        private static final int META_MODIFIER_MASK =
                KeyEvent.META_SHIFT_ON | KeyEvent.META_SHIFT_LEFT_ON | KeyEvent.META_SHIFT_RIGHT_ON
                | KeyEvent.META_ALT_ON | KeyEvent.META_ALT_LEFT_ON | KeyEvent.META_ALT_RIGHT_ON
                | KeyEvent.META_SYM_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.886 -0500", hash_original_field = "8A034C3BEBD6C19FFBF6B1D551C83DA9", hash_generated_field = "AFCEC372F74E853379098AF8C7BB078B")

        private static final int META_ALL_MASK = META_MODIFIER_MASK;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.241 -0400", hash_original_method = "6346EE5F678CD82673E4481506E12189", hash_generated_method = "6346EE5F678CD82673E4481506E12189")
        public BaseKeyEventVersionImpl ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.891 -0500", hash_original_method = "30C53A116B74264C0199431DE5B4E778", hash_generated_method = "0F36BE944BB9D2D63E07F3243488C5C5")
        
@Override
        public int normalizeMetaState(int metaState) {
            if ((metaState & (KeyEvent.META_SHIFT_LEFT_ON | KeyEvent.META_SHIFT_RIGHT_ON)) != 0) {
                metaState |= KeyEvent.META_SHIFT_ON;
            }
            if ((metaState & (KeyEvent.META_ALT_LEFT_ON | KeyEvent.META_ALT_RIGHT_ON)) != 0) {
                metaState |= KeyEvent.META_ALT_ON;
            }
            return metaState & META_ALL_MASK;
        }
 
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.894 -0500", hash_original_method = "0CE5E00AA00E801EB34027CB09D6334C", hash_generated_method = "775F5F2329E47C4CC3BB24323E2D7E56")
        
@Override
        public boolean metaStateHasModifiers(int metaState, int modifiers) {
            metaState = normalizeMetaState(metaState) & META_MODIFIER_MASK;
            metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                    KeyEvent.META_SHIFT_ON, KeyEvent.META_SHIFT_LEFT_ON, KeyEvent.META_SHIFT_RIGHT_ON);
            metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                    KeyEvent.META_ALT_ON, KeyEvent.META_ALT_LEFT_ON, KeyEvent.META_ALT_RIGHT_ON);
            return metaState == modifiers;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.897 -0500", hash_original_method = "39D9C16C68B6F41FF034537B98CA7050", hash_generated_method = "ADBA0A04887DF3F54C3EB39BC011386D")
        
@Override
        public boolean metaStateHasNoModifiers(int metaState) {
            return (normalizeMetaState(metaState) & META_MODIFIER_MASK) == 0;
        }
    }
    
    static class HoneycombKeyEventVersionImpl implements KeyEventVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.244 -0400", hash_original_method = "C9F0128F3261973D5584669E422DE07F", hash_generated_method = "C9F0128F3261973D5584669E422DE07F")
        public HoneycombKeyEventVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.902 -0500", hash_original_method = "2773B3FD163B459273C4B0CFE530AF81", hash_generated_method = "34E7478864BFE85D32552E134BB9AACA")
        
@Override
        public int normalizeMetaState(int metaState) {
            return KeyEventCompatHoneycomb.normalizeMetaState(metaState);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.904 -0500", hash_original_method = "F8279AD984F6DC9126A16EB459D6633B", hash_generated_method = "2875E8A60FE37AE27ED6E431C8871195")
        
@Override
        public boolean metaStateHasModifiers(int metaState, int modifiers) {
            return KeyEventCompatHoneycomb.metaStateHasModifiers(metaState, modifiers);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.906 -0500", hash_original_method = "98D19D2BC4AF3D8F42A3B8EFF1645FBD", hash_generated_method = "871DDEA1B8287B31F3C28DF693DD1C68")
        
@Override
        public boolean metaStateHasNoModifiers(int metaState) {
            return KeyEventCompatHoneycomb.metaStateHasNoModifiers(metaState);
        }
        
    }
    
    interface KeyEventVersionImpl {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int normalizeMetaState(int metaState);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean metaStateHasModifiers(int metaState, int modifiers);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean metaStateHasNoModifiers(int metaState);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.239 -0400", hash_original_method = "532007D9C650EDCB29F8F1C752472985", hash_generated_method = "532007D9C650EDCB29F8F1C752472985")
    public KeyEventCompat ()
    {
        //Synthesized constructor
    }
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombKeyEventVersionImpl();
        } else {
            IMPL = new BaseKeyEventVersionImpl();
        }
    }
    
}

