package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.FileDescriptor;

public class LocalServerSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.515 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "9FC425CCAE80D9162FEB6CEC3E95B3C0")

    private LocalSocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.515 -0400", hash_original_field = "5C73038C2146DC3AED672FCA3B0ADB95", hash_generated_field = "998A409B350B5C2296F10AA66491F7E9")

    private LocalSocketAddress localAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.516 -0400", hash_original_method = "84F635671A3C26E6B4F1228C3E17A491", hash_generated_method = "DD52E8915043550996201692E0D59419")
    public  LocalServerSocket(String name) throws IOException {
        impl = new LocalSocketImpl();
        impl.create(true);
        localAddress = new LocalSocketAddress(name);
        impl.bind(localAddress);
        impl.listen(LISTEN_BACKLOG);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.517 -0400", hash_original_method = "40EEF7A0A264136F662D7E1DA715A559", hash_generated_method = "EB25BDE0A8F69F77601A4FBFE2F2404A")
    public  LocalServerSocket(FileDescriptor fd) throws IOException {
        impl = new LocalSocketImpl(fd);
        impl.listen(LISTEN_BACKLOG);
        localAddress = impl.getSockAddress();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.518 -0400", hash_original_method = "E608923787A6482FF0ABAB03074C01F6", hash_generated_method = "90742025E434A3573D4978F65CA5AE8D")
    public LocalSocketAddress getLocalSocketAddress() {
LocalSocketAddress varAD2ECC3D59386A6CEBDBFE5B70B7F72A_1251121402 =         localAddress;
        varAD2ECC3D59386A6CEBDBFE5B70B7F72A_1251121402.addTaint(taint);
        return varAD2ECC3D59386A6CEBDBFE5B70B7F72A_1251121402;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.519 -0400", hash_original_method = "4C7BE72C58D9A70D111AB53708810EA4", hash_generated_method = "6418BD4D4D30E253F0AB4AEE8B33224B")
    public LocalSocket accept() throws IOException {
        LocalSocketImpl acceptedImpl = new LocalSocketImpl();
        impl.accept (acceptedImpl);
LocalSocket var81615AF6EA73F8A8262A88467A8E1AF9_1525656247 =         new LocalSocket(acceptedImpl);
        var81615AF6EA73F8A8262A88467A8E1AF9_1525656247.addTaint(taint);
        return var81615AF6EA73F8A8262A88467A8E1AF9_1525656247;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.519 -0400", hash_original_method = "48E5039C4FB2B8BAB81B3561EAA65E0E", hash_generated_method = "999A068CB05C74445839A804827F9795")
    public FileDescriptor getFileDescriptor() {
FileDescriptor var05E29FE12AB06423EE2D8B05D08F76BE_1423846540 =         impl.getFileDescriptor();
        var05E29FE12AB06423EE2D8B05D08F76BE_1423846540.addTaint(taint);
        return var05E29FE12AB06423EE2D8B05D08F76BE_1423846540;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.519 -0400", hash_original_method = "CB913E335DEA23070E332AEE6AD401FB", hash_generated_method = "12F0B4AF8EE7B599F14465C727089231")
    public void close() throws IOException {
        impl.close();
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.520 -0400", hash_original_field = "EA62F79E6D0E6E18A741F57CCDFCE5F9", hash_generated_field = "CF3B17719A06AE9E2539F6BC60A2C73B")

    private static final int LISTEN_BACKLOG = 50;
}

