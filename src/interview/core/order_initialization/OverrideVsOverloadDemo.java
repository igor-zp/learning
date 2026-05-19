package interview.core.order_initialization;

/*
порядок ініщацізації класів наслідування
overriding
overloading
* */

//1. 5/3 = 1 тому що Number і ми ділемо цілочислені значення які розглядаються як int
/*

Сигнатура та аргументи
- Ім’я методу та список аргументів (їх кількість, типи та порядок) повинні бути абсолютно ідентичними до батьківського методу.
- Тип повернення (Return type)
- Тип значення, яке повертається, має бути таким самим, як у методу, що перевизначається, або його підтипом (коваріантний тип).

Модифікатори доступу
- Рівень доступу методу, що перевизначає, не може бути більш обмеженим, ніж у батьківського методу.
Приклад:
- Якщо метод у батьківському класі має модифікатор public, то метод у дочірньому класі не може бути private або protected.

Exceptions
- Перевизначений метод не повинен викидати checked exceptions, які є ширшими за ті, що оголошені в методі батьківського класу.
Дочірній метод може:
взагалі не викидати винятків;
викидати підкласи винятків, оголошених у батьківському методі.

Ключові слова та статичність
- Метод, оголошений як final або static, не можна перевизначити.
- Методи private не успадковуються, тому вони також не можуть бути перевизначені.
- Якщо метод у дочірньому класі має таку саму сигнатуру, як static-метод у батьківському класі,
це називається приховуванням методу (method hiding), а не перевизначенням (overriding).

*/

//Notion Polymorphism & Object Initialization — Ментальна модель
class Parent{
	public void m(Number n){
		n = 5/3;
		System.out.println("Class A, method m: " + n);
	}
}

class Child extends Parent {
	public void m(Double d){
		d = d/3;
		System.out.println("Class B, method m: " + d);
	}

	@Override
	public void m(Number n) {
		n = 5/3;
		System.out.println("Class B, method m Override: " + n);
	}
}

public class OverrideVsOverloadDemo {
	public static void main(String[] args) {
		Parent a1 = new Child();
		a1.m(5.0); //Override
		Child a2 = new Child();
		a2.m(5.0); //Overload
	}
}


