package javax.sip.header;

// Droidsafe Imports

public interface ReplyToHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Reply-To";

    String getDisplayName();
}
