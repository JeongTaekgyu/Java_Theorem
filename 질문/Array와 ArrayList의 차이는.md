# Array(배열)와 ArrayList(리스트)의 차이는?  

<br>

1. Implementation of array is simple fixed sized array but Implementation of ArrayList is dynamic sized array.
   배열은 크기가 고정되어있지만 arrayList는 사이즈가 동적인 배열이다.

2. Array can contain both primitives and objects but ArrayList can contain only object elements
   배열은 primitive type(int, byte, char 등)과 object 모두를 담을 수 있지만, arrayList는 object element만 담을 수 있다.

3. You can’t use generics along with array but ArrayList allows us to use generics to ensure type safety.
   배열은 제네릭을 사용할 수 없지만, arrayList는 타입 안정성을 보장해주는 제네릭을 사용할 수 있다.

4. You can use length variable to calculate length of an array but size() method to calculate size of ArrayList.
   길이에 대해 배열은 length 변수를 쓰고, arrayList는 size() 메서드를 써야한다.

5. Array use assignment operator to store elements but ArrayList use add() to insert elements.
   배열은 element들을 할당하기 위해 assignment(할당) 연산자를 써야하고, arrayList는 add() 메서드를 통해 element를 삽입한다.

