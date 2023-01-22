# Programsko inženjerstvo

# Solid Principle

## S - Single Responsibility

```java
@Data
@AllArgsConstructor
public class Book {
     	private String name;
	private String author;

	private Printer<Book> printer;**
	/*
	* Odgovornost knjige nije printanje!
	* Ovo treba biti odvojeno u drugu klasu
	*/
	public void print(){
		printer.print(this, Locale.ENGLISH);
	}
}
```

```java
public class BookPrinter {
	private Printer<Book> printer;

	void print(Book book){
		printer.print(book, Locale.ENGLISH);
	}
}
```

********************Single responsibility******************** zalaže da jedna klasa treba služiti samo jednoj svrsi.
Sve metode i svojstva trebaju raditi prema istom cilju.

## O - Open Close

```java
@Data
@AllArgsConstructor
public class Book {
	private String name;
	private String author;
	private BookType type;
	
	/*
	 * Pošto znamo da u budućnosti će biti više tipova knjiga
	 * ova metoda će postati vrlo brzo nemoguća za održavanje!
	 */
	public Double calculateCharge(){
		if(BookType.MAGAZINE.equals(type)){
			return 15.00;
		}else if(BookType.EDUCATIONAL.equals(type)){
			return 50.00;
		}
		return 00.00;
	}
}
```

```java
public interface Chargable{
	Double calculateCharge();
}

public class EducationalBook extends Book implements Chargable {
	@Override
	public Double calculateCharge(){
		return 50.00;
	}
}

```

**************************************Open close princip************************************** zalaže da klase trebaju biti otvorene za proširenja, ali zatvorena za modifikacije.
Cilj ovog principa je da dodavanje novih karakteristika treba biti jednostavno i lako za implementirati bez da mijenjamo ponašanja postojećih metoda.

## L - Liskov Substitution

```java
public class Animal {
    public void speak() {
        System.out.println("Animals can speak");
    }
}

public class Dog extends Animal {
	 	/*
		* Pas naslijeđuje Animal klasu i zbog toga što
		* override-a speak metodu na način da ima drugačiji potpis
		* od Animal metode speak()
		*/
    public void speak(int volume) {
        System.out.println("Dog barks at volume: " + volume);
    }

}
```

```java
public class Animal {
    public void speak() {
        System.out.println("Animals can speak");
    }
}
public class Dog extends Animal {
    public void speak() {
        System.out.println("Dog barks");
    }
}
```

********************Liskov princip substitucije******************** zalaže da ako je klasa ****Dog**** podklasa klase *******Animal******* tada bismo trebali moći zamijeniti Animal sa **Dog** bez narušavanja ponašanja programa:

```java
Animal pas = new Dog();  // Treba compailat isto kao i 
Dog pas = new Dog();     // kao i ovo
```

## I - Interface segregation

```java
public interface AnimalBehavior{
	void swim();
	void fly();
}

public class Fish implements AnimalBehavior{
	public void swim(){
		System.out.println("Fish swims..");
	}
		/*
		* Riba nebi trebala naslijediti interface u kojemu 
		* postoji metoda fly() jer riba ne smije letjeti.
		*/
		public void fly(){
			// Fish doesn't fly
	}**

}
```

```java
public interface Swimmable{
	void swim();
}
public interface Flyable{
	void fly();
}

public class Fish implements Swimmable{
	public void swim(){
		System.out.println("Fish swims..");
	}
}
```

********************************************Interface segregation******************************************** zalaže da klijent nesmoje biti forsiran implementirati interface koje neće koristiti, time rečeno, velike interface treba podijeliti na manje.

## D - Dependency Inversion

```java
public class CombustionEngine {
	public void start(){
		System.out.println("Brrrmmmmmmm");
	}
}

public class Bugatti {

	private CombustionEngine engineW16;
	
		/*
		* Naš bugatti klasa je sada isključivo vezana za Combustion engine 
		* klasu i dizajnirana je da radi samo sa combustion engine klasom.
		* Kada bismo htjeli promjeniti engineW16 da bude tipa GasEngine
		* tada bismo trebali promjeniti cijelu strukturu klase bugatti.
		*/
	public Bugatti(){
		this.engineW16 = new CombustionEngine();
	}

	public void start(){
		engineW16.start();
	}

}

```

```java
interface Engine {
    void start();
}

public class CombustionEngine implements Engine{
	public void start() {
			System.out.println("Brrrmmmmmmm");
	}
}

public class Bugatti{
    private Engine engine;

    public Bugatti (Engine engine) {
        this.engine = engine;
    }
    public void start() {
        engine.start();
    }
}
```

******************************************Dependency inversion****************************************** zalaže da moduli visoke razine ne bi trebali ovisit o modulima niske razine, u našem slučaju; ********Bugatti******** klasa ne bi trebala ovisiti o ********************CombustionEngine******************** klasi već o *******Engine******* klasi.
Na ovaj način možemo u konstruktoru ********Bugatti******** klase staviti bilo koji engine koji implementira engine interface.

---

# Design Patterns

Postoje 3 tipa dizajn patterna:

- ********************Creational********************
    
    > Design pattern koji se bavi mehanizmima za stvaranje objekata, koji povećavaju fleksibilnost i iskoristivost postojećeg koda.
    > 
    > ℹ️ Creational design patterns: factory method, abstract factory, builder, prototype, singleton
   
    
- **********************Structural**********************
    
    > Design pattern koji objašnjava kako se objekti i klase slažu u veće struktrure, na način da te strukture ostanu fleksibilne i efikasne.
    > 
    > ℹ️ Structural design patterns: adapter, decorator, bridge, composite, facade, proxy
    
- ****Behavioural****
    
    > Behavioral design pattern se brine o algoritmima i dodijeli odgovornosti između objekta.
    >
    > ℹ️ Behavioral design patterns: chain of responsibility, command, iterator, mediator, memento, observer, state, strategy, template method, visitor
    

## Singleton pattern

```java
public class CEOSingleton {
	private static CEOSingleton instance = new CEOSingleton();

	private CEOSingleton**(){
	}
	
	public static CEOSingleton getInstance(){
		return instance;
	}**

	public void speak(){
		System.out.println("I am the CEO " + 
				"therefore there should be only one " + 
				"instance of me");
	}
}
```

> **Zašto bi koristili Singleton pattern?**
>Singleton pattern koristimo kada želimo osigurati da postoji samo jedna instanca objekta.
>Npr. ako postoji CEO klasa, koja ne implementira Singleton pattern onda možemo stvarati “beskonačno” instanci te klase, što nema smisla jer bi trebao postojati samo >jedan CEO.
>
>**Singletonova najvažnija beneficija je da je resource friendly,** to znači da ****nećemo trošiti resurse na stvaranju novih instanci objekta kada nam neće trebat.
> 

## Factory method

```java
public interface Sing {
	void sing();
}

public class OperaSinger implements Sing{
	@Override
	public sing(){
		System.out.println("AAAAA");
	}
}

public class Rapper implements Sing{
	@Override
	public sing(){
		System.out.println("uhhhhh");
	}
}

public class SingerFactory {
	public static Sing createSinger(Sing singer){
		if(singer == null) return null;
		else if(singer instanceof OperaSinger) return new OperaSinger();
		else if(singer instanceof Rapper) return new Rapper();
		else throw new IllegalArgumentException("Unkown singer");
	}
}
```

> **Zašto bi koristili Factory method pattern?**
Factory method design pattern koristimo da bi stvorili objekte bez da moramo specificirati klasu objekta koju želimo stvoriti. Umjesto toga, stvaramo “factory” koji se brina o stvaranju objekta za nas.
>
> Npr. Ako imamo interface *****Sing***** koji ima metodu *******sing()******* i stvorili smo klase koji naslijeđuju taj interface, factory nam omogućava da onda stvorimo instance ************OperaSinger************ ili *******Rapper******* jer factory kao parametar za stvaranje ********Singera******** prima interface.
>
>Ovo nam omogućava promjenu klase objekta koju želimo stvoriti bez da mijenjamo kod.
> 

## Builder

```java
public class Sandiwch{
	private String bread;
	private String meat;

	private Sandiwch(SendwichBuilder builder){
		this.bread = builder.bread;
		this.meat = builder.meat
	}

	public String getBread(){
		return this.bread;
	}
	
	public String getMeat(){
		return this.meat;
	}
	// GETTERS FOR BREAD, MEAT AND TOPPINGS
	// NO SETTERS IN SANDWICH CLASS! 

	public static class SendwichBuilder{
		private Sandwich sandwich;
		private String bread;
		private String meat;

	public SendwichBuilder setBread(String bread){
		this.bread = bread;
	}

	public SendwichBuilder setMeat(String meat){
		this.meat = meat;
	}

	public Sendwich build(){
		return new Sendwich(this);
	}
}
```

> ********************************************Zašto bi htjeli koristiti builder design pattern?********************************************
Zamislimo da imamo klasu ******House****** koja može biti obična kuća, pod tim mislim da u sebi ima *****************class properties***************** poput **************Garage, Pool, Garden itd…**************
> 
> 
> ```java
> public class House{
> 	private Garage garage;
> 	private Pool pool;
> 	private Garden garden;
> 
> 	public House(Garage garage, Pool pool, Garden garden){
> 		this.garage = garage;
> 		...
> 	}
> }
> ```
> 
> ****************Garage, garden i pool**************** stavke mogu biti opcionalne, možda netko ne želi kuću sa garažom ili slično. 
> Jedna od solucija za proširivanje obične *House* klase je stvaranje npr. ************GarageHouse************ klasu i slično ili stvaranje ogromnog konstruktora koji će onda za garažu primiti null.
> 
> ```java
> House houseWithPool = new House(null, new Pool(), null);
> ```
> 
> Tu onda stupa builder koji u sebi ima metoda za izgradnju garaže, bazena i ostali stvari.
> Možda naizgled izgleda ka kompliciranje, ali ustvari kod nam je puno organiziraniji jer pozivamo samo one metode koje želimo.
> 

## Prototype

```java
public abstract class Vehicle{
	public int horsePower;
	
	public Vehicle(Vehicle v){
		if(v != null)
			this.horsePower = v.horsePower;
	}

	public abstract Vehicle clone();
}

public class Car extends Vehicle{
	public int kw;
	public Car(Car car){
		super(car);
		if(car != null)
			this.kw = car.kw;
	}

	public Vehicle clone(){
		return new Car(this);
	}
}
```

> **************************Zašto bi htjeli koristiti Prototype design pattern?**************************
Zbog ovog design patterna puno je lakše i brže kopirati i u odnosnu na kopirani objekt stvoriti novi.
>
>******************************************************************Zašto bi htjeli kopirati objekt?******************************************************************
> 
> - Možemo stvoriti kopiju bez da modificiramo orginalni objekt
> - Kloniranje objekta košta puno manje nego stvaranje novog objekta
> - Ako želimo stvoriti neki objekt koji ima puno parametra u konstruktoru, onda je lakše klonirati pa modificirati samo one propertyije koje želimo promjeniti
> - Stvaranje backup kopije objekta prije primjene nekih promjena. On nam omogućava da spremimo orginalnu kopiju ako su primjenjene promjene stvorile probleme.

## Adapter

```java
interface Shape{
	void draw();
}

public class Rectangle {
	public void draw(int x1, int x2, int y1, int y2){
		// Draw rectangle
	}
}

public class RectangleAdapter implements Shape{
	private Rectangle rectangle;
	
	public RectangleAdapter(Rectangle adaptee){
		this.rectangle = adaptee;
	}

	@Override
	public void draw(){
		rectangle.draw(0,0,10,10);
	}
}
```

> ********Zašto želimo koristiti Adapter design pattern?********
>Adapter je kao prvo strukturalni design pattern koji nam pomaže da objekt prilagodimo da funkcionira sa naizgled nekompatibilnim objektima.
>
>Nesvjesno stalno koristimo adapter design pattern u svakodnevnom programskom kodu: 
**********************************************Array.asList(), 
InputStreamReader(InputStream) →********************************************** vraća Reader objekt
> 

## Decorator

```java
interface Pizza{
	String getIngridients();
}

public class Margarita implements Pizza{
	@Override
	public String getIngridients(){
		return "Tomato sauce, Cheese";
	}
}

abstract class PizzaDecorator implements Pizza {
	protected Pizza pizza;

	public PizzaDecorator(Pizza pizza){
		this.pizza = pizza;
	}

	public String getIngridients(){
		return pizza.getIngridients();
	}
}

public class HamDecorator extends PizzaDecorator {
	public HamDecorator (Pizza pizza){
		super(pizza);
	}

	public String getIngridients(){
		return pizza.getIngridients() + "Ham";
	}
}
```

> **************************************************************************Zašto želimo koristiti Decorator design pattern?**************************************************************************
Decorator design pattern nam omogućava dodavanje novog ponašanje objektima na način da ih wrappamo sa objektima koje nazivamo dekorator.
>
>Npr. što ako želimo dodati ponašanje (neku metodu) za klasu ************************ArrayList?************************
>Ne bi bilo pametno dodavati kod na klasu koju su pisali kvalificirani programeri godinama, već možemo napraviti naš dekorator na postojeću klasu.
> 

## Observer

```java
interface Subject {
	void registerObserver(Observer o);
	void notifyObservers();
}

interface Observer{
	void update(double stockPrice);
}

public class StockMarket implements Subject {
	private List<Observers> observers = new ArrayList<Observers>();
	private double appleStock;
	@Override
	public void registerObserver(Observer o){
		observers.add(o);
	}

	// Stock market obavještava investitore o cijeni
	@Override
	public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(appleStock);
        }
    }

	public void setStockPrice(double appleStock){
		this.appleStock = appleStock;
		notifyObservers();
	}
}

public class Investor implements Observer {
	private String name;

	public Investor(String name){
		this.name = name;
	}

	// Investor sluša za poziv na update metodu
	@Override
	public  void update(double stockPrice){
		System.out.println("Stock price is : " + stockPrice + "$");
	}	
}
```

> **********************************************************************************************Zašto želimo korisiti Observer design pattern?**********************************************************************************************
> Observer design pattern je prilično čest u svakodnevnici, pogotovo u GUI komponentama gdje se često pozivaju ****************************EventListener**************************** kada želimo slušati na odgovor na klik na gumb.
>
