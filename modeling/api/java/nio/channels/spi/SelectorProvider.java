package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.SelectorProviderImpl;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ServiceLoader;

public abstract class SelectorProvider {

    /**
     * Gets a provider instance by executing the following steps when called for
     * the first time:
     * <ul>
     * <li> if the system property "java.nio.channels.spi.SelectorProvider" is
     * set, the value of this property is the class name of the provider
     * returned; </li>
     * <li>if there is a provider-configuration file named
     * "java.nio.channels.spi.SelectorProvider" in META-INF/services of a jar
     * file valid in the system class loader, the first class name is the
     * provider's class name; </li>
     * <li> otherwise, a system default provider will be returned.</li>
     * </ul>
     *
     * @return the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.276 -0500", hash_original_method = "CDAD760489E4CBA08CB762B57FD82B13", hash_generated_method = "9787BC8AEE542E1179EA15A898C61B68")
    
synchronized public static SelectorProvider provider() {
        if (provider == null) {
            provider = ServiceLoader.loadFromSystemProperty(SelectorProvider.class);
            if (provider == null) {
                provider = loadProviderByJar();
            }
            if (provider == null) {
                provider = new SelectorProviderImpl();
            }
        }
        return provider;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.279 -0500", hash_original_method = "C5D0C714A3BF8C6915C7636E13EEA7C7", hash_generated_method = "A60E27474069C0C3802B81F66A315C06")
    
private static SelectorProvider loadProviderByJar() {
        for (SelectorProvider provider : ServiceLoader.load(SelectorProvider.class)) {
            return provider;
        }
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.271 -0500", hash_original_field = "6B7D498973D24EE245B343DF130AA1D4", hash_generated_field = "D035C1A1A75D6145DD94D05B3D58FE60")

    private static SelectorProvider provider = null;

    /**
     * Constructs a new {@code SelectorProvider}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.274 -0500", hash_original_method = "DDE564F0B2C96394E14746CA546F5611", hash_generated_method = "39A5CB46BA9F7F74268BE7C809F20830")
    
protected SelectorProvider() {
    }

    /**
     * Creates a new open {@code DatagramChannel}.
     *
     * @return the new channel.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.281 -0500", hash_original_method = "6CE46028DFD2506BCD98D615EA62CDBE", hash_generated_method = "26779A042F4F3F7A51C52AAC48C8F131")
    
public abstract DatagramChannel openDatagramChannel() throws IOException;

    /**
     * Creates a new {@code Pipe}.
     *
     * @return the new pipe.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.284 -0500", hash_original_method = "9754760E4C5D79B353FBD42CC84376BC", hash_generated_method = "7975B1A8DC0ACD7AFE4EB92E7A2E26B9")
    
public abstract Pipe openPipe() throws IOException;

    /**
     * Creates a new selector.
     *
     * @return the new selector.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.287 -0500", hash_original_method = "33F302F02C9A0ABE6F822FDD9590DDB1", hash_generated_method = "CE2BE189B8E5DFD0DFA7167F12016B71")
    
public abstract AbstractSelector openSelector() throws IOException;

    /**
     * Creates a new open {@code ServerSocketChannel}.
     *
     * @return the new channel.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.289 -0500", hash_original_method = "FFADC8C36121EF0521C5D9B96AF17086", hash_generated_method = "BBBAC932364FF4BB6BA15E4406EEB5D2")
    
public abstract ServerSocketChannel openServerSocketChannel()
            throws IOException;

    /**
     * Create a new open {@code SocketChannel}.
     *
     * @return the new channel.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.291 -0500", hash_original_method = "A9809723489DBB26BCC3B12B8A96DD26", hash_generated_method = "7FA0C3464F045FA28D2329D892FFD7E5")
    
public abstract SocketChannel openSocketChannel() throws IOException;

    /**
     * Returns the channel inherited from the process that created this VM.
     * On Android, this method always returns null because stdin and stdout are
     * never connected to a socket.
     *
     * @return the channel.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.293 -0500", hash_original_method = "1567929400994F6BBA42155A37789D93", hash_generated_method = "4BA794C5047799A4E3981E4D72C62B15")
    
public Channel inheritedChannel() throws IOException {
        // Android never has stdin/stdout connected to a socket.
        return null;
    }
}

