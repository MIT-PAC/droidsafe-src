package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface PerformanceTestCase
{
    
    public interface Intermediates
    {
        void setInternalIterations(int count);
        void startTiming(boolean realTime);
        void addIntermediate(String name);
        void addIntermediate(String name, long timeInNS);
        void finishTiming(boolean realTime);
    }

    
    int startPerformance(Intermediates intermediates);
    
    
    boolean isPerformanceOnly();
}
