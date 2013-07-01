package android.support.v4.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;

public class AccessibilityManagerCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.475 -0400", hash_original_method = "AC829248F02C50B724A8B55AAAADE1B7", hash_generated_method = "AC829248F02C50B724A8B55AAAADE1B7")
    public AccessibilityManagerCompat ()
    {
        //Synthesized constructor
    }


    public static boolean addAccessibilityStateChangeListener(AccessibilityManager manager,
            AccessibilityStateChangeListenerCompat listener) {
        return IMPL.addAccessibilityStateChangeListener(manager, listener);
    }

    
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager manager,
            AccessibilityStateChangeListenerCompat listener) {
        return IMPL.removeAccessibilityStateChangeListener(manager, listener);
    }

    
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(
            AccessibilityManager manager) {
        return IMPL.getInstalledAccessibilityServiceList(manager);
    }

    
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
            AccessibilityManager manager, int feedbackTypeFlags) {
        return IMPL.getEnabledAccessibilityServiceList(manager, feedbackTypeFlags);
    }

    
    public static boolean isTouchExplorationEnabled(AccessibilityManager manager) {
        return IMPL.isTouchExplorationEnabled(manager);
    }

    
    static class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.476 -0400", hash_original_method = "791165FA7321030127E802C0974A5551", hash_generated_method = "791165FA7321030127E802C0974A5551")
        public AccessibilityManagerStubImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.477 -0400", hash_original_method = "7D59B8882263E438CB4361275EA728A2", hash_generated_method = "4DEE1B92670BFB39B4262816636D3180")
        public Object newAccessiblityStateChangeListener(
                AccessibilityStateChangeListenerCompat listener) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1042257569 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1042257569 = null;
            addTaint(listener.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1042257569.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1042257569;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.479 -0400", hash_original_method = "33A1F684547BED5D3B48AAD04779CA50", hash_generated_method = "4B98B01348BEE9DA7C65572DC419623C")
        public boolean addAccessibilityStateChangeListener(AccessibilityManager manager,
                AccessibilityStateChangeListenerCompat listener) {
            addTaint(manager.getTaint());
            addTaint(listener.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_656064537 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_656064537;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.479 -0400", hash_original_method = "3EC1834EAD9521199DD8CC1AEEEE93EE", hash_generated_method = "501B28691BA9C5FFCCFB9BA7933DE0E9")
        public boolean removeAccessibilityStateChangeListener(AccessibilityManager manager,
                AccessibilityStateChangeListenerCompat listener) {
            addTaint(manager.getTaint());
            addTaint(listener.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_712909522 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_712909522;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.481 -0400", hash_original_method = "0B155E7439E18F95389B186D3A0B1547", hash_generated_method = "94A4E30112F40116B6C9A85C91403236")
        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
                AccessibilityManager manager, int feedbackTypeFlags) {
            List<AccessibilityServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_44844729 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_44844729 = Collections.emptyList();
            addTaint(manager.getTaint());
            addTaint(feedbackTypeFlags);
            varB4EAC82CA7396A68D541C85D26508E83_44844729.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_44844729;
            // ---------- Original Method ----------
            //return Collections.emptyList();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.482 -0400", hash_original_method = "1B9F4BA5149600AFD41B481B12F75C04", hash_generated_method = "D2BC79D79090CB24595CAFB59753A6D8")
        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(
                AccessibilityManager manager) {
            List<AccessibilityServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_1192411801 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1192411801 = Collections.emptyList();
            addTaint(manager.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1192411801.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1192411801;
            // ---------- Original Method ----------
            //return Collections.emptyList();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.482 -0400", hash_original_method = "D41A4A15681F6206C5A89225952F89E0", hash_generated_method = "36C0375A17AE13CF1E1CFD0149C1ADB5")
        public boolean isTouchExplorationEnabled(AccessibilityManager manager) {
            addTaint(manager.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_897288857 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_897288857;
            // ---------- Original Method ----------
            //return false;
        }

        
    }


    
    static class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.483 -0400", hash_original_method = "23F636143C406EB5E850140D3B3826C9", hash_generated_method = "23F636143C406EB5E850140D3B3826C9")
        public AccessibilityManagerIcsImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.484 -0400", hash_original_method = "9605D56F845E05772D756797E8C103EB", hash_generated_method = "8DDB1D622EC44DAD356687E360495AB4")
        @Override
        public Object newAccessiblityStateChangeListener(
                final AccessibilityStateChangeListenerCompat listener) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1225361307 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1225361307 = AccessibilityManagerCompatIcs.newAccessibilityStateChangeListener(
                new AccessibilityStateChangeListenerBridge() {
                    public void onAccessibilityStateChanged(boolean enabled) {
                        listener.onAccessibilityStateChanged(enabled);
                    }
                });
            addTaint(listener.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1225361307.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1225361307;
            // ---------- Original Method ----------
            //return AccessibilityManagerCompatIcs.newAccessibilityStateChangeListener(
                //new AccessibilityStateChangeListenerBridge() {
                    //public void onAccessibilityStateChanged(boolean enabled) {
                        //listener.onAccessibilityStateChanged(enabled);
                    //}
                //});
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.485 -0400", hash_original_method = "DDED9713E60FF2ACC487AE68FB5B1EF0", hash_generated_method = "9F0B7C5A7928738464CB1B05D41C1597")
        @Override
        public boolean addAccessibilityStateChangeListener(AccessibilityManager manager,
                AccessibilityStateChangeListenerCompat listener) {
            boolean var5D2C248FB4CFB4D54778BB6FBEA2A41F_1533941537 = (AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(manager,
                    listener.mListener));
            addTaint(manager.getTaint());
            addTaint(listener.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2032320523 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2032320523;
            // ---------- Original Method ----------
            //return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(manager,
                    //listener.mListener);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.486 -0400", hash_original_method = "7219CB250AC0A0DE22055706F7853760", hash_generated_method = "DBBE45A478C735C7AE8AF6A0E0FF4C97")
        @Override
        public boolean removeAccessibilityStateChangeListener(AccessibilityManager manager,
                final AccessibilityStateChangeListenerCompat listener) {
            boolean var5D71BD0C3ECC1C457C222AD7D40D5E51_143042582 = (AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(manager,
                    listener.mListener));
            addTaint(manager.getTaint());
            addTaint(listener.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510024640 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_510024640;
            // ---------- Original Method ----------
            //return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(manager,
                    //listener.mListener);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.487 -0400", hash_original_method = "45A7C83CCFEDDE0EAF6164AEE534859C", hash_generated_method = "2DDDF34BEEF76B2DCC05179D7B5E69B4")
        @Override
        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
                AccessibilityManager manager, int feedbackTypeFlags) {
            List<AccessibilityServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_552656669 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_552656669 = AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(manager,
                    feedbackTypeFlags);
            addTaint(manager.getTaint());
            addTaint(feedbackTypeFlags);
            varB4EAC82CA7396A68D541C85D26508E83_552656669.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_552656669;
            // ---------- Original Method ----------
            //return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(manager,
                    //feedbackTypeFlags);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.488 -0400", hash_original_method = "024643C1E057DD1DCC44ABD9C44E9BD0", hash_generated_method = "DB32AACDEECA305A183A22B1ED26E17E")
        @Override
        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(
                AccessibilityManager manager) {
            List<AccessibilityServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_846740342 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_846740342 = AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(manager);
            addTaint(manager.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_846740342.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_846740342;
            // ---------- Original Method ----------
            //return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(manager);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.489 -0400", hash_original_method = "BFE7EE6F020C3B9F8FFE4E032E4A4E03", hash_generated_method = "940E21142B7DB1A594E0E645922E3EC9")
        @Override
        public boolean isTouchExplorationEnabled(AccessibilityManager manager) {
            boolean var8F862A071D4556976F38B90E56EC6E08_1967513364 = (AccessibilityManagerCompatIcs.isTouchExplorationEnabled(manager));
            addTaint(manager.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438572114 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438572114;
            // ---------- Original Method ----------
            //return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(manager);
        }

        
        /*
        // orphaned legacy method
        public void onAccessibilityStateChanged(boolean enabled) {
                        listener.onAccessibilityStateChanged(enabled);
                    }
        
        */
    }


    
    public static abstract class AccessibilityStateChangeListenerCompat {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.490 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "6298872A0C122A375C2BF0CC5B8647C6")

        Object mListener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.490 -0400", hash_original_method = "FA0620266C265FA0D90FCFE5DA96B3B2", hash_generated_method = "741FF0BD831ABCAEAE97E46DD6866A08")
        public  AccessibilityStateChangeListenerCompat() {
            mListener = IMPL.newAccessiblityStateChangeListener(this);
            // ---------- Original Method ----------
            //mListener = IMPL.newAccessiblityStateChangeListener(this);
        }

        
        public abstract void onAccessibilityStateChanged(boolean enabled);

        
    }


    
    interface AccessibilityManagerVersionImpl {
        public Object newAccessiblityStateChangeListener(
                AccessibilityStateChangeListenerCompat listener);
        public boolean addAccessibilityStateChangeListener(AccessibilityManager manager,
                AccessibilityStateChangeListenerCompat listener);
        public boolean removeAccessibilityStateChangeListener(AccessibilityManager manager,
                AccessibilityStateChangeListenerCompat listener);
        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
                AccessibilityManager manager,int feedbackTypeFlags);
        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(
                AccessibilityManager manager);
        public boolean isTouchExplorationEnabled(AccessibilityManager manager);
    }
    
    static {
        if (Build.VERSION.SDK_INT >= 14) { 
            IMPL = new AccessibilityManagerIcsImpl();
        } else {
            IMPL = new AccessibilityManagerStubImpl();
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.491 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "11030A36D1F404B868FA2500FC50C900")

    private static AccessibilityManagerVersionImpl IMPL;
}

