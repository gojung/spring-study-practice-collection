# State Pattern

## 전제

Frog는 비가 오면 울고, 해가 쨍쨍하면 잔다.

구현해놓고 보니까 이거 상태보다는 전략패턴 같은디  
일단 개구리부터가 무슨 상태를 가지고 있지를 않음  
enum으로 상태패턴 쓰는 거 해볼랬는데 아쉽당  

전략/상태가 명확히 나눠지는 건 아니지만 개구리가 상태를 가지고 있어야 상태 패턴이 됨
그리고 상태 전이가 끊임없이 일어나야 하는 로직이어야 할 것 같음  

