$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Feature/SportsTakFunctionalityValidation.feature");
formatter.feature({
  "name": "Sportstak functionalities validations",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@xyz"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Validating and verifying the functionality of Sportstak",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Open chrome browser and enter URL",
  "keyword": "Given "
});
formatter.step({
  "name": "Click on \"\u003ctab\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "tab",
        "PageNo",
        "Col1",
        "Col2",
        "Col3",
        "Col4",
        "tab1",
        "Page_number",
        "WebStoryNo"
      ]
    },
    {
      "cells": [
        "Cricket",
        "3",
        "Light",
        "Dark",
        "Dark",
        "Light",
        "Web Stories",
        "1",
        "1"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Validating and verifying the functionality of Sportstak",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@xyz"
    }
  ]
});
formatter.step({
  "name": "Open chrome browser and enter URL",
  "keyword": "Given "
});
formatter.match({
  "location": "SportsTakTest.open_chrome_browser_and_enter_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on \"Cricket\"",
  "keyword": "And "
});
formatter.match({
  "location": "SportsTakTest.click_on(String)"
});
formatter.result({
  "status": "passed"
});
});