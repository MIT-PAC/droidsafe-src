package org.apache.commons.io.monitor;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

public final class FileAlterationMonitor implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.476 -0400", hash_original_field = "D2E16D3F793E62737A6CDF2D54B0D9C1", hash_generated_field = "A187678ED22D20A3185A905AC22BB781")

    private long interval;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.476 -0400", hash_original_field = "DEFF2B4753813EDCE4E2A9CD60B09D9D", hash_generated_field = "F3F34EF7C4EBDAADEFCB2334220A3BDA")

    private final List<FileAlterationObserver> observers = new CopyOnWriteArrayList<FileAlterationObserver>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.476 -0400", hash_original_field = "29AF94E1DA9BDE0448DEF5B3A2084BD6", hash_generated_field = "80520562B1904B351F5B26D98691BDBB")

    private Thread thread = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.476 -0400", hash_original_field = "DCEABFFDB4C91584FC9D3ABFD745936C", hash_generated_field = "6AD968703BFB4237698E73F59CC7657E")

    private ThreadFactory threadFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.476 -0400", hash_original_field = "B6E66E0A40F6F0D8A870C9C892F82367", hash_generated_field = "D887AB93EC2149E2D4A25BFD1C4FE163")

    private volatile boolean running = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.477 -0400", hash_original_method = "5732859DDEB3B1715451D21A81461EDA", hash_generated_method = "347FEEEF9B93812A242E99CF619C2C30")
    public  FileAlterationMonitor() {
        this(10000);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.477 -0400", hash_original_method = "53CA0D043E68099722661EEB7F58526A", hash_generated_method = "10E5F5B5D61FC814D289EFE3BC262B88")
    public  FileAlterationMonitor(long interval) {
        this.interval = interval;
        // ---------- Original Method ----------
        //this.interval = interval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.479 -0400", hash_original_method = "A414A772722097FFAFAD59FE99FA8E24", hash_generated_method = "29F717E7133B99760ECFD2C1DB64594A")
    public  FileAlterationMonitor(long interval, FileAlterationObserver... observers) {
        this(interval);
        {
            {
                //Iterator<FileAlterationObserver> var4BDBA0172E5E49F358D9F86D41707395_46854678 = (observers).iterator();
                //var4BDBA0172E5E49F358D9F86D41707395_46854678.hasNext();
                FileAlterationObserver observer = observers[0];
                {
                    addObserver(observer);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(interval);
        addTaint(observers[0].getTaint());
        // ---------- Original Method ----------
        //if (observers != null) {
            //for (FileAlterationObserver observer : observers) {
                //addObserver(observer);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.480 -0400", hash_original_method = "8CAC42DB459590AAD476B56FC6D4D691", hash_generated_method = "07A15A8F407CF26C5A8EF03F48D13C44")
    public long getInterval() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_848605141 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_848605141;
        // ---------- Original Method ----------
        //return interval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.480 -0400", hash_original_method = "7BE8A8BA046629FAE448DADF48A43E2C", hash_generated_method = "45815364147204283B9021DBF48F822A")
    public synchronized void setThreadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        // ---------- Original Method ----------
        //this.threadFactory = threadFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.481 -0400", hash_original_method = "2582EB9761FBC4039D57C08A2BAB7EC6", hash_generated_method = "0B9811A1AE8E88F3B1604C9BA3C0D544")
    public void addObserver(final FileAlterationObserver observer) {
        {
            observers.add(observer);
        } //End block
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //if (observer != null) {
            //observers.add(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.482 -0400", hash_original_method = "F32D89C4D68A9F884EB414FBF4D51576", hash_generated_method = "C174A3F8AF7F398775F72EBAD802212A")
    public void removeObserver(final FileAlterationObserver observer) {
        {
            {
                boolean var793AE44AA042FADFB401996D791FF0FB_1670328952 = (observers.remove(observer));
            } //End collapsed parenthetic
        } //End block
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //if (observer != null) {
            //while (observers.remove(observer)) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.484 -0400", hash_original_method = "BF717E48FF5F91E5BF5689DA8A1B6D0C", hash_generated_method = "98A5A7AADA011521B7D12B9A05D3DB1E")
    public Iterable<FileAlterationObserver> getObservers() {
        Iterable<FileAlterationObserver> varB4EAC82CA7396A68D541C85D26508E83_1177423181 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1177423181 = observers;
        varB4EAC82CA7396A68D541C85D26508E83_1177423181.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1177423181;
        // ---------- Original Method ----------
        //return observers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.487 -0400", hash_original_method = "B61D151163EA402642536A8375DC60A2", hash_generated_method = "586337B55D2CD88A3F1299334711BE17")
    public synchronized void start() throws Exception {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Monitor is already running");
        } //End block
        {
            Iterator<FileAlterationObserver> var4BDBA0172E5E49F358D9F86D41707395_407936480 = (observers).iterator();
            var4BDBA0172E5E49F358D9F86D41707395_407936480.hasNext();
            FileAlterationObserver observer = var4BDBA0172E5E49F358D9F86D41707395_407936480.next();
            {
                observer.initialize();
            } //End block
        } //End collapsed parenthetic
        running = true;
        {
            thread = threadFactory.newThread(this);
        } //End block
        {
            thread = new Thread(this);
        } //End block
        thread.start();
        // ---------- Original Method ----------
        //if (running) {
            //throw new IllegalStateException("Monitor is already running");
        //}
        //for (FileAlterationObserver observer : observers) {
            //observer.initialize();
        //}
        //running = true;
        //if (threadFactory != null) {
            //thread = threadFactory.newThread(this);
        //} else {
            //thread = new Thread(this);
        //}
        //thread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.488 -0400", hash_original_method = "6C2BF33BEAB4575B1BB326C79611D3DD", hash_generated_method = "FE875CF0B12485E54D4E2F4980408D92")
    public synchronized void stop() throws Exception {
        stop(interval);
        // ---------- Original Method ----------
        //stop(interval);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.489 -0400", hash_original_method = "847744E50C0F667B1CC040D26B6B22E8", hash_generated_method = "52B42F9E4D2B9FC1E52A42360BD1370A")
    public synchronized void stop(long stopInterval) throws Exception {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Monitor is not running");
        } //End block
        running = false;
        try 
        {
            thread.join(stopInterval);
        } //End block
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        } //End block
        {
            Iterator<FileAlterationObserver> var4BDBA0172E5E49F358D9F86D41707395_599739225 = (observers).iterator();
            var4BDBA0172E5E49F358D9F86D41707395_599739225.hasNext();
            FileAlterationObserver observer = var4BDBA0172E5E49F358D9F86D41707395_599739225.next();
            {
                observer.destroy();
            } //End block
        } //End collapsed parenthetic
        addTaint(stopInterval);
        // ---------- Original Method ----------
        //if (running == false) {
            //throw new IllegalStateException("Monitor is not running");
        //}
        //running = false;
        //try {
            //thread.join(stopInterval);
        //} catch (InterruptedException e) {
            //Thread.currentThread().interrupt();
        //}
        //for (FileAlterationObserver observer : observers) {
            //observer.destroy();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.490 -0400", hash_original_method = "24024F5BBB220303415536AF43C72777", hash_generated_method = "B9E52225952E599E1E4D2058D0EB6CA4")
    public void run() {
        {
            {
                Iterator<FileAlterationObserver> var4BDBA0172E5E49F358D9F86D41707395_2012206190 = (observers).iterator();
                var4BDBA0172E5E49F358D9F86D41707395_2012206190.hasNext();
                FileAlterationObserver observer = var4BDBA0172E5E49F358D9F86D41707395_2012206190.next();
                {
                    observer.checkAndNotify();
                } //End block
            } //End collapsed parenthetic
            try 
            {
                Thread.sleep(interval);
            } //End block
            catch (final InterruptedException ignored)
            { }
        } //End block
        // ---------- Original Method ----------
        //while (running) {
            //for (FileAlterationObserver observer : observers) {
                //observer.checkAndNotify();
            //}
            //if (!running) {
                //break;
            //}
            //try {
                //Thread.sleep(interval);
            //} catch (final InterruptedException ignored) {
            //}
        //}
    }

    
}

