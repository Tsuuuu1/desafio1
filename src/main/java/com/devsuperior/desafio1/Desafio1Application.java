package com.devsuperior.desafio1;

import com.devsuperior.desafio1.entities.Order;
import com.devsuperior.desafio1.services.OrderService;
import com.devsuperior.desafio1.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner{

	@Autowired
	private OrderService orderService;

	@Autowired
	private ShippingService shippingService;



	public static void main(String[] args) {

		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order = new Order(1309, 95.90, 0.0);
		System.out.println("Pedido código: "  + order.getCode());
		System.out.println("Valor total: " + ((order.getBasic() * (1 - order.getDiscount() / 100)) + shippingService.shipment(order)));

	}

}
