package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class Phonenumber {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.323 -0400", hash_original_method = "9F0C69719EBF6B458992D61E4BCC90E8", hash_generated_method = "5CB1D98A4150FC5519010EC189B4C107")
    private  Phonenumber() {
        // ---------- Original Method ----------
    }

    
    public static class PhoneNumber implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.324 -0400", hash_original_field = "8DA9382CFAB6A2934FA5AD3C46617F89", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

        private boolean hasCountryCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.332 -0400", hash_original_field = "3461D01D5A7F32E3FA9B229113397711", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

        private int countryCode_ = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.332 -0400", hash_original_field = "BEF2FB3011A67ABE2750EE20B94BCF1B", hash_generated_field = "B31B8035F727A8BE2916E64EBF4F38BF")

        private boolean hasNationalNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.332 -0400", hash_original_field = "2FE6622A7CBF4A37DA0EE3F97AFD3C1A", hash_generated_field = "861F5C609F3E4BA70615CE11EE4F3E7C")

        private long nationalNumber_ = 0L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.332 -0400", hash_original_field = "E8BF8AD5CF623306E4137F929A4B793C", hash_generated_field = "358E6375D13B5162BE1A3016216C10C6")

        private boolean hasExtension;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.332 -0400", hash_original_field = "BABEC9AFE089768EADBB1770DB6C73E0", hash_generated_field = "6640D7D6CB57D7D20313E3325CD1FB22")

        private java.lang.String extension_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.332 -0400", hash_original_field = "9A3A483658C79E793F495FF31A1A2719", hash_generated_field = "3F85D89FA25AF2B45530E00802BDAF23")

        private boolean hasItalianLeadingZero;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.332 -0400", hash_original_field = "BA6B94B60539B119EFEF2AF2F66C2C0F", hash_generated_field = "D7F0554114A7FE26069B675ED8151AC1")

        private boolean italianLeadingZero_ = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.332 -0400", hash_original_field = "E04C31A797660EF69743A4E81B09F98E", hash_generated_field = "C4DB1F876DD23BC8A14CC9C5A337EE0B")

        private boolean hasRawInput;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.332 -0400", hash_original_field = "DA7C30298E9E640F6E99799BCA546A44", hash_generated_field = "1CA91139B304F5C069E8FEFEEC7BDADA")

        private String rawInput_ = "";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.333 -0400", hash_original_field = "AF071B11070C28DD45E4F04A2EAC9FD9", hash_generated_field = "F0FD53E6932AA94BEF89B80DE8FBB48A")

        private boolean hasCountryCodeSource;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.333 -0400", hash_original_field = "15078F02FD915A57AC4033865D7BD527", hash_generated_field = "726423546266BF59E9D4D30E8DF8603B")

        private CountryCodeSource countryCodeSource_;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.333 -0400", hash_original_field = "875F08A1E2A43A5348B38BFC578F2335", hash_generated_field = "7A3961A3D14D61159606E8AEE7AE90AE")

        private boolean hasPreferredDomesticCarrierCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.333 -0400", hash_original_field = "2939A13320742DC344097CB116D7C987", hash_generated_field = "30C4AF8975E517B81211F0AB34A0B954")

        private java.lang.String preferredDomesticCarrierCode_ = "";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.333 -0400", hash_original_method = "BC3E0739FB67F4B1E9E07E3377CC422E", hash_generated_method = "82E1ACB1E508CA9B7F2766C0989401DD")
        public  PhoneNumber() {
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            // ---------- Original Method ----------
            //countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.353 -0400", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "4B33FBEE9B77495906182373B57BAA06")
        public boolean hasCountryCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835810637 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835810637;
            // ---------- Original Method ----------
            //return hasCountryCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.354 -0400", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "1F282AA07939BFB08063BC25C282E3E2")
        public int getCountryCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596083367 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596083367;
            // ---------- Original Method ----------
            //return countryCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.354 -0400", hash_original_method = "231BDC2ACAA546410AD99483D572C314", hash_generated_method = "53E9266F0B73DAF581F2F3AE29B09F4A")
        public PhoneNumber setCountryCode(int value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_964165344 = null; //Variable for return #1
            hasCountryCode = true;
            countryCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_964165344 = this;
            varB4EAC82CA7396A68D541C85D26508E83_964165344.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_964165344;
            // ---------- Original Method ----------
            //hasCountryCode = true;
            //countryCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.355 -0400", hash_original_method = "F3480C339E6576F38870C4A8107DC432", hash_generated_method = "011EE636A63A2E12D5515A459A479B34")
        public PhoneNumber clearCountryCode() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_481353078 = null; //Variable for return #1
            hasCountryCode = false;
            countryCode_ = 0;
            varB4EAC82CA7396A68D541C85D26508E83_481353078 = this;
            varB4EAC82CA7396A68D541C85D26508E83_481353078.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_481353078;
            // ---------- Original Method ----------
            //hasCountryCode = false;
            //countryCode_ = 0;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.355 -0400", hash_original_method = "9E5DD8721DB5E6B4EA37D3D3DF3C82B6", hash_generated_method = "9E829767728B6F9959FF72C69D9075C1")
        public boolean hasNationalNumber() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873560257 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_873560257;
            // ---------- Original Method ----------
            //return hasNationalNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.355 -0400", hash_original_method = "6637472029560B21624D3926379C2007", hash_generated_method = "CB3798850CF006C51788A9D3A901B0AF")
        public long getNationalNumber() {
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1106301750 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1106301750;
            // ---------- Original Method ----------
            //return nationalNumber_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.356 -0400", hash_original_method = "6A535B2D70F0F9B1A2B7BD33E2B75251", hash_generated_method = "A17D2C59AC82E55BFEE72E3D3ABBE2AF")
        public PhoneNumber setNationalNumber(long value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1478830585 = null; //Variable for return #1
            hasNationalNumber = true;
            nationalNumber_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1478830585 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1478830585.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1478830585;
            // ---------- Original Method ----------
            //hasNationalNumber = true;
            //nationalNumber_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.356 -0400", hash_original_method = "805285A190D17B224561E5C065A4AB00", hash_generated_method = "C0B091A4FADA243276F067CE92F46200")
        public PhoneNumber clearNationalNumber() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_2011362388 = null; //Variable for return #1
            hasNationalNumber = false;
            nationalNumber_ = 0L;
            varB4EAC82CA7396A68D541C85D26508E83_2011362388 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2011362388.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2011362388;
            // ---------- Original Method ----------
            //hasNationalNumber = false;
            //nationalNumber_ = 0L;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.358 -0400", hash_original_method = "66338EE760653FB7826716BD4179F0EB", hash_generated_method = "5F4E8A4D6A90D06155DAA0A3010652AA")
        public boolean hasExtension() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822458612 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_822458612;
            // ---------- Original Method ----------
            //return hasExtension;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.372 -0400", hash_original_method = "F04D3A8DBD1CCF0248A759BF39EDDDEC", hash_generated_method = "28AC5874524790DE29AF55573DE3713A")
        public String getExtension() {
            String varB4EAC82CA7396A68D541C85D26508E83_64877205 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_64877205 = extension_;
            varB4EAC82CA7396A68D541C85D26508E83_64877205.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_64877205;
            // ---------- Original Method ----------
            //return extension_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.376 -0400", hash_original_method = "38A692624EA50F65C5AAF1C27A4F1E79", hash_generated_method = "51E9FF69EE54D424798AEB85EE297F4C")
        public PhoneNumber setExtension(String value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1528698766 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasExtension = true;
            extension_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1528698766 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1528698766.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1528698766;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasExtension = true;
            //extension_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.377 -0400", hash_original_method = "831C8D6965C7D5091D9400B8A1911F63", hash_generated_method = "566355764AB3455FB201ED1851FF3ECE")
        public PhoneNumber clearExtension() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1780874090 = null; //Variable for return #1
            hasExtension = false;
            extension_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_1780874090 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1780874090.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1780874090;
            // ---------- Original Method ----------
            //hasExtension = false;
            //extension_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.377 -0400", hash_original_method = "297A117AFD1E548B3AE9E987C5DEDB53", hash_generated_method = "3DAA15395AC073F7B0D068CAD2C5A066")
        public boolean hasItalianLeadingZero() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746167720 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746167720;
            // ---------- Original Method ----------
            //return hasItalianLeadingZero;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.377 -0400", hash_original_method = "B0BA7A66148037C7B1A35A6061ECB1A6", hash_generated_method = "6BB3B2857DEF7F524B2AD6A8D10BDB26")
        public boolean isItalianLeadingZero() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1251358553 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1251358553;
            // ---------- Original Method ----------
            //return italianLeadingZero_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.378 -0400", hash_original_method = "5FB07870F4A15DEE8F66E77590B141DD", hash_generated_method = "3D6F7DF4A30A1ECC476975BEB321AA53")
        public PhoneNumber setItalianLeadingZero(boolean value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_877020946 = null; //Variable for return #1
            hasItalianLeadingZero = true;
            italianLeadingZero_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_877020946 = this;
            varB4EAC82CA7396A68D541C85D26508E83_877020946.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_877020946;
            // ---------- Original Method ----------
            //hasItalianLeadingZero = true;
            //italianLeadingZero_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.379 -0400", hash_original_method = "55D33A5E10AF87EF82FB6277592BFD48", hash_generated_method = "00E48C3BFA4298F02CDD4B88218B0A7F")
        public PhoneNumber clearItalianLeadingZero() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_358754449 = null; //Variable for return #1
            hasItalianLeadingZero = false;
            italianLeadingZero_ = false;
            varB4EAC82CA7396A68D541C85D26508E83_358754449 = this;
            varB4EAC82CA7396A68D541C85D26508E83_358754449.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_358754449;
            // ---------- Original Method ----------
            //hasItalianLeadingZero = false;
            //italianLeadingZero_ = false;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.379 -0400", hash_original_method = "FC01A3A255BE4F11BA51CD36FFDCBB37", hash_generated_method = "05E0DC9BF6A746DEC7FC2DB85E1F11EE")
        public boolean hasRawInput() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_204147279 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_204147279;
            // ---------- Original Method ----------
            //return hasRawInput;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.380 -0400", hash_original_method = "F6017E34CFBABE539ED487A19641D13D", hash_generated_method = "19990D7B3936B2BEC4EC441D0278BA26")
        public String getRawInput() {
            String varB4EAC82CA7396A68D541C85D26508E83_1096747615 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1096747615 = rawInput_;
            varB4EAC82CA7396A68D541C85D26508E83_1096747615.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1096747615;
            // ---------- Original Method ----------
            //return rawInput_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.394 -0400", hash_original_method = "1DF89DBF221798F84EE73F6641D85CA9", hash_generated_method = "4C55C73B6FDB32FF6A3B276619AD3AB5")
        public PhoneNumber setRawInput(String value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1497400997 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasRawInput = true;
            rawInput_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_1497400997 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1497400997.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1497400997;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasRawInput = true;
            //rawInput_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.406 -0400", hash_original_method = "090A68BA48513AA6167B14B8C7E5B538", hash_generated_method = "FA926D1B0D04BBB8EEC93879259004F5")
        public PhoneNumber clearRawInput() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1685069429 = null; //Variable for return #1
            hasRawInput = false;
            rawInput_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_1685069429 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1685069429.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1685069429;
            // ---------- Original Method ----------
            //hasRawInput = false;
            //rawInput_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.407 -0400", hash_original_method = "49E6B213C7CF699A88721EC66ED6A85C", hash_generated_method = "AB15DE825452EC2B5CA734CD7D5546AA")
        public boolean hasCountryCodeSource() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980733016 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980733016;
            // ---------- Original Method ----------
            //return hasCountryCodeSource;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.411 -0400", hash_original_method = "EC13D38EB752707A5D37EF84821B18F3", hash_generated_method = "0871A4A21855415E45EF6342FD0ABB62")
        public CountryCodeSource getCountryCodeSource() {
            CountryCodeSource varB4EAC82CA7396A68D541C85D26508E83_1544338111 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1544338111 = countryCodeSource_;
            varB4EAC82CA7396A68D541C85D26508E83_1544338111.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1544338111;
            // ---------- Original Method ----------
            //return countryCodeSource_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.413 -0400", hash_original_method = "4C681F77FE4C34506AE7929BB9F5DB5B", hash_generated_method = "01AA8ECA29378DFE0D3CC04E14CC4F46")
        public PhoneNumber setCountryCodeSource(CountryCodeSource value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_684809100 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasCountryCodeSource = true;
            countryCodeSource_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_684809100 = this;
            varB4EAC82CA7396A68D541C85D26508E83_684809100.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_684809100;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasCountryCodeSource = true;
            //countryCodeSource_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.414 -0400", hash_original_method = "AD210C1FCCDAAC9D9B6A95A61CE920CC", hash_generated_method = "037A209340282861B653AC7AC2EB95F9")
        public PhoneNumber clearCountryCodeSource() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_90080229 = null; //Variable for return #1
            hasCountryCodeSource = false;
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            varB4EAC82CA7396A68D541C85D26508E83_90080229 = this;
            varB4EAC82CA7396A68D541C85D26508E83_90080229.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_90080229;
            // ---------- Original Method ----------
            //hasCountryCodeSource = false;
            //countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.423 -0400", hash_original_method = "8350C830C26B7D092EEEE9A503A10DA0", hash_generated_method = "9C7E6ACAEC129722AD1FD11B2EAC25D6")
        public boolean hasPreferredDomesticCarrierCode() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1657939239 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1657939239;
            // ---------- Original Method ----------
            //return hasPreferredDomesticCarrierCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.424 -0400", hash_original_method = "47CB8521CF67D388DB30B3F811726252", hash_generated_method = "E556E5B052AF0BC47254F1EAD2DA4E93")
        public String getPreferredDomesticCarrierCode() {
            String varB4EAC82CA7396A68D541C85D26508E83_2033091635 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2033091635 = preferredDomesticCarrierCode_;
            varB4EAC82CA7396A68D541C85D26508E83_2033091635.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2033091635;
            // ---------- Original Method ----------
            //return preferredDomesticCarrierCode_;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.424 -0400", hash_original_method = "41BB5D81F1B0279F583403646A2042B9", hash_generated_method = "0FAFBA512DB02D0C6DF870C296FACEDD")
        public PhoneNumber setPreferredDomesticCarrierCode(String value) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_743763020 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            hasPreferredDomesticCarrierCode = true;
            preferredDomesticCarrierCode_ = value;
            varB4EAC82CA7396A68D541C85D26508E83_743763020 = this;
            varB4EAC82CA7396A68D541C85D26508E83_743763020.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_743763020;
            // ---------- Original Method ----------
            //if (value == null) {
        //throw new NullPointerException();
      //}
            //hasPreferredDomesticCarrierCode = true;
            //preferredDomesticCarrierCode_ = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.425 -0400", hash_original_method = "26AD27D6AD8CEDC77B768F25CC124964", hash_generated_method = "9E8BA4CA9538C93546A005AC8687C8B3")
        public PhoneNumber clearPreferredDomesticCarrierCode() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_115658591 = null; //Variable for return #1
            hasPreferredDomesticCarrierCode = false;
            preferredDomesticCarrierCode_ = "";
            varB4EAC82CA7396A68D541C85D26508E83_115658591 = this;
            varB4EAC82CA7396A68D541C85D26508E83_115658591.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_115658591;
            // ---------- Original Method ----------
            //hasPreferredDomesticCarrierCode = false;
            //preferredDomesticCarrierCode_ = "";
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.426 -0400", hash_original_method = "9E3F334A53F42C22EC58969EE12FFC06", hash_generated_method = "9C6D324F2E0F2F3C8C7EC233EB661DF5")
        public final PhoneNumber clear() {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_614679091 = null; //Variable for return #1
            clearCountryCode();
            clearNationalNumber();
            clearExtension();
            clearItalianLeadingZero();
            clearRawInput();
            clearCountryCodeSource();
            clearPreferredDomesticCarrierCode();
            varB4EAC82CA7396A68D541C85D26508E83_614679091 = this;
            varB4EAC82CA7396A68D541C85D26508E83_614679091.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_614679091;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.446 -0400", hash_original_method = "0AFF34EE20E5281E0E8704C233C4A6C7", hash_generated_method = "8EB0B51B69B4372707D3EF0EF5A71746")
        public PhoneNumber mergeFrom(PhoneNumber other) {
            PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_60014892 = null; //Variable for return #1
            {
                boolean var7E81CBAAB3EA7600B5C349844A3DA67F_1606395606 = (other.hasCountryCode());
                {
                    setCountryCode(other.getCountryCode());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2052D51723D6CFDD0C32171C1669744A_369811388 = (other.hasNationalNumber());
                {
                    setNationalNumber(other.getNationalNumber());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var3D50C0940F659491C98DC4B316490D2B_441743658 = (other.hasExtension());
                {
                    setExtension(other.getExtension());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varA9932682E4C7BD97414CE18901A431BF_809993479 = (other.hasItalianLeadingZero());
                {
                    setItalianLeadingZero(other.isItalianLeadingZero());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF5BDCCDF0CF842993D0F90518AD8B0B1_1052501380 = (other.hasRawInput());
                {
                    setRawInput(other.getRawInput());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var035EFCDC910421918C6321C968D446C6_2087659878 = (other.hasCountryCodeSource());
                {
                    setCountryCodeSource(other.getCountryCodeSource());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBC066E2F7D27AB4E6EB4E9344D3B9AFA_386262016 = (other.hasPreferredDomesticCarrierCode());
                {
                    setPreferredDomesticCarrierCode(other.getPreferredDomesticCarrierCode());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_60014892 = this;
            addTaint(other.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_60014892.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_60014892;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.447 -0400", hash_original_method = "DE1C4B1DD2D8C57C4042DF1B529C7D4D", hash_generated_method = "4FD53EC2D8FC82A4517BEC984C85DFDD")
        public boolean exactlySameAs(PhoneNumber other) {
            boolean var4EB77A9CEDB1032569C973613A9313C9_604728782 = ((countryCode_ == other.countryCode_ && nationalNumber_ == other.nationalNumber_ &&
          extension_.equals(other.extension_) && italianLeadingZero_ == other.italianLeadingZero_ &&
          rawInput_.equals(other.rawInput_) && countryCodeSource_ == other.countryCodeSource_ &&
          preferredDomesticCarrierCode_.equals(other.preferredDomesticCarrierCode_) &&
          hasPreferredDomesticCarrierCode() == other.hasPreferredDomesticCarrierCode()));
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81162699 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_81162699;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.447 -0400", hash_original_method = "EF0E3A387E8AEF6EC396B951EC1536A9", hash_generated_method = "671C517FBE2F1CB48FEFDDBDF3867D91")
        @Override
        public boolean equals(Object that) {
            boolean var739237D2BDA3D224DE7CFFAAA4A6064B_17951109 = ((that instanceof PhoneNumber) && exactlySameAs((PhoneNumber) that));
            addTaint(that.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_505329552 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_505329552;
            // ---------- Original Method ----------
            //return (that instanceof PhoneNumber) && exactlySameAs((PhoneNumber) that);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.468 -0400", hash_original_method = "F1BB2EE5D9E77C138CA0D6B9F17756FB", hash_generated_method = "27007C61A1E672A9383754C84610E93A")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1476357888 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1476357888;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.470 -0400", hash_original_method = "16D1E3F084AA1063C11CF7C5BDA5DD45", hash_generated_method = "7254143C78D05032DFB94F71E4CE16F3")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1373408665 = null; //Variable for return #1
            StringBuilder outputString;
            outputString = new StringBuilder();
            outputString.append("Country Code: ").append(countryCode_);
            outputString.append(" National Number: ").append(nationalNumber_);
            {
                boolean varAC928743AA4361941C966832DF776A7B_510987647 = (hasItalianLeadingZero() && isItalianLeadingZero());
                {
                    outputString.append(" Leading Zero: true");
                } //End block
            } //End collapsed parenthetic
            {
                boolean var1430D110BD7C50E7B13612C95695845D_1840059455 = (hasExtension());
                {
                    outputString.append(" Extension: ").append(extension_);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2412B064642DAAEC43954205576731D7_642480928 = (hasCountryCodeSource());
                {
                    outputString.append(" Country Code Source: ").append(countryCodeSource_);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var647279AD14B7D4C5032BD55F39D3D3A8_1453385647 = (hasPreferredDomesticCarrierCode());
                {
                    outputString.append(" Preferred Domestic Carrier Code: ").
            append(preferredDomesticCarrierCode_);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1373408665 = outputString.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1373408665.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1373408665;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.470 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

        private static long serialVersionUID = 1L;
    }


    
}

