package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import java.util.Random;

public abstract class ECFieldElement implements ECConstants {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.239 -0400", hash_original_method = "18B929116CB81747CE726807F2C6A2C0", hash_generated_method = "18B929116CB81747CE726807F2C6A2C0")
    public ECFieldElement ()
    {
        //Synthesized constructor
    }


    public abstract BigInteger     toBigInteger();

    
    public abstract String         getFieldName();

    
    public abstract int            getFieldSize();

    
    public abstract ECFieldElement add(ECFieldElement b);

    
    public abstract ECFieldElement subtract(ECFieldElement b);

    
    public abstract ECFieldElement multiply(ECFieldElement b);

    
    public abstract ECFieldElement divide(ECFieldElement b);

    
    public abstract ECFieldElement negate();

    
    public abstract ECFieldElement square();

    
    public abstract ECFieldElement invert();

    
    public abstract ECFieldElement sqrt();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.242 -0400", hash_original_method = "0A600F50B2D3858965A3E5F0EE37FE95", hash_generated_method = "CF1CFB09840F136C93F3F73197AF2BF8")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1280751082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1280751082 = this.toBigInteger().toString(2);
        varB4EAC82CA7396A68D541C85D26508E83_1280751082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1280751082;
        // ---------- Original Method ----------
        //return this.toBigInteger().toString(2);
    }

    
    public static class Fp extends ECFieldElement {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.245 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "8A69D3B9CF67CA1128DF293842071E77")

        BigInteger x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.245 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "F819999E3B2036A19089F4FD0B5D94F4")

        BigInteger q;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.245 -0400", hash_original_method = "2CEE87D2C14E1CA252587D4A1EA48723", hash_generated_method = "F9E5D17F161ED49EBB597A37CF509C9B")
        public  Fp(BigInteger q, BigInteger x) {
            this.x = x;
            {
                boolean var46B3A30496779CCBFE107E4FE6508D5F_234574339 = (x.compareTo(q) >= 0);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("x value too large in field element");
                } //End block
            } //End collapsed parenthetic
            this.q = q;
            // ---------- Original Method ----------
            //this.x = x;
            //if (x.compareTo(q) >= 0)
            //{
                //throw new IllegalArgumentException("x value too large in field element");
            //}
            //this.q = q;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.247 -0400", hash_original_method = "980758C44AA9D55BE8845E0F1627D066", hash_generated_method = "85151AB90A6C25FA5DF583BE00D4D9EE")
        public BigInteger toBigInteger() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_537308108 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_537308108 = x;
            varB4EAC82CA7396A68D541C85D26508E83_537308108.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_537308108;
            // ---------- Original Method ----------
            //return x;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.250 -0400", hash_original_method = "0E8B7E675C6828F2CC0DC48F96E6F8E3", hash_generated_method = "9688FEE21F3FFDE82733D79DA57708DC")
        public String getFieldName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1234238436 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1234238436 = "Fp";
            varB4EAC82CA7396A68D541C85D26508E83_1234238436.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1234238436;
            // ---------- Original Method ----------
            //return "Fp";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.263 -0400", hash_original_method = "B586F82D19D11BCE8142121499961CE9", hash_generated_method = "40B2EBE3FAD7C1B45C2D29225E702077")
        public int getFieldSize() {
            int varA151D78D1E2C09447CC56EDC4DA68901_667337576 = (q.bitLength());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635157830 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635157830;
            // ---------- Original Method ----------
            //return q.bitLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.265 -0400", hash_original_method = "ACFCE2DB75EFF131F33A5EE2D309C15F", hash_generated_method = "A345CB0DAC9CD229575FAA35E8296F2B")
        public BigInteger getQ() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_1212682248 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1212682248 = q;
            varB4EAC82CA7396A68D541C85D26508E83_1212682248.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1212682248;
            // ---------- Original Method ----------
            //return q;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.265 -0400", hash_original_method = "81C2635B1C8BBF0D98329C00DDA86CBF", hash_generated_method = "E56F4D7C7B77D0B410BA7A8EEAC61179")
        public ECFieldElement add(ECFieldElement b) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_535031248 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_535031248 = new Fp(q, x.add(b.toBigInteger()).mod(q));
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_535031248.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_535031248;
            // ---------- Original Method ----------
            //return new Fp(q, x.add(b.toBigInteger()).mod(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.272 -0400", hash_original_method = "CC55B0F5614FEECA03D2E059411B5A62", hash_generated_method = "05EBF5FAD00C139BEAADA230CB3B707B")
        public ECFieldElement subtract(ECFieldElement b) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_593167376 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_593167376 = new Fp(q, x.subtract(b.toBigInteger()).mod(q));
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_593167376.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_593167376;
            // ---------- Original Method ----------
            //return new Fp(q, x.subtract(b.toBigInteger()).mod(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.273 -0400", hash_original_method = "8FDF6CC967FA6FBF2AB862654F18B35A", hash_generated_method = "F9CFE1157F409E74193AA4E15D4461DF")
        public ECFieldElement multiply(ECFieldElement b) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_450866829 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_450866829 = new Fp(q, x.multiply(b.toBigInteger()).mod(q));
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_450866829.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_450866829;
            // ---------- Original Method ----------
            //return new Fp(q, x.multiply(b.toBigInteger()).mod(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.274 -0400", hash_original_method = "273EB04F445D1E8BD427B46F09A750C8", hash_generated_method = "AC8FACE666C8F9E37AA985BE6DF3F46F")
        public ECFieldElement divide(ECFieldElement b) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_828863818 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_828863818 = new Fp(q, x.multiply(b.toBigInteger().modInverse(q)).mod(q));
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_828863818.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_828863818;
            // ---------- Original Method ----------
            //return new Fp(q, x.multiply(b.toBigInteger().modInverse(q)).mod(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.274 -0400", hash_original_method = "9EF54D69A52E7076272AA6C8111B6A31", hash_generated_method = "6C0E8AF88E665BF2FF51EBBCE7A93538")
        public ECFieldElement negate() {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1814098188 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1814098188 = new Fp(q, x.negate().mod(q));
            varB4EAC82CA7396A68D541C85D26508E83_1814098188.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1814098188;
            // ---------- Original Method ----------
            //return new Fp(q, x.negate().mod(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.276 -0400", hash_original_method = "1F15D9F4F3F7C45F6D78B4A8A149E9FC", hash_generated_method = "AC27A7956D8B05CEB030F8934F6F841A")
        public ECFieldElement square() {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_569535054 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_569535054 = new Fp(q, x.multiply(x).mod(q));
            varB4EAC82CA7396A68D541C85D26508E83_569535054.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_569535054;
            // ---------- Original Method ----------
            //return new Fp(q, x.multiply(x).mod(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.277 -0400", hash_original_method = "87CD41222C6FB4EC59F31E743CC1D431", hash_generated_method = "2199A80CAACC1FF38ADABA2A22240A1C")
        public ECFieldElement invert() {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_205471841 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_205471841 = new Fp(q, x.modInverse(q));
            varB4EAC82CA7396A68D541C85D26508E83_205471841.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_205471841;
            // ---------- Original Method ----------
            //return new Fp(q, x.modInverse(q));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.278 -0400", hash_original_method = "27B2154E50FF6039CAEE06398FCA6C60", hash_generated_method = "063B47873716A9B6481FCC1CCD3F6757")
        public ECFieldElement sqrt() {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_759827879 = null; //Variable for return #1
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1151309605 = null; //Variable for return #2
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_63059053 = null; //Variable for return #3
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_111465791 = null; //Variable for return #4
            {
                boolean var33697466106CFFEBB33A35A4F7D35ACE_2103955691 = (!q.testBit(0));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("not done yet");
                } //End block
            } //End collapsed parenthetic
            {
                boolean var259B65665E46BAB848067F35F4130465_1362532847 = (q.testBit(1));
                {
                    ECFieldElement z;
                    z = new Fp(q, x.modPow(q.shiftRight(2).add(ECConstants.ONE), q));
                    varB4EAC82CA7396A68D541C85D26508E83_759827879 = z.square().equals(this) ? z : null;
                } //End block
            } //End collapsed parenthetic
            BigInteger qMinusOne;
            qMinusOne = q.subtract(ECConstants.ONE);
            BigInteger legendreExponent;
            legendreExponent = qMinusOne.shiftRight(1);
            {
                boolean varB8253DA8B9818D81AD3995887916701E_529218626 = (!(x.modPow(legendreExponent, q).equals(ECConstants.ONE)));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1151309605 = null;
                } //End block
            } //End collapsed parenthetic
            BigInteger u;
            u = qMinusOne.shiftRight(2);
            BigInteger k;
            k = u.shiftLeft(1).add(ECConstants.ONE);
            BigInteger Q;
            Q = this.x;
            BigInteger fourQ;
            fourQ = Q.shiftLeft(2).mod(q);
            BigInteger U, V;
            Random rand;
            rand = new Random();
            {
                BigInteger P;
                {
                    P = new BigInteger(q.bitLength(), rand);
                } //End block
                {
                    boolean var54E1C85900042E97024D4231C04EF298_786227453 = (P.compareTo(q) >= 0
                    || !(P.multiply(P).subtract(fourQ).modPow(legendreExponent, q).equals(qMinusOne)));
                } //End collapsed parenthetic
                BigInteger[] result;
                result = lucasSequence(q, P, Q, k);
                U = result[0];
                V = result[1];
                {
                    boolean varF558A1D6DBB1E7A0C59C5A64D332625F_678950612 = (V.multiply(V).mod(q).equals(fourQ));
                    {
                        {
                            boolean var4333B164173F6BF688DAF78CDB9E335A_2030240335 = (V.testBit(0));
                            {
                                V = V.add(q);
                            } //End block
                        } //End collapsed parenthetic
                        V = V.shiftRight(1);
                        varB4EAC82CA7396A68D541C85D26508E83_63059053 = new ECFieldElement.Fp(q, V);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var5E4BF148E58B0416AAAE5F52B237276F_1843494165 = (U.equals(ECConstants.ONE) || U.equals(qMinusOne));
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_111465791 = null;
            ECFieldElement varA7E53CE21691AB073D9660D615818899_469286819; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_469286819 = varB4EAC82CA7396A68D541C85D26508E83_759827879;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_469286819 = varB4EAC82CA7396A68D541C85D26508E83_1151309605;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_469286819 = varB4EAC82CA7396A68D541C85D26508E83_63059053;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_469286819 = varB4EAC82CA7396A68D541C85D26508E83_111465791;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_469286819.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_469286819;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.292 -0400", hash_original_method = "F275DE81E4C5BCC7A64CB08B0E3C6B94", hash_generated_method = "33B5DCF60A4311AC1639D70543A75A69")
        public boolean equals(Object other) {
            {
                boolean varEBAA9C88926E0374801C3AD978616673_456361968 = (other == this);
            } //End collapsed parenthetic
            ECFieldElement.Fp o;
            o = (ECFieldElement.Fp)other;
            boolean var93EE7FCE80F32EFF7526E3672BB83382_1756699636 = (q.equals(o.q) && x.equals(o.x));
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_258657352 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_258657352;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.293 -0400", hash_original_method = "61E77154098D5712686019259E83DC28", hash_generated_method = "C3FE04DAA29B5461FE084B5C0766940E")
        public int hashCode() {
            int var7C42B5C4D89A4D0A9807B6AA92611DFF_1982237758 = (q.hashCode() ^ x.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428477738 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428477738;
            // ---------- Original Method ----------
            //return q.hashCode() ^ x.hashCode();
        }

        
    }


    
    public static class F2m extends ECFieldElement {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.294 -0400", hash_original_field = "EE16755AF8C89D0C26540DAF7A0FE1B3", hash_generated_field = "05684F2BDAA8EE0BD6A4A6166AA30FB6")

        private int representation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.294 -0400", hash_original_field = "6F8F57715090DA2632453988D9A1501B", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

        private int m;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.294 -0400", hash_original_field = "B637B17AF08ACED8850C18CCCDE915DA", hash_generated_field = "82BC5D885288BEA8F058C8200E42732B")

        private int k1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.294 -0400", hash_original_field = "61620957A1443C946A143CF99A7D24FA", hash_generated_field = "9A9BABB98FA71DB4E862A96C38A0DEB5")

        private int k2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.294 -0400", hash_original_field = "F7AB469D1DC79166FC874DADCC0DD854", hash_generated_field = "B93297072479995D07A6DAC48610EF09")

        private int k3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.294 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "8009D56CC2C16E6B1ECA88AD9DDD4454")

        private IntArray x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.294 -0400", hash_original_field = "E358EFA489F58062F10DD7316B65649E", hash_generated_field = "C6BE2DA2DF5011CA37BB619361E1CF67")

        private int t;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.301 -0400", hash_original_method = "30B70FEF02DF1B2128C82CD1FCC1318F", hash_generated_method = "17C3DD81464C480E66EC857EB6AD9D7C")
        public  F2m(
            int m, 
            int k1, 
            int k2, 
            int k3,
            BigInteger x) {
            t = (m + 31) >> 5;
            this.x = new IntArray(x, t);
            {
                this.representation = TPB;
            } //End block
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                            "k2 must be smaller than k3");
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                            "k2 must be larger than 0");
                } //End block
                this.representation = PPB;
            } //End block
            {
                boolean var1006DCCF4E810448453B3581D5D95413_1356066348 = (x.signum() < 0);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("x value cannot be negative");
                } //End block
            } //End collapsed parenthetic
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.302 -0400", hash_original_method = "769D94FCBFF8D8B7B44421BAE1CCBF10", hash_generated_method = "9DEECFEEBF124969A483854A33973109")
        public  F2m(int m, int k, BigInteger x) {
            this(m, k, 0, 0, x);
            addTaint(m);
            addTaint(k);
            addTaint(x.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.303 -0400", hash_original_method = "E37831F6788FECA0B3C28407A9D117A4", hash_generated_method = "86F31FD85A933C5EA9731A9DF0764CED")
        private  F2m(int m, int k1, int k2, int k3, IntArray x) {
            t = (m + 31) >> 5;
            this.x = x;
            this.m = m;
            this.k1 = k1;
            this.k2 = k2;
            this.k3 = k3;
            {
                this.representation = TPB;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.309 -0400", hash_original_method = "D9240AE462D2FCFCBEB9680DA07047D8", hash_generated_method = "EF8D99EB637325EC7D4D4F845A51E862")
        public BigInteger toBigInteger() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_1150719338 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1150719338 = x.toBigInteger();
            varB4EAC82CA7396A68D541C85D26508E83_1150719338.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1150719338;
            // ---------- Original Method ----------
            //return x.toBigInteger();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.310 -0400", hash_original_method = "69EE8C1832EFB43BF906E0C4BE94B23A", hash_generated_method = "15DB70A7680682EEA399F61E0874BF58")
        public String getFieldName() {
            String varB4EAC82CA7396A68D541C85D26508E83_955145220 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_955145220 = "F2m";
            varB4EAC82CA7396A68D541C85D26508E83_955145220.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_955145220;
            // ---------- Original Method ----------
            //return "F2m";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.310 -0400", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "CDB627C584FC556EE07AF6A6ECDE90D0")
        public int getFieldSize() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070336063 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070336063;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.322 -0400", hash_original_method = "1771E6C8DC949344BED4A1E6536DC20F", hash_generated_method = "19F44D61B7D28F6B961B3BDEAB6FA7EA")
        public ECFieldElement add(final ECFieldElement b) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_2020126832 = null; //Variable for return #1
            IntArray iarrClone;
            iarrClone = (IntArray)this.x.clone();
            F2m bF2m;
            bF2m = (F2m)b;
            iarrClone.addShifted(bF2m.x, 0);
            varB4EAC82CA7396A68D541C85D26508E83_2020126832 = new F2m(m, k1, k2, k3, iarrClone);
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2020126832.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2020126832;
            // ---------- Original Method ----------
            //IntArray iarrClone = (IntArray)this.x.clone();
            //F2m bF2m = (F2m)b;
            //iarrClone.addShifted(bF2m.x, 0);
            //return new F2m(m, k1, k2, k3, iarrClone);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.325 -0400", hash_original_method = "DED14713A83018FDD63888AD3FB6A659", hash_generated_method = "4F03E1FFC745D77E724234FB847A7309")
        public ECFieldElement subtract(final ECFieldElement b) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1521369344 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1521369344 = add(b);
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1521369344.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1521369344;
            // ---------- Original Method ----------
            //return add(b);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.326 -0400", hash_original_method = "CFFAAAAE4FA7236DDDBD1DC710F4AF58", hash_generated_method = "3774B42605F61085C970E4F679654F7D")
        public ECFieldElement multiply(final ECFieldElement b) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_514024543 = null; //Variable for return #1
            F2m bF2m;
            bF2m = (F2m)b;
            IntArray mult;
            mult = x.multiply(bF2m.x, m);
            mult.reduce(m, new int[]{k1, k2, k3});
            varB4EAC82CA7396A68D541C85D26508E83_514024543 = new F2m(m, k1, k2, k3, mult);
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_514024543.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_514024543;
            // ---------- Original Method ----------
            //F2m bF2m = (F2m)b;
            //IntArray mult = x.multiply(bF2m.x, m);
            //mult.reduce(m, new int[]{k1, k2, k3});
            //return new F2m(m, k1, k2, k3, mult);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.326 -0400", hash_original_method = "69832D94122014C087767F6408988886", hash_generated_method = "CDE432CE76E41931AE5E792B3D5A5DEF")
        public ECFieldElement divide(final ECFieldElement b) {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_511700083 = null; //Variable for return #1
            ECFieldElement bInv;
            bInv = b.invert();
            varB4EAC82CA7396A68D541C85D26508E83_511700083 = multiply(bInv);
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_511700083.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_511700083;
            // ---------- Original Method ----------
            //ECFieldElement bInv = b.invert();
            //return multiply(bInv);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.327 -0400", hash_original_method = "3796F7BD0BD7CB77DE18BFC002B0C069", hash_generated_method = "C4B8BEA6875BA69A647176606C877166")
        public ECFieldElement negate() {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_435719504 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_435719504 = this;
            varB4EAC82CA7396A68D541C85D26508E83_435719504.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_435719504;
            // ---------- Original Method ----------
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.334 -0400", hash_original_method = "C7941F6A7028361E62B5AB4ECF6F47B0", hash_generated_method = "932A954B2EEE84C13AC6775356A13EDB")
        public ECFieldElement square() {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1612225008 = null; //Variable for return #1
            IntArray squared;
            squared = x.square(m);
            squared.reduce(m, new int[]{k1, k2, k3});
            varB4EAC82CA7396A68D541C85D26508E83_1612225008 = new F2m(m, k1, k2, k3, squared);
            varB4EAC82CA7396A68D541C85D26508E83_1612225008.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1612225008;
            // ---------- Original Method ----------
            //IntArray squared = x.square(m);
            //squared.reduce(m, new int[]{k1, k2, k3});
            //return new F2m(m, k1, k2, k3, squared);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.335 -0400", hash_original_method = "1700F54C0CA191DF0B1880FDDD97556A", hash_generated_method = "543F5C52A32430DA74CD112D5B91DCC7")
        public ECFieldElement invert() {
            ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_900504542 = null; //Variable for return #1
            IntArray uz;
            uz = (IntArray)this.x.clone();
            IntArray vz;
            vz = new IntArray(t);
            vz.setBit(m);
            vz.setBit(0);
            vz.setBit(this.k1);
            {
                vz.setBit(this.k2);
                vz.setBit(this.k3);
            } //End block
            IntArray g1z;
            g1z = new IntArray(t);
            g1z.setBit(0);
            IntArray g2z;
            g2z = new IntArray(t);
            {
                boolean var7A9543C5F0BD2E786E6BF9C7793C70D4_12180387 = (!uz.isZero());
                {
                    int j;
                    j = uz.bitLength() - vz.bitLength();
                    {
                        IntArray uzCopy;
                        uzCopy = uz;
                        uz = vz;
                        vz = uzCopy;
                        IntArray g1zCopy;
                        g1zCopy = g1z;
                        g1z = g2z;
                        g2z = g1zCopy;
                        j = -j;
                    } //End block
                    int jInt;
                    jInt = j >> 5;
                    int jBit;
                    jBit = j & 0x1F;
                    IntArray vzShift;
                    vzShift = vz.shiftLeft(jBit);
                    uz.addShifted(vzShift, jInt);
                    IntArray g2zShift;
                    g2zShift = g2z.shiftLeft(jBit);
                    g1z.addShifted(g2zShift, jInt);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_900504542 = new ECFieldElement.F2m(
                    this.m, this.k1, this.k2, this.k3, g2z);
            varB4EAC82CA7396A68D541C85D26508E83_900504542.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_900504542;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.335 -0400", hash_original_method = "3F2FB8B8358C44CE763B294C61568C61", hash_generated_method = "15DBA8E346D1FAAE2D6C8F5AC1BB1150")
        public ECFieldElement sqrt() {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not implemented");
            // ---------- Original Method ----------
            //throw new RuntimeException("Not implemented");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.336 -0400", hash_original_method = "F44EC09A2F605B64D128CF1FD080E96F", hash_generated_method = "EB82D6DA70B66A1309C787E4F3A10A4E")
        public int getRepresentation() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1697471903 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1697471903;
            // ---------- Original Method ----------
            //return this.representation;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.336 -0400", hash_original_method = "16D4D66DBFDF91ECDD28D772829DE89A", hash_generated_method = "C5C3ED1C8BBC2884E7E57335DAF6105D")
        public int getM() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911590967 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911590967;
            // ---------- Original Method ----------
            //return this.m;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.336 -0400", hash_original_method = "788DAA97D92752E8BB2DDD2E9F6BC21F", hash_generated_method = "20999011F74F407FFECF6A28EB13E9A4")
        public int getK1() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254130548 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254130548;
            // ---------- Original Method ----------
            //return this.k1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.336 -0400", hash_original_method = "F79890B1EB0EE6C2416B5951B6A3A0C5", hash_generated_method = "7DF12532615516CAC36EE35B6F161029")
        public int getK2() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445878644 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445878644;
            // ---------- Original Method ----------
            //return this.k2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.337 -0400", hash_original_method = "1D65CE2828E295283E79F47AB831B6A0", hash_generated_method = "AAD990C5E62BEA68A880A3F0572E9D5E")
        public int getK3() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594243339 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594243339;
            // ---------- Original Method ----------
            //return this.k3;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.351 -0400", hash_original_method = "3D5105255A9EFAC151D1697019D15B93", hash_generated_method = "8C2C4D482FB1C37EA621B48D3FC29859")
        public boolean equals(Object anObject) {
            {
                boolean varDDF650371899A44735E1E943193361F5_1362182126 = (anObject == this);
            } //End collapsed parenthetic
            ECFieldElement.F2m b;
            b = (ECFieldElement.F2m)anObject;
            boolean var5DC0A1DDDD3118B20B12290F66AB6462_1043885554 = (((this.m == b.m) && (this.k1 == b.k1) && (this.k2 == b.k2)
                && (this.k3 == b.k3)
                && (this.representation == b.representation)
                && (this.x.equals(b.x))));
            addTaint(anObject.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_183662660 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_183662660;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.353 -0400", hash_original_method = "A8D83F5F73395A245F39934AB1D46428", hash_generated_method = "CB05D7C48026E067E33AEB9E0972359E")
        public int hashCode() {
            int varC325A9404638827954521743C4DF1848_1111587662 = (x.hashCode() ^ m ^ k1 ^ k2 ^ k3);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653995447 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653995447;
            // ---------- Original Method ----------
            //return x.hashCode() ^ m ^ k1 ^ k2 ^ k3;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.353 -0400", hash_original_field = "E8B41906FE7C3E4F22325A5FFD12E34F", hash_generated_field = "1EF437C47631F0C3F3BB2EA100DFE875")

        public static final int GNB = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.353 -0400", hash_original_field = "B8232562CF38D3B220C5996492FFB291", hash_generated_field = "37EF4BAB1D77E666E3DAF9CFE4014569")

        public static final int TPB = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.353 -0400", hash_original_field = "EB22FE82A7FB60D3261A608321D0EB45", hash_generated_field = "895352A09857F9070F0E8B8F7FB4EE8F")

        public static final int PPB = 3;
    }


    
}

