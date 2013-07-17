package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleSessionDescription {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.369 -0400", hash_original_field = "411C3A7A9C40CC3933F588BBB034DE72", hash_generated_field = "7FC97BC1C457A3C7034DB3B8BF10C7C3")

    private final Fields mFields = new Fields("voscbtka");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.369 -0400", hash_original_field = "CE1323E9AA1F05E97BC1C5C98DE08C78", hash_generated_field = "25083CE234B196AB0C0988179FBD23E1")

    private final ArrayList<Media> mMedia = new ArrayList<Media>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.370 -0400", hash_original_method = "2A5A308C97610724520D8E7C21BD0897", hash_generated_method = "95E68D1FD375A4F58844D985779FE980")
    public  SimpleSessionDescription(long sessionId, String address) {
        addTaint(address.getTaint());
        addTaint(sessionId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.370 -0400", hash_original_method = "55B596B0C996801BF0FD9956A535E1C7", hash_generated_method = "EEAEFC31CA3B5D6E6173393E3D0745D0")
    public  SimpleSessionDescription(String message) {
        addTaint(message.getTaint());
        String[] lines = message.trim().replaceAll(" +", " ").split("[\r\n]+");
        Fields fields = mFields;
for(String line : lines)
        {
            try 
            {
                if(line.charAt(1) != '=')                
                {
                    IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1654441117 = new IllegalArgumentException();
                    var5783EF97022AA508B74A1E3EA38534AF_1654441117.addTaint(taint);
                    throw var5783EF97022AA508B74A1E3EA38534AF_1654441117;
                } //End block
                if(line.charAt(0) == 'm')                
                {
                    String[] parts = line.substring(2).split(" ", 4);
                    String[] ports = parts[1].split("/", 2);
                    Media media = newMedia(parts[0], Integer.parseInt(ports[0]),
                            (ports.length < 2) ? 1 : Integer.parseInt(ports[1]),
                            parts[2]);
for(String format : parts[3].split(" "))
                    {
                        media.setFormat(format, null);
                    } //End block
                    fields = media;
                } //End block
                else
                {
                    fields.parse(line);
                } //End block
            } //End block
            catch (Exception e)
            {
                IllegalArgumentException var6241B58D35D06A9EAD1E4E02A9C2DC6A_311307370 = new IllegalArgumentException("Invalid SDP: " + line);
                var6241B58D35D06A9EAD1E4E02A9C2DC6A_311307370.addTaint(taint);
                throw var6241B58D35D06A9EAD1E4E02A9C2DC6A_311307370;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.371 -0400", hash_original_method = "EA659D41568208E07CC0B460E13AE27A", hash_generated_method = "2961411FD89DACEAD4DECB5981D59CDC")
    public Media newMedia(String type, int port, int portCount,
            String protocol) {
        addTaint(protocol.getTaint());
        addTaint(portCount);
        addTaint(port);
        addTaint(type.getTaint());
        Media media = new Media(type, port, portCount, protocol);
        mMedia.add(media);
Media varBE1D6B119ABF0E6270B47941F9EF21CE_2055081616 =         media;
        varBE1D6B119ABF0E6270B47941F9EF21CE_2055081616.addTaint(taint);
        return varBE1D6B119ABF0E6270B47941F9EF21CE_2055081616;
        // ---------- Original Method ----------
        //Media media = new Media(type, port, portCount, protocol);
        //mMedia.add(media);
        //return media;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.372 -0400", hash_original_method = "B85596442E6A0B0D5C28199B22779A84", hash_generated_method = "0D261C797F4F512904D7712E2707FE21")
    public Media[] getMedia() {
Media[] var36F2E75E5285F87859F9AF6BCE3D44D2_855785821 =         mMedia.toArray(new Media[mMedia.size()]);
        var36F2E75E5285F87859F9AF6BCE3D44D2_855785821.addTaint(taint);
        return var36F2E75E5285F87859F9AF6BCE3D44D2_855785821;
        // ---------- Original Method ----------
        //return mMedia.toArray(new Media[mMedia.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.372 -0400", hash_original_method = "5F8774B802EBD1C84B8B67985F8F69FE", hash_generated_method = "D05E3EAE92FCF016F6FABA288746C92F")
    public String encode() {
        StringBuilder buffer = new StringBuilder();
        mFields.write(buffer);
for(Media media : mMedia)
        {
            media.write(buffer);
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_861678272 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_861678272.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_861678272;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //mFields.write(buffer);
        //for (Media media : mMedia) {
            //media.write(buffer);
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.373 -0400", hash_original_method = "F8D52A976FE0230A990054D249BBC343", hash_generated_method = "1B443DE54651934AFDC20BA1F4129888")
    public String getAddress() {
String var636B966AFDAFEC29040EC8E8FA458908_1749296778 =         mFields.getAddress();
        var636B966AFDAFEC29040EC8E8FA458908_1749296778.addTaint(taint);
        return var636B966AFDAFEC29040EC8E8FA458908_1749296778;
        // ---------- Original Method ----------
        //return mFields.getAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.373 -0400", hash_original_method = "9CF6A3FFF46CFF8C635A973470CB60F8", hash_generated_method = "34A578D76264F546764A9C5A523819D7")
    public void setAddress(String address) {
        addTaint(address.getTaint());
        mFields.setAddress(address);
        // ---------- Original Method ----------
        //mFields.setAddress(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.373 -0400", hash_original_method = "CF383146C8D4D1A90CD3326AD48DF581", hash_generated_method = "BC1ECE6084F48FE0F97D674CF4C82065")
    public String getEncryptionMethod() {
String varFB8378A883C94B06797AD07E363171B5_402615709 =         mFields.getEncryptionMethod();
        varFB8378A883C94B06797AD07E363171B5_402615709.addTaint(taint);
        return varFB8378A883C94B06797AD07E363171B5_402615709;
        // ---------- Original Method ----------
        //return mFields.getEncryptionMethod();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.373 -0400", hash_original_method = "A3819CF07A96AB27E331482FA08A72EC", hash_generated_method = "FC971B90E9B1010CD3E94982D99BA098")
    public String getEncryptionKey() {
String var42CDEA47B0DBF9D9734EA57642C02DA2_1049325663 =         mFields.getEncryptionKey();
        var42CDEA47B0DBF9D9734EA57642C02DA2_1049325663.addTaint(taint);
        return var42CDEA47B0DBF9D9734EA57642C02DA2_1049325663;
        // ---------- Original Method ----------
        //return mFields.getEncryptionKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.374 -0400", hash_original_method = "A82F97B5F7341431789E84B509C9D803", hash_generated_method = "36681D182D013C76410578A8A5E337C4")
    public void setEncryption(String method, String key) {
        addTaint(key.getTaint());
        addTaint(method.getTaint());
        mFields.setEncryption(method, key);
        // ---------- Original Method ----------
        //mFields.setEncryption(method, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.374 -0400", hash_original_method = "E6DC230D0F77B46CC062C029BF806CE1", hash_generated_method = "C6354139C17A1647E795406F81B031D8")
    public String[] getBandwidthTypes() {
String[] var91700E63EA946BD1125FA827B9682874_579330647 =         mFields.getBandwidthTypes();
        var91700E63EA946BD1125FA827B9682874_579330647.addTaint(taint);
        return var91700E63EA946BD1125FA827B9682874_579330647;
        // ---------- Original Method ----------
        //return mFields.getBandwidthTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.374 -0400", hash_original_method = "F5B1268DC2500E20A835AD2EE3964BC1", hash_generated_method = "538FD997399C13D872F5231B8F456DFC")
    public int getBandwidth(String type) {
        addTaint(type.getTaint());
        int var5AB10906DB4653C290EB027706B0017A_1299168707 = (mFields.getBandwidth(type));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629782674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629782674;
        // ---------- Original Method ----------
        //return mFields.getBandwidth(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.375 -0400", hash_original_method = "8E0EC67E7D91F3DDCC83F18482476DA9", hash_generated_method = "BA0AE84DBC88374D3ABCD485701AC23B")
    public void setBandwidth(String type, int value) {
        addTaint(value);
        addTaint(type.getTaint());
        mFields.setBandwidth(type, value);
        // ---------- Original Method ----------
        //mFields.setBandwidth(type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.375 -0400", hash_original_method = "5B56D37EB252892A4BEDE959A6610969", hash_generated_method = "BA7D113B6D416AC638045AE65C6749C2")
    public String[] getAttributeNames() {
String[] varE9A1A1DE8F86498B03558DECC84C4DEE_1913494871 =         mFields.getAttributeNames();
        varE9A1A1DE8F86498B03558DECC84C4DEE_1913494871.addTaint(taint);
        return varE9A1A1DE8F86498B03558DECC84C4DEE_1913494871;
        // ---------- Original Method ----------
        //return mFields.getAttributeNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.375 -0400", hash_original_method = "8C22B12F041FCBB6C901893035A47DF3", hash_generated_method = "6CCCD71A3CFB5E833582E9FCE5AF363C")
    public String getAttribute(String name) {
        addTaint(name.getTaint());
String varCA33BF02D280D51D7B795F30C150EFBE_1429630215 =         mFields.getAttribute(name);
        varCA33BF02D280D51D7B795F30C150EFBE_1429630215.addTaint(taint);
        return varCA33BF02D280D51D7B795F30C150EFBE_1429630215;
        // ---------- Original Method ----------
        //return mFields.getAttribute(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.376 -0400", hash_original_method = "A5005CAFDCC1F5EB8A695D7ADEDCA043", hash_generated_method = "2E36B6B67B18BF1F711E142BA852D69C")
    public void setAttribute(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        mFields.setAttribute(name, value);
        // ---------- Original Method ----------
        //mFields.setAttribute(name, value);
    }

    
    public static class Media extends Fields {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.376 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "DA7F98239A4F122D17620AC61DF29F55")

        private String mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.376 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

        private int mPort;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.376 -0400", hash_original_field = "D0E1DF8C25F4A332E41D25A2CE9F3985", hash_generated_field = "664DEF09AA11EB91ABE05F4C73593C8F")

        private int mPortCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.376 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "9531EB6C865FAC78E4991C4D266091F2")

        private String mProtocol;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.376 -0400", hash_original_field = "7FCC7CE9BCEF50DF7B669C389D3C46A1", hash_generated_field = "D1D6A77EEC6AF4F5D93F127A32909A95")

        private ArrayList<String> mFormats = new ArrayList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.377 -0400", hash_original_method = "02F078FAC4A0FFA7B56C26518CB9B9A1", hash_generated_method = "3475065E93FD65F6A2B2E9FB94DB4CC1")
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.378 -0400", hash_original_method = "F57356AE1A37FC524BD36BB2BA67325B", hash_generated_method = "8E5B81CB46D31F78AF10C3FBFE17C5E7")
        public String getType() {
String var4BA7381699FCDF343F6526506FD5D65C_1844631447 =             mType;
            var4BA7381699FCDF343F6526506FD5D65C_1844631447.addTaint(taint);
            return var4BA7381699FCDF343F6526506FD5D65C_1844631447;
            // ---------- Original Method ----------
            //return mType;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.378 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "02B238C7A85D0300B796AA227BEB9100")
        public int getPort() {
            int var5EFA61C4FCA92CA992BE37C2BAF4D350_1418201038 = (mPort);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521136771 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521136771;
            // ---------- Original Method ----------
            //return mPort;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.378 -0400", hash_original_method = "7A9595EE55A65FB3ADE35A1A62D4E357", hash_generated_method = "3BFB05BE0B2C8DF338FB5F26CC276398")
        public int getPortCount() {
            int varD0E1DF8C25F4A332E41D25A2CE9F3985_1433358641 = (mPortCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091847941 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091847941;
            // ---------- Original Method ----------
            //return mPortCount;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.378 -0400", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "CFBC2E8317D999AE767314F16271A3A5")
        public String getProtocol() {
String var08FE45DCAD8E150FAC65A2ED6B7AD1DC_1981123420 =             mProtocol;
            var08FE45DCAD8E150FAC65A2ED6B7AD1DC_1981123420.addTaint(taint);
            return var08FE45DCAD8E150FAC65A2ED6B7AD1DC_1981123420;
            // ---------- Original Method ----------
            //return mProtocol;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.379 -0400", hash_original_method = "FE32CC25BB54D83998E2230125207ED2", hash_generated_method = "60929414BAB837B263BB29481E2AAF7E")
        public String[] getFormats() {
String[] var1AB82AAA43843F67731B6738BE17D9F6_507491027 =             mFormats.toArray(new String[mFormats.size()]);
            var1AB82AAA43843F67731B6738BE17D9F6_507491027.addTaint(taint);
            return var1AB82AAA43843F67731B6738BE17D9F6_507491027;
            // ---------- Original Method ----------
            //return mFormats.toArray(new String[mFormats.size()]);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.380 -0400", hash_original_method = "FA4CAF6A8A475DAE2E8CED4184402CED", hash_generated_method = "D1C9B39D85160BA85783918D1848F736")
        public String getFmtp(String format) {
            addTaint(format.getTaint());
String varFDEF856B706A303731C65E04FA4DF645_872157550 =             super.get("a=fmtp:" + format, ' ');
            varFDEF856B706A303731C65E04FA4DF645_872157550.addTaint(taint);
            return varFDEF856B706A303731C65E04FA4DF645_872157550;
            // ---------- Original Method ----------
            //return super.get("a=fmtp:" + format, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.380 -0400", hash_original_method = "C64230710F5A14357C2D213EB5CAD075", hash_generated_method = "6DD84FE933D967093B0DE843238A8C54")
        public void setFormat(String format, String fmtp) {
            addTaint(fmtp.getTaint());
            addTaint(format.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.381 -0400", hash_original_method = "9754946CE829C7317659B7AE5D5C7570", hash_generated_method = "0170BBF0E323C5C31CB1A595C5240736")
        public void removeFormat(String format) {
            addTaint(format.getTaint());
            mFormats.remove(format);
            super.set("a=rtpmap:" + format, ' ', null);
            super.set("a=fmtp:" + format, ' ', null);
            // ---------- Original Method ----------
            //mFormats.remove(format);
            //super.set("a=rtpmap:" + format, ' ', null);
            //super.set("a=fmtp:" + format, ' ', null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.382 -0400", hash_original_method = "9C0F6B568B86FD34F835983651B5C872", hash_generated_method = "A6CEA89885BDCFA0EA4F8F648797ECC1")
        public int[] getRtpPayloadTypes() {
            int[] types = new int[mFormats.size()];
            int length = 0;
for(String format : mFormats)
            {
                try 
                {
                    types[length] = Integer.parseInt(format);
                    ++length;
                } //End block
                catch (NumberFormatException e)
                {
                } //End block
            } //End block
            int[] var2113B548DE60503AA2F515D1F95008B0_471779146 = (Arrays.copyOf(types, length));
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_253849023 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_253849023;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.383 -0400", hash_original_method = "24059B72158848D6AA4D09BBC6EA89FF", hash_generated_method = "2EC295D2AF968B59D06021934DEC0BCE")
        public String getRtpmap(int type) {
            addTaint(type);
String var51F8CDE9E2CAD0E396CB4B12AD628C37_521848897 =             super.get("a=rtpmap:" + type, ' ');
            var51F8CDE9E2CAD0E396CB4B12AD628C37_521848897.addTaint(taint);
            return var51F8CDE9E2CAD0E396CB4B12AD628C37_521848897;
            // ---------- Original Method ----------
            //return super.get("a=rtpmap:" + type, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.384 -0400", hash_original_method = "B26584A4E479E1852859F85D5F0DF9AE", hash_generated_method = "AC6B12B53D0EA277BC1064C130A1F3E2")
        public String getFmtp(int type) {
            addTaint(type);
String var7469C96DF23F0880E3C389D3B022EFF2_188069914 =             super.get("a=fmtp:" + type, ' ');
            var7469C96DF23F0880E3C389D3B022EFF2_188069914.addTaint(taint);
            return var7469C96DF23F0880E3C389D3B022EFF2_188069914;
            // ---------- Original Method ----------
            //return super.get("a=fmtp:" + type, ' ');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.384 -0400", hash_original_method = "F9FA54C35728FF67E338ECA5310C56AD", hash_generated_method = "134401685065880E9F5440BB6E6494BB")
        public void setRtpPayload(int type, String rtpmap, String fmtp) {
            addTaint(fmtp.getTaint());
            addTaint(rtpmap.getTaint());
            addTaint(type);
            String format = String.valueOf(type);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.385 -0400", hash_original_method = "DA7390F19D86262D8A26D94062855C18", hash_generated_method = "A494A6314722924A08CBD2508B41633C")
        public void removeRtpPayload(int type) {
            addTaint(type);
            removeFormat(String.valueOf(type));
            // ---------- Original Method ----------
            //removeFormat(String.valueOf(type));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.385 -0400", hash_original_method = "9628E0029B5D265C0B7D76261776561B", hash_generated_method = "6229887238B1DDAFF0F2E6DE3886C48B")
        private void write(StringBuilder buffer) {
            addTaint(buffer.getTaint());
            buffer.append("m=").append(mType).append(' ').append(mPort);
            if(mPortCount != 1)            
            {
                buffer.append('/').append(mPortCount);
            } //End block
            buffer.append(' ').append(mProtocol);
for(String format : mFormats)
            {
                buffer.append(' ').append(format);
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.385 -0400", hash_original_field = "6D112D2229BB97D14E6F55D683775A63", hash_generated_field = "FE61FA4626921CBB643E7F37A28C123F")

        private String mOrder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.386 -0400", hash_original_field = "8D2D3201709E0D098F0C573D9A872D25", hash_generated_field = "8C292B28C2E778857703C352578975B3")

        private final ArrayList<String> mLines = new ArrayList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.386 -0400", hash_original_method = "961F9332E222C9766CB023FF8444B0B1", hash_generated_method = "53E28CC7DD6276023EA5568413E9B75D")
          Fields(String order) {
            mOrder = order;
            // ---------- Original Method ----------
            //mOrder = order;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.386 -0400", hash_original_method = "A670B06063C17BED4844A712165B1C95", hash_generated_method = "75E2FDCDC0C3C5518AFB112481F0F635")
        public String getAddress() {
            String address = get("c", '=');
            if(address == null)            
            {
String var540C13E9E156B687226421B24F2DF178_98002812 =                 null;
                var540C13E9E156B687226421B24F2DF178_98002812.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_98002812;
            } //End block
            String[] parts = address.split(" ");
            if(parts.length != 3)            
            {
String var540C13E9E156B687226421B24F2DF178_2089109622 =                 null;
                var540C13E9E156B687226421B24F2DF178_2089109622.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_2089109622;
            } //End block
            int slash = parts[2].indexOf('/');
String var1BF089703585EA2A3F76A548CA952814_507201497 =             (slash < 0) ? parts[2] : parts[2].substring(0, slash);
            var1BF089703585EA2A3F76A548CA952814_507201497.addTaint(taint);
            return var1BF089703585EA2A3F76A548CA952814_507201497;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.387 -0400", hash_original_method = "D0AF733436A7D8101A9CE592CCF78EC4", hash_generated_method = "91840FD50146863D7EDABFFCCDF2F78F")
        public void setAddress(String address) {
            addTaint(address.getTaint());
            if(address != null)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.387 -0400", hash_original_method = "118574D8F2FBBB67C378449350CD8498", hash_generated_method = "F5DB772F783DCB4E53F6A191388F4022")
        public String getEncryptionMethod() {
            String encryption = get("k", '=');
            if(encryption == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1422219870 =                 null;
                var540C13E9E156B687226421B24F2DF178_1422219870.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1422219870;
            } //End block
            int colon = encryption.indexOf(':');
String varEEA69AC7A711FF3D447866E716ED7DAB_241443632 =             (colon == -1) ? encryption : encryption.substring(0, colon);
            varEEA69AC7A711FF3D447866E716ED7DAB_241443632.addTaint(taint);
            return varEEA69AC7A711FF3D447866E716ED7DAB_241443632;
            // ---------- Original Method ----------
            //String encryption = get("k", '=');
            //if (encryption == null) {
                //return null;
            //}
            //int colon = encryption.indexOf(':');
            //return (colon == -1) ? encryption : encryption.substring(0, colon);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.388 -0400", hash_original_method = "E755BA7ABD1182BDF3E20148341D4912", hash_generated_method = "8E08F661501762D7B971F869EF63EA8B")
        public String getEncryptionKey() {
            String encryption = get("k", '=');
            if(encryption == null)            
            {
String var540C13E9E156B687226421B24F2DF178_636280345 =                 null;
                var540C13E9E156B687226421B24F2DF178_636280345.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_636280345;
            } //End block
            int colon = encryption.indexOf(':');
String var7D288BF80A92EAB7CBA6016DDAC46AE7_506900486 =             (colon == -1) ? null : encryption.substring(0, colon + 1);
            var7D288BF80A92EAB7CBA6016DDAC46AE7_506900486.addTaint(taint);
            return var7D288BF80A92EAB7CBA6016DDAC46AE7_506900486;
            // ---------- Original Method ----------
            //String encryption = get("k", '=');
            //if (encryption == null) {
                //return null;
            //}
            //int colon = encryption.indexOf(':');
            //return (colon == -1) ? null : encryption.substring(0, colon + 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.388 -0400", hash_original_method = "D6BD475F892E56E5EB541552A030D2BC", hash_generated_method = "2E428D4D912FA03D98D263F7E3CBD8B1")
        public void setEncryption(String method, String key) {
            addTaint(key.getTaint());
            addTaint(method.getTaint());
            set("k", '=', (method == null || key == null) ?
                    method : method + ':' + key);
            // ---------- Original Method ----------
            //set("k", '=', (method == null || key == null) ?
                    //method : method + ':' + key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.389 -0400", hash_original_method = "647C47031353EA6DBD8C2255C9701417", hash_generated_method = "CACF2D1BD16A71882C16023C97E1AC73")
        public String[] getBandwidthTypes() {
String[] var64D0A7A251C3348E8A84A9C48BE427A9_1823507975 =             cut("b=", ':');
            var64D0A7A251C3348E8A84A9C48BE427A9_1823507975.addTaint(taint);
            return var64D0A7A251C3348E8A84A9C48BE427A9_1823507975;
            // ---------- Original Method ----------
            //return cut("b=", ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.389 -0400", hash_original_method = "AAFC6858B139DD8B4164F3A7991B844E", hash_generated_method = "3B5A9C42E7DBC081643B70D2E09B3A6E")
        public int getBandwidth(String type) {
            addTaint(type.getTaint());
            String value = get("b=" + type, ':');
            if(value != null)            
            {
                try 
                {
                    int var20FFFD77EFBC3C0974E059C438208616_589599355 = (Integer.parseInt(value));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905092791 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905092791;
                } //End block
                catch (NumberFormatException e)
                {
                } //End block
                setBandwidth(type, -1);
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1586184251 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494612432 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494612432;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.390 -0400", hash_original_method = "599740758F5BEDB2EA85017AA799A405", hash_generated_method = "D817999E53C2D79736373561FA4A9479")
        public void setBandwidth(String type, int value) {
            addTaint(value);
            addTaint(type.getTaint());
            set("b=" + type, ':', (value < 0) ? null : String.valueOf(value));
            // ---------- Original Method ----------
            //set("b=" + type, ':', (value < 0) ? null : String.valueOf(value));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.390 -0400", hash_original_method = "7DE1393AC1C7539875AD2D3F3301C0B7", hash_generated_method = "B214959AA66D77C64F7130BE01387E38")
        public String[] getAttributeNames() {
String[] var8115D36206B0C50035E3C513B2BBF372_1823959438 =             cut("a=", ':');
            var8115D36206B0C50035E3C513B2BBF372_1823959438.addTaint(taint);
            return var8115D36206B0C50035E3C513B2BBF372_1823959438;
            // ---------- Original Method ----------
            //return cut("a=", ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.390 -0400", hash_original_method = "1FA4E1C2AB18E99215F11DC02E4EE2C1", hash_generated_method = "E8AACA3EFE501F829DBF32920B4520DE")
        public String getAttribute(String name) {
            addTaint(name.getTaint());
String var849565A12C004DEFBB4396F20634EF28_923074779 =             get("a=" + name, ':');
            var849565A12C004DEFBB4396F20634EF28_923074779.addTaint(taint);
            return var849565A12C004DEFBB4396F20634EF28_923074779;
            // ---------- Original Method ----------
            //return get("a=" + name, ':');
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.391 -0400", hash_original_method = "5FC68CD08D9765AB5882516E9433018C", hash_generated_method = "BB42C60D0EEFE34F44FFF47108E7192E")
        public void setAttribute(String name, String value) {
            addTaint(value.getTaint());
            addTaint(name.getTaint());
            set("a=" + name, ':', value);
            // ---------- Original Method ----------
            //set("a=" + name, ':', value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.391 -0400", hash_original_method = "0B643EB7A40766CD17BE57ED23F6E069", hash_generated_method = "0A18F383C26108864E9BEA9BA2249BF7")
        private void write(StringBuilder buffer) {
            addTaint(buffer.getTaint());
for(int i = 0;i < mOrder.length();++i)
            {
                char type = mOrder.charAt(i);
for(String line : mLines)
                {
                    if(line.charAt(0) == type)                    
                    {
                        buffer.append(line).append("\r\n");
                    } //End block
                } //End block
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.391 -0400", hash_original_method = "1E2B4FDCC5FCB983233F6190F7157F83", hash_generated_method = "C8F5631623FBFD58F8407A4DAF5EE0A5")
        private void parse(String line) {
            addTaint(line.getTaint());
            char type = line.charAt(0);
            if(mOrder.indexOf(type) == -1)            
            {
                return;
            } //End block
            char delimiter = '=';
            if(line.startsWith("a=rtpmap:") || line.startsWith("a=fmtp:"))            
            {
                delimiter = ' ';
            } //End block
            else
            if(type == 'b' || type == 'a')            
            {
                delimiter = ':';
            } //End block
            int i = line.indexOf(delimiter);
            if(i == -1)            
            {
                set(line, delimiter, "");
            } //End block
            else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.392 -0400", hash_original_method = "AC73044C1BE8B35906F49C8C6D477AFE", hash_generated_method = "F0E4B55235BDB628D28713DD071CD07B")
        private String[] cut(String prefix, char delimiter) {
            addTaint(delimiter);
            addTaint(prefix.getTaint());
            String[] names = new String[mLines.size()];
            int length = 0;
for(String line : mLines)
            {
                if(line.startsWith(prefix))                
                {
                    int i = line.indexOf(delimiter);
                    if(i == -1)                    
                    {
                        i = line.length();
                    } //End block
                    names[length] = line.substring(prefix.length(), i);
                    ++length;
                } //End block
            } //End block
String[] varA3D37981F10577BE2FF327E6C05A0DC0_1073925576 =             Arrays.copyOf(names, length);
            varA3D37981F10577BE2FF327E6C05A0DC0_1073925576.addTaint(taint);
            return varA3D37981F10577BE2FF327E6C05A0DC0_1073925576;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.392 -0400", hash_original_method = "6CC88714FB6247DC4BDAFCE2B4177456", hash_generated_method = "7BBDC57A0621D779E187EAC7CBFC7896")
        private int find(String key, char delimiter) {
            addTaint(delimiter);
            addTaint(key.getTaint());
            int length = key.length();
for(int i = mLines.size() - 1;i >= 0;--i)
            {
                String line = mLines.get(i);
                if(line.startsWith(key) && (line.length() == length ||
                        line.charAt(length) == delimiter))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1038097773 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655885703 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655885703;
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_934789259 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413542342 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413542342;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.392 -0400", hash_original_method = "9868AB060D9EE7DD5CB696B838DF99A9", hash_generated_method = "5C485992E5635524461C7D009D0E10A9")
        private void set(String key, char delimiter, String value) {
            addTaint(value.getTaint());
            addTaint(delimiter);
            addTaint(key.getTaint());
            int index = find(key, delimiter);
            if(value != null)            
            {
                if(value.length() != 0)                
                {
                    key = key + delimiter + value;
                } //End block
                if(index == -1)                
                {
                    mLines.add(key);
                } //End block
                else
                {
                    mLines.set(index, key);
                } //End block
            } //End block
            else
            if(index != -1)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.392 -0400", hash_original_method = "820DDC74FB3CD5776CD6646B43FBF51C", hash_generated_method = "395DF297960DE0C57763708E15F5DAAF")
        private String get(String key, char delimiter) {
            addTaint(delimiter);
            addTaint(key.getTaint());
            int index = find(key, delimiter);
            if(index == -1)            
            {
String var540C13E9E156B687226421B24F2DF178_614582002 =                 null;
                var540C13E9E156B687226421B24F2DF178_614582002.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_614582002;
            } //End block
            String line = mLines.get(index);
            int length = key.length();
String var1EFBADABEF0558085A265031BB97433F_2101084746 =             (line.length() == length) ? "" : line.substring(length + 1);
            var1EFBADABEF0558085A265031BB97433F_2101084746.addTaint(taint);
            return var1EFBADABEF0558085A265031BB97433F_2101084746;
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

