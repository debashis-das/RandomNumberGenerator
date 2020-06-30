# RandomNumberGenerator

You can run the application using command
```
./mvnw spring-boot:run
```
To test the application 
```
./mvnw test
```

This application generates numbers randomly from 0 to 1000 and prints in in the log in format like :

```
2020-06-30 15:38:08.833  INFO 5695 --- [        Timer-0] c.a.r.RandomNumberGenerator              : [153, 522, 786, 671, 304]
2020-06-30 15:38:09.834  INFO 5695 --- [        Timer-0] c.a.r.RandomNumberGenerator              : [164, 861, 979, 395, 535]
2020-06-30 15:38:10.840  INFO 5695 --- [        Timer-0] c.a.r.RandomNumberGenerator              : [661, 602, 825, 594, 708]
2020-06-30 15:38:11.844  INFO 5695 --- [        Timer-0] c.a.r.RandomNumberGenerator              : [218, 431, 994, 365, 946]
```

Now for the 2nd part of the question we need to display numbers generated in last 5/10/30 mins. Api is as follows :
```
curl --location --request GET 'http://<server_ip>:8080/randomNumber/{300}'
```
Param : 300 is the value in seconds

## RESPONSE :
```
[
  [888,474,365,488,976],
  [346,48,964,286,225],
  [321,714,638,435,161],
  [738,185,97,336,330]
  .
  .
  No. of seconds expected
]
```

## Assumptions : 
1. Numbers generated in will be from 0 to 1000 (You can modify this in Constants.java)
2. API for returning response every 5/10/30 mins can be changed to any values in seconds but I have restricted it to only 
   (5 mins : 300 sec, 10 mins : 600 sec, 30 min : 1800 sec). But if you want to make changes you can whitelist them in Constants.java
3. Values per second is also configurable in Constants.java.
4. I have done an assumption that the read and write in an array will not happen at the same nano-seconds which might result in a stale data. 
   This case is a rare scenario to happen.
