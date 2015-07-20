## Prerequisites

### Setup Git & GitLab 

Here a quick [step-by-step guide](docs/getting-started-with-git.md)!

### Other Software

* [Maven](https://maven.apache.org/download.cgi)
* Java JDK 8 
* Firefox

### Introduction to Working with Merge request and short-lived feature branches

All documented here: [docs/workflow.md](docs/workflow.md)

## Running the tests

1. From the project root directory run `./run.sh`
2. When overriding system properties use `mvn verify` followed by properties

## Help

* Various configuration parameters can be over written at command line. Refer the [System properties listed here](http://thucydides.info/docs/serenity/#_serenity_system_properties_and_configuration)

## Recommended Practices

* Scenarios should be written from third person point of you as that makes you think about who will be the customers 
  of your feature. See [Guidelines blog](https://blog.grandcentrix.net/gherkin-guidelines-and-best-practices/) 
* [Cucumber documentation](https://github.com/cucumber/cucumber/wiki)
* [How to write data driven tests](docs/WritingDataDrivenTests.md)  
* [Tagging features and scenarios](docs/TaggingFeaturesAndScenarios.md)

### Creating Page Objects

* Every page in the test journey on should have a page object
* Reusable modules on a page should be extracted as separate page objects which can be composed in bigger pages
* No assertions should be added in page objects, all assertions should be part of Step Definitions
* Avoid methods which expose native WebElements from page objects
* Methods on page objects should mimic user's operation
* Static Web Elements should be bound using @FindBy annotation which allows them to be cached
* XPath selector must be avoided. In the order of preference use id or otherwise css selector 
