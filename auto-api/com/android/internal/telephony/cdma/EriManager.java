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
    private PhoneBase mPhone;
    private Context mContext;
    private int mEriFileSource = ERI_FROM_XML;
    private boolean isEriFileLoaded;
    private EriFile mEriFile;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.795 -0400", hash_original_method = "3CF9033327C5802237473AC2EBF5A9A4", hash_generated_method = "04447B1D2092223A9316B7CCE73EB387")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EriManager(PhoneBase phone, Context context, int eriFileSource) {
        dsTaint.addTaint(eriFileSource);
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        this.mEriFile = new EriFile();
        // ---------- Original Method ----------
        //this.mPhone = phone;
        //this.mContext = context;
        //this.mEriFileSource = eriFileSource;
        //this.mEriFile = new EriFile();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.795 -0400", hash_original_method = "E6DC952A5F138026D46EF70E48873C6A", hash_generated_method = "63E6418D6E31FB076F0ABE7FE7C0BC71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        mEriFile = new EriFile();
        isEriFileLoaded = false;
        // ---------- Original Method ----------
        //mEriFile = new EriFile();
        //isEriFileLoaded = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.795 -0400", hash_original_method = "79759E789BC701587754CBB5AD9F0BEC", hash_generated_method = "9AD1C333977B2F5366B5F750F19BD008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.795 -0400", hash_original_method = "F319D2CF7E3E715B8D39AE2FABF6BF7B", hash_generated_method = "E557464B9F1CB4500DE84483A9542396")
    @DSModeled(DSC.SAFE)
    private void loadEriFileFromModem() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.795 -0400", hash_original_method = "A745E0763E42351C9DE31AD2579A5B7C", hash_generated_method = "E7A0D2EF52E0D62B1AC03B9954F84BEF")
    @DSModeled(DSC.SAFE)
    private void loadEriFileFromFileSystem() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.796 -0400", hash_original_method = "C6A3384D5129DFA3EA95328C5EF0C849", hash_generated_method = "E37CB2B9AFCAE4DF32AE8A922244E52B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean varE80C698A9C3F8E5666F4303FE2067665_2013166096 = (name.equals("CallPromptId"));
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
                        boolean var899A8E63ADE4001FCB3DF2C3D92C8FA5_1073703946 = (name.equals("EriInfo"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.797 -0400", hash_original_method = "C9469B68514D99711DF201C8FE7DFBA7", hash_generated_method = "646FC6E9135AA509CF3E2FA96326938C")
    @DSModeled(DSC.SAFE)
    public int getEriFileVersion() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEriFile.mVersionNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.797 -0400", hash_original_method = "61A833F46D3B8953A540625C42A0EB37", hash_generated_method = "1A6CB3F50B234598DC84AA01765F88DF")
    @DSModeled(DSC.SAFE)
    public int getEriNumberOfEntries() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEriFile.mNumberOfEriEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.797 -0400", hash_original_method = "1FA8D7F59FB6C59B7F4FF404D7CADD99", hash_generated_method = "8E7E757D2CEE89D3C60B8DBBBA05A3DC")
    @DSModeled(DSC.SAFE)
    public int getEriFileType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEriFile.mEriFileType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.797 -0400", hash_original_method = "82EFBDE53CEDFA09C7F551715591238A", hash_generated_method = "5B6D4C0B5BB783A51A042CD89BCBD874")
    @DSModeled(DSC.SAFE)
    public boolean isEriFileLoaded() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isEriFileLoaded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.797 -0400", hash_original_method = "EC9DEB76FD43053D10B144FC41192B14", hash_generated_method = "252D167155DFEB25401A095FD62CEADB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private EriInfo getEriInfo(int roamingIndicator) {
        dsTaint.addTaint(roamingIndicator);
        {
            boolean var57ABABFD2A3B3C6B754E21C0F57554B9_1192867335 = (mEriFile.mRoamIndTable.containsKey(roamingIndicator));
            {
                EriInfo varDC56B033E33FFB98F7994747BD57F269_437955499 = (mEriFile.mRoamIndTable.get(roamingIndicator));
            } //End block
        } //End collapsed parenthetic
        return (EriInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mEriFile.mRoamIndTable.containsKey(roamingIndicator)) {
            //return mEriFile.mRoamIndTable.get(roamingIndicator);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.799 -0400", hash_original_method = "D2C726FAB5040CEBEF6EB4A1388860BE", hash_generated_method = "DF1CC71A3B14ED3414D0B08205DCD7F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private EriDisplayInformation getEriDisplayInformation(int roamInd, int defRoamInd) {
        dsTaint.addTaint(roamInd);
        dsTaint.addTaint(defRoamInd);
        EriDisplayInformation ret;
        {
            EriInfo eriInfo;
            eriInfo = getEriInfo(roamInd);
            {
                ret = new EriDisplayInformation(
                        eriInfo.mIconIndex,
                        eriInfo.mIconMode,
                        eriInfo.mEriText);
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
        return (EriDisplayInformation)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.800 -0400", hash_original_method = "0CC10569A68EA715FF25360AD6D9EC97", hash_generated_method = "673B4B7FC1EAC1B050248DBA749F0254")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCdmaEriIconIndex(int roamInd, int defRoamInd) {
        dsTaint.addTaint(roamInd);
        dsTaint.addTaint(defRoamInd);
        int var515FFAA8B10D5444FFA319B784D84C94_554647555 = (getEriDisplayInformation(roamInd, defRoamInd).mEriIconIndex);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getEriDisplayInformation(roamInd, defRoamInd).mEriIconIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.800 -0400", hash_original_method = "9AB048E0DEB3BE0C35B104EC83429815", hash_generated_method = "2A1FCE3D3F38B5B89B54453D226E6B47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCdmaEriIconMode(int roamInd, int defRoamInd) {
        dsTaint.addTaint(roamInd);
        dsTaint.addTaint(defRoamInd);
        int var29D805AE6BA7F58D859AF81BAF606D7F_805012081 = (getEriDisplayInformation(roamInd, defRoamInd).mEriIconMode);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getEriDisplayInformation(roamInd, defRoamInd).mEriIconMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.800 -0400", hash_original_method = "180B939948D08F85119E751A7703AC82", hash_generated_method = "6125028148B5922251DE77F3D69B4B13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaEriText(int roamInd, int defRoamInd) {
        dsTaint.addTaint(roamInd);
        dsTaint.addTaint(defRoamInd);
        String varC9FA60E5C3FDF1A670CAE9A068BE7A51_1238780982 = (getEriDisplayInformation(roamInd, defRoamInd).mEriIconText);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getEriDisplayInformation(roamInd, defRoamInd).mEriIconText;
    }

    
    class EriFile {
        public int mVersionNumber;
        public int mNumberOfEriEntries;
        public int mEriFileType;
        public String[] mCallPromptId;
        public HashMap<Integer, EriInfo> mRoamIndTable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.800 -0400", hash_original_method = "2EA3C22290A4E78EE72B7E98713E9994", hash_generated_method = "198DE2BB12791BAD0A6900555629D6CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public EriFile() {
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
        public int mEriIconIndex;
        public int mEriIconMode;
        public String mEriIconText;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.801 -0400", hash_original_method = "4EF117935273C0A391AF6FA851E1F0DC", hash_generated_method = "30AFAAAB162236BF4B8940A9FAD45CBD")
        @DSModeled(DSC.SAFE)
        public EriDisplayInformation(int eriIconIndex, int eriIconMode, String eriIconText) {
            dsTaint.addTaint(eriIconText);
            dsTaint.addTaint(eriIconIndex);
            dsTaint.addTaint(eriIconMode);
            // ---------- Original Method ----------
            //mEriIconIndex = eriIconIndex;
            //mEriIconMode = eriIconMode;
            //mEriIconText = eriIconText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.801 -0400", hash_original_method = "AD3807950D152469EF511B007C55D141", hash_generated_method = "25766604B6DBEDA1F842E1D7CF2403DE")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EriDisplayInformation: {" + " IconIndex: " + mEriIconIndex + " EriIconMode: "
                    //+ mEriIconMode + " EriIconText: " + mEriIconText + " }";
        }

        
    }


    
    private static final String LOG_TAG = "CDMA";
    private static final boolean DBG = true;
    private static final boolean VDBG = false;
    public static final int ERI_FROM_XML          = 0;
    public static final int ERI_FROM_FILE_SYSTEM  = 1;
    public static final int ERI_FROM_MODEM        = 2;
}

