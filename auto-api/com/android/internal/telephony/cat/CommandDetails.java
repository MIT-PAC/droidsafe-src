package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

abstract class ValueObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.746 -0400", hash_original_method = "7E100E3F07653D57459750A9DAB5B7AA", hash_generated_method = "7E100E3F07653D57459750A9DAB5B7AA")
        public ValueObject ()
    {
    }


    abstract ComprehensionTlvTag getTag();

    
}

class CommandDetails extends ValueObject implements Parcelable {
    public boolean compRequired;
    public int commandNumber;
    public int typeOfCommand;
    public int commandQualifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.746 -0400", hash_original_method = "72B242645176D3C048490A6F87EF8C3E", hash_generated_method = "D119A005614DCAFC6E618543CD54EADF")
    @DSModeled(DSC.SAFE)
     CommandDetails() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.747 -0400", hash_original_method = "465BB229D9A5966C3E9ADC72C0D64377", hash_generated_method = "A06C5AC849438F0362AC8A17E9C646F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CommandDetails(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.747 -0400", hash_original_method = "C0C704DA5801253794AC36F584EC8459", hash_generated_method = "3B00F9AA6CB676703CAA32B04802F930")
    @DSModeled(DSC.SAFE)
    public ComprehensionTlvTag getTag() {
        return (ComprehensionTlvTag)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ComprehensionTlvTag.COMMAND_DETAILS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.747 -0400", hash_original_method = "0B93253C460C2EDDDD5784E156E19F28", hash_generated_method = "F708593FA1BBE57F088B8215D5C9087F")
    @DSModeled(DSC.SAFE)
    public boolean compareTo(CommandDetails other) {
        dsTaint.addTaint(other.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (this.compRequired == other.compRequired &&
                //this.commandNumber == other.commandNumber &&
                //this.commandQualifier == other.commandQualifier &&
                //this.typeOfCommand == other.typeOfCommand);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.747 -0400", hash_original_method = "27B546585D0CB89B418F4678204A3CCC", hash_generated_method = "F9D2B7F4E67D96DEADAFE35128E21A0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(commandNumber);
        dest.writeInt(typeOfCommand);
        dest.writeInt(commandQualifier);
        // ---------- Original Method ----------
        //dest.writeInt(commandNumber);
        //dest.writeInt(typeOfCommand);
        //dest.writeInt(commandQualifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.750 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static final Parcelable.Creator<CommandDetails> CREATOR = new Parcelable.Creator<CommandDetails>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.751 -0400", hash_original_method = "6632EE25D694EDC930AA977D0E0974F2", hash_generated_method = "52EAD78CBB773CB3D70AD15AE6F52D56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CommandDetails createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            CommandDetails var5A8213D4A3C29DF41062680B14CB801E_761879082 = (new CommandDetails(in));
            return (CommandDetails)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CommandDetails(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.752 -0400", hash_original_method = "F960351FBE610A581533F868670690CB", hash_generated_method = "8924E0433CBF75D41719A82B600C220A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CommandDetails[] newArray(int size) {
            dsTaint.addTaint(size);
            CommandDetails[] var8E26D03135425C73B55699F508272239_1891148506 = (new CommandDetails[size]);
            return (CommandDetails[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CommandDetails[size];
        }

        
}; //Transformed anonymous class
}

class DeviceIdentities extends ValueObject {
    public int sourceId;
    public int destinationId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.753 -0400", hash_original_method = "E028D1D3E96B0B495122457BDE13537D", hash_generated_method = "E028D1D3E96B0B495122457BDE13537D")
        public DeviceIdentities ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.754 -0400", hash_original_method = "08D7E03586C546439C1E191A295F1932", hash_generated_method = "95AB745539E2CCE1AC64BAA3297A38FB")
    @DSModeled(DSC.SAFE)
     ComprehensionTlvTag getTag() {
        return (ComprehensionTlvTag)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ComprehensionTlvTag.DEVICE_IDENTITIES;
    }

    
}

class IconId extends ValueObject {
    int recordNumber;
    boolean selfExplanatory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.755 -0400", hash_original_method = "63FB35770BFFE32ADA211216571FDFDD", hash_generated_method = "63FB35770BFFE32ADA211216571FDFDD")
        public IconId ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.756 -0400", hash_original_method = "FDA08E7237336A8674293BF7C0007438", hash_generated_method = "AF358415A2EEAECEDA4753772DC9A6B2")
    @DSModeled(DSC.SAFE)
     ComprehensionTlvTag getTag() {
        return (ComprehensionTlvTag)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ComprehensionTlvTag.ICON_ID;
    }

    
}

class ItemsIconId extends ValueObject {
    int [] recordNumbers;
    boolean selfExplanatory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.756 -0400", hash_original_method = "19B6F5C763CC6A757252424C962E0610", hash_generated_method = "19B6F5C763CC6A757252424C962E0610")
        public ItemsIconId ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.756 -0400", hash_original_method = "7B0D04191966D298CC63DF323042C1B7", hash_generated_method = "1D77812F688A1AEADA1B7B62573F2F9D")
    @DSModeled(DSC.SAFE)
     ComprehensionTlvTag getTag() {
        return (ComprehensionTlvTag)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ComprehensionTlvTag.ITEM_ICON_ID_LIST;
    }

    
}

