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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.632 -0400", hash_original_field = "411C3A7A9C40CC3933F588BBB034DE72", hash_generated_field = "84211CF74EF03623F21BA45FAB60638A")

    private Fields mFields = new Fields("voscbtka");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.632 -0400", hash_original_field = "CE1323E9AA1F05E97BC1C5C98DE08C78", hash_generated_field = "055E5E861C47EC7A7744F5944F014D67")

    private ArrayList<Media> mMedia = new ArrayList<Media>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.633 -0400", hash_original_method = "2A5A308C97610724520D8E7C21BD0897", hash_generated_method = "6F960B300522659810552A3FF526341D")
    public  SimpleSessionDescription(long sessionId, String address) {
        address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") + address;
        mFields.parse("v=0");
        mFields.parse(String.format("o=- %d %d %s", sessionId,
                System.currentTimeMillis(), address));
        mFields.parse("s=-");
        mFields.parse("t=0 0");
        mFields.parse("c=" + address);
        addTaint(sessionId);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") + address;
        //mFields.parse("v=0");
        //mFields.parse(String.format("o=- %d %d %s", sessionId,
                //System.currentTimeMillis(), address));
        //mFields.parse("s=-");
        //mFields.parse("t=0 0");
        //mFields.parse("c=" + address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.695 -0400", hash_original_method = "55B596B0C996801BF0FD9956A535E1C7", hash_generated_method = "C42F1AEA69E3B2595E6646193D7040C7")
    public  SimpleSessionDescription(String message) {
        String[] lines;
        lines = message.trim().replaceAll(" +", " ").split("[\r\n]+");
        Fields fields;
        fields = mFields;
        {
            Iterator<String> varCF93D539A3E58828AD23375CCE318758_1101156833 = (lines).iterator();
            varCF93D539A3E58828AD23375CCE318758_1101156833.hasNext();
            String line = varCF93D539A3E58828AD23375CCE318758_1101156833.next();
            {
                try 
                {
                    {
                        boolean var2A91C46D7CA06FE1241C930CCD64DB38_197389284 = (line.charAt(1) != '=');
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varE385D6218CF0ED713D7FF9ED06AAAF9B_252680827 = (line.charAt(0) == 'm');
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
                                Iterator<String> varB518E18E62D7B28384963CA02D6A0575_1021860421 = (parts[3].split(" ")).iterator();
                                varB518E18E62D7B28384963CA02D6A0575_1021860421.hasNext();
                                String format = varB518E18E62D7B28384963CA02D6A0575_1021860421.next();
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
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.697 -0400", hash_original_method = "EA659D41568208E07CC0B460E13AE27A", hash_generated_method = "2FF0834E01F45C5148575E1D0D07DC07")
    public Media newMedia(String type, int port, int portCount,
            String protocol) {
        Media varB4EAC82CA7396A68D541C85D26508E83_1670829372 = null; //Variable for return #1
        Media media;
        media = new Media(type, port, portCount, protocol);
        mMedia.add(media);
        varB4EAC82CA7396A68D541C85D26508E83_1670829372 = media;
        addTaint(type.getTaint());
        addTaint(port);
        addTaint(portCount);
        addTaint(protocol.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1670829372.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1670829372;
        // ---------- Original Method ----------
        //Media media = new Media(type, port, portCount, protocol);
        //mMedia.add(media);
        //return media;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.701 -0400", hash_original_method = "B85596442E6A0B0D5C28199B22779A84", hash_generated_method = "C18C811FB123CF276A90075BA5BFF422")
    public Media[] getMedia() {
        Media[] varB4EAC82CA7396A68D541C85D26508E83_687208277 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_687208277 = mMedia.toArray(new Media[mMedia.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_687208277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_687208277;
        // ---------- Original Method ----------
        //return mMedia.toArray(new Media[mMedia.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.761 -0400", hash_original_method = "5F8774B802EBD1C84B8B67985F8F69FE", hash_generated_method = "CB67FA967E26A8F2E369B316A4CC2D8B")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_475037118 = null; //Variable for return #1
        StringBuilder buffer;
        buffer = new StringBuilder();
        mFields.write(buffer);
        {
            Iterator<Media> var7DC12DFD4C829C8145DD95C7BDB07760_1788364066 = (mMedia).iterator();
            var7DC12DFD4C829C8145DD95C7BDB07760_1788364066.hasNext();
            Media media = var7DC12DFD4C829C8145DD95C7BDB07760_1788364066.next();
            {
                media.write(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_475037118 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_475037118.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_475037118;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //mFields.write(buffer);
        //for (Media media : mMedia) {
            //media.write(buffer);
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.762 -0400", hash_original_method = "F8D52A976FE0230A990054D249BBC343", hash_generated_method = "3CA54382EB6148604E31664F4B726882")
    public String getAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1004851072 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1004851072 = mFields.getAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1004851072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1004851072;
        // ---------- Original Method ----------
        //return mFields.getAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.763 -0400", hash_original_method = "9CF6A3FFF46CFF8C635A973470CB60F8", hash_generated_method = "B94EEECAB6122A313D39FF76B77A97DD")
    public void setAddress(String address) {
        mFields.setAddress(address);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //mFields.setAddress(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.779 -0400", hash_original_method = "CF383146C8D4D1A90CD3326AD48DF581", hash_generated_method = "8400DEDD7AF187291CB6A843EA6B321A")
    public String getEncryptionMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_150537020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_150537020 = mFields.getEncryptionMethod();
        varB4EAC82CA7396A68D541C85D26508E83_150537020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_150537020;
        // ---------- Original Method ----------
        //return mFields.getEncryptionMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.780 -0400", hash_original_method = "A3819CF07A96AB27E331482FA08A72EC", hash_generated_method = "D4A88EDFC396CAD4B493B2830575FB81")
    public String getEncryptionKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_780458594 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_780458594 = mFields.getEncryptionKey();
        varB4EAC82CA7396A68D541C85D26508E83_780458594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_780458594;
        // ---------- Original Method ----------
        //return mFields.getEncryptionKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.781 -0400", hash_original_method = "A82F97B5F7341431789E84B509C9D803", hash_generated_method = "AD30430AF000337739A2F8D250AE7661")
    public void setEncryption(String method, String key) {
        mFields.setEncryption(method, key);
        addTaint(method.getTaint());
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //mFields.setEncryption(method, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.793 -0400", hash_original_method = "E6DC230D0F77B46CC062C029BF806CE1", hash_generated_method = "7D01C509FAB23400F7C39EB26A219C38")
    public String[] getBandwidthTypes() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_554848657 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_554848657 = mFields.getBandwidthTypes();
        varB4EAC82CA7396A68D541C85D26508E83_554848657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_554848657;
        // ---------- Original Method ----------
        //return mFields.getBandwidthTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.797 -0400", hash_original_method = "F5B1268DC2500E20A835AD2EE3964BC1", hash_generated_method = "3C60858FFB37475A7572F6AEC49FB6F0")
    public int getBandwidth(String type) {
        int var2B0CB136CA5B9627C36A8437D5FD8DF0_1138824661 = (mFields.getBandwidth(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982550837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982550837;
        // ---------- Original Method ----------
        //return mFields.getBandwidth(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.811 -0400", hash_original_method = "8E0EC67E7D91F3DDCC83F18482476DA9", hash_generated_method = "354516C5EC1EAD996441E453475977D8")
    public void setBandwidth(String type, int value) {
        mFields.setBandwidth(type, value);
        addTaint(type.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //mFields.setBandwidth(type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.813 -0400", hash_original_method = "5B56D37EB252892A4BEDE959A6610969", hash_generated_method = "26A2CC44569AD756F1E195935B579B47")
    public String[] getAttributeNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_865993569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_865993569 = mFields.getAttributeNames();
        varB4EAC82CA7396A68D541C85D26508E83_865993569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_865993569;
        // ---------- Original Method ----------
        //return mFields.getAttributeNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.828 -0400", hash_original_method = "8C22B12F041FCBB6C901893035A47DF3", hash_generated_method = "527BA862C2DF409529B581D400C9F940")
    public String getAttribute(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1500655039 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1500655039 = mFields.getAttribute(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1500655039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1500655039;
        // ---------- Original Method ----------
        //return mFields.getAttribute(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.829 -0400", hash_original_method = "A5005CAFDCC1F5EB8A695D7ADEDCA043", hash_generated_method = "992097615597F39BB2737B10FD787B6E")
    public void setAttribute(String name, String value) {
        mFields.setAttribute(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mFields.setAttribute(name, value);
    }

    
    public static class Media extends Fields {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.829 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "DA7F98239A4F122D17620AC61DF29F55")

        private String mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.829 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

        private int mPort;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.829 -0400", hash_original_field = "D0E1DF8C25F4A332E41D25A2CE9F3985", hash_generated_field = "664DEF09AA11EB91ABE05F4C73593C8F")

        private int mPortCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.829 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "9531EB6C865FAC78E4991C4D266091F2")

        private String mProtocol;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.829 -0400", hash_original_field = "7FCC7CE9BCEF50DF7B669C389D3C46A1", hash_generated_field = "D1D6A77EEC6AF4F5D93F127A32909A95")

        private ArrayList<String> mFormats = new ArrayList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.830 -0400", hash_original_method = "02F078FAC4A0FFA7B56C26518CB9B9A1", hash_generated_method = "3475065E93FD65F6A2B2E9FB94DB4CC1")
        private  Media(String type, int port, int portCount, String protocol) {
            super("icbka");
            mType = type;
            mPort = port;
            mPortCount = portCount;
            mProtocol = protocol;
            // ---------- Original Method ----------
            //mType = type;
            //mPort = port;
            //mPortCount = portCount;
            //mProtocol = protocol;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.831 -0400", hash_original_method = "F57356AE1A37FC524BD36BB2BA67325B", hash_generated_method = "2882223555C1ED47D2DAB12E19ADB767")
        public String getType() {
            String varB4EAC82CA7396A68D541C85D26508E83_1298348442 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1298348442 = mType;
            varB4EAC82CA7396A68D541C85D26508E83_1298348442.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1298348442;
            // ---------- Original Method ----------
            //return mType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.832 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "282E90F121F85E07DC78DE2970573571")
        public int getPort() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686774900 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686774900;
            // ---------- Original Method ----------
            //return mPort;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.832 -0400", hash_original_method = "7A9595EE55A65FB3ADE35A1A62D4E357", hash_generated_method = "9432F8F004274E863C8093F3BBD279DB")
        public int getPortCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119337621 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119337621;
            // ---------- Original Method ----------
            //return mPortCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.833 -0400", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "23DEC295B81FBD0BDB7C42D72890030E")
        public String getProtocol() {
            String varB4EAC82CA7396A68D541C85D26508E83_277781538 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_277781538 = mProtocol;
            varB4EAC82CA7396A68D541C85D26508E83_277781538.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_277781538;
            // ---------- Original Method ----------
            //return mProtocol;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.857 -0400", hash_original_method = "FE32CC25BB54D83998E2230125207ED2", hash_generated_method = "0AE8C52C12BFA51F8E289B699AA25A27")
        public String[] getFormats() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1054534589 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1054534589 = mFormats.toArray(new String[mFormats.size()]);
            varB4EAC82CA7396A68D541C85D26508E83_1054534589.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1054534589;
            // ---------- Original Method ----------
            //return mFormats.toArray(new String[mFormats.size()]);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.859 -0400", hash_original_method = "FA4CAF6A8A475DAE2E8CED4184402CED", hash_generated_method = "FAF20EE46F4B48FDA00E475C6D3408AB")
        public String getFmtp(String format) {
            String varB4EAC82CA7396A68D541C85D26508E83_173882096 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_173882096 = super.get("a=fmtp:" + format, ' ');
            addTaint(format.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_173882096.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_173882096;
            // ---------- Original Method ----------
            //return super.get("a=fmtp:" + format, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.860 -0400", hash_original_method = "C64230710F5A14357C2D213EB5CAD075", hash_generated_method = "EAE1ECA42CBE719D3AF5E24A5F6FB6C1")
        public void setFormat(String format, String fmtp) {
            mFormats.remove(format);
            mFormats.add(format);
            super.set("a=rtpmap:" + format, ' ', null);
            super.set("a=fmtp:" + format, ' ', fmtp);
            addTaint(format.getTaint());
            addTaint(fmtp.getTaint());
            // ---------- Original Method ----------
            //mFormats.remove(format);
            //mFormats.add(format);
            //super.set("a=rtpmap:" + format, ' ', null);
            //super.set("a=fmtp:" + format, ' ', fmtp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.861 -0400", hash_original_method = "9754946CE829C7317659B7AE5D5C7570", hash_generated_method = "A1931543C9DB1FF7F43237A2DFB1FEE2")
        public void removeFormat(String format) {
            mFormats.remove(format);
            super.set("a=rtpmap:" + format, ' ', null);
            super.set("a=fmtp:" + format, ' ', null);
            addTaint(format.getTaint());
            // ---------- Original Method ----------
            //mFormats.remove(format);
            //super.set("a=rtpmap:" + format, ' ', null);
            //super.set("a=fmtp:" + format, ' ', null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.944 -0400", hash_original_method = "9C0F6B568B86FD34F835983651B5C872", hash_generated_method = "FF7AEBE683ADAEE8D0D14AD2AC03D45F")
        public int[] getRtpPayloadTypes() {
            int[] types;
            types = new int[mFormats.size()];
            int length;
            length = 0;
            {
                Iterator<String> var47228CF1CAC3A7119C63CB4FB44AFEE5_273801133 = (mFormats).iterator();
                var47228CF1CAC3A7119C63CB4FB44AFEE5_273801133.hasNext();
                String format = var47228CF1CAC3A7119C63CB4FB44AFEE5_273801133.next();
                {
                    try 
                    {
                        types[length] = Integer.parseInt(format);
                    } //End block
                    catch (NumberFormatException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            int[] varFBCA3D756DD0E2B9A9D5B7108F9FAE70_1304183077 = (Arrays.copyOf(types, length));
            int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1572118798 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1572118798;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.945 -0400", hash_original_method = "24059B72158848D6AA4D09BBC6EA89FF", hash_generated_method = "B32611FE00D0CABA46FFB2E108D412F5")
        public String getRtpmap(int type) {
            String varB4EAC82CA7396A68D541C85D26508E83_1446810136 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1446810136 = super.get("a=rtpmap:" + type, ' ');
            addTaint(type);
            varB4EAC82CA7396A68D541C85D26508E83_1446810136.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1446810136;
            // ---------- Original Method ----------
            //return super.get("a=rtpmap:" + type, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.945 -0400", hash_original_method = "B26584A4E479E1852859F85D5F0DF9AE", hash_generated_method = "ECB2E1FCBDDDBEB169F1B3FBB557F6B1")
        public String getFmtp(int type) {
            String varB4EAC82CA7396A68D541C85D26508E83_767604815 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_767604815 = super.get("a=fmtp:" + type, ' ');
            addTaint(type);
            varB4EAC82CA7396A68D541C85D26508E83_767604815.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_767604815;
            // ---------- Original Method ----------
            //return super.get("a=fmtp:" + type, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.949 -0400", hash_original_method = "F9FA54C35728FF67E338ECA5310C56AD", hash_generated_method = "358E0566D51378FE8722E49A018E5601")
        public void setRtpPayload(int type, String rtpmap, String fmtp) {
            String format;
            format = String.valueOf(type);
            mFormats.remove(format);
            mFormats.add(format);
            super.set("a=rtpmap:" + format, ' ', rtpmap);
            super.set("a=fmtp:" + format, ' ', fmtp);
            addTaint(type);
            addTaint(rtpmap.getTaint());
            addTaint(fmtp.getTaint());
            // ---------- Original Method ----------
            //String format = String.valueOf(type);
            //mFormats.remove(format);
            //mFormats.add(format);
            //super.set("a=rtpmap:" + format, ' ', rtpmap);
            //super.set("a=fmtp:" + format, ' ', fmtp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.950 -0400", hash_original_method = "DA7390F19D86262D8A26D94062855C18", hash_generated_method = "09E9265B6DCE649275AD04849F8C4A40")
        public void removeRtpPayload(int type) {
            removeFormat(String.valueOf(type));
            addTaint(type);
            // ---------- Original Method ----------
            //removeFormat(String.valueOf(type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.040 -0400", hash_original_method = "9628E0029B5D265C0B7D76261776561B", hash_generated_method = "DBD9E2CF600BAB89093C1870B2BD495E")
        private void write(StringBuilder buffer) {
            buffer.append("m=").append(mType).append(' ').append(mPort);
            {
                buffer.append('/').append(mPortCount);
            } //End block
            buffer.append(' ').append(mProtocol);
            {
                Iterator<String> var47228CF1CAC3A7119C63CB4FB44AFEE5_560054482 = (mFormats).iterator();
                var47228CF1CAC3A7119C63CB4FB44AFEE5_560054482.hasNext();
                String format = var47228CF1CAC3A7119C63CB4FB44AFEE5_560054482.next();
                {
                    buffer.append(' ').append(format);
                } //End block
            } //End collapsed parenthetic
            buffer.append("\r\n");
            super.write(buffer);
            addTaint(buffer.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.040 -0400", hash_original_field = "6D112D2229BB97D14E6F55D683775A63", hash_generated_field = "FE61FA4626921CBB643E7F37A28C123F")

        private String mOrder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.040 -0400", hash_original_field = "8D2D3201709E0D098F0C573D9A872D25", hash_generated_field = "7C10ABDEAB009151722A2C57D0D03F53")

        private ArrayList<String> mLines = new ArrayList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.043 -0400", hash_original_method = "961F9332E222C9766CB023FF8444B0B1", hash_generated_method = "53E28CC7DD6276023EA5568413E9B75D")
          Fields(String order) {
            mOrder = order;
            // ---------- Original Method ----------
            //mOrder = order;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.050 -0400", hash_original_method = "A670B06063C17BED4844A712165B1C95", hash_generated_method = "5411DA23F77A3204A11288A56FCA1A31")
        public String getAddress() {
            String varB4EAC82CA7396A68D541C85D26508E83_284152214 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1764437793 = null; //Variable for return #2
            String varB4EAC82CA7396A68D541C85D26508E83_1171943825 = null; //Variable for return #3
            String address;
            address = get("c", '=');
            {
                varB4EAC82CA7396A68D541C85D26508E83_284152214 = null;
            } //End block
            String[] parts;
            parts = address.split(" ");
            {
                varB4EAC82CA7396A68D541C85D26508E83_1764437793 = null;
            } //End block
            int slash;
            slash = parts[2].indexOf('/');
            varB4EAC82CA7396A68D541C85D26508E83_1171943825 = (slash < 0) ? parts[2] : parts[2].substring(0, slash);
            String varA7E53CE21691AB073D9660D615818899_1596527593; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1596527593 = varB4EAC82CA7396A68D541C85D26508E83_284152214;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1596527593 = varB4EAC82CA7396A68D541C85D26508E83_1764437793;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1596527593 = varB4EAC82CA7396A68D541C85D26508E83_1171943825;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1596527593.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1596527593;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.071 -0400", hash_original_method = "D0AF733436A7D8101A9CE592CCF78EC4", hash_generated_method = "E95F4C81F509B63F7CFCEB4F8DDF8187")
        public void setAddress(String address) {
            {
                address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") +
                        address;
            } //End block
            set("c", '=', address);
            addTaint(address.getTaint());
            // ---------- Original Method ----------
            //if (address != null) {
                //address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") +
                        //address;
            //}
            //set("c", '=', address);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.073 -0400", hash_original_method = "118574D8F2FBBB67C378449350CD8498", hash_generated_method = "B080D90F52560F200F320EAEC1EA6528")
        public String getEncryptionMethod() {
            String varB4EAC82CA7396A68D541C85D26508E83_694603150 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_2064707818 = null; //Variable for return #2
            String encryption;
            encryption = get("k", '=');
            {
                varB4EAC82CA7396A68D541C85D26508E83_694603150 = null;
            } //End block
            int colon;
            colon = encryption.indexOf(':');
            varB4EAC82CA7396A68D541C85D26508E83_2064707818 = (colon == -1) ? encryption : encryption.substring(0, colon);
            String varA7E53CE21691AB073D9660D615818899_705830223; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_705830223 = varB4EAC82CA7396A68D541C85D26508E83_694603150;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_705830223 = varB4EAC82CA7396A68D541C85D26508E83_2064707818;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_705830223.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_705830223;
            // ---------- Original Method ----------
            //String encryption = get("k", '=');
            //if (encryption == null) {
                //return null;
            //}
            //int colon = encryption.indexOf(':');
            //return (colon == -1) ? encryption : encryption.substring(0, colon);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.074 -0400", hash_original_method = "E755BA7ABD1182BDF3E20148341D4912", hash_generated_method = "D936D11A5B796526A6E11BF44515429B")
        public String getEncryptionKey() {
            String varB4EAC82CA7396A68D541C85D26508E83_245436450 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1606318132 = null; //Variable for return #2
            String encryption;
            encryption = get("k", '=');
            {
                varB4EAC82CA7396A68D541C85D26508E83_245436450 = null;
            } //End block
            int colon;
            colon = encryption.indexOf(':');
            varB4EAC82CA7396A68D541C85D26508E83_1606318132 = (colon == -1) ? null : encryption.substring(0, colon + 1);
            String varA7E53CE21691AB073D9660D615818899_518939061; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_518939061 = varB4EAC82CA7396A68D541C85D26508E83_245436450;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_518939061 = varB4EAC82CA7396A68D541C85D26508E83_1606318132;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_518939061.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_518939061;
            // ---------- Original Method ----------
            //String encryption = get("k", '=');
            //if (encryption == null) {
                //return null;
            //}
            //int colon = encryption.indexOf(':');
            //return (colon == -1) ? null : encryption.substring(0, colon + 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.097 -0400", hash_original_method = "D6BD475F892E56E5EB541552A030D2BC", hash_generated_method = "9FFD68E51675810CC139B41D3780D85E")
        public void setEncryption(String method, String key) {
            set("k", '=', (method == null || key == null) ?
                    method : method + ':' + key);
            addTaint(method.getTaint());
            addTaint(key.getTaint());
            // ---------- Original Method ----------
            //set("k", '=', (method == null || key == null) ?
                    //method : method + ':' + key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.098 -0400", hash_original_method = "647C47031353EA6DBD8C2255C9701417", hash_generated_method = "0B838390D65165E7E61298EAEF37FBAF")
        public String[] getBandwidthTypes() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1654108544 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1654108544 = cut("b=", ':');
            varB4EAC82CA7396A68D541C85D26508E83_1654108544.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1654108544;
            // ---------- Original Method ----------
            //return cut("b=", ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.099 -0400", hash_original_method = "AAFC6858B139DD8B4164F3A7991B844E", hash_generated_method = "6BBDE01F05146CCAF0D8BD941EF942AC")
        public int getBandwidth(String type) {
            String value;
            value = get("b=" + type, ':');
            {
                try 
                {
                    int var15DF36F5919623E280F781869F4CE166_2142184769 = (Integer.parseInt(value));
                } //End block
                catch (NumberFormatException e)
                { }
                setBandwidth(type, -1);
            } //End block
            addTaint(type.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_627257738 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_627257738;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.110 -0400", hash_original_method = "599740758F5BEDB2EA85017AA799A405", hash_generated_method = "2421D6A426E57CA22035FC1AFCA0E0F0")
        public void setBandwidth(String type, int value) {
            set("b=" + type, ':', (value < 0) ? null : String.valueOf(value));
            addTaint(type.getTaint());
            addTaint(value);
            // ---------- Original Method ----------
            //set("b=" + type, ':', (value < 0) ? null : String.valueOf(value));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.112 -0400", hash_original_method = "7DE1393AC1C7539875AD2D3F3301C0B7", hash_generated_method = "C6C887537627CF1C2F195145E5C0AED9")
        public String[] getAttributeNames() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_69710518 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_69710518 = cut("a=", ':');
            varB4EAC82CA7396A68D541C85D26508E83_69710518.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_69710518;
            // ---------- Original Method ----------
            //return cut("a=", ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.125 -0400", hash_original_method = "1FA4E1C2AB18E99215F11DC02E4EE2C1", hash_generated_method = "DFDA8CEA3CD4B15AF103AB2CE461124F")
        public String getAttribute(String name) {
            String varB4EAC82CA7396A68D541C85D26508E83_1195190993 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1195190993 = get("a=" + name, ':');
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1195190993.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1195190993;
            // ---------- Original Method ----------
            //return get("a=" + name, ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.125 -0400", hash_original_method = "5FC68CD08D9765AB5882516E9433018C", hash_generated_method = "EE62498AD044C8C3374D73BC8EE68315")
        public void setAttribute(String name, String value) {
            set("a=" + name, ':', value);
            addTaint(name.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
            //set("a=" + name, ':', value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.191 -0400", hash_original_method = "0B643EB7A40766CD17BE57ED23F6E069", hash_generated_method = "D600DA02C503E402FD65B09643615290")
        private void write(StringBuilder buffer) {
            {
                int i;
                i = 0;
                boolean varE03BD4B83C4E7F4CE72B92B8D5D6790B_2066868637 = (i < mOrder.length());
                {
                    char type;
                    type = mOrder.charAt(i);
                    {
                        Iterator<String> var33541B584377259EA3D760823C336186_1571891037 = (mLines).iterator();
                        var33541B584377259EA3D760823C336186_1571891037.hasNext();
                        String line = var33541B584377259EA3D760823C336186_1571891037.next();
                        {
                            {
                                boolean varB22937242D108206FAAC5F0D2B2DA8AE_1241350475 = (line.charAt(0) == type);
                                {
                                    buffer.append(line).append("\r\n");
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            addTaint(buffer.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.198 -0400", hash_original_method = "1E2B4FDCC5FCB983233F6190F7157F83", hash_generated_method = "A18E28817E8CEFC0D53CE5BDACD967CA")
        private void parse(String line) {
            char type;
            type = line.charAt(0);
            {
                boolean var45A4F8DFAB3187D96C88005259980BA6_895267092 = (mOrder.indexOf(type) == -1);
            } //End collapsed parenthetic
            char delimiter;
            delimiter = '=';
            {
                boolean var0ABDD4D7A2D309C7309EBED913CFB9B3_1583666927 = (line.startsWith("a=rtpmap:") || line.startsWith("a=fmtp:"));
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
            addTaint(line.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.359 -0400", hash_original_method = "AC73044C1BE8B35906F49C8C6D477AFE", hash_generated_method = "4EAD039B97A8CB323DAA58E105F4A0E4")
        private String[] cut(String prefix, char delimiter) {
            String[] varB4EAC82CA7396A68D541C85D26508E83_531324067 = null; //Variable for return #1
            String[] names;
            names = new String[mLines.size()];
            int length;
            length = 0;
            {
                Iterator<String> var33541B584377259EA3D760823C336186_1791174248 = (mLines).iterator();
                var33541B584377259EA3D760823C336186_1791174248.hasNext();
                String line = var33541B584377259EA3D760823C336186_1791174248.next();
                {
                    {
                        boolean varE1917FEFE264AB279AD8DEABA6AD762D_991544525 = (line.startsWith(prefix));
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
            varB4EAC82CA7396A68D541C85D26508E83_531324067 = Arrays.copyOf(names, length);
            addTaint(prefix.getTaint());
            addTaint(delimiter);
            varB4EAC82CA7396A68D541C85D26508E83_531324067.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_531324067;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.372 -0400", hash_original_method = "6CC88714FB6247DC4BDAFCE2B4177456", hash_generated_method = "534ECBAB31A0CC3566AD271D0A825081")
        private int find(String key, char delimiter) {
            int length;
            length = key.length();
            {
                int i;
                i = mLines.size() - 1;
                {
                    String line;
                    line = mLines.get(i);
                    {
                        boolean varF5624683B74864B9F31881A98FB34164_7383889 = (line.startsWith(key) && (line.length() == length ||
                        line.charAt(length) == delimiter));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            addTaint(key.getTaint());
            addTaint(delimiter);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089009852 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089009852;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.388 -0400", hash_original_method = "9868AB060D9EE7DD5CB696B838DF99A9", hash_generated_method = "677EEC0BCDDEE196575387A9550EFD46")
        private void set(String key, char delimiter, String value) {
            int index;
            index = find(key, delimiter);
            {
                {
                    boolean var32A7D4D29FF2814FB51F7D7995BD2E16_999501090 = (value.length() != 0);
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
            addTaint(key.getTaint());
            addTaint(delimiter);
            addTaint(value.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.396 -0400", hash_original_method = "820DDC74FB3CD5776CD6646B43FBF51C", hash_generated_method = "E28A6F951E3FE3B13565801A58AC5EAF")
        private String get(String key, char delimiter) {
            String varB4EAC82CA7396A68D541C85D26508E83_1465443161 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1131554700 = null; //Variable for return #2
            int index;
            index = find(key, delimiter);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1465443161 = null;
            } //End block
            String line;
            line = mLines.get(index);
            int length;
            length = key.length();
            varB4EAC82CA7396A68D541C85D26508E83_1131554700 = (line.length() == length) ? "" : line.substring(length + 1);
            addTaint(key.getTaint());
            addTaint(delimiter);
            String varA7E53CE21691AB073D9660D615818899_842082483; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_842082483 = varB4EAC82CA7396A68D541C85D26508E83_1465443161;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_842082483 = varB4EAC82CA7396A68D541C85D26508E83_1131554700;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_842082483.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_842082483;
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

