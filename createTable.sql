create table TBSETR_FINANCE_ADJUSTMENT_REQ
(
  NU_REQUEST               NUMBER(15) not null,
  CD_REQUEST_TYPE          CHAR(1) not null,
  DH_REQUEST               DATE not null,
  CD_REJECT_REASON         NUMBER(4),
  DT_SETTLEMENT_ADJUSTMENT DATE,
  VL_GROSS                 NUMBER(15,2),
  CD_USER_ID               VARCHAR2(20),
  CD_TECHNOLOGY_TYPE       NUMBER(2),
  CD_STATUS_REQUEST        NUMBER(2),
  NU_CUSTOMER              NUMBER(10) not null,
  NU_MOD_CUSTOMER          NUMBER(2) not null,
  NU_BATCH                 NUMBER(20) not null,
  CD_MOVEMENT_TYPE         NUMBER(3),
  CD_REFUND_STATUS_REQUEST NUMBER(2),
  CD_ADJUSTMENT_REASON     NUMBER(3),
  DC_ADJUSTMENT_COMMENTS   VARCHAR2(140),
  NU_LOAD_FILE_ID          NUMBER(20),
  CD_PRODUCT               NUMBER(4),
  CD_ENTRY_TYPE            NUMBER(5)
)
;

create table TBSETR_ADJUSTMENT
(
  NU_FINANCIAL_ADJUSTMENT     NUMBER(20) not null,
  DT_BATCH                    DATE not null,
  NU_MOD_CUSTOMER             NUMBER(2) not null,
  CD_ENTRY_TYPE               NUMBER(5) not null,
  NU_BATCH                    NUMBER(20) not null,
  CD_MOVEMENT_TYPE            NUMBER(3) not null,
  NU_NSU_REFUND               NUMBER(8),
  NU_TRANSACTION_ID_ORIGINAL  NUMBER(15),
  NU_CUSTOMER                 NUMBER(10) not null,
  VL_ADJUSTMENT_AMOUNT        NUMBER(15,2) not null,
  VL_NET_AMOUNT               NUMBER(15,2) not null,
  VL_DISCOUNT_AMOUNT          NUMBER(15,2) not null,
  DH_ADJUSTMENT               DATE not null,
  DT_SETTLEMENT_ADJUSTMENT    DATE,
  IN_SETTLEMENT               CHAR(1),
  NU_REQUEST                  NUMBER(15),
  DH_REQUEST                  DATE not null,
  CD_REQUEST_TYPE             CHAR(1),
  NU_LOAD_FILE_ID             NUMBER(20) not null,
  NU_TERMINAL                 VARCHAR2(8),
  CD_PRODUCT                  NUMBER(4),
  CD_ACQUIRER                 NUMBER(10),
  CD_ADJUSTMENT_REASON        NUMBER(3),
  CD_TECHNOLOGY_TYPE          NUMBER(2) not null,
  VL_IC_ADJUSTMENT            NUMBER(15,2),
  NU_INSTALLMENT_SEQ_ORIGINAL NUMBER(4) not null,
  NU_FINANCIAL_MOVEMENT       CHAR(40),
  VL_DISCOUNT_ORIG            NUMBER(15,2),
  VL_FLEXIBLE_TERM            NUMBER(15,2),
  VL_ISSUER_RATE_BASE         NUMBER(15,2) default 0 not null,
  VL_RATE_INCREMENTAL         NUMBER(15,2) default 0 not null
)
;

create table TBSETR_FINANCE_ADJUST_HIST
(
  NU_HISTORY               NUMBER(15) not null,
  NU_CUSTOMER              NUMBER(10) not null,
  NU_MOD_CUSTOMER          NUMBER(2) not null,
  CD_TECHNOLOGY_TYPE       NUMBER(2),
  CD_STATUS_REQUEST        NUMBER(2),
  CD_USER_ID               VARCHAR2(20) not null,
  DH_STATUS_CHANGED        DATE not null,
  VL_GROSS                 NUMBER(15,2),
  DT_SETTLEMENT_ADJUSTMENT DATE,
  CD_MOVEMENT_TYPE         NUMBER(3),
  CD_ADJUSTMENT_REASON     NUMBER(3),
  NU_REQUEST               NUMBER(15) not null,
  DH_REQUEST               DATE not null,
  CD_REQUEST_TYPE          CHAR(1) not null,
  CD_ENTRY_TYPE            NUMBER(5)
)
;

create table TBSETR_REL_MOVEMENT_ADJUSTMENT
(
  DT_BATCH                DATE not null,
  NU_MOD_CUSTOMER_MOV     NUMBER(2) not null,
  NU_FINANCIAL_ADJUSTMENT NUMBER(20) not null,
  DT_SETTLEMENT           DATE not null,
  NU_FINANCIAL_MOVEMENT   CHAR(40) not null,
  NU_MOD_CUSTOMER_ADJ     NUMBER(2) not null
)
;



create table TBSETR_REL_ADJUSTMENT_MOVEMENT
(
  DT_BATCH                DATE not null,
  NU_MOD_CUSTOMER_ADJ     NUMBER(2) not null,
  NU_FINANCIAL_ADJUSTMENT NUMBER(20) not null,
  DT_SETTLEMENT           DATE not null,
  NU_FINANCIAL_MOVEMENT   CHAR(40) not null,
  NU_MOD_CUSTOMER_MOV     NUMBER(2) not null
)
;


create table TBSETR_SETTLEMENT_MOVEMENT
(
  NU_FINANCIAL_MOVEMENT       CHAR(40) not null,
  DT_SETTLEMENT               DATE not null,
  NU_MOD_CUSTOMER             NUMBER(2) not null,
  DT_BATCH                    DATE not null,
  CD_PRODUCT                  NUMBER(4),
  CD_MOVEMENT_TYPE            NUMBER(3),
  NU_CUSTOMER                 NUMBER(10) not null,
  VL_MOVEMENT_NET             NUMBER(17,2),
  VL_MOVEMENT_GROSS           NUMBER(17,2),
  VL_DAILY_DISCOUNT_AMOUNT    NUMBER(17,2),
  NU_LOAD_FILE_ID             NUMBER(20),
  CD_FUNDING_CURRENCY         VARCHAR2(3),
  NU_FINANCIAL_MOVEMENT_TRACE CHAR(40),
  DT_SETTLEMENT_TRACE         DATE,
  NU_MOD_CUSTOMER_TRACE       NUMBER(2),
  CD_MOVEMENT_STATUS          NUMBER(2)
)
;

create table TBSETR_COMPLEMENT_MOVEMENT
(
  NU_FINANCIAL_MOVEMENT       CHAR(40) not null,
  DT_SETTLEMENT               DATE not null,
  NU_MOD_CUSTOMER             NUMBER(2) not null,
  QT_TRANSACTION              NUMBER(10) not null,
  VL_IC                       NUMBER(15,2) not null,
  DH_RECORD_CREATION          DATE default sysdate not null,
  NM_LOGIN_USER_CREATION      VARCHAR2(50) default 'STAR' not null,
  DH_RECORD_LAST_MODIFIED     DATE default sysdate not null,
  NM_LOGIN_USER_LAST_MODIFIED VARCHAR2(50) default 'STAR' not null,
  VL_FLEXIBLE_TERM            NUMBER(15,2),
  VL_DISCOUNT_AMOUNT          NUMBER(15,2),
  VL_DCC_REBATE               NUMBER(15,2),
  VL_ISSUER_RATE_BASE         NUMBER(15,2) default 0 not null,
  VL_RATE_INCREMENTAL         NUMBER(15,2) default 0 not null
)
;
