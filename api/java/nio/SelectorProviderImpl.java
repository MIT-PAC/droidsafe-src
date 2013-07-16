package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;

public final class SelectorProviderImpl extends SelectorProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.285 -0400", hash_original_method = "0FAD76CB1DA362BA4B44B65B1490E94B", hash_generated_method = "0FAD76CB1DA362BA4B44B65B1490E94B")
    public SelectorProviderImpl ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.285 -0400", hash_original_method = "387A5A2577212A6C1EA1C3C9B72655AF", hash_generated_method = "03430E330E0F22E324BA91FB8564F368")
    public DatagramChannel openDatagramChannel() throws IOException {
DatagramChannel varAF3335D755E3351CD64D95455619BEA7_325145162 =         new DatagramChannelImpl(this);
        varAF3335D755E3351CD64D95455619BEA7_325145162.addTaint(taint);
        return varAF3335D755E3351CD64D95455619BEA7_325145162;
        // ---------- Original Method ----------
        //return new DatagramChannelImpl(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.286 -0400", hash_original_method = "2F15CF0A5D0F2155005284DE3BE9BD3D", hash_generated_method = "DC5BDA7B5EEF9D587268AC4B1995F620")
    public Pipe openPipe() throws IOException {
Pipe varB1A7AB7499256E51DCEBE9E405C1F09B_305416229 =         new PipeImpl();
        varB1A7AB7499256E51DCEBE9E405C1F09B_305416229.addTaint(taint);
        return varB1A7AB7499256E51DCEBE9E405C1F09B_305416229;
        // ---------- Original Method ----------
        //return new PipeImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.286 -0400", hash_original_method = "7F763A0354A8071A63016F4A050A4598", hash_generated_method = "D4F1EFED523013F238AF345B4419F234")
    public AbstractSelector openSelector() throws IOException {
AbstractSelector varD6153CA6D598C06006942B13CC2A7E1A_1335777011 =         new SelectorImpl(this);
        varD6153CA6D598C06006942B13CC2A7E1A_1335777011.addTaint(taint);
        return varD6153CA6D598C06006942B13CC2A7E1A_1335777011;
        // ---------- Original Method ----------
        //return new SelectorImpl(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.286 -0400", hash_original_method = "775977081681050F27E8E3BC6B50B017", hash_generated_method = "0299F89F37EDB1A0374ABF9C6DF54357")
    public ServerSocketChannel openServerSocketChannel() throws IOException {
ServerSocketChannel var4DCD84F5EA5722C3E1DDA85169A11769_743416157 =         new ServerSocketChannelImpl(this);
        var4DCD84F5EA5722C3E1DDA85169A11769_743416157.addTaint(taint);
        return var4DCD84F5EA5722C3E1DDA85169A11769_743416157;
        // ---------- Original Method ----------
        //return new ServerSocketChannelImpl(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.287 -0400", hash_original_method = "7755F9A94A84671924AAF38559CE588E", hash_generated_method = "B002DE9576EC02C78EF1C93EC8FA7C8C")
    public SocketChannel openSocketChannel() throws IOException {
SocketChannel var9A4D98B5539519F42FDA225F92D65D54_1273951250 =         new SocketChannelImpl(this);
        var9A4D98B5539519F42FDA225F92D65D54_1273951250.addTaint(taint);
        return var9A4D98B5539519F42FDA225F92D65D54_1273951250;
        // ---------- Original Method ----------
        //return new SocketChannelImpl(this);
    }

    
}

