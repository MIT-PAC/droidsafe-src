package com.android.internal.telephony.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.AsyncResult;
import android.os.Handler;
import android.util.Log;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccRecords;
import com.android.internal.telephony.gsm.SimTlv;
import java.nio.charset.Charset;
import java.util.ArrayList;
import static com.android.internal.telephony.IccConstants.EF_DOMAIN;
import static com.android.internal.telephony.IccConstants.EF_IMPI;
import static com.android.internal.telephony.IccConstants.EF_IMPU;

public final class IsimUiccRecords implements IsimRecords {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.536 -0400", hash_original_field = "76EADD29A38BB9020CFAA25983EC4F62", hash_generated_field = "DE30CC27BA99BC0F13199E25EE20093E")

    private String mIsimImpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.536 -0400", hash_original_field = "FAC771DD0720D0AC54A49AC5FFE7D99B", hash_generated_field = "6EA5B090D057D1F1F86B721FBB59C530")

    private String mIsimDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.536 -0400", hash_original_field = "9A219EC2141C43445EC17DD7D91AC487", hash_generated_field = "061DCA8790165CF888D655A104FB4EF7")

    private String[] mIsimImpu;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.536 -0400", hash_original_method = "A25994306BA700F1CD652F8E8E6DC6B3", hash_generated_method = "A25994306BA700F1CD652F8E8E6DC6B3")
    public IsimUiccRecords ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.536 -0400", hash_original_method = "65EA4CC7473CC6604A3DE8B9A82FCC11", hash_generated_method = "A580A686E12544EC522D21A3200D1AE4")
    public int fetchIsimRecords(IccFileHandler iccFh, Handler h) {
        iccFh.loadEFTransparent(EF_IMPI, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpiLoaded()));
        iccFh.loadEFLinearFixedAll(EF_IMPU, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpuLoaded()));
        iccFh.loadEFTransparent(EF_DOMAIN, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimDomainLoaded()));
        addTaint(iccFh.getTaint());
        addTaint(h.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371082786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371082786;
        // ---------- Original Method ----------
        //iccFh.loadEFTransparent(EF_IMPI, h.obtainMessage(
                //IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpiLoaded()));
        //iccFh.loadEFLinearFixedAll(EF_IMPU, h.obtainMessage(
                //IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpuLoaded()));
        //iccFh.loadEFTransparent(EF_DOMAIN, h.obtainMessage(
                //IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimDomainLoaded()));
        //return 3;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.537 -0400", hash_original_method = "6D2B5E713513F7C05BF0126DA069258E", hash_generated_method = "71749375D668833545085B2FF632AEC7")
     void log(String s) {
        Log.d(LOG_TAG, "[ISIM] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "[ISIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.537 -0400", hash_original_method = "D22606291D00D3FF31B88F1A658749A5", hash_generated_method = "8C7FFEF49AD2265CA109C917D25E8D3D")
     void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (DBG) Log.e(LOG_TAG, "[ISIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.538 -0400", hash_original_method = "0C48887FF3A7960AF9ADE0B3DADCC487", hash_generated_method = "002D96D43D95BF71F2E95251024CC1AF")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_80272178 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_80272178 = mIsimImpi;
        varB4EAC82CA7396A68D541C85D26508E83_80272178.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_80272178;
        // ---------- Original Method ----------
        //return mIsimImpi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.538 -0400", hash_original_method = "4243CC1C17FF1186628D392C9E7E1EB1", hash_generated_method = "30CCAC74BDFA7AC68EC2656EE264C3C4")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_58906363 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_58906363 = mIsimDomain;
        varB4EAC82CA7396A68D541C85D26508E83_58906363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_58906363;
        // ---------- Original Method ----------
        //return mIsimDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.539 -0400", hash_original_method = "9090A8F6ED42A9AE952A72E5A0840C23", hash_generated_method = "CA83DCBA4E25711BA944517306995A79")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_839978913 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_839978913 = (mIsimImpu != null) ? mIsimImpu.clone() : null;
        varB4EAC82CA7396A68D541C85D26508E83_839978913.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_839978913;
        // ---------- Original Method ----------
        //return (mIsimImpu != null) ? mIsimImpu.clone() : null;
    }

    
    private class EfIsimImpiLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.539 -0400", hash_original_method = "1648BD81357865C3A3E303A2434827DF", hash_generated_method = "1648BD81357865C3A3E303A2434827DF")
        public EfIsimImpiLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.540 -0400", hash_original_method = "81740E578FCC01A298E59A120ACB7A20", hash_generated_method = "F651239CE5804F6EFBAB8613A35FB0F0")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1558685542 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1558685542 = "EF_ISIM_IMPI";
            varB4EAC82CA7396A68D541C85D26508E83_1558685542.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1558685542;
            // ---------- Original Method ----------
            //return "EF_ISIM_IMPI";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.540 -0400", hash_original_method = "90A14C4AAFF433EE7EAC0700F3BB549F", hash_generated_method = "6D756D86CD3DAEA64D1E5B9D82995D0F")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            byte[] data;
            data = (byte[]) ar.result;
            mIsimImpi = isimTlvToString(data);
            log("EF_IMPI=" + mIsimImpi);
            addTaint(ar.getTaint());
            // ---------- Original Method ----------
            //byte[] data = (byte[]) ar.result;
            //mIsimImpi = isimTlvToString(data);
            //if (DUMP_RECORDS) log("EF_IMPI=" + mIsimImpi);
        }

        
    }


    
    private class EfIsimImpuLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.540 -0400", hash_original_method = "D36761040F857F140719B8DB530580FC", hash_generated_method = "D36761040F857F140719B8DB530580FC")
        public EfIsimImpuLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.548 -0400", hash_original_method = "6ACADD4D30DF15849A74BDE374634092", hash_generated_method = "5A1665969CE5DE285D304721792B575F")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1332912508 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1332912508 = "EF_ISIM_IMPU";
            varB4EAC82CA7396A68D541C85D26508E83_1332912508.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1332912508;
            // ---------- Original Method ----------
            //return "EF_ISIM_IMPU";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.584 -0400", hash_original_method = "6EEA897801EC1809D035B3B23B9DD12A", hash_generated_method = "47397DDFAB99CFDCC997C09804A76D83")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            ArrayList<byte[]> impuList;
            impuList = (ArrayList<byte[]>) ar.result;
            log("EF_IMPU record count: " + impuList.size());
            mIsimImpu = new String[impuList.size()];
            int i;
            i = 0;
            {
                Iterator<byte[]> var5BCC2EE5D00C9451553D406F293D94B3_63317553 = (impuList).iterator();
                var5BCC2EE5D00C9451553D406F293D94B3_63317553.hasNext();
                byte[] identity = var5BCC2EE5D00C9451553D406F293D94B3_63317553.next();
                {
                    String impu;
                    impu = isimTlvToString(identity);
                    log("EF_IMPU[" + i + "]=" + impu);
                    mIsimImpu[i++] = impu;
                } //End block
            } //End collapsed parenthetic
            addTaint(ar.getTaint());
            // ---------- Original Method ----------
            //ArrayList<byte[]> impuList = (ArrayList<byte[]>) ar.result;
            //if (DBG) log("EF_IMPU record count: " + impuList.size());
            //mIsimImpu = new String[impuList.size()];
            //int i = 0;
            //for (byte[] identity : impuList) {
                //String impu = isimTlvToString(identity);
                //if (DUMP_RECORDS) log("EF_IMPU[" + i + "]=" + impu);
                //mIsimImpu[i++] = impu;
            //}
        }

        
    }


    
    private class EfIsimDomainLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.584 -0400", hash_original_method = "0E7AAEB3F527509DE6629FF8F10D67B7", hash_generated_method = "0E7AAEB3F527509DE6629FF8F10D67B7")
        public EfIsimDomainLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.592 -0400", hash_original_method = "42CE7E28C1D31526FC06B2AB64B01116", hash_generated_method = "59A93AEE75A13EA68FA2D3E04222791C")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1842819914 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1842819914 = "EF_ISIM_DOMAIN";
            varB4EAC82CA7396A68D541C85D26508E83_1842819914.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1842819914;
            // ---------- Original Method ----------
            //return "EF_ISIM_DOMAIN";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.592 -0400", hash_original_method = "7C79F77549AD4915107C48F1E050653A", hash_generated_method = "5039FBA0539C7641CCE97B88CF6774D1")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            byte[] data;
            data = (byte[]) ar.result;
            mIsimDomain = isimTlvToString(data);
            log("EF_DOMAIN=" + mIsimDomain);
            addTaint(ar.getTaint());
            // ---------- Original Method ----------
            //byte[] data = (byte[]) ar.result;
            //mIsimDomain = isimTlvToString(data);
            //if (DUMP_RECORDS) log("EF_DOMAIN=" + mIsimDomain);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.592 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "122B20F52DE0D566691CB293C46EE900")

    protected static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.592 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "EA7FF8772A7B2A0121F9F6C2158F8474")

    private static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.592 -0400", hash_original_field = "67335754D34F1A97E3C5D836EF1E262E", hash_generated_field = "005C15500F67D27D68DB85218A47B78C")

    private static boolean DUMP_RECORDS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.592 -0400", hash_original_field = "52F35D2F31EF37FE0F6B7B218FB7FDA4", hash_generated_field = "9DC5F5914530880581F966F56FB662C6")

    private static int TAG_ISIM_VALUE = 0x80;
}

