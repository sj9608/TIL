## MySQL Settings (M1 macOS)

## 1. Install using brew

```bash
	brew serach mysql
	
	# install mysql 
	brew install mysql
	
	# error related to Rosetta2
	arch -arm64 brew install mysql
```

## 2. MySQL secure setting

```bash
# MySQL root, password settings
mysql_secure_installation
```

## 3.  Server start

```bash
#MySQL Server start
mysql.server start
```

## 4. Connect to server

``` bash
# connect using root account
mysql -uroot -p

# then type password
```

