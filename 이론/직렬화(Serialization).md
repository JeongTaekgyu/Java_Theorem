# 직렬화(Serialization)

객체를 컴퓨터에 저장했다가 다음에 꺼내 쓸 수는 없을지 또는 네트워크를 통해 컴퓨터 간에 서로 객체를 주고받을 수는 있을까? 직렬화를 사용하다면 가능하다.

## 1. 직렬화란?

객체를 데이터 스트림으로 만드는 것이다.

객체 ---> 데이터 스트림

즉, 저장된 데이터를 스트림에 쓰기(write)위해 연속적(serial)인 데이터로 변환하는 것을 말한다.

반대로 스트림으로부터 데이터를 읽어서 객체를 만드는 것을 역직렬화(deserialization)이라고 한다.



객체 : 클래스에 정의된 인스턴스 변수의 집합이다.

객체에는 클래스변수나 메서드가 포함되지 않는다.

전에는 이해를 돕기 위해 객체를 생성하면 인스턴스변수와 메서드를 함께 그리곤 했으나 사실 객체에는 메서드가 포함되지 않는다.



클래스에 정의된 인스턴스변수가 단순히 기본형일 때는 인스턴스변수의 값을 저장하는 일이 간단하지만, 인스턴스 변수의 타입이 참조형일 때는 그리 간단하지 않다. 예를 들어 인스턴스변수의 타입이 배열이라면 배열에 저장된 값들도 모두 저장되어야할 것이다. 그러나 우리는 객체를 직렬화해야 하는지 고민하지 않아도 된다. 다만 객체를 직렬화/역직렬화할 수 있는 ObjectInputStream과 ObjectOutputStream을 사용하는 방법만 알면 된다.



파일에 객체를 저장(직렬화)하고 싶다면 다음과 같이 하면 된다.

```java
FileOutputStream fos = new FileOutputStream("objectfile.ser");
ObjectOutputStream out = new ObjectOutputStream(fos);
out.writeObject(new UserInfo());
```

해당 코드는 objectfile.ser 라는 파일에 UserInfo 객체를 직렬화하여 저장한다. 출력할 스트림(FileOutputStream)을 생성해서 이를 기반 스트림으로 하는 ObjectOutStream을 생성한다.

