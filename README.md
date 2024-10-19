# Reactive Programming

What is Reactive Programming?  

* Reactive Programming is a design Patterm that focuses on use of asynchrnous and non-asynchronous blocking daa streams to handle data and events.  
* Helps us to increase Efficiency and Scalability of applications.

Featus of reactive Programming  
* Asynchronous and non-blocking
* Functional Style coding
* Data Flow as event driven
* BackPressure of Data stream


Reactive stream specification  

* Reactive programming has some rules these rules is known as Specification.
* There are 4 main interfaces
    * Publisher : It will publish the data(DataSource)
    * Subscriber : It will subscribe to get the data
    * Subscription : You can request that you want this much data or you can cancel the subscription
    * Processor : Acts or represnt both Publisher and Subscriber
 
Publisher  

Acts as Data Source

```java
public interface Publisher<T>{
  public void subscribe(Subsriber<? super T> s);
}
```

Subscriber  
 Acts as Data Receiver

```java
public interface Subscriber<T>{
  public void onSubscribe(Subscription s);
  public void onNext(T t);
  public void onError(Throwable t);
  public void onComplete();
}
```

Subscription  

Request data from publisher or cancel a request

```java
public interface Subscription{
  public void request(long n);
  public void cancel();
}
```

Processor  

Processor interfcae is the combination of both Publisher and Subscriber interfaces.
```java
public interface Processor<T,R> extends Subscriber<T>,Publisher<R>{
}
```

![image](https://github.com/user-attachments/assets/7db5f5de-be2a-420c-9801-63fe44344c36)

Mono--Publisher-->0/1  
Flux--Publisher-->0..n