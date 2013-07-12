package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.GenericObject;
import gov.nist.core.Separators;
import gov.nist.javax.sip.header.ims.PrivacyHeader;
import javax.sip.header.Header;
import java.lang.reflect.Constructor;
import java.util.*;

public abstract class SIPHeaderList<HDR extends SIPHeader> extends SIPHeader implements java.util.List<HDR>, Header {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.280 -0400", hash_original_field = "54FC99FFF06FAFF26E47359497AA764D", hash_generated_field = "1610EB574C9A048E3BE2EA98FBE15AF1")

    protected List<HDR> hlist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.280 -0400", hash_original_field = "D0509468108F68C610DFF430648FE029", hash_generated_field = "7DDB65A0A435AAFCBC63AD9D687C490F")

    private Class<HDR> myClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.280 -0400", hash_original_method = "D7E30AE5F54C678856B1E2B4E08FADF6", hash_generated_method = "DD0314912C40308B77D7E83CB7E4756A")
    private  SIPHeaderList() {
        hlist = new LinkedList<HDR>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.281 -0400", hash_original_method = "C956079DDC347F2EE85C1D1E44860715", hash_generated_method = "51235193447C0D5C365999E9B5547A62")
    protected  SIPHeaderList(Class<HDR> objclass, String hname) {
        this();
        addTaint(hname.getTaint());
        this.headerName = hname;
        this.myClass =  objclass;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.281 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "DD19463119EDA5DA9C42DB96C7445DF3")
    public String getName() {
String var2D0A9E749E9205038C7691483855DB68_2011128350 =         this.headerName;
        var2D0A9E749E9205038C7691483855DB68_2011128350.addTaint(taint);
        return var2D0A9E749E9205038C7691483855DB68_2011128350;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.282 -0400", hash_original_method = "45FF804DBFA2BB4F4071CDF27CE28633", hash_generated_method = "86B1608D9ECD77A26E2901F5D3AA5737")
    public boolean add(HDR objectToAdd) {
        addTaint(objectToAdd.getTaint());
        hlist.add((HDR)objectToAdd);
        boolean varB326B5062B2F0E69046810717534CB09_1717118972 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005251775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005251775;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.282 -0400", hash_original_method = "87B618AF10705C22EFB36E4A71158D56", hash_generated_method = "2C07AFDE4A0DCA38E55746E3ADF9124E")
    public void addFirst(HDR obj) {
        addTaint(obj.getTaint());
        hlist.add(0,(HDR) obj);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.282 -0400", hash_original_method = "3D14CCA72C816FE4801BBC05991E4343", hash_generated_method = "DA68F4029F6FD9ED2C2B15C62DFE59D0")
    public void add(HDR sipheader, boolean top) {
        addTaint(top);
        addTaint(sipheader.getTaint());
    if(top)        
        this.addFirst(sipheader);
        else
        this.add(sipheader);
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.283 -0400", hash_original_method = "2C5EDAC0235777863EFD087B4072277C", hash_generated_method = "D4AD0D90F9A0DB1B91A4CC16A1AF54E3")
    public void concatenate(SIPHeaderList<HDR> other, boolean topFlag) throws IllegalArgumentException {
        addTaint(topFlag);
        addTaint(other.getTaint());
    if(!topFlag)        
        {
            this.addAll(other);
        } 
        else
        {
            this.addAll(0, other);
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.283 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "208ABB2292BE5253E5E66D8E3ECEF5AC")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1168503773 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1168503773.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1168503773;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.284 -0400", hash_original_method = "4452028BB43CC449CBD4FD5523C455CD", hash_generated_method = "E34F00EFDE65226C179A6CA11D59E03D")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(hlist.isEmpty())        
        {
            buffer.append(headerName).append(':').append(Separators.NEWLINE);
        } 
        else
        {
    if(this.headerName.equals(SIPHeaderNames.WWW_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.AUTHORIZATION)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHORIZATION)
                    || (prettyEncode &&
                            (this.headerName.equals(SIPHeaderNames.VIA) || this.headerName.equals(SIPHeaderNames.ROUTE) || this.headerName.equals(SIPHeaderNames.RECORD_ROUTE))) 
                    || this.getClass().equals( ExtensionHeaderList.class))            
            {
                ListIterator<HDR> li = hlist.listIterator();
                while
(li.hasNext())                
                {
                    HDR sipheader = (HDR) li.next();
                    sipheader.encode(buffer);
                } 
            } 
            else
            {
                buffer.append(headerName).append(Separators.COLON).append(Separators.SP);
                this.encodeBody(buffer);
                buffer.append(Separators.NEWLINE);
            } 
        } 
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_10027118 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_10027118.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_10027118;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.284 -0400", hash_original_method = "3A5F29F99CF35D16AD0C376ECAFA4E44", hash_generated_method = "609B6F22586E3215C33F92B6849499D4")
    public List<String> getHeadersAsEncodedStrings() {
        List<String> retval = new LinkedList<String>();
        ListIterator<HDR> li = hlist.listIterator();
        while
(li.hasNext())        
        {
            Header sipheader = li.next();
            retval.add(sipheader.toString());
        } 
List<String> varF9E19AD6135C970F387F77C6F3DE4477_486492632 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_486492632.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_486492632;
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.285 -0400", hash_original_method = "6C7059400A289BDBD2DC174FD9546E0E", hash_generated_method = "DDD9AF3B062BFDBEF7618D375AAC2EBE")
    public Header getFirst() {
    if(hlist == null || hlist.isEmpty())        
        {
Header var540C13E9E156B687226421B24F2DF178_1609363993 =         null;
        var540C13E9E156B687226421B24F2DF178_1609363993.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1609363993;
        }
        else
        {
Header var03CBF4E7FCB6AE9DEC069A1A9E942FE2_1070057368 =         hlist.get(0);
        var03CBF4E7FCB6AE9DEC069A1A9E942FE2_1070057368.addTaint(taint);
        return var03CBF4E7FCB6AE9DEC069A1A9E942FE2_1070057368;
        }
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.285 -0400", hash_original_method = "564DA566938B5DEC3F30C613889BA2FD", hash_generated_method = "883B8444D9CEF637E7C8D854A61BA652")
    public Header getLast() {
    if(hlist == null || hlist.isEmpty())        
        {
Header var540C13E9E156B687226421B24F2DF178_1560474534 =         null;
        var540C13E9E156B687226421B24F2DF178_1560474534.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1560474534;
        }
Header var374F33CD83CC900111AB59F8D731DC16_796564119 =         hlist.get(hlist.size() - 1);
        var374F33CD83CC900111AB59F8D731DC16_796564119.addTaint(taint);
        return var374F33CD83CC900111AB59F8D731DC16_796564119;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.285 -0400", hash_original_method = "52DB400388897C60F1E5D7C5CF768C2C", hash_generated_method = "EE4ACF86EDB4EE024940CC0B0BE9B8D0")
    public Class<HDR> getMyClass() {
Class<HDR> var15B6B2C8B82C709EA0861459314166EA_1329155355 =         this.myClass;
        var15B6B2C8B82C709EA0861459314166EA_1329155355.addTaint(taint);
        return var15B6B2C8B82C709EA0861459314166EA_1329155355;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.286 -0400", hash_original_method = "FF43F4EB263E123805961D1A87217B48", hash_generated_method = "ABFF11128389B581DAA7310CDB5F8F66")
    public boolean isEmpty() {
        boolean varF6FBFC9C4283831A4C403D058FEA1D3C_1902936712 = (hlist.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942683039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_942683039;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.286 -0400", hash_original_method = "36E257E69C92FC5D45CD0DCB007DB07A", hash_generated_method = "2198B402C66591CC11507C7FA336708F")
    public ListIterator<HDR> listIterator() {
ListIterator<HDR> var214F06B8FEED8333C89E5D0EB8E4FC02_2033610098 =         hlist.listIterator(0);
        var214F06B8FEED8333C89E5D0EB8E4FC02_2033610098.addTaint(taint);
        return var214F06B8FEED8333C89E5D0EB8E4FC02_2033610098;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.286 -0400", hash_original_method = "9E6C15618943805727A8B08583C0FF39", hash_generated_method = "6EAC4FCE43235176B4FD4B0F420D87C0")
    public List<HDR> getHeaderList() {
List<HDR> var49BC912958DD04CBD88E5E5E589C21A1_1086730051 =         this.hlist;
        var49BC912958DD04CBD88E5E5E589C21A1_1086730051.addTaint(taint);
        return var49BC912958DD04CBD88E5E5E589C21A1_1086730051;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.286 -0400", hash_original_method = "EDE82742DF271310D47CFC69F814BF44", hash_generated_method = "058A892713107042F338BBEA3378D34C")
    public ListIterator<HDR> listIterator(int position) {
        addTaint(position);
ListIterator<HDR> varB6858C2A0A5D5DA33796D38FD73E73F3_295462428 =         hlist.listIterator(position);
        varB6858C2A0A5D5DA33796D38FD73E73F3_295462428.addTaint(taint);
        return varB6858C2A0A5D5DA33796D38FD73E73F3_295462428;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.287 -0400", hash_original_method = "66F538C19C1B45B9F4975D517A08EBE7", hash_generated_method = "0EC6A71C3B50D213E8D72294E41D19C0")
    public void removeFirst() {
    if(hlist.size() != 0)        
        hlist.remove(0);
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.287 -0400", hash_original_method = "56685A1560151077841543B2BC810F93", hash_generated_method = "4174F13ADDBFAB97F9B36DBC7B1C6E1C")
    public void removeLast() {
    if(hlist.size() != 0)        
        hlist.remove(hlist.size() - 1);
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.287 -0400", hash_original_method = "6090D81CA85470AC09234766F76789C0", hash_generated_method = "E22DE713B82E9089D927F0F6863EC9D2")
    public boolean remove(HDR obj) {
        addTaint(obj.getTaint());
    if(hlist.size() == 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_141967013 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1419871939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1419871939;
        }
        else
        {
        boolean var0A591BD0247EB6D15AFA01AFEB2B4319_1822764605 = (hlist.remove(obj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1076237776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1076237776;
        }
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.288 -0400", hash_original_method = "23B9304014C757503CC0D5B9D6DB550F", hash_generated_method = "B52967299638535006F513B062474563")
    protected void setMyClass(Class<HDR> cl) {
        this.myClass = cl;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.288 -0400", hash_original_method = "CC42CBF49D5975143777F4A2B14A482C", hash_generated_method = "BC301AD78910316BD13601AE58346AD1")
    public String debugDump(int indentation) {
        addTaint(indentation);
        stringRepresentation = "";
        String indent = new Indentation(indentation).getIndentation();
        String className = this.getClass().getName();
        sprint(indent + className);
        sprint(indent + "{");
for(Iterator<HDR> it = hlist.iterator();it.hasNext();)
        {
            HDR sipHeader = (HDR) it.next();
            sprint(indent + sipHeader.debugDump());
        } 
        sprint(indent + "}");
String var8D11C2D110975896438D6F91C60E6D6F_668257393 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_668257393.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_668257393;
        
        
        
        
        
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.288 -0400", hash_original_method = "ABFB21316126C2849AB41073C957D80E", hash_generated_method = "3E441762D4E5D61BFC48911C762F5009")
    public String debugDump() {
String varF5750B8E6AF3561EC64E2884C2BF2D7F_6512620 =         debugDump(0);
        varF5750B8E6AF3561EC64E2884C2BF2D7F_6512620.addTaint(taint);
        return varF5750B8E6AF3561EC64E2884C2BF2D7F_6512620;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.289 -0400", hash_original_method = "7EBA89BCEE46EEC5D25867CF89F8E8B9", hash_generated_method = "D9234AF78E317A8C812B26E5B98668B5")
    public Object[] toArray() {
Object[] var9BCCDED204626682CB94D4271D3BFC41_16218149 =         hlist.toArray();
        var9BCCDED204626682CB94D4271D3BFC41_16218149.addTaint(taint);
        return var9BCCDED204626682CB94D4271D3BFC41_16218149;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.289 -0400", hash_original_method = "795B857E8950EF3C66EEA5946EF97E00", hash_generated_method = "FD7CDDD23EB6D0AC165E52F90CE6B2AB")
    public int indexOf(GenericObject gobj) {
        addTaint(gobj.getTaint());
        int var096EA5045151DF57BBE15BF4244ABD78_153290330 = (hlist.indexOf(gobj));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850209163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850209163;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.289 -0400", hash_original_method = "D4A0602F4424EB672EFBEE9811EC3EF2", hash_generated_method = "C084A196CCF5B74F0FC6E53FE5DF92D9")
    public void add(int index, HDR  sipHeader) throws IndexOutOfBoundsException {
        addTaint(sipHeader.getTaint());
        addTaint(index);
        hlist.add(index, sipHeader);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.290 -0400", hash_original_method = "7AF224A0221DFF0013A72A01287D2D95", hash_generated_method = "AFEB4D646F06380CB89134D83B3FA0A3")
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1343106761 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_377390053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_377390053;
        }
    if(other instanceof SIPHeaderList)        
        {
            SIPHeaderList<SIPHeader> that = (SIPHeaderList<SIPHeader>) other;
    if(this.hlist == that.hlist)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_901587818 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1891292752 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1891292752;
            }
            else
    if(this.hlist == null)            
            {
            boolean var0345CD47BA79A23179449C6BFBDB3502_1230033609 = (that.hlist == null || that.hlist.size() == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274671242 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_274671242;
            }
            boolean var81B7B0BB46EA552398BF0C1D820E9C57_2031045883 = (this.hlist.equals(that.hlist));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_298553284 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_298553284;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1651860436 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281306299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_281306299;
        
        
            
        
            
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.290 -0400", hash_original_method = "6ED02991F9AD79524F79D6703964DFB6", hash_generated_method = "F1C026EE909F9E65F0860ED3604486D1")
    public boolean match(SIPHeaderList<?> template) {
        addTaint(template.getTaint());
    if(template == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_169807322 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_102126421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_102126421;
        }
    if(!this.getClass().equals(template.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1249704592 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314710349 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314710349;
        }
        SIPHeaderList<SIPHeader> that = (SIPHeaderList<SIPHeader>) template;
    if(this.hlist == that.hlist)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_859109858 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925757480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925757480;
        }
        else
    if(this.hlist == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1621712156 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_512255085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_512255085;
        }
        else
        {
for(Iterator<SIPHeader> it = that.hlist.iterator();it.hasNext();)
            {
                SIPHeader sipHeader = (SIPHeader) it.next();
                boolean found = false;
for(Iterator<HDR> it1 = this.hlist.iterator();it1.hasNext()
                        && !found;)
                {
                    SIPHeader sipHeader1 = (SIPHeader) it1.next();
                    found = sipHeader1.match(sipHeader);
                } 
    if(!found)                
                {
                boolean var68934A3E9455FA72420237EB05902327_388801525 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_284652549 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_284652549;
                }
            } 
            boolean varB326B5062B2F0E69046810717534CB09_1769193773 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431372989 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_431372989;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.292 -0400", hash_original_method = "359991759D26E2A3F33ACAEA17758D18", hash_generated_method = "0783330CE9FFF79898EC0CA81036F096")
    public Object clone() {
        try 
        {
            Class<?> clazz = this.getClass();
            Constructor<?> cons = clazz.getConstructor((Class[])null);
            SIPHeaderList<HDR> retval = (SIPHeaderList<HDR>) cons.newInstance((Object[])null);
            retval.headerName = this.headerName;
            retval.myClass  = this.myClass;
Object varF627329B9209466293A1BF71D9AF7B2B_694078664 =             retval.clonehlist(this.hlist);
            varF627329B9209466293A1BF71D9AF7B2B_694078664.addTaint(taint);
            return varF627329B9209466293A1BF71D9AF7B2B_694078664;
        } 
        catch (Exception ex)
        {
            RuntimeException var2C1E94E23404E6CD9DAB357D8EB46717_1123352854 = new RuntimeException("Could not clone!", ex);
            var2C1E94E23404E6CD9DAB357D8EB46717_1123352854.addTaint(taint);
            throw var2C1E94E23404E6CD9DAB357D8EB46717_1123352854;
        } 
        
        
            
            
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.292 -0400", hash_original_method = "CA032BB58CFE2AE5C2CC307C2E78224F", hash_generated_method = "413E19A716D73A68F94D04727E837CAA")
    protected final SIPHeaderList<HDR> clonehlist(List<HDR> hlistToClone) {
        addTaint(hlistToClone.getTaint());
    if(hlistToClone != null)        
        {
for(Iterator<HDR> it = (Iterator<HDR>) hlistToClone.iterator();it.hasNext();)
            {
                Header h = it.next();
                this.hlist.add((HDR)h.clone());
            } 
        } 
SIPHeaderList<HDR> var72A74007B2BE62B849F475C7BDA4658B_544980285 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_544980285.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_544980285;
        
        
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.293 -0400", hash_original_method = "FCBD3ECE23AA666BDE06756DAACE9219", hash_generated_method = "A0C0BA0CF914985050499BF6AD14F5AE")
    public int size() {
        int varAF3E3129CF1C5C3FB4229A92D894C33E_1508088145 = (hlist.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237456444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237456444;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.293 -0400", hash_original_method = "32932F147EA25CC7B7BC47F740C6BF91", hash_generated_method = "AA361503FAA2168E3989D19D3C6B3D09")
    public boolean isHeaderList() {
        boolean varB326B5062B2F0E69046810717534CB09_681901425 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_396306011 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_396306011;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.294 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "53216B34AA144566DD8350502FB887C3")
    protected String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_535489844 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_535489844.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_535489844;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.294 -0400", hash_original_method = "8EFAAECA9CE0AC45762D4D910A6D9585", hash_generated_method = "7266B22679507BC701E6507C68179583")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        ListIterator<HDR> iterator = this.listIterator();
        while
(true)        
        {
            SIPHeader sipHeader = (SIPHeader) iterator.next();
    if(sipHeader == this)            
            {
            RuntimeException var4E49D9E9544AAFAA7AA7CB9288406656_1568018559 = new RuntimeException ("Unexpected circularity in SipHeaderList");
            var4E49D9E9544AAFAA7AA7CB9288406656_1568018559.addTaint(taint);
            throw var4E49D9E9544AAFAA7AA7CB9288406656_1568018559;
            }
            sipHeader.encodeBody(buffer);
    if(iterator.hasNext())            
            {
    if(!this.headerName.equals(PrivacyHeader.NAME))                
                buffer.append(Separators.COMMA);
                else
                buffer.append(Separators.SEMICOLON);
                continue;
            } 
            else
            break;
        } 
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_19836186 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_19836186.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_19836186;
        
        
        
            
            
            
            
                
                    
                
                    
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.295 -0400", hash_original_method = "D5DDE9BDBABBA5EC4E7B0879A10A7D8D", hash_generated_method = "D883CAE97F17BA2A1DBC5202AEE4B8FA")
    public boolean addAll(Collection<? extends HDR> collection) {
        addTaint(collection.getTaint());
        boolean var2F99B7A53C0E3F568E166C1088FAE05D_145441993 = (this.hlist.addAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1469942836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1469942836;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.296 -0400", hash_original_method = "5E3DA6DCBC302D72E9103E3CB1D3527B", hash_generated_method = "1CE0715FD0DE3031908ACEC194CD4B04")
    public boolean addAll(int index, Collection<? extends HDR> collection) {
        addTaint(collection.getTaint());
        addTaint(index);
        boolean varB4EBE377B9166E9DECFDE489F4A7AC18_1319927011 = (this.hlist.addAll(index, collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_512465777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_512465777;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.296 -0400", hash_original_method = "F1DA48A9A827D74FF9F3AEB298E80E0A", hash_generated_method = "97C895072CB790C27CBB467BB1FF4D4E")
    public boolean containsAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var89FEFD365191181AAD3D23E2761A1800_1073781562 = (this.hlist.containsAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_56971357 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_56971357;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.296 -0400", hash_original_method = "D791B8D331C82850017A4DF87B2D73FE", hash_generated_method = "7B3736200B6CC37F2F0C36EB7F8C7C36")
    public void clear() {
        this.hlist.clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.297 -0400", hash_original_method = "B039DF80CC42319FF93C93DFC4F09CCF", hash_generated_method = "1D9B6C26F4F149C75382C7391B2BC0A8")
    public boolean contains(Object header) {
        addTaint(header.getTaint());
        boolean var43C10FBEA04219F6C839E45603981969_1556505209 = (this.hlist.contains(header));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225358415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_225358415;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.297 -0400", hash_original_method = "B0FF15B145547E100ED44D45A7137CDE", hash_generated_method = "232AC1EBB93EBDEAC5B262AA8B94DE98")
    public HDR get(int index) {
        addTaint(index);
HDR varE814669528E94208DB851E0203603324_2008831185 =         this.hlist.get(index);
        varE814669528E94208DB851E0203603324_2008831185.addTaint(taint);
        return varE814669528E94208DB851E0203603324_2008831185;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.297 -0400", hash_original_method = "9C1A1055EA03DFB32FF882EA4FC9149D", hash_generated_method = "23A91888E9895ACD34CC0BF5637C7C4D")
    public int indexOf(Object obj) {
        addTaint(obj.getTaint());
        int varAC466A844787C6333CA17A2EB953058F_1454563997 = (this.hlist.indexOf(obj));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1203261557 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1203261557;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.298 -0400", hash_original_method = "84FF645EE0B76DB0D5B552F9A7A0DC94", hash_generated_method = "88E060181FD7C963C6883DD5F21D3006")
    public java.util.Iterator<HDR> iterator() {
java.util.Iterator<HDR> var96DA5F4DE476CD2881BA1D682D0C27E7_1980593582 =         this.hlist.listIterator();
        var96DA5F4DE476CD2881BA1D682D0C27E7_1980593582.addTaint(taint);
        return var96DA5F4DE476CD2881BA1D682D0C27E7_1980593582;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.298 -0400", hash_original_method = "05A7D65C6D911E0B1F3261A66888CB52", hash_generated_method = "CC58DB347FBE09A20F3DFC872A6FC8B2")
    public int lastIndexOf(Object obj) {
        addTaint(obj.getTaint());
        int var6AF16C4D258C7D1B28A34D5FD81D47F4_537421213 = (this.hlist.lastIndexOf(obj));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427090705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427090705;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.298 -0400", hash_original_method = "FB49499CFAFE2E72F27390E6807CB034", hash_generated_method = "E362548BA7A0727F8122DAECDE389C94")
    public boolean remove(Object obj) {
        addTaint(obj.getTaint());
        boolean var91A3ABCCA3E1FA8D3ED21E0F4E2D5AB4_1843205567 = (this.hlist.remove(obj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_353570537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_353570537;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.299 -0400", hash_original_method = "2B7049D180B166140C32B8D54A96E238", hash_generated_method = "413917E5D5B51FBB951DF24F96520E5A")
    public HDR remove(int index) {
        addTaint(index);
HDR var2AFA8B7520708C0D013D76A45AB5CB74_1792156153 =         this.hlist.remove(index);
        var2AFA8B7520708C0D013D76A45AB5CB74_1792156153.addTaint(taint);
        return var2AFA8B7520708C0D013D76A45AB5CB74_1792156153;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.299 -0400", hash_original_method = "5A03B3005777615BF04A1D43320D1AA1", hash_generated_method = "361C2BF81FCDAF914703D2A0B47AFFED")
    public boolean removeAll(java.util.Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var30F068D3689D3D4F51A9B37B262304C6_1715319594 = (this.hlist.removeAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432183646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_432183646;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.299 -0400", hash_original_method = "4FD342E6A050272CE06CEE9969944C1B", hash_generated_method = "2A1297655D83BCD61448C1E916B0B6D2")
    public boolean retainAll(java.util.Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean varA2A738B814C2F176D6750A1B29B16AEE_320209799 = (this.hlist.retainAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297056771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_297056771;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.300 -0400", hash_original_method = "894CB5A5FAD7AFC5CD5A3389B3F77AB4", hash_generated_method = "1A4C2B9228C32439120CE63D2F88C761")
    public java.util.List<HDR> subList(int index1, int index2) {
        addTaint(index2);
        addTaint(index1);
java.util.List<HDR> varBF1746F375784D42EB824D444080CEAC_1924058482 =         this.hlist.subList(index1, index2);
        varBF1746F375784D42EB824D444080CEAC_1924058482.addTaint(taint);
        return varBF1746F375784D42EB824D444080CEAC_1924058482;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.300 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "949342A6AFAF49AC56C08A521B6098A0")
    public int hashCode() {
        int var3CA62782399404389049138061B2C659_2141913343 = (this.headerName.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638300075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638300075;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.300 -0400", hash_original_method = "A9FD382DBA3FE66AACB46D6203100A0D", hash_generated_method = "F185743B654BD38F5D0125D6A755FDBC")
    public HDR set(int position, HDR sipHeader) {
        addTaint(sipHeader.getTaint());
        addTaint(position);
HDR var73EA56BF60982634FDD7524661BF8918_222835620 =         hlist.set(position, sipHeader);
        var73EA56BF60982634FDD7524661BF8918_222835620.addTaint(taint);
        return var73EA56BF60982634FDD7524661BF8918_222835620;
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static void setPrettyEncode(boolean flag) {
        prettyEncode = flag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.301 -0400", hash_original_method = "B04CD19C0316B320C5B66A678FB2994B", hash_generated_method = "9378BDE19C7406A5A460EDAE5ED91D8E")
    public <T> T[] toArray(T[] array) {
        addTaint(array[0].getTaint());
T[] var0350DC20E51885F26BC9AE21A5634403_1017235933 =         this.hlist.toArray(array);
        var0350DC20E51885F26BC9AE21A5634403_1017235933.addTaint(taint);
        return var0350DC20E51885F26BC9AE21A5634403_1017235933;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.301 -0400", hash_original_field = "BB31D88D930D91866C4879183DCACA7E", hash_generated_field = "F24392C13A6D95700264E5A997197264")

    private static boolean prettyEncode = false;
}

