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
    private LocalSocketImpl impl;
    private LocalSocketAddress localAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.994 -0400", hash_original_method = "84F635671A3C26E6B4F1228C3E17A491", hash_generated_method = "BDF6F2E54762D6C4E4DA97F02F8AE1F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.995 -0400", hash_original_method = "40EEF7A0A264136F662D7E1DA715A559", hash_generated_method = "6C78E6015C22B19262B79C79625C9361")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.996 -0400", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "BE860574D1B1ABDB65C919B33068F998")
    @DSModeled(DSC.SAFE)
    public LocalSocketAddress getLocalSocketAddress() {
        return (LocalSocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return localAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.996 -0400", hash_original_method = "4C7BE72C58D9A70D111AB53708810EA4", hash_generated_method = "634E546D19B2983566EFE35B8CC2A9E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LocalSocket accept() throws IOException {
        LocalSocketImpl acceptedImpl;
        acceptedImpl = new LocalSocketImpl();
        impl.accept (acceptedImpl);
        LocalSocket var7E8CD8CBC9F75AE5CAD7E08818260DC1_274165112 = (new LocalSocket(acceptedImpl));
        return (LocalSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LocalSocketImpl acceptedImpl = new LocalSocketImpl();
        //impl.accept (acceptedImpl);
        //return new LocalSocket(acceptedImpl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.997 -0400", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "4039E73A9BCDC9D70EDCDEC273B2296C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor getFileDescriptor() {
        FileDescriptor var597D4329ABDF8C84D1288615FE8B9EEF_835634685 = (impl.getFileDescriptor());
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.getFileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.997 -0400", hash_original_method = "CB913E335DEA23070E332AEE6AD401FB", hash_generated_method = "12F0B4AF8EE7B599F14465C727089231")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        impl.close();
        // ---------- Original Method ----------
        //impl.close();
    }

    
    private static final int LISTEN_BACKLOG = 50;
}

