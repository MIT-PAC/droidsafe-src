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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.245 -0400", hash_original_field = "76EADD29A38BB9020CFAA25983EC4F62", hash_generated_field = "DE30CC27BA99BC0F13199E25EE20093E")

    private String mIsimImpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.245 -0400", hash_original_field = "FAC771DD0720D0AC54A49AC5FFE7D99B", hash_generated_field = "6EA5B090D057D1F1F86B721FBB59C530")

    private String mIsimDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.245 -0400", hash_original_field = "9A219EC2141C43445EC17DD7D91AC487", hash_generated_field = "061DCA8790165CF888D655A104FB4EF7")

    private String[] mIsimImpu;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.245 -0400", hash_original_method = "A25994306BA700F1CD652F8E8E6DC6B3", hash_generated_method = "A25994306BA700F1CD652F8E8E6DC6B3")
    public IsimUiccRecords ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.246 -0400", hash_original_method = "65EA4CC7473CC6604A3DE8B9A82FCC11", hash_generated_method = "6D63AE30DA70DE32819850EEC7E51807")
    public int fetchIsimRecords(IccFileHandler iccFh, Handler h) {
        iccFh.loadEFTransparent(EF_IMPI, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpiLoaded()));
        iccFh.loadEFLinearFixedAll(EF_IMPU, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpuLoaded()));
        iccFh.loadEFTransparent(EF_DOMAIN, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimDomainLoaded()));
        addTaint(iccFh.getTaint());
        addTaint(h.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387604650 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387604650;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.246 -0400", hash_original_method = "6D2B5E713513F7C05BF0126DA069258E", hash_generated_method = "71749375D668833545085B2FF632AEC7")
     void log(String s) {
        Log.d(LOG_TAG, "[ISIM] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "[ISIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.250 -0400", hash_original_method = "D22606291D00D3FF31B88F1A658749A5", hash_generated_method = "8C7FFEF49AD2265CA109C917D25E8D3D")
     void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (DBG) Log.e(LOG_TAG, "[ISIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.251 -0400", hash_original_method = "0C48887FF3A7960AF9ADE0B3DADCC487", hash_generated_method = "6A54B8A7C08B4000B53529B2AAF9E4C0")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_246953021 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_246953021 = mIsimImpi;
        varB4EAC82CA7396A68D541C85D26508E83_246953021.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_246953021;
        // ---------- Original Method ----------
        //return mIsimImpi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.251 -0400", hash_original_method = "4243CC1C17FF1186628D392C9E7E1EB1", hash_generated_method = "D21DEE7BF17E3A17BDDA130F9146D6BB")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1688506849 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1688506849 = mIsimDomain;
        varB4EAC82CA7396A68D541C85D26508E83_1688506849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1688506849;
        // ---------- Original Method ----------
        //return mIsimDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.251 -0400", hash_original_method = "9090A8F6ED42A9AE952A72E5A0840C23", hash_generated_method = "4D501EEEE8F0A932CA1CEA535459B4DD")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_250298512 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_250298512 = (mIsimImpu != null) ? mIsimImpu.clone() : null;
        varB4EAC82CA7396A68D541C85D26508E83_250298512.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_250298512;
        // ---------- Original Method ----------
        //return (mIsimImpu != null) ? mIsimImpu.clone() : null;
    }

    
    private class EfIsimImpiLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.251 -0400", hash_original_method = "1648BD81357865C3A3E303A2434827DF", hash_generated_method = "1648BD81357865C3A3E303A2434827DF")
        public EfIsimImpiLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.252 -0400", hash_original_method = "81740E578FCC01A298E59A120ACB7A20", hash_generated_method = "082A3E1FB5FAD64F64F60665174D7912")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1751376321 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1751376321 = "EF_ISIM_IMPI";
            varB4EAC82CA7396A68D541C85D26508E83_1751376321.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1751376321;
            // ---------- Original Method ----------
            //return "EF_ISIM_IMPI";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.252 -0400", hash_original_method = "90A14C4AAFF433EE7EAC0700F3BB549F", hash_generated_method = "6D756D86CD3DAEA64D1E5B9D82995D0F")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.252 -0400", hash_original_method = "D36761040F857F140719B8DB530580FC", hash_generated_method = "D36761040F857F140719B8DB530580FC")
        public EfIsimImpuLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.270 -0400", hash_original_method = "6ACADD4D30DF15849A74BDE374634092", hash_generated_method = "F9716C579BE9F24BDBB986AD23D1D942")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_737843097 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_737843097 = "EF_ISIM_IMPU";
            varB4EAC82CA7396A68D541C85D26508E83_737843097.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_737843097;
            // ---------- Original Method ----------
            //return "EF_ISIM_IMPU";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.307 -0400", hash_original_method = "6EEA897801EC1809D035B3B23B9DD12A", hash_generated_method = "C6BA4327AE24EE55701126B3DDCEECE6")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            ArrayList<byte[]> impuList;
            impuList = (ArrayList<byte[]>) ar.result;
            log("EF_IMPU record count: " + impuList.size());
            mIsimImpu = new String[impuList.size()];
            int i;
            i = 0;
            {
                Iterator<byte[]> var5BCC2EE5D00C9451553D406F293D94B3_1209150303 = (impuList).iterator();
                var5BCC2EE5D00C9451553D406F293D94B3_1209150303.hasNext();
                byte[] identity = var5BCC2EE5D00C9451553D406F293D94B3_1209150303.next();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.308 -0400", hash_original_method = "0E7AAEB3F527509DE6629FF8F10D67B7", hash_generated_method = "0E7AAEB3F527509DE6629FF8F10D67B7")
        public EfIsimDomainLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.308 -0400", hash_original_method = "42CE7E28C1D31526FC06B2AB64B01116", hash_generated_method = "C0477296CB7D082A71F004907CC98948")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1660417400 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1660417400 = "EF_ISIM_DOMAIN";
            varB4EAC82CA7396A68D541C85D26508E83_1660417400.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1660417400;
            // ---------- Original Method ----------
            //return "EF_ISIM_DOMAIN";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.308 -0400", hash_original_method = "7C79F77549AD4915107C48F1E050653A", hash_generated_method = "5039FBA0539C7641CCE97B88CF6774D1")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.308 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "122B20F52DE0D566691CB293C46EE900")

    protected static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.308 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "EA7FF8772A7B2A0121F9F6C2158F8474")

    private static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.308 -0400", hash_original_field = "67335754D34F1A97E3C5D836EF1E262E", hash_generated_field = "005C15500F67D27D68DB85218A47B78C")

    private static boolean DUMP_RECORDS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.308 -0400", hash_original_field = "52F35D2F31EF37FE0F6B7B218FB7FDA4", hash_generated_field = "9DC5F5914530880581F966F56FB662C6")

    private static int TAG_ISIM_VALUE = 0x80;
}

