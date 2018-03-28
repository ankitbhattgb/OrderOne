$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("stepDef/frontpageSJ.feature");
formatter.feature({
  "line": 1,
  "name": "Attitude matters",
  "description": "",
  "id": "attitude-matters",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 2,
  "name": "I am an employee and its my attitude",
  "description": "",
  "id": "attitude-matters;i-am-an-employee-and-its-my-attitude",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I work in \"\u003ctime\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I meet \"\u003cguy\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I \"\u003cgreet\u003e\" him",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "attitude-matters;i-am-an-employee-and-its-my-attitude;",
  "rows": [
    {
      "cells": [
        "time",
        "guy",
        "greet"
      ],
      "line": 11,
      "id": "attitude-matters;i-am-an-employee-and-its-my-attitude;;1"
    },
    {
      "cells": [
        "morning",
        "officeboy",
        "greet"
      ],
      "line": 12,
      "id": "attitude-matters;i-am-an-employee-and-its-my-attitude;;2"
    },
    {
      "cells": [
        "noon",
        "newspaperboy",
        "skipgreeting"
      ],
      "line": 13,
      "id": "attitude-matters;i-am-an-employee-and-its-my-attitude;;3"
    },
    {
      "cells": [
        "evening",
        "cabdriver",
        "handshake"
      ],
      "line": 14,
      "id": "attitude-matters;i-am-an-employee-and-its-my-attitude;;4"
    },
    {
      "cells": [
        "night",
        "security",
        "hug"
      ],
      "line": 15,
      "id": "attitude-matters;i-am-an-employee-and-its-my-attitude;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "I am an employee and its my attitude",
  "description": "",
  "id": "attitude-matters;i-am-an-employee-and-its-my-attitude;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I work in \"morning\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I meet \"officeboy\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I \"greet\" him",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "morning",
      "offset": 11
    }
  ],
  "location": "Basictest.gn(String)"
});
formatter.result({
  "duration": 203856764,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "officeboy",
      "offset": 8
    }
  ],
  "location": "Basictest.wn(String)"
});
formatter.result({
  "duration": 334159,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "greet",
      "offset": 3
    }
  ],
  "location": "Basictest.tn(String)"
});
formatter.result({
  "duration": 407410,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "I am an employee and its my attitude",
  "description": "",
  "id": "attitude-matters;i-am-an-employee-and-its-my-attitude;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I work in \"noon\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I meet \"newspaperboy\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I \"skipgreeting\" him",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "noon",
      "offset": 11
    }
  ],
  "location": "Basictest.gn(String)"
});
formatter.result({
  "duration": 249958,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "newspaperboy",
      "offset": 8
    }
  ],
  "location": "Basictest.wn(String)"
});
formatter.result({
  "duration": 928094,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "skipgreeting",
      "offset": 3
    }
  ],
  "location": "Basictest.tn(String)"
});
formatter.result({
  "duration": 328496,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "I am an employee and its my attitude",
  "description": "",
  "id": "attitude-matters;i-am-an-employee-and-its-my-attitude;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I work in \"evening\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I meet \"cabdriver\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I \"handshake\" him",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "evening",
      "offset": 11
    }
  ],
  "location": "Basictest.gn(String)"
});
formatter.result({
  "duration": 289605,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cabdriver",
      "offset": 8
    }
  ],
  "location": "Basictest.wn(String)"
});
formatter.result({
  "duration": 558820,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "handshake",
      "offset": 3
    }
  ],
  "location": "Basictest.tn(String)"
});
formatter.result({
  "duration": 288094,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "I am an employee and its my attitude",
  "description": "",
  "id": "attitude-matters;i-am-an-employee-and-its-my-attitude;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I work in \"night\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I meet \"security\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I \"hug\" him",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "night",
      "offset": 11
    }
  ],
  "location": "Basictest.gn(String)"
});
formatter.result({
  "duration": 275257,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "security",
      "offset": 8
    }
  ],
  "location": "Basictest.wn(String)"
});
formatter.result({
  "duration": 262419,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hug",
      "offset": 3
    }
  ],
  "location": "Basictest.tn(String)"
});
formatter.result({
  "duration": 355304,
  "status": "passed"
});
});