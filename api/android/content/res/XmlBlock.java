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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.270 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "49B4A4B4F77DF85AA82FF83B2F894508")

    private AssetManager mAssets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.271 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.271 -0400", hash_original_field = "DCFA8FC1CFB8B5A5290D25EC1EA3C56B", hash_generated_field = "E687239F3E1A0E0370D394F826B65E89")

    StringBlock mStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.271 -0400", hash_original_field = "FA3F9A9DA0C13C19A5EFA6211E2FE7F3", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.271 -0400", hash_original_field = "1DD071DB88934A0BCF394BA8B6213C8D", hash_generated_field = "D98A2F1C489BE52721534D4A450F131E")

    private int mOpenCount = 1;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.271 -0400", hash_original_method = "A22EEB27BFE227BD171CA1655E28A01F", hash_generated_method = "4AE7DDE59497735C74D31FB0EB379F5F")
    public  XmlBlock(byte[] data) {
        mAssets = null;
        mNative = nativeCreate(data, 0, data.length);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        // ---------- Original Method ----------
        //mAssets = null;
        //mNative = nativeCreate(data, 0, data.length);
        //mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.272 -0400", hash_original_method = "B1D68A7ECB78CEADC57D198A6FDBCA28", hash_generated_method = "AB11E1FEA4E4C63AD257E940DE94AF11")
    public  XmlBlock(byte[] data, int offset, int size) {
        mAssets = null;
        mNative = nativeCreate(data, offset, size);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
        // ---------- Original Method ----------
        //mAssets = null;
        //mNative = nativeCreate(data, offset, size);
        //mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.273 -0400", hash_original_method = "2D0B3C5ECC15AA5F78B0AD70805A049B", hash_generated_method = "2E005A9D8EA3DF78882014B9F5C7AE35")
      XmlBlock(AssetManager assets, int xmlBlock) {
        mAssets = assets;
        mNative = xmlBlock;
        mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
        // ---------- Original Method ----------
        //mAssets = assets;
        //mNative = xmlBlock;
        //mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.274 -0400", hash_original_method = "92B3E7DBAA5D8D51C162522636FE2570", hash_generated_method = "EBE550FE58E4C1BD64043333E00F8921")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.275 -0400", hash_original_method = "017FB1456432C4B45E3EDBB9E5F1A65C", hash_generated_method = "84D1C4F049C7E2AADFC14B118EC48977")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.276 -0400", hash_original_method = "36FE28CA3339B97C4303841D21F6E4EF", hash_generated_method = "636BDD3B49D0686581C4A39282EB6F44")
    public XmlResourceParser newParser() {
        synchronized
(this)        {
            if(mNative != 0)            
            {
XmlResourceParser var4172B33804D80B8E22876EF5A96DF9D3_1550520457 =                 new Parser(nativeCreateParseState(mNative), this);
                var4172B33804D80B8E22876EF5A96DF9D3_1550520457.addTaint(taint);
                return var4172B33804D80B8E22876EF5A96DF9D3_1550520457;
            } //End block
XmlResourceParser var540C13E9E156B687226421B24F2DF178_1175030277 =             null;
            var540C13E9E156B687226421B24F2DF178_1175030277.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1175030277;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mNative != 0) {
                //return new Parser(nativeCreateParseState(mNative), this);
            //}
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.277 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.287 -0400", hash_original_field = "4BFB0B80D080363EFC5373B871FF0770", hash_generated_field = "6CCE16E02108F8B5004F82A927CFF083")

        int mParseState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.287 -0400", hash_original_field = "E5ADD54C021234204DB48E99A01961D7", hash_generated_field = "3EDA85A0804ED213AA0240D41752F909")

        private XmlBlock mBlock;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.287 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

        private boolean mStarted = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.287 -0400", hash_original_field = "0A0A65D3B2CBF183A116FD12849B0451", hash_generated_field = "202F76F59FBD4A34EFD44A9FC7F2ED5B")

        private boolean mDecNextDepth = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.287 -0400", hash_original_field = "8A9EE96E8F54650AD1636FC7C1C10A9A", hash_generated_field = "67A287B1854820A57845B046DB8B7A31")

        private int mDepth = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.287 -0400", hash_original_field = "35AE7FC4CD775545AD93999E73996B6A", hash_generated_field = "4840498E2AA207F0162BEB5586951A29")

        private int mEventType = START_DOCUMENT;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.288 -0400", hash_original_method = "2D249E03AFD474FA9CDB4E7172E5ABB4", hash_generated_method = "679A1063787BB118E1C0F83210507A3D")
          Parser(int parseState, XmlBlock block) {
            mParseState = parseState;
            mBlock = block;
            block.mOpenCount++;
            // ---------- Original Method ----------
            //mParseState = parseState;
            //mBlock = block;
            //block.mOpenCount++;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.289 -0400", hash_original_method = "C272D7923F75EBE1BE9678831233D06B", hash_generated_method = "B60350E48D5803A22D12A268DC8B16F4")
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
            XmlPullParserException var36669038112E18ABF864A1F87B292726_308601673 = new XmlPullParserException("Unsupported feature: " + name);
            var36669038112E18ABF864A1F87B292726_308601673.addTaint(taint);
            throw var36669038112E18ABF864A1F87B292726_308601673;
            // ---------- Original Method ----------
            //if (FEATURE_PROCESS_NAMESPACES.equals(name) && state) {
                //return;
            //}
            //if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name) && state) {
                //return;
            //}
            //throw new XmlPullParserException("Unsupported feature: " + name);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.290 -0400", hash_original_method = "AB43D5F41C6A1AAA22A1C5749D672E40", hash_generated_method = "01CE5D6CD03FDE071632FE80E20BA112")
        public boolean getFeature(String name) {
            addTaint(name.getTaint());
            if(FEATURE_PROCESS_NAMESPACES.equals(name))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1310538661 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_401502837 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_401502837;
            } //End block
            if(FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_78257264 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_113487835 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_113487835;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_381683984 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1171889930 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1171889930;
            // ---------- Original Method ----------
            //if (FEATURE_PROCESS_NAMESPACES.equals(name)) {
                //return true;
            //}
            //if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name)) {
                //return true;
            //}
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.290 -0400", hash_original_method = "B8013E7A09E481D305959C445CAA259A", hash_generated_method = "34DB97DFA16F8F63C2825C72DDE4CAA5")
        public void setProperty(String name, Object value) throws XmlPullParserException {
            addTaint(value.getTaint());
            addTaint(name.getTaint());
            XmlPullParserException varC2E75CC38D1CD2AAFFEF04666510802E_19423557 = new XmlPullParserException("setProperty() not supported");
            varC2E75CC38D1CD2AAFFEF04666510802E_19423557.addTaint(taint);
            throw varC2E75CC38D1CD2AAFFEF04666510802E_19423557;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setProperty() not supported");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.290 -0400", hash_original_method = "5175B2315D9AD451CFA017AE30114E6D", hash_generated_method = "D64F525D1FA7340836CFE9E8AC166CA6")
        public Object getProperty(String name) {
            addTaint(name.getTaint());
Object var540C13E9E156B687226421B24F2DF178_99505555 =             null;
            var540C13E9E156B687226421B24F2DF178_99505555.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_99505555;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.291 -0400", hash_original_method = "C407C4DE5B4382B09BED3CBFBB5B2FE9", hash_generated_method = "E51D84B71D513FA7010D04246DF7517A")
        public void setInput(Reader in) throws XmlPullParserException {
            addTaint(in.getTaint());
            XmlPullParserException var13720D275E029A000AE4F226DC2DDED2_1745552968 = new XmlPullParserException("setInput() not supported");
            var13720D275E029A000AE4F226DC2DDED2_1745552968.addTaint(taint);
            throw var13720D275E029A000AE4F226DC2DDED2_1745552968;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setInput() not supported");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.291 -0400", hash_original_method = "2056A33FA2E1F0F175E1EBF8A8F56238", hash_generated_method = "AB6FC491C3B599759F079F554DE2F1EE")
        public void setInput(InputStream inputStream, String inputEncoding) throws XmlPullParserException {
            addTaint(inputEncoding.getTaint());
            addTaint(inputStream.getTaint());
            XmlPullParserException var13720D275E029A000AE4F226DC2DDED2_304074288 = new XmlPullParserException("setInput() not supported");
            var13720D275E029A000AE4F226DC2DDED2_304074288.addTaint(taint);
            throw var13720D275E029A000AE4F226DC2DDED2_304074288;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("setInput() not supported");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.292 -0400", hash_original_method = "523C048AE61D8B3E324838EE2E3CB0C0", hash_generated_method = "8D7842357202BDEC6F1B5FD5A1E00756")
        public void defineEntityReplacementText(String entityName, String replacementText) throws XmlPullParserException {
            addTaint(replacementText.getTaint());
            addTaint(entityName.getTaint());
            XmlPullParserException var4D0F832342B70C9DBBBDEA990AA3619E_2117243978 = new XmlPullParserException("defineEntityReplacementText() not supported");
            var4D0F832342B70C9DBBBDEA990AA3619E_2117243978.addTaint(taint);
            throw var4D0F832342B70C9DBBBDEA990AA3619E_2117243978;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("defineEntityReplacementText() not supported");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.292 -0400", hash_original_method = "A5499422039640FD4F9D5601F1C55CCA", hash_generated_method = "D262C262B42CCDDF418AB41099A3FAFD")
        public String getNamespacePrefix(int pos) throws XmlPullParserException {
            addTaint(pos);
            XmlPullParserException varC9B4C07D42DC39CA7EFC095E58B0FF54_589453751 = new XmlPullParserException("getNamespacePrefix() not supported");
            varC9B4C07D42DC39CA7EFC095E58B0FF54_589453751.addTaint(taint);
            throw varC9B4C07D42DC39CA7EFC095E58B0FF54_589453751;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespacePrefix() not supported");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.292 -0400", hash_original_method = "5C999184AAA0F0E674F1363E90C0FD13", hash_generated_method = "3E080F425D20F78CCD9FBCD6981A3F32")
        public String getInputEncoding() {
String var540C13E9E156B687226421B24F2DF178_338009275 =             null;
            var540C13E9E156B687226421B24F2DF178_338009275.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_338009275;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.293 -0400", hash_original_method = "AE6D93E7ABBCC0A1FA148BC6AE95DD76", hash_generated_method = "296DB28777E01E117D5D352C005AB674")
        public String getNamespace(String prefix) {
            addTaint(prefix.getTaint());
            RuntimeException varA8F476CB2C567179C00D18D91F8C0404_1671935073 = new RuntimeException("getNamespace() not supported");
            varA8F476CB2C567179C00D18D91F8C0404_1671935073.addTaint(taint);
            throw varA8F476CB2C567179C00D18D91F8C0404_1671935073;
            // ---------- Original Method ----------
            //throw new RuntimeException("getNamespace() not supported");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.293 -0400", hash_original_method = "A423E278D1BE175DD386F3DED425ED1E", hash_generated_method = "7739141F1FB3AA5F83B6B5B0B7F716AA")
        public int getNamespaceCount(int depth) throws XmlPullParserException {
            addTaint(depth);
            XmlPullParserException var773A08DB55EF063FA9BBF9D70DCC6FAB_503491528 = new XmlPullParserException("getNamespaceCount() not supported");
            var773A08DB55EF063FA9BBF9D70DCC6FAB_503491528.addTaint(taint);
            throw var773A08DB55EF063FA9BBF9D70DCC6FAB_503491528;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespaceCount() not supported");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.293 -0400", hash_original_method = "D2403D5573FCC08ECC8A73989B7EFE93", hash_generated_method = "DA85000A8EB6BFAEF4A6DCFE0E16BB6B")
        public String getPositionDescription() {
String varA8A936FAF2F1582A5549DC73887E1742_343817149 =             "Binary XML file line #" + getLineNumber();
            varA8A936FAF2F1582A5549DC73887E1742_343817149.addTaint(taint);
            return varA8A936FAF2F1582A5549DC73887E1742_343817149;
            // ---------- Original Method ----------
            //return "Binary XML file line #" + getLineNumber();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.294 -0400", hash_original_method = "0BA86538E6BFE859243D39CD091AF1CC", hash_generated_method = "9F3D241593480BBC957CA87F7660F46A")
        public String getNamespaceUri(int pos) throws XmlPullParserException {
            addTaint(pos);
            XmlPullParserException varC91C9D26BE7AFD0B97CBA8DA33336DEF_1840530673 = new XmlPullParserException("getNamespaceUri() not supported");
            varC91C9D26BE7AFD0B97CBA8DA33336DEF_1840530673.addTaint(taint);
            throw varC91C9D26BE7AFD0B97CBA8DA33336DEF_1840530673;
            // ---------- Original Method ----------
            //throw new XmlPullParserException("getNamespaceUri() not supported");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.294 -0400", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "B93ECE0EF7B4184E8C7D58269DBA934D")
        public int getColumnNumber() {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1772192950 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954858209 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954858209;
            // ---------- Original Method ----------
            //return -1;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.294 -0400", hash_original_method = "DE1021F4C2B2A1E4D5CF36677B434DEA", hash_generated_method = "8C075B480A33A0952F76CCD018D89ABE")
        public int getDepth() {
            int var67EB95621332D6338FBDBCE544F839EC_1426195450 = (mDepth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_601709341 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_601709341;
            // ---------- Original Method ----------
            //return mDepth;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.295 -0400", hash_original_method = "9AA17B3C306C694E2A4C941D5BD64364", hash_generated_method = "53EF4A16B605F014343378EC4FCD7F54")
        public String getText() {
            int id = nativeGetText(mParseState);
String varAB024744B99AEC970E7EFF5B57F7E3E8_1942560033 =             id >= 0 ? mStrings.get(id).toString() : null;
            varAB024744B99AEC970E7EFF5B57F7E3E8_1942560033.addTaint(taint);
            return varAB024744B99AEC970E7EFF5B57F7E3E8_1942560033;
            // ---------- Original Method ----------
            //int id = nativeGetText(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.295 -0400", hash_original_method = "D6658BAD08E09D6B5CC695C7702E23C1", hash_generated_method = "7280566E12B443BC4881008273EEF8DE")
        public int getLineNumber() {
            int var9E3B6725FD649218AC1817BECBC5A43E_692757206 = (nativeGetLineNumber(mParseState));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1736881999 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1736881999;
            // ---------- Original Method ----------
            //return nativeGetLineNumber(mParseState);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.296 -0400", hash_original_method = "8A2CD03AAFDD20222A8759980FBB28AE", hash_generated_method = "63FD1DCD6C38631B12DC33FA7A85996F")
        public int getEventType() throws XmlPullParserException {
            int varC7C43C278E8643FF27A9474560193A6F_1731386258 = (mEventType);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658360175 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658360175;
            // ---------- Original Method ----------
            //return mEventType;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.296 -0400", hash_original_method = "926F3413D3806C4A183D059B4FD2543E", hash_generated_method = "A57B2A34629832D5A83DBFC7507669BF")
        public boolean isWhitespace() throws XmlPullParserException {
            boolean var68934A3E9455FA72420237EB05902327_808761400 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_379907272 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_379907272;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.296 -0400", hash_original_method = "692B884A81B63C3B5FA2E5F7E1379D3F", hash_generated_method = "CD1B87E2EB9AABB5325B83CDF5CF8399")
        public String getPrefix() {
            RuntimeException var18578E829D598674630F7F501652FBAE_792796568 = new RuntimeException("getPrefix not supported");
            var18578E829D598674630F7F501652FBAE_792796568.addTaint(taint);
            throw var18578E829D598674630F7F501652FBAE_792796568;
            // ---------- Original Method ----------
            //throw new RuntimeException("getPrefix not supported");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.297 -0400", hash_original_method = "03AC06D9FB54ABC98AEB5C7372B8DFCE", hash_generated_method = "09C06260CA688352AD16E0540E2E44C1")
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
            char[] varB69D9BC635CCD79AD2C64BC862ABE3B4_2779751 = (chars);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_239463528 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_239463528;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.298 -0400", hash_original_method = "53E841A7D41D7C8EC6230F47D159F5F8", hash_generated_method = "C9445E81D39F64692D6B2E84B1A89226")
        public String getNamespace() {
            int id = nativeGetNamespace(mParseState);
String var0DB8E8DA55A048D8C582FCA9C8A1CDAF_1903184832 =             id >= 0 ? mStrings.get(id).toString() : "";
            var0DB8E8DA55A048D8C582FCA9C8A1CDAF_1903184832.addTaint(taint);
            return var0DB8E8DA55A048D8C582FCA9C8A1CDAF_1903184832;
            // ---------- Original Method ----------
            //int id = nativeGetNamespace(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : "";
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.298 -0400", hash_original_method = "5E952CADD7A547B8BBE8593EB2804E3F", hash_generated_method = "A287A027BD0F69B5CB5348691F28B828")
        public String getName() {
            int id = nativeGetName(mParseState);
String varAB024744B99AEC970E7EFF5B57F7E3E8_1328303245 =             id >= 0 ? mStrings.get(id).toString() : null;
            varAB024744B99AEC970E7EFF5B57F7E3E8_1328303245.addTaint(taint);
            return varAB024744B99AEC970E7EFF5B57F7E3E8_1328303245;
            // ---------- Original Method ----------
            //int id = nativeGetName(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.299 -0400", hash_original_method = "C5B0A5333E9C04C4ABC345C16B794494", hash_generated_method = "AC478CE14952EB8075CCD80797AB8B14")
        public String getAttributeNamespace(int index) {
            addTaint(index);
            int id = nativeGetAttributeNamespace(mParseState, index);
            if(DEBUG)            
            System.out.println("getAttributeNamespace of " + index + " = " + id);
            if(id >= 0)            
            {
String varC1C98DA6DE8FF3C09EA690EC1717A80F_1067864231 =             mStrings.get(id).toString();
            varC1C98DA6DE8FF3C09EA690EC1717A80F_1067864231.addTaint(taint);
            return varC1C98DA6DE8FF3C09EA690EC1717A80F_1067864231;
            }
            else
            if(id == -1)            
            {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_909229059 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_909229059.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_909229059;
            }
            IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_1388662858 = new IndexOutOfBoundsException(String.valueOf(index));
            varDC2A30BE720FF28962244F217E60E3D1_1388662858.addTaint(taint);
            throw varDC2A30BE720FF28962244F217E60E3D1_1388662858;
            // ---------- Original Method ----------
            //int id = nativeGetAttributeNamespace(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeNamespace of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //else if (id == -1) return "";
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.300 -0400", hash_original_method = "84AEB345F706FFE756390519A4CE900D", hash_generated_method = "A7CC5D318B14E45496D6EB708FAE3BB5")
        public String getAttributeName(int index) {
            addTaint(index);
            int id = nativeGetAttributeName(mParseState, index);
            if(DEBUG)            
            System.out.println("getAttributeName of " + index + " = " + id);
            if(id >= 0)            
            {
String varC1C98DA6DE8FF3C09EA690EC1717A80F_1373232981 =             mStrings.get(id).toString();
            varC1C98DA6DE8FF3C09EA690EC1717A80F_1373232981.addTaint(taint);
            return varC1C98DA6DE8FF3C09EA690EC1717A80F_1373232981;
            }
            IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_1757504768 = new IndexOutOfBoundsException(String.valueOf(index));
            varDC2A30BE720FF28962244F217E60E3D1_1757504768.addTaint(taint);
            throw varDC2A30BE720FF28962244F217E60E3D1_1757504768;
            // ---------- Original Method ----------
            //int id = nativeGetAttributeName(mParseState, index);
            //if (DEBUG) System.out.println("getAttributeName of " + index + " = " + id);
            //if (id >= 0) return mStrings.get(id).toString();
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.300 -0400", hash_original_method = "50B51A25D0464B8FD90EECF499D60B48", hash_generated_method = "EDF20C508E5D8150AB97F3EAFE40295F")
        public String getAttributePrefix(int index) {
            addTaint(index);
            RuntimeException var82F3D809FCDE04A7958FC0E209861B27_857119614 = new RuntimeException("getAttributePrefix not supported");
            var82F3D809FCDE04A7958FC0E209861B27_857119614.addTaint(taint);
            throw var82F3D809FCDE04A7958FC0E209861B27_857119614;
            // ---------- Original Method ----------
            //throw new RuntimeException("getAttributePrefix not supported");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.301 -0400", hash_original_method = "860332C2A14F44509730B84BDA1621A5", hash_generated_method = "B275EADD8DD16AB07B10CED26CD03ED4")
        public boolean isEmptyElementTag() throws XmlPullParserException {
            boolean var68934A3E9455FA72420237EB05902327_1443982175 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842755403 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842755403;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.301 -0400", hash_original_method = "AF6A401047A56BD2769A9CCD0765487F", hash_generated_method = "2F220516488419CD354C34093F9611A9")
        public int getAttributeCount() {
            int varA684D62E66CE7CA72731D6D7CD33556F_1149967238 = (mEventType == START_TAG ? nativeGetAttributeCount(mParseState) : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350742544 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350742544;
            // ---------- Original Method ----------
            //return mEventType == START_TAG ? nativeGetAttributeCount(mParseState) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.301 -0400", hash_original_method = "F4E9CDB9F128BA6177C44CACB76DA2CC", hash_generated_method = "13B86FA56A9FD208B0E8CCEC48BF56B5")
        public String getAttributeValue(int index) {
            addTaint(index);
            int id = nativeGetAttributeStringValue(mParseState, index);
            if(DEBUG)            
            System.out.println("getAttributeValue of " + index + " = " + id);
            if(id >= 0)            
            {
String varC1C98DA6DE8FF3C09EA690EC1717A80F_353630224 =             mStrings.get(id).toString();
            varC1C98DA6DE8FF3C09EA690EC1717A80F_353630224.addTaint(taint);
            return varC1C98DA6DE8FF3C09EA690EC1717A80F_353630224;
            }
            int t = nativeGetAttributeDataType(mParseState, index);
            if(t == TypedValue.TYPE_NULL)            
            {
                IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_698211309 = new IndexOutOfBoundsException(String.valueOf(index));
                varDC2A30BE720FF28962244F217E60E3D1_698211309.addTaint(taint);
                throw varDC2A30BE720FF28962244F217E60E3D1_698211309;
            } //End block
            int v = nativeGetAttributeData(mParseState, index);
String var917B89ADD92DCC9B7E6E4C601918A285_1112578590 =             TypedValue.coerceToString(t, v);
            var917B89ADD92DCC9B7E6E4C601918A285_1112578590.addTaint(taint);
            return var917B89ADD92DCC9B7E6E4C601918A285_1112578590;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.302 -0400", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "9375BCD4B6FB7932DF29AE33A2FBE286")
        public String getAttributeType(int index) {
            addTaint(index);
String var51FC5D2EB0F14BB856F2382E944EB3B9_175305746 =             "CDATA";
            var51FC5D2EB0F14BB856F2382E944EB3B9_175305746.addTaint(taint);
            return var51FC5D2EB0F14BB856F2382E944EB3B9_175305746;
            // ---------- Original Method ----------
            //return "CDATA";
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.302 -0400", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "F49C57CFF7DD8742E3658B6CFAA60E1F")
        public boolean isAttributeDefault(int index) {
            addTaint(index);
            boolean var68934A3E9455FA72420237EB05902327_1817473013 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_834075457 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_834075457;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.303 -0400", hash_original_method = "F3E3F86FBCCE797A7D99504582A16A5E", hash_generated_method = "7328298F784C19AD5463C9C1EE6B8D7A")
        public int nextToken() throws XmlPullParserException,IOException {
            int var664F8784E379383402F73AEB98BCA97F_73670756 = (next());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779302709 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779302709;
            // ---------- Original Method ----------
            //return next();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.304 -0400", hash_original_method = "8127D80C9F5EEB177072DC0AE91ACB4C", hash_generated_method = "D7F57E92D63A8E62E68B95620B850C1B")
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
String varF241B30B5190DB615ACC5E947F22D845_921214188 =                 getAttributeValue(idx);
                varF241B30B5190DB615ACC5E947F22D845_921214188.addTaint(taint);
                return varF241B30B5190DB615ACC5E947F22D845_921214188;
            } //End block
String var540C13E9E156B687226421B24F2DF178_2068503146 =             null;
            var540C13E9E156B687226421B24F2DF178_2068503146.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2068503146;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.306 -0400", hash_original_method = "2DA88A175068BC957038D4798DAD0AF9", hash_generated_method = "74542622754FF56E95CA30EB16344300")
        public int next() throws XmlPullParserException,IOException {
            if(!mStarted)            
            {
                mStarted = true;
                int var44789CC4B01E17A13BBF6EB1C0517A03_429351777 = (START_DOCUMENT);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683973687 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683973687;
            } //End block
            if(mParseState == 0)            
            {
                int var4620EC92A1E599503D1824B7D72639A9_1581527625 = (END_DOCUMENT);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1154911664 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1154911664;
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
            int var3CF804E7182AB12879C33C914E1C5CD8_162250157 = (ev);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477885380 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477885380;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.307 -0400", hash_original_method = "A600298A9B2D06DCD3FD708D87D4E435", hash_generated_method = "E1A000F5D8EC43918569BBF1F827F276")
        public void require(int type, String namespace, String name) throws XmlPullParserException,IOException {
            addTaint(name.getTaint());
            addTaint(namespace.getTaint());
            addTaint(type);
            if(type != getEventType()
                || (namespace != null && !namespace.equals( getNamespace () ) )
                || (name != null && !name.equals( getName() ) ))            
            {
            XmlPullParserException varE41E622105B5125938ACBE30679C95EE_113312644 = new XmlPullParserException( "expected "+ TYPES[ type ]+getPositionDescription());
            varE41E622105B5125938ACBE30679C95EE_113312644.addTaint(taint);
            throw varE41E622105B5125938ACBE30679C95EE_113312644;
            }
            // ---------- Original Method ----------
            //if (type != getEventType()
                //|| (namespace != null && !namespace.equals( getNamespace () ) )
                //|| (name != null && !name.equals( getName() ) ) )
                //throw new XmlPullParserException( "expected "+ TYPES[ type ]+getPositionDescription());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.308 -0400", hash_original_method = "0387CD391BE287242825F05D1B5C07FC", hash_generated_method = "8503BEE39902841A42C99D8A9A5E032C")
        public String nextText() throws XmlPullParserException,IOException {
            if(getEventType() != START_TAG)            
            {
                XmlPullParserException varDCE3D1008149699819D8D8094B11E189_1627348114 = new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG to read next text", this, null);
                varDCE3D1008149699819D8D8094B11E189_1627348114.addTaint(taint);
                throw varDCE3D1008149699819D8D8094B11E189_1627348114;
            } //End block
            int eventType = next();
            if(eventType == TEXT)            
            {
                String result = getText();
                eventType = next();
                if(eventType != END_TAG)                
                {
                    XmlPullParserException varEDB6AE54CD1BA3452F32C8801D98FA0A_1547690517 = new XmlPullParserException(
                    getPositionDescription()
                    + ": event TEXT it must be immediately followed by END_TAG", this, null);
                    varEDB6AE54CD1BA3452F32C8801D98FA0A_1547690517.addTaint(taint);
                    throw varEDB6AE54CD1BA3452F32C8801D98FA0A_1547690517;
                } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_1379966176 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1379966176.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1379966176;
            } //End block
            else
            if(eventType == END_TAG)            
            {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1352454190 =                 "";
                var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1352454190.addTaint(taint);
                return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1352454190;
            } //End block
            else
            {
                XmlPullParserException var7479EABD1BC4B9487BD1B52EC928FE5F_1950574753 = new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG or TEXT to read text", this, null);
                var7479EABD1BC4B9487BD1B52EC928FE5F_1950574753.addTaint(taint);
                throw var7479EABD1BC4B9487BD1B52EC928FE5F_1950574753;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.309 -0400", hash_original_method = "86ECF63697C3285DB17A648F53C02562", hash_generated_method = "BAA327299A29F8C6481891D829717B6A")
        public int nextTag() throws XmlPullParserException,IOException {
            int eventType = next();
            if(eventType == TEXT && isWhitespace())            
            {
                eventType = next();
            } //End block
            if(eventType != START_TAG && eventType != END_TAG)            
            {
                XmlPullParserException var3AF76C9C5CAFF3B4AB5417C37949A0A1_1168559099 = new XmlPullParserException(
                   getPositionDescription() 
                   + ": expected start or end tag", this, null);
                var3AF76C9C5CAFF3B4AB5417C37949A0A1_1168559099.addTaint(taint);
                throw var3AF76C9C5CAFF3B4AB5417C37949A0A1_1168559099;
            } //End block
            int var2F264034C73ACBD6BAAE70DD7EDB3D3F_1780723184 = (eventType);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034823336 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034823336;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.309 -0400", hash_original_method = "F89E8721AF5486B49BDF02DB68EDEEE5", hash_generated_method = "753F5551D38CD9F1AB2042115E4E69A1")
        public int getAttributeNameResource(int index) {
            addTaint(index);
            int var00177517A6CA03A83035BBE864478806_1887335296 = (nativeGetAttributeResource(mParseState, index));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031961420 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031961420;
            // ---------- Original Method ----------
            //return nativeGetAttributeResource(mParseState, index);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.309 -0400", hash_original_method = "1215FB5AAEE746C41F9FA8271AAF1E60", hash_generated_method = "A0E34D2906DDC5487227C3BE8E32E669")
        public int getAttributeListValue(String namespace, String attribute,
                String[] options, int defaultValue) {
            addTaint(defaultValue);
            addTaint(options[0].getTaint());
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if(idx >= 0)            
            {
                int var1E98E5DE7362378F2B645B289E69073D_1753739732 = (getAttributeListValue(idx, options, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866020647 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866020647;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1644443604 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525193485 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525193485;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeListValue(idx, options, defaultValue);
            //}
            //return defaultValue;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.310 -0400", hash_original_method = "B01E2E5CC96F6EF51E59D8D07AB9873A", hash_generated_method = "8E6CACC887C3C9DC41CE2DD818A0E344")
        public boolean getAttributeBooleanValue(String namespace, String attribute,
                boolean defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if(idx >= 0)            
            {
                boolean var4933B6B8D8D0E59B2FEA8D3F7FA5F6E4_520307620 = (getAttributeBooleanValue(idx, defaultValue));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_720108326 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_720108326;
            } //End block
            boolean var16830A58E1E33A4163524366BA7B701B_99344680 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_5882977 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_5882977;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeBooleanValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.311 -0400", hash_original_method = "CB3F64435C40C20F84A081F8E49D1C0C", hash_generated_method = "F30336E29C85789FA1A59FEF944D365F")
        public int getAttributeResourceValue(String namespace, String attribute,
                int defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if(idx >= 0)            
            {
                int var8F636DCD663B68984BE0038795501BD7_683828758 = (getAttributeResourceValue(idx, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998824971 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998824971;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_2063048055 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719125043 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719125043;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeResourceValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.311 -0400", hash_original_method = "8EF5A68420C37BD2779707A79B9C3811", hash_generated_method = "0D00479E2BAFE659B280B48AF0599D8F")
        public int getAttributeIntValue(String namespace, String attribute,
                int defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if(idx >= 0)            
            {
                int varBFDC6DAECC7C726E0D57EA41CF84B40F_234742187 = (getAttributeIntValue(idx, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338845448 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338845448;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_397259889 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121320044 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121320044;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeIntValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.312 -0400", hash_original_method = "133F9E0C363583A7982FF4EDA455C0C4", hash_generated_method = "5496CB767649F95181CE33EC253B3C55")
        public int getAttributeUnsignedIntValue(String namespace, String attribute,
                                                int defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if(idx >= 0)            
            {
                int varBFF34230F58599DBD52BE2E80D08A039_620430760 = (getAttributeUnsignedIntValue(idx, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2078428358 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2078428358;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1058486003 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448291779 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448291779;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeUnsignedIntValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.313 -0400", hash_original_method = "91D09444FE7CF8F77D4AFF725E1E8970", hash_generated_method = "2B624C2E8A2E30B3EBA6F55F0C0EE12B")
        public float getAttributeFloatValue(String namespace, String attribute,
                float defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute.getTaint());
            addTaint(namespace.getTaint());
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if(idx >= 0)            
            {
                float var2B5CC95C575F8450CEF7CCAA3A7FE562_1625315871 = (getAttributeFloatValue(idx, defaultValue));
                                float var546ADE640B6EDFBC8A086EF31347E768_798978539 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_798978539;
            } //End block
            float var16830A58E1E33A4163524366BA7B701B_952337667 = (defaultValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_1291873747 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1291873747;
            // ---------- Original Method ----------
            //int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            //if (idx >= 0) {
                //return getAttributeFloatValue(idx, defaultValue);
            //}
            //return defaultValue;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.314 -0400", hash_original_method = "2BA8E9098E1E3526495883648F7DEF5F", hash_generated_method = "03A7795E239C0BF9662DEF1417481FBA")
        public int getAttributeListValue(int idx,
                String[] options, int defaultValue) {
            addTaint(defaultValue);
            addTaint(options[0].getTaint());
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
            int v = nativeGetAttributeData(mParseState, idx);
            if(t == TypedValue.TYPE_STRING)            
            {
                int var2DF11F710A850108860E684E28E390C2_684933978 = (XmlUtils.convertValueToList(
                    mStrings.get(v), options, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717513195 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717513195;
            } //End block
            int var9E3669D19B675BD57058FD4664205D2A_764489638 = (v);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564363585 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564363585;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //int v = nativeGetAttributeData(mParseState, idx);
            //if (t == TypedValue.TYPE_STRING) {
                //return XmlUtils.convertValueToList(
                    //mStrings.get(v), options, defaultValue);
            //}
            //return v;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.315 -0400", hash_original_method = "9FDDF9436ABA275F049CE63B7297D004", hash_generated_method = "3B6645CA4EE4033EACD9E524F89A895C")
        public boolean getAttributeBooleanValue(int idx,
                boolean defaultValue) {
            addTaint(defaultValue);
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
            if(t >= TypedValue.TYPE_FIRST_INT &&
                t <= TypedValue.TYPE_LAST_INT)            
            {
                boolean var05CF6AF39B3AB74A060D12E4CA8CA26C_305929184 = (nativeGetAttributeData(mParseState, idx) != 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146940440 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146940440;
            } //End block
            boolean var16830A58E1E33A4163524366BA7B701B_1368942985 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_111058621 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_111058621;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx) != 0;
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.315 -0400", hash_original_method = "0D4A13949891098942D2BD0FE4681BA9", hash_generated_method = "EE08886C57B74500BCBED848C110E9EF")
        public int getAttributeResourceValue(int idx, int defaultValue) {
            addTaint(defaultValue);
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
            if(t == TypedValue.TYPE_REFERENCE)            
            {
                int var4ABA23A3F2BE8432141FF4E1F023A687_735540110 = (nativeGetAttributeData(mParseState, idx));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_704551512 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_704551512;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1334420578 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125043808 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125043808;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t == TypedValue.TYPE_REFERENCE) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.316 -0400", hash_original_method = "76347FF1C756B55868935018572B3748", hash_generated_method = "1D33E83135925F101007C6E6B5F87B46")
        public int getAttributeIntValue(int idx, int defaultValue) {
            addTaint(defaultValue);
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
            if(t >= TypedValue.TYPE_FIRST_INT &&
                t <= TypedValue.TYPE_LAST_INT)            
            {
                int var4ABA23A3F2BE8432141FF4E1F023A687_1348705588 = (nativeGetAttributeData(mParseState, idx));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_506792805 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_506792805;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1876207872 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756475391 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756475391;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.316 -0400", hash_original_method = "10FB8704E5561F244AB5AE7B4EFD0C1E", hash_generated_method = "60343E7A84ADA2FBA8299DB57C834CAA")
        public int getAttributeUnsignedIntValue(int idx, int defaultValue) {
            addTaint(defaultValue);
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
            if(t >= TypedValue.TYPE_FIRST_INT &&
                t <= TypedValue.TYPE_LAST_INT)            
            {
                int var4ABA23A3F2BE8432141FF4E1F023A687_704295528 = (nativeGetAttributeData(mParseState, idx));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629568677 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629568677;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_619493095 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_66914973 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_66914973;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t >= TypedValue.TYPE_FIRST_INT &&
                //t <= TypedValue.TYPE_LAST_INT) {
                //return nativeGetAttributeData(mParseState, idx);
            //}
            //return defaultValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.317 -0400", hash_original_method = "BBF18D629EB0696226FD45DB0C0888CC", hash_generated_method = "CF5AE25AC80E4ACDA08F915F4459483C")
        public float getAttributeFloatValue(int idx, float defaultValue) {
            addTaint(defaultValue);
            addTaint(idx);
            int t = nativeGetAttributeDataType(mParseState, idx);
            if(t == TypedValue.TYPE_FLOAT)            
            {
                float var2B81D834EA6B38A9637600D2F631A0B5_1179408568 = (Float.intBitsToFloat(
                    nativeGetAttributeData(mParseState, idx)));
                                float var546ADE640B6EDFBC8A086EF31347E768_1222289667 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1222289667;
            } //End block
            RuntimeException var82C8D0685FB3FB164499685B7906795E_1744660057 = new RuntimeException("not a float!");
            var82C8D0685FB3FB164499685B7906795E_1744660057.addTaint(taint);
            throw var82C8D0685FB3FB164499685B7906795E_1744660057;
            // ---------- Original Method ----------
            //int t = nativeGetAttributeDataType(mParseState, idx);
            //if (t == TypedValue.TYPE_FLOAT) {
                //return Float.intBitsToFloat(
                    //nativeGetAttributeData(mParseState, idx));
            //}
            //throw new RuntimeException("not a float!");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.317 -0400", hash_original_method = "459DE28869C0476D8004C0FC89A0FAA3", hash_generated_method = "B6C528AEA64D3A87D6959BA3FE6AA66B")
        public String getIdAttribute() {
            int id = nativeGetIdAttribute(mParseState);
String varAB024744B99AEC970E7EFF5B57F7E3E8_860112537 =             id >= 0 ? mStrings.get(id).toString() : null;
            varAB024744B99AEC970E7EFF5B57F7E3E8_860112537.addTaint(taint);
            return varAB024744B99AEC970E7EFF5B57F7E3E8_860112537;
            // ---------- Original Method ----------
            //int id = nativeGetIdAttribute(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.317 -0400", hash_original_method = "6EA4969C84EC91743C886113DBDA4AC3", hash_generated_method = "6A71BDDAB391BD9D5E9A1A86918C8AC5")
        public String getClassAttribute() {
            int id = nativeGetClassAttribute(mParseState);
String varAB024744B99AEC970E7EFF5B57F7E3E8_2083408881 =             id >= 0 ? mStrings.get(id).toString() : null;
            varAB024744B99AEC970E7EFF5B57F7E3E8_2083408881.addTaint(taint);
            return varAB024744B99AEC970E7EFF5B57F7E3E8_2083408881;
            // ---------- Original Method ----------
            //int id = nativeGetClassAttribute(mParseState);
            //return id >= 0 ? mStrings.get(id).toString() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.318 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "FED2C1F315D38629814840C464B38CF2")
        public int getIdAttributeResourceValue(int defaultValue) {
            addTaint(defaultValue);
            int varCD137CD47DD67CEDD2FB3C345949E98D_761929763 = (getAttributeResourceValue(null, "id", defaultValue));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171732998 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171732998;
            // ---------- Original Method ----------
            //return getAttributeResourceValue(null, "id", defaultValue);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.318 -0400", hash_original_method = "34AB6D031D153719912E2897914AFEED", hash_generated_method = "B240FFF78DC0C7FC77396E210394B6B3")
        public int getStyleAttribute() {
            int var672FF0DE58331DB878C91499A9F3541B_497630810 = (nativeGetStyleAttribute(mParseState));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565990015 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565990015;
            // ---------- Original Method ----------
            //return nativeGetStyleAttribute(mParseState);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.318 -0400", hash_original_method = "283F7DAAD4F2484127D9024B5883A661", hash_generated_method = "919549817098AD6C7430CF4A6B84686E")
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.319 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        protected void finalize() throws Throwable {
            close();
            // ---------- Original Method ----------
            //close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.319 -0400", hash_original_method = "E55719651A1187D6CF490013E1512769", hash_generated_method = "9490D998B3ACF2F1F42AF65D4CB21769")
        final CharSequence getPooledString(int id) {
            addTaint(id);
CharSequence varE60373DEF60CD26E76B56CA0EAE527B4_368816401 =             mStrings.get(id);
            varE60373DEF60CD26E76B56CA0EAE527B4_368816401.addTaint(taint);
            return varE60373DEF60CD26E76B56CA0EAE527B4_368816401;
            // ---------- Original Method ----------
            //return mStrings.get(id);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.319 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

