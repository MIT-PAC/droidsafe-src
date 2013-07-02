package android.content.res;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

final class XmlBlock {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.437 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "49B4A4B4F77DF85AA82FF83B2F894508")

    private AssetManager mAssets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.437 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.438 -0400", hash_original_field = "DCFA8FC1CFB8B5A5290D25EC1EA3C56B", hash_generated_field = "E687239F3E1A0E0370D394F826B65E89")

    StringBlock mStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.438 -0400", hash_original_field = "FA3F9A9DA0C13C19A5EFA6211E2FE7F3", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.438 -0400", hash_original_field = "1DD071DB88934A0BCF394BA8B6213C8D", hash_generated_field = "D98A2F1C489BE52721534D4A450F131E")

    private int mOpenCount = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.438 -0400", hash_original_method = "A22EEB27BFE227BD171CA1655E28A01F", hash_generated_method = "4AE7DDE59497735C74D31FB0EB379F5F")
    public  XmlBlock(byte[] data) {
        mAssets = null;
        mNative = nativeCreate(data, 0, data.length);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.439 -0400", hash_original_method = "B1D68A7ECB78CEADC57D198A6FDBCA28", hash_generated_method = "AB11E1FEA4E4C63AD257E940DE94AF11")
    public  XmlBlock(byte[] data, int offset, int size) {
        mAssets = null;
        mNative = nativeCreate(data, offset, size);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.439 -0400", hash_original_method = "2D0B3C5ECC15AA5F78B0AD70805A049B", hash_generated_method = "2E005A9D8EA3DF78882014B9F5C7AE35")
      XmlBlock(AssetManager assets, int xmlBlock) {
        mAssets = assets;
        mNative = xmlBlock;
        mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.440 -0400", hash_original_method = "92B3E7DBAA5D8D51C162522636FE2570", hash_generated_method = "B4E7DA18AC06A705B61F6622C9433AEA")
    public void close() {
        {
            {
                mOpen = false;
                decOpenCountLocked();
            } 
        } 
        
        
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.440 -0400", hash_original_method = "017FB1456432C4B45E3EDBB9E5F1A65C", hash_generated_method = "755E68CBCCC578A6BE297FE901E3483E")
    private void decOpenCountLocked() {
        {
            nativeDestroy(mNative);
            {
                mAssets.xmlBlockGone(hashCode());
            } 
        } 
        
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.441 -0400", hash_original_method = "36FE28CA3339B97C4303841D21F6E4EF", hash_generated_method = "7BB08A612D8474490D29D9EDC3CC06CD")
    public XmlResourceParser newParser() {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_819679254 = null; 
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_60992945 = null; 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_819679254 = new Parser(nativeCreateParseState(mNative), this);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_60992945 = null;
        } 
        XmlResourceParser varA7E53CE21691AB073D9660D615818899_254971635; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_254971635 = varB4EAC82CA7396A68D541C85D26508E83_819679254;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_254971635 = varB4EAC82CA7396A68D541C85D26508E83_60992945;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_254971635.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_254971635;
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.442 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
    protected void finalize() throws Throwable {
        close();
        
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.445 -0400", hash_original_field = "4BFB0B80D080363EFC5373B871FF0770", hash_generated_field = "6CCE16E02108F8B5004F82A927CFF083")

        int mParseState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.446 -0400", hash_original_field = "E5ADD54C021234204DB48E99A01961D7", hash_generated_field = "3EDA85A0804ED213AA0240D41752F909")

        private XmlBlock mBlock;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.446 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

        private boolean mStarted = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.446 -0400", hash_original_field = "0A0A65D3B2CBF183A116FD12849B0451", hash_generated_field = "202F76F59FBD4A34EFD44A9FC7F2ED5B")

        private boolean mDecNextDepth = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.446 -0400", hash_original_field = "8A9EE96E8F54650AD1636FC7C1C10A9A", hash_generated_field = "67A287B1854820A57845B046DB8B7A31")

        private int mDepth = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.446 -0400", hash_original_field = "35AE7FC4CD775545AD93999E73996B6A", hash_generated_field = "4840498E2AA207F0162BEB5586951A29")

        private int mEventType = START_DOCUMENT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.446 -0400", hash_original_method = "2D249E03AFD474FA9CDB4E7172E5ABB4", hash_generated_method = "DC07F5E54AE7F03957056D7EBA481B90")
          Parser(int parseState, XmlBlock block) {
            mParseState = parseState;
            mBlock = block;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.447 -0400", hash_original_method = "C272D7923F75EBE1BE9678831233D06B", hash_generated_method = "E86B17188C3A981994F9517986A7DE56")
        public void setFeature(String name, boolean state) throws XmlPullParserException {
            {
                boolean varB94CA82C41719F3E969BD618F7E5D9E4_2007074305 = (FEATURE_PROCESS_NAMESPACES.equals(name) && state);
            } 
            {
                boolean var46B472FB98C8A84DE2826A8C4EA5EA01_865820245 = (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name) && state);
            } 
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Unsupported feature: " + name);
            addTaint(name.getTaint());
            addTaint(state);
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.447 -0400", hash_original_method = "AB43D5F41C6A1AAA22A1C5749D672E40", hash_generated_method = "E31FD590C035E7F5C610B99F3E1A5360")
        public boolean getFeature(String name) {
            {
                boolean var30BD9FC73D8A5FB7FF062BA1F723D3AA_1230396259 = (FEATURE_PROCESS_NAMESPACES.equals(name));
            } 
            {
                boolean var5829279DB6D53DE356D337B03CF1D24E_1890016443 = (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name));
            } 
            addTaint(name.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918554790 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918554790;
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.448 -0400", hash_original_method = "B8013E7A09E481D305959C445CAA259A", hash_generated_method = "F4CA7ACF3429D8D3EC0C51506AA96CE2")
        public void setProperty(String name, Object value) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setProperty() not supported");
            addTaint(name.getTaint());
            addTaint(value.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.448 -0400", hash_original_method = "5175B2315D9AD451CFA017AE30114E6D", hash_generated_method = "75C081255E916AE87F46DAC54BD73C8B")
        public Object getProperty(String name) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1053981698 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1053981698 = null;
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1053981698.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1053981698;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.449 -0400", hash_original_method = "C407C4DE5B4382B09BED3CBFBB5B2FE9", hash_generated_method = "99684ED610434DFB2715A98BDF0C9681")
        public void setInput(Reader in) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setInput() not supported");
            addTaint(in.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.449 -0400", hash_original_method = "2056A33FA2E1F0F175E1EBF8A8F56238", hash_generated_method = "7693B1D4D6943793D3FE1CF423081746")
        public void setInput(InputStream inputStream, String inputEncoding) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setInput() not supported");
            addTaint(inputStream.getTaint());
            addTaint(inputEncoding.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.449 -0400", hash_original_method = "523C048AE61D8B3E324838EE2E3CB0C0", hash_generated_method = "7510301D985B152E3D6018F1641592EF")
        public void defineEntityReplacementText(String entityName, String replacementText) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("defineEntityReplacementText() not supported");
            addTaint(entityName.getTaint());
            addTaint(replacementText.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.470 -0400", hash_original_method = "A5499422039640FD4F9D5601F1C55CCA", hash_generated_method = "5A1820670FF9E1B1F58A76AE3B92A12B")
        public String getNamespacePrefix(int pos) throws XmlPullParserException {
        	throw new XmlPullParserException("getNamespacePrefix() not supported");
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.451 -0400", hash_original_method = "5C999184AAA0F0E674F1363E90C0FD13", hash_generated_method = "EE0BE6C1B2AAA1C427F53F7BA87BA31E")
        public String getInputEncoding() {
            String varB4EAC82CA7396A68D541C85D26508E83_1176546983 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1176546983 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1176546983.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1176546983;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.477 -0400", hash_original_method = "AE6D93E7ABBCC0A1FA148BC6AE95DD76", hash_generated_method = "BBE1E7E60FD88248A0A020D7D18AA3A3")
        public String getNamespace(String prefix) {
        	throw new RuntimeException("getNamespace() not supported");
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.451 -0400", hash_original_method = "A423E278D1BE175DD386F3DED425ED1E", hash_generated_method = "F40E20F319AAAED6F116D71C040D8DBB")
        public int getNamespaceCount(int depth) throws XmlPullParserException {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("getNamespaceCount() not supported");
            addTaint(depth);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082469030 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082469030;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.453 -0400", hash_original_method = "D2403D5573FCC08ECC8A73989B7EFE93", hash_generated_method = "B8823855535B112C2656FCAB2753004E")
        public String getPositionDescription() {
            String varB4EAC82CA7396A68D541C85D26508E83_968215239 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_968215239 = "Binary XML file line #" + getLineNumber();
            varB4EAC82CA7396A68D541C85D26508E83_968215239.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_968215239;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.496 -0400", hash_original_method = "0BA86538E6BFE859243D39CD091AF1CC", hash_generated_method = "F214E776EEAB004F6028C7D166FAB46D")
        public String getNamespaceUri(int pos) throws XmlPullParserException {
        	throw new XmlPullParserException("getNamespaceUri() not supported");
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.454 -0400", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "778DCC4D227C60DEE60767A7A381CA8C")
        public int getColumnNumber() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814240229 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814240229;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.454 -0400", hash_original_method = "DE1021F4C2B2A1E4D5CF36677B434DEA", hash_generated_method = "F27DBF2AFDD08FF3F9592380A30650FD")
        public int getDepth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695827581 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695827581;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.455 -0400", hash_original_method = "9AA17B3C306C694E2A4C941D5BD64364", hash_generated_method = "BCA42763E5B0FF82535AC2A6B06FB109")
        public String getText() {
            String varB4EAC82CA7396A68D541C85D26508E83_1015183989 = null; 
            int id = nativeGetText(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_1015183989 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1015183989.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1015183989;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.456 -0400", hash_original_method = "D6658BAD08E09D6B5CC695C7702E23C1", hash_generated_method = "1FD5BBB90B378402BCAA0F1D9E6FF3BB")
        public int getLineNumber() {
            int varBAA831A065AF74337E20120097F7F4FD_670416976 = (nativeGetLineNumber(mParseState));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183539750 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183539750;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.456 -0400", hash_original_method = "8A2CD03AAFDD20222A8759980FBB28AE", hash_generated_method = "BF2D786D1B7E1C030B5E09959819AFBC")
        public int getEventType() throws XmlPullParserException {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_727696885 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_727696885;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.456 -0400", hash_original_method = "926F3413D3806C4A183D059B4FD2543E", hash_generated_method = "802DFD908B0AC646E3FDF381786A2749")
        public boolean isWhitespace() throws XmlPullParserException {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1170594871 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1170594871;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.525 -0400", hash_original_method = "692B884A81B63C3B5FA2E5F7E1379D3F", hash_generated_method = "C3F8B39F24F360249FCD5FC6C50AABB3")
        public String getPrefix() {
        	throw new RuntimeException("getPrefix not supported");
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.457 -0400", hash_original_method = "03AC06D9FB54ABC98AEB5C7372B8DFCE", hash_generated_method = "82E8ECED4BFA1E35C7251892D7F381B3")
        public char[] getTextCharacters(int[] holderForStartAndLength) {
            String txt = getText();
            char[] chars = null;
            {
                holderForStartAndLength[0] = 0;
                holderForStartAndLength[1] = txt.length();
                chars = new char[txt.length()];
                txt.getChars(0, txt.length(), chars, 0);
            } 
            addTaint(holderForStartAndLength[0]);
            char[] var50607924ABD4C17119BAF3A1CE41C0EC_1004960940 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_1004960940;
            
            
            
            
                
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.458 -0400", hash_original_method = "53E841A7D41D7C8EC6230F47D159F5F8", hash_generated_method = "BBF93232B5108BD1D4647527C7B885B2")
        public String getNamespace() {
            String varB4EAC82CA7396A68D541C85D26508E83_263407781 = null; 
            int id = nativeGetNamespace(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_263407781 = id >= 0 ? mStrings.get(id).toString() : "";
            varB4EAC82CA7396A68D541C85D26508E83_263407781.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_263407781;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.458 -0400", hash_original_method = "5E952CADD7A547B8BBE8593EB2804E3F", hash_generated_method = "AEB4544FF0C445113146EAA66F4E64BA")
        public String getName() {
            String varB4EAC82CA7396A68D541C85D26508E83_745966751 = null; 
            int id = nativeGetName(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_745966751 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_745966751.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_745966751;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.459 -0400", hash_original_method = "C5B0A5333E9C04C4ABC345C16B794494", hash_generated_method = "83CE7E5F5CD3DB0BF9F2BF88411625FE")
        public String getAttributeNamespace(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_1539924953 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1046796730 = null; 
            int id = nativeGetAttributeNamespace(mParseState, index);
            System.out.println("getAttributeNamespace of " + index + " = " + id);
            varB4EAC82CA7396A68D541C85D26508E83_1539924953 = mStrings.get(id).toString();
            varB4EAC82CA7396A68D541C85D26508E83_1046796730 = "";
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            addTaint(index);
            String varA7E53CE21691AB073D9660D615818899_607572311; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_607572311 = varB4EAC82CA7396A68D541C85D26508E83_1539924953;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_607572311 = varB4EAC82CA7396A68D541C85D26508E83_1046796730;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_607572311.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_607572311;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.460 -0400", hash_original_method = "84AEB345F706FFE756390519A4CE900D", hash_generated_method = "121B61637D009D5956384D0D654C27A0")
        public String getAttributeName(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_329224164 = null; 
            int id = nativeGetAttributeName(mParseState, index);
            System.out.println("getAttributeName of " + index + " = " + id);
            varB4EAC82CA7396A68D541C85D26508E83_329224164 = mStrings.get(id).toString();
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_329224164.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_329224164;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.580 -0400", hash_original_method = "50B51A25D0464B8FD90EECF499D60B48", hash_generated_method = "8981166C7E6540038A16C40BE0EDD139")
        public String getAttributePrefix(int index) {
        	throw new RuntimeException("getAttributePrefix not supported");
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.461 -0400", hash_original_method = "860332C2A14F44509730B84BDA1621A5", hash_generated_method = "4EC9F8CF41A9361C8352E024842E1F80")
        public boolean isEmptyElementTag() throws XmlPullParserException {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394528661 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394528661;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.463 -0400", hash_original_method = "AF6A401047A56BD2769A9CCD0765487F", hash_generated_method = "87A558DC24A7321D87D96F184F34795B")
        public int getAttributeCount() {
            {
                Object var4E40D70343CD40DEDD7252A82F34EED9_325194152 = (nativeGetAttributeCount(mParseState));
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733718325 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733718325;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.465 -0400", hash_original_method = "F4E9CDB9F128BA6177C44CACB76DA2CC", hash_generated_method = "FCE805BF5042CCA72062082D4A9A029B")
        public String getAttributeValue(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_262455222 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1811285572 = null; 
            int id = nativeGetAttributeStringValue(mParseState, index);
            System.out.println("getAttributeValue of " + index + " = " + id);
            varB4EAC82CA7396A68D541C85D26508E83_262455222 = mStrings.get(id).toString();
            int t = nativeGetAttributeDataType(mParseState, index);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            } 
            int v = nativeGetAttributeData(mParseState, index);
            varB4EAC82CA7396A68D541C85D26508E83_1811285572 = TypedValue.coerceToString(t, v);
            addTaint(index);
            String varA7E53CE21691AB073D9660D615818899_756887891; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_756887891 = varB4EAC82CA7396A68D541C85D26508E83_262455222;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_756887891 = varB4EAC82CA7396A68D541C85D26508E83_1811285572;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_756887891.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_756887891;
            
            
            
            
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.465 -0400", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "D490450CBA143620A30E4B0E7730E251")
        public String getAttributeType(int index) {
            String varB4EAC82CA7396A68D541C85D26508E83_1720223271 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1720223271 = "CDATA";
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1720223271.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1720223271;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.466 -0400", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "1B5BCF4A5ECB4A3B5EEF9B7F35266453")
        public boolean isAttributeDefault(int index) {
            addTaint(index);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1615422965 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1615422965;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.466 -0400", hash_original_method = "F3E3F86FBCCE797A7D99504582A16A5E", hash_generated_method = "9FFA7183761CD45E518C2AFA287286A3")
        public int nextToken() throws XmlPullParserException,IOException {
            int var83133C39DBD81A6FC01ACC28F158E440_2118237368 = (next());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522597296 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522597296;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.467 -0400", hash_original_method = "8127D80C9F5EEB177072DC0AE91ACB4C", hash_generated_method = "2CDA71662EEA83249577215957C3E3BE")
        public String getAttributeValue(String namespace, String name) {
            String varB4EAC82CA7396A68D541C85D26508E83_1455969418 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_759058680 = null; 
            int idx = nativeGetAttributeIndex(mParseState, namespace, name);
            {
                System.out.println("getAttributeName of "
                        + namespace + ":" + name + " index = " + idx);
                System.out.println(
                        "Namespace=" + getAttributeNamespace(idx)
                        + "Name=" + getAttributeName(idx)
                        + ", Value=" + getAttributeValue(idx));
                varB4EAC82CA7396A68D541C85D26508E83_1455969418 = getAttributeValue(idx);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_759058680 = null;
            addTaint(namespace.getTaint());
            addTaint(name.getTaint());
            String varA7E53CE21691AB073D9660D615818899_46204075; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_46204075 = varB4EAC82CA7396A68D541C85D26508E83_1455969418;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_46204075 = varB4EAC82CA7396A68D541C85D26508E83_759058680;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_46204075.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_46204075;
            
            
            
                
                        
                
                        
                        
                        
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.468 -0400", hash_original_method = "2DA88A175068BC957038D4798DAD0AF9", hash_generated_method = "C70240400A13CDCFE1D8E95E8A9BD163")
        public int next() throws XmlPullParserException,IOException {
            {
                mStarted = true;
            } 
            int ev = nativeNext(mParseState);
            {
                mDecNextDepth = false;
            } 
            
            mDecNextDepth = true;
            
            mEventType = ev;
            {
                close();
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121398372 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121398372;
            
            
                
                
            
            
                
            
            
            
                
                
            
            
            
                
                
            
                
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.469 -0400", hash_original_method = "A600298A9B2D06DCD3FD708D87D4E435", hash_generated_method = "9C6ED86A484AA3039619EEA0D05623EE")
        public void require(int type, String namespace, String name) throws XmlPullParserException,IOException {
            {
                boolean var97810C1B0E0CD8066713029C8CFC3E70_134300259 = (type != getEventType()
                || (namespace != null && !namespace.equals( getNamespace () ) )
                || (name != null && !name.equals( getName() ) ));
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException( "expected "+ TYPES[ type ]+getPositionDescription());
            } 
            addTaint(type);
            addTaint(namespace.getTaint());
            addTaint(name.getTaint());
            
            
                
                
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.470 -0400", hash_original_method = "0387CD391BE287242825F05D1B5C07FC", hash_generated_method = "79AD3C07696D92DB5AB526C68B840EA0")
        public String nextText() throws XmlPullParserException,IOException {
            String varB4EAC82CA7396A68D541C85D26508E83_103457986 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_311286152 = null; 
            {
                boolean var9596CF2618BFAD282E250C866F3DF3C9_1441154359 = (getEventType() != START_TAG);
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG to read next text", this, null);
                } 
            } 
            int eventType = next();
            {
                String result = getText();
                eventType = next();
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    getPositionDescription()
                    + ": event TEXT it must be immediately followed by END_TAG", this, null);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_103457986 = result;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_311286152 = "";
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG or TEXT to read text", this, null);
            } 
            String varA7E53CE21691AB073D9660D615818899_1155866719; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1155866719 = varB4EAC82CA7396A68D541C85D26508E83_103457986;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1155866719 = varB4EAC82CA7396A68D541C85D26508E83_311286152;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1155866719.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1155866719;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.470 -0400", hash_original_method = "86ECF63697C3285DB17A648F53C02562", hash_generated_method = "D0F0101682E8B2CCBF325AA07DCB3C6C")
        public int nextTag() throws XmlPullParserException,IOException {
            int eventType = next();
            {
                boolean varC64C896D81E5DDFF005758762D652945_1360009512 = (eventType == TEXT && isWhitespace());
                {
                    eventType = next();
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                   getPositionDescription() 
                   + ": expected start or end tag", this, null);
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053054807 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053054807;
            
            
            
               
            
            
               
                   
                   
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.471 -0400", hash_original_method = "F89E8721AF5486B49BDF02DB68EDEEE5", hash_generated_method = "07F6BA0BD1CC549B0DAA8610F44554B1")
        public int getAttributeNameResource(int index) {
            int varF6A84D2EA99C427754EE4C64391AE074_471397161 = (nativeGetAttributeResource(mParseState, index));
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849775470 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849775470;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.472 -0400", hash_original_method = "1215FB5AAEE746C41F9FA8271AAF1E60", hash_generated_method = "6A26E4AAFA16D8348972ED213B023DDA")
        public int getAttributeListValue(String namespace, String attribute,
                String[] options, int defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var9746577ED7FA626EB250C6FA1993E568_1096991940 = (getAttributeListValue(idx, options, defaultValue));
            } 
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(options[0].getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356611727 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356611727;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.473 -0400", hash_original_method = "B01E2E5CC96F6EF51E59D8D07AB9873A", hash_generated_method = "A4C7D8A226522247C5358E2051DB78DF")
        public boolean getAttributeBooleanValue(String namespace, String attribute,
                boolean defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                boolean var112C81F0CF2922B630967C489E44FCE2_538126647 = (getAttributeBooleanValue(idx, defaultValue));
            } 
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732295956 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732295956;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.474 -0400", hash_original_method = "CB3F64435C40C20F84A081F8E49D1C0C", hash_generated_method = "C92032D9E9EC809DA772CA7E583927A6")
        public int getAttributeResourceValue(String namespace, String attribute,
                int defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var4041CE7258634F39669102768A31E2B5_933804724 = (getAttributeResourceValue(idx, defaultValue));
            } 
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851222276 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851222276;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.474 -0400", hash_original_method = "8EF5A68420C37BD2779707A79B9C3811", hash_generated_method = "670D9A8F4B86D7D604BA563982493D34")
        public int getAttributeIntValue(String namespace, String attribute,
                int defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var98A36DA81833C24E66998F976469DC76_1779804257 = (getAttributeIntValue(idx, defaultValue));
            } 
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458467462 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458467462;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.475 -0400", hash_original_method = "133F9E0C363583A7982FF4EDA455C0C4", hash_generated_method = "6FEAECC88C4DDA5E5EC16DF632877074")
        public int getAttributeUnsignedIntValue(String namespace, String attribute,
                                                int defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                int var6B4AE1ACD2501944E06884239ECFC491_1297983257 = (getAttributeUnsignedIntValue(idx, defaultValue));
            } 
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731028356 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731028356;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.475 -0400", hash_original_method = "91D09444FE7CF8F77D4AFF725E1E8970", hash_generated_method = "B3143347452256C49CD26245974D8CB1")
        public float getAttributeFloatValue(String namespace, String attribute,
                float defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            {
                float var8ADD88168EAB5E1C9157AC1388ED29E4_1967638445 = (getAttributeFloatValue(idx, defaultValue));
            } 
            addTaint(namespace.getTaint());
            addTaint(attribute.getTaint());
            addTaint(defaultValue);
            float var546ADE640B6EDFBC8A086EF31347E768_363032674 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_363032674;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.476 -0400", hash_original_method = "2BA8E9098E1E3526495883648F7DEF5F", hash_generated_method = "29632A41D63A11E5E5558C92F9C27141")
        public int getAttributeListValue(int idx,
                String[] options, int defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            int v = nativeGetAttributeData(mParseState, idx);
            {
                int var87C4679D2BF706005778803B1AE8C887_893420180 = (XmlUtils.convertValueToList(
                    mStrings.get(v), options, defaultValue));
            } 
            addTaint(idx);
            addTaint(options[0].getTaint());
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737795078 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737795078;
            
            
            
            
                
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.476 -0400", hash_original_method = "9FDDF9436ABA275F049CE63B7297D004", hash_generated_method = "5E11C9E7F8AAD3A48A1E6FE0B0A202CA")
        public boolean getAttributeBooleanValue(int idx,
                boolean defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            {
                boolean var612CB30EBEACD27A167E09918F9B42F1_825826185 = (nativeGetAttributeData(mParseState, idx) != 0);
            } 
            addTaint(idx);
            addTaint(defaultValue);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365270115 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365270115;
            
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.477 -0400", hash_original_method = "0D4A13949891098942D2BD0FE4681BA9", hash_generated_method = "50208EC0C626A61941BC91B85ED95F3C")
        public int getAttributeResourceValue(int idx, int defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_276797172 = (nativeGetAttributeData(mParseState, idx));
            } 
            addTaint(idx);
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403707940 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403707940;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.477 -0400", hash_original_method = "76347FF1C756B55868935018572B3748", hash_generated_method = "4BC03176313AA9B22673FC6E29BF1BD0")
        public int getAttributeIntValue(int idx, int defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_2084924214 = (nativeGetAttributeData(mParseState, idx));
            } 
            addTaint(idx);
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819649650 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819649650;
            
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.478 -0400", hash_original_method = "10FB8704E5561F244AB5AE7B4EFD0C1E", hash_generated_method = "9FC65D87524676369BF8CF683598B0C6")
        public int getAttributeUnsignedIntValue(int idx, int defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            {
                int var533971BCF6E370893815C9B2626DAA5E_1444409474 = (nativeGetAttributeData(mParseState, idx));
            } 
            addTaint(idx);
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108373580 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108373580;
            
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.478 -0400", hash_original_method = "BBF18D629EB0696226FD45DB0C0888CC", hash_generated_method = "71A690BA597C7241DCB6A32862279027")
        public float getAttributeFloatValue(int idx, float defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            {
                float var7FE27D38E8241DD13E64DA80050555B4_550058026 = (Float.intBitsToFloat(
                    nativeGetAttributeData(mParseState, idx)));
            } 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("not a float!");
            addTaint(idx);
            addTaint(defaultValue);
            float var546ADE640B6EDFBC8A086EF31347E768_1345233739 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1345233739;
            
            
            
                
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.479 -0400", hash_original_method = "459DE28869C0476D8004C0FC89A0FAA3", hash_generated_method = "FAFADCFA0423AFE9B266D827CAEAB2CD")
        public String getIdAttribute() {
            String varB4EAC82CA7396A68D541C85D26508E83_1255105400 = null; 
            int id = nativeGetIdAttribute(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_1255105400 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_1255105400.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1255105400;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.479 -0400", hash_original_method = "6EA4969C84EC91743C886113DBDA4AC3", hash_generated_method = "781A09ACFC4C27E29D57A386CEE309E7")
        public String getClassAttribute() {
            String varB4EAC82CA7396A68D541C85D26508E83_817101850 = null; 
            int id = nativeGetClassAttribute(mParseState);
            varB4EAC82CA7396A68D541C85D26508E83_817101850 = id >= 0 ? mStrings.get(id).toString() : null;
            varB4EAC82CA7396A68D541C85D26508E83_817101850.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_817101850;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.480 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "C32E722D718CE03D50C9D66DCD1C6575")
        public int getIdAttributeResourceValue(int defaultValue) {
            int var3134D2BCB0EA7E34279C8DC792789F56_1819713688 = (getAttributeResourceValue(null, "id", defaultValue));
            addTaint(defaultValue);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1789579836 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1789579836;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.480 -0400", hash_original_method = "34AB6D031D153719912E2897914AFEED", hash_generated_method = "BF7E194456234C812D5DBF68148E134A")
        public int getStyleAttribute() {
            int var24F64E8584039948E1AFFBFA2A70D193_517120652 = (nativeGetStyleAttribute(mParseState));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954260741 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954260741;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.481 -0400", hash_original_method = "283F7DAAD4F2484127D9024B5883A661", hash_generated_method = "0495834BCB8967EEAAC0C90DB330C999")
        public void close() {
            {
                {
                    nativeDestroyParseState(mParseState);
                    mParseState = 0;
                    mBlock.decOpenCountLocked();
                } 
            } 
            
            
                
                    
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.481 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        protected void finalize() throws Throwable {
            close();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.483 -0400", hash_original_method = "E55719651A1187D6CF490013E1512769", hash_generated_method = "4826C3AB45356C0EB209A951AC0F7DBF")
        final CharSequence getPooledString(int id) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_934122485 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_934122485 = mStrings.get(id);
            addTaint(id);
            varB4EAC82CA7396A68D541C85D26508E83_934122485.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_934122485;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.484 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

