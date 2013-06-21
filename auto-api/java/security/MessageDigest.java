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
    private Provider provider;
    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.388 -0400", hash_original_method = "DA3220D378CF53A8E8D20808A7040AB6", hash_generated_method = "5E20F883A187FDE8DDA24D37B2E72148")
    @DSModeled(DSC.SAFE)
    protected MessageDigest(String algorithm) {
        dsTaint.addTaint(algorithm);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.388 -0400", hash_original_method = "E1E123B455D04188508A4B0941F355AE", hash_generated_method = "886270F67B96DDF0DAA56D42A28596B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reset() {
        engineReset();
        // ---------- Original Method ----------
        //engineReset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.388 -0400", hash_original_method = "5D76F053E1EB2FF1CE017209E211EA20", hash_generated_method = "A31C02E5C14B38733023DF36561605FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(byte arg0) {
        dsTaint.addTaint(arg0);
        engineUpdate(arg0);
        // ---------- Original Method ----------
        //engineUpdate(arg0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.389 -0400", hash_original_method = "4F50D6AF2B6F6CC75F087F1B36C7BEE9", hash_generated_method = "2A1C6793BF12B0522CA4DA1DFC275BF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(byte[] input, int offset, int len) {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        engineUpdate(input, offset, len);
        // ---------- Original Method ----------
        //if (input == null ||
                //(long) offset + (long) len > input.length) {
            //throw new IllegalArgumentException();
        //}
        //engineUpdate(input, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.389 -0400", hash_original_method = "2D0F4C2E65A537F2694C1C3FF3BB32CC", hash_generated_method = "6605466A67FB8D8CFB4C532B49C8E54E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(byte[] input) {
        dsTaint.addTaint(input[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        engineUpdate(input, 0, input.length);
        // ---------- Original Method ----------
        //if (input == null) {
            //throw new NullPointerException();
        //}
        //engineUpdate(input, 0, input.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.389 -0400", hash_original_method = "BFC8812962D9635EA2DD9DD3F9DF8CCE", hash_generated_method = "3DD789A92A63F7B6EE3881803119482F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] digest() {
        byte[] var57D103A63674F987D87BF0540FEA990B_1476527891 = (engineDigest());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return engineDigest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.389 -0400", hash_original_method = "427D2D0CC508C9C4E8BC486441041E72", hash_generated_method = "6F3DA9F752AF5C40EEB92399296CCCEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int digest(byte[] buf, int offset, int len) throws DigestException {
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        int var2CAEA613A9CD0DCE46D4A8F510BE3822_872630612 = (engineDigest(buf, offset, len));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buf == null ||
                //(long) offset + (long) len > buf.length) {
            //throw new IllegalArgumentException();
        //}
        //return engineDigest(buf, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.389 -0400", hash_original_method = "C04191B06E52578EA4C996F47114224E", hash_generated_method = "C45230CEABE39D696BCC1F731E4B0F07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] digest(byte[] input) {
        dsTaint.addTaint(input[0]);
        update(input);
        byte[] var0ABA005EAD8E4308D8116BD872FEB63C_723379880 = (digest());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //update(input);
        //return digest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.389 -0400", hash_original_method = "67B827C914C444116C889B9B936D23D1", hash_generated_method = "D2B8F03F95EA0AB9289E523AA0AE5C2B")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.390 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "D8B68EE02F71705BA62E93B42B805D25")
    @DSModeled(DSC.SAFE)
    public final String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.390 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.390 -0400", hash_original_method = "CB1E3F95FB76C6289C61CD25B71DC6B2", hash_generated_method = "01A46C4978C267937BFBEE7DFF3FF5F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getDigestLength() {
        int l;
        l = engineGetDigestLength();
        try 
        {
            MessageDigest md;
            md = (MessageDigest) clone();
            int var7CB7B46411ABEA4D435C69516DBB5D10_763565220 = (md.digest().length);
        } //End block
        catch (CloneNotSupportedException e)
        { }
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.390 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "7F26427DB9E8FAA5789670E876F6D97F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() throws CloneNotSupportedException {
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_1918874000 = (super.clone());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.390 -0400", hash_original_method = "8AF1ACEDEB3ACC905C3D0DD872BD7C78", hash_generated_method = "59D53DBF8B091BD8B260267D9B70B4FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void update(ByteBuffer input) {
        dsTaint.addTaint(input.dsTaint);
        engineUpdate(input);
        // ---------- Original Method ----------
        //engineUpdate(input);
    }

    
    private static class MessageDigestImpl extends MessageDigest {
        private MessageDigestSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.391 -0400", hash_original_method = "AF4F6C5934F11306EFBE5B299B5A2B9A", hash_generated_method = "46575F14548FE1D78C120052B06C8633")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private MessageDigestImpl(MessageDigestSpi messageDigestSpi,
                Provider provider, String algorithm) {
            super(algorithm);
            dsTaint.addTaint(provider.dsTaint);
            dsTaint.addTaint(messageDigestSpi.dsTaint);
            dsTaint.addTaint(algorithm);
            super.provider = provider;
            // ---------- Original Method ----------
            //super.provider = provider;
            //spiImpl = messageDigestSpi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.391 -0400", hash_original_method = "7B2BEE5C01EE533E37620968FDA4C371", hash_generated_method = "80CF2DD0AD898031D6EF2CECA4BECD8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void engineReset() {
            spiImpl.engineReset();
            // ---------- Original Method ----------
            //spiImpl.engineReset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.391 -0400", hash_original_method = "F90FDD38A509FFE526728E64881BF6E1", hash_generated_method = "904728B6549BA415BFC7E39F1F099EC6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected byte[] engineDigest() {
            byte[] varFA3C40A0C93E6BBA5F82AAEEFBCFA132_111638915 = (spiImpl.engineDigest());
            byte[] retVal = new byte[1];
            retVal[0] = (byte)dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //return spiImpl.engineDigest();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.391 -0400", hash_original_method = "A58BB0AA00BEE25A1A003BC1A1C82C78", hash_generated_method = "BED59E0477157D878D536DF05F6EAD1B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int engineGetDigestLength() {
            int varADF268C32B044A7824ABB952579ACEC5_1686737636 = (spiImpl.engineGetDigestLength());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return spiImpl.engineGetDigestLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.391 -0400", hash_original_method = "D358F15D417A4020320217683B1513E5", hash_generated_method = "5984827D71605D6DCCD0DB5B671F4481")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void engineUpdate(byte arg0) {
            dsTaint.addTaint(arg0);
            spiImpl.engineUpdate(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.391 -0400", hash_original_method = "A2CCF3CCE76988A3320BAC87F00B4D63", hash_generated_method = "8BB172FE07C21E7E8A9098DC57FFBA80")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) {
            dsTaint.addTaint(arg2);
            dsTaint.addTaint(arg1);
            dsTaint.addTaint(arg0[0]);
            spiImpl.engineUpdate(arg0, arg1, arg2);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.392 -0400", hash_original_method = "C83E6E6E4FE5D7C377E3AA33AF7D3FC4", hash_generated_method = "0A0DFABD11760324F93C03DD4235C773")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object clone() throws CloneNotSupportedException {
            {
                MessageDigestSpi spi;
                spi = (MessageDigestSpi) spiImpl.clone();
                Object varCAE1575D4CACB58BC0AA8C6BC6F6B288_1925924089 = (new MessageDigestImpl(spi, getProvider(), getAlgorithm()));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (spiImpl instanceof Cloneable) {
                //MessageDigestSpi spi = (MessageDigestSpi) spiImpl.clone();
                //return new MessageDigestImpl(spi, getProvider(), getAlgorithm());
            //}
            //throw new CloneNotSupportedException();
        }

        
    }


    
    private static final Engine ENGINE = new Engine("MessageDigest");
}

