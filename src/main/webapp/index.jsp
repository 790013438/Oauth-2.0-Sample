<html>
    <head>
        <title>The World's Most Interesting Infographic</title>
    </head>
    <body>
        <button id="goButton" type="button">Go!</button>
        <div id="results"></div>
    </body>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#goButton').click(makeRequest);
        });

        function makeRequest() {
            // Define properties
            var AUTH_ENDPOINT = 'https://github.com/login/oauth/authorize';
            var CLIENT_ID = 'a20bc0c080b542a9b882';
            var REDIRECT_URI = 'http://floyd10086.com/callback.html';
            var SCOPE = 'public_repo';

            // Build authorization request endpoint
            var requestEndpoint = AUTH_ENDPOINT + '?' + 
            'client_id=' + encodeURIComponent(CLIENT_ID) + '&' + 
            'redirect_uri=' + encodeURIComponent(REDIRECT_URI) + '&' + 
            'scope=' + encodeURIComponent(SCOPE);

            // Send to authorization request endpoint
            window.location.href = requestEndpoint;
        }
    </script>
</html>
