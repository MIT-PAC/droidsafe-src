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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.386 -0400", hash_original_field = "411C3A7A9C40CC3933F588BBB034DE72", hash_generated_field = "84211CF74EF03623F21BA45FAB60638A")

    private Fields mFields = new Fields("voscbtka");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.386 -0400", hash_original_field = "CE1323E9AA1F05E97BC1C5C98DE08C78", hash_generated_field = "055E5E861C47EC7A7744F5944F014D67")

    private ArrayList<Media> mMedia = new ArrayList<Media>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.389 -0400", hash_original_method = "2A5A308C97610724520D8E7C21BD0897", hash_generated_method = "6F960B300522659810552A3FF526341D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.438 -0400", hash_original_method = "55B596B0C996801BF0FD9956A535E1C7", hash_generated_method = "4293D9ACBEA095E8E68BEEB1A6BEBA29")
    public  SimpleSessionDescription(String message) {
        String[] lines;
        lines = message.trim().replaceAll(" +", " ").split("[\r\n]+");
        Fields fields;
        fields = mFields;
        {
            Iterator<String> varCF93D539A3E58828AD23375CCE318758_1203823726 = (lines).iterator();
            varCF93D539A3E58828AD23375CCE318758_1203823726.hasNext();
            String line = varCF93D539A3E58828AD23375CCE318758_1203823726.next();
            {
                try 
                {
                    {
                        boolean var2A91C46D7CA06FE1241C930CCD64DB38_1371542370 = (line.charAt(1) != '=');
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varE385D6218CF0ED713D7FF9ED06AAAF9B_2066349214 = (line.charAt(0) == 'm');
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
                                Iterator<String> varB518E18E62D7B28384963CA02D6A0575_559596424 = (parts[3].split(" ")).iterator();
                                varB518E18E62D7B28384963CA02D6A0575_559596424.hasNext();
                                String format = varB518E18E62D7B28384963CA02D6A0575_559596424.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.440 -0400", hash_original_method = "EA659D41568208E07CC0B460E13AE27A", hash_generated_method = "5506F765D77D5D3236D33C93DB701A8A")
    public Media newMedia(String type, int port, int portCount,
            String protocol) {
        Media varB4EAC82CA7396A68D541C85D26508E83_1683143247 = null; //Variable for return #1
        Media media;
        media = new Media(type, port, portCount, protocol);
        mMedia.add(media);
        varB4EAC82CA7396A68D541C85D26508E83_1683143247 = media;
        addTaint(type.getTaint());
        addTaint(port);
        addTaint(portCount);
        addTaint(protocol.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1683143247.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1683143247;
        // ---------- Original Method ----------
        //Media media = new Media(type, port, portCount, protocol);
        //mMedia.add(media);
        //return media;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.441 -0400", hash_original_method = "B85596442E6A0B0D5C28199B22779A84", hash_generated_method = "E5D4B0F734D593BC5514C860A76CC156")
    public Media[] getMedia() {
        Media[] varB4EAC82CA7396A68D541C85D26508E83_1433498230 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1433498230 = mMedia.toArray(new Media[mMedia.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1433498230.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1433498230;
        // ---------- Original Method ----------
        //return mMedia.toArray(new Media[mMedia.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.572 -0400", hash_original_method = "5F8774B802EBD1C84B8B67985F8F69FE", hash_generated_method = "C3D223B5C27B0FF4EA1D749BBB2D7D19")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_454130498 = null; //Variable for return #1
        StringBuilder buffer;
        buffer = new StringBuilder();
        mFields.write(buffer);
        {
            Iterator<Media> var7DC12DFD4C829C8145DD95C7BDB07760_1217287340 = (mMedia).iterator();
            var7DC12DFD4C829C8145DD95C7BDB07760_1217287340.hasNext();
            Media media = var7DC12DFD4C829C8145DD95C7BDB07760_1217287340.next();
            {
                media.write(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_454130498 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_454130498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_454130498;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //mFields.write(buffer);
        //for (Media media : mMedia) {
            //media.write(buffer);
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.580 -0400", hash_original_method = "F8D52A976FE0230A990054D249BBC343", hash_generated_method = "55F4125021D50229A86AD22EDCB276B3")
    public String getAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_144107485 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_144107485 = mFields.getAddress();
        varB4EAC82CA7396A68D541C85D26508E83_144107485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_144107485;
        // ---------- Original Method ----------
        //return mFields.getAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.581 -0400", hash_original_method = "9CF6A3FFF46CFF8C635A973470CB60F8", hash_generated_method = "B94EEECAB6122A313D39FF76B77A97DD")
    public void setAddress(String address) {
        mFields.setAddress(address);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //mFields.setAddress(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.582 -0400", hash_original_method = "CF383146C8D4D1A90CD3326AD48DF581", hash_generated_method = "8FC8DC514AB6B0902D040B12B482CA48")
    public String getEncryptionMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1020013536 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1020013536 = mFields.getEncryptionMethod();
        varB4EAC82CA7396A68D541C85D26508E83_1020013536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1020013536;
        // ---------- Original Method ----------
        //return mFields.getEncryptionMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.582 -0400", hash_original_method = "A3819CF07A96AB27E331482FA08A72EC", hash_generated_method = "5F824AC0EDEA6E80C690BB03AD7293DD")
    public String getEncryptionKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1425331466 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1425331466 = mFields.getEncryptionKey();
        varB4EAC82CA7396A68D541C85D26508E83_1425331466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1425331466;
        // ---------- Original Method ----------
        //return mFields.getEncryptionKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.583 -0400", hash_original_method = "A82F97B5F7341431789E84B509C9D803", hash_generated_method = "AD30430AF000337739A2F8D250AE7661")
    public void setEncryption(String method, String key) {
        mFields.setEncryption(method, key);
        addTaint(method.getTaint());
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //mFields.setEncryption(method, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.584 -0400", hash_original_method = "E6DC230D0F77B46CC062C029BF806CE1", hash_generated_method = "E298FEC6FD9552D04219E7195D11A723")
    public String[] getBandwidthTypes() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_960877152 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_960877152 = mFields.getBandwidthTypes();
        varB4EAC82CA7396A68D541C85D26508E83_960877152.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_960877152;
        // ---------- Original Method ----------
        //return mFields.getBandwidthTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.585 -0400", hash_original_method = "F5B1268DC2500E20A835AD2EE3964BC1", hash_generated_method = "C0581E13FAD6980248161AA9FB6EE74C")
    public int getBandwidth(String type) {
        int var2B0CB136CA5B9627C36A8437D5FD8DF0_2141251235 = (mFields.getBandwidth(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529705370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529705370;
        // ---------- Original Method ----------
        //return mFields.getBandwidth(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.596 -0400", hash_original_method = "8E0EC67E7D91F3DDCC83F18482476DA9", hash_generated_method = "354516C5EC1EAD996441E453475977D8")
    public void setBandwidth(String type, int value) {
        mFields.setBandwidth(type, value);
        addTaint(type.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //mFields.setBandwidth(type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.597 -0400", hash_original_method = "5B56D37EB252892A4BEDE959A6610969", hash_generated_method = "22216A53F7B7A0B7D917DCC2AA68F072")
    public String[] getAttributeNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_895525038 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_895525038 = mFields.getAttributeNames();
        varB4EAC82CA7396A68D541C85D26508E83_895525038.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_895525038;
        // ---------- Original Method ----------
        //return mFields.getAttributeNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.598 -0400", hash_original_method = "8C22B12F041FCBB6C901893035A47DF3", hash_generated_method = "B6155BDE8FF57C810E33CCA106BB8827")
    public String getAttribute(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_669294978 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_669294978 = mFields.getAttribute(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_669294978.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_669294978;
        // ---------- Original Method ----------
        //return mFields.getAttribute(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.601 -0400", hash_original_method = "A5005CAFDCC1F5EB8A695D7ADEDCA043", hash_generated_method = "992097615597F39BB2737B10FD787B6E")
    public void setAttribute(String name, String value) {
        mFields.setAttribute(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mFields.setAttribute(name, value);
    }

    
    public static class Media extends Fields {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.601 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "DA7F98239A4F122D17620AC61DF29F55")

        private String mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.601 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

        private int mPort;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.602 -0400", hash_original_field = "D0E1DF8C25F4A332E41D25A2CE9F3985", hash_generated_field = "664DEF09AA11EB91ABE05F4C73593C8F")

        private int mPortCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.602 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "9531EB6C865FAC78E4991C4D266091F2")

        private String mProtocol;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.602 -0400", hash_original_field = "7FCC7CE9BCEF50DF7B669C389D3C46A1", hash_generated_field = "D1D6A77EEC6AF4F5D93F127A32909A95")

        private ArrayList<String> mFormats = new ArrayList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.603 -0400", hash_original_method = "02F078FAC4A0FFA7B56C26518CB9B9A1", hash_generated_method = "3475065E93FD65F6A2B2E9FB94DB4CC1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.617 -0400", hash_original_method = "F57356AE1A37FC524BD36BB2BA67325B", hash_generated_method = "9CEAFBE76B1A26D2AEF80AECC79A72E4")
        public String getType() {
            String varB4EAC82CA7396A68D541C85D26508E83_1415384965 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1415384965 = mType;
            varB4EAC82CA7396A68D541C85D26508E83_1415384965.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1415384965;
            // ---------- Original Method ----------
            //return mType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.617 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "00945FE6ED8769667A94BC40275A67F2")
        public int getPort() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574611432 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574611432;
            // ---------- Original Method ----------
            //return mPort;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.622 -0400", hash_original_method = "7A9595EE55A65FB3ADE35A1A62D4E357", hash_generated_method = "E64C31910ADD1B2CC29A50CDCBC10F17")
        public int getPortCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1308782377 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1308782377;
            // ---------- Original Method ----------
            //return mPortCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.635 -0400", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "4678B96C67F9A9B0480BFBD15B529365")
        public String getProtocol() {
            String varB4EAC82CA7396A68D541C85D26508E83_1651399150 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1651399150 = mProtocol;
            varB4EAC82CA7396A68D541C85D26508E83_1651399150.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1651399150;
            // ---------- Original Method ----------
            //return mProtocol;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.635 -0400", hash_original_method = "FE32CC25BB54D83998E2230125207ED2", hash_generated_method = "64FDD066EC2C79CBE741D6C9219951CC")
        public String[] getFormats() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1920375687 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1920375687 = mFormats.toArray(new String[mFormats.size()]);
            varB4EAC82CA7396A68D541C85D26508E83_1920375687.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1920375687;
            // ---------- Original Method ----------
            //return mFormats.toArray(new String[mFormats.size()]);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.636 -0400", hash_original_method = "FA4CAF6A8A475DAE2E8CED4184402CED", hash_generated_method = "0508D8FD373E5A59C9F3DDA6C2E7C38F")
        public String getFmtp(String format) {
            String varB4EAC82CA7396A68D541C85D26508E83_644929639 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_644929639 = super.get("a=fmtp:" + format, ' ');
            addTaint(format.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_644929639.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_644929639;
            // ---------- Original Method ----------
            //return super.get("a=fmtp:" + format, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.638 -0400", hash_original_method = "C64230710F5A14357C2D213EB5CAD075", hash_generated_method = "EAE1ECA42CBE719D3AF5E24A5F6FB6C1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.639 -0400", hash_original_method = "9754946CE829C7317659B7AE5D5C7570", hash_generated_method = "A1931543C9DB1FF7F43237A2DFB1FEE2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.709 -0400", hash_original_method = "9C0F6B568B86FD34F835983651B5C872", hash_generated_method = "A82123D84EA655363DC4E4E82D2B2A9E")
        public int[] getRtpPayloadTypes() {
            int[] types;
            types = new int[mFormats.size()];
            int length;
            length = 0;
            {
                Iterator<String> var47228CF1CAC3A7119C63CB4FB44AFEE5_57112645 = (mFormats).iterator();
                var47228CF1CAC3A7119C63CB4FB44AFEE5_57112645.hasNext();
                String format = var47228CF1CAC3A7119C63CB4FB44AFEE5_57112645.next();
                {
                    try 
                    {
                        types[length] = Integer.parseInt(format);
                    } //End block
                    catch (NumberFormatException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            int[] varFBCA3D756DD0E2B9A9D5B7108F9FAE70_701279711 = (Arrays.copyOf(types, length));
            int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2129117085 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_2129117085;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.725 -0400", hash_original_method = "24059B72158848D6AA4D09BBC6EA89FF", hash_generated_method = "007507EEB5204B8597F8680776185535")
        public String getRtpmap(int type) {
            String varB4EAC82CA7396A68D541C85D26508E83_1452550798 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1452550798 = super.get("a=rtpmap:" + type, ' ');
            addTaint(type);
            varB4EAC82CA7396A68D541C85D26508E83_1452550798.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1452550798;
            // ---------- Original Method ----------
            //return super.get("a=rtpmap:" + type, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.725 -0400", hash_original_method = "B26584A4E479E1852859F85D5F0DF9AE", hash_generated_method = "E562BD0393DAFBFE1D28D9E57757C845")
        public String getFmtp(int type) {
            String varB4EAC82CA7396A68D541C85D26508E83_217381595 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_217381595 = super.get("a=fmtp:" + type, ' ');
            addTaint(type);
            varB4EAC82CA7396A68D541C85D26508E83_217381595.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_217381595;
            // ---------- Original Method ----------
            //return super.get("a=fmtp:" + type, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.739 -0400", hash_original_method = "F9FA54C35728FF67E338ECA5310C56AD", hash_generated_method = "358E0566D51378FE8722E49A018E5601")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.741 -0400", hash_original_method = "DA7390F19D86262D8A26D94062855C18", hash_generated_method = "09E9265B6DCE649275AD04849F8C4A40")
        public void removeRtpPayload(int type) {
            removeFormat(String.valueOf(type));
            addTaint(type);
            // ---------- Original Method ----------
            //removeFormat(String.valueOf(type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.829 -0400", hash_original_method = "9628E0029B5D265C0B7D76261776561B", hash_generated_method = "65EC6C9D3B6443647BCCECF452C307D0")
        private void write(StringBuilder buffer) {
            buffer.append("m=").append(mType).append(' ').append(mPort);
            {
                buffer.append('/').append(mPortCount);
            } //End block
            buffer.append(' ').append(mProtocol);
            {
                Iterator<String> var47228CF1CAC3A7119C63CB4FB44AFEE5_419771230 = (mFormats).iterator();
                var47228CF1CAC3A7119C63CB4FB44AFEE5_419771230.hasNext();
                String format = var47228CF1CAC3A7119C63CB4FB44AFEE5_419771230.next();
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.829 -0400", hash_original_field = "6D112D2229BB97D14E6F55D683775A63", hash_generated_field = "FE61FA4626921CBB643E7F37A28C123F")

        private String mOrder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.829 -0400", hash_original_field = "8D2D3201709E0D098F0C573D9A872D25", hash_generated_field = "7C10ABDEAB009151722A2C57D0D03F53")

        private ArrayList<String> mLines = new ArrayList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.831 -0400", hash_original_method = "961F9332E222C9766CB023FF8444B0B1", hash_generated_method = "53E28CC7DD6276023EA5568413E9B75D")
          Fields(String order) {
            mOrder = order;
            // ---------- Original Method ----------
            //mOrder = order;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.852 -0400", hash_original_method = "A670B06063C17BED4844A712165B1C95", hash_generated_method = "9BB58A8F7423280B0C94559D73133E01")
        public String getAddress() {
            String varB4EAC82CA7396A68D541C85D26508E83_1979190376 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1450955620 = null; //Variable for return #2
            String varB4EAC82CA7396A68D541C85D26508E83_1037287908 = null; //Variable for return #3
            String address;
            address = get("c", '=');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1979190376 = null;
            } //End block
            String[] parts;
            parts = address.split(" ");
            {
                varB4EAC82CA7396A68D541C85D26508E83_1450955620 = null;
            } //End block
            int slash;
            slash = parts[2].indexOf('/');
            varB4EAC82CA7396A68D541C85D26508E83_1037287908 = (slash < 0) ? parts[2] : parts[2].substring(0, slash);
            String varA7E53CE21691AB073D9660D615818899_692313934; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_692313934 = varB4EAC82CA7396A68D541C85D26508E83_1979190376;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_692313934 = varB4EAC82CA7396A68D541C85D26508E83_1450955620;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_692313934 = varB4EAC82CA7396A68D541C85D26508E83_1037287908;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_692313934.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_692313934;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.854 -0400", hash_original_method = "D0AF733436A7D8101A9CE592CCF78EC4", hash_generated_method = "E95F4C81F509B63F7CFCEB4F8DDF8187")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.855 -0400", hash_original_method = "118574D8F2FBBB67C378449350CD8498", hash_generated_method = "BFF0F86E615D9AB9E7C3A41669E33839")
        public String getEncryptionMethod() {
            String varB4EAC82CA7396A68D541C85D26508E83_1214301560 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1810803591 = null; //Variable for return #2
            String encryption;
            encryption = get("k", '=');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1214301560 = null;
            } //End block
            int colon;
            colon = encryption.indexOf(':');
            varB4EAC82CA7396A68D541C85D26508E83_1810803591 = (colon == -1) ? encryption : encryption.substring(0, colon);
            String varA7E53CE21691AB073D9660D615818899_1744832875; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1744832875 = varB4EAC82CA7396A68D541C85D26508E83_1214301560;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1744832875 = varB4EAC82CA7396A68D541C85D26508E83_1810803591;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1744832875.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1744832875;
            // ---------- Original Method ----------
            //String encryption = get("k", '=');
            //if (encryption == null) {
                //return null;
            //}
            //int colon = encryption.indexOf(':');
            //return (colon == -1) ? encryption : encryption.substring(0, colon);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.871 -0400", hash_original_method = "E755BA7ABD1182BDF3E20148341D4912", hash_generated_method = "EAC9B5FEB1E6DD1D5D8C8D05050D7357")
        public String getEncryptionKey() {
            String varB4EAC82CA7396A68D541C85D26508E83_1432456829 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1507480588 = null; //Variable for return #2
            String encryption;
            encryption = get("k", '=');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1432456829 = null;
            } //End block
            int colon;
            colon = encryption.indexOf(':');
            varB4EAC82CA7396A68D541C85D26508E83_1507480588 = (colon == -1) ? null : encryption.substring(0, colon + 1);
            String varA7E53CE21691AB073D9660D615818899_587270931; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_587270931 = varB4EAC82CA7396A68D541C85D26508E83_1432456829;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_587270931 = varB4EAC82CA7396A68D541C85D26508E83_1507480588;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_587270931.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_587270931;
            // ---------- Original Method ----------
            //String encryption = get("k", '=');
            //if (encryption == null) {
                //return null;
            //}
            //int colon = encryption.indexOf(':');
            //return (colon == -1) ? null : encryption.substring(0, colon + 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.871 -0400", hash_original_method = "D6BD475F892E56E5EB541552A030D2BC", hash_generated_method = "9FFD68E51675810CC139B41D3780D85E")
        public void setEncryption(String method, String key) {
            set("k", '=', (method == null || key == null) ?
                    method : method + ':' + key);
            addTaint(method.getTaint());
            addTaint(key.getTaint());
            // ---------- Original Method ----------
            //set("k", '=', (method == null || key == null) ?
                    //method : method + ':' + key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.872 -0400", hash_original_method = "647C47031353EA6DBD8C2255C9701417", hash_generated_method = "F91E848A8E1D397382C3C04A9B592BF8")
        public String[] getBandwidthTypes() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1115831490 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1115831490 = cut("b=", ':');
            varB4EAC82CA7396A68D541C85D26508E83_1115831490.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1115831490;
            // ---------- Original Method ----------
            //return cut("b=", ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.908 -0400", hash_original_method = "AAFC6858B139DD8B4164F3A7991B844E", hash_generated_method = "F0DBE776E421F7511E356870AB088C7F")
        public int getBandwidth(String type) {
            String value;
            value = get("b=" + type, ':');
            {
                try 
                {
                    int var15DF36F5919623E280F781869F4CE166_1480978354 = (Integer.parseInt(value));
                } //End block
                catch (NumberFormatException e)
                { }
                setBandwidth(type, -1);
            } //End block
            addTaint(type.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254565991 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254565991;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.912 -0400", hash_original_method = "599740758F5BEDB2EA85017AA799A405", hash_generated_method = "2421D6A426E57CA22035FC1AFCA0E0F0")
        public void setBandwidth(String type, int value) {
            set("b=" + type, ':', (value < 0) ? null : String.valueOf(value));
            addTaint(type.getTaint());
            addTaint(value);
            // ---------- Original Method ----------
            //set("b=" + type, ':', (value < 0) ? null : String.valueOf(value));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.913 -0400", hash_original_method = "7DE1393AC1C7539875AD2D3F3301C0B7", hash_generated_method = "2AD91EF9CCD8DBA9D16AB6D4DB194CB3")
        public String[] getAttributeNames() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1718064062 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1718064062 = cut("a=", ':');
            varB4EAC82CA7396A68D541C85D26508E83_1718064062.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1718064062;
            // ---------- Original Method ----------
            //return cut("a=", ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.914 -0400", hash_original_method = "1FA4E1C2AB18E99215F11DC02E4EE2C1", hash_generated_method = "E3834688FC04D27B79AFD2B9A5D589DB")
        public String getAttribute(String name) {
            String varB4EAC82CA7396A68D541C85D26508E83_388774839 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_388774839 = get("a=" + name, ':');
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_388774839.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_388774839;
            // ---------- Original Method ----------
            //return get("a=" + name, ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.915 -0400", hash_original_method = "5FC68CD08D9765AB5882516E9433018C", hash_generated_method = "EE62498AD044C8C3374D73BC8EE68315")
        public void setAttribute(String name, String value) {
            set("a=" + name, ':', value);
            addTaint(name.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
            //set("a=" + name, ':', value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.974 -0400", hash_original_method = "0B643EB7A40766CD17BE57ED23F6E069", hash_generated_method = "585F658F747BB42674CEB9CAD9BE5130")
        private void write(StringBuilder buffer) {
            {
                int i;
                i = 0;
                boolean varE03BD4B83C4E7F4CE72B92B8D5D6790B_253016678 = (i < mOrder.length());
                {
                    char type;
                    type = mOrder.charAt(i);
                    {
                        Iterator<String> var33541B584377259EA3D760823C336186_1829591837 = (mLines).iterator();
                        var33541B584377259EA3D760823C336186_1829591837.hasNext();
                        String line = var33541B584377259EA3D760823C336186_1829591837.next();
                        {
                            {
                                boolean varB22937242D108206FAAC5F0D2B2DA8AE_1446423190 = (line.charAt(0) == type);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.982 -0400", hash_original_method = "1E2B4FDCC5FCB983233F6190F7157F83", hash_generated_method = "40CACF8EF47F5B07A60E3EFC8EA6AB02")
        private void parse(String line) {
            char type;
            type = line.charAt(0);
            {
                boolean var45A4F8DFAB3187D96C88005259980BA6_1509420580 = (mOrder.indexOf(type) == -1);
            } //End collapsed parenthetic
            char delimiter;
            delimiter = '=';
            {
                boolean var0ABDD4D7A2D309C7309EBED913CFB9B3_1555882004 = (line.startsWith("a=rtpmap:") || line.startsWith("a=fmtp:"));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.072 -0400", hash_original_method = "AC73044C1BE8B35906F49C8C6D477AFE", hash_generated_method = "9D97F05153D8FA1B6F54D5AE277D2565")
        private String[] cut(String prefix, char delimiter) {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1784151672 = null; //Variable for return #1
            String[] names;
            names = new String[mLines.size()];
            int length;
            length = 0;
            {
                Iterator<String> var33541B584377259EA3D760823C336186_67610513 = (mLines).iterator();
                var33541B584377259EA3D760823C336186_67610513.hasNext();
                String line = var33541B584377259EA3D760823C336186_67610513.next();
                {
                    {
                        boolean varE1917FEFE264AB279AD8DEABA6AD762D_1987070330 = (line.startsWith(prefix));
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
            varB4EAC82CA7396A68D541C85D26508E83_1784151672 = Arrays.copyOf(names, length);
            addTaint(prefix.getTaint());
            addTaint(delimiter);
            varB4EAC82CA7396A68D541C85D26508E83_1784151672.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1784151672;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.073 -0400", hash_original_method = "6CC88714FB6247DC4BDAFCE2B4177456", hash_generated_method = "13168AE1038F0B51EE09D6D3BE4F223B")
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
                        boolean varF5624683B74864B9F31881A98FB34164_1005973191 = (line.startsWith(key) && (line.length() == length ||
                        line.charAt(length) == delimiter));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            addTaint(key.getTaint());
            addTaint(delimiter);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_184125382 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_184125382;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.074 -0400", hash_original_method = "9868AB060D9EE7DD5CB696B838DF99A9", hash_generated_method = "1B9D74E94F887BDB2F193228FA0941E5")
        private void set(String key, char delimiter, String value) {
            int index;
            index = find(key, delimiter);
            {
                {
                    boolean var32A7D4D29FF2814FB51F7D7995BD2E16_1014994606 = (value.length() != 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.082 -0400", hash_original_method = "820DDC74FB3CD5776CD6646B43FBF51C", hash_generated_method = "DE75CE92E7C322A4CB4A4D10A267F4D5")
        private String get(String key, char delimiter) {
            String varB4EAC82CA7396A68D541C85D26508E83_1259541664 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_634947961 = null; //Variable for return #2
            int index;
            index = find(key, delimiter);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1259541664 = null;
            } //End block
            String line;
            line = mLines.get(index);
            int length;
            length = key.length();
            varB4EAC82CA7396A68D541C85D26508E83_634947961 = (line.length() == length) ? "" : line.substring(length + 1);
            addTaint(key.getTaint());
            addTaint(delimiter);
            String varA7E53CE21691AB073D9660D615818899_924977130; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_924977130 = varB4EAC82CA7396A68D541C85D26508E83_1259541664;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_924977130 = varB4EAC82CA7396A68D541C85D26508E83_634947961;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_924977130.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_924977130;
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

