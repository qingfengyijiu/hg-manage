-- Create table
create table NEW_S_USER
(
  id                      VARCHAR2(32) not null,
  password                VARCHAR2(32),
  username                VARCHAR2(32),
  account_non_expired     CHAR(1) default 'F',
  account_non_locked      CHAR(1) default 'F',
  credentials_non_expired CHAR(1) default 'F',
  enabled                 CHAR(1) default 'F'
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints 
alter table NEW_S_USER
  add constraint PK_NEW_S_USER primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table NEW_S_USER
  add constraint UNIQUE_NEW_S_USER_USERNAME unique (USERNAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
