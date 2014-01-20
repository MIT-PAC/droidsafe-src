package com.android.internal.telephony.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static com.android.internal.telephony.IccConstants.EF_DOMAIN;
import static com.android.internal.telephony.IccConstants.EF_IMPI;
import static com.android.internal.telephony.IccConstants.EF_IMPU;

import java.nio.charset.Charset;
import java.util.ArrayList;

import android.os.AsyncResult;
import android.os.Handler;
import android.util.Log;

import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccRecords;
import com.android.internal.telephony.gsm.SimTlv;

public final class IsimUiccRecords implements IsimRecords {

    /**
     * ISIM records for IMS are stored inside a Tag-Length-Value record as a UTF-8 string
     * with tag value 0x80.
     * @param record the byte array containing the IMS data string
     * @return the decoded String value, or null if the record can't be decoded
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.932 -0500", hash_original_method = "5678F2B610228E0CE45D092607B03827", hash_generated_method = "7B2C35C921BBD0175CC55FEA5D981832")
    
private static String isimTlvToString(byte[] record) {
        SimTlv tlv = new SimTlv(record, 0, record.length);
        do {
            if (tlv.getTag() == TAG_ISIM_VALUE) {
                return new String(tlv.getData(), Charset.forName("UTF-8"));
            }
        } while (tlv.nextObject());

        Log.e(LOG_TAG, "[ISIM] can't find TLV tag in ISIM record, returning null");
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.887 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "BD940BC52C3AB14198F71CB81F0E8FEB")

    protected static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.890 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.892 -0500", hash_original_field = "A801B080FC32C407303ECD95F44B4B09", hash_generated_field = "8B06C3B6BF00D7D43F66466D5AB2B4FD")

    private static final boolean DUMP_RECORDS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.902 -0500", hash_original_field = "97EB25C2FC030AEC10C399DBFFED2F08", hash_generated_field = "C529ECF6947054FFE9397A031D3E9F83")

    private static final int TAG_ISIM_VALUE = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.894 -0500", hash_original_field = "56FDD97A14BCF33E2D548C9AE873CBA8", hash_generated_field = "A9ECD0E19F7F14AD629B9D31DB6A0C3B")

    // ISIM EF records (see 3GPP TS 31.103)
    private String mIsimImpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.897 -0500", hash_original_field = "EC9A4EAC2C9A76306CF971C1AB07119F", hash_generated_field = "6EA5B090D057D1F1F86B721FBB59C530")

    private String mIsimDomain;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.899 -0500", hash_original_field = "C39C0494F0B7438601F3B378172F16AD", hash_generated_field = "061DCA8790165CF888D655A104FB4EF7")

    private String[] mIsimImpu;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.045 -0400", hash_original_method = "A25994306BA700F1CD652F8E8E6DC6B3", hash_generated_method = "A25994306BA700F1CD652F8E8E6DC6B3")
    public IsimUiccRecords ()
    {
        //Synthesized constructor
    }

    /**
     * Request the ISIM records to load.
     * @param iccFh the IccFileHandler to load the records from
     * @param h the Handler to which the response message will be sent
     * @return the number of EF record requests that were added
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.928 -0500", hash_original_method = "65EA4CC7473CC6604A3DE8B9A82FCC11", hash_generated_method = "2C399FBFF5BF16C5903F56ED85D3BCE5")
    
public int fetchIsimRecords(IccFileHandler iccFh, Handler h) {
        iccFh.loadEFTransparent(EF_IMPI, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpiLoaded()));
        iccFh.loadEFLinearFixedAll(EF_IMPU, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpuLoaded()));
        iccFh.loadEFTransparent(EF_DOMAIN, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimDomainLoaded()));
        return 3;   // number of EF record load requests
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.934 -0500", hash_original_method = "6D2B5E713513F7C05BF0126DA069258E", hash_generated_method = "6D2B5E713513F7C05BF0126DA069258E")
    
void log(String s) {
        if (DBG) Log.d(LOG_TAG, "[ISIM] " + s);
    }
    
    private class EfIsimImpiLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.050 -0400", hash_original_method = "1648BD81357865C3A3E303A2434827DF", hash_generated_method = "1648BD81357865C3A3E303A2434827DF")
        public EfIsimImpiLoaded ()
        {
            //Synthesized constructor
        }
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.905 -0500", hash_original_method = "81740E578FCC01A298E59A120ACB7A20", hash_generated_method = "BEE5E19915FCA317DBE884B194D8CD87")
        
public String getEfName() {
            return "EF_ISIM_IMPI";
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.908 -0500", hash_original_method = "90A14C4AAFF433EE7EAC0700F3BB549F", hash_generated_method = "84023554CD32A0BC15B13F51F74B42DA")
        
public void onRecordLoaded(AsyncResult ar) {
            byte[] data = (byte[]) ar.result;
            mIsimImpi = isimTlvToString(data);
            if (DUMP_RECORDS) log("EF_IMPI=" + mIsimImpi);
        }
        
    }
    
    private class EfIsimImpuLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.051 -0400", hash_original_method = "D36761040F857F140719B8DB530580FC", hash_generated_method = "D36761040F857F140719B8DB530580FC")
        public EfIsimImpuLoaded ()
        {
            //Synthesized constructor
        }
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.913 -0500", hash_original_method = "6ACADD4D30DF15849A74BDE374634092", hash_generated_method = "7D4AAE68E3498576AF02DACE532CB04F")
        
public String getEfName() {
            return "EF_ISIM_IMPU";
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.916 -0500", hash_original_method = "6EEA897801EC1809D035B3B23B9DD12A", hash_generated_method = "5E8F5FE07CDC1C576B47FA884A9259F9")
        
public void onRecordLoaded(AsyncResult ar) {
            ArrayList<byte[]> impuList = (ArrayList<byte[]>) ar.result;
            if (DBG) log("EF_IMPU record count: " + impuList.size());
            mIsimImpu = new String[impuList.size()];
            int i = 0;
            for (byte[] identity : impuList) {
                String impu = isimTlvToString(identity);
                if (DUMP_RECORDS) log("EF_IMPU[" + i + "]=" + impu);
                mIsimImpu[i++] = impu;
            }
        }
        
    }
    
    private class EfIsimDomainLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.053 -0400", hash_original_method = "0E7AAEB3F527509DE6629FF8F10D67B7", hash_generated_method = "0E7AAEB3F527509DE6629FF8F10D67B7")
        public EfIsimDomainLoaded ()
        {
            //Synthesized constructor
        }
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.921 -0500", hash_original_method = "42CE7E28C1D31526FC06B2AB64B01116", hash_generated_method = "0DEBF20B3A0FC149A864AFCF5C1CC810")
        
public String getEfName() {
            return "EF_ISIM_DOMAIN";
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.924 -0500", hash_original_method = "7C79F77549AD4915107C48F1E050653A", hash_generated_method = "8C81209F90063C3546D581BD9D231D53")
        
public void onRecordLoaded(AsyncResult ar) {
            byte[] data = (byte[]) ar.result;
            mIsimDomain = isimTlvToString(data);
            if (DUMP_RECORDS) log("EF_DOMAIN=" + mIsimDomain);
        }
        
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.936 -0500", hash_original_method = "D22606291D00D3FF31B88F1A658749A5", hash_generated_method = "D22606291D00D3FF31B88F1A658749A5")
    
void loge(String s) {
        if (DBG) Log.e(LOG_TAG, "[ISIM] " + s);
    }

    /**
     * Return the IMS private user identity (IMPI).
     * Returns null if the IMPI hasn't been loaded or isn't present on the ISIM.
     * @return the IMS private user identity string, or null if not available
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.938 -0500", hash_original_method = "0C48887FF3A7960AF9ADE0B3DADCC487", hash_generated_method = "262B6AF4C0CB2FB6F8BDFCF66BBA7630")
    
public String getIsimImpi() {
        return mIsimImpi;
    }

    /**
     * Return the IMS home network domain name.
     * Returns null if the IMS domain hasn't been loaded or isn't present on the ISIM.
     * @return the IMS home network domain name, or null if not available
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.940 -0500", hash_original_method = "4243CC1C17FF1186628D392C9E7E1EB1", hash_generated_method = "C57F990C7B2B0F2B5409D3AF146913D2")
    
public String getIsimDomain() {
        return mIsimDomain;
    }

    /**
     * Return an array of IMS public user identities (IMPU).
     * Returns null if the IMPU hasn't been loaded or isn't present on the ISIM.
     * @return an array of IMS public user identity strings, or null if not available
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.943 -0500", hash_original_method = "9090A8F6ED42A9AE952A72E5A0840C23", hash_generated_method = "87737102519F03269A9C1EC738B780F8")
    
public String[] getIsimImpu() {
        return (mIsimImpu != null) ? mIsimImpu.clone() : null;
    }
}

