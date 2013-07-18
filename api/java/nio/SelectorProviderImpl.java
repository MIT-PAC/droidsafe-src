package java.nio;

// Droidsafe Imports
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class SelectorProviderImpl extends SelectorProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.908 -0400", hash_original_method = "0FAD76CB1DA362BA4B44B65B1490E94B", hash_generated_method = "0FAD76CB1DA362BA4B44B65B1490E94B")
    public SelectorProviderImpl ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.908 -0400", hash_original_method = "387A5A2577212A6C1EA1C3C9B72655AF", hash_generated_method = "01A5B5D3E20FE01A1D96049C30622EA8")
    public DatagramChannel openDatagramChannel() throws IOException {
DatagramChannel varAF3335D755E3351CD64D95455619BEA7_1708079017 =         new DatagramChannelImpl(this);
        varAF3335D755E3351CD64D95455619BEA7_1708079017.addTaint(taint);
        return varAF3335D755E3351CD64D95455619BEA7_1708079017;
        // ---------- Original Method ----------
        //return new DatagramChannelImpl(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.908 -0400", hash_original_method = "2F15CF0A5D0F2155005284DE3BE9BD3D", hash_generated_method = "DF16D38559A1C00F9F349F1C404DA564")
    public Pipe openPipe() throws IOException {
Pipe varB1A7AB7499256E51DCEBE9E405C1F09B_874722881 =         new PipeImpl();
        varB1A7AB7499256E51DCEBE9E405C1F09B_874722881.addTaint(taint);
        return varB1A7AB7499256E51DCEBE9E405C1F09B_874722881;
        // ---------- Original Method ----------
        //return new PipeImpl();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.908 -0400", hash_original_method = "7F763A0354A8071A63016F4A050A4598", hash_generated_method = "85EF6B73E854C45BFF36E6D96C0F6C60")
    public AbstractSelector openSelector() throws IOException {
AbstractSelector varD6153CA6D598C06006942B13CC2A7E1A_584468261 =         new SelectorImpl(this);
        varD6153CA6D598C06006942B13CC2A7E1A_584468261.addTaint(taint);
        return varD6153CA6D598C06006942B13CC2A7E1A_584468261;
        // ---------- Original Method ----------
        //return new SelectorImpl(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.909 -0400", hash_original_method = "775977081681050F27E8E3BC6B50B017", hash_generated_method = "61B24D861381BC5B6175466ABA344557")
    public ServerSocketChannel openServerSocketChannel() throws IOException {
ServerSocketChannel var4DCD84F5EA5722C3E1DDA85169A11769_2139307509 =         new ServerSocketChannelImpl(this);
        var4DCD84F5EA5722C3E1DDA85169A11769_2139307509.addTaint(taint);
        return var4DCD84F5EA5722C3E1DDA85169A11769_2139307509;
        // ---------- Original Method ----------
        //return new ServerSocketChannelImpl(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.909 -0400", hash_original_method = "7755F9A94A84671924AAF38559CE588E", hash_generated_method = "B13DEB9C924B5DCE7AFBF5A44B8B9F95")
    public SocketChannel openSocketChannel() throws IOException {
SocketChannel var9A4D98B5539519F42FDA225F92D65D54_354140246 =         new SocketChannelImpl(this);
        var9A4D98B5539519F42FDA225F92D65D54_354140246.addTaint(taint);
        return var9A4D98B5539519F42FDA225F92D65D54_354140246;
        // ---------- Original Method ----------
        //return new SocketChannelImpl(this);
    }

    
}

