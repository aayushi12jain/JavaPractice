package mainPackage;


import FactoryPattern.Shape;
import FactoryPattern.ShapeFactory;
import chainResponsibilityModelATMSystem.Fifties;
import chainResponsibilityModelATMSystem.FiveHundreds;
import chainResponsibilityModelATMSystem.Hundreds;
import chainResponsibilityModelATMSystem.NotesHandler;
import chainResponsibilityModelATMSystem.TwoThousands;
import decoratorPattern.BasePizza;
import decoratorPattern.ExtraCheese;
import decoratorPattern.Margherita;
import decoratorPattern.Mushroom;
import observerPattern.EmailNotification;
import observerPattern.IphoneObservable;
import observerPattern.MobileNotification;
import observerPattern.NotifyObserver;
import observerPattern.StockObservable;
import proxyDesignPattern.EmployeeDao;
import proxyDesignPattern.EmployeeDaoProxy;
import strategyPattern.PassengerCar;
import strategyPattern.Vehicle;

public class Solution {

	public static void main(String[] args) {
		
		/*
		//Strategy Pattern 
		
		Vehicle v = new PassengerCar();
		v.drive();

		//Observe Pattern
		
		StockObservable obj = new IphoneObservable();
		
		NotifyObserver obj1 = new EmailNotification("xyz@hotmail.com", obj);
		NotifyObserver obj2 = new EmailNotification("abc@hotmail.com", obj);
		NotifyObserver obj3 = new MobileNotification("2341234563", obj);
		
		obj.add(obj1);
		obj.add(obj2);
		obj.add(obj3);
		
		obj.setStock(10);
		obj.setStock(0);
		obj.getStock();
		obj.setStock(10);
		
		
		BasePizza pizza = new Mushroom(new ExtraCheese(new Margherita()));
		System.out.println(pizza.cost());
		
		
		ShapeFactory s = new ShapeFactory();
		Shape s1 = s.create("Circle");
		Shape s2 = s.create("rectangle");
		
		s1.draw();
		s2.draw();
		
		
		
		LoggerHandler logger = new InforLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		
		logger.log(logger.ERROR, "An error has occured");
		logger.log(logger.INFO, "An info has recieved");
		logger.log(logger.DEBUG, "A debug log has occured");
		
		NotesHandler atm = new TwoThousands(new FiveHundreds(new Hundreds(new Fifties(null))));
		
		atm.withdraw(2050);
		
		
		EmployeeDao empObj = new EmployeeDaoProxy();
		empObj.create("USER", "Alex");
		empObj.delete("ADMIN", "Alex");
		empObj.get("USER", "Alex");
		
		*/
	}

}
