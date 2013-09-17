package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;





public class HandlerThread extends Thread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.213 -0400", hash_original_field = "22FC7A378B4F7C5F90F70A47BE1E4FCD", hash_generated_field = "1D8CA7654CC48BAF402334392A1619BF")

    int mPriority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.213 -0400", hash_original_field = "786D3949F65E83EBF0570337C6D9716A", hash_generated_field = "443BB6C8F0508752717F617F7353B13A")

    int mTid = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.213 -0400", hash_original_field = "DA288C1345E9C94467C02060ED19C6FA", hash_generated_field = "4C6A73D1D5351706C43659B423CF9288")

    Looper mLooper;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.213 -0400", hash_original_method = "E5F101A858C2AB40D5C2E9617BFE5E37", hash_generated_method = "FCB270CCF80D7A39E5F41F9293FDE504")
    public  HandlerThread(String name) {
        super(name);
        addTaint(name.getTaint());
        mPriority = Process.THREAD_PRIORITY_DEFAULT;
        // ---------- Original Method ----------
        //mPriority = Process.THREAD_PRIORITY_DEFAULT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.214 -0400", hash_original_method = "E70E3F12F9547EDCFC1C795A424416CD", hash_generated_method = "A0A04D764B43C8282C78CE35882E9EB6")
    public  HandlerThread(String name, int priority) {
        super(name);
        addTaint(name.getTaint());
        mPriority = priority;
        // ---------- Original Method ----------
        //mPriority = priority;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.215 -0400", hash_original_method = "7869505C1EE96F329E4F7F0EA5AF9C5D", hash_generated_method = "FB28300AB029F1A68D6A159EC4AF6459")
    protected void onLooperPrepared() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.216 -0400", hash_original_method = "9E0B8BC0299FD7F24B369B7431C1A009", hash_generated_method = "0B5CC3F60971D75F6E00E5C05E9341C9")
    public void run() {
        mTid = Process.myTid();
        Looper.prepare();
        synchronized
(this)        {
            mLooper = Looper.myLooper();
            notifyAll();
        } //End block
        Process.setThreadPriority(mPriority);
        onLooperPrepared();
        Looper.loop();
        mTid = -1;
        // ---------- Original Method ----------
        //mTid = Process.myTid();
        //Looper.prepare();
        //synchronized (this) {
            //mLooper = Looper.myLooper();
            //notifyAll();
        //}
        //Process.setThreadPriority(mPriority);
        //onLooperPrepared();
        //Looper.loop();
        //mTid = -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.216 -0400", hash_original_method = "0FC13809696BA2D6DC441C842770D0F1", hash_generated_method = "E2EDF91F5386DA87DFFE501F94670950")
    public Looper getLooper() {
        if(!isAlive())        
        {
Looper var540C13E9E156B687226421B24F2DF178_1381021412 =             null;
            var540C13E9E156B687226421B24F2DF178_1381021412.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1381021412;
        } //End block
        synchronized
(this)        {
            while
(isAlive() && mLooper == null)            
            {
                try 
                {
                    wait();
                } //End block
                catch (InterruptedException e)
                {
                } //End block
            } //End block
        } //End block
Looper var0D78717954912E9F181D5C0583378DCC_1702024292 =         mLooper;
        var0D78717954912E9F181D5C0583378DCC_1702024292.addTaint(taint);
        return var0D78717954912E9F181D5C0583378DCC_1702024292;
        // ---------- Original Method ----------
        //if (!isAlive()) {
            //return null;
        //}
        //synchronized (this) {
            //while (isAlive() && mLooper == null) {
                //try {
                    //wait();
                //} catch (InterruptedException e) {
                //}
            //}
        //}
        //return mLooper;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.217 -0400", hash_original_method = "45988F35C3EAC3EE4988825F5EC29D45", hash_generated_method = "059AE2F792F478B6B34F7E1EC30BAB94")
    public boolean quit() {
        Looper looper = getLooper();
        if(looper != null)        
        {
            looper.quit();
            boolean varB326B5062B2F0E69046810717534CB09_1132083265 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2145374827 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2145374827;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_159547992 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452474500 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452474500;
        // ---------- Original Method ----------
        //Looper looper = getLooper();
        //if (looper != null) {
            //looper.quit();
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.218 -0400", hash_original_method = "EC4E0EE5AEE6B394A49A3FA195776A82", hash_generated_method = "CDC2CF30922BF09518EE4392B8834B27")
    public int getThreadId() {
        int var112D67724C3A8F952B4AC2B5A69FBC94_894590399 = (mTid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487023818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487023818;
        // ---------- Original Method ----------
        //return mTid;
    }

    
}

