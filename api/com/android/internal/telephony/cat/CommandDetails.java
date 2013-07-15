package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

abstract class ValueObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.909 -0400", hash_original_method = "E974AB10453903E872F02B47A1C2E57C", hash_generated_method = "E974AB10453903E872F02B47A1C2E57C")
    public ValueObject ()
    {
        //Synthesized constructor
    }


    abstract ComprehensionTlvTag getTag();

    
}

class CommandDetails extends ValueObject implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.909 -0400", hash_original_field = "5D8DA2DD98DEF4A10F4E851E462017EC", hash_generated_field = "B9508E75FA8998D0489709EA5C6A1FB1")

    public boolean compRequired;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.909 -0400", hash_original_field = "39D9A0D3F0F22A860FAD930A0541C9EB", hash_generated_field = "4FF1570AB5D90A3DF04BE27C2E6198CF")

    public int commandNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.909 -0400", hash_original_field = "9DD20BDF3555BC5AF0F844E31869734E", hash_generated_field = "AA185C9CE6B92C465D77C666E71B155A")

    public int typeOfCommand;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.910 -0400", hash_original_field = "4FC63F50098E8F171A8E9EA49C024E81", hash_generated_field = "013CF7208E646A4D90B7E6836636A420")

    public int commandQualifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.910 -0400", hash_original_method = "72B242645176D3C048490A6F87EF8C3E", hash_generated_method = "D119A005614DCAFC6E618543CD54EADF")
      CommandDetails() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.910 -0400", hash_original_method = "465BB229D9A5966C3E9ADC72C0D64377", hash_generated_method = "FCBCCD79B659683FAA303080B1C81EE6")
    public  CommandDetails(Parcel in) {
        compRequired = true;
        commandNumber = in.readInt();
        typeOfCommand = in.readInt();
        commandQualifier = in.readInt();
        // ---------- Original Method ----------
        //compRequired = true;
        //commandNumber = in.readInt();
        //typeOfCommand = in.readInt();
        //commandQualifier = in.readInt();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.911 -0400", hash_original_method = "C0C704DA5801253794AC36F584EC8459", hash_generated_method = "14712917A585B3C2982AF941F9965472")
    public ComprehensionTlvTag getTag() {
ComprehensionTlvTag var9DA7656155941EB638A21C9886D66E9F_99405001 =         ComprehensionTlvTag.COMMAND_DETAILS;
        var9DA7656155941EB638A21C9886D66E9F_99405001.addTaint(taint);
        return var9DA7656155941EB638A21C9886D66E9F_99405001;
        // ---------- Original Method ----------
        //return ComprehensionTlvTag.COMMAND_DETAILS;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.911 -0400", hash_original_method = "0B93253C460C2EDDDD5784E156E19F28", hash_generated_method = "D54D8CB4FE60D23E04B733A09595D900")
    public boolean compareTo(CommandDetails other) {
        addTaint(other.getTaint());
        boolean varAA7B031B4E3C0BE0425D113B87949CED_839081848 = ((this.compRequired == other.compRequired &&
                this.commandNumber == other.commandNumber &&
                this.commandQualifier == other.commandQualifier &&
                this.typeOfCommand == other.typeOfCommand));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211316016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211316016;
        // ---------- Original Method ----------
        //return (this.compRequired == other.compRequired &&
                //this.commandNumber == other.commandNumber &&
                //this.commandQualifier == other.commandQualifier &&
                //this.typeOfCommand == other.typeOfCommand);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.912 -0400", hash_original_method = "27B546585D0CB89B418F4678204A3CCC", hash_generated_method = "D009DE340B774BFB65532BD04357D388")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(commandNumber);
        dest.writeInt(typeOfCommand);
        dest.writeInt(commandQualifier);
        // ---------- Original Method ----------
        //dest.writeInt(commandNumber);
        //dest.writeInt(typeOfCommand);
        //dest.writeInt(commandQualifier);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.912 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "956DF7B09FD4F77838672A10FA9B7C62")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1624100655 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025570971 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025570971;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.912 -0400", hash_original_field = "372A8EBA2514DF3562B01F8E789F5B34", hash_generated_field = "937C374E63EDFE7BE1A8C25FF1AC469F")

    public static final Parcelable.Creator<CommandDetails> CREATOR =
                                new Parcelable.Creator<CommandDetails>() {
        public CommandDetails createFromParcel(Parcel in) {
            return new CommandDetails(in);
        }

        public CommandDetails[] newArray(int size) {
            return new CommandDetails[size];
        }
    };
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.912 -0400", hash_original_field = "52195DAE0174459C5F066FA0DF053C26", hash_generated_field = "699B24C811CA3EE9C9F2776228805ACE")

    public int sourceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.912 -0400", hash_original_field = "6A42CDBBFC8189D80836B9F8C8262EA1", hash_generated_field = "251702FDD11772E951CFF3BA87FD18DF")

    public int destinationId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.912 -0400", hash_original_method = "0DDAAF9AE8107B54D0B6867A38B9BB39", hash_generated_method = "0DDAAF9AE8107B54D0B6867A38B9BB39")
    public DeviceIdentities ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.912 -0400", hash_original_method = "08D7E03586C546439C1E191A295F1932", hash_generated_method = "31F4D0CDE4B8DB35BDC74793C72A16DF")
     ComprehensionTlvTag getTag() {
ComprehensionTlvTag var40E2ED400A74AD7725B9C37C0CB8965B_603067912 =         ComprehensionTlvTag.DEVICE_IDENTITIES;
        var40E2ED400A74AD7725B9C37C0CB8965B_603067912.addTaint(taint);
        return var40E2ED400A74AD7725B9C37C0CB8965B_603067912;
        // ---------- Original Method ----------
        //return ComprehensionTlvTag.DEVICE_IDENTITIES;
    }

    
}

class IconId extends ValueObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.913 -0400", hash_original_field = "94FFE9B9C5894C1D45DFC612B295C53B", hash_generated_field = "23F79AC71281FC94187158A5D1BA833B")

    int recordNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.913 -0400", hash_original_field = "D530082FF574F6936F8BA898B3CFD500", hash_generated_field = "6EA79FA7FE3DEAB8FB8402E06AA87A13")

    boolean selfExplanatory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.913 -0400", hash_original_method = "6C2A3A6407CD61624CE3740BB0DD1581", hash_generated_method = "6C2A3A6407CD61624CE3740BB0DD1581")
    public IconId ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.913 -0400", hash_original_method = "FDA08E7237336A8674293BF7C0007438", hash_generated_method = "54FAC0664D4D36BF9010D9879F2E7C69")
     ComprehensionTlvTag getTag() {
ComprehensionTlvTag var9A40A0A29371917EAA2F45DA4051B8A9_2012032598 =         ComprehensionTlvTag.ICON_ID;
        var9A40A0A29371917EAA2F45DA4051B8A9_2012032598.addTaint(taint);
        return var9A40A0A29371917EAA2F45DA4051B8A9_2012032598;
        // ---------- Original Method ----------
        //return ComprehensionTlvTag.ICON_ID;
    }

    
}

class ItemsIconId extends ValueObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.913 -0400", hash_original_field = "5F4CE911640D8483D8869BCBD210AA0C", hash_generated_field = "923F2D4C417CA0B2591A1FD13ED1E236")

    int [] recordNumbers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.913 -0400", hash_original_field = "D530082FF574F6936F8BA898B3CFD500", hash_generated_field = "6EA79FA7FE3DEAB8FB8402E06AA87A13")

    boolean selfExplanatory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.913 -0400", hash_original_method = "A28F5B565DAFF118B0CD8282DD5FCE83", hash_generated_method = "A28F5B565DAFF118B0CD8282DD5FCE83")
    public ItemsIconId ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.914 -0400", hash_original_method = "7B0D04191966D298CC63DF323042C1B7", hash_generated_method = "A1172FA64300355B5F94B1CD914929FF")
     ComprehensionTlvTag getTag() {
ComprehensionTlvTag var92C3009FE0AF09FE85422EE9A9D13021_1527461518 =         ComprehensionTlvTag.ITEM_ICON_ID_LIST;
        var92C3009FE0AF09FE85422EE9A9D13021_1527461518.addTaint(taint);
        return var92C3009FE0AF09FE85422EE9A9D13021_1527461518;
        // ---------- Original Method ----------
        //return ComprehensionTlvTag.ITEM_ICON_ID_LIST;
    }

    
}

