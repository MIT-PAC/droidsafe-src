package android.test;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

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
