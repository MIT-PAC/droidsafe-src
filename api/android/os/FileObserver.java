package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.HashMap;

import android.util.Log;





public abstract class FileObserver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.064 -0400", hash_original_field = "A74740AB247BAEAA4F1F231E45678F33", hash_generated_field = "F6AE1494CAFC5CFCCCF98A3C7A6207EF")

    private String m_path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.064 -0400", hash_original_field = "A26490C5028420B1448BC00C18D5E7EA", hash_generated_field = "5DCB2EE94F3D164CE0E5D793D93A27A8")

    private Integer m_descriptor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.064 -0400", hash_original_field = "D7835D98F9518BDBBA6B8AF195A6B285", hash_generated_field = "8FECC38F89FDC20604C46C3D7E8ED104")

    private int m_mask;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.065 -0400", hash_original_method = "27AB284A495E6BF3D5CB7AEC897FFDFD", hash_generated_method = "B0638721E13BB6827303F2CA23F6B9D9")
    public  FileObserver(String path) {
        this(path, ALL_EVENTS);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.065 -0400", hash_original_method = "F264FAE09DE2A5840856FF0F4AB8E776", hash_generated_method = "F99D4FBCDED71BD3CF6CA9F6E07C30BD")
    public  FileObserver(String path, int mask) {
        m_path = path;
        m_mask = mask;
        m_descriptor = -1;
        // ---------- Original Method ----------
        //m_path = path;
        //m_mask = mask;
        //m_descriptor = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.065 -0400", hash_original_method = "C06680780DBA5951A3829CD335D202E8", hash_generated_method = "54389441D361A9D47ADD493BC8B0D77A")
    protected void finalize() {
        stopWatching();
        // ---------- Original Method ----------
        //stopWatching();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.065 -0400", hash_original_method = "2F8CF3013C1A72AA7A8ACE9D7C9A9F50", hash_generated_method = "E9714164A4941E164E92D52B6A929FE6")
    public void startWatching() {
        if(m_descriptor < 0)        
        {
            m_descriptor = s_observerThread.startWatching(m_path, m_mask, this);
        } //End block
        // ---------- Original Method ----------
        //if (m_descriptor < 0) {
            //m_descriptor = s_observerThread.startWatching(m_path, m_mask, this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.065 -0400", hash_original_method = "F05E1AF3D6B069B416C982EF16D23F8E", hash_generated_method = "F0559F6875180B7D27098A06C91572B6")
    public void stopWatching() {
        if(m_descriptor >= 0)        
        {
            s_observerThread.stopWatching(m_descriptor);
            m_descriptor = -1;
        } //End block
        // ---------- Original Method ----------
        //if (m_descriptor >= 0) {
            //s_observerThread.stopWatching(m_descriptor);
            //m_descriptor = -1;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void onEvent(int event, String path);

    
    private static class ObserverThread extends Thread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.065 -0400", hash_original_field = "3D2D05B9A1A7F586AE2D9BD753DF4C6B", hash_generated_field = "95A030757310716145723A8A1CEA6B63")

        private HashMap<Integer, WeakReference> m_observers = new HashMap<Integer, WeakReference>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.065 -0400", hash_original_field = "BF920D51EC7D8B9180D54D1F5A64DF53", hash_generated_field = "8BACC5D66846682999F92AA7BA6BAF2A")

        private int m_fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.065 -0400", hash_original_method = "3824F66F79A638103BDBC3E2FF39A85C", hash_generated_method = "83B8653B1FC4B33B9768F5319DAA9E21")
        public  ObserverThread() {
            super("FileObserver");
            m_fd = init();
            // ---------- Original Method ----------
            //m_fd = init();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.066 -0400", hash_original_method = "1D431AF3E47E4C831FAF412598272832", hash_generated_method = "1AC225FF31C20B65F9280920FBE577FF")
        public void run() {
            observe(m_fd);
            // ---------- Original Method ----------
            //observe(m_fd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.066 -0400", hash_original_method = "D908EBB4D5EECA8DE9588D13B5ECBFEE", hash_generated_method = "0CF7A9146B02F31FE20F0F37D49386FC")
        public int startWatching(String path, int mask, FileObserver observer) {
            addTaint(observer.getTaint());
            addTaint(mask);
            addTaint(path.getTaint());
            int wfd = startWatching(m_fd, path, mask);
            Integer i = new Integer(wfd);
            if(wfd >= 0)            
            {
                synchronized
(m_observers)                {
                    m_observers.put(i, new WeakReference(observer));
                } //End block
            } //End block
            int var865C0C0B4AB0E063E5CAA3387C1A8741_1088537019 = (i);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993647838 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993647838;
            // ---------- Original Method ----------
            //int wfd = startWatching(m_fd, path, mask);
            //Integer i = new Integer(wfd);
            //if (wfd >= 0) {
                //synchronized (m_observers) {
                    //m_observers.put(i, new WeakReference(observer));
                //}
            //}
            //return i;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.066 -0400", hash_original_method = "573D65A32946B3D500B130C05C51CF06", hash_generated_method = "C6F724F674DEC309CE7954E33C438687")
        public void stopWatching(int descriptor) {
            addTaint(descriptor);
            stopWatching(m_fd, descriptor);
            // ---------- Original Method ----------
            //stopWatching(m_fd, descriptor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.066 -0400", hash_original_method = "E3F4B34F65574690D606354D21ACF2F8", hash_generated_method = "43B249D50E1708E7BF7B631043593B2C")
        public void onEvent(int wfd, int mask, String path) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(path.getTaint());
            addTaint(mask);
            addTaint(wfd);
            FileObserver observer = null;
            synchronized
(m_observers)            {
                WeakReference weak = m_observers.get(wfd);
                if(weak != null)                
                {
                    observer = (FileObserver) weak.get();
                    if(observer == null)                    
                    {
                        m_observers.remove(wfd);
                    } //End block
                } //End block
            } //End block
            if(observer != null)            
            {
                try 
                {
                    observer.onEvent(mask, path);
                } //End block
                catch (Throwable throwable)
                {
                    Log.wtf(LOG_TAG, "Unhandled exception in FileObserver " + observer, throwable);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //FileObserver observer = null;
            //synchronized (m_observers) {
                //WeakReference weak = m_observers.get(wfd);
                //if (weak != null) {  
                    //observer = (FileObserver) weak.get();
                    //if (observer == null) {
                        //m_observers.remove(wfd);
                    //}
                //}
            //}
            //if (observer != null) {
                //try {
                    //observer.onEvent(mask, path);
                //} catch (Throwable throwable) {
                    //Log.wtf(LOG_TAG, "Unhandled exception in FileObserver " + observer, throwable);
                //}
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.066 -0400", hash_original_method = "778044715AD29D56156139197CF7ACD4", hash_generated_method = "29F57CCE2FDCC0585A17922C1938666E")
        private int init() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998196422 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998196422;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.066 -0400", hash_original_method = "30BDAF8579403E1F75F26C57B59EB8F1", hash_generated_method = "67FB347A4347839EF365C019547DE29A")
        private void observe(int fd) {
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.066 -0400", hash_original_method = "CA1E769B93F82C6A5E8C249942B2D7CE", hash_generated_method = "414380EB4D2C3F07EFB08745B191805E")
        private int startWatching(int fd, String path, int mask) {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546885625 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546885625;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_method = "78CD10B29FCA91AF1BF9DCB391BC5AA9", hash_generated_method = "AA52DA03EE07FAC57937E1E11154B48F")
        private void stopWatching(int fd, int wfd) {
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "1C706889DC35E61A8229B0F14770BC25", hash_generated_field = "21BD865D91527844549AD20398D3728F")

    public static final int ACCESS = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "5E1AB56786E957C5A27FC350CB85D1E7", hash_generated_field = "34CDF25B69EE0885206F1D866F9D0AC5")

    public static final int MODIFY = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "73B84263866306FB88D91B6E688076F2", hash_generated_field = "4F6D51221FB774BFCF5270206198485D")

    public static final int ATTRIB = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "A70EA521353260D0414C71FC71B8B470", hash_generated_field = "5F9A226BFB3C82BAAFDE638016B2FCC1")

    public static final int CLOSE_WRITE = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "CF6055B228FCFB47930F71F1BE1D1228", hash_generated_field = "18E6C95C116FA23FCBDF301853052C9A")

    public static final int CLOSE_NOWRITE = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "4EA966479AD0B5DF65D0DDFBFDD9FF21", hash_generated_field = "EEC036CDB6E857C3BEF8C7257F2A5554")

    public static final int OPEN = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "6684C0299399C39243AEBF0BF851229C", hash_generated_field = "BE9A914D8AFFF0EEE1F39D2DB6E50051")

    public static final int MOVED_FROM = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "C908335A476075B0BFB770CDE10FAE5A", hash_generated_field = "8A68A4B983D9AFC8272B9C244F4FDBFE")

    public static final int MOVED_TO = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "B4F99B696B90EFE9459188998F270BAC", hash_generated_field = "91ECC282AD15E5A8F68B2D076FF1EAC8")

    public static final int CREATE = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "3ED2E037AD4F64CA7D2FEBCAB77C5749", hash_generated_field = "B3C04D515307EB7E0F19F0FA5082DE3C")

    public static final int DELETE = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "033E45B44E532704A57B7B9186D1CE2D", hash_generated_field = "39F7D0EDCEBE72DA3E3CF500B5EAFB12")

    public static final int DELETE_SELF = 0x00000400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "244C360118F6D7A5FCBC4CFCA5BD3438", hash_generated_field = "BB224A5CEAE854073BC45842FD18D091")

    public static final int MOVE_SELF = 0x00000800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "C59E3267F22C87D0ABC87F634BA32F27", hash_generated_field = "BA672F676FA20A031401BA7DED2A7810")

    public static final int ALL_EVENTS = ACCESS | MODIFY | ATTRIB | CLOSE_WRITE
            | CLOSE_NOWRITE | OPEN | MOVED_FROM | MOVED_TO | DELETE | CREATE
            | DELETE_SELF | MOVE_SELF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "A78086BDBD05BA693E4888509D77A6CC", hash_generated_field = "AC0E7C3E561C767FDA353DB7657B76AD")

    private static final String LOG_TAG = "FileObserver";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.067 -0400", hash_original_field = "1DF9D582FDC2BF498B12523C6D0CEA43", hash_generated_field = "810470F71D04523E52A64C29782F9430")

    private static ObserverThread s_observerThread;
    static {
        s_observerThread = new ObserverThread();
        s_observerThread.start();
    }
    
}

