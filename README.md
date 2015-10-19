# ese2015-team2

Dear Team members, ESE Staff and strangers,

This is a project for the course "Einführung in Software Engineering" at the University of Berne, Fall Semester 2015. 
The team members are:
* Eve Mendoza Quiros
* Mischa Wenger
* Cyrill Portmann
* Marc Jost
 
The lectures at the University are mostly of theoretical nature, while the exercises aim to provide the students with some first hand experience. For this matter, a tutoring website is to be developed for an imaginary customer. The students learn how to interact with customers regarding requirements elicitation and formalization and eventually developing iteratively. 

This repository contains all the output that we, ESE Team 2, generated during the semester. Have fun!

## Installation Instructions

In order to work on the project, you will need a few things:
* Glassfish 4.1 (Java EE 7 full platform) https://glassfish.java.net/download.html
* NetBeans IDE (the Java EE version): http://download.netbeans.org/netbeans/8.1/rc/
* JDK8 http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* Git (included in NetBeans, but if you prefer the console thing, download (g)it)

### JDK
* Make sure you have installed JDK8 and set up your path correctly. I'm not touching this one with a 10 feet pole, you're on your own. 

### Glassfish
* After you've downloaded Glassfish (GF), extract the ZIP's content to anywhere you like. I extracted mine to C, so mine is C:\glassfish4\
* This is basically it, you've installed GF! You can test the installation by opening the command shell and navigating to [wherevery you installed]glassfish4\glassfish\bin and then executing the command "asadmin start-domain domain1" without the quotes. After it says "Domain started successfully", open your browser and type localhost:8080 and enter. If done correctly, you should see the message "Your Server is now running".
* Leave your GF alone for now. She needs some space too you know.

### Netbeans

* After you've downloaded and installed NetBeans (NB), it's advisable to give NB Administrator Privileges. On Windows, right click the shortcut, go to compatability and tell it to run as administrator. On Mac: Who cares? :-D
* Clone this repository by using the Git shell or the tools provided on this platform
* Return to NB and choose File, Open Project and navigate to the location where you clones the project to. Open the project
* You should now have the project ESET2 in NB's project explorer. Joy to the world. 
* Now it's time to hook up NB and GF. For this choose "Tool" in NB (top menu bar) and then Servers. Click Add Server in the lower right, select GlassFish Server, Next and specify the installation directory (mine would be C:\glassfish4). Keep local domain selected and choose Next. Keep the default settings and finish the wizard.
* Optional: Try starting the server from NB. Next to the project explorer on the left hand you should see a tab called Services. Open it, expand Servers and you should see your GF there. Right click it and choose start. At the bottom of the screen you'll see some sweet output in the Glassfish tab. 
* We'll need to attach the Server to the project. Easy: Right Click the project, choose Properties at the bottom and navigate to "Run". There, choose your GF in the Server Dropdown and click okay. That's it!
* Running the project is as easy as right clicking the project and choosing run. If you've done everything right, GF will start up and your browser will open, showing the project.
* Side note: It might be necessary to register your JDK in NetBeans. For this, go to Tools -> Java Platforms. Add a new platform and browse to your JDK8 installation. 
 
That should be it for now. I will keep this updated if questions arise or something isn't clear enough. 

Thanks and bye!
