package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.FileDescriptor;

public class LocalServerSocket {
    private final LocalSocketImpl impl;
    private final LocalSocketAddress localAddress;
    private static final int LISTEN_BACKLOG = 50;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.168 -0400", hash_original_method = "84F635671A3C26E6B4F1228C3E17A491", hash_generated_method = "D6F1C9CE51EB76582EC08A9D807AE717")
    @DSModeled(DSC.SAFE)
    public LocalServerSocket(String name) throws IOException {
        dsTaint.addTaint(name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.168 -0400", hash_original_method = "40EEF7A0A264136F662D7E1DA715A559", hash_generated_method = "A7A2F06900FF8553997B54ED4654C63E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LocalServerSocket(FileDescriptor fd) throws IOException {
        dsTaint.addTaint(fd.dsTaint);
        impl = new LocalSocketImpl(fd);
        impl.listen(LISTEN_BACKLOG);
        localAddress = impl.getSockAddress();
        // ---------- Original Method ----------
        //impl = new LocalSocketImpl(fd);
        //impl.listen(LISTEN_BACKLOG);
        //localAddress = impl.getSockAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.168 -0400", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "295AAD31235F8E1D6C123196F3CC7C95")
    @DSModeled(DSC.SAFE)
    public LocalSocketAddress getLocalSocketAddress() {
        return (LocalSocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.168 -0400", hash_original_method = "4C7BE72C58D9A70D111AB53708810EA4", hash_generated_method = "A746C883547CD36A167C5DB745EFC761")
    @DSModeled(DSC.SAFE)
    public LocalSocket accept() throws IOException {
        LocalSocketImpl acceptedImpl;
        acceptedImpl = new LocalSocketImpl();
        impl.accept (acceptedImpl);
        return (LocalSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LocalSocketImpl acceptedImpl = new LocalSocketImpl();
        //impl.accept (acceptedImpl);
        //return new LocalSocket(acceptedImpl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.168 -0400", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "5B9C29BCF0AB179F553A1BF11008E860")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor getFileDescriptor() {
        FileDescriptor var597D4329ABDF8C84D1288615FE8B9EEF_769455902 = (impl.getFileDescriptor());
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.getFileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.168 -0400", hash_original_method = "CB913E335DEA23070E332AEE6AD401FB", hash_generated_method = "9189A0539F108EC8E07FA6018FBCB64B")
    @DSModeled(DSC.SAFE)
    public void close() throws IOException {
        impl.close();
        // ---------- Original Method ----------
        //impl.close();
    }

    
}


