#Akshaya....
@checkout
Feature: validate checkout with datatable
@checkout1 
  Scenario: login with single user and purchase multiple products
    #These things should run only once
    Given open browser as "chrome"
    When enter url as "https://djangovinoth.pythonanywhere.com/login/"
    And enter username as "Akshayaachu"
    When enter password as "Aswin@1a"
    And click login button
    Then navigate to checkout page as "https://djangovinoth.pythonanywhere.com/simpleform/"
    When checkout place order with details
     # | PRODUCTNAME       | MOBILE NUM | EMAIL    | PROD CAT    | PROD QUA | PURCHASER NAME |
      | samsung mobiles   |      11111 | pass@123 | Electronics |        1 | Akshaya        |
      | LG washingmachine |      11111 | pass@123 | Electronics |        1 | Akshaya        |
      | sony Tv           |      11111 | pass@123 | Electronics |        1 | Akshaya        |
      | Refrigerator      |      11111 | pass@123 | Electronics |        1 | Akshaya        |
    And logout
@checkout2 
  Scenario: login with single user and purchase multiple products
    #These things should run only once
    Given open browser as "chrome"
    When enter url as "https://djangovinoth.pythonanywhere.com/login/"
    And enter username as "Akshayaachu"
    When enter password as "Aswin@1a"
    And click login button
    Then navigate to checkout page as "https://djangovinoth.pythonanywhere.com/simpleform/"
    When checkout place order with details in map format
      | PRODUCTNAME       | MOBILE NUM | EMAIL    | PROD CAT    | PROD QUA | PURCHASER NAME |
      | samsung mobiles   |      11111 | pass@123 | Electronics |        1 | Akshaya        |
      | LG washingmachine |      11111 | pass@123 | Electronics |        1 | Akshaya        |
      | sony Tv           |      11111 | pass@123 | Electronics |        1 | Akshaya        |
      | Refrigerator      |      11111 | pass@123 | Electronics |        1 | Akshaya        |
    And logout