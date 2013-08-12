package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;





public abstract class CountDownTimer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.916 -0400", hash_original_field = "941F81AFBDD565B8984476C31B2330CD", hash_generated_field = "55875BD3E9D866BEA2C437122061CD6E")

    private long mMillisInFuture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.916 -0400", hash_original_field = "0106771DE534CE1807699A3CEEBB34B8", hash_generated_field = "680815491847B69D8671F5F72C72E2CE")

    private long mCountdownInterval;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.916 -0400", hash_original_field = "007FD2F712F3F4BB757AFA007EC35AB4", hash_generated_field = "6E03F58BFB699FC4A4C5B3CDD86B2F5D")

    private long mStopTimeInFuture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.068 -0400", hash_original_field = "5ACB42150E6910CF60F8ACA03F3FCF2B", hash_generated_field = "42F1EE03623FE9A5876F5AA26D4DF01A")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.068 -0400", hash_original_method = "7B84927A7A341E4B7E3F8DD42DA9B8B6", hash_generated_method = "0C36A2A611F570EA11A2EE877F8B441B")
        @Override
        public void handleMessage(Message msg) {
            {
                Object var551173F8929BB98D218065CC95BB0441_260042709 = (CountDownTimer.this);
                {
                    final long millisLeft = mStopTimeInFuture - SystemClock.elapsedRealtime();
                    {
                        onFinish();
                    } 
                    {
                        sendMessageDelayed(obtainMessage(MSG), millisLeft);
                    } 
                    {
                        long lastTickStart = SystemClock.elapsedRealtime();
                        onTick(millisLeft);
                        long delay = lastTickStart + mCountdownInterval - SystemClock.elapsedRealtime();
                        delay += mCountdownInterval;
                        sendMessageDelayed(obtainMessage(MSG), delay);
                    } 
                } 
            } 
            addTaint(msg.getTaint());
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.917 -0400", hash_original_method = "64AD26CC4F853CBE40630E575971F568", hash_generated_method = "69D450A186CD7505D58D8F8FE3948720")
    public  CountDownTimer(long millisInFuture, long countDownInterval) {
        mMillisInFuture = millisInFuture;
        mCountdownInterval = countDownInterval;
        // ---------- Original Method ----------
        //mMillisInFuture = millisInFuture;
        //mCountdownInterval = countDownInterval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.918 -0400", hash_original_method = "668A5D3225CBBDE8895EF9129976DF1D", hash_generated_method = "CA4F31EEB98095DD1785A84FC0B8E1C5")
    public final void cancel() {
        mHandler.removeMessages(MSG);
        // ---------- Original Method ----------
        //mHandler.removeMessages(MSG);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.920 -0400", hash_original_method = "9B88C24B384B8F4F3D5DCE994477E303", hash_generated_method = "EE2ABFCEDB6C12F5844A3A67A7DE5470")
    public synchronized final CountDownTimer start() {
        if(mMillisInFuture <= 0)        
        {
            onFinish();
CountDownTimer var72A74007B2BE62B849F475C7BDA4658B_19997730 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_19997730.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_19997730;
        } //End block
        mStopTimeInFuture = SystemClock.elapsedRealtime() + mMillisInFuture;
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
CountDownTimer var72A74007B2BE62B849F475C7BDA4658B_1444867935 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1444867935.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1444867935;
        // ---------- Original Method ----------
        //if (mMillisInFuture <= 0) {
            //onFinish();
            //return this;
        //}
        //mStopTimeInFuture = SystemClock.elapsedRealtime() + mMillisInFuture;
        //mHandler.sendMessage(mHandler.obtainMessage(MSG));
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void onTick(long millisUntilFinished);

    
    @DSModeled(DSC.SAFE)
    public abstract void onFinish();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.921 -0400", hash_original_field = "5892D4C854B350DEAD7AB30CDD2AB26D", hash_generated_field = "33207288B866F3DDE85211D1B4FA47BB")

    private static final int MSG = 1;
}

