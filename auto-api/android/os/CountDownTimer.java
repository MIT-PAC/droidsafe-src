package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public abstract class CountDownTimer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.713 -0400", hash_original_field = "941F81AFBDD565B8984476C31B2330CD", hash_generated_field = "55875BD3E9D866BEA2C437122061CD6E")

    private long mMillisInFuture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.713 -0400", hash_original_field = "0106771DE534CE1807699A3CEEBB34B8", hash_generated_field = "680815491847B69D8671F5F72C72E2CE")

    private long mCountdownInterval;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.713 -0400", hash_original_field = "007FD2F712F3F4BB757AFA007EC35AB4", hash_generated_field = "6E03F58BFB699FC4A4C5B3CDD86B2F5D")

    private long mStopTimeInFuture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.715 -0400", hash_original_field = "5ACB42150E6910CF60F8ACA03F3FCF2B", hash_generated_field = "4722BE54C29DAC76CEA5B1E7D2A9C93C")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.715 -0400", hash_original_method = "7B84927A7A341E4B7E3F8DD42DA9B8B6", hash_generated_method = "28BC9036ED0575A91B9DB8A4EB60AF23")
        @Override
        public void handleMessage(Message msg) {
            {
                Object var551173F8929BB98D218065CC95BB0441_2068425722 = (CountDownTimer.this);
                {
                    long millisLeft;
                    millisLeft = mStopTimeInFuture - SystemClock.elapsedRealtime();
                    {
                        onFinish();
                    } //End block
                    {
                        sendMessageDelayed(obtainMessage(MSG), millisLeft);
                    } //End block
                    {
                        long lastTickStart;
                        lastTickStart = SystemClock.elapsedRealtime();
                        onTick(millisLeft);
                        long delay;
                        delay = lastTickStart + mCountdownInterval - SystemClock.elapsedRealtime();
                        delay += mCountdownInterval;
                        sendMessageDelayed(obtainMessage(MSG), delay);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.717 -0400", hash_original_method = "64AD26CC4F853CBE40630E575971F568", hash_generated_method = "69D450A186CD7505D58D8F8FE3948720")
    public  CountDownTimer(long millisInFuture, long countDownInterval) {
        mMillisInFuture = millisInFuture;
        mCountdownInterval = countDownInterval;
        // ---------- Original Method ----------
        //mMillisInFuture = millisInFuture;
        //mCountdownInterval = countDownInterval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.735 -0400", hash_original_method = "668A5D3225CBBDE8895EF9129976DF1D", hash_generated_method = "CA4F31EEB98095DD1785A84FC0B8E1C5")
    public final void cancel() {
        mHandler.removeMessages(MSG);
        // ---------- Original Method ----------
        //mHandler.removeMessages(MSG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.741 -0400", hash_original_method = "9B88C24B384B8F4F3D5DCE994477E303", hash_generated_method = "FB3BAF88A000DCEE9C489CCE7556AB35")
    public synchronized final CountDownTimer start() {
        CountDownTimer varB4EAC82CA7396A68D541C85D26508E83_1880975976 = null; //Variable for return #1
        CountDownTimer varB4EAC82CA7396A68D541C85D26508E83_1290416180 = null; //Variable for return #2
        {
            onFinish();
            varB4EAC82CA7396A68D541C85D26508E83_1880975976 = this;
        } //End block
        mStopTimeInFuture = SystemClock.elapsedRealtime() + mMillisInFuture;
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
        varB4EAC82CA7396A68D541C85D26508E83_1290416180 = this;
        CountDownTimer varA7E53CE21691AB073D9660D615818899_971463168; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_971463168 = varB4EAC82CA7396A68D541C85D26508E83_1880975976;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_971463168 = varB4EAC82CA7396A68D541C85D26508E83_1290416180;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_971463168.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_971463168;
        // ---------- Original Method ----------
        //if (mMillisInFuture <= 0) {
            //onFinish();
            //return this;
        //}
        //mStopTimeInFuture = SystemClock.elapsedRealtime() + mMillisInFuture;
        //mHandler.sendMessage(mHandler.obtainMessage(MSG));
        //return this;
    }

    
    public abstract void onTick(long millisUntilFinished);

    
    public abstract void onFinish();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.742 -0400", hash_original_field = "5892D4C854B350DEAD7AB30CDD2AB26D", hash_generated_field = "CF6EA1CA04CF303C210F22672AD552CB")

    private static int MSG = 1;
}

