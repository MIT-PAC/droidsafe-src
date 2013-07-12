package android.test.mock;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Application;
import android.content.res.Configuration;

public class MockApplication extends Application {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.375 -0400", hash_original_method = "1B19C6453B2D07E5BCC8816EA82B0228", hash_generated_method = "FFE941A3C9F3A64BF791EC2AFB439F21")
    public  MockApplication() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.375 -0400", hash_original_method = "AB55BCFD90D9CF641566BDB5BAD65AFF", hash_generated_method = "8268DB9C4A4FC6BB8F74DAAD3871A8ED")
    @Override
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_122300628 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_122300628.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_122300628;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.375 -0400", hash_original_method = "9991613DFAC855235B415C4774CC80EA", hash_generated_method = "21731979FB91ECA4C5920D1443044E92")
    @Override
    public void onTerminate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1505230357 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1505230357.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1505230357;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.376 -0400", hash_original_method = "7E56559F8B4EC145CBEC91305D6CF8F3", hash_generated_method = "01E3D67DB6C1F43FC595EC557B1EF0DA")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_501668901 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_501668901.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_501668901;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

