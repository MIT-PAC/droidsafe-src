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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.118 -0400", hash_original_field = "D2E16D3F793E62737A6CDF2D54B0D9C1", hash_generated_field = "A187678ED22D20A3185A905AC22BB781")

    private long interval;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.118 -0400", hash_original_field = "DEFF2B4753813EDCE4E2A9CD60B09D9D", hash_generated_field = "2C1B985E415DFDD5089C84C45BAB9A4C")

    private List<FileAlterationObserver> observers = new CopyOnWriteArrayList<FileAlterationObserver>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.118 -0400", hash_original_field = "29AF94E1DA9BDE0448DEF5B3A2084BD6", hash_generated_field = "80520562B1904B351F5B26D98691BDBB")

    private Thread thread = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.118 -0400", hash_original_field = "DCEABFFDB4C91584FC9D3ABFD745936C", hash_generated_field = "6AD968703BFB4237698E73F59CC7657E")

    private ThreadFactory threadFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.118 -0400", hash_original_field = "B6E66E0A40F6F0D8A870C9C892F82367", hash_generated_field = "D887AB93EC2149E2D4A25BFD1C4FE163")

    private volatile boolean running = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.118 -0400", hash_original_method = "5732859DDEB3B1715451D21A81461EDA", hash_generated_method = "347FEEEF9B93812A242E99CF619C2C30")
    public  FileAlterationMonitor() {
        this(10000);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.118 -0400", hash_original_method = "53CA0D043E68099722661EEB7F58526A", hash_generated_method = "10E5F5B5D61FC814D289EFE3BC262B88")
    public  FileAlterationMonitor(long interval) {
        this.interval = interval;
        // ---------- Original Method ----------
        //this.interval = interval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.121 -0400", hash_original_method = "A414A772722097FFAFAD59FE99FA8E24", hash_generated_method = "0DABB63D2BE64A09B7C3435B03289271")
    public  FileAlterationMonitor(long interval, FileAlterationObserver... observers) {
        this(interval);
        {
            {
                Iterator<FileAlterationObserver> var4BDBA0172E5E49F358D9F86D41707395_185282239 = (observers).iterator();
                var4BDBA0172E5E49F358D9F86D41707395_185282239.hasNext();
                FileAlterationObserver observer = var4BDBA0172E5E49F358D9F86D41707395_185282239.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.131 -0400", hash_original_method = "8CAC42DB459590AAD476B56FC6D4D691", hash_generated_method = "A157BBAACB03DC2159A66B7CF51B99CE")
    public long getInterval() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_126305157 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_126305157;
        // ---------- Original Method ----------
        //return interval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.140 -0400", hash_original_method = "7BE8A8BA046629FAE448DADF48A43E2C", hash_generated_method = "45815364147204283B9021DBF48F822A")
    public synchronized void setThreadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        // ---------- Original Method ----------
        //this.threadFactory = threadFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.141 -0400", hash_original_method = "2582EB9761FBC4039D57C08A2BAB7EC6", hash_generated_method = "0B9811A1AE8E88F3B1604C9BA3C0D544")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.141 -0400", hash_original_method = "F32D89C4D68A9F884EB414FBF4D51576", hash_generated_method = "37A59FCB51092CCBFAB23DA0E8D006AD")
    public void removeObserver(final FileAlterationObserver observer) {
        {
            {
                boolean var793AE44AA042FADFB401996D791FF0FB_787830598 = (observers.remove(observer));
            } //End collapsed parenthetic
        } //End block
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //if (observer != null) {
            //while (observers.remove(observer)) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.142 -0400", hash_original_method = "BF717E48FF5F91E5BF5689DA8A1B6D0C", hash_generated_method = "086239FF781448875F8D101C927B3000")
    public Iterable<FileAlterationObserver> getObservers() {
        Iterable<FileAlterationObserver> varB4EAC82CA7396A68D541C85D26508E83_484560557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_484560557 = observers;
        varB4EAC82CA7396A68D541C85D26508E83_484560557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_484560557;
        // ---------- Original Method ----------
        //return observers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.165 -0400", hash_original_method = "B61D151163EA402642536A8375DC60A2", hash_generated_method = "893339C32D157A36914DBBB8A687731F")
    public synchronized void start() throws Exception {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Monitor is already running");
        } //End block
        {
            Iterator<FileAlterationObserver> var4BDBA0172E5E49F358D9F86D41707395_687815760 = (observers).iterator();
            var4BDBA0172E5E49F358D9F86D41707395_687815760.hasNext();
            FileAlterationObserver observer = var4BDBA0172E5E49F358D9F86D41707395_687815760.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.166 -0400", hash_original_method = "6C2BF33BEAB4575B1BB326C79611D3DD", hash_generated_method = "FE875CF0B12485E54D4E2F4980408D92")
    public synchronized void stop() throws Exception {
        stop(interval);
        // ---------- Original Method ----------
        //stop(interval);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.202 -0400", hash_original_method = "847744E50C0F667B1CC040D26B6B22E8", hash_generated_method = "8B3C5ED455A71D1F194803B50A03AABC")
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
            Iterator<FileAlterationObserver> var4BDBA0172E5E49F358D9F86D41707395_1368765118 = (observers).iterator();
            var4BDBA0172E5E49F358D9F86D41707395_1368765118.hasNext();
            FileAlterationObserver observer = var4BDBA0172E5E49F358D9F86D41707395_1368765118.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.230 -0400", hash_original_method = "24024F5BBB220303415536AF43C72777", hash_generated_method = "038CA94E33D0A8BF2DB17290CCE7C6BE")
    public void run() {
        {
            {
                Iterator<FileAlterationObserver> var4BDBA0172E5E49F358D9F86D41707395_837802154 = (observers).iterator();
                var4BDBA0172E5E49F358D9F86D41707395_837802154.hasNext();
                FileAlterationObserver observer = var4BDBA0172E5E49F358D9F86D41707395_837802154.next();
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

