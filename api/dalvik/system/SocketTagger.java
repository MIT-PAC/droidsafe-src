package dalvik.system;

// Droidsafe Imports
import java.io.FileDescriptor;
import java.net.Socket;
import java.net.SocketException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class SocketTagger {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.818 -0400", hash_original_method = "3FCBFB017A056A47E7F458C1C015DE98", hash_generated_method = "3FCBFB017A056A47E7F458C1C015DE98")
    public SocketTagger ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    public abstract void tag(FileDescriptor socketDescriptor) throws SocketException;

    
    @DSModeled(DSC.BAN)
    public abstract void untag(FileDescriptor socketDescriptor) throws SocketException;

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.819 -0400", hash_original_method = "6DADFCEFEAC71C05F27C21DEA87D02DB", hash_generated_method = "DDC00633D2D9EC1D94B2A8F60DC571AB")
    public final void tag(Socket socket) throws SocketException {
        addTaint(socket.getTaint());
        if(!socket.isClosed())        
        {
            tag(socket.getFileDescriptor$());
        } //End block
        // ---------- Original Method ----------
        //if (!socket.isClosed()) {
            //tag(socket.getFileDescriptor$());
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.819 -0400", hash_original_method = "54DD0CF9051E663B674E2F8CC129A4E5", hash_generated_method = "11DB0139D656E16CF8014AF5BA170B57")
    public final void untag(Socket socket) throws SocketException {
        addTaint(socket.getTaint());
        if(!socket.isClosed())        
        {
            untag(socket.getFileDescriptor$());
        } //End block
        // ---------- Original Method ----------
        //if (!socket.isClosed()) {
            //untag(socket.getFileDescriptor$());
        //}
    }

    
    @DSModeled(DSC.BAN)
    public static synchronized void set(SocketTagger tagger) {
        if (tagger == null) {
            throw new NullPointerException("tagger == null");
        }
        SocketTagger.tagger = tagger;
    }

    
    @DSModeled(DSC.BAN)
    public static synchronized SocketTagger get() {
        return tagger;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.778 -0400", hash_original_field = "B97DCF68D320E085515A8D2144D4C814", hash_generated_field = "23BEE6B2224CB13CE066B2939D5005AD")

    private static SocketTagger tagger = new SocketTagger() {        
        @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.778 -0400", hash_original_method = "8328599569196B30B389F2CEF15714B9", hash_generated_method = "464053965BAB7380A18FB745C85C07DF")
        @Override
        public void tag(FileDescriptor socketDescriptor) throws SocketException {
            addTaint(socketDescriptor.getTaint());
            
        }

        
        @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.778 -0400", hash_original_method = "47AD6090A21FCA2559F757EDA52B92F0", hash_generated_method = "90FFA01302CC5CF4A2BB81B5E73337A0")
        @Override
        public void untag(FileDescriptor socketDescriptor) throws SocketException {
            addTaint(socketDescriptor.getTaint());
            
        }

        
};
}

