package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FileCleaningTracker {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.294 -0400", hash_original_field = "C7F7B8E1996E1473C0F68167EB1C48D9", hash_generated_field = "213531C24E01D75B6586561286CC3D19")

    ReferenceQueue<Object> q = new ReferenceQueue<Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.294 -0400", hash_original_field = "2A7D757FDCBA664FEF63517E768369A2", hash_generated_field = "AF9D0C9A26B48389985C14225EEC9872")

    final Collection<Tracker> trackers = Collections.synchronizedSet(new HashSet<Tracker>());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.294 -0400", hash_original_field = "C1AC752923DF7FFB821113227C5B1909", hash_generated_field = "A6AEB94E48E2859A32C7ED265019A512")

    final List<String> deleteFailures = Collections.synchronizedList(new ArrayList<String>());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.294 -0400", hash_original_field = "2B3F18F02063A34FC73F392335C02AA3", hash_generated_field = "FC69D0639783984C922B494B12D9334F")

    volatile boolean exitWhenFinished = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.294 -0400", hash_original_field = "8F9C4BE97DDE5A4499A5CA37360E6FAE", hash_generated_field = "FF1EED7D363F9E58AB5605C1B22B97F7")

    Thread reaper;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.294 -0400", hash_original_method = "426A3F67BDF174C11E9DF835FA4ECA6C", hash_generated_method = "426A3F67BDF174C11E9DF835FA4ECA6C")
    public FileCleaningTracker ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.295 -0400", hash_original_method = "F07020199FD227FDE709D6E57E38422A", hash_generated_method = "7529397C6148DE80D8E9BE7F8F88FD3B")
    public void track(File file, Object marker) {
        track(file, marker, (FileDeleteStrategy) null);
        addTaint(file.getTaint());
        addTaint(marker.getTaint());
        // ---------- Original Method ----------
        //track(file, marker, (FileDeleteStrategy) null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.295 -0400", hash_original_method = "86C594F1F9E71F35FFEC0A77C084143C", hash_generated_method = "43196371CE61D98A9CCE25CBB092AE7E")
    public void track(File file, Object marker, FileDeleteStrategy deleteStrategy) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The file must not be null");
        } //End block
        addTracker(file.getPath(), marker, deleteStrategy);
        addTaint(file.getTaint());
        addTaint(marker.getTaint());
        addTaint(deleteStrategy.getTaint());
        // ---------- Original Method ----------
        //if (file == null) {
            //throw new NullPointerException("The file must not be null");
        //}
        //addTracker(file.getPath(), marker, deleteStrategy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.295 -0400", hash_original_method = "A3E86DDC0D794AB85A77D2E23B6B45C0", hash_generated_method = "3A8AAC58FD4C7257046E8CED49B8396D")
    public void track(String path, Object marker) {
        track(path, marker, (FileDeleteStrategy) null);
        addTaint(path.getTaint());
        addTaint(marker.getTaint());
        // ---------- Original Method ----------
        //track(path, marker, (FileDeleteStrategy) null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.296 -0400", hash_original_method = "543B22C2EC07CA4C1AEB003D5BB6B718", hash_generated_method = "CB8F452D5BC4BCEFA1929E4A70B2F473")
    public void track(String path, Object marker, FileDeleteStrategy deleteStrategy) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The path must not be null");
        } //End block
        addTracker(path, marker, deleteStrategy);
        addTaint(path.getTaint());
        addTaint(marker.getTaint());
        addTaint(deleteStrategy.getTaint());
        // ---------- Original Method ----------
        //if (path == null) {
            //throw new NullPointerException("The path must not be null");
        //}
        //addTracker(path, marker, deleteStrategy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.296 -0400", hash_original_method = "954E11DA9D99B56A3E0C00DDF1274471", hash_generated_method = "DCF3B97236E7A9C29FEB57A01A9C52B9")
    private synchronized void addTracker(String path, Object marker, FileDeleteStrategy deleteStrategy) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        } //End block
        {
            reaper = new Reaper();
            reaper.start();
        } //End block
        trackers.add(new Tracker(path, deleteStrategy, marker, q));
        addTaint(path.getTaint());
        addTaint(marker.getTaint());
        addTaint(deleteStrategy.getTaint());
        // ---------- Original Method ----------
        //if (exitWhenFinished) {
            //throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        //}
        //if (reaper == null) {
            //reaper = new Reaper();
            //reaper.start();
        //}
        //trackers.add(new Tracker(path, deleteStrategy, marker, q));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.297 -0400", hash_original_method = "0EFA130573A478F2919BB30F1541B30D", hash_generated_method = "EA1C7CEF40C33D0129FA5A12464F07CC")
    public int getTrackCount() {
        int var7853BB5C1D06EADAC5F74F0DBD6FDCE0_1603260380 = (trackers.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479807508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479807508;
        // ---------- Original Method ----------
        //return trackers.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.298 -0400", hash_original_method = "643CA49BD82C37C2D2981C66A57227C8", hash_generated_method = "089CDE587395BCA4B37E1CB7334F8B2D")
    public List<String> getDeleteFailures() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1381425429 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1381425429 = deleteFailures;
        varB4EAC82CA7396A68D541C85D26508E83_1381425429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1381425429;
        // ---------- Original Method ----------
        //return deleteFailures;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.298 -0400", hash_original_method = "4DFB4596FA2073A710F42E9B9443E144", hash_generated_method = "9177AAD41BE6B5E70CE3C0F8D3C5AC38")
    public synchronized void exitWhenFinished() {
        exitWhenFinished = true;
        {
            {
                reaper.interrupt();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //exitWhenFinished = true;
        //if (reaper != null) {
            //synchronized (reaper) {
                //reaper.interrupt();
            //}
        //}
    }

    
    private final class Reaper extends Thread {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.299 -0400", hash_original_method = "8A2C8203FCA0486478B916225D009300", hash_generated_method = "8903C57A96C128C901B95AAA66D3F861")
          Reaper() {
            super("File Reaper");
            setPriority(Thread.MAX_PRIORITY);
            setDaemon(true);
            // ---------- Original Method ----------
            //setPriority(Thread.MAX_PRIORITY);
            //setDaemon(true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.300 -0400", hash_original_method = "63BD1C8F3C17781753BA16C837ECEC6F", hash_generated_method = "E315495CE2AA26B7AB2F6FDCBBF9797F")
        @Override
        public void run() {
            {
                boolean var8ADA4FBD2A52A519FCE8DACC390EADFC_1213786851 = (exitWhenFinished == false || trackers.size() > 0);
                {
                    try 
                    {
                        Tracker tracker = (Tracker) q.remove();
                        trackers.remove(tracker);
                        {
                            boolean var99BD88113948D5AC8A3BFE23164FCEB4_859482290 = (!tracker.delete());
                            {
                                deleteFailures.add(tracker.getPath());
                            } //End block
                        } //End collapsed parenthetic
                        tracker.clear();
                    } //End block
                    catch (InterruptedException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //while (exitWhenFinished == false || trackers.size() > 0) {
                //try {
                    //Tracker tracker = (Tracker) q.remove(); 
                    //trackers.remove(tracker);
                    //if (!tracker.delete()) {
                        //deleteFailures.add(tracker.getPath());
                    //}
                    //tracker.clear();
                //} catch (InterruptedException e) {
                    //continue;
                //}
            //}
        }

        
    }


    
    private static final class Tracker extends PhantomReference<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.300 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

        private String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.300 -0400", hash_original_field = "747B2CCEC93E4A0453F3DE516A284004", hash_generated_field = "B4FF12F6828CA41D190DAA3E50AD77C4")

        private FileDeleteStrategy deleteStrategy;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.301 -0400", hash_original_method = "D194994672CF72D739AD2FC5B3B2AA56", hash_generated_method = "01AFBCAB55A574A3B70B684BEB4BB5F4")
          Tracker(String path, FileDeleteStrategy deleteStrategy, Object marker, ReferenceQueue<? super Object> queue) {
            super(marker, queue);
            this.path = path;
            this.deleteStrategy = deleteStrategy == null ? FileDeleteStrategy.NORMAL : deleteStrategy;
            addTaint(marker.getTaint());
            addTaint(queue.getTaint());
            // ---------- Original Method ----------
            //this.path = path;
            //this.deleteStrategy = deleteStrategy == null ? FileDeleteStrategy.NORMAL : deleteStrategy;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.302 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "3D5DD9718925260090B2CB5855686DE0")
        public String getPath() {
            String varB4EAC82CA7396A68D541C85D26508E83_406444421 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_406444421 = path;
            varB4EAC82CA7396A68D541C85D26508E83_406444421.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_406444421;
            // ---------- Original Method ----------
            //return path;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.303 -0400", hash_original_method = "D48AE50A84087A4C1BFE9CE0B93380B9", hash_generated_method = "B235128EF48D67D6E8231CE330B1214B")
        public boolean delete() {
            boolean var16512D20B0098962570808FE3BD35F8A_1377431716 = (deleteStrategy.deleteQuietly(new File(path)));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1003246200 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1003246200;
            // ---------- Original Method ----------
            //return deleteStrategy.deleteQuietly(new File(path));
        }

        
    }


    
}

