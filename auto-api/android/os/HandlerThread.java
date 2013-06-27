package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class HandlerThread extends Thread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.102 -0400", hash_original_field = "22FC7A378B4F7C5F90F70A47BE1E4FCD", hash_generated_field = "1D8CA7654CC48BAF402334392A1619BF")

    int mPriority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.102 -0400", hash_original_field = "786D3949F65E83EBF0570337C6D9716A", hash_generated_field = "443BB6C8F0508752717F617F7353B13A")

    int mTid = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.102 -0400", hash_original_field = "DA288C1345E9C94467C02060ED19C6FA", hash_generated_field = "4C6A73D1D5351706C43659B423CF9288")

    Looper mLooper;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.103 -0400", hash_original_method = "E5F101A858C2AB40D5C2E9617BFE5E37", hash_generated_method = "836DE158C33FBD2986588D6F4BBBE339")
    public  HandlerThread(String name) {
        super(name);
        mPriority = Process.THREAD_PRIORITY_DEFAULT;
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //mPriority = Process.THREAD_PRIORITY_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.110 -0400", hash_original_method = "E70E3F12F9547EDCFC1C795A424416CD", hash_generated_method = "3597CAE74E0CC2014DA4F752A3F7A1AD")
    public  HandlerThread(String name, int priority) {
        super(name);
        mPriority = priority;
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //mPriority = priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.111 -0400", hash_original_method = "7869505C1EE96F329E4F7F0EA5AF9C5D", hash_generated_method = "FB28300AB029F1A68D6A159EC4AF6459")
    protected void onLooperPrepared() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.128 -0400", hash_original_method = "9E0B8BC0299FD7F24B369B7431C1A009", hash_generated_method = "9CAA9544D70D477C070654A917E8FC9D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.138 -0400", hash_original_method = "0FC13809696BA2D6DC441C842770D0F1", hash_generated_method = "79BCA6335CCAD5CE1BE1BEE39B0FAEC2")
    public Looper getLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_1446956410 = null; //Variable for return #1
        Looper varB4EAC82CA7396A68D541C85D26508E83_81220063 = null; //Variable for return #2
        {
            boolean var26246F6B91339E19161496C5E67A3C4C_1429555111 = (!isAlive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1446956410 = null;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var69F7AF4175FC4B4AA6DEE35627DC602F_1911954817 = (isAlive() && mLooper == null);
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
        varB4EAC82CA7396A68D541C85D26508E83_81220063 = mLooper;
        Looper varA7E53CE21691AB073D9660D615818899_1693528193; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1693528193 = varB4EAC82CA7396A68D541C85D26508E83_1446956410;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1693528193 = varB4EAC82CA7396A68D541C85D26508E83_81220063;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1693528193.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1693528193;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.139 -0400", hash_original_method = "45988F35C3EAC3EE4988825F5EC29D45", hash_generated_method = "D4EF4D157B8D52506438D22BBA14E3EE")
    public boolean quit() {
        Looper looper;
        looper = getLooper();
        {
            looper.quit();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368099307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_368099307;
        // ---------- Original Method ----------
        //Looper looper = getLooper();
        //if (looper != null) {
            //looper.quit();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.139 -0400", hash_original_method = "EC4E0EE5AEE6B394A49A3FA195776A82", hash_generated_method = "809984223A0B12FC73D8F6A0ABC2728E")
    public int getThreadId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1296804010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1296804010;
        // ---------- Original Method ----------
        //return mTid;
    }

    
}

