package android.test;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.PerformanceCollector;
import android.os.PerformanceCollector.PerformanceResultsWriter;

public interface PerformanceCollectorTestCase {
    public PerformanceCollector mPerfCollector = new PerformanceCollector();

    public void setPerformanceResultsWriter(PerformanceResultsWriter writer);
}
