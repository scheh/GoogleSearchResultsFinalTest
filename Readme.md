# Google search test
***
## Description
***
This test:
1. Search results by "Selenium" word.
2. Then scrolling down to the end of the page and search all elements are present on the current Page 1
3. Click on Page 2 icon
4. Go to search Page 2
5. Then scrolling down to the end of the page and search all elements are present on the current Page 2
***
##
Test running
***
You need the next utilities to successful test run:
1. Install Java SDK (JDK).
2. Install Jenkins.
***
##
Files description
***
1. Readme - current file with project description.
2. pom.xml - page, which runs Maven and describes libraries we need to use for our tests.
3. google-search.xml - file which create test suits.
4. .gitignore - file formats which shouldn't be added to the git.
5. GoogleSearchResultTest - our test with asserts on the pages..
6. GoogleSearchBaseTest - file with Before and After methods.
7. - Before Method contains method which has method for checking on different browsers + Optional method which will be used if our google-search.xml file is absent.
8. - After Method contains method for closing our browser after the tests are finished.
9. GoogleSearchResultPage2 - PageFactory pattern for Java Class with search page 2 elements initialization.
10. GoogleSearchResultPage1 - PageFactory pattern for Java Class with search page 1 elements initialization.
11. GooglePage - PageFactory pattern for Java Class with Google Home page elements initialization.
12. GoogleBasePage - constructor for webDriver initialization and using on all other pages.
