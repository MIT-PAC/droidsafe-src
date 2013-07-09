package android.net.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleSessionDescription {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.799 -0400", hash_original_field = "411C3A7A9C40CC3933F588BBB034DE72", hash_generated_field = "7FC97BC1C457A3C7034DB3B8BF10C7C3")

    private final Fields mFields = new Fields("voscbtka");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.800 -0400", hash_original_field = "CE1323E9AA1F05E97BC1C5C98DE08C78", hash_generated_field = "25083CE234B196AB0C0988179FBD23E1")

    private final ArrayList<Media> mMedia = new ArrayList<Media>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.800 -0400", hash_original_method = "2A5A308C97610724520D8E7C21BD0897", hash_generated_method = "6F960B300522659810552A3FF526341D")
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
        
        
        
        
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.804 -0400", hash_original_method = "55B596B0C996801BF0FD9956A535E1C7", hash_generated_method = "7171EF711FCA8D4E9470B180922A859A")
    public  SimpleSessionDescription(String message) {
        String[] lines = message.trim().replaceAll(" +", " ").split("[\r\n]+");
        Fields fields = mFields;
        {

            String line = lines[0];
            {
                try 
                {
                    {
                        boolean var2A91C46D7CA06FE1241C930CCD64DB38_1320370472 = (line.charAt(1) != '=');
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                        } 
                    } 
                    {
                        boolean varE385D6218CF0ED713D7FF9ED06AAAF9B_965710956 = (line.charAt(0) == 'm');
                        {
                            String[] parts = line.substring(2).split(" ", 4);
                            String[] ports = parts[1].split("/", 2);
                            Media media = newMedia(parts[0], Integer.parseInt(ports[0]),
                            (ports.length < 2) ? 1 : Integer.parseInt(ports[1]),
                            parts[2]);
                            {
                                
                                String format = parts[3].split(" ")[0];
                                {
                                    media.setFormat(format, null);
                                } 
                            } 
                            fields = media;
                        } 
                        {
                            fields.parse(line);
                        } 
                    } 
                } 
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid SDP: " + line);
                } 
            } 
        } 
        addTaint(message.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.805 -0400", hash_original_method = "EA659D41568208E07CC0B460E13AE27A", hash_generated_method = "96DA4BB16655C2026793C7A64C300B03")
    public Media newMedia(String type, int port, int portCount,
            String protocol) {
        Media varB4EAC82CA7396A68D541C85D26508E83_1690368620 = null; 
        Media media = new Media(type, port, portCount, protocol);
        mMedia.add(media);
        varB4EAC82CA7396A68D541C85D26508E83_1690368620 = media;
        addTaint(type.getTaint());
        addTaint(port);
        addTaint(portCount);
        addTaint(protocol.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1690368620.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1690368620;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.806 -0400", hash_original_method = "B85596442E6A0B0D5C28199B22779A84", hash_generated_method = "847D697CCBA52C6B28A96160056FBE8E")
    public Media[] getMedia() {
        Media[] varB4EAC82CA7396A68D541C85D26508E83_576915803 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_576915803 = mMedia.toArray(new Media[mMedia.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_576915803.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_576915803;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.809 -0400", hash_original_method = "5F8774B802EBD1C84B8B67985F8F69FE", hash_generated_method = "654DBB73850E516B9D65FA883FDE7EB4")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_770871423 = null; 
        StringBuilder buffer = new StringBuilder();
        mFields.write(buffer);
        {
            Iterator<Media> var7DC12DFD4C829C8145DD95C7BDB07760_921162211 = (mMedia).iterator();
            var7DC12DFD4C829C8145DD95C7BDB07760_921162211.hasNext();
            Media media = var7DC12DFD4C829C8145DD95C7BDB07760_921162211.next();
            {
                media.write(buffer);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_770871423 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_770871423.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_770871423;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.810 -0400", hash_original_method = "F8D52A976FE0230A990054D249BBC343", hash_generated_method = "E415B51C3D17CF3F3C7FDD60C43C29D5")
    public String getAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_17062808 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_17062808 = mFields.getAddress();
        varB4EAC82CA7396A68D541C85D26508E83_17062808.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_17062808;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.810 -0400", hash_original_method = "9CF6A3FFF46CFF8C635A973470CB60F8", hash_generated_method = "B94EEECAB6122A313D39FF76B77A97DD")
    public void setAddress(String address) {
        mFields.setAddress(address);
        addTaint(address.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.811 -0400", hash_original_method = "CF383146C8D4D1A90CD3326AD48DF581", hash_generated_method = "BAE19E882F5102A678BD166BE3FB8EF7")
    public String getEncryptionMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_696999731 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_696999731 = mFields.getEncryptionMethod();
        varB4EAC82CA7396A68D541C85D26508E83_696999731.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_696999731;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.812 -0400", hash_original_method = "A3819CF07A96AB27E331482FA08A72EC", hash_generated_method = "4332D9685FAD1E5C200755E182D5E0D0")
    public String getEncryptionKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_745585064 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_745585064 = mFields.getEncryptionKey();
        varB4EAC82CA7396A68D541C85D26508E83_745585064.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_745585064;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.812 -0400", hash_original_method = "A82F97B5F7341431789E84B509C9D803", hash_generated_method = "AD30430AF000337739A2F8D250AE7661")
    public void setEncryption(String method, String key) {
        mFields.setEncryption(method, key);
        addTaint(method.getTaint());
        addTaint(key.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.813 -0400", hash_original_method = "E6DC230D0F77B46CC062C029BF806CE1", hash_generated_method = "C92A5FDBF6C50863DEA4595D93D4AA11")
    public String[] getBandwidthTypes() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_321198193 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_321198193 = mFields.getBandwidthTypes();
        varB4EAC82CA7396A68D541C85D26508E83_321198193.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_321198193;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.814 -0400", hash_original_method = "F5B1268DC2500E20A835AD2EE3964BC1", hash_generated_method = "1A7C3FA8BA7E0710065A9E7923C4B17A")
    public int getBandwidth(String type) {
        int var2B0CB136CA5B9627C36A8437D5FD8DF0_1379110688 = (mFields.getBandwidth(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833749178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833749178;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.815 -0400", hash_original_method = "8E0EC67E7D91F3DDCC83F18482476DA9", hash_generated_method = "354516C5EC1EAD996441E453475977D8")
    public void setBandwidth(String type, int value) {
        mFields.setBandwidth(type, value);
        addTaint(type.getTaint());
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.816 -0400", hash_original_method = "5B56D37EB252892A4BEDE959A6610969", hash_generated_method = "8E5C412AB4C5AAC59BA45E333F5192B8")
    public String[] getAttributeNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_21150898 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_21150898 = mFields.getAttributeNames();
        varB4EAC82CA7396A68D541C85D26508E83_21150898.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_21150898;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.817 -0400", hash_original_method = "8C22B12F041FCBB6C901893035A47DF3", hash_generated_method = "BD9767D6CF576D6809DA03CCB02C2FEF")
    public String getAttribute(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1500148669 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1500148669 = mFields.getAttribute(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1500148669.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1500148669;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.817 -0400", hash_original_method = "A5005CAFDCC1F5EB8A695D7ADEDCA043", hash_generated_method = "992097615597F39BB2737B10FD787B6E")
    public void setAttribute(String name, String value) {
        mFields.setAttribute(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    public static class Media extends Fields {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.817 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "DA7F98239A4F122D17620AC61DF29F55")

        private String mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.817 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

        private int mPort;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.817 -0400", hash_original_field = "D0E1DF8C25F4A332E41D25A2CE9F3985", hash_generated_field = "664DEF09AA11EB91ABE05F4C73593C8F")

        private int mPortCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.817 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "9531EB6C865FAC78E4991C4D266091F2")

        private String mProtocol;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.817 -0400", hash_original_field = "7FCC7CE9BCEF50DF7B669C389D3C46A1", hash_generated_field = "D1D6A77EEC6AF4F5D93F127A32909A95")

        private ArrayList<String> mFormats = new ArrayList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.818 -0400", hash_original_method = "02F078FAC4A0FFA7B56C26518CB9B9A1", hash_generated_method = "3475065E93FD65F6A2B2E9FB94DB4CC1")
        private  Media(String type, int port, int portCount, String protocol) {
            super("icbka");
            mType = type;
            mPort = port;
            mPortCount = portCount;
            mProtocol = protocol;
            
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.818 -0400", hash_original_method = "F57356AE1A37FC524BD36BB2BA67325B", hash_generated_method = "D8E08773911F8F039031B4D25FA66793")
        public String getType() {
            String varB4EAC82CA7396A68D541C85D26508E83_2125710539 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2125710539 = mType;
            varB4EAC82CA7396A68D541C85D26508E83_2125710539.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2125710539;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.819 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "CBE5D20B9B766AD8D0BEF3FCAF2F58CC")
        public int getPort() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_680989320 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_680989320;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.819 -0400", hash_original_method = "7A9595EE55A65FB3ADE35A1A62D4E357", hash_generated_method = "AC9C01DEBDB90B3AAAA7368E27BFABFC")
        public int getPortCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958817980 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958817980;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.820 -0400", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "1A06E42CFB6E2F253D082004B29E48F0")
        public String getProtocol() {
            String varB4EAC82CA7396A68D541C85D26508E83_289857101 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_289857101 = mProtocol;
            varB4EAC82CA7396A68D541C85D26508E83_289857101.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_289857101;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.820 -0400", hash_original_method = "FE32CC25BB54D83998E2230125207ED2", hash_generated_method = "1F5CC06B92E19581B6CD52CD8CDFF67A")
        public String[] getFormats() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_2123229326 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2123229326 = mFormats.toArray(new String[mFormats.size()]);
            varB4EAC82CA7396A68D541C85D26508E83_2123229326.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2123229326;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.821 -0400", hash_original_method = "FA4CAF6A8A475DAE2E8CED4184402CED", hash_generated_method = "08B1549389ECBC7F82F2B79EBD76D877")
        public String getFmtp(String format) {
            String varB4EAC82CA7396A68D541C85D26508E83_113432435 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_113432435 = super.get("a=fmtp:" + format, ' ');
            addTaint(format.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_113432435.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_113432435;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.821 -0400", hash_original_method = "C64230710F5A14357C2D213EB5CAD075", hash_generated_method = "EAE1ECA42CBE719D3AF5E24A5F6FB6C1")
        public void setFormat(String format, String fmtp) {
            mFormats.remove(format);
            mFormats.add(format);
            super.set("a=rtpmap:" + format, ' ', null);
            super.set("a=fmtp:" + format, ' ', fmtp);
            addTaint(format.getTaint());
            addTaint(fmtp.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.821 -0400", hash_original_method = "9754946CE829C7317659B7AE5D5C7570", hash_generated_method = "A1931543C9DB1FF7F43237A2DFB1FEE2")
        public void removeFormat(String format) {
            mFormats.remove(format);
            super.set("a=rtpmap:" + format, ' ', null);
            super.set("a=fmtp:" + format, ' ', null);
            addTaint(format.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.828 -0400", hash_original_method = "9C0F6B568B86FD34F835983651B5C872", hash_generated_method = "451F228E3B9F6262BD5C9378AB74377F")
        public int[] getRtpPayloadTypes() {
            int[] types = new int[mFormats.size()];
            int length = 0;
            {
                Iterator<String> var47228CF1CAC3A7119C63CB4FB44AFEE5_1934886961 = (mFormats).iterator();
                var47228CF1CAC3A7119C63CB4FB44AFEE5_1934886961.hasNext();
                String format = var47228CF1CAC3A7119C63CB4FB44AFEE5_1934886961.next();
                {
                    try 
                    {
                        types[length] = Integer.parseInt(format);
                    } 
                    catch (NumberFormatException e)
                    { }
                } 
            } 
            int[] varFBCA3D756DD0E2B9A9D5B7108F9FAE70_1449137045 = (Arrays.copyOf(types, length));
            int[] varB4CCCA26F9DB9189C32F33E82D425CFB_648093889 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_648093889;
            
            
            
            
                
                    
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.829 -0400", hash_original_method = "24059B72158848D6AA4D09BBC6EA89FF", hash_generated_method = "6CFAE459BC2D1F6E8D5773BF0B442483")
        public String getRtpmap(int type) {
            String varB4EAC82CA7396A68D541C85D26508E83_1416233105 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1416233105 = super.get("a=rtpmap:" + type, ' ');
            addTaint(type);
            varB4EAC82CA7396A68D541C85D26508E83_1416233105.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1416233105;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.829 -0400", hash_original_method = "B26584A4E479E1852859F85D5F0DF9AE", hash_generated_method = "0CD06E963A4ED59DB4AA686867F3DA81")
        public String getFmtp(int type) {
            String varB4EAC82CA7396A68D541C85D26508E83_436008850 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_436008850 = super.get("a=fmtp:" + type, ' ');
            addTaint(type);
            varB4EAC82CA7396A68D541C85D26508E83_436008850.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_436008850;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.830 -0400", hash_original_method = "F9FA54C35728FF67E338ECA5310C56AD", hash_generated_method = "E4B4FA8AA1E13DCB7CE4B21D0808EF8A")
        public void setRtpPayload(int type, String rtpmap, String fmtp) {
            String format = String.valueOf(type);
            mFormats.remove(format);
            mFormats.add(format);
            super.set("a=rtpmap:" + format, ' ', rtpmap);
            super.set("a=fmtp:" + format, ' ', fmtp);
            addTaint(type);
            addTaint(rtpmap.getTaint());
            addTaint(fmtp.getTaint());
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.830 -0400", hash_original_method = "DA7390F19D86262D8A26D94062855C18", hash_generated_method = "09E9265B6DCE649275AD04849F8C4A40")
        public void removeRtpPayload(int type) {
            removeFormat(String.valueOf(type));
            addTaint(type);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.836 -0400", hash_original_method = "9628E0029B5D265C0B7D76261776561B", hash_generated_method = "7FDD70341673E5FE09D157D899F5E554")
        private void write(StringBuilder buffer) {
            buffer.append("m=").append(mType).append(' ').append(mPort);
            {
                buffer.append('/').append(mPortCount);
            } 
            buffer.append(' ').append(mProtocol);
            {
                Iterator<String> var47228CF1CAC3A7119C63CB4FB44AFEE5_789476123 = (mFormats).iterator();
                var47228CF1CAC3A7119C63CB4FB44AFEE5_789476123.hasNext();
                String format = var47228CF1CAC3A7119C63CB4FB44AFEE5_789476123.next();
                {
                    buffer.append(' ').append(format);
                } 
            } 
            buffer.append("\r\n");
            super.write(buffer);
            addTaint(buffer.getTaint());
            
            
            
                
            
            
            
                
            
            
            
        }

        
    }


    
    private static class Fields {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.836 -0400", hash_original_field = "6D112D2229BB97D14E6F55D683775A63", hash_generated_field = "FE61FA4626921CBB643E7F37A28C123F")

        private String mOrder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.836 -0400", hash_original_field = "8D2D3201709E0D098F0C573D9A872D25", hash_generated_field = "8C292B28C2E778857703C352578975B3")

        private final ArrayList<String> mLines = new ArrayList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.837 -0400", hash_original_method = "961F9332E222C9766CB023FF8444B0B1", hash_generated_method = "53E28CC7DD6276023EA5568413E9B75D")
          Fields(String order) {
            mOrder = order;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.838 -0400", hash_original_method = "A670B06063C17BED4844A712165B1C95", hash_generated_method = "9E0751FFE17A590D3B9013514C5E3388")
        public String getAddress() {
            String varB4EAC82CA7396A68D541C85D26508E83_1091531542 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_305887532 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1333784622 = null; 
            String address = get("c", '=');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1091531542 = null;
            } 
            String[] parts = address.split(" ");
            {
                varB4EAC82CA7396A68D541C85D26508E83_305887532 = null;
            } 
            int slash = parts[2].indexOf('/');
            varB4EAC82CA7396A68D541C85D26508E83_1333784622 = (slash < 0) ? parts[2] : parts[2].substring(0, slash);
            String varA7E53CE21691AB073D9660D615818899_1175807648; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1175807648 = varB4EAC82CA7396A68D541C85D26508E83_1091531542;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1175807648 = varB4EAC82CA7396A68D541C85D26508E83_305887532;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1175807648 = varB4EAC82CA7396A68D541C85D26508E83_1333784622;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1175807648.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1175807648;
            
            
            
                
            
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.838 -0400", hash_original_method = "D0AF733436A7D8101A9CE592CCF78EC4", hash_generated_method = "E95F4C81F509B63F7CFCEB4F8DDF8187")
        public void setAddress(String address) {
            {
                address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") +
                        address;
            } 
            set("c", '=', address);
            addTaint(address.getTaint());
            
            
                
                        
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.838 -0400", hash_original_method = "118574D8F2FBBB67C378449350CD8498", hash_generated_method = "00CB8580F2FDA5D496F95B09AE3A9048")
        public String getEncryptionMethod() {
            String varB4EAC82CA7396A68D541C85D26508E83_322309458 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1536701044 = null; 
            String encryption = get("k", '=');
            {
                varB4EAC82CA7396A68D541C85D26508E83_322309458 = null;
            } 
            int colon = encryption.indexOf(':');
            varB4EAC82CA7396A68D541C85D26508E83_1536701044 = (colon == -1) ? encryption : encryption.substring(0, colon);
            String varA7E53CE21691AB073D9660D615818899_1723309795; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1723309795 = varB4EAC82CA7396A68D541C85D26508E83_322309458;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1723309795 = varB4EAC82CA7396A68D541C85D26508E83_1536701044;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1723309795.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1723309795;
            
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.839 -0400", hash_original_method = "E755BA7ABD1182BDF3E20148341D4912", hash_generated_method = "80895D9E8806FAF5A77C1E7FC1F1070B")
        public String getEncryptionKey() {
            String varB4EAC82CA7396A68D541C85D26508E83_1853233823 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1869006772 = null; 
            String encryption = get("k", '=');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1853233823 = null;
            } 
            int colon = encryption.indexOf(':');
            varB4EAC82CA7396A68D541C85D26508E83_1869006772 = (colon == -1) ? null : encryption.substring(0, colon + 1);
            String varA7E53CE21691AB073D9660D615818899_640357879; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_640357879 = varB4EAC82CA7396A68D541C85D26508E83_1853233823;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_640357879 = varB4EAC82CA7396A68D541C85D26508E83_1869006772;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_640357879.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_640357879;
            
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.839 -0400", hash_original_method = "D6BD475F892E56E5EB541552A030D2BC", hash_generated_method = "9FFD68E51675810CC139B41D3780D85E")
        public void setEncryption(String method, String key) {
            set("k", '=', (method == null || key == null) ?
                    method : method + ':' + key);
            addTaint(method.getTaint());
            addTaint(key.getTaint());
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.840 -0400", hash_original_method = "647C47031353EA6DBD8C2255C9701417", hash_generated_method = "4426DAF051D9CD98EC8203D0FF5C9F06")
        public String[] getBandwidthTypes() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1135235527 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1135235527 = cut("b=", ':');
            varB4EAC82CA7396A68D541C85D26508E83_1135235527.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1135235527;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.840 -0400", hash_original_method = "AAFC6858B139DD8B4164F3A7991B844E", hash_generated_method = "04FF290AAA73F12C57DCF6D7D72B4DC7")
        public int getBandwidth(String type) {
            String value = get("b=" + type, ':');
            {
                try 
                {
                    int var15DF36F5919623E280F781869F4CE166_512190360 = (Integer.parseInt(value));
                } 
                catch (NumberFormatException e)
                { }
                setBandwidth(type, -1);
            } 
            addTaint(type.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124145303 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124145303;
            
            
            
                
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.840 -0400", hash_original_method = "599740758F5BEDB2EA85017AA799A405", hash_generated_method = "2421D6A426E57CA22035FC1AFCA0E0F0")
        public void setBandwidth(String type, int value) {
            set("b=" + type, ':', (value < 0) ? null : String.valueOf(value));
            addTaint(type.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.841 -0400", hash_original_method = "7DE1393AC1C7539875AD2D3F3301C0B7", hash_generated_method = "651F2A497B1C39DE60AE3E22B6F2F410")
        public String[] getAttributeNames() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_159813134 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_159813134 = cut("a=", ':');
            varB4EAC82CA7396A68D541C85D26508E83_159813134.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_159813134;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.841 -0400", hash_original_method = "1FA4E1C2AB18E99215F11DC02E4EE2C1", hash_generated_method = "C8D80712F923A76E19A6F2CB9DCBF92C")
        public String getAttribute(String name) {
            String varB4EAC82CA7396A68D541C85D26508E83_1554357769 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1554357769 = get("a=" + name, ':');
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1554357769.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1554357769;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.841 -0400", hash_original_method = "5FC68CD08D9765AB5882516E9433018C", hash_generated_method = "EE62498AD044C8C3374D73BC8EE68315")
        public void setAttribute(String name, String value) {
            set("a=" + name, ':', value);
            addTaint(name.getTaint());
            addTaint(value.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.847 -0400", hash_original_method = "0B643EB7A40766CD17BE57ED23F6E069", hash_generated_method = "59D7FA5648CE991943008A1FEEE66BE4")
        private void write(StringBuilder buffer) {
            {
                int i = 0;
                boolean varE03BD4B83C4E7F4CE72B92B8D5D6790B_180220344 = (i < mOrder.length());
                {
                    char type = mOrder.charAt(i);
                    {
                        Iterator<String> var33541B584377259EA3D760823C336186_2136656744 = (mLines).iterator();
                        var33541B584377259EA3D760823C336186_2136656744.hasNext();
                        String line = var33541B584377259EA3D760823C336186_2136656744.next();
                        {
                            {
                                boolean varB22937242D108206FAAC5F0D2B2DA8AE_524240586 = (line.charAt(0) == type);
                                {
                                    buffer.append(line).append("\r\n");
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            addTaint(buffer.getTaint());
            
            
                
                
                    
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.848 -0400", hash_original_method = "1E2B4FDCC5FCB983233F6190F7157F83", hash_generated_method = "D31B09ED26D5979361BB5C4CE319AC40")
        private void parse(String line) {
            char type = line.charAt(0);
            {
                boolean var45A4F8DFAB3187D96C88005259980BA6_948109805 = (mOrder.indexOf(type) == -1);
            } 
            char delimiter = '=';
            {
                boolean var0ABDD4D7A2D309C7309EBED913CFB9B3_324205766 = (line.startsWith("a=rtpmap:") || line.startsWith("a=fmtp:"));
                {
                    delimiter = ' ';
                } 
                {
                    delimiter = ':';
                } 
            } 
            int i = line.indexOf(delimiter);
            {
                set(line, delimiter, "");
            } 
            {
                set(line.substring(0, i), delimiter, line.substring(i + 1));
            } 
            addTaint(line.getTaint());
            
            
            
                
            
            
            
                
            
                
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.854 -0400", hash_original_method = "AC73044C1BE8B35906F49C8C6D477AFE", hash_generated_method = "B59864405B97F9234258D47EE075C4B0")
        private String[] cut(String prefix, char delimiter) {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1501468246 = null; 
            String[] names = new String[mLines.size()];
            int length = 0;
            {
                Iterator<String> var33541B584377259EA3D760823C336186_1830502970 = (mLines).iterator();
                var33541B584377259EA3D760823C336186_1830502970.hasNext();
                String line = var33541B584377259EA3D760823C336186_1830502970.next();
                {
                    {
                        boolean varE1917FEFE264AB279AD8DEABA6AD762D_542739434 = (line.startsWith(prefix));
                        {
                            int i = line.indexOf(delimiter);
                            {
                                i = line.length();
                            } 
                            names[length] = line.substring(prefix.length(), i);
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1501468246 = Arrays.copyOf(names, length);
            addTaint(prefix.getTaint());
            addTaint(delimiter);
            varB4EAC82CA7396A68D541C85D26508E83_1501468246.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1501468246;
            
            
            
            
                
                    
                    
                        
                    
                    
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.855 -0400", hash_original_method = "6CC88714FB6247DC4BDAFCE2B4177456", hash_generated_method = "E731061764F47EC958A14B0ADA3CDBAB")
        private int find(String key, char delimiter) {
            int length = key.length();
            {
                int i = mLines.size() - 1;
                {
                    String line = mLines.get(i);
                    {
                        boolean varF5624683B74864B9F31881A98FB34164_757574334 = (line.startsWith(key) && (line.length() == length ||
                        line.charAt(length) == delimiter));
                    } 
                } 
            } 
            addTaint(key.getTaint());
            addTaint(delimiter);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683925317 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683925317;
            
            
            
                
                
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.856 -0400", hash_original_method = "9868AB060D9EE7DD5CB696B838DF99A9", hash_generated_method = "6427E8FFEA372C0FBB6CD962BE022FB5")
        private void set(String key, char delimiter, String value) {
            int index = find(key, delimiter);
            {
                {
                    boolean var32A7D4D29FF2814FB51F7D7995BD2E16_1922376413 = (value.length() != 0);
                    {
                        key = key + delimiter + value;
                    } 
                } 
                {
                    mLines.add(key);
                } 
                {
                    mLines.set(index, key);
                } 
            } 
            {
                mLines.remove(index);
            } 
            addTaint(key.getTaint());
            addTaint(delimiter);
            addTaint(value.getTaint());
            
            
            
                
                    
                
                
                    
                
                    
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.858 -0400", hash_original_method = "820DDC74FB3CD5776CD6646B43FBF51C", hash_generated_method = "6550C130CF98F2A3C6E94D8042310D02")
        private String get(String key, char delimiter) {
            String varB4EAC82CA7396A68D541C85D26508E83_1236377252 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1738134726 = null; 
            int index = find(key, delimiter);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1236377252 = null;
            } 
            String line = mLines.get(index);
            int length = key.length();
            varB4EAC82CA7396A68D541C85D26508E83_1738134726 = (line.length() == length) ? "" : line.substring(length + 1);
            addTaint(key.getTaint());
            addTaint(delimiter);
            String varA7E53CE21691AB073D9660D615818899_1853703687; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1853703687 = varB4EAC82CA7396A68D541C85D26508E83_1236377252;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1853703687 = varB4EAC82CA7396A68D541C85D26508E83_1738134726;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1853703687.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1853703687;
            
            
            
                
            
            
            
            
        }

        
    }


    
}

