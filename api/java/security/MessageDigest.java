package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import org.apache.harmony.security.fortress.Engine;

public abstract class MessageDigest extends MessageDigestSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.107 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.107 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.108 -0400", hash_original_method = "DA3220D378CF53A8E8D20808A7040AB6", hash_generated_method = "399C27BF3F6D93A48DF8AFC793FD14ED")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.109 -0400", hash_original_method = "E1E123B455D04188508A4B0941F355AE", hash_generated_method = "886270F67B96DDF0DAA56D42A28596B7")
    public void reset() {
        engineReset();
        // ---------- Original Method ----------
        //engineReset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.109 -0400", hash_original_method = "5D76F053E1EB2FF1CE017209E211EA20", hash_generated_method = "421EF14958559C71CD3E606C0F2D9D9B")
    public void update(byte arg0) {
        addTaint(arg0);
        engineUpdate(arg0);
        // ---------- Original Method ----------
        //engineUpdate(arg0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.110 -0400", hash_original_method = "4F50D6AF2B6F6CC75F087F1B36C7BEE9", hash_generated_method = "8E1CE5842760121E820E67961257A850")
    public void update(byte[] input, int offset, int len) {
        addTaint(len);
        addTaint(offset);
        addTaint(input[0]);
    if(input == null ||
                (long) offset + (long) len > input.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1577182722 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1577182722.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1577182722;
        } //End block
        engineUpdate(input, offset, len);
        // ---------- Original Method ----------
        //if (input == null ||
                //(long) offset + (long) len > input.length) {
            //throw new IllegalArgumentException();
        //}
        //engineUpdate(input, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.110 -0400", hash_original_method = "2D0F4C2E65A537F2694C1C3FF3BB32CC", hash_generated_method = "F4AB5D15A88033A862D7D93A32998D98")
    public void update(byte[] input) {
        addTaint(input[0]);
    if(input == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_319358397 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_319358397.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_319358397;
        } //End block
        engineUpdate(input, 0, input.length);
        // ---------- Original Method ----------
        //if (input == null) {
            //throw new NullPointerException();
        //}
        //engineUpdate(input, 0, input.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.110 -0400", hash_original_method = "BFC8812962D9635EA2DD9DD3F9DF8CCE", hash_generated_method = "FDE9D3856237579CAD1C308F46279DA6")
    public byte[] digest() {
        byte[] varF6CE38F9D4ECC452155A563399B35C32_655279068 = (engineDigest());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1250480899 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1250480899;
        // ---------- Original Method ----------
        //return engineDigest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.111 -0400", hash_original_method = "427D2D0CC508C9C4E8BC486441041E72", hash_generated_method = "C5B63EDD56226147E2E98F8C83179318")
    public int digest(byte[] buf, int offset, int len) throws DigestException {
        addTaint(len);
        addTaint(offset);
        addTaint(buf[0]);
    if(buf == null ||
                (long) offset + (long) len > buf.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1516118485 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1516118485.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1516118485;
        } //End block
        int varDC0967B96EA0CF8F9C34EA96B19C86E4_768672275 = (engineDigest(buf, offset, len));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724194497 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724194497;
        // ---------- Original Method ----------
        //if (buf == null ||
                //(long) offset + (long) len > buf.length) {
            //throw new IllegalArgumentException();
        //}
        //return engineDigest(buf, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.112 -0400", hash_original_method = "C04191B06E52578EA4C996F47114224E", hash_generated_method = "47AA2D291BA2E6A2E1D81B8912708EA4")
    public byte[] digest(byte[] input) {
        addTaint(input[0]);
        update(input);
        byte[] varC1BA6528FD289D9ECA4FE44AFEF5877E_1131488566 = (digest());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1216300895 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1216300895;
        // ---------- Original Method ----------
        //update(input);
        //return digest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.112 -0400", hash_original_method = "67B827C914C444116C889B9B936D23D1", hash_generated_method = "077060D497667035EEFB0D95958D5CCD")
    @Override
    public String toString() {
String var2DE2B0753514113A12D28ABDDE929C04_814924632 =         "MESSAGE DIGEST " + algorithm;
        var2DE2B0753514113A12D28ABDDE929C04_814924632.addTaint(taint);
        return var2DE2B0753514113A12D28ABDDE929C04_814924632;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.113 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "C9ABC7E0AEAAC41E6C60961AD3BC1D61")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1529771575 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_1529771575.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_1529771575;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.113 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "E65AD2C7BC2F73BA460CACE02AF5720B")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_291247029 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_291247029.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_291247029;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.113 -0400", hash_original_method = "CB1E3F95FB76C6289C61CD25B71DC6B2", hash_generated_method = "5E81B88413B4E2BBFA4D7F417D202739")
    public final int getDigestLength() {
        int l = engineGetDigestLength();
    if(l != 0)        
        {
            int var2DB95E8E1A9267B7A1188556B2013B33_1985006322 = (l);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699155968 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699155968;
        } //End block
    if(!(this instanceof Cloneable))        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1559553246 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179234444 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179234444;
        } //End block
        try 
        {
            MessageDigest md = (MessageDigest) clone();
            int varD47BA43CD6D151F6AF47D7BF0202FE86_1719474480 = (md.digest().length);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_788310766 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_788310766;
        } //End block
        catch (CloneNotSupportedException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_801254057 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_813782564 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_813782564;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.114 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "1F5297A37D5FF6CDEE4ED71EFC979D34")
    @Override
    public Object clone() throws CloneNotSupportedException {
    if(this instanceof Cloneable)        
        {
Object var46F3A0D86742C1D6E099C2B166941A33_497392167 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_497392167.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_497392167;
        } //End block
        CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_1392577232 = new CloneNotSupportedException();
        var1615C718FF05C0D800F9FFF876AD8603_1392577232.addTaint(taint);
        throw var1615C718FF05C0D800F9FFF876AD8603_1392577232;
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.114 -0400", hash_original_method = "8AF1ACEDEB3ACC905C3D0DD872BD7C78", hash_generated_method = "EC420F17E2A02DA67E335396589590D6")
    public final void update(ByteBuffer input) {
        addTaint(input.getTaint());
        engineUpdate(input);
        // ---------- Original Method ----------
        //engineUpdate(input);
    }

    
    private static class MessageDigestImpl extends MessageDigest {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.115 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "13EF455E6884522AF3C11AFF102361CB")

        private MessageDigestSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.115 -0400", hash_original_method = "AF4F6C5934F11306EFBE5B299B5A2B9A", hash_generated_method = "A429A5B998EC05778C035C93FB935975")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.116 -0400", hash_original_method = "7B2BEE5C01EE533E37620968FDA4C371", hash_generated_method = "80CF2DD0AD898031D6EF2CECA4BECD8D")
        @Override
        protected void engineReset() {
            spiImpl.engineReset();
            // ---------- Original Method ----------
            //spiImpl.engineReset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.116 -0400", hash_original_method = "F90FDD38A509FFE526728E64881BF6E1", hash_generated_method = "FBF478C8B0196DBFB829328A8D66CCDD")
        @Override
        protected byte[] engineDigest() {
            byte[] varCC6F28AE08AAB3B4DDBD0764628594FB_780812219 = (spiImpl.engineDigest());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1146123562 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1146123562;
            // ---------- Original Method ----------
            //return spiImpl.engineDigest();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.116 -0400", hash_original_method = "A58BB0AA00BEE25A1A003BC1A1C82C78", hash_generated_method = "C101C3C7C7D338BE464618889D936E10")
        @Override
        protected int engineGetDigestLength() {
            int var667C3D1431B4BE6D4EA8DC2EEB8B31E8_289890551 = (spiImpl.engineGetDigestLength());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2095485760 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2095485760;
            // ---------- Original Method ----------
            //return spiImpl.engineGetDigestLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.117 -0400", hash_original_method = "D358F15D417A4020320217683B1513E5", hash_generated_method = "DA9CED5ADDCC300AE96EE0F890E10756")
        @Override
        protected void engineUpdate(byte arg0) {
            addTaint(arg0);
            spiImpl.engineUpdate(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.117 -0400", hash_original_method = "A2CCF3CCE76988A3320BAC87F00B4D63", hash_generated_method = "960D27DB9457D5DF1B7EF85FBFFFEDD5")
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) {
            addTaint(arg2);
            addTaint(arg1);
            addTaint(arg0[0]);
            spiImpl.engineUpdate(arg0, arg1, arg2);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.117 -0400", hash_original_method = "C83E6E6E4FE5D7C377E3AA33AF7D3FC4", hash_generated_method = "BF24061721CFA7B9F47B6F8564412E93")
        @Override
        public Object clone() throws CloneNotSupportedException {
    if(spiImpl instanceof Cloneable)            
            {
                MessageDigestSpi spi = (MessageDigestSpi) spiImpl.clone();
Object var65764E0FFD229951E453537D8A06831A_1675261701 =                 new MessageDigestImpl(spi, getProvider(), getAlgorithm());
                var65764E0FFD229951E453537D8A06831A_1675261701.addTaint(taint);
                return var65764E0FFD229951E453537D8A06831A_1675261701;
            } //End block
            CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_36046169 = new CloneNotSupportedException();
            var1615C718FF05C0D800F9FFF876AD8603_36046169.addTaint(taint);
            throw var1615C718FF05C0D800F9FFF876AD8603_36046169;
            // ---------- Original Method ----------
            //if (spiImpl instanceof Cloneable) {
                //MessageDigestSpi spi = (MessageDigestSpi) spiImpl.clone();
                //return new MessageDigestImpl(spi, getProvider(), getAlgorithm());
            //}
            //throw new CloneNotSupportedException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.118 -0400", hash_original_field = "6CFB3DC6BB9C310BE9EF6251E182D808", hash_generated_field = "D5F8A930AD592F3B05EEB634AF2D6E2F")

    private static final Engine ENGINE = new Engine("MessageDigest");
}

