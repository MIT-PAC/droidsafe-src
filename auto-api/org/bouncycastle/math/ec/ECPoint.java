package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import org.bouncycastle.asn1.x9.X9IntegerConverter;

public abstract class ECPoint {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.205 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "704A3581F062D90BBFC67E94998B89B2")

    ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.205 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "4962267CB3409346474982F669EDC96A")

    ECFieldElement x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.205 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "8FD25F34A4263F01B1FBD2F22B2F99BF")

    ECFieldElement y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.205 -0400", hash_original_field = "A04A91040E7D1CAA0270269A913F52BB", hash_generated_field = "7FD389F38A41EB1BAE8714CB05D998E3")

    protected boolean withCompression;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.205 -0400", hash_original_field = "73DABD82B9E2DA8B72224DD8528740A4", hash_generated_field = "C1F508A0F6FEA833DEEAC7A7B323D761")

    protected ECMultiplier multiplier = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.206 -0400", hash_original_field = "14172E23074FE3D1020FA12A5CEFEB04", hash_generated_field = "84CF639EBFFD87F3AC15C9EF1E1AAF42")

    protected PreCompInfo preCompInfo = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.206 -0400", hash_original_method = "5BA77B5B0277E538D25ED5D9A027BA25", hash_generated_method = "847A130CB97DB4D071D636D195FCCE97")
    protected  ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y) {
        this.curve = curve;
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.207 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "D6548243F6E27142E22C4465D50BDF25")
    public ECCurve getCurve() {
        ECCurve varB4EAC82CA7396A68D541C85D26508E83_683287075 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_683287075 = curve;
        varB4EAC82CA7396A68D541C85D26508E83_683287075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_683287075;
        // ---------- Original Method ----------
        //return curve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.213 -0400", hash_original_method = "C7C8D965D2F53EB7BBE8F50406AF2883", hash_generated_method = "F30ABD4B928BFFA543E5337C3708B920")
    public ECFieldElement getX() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1319760000 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1319760000 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1319760000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1319760000;
        // ---------- Original Method ----------
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.214 -0400", hash_original_method = "B5FEFF99DC806D61F0BCF9BC7ACEB9BA", hash_generated_method = "1A93502FC3FD571D496937FFD2BD9DFD")
    public ECFieldElement getY() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_2065541144 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2065541144 = y;
        varB4EAC82CA7396A68D541C85D26508E83_2065541144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2065541144;
        // ---------- Original Method ----------
        //return y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.214 -0400", hash_original_method = "B09C1F46CE24A0176C4C3F4348C76697", hash_generated_method = "CCD5D5CAAB1C04B0DA7289600DE5262C")
    public boolean isInfinity() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255730720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255730720;
        // ---------- Original Method ----------
        //return x == null && y == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.214 -0400", hash_original_method = "47BFB55B0C4A3BF2B8623783D9C43540", hash_generated_method = "FDBBD5AACE36C77998132F924ABFEA26")
    public boolean isCompressed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1914357802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1914357802;
        // ---------- Original Method ----------
        //return withCompression;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.215 -0400", hash_original_method = "8BF915B7848C2883598F0B5C0E5B1EC3", hash_generated_method = "43DD22FDF4BA53F2AB659A1576F83E03")
    public boolean equals(
        Object  other) {
        {
            boolean var140A8815FDEEC27C4D8944D501CA10BC_1645119162 = (other == this);
        } //End collapsed parenthetic
        ECPoint o;
        o = (ECPoint)other;
        {
            boolean varB03470E068DC04327C836C8BEDADAFE1_1837872913 = (this.isInfinity());
            {
                boolean varDC84CE8AEB9453E25988DB714FEFECAF_1453904079 = (o.isInfinity());
            } //End block
        } //End collapsed parenthetic
        boolean var7EE45789D6D932F5F1311F0577CF265F_863415955 = (x.equals(o.x) && y.equals(o.y));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1408199541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1408199541;
        // ---------- Original Method ----------
        //if (other == this)
        //{
            //return true;
        //}
        //if (!(other instanceof ECPoint))
        //{
            //return false;
        //}
        //ECPoint o = (ECPoint)other;
        //if (this.isInfinity())
        //{
            //return o.isInfinity();
        //}
        //return x.equals(o.x) && y.equals(o.y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.216 -0400", hash_original_method = "50EB0D4EE4BADC10EDE9CC4D5C9244FF", hash_generated_method = "F5D19E555652F492BFF283B177570C7E")
    public int hashCode() {
        {
            boolean varB03470E068DC04327C836C8BEDADAFE1_1007430331 = (this.isInfinity());
        } //End collapsed parenthetic
        int varFD4844CACAD08EE7CC6F70930CBF49EB_1741031325 = (x.hashCode() ^ y.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014248105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014248105;
        // ---------- Original Method ----------
        //if (this.isInfinity())
        //{
            //return 0;
        //}
        //return x.hashCode() ^ y.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.216 -0400", hash_original_method = "3CED2898CE1D9F7EEE71D4F4E6298B52", hash_generated_method = "7B74A03DE78F3C307128B0AF3CA7A466")
     void setPreCompInfo(PreCompInfo preCompInfo) {
        this.preCompInfo = preCompInfo;
        // ---------- Original Method ----------
        //this.preCompInfo = preCompInfo;
    }

    
    public abstract byte[] getEncoded();

    
    public abstract ECPoint add(ECPoint b);

    
    public abstract ECPoint subtract(ECPoint b);

    
    public abstract ECPoint negate();

    
    public abstract ECPoint twice();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.222 -0400", hash_original_method = "CFD8CCAA4A8EFD7B41616F74559C84F4", hash_generated_method = "A3DFBB3FA717A82090B2DD1B90C7A348")
    synchronized void assertECMultiplier() {
        {
            this.multiplier = new FpNafMultiplier();
        } //End block
        // ---------- Original Method ----------
        //if (this.multiplier == null)
        //{
            //this.multiplier = new FpNafMultiplier();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.237 -0400", hash_original_method = "0A712A2425F19F0711671167931DA051", hash_generated_method = "8DC529F39CE004E1AB66A5CBF7B75798")
    public ECPoint multiply(BigInteger k) {
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_627136213 = null; //Variable for return #1
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_1489333215 = null; //Variable for return #2
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_327108146 = null; //Variable for return #3
        {
            boolean varF5CB0378F3CC1D54FB008B542E2E4175_459317942 = (k.signum() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The multiplicator cannot be negative");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB03470E068DC04327C836C8BEDADAFE1_947428819 = (this.isInfinity());
            {
                varB4EAC82CA7396A68D541C85D26508E83_627136213 = this;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var76C73C83AB7D485B6F3FD352E70601D6_1576144050 = (k.signum() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1489333215 = this.curve.getInfinity();
            } //End block
        } //End collapsed parenthetic
        assertECMultiplier();
        varB4EAC82CA7396A68D541C85D26508E83_327108146 = this.multiplier.multiply(this, k, preCompInfo);
        addTaint(k.getTaint());
        ECPoint varA7E53CE21691AB073D9660D615818899_986414346; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_986414346 = varB4EAC82CA7396A68D541C85D26508E83_627136213;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_986414346 = varB4EAC82CA7396A68D541C85D26508E83_1489333215;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_986414346 = varB4EAC82CA7396A68D541C85D26508E83_327108146;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_986414346.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_986414346;
        // ---------- Original Method ----------
        //if (k.signum() < 0)
        //{
            //throw new IllegalArgumentException("The multiplicator cannot be negative");
        //}
        //if (this.isInfinity())
        //{
            //return this;
        //}
        //if (k.signum() == 0)
        //{
            //return this.curve.getInfinity();
        //}
        //assertECMultiplier();
        //return this.multiplier.multiply(this, k, preCompInfo);
    }

    
    public static class Fp extends ECPoint {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.238 -0400", hash_original_method = "C218E406154D6A68AEA278E34615CF99", hash_generated_method = "42000A5C4862A66CACDA81E55FB73F2B")
        public  Fp(ECCurve curve, ECFieldElement x, ECFieldElement y) {
            this(curve, x, y, false);
            addTaint(curve.getTaint());
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.238 -0400", hash_original_method = "DA43573652764E89DCD825DB3FC87547", hash_generated_method = "6E8C7507B410A6024B36622CEC2B0F36")
        public  Fp(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression) {
            super(curve, x, y);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Exactly one of the field elements is null");
            } //End block
            this.withCompression = withCompression;
            addTaint(curve.getTaint());
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            addTaint(withCompression);
            // ---------- Original Method ----------
            //if ((x != null && y == null) || (x == null && y != null))
            //{
                //throw new IllegalArgumentException("Exactly one of the field elements is null");
            //}
            //this.withCompression = withCompression;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.239 -0400", hash_original_method = "122C86DAB9B6EC00B00943741F6C7C43", hash_generated_method = "501508C8E0D45CF28268A6BC5B384F89")
        public byte[] getEncoded() {
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_679007606 = (this.isInfinity());
                {
                    byte[] varDC3732A3F5F37EC49A2E4A5DF1C88342_527521151 = (new byte[1]);
                } //End block
            } //End collapsed parenthetic
            int qLength;
            qLength = converter.getByteLength(x);
            {
                byte PC;
                {
                    boolean varD887F1709689361DC8B0AB80CD81C246_1268741047 = (this.getY().toBigInteger().testBit(0));
                    {
                        PC = 0x03;
                    } //End block
                    {
                        PC = 0x02;
                    } //End block
                } //End collapsed parenthetic
                byte[] X;
                X = converter.integerToBytes(this.getX().toBigInteger(), qLength);
                byte[] PO;
                PO = new byte[X.length + 1];
                PO[0] = PC;
                System.arraycopy(X, 0, PO, 1, X.length);
            } //End block
            {
                byte[] X;
                X = converter.integerToBytes(this.getX().toBigInteger(), qLength);
                byte[] Y;
                Y = converter.integerToBytes(this.getY().toBigInteger(), qLength);
                byte[] PO;
                PO = new byte[X.length + Y.length + 1];
                PO[0] = 0x04;
                System.arraycopy(X, 0, PO, 1, X.length);
                System.arraycopy(Y, 0, PO, X.length + 1, Y.length);
            } //End block
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1607469795 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1607469795;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.250 -0400", hash_original_method = "95E059CAF9907A74F8544551FF4AF334", hash_generated_method = "92FF4E05BEF8BBA2E722DA921419F740")
        public ECPoint add(ECPoint b) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_2136221313 = null; //Variable for return #1
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_144580371 = null; //Variable for return #2
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1748343899 = null; //Variable for return #3
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1139237119 = null; //Variable for return #4
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1660480695 = null; //Variable for return #5
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_677986814 = (this.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2136221313 = b;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var908D0D7D4A9949C77E1B63E914B1D7AB_1632842104 = (b.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_144580371 = this;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var66DF63E936B6D1FAA6881D1F95A29873_490211030 = (this.x.equals(b.x));
                {
                    {
                        boolean var09A872EDC0794D5341C95ACD14A20E4A_1130012082 = (this.y.equals(b.y));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1748343899 = this.twice();
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1139237119 = this.curve.getInfinity();
                } //End block
            } //End collapsed parenthetic
            ECFieldElement gamma;
            gamma = b.y.subtract(this.y).divide(b.x.subtract(this.x));
            ECFieldElement x3;
            x3 = gamma.square().subtract(this.x).subtract(b.x);
            ECFieldElement y3;
            y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
            varB4EAC82CA7396A68D541C85D26508E83_1660480695 = new ECPoint.Fp(curve, x3, y3);
            addTaint(b.getTaint());
            ECPoint varA7E53CE21691AB073D9660D615818899_558555941; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_558555941 = varB4EAC82CA7396A68D541C85D26508E83_2136221313;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_558555941 = varB4EAC82CA7396A68D541C85D26508E83_144580371;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_558555941 = varB4EAC82CA7396A68D541C85D26508E83_1748343899;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_558555941 = varB4EAC82CA7396A68D541C85D26508E83_1139237119;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_558555941 = varB4EAC82CA7396A68D541C85D26508E83_1660480695;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_558555941.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_558555941;
            // ---------- Original Method ----------
            //if (this.isInfinity())
            //{
                //return b;
            //}
            //if (b.isInfinity())
            //{
                //return this;
            //}
            //if (this.x.equals(b.x))
            //{
                //if (this.y.equals(b.y))
                //{
                    //return this.twice();
                //}
                //return this.curve.getInfinity();
            //}
            //ECFieldElement gamma = b.y.subtract(this.y).divide(b.x.subtract(this.x));
            //ECFieldElement x3 = gamma.square().subtract(this.x).subtract(b.x);
            //ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
            //return new ECPoint.Fp(curve, x3, y3);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.254 -0400", hash_original_method = "814EC5F0BAC3EF42CB4061AB2E0CCD5F", hash_generated_method = "D87FA91A4B7FDD81561BB8BAC5FFCF35")
        public ECPoint twice() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1329618182 = null; //Variable for return #1
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1801098910 = null; //Variable for return #2
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1371615999 = null; //Variable for return #3
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_129378059 = (this.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1329618182 = this;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var4A993B1CDED66FE550138AAC82389C41_138093708 = (this.y.toBigInteger().signum() == 0);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1801098910 = this.curve.getInfinity();
                } //End block
            } //End collapsed parenthetic
            ECFieldElement TWO;
            TWO = this.curve.fromBigInteger(BigInteger.valueOf(2));
            ECFieldElement THREE;
            THREE = this.curve.fromBigInteger(BigInteger.valueOf(3));
            ECFieldElement gamma;
            gamma = this.x.square().multiply(THREE).add(curve.a).divide(y.multiply(TWO));
            ECFieldElement x3;
            x3 = gamma.square().subtract(this.x.multiply(TWO));
            ECFieldElement y3;
            y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
            varB4EAC82CA7396A68D541C85D26508E83_1371615999 = new ECPoint.Fp(curve, x3, y3, this.withCompression);
            ECPoint varA7E53CE21691AB073D9660D615818899_1820336053; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1820336053 = varB4EAC82CA7396A68D541C85D26508E83_1329618182;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1820336053 = varB4EAC82CA7396A68D541C85D26508E83_1801098910;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1820336053 = varB4EAC82CA7396A68D541C85D26508E83_1371615999;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1820336053.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1820336053;
            // ---------- Original Method ----------
            //if (this.isInfinity())
            //{
                //return this;
            //}
            //if (this.y.toBigInteger().signum() == 0) 
            //{
                //return this.curve.getInfinity();
            //}
            //ECFieldElement TWO = this.curve.fromBigInteger(BigInteger.valueOf(2));
            //ECFieldElement THREE = this.curve.fromBigInteger(BigInteger.valueOf(3));
            //ECFieldElement gamma = this.x.square().multiply(THREE).add(curve.a).divide(y.multiply(TWO));
            //ECFieldElement x3 = gamma.square().subtract(this.x.multiply(TWO));
            //ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
            //return new ECPoint.Fp(curve, x3, y3, this.withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.255 -0400", hash_original_method = "6CF29EA69F961CE922C32B4E8E2284E5", hash_generated_method = "C0B176A29714B4F627B1AD912DA9FBD6")
        public ECPoint subtract(ECPoint b) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_148986591 = null; //Variable for return #1
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1894472629 = null; //Variable for return #2
            {
                boolean var908D0D7D4A9949C77E1B63E914B1D7AB_1896633517 = (b.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_148986591 = this;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1894472629 = add(b.negate());
            addTaint(b.getTaint());
            ECPoint varA7E53CE21691AB073D9660D615818899_1296633551; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1296633551 = varB4EAC82CA7396A68D541C85D26508E83_148986591;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1296633551 = varB4EAC82CA7396A68D541C85D26508E83_1894472629;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1296633551.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1296633551;
            // ---------- Original Method ----------
            //if (b.isInfinity())
            //{
                //return this;
            //}
            //return add(b.negate());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.255 -0400", hash_original_method = "18C2403460E252970B56CE0DE1D343AC", hash_generated_method = "F95C6451E06411521014648FFB726EB8")
        public ECPoint negate() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_548909216 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_548909216 = new ECPoint.Fp(curve, this.x, this.y.negate(), this.withCompression);
            varB4EAC82CA7396A68D541C85D26508E83_548909216.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_548909216;
            // ---------- Original Method ----------
            //return new ECPoint.Fp(curve, this.x, this.y.negate(), this.withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.256 -0400", hash_original_method = "8EF68E9821BB7A65A39BDB5C806DAEDA", hash_generated_method = "9D03005E83437AF7AE2345086A0901C8")
        synchronized void assertECMultiplier() {
            {
                this.multiplier = new WNafMultiplier();
            } //End block
            // ---------- Original Method ----------
            //if (this.multiplier == null)
            //{
                //this.multiplier = new WNafMultiplier();
            //}
        }

        
    }


    
    public static class F2m extends ECPoint {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.257 -0400", hash_original_method = "73BD63756191E5AAFB19346FBE556EB3", hash_generated_method = "FF55D416F3E4248E822D393EE0759DAC")
        public  F2m(ECCurve curve, ECFieldElement x, ECFieldElement y) {
            this(curve, x, y, false);
            addTaint(curve.getTaint());
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.257 -0400", hash_original_method = "4610FCAEB1DDBBF845E95D34129A59A7", hash_generated_method = "BEA52E1D2A17868CE006DA5D9E0E0B1F")
        public  F2m(ECCurve curve, ECFieldElement x, ECFieldElement y, boolean withCompression) {
            super(curve, x, y);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Exactly one of the field elements is null");
            } //End block
            {
                ECFieldElement.F2m.checkFieldElements(this.x, this.y);
                {
                    ECFieldElement.F2m.checkFieldElements(this.x, this.curve.getA());
                } //End block
            } //End block
            this.withCompression = withCompression;
            addTaint(curve.getTaint());
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            addTaint(withCompression);
            // ---------- Original Method ----------
            //if ((x != null && y == null) || (x == null && y != null))
            //{
                //throw new IllegalArgumentException("Exactly one of the field elements is null");
            //}
            //if (x != null)
            //{
                //ECFieldElement.F2m.checkFieldElements(this.x, this.y);
                //if (curve != null)
                //{
                    //ECFieldElement.F2m.checkFieldElements(this.x, this.curve.getA());
                //}
            //}
            //this.withCompression = withCompression;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.258 -0400", hash_original_method = "91DE6710B35AB1954917AAE97889BD70", hash_generated_method = "D2712956D9F21F73555100D7AF6E3E18")
        public byte[] getEncoded() {
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_1147728141 = (this.isInfinity());
                {
                    byte[] varDC3732A3F5F37EC49A2E4A5DF1C88342_1978342980 = (new byte[1]);
                } //End block
            } //End collapsed parenthetic
            int byteCount;
            byteCount = converter.getByteLength(this.x);
            byte[] X;
            X = converter.integerToBytes(this.getX().toBigInteger(), byteCount);
            byte[] PO;
            {
                PO = new byte[byteCount + 1];
                PO[0] = 0x02;
                {
                    boolean varC9110A8DD36BD0AEBF7B7278459C1614_1270956163 = (!(this.getX().toBigInteger().equals(ECConstants.ZERO)));
                    {
                        {
                            boolean var0134D4F4ADE9527B2BFCCA72540F2F93_711038415 = (this.getY().multiply(this.getX().invert())
                            .toBigInteger().testBit(0));
                            {
                                PO[0] = 0x03;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                System.arraycopy(X, 0, PO, 1, byteCount);
            } //End block
            {
                byte[] Y;
                Y = converter.integerToBytes(this.getY().toBigInteger(), byteCount);
                PO = new byte[byteCount + byteCount + 1];
                PO[0] = 0x04;
                System.arraycopy(X, 0, PO, 1, byteCount);
                System.arraycopy(Y, 0, PO, byteCount + 1, byteCount);
            } //End block
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1874267542 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1874267542;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                private static void checkPoints(ECPoint a, ECPoint b) {
            if (!(a.curve.equals(b.curve)))
            {
                throw new IllegalArgumentException("Only points on the same "
                        + "curve can be added or subtracted");
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.259 -0400", hash_original_method = "CE1FEB0E79091A4CCB0243E0EA7A28CB", hash_generated_method = "9C09FD1F6B13641C15846A48D8B7E751")
        public ECPoint add(ECPoint b) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_231743889 = null; //Variable for return #1
            checkPoints(this, b);
            varB4EAC82CA7396A68D541C85D26508E83_231743889 = addSimple((ECPoint.F2m)b);
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_231743889.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_231743889;
            // ---------- Original Method ----------
            //checkPoints(this, b);
            //return addSimple((ECPoint.F2m)b);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.271 -0400", hash_original_method = "230992766041FE2E7B78B40F0E0C1144", hash_generated_method = "7A76A53F66F135C785599CA5C21FA650")
        public ECPoint.F2m addSimple(ECPoint.F2m b) {
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_517933019 = null; //Variable for return #1
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_949005502 = null; //Variable for return #2
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_1522540330 = null; //Variable for return #3
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_1462287404 = null; //Variable for return #4
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_980225332 = null; //Variable for return #5
            ECPoint.F2m other;
            other = b;
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_1101048872 = (this.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_517933019 = other;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var488668EC7B3656666D603083E4B4A5F5_1938904479 = (other.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_949005502 = this;
                } //End block
            } //End collapsed parenthetic
            ECFieldElement.F2m x2;
            x2 = (ECFieldElement.F2m)other.getX();
            ECFieldElement.F2m y2;
            y2 = (ECFieldElement.F2m)other.getY();
            {
                boolean varD94053BC8F53E0F37132A731E03D7495_2071202637 = (this.x.equals(x2));
                {
                    {
                        boolean varD57155AC29D78D2D630C3828E07A7A00_2055150455 = (this.y.equals(y2));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1522540330 = (ECPoint.F2m)this.twice();
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1462287404 = (ECPoint.F2m)this.curve.getInfinity();
                } //End block
            } //End collapsed parenthetic
            ECFieldElement.F2m lambda;
            lambda = (ECFieldElement.F2m)(this.y.add(y2)).divide(this.x.add(x2));
            ECFieldElement.F2m x3;
            x3 = (ECFieldElement.F2m)lambda.square().add(lambda).add(this.x).add(x2).add(this.curve.getA());
            ECFieldElement.F2m y3;
            y3 = (ECFieldElement.F2m)lambda.multiply(this.x.add(x3)).add(x3).add(this.y);
            varB4EAC82CA7396A68D541C85D26508E83_980225332 = new ECPoint.F2m(curve, x3, y3, withCompression);
            addTaint(b.getTaint());
            ECPoint.F2m varA7E53CE21691AB073D9660D615818899_495485537; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_495485537 = varB4EAC82CA7396A68D541C85D26508E83_517933019;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_495485537 = varB4EAC82CA7396A68D541C85D26508E83_949005502;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_495485537 = varB4EAC82CA7396A68D541C85D26508E83_1522540330;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_495485537 = varB4EAC82CA7396A68D541C85D26508E83_1462287404;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_495485537 = varB4EAC82CA7396A68D541C85D26508E83_980225332;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_495485537.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_495485537;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.272 -0400", hash_original_method = "E180EBB5B66B4130D071F14F4EE083E4", hash_generated_method = "207AEC7493AF86A50F135ED6ECA5F0B3")
        public ECPoint subtract(ECPoint b) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_678108509 = null; //Variable for return #1
            checkPoints(this, b);
            varB4EAC82CA7396A68D541C85D26508E83_678108509 = subtractSimple((ECPoint.F2m)b);
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_678108509.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_678108509;
            // ---------- Original Method ----------
            //checkPoints(this, b);
            //return subtractSimple((ECPoint.F2m)b);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.281 -0400", hash_original_method = "FE873BC192C2EB55E75185601239ED06", hash_generated_method = "E9CAF6363BEC88C690FBEFAB71036D45")
        public ECPoint.F2m subtractSimple(ECPoint.F2m b) {
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_607090576 = null; //Variable for return #1
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_609232780 = null; //Variable for return #2
            {
                boolean var908D0D7D4A9949C77E1B63E914B1D7AB_798573505 = (b.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_607090576 = this;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_609232780 = addSimple((ECPoint.F2m)b.negate());
            addTaint(b.getTaint());
            ECPoint.F2m varA7E53CE21691AB073D9660D615818899_2006957139; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2006957139 = varB4EAC82CA7396A68D541C85D26508E83_607090576;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2006957139 = varB4EAC82CA7396A68D541C85D26508E83_609232780;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2006957139.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2006957139;
            // ---------- Original Method ----------
            //if (b.isInfinity())
            //{
                //return this;
            //}
            //return addSimple((ECPoint.F2m)b.negate());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.283 -0400", hash_original_method = "45BA33A6C8448ED0A2617484FF5E8003", hash_generated_method = "BC4B268DE9803B8BFA22451A2192C67D")
        public ECPoint twice() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_978599076 = null; //Variable for return #1
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_605640449 = null; //Variable for return #2
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_689249581 = null; //Variable for return #3
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_58658843 = (this.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_978599076 = this;
                } //End block
            } //End collapsed parenthetic
            {
                boolean varC3B49E08C4799B4FB26BD80041DA99F1_1722680839 = (this.x.toBigInteger().signum() == 0);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_605640449 = this.curve.getInfinity();
                } //End block
            } //End collapsed parenthetic
            ECFieldElement.F2m lambda;
            lambda = (ECFieldElement.F2m)this.x.add(this.y.divide(this.x));
            ECFieldElement.F2m x3;
            x3 = (ECFieldElement.F2m)lambda.square().add(lambda).
                    add(this.curve.getA());
            ECFieldElement ONE;
            ONE = this.curve.fromBigInteger(ECConstants.ONE);
            ECFieldElement.F2m y3;
            y3 = (ECFieldElement.F2m)this.x.square().add(
                    x3.multiply(lambda.add(ONE)));
            varB4EAC82CA7396A68D541C85D26508E83_689249581 = new ECPoint.F2m(this.curve, x3, y3, withCompression);
            ECPoint varA7E53CE21691AB073D9660D615818899_641824199; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_641824199 = varB4EAC82CA7396A68D541C85D26508E83_978599076;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_641824199 = varB4EAC82CA7396A68D541C85D26508E83_605640449;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_641824199 = varB4EAC82CA7396A68D541C85D26508E83_689249581;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_641824199.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_641824199;
            // ---------- Original Method ----------
            //if (this.isInfinity()) 
            //{
                //return this;
            //}
            //if (this.x.toBigInteger().signum() == 0) 
            //{
                //return this.curve.getInfinity();
            //}
            //ECFieldElement.F2m lambda
                //= (ECFieldElement.F2m)this.x.add(this.y.divide(this.x));
            //ECFieldElement.F2m x3
                //= (ECFieldElement.F2m)lambda.square().add(lambda).
                    //add(this.curve.getA());
            //ECFieldElement ONE = this.curve.fromBigInteger(ECConstants.ONE);
            //ECFieldElement.F2m y3
                //= (ECFieldElement.F2m)this.x.square().add(
                    //x3.multiply(lambda.add(ONE)));
            //return new ECPoint.F2m(this.curve, x3, y3, withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.283 -0400", hash_original_method = "55BA3FB66363791B05BA3007051689C2", hash_generated_method = "727CE38F8C6BED3E30F6676313A65374")
        public ECPoint negate() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1603558047 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1603558047 = new ECPoint.F2m(curve, this.getX(), this.getY().add(this.getX()), withCompression);
            varB4EAC82CA7396A68D541C85D26508E83_1603558047.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1603558047;
            // ---------- Original Method ----------
            //return new ECPoint.F2m(curve, this.getX(), this.getY().add(this.getX()), withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.288 -0400", hash_original_method = "B01B67DF3607CCDD35FFA0674C4BFE3B", hash_generated_method = "95B5AFCC2102448D9ECB77A6B3F7B561")
        synchronized void assertECMultiplier() {
            {
                {
                    boolean var3ED29988D2286D4C476B035DE0FC78E7_452282624 = (((ECCurve.F2m)this.curve).isKoblitz());
                    {
                        this.multiplier = new WTauNafMultiplier();
                    } //End block
                    {
                        this.multiplier = new WNafMultiplier();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //if (this.multiplier == null)
            //{
                //if (((ECCurve.F2m)this.curve).isKoblitz())
                //{
                    //this.multiplier = new WTauNafMultiplier();
                //}
                //else
                //{
                    //this.multiplier = new WNafMultiplier();
                //}
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.288 -0400", hash_original_field = "61707B662C0781EC16F82DBF410266B9", hash_generated_field = "F6B8D48C5F5A761E5DB11D930C790FFE")

    private static X9IntegerConverter converter = new X9IntegerConverter();
}

