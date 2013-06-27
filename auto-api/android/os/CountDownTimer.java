package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public abstract class CountDownTimer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.135 -0400", hash_original_field = "941F81AFBDD565B8984476C31B2330CD", hash_generated_field = "55875BD3E9D866BEA2C437122061CD6E")

    private long mMillisInFuture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.136 -0400", hash_original_field = "0106771DE534CE1807699A3CEEBB34B8", hash_generated_field = "680815491847B69D8671F5F72C72E2CE")

    private long mCountdownInterval;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.136 -0400", hash_original_field = "007FD2F712F3F4BB757AFA007EC35AB4", hash_generated_field = "6E03F58BFB699FC4A4C5B3CDD86B2F5D")

    private long mStopTimeInFuture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.139 -0400", hash_original_field = "5ACB42150E6910CF60F8ACA03F3FCF2B", hash_generated_field = "B1880DA4CBBE26DC72AA1FAADF633ED5")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.138 -0400", hash_original_method = "7B84927A7A341E4B7E3F8DD42DA9B8B6", hash_generated_method = "1E6F24D916799ED433CF8E97B6A27D68")
        @Override
        public void handleMessage(Message msg) {
            {
                Object var551173F8929BB98D218065CC95BB0441_1823143022 = (CountDownTimer.this);
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.140 -0400", hash_original_method = "64AD26CC4F853CBE40630E575971F568", hash_generated_method = "69D450A186CD7505D58D8F8FE3948720")
    public  CountDownTimer(long millisInFuture, long countDownInterval) {
        mMillisInFuture = millisInFuture;
        mCountdownInterval = countDownInterval;
        // ---------- Original Method ----------
        //mMillisInFuture = millisInFuture;
        //mCountdownInterval = countDownInterval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.141 -0400", hash_original_method = "668A5D3225CBBDE8895EF9129976DF1D", hash_generated_method = "CA4F31EEB98095DD1785A84FC0B8E1C5")
    public final void cancel() {
        mHandler.removeMessages(MSG);
        // ---------- Original Method ----------
        //mHandler.removeMessages(MSG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.232 -0400", hash_original_method = "9B88C24B384B8F4F3D5DCE994477E303", hash_generated_method = "B54AF0D12C203E9E9DB13FB6FEFC80C2")
    public synchronized final CountDownTimer start() {
        CountDownTimer varB4EAC82CA7396A68D541C85D26508E83_808703706 = null; //Variable for return #1
        CountDownTimer varB4EAC82CA7396A68D541C85D26508E83_549385710 = null; //Variable for return #2
        {
            onFinish();
            varB4EAC82CA7396A68D541C85D26508E83_808703706 = this;
        } //End block
        mStopTimeInFuture = SystemClock.elapsedRealtime() + mMillisInFuture;
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
        varB4EAC82CA7396A68D541C85D26508E83_549385710 = this;
        CountDownTimer varA7E53CE21691AB073D9660D615818899_1109727883; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1109727883 = varB4EAC82CA7396A68D541C85D26508E83_808703706;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1109727883 = varB4EAC82CA7396A68D541C85D26508E83_549385710;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1109727883.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1109727883;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.233 -0400", hash_original_field = "5892D4C854B350DEAD7AB30CDD2AB26D", hash_generated_field = "CF6EA1CA04CF303C210F22672AD552CB")

    private static int MSG = 1;
}

