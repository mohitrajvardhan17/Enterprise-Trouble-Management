### Identify user table name.
    ETM_People
### Identify all the required column (NAME, TYPE, SIZE, REQUIRED, IS NULL, DEFAULT)
    NAME= Id, TYPE= bigint, SIZE= 19 ,REQUIRED= primary, ISNULL= no, DEFAULT= none

    NAME= Username,TYPE= varchar,SIZE= 7, REQUIRED= yes, ISNULL= no, , DEFAULT= none
    NAME= FirstName,TYPE= varchar,SIZE= 255, REQUIRED= yes, ISNULL= no, , DEFAULT= none
    NAME= LastName,TYPE= varchar,SIZE= 255, REQUIRED= no, ISNULL= yes, , DEFAULT= none
    NAME= Email, TYPE= varchar,SIZE= 255, REQUIRED= yes, ISNULL= no, , DEFAULT= none

    NAME= Account(table), TYPE= varchar,SIZE= -1, REQUIRED= yes, ISNULL= no, , DEFAULT= none //Keep restriction till 3
    NAME= Contact(table), TYPE= varchar,SIZE= -1, REQUIRED= yes, ISNULL= no, , DEFAULT= none //Keep restriction till 3
    NAME= Role(table), TYPE= varchar ,SIZE= -1, REQUIRED= yes, ISNULL= no, , DEFAULT= read // Functional Role(MANAGER,AOM,...)
    NAME= Permission(table), TYPE= varchar ,SIZE= -1, REQUIRED= yes, ISNULL= no, , DEFAULT= read // Functional Role(CRUD permission)
    NAME= Application(table), TYPE= varchar ,SIZE= -1, REQUIRED= yes, ISNULL= no, , DEFAULT= none
    NAME= WorkinghHour(table), TYPE= varchar ,SIZE= -1, REQUIRED= yes, ISNULL= no, , DEFAULT= none
    NAME= SPOC(table), TYPE= varchar ,SIZE= -1, REQUIRED= yes, ISNULL= no, , DEFAULT= none
    NAME= Locale(table), TYPE= varchar ,SIZE= -1, REQUIRED= yes, ISNULL= no, , DEFAULT= none // Refer Salesfore documentation
    NAME= Manager(Username),TYPE= varchar,SIZE= 7, REQUIRED= no, ISNULL= no, , DEFAULT= none // User with Manager Role 

    NAME= IsActive, TYPE= BOOLEAN ,SIZE= 3, REQUIRED= yes, ISNULL= no, , DEFAULT= yes
    NAME= CreaatedBy(Username),TYPE= varchar,SIZE= 7, REQUIRED= yes, ISNULL= no, , DEFAULT= none 
    NAME= CreaatedDate(Username),TYPE= timestamp,SIZE= 20, REQUIRED= yes, ISNULL= no, , DEFAULT= none
    NAME= ModifiedBy(Username),TYPE= varchar,SIZE= 7, REQUIRED= no, ISNULL= no, , DEFAULT= none 
    NAME= ModifiedDate(Username),TYPE= timestamp,SIZE= 20, REQUIRED= no, ISNULL= no, , DEFAULT= none
    NAME= Description,TYPE= varchar,SIZE= 255, REQUIRED= no, ISNULL= no, , DEFAULT= none
### Create database table as per the finalized columns.
    NAME= Id

    NAME= Username
    NAME= FirstName
    NAME= LastName
    NAME= Email

    NAME= Account(table)
    NAME= Contact(table)
    NAME= Role(table)
    NAME= Permission(table)
    NAME= Application(table)
    NAME= WorkinghHour(table)
    NAME= SPOC(table)
    NAME= Locale(table)
    NAME= Manager(Username)

    NAME= IsActive
    NAME= CreaatedBy
    NAME= CreaatedDate
    NAME= ModifiedBy
    NAME= ModifiedDate
    NAME= Description
    
### Create the CRUD code for user table
### Create the web-page for user profile.
### Test the user profile & table.
