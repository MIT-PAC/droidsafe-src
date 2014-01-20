package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.net.Socket;
import java.net.SocketException;

public abstract class SocketTagger {

    /**
     * Sets this process' socket tagger to {@code tagger}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.450 -0500", hash_original_method = "EDEE55D75359311904AE78EC5039AEA8", hash_generated_method = "556290A77FEED0E42DE5ED0FAA7F3D27")
    
public static synchronized void set(SocketTagger tagger) {
        if (tagger == null) {
            throw new NullPointerException("tagger == null");
        }
        SocketTagger.tagger = tagger;
    }

    /**
     * Returns this process socket tagger.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.453 -0500", hash_original_method = "87B6FC7B35B939DE64706833D2FA396B", hash_generated_method = "9C72E2DCC2A6309C30FA4649268C0529")
    
public static synchronized SocketTagger get() {
        return tagger;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.778 -0400", hash_original_field = "B97DCF68D320E085515A8D2144D4C814", hash_generated_field = "23BEE6B2224CB13CE066B2939D5005AD")

    private static SocketTagger tagger = new SocketTagger() {
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.778 -0400", hash_original_method = "8328599569196B30B389F2CEF15714B9", hash_generated_method = "464053965BAB7380A18FB745C85C07DF")
        @Override
        public void tag(FileDescriptor socketDescriptor) throws SocketException {
            addTaint(socketDescriptor.getTaint());
            
        }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.778 -0400", hash_original_method = "47AD6090A21FCA2559F757EDA52B92F0", hash_generated_method = "90FFA01302CC5CF4A2BB81B5E73337A0")
        @Override
        public void untag(FileDescriptor socketDescriptor) throws SocketException {
            addTaint(socketDescriptor.getTaint());
            
        }
        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.818 -0400", hash_original_method = "3FCBFB017A056A47E7F458C1C015DE98", hash_generated_method = "3FCBFB017A056A47E7F458C1C015DE98")
    public SocketTagger ()
    {
        //Synthesized constructor
    }

    /**
     * Notified when {@code socketDescriptor} is either assigned to the current
     * thread. The socket is either newly connected or reused from a connection
     * pool. Implementations of this method should be thread-safe.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.439 -0500", hash_original_method = "9BD43B1E2CFC27D090627A116B518176", hash_generated_method = "227AD56C5F547C039B73864DE505A308")
    
public abstract void tag(FileDescriptor socketDescriptor) throws SocketException;

    /**
     * Notified when {@code socketDescriptor} is released from the current
     * thread to a connection pool. Implementations of this method should be
     * thread-safe.
     *
     * <p><strong>Note:</strong> this method will not be invoked when the socket
     * is closed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.442 -0500", hash_original_method = "2BF068569797F0DFBCD6691D25ACF08F", hash_generated_method = "5FD01BB243B453B61CFC5CA4C40FE711")
    
public abstract void untag(FileDescriptor socketDescriptor) throws SocketException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.444 -0500", hash_original_method = "6DADFCEFEAC71C05F27C21DEA87D02DB", hash_generated_method = "A6AE8C55ABFE6600DC9D40F98777FC21")
    
public final void tag(Socket socket) throws SocketException {
        if (!socket.isClosed()) {
            tag(socket.getFileDescriptor$());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.447 -0500", hash_original_method = "54DD0CF9051E663B674E2F8CC129A4E5", hash_generated_method = "FBDBD394A5D541F6E6E3D157E3F24C99")
    
public final void untag(Socket socket) throws SocketException {
        if (!socket.isClosed()) {
            untag(socket.getFileDescriptor$());
        }
    }
}

