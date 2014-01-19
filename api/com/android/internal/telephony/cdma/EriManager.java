package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;

import com.android.internal.telephony.PhoneBase;
import com.android.internal.util.XmlUtils;

public final class EriManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.537 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "1718F4DE7305211326235C8400C02ED3")

    private static final String LOG_TAG = "CDMA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.540 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.543 -0500", hash_original_field = "F8CE2FA6EEC177FA658AF7AF6580B765", hash_generated_field = "D02AF5D06ADE430F9873A441F2773872")

    private static final boolean VDBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.545 -0500", hash_original_field = "9D9EA018F8884BE17D03C350A78CB644", hash_generated_field = "00C3C5EFF0729D5E68BE0BDCAA7114C6")

    public static final int ERI_FROM_XML          = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.548 -0500", hash_original_field = "84D2D928253E1F2C1EEBDC6516282ACA", hash_generated_field = "02B1498635DB5093BFD38B42915E1A9B")

    public static final int ERI_FROM_FILE_SYSTEM  = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.550 -0500", hash_original_field = "0D80F43E336AA0680D7DA9D2A0693737", hash_generated_field = "468B5F78F500D1FE21D0E4DF6EAF48F6")

    public static final int ERI_FROM_MODEM        = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.552 -0500", hash_original_field = "B504049739EC0253F0006BF183324917", hash_generated_field = "E7BDAD23CF4F53103B9ED94B380FFE2A")

    private PhoneBase mPhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.554 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.556 -0500", hash_original_field = "732702F7A08343930CF32768632D3EB8", hash_generated_field = "BE050A394E5DDA84CD7D9B82D09CD0DF")

    private int mEriFileSource = ERI_FROM_XML;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.558 -0500", hash_original_field = "CAD1094BC304792E69C7F6115A3FC24D", hash_generated_field = "D44D6DD6E8F17217EFA480219059C42D")

    private boolean isEriFileLoaded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.561 -0500", hash_original_field = "12F4AD4CBD2DE6DB852685AC6117016F", hash_generated_field = "F63AB3051D8F51BADF0A35205FF6E8C1")

    private EriFile mEriFile;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.569 -0500", hash_original_method = "3CF9033327C5802237473AC2EBF5A9A4", hash_generated_method = "9CEDD91AF8CFB4341EAFBE9387B971F3")
    
public EriManager(PhoneBase phone, Context context, int eriFileSource) {
        this.mPhone = phone;
        this.mContext = context;
        this.mEriFileSource = eriFileSource;
        this.mEriFile = new EriFile();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.572 -0500", hash_original_method = "E6DC952A5F138026D46EF70E48873C6A", hash_generated_method = "3272E853E63D6A165BD9DD833CBF3383")
    
public void dispose() {
        mEriFile = new EriFile();
        isEriFileLoaded = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.574 -0500", hash_original_method = "79759E789BC701587754CBB5AD9F0BEC", hash_generated_method = "3C7EF608253C170AEE60036A66D54C69")
    
public void loadEriFile() {
        switch (mEriFileSource) {
        case ERI_FROM_MODEM:
            loadEriFileFromModem();
            break;

        case ERI_FROM_FILE_SYSTEM:
            loadEriFileFromFileSystem();
            break;

        case ERI_FROM_XML:
        default:
            loadEriFileFromXml();
            break;
        }
    }

    /**
     * Load the ERI file from the MODEM through chipset specific RIL_REQUEST_OEM_HOOK
     *
     * In this case the ERI file can be updated from the Phone Support Tool available
     * from the Chipset vendor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.576 -0500", hash_original_method = "F319D2CF7E3E715B8D39AE2FABF6BF7B", hash_generated_method = "9E3644C8010B59580E039822D66A62AC")
    
private void loadEriFileFromModem() {
        // NOT IMPLEMENTED, Chipset vendor/Operator specific
    }

    /**
     * Load the ERI file from a File System file
     *
     * In this case the a Phone Support Tool to update the ERI file must be provided
     * to the Operator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.578 -0500", hash_original_method = "A745E0763E42351C9DE31AD2579A5B7C", hash_generated_method = "2E9EE1FBCA17BF52E15300F9A36ED1DF")
    
private void loadEriFileFromFileSystem() {
        // NOT IMPLEMENTED, Chipset vendor/Operator specific
    }

    /**
     * Load the ERI file from the application framework resources encoded in XML
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.583 -0500", hash_original_method = "C6A3384D5129DFA3EA95328C5EF0C849", hash_generated_method = "705A8F768F24C9110C345F97C704AEA9")
    
private void loadEriFileFromXml() {
        XmlPullParser parser = null;
        FileInputStream stream = null;
        Resources r = mContext.getResources();

        try {
            if (DBG) Log.d(LOG_TAG, "loadEriFileFromXml: check for alternate file");
            stream = new FileInputStream(
                            r.getString(com.android.internal.R.string.alternate_eri_file));
            parser = Xml.newPullParser();
            parser.setInput(stream, null);
            if (DBG) Log.d(LOG_TAG, "loadEriFileFromXml: opened alternate file");
        } catch (FileNotFoundException e) {
            if (DBG) Log.d(LOG_TAG, "loadEriFileFromXml: no alternate file");
            parser = null;
        } catch (XmlPullParserException e) {
            if (DBG) Log.d(LOG_TAG, "loadEriFileFromXml: no parser for alternate file");
            parser = null;
        }

        if (parser == null) {
            if (DBG) Log.d(LOG_TAG, "loadEriFileFromXml: open normal file");
            parser = r.getXml(com.android.internal.R.xml.eri);
        }

        try {
            XmlUtils.beginDocument(parser, "EriFile");
            mEriFile.mVersionNumber = Integer.parseInt(
                    parser.getAttributeValue(null, "VersionNumber"));
            mEriFile.mNumberOfEriEntries = Integer.parseInt(
                    parser.getAttributeValue(null, "NumberOfEriEntries"));
            mEriFile.mEriFileType = Integer.parseInt(
                    parser.getAttributeValue(null, "EriFileType"));

            int parsedEriEntries = 0;
            while(true) {
                XmlUtils.nextElement(parser);
                String name = parser.getName();
                if (name == null) {
                    if (parsedEriEntries != mEriFile.mNumberOfEriEntries)
                        Log.e(LOG_TAG, "Error Parsing ERI file: " +  mEriFile.mNumberOfEriEntries
                                + " defined, " + parsedEriEntries + " parsed!");
                    break;
                } else if (name.equals("CallPromptId")) {
                    int id = Integer.parseInt(parser.getAttributeValue(null, "Id"));
                    String text = parser.getAttributeValue(null, "CallPromptText");
                    if (id >= 0 && id <= 2) {
                        mEriFile.mCallPromptId[id] = text;
                    } else {
                        Log.e(LOG_TAG, "Error Parsing ERI file: found" + id + " CallPromptId");
                    }

                } else if (name.equals("EriInfo")) {
                    int roamingIndicator = Integer.parseInt(
                            parser.getAttributeValue(null, "RoamingIndicator"));
                    int iconIndex = Integer.parseInt(parser.getAttributeValue(null, "IconIndex"));
                    int iconMode = Integer.parseInt(parser.getAttributeValue(null, "IconMode"));
                    String eriText = parser.getAttributeValue(null, "EriText");
                    int callPromptId = Integer.parseInt(
                            parser.getAttributeValue(null, "CallPromptId"));
                    int alertId = Integer.parseInt(parser.getAttributeValue(null, "AlertId"));
                    parsedEriEntries++;
                    mEriFile.mRoamIndTable.put(roamingIndicator, new EriInfo (roamingIndicator,
                            iconIndex, iconMode, eriText, callPromptId, alertId));
                }
            }

            if (DBG) Log.d(LOG_TAG, "loadEriFileFromXml: eri parsing successful, file loaded");
            isEriFileLoaded = true;

        } catch (Exception e) {
            Log.e(LOG_TAG, "Got exception while loading ERI file.", e);
        } finally {
            if (parser instanceof XmlResourceParser) {
                ((XmlResourceParser)parser).close();
            }
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                // Ignore
            }
        }
    }

    /**
     * Returns the version of the ERI file
     *
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.585 -0500", hash_original_method = "C9469B68514D99711DF201C8FE7DFBA7", hash_generated_method = "D1E7158C97910CA51D94C509924F2A50")
    
public int getEriFileVersion() {
        return mEriFile.mVersionNumber;
    }

    /**
     * Returns the number of ERI entries parsed
     *
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.588 -0500", hash_original_method = "61A833F46D3B8953A540625C42A0EB37", hash_generated_method = "3BF13A25945591AC4447C2719D699FAB")
    
public int getEriNumberOfEntries() {
        return mEriFile.mNumberOfEriEntries;
    }

    /**
     * Returns the ERI file type value ( 0 for Phase 0, 1 for Phase 1)
     *
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.590 -0500", hash_original_method = "1FA8D7F59FB6C59B7F4FF404D7CADD99", hash_generated_method = "691B7E4EBBD1F924EBB5DC55E73A9D4A")
    
public int getEriFileType() {
        return mEriFile.mEriFileType;
    }
    
    class EriFile {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.505 -0500", hash_original_field = "50A355229BEB69A5D0974EAF2DAAD1F5", hash_generated_field = "7213E6068BB9156E973788AD57203866")

        public int mVersionNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.508 -0500", hash_original_field = "7F68781EE7955FA9B68FC91B68B82E84", hash_generated_field = "FDCC1E3B4FD2295A26ED5003CFA706F3")

        public int mNumberOfEriEntries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.510 -0500", hash_original_field = "4ADFF9D8BC5A1FB1E504695730F8EDBA", hash_generated_field = "E9576BD6C3AB66FA7A330571C9CA95FE")

        public int mEriFileType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.513 -0500", hash_original_field = "2008940DEEA07B16BFBE7630C669069B", hash_generated_field = "512550D324A14CD5B361FBEA251F64C2")

        //public int mNumberOfIconImages;               // reserved for future use
        //public int mIconImageType;                    // reserved for future use
        public String[] mCallPromptId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.516 -0500", hash_original_field = "73AE0E62CDBF1B90A44037FD18022155", hash_generated_field = "777F27FBAB0D81E98C7637CE98514EB6")

        public HashMap<Integer, EriInfo> mRoamIndTable; // Roaming Indicator Table

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.519 -0500", hash_original_method = "2EA3C22290A4E78EE72B7E98713E9994", hash_generated_method = "9A8A1D4B293D6D0EE299CBB873653772")
        
public EriFile() {
            this.mVersionNumber = -1;
            this.mNumberOfEriEntries = 0;
            this.mEriFileType = -1;
            this.mCallPromptId = new String[] { "", "", "" };
            this.mRoamIndTable = new HashMap<Integer, EriInfo>();
        }
        
    }
    
    class EriDisplayInformation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.523 -0500", hash_original_field = "08F80C000B9ED2BFAD3A7730AFC97B9F", hash_generated_field = "D41D6FF190F02ADC6B00CBC4CA09758B")

        public int mEriIconIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.525 -0500", hash_original_field = "F3778D3BB4AB4C2713DA62DD23DC006D", hash_generated_field = "567015E9F1EBB9480DDA52E1D3755433")

        public int mEriIconMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.527 -0500", hash_original_field = "FA6F739A34CD1C3B835359CAAED94C48", hash_generated_field = "FE7B91EA19745F159F421B316262311F")

        public String mEriIconText;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.530 -0500", hash_original_method = "4EF117935273C0A391AF6FA851E1F0DC", hash_generated_method = "55C29B63383E471F63AB06F677D86806")
        
public EriDisplayInformation(int eriIconIndex, int eriIconMode, String eriIconText) {
            mEriIconIndex = eriIconIndex;
            mEriIconMode = eriIconMode;
            mEriIconText = eriIconText;
        }

//        public void setParameters(int eriIconIndex, int eriIconMode, String eriIconText){
//            this.mEriIconIndex = eriIconIndex;
//            this.mEriIconMode = eriIconMode;
//            this.mEriIconText = eriIconText;
//        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.533 -0500", hash_original_method = "AD3807950D152469EF511B007C55D141", hash_generated_method = "44C2489F0578E6D3A6BB06E28BFAFFDE")
        
@Override
        public String toString() {
            return "EriDisplayInformation: {" + " IconIndex: " + mEriIconIndex + " EriIconMode: "
                    + mEriIconMode + " EriIconText: " + mEriIconText + " }";
        }
        
    }

    /**
     * Returns if the ERI file has been loaded
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.592 -0500", hash_original_method = "82EFBDE53CEDFA09C7F551715591238A", hash_generated_method = "7297BDFBC925A6851A3AFBD5F6147A71")
    
public boolean isEriFileLoaded() {
        return isEriFileLoaded;
    }

    /**
     * Returns the EriInfo record associated with roamingIndicator
     * or null if the entry is not found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.594 -0500", hash_original_method = "EC9DEB76FD43053D10B144FC41192B14", hash_generated_method = "A1B48DA814006445EF3B7BA2A031AEC4")
    
private EriInfo getEriInfo(int roamingIndicator) {
        if (mEriFile.mRoamIndTable.containsKey(roamingIndicator)) {
            return mEriFile.mRoamIndTable.get(roamingIndicator);
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.600 -0500", hash_original_method = "D2C726FAB5040CEBEF6EB4A1388860BE", hash_generated_method = "614CB7933A55EC4523D7ED1F43FB886D")
    
private EriDisplayInformation getEriDisplayInformation(int roamInd, int defRoamInd){
        EriDisplayInformation ret;

        // Carrier can use eri.xml to customize any built-in roaming display indications
        if (isEriFileLoaded) {
            EriInfo eriInfo = getEriInfo(roamInd);
            if (eriInfo != null) {
                if (VDBG) Log.v(LOG_TAG, "ERI roamInd " + roamInd + " found in ERI file");
                ret = new EriDisplayInformation(
                        eriInfo.mIconIndex,
                        eriInfo.mIconMode,
                        eriInfo.mEriText);
                return ret;
            }
        }

        switch (roamInd) {
        // Handling the standard roaming indicator (non-ERI)
        case EriInfo.ROAMING_INDICATOR_ON:
            ret = new EriDisplayInformation(
                    EriInfo.ROAMING_INDICATOR_ON,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText0).toString());
            break;

        case EriInfo.ROAMING_INDICATOR_OFF:
            ret = new EriDisplayInformation(
                    EriInfo.ROAMING_INDICATOR_OFF,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText1).toString());
            break;

        case EriInfo.ROAMING_INDICATOR_FLASH:
            ret = new EriDisplayInformation(
                    EriInfo.ROAMING_INDICATOR_FLASH,
                    EriInfo.ROAMING_ICON_MODE_FLASH,
                    mContext.getText(com.android.internal.R.string.roamingText2).toString());
            break;

        // Handling the standard ERI
        case 3:
            ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText3).toString());
            break;

        case 4:
            ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText4).toString());
            break;

        case 5:
            ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText5).toString());
            break;

        case 6:
            ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText6).toString());
            break;

        case 7:
            ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText7).toString());
            break;

        case 8:
            ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText8).toString());
            break;

        case 9:
            ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText9).toString());
            break;

        case 10:
            ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText10).toString());
            break;

        case 11:
            ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText11).toString());
            break;

        case 12:
            ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText12).toString());
            break;

        // Handling the non standard Enhanced Roaming Indicator (roamInd > 63)
        default:
            if (!isEriFileLoaded) {
                // ERI file NOT loaded
                if (DBG) Log.d(LOG_TAG, "ERI File not loaded");
                if(defRoamInd > 2) {
                    if (VDBG) Log.v(LOG_TAG, "ERI defRoamInd > 2 ...flashing");
                    ret = new EriDisplayInformation(
                            EriInfo.ROAMING_INDICATOR_FLASH,
                            EriInfo.ROAMING_ICON_MODE_FLASH,
                            mContext.getText(com.android.internal
                                                            .R.string.roamingText2).toString());
                } else {
                    if (VDBG) Log.v(LOG_TAG, "ERI defRoamInd <= 2");
                    switch (defRoamInd) {
                    case EriInfo.ROAMING_INDICATOR_ON:
                        ret = new EriDisplayInformation(
                                EriInfo.ROAMING_INDICATOR_ON,
                                EriInfo.ROAMING_ICON_MODE_NORMAL,
                                mContext.getText(com.android.internal
                                                            .R.string.roamingText0).toString());
                        break;

                    case EriInfo.ROAMING_INDICATOR_OFF:
                        ret = new EriDisplayInformation(
                                EriInfo.ROAMING_INDICATOR_OFF,
                                EriInfo.ROAMING_ICON_MODE_NORMAL,
                                mContext.getText(com.android.internal
                                                            .R.string.roamingText1).toString());
                        break;

                    case EriInfo.ROAMING_INDICATOR_FLASH:
                        ret = new EriDisplayInformation(
                                EriInfo.ROAMING_INDICATOR_FLASH,
                                EriInfo.ROAMING_ICON_MODE_FLASH,
                                mContext.getText(com.android.internal
                                                            .R.string.roamingText2).toString());
                        break;

                    default:
                        ret = new EriDisplayInformation(-1, -1, "ERI text");
                    }
                }
            } else {
                // ERI file loaded
                EriInfo eriInfo = getEriInfo(roamInd);
                EriInfo defEriInfo = getEriInfo(defRoamInd);
                if (eriInfo == null) {
                    if (VDBG) {
                        Log.v(LOG_TAG, "ERI roamInd " + roamInd
                            + " not found in ERI file ...using defRoamInd " + defRoamInd);
                    }
                    if(defEriInfo == null) {
                        Log.e(LOG_TAG, "ERI defRoamInd " + defRoamInd
                                + " not found in ERI file ...on");
                        ret = new EriDisplayInformation(
                                EriInfo.ROAMING_INDICATOR_ON,
                                EriInfo.ROAMING_ICON_MODE_NORMAL,
                                mContext.getText(com.android.internal
                                                             .R.string.roamingText0).toString());

                    } else {
                        if (VDBG) {
                            Log.v(LOG_TAG, "ERI defRoamInd " + defRoamInd + " found in ERI file");
                        }
                        ret = new EriDisplayInformation(
                                defEriInfo.mIconIndex,
                                defEriInfo.mIconMode,
                                defEriInfo.mEriText);
                    }
                } else {
                    if (VDBG) Log.v(LOG_TAG, "ERI roamInd " + roamInd + " found in ERI file");
                    ret = new EriDisplayInformation(
                            eriInfo.mIconIndex,
                            eriInfo.mIconMode,
                            eriInfo.mEriText);
                }
            }
            break;
        }
        if (VDBG) Log.v(LOG_TAG, "Displaying ERI " + ret.toString());
        return ret;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.602 -0500", hash_original_method = "0CC10569A68EA715FF25360AD6D9EC97", hash_generated_method = "0DE45E1248F6209B92F10815DEF40E4B")
    
public int getCdmaEriIconIndex(int roamInd, int defRoamInd){
        return getEriDisplayInformation(roamInd, defRoamInd).mEriIconIndex;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.604 -0500", hash_original_method = "9AB048E0DEB3BE0C35B104EC83429815", hash_generated_method = "2306462A913835AD68AEA1F9EECEAB05")
    
public int getCdmaEriIconMode(int roamInd, int defRoamInd){
        return getEriDisplayInformation(roamInd, defRoamInd).mEriIconMode;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.607 -0500", hash_original_method = "180B939948D08F85119E751A7703AC82", hash_generated_method = "840339AD107E413B35E633678D9C4D67")
    
public String getCdmaEriText(int roamInd, int defRoamInd){
        return getEriDisplayInformation(roamInd, defRoamInd).mEriIconText;
    }
}

