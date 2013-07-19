package gov.nist.javax.sip.header;

// Droidsafe Imports
import java.text.ParseException;

import javax.sip.header.ContentTypeHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ContentType extends ParametersHeader implements javax.sip.header.ContentTypeHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.304 -0400", hash_original_field = "658105D0D44EEADF22FE9B4C6C740531", hash_generated_field = "FE54B36640417CD311E956ED780B7202")

    protected MediaRange mediaRange;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.304 -0400", hash_original_method = "DFB0ACA07F1EF34999053FFFBC3153AF", hash_generated_method = "D69CDBB6EDF548FF307DB3C54F1E561D")
    public  ContentType() {
        super(CONTENT_TYPE);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.304 -0400", hash_original_method = "97EC00F8B2220E42E6B0126E7CC0F3E7", hash_generated_method = "A4E9557449833D9EC257340C027A3E09")
    public  ContentType(String contentType, String contentSubtype) {
        this();
        addTaint(contentSubtype.getTaint());
        addTaint(contentType.getTaint());
        this.setContentType(contentType, contentSubtype);
        // ---------- Original Method ----------
        //this.setContentType(contentType, contentSubtype);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.304 -0400", hash_original_method = "2022581A914A53DEAB486C7C21721639", hash_generated_method = "17C71CC29E3EF70813A84AD53C2DB658")
    public int compareMediaRange(String media) {
        addTaint(media.getTaint());
        int varDD9373BD6A1904956970CC30E5CBF481_1521766866 = ((
            mediaRange.type + "/" + mediaRange.subtype).compareToIgnoreCase(
            media));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272534584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272534584;
        // ---------- Original Method ----------
        //return (
            //mediaRange.type + "/" + mediaRange.subtype).compareToIgnoreCase(
            //media);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.305 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "A0D4667879F70F78EF1105E0A83EB723")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_777778963 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_777778963.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_777778963;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.305 -0400", hash_original_method = "2667754E6FC706178FFA281551626F8E", hash_generated_method = "49492F65B8C33616B5FD7F79B387814B")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        mediaRange.encode(buffer);
        if(hasParameters())        
        {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1747163563 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1747163563.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1747163563;
        // ---------- Original Method ----------
        //mediaRange.encode(buffer);
        //if (hasParameters()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.305 -0400", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "A4CD130B1AFB41430071EE770990E746")
    public MediaRange getMediaRange() {
MediaRange varF0641D8BD2A6E7A6B70BF4AB4A7ED980_494816693 =         mediaRange;
        varF0641D8BD2A6E7A6B70BF4AB4A7ED980_494816693.addTaint(taint);
        return varF0641D8BD2A6E7A6B70BF4AB4A7ED980_494816693;
        // ---------- Original Method ----------
        //return mediaRange;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.305 -0400", hash_original_method = "71A8EC95A25C2B8732F46A6E9FE1A552", hash_generated_method = "C01857EDEB873275F1D9618EE22F40DD")
    public String getMediaType() {
String var546D37A8A73F736C9BCD7D254DD561E1_1417958575 =         mediaRange.type;
        var546D37A8A73F736C9BCD7D254DD561E1_1417958575.addTaint(taint);
        return var546D37A8A73F736C9BCD7D254DD561E1_1417958575;
        // ---------- Original Method ----------
        //return mediaRange.type;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.306 -0400", hash_original_method = "EEE1854610A538C776591DF3242D2F30", hash_generated_method = "3D5FF5A3D2874DE96C03DC62422D5BC6")
    public String getMediaSubType() {
String var14276D2031A32DFF0C5BFDF68849D64F_308002537 =         mediaRange.subtype;
        var14276D2031A32DFF0C5BFDF68849D64F_308002537.addTaint(taint);
        return var14276D2031A32DFF0C5BFDF68849D64F_308002537;
        // ---------- Original Method ----------
        //return mediaRange.subtype;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.306 -0400", hash_original_method = "8BA245F79ADA117CDC825C68939B2C5E", hash_generated_method = "25A0D8C1F20F763277EC0D842AED9104")
    public String getContentSubType() {
String var7952D5764267666C01E4604419DC946B_509042110 =         mediaRange == null ? null : mediaRange.getSubtype();
        var7952D5764267666C01E4604419DC946B_509042110.addTaint(taint);
        return var7952D5764267666C01E4604419DC946B_509042110;
        // ---------- Original Method ----------
        //return mediaRange == null ? null : mediaRange.getSubtype();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.306 -0400", hash_original_method = "13593DF0637733E8B4FF50555F8020B8", hash_generated_method = "5D77482F4BB5611DD7BE47FC8B07F20C")
    public String getContentType() {
String varA053C7852ED52ACADA9D62FC7E03186D_380763500 =         mediaRange == null ? null : mediaRange.getType();
        varA053C7852ED52ACADA9D62FC7E03186D_380763500.addTaint(taint);
        return varA053C7852ED52ACADA9D62FC7E03186D_380763500;
        // ---------- Original Method ----------
        //return mediaRange == null ? null : mediaRange.getType();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.306 -0400", hash_original_method = "706F14B8E3FC5B0A8E41E785E1C48F47", hash_generated_method = "0AE87FA757EFD1628EDEAAE6E78DFB52")
    public String getCharset() {
String var10B3BF1D2BF86527A37CD1FB4315E406_1531986990 =         this.getParameter("charset");
        var10B3BF1D2BF86527A37CD1FB4315E406_1531986990.addTaint(taint);
        return var10B3BF1D2BF86527A37CD1FB4315E406_1531986990;
        // ---------- Original Method ----------
        //return this.getParameter("charset");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.307 -0400", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "D4B8159947A4E1D723FD3764612CBB21")
    public void setMediaRange(MediaRange m) {
        mediaRange = m;
        // ---------- Original Method ----------
        //mediaRange = m;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.307 -0400", hash_original_method = "255C5DEA7C1BA0115D227FF364F117E1", hash_generated_method = "EF7AE3E8041080E8F42EE9E4D8FF33B5")
    public void setContentType(String contentType, String contentSubType) {
        addTaint(contentSubType.getTaint());
        addTaint(contentType.getTaint());
        if(mediaRange == null)        
        mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        mediaRange.setSubtype(contentSubType);
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(contentType);
        //mediaRange.setSubtype(contentSubType);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.307 -0400", hash_original_method = "D590DDC03635869B8BF7D8A74B8AFC87", hash_generated_method = "2706CA5C5121FCDD79FCC1444B7A1E65")
    public void setContentType(String contentType) throws ParseException {
        addTaint(contentType.getTaint());
        if(contentType == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1890752437 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1890752437.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1890752437;
        }
        if(mediaRange == null)        
        mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        // ---------- Original Method ----------
        //if (contentType == null)
            //throw new NullPointerException("null arg");
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(contentType);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.308 -0400", hash_original_method = "0B1F5B2677CEADEDD2A1902A7B2F0CE3", hash_generated_method = "34C9B932B158F079DEB6417223F69F1C")
    public void setContentSubType(String contentType) throws ParseException {
        addTaint(contentType.getTaint());
        if(contentType == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_289349942 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_289349942.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_289349942;
        }
        if(mediaRange == null)        
        mediaRange = new MediaRange();
        mediaRange.setSubtype(contentType);
        // ---------- Original Method ----------
        //if (contentType == null)
            //throw new NullPointerException("null arg");
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setSubtype(contentType);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.308 -0400", hash_original_method = "EAF7A0BAA68C7F455EB82B27B83B3C3F", hash_generated_method = "306B4F756FB20F9CF6A3F5E0AA8CF281")
    public Object clone() {
        ContentType retval = (ContentType) super.clone();
        if(this.mediaRange != null)        
        retval.mediaRange = (MediaRange) this.mediaRange.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1304040741 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1304040741.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1304040741;
        // ---------- Original Method ----------
        //ContentType retval = (ContentType) super.clone();
        //if (this.mediaRange != null)
            //retval.mediaRange = (MediaRange) this.mediaRange.clone();
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.309 -0400", hash_original_method = "34166B5115AC7B46D5451CCD077A72C8", hash_generated_method = "2DB10F360EF573F3FF1B40A800C6350E")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other instanceof ContentTypeHeader)        
        {
            final ContentTypeHeader o = (ContentTypeHeader) other;
            boolean varCAE68774E697304B563177C84D850AF2_405710622 = (this.getContentType().equalsIgnoreCase( o.getContentType() )
                && this.getContentSubType().equalsIgnoreCase( o.getContentSubType() )
                && equalParameters( o ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647581646 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647581646;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_666782554 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1449285029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1449285029;
        // ---------- Original Method ----------
        //if (other instanceof ContentTypeHeader) {
            //final ContentTypeHeader o = (ContentTypeHeader) other;
            //return this.getContentType().equalsIgnoreCase( o.getContentType() )
                //&& this.getContentSubType().equalsIgnoreCase( o.getContentSubType() )
                //&& equalParameters( o );
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.309 -0400", hash_original_field = "7EC829A2BDD9F0C20CFC8BC464500A23", hash_generated_field = "F8C109B71FF1A33F443977543E5F5F99")

    private static final long serialVersionUID = 8475682204373446610L;
}

