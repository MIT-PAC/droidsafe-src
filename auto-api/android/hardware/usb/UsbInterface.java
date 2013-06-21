package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class UsbInterface implements Parcelable {
    private int mId;
    private int mClass;
    private int mSubclass;
    private int mProtocol;
    private Parcelable[] mEndpoints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.130 -0400", hash_original_method = "168A662ECD22EEAD4E32FE6198805EA1", hash_generated_method = "FF48E11F3E00F60A471CC6366A8441CA")
    @DSModeled(DSC.SAFE)
    public UsbInterface(int id, int Class, int subClass, int protocol,
            Parcelable[] endpoints) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(subClass);
        dsTaint.addTaint(endpoints[0].dsTaint);
        dsTaint.addTaint(Class);
        // ---------- Original Method ----------
        //mId = id;
        //mClass = Class;
        //mSubclass = subClass;
        //mProtocol = protocol;
        //mEndpoints = endpoints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.131 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "8621FE03FADC0A3000742A4E8AF6A961")
    @DSModeled(DSC.SAFE)
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.131 -0400", hash_original_method = "3020C5CBFA8B36FE57B171E2A093C23C", hash_generated_method = "D38E79FD7E4D25E8D89771B81B987D7E")
    @DSModeled(DSC.SAFE)
    public int getInterfaceClass() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.131 -0400", hash_original_method = "7088B4DB86E16F91D699838E45BCCE2E", hash_generated_method = "06EBC1ADEC15A1F64C04AF7137FD0870")
    @DSModeled(DSC.SAFE)
    public int getInterfaceSubclass() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.131 -0400", hash_original_method = "095D314DB549CF9B46225B9A82ECAABC", hash_generated_method = "E86443CBBEF1D0331222126D3862A90C")
    @DSModeled(DSC.SAFE)
    public int getInterfaceProtocol() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.132 -0400", hash_original_method = "B83541EC17993A78C7733C982BB94257", hash_generated_method = "9C45BE4696062346CE2BB07E457FA897")
    @DSModeled(DSC.SAFE)
    public int getEndpointCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEndpoints.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.132 -0400", hash_original_method = "10BF694D0DC13FB211A1D4B783AFDCB8", hash_generated_method = "2BC55F1EEE5D0DD6F9650B4FE39C754B")
    @DSModeled(DSC.SAFE)
    public UsbEndpoint getEndpoint(int index) {
        dsTaint.addTaint(index);
        return (UsbEndpoint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (UsbEndpoint)mEndpoints[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.132 -0400", hash_original_method = "7DE8C5BE07836E58A7BC66D5916A69AB", hash_generated_method = "0E087EFC8158EF2F43F20164CE459FAC")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                //",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                //",mEndpoints=" + mEndpoints + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.132 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.133 -0400", hash_original_method = "F436F428B0571288036EC16237EC67B4", hash_generated_method = "B1C91F78BD04E2885AED752B0B83BCA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeInt(mId);
        parcel.writeInt(mClass);
        parcel.writeInt(mSubclass);
        parcel.writeInt(mProtocol);
        parcel.writeParcelableArray(mEndpoints, 0);
        // ---------- Original Method ----------
        //parcel.writeInt(mId);
        //parcel.writeInt(mClass);
        //parcel.writeInt(mSubclass);
        //parcel.writeInt(mProtocol);
        //parcel.writeParcelableArray(mEndpoints, 0);
    }

    
    public static final Parcelable.Creator<UsbInterface> CREATOR = new Parcelable.Creator<UsbInterface>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.133 -0400", hash_original_method = "3B04131A8CBD1CFB2F6A52BD485FA731", hash_generated_method = "8A6AE654927D064310DAB2BCE9BD21ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UsbInterface createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            int id;
            id = in.readInt();
            int Class;
            Class = in.readInt();
            int subClass;
            subClass = in.readInt();
            int protocol;
            protocol = in.readInt();
            Parcelable[] endpoints;
            endpoints = in.readParcelableArray(UsbEndpoint.class.getClassLoader());
            UsbInterface varEB5D8791B8302B00516F86E6144FF71B_1427786529 = (new UsbInterface(id, Class, subClass, protocol, endpoints));
            return (UsbInterface)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int id = in.readInt();
            //int Class = in.readInt();
            //int subClass = in.readInt();
            //int protocol = in.readInt();
            //Parcelable[] endpoints = in.readParcelableArray(UsbEndpoint.class.getClassLoader());
            //return new UsbInterface(id, Class, subClass, protocol, endpoints);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.133 -0400", hash_original_method = "97BF19E106D86A6196E457C3D6641932", hash_generated_method = "1E0EDDF5219437BC51A97E682260F91F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UsbInterface[] newArray(int size) {
            dsTaint.addTaint(size);
            UsbInterface[] var84069A1D5DEE7030CFBC2C108F1842CA_1612226172 = (new UsbInterface[size]);
            return (UsbInterface[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UsbInterface[size];
        }

        
}; //Transformed anonymous class
}

