-- 거래처 영업관리 프로그램
DROP SCHEMA IF EXISTS donghun2;

-- 거래처 영업관리 프로그램
CREATE SCHEMA donghun2;

-- 영원사원
CREATE TABLE donghun2.employee (
	code  CHAR(4)  NOT NULL COMMENT '사원코드', 
	name  CHAR(11) NOT NULL COMMENT '사원명', 
	grade CHAR(1)  NOT NULL COMMENT '사원등급' 
)
COMMENT '영원사원';

-- 영원사원
ALTER TABLE donghun2.employee
	ADD CONSTRAINT PK_employee
		PRIMARY KEY (code);

-- 제품
CREATE TABLE donghun2.product (
	code       CHAR(4)  NOT NULL COMMENT '제품코드',
	name       CHAR(11) NOT NULL COMMENT '제품명',
	saleprice  INT      NOT NULL COMMENT '판매정가', 
	origiprice INT      NOT NULL COMMENT '판매원가' 
)
COMMENT '제품';

-- 제품
ALTER TABLE donghun2.product
	ADD CONSTRAINT PK_product
		PRIMARY KEY (code);

-- 거래처
CREATE TABLE donghun2.customer (
	code  CHAR(4)  NOT NULL COMMENT '거래처코드',
	name  CHAR(11) NOT NULL COMMENT '거래처명',
	grade CHAR(1)  NOT NULL COMMENT '거래처등급'
)
COMMENT '거래처';

-- 거래처
ALTER TABLE donghun2.customer
	ADD CONSTRAINT PK_customer PRIMARY KEY (code);

-- 거래내역
CREATE TABLE donghun2.saleinfo (
	ecode     CHAR(4) NOT NULL COMMENT '사원코드',
	pcode     CHAR(4) NOT NULL COMMENT '제품코드', 
	ccode     CHAR(4) NOT NULL COMMENT '거래처코드', 
	quantity  INT     NOT NULL COMMENT '판매수량', 
	unitprice INT     NOT NULL COMMENT '판매단가', 
	saleDate  DATE    NOT NULL COMMENT '거래일자' 
)
COMMENT '거래내역';

-- 거래내역
ALTER TABLE donghun2.saleinfo
	ADD CONSTRAINT FK_employee_TO_saleinfo
		FOREIGN KEY (ecode) REFERENCES donghun2.employee (code);

-- 거래내역
ALTER TABLE donghun2.saleinfo
	ADD CONSTRAINT FK_product_TO_saleinfo
		FOREIGN KEY (pcode) REFERENCES donghun2.product (code);

-- 거래내역
ALTER TABLE donghun2.saleinfo
	ADD CONSTRAINT FK_customer_TO_saleinfo
		FOREIGN KEY (ccode)	REFERENCES donghun2.customer (code);

delete from customer where code = 1;


insert into product values 
('P001','아메리카노',3000,1000),
('P002','카푸치노',4000,2000),
('P003','카페모카',5000,25000),
('P004','마끼아또',6000,3000);

select * from product;

