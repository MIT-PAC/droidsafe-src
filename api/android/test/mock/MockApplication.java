package android.test.mock;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Application;
import android.content.res.Configuration;

public class MockApplication extends Application {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.971 -0500", hash_original_method = "1B19C6453B2D07E5BCC8816EA82B0228", hash_generated_method = "15C3A0A61B7C0F3007C3F2D0670A6F02")
    
public MockApplication() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.973 -0500", hash_original_method = "AB55BCFD90D9CF641566BDB5BAD65AFF", hash_generated_method = "D7E69C6D9C3495D5EF31B1477698DA4C")
    
@Override
    public void onCreate() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.976 -0500", hash_original_method = "9991613DFAC855235B415C4774CC80EA", hash_generated_method = "16F7ED9664099BE606754E50B16E01CC")
    
@Override
    public void onTerminate() {
        throw new UnsupportedOperationException();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.978 -0500", hash_original_method = "7E56559F8B4EC145CBEC91305D6CF8F3", hash_generated_method = "A98CE60F4C41025303976C5973E48F2E")
    
@Override
    public void onConfigurationChanged(Configuration newConfig) {
        throw new UnsupportedOperationException();
    }
    
}

