package main;

import clases.*;

public class Main {
	public static void main (String[]args) {
		Cliente cliente = new Cliente ("Antia Cancelo ", "antiacancelo@gmail.com" , "612345678");
		Repartidor repartidor = new Repartidor ("Juanito Juan" , "juanitojuan@gmail.com" , "689689689", "Monte Alto" );
		Producto pizza = new Producto ("Pizza Peperoni", 9.90, Categoria.COMIDA);
		Producto refresco = new Producto ("Nestea" , 1.5, Categoria.BEBIDA);
		
		Pedido pedido = new Pedido (1, cliente);
		pedido.addProducto(pizza, 2);
		pedido.addProducto(refresco, 3);
		cliente.addPedido(pedido);
		
		System.out.println("Pedido Nº: " +pedido.getId());
		System.out.println("Cliente: " +pedido.getCliente().getNombre());
		System.out.println("Estado del pedido: " +pedido.getEstado());
		System.out.println("Monto total del pedido: " +pedido.calcularTotal() + " €.");
		
		pedido.asignarRepartidor(repartidor);
		System.out.println("Repartidor asignado: " + pedido.getRepartidor().getNombre());
		System.out.println("Estado tras asignar: " + pedido.getEstado());
		System.out.println("Repartidor ocupado: " + !repartidor.isDisponible());
		
		pedido.entregar();
		System.out.println("Estado tras entregar: " + pedido.getEstado());
		System.out.println("Repartidor disponible: " + repartidor.isDisponible());
		
		
		
		
		
		
		

		
		
	}
	
	

}
