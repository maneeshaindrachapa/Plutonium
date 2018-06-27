# Plutonium - Simple Virus Analyser Using JAVA
Plutonium is a simple virus analyser made using Java,It uses a MD5 hash registry from [VirusShare](https://virusshare.com). It is capable of generating a report on a file whether it is infected or not. If infected then the type of virus identification. This is done using a API service supplied by [VirusTotal](https://www.virustotal.com/#/intelligence-overview).
### Home Page
![alt text](https://github.com/maneeshaindrachapa/Plutonium/blob/master/docs/1.PNG)<br>
### Virus Scan
![alt text](https://github.com/maneeshaindrachapa/Plutonium/blob/master/docs/2.PNG)<br>
![alt text](https://github.com/maneeshaindrachapa/Plutonium/blob/master/docs/3.PNG)<br>
In here if a folder is selected Plutonium will read all files in that folder and check the MD5 hashes of those files and checks those hashes are on the hash document provided by the [VirusShare](https://virusshare.com) . If it is in the doc file will detect as an infected file.
### Virus Total
![alt text](https://github.com/maneeshaindrachapa/Plutonium/blob/master/docs/4.PNG)<br>
![alt text](https://github.com/maneeshaindrachapa/Plutonium/blob/master/docs/5.PNG)<br>
These reports can generated using the API provided by [VirusTotal](https://www.virustotal.com/#/intelligence-overview)

## Required Libraris
1. [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. [gson 2.3.1](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.3.1)
3. AbsoluteLayout.jar

## Usage
1. Clone This Repository
2. Add Required Libraries
3. Run the Application

## Acknowledgements
1. [VirusShare](https://virusshare.com) for MD5 hash registry
2. [VirusTotal](https://www.virustotal.com/#/intelligence-overview) for API
