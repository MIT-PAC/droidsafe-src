package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.net.Socket;
import java.net.SocketException;

public abstract class SocketTagger {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.427 -0400", hash_original_method = "3FCBFB017A056A47E7F458C1C015DE98", hash_generated_method = "3FCBFB017A056A47E7F458C1C015DE98")
    public SocketTagger ()
    {
        //Synthesized constructor
    }


    public abstract void tag(FileDescriptor socketDescriptor) throws SocketException;

    
    public abstract void untag(FileDescriptor socketDescriptor) throws SocketException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.428 -0400", hash_original_method = "6DADFCEFEAC71C05F27C21DEA87D02DB", hash_generated_method = "D4A845F06CA51E3A53D5434536FFE26B")
    public final void tag(Socket socket) throws SocketException {
        {
            boolean varD46A2716AEC08881570CED6916EA1310_51806102 = (!socket.isClosed());
            {
                tag(socket.getFileDescriptor$());
            } //End block
        } //End collapsed parenthetic
        addTaint(socket.getTaint());
        // ---------- Original Method ----------
        //if (!socket.isClosed()) {
            //tag(socket.getFileDescriptor$());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.428 -0400", hash_original_method = "54DD0CF9051E663B674E2F8CC129A4E5", hash_generated_method = "9D912F28F693E2A2F5835FC33D1AC142")
    public final void untag(Socket socket) throws SocketException {
        {
            boolean varD46A2716AEC08881570CED6916EA1310_892566446 = (!socket.isClosed());
            {
                untag(socket.getFileDescriptor$());
            } //End block
        } //End collapsed parenthetic
        addTaint(socket.getTaint());
        // ---------- Original Method ----------
        //if (!socket.isClosed()) {
            //untag(socket.getFileDescriptor$());
        //}
    }

    
        public static synchronized void set(SocketTagger tagger) {
        if (tagger == null) {
            throw new NullPointerException("tagger == null");
        }
        SocketTagger.tagger = tagger;
    }

    
        public static synchronized SocketTagger get() {
        return tagger;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.436 -0400", hash_original_field = "B97DCF68D320E085515A8D2144D4C814", hash_generated_field = "9BDB39D6F4E2967BA8B88CF4364EB904")

    private static SocketTagger tagger = new SocketTagger() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.436 -0400", hash_original_method = "8328599569196B30B389F2CEF15714B9", hash_generated_method = "464053965BAB7380A18FB745C85C07DF")
        @Override
        public void tag(FileDescriptor socketDescriptor) throws SocketException {
            addTaint(socketDescriptor.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.436 -0400", hash_original_method = "47AD6090A21FCA2559F757EDA52B92F0", hash_generated_method = "90FFA01302CC5CF4A2BB81B5E73337A0")
        @Override
        public void untag(FileDescriptor socketDescriptor) throws SocketException {
            addTaint(socketDescriptor.getTaint());
            // ---------- Original Method ----------
        }

        
};
}

