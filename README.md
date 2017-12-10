# Oauth-2.0-Sample
Mastering OAuth 2.0. personal reading record
```bash
mvn archetype:generate -DgroupId=snippets -DartifactId=wmiig -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```
```bash
wmiig
├── LICENSE
├── pom.xml
├── README.md
└── src
    └── main
        ├── resources
        └── webapp
            ├── index.jsp
            └── WEB-INF
                └── web.xml

```
> Modify the hosts file
In order to test our redirections properly, we need to be able to use proper hostnames when referring to our application. `localhost` just won't cut it. To do this, make sure you put the following entry into your `hosts` file:
```
127.0.0.1 wmiig.com
```
With this entry in place, you can now refer to `localhost` using the hostname wmiig.com.
Since `hosts` files are maintained differently on different platforms, the process of modifying your `hosts` file is omitted. Typically, this is located at `/etc/hosts` for Linux/Unix-based systems, including OSX. For Windows 8+ machines, it is located at `C:\Windows\System32\Drivers\etc\hosts`.

```bash
mvn -Dmaven.tomcat.port=80 -Dmaven.tomcat.path=/ tomcat:run
```
