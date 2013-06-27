package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;
import org.apache.harmony.security.fortress.Engine;

public abstract class MessageDigest extends MessageDigestSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.305 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.306 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.314 -0400", hash_original_method = "DA3220D378CF53A8E8D20808A7040AB6", hash_generated_method = "399C27BF3F6D93A48DF8AFC793FD14ED")
    protected  MessageDigest(String algorithm) {
        this.algorithm = algorithm;
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
    }

    
        public static MessageDigest getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        Object spi = sap.spi;
        Provider provider = sap.provider;
        if (spi instanceof MessageDigest) {
            MessageDigest result = (MessageDigest) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new MessageDigestImpl((MessageDigestSpi) sap.spi, sap.provider, algorithm);
    }

    
        public static MessageDigest getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, p);
    }

    
        public static MessageDigest getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        if (spi instanceof MessageDigest) {
            MessageDigest result = (MessageDigest) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new MessageDigestImpl((MessageDigestSpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.315 -0400", hash_original_method = "E1E123B455D04188508A4B0941F355AE", hash_generated_method = "886270F67B96DDF0DAA56D42A28596B7")
    public void reset() {
        engineReset();
        // ---------- Original Method ----------
        //engineReset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.315 -0400", hash_original_method = "5D76F053E1EB2FF1CE017209E211EA20", hash_generated_method = "962B17263F27FC6A58AE4DF65658A16D")
    public void update(byte arg0) {
        engineUpdate(arg0);
        addTaint(arg0);
        // ---------- Original Method ----------
        //engineUpdate(arg0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.316 -0400", hash_original_method = "4F50D6AF2B6F6CC75F087F1B36C7BEE9", hash_generated_method = "CCE65ADE8D6C1D5DC9F8272C0C6B8BF6")
    public void update(byte[] input, int offset, int len) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        engineUpdate(input, offset, len);
        addTaint(input[0]);
        addTaint(offset);
        addTaint(len);
        // ---------- Original Method ----------
        //if (input == null ||
                //(long) offset + (long) len > input.length) {
            //throw new IllegalArgumentException();
        //}
        //engineUpdate(input, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.316 -0400", hash_original_method = "2D0F4C2E65A537F2694C1C3FF3BB32CC", hash_generated_method = "5F64D0F544136617236A7024F854EF70")
    public void update(byte[] input) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        engineUpdate(input, 0, input.length);
        addTaint(input[0]);
        // ---------- Original Method ----------
        //if (input == null) {
            //throw new NullPointerException();
        //}
        //engineUpdate(input, 0, input.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.316 -0400", hash_original_method = "BFC8812962D9635EA2DD9DD3F9DF8CCE", hash_generated_method = "5FD3118545326AEABE4597C9884AB156")
    public byte[] digest() {
        byte[] var57D103A63674F987D87BF0540FEA990B_1620069610 = (engineDigest());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_226119628 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_226119628;
        // ---------- Original Method ----------
        //return engineDigest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.333 -0400", hash_original_method = "427D2D0CC508C9C4E8BC486441041E72", hash_generated_method = "89ABA7E9FF175D318C860D8DBB11BC4C")
    public int digest(byte[] buf, int offset, int len) throws DigestException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        int var2CAEA613A9CD0DCE46D4A8F510BE3822_708433646 = (engineDigest(buf, offset, len));
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1664050262 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1664050262;
        // ---------- Original Method ----------
        //if (buf == null ||
                //(long) offset + (long) len > buf.length) {
            //throw new IllegalArgumentException();
        //}
        //return engineDigest(buf, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.333 -0400", hash_original_method = "C04191B06E52578EA4C996F47114224E", hash_generated_method = "082F1BF9457A471F47D14A2D91E29E1E")
    public byte[] digest(byte[] input) {
        update(input);
        byte[] var0ABA005EAD8E4308D8116BD872FEB63C_1236494140 = (digest());
        addTaint(input[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1703520842 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1703520842;
        // ---------- Original Method ----------
        //update(input);
        //return digest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.334 -0400", hash_original_method = "67B827C914C444116C889B9B936D23D1", hash_generated_method = "A694E393525FCDAC1712578952CC1A3E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1465173820 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1465173820 = "MESSAGE DIGEST " + algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1465173820.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1465173820;
        // ---------- Original Method ----------
        //return "MESSAGE DIGEST " + algorithm;
    }

    
        public static boolean isEqual(byte[] digesta, byte[] digestb) {
        if (digesta.length != digestb.length) {
            return false;
        }
        for (int i = 0; i < digesta.length; i++) {
            if (digesta[i] != digestb[i]) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.334 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "1AA97C705BABC0D3281189C93F00B55D")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_286671596 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_286671596 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_286671596.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_286671596;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.335 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "51E9696FD8AA34E38FE8969FFBA2B208")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_530208517 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_530208517 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_530208517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_530208517;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.335 -0400", hash_original_method = "CB1E3F95FB76C6289C61CD25B71DC6B2", hash_generated_method = "40DD66017881C41445EAAA44E3F0961F")
    public final int getDigestLength() {
        int l;
        l = engineGetDigestLength();
        try 
        {
            MessageDigest md;
            md = (MessageDigest) clone();
            int var7CB7B46411ABEA4D435C69516DBB5D10_1316749407 = (md.digest().length);
        } //End block
        catch (CloneNotSupportedException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999629945 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999629945;
        // ---------- Original Method ----------
        //int l = engineGetDigestLength();
        //if (l != 0) {
            //return l;
        //}
        //if (!(this instanceof Cloneable)) {
            //return 0;
        //}
        //try {
            //MessageDigest md = (MessageDigest) clone();
            //return md.digest().length;
        //} catch (CloneNotSupportedException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.344 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "11708811E0A0286AB8CAE45B9E7B47C0")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2045770609 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_2045770609 = super.clone();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
        varB4EAC82CA7396A68D541C85D26508E83_2045770609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2045770609;
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.344 -0400", hash_original_method = "8AF1ACEDEB3ACC905C3D0DD872BD7C78", hash_generated_method = "ED5AADAF56BA08A93CBA104E5A84E7D9")
    public final void update(ByteBuffer input) {
        engineUpdate(input);
        addTaint(input.getTaint());
        // ---------- Original Method ----------
        //engineUpdate(input);
    }

    
    private static class MessageDigestImpl extends MessageDigest {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.344 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "13EF455E6884522AF3C11AFF102361CB")

        private MessageDigestSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.345 -0400", hash_original_method = "AF4F6C5934F11306EFBE5B299B5A2B9A", hash_generated_method = "0C2E77E07932D305B9AC81027D76354A")
        private  MessageDigestImpl(MessageDigestSpi messageDigestSpi,
                Provider provider, String algorithm) {
            super(algorithm);
            super.provider = provider;
            spiImpl = messageDigestSpi;
            addTaint(provider.getTaint());
            addTaint(algorithm.getTaint());
            // ---------- Original Method ----------
            //super.provider = provider;
            //spiImpl = messageDigestSpi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.353 -0400", hash_original_method = "7B2BEE5C01EE533E37620968FDA4C371", hash_generated_method = "80CF2DD0AD898031D6EF2CECA4BECD8D")
        @Override
        protected void engineReset() {
            spiImpl.engineReset();
            // ---------- Original Method ----------
            //spiImpl.engineReset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.353 -0400", hash_original_method = "F90FDD38A509FFE526728E64881BF6E1", hash_generated_method = "FFD0573138D958F431A51AAF15555A03")
        @Override
        protected byte[] engineDigest() {
            byte[] varFA3C40A0C93E6BBA5F82AAEEFBCFA132_2042850578 = (spiImpl.engineDigest());
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1331079527 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1331079527;
            // ---------- Original Method ----------
            //return spiImpl.engineDigest();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.353 -0400", hash_original_method = "A58BB0AA00BEE25A1A003BC1A1C82C78", hash_generated_method = "F6FACA699FF1E8AF55C6F563C1C3EFB8")
        @Override
        protected int engineGetDigestLength() {
            int varADF268C32B044A7824ABB952579ACEC5_522852268 = (spiImpl.engineGetDigestLength());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_418445785 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_418445785;
            // ---------- Original Method ----------
            //return spiImpl.engineGetDigestLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.354 -0400", hash_original_method = "D358F15D417A4020320217683B1513E5", hash_generated_method = "25F1B8CB741DD0FF6D4DAE8E29238417")
        @Override
        protected void engineUpdate(byte arg0) {
            spiImpl.engineUpdate(arg0);
            addTaint(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.354 -0400", hash_original_method = "A2CCF3CCE76988A3320BAC87F00B4D63", hash_generated_method = "C13D8C5670E4BA34E7D149FF3B3331A6")
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) {
            spiImpl.engineUpdate(arg0, arg1, arg2);
            addTaint(arg0[0]);
            addTaint(arg1);
            addTaint(arg2);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.355 -0400", hash_original_method = "C83E6E6E4FE5D7C377E3AA33AF7D3FC4", hash_generated_method = "850A4301D00288558EFFB0B78AE1918D")
        @Override
        public Object clone() throws CloneNotSupportedException {
            Object varB4EAC82CA7396A68D541C85D26508E83_303906949 = null; //Variable for return #1
            {
                MessageDigestSpi spi;
                spi = (MessageDigestSpi) spiImpl.clone();
                varB4EAC82CA7396A68D541C85D26508E83_303906949 = new MessageDigestImpl(spi, getProvider(), getAlgorithm());
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
            varB4EAC82CA7396A68D541C85D26508E83_303906949.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_303906949;
            // ---------- Original Method ----------
            //if (spiImpl instanceof Cloneable) {
                //MessageDigestSpi spi = (MessageDigestSpi) spiImpl.clone();
                //return new MessageDigestImpl(spi, getProvider(), getAlgorithm());
            //}
            //throw new CloneNotSupportedException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.355 -0400", hash_original_field = "6CFB3DC6BB9C310BE9EF6251E182D808", hash_generated_field = "A1FD7702E03E9D707539230182D00E68")

    private static Engine ENGINE = new Engine("MessageDigest");
}

