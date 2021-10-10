# Software Requirements Specification
## 1. Purpose
The purpose of this project is to build a simple web-application to work with *bank accounts and associated them credit cards*.  
## 2. Scope
Key features of the application:  
* View and edit the list of bank accounts
* Filter the list of accounts by account number and client name  
* Add a new credit card to the selected bank account
* View and edit the list of credit cards
* Filter the list of cards by account number and card number
* Deposit money to the selected credit card
* Transfer money to the specified credit card
## 3. Overall description
### 3.1 Bank account characteristics
**Users of the system should have the following management functions:**  
#### 3.1.1 View, filter, and edit the list of bank accounts:
##### Basic Action: 
  * The user selects the **Accounts** tab
  * The system generates and displays a list of all bank accounts
    <img alt="Slide 1" height="60%" src="https://user-images.githubusercontent.com/75541561/136701674-b58d060d-c338-4f5f-b04a-9bfa4dbfae39.PNG" width="60%"/>
  * The list of bank accounts includes the following columns:
    * Account number
    * Client's first and last name
    * Registration date of the client in the system
    * Total number of credit cards associated with the account
    * Links to edit, remove the account, and add a new credit card to the account
##### Action to Filter the List of Bank Accounts:
  * The user enters a search pattern into each input field or one of them 
  * The user clicks the **APPLY**
  * The system validates the given search patterns
  * In the case, the search patterns are valid, the system generates and displays a list of bank accounts matching
    the search patterns or the info message "No data found matching the given filter criteria"  
    <img alt="Slide 2" height="60%" src="https://user-images.githubusercontent.com/75541561/136701730-6dffdb4d-6445-47b0-bea2-8ddc82a42557.PNG" width="60%"/>
  * In the case, the search patterns are invalid, the system generates error message "The given filter criteria 
  are incorrect"
  * To cancel the filter, the user clicks the **RESET** and the system generates and 
  displays a list of all bank accounts
  * The search pattern for the account number is entered in the field located above the Number column, and for the client 
  it is entered in the field located above the Client column
##### Action to Edit a Bank Account:
  * The user clicks the **Edit** in the line of the selected bank account
  * The system redirects the user to the page containing an account editing form
    <img alt="Slide 3" height="60%" src="https://user-images.githubusercontent.com/75541561/136701736-d74e8dc2-af68-4988-a85a-945739a3e21d.PNG" width="60%"/>
  * The user changes the editable data
  * In the case, user clicks the **SAVE**:
    * The system validates the given data
    * In the case, the given data is valid:
      * The system updates it in the database
      * The system redirect the user to the accounts page
      * The system generates and displays a list of all bank accounts with updated data
    * In the case, the given data is invalid, the system generates error message "The given data are incorrect"
  * In the case, user clicks the **CANCEL**, the system doesn't update the account and 
  redirects the user to the accounts page
##### Action to Remove a Bank Account:
  * The user clicks the **Remove** in the line of the selected bank account
  * The system checks the deleted account for associated credit cards 
  * In the case, the deleted account is associated to credit cards, the system generates error message 
  "The account {its number is indicated} cannot be deleted" and displays a list of associated credit cards
  * In the case, the deleted account isn't associated with credit cards:
    * The system asks the user to confirm the account deletion   
      <img alt="Slide 4" height="60%" src="https://user-images.githubusercontent.com/75541561/136701745-73d414b6-be01-409c-9a75-8c3c2d7b46c4.PNG" width="60%"/>
    * If user confirms the account deletion: 
      * The system removes it in the database
      * The system generates and displays a list of all bank accounts with updated data
    * If user doesn't confirm the account deletion, the system doesn't remove the account
##### Action to Add a New Credit Card to the Bank Account:
  * The user clicks the **Add Card** in the line of the selected bank account
  * The system automatically generates a new credit card number
  * The system automatically sets the new credit card balance to zero
  * The system inserts these data in the database
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
    * The system inserts these data in the database
    * The system redirect the user to the accounts page
    * The system generates and displays a list of all bank accounts with new data
  * In the case, user clicks the **CANCEL**, the system doesn't create the account and
  redirects the user to the accounts page