package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.HashMap;
public abstract class UEventObserver {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.738 -0400", hash_original_method = "DBB619BC345F9C7AE6106C9C9F6A9C1D", hash_generated_method = "DBB619BC345F9C7AE6106C9C9F6A9C1D")
    public UEventObserver ()
    {
        //Synthesized constructor
    }


    private static void native_setup() {
    }

    
    private static int next_event(byte[] buffer) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227850872 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227850872;
    }

    
    private static final synchronized void ensureThreadStarted() {
        if (sThreadStarted == false) {
            sThread = new UEventThread();
            sThread.start();
            sThreadStarted = true;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.742 -0400", hash_original_method = "CE89EFA30CD7E1D6B7DFDBD22A6CF8A2", hash_generated_method = "8455143F8A2B7FF2008A82D32A6F1F9E")
    public final synchronized void startObserving(String match) {
        addTaint(match.getTaint());
ensureThreadStarted()sThread.addObserver(match, this)
        // ---------- Original Method ----------
        //ensureThreadStarted();
        //sThread.addObserver(match, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.744 -0400", hash_original_method = "6F6E76F6EBDC6FFBE5DA2A881C7ADEF8", hash_generated_method = "FB28E9D7F87AFF19B7F5160291B176A8")
    public final synchronized void stopObserving() {
sThread.removeObserver(this)
        // ---------- Original Method ----------
        //sThread.removeObserver(this);
    }

    
    public abstract void onUEvent(UEvent event);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.746 -0400", hash_original_method = "A76EAA7F0E447E04C0468C64D2888F8D", hash_generated_method = "3166AF5EFFDE8D65BF15FF65F692FF28")
    protected void finalize() throws Throwable {
        try 
        {
stopObserving()
        } //End block
        finally 
        {
super.finalize()
        } //End block
        // ---------- Original Method ----------
        //try {
            //stopObserving();
        //} finally {
            //super.finalize();
        //}
    }

    
    static public class UEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.748 -0400", hash_original_field = "5DDD98D3433C6CBEC9205B7B35A2EA49", hash_generated_field = "C4FE5CE1066D6F29B4B9FA3A570315F1")

        public HashMap<String,String> mMap = new HashMap<String,String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.750 -0400", hash_original_method = "3CDE3274412CDEDD0F474EFD1B0CA04A", hash_generated_method = "4459773B4817497CEC21CAEB1CBBEA66")
        public  UEvent(String message) {
            addTaint(message.getTaint());
            int offset = 0;
            int length = message.length();
            while
(offset<length)            
            {
                int equals = message.indexOf('=', offset);
                int at = message.indexOf(0, offset);
                if(at<0)                
                break;
                if(equals>offset&&equals<at)                
                {
mMap.put(message.substring(offset, equals), message.substring(equals+1, at))
                } //End block
offset=at+1
            } //End block
            // ---------- Original Method ----------
            //int offset = 0;
            //int length = message.length();
            //while (offset < length) {
                //int equals = message.indexOf('=', offset);
                //int at = message.indexOf(0, offset);
                //if (at < 0) break;
                //if (equals > offset && equals < at) {
                    //mMap.put(message.substring(offset, equals),
                            //message.substring(equals + 1, at));
                //}
                //offset = at + 1;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.752 -0400", hash_original_method = "4BCD400EF6A3BABD5D1A20005C4F1016", hash_generated_method = "798DAC247C8F7AFF6D8D91241A55FFFE")
        public String get(String key) {
            addTaint(key.getTaint());
String var854B7A61C03CF753466A11AD5A6F683C_2053008366 = mMap.get(key)            var854B7A61C03CF753466A11AD5A6F683C_2053008366.addTaint(taint);
            return var854B7A61C03CF753466A11AD5A6F683C_2053008366;
            // ---------- Original Method ----------
            //return mMap.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.755 -0400", hash_original_method = "1B8B9EDC05287696A2108B9128ACCBB1", hash_generated_method = "C471D4757A0B6CB74936D6CAD013786A")
        public String get(String key, String defaultValue) {
            addTaint(defaultValue.getTaint());
            addTaint(key.getTaint());
            String result = mMap.get(key);
String varDD8DC949DB6F9D988E33E732E4FEC3D5_1287582478 = (result==null?defaultValue:defaultValue)            varDD8DC949DB6F9D988E33E732E4FEC3D5_1287582478.addTaint(taint);
            return varDD8DC949DB6F9D988E33E732E4FEC3D5_1287582478;
            // ---------- Original Method ----------
            //String result = mMap.get(key);
            //return (result == null ? defaultValue : result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.756 -0400", hash_original_method = "4B57D33D290F28B8D3CB24EB8115BFC8", hash_generated_method = "9A44B5AE556A01645200661934F919E6")
        public String toString() {
String var6060E263C327E21DF3A8204BD142E3B7_857585786 = mMap.toString()            var6060E263C327E21DF3A8204BD142E3B7_857585786.addTaint(taint);
            return var6060E263C327E21DF3A8204BD142E3B7_857585786;
            // ---------- Original Method ----------
            //return mMap.toString();
        }

        
    }


    
    private static class UEventThread extends Thread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.758 -0400", hash_original_field = "56E7670A93418ECC32C85F46E8820B4D", hash_generated_field = "2BFA983132DE3FC9182895936C020BBE")

        private ArrayList<Object> mObservers = new ArrayList<Object>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.758 -0400", hash_original_method = "4F36A64203A079DC607428FC68B825DD", hash_generated_method = "0E4EB15DDEEEB0E9297640A5D55F80E0")
          UEventThread() {
            super("UEventObserver");
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.760 -0400", hash_original_method = "AB85272443487C187ABBB017139E6418", hash_generated_method = "11AD6BAE74B4FB3735403703EEDBCC86")
        public void run() {
native_setup()            byte[] buffer = new byte[1024];
            int len;
            while
(true)            
            {
len=next_event(buffer)                if(len>0)                
                {
                    String bufferStr = new String(buffer, 0, len);
                    synchronized
(mObservers)                    {
for(int i = 0;i<mObservers.size();i+=2)
                        {
                            if(bufferStr.indexOf((String) mObservers.get(i))!=-1)                            
                            {
((UEventObserver) mObservers.get(i+1)).onUEvent(new UEvent(bufferStr))
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //native_setup();
            //byte[] buffer = new byte[1024];
            //int len;
            //while (true) {
                //len = next_event(buffer);
                //if (len > 0) {
                    //String bufferStr = new String(buffer, 0, len);  
                    //synchronized (mObservers) {
                        //for (int i = 0; i < mObservers.size(); i += 2) {
                            //if (bufferStr.indexOf((String)mObservers.get(i)) != -1) {
                                //((UEventObserver)mObservers.get(i+1))
                                        //.onUEvent(new UEvent(bufferStr));
                            //}
                        //}
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.762 -0400", hash_original_method = "26CDEFB7AA5C643341A28B7787CB2DA4", hash_generated_method = "9B2BF281BC1B636BC897FCB9BEC3BD34")
        public void addObserver(String match, UEventObserver observer) {
            addTaint(observer.getTaint());
            addTaint(match.getTaint());
            synchronized
(mObservers)            {
mObservers.add(match)mObservers.add(observer)
            } //End block
            // ---------- Original Method ----------
            //synchronized(mObservers) {
                //mObservers.add(match);
                //mObservers.add(observer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.764 -0400", hash_original_method = "96CF779B6B17D89292DE9C5D3AAD1FF2", hash_generated_method = "6434AD13E244F0DE87A73D6979A4CCC2")
        public void removeObserver(UEventObserver observer) {
            addTaint(observer.getTaint());
            synchronized
(mObservers)            {
                boolean found = true;
                while
(found)                
                {
found=falsefor(int i = 0;i<mObservers.size();i+=2)
                    {
                        if(mObservers.get(i+1)==observer)                        
                        {
mObservers.remove(i+1)mObservers.remove(i)found=true                            break;
                        } //End block
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized(mObservers) {
                //boolean found = true;
                //while (found) {
                    //found = false;
                    //for (int i = 0; i < mObservers.size(); i += 2) {
                        //if (mObservers.get(i+1) == observer) {
                            //mObservers.remove(i+1);
                            //mObservers.remove(i);
                            //found = true;
                            //break;
                        //}
                    //}
                //}
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.765 -0400", hash_original_field = "AF9AFA5451ADA9B6C1A1F679C5F539A8", hash_generated_field = "9B9B5B80005C346D9EE83A1364F9C57C")

    private static final String TAG = UEventObserver.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.765 -0400", hash_original_field = "4B16ED037169C5B135E33EB642EB5604", hash_generated_field = "DEC469943ACA430BEFECF62F1B249F29")

    private static UEventThread sThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.766 -0400", hash_original_field = "160DB3D755B6309924CE0720885B419E", hash_generated_field = "D28B58FBC86DCC8B2E94D2DF26F56973")

    private static boolean sThreadStarted = false;
}

