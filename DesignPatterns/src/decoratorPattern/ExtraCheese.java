package decoratorPattern;

public class ExtraCheese extends Topping{
	
	BasePizza basePizza;
	
	public ExtraCheese(BasePizza pizza) {
		this.basePizza = pizza;
	}

	@Override
	public int cost() {
		return this.basePizza.cost() + 10;
	}
	
}
