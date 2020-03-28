# String클래스와 StringBuffer 클래스

## 1. String클래스

String클래스는 문자열을 저장하고 이를 다루는데 필요한 메서드를 함께 제공한다.

<br>

- string클래스의 특징

  - 한 번 생성된 String인스턴스가 갖고 있는 문자열은 읽어 올 수만 있고, 변경할 수는 없다.

    예를 들어 아래의 코드와 같이 '+' 연산자를 이용해서 문자열을 결합하는 경우 인스턴스 내의 문자열이 바뀌는 것이 아니라 새로운 면자열 "ab" 이 담긴 String인스턴스가 생성되는 것이다.

    ```java
    String a = "a";
    String b = "b";
    String a = a + b;
    ```

    <img src="https://user-images.githubusercontent.com/32161395/77824849-e4e4b800-7148-11ea-9005-3dd139574aa6.jpg" width="60%"></img>

    이처럼 덧셈연산자 '+'를 사용해서 문자열을 결합하는 것은 매 연산 시 마다 새로운 문자열을 가진 String인스턴스가 생성되어 메모리공간을 차지하게 되므로 가능한 한 결합횟수를 줄이는 것이 좋다.

    문자열간의 결합이나 추출 등 문자열을 다루는 작업이 많이 필요한 경우에는 String클래스 대신 StringBuffer클래스를 사용하는 것이 좋다.

    StringBuffer인스턴스에 저장된 문자열은 변경이 가능하므로 하나의 StringBuffeer인스턴스만으로도 문자열을 다루는 것이 가능하다.

<br>

## StringBuffer클래스

String클래스는 인스턴스를 생성할 때 지정된 문자열을 변경할 수 없지만 StringBuffer클래스는 변경이 가능하다. 내부적으로 문자열 편집을 위한 버퍼(buffer)를 가지고 있으며, StringBuffer인스턴스를 생성할 때 그 크기를 지정할 수 있다.

- StringBuffer의 생성자
  - String인스턴스를 생성할 때, 버퍼의 크기를 지정해주지 않으면 16개의 문자를 저장할 수 있는 크기의 버퍼를 생성한다.