package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.FileDescriptor;

public class LocalServerSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.105 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "9FC425CCAE80D9162FEB6CEC3E95B3C0")

    private LocalSocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.106 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "998A409B350B5C2296F10AA66491F7E9")

    private LocalSocketAddress localAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.113 -0400", hash_original_method = "84F635671A3C26E6B4F1228C3E17A491", hash_generated_method = "DD52E8915043550996201692E0D59419")
    public  LocalServerSocket(String name) throws IOException {
        impl = new LocalSocketImpl();
        impl.create(true);
        localAddress = new LocalSocketAddress(name);
        impl.bind(localAddress);
        impl.listen(LISTEN_BACKLOG);
        // ---------- Original Method ----------
        //impl = new LocalSocketImpl();
        //impl.create(true);
        //localAddress = new LocalSocketAddress(name);
        //impl.bind(localAddress);
        //impl.listen(LISTEN_BACKLOG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.114 -0400", hash_original_method = "40EEF7A0A264136F662D7E1DA715A559", hash_generated_method = "EB25BDE0A8F69F77601A4FBFE2F2404A")
    public  LocalServerSocket(FileDescriptor fd) throws IOException {
        impl = new LocalSocketImpl(fd);
        impl.listen(LISTEN_BACKLOG);
        localAddress = impl.getSockAddress();
        // ---------- Original Method ----------
        //impl = new LocalSocketImpl(fd);
        //impl.listen(LISTEN_BACKLOG);
        //localAddress = impl.getSockAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.118 -0400", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "AE9253B3E8C3E9838D1F0E40BEEC220A")
    public LocalSocketAddress getLocalSocketAddress() {
        LocalSocketAddress varB4EAC82CA7396A68D541C85D26508E83_133583872 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_133583872 = localAddress;
        varB4EAC82CA7396A68D541C85D26508E83_133583872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_133583872;
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.128 -0400", hash_original_method = "4C7BE72C58D9A70D111AB53708810EA4", hash_generated_method = "BAB3889C7C1E9C7B03482AD99B8B5E44")
    public LocalSocket accept() throws IOException {
        LocalSocket varB4EAC82CA7396A68D541C85D26508E83_12868774 = null; //Variable for return #1
        LocalSocketImpl acceptedImpl;
        acceptedImpl = new LocalSocketImpl();
        impl.accept (acceptedImpl);
        varB4EAC82CA7396A68D541C85D26508E83_12868774 = new LocalSocket(acceptedImpl);
        varB4EAC82CA7396A68D541C85D26508E83_12868774.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_12868774;
        // ---------- Original Method ----------
        //LocalSocketImpl acceptedImpl = new LocalSocketImpl();
        //impl.accept (acceptedImpl);
        //return new LocalSocket(acceptedImpl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.129 -0400", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "CC1A4A2E1A9F9E7035CF632FC90EB590")
    public FileDescriptor getFileDescriptor() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_503063978 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_503063978 = impl.getFileDescriptor();
        varB4EAC82CA7396A68D541C85D26508E83_503063978.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_503063978;
        // ---------- Original Method ----------
        //return impl.getFileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.144 -0400", hash_original_method = "CB913E335DEA23070E332AEE6AD401FB", hash_generated_method = "12F0B4AF8EE7B599F14465C727089231")
    public void close() throws IOException {
        impl.close();
        // ---------- Original Method ----------
        //impl.close();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.144 -0400", hash_original_field = "EA62F79E6D0E6E18A741F57CCDFCE5F9", hash_generated_field = "ECAC6AA2FDCE19340104986AF0298CEF")

    private static int LISTEN_BACKLOG = 50;
}

