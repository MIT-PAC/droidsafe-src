package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Message;
import android.util.Log;
import android.util.Xml;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.util.XmlUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public final class EriManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.597 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "E7BDAD23CF4F53103B9ED94B380FFE2A")

    private PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.599 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.603 -0400", hash_original_field = "A757B28B600867D7632EA7A4EAF519EA", hash_generated_field = "BE050A394E5DDA84CD7D9B82D09CD0DF")

    private int mEriFileSource = ERI_FROM_XML;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.603 -0400", hash_original_field = "583264D6B6FB2E8327A962B767E7361D", hash_generated_field = "D44D6DD6E8F17217EFA480219059C42D")

    private boolean isEriFileLoaded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.603 -0400", hash_original_field = "368C9D55284EA57A4D72C138088A7AEA", hash_generated_field = "F63AB3051D8F51BADF0A35205FF6E8C1")

    private EriFile mEriFile;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.604 -0400", hash_original_method = "3CF9033327C5802237473AC2EBF5A9A4", hash_generated_method = "DE2FD4EC78744ED88F4F1E9E56C3186D")
    public  EriManager(PhoneBase phone, Context context, int eriFileSource) {
        this.mPhone = phone;
        this.mContext = context;
        this.mEriFileSource = eriFileSource;
        this.mEriFile = new EriFile();
        // ---------- Original Method ----------
        //this.mPhone = phone;
        //this.mContext = context;
        //this.mEriFileSource = eriFileSource;
        //this.mEriFile = new EriFile();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.604 -0400", hash_original_method = "E6DC952A5F138026D46EF70E48873C6A", hash_generated_method = "63E6418D6E31FB076F0ABE7FE7C0BC71")
    public void dispose() {
        mEriFile = new EriFile();
        isEriFileLoaded = false;
        // ---------- Original Method ----------
        //mEriFile = new EriFile();
        //isEriFileLoaded = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.605 -0400", hash_original_method = "79759E789BC701587754CBB5AD9F0BEC", hash_generated_method = "9AD1C333977B2F5366B5F750F19BD008")
    public void loadEriFile() {
        //Begin case ERI_FROM_MODEM 
        loadEriFileFromModem();
        //End case ERI_FROM_MODEM 
        //Begin case ERI_FROM_FILE_SYSTEM 
        loadEriFileFromFileSystem();
        //End case ERI_FROM_FILE_SYSTEM 
        //Begin case ERI_FROM_XML default 
        loadEriFileFromXml();
        //End case ERI_FROM_XML default 
        // ---------- Original Method ----------
        //switch (mEriFileSource) {
        //case ERI_FROM_MODEM:
            //loadEriFileFromModem();
            //break;
        //case ERI_FROM_FILE_SYSTEM:
            //loadEriFileFromFileSystem();
            //break;
        //case ERI_FROM_XML:
        //default:
            //loadEriFileFromXml();
            //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.605 -0400", hash_original_method = "F319D2CF7E3E715B8D39AE2FABF6BF7B", hash_generated_method = "E557464B9F1CB4500DE84483A9542396")
    private void loadEriFileFromModem() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.605 -0400", hash_original_method = "A745E0763E42351C9DE31AD2579A5B7C", hash_generated_method = "E7A0D2EF52E0D62B1AC03B9954F84BEF")
    private void loadEriFileFromFileSystem() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.627 -0400", hash_original_method = "C6A3384D5129DFA3EA95328C5EF0C849", hash_generated_method = "E1775A7D88909E25788F37B04C6F591B")
    private void loadEriFileFromXml() {
        XmlPullParser parser;
        parser = null;
        FileInputStream stream;
        stream = null;
        Resources r;
        r = mContext.getResources();
        try 
        {
            Log.d(LOG_TAG, "loadEriFileFromXml: check for alternate file");
            stream = new FileInputStream(
                            r.getString(com.android.internal.R.string.alternate_eri_file));
            parser = Xml.newPullParser();
            parser.setInput(stream, null);
            Log.d(LOG_TAG, "loadEriFileFromXml: opened alternate file");
        } //End block
        catch (FileNotFoundException e)
        {
            Log.d(LOG_TAG, "loadEriFileFromXml: no alternate file");
            parser = null;
        } //End block
        catch (XmlPullParserException e)
        {
            Log.d(LOG_TAG, "loadEriFileFromXml: no parser for alternate file");
            parser = null;
        } //End block
        {
            Log.d(LOG_TAG, "loadEriFileFromXml: open normal file");
            parser = r.getXml(com.android.internal.R.xml.eri);
        } //End block
        try 
        {
            XmlUtils.beginDocument(parser, "EriFile");
            mEriFile.mVersionNumber = Integer.parseInt(
                    parser.getAttributeValue(null, "VersionNumber"));
            mEriFile.mNumberOfEriEntries = Integer.parseInt(
                    parser.getAttributeValue(null, "NumberOfEriEntries"));
            mEriFile.mEriFileType = Integer.parseInt(
                    parser.getAttributeValue(null, "EriFileType"));
            int parsedEriEntries;
            parsedEriEntries = 0;
            {
                XmlUtils.nextElement(parser);
                String name;
                name = parser.getName();
                {
                    boolean varE80C698A9C3F8E5666F4303FE2067665_193504365 = (name.equals("CallPromptId"));
                    {
                        int id;
                        id = Integer.parseInt(parser.getAttributeValue(null, "Id"));
                        String text;
                        text = parser.getAttributeValue(null, "CallPromptText");
                        {
                            mEriFile.mCallPromptId[id] = text;
                        } //End block
                    } //End block
                    {
                        boolean var899A8E63ADE4001FCB3DF2C3D92C8FA5_459998916 = (name.equals("EriInfo"));
                        {
                            int roamingIndicator;
                            roamingIndicator = Integer.parseInt(
                            parser.getAttributeValue(null, "RoamingIndicator"));
                            int iconIndex;
                            iconIndex = Integer.parseInt(parser.getAttributeValue(null, "IconIndex"));
                            int iconMode;
                            iconMode = Integer.parseInt(parser.getAttributeValue(null, "IconMode"));
                            String eriText;
                            eriText = parser.getAttributeValue(null, "EriText");
                            int callPromptId;
                            callPromptId = Integer.parseInt(
                            parser.getAttributeValue(null, "CallPromptId"));
                            int alertId;
                            alertId = Integer.parseInt(parser.getAttributeValue(null, "AlertId"));
                            mEriFile.mRoamIndTable.put(roamingIndicator, new EriInfo (roamingIndicator,
                            iconIndex, iconMode, eriText, callPromptId, alertId));
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            Log.d(LOG_TAG, "loadEriFileFromXml: eri parsing successful, file loaded");
            isEriFileLoaded = true;
        } //End block
        catch (Exception e)
        { }
        finally 
        {
            {
                ((XmlResourceParser)parser).close();
            } //End block
            try 
            {
                {
                    stream.close();
                } //End block
            } //End block
            catch (IOException e)
            { }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.629 -0400", hash_original_method = "C9469B68514D99711DF201C8FE7DFBA7", hash_generated_method = "AC55C2AC67A31D99794498F49641966A")
    public int getEriFileVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257649202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257649202;
        // ---------- Original Method ----------
        //return mEriFile.mVersionNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.629 -0400", hash_original_method = "61A833F46D3B8953A540625C42A0EB37", hash_generated_method = "5AD50FEBA849391DB20F74120A00D91A")
    public int getEriNumberOfEntries() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273969685 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273969685;
        // ---------- Original Method ----------
        //return mEriFile.mNumberOfEriEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.638 -0400", hash_original_method = "1FA8D7F59FB6C59B7F4FF404D7CADD99", hash_generated_method = "4A130D41AC8F9DB1286A39529AD44077")
    public int getEriFileType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000547868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000547868;
        // ---------- Original Method ----------
        //return mEriFile.mEriFileType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.646 -0400", hash_original_method = "82EFBDE53CEDFA09C7F551715591238A", hash_generated_method = "F187F2336053DF15028A01F3CE7B1927")
    public boolean isEriFileLoaded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_342498953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_342498953;
        // ---------- Original Method ----------
        //return isEriFileLoaded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.647 -0400", hash_original_method = "EC9DEB76FD43053D10B144FC41192B14", hash_generated_method = "F1828AEB08911AB7CC92CB005452C673")
    private EriInfo getEriInfo(int roamingIndicator) {
        EriInfo varB4EAC82CA7396A68D541C85D26508E83_1056785804 = null; //Variable for return #1
        EriInfo varB4EAC82CA7396A68D541C85D26508E83_1951213941 = null; //Variable for return #2
        {
            boolean var57ABABFD2A3B3C6B754E21C0F57554B9_1134428514 = (mEriFile.mRoamIndTable.containsKey(roamingIndicator));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1056785804 = mEriFile.mRoamIndTable.get(roamingIndicator);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1951213941 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(roamingIndicator);
        EriInfo varA7E53CE21691AB073D9660D615818899_1075506606; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1075506606 = varB4EAC82CA7396A68D541C85D26508E83_1056785804;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1075506606 = varB4EAC82CA7396A68D541C85D26508E83_1951213941;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1075506606.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1075506606;
        // ---------- Original Method ----------
        //if (mEriFile.mRoamIndTable.containsKey(roamingIndicator)) {
            //return mEriFile.mRoamIndTable.get(roamingIndicator);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.675 -0400", hash_original_method = "D2C726FAB5040CEBEF6EB4A1388860BE", hash_generated_method = "CC0F4A7FF3945E09CEE9AD870D62AC42")
    private EriDisplayInformation getEriDisplayInformation(int roamInd, int defRoamInd) {
        EriDisplayInformation varB4EAC82CA7396A68D541C85D26508E83_11449243 = null; //Variable for return #1
        EriDisplayInformation varB4EAC82CA7396A68D541C85D26508E83_2135474152 = null; //Variable for return #2
        EriDisplayInformation ret;
        {
            EriInfo eriInfo;
            eriInfo = getEriInfo(roamInd);
            {
                ret = new EriDisplayInformation(
                        eriInfo.mIconIndex,
                        eriInfo.mIconMode,
                        eriInfo.mEriText);
                varB4EAC82CA7396A68D541C85D26508E83_11449243 = ret;
            } //End block
        } //End block
        //Begin case EriInfo.ROAMING_INDICATOR_ON 
        ret = new EriDisplayInformation(
                    EriInfo.ROAMING_INDICATOR_ON,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText0).toString());
        //End case EriInfo.ROAMING_INDICATOR_ON 
        //Begin case EriInfo.ROAMING_INDICATOR_OFF 
        ret = new EriDisplayInformation(
                    EriInfo.ROAMING_INDICATOR_OFF,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText1).toString());
        //End case EriInfo.ROAMING_INDICATOR_OFF 
        //Begin case EriInfo.ROAMING_INDICATOR_FLASH 
        ret = new EriDisplayInformation(
                    EriInfo.ROAMING_INDICATOR_FLASH,
                    EriInfo.ROAMING_ICON_MODE_FLASH,
                    mContext.getText(com.android.internal.R.string.roamingText2).toString());
        //End case EriInfo.ROAMING_INDICATOR_FLASH 
        //Begin case 3 
        ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText3).toString());
        //End case 3 
        //Begin case 4 
        ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText4).toString());
        //End case 4 
        //Begin case 5 
        ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText5).toString());
        //End case 5 
        //Begin case 6 
        ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText6).toString());
        //End case 6 
        //Begin case 7 
        ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText7).toString());
        //End case 7 
        //Begin case 8 
        ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText8).toString());
        //End case 8 
        //Begin case 9 
        ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText9).toString());
        //End case 9 
        //Begin case 10 
        ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText10).toString());
        //End case 10 
        //Begin case 11 
        ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText11).toString());
        //End case 11 
        //Begin case 12 
        ret = new EriDisplayInformation(
                    roamInd,
                    EriInfo.ROAMING_ICON_MODE_NORMAL,
                    mContext.getText(com.android.internal.R.string.roamingText12).toString());
        //End case 12 
        //Begin case default 
        {
            Log.d(LOG_TAG, "ERI File not loaded");
            {
                ret = new EriDisplayInformation(
                            EriInfo.ROAMING_INDICATOR_FLASH,
                            EriInfo.ROAMING_ICON_MODE_FLASH,
                            mContext.getText(com.android.internal
                                                            .R.string.roamingText2).toString());
            } //End block
            {
                //Begin case EriInfo.ROAMING_INDICATOR_ON 
                ret = new EriDisplayInformation(
                                EriInfo.ROAMING_INDICATOR_ON,
                                EriInfo.ROAMING_ICON_MODE_NORMAL,
                                mContext.getText(com.android.internal
                                                            .R.string.roamingText0).toString());
                //End case EriInfo.ROAMING_INDICATOR_ON 
                //Begin case EriInfo.ROAMING_INDICATOR_OFF 
                ret = new EriDisplayInformation(
                                EriInfo.ROAMING_INDICATOR_OFF,
                                EriInfo.ROAMING_ICON_MODE_NORMAL,
                                mContext.getText(com.android.internal
                                                            .R.string.roamingText1).toString());
                //End case EriInfo.ROAMING_INDICATOR_OFF 
                //Begin case EriInfo.ROAMING_INDICATOR_FLASH 
                ret = new EriDisplayInformation(
                                EriInfo.ROAMING_INDICATOR_FLASH,
                                EriInfo.ROAMING_ICON_MODE_FLASH,
                                mContext.getText(com.android.internal
                                                            .R.string.roamingText2).toString());
                //End case EriInfo.ROAMING_INDICATOR_FLASH 
                //Begin case default 
                ret = new EriDisplayInformation(-1, -1, "ERI text");
                //End case default 
            } //End block
        } //End block
        {
            EriInfo eriInfo;
            eriInfo = getEriInfo(roamInd);
            EriInfo defEriInfo;
            defEriInfo = getEriInfo(defRoamInd);
            {
                {
                    ret = new EriDisplayInformation(
                                EriInfo.ROAMING_INDICATOR_ON,
                                EriInfo.ROAMING_ICON_MODE_NORMAL,
                                mContext.getText(com.android.internal
                                                             .R.string.roamingText0).toString());
                } //End block
                {
                    ret = new EriDisplayInformation(
                                defEriInfo.mIconIndex,
                                defEriInfo.mIconMode,
                                defEriInfo.mEriText);
                } //End block
            } //End block
            {
                ret = new EriDisplayInformation(
                            eriInfo.mIconIndex,
                            eriInfo.mIconMode,
                            eriInfo.mEriText);
            } //End block
        } //End block
        //End case default 
        varB4EAC82CA7396A68D541C85D26508E83_2135474152 = ret;
        addTaint(roamInd);
        addTaint(defRoamInd);
        EriDisplayInformation varA7E53CE21691AB073D9660D615818899_194510544; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_194510544 = varB4EAC82CA7396A68D541C85D26508E83_11449243;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_194510544 = varB4EAC82CA7396A68D541C85D26508E83_2135474152;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_194510544.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_194510544;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.676 -0400", hash_original_method = "0CC10569A68EA715FF25360AD6D9EC97", hash_generated_method = "77E39528A29D130EF2BBEF9E5C8FF604")
    public int getCdmaEriIconIndex(int roamInd, int defRoamInd) {
        int var515FFAA8B10D5444FFA319B784D84C94_852014951 = (getEriDisplayInformation(roamInd, defRoamInd).mEriIconIndex);
        addTaint(roamInd);
        addTaint(defRoamInd);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530082677 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530082677;
        // ---------- Original Method ----------
        //return getEriDisplayInformation(roamInd, defRoamInd).mEriIconIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.676 -0400", hash_original_method = "9AB048E0DEB3BE0C35B104EC83429815", hash_generated_method = "2AA75E4C7742066B0C4F7642FD5E72D8")
    public int getCdmaEriIconMode(int roamInd, int defRoamInd) {
        int var29D805AE6BA7F58D859AF81BAF606D7F_1170925392 = (getEriDisplayInformation(roamInd, defRoamInd).mEriIconMode);
        addTaint(roamInd);
        addTaint(defRoamInd);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71154215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71154215;
        // ---------- Original Method ----------
        //return getEriDisplayInformation(roamInd, defRoamInd).mEriIconMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.677 -0400", hash_original_method = "180B939948D08F85119E751A7703AC82", hash_generated_method = "1A4B53F582D07114A19F1A4FBB857328")
    public String getCdmaEriText(int roamInd, int defRoamInd) {
        String varB4EAC82CA7396A68D541C85D26508E83_1355885184 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1355885184 = getEriDisplayInformation(roamInd, defRoamInd).mEriIconText;
        addTaint(roamInd);
        addTaint(defRoamInd);
        varB4EAC82CA7396A68D541C85D26508E83_1355885184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1355885184;
        // ---------- Original Method ----------
        //return getEriDisplayInformation(roamInd, defRoamInd).mEriIconText;
    }

    
    class EriFile {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.677 -0400", hash_original_field = "CA3B6F228A22FE5E587CFE3500DB0235", hash_generated_field = "7213E6068BB9156E973788AD57203866")

        public int mVersionNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.677 -0400", hash_original_field = "C42433D66F2C2DBC9799A789B2B48B1D", hash_generated_field = "FDCC1E3B4FD2295A26ED5003CFA706F3")

        public int mNumberOfEriEntries;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.677 -0400", hash_original_field = "AD315A22B51F691A15FF83833BF75CD9", hash_generated_field = "E9576BD6C3AB66FA7A330571C9CA95FE")

        public int mEriFileType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.678 -0400", hash_original_field = "2FB0AC8DD26FF5F0DD2CA5B243F49CAB", hash_generated_field = "AFBDC935694CE0774D1C68BD6FD348E1")

        public String[] mCallPromptId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.678 -0400", hash_original_field = "4FC2074114FB09A5F4C098DD58728B23", hash_generated_field = "777F27FBAB0D81E98C7637CE98514EB6")

        public HashMap<Integer, EriInfo> mRoamIndTable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.678 -0400", hash_original_method = "2EA3C22290A4E78EE72B7E98713E9994", hash_generated_method = "198DE2BB12791BAD0A6900555629D6CA")
        public  EriFile() {
            this.mVersionNumber = -1;
            this.mNumberOfEriEntries = 0;
            this.mEriFileType = -1;
            this.mCallPromptId = new String[] { "", "", "" };
            this.mRoamIndTable = new HashMap<Integer, EriInfo>();
            // ---------- Original Method ----------
            //this.mVersionNumber = -1;
            //this.mNumberOfEriEntries = 0;
            //this.mEriFileType = -1;
            //this.mCallPromptId = new String[] { "", "", "" };
            //this.mRoamIndTable = new HashMap<Integer, EriInfo>();
        }

        
    }


    
    class EriDisplayInformation {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.678 -0400", hash_original_field = "5C2EEBB55B73259BA23EEAF20EEA7208", hash_generated_field = "D41D6FF190F02ADC6B00CBC4CA09758B")

        public int mEriIconIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.678 -0400", hash_original_field = "EBB2869EEC015D02DBBB42BC561755A0", hash_generated_field = "567015E9F1EBB9480DDA52E1D3755433")

        public int mEriIconMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.678 -0400", hash_original_field = "950CBE7B17588C814951F20D86DEFDC5", hash_generated_field = "FE7B91EA19745F159F421B316262311F")

        public String mEriIconText;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.695 -0400", hash_original_method = "4EF117935273C0A391AF6FA851E1F0DC", hash_generated_method = "7B98B4E282FBDCCFB11D0BC5C762DE79")
        public  EriDisplayInformation(int eriIconIndex, int eriIconMode, String eriIconText) {
            mEriIconIndex = eriIconIndex;
            mEriIconMode = eriIconMode;
            mEriIconText = eriIconText;
            // ---------- Original Method ----------
            //mEriIconIndex = eriIconIndex;
            //mEriIconMode = eriIconMode;
            //mEriIconText = eriIconText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.696 -0400", hash_original_method = "AD3807950D152469EF511B007C55D141", hash_generated_method = "6840662A3C122A2F8F3751AD7E7DC767")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1152802157 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1152802157 = "EriDisplayInformation: {" + " IconIndex: " + mEriIconIndex + " EriIconMode: "
                    + mEriIconMode + " EriIconText: " + mEriIconText + " }";
            varB4EAC82CA7396A68D541C85D26508E83_1152802157.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1152802157;
            // ---------- Original Method ----------
            //return "EriDisplayInformation: {" + " IconIndex: " + mEriIconIndex + " EriIconMode: "
                    //+ mEriIconMode + " EriIconText: " + mEriIconText + " }";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.696 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "3180393FBDFF3695C5B6689D6A3679D8")

    private static String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.696 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "EA7FF8772A7B2A0121F9F6C2158F8474")

    private static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.696 -0400", hash_original_field = "F731EB70B21910E383F52051C1671657", hash_generated_field = "CC544916A8B1096E680ADE82FEC5BF9D")

    private static boolean VDBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.696 -0400", hash_original_field = "5593BB933254AF080B241EF8A7D85975", hash_generated_field = "00C3C5EFF0729D5E68BE0BDCAA7114C6")

    public static final int ERI_FROM_XML          = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.696 -0400", hash_original_field = "75287E9282EF2CA3FA6D4E6197DEF8B2", hash_generated_field = "02B1498635DB5093BFD38B42915E1A9B")

    public static final int ERI_FROM_FILE_SYSTEM  = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.696 -0400", hash_original_field = "5CC67EE3C8CE1461E5FE0D948907D471", hash_generated_field = "468B5F78F500D1FE21D0E4DF6EAF48F6")

    public static final int ERI_FROM_MODEM        = 2;
}

