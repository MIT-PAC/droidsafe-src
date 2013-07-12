package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;

@Deprecated public interface TestCase extends Runnable
{
    
    public void setUp(Context context);

    
    public void tearDown();
}
