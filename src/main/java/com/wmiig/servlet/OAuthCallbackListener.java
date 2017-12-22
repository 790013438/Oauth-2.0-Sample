package com.wmiig.servlet;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class OAuthCallbackListener extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Detect the presence of an authorization code
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Detect the presence of an authoriztion code
        String authorizationCode = request.getParameter("code");
        if (authorizationCode != null && authorizationCode.length() > 0) {

            final String TOKEN_ENDPOINT = "https://github.com/login/oauth/access_token";
            final String REDIRECT_URI = "http://floyd10086.com/callback";
            final String CLIENT_ID = "a20bc0c080b542a9b882";
            final String CLIENT_SECRET = "b253b20abc1f3bfc1200492ecc5e1accfe913c4d";

            // Generate POST request
            HttpPost httpPost = new HttpPost(TOKEN_ENDPOINT + "?code=" +
                    URLEncoder.encode(authorizationCode, StandardCharsets.UTF_8.name()) +
                    "&client_id=" + "a20bc0c080b542a9b882" +
                    "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI,
                    StandardCharsets.UTF_8.name()));

            // Add "Authorization" header with encoded client credentials
            String clientCredentials = CLIENT_ID + ":" + CLIENT_SECRET;
            String encodedClientCredentials =
                    new String(Base64.encodeBase64(clientCredentials.getBytes()));
            httpPost.setHeader("Authorization", "Basic " + encodedClientCredentials);

            // Make the access token request
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpResponse httpResponse = httpClient.execute(httpPost);

            // TODO: Handle access token response
            httpClient.close();

        } else {
            // Handle failure
        }
    }
}
