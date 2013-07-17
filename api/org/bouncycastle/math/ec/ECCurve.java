package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.util.Random;

public abstract class ECCurve {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.434 -0400", hash_original_field = "0CC175B9C0F1B6A831C399E269772661", hash_generated_field = "16F3809D308EE3B5C0D90855C77B94DD")

    ECFieldElement a;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.434 -0400", hash_original_field = "92EB5FFEE6AE2FEC3AD71C777531578F", hash_generated_field = "2E1C114DB6D3D5AFAFE6B5C7A24A4397")

    ECFieldElement b;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.434 -0400", hash_original_method = "3ADB63016220614BC8D776351AA4CC0A", hash_generated_method = "3ADB63016220614BC8D776351AA4CC0A")
    public ECCurve ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract int getFieldSize();

    
    @DSModeled(DSC.SAFE)
    public abstract ECFieldElement fromBigInteger(BigInteger x);

    
    @DSModeled(DSC.SAFE)
    public abstract ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression);

    
    @DSModeled(DSC.SAFE)
    public abstract ECPoint decodePoint(byte[] encoded);

    
    @DSModeled(DSC.SAFE)
    public abstract ECPoint getInfinity();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.435 -0400", hash_original_method = "E518DFD3A1B52E4C2FA641AF9C8BD0EA", hash_generated_method = "6AEC2046E4802417E1269607F5FF9E76")
    public ECFieldElement getA() {
ECFieldElement var3F5343BF1D849954A73F0BB303805FFD_2132192093 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_2132192093.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_2132192093;
        // ---------- Original Method ----------
        //return a;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.435 -0400", hash_original_method = "E3D5F4BB1EEF47030E7E58DC1A7D0CBC", hash_generated_method = "530DBDD6A47377DE162F4C187494AA43")
    public ECFieldElement getB() {
ECFieldElement var73F89FAC8F369DF0913D10C37C1E0EA1_1450217011 =         b;
        var73F89FAC8F369DF0913D10C37C1E0EA1_1450217011.addTaint(taint);
        return var73F89FAC8F369DF0913D10C37C1E0EA1_1450217011;
        // ---------- Original Method ----------
        //return b;
    }

    
    public static class Fp extends ECCurve {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.436 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "F819999E3B2036A19089F4FD0B5D94F4")

        BigInteger q;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.436 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "69A238B6B16C69E09404578CE64545C8")

        ECPoint.Fp infinity;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.436 -0400", hash_original_method = "22B1E0FEEF98DB62B3F95091656AE119", hash_generated_method = "7846805D72ADC3FA3F6A4C0B21318F69")
        public  Fp(BigInteger q, BigInteger a, BigInteger b) {
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            this.q = q;
            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.infinity = new ECPoint.Fp(this, null, null);
            // ---------- Original Method ----------
            //this.q = q;
            //this.a = fromBigInteger(a);
            //this.b = fromBigInteger(b);
            //this.infinity = new ECPoint.Fp(this, null, null);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.437 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "89A1B026D80D476F58CD68D701E95627")
        public BigInteger getQ() {
BigInteger varBEF1B7662E10AF6D5747729987514CB6_1510474262 =             q;
            varBEF1B7662E10AF6D5747729987514CB6_1510474262.addTaint(taint);
            return varBEF1B7662E10AF6D5747729987514CB6_1510474262;
            // ---------- Original Method ----------
            //return q;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.437 -0400", hash_original_method = "B586F82D19D11BCE8142121499961CE9", hash_generated_method = "75CD159FDC736D8E3989C7287DCF8775")
        public int getFieldSize() {
            int var0769037565AC374C9291621AA66E8145_767266127 = (q.bitLength());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106583858 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106583858;
            // ---------- Original Method ----------
            //return q.bitLength();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.437 -0400", hash_original_method = "717FAD51B8C0866C7878DF981123AAA4", hash_generated_method = "EEBE85676C34E2DE856ADB33F2C94F7B")
        public ECFieldElement fromBigInteger(BigInteger x) {
            addTaint(x.getTaint());
ECFieldElement var9002094E05CF56420543DC9EAEAEF109_585793254 =             new ECFieldElement.Fp(this.q, x);
            var9002094E05CF56420543DC9EAEAEF109_585793254.addTaint(taint);
            return var9002094E05CF56420543DC9EAEAEF109_585793254;
            // ---------- Original Method ----------
            //return new ECFieldElement.Fp(this.q, x);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.438 -0400", hash_original_method = "E2F0508F86D70ECB95714B920D7ED166", hash_generated_method = "9C32AA27BFCC4CDD259961FD870F1964")
        public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
            addTaint(withCompression);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
ECPoint var6A2F883B690EF7F35DBD24DC6932AC49_2123605381 =             new ECPoint.Fp(this, fromBigInteger(x), fromBigInteger(y), withCompression);
            var6A2F883B690EF7F35DBD24DC6932AC49_2123605381.addTaint(taint);
            return var6A2F883B690EF7F35DBD24DC6932AC49_2123605381;
            // ---------- Original Method ----------
            //return new ECPoint.Fp(this, fromBigInteger(x), fromBigInteger(y), withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.439 -0400", hash_original_method = "1737D5EF0BE777F7A805235738F1CA68", hash_generated_method = "2AE97644CAB52E47F6979C14B95D4C61")
        public ECPoint decodePoint(byte[] encoded) {
            addTaint(encoded[0]);
            ECPoint p = null;
switch(encoded[0]){
            case 0x00:
            if(encoded.length > 1)            
            {
                RuntimeException varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_915042576 = new RuntimeException("Invalid point encoding");
                varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_915042576.addTaint(taint);
                throw varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_915042576;
            } //End block
            p = getInfinity();
            break;
            case 0x02:
            case 0x03:
            int ytilde = encoded[0] & 1;
            byte[] i = new byte[encoded.length - 1];
            System.arraycopy(encoded, 1, i, 0, i.length);
            ECFieldElement x = new ECFieldElement.Fp(this.q, new BigInteger(1, i));
            ECFieldElement alpha = x.multiply(x.square().add(a)).add(b);
            ECFieldElement beta = alpha.sqrt();
            if(beta == null)            
            {
                RuntimeException var073123230BDDEAB03F8CC2D1C501D87E_993256228 = new RuntimeException("Invalid point compression");
                var073123230BDDEAB03F8CC2D1C501D87E_993256228.addTaint(taint);
                throw var073123230BDDEAB03F8CC2D1C501D87E_993256228;
            } //End block
            int bit0 = (beta.toBigInteger().testBit(0) ? 1 : 0);
            if(bit0 == ytilde)            
            {
                p = new ECPoint.Fp(this, x, beta, true);
            } //End block
            else
            {
                p = new ECPoint.Fp(this, x,
                        new ECFieldElement.Fp(this.q, q.subtract(beta.toBigInteger())), true);
            } //End block
            break;
            case 0x04:
            case 0x06:
            case 0x07:
            byte[] xEnc = new byte[(encoded.length - 1) / 2];
            byte[] yEnc = new byte[(encoded.length - 1) / 2];
            System.arraycopy(encoded, 1, xEnc, 0, xEnc.length);
            System.arraycopy(encoded, xEnc.length + 1, yEnc, 0, yEnc.length);
            p = new ECPoint.Fp(this,
                        new ECFieldElement.Fp(this.q, new BigInteger(1, xEnc)),
                        new ECFieldElement.Fp(this.q, new BigInteger(1, yEnc)));
            break;
            default:
            RuntimeException var6B576F84820FD10EFF078D43E27E2D72_2002122065 = new RuntimeException("Invalid point encoding 0x" + Integer.toString(encoded[0], 16));
            var6B576F84820FD10EFF078D43E27E2D72_2002122065.addTaint(taint);
            throw var6B576F84820FD10EFF078D43E27E2D72_2002122065;
}ECPoint var74E4690D9F2A026504928C017944E149_1936489386 =             p;
            var74E4690D9F2A026504928C017944E149_1936489386.addTaint(taint);
            return var74E4690D9F2A026504928C017944E149_1936489386;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.440 -0400", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "483BF1CB07C6456E7EDBA84DB76C8C3C")
        public ECPoint getInfinity() {
ECPoint varD826F01678C0988122ADB8C93417E177_975666561 =             infinity;
            varD826F01678C0988122ADB8C93417E177_975666561.addTaint(taint);
            return varD826F01678C0988122ADB8C93417E177_975666561;
            // ---------- Original Method ----------
            //return infinity;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.440 -0400", hash_original_method = "937E7F8C7D7C20805F9F2153639BF5E3", hash_generated_method = "74A6085D7B95427F79F8C7E7B59505FB")
        public boolean equals(
            Object anObject) {
            addTaint(anObject.getTaint());
            if(anObject == this)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_425132548 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847627009 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847627009;
            } //End block
            if(!(anObject instanceof ECCurve.Fp))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1229488730 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940090320 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_940090320;
            } //End block
            ECCurve.Fp other = (ECCurve.Fp) anObject;
            boolean varBCEFD00147463359556F9E3D2B186D57_1495376073 = (this.q.equals(other.q) 
                    && a.equals(other.a) && b.equals(other.b));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518368720 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518368720;
            // ---------- Original Method ----------
            //if (anObject == this) 
            //{
                //return true;
            //}
            //if (!(anObject instanceof ECCurve.Fp)) 
            //{
                //return false;
            //}
            //ECCurve.Fp other = (ECCurve.Fp) anObject;
            //return this.q.equals(other.q) 
                    //&& a.equals(other.a) && b.equals(other.b);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.441 -0400", hash_original_method = "0595BFE04038932B73D34C7D5BF16F78", hash_generated_method = "84CE1399F8098868A3EE8DAE853F4DB6")
        public int hashCode() {
            int var0FD32793CB23B5AFDB05A870AAB833C7_1247650728 = (a.hashCode() ^ b.hashCode() ^ q.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293209174 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293209174;
            // ---------- Original Method ----------
            //return a.hashCode() ^ b.hashCode() ^ q.hashCode();
        }

        
    }


    
    public static class F2m extends ECCurve {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.441 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

        private int m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.441 -0400", hash_original_field = "B637B17AF08ACED8850C18CCCDE915DA", hash_generated_field = "82BC5D885288BEA8F058C8200E42732B")

        private int k1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.441 -0400", hash_original_field = "61620957A1443C946A143CF99A7D24FA", hash_generated_field = "9A9BABB98FA71DB4E862A96C38A0DEB5")

        private int k2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.441 -0400", hash_original_field = "F7AB469D1DC79166FC874DADCC0DD854", hash_generated_field = "B93297072479995D07A6DAC48610EF09")

        private int k3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.441 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "28997BC83DA18A620109895922F10617")

        private BigInteger n;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.441 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

        private BigInteger h;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.441 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "3F0371905D46A3DF93ACA58D05B01E9C")

        private ECPoint.F2m infinity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.441 -0400", hash_original_field = "5C77EC7DAADCE22A1213046881A54B40", hash_generated_field = "FF1108A0424E980F296A774C118EF5E8")

        private byte mu = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.441 -0400", hash_original_field = "9A98A235BB28BA556F2A8960F7A384A8", hash_generated_field = "4DD43C8E43FDD8E564AAA02789FAC70C")

        private BigInteger[] si = null;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.442 -0400", hash_original_method = "DEC52BA66274A72254EB3F42E643013D", hash_generated_method = "D0986C1D732EC363393DF80C8862B1D1")
        public  F2m(
            int m,
            int k,
            BigInteger a,
            BigInteger b) {
            this(m, k, 0, 0, a, b, null, null);
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            addTaint(k);
            addTaint(m);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.442 -0400", hash_original_method = "F2139B4AB6C86388E7E3C9323DB40384", hash_generated_method = "8099BBA63F992C4F8A19596D2E64CCF7")
        public  F2m(
            int m, 
            int k, 
            BigInteger a, 
            BigInteger b,
            BigInteger n,
            BigInteger h) {
            this(m, k, 0, 0, a, b, n, h);
            addTaint(h.getTaint());
            addTaint(n.getTaint());
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            addTaint(k);
            addTaint(m);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.442 -0400", hash_original_method = "5E11630AFDD86B3E6F25DD938FDF4713", hash_generated_method = "42C4937A5C138EF07EEA09F0D15B42F9")
        public  F2m(
            int m,
            int k1,
            int k2,
            int k3,
            BigInteger a,
            BigInteger b) {
            this(m, k1, k2, k3, a, b, null, null);
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            addTaint(k3);
            addTaint(k2);
            addTaint(k1);
            addTaint(m);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.443 -0400", hash_original_method = "DFE62FA9A40BB48176925A509A87D7E7", hash_generated_method = "89E4D73FAAB960F27F829D4403F90BDD")
        public  F2m(
            int m, 
            int k1, 
            int k2, 
            int k3,
            BigInteger a, 
            BigInteger b,
            BigInteger n,
            BigInteger h) {
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            this.n = n;
            this.h = h;
            if(k1 == 0)            
            {
                IllegalArgumentException varC61641897B87AEAE255E76A9677C9C6C_1195812295 = new IllegalArgumentException("k1 must be > 0");
                varC61641897B87AEAE255E76A9677C9C6C_1195812295.addTaint(taint);
                throw varC61641897B87AEAE255E76A9677C9C6C_1195812295;
            } //End block
            if(k2 == 0)            
            {
                if(k3 != 0)                
                {
                    IllegalArgumentException var450989A420B395AA4EE14FF066EE37CA_403916070 = new IllegalArgumentException("k3 must be 0 if k2 == 0");
                    var450989A420B395AA4EE14FF066EE37CA_403916070.addTaint(taint);
                    throw var450989A420B395AA4EE14FF066EE37CA_403916070;
                } //End block
            } //End block
            else
            {
                if(k2 <= k1)                
                {
                    IllegalArgumentException var0EB121ECA88543D465A3EBFCD9122EA1_1663582087 = new IllegalArgumentException("k2 must be > k1");
                    var0EB121ECA88543D465A3EBFCD9122EA1_1663582087.addTaint(taint);
                    throw var0EB121ECA88543D465A3EBFCD9122EA1_1663582087;
                } //End block
                if(k3 <= k2)                
                {
                    IllegalArgumentException var0BA2B8A105297223AF1B1D2E7E312C4F_454769580 = new IllegalArgumentException("k3 must be > k2");
                    var0BA2B8A105297223AF1B1D2E7E312C4F_454769580.addTaint(taint);
                    throw var0BA2B8A105297223AF1B1D2E7E312C4F_454769580;
                } //End block
            } //End block
            this.a = fromBigInteger(a);
            this.b = fromBigInteger(b);
            this.infinity = new ECPoint.F2m(this, null, null);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.443 -0400", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "C774FEB84FA8DCACBC975866DF6F24C2")
        public int getFieldSize() {
            int var6F8F57715090DA2632453988D9A1501B_595101693 = (m);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082888420 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082888420;
            // ---------- Original Method ----------
            //return m;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.443 -0400", hash_original_method = "7AF48CB12A1921AAC7C154231A16AA21", hash_generated_method = "EDF79AAF5C687FC9BC3AC2F07B2DDA5E")
        public ECFieldElement fromBigInteger(BigInteger x) {
            addTaint(x.getTaint());
ECFieldElement var2192A5A60ACD6C969D10D16EBF531997_974507775 =             new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
            var2192A5A60ACD6C969D10D16EBF531997_974507775.addTaint(taint);
            return var2192A5A60ACD6C969D10D16EBF531997_974507775;
            // ---------- Original Method ----------
            //return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, x);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.444 -0400", hash_original_method = "166EA7512C9A204978606C53F7DDDB4A", hash_generated_method = "D44803D081906FD88469BCA714256826")
        public ECPoint createPoint(BigInteger x, BigInteger y, boolean withCompression) {
            addTaint(withCompression);
            addTaint(y.getTaint());
            addTaint(x.getTaint());
ECPoint var03FF0EF84700327CC816AF0C0D978C53_885670790 =             new ECPoint.F2m(this, fromBigInteger(x), fromBigInteger(y), withCompression);
            var03FF0EF84700327CC816AF0C0D978C53_885670790.addTaint(taint);
            return var03FF0EF84700327CC816AF0C0D978C53_885670790;
            // ---------- Original Method ----------
            //return new ECPoint.F2m(this, fromBigInteger(x), fromBigInteger(y), withCompression);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.445 -0400", hash_original_method = "3A440A2E6AC052FD5047F5B01472DA22", hash_generated_method = "00C86B10DA1FBC47277F7E9035D42DE1")
        public ECPoint decodePoint(byte[] encoded) {
            addTaint(encoded[0]);
            ECPoint p = null;
switch(encoded[0]){
            case 0x00:
            if(encoded.length > 1)            
            {
                RuntimeException varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_847003978 = new RuntimeException("Invalid point encoding");
                varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_847003978.addTaint(taint);
                throw varB3BB7E3E1FAB0FFCC2C96D0FCF4938C9_847003978;
            } //End block
            p = getInfinity();
            break;
            case 0x02:
            case 0x03:
            byte[] enc = new byte[encoded.length - 1];
            System.arraycopy(encoded, 1, enc, 0, enc.length);
            if(encoded[0] == 0x02)            
            {
                p = decompressPoint(enc, 0);
            } //End block
            else
            {
                p = decompressPoint(enc, 1);
            } //End block
            break;
            case 0x04:
            case 0x06:
            case 0x07:
            byte[] xEnc = new byte[(encoded.length - 1) / 2];
            byte[] yEnc = new byte[(encoded.length - 1) / 2];
            System.arraycopy(encoded, 1, xEnc, 0, xEnc.length);
            System.arraycopy(encoded, xEnc.length + 1, yEnc, 0, yEnc.length);
            p = new ECPoint.F2m(this,
                    new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3,
                        new BigInteger(1, xEnc)),
                    new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3,
                        new BigInteger(1, yEnc)), false);
            break;
            default:
            RuntimeException var6B576F84820FD10EFF078D43E27E2D72_1907069046 = new RuntimeException("Invalid point encoding 0x" + Integer.toString(encoded[0], 16));
            var6B576F84820FD10EFF078D43E27E2D72_1907069046.addTaint(taint);
            throw var6B576F84820FD10EFF078D43E27E2D72_1907069046;
}ECPoint var74E4690D9F2A026504928C017944E149_1282775306 =             p;
            var74E4690D9F2A026504928C017944E149_1282775306.addTaint(taint);
            return var74E4690D9F2A026504928C017944E149_1282775306;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.445 -0400", hash_original_method = "D748A17CBCA9116B03723FC1B2367E9D", hash_generated_method = "794448C94AFC028B158427F1520029EA")
        public ECPoint getInfinity() {
ECPoint varD826F01678C0988122ADB8C93417E177_323637672 =             infinity;
            varD826F01678C0988122ADB8C93417E177_323637672.addTaint(taint);
            return varD826F01678C0988122ADB8C93417E177_323637672;
            // ---------- Original Method ----------
            //return infinity;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.446 -0400", hash_original_method = "0873B9ADE54853DB8C371F01782A1B9E", hash_generated_method = "A3FC00174C213F66F5C2A6CC4FE8CB84")
        public boolean isKoblitz() {
            boolean var3A159A0BE54692E8571216DB24FAD4EB_1021582464 = (((n != null) && (h != null) &&
                    ((a.toBigInteger().equals(ECConstants.ZERO)) ||
                    (a.toBigInteger().equals(ECConstants.ONE))) &&
                    (b.toBigInteger().equals(ECConstants.ONE))));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_557209656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_557209656;
            // ---------- Original Method ----------
            //return ((n != null) && (h != null) &&
                    //((a.toBigInteger().equals(ECConstants.ZERO)) ||
                    //(a.toBigInteger().equals(ECConstants.ONE))) &&
                    //(b.toBigInteger().equals(ECConstants.ONE)));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.446 -0400", hash_original_method = "6A47B833A38B2C51AF1636CDFCEB3B55", hash_generated_method = "AD648E6597DB9DA93B3A3A5CFD79A27E")
        synchronized byte getMu() {
            if(mu == 0)            
            {
                mu = Tnaf.getMu(this);
            } //End block
            byte var89AA4B196B48C8A13A6549BB1EAEBD80_2003538869 = (mu);
                        byte var40EA57D3EE3C07BF1C102B466E1C3091_1589705016 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_1589705016;
            // ---------- Original Method ----------
            //if (mu == 0)
            //{
                //mu = Tnaf.getMu(this);
            //}
            //return mu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.447 -0400", hash_original_method = "C02001236D393BDCA3D2D65CC0F3FCD6", hash_generated_method = "69900187309E568E7D56831B56D9995D")
        synchronized BigInteger[] getSi() {
            if(si == null)            
            {
                si = Tnaf.getSi(this);
            } //End block
BigInteger[] var316474D4DA67FD8479E170FE8E19F283_2113659500 =             si;
            var316474D4DA67FD8479E170FE8E19F283_2113659500.addTaint(taint);
            return var316474D4DA67FD8479E170FE8E19F283_2113659500;
            // ---------- Original Method ----------
            //if (si == null)
            //{
                //si = Tnaf.getSi(this);
            //}
            //return si;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.448 -0400", hash_original_method = "ABCDD5682443273B6E9EF7110AFEAA10", hash_generated_method = "061A3EE76A61AD88D6B3964A2C49F4F8")
        private ECPoint decompressPoint(
            byte[] xEnc, 
            int ypBit) {
            addTaint(ypBit);
            addTaint(xEnc[0]);
            ECFieldElement xp = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, new BigInteger(1, xEnc));
            ECFieldElement yp = null;
            if(xp.toBigInteger().equals(ECConstants.ZERO))            
            {
                yp = (ECFieldElement.F2m)b;
for(int i = 0;i < m - 1;i++)
                {
                    yp = yp.square();
                } //End block
            } //End block
            else
            {
                ECFieldElement beta = xp.add(a).add(
                        b.multiply(xp.square().invert()));
                ECFieldElement z = solveQuadradicEquation(beta);
                if(z == null)                
                {
                    RuntimeException var073123230BDDEAB03F8CC2D1C501D87E_789576892 = new RuntimeException("Invalid point compression");
                    var073123230BDDEAB03F8CC2D1C501D87E_789576892.addTaint(taint);
                    throw var073123230BDDEAB03F8CC2D1C501D87E_789576892;
                } //End block
                int zBit = 0;
                if(z.toBigInteger().testBit(0))                
                {
                    zBit = 1;
                } //End block
                if(zBit != ypBit)                
                {
                    z = z.add(new ECFieldElement.F2m(this.m, this.k1, this.k2,
                            this.k3, ECConstants.ONE));
                } //End block
                yp = xp.multiply(z);
            } //End block
ECPoint varD903BA7B856E5972E8BD7D9E7940A611_1672650258 =             new ECPoint.F2m(this, xp, yp);
            varD903BA7B856E5972E8BD7D9E7940A611_1672650258.addTaint(taint);
            return varD903BA7B856E5972E8BD7D9E7940A611_1672650258;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.449 -0400", hash_original_method = "25ED10C579C6ED4884A834D5A2CEB482", hash_generated_method = "FBED8B59F28FDCF4994822E7CCFC73E8")
        private ECFieldElement solveQuadradicEquation(ECFieldElement beta) {
            addTaint(beta.getTaint());
            ECFieldElement zeroElement = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, ECConstants.ZERO);
            if(beta.toBigInteger().equals(ECConstants.ZERO))            
            {
ECFieldElement var99B607BA1DEFDB54F96AED6A216D9277_801773012 =                 zeroElement;
                var99B607BA1DEFDB54F96AED6A216D9277_801773012.addTaint(taint);
                return var99B607BA1DEFDB54F96AED6A216D9277_801773012;
            } //End block
            ECFieldElement z = null;
            ECFieldElement gamma = zeroElement;
            Random rand = new Random();
            do {
                {
                    ECFieldElement t = new ECFieldElement.F2m(this.m, this.k1,
                        this.k2, this.k3, new BigInteger(m, rand));
                    z = zeroElement;
                    ECFieldElement w = beta;
for(int i = 1;i <= m - 1;i++)
                    {
                        ECFieldElement w2 = w.square();
                        z = z.square().add(w2.multiply(t));
                        w = w2.add(beta);
                    } //End block
                    if(!w.toBigInteger().equals(ECConstants.ZERO))                    
                    {
ECFieldElement var540C13E9E156B687226421B24F2DF178_364808536 =                         null;
                        var540C13E9E156B687226421B24F2DF178_364808536.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_364808536;
                    } //End block
                    gamma = z.square().add(z);
                } //End block
} while (gamma.toBigInteger().equals(ECConstants.ZERO));
ECFieldElement var07014B16947C3ECA078D6A03A18D6101_1664051809 =             z;
            var07014B16947C3ECA078D6A03A18D6101_1664051809.addTaint(taint);
            return var07014B16947C3ECA078D6A03A18D6101_1664051809;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.450 -0400", hash_original_method = "5F33BE6BAAB2ADDEB5EF1D1748825E7B", hash_generated_method = "1A9B26CD8423CC638828D6CBE9E16861")
        public boolean equals(
            Object anObject) {
            addTaint(anObject.getTaint());
            if(anObject == this)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_966359547 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522357309 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_522357309;
            } //End block
            if(!(anObject instanceof ECCurve.F2m))            
            {
                boolean var68934A3E9455FA72420237EB05902327_927143167 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451698436 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_451698436;
            } //End block
            ECCurve.F2m other = (ECCurve.F2m)anObject;
            boolean varE4B05A1198E46519975331865A8C8EA5_2075691152 = ((this.m == other.m) && (this.k1 == other.k1)
                && (this.k2 == other.k2) && (this.k3 == other.k3)
                && a.equals(other.a) && b.equals(other.b));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560064460 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_560064460;
            // ---------- Original Method ----------
            //if (anObject == this) 
            //{
                //return true;
            //}
            //if (!(anObject instanceof ECCurve.F2m)) 
            //{
                //return false;
            //}
            //ECCurve.F2m other = (ECCurve.F2m)anObject;
            //return (this.m == other.m) && (this.k1 == other.k1)
                //&& (this.k2 == other.k2) && (this.k3 == other.k3)
                //&& a.equals(other.a) && b.equals(other.b);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.450 -0400", hash_original_method = "E92144A56D15AF334E01FB92437AD76B", hash_generated_method = "C5990DEB07472262E6AE15E18E6B6B65")
        public int hashCode() {
            int var094CC37330A541EC50C4AE279DAFABD8_931659552 = (this.a.hashCode() ^ this.b.hashCode() ^ m ^ k1 ^ k2 ^ k3);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990535132 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990535132;
            // ---------- Original Method ----------
            //return this.a.hashCode() ^ this.b.hashCode() ^ m ^ k1 ^ k2 ^ k3;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.451 -0400", hash_original_method = "2FA087881284515E1CE9CA954B1F01D0", hash_generated_method = "C04D75A77B95B0E849284E46A80A4C4E")
        public int getM() {
            int var6F8F57715090DA2632453988D9A1501B_442320496 = (m);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30287735 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30287735;
            // ---------- Original Method ----------
            //return m;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.451 -0400", hash_original_method = "0A21FBE14C3CF35BF18E601EA9469DB4", hash_generated_method = "745A4ACBC6F0AD8C0BF873BE25B3D54E")
        public boolean isTrinomial() {
            boolean varF61B4889BFF262902FBF9BAA3E934E2B_1953663622 = (k2 == 0 && k3 == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_755485204 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_755485204;
            // ---------- Original Method ----------
            //return k2 == 0 && k3 == 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.451 -0400", hash_original_method = "6F5E01D9EB3F8F69F3EDFAB71A89E9BA", hash_generated_method = "9A0A4FC309E0B1BA7DEF75BF44180C1A")
        public int getK1() {
            int varB637B17AF08ACED8850C18CCCDE915DA_1883201190 = (k1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1856684262 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1856684262;
            // ---------- Original Method ----------
            //return k1;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.452 -0400", hash_original_method = "39AC234DC3848032A728401BC68DF439", hash_generated_method = "3FF1D45B23E9BD7CF9BE8AC50D89A895")
        public int getK2() {
            int var61620957A1443C946A143CF99A7D24FA_244451912 = (k2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916416400 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916416400;
            // ---------- Original Method ----------
            //return k2;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.452 -0400", hash_original_method = "A40D42566F753B213E5F7F205217D7F1", hash_generated_method = "4BBD7E6CC449E1BB7F5541B4351362FE")
        public int getK3() {
            int varF7AB469D1DC79166FC874DADCC0DD854_1586247207 = (k3);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247593241 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247593241;
            // ---------- Original Method ----------
            //return k3;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.452 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "C2994974000F62F1AC384D1D050EAD37")
        public BigInteger getN() {
BigInteger var041154653C812B0D1663EC287BE4C757_917687947 =             n;
            var041154653C812B0D1663EC287BE4C757_917687947.addTaint(taint);
            return var041154653C812B0D1663EC287BE4C757_917687947;
            // ---------- Original Method ----------
            //return n;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.452 -0400", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "4247C544CCE0A9CCA5F406A8E8A3DB38")
        public BigInteger getH() {
BigInteger var81CECAAA363C2B26C476DE4A79F58961_297080952 =             h;
            var81CECAAA363C2B26C476DE4A79F58961_297080952.addTaint(taint);
            return var81CECAAA363C2B26C476DE4A79F58961_297080952;
            // ---------- Original Method ----------
            //return h;
        }

        
    }


    
}

