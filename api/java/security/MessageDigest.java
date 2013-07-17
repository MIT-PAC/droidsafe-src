package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import org.apache.harmony.security.fortress.Engine;

public abstract class MessageDigest extends MessageDigestSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.075 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.075 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.076 -0400", hash_original_method = "DA3220D378CF53A8E8D20808A7040AB6", hash_generated_method = "399C27BF3F6D93A48DF8AFC793FD14ED")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.077 -0400", hash_original_method = "E1E123B455D04188508A4B0941F355AE", hash_generated_method = "886270F67B96DDF0DAA56D42A28596B7")
    public void reset() {
        engineReset();
        // ---------- Original Method ----------
        //engineReset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.077 -0400", hash_original_method = "5D76F053E1EB2FF1CE017209E211EA20", hash_generated_method = "421EF14958559C71CD3E606C0F2D9D9B")
    public void update(byte arg0) {
        addTaint(arg0);
        engineUpdate(arg0);
        // ---------- Original Method ----------
        //engineUpdate(arg0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.078 -0400", hash_original_method = "4F50D6AF2B6F6CC75F087F1B36C7BEE9", hash_generated_method = "AFE97CF4DF63F15FF83690CC61E5BF0E")
    public void update(byte[] input, int offset, int len) {
        addTaint(len);
        addTaint(offset);
        addTaint(input[0]);
        if(input == null ||
                (long) offset + (long) len > input.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1711042230 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1711042230.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1711042230;
        } //End block
        engineUpdate(input, offset, len);
        // ---------- Original Method ----------
        //if (input == null ||
                //(long) offset + (long) len > input.length) {
            //throw new IllegalArgumentException();
        //}
        //engineUpdate(input, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.079 -0400", hash_original_method = "2D0F4C2E65A537F2694C1C3FF3BB32CC", hash_generated_method = "E675E2424596BF6422284B3D13BC2B0B")
    public void update(byte[] input) {
        addTaint(input[0]);
        if(input == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_220405133 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_220405133.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_220405133;
        } //End block
        engineUpdate(input, 0, input.length);
        // ---------- Original Method ----------
        //if (input == null) {
            //throw new NullPointerException();
        //}
        //engineUpdate(input, 0, input.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.079 -0400", hash_original_method = "BFC8812962D9635EA2DD9DD3F9DF8CCE", hash_generated_method = "2F3B959E95A57AA89AABA002E73A03FD")
    public byte[] digest() {
        byte[] varF6CE38F9D4ECC452155A563399B35C32_1758176272 = (engineDigest());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_662528363 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_662528363;
        // ---------- Original Method ----------
        //return engineDigest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.079 -0400", hash_original_method = "427D2D0CC508C9C4E8BC486441041E72", hash_generated_method = "35F2DA2B49EA47F963AC1A1265864DB8")
    public int digest(byte[] buf, int offset, int len) throws DigestException {
        addTaint(len);
        addTaint(offset);
        addTaint(buf[0]);
        if(buf == null ||
                (long) offset + (long) len > buf.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1943593332 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1943593332.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1943593332;
        } //End block
        int varDC0967B96EA0CF8F9C34EA96B19C86E4_1593662513 = (engineDigest(buf, offset, len));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261051111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261051111;
        // ---------- Original Method ----------
        //if (buf == null ||
                //(long) offset + (long) len > buf.length) {
            //throw new IllegalArgumentException();
        //}
        //return engineDigest(buf, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.080 -0400", hash_original_method = "C04191B06E52578EA4C996F47114224E", hash_generated_method = "7462C4325466AEFE47FCB95B7D6F3492")
    public byte[] digest(byte[] input) {
        addTaint(input[0]);
        update(input);
        byte[] varC1BA6528FD289D9ECA4FE44AFEF5877E_2130869909 = (digest());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_341654266 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_341654266;
        // ---------- Original Method ----------
        //update(input);
        //return digest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.080 -0400", hash_original_method = "67B827C914C444116C889B9B936D23D1", hash_generated_method = "67137A5435CCB17F8F4750386817CDB2")
    @Override
    public String toString() {
String var2DE2B0753514113A12D28ABDDE929C04_680765256 =         "MESSAGE DIGEST " + algorithm;
        var2DE2B0753514113A12D28ABDDE929C04_680765256.addTaint(taint);
        return var2DE2B0753514113A12D28ABDDE929C04_680765256;
        // ---------- Original Method ----------
        //return "MESSAGE DIGEST " + algorithm;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.080 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "99A31C22C6017B895699906C95555F0F")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_815497987 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_815497987.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_815497987;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.081 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "B2A689454F66BC63EDCE9FD51673FC9F")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_962924216 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_962924216.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_962924216;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.081 -0400", hash_original_method = "CB1E3F95FB76C6289C61CD25B71DC6B2", hash_generated_method = "4BD7CAA2B1DDAA9FAE1E411DCB37C3B1")
    public final int getDigestLength() {
        int l = engineGetDigestLength();
        if(l != 0)        
        {
            int var2DB95E8E1A9267B7A1188556B2013B33_1932121222 = (l);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638426677 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638426677;
        } //End block
        if(!(this instanceof Cloneable))        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_2124855318 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889635424 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889635424;
        } //End block
        try 
        {
            MessageDigest md = (MessageDigest) clone();
            int varD47BA43CD6D151F6AF47D7BF0202FE86_878628526 = (md.digest().length);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_321129961 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_321129961;
        } //End block
        catch (CloneNotSupportedException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_842627228 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1807489204 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1807489204;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.082 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "75A8CAB1D51C9AAB44B1862ED0A92A57")
    @Override
    public Object clone() throws CloneNotSupportedException {
        if(this instanceof Cloneable)        
        {
Object var46F3A0D86742C1D6E099C2B166941A33_300615277 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_300615277.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_300615277;
        } //End block
        CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_126127565 = new CloneNotSupportedException();
        var1615C718FF05C0D800F9FFF876AD8603_126127565.addTaint(taint);
        throw var1615C718FF05C0D800F9FFF876AD8603_126127565;
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.083 -0400", hash_original_method = "8AF1ACEDEB3ACC905C3D0DD872BD7C78", hash_generated_method = "EC420F17E2A02DA67E335396589590D6")
    public final void update(ByteBuffer input) {
        addTaint(input.getTaint());
        engineUpdate(input);
        // ---------- Original Method ----------
        //engineUpdate(input);
    }

    
    private static class MessageDigestImpl extends MessageDigest {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.083 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "13EF455E6884522AF3C11AFF102361CB")

        private MessageDigestSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.085 -0400", hash_original_method = "AF4F6C5934F11306EFBE5B299B5A2B9A", hash_generated_method = "A429A5B998EC05778C035C93FB935975")
        private  MessageDigestImpl(MessageDigestSpi messageDigestSpi,
                Provider provider, String algorithm) {
            super(algorithm);
            addTaint(algorithm.getTaint());
            addTaint(provider.getTaint());
            super.provider = provider;
            spiImpl = messageDigestSpi;
            // ---------- Original Method ----------
            //super.provider = provider;
            //spiImpl = messageDigestSpi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.085 -0400", hash_original_method = "7B2BEE5C01EE533E37620968FDA4C371", hash_generated_method = "80CF2DD0AD898031D6EF2CECA4BECD8D")
        @Override
        protected void engineReset() {
            spiImpl.engineReset();
            // ---------- Original Method ----------
            //spiImpl.engineReset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.085 -0400", hash_original_method = "F90FDD38A509FFE526728E64881BF6E1", hash_generated_method = "D1880D27A47BE5CBA2C8AC5297811B73")
        @Override
        protected byte[] engineDigest() {
            byte[] varCC6F28AE08AAB3B4DDBD0764628594FB_681527437 = (spiImpl.engineDigest());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1571306920 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1571306920;
            // ---------- Original Method ----------
            //return spiImpl.engineDigest();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.086 -0400", hash_original_method = "A58BB0AA00BEE25A1A003BC1A1C82C78", hash_generated_method = "9C0F88CB36AED830CCB7E3F07AE13014")
        @Override
        protected int engineGetDigestLength() {
            int var667C3D1431B4BE6D4EA8DC2EEB8B31E8_1231512335 = (spiImpl.engineGetDigestLength());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238142188 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238142188;
            // ---------- Original Method ----------
            //return spiImpl.engineGetDigestLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.086 -0400", hash_original_method = "D358F15D417A4020320217683B1513E5", hash_generated_method = "DA9CED5ADDCC300AE96EE0F890E10756")
        @Override
        protected void engineUpdate(byte arg0) {
            addTaint(arg0);
            spiImpl.engineUpdate(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.087 -0400", hash_original_method = "A2CCF3CCE76988A3320BAC87F00B4D63", hash_generated_method = "960D27DB9457D5DF1B7EF85FBFFFEDD5")
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) {
            addTaint(arg2);
            addTaint(arg1);
            addTaint(arg0[0]);
            spiImpl.engineUpdate(arg0, arg1, arg2);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.087 -0400", hash_original_method = "C83E6E6E4FE5D7C377E3AA33AF7D3FC4", hash_generated_method = "8108382BD79E2261EA661C5057724301")
        @Override
        public Object clone() throws CloneNotSupportedException {
            if(spiImpl instanceof Cloneable)            
            {
                MessageDigestSpi spi = (MessageDigestSpi) spiImpl.clone();
Object var65764E0FFD229951E453537D8A06831A_2011963868 =                 new MessageDigestImpl(spi, getProvider(), getAlgorithm());
                var65764E0FFD229951E453537D8A06831A_2011963868.addTaint(taint);
                return var65764E0FFD229951E453537D8A06831A_2011963868;
            } //End block
            CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_1503863881 = new CloneNotSupportedException();
            var1615C718FF05C0D800F9FFF876AD8603_1503863881.addTaint(taint);
            throw var1615C718FF05C0D800F9FFF876AD8603_1503863881;
            // ---------- Original Method ----------
            //if (spiImpl instanceof Cloneable) {
                //MessageDigestSpi spi = (MessageDigestSpi) spiImpl.clone();
                //return new MessageDigestImpl(spi, getProvider(), getAlgorithm());
            //}
            //throw new CloneNotSupportedException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.087 -0400", hash_original_field = "6CFB3DC6BB9C310BE9EF6251E182D808", hash_generated_field = "D5F8A930AD592F3B05EEB634AF2D6E2F")

    private static final Engine ENGINE = new Engine("MessageDigest");
}

