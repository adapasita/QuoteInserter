Quote Inserter Services Project Description:

It is Maven-TestNG based Data-Driven java Project

It add all quotes by Gideon to the database that we can find on the following website: https://agoldoffish.wordpress.com/criminal-minds-opening-and-closing-quotes

It is followed page object model design pattern. Automation framework is designed in a parametrised way. This means that the tests can theoretically be run in any environment just by changing the relevant parameters (in practice there will need to be some modifications to take into account different environmental structures such as stubbing).

Automation framework is designed in a such way that it is very easy to automate remaining or new testcases as i have created common functions across all Scripts. For adding new testcase, just need to add test case name in testdata.xls and create method with testname in test classes by calling existing common methods.

Selenium is used for WEB Automation.

pom.xml contains all basic dependencies required for WEB automation project.

TestNG.xml contains tests needs to be executed.

TestData.xls should contain testname and corresponding test data.

This Framework can easily integrate with mobile and api automation.

It is integrated with Extent Report API. Extent Reports is a HTML reporting library for quick generation of great looking HTML reports.Latest execution report can be viewed from path test-output\SmartReport.html.

Extent Summary Report will show service wise results in the left side status tab and corresponding to that right side will show all testcases statuses related to that service. If we click on any test case status, it will show you in detail execution steps of that test. As i am logging execution details in html report hence i did not logged those details regular log file.