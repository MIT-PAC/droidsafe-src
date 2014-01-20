package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.HashMap;

import android.util.Log;

public abstract class FileObserver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.682 -0500", hash_original_field = "5FE9DDE9D837F34381C4A54B3D07EE27", hash_generated_field = "21BD865D91527844549AD20398D3728F")

    public static final int ACCESS = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.684 -0500", hash_original_field = "51D9742CE255D597372550D9F50967F0", hash_generated_field = "34CDF25B69EE0885206F1D866F9D0AC5")

    public static final int MODIFY = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.687 -0500", hash_original_field = "DD8335F962D4C393E514190CC6E8990C", hash_generated_field = "4F6D51221FB774BFCF5270206198485D")

    public static final int ATTRIB = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.689 -0500", hash_original_field = "0031D6AA77107257DA71181ADDF3D4EC", hash_generated_field = "5F9A226BFB3C82BAAFDE638016B2FCC1")

    public static final int CLOSE_WRITE = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.691 -0500", hash_original_field = "35A7EEC38F9D7AD0459F4FB3166FBF5D", hash_generated_field = "18E6C95C116FA23FCBDF301853052C9A")

    public static final int CLOSE_NOWRITE = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.694 -0500", hash_original_field = "BA8511E709E557932F3CAFD6C8C16579", hash_generated_field = "EEC036CDB6E857C3BEF8C7257F2A5554")

    public static final int OPEN = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.696 -0500", hash_original_field = "0AA9F3ACB842FAC6DE18E3672AF526E5", hash_generated_field = "BE9A914D8AFFF0EEE1F39D2DB6E50051")

    public static final int MOVED_FROM = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.698 -0500", hash_original_field = "E560ED899B24A9426ADA31CD486062D3", hash_generated_field = "8A68A4B983D9AFC8272B9C244F4FDBFE")

    public static final int MOVED_TO = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.700 -0500", hash_original_field = "0B56105F8D0FC207B117C5E139DEDF9A", hash_generated_field = "91ECC282AD15E5A8F68B2D076FF1EAC8")

    public static final int CREATE = 0x00000100;
    
    private static class ObserverThread extends Thread {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.716 -0500", hash_original_field = "56456BFCC9D71198E1C8B389DC5580DC", hash_generated_field = "95A030757310716145723A8A1CEA6B63")

        private HashMap<Integer, WeakReference> m_observers = new HashMap<Integer, WeakReference>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.718 -0500", hash_original_field = "F68895B9DFF02A5C47584B8AE83828AF", hash_generated_field = "8BACC5D66846682999F92AA7BA6BAF2A")

        private int m_fd;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.720 -0500", hash_original_method = "3824F66F79A638103BDBC3E2FF39A85C", hash_generated_method = "16801E71DF829F3F33A9FE1858158FE6")
        
public ObserverThread() {
            super("FileObserver");
            m_fd = init();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.722 -0500", hash_original_method = "1D431AF3E47E4C831FAF412598272832", hash_generated_method = "1C18F73B691854C851AA61D2F3BFB8BE")
        
public void run() {
            observe(m_fd);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.724 -0500", hash_original_method = "D908EBB4D5EECA8DE9588D13B5ECBFEE", hash_generated_method = "A4B25ED9C6B8AD280CA32B66CC6873E9")
        
public int startWatching(String path, int mask, FileObserver observer) {
            int wfd = startWatching(m_fd, path, mask);

            Integer i = new Integer(wfd);
            if (wfd >= 0) {
                synchronized (m_observers) {
                    m_observers.put(i, new WeakReference(observer));
                }
            }

            return i;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.727 -0500", hash_original_method = "573D65A32946B3D500B130C05C51CF06", hash_generated_method = "B4E2B6E425A124E555458740D9C45D41")
        
public void stopWatching(int descriptor) {
            stopWatching(m_fd, descriptor);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.730 -0500", hash_original_method = "E3F4B34F65574690D606354D21ACF2F8", hash_generated_method = "769343B245E225D91FE481E6D443555F")
        
public void onEvent(int wfd, int mask, String path) {
            // look up our observer, fixing up the map if necessary...
            FileObserver observer = null;

            synchronized (m_observers) {
                WeakReference weak = m_observers.get(wfd);
                if (weak != null) {  // can happen with lots of events from a dead wfd
                    observer = (FileObserver) weak.get();
                    if (observer == null) {
                        m_observers.remove(wfd);
                    }
                }
            }

            // ...then call out to the observer without the sync lock held
            if (observer != null) {
                try {
                    observer.onEvent(mask, path);
                } catch (Throwable throwable) {
                    Log.wtf(LOG_TAG, "Unhandled exception in FileObserver " + observer, throwable);
                }
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.733 -0500", hash_original_method = "778044715AD29D56156139197CF7ACD4", hash_generated_method = "C09CD20B792D56A44D7CCF0AC590A5B0")
        
        private int init(){
        	//Formerly a native method
        	return getTaintInt();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.737 -0500", hash_original_method = "30BDAF8579403E1F75F26C57B59EB8F1", hash_generated_method = "0C3A49C6AA4498CA7B66854C7F0DEC73")
        
        private void observe(int fd){
        	//Formerly a native method
        	addTaint(fd);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.741 -0500", hash_original_method = "CA1E769B93F82C6A5E8C249942B2D7CE", hash_generated_method = "1F5F28AF9A61AB289D32BB2848B3F6EA")
        
        private int startWatching(int fd, String path, int mask){
        	//Formerly a native method
        	addTaint(fd);
        	addTaint(path.getTaint());
        	addTaint(mask);
        	return getTaintInt();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.745 -0500", hash_original_method = "78CD10B29FCA91AF1BF9DCB391BC5AA9", hash_generated_method = "394E12E9AC9B12044ECB7B5C98603EBD")
        
        private void stopWatching(int fd, int wfd){
        	//Formerly a native method
        	addTaint(fd);
        	addTaint(wfd);
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.703 -0500", hash_original_field = "CAB0384DF54A798636664314B0F34248", hash_generated_field = "B3C04D515307EB7E0F19F0FA5082DE3C")

    public static final int DELETE = 0x00000200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.705 -0500", hash_original_field = "7B8ADF7D88130BA5FD52283D97C2822B", hash_generated_field = "39F7D0EDCEBE72DA3E3CF500B5EAFB12")

    public static final int DELETE_SELF = 0x00000400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.707 -0500", hash_original_field = "ED2CB8690CC267D947ACC47E4FEA21A7", hash_generated_field = "BB224A5CEAE854073BC45842FD18D091")

    public static final int MOVE_SELF = 0x00000800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.710 -0500", hash_original_field = "0322CEAAAE3639A2F26C5A83F37E2762", hash_generated_field = "BA672F676FA20A031401BA7DED2A7810")

    public static final int ALL_EVENTS = ACCESS | MODIFY | ATTRIB | CLOSE_WRITE
            | CLOSE_NOWRITE | OPEN | MOVED_FROM | MOVED_TO | DELETE | CREATE
            | DELETE_SELF | MOVE_SELF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.713 -0500", hash_original_field = "3CE1256B1C9BDB4415B01ECC77A3613B", hash_generated_field = "AC0E7C3E561C767FDA353DB7657B76AD")

    private static final String LOG_TAG = "FileObserver";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.749 -0500", hash_original_field = "53047BD8D0D028D55CFACC5947363460", hash_generated_field = "810470F71D04523E52A64C29782F9430")

    private static ObserverThread s_observerThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.752 -0500", hash_original_field = "86D341BCB988DE4CD549A04FD8E01BB0", hash_generated_field = "F6AE1494CAFC5CFCCCF98A3C7A6207EF")

    private String m_path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.754 -0500", hash_original_field = "C7687443B24DC837C77E4CB928989D01", hash_generated_field = "5DCB2EE94F3D164CE0E5D793D93A27A8")

    private Integer m_descriptor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.756 -0500", hash_original_field = "C5C1B6D37D9EA21552C49412B2FB445C", hash_generated_field = "8FECC38F89FDC20604C46C3D7E8ED104")

    private int m_mask;

    /**
     * Equivalent to FileObserver(path, FileObserver.ALL_EVENTS).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.759 -0500", hash_original_method = "27AB284A495E6BF3D5CB7AEC897FFDFD", hash_generated_method = "B4B4AC1835BE60409D6948677153E2D6")
    
public FileObserver(String path) {
        this(path, ALL_EVENTS);
    }

    /**
     * Create a new file observer for a certain file or directory.
     * Monitoring does not start on creation!  You must call
     * {@link #startWatching()} before you will receive events.
     *
     * @param path The file or directory to monitor
     * @param mask The event or events (added together) to watch for
     */
    @DSComment("Low level monitoring file state")
    @DSSpec(DSCat.OS_LOW_LEVEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.761 -0500", hash_original_method = "F264FAE09DE2A5840856FF0F4AB8E776", hash_generated_method = "4420EB73C687A6AEEB448978A7536312")
    
public FileObserver(String path, int mask) {
        m_path = path;
        m_mask = mask;
        m_descriptor = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.763 -0500", hash_original_method = "C06680780DBA5951A3829CD335D202E8", hash_generated_method = "855EFDC4998FA49DCA64C379A4C6E0AA")
    
protected void finalize() {
        stopWatching();
    }

    /**
     * Start watching for events.  The monitored file or directory must exist at
     * this time, or else no events will be reported (even if it appears later).
     * If monitoring is already started, this call has no effect.
     */
    @DSComment("Low level monitoring file state")
    @DSSpec(DSCat.OS_LOW_LEVEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.765 -0500", hash_original_method = "2F8CF3013C1A72AA7A8ACE9D7C9A9F50", hash_generated_method = "4B40553039EC0FF89457EEC174970D10")
    
public void startWatching() {
        if (m_descriptor < 0) {
            m_descriptor = s_observerThread.startWatching(m_path, m_mask, this);
        }
    }

    /**
     * Stop watching for events.  Some events may be in process, so events
     * may continue to be reported even after this method completes.  If
     * monitoring is already stopped, this call has no effect.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.767 -0500", hash_original_method = "F05E1AF3D6B069B416C982EF16D23F8E", hash_generated_method = "B119867563A1AD2F08772FECCC77D9F4")
    
public void stopWatching() {
        if (m_descriptor >= 0) {
            s_observerThread.stopWatching(m_descriptor);
            m_descriptor = -1;
        }
    }

    /**
     * The event handler, which must be implemented by subclasses.
     *
     * <p class="note">This method is invoked on a special FileObserver thread.
     * It runs independently of any threads, so take care to use appropriate
     * synchronization!  Consider using {@link Handler#post(Runnable)} to shift
     * event handling work to the main thread to avoid concurrency problems.</p>
     *
     * <p>Event handlers must not throw exceptions.</p>
     *
     * @param event The type of event which happened
     * @param path The path, relative to the main monitored file or directory,
     *     of the file or directory which triggered the event
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.769 -0500", hash_original_method = "61CF0F56D51B4057906F8EC12985FFBD", hash_generated_method = "94669805F59639EB370B93260D57DECB")
    
public abstract void onEvent(int event, String path);
    static {
        s_observerThread = new ObserverThread();
        s_observerThread.start();
    }
    
}

