package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class Phonenumber {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.682 -0400", hash_original_method = "9F0C69719EBF6B458992D61E4BCC90E8", hash_generated_method = "5CB1D98A4150FC5519010EC189B4C107")
    private  Phonenumber() {
        // ---------- Original Method ----------
    }

    
    public static class PhoneNumber implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "8DA9382CFAB6A2934FA5AD3C46617F89", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

        private boolean hasCountryCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "3461D01D5A7F32E3FA9B229113397711", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

        private int countryCode_ = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "BEF2FB3011A67ABE2750EE20B94BCF1B", hash_generated_field = "B31B8035F727A8BE2916E64EBF4F38BF")

        private boolean hasNationalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "2FE6622A7CBF4A37DA0EE3F97AFD3C1A", hash_generated_field = "861F5C609F3E4BA70615CE11EE4F3E7C")

        private long nationalNumber_ = 0L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "E8BF8AD5CF623306E4137F929A4B793C", hash_generated_field = "358E6375D13B5162BE1A3016216C10C6")

        private boolean hasExtension;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "BABEC9AFE089768EADBB1770DB6C73E0", hash_generated_field = "6640D7D6CB57D7D20313E3325CD1FB22")

        private java.lang.String extension_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "9A3A483658C79E793F495FF31A1A2719", hash_generated_field = "3F85D89FA25AF2B45530E00802BDAF23")

        private boolean hasItalianLeadingZero;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "BA6B94B60539B119EFEF2AF2F66C2C0F", hash_generated_field = "D7F0554114A7FE26069B675ED8151AC1")

        private boolean italianLeadingZero_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "E04C31A797660EF69743A4E81B09F98E", hash_generated_field = "C4DB1F876DD23BC8A14CC9C5A337EE0B")

        private boolean hasRawInput;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "DA7C30298E9E640F6E99799BCA546A44", hash_generated_field = "1CA91139B304F5C069E8FEFEEC7BDADA")

        private String rawInput_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "AF071B11070C28DD45E4F04A2EAC9FD9", hash_generated_field = "F0FD53E6932AA94BEF89B80DE8FBB48A")

        private boolean hasCountryCodeSource;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "15078F02FD915A57AC4033865D7BD527", hash_generated_field = "726423546266BF59E9D4D30E8DF8603B")

        private CountryCodeSource countryCodeSource_;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "875F08A1E2A43A5348B38BFC578F2335", hash_generated_field = "7A3961A3D14D61159606E8AEE7AE90AE")

        private boolean hasPreferredDomesticCarrierCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_field = "2939A13320742DC344097CB116D7C987", hash_generated_field = "30C4AF8975E517B81211F0AB34A0B954")

        private java.lang.String preferredDomesticCarrierCode_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.683 -0400", hash_original_method = "BC3E0739FB67F4B1E9E07E3377CC422E", hash_generated_method = "82E1ACB1E508CA9B7F2766C0989401DD")
        public  PhoneNumber() {
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            // ---------- Original Method ----------
            //countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.684 -0400", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "D842139FCCB227DC6981C3CBC64355CB")
        public boolean hasCountryCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1150394356 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1150394356;
            // ---------- Original Method ----------
            //return hasCountryCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.684 -0400", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "33C75CC457B7E000C034CD3E4F3AD346")
        public int getCountryCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263744956 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263744956;
            // ---------- Original Method ----------
            //return countryCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.691 -0400", hash_original_method = "231BDC2ACAA546410AD99483D572C314", hash_generated_method = "AE9F17D7AB03338262FDB6DE78ECF4F5")
        public PhoneNumber setCountryCode(int value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_221206813 = null; //Variable for return #1
            hasCountryCode = true;
            countryCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_221206813 = this;
            varB4EAC82CA7396A68D541C85D26508E83_221206813.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_221206813;
            // ---------- Original Method ----------
            //hasCountryCode = true;
            //countryCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.691 -0400", hash_original_method = "F3480C339E6576F38870C4A8107DC432", hash_generated_method = "1C915943D78AC8BC08FFEB6C812F76D0")
        public PhoneNumber clearCountryCode() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1391336280 = null; //Variable for return #1
            hasCountryCode = false;
            countryCode_ = 0;
            varB4EAC82CA7396A68D541C85D26508E83_1391336280 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1391336280.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1391336280;
            // ---------- Original Method ----------
            //hasCountryCode = false;
            //countryCode_ = 0;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.692 -0400", hash_original_method = "9E5DD8721DB5E6B4EA37D3D3DF3C82B6", hash_generated_method = "6676611D5A77CD17BD21C8A41B99301A")
        public boolean hasNationalNumber() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518991760 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518991760;
            // ---------- Original Method ----------
            //return hasNationalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.692 -0400", hash_original_method = "6637472029560B21624D3926379C2007", hash_generated_method = "94B073D0221885E108C7942CC419D04D")
        public long getNationalNumber() {
            long var0F5264038205EDFB1AC05FBB0E8C5E94_658784122 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_658784122;
            // ---------- Original Method ----------
            //return nationalNumber_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.692 -0400", hash_original_method = "6A535B2D70F0F9B1A2B7BD33E2B75251", hash_generated_method = "30DCB01CF7CE026C6978B27607AB5481")
        public PhoneNumber setNationalNumber(long value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_2059192464 = null; //Variable for return #1
            hasNationalNumber = true;
            nationalNumber_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_2059192464 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2059192464.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2059192464;
            // ---------- Original Method ----------
            //hasNationalNumber = true;
            //nationalNumber_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.696 -0400", hash_original_method = "805285A190D17B224561E5C065A4AB00", hash_generated_method = "E10F093EA3A13145C42627F9E9465E99")
        public PhoneNumber clearNationalNumber() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1938355261 = null; //Variable for return #1
            hasNationalNumber = false;
            nationalNumber_ = 0L;
            varB4EAC82CA7396A68D541C85D26508E83_1938355261 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1938355261.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1938355261;
            // ---------- Original Method ----------
            //hasNationalNumber = false;
            //nationalNumber_ = 0L;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.696 -0400", hash_original_method = "66338EE760653FB7826716BD4179F0EB", hash_generated_method = "EF850D5AD9FB75EBF5419819BCBA1123")
        public boolean hasExtension() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633897721 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_633897721;
            // ---------- Original Method ----------
            //return hasExtension;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.696 -0400", hash_original_method = "F04D3A8DBD1CCF0248A759BF39EDDDEC", hash_generated_method = "5F105A7BF820D2A70C9A29987332BBE7")
        public String getExtension() {
            String varB4EAC82CA7396A68D541C85D26508E83_1761526187 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1761526187 = extension_;
            varB4EAC82CA7396A68D541C85D26508E83_1761526187.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1761526187;
            // ---------- Original Method ----------
            //return extension_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.745 -0400", hash_original_method = "38A692624EA50F65C5AAF1C27A4F1E79", hash_generated_method = "CB074B36E6B0BB7AF3D676DA8731DA74")
        public PhoneNumber setExtension(String value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1378795651 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasExtension = true;
            extension_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1378795651 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1378795651.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1378795651;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasExtension = true;
            //extension_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.746 -0400", hash_original_method = "831C8D6965C7D5091D9400B8A1911F63", hash_generated_method = "6822186E2295850E05021657FC8A6799")
        public PhoneNumber clearExtension() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1304347920 = null; //Variable for return #1
            hasExtension = false;
            extension_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_1304347920 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1304347920.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1304347920;
            // ---------- Original Method ----------
            //hasExtension = false;
            //extension_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.746 -0400", hash_original_method = "297A117AFD1E548B3AE9E987C5DEDB53", hash_generated_method = "A28B2E2524315BC4EA5168D4875E00D4")
        public boolean hasItalianLeadingZero() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_232406177 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_232406177;
            // ---------- Original Method ----------
            //return hasItalianLeadingZero;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.747 -0400", hash_original_method = "B0BA7A66148037C7B1A35A6061ECB1A6", hash_generated_method = "2765D53DABCD527FB4BD7348AA0DCCFE")
        public boolean isItalianLeadingZero() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632971824 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_632971824;
            // ---------- Original Method ----------
            //return italianLeadingZero_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.747 -0400", hash_original_method = "5FB07870F4A15DEE8F66E77590B141DD", hash_generated_method = "8185FE8116593B781424E80B7A93DF93")
        public PhoneNumber setItalianLeadingZero(boolean value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_69452739 = null; //Variable for return #1
            hasItalianLeadingZero = true;
            italianLeadingZero_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_69452739 = this;
            varB4EAC82CA7396A68D541C85D26508E83_69452739.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_69452739;
            // ---------- Original Method ----------
            //hasItalianLeadingZero = true;
            //italianLeadingZero_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.752 -0400", hash_original_method = "55D33A5E10AF87EF82FB6277592BFD48", hash_generated_method = "736308D21B98709A5843CE8805DFF34D")
        public PhoneNumber clearItalianLeadingZero() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1804234609 = null; //Variable for return #1
            hasItalianLeadingZero = false;
            italianLeadingZero_ = false;
            varB4EAC82CA7396A68D541C85D26508E83_1804234609 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1804234609.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1804234609;
            // ---------- Original Method ----------
            //hasItalianLeadingZero = false;
            //italianLeadingZero_ = false;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.753 -0400", hash_original_method = "FC01A3A255BE4F11BA51CD36FFDCBB37", hash_generated_method = "E43C080E178F67BDFB79E26B3A8C56AA")
        public boolean hasRawInput() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325741204 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325741204;
            // ---------- Original Method ----------
            //return hasRawInput;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.753 -0400", hash_original_method = "F6017E34CFBABE539ED487A19641D13D", hash_generated_method = "5154E595C9B4A24EC1FDB173E2ACB0DF")
        public String getRawInput() {
            String varB4EAC82CA7396A68D541C85D26508E83_950096035 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_950096035 = rawInput_;
            varB4EAC82CA7396A68D541C85D26508E83_950096035.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_950096035;
            // ---------- Original Method ----------
            //return rawInput_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.754 -0400", hash_original_method = "1DF89DBF221798F84EE73F6641D85CA9", hash_generated_method = "32F60B9FF722E89DAC0DBB8442005BE7")
        public PhoneNumber setRawInput(String value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1203259502 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasRawInput = true;
            rawInput_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1203259502 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1203259502.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1203259502;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasRawInput = true;
            //rawInput_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.755 -0400", hash_original_method = "090A68BA48513AA6167B14B8C7E5B538", hash_generated_method = "0E4BBD6EA987C769BDC8E2F4ACC9D1C9")
        public PhoneNumber clearRawInput() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1473103929 = null; //Variable for return #1
            hasRawInput = false;
            rawInput_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_1473103929 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1473103929.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1473103929;
            // ---------- Original Method ----------
            //hasRawInput = false;
            //rawInput_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.782 -0400", hash_original_method = "49E6B213C7CF699A88721EC66ED6A85C", hash_generated_method = "A9F987F33416ECCD9589ACC468C89E09")
        public boolean hasCountryCodeSource() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1173861875 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1173861875;
            // ---------- Original Method ----------
            //return hasCountryCodeSource;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.782 -0400", hash_original_method = "EC13D38EB752707A5D37EF84821B18F3", hash_generated_method = "784295A40551BE2DE3F941CA2D18944D")
        public CountryCodeSource getCountryCodeSource() {
            CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_1657940987 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1657940987 = countryCodeSource_;
            varB4EAC82CA7396A68D541C85D26508E83_1657940987.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1657940987;
            // ---------- Original Method ----------
            //return countryCodeSource_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.783 -0400", hash_original_method = "4C681F77FE4C34506AE7929BB9F5DB5B", hash_generated_method = "D1DA2B3F02FF1612E91F0678C8AC71A2")
        public PhoneNumber setCountryCodeSource(CountryCodeSource value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_423589727 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasCountryCodeSource = true;
            countryCodeSource_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_423589727 = this;
            varB4EAC82CA7396A68D541C85D26508E83_423589727.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_423589727;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasCountryCodeSource = true;
            //countryCodeSource_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.805 -0400", hash_original_method = "AD210C1FCCDAAC9D9B6A95A61CE920CC", hash_generated_method = "4D6093429B0A272316A1A7E85BFC38DC")
        public PhoneNumber clearCountryCodeSource() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_704550023 = null; //Variable for return #1
            hasCountryCodeSource = false;
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            varB4EAC82CA7396A68D541C85D26508E83_704550023 = this;
            varB4EAC82CA7396A68D541C85D26508E83_704550023.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_704550023;
            // ---------- Original Method ----------
            //hasCountryCodeSource = false;
            //countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.806 -0400", hash_original_method = "8350C830C26B7D092EEEE9A503A10DA0", hash_generated_method = "FE0E6277AA562F671F08EB3EF48269E0")
        public boolean hasPreferredDomesticCarrierCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_3995684 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_3995684;
            // ---------- Original Method ----------
            //return hasPreferredDomesticCarrierCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.806 -0400", hash_original_method = "47CB8521CF67D388DB30B3F811726252", hash_generated_method = "06171EFEC12C1B87218495868E321107")
        public String getPreferredDomesticCarrierCode() {
            String varB4EAC82CA7396A68D541C85D26508E83_1775380054 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1775380054 = preferredDomesticCarrierCode_;
            varB4EAC82CA7396A68D541C85D26508E83_1775380054.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1775380054;
            // ---------- Original Method ----------
            //return preferredDomesticCarrierCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.807 -0400", hash_original_method = "41BB5D81F1B0279F583403646A2042B9", hash_generated_method = "DAC3A81A197C3BEF23B9595020C8A806")
        public PhoneNumber setPreferredDomesticCarrierCode(String value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_730234933 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPreferredDomesticCarrierCode = true;
            preferredDomesticCarrierCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_730234933 = this;
            varB4EAC82CA7396A68D541C85D26508E83_730234933.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_730234933;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPreferredDomesticCarrierCode = true;
            //preferredDomesticCarrierCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.807 -0400", hash_original_method = "26AD27D6AD8CEDC77B768F25CC124964", hash_generated_method = "7731B0D5A665AC719B1AE0A837DA3430")
        public PhoneNumber clearPreferredDomesticCarrierCode() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1328978403 = null; //Variable for return #1
            hasPreferredDomesticCarrierCode = false;
            preferredDomesticCarrierCode_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_1328978403 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1328978403.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1328978403;
            // ---------- Original Method ----------
            //hasPreferredDomesticCarrierCode = false;
            //preferredDomesticCarrierCode_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.830 -0400", hash_original_method = "9E3F334A53F42C22EC58969EE12FFC06", hash_generated_method = "0A639299F60365E728A10C19F7EF63C9")
        public final PhoneNumber clear() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1657648497 = null; //Variable for return #1
            clearCountryCode();
            clearNationalNumber();
            clearExtension();
            clearItalianLeadingZero();
            clearRawInput();
            clearCountryCodeSource();
            clearPreferredDomesticCarrierCode();
            varB4EAC82CA7396A68D541C85D26508E83_1657648497 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1657648497.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1657648497;
            // ---------- Original Method ----------
            //clearCountryCode();
            //clearNationalNumber();
            //clearExtension();
            //clearItalianLeadingZero();
            //clearRawInput();
            //clearCountryCodeSource();
            //clearPreferredDomesticCarrierCode();
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.832 -0400", hash_original_method = "0AFF34EE20E5281E0E8704C233C4A6C7", hash_generated_method = "41C2735DF54DBA967DBF7615CE4CAB6F")
        public PhoneNumber mergeFrom(PhoneNumber other) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1758937151 = null; //Variable for return #1
            {
                boolean var7E81CBAAB3EA7600B5C349844A3DA67F_641444609 = (other.hasCountryCode());
                {
                    setCountryCode(other.getCountryCode());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2052D51723D6CFDD0C32171C1669744A_868851848 = (other.hasNationalNumber());
                {
                    setNationalNumber(other.getNationalNumber());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var3D50C0940F659491C98DC4B316490D2B_1331192707 = (other.hasExtension());
                {
                    setExtension(other.getExtension());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varA9932682E4C7BD97414CE18901A431BF_1378657586 = (other.hasItalianLeadingZero());
                {
                    setItalianLeadingZero(other.isItalianLeadingZero());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF5BDCCDF0CF842993D0F90518AD8B0B1_968156357 = (other.hasRawInput());
                {
                    setRawInput(other.getRawInput());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var035EFCDC910421918C6321C968D446C6_644765832 = (other.hasCountryCodeSource());
                {
                    setCountryCodeSource(other.getCountryCodeSource());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBC066E2F7D27AB4E6EB4E9344D3B9AFA_1535498438 = (other.hasPreferredDomesticCarrierCode());
                {
                    setPreferredDomesticCarrierCode(other.getPreferredDomesticCarrierCode());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1758937151 = this;
            addTaint(other.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1758937151.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1758937151;
            // ---------- Original Method ----------
            //if (other.hasCountryCode()) {
        //setCountryCode(other.getCountryCode());
      //}
            //if (other.hasNationalNumber()) {
        //setNationalNumber(other.getNationalNumber());
      //}
            //if (other.hasExtension()) {
        //setExtension(other.getExtension());
      //}
            //if (other.hasItalianLeadingZero()) {
        //setItalianLeadingZero(other.isItalianLeadingZero());
      //}
            //if (other.hasRawInput()) {
        //setRawInput(other.getRawInput());
      //}
            //if (other.hasCountryCodeSource()) {
        //setCountryCodeSource(other.getCountryCodeSource());
      //}
            //if (other.hasPreferredDomesticCarrierCode()) {
        //setPreferredDomesticCarrierCode(other.getPreferredDomesticCarrierCode());
      //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.832 -0400", hash_original_method = "DE1C4B1DD2D8C57C4042DF1B529C7D4D", hash_generated_method = "D2DD460BE3C0515C5DBA8F515FF75FCB")
        public boolean exactlySameAs(PhoneNumber other) {
            boolean var4EB77A9CEDB1032569C973613A9313C9_1699396207 = ((countryCode_ == other.countryCode_ && nationalNumber_ == other.nationalNumber_ &&
          extension_.equals(other.extension_) && italianLeadingZero_ == other.italianLeadingZero_ &&
          rawInput_.equals(other.rawInput_) && countryCodeSource_ == other.countryCodeSource_ &&
          preferredDomesticCarrierCode_.equals(other.preferredDomesticCarrierCode_) &&
          hasPreferredDomesticCarrierCode() == other.hasPreferredDomesticCarrierCode()));
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938312313 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_938312313;
            // ---------- Original Method ----------
            //if (other == null) {
        //return false;
      //}
            //if (this == other) {
        //return true;
      //}
            //return (countryCode_ == other.countryCode_ && nationalNumber_ == other.nationalNumber_ &&
          //extension_.equals(other.extension_) && italianLeadingZero_ == other.italianLeadingZero_ &&
          //rawInput_.equals(other.rawInput_) && countryCodeSource_ == other.countryCodeSource_ &&
          //preferredDomesticCarrierCode_.equals(other.preferredDomesticCarrierCode_) &&
          //hasPreferredDomesticCarrierCode() == other.hasPreferredDomesticCarrierCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.832 -0400", hash_original_method = "EF0E3A387E8AEF6EC396B951EC1536A9", hash_generated_method = "6379B0CD47A7BEE6A178E843F7BA23BC")
        @Override
        public boolean equals(Object that) {
            boolean var739237D2BDA3D224DE7CFFAAA4A6064B_1929221630 = ((that instanceof PhoneNumber) && exactlySameAs((PhoneNumber) that));
            addTaint(that.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514197752 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_514197752;
            // ---------- Original Method ----------
            //return (that instanceof PhoneNumber) && exactlySameAs((PhoneNumber) that);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.834 -0400", hash_original_method = "F1BB2EE5D9E77C138CA0D6B9F17756FB", hash_generated_method = "B015B36BE713C877FE36F738C22585C2")
        @Override
        public int hashCode() {
            int hash;
            hash = 41;
            hash = (53 * hash) + getCountryCode();
            hash = (53 * hash) + Long.valueOf(getNationalNumber()).hashCode();
            hash = (53 * hash) + getExtension().hashCode();
            hash = (53 * hash) + (isItalianLeadingZero() ? 1231 : 1237);
            hash = (53 * hash) + getRawInput().hashCode();
            hash = (53 * hash) + getCountryCodeSource().hashCode();
            hash = (53 * hash) + getPreferredDomesticCarrierCode().hashCode();
            hash = (53 * hash) + (hasPreferredDomesticCarrierCode() ? 1231 : 1237);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1262494452 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1262494452;
            // ---------- Original Method ----------
            //int hash = 41;
            //hash = (53 * hash) + getCountryCode();
            //hash = (53 * hash) + Long.valueOf(getNationalNumber()).hashCode();
            //hash = (53 * hash) + getExtension().hashCode();
            //hash = (53 * hash) + (isItalianLeadingZero() ? 1231 : 1237);
            //hash = (53 * hash) + getRawInput().hashCode();
            //hash = (53 * hash) + getCountryCodeSource().hashCode();
            //hash = (53 * hash) + getPreferredDomesticCarrierCode().hashCode();
            //hash = (53 * hash) + (hasPreferredDomesticCarrierCode() ? 1231 : 1237);
            //return hash;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.847 -0400", hash_original_method = "16D1E3F084AA1063C11CF7C5BDA5DD45", hash_generated_method = "7B5AC30B5B994EF5BC7087F029C8F56E")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_175315363 = null; //Variable for return #1
            StringBuilder outputString;
            outputString = new StringBuilder();
            outputString.append("Country Code: ").append(countryCode_);
            outputString.append(" National Number: ").append(nationalNumber_);
            {
                boolean varAC928743AA4361941C966832DF776A7B_1517130222 = (hasItalianLeadingZero() && isItalianLeadingZero());
                {
                    outputString.append(" Leading Zero: true");
                } //End block
            } //End collapsed parenthetic
            {
                boolean var1430D110BD7C50E7B13612C95695845D_1002640930 = (hasExtension());
                {
                    outputString.append(" Extension: ").append(extension_);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2412B064642DAAEC43954205576731D7_628848149 = (hasCountryCodeSource());
                {
                    outputString.append(" Country Code Source: ").append(countryCodeSource_);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var647279AD14B7D4C5032BD55F39D3D3A8_1764876885 = (hasPreferredDomesticCarrierCode());
                {
                    outputString.append(" Preferred Domestic Carrier Code: ").
            append(preferredDomesticCarrierCode_);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_175315363 = outputString.toString();
            varB4EAC82CA7396A68D541C85D26508E83_175315363.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_175315363;
            // ---------- Original Method ----------
            //StringBuilder outputString = new StringBuilder();
            //outputString.append("Country Code: ").append(countryCode_);
            //outputString.append(" National Number: ").append(nationalNumber_);
            //if (hasItalianLeadingZero() && isItalianLeadingZero()) {
        //outputString.append(" Leading Zero: true");
      //}
            //if (hasExtension()) {
        //outputString.append(" Extension: ").append(extension_);
      //}
            //if (hasCountryCodeSource()) {
        //outputString.append(" Country Code Source: ").append(countryCodeSource_);
      //}
            //if (hasPreferredDomesticCarrierCode()) {
        //outputString.append(" Preferred Domestic Carrier Code: ").
            //append(preferredDomesticCarrierCode_);
      //}
            //return outputString.toString();
        }

        
        public enum CountryCodeSource {
      FROM_NUMBER_WITH_PLUS_SIGN,
      FROM_NUMBER_WITH_IDD,
      FROM_NUMBER_WITHOUT_PLUS_SIGN,
      FROM_DEFAULT_COUNTRY
    }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.847 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

        private static long serialVersionUID = 1L;
    }


    
}

