package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class NumberParseException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.364 -0500", hash_original_field = "D71FCBD367473EEEA673A4264EBD1059", hash_generated_field = "84B9E028BBF2DC9E5382F00380C2F272")


  private ErrorType errorType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.367 -0500", hash_original_field = "C9795C94D34B39950C581203743BD4FC", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")

  private String message;

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.369 -0500", hash_original_method = "E3BFB23E8C79BF87D1C5A9FB2A377F86", hash_generated_method = "FE3499F38EC3B6FF1FF8691C79A0540C")
    
public NumberParseException(ErrorType errorType, String message) {
    super(message);
    this.message = message;
    this.errorType = errorType;
  }

  /**
   * Returns the error type of the exception that has been thrown.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.372 -0500", hash_original_method = "D589126B13584B530A9FB2F071914799", hash_generated_method = "ED3EB31FB84E7B0B05B2E3AFA0C2E338")
    
public ErrorType getErrorType() {
    return errorType;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:05.374 -0500", hash_original_method = "6D8405A96F8D5D279CAA6C0BAAB6D3AE", hash_generated_method = "75826441FB213315B49F8F837251BF10")
    
@Override
  public String toString() {
    return "Error type: " + errorType + ". " + message;
  }

    
    public enum ErrorType {
    INVALID_COUNTRY_CODE,
    NOT_A_NUMBER,
    TOO_SHORT_AFTER_IDD,
    TOO_SHORT_NSN,
    TOO_LONG,
  }

    
}

