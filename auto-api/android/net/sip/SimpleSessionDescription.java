package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleSessionDescription {
    private Fields mFields = new Fields("voscbtka");
    private ArrayList<Media> mMedia = new ArrayList<Media>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.166 -0400", hash_original_method = "2A5A308C97610724520D8E7C21BD0897", hash_generated_method = "E4F160F46968C3E9F3F20CF37F4D05AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleSessionDescription(long sessionId, String address) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(sessionId);
        address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") + address;
        mFields.parse("v=0");
        mFields.parse(String.format("o=- %d %d %s", sessionId,
                System.currentTimeMillis(), address));
        mFields.parse("s=-");
        mFields.parse("t=0 0");
        mFields.parse("c=" + address);
        // ---------- Original Method ----------
        //address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") + address;
        //mFields.parse("v=0");
        //mFields.parse(String.format("o=- %d %d %s", sessionId,
                //System.currentTimeMillis(), address));
        //mFields.parse("s=-");
        //mFields.parse("t=0 0");
        //mFields.parse("c=" + address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.168 -0400", hash_original_method = "55B596B0C996801BF0FD9956A535E1C7", hash_generated_method = "2AF2BBA0BB5AABBA68EE4AD4D0B10741")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleSessionDescription(String message) {
        dsTaint.addTaint(message);
        String[] lines;
        lines = message.trim().replaceAll(" +", " ").split("[\r\n]+");
        Fields fields;
        fields = mFields;
        {
            Iterator<String> varCF93D539A3E58828AD23375CCE318758_160447173 = (lines).iterator();
            varCF93D539A3E58828AD23375CCE318758_160447173.hasNext();
            String line = varCF93D539A3E58828AD23375CCE318758_160447173.next();
            {
                try 
                {
                    {
                        boolean var2A91C46D7CA06FE1241C930CCD64DB38_771217701 = (line.charAt(1) != '=');
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varE385D6218CF0ED713D7FF9ED06AAAF9B_1030658584 = (line.charAt(0) == 'm');
                        {
                            String[] parts;
                            parts = line.substring(2).split(" ", 4);
                            String[] ports;
                            ports = parts[1].split("/", 2);
                            Media media;
                            media = newMedia(parts[0], Integer.parseInt(ports[0]),
                            (ports.length < 2) ? 1 : Integer.parseInt(ports[1]),
                            parts[2]);//DSFIXME:  CODE0008: Nested ternary operator in expression
                            {
                                Iterator<String> varB518E18E62D7B28384963CA02D6A0575_1937865277 = (parts[3].split(" ")).iterator();
                                varB518E18E62D7B28384963CA02D6A0575_1937865277.hasNext();
                                String format = varB518E18E62D7B28384963CA02D6A0575_1937865277.next();
                                {
                                    media.setFormat(format, null);
                                } //End block
                            } //End collapsed parenthetic
                            fields = media;
                        } //End block
                        {
                            fields.parse(line);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid SDP: " + line);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.169 -0400", hash_original_method = "EA659D41568208E07CC0B460E13AE27A", hash_generated_method = "92046ECFF70CC444B27F21DD9DACB638")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Media newMedia(String type, int port, int portCount,
            String protocol) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(portCount);
        dsTaint.addTaint(type);
        Media media;
        media = new Media(type, port, portCount, protocol);
        mMedia.add(media);
        return (Media)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Media media = new Media(type, port, portCount, protocol);
        //mMedia.add(media);
        //return media;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.169 -0400", hash_original_method = "B85596442E6A0B0D5C28199B22779A84", hash_generated_method = "8328D00B58BAB144F0EEA7BB665369B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Media[] getMedia() {
        Media[] var81AF0BB681E1AAF7B6C0383895EC1E22_1448874094 = (mMedia.toArray(new Media[mMedia.size()]));
        return (Media[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMedia.toArray(new Media[mMedia.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.171 -0400", hash_original_method = "5F8774B802EBD1C84B8B67985F8F69FE", hash_generated_method = "C23F3B8538AA37C95D266A98E7F5F954")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        StringBuilder buffer;
        buffer = new StringBuilder();
        mFields.write(buffer);
        {
            Iterator<Media> var7DC12DFD4C829C8145DD95C7BDB07760_983852570 = (mMedia).iterator();
            var7DC12DFD4C829C8145DD95C7BDB07760_983852570.hasNext();
            Media media = var7DC12DFD4C829C8145DD95C7BDB07760_983852570.next();
            {
                media.write(buffer);
            } //End block
        } //End collapsed parenthetic
        String varAD28D02EB1C6982A5710D014292E1955_769601725 = (buffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //mFields.write(buffer);
        //for (Media media : mMedia) {
            //media.write(buffer);
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.172 -0400", hash_original_method = "F8D52A976FE0230A990054D249BBC343", hash_generated_method = "9753C734EA30D7E9A7890F52687C8AA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAddress() {
        String var4F585494B1CD5CB05DB579FCC7106FB1_1620647041 = (mFields.getAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFields.getAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.172 -0400", hash_original_method = "9CF6A3FFF46CFF8C635A973470CB60F8", hash_generated_method = "695CAE9CC2D6847842C34A0C40F825CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAddress(String address) {
        dsTaint.addTaint(address);
        mFields.setAddress(address);
        // ---------- Original Method ----------
        //mFields.setAddress(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.172 -0400", hash_original_method = "CF383146C8D4D1A90CD3326AD48DF581", hash_generated_method = "6D2E5BB130279AF06A5F21211443EF39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEncryptionMethod() {
        String varD90D5EDFB63E7752CDF8DB1558E8ED7B_1748039252 = (mFields.getEncryptionMethod());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFields.getEncryptionMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.172 -0400", hash_original_method = "A3819CF07A96AB27E331482FA08A72EC", hash_generated_method = "8133CF11A065CCCA3EA617C78BE764D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEncryptionKey() {
        String var2AE8215CCA97668579AC4CCDE5378894_1771833936 = (mFields.getEncryptionKey());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFields.getEncryptionKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.173 -0400", hash_original_method = "A82F97B5F7341431789E84B509C9D803", hash_generated_method = "E3FD72C9564D867404283C2D14F5D0D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEncryption(String method, String key) {
        dsTaint.addTaint(method);
        dsTaint.addTaint(key);
        mFields.setEncryption(method, key);
        // ---------- Original Method ----------
        //mFields.setEncryption(method, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.173 -0400", hash_original_method = "E6DC230D0F77B46CC062C029BF806CE1", hash_generated_method = "C9835D2032B98B71BADC098E6EE5E822")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getBandwidthTypes() {
        String[] var18E3F2F30E83015B9D882FEB8029B779_1184664953 = (mFields.getBandwidthTypes());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mFields.getBandwidthTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.173 -0400", hash_original_method = "F5B1268DC2500E20A835AD2EE3964BC1", hash_generated_method = "1118A976DC7557C35BA44A3FD28E1C19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBandwidth(String type) {
        dsTaint.addTaint(type);
        int var2B0CB136CA5B9627C36A8437D5FD8DF0_128361305 = (mFields.getBandwidth(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFields.getBandwidth(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.173 -0400", hash_original_method = "8E0EC67E7D91F3DDCC83F18482476DA9", hash_generated_method = "47CBEA1FCA484B7EDE311EC2EE24EFCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBandwidth(String type, int value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(type);
        mFields.setBandwidth(type, value);
        // ---------- Original Method ----------
        //mFields.setBandwidth(type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.174 -0400", hash_original_method = "5B56D37EB252892A4BEDE959A6610969", hash_generated_method = "9F0DB10746541550983E379FFA82A40E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getAttributeNames() {
        String[] varAAD50C290ED8ECD9D7FDA8245E9C3035_639583601 = (mFields.getAttributeNames());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mFields.getAttributeNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.174 -0400", hash_original_method = "8C22B12F041FCBB6C901893035A47DF3", hash_generated_method = "2124A6FC32BB463BB92EEC97F1E038FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAttribute(String name) {
        dsTaint.addTaint(name);
        String var1DDE00364A83C2DC119CE00E67687E37_820373972 = (mFields.getAttribute(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFields.getAttribute(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.174 -0400", hash_original_method = "A5005CAFDCC1F5EB8A695D7ADEDCA043", hash_generated_method = "0BC29D71A5FB8ABFE2AD43F0C1A93B74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAttribute(String name, String value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        mFields.setAttribute(name, value);
        // ---------- Original Method ----------
        //mFields.setAttribute(name, value);
    }

    
    public static class Media extends Fields {
        private String mType;
        private int mPort;
        private int mPortCount;
        private String mProtocol;
        private ArrayList<String> mFormats = new ArrayList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.174 -0400", hash_original_method = "02F078FAC4A0FFA7B56C26518CB9B9A1", hash_generated_method = "DC05C9479ECCA1889A57B727B2E336EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Media(String type, int port, int portCount, String protocol) {
            super("icbka");
            dsTaint.addTaint(port);
            dsTaint.addTaint(protocol);
            dsTaint.addTaint(portCount);
            dsTaint.addTaint(type);
            // ---------- Original Method ----------
            //mType = type;
            //mPort = port;
            //mPortCount = portCount;
            //mProtocol = protocol;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.175 -0400", hash_original_method = "F57356AE1A37FC524BD36BB2BA67325B", hash_generated_method = "177914E54861801B4AD4B79AB0F1D084")
        @DSModeled(DSC.SAFE)
        public String getType() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.175 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "989B279AB861DC9FDC85B5020F096FDA")
        @DSModeled(DSC.SAFE)
        public int getPort() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPort;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.175 -0400", hash_original_method = "7A9595EE55A65FB3ADE35A1A62D4E357", hash_generated_method = "5AE9880A61BCBD7ED18D7B7F29BAB5D3")
        @DSModeled(DSC.SAFE)
        public int getPortCount() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPortCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.175 -0400", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "83BB3D205C9054750B0B417C7DC6C847")
        @DSModeled(DSC.SAFE)
        public String getProtocol() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mProtocol;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.175 -0400", hash_original_method = "FE32CC25BB54D83998E2230125207ED2", hash_generated_method = "092113F4059D9FE656BF7EC46CEE3320")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String[] getFormats() {
            String[] var5589E972FFDDD6FD3AEC26318C58E4B5_311453867 = (mFormats.toArray(new String[mFormats.size()]));
            String[] retVal = new String[1];
            retVal[0] = dsTaint.getTaintString();
            return retVal;
            // ---------- Original Method ----------
            //return mFormats.toArray(new String[mFormats.size()]);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.176 -0400", hash_original_method = "FA4CAF6A8A475DAE2E8CED4184402CED", hash_generated_method = "6C3633991F6A1B90415090ECCCD70D43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getFmtp(String format) {
            dsTaint.addTaint(format);
            String var99E700D8B81A0B92685F03104960704C_1189782195 = (super.get("a=fmtp:" + format, ' '));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return super.get("a=fmtp:" + format, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.176 -0400", hash_original_method = "C64230710F5A14357C2D213EB5CAD075", hash_generated_method = "6D7C786CC04A9752F37A9A5E90BE4E6C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setFormat(String format, String fmtp) {
            dsTaint.addTaint(fmtp);
            dsTaint.addTaint(format);
            mFormats.remove(format);
            mFormats.add(format);
            super.set("a=rtpmap:" + format, ' ', null);
            super.set("a=fmtp:" + format, ' ', fmtp);
            // ---------- Original Method ----------
            //mFormats.remove(format);
            //mFormats.add(format);
            //super.set("a=rtpmap:" + format, ' ', null);
            //super.set("a=fmtp:" + format, ' ', fmtp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.176 -0400", hash_original_method = "9754946CE829C7317659B7AE5D5C7570", hash_generated_method = "6103F7913FFF72C463FFEB17B5EA52C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void removeFormat(String format) {
            dsTaint.addTaint(format);
            mFormats.remove(format);
            super.set("a=rtpmap:" + format, ' ', null);
            super.set("a=fmtp:" + format, ' ', null);
            // ---------- Original Method ----------
            //mFormats.remove(format);
            //super.set("a=rtpmap:" + format, ' ', null);
            //super.set("a=fmtp:" + format, ' ', null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.181 -0400", hash_original_method = "9C0F6B568B86FD34F835983651B5C872", hash_generated_method = "1FE750FF9BEC086559208DDD3AFF945F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int[] getRtpPayloadTypes() {
            int[] types;
            types = new int[mFormats.size()];
            int length;
            length = 0;
            {
                Iterator<String> var47228CF1CAC3A7119C63CB4FB44AFEE5_1337222810 = (mFormats).iterator();
                var47228CF1CAC3A7119C63CB4FB44AFEE5_1337222810.hasNext();
                String format = var47228CF1CAC3A7119C63CB4FB44AFEE5_1337222810.next();
                {
                    try 
                    {
                        types[length] = Integer.parseInt(format);
                    } //End block
                    catch (NumberFormatException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            int[] varFBCA3D756DD0E2B9A9D5B7108F9FAE70_1193659441 = (Arrays.copyOf(types, length));
            int[] retVal = new int[1];
            retVal[0] = dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //int[] types = new int[mFormats.size()];
            //int length = 0;
            //for (String format : mFormats) {
                //try {
                    //types[length] = Integer.parseInt(format);
                    //++length;
                //} catch (NumberFormatException e) { }
            //}
            //return Arrays.copyOf(types, length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.182 -0400", hash_original_method = "24059B72158848D6AA4D09BBC6EA89FF", hash_generated_method = "C9463E6A3AF1E8CD6119ADF30AA8CC8B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getRtpmap(int type) {
            dsTaint.addTaint(type);
            String varD8F0B44D1C2A523E692484E936AF13A6_753989594 = (super.get("a=rtpmap:" + type, ' '));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return super.get("a=rtpmap:" + type, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.182 -0400", hash_original_method = "B26584A4E479E1852859F85D5F0DF9AE", hash_generated_method = "DED61C39E2C2E32442BA21F4CB0B2CAC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getFmtp(int type) {
            dsTaint.addTaint(type);
            String var5E4D9EA0558EC604C98D356D5594A6BB_1390880572 = (super.get("a=fmtp:" + type, ' '));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return super.get("a=fmtp:" + type, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.182 -0400", hash_original_method = "F9FA54C35728FF67E338ECA5310C56AD", hash_generated_method = "31BF11BA2A98FB86913005A12BA269FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setRtpPayload(int type, String rtpmap, String fmtp) {
            dsTaint.addTaint(rtpmap);
            dsTaint.addTaint(fmtp);
            dsTaint.addTaint(type);
            String format;
            format = String.valueOf(type);
            mFormats.remove(format);
            mFormats.add(format);
            super.set("a=rtpmap:" + format, ' ', rtpmap);
            super.set("a=fmtp:" + format, ' ', fmtp);
            // ---------- Original Method ----------
            //String format = String.valueOf(type);
            //mFormats.remove(format);
            //mFormats.add(format);
            //super.set("a=rtpmap:" + format, ' ', rtpmap);
            //super.set("a=fmtp:" + format, ' ', fmtp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.183 -0400", hash_original_method = "DA7390F19D86262D8A26D94062855C18", hash_generated_method = "833A2E41F81B551FCA2B508EFFD0F53C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void removeRtpPayload(int type) {
            dsTaint.addTaint(type);
            removeFormat(String.valueOf(type));
            // ---------- Original Method ----------
            //removeFormat(String.valueOf(type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.188 -0400", hash_original_method = "9628E0029B5D265C0B7D76261776561B", hash_generated_method = "A8CAB92D5BABA643E4039360B55D3C7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void write(StringBuilder buffer) {
            dsTaint.addTaint(buffer.dsTaint);
            buffer.append("m=").append(mType).append(' ').append(mPort);
            {
                buffer.append('/').append(mPortCount);
            } //End block
            buffer.append(' ').append(mProtocol);
            {
                Iterator<String> var47228CF1CAC3A7119C63CB4FB44AFEE5_193246525 = (mFormats).iterator();
                var47228CF1CAC3A7119C63CB4FB44AFEE5_193246525.hasNext();
                String format = var47228CF1CAC3A7119C63CB4FB44AFEE5_193246525.next();
                {
                    buffer.append(' ').append(format);
                } //End block
            } //End collapsed parenthetic
            buffer.append("\r\n");
            super.write(buffer);
            // ---------- Original Method ----------
            //buffer.append("m=").append(mType).append(' ').append(mPort);
            //if (mPortCount != 1) {
                //buffer.append('/').append(mPortCount);
            //}
            //buffer.append(' ').append(mProtocol);
            //for (String format : mFormats) {
                //buffer.append(' ').append(format);
            //}
            //buffer.append("\r\n");
            //super.write(buffer);
        }

        
    }


    
    private static class Fields {
        private String mOrder;
        private ArrayList<String> mLines = new ArrayList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.189 -0400", hash_original_method = "961F9332E222C9766CB023FF8444B0B1", hash_generated_method = "DDA176484CC0C0EB7206264924733C71")
        @DSModeled(DSC.SAFE)
         Fields(String order) {
            dsTaint.addTaint(order);
            // ---------- Original Method ----------
            //mOrder = order;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.189 -0400", hash_original_method = "A670B06063C17BED4844A712165B1C95", hash_generated_method = "3633915A08939C9B7136A2CA77DE84E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAddress() {
            String address;
            address = get("c", '=');
            String[] parts;
            parts = address.split(" ");
            int slash;
            slash = parts[2].indexOf('/');
            {
                Object var3BA2EDB8EECE53976F46BA2781C3DB58_910955474 = (parts[2].substring(0, slash));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String address = get("c", '=');
            //if (address == null) {
                //return null;
            //}
            //String[] parts = address.split(" ");
            //if (parts.length != 3) {
                //return null;
            //}
            //int slash = parts[2].indexOf('/');
            //return (slash < 0) ? parts[2] : parts[2].substring(0, slash);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.190 -0400", hash_original_method = "D0AF733436A7D8101A9CE592CCF78EC4", hash_generated_method = "743BA7135B8AB238EF2014CAF7CBB881")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setAddress(String address) {
            dsTaint.addTaint(address);
            {
                address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") +
                        address;
            } //End block
            set("c", '=', address);
            // ---------- Original Method ----------
            //if (address != null) {
                //address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") +
                        //address;
            //}
            //set("c", '=', address);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.190 -0400", hash_original_method = "118574D8F2FBBB67C378449350CD8498", hash_generated_method = "5F5C4562B26BDD6D09733C8D92684825")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncryptionMethod() {
            String encryption;
            encryption = get("k", '=');
            int colon;
            colon = encryption.indexOf(':');
            {
                Object var3A2888D4493282EC6D79867ABDD02029_358561976 = (encryption.substring(0, colon));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String encryption = get("k", '=');
            //if (encryption == null) {
                //return null;
            //}
            //int colon = encryption.indexOf(':');
            //return (colon == -1) ? encryption : encryption.substring(0, colon);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.190 -0400", hash_original_method = "E755BA7ABD1182BDF3E20148341D4912", hash_generated_method = "77D5108AFDF3D93AB2C7DA80BD5E6F43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getEncryptionKey() {
            String encryption;
            encryption = get("k", '=');
            int colon;
            colon = encryption.indexOf(':');
            {
                Object var9366EFEC9967503C429401B0BDA8FD45_771409887 = (encryption.substring(0, colon + 1));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String encryption = get("k", '=');
            //if (encryption == null) {
                //return null;
            //}
            //int colon = encryption.indexOf(':');
            //return (colon == -1) ? null : encryption.substring(0, colon + 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.191 -0400", hash_original_method = "D6BD475F892E56E5EB541552A030D2BC", hash_generated_method = "972E2A2B0835891C4E4D6AD076E0F68B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setEncryption(String method, String key) {
            dsTaint.addTaint(method);
            dsTaint.addTaint(key);
            set("k", '=', (method == null || key == null) ?
                    method : method + ':' + key);
            // ---------- Original Method ----------
            //set("k", '=', (method == null || key == null) ?
                    //method : method + ':' + key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.191 -0400", hash_original_method = "647C47031353EA6DBD8C2255C9701417", hash_generated_method = "13D2379396E6F220230076A577496C3A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String[] getBandwidthTypes() {
            String[] var813E1414882DC51C7CBC3270A48AE2A0_1679613856 = (cut("b=", ':'));
            String[] retVal = new String[1];
            retVal[0] = dsTaint.getTaintString();
            return retVal;
            // ---------- Original Method ----------
            //return cut("b=", ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.191 -0400", hash_original_method = "AAFC6858B139DD8B4164F3A7991B844E", hash_generated_method = "0C49C23AFB8151456C49DBE0FBEB38DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getBandwidth(String type) {
            dsTaint.addTaint(type);
            String value;
            value = get("b=" + type, ':');
            {
                try 
                {
                    int var15DF36F5919623E280F781869F4CE166_753515224 = (Integer.parseInt(value));
                } //End block
                catch (NumberFormatException e)
                { }
                setBandwidth(type, -1);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //String value = get("b=" + type, ':');
            //if (value != null) {
                //try {
                    //return Integer.parseInt(value);
                //} catch (NumberFormatException e) { }
                //setBandwidth(type, -1);
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.191 -0400", hash_original_method = "599740758F5BEDB2EA85017AA799A405", hash_generated_method = "6FDDEEF16AB272D110B758F28E69F518")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setBandwidth(String type, int value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(type);
            set("b=" + type, ':', (value < 0) ? null : String.valueOf(value));
            // ---------- Original Method ----------
            //set("b=" + type, ':', (value < 0) ? null : String.valueOf(value));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.192 -0400", hash_original_method = "7DE1393AC1C7539875AD2D3F3301C0B7", hash_generated_method = "66BE6325C91E71C881C2F39B842F7A57")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String[] getAttributeNames() {
            String[] var25D3D7883122113FDF3E55161E32469C_2125805773 = (cut("a=", ':'));
            String[] retVal = new String[1];
            retVal[0] = dsTaint.getTaintString();
            return retVal;
            // ---------- Original Method ----------
            //return cut("a=", ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.192 -0400", hash_original_method = "1FA4E1C2AB18E99215F11DC02E4EE2C1", hash_generated_method = "5B1A1817E89F65C6E272917DCA41FFA2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getAttribute(String name) {
            dsTaint.addTaint(name);
            String varD76FC18FE1D9C54DD6B8C0F0DD5F56EE_2099010312 = (get("a=" + name, ':'));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return get("a=" + name, ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.192 -0400", hash_original_method = "5FC68CD08D9765AB5882516E9433018C", hash_generated_method = "1FAACFDF7C60A98F2C06525A7129D57C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setAttribute(String name, String value) {
            dsTaint.addTaint(name);
            dsTaint.addTaint(value);
            set("a=" + name, ':', value);
            // ---------- Original Method ----------
            //set("a=" + name, ':', value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.196 -0400", hash_original_method = "0B643EB7A40766CD17BE57ED23F6E069", hash_generated_method = "B8C0BF90DBAFB87DCC977387516650BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void write(StringBuilder buffer) {
            dsTaint.addTaint(buffer.dsTaint);
            {
                int i;
                i = 0;
                boolean varE03BD4B83C4E7F4CE72B92B8D5D6790B_1498398050 = (i < mOrder.length());
                {
                    char type;
                    type = mOrder.charAt(i);
                    {
                        Iterator<String> var33541B584377259EA3D760823C336186_2095384059 = (mLines).iterator();
                        var33541B584377259EA3D760823C336186_2095384059.hasNext();
                        String line = var33541B584377259EA3D760823C336186_2095384059.next();
                        {
                            {
                                boolean varB22937242D108206FAAC5F0D2B2DA8AE_974612206 = (line.charAt(0) == type);
                                {
                                    buffer.append(line).append("\r\n");
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //for (int i = 0; i < mOrder.length(); ++i) {
                //char type = mOrder.charAt(i);
                //for (String line : mLines) {
                    //if (line.charAt(0) == type) {
                        //buffer.append(line).append("\r\n");
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.197 -0400", hash_original_method = "1E2B4FDCC5FCB983233F6190F7157F83", hash_generated_method = "546656232F374BB81F09A6CAB27F9793")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void parse(String line) {
            dsTaint.addTaint(line);
            char type;
            type = line.charAt(0);
            {
                boolean var45A4F8DFAB3187D96C88005259980BA6_1125654327 = (mOrder.indexOf(type) == -1);
            } //End collapsed parenthetic
            char delimiter;
            delimiter = '=';
            {
                boolean var0ABDD4D7A2D309C7309EBED913CFB9B3_345803017 = (line.startsWith("a=rtpmap:") || line.startsWith("a=fmtp:"));
                {
                    delimiter = ' ';
                } //End block
                {
                    delimiter = ':';
                } //End block
            } //End collapsed parenthetic
            int i;
            i = line.indexOf(delimiter);
            {
                set(line, delimiter, "");
            } //End block
            {
                set(line.substring(0, i), delimiter, line.substring(i + 1));
            } //End block
            // ---------- Original Method ----------
            //char type = line.charAt(0);
            //if (mOrder.indexOf(type) == -1) {
                //return;
            //}
            //char delimiter = '=';
            //if (line.startsWith("a=rtpmap:") || line.startsWith("a=fmtp:")) {
                //delimiter = ' ';
            //} else if (type == 'b' || type == 'a') {
                //delimiter = ':';
            //}
            //int i = line.indexOf(delimiter);
            //if (i == -1) {
                //set(line, delimiter, "");
            //} else {
                //set(line.substring(0, i), delimiter, line.substring(i + 1));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.201 -0400", hash_original_method = "AC73044C1BE8B35906F49C8C6D477AFE", hash_generated_method = "1702F81A1B401B4C0ACBE1061D6B2825")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String[] cut(String prefix, char delimiter) {
            dsTaint.addTaint(delimiter);
            dsTaint.addTaint(prefix);
            String[] names;
            names = new String[mLines.size()];
            int length;
            length = 0;
            {
                Iterator<String> var33541B584377259EA3D760823C336186_170648829 = (mLines).iterator();
                var33541B584377259EA3D760823C336186_170648829.hasNext();
                String line = var33541B584377259EA3D760823C336186_170648829.next();
                {
                    {
                        boolean varE1917FEFE264AB279AD8DEABA6AD762D_412312806 = (line.startsWith(prefix));
                        {
                            int i;
                            i = line.indexOf(delimiter);
                            {
                                i = line.length();
                            } //End block
                            names[length] = line.substring(prefix.length(), i);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            String[] var462E79639E5EA5C432D68024D722E843_1170102986 = (Arrays.copyOf(names, length));
            String[] retVal = new String[1];
            retVal[0] = dsTaint.getTaintString();
            return retVal;
            // ---------- Original Method ----------
            //String[] names = new String[mLines.size()];
            //int length = 0;
            //for (String line : mLines) {
                //if (line.startsWith(prefix)) {
                    //int i = line.indexOf(delimiter);
                    //if (i == -1) {
                        //i = line.length();
                    //}
                    //names[length] = line.substring(prefix.length(), i);
                    //++length;
                //}
            //}
            //return Arrays.copyOf(names, length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.202 -0400", hash_original_method = "6CC88714FB6247DC4BDAFCE2B4177456", hash_generated_method = "29E7518321618D8C4840B9C402E22EC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int find(String key, char delimiter) {
            dsTaint.addTaint(delimiter);
            dsTaint.addTaint(key);
            int length;
            length = key.length();
            {
                int i;
                i = mLines.size() - 1;
                {
                    String line;
                    line = mLines.get(i);
                    {
                        boolean varF5624683B74864B9F31881A98FB34164_2084444009 = (line.startsWith(key) && (line.length() == length ||
                        line.charAt(length) == delimiter));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int length = key.length();
            //for (int i = mLines.size() - 1; i >= 0; --i) {
                //String line = mLines.get(i);
                //if (line.startsWith(key) && (line.length() == length ||
                        //line.charAt(length) == delimiter)) {
                    //return i;
                //}
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.202 -0400", hash_original_method = "9868AB060D9EE7DD5CB696B838DF99A9", hash_generated_method = "1DEC4021001845642D14E2A42CAD1C08")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void set(String key, char delimiter, String value) {
            dsTaint.addTaint(delimiter);
            dsTaint.addTaint(value);
            dsTaint.addTaint(key);
            int index;
            index = find(key, delimiter);
            {
                {
                    boolean var32A7D4D29FF2814FB51F7D7995BD2E16_656849472 = (value.length() != 0);
                    {
                        key = key + delimiter + value;
                    } //End block
                } //End collapsed parenthetic
                {
                    mLines.add(key);
                } //End block
                {
                    mLines.set(index, key);
                } //End block
            } //End block
            {
                mLines.remove(index);
            } //End block
            // ---------- Original Method ----------
            //int index = find(key, delimiter);
            //if (value != null) {
                //if (value.length() != 0) {
                    //key = key + delimiter + value;
                //}
                //if (index == -1) {
                    //mLines.add(key);
                //} else {
                    //mLines.set(index, key);
                //}
            //} else if (index != -1) {
                //mLines.remove(index);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.203 -0400", hash_original_method = "820DDC74FB3CD5776CD6646B43FBF51C", hash_generated_method = "EE78B8F7CBFE02255FCEFD56B9D264AC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String get(String key, char delimiter) {
            dsTaint.addTaint(delimiter);
            dsTaint.addTaint(key);
            int index;
            index = find(key, delimiter);
            String line;
            line = mLines.get(index);
            int length;
            length = key.length();
            {
                boolean var3EAEBB06EB095DF9EF4D0DE94872930E_1544050366 = ((line.length() == length));
                Object var34941C0534D917E941E52C0926169922_1516210069 = (line.substring(length + 1));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int index = find(key, delimiter);
            //if (index == -1) {
                //return null;
            //}
            //String line = mLines.get(index);
            //int length = key.length();
            //return (line.length() == length) ? "" : line.substring(length + 1);
        }

        
    }


    
}

