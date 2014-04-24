Add below VM arguments to Tomcat Server Runtime:

  -javaagent:D:\workspace\smart-parent\jrebel\jrebel.jar -noverify
  
Eclipse Menu > Run > Run Configurations... > Apache Tomcat > Tomcat v7.0 Server at localhost > Arguments > VM Arguments

Go to Servers view, double click to open "Tomcat v7.0 Server at localhost"
 > Modules
 > Select your webapp project
 > Edit
 > Uncheck "Auto reloading enabled" box
