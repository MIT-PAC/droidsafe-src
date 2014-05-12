package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import javax.net.ssl.SSLException;

public final class SSLSocketInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.694 -0500", hash_original_field = "277DA66AE6A07AC9858104D25DCF4EE3", hash_generated_field = "5DBC1BD0478978FB5C08FDF3A66AC7FD")

    // It should not be less than maximum data chunk enclosed
    // in one ssl packet.
    private static final int BUFFER_SIZE = SSLRecordProtocol.MAX_DATA_LENGTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.696 -0500", hash_original_field = "002ED5219400014D7E06D2ED374D1F8F", hash_generated_field = "282EEB2007797BAF8E0177A8CE143E9E")

    private byte[] buffer = new byte[BUFFER_SIZE];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.698 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.701 -0500", hash_original_field = "302E5A3147803830441A79AED31F4022", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.703 -0500", hash_original_field = "09345289E0F08ED39AA376881C5DC943", hash_generated_field = "FC855125850BB72054AAC77176B58208")

    private  SSLSocketImpl owner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.706 -0500", hash_original_field = "FEB5C953351099C8EE48E60CFEBFC21B", hash_generated_field = "929F57A2C97BF3A19086FCEB77B5EEEF")

    // has been reached
    private boolean end_reached = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.711 -0500", hash_original_field = "BCB4A0F890186AB6C4C174795B59052C", hash_generated_field = "ABB2CE89E11F7FB8542D3FE9B7058434")

    protected Adapter dataPoint = new Adapter();

    /**
     * Creates the application data input stream for specified socket.
     * @param   owner the socket which will provide this input stream
     * to client applications.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.708 -0500", hash_original_method = "2B2DE235A31ECF6D427ED4CC1BA78F0B", hash_generated_method = "BABE2D99577BBBDD84C82A81744F7046")
    
protected SSLSocketInputStream(SSLSocketImpl owner) {
        this.owner = owner;
    }

    /**
     * Tells to the stream that the end of the income data has
     * been reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.713 -0500", hash_original_method = "A09BD0FC7A641BF0B6392C48D9B80DDB", hash_generated_method = "F0ACBF3C1C8A24A981F352A81B41A9CF")
    
protected void setEnd() {
        end_reached = true;
    }

    // ------------------ InputStream implementation -------------------

    /**
     * Returns the number of bytes available for reading without blocking.
     * @return the number of available bytes.
     * @throws  IOException
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.715 -0500", hash_original_method = "32329B6D4EFC7F65437C2D09A5400721", hash_generated_method = "7B6C0E97C0EA9A758302804A5C5B251B")
    
@Override
    public int available() throws IOException {
        return end - pos;
    }

    /**
     * Closes the stream
     * @throws  IOException
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.718 -0500", hash_original_method = "B0B2FCB9CE6FDF4EA578715FA3754421", hash_generated_method = "3FC5DF76B8480C3D8AA91CEAB9060C0C")
    
@Override
    public void close() throws IOException {
        buffer = null;
    }

    /**
     * Reads one byte. If there is no data in the underlying buffer,
     * this operation can block until the data will be
     * available.
     * @return read value.
     * @throws  IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.720 -0500", hash_original_method = "92F5EAFF00040EF543528D1059933772", hash_generated_method = "7FD93B48818FA167E312FB737B2A4BEA")
    
@Override
    public int read() throws IOException {
        if (buffer == null) {
            throw new IOException("Stream was closed.");
        }
        while (pos == end) {
            if (end_reached) {
                return -1;
            }
            // If there is no data in the buffer
            // - will block until the data will be provided by
            // record layer
            owner.needAppData();
        }
        return buffer[pos++] & 0xFF;
    }
    
    private class Adapter implements org.apache.harmony.xnet.provider.jsse.Appendable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.576 -0400", hash_original_method = "740A355E7DE5D3F2D284C3985F05A62D", hash_generated_method = "740A355E7DE5D3F2D284C3985F05A62D")
        public Adapter ()
        {
            //Synthesized constructor
        }
        /**
         * Appends the data to the stream.
         * This method could be implemented in the outer class
         * itself, but it could be insecure.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.727 -0500", hash_original_method = "63D6CE2521D05DB3C4B970CFFD748CB7", hash_generated_method = "BB9F1862F706485CBF83A3C202EE37AA")
        
public void append(byte[] src) {
            int length = src.length;
            if (BUFFER_SIZE - (end - pos) < length) {
                // If the size of the buffer is greater than or equals to
                // SSLRecordProtocol.MAX_DATA_LENGTH this situation will
                // happen iff:
                // 1. the length of received data fragment is greater
                // than allowed by the spec
                // 2. it is rehandshaking stage and we have got several
                // extra app data messages.
                // In any case it is better to throw alert exception.
                throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                        new SSLException("Could not accept income app data."));
            }
            if (end + length > BUFFER_SIZE) {
                // move the content of the buffer to the beginning
                System.arraycopy(buffer, pos, buffer, 0, end-pos);
                end -= pos;
                pos = 0;
            }
            System.arraycopy(src, 0, buffer, end, length);
            end = end + length;
        }
        
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:06.723 -0500", hash_original_method = "50426CF7D6642F19D28119E1D947BED8", hash_generated_method = "6BC2CEF740D0BDFCA8A3015759885D03")
    
@Override public int read(byte[] b, int off, int len) throws IOException {
        int read_b;
        int i = 0;
        do {
            if ((read_b = read()) == -1) {
                return (i == 0) ? -1 : i;
            }
            b[off+i] = (byte) read_b;
            i++;
        } while ((available() != 0) && (i<len));
        return i;
    }
}

