# Post Tracking System
<br><br>
## Table of contents
- [Instalation](#instalation)
- [Menu](#main-menu)
- [Adding a Package](#adding-a-package)
- [Looking for a Package](#looking-for-a-package)

## Instalation
<ol>
    <li>Clone the repo: git clone https://github.com/cesarreboucas/PostTracking.git</li>
    <li>Start MySQL (Make sure there is a root user with blank password :blush: )</li>
    <li>Create a Database called `posttracking`</li>
    <li>Fire up ECLIPSE</li>
    <li>Go to "File" => "Open Projects from File System..."</li>
    <li>Select the folder created when you cloned the Repo</li>
    <li>Get a :coffee: while Maven download the Dependencies</li>
    <li>Look for the Package Boundaries under `com.PosTracking`</li>
    <li>Select the Class PostTrackingApplication.java</li>
    <li>:rocket: Run! (Ctrl+F11)</li>
</ol>
<p>Your Server should be Available Localhost port 8080</p>
<p>On your Browser, you should be able see this screen: </p>
<img src="https://github.com/cesarreboucas/PostTracking/blob/master/Support/Instalation/screenIndex.png?raw=true" />
<p>If You are looking for a Demo set of data, aceess the 
    <strong>Start Kit (127.0.0.1:8080/start)</strong> and follow the Instructions on the Screen!</p>

## Main Menu

### Below, a brief explanation of menu items:
<img src="https://github.com/cesarreboucas/PostTracking/blob/master/Support/Instalation/menu.png?raw=true" />
<ol>
    <li><strong>Vehicles:</strong>
        The vehicles that carry the packages among the Distribution Centers.</li>
    <li><strong>Routes:</strong>
        Predetermined Journeys that generates all the future Journeys.</li>
    <li><strong>Journeys:</strong>
        Active Journeys that were created automatically when adding a Package. Just the Journeys with
        an ongoing Package are shown.</li>
    <li><strong>Packages:</strong> Search or Add Packages in this section.</li>
    <li><strong>Customers:</strong> The owners of each Package in the company.</li>
    <li><strong>Dist. Centers:</strong> Physical spaces where Packages flow until reach 
        the Destination</li>
</ol>
<br/><br/>

## Adding a Package
<p> Packages are the main component in our system.</p>
<p> You can Add a Package accessing the menu "Packages", then "Add Package"</p>
<p> The form is pretty straight forward, and the example is the following:</p>
<img src="https://github.com/cesarreboucas/PostTracking/blob/master/Support/Instalation/add_package.png?raw=true" />
<p>After filling the Form, the Button "Seek Path" will look for Paths (set of Journeys) between the Origin and the Destination.<br/>The Output is similar to the following:</p>
<img src="https://github.com/cesarreboucas/PostTracking/blob/master/Support/Instalation/seekpath.png?raw=true" />
<p>Where you can choose (By Clicking in "Choose" :grin: among the options) the Journyes (and the Distribution Centers/Vehicles) you want to use to Deliver this Package.</p>
<p>We choosed the second Option :dart:</p>
<br/><br/>

## Looking for a Package
<p>After adding a Package, you can see it on the menu Packages => Seach.</p>
<p>Filling the criteria is optional but we strongly recommend, mainly when dealing with a large number of packages.</p>
<p>In our example, this is the result</p>
<img src="https://github.com/cesarreboucas/PostTracking/blob/master/Support/Instalation/packages_main.png?raw=true" />
<p></p>As you can see, the Package number "3" is there going from Dragonstone to Winterfell, currently in Dragonstone (where it started its way), having the first movement going to "Myr"</p>