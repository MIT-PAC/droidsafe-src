package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

final class XmlBlock {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.778 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "49B4A4B4F77DF85AA82FF83B2F894508")

    private AssetManager mAssets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.779 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.779 -0400", hash_original_field = "DCFA8FC1CFB8B5A5290D25EC1EA3C56B", hash_generated_field = "E687239F3E1A0E0370D394F826B65E89")

    StringBlock mStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.779 -0400", hash_original_field = "FA3F9A9DA0C13C19A5EFA6211E2FE7F3", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.779 -0400", hash_original_field = "1DD071DB88934A0BCF394BA8B6213C8D", hash_generated_field = "D98A2F1C489BE52721534D4A450F131E")

    private int mOpenCount = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.780 -0400", hash_original_method = "A22EEB27BFE227BD171CA1655E28A01F", hash_generated_method = "4AE7DDE59497735C74D31FB0EB379F5F")
    public  XmlBlock(byte[] data) {
        mAssets = null;
        mNative = nativeCreate(data, 0, data.length);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        // ---------- Original Method ----------
        //mAssets = null;
        //mNative = nativeCreate(data, 0, data.length);
        //mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.780 -0400", hash_original_method = "B1D68A7ECB78CEADC57D198A6FDBCA28", hash_generated_method = "AB11E1FEA4E4C63AD257E940DE94AF11")
    public  XmlBlock(byte[] data, int offset, int size) {
        mAssets = null;
        mNative = nativeCreate(data, offset, size);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        // ---------- Original Method ----------
        //mAssets = null;
        //mNative = nativeCreate(data, offset, size);
        //mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.781 -0400", hash_original_method = "2D0B3C5ECC15AA5F78B0AD70805A049B", hash_generated_method = "2E005A9D8EA3DF78882014B9F5C7AE35")
      XmlBlock(AssetManager assets, int xmlBlock) {
        mAssets = assets;
        mNative = xmlBlock;
        mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
        // ---------- Original Method ----------
        //mAssets = assets;
        //mNative = xmlBlock;
        //mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.781 -0400", hash_original_method = "92B3E7DBAA5D8D51C162522636FE2570", hash_generated_method = "EBE550FE58E4C1BD64043333E00F8921")
    public void close() {
        synchronized
(this)        {
    if(mOpen)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.782 -0400", hash_original_method = "017FB1456432C4B45E3EDBB9E5F1A65C", hash_generated_method = "84D1C4F049C7E2AADFC14B118EC48977")
    private void decOpenCountLocked() {
        mOpenCount--;
    if(mOpenCount == 0)        
        {
            nativeDestroy(mNative);
    if(mAssets != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.782 -0400", hash_original_method = "36FE28CA3339B97C4303841D21F6E4EF", hash_generated_method = "59946A9767DEA22E6662E750ADAA0CFB")
    public XmlResourceParser newParser() {
        synchronized
(this)        {
    if(mNative != 0)            
            {
XmlResourceParser var4172B33804D80B8E22876EF5A96DF9D3_1651896970 =                 new Parser(nativeCreateParseState(mNative), this);
                var4172B33804D80B8E22876EF5A96DF9D3_1651896970.addTaint(taint);
                return var4172B33804D80B8E22876EF5A96DF9D3_1651896970;
            } //End block
XmlResourceParser var540C13E9E156B687226421B24F2DF178_94114213 =             null;
            var540C13E9E156B687226421B24F2DF178_94114213.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_94114213;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mNative != 0) {
                //return new Parser(nativeCreateParseState(mNative), this);
            //}
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.783 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.789 -0400", hash_original_field = "4BFB0B80D080363EFC5373B871FF0770", hash_generated_field = "6CCE16E02108F8B5004F82A927CFF083")

        int mParseState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.789 -0400", hash_original_field = "E5ADD54C021234204DB48E99A01961D7", hash_generated_field = "3EDA85A0804ED213AA0240D41752F909")

        private XmlBlock mBlock;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.789 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

        private boolean mStarted = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.790 -0400", hash_original_field = "0A0A65D3B2CBF183A116FD12849B0451", hash_generated_field = "202F76F59FBD4A34EFD44A9FC7F2ED5B")

        private boolean mDecNextDepth = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.790 -0400", hash_original_field = "8A9EE96E8F54650AD1636FC7C1C10A9A", hash_generated_field = "67A287B1854820A57845B046DB8B7A31")

        private int mDepth = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.790 -0400", hash_original_field = "35AE7FC4CD775545AD93999E73996B6A", hash_generated_field = "4840498E2AA207F0162BEB5586951A29")

        private int mEventType = START_DOCUMENT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.791 -0400", hash_original_method = "2D249E03AFD474FA9CDB4E7172E5ABB4", hash_generated_method = "679A1063787BB118E1C0F83210507A3D")
          Parser(int parseState, XmlBlock block) {
            mParseState = parseState;
            mBlock = block;
            block.mOpenCount++;
            // ---------- Original Method ----------
            //mParseState = parseState;
            //mBlock = block;
            //block.mOpenCount++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.791 -0400", hash_original_method = "C272D7923F75EBE1BE9678831233D06B", hash_generated_method = "AF6B27B492D9B565C12A213D2E10AC19")
        public void setFeature(String name, boolean state) throws XmlPullParserException {
            addTaint(state);
            addTaint(name.getTaint());
    if(FEATURE_PROCESS_NAMESPACES.equals(name) && state)            
            {
                return;
            } //End block
    if(FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name) && state)            
            {
                return;
            } //End block
            XmlPullParserException var36669038112E18ABF864A1F87B292726_859845248 = new XmlPullParserException("Unsupported feature: " + name);
            var36669038112E18ABF864A1F87B292726_859845248.addTaint(taint);
            throw var36669038112E18ABF864A1F87B292726_859845248;
            // ---------- Original Method ----------
            //if (FEATURE_PROCESS_NAMESPACES.equals(name) && state) {
                //return;
            //}
            //if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name) && state) {
                //return;
            //}
            //throw new XmlPullParserException("Unsupported feature: " + name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.792 -0400", hash_original_method = "AB43D5F41C6A1AAA22A1C5749D672E40", hash_generated_method = "A944E410D153799BDB6D088D166C8079")
        public boolean getFeature(String name) {
            addTaint(name.getTaint());
    if(FEATURE_PROCESS_NAMESPACES.equals(name))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_2128254122 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980417300 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980417300;
            } //End block
    if(FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1965216708 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70225994 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_70225994;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1186364879 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628489911 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628489911;
            // ---------- Original Method ----------
            //if (FEATURE_PROCESS_NAMESPACES.equals(name)) {
                //return true;
            //}
            //if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name)) {
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.793 -0400", hash_original_method = "B8013E7A09E481D305959C445CAA259A", hash_generated_method = "E856D39BD8B680CD1239943781678E6C")
        public void setProperty(String name, Object value) throws XmlPullParserException {
            addTaint(value.getTaint());
            addTaint(name.getTaint());
            XmlPullParserException varC2E75CC38D1CD2AAFFEF04666510802E_1973064791 = new XmlPullParserException("setProperty() not supported");
            varC2E75CC38D1CD2AAFFEF04666510802E_1973064791.addTaint(taint);
            throw varC2E75CC38D1CD2AAFFEF04666510802E_1973064791;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setProperty() not supported");
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.793 -0400", hash_original_method = "5175B2315D9AD451CFA017AE30114E6D", hash_generated_method = "7ED305E603A8DE0D439E4232E044C2B5")
        public Object getProperty(String name) {
            addTaint(name.getTaint());
Object var540C13E9E156B687226421B24F2DF178_1425880725 =             null;
            var540C13E9E156B687226421B24F2DF178_1425880725.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1425880725;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.793 -0400", hash_original_method = "C407C4DE5B4382B09BED3CBFBB5B2FE9", hash_generated_method = "2FB8331FE88655B58E99FC386D7AFD82")
        public void setInput(Reader in) throws XmlPullParserException {
            addTaint(in.getTaint());
            XmlPullParserException var13720D275E029A000AE4F226DC2DDED2_642176445 = new XmlPullParserException("setInput() not supported");
            var13720D275E029A000AE4F226DC2DDED2_642176445.addTaint(taint);
            throw var13720D275E029A000AE4F226DC2DDED2_642176445;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setInput() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.794 -0400", hash_original_method = "2056A33FA2E1F0F175E1EBF8A8F56238", hash_generated_method = "6E14B8AE5FF8B5A45B2A2EB67B1BB4E2")
        public void setInput(InputStream inputStream, String inputEncoding) throws XmlPullParserException {
            addTaint(inputEncoding.getTaint());
            addTaint(inputStream.getTaint());
            XmlPullParserException var13720D275E029A000AE4F226DC2DDED2_915566436 = new XmlPullParserException("setInput() not supported");
            var13720D275E029A000AE4F226DC2DDED2_915566436.addTaint(taint);
            throw var13720D275E029A000AE4F226DC2DDED2_915566436;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setInput() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.794 -0400", hash_original_method = "523C048AE61D8B3E324838EE2E3CB0C0", hash_generated_method = "94B3BF7798CC2263010FC593846ED5F8")
        public void defineEntityReplacementText(String entityName, String replacementText) throws XmlPullParserException {
            addTaint(replacementText.getTaint());
            addTaint(entityName.getTaint());
            XmlPullParserException var4D0F832342B70C9DBBBDEA990AA3619E_1634012305 = new XmlPullParserException("defineEntityReplacementText() not supported");
            var4D0F832342B70C9DBBBDEA990AA3619E_1634012305.addTaint(taint);
            throw var4D0F832342B70C9DBBBDEA990AA3619E_1634012305;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("defineEntityReplacementText() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.794 -0400", hash_original_method = "A5499422039640FD4F9D5601F1C55CCA", hash_generated_method = "7962802794F5A4D157F2B8810DE702E1")
        public String getNamespacePrefix(int pos) throws XmlPullParserException {
            addTaint(pos);
            XmlPullParserException varC9B4C07D42DC39CA7EFC095E58B0FF54_1339981397 = new XmlPullParserException("getNamespacePrefix() not supported");
            varC9B4C07D42DC39CA7EFC095E58B0FF54_1339981397.addTaint(taint);
            throw varC9B4C07D42DC39CA7EFC095E58B0FF54_1339981397;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespacePrefix() not supported");
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.795 -0400", hash_original_method = "5C999184AAA0F0E674F1363E90C0FD13", hash_generated_method = "062310341906C6EEF745C5D4E14E232E")
        public String getInputEncoding() {
String var540C13E9E156B687226421B24F2DF178_707728699 =             null;
            var540C13E9E156B687226421B24F2DF178_707728699.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_707728699;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.795 -0400", hash_original_method = "AE6D93E7ABBCC0A1FA148BC6AE95DD76", hash_generated_method = "3F4D86E1AAC473ABBE2F412D354CA370")
        public String getNamespace(String prefix) {
            addTaint(prefix.getTaint());
            RuntimeException varA8F476CB2C567179C00D18D91F8C0404_77964208 = new RuntimeException("getNamespace() not supported");
            varA8F476CB2C567179C00D18D91F8C0404_77964208.addTaint(taint);
            throw varA8F476CB2C567179C00D18D91F8C0404_77964208;
            // ---------- Original Method ----------
            //throw new RuntimeException("getNamespace() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.795 -0400", hash_original_method = "A423E278D1BE175DD386F3DED425ED1E", hash_generated_method = "DF0F79650C16164BF0F9D9595A20C18D")
        public int getNamespaceCount(int depth) throws XmlPullParserException {
            addTaint(depth);
            XmlPullParserException var773A08DB55EF063FA9BBF9D70DCC6FAB_380298443 = new XmlPullParserException("getNamespaceCount() not supported");
            var773A08DB55EF063FA9BBF9D70DCC6FAB_380298443.addTaint(taint);
            throw var773A08DB55EF063FA9BBF9D70DCC6FAB_380298443;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespaceCount() not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.796 -0400", hash_original_method = "D2403D5573FCC08ECC8A73989B7EFE93", hash_generated_method = "C70BE708BF1E4C1FE86C6E9F4C708B49")
        public String getPositionDescription() {
String varA8A936FAF2F1582A5549DC73887E1742_329086352 =             "Binary XML file line #" + getLineNumber();
            varA8A936FAF2F1582A5549DC73887E1742_329086352.addTaint(taint);
            return varA8A936FAF2F1582A5549DC73887E1742_329086352;
            // ---------- Original Method ----------
            //return "Binary XML file line #" + getLineNumber();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.796 -0400", hash_original_method = "0BA86538E6BFE859243D39CD091AF1CC", hash_generated_method = "F3D099E8CE445514313779C46E5773FE")
        public String getNamespaceUri(int pos) throws XmlPullParserException {
            addTaint(pos);
            XmlPullParserException varC91C9D26BE7AFD0B97CBA8DA33336DEF_678346707 = new XmlPullParserException("getNamespaceUri() not supported");
            varC91C9D26BE7AFD0B97CBA8DA33336DEF_678346707.addTaint(taint);
            throw varC91C9D26BE7AFD0B97CBA8DA33336DEF_678346707;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespaceUri() not supported");
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.796 -0400", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "C413C75C481BDA40778B29256371C743")
        public int getColumnNumber() {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1072265543 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940281635 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940281635;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.797 -0400", hash_original_method = "DE1021F4C2B2A1E4D5CF36677B434DEA", hash_generated_method = "A0A589A73024A1943130D50E9997B840")
        public int getDepth() {
            int var67EB95621332D6338FBDBCE544F839EC_828244204 = (mDepth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327859676 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327859676;
            // ---------- Original Method ----------
            //return mDepth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.797 -0400", hash_original_method = "9AA17B3C306C694E2A4C941D5BD64364", hash_generated_method = "6E79429E68095DF911503DE793EA685A")
        public String getText() {
            int id = nativeGetText(mParseState);
String varAB024744B99AEC970E7EFF5B57F7E3E8_1663231843 =             id >= 0 ? mStrings.get(id).toString() : null;
            varAB024744B99AEC970E7EFF5B57F7E3E8_1663231843.addTaint(taint);
            return varAB024744B99AEC970E7EFF5B57F7E3E8_1663231843;
            // ---------- Original Method ----------
            //int id = nativeGetText(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.797 -0400", hash_original_method = "D6658BAD08E09D6B5CC695C7702E23C1", hash_generated_method = "0CEAB487A0FFFD10EEFD0AE36D244471")
        public int getLineNumber() {
            int var9E3B6725FD649218AC1817BECBC5A43E_1579718207 = (nativeGetLineNumber(mParseState));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225437591 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225437591;
            // ---------- Original Method ----------
            //return nativeGetLineNumber(mParseState);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.797 -0400", hash_original_method = "8A2CD03AAFDD20222A8759980FBB28AE", hash_generated_method = "F9AF1E21FA4CF620E7D95D383F200AEA")
        public int getEventType() throws XmlPullParserException {
            int varC7C43C278E8643FF27A9474560193A6F_1665472864 = (mEventType);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943537661 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943537661;
            // ---------- Original Method ----------
            //return mEventType;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.798 -0400", hash_original_method = "926F3413D3806C4A183D059B4FD2543E", hash_generated_method = "3AA4599EFFC2C24F8CCC1BFE6DC44F2E")
        public boolean isWhitespace() throws XmlPullParserException {
            boolean var68934A3E9455FA72420237EB05902327_355378625 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177764118 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177764118;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.798 -0400", hash_original_method = "692B884A81B63C3B5FA2E5F7E1379D3F", hash_generated_method = "8849881D906FD136E09DE8215AA0C512")
        public String getPrefix() {
            RuntimeException var18578E829D598674630F7F501652FBAE_532305594 = new RuntimeException("getPrefix not supported");
            var18578E829D598674630F7F501652FBAE_532305594.addTaint(taint);
            throw var18578E829D598674630F7F501652FBAE_532305594;
            // ---------- Original Method ----------
            //throw new RuntimeException("getPrefix not supported");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.799 -0400", hash_original_method = "03AC06D9FB54ABC98AEB5C7372B8DFCE", hash_generated_method = "F79847E40771548FCC52011FCA6B89EE")
        public char[] getTextCharacters(int[] holderForStartAndLength) {
            addTaint(holderForStartAndLength[0]);
            String txt = getText();
            char[] chars = null;
    if(txt != null)            
            {
                holderForStartAndLength[0] = 0;
                holderForStartAndLength[1] = txt.length();
                chars = new char[txt.length()];
                txt.getChars(0, txt.length(), chars, 0);
            } //End block
            char[] varB69D9BC635CCD79AD2C64BC862ABE3B4_449975777 = (chars);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_685188745 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_685188745;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.799 -0400", hash_original_method = "53E841A7D41D7C8EC6230F47D159F5F8", hash_generated_method = "9DAAA0C97929DAFAB859B8C60973DC13")
        public String getNamespace() {
            int id = nativeGetNamespace(mParseState);
String var0DB8E8DA55A048D8C582FCA9C8A1CDAF_1367201635 =             id >= 0 ? mStrings.get(id).toString() : "";
            var0DB8E8DA55A048D8C582FCA9C8A1CDAF_1367201635.addTaint(taint);
            return var0DB8E8DA55A048D8C582FCA9C8A1CDAF_1367201635;
            // ---------- Original Method ----------
            //int id = nativeGetNamespace(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.799 -0400", hash_original_method = "5E952CADD7A547B8BBE8593EB2804E3F", hash_generated_method = "D03E92351108D03E2FFCDCB5A03F7A19")
        public String getName() {
            int id = nativeGetName(mParseState);
String varAB024744B99AEC970E7EFF5B57F7E3E8_482947212 =             id >= 0 ? mStrings.get(id).toString() : null;
            varAB024744B99AEC970E7EFF5B57F7E3E8_482947212.addTaint(taint);
            return varAB024744B99AEC970E7EFF5B57F7E3E8_482947212;
            // ---------- Original Method ----------
            //int id = nativeGetName(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.800 -0400", hash_original_method = "C5B0A5333E9C04C4ABC345C16B794494", hash_generated_method = "B89C77919C9C90C556C7CE81C2B08FD7")
        public String getAttributeNamespace(int index) {
            addTaint(index);
            int id = nativeGetAttributeNamespace(mParseState, index);
    if(DEBUG)            
            System.out.println("getAttributeNamespace of " + index + " = " + id);
    if(id >= 0)            
            {
String varC1C98DA6DE8FF3C09EA690EC1717A80F_1229851268 =             mStrings.get(id).toString();
            varC1C98DA6DE8FF3C09EA690EC1717A80F_1229851268.addTaint(taint);
            return varC1C98DA6DE8FF3C09EA690EC1717A80F_1229851268;
            }
            else
    if(id == -1)            
            {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1352545107 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1352545107.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1352545107;
            }
            IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_313342982 = new IndexOutOfBoundsException(String.valueOf(index));
            varDC2A30BE720FF28962244F217E60E3D1_313342982.addTaint(taint);
            throw varDC2A30BE720FF28962244F217E60E3D1_313342982;
            // ---------- Original Method ----------
            //int id = nativeGetAttributeNamespace(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeNamespace of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //else if (id == -1) return "";
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.800 -0400", hash_original_method = "84AEB345F706FFE756390519A4CE900D", hash_generated_method = "3EC32B74B0117526C9C30E0C2E8A1E34")
        public String getAttributeName(int index) {
            addTaint(index);
            int id = nativeGetAttributeName(mParseState, index);
    if(DEBUG)            
            System.out.println("getAttributeName of " + index + " = " + id);
    if(id >= 0)            
            {
String varC1C98DA6DE8FF3C09EA690EC1717A80F_990957361 =             mStrings.get(id).toString();
            varC1C98DA6DE8FF3C09EA690EC1717A80F_990957361.addTaint(taint);
            return varC1C98DA6DE8FF3C09EA690EC1717A80F_990957361;
            }
            IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_1579985227 = new IndexOutOfBoundsException(String.valueOf(index));
            varDC2A30BE720FF28962244F217E60E3D1_1579985227.addTaint(taint);
            throw varDC2A30BE720FF28962244F217E60E3D1_1579985227;
            // ---------- Original Method ----------
            //int id = nativeGetAttributeName(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeName of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.801 -0400", hash_original_method = "50B51A25D0464B8FD90EECF499D60B48", hash_generated_method = "C1FD7F052135E089CF957F0862441B96")
        public String getAttributePrefix(int index) {
            addTaint(index);
            RuntimeException var82F3D809FCDE04A7958FC0E209861B27_1107991239 = new RuntimeException("getAttributePrefix not supported");
            var82F3D809FCDE04A7958FC0E209861B27_1107991239.addTaint(taint);
            throw var82F3D809FCDE04A7958FC0E209861B27_1107991239;
            // ---------- Original Method ----------
            //throw new RuntimeException("getAttributePrefix not supported");
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.801 -0400", hash_original_method = "860332C2A14F44509730B84BDA1621A5", hash_generated_method = "C34A88BF0F247F284ADEC086D3818EEF")
        public boolean isEmptyElementTag() throws XmlPullParserException {
            boolean var68934A3E9455FA72420237EB05902327_603639987 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_150383932 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_150383932;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.801 -0400", hash_original_method = "AF6A401047A56BD2769A9CCD0765487F", hash_generated_method = "63D938E0FE18048A7B22D318C612C904")
        public int getAttributeCount() {
            int varA684D62E66CE7CA72731D6D7CD33556F_339774994 = (mEventType == START_TAG ? nativeGetAttributeCount(mParseState) : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243738201 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243738201;
            // ---------- Original Method ----------
            //return mEventType == START_TAG ? nativeGetAttributeCount(mParseState) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.801 -0400", hash_original_method = "F4E9CDB9F128BA6177C44CACB76DA2CC", hash_generated_method = "9012D57D5530FDB1D90F05C14DAD36C3")
        public String getAttributeValue(int index) {
            addTaint(index);
            int id = nativeGetAttributeStringValue(mParseState, index);
    if(DEBUG)            
            System.out.println("getAttributeValue of " + index + " = " + id);
    if(id >= 0)            
            {
String varC1C98DA6DE8FF3C09EA690EC1717A80F_770869817 =             mStrings.get(id).toString();
            varC1C98DA6DE8FF3C09EA690EC1717A80F_770869817.addTaint(taint);
            return varC1C98DA6DE8FF3C09EA690EC1717A80F_770869817;
            }
            int t = nativeGetAttributeDataType(mParseState, index);
    if(t == TypedValue.TYPE_NULL)            
            {
                IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_639928920 = new IndexOutOfBoundsException(String.valueOf(index));
                varDC2A30BE720FF28962244F217E60E3D1_639928920.addTaint(taint);
                throw varDC2A30BE720FF28962244F217E60E3D1_639928920;
            } //End block
            int v = nativeGetAttributeData(mParseState, index);
String var917B89ADD92DCC9B7E6E4C601918A285_1085843877 =             TypedValue.coerceToString(t, v);
            var917B89ADD92DCC9B7E6E4C601918A285_1085843877.addTaint(taint);
            return var917B89ADD92DCC9B7E6E4C601918A285_1085843877;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.802 -0400", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "349EEE950B96C4F5AB126BFCC5EBA876")
        public String getAttributeType(int index) {
            addTaint(index);
String var51FC5D2EB0F14BB856F2382E944EB3B9_1251438365 =             "CDATA";
            var51FC5D2EB0F14BB856F2382E944EB3B9_1251438365.addTaint(taint);
            return var51FC5D2EB0F14BB856F2382E944EB3B9_1251438365;
            // ---------- Original Method ----------
            //return "CDATA";
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.802 -0400", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "CBC84E360098D5DB44E079C7A0070738")
        public boolean isAttributeDefault(int index) {
            addTaint(index);
            boolean var68934A3E9455FA72420237EB05902327_823798436 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_180845698 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_180845698;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.802 -0400", hash_original_method = "F3E3F86FBCCE797A7D99504582A16A5E", hash_generated_method = "5FD0018B78FCB72D197B1E28AECD30C0")
        public int nextToken() throws XmlPullParserException,IOException {
            int var664F8784E379383402F73AEB98BCA97F_2028698593 = (next());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_533740905 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_533740905;
            // ---------- Original Method ----------
            //return next();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.803 -0400", hash_original_method = "8127D80C9F5EEB177072DC0AE91ACB4C", hash_generated_method = "B069D6994E75D4F91867F460F39784C1")
        public String getAttributeValue(String namespace, String name) {
            addTaint(name.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, name);
    if(idx >= 0)            
            {
    if(DEBUG)                
                System.out.println("getAttributeName of "
                        + namespace + ":" + name + " index = " + idx);
    if(DEBUG)                
                System.out.println(
                        "Namespace=" + getAttributeNamespace(idx)
                        + "Name=" + getAttributeName(idx)
                        + ", Value=" + getAttributeValue(idx));
String varF241B30B5190DB615ACC5E947F22D845_2065158399 =                 getAttributeValue(idx);
                varF241B30B5190DB615ACC5E947F22D845_2065158399.addTaint(taint);
                return varF241B30B5190DB615ACC5E947F22D845_2065158399;
            } //End block
String var540C13E9E156B687226421B24F2DF178_244000273 =             null;
            var540C13E9E156B687226421B24F2DF178_244000273.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_244000273;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.804 -0400", hash_original_method = "2DA88A175068BC957038D4798DAD0AF9", hash_generated_method = "BFC85B7BDBFE1FD6D38522E2381141E1")
        public int next() throws XmlPullParserException,IOException {
    if(!mStarted)            
            {
                mStarted = true;
                int var44789CC4B01E17A13BBF6EB1C0517A03_2099939087 = (START_DOCUMENT);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064344644 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064344644;
            } //End block
    if(mParseState == 0)            
            {
                int var4620EC92A1E599503D1824B7D72639A9_1986810387 = (END_DOCUMENT);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_556154849 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_556154849;
            } //End block
            int ev = nativeNext(mParseState);
    if(mDecNextDepth)            
            {
                mDepth--;
                mDecNextDepth = false;
            } //End block
switch(ev){
            case START_TAG:
            mDepth++;
            break;
            case END_TAG:
            mDecNextDepth = true;
            break;
}            mEventType = ev;
    if(ev == END_DOCUMENT)            
            {
                close();
            } //End block
            int var3CF804E7182AB12879C33C914E1C5CD8_1501373205 = (ev);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797380311 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797380311;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.805 -0400", hash_original_method = "A600298A9B2D06DCD3FD708D87D4E435", hash_generated_method = "87616932BFF93BC6D921113113E61C9A")
        public void require(int type, String namespace, String name) throws XmlPullParserException,IOException {
            addTaint(name.getTaint());
            addTaint(namespace.getTaint());
            addTaint(type);
    if(type != getEventType()
                || (namespace != null && !namespace.equals( getNamespace () ) )
                || (name != null && !name.equals( getName() ) ))            
            {
            XmlPullParserException varE41E622105B5125938ACBE30679C95EE_406571191 = new XmlPullParserException( "expected "+ TYPES[ type ]+getPositionDescription());
            varE41E622105B5125938ACBE30679C95EE_406571191.addTaint(taint);
            throw varE41E622105B5125938ACBE30679C95EE_406571191;
            }
            // ---------- Original Method ----------
            //if (type != getEventType()
                //|| (namespace != null && !namespace.equals( getNamespace () ) )
                //|| (name != null && !name.equals( getName() ) ) )
                //throw new XmlPullParserException( "expected "+ TYPES[ type ]+getPositionDescription());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.806 -0400", hash_original_method = "0387CD391BE287242825F05D1B5C07FC", hash_generated_method = "4CCA7EE93763B2C23A16BB49B23E2D01")
        public String nextText() throws XmlPullParserException,IOException {
    if(getEventType() != START_TAG)            
            {
                XmlPullParserException varDCE3D1008149699819D8D8094B11E189_434519212 = new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG to read next text", this, null);
                varDCE3D1008149699819D8D8094B11E189_434519212.addTaint(taint);
                throw varDCE3D1008149699819D8D8094B11E189_434519212;
            } //End block
            int eventType = next();
    if(eventType == TEXT)            
            {
                String result = getText();
                eventType = next();
    if(eventType != END_TAG)                
                {
                    XmlPullParserException varEDB6AE54CD1BA3452F32C8801D98FA0A_19531865 = new XmlPullParserException(
                    getPositionDescription()
                    + ": event TEXT it must be immediately followed by END_TAG", this, null);
                    varEDB6AE54CD1BA3452F32C8801D98FA0A_19531865.addTaint(taint);
                    throw varEDB6AE54CD1BA3452F32C8801D98FA0A_19531865;
                } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_1472770339 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1472770339.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1472770339;
            } //End block
            else
    if(eventType == END_TAG)            
            {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_851041475 =                 "";
                var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_851041475.addTaint(taint);
                return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_851041475;
            } //End block
            else
            {
                XmlPullParserException var7479EABD1BC4B9487BD1B52EC928FE5F_910854754 = new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG or TEXT to read text", this, null);
                var7479EABD1BC4B9487BD1B52EC928FE5F_910854754.addTaint(taint);
                throw var7479EABD1BC4B9487BD1B52EC928FE5F_910854754;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.807 -0400", hash_original_method = "86ECF63697C3285DB17A648F53C02562", hash_generated_method = "0737F5B7455489543078EA80698EF635")
        public int nextTag() throws XmlPullParserException,IOException {
            int eventType = next();
    if(eventType == TEXT && isWhitespace())            
            {
                eventType = next();
            } //End block
    if(eventType != START_TAG && eventType != END_TAG)            
            {
                XmlPullParserException var3AF76C9C5CAFF3B4AB5417C37949A0A1_999545894 = new XmlPullParserException(
                   getPositionDescription() 
                   + ": expected start or end tag", this, null);
                var3AF76C9C5CAFF3B4AB5417C37949A0A1_999545894.addTaint(taint);
                throw var3AF76C9C5CAFF3B4AB5417C37949A0A1_999545894;
            } //End block
            int var2F264034C73ACBD6BAAE70DD7EDB3D3F_8030748 = (eventType);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1384160112 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1384160112;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.807 -0400", hash_original_method = "F89E8721AF5486B49BDF02DB68EDEEE5", hash_generated_method = "517CB3F63648A083BBB8BB72ABA9DE23")
        public int getAttributeNameResource(int index) {
            addTaint(index);
            int var00177517A6CA03A83035BBE864478806_932124648 = (nativeGetAttributeResource(mParseState, index));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379480842 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379480842;
            // ---------- Original Method ----------
            //return nativeGetAttributeResource(mParseState, index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.808 -0400", hash_original_method = "1215FB5AAEE746C41F9FA8271AAF1E60", hash_generated_method = "FDC0ABB615482D2EC4EE71FA3637EB42")
        public int getAttributeListValue(String namespace, String attribute,
                String[] options, int defaultValue) {
            addTaint(defaultValue);
            addTaint(options[0].getTaint());
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
    if(idx >= 0)            
            {
                int var1E98E5DE7362378F2B645B289E69073D_1025300479 = (getAttributeListValue(idx, options, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702685107 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702685107;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1579274904 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456399503 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456399503;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeListValue(idx, options, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.809 -0400", hash_original_method = "B01E2E5CC96F6EF51E59D8D07AB9873A", hash_generated_method = "B843EA92FD85F1D253636AFE7E426987")
        public boolean getAttributeBooleanValue(String namespace, String attribute,
                boolean defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
    if(idx >= 0)            
            {
                boolean var4933B6B8D8D0E59B2FEA8D3F7FA5F6E4_754203887 = (getAttributeBooleanValue(idx, defaultValue));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1285659510 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1285659510;
            } //End block
            boolean var16830A58E1E33A4163524366BA7B701B_1528469712 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_73539030 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_73539030;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeBooleanValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.810 -0400", hash_original_method = "CB3F64435C40C20F84A081F8E49D1C0C", hash_generated_method = "9C9F982C346BC12CDA94E82BF9A8CE90")
        public int getAttributeResourceValue(String namespace, String attribute,
                int defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
    if(idx >= 0)            
            {
                int var8F636DCD663B68984BE0038795501BD7_527636961 = (getAttributeResourceValue(idx, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972175610 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972175610;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1658128708 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245304788 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245304788;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeResourceValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.811 -0400", hash_original_method = "8EF5A68420C37BD2779707A79B9C3811", hash_generated_method = "A0799436B77B8E57B8337B7052AADC2B")
        public int getAttributeIntValue(String namespace, String attribute,
                int defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
    if(idx >= 0)            
            {
                int varBFDC6DAECC7C726E0D57EA41CF84B40F_319476047 = (getAttributeIntValue(idx, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_758399031 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_758399031;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_614866776 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716910840 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716910840;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeIntValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.811 -0400", hash_original_method = "133F9E0C363583A7982FF4EDA455C0C4", hash_generated_method = "719CE1C860D12D83C52DB1669B12BA00")
        public int getAttributeUnsignedIntValue(String namespace, String attribute,
                                                int defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
    if(idx >= 0)            
            {
                int varBFF34230F58599DBD52BE2E80D08A039_465420295 = (getAttributeUnsignedIntValue(idx, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_246287050 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_246287050;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1800427785 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228234055 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228234055;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeUnsignedIntValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.812 -0400", hash_original_method = "91D09444FE7CF8F77D4AFF725E1E8970", hash_generated_method = "1051F1FA884265010E547E1777CD7C8D")
        public float getAttributeFloatValue(String namespace, String attribute,
                float defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
    if(idx >= 0)            
            {
                float var2B5CC95C575F8450CEF7CCAA3A7FE562_380533408 = (getAttributeFloatValue(idx, defaultValue));
                                float var546ADE640B6EDFBC8A086EF31347E768_60808037 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_60808037;
            } //End block
            float var16830A58E1E33A4163524366BA7B701B_269795923 = (defaultValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_1371762850 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1371762850;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeFloatValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.812 -0400", hash_original_method = "2BA8E9098E1E3526495883648F7DEF5F", hash_generated_method = "107B0D9B98490611AD24166DDE9C8DBF")
        public int getAttributeListValue(int idx,
                String[] options, int defaultValue) {
            addTaint(defaultValue);
            addTaint(options[0].getTaint());
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
            int v = nativeGetAttributeData(mParseState, idx);
    if(t == TypedValue.TYPE_STRING)            
            {
                int var2DF11F710A850108860E684E28E390C2_808474623 = (XmlUtils.convertValueToList(
                    mStrings.get(v), options, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_803705753 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_803705753;
            } //End block
            int var9E3669D19B675BD57058FD4664205D2A_1235901343 = (v);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_853917739 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_853917739;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //int v = nativeGetAttributeData(mParseState, idx);
            //if (t == TypedValue.TYPE_STRING) {
                //return XmlUtils.convertValueToList(
                    //mStrings.get(v), options, defaultValue);
            //}
            //return v;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.813 -0400", hash_original_method = "9FDDF9436ABA275F049CE63B7297D004", hash_generated_method = "4F38959993903D10203ABE811897A162")
        public boolean getAttributeBooleanValue(int idx,
                boolean defaultValue) {
            addTaint(defaultValue);
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
    if(t >= TypedValue.TYPE_FIRST_INT &&
                t <= TypedValue.TYPE_LAST_INT)            
            {
                boolean var05CF6AF39B3AB74A060D12E4CA8CA26C_1293672776 = (nativeGetAttributeData(mParseState, idx) != 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1575485997 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1575485997;
            } //End block
            boolean var16830A58E1E33A4163524366BA7B701B_1450406110 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306494177 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306494177;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx) != 0;
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.814 -0400", hash_original_method = "0D4A13949891098942D2BD0FE4681BA9", hash_generated_method = "9BD680DC9E75E78A7F66605130BC9BA9")
        public int getAttributeResourceValue(int idx, int defaultValue) {
            addTaint(defaultValue);
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
    if(t == TypedValue.TYPE_REFERENCE)            
            {
                int var4ABA23A3F2BE8432141FF4E1F023A687_1318265503 = (nativeGetAttributeData(mParseState, idx));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604245022 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604245022;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1977954634 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1972218064 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1972218064;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t == TypedValue.TYPE_REFERENCE) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.815 -0400", hash_original_method = "76347FF1C756B55868935018572B3748", hash_generated_method = "778779EF9C44DC3E9A28F4499EE73E72")
        public int getAttributeIntValue(int idx, int defaultValue) {
            addTaint(defaultValue);
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
    if(t >= TypedValue.TYPE_FIRST_INT &&
                t <= TypedValue.TYPE_LAST_INT)            
            {
                int var4ABA23A3F2BE8432141FF4E1F023A687_1108968797 = (nativeGetAttributeData(mParseState, idx));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026133899 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026133899;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1485078732 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617683628 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617683628;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.815 -0400", hash_original_method = "10FB8704E5561F244AB5AE7B4EFD0C1E", hash_generated_method = "121FA0A323BC6281EC764DB345F5D30F")
        public int getAttributeUnsignedIntValue(int idx, int defaultValue) {
            addTaint(defaultValue);
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
    if(t >= TypedValue.TYPE_FIRST_INT &&
                t <= TypedValue.TYPE_LAST_INT)            
            {
                int var4ABA23A3F2BE8432141FF4E1F023A687_1278358734 = (nativeGetAttributeData(mParseState, idx));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049963724 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049963724;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1268134814 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280614160 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280614160;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.816 -0400", hash_original_method = "BBF18D629EB0696226FD45DB0C0888CC", hash_generated_method = "8CC82FDA9B800F48C69E0FC7CA4CCE8B")
        public float getAttributeFloatValue(int idx, float defaultValue) {
            addTaint(defaultValue);
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
    if(t == TypedValue.TYPE_FLOAT)            
            {
                float var2B81D834EA6B38A9637600D2F631A0B5_1489283086 = (Float.intBitsToFloat(
                    nativeGetAttributeData(mParseState, idx)));
                                float var546ADE640B6EDFBC8A086EF31347E768_978563730 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_978563730;
            } //End block
            RuntimeException var82C8D0685FB3FB164499685B7906795E_286359450 = new RuntimeException("not a float!");
            var82C8D0685FB3FB164499685B7906795E_286359450.addTaint(taint);
            throw var82C8D0685FB3FB164499685B7906795E_286359450;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t == TypedValue.TYPE_FLOAT) {
                //return Float.intBitsToFloat(
                    //nativeGetAttributeData(mParseState, idx));
            //}
            //throw new RuntimeException("not a float!");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.817 -0400", hash_original_method = "459DE28869C0476D8004C0FC89A0FAA3", hash_generated_method = "04E59870D5F33E01CD3963E60C4F434F")
        public String getIdAttribute() {
            int id = nativeGetIdAttribute(mParseState);
String varAB024744B99AEC970E7EFF5B57F7E3E8_814080065 =             id >= 0 ? mStrings.get(id).toString() : null;
            varAB024744B99AEC970E7EFF5B57F7E3E8_814080065.addTaint(taint);
            return varAB024744B99AEC970E7EFF5B57F7E3E8_814080065;
            // ---------- Original Method ----------
            //int id = nativeGetIdAttribute(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.817 -0400", hash_original_method = "6EA4969C84EC91743C886113DBDA4AC3", hash_generated_method = "C9902BA2103CE523AC66B23D342A874F")
        public String getClassAttribute() {
            int id = nativeGetClassAttribute(mParseState);
String varAB024744B99AEC970E7EFF5B57F7E3E8_1666508881 =             id >= 0 ? mStrings.get(id).toString() : null;
            varAB024744B99AEC970E7EFF5B57F7E3E8_1666508881.addTaint(taint);
            return varAB024744B99AEC970E7EFF5B57F7E3E8_1666508881;
            // ---------- Original Method ----------
            //int id = nativeGetClassAttribute(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.817 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "5C58F842E259505B274DD6A5FB75392C")
        public int getIdAttributeResourceValue(int defaultValue) {
            addTaint(defaultValue);
            int varCD137CD47DD67CEDD2FB3C345949E98D_1065318745 = (getAttributeResourceValue(null, "id", defaultValue));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_933918880 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_933918880;
            // ---------- Original Method ----------
            //return getAttributeResourceValue(null, "id", defaultValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.818 -0400", hash_original_method = "34AB6D031D153719912E2897914AFEED", hash_generated_method = "EC09C510B2320664B6208009C1551868")
        public int getStyleAttribute() {
            int var672FF0DE58331DB878C91499A9F3541B_1193211088 = (nativeGetStyleAttribute(mParseState));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786698594 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786698594;
            // ---------- Original Method ----------
            //return nativeGetStyleAttribute(mParseState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.818 -0400", hash_original_method = "283F7DAAD4F2484127D9024B5883A661", hash_generated_method = "919549817098AD6C7430CF4A6B84686E")
        public void close() {
            synchronized
(mBlock)            {
    if(mParseState != 0)                
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.818 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        protected void finalize() throws Throwable {
            close();
            // ---------- Original Method ----------
            //close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.819 -0400", hash_original_method = "E55719651A1187D6CF490013E1512769", hash_generated_method = "F4B160E7EB2A1FA4E6E8A09169FA477E")
        final CharSequence getPooledString(int id) {
            addTaint(id);
CharSequence varE60373DEF60CD26E76B56CA0EAE527B4_302469867 =             mStrings.get(id);
            varE60373DEF60CD26E76B56CA0EAE527B4_302469867.addTaint(taint);
            return varE60373DEF60CD26E76B56CA0EAE527B4_302469867;
            // ---------- Original Method ----------
            //return mStrings.get(id);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.819 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

