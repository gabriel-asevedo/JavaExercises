package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	public static SimpleDateFormat SDF1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat SDF2 = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus status;
	private Client client;

	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Double totalPrice() {
		double value = 0.0;
		for (OrderItem oI : items) {
			value += oI.subTotal();
		}

		return value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY:");
		sb.append("\nOrder moment: " + SDF1.format(moment));
		sb.append("\nOrder status: " + status);
		sb.append("\nClient: " + client.getName());
		sb.append(" (" + SDF2.format(client.getBirthDate()) + ") - " + client.getEmail());
		sb.append("\nOrder items:\n");

		for (OrderItem oI : items) {
			sb.append(oI.getProduct().getName() + ", " + String.format("$%.2f", oI.getPrice()) + ", ");
			sb.append("Quantity: " + oI.getQuantity() + ", " + String.format("Subtotal: $%.2f\n", oI.subTotal()));
		}

		sb.append(String.format("\nTotal price: $%.2f", totalPrice()));

		return sb.toString();
	}
}
