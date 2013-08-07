package android.test.mock;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.app.Application;
import android.content.res.Configuration;


public class MockApplication extends Application {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.054 -0400", hash_original_method = "1B19C6453B2D07E5BCC8816EA82B0228", hash_generated_method = "FFE941A3C9F3A64BF791EC2AFB439F21")
    public  MockApplication() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.055 -0400", hash_original_method = "AB55BCFD90D9CF641566BDB5BAD65AFF", hash_generated_method = "89D535F36644052A64306CEC7C49617F")
    @Override
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_130511122 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_130511122.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_130511122;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.055 -0400", hash_original_method = "9991613DFAC855235B415C4774CC80EA", hash_generated_method = "F966D1AD11CA0FE0A0C72058DB17500F")
    @Override
    public void onTerminate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_312213223 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_312213223.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_312213223;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.055 -0400", hash_original_method = "7E56559F8B4EC145CBEC91305D6CF8F3", hash_generated_method = "BF7EFFDC61C761235A2CDEC926F4E7BC")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1862066878 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1862066878.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1862066878;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

