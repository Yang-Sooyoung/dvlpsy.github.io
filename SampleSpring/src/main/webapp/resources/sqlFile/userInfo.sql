--------------------------------------------------------
--  Drop  
--------------------------------------------------------
DROP TABLE "USER_INFO" cascade constraints;
DROP SEQUENCE "USER_INFO_SEQ";
--------------------------------------------------------
--  DDL for Sequence USER_INFO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "USER_INFO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table USER_INFO
--------------------------------------------------------

  CREATE TABLE "USER_INFO" 
   (	"USER_NO" NUMBER, 
	"USER_ID" VARCHAR2(200), 
	"USER_NM" VARCHAR2(200), 
	"USER_PW" VARCHAR2(200)
   ) ;
 

   COMMENT ON COLUMN "USER_INFO"."USER_NO" IS '사용자번호';
 
   COMMENT ON COLUMN "USER_INFO"."USER_ID" IS '사용자아이디';
 
   COMMENT ON COLUMN "USER_INFO"."USER_NM" IS '사용자이름';
 
   COMMENT ON COLUMN "USER_INFO"."USER_PW" IS '사용자비밀번호';
--------------------------------------------------------
--  DDL for Index USER_INFO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER_INFO_PK" ON "USER_INFO" ("USER_NO") 
  ;
--------------------------------------------------------
--  Constraints for Table USER_INFO
--------------------------------------------------------

  ALTER TABLE "USER_INFO" MODIFY ("USER_NO" NOT NULL ENABLE);
 
  ALTER TABLE "USER_INFO" MODIFY ("USER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "USER_INFO" MODIFY ("USER_NM" NOT NULL ENABLE);
 
  ALTER TABLE "USER_INFO" MODIFY ("USER_PW" NOT NULL ENABLE);
 
  ALTER TABLE "USER_INFO" ADD CONSTRAINT "USER_INFO_PK" PRIMARY KEY ("USER_NO") ENABLE;

--------------------------------------------------------
--  INSERT Default Data
--------------------------------------------------------
  INSERT INTO USER_INFO(USER_NO, USER_ID, USER_NM, USER_PW)
  VALUES (USER_INFO_SEQ.NEXTVAL, 'TEST', 'TESTER', '1234');