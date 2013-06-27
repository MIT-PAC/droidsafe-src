package org.bouncycastle.asn1.sec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;

public class SECNamedCurves {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.657 -0400", hash_original_method = "23A51E56E8942FF07ABE86D375C28B89", hash_generated_method = "23A51E56E8942FF07ABE86D375C28B89")
    public SECNamedCurves ()
    {
        //Synthesized constructor
    }


        private static BigInteger fromHex(
        String hex) {
        return new BigInteger(1, Hex.decode(hex));
    }

    
        static void defineCurve(String name, DERObjectIdentifier oid, X9ECParametersHolder holder) {
        objIds.put(name, oid);
        names.put(oid, name);
        curves.put(oid, holder);
    }

    
        public static X9ECParameters getByName(
        String name) {
        DERObjectIdentifier oid = (DERObjectIdentifier)objIds.get(Strings.toLowerCase(name));
        if (oid != null)
        {
            return getByOID(oid);
        }
        return null;
    }

    
        public static X9ECParameters getByOID(
        DERObjectIdentifier oid) {
        X9ECParametersHolder holder = (X9ECParametersHolder)curves.get(oid);
        if (holder != null)
        {
            return holder.getParameters();
        }
        return null;
    }

    
        public static DERObjectIdentifier getOID(
        String name) {
        return (DERObjectIdentifier)objIds.get(Strings.toLowerCase(name));
    }

    
        public static String getName(
        DERObjectIdentifier oid) {
        return (String)names.get(oid);
    }

    
        public static Enumeration getNames() {
        return objIds.keys();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.672 -0400", hash_original_field = "B41E146BA8C164111B1645919735CC9D", hash_generated_field = "2FF725D59215834EB6FDA2FD3CEF67E1")

    static X9ECParametersHolder secp112r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.672 -0400", hash_original_method = "8E448402047C0F11C87A90E5BD1B04E9", hash_generated_method = "6379CB80253EB1A60D6C880ED5BFA525")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1674038547 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("DB7C2ABF62E35E668076BEAD208B");
            BigInteger a;
            a = fromHex("DB7C2ABF62E35E668076BEAD2088");
            BigInteger b;
            b = fromHex("659EF8BA043916EEDE8911702B22");
            byte[] S;
            S = Hex.decode("00F50B028E4D696E676875615175290472783FB1");
            BigInteger n;
            n = fromHex("DB7C2ABF62E35E7628DFAC6561C5");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "09487239995A5EE76B55F9C2F098"
                + "A89CE5AF8724C0A23E0E0FF77500"));
            varB4EAC82CA7396A68D541C85D26508E83_1674038547 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1674038547.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1674038547;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("DB7C2ABF62E35E668076BEAD208B");
            //BigInteger a = fromHex("DB7C2ABF62E35E668076BEAD2088");
            //BigInteger b = fromHex("659EF8BA043916EEDE8911702B22");
            //byte[] S = Hex.decode("00F50B028E4D696E676875615175290472783FB1");
            //BigInteger n = fromHex("DB7C2ABF62E35E7628DFAC6561C5");
            //BigInteger h = BigInteger.valueOf(1);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "09487239995A5EE76B55F9C2F098"
                //+ "A89CE5AF8724C0A23E0E0FF77500"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.681 -0400", hash_original_field = "5F969404F8070F5465E28F29946123AE", hash_generated_field = "4368F0A5FCE14C8211C5DFFB70F0BEB9")

    static X9ECParametersHolder secp112r2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.681 -0400", hash_original_method = "468E53769BA5ED2EE03D54A96E907092", hash_generated_method = "DECD85BD15E3A9FCDC5484F8BAD77718")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1339948156 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("DB7C2ABF62E35E668076BEAD208B");
            BigInteger a;
            a = fromHex("6127C24C05F38A0AAAF65C0EF02C");
            BigInteger b;
            b = fromHex("51DEF1815DB5ED74FCC34C85D709");
            byte[] S;
            S = Hex.decode("002757A1114D696E6768756151755316C05E0BD4");
            BigInteger n;
            n = fromHex("36DF0AAFD8B8D7597CA10520D04B");
            BigInteger h;
            h = BigInteger.valueOf(4);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "4BA30AB5E892B4E1649DD0928643"
                + "ADCD46F5882E3747DEF36E956E97"));
            varB4EAC82CA7396A68D541C85D26508E83_1339948156 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1339948156.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1339948156;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("DB7C2ABF62E35E668076BEAD208B");
            //BigInteger a = fromHex("6127C24C05F38A0AAAF65C0EF02C");
            //BigInteger b = fromHex("51DEF1815DB5ED74FCC34C85D709");
            //byte[] S = Hex.decode("002757A1114D696E6768756151755316C05E0BD4");
            //BigInteger n = fromHex("36DF0AAFD8B8D7597CA10520D04B");
            //BigInteger h = BigInteger.valueOf(4);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "4BA30AB5E892B4E1649DD0928643"
                //+ "ADCD46F5882E3747DEF36E956E97"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.686 -0400", hash_original_field = "E982AF317A03346C433CBBD4EFEA7088", hash_generated_field = "B9A8482CAC76EC23A3294A1C36384E6A")

    static X9ECParametersHolder secp128r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.685 -0400", hash_original_method = "97C5E2A90B849D3523C9EEADC16D1AF8", hash_generated_method = "3A0A10FAB990CFC65AC59D1F07BB45E4")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1243244338 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF");
            BigInteger a;
            a = fromHex("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC");
            BigInteger b;
            b = fromHex("E87579C11079F43DD824993C2CEE5ED3");
            byte[] S;
            S = Hex.decode("000E0D4D696E6768756151750CC03A4473D03679");
            BigInteger n;
            n = fromHex("FFFFFFFE0000000075A30D1B9038A115");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "161FF7528B899B2D0C28607CA52C5B86"
                + "CF5AC8395BAFEB13C02DA292DDED7A83"));
            varB4EAC82CA7396A68D541C85D26508E83_1243244338 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1243244338.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1243244338;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF");
            //BigInteger a = fromHex("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC");
            //BigInteger b = fromHex("E87579C11079F43DD824993C2CEE5ED3");
            //byte[] S = Hex.decode("000E0D4D696E6768756151750CC03A4473D03679");
            //BigInteger n = fromHex("FFFFFFFE0000000075A30D1B9038A115");
            //BigInteger h = BigInteger.valueOf(1);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "161FF7528B899B2D0C28607CA52C5B86"
                //+ "CF5AC8395BAFEB13C02DA292DDED7A83"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.699 -0400", hash_original_field = "71CFAF22C17BF0EAEAE13BF3AA8F25BA", hash_generated_field = "FD6153A62736ED38400C9C496BBF0866")

    static X9ECParametersHolder secp128r2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.687 -0400", hash_original_method = "43319354EF5C174017C8409BB24C6E19", hash_generated_method = "6E2BF7F7CAB538D8B1DF6999E43D995D")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1330564179 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF");
            BigInteger a;
            a = fromHex("D6031998D1B3BBFEBF59CC9BBFF9AEE1");
            BigInteger b;
            b = fromHex("5EEEFCA380D02919DC2C6558BB6D8A5D");
            byte[] S;
            S = Hex.decode("004D696E67687561517512D8F03431FCE63B88F4");
            BigInteger n;
            n = fromHex("3FFFFFFF7FFFFFFFBE0024720613B5A3");
            BigInteger h;
            h = BigInteger.valueOf(4);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "7B6AA5D85E572983E6FB32A7CDEBC140"
                + "27B6916A894D3AEE7106FE805FC34B44"));
            varB4EAC82CA7396A68D541C85D26508E83_1330564179 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1330564179.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1330564179;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF");
            //BigInteger a = fromHex("D6031998D1B3BBFEBF59CC9BBFF9AEE1");
            //BigInteger b = fromHex("5EEEFCA380D02919DC2C6558BB6D8A5D");
            //byte[] S = Hex.decode("004D696E67687561517512D8F03431FCE63B88F4");
            //BigInteger n = fromHex("3FFFFFFF7FFFFFFFBE0024720613B5A3");
            //BigInteger h = BigInteger.valueOf(4);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "7B6AA5D85E572983E6FB32A7CDEBC140"
                //+ "27B6916A894D3AEE7106FE805FC34B44"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.701 -0400", hash_original_field = "3398576FAC09240EC283C0AAED3D54E4", hash_generated_field = "66EEB111460D007A9BE24F361422BC40")

    static X9ECParametersHolder secp160k1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.701 -0400", hash_original_method = "E719BBEAA068ED10BCA6A033D327153E", hash_generated_method = "6989A6FE2F0D273AC909EE7F1C7774A7")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_258660383 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73");
            BigInteger a;
            a = ECConstants.ZERO;
            BigInteger b;
            b = BigInteger.valueOf(7);
            byte[] S;
            S = null;
            BigInteger n;
            n = fromHex("0100000000000000000001B8FA16DFAB9ACA16B6B3");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "3B4C382CE37AA192A4019E763036F4F5DD4D7EBB"
                + "938CF935318FDCED6BC28286531733C3F03C4FEE"));
            varB4EAC82CA7396A68D541C85D26508E83_258660383 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_258660383.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_258660383;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73");
            //BigInteger a = ECConstants.ZERO;
            //BigInteger b = BigInteger.valueOf(7);
            //byte[] S = null;
            //BigInteger n = fromHex("0100000000000000000001B8FA16DFAB9ACA16B6B3");
            //BigInteger h = BigInteger.valueOf(1);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "3B4C382CE37AA192A4019E763036F4F5DD4D7EBB"
                //+ "938CF935318FDCED6BC28286531733C3F03C4FEE"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.707 -0400", hash_original_field = "2AB110EC9C12A8F9175994736FD5B02C", hash_generated_field = "472E923632C62D1E84D8214D0000C673")

    static X9ECParametersHolder secp160r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.703 -0400", hash_original_method = "DDB2B363945B5490D694A386BE4E5F03", hash_generated_method = "2BB84BB5BF7307C8FAFD595304FAC6E1")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_301984496 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF");
            BigInteger a;
            a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC");
            BigInteger b;
            b = fromHex("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45");
            byte[] S;
            S = Hex.decode("1053CDE42C14D696E67687561517533BF3F83345");
            BigInteger n;
            n = fromHex("0100000000000000000001F4C8F927AED3CA752257");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "4A96B5688EF573284664698968C38BB913CBFC82"
                + "23A628553168947D59DCC912042351377AC5FB32"));
            varB4EAC82CA7396A68D541C85D26508E83_301984496 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_301984496.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_301984496;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF");
            //BigInteger a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC");
            //BigInteger b = fromHex("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45");
            //byte[] S = Hex.decode("1053CDE42C14D696E67687561517533BF3F83345");
            //BigInteger n = fromHex("0100000000000000000001F4C8F927AED3CA752257");
            //BigInteger h = BigInteger.valueOf(1);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "4A96B5688EF573284664698968C38BB913CBFC82"
                //+ "23A628553168947D59DCC912042351377AC5FB32"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.711 -0400", hash_original_field = "B801768A876AB9E1A06D46266D7736B2", hash_generated_field = "21AA3D312F293AEA3C7E327A4156A6D6")

    static X9ECParametersHolder secp160r2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.711 -0400", hash_original_method = "9950719937522ACF7448267AEFDF006A", hash_generated_method = "4A2055BA61712C750BDACE595E010A0C")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_927772863 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73");
            BigInteger a;
            a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70");
            BigInteger b;
            b = fromHex("B4E134D3FB59EB8BAB57274904664D5AF50388BA");
            byte[] S;
            S = Hex.decode("B99B99B099B323E02709A4D696E6768756151751");
            BigInteger n;
            n = fromHex("0100000000000000000000351EE786A818F3A1A16B");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "52DCB034293A117E1F4FF11B30F7199D3144CE6D"
                + "FEAFFEF2E331F296E071FA0DF9982CFEA7D43F2E"));
            varB4EAC82CA7396A68D541C85D26508E83_927772863 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_927772863.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_927772863;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73");
            //BigInteger a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70");
            //BigInteger b = fromHex("B4E134D3FB59EB8BAB57274904664D5AF50388BA");
            //byte[] S = Hex.decode("B99B99B099B323E02709A4D696E6768756151751");
            //BigInteger n = fromHex("0100000000000000000000351EE786A818F3A1A16B");
            //BigInteger h = BigInteger.valueOf(1);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "52DCB034293A117E1F4FF11B30F7199D3144CE6D"
                //+ "FEAFFEF2E331F296E071FA0DF9982CFEA7D43F2E"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.712 -0400", hash_original_field = "F443BB334E744D1AB628BBE229667AD4", hash_generated_field = "9BA9488B474E83062F46E9E12514A912")

    static X9ECParametersHolder secp192k1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.712 -0400", hash_original_method = "350F010EB26B45C92F40BBB1CD103BA0", hash_generated_method = "5EBA042408290CE543BCED699CD38C93")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1549181022 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37");
            BigInteger a;
            a = ECConstants.ZERO;
            BigInteger b;
            b = BigInteger.valueOf(3);
            byte[] S;
            S = null;
            BigInteger n;
            n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D"
                + "9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D"));
            varB4EAC82CA7396A68D541C85D26508E83_1549181022 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1549181022.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1549181022;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37");
            //BigInteger a = ECConstants.ZERO;
            //BigInteger b = BigInteger.valueOf(3);
            //byte[] S = null;
            //BigInteger n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D");
            //BigInteger h = BigInteger.valueOf(1);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D"
                //+ "9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.712 -0400", hash_original_field = "EAE018F0751BB0735BBC6EC2AE3488A4", hash_generated_field = "ED9488D545FC27F366098284E0F5F080")

    static X9ECParametersHolder secp192r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.712 -0400", hash_original_method = "CD250B58B5465DF0C8A18821FB3F1924", hash_generated_method = "309C584EED45EB0329124C0A84084318")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1968008999 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF");
            BigInteger a;
            a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC");
            BigInteger b;
            b = fromHex("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1");
            byte[] S;
            S = Hex.decode("3045AE6FC8422F64ED579528D38120EAE12196D5");
            BigInteger n;
            n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF1012"
                + "07192B95FFC8DA78631011ED6B24CDD573F977A11E794811"));
            varB4EAC82CA7396A68D541C85D26508E83_1968008999 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1968008999.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1968008999;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF");
            //BigInteger a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC");
            //BigInteger b = fromHex("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1");
            //byte[] S = Hex.decode("3045AE6FC8422F64ED579528D38120EAE12196D5");
            //BigInteger n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831");
            //BigInteger h = BigInteger.valueOf(1);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF1012"
                //+ "07192B95FFC8DA78631011ED6B24CDD573F977A11E794811"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.713 -0400", hash_original_field = "2F386C09373029D02D0FBA1D3B6F8156", hash_generated_field = "2180D2481B6C7533CAEC320AB0FACBD9")

    static X9ECParametersHolder secp224k1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.713 -0400", hash_original_method = "F8EE21E6B1A0FBC8F145CBF3D8CE3CFB", hash_generated_method = "A4C846C3930BFD211DA0FE95F5198DB3")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1067067474 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D");
            BigInteger a;
            a = ECConstants.ZERO;
            BigInteger b;
            b = BigInteger.valueOf(5);
            byte[] S;
            S = null;
            BigInteger n;
            n = fromHex("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "A1455B334DF099DF30FC28A169A467E9E47075A90F7E650EB6B7A45C"
                + "7E089FED7FBA344282CAFBD6F7E319F7C0B0BD59E2CA4BDB556D61A5"));
            varB4EAC82CA7396A68D541C85D26508E83_1067067474 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1067067474.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1067067474;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D");
            //BigInteger a = ECConstants.ZERO;
            //BigInteger b = BigInteger.valueOf(5);
            //byte[] S = null;
            //BigInteger n = fromHex("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7");
            //BigInteger h = BigInteger.valueOf(1);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "A1455B334DF099DF30FC28A169A467E9E47075A90F7E650EB6B7A45C"
                //+ "7E089FED7FBA344282CAFBD6F7E319F7C0B0BD59E2CA4BDB556D61A5"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.722 -0400", hash_original_field = "9A597036873E73DC6A72FECE6D6F5712", hash_generated_field = "9E2B62715AC159156D61D940950BD9A4")

    static X9ECParametersHolder secp224r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.721 -0400", hash_original_method = "5E3CCE2D1D9CAA16108BE66F878E85CC", hash_generated_method = "3DBF05D4B0183242176E9A40CE42E348")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1872627399 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001");
            BigInteger a;
            a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE");
            BigInteger b;
            b = fromHex("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4");
            byte[] S;
            S = Hex.decode("BD71344799D5C7FCDC45B59FA3B9AB8F6A948BC5");
            BigInteger n;
            n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "B70E0CBD6BB4BF7F321390B94A03C1D356C21122343280D6115C1D21"
                + "BD376388B5F723FB4C22DFE6CD4375A05A07476444D5819985007E34"));
            varB4EAC82CA7396A68D541C85D26508E83_1872627399 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1872627399.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1872627399;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.726 -0400", hash_original_field = "72DBCB5F9A9BF55575D44A2633460D5E", hash_generated_field = "F4619826CC8AF38E69ED4D168201A9DC")

    static X9ECParametersHolder secp256k1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.726 -0400", hash_original_method = "B753204968CAC07BB57DEF24BE54279B", hash_generated_method = "C7DC3A49F822337F970BCFAC1DE6FC6B")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_599404071 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F");
            BigInteger a;
            a = ECConstants.ZERO;
            BigInteger b;
            b = BigInteger.valueOf(7);
            byte[] S;
            S = null;
            BigInteger n;
            n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"
                + "483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8"));
            varB4EAC82CA7396A68D541C85D26508E83_599404071 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_599404071.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_599404071;
            // ---------- Original Method ----------
            //BigInteger p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F");
            //BigInteger a = ECConstants.ZERO;
            //BigInteger b = BigInteger.valueOf(7);
            //byte[] S = null;
            //BigInteger n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141");
            //BigInteger h = BigInteger.valueOf(1);
            //ECCurve curve = new ECCurve.Fp(p, a, b);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798"
                //+ "483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.732 -0400", hash_original_field = "B7DD68ECBDD670A7A3083EBD0DEFDC1D", hash_generated_field = "FAD5A64326A69416022F7D735EFD0A58")

    static X9ECParametersHolder secp256r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.732 -0400", hash_original_method = "2DCCFFE65BEEA022E61A31B0B196D486", hash_generated_method = "BD9D30EED0D76893FA5DAD2317AEB8CF")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_139707873 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF");
            BigInteger a;
            a = fromHex("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC");
            BigInteger b;
            b = fromHex("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B");
            byte[] S;
            S = Hex.decode("C49D360886E704936A6678E1139D26B7819F7E90");
            BigInteger n;
            n = fromHex("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296"
                + "4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5"));
            varB4EAC82CA7396A68D541C85D26508E83_139707873 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_139707873.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_139707873;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.733 -0400", hash_original_field = "6F65A1874614B834E202673B82D898EF", hash_generated_field = "612C02411F229B82457BEBE81A43C066")

    static X9ECParametersHolder secp384r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.733 -0400", hash_original_method = "80CF03327EF6750927A129BF16E6D681", hash_generated_method = "007005E633401DE884018335468D9252")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1300939247 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF");
            BigInteger a;
            a = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC");
            BigInteger b;
            b = fromHex("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF");
            byte[] S;
            S = Hex.decode("A335926AA319A27A1D00896A6773A4827ACDAC73");
            BigInteger n;
            n = fromHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "AA87CA22BE8B05378EB1C71EF320AD746E1D3B628BA79B9859F741E082542A385502F25DBF55296C3A545E3872760AB7"
                + "3617DE4A96262C6F5D9E98BF9292DC29F8F41DBD289A147CE9DA3113B5F0B8C00A60B1CE1D7E819D7A431D7C90EA0E5F"));
            varB4EAC82CA7396A68D541C85D26508E83_1300939247 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1300939247.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1300939247;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.735 -0400", hash_original_field = "CAECA391B2C0E3AB57B20BCD41B2FA41", hash_generated_field = "66D7BB9D6A0E49A16177604DDD265578")

    static X9ECParametersHolder secp521r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.735 -0400", hash_original_method = "79B36F90B44C85A48A3830602FF806E1", hash_generated_method = "F23902F9E12AFE89B70F274968196B04")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1781651986 = null; //Variable for return #1
            BigInteger p;
            p = fromHex("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
            BigInteger a;
            a = fromHex("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC");
            BigInteger b;
            b = fromHex("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00");
            byte[] S;
            S = Hex.decode("D09E8800291CB85396CC6717393284AAA0DA64BA");
            BigInteger n;
            n = fromHex("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409");
            BigInteger h;
            h = BigInteger.valueOf(1);
            ECCurve curve;
            curve = new ECCurve.Fp(p, a, b);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "00C6858E06B70404E9CD9E3ECB662395B4429C648139053FB521F828AF606B4D3DBAA14B5E77EFE75928FE1DC127A2FFA8DE3348B3C1856A429BF97E7E31C2E5BD66"
                + "011839296A789A3BC0045C8A5FB42C7D1BD998F54449579B446817AFBD17273E662C97EE72995EF42640C550B9013FAD0761353C7086A272C24088BE94769FD16650"));
            varB4EAC82CA7396A68D541C85D26508E83_1781651986 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1781651986.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1781651986;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.737 -0400", hash_original_field = "96976F6E4812D761893BE97B1B87D455", hash_generated_field = "4B652A96CFE26AEA9A27FAAD50118848")

    static X9ECParametersHolder sect113r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.736 -0400", hash_original_method = "B885FC73F0F72CED8886BA74AFEBBC53", hash_generated_method = "033E5E791FD4FC604F20B533AA4CA5C0")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1793539770 = null; //Variable for return #1
            int m;
            m = 113;
            int k;
            k = 9;
            BigInteger a;
            a = fromHex("003088250CA6E7C7FE649CE85820F7");
            BigInteger b;
            b = fromHex("00E8BEE4D3E2260744188BE0E9C723");
            byte[] S;
            S = Hex.decode("10E723AB14D696E6768756151756FEBF8FCB49A9");
            BigInteger n;
            n = fromHex("0100000000000000D9CCEC8A39E56F");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "009D73616F35F4AB1407D73562C10F"
                + "00A52830277958EE84D1315ED31886"));
            varB4EAC82CA7396A68D541C85D26508E83_1793539770 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1793539770.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1793539770;
            // ---------- Original Method ----------
            //int m = 113;
            //int k = 9;
            //BigInteger a = fromHex("003088250CA6E7C7FE649CE85820F7");
            //BigInteger b = fromHex("00E8BEE4D3E2260744188BE0E9C723");
            //byte[] S = Hex.decode("10E723AB14D696E6768756151756FEBF8FCB49A9");
            //BigInteger n = fromHex("0100000000000000D9CCEC8A39E56F");
            //BigInteger h = BigInteger.valueOf(2);
            //ECCurve curve = new ECCurve.F2m(m, k, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "009D73616F35F4AB1407D73562C10F"
                //+ "00A52830277958EE84D1315ED31886"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.752 -0400", hash_original_field = "5D8133664447D1E4F7D13552E917DBCA", hash_generated_field = "678AFA13C3878B1FE0F2C99A7EF25420")

    static X9ECParametersHolder sect113r2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.751 -0400", hash_original_method = "873F3FA5CF8FBCF68530771A6DC5B094", hash_generated_method = "AB7C5D158BE8AFCD251958025498CC8A")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1778121471 = null; //Variable for return #1
            int m;
            m = 113;
            int k;
            k = 9;
            BigInteger a;
            a = fromHex("00689918DBEC7E5A0DD6DFC0AA55C7");
            BigInteger b;
            b = fromHex("0095E9A9EC9B297BD4BF36E059184F");
            byte[] S;
            S = Hex.decode("10C0FB15760860DEF1EEF4D696E676875615175D");
            BigInteger n;
            n = fromHex("010000000000000108789B2496AF93");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "01A57A6A7B26CA5EF52FCDB8164797"
                + "00B3ADC94ED1FE674C06E695BABA1D"));
            varB4EAC82CA7396A68D541C85D26508E83_1778121471 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1778121471.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1778121471;
            // ---------- Original Method ----------
            //int m = 113;
            //int k = 9;
            //BigInteger a = fromHex("00689918DBEC7E5A0DD6DFC0AA55C7");
            //BigInteger b = fromHex("0095E9A9EC9B297BD4BF36E059184F");
            //byte[] S = Hex.decode("10C0FB15760860DEF1EEF4D696E676875615175D");
            //BigInteger n = fromHex("010000000000000108789B2496AF93");
            //BigInteger h = BigInteger.valueOf(2);
            //ECCurve curve = new ECCurve.F2m(m, k, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "01A57A6A7B26CA5EF52FCDB8164797"
                //+ "00B3ADC94ED1FE674C06E695BABA1D"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.753 -0400", hash_original_field = "FD21318D509A0E36D13A1509FAD7B04F", hash_generated_field = "5BBE6D233FBB425F72AAA3E998D0C3C3")

    static X9ECParametersHolder sect131r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.752 -0400", hash_original_method = "F86DF6B8541CFA01E108050621442C1B", hash_generated_method = "DF6C4FD2645945CBFF7A769B1E03FE85")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_292677390 = null; //Variable for return #1
            int m;
            m = 131;
            int k1;
            k1 = 2;
            int k2;
            k2 = 3;
            int k3;
            k3 = 8;
            BigInteger a;
            a = fromHex("07A11B09A76B562144418FF3FF8C2570B8");
            BigInteger b;
            b = fromHex("0217C05610884B63B9C6C7291678F9D341");
            byte[] S;
            S = Hex.decode("4D696E676875615175985BD3ADBADA21B43A97E2");
            BigInteger n;
            n = fromHex("0400000000000000023123953A9464B54D");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "0081BAF91FDF9833C40F9C181343638399"
                + "078C6E7EA38C001F73C8134B1B4EF9E150"));
            varB4EAC82CA7396A68D541C85D26508E83_292677390 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_292677390.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_292677390;
            // ---------- Original Method ----------
            //int m = 131;
            //int k1 = 2;
            //int k2 = 3;
            //int k3 = 8;
            //BigInteger a = fromHex("07A11B09A76B562144418FF3FF8C2570B8");
            //BigInteger b = fromHex("0217C05610884B63B9C6C7291678F9D341");
            //byte[] S = Hex.decode("4D696E676875615175985BD3ADBADA21B43A97E2");
            //BigInteger n = fromHex("0400000000000000023123953A9464B54D");
            //BigInteger h = BigInteger.valueOf(2);
            //ECCurve curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "0081BAF91FDF9833C40F9C181343638399"
                //+ "078C6E7EA38C001F73C8134B1B4EF9E150"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.762 -0400", hash_original_field = "BA0312C18913DAAADA2CACCFE9A525D2", hash_generated_field = "2742D1848A05B53AAE026E4079FFFDC0")

    static X9ECParametersHolder sect131r2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.755 -0400", hash_original_method = "3FB83B1C3F4DA9E5D14CA9119EF956F4", hash_generated_method = "D74E099A957AD8D970FA95135B5D1DCB")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_112463096 = null; //Variable for return #1
            int m;
            m = 131;
            int k1;
            k1 = 2;
            int k2;
            k2 = 3;
            int k3;
            k3 = 8;
            BigInteger a;
            a = fromHex("03E5A88919D7CAFCBF415F07C2176573B2");
            BigInteger b;
            b = fromHex("04B8266A46C55657AC734CE38F018F2192");
            byte[] S;
            S = Hex.decode("985BD3ADBAD4D696E676875615175A21B43A97E3");
            BigInteger n;
            n = fromHex("0400000000000000016954A233049BA98F");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "0356DCD8F2F95031AD652D23951BB366A8"
                + "0648F06D867940A5366D9E265DE9EB240F"));
            varB4EAC82CA7396A68D541C85D26508E83_112463096 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_112463096.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_112463096;
            // ---------- Original Method ----------
            //int m = 131;
            //int k1 = 2;
            //int k2 = 3;
            //int k3 = 8;
            //BigInteger a = fromHex("03E5A88919D7CAFCBF415F07C2176573B2");
            //BigInteger b = fromHex("04B8266A46C55657AC734CE38F018F2192");
            //byte[] S = Hex.decode("985BD3ADBAD4D696E676875615175A21B43A97E3");
            //BigInteger n = fromHex("0400000000000000016954A233049BA98F");
            //BigInteger h = BigInteger.valueOf(2);
            //ECCurve curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "0356DCD8F2F95031AD652D23951BB366A8"
                //+ "0648F06D867940A5366D9E265DE9EB240F"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.763 -0400", hash_original_field = "9004BA76FDCCD3F7DA3C9C45C1F2A011", hash_generated_field = "F7A99B51C9415D862735E68E1915456C")

    static X9ECParametersHolder sect163k1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.763 -0400", hash_original_method = "1CF51518AB8E48426A23D017265CEAC7", hash_generated_method = "DB97F1725A0FAD221AD62A763F041DC0")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_2121169944 = null; //Variable for return #1
            int m;
            m = 163;
            int k1;
            k1 = 3;
            int k2;
            k2 = 6;
            int k3;
            k3 = 7;
            BigInteger a;
            a = BigInteger.valueOf(1);
            BigInteger b;
            b = BigInteger.valueOf(1);
            byte[] S;
            S = null;
            BigInteger n;
            n = fromHex("04000000000000000000020108A2E0CC0D99F8A5EF");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "02FE13C0537BBC11ACAA07D793DE4E6D5E5C94EEE8"
                + "0289070FB05D38FF58321F2E800536D538CCDAA3D9"));
            varB4EAC82CA7396A68D541C85D26508E83_2121169944 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_2121169944.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2121169944;
            // ---------- Original Method ----------
            //int m = 163;
            //int k1 = 3;
            //int k2 = 6;
            //int k3 = 7;
            //BigInteger a = BigInteger.valueOf(1);
            //BigInteger b = BigInteger.valueOf(1);
            //byte[] S = null;
            //BigInteger n = fromHex("04000000000000000000020108A2E0CC0D99F8A5EF");
            //BigInteger h = BigInteger.valueOf(2);
            //ECCurve curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "02FE13C0537BBC11ACAA07D793DE4E6D5E5C94EEE8"
                //+ "0289070FB05D38FF58321F2E800536D538CCDAA3D9"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.764 -0400", hash_original_field = "A4AE2827500BB3211DBFD4C05C50BF0C", hash_generated_field = "4F82F43B1AF56F6B871B93D7EB52746D")

    static X9ECParametersHolder sect163r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.763 -0400", hash_original_method = "013C492C11913727E576250A34DE6343", hash_generated_method = "FFB4DE37868DCEB1A73E9326845AF0B2")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1148843906 = null; //Variable for return #1
            int m;
            m = 163;
            int k1;
            k1 = 3;
            int k2;
            k2 = 6;
            int k3;
            k3 = 7;
            BigInteger a;
            a = fromHex("07B6882CAAEFA84F9554FF8428BD88E246D2782AE2");
            BigInteger b;
            b = fromHex("0713612DCDDCB40AAB946BDA29CA91F73AF958AFD9");
            byte[] S;
            S = Hex.decode("24B7B137C8A14D696E6768756151756FD0DA2E5C");
            BigInteger n;
            n = fromHex("03FFFFFFFFFFFFFFFFFFFF48AAB689C29CA710279B");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "0369979697AB43897789566789567F787A7876A654"
                + "00435EDB42EFAFB2989D51FEFCE3C80988F41FF883"));
            varB4EAC82CA7396A68D541C85D26508E83_1148843906 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1148843906.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1148843906;
            // ---------- Original Method ----------
            //int m = 163;
            //int k1 = 3;
            //int k2 = 6;
            //int k3 = 7;
            //BigInteger a = fromHex("07B6882CAAEFA84F9554FF8428BD88E246D2782AE2");
            //BigInteger b = fromHex("0713612DCDDCB40AAB946BDA29CA91F73AF958AFD9");
            //byte[] S = Hex.decode("24B7B137C8A14D696E6768756151756FD0DA2E5C");
            //BigInteger n = fromHex("03FFFFFFFFFFFFFFFFFFFF48AAB689C29CA710279B");
            //BigInteger h = BigInteger.valueOf(2);
            //ECCurve curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "0369979697AB43897789566789567F787A7876A654"
                //+ "00435EDB42EFAFB2989D51FEFCE3C80988F41FF883"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.764 -0400", hash_original_field = "26858ADA101044B87D434E72AFF01645", hash_generated_field = "19CA030512E280EDB5D1668DD850B129")

    static X9ECParametersHolder sect163r2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.764 -0400", hash_original_method = "C131801BB1AAB755950E30E9E4DF8097", hash_generated_method = "6ABFD3E40FF3BFAEB2CD7B58C5056C8D")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1341428468 = null; //Variable for return #1
            int m;
            m = 163;
            int k1;
            k1 = 3;
            int k2;
            k2 = 6;
            int k3;
            k3 = 7;
            BigInteger a;
            a = BigInteger.valueOf(1);
            BigInteger b;
            b = fromHex("020A601907B8C953CA1481EB10512F78744A3205FD");
            byte[] S;
            S = Hex.decode("85E25BFE5C86226CDB12016F7553F9D0E693A268");
            BigInteger n;
            n = fromHex("040000000000000000000292FE77E70C12A4234C33");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "03F0EBA16286A2D57EA0991168D4994637E8343E36"
                + "00D51FBC6C71A0094FA2CDD545B11C5C0C797324F1"));
            varB4EAC82CA7396A68D541C85D26508E83_1341428468 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1341428468.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1341428468;
            // ---------- Original Method ----------
            //int m = 163;
            //int k1 = 3;
            //int k2 = 6;
            //int k3 = 7;
            //BigInteger a = BigInteger.valueOf(1);
            //BigInteger b = fromHex("020A601907B8C953CA1481EB10512F78744A3205FD");
            //byte[] S = Hex.decode("85E25BFE5C86226CDB12016F7553F9D0E693A268");
            //BigInteger n = fromHex("040000000000000000000292FE77E70C12A4234C33");
            //BigInteger h = BigInteger.valueOf(2);
            //ECCurve curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "03F0EBA16286A2D57EA0991168D4994637E8343E36"
                //+ "00D51FBC6C71A0094FA2CDD545B11C5C0C797324F1"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.766 -0400", hash_original_field = "B27C1E9C9FC0E59F088154F71EB84104", hash_generated_field = "783A23DADEF271C1C5059F86D342C7BD")

    static X9ECParametersHolder sect193r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.765 -0400", hash_original_method = "DF7F450FEF1B3A3B560CA3A0C0318C1E", hash_generated_method = "32AE26AFB163224BB9BD81ECAF8990CE")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_750001434 = null; //Variable for return #1
            int m;
            m = 193;
            int k;
            k = 15;
            BigInteger a;
            a = fromHex("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01");
            BigInteger b;
            b = fromHex("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814");
            byte[] S;
            S = Hex.decode("103FAEC74D696E676875615175777FC5B191EF30");
            BigInteger n;
            n = fromHex("01000000000000000000000000C7F34A778F443ACC920EBA49");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "01F481BC5F0FF84A74AD6CDF6FDEF4BF6179625372D8C0C5E1"
                + "0025E399F2903712CCF3EA9E3A1AD17FB0B3201B6AF7CE1B05"));
            varB4EAC82CA7396A68D541C85D26508E83_750001434 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_750001434.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_750001434;
            // ---------- Original Method ----------
            //int m = 193;
            //int k = 15;
            //BigInteger a = fromHex("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01");
            //BigInteger b = fromHex("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814");
            //byte[] S = Hex.decode("103FAEC74D696E676875615175777FC5B191EF30");
            //BigInteger n = fromHex("01000000000000000000000000C7F34A778F443ACC920EBA49");
            //BigInteger h = BigInteger.valueOf(2);
            //ECCurve curve = new ECCurve.F2m(m, k, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "01F481BC5F0FF84A74AD6CDF6FDEF4BF6179625372D8C0C5E1"
                //+ "0025E399F2903712CCF3EA9E3A1AD17FB0B3201B6AF7CE1B05"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.767 -0400", hash_original_field = "4172B89402E1709FC853FE657C799BCF", hash_generated_field = "DEC58A1565EC0BD79BDF79815D48247A")

    static X9ECParametersHolder sect193r2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.766 -0400", hash_original_method = "34B8DF7527F877746E2AB9998BD4D9A0", hash_generated_method = "0D4A634CE1DAA7EA8B5E9CD3DD89404A")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1647253061 = null; //Variable for return #1
            int m;
            m = 193;
            int k;
            k = 15;
            BigInteger a;
            a = fromHex("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B");
            BigInteger b;
            b = fromHex("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE");
            byte[] S;
            S = Hex.decode("10B7B4D696E676875615175137C8A16FD0DA2211");
            BigInteger n;
            n = fromHex("010000000000000000000000015AAB561B005413CCD4EE99D5");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "00D9B67D192E0367C803F39E1A7E82CA14A651350AAE617E8F"
                + "01CE94335607C304AC29E7DEFBD9CA01F596F927224CDECF6C"));
            varB4EAC82CA7396A68D541C85D26508E83_1647253061 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1647253061.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1647253061;
            // ---------- Original Method ----------
            //int m = 193;
            //int k = 15;
            //BigInteger a = fromHex("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B");
            //BigInteger b = fromHex("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE");
            //byte[] S = Hex.decode("10B7B4D696E676875615175137C8A16FD0DA2211");
            //BigInteger n = fromHex("010000000000000000000000015AAB561B005413CCD4EE99D5");
            //BigInteger h = BigInteger.valueOf(2);
            //ECCurve curve = new ECCurve.F2m(m, k, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "00D9B67D192E0367C803F39E1A7E82CA14A651350AAE617E8F"
                //+ "01CE94335607C304AC29E7DEFBD9CA01F596F927224CDECF6C"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.781 -0400", hash_original_field = "42122C3E2C7D15193577FF307AFCB45B", hash_generated_field = "8BE4C90EC6C106D1D62F2EF1D49B0BBB")

    static X9ECParametersHolder sect233k1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.781 -0400", hash_original_method = "6C906D6006DB2DE7B23F0152BF31DEF1", hash_generated_method = "A7FE7B7D9F70DDE421E6A64F87D2DA8C")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1419939803 = null; //Variable for return #1
            int m;
            m = 233;
            int k;
            k = 74;
            BigInteger a;
            a = ECConstants.ZERO;
            BigInteger b;
            b = BigInteger.valueOf(1);
            byte[] S;
            S = null;
            BigInteger n;
            n = fromHex("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF");
            BigInteger h;
            h = BigInteger.valueOf(4);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "017232BA853A7E731AF129F22FF4149563A419C26BF50A4C9D6EEFAD6126"
                + "01DB537DECE819B7F70F555A67C427A8CD9BF18AEB9B56E0C11056FAE6A3"));
            varB4EAC82CA7396A68D541C85D26508E83_1419939803 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1419939803.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1419939803;
            // ---------- Original Method ----------
            //int m = 233;
            //int k = 74;
            //BigInteger a = ECConstants.ZERO;
            //BigInteger b = BigInteger.valueOf(1);
            //byte[] S = null;
            //BigInteger n = fromHex("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF");
            //BigInteger h = BigInteger.valueOf(4);
            //ECCurve curve = new ECCurve.F2m(m, k, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "017232BA853A7E731AF129F22FF4149563A419C26BF50A4C9D6EEFAD6126"
                //+ "01DB537DECE819B7F70F555A67C427A8CD9BF18AEB9B56E0C11056FAE6A3"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.782 -0400", hash_original_field = "03448A32F413239402A1F40C88D1DBFA", hash_generated_field = "6C09B9F8DA598E3E0AE474BE17D94508")

    static X9ECParametersHolder sect233r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.781 -0400", hash_original_method = "07B356EC1DCC67D8B9E57B61206404AD", hash_generated_method = "73E39D19A8296B8D5FE752FE18D77E3B")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_817907328 = null; //Variable for return #1
            int m;
            m = 233;
            int k;
            k = 74;
            BigInteger a;
            a = BigInteger.valueOf(1);
            BigInteger b;
            b = fromHex("0066647EDE6C332C7F8C0923BB58213B333B20E9CE4281FE115F7D8F90AD");
            byte[] S;
            S = Hex.decode("74D59FF07F6B413D0EA14B344B20A2DB049B50C3");
            BigInteger n;
            n = fromHex("01000000000000000000000000000013E974E72F8A6922031D2603CFE0D7");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "00FAC9DFCBAC8313BB2139F1BB755FEF65BC391F8B36F8F8EB7371FD558B"
                + "01006A08A41903350678E58528BEBF8A0BEFF867A7CA36716F7E01F81052"));
            varB4EAC82CA7396A68D541C85D26508E83_817907328 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_817907328.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_817907328;
            // ---------- Original Method ----------
            //int m = 233;
            //int k = 74;
            //BigInteger a = BigInteger.valueOf(1);
            //BigInteger b = fromHex("0066647EDE6C332C7F8C0923BB58213B333B20E9CE4281FE115F7D8F90AD");
            //byte[] S = Hex.decode("74D59FF07F6B413D0EA14B344B20A2DB049B50C3");
            //BigInteger n = fromHex("01000000000000000000000000000013E974E72F8A6922031D2603CFE0D7");
            //BigInteger h = BigInteger.valueOf(2);
            //ECCurve curve = new ECCurve.F2m(m, k, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "00FAC9DFCBAC8313BB2139F1BB755FEF65BC391F8B36F8F8EB7371FD558B"
                //+ "01006A08A41903350678E58528BEBF8A0BEFF867A7CA36716F7E01F81052"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.786 -0400", hash_original_field = "9F5207DA0C09CF6E21210F852E286FBD", hash_generated_field = "C5236A70F5B6F97512913DC10A1EED26")

    static X9ECParametersHolder sect239k1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.786 -0400", hash_original_method = "1BB274E6633447AD0C198E0CE77AB80A", hash_generated_method = "7E22EC2B6B2F02B54E70FC0CD332F36F")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1432117860 = null; //Variable for return #1
            int m;
            m = 239;
            int k;
            k = 158;
            BigInteger a;
            a = ECConstants.ZERO;
            BigInteger b;
            b = BigInteger.valueOf(1);
            byte[] S;
            S = null;
            BigInteger n;
            n = fromHex("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5");
            BigInteger h;
            h = BigInteger.valueOf(4);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "29A0B6A887A983E9730988A68727A8B2D126C44CC2CC7B2A6555193035DC"
                + "76310804F12E549BDB011C103089E73510ACB275FC312A5DC6B76553F0CA"));
            varB4EAC82CA7396A68D541C85D26508E83_1432117860 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1432117860.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1432117860;
            // ---------- Original Method ----------
            //int m = 239;
            //int k = 158;
            //BigInteger a = ECConstants.ZERO;
            //BigInteger b = BigInteger.valueOf(1);
            //byte[] S = null;
            //BigInteger n = fromHex("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5");
            //BigInteger h = BigInteger.valueOf(4);
            //ECCurve curve = new ECCurve.F2m(m, k, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "29A0B6A887A983E9730988A68727A8B2D126C44CC2CC7B2A6555193035DC"
                //+ "76310804F12E549BDB011C103089E73510ACB275FC312A5DC6B76553F0CA"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.787 -0400", hash_original_field = "01C632D50489CF8783D08FE400DC5BD7", hash_generated_field = "AB5B31DEB21D511D752019EC16B8FB62")

    static X9ECParametersHolder sect283k1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.787 -0400", hash_original_method = "43320E8AD6889EF9FF9FAB4C50D6D1E9", hash_generated_method = "E24F538D8BBC25149E065CAC9BC9034D")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_954137364 = null; //Variable for return #1
            int m;
            m = 283;
            int k1;
            k1 = 5;
            int k2;
            k2 = 7;
            int k3;
            k3 = 12;
            BigInteger a;
            a = ECConstants.ZERO;
            BigInteger b;
            b = BigInteger.valueOf(1);
            byte[] S;
            S = null;
            BigInteger n;
            n = fromHex("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61");
            BigInteger h;
            h = BigInteger.valueOf(4);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "0503213F78CA44883F1A3B8162F188E553CD265F23C1567A16876913B0C2AC2458492836"
                + "01CCDA380F1C9E318D90F95D07E5426FE87E45C0E8184698E45962364E34116177DD2259"));
            varB4EAC82CA7396A68D541C85D26508E83_954137364 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_954137364.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_954137364;
            // ---------- Original Method ----------
            //int m = 283;
            //int k1 = 5;
            //int k2 = 7;
            //int k3 = 12;
            //BigInteger a = ECConstants.ZERO;
            //BigInteger b = BigInteger.valueOf(1);
            //byte[] S = null;
            //BigInteger n = fromHex("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61");
            //BigInteger h = BigInteger.valueOf(4);
            //ECCurve curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "0503213F78CA44883F1A3B8162F188E553CD265F23C1567A16876913B0C2AC2458492836"
                //+ "01CCDA380F1C9E318D90F95D07E5426FE87E45C0E8184698E45962364E34116177DD2259"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.788 -0400", hash_original_field = "C716D1BCBE97916232929F17CE42E976", hash_generated_field = "C23BFAE06FE57FE9436EF137A6D0C9EA")

    static X9ECParametersHolder sect283r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.788 -0400", hash_original_method = "BAFFAB3DD59BCB7DBF6C1389579B2C9B", hash_generated_method = "580166F8D322AA13C8BD04628CA57FB2")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_62089176 = null; //Variable for return #1
            int m;
            m = 283;
            int k1;
            k1 = 5;
            int k2;
            k2 = 7;
            int k3;
            k3 = 12;
            BigInteger a;
            a = BigInteger.valueOf(1);
            BigInteger b;
            b = fromHex("027B680AC8B8596DA5A4AF8A19A0303FCA97FD7645309FA2A581485AF6263E313B79A2F5");
            byte[] S;
            S = Hex.decode("77E2B07370EB0F832A6DD5B62DFC88CD06BB84BE");
            BigInteger n;
            n = fromHex("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEF90399660FC938A90165B042A7CEFADB307");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "05F939258DB7DD90E1934F8C70B0DFEC2EED25B8557EAC9C80E2E198F8CDBECD86B12053"
                + "03676854FE24141CB98FE6D4B20D02B4516FF702350EDDB0826779C813F0DF45BE8112F4"));
            varB4EAC82CA7396A68D541C85D26508E83_62089176 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_62089176.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_62089176;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.793 -0400", hash_original_field = "33088EFD1988036D661BD9EF34E5BD6D", hash_generated_field = "1685F1B72E16D38133B20B6D26F55B6A")

    static X9ECParametersHolder sect409k1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.793 -0400", hash_original_method = "7D19DAE4DBEC48E74839F2C6F3BE1E30", hash_generated_method = "9C798F3E0BC434A56567996C9F82C213")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_976311287 = null; //Variable for return #1
            int m;
            m = 409;
            int k;
            k = 87;
            BigInteger a;
            a = ECConstants.ZERO;
            BigInteger b;
            b = BigInteger.valueOf(1);
            byte[] S;
            S = null;
            BigInteger n;
            n = fromHex("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF");
            BigInteger h;
            h = BigInteger.valueOf(4);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "0060F05F658F49C1AD3AB1890F7184210EFD0987E307C84C27ACCFB8F9F67CC2C460189EB5AAAA62EE222EB1B35540CFE9023746"
                + "01E369050B7C4E42ACBA1DACBF04299C3460782F918EA427E6325165E9EA10E3DA5F6C42E9C55215AA9CA27A5863EC48D8E0286B"));
            varB4EAC82CA7396A68D541C85D26508E83_976311287 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_976311287.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_976311287;
            // ---------- Original Method ----------
            //int m = 409;
            //int k = 87;
            //BigInteger a = ECConstants.ZERO;
            //BigInteger b = BigInteger.valueOf(1);
            //byte[] S = null;
            //BigInteger n = fromHex("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF");
            //BigInteger h = BigInteger.valueOf(4);
            //ECCurve curve = new ECCurve.F2m(m, k, a, b, n, h);
            //ECPoint G = curve.decodePoint(Hex.decode("04"
                //+ "0060F05F658F49C1AD3AB1890F7184210EFD0987E307C84C27ACCFB8F9F67CC2C460189EB5AAAA62EE222EB1B35540CFE9023746"
                //+ "01E369050B7C4E42ACBA1DACBF04299C3460782F918EA427E6325165E9EA10E3DA5F6C42E9C55215AA9CA27A5863EC48D8E0286B"));
            //return new X9ECParameters(curve, G, n, h, S);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.807 -0400", hash_original_field = "CC270FB9105A33F5B97941DBE3D98160", hash_generated_field = "B5DFC2DFB6B583D9CE031A685CFB846A")

    static X9ECParametersHolder sect409r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.803 -0400", hash_original_method = "813243EC1F2EF186FEEB8FDBF8EFAEA1", hash_generated_method = "80E2B828C8D178B2FFEB77EA9B644AA1")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1190642325 = null; //Variable for return #1
            int m;
            m = 409;
            int k;
            k = 87;
            BigInteger a;
            a = BigInteger.valueOf(1);
            BigInteger b;
            b = fromHex("0021A5C2C8EE9FEB5C4B9A753B7B476B7FD6422EF1F3DD674761FA99D6AC27C8A9A197B272822F6CD57A55AA4F50AE317B13545F");
            byte[] S;
            S = Hex.decode("4099B5A457F9D69F79213D094C4BCD4D4262210B");
            BigInteger n;
            n = fromHex("010000000000000000000000000000000000000000000000000001E2AAD6A612F33307BE5FA47C3C9E052F838164CD37D9A21173");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "015D4860D088DDB3496B0C6064756260441CDE4AF1771D4DB01FFE5B34E59703DC255A868A1180515603AEAB60794E54BB7996A7"
                + "0061B1CFAB6BE5F32BBFA78324ED106A7636B9C5A7BD198D0158AA4F5488D08F38514F1FDF4B4F40D2181B3681C364BA0273C706"));
            varB4EAC82CA7396A68D541C85D26508E83_1190642325 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1190642325.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1190642325;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.814 -0400", hash_original_field = "F8FB64609BFCAE8520DC3805742F2442", hash_generated_field = "418F05581685BB9070B7656E41B32F5D")

    static X9ECParametersHolder sect571k1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.813 -0400", hash_original_method = "CBB599AB4E1E60D840DD23D28030C0A4", hash_generated_method = "B9F3FB5E1D7132E91AE67294D6898406")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_483341558 = null; //Variable for return #1
            int m;
            m = 571;
            int k1;
            k1 = 2;
            int k2;
            k2 = 5;
            int k3;
            k3 = 10;
            BigInteger a;
            a = ECConstants.ZERO;
            BigInteger b;
            b = BigInteger.valueOf(1);
            byte[] S;
            S = null;
            BigInteger n;
            n = fromHex("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001");
            BigInteger h;
            h = BigInteger.valueOf(4);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "026EB7A859923FBC82189631F8103FE4AC9CA2970012D5D46024804801841CA44370958493B205E647DA304DB4CEB08CBBD1BA39494776FB988B47174DCA88C7E2945283A01C8972"
                + "0349DC807F4FBF374F4AEADE3BCA95314DD58CEC9F307A54FFC61EFC006D8A2C9D4979C0AC44AEA74FBEBBB9F772AEDCB620B01A7BA7AF1B320430C8591984F601CD4C143EF1C7A3"));
            varB4EAC82CA7396A68D541C85D26508E83_483341558 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_483341558.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_483341558;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.815 -0400", hash_original_field = "D4444F3B372733CD71070BB10F372BBF", hash_generated_field = "456CD8DCA3566B0747255AE7AEBEE87C")

    static X9ECParametersHolder sect571r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.814 -0400", hash_original_method = "1723E2241C5F8371AAE0510851FF7E06", hash_generated_method = "B3FF89EF2A9EFFFF85449BF390D76CB7")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1451596275 = null; //Variable for return #1
            int m;
            m = 571;
            int k1;
            k1 = 2;
            int k2;
            k2 = 5;
            int k3;
            k3 = 10;
            BigInteger a;
            a = BigInteger.valueOf(1);
            BigInteger b;
            b = fromHex("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A");
            byte[] S;
            S = Hex.decode("2AA058F73A0E33AB486B0F610410C53A7F132310");
            BigInteger n;
            n = fromHex("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47");
            BigInteger h;
            h = BigInteger.valueOf(2);
            ECCurve curve;
            curve = new ECCurve.F2m(m, k1, k2, k3, a, b, n, h);
            ECPoint G;
            G = curve.decodePoint(Hex.decode("04"
                + "0303001D34B856296C16C0D40D3CD7750A93D1D2955FA80AA5F40FC8DB7B2ABDBDE53950F4C0D293CDD711A35B67FB1499AE60038614F1394ABFA3B4C850D927E1E7769C8EEC2D19"
                + "037BF27342DA639B6DCCFFFEB73D69D78C6C27A6009CBBCA1980F8533921E8A684423E43BAB08A576291AF8F461BB2A8B3531D2F0485C19B16E2F1516E23DD3C1A4827AF1B8AC15B"));
            varB4EAC82CA7396A68D541C85D26508E83_1451596275 = new X9ECParameters(curve, G, n, h, S);
            varB4EAC82CA7396A68D541C85D26508E83_1451596275.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1451596275;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.815 -0400", hash_original_field = "09196982C4917B07F992CCE003F1710F", hash_generated_field = "1169508D6249D74AF50B49E4347C0169")

    static Hashtable objIds = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.815 -0400", hash_original_field = "53A355950F48EB163EF1F9185C63BB74", hash_generated_field = "B652C3916C4B0B27A1AED979DB01CCBF")

    static Hashtable curves = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.815 -0400", hash_original_field = "E70BACFD70C0C66E2A0FC643AF5696C0", hash_generated_field = "BBC73B5D5E92CE9D193A9A8C606FBC8E")

    static Hashtable names = new Hashtable();
    static {
        defineCurve("secp112r1", SECObjectIdentifiers.secp112r1, secp112r1);
        defineCurve("secp112r2", SECObjectIdentifiers.secp112r2, secp112r2);
        defineCurve("secp128r1", SECObjectIdentifiers.secp128r1, secp128r1);
        defineCurve("secp128r2", SECObjectIdentifiers.secp128r2, secp128r2);
        defineCurve("secp160k1", SECObjectIdentifiers.secp160k1, secp160k1);
        defineCurve("secp160r1", SECObjectIdentifiers.secp160r1, secp160r1);
        defineCurve("secp160r2", SECObjectIdentifiers.secp160r2, secp160r2);
        defineCurve("secp192k1", SECObjectIdentifiers.secp192k1, secp192k1);
        defineCurve("secp192r1", SECObjectIdentifiers.secp192r1, secp192r1);
        defineCurve("secp224k1", SECObjectIdentifiers.secp224k1, secp224k1);
        defineCurve("secp224r1", SECObjectIdentifiers.secp224r1, secp224r1); 
        defineCurve("secp256k1", SECObjectIdentifiers.secp256k1, secp256k1);
        defineCurve("secp256r1", SECObjectIdentifiers.secp256r1, secp256r1); 
        defineCurve("secp384r1", SECObjectIdentifiers.secp384r1, secp384r1); 
        defineCurve("secp521r1", SECObjectIdentifiers.secp521r1, secp521r1); 
        defineCurve("sect113r1", SECObjectIdentifiers.sect113r1, sect113r1);
        defineCurve("sect113r2", SECObjectIdentifiers.sect113r2, sect113r2);
        defineCurve("sect131r1", SECObjectIdentifiers.sect131r1, sect131r1);
        defineCurve("sect131r2", SECObjectIdentifiers.sect131r2, sect131r2);
        defineCurve("sect163k1", SECObjectIdentifiers.sect163k1, sect163k1);
        defineCurve("sect163r1", SECObjectIdentifiers.sect163r1, sect163r1);
        defineCurve("sect163r2", SECObjectIdentifiers.sect163r2, sect163r2);
        defineCurve("sect193r1", SECObjectIdentifiers.sect193r1, sect193r1);
        defineCurve("sect193r2", SECObjectIdentifiers.sect193r2, sect193r2);
        defineCurve("sect233k1", SECObjectIdentifiers.sect233k1, sect233k1);
        defineCurve("sect233r1", SECObjectIdentifiers.sect233r1, sect233r1);
        defineCurve("sect239k1", SECObjectIdentifiers.sect239k1, sect239k1);
        defineCurve("sect283k1", SECObjectIdentifiers.sect283k1, sect283k1);
        defineCurve("sect283r1", SECObjectIdentifiers.sect283r1, sect283r1);
        defineCurve("sect409k1", SECObjectIdentifiers.sect409k1, sect409k1);
        defineCurve("sect409r1", SECObjectIdentifiers.sect409r1, sect409r1);
        defineCurve("sect571k1", SECObjectIdentifiers.sect571k1, sect571k1);
        defineCurve("sect571r1", SECObjectIdentifiers.sect571r1, sect571r1); 
    }
    
}

