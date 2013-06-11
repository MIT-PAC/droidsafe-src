package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.ByteBuffer;
import org.apache.harmony.security.fortress.Engine;

public abstract class MessageDigest extends MessageDigestSpi {
    private static final Engine ENGINE = new Engine("MessageDigest");
    private Provider provider;
    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "DA3220D378CF53A8E8D20808A7040AB6", hash_generated_method = "E180219C8941B16B26893BEBFB42D9CF")
    @DSModeled(DSC.SAFE)
    protected MessageDigest(String algorithm) {
        dsTaint.addTaint(algorithm);
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "5C601ADA1D2E18CF500EF6D66253600E", hash_generated_method = "7136D7DF10FBBCC2A23B2BFE80B5FAB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "4A47CCCAB9E7CA50F3AD4953C61AD60D", hash_generated_method = "E109005BEF06DBB9107F58DD5DA16131")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "723C5C1CC0AC6B47325C4EFD63C83CA5", hash_generated_method = "FB6253B2AEE8F1F7762F8C00D3303C27")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "E1E123B455D04188508A4B0941F355AE", hash_generated_method = "9A18E1EA5DA5ED8723D99F67644C1D1B")
    @DSModeled(DSC.SAFE)
    public void reset() {
        engineReset();
        // ---------- Original Method ----------
        //engineReset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "5D76F053E1EB2FF1CE017209E211EA20", hash_generated_method = "5DA658A39B1C8F68C59CD01D37B669A2")
    @DSModeled(DSC.SAFE)
    public void update(byte arg0) {
        dsTaint.addTaint(arg0);
        engineUpdate(arg0);
        // ---------- Original Method ----------
        //engineUpdate(arg0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "4F50D6AF2B6F6CC75F087F1B36C7BEE9", hash_generated_method = "1B21890B195C618377C9E73C9C534DF0")
    @DSModeled(DSC.SAFE)
    public void update(byte[] input, int offset, int len) {
        dsTaint.addTaint(input);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        {
            throw new IllegalArgumentException();
        } //End block
        engineUpdate(input, offset, len);
        // ---------- Original Method ----------
        //if (input == null ||
                //(long) offset + (long) len > input.length) {
            //throw new IllegalArgumentException();
        //}
        //engineUpdate(input, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "2D0F4C2E65A537F2694C1C3FF3BB32CC", hash_generated_method = "56143787DD02F2305ABD5DC5C29A878C")
    @DSModeled(DSC.SAFE)
    public void update(byte[] input) {
        dsTaint.addTaint(input);
        {
            throw new NullPointerException();
        } //End block
        engineUpdate(input, 0, input.length);
        // ---------- Original Method ----------
        //if (input == null) {
            //throw new NullPointerException();
        //}
        //engineUpdate(input, 0, input.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "BFC8812962D9635EA2DD9DD3F9DF8CCE", hash_generated_method = "5E21BD81FAA2663721C8ABAE3703AF89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] digest() {
        byte[] var57D103A63674F987D87BF0540FEA990B_1440208752 = (engineDigest());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return engineDigest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "427D2D0CC508C9C4E8BC486441041E72", hash_generated_method = "3FA8D36DC9B0C39AFB93D23F307F926A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int digest(byte[] buf, int offset, int len) throws DigestException {
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf);
        {
            throw new IllegalArgumentException();
        } //End block
        int var2CAEA613A9CD0DCE46D4A8F510BE3822_326166221 = (engineDigest(buf, offset, len));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buf == null ||
                //(long) offset + (long) len > buf.length) {
            //throw new IllegalArgumentException();
        //}
        //return engineDigest(buf, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.610 -0400", hash_original_method = "C04191B06E52578EA4C996F47114224E", hash_generated_method = "6A09943E4DD3AC53D132673530F0B48E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] digest(byte[] input) {
        dsTaint.addTaint(input);
        update(input);
        byte[] var0ABA005EAD8E4308D8116BD872FEB63C_2138288854 = (digest());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //update(input);
        //return digest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "67B827C914C444116C889B9B936D23D1", hash_generated_method = "86D94A15C4D0A67C7319571CE84074C9")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "MESSAGE DIGEST " + algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "8E343D7D0CF266D2D2F5F12353F2E5FB", hash_generated_method = "3F0DC5CF6405BEFFC970BFCD2FEB88B1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "4A58ADD94C981C54C4328FD02BFEBA19")
    @DSModeled(DSC.SAFE)
    public final String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "45F6335264F85F3B8D73CAC979348AC1")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "CB1E3F95FB76C6289C61CD25B71DC6B2", hash_generated_method = "1BA214A6324D2788B159CB817EF9608F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getDigestLength() {
        int l;
        l = engineGetDigestLength();
        try 
        {
            MessageDigest md;
            md = (MessageDigest) clone();
            int var7CB7B46411ABEA4D435C69516DBB5D10_72985822 = (md.digest().length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "E34C97055C4AE9820250D0DC445DF77C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() throws CloneNotSupportedException {
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_1775111893 = (super.clone());
        } //End block
        throw new CloneNotSupportedException();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "8AF1ACEDEB3ACC905C3D0DD872BD7C78", hash_generated_method = "EA8C88C11CD8C44DDD2FD6CB65C570EF")
    @DSModeled(DSC.SAFE)
    public final void update(ByteBuffer input) {
        dsTaint.addTaint(input.dsTaint);
        engineUpdate(input);
        // ---------- Original Method ----------
        //engineUpdate(input);
    }

    
    private static class MessageDigestImpl extends MessageDigest {
        private MessageDigestSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "AF4F6C5934F11306EFBE5B299B5A2B9A", hash_generated_method = "2E55E6EB3522E690C729CD6EF32C37DD")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "7B2BEE5C01EE533E37620968FDA4C371", hash_generated_method = "3AABAC2FE712BE7FEFE62FAFC0DCF7D3")
        @DSModeled(DSC.SAFE)
        @Override
        protected void engineReset() {
            spiImpl.engineReset();
            // ---------- Original Method ----------
            //spiImpl.engineReset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "F90FDD38A509FFE526728E64881BF6E1", hash_generated_method = "E650A99B7B46CA8DC73C1F48FC95BA53")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected byte[] engineDigest() {
            byte[] varFA3C40A0C93E6BBA5F82AAEEFBCFA132_1393449418 = (spiImpl.engineDigest());
            byte[] retVal = new byte[1];
            retVal[0] = (byte)dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //return spiImpl.engineDigest();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "A58BB0AA00BEE25A1A003BC1A1C82C78", hash_generated_method = "2EF1829A702C24F94EADBE0AD8680658")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int engineGetDigestLength() {
            int varADF268C32B044A7824ABB952579ACEC5_2022377557 = (spiImpl.engineGetDigestLength());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return spiImpl.engineGetDigestLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "D358F15D417A4020320217683B1513E5", hash_generated_method = "EFCB956D055C56DEA9519DE278495D6D")
        @DSModeled(DSC.SAFE)
        @Override
        protected void engineUpdate(byte arg0) {
            dsTaint.addTaint(arg0);
            spiImpl.engineUpdate(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "A2CCF3CCE76988A3320BAC87F00B4D63", hash_generated_method = "ED1B0418970AFCA6520D9D4D0A7C9FF0")
        @DSModeled(DSC.SAFE)
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) {
            dsTaint.addTaint(arg2);
            dsTaint.addTaint(arg1);
            dsTaint.addTaint(arg0);
            spiImpl.engineUpdate(arg0, arg1, arg2);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.611 -0400", hash_original_method = "C83E6E6E4FE5D7C377E3AA33AF7D3FC4", hash_generated_method = "FB2E94E00714C473D6496C621682A782")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object clone() throws CloneNotSupportedException {
            {
                MessageDigestSpi spi;
                spi = (MessageDigestSpi) spiImpl.clone();
                Object varCAE1575D4CACB58BC0AA8C6BC6F6B288_1892674179 = (new MessageDigestImpl(spi, getProvider(), getAlgorithm()));
            } //End block
            throw new CloneNotSupportedException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (spiImpl instanceof Cloneable) {
                //MessageDigestSpi spi = (MessageDigestSpi) spiImpl.clone();
                //return new MessageDigestImpl(spi, getProvider(), getAlgorithm());
            //}
            //throw new CloneNotSupportedException();
        }

        
    }


    
}


