package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;

public final class PhoneNumberMatch {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.983 -0500", hash_original_field = "A420862623A673AB42FCEC90A616158F", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

  private  int start;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.985 -0500", hash_original_field = "3F1856C6499EED7D4325FD9564A51E14", hash_generated_field = "6456B20A1E1CCB2639ECC7BC4AF85249")

  private  String rawString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.988 -0500", hash_original_field = "58D3212316F184CF0BABA7FD24F567F3", hash_generated_field = "DFCB3B49B2D60B2C16CC443A648E9AFE")

  private  PhoneNumber number;

  /**
   * Creates a new match.
   *
   * @param start  the start index into the target text
   * @param rawString  the matched substring of the target text
   * @param number  the matched phone number
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.990 -0500", hash_original_method = "24CA5CFFCC859FAC59BD892D4A4B2393", hash_generated_method = "24CA5CFFCC859FAC59BD892D4A4B2393")
    
PhoneNumberMatch(int start, String rawString, PhoneNumber number) {
    if (start < 0) {
      throw new IllegalArgumentException("Start index must be >= 0.");
    }
    if (rawString == null || number == null) {
      throw new NullPointerException();
    }
    this.start = start;
    this.rawString = rawString;
    this.number = number;
  }

  /** Returns the phone number matched by the receiver. */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.992 -0500", hash_original_method = "3AF6887A924E6E03501A94FECACFA30D", hash_generated_method = "5705C3169A8CBCB52CD642431AD8E122")
    
public PhoneNumber number() {
    return number;
  }

  /** Returns the start index of the matched phone number within the searched text. */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.995 -0500", hash_original_method = "5948F380AB147474B7B360324D01D8A7", hash_generated_method = "7FA79083EB7878F2305A2D359E08DEAD")
    
public int start() {
    return start;
  }

  /** Returns the exclusive end index of the matched phone number within the searched text. */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.997 -0500", hash_original_method = "7D10A3C1D28519413DA457C01967C482", hash_generated_method = "1F98BC8BED2EF7A2C0F459271E3FDBDD")
    
public int end() {
    return start + rawString.length();
  }

  /** Returns the raw string matched as a phone number in the searched text. */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.999 -0500", hash_original_method = "9FB54278FE2075E29BA0E55156E431DE", hash_generated_method = "3E5BA0005B7D6387F8EA073D83361BE0")
    
public String rawString() {
    return rawString;
  }

  @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.001 -0500", hash_original_method = "13786FFFFB16751EA6F3DAD6D70C98CC", hash_generated_method = "8917298BE59ABD6AC07D2881E908FEAF")
    
@Override
  public int hashCode() {
    return Arrays.hashCode(new Object[]{start, rawString, number});
  }

  @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.004 -0500", hash_original_method = "38076D29780FBE1507C47919C30AB86E", hash_generated_method = "CE8956F7DE5C6E74F4830B1F5F710D53")
    
@Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof PhoneNumberMatch)) {
      return false;
    }
    PhoneNumberMatch other = (PhoneNumberMatch) obj;
    return rawString.equals(other.rawString) && (start == other.start) &&
        number.equals(other.number);
  }

  @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:06.007 -0500", hash_original_method = "9E681ADFB274F0FD80239D8E6C0D9096", hash_generated_method = "66D6108A1D76054128827513A7C03B91")
    
@Override
  public String toString() {
    return "PhoneNumberMatch [" + start() + "," + end() + ") " + rawString;
  }
    
}

