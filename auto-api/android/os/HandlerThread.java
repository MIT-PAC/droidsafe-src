package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class HandlerThread extends Thread {
    int mPriority;
    int mTid = -1;
    Looper mLooper;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.545 -0400", hash_original_method = "E5F101A858C2AB40D5C2E9617BFE5E37", hash_generated_method = "E6CE4E5D0AA73AABEC10042C5ECF48A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HandlerThread(String name) {
        super(name);
        dsTaint.addTaint(name);
        mPriority = Process.THREAD_PRIORITY_DEFAULT;
        // ---------- Original Method ----------
        //mPriority = Process.THREAD_PRIORITY_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.545 -0400", hash_original_method = "E70E3F12F9547EDCFC1C795A424416CD", hash_generated_method = "713B719C3DD181C5891FFE50EDC00C95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HandlerThread(String name, int priority) {
        super(name);
        dsTaint.addTaint(priority);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
        //mPriority = priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.546 -0400", hash_original_method = "7869505C1EE96F329E4F7F0EA5AF9C5D", hash_generated_method = "FB28300AB029F1A68D6A159EC4AF6459")
    @DSModeled(DSC.SAFE)
    protected void onLooperPrepared() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.546 -0400", hash_original_method = "9E0B8BC0299FD7F24B369B7431C1A009", hash_generated_method = "9CAA9544D70D477C070654A917E8FC9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        mTid = Process.myTid();
        Looper.prepare();
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.547 -0400", hash_original_method = "0FC13809696BA2D6DC441C842770D0F1", hash_generated_method = "F69BD52BFD55A2FB8655DAC146CB2970")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Looper getLooper() {
        {
            boolean var26246F6B91339E19161496C5E67A3C4C_1706213479 = (!isAlive());
        } //End collapsed parenthetic
        {
            {
                boolean var69F7AF4175FC4B4AA6DEE35627DC602F_827580142 = (isAlive() && mLooper == null);
                {
                    try 
                    {
                        wait();
                    } //End block
                    catch (InterruptedException e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Looper)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.547 -0400", hash_original_method = "45988F35C3EAC3EE4988825F5EC29D45", hash_generated_method = "760328B5FA614600FE012DDA0B5F6409")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quit() {
        Looper looper;
        looper = getLooper();
        {
            looper.quit();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Looper looper = getLooper();
        //if (looper != null) {
            //looper.quit();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.548 -0400", hash_original_method = "EC4E0EE5AEE6B394A49A3FA195776A82", hash_generated_method = "88DBDD7033914A74DEE17118A02EAD31")
    @DSModeled(DSC.SAFE)
    public int getThreadId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTid;
    }

    
}

