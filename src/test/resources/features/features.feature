Feature: Exchange key and process top up

  Scenario: Exchange key
    Given Call Api exchange key
    When Receive Response
    Then Validate Response with

  Scenario Outline: Topup
    Given Call Api topup with request "<Request>"
    When Receive Response
    Then Validate Response with type xml
    Examples:
    | Request     |
    | request.xml |

  Scenario Outline: Topup response invalid input
    Given Call Api topup with request "<Request>" but not included token
    When Receive Response
    Then Validate Response with type xml
    Examples:
      | Request     |
      | request.xml |
