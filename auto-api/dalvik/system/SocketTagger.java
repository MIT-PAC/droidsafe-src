package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.FileDescriptor;
import java.net.Socket;
import java.net.SocketException;

public abstract class SocketTagger {
    private static SocketTagger tagger = new SocketTagger() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.342 -0400", hash_original_method = "8328599569196B30B389F2CEF15714B9", hash_generated_method = "89EC89F46CF43AD8325A780F10C4981E")
        @DSModeled(DSC.SAFE)
        @Override
        public void tag(FileDescriptor socketDescriptor) throws SocketException {
            dsTaint.addTaint(socketDescriptor.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.342 -0400", hash_original_method = "47AD6090A21FCA2559F757EDA52B92F0", hash_generated_method = "B987335B3156DA9F23D96728A751AFC2")
        @DSModeled(DSC.SAFE)
        @Override
        public void untag(FileDescriptor socketDescriptor) throws SocketException {
            dsTaint.addTaint(socketDescriptor.dsTaint);
            // ---------- Original Method ----------
        }

        
}; //Transformed anonymous class
    
    public abstract void tag(FileDescriptor socketDescriptor) throws SocketException;

    
    public abstract void untag(FileDescriptor socketDescriptor) throws SocketException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.342 -0400", hash_original_method = "6DADFCEFEAC71C05F27C21DEA87D02DB", hash_generated_method = "E25DA84F6011EBF539EDD72B8E19A72D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void tag(Socket socket) throws SocketException {
        dsTaint.addTaint(socket.dsTaint);
        {
            boolean varD46A2716AEC08881570CED6916EA1310_598071680 = (!socket.isClosed());
            {
                tag(socket.getFileDescriptor$());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!socket.isClosed()) {
            //tag(socket.getFileDescriptor$());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.343 -0400", hash_original_method = "54DD0CF9051E663B674E2F8CC129A4E5", hash_generated_method = "153B6503FFEC5CBF78A3931868FE7946")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void untag(Socket socket) throws SocketException {
        dsTaint.addTaint(socket.dsTaint);
        {
            boolean varD46A2716AEC08881570CED6916EA1310_271817517 = (!socket.isClosed());
            {
                untag(socket.getFileDescriptor$());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!socket.isClosed()) {
            //untag(socket.getFileDescriptor$());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.343 -0400", hash_original_method = "EDEE55D75359311904AE78EC5039AEA8", hash_generated_method = "556290A77FEED0E42DE5ED0FAA7F3D27")
    public static synchronized void set(SocketTagger tagger) {
        if (tagger == null) {
            throw new NullPointerException("tagger == null");
        }
        SocketTagger.tagger = tagger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.343 -0400", hash_original_method = "87B6FC7B35B939DE64706833D2FA396B", hash_generated_method = "9C72E2DCC2A6309C30FA4649268C0529")
    public static synchronized SocketTagger get() {
        return tagger;
    }

    
}


