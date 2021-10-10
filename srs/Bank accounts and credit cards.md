# Software requirements specification
## 1. Purpose
The purpose of this project is to build a simple web-application to work with *bank accounts and associated them credit cards*.  
## 2. Scope
Key features of the application:  
* view and edit the list of bank accounts
* filter the list of accounts by account number and client name  
* add a new credit card to the selected bank account
* view and edit the list of credit cards
* filter the list of cards by account number and card number
* deposit money to the selected credit card
* transfer money to the specified credit card
## 3. Overall description
### 3.1 Bank account characteristics
####Users of the system should have the following management functions:  
####3.1.1 View, filter, and edit the list of bank accounts:
#####Basic Action: 
  * The user selects the <span style="color:blue">Accounts</span> tab
  * The system generates and displays a list of all bank accounts
  <img src="D:\BJC2021\Software requirements specification\Слайд1.PNG"/>
  * The list of bank accounts includes the following columns:
    * Account number
    * Client's first and last name
    * Registration date of the client in the system
    * Total number of credit cards associated with the account
    * Links to edit, remove the account, and add a new credit card to the account
#####Action to Filter the List of Bank Accounts:
  * The user enters into each input field or one of them a search pattern
  * The user clicks the <span style="color:blue">APPLY</span>
  * The system validates the given search patterns
  * In the case, the search patterns are valid, the system generates and displays a list of bank accounts matching 
  the search patterns or the info message "No data found matching the given filter criteria"
  <img src="D:\BJC2021\Software requirements specification\Слайд2.PNG"/>
  * In the case, the search patterns are invalid, the system generates error message "The given filter criteria 
  are incorrect"
  * To cancel the filter, the user clicks the <span style="color:blue">RESET</span> and the system generates and 
  displays a list of all bank accounts
  * The search pattern for the account number is entered in the field located above the Number column, and for the client 
  it is entered in the field located above the Client column
#####Action to Edit a Bank Account:
  * The user clicks the <span style="color:blue">Edit</span> in the line of the selected bank account
  * The system redirects the user to the page containing an account editing form
  <img src="D:\BJC2021\Software requirements specification\Слайд3.PNG"/>
  * The user changes editable data
  * In the case user clicks the <span style="color:blue">SAVE</span>:
    * The system validates the given data
    * In the case, the given data is valid:
      * The system updates it in the database
      * The system redirect the user to the accounts page
      * The system generates and displays a list of all bank accounts with updated data
    * In the case, the given data is invalid, the system generates error message "The given data are incorrect"
  * In the case user clicks the <span style="color:blue">CANCEL</span>, the system doesn't update the account and 
  redirects the user to the accounts page
#####Action to Remove a Bank Account:
  * The user clicks the <span style="color:blue">Remove</span> in the line of the selected bank account
  * The system checks the deleted account for associated credit cards 
  * In the case, the deleted account is associated to credit cards, the system generates error message 
  "The account {its number is indicated} cannot be deleted" and displays a list of associated credit cards
  * In the case, the deleted account isn't associated with credit cards:
    * The system asks the user to confirm the deletion of the account
    <img src="D:\BJC2021\Software requirements specification\Слайд4.PNG"/>
    * If user confirms the account deletion: 
      * The system removes it in the database
      * The system generates and displays a list of all bank accounts with updated data
    * If user doesn't confirm the account deletion, the system doesn't remove the account
#####Action to Add a New Credit Card to the Bank Account:
  * The user clicks the <span style="color:blue">Add Card</span> in the line of the selected bank account
  * The system automatically generates a new credit card number
  * The system automatically sets the new credit card balance to zero
  * The system inserts these data in the database
  * The system generates and displays a list of all bank accounts with new data  
####3.1.2 Create a new bank account
* Basic Action:
  * The user clicks the <span style="color:blue">CREATE NEW</span>
  * The system redirects the user to the page containing an account creating form
    <img src="D:\BJC2021\Software requirements specification\Слайд5.PNG"/>
  * The system automatically generates a new bank account number
  * The system automatically sets a registration date corresponding to the current date
  * The user enters the client's first and last name
  * In the case, user clicks the <span style="color:blue">CREATE</span>:
    * The system inserts these data in the database
    * The system redirect the user to the accounts page
    * The system generates and displays a list of all bank accounts with new data
  * In the case, user clicks the <span style="color:blue">CANCEL</span>, the system doesn't create the account and
  redirects the user to the accounts page