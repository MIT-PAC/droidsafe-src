package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.VelocityTracker;

public class VelocityTrackerCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.031 -0400", hash_original_method = "ACE59A9EBE302FC1E1A244DA6E2DCF51", hash_generated_method = "ACE59A9EBE302FC1E1A244DA6E2DCF51")
    public VelocityTrackerCompat ()
    {
        //Synthesized constructor
    }


    public static float getXVelocity(VelocityTracker tracker, int pointerId) {
        return IMPL.getXVelocity(tracker, pointerId);
    }

    
    public static float getYVelocity(VelocityTracker tracker, int pointerId) {
        return IMPL.getYVelocity(tracker, pointerId);
    }

    
    static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.032 -0400", hash_original_method = "E207FC5896FAF2D7F355008464495FF2", hash_generated_method = "E207FC5896FAF2D7F355008464495FF2")
        public BaseVelocityTrackerVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.034 -0400", hash_original_method = "C711DFF45899DB50837A3534EA18E563", hash_generated_method = "E80384C68FFFDC624BF69EFB25CDD659")
        @Override
        public float getXVelocity(VelocityTracker tracker, int pointerId) {
            float var299E48371677224CC2A1B692B9F8CDCC_1404254624 = (tracker.getXVelocity());
            addTaint(tracker.getTaint());
            addTaint(pointerId);
            float var546ADE640B6EDFBC8A086EF31347E768_1227700224 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1227700224;
            // ---------- Original Method ----------
            //return tracker.getXVelocity();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.036 -0400", hash_original_method = "C1E75A29A2B04E744E6358D9ECEF4179", hash_generated_method = "1F7082DD5C9105BD70CCAE30A71E3B55")
        @Override
        public float getYVelocity(VelocityTracker tracker, int pointerId) {
            float varBC4B4876EED1C57DB45F43DA5BD65388_285600400 = (tracker.getYVelocity());
            addTaint(tracker.getTaint());
            addTaint(pointerId);
            float var546ADE640B6EDFBC8A086EF31347E768_1695174357 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1695174357;
            // ---------- Original Method ----------
            //return tracker.getYVelocity();
        }

        
    }


    
    static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.036 -0400", hash_original_method = "C45D4DE867C130E838448AE2BF37BBAC", hash_generated_method = "C45D4DE867C130E838448AE2BF37BBAC")
        public HoneycombVelocityTrackerVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.037 -0400", hash_original_method = "E2537AF0FA564D885F2AE573A5D655DB", hash_generated_method = "C02B78B9A011C05A74112DCF81A492FD")
        @Override
        public float getXVelocity(VelocityTracker tracker, int pointerId) {
            float varE5197E3C0701D136FA9872452844F048_228180509 = (VelocityTrackerCompatHoneycomb.getXVelocity(tracker, pointerId));
            addTaint(tracker.getTaint());
            addTaint(pointerId);
            float var546ADE640B6EDFBC8A086EF31347E768_474249069 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_474249069;
            // ---------- Original Method ----------
            //return VelocityTrackerCompatHoneycomb.getXVelocity(tracker, pointerId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.039 -0400", hash_original_method = "D5A70EB91EAA38C3613B20D88EAA6FB3", hash_generated_method = "0A6CA155F821F4A69425FC75F5CF7633")
        @Override
        public float getYVelocity(VelocityTracker tracker, int pointerId) {
            float var32A9886BA2A408A3623BE9E5F06F755F_1726040639 = (VelocityTrackerCompatHoneycomb.getYVelocity(tracker, pointerId));
            addTaint(tracker.getTaint());
            addTaint(pointerId);
            float var546ADE640B6EDFBC8A086EF31347E768_1506337204 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1506337204;
            // ---------- Original Method ----------
            //return VelocityTrackerCompatHoneycomb.getYVelocity(tracker, pointerId);
        }

        
    }


    
    interface VelocityTrackerVersionImpl {
        public float getXVelocity(VelocityTracker tracker, int pointerId);
        public float getYVelocity(VelocityTracker tracker, int pointerId);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.039 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "0A84FDB029BDF78AE211B91A0B9EF3AB")

    static VelocityTrackerVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombVelocityTrackerVersionImpl();
        } else {
            IMPL = new BaseVelocityTrackerVersionImpl();
        }
    }
    
}

