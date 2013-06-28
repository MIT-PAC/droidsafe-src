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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.612 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "704A3581F062D90BBFC67E94998B89B2")

    ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.612 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "4962267CB3409346474982F669EDC96A")

    ECFieldElement x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.612 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "8FD25F34A4263F01B1FBD2F22B2F99BF")

    ECFieldElement y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.612 -0400", hash_original_field = "A04A91040E7D1CAA0270269A913F52BB", hash_generated_field = "7FD389F38A41EB1BAE8714CB05D998E3")

    protected boolean withCompression;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.612 -0400", hash_original_field = "73DABD82B9E2DA8B72224DD8528740A4", hash_generated_field = "C1F508A0F6FEA833DEEAC7A7B323D761")

    protected ECMultiplier multiplier = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.612 -0400", hash_original_field = "14172E23074FE3D1020FA12A5CEFEB04", hash_generated_field = "84CF639EBFFD87F3AC15C9EF1E1AAF42")

    protected PreCompInfo preCompInfo = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.612 -0400", hash_original_method = "5BA77B5B0277E538D25ED5D9A027BA25", hash_generated_method = "847A130CB97DB4D071D636D195FCCE97")
    protected  ECPoint(ECCurve curve, ECFieldElement x, ECFieldElement y) {
        this.curve = curve;
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.613 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "315B0D8D5D0F25932161932EF460F52E")
    public ECCurve getCurve() {
        ECCurve varB4EAC82CA7396A68D541C85D26508E83_638887864 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_638887864 = curve;
        varB4EAC82CA7396A68D541C85D26508E83_638887864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_638887864;
        // ---------- Original Method ----------
        //return curve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.613 -0400", hash_original_method = "C7C8D965D2F53EB7BBE8F50406AF2883", hash_generated_method = "28055B1616AB16A2F9E31A2998CD91F4")
    public ECFieldElement getX() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_1575453853 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1575453853 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1575453853.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1575453853;
        // ---------- Original Method ----------
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.613 -0400", hash_original_method = "B5FEFF99DC806D61F0BCF9BC7ACEB9BA", hash_generated_method = "94AC66E8922ABAB8BBE6CFB4C18EAA0B")
    public ECFieldElement getY() {
        ECFieldElement varB4EAC82CA7396A68D541C85D26508E83_964951452 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_964951452 = y;
        varB4EAC82CA7396A68D541C85D26508E83_964951452.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_964951452;
        // ---------- Original Method ----------
        //return y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.613 -0400", hash_original_method = "B09C1F46CE24A0176C4C3F4348C76697", hash_generated_method = "9DE4926A5E9CE7C99338604829C39120")
    public boolean isInfinity() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_979662704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_979662704;
        // ---------- Original Method ----------
        //return x == null && y == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.614 -0400", hash_original_method = "47BFB55B0C4A3BF2B8623783D9C43540", hash_generated_method = "052024C518A63360B9BAA7DE2C2309ED")
    public boolean isCompressed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_364139018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_364139018;
        // ---------- Original Method ----------
        //return withCompression;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.614 -0400", hash_original_method = "8BF915B7848C2883598F0B5C0E5B1EC3", hash_generated_method = "03FB1F13556AFC03D06F5C717F185DB4")
    public boolean equals(
        Object  other) {
        {
            boolean var140A8815FDEEC27C4D8944D501CA10BC_186851962 = (other == this);
        } //End collapsed parenthetic
        ECPoint o = (ECPoint)other;
        {
            boolean varB03470E068DC04327C836C8BEDADAFE1_1752943066 = (this.isInfinity());
            {
                boolean varDC84CE8AEB9453E25988DB714FEFECAF_1451181821 = (o.isInfinity());
            } //End block
        } //End collapsed parenthetic
        boolean var7EE45789D6D932F5F1311F0577CF265F_396205442 = (x.equals(o.x) && y.equals(o.y));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449899343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_449899343;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.614 -0400", hash_original_method = "50EB0D4EE4BADC10EDE9CC4D5C9244FF", hash_generated_method = "8066B6603AE0B0168F76F903FBADAE15")
    public int hashCode() {
        {
            boolean varB03470E068DC04327C836C8BEDADAFE1_266172221 = (this.isInfinity());
        } //End collapsed parenthetic
        int varFD4844CACAD08EE7CC6F70930CBF49EB_1778194197 = (x.hashCode() ^ y.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837783268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837783268;
        // ---------- Original Method ----------
        //if (this.isInfinity())
        //{
            //return 0;
        //}
        //return x.hashCode() ^ y.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.615 -0400", hash_original_method = "3CED2898CE1D9F7EEE71D4F4E6298B52", hash_generated_method = "7B74A03DE78F3C307128B0AF3CA7A466")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.616 -0400", hash_original_method = "CFD8CCAA4A8EFD7B41616F74559C84F4", hash_generated_method = "A3DFBB3FA717A82090B2DD1B90C7A348")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.617 -0400", hash_original_method = "0A712A2425F19F0711671167931DA051", hash_generated_method = "7EADE1A30D67A10C68FC308DF61B2A06")
    public ECPoint multiply(BigInteger k) {
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_430649492 = null; //Variable for return #1
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_1117008140 = null; //Variable for return #2
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_85468355 = null; //Variable for return #3
        {
            boolean varF5CB0378F3CC1D54FB008B542E2E4175_1042255064 = (k.signum() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The multiplicator cannot be negative");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB03470E068DC04327C836C8BEDADAFE1_591132175 = (this.isInfinity());
            {
                varB4EAC82CA7396A68D541C85D26508E83_430649492 = this;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var76C73C83AB7D485B6F3FD352E70601D6_2034475909 = (k.signum() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1117008140 = this.curve.getInfinity();
            } //End block
        } //End collapsed parenthetic
        assertECMultiplier();
        varB4EAC82CA7396A68D541C85D26508E83_85468355 = this.multiplier.multiply(this, k, preCompInfo);
        addTaint(k.getTaint());
        ECPoint varA7E53CE21691AB073D9660D615818899_1134824100; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1134824100 = varB4EAC82CA7396A68D541C85D26508E83_430649492;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1134824100 = varB4EAC82CA7396A68D541C85D26508E83_1117008140;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1134824100 = varB4EAC82CA7396A68D541C85D26508E83_85468355;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1134824100.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1134824100;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.618 -0400", hash_original_method = "C218E406154D6A68AEA278E34615CF99", hash_generated_method = "42000A5C4862A66CACDA81E55FB73F2B")
        public  Fp(ECCurve curve, ECFieldElement x, ECFieldElement y) {
            this(curve, x, y, false);
            addTaint(curve.getTaint());
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.618 -0400", hash_original_method = "DA43573652764E89DCD825DB3FC87547", hash_generated_method = "6E8C7507B410A6024B36622CEC2B0F36")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.619 -0400", hash_original_method = "122C86DAB9B6EC00B00943741F6C7C43", hash_generated_method = "ECCD56708AB81A8E8A9A3C07FE3F6969")
        public byte[] getEncoded() {
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_1585932137 = (this.isInfinity());
                {
                    byte[] varDC3732A3F5F37EC49A2E4A5DF1C88342_1454499338 = (new byte[1]);
                } //End block
            } //End collapsed parenthetic
            int qLength = converter.getByteLength(x);
            {
                byte PC;
                {
                    boolean varD887F1709689361DC8B0AB80CD81C246_1795432858 = (this.getY().toBigInteger().testBit(0));
                    {
                        PC = 0x03;
                    } //End block
                    {
                        PC = 0x02;
                    } //End block
                } //End collapsed parenthetic
                byte[] X = converter.integerToBytes(this.getX().toBigInteger(), qLength);
                byte[] PO = new byte[X.length + 1];
                PO[0] = PC;
                System.arraycopy(X, 0, PO, 1, X.length);
            } //End block
            {
                byte[] X = converter.integerToBytes(this.getX().toBigInteger(), qLength);
                byte[] Y = converter.integerToBytes(this.getY().toBigInteger(), qLength);
                byte[] PO = new byte[X.length + Y.length + 1];
                PO[0] = 0x04;
                System.arraycopy(X, 0, PO, 1, X.length);
                System.arraycopy(Y, 0, PO, X.length + 1, Y.length);
            } //End block
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_609334472 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_609334472;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.620 -0400", hash_original_method = "95E059CAF9907A74F8544551FF4AF334", hash_generated_method = "88C019738E3770F1B89B333BA59029BA")
        public ECPoint add(ECPoint b) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1513694865 = null; //Variable for return #1
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1850350572 = null; //Variable for return #2
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_766684105 = null; //Variable for return #3
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_784330450 = null; //Variable for return #4
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1788471178 = null; //Variable for return #5
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_1088586126 = (this.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1513694865 = b;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var908D0D7D4A9949C77E1B63E914B1D7AB_1905655202 = (b.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1850350572 = this;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var66DF63E936B6D1FAA6881D1F95A29873_1298814793 = (this.x.equals(b.x));
                {
                    {
                        boolean var09A872EDC0794D5341C95ACD14A20E4A_1443186081 = (this.y.equals(b.y));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_766684105 = this.twice();
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_784330450 = this.curve.getInfinity();
                } //End block
            } //End collapsed parenthetic
            ECFieldElement gamma = b.y.subtract(this.y).divide(b.x.subtract(this.x));
            ECFieldElement x3 = gamma.square().subtract(this.x).subtract(b.x);
            ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
            varB4EAC82CA7396A68D541C85D26508E83_1788471178 = new ECPoint.Fp(curve, x3, y3);
            addTaint(b.getTaint());
            ECPoint varA7E53CE21691AB073D9660D615818899_512592679; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_512592679 = varB4EAC82CA7396A68D541C85D26508E83_1513694865;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_512592679 = varB4EAC82CA7396A68D541C85D26508E83_1850350572;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_512592679 = varB4EAC82CA7396A68D541C85D26508E83_766684105;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_512592679 = varB4EAC82CA7396A68D541C85D26508E83_784330450;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_512592679 = varB4EAC82CA7396A68D541C85D26508E83_1788471178;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_512592679.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_512592679;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.621 -0400", hash_original_method = "814EC5F0BAC3EF42CB4061AB2E0CCD5F", hash_generated_method = "37F1E064EB760C2C91EC48AB0FAD83B0")
        public ECPoint twice() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_574983649 = null; //Variable for return #1
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1475164176 = null; //Variable for return #2
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1991543415 = null; //Variable for return #3
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_908929172 = (this.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_574983649 = this;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var4A993B1CDED66FE550138AAC82389C41_561438968 = (this.y.toBigInteger().signum() == 0);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1475164176 = this.curve.getInfinity();
                } //End block
            } //End collapsed parenthetic
            ECFieldElement TWO = this.curve.fromBigInteger(BigInteger.valueOf(2));
            ECFieldElement THREE = this.curve.fromBigInteger(BigInteger.valueOf(3));
            ECFieldElement gamma = this.x.square().multiply(THREE).add(curve.a).divide(y.multiply(TWO));
            ECFieldElement x3 = gamma.square().subtract(this.x.multiply(TWO));
            ECFieldElement y3 = gamma.multiply(this.x.subtract(x3)).subtract(this.y);
            varB4EAC82CA7396A68D541C85D26508E83_1991543415 = new ECPoint.Fp(curve, x3, y3, this.withCompression);
            ECPoint varA7E53CE21691AB073D9660D615818899_1040200890; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1040200890 = varB4EAC82CA7396A68D541C85D26508E83_574983649;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1040200890 = varB4EAC82CA7396A68D541C85D26508E83_1475164176;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1040200890 = varB4EAC82CA7396A68D541C85D26508E83_1991543415;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1040200890.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1040200890;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.622 -0400", hash_original_method = "6CF29EA69F961CE922C32B4E8E2284E5", hash_generated_method = "6ED6B0D290402B3DA3063460C3A537BD")
        public ECPoint subtract(ECPoint b) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_2126229659 = null; //Variable for return #1
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_759874439 = null; //Variable for return #2
            {
                boolean var908D0D7D4A9949C77E1B63E914B1D7AB_1757058394 = (b.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2126229659 = this;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_759874439 = add(b.negate());
            addTaint(b.getTaint());
            ECPoint varA7E53CE21691AB073D9660D615818899_977208109; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_977208109 = varB4EAC82CA7396A68D541C85D26508E83_2126229659;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_977208109 = varB4EAC82CA7396A68D541C85D26508E83_759874439;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_977208109.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_977208109;
            // ---------- Original Method ----------
            //if (b.isInfinity())
            //{
                //return this;
            //}
            //return add(b.negate());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.623 -0400", hash_original_method = "18C2403460E252970B56CE0DE1D343AC", hash_generated_method = "FDE817C3658E1F3EE763DD49DD63BB03")
        public ECPoint negate() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1316137344 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1316137344 = new ECPoint.Fp(curve, this.x, this.y.negate(), this.withCompression);
            varB4EAC82CA7396A68D541C85D26508E83_1316137344.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1316137344;
            // ---------- Original Method ----------
            //return new ECPoint.Fp(curve, this.x, this.y.negate(), this.withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.624 -0400", hash_original_method = "8EF68E9821BB7A65A39BDB5C806DAEDA", hash_generated_method = "9D03005E83437AF7AE2345086A0901C8")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.625 -0400", hash_original_method = "73BD63756191E5AAFB19346FBE556EB3", hash_generated_method = "FF55D416F3E4248E822D393EE0759DAC")
        public  F2m(ECCurve curve, ECFieldElement x, ECFieldElement y) {
            this(curve, x, y, false);
            addTaint(curve.getTaint());
            addTaint(x.getTaint());
            addTaint(y.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.626 -0400", hash_original_method = "4610FCAEB1DDBBF845E95D34129A59A7", hash_generated_method = "BEA52E1D2A17868CE006DA5D9E0E0B1F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.629 -0400", hash_original_method = "91DE6710B35AB1954917AAE97889BD70", hash_generated_method = "8A46B0AD19BAFFF316CEFF1CD1DDC40B")
        public byte[] getEncoded() {
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_1171406122 = (this.isInfinity());
                {
                    byte[] varDC3732A3F5F37EC49A2E4A5DF1C88342_320747332 = (new byte[1]);
                } //End block
            } //End collapsed parenthetic
            int byteCount = converter.getByteLength(this.x);
            byte[] X = converter.integerToBytes(this.getX().toBigInteger(), byteCount);
            byte[] PO;
            {
                PO = new byte[byteCount + 1];
                PO[0] = 0x02;
                {
                    boolean varC9110A8DD36BD0AEBF7B7278459C1614_1359554717 = (!(this.getX().toBigInteger().equals(ECConstants.ZERO)));
                    {
                        {
                            boolean var0134D4F4ADE9527B2BFCCA72540F2F93_905775794 = (this.getY().multiply(this.getX().invert())
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
                byte[] Y = converter.integerToBytes(this.getY().toBigInteger(), byteCount);
                PO = new byte[byteCount + byteCount + 1];
                PO[0] = 0x04;
                System.arraycopy(X, 0, PO, 1, byteCount);
                System.arraycopy(Y, 0, PO, byteCount + 1, byteCount);
            } //End block
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1505228392 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1505228392;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.631 -0400", hash_original_method = "CE1FEB0E79091A4CCB0243E0EA7A28CB", hash_generated_method = "5EC9B2708F43296B7189816FCD876576")
        public ECPoint add(ECPoint b) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_372167351 = null; //Variable for return #1
            checkPoints(this, b);
            varB4EAC82CA7396A68D541C85D26508E83_372167351 = addSimple((ECPoint.F2m)b);
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_372167351.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_372167351;
            // ---------- Original Method ----------
            //checkPoints(this, b);
            //return addSimple((ECPoint.F2m)b);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.633 -0400", hash_original_method = "230992766041FE2E7B78B40F0E0C1144", hash_generated_method = "BA60D90CC437E3987794C42C62BA36DB")
        public ECPoint.F2m addSimple(ECPoint.F2m b) {
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_1712241454 = null; //Variable for return #1
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_992820952 = null; //Variable for return #2
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_390938680 = null; //Variable for return #3
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_35180764 = null; //Variable for return #4
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_674673209 = null; //Variable for return #5
            ECPoint.F2m other = b;
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_1280802625 = (this.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1712241454 = other;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var488668EC7B3656666D603083E4B4A5F5_38915623 = (other.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_992820952 = this;
                } //End block
            } //End collapsed parenthetic
            ECFieldElement.F2m x2 = (ECFieldElement.F2m)other.getX();
            ECFieldElement.F2m y2 = (ECFieldElement.F2m)other.getY();
            {
                boolean varD94053BC8F53E0F37132A731E03D7495_464651167 = (this.x.equals(x2));
                {
                    {
                        boolean varD57155AC29D78D2D630C3828E07A7A00_564041467 = (this.y.equals(y2));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_390938680 = (ECPoint.F2m)this.twice();
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_35180764 = (ECPoint.F2m)this.curve.getInfinity();
                } //End block
            } //End collapsed parenthetic
            ECFieldElement.F2m lambda = (ECFieldElement.F2m)(this.y.add(y2)).divide(this.x.add(x2));
            ECFieldElement.F2m x3 = (ECFieldElement.F2m)lambda.square().add(lambda).add(this.x).add(x2).add(this.curve.getA());
            ECFieldElement.F2m y3 = (ECFieldElement.F2m)lambda.multiply(this.x.add(x3)).add(x3).add(this.y);
            varB4EAC82CA7396A68D541C85D26508E83_674673209 = new ECPoint.F2m(curve, x3, y3, withCompression);
            addTaint(b.getTaint());
            ECPoint.F2m varA7E53CE21691AB073D9660D615818899_648833234; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_648833234 = varB4EAC82CA7396A68D541C85D26508E83_1712241454;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_648833234 = varB4EAC82CA7396A68D541C85D26508E83_992820952;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_648833234 = varB4EAC82CA7396A68D541C85D26508E83_390938680;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_648833234 = varB4EAC82CA7396A68D541C85D26508E83_35180764;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_648833234 = varB4EAC82CA7396A68D541C85D26508E83_674673209;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_648833234.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_648833234;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.634 -0400", hash_original_method = "E180EBB5B66B4130D071F14F4EE083E4", hash_generated_method = "D8F74E6BF3263EB6C26BC430E57EA1D3")
        public ECPoint subtract(ECPoint b) {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1871783749 = null; //Variable for return #1
            checkPoints(this, b);
            varB4EAC82CA7396A68D541C85D26508E83_1871783749 = subtractSimple((ECPoint.F2m)b);
            addTaint(b.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1871783749.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1871783749;
            // ---------- Original Method ----------
            //checkPoints(this, b);
            //return subtractSimple((ECPoint.F2m)b);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.635 -0400", hash_original_method = "FE873BC192C2EB55E75185601239ED06", hash_generated_method = "64C575885DBC54A2CFCEE5EE14BBEB10")
        public ECPoint.F2m subtractSimple(ECPoint.F2m b) {
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_415452521 = null; //Variable for return #1
            ECPoint.F2m varB4EAC82CA7396A68D541C85D26508E83_1185775294 = null; //Variable for return #2
            {
                boolean var908D0D7D4A9949C77E1B63E914B1D7AB_2033928461 = (b.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_415452521 = this;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1185775294 = addSimple((ECPoint.F2m)b.negate());
            addTaint(b.getTaint());
            ECPoint.F2m varA7E53CE21691AB073D9660D615818899_751103591; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_751103591 = varB4EAC82CA7396A68D541C85D26508E83_415452521;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_751103591 = varB4EAC82CA7396A68D541C85D26508E83_1185775294;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_751103591.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_751103591;
            // ---------- Original Method ----------
            //if (b.isInfinity())
            //{
                //return this;
            //}
            //return addSimple((ECPoint.F2m)b.negate());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.636 -0400", hash_original_method = "45BA33A6C8448ED0A2617484FF5E8003", hash_generated_method = "375BC65BC218A4BFD9A8A11EAE79447E")
        public ECPoint twice() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1943580903 = null; //Variable for return #1
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1549049175 = null; //Variable for return #2
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1217201406 = null; //Variable for return #3
            {
                boolean varB1E4D1887A5249B74BFE7226099FCBFE_716832196 = (this.isInfinity());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1943580903 = this;
                } //End block
            } //End collapsed parenthetic
            {
                boolean varC3B49E08C4799B4FB26BD80041DA99F1_1544033821 = (this.x.toBigInteger().signum() == 0);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1549049175 = this.curve.getInfinity();
                } //End block
            } //End collapsed parenthetic
            ECFieldElement.F2m lambda = (ECFieldElement.F2m)this.x.add(this.y.divide(this.x));
            ECFieldElement.F2m x3 = (ECFieldElement.F2m)lambda.square().add(lambda).
                    add(this.curve.getA());
            ECFieldElement ONE = this.curve.fromBigInteger(ECConstants.ONE);
            ECFieldElement.F2m y3 = (ECFieldElement.F2m)this.x.square().add(
                    x3.multiply(lambda.add(ONE)));
            varB4EAC82CA7396A68D541C85D26508E83_1217201406 = new ECPoint.F2m(this.curve, x3, y3, withCompression);
            ECPoint varA7E53CE21691AB073D9660D615818899_1197134176; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1197134176 = varB4EAC82CA7396A68D541C85D26508E83_1943580903;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1197134176 = varB4EAC82CA7396A68D541C85D26508E83_1549049175;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1197134176 = varB4EAC82CA7396A68D541C85D26508E83_1217201406;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1197134176.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1197134176;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.637 -0400", hash_original_method = "55BA3FB66363791B05BA3007051689C2", hash_generated_method = "57B0B551896D59DD3B9C2BC255B8BC09")
        public ECPoint negate() {
            ECPoint varB4EAC82CA7396A68D541C85D26508E83_1851184416 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1851184416 = new ECPoint.F2m(curve, this.getX(), this.getY().add(this.getX()), withCompression);
            varB4EAC82CA7396A68D541C85D26508E83_1851184416.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1851184416;
            // ---------- Original Method ----------
            //return new ECPoint.F2m(curve, this.getX(), this.getY().add(this.getX()), withCompression);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.638 -0400", hash_original_method = "B01B67DF3607CCDD35FFA0674C4BFE3B", hash_generated_method = "163A2CC92E06087DDDB1D5673604F649")
        synchronized void assertECMultiplier() {
            {
                {
                    boolean var3ED29988D2286D4C476B035DE0FC78E7_929220717 = (((ECCurve.F2m)this.curve).isKoblitz());
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.639 -0400", hash_original_field = "61707B662C0781EC16F82DBF410266B9", hash_generated_field = "F6B8D48C5F5A761E5DB11D930C790FFE")

    private static X9IntegerConverter converter = new X9IntegerConverter();
}

