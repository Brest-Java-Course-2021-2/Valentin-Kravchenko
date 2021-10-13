# Software Requirements Specification
## 1. Purpose
The purpose of this project is to build a simple web-application to work with *bank accounts and associated them credit cards*.  
## 2. Scope
The application allows users to:  
* View and edit the list of bank accounts
* Filter the list of accounts by account number and client name  
* Add a new credit card to the selected bank account
* View and edit the list of credit cards
* Filter the list of cards by account number and card number
* Deposit money to the selected credit card
* Transfer money to the specified credit card
## 3. Overall description
### 3.1 Bank account requirements
**Users of the system should have the following management functions:**  
#### 3.1.1 View, filter, and edit the list of bank accounts:
##### Basic Action: 
  * The user selects the **Accounts** tab
  * The system generates and displays a list of all bank accounts
    <img alt="Slide 1" height="60%" src="https://user-images.githubusercontent.com/75541561/136829329-6ced4998-c778-4ba0-a382-9d81a49a7757.PNG" width="60%"/>
  * The list of bank accounts includes the following columns:
    * Bank account number
    * Client's first and last name
    * Registration date of the client in the system
    * Total number of credit cards associated with the account
    * Links to edit, remove the account, and add a new credit card to the account
##### Action to Filter the List of Bank Accounts:
  * The user enters a search pattern into each input field or one of them 
  * The user clicks the **APPLY**
  * The system validates the given search patterns
  * In the case, the search patterns are valid, the system generates and displays a list of bank accounts matching
    the search patterns  
    <img alt="Slide 2" height="60%" src="https://user-images.githubusercontent.com/75541561/136829371-e5c7e9ef-11a5-41e1-9b6c-998f8b8f1bf4.PNG" width="60%"/>
  * In the case, there are no bank accounts matching the search patterns, the system generates an info message  
  "No data found matching the given filter criteria"
  * In the case, the search patterns are invalid, the system generates error message "The given filter criteria 
  are incorrect"
  * To cancel the filter, the user clicks the **RESET** and the system generates and 
  displays a list of all bank accounts
  * The search pattern for the account number is entered in the field located above the Number column, and for the client 
  it is entered in the field located above the Client column
##### Action to Edit a Bank Account:
  * The user clicks the **Edit** in the line of the selected bank account
  * The system redirects the user to the page containing an account editing form
    <img alt="Slide 3" height="60%" src="https://user-images.githubusercontent.com/75541561/136829439-f5494296-cd82-4332-9d20-d613250ae615.PNG" width="60%"/>
  * The user changes the editable data
  * In the case, user clicks the **SAVE**:
    * The system validates the given data
    * In the case, the given data is valid:
      * The system updates this data in the database
      * In the case, an error occurred while updating data, the system generates an error message "Error saving data"  
      * In the case, the update was successful:
        * The system redirect the user to the accounts page
        * The system generates and displays a list of all bank accounts with updated data
    * In the case, the given data is invalid, the system generates an error message "The given data is incorrect"
  * In the case, user clicks the **CANCEL**, the system doesn't update the selected bank account and 
  redirects the user to the accounts page
##### Action to Remove a Bank Account:
  * The user clicks the **Remove** in the line of the selected bank account
  * The system checks the removed account for associated credit cards 
  * In the case, the removed account is associated to credit cards, the system generates an error message 
  "The bank account {its number is indicated} cannot be deleted" and displays a list of associated credit cards
  * In the case, the removed account isn't associated with credit cards:
    * The system asks the user to confirm the account deletion   
      <img alt="Slide 4" height="60%" src="https://user-images.githubusercontent.com/75541561/136829476-d925f040-473b-41d6-96ab-efb6eb07f660.PNG" width="60%"/>
    * If user confirms the account deletion: 
      * The system removes it from the database
      * In the case, an error occurred while deleting data, the system generates an error message "Error deleting data"
      * In the case, the deletion was successful, the system generates and displays a list of all bank accounts   
      with updated data
    * If user doesn't confirm the account deletion, the system doesn't remove the selected account
##### Action to Add a New Credit Card to the Bank Account:
  * The user clicks the **Add Card** in the line of the selected bank account
  * The system automatically generates a new credit card number
  * The system automatically sets the new credit card balance to zero
  * The system inserts this data in the database
  * In the case, an error occurred while inserting data, the system generates an error message "Failed to add the credit card"
  * In the case, the insertion was successful:
    * The system generates an info message "New credit card successfully added"
    * The system generates and displays a list of all bank accounts with new data  
#### 3.1.2 Create a New Bank Account
* Basic Action:
  * The user clicks the **CREATE NEW**
  * The system redirects the user to the page containing an account creating form
    <img alt="Slide 5" height="60%" src="https://user-images.githubusercontent.com/75541561/136701754-01b87197-20f9-431a-bf60-ae26c0c87f75.PNG" width="60%"/>
  * The system automatically generates a new bank account number
  * The system automatically sets a registration date corresponding to the current date
  * The user enters the client's first and last name
  * In the case, user clicks the **CREATE**:
    * The system validates the given data
    * In the case, the given data is valid:
      * The system inserts this data in the database
      * In the case, an error occurred while inserting data, the system generates an error message "Error saving data"
      * In the case, the insertion was successful:
        * The system redirect the user to the accounts page
        * The system generates an info message "New bank account successfully created"
        * The system generates and displays a list of all bank accounts with new data
    * In the case, the given data is invalid, the system generates an error message "The given data is incorrect" 
  * In the case, user clicks the **CANCEL**, the system doesn't create the account and redirects the user   
  to the accounts page
### 3.2 Credit card requirements
**Users of the system should have the following management functions:**
#### 3.2.1 View, filter, and edit the list of credit cards:
##### Basic Action:
* The user selects the **Cards** tab
    * The system generates and displays a list of all credit cards
      <img alt="Slide 6" height="60%" src="https://user-images.githubusercontent.com/75541561/136774292-be7e4fb4-bf0a-4c42-ad67-180c04306c32.PNG" width="60%"/>
    * The list of bank accounts includes the following columns:
        * Bank account number associated with the credit card 
        * Credit card number
        * The expiration date of the credit card 
        * Current credit card balance
        * Links to remove the card, deposit and transfer money
##### Action to Filter the List of Credit Cards:
  * The user enters a search pattern into each input field or one of them
  * The user clicks the **APPLY**
  * The system validates the given search patterns
  * In the case, the search patterns are valid, the system generates and displays a list of credit cards matching
    the search patterns
  * In the case, there are no credit cards matching the search patterns, the system generates an info message  
  "No data found matching the given filter criteria"
  * In the case, the search patterns are invalid, the system generates error message "The given filter criteria
  are incorrect"
  * To cancel the filter, the user clicks the **RESET** and the system generates and displays a list of all 
  credit cards
  * The search pattern for the account number is entered in the field located above the Account Number column,   
  and for the card number it is entered in the field located above the Card Number column
##### Action to Remove a Credit Card:
  * The user clicks the **Remove** in the line of the selected credit card
  * The system checks the current balance of the removed card
  * In the case, the current balance of the removed card is greater than zero, the system generates an error message  
  "The credit card {its number is indicated} cannot be deleted"
  * In the case, the current balance of the removed card is zero:
      * The system asks the user to confirm the card deletion
      * If user confirms the card deletion:
        * The system removes it from the database
        * In the case, an error occurred while deleting data, the system generates an error message "Error deleting data"
        * In the case, the deletion was successful, the system generates and displays a list of all credit cards   
          with updated data
  * If user doesn't confirm the card deletion, the system doesn't remove the selected card
##### Action to Deposit Money:
  * The user clicks the **Deposit** in the line of the selected bank account
  * The system redirects the user to the page containing a money deposit form
    <img alt="Slide 7" height="60%" src="https://user-images.githubusercontent.com/75541561/137110998-5469c7bc-f1c9-46e0-9331-153bb6a23d04.PNG" width="60%"/>
  * The user enters amount of money what will be added to the credit card balance
  * The user clicks the **ACCEPT**
  * The system validates the given amount of money
  * In the case, the given amount of money is correct:
    * The system increases the credit card balance by the given amount of money
    * The system updates this balance in the database
    * In the case, an error occurred while updating data, the system generates an error message "Failed to deposit money"
      * In the case, the update was successful:
        * The system redirect the user to the cards page
        * The system generates and displays a list of all credit cards with updated data
    * In the case, the given amount of money is incorrect, the system generates an error message "The given amount of money is incorrect"
  * In the case, user clicks the **CANCEL**, the system doesn't deposit money to the selected credit card and
  redirects the user to the cards page
##### Action to Transfer Money:
  * The user clicks the **Transfer** in the line of the selected bank account
  * The system redirects the user to the page containing a money transfer form
    <img alt="Slide 8" height="60%" src="https://user-images.githubusercontent.com/75541561/137111057-f5da3cb7-a0ea-4901-a49e-62698982634f.PNG" width="60%"/>
  * The user enters credit card number to transfer money 
  * The user enters amount of money what will be transferred to the specified credit card
  * The user clicks the **ACCEPT**
  * The system validates the credit card number and the given amount of money
  * In the case, the given data is correct:
    * The system checks the source credit card balance for the  amount of money debited 
    * In the case, the check was successful:
      * The system decreases the source credit card balance by the given amount of money
      * The system increases the target credit card balance by the given amount of money
      * The system updates these balances in the database
      * In the case, an error occurred while updating data:  
        * The system generates an error message "Failed to transfer money"
        * The system rolls back updates
      * In the case, the update was successful:
          * The system redirect the user to the cards page
          * The system generates and displays a list of all credit cards with updated data
    * In the case, the check failed, the system generates an error message "Money transfer isn't possible" 
  * In the case, the given data is incorrect, the system generates an error message "The given data is incorrect"
  * In the case, user clicks the **CANCEL**, the system doesn't transfer money to the specified credit card and
  redirects the user to the cards page
  