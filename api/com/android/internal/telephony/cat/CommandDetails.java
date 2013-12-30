package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





abstract class ValueObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.954 -0400", hash_original_method = "E974AB10453903E872F02B47A1C2E57C", hash_generated_method = "E974AB10453903E872F02B47A1C2E57C")
    public ValueObject ()
    {
        //Synthesized constructor
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.962 -0500", hash_original_method = "212B105C30378E62FCB34D5DBAF13A51", hash_generated_method = "639F13DC8D11D22BAE465A34F5915351")
    
abstract ComprehensionTlvTag getTag();

    
}

class CommandDetails extends ValueObject implements Parcelable {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.958 -0400", hash_original_field = "372A8EBA2514DF3562B01F8E789F5B34", hash_generated_field = "937C374E63EDFE7BE1A8C25FF1AC469F")

    public static final Parcelable.Creator<CommandDetails> CREATOR =
                                new Parcelable.Creator<CommandDetails>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.989 -0500", hash_original_method = "6632EE25D694EDC930AA977D0E0974F2", hash_generated_method = "966D944AA96D3324753E78ECE54E6A34")
        
public CommandDetails createFromParcel(Parcel in) {
            return new CommandDetails(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.991 -0500", hash_original_method = "F960351FBE610A581533F868670690CB", hash_generated_method = "8708BF37816425F4B6B9EDE834D78ED1")
        
public CommandDetails[] newArray(int size) {
            return new CommandDetails[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.965 -0500", hash_original_field = "47C7A38477A19EB417FAD86F3385AB91", hash_generated_field = "B9508E75FA8998D0489709EA5C6A1FB1")

    public boolean compRequired;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.968 -0500", hash_original_field = "B535E70A1556D3749FCA3814EB14798D", hash_generated_field = "4FF1570AB5D90A3DF04BE27C2E6198CF")

    public int commandNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.970 -0500", hash_original_field = "F98FC47574C279B4A9DD8B143450D05A", hash_generated_field = "AA185C9CE6B92C465D77C666E71B155A")

    public int typeOfCommand;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.972 -0500", hash_original_field = "4A17C27BE3BF406EE5D300D196E63776", hash_generated_field = "013CF7208E646A4D90B7E6836636A420")

    public int commandQualifier;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.978 -0500", hash_original_method = "72B242645176D3C048490A6F87EF8C3E", hash_generated_method = "72B242645176D3C048490A6F87EF8C3E")
    
CommandDetails() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.983 -0500", hash_original_method = "465BB229D9A5966C3E9ADC72C0D64377", hash_generated_method = "E79D0C1782FCFD86BE86C6C98133D0E4")
    
public CommandDetails(Parcel in) {
        compRequired = true;
        commandNumber = in.readInt();
        typeOfCommand = in.readInt();
        commandQualifier = in.readInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.975 -0500", hash_original_method = "C0C704DA5801253794AC36F584EC8459", hash_generated_method = "6BA592661465FD7F1BC3FF34B79A1591")
    
public ComprehensionTlvTag getTag() {
        return ComprehensionTlvTag.COMMAND_DETAILS;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.980 -0500", hash_original_method = "0B93253C460C2EDDDD5784E156E19F28", hash_generated_method = "509F06CF64BD595348EA38C2EFCD16BB")
    
public boolean compareTo(CommandDetails other) {
        return (this.compRequired == other.compRequired &&
                this.commandNumber == other.commandNumber &&
                this.commandQualifier == other.commandQualifier &&
                this.typeOfCommand == other.typeOfCommand);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.985 -0500", hash_original_method = "27B546585D0CB89B418F4678204A3CCC", hash_generated_method = "E52F4963B5DD617448BE0CFE25CD70E8")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(commandNumber);
        dest.writeInt(typeOfCommand);
        dest.writeInt(commandQualifier);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.996 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public CommandDetails createFromParcel(Parcel in) {
            return new CommandDetails(in);
        }
    
    // orphaned legacy method
    public CommandDetails[] newArray(int size) {
            return new CommandDetails[size];
        }
    
}

class DeviceIdentities extends ValueObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.998 -0500", hash_original_field = "52DC6256AF0AB2CD621ABE3833CCD24E", hash_generated_field = "699B24C811CA3EE9C9F2776228805ACE")

    public int sourceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.001 -0500", hash_original_field = "AA8046A7962C146592410A01F45C56BF", hash_generated_field = "251702FDD11772E951CFF3BA87FD18DF")

    public int destinationId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.958 -0400", hash_original_method = "0DDAAF9AE8107B54D0B6867A38B9BB39", hash_generated_method = "0DDAAF9AE8107B54D0B6867A38B9BB39")
    public DeviceIdentities ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.004 -0500", hash_original_method = "08D7E03586C546439C1E191A295F1932", hash_generated_method = "08D7E03586C546439C1E191A295F1932")
    
ComprehensionTlvTag getTag() {
        return ComprehensionTlvTag.DEVICE_IDENTITIES;
    }

    
}

class IconId extends ValueObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.006 -0500", hash_original_field = "23F79AC71281FC94187158A5D1BA833B", hash_generated_field = "23F79AC71281FC94187158A5D1BA833B")

    int recordNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.008 -0500", hash_original_field = "6EA79FA7FE3DEAB8FB8402E06AA87A13", hash_generated_field = "6EA79FA7FE3DEAB8FB8402E06AA87A13")

    boolean selfExplanatory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.959 -0400", hash_original_method = "6C2A3A6407CD61624CE3740BB0DD1581", hash_generated_method = "6C2A3A6407CD61624CE3740BB0DD1581")
    public IconId ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.010 -0500", hash_original_method = "FDA08E7237336A8674293BF7C0007438", hash_generated_method = "FDA08E7237336A8674293BF7C0007438")
    
ComprehensionTlvTag getTag() {
        return ComprehensionTlvTag.ICON_ID;
    }

    
}

class ItemsIconId extends ValueObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.013 -0500", hash_original_field = "923F2D4C417CA0B2591A1FD13ED1E236", hash_generated_field = "923F2D4C417CA0B2591A1FD13ED1E236")

    int [] recordNumbers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.016 -0500", hash_original_field = "6EA79FA7FE3DEAB8FB8402E06AA87A13", hash_generated_field = "6EA79FA7FE3DEAB8FB8402E06AA87A13")

    boolean selfExplanatory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.959 -0400", hash_original_method = "A28F5B565DAFF118B0CD8282DD5FCE83", hash_generated_method = "A28F5B565DAFF118B0CD8282DD5FCE83")
    public ItemsIconId ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.018 -0500", hash_original_method = "7B0D04191966D298CC63DF323042C1B7", hash_generated_method = "7B0D04191966D298CC63DF323042C1B7")
    
ComprehensionTlvTag getTag() {
        return ComprehensionTlvTag.ITEM_ICON_ID_LIST;
    }

    
}

