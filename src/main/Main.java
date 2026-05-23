package main;

import clases.*;

public class Main {
	public static void main (String[]args) {
		Cliente cliente = new Cliente ("Antia Cancelo ", "antiacancelo@gmail.com" , 612345678);
		Repartidor repartidor = new Repartidor ("Juanito Juan" , "juanitojuan@gmail.com" , 689689689, "Monte Alto" );
		Producto pizza = new Producto ("Pizza Peperoni", 9.90, Categoria.COMIDA);
		Producto refresco = new Producto ("Nestea" , 1.5, Categoria.BEBIDA);
		
		Pedido pedido = new Pedido ();
		pedido.addProducto(pizza, 2);
		pedido.addProducto(refresco, 3);
		
		
		
		
		
		
		
		
		
	}
	
	

}
