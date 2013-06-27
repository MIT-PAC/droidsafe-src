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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.146 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "49B4A4B4F77DF85AA82FF83B2F894508")

    private AssetManager mAssets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.146 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.146 -0400", hash_original_field = "DCFA8FC1CFB8B5A5290D25EC1EA3C56B", hash_generated_field = "E687239F3E1A0E0370D394F826B65E89")

    StringBlock mStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.146 -0400", hash_original_field = "FA3F9A9DA0C13C19A5EFA6211E2FE7F3", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.146 -0400", hash_original_field = "1DD071DB88934A0BCF394BA8B6213C8D", hash_generated_field = "D98A2F1C489BE52721534D4A450F131E")

    private int mOpenCount = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.148 -0400", hash_original_method = "A22EEB27BFE227BD171CA1655E28A01F", hash_generated_method = "4AE7DDE59497735C74D31FB0EB379F5F")
    public  XmlBlock(byte[] data) {
        mAssets = null;
        mNative = nativeCreate(data, 0, data.length);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        // ---------- Original Method ----------
        //mAssets = null;
        //mNative = nativeCreate(data, 0, data.length);
        //mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.158 -0400", hash_original_method = "B1D68A7ECB78CEADC57D198A6FDBCA28", hash_generated_method = "AB11E1FEA4E4C63AD257E940DE94AF11")
    public  XmlBlock(byte[] data, int offset, int size) {
        mAssets = null;
        mNative = nativeCreate(data, offset, size);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        // ---------- Original Method ----------
        //mAssets = null;
        //mNative = nativeCreate(data, offset, size);
        //mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.159 -0400", hash_original_method = "2D0B3C5ECC15AA5F78B0AD70805A049B", hash_generated_method = "2E005A9D8EA3DF78882014B9F5C7AE35")
      XmlBlock(AssetManager assets, int xmlBlock) {
        mAssets = assets;
        mNative = xmlBlock;
        mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
        // ---------- Original Method ----------
        //mAssets = assets;
        //mNative = xmlBlock;
        //mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.171 -0400", hash_original_method = "92B3E7DBAA5D8D51C162522636FE2570", hash_generated_method = "B4E7DA18AC06A705B61F6622C9433AEA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.172 -0400", hash_original_method = "017FB1456432C4B45E3EDBB9E5F1A65C", hash_generated_method = "755E68CBCCC578A6BE297FE901E3483E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.174 -0400", hash_original_method = "36FE28CA3339B97C4303841D21F6E4EF", hash_generated_method = "0A5B70485E08BA45509E781F44F843BB")
    public XmlResourceParser newParser() {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1427480246 = null; //Variable for return #1
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_245978541 = null; //Variable for return #2
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1427480246 = new Parser(nativeCreateParseState(mNative), this);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_245978541 = null;
        } //End block
        XmlResourceParser varA7E53CE21691AB073D9660D615818899_1885105706; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1885105706 = varB4EAC82CA7396A68D541C85D26508E83_1427480246;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1885105706 = varB4EAC82CA7396A68D541C85D26508E83_245978541;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1885105706.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1885105706;
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mNative != 0) {
                //return new Parser(nativeCreateParseState(mNative), this);
            //}
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.182 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.229 -0400", hash_original_field = "4BFB0B80D080363EFC5373B871FF0770", hash_generated_field = "6CCE16E02108F8B5004F82A927CFF083")

        int mParseState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.230 -0400", hash_original_field = "E5ADD54C021234204DB48E99A01961D7", hash_generated_field = "3EDA85A0804ED213AA0240D41752F909")

        private XmlBlock mBlock;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.230 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

        private boolean mStarted = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.230 -0400", hash_original_field = "0A0A65D3B2CBF183A116FD12849B0451", hash_generated_field = "202F76F59FBD4A34EFD44A9FC7F2ED5B")

        private boolean mDecNextDepth = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.230 -0400", hash_original_field = "8A9EE96E8F54650AD1636FC7C1C10A9A", hash_generated_field = "67A287B1854820A57845B046DB8B7A31")

        private int mDepth = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.230 -0400", hash_original_field = "35AE7FC4CD775545AD93999E73996B6A", hash_generated_field = "4840498E2AA207F0162BEB5586951A29")

        private int mEventType = START_DOCUMENT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.240 -0400", hash_original_method = "2D249E03AFD474FA9CDB4E7172E5ABB4", hash_generated_method = "DC07F5E54AE7F03957056D7EBA481B90")
          Parser(int parseState, XmlBlock block) {
            mParseState = parseState;
            mBlock = block;
            // ---------- Original Method ----------
            //mParseState = parseState;
            //mBlock = block;
            //block.mOpenCount++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.242 -0400", hash_original_method = "C272D7923F75EBE1BE9678831233D06B", hash_generated_method = "E1EA76D6B16532C35F5F3E98CF124656")
        public void setFeature(String name, boolean state) throws XmlPullParserException {
            {
                boolean varB94CA82C41719F3E969BD618F7E5D9E4_1519188957 = (FEATURE_PROCESS_NAMESPACES.equals(name) && state);
            } //End collapsed parenthetic
            {
                boolean var46B472FB98C8A84DE2826A8C4EA5EA01_800490200 = (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name) && state);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.256 -0400", hash_original_method = "AB43D5F41C6A1AAA22A1C5749D672E40", hash_generated_method = "91F1AFC11DC2B7AE802326BBAA46541F")
        public boolean getFeature(String name) {
            {
                boolean var30BD9FC73D8A5FB7FF062BA1F723D3AA_1101080195 = (FEATURE_PROCESS_NAMESPACES.equals(name));
            } //End collapsed parenthetic
            {
                boolean var5829279DB6D53DE356D337B03CF1D24E_931445356 = (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name));
            } //End collapsed parenthetic
            addTaint(name.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779343192 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_779343192;
            // ---------- Original Method ----------
            //if (FEATURE_PROCESS_NAMESPACES.equals(name)) {
                //return true;
            //}
            //if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name)) {
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.257 -0400", hash_original_method = "B8013E7A09E481D305959C445CAA259A", hash_generated_method = "F4CA7ACF3429D8D3EC0C51506AA96CE2")
        public void setProperty(String name, Object value) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setProperty() not supported");
            addTaint(name.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setProperty() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.270 -0400", hash_original_method = "5175B2315D9AD451CFA017AE30114E6D", hash_generated_method = "75D82DFC19A6E6969F80D8743D133150")
        public Object getProperty(String name) {
            Object varB4EAC82CA7396A68D541C85D26508E83_767317104 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_767317104 = null;
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_767317104.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_767317104;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.271 -0400", hash_original_method = "C407C4DE5B4382B09BED3CBFBB5B2FE9", hash_generated_method = "99684ED610434DFB2715A98BDF0C9681")
        public void setInput(Reader in) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setInput() not supported");
            addTaint(in.getTaint());
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setInput() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.272 -0400", hash_original_method = "2056A33FA2E1F0F175E1EBF8A8F56238", hash_generated_method = "7693B1D4D6943793D3FE1CF423081746")
        public void setInput(InputStream inputStream, String inputEncoding) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setInput() not supported");
            addTaint(inputStream.getTaint());
            addTaint(inputEncoding.getTaint());
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setInput() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.280 -0400", hash_original_method = "523C048AE61D8B3E324838EE2E3CB0C0", hash_generated_method = "7510301D985B152E3D6018F1641592EF")
        public void defineEntityReplacementText(String entityName, String replacementText) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("defineEntityReplacementText() not supported");
            addTaint(entityName.getTaint());
            addTaint(replacementText.getTaint());
            // ---------- Original Method ----------
            //throw new XmlPullParserException("defineEntityReplacementText() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.281 -0400", hash_original_method = "A5499422039640FD4F9D5601F1C55CCA", hash_generated_method = "5A1820670FF9E1B1F58A76AE3B92A12B")
        public String getNamespacePrefix(int pos) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("getNamespacePrefix() not supported");
            addTaint(pos);
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespacePrefix() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.293 -0400", hash_original_method = "5C999184AAA0F0E674F1363E90C0FD13", hash_generated_method = "454C860C95A6B8F4A955B211F73AFADE")
        public String getInputEncoding() {
            String varB4EAC82CA7396A68D541C85D26508E83_1456035804 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1456035804 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1456035804.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1456035804;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.302 -0400", hash_original_method = "AE6D93E7ABBCC0A1FA148BC6AE95DD76", hash_generated_method = "BBE1E7E60FD88248A0A020D7D18AA3A3")
        public String getNamespace(String prefix) {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getNamespace() not supported");
            addTaint(prefix.getTaint());
            // ---------- Original Method ----------
            //throw new RuntimeException("getNamespace() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.303 -0400", hash_original_method = "A423E278D1BE175DD386F3DED425ED1E", hash_generated_method = "2B7A59EF8F2E97E91246780531FE98CB")
        public int getNamespaceCount(int depth) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("getNamespaceCount() not supported");
            addTaint(depth);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668979724 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668979724;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespaceCount() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.309 -0400", hash_original_method = "D2403D5573FCC08ECC8A73989B7EFE93", hash_generated_method = "C22BFF4C0599FAE7552977774D35D9AC")
        public String getPositionDescription() {
            String varB4EAC82CA7396A68D541C85D26508E83_1688851812 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1688851812 = "Binary XML file line #" + getLineNumber();
            varB4EAC82CA7396A68D541C85D26508E83_1688851812.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1688851812;
            // ---------- Original Method ----------
            //return "Binary XML file line #" + getLineNumber();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.319 -0400", hash_original_method = "0BA86538E6BFE859243D39CD091AF1CC", hash_generated_method = "F214E776EEAB004F6028C7D166FAB46D")
        public String getNamespaceUri(int pos) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("getNamespaceUri() not supported");
            addTaint(pos);
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespaceUri() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.320 -0400", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "7B3378F7E2B79509ED3828EFA9275382")
        public int getColumnNumber() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1590277453 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1590277453;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.320 -0400", hash_original_method = "DE1021F4C2B2A1E4D5CF36677B434DEA", hash_generated_method = "CDAE6A1D1766EC64341D93A52365A6BF")
        public int getDepth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097935362 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097935362;
            // ---------- Original Method ----------
            //return mDepth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.321 -0400", hash_original_method = "9AA17B3C306C694E2A4C941D5BD64364", hash_generated_method = "73419FADCA1B92C90FB8FA4F29100B78")
        public String getText() {
            String varB4EAC82CA7396A68D541C85D26508E83_1886566333 = null; //Variable for return #1
            int id;
            id = nativeGetText(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_1886566333 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1886566333.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1886566333;
            // ---------- Original Method ----------
            //int id = nativeGetText(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.324 -0400", hash_original_method = "D6658BAD08E09D6B5CC695C7702E23C1", hash_generated_method = "EDB01A02775E6E4D6F254E4060D615BD")
        public int getLineNumber() {
            int varBAA831A065AF74337E20120097F7F4FD_1033876098 = (nativeGetLineNumber(mParseState));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844769408 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844769408;
            // ---------- Original Method ----------
            //return nativeGetLineNumber(mParseState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.325 -0400", hash_original_method = "8A2CD03AAFDD20222A8759980FBB28AE", hash_generated_method = "76BC698ACA43C5128887EF3C487E138D")
        public int getEventType() throws XmlPullParserException {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537371678 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537371678;
            // ---------- Original Method ----------
            //return mEventType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.326 -0400", hash_original_method = "926F3413D3806C4A183D059B4FD2543E", hash_generated_method = "6B7BA33B31AB73A0F8A81A1C37E6F70D")
        public boolean isWhitespace() throws XmlPullParserException {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423067498 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423067498;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.326 -0400", hash_original_method = "692B884A81B63C3B5FA2E5F7E1379D3F", hash_generated_method = "C3F8B39F24F360249FCD5FC6C50AABB3")
        public String getPrefix() {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getPrefix not supported");
            // ---------- Original Method ----------
            //throw new RuntimeException("getPrefix not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.356 -0400", hash_original_method = "03AC06D9FB54ABC98AEB5C7372B8DFCE", hash_generated_method = "AE64FAE45F300651A62EE23F3987C827")
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
            char[] var50607924ABD4C17119BAF3A1CE41C0EC_1479421294 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_1479421294;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.365 -0400", hash_original_method = "53E841A7D41D7C8EC6230F47D159F5F8", hash_generated_method = "B767E4626910DD077FC18DE41D76A83E")
        public String getNamespace() {
            String varB4EAC82CA7396A68D541C85D26508E83_1813058840 = null; //Variable for return #1
            int id;
            id = nativeGetNamespace(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_1813058840 = id >= 0 ? mStrings.get(id).toString() : "";
            varB4EAC82CA7396A68D541C85D26508E83_1813058840.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1813058840;
            // ---------- Original Method ----------
            //int id = nativeGetNamespace(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.369 -0400", hash_original_method = "5E952CADD7A547B8BBE8593EB2804E3F", hash_generated_method = "B3AEAD93AC1E587509F3DF61E5CEAB41")
        public String getName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1858209923 = null; //Variable for return #1
            int id;
            id = nativeGetName(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_1858209923 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1858209923.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1858209923;
            // ---------- Original Method ----------
            //int id = nativeGetName(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.371 -0400", hash_original_method = "C5B0A5333E9C04C4ABC345C16B794494", hash_generated_method = "CFEA6A44C880346F1EFA3163FA4B54F1")
        public String getAttributeNamespace(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_2066067470 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1358271495 = null; //Variable for return #2
            int id;
            id = nativeGetAttributeNamespace(mParseState, index);
            System.out.println("getAttributeNamespace of " + index + " = " + id);
            varB4EAC82CA7396A68D541C85D26508E83_2066067470 = mStrings.get(id).toString();
            varB4EAC82CA7396A68D541C85D26508E83_1358271495 = "";
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            addTaint(index);
            String varA7E53CE21691AB073D9660D615818899_1780863103; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1780863103 = varB4EAC82CA7396A68D541C85D26508E83_2066067470;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1780863103 = varB4EAC82CA7396A68D541C85D26508E83_1358271495;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1780863103.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1780863103;
            // ---------- Original Method ----------
            //int id = nativeGetAttributeNamespace(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeNamespace of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //else if (id == -1) return "";
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.395 -0400", hash_original_method = "84AEB345F706FFE756390519A4CE900D", hash_generated_method = "1CA7A60A2479E802C322988059091E75")
        public String getAttributeName(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_1773956526 = null; //Variable for return #1
            int id;
            id = nativeGetAttributeName(mParseState, index);
            System.out.println("getAttributeName of " + index + " = " + id);
            varB4EAC82CA7396A68D541C85D26508E83_1773956526 = mStrings.get(id).toString();
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1773956526.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1773956526;
            // ---------- Original Method ----------
            //int id = nativeGetAttributeName(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeName of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.402 -0400", hash_original_method = "50B51A25D0464B8FD90EECF499D60B48", hash_generated_method = "8981166C7E6540038A16C40BE0EDD139")
        public String getAttributePrefix(int index) {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getAttributePrefix not supported");
            addTaint(index);
            // ---------- Original Method ----------
            //throw new RuntimeException("getAttributePrefix not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.403 -0400", hash_original_method = "860332C2A14F44509730B84BDA1621A5", hash_generated_method = "56A2C2089B27DEB2C9AD60CCDF929925")
        public boolean isEmptyElementTag() throws XmlPullParserException {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708822873 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708822873;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.415 -0400", hash_original_method = "AF6A401047A56BD2769A9CCD0765487F", hash_generated_method = "CE6CFF1F7F01BD4EA4F053CBF0E360FE")
        public int getAttributeCount() {
            {
                Object var4E40D70343CD40DEDD7252A82F34EED9_1557101394 = (nativeGetAttributeCount(mParseState));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019691600 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019691600;
            // ---------- Original Method ----------
            //return mEventType == START_TAG ? nativeGetAttributeCount(mParseState) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.426 -0400", hash_original_method = "F4E9CDB9F128BA6177C44CACB76DA2CC", hash_generated_method = "72E10AB7EE897C77B4C9B9F8B4748A39")
        public String getAttributeValue(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_58432262 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1570421380 = null; //Variable for return #2
            int id;
            id = nativeGetAttributeStringValue(mParseState, index);
            System.out.println("getAttributeValue of " + index + " = " + id);
            varB4EAC82CA7396A68D541C85D26508E83_58432262 = mStrings.get(id).toString();
            int t;
            t = nativeGetAttributeDataType(mParseState, index);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            } //End block
            int v;
            v = nativeGetAttributeData(mParseState, index);
            varB4EAC82CA7396A68D541C85D26508E83_1570421380 = TypedValue.coerceToString(t, v);
            addTaint(index);
            String varA7E53CE21691AB073D9660D615818899_536175433; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_536175433 = varB4EAC82CA7396A68D541C85D26508E83_58432262;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_536175433 = varB4EAC82CA7396A68D541C85D26508E83_1570421380;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_536175433.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_536175433;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.428 -0400", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "675032624C1EE0549A1E408937D6AFF3")
        public String getAttributeType(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_156674142 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_156674142 = "CDATA";
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_156674142.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_156674142;
            // ---------- Original Method ----------
            //return "CDATA";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.429 -0400", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "089A81B2501C9CBD591318086A3AAB30")
        public boolean isAttributeDefault(int index) {
            addTaint(index);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451557216 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_451557216;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.450 -0400", hash_original_method = "F3E3F86FBCCE797A7D99504582A16A5E", hash_generated_method = "EC5931E9AC67517647F984DE06873896")
        public int nextToken() throws XmlPullParserException,IOException {
            int var83133C39DBD81A6FC01ACC28F158E440_1523422648 = (next());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587195136 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587195136;
            // ---------- Original Method ----------
            //return next();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.460 -0400", hash_original_method = "8127D80C9F5EEB177072DC0AE91ACB4C", hash_generated_method = "B2C063EC0C46EA3F9D8D72588CB0D2E3")
        public String getAttributeValue(String namespace, String name) {
            String varB4EAC82CA7396A68D541C85D26508E83_2022116763 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1088192713 = null; //Variable for return #2
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, name);
            {
                System.out.println("getAttributeName of "
                        + namespace + ":" + name + " index = " + idx);
                System.out.println(
                        "Namespace=" + getAttributeNamespace(idx)
                        + "Name=" + getAttributeName(idx)
                        + ", Value=" + getAttributeValue(idx));
                varB4EAC82CA7396A68D541C85D26508E83_2022116763 = getAttributeValue(idx);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1088192713 = null;
            addTaint(namespace.getTaint());
            addTaint(name.getTaint());
            String varA7E53CE21691AB073D9660D615818899_953954631; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_953954631 = varB4EAC82CA7396A68D541C85D26508E83_2022116763;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_953954631 = varB4EAC82CA7396A68D541C85D26508E83_1088192713;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_953954631.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_953954631;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.464 -0400", hash_original_method = "2DA88A175068BC957038D4798DAD0AF9", hash_generated_method = "A7C19320D57201EEB0870EBC20B2216E")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_418897994 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_418897994;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.486 -0400", hash_original_method = "A600298A9B2D06DCD3FD708D87D4E435", hash_generated_method = "683BFE0F6ABCAABCB3666485D8982E89")
        public void require(int type, String namespace, String name) throws XmlPullParserException,IOException {
            {
                boolean var97810C1B0E0CD8066713029C8CFC3E70_897102719 = (type != getEventType()
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.489 -0400", hash_original_method = "0387CD391BE287242825F05D1B5C07FC", hash_generated_method = "C41BA7A8AC3A7F9D70D94E141DAC42A4")
        public String nextText() throws XmlPullParserException,IOException {
            String varB4EAC82CA7396A68D541C85D26508E83_1291846027 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_961921495 = null; //Variable for return #2
            {
                boolean var9596CF2618BFAD282E250C866F3DF3C9_1712380924 = (getEventType() != START_TAG);
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
                varB4EAC82CA7396A68D541C85D26508E83_1291846027 = result;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_961921495 = "";
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG or TEXT to read text", this, null);
            } //End block
            String varA7E53CE21691AB073D9660D615818899_478130182; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_478130182 = varB4EAC82CA7396A68D541C85D26508E83_1291846027;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_478130182 = varB4EAC82CA7396A68D541C85D26508E83_961921495;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_478130182.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_478130182;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.490 -0400", hash_original_method = "86ECF63697C3285DB17A648F53C02562", hash_generated_method = "B1D01FCFA975E20E3C05E6C90F9E0E7E")
        public int nextTag() throws XmlPullParserException,IOException {
            int eventType;
            eventType = next();
            {
                boolean varC64C896D81E5DDFF005758762D652945_385119425 = (eventType == TEXT && isWhitespace());
                {
                    eventType = next();
                } //End block
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                   getPositionDescription() 
                   + ": expected start or end tag", this, null);
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1854174021 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1854174021;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.516 -0400", hash_original_method = "F89E8721AF5486B49BDF02DB68EDEEE5", hash_generated_method = "5DEDDAFA4455BCEAFA3D0FC9F50AF00A")
        public int getAttributeNameResource(int index) {
            int varF6A84D2EA99C427754EE4C64391AE074_100864342 = (nativeGetAttributeResource(mParseState, index));
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483031231 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483031231;
            // ---------- Original Method ----------
            //return nativeGetAttributeResource(mParseState, index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.518 -0400", hash_original_method = "1215FB5AAEE746C41F9FA8271AAF1E60", hash_generated_method = "7D720177A621A45B3BD932A624B08E70")
        public int getAttributeListValue(String namespace, String attribute,
                String[] options, int defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var9746577ED7FA626EB250C6FA1993E568_221044239 = (getAttributeListValue(idx, options, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(options[0].getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011042574 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011042574;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeListValue(idx, options, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.518 -0400", hash_original_method = "B01E2E5CC96F6EF51E59D8D07AB9873A", hash_generated_method = "68E6DA7B7118879AAD42FF3852749633")
        public boolean getAttributeBooleanValue(String namespace, String attribute,
                boolean defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                boolean var112C81F0CF2922B630967C489E44FCE2_1504780835 = (getAttributeBooleanValue(idx, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_661120014 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_661120014;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeBooleanValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.519 -0400", hash_original_method = "CB3F64435C40C20F84A081F8E49D1C0C", hash_generated_method = "65C2E8A3458FB3D6E4950F89B37E84F9")
        public int getAttributeResourceValue(String namespace, String attribute,
                int defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var4041CE7258634F39669102768A31E2B5_1667335312 = (getAttributeResourceValue(idx, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232866375 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232866375;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeResourceValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.528 -0400", hash_original_method = "8EF5A68420C37BD2779707A79B9C3811", hash_generated_method = "C9A1C3B8FE2840220ED18367043F0BB4")
        public int getAttributeIntValue(String namespace, String attribute,
                int defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var98A36DA81833C24E66998F976469DC76_334817142 = (getAttributeIntValue(idx, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715780909 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715780909;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeIntValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.530 -0400", hash_original_method = "133F9E0C363583A7982FF4EDA455C0C4", hash_generated_method = "DC06FE06D91F08EE86A5DF6B19F4595E")
        public int getAttributeUnsignedIntValue(String namespace, String attribute,
                                                int defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var6B4AE1ACD2501944E06884239ECFC491_644942741 = (getAttributeUnsignedIntValue(idx, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584226216 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584226216;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeUnsignedIntValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.555 -0400", hash_original_method = "91D09444FE7CF8F77D4AFF725E1E8970", hash_generated_method = "A0AD64F08DB31042AC94CD942F9ECAFA")
        public float getAttributeFloatValue(String namespace, String attribute,
                float defaultValue) {
            int idx;
            idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                float var8ADD88168EAB5E1C9157AC1388ED29E4_1930191226 = (getAttributeFloatValue(idx, defaultValue));
            } //End block
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            float var546ADE640B6EDFBC8A086EF31347E768_883167654 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_883167654;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeFloatValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.562 -0400", hash_original_method = "2BA8E9098E1E3526495883648F7DEF5F", hash_generated_method = "0949A58FACF3E3FE4317F64D2DF22092")
        public int getAttributeListValue(int idx,
                String[] options, int defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            int v;
            v = nativeGetAttributeData(mParseState, idx);
            {
                int var87C4679D2BF706005778803B1AE8C887_347586725 = (XmlUtils.convertValueToList(
                    mStrings.get(v), options, defaultValue));
            } //End block
            addTaint(idx);
            addTaint(options[0].getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2128801191 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2128801191;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //int v = nativeGetAttributeData(mParseState, idx);
            //if (t == TypedValue.TYPE_STRING) {
                //return XmlUtils.convertValueToList(
                    //mStrings.get(v), options, defaultValue);
            //}
            //return v;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.566 -0400", hash_original_method = "9FDDF9436ABA275F049CE63B7297D004", hash_generated_method = "E44E9D0DF8BB0174BBB70E27CBA7A45F")
        public boolean getAttributeBooleanValue(int idx,
                boolean defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                boolean var612CB30EBEACD27A167E09918F9B42F1_1812893104 = (nativeGetAttributeData(mParseState, idx) != 0);
            } //End block
            addTaint(idx);
            addTaint(defaultValue);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022066911 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022066911;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx) != 0;
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.567 -0400", hash_original_method = "0D4A13949891098942D2BD0FE4681BA9", hash_generated_method = "757804817E498267405BF2302727B399")
        public int getAttributeResourceValue(int idx, int defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_4874869 = (nativeGetAttributeData(mParseState, idx));
            } //End block
            addTaint(idx);
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_195573413 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_195573413;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t == TypedValue.TYPE_REFERENCE) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.580 -0400", hash_original_method = "76347FF1C756B55868935018572B3748", hash_generated_method = "784B4784DAA30C5B2F93CA9A613403FA")
        public int getAttributeIntValue(int idx, int defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_1084876173 = (nativeGetAttributeData(mParseState, idx));
            } //End block
            addTaint(idx);
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689954914 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689954914;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.581 -0400", hash_original_method = "10FB8704E5561F244AB5AE7B4EFD0C1E", hash_generated_method = "99CB51222C4E770B2D1F66F0C00076E5")
        public int getAttributeUnsignedIntValue(int idx, int defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_1166532121 = (nativeGetAttributeData(mParseState, idx));
            } //End block
            addTaint(idx);
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442539878 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442539878;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.593 -0400", hash_original_method = "BBF18D629EB0696226FD45DB0C0888CC", hash_generated_method = "4D56E613E20EC8547808CE2EF291ADC8")
        public float getAttributeFloatValue(int idx, float defaultValue) {
            int t;
            t = nativeGetAttributeDataType(mParseState, idx);
            {
                float var7FE27D38E8241DD13E64DA80050555B4_610800461 = (Float.intBitsToFloat(
                    nativeGetAttributeData(mParseState, idx)));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("not a float!");
            addTaint(idx);
            addTaint(defaultValue);
            float var546ADE640B6EDFBC8A086EF31347E768_317469363 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_317469363;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t == TypedValue.TYPE_FLOAT) {
                //return Float.intBitsToFloat(
                    //nativeGetAttributeData(mParseState, idx));
            //}
            //throw new RuntimeException("not a float!");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.607 -0400", hash_original_method = "459DE28869C0476D8004C0FC89A0FAA3", hash_generated_method = "1D9212F7A7247F17E12EF497E6F65DA4")
        public String getIdAttribute() {
            String varB4EAC82CA7396A68D541C85D26508E83_9852110 = null; //Variable for return #1
            int id;
            id = nativeGetIdAttribute(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_9852110 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_9852110.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_9852110;
            // ---------- Original Method ----------
            //int id = nativeGetIdAttribute(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.618 -0400", hash_original_method = "6EA4969C84EC91743C886113DBDA4AC3", hash_generated_method = "F6A7920DAAD7E638C892FA16E45A3AD3")
        public String getClassAttribute() {
            String varB4EAC82CA7396A68D541C85D26508E83_1662014508 = null; //Variable for return #1
            int id;
            id = nativeGetClassAttribute(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_1662014508 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1662014508.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1662014508;
            // ---------- Original Method ----------
            //int id = nativeGetClassAttribute(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.618 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "40B046D7249A1C71D14DC5E69E66D150")
        public int getIdAttributeResourceValue(int defaultValue) {
            int var3134D2BCB0EA7E34279C8DC792789F56_1006852575 = (getAttributeResourceValue(null, "id", defaultValue));
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163048837 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163048837;
            // ---------- Original Method ----------
            //return getAttributeResourceValue(null, "id", defaultValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.620 -0400", hash_original_method = "34AB6D031D153719912E2897914AFEED", hash_generated_method = "EC226225B1AB6CA2369D0C20F78D5CDC")
        public int getStyleAttribute() {
            int var24F64E8584039948E1AFFBFA2A70D193_1898333036 = (nativeGetStyleAttribute(mParseState));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124950360 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124950360;
            // ---------- Original Method ----------
            //return nativeGetStyleAttribute(mParseState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.626 -0400", hash_original_method = "283F7DAAD4F2484127D9024B5883A661", hash_generated_method = "0495834BCB8967EEAAC0C90DB330C999")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.627 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        protected void finalize() throws Throwable {
            close();
            // ---------- Original Method ----------
            //close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.656 -0400", hash_original_method = "E55719651A1187D6CF490013E1512769", hash_generated_method = "F73CC37A65CA77CC58998A42857A02E4")
        final CharSequence getPooledString(int id) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1742009944 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1742009944 = mStrings.get(id);
            addTaint(id);
            varB4EAC82CA7396A68D541C85D26508E83_1742009944.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1742009944;
            // ---------- Original Method ----------
            //return mStrings.get(id);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.661 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
}

