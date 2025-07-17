package decoratorPattern;

public class Mushroom extends BasePizza{

	BasePizza pizza;
	
	public Mushroom(BasePizza pizza) {
		super();
		this.pizza = pizza;
	}

	@Override
	public int cost() {
		return this.pizza.cost() + 15;
	}
	
}
