package entities;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	@Override
	public final String priceTag() {
		return getName() + String.format("\t\t$%.2f", totalPrice()) 
		+ String.format("\t(Custom Fee $%.2f)", customsFee);
	}

	public Double totalPrice() {
		return getPrice() + customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

}
