package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;

public class X962NamedCurves {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.348 -0400", hash_original_method = "E9893857EF70F6AC19E01FEF66A94FDD", hash_generated_method = "E9893857EF70F6AC19E01FEF66A94FDD")
    public X962NamedCurves ()
    {
        //Synthesized constructor
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.353 -0400", hash_original_field = "2B9CC11C7FF569B9F238F688D0D48774", hash_generated_field = "2F8C9FBB767DF27F47F7740AD167EE4E")

    static X9ECParametersHolder prime192v1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.352 -0400", hash_original_method = "0B01D07FA9972E41F0F2DE861B34CC04", hash_generated_method = "B25AD2ACEA46555BC2EB6B5649C8966B")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_402496216 = null; //Variable for return #1
            ECCurve cFp192v1;
            cFp192v1 = new ECCurve.Fp(
                new BigInteger("6277101735386680763835789423207666416083908700390324961279"),
                new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16),
                new BigInteger("64210519e59c80e70fa7e9ab72243049feb8deecc146b9b1", 16));
            varB4EAC82CA7396A68D541C85D26508E83_402496216 = new X9ECParameters(
                cFp192v1,
                cFp192v1.decodePoint(
                    Hex.decode("03188da80eb03090f67cbf20eb43a18800f4ff0afd82ff1012")),
                new BigInteger("ffffffffffffffffffffffff99def836146bc9b1b4d22831", 16),
                BigInteger.valueOf(1),
                Hex.decode("3045AE6FC8422f64ED579528D38120EAE12196D5"));
            varB4EAC82CA7396A68D541C85D26508E83_402496216.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_402496216;
            // ---------- Original Method ----------
            //ECCurve cFp192v1 = new ECCurve.Fp(
                //new BigInteger("6277101735386680763835789423207666416083908700390324961279"),
                //new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16),
                //new BigInteger("64210519e59c80e70fa7e9ab72243049feb8deecc146b9b1", 16));
            //return new X9ECParameters(
                //cFp192v1,
                //cFp192v1.decodePoint(
                    //Hex.decode("03188da80eb03090f67cbf20eb43a18800f4ff0afd82ff1012")),
                //new BigInteger("ffffffffffffffffffffffff99def836146bc9b1b4d22831", 16),
                //BigInteger.valueOf(1),
                //Hex.decode("3045AE6FC8422f64ED579528D38120EAE12196D5"));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.354 -0400", hash_original_field = "8BAC8A3233FB3D98850BF8EC293DBC9D", hash_generated_field = "A46683E840EF37ABAD6D8425835E033F")

    static X9ECParametersHolder prime192v2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.353 -0400", hash_original_method = "4E93A293794C023DE8392647CC9F3861", hash_generated_method = "6732CA73297CE6BB6B954BCA57DA07AC")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_202269068 = null; //Variable for return #1
            ECCurve cFp192v2;
            cFp192v2 = new ECCurve.Fp(
                new BigInteger("6277101735386680763835789423207666416083908700390324961279"),
                new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16),
                new BigInteger("cc22d6dfb95c6b25e49c0d6364a4e5980c393aa21668d953", 16));
            varB4EAC82CA7396A68D541C85D26508E83_202269068 = new X9ECParameters(
                cFp192v2,
                cFp192v2.decodePoint(
                    Hex.decode("03eea2bae7e1497842f2de7769cfe9c989c072ad696f48034a")),
                new BigInteger("fffffffffffffffffffffffe5fb1a724dc80418648d8dd31", 16),
                BigInteger.valueOf(1),
                Hex.decode("31a92ee2029fd10d901b113e990710f0d21ac6b6"));
            varB4EAC82CA7396A68D541C85D26508E83_202269068.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_202269068;
            // ---------- Original Method ----------
            //ECCurve cFp192v2 = new ECCurve.Fp(
                //new BigInteger("6277101735386680763835789423207666416083908700390324961279"),
                //new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16),
                //new BigInteger("cc22d6dfb95c6b25e49c0d6364a4e5980c393aa21668d953", 16));
            //return new X9ECParameters(
                //cFp192v2,
                //cFp192v2.decodePoint(
                    //Hex.decode("03eea2bae7e1497842f2de7769cfe9c989c072ad696f48034a")),
                //new BigInteger("fffffffffffffffffffffffe5fb1a724dc80418648d8dd31", 16),
                //BigInteger.valueOf(1),
                //Hex.decode("31a92ee2029fd10d901b113e990710f0d21ac6b6"));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.361 -0400", hash_original_field = "F8BBD1D8ECD451534E7D4B077103F2BF", hash_generated_field = "F5A65753E74B72D72858A527683F1A52")

    static X9ECParametersHolder prime192v3 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.354 -0400", hash_original_method = "561E09FE418261B715C0B0F7131EB9AA", hash_generated_method = "6E099A067580F3CCC258EBB9632A4BE4")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1371450966 = null; //Variable for return #1
            ECCurve cFp192v3;
            cFp192v3 = new ECCurve.Fp(
                new BigInteger("6277101735386680763835789423207666416083908700390324961279"),
                new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16),
                new BigInteger("22123dc2395a05caa7423daeccc94760a7d462256bd56916", 16));
            varB4EAC82CA7396A68D541C85D26508E83_1371450966 = new X9ECParameters(
                cFp192v3,
                cFp192v3.decodePoint(
                    Hex.decode("027d29778100c65a1da1783716588dce2b8b4aee8e228f1896")),
                new BigInteger("ffffffffffffffffffffffff7a62d031c83f4294f640ec13", 16),
                BigInteger.valueOf(1),
                Hex.decode("c469684435deb378c4b65ca9591e2a5763059a2e"));
            varB4EAC82CA7396A68D541C85D26508E83_1371450966.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1371450966;
            // ---------- Original Method ----------
            //ECCurve cFp192v3 = new ECCurve.Fp(
                //new BigInteger("6277101735386680763835789423207666416083908700390324961279"),
                //new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16),
                //new BigInteger("22123dc2395a05caa7423daeccc94760a7d462256bd56916", 16));
            //return new X9ECParameters(
                //cFp192v3,
                //cFp192v3.decodePoint(
                    //Hex.decode("027d29778100c65a1da1783716588dce2b8b4aee8e228f1896")),
                //new BigInteger("ffffffffffffffffffffffff7a62d031c83f4294f640ec13", 16),
                //BigInteger.valueOf(1),
                //Hex.decode("c469684435deb378c4b65ca9591e2a5763059a2e"));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.362 -0400", hash_original_field = "40996880BEA2607566E3F14D5FE5DB00", hash_generated_field = "EB8A096F7967CBACD0F0EEBC52E9CE3C")

    static X9ECParametersHolder prime239v1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.362 -0400", hash_original_method = "8239FE46B0A28D2F310ADFA3B8BE22B8", hash_generated_method = "A99D8D3BC61E281E079149ABBD023FE8")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_2135102323 = null; //Variable for return #1
            ECCurve cFp239v1;
            cFp239v1 = new ECCurve.Fp(
                new BigInteger("883423532389192164791648750360308885314476597252960362792450860609699839"),
                new BigInteger("7fffffffffffffffffffffff7fffffffffff8000000000007ffffffffffc", 16),
                new BigInteger("6b016c3bdcf18941d0d654921475ca71a9db2fb27d1d37796185c2942c0a", 16));
            varB4EAC82CA7396A68D541C85D26508E83_2135102323 = new X9ECParameters(
                cFp239v1,
                cFp239v1.decodePoint(
                    Hex.decode("020ffa963cdca8816ccc33b8642bedf905c3d358573d3f27fbbd3b3cb9aaaf")),
                new BigInteger("7fffffffffffffffffffffff7fffff9e5e9a9f5d9071fbd1522688909d0b", 16),
                BigInteger.valueOf(1),
                Hex.decode("e43bb460f0b80cc0c0b075798e948060f8321b7d"));
            varB4EAC82CA7396A68D541C85D26508E83_2135102323.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2135102323;
            // ---------- Original Method ----------
            //ECCurve cFp239v1 = new ECCurve.Fp(
                //new BigInteger("883423532389192164791648750360308885314476597252960362792450860609699839"),
                //new BigInteger("7fffffffffffffffffffffff7fffffffffff8000000000007ffffffffffc", 16),
                //new BigInteger("6b016c3bdcf18941d0d654921475ca71a9db2fb27d1d37796185c2942c0a", 16));
            //return new X9ECParameters(
                //cFp239v1,
                //cFp239v1.decodePoint(
                    //Hex.decode("020ffa963cdca8816ccc33b8642bedf905c3d358573d3f27fbbd3b3cb9aaaf")),
                //new BigInteger("7fffffffffffffffffffffff7fffff9e5e9a9f5d9071fbd1522688909d0b", 16),
                //BigInteger.valueOf(1),
                //Hex.decode("e43bb460f0b80cc0c0b075798e948060f8321b7d"));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.364 -0400", hash_original_field = "80981054E92C6701C02B1258D4627FD5", hash_generated_field = "82367D054AC4C6EF14A5CB364B26C219")

    static X9ECParametersHolder prime239v2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.363 -0400", hash_original_method = "351306A44030B144302CB546AE95D076", hash_generated_method = "38EB2D26B26C0001E3A53EF05DAEBC42")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_2028896055 = null; //Variable for return #1
            ECCurve cFp239v2;
            cFp239v2 = new ECCurve.Fp(
                new BigInteger("883423532389192164791648750360308885314476597252960362792450860609699839"),
                new BigInteger("7fffffffffffffffffffffff7fffffffffff8000000000007ffffffffffc", 16),
                new BigInteger("617fab6832576cbbfed50d99f0249c3fee58b94ba0038c7ae84c8c832f2c", 16));
            varB4EAC82CA7396A68D541C85D26508E83_2028896055 = new X9ECParameters(
                cFp239v2,
                cFp239v2.decodePoint(
                    Hex.decode("0238af09d98727705120c921bb5e9e26296a3cdcf2f35757a0eafd87b830e7")),
                new BigInteger("7fffffffffffffffffffffff800000cfa7e8594377d414c03821bc582063", 16),
                BigInteger.valueOf(1),
                Hex.decode("e8b4011604095303ca3b8099982be09fcb9ae616"));
            varB4EAC82CA7396A68D541C85D26508E83_2028896055.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2028896055;
            // ---------- Original Method ----------
            //ECCurve cFp239v2 = new ECCurve.Fp(
                //new BigInteger("883423532389192164791648750360308885314476597252960362792450860609699839"),
                //new BigInteger("7fffffffffffffffffffffff7fffffffffff8000000000007ffffffffffc", 16),
                //new BigInteger("617fab6832576cbbfed50d99f0249c3fee58b94ba0038c7ae84c8c832f2c", 16));
            //return new X9ECParameters(
                //cFp239v2,
                //cFp239v2.decodePoint(
                    //Hex.decode("0238af09d98727705120c921bb5e9e26296a3cdcf2f35757a0eafd87b830e7")),
                //new BigInteger("7fffffffffffffffffffffff800000cfa7e8594377d414c03821bc582063", 16),
                //BigInteger.valueOf(1),
                //Hex.decode("e8b4011604095303ca3b8099982be09fcb9ae616"));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.373 -0400", hash_original_field = "4220FAB355B49ED518009B8FDC618979", hash_generated_field = "4A4887E86515CC96EE1C61488A2493D6")

    static X9ECParametersHolder prime239v3 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.367 -0400", hash_original_method = "3DF3C75DA42E41839400C85B091C0129", hash_generated_method = "85A0698D8BE2CA2718514080731756DF")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_2060887107 = null; //Variable for return #1
            ECCurve cFp239v3;
            cFp239v3 = new ECCurve.Fp(
                new BigInteger("883423532389192164791648750360308885314476597252960362792450860609699839"),
                new BigInteger("7fffffffffffffffffffffff7fffffffffff8000000000007ffffffffffc", 16),
                new BigInteger("255705fa2a306654b1f4cb03d6a750a30c250102d4988717d9ba15ab6d3e", 16));
            varB4EAC82CA7396A68D541C85D26508E83_2060887107 = new X9ECParameters(
                cFp239v3,
                cFp239v3.decodePoint(
                    Hex.decode("036768ae8e18bb92cfcf005c949aa2c6d94853d0e660bbf854b1c9505fe95a")),
                new BigInteger("7fffffffffffffffffffffff7fffff975deb41b3a6057c3c432146526551", 16),
                BigInteger.valueOf(1),
                Hex.decode("7d7374168ffe3471b60a857686a19475d3bfa2ff"));
            varB4EAC82CA7396A68D541C85D26508E83_2060887107.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2060887107;
            // ---------- Original Method ----------
            //ECCurve cFp239v3 = new ECCurve.Fp(
                //new BigInteger("883423532389192164791648750360308885314476597252960362792450860609699839"),
                //new BigInteger("7fffffffffffffffffffffff7fffffffffff8000000000007ffffffffffc", 16),
                //new BigInteger("255705fa2a306654b1f4cb03d6a750a30c250102d4988717d9ba15ab6d3e", 16));
            //return new X9ECParameters(
                //cFp239v3,
                //cFp239v3.decodePoint(
                    //Hex.decode("036768ae8e18bb92cfcf005c949aa2c6d94853d0e660bbf854b1c9505fe95a")),
                //new BigInteger("7fffffffffffffffffffffff7fffff975deb41b3a6057c3c432146526551", 16),
                //BigInteger.valueOf(1),
                //Hex.decode("7d7374168ffe3471b60a857686a19475d3bfa2ff"));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.374 -0400", hash_original_field = "77A95BAAB48848993C8E2014F92E5F67", hash_generated_field = "DB02FF24DA8DD85698B6D778AF15C704")

    static X9ECParametersHolder prime256v1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.374 -0400", hash_original_method = "79C7234C41AA3C4EC4E0102564F4FCD4", hash_generated_method = "1125C1B911961086B347861A13B6703C")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1959768533 = null; //Variable for return #1
            ECCurve cFp256v1;
            cFp256v1 = new ECCurve.Fp(
                new BigInteger("115792089210356248762697446949407573530086143415290314195533631308867097853951"),
                new BigInteger("ffffffff00000001000000000000000000000000fffffffffffffffffffffffc", 16),
                new BigInteger("5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16));
            varB4EAC82CA7396A68D541C85D26508E83_1959768533 = new X9ECParameters(
                cFp256v1,
                cFp256v1.decodePoint(
                    Hex.decode("036b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296")),
                new BigInteger("ffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551", 16),
                BigInteger.valueOf(1),
                Hex.decode("c49d360886e704936a6678e1139d26b7819f7e90"));
            varB4EAC82CA7396A68D541C85D26508E83_1959768533.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1959768533;
            // ---------- Original Method ----------
            //ECCurve cFp256v1 = new ECCurve.Fp(
                //new BigInteger("115792089210356248762697446949407573530086143415290314195533631308867097853951"),
                //new BigInteger("ffffffff00000001000000000000000000000000fffffffffffffffffffffffc", 16),
                //new BigInteger("5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16));
            //return new X9ECParameters(
                //cFp256v1,
                //cFp256v1.decodePoint(
                    //Hex.decode("036b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296")),
                //new BigInteger("ffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551", 16),
                //BigInteger.valueOf(1),
                //Hex.decode("c49d360886e704936a6678e1139d26b7819f7e90"));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.375 -0400", hash_original_field = "864978BD0B4BE12245C5B210A9640CE9", hash_generated_field = "88ED8B935DED0F3D7F4DBEDE4D31F17A")

    static X9ECParametersHolder c2pnb163v1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.374 -0400", hash_original_method = "62BC8BE80DD7CCC73D39CF290550C1DE", hash_generated_method = "4A23E57F6AF11A6AB88456917BB19A2C")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_721727404 = null; //Variable for return #1
            BigInteger c2m163v1n;
            c2m163v1n = new BigInteger("0400000000000000000001E60FC8821CC74DAEAFC1", 16);
            BigInteger c2m163v1h;
            c2m163v1h = BigInteger.valueOf(2);
            ECCurve c2m163v1;
            c2m163v1 = new ECCurve.F2m(
                163,
                1, 2, 8,
                new BigInteger("072546B5435234A422E0789675F432C89435DE5242", 16),
                new BigInteger("00C9517D06D5240D3CFF38C74B20B6CD4D6F9DD4D9", 16),
                c2m163v1n, c2m163v1h);
            varB4EAC82CA7396A68D541C85D26508E83_721727404 = new X9ECParameters(
                c2m163v1,
                c2m163v1.decodePoint(
                    Hex.decode("0307AF69989546103D79329FCC3D74880F33BBE803CB")),
                c2m163v1n, c2m163v1h,
                Hex.decode("D2COFB15760860DEF1EEF4D696E6768756151754"));
            varB4EAC82CA7396A68D541C85D26508E83_721727404.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_721727404;
            // ---------- Original Method ----------
            //BigInteger c2m163v1n = new BigInteger("0400000000000000000001E60FC8821CC74DAEAFC1", 16);
            //BigInteger c2m163v1h = BigInteger.valueOf(2);
            //ECCurve c2m163v1 = new ECCurve.F2m(
                //163,
                //1, 2, 8,
                //new BigInteger("072546B5435234A422E0789675F432C89435DE5242", 16),
                //new BigInteger("00C9517D06D5240D3CFF38C74B20B6CD4D6F9DD4D9", 16),
                //c2m163v1n, c2m163v1h);
            //return new X9ECParameters(
                //c2m163v1,
                //c2m163v1.decodePoint(
                    //Hex.decode("0307AF69989546103D79329FCC3D74880F33BBE803CB")),
                //c2m163v1n, c2m163v1h,
                //Hex.decode("D2COFB15760860DEF1EEF4D696E6768756151754"));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.391 -0400", hash_original_field = "B8500FD6ED6BEB9D5D5F6BCB7B92D815", hash_generated_field = "9C9892EED4EFB916E2A54F3A492AC74F")

    static X9ECParametersHolder c2pnb163v2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.382 -0400", hash_original_method = "716279BF3FE75DC28EAFCE45707DC8C4", hash_generated_method = "501EB776F6653F9D6758CD0A70C97288")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_136853187 = null; //Variable for return #1
            BigInteger c2m163v2n;
            c2m163v2n = new BigInteger("03FFFFFFFFFFFFFFFFFFFDF64DE1151ADBB78F10A7", 16);
            BigInteger c2m163v2h;
            c2m163v2h = BigInteger.valueOf(2);
            ECCurve c2m163v2;
            c2m163v2 = new ECCurve.F2m(
                163,
                1, 2, 8,
                new BigInteger("0108B39E77C4B108BED981ED0E890E117C511CF072", 16),
                new BigInteger("0667ACEB38AF4E488C407433FFAE4F1C811638DF20", 16),
                c2m163v2n, c2m163v2h);
            varB4EAC82CA7396A68D541C85D26508E83_136853187 = new X9ECParameters(
                c2m163v2,
                c2m163v2.decodePoint(
                    Hex.decode("030024266E4EB5106D0A964D92C4860E2671DB9B6CC5")),
                c2m163v2n, c2m163v2h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_136853187.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_136853187;
            // ---------- Original Method ----------
            //BigInteger c2m163v2n = new BigInteger("03FFFFFFFFFFFFFFFFFFFDF64DE1151ADBB78F10A7", 16);
            //BigInteger c2m163v2h = BigInteger.valueOf(2);
            //ECCurve c2m163v2 = new ECCurve.F2m(
                //163,
                //1, 2, 8,
                //new BigInteger("0108B39E77C4B108BED981ED0E890E117C511CF072", 16),
                //new BigInteger("0667ACEB38AF4E488C407433FFAE4F1C811638DF20", 16),
                //c2m163v2n, c2m163v2h);
            //return new X9ECParameters(
                //c2m163v2,
                //c2m163v2.decodePoint(
                    //Hex.decode("030024266E4EB5106D0A964D92C4860E2671DB9B6CC5")),
                //c2m163v2n, c2m163v2h,
                //null);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.392 -0400", hash_original_field = "985D839D652011925FFE4183B22DF77A", hash_generated_field = "18715D1B885BF06CF03DB0C4E9123B56")

    static X9ECParametersHolder c2pnb163v3 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.392 -0400", hash_original_method = "CF6C9B2DE4E170AA5ADA8CA0CCB12A3B", hash_generated_method = "3708CC774C980A254335FCD8F6E49A18")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1911739061 = null; //Variable for return #1
            BigInteger c2m163v3n;
            c2m163v3n = new BigInteger("03FFFFFFFFFFFFFFFFFFFE1AEE140F110AFF961309", 16);
            BigInteger c2m163v3h;
            c2m163v3h = BigInteger.valueOf(2);
            ECCurve c2m163v3;
            c2m163v3 = new ECCurve.F2m(
                163,
                1, 2, 8,
                new BigInteger("07A526C63D3E25A256A007699F5447E32AE456B50E", 16),
                new BigInteger("03F7061798EB99E238FD6F1BF95B48FEEB4854252B", 16),
                c2m163v3n, c2m163v3h);
            varB4EAC82CA7396A68D541C85D26508E83_1911739061 = new X9ECParameters(
                c2m163v3,
                c2m163v3.decodePoint(
                    Hex.decode("0202F9F87B7C574D0BDECF8A22E6524775F98CDEBDCB")),
                c2m163v3n, c2m163v3h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_1911739061.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1911739061;
            // ---------- Original Method ----------
            //BigInteger c2m163v3n = new BigInteger("03FFFFFFFFFFFFFFFFFFFE1AEE140F110AFF961309", 16);
            //BigInteger c2m163v3h = BigInteger.valueOf(2);
            //ECCurve c2m163v3 = new ECCurve.F2m(
                //163,
                //1, 2, 8,
                //new BigInteger("07A526C63D3E25A256A007699F5447E32AE456B50E", 16),
                //new BigInteger("03F7061798EB99E238FD6F1BF95B48FEEB4854252B", 16),
                //c2m163v3n, c2m163v3h);
            //return new X9ECParameters(
                //c2m163v3,
                //c2m163v3.decodePoint(
                    //Hex.decode("0202F9F87B7C574D0BDECF8A22E6524775F98CDEBDCB")),
                //c2m163v3n, c2m163v3h,
                //null);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.393 -0400", hash_original_field = "10CE570E94ED5AF04158473E3BEE5F95", hash_generated_field = "604FC656E99AA1F5FE22C7ABFBAE7659")

    static X9ECParametersHolder c2pnb176w1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.393 -0400", hash_original_method = "BEAEF27E189E269EBE29494C580BCC4A", hash_generated_method = "214C1260E651B25F1F2A88192C905594")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_734191195 = null; //Variable for return #1
            BigInteger c2m176w1n;
            c2m176w1n = new BigInteger("010092537397ECA4F6145799D62B0A19CE06FE26AD", 16);
            BigInteger c2m176w1h;
            c2m176w1h = BigInteger.valueOf(0xFF6E);
            ECCurve c2m176w1;
            c2m176w1 = new ECCurve.F2m(
                176,
                1, 2, 43,
                new BigInteger("00E4E6DB2995065C407D9D39B8D0967B96704BA8E9C90B", 16),
                new BigInteger("005DDA470ABE6414DE8EC133AE28E9BBD7FCEC0AE0FFF2", 16),
                c2m176w1n, c2m176w1h);
            varB4EAC82CA7396A68D541C85D26508E83_734191195 = new X9ECParameters(
                c2m176w1,
                c2m176w1.decodePoint(
                    Hex.decode("038D16C2866798B600F9F08BB4A8E860F3298CE04A5798")),
                c2m176w1n, c2m176w1h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_734191195.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_734191195;
            // ---------- Original Method ----------
            //BigInteger c2m176w1n = new BigInteger("010092537397ECA4F6145799D62B0A19CE06FE26AD", 16);
            //BigInteger c2m176w1h = BigInteger.valueOf(0xFF6E);
            //ECCurve c2m176w1 = new ECCurve.F2m(
                //176,
                //1, 2, 43,
                //new BigInteger("00E4E6DB2995065C407D9D39B8D0967B96704BA8E9C90B", 16),
                //new BigInteger("005DDA470ABE6414DE8EC133AE28E9BBD7FCEC0AE0FFF2", 16),
                //c2m176w1n, c2m176w1h);
            //return new X9ECParameters(
                //c2m176w1,
                //c2m176w1.decodePoint(
                    //Hex.decode("038D16C2866798B600F9F08BB4A8E860F3298CE04A5798")),
                //c2m176w1n, c2m176w1h,
                //null);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.403 -0400", hash_original_field = "2A00A5D2B6B48C55F8891FF29AD479C6", hash_generated_field = "4085F1CC4DCDCFCC9E610DE381A529CD")

    static X9ECParametersHolder c2tnb191v1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.400 -0400", hash_original_method = "88655D221C97CDA9B8EA72F7C040033F", hash_generated_method = "AC7167033D77E55D1DF276950BA904FB")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1814652934 = null; //Variable for return #1
            BigInteger c2m191v1n;
            c2m191v1n = new BigInteger("40000000000000000000000004A20E90C39067C893BBB9A5", 16);
            BigInteger c2m191v1h;
            c2m191v1h = BigInteger.valueOf(2);
            ECCurve c2m191v1;
            c2m191v1 = new ECCurve.F2m(
                191,
                9,
                new BigInteger("2866537B676752636A68F56554E12640276B649EF7526267", 16),
                new BigInteger("2E45EF571F00786F67B0081B9495A3D95462F5DE0AA185EC", 16),
                c2m191v1n, c2m191v1h);
            varB4EAC82CA7396A68D541C85D26508E83_1814652934 = new X9ECParameters(
                c2m191v1,
                c2m191v1.decodePoint(
                    Hex.decode("0236B3DAF8A23206F9C4F299D7B21A9C369137F2C84AE1AA0D")),
                c2m191v1n, c2m191v1h,
                Hex.decode("4E13CA542744D696E67687561517552F279A8C84"));
            varB4EAC82CA7396A68D541C85D26508E83_1814652934.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1814652934;
            // ---------- Original Method ----------
            //BigInteger c2m191v1n = new BigInteger("40000000000000000000000004A20E90C39067C893BBB9A5", 16);
            //BigInteger c2m191v1h = BigInteger.valueOf(2);
            //ECCurve c2m191v1 = new ECCurve.F2m(
                //191,
                //9,
                //new BigInteger("2866537B676752636A68F56554E12640276B649EF7526267", 16),
                //new BigInteger("2E45EF571F00786F67B0081B9495A3D95462F5DE0AA185EC", 16),
                //c2m191v1n, c2m191v1h);
            //return new X9ECParameters(
                //c2m191v1,
                //c2m191v1.decodePoint(
                    //Hex.decode("0236B3DAF8A23206F9C4F299D7B21A9C369137F2C84AE1AA0D")),
                //c2m191v1n, c2m191v1h,
                //Hex.decode("4E13CA542744D696E67687561517552F279A8C84"));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.410 -0400", hash_original_field = "7C6CCBD40CFAB72898BD2416113AD231", hash_generated_field = "AB913CE5D03DBADBE29EF391BDE5B727")

    static X9ECParametersHolder c2tnb191v2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.410 -0400", hash_original_method = "AE0C92C7770C7B571F0FAE2DA1A3373C", hash_generated_method = "D13EB7A817B91CDAB1D1385E280B56FD")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1695332942 = null; //Variable for return #1
            BigInteger c2m191v2n;
            c2m191v2n = new BigInteger("20000000000000000000000050508CB89F652824E06B8173", 16);
            BigInteger c2m191v2h;
            c2m191v2h = BigInteger.valueOf(4);
            ECCurve c2m191v2;
            c2m191v2 = new ECCurve.F2m(
                191,
                9,
                new BigInteger("401028774D7777C7B7666D1366EA432071274F89FF01E718", 16),
                new BigInteger("0620048D28BCBD03B6249C99182B7C8CD19700C362C46A01", 16),
                c2m191v2n, c2m191v2h);
            varB4EAC82CA7396A68D541C85D26508E83_1695332942 = new X9ECParameters(
                c2m191v2,
                c2m191v2.decodePoint(
                    Hex.decode("023809B2B7CC1B28CC5A87926AAD83FD28789E81E2C9E3BF10")),
                c2m191v2n, c2m191v2h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_1695332942.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1695332942;
            // ---------- Original Method ----------
            //BigInteger c2m191v2n = new BigInteger("20000000000000000000000050508CB89F652824E06B8173", 16);
            //BigInteger c2m191v2h = BigInteger.valueOf(4);
            //ECCurve c2m191v2 = new ECCurve.F2m(
                //191,
                //9,
                //new BigInteger("401028774D7777C7B7666D1366EA432071274F89FF01E718", 16),
                //new BigInteger("0620048D28BCBD03B6249C99182B7C8CD19700C362C46A01", 16),
                //c2m191v2n, c2m191v2h);
            //return new X9ECParameters(
                //c2m191v2,
                //c2m191v2.decodePoint(
                    //Hex.decode("023809B2B7CC1B28CC5A87926AAD83FD28789E81E2C9E3BF10")),
                //c2m191v2n, c2m191v2h,
                //null);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.418 -0400", hash_original_field = "6017D4A51C5BA8E6C7292D2B06B6F748", hash_generated_field = "F0F42B106A41450571AA66D7E0850177")

    static X9ECParametersHolder c2tnb191v3 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.418 -0400", hash_original_method = "A7219D964C1FAE9E8E5A4658AECE2143", hash_generated_method = "1095B3A2359CDCDD7FE1A4666F11212C")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1003763500 = null; //Variable for return #1
            BigInteger c2m191v3n;
            c2m191v3n = new BigInteger("155555555555555555555555610C0B196812BFB6288A3EA3", 16);
            BigInteger c2m191v3h;
            c2m191v3h = BigInteger.valueOf(6);
            ECCurve c2m191v3;
            c2m191v3 = new ECCurve.F2m(
                191,
                9,
                new BigInteger("6C01074756099122221056911C77D77E77A777E7E7E77FCB", 16),
                new BigInteger("71FE1AF926CF847989EFEF8DB459F66394D90F32AD3F15E8", 16),
                c2m191v3n, c2m191v3h);
            varB4EAC82CA7396A68D541C85D26508E83_1003763500 = new X9ECParameters(
                c2m191v3,
                c2m191v3.decodePoint(
                    Hex.decode("03375D4CE24FDE434489DE8746E71786015009E66E38A926DD")),
                c2m191v3n, c2m191v3h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_1003763500.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1003763500;
            // ---------- Original Method ----------
            //BigInteger c2m191v3n = new BigInteger("155555555555555555555555610C0B196812BFB6288A3EA3", 16);
            //BigInteger c2m191v3h = BigInteger.valueOf(6);
            //ECCurve c2m191v3 = new ECCurve.F2m(
                //191,
                //9,
                //new BigInteger("6C01074756099122221056911C77D77E77A777E7E7E77FCB", 16),
                //new BigInteger("71FE1AF926CF847989EFEF8DB459F66394D90F32AD3F15E8", 16),
                //c2m191v3n, c2m191v3h);
            //return new X9ECParameters(
                //c2m191v3,
                //c2m191v3.decodePoint(
                    //Hex.decode("03375D4CE24FDE434489DE8746E71786015009E66E38A926DD")),
                //c2m191v3n, c2m191v3h,
                //null);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.419 -0400", hash_original_field = "2E20B7290E49709F48C9D2BE081A9C71", hash_generated_field = "0DCCBD895BC12EADC72D48F270A3AF48")

    static X9ECParametersHolder c2pnb208w1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.419 -0400", hash_original_method = "6E09289677196B370EC32CAC47AE68AE", hash_generated_method = "5EC3494ABE14B5CBDCE2A5EDA0CB70E8")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_855150286 = null; //Variable for return #1
            BigInteger c2m208w1n;
            c2m208w1n = new BigInteger("0101BAF95C9723C57B6C21DA2EFF2D5ED588BDD5717E212F9D", 16);
            BigInteger c2m208w1h;
            c2m208w1h = BigInteger.valueOf(0xFE48);
            ECCurve c2m208w1;
            c2m208w1 = new ECCurve.F2m(
                208,
                1, 2, 83,
                new BigInteger("0", 16),
                new BigInteger("00C8619ED45A62E6212E1160349E2BFA844439FAFC2A3FD1638F9E", 16),
                c2m208w1n, c2m208w1h);
            varB4EAC82CA7396A68D541C85D26508E83_855150286 = new X9ECParameters(
                c2m208w1,
                c2m208w1.decodePoint(
                    Hex.decode("0289FDFBE4ABE193DF9559ECF07AC0CE78554E2784EB8C1ED1A57A")),
                c2m208w1n, c2m208w1h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_855150286.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_855150286;
            // ---------- Original Method ----------
            //BigInteger c2m208w1n = new BigInteger("0101BAF95C9723C57B6C21DA2EFF2D5ED588BDD5717E212F9D", 16);
            //BigInteger c2m208w1h = BigInteger.valueOf(0xFE48);
            //ECCurve c2m208w1 = new ECCurve.F2m(
                //208,
                //1, 2, 83,
                //new BigInteger("0", 16),
                //new BigInteger("00C8619ED45A62E6212E1160349E2BFA844439FAFC2A3FD1638F9E", 16),
                //c2m208w1n, c2m208w1h);
            //return new X9ECParameters(
                //c2m208w1,
                //c2m208w1.decodePoint(
                    //Hex.decode("0289FDFBE4ABE193DF9559ECF07AC0CE78554E2784EB8C1ED1A57A")),
                //c2m208w1n, c2m208w1h,
                //null);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.420 -0400", hash_original_field = "D9D396B299ACA9861F919FD353DAD770", hash_generated_field = "3002E75AE3CF0A743059AF685CC3B40D")

    static X9ECParametersHolder c2tnb239v1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.420 -0400", hash_original_method = "60316DB5431D45C35400220C90630B75", hash_generated_method = "8C478F45627725F59D8BDEEA675EE8F4")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1539042169 = null; //Variable for return #1
            BigInteger c2m239v1n;
            c2m239v1n = new BigInteger("2000000000000000000000000000000F4D42FFE1492A4993F1CAD666E447", 16);
            BigInteger c2m239v1h;
            c2m239v1h = BigInteger.valueOf(4);
            ECCurve c2m239v1;
            c2m239v1 = new ECCurve.F2m(
                239,
                36,
                new BigInteger("32010857077C5431123A46B808906756F543423E8D27877578125778AC76", 16),
                new BigInteger("790408F2EEDAF392B012EDEFB3392F30F4327C0CA3F31FC383C422AA8C16", 16),
                c2m239v1n, c2m239v1h);
            varB4EAC82CA7396A68D541C85D26508E83_1539042169 = new X9ECParameters(
                c2m239v1,
                c2m239v1.decodePoint(
                    Hex.decode("0257927098FA932E7C0A96D3FD5B706EF7E5F5C156E16B7E7C86038552E91D")),
                c2m239v1n, c2m239v1h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_1539042169.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1539042169;
            // ---------- Original Method ----------
            //BigInteger c2m239v1n = new BigInteger("2000000000000000000000000000000F4D42FFE1492A4993F1CAD666E447", 16);
            //BigInteger c2m239v1h = BigInteger.valueOf(4);
            //ECCurve c2m239v1 = new ECCurve.F2m(
                //239,
                //36,
                //new BigInteger("32010857077C5431123A46B808906756F543423E8D27877578125778AC76", 16),
                //new BigInteger("790408F2EEDAF392B012EDEFB3392F30F4327C0CA3F31FC383C422AA8C16", 16),
                //c2m239v1n, c2m239v1h);
            //return new X9ECParameters(
                //c2m239v1,
                //c2m239v1.decodePoint(
                    //Hex.decode("0257927098FA932E7C0A96D3FD5B706EF7E5F5C156E16B7E7C86038552E91D")),
                //c2m239v1n, c2m239v1h,
                //null);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.421 -0400", hash_original_field = "4DD98DF450B9471F9322FCCDB147B924", hash_generated_field = "F4BF48D494143EEF985FE08B37F7DC6D")

    static X9ECParametersHolder c2tnb239v2 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.421 -0400", hash_original_method = "A6B8CC34894DCE2EC726701E2F1D6053", hash_generated_method = "24B9A43880DE453A8241D84D4AF25EA1")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1850472139 = null; //Variable for return #1
            BigInteger c2m239v2n;
            c2m239v2n = new BigInteger("1555555555555555555555555555553C6F2885259C31E3FCDF154624522D", 16);
            BigInteger c2m239v2h;
            c2m239v2h = BigInteger.valueOf(6);
            ECCurve c2m239v2;
            c2m239v2 = new ECCurve.F2m(
                239,
                36,
                new BigInteger("4230017757A767FAE42398569B746325D45313AF0766266479B75654E65F", 16),
                new BigInteger("5037EA654196CFF0CD82B2C14A2FCF2E3FF8775285B545722F03EACDB74B", 16),
                c2m239v2n, c2m239v2h);
            varB4EAC82CA7396A68D541C85D26508E83_1850472139 = new X9ECParameters(
                c2m239v2,
                c2m239v2.decodePoint(
                    Hex.decode("0228F9D04E900069C8DC47A08534FE76D2B900B7D7EF31F5709F200C4CA205")),
                c2m239v2n, c2m239v2h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_1850472139.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1850472139;
            // ---------- Original Method ----------
            //BigInteger c2m239v2n = new BigInteger("1555555555555555555555555555553C6F2885259C31E3FCDF154624522D", 16);
            //BigInteger c2m239v2h = BigInteger.valueOf(6);
            //ECCurve c2m239v2 = new ECCurve.F2m(
                //239,
                //36,
                //new BigInteger("4230017757A767FAE42398569B746325D45313AF0766266479B75654E65F", 16),
                //new BigInteger("5037EA654196CFF0CD82B2C14A2FCF2E3FF8775285B545722F03EACDB74B", 16),
                //c2m239v2n, c2m239v2h);
            //return new X9ECParameters(
                //c2m239v2,
                //c2m239v2.decodePoint(
                    //Hex.decode("0228F9D04E900069C8DC47A08534FE76D2B900B7D7EF31F5709F200C4CA205")),
                //c2m239v2n, c2m239v2h,
                //null);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.434 -0400", hash_original_field = "3C7046EE4C9603219707FC7F2A99AF92", hash_generated_field = "6A20D9265436222997622D0D431B8C49")

    static X9ECParametersHolder c2tnb239v3 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.434 -0400", hash_original_method = "53AB0C170525E4DC578179F94F18E93F", hash_generated_method = "FF49EF24AFB4C617952B50E61B4CA831")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_578888025 = null; //Variable for return #1
            BigInteger c2m239v3n;
            c2m239v3n = new BigInteger("0CCCCCCCCCCCCCCCCCCCCCCCCCCCCCAC4912D2D9DF903EF9888B8A0E4CFF", 16);
            BigInteger c2m239v3h;
            c2m239v3h = BigInteger.valueOf(10);
            ECCurve c2m239v3;
            c2m239v3 = new ECCurve.F2m(
                239,
                36,
                new BigInteger("01238774666A67766D6676F778E676B66999176666E687666D8766C66A9F", 16),
                new BigInteger("6A941977BA9F6A435199ACFC51067ED587F519C5ECB541B8E44111DE1D40", 16),
                c2m239v3n, c2m239v3h);
            varB4EAC82CA7396A68D541C85D26508E83_578888025 = new X9ECParameters(
                c2m239v3,
                c2m239v3.decodePoint(
                    Hex.decode("0370F6E9D04D289C4E89913CE3530BFDE903977D42B146D539BF1BDE4E9C92")),
                c2m239v3n, c2m239v3h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_578888025.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_578888025;
            // ---------- Original Method ----------
            //BigInteger c2m239v3n = new BigInteger("0CCCCCCCCCCCCCCCCCCCCCCCCCCCCCAC4912D2D9DF903EF9888B8A0E4CFF", 16);
            //BigInteger c2m239v3h = BigInteger.valueOf(10);
            //ECCurve c2m239v3 = new ECCurve.F2m(
                //239,
                //36,
                //new BigInteger("01238774666A67766D6676F778E676B66999176666E687666D8766C66A9F", 16),
                //new BigInteger("6A941977BA9F6A435199ACFC51067ED587F519C5ECB541B8E44111DE1D40", 16),
                //c2m239v3n, c2m239v3h);
            //return new X9ECParameters(
                //c2m239v3,
                //c2m239v3.decodePoint(
                    //Hex.decode("0370F6E9D04D289C4E89913CE3530BFDE903977D42B146D539BF1BDE4E9C92")),
                //c2m239v3n, c2m239v3h,
                //null);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.435 -0400", hash_original_field = "AFE71347E3C5043EBF81C8E7BAC471B5", hash_generated_field = "ECA62E048BFB96BE11CE852A065E8F56")

    static X9ECParametersHolder c2pnb272w1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.435 -0400", hash_original_method = "B01356F226D52BFCC0B9483D8ABA264F", hash_generated_method = "3E0281C0DAEF4B76D8F65142BE5BE28C")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1623896038 = null; //Variable for return #1
            BigInteger c2m272w1n;
            c2m272w1n = new BigInteger("0100FAF51354E0E39E4892DF6E319C72C8161603FA45AA7B998A167B8F1E629521", 16);
            BigInteger c2m272w1h;
            c2m272w1h = BigInteger.valueOf(0xFF06);
            ECCurve c2m272w1;
            c2m272w1 = new ECCurve.F2m(
                272,
                1, 3, 56,
                new BigInteger("0091A091F03B5FBA4AB2CCF49C4EDD220FB028712D42BE752B2C40094DBACDB586FB20", 16),
                new BigInteger("7167EFC92BB2E3CE7C8AAAFF34E12A9C557003D7C73A6FAF003F99F6CC8482E540F7", 16),
                c2m272w1n, c2m272w1h);
            varB4EAC82CA7396A68D541C85D26508E83_1623896038 = new X9ECParameters(
                c2m272w1,
                c2m272w1.decodePoint(
                    Hex.decode("026108BABB2CEEBCF787058A056CBE0CFE622D7723A289E08A07AE13EF0D10D171DD8D")),
                c2m272w1n, c2m272w1h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_1623896038.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1623896038;
            // ---------- Original Method ----------
            //BigInteger c2m272w1n = new BigInteger("0100FAF51354E0E39E4892DF6E319C72C8161603FA45AA7B998A167B8F1E629521", 16);
            //BigInteger c2m272w1h = BigInteger.valueOf(0xFF06);
            //ECCurve c2m272w1 = new ECCurve.F2m(
                //272,
                //1, 3, 56,
                //new BigInteger("0091A091F03B5FBA4AB2CCF49C4EDD220FB028712D42BE752B2C40094DBACDB586FB20", 16),
                //new BigInteger("7167EFC92BB2E3CE7C8AAAFF34E12A9C557003D7C73A6FAF003F99F6CC8482E540F7", 16),
                //c2m272w1n, c2m272w1h);
            //return new X9ECParameters(
                //c2m272w1,
                //c2m272w1.decodePoint(
                    //Hex.decode("026108BABB2CEEBCF787058A056CBE0CFE622D7723A289E08A07AE13EF0D10D171DD8D")),
                //c2m272w1n, c2m272w1h,
                //null);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.441 -0400", hash_original_field = "AA822E02D76488BE145122B7D7E004BA", hash_generated_field = "89AE9D3F4C00BAB6A3719A3DA3886634")

    static X9ECParametersHolder c2pnb304w1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.441 -0400", hash_original_method = "8038BE8DFEA0656DF5229D989ACE6A9B", hash_generated_method = "0A47CB265AB8C191978E15AE847C2DDA")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1163965431 = null; //Variable for return #1
            BigInteger c2m304w1n;
            c2m304w1n = new BigInteger("0101D556572AABAC800101D556572AABAC8001022D5C91DD173F8FB561DA6899164443051D", 16);
            BigInteger c2m304w1h;
            c2m304w1h = BigInteger.valueOf(0xFE2E);
            ECCurve c2m304w1;
            c2m304w1 = new ECCurve.F2m(
                304,
                1, 2, 11,
                new BigInteger("00FD0D693149A118F651E6DCE6802085377E5F882D1B510B44160074C1288078365A0396C8E681", 16),
                new BigInteger("00BDDB97E555A50A908E43B01C798EA5DAA6788F1EA2794EFCF57166B8C14039601E55827340BE", 16),
                c2m304w1n, c2m304w1h);
            varB4EAC82CA7396A68D541C85D26508E83_1163965431 = new X9ECParameters(
                c2m304w1,
                c2m304w1.decodePoint(
                    Hex.decode("02197B07845E9BE2D96ADB0F5F3C7F2CFFBD7A3EB8B6FEC35C7FD67F26DDF6285A644F740A2614")),
                c2m304w1n, c2m304w1h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_1163965431.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1163965431;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.442 -0400", hash_original_field = "1CAF64C580113FDBB8D0133288A0CFC8", hash_generated_field = "95EC8D0CB6B8177653B6D5B9FB05CD7B")

    static X9ECParametersHolder c2tnb359v1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.441 -0400", hash_original_method = "37E1C92851E5B505F7DF10263E7B6314", hash_generated_method = "4470BB85C23EF1E790F1EC6F66F50F96")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_979766719 = null; //Variable for return #1
            BigInteger c2m359v1n;
            c2m359v1n = new BigInteger("01AF286BCA1AF286BCA1AF286BCA1AF286BCA1AF286BC9FB8F6B85C556892C20A7EB964FE7719E74F490758D3B", 16);
            BigInteger c2m359v1h;
            c2m359v1h = BigInteger.valueOf(0x4C);
            ECCurve c2m359v1;
            c2m359v1 = new ECCurve.F2m(
                359,
                68,
                new BigInteger("5667676A654B20754F356EA92017D946567C46675556F19556A04616B567D223A5E05656FB549016A96656A557", 16),
                new BigInteger("2472E2D0197C49363F1FE7F5B6DB075D52B6947D135D8CA445805D39BC345626089687742B6329E70680231988", 16),
                c2m359v1n, c2m359v1h);
            varB4EAC82CA7396A68D541C85D26508E83_979766719 = new X9ECParameters(
                c2m359v1,
                c2m359v1.decodePoint(
                    Hex.decode("033C258EF3047767E7EDE0F1FDAA79DAEE3841366A132E163ACED4ED2401DF9C6BDCDE98E8E707C07A2239B1B097")),
                c2m359v1n, c2m359v1h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_979766719.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_979766719;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.443 -0400", hash_original_field = "100B766372195305519A4C0F3F8D45C2", hash_generated_field = "4CA6FFDB669170E5B9E7E3AE3D1A69E4")

    static X9ECParametersHolder c2pnb368w1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.443 -0400", hash_original_method = "D2533E347D1C5A2B3F7557F91A52306F", hash_generated_method = "C327FAE2600E01D8D4580DCBA3BC17FE")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_680279933 = null; //Variable for return #1
            BigInteger c2m368w1n;
            c2m368w1n = new BigInteger("010090512DA9AF72B08349D98A5DD4C7B0532ECA51CE03E2D10F3B7AC579BD87E909AE40A6F131E9CFCE5BD967", 16);
            BigInteger c2m368w1h;
            c2m368w1h = BigInteger.valueOf(0xFF70);
            ECCurve c2m368w1;
            c2m368w1 = new ECCurve.F2m(
                368,
                1, 2, 85,
                new BigInteger("00E0D2EE25095206F5E2A4F9ED229F1F256E79A0E2B455970D8D0D865BD94778C576D62F0AB7519CCD2A1A906AE30D", 16),
                new BigInteger("00FC1217D4320A90452C760A58EDCD30C8DD069B3C34453837A34ED50CB54917E1C2112D84D164F444F8F74786046A", 16),
                c2m368w1n, c2m368w1h);
            varB4EAC82CA7396A68D541C85D26508E83_680279933 = new X9ECParameters(
                c2m368w1,
                c2m368w1.decodePoint(
                    Hex.decode("021085E2755381DCCCE3C1557AFA10C2F0C0C2825646C5B34A394CBCFA8BC16B22E7E789E927BE216F02E1FB136A5F")),
                c2m368w1n, c2m368w1h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_680279933.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_680279933;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.453 -0400", hash_original_field = "CA3A82BCA0630C34CB91F7708F08801D", hash_generated_field = "8CE20ED5200CD4F205CEB112C92E926C")

    static X9ECParametersHolder c2tnb431r1 = new X9ECParametersHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.453 -0400", hash_original_method = "31E7BABE5A14818323F258FB48AD168E", hash_generated_method = "3DFC1975B7BFAED5B5387247B8F8D9F2")
        protected X9ECParameters createParameters() {
            X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_1447880265 = null; //Variable for return #1
            BigInteger c2m431r1n;
            c2m431r1n = new BigInteger("0340340340340340340340340340340340340340340340340340340323C313FAB50589703B5EC68D3587FEC60D161CC149C1AD4A91", 16);
            BigInteger c2m431r1h;
            c2m431r1h = BigInteger.valueOf(0x2760);
            ECCurve c2m431r1;
            c2m431r1 = new ECCurve.F2m(
                431,
                120,
                new BigInteger("1A827EF00DD6FC0E234CAF046C6A5D8A85395B236CC4AD2CF32A0CADBDC9DDF620B0EB9906D0957F6C6FEACD615468DF104DE296CD8F", 16),
                new BigInteger("10D9B4A3D9047D8B154359ABFB1B7F5485B04CEB868237DDC9DEDA982A679A5A919B626D4E50A8DD731B107A9962381FB5D807BF2618", 16),
                c2m431r1n, c2m431r1h);
            varB4EAC82CA7396A68D541C85D26508E83_1447880265 = new X9ECParameters(
                c2m431r1,
                c2m431r1.decodePoint(
                    Hex.decode("02120FC05D3C67A99DE161D2F4092622FECA701BE4F50F4758714E8A87BBF2A658EF8C21E7C5EFE965361F6C2999C0C247B0DBD70CE6B7")),
                c2m431r1n, c2m431r1h,
                null);
            varB4EAC82CA7396A68D541C85D26508E83_1447880265.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1447880265;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.454 -0400", hash_original_field = "09196982C4917B07F992CCE003F1710F", hash_generated_field = "1169508D6249D74AF50B49E4347C0169")

    static Hashtable objIds = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.454 -0400", hash_original_field = "53A355950F48EB163EF1F9185C63BB74", hash_generated_field = "B652C3916C4B0B27A1AED979DB01CCBF")

    static Hashtable curves = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.455 -0400", hash_original_field = "E70BACFD70C0C66E2A0FC643AF5696C0", hash_generated_field = "BBC73B5D5E92CE9D193A9A8C606FBC8E")

    static Hashtable names = new Hashtable();
    static {
        defineCurve("prime192v1", X9ObjectIdentifiers.prime192v1, prime192v1);
        defineCurve("prime192v2", X9ObjectIdentifiers.prime192v2, prime192v2);
        defineCurve("prime192v3", X9ObjectIdentifiers.prime192v3, prime192v3);
        defineCurve("prime239v1", X9ObjectIdentifiers.prime239v1, prime239v1);
        defineCurve("prime239v2", X9ObjectIdentifiers.prime239v2, prime239v2);
        defineCurve("prime239v3", X9ObjectIdentifiers.prime239v3, prime239v3);
        defineCurve("prime256v1", X9ObjectIdentifiers.prime256v1, prime256v1);
        defineCurve("c2pnb163v1", X9ObjectIdentifiers.c2pnb163v1, c2pnb163v1);
        defineCurve("c2pnb163v2", X9ObjectIdentifiers.c2pnb163v2, c2pnb163v2);
        defineCurve("c2pnb163v3", X9ObjectIdentifiers.c2pnb163v3, c2pnb163v3);
        defineCurve("c2pnb176w1", X9ObjectIdentifiers.c2pnb176w1, c2pnb176w1);
        defineCurve("c2tnb191v1", X9ObjectIdentifiers.c2tnb191v1, c2tnb191v1);
        defineCurve("c2tnb191v2", X9ObjectIdentifiers.c2tnb191v2, c2tnb191v2);
        defineCurve("c2tnb191v3", X9ObjectIdentifiers.c2tnb191v3, c2tnb191v3);
        defineCurve("c2pnb208w1", X9ObjectIdentifiers.c2pnb208w1, c2pnb208w1);
        defineCurve("c2tnb239v1", X9ObjectIdentifiers.c2tnb239v1, c2tnb239v1);
        defineCurve("c2tnb239v2", X9ObjectIdentifiers.c2tnb239v2, c2tnb239v2);
        defineCurve("c2tnb239v3", X9ObjectIdentifiers.c2tnb239v3, c2tnb239v3);
        defineCurve("c2pnb272w1", X9ObjectIdentifiers.c2pnb272w1, c2pnb272w1);
        defineCurve("c2pnb304w1", X9ObjectIdentifiers.c2pnb304w1, c2pnb304w1);
        defineCurve("c2tnb359v1", X9ObjectIdentifiers.c2tnb359v1, c2tnb359v1);
        defineCurve("c2pnb368w1", X9ObjectIdentifiers.c2pnb368w1, c2pnb368w1);
        defineCurve("c2tnb431r1", X9ObjectIdentifiers.c2tnb431r1, c2tnb431r1);
    }
    
}

