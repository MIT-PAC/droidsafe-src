package android.content.res;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.xmlpull.v1.XmlPullParserException;

import android.util.TypedValue;

import com.android.internal.util.XmlUtils;

import droidsafe.helpers.DSUtils;

final class XmlBlock {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeCreate(byte[] data,
                                                 int offset,
                                                 int size) {
        return (data.getTaintInt() + data[0] + offset + size);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetStringBlock(int obj) {
        return obj;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeCreateParseState(int obj) {
        return obj;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static final int nativeNext(int state) {
        return state;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetNamespace(int state) {
        return state;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static final int nativeGetName(int state) {
        return state;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetText(int state) {
        return state;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetLineNumber(int state) {
        return state;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetAttributeCount(int state) {
        return state;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetAttributeNamespace(int state, int idx) {
        return state + idx;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetAttributeName(int state, int idx) {
        return state + idx;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetAttributeResource(int state, int idx) {
        return state + idx;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetAttributeDataType(int state, int idx) {
        return state + idx;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetAttributeData(int state, int idx) {
        return state + idx;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetAttributeStringValue(int state, int idx) {
        return state + idx;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetIdAttribute(int state) {
        return state;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetClassAttribute(int state) {
        return state;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetStyleAttribute(int state) {
        return state;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int nativeGetAttributeIndex(int state, String namespace, String name) {
        return state + namespace.getTaintInt() + name.getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final void nativeDestroyParseState(int state) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final void nativeDestroy(int obj) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.916 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG=false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.095 -0500", hash_original_field = "4C5448F642D7E098FE1B989A50398568", hash_generated_field = "49B4A4B4F77DF85AA82FF83B2F894508")

    private  AssetManager mAssets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.097 -0500", hash_original_field = "D883352313723F88BD080533FB82D9CF", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private  int mNative;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.099 -0500", hash_original_field = "E687239F3E1A0E0370D394F826B65E89", hash_generated_field = "E687239F3E1A0E0370D394F826B65E89")
  StringBlock mStrings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.101 -0500", hash_original_field = "C88AEDA1700F461F9D03C7F9BF16FB2E", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.103 -0500", hash_original_field = "17127E8AA68912D71B44087149841EDE", hash_generated_field = "D98A2F1C489BE52721534D4A450F131E")

    private int mOpenCount = 1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.919 -0500", hash_original_method = "A22EEB27BFE227BD171CA1655E28A01F", hash_generated_method = "E71F79D40A927106CA74C9701D544910")
    
public XmlBlock(byte[] data) {
        mAssets = null;
        mNative = nativeCreate(data, 0, data.length);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.921 -0500", hash_original_method = "B1D68A7ECB78CEADC57D198A6FDBCA28", hash_generated_method = "9A4DCDF42AC9305002DE5EDCC3769C47")
    
public XmlBlock(byte[] data, int offset, int size) {
        mAssets = null;
        mNative = nativeCreate(data, offset, size);
        mStrings = new StringBlock(nativeGetStringBlock(mNative), false);
    }

    /**
     * Create from an existing xml block native object.  This is
     * -extremely- dangerous -- only use it if you absolutely know what you
     *  are doing!  The given native object must exist for the entire lifetime
     *  of this newly creating XmlBlock.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.093 -0500", hash_original_method = "2D0B3C5ECC15AA5F78B0AD70805A049B", hash_generated_method = "2D0B3C5ECC15AA5F78B0AD70805A049B")
    
XmlBlock(AssetManager assets, int xmlBlock) {
        mAssets = assets;
        mNative = xmlBlock;
        mStrings = new StringBlock(nativeGetStringBlock(xmlBlock), false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.923 -0500", hash_original_method = "92B3E7DBAA5D8D51C162522636FE2570", hash_generated_method = "AF0E502AB74BBE0EBBCCB1E833904B48")
    
public void close() {
        synchronized (this) {
            if (mOpen) {
                mOpen = false;
                decOpenCountLocked();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.926 -0500", hash_original_method = "017FB1456432C4B45E3EDBB9E5F1A65C", hash_generated_method = "CBB5BD63BB4E7B35F2644EB5CA1177B3")
    
private void decOpenCountLocked() {
        mOpenCount--;
        if (mOpenCount == 0) {
            nativeDestroy(mNative);
            if (mAssets != null) {
                mAssets.xmlBlockGone(hashCode());
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.928 -0500", hash_original_method = "36FE28CA3339B97C4303841D21F6E4EF", hash_generated_method = "C4E2B0662B748EAA4AD8A26C03D484BC")
    
public XmlResourceParser newParser() {
        synchronized (this) {
            if (mNative != 0) {
                return new Parser(nativeCreateParseState(mNative), this);
            }
            return null;
        }
    }
    
    final class Parser implements XmlResourceParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.070 -0500", hash_original_field = "6CCE16E02108F8B5004F82A927CFF083", hash_generated_field = "6CCE16E02108F8B5004F82A927CFF083")
 int mParseState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.072 -0500", hash_original_field = "8AF231F5A446F6B58BD3E7194B5B0015", hash_generated_field = "3EDA85A0804ED213AA0240D41752F909")

        private  XmlBlock mBlock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.074 -0500", hash_original_field = "5D947BF952E8653BAADEA609028A78F9", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

        private boolean mStarted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.076 -0500", hash_original_field = "559A88A95A57D712B3E6A47E78431D1B", hash_generated_field = "202F76F59FBD4A34EFD44A9FC7F2ED5B")

        private boolean mDecNextDepth = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.078 -0500", hash_original_field = "CBF95C0AE445F172B78BD45B0148F1C2", hash_generated_field = "67A287B1854820A57845B046DB8B7A31")

        private int mDepth = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.081 -0500", hash_original_field = "D54907D8A01DE7E58105EE87AFBFD2BC", hash_generated_field = "4840498E2AA207F0162BEB5586951A29")

        private int mEventType = START_DOCUMENT;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.931 -0500", hash_original_method = "2D249E03AFD474FA9CDB4E7172E5ABB4", hash_generated_method = "2D249E03AFD474FA9CDB4E7172E5ABB4")
        
Parser(int parseState, XmlBlock block) {
            mParseState = parseState;
            mBlock = block;
            block.mOpenCount++;
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.934 -0500", hash_original_method = "C272D7923F75EBE1BE9678831233D06B", hash_generated_method = "347E0F4AC94E8FB49862343388323565")
        
public void setFeature(String name, boolean state) throws XmlPullParserException {
            if (FEATURE_PROCESS_NAMESPACES.equals(name) && state) {
                return;
            }
            if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name) && state) {
                return;
            }
            throw new XmlPullParserException("Unsupported feature: " + name);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.937 -0500", hash_original_method = "AB43D5F41C6A1AAA22A1C5749D672E40", hash_generated_method = "DCFFAC36B007AE2639C8301694948045")
        
public boolean getFeature(String name) {
            if (FEATURE_PROCESS_NAMESPACES.equals(name)) {
                return true;
            }
            if (FEATURE_REPORT_NAMESPACE_ATTRIBUTES.equals(name)) {
                return true;
            }
            return false;
        }
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.939 -0500", hash_original_method = "B8013E7A09E481D305959C445CAA259A", hash_generated_method = "79FBDEE46157A1E3B2501218DF73F95D")
        
public void setProperty(String name, Object value) throws XmlPullParserException {
            throw new XmlPullParserException("setProperty() not supported");
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.941 -0500", hash_original_method = "5175B2315D9AD451CFA017AE30114E6D", hash_generated_method = "210476F9839F99F1A83B89914834B50B")
        
public Object getProperty(String name) {
            return null;
        }
        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.944 -0500", hash_original_method = "C407C4DE5B4382B09BED3CBFBB5B2FE9", hash_generated_method = "BE9B98117489DC0B0FC94AF87CC96769")
        
public void setInput(Reader in) throws XmlPullParserException {
            throw new XmlPullParserException("setInput() not supported");
        }
        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.946 -0500", hash_original_method = "2056A33FA2E1F0F175E1EBF8A8F56238", hash_generated_method = "7892456EC600809972DBF35FD32BB3C6")
        
public void setInput(InputStream inputStream, String inputEncoding) throws XmlPullParserException {
            throw new XmlPullParserException("setInput() not supported");
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.948 -0500", hash_original_method = "523C048AE61D8B3E324838EE2E3CB0C0", hash_generated_method = "090DC5BBF9B81F7E89466054D7D2A594")
        
public void defineEntityReplacementText(String entityName, String replacementText) throws XmlPullParserException {
            throw new XmlPullParserException("defineEntityReplacementText() not supported");
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.950 -0500", hash_original_method = "A5499422039640FD4F9D5601F1C55CCA", hash_generated_method = "67EB34FF1C2C15AC6D34FF6BFF2CD173")
        
public String getNamespacePrefix(int pos) throws XmlPullParserException {
            throw new XmlPullParserException("getNamespacePrefix() not supported");
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.952 -0500", hash_original_method = "5C999184AAA0F0E674F1363E90C0FD13", hash_generated_method = "492027BB4A1A897A566E7A0E4A30783F")
        
public String getInputEncoding() {
            return null;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.955 -0500", hash_original_method = "AE6D93E7ABBCC0A1FA148BC6AE95DD76", hash_generated_method = "EA5A13B54F4AC32C0B9F21FDB54B19B5")
        
public String getNamespace(String prefix) {
            throw new RuntimeException("getNamespace() not supported");
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.957 -0500", hash_original_method = "A423E278D1BE175DD386F3DED425ED1E", hash_generated_method = "D449D5165E97CB9E648470ED086E3DB4")
        
public int getNamespaceCount(int depth) throws XmlPullParserException {
            throw new XmlPullParserException("getNamespaceCount() not supported");
        }
        @DSSafe(DSCat.DATA_STRUCTURE)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.959 -0500", hash_original_method = "D2403D5573FCC08ECC8A73989B7EFE93", hash_generated_method = "DC3028978D13AB1C35987EABA2FF7582")
        
public String getPositionDescription() {
            return "Binary XML file line #" + getLineNumber();
        }
        @DSSource({DSSourceKind.FILE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.961 -0500", hash_original_method = "0BA86538E6BFE859243D39CD091AF1CC", hash_generated_method = "E55E4770A0FBC9E68D7CDC06379DCC3B")
        
public String getNamespaceUri(int pos) throws XmlPullParserException {
            throw new XmlPullParserException("getNamespaceUri() not supported");
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.964 -0500", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "7FAFD36017F4549B56F50F6A5668874B")
        
public int getColumnNumber() {
            return -1;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.966 -0500", hash_original_method = "DE1021F4C2B2A1E4D5CF36677B434DEA", hash_generated_method = "F01D403CDCFD7D68A6FC0F8F677FBC71")
        
public int getDepth() {
            return mDepth;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.968 -0500", hash_original_method = "9AA17B3C306C694E2A4C941D5BD64364", hash_generated_method = "11A4CCA4F7E2D5CA2B2CE783F0F85F1D")
        
public String getText() {
            int id = nativeGetText(mParseState);
            return id >= 0 ? mStrings.get(id).toString() : null;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.970 -0500", hash_original_method = "D6658BAD08E09D6B5CC695C7702E23C1", hash_generated_method = "9D80E9E53DCB711E7332DFD1842F5E21")
        
public int getLineNumber() {
            return nativeGetLineNumber(mParseState);
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.973 -0500", hash_original_method = "8A2CD03AAFDD20222A8759980FBB28AE", hash_generated_method = "E6084B38BAA2FE9473BA4BCE717A2BBE")
        
public int getEventType() throws XmlPullParserException {
            return mEventType;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.975 -0500", hash_original_method = "926F3413D3806C4A183D059B4FD2543E", hash_generated_method = "F1A48B3AB8E643571C0A4D9958608A5C")
        
public boolean isWhitespace() throws XmlPullParserException {
            // whitespace was stripped by aapt.
            return false;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.977 -0500", hash_original_method = "692B884A81B63C3B5FA2E5F7E1379D3F", hash_generated_method = "0CE6F9D97F4B719B20DA74EE3C3D0393")
        
public String getPrefix() {
            throw new RuntimeException("getPrefix not supported");
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.980 -0500", hash_original_method = "03AC06D9FB54ABC98AEB5C7372B8DFCE", hash_generated_method = "E1BC1D833CF72BEB19D2A10E77403204")
        
public char[] getTextCharacters(int[] holderForStartAndLength) {
            String txt = getText();
            char[] chars = null;
            if (txt != null) {
                holderForStartAndLength[0] = 0;
                holderForStartAndLength[1] = txt.length();
                chars = new char[txt.length()];
                txt.getChars(0, txt.length(), chars, 0);
            }
            return chars;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.983 -0500", hash_original_method = "53E841A7D41D7C8EC6230F47D159F5F8", hash_generated_method = "8A50E0007B445B6A9EB1F094D6875325")
        
public String getNamespace() {
            int id = nativeGetNamespace(mParseState);
            return id >= 0 ? mStrings.get(id).toString() : "";
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.985 -0500", hash_original_method = "5E952CADD7A547B8BBE8593EB2804E3F", hash_generated_method = "82F71DAE7B3680F2B058A14E6C7AE705")
        
public String getName() {
            int id = nativeGetName(mParseState);
            return id >= 0 ? mStrings.get(id).toString() : null;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.987 -0500", hash_original_method = "C5B0A5333E9C04C4ABC345C16B794494", hash_generated_method = "625496914830FF31CFD52968AD4B4400")
        
public String getAttributeNamespace(int index) {
            int id = nativeGetAttributeNamespace(mParseState, index);
            if (DEBUG) System.out.println("getAttributeNamespace of " + index + " = " + id);
            if (id >= 0) return mStrings.get(id).toString();
            else if (id == -1) return "";
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.990 -0500", hash_original_method = "84AEB345F706FFE756390519A4CE900D", hash_generated_method = "366DFD35BFB6CC8A196D2AA2E8E35232")
        
public String getAttributeName(int index) {
            int id = nativeGetAttributeName(mParseState, index);
            if (DEBUG) System.out.println("getAttributeName of " + index + " = " + id);
            if (id >= 0) return mStrings.get(id).toString();
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.992 -0500", hash_original_method = "50B51A25D0464B8FD90EECF499D60B48", hash_generated_method = "EC0FACD7FAE162A8FE0341B3F4A77F61")
        
public String getAttributePrefix(int index) {
            throw new RuntimeException("getAttributePrefix not supported");
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.994 -0500", hash_original_method = "860332C2A14F44509730B84BDA1621A5", hash_generated_method = "C66DA091BE7B4CF7E8B3E0BBFADAF73F")
        
public boolean isEmptyElementTag() throws XmlPullParserException {
            // XXX Need to detect this.
            return false;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.997 -0500", hash_original_method = "AF6A401047A56BD2769A9CCD0765487F", hash_generated_method = "251B7B52ECC8CF6BE835BB6EFCEC2E8F")
        
public int getAttributeCount() {
            return mEventType == START_TAG ? nativeGetAttributeCount(mParseState) : -1;
        }
        @DSSafe(DSCat.DATA_STRUCTURE)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.000 -0500", hash_original_method = "F4E9CDB9F128BA6177C44CACB76DA2CC", hash_generated_method = "CB1D628EAE2020F032BE264A79BEB4FE")
        
public String getAttributeValue(int index) {
            int id = nativeGetAttributeStringValue(mParseState, index);
            if (DEBUG) System.out.println("getAttributeValue of " + index + " = " + id);
            if (id >= 0) return mStrings.get(id).toString();

            // May be some other type...  check and try to convert if so.
            int t = nativeGetAttributeDataType(mParseState, index);
            if (t == TypedValue.TYPE_NULL) {
                throw new IndexOutOfBoundsException(String.valueOf(index));
            }

            int v = nativeGetAttributeData(mParseState, index);
            return TypedValue.coerceToString(t, v);
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.002 -0500", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "7C8FF293943A670ABF6F2AFD6D3199E0")
        
public String getAttributeType(int index) {
            return "CDATA";
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.004 -0500", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "2FB0D2D586DF51D33C0DF05BD780E580")
        
public boolean isAttributeDefault(int index) {
            return false;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.006 -0500", hash_original_method = "F3E3F86FBCCE797A7D99504582A16A5E", hash_generated_method = "F63BE3EF77DF6080B20BC49147286072")
        
public int nextToken() throws XmlPullParserException,IOException {
            return next();
        }
        @DSSafe(DSCat.DATA_STRUCTURE)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.009 -0500", hash_original_method = "8127D80C9F5EEB177072DC0AE91ACB4C", hash_generated_method = "45702943C347CDA97048E59AECB51ED2")
        
public String getAttributeValue(String namespace, String name) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, name);
            if (idx >= 0) {
                if (DEBUG) System.out.println("getAttributeName of "
                        + namespace + ":" + name + " index = " + idx);
                if (DEBUG) System.out.println(
                        "Namespace=" + getAttributeNamespace(idx)
                        + "Name=" + getAttributeName(idx)
                        + ", Value=" + getAttributeValue(idx));
                return getAttributeValue(idx);
            }
            return null;
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.011 -0500", hash_original_method = "2DA88A175068BC957038D4798DAD0AF9", hash_generated_method = "D05BE2DE080ACFE1DDC32F95C03DD077")
        
public int next() throws XmlPullParserException,IOException {
            if (!mStarted) {
                mStarted = true;
                return START_DOCUMENT;
            }
            if (mParseState == 0) {
                return END_DOCUMENT;
            }
            int ev = nativeNext(mParseState);
            if (mDecNextDepth) {
                mDepth--;
                mDecNextDepth = false;
            }
            switch (ev) {
            case START_TAG:
                mDepth++;
                break;
            case END_TAG:
                mDecNextDepth = true;
                break;
            }
            mEventType = ev;
            if (ev == END_DOCUMENT) {
                // Automatically close the parse when we reach the end of
                // a document, since the standard XmlPullParser interface
                // doesn't have such an API so most clients will leave us
                // dangling.
                close();
            }
            return ev;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.013 -0500", hash_original_method = "A600298A9B2D06DCD3FD708D87D4E435", hash_generated_method = "6624A22027C52A6C4F4D11DBEDE9736A")
        
public void require(int type, String namespace, String name) throws XmlPullParserException,IOException {
            if (type != getEventType()
                || (namespace != null && !namespace.equals( getNamespace () ) )
                || (name != null && !name.equals( getName() ) ) )
                throw new XmlPullParserException( "expected "+ TYPES[ type ]+getPositionDescription());
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.017 -0500", hash_original_method = "0387CD391BE287242825F05D1B5C07FC", hash_generated_method = "0304AF689283CD5ADE601903F4BECED4")
        
public String nextText() throws XmlPullParserException,IOException {
            if(getEventType() != START_TAG) {
               throw new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG to read next text", this, null);
            }
            int eventType = next();
            if(eventType == TEXT) {
               String result = getText();
               eventType = next();
               if(eventType != END_TAG) {
                 throw new XmlPullParserException(
                    getPositionDescription()
                    + ": event TEXT it must be immediately followed by END_TAG", this, null);
                }
                return result;
            } else if(eventType == END_TAG) {
               return "";
            } else {
               throw new XmlPullParserException(
                 getPositionDescription()
                 + ": parser must be on START_TAG or TEXT to read text", this, null);
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.019 -0500", hash_original_method = "86ECF63697C3285DB17A648F53C02562", hash_generated_method = "BDE69B9E9A99FAEB93E59E6291FA32CA")
        
public int nextTag() throws XmlPullParserException,IOException {
            int eventType = next();
            if(eventType == TEXT && isWhitespace()) {   // skip whitespace
               eventType = next();
            }
            if (eventType != START_TAG && eventType != END_TAG) {
               throw new XmlPullParserException(
                   getPositionDescription() 
                   + ": expected start or end tag", this, null);
            }
            return eventType;
        }
    
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.022 -0500", hash_original_method = "F89E8721AF5486B49BDF02DB68EDEEE5", hash_generated_method = "2D0B790C95773355B53C24708FF64D6F")
        
public int getAttributeNameResource(int index) {
            return nativeGetAttributeResource(mParseState, index);
        }
    
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.024 -0500", hash_original_method = "1215FB5AAEE746C41F9FA8271AAF1E60", hash_generated_method = "A76C36EBFF5AA9A0B831974DF119CFE3")
        
public int getAttributeListValue(String namespace, String attribute,
                String[] options, int defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if (idx >= 0) {
                return getAttributeListValue(idx, options, defaultValue);
            }
            return defaultValue;
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.027 -0500", hash_original_method = "B01E2E5CC96F6EF51E59D8D07AB9873A", hash_generated_method = "EB939D155B0B767864BA24259ABD7AEC")
        
public boolean getAttributeBooleanValue(String namespace, String attribute,
                boolean defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if (idx >= 0) {
                return getAttributeBooleanValue(idx, defaultValue);
            }
            return defaultValue;
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.030 -0500", hash_original_method = "CB3F64435C40C20F84A081F8E49D1C0C", hash_generated_method = "49C4A69555EBC9D45B1C099130A90D5F")
        
public int getAttributeResourceValue(String namespace, String attribute,
                int defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if (idx >= 0) {
                return getAttributeResourceValue(idx, defaultValue);
            }
            return defaultValue;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.032 -0500", hash_original_method = "8EF5A68420C37BD2779707A79B9C3811", hash_generated_method = "D62F8F2FF8B80D306E09B582171DD3F2")
        
public int getAttributeIntValue(String namespace, String attribute,
                int defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if (idx >= 0) {
                return getAttributeIntValue(idx, defaultValue);
            }
            return defaultValue;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.034 -0500", hash_original_method = "133F9E0C363583A7982FF4EDA455C0C4", hash_generated_method = "53F0ADA27969C684C268EBFB13278A66")
        
public int getAttributeUnsignedIntValue(String namespace, String attribute,
                                                int defaultValue)
        {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if (idx >= 0) {
                return getAttributeUnsignedIntValue(idx, defaultValue);
            }
            return defaultValue;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.037 -0500", hash_original_method = "91D09444FE7CF8F77D4AFF725E1E8970", hash_generated_method = "63D94AEA831303EAD8CE080444445F82")
        
public float getAttributeFloatValue(String namespace, String attribute,
                float defaultValue) {
            int idx = nativeGetAttributeIndex(mParseState, namespace, attribute);
            if (idx >= 0) {
                return getAttributeFloatValue(idx, defaultValue);
            }
            return defaultValue;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.039 -0500", hash_original_method = "2BA8E9098E1E3526495883648F7DEF5F", hash_generated_method = "0AE80EC8BC31E35EBDE252F937E2CC24")
        
public int getAttributeListValue(int idx,
                String[] options, int defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            int v = nativeGetAttributeData(mParseState, idx);
            if (t == TypedValue.TYPE_STRING) {
                return XmlUtils.convertValueToList(
                    mStrings.get(v), options, defaultValue);
            }
            return v;
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.041 -0500", hash_original_method = "9FDDF9436ABA275F049CE63B7297D004", hash_generated_method = "1BFAFA406D7FCC6E67F42CD1692368BA")
        
public boolean getAttributeBooleanValue(int idx,
                boolean defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            // Note: don't attempt to convert any other types, because
            // we want to count on appt doing the conversion for us.
            if (t >= TypedValue.TYPE_FIRST_INT &&
                t <= TypedValue.TYPE_LAST_INT) {
                return nativeGetAttributeData(mParseState, idx) != 0;
            }
            return defaultValue;
        }
        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.044 -0500", hash_original_method = "0D4A13949891098942D2BD0FE4681BA9", hash_generated_method = "E2F8847557B20C6541A2F449601D1D01")
        
public int getAttributeResourceValue(int idx, int defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            // Note: don't attempt to convert any other types, because
            // we want to count on appt doing the conversion for us.
            if (t == TypedValue.TYPE_REFERENCE) {
                return nativeGetAttributeData(mParseState, idx);
            }
            return defaultValue;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.046 -0500", hash_original_method = "76347FF1C756B55868935018572B3748", hash_generated_method = "8A3D76A1FADB788AEC8D6C588C4CBEA5")
        
public int getAttributeIntValue(int idx, int defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            // Note: don't attempt to convert any other types, because
            // we want to count on appt doing the conversion for us.
            if (t >= TypedValue.TYPE_FIRST_INT &&
                t <= TypedValue.TYPE_LAST_INT) {
                return nativeGetAttributeData(mParseState, idx);
            }
            return defaultValue;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.049 -0500", hash_original_method = "10FB8704E5561F244AB5AE7B4EFD0C1E", hash_generated_method = "F027B059C0FB0446299E3DD63D5C19C2")
        
public int getAttributeUnsignedIntValue(int idx, int defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            // Note: don't attempt to convert any other types, because
            // we want to count on appt doing the conversion for us.
            if (t >= TypedValue.TYPE_FIRST_INT &&
                t <= TypedValue.TYPE_LAST_INT) {
                return nativeGetAttributeData(mParseState, idx);
            }
            return defaultValue;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.051 -0500", hash_original_method = "BBF18D629EB0696226FD45DB0C0888CC", hash_generated_method = "7E9F369ACAF6C50807889AA7EAEA4613")
        
public float getAttributeFloatValue(int idx, float defaultValue) {
            int t = nativeGetAttributeDataType(mParseState, idx);
            // Note: don't attempt to convert any other types, because
            // we want to count on appt doing the conversion for us.
            if (t == TypedValue.TYPE_FLOAT) {
                return Float.intBitsToFloat(
                    nativeGetAttributeData(mParseState, idx));
            }
            throw new RuntimeException("not a float!");
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.053 -0500", hash_original_method = "459DE28869C0476D8004C0FC89A0FAA3", hash_generated_method = "B9100C809A67A17C8D95FF5DA9E3FFBE")
        
public String getIdAttribute() {
            int id = nativeGetIdAttribute(mParseState);
            return id >= 0 ? mStrings.get(id).toString() : null;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.055 -0500", hash_original_method = "6EA4969C84EC91743C886113DBDA4AC3", hash_generated_method = "2B631D030B05EAAE5B5537011F0343BD")
        
public String getClassAttribute() {
            int id = nativeGetClassAttribute(mParseState);
            return id >= 0 ? mStrings.get(id).toString() : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.057 -0500", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "27C18C547E9144A0596CEEFCB78A42D3")
        
public int getIdAttributeResourceValue(int defaultValue) {
            //todo: create and use native method
            return getAttributeResourceValue(null, "id", defaultValue);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.061 -0500", hash_original_method = "34AB6D031D153719912E2897914AFEED", hash_generated_method = "F08831EF82C6B13B74FDB8A1ABB4FE1C")
        
public int getStyleAttribute() {
            return nativeGetStyleAttribute(mParseState);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.063 -0500", hash_original_method = "283F7DAAD4F2484127D9024B5883A661", hash_generated_method = "BCD5E5B561400FB20FDA77DE3FF5428F")
        
public void close() {
            synchronized (mBlock) {
                if (mParseState != 0) {
                    nativeDestroyParseState(mParseState);
                    mParseState = 0;
                    mBlock.decOpenCountLocked();
                }
            }
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.065 -0500", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "0BF8996A0A6FCACED5B5E8AA34F655BA")
        
protected void finalize() throws Throwable {
            close();
        }

        /*package*/ @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.067 -0500", hash_original_method = "E55719651A1187D6CF490013E1512769", hash_generated_method = "40472AC1B56B347081CB0460B5605667")
        
final CharSequence getPooledString(int id) {
            return mStrings.get(id);
        }
        
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.090 -0500", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "0BF8996A0A6FCACED5B5E8AA34F655BA")
    
protected void finalize() throws Throwable {
        close();
    }
}

