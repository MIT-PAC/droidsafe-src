package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class AlertProtocol {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.328 -0500", hash_original_field = "C114C8B6EE3E6323E92E3A30FCD7CECF", hash_generated_field = "54614161E21C0136DB540001945D62B9")

    /**
     * Defines the severity of alert as warning
     */
    protected static final byte WARNING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.331 -0500", hash_original_field = "2EE4182748D3CDA4886A80B2DBDBCDC8", hash_generated_field = "CCEA5AC62091E6116B18F3EA59AE853E")

    protected static final byte FATAL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.333 -0500", hash_original_field = "8F79C253C417EED07FA183665E32AE0C", hash_generated_field = "1B249134FCB5B135AABBD58C25FC388F")

    /**
     * Defines the description code of the close_notify alert
     */
    protected static final byte CLOSE_NOTIFY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.336 -0500", hash_original_field = "BAE35B6843C4B3A93E70E1390D389882", hash_generated_field = "92373E3FE4B88ED6789D47F654449FC3")

    protected static final byte UNEXPECTED_MESSAGE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.338 -0500", hash_original_field = "FB713CFF473A31B077A6EA3E92E6EB3F", hash_generated_field = "8702A0A5CEAE06C380E312A5C79C01C4")

    protected static final byte BAD_RECORD_MAC = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.340 -0500", hash_original_field = "BE506F62E92D9152D16AB37F3B691BCD", hash_generated_field = "65B9EDB1AF576FF07570398647CD2A9E")

    protected static final byte DECRYPTION_FAILED = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.342 -0500", hash_original_field = "7C8AC6FA1901ABA0A51B86410AEC5F9C", hash_generated_field = "9A7641B58F745E8923D0B4233FA92AF1")

    protected static final byte RECORD_OVERFLOW = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.345 -0500", hash_original_field = "7F0338C67243563A094B07FEE6B9993A", hash_generated_field = "092EE3D7EA73AEC1B4700C761C4B0353")

    protected static final byte DECOMPRESSION_FAILURE = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.348 -0500", hash_original_field = "69F0D5673D51F48E8AE83872F1F4AF94", hash_generated_field = "2C628E03556DD2F5D16D91506A726D0C")

    protected static final byte HANDSHAKE_FAILURE = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.351 -0500", hash_original_field = "37324A0A9FFE23739D818D77817B3996", hash_generated_field = "36BCBDFC2068CF580E2412D611602F1F")

    protected static final byte BAD_CERTIFICATE = 42;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.353 -0500", hash_original_field = "FDD183885F88BADBD618696573A5E170", hash_generated_field = "09700AE0664736B5D2BABFEBAC521A94")

    protected static final byte UNSUPPORTED_CERTIFICATE = 43;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.355 -0500", hash_original_field = "4180382095BB74E08F5E1CDE4D51E4EE", hash_generated_field = "E19C5A51459B9774D9F51AF8C4E04E36")

    protected static final byte CERTIFICATE_REVOKED = 44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.358 -0500", hash_original_field = "E39433E16960E71401FE987BF4E97449", hash_generated_field = "704126822B1D40C68AB7E26FF4EAEE14")

    protected static final byte CERTIFICATE_EXPIRED = 45;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.360 -0500", hash_original_field = "6E52E4DDA5163E8A1FDBFF25A9E53A66", hash_generated_field = "0A65A1AA69D5EA0CAC2714E644700970")

    protected static final byte CERTIFICATE_UNKNOWN = 46;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.363 -0500", hash_original_field = "97E5EBD91176A052E9F3E59F0272874C", hash_generated_field = "0D9DAAE25899244AE24E2FDBC5F46F99")

    protected static final byte ILLEGAL_PARAMETER = 47;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.365 -0500", hash_original_field = "EC029688A199D0C128046987A43D93DF", hash_generated_field = "5AE84A65E5F8B680690791B6AB551A34")

    protected static final byte UNKNOWN_CA = 48;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.368 -0500", hash_original_field = "AD55EEA078A55DCFF76D6FE458A4EDCC", hash_generated_field = "2C64F9F1B77B75D7B601E263C9080DD1")

    protected static final byte ACCESS_DENIED = 49;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.370 -0500", hash_original_field = "1BCE709C6D04F83DE120EB111367861B", hash_generated_field = "DA4B5892D3EB01FD2F89AEF938A8B5F2")

    protected static final byte DECODE_ERROR = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.373 -0500", hash_original_field = "204DD2763A73A1D4AB4ADDC4584C2951", hash_generated_field = "80900BCF720CCA813B84F65D17BD2FD0")

    protected static final byte DECRYPT_ERROR = 51;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.375 -0500", hash_original_field = "0F6CD38627E4ECDD5395010BA02DD82F", hash_generated_field = "B38F8CCDFDE852E963780190F8B1E1C5")

    protected static final byte EXPORT_RESTRICTION = 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.378 -0500", hash_original_field = "84788F09DFD7F59B2263952817C1E821", hash_generated_field = "7E09044202CF3235342DA0C5C259D835")

    protected static final byte PROTOCOL_VERSION = 70;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.380 -0500", hash_original_field = "98F9D6E1C215899D1458588F538B9559", hash_generated_field = "78A173AAC24D902C801E280C9759592F")

    protected static final byte INSUFFICIENT_SECURITY = 71;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.382 -0500", hash_original_field = "79120C79AF243B52C8A04DECE65CB284", hash_generated_field = "3F17FA7CA8CD6D0E5BBB1A6F4C9DAAA9")

    protected static final byte INTERNAL_ERROR = 80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.385 -0500", hash_original_field = "2821A2C91008F6E89DAC524077948A7E", hash_generated_field = "7C1FC5845E884F2715B0A31C8DFF4F31")

    protected static final byte USER_CANCELED = 90;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.388 -0500", hash_original_field = "2995738ADC7CB60FAD944164AD9A9DCD", hash_generated_field = "47D9DE2507A92C29BDE55BF608AC91F8")

    protected static final byte NO_RENEGOTIATION = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.390 -0500", hash_original_field = "5F7EFCDE3EED9EF4584272CA6F33AF40", hash_generated_field = "123A71D4C41C48510467491232841B9E")

    private final byte[] alert = new byte[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.392 -0500", hash_original_field = "450F49BACBC7E7E38A182C4284626ACE", hash_generated_field = "C5076A69D1F8496ADA0329E39C7F9A64")

    private SSLRecordProtocol recordProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.395 -0500", hash_original_field = "04CD57BDDB684030B8129F1C565F7967", hash_generated_field = "586593FC273B16FB55D0AB5F86D137A2")

    private Logger.Stream logger = Logger.getStream("alert");

    /**
     * Creates the instance of AlertProtocol.
     * Note that class is not ready to work without providing of
     * record protocol
     * @see #setRecordProtocol
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.397 -0500", hash_original_method = "E092E2209250C02F09C22B7C95E9AB91", hash_generated_method = "A72600933EA880F69BAE3F07B74702DB")
    
protected AlertProtocol() {}

    /**
     * Sets up the record protocol to be used by this allert protocol.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.399 -0500", hash_original_method = "4783F18A2AEFB1BF115D21F8D4F4E6FF", hash_generated_method = "EEFC693BE055C50A31F73AD95BCC5E8B")
    
protected void setRecordProtocol(SSLRecordProtocol recordProtocol) {
        this.recordProtocol = recordProtocol;
    }

    /**
     * Reports an alert to be sent/received by transport.
     * This method is usually called during processing
     * of the income TSL record: if it contains alert message from another
     * peer, or if warning alert occured during the processing of the
     * message and this warning should be sent to another peer.
     * @param   level:  alert level code
     * @param   description: alert description code
     * @return
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.402 -0500", hash_original_method = "F413EBA539C7D7D57656EE1032BAAF7C", hash_generated_method = "086EE2DCEAFC1A5826481261194B1DF7")
    
protected void alert(byte level, byte description) {
        if (logger != null) {
            logger.println("Alert.alert: "+level+" "+description);
        }
        this.alert[0] = level;
        this.alert[1] = description;
    }

    /**
     * Returns the description code of alert or -100 if there
     * is no alert.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.404 -0500", hash_original_method = "5D3BF0EC0666EBF860C9DC61576F480B", hash_generated_method = "7A8EE9706552E0ED056BC1BB7074D029")
    
protected byte getDescriptionCode() {
        return (alert[0] != 0) ? alert[1] : -100;
    }

    /**
     * Resets the protocol to be in "no alert" state.
     * This method shoud be called after processing of the reported alert.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.407 -0500", hash_original_method = "87AB9C19E1A7EED4E3BFCF946809E0DA", hash_generated_method = "90D7B27A50AB1CEE9F51C49991DF097F")
    
protected void setProcessed() {
        // free the info about alert
        if (logger != null) {
            logger.println("Alert.setProcessed");
        }
        this.alert[0] = 0;
    }

    /**
     * Checks if any alert has occured.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.409 -0500", hash_original_method = "45A2D96003EBC85CF21133EEF592859F", hash_generated_method = "4248ED5861E04328D96C1D2507E64617")
    
protected boolean hasAlert() {
        return (alert[0] != 0);
    }

    /**
     * Checks if occured alert is fatal alert.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.411 -0500", hash_original_method = "7F9DD2505076B3CAC6687DC8D86BE7DC", hash_generated_method = "540A811DA2E9D75A3921F5A4DB794384")
    
protected boolean isFatalAlert() {
        return (alert[0] == 2);
    }

    /**
     * Returns the string representation of occured alert.
     * If no alert has occured null is returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.414 -0500", hash_original_method = "4ED335C5479EFEAB65BE48D985C7B953", hash_generated_method = "BC1AF47FCFB0A90853760EB213117316")
    
protected String getAlertDescription() {
        switch (alert[1]) {
        case CLOSE_NOTIFY:
            return "close_notify";
        case UNEXPECTED_MESSAGE:
            return "unexpected_message";
        case BAD_RECORD_MAC:
            return "bad_record_mac";
        case DECRYPTION_FAILED:
            return "decryption_failed";
        case RECORD_OVERFLOW:
            return "record_overflow";
        case DECOMPRESSION_FAILURE:
            return "decompression_failure";
        case HANDSHAKE_FAILURE:
            return "handshake_failure";
        case BAD_CERTIFICATE:
            return "bad_certificate";
        case UNSUPPORTED_CERTIFICATE:
            return "unsupported_certificate";
        case CERTIFICATE_REVOKED:
            return "certificate_revoked";
        case CERTIFICATE_EXPIRED:
            return "certificate_expired";
        case CERTIFICATE_UNKNOWN:
            return "certificate_unknown";
        case ILLEGAL_PARAMETER:
            return "illegal_parameter";
        case UNKNOWN_CA:
            return "unknown_ca";
        case ACCESS_DENIED:
            return "access_denied";
        case DECODE_ERROR:
            return "decode_error";
        case DECRYPT_ERROR:
            return "decrypt_error";
        case EXPORT_RESTRICTION:
            return "export_restriction";
        case PROTOCOL_VERSION:
            return "protocol_version";
        case INSUFFICIENT_SECURITY:
            return "insufficient_security";
        case INTERNAL_ERROR:
            return "internal_error";
        case USER_CANCELED:
            return "user_canceled";
        case NO_RENEGOTIATION:
            return "no_renegotiation";
        }
        return null;
    }

    /**
     * Returns the record with reported alert message.
     * The returned array of bytes is ready to be sent to another peer.
     * Note, that this method does not automatically set the state of alert
     * protocol in "no alert" state, so after wrapping the method setProcessed
     * should be called.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.416 -0500", hash_original_method = "124BFC00035B67AF657D6336BEA07CC5", hash_generated_method = "2823AFE6AA2CFFB4F440BE1D573A853D")
    
protected byte[] wrap() {
        byte[] res = recordProtocol.wrap(ContentType.ALERT, alert, 0, 2);
        return res;
    }

    /**
     * Shutdown the protocol. It will be impossible to use the instance
     * after the calling of this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.418 -0500", hash_original_method = "18F927F44CECC98A241CC5D3FE86DBCB", hash_generated_method = "491F9C3BA65461F7B2C006E8F1F82AB8")
    
protected void shutdown() {
        alert[0] = 0;
        alert[1] = 0;
        recordProtocol = null;
    }
}

