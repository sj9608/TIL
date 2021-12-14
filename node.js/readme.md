# M1 NVM Setting

## 1. install nvm using homebrew

```bash
brew install nvm
```



## 2. terminal setting

<img width="971" alt="image" src="https://user-images.githubusercontent.com/52594760/145947466-05745466-85d1-46c9-a0cf-bddb79cc656f.png">

```bash
mkdir ~/.nvm

vi ~/.zshrc
```

```.zshrc
# .zshrc
# NVM Home Settings

export NVM_DIR="$HOME/.nvm"
[ -s "/opt/homebrew/opt/nvm/nvm.sh" ] && \. "/opt/homebrew/opt/nvm/nvm.sh"  # This loads nvm
[ -s "/opt/homebrew/opt/nvm/etc/bash_completion.d/nvm" ] && \. "/opt/homebrew/opt/nvm/etc/bash_completion.d/nvm"  # This loads nvm bash_completion
```

```bash
source ~/.zshrc
```



## 3. nvm version check, install

```bash
nvm -v
```



install on M1 (open terminal using Rosetta)

```bash
nvm install --lts
```



```bash
# check installed node.js list 
nvm ls

# use specific version
nvm use <version>
```

