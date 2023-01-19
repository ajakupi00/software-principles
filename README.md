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
