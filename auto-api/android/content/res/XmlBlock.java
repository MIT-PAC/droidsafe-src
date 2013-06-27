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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.305 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "49B4A4B4F77DF85AA82FF83B2F894508")

    private AssetManager mAssets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.305 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.317 -0400", hash_original_field = "DCFA8FC1CFB8B5A5290D25EC1EA3C56B", hash_generated_field = "E687239F3E1A0E0370D394F826B65E89")

    StringBlock mStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.317 -0400", hash_original_field = "FA3F9A9DA0C13C19A5EFA6211E2FE7F3", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.317 -0400", hash_original_field = "1DD071DB88934A0BCF394BA8B6213C8D", hash_generated_field = "D98A2F1C489BE52721534D4A450F131E")

    private int mOpenCount = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.320 -0400", hash_original_method = "A22EEB27BFE227BD171CA1655E28A01F", hash_generated_method = "4AE7DDE59497735C74D31FB0EB379F5F")
    public  XmlBlock(byte[] data) {
        mAssets = null;
        mNative = nativeCreate(data, 0, data.length);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        // ---------- Original Method ----------
        //mAssets = null;
        //mNative = nativeCreate(data, 0, data.length);
        //mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.322 -0400", hash_original_method = "B1D68A7ECB78CEADC57D198A6FDBCA28", hash_generated_method = "AB11E1FEA4E4C63AD257E940DE94AF11")
    public  XmlBlock(byte[] data, int offset, int size) {
        mAssets = null;
        mNative = nativeCreate(data, offset, size);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        // ---------- Original Method ----------
        //mAssets = null;
        //mNative = nativeCreate(data, offset, size);
        //mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.346 -0400", hash_original_method = "2D0B3C5ECC15AA5F78B0AD70805A049B", hash_generated_method = "2E005A9D8EA3DF78882014B9F5C7AE35")
      XmlBlock(AssetManager assets, int xmlBlock) {
        mAssets = assets;
        mNative = xmlBlock;
        mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
        // ---------- Original Method ----------
        //mAssets = assets;
        //mNative = xmlBlock;
        //mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.353 -0400", hash_original_method = "92B3E7DBAA5D8D51C162522636FE2570", hash_generated_method = "B4E7DA18AC06A705B61F6622C9433AEA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.354 -0400", hash_original_method = "017FB1456432C4B45E3EDBB9E5F1A65C", hash_generated_method = "755E68CBCCC578A6BE297FE901E3483E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.375 -0400", hash_original_method = "36FE28CA3339B97C4303841D21F6E4EF", hash_generated_method = "AE5E0A5F28E24AC3DE69AAA18B4A2817")
    public XmlResourceParser newParser() {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_993902121 = null; //Variable for return #1
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_2108420002 = null; //Variable for return #2
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_993902121 = new Parser(nativeCreateParseState(mNative), this);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2108420002 = null;
        } //End block
        XmlResourceParser varA7E53CE21691AB073D9660D615818899_438038921; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_438038921 = varB4EAC82CA7396A68D541C85D26508E83_993902121;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_438038921 = varB4EAC82CA7396A68D541C85D26508E83_2108420002;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_438038921.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_438038921;
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mNative != 0) {
                //return new Parser(nativeCreateParseState(mNative), this);
            //}
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.376 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.409 -0400", hash_original_field = "4BFB0B80D080363EFC5373B871FF0770", hash_generated_field = "6CCE16E02108F8B5004F82A927CFF083")

        int mParseState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.409 -0400", hash_original_field = "E5ADD54C021234204DB48E99A01961D7", hash_generated_field = "3EDA85A0804ED213AA0240D41752F909")

        private XmlBlock mBlock;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.409 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

        private boolean mStarted = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.410 -0400", hash_original_field = "0A0A65D3B2CBF183A116FD12849B0451", hash_generated_field = "202F76F59FBD4A34EFD44A9FC7F2ED5B")

        private boolean mDecNextDepth = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.420 -0400", hash_original_field = "8A9EE96E8F54650AD1636FC7C1C10A9A", hash_generated_field = "67A287B1854820A57845B046DB8B7A31")

        private int mDepth = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.420 -0400", hash_original_field = "35AE7FC4CD775545AD93999E73996B6A", hash_generated_field = "4840498E2AA207F0162BEB5586951A29")

        private int mEventType = START_DOCUMENT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.422 -0400", hash_original_method = "2D249E03AFD474FA9CDB4E7172E5ABB4", hash_generated_method = "DC07F5E54AE7F03957056D7EBA481B90")
          Parser(int parseState, XmlBlock block) {
            mParseState = parseState;
            mBlock = block;
            // ---------- Original Method ----------
            //mParseState = parseState;
            //mBlock = block;
            //block.mOpenCount++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.428 -0400", hash_original_method = "C272D7923F75EBE1BE9678831233D06B", hash_generated_method = "7C6B24293105A643B5FA9505DB2EB422")
        public void setFeature(String name, boolean state) throws XmlPullParserException {
            {
                boolean varB94CA82C41719F3E969BD618F7E5D9E4_682873969 = (FEATURE_PROCESS_NAMESPACES.equals(name) && state);
            } //End collapsed parenthetic
            {
                boolean var46B472FB98C8A84DE2826A8C4EA5EA01_1816310744 = (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name) && state);
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Unsupported feature: " + name);
            addTaint(name.getTaint());
            addTaint(state);
            // ---------- Original Method ----------
            //if (FEATURE_PROCESS_NAMESPACES.equals(name) && state) {
                //return;
            //}
            //if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name) && state) {
                //return;
            //}
            //throw new XmlPullParserException("Unsupported feature: " + name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.429 -0400", hash_original_method = "AB43D5F41C6A1AAA22A1C5749D672E40", hash_generated_method = "401A31E7E4A43EA112A7802989CEC660")
        public boolean getFeature(String name) {
            {
                boolean var30BD9FC73D8A5FB7FF062BA1F723D3AA_1323044461 = (FEATURE_PROCESS_NAMESPACES.equals(name));
            } //End collapsed parenthetic
            {
                boolean var5829279DB6D53DE356D337B03CF1D24E_1551855522 = (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name));
            } //End collapsed parenthetic
            addTaint(name.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_238874744 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_238874744;
            // ---------- Original Method ----------
            //if (FEATURE_PROCESS_NAMESPACES.equals(name)) {
                //return true;
            //}
            //if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name)) {
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.443 -0400", hash_original_method = "B8013E7A09E481D305959C445CAA259A", hash_generated_method = "F4CA7ACF3429D8D3EC0C51506AA96CE2")
        public void setProperty(String name, Object value) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setProperty() not supported");
            addTaint(name.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setProperty() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.444 -0400", hash_original_method = "5175B2315D9AD451CFA017AE30114E6D", hash_generated_method = "D2AB3658139EBF1B97899ABD66ACED31")
        public Object getProperty(String name) {
            Object varB4EAC82CA7396A68D541C85D26508E83_159745366 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_159745366 = null;
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_159745366.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_159745366;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.445 -0400", hash_original_method = "C407C4DE5B4382B09BED3CBFBB5B2FE9", hash_generated_method = "99684ED610434DFB2715A98BDF0C9681")
        public void setInput(Reader in) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setInput() not supported");
            addTaint(in.getTaint());
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setInput() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.469 -0400", hash_original_method = "2056A33FA2E1F0F175E1EBF8A8F56238", hash_generated_method = "7693B1D4D6943793D3FE1CF423081746")
        public void setInput(InputStream inputStream, String inputEncoding) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setInput() not supported");
            addTaint(inputStream.getTaint());
            addTaint(inputEncoding.getTaint());
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setInput() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.470 -0400", hash_original_method = "523C048AE61D8B3E324838EE2E3CB0C0", hash_generated_method = "7510301D985B152E3D6018F1641592EF")
        public void defineEntityReplacementText(String entityName, String replacementText) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("defineEntityReplacementText() not supported");
            addTaint(entityName.getTaint());
            addTaint(replacementText.getTaint());
            // ---------- Original Method ----------
            //throw new XmlPullParserException("defineEntityReplacementText() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.470 -0400", hash_original_method = "A5499422039640FD4F9D5601F1C55CCA", hash_generated_method = "5A1820670FF9E1B1F58A76AE3B92A12B")
        public String getNamespacePrefix(int pos) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("getNamespacePrefix() not supported");
            addTaint(pos);
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespacePrefix() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.476 -0400", hash_original_method = "5C999184AAA0F0E674F1363E90C0FD13", hash_generated_method = "2ED60B7DF457D29B2D75716A64301D79")
        public String getInputEncoding() {
            String varB4EAC82CA7396A68D541C85D26508E83_1086663274 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1086663274 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1086663274.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1086663274;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.477 -0400", hash_original_method = "AE6D93E7ABBCC0A1FA148BC6AE95DD76", hash_generated_method = "BBE1E7E60FD88248A0A020D7D18AA3A3")
        public String getNamespace(String prefix) {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getNamespace() not supported");
            addTaint(prefix.getTaint());
            // ---------- Original Method ----------
            //throw new RuntimeException("getNamespace() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.478 -0400", hash_original_method = "A423E278D1BE175DD386F3DED425ED1E", hash_generated_method = "319E6FE1AE303333DBD4F4ABE46516E4")
        public int getNamespaceCount(int depth) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("getNamespaceCount() not supported");
            addTaint(depth);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103580191 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103580191;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespaceCount() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.495 -0400", hash_original_method = "D2403D5573FCC08ECC8A73989B7EFE93", hash_generated_method = "A9082C2644F18868EBF5DFC86F3FF02E")
        public String getPositionDescription() {
            String varB4EAC82CA7396A68D541C85D26508E83_1461659032 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1461659032 = "Binary XML file line #" + getLineNumber();
            varB4EAC82CA7396A68D541C85D26508E83_1461659032.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1461659032;
            // ---------- Original Method ----------
            //return "Binary XML file line #" + getLineNumber();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.496 -0400", hash_original_method = "0BA86538E6BFE859243D39CD091AF1CC", hash_generated_method = "F214E776EEAB004F6028C7D166FAB46D")
        public String getNamespaceUri(int pos) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("getNamespaceUri() not supported");
            addTaint(pos);
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespaceUri() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.497 -0400", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "B23EB23C4611F959704D4FAF0559CDA3")
        public int getColumnNumber() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176230694 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176230694;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.497 -0400", hash_original_method = "DE1021F4C2B2A1E4D5CF36677B434DEA", hash_generated_method = "3FDE11FEBF87615771637F89D9BBC172")
        public int getDepth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1680192095 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1680192095;
            // ---------- Original Method ----------
            //return mDepth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.498 -0400", hash_original_method = "9AA17B3C306C694E2A4C941D5BD64364", hash_generated_method = "2465E42B67D1BCEC751F02A07F8D6810")
        public String getText() {
            String varB4EAC82CA7396A68D541C85D26508E83_701725477 = null; //Variable for return #1
            int id;
            id = nativeGetText(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_701725477 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_701725477.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_701725477;
            // ---------- Original Method ----------
            //int id = nativeGetText(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.499 -0400", hash_original_method = "D6658BAD08E09D6B5CC695C7702E23C1", hash_generated_method = "EBE10603FAD8940E294743DD58C9C747")
        public int getLineNumber() {
            int varBAA831A065AF74337E20120097F7F4FD_664290599 = (nativeGetLineNumber(mParseState));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288696104 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288696104;
            // ---------- Original Method ----------
            //return nativeGetLineNumber(mParseState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.499 -0400", hash_original_method = "8A2CD03AAFDD20222A8759980FBB28AE", hash_generated_method = "CB4C0353AD057BA020BB2E9C49FCF92A")
        public int getEventType() throws XmlPullParserException {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458507732 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458507732;
            // ---------- Original Method ----------
            //return mEventType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.507 -0400", hash_original_method = "926F3413D3806C4A183D059B4FD2543E", hash_generated_method = "A30006525A79C4E803A9E11383CB4973")
        public boolean isWhitespace() throws XmlPullParserException {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274220486 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_274220486;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.525 -0400", hash_original_method = "692B884A81B63C3B5FA2E5F7E1379D3F", hash_generated_method = "C3F8B39F24F360249FCD5FC6C50AABB3")
        public String getPrefix() {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getPrefix not supported");
            // ---------- Original Method ----------
            //throw new RuntimeException("getPrefix not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.528 -0400", hash_original_method = "03AC06D9FB54ABC98AEB5C7372B8DFCE", hash_generated_method = "95F02B9D8827F0473219F0A678944EBA")
        public char[] getTextCharacters(int[] holderForStartAndLength) {
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
            addTaint(holderForStartAndLength[0]);
            char[] var50607924ABD4C17119BAF3A1CE41C0EC_1947570709 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_1947570709;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.529 -0400", hash_original_method = "53E841A7D41D7C8EC6230F47D159F5F8", hash_generated_method = "65398B349C7B2CCE052539962571E70C")
        public String getNamespace() {
            String varB4EAC82CA7396A68D541C85D26508E83_691872315 = null; //Variable for return #1
            int id;
            id = nativeGetNamespace(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_691872315 = id >= 0 ? mStrings.get(id).toString() : "";
            varB4EAC82CA7396A68D541C85D26508E83_691872315.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_691872315;
            // ---------- Original Method ----------
            //int id = nativeGetNamespace(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.547 -0400", hash_original_method = "5E952CADD7A547B8BBE8593EB2804E3F", hash_generated_method = "25F5677C9E56E38D81D4C3A657B4EE6C")
        public String getName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1769088172 = null; //Variable for return #1
            int id;
            id = nativeGetName(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_1769088172 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1769088172.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1769088172;
            // ---------- Original Method ----------
            //int id = nativeGetName(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.550 -0400", hash_original_method = "C5B0A5333E9C04C4ABC345C16B794494", hash_generated_method = "23B89DA1AFB3678F0CF13AED426FDA99")
        public String getAttributeNamespace(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_994350149 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_256014559 = null; //Variable for return #2
            int id;
            id = nativeGetAttributeNamespace(mParseState, index);
            System.out.println("getAttributeNamespace of " + index + " = " + id);
            varB4EAC82CA7396A68D541C85D26508E83_994350149 = mStrings.get(id).toString();
            varB4EAC82CA7396A68D541C85D26508E83_256014559 = "";
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            addTaint(index);
            String varA7E53CE21691AB073D9660D615818899_868721326; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_868721326 = varB4EAC82CA7396A68D541C85D26508E83_994350149;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_868721326 = varB4EAC82CA7396A68D541C85D26508E83_256014559;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_868721326.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_868721326;
            // ---------- Original Method ----------
            //int id = nativeGetAttributeNamespace(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeNamespace of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //else if (id == -1) return "";
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.578 -0400", hash_original_method = "84AEB345F706FFE756390519A4CE900D", hash_generated_method = "88482B71CA748EDD6E0DFDCB997B930A")
        public String getAttributeName(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_1618310613 = null; //Variable for return #1
            int id;
            id = nativeGetAttributeName(mParseState, index);
            System.out.println("getAttributeName of " + index + " = " + id);
            varB4EAC82CA7396A68D541C85D26508E83_1618310613 = mStrings.get(id).toString();
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1618310613.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1618310613;
            // ---------- Original Method ----------
            //int id = nativeGetAttributeName(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeName of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.580 -0400", hash_original_method = "50B51A25D0464B8FD90EECF499D60B48", hash_generated_method = "8981166C7E6540038A16C40BE0EDD139")
        public String getAttributePrefix(int index) {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getAttributePrefix not supported");
            addTaint(index);
            // ---------- Original Method ----------
            //throw new RuntimeException("getAttributePrefix not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.580 -0400", hash_original_method = "860332C2A14F44509730B84BDA1621A5", hash_generated_method = "7BC5B20EF76B1A22FB510907203C3B48")
        public boolean isEmptyElementTag() throws XmlPullParserException {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1191404769 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1191404769;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.595 -0400", hash_original_method = "AF6A401047A56BD2769A9CCD0765487F", hash_generated_method = "24A948C7C083CAB52A8026716603D41A")
        public int getAttributeCount() {
            {
                Object var4E40D70343CD40DEDD7252A82F34EED9_1461396575 = (nativeGetAttributeCount(mParseState));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_763554954 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_763554954;
            // ---------- Original Method ----------
            //return mEventType == START_TAG ? nativeGetAttributeCount(mParseState) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.614 -0400", hash_original_method = "F4E9CDB9F128BA6177C44CACB76DA2CC", hash_generated_method = "19125ADB627AAAC2FF2D1EF7BB3B029E")
        public String getAttributeValue(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_1812427972 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_570689403 = null; //Variable for return #2
            int id;
            id = nativeGetAttributeStringValue(mParseState, index);
            System.out.println("getAttributeValue of " + index + " = " + id);
            varB4EAC82CA7396A68D541C85D26508E83_1812427972 = mStrings.get(id).toString();
            int t;
            t = nativeGetAttributeDataType(mParseState, index);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            } //End block
            int v;
            v = nativeGetAttributeData(mParseState, index);
            varB4EAC82CA7396A68D541C85D26508E83_570689403 = TypedValue.coerceToString(t, v);
            addTaint(index);
            String varA7E53CE21691AB073D9660D615818899_405752687; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_405752687 = varB4EAC82CA7396A68D541C85D26508E83_1812427972;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_405752687 = varB4EAC82CA7396A68D541C85D26508E83_570689403;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_405752687.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_405752687;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.615 -0400", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "E294608DA2528D72C082C11274312FF7")
        public String getAttributeType(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_1762162030 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1762162030 = "CDATA";
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1762162030.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1762162030;
            // ---------- Original Method ----------
            //return "CDATA";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.616 -0400", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "D39820135DC0C889165D0DDB78E03627")
        public boolean isAttributeDefault(int index) {
            addTaint(index);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1976442419 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1976442419;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.631 -0400", hash_original_method = "F3E3F86FBCCE797A7D99504582A16A5E", hash_generated_method = "FF0CEFFA0D88CD26640C813ACD6B828B")
        public int nextToken() throws XmlPullParserException,IOException {
            int var83133C39DBD81A6FC01ACC28F158E440_709295136 = (next());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138991455 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138991455;
            // ---------- Original Method ----------
            //return next();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.634 -0400", hash_original_method = "8127D80C9F5EEB177072DC0AE91ACB4C", hash_generated_method = "9FA406BE3DC0B4E12D538DC577039517")
        public String getAttributeValue(String namespace, String name) {
            String varB4EAC82CA7396A68D541C85D26508E83_72075258 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_2008139993 = null; //Variable for return #2
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, name);
            {
                System.out.println("getAttributeName of "
                        + namespace + ":" + name + " index = " + idx);
                System.out.println(
                        "Namespace=" + getAttributeNamespace(idx)
                        + "Name=" + getAttributeName(idx)
                        + ", Value=" + getAttributeValue(idx));
                varB4EAC82CA7396A68D541C85D26508E83_72075258 = getAttributeValue(idx);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2008139993 = null;
            addTaint(namespace.getTaint());
            addTaint(name.getTaint());
            String varA7E53CE21691AB073D9660D615818899_1721479300; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1721479300 = varB4EAC82CA7396A68D541C85D26508E83_72075258;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1721479300 = varB4EAC82CA7396A68D541C85D26508E83_2008139993;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1721479300.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1721479300;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.654 -0400", hash_original_method = "2DA88A175068BC957038D4798DAD0AF9", hash_generated_method = "5A9CA7110963FD3DAEAD5A186F71DD92")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677371689 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677371689;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.660 -0400", hash_original_method = "A600298A9B2D06DCD3FD708D87D4E435", hash_generated_method = "4D461041C017C12D260FCC7A49956BE4")
        public void require(int type, String namespace, String name) throws XmlPullParserException,IOException {
            {
                boolean var97810C1B0E0CD8066713029C8CFC3E70_2036100544 = (type != getEventType()
                || (namespace != null && !namespace.equals( getNamespace () ) )
                || (name != null && !name.equals( getName() ) ));
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException( "expected "+ TYPES[ type ]+getPositionDescription());
            } //End collapsed parenthetic
            addTaint(type);
            addTaint(namespace.getTaint());
            addTaint(name.getTaint());
            // ---------- Original Method ----------
            //if (type != getEventType()
                //|| (namespace != null && !namespace.equals( getNamespace () ) )
                //|| (name != null && !name.equals( getName() ) ) )
                //throw new XmlPullParserException( "expected "+ TYPES[ type ]+getPositionDescription());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.674 -0400", hash_original_method = "0387CD391BE287242825F05D1B5C07FC", hash_generated_method = "EEA843E057B177BF8E1EF48C60096450")
        public String nextText() throws XmlPullParserException,IOException {
            String varB4EAC82CA7396A68D541C85D26508E83_297660288 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1666723129 = null; //Variable for return #2
            {
                boolean var9596CF2618BFAD282E250C866F3DF3C9_940581472 = (getEventType() != START_TAG);
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
                varB4EAC82CA7396A68D541C85D26508E83_297660288 = result;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1666723129 = "";
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG or TEXT to read text", this, null);
            } //End block
            String varA7E53CE21691AB073D9660D615818899_1757696243; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1757696243 = varB4EAC82CA7396A68D541C85D26508E83_297660288;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1757696243 = varB4EAC82CA7396A68D541C85D26508E83_1666723129;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1757696243.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1757696243;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.676 -0400", hash_original_method = "86ECF63697C3285DB17A648F53C02562", hash_generated_method = "49C0F978A26F73E5C2C35B84528D4A91")
        public int nextTag() throws XmlPullParserException,IOException {
            int eventType;
            eventType = next();
            {
                boolean varC64C896D81E5DDFF005758762D652945_839719859 = (eventType == TEXT && isWhitespace());
                {
                    eventType = next();
                } //End block
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                   getPositionDescription() 
                   + ": expected start or end tag", this, null);
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788187987 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788187987;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.677 -0400", hash_original_method = "F89E8721AF5486B49BDF02DB68EDEEE5", hash_generated_method = "6D4C2B7698ED94543645DDF88D670E1A")
        public int getAttributeNameResource(int index) {
            int varF6A84D2EA99C427754EE4C64391AE074_1543940219 = (nativeGetAttributeResource(mParseState, index));
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487677688 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487677688;
            // ---------- Original Method ----------
            //return nativeGetAttributeResource(mParseState, index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.696 -0400", hash_original_method = "1215FB5AAEE746C41F9FA8271AAF1E60", hash_generated_method = "EB5799F46184A28A161BC2BB9CB387C8")
        public int getAttributeListValue(String namespace, String attribute,
                String[] options, int defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var9746577ED7FA626EB250C6FA1993E568_716079808 = (getAttributeListValue(idx, options, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(options[0].getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517563777 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517563777;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeListValue(idx, options, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.697 -0400", hash_original_method = "B01E2E5CC96F6EF51E59D8D07AB9873A", hash_generated_method = "F11E2AB4F903C730C119E5B9514821B6")
        public boolean getAttributeBooleanValue(String namespace, String attribute,
                boolean defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                boolean var112C81F0CF2922B630967C489E44FCE2_67920579 = (getAttributeBooleanValue(idx, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_874069880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_874069880;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeBooleanValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.721 -0400", hash_original_method = "CB3F64435C40C20F84A081F8E49D1C0C", hash_generated_method = "9756D6AC8AED7260483606B86B05AAD4")
        public int getAttributeResourceValue(String namespace, String attribute,
                int defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var4041CE7258634F39669102768A31E2B5_452940699 = (getAttributeResourceValue(idx, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665784413 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665784413;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeResourceValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.722 -0400", hash_original_method = "8EF5A68420C37BD2779707A79B9C3811", hash_generated_method = "171C1FD0D52D65573FD65133EEBD84D2")
        public int getAttributeIntValue(String namespace, String attribute,
                int defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var98A36DA81833C24E66998F976469DC76_1443299682 = (getAttributeIntValue(idx, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102042592 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102042592;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeIntValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.723 -0400", hash_original_method = "133F9E0C363583A7982FF4EDA455C0C4", hash_generated_method = "26F47A1272273BE4F1D433176D38DCE5")
        public int getAttributeUnsignedIntValue(String namespace, String attribute,
                                                int defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var6B4AE1ACD2501944E06884239ECFC491_1296009797 = (getAttributeUnsignedIntValue(idx, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_204999043 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_204999043;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeUnsignedIntValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.725 -0400", hash_original_method = "91D09444FE7CF8F77D4AFF725E1E8970", hash_generated_method = "D122BCA03EE13B7D21B21207A23AD1EC")
        public float getAttributeFloatValue(String namespace, String attribute,
                float defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                float var8ADD88168EAB5E1C9157AC1388ED29E4_1918075914 = (getAttributeFloatValue(idx, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            float var546ADE640B6EDFBC8A086EF31347E768_1201548536 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1201548536;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeFloatValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.727 -0400", hash_original_method = "2BA8E9098E1E3526495883648F7DEF5F", hash_generated_method = "8CF64C41CF5FF14F16B361B4F2663F6E")
        public int getAttributeListValue(int idx,
                String[] options, int defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            int v;
            v = nativeGetAttributeData(mParseState, idx);
            {
                int var87C4679D2BF706005778803B1AE8C887_773714734 = (XmlUtils.convertValueToList(
                    mStrings.get(v), options, defaultValue));
            } //End block
            addTaint(idx);
            addTaint(options[0].getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93510985 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93510985;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //int v = nativeGetAttributeData(mParseState, idx);
            //if (t == TypedValue.TYPE_STRING) {
                //return XmlUtils.convertValueToList(
                    //mStrings.get(v), options, defaultValue);
            //}
            //return v;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.753 -0400", hash_original_method = "9FDDF9436ABA275F049CE63B7297D004", hash_generated_method = "BD76A2A5CF37A75D984171BCE859CC12")
        public boolean getAttributeBooleanValue(int idx,
                boolean defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                boolean var612CB30EBEACD27A167E09918F9B42F1_367359463 = (nativeGetAttributeData(mParseState, idx) != 0);
            } //End block
            addTaint(idx);
            addTaint(defaultValue);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1644786721 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1644786721;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx) != 0;
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.754 -0400", hash_original_method = "0D4A13949891098942D2BD0FE4681BA9", hash_generated_method = "F569BFBA8369157E332A8958020BE7DC")
        public int getAttributeResourceValue(int idx, int defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_379496603 = (nativeGetAttributeData(mParseState, idx));
            } //End block
            addTaint(idx);
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132168411 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132168411;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t == TypedValue.TYPE_REFERENCE) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.755 -0400", hash_original_method = "76347FF1C756B55868935018572B3748", hash_generated_method = "F1E1ACF98380D5B1C0A1A9437BBA5EC6")
        public int getAttributeIntValue(int idx, int defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_1952395654 = (nativeGetAttributeData(mParseState, idx));
            } //End block
            addTaint(idx);
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_53544859 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_53544859;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.756 -0400", hash_original_method = "10FB8704E5561F244AB5AE7B4EFD0C1E", hash_generated_method = "DEBBEBFFCE4B1DBE70EE1A192E1057CB")
        public int getAttributeUnsignedIntValue(int idx, int defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_334756166 = (nativeGetAttributeData(mParseState, idx));
            } //End block
            addTaint(idx);
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530781877 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530781877;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.773 -0400", hash_original_method = "BBF18D629EB0696226FD45DB0C0888CC", hash_generated_method = "BB90714D043E9B7CDF4859CA19D65216")
        public float getAttributeFloatValue(int idx, float defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                float var7FE27D38E8241DD13E64DA80050555B4_206669100 = (Float.intBitsToFloat(
                    nativeGetAttributeData(mParseState, idx)));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("not a float!");
            addTaint(idx);
            addTaint(defaultValue);
            float var546ADE640B6EDFBC8A086EF31347E768_627889706 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_627889706;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t == TypedValue.TYPE_FLOAT) {
                //return Float.intBitsToFloat(
                    //nativeGetAttributeData(mParseState, idx));
            //}
            //throw new RuntimeException("not a float!");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.774 -0400", hash_original_method = "459DE28869C0476D8004C0FC89A0FAA3", hash_generated_method = "B6E2754740E000ED0BBB9FE29BDE894F")
        public String getIdAttribute() {
            String varB4EAC82CA7396A68D541C85D26508E83_1920532741 = null; //Variable for return #1
            int id;
            id = nativeGetIdAttribute(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_1920532741 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1920532741.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1920532741;
            // ---------- Original Method ----------
            //int id = nativeGetIdAttribute(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.775 -0400", hash_original_method = "6EA4969C84EC91743C886113DBDA4AC3", hash_generated_method = "F8D2191F2AAFEED6FCD662FFB2D99543")
        public String getClassAttribute() {
            String varB4EAC82CA7396A68D541C85D26508E83_1559263004 = null; //Variable for return #1
            int id;
            id = nativeGetClassAttribute(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_1559263004 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1559263004.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1559263004;
            // ---------- Original Method ----------
            //int id = nativeGetClassAttribute(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.776 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "0B3273BF5288E1E78C382846BEC3A7DD")
        public int getIdAttributeResourceValue(int defaultValue) {
            int var3134D2BCB0EA7E34279C8DC792789F56_1702320297 = (getAttributeResourceValue(null, "id", defaultValue));
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598457060 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598457060;
            // ---------- Original Method ----------
            //return getAttributeResourceValue(null, "id", defaultValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.776 -0400", hash_original_method = "34AB6D031D153719912E2897914AFEED", hash_generated_method = "43EC98FF84D11C73621F97188A72521F")
        public int getStyleAttribute() {
            int var24F64E8584039948E1AFFBFA2A70D193_46748057 = (nativeGetStyleAttribute(mParseState));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847096822 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847096822;
            // ---------- Original Method ----------
            //return nativeGetStyleAttribute(mParseState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.786 -0400", hash_original_method = "283F7DAAD4F2484127D9024B5883A661", hash_generated_method = "0495834BCB8967EEAAC0C90DB330C999")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.787 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        protected void finalize() throws Throwable {
            close();
            // ---------- Original Method ----------
            //close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.788 -0400", hash_original_method = "E55719651A1187D6CF490013E1512769", hash_generated_method = "94095E73CE65B10CC5C94F35A65F6273")
        final CharSequence getPooledString(int id) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1848337063 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1848337063 = mStrings.get(id);
            addTaint(id);
            varB4EAC82CA7396A68D541C85D26508E83_1848337063.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1848337063;
            // ---------- Original Method ----------
            //return mStrings.get(id);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.805 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
}

