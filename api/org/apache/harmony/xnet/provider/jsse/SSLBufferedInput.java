package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.ByteBuffer;

public class SSLBufferedInput extends SSLInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.888 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "3B141A9D4793286CCC8107F666C9770C")

    private ByteBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.888 -0400", hash_original_field = "4176DD63A8A7706071A277D22BE6F13B", hash_generated_field = "57C57C6B5A44D0B945AC629B5C8D3802")

    private int bytik;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.888 -0400", hash_original_field = "5A6C74F3D8043A986B1E04513B7293B7", hash_generated_field = "58E74C0831CBD382581EE5956FDD5009")

    private int consumed = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.889 -0400", hash_original_method = "0FA622847329CF4AC911569EF96C37AF", hash_generated_method = "207C02C0F42AD27E2901C37C4EA4E064")
    protected  SSLBufferedInput() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.889 -0400", hash_original_method = "4BA9811A4EA68D06D9EBAD32A862938E", hash_generated_method = "E2127C5D16644089261CEF9729751A03")
    protected void setSourceBuffer(ByteBuffer in) {
        consumed = 0;
        this.in = in;
        // ---------- Original Method ----------
        //consumed = 0;
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.890 -0400", hash_original_method = "BB38BB904E493CEE8626853626B4B1AC", hash_generated_method = "8F03D63D462F25A039046F3A19F32305")
    @Override
    public int available() throws IOException {
        int var3598FDB044C87D9B470895827229EFD7_19155626 = (in.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1493243806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1493243806;
        // ---------- Original Method ----------
        //return in.remaining();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.890 -0400", hash_original_method = "7DD74A3F0F5CC57B45BB73D025A428F5", hash_generated_method = "2216645FE65488A6B0867E91BBA015E5")
    protected int consumed() {
        int var48FE8558CE14C4C865198444C538ECC5_2122068026 = (consumed);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475869617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475869617;
        // ---------- Original Method ----------
        //return consumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.890 -0400", hash_original_method = "575079C176E4EB6FD7A12CD67A6942A7", hash_generated_method = "A07593C6B046F9E27A0EC02F04952C4C")
    @Override
    public int read() throws IOException {
        bytik = in.get() & 0x00FF;
        consumed ++;
        int var4176DD63A8A7706071A277D22BE6F13B_198502130 = (bytik);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638971416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638971416;
        // ---------- Original Method ----------
        //bytik = in.get() & 0x00FF;
        //consumed ++;
        //return bytik;
    }

    
}

