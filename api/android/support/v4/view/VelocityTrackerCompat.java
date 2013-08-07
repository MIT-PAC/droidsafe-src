package android.support.v4.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.view.VelocityTracker;



public class VelocityTrackerCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.332 -0400", hash_original_method = "ACE59A9EBE302FC1E1A244DA6E2DCF51", hash_generated_method = "ACE59A9EBE302FC1E1A244DA6E2DCF51")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.333 -0400", hash_original_method = "E207FC5896FAF2D7F355008464495FF2", hash_generated_method = "E207FC5896FAF2D7F355008464495FF2")
        public BaseVelocityTrackerVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.333 -0400", hash_original_method = "C711DFF45899DB50837A3534EA18E563", hash_generated_method = "D84371AE71EEDCE74BC2E0AB6EBB3BA3")
        @Override
        public float getXVelocity(VelocityTracker tracker, int pointerId) {
            addTaint(pointerId);
            addTaint(tracker.getTaint());
            float var9699F73440CCB9361B8AAB0F4F40909C_1498757539 = (tracker.getXVelocity());
                        float var546ADE640B6EDFBC8A086EF31347E768_1784167266 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1784167266;
            // ---------- Original Method ----------
            //return tracker.getXVelocity();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.334 -0400", hash_original_method = "C1E75A29A2B04E744E6358D9ECEF4179", hash_generated_method = "3288961814A63B8A839021ACB8411FF7")
        @Override
        public float getYVelocity(VelocityTracker tracker, int pointerId) {
            addTaint(pointerId);
            addTaint(tracker.getTaint());
            float varC22E90EF29902DFF397E1759E730A063_1708834646 = (tracker.getYVelocity());
                        float var546ADE640B6EDFBC8A086EF31347E768_621283260 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_621283260;
            // ---------- Original Method ----------
            //return tracker.getYVelocity();
        }

        
    }


    
    static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.334 -0400", hash_original_method = "C45D4DE867C130E838448AE2BF37BBAC", hash_generated_method = "C45D4DE867C130E838448AE2BF37BBAC")
        public HoneycombVelocityTrackerVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.334 -0400", hash_original_method = "E2537AF0FA564D885F2AE573A5D655DB", hash_generated_method = "1954BEADD348B6303A8AD345FAF489AF")
        @Override
        public float getXVelocity(VelocityTracker tracker, int pointerId) {
            addTaint(pointerId);
            addTaint(tracker.getTaint());
            float var85F1E6B3092F53154330E40357C4E4FF_1468419260 = (VelocityTrackerCompatHoneycomb.getXVelocity(tracker, pointerId));
                        float var546ADE640B6EDFBC8A086EF31347E768_1988780115 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1988780115;
            // ---------- Original Method ----------
            //return VelocityTrackerCompatHoneycomb.getXVelocity(tracker, pointerId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.335 -0400", hash_original_method = "D5A70EB91EAA38C3613B20D88EAA6FB3", hash_generated_method = "15E15F782678193D8DFA0AA547A64F6A")
        @Override
        public float getYVelocity(VelocityTracker tracker, int pointerId) {
            addTaint(pointerId);
            addTaint(tracker.getTaint());
            float varEF91F87F26500E40D8C0DCC45FDA58F7_427136248 = (VelocityTrackerCompatHoneycomb.getYVelocity(tracker, pointerId));
                        float var546ADE640B6EDFBC8A086EF31347E768_1911821402 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1911821402;
            // ---------- Original Method ----------
            //return VelocityTrackerCompatHoneycomb.getYVelocity(tracker, pointerId);
        }

        
    }


    
    interface VelocityTrackerVersionImpl {
        public float getXVelocity(VelocityTracker tracker, int pointerId);
        public float getYVelocity(VelocityTracker tracker, int pointerId);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.335 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "0A84FDB029BDF78AE211B91A0B9EF3AB")

    static VelocityTrackerVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombVelocityTrackerVersionImpl();
        } else {
            IMPL = new BaseVelocityTrackerVersionImpl();
        }
    }
    
}

