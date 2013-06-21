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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.270 -0400", hash_original_method = "812A9349863627E70167D132A9886EDC", hash_generated_method = "812A9349863627E70167D132A9886EDC")
        public SocketTagger ()
    {
    }


    public abstract void tag(FileDescriptor socketDescriptor) throws SocketException;

    
    public abstract void untag(FileDescriptor socketDescriptor) throws SocketException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.271 -0400", hash_original_method = "6DADFCEFEAC71C05F27C21DEA87D02DB", hash_generated_method = "627FA728A9A0999D9C06B363884628E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void tag(Socket socket) throws SocketException {
        dsTaint.addTaint(socket.dsTaint);
        {
            boolean varD46A2716AEC08881570CED6916EA1310_792968967 = (!socket.isClosed());
            {
                tag(socket.getFileDescriptor$());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!socket.isClosed()) {
            //tag(socket.getFileDescriptor$());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.271 -0400", hash_original_method = "54DD0CF9051E663B674E2F8CC129A4E5", hash_generated_method = "90F7935F866EA09648703786C09837F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void untag(Socket socket) throws SocketException {
        dsTaint.addTaint(socket.dsTaint);
        {
            boolean varD46A2716AEC08881570CED6916EA1310_1399768816 = (!socket.isClosed());
            {
                untag(socket.getFileDescriptor$());
            } //End block
        } //End collapsed parenthetic
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

    
    private static SocketTagger tagger = new SocketTagger() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.272 -0400", hash_original_method = "8328599569196B30B389F2CEF15714B9", hash_generated_method = "6C893ABCAC0860A6A44925F992463F35")
        @DSModeled(DSC.SAFE)
        @Override
        public void tag(FileDescriptor socketDescriptor) throws SocketException {
            dsTaint.addTaint(socketDescriptor.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.272 -0400", hash_original_method = "47AD6090A21FCA2559F757EDA52B92F0", hash_generated_method = "B14122190A3C2D862AEFB455418F53E7")
        @DSModeled(DSC.SAFE)
        @Override
        public void untag(FileDescriptor socketDescriptor) throws SocketException {
            dsTaint.addTaint(socketDescriptor.dsTaint);
            // ---------- Original Method ----------
        }

        
}; //Transformed anonymous class
}

