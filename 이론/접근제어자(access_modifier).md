# 접근 제어자_(access_modifier)

## 1. 접근 제어자

접근제어자는 멤버 또는 클래스에 사용되어, 해당하는 멤버 또는 클래스를 외부에서 접근하지 못하도록 제한하는 역할을 한다.

접근 제어자가 default 임을 알리기 위해 실제로 default를 붙이지는 않는다.

클래스나 멤버변수, 메소드, 생성자에 접근 제어자가 지정되어 있지 않다면 접근 제어자가 default임을 뜻한다.

**접근 제어자가 사용될 수 있는 곳 - 클래스, 멤버변수, 메소드, 생성자**

- 접근 범위
  - private		- 같은 클래스 내에서만 접근이 가능하다.
  - default		- 같은 패키지 내에서만 접근이 가능하다.
  - protected	- 같은 패키지 내에서, 그리고 **다른 패키지와 자손클래스에서 접근이 가능**하다.
  - public		- 접근 제한이 전혀 없다.

| 제어자    | 같은 클래스 | 같은 패키지 | 자손클래스 | 전체 |
| --------- | :---------: | :---------: | :--------: | :--: |
| public    |      O      |      O      |     O      |  O   |
| protected |      O      |      O      |     O      |  X   |
| (default) |      O      |      O      |     X      |  X   |
| private   |      O      |      X      |     X      |  X   |

<br>

- 사용가능한 접근 제어자

| 대상     | 사용가능한 접근 제어자                |
| -------- | ------------------------------------- |
| 클래스   | public, (default)                     |
| 메소드   | public, protected, (default), private |
| 멤버변수 | public, protected, (default), private |
| 지역변수 | 없음                                  |

<br>

- 접근 제어자를 사용하는 이유

  - 외부로부터 데이터를 보호하기 위해서
  - 외부에는 불필요한, 내부적으로만 사용되는 부분을 감추기 위해서

  <br>

- 생성자의 접근 제어자

  생성자에 접근 제어자를 사용함으로써 인스턴스의 생성을 제한할 수 있다. 보통 생성자의 접근 제어자는 클래스의 접근 제어자와 같지만, 다르게 지정할 수도 있다. 생성자의 접근 제어자를 private으로 지정하면, 다르게 지정,할 수도 있다.

  <br><br>

## 2. 제어자의 조합

| 대상     | 사용가능한 제어자                         |
| -------- | ----------------------------------------- |
| 클래스   | public, (default), final, abstract        |
| 메소드   | 모든 접근 제어자, final, abstract, static |
| 멤버변수 | 모든 접근 제어자, final, static           |
| 지역변수 | fianl                                     |

<br>

- 제어자를 조합해서 사용할 때 주의사항

  1. 메소드에 static과 abstract를 함께 사용할 수 없다

     static메소드는 몸통이 있는 메소드에만 사용할 수 있기 때문이다.

  2. 클래스에 abstract와 final을 동시에 사용할 수 없다.

     클래스에 사용되는 final은 클래스를 확장할 수 없다는 의미이고 abstract는 상속을 통해서 완성되어야 한다는 의미이므로 서로 모순되기 때문이다.

  3. abstract메소드의 접근 제어자가 private일 수 없다.

     abstract메소드는 자손클래스에서 구현해주어야 하는데 접근 제어자가 private이면, 자손클래스에서 접근할 수 없기 때문이다.

  4. 메소드에 private과 final을 같이 사용할 필요는 없다.

     접근 제어자가 private인 메소드는 오버라이딩될 수 없기 때문이다. 이 둘 중 하나만 사용해도 의미가 충분하다.