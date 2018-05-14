### Identify user table name.
    ETM_People
### Identify all the required column (NAME, TYPE, SIZE, REQUIRED, IS NULL, DEFAULT)
    (Username, CHARACTER, 30, Yes, NOT NULL, No)
    (Signum_ID, VARCHAR, 7, Yes, NOT NULL, No)
    (First_Phone_Number, INTEGER, 10, Yes, NOT NULL, No)
    (Second_Phone_Number, BIGINT, 19, No, NULL, No)
    (ECN_Phone_Number, BIGINT, 19, No, NULL, No)
    (Email_Address, CHARACTER, N, Yes, NOT NULL, No)
    (Profile_Status, BOOLEAN, 3, Yes, NOT NULL, Yes)
    (Profile_Permission, VARCHAR, 10, Yes, NOT NULL, Yes)
    (Linked_Tool_Name, VARCHAR, 10, Yes, NOT NULL, Yes)
    (Availability Time, CHARACTER, 20, Yes, NOT NULL, Yes)
    (Availability Duration, TIMESTAMP, 20, Yes, NOT NULL, Yes)
    (Manager_Name, CHARACTER, 30, Yes, NOT NULL, No)
    (Manager_Signum_ID, VARCHAR, 7, Yes, NOT NULL, No)
    
### Create database table as per the finalized columns.
    Username
    Signum_ID
    First_Phone_Number
    Second_Phone_Number
    ECN_Phone_Number
    Email_Address
    Profile_Status
    Profile_Permission
    Linked_Tool_Name
    Availability_Time
    Availability_Duration
    Manager_Name
    Manager_Signum_ID
    
### Create the CRUD code for user table
### Create the web-page for user profile.
### Test the user profile & table.
