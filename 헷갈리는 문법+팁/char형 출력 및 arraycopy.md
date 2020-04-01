## char형 출력 및 arraycopy

```java
package Class_And_Object; 
import java.util.Arrays; 
class ArrayTest { 
  public static void main(String[] args)
  {
    char[] abc = { 'A', 'B', 'C', 'D'}; 
    char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}; 
    System.out.println(abc); // ABCD 출력
    System.out.println(num); // 0123456789 출력
      
    // 배열 abc와 num을 붙여서 하나의 배열(result)로 만든다. 
    char[] result = new char[abc.length+num.length]; 
    System.arraycopy(abc, 0, result, 0, abc.length);
    System.out.println(result);	// ABCD 출력
    System.arraycopy(num, 0, result, abc.length, num.length); 
      
    System.out.println("result : "+ result);// 1. result : [C@7852e922 출력
    System.out.println(result); 			// 2. ABCD0123456789 출력
 } 
} 
```

위의 코드에서

1과 2의 출력같이 다른 이유는

1. **System.out.println("result: " + result);**

   \- String 값인 "result: " 과 + 연산을 하기 위해 암시적으로 result.toString() 을 호출하여 더한 String 값을 호출하고 있다.

2. **System.out.println(result);** 

   \- char[] array 를 그대로 출력하는 println(char[] x) 메소드를 호출했다. 위와 같이 다른 println 메소드를 호출했기에 결과값이 달라집니다.

<br>

참고로 **arraycopy** 같은 경우는

```java
System.arraycopy(num, 0, newNum, 3, n)
//num[0]에서 newNum[3]으로 n개의 데이터를 복사한다.
```

