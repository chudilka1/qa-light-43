# Selenium Grid guidelines

## Start Selenium Grid server
1. Download Selenium Grid server (selenium-server-standalone-xxxx.jar)
2. Place the Selenium Server .jar file anywhere in your HardDrive
3. Navigate to the folder with donwloaded .jar and start CLI
4. Start Selenium Grid server:
	4.1. Run `java -jar selenium-server-standalone-xxxx.jar -role hub` (default port is 4444)
	4.2. If hub is configured with .json: 
	    4.2.1. Create `hubConfig.json` (see example in the root folder)
	    4.2.3. Run `java -jar selenium-server-standalone-3.141.59.jar -role hub -hubConfig hubConfig.json`
5. Verify Selenium Grid server started by `http://localhost:4444` (Selenium Grid Hub page should be displayed)

## Create Selenium Grid node
1. Ensure Selenium Grid server .jar file is downloaded on the node machine
2. Download necessary drivers (and put them into the folder with .jar file)
2. Obtain (write down) the ip address of the machine where the Selenium Grid hub is running
3. Navigate to the folder with donwloaded .jar and start CLI
4. Register and launch Selenium Grid node:
	4.1. Run `java -Dwebdriver.chomre.driver="C:\chromedriver.exe" -jar selenium-server-standalone-xxxxx.jar -role node -hub http://localhost:4444/grid/register -port 5566` (port is optional parameter, if not specified, it is automatically assigned)
	4.2. If node is configured with .json:
		4.2.1. Create `node1.json` (see example in the root folder)
		4.2.2. `java -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig node1.json`
5. Verify Selenium Grid node started by `http://localhost:4444/grid/console` (Selenium Grid node page should be displayed with predifined configuration)

## Remote driver initialization
1. If you are using Remote WebDriver nodes, then use RemoteWebDriver and DesiredCapabilities object to define the browser, version, and platform. For this, create the target browser capabilities to run the test:

`DesiredCapabilities capability = DesiredCapabilities.firefox();`

2. Once created, pass this set of browser capabilities into the RemoteWebDriver object

`WebDriver driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), capability);`

GOOD LUCK!!!