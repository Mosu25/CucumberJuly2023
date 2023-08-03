Feature: Products test

  Scenario Outline: Add to cart
    And user login into the application with "<username>" and "<password>"
    And user search for a "<book>"
    When user add the book to the cart
    Then the cart badge should get updated

    Examples:
      | username | password     | book            |
      | Mosu2023 | Welcome@2023 | Roomies         |
      | Mosu2023 | Welcome@2023 | The Simple Wild |


    Examples:
      | username | password     | book          |
      | Mosu2023 | Welcome@2023 | Robbie        |
      | Mosu2023 | Welcome@2023 | Catching Fire |