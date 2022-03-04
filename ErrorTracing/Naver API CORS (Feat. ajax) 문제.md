# Naver API CORS (Feat. ajax) 문제

### 0. 상황

위치 기반의 서비스를 만들어 보기 위해서 중요한게 위치를 아는 것이다. 모바일의 경우에는 gps 모듈이 있기 때문에 정확한 위치를 잡아 낼 수 있지만 web의 경우에 어떻게 처리하는지 궁금했다.

처음에 찾았을 때 IP를 기반으로 위치 정보를 찾을 수 있는 Naver의 GeoLocation API를 이용하고자 했다. 이를 위해선 사설 IP(private IP) 가 아닌 정확한 나의 IP가 필요했는데 브라우저에서 이 정보를 알아내기 위해선 IP를 찾는 API를 이용해야 했다.

그 중에 ipify api 를 이용해 IP 정보를 받아오고 GeoLocation 서비스를 작동 시켰는데 정확도가 생각보다 낮아서 (Naver Web에서도 위치정보는 해당 API를 사용하는듯 정확도가 낮은 같은 결과가 나왔음) 추가로 방법을 찾은 결과

ES6 에서 제공하는 navigator.geolocation.getCurrentPosition 내장 기능을 이용했다. 결과로 **위도와 경도를 알아 낼 수 있었고 위치정보를 알기 위해선 Naver 에서 제공하는 Reverse Geocode API를 이용해야 했다.**

**API 서비스를 신청하고 클라이언트 키, 시크릿을 헤더에 넣고 ajax로 GET 메서드와 파라미터를 요청했지만 결과는 CORS 왜 이런 에러가 발생했는지 알아보았다.**



### 1. 에러 발생

<img width="924" alt="image" src="https://user-images.githubusercontent.com/52594760/156765993-51a7956f-7dba-42c8-b45a-51319a68fdaf.png">



### 2. 작성 코드

```javascript
$(document).ready(() => {
            navigator.geolocation.getCurrentPosition((data) => {

                console.log(data);

                const lon = data.coords.longitude;
                const lat = data.coords.latitude;
                const coords = lon + ',' + lat;

                $.ajax({
                    url: "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc",
                    type: "GET",
                    data: {
                        "coords": coords,
                        "output": "json"
                    },
                    crossDomain: true,
                    headers: {
                        "X-NCP-APIGW-API-KEY-ID": "CLIENT_KEY",
                        "X-NCP-APIGW-API-KEY": "CLIENT_SECRET",
                        "Access-Control-Allow-Origin": "*",
                        "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS",
                        "Access-Control-Allow-Headers": "Content-Type, X-Requested-With, Authorization",
                    },
                    success: (result) => {
                        console.log(result);
                    },
                    error: (e, msg) => {
                        console.log(e);
                        console.log(msg);
                    } 
                });

            }), (e ,msg) => {
                console.log(e);
                console.log(msg);
            }
        });
```



### 3. 발생 원인

<img width="766" alt="image" src="https://user-images.githubusercontent.com/52594760/156765684-f065867a-32ac-4b68-8886-b3e8293c68dc.png">



<img width="721" alt="image" src="https://user-images.githubusercontent.com/52594760/156767917-46ccb929-152a-4c5a-925d-2318b9f1d25b.png">



<img width="953" alt="image" src="https://user-images.githubusercontent.com/52594760/156767771-f7935f23-de27-4c33-b5bf-ee63207c5298.png">

마지막 사진처럼 이미 2016년에 나와 같은 에러를 겪은 사람이 있었다.. 포스팅 시점에 무려 6년이상 지난글 이지만 도움이 됐다!



### 4. 해결 방법

원인 측에서도 봤던것 처럼 새로운 인증방식의 보안이 강화되어 클라이언트 쪽 (js) 에선 처리할 수 없도록 막아 놓은 것 같다. sample 코드를 참고해서 서버쪽 java에서 HttpURLConnection으로 처리 하니 결과가 잘 나온다. 

```java
String clientId = "CLIENT_ID";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "CLIENT_SECRET";//애플리케이션 클라이언트 시크릿값";
        try {
            String coords = URLEncoder.encode("위도,경도", "UTF-8");
            String apiURL = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?coords=" + coords + "&output=json";

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
```

