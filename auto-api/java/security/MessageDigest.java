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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.373 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.373 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.374 -0400", hash_original_method = "DA3220D378CF53A8E8D20808A7040AB6", hash_generated_method = "399C27BF3F6D93A48DF8AFC793FD14ED")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.375 -0400", hash_original_method = "E1E123B455D04188508A4B0941F355AE", hash_generated_method = "886270F67B96DDF0DAA56D42A28596B7")
    public void reset() {
        engineReset();
        // ---------- Original Method ----------
        //engineReset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.375 -0400", hash_original_method = "5D76F053E1EB2FF1CE017209E211EA20", hash_generated_method = "962B17263F27FC6A58AE4DF65658A16D")
    public void update(byte arg0) {
        engineUpdate(arg0);
        addTaint(arg0);
        // ---------- Original Method ----------
        //engineUpdate(arg0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.375 -0400", hash_original_method = "4F50D6AF2B6F6CC75F087F1B36C7BEE9", hash_generated_method = "CCE65ADE8D6C1D5DC9F8272C0C6B8BF6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.375 -0400", hash_original_method = "2D0F4C2E65A537F2694C1C3FF3BB32CC", hash_generated_method = "5F64D0F544136617236A7024F854EF70")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.375 -0400", hash_original_method = "BFC8812962D9635EA2DD9DD3F9DF8CCE", hash_generated_method = "752E0CA2ECDB3C50D9F382210D38AD74")
    public byte[] digest() {
        byte[] var57D103A63674F987D87BF0540FEA990B_556477335 = (engineDigest());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1243871250 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1243871250;
        // ---------- Original Method ----------
        //return engineDigest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.376 -0400", hash_original_method = "427D2D0CC508C9C4E8BC486441041E72", hash_generated_method = "C152C1DD33BFA257E696E5894258BACA")
    public int digest(byte[] buf, int offset, int len) throws DigestException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        int var2CAEA613A9CD0DCE46D4A8F510BE3822_197752742 = (engineDigest(buf, offset, len));
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1715722573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1715722573;
        // ---------- Original Method ----------
        //if (buf == null ||
                //(long) offset + (long) len > buf.length) {
            //throw new IllegalArgumentException();
        //}
        //return engineDigest(buf, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.376 -0400", hash_original_method = "C04191B06E52578EA4C996F47114224E", hash_generated_method = "35C8C6269EC89C1A9524863A2FD6DD7E")
    public byte[] digest(byte[] input) {
        update(input);
        byte[] var0ABA005EAD8E4308D8116BD872FEB63C_1596311593 = (digest());
        addTaint(input[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_734706145 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_734706145;
        // ---------- Original Method ----------
        //update(input);
        //return digest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.377 -0400", hash_original_method = "67B827C914C444116C889B9B936D23D1", hash_generated_method = "44DAB113D59385A74D8C64C982DABE5E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1387493840 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1387493840 = "MESSAGE DIGEST " + algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1387493840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1387493840;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.378 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "DEFF412C754130DD6FD7FBA676E2B8CA")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_254952221 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_254952221 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_254952221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_254952221;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.379 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "E629A8AA0E00A7D3FFE4A73EAA0BCA85")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_1993757761 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1993757761 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1993757761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1993757761;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.379 -0400", hash_original_method = "CB1E3F95FB76C6289C61CD25B71DC6B2", hash_generated_method = "87A003E48C2F3678EDBC0F3DC91A48FC")
    public final int getDigestLength() {
        int l = engineGetDigestLength();
        try 
        {
            MessageDigest md = (MessageDigest) clone();
            int var7CB7B46411ABEA4D435C69516DBB5D10_1975886567 = (md.digest().length);
        } //End block
        catch (CloneNotSupportedException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639600916 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639600916;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.379 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "991B211A8931F0302B282353013A9BD1")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1796458699 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1796458699 = super.clone();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
        varB4EAC82CA7396A68D541C85D26508E83_1796458699.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1796458699;
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.380 -0400", hash_original_method = "8AF1ACEDEB3ACC905C3D0DD872BD7C78", hash_generated_method = "ED5AADAF56BA08A93CBA104E5A84E7D9")
    public final void update(ByteBuffer input) {
        engineUpdate(input);
        addTaint(input.getTaint());
        // ---------- Original Method ----------
        //engineUpdate(input);
    }

    
    private static class MessageDigestImpl extends MessageDigest {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.380 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "13EF455E6884522AF3C11AFF102361CB")

        private MessageDigestSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.380 -0400", hash_original_method = "AF4F6C5934F11306EFBE5B299B5A2B9A", hash_generated_method = "0C2E77E07932D305B9AC81027D76354A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.380 -0400", hash_original_method = "7B2BEE5C01EE533E37620968FDA4C371", hash_generated_method = "80CF2DD0AD898031D6EF2CECA4BECD8D")
        @Override
        protected void engineReset() {
            spiImpl.engineReset();
            // ---------- Original Method ----------
            //spiImpl.engineReset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.380 -0400", hash_original_method = "F90FDD38A509FFE526728E64881BF6E1", hash_generated_method = "DFEF84CA80188D56A12DEA8BBAFD2A79")
        @Override
        protected byte[] engineDigest() {
            byte[] varFA3C40A0C93E6BBA5F82AAEEFBCFA132_975006641 = (spiImpl.engineDigest());
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1313909786 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1313909786;
            // ---------- Original Method ----------
            //return spiImpl.engineDigest();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.381 -0400", hash_original_method = "A58BB0AA00BEE25A1A003BC1A1C82C78", hash_generated_method = "BCC6FD79F8ABE65485AB2020673C87E7")
        @Override
        protected int engineGetDigestLength() {
            int varADF268C32B044A7824ABB952579ACEC5_1421407671 = (spiImpl.engineGetDigestLength());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773061882 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773061882;
            // ---------- Original Method ----------
            //return spiImpl.engineGetDigestLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.381 -0400", hash_original_method = "D358F15D417A4020320217683B1513E5", hash_generated_method = "25F1B8CB741DD0FF6D4DAE8E29238417")
        @Override
        protected void engineUpdate(byte arg0) {
            spiImpl.engineUpdate(arg0);
            addTaint(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.381 -0400", hash_original_method = "A2CCF3CCE76988A3320BAC87F00B4D63", hash_generated_method = "C13D8C5670E4BA34E7D149FF3B3331A6")
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) {
            spiImpl.engineUpdate(arg0, arg1, arg2);
            addTaint(arg0[0]);
            addTaint(arg1);
            addTaint(arg2);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.382 -0400", hash_original_method = "C83E6E6E4FE5D7C377E3AA33AF7D3FC4", hash_generated_method = "DEC562C45DAED2DE223B4FBCD6E1A20B")
        @Override
        public Object clone() throws CloneNotSupportedException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1368805133 = null; //Variable for return #1
            {
                MessageDigestSpi spi = (MessageDigestSpi) spiImpl.clone();
                varB4EAC82CA7396A68D541C85D26508E83_1368805133 = new MessageDigestImpl(spi, getProvider(), getAlgorithm());
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
            varB4EAC82CA7396A68D541C85D26508E83_1368805133.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1368805133;
            // ---------- Original Method ----------
            //if (spiImpl instanceof Cloneable) {
                //MessageDigestSpi spi = (MessageDigestSpi) spiImpl.clone();
                //return new MessageDigestImpl(spi, getProvider(), getAlgorithm());
            //}
            //throw new CloneNotSupportedException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.382 -0400", hash_original_field = "6CFB3DC6BB9C310BE9EF6251E182D808", hash_generated_field = "D5F8A930AD592F3B05EEB634AF2D6E2F")

    private static final Engine ENGINE = new Engine("MessageDigest");
}

