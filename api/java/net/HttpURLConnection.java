package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import libcore.net.http.HttpEngine;





public abstract class HttpURLConnection extends URLConnection {

    /**
     * Returns the value of {@code followRedirects} which indicates if this
     * connection follows a different URL redirected by the server. It is
     * enabled by default.
     *
     * @return the value of the flag.
     * @see #setFollowRedirects
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.044 -0500", hash_original_method = "195F46AAAC627D752197C2F5D2FE5BA7", hash_generated_method = "9A6235A6549370F6AEF343DDA467E4AF")
    public static boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * Sets the flag of whether this connection will follow redirects returned
     * by the remote server.
     *
     * @param auto
     *            the value to enable or disable this option.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.048 -0500", hash_original_method = "01C5BC2929229BBFAEADEA2D910F6CE5", hash_generated_method = "77856BA0E5A7DD9A70EB63102D162657")
    public static void setFollowRedirects(boolean auto) {
        followRedirects = auto;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.004 -0500", hash_original_field = "0F5B14F99883A7FABF4F73F6F2461088", hash_generated_field = "30980E96694F574E6B83303B404181DE")

    private static final String[] PERMITTED_USER_METHODS = {
            HttpEngine.OPTIONS,
            HttpEngine.GET,
            HttpEngine.HEAD,
            HttpEngine.POST,
            HttpEngine.PUT,
            HttpEngine.DELETE,
            HttpEngine.TRACE
            // Note: we don't allow users to specify "CONNECT"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.008 -0500", hash_original_field = "7FD13A00311AD6500193BCCAFBA702CB", hash_generated_field = "B6B148D800DA01B94858FBCF1FB7DA47")


    private static boolean followRedirects = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.011 -0500", hash_original_field = "08C33CBFB7734EF961E47B48359F521B", hash_generated_field = "96A78475A787D0B276307F183EB23F54")

    // 3XX: relocation/redirect
    // 4XX: client error
    // 5XX: server error
    /**
     * Numeric status code, 202: Accepted
     */
    public static final int HTTP_ACCEPTED = 202;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.011 -0500", hash_original_field = "EBE543340DE0A24DD81ACDB2018FA292", hash_generated_field = "9864CA3F5FB31C39804E7466BA3CD139")

    public static final int HTTP_BAD_GATEWAY = 502;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.012 -0500", hash_original_field = "DB23A1D225B25EBCE5F4092D634B553C", hash_generated_field = "696A2E951293D6CD9261D6B05486691E")

    public static final int HTTP_BAD_METHOD = 405;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.013 -0500", hash_original_field = "F96425FAAEF3C9E4B1DDFC53455B7E5F", hash_generated_field = "5577B38F7E0C48DFB42FE39AEF31D544")

    public static final int HTTP_BAD_REQUEST = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.014 -0500", hash_original_field = "2AE7AD92E3A14EB66B85EF44D8A45805", hash_generated_field = "63A04887E330E4F535339E1E5BCF5FDD")

    public static final int HTTP_CLIENT_TIMEOUT = 408;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.015 -0500", hash_original_field = "2FF1DF6A69E0D5F5CFD8E6EEC1A60A62", hash_generated_field = "0767719730997B49271B736544301776")

    public static final int HTTP_CONFLICT = 409;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.016 -0500", hash_original_field = "80F6DEBBB6054C209754169857104A97", hash_generated_field = "E0DF1F490D7179E22226073461AD67B5")

    public static final int HTTP_CREATED = 201;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.017 -0500", hash_original_field = "B0B1A24F217A2A8EFFD6DF6D8541BA17", hash_generated_field = "FD6C34742CF4690CA78A254B5256C694")

    public static final int HTTP_ENTITY_TOO_LARGE = 413;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.017 -0500", hash_original_field = "8B8973D4B3994913CE9E3180882A522D", hash_generated_field = "BAAF308A424CA9ACE2FAAE31C54AFC7F")

    public static final int HTTP_FORBIDDEN = 403;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.018 -0500", hash_original_field = "9EB9D090DB119E7552474F22115B8C93", hash_generated_field = "8CDD0FC1C367EA9D2C8D75383F450447")

    public static final int HTTP_GATEWAY_TIMEOUT = 504;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.019 -0500", hash_original_field = "AF3A847F9AD0A3C868A50272271F2B3A", hash_generated_field = "7BBF798C1FD94676CE47A165F97359C4")

    public static final int HTTP_GONE = 410;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.020 -0500", hash_original_field = "92EFFA00C306D39FEFFBC066B8E326FF", hash_generated_field = "F01C8443DA02D3A267D3E058CCB1F504")

    public static final int HTTP_INTERNAL_ERROR = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.021 -0500", hash_original_field = "C012DDCCCEA8D49689B9B99B4FFEDDBE", hash_generated_field = "0DCDC89059EE26376A2549D30E897CBB")

    public static final int HTTP_LENGTH_REQUIRED = 411;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.022 -0500", hash_original_field = "3EA381A9298B518A51D2FDA73DC8609A", hash_generated_field = "850977F848B556A14BE3FA0DA2ADAD18")

    public static final int HTTP_MOVED_PERM = 301;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.023 -0500", hash_original_field = "3E92CE98C6BDDB5FE1C896B1793B234D", hash_generated_field = "F6577310447CF3C587C37765B2784E79")

    public static final int HTTP_MOVED_TEMP = 302;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.023 -0500", hash_original_field = "EE46FE288FBCE5BA54E7AEA00CB1B530", hash_generated_field = "469D3D9BE99C408D2FA7961787A207EF")

    public static final int HTTP_MULT_CHOICE = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.024 -0500", hash_original_field = "54416A39C4A18F7DC2701C4FB289D172", hash_generated_field = "B2FC3A8B3E42A9E9D38E54A3702BEB16")

    public static final int HTTP_NO_CONTENT = 204;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.025 -0500", hash_original_field = "23B75FC35F9F30EBC297B1565FC2F3F1", hash_generated_field = "B40E3B5B40334E6092B9B6D34B7C538E")

    public static final int HTTP_NOT_ACCEPTABLE = 406;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.026 -0500", hash_original_field = "C0336D2EAB1520050405B3C4702FAF36", hash_generated_field = "D27B485062E6EC655CD2B4E91A01411F")

    public static final int HTTP_NOT_AUTHORITATIVE = 203;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.027 -0500", hash_original_field = "5F76983B14F0A279991E635441241C96", hash_generated_field = "DA61F60B79920B39A724C61DCBD4C785")

    public static final int HTTP_NOT_FOUND = 404;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.028 -0500", hash_original_field = "D7E3287CE5D50C2C52DCAD8D980BFF8F", hash_generated_field = "5AF86F1E70BBDB2DDA175ACE4BE74EB2")

    public static final int HTTP_NOT_IMPLEMENTED = 501;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.029 -0500", hash_original_field = "D867F77B71B4007457FAD26BE01C5B60", hash_generated_field = "09621F5A75F08E6A479373F764583267")

    public static final int HTTP_NOT_MODIFIED = 304;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.029 -0500", hash_original_field = "4F08975A84D01CE999CC4E4860225587", hash_generated_field = "B28A869494D6F2BB4C3309364352E925")

    public static final int HTTP_OK = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.030 -0500", hash_original_field = "89F8899BAC05D17380CFF32F2E6D7296", hash_generated_field = "9470102D6735C74C850CC62FFAC35505")

    public static final int HTTP_PARTIAL = 206;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.031 -0500", hash_original_field = "C20ADC26C9A57D6CB4317FF71FE96539", hash_generated_field = "623DAA6CF22D74D5117D76A4E14DBB31")

    public static final int HTTP_PAYMENT_REQUIRED = 402;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.032 -0500", hash_original_field = "1F7F837F717A5DACEE64428D01E4BEE2", hash_generated_field = "03F7F1E288750056447A9AEE3777CB82")

    public static final int HTTP_PRECON_FAILED = 412;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.033 -0500", hash_original_field = "B9011F9284B3F5802812F31765400BAF", hash_generated_field = "1D204D4BD4AB01CF4D5CCF382B338CA2")

    public static final int HTTP_PROXY_AUTH = 407;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.034 -0500", hash_original_field = "E51D0816BB59F92E94FFBC5E773899F7", hash_generated_field = "1C15FD99A982DB822D82F55EC13E7655")

    public static final int HTTP_REQ_TOO_LONG = 414;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.034 -0500", hash_original_field = "9B8DD461C4826271F4890BE7193D5EF0", hash_generated_field = "654DDA09165022891332C495EEA0BCAA")

    public static final int HTTP_RESET = 205;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.036 -0500", hash_original_field = "F587D14A71911E85060DCB94495BE5D3", hash_generated_field = "DCCCB9D9FAB840DC0E6E2A8B18DF7B1B")

    public static final int HTTP_SEE_OTHER = 303;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.036 -0500", hash_original_field = "4968C927FEDDFC95CF3C14FFA9DD65E7", hash_generated_field = "3420A19DE136753A76C8A86911BDE6EA")

    @Deprecated
    public static final int HTTP_SERVER_ERROR = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.037 -0500", hash_original_field = "642064CDD2DDF9250DEC3F218598A5FD", hash_generated_field = "30A12FC36C0F6722154FAAA6F4948E03")

    public static final int HTTP_USE_PROXY = 305;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.038 -0500", hash_original_field = "5048526DDF3465323C1C2E6A1D7D6500", hash_generated_field = "D598D4ED4CC6F37F7F263CD950F7880A")

    public static final int HTTP_UNAUTHORIZED = 401;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.039 -0500", hash_original_field = "E5332B3190B3B5905A7A1DF30D341634", hash_generated_field = "F9830A7FB26A343C08DADEA53699DDD4")

    public static final int HTTP_UNSUPPORTED_TYPE = 415;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.040 -0500", hash_original_field = "22C1BC4C55C2966F0A05E56D55C87648", hash_generated_field = "3465A3FC0C00178A095C5D45D5849D57")

    public static final int HTTP_UNAVAILABLE = 503;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.041 -0500", hash_original_field = "0F97F63A796550B57E4C2633C371FE0C", hash_generated_field = "9D040EB72BD3FB6AFC1CBAC843DD69E3")

    public static final int HTTP_VERSION = 505;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.004 -0500", hash_original_field = "071B53D04DDD05D832A6DF00AC608C77", hash_generated_field = "F06DE6E42C33023D5D9ACD62B7708D03")

    protected String method = HttpEngine.GET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.006 -0500", hash_original_field = "C8334BB5D76A281957EF6D16AB72DEB9", hash_generated_field = "8B29EFDEBE881DE9494B414F5C05E649")

    protected int responseCode = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.006 -0500", hash_original_field = "DB6D15FDCC440703E4CF4DC1D69DBA6B", hash_generated_field = "E5DB9E5C9FDAF202B17CFDE924A921F1")

    protected String responseMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.007 -0500", hash_original_field = "E5C5D688D36E086F230C59CCFC7214E4", hash_generated_field = "809E761C93200C2583C6922826941A9E")

    protected boolean instanceFollowRedirects = followRedirects;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.009 -0500", hash_original_field = "AA915776256C9E04FEA1DC668EF1B876", hash_generated_field = "77687C2C09882EC53E9F2E7D596A60DB")

    protected int chunkLength = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.010 -0500", hash_original_field = "0AF15284BC11A1CA6DB85266A353695D", hash_generated_field = "BAF5159A87CC6A5E2AEF6B3E3AEA785A")

    protected int fixedContentLength = -1;

    /**
     * Constructs a new {@code HttpURLConnection} instance pointing to the
     * resource specified by the {@code url}.
     *
     * @param url
     *            the URL of this connection.
     * @see URL
     * @see URLConnection
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.041 -0500", hash_original_method = "58372EDCAE538607FC34A4F4F0582407", hash_generated_method = "D74395ED30BF348457F7270004946E3E")
    protected HttpURLConnection(URL url) {
        super(url);
    }

    /**
     * Closes the connection to the HTTP server.
     *
     * @see URLConnection#connect()
     * @see URLConnection#connected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.042 -0500", hash_original_method = "3C68B068054EBA545E5AA24799ED950D", hash_generated_method = "0F5A9F285A124D64FA561BD6158DD33E")
    public abstract void disconnect();

    /**
     * Returns an input stream from the server in the case of an error such as
     * the requested file has not been found on the remote server. This stream
     * can be used to read the data the server will send back.
     *
     * @return the error input stream returned by the server.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.043 -0500", hash_original_method = "6640096D2D877ED3E740627246DA5AF9", hash_generated_method = "58330C89C9E2E008813741E1516603AD")
    public InputStream getErrorStream() {
        return null;
    }

    /**
     * Returns the permission object (in this case {@code SocketPermission})
     * with the host and the port number as the target name and {@code
     * "resolve, connect"} as the action list. If the port number of this URL
     * instance is lower than {@code 0} the port will be set to {@code 80}.
     *
     * @return the permission object required for this connection.
     * @throws IOException
     *             if an IO exception occurs during the creation of the
     *             permission object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.044 -0500", hash_original_method = "ED24FB1ED5E1E919D525362B14A80DB6", hash_generated_method = "CCDEB11B4A1F8430376C08884DDDC178")
    @Override
public java.security.Permission getPermission() throws IOException {
        int port = url.getPort();
        if (port < 0) {
            port = 80;
        }
        return new SocketPermission(url.getHost() + ":" + port,
                "connect, resolve");
    }

    /**
     * Returns the request method which will be used to make the request to the
     * remote HTTP server. All possible methods of this HTTP implementation is
     * listed in the class definition.
     *
     * @return the request method string.
     * @see #method
     * @see #setRequestMethod
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.045 -0500", hash_original_method = "0D9C6E3C645DAD49E763E30DD315D3EF", hash_generated_method = "856E62238850A66AFEBF25CCB07FCBB8")
    public String getRequestMethod() {
        return method;
    }

    /**
     * Returns the response code returned by the remote HTTP server.
     *
     * @return the response code, -1 if no valid response code.
     * @throws IOException
     *             if there is an IO error during the retrieval.
     * @see #getResponseMessage
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.046 -0500", hash_original_method = "7D3B203196D55AEFB0033919830A54D2", hash_generated_method = "E5CEF15CCA918C333D4C4BE375BE6761")
    public int getResponseCode() throws IOException {
        // Call getInputStream() first since getHeaderField() doesn't return
        // exceptions
        getInputStream();
        String response = getHeaderField(0);
        if (response == null) {
            return -1;
        }
        response = response.trim();
        int mark = response.indexOf(" ") + 1;
        if (mark == 0) {
            return -1;
        }
        int last = mark + 3;
        if (last > response.length()) {
            last = response.length();
        }
        responseCode = Integer.parseInt(response.substring(mark, last));
        if (last + 1 <= response.length()) {
            responseMessage = response.substring(last + 1);
        }
        return responseCode;
    }

    /**
     * Returns the response message returned by the remote HTTP server.
     *
     * @return the response message. {@code null} if no such response exists.
     * @throws IOException
     *             if there is an error during the retrieval.
     * @see #getResponseCode()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.047 -0500", hash_original_method = "2B517AE93F70715BB09FC42E79EE9551", hash_generated_method = "268A72CA5053EB689B330389DCC43810")
    public String getResponseMessage() throws IOException {
        if (responseMessage != null) {
            return responseMessage;
        }
        getResponseCode();
        return responseMessage;
    }

    /**
     * Sets the request command which will be sent to the remote HTTP server.
     * This method can only be called before the connection is made.
     *
     * @param method
     *            the string representing the method to be used.
     * @throws ProtocolException
     *             if this is called after connected, or the method is not
     *             supported by this HTTP implementation.
     * @see #getRequestMethod()
     * @see #method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.048 -0500", hash_original_method = "3B5EB6833E70FFDCB063E860A5177AF6", hash_generated_method = "CB9578508F0DA92FBC57641C0CFBE1C1")
    public void setRequestMethod(String method) throws ProtocolException {
        if (connected) {
            throw new ProtocolException("Connection already established");
        }
        for (String permittedUserMethod : PERMITTED_USER_METHODS) {
            if (permittedUserMethod.equals(method)) {
                // if there is a supported method that matches the desired
                // method, then set the current method and return
                this.method = permittedUserMethod;
                return;
            }
        }
        // if none matches, then throw ProtocolException
        throw new ProtocolException("Unknown method '" + method + "'; must be one of " +
                Arrays.toString(PERMITTED_USER_METHODS));
    }

    /**
     * Returns whether this connection uses a proxy server or not.
     *
     * @return {@code true} if this connection passes a proxy server, false
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.049 -0500", hash_original_method = "373BD5C6D915886091B65C981790F7E3", hash_generated_method = "B63EE72C4BD0A01FEACCDE1364ECDF54")
    public abstract boolean usingProxy();

    /**
     * Returns the encoding used to transmit the response body over the network.
     * This is null or "identity" if the content was not encoded, or "gzip" if
     * the body was gzip compressed. Most callers will be more interested in the
     * {@link #getContentType() content type}, which may also include the
     * content's character encoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.051 -0500", hash_original_method = "17A4A6C99056147BEFFA252CAD4737D6", hash_generated_method = "75271B8463D26A418CBC1CC9FFE3090D")
    @Override
public String getContentEncoding() {
        return super.getContentEncoding(); // overridden for Javadoc only
    }

    /**
     * Returns whether this connection follows redirects.
     *
     * @return {@code true} if this connection follows redirects, false
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.051 -0500", hash_original_method = "881D26516B84F6D6EEADB518A168ADE5", hash_generated_method = "3D08967BCB3267899294E27181F97478")
    public boolean getInstanceFollowRedirects() {
        return instanceFollowRedirects;
    }

    /**
     * Sets whether this connection follows redirects.
     *
     * @param followRedirects
     *            {@code true} if this connection will follows redirects, false
     *            otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.052 -0500", hash_original_method = "BB71B8E9C2D3F0EF20C7720F9E44016D", hash_generated_method = "703BEB9D82C667D729F218BA55F744AA")
    public void setInstanceFollowRedirects(boolean followRedirects) {
        instanceFollowRedirects = followRedirects;
    }

    /**
     * Returns the date value in milliseconds since {@code 01.01.1970, 00:00h}
     * corresponding to the header field {@code field}. The {@code defaultValue}
     * will be returned if no such field can be found in the response header.
     *
     * @param field
     *            the header field name.
     * @param defaultValue
     *            the default value to use if the specified header field wont be
     *            found.
     * @return the header field represented in milliseconds since January 1,
     *         1970 GMT.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.053 -0500", hash_original_method = "6E2F3B7733832056F416A461A3655623", hash_generated_method = "ADB9DD8D1AD768A58E2F31808B608AE5")
    @Override
public long getHeaderFieldDate(String field, long defaultValue) {
        return super.getHeaderFieldDate(field, defaultValue);
    }

    /**
     * If the length of a HTTP request body is known ahead, sets fixed length to
     * enable streaming without buffering. Sets after connection will cause an
     * exception.
     *
     * @see #setChunkedStreamingMode
     * @param contentLength
     *            the fixed length of the HTTP request body.
     * @throws IllegalStateException
     *             if already connected or another mode already set.
     * @throws IllegalArgumentException
     *             if {@code contentLength} is less than zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.054 -0500", hash_original_method = "746797ABBB47B5E996C092A3E4D56421", hash_generated_method = "DF85FA5E1C07390B047C55ADAC9B77ED")
    public void setFixedLengthStreamingMode(int contentLength) {
        if (super.connected) {
            throw new IllegalStateException("Already connected");
        }
        if (chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        }
        if (contentLength < 0) {
            throw new IllegalArgumentException("contentLength < 0");
        }
        this.fixedContentLength = contentLength;
    }

    /**
     * Stream a request body whose length is not known in advance. Old HTTP/1.0
     * only servers may not support this mode.
     *
     * <p>When HTTP chunked encoding is used, the stream is divided into
     * chunks, each prefixed with a header containing the chunk's size. Setting
     * a large chunk length requires a large internal buffer, potentially
     * wasting memory. Setting a small chunk length increases the number of
     * bytes that must be transmitted because of the header on every chunk.
     * Most caller should use {@code 0} to get the system default.
     *
     * @see #setFixedLengthStreamingMode
     * @param chunkLength the length to use, or {@code 0} for the default chunk
     *     length.
     * @throws IllegalStateException if already connected or another mode
     *     already set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.055 -0500", hash_original_method = "21470E1D7A697F6C3367E1B80C1F2447", hash_generated_method = "93042EBF77367EE2D4961D3CDAF8C59C")
    public void setChunkedStreamingMode(int chunkLength) {
        if (super.connected) {
            throw new IllegalStateException("Already connected");
        }
        if (fixedContentLength >= 0) {
            throw new IllegalStateException("Already in fixed-length mode");
        }
        if (chunkLength <= 0) {
            this.chunkLength = HttpEngine.DEFAULT_CHUNK_LENGTH;
        } else {
            this.chunkLength = chunkLength;
        }
    }
}

