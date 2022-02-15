## MySQL Settings (M1 macOS)

## 1. Install using brew

```bash
	brew serach mysql
	
	# install mysql 
	brew install mysql
	
	# error related to Rosetta2
	arch -arm64 brew install mysql
```

<br>

## 2. MySQL secure setting

```bash
# MySQL root, password settings
mysql_secure_installation
```

<br>

## 3.  Server start

```bash
#MySQL Server start
mysql.server start
```

<br>

## 4. Connect to server

``` bash
# connect using root account
mysql -uroot -p

# then type password
```

## 5. 비밀번호 정책 확인 및 변경

패스워드 정책 관련 설정 확인 ( mysql 8.0.x )

```mysql
SHOW VARIABLES LIKE 'validate_password.%';
```

```bash
+--------------------------------------+--------+
| Variable_name                        | Value  |
+--------------------------------------+--------+
| validate_password.check_user_name    | ON     |
| validate_password.dictionary_file    |        |
| validate_password.length             | 8      |
| validate_password.mixed_case_count   | 1      |
| validate_password.number_count       | 1      |
| validate_password.policy             | MEDIUM |
| validate_password.special_char_count | 1      |
+--------------------------------------+--------+
```



패스워드 정책 및 비밀번호 변경

```mysql
SET GLOBAL VARIABLES validate_password.policy=LOW;
SET GLOBAL VARIABLES validate_password.length=4;

alter user 'root'@'localhost' identified by '1234';
flush privileges;
```

