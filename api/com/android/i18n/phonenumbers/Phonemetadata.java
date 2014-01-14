package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class Phonemetadata {
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.990 -0500", hash_original_method = "AA2168146A79C42118444B1AF1D13430", hash_generated_method = "26CABAE6A5BDA9723B655D1D4AA748A5")
    
private Phonemetadata() {}
    
    public static class NumberFormat implements Externalizable {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.004 -0500", hash_original_method = "40C91A2B40702DA09592EFF9D16C1F5D", hash_generated_method = "9482C4B711FD5BDB71268D84C7181C9E")
        
public static Builder newBuilder() {
      return new Builder();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.993 -0500", hash_original_field = "BADD260C899A27EA5AFAD8DE17C69518", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

    private static final long serialVersionUID = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.006 -0500", hash_original_field = "E6E5073D0657E91E5EDE0CABEB295B4A", hash_generated_field = "BCFAB4E6509DB535E782A9A7638BF800")

    private boolean hasPattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.009 -0500", hash_original_field = "112CC88CF7ACF54981F2527F479CDBEB", hash_generated_field = "A40119EC58A9ADBEEF7F74515C4824EB")

    private String pattern_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.018 -0500", hash_original_field = "02420DBB478D18A2F3518DE4E9B966EE", hash_generated_field = "BB7D9B531AF497BD0CC6485A499825C4")

    private boolean hasFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.020 -0500", hash_original_field = "0C360943C172A3E4E19FC80F3A58FCA2", hash_generated_field = "331E3EC56817A5418D313A742EE6BAF6")

    private String format_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.030 -0500", hash_original_field = "2D1A305D2D8544C49BB8AB444D020467", hash_generated_field = "8C6856D900C2B3217AAACE1CB04BBDC9")

    private java.util.List<String> leadingDigitsPattern_ = new java.util.ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.042 -0500", hash_original_field = "077E8D62B1EA2309785E1601C270359D", hash_generated_field = "92669F4414DE1997CD38BA06884F29EB")

    private boolean hasNationalPrefixFormattingRule;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.044 -0500", hash_original_field = "3624A29C44CED48383AC31689F083383", hash_generated_field = "B5917D98A0DF4DBF46F96EC8B9B42B54")

    private String nationalPrefixFormattingRule_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.056 -0500", hash_original_field = "54B26BD31C719A4C03A0E49C9D51D520", hash_generated_field = "1C2206B3A1E5D1FEEB3BC9386E1B8AEC")

    private boolean hasDomesticCarrierCodeFormattingRule;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.058 -0500", hash_original_field = "C5CDD90D08F0BC6BE53CAA9E8190350D", hash_generated_field = "4E860583F8E21CB17BEAB512DD9874BA")

    private String domesticCarrierCodeFormattingRule_ = "";
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.996 -0500", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "CC6BC77D87404D536F3CBB3CC13951E4")
        
public NumberFormat() {}
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.011 -0500", hash_original_method = "0246232EE6FB2A92C361AD6A40430F9A", hash_generated_method = "D2A81631EB56DA96A36627C9E8CD5E38")
        
public boolean hasPattern() { return hasPattern; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.013 -0500", hash_original_method = "42C6A53B1E4394F40C706B46BCE960D0", hash_generated_method = "67A3034CAACA541F7DD9AB6CE498F1CD")
        
public String getPattern() { return pattern_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.015 -0500", hash_original_method = "ED9D042141B07F3A02D73E93DCCEE4F0", hash_generated_method = "BECDAEFE71EAF6660B58F7BB3F4F9C15")
        
public NumberFormat setPattern(String value) {
      hasPattern = true;
      pattern_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.022 -0500", hash_original_method = "68B5595866A3AC066C218CEE1670E78C", hash_generated_method = "7F321ABB04C5E159799BF6DE7D931CAD")
        
public boolean hasFormat() { return hasFormat; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.025 -0500", hash_original_method = "77809F0555E410001A5868E71E8924BD", hash_generated_method = "DB48F2DF6B5B9A8F6AFF3B7E65FB6D73")
        
public String getFormat() { return format_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.028 -0500", hash_original_method = "791160F9BB3B0A81AD0DFEC24C1732C9", hash_generated_method = "E028C8B978E6BF1E1295088BE6A9EB0A")
        
public NumberFormat setFormat(String value) {
      hasFormat = true;
      format_ = value;
      return this;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.032 -0500", hash_original_method = "E6A52876E9E1328523A23CDD4ADD6081", hash_generated_method = "69B5C0EE96377478F94E375CEF1A5599")
        
public java.util.List<String> leadingDigitPatterns() {
      return leadingDigitsPattern_;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.034 -0500", hash_original_method = "A7BC4264224DD72A69FEDA104C14570A", hash_generated_method = "CE546619910E95FE11C17D1A53524C81")
        
public int leadingDigitsPatternSize() { return leadingDigitsPattern_.size(); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.036 -0500", hash_original_method = "F45A9318A15D3A63FB863C1586B0A383", hash_generated_method = "787034B4DF3A2FFB6E82127DD0C96253")
        
public String getLeadingDigitsPattern(int index) {
      return leadingDigitsPattern_.get(index);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.039 -0500", hash_original_method = "67AADF10399513606F7245D93555CAB7", hash_generated_method = "3FD651F757251C89FFEBB85EAEC68565")
        
public NumberFormat addLeadingDigitsPattern(String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      leadingDigitsPattern_.add(value);
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.046 -0500", hash_original_method = "A0F401EEBE63541205F643F348AC0373", hash_generated_method = "3347C7D2CC099DE3F21E95EDCF9CA905")
        
public boolean hasNationalPrefixFormattingRule() { return hasNationalPrefixFormattingRule; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.049 -0500", hash_original_method = "4B4C80C20D7D7C0D6F8A6AA39111D13B", hash_generated_method = "40533399D98C7D79F505AAA1935BD685")
        
public String getNationalPrefixFormattingRule() { return nationalPrefixFormattingRule_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.051 -0500", hash_original_method = "6C67B9000B21FDC6ACFC6210DBD720A7", hash_generated_method = "3B2C8D1EF27E4C842724645A7C205BDB")
        
public NumberFormat setNationalPrefixFormattingRule(String value) {
      hasNationalPrefixFormattingRule = true;
      nationalPrefixFormattingRule_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.053 -0500", hash_original_method = "394C283EEDF7D9BA381FE6D7D2DD662E", hash_generated_method = "E37BB4FEF08A53834F7FDEC839552508")
        
public NumberFormat clearNationalPrefixFormattingRule() {
      hasNationalPrefixFormattingRule = false;
      nationalPrefixFormattingRule_ = "";
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.061 -0500", hash_original_method = "1D512C574271A1305D1AF9A0CCC5C6D3", hash_generated_method = "BDAC82CF6D61843A0139331DB92AD229")
        
public boolean hasDomesticCarrierCodeFormattingRule() {
      return hasDomesticCarrierCodeFormattingRule; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.063 -0500", hash_original_method = "1D78023CBBDF63A0A2ACC33925BD120F", hash_generated_method = "17E6632F19F48F6630686507067D127A")
        
public String getDomesticCarrierCodeFormattingRule() {
      return domesticCarrierCodeFormattingRule_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.066 -0500", hash_original_method = "2168D8046E4A0ED39DDD19551FD64D5A", hash_generated_method = "82EDE6F72722CBE0B3F277BC19203C7C")
        
public NumberFormat setDomesticCarrierCodeFormattingRule(String value) {
      hasDomesticCarrierCodeFormattingRule = true;
      domesticCarrierCodeFormattingRule_ = value;
      return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.069 -0500", hash_original_method = "DEB91FB350FEBE5DEE35AF7BFA950AEF", hash_generated_method = "25B531A6B0B7205B01D2BDFD196E90D4")
        
public NumberFormat mergeFrom(NumberFormat other) {
      if (other.hasPattern()) {
        setPattern(other.getPattern());
      }
      if (other.hasFormat()) {
        setFormat(other.getFormat());
      }
      int leadingDigitsPatternSize = other.leadingDigitsPatternSize();
      for (int i = 0; i < leadingDigitsPatternSize; i++) {
        addLeadingDigitsPattern(other.getLeadingDigitsPattern(i));
      }
      if (other.hasNationalPrefixFormattingRule()) {
        setNationalPrefixFormattingRule(other.getNationalPrefixFormattingRule());
      }
      if (other.hasDomesticCarrierCodeFormattingRule()) {
        setDomesticCarrierCodeFormattingRule(other.getDomesticCarrierCodeFormattingRule());
      }
      return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.072 -0500", hash_original_method = "A100AA8318BC8064BB1FFCA8BFB04888", hash_generated_method = "F478D0E447327832712EE4B92483FE18")
        
public void writeExternal(ObjectOutput objectOutput) throws IOException {
      objectOutput.writeUTF(pattern_);
      objectOutput.writeUTF(format_);
      int leadingDigitsPatternSize = leadingDigitsPatternSize();
      objectOutput.writeInt(leadingDigitsPatternSize);
      for (int i = 0; i < leadingDigitsPatternSize; i++) {
        objectOutput.writeUTF(leadingDigitsPattern_.get(i));
      }

      objectOutput.writeBoolean(hasNationalPrefixFormattingRule);
      if (hasNationalPrefixFormattingRule) {
        objectOutput.writeUTF(nationalPrefixFormattingRule_);
      }
      objectOutput.writeBoolean(hasDomesticCarrierCodeFormattingRule);
      if (hasDomesticCarrierCodeFormattingRule) {
        objectOutput.writeUTF(domesticCarrierCodeFormattingRule_);
      }
    }
        
        public static final class Builder extends NumberFormat {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.185 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.000 -0500", hash_original_method = "0B2E67344AC06F839A81A2533D186625", hash_generated_method = "0DE591BEE46A5688B446318BCC46EBAB")
            
public NumberFormat build() {
        return this;
      }
            
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.074 -0500", hash_original_method = "A5A163CCCC35630D5C707482125AAE27", hash_generated_method = "EAD598E4B9164BC70ECC0513F99309A6")
        
public void readExternal(ObjectInput objectInput) throws IOException {
      setPattern(objectInput.readUTF());
      setFormat(objectInput.readUTF());
      int leadingDigitsPatternSize = objectInput.readInt();
      for (int i = 0; i < leadingDigitsPatternSize; i++) {
        leadingDigitsPattern_.add(objectInput.readUTF());
      }
      if (objectInput.readBoolean()) {
        setNationalPrefixFormattingRule(objectInput.readUTF());
      }
      if (objectInput.readBoolean()) {
        setDomesticCarrierCodeFormattingRule(objectInput.readUTF());
      }
    }
    }
    
    public static class PhoneNumberDesc implements Externalizable {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.091 -0500", hash_original_method = "40C91A2B40702DA09592EFF9D16C1F5D", hash_generated_method = "9482C4B711FD5BDB71268D84C7181C9E")
        
public static Builder newBuilder() {
      return new Builder();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.080 -0500", hash_original_field = "BADD260C899A27EA5AFAD8DE17C69518", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

    private static final long serialVersionUID = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.093 -0500", hash_original_field = "9D70BEFD20DF6FE835675B860CC132BF", hash_generated_field = "FE0D4AC450B46E7BA63C0A5FF14C51C2")

    private boolean hasNationalNumberPattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.095 -0500", hash_original_field = "4725FB1937118075855F3E6344C7D45D", hash_generated_field = "EEA13D95EC1A783CC3FD2A2EA5BF77DB")

    private String nationalNumberPattern_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.104 -0500", hash_original_field = "3DEAEF7824EB405CF6B793549A9A0EA6", hash_generated_field = "A5D4C78E7537A35AEAFB80E70E1EF9CF")

    private boolean hasPossibleNumberPattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.107 -0500", hash_original_field = "77D6E1DBA54D47B17D42672B343BF598", hash_generated_field = "9740030449804334CD1D210C9AACA78D")

    private String possibleNumberPattern_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.117 -0500", hash_original_field = "61E0D07AFAB10ABDE20B605929E11EC3", hash_generated_field = "A377FEAF080DA6EA07178B0BF7E01505")

    private boolean hasExampleNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.119 -0500", hash_original_field = "F256DEC58A79E26491FB294D557FB16A", hash_generated_field = "D8EDB7AA5577953B265C1D4AEECCDF65")

    private String exampleNumber_ = "";
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.083 -0500", hash_original_method = "7B50B3AE2E947514292047EE4CC3D0B3", hash_generated_method = "4F15F34FB8F5976676EE5045476563B6")
        
public PhoneNumberDesc() {}
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.097 -0500", hash_original_method = "7AE951C08CA66D0892FA0795F4703C0D", hash_generated_method = "740669F056F891565FA1250881F9960D")
        
public boolean hasNationalNumberPattern() { return hasNationalNumberPattern; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.100 -0500", hash_original_method = "AE5307416A342E6E51B0D8AFEA64E005", hash_generated_method = "B4761B265520004CC04647A731B285AC")
        
public String getNationalNumberPattern() { return nationalNumberPattern_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.102 -0500", hash_original_method = "5843589EEE5242B872EEFCA090E2182C", hash_generated_method = "39ABB1DB04BC25F1A0C655EDE0B73935")
        
public PhoneNumberDesc setNationalNumberPattern(String value) {
      hasNationalNumberPattern = true;
      nationalNumberPattern_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.109 -0500", hash_original_method = "0D2D12A828079BB292F0B693EDB7AA61", hash_generated_method = "7B0F9A6506887BF68538A63DAC38A623")
        
public boolean hasPossibleNumberPattern() { return hasPossibleNumberPattern; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.112 -0500", hash_original_method = "69E173398B553B507060BBCC25879496", hash_generated_method = "20CB4BE17CE408121602C669651F3C42")
        
public String getPossibleNumberPattern() { return possibleNumberPattern_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.114 -0500", hash_original_method = "E6F0FD7A3910EDF596B66C25C9FCACCB", hash_generated_method = "06B2DDE9DECE88A10381D9605A689C3A")
        
public PhoneNumberDesc setPossibleNumberPattern(String value) {
      hasPossibleNumberPattern = true;
      possibleNumberPattern_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.121 -0500", hash_original_method = "9EA98547022BA9B31E373C0BBC90B4AD", hash_generated_method = "145B824BF8E9E4C79B7A6BEE466D7A17")
        
public boolean hasExampleNumber() { return hasExampleNumber; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.123 -0500", hash_original_method = "4F2E88760366816D23F2792FF3D4D910", hash_generated_method = "4ACE8B1C15DF80DEEAB045FA52442AA1")
        
public String getExampleNumber() { return exampleNumber_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.125 -0500", hash_original_method = "99D22C86FFDC5E436BCE118592FFD464", hash_generated_method = "C090CA5080F184796F8535F7BE3C1FF1")
        
public PhoneNumberDesc setExampleNumber(String value) {
      hasExampleNumber = true;
      exampleNumber_ = value;
      return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.128 -0500", hash_original_method = "13E9D2F0445C754E67764A18611FF669", hash_generated_method = "3B79268BA5D64C916EE688C45B3DACB1")
        
public PhoneNumberDesc mergeFrom(PhoneNumberDesc other) {
      if (other.hasNationalNumberPattern()) {
        setNationalNumberPattern(other.getNationalNumberPattern());
      }
      if (other.hasPossibleNumberPattern()) {
        setPossibleNumberPattern(other.getPossibleNumberPattern());
      }
      if (other.hasExampleNumber()) {
        setExampleNumber(other.getExampleNumber());
      }
      return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.130 -0500", hash_original_method = "67972576318010D4A6F8FC5204742584", hash_generated_method = "60154FCC57C5F561502AE63620F7968F")
        
public boolean exactlySameAs(PhoneNumberDesc other) {
      return nationalNumberPattern_.equals(other.nationalNumberPattern_) &&
          possibleNumberPattern_.equals(other.possibleNumberPattern_) &&
          exampleNumber_.equals(other.exampleNumber_);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.133 -0500", hash_original_method = "A248C31238E31950C31B42AEACDEB8E6", hash_generated_method = "D4EA929199BBBEE464BD6F8675F8EB07")
        
public void writeExternal(ObjectOutput objectOutput) throws IOException {
      objectOutput.writeBoolean(hasNationalNumberPattern);
      if (hasNationalNumberPattern) {
        objectOutput.writeUTF(nationalNumberPattern_);
      }

      objectOutput.writeBoolean(hasPossibleNumberPattern);
      if (hasPossibleNumberPattern) {
        objectOutput.writeUTF(possibleNumberPattern_);
      }

      objectOutput.writeBoolean(hasExampleNumber);
      if (hasExampleNumber) {
        objectOutput.writeUTF(exampleNumber_);
      }
    }
        
        public static final class Builder extends PhoneNumberDesc {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.188 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.087 -0500", hash_original_method = "27A166D755957BD27B60D63CE4983A6A", hash_generated_method = "F3DBE646E04FE2E398C2DEFB42DD5DDA")
            
public PhoneNumberDesc build() {
        return this;
      }
            
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.136 -0500", hash_original_method = "27FB9E0837C2CDBADF688660FFE7A75C", hash_generated_method = "EB909794D1401E4012ED9EB08A331497")
        
public void readExternal(ObjectInput objectInput) throws IOException {
      if (objectInput.readBoolean()) {
        setNationalNumberPattern(objectInput.readUTF());
      }

      if (objectInput.readBoolean()) {
        setPossibleNumberPattern(objectInput.readUTF());
      }

      if (objectInput.readBoolean()) {
        setExampleNumber(objectInput.readUTF());
      }
    }
    }
    
    public static class PhoneMetadata implements Externalizable {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.152 -0500", hash_original_method = "40C91A2B40702DA09592EFF9D16C1F5D", hash_generated_method = "9482C4B711FD5BDB71268D84C7181C9E")
        
public static Builder newBuilder() {
      return new Builder();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.142 -0500", hash_original_field = "BADD260C899A27EA5AFAD8DE17C69518", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

    private static final long serialVersionUID = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.154 -0500", hash_original_field = "A75B4682067E6001DEFE67FF26D093CF", hash_generated_field = "A3B9F71CE88284DA159E437E743AF585")

    private boolean hasGeneralDesc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.156 -0500", hash_original_field = "3BA677D2143662CE657199D46DC763FA", hash_generated_field = "7468C9C864A0465318B0CE4D7F53C201")

    private PhoneNumberDesc generalDesc_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.166 -0500", hash_original_field = "D4152AEBBEC23DADB9F68F950CE24B26", hash_generated_field = "E05C42AA9F7E3C173F9E6FFB96993C10")

    private boolean hasFixedLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.168 -0500", hash_original_field = "6F0B326B00A499044E858F9491296E17", hash_generated_field = "6B2D29317DA7FDD4358F05B6ED70E817")

    private PhoneNumberDesc fixedLine_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.177 -0500", hash_original_field = "2AD78F3CE5BD3CCB5707CBB9E79F51EA", hash_generated_field = "6732DA5D8F7E44D3EB8E9B3B04D2C208")

    private boolean hasMobile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.179 -0500", hash_original_field = "D72BED9BB939BFB8CFCD15CBBCE7D0A4", hash_generated_field = "B09F10BC9C29A32513C7F9D45C9DD65D")

    private PhoneNumberDesc mobile_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.189 -0500", hash_original_field = "ECE77CD3ED3FBD37A3A273F4DCDC856C", hash_generated_field = "80FAAA0975BF29FCB14D951C0BEDC5C4")

    private boolean hasTollFree;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.191 -0500", hash_original_field = "FC7565FC416B4F742A6DF082E4CAF24E", hash_generated_field = "80CDA2C3C5F8E5226552943E5B5D1962")

    private PhoneNumberDesc tollFree_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.201 -0500", hash_original_field = "C46233204F8742493CD7E6ECC168AFFC", hash_generated_field = "5A30F5E3B7119D5842288ABCFFE97498")

    private boolean hasPremiumRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.203 -0500", hash_original_field = "0D3C80A89EEDAB54E4F658458414EF76", hash_generated_field = "A45FECABBF74FB7321F9023E44E33237")

    private PhoneNumberDesc premiumRate_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.213 -0500", hash_original_field = "FCBAE103BB934909ADA89E0DA22823C5", hash_generated_field = "E49185F054F9F704C5600406F67DCB84")

    private boolean hasSharedCost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.215 -0500", hash_original_field = "D412C97044C410BF680A532A76F91958", hash_generated_field = "F1E7A155AA2DB5B0B5B95BFB0CEE31C9")

    private PhoneNumberDesc sharedCost_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.225 -0500", hash_original_field = "EAC6C6AAA47A8DE905547B7A8B884866", hash_generated_field = "EDA3B33207D61D6AC565FA093ADCC196")

    private boolean hasPersonalNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.228 -0500", hash_original_field = "6769BA28C747AA6955E2DB6195A0D5A7", hash_generated_field = "9BEB6F47AE29097500633D2F6F699031")

    private PhoneNumberDesc personalNumber_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.237 -0500", hash_original_field = "232EECA4B7132B9D3A56FAD78AB1550D", hash_generated_field = "389614404066D2EFA2E54C2350D94AD0")

    private boolean hasVoip;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.240 -0500", hash_original_field = "DCC73F21EAF2C8F3DA4EF728DBDDEBBD", hash_generated_field = "EFA41A681D6E8CCFBC92A6D814B85301")

    private PhoneNumberDesc voip_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.249 -0500", hash_original_field = "138F4B73D076944BB998A651C9566C90", hash_generated_field = "AA932FC09168FC29B0E1BDD3089132CB")

    private boolean hasPager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.252 -0500", hash_original_field = "2E0517564F40EB9807E9FDEE760E1363", hash_generated_field = "6DF80094481DB5FAFFA343EECB46293A")

    private PhoneNumberDesc pager_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.261 -0500", hash_original_field = "08A5E3D2DA7CA167CB0F95C7DC5CDDE8", hash_generated_field = "8F81ABDD16142E28D9E5984C6F740238")

    private boolean hasUan;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.263 -0500", hash_original_field = "386277F79C7C03382CF1525FD39D7141", hash_generated_field = "AD69C3410F5AE892799A6AC7CB2532E2")

    private PhoneNumberDesc uan_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.273 -0500", hash_original_field = "5F122F0CD6A700D9F7F5ECF5434EC3E7", hash_generated_field = "0ADF693E546C325541D053D46F07CA67")

    private boolean hasNoInternationalDialling;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.275 -0500", hash_original_field = "7814F72372A8F2C04F630FB7885D9620", hash_generated_field = "DB4742972A73F31DE788D6B88EE269C4")

    private PhoneNumberDesc noInternationalDialling_ = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.284 -0500", hash_original_field = "78B136712EAAF25266BCE7AC95547761", hash_generated_field = "0140279EBB974905A38C47A7722FAFF6")

    private boolean hasId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.287 -0500", hash_original_field = "A905F98E55CFDEC638574FD49A14067F", hash_generated_field = "A3944B7884E3A988EBAE9C53EFFAD5F5")

    private String id_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.296 -0500", hash_original_field = "82B142B2F946F9A1DC4E5413570AA407", hash_generated_field = "CF25A53A16027E6C1439C964CFA8231E")

    private boolean hasCountryCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.299 -0500", hash_original_field = "FC23115A75478BAF69B51EBF0DF044E0", hash_generated_field = "BBE65B049C25092143E5A3703C6D33E3")

    private int countryCode_ = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.307 -0500", hash_original_field = "B0FA2D19B6DDCBEDA163E5F6FFEA67F7", hash_generated_field = "5FC44BC01719FCF066ECC548BE8A5361")

    private boolean hasInternationalPrefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.309 -0500", hash_original_field = "8A758F903D89ACA4C2330478B5AACF83", hash_generated_field = "717A913C833941AC2C547FE2DFF1FB22")

    private String internationalPrefix_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.319 -0500", hash_original_field = "94C5600B5F90EAC3F2206038AB3F3F63", hash_generated_field = "A9895E937CD8DAE0C496DBC48D2C2CEE")

    private boolean hasPreferredInternationalPrefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.321 -0500", hash_original_field = "A04E9953468865B2BD93CC65B38AC229", hash_generated_field = "CDC303EF35375A2E1F5FC52FA30A0AEF")

    private String preferredInternationalPrefix_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.331 -0500", hash_original_field = "7B686F78436DDB28297FA11CC397D8F2", hash_generated_field = "7558F68656CC64EE957040556631A4B3")

    private boolean hasNationalPrefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.333 -0500", hash_original_field = "5D2CD94C89B59FDF3CAF103EA09DDF4D", hash_generated_field = "9FD4079672B074B1C28FCBD5211F0E6E")

    private String nationalPrefix_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.343 -0500", hash_original_field = "51C6E84EC471FF0620E3800A5C556E7F", hash_generated_field = "D4784FA8A81183D66211EA3CB7EAD63D")

    private boolean hasPreferredExtnPrefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.345 -0500", hash_original_field = "A804EDC76939182B0A95C195D8AB3BC4", hash_generated_field = "F27B632A949D8FCEF65E426D0FEC59C2")

    private String preferredExtnPrefix_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.353 -0500", hash_original_field = "35619A9D71C405F8D42822DEFFA99F46", hash_generated_field = "507A8081AF30D85EF13F20C27737EE29")

    private boolean hasNationalPrefixForParsing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.356 -0500", hash_original_field = "69172098DCD8784358C8B8EAE575F46E", hash_generated_field = "46A092752488BEB0567E42ECBB5103EA")

    private String nationalPrefixForParsing_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.366 -0500", hash_original_field = "A3DA2ABA5571BE2B57DFDEF722FC63CB", hash_generated_field = "B59E7752C84471B249DCD9F9C398AFC5")

    private boolean hasNationalPrefixTransformRule;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.368 -0500", hash_original_field = "0274AE1840CD81255B83E0200F4A1E0E", hash_generated_field = "08067D30B404B72AEBA1F2484BFD694C")

    private String nationalPrefixTransformRule_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.377 -0500", hash_original_field = "99AB74DED3D22A7FE929AABB667DB9A7", hash_generated_field = "31870DDEA4297A7CAB4D169E31FFFEBE")

    private boolean hasSameMobileAndFixedLinePattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.380 -0500", hash_original_field = "B448C3CC32062224BD773EC729A8B933", hash_generated_field = "789005A5E2E7FE7FCA1F46FB6F3F7B13")

    private boolean sameMobileAndFixedLinePattern_ = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.389 -0500", hash_original_field = "7C14EF13395E49E2B119D741C71D0825", hash_generated_field = "B800AB6258E8C26EC659EA232E613974")

    private java.util.List<NumberFormat> numberFormat_ = new java.util.ArrayList<NumberFormat>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.400 -0500", hash_original_field = "22ED4BCADA1D2508660663C7FEC3B5F7", hash_generated_field = "8438C32E42D261618BF3822D8254B874")

    private java.util.List<NumberFormat> intlNumberFormat_ =
        new java.util.ArrayList<NumberFormat>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.415 -0500", hash_original_field = "F5CA89670A4113FFF107E5EE7EB98964", hash_generated_field = "30F748667FFCDF08F79F81730072A8E1")

    private boolean hasMainCountryForCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.417 -0500", hash_original_field = "2EEB04F126561BE57F3643F66A83CA9E", hash_generated_field = "7BE3C4CE079A909FDB8BCA00D97F89BF")

    private boolean mainCountryForCode_ = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.429 -0500", hash_original_field = "B961449A711B76A02C21014E893A62EC", hash_generated_field = "AE9DE5751CA76FAC5FD0690889290B59")

    private boolean hasLeadingDigits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.431 -0500", hash_original_field = "05F257CB8EDE0FA69E5C2E98EF1B348D", hash_generated_field = "A2DF202A3B5F3D62339A3B2DE2A4FAB2")

    private String leadingDigits_ = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.440 -0500", hash_original_field = "5493B2827F47DEF2323685451B92529F", hash_generated_field = "4AEC48A66912462BA0FE869D7DC85F43")

    private boolean hasLeadingZeroPossible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.442 -0500", hash_original_field = "3145313241F633B5C1F3B2FAEF7741C6", hash_generated_field = "F45DAF5712BFBE9A35415A4D733DC0FC")

    private boolean leadingZeroPossible_ = false;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.144 -0500", hash_original_method = "8411C48F959C93D1C6435DDA5C4FFBF8", hash_generated_method = "0182E170691B81D7A0703D1C83899138")
        
public PhoneMetadata() {}
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.159 -0500", hash_original_method = "573E786E141FAAA03A367F49BCA559B5", hash_generated_method = "43E331C0252E1144C5705999F59CF4BE")
        
public boolean hasGeneralDesc() { return hasGeneralDesc; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.161 -0500", hash_original_method = "F96C4A1868C09190E3C941F03A2889CB", hash_generated_method = "515A432EA61D0FBE34045B41917E49C6")
        
public PhoneNumberDesc getGeneralDesc() { return generalDesc_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.164 -0500", hash_original_method = "97D824F311B5130867761544B2540B90", hash_generated_method = "9D106909826181494798CD63D5675AE3")
        
public PhoneMetadata setGeneralDesc(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasGeneralDesc = true;
      generalDesc_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.170 -0500", hash_original_method = "0B06F02C38AE7EA6E1205EAD00F0F3D7", hash_generated_method = "B30597506A6B86B0C7F9DED657FBE7DA")
        
public boolean hasFixedLine() { return hasFixedLine; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.172 -0500", hash_original_method = "7111E9DB2C9B99769226207CB0B39C0D", hash_generated_method = "E8433C6E18484DA07B875B7DAD333654")
        
public PhoneNumberDesc getFixedLine() { return fixedLine_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.174 -0500", hash_original_method = "4E0B7145906BC721C9DE8D0C32500FC9", hash_generated_method = "4F86279683C879C729C6D1B6471BD6E6")
        
public PhoneMetadata setFixedLine(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasFixedLine = true;
      fixedLine_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.182 -0500", hash_original_method = "F5A454F163C8198EDADB6A0267665530", hash_generated_method = "01DF5F2524C7CBED55502CC6A73E71D5")
        
public boolean hasMobile() { return hasMobile; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.184 -0500", hash_original_method = "469BFC723D37FABFB9BC30DE50B7B80A", hash_generated_method = "A04C573840762CC735F9C51EDF7BD9D4")
        
public PhoneNumberDesc getMobile() { return mobile_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.186 -0500", hash_original_method = "CF0A4860566840BE9C27E4474979A50E", hash_generated_method = "C4B0AAE5C94212A5DCF8744A351C7393")
        
public PhoneMetadata setMobile(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasMobile = true;
      mobile_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.193 -0500", hash_original_method = "C6BB80AB6E7BD893E9D8810967101490", hash_generated_method = "7B91DE4DECC555701EB704846E8E024A")
        
public boolean hasTollFree() { return hasTollFree; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.196 -0500", hash_original_method = "A25CEA98E2A744A76CD23B6ECE21AB56", hash_generated_method = "A21539E97E0D97CF6F9143D6FBEE89E7")
        
public PhoneNumberDesc getTollFree() { return tollFree_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.198 -0500", hash_original_method = "46A649F605F0EC24C76169E259456A93", hash_generated_method = "879003C5C53D49A9AE64D9502ED0918B")
        
public PhoneMetadata setTollFree(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasTollFree = true;
      tollFree_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.205 -0500", hash_original_method = "82079540736B40B455CF317890B4623A", hash_generated_method = "DD9F9A4A7CA912B44083EBA01E4843E9")
        
public boolean hasPremiumRate() { return hasPremiumRate; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.208 -0500", hash_original_method = "14341C327DA8E1CAAD52FEB1F27BC133", hash_generated_method = "EE8A15D8F227259C0D20D4B28B4D7072")
        
public PhoneNumberDesc getPremiumRate() { return premiumRate_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.210 -0500", hash_original_method = "BC27E8EEE54A894FE20AA77CF35DD102", hash_generated_method = "1ED1F0968C0536C606E70F637927B6DC")
        
public PhoneMetadata setPremiumRate(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasPremiumRate = true;
      premiumRate_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.218 -0500", hash_original_method = "3FC94E6C0EA4E13DD9DFC50367AE259A", hash_generated_method = "EE40155525866AF237D42D6E576D6F4F")
        
public boolean hasSharedCost() { return hasSharedCost; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.220 -0500", hash_original_method = "1FFB14D9D02DC30D3C5835101DD9BAF0", hash_generated_method = "24712D0F15A1DDFBDAB733BA55D17F6C")
        
public PhoneNumberDesc getSharedCost() { return sharedCost_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.223 -0500", hash_original_method = "CDEC9E0DF29779C1B33ED334AA2CAB69", hash_generated_method = "8CD2753CF2F560D3B150E1F767B26296")
        
public PhoneMetadata setSharedCost(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasSharedCost = true;
      sharedCost_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.230 -0500", hash_original_method = "0212D7D16A2BAA9CCCFC0F72E5660C30", hash_generated_method = "4B61E02DDFF6BEBB912FF5845CDAB91D")
        
public boolean hasPersonalNumber() { return hasPersonalNumber; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.232 -0500", hash_original_method = "4CF811D3746F6643A77AAC306D011902", hash_generated_method = "A5F86B3791B2010280A8FEC160423314")
        
public PhoneNumberDesc getPersonalNumber() { return personalNumber_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.235 -0500", hash_original_method = "24493CAEB1946A8C79E7D00511D66307", hash_generated_method = "6772E8779407A2E2AB0B5BC7AC2EB761")
        
public PhoneMetadata setPersonalNumber(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasPersonalNumber = true;
      personalNumber_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.242 -0500", hash_original_method = "96BC6C0B8CEC8C19A5CCD809DD7C636B", hash_generated_method = "D1BE363747BADBBAB8B9FD6CBE6CBFBC")
        
public boolean hasVoip() { return hasVoip; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.245 -0500", hash_original_method = "3E7A9D2F706E69069EF64F75DD5323E7", hash_generated_method = "CD644BFA22A6EDA84F71F5160B94E5F2")
        
public PhoneNumberDesc getVoip() { return voip_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.247 -0500", hash_original_method = "5FE2D757C727FFFD1EC6F29B7720BADF", hash_generated_method = "54689933A71767B77A46CD51DEF23F33")
        
public PhoneMetadata setVoip(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasVoip = true;
      voip_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.254 -0500", hash_original_method = "ACFB2D18067CB4D678DA99A9B4C18C84", hash_generated_method = "1C3BE2BCA8DDA92187476DAA247B5CBC")
        
public boolean hasPager() { return hasPager; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.256 -0500", hash_original_method = "C20F5AA8347238E1E9DA82F58997297F", hash_generated_method = "2B3E0A8947A2ABC2769E616762770965")
        
public PhoneNumberDesc getPager() { return pager_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.258 -0500", hash_original_method = "F7E7BD7CBC5C04503F79204D035D6093", hash_generated_method = "29CAE31C40D79780374F5BDAF93C7869")
        
public PhoneMetadata setPager(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasPager = true;
      pager_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.266 -0500", hash_original_method = "7052BD1D22DD33A68E8BFBF8EF4C8D7C", hash_generated_method = "F790389A3E12C9D9417ED0D92DFDA683")
        
public boolean hasUan() { return hasUan; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.268 -0500", hash_original_method = "6E5CDB2B0554F6EDEAFB0A826808F837", hash_generated_method = "A94A143E26CF09C06FB122507072999E")
        
public PhoneNumberDesc getUan() { return uan_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.270 -0500", hash_original_method = "645A0026A31D8D600D28A5F0E2FCB775", hash_generated_method = "1E7571D97B926CE464FCA4BA53F05AEE")
        
public PhoneMetadata setUan(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasUan = true;
      uan_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.277 -0500", hash_original_method = "1D4CDC46AB20A45A27679F7FB2E14F5D", hash_generated_method = "AD21FA3944EC2C4A014516348951A9CE")
        
public boolean hasNoInternationalDialling() { return hasNoInternationalDialling; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.280 -0500", hash_original_method = "8BF24E7280AB555752CDF0AB6293C8C0", hash_generated_method = "175788BC8D56C7A1DDCBCB1567037FE2")
        
public PhoneNumberDesc getNoInternationalDialling() { return noInternationalDialling_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.282 -0500", hash_original_method = "7DCE821DB5B30DD48C6A3A37AA42A1FD", hash_generated_method = "68DF278FD64EE7AF8C5A475FC4D53344")
        
public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasNoInternationalDialling = true;
      noInternationalDialling_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.290 -0500", hash_original_method = "4B670822089DE57CBF3DD8C644F8C3E5", hash_generated_method = "A599150D5EFA57A273C0341642881FB1")
        
public boolean hasId() { return hasId; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.292 -0500", hash_original_method = "C805C797DAF63B59CBD999295B2F5158", hash_generated_method = "69E46C92D3C4BB43A711C0914DB88A47")
        
public String getId() { return id_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.294 -0500", hash_original_method = "6B3AD7A8DB5994F94639D3A9A0778D2B", hash_generated_method = "F86EF675A6B0779EA12BB9E3DC0BF79D")
        
public PhoneMetadata setId(String value) {
      hasId = true;
      id_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.301 -0500", hash_original_method = "F49410E49FF0F4105142DBDFDDA2C341", hash_generated_method = "AD6664713D77220A89A09E0596063EF4")
        
public boolean hasCountryCode() { return hasCountryCode; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.303 -0500", hash_original_method = "919900A7E94AD27066F6B024991185E0", hash_generated_method = "C37DB593B1646041EDA64981C3456204")
        
public int getCountryCode() { return countryCode_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.305 -0500", hash_original_method = "1AB7F6532DA188CC62A13C45F2B9ADF3", hash_generated_method = "5ED50221A52D9ACB5EBAE59143F556B1")
        
public PhoneMetadata setCountryCode(int value) {
      hasCountryCode = true;
      countryCode_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.312 -0500", hash_original_method = "B89BF9592A7F16BE6654C3883F9898E5", hash_generated_method = "9AB103EE9054B9749C97E3B50FFE87EC")
        
public boolean hasInternationalPrefix() { return hasInternationalPrefix; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.314 -0500", hash_original_method = "09123B0A33DF502700CE0BB29A84EB95", hash_generated_method = "0046F8E7C02E22B22DC3E83ACF1F49C9")
        
public String getInternationalPrefix() { return internationalPrefix_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.317 -0500", hash_original_method = "3DE0D2253FD6A81DEABED2BF406E5650", hash_generated_method = "3EA011B6D10DF97BC612DFDC09499CBD")
        
public PhoneMetadata setInternationalPrefix(String value) {
      hasInternationalPrefix = true;
      internationalPrefix_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.323 -0500", hash_original_method = "3A1D043D6BB606ABB758EEC975A83919", hash_generated_method = "781DE35ADA269697D865E56A447708BE")
        
public boolean hasPreferredInternationalPrefix() { return hasPreferredInternationalPrefix; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.326 -0500", hash_original_method = "3992DDBA34CC5C49CFC74CF0545FF343", hash_generated_method = "2F5D665E2C2E16E2C92A223056A77E04")
        
public String getPreferredInternationalPrefix() { return preferredInternationalPrefix_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.329 -0500", hash_original_method = "2F2A95A6FC37FC6A654CD2ED9E105058", hash_generated_method = "F1B73395F314D72E6B05C813F2F4F881")
        
public PhoneMetadata setPreferredInternationalPrefix(String value) {
      hasPreferredInternationalPrefix = true;
      preferredInternationalPrefix_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.336 -0500", hash_original_method = "3FEC8563D97FEF0C0B81201609B8C138", hash_generated_method = "156C9EA63954771E4D5CE6029C4EBF38")
        
public boolean hasNationalPrefix() { return hasNationalPrefix; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.338 -0500", hash_original_method = "3F6DDEA7E91472B57F47F7AA42FF40A4", hash_generated_method = "57850ECDEFE293E840A743DE22637115")
        
public String getNationalPrefix() { return nationalPrefix_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.340 -0500", hash_original_method = "F24C638CA5CEB8CDF3416D52787AAB8D", hash_generated_method = "19A829D140929F4CCC32EA6B1682B790")
        
public PhoneMetadata setNationalPrefix(String value) {
      hasNationalPrefix = true;
      nationalPrefix_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.347 -0500", hash_original_method = "E23165194A0E40A98A75B1CB3195C323", hash_generated_method = "8A2EC5404C0438EF39DF628CA6E42111")
        
public boolean hasPreferredExtnPrefix() { return hasPreferredExtnPrefix; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.349 -0500", hash_original_method = "54C0428B3277F86E8CEE26D4467F5D32", hash_generated_method = "2A6DFC50DDFA8AA987980C501BA7054A")
        
public String getPreferredExtnPrefix() { return preferredExtnPrefix_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.351 -0500", hash_original_method = "6AE031AAEF0021BEEE5C7C14D7E5ADEE", hash_generated_method = "EA47A8E9A3AAB4E1C875144FB60B096F")
        
public PhoneMetadata setPreferredExtnPrefix(String value) {
      hasPreferredExtnPrefix = true;
      preferredExtnPrefix_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.359 -0500", hash_original_method = "079D2F6BDFB9C83E975C341D5D3984E8", hash_generated_method = "D115F95F67719E4DFD01EA8DF6629B75")
        
public boolean hasNationalPrefixForParsing() { return hasNationalPrefixForParsing; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.361 -0500", hash_original_method = "049975D1EC97C98DFAFD92CBA7A3DB4E", hash_generated_method = "CE244CCEE36EEBE0FD84D5BFA7A64CEA")
        
public String getNationalPrefixForParsing() { return nationalPrefixForParsing_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.364 -0500", hash_original_method = "9C0BD3F3F0877996BC57F1866741042E", hash_generated_method = "D4508E703DD96450EA43AE500A889AC6")
        
public PhoneMetadata setNationalPrefixForParsing(String value) {
      hasNationalPrefixForParsing = true;
      nationalPrefixForParsing_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.370 -0500", hash_original_method = "1810BCBEB4974245D7BFFA09C69DD621", hash_generated_method = "887F25A4F2F63A81E17964868D1CEDFB")
        
public boolean hasNationalPrefixTransformRule() { return hasNationalPrefixTransformRule; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.373 -0500", hash_original_method = "55DE6447BA6383DE2B8CA08949083559", hash_generated_method = "4AE367E9086F24B5EF2C01BE81793A7F")
        
public String getNationalPrefixTransformRule() { return nationalPrefixTransformRule_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.375 -0500", hash_original_method = "F0F297723C8F168223FB62622F5A1EB6", hash_generated_method = "9F14F29F49D3916B3FCC1942A59F6B48")
        
public PhoneMetadata setNationalPrefixTransformRule(String value) {
      hasNationalPrefixTransformRule = true;
      nationalPrefixTransformRule_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.382 -0500", hash_original_method = "23B7A16EBE621B68A999B8F98C32C7FC", hash_generated_method = "279B959D7A3CEA44D41BC340C9237888")
        
public boolean hasSameMobileAndFixedLinePattern() { return hasSameMobileAndFixedLinePattern; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.384 -0500", hash_original_method = "0C8ED851B6AE0A07DB69452573173B34", hash_generated_method = "980C5DC7AA4C3D9B1D11CF35000132F1")
        
public boolean isSameMobileAndFixedLinePattern() { return sameMobileAndFixedLinePattern_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.387 -0500", hash_original_method = "4899ADA62C5B2767C955044A6A730FDD", hash_generated_method = "7205E340EBFC5F2AAFAD14021E364C25")
        
public PhoneMetadata setSameMobileAndFixedLinePattern(boolean value) {
      hasSameMobileAndFixedLinePattern = true;
      sameMobileAndFixedLinePattern_ = value;
      return this;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.391 -0500", hash_original_method = "84A1634AEDD3ABF2CF1A3014B5D415EB", hash_generated_method = "5489E9242974C50747F05F61B55C577E")
        
public java.util.List<NumberFormat> numberFormats() {
      return numberFormat_;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.393 -0500", hash_original_method = "926251D4CC15A970A4459B1AE98E21C5", hash_generated_method = "3666B5B4AD86E9A70C3C088D7882E645")
        
public int numberFormatSize() { return numberFormat_.size(); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.395 -0500", hash_original_method = "A540DB640DF9F8195853729D5B88BC06", hash_generated_method = "B10A9AF5060F80AE2ECE0D19B57CCB19")
        
public NumberFormat getNumberFormat(int index) {
      return numberFormat_.get(index);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.397 -0500", hash_original_method = "6431B417B09BF16DE184C0BF7BFD8C0A", hash_generated_method = "1A33790F0E7B4C2E6E653B2A41F20615")
        
public PhoneMetadata addNumberFormat(NumberFormat value) {
      if (value == null) {
        throw new NullPointerException();
      }
      numberFormat_.add(value);
      return this;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.403 -0500", hash_original_method = "AE158E1AC846181939D70DB177BF740E", hash_generated_method = "03B5EC9CCD8C26FC0905344395B25A9A")
        
public java.util.List<NumberFormat> intlNumberFormats() {
      return intlNumberFormat_;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.405 -0500", hash_original_method = "58F2978D59C0EB64F45AEE8E7A3A3ECF", hash_generated_method = "71647B16B8DD84C5024EB78DB2DFFE0A")
        
public int intlNumberFormatSize() { return intlNumberFormat_.size(); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.408 -0500", hash_original_method = "14BAA3A4AA80C468A085BC9B63542EE0", hash_generated_method = "89CE9AD771634420C077A2CDEC94F3CC")
        
public NumberFormat getIntlNumberFormat(int index) {
      return intlNumberFormat_.get(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.410 -0500", hash_original_method = "DDE7F201B8001F4279DAEE9969BC3EF9", hash_generated_method = "130F2C76B57CA307B96349573F9341CC")
        
public PhoneMetadata addIntlNumberFormat(NumberFormat value) {
      if (value == null) {
        throw new NullPointerException();
      }
      intlNumberFormat_.add(value);
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.413 -0500", hash_original_method = "C1C6B471737DB86E719E8005B048F8A4", hash_generated_method = "E8129561BDBBB98B75A18C1B20B32DFD")
        
public PhoneMetadata clearIntlNumberFormat() {
      intlNumberFormat_.clear();
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.420 -0500", hash_original_method = "F0A3F725FE27520DECCABEEE1451ABF4", hash_generated_method = "4BF02D3A8B8C0E764E4CA27B5E2E7665")
        
public boolean hasMainCountryForCode() { return hasMainCountryForCode; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.422 -0500", hash_original_method = "CF03E78162809AA6058F20CA8B82C717", hash_generated_method = "72D3631996F0A267403DB164DCDB985A")
        
public boolean isMainCountryForCode() { return mainCountryForCode_; }
    // Method that lets this class have the same interface as the one generated by Protocol Buffers
    // which is used by C++ build tools.
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.424 -0500", hash_original_method = "8B579A48BF103BAE8E5F2D34ABF5A62F", hash_generated_method = "0F0CDA12A0234683C4782EA470062EC6")
        
public boolean getMainCountryForCode() { return mainCountryForCode_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.427 -0500", hash_original_method = "0E977089CAAEFAD04CCCDA9E72421381", hash_generated_method = "0C3D6EE0AFF67D524837549AB77C882D")
        
public PhoneMetadata setMainCountryForCode(boolean value) {
      hasMainCountryForCode = true;
      mainCountryForCode_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.433 -0500", hash_original_method = "46DBCF13AB23890B1C354034C02AAE0D", hash_generated_method = "8B057D1EC13BC888894F7FDB1E341B3B")
        
public boolean hasLeadingDigits() { return hasLeadingDigits; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.436 -0500", hash_original_method = "BA0CBA2DFD34C6F845467DDF3F7503AD", hash_generated_method = "8FA6A1222CC588520E535620E447E7C8")
        
public String getLeadingDigits() { return leadingDigits_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.438 -0500", hash_original_method = "1B8095B1499A1300CC7FD6395528DFB9", hash_generated_method = "C0D98860E1D9CE1F34483E93E7817149")
        
public PhoneMetadata setLeadingDigits(String value) {
      hasLeadingDigits = true;
      leadingDigits_ = value;
      return this;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.444 -0500", hash_original_method = "DF6824D9CE520B4AB88B3980F12D84DC", hash_generated_method = "A72A7095808322DA7F094123541C0E5A")
        
public boolean hasLeadingZeroPossible() { return hasLeadingZeroPossible; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.447 -0500", hash_original_method = "9CE4681262676BB262003F306366B26D", hash_generated_method = "5E15296AE3E1918ED6E4F47F4F388D30")
        
public boolean isLeadingZeroPossible() { return leadingZeroPossible_; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.450 -0500", hash_original_method = "4E51759A218DB37A00D6735D1891D88D", hash_generated_method = "9810B41F2D2D1E875A016ED8A0627346")
        
public PhoneMetadata setLeadingZeroPossible(boolean value) {
      hasLeadingZeroPossible = true;
      leadingZeroPossible_ = value;
      return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.453 -0500", hash_original_method = "82C82662DE792F1D24D935E7D9A568AC", hash_generated_method = "16C03757178D7F85C1AE533A256354C4")
        
public void writeExternal(ObjectOutput objectOutput) throws IOException {
      objectOutput.writeBoolean(hasGeneralDesc);
      if (hasGeneralDesc) {
        generalDesc_.writeExternal(objectOutput);
      }
      objectOutput.writeBoolean(hasFixedLine);
      if (hasFixedLine) {
        fixedLine_.writeExternal(objectOutput);
      }
      objectOutput.writeBoolean(hasMobile);
      if (hasMobile) {
        mobile_.writeExternal(objectOutput);
      }
      objectOutput.writeBoolean(hasTollFree);
      if (hasTollFree) {
        tollFree_.writeExternal(objectOutput);
      }
      objectOutput.writeBoolean(hasPremiumRate);
      if (hasPremiumRate) {
        premiumRate_.writeExternal(objectOutput);
      }
      objectOutput.writeBoolean(hasSharedCost);
      if (hasSharedCost) {
        sharedCost_.writeExternal(objectOutput);
      }
      objectOutput.writeBoolean(hasPersonalNumber);
      if (hasPersonalNumber) {
        personalNumber_.writeExternal(objectOutput);
      }
      objectOutput.writeBoolean(hasVoip);
      if (hasVoip) {
        voip_.writeExternal(objectOutput);
      }
      objectOutput.writeBoolean(hasPager);
      if (hasPager) {
        pager_.writeExternal(objectOutput);
      }
      objectOutput.writeBoolean(hasUan);
      if (hasUan) {
        uan_.writeExternal(objectOutput);
      }
      objectOutput.writeBoolean(hasNoInternationalDialling);
      if (hasNoInternationalDialling) {
        noInternationalDialling_.writeExternal(objectOutput);
      }

      objectOutput.writeUTF(id_);
      objectOutput.writeInt(countryCode_);
      objectOutput.writeUTF(internationalPrefix_);

      objectOutput.writeBoolean(hasPreferredInternationalPrefix);
      if (hasPreferredInternationalPrefix) {
        objectOutput.writeUTF(preferredInternationalPrefix_);
      }

      objectOutput.writeBoolean(hasNationalPrefix);
      if (hasNationalPrefix) {
        objectOutput.writeUTF(nationalPrefix_);
      }

      objectOutput.writeBoolean(hasPreferredExtnPrefix);
      if (hasPreferredExtnPrefix) {
        objectOutput.writeUTF(preferredExtnPrefix_);
      }

      objectOutput.writeBoolean(hasNationalPrefixForParsing);
      if (hasNationalPrefixForParsing) {
        objectOutput.writeUTF(nationalPrefixForParsing_);
      }

      objectOutput.writeBoolean(hasNationalPrefixTransformRule);
      if (hasNationalPrefixTransformRule) {
        objectOutput.writeUTF(nationalPrefixTransformRule_);
      }

      objectOutput.writeBoolean(sameMobileAndFixedLinePattern_);

      int numberFormatSize = numberFormatSize();
      objectOutput.writeInt(numberFormatSize);
      for (int i = 0; i < numberFormatSize; i++) {
        numberFormat_.get(i).writeExternal(objectOutput);
      }

      int intlNumberFormatSize = intlNumberFormatSize();
      objectOutput.writeInt(intlNumberFormatSize);
      for (int i = 0; i < intlNumberFormatSize; i++) {
        intlNumberFormat_.get(i).writeExternal(objectOutput);
      }

      objectOutput.writeBoolean(mainCountryForCode_);

      objectOutput.writeBoolean(hasLeadingDigits);
      if (hasLeadingDigits) {
        objectOutput.writeUTF(leadingDigits_);
      }

      objectOutput.writeBoolean(leadingZeroPossible_);
    }
        
        public static final class Builder extends PhoneMetadata {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.241 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.147 -0500", hash_original_method = "FECA3DB69AA5738CC513C59EB359D04E", hash_generated_method = "BC23D2CB6074C9BBFB7F50AF1450A350")
            
public PhoneMetadata build() {
        return this;
      }
            
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.458 -0500", hash_original_method = "4D891D3CC56C8A4A25C2FA3B62E66106", hash_generated_method = "E1819FC8E322D81F7D119953C25A19CB")
        
public void readExternal(ObjectInput objectInput) throws IOException {
      boolean hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setGeneralDesc(desc);
      }
      hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setFixedLine(desc);
      }
      hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setMobile(desc);
      }
      hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setTollFree(desc);
      }
      hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setPremiumRate(desc);
      }
      hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setSharedCost(desc);
      }
      hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setPersonalNumber(desc);
      }
      hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setVoip(desc);
      }
      hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setPager(desc);
      }
      hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setUan(desc);
      }
      hasDesc = objectInput.readBoolean();
      if (hasDesc) {
        PhoneNumberDesc desc = new PhoneNumberDesc();
        desc.readExternal(objectInput);
        setNoInternationalDialling(desc);
      }

      setId(objectInput.readUTF());
      setCountryCode(objectInput.readInt());
      setInternationalPrefix(objectInput.readUTF());

      boolean hasString = objectInput.readBoolean();
      if (hasString) {
        setPreferredInternationalPrefix(objectInput.readUTF());
      }

      hasString = objectInput.readBoolean();
      if (hasString) {
        setNationalPrefix(objectInput.readUTF());
      }

      hasString = objectInput.readBoolean();
      if (hasString) {
        setPreferredExtnPrefix(objectInput.readUTF());
      }

      hasString = objectInput.readBoolean();
      if (hasString) {
        setNationalPrefixForParsing(objectInput.readUTF());
      }

      hasString = objectInput.readBoolean();
      if (hasString) {
        setNationalPrefixTransformRule(objectInput.readUTF());
      }

      setSameMobileAndFixedLinePattern(objectInput.readBoolean());

      int nationalFormatSize = objectInput.readInt();
      for (int i = 0; i < nationalFormatSize; i++) {
        NumberFormat numFormat = new NumberFormat();
        numFormat.readExternal(objectInput);
        numberFormat_.add(numFormat);
      }

      int intlNumberFormatSize = objectInput.readInt();
      for (int i = 0; i < intlNumberFormatSize; i++) {
        NumberFormat numFormat = new NumberFormat();
        numFormat.readExternal(objectInput);
        intlNumberFormat_.add(numFormat);
      }

      setMainCountryForCode(objectInput.readBoolean());

      hasString = objectInput.readBoolean();
      if (hasString) {
        setLeadingDigits(objectInput.readUTF());
      }

      setLeadingZeroPossible(objectInput.readBoolean());
    }
    }
    
    public static class PhoneMetadataCollection implements Externalizable {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.479 -0500", hash_original_method = "40C91A2B40702DA09592EFF9D16C1F5D", hash_generated_method = "9482C4B711FD5BDB71268D84C7181C9E")
        
public static Builder newBuilder() {
      return new Builder();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.468 -0500", hash_original_field = "BADD260C899A27EA5AFAD8DE17C69518", hash_generated_field = "A5C2B07DA97E1CAF36C5BF2CB3F2D1C6")

    private static final long serialVersionUID = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.481 -0500", hash_original_field = "3428B5E42448C7798A92924D079BB4EB", hash_generated_field = "3988CF3B3569C765826A81A610C2CFA8")

    private java.util.List<PhoneMetadata> metadata_ = new java.util.ArrayList<PhoneMetadata>();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.471 -0500", hash_original_method = "833FEC11FB1A703522FFE165412E2F7D", hash_generated_method = "FC5260D817B36F63FC4698A677B64BDA")
        
public PhoneMetadataCollection() {}

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.484 -0500", hash_original_method = "C5ECD645F70FA9D5A2A9EB8CBA32ADEF", hash_generated_method = "19C3C4CE823C1BC802CF8B760B7FD03C")
        
public java.util.List<PhoneMetadata> getMetadataList() {
      return metadata_;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.486 -0500", hash_original_method = "95419ED058599C84B2A0103C5C8B3F30", hash_generated_method = "71E863C649392CC9AB1BB5A6068913A6")
        
public int getMetadataCount() { return metadata_.size(); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.489 -0500", hash_original_method = "D57D52560347164C8871C87ACF1DAD2C", hash_generated_method = "6D3958DCFD67528EEEF04AB343994ADD")
        
public PhoneMetadataCollection addMetadata(PhoneMetadata value) {
      if (value == null) {
        throw new NullPointerException();
      }
      metadata_.add(value);
      return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.491 -0500", hash_original_method = "BDFB00F39A05DC0D50872248169D293E", hash_generated_method = "02A84DA131F38BB4F5CF16B6992C642D")
        
public void writeExternal(ObjectOutput objectOutput) throws IOException {
      int size = getMetadataCount();
      objectOutput.writeInt(size);
      for (int i = 0; i < size; i++) {
        metadata_.get(i).writeExternal(objectOutput);
      }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.494 -0500", hash_original_method = "FAC331B8B6AD54634EE3CFAA3149ADF1", hash_generated_method = "C4B649552829AC1EC97F82D57F2C689B")
        
public void readExternal(ObjectInput objectInput) throws IOException {
      int size = objectInput.readInt();
      for (int i = 0; i < size; i++) {
        PhoneMetadata metadata = new PhoneMetadata();
        metadata.readExternal(objectInput);
        metadata_.add(metadata);
      }
    }
        
        public static final class Builder extends PhoneMetadataCollection {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.242 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
            public Builder ()
            {
                //Synthesized constructor
            }
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.474 -0500", hash_original_method = "62075F60ED3DD2393D61C900D272662C", hash_generated_method = "99AEFF812A4620961E6ECD6C4D702C29")
            
public PhoneMetadataCollection build() {
        return this;
      }
            
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:01.496 -0500", hash_original_method = "1BB2E7D611D4F26F7F8136F4B2C1D585", hash_generated_method = "39413F0BEF1F689C121703F69DA5FE71")
        
public PhoneMetadataCollection clear() {
      metadata_.clear();
      return this;
    }
    }
    
}

