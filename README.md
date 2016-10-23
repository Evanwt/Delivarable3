# Delivarable3


Description

   While at the very beginning , I selected the geckodriver and firefox broswer to test the E-commerce website, but
it always encountered some error over and over again. I consulted some of my classmates who ran successfully, they told
me that maybe because the version of the browser was out of date.

   So I decided to use the Chrome broswer for testing the website and the driver was using the corresponding one, namely chromedriver.
 Initially, I also failed, I searched the reason on stackoverflow, and got the solution that the jdk should be used version 1.8.
  Also we need to set the appropriate waiting time for the broswer to load. 


  Then I ran the test successfully, there were 3 storys in total, and each of the story contained 3 scenarios. 

  The first story was user Log in module.
   
   As a user,
   I want to login the webSite,
   So that I can buy products from the website using my account name.

   Scenarios 1
   
   Given a null value ,
   When I try to log in with the null value,
   Then it will prompt Error info.

   Scenarios 2
   Given a valid username and invalid password,
   When I try to log in with those credentials,
   Then I should recieve an Error info.


   Scenarios 3
   Given a invalid username and valid password,
   When I try to log in with those credentials,
   Then it will prompt Error info again.


   The second story was checkout module.

     As a user,
     I want to select the products that I want to buy, and put it in the shopping cart,
     So that I know how much money I should pay.
     
    Scenarios 1

     Given the product name, 
	 When I try to put it in the shopping cart and change the quantity to 5, 
	 Then I should recieve the message shown that the total cost is 60.

	 Scenarios 2

	 Given the products name, and put it in the shopping cart,
	 When I  Click go to checkout ,I remove it,
	 Then the cart should be empty.

	 Scenarios 3
     
     Given a product name, and put it in the shopping cart,
     When I decide to continue shopping,
	 Then I should stay at the page.


   The third story was Item search module.

   
     As a user, 
     I want to search the products that I want to buy.
     So that I will know much about this kind of product
     
     Scenarios 1
           
     Given the words that is not related to any products of the website,
     When I try to type in the words in search bar and press the 'enter',
     Then  the webpage returned nothing.
     
     Scenarios 2
           
     Given I the key word 'iPad'
     When I try to type in the words in search bar and press 'enter',
     Then there will be 3 results returned.

     Scenarios 3

     Given I searched the key word 'iPhone'
     When I try to type in the words in search bar and press 'enter',
     Then there will be 5 results returned.



  




