package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

final class XmlBlock {
    private AssetManager mAssets;
    private int mNative;
    StringBlock mStrings;
    private boolean mOpen = true;
    private int mOpenCount = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.710 -0400", hash_original_method = "A22EEB27BFE227BD171CA1655E28A01F", hash_generated_method = "73068A164D51E8BE6B220DABAAB77B37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlBlock(byte[] data) {
        dsTaint.addTaint(data[0]);
        mAssets = null;
        mNative = nativeCreate(data, 0, data.length);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        // ---------- Original Method ----------
        //mAssets = null;
        //mNative = nativeCreate(data, 0, data.length);
        //mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.720 -0400", hash_original_method = "B1D68A7ECB78CEADC57D198A6FDBCA28", hash_generated_method = "5A1E5A1A76770530160AAD3E3921C08B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlBlock(byte[] data, int offset, int size) {
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(size);
        mAssets = null;
        mNative = nativeCreate(data, offset, size);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        // ---------- Original Method ----------
        //mAssets = null;
        //mNative = nativeCreate(data, offset, size);
        //mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.720 -0400", hash_original_method = "2D0B3C5ECC15AA5F78B0AD70805A049B", hash_generated_method = "2E6917C96AFD25A9368D078C268A2D8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     XmlBlock(AssetManager assets, int xmlBlock) {
        dsTaint.addTaint(assets.dsTaint);
        dsTaint.addTaint(xmlBlock);
        mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
        // ---------- Original Method ----------
        //mAssets = assets;
        //mNative = xmlBlock;
        //mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.721 -0400", hash_original_method = "92B3E7DBAA5D8D51C162522636FE2570", hash_generated_method = "B4E7DA18AC06A705B61F6622C9433AEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        {
            {
                mOpen = false;
                decOpenCountLocked();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mOpen) {
                //mOpen = false;
                //decOpenCountLocked();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.721 -0400", hash_original_method = "017FB1456432C4B45E3EDBB9E5F1A65C", hash_generated_method = "755E68CBCCC578A6BE297FE901E3483E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void decOpenCountLocked() {
        {
            nativeDestroy(mNative);
            {
                mAssets.xmlBlockGone(hashCode());
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mOpenCount--;
        //if (mOpenCount == 0) {
            //nativeDestroy(mNative);
            //if (mAssets != null) {
                //mAssets.xmlBlockGone(hashCode());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.723 -0400", hash_original_method = "36FE28CA3339B97C4303841D21F6E4EF", hash_generated_method = "FDACDF2A5391D2457CE69DDBB4281D26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlResourceParser newParser() {
        {
            {
                XmlResourceParser var300FA01976018F781FA2BECE3AFC43CD_1672827985 = (new Parser(nativeCreateParseState(mNative), this));
            } //End block
        } //End block
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mNative != 0) {
                //return new Parser(nativeCreateParseState(mNative), this);
            //}
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.724 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        close();
        // ---------- Original Method ----------
        //close();
    }

    
        private static final int nativeCreate(byte[] data,
                                                 int offset,
                                                 int size) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetStringBlock(int obj) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeCreateParseState(int obj) {
        return DSUtils.UNKNOWN_INT;
    }

    
        static final int nativeNext(int state) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetNamespace(int state) {
        return DSUtils.UNKNOWN_INT;
    }

    
        static final int nativeGetName(int state) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetText(int state) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetLineNumber(int state) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetAttributeCount(int state) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetAttributeNamespace(int state, int idx) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetAttributeName(int state, int idx) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetAttributeResource(int state, int idx) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetAttributeDataType(int state, int idx) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetAttributeData(int state, int idx) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetAttributeStringValue(int state, int idx) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetIdAttribute(int state) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetClassAttribute(int state) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetStyleAttribute(int state) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetAttributeIndex(int state, String namespace, String name) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final void nativeDestroyParseState(int state) {
    }

    
        private static final void nativeDestroy(int obj) {
    }

    
    final class Parser implements XmlResourceParser {
        int mParseState;
        private XmlBlock mBlock;
        private boolean mStarted = false;
        private boolean mDecNextDepth = false;
        private int mDepth = 0;
        private int mEventType = START_DOCUMENT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.731 -0400", hash_original_method = "2D249E03AFD474FA9CDB4E7172E5ABB4", hash_generated_method = "4FBA65F197C7FA9DB2BEDF0159ABC8EE")
        @DSModeled(DSC.SAFE)
         Parser(int parseState, XmlBlock block) {
            dsTaint.addTaint(block.dsTaint);
            dsTaint.addTaint(parseState);
            // ---------- Original Method ----------
            //mParseState = parseState;
            //mBlock = block;
            //block.mOpenCount++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.731 -0400", hash_original_method = "C272D7923F75EBE1BE9678831233D06B", hash_generated_method = "891E3D83B520D0A8C08ECF63F3157FE9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setFeature(String name, boolean state) throws XmlPullParserException {
            dsTaint.addTaint(name);
            dsTaint.addTaint(state);
            {
                boolean varB94CA82C41719F3E969BD618F7E5D9E4_1614707115 = (FEATURE_PROCESS_NAMESPACES.equals(name) && state);
            } //End collapsed parenthetic
            {
                boolean var46B472FB98C8A84DE2826A8C4EA5EA01_1494481755 = (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name) && state);
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Unsupported feature: " + name);
            // ---------- Original Method ----------
            //if (FEATURE_PROCESS_NAMESPACES.equals(name) && state) {
                //return;
            //}
            //if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name) && state) {
                //return;
            //}
            //throw new XmlPullParserException("Unsupported feature: " + name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.731 -0400", hash_original_method = "AB43D5F41C6A1AAA22A1C5749D672E40", hash_generated_method = "730E55433D19A91D5779D034B1CFD656")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean getFeature(String name) {
            dsTaint.addTaint(name);
            {
                boolean var30BD9FC73D8A5FB7FF062BA1F723D3AA_699096231 = (FEATURE_PROCESS_NAMESPACES.equals(name));
            } //End collapsed parenthetic
            {
                boolean var5829279DB6D53DE356D337B03CF1D24E_1307192601 = (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name));
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (FEATURE_PROCESS_NAMESPACES.equals(name)) {
                //return true;
            //}
            //if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name)) {
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.731 -0400", hash_original_method = "B8013E7A09E481D305959C445CAA259A", hash_generated_method = "03967FDCEB897077886686F30881F624")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setProperty(String name, Object value) throws XmlPullParserException {
            dsTaint.addTaint(name);
            dsTaint.addTaint(value.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setProperty() not supported");
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setProperty() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.732 -0400", hash_original_method = "5175B2315D9AD451CFA017AE30114E6D", hash_generated_method = "A3847CFC8D039E0DB7D59F67C6705893")
        @DSModeled(DSC.SAFE)
        public Object getProperty(String name) {
            dsTaint.addTaint(name);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.732 -0400", hash_original_method = "C407C4DE5B4382B09BED3CBFBB5B2FE9", hash_generated_method = "92C6703E8492F4C4B3964C4B9BCDA8F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setInput(Reader in) throws XmlPullParserException {
            dsTaint.addTaint(in.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setInput() not supported");
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setInput() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.732 -0400", hash_original_method = "2056A33FA2E1F0F175E1EBF8A8F56238", hash_generated_method = "CEF1CC90B751D0208D3CF540C136CD31")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setInput(InputStream inputStream, String inputEncoding) throws XmlPullParserException {
            dsTaint.addTaint(inputStream.dsTaint);
            dsTaint.addTaint(inputEncoding);
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setInput() not supported");
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setInput() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.732 -0400", hash_original_method = "523C048AE61D8B3E324838EE2E3CB0C0", hash_generated_method = "CFAEF8FCFA7CEBB0797382BDC9A8C791")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void defineEntityReplacementText(String entityName, String replacementText) throws XmlPullParserException {
            dsTaint.addTaint(replacementText);
            dsTaint.addTaint(entityName);
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("defineEntityReplacementText() not supported");
            // ---------- Original Method ----------
            //throw new XmlPullParserException("defineEntityReplacementText() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.733 -0400", hash_original_method = "A5499422039640FD4F9D5601F1C55CCA", hash_generated_method = "32A78DB13BDC3C84203D930144C09541")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getNamespacePrefix(int pos) throws XmlPullParserException {
            dsTaint.addTaint(pos);
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("getNamespacePrefix() not supported");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespacePrefix() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.733 -0400", hash_original_method = "5C999184AAA0F0E674F1363E90C0FD13", hash_generated_method = "37260CEF3F33181D5DE0B58335844E5C")
        @DSModeled(DSC.SAFE)
        public String getInputEncoding() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.733 -0400", hash_original_method = "AE6D93E7ABBCC0A1FA148BC6AE95DD76", hash_generated_method = "CFDA50314590256CD5032A6038EFD59B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getNamespace(String prefix) {
            dsTaint.addTaint(prefix);
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getNamespace() not supported");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //throw new RuntimeException("getNamespace() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.733 -0400", hash_original_method = "A423E278D1BE175DD386F3DED425ED1E", hash_generated_method = "DCB5A8A6C1D9019DABFF934F9BF6070B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getNamespaceCount(int depth) throws XmlPullParserException {
            dsTaint.addTaint(depth);
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("getNamespaceCount() not supported");
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespaceCount() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.733 -0400", hash_original_method = "D2403D5573FCC08ECC8A73989B7EFE93", hash_generated_method = "2B8E9E64EDF1080484AD4BD07564728C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getPositionDescription() {
            String var356F074973DF0F8B912CDDEE702EFA72_438687584 = ("Binary XML file line #" + getLineNumber());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Binary XML file line #" + getLineNumber();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.734 -0400", hash_original_method = "0BA86538E6BFE859243D39CD091AF1CC", hash_generated_method = "F820C168BD53D8EBA93B29756D565E5F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getNamespaceUri(int pos) throws XmlPullParserException {
            dsTaint.addTaint(pos);
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("getNamespaceUri() not supported");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespaceUri() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.734 -0400", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "D46CF5CF46D8B989B2A4A44717C571DD")
        @DSModeled(DSC.SAFE)
        public int getColumnNumber() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.734 -0400", hash_original_method = "DE1021F4C2B2A1E4D5CF36677B434DEA", hash_generated_method = "9098C21CFAB66D40695921401817F430")
        @DSModeled(DSC.SAFE)
        public int getDepth() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mDepth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.734 -0400", hash_original_method = "9AA17B3C306C694E2A4C941D5BD64364", hash_generated_method = "015C6360BEB913D5814B211FCA480820")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getText() {
            int id;
            id = nativeGetText(mParseState);
            {
                Object var9FE53D5D7EFA6B8087535C1416E3DE4B_821527217 = (mStrings.get(id).toString());
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int id = nativeGetText(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.735 -0400", hash_original_method = "D6658BAD08E09D6B5CC695C7702E23C1", hash_generated_method = "1CDF02728D63D48FE11CC063EF45FD74")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getLineNumber() {
            int varBAA831A065AF74337E20120097F7F4FD_1167436875 = (nativeGetLineNumber(mParseState));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return nativeGetLineNumber(mParseState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.735 -0400", hash_original_method = "8A2CD03AAFDD20222A8759980FBB28AE", hash_generated_method = "265B6170E3524924680374D9CBBCEF6D")
        @DSModeled(DSC.SAFE)
        public int getEventType() throws XmlPullParserException {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mEventType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.735 -0400", hash_original_method = "926F3413D3806C4A183D059B4FD2543E", hash_generated_method = "353DC2534B26E585D6A3EA305A809324")
        @DSModeled(DSC.SAFE)
        public boolean isWhitespace() throws XmlPullParserException {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.735 -0400", hash_original_method = "692B884A81B63C3B5FA2E5F7E1379D3F", hash_generated_method = "0BB4932E2B1D74E90BD5524754427F69")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getPrefix() {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getPrefix not supported");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //throw new RuntimeException("getPrefix not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.736 -0400", hash_original_method = "03AC06D9FB54ABC98AEB5C7372B8DFCE", hash_generated_method = "672890FCD66FC8A2FC289D42EBB569FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char[] getTextCharacters(int[] holderForStartAndLength) {
            dsTaint.addTaint(holderForStartAndLength[0]);
            String txt;
            txt = getText();
            char[] chars;
            chars = null;
            {
                holderForStartAndLength[0] = 0;
                holderForStartAndLength[1] = txt.length();
                chars = new char[txt.length()];
                txt.getChars(0, txt.length(), chars, 0);
            } //End block
            char[] retVal = new char[1];
            retVal[0] = dsTaint.getTaintString().charAt(0);
            return retVal;
            // ---------- Original Method ----------
            //String txt = getText();
            //char[] chars = null;
            //if (txt != null) {
                //holderForStartAndLength[0] = 0;
                //holderForStartAndLength[1] = txt.length();
                //chars = new char[txt.length()];
                //txt.getChars(0, txt.length(), chars, 0);
            //}
            //return chars;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.736 -0400", hash_original_method = "53E841A7D41D7C8EC6230F47D159F5F8", hash_generated_method = "532AF2B9CEA9AC413B1FACCF8AE8FE24")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getNamespace() {
            int id;
            id = nativeGetNamespace(mParseState);
            {
                Object var9FE53D5D7EFA6B8087535C1416E3DE4B_1698255518 = (mStrings.get(id).toString());
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int id = nativeGetNamespace(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.736 -0400", hash_original_method = "5E952CADD7A547B8BBE8593EB2804E3F", hash_generated_method = "CCA625165C6842158C82E197E76A8323")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getName() {
            int id;
            id = nativeGetName(mParseState);
            {
                Object var9FE53D5D7EFA6B8087535C1416E3DE4B_637103279 = (mStrings.get(id).toString());
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int id = nativeGetName(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.737 -0400", hash_original_method = "C5B0A5333E9C04C4ABC345C16B794494", hash_generated_method = "B19FB967B92C974E94FA0DE9B8504A87")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAttributeNamespace(int index) {
            dsTaint.addTaint(index);
            int id;
            id = nativeGetAttributeNamespace(mParseState, index);
            System.out.println("getAttributeNamespace of " + index + " = " + id);
            String varB7AB16A937E0EA50EDE2041C09FCDC88_144525693 = (mStrings.get(id).toString());
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int id = nativeGetAttributeNamespace(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeNamespace of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //else if (id == -1) return "";
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.737 -0400", hash_original_method = "84AEB345F706FFE756390519A4CE900D", hash_generated_method = "EA4B0AD0DA6146D7C0293AEE0541408C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAttributeName(int index) {
            dsTaint.addTaint(index);
            int id;
            id = nativeGetAttributeName(mParseState, index);
            System.out.println("getAttributeName of " + index + " = " + id);
            String varB7AB16A937E0EA50EDE2041C09FCDC88_619707038 = (mStrings.get(id).toString());
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int id = nativeGetAttributeName(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeName of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.737 -0400", hash_original_method = "50B51A25D0464B8FD90EECF499D60B48", hash_generated_method = "3218A084F3596EC8CBEC67AD007D6144")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAttributePrefix(int index) {
            dsTaint.addTaint(index);
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getAttributePrefix not supported");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //throw new RuntimeException("getAttributePrefix not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.738 -0400", hash_original_method = "860332C2A14F44509730B84BDA1621A5", hash_generated_method = "EF2901D2EB43885C84C6F3806B8DF971")
        @DSModeled(DSC.SAFE)
        public boolean isEmptyElementTag() throws XmlPullParserException {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.738 -0400", hash_original_method = "AF6A401047A56BD2769A9CCD0765487F", hash_generated_method = "50BD4A5E00245941CBA6F6406CEC4507")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getAttributeCount() {
            {
                Object var4E40D70343CD40DEDD7252A82F34EED9_1380902622 = (nativeGetAttributeCount(mParseState));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mEventType == START_TAG ? nativeGetAttributeCount(mParseState) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.738 -0400", hash_original_method = "F4E9CDB9F128BA6177C44CACB76DA2CC", hash_generated_method = "79251D5FFF08F32A29CBF766837CA0C3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAttributeValue(int index) {
            dsTaint.addTaint(index);
            int id;
            id = nativeGetAttributeStringValue(mParseState, index);
            System.out.println("getAttributeValue of " + index + " = " + id);
            String varB7AB16A937E0EA50EDE2041C09FCDC88_1858804577 = (mStrings.get(id).toString());
            int t;
            t = nativeGetAttributeDataType(mParseState, index);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            } //End block
            int v;
            v = nativeGetAttributeData(mParseState, index);
            String varE5EF571714469D02D5CAEFDB51FE55D2_1441616167 = (TypedValue.coerceToString(t, v));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int id = nativeGetAttributeStringValue(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeValue of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //int t = nativeGetAttributeDataType(mParseState, index);
            //if (t == TypedValue.TYPE_NULL) {
                //throw new IndexOutOfBoundsException(String.valueOf(index));
            //}
            //int v = nativeGetAttributeData(mParseState, index);
            //return TypedValue.coerceToString(t, v);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.739 -0400", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "D0185ED1B70CA49F327A0F4D64531C56")
        @DSModeled(DSC.SAFE)
        public String getAttributeType(int index) {
            dsTaint.addTaint(index);
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CDATA";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.739 -0400", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "62E974F27010D13175D4EEA3D88B9120")
        @DSModeled(DSC.SAFE)
        public boolean isAttributeDefault(int index) {
            dsTaint.addTaint(index);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.739 -0400", hash_original_method = "F3E3F86FBCCE797A7D99504582A16A5E", hash_generated_method = "152354BA508F47255F5E43A317427C71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int nextToken() throws XmlPullParserException,IOException {
            int var83133C39DBD81A6FC01ACC28F158E440_1309239914 = (next());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return next();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.739 -0400", hash_original_method = "8127D80C9F5EEB177072DC0AE91ACB4C", hash_generated_method = "604609DBB4A2367512C435BD26A96594")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAttributeValue(String namespace, String name) {
            dsTaint.addTaint(name);
            dsTaint.addTaint(namespace);
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, name);
            {
                System.out.println("getAttributeName of "
                        + namespace + ":" + name + " index = " + idx);
                System.out.println(
                        "Namespace=" + getAttributeNamespace(idx)
                        + "Name=" + getAttributeName(idx)
                        + ", Value=" + getAttributeValue(idx));
                String varEFABF64B7BF29C98DD39C61F08D5DABC_2096630775 = (getAttributeValue(idx));
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, name);
            //if (idx >= 0) {
                //if (DEBUG) System.out.println("getAttributeName of "
                        //+ namespace + ":" + name + " index = " + idx);
                //if (DEBUG) System.out.println(
                        //"Namespace=" + getAttributeNamespace(idx)
                        //+ "Name=" + getAttributeName(idx)
                        //+ ", Value=" + getAttributeValue(idx));
                //return getAttributeValue(idx);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.740 -0400", hash_original_method = "2DA88A175068BC957038D4798DAD0AF9", hash_generated_method = "DCA5F33B3A1D63AD19AC8AA6CFA6F9DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int next() throws XmlPullParserException,IOException {
            {
                mStarted = true;
            } //End block
            int ev;
            ev = nativeNext(mParseState);
            {
                mDecNextDepth = false;
            } //End block
            //Begin case END_TAG 
            mDecNextDepth = true;
            //End case END_TAG 
            mEventType = ev;
            {
                close();
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (!mStarted) {
                //mStarted = true;
                //return START_DOCUMENT;
            //}
            //if (mParseState == 0) {
                //return END_DOCUMENT;
            //}
            //int ev = nativeNext(mParseState);
            //if (mDecNextDepth) {
                //mDepth--;
                //mDecNextDepth = false;
            //}
            //switch (ev) {
            //case START_TAG:
                //mDepth++;
                //break;
            //case END_TAG:
                //mDecNextDepth = true;
                //break;
            //}
            //mEventType = ev;
            //if (ev == END_DOCUMENT) {
                //close();
            //}
            //return ev;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.740 -0400", hash_original_method = "A600298A9B2D06DCD3FD708D87D4E435", hash_generated_method = "EA7D3D96132CACD36E99DDE6A85936EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void require(int type, String namespace, String name) throws XmlPullParserException,IOException {
            dsTaint.addTaint(name);
            dsTaint.addTaint(type);
            dsTaint.addTaint(namespace);
            {
                boolean var97810C1B0E0CD8066713029C8CFC3E70_350555247 = (type != getEventType()
                || (namespace != null && !namespace.equals( getNamespace () ) )
                || (name != null && !name.equals( getName() ) ));
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException( "expected "+ TYPES[ type ]+getPositionDescription());
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (type != getEventType()
                //|| (namespace != null && !namespace.equals( getNamespace () ) )
                //|| (name != null && !name.equals( getName() ) ) )
                //throw new XmlPullParserException( "expected "+ TYPES[ type ]+getPositionDescription());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.740 -0400", hash_original_method = "0387CD391BE287242825F05D1B5C07FC", hash_generated_method = "30C9BBA70F54D331BAC5030241DE5378")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String nextText() throws XmlPullParserException,IOException {
            {
                boolean var9596CF2618BFAD282E250C866F3DF3C9_30874367 = (getEventType() != START_TAG);
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG to read next text", this, null);
                } //End block
            } //End collapsed parenthetic
            int eventType;
            eventType = next();
            {
                String result;
                result = getText();
                eventType = next();
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    getPositionDescription()
                    + ": event TEXT it must be immediately followed by END_TAG", this, null);
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG or TEXT to read text", this, null);
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.741 -0400", hash_original_method = "86ECF63697C3285DB17A648F53C02562", hash_generated_method = "D6F6F4BA388724854D4C0344A421B90F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int nextTag() throws XmlPullParserException,IOException {
            int eventType;
            eventType = next();
            {
                boolean varC64C896D81E5DDFF005758762D652945_1594866713 = (eventType == TEXT && isWhitespace());
                {
                    eventType = next();
                } //End block
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                   getPositionDescription() 
                   + ": expected start or end tag", this, null);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int eventType = next();
            //if(eventType == TEXT && isWhitespace()) {   
               //eventType = next();
            //}
            //if (eventType != START_TAG && eventType != END_TAG) {
               //throw new XmlPullParserException(
                   //getPositionDescription() 
                   //+ ": expected start or end tag", this, null);
            //}
            //return eventType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.741 -0400", hash_original_method = "F89E8721AF5486B49BDF02DB68EDEEE5", hash_generated_method = "0A5DF201A5FEC44F0617A56ABADE833C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getAttributeNameResource(int index) {
            dsTaint.addTaint(index);
            int varF6A84D2EA99C427754EE4C64391AE074_638068593 = (nativeGetAttributeResource(mParseState, index));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return nativeGetAttributeResource(mParseState, index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.741 -0400", hash_original_method = "1215FB5AAEE746C41F9FA8271AAF1E60", hash_generated_method = "8E9ADB2F564987FD23008EF10ECAC0E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getAttributeListValue(String namespace, String attribute,
                String[] options, int defaultValue) {
            dsTaint.addTaint(attribute);
            dsTaint.addTaint(defaultValue);
            dsTaint.addTaint(options[0]);
            dsTaint.addTaint(namespace);
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var9746577ED7FA626EB250C6FA1993E568_1079772867 = (getAttributeListValue(idx, options, defaultValue));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeListValue(idx, options, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.742 -0400", hash_original_method = "B01E2E5CC96F6EF51E59D8D07AB9873A", hash_generated_method = "50322AB3C80E7A91EFD4BCC3AAFBD43E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean getAttributeBooleanValue(String namespace, String attribute,
                boolean defaultValue) {
            dsTaint.addTaint(attribute);
            dsTaint.addTaint(defaultValue);
            dsTaint.addTaint(namespace);
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                boolean var112C81F0CF2922B630967C489E44FCE2_1198955815 = (getAttributeBooleanValue(idx, defaultValue));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeBooleanValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.742 -0400", hash_original_method = "CB3F64435C40C20F84A081F8E49D1C0C", hash_generated_method = "E2CCD2DE0CCAFFDAD5AA9CB9D2F5AA1C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getAttributeResourceValue(String namespace, String attribute,
                int defaultValue) {
            dsTaint.addTaint(attribute);
            dsTaint.addTaint(defaultValue);
            dsTaint.addTaint(namespace);
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var4041CE7258634F39669102768A31E2B5_1328577586 = (getAttributeResourceValue(idx, defaultValue));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeResourceValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.742 -0400", hash_original_method = "8EF5A68420C37BD2779707A79B9C3811", hash_generated_method = "7B792AA65AB4D4B6F9D7473DE91EC2D6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getAttributeIntValue(String namespace, String attribute,
                int defaultValue) {
            dsTaint.addTaint(attribute);
            dsTaint.addTaint(defaultValue);
            dsTaint.addTaint(namespace);
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var98A36DA81833C24E66998F976469DC76_740579930 = (getAttributeIntValue(idx, defaultValue));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeIntValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.742 -0400", hash_original_method = "133F9E0C363583A7982FF4EDA455C0C4", hash_generated_method = "3C74B7AFCE6DF37F04A9B7DE3C36C6FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getAttributeUnsignedIntValue(String namespace, String attribute,
                                                int defaultValue) {
            dsTaint.addTaint(attribute);
            dsTaint.addTaint(defaultValue);
            dsTaint.addTaint(namespace);
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var6B4AE1ACD2501944E06884239ECFC491_1254311538 = (getAttributeUnsignedIntValue(idx, defaultValue));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeUnsignedIntValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.743 -0400", hash_original_method = "91D09444FE7CF8F77D4AFF725E1E8970", hash_generated_method = "9E82BBFE47FD64F5665D8FA81E8DF339")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float getAttributeFloatValue(String namespace, String attribute,
                float defaultValue) {
            dsTaint.addTaint(attribute);
            dsTaint.addTaint(defaultValue);
            dsTaint.addTaint(namespace);
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                float var8ADD88168EAB5E1C9157AC1388ED29E4_1525841758 = (getAttributeFloatValue(idx, defaultValue));
            } //End block
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeFloatValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.743 -0400", hash_original_method = "2BA8E9098E1E3526495883648F7DEF5F", hash_generated_method = "7CCC855C9ECE479E93DBD89C3E83E4C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getAttributeListValue(int idx,
                String[] options, int defaultValue) {
            dsTaint.addTaint(idx);
            dsTaint.addTaint(defaultValue);
            dsTaint.addTaint(options[0]);
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            int v;
            v = nativeGetAttributeData(mParseState, idx);
            {
                int var87C4679D2BF706005778803B1AE8C887_1452395888 = (XmlUtils.convertValueToList(
                    mStrings.get(v), options, defaultValue));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //int v = nativeGetAttributeData(mParseState, idx);
            //if (t == TypedValue.TYPE_STRING) {
                //return XmlUtils.convertValueToList(
                    //mStrings.get(v), options, defaultValue);
            //}
            //return v;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.743 -0400", hash_original_method = "9FDDF9436ABA275F049CE63B7297D004", hash_generated_method = "A13C963D67B7BFC7E2301F69B4D64BE5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean getAttributeBooleanValue(int idx,
                boolean defaultValue) {
            dsTaint.addTaint(idx);
            dsTaint.addTaint(defaultValue);
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                boolean var612CB30EBEACD27A167E09918F9B42F1_106146796 = (nativeGetAttributeData(mParseState, idx) != 0);
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx) != 0;
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.748 -0400", hash_original_method = "0D4A13949891098942D2BD0FE4681BA9", hash_generated_method = "D6C9903830F66A44027C57C27C52EA18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getAttributeResourceValue(int idx, int defaultValue) {
            dsTaint.addTaint(idx);
            dsTaint.addTaint(defaultValue);
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_1966178954 = (nativeGetAttributeData(mParseState, idx));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t == TypedValue.TYPE_REFERENCE) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.749 -0400", hash_original_method = "76347FF1C756B55868935018572B3748", hash_generated_method = "FCF46053A6205A3D4AA5AB969400F0B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getAttributeIntValue(int idx, int defaultValue) {
            dsTaint.addTaint(idx);
            dsTaint.addTaint(defaultValue);
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_509818224 = (nativeGetAttributeData(mParseState, idx));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.749 -0400", hash_original_method = "10FB8704E5561F244AB5AE7B4EFD0C1E", hash_generated_method = "4D457E88E6AC097C0F6B91586651C174")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getAttributeUnsignedIntValue(int idx, int defaultValue) {
            dsTaint.addTaint(idx);
            dsTaint.addTaint(defaultValue);
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_2040798574 = (nativeGetAttributeData(mParseState, idx));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.749 -0400", hash_original_method = "BBF18D629EB0696226FD45DB0C0888CC", hash_generated_method = "5D786BCD774B864BC9D7C29F6D4F59FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float getAttributeFloatValue(int idx, float defaultValue) {
            dsTaint.addTaint(idx);
            dsTaint.addTaint(defaultValue);
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                float var7FE27D38E8241DD13E64DA80050555B4_851843403 = (Float.intBitsToFloat(
                    nativeGetAttributeData(mParseState, idx)));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("not a float!");
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t == TypedValue.TYPE_FLOAT) {
                //return Float.intBitsToFloat(
                    //nativeGetAttributeData(mParseState, idx));
            //}
            //throw new RuntimeException("not a float!");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.751 -0400", hash_original_method = "459DE28869C0476D8004C0FC89A0FAA3", hash_generated_method = "BD305FD63B2E25B814A70620C793225C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getIdAttribute() {
            int id;
            id = nativeGetIdAttribute(mParseState);
            {
                Object var9FE53D5D7EFA6B8087535C1416E3DE4B_824808274 = (mStrings.get(id).toString());
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int id = nativeGetIdAttribute(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.751 -0400", hash_original_method = "6EA4969C84EC91743C886113DBDA4AC3", hash_generated_method = "2AC76E2439AE6A5E4CC55787E22DEE07")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getClassAttribute() {
            int id;
            id = nativeGetClassAttribute(mParseState);
            {
                Object var9FE53D5D7EFA6B8087535C1416E3DE4B_1448253798 = (mStrings.get(id).toString());
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int id = nativeGetClassAttribute(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.752 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "1551853770EB449A245659BE9253B511")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getIdAttributeResourceValue(int defaultValue) {
            dsTaint.addTaint(defaultValue);
            int var3134D2BCB0EA7E34279C8DC792789F56_856081137 = (getAttributeResourceValue(null, "id", defaultValue));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getAttributeResourceValue(null, "id", defaultValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.754 -0400", hash_original_method = "34AB6D031D153719912E2897914AFEED", hash_generated_method = "2651F60E571A43610D18818608F90B88")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getStyleAttribute() {
            int var24F64E8584039948E1AFFBFA2A70D193_564241251 = (nativeGetStyleAttribute(mParseState));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return nativeGetStyleAttribute(mParseState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.757 -0400", hash_original_method = "283F7DAAD4F2484127D9024B5883A661", hash_generated_method = "0495834BCB8967EEAAC0C90DB330C999")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void close() {
            {
                {
                    nativeDestroyParseState(mParseState);
                    mParseState = 0;
                    mBlock.decOpenCountLocked();
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mBlock) {
                //if (mParseState != 0) {
                    //nativeDestroyParseState(mParseState);
                    //mParseState = 0;
                    //mBlock.decOpenCountLocked();
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.758 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void finalize() throws Throwable {
            close();
            // ---------- Original Method ----------
            //close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.759 -0400", hash_original_method = "E55719651A1187D6CF490013E1512769", hash_generated_method = "F0172DA597A89780FE535C98CA5D31A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final CharSequence getPooledString(int id) {
            dsTaint.addTaint(id);
            CharSequence var1368FC88A4912EDD21ABB5129148C8D4_1999375154 = (mStrings.get(id));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mStrings.get(id);
        }

        
    }


    
    private static final boolean DEBUG=false;
}

