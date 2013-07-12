package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.016 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "E7BDAD23CF4F53103B9ED94B380FFE2A")

    private PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.016 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.016 -0400", hash_original_field = "A757B28B600867D7632EA7A4EAF519EA", hash_generated_field = "BE050A394E5DDA84CD7D9B82D09CD0DF")

    private int mEriFileSource = ERI_FROM_XML;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.016 -0400", hash_original_field = "583264D6B6FB2E8327A962B767E7361D", hash_generated_field = "D44D6DD6E8F17217EFA480219059C42D")

    private boolean isEriFileLoaded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.016 -0400", hash_original_field = "368C9D55284EA57A4D72C138088A7AEA", hash_generated_field = "F63AB3051D8F51BADF0A35205FF6E8C1")

    private EriFile mEriFile;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.017 -0400", hash_original_method = "3CF9033327C5802237473AC2EBF5A9A4", hash_generated_method = "DE2FD4EC78744ED88F4F1E9E56C3186D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.018 -0400", hash_original_method = "E6DC952A5F138026D46EF70E48873C6A", hash_generated_method = "63E6418D6E31FB076F0ABE7FE7C0BC71")
    public void dispose() {
        mEriFile = new EriFile();
        isEriFileLoaded = false;
        // ---------- Original Method ----------
        //mEriFile = new EriFile();
        //isEriFileLoaded = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.018 -0400", hash_original_method = "79759E789BC701587754CBB5AD9F0BEC", hash_generated_method = "1ED7DD81F43A3F70BE1F4E0967471815")
    public void loadEriFile() {
switch(mEriFileSource){
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.018 -0400", hash_original_method = "F319D2CF7E3E715B8D39AE2FABF6BF7B", hash_generated_method = "E557464B9F1CB4500DE84483A9542396")
    private void loadEriFileFromModem() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.019 -0400", hash_original_method = "A745E0763E42351C9DE31AD2579A5B7C", hash_generated_method = "E7A0D2EF52E0D62B1AC03B9954F84BEF")
    private void loadEriFileFromFileSystem() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.022 -0400", hash_original_method = "C6A3384D5129DFA3EA95328C5EF0C849", hash_generated_method = "9905FA626D82E09136388C388944E1BD")
    private void loadEriFileFromXml() {
        XmlPullParser parser = null;
        FileInputStream stream = null;
        Resources r = mContext.getResources();
        try 
        {
    if(DBG)            
            Log.d(LOG_TAG, "loadEriFileFromXml: check for alternate file");
            stream = new FileInputStream(
                            r.getString(com.android.internal.R.string.alternate_eri_file));
            parser = Xml.newPullParser();
            parser.setInput(stream, null);
    if(DBG)            
            Log.d(LOG_TAG, "loadEriFileFromXml: opened alternate file");
        } //End block
        catch (FileNotFoundException e)
        {
    if(DBG)            
            Log.d(LOG_TAG, "loadEriFileFromXml: no alternate file");
            parser = null;
        } //End block
        catch (XmlPullParserException e)
        {
    if(DBG)            
            Log.d(LOG_TAG, "loadEriFileFromXml: no parser for alternate file");
            parser = null;
        } //End block
    if(parser == null)        
        {
    if(DBG)            
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
            int parsedEriEntries = 0;
            while
(true)            
            {
                XmlUtils.nextElement(parser);
                String name = parser.getName();
    if(name == null)                
                {
    if(parsedEriEntries != mEriFile.mNumberOfEriEntries){ }                    break;
                } //End block
                else
    if(name.equals("CallPromptId"))                
                {
                    int id = Integer.parseInt(parser.getAttributeValue(null, "Id"));
                    String text = parser.getAttributeValue(null, "CallPromptText");
    if(id >= 0 && id <= 2)                    
                    {
                        mEriFile.mCallPromptId[id] = text;
                    } //End block
                    else
                    {
                    } //End block
                } //End block
                else
    if(name.equals("EriInfo"))                
                {
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
                } //End block
            } //End block
    if(DBG)            
            Log.d(LOG_TAG, "loadEriFileFromXml: eri parsing successful, file loaded");
            isEriFileLoaded = true;
        } //End block
        catch (Exception e)
        {
        } //End block
        finally 
        {
    if(parser instanceof XmlResourceParser)            
            {
                ((XmlResourceParser)parser).close();
            } //End block
            try 
            {
    if(stream != null)                
                {
                    stream.close();
                } //End block
            } //End block
            catch (IOException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.023 -0400", hash_original_method = "C9469B68514D99711DF201C8FE7DFBA7", hash_generated_method = "CB31412093EB33B26603AC3CF4DE3727")
    public int getEriFileVersion() {
        int var84CA50330295D6872A385F9A7A9BE91E_1964787058 = (mEriFile.mVersionNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117474906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117474906;
        // ---------- Original Method ----------
        //return mEriFile.mVersionNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.023 -0400", hash_original_method = "61A833F46D3B8953A540625C42A0EB37", hash_generated_method = "3D21865797EB1C87458FD0EB022A0B74")
    public int getEriNumberOfEntries() {
        int varC749F5B583DFAF595D13626B09EB5960_1433053090 = (mEriFile.mNumberOfEriEntries);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852106267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852106267;
        // ---------- Original Method ----------
        //return mEriFile.mNumberOfEriEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.024 -0400", hash_original_method = "1FA8D7F59FB6C59B7F4FF404D7CADD99", hash_generated_method = "7A84E495C421EFC7387C8415011008BA")
    public int getEriFileType() {
        int varE91C92CE404E86D048540B9EF5715810_1042623721 = (mEriFile.mEriFileType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611403944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611403944;
        // ---------- Original Method ----------
        //return mEriFile.mEriFileType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.024 -0400", hash_original_method = "82EFBDE53CEDFA09C7F551715591238A", hash_generated_method = "689C9D36EE160C291630AC63B3F72D8B")
    public boolean isEriFileLoaded() {
        boolean var583264D6B6FB2E8327A962B767E7361D_643632940 = (isEriFileLoaded);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461459396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461459396;
        // ---------- Original Method ----------
        //return isEriFileLoaded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.024 -0400", hash_original_method = "EC9DEB76FD43053D10B144FC41192B14", hash_generated_method = "4431AD6DFE7B97AF846D7ECF61691C56")
    private EriInfo getEriInfo(int roamingIndicator) {
        addTaint(roamingIndicator);
    if(mEriFile.mRoamIndTable.containsKey(roamingIndicator))        
        {
EriInfo var95BC62916B4AC2E6FB714DE628BBC803_481102501 =             mEriFile.mRoamIndTable.get(roamingIndicator);
            var95BC62916B4AC2E6FB714DE628BBC803_481102501.addTaint(taint);
            return var95BC62916B4AC2E6FB714DE628BBC803_481102501;
        } //End block
        else
        {
EriInfo var540C13E9E156B687226421B24F2DF178_908746322 =             null;
            var540C13E9E156B687226421B24F2DF178_908746322.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_908746322;
        } //End block
        // ---------- Original Method ----------
        //if (mEriFile.mRoamIndTable.containsKey(roamingIndicator)) {
            //return mEriFile.mRoamIndTable.get(roamingIndicator);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.030 -0400", hash_original_method = "D2C726FAB5040CEBEF6EB4A1388860BE", hash_generated_method = "14FC30C12C28A2AB440CA341E64FC5FA")
    private EriDisplayInformation getEriDisplayInformation(int roamInd, int defRoamInd) {
        addTaint(defRoamInd);
        addTaint(roamInd);
        EriDisplayInformation ret;
    if(isEriFileLoaded)        
        {
            EriInfo eriInfo = getEriInfo(roamInd);
    if(eriInfo != null)            
            {
    if(VDBG){ }                ret = new EriDisplayInformation(
                        eriInfo.mIconIndex,
                        eriInfo.mIconMode,
                        eriInfo.mEriText);
EriDisplayInformation varEDFF4FBBF053B5DC2B444ADFA049EE0F_1183659705 =                 ret;
                varEDFF4FBBF053B5DC2B444ADFA049EE0F_1183659705.addTaint(taint);
                return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1183659705;
            } //End block
        } //End block
switch(roamInd){
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
        default:
    if(!isEriFileLoaded)        
        {
    if(DBG)            
            Log.d(LOG_TAG, "ERI File not loaded");
    if(defRoamInd > 2)            
            {
    if(VDBG){ }                ret = new EriDisplayInformation(
                            EriInfo.ROAMING_INDICATOR_FLASH,
                            EriInfo.ROAMING_ICON_MODE_FLASH,
                            mContext.getText(com.android.internal
                                                            .R.string.roamingText2).toString());
            } //End block
            else
            {
    if(VDBG){ }switch(defRoamInd){
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
            } //End block
        } //End block
        else
        {
            EriInfo eriInfo = getEriInfo(roamInd);
            EriInfo defEriInfo = getEriInfo(defRoamInd);
    if(eriInfo == null)            
            {
    if(VDBG)                
                {
                } //End block
    if(defEriInfo == null)                
                {
                    ret = new EriDisplayInformation(
                                EriInfo.ROAMING_INDICATOR_ON,
                                EriInfo.ROAMING_ICON_MODE_NORMAL,
                                mContext.getText(com.android.internal
                                                             .R.string.roamingText0).toString());
                } //End block
                else
                {
    if(VDBG)                    
                    {
                    } //End block
                    ret = new EriDisplayInformation(
                                defEriInfo.mIconIndex,
                                defEriInfo.mIconMode,
                                defEriInfo.mEriText);
                } //End block
            } //End block
            else
            {
    if(VDBG){ }                ret = new EriDisplayInformation(
                            eriInfo.mIconIndex,
                            eriInfo.mIconMode,
                            eriInfo.mEriText);
            } //End block
        } //End block
        break;
}    if(VDBG){ }EriDisplayInformation varEDFF4FBBF053B5DC2B444ADFA049EE0F_324800950 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_324800950.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_324800950;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.033 -0400", hash_original_method = "0CC10569A68EA715FF25360AD6D9EC97", hash_generated_method = "1665BABEA8C80439BB1362DF53E26039")
    public int getCdmaEriIconIndex(int roamInd, int defRoamInd) {
        addTaint(defRoamInd);
        addTaint(roamInd);
        int varE3CFB090E31C59B45B8B8A4F5A1D2081_1415283383 = (getEriDisplayInformation(roamInd, defRoamInd).mEriIconIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817550202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817550202;
        // ---------- Original Method ----------
        //return getEriDisplayInformation(roamInd, defRoamInd).mEriIconIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.034 -0400", hash_original_method = "9AB048E0DEB3BE0C35B104EC83429815", hash_generated_method = "4AA3B91F26BF4163B757394A61ECDDCE")
    public int getCdmaEriIconMode(int roamInd, int defRoamInd) {
        addTaint(defRoamInd);
        addTaint(roamInd);
        int var01BB9FB3014BF1591D6FFB2DCA98BCD5_1121988975 = (getEriDisplayInformation(roamInd, defRoamInd).mEriIconMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_781214975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_781214975;
        // ---------- Original Method ----------
        //return getEriDisplayInformation(roamInd, defRoamInd).mEriIconMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.034 -0400", hash_original_method = "180B939948D08F85119E751A7703AC82", hash_generated_method = "EC94D5DB58C651950FC0EEB3DE176383")
    public String getCdmaEriText(int roamInd, int defRoamInd) {
        addTaint(defRoamInd);
        addTaint(roamInd);
String var3179FF429DC1C911ED4D261268562F01_1141217174 =         getEriDisplayInformation(roamInd, defRoamInd).mEriIconText;
        var3179FF429DC1C911ED4D261268562F01_1141217174.addTaint(taint);
        return var3179FF429DC1C911ED4D261268562F01_1141217174;
        // ---------- Original Method ----------
        //return getEriDisplayInformation(roamInd, defRoamInd).mEriIconText;
    }

    
    class EriFile {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.034 -0400", hash_original_field = "CA3B6F228A22FE5E587CFE3500DB0235", hash_generated_field = "7213E6068BB9156E973788AD57203866")

        public int mVersionNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.035 -0400", hash_original_field = "C42433D66F2C2DBC9799A789B2B48B1D", hash_generated_field = "FDCC1E3B4FD2295A26ED5003CFA706F3")

        public int mNumberOfEriEntries;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.035 -0400", hash_original_field = "AD315A22B51F691A15FF83833BF75CD9", hash_generated_field = "E9576BD6C3AB66FA7A330571C9CA95FE")

        public int mEriFileType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.035 -0400", hash_original_field = "2FB0AC8DD26FF5F0DD2CA5B243F49CAB", hash_generated_field = "AFBDC935694CE0774D1C68BD6FD348E1")

        public String[] mCallPromptId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.035 -0400", hash_original_field = "4FC2074114FB09A5F4C098DD58728B23", hash_generated_field = "777F27FBAB0D81E98C7637CE98514EB6")

        public HashMap<Integer, EriInfo> mRoamIndTable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.036 -0400", hash_original_method = "2EA3C22290A4E78EE72B7E98713E9994", hash_generated_method = "198DE2BB12791BAD0A6900555629D6CA")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.036 -0400", hash_original_field = "5C2EEBB55B73259BA23EEAF20EEA7208", hash_generated_field = "D41D6FF190F02ADC6B00CBC4CA09758B")

        public int mEriIconIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.036 -0400", hash_original_field = "EBB2869EEC015D02DBBB42BC561755A0", hash_generated_field = "567015E9F1EBB9480DDA52E1D3755433")

        public int mEriIconMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.036 -0400", hash_original_field = "950CBE7B17588C814951F20D86DEFDC5", hash_generated_field = "FE7B91EA19745F159F421B316262311F")

        public String mEriIconText;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.036 -0400", hash_original_method = "4EF117935273C0A391AF6FA851E1F0DC", hash_generated_method = "7B98B4E282FBDCCFB11D0BC5C762DE79")
        public  EriDisplayInformation(int eriIconIndex, int eriIconMode, String eriIconText) {
            mEriIconIndex = eriIconIndex;
            mEriIconMode = eriIconMode;
            mEriIconText = eriIconText;
            // ---------- Original Method ----------
            //mEriIconIndex = eriIconIndex;
            //mEriIconMode = eriIconMode;
            //mEriIconText = eriIconText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.037 -0400", hash_original_method = "AD3807950D152469EF511B007C55D141", hash_generated_method = "A6B62875ED2DAFF8D9B6EAFBD1D795BB")
        @Override
        public String toString() {
String var8A9C20A1070AC6BE778DE672504894BA_1623972914 =             "EriDisplayInformation: {" + " IconIndex: " + mEriIconIndex + " EriIconMode: "
                    + mEriIconMode + " EriIconText: " + mEriIconText + " }";
            var8A9C20A1070AC6BE778DE672504894BA_1623972914.addTaint(taint);
            return var8A9C20A1070AC6BE778DE672504894BA_1623972914;
            // ---------- Original Method ----------
            //return "EriDisplayInformation: {" + " IconIndex: " + mEriIconIndex + " EriIconMode: "
                    //+ mEriIconMode + " EriIconText: " + mEriIconText + " }";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.037 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "1718F4DE7305211326235C8400C02ED3")

    private static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.037 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.037 -0400", hash_original_field = "F731EB70B21910E383F52051C1671657", hash_generated_field = "D02AF5D06ADE430F9873A441F2773872")

    private static final boolean VDBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.037 -0400", hash_original_field = "5593BB933254AF080B241EF8A7D85975", hash_generated_field = "00C3C5EFF0729D5E68BE0BDCAA7114C6")

    public static final int ERI_FROM_XML          = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.037 -0400", hash_original_field = "75287E9282EF2CA3FA6D4E6197DEF8B2", hash_generated_field = "02B1498635DB5093BFD38B42915E1A9B")

    public static final int ERI_FROM_FILE_SYSTEM  = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.037 -0400", hash_original_field = "5CC67EE3C8CE1461E5FE0D948907D471", hash_generated_field = "468B5F78F500D1FE21D0E4DF6EAF48F6")

    public static final int ERI_FROM_MODEM        = 2;
}

