# 일곱 난쟁이

## 문제

왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

## 입력

아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.



## 문제 이해

처음엔 백트래킹 이용하는 문제인줄 알고 어떻게 구현할지 막막했는데 생각을 바꾸니 매우 쉬운문제가 되었다.. 고 한다.

9명의 키를 모두 더한 값에서 2개의 임의의 값을 빼서 100이 되는 수를 찾은뒤 해당하는 2개의 값제외 나머지 출력



## 코드

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

int[] arr = new int[9];
int sum = 0;

for (int i = 0; i < 9; i++) {
  arr[i] = Integer.parseInt(br.readLine());
  sum += arr[i];
}

Arrays.sort(arr);

int a = 0;
int b = 0;
for (int i = 0; i < arr.length; i++) {
  for (int j = i + 1; j < arr.length; j++) {
    if ((sum - arr[i] - arr[j]) == 100) {
      a = arr[i];
      b = arr[j];
    }
  }
}

for (int i = 0; i < arr.length; i++) {
  if (arr[i] != a && arr[i] != b)
    bw.write( Integer.toString(arr[i]) + "\n");
}

bw.flush();
```

