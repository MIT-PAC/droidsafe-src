package org.bouncycastle.math.ec;

// Droidsafe Imports
import java.math.BigInteger;
import java.util.Random;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class ECFieldElement implements ECConstants {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.559 -0400", hash_original_method = "18B929116CB81747CE726807F2C6A2C0", hash_generated_method = "18B929116CB81747CE726807F2C6A2C0")
    public ECFieldElement ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract BigInteger     toBigInteger();

    
    @DSModeled(DSC.SAFE)
    public abstract String         getFieldName();

    
    @DSModeled(DSC.SAFE)
    public abstract int            getFieldSize();

    
    @DSModeled(DSC.SAFE)
    public abstract ECFieldElement add(ECFieldElement b);

    
    @DSModeled(DSC.SAFE)
    public abstract ECFieldElement subtract(ECFieldElement b);

    
    @DSModeled(DSC.SAFE)
    public abstract ECFieldElement multiply(ECFieldElement b);

    
    @DSModeled(DSC.SAFE)
    public abstract ECFieldElement divide(ECFieldElement b);

    
    @DSModeled(DSC.SAFE)
    public abstract ECFieldElement negate();

    
    @DSModeled(DSC.SAFE)
    public abstract ECFieldElement square();

    
    @DSModeled(DSC.SAFE)
    public abstract ECFieldElement invert();

    
    @DSModeled(DSC.SAFE)
    public abstract ECFieldElement sqrt();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.561 -0400", hash_original_method = "0A600F50B2D3858965A3E5F0EE37FE95", hash_generated_method = "1071B39BBB2ACDD6B09EFA564B83E4A5")
    public String toString() {
String var9B750EC2909B6FC9C2DCE0545795AB11_1165176666 =         this.toBigInteger().toString(2);
        var9B750EC2909B6FC9C2DCE0545795AB11_1165176666.addTaint(taint);
        return var9B750EC2909B6FC9C2DCE0545795AB11_1165176666;
        // ---------- Original Method ----------
        //return this.toBigInteger().toString(2);
    }

    
    public static class Fp extends ECFieldElement {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.561 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "8A69D3B9CF67CA1128DF293842071E77")

        BigInteger x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.561 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "F819999E3B2036A19089F4FD0B5D94F4")

        BigInteger q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.561 -0400", hash_original_method = "2CEE87D2C14E1CA252587D4A1EA48723", hash_generated_method = "6377CD24C52E5C84E2F822231A3EB89B")
        public  Fp(BigInteger q, BigInteger x) {
            this.x = x;
            if(x.compareTo(q) >= 0)            
            {
                IllegalArgumentException varB3CB45172D3A94C252A8E0B24738EE73_938355391 = new IllegalArgumentException("x value too large in field element");
                varB3CB45172D3A94C252A8E0B24738EE73_938355391.addTaint(taint);
                throw varB3CB45172D3A94C252A8E0B24738EE73_938355391;
            } //End block
            this.q = q;
            // ---------- Original Method ----------
            //this.x = x;
            //if (x.compareTo(q) >= 0)
            //{
                //throw new IllegalArgumentException("x value too large in field element");
            //}
            //this.q = q;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.561 -0400", hash_original_method = "980758C44AA9D55BE8845E0F1627D066", hash_generated_method = "3F25821AC184C0BCAB9A4BF76924F2F5")
        public BigInteger toBigInteger() {
BigInteger varEA5659DA512DECF23E6D37EE8060D074_1945304129 =             x;
            varEA5659DA512DECF23E6D37EE8060D074_1945304129.addTaint(taint);
            return varEA5659DA512DECF23E6D37EE8060D074_1945304129;
            // ---------- Original Method ----------
            //return x;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.562 -0400", hash_original_method = "0E8B7E675C6828F2CC0DC48F96E6F8E3", hash_generated_method = "653A9189271F72D46F2C5181D2A9BFA1")
        public String getFieldName() {
String varEA74BFECD01ADB646158482B0707242D_241261488 =             "Fp";
            varEA74BFECD01ADB646158482B0707242D_241261488.addTaint(taint);
            return varEA74BFECD01ADB646158482B0707242D_241261488;
            // ---------- Original Method ----------
            //return "Fp";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.562 -0400", hash_original_method = "B586F82D19D11BCE8142121499961CE9", hash_generated_method = "27E3ED8EE7F401CD16DDD0FC678AABA2")
        public int getFieldSize() {
            int var0769037565AC374C9291621AA66E8145_936348983 = (q.bitLength());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_673175843 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_673175843;
            // ---------- Original Method ----------
            //return q.bitLength();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.562 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "861FFAFDFDB0495838FB80043343C63F")
        public BigInteger getQ() {
BigInteger varBEF1B7662E10AF6D5747729987514CB6_1560777627 =             q;
            varBEF1B7662E10AF6D5747729987514CB6_1560777627.addTaint(taint);
            return varBEF1B7662E10AF6D5747729987514CB6_1560777627;
            // ---------- Original Method ----------
            //return q;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.562 -0400", hash_original_method = "81C2635B1C8BBF0D98329C00DDA86CBF", hash_generated_method = "61998E36019D229BC87A78280F0EA675")
        public ECFieldElement add(ECFieldElement b) {
            addTaint(b.getTaint());
ECFieldElement var95CD65D7E9E9B30879AC7D6DC02DEBD6_1557390276 =             new Fp(q, x.add(b.toBigInteger()).mod(q));
            var95CD65D7E9E9B30879AC7D6DC02DEBD6_1557390276.addTaint(taint);
            return var95CD65D7E9E9B30879AC7D6DC02DEBD6_1557390276;
            // ---------- Original Method ----------
            //return new Fp(q, x.add(b.toBigInteger()).mod(q));
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.563 -0400", hash_original_method = "CC55B0F5614FEECA03D2E059411B5A62", hash_generated_method = "76019315EEBA5C94D8FD658AC7E58CDE")
        public ECFieldElement subtract(ECFieldElement b) {
            addTaint(b.getTaint());
ECFieldElement varD8B8420F07FA66AA2D7A0248ABEB3539_2049312727 =             new Fp(q, x.subtract(b.toBigInteger()).mod(q));
            varD8B8420F07FA66AA2D7A0248ABEB3539_2049312727.addTaint(taint);
            return varD8B8420F07FA66AA2D7A0248ABEB3539_2049312727;
            // ---------- Original Method ----------
            //return new Fp(q, x.subtract(b.toBigInteger()).mod(q));
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.563 -0400", hash_original_method = "8FDF6CC967FA6FBF2AB862654F18B35A", hash_generated_method = "0D2D55A42804CA623175385C7DA08E82")
        public ECFieldElement multiply(ECFieldElement b) {
            addTaint(b.getTaint());
ECFieldElement var721CE09C12047DA4DC97E558E685713B_1236773874 =             new Fp(q, x.multiply(b.toBigInteger()).mod(q));
            var721CE09C12047DA4DC97E558E685713B_1236773874.addTaint(taint);
            return var721CE09C12047DA4DC97E558E685713B_1236773874;
            // ---------- Original Method ----------
            //return new Fp(q, x.multiply(b.toBigInteger()).mod(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.563 -0400", hash_original_method = "273EB04F445D1E8BD427B46F09A750C8", hash_generated_method = "0405120EF9387FA5F9BBAF0F59720455")
        public ECFieldElement divide(ECFieldElement b) {
            addTaint(b.getTaint());
ECFieldElement var91340398E306B41FC40D6A74F045FBCF_351705564 =             new Fp(q, x.multiply(b.toBigInteger().modInverse(q)).mod(q));
            var91340398E306B41FC40D6A74F045FBCF_351705564.addTaint(taint);
            return var91340398E306B41FC40D6A74F045FBCF_351705564;
            // ---------- Original Method ----------
            //return new Fp(q, x.multiply(b.toBigInteger().modInverse(q)).mod(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.564 -0400", hash_original_method = "9EF54D69A52E7076272AA6C8111B6A31", hash_generated_method = "05991A7FC566EFFFBFF47618DD03128A")
        public ECFieldElement negate() {
ECFieldElement varAF04B96EA998AE163274400B0D7DE06F_662063516 =             new Fp(q, x.negate().mod(q));
            varAF04B96EA998AE163274400B0D7DE06F_662063516.addTaint(taint);
            return varAF04B96EA998AE163274400B0D7DE06F_662063516;
            // ---------- Original Method ----------
            //return new Fp(q, x.negate().mod(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.564 -0400", hash_original_method = "1F15D9F4F3F7C45F6D78B4A8A149E9FC", hash_generated_method = "1B8556D2321C3A327050AF6207B84A32")
        public ECFieldElement square() {
ECFieldElement var093D94E671FE87C574D7FD482BCC127A_640203051 =             new Fp(q, x.multiply(x).mod(q));
            var093D94E671FE87C574D7FD482BCC127A_640203051.addTaint(taint);
            return var093D94E671FE87C574D7FD482BCC127A_640203051;
            // ---------- Original Method ----------
            //return new Fp(q, x.multiply(x).mod(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.564 -0400", hash_original_method = "87CD41222C6FB4EC59F31E743CC1D431", hash_generated_method = "E42FADDC211B8D6AD97BC6BE1634BD17")
        public ECFieldElement invert() {
ECFieldElement varFEF24BB86BC223E29D9B2D72028A527B_1267919829 =             new Fp(q, x.modInverse(q));
            varFEF24BB86BC223E29D9B2D72028A527B_1267919829.addTaint(taint);
            return varFEF24BB86BC223E29D9B2D72028A527B_1267919829;
            // ---------- Original Method ----------
            //return new Fp(q, x.modInverse(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.565 -0400", hash_original_method = "27B2154E50FF6039CAEE06398FCA6C60", hash_generated_method = "34433327C529C9257244FEF73853114F")
        public ECFieldElement sqrt() {
            if(!q.testBit(0))            
            {
                RuntimeException varDC49C9CCC8D464733337D79D36F9AAD1_1486690115 = new RuntimeException("not done yet");
                varDC49C9CCC8D464733337D79D36F9AAD1_1486690115.addTaint(taint);
                throw varDC49C9CCC8D464733337D79D36F9AAD1_1486690115;
            } //End block
            if(q.testBit(1))            
            {
                ECFieldElement z = new Fp(q, x.modPow(q.shiftRight(2).add(ECConstants.ONE), q));
ECFieldElement var3E43DBDF6B8E8414F8E5F926A23338D3_590753293 =                 z.square().equals(this) ? z : null;
                var3E43DBDF6B8E8414F8E5F926A23338D3_590753293.addTaint(taint);
                return var3E43DBDF6B8E8414F8E5F926A23338D3_590753293;
            } //End block
            BigInteger qMinusOne = q.subtract(ECConstants.ONE);
            BigInteger legendreExponent = qMinusOne.shiftRight(1);
            if(!(x.modPow(legendreExponent, q).equals(ECConstants.ONE)))            
            {
ECFieldElement var540C13E9E156B687226421B24F2DF178_1734703497 =                 null;
                var540C13E9E156B687226421B24F2DF178_1734703497.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1734703497;
            } //End block
            BigInteger u = qMinusOne.shiftRight(2);
            BigInteger k = u.shiftLeft(1).add(ECConstants.ONE);
            BigInteger Q = this.x;
            BigInteger fourQ = Q.shiftLeft(2).mod(q);
            BigInteger U;
            BigInteger V;
            Random rand = new Random();
            do {
                {
                    BigInteger P;
                    do {
                        {
                            P = new BigInteger(q.bitLength(), rand);
                        } //End block
} while (P.compareTo(q) >= 0
                    || !(P.multiply(P).subtract(fourQ).modPow(legendreExponent, q).equals(qMinusOne)));
                    BigInteger[] result = lucasSequence(q, P, Q, k);
                    U = result[0];
                    V = result[1];
                    if(V.multiply(V).mod(q).equals(fourQ))                    
                    {
                        if(V.testBit(0))                        
                        {
                            V = V.add(q);
                        } //End block
                        V = V.shiftRight(1);
ECFieldElement var4BF768B78687B548C85E5A6267B2FC18_913217912 =                         new ECFieldElement.Fp(q, V);
                        var4BF768B78687B548C85E5A6267B2FC18_913217912.addTaint(taint);
                        return var4BF768B78687B548C85E5A6267B2FC18_913217912;
                    } //End block
                } //End block
} while (U.equals(ECConstants.ONE) || U.equals(qMinusOne));
ECFieldElement var540C13E9E156B687226421B24F2DF178_1555834571 =             null;
            var540C13E9E156B687226421B24F2DF178_1555834571.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1555834571;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static BigInteger[] lucasSequence(
            BigInteger  p,
            BigInteger  P,
            BigInteger  Q,
            BigInteger  k) {
            int n = k.bitLength();
            int s = k.getLowestSetBit();
            BigInteger Uh = ECConstants.ONE;
            BigInteger Vl = ECConstants.TWO;
            BigInteger Vh = P;
            BigInteger Ql = ECConstants.ONE;
            BigInteger Qh = ECConstants.ONE;
            for (int j = n - 1; j >= s + 1; --j)
            {
                Ql = Ql.multiply(Qh).mod(p);
                if (k.testBit(j))
                {
                    Qh = Ql.multiply(Q).mod(p);
                    Uh = Uh.multiply(Vh).mod(p);
                    Vl = Vh.multiply(Vl).subtract(P.multiply(Ql)).mod(p);
                    Vh = Vh.multiply(Vh).subtract(Qh.shiftLeft(1)).mod(p);
                }
                else
                {
                    Qh = Ql;
                    Uh = Uh.multiply(Vl).subtract(Ql).mod(p);
                    Vh = Vh.multiply(Vl).subtract(P.multiply(Ql)).mod(p);
                    Vl = Vl.multiply(Vl).subtract(Ql.shiftLeft(1)).mod(p);
                }
            }
            Ql = Ql.multiply(Qh).mod(p);
            Qh = Ql.multiply(Q).mod(p);
            Uh = Uh.multiply(Vl).subtract(Ql).mod(p);
            Vl = Vh.multiply(Vl).subtract(P.multiply(Ql)).mod(p);
            Ql = Ql.multiply(Qh).mod(p);
            for (int j = 1; j <= s; ++j)
            {
                Uh = Uh.multiply(Vl).mod(p);
                Vl = Vl.multiply(Vl).subtract(Ql.shiftLeft(1)).mod(p);
                Ql = Ql.multiply(Ql).mod(p);
            }
            return new BigInteger[]{ Uh, Vl };
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.566 -0400", hash_original_method = "F275DE81E4C5BCC7A64CB08B0E3C6B94", hash_generated_method = "1C5923571DAA1378CB556661E3380448")
        public boolean equals(Object other) {
            addTaint(other.getTaint());
            if(other == this)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_738250231 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040753457 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040753457;
            } //End block
            if(!(other instanceof ECFieldElement.Fp))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1625805882 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670618381 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670618381;
            } //End block
            ECFieldElement.Fp o = (ECFieldElement.Fp)other;
            boolean var761CEA50B135B830D797A5C431CF642B_1873921649 = (q.equals(o.q) && x.equals(o.x));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1611614597 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1611614597;
            // ---------- Original Method ----------
            //if (other == this)
            //{
                //return true;
            //}
            //if (!(other instanceof ECFieldElement.Fp))
            //{
                //return false;
            //}
            //ECFieldElement.Fp o = (ECFieldElement.Fp)other;
            //return q.equals(o.q) && x.equals(o.x);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.566 -0400", hash_original_method = "61E77154098D5712686019259E83DC28", hash_generated_method = "F536AAB82468FC1EE4B001B771EC731B")
        public int hashCode() {
            int var47CAD9BD55BDFC41A1191D6715C04270_1146203250 = (q.hashCode() ^ x.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_352307175 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_352307175;
            // ---------- Original Method ----------
            //return q.hashCode() ^ x.hashCode();
        }

        
    }


    
    public static class F2m extends ECFieldElement {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.566 -0400", hash_original_field = "EE16755AF8C89D0C26540DAF7A0FE1B3", hash_generated_field = "05684F2BDAA8EE0BD6A4A6166AA30FB6")

        private int representation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.566 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

        private int m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.566 -0400", hash_original_field = "B637B17AF08ACED8850C18CCCDE915DA", hash_generated_field = "82BC5D885288BEA8F058C8200E42732B")

        private int k1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.566 -0400", hash_original_field = "61620957A1443C946A143CF99A7D24FA", hash_generated_field = "9A9BABB98FA71DB4E862A96C38A0DEB5")

        private int k2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.566 -0400", hash_original_field = "F7AB469D1DC79166FC874DADCC0DD854", hash_generated_field = "B93297072479995D07A6DAC48610EF09")

        private int k3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.566 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "8009D56CC2C16E6B1ECA88AD9DDD4454")

        private IntArray x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.566 -0400", hash_original_field = "E358EFA489F58062F10DD7316B65649E", hash_generated_field = "C6BE2DA2DF5011CA37BB619361E1CF67")

        private int t;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.567 -0400", hash_original_method = "30B70FEF02DF1B2128C82CD1FCC1318F", hash_generated_method = "B8A39F6697FF6A54DD834C35292F132B")
        public  F2m(
            int m, 
            int k1, 
            int k2, 
            int k3,
            BigInteger x) {
            t = (m + 31) >> 5;
            this.x = new IntArray(x, t);
            if((k2 == 0) && (k3 == 0))            
            {
                this.representation = TPB;
            } //End block
            else
            {
                if(k2 >= k3)                
                {
                    IllegalArgumentException var047CAF9799C59B2CC26D28A401C7EA9F_1510116752 = new IllegalArgumentException(
                            "k2 must be smaller than k3");
                    var047CAF9799C59B2CC26D28A401C7EA9F_1510116752.addTaint(taint);
                    throw var047CAF9799C59B2CC26D28A401C7EA9F_1510116752;
                } //End block
                if(k2 <= 0)                
                {
                    IllegalArgumentException varBFB69105FAC554536930812AACB69C4D_2002157331 = new IllegalArgumentException(
                            "k2 must be larger than 0");
                    varBFB69105FAC554536930812AACB69C4D_2002157331.addTaint(taint);
                    throw varBFB69105FAC554536930812AACB69C4D_2002157331;
                } //End block
                this.representation = PPB;
            } //End block
            if(x.signum() < 0)            
            {
                IllegalArgumentException var6CCA8111E0BEC017E77440F342CC24CF_15024035 = new IllegalArgumentException("x value cannot be negative");
                var6CCA8111E0BEC017E77440F342CC24CF_15024035.addTaint(taint);
                throw var6CCA8111E0BEC017E77440F342CC24CF_15024035;
            } //End block
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.567 -0400", hash_original_method = "769D94FCBFF8D8B7B44421BAE1CCBF10", hash_generated_method = "B02FE738288DDE8CD2C1FAA705C99AB9")
        public  F2m(int m, int k, BigInteger x) {
            this(m, k, 0, 0, x);
            addTaint(x.getTaint());
            addTaint(k);
            addTaint(m);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.568 -0400", hash_original_method = "E37831F6788FECA0B3C28407A9D117A4", hash_generated_method = "0A25AF3D31E3563872BEF9704D2BA9E8")
        private  F2m(int m, int k1, int k2, int k3, IntArray x) {
            t = (m + 31) >> 5;
            this.x = x;
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            if((k2 == 0) && (k3 == 0))            
            {
                this.representation = TPB;
            } //End block
            else
            {
                this.representation = PPB;
            } //End block
            // ---------- Original Method ----------
            //t = (m + 31) >> 5;
            //this.x = x;
            //this.m = m;
            //this.k1 = k1;
            //this.k2 = k2;
            //this.k3 = k3;
            //if ((k2 == 0) && (k3 == 0))
            //{
                //this.representation = TPB;
            //}
            //else
            //{
                //this.representation = PPB;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.568 -0400", hash_original_method = "D9240AE462D2FCFCBEB9680DA07047D8", hash_generated_method = "00E607104E046B1D8D993C9C15366D07")
        public BigInteger toBigInteger() {
BigInteger varA5CABE31C940B93287B41AAF30CBBD9D_2793284 =             x.toBigInteger();
            varA5CABE31C940B93287B41AAF30CBBD9D_2793284.addTaint(taint);
            return varA5CABE31C940B93287B41AAF30CBBD9D_2793284;
            // ---------- Original Method ----------
            //return x.toBigInteger();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.568 -0400", hash_original_method = "69EE8C1832EFB43BF906E0C4BE94B23A", hash_generated_method = "9F9E76E832AC6458EC9D6BBF1963A64F")
        public String getFieldName() {
String var09AD38A4C279366F522630A4F3F38326_1476209697 =             "F2m";
            var09AD38A4C279366F522630A4F3F38326_1476209697.addTaint(taint);
            return var09AD38A4C279366F522630A4F3F38326_1476209697;
            // ---------- Original Method ----------
            //return "F2m";
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.568 -0400", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "4A008C15BFF33A6FE2EC184FACD62705")
        public int getFieldSize() {
            int var6F8F57715090DA2632453988D9A1501B_1918975746 = (m);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524357578 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524357578;
            // ---------- Original Method ----------
            //return m;
        }

        
        public static void checkFieldElements(
            ECFieldElement a,
            ECFieldElement b) {
            if ((!(a instanceof F2m)) || (!(b instanceof F2m)))
            {
                throw new IllegalArgumentException("Field elements are not "
                        + "both instances of ECFieldElement.F2m");
            }
            ECFieldElement.F2m aF2m = (ECFieldElement.F2m)a;
            ECFieldElement.F2m bF2m = (ECFieldElement.F2m)b;
            if ((aF2m.m != bF2m.m) || (aF2m.k1 != bF2m.k1)
                    || (aF2m.k2 != bF2m.k2) || (aF2m.k3 != bF2m.k3))
            {
                throw new IllegalArgumentException("Field elements are not "
                        + "elements of the same field F2m");
            }
            if (aF2m.representation != bF2m.representation)
            {
                throw new IllegalArgumentException(
                        "One of the field "
                                + "elements are not elements has incorrect representation");
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.568 -0400", hash_original_method = "1771E6C8DC949344BED4A1E6536DC20F", hash_generated_method = "1377D7055B2A706649B8D4D908BF4D91")
        public ECFieldElement add(final ECFieldElement b) {
            addTaint(b.getTaint());
            IntArray iarrClone = (IntArray)this.x.clone();
            F2m bF2m = (F2m)b;
            iarrClone.addShifted(bF2m.x, 0);
ECFieldElement var05CCF13E4F1E050A83D5CD6B3B4844DB_1796042216 =             new F2m(m, k1, k2, k3, iarrClone);
            var05CCF13E4F1E050A83D5CD6B3B4844DB_1796042216.addTaint(taint);
            return var05CCF13E4F1E050A83D5CD6B3B4844DB_1796042216;
            // ---------- Original Method ----------
            //IntArray iarrClone = (IntArray)this.x.clone();
            //F2m bF2m = (F2m)b;
            //iarrClone.addShifted(bF2m.x, 0);
            //return new F2m(m, k1, k2, k3, iarrClone);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.569 -0400", hash_original_method = "DED14713A83018FDD63888AD3FB6A659", hash_generated_method = "81C3C2A4794FE1695CC2DBCA11E3FD44")
        public ECFieldElement subtract(final ECFieldElement b) {
            addTaint(b.getTaint());
ECFieldElement var9DB025919878C446BA442101E8E28F74_192332611 =             add(b);
            var9DB025919878C446BA442101E8E28F74_192332611.addTaint(taint);
            return var9DB025919878C446BA442101E8E28F74_192332611;
            // ---------- Original Method ----------
            //return add(b);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.569 -0400", hash_original_method = "CFFAAAAE4FA7236DDDBD1DC710F4AF58", hash_generated_method = "EC95BAE3B798A2A3F9549CA7CC36FE9B")
        public ECFieldElement multiply(final ECFieldElement b) {
            addTaint(b.getTaint());
            F2m bF2m = (F2m)b;
            IntArray mult = x.multiply(bF2m.x, m);
            mult.reduce(m, new int[]{k1, k2, k3});
ECFieldElement var607E4A0964B00B8064FAFC5C09036C82_1517042471 =             new F2m(m, k1, k2, k3, mult);
            var607E4A0964B00B8064FAFC5C09036C82_1517042471.addTaint(taint);
            return var607E4A0964B00B8064FAFC5C09036C82_1517042471;
            // ---------- Original Method ----------
            //F2m bF2m = (F2m)b;
            //IntArray mult = x.multiply(bF2m.x, m);
            //mult.reduce(m, new int[]{k1, k2, k3});
            //return new F2m(m, k1, k2, k3, mult);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.569 -0400", hash_original_method = "69832D94122014C087767F6408988886", hash_generated_method = "53E9F79787E0474CADBF071C98DE1DF6")
        public ECFieldElement divide(final ECFieldElement b) {
            addTaint(b.getTaint());
            ECFieldElement bInv = b.invert();
ECFieldElement var59F8A028BD520BE6E99E368FC9AFB90A_33118199 =             multiply(bInv);
            var59F8A028BD520BE6E99E368FC9AFB90A_33118199.addTaint(taint);
            return var59F8A028BD520BE6E99E368FC9AFB90A_33118199;
            // ---------- Original Method ----------
            //ECFieldElement bInv = b.invert();
            //return multiply(bInv);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.569 -0400", hash_original_method = "3796F7BD0BD7CB77DE18BFC002B0C069", hash_generated_method = "657404E47756574F6F049D47FB4883FE")
        public ECFieldElement negate() {
ECFieldElement var72A74007B2BE62B849F475C7BDA4658B_1432207981 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1432207981.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1432207981;
            // ---------- Original Method ----------
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.569 -0400", hash_original_method = "C7941F6A7028361E62B5AB4ECF6F47B0", hash_generated_method = "6DCBAB158B6CE945DE006D7892E8CA87")
        public ECFieldElement square() {
            IntArray squared = x.square(m);
            squared.reduce(m, new int[]{k1, k2, k3});
ECFieldElement var974601C2E38A39842811A3629969E27D_1199998606 =             new F2m(m, k1, k2, k3, squared);
            var974601C2E38A39842811A3629969E27D_1199998606.addTaint(taint);
            return var974601C2E38A39842811A3629969E27D_1199998606;
            // ---------- Original Method ----------
            //IntArray squared = x.square(m);
            //squared.reduce(m, new int[]{k1, k2, k3});
            //return new F2m(m, k1, k2, k3, squared);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.570 -0400", hash_original_method = "1700F54C0CA191DF0B1880FDDD97556A", hash_generated_method = "0A481C73F4641298F7D473067346BD81")
        public ECFieldElement invert() {
            IntArray uz = (IntArray)this.x.clone();
            IntArray vz = new IntArray(t);
            vz.setBit(m);
            vz.setBit(0);
            vz.setBit(this.k1);
            if(this.representation == PPB)            
            {
                vz.setBit(this.k2);
                vz.setBit(this.k3);
            } //End block
            IntArray g1z = new IntArray(t);
            g1z.setBit(0);
            IntArray g2z = new IntArray(t);
            while
(!uz.isZero())            
            {
                int j = uz.bitLength() - vz.bitLength();
                if(j < 0)                
                {
                    final IntArray uzCopy = uz;
                    uz = vz;
                    vz = uzCopy;
                    final IntArray g1zCopy = g1z;
                    g1z = g2z;
                    g2z = g1zCopy;
                    j = -j;
                } //End block
                int jInt = j >> 5;
                int jBit = j & 0x1F;
                IntArray vzShift = vz.shiftLeft(jBit);
                uz.addShifted(vzShift, jInt);
                IntArray g2zShift = g2z.shiftLeft(jBit);
                g1z.addShifted(g2zShift, jInt);
            } //End block
ECFieldElement varDA978903C722F906B630B871248C94CE_237211089 =             new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, g2z);
            varDA978903C722F906B630B871248C94CE_237211089.addTaint(taint);
            return varDA978903C722F906B630B871248C94CE_237211089;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.570 -0400", hash_original_method = "3F2FB8B8358C44CE763B294C61568C61", hash_generated_method = "C87134F4176ECB270378E2037C803EFE")
        public ECFieldElement sqrt() {
            RuntimeException varECF25F51942B946710F937BB139F9A1F_1774297119 = new RuntimeException("Not implemented");
            varECF25F51942B946710F937BB139F9A1F_1774297119.addTaint(taint);
            throw varECF25F51942B946710F937BB139F9A1F_1774297119;
            // ---------- Original Method ----------
            //throw new RuntimeException("Not implemented");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.570 -0400", hash_original_method = "F44EC09A2F605B64D128CF1FD080E96F", hash_generated_method = "D8EA0C6C77B6C81F96401D6819B00A82")
        public int getRepresentation() {
            int var0D93DB0C2F85BACA29F992F68B556671_529929080 = (this.representation);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175884984 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175884984;
            // ---------- Original Method ----------
            //return this.representation;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.570 -0400", hash_original_method = "16D4D66DBFDF91ECDD28D772829DE89A", hash_generated_method = "ABAC02010DA7FFF407E27641B99E0ECD")
        public int getM() {
            int varE232824FC708DC9890A445C590D5EF7B_196308048 = (this.m);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552419888 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552419888;
            // ---------- Original Method ----------
            //return this.m;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.570 -0400", hash_original_method = "788DAA97D92752E8BB2DDD2E9F6BC21F", hash_generated_method = "1B04F720E379B6F6F3775E43BA5269F8")
        public int getK1() {
            int var4D98D917A246DCDB89729CDA9C120415_719948432 = (this.k1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363085734 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363085734;
            // ---------- Original Method ----------
            //return this.k1;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.570 -0400", hash_original_method = "F79890B1EB0EE6C2416B5951B6A3A0C5", hash_generated_method = "96611BAAB842F0E360A93BECCF4A8E19")
        public int getK2() {
            int varFA3D3267307EA8828AD1C37F5BAACCCD_419705594 = (this.k2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480340380 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480340380;
            // ---------- Original Method ----------
            //return this.k2;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.571 -0400", hash_original_method = "1D65CE2828E295283E79F47AB831B6A0", hash_generated_method = "BECB6D5159B4E929F56B018F579B1D1A")
        public int getK3() {
            int var1E5396ECC021351D2F4DD73E5E502D13_49616063 = (this.k3);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_225806176 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_225806176;
            // ---------- Original Method ----------
            //return this.k3;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.571 -0400", hash_original_method = "3D5105255A9EFAC151D1697019D15B93", hash_generated_method = "2785A612E619E6CDC6BD7C1D8138D9D6")
        public boolean equals(Object anObject) {
            addTaint(anObject.getTaint());
            if(anObject == this)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_2013329426 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68807897 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_68807897;
            } //End block
            if(!(anObject instanceof ECFieldElement.F2m))            
            {
                boolean var68934A3E9455FA72420237EB05902327_374228924 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_35374630 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_35374630;
            } //End block
            ECFieldElement.F2m b = (ECFieldElement.F2m)anObject;
            boolean var45C74E10B2A26CE15CD2929040B64F12_1114507549 = (((this.m == b.m) && (this.k1 == b.k1) && (this.k2 == b.k2)
                && (this.k3 == b.k3)
                && (this.representation == b.representation)
                && (this.x.equals(b.x))));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982291359 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982291359;
            // ---------- Original Method ----------
            //if (anObject == this) 
            //{
                //return true;
            //}
            //if (!(anObject instanceof ECFieldElement.F2m)) 
            //{
                //return false;
            //}
            //ECFieldElement.F2m b = (ECFieldElement.F2m)anObject;
            //return ((this.m == b.m) && (this.k1 == b.k1) && (this.k2 == b.k2)
                //&& (this.k3 == b.k3)
                //&& (this.representation == b.representation)
                //&& (this.x.equals(b.x)));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.571 -0400", hash_original_method = "A8D83F5F73395A245F39934AB1D46428", hash_generated_method = "ADE1D603EE5EC719307FCF818863E36C")
        public int hashCode() {
            int varC8F32407834A0DEC4D476D4A528031C7_2008278574 = (x.hashCode() ^ m ^ k1 ^ k2 ^ k3);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827759069 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827759069;
            // ---------- Original Method ----------
            //return x.hashCode() ^ m ^ k1 ^ k2 ^ k3;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.571 -0400", hash_original_field = "E8B41906FE7C3E4F22325A5FFD12E34F", hash_generated_field = "1EF437C47631F0C3F3BB2EA100DFE875")

        public static final int GNB = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.571 -0400", hash_original_field = "B8232562CF38D3B220C5996492FFB291", hash_generated_field = "37EF4BAB1D77E666E3DAF9CFE4014569")

        public static final int TPB = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.571 -0400", hash_original_field = "EB22FE82A7FB60D3261A608321D0EB45", hash_generated_field = "895352A09857F9070F0E8B8F7FB4EE8F")

        public static final int PPB = 3;
    }


    
}

