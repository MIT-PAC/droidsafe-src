package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;






public final class Phonenumber {
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.156 -0500", hash_original_method = "9F0C69719EBF6B458992D61E4BCC90E8", hash_generated_method = "C9B6A6946D35C4BEE39F9108178BA451")
    private Phonenumber() {}

    
    public static class PhoneNumber implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.157 -0500", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.160 -0500", hash_original_field = "82B142B2F946F9A1DC4E5413570AA407", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

    private boolean hasCountryCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.160 -0500", hash_original_field = "FC23115A75478BAF69B51EBF0DF044E0", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

    private int countryCode_ = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.164 -0500", hash_original_field = "583B17F0631B08F465D8873364D1F69E", hash_generated_field = "B31B8035F727A8BE2916E64EBF4F38BF")

    private boolean hasNationalNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.165 -0500", hash_original_field = "47D9F22F054A6889A5FAB156B1C26943", hash_generated_field = "861F5C609F3E4BA70615CE11EE4F3E7C")

    private long nationalNumber_ = 0L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.169 -0500", hash_original_field = "08856F07FEB46177FC970E2EA8A76849", hash_generated_field = "358E6375D13B5162BE1A3016216C10C6")

    private boolean hasExtension;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.170 -0500", hash_original_field = "12A3CF1FDB8524F50C150DB4844B3973", hash_generated_field = "6640D7D6CB57D7D20313E3325CD1FB22")

    private java.lang.String extension_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.174 -0500", hash_original_field = "BFD5E3B714BA5935AD999463D5FDE9D9", hash_generated_field = "3F85D89FA25AF2B45530E00802BDAF23")

    private boolean hasItalianLeadingZero;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.176 -0500", hash_original_field = "B7C0345302309EF4E42090FA700B8C30", hash_generated_field = "D7F0554114A7FE26069B675ED8151AC1")

    private boolean italianLeadingZero_ = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.180 -0500", hash_original_field = "0E5806B14C88BEF286DE0354C8FC8706", hash_generated_field = "C4DB1F876DD23BC8A14CC9C5A337EE0B")

    private boolean hasRawInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.180 -0500", hash_original_field = "8531784DE8FF255304C4A869A0914681", hash_generated_field = "1CA91139B304F5C069E8FEFEEC7BDADA")

    private String rawInput_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.185 -0500", hash_original_field = "8C643CC235AC76A86396BB54F092E74B", hash_generated_field = "F0FD53E6932AA94BEF89B80DE8FBB48A")

    private boolean hasCountryCodeSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.185 -0500", hash_original_field = "024C3F93C02F3B701271E699655E8215", hash_generated_field = "726423546266BF59E9D4D30E8DF8603B")

    private CountryCodeSource countryCodeSource_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.190 -0500", hash_original_field = "BC52FD786796F1BB69722F435230C282", hash_generated_field = "7A3961A3D14D61159606E8AEE7AE90AE")

    private boolean hasPreferredDomesticCarrierCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.190 -0500", hash_original_field = "111FD684B139A36C9E0795EEF2B7FCD7", hash_generated_field = "30C4AF8975E517B81211F0AB34A0B954")

    private java.lang.String preferredDomesticCarrierCode_ = "";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.159 -0500", hash_original_method = "BC3E0739FB67F4B1E9E07E3377CC422E", hash_generated_method = "56363C40971DF55803621B192A2493FA")
        public PhoneNumber() {
      countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.161 -0500", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "AD6664713D77220A89A09E0596063EF4")
        public boolean hasCountryCode() { return hasCountryCode; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.162 -0500", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "C37DB593B1646041EDA64981C3456204")
        public int getCountryCode() { return countryCode_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.163 -0500", hash_original_method = "231BDC2ACAA546410AD99483D572C314", hash_generated_method = "9DBF7FE4FCC5269F7A93B54FB6E301DC")
        public PhoneNumber setCountryCode(int value) {
      hasCountryCode = true;
      countryCode_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.164 -0500", hash_original_method = "F3480C339E6576F38870C4A8107DC432", hash_generated_method = "27AB82FADD773210E81FB7282752E714")
        public PhoneNumber clearCountryCode() {
      hasCountryCode = false;
      countryCode_ = 0;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.166 -0500", hash_original_method = "9E5DD8721DB5E6B4EA37D3D3DF3C82B6", hash_generated_method = "13A31FE754A0DCC4B1987692798CCF4D")
        public boolean hasNationalNumber() { return hasNationalNumber; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.167 -0500", hash_original_method = "6637472029560B21624D3926379C2007", hash_generated_method = "DA629ACAB58FB7338A66DCAD1867CF7C")
        public long getNationalNumber() { return nationalNumber_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.167 -0500", hash_original_method = "6A535B2D70F0F9B1A2B7BD33E2B75251", hash_generated_method = "82ED6B1949FE084C17108E1654439E44")
        public PhoneNumber setNationalNumber(long value) {
      hasNationalNumber = true;
      nationalNumber_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.168 -0500", hash_original_method = "805285A190D17B224561E5C065A4AB00", hash_generated_method = "5E953821A0764973B82260E3F089C4F8")
        public PhoneNumber clearNationalNumber() {
      hasNationalNumber = false;
      nationalNumber_ = 0L;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.171 -0500", hash_original_method = "66338EE760653FB7826716BD4179F0EB", hash_generated_method = "CB0A815996451F4817F3D748735FA7E3")
        public boolean hasExtension() { return hasExtension; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.172 -0500", hash_original_method = "F04D3A8DBD1CCF0248A759BF39EDDDEC", hash_generated_method = "565B05D15125DB58E68A83C6324BED47")
        public String getExtension() { return extension_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.173 -0500", hash_original_method = "38A692624EA50F65C5AAF1C27A4F1E79", hash_generated_method = "9C47E32754B7630BAA172FCEE4EFA94B")
        public PhoneNumber setExtension(String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasExtension = true;
      extension_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.174 -0500", hash_original_method = "831C8D6965C7D5091D9400B8A1911F63", hash_generated_method = "565CC8392C79CCD98297FC63E1FDCCC1")
        public PhoneNumber clearExtension() {
      hasExtension = false;
      extension_ = "";
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.176 -0500", hash_original_method = "297A117AFD1E548B3AE9E987C5DEDB53", hash_generated_method = "EB56DD1D33DAE581EB68650764C3C2E2")
        public boolean hasItalianLeadingZero() { return hasItalianLeadingZero; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.177 -0500", hash_original_method = "B0BA7A66148037C7B1A35A6061ECB1A6", hash_generated_method = "BB3D4F0DEC1B4D25B8F3E2B95CF41A0C")
        public boolean isItalianLeadingZero() { return italianLeadingZero_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.178 -0500", hash_original_method = "5FB07870F4A15DEE8F66E77590B141DD", hash_generated_method = "8373CD0CC3FDFCD592BD309BFDB00E42")
        public PhoneNumber setItalianLeadingZero(boolean value) {
      hasItalianLeadingZero = true;
      italianLeadingZero_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.179 -0500", hash_original_method = "55D33A5E10AF87EF82FB6277592BFD48", hash_generated_method = "DF3FBE4334CB7FCDC52C1F878B443987")
        public PhoneNumber clearItalianLeadingZero() {
      hasItalianLeadingZero = false;
      italianLeadingZero_ = false;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.181 -0500", hash_original_method = "FC01A3A255BE4F11BA51CD36FFDCBB37", hash_generated_method = "B02DFC309232478D4D5E800DE3F53E44")
        public boolean hasRawInput() { return hasRawInput; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.182 -0500", hash_original_method = "F6017E34CFBABE539ED487A19641D13D", hash_generated_method = "F669124DDD92B2874EE0A20C3B26D56B")
        public String getRawInput() { return rawInput_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.183 -0500", hash_original_method = "1DF89DBF221798F84EE73F6641D85CA9", hash_generated_method = "62829CA35ECFD9B96955EDB1D76A5ABC")
        public PhoneNumber setRawInput(String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasRawInput = true;
      rawInput_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.184 -0500", hash_original_method = "090A68BA48513AA6167B14B8C7E5B538", hash_generated_method = "6F02D769E45C16B1135D7CF365B48F3C")
        public PhoneNumber clearRawInput() {
      hasRawInput = false;
      rawInput_ = "";
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.186 -0500", hash_original_method = "49E6B213C7CF699A88721EC66ED6A85C", hash_generated_method = "A32BEEEF8D0ED31259A48BFC1A34803A")
        public boolean hasCountryCodeSource() { return hasCountryCodeSource; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.187 -0500", hash_original_method = "EC13D38EB752707A5D37EF84821B18F3", hash_generated_method = "647DFD3BCCCBF7E770699E31F5E857F2")
        public CountryCodeSource getCountryCodeSource() { return countryCodeSource_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.188 -0500", hash_original_method = "4C681F77FE4C34506AE7929BB9F5DB5B", hash_generated_method = "81BC9D0085B36CB27137905422E5B816")
        public PhoneNumber setCountryCodeSource(CountryCodeSource value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasCountryCodeSource = true;
      countryCodeSource_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.189 -0500", hash_original_method = "AD210C1FCCDAAC9D9B6A95A61CE920CC", hash_generated_method = "F309409F29D6984BAD5D857D98A53C77")
        public PhoneNumber clearCountryCodeSource() {
      hasCountryCodeSource = false;
      countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.191 -0500", hash_original_method = "8350C830C26B7D092EEEE9A503A10DA0", hash_generated_method = "03020ACFA0F9A425A5D35732CA79F362")
        public boolean hasPreferredDomesticCarrierCode() { return hasPreferredDomesticCarrierCode; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.192 -0500", hash_original_method = "47CB8521CF67D388DB30B3F811726252", hash_generated_method = "4C5A5475D648741F876A73838BD54664")
        public String getPreferredDomesticCarrierCode() { return preferredDomesticCarrierCode_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.193 -0500", hash_original_method = "41BB5D81F1B0279F583403646A2042B9", hash_generated_method = "C7E3136CC53E355345F23A49A1A9D21F")
        public PhoneNumber setPreferredDomesticCarrierCode(String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasPreferredDomesticCarrierCode = true;
      preferredDomesticCarrierCode_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.194 -0500", hash_original_method = "26AD27D6AD8CEDC77B768F25CC124964", hash_generated_method = "13ADA143311288EAD426928CC8E64607")
        public PhoneNumber clearPreferredDomesticCarrierCode() {
      hasPreferredDomesticCarrierCode = false;
      preferredDomesticCarrierCode_ = "";
      return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.195 -0500", hash_original_method = "9E3F334A53F42C22EC58969EE12FFC06", hash_generated_method = "E97B3D5421C70FA0E54207081B636B76")
        public final PhoneNumber clear() {
      clearCountryCode();
      clearNationalNumber();
      clearExtension();
      clearItalianLeadingZero();
      clearRawInput();
      clearCountryCodeSource();
      clearPreferredDomesticCarrierCode();
      return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.196 -0500", hash_original_method = "0AFF34EE20E5281E0E8704C233C4A6C7", hash_generated_method = "04A02D691875E33282BF86FC55C9EC3E")
        public PhoneNumber mergeFrom(PhoneNumber other) {
      if (other.hasCountryCode()) {
        setCountryCode(other.getCountryCode());
      }
      if (other.hasNationalNumber()) {
        setNationalNumber(other.getNationalNumber());
      }
      if (other.hasExtension()) {
        setExtension(other.getExtension());
      }
      if (other.hasItalianLeadingZero()) {
        setItalianLeadingZero(other.isItalianLeadingZero());
      }
      if (other.hasRawInput()) {
        setRawInput(other.getRawInput());
      }
      if (other.hasCountryCodeSource()) {
        setCountryCodeSource(other.getCountryCodeSource());
      }
      if (other.hasPreferredDomesticCarrierCode()) {
        setPreferredDomesticCarrierCode(other.getPreferredDomesticCarrierCode());
      }
      return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.196 -0500", hash_original_method = "DE1C4B1DD2D8C57C4042DF1B529C7D4D", hash_generated_method = "11EA20DEFA6AD7D49204327C82A9AA70")
        public boolean exactlySameAs(PhoneNumber other) {
      if (other == null) {
        return false;
      }
      if (this == other) {
        return true;
      }
      return (countryCode_ == other.countryCode_ && nationalNumber_ == other.nationalNumber_ &&
          extension_.equals(other.extension_) && italianLeadingZero_ == other.italianLeadingZero_ &&
          rawInput_.equals(other.rawInput_) && countryCodeSource_ == other.countryCodeSource_ &&
          preferredDomesticCarrierCode_.equals(other.preferredDomesticCarrierCode_) &&
          hasPreferredDomesticCarrierCode() == other.hasPreferredDomesticCarrierCode());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.197 -0500", hash_original_method = "EF0E3A387E8AEF6EC396B951EC1536A9", hash_generated_method = "23B09A2B6C9F3F5F5263094FB4028E82")
        @Override
public boolean equals(Object that) {
      return (that instanceof PhoneNumber) && exactlySameAs((PhoneNumber) that);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.199 -0500", hash_original_method = "F1BB2EE5D9E77C138CA0D6B9F17756FB", hash_generated_method = "8D8F271DF5F3039F0BB00408A32ADCA4")
        @Override
public int hashCode() {
      // Simplified rendition of the hashCode function automatically generated from the proto
      // compiler with java_generate_equals_and_hash set to true. We are happy with unset values to
      // be considered equal to their explicitly-set equivalents, so don't check if any value is
      // unknown. The only exception to this is the preferred domestic carrier code.
      int hash = 41;
      hash = (53 * hash) + getCountryCode();
      hash = (53 * hash) + Long.valueOf(getNationalNumber()).hashCode();
      hash = (53 * hash) + getExtension().hashCode();
      hash = (53 * hash) + (isItalianLeadingZero() ? 1231 : 1237);
      hash = (53 * hash) + getRawInput().hashCode();
      hash = (53 * hash) + getCountryCodeSource().hashCode();
      hash = (53 * hash) + getPreferredDomesticCarrierCode().hashCode();
      hash = (53 * hash) + (hasPreferredDomesticCarrierCode() ? 1231 : 1237);
      return hash;
    }

        
        public enum CountryCodeSource {
      FROM_NUMBER_WITH_PLUS_SIGN,
      FROM_NUMBER_WITH_IDD,
      FROM_NUMBER_WITHOUT_PLUS_SIGN,
      FROM_DEFAULT_COUNTRY
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:47.200 -0500", hash_original_method = "16D1E3F084AA1063C11CF7C5BDA5DD45", hash_generated_method = "AE6BF4EB11153FB9C19327696FB20C56")
        @Override
public String toString() {
      StringBuilder outputString = new StringBuilder();
      outputString.append("Country Code: ").append(countryCode_);
      outputString.append(" National Number: ").append(nationalNumber_);
      if (hasItalianLeadingZero() && isItalianLeadingZero()) {
        outputString.append(" Leading Zero: true");
      }
      if (hasExtension()) {
        outputString.append(" Extension: ").append(extension_);
      }
      if (hasCountryCodeSource()) {
        outputString.append(" Country Code Source: ").append(countryCodeSource_);
      }
      if (hasPreferredDomesticCarrierCode()) {
        outputString.append(" Preferred Domestic Carrier Code: ").
            append(preferredDomesticCarrierCode_);
      }
      return outputString.toString();
    }
    }


    
}

