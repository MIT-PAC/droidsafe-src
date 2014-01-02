package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;





public abstract class IccFileHandler extends Handler implements IccConstants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.901 -0500", hash_original_field = "C18EE6706A9CB8F70E229538207C2600", hash_generated_field = "3CC60D7DB30C18A0452D9C9FBB518575")

    static protected final int COMMAND_READ_BINARY = 0xb0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.904 -0500", hash_original_field = "75CEF4CB7A642B36C7E2FECA8361FD4A", hash_generated_field = "52CE690B836D20CF1E855B08938321D5")

    static protected final int COMMAND_UPDATE_BINARY = 0xd6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.907 -0500", hash_original_field = "78A4BAEFC51F9837FB6162CBB728F496", hash_generated_field = "BC9C2764EDA638334784F399B103E9E0")

    static protected final int COMMAND_READ_RECORD = 0xb2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.909 -0500", hash_original_field = "5EBB29FCD9AFEF22623CC393C22F9EA3", hash_generated_field = "8BF22C00B90ECE41C175F284E14EB6F8")

    static protected final int COMMAND_UPDATE_RECORD = 0xdc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.912 -0500", hash_original_field = "470909E5B06989BCFAE30E759CB693E5", hash_generated_field = "8B9C977412DD987F5424817123628799")

    static protected final int COMMAND_SEEK = 0xa2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.915 -0500", hash_original_field = "A404D2DE0D07AAC953022F1261F82E69", hash_generated_field = "9C29D11CB02119C04CD878F24FD81DAA")

    static protected final int COMMAND_GET_RESPONSE = 0xc0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.918 -0500", hash_original_field = "516F4B63F6B77592C4A864CEFD3B4B7C", hash_generated_field = "AE4A7A14F63E2E0B4D9A7D7CBC69BBF3")

    static protected final int READ_RECORD_MODE_ABSOLUTE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.920 -0500", hash_original_field = "8C98A4FB4104520D8A49747571DD3F0E", hash_generated_field = "B134B87914AE417BA97C107B99B8CDB9")

    static protected final int EF_TYPE_TRANSPARENT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.923 -0500", hash_original_field = "2D0E397D464DC4164B40D681B3B9E34F", hash_generated_field = "6E3709AF8775D792AC4A070C596F9861")

    static protected final int EF_TYPE_LINEAR_FIXED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.925 -0500", hash_original_field = "F418EC5838D92B308309F623C086E187", hash_generated_field = "2394B70D9734050F861A3B3CB5C98303")

    static protected final int EF_TYPE_CYCLIC = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.928 -0500", hash_original_field = "355D08BDCE5315911FFCB07E45CB0250", hash_generated_field = "4F6A96AD1CFA7A0B6F5F28A0AF40A03E")

    static protected final int TYPE_RFU = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.930 -0500", hash_original_field = "F2D6F7AB4370B7D6A2648CE732689E8B", hash_generated_field = "C12E1BA59E42BE4005DF2464AFF7BDD8")

    static protected final int TYPE_MF  = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.933 -0500", hash_original_field = "F6D3AD6023279028C525B78E222B82ED", hash_generated_field = "17EDC54C4C805341C1E3BD385DADBD3F")

    static protected final int TYPE_DF  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.935 -0500", hash_original_field = "5C64AD41F61175848F3460BAD530C94B", hash_generated_field = "A3CD59D6127DE19679D87A08B2F34045")

    static protected final int TYPE_EF  = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.938 -0500", hash_original_field = "03CCE3A591C34F7F690DA2FFD82C0069", hash_generated_field = "8B5DF3D8E3782991E722AD74CEABBA98")

    static protected final int GET_RESPONSE_EF_SIZE_BYTES = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.941 -0500", hash_original_field = "F0E19073ED737C45DAA4C16FD3BE0647", hash_generated_field = "5F8D8623CED36DF566DA8C82F1CFAEAB")

    static protected final int GET_RESPONSE_EF_IMG_SIZE_BYTES = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.943 -0500", hash_original_field = "E3A78CCE65EB7874F0821A147212ABFA", hash_generated_field = "C6A23F2855CF12ACA04A6D0C86A3A872")

    // Refer TS 51.011 Section 9.2.1
    static protected final int RESPONSE_DATA_RFU_1 = 0;

    
    static class LoadLinearFixedContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.006 -0500", hash_original_field = "48F4A49B3891A623660D9D89A749D7FD", hash_generated_field = "48F4A49B3891A623660D9D89A749D7FD")


        int efid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.113 -0400", hash_original_field = "CA295049F4D4B86A33AD27D536F404C9", hash_generated_field = "448A06525EF8C132E28A8573FF9B2600")

        int recordNum;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.113 -0400", hash_original_field = "5BF8005FBC54CBD8FD3B1DD07A722DAC", hash_generated_field = "F30A01C2B6ADD522369D460AF8A04CE9")

        int recordSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.113 -0400", hash_original_field = "2F5F454F98EAFD8B6FA7B7DDD9C0D375", hash_generated_field = "8940C0F4994601D31321FD5647CCE2C9")

        int countRecords;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.010 -0500", hash_original_field = "3FC49A57EDDE4CDC0FE7CAB1D79A6EF9", hash_generated_field = "3FC49A57EDDE4CDC0FE7CAB1D79A6EF9")

        boolean loadAll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.012 -0500", hash_original_field = "20B78D0A5BE6006623DEB5273A81CD7C", hash_generated_field = "20B78D0A5BE6006623DEB5273A81CD7C")


        Message onLoaded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.015 -0500", hash_original_field = "0881DA448D3638C35BB652108D0CFFA3", hash_generated_field = "0881DA448D3638C35BB652108D0CFFA3")


        ArrayList<byte[]> results;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.017 -0500", hash_original_method = "51FF1105D833FA23AFEA102913139717", hash_generated_method = "51FF1105D833FA23AFEA102913139717")
        
LoadLinearFixedContext(int efid, int recordNum, Message onLoaded) {
            this.efid = efid;
            this.recordNum = recordNum;
            this.onLoaded = onLoaded;
            this.loadAll = false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.020 -0500", hash_original_method = "D730261F991D6C5434BBC408762FB0A8", hash_generated_method = "D730261F991D6C5434BBC408762FB0A8")
        
LoadLinearFixedContext(int efid, Message onLoaded) {
            this.efid = efid;
            this.recordNum = 1;
            this.loadAll = true;
            this.onLoaded = onLoaded;
        }

        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.946 -0500", hash_original_field = "5EEFA1A4E949E7A24F1ADAEC4569BF53", hash_generated_field = "B4E1945F68B64B65F65ABDC4D0578A48")

    static protected final int RESPONSE_DATA_RFU_2 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.948 -0500", hash_original_field = "E41539C17DE964812150F25E7D64EC32", hash_generated_field = "8FF5EBA412756AC6E802E2BAC0FBDAED")


    static protected final int RESPONSE_DATA_FILE_SIZE_1 = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.951 -0500", hash_original_field = "688F29657079B7BD6AEE8211DD5E283D", hash_generated_field = "DDB49D3A31C04577F0DB449EF1DD0448")

    static protected final int RESPONSE_DATA_FILE_SIZE_2 = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.953 -0500", hash_original_field = "314700CBFE3E084E4DD66E074EE50EB7", hash_generated_field = "7E722ABC4E41AE1CC40344A1978E9C0B")


    static protected final int RESPONSE_DATA_FILE_ID_1 = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.957 -0500", hash_original_field = "DD4C10B951B7EE9A9C4BAAB3DEA0CD04", hash_generated_field = "0AA73A2D770760EB67EB3D4FD789E7A4")

    static protected final int RESPONSE_DATA_FILE_ID_2 = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.959 -0500", hash_original_field = "F35541A0952C3720AF7D0CE4E3AEC0FB", hash_generated_field = "BA1B7DC7209FCB1EF51F72F887933559")

    static protected final int RESPONSE_DATA_FILE_TYPE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.961 -0500", hash_original_field = "4D12A13F05E493442D225FD6C6E77029", hash_generated_field = "8AA9EB145B76A6BF1DCD4275917932B3")

    static protected final int RESPONSE_DATA_RFU_3 = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.964 -0500", hash_original_field = "07DAEFDE069EE9183AB83F57AF94DA0A", hash_generated_field = "DE14F002E7E80FE2825FEC61B0815958")

    static protected final int RESPONSE_DATA_ACCESS_CONDITION_1 = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.966 -0500", hash_original_field = "941ECA817DBAFAF6F9AAE39FF75F0FE8", hash_generated_field = "0CF86211F8BFE346CC8DCB9949EDB3A6")

    static protected final int RESPONSE_DATA_ACCESS_CONDITION_2 = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.969 -0500", hash_original_field = "4FC3EB958E8F7A2C0147A94C59A685F0", hash_generated_field = "42ECBE4F040FEC401BC6BE7771289E30")

    static protected final int RESPONSE_DATA_ACCESS_CONDITION_3 = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.972 -0500", hash_original_field = "99D6DE06A628BADAFC57DA53D6025258", hash_generated_field = "199F3CA72C4189885796724CED0A9AEF")

    static protected final int RESPONSE_DATA_FILE_STATUS = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.975 -0500", hash_original_field = "0B403F12B1835EDCDB2036FB698D5323", hash_generated_field = "DDE70B9F41C77A0C7A9BD50EB36912CD")

    static protected final int RESPONSE_DATA_LENGTH = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.978 -0500", hash_original_field = "816D8546DFB8EC90A56E9000088DC21C", hash_generated_field = "01DFE7624519AD919AAD908A207C02D6")

    static protected final int RESPONSE_DATA_STRUCTURE = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.980 -0500", hash_original_field = "02C5E5E5848B890876B18AA0FF324DD7", hash_generated_field = "FC1BB9BEB6B9507CBA32136E897CC277")

    static protected final int RESPONSE_DATA_RECORD_LENGTH = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.983 -0500", hash_original_field = "7C8A5C01E5D0B68FBE6AD2399528439C", hash_generated_field = "E9A111AA7C3405793F606C7049665085")


    /** Finished retrieving size of transparent EF; start loading. */
    static protected final int EVENT_GET_BINARY_SIZE_DONE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.986 -0500", hash_original_field = "B9F4940356838EE86A2E3D815D0CE88F", hash_generated_field = "6417995F1CCE3BD60EA55EC5D9BAF9EB")

    static protected final int EVENT_READ_BINARY_DONE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.989 -0500", hash_original_field = "4806EE6A1E6B009B5112DE69456E7DF5", hash_generated_field = "8D7F7098D55C746BB788A8036B8F4D60")

    static protected final int EVENT_GET_RECORD_SIZE_DONE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.991 -0500", hash_original_field = "3AAEFB991C0B1315132731CD0E5072B6", hash_generated_field = "E404E9022F0FA890A46E1100E27B724F")

    static protected final int EVENT_READ_RECORD_DONE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.993 -0500", hash_original_field = "F697E7EDB1424CB78DE20EC28C1B37E8", hash_generated_field = "947A21F99F735ED86DA9B734578677CA")

    static protected final int EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.997 -0500", hash_original_field = "E2F1FC74BC68C4FF3246657B12385CF8", hash_generated_field = "E159B90A57982AF312C9C8222FA36B34")

    static protected final int EVENT_READ_IMG_DONE = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.999 -0500", hash_original_field = "887B82107035B9BC18C86389E53625AF", hash_generated_field = "545706A6E283BA9001F4AD6AECCB60D0")

    static protected final int EVENT_READ_ICON_DONE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.003 -0500", hash_original_field = "4D74BFF297E0DF8FA98FF6D8A8DBA78C", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;

    /**
     * Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.024 -0500", hash_original_method = "D43DCB164382547ACBC107CD3DAC237A", hash_generated_method = "3C228AD8CE24C521B5E0742CD18C5407")
    
protected IccFileHandler(PhoneBase phone) {
        super();
        this.phone = phone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.027 -0500", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "5EA87569AF1433DF9A5120E4976B79C1")
    
public void dispose() {
    }

    //***** Public Methods

    /**
     * Load a record from a SIM Linear Fixed EF
     *
     * @param fileid EF id
     * @param recordNum 1-based (not 0-based) record number
     * @param onLoaded
     *
     * ((AsyncResult)(onLoaded.obj)).result is the byte[]
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.029 -0500", hash_original_method = "663260DCC0AEA6DC2CA2BB2A67F595C2", hash_generated_method = "4E18EFDA09ABD07DD5FBD8A52EDF3A92")
    
public void loadEFLinearFixed(int fileid, int recordNum, Message onLoaded) {
        Message response
            = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        new LoadLinearFixedContext(fileid, recordNum, onLoaded));

        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    /**
     * Load a image instance record from a SIM Linear Fixed EF-IMG
     *
     * @param recordNum 1-based (not 0-based) record number
     * @param onLoaded
     *
     * ((AsyncResult)(onLoaded.obj)).result is the byte[]
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.033 -0500", hash_original_method = "AD3D0941CCBE990655E4D58F2671DA3B", hash_generated_method = "2F3A58B7052C1EECECDBF5F698B5CE16")
    
public void loadEFImgLinearFixed(int recordNum, Message onLoaded) {
        Message response = obtainMessage(EVENT_READ_IMG_DONE,
                new LoadLinearFixedContext(IccConstants.EF_IMG, recordNum,
                        onLoaded));

        // TODO(): Verify when path changes are done.
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, IccConstants.EF_IMG, "img",
                recordNum, READ_RECORD_MODE_ABSOLUTE,
                GET_RESPONSE_EF_IMG_SIZE_BYTES, null, null, response);
    }

    /**
     * get record size for a linear fixed EF
     *
     * @param fileid EF id
     * @param onLoaded ((AsnyncResult)(onLoaded.obj)).result is the recordSize[]
     *        int[0] is the record length int[1] is the total length of the EF
     *        file int[3] is the number of records in the EF file So int[0] *
     *        int[3] = int[1]
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.035 -0500", hash_original_method = "50E0C1880D1B176F78B29AB1FC2AC0F6", hash_generated_method = "7AEFFD11612E265524346318FFDB2510")
    
public void getEFLinearRecordSize(int fileid, Message onLoaded) {
        Message response
                = obtainMessage(EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE,
                        new LoadLinearFixedContext(fileid, onLoaded));
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                    0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    /**
     * Load all records from a SIM Linear Fixed EF
     *
     * @param fileid EF id
     * @param onLoaded
     *
     * ((AsyncResult)(onLoaded.obj)).result is an ArrayList<byte[]>
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.037 -0500", hash_original_method = "65C59C00611DFB92BBD6DFE9FDCAEDDA", hash_generated_method = "17A03CFD36DA3D14AD3DEF832F888B0B")
    
public void loadEFLinearFixedAll(int fileid, Message onLoaded) {
        Message response = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        new LoadLinearFixedContext(fileid,onLoaded));

        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    /**
     * Load a SIM Transparent EF
     *
     * @param fileid EF id
     * @param onLoaded
     *
     * ((AsyncResult)(onLoaded.obj)).result is the byte[]
     *
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.040 -0500", hash_original_method = "E6873BA2275643766469BAAFD3B2D8F2", hash_generated_method = "7CE718F0ED6CA68EA878090B385797B7")
    
public void loadEFTransparent(int fileid, Message onLoaded) {
        Message response = obtainMessage(EVENT_GET_BINARY_SIZE_DONE,
                        fileid, 0, onLoaded);

        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    /**
     * Load a SIM Transparent EF-IMG. Used right after loadEFImgLinearFixed to
     * retrive STK's icon data.
     *
     * @param fileid EF id
     * @param onLoaded
     *
     * ((AsyncResult)(onLoaded.obj)).result is the byte[]
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.042 -0500", hash_original_method = "2560A35ADA01F4B533EB0E56DA8161F2", hash_generated_method = "45B5B0CFEB8753AAC4C43014A4F4969E")
    
public void loadEFImgTransparent(int fileid, int highOffset, int lowOffset,
            int length, Message onLoaded) {
        Message response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                onLoaded);

        phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, "img", highOffset, lowOffset,
                length, null, null, response);
    }

    /**
     * Update a record in a linear fixed EF
     * @param fileid EF id
     * @param recordNum 1-based (not 0-based) record number
     * @param data must be exactly as long as the record in the EF
     * @param pin2 for CHV2 operations, otherwist must be null
     * @param onComplete onComplete.obj will be an AsyncResult
     *                   onComplete.obj.userObj will be a IccIoResult on success
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.044 -0500", hash_original_method = "FA70C1BBB046CBB00612B81948F784B1", hash_generated_method = "CE84EB325E5A57446D83DA5863F644B8")
    
public void updateEFLinearFixed(int fileid, int recordNum, byte[] data,
            String pin2, Message onComplete) {
        phone.mCM.iccIO(COMMAND_UPDATE_RECORD, fileid, getEFPath(fileid),
                        recordNum, READ_RECORD_MODE_ABSOLUTE, data.length,
                        IccUtils.bytesToHexString(data), pin2, onComplete);
    }

    /**
     * Update a transparent EF
     * @param fileid EF id
     * @param data must be exactly as long as the EF
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.047 -0500", hash_original_method = "E2C68C0F33001D18516AF5A16FEBCDCE", hash_generated_method = "B9BE3BB094C165FB24105BDAD0426014")
    
public void updateEFTransparent(int fileid, byte[] data, Message onComplete) {
        phone.mCM.iccIO(COMMAND_UPDATE_BINARY, fileid, getEFPath(fileid),
                        0, 0, data.length,
                        IccUtils.bytesToHexString(data), null, onComplete);
    }


    //***** Abstract Methods


    //***** Private Methods

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.050 -0500", hash_original_method = "75655596118E033F36F4E4359D6ED264", hash_generated_method = "011ADC436A437F29A195186F89A69206")
    
private void sendResult(Message response, Object result, Throwable ex) {
        if (response == null) {
            return;
        }

        AsyncResult.forMessage(response, result, ex);

        response.sendToTarget();
    }

    //***** Overridden from Handler

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.056 -0500", hash_original_method = "7545CD0BE0B692221088F308787036AD", hash_generated_method = "68022EB240E6BA96F678CCE680BC607D")
    
public void handleMessage(Message msg) {
        AsyncResult ar;
        IccIoResult result;
        Message response = null;
        String str;
        LoadLinearFixedContext lc;

        IccException iccException;
        byte data[];
        int size;
        int fileid;
        int recordNum;
        int recordSize[];

        try {
            switch (msg.what) {
            case EVENT_READ_IMG_DONE:
                ar = (AsyncResult) msg.obj;
                lc = (LoadLinearFixedContext) ar.userObj;
                result = (IccIoResult) ar.result;
                response = lc.onLoaded;

                iccException = result.getException();
                if (iccException != null) {
                    sendResult(response, result.payload, ar.exception);
                }
                break;
            case EVENT_READ_ICON_DONE:
                ar = (AsyncResult) msg.obj;
                response = (Message) ar.userObj;
                result = (IccIoResult) ar.result;

                iccException = result.getException();
                if (iccException != null) {
                    sendResult(response, result.payload, ar.exception);
                }
                break;
            case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE:
                ar = (AsyncResult)msg.obj;
                lc = (LoadLinearFixedContext) ar.userObj;
                result = (IccIoResult) ar.result;
                response = lc.onLoaded;

                if (ar.exception != null) {
                    sendResult(response, null, ar.exception);
                    break;
                }

                iccException = result.getException();
                if (iccException != null) {
                    sendResult(response, null, iccException);
                    break;
                }

                data = result.payload;

                if (TYPE_EF != data[RESPONSE_DATA_FILE_TYPE] ||
                    EF_TYPE_LINEAR_FIXED != data[RESPONSE_DATA_STRUCTURE]) {
                    throw new IccFileTypeMismatch();
                }

                recordSize = new int[3];
                recordSize[0] = data[RESPONSE_DATA_RECORD_LENGTH] & 0xFF;
                recordSize[1] = ((data[RESPONSE_DATA_FILE_SIZE_1] & 0xff) << 8)
                       + (data[RESPONSE_DATA_FILE_SIZE_2] & 0xff);
                recordSize[2] = recordSize[1] / recordSize[0];

                sendResult(response, recordSize, null);
                break;
             case EVENT_GET_RECORD_SIZE_DONE:
                ar = (AsyncResult)msg.obj;
                lc = (LoadLinearFixedContext) ar.userObj;
                result = (IccIoResult) ar.result;
                response = lc.onLoaded;

                if (ar.exception != null) {
                    sendResult(response, null, ar.exception);
                    break;
                }

                iccException = result.getException();

                if (iccException != null) {
                    sendResult(response, null, iccException);
                    break;
                }

                data = result.payload;
                fileid = lc.efid;
                recordNum = lc.recordNum;

                if (TYPE_EF != data[RESPONSE_DATA_FILE_TYPE]) {
                    throw new IccFileTypeMismatch();
                }

                if (EF_TYPE_LINEAR_FIXED != data[RESPONSE_DATA_STRUCTURE]) {
                    throw new IccFileTypeMismatch();
                }

                lc.recordSize = data[RESPONSE_DATA_RECORD_LENGTH] & 0xFF;

                size = ((data[RESPONSE_DATA_FILE_SIZE_1] & 0xff) << 8)
                       + (data[RESPONSE_DATA_FILE_SIZE_2] & 0xff);

                lc.countRecords = size / lc.recordSize;

                 if (lc.loadAll) {
                     lc.results = new ArrayList<byte[]>(lc.countRecords);
                 }

                 phone.mCM.iccIO(COMMAND_READ_RECORD, lc.efid, getEFPath(lc.efid),
                         lc.recordNum,
                         READ_RECORD_MODE_ABSOLUTE,
                         lc.recordSize, null, null,
                         obtainMessage(EVENT_READ_RECORD_DONE, lc));
                 break;
            case EVENT_GET_BINARY_SIZE_DONE:
                ar = (AsyncResult)msg.obj;
                response = (Message) ar.userObj;
                result = (IccIoResult) ar.result;

                if (ar.exception != null) {
                    sendResult(response, null, ar.exception);
                    break;
                }

                iccException = result.getException();

                if (iccException != null) {
                    sendResult(response, null, iccException);
                    break;
                }

                data = result.payload;

                fileid = msg.arg1;

                if (TYPE_EF != data[RESPONSE_DATA_FILE_TYPE]) {
                    throw new IccFileTypeMismatch();
                }

                if (EF_TYPE_TRANSPARENT != data[RESPONSE_DATA_STRUCTURE]) {
                    throw new IccFileTypeMismatch();
                }

                size = ((data[RESPONSE_DATA_FILE_SIZE_1] & 0xff) << 8)
                       + (data[RESPONSE_DATA_FILE_SIZE_2] & 0xff);

                phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, getEFPath(fileid),
                                0, 0, size, null, null,
                                obtainMessage(EVENT_READ_BINARY_DONE,
                                              fileid, 0, response));
            break;

            case EVENT_READ_RECORD_DONE:

                ar = (AsyncResult)msg.obj;
                lc = (LoadLinearFixedContext) ar.userObj;
                result = (IccIoResult) ar.result;
                response = lc.onLoaded;

                if (ar.exception != null) {
                    sendResult(response, null, ar.exception);
                    break;
                }

                iccException = result.getException();

                if (iccException != null) {
                    sendResult(response, null, iccException);
                    break;
                }

                if (!lc.loadAll) {
                    sendResult(response, result.payload, null);
                } else {
                    lc.results.add(result.payload);

                    lc.recordNum++;

                    if (lc.recordNum > lc.countRecords) {
                        sendResult(response, lc.results, null);
                    } else {
                        phone.mCM.iccIO(COMMAND_READ_RECORD, lc.efid, getEFPath(lc.efid),
                                    lc.recordNum,
                                    READ_RECORD_MODE_ABSOLUTE,
                                    lc.recordSize, null, null,
                                    obtainMessage(EVENT_READ_RECORD_DONE, lc));
                    }
                }

            break;

            case EVENT_READ_BINARY_DONE:
                ar = (AsyncResult)msg.obj;
                response = (Message) ar.userObj;
                result = (IccIoResult) ar.result;

                if (ar.exception != null) {
                    sendResult(response, null, ar.exception);
                    break;
                }

                iccException = result.getException();

                if (iccException != null) {
                    sendResult(response, null, iccException);
                    break;
                }

                sendResult(response, result.payload, null);
            break;

        }} catch (Exception exc) {
            if (response != null) {
                sendResult(response, null, exc);
            } else {
                loge("uncaught exception" + exc);
            }
        }
    }

    /**
     * Returns the root path of the EF file.
     * i.e returns MasterFile + DFfile as a string.
     * Ex: For EF_ADN on a SIM, it will return "3F007F10"
     * This function handles only EFids that are common to
     * RUIM, SIM, USIM and other types of Icc cards.
     *
     * @param efId
     * @return root path of the file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.059 -0500", hash_original_method = "186CFCBD54A740D0E08382313B3D28EB", hash_generated_method = "CF5B8D360BCB350AC0A0BB5F6BDA0EA6")
    
protected String getCommonIccEFPath(int efid) {
        switch(efid) {
        case EF_ADN:
        case EF_FDN:
        case EF_MSISDN:
        case EF_SDN:
        case EF_EXT1:
        case EF_EXT2:
        case EF_EXT3:
            return MF_SIM + DF_TELECOM;

        case EF_ICCID:
        case EF_PL:
            return MF_SIM;
        case EF_IMG:
            return MF_SIM + DF_TELECOM + DF_GRAPHICS;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.061 -0500", hash_original_method = "C907A749FCCFB41A918898641D1D7558", hash_generated_method = "E4EBBA2992ACA18FD1EDAABC0FC8112F")
    
protected abstract String getEFPath(int efid);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.064 -0500", hash_original_method = "A6575C85320F46E94B0F4CB5120856FE", hash_generated_method = "9B237DFCD676281237C8BE1A877AC831")
    
protected abstract void logd(String s);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.066 -0500", hash_original_method = "8503C48BD28DECE909202E8D31B4BECE", hash_generated_method = "98998146AAEFC08A350487078A6888FB")
    
protected abstract void loge(String s);
}

