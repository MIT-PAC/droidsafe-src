package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleSessionDescription {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.938 -0500", hash_original_field = "4440D95739751EDD25D246C30AC15CB0", hash_generated_field = "7FC97BC1C457A3C7034DB3B8BF10C7C3")

    private final Fields mFields = new Fields("voscbtka");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.941 -0500", hash_original_field = "C605AAAB5077AC0839B82D5B5DFC7EE1", hash_generated_field = "25083CE234B196AB0C0988179FBD23E1")

    private final ArrayList<Media> mMedia = new ArrayList<Media>();

    /**
     * Creates a minimal session description from the given session ID and
     * unicast address. The address is used in the origin field ("o=") and the
     * connection field ("c="). See {@link SimpleSessionDescription} for an
     * example of its usage.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.944 -0500", hash_original_method = "2A5A308C97610724520D8E7C21BD0897", hash_generated_method = "998E418FB9083C7D8041788EF07796EC")
    
public SimpleSessionDescription(long sessionId, String address) {
        address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") + address;
        mFields.parse("v=0");
        mFields.parse(String.format("o=- %d %d %s", sessionId,
                System.currentTimeMillis(), address));
        mFields.parse("s=-");
        mFields.parse("t=0 0");
        mFields.parse("c=" + address);
    }

    /**
     * Creates a session description from the given message.
     *
     * @throws IllegalArgumentException if message is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.948 -0500", hash_original_method = "55B596B0C996801BF0FD9956A535E1C7", hash_generated_method = "1CE8E8BF6FF20203CD69EBA8E105DEF8")
    
public SimpleSessionDescription(String message) {
        String[] lines = message.trim().replaceAll(" +", " ").split("[\r\n]+");
        Fields fields = mFields;

        for (String line : lines) {
            try {
                if (line.charAt(1) != '=') {
                    throw new IllegalArgumentException();
                }
                if (line.charAt(0) == 'm') {
                    String[] parts = line.substring(2).split(" ", 4);
                    String[] ports = parts[1].split("/", 2);
                    Media media = newMedia(parts[0], Integer.parseInt(ports[0]),
                            (ports.length < 2) ? 1 : Integer.parseInt(ports[1]),
                            parts[2]);
                    for (String format : parts[3].split(" ")) {
                        media.setFormat(format, null);
                    }
                    fields = media;
                } else {
                    fields.parse(line);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid SDP: " + line);
            }
        }
    }

    /**
     * Creates a new media description in this session description.
     *
     * @param type The media type, e.g. {@code "audio"}.
     * @param port The first transport port used by this media.
     * @param portCount The number of contiguous ports used by this media.
     * @param protocol The transport protocol, e.g. {@code "RTP/AVP"}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.950 -0500", hash_original_method = "EA659D41568208E07CC0B460E13AE27A", hash_generated_method = "B41A9B2B9E2A47ECAECB03E449C85FA4")
    
public Media newMedia(String type, int port, int portCount,
            String protocol) {
        Media media = new Media(type, port, portCount, protocol);
        mMedia.add(media);
        return media;
    }

    /**
     * Returns all the media descriptions in this session description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.952 -0500", hash_original_method = "B85596442E6A0B0D5C28199B22779A84", hash_generated_method = "FEB00FDA187077CB475FE1C40CF6285C")
    
public Media[] getMedia() {
        return mMedia.toArray(new Media[mMedia.size()]);
    }

    /**
     * Encodes the session description and all its media descriptions in a
     * string. Note that the result might be incomplete if a required field
     * has never been added before.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.954 -0500", hash_original_method = "5F8774B802EBD1C84B8B67985F8F69FE", hash_generated_method = "405BDD8BFD91234FD09CF1AC522A702C")
    
public String encode() {
        StringBuilder buffer = new StringBuilder();
        mFields.write(buffer);
        for (Media media : mMedia) {
            media.write(buffer);
        }
        return buffer.toString();
    }

    /**
     * Returns the connection address or {@code null} if it is not present.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.956 -0500", hash_original_method = "F8D52A976FE0230A990054D249BBC343", hash_generated_method = "F315648F4C69D68AB63A2749CE5BBC89")
    
public String getAddress() {
        return mFields.getAddress();
    }

    /**
     * Sets the connection address. The field will be removed if the address
     * is {@code null}.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.958 -0500", hash_original_method = "9CF6A3FFF46CFF8C635A973470CB60F8", hash_generated_method = "74E5A0ADBEF08527D130C2087D1D39B3")
    
public void setAddress(String address) {
        mFields.setAddress(address);
    }

    /**
     * Returns the encryption method or {@code null} if it is not present.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.960 -0500", hash_original_method = "CF383146C8D4D1A90CD3326AD48DF581", hash_generated_method = "EEF3F807CEB01380D0F182405A4320C3")
    
public String getEncryptionMethod() {
        return mFields.getEncryptionMethod();
    }

    /**
     * Returns the encryption key or {@code null} if it is not present.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.963 -0500", hash_original_method = "A3819CF07A96AB27E331482FA08A72EC", hash_generated_method = "D2AB22343939E7DC8D2B86FA335A477E")
    
public String getEncryptionKey() {
        return mFields.getEncryptionKey();
    }

    /**
     * Sets the encryption method and the encryption key. The field will be
     * removed if the method is {@code null}.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.965 -0500", hash_original_method = "A82F97B5F7341431789E84B509C9D803", hash_generated_method = "25615D392B46A6486F8E55A7D36EECD3")
    
public void setEncryption(String method, String key) {
        mFields.setEncryption(method, key);
    }

    /**
     * Returns the types of the bandwidth limits.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.967 -0500", hash_original_method = "E6DC230D0F77B46CC062C029BF806CE1", hash_generated_method = "7A5E45FDCC18C123D925485B62B59D05")
    
public String[] getBandwidthTypes() {
        return mFields.getBandwidthTypes();
    }

    /**
     * Returns the bandwidth limit of the given type or {@code -1} if it is not
     * present.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.969 -0500", hash_original_method = "F5B1268DC2500E20A835AD2EE3964BC1", hash_generated_method = "712AD4B1F0B45ADB77178AA7D5E5D7B4")
    
public int getBandwidth(String type) {
        return mFields.getBandwidth(type);
    }

    /**
     * Sets the bandwith limit for the given type. The field will be removed if
     * the value is negative.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.972 -0500", hash_original_method = "8E0EC67E7D91F3DDCC83F18482476DA9", hash_generated_method = "24533E4C28D472361CC997316A9ABDB4")
    
public void setBandwidth(String type, int value) {
        mFields.setBandwidth(type, value);
    }

    /**
     * Returns the names of all the attributes.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.974 -0500", hash_original_method = "5B56D37EB252892A4BEDE959A6610969", hash_generated_method = "673DE0352DA1B3A408901B0099AA51A8")
    
public String[] getAttributeNames() {
        return mFields.getAttributeNames();
    }

    /**
     * Returns the attribute of the given name or {@code null} if it is not
     * present.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.976 -0500", hash_original_method = "8C22B12F041FCBB6C901893035A47DF3", hash_generated_method = "32BF7C886E0BF19D980EA308EC90D456")
    
public String getAttribute(String name) {
        return mFields.getAttribute(name);
    }

    /**
     * Sets the attribute for the given name. The field will be removed if
     * the value is {@code null}. To set a binary attribute, use an empty
     * string as the value.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.978 -0500", hash_original_method = "A5005CAFDCC1F5EB8A695D7ADEDCA043", hash_generated_method = "1953AC249CD749988AD3AFECBF386CA1")
    
public void setAttribute(String name, String value) {
        mFields.setAttribute(name, value);
    }
    
    public static class Media extends Fields {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.980 -0500", hash_original_field = "1672B69A08B1383BA3D3C191D3C06566", hash_generated_field = "DA7F98239A4F122D17620AC61DF29F55")

        private  String mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.983 -0500", hash_original_field = "AAAF8A3C293EA5711E38C28140852BDE", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

        private  int mPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.985 -0500", hash_original_field = "F0B131BF490FC97E322D23D02456C166", hash_generated_field = "664DEF09AA11EB91ABE05F4C73593C8F")

        private  int mPortCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.988 -0500", hash_original_field = "D749B5A42DD4805DD6802899337E94EB", hash_generated_field = "9531EB6C865FAC78E4991C4D266091F2")

        private  String mProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.990 -0500", hash_original_field = "14E98F5AD7F926086F859E8DCDED5976", hash_generated_field = "D1D6A77EEC6AF4F5D93F127A32909A95")

        private ArrayList<String> mFormats = new ArrayList<String>();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.993 -0500", hash_original_method = "02F078FAC4A0FFA7B56C26518CB9B9A1", hash_generated_method = "2DA64E39C246FA1CB1FD7779973AAE12")
        
private Media(String type, int port, int portCount, String protocol) {
            super("icbka");
            mType = type;
            mPort = port;
            mPortCount = portCount;
            mProtocol = protocol;
        }

        /**
         * Returns the media type.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.995 -0500", hash_original_method = "F57356AE1A37FC524BD36BB2BA67325B", hash_generated_method = "FD34A57B2342B04CD78207BBDCFD6F8F")
        
public String getType() {
            return mType;
        }

        /**
         * Returns the first transport port used by this media.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.997 -0500", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "33B8E8C1C43AC396F100852932189626")
        
public int getPort() {
            return mPort;
        }

        /**
         * Returns the number of contiguous ports used by this media.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.999 -0500", hash_original_method = "7A9595EE55A65FB3ADE35A1A62D4E357", hash_generated_method = "FB76D5862131E1AD32CCBD35B2D50263")
        
public int getPortCount() {
            return mPortCount;
        }

        /**
         * Returns the transport protocol.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.001 -0500", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "8F1EAEC8EB0D8F93DE7E24D552C33424")
        
public String getProtocol() {
            return mProtocol;
        }

        /**
         * Returns the media formats.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.004 -0500", hash_original_method = "FE32CC25BB54D83998E2230125207ED2", hash_generated_method = "7B3645E2B5DAA41B1816CFB6FBE98C82")
        
public String[] getFormats() {
            return mFormats.toArray(new String[mFormats.size()]);
        }

        /**
         * Returns the {@code fmtp} attribute of the given format or
         * {@code null} if it is not present.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.006 -0500", hash_original_method = "FA4CAF6A8A475DAE2E8CED4184402CED", hash_generated_method = "5B2C3351F4D1F4DAA3F8615708A69A67")
        
public String getFmtp(String format) {
            return super.get("a=fmtp:" + format, ' ');
        }

        /**
         * Sets a format and its {@code fmtp} attribute. If the attribute is
         * {@code null}, the corresponding field will be removed.
         */
        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.008 -0500", hash_original_method = "C64230710F5A14357C2D213EB5CAD075", hash_generated_method = "6CAEE65EBEBE59F4BDF119EEAD2724CB")
        
public void setFormat(String format, String fmtp) {
            mFormats.remove(format);
            mFormats.add(format);
            super.set("a=rtpmap:" + format, ' ', null);
            super.set("a=fmtp:" + format, ' ', fmtp);
        }

        /**
         * Removes a format and its {@code fmtp} attribute.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.011 -0500", hash_original_method = "9754946CE829C7317659B7AE5D5C7570", hash_generated_method = "EC3EFE17A6284B9690599685BDE15798")
        
public void removeFormat(String format) {
            mFormats.remove(format);
            super.set("a=rtpmap:" + format, ' ', null);
            super.set("a=fmtp:" + format, ' ', null);
        }

        /**
         * Returns the RTP payload types.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.014 -0500", hash_original_method = "9C0F6B568B86FD34F835983651B5C872", hash_generated_method = "0A879E5C074561F59D602525C21C7BC9")
        
public int[] getRtpPayloadTypes() {
            int[] types = new int[mFormats.size()];
            int length = 0;
            for (String format : mFormats) {
                try {
                    types[length] = Integer.parseInt(format);
                    ++length;
                } catch (NumberFormatException e) { }
            }
            return Arrays.copyOf(types, length);
        }

        /**
         * Returns the {@code rtpmap} attribute of the given RTP payload type
         * or {@code null} if it is not present.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.016 -0500", hash_original_method = "24059B72158848D6AA4D09BBC6EA89FF", hash_generated_method = "94037B0A36157542D59BED090D4847D2")
        
public String getRtpmap(int type) {
            return super.get("a=rtpmap:" + type, ' ');
        }

        /**
         * Returns the {@code fmtp} attribute of the given RTP payload type or
         * {@code null} if it is not present.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.018 -0500", hash_original_method = "B26584A4E479E1852859F85D5F0DF9AE", hash_generated_method = "6C40BBED03CF12CBE8F70A2EEA007932")
        
public String getFmtp(int type) {
            return super.get("a=fmtp:" + type, ' ');
        }

        /**
         * Sets a RTP payload type and its {@code rtpmap} and {@code fmtp}
         * attributes. If any of the attributes is {@code null}, the
         * corresponding field will be removed. See
         * {@link SimpleSessionDescription} for an example of its usage.
         */
        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.020 -0500", hash_original_method = "F9FA54C35728FF67E338ECA5310C56AD", hash_generated_method = "550E78B89EA2CB8E165AFC0C0D308401")
        
public void setRtpPayload(int type, String rtpmap, String fmtp) {
            String format = String.valueOf(type);
            mFormats.remove(format);
            mFormats.add(format);
            super.set("a=rtpmap:" + format, ' ', rtpmap);
            super.set("a=fmtp:" + format, ' ', fmtp);
        }

        /**
         * Removes a RTP payload and its {@code rtpmap} and {@code fmtp}
         * attributes.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.022 -0500", hash_original_method = "DA7390F19D86262D8A26D94062855C18", hash_generated_method = "00E7C9A70532BEBE8B4BCFFD0F915541")
        
public void removeRtpPayload(int type) {
            removeFormat(String.valueOf(type));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.025 -0500", hash_original_method = "9628E0029B5D265C0B7D76261776561B", hash_generated_method = "6FF203714E036AEAD8436A74AB5168BE")
        
private void write(StringBuilder buffer) {
            buffer.append("m=").append(mType).append(' ').append(mPort);
            if (mPortCount != 1) {
                buffer.append('/').append(mPortCount);
            }
            buffer.append(' ').append(mProtocol);
            for (String format : mFormats) {
                buffer.append(' ').append(format);
            }
            buffer.append("\r\n");
            super.write(buffer);
        }
        
    }
    
    private static class Fields {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.030 -0500", hash_original_field = "ADD241968D5EB723468DE66E1ADFBAA8", hash_generated_field = "FE61FA4626921CBB643E7F37A28C123F")

        private  String mOrder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.033 -0500", hash_original_field = "5084E55066A2C960592238F3B96794F3", hash_generated_field = "8C292B28C2E778857703C352578975B3")

        private final ArrayList<String> mLines = new ArrayList<String>();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.035 -0500", hash_original_method = "961F9332E222C9766CB023FF8444B0B1", hash_generated_method = "961F9332E222C9766CB023FF8444B0B1")
        
Fields(String order) {
            mOrder = order;
        }

        /**
         * Returns the connection address or {@code null} if it is not present.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.038 -0500", hash_original_method = "A670B06063C17BED4844A712165B1C95", hash_generated_method = "94D77C6A217F62D8053033D830F0C83A")
        
public String getAddress() {
            String address = get("c", '=');
            if (address == null) {
                return null;
            }
            String[] parts = address.split(" ");
            if (parts.length != 3) {
                return null;
            }
            int slash = parts[2].indexOf('/');
            return (slash < 0) ? parts[2] : parts[2].substring(0, slash);
        }

        /**
         * Sets the connection address. The field will be removed if the address
         * is {@code null}.
         */
        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.041 -0500", hash_original_method = "D0AF733436A7D8101A9CE592CCF78EC4", hash_generated_method = "DFA609F667A9EC9785113020DC447CFD")
        
public void setAddress(String address) {
            if (address != null) {
                address = (address.indexOf(':') < 0 ? "IN IP4 " : "IN IP6 ") +
                        address;
            }
            set("c", '=', address);
        }

        /**
         * Returns the encryption method or {@code null} if it is not present.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.043 -0500", hash_original_method = "118574D8F2FBBB67C378449350CD8498", hash_generated_method = "DE0ED01E9E38A3327F088703B32BE426")
        
public String getEncryptionMethod() {
            String encryption = get("k", '=');
            if (encryption == null) {
                return null;
            }
            int colon = encryption.indexOf(':');
            return (colon == -1) ? encryption : encryption.substring(0, colon);
        }

        /**
         * Returns the encryption key or {@code null} if it is not present.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.045 -0500", hash_original_method = "E755BA7ABD1182BDF3E20148341D4912", hash_generated_method = "908092B527C3B806B9938452D8B605D8")
        
public String getEncryptionKey() {
            String encryption = get("k", '=');
            if (encryption == null) {
                return null;
            }
            int colon = encryption.indexOf(':');
            return (colon == -1) ? null : encryption.substring(0, colon + 1);
        }

        /**
         * Sets the encryption method and the encryption key. The field will be
         * removed if the method is {@code null}.
         */
        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.048 -0500", hash_original_method = "D6BD475F892E56E5EB541552A030D2BC", hash_generated_method = "855310653C3B1B4E6FB87D2C83A759F0")
        
public void setEncryption(String method, String key) {
            set("k", '=', (method == null || key == null) ?
                    method : method + ':' + key);
        }

        /**
         * Returns the types of the bandwidth limits.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.050 -0500", hash_original_method = "647C47031353EA6DBD8C2255C9701417", hash_generated_method = "C1DFBB364AAF10D22C8C86288F061A99")
        
public String[] getBandwidthTypes() {
            return cut("b=", ':');
        }

        /**
         * Returns the bandwidth limit of the given type or {@code -1} if it is
         * not present.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.052 -0500", hash_original_method = "AAFC6858B139DD8B4164F3A7991B844E", hash_generated_method = "D251218E5CC5445A0CA9174D92A26B66")
        
public int getBandwidth(String type) {
            String value = get("b=" + type, ':');
            if (value != null) {
                try {
                    return Integer.parseInt(value);
                } catch (NumberFormatException e) { }
                setBandwidth(type, -1);
            }
            return -1;
        }

        /**
         * Sets the bandwith limit for the given type. The field will be removed
         * if the value is negative.
         */
        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.055 -0500", hash_original_method = "599740758F5BEDB2EA85017AA799A405", hash_generated_method = "B1FB588F54965EE9EDEC84AD4CEA1F0E")
        
public void setBandwidth(String type, int value) {
            set("b=" + type, ':', (value < 0) ? null : String.valueOf(value));
        }

        /**
         * Returns the names of all the attributes.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.057 -0500", hash_original_method = "7DE1393AC1C7539875AD2D3F3301C0B7", hash_generated_method = "CB7BC7EA51D54FD9B0BD5E6A0110563A")
        
public String[] getAttributeNames() {
            return cut("a=", ':');
        }

        /**
         * Returns the attribute of the given name or {@code null} if it is not
         * present.
         */
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.059 -0500", hash_original_method = "1FA4E1C2AB18E99215F11DC02E4EE2C1", hash_generated_method = "689EB4C6EA1C1106618F1C166A9AA307")
        
public String getAttribute(String name) {
            return get("a=" + name, ':');
        }

        /**
         * Sets the attribute for the given name. The field will be removed if
         * the value is {@code null}. To set a binary attribute, use an empty
         * string as the value.
         */
        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.062 -0500", hash_original_method = "5FC68CD08D9765AB5882516E9433018C", hash_generated_method = "5C2D003AE097463375E355C4C12FE583")
        
public void setAttribute(String name, String value) {
            set("a=" + name, ':', value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.064 -0500", hash_original_method = "0B643EB7A40766CD17BE57ED23F6E069", hash_generated_method = "B863096EDA63A2CB1C8E8E939E025B30")
        
private void write(StringBuilder buffer) {
            for (int i = 0; i < mOrder.length(); ++i) {
                char type = mOrder.charAt(i);
                for (String line : mLines) {
                    if (line.charAt(0) == type) {
                        buffer.append(line).append("\r\n");
                    }
                }
            }
        }

        /**
         * Invokes {@link #set} after splitting the line into three parts.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.066 -0500", hash_original_method = "1E2B4FDCC5FCB983233F6190F7157F83", hash_generated_method = "D840C97F644B017E3651A356EE52115B")
        
private void parse(String line) {
            char type = line.charAt(0);
            if (mOrder.indexOf(type) == -1) {
                return;
            }
            char delimiter = '=';
            if (line.startsWith("a=rtpmap:") || line.startsWith("a=fmtp:")) {
                delimiter = ' ';
            } else if (type == 'b' || type == 'a') {
                delimiter = ':';
            }
            int i = line.indexOf(delimiter);
            if (i == -1) {
                set(line, delimiter, "");
            } else {
                set(line.substring(0, i), delimiter, line.substring(i + 1));
            }
        }

        /**
         * Finds the key with the given prefix and returns its suffix.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.068 -0500", hash_original_method = "AC73044C1BE8B35906F49C8C6D477AFE", hash_generated_method = "B64DAC5DC579F956866B0E3AFF4E496F")
        
private String[] cut(String prefix, char delimiter) {
            String[] names = new String[mLines.size()];
            int length = 0;
            for (String line : mLines) {
                if (line.startsWith(prefix)) {
                    int i = line.indexOf(delimiter);
                    if (i == -1) {
                        i = line.length();
                    }
                    names[length] = line.substring(prefix.length(), i);
                    ++length;
                }
            }
            return Arrays.copyOf(names, length);
        }

        /**
         * Returns the index of the key.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.071 -0500", hash_original_method = "6CC88714FB6247DC4BDAFCE2B4177456", hash_generated_method = "41FAEBAC9C7E267B54234DF09F294B37")
        
private int find(String key, char delimiter) {
            int length = key.length();
            for (int i = mLines.size() - 1; i >= 0; --i) {
                String line = mLines.get(i);
                if (line.startsWith(key) && (line.length() == length ||
                        line.charAt(length) == delimiter)) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * Sets the key with the value or removes the key if the value is
         * {@code null}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.073 -0500", hash_original_method = "9868AB060D9EE7DD5CB696B838DF99A9", hash_generated_method = "94F6D8DA96609EB5291E15164A9EE33D")
        
private void set(String key, char delimiter, String value) {
            int index = find(key, delimiter);
            if (value != null) {
                if (value.length() != 0) {
                    key = key + delimiter + value;
                }
                if (index == -1) {
                    mLines.add(key);
                } else {
                    mLines.set(index, key);
                }
            } else if (index != -1) {
                mLines.remove(index);
            }
        }

        /**
         * Returns the value of the key.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:26.076 -0500", hash_original_method = "820DDC74FB3CD5776CD6646B43FBF51C", hash_generated_method = "3A7F7BB7C83ACE4EA83E12008CF58EA0")
        
private String get(String key, char delimiter) {
            int index = find(key, delimiter);
            if (index == -1) {
                return null;
            }
            String line = mLines.get(index);
            int length = key.length();
            return (line.length() == length) ? "" : line.substring(length + 1);
        }
        
    }
    
}

