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
		
		
		System.out.println("\n PRUEBA PRODUCTO DUPLICADO");
		Pedido pedido2 = new Pedido (2,cliente);
		pedido2.addProducto(pizza, 1);
		try {
			pedido2.addProducto(pizza, 1);
			System.out.println("ERROR: debería haber lanzado excepción");
		} catch (IllegalArgumentException e) {
			System.out.println("Correcto - " + e.getMessage());
		}
		
		System.out.println("\n PRUEBA ASIGNAR SIN PRODUCTOS");
        Pedido pedido3 = new Pedido(3, cliente);
        try {
            pedido3.asignarRepartidor(repartidor);
            System.out.println("ERROR: debería haber lanzado excepción");
        } catch (IllegalStateException e) {
            System.out.println("Correcto - " + e.getMessage());
        }
        
        System.out.println("\n PRUEBA ENTREGAR SIN ESTAR EN REPARTO ");
        Pedido pedido4 = new Pedido(4, cliente);
        pedido4.addProducto(refresco, 2);
        try {
            pedido4.entregar();
            System.out.println("ERROR: debería haber lanzado excepción");
        } catch (IllegalStateException e) {
            System.out.println("Correcto - " + e.getMessage());
        }
        
        System.out.println("\n PRUEBA CANCELAR PEDIDO");
        Pedido pedido5 = new Pedido(5, cliente);
        pedido5.addProducto(pizza, 1);
        pedido5.asignarRepartidor(repartidor);
        System.out.println("Estado antes de cancelar: " + pedido5.getEstado());
        System.out.println("Repartidor ocupado: " + !repartidor.isDisponible());
        pedido5.cancelar();
        System.out.println("Estado tras cancelar: " + pedido5.getEstado());
        System.out.println("Repartidor libre tras cancelar: " + repartidor.isDisponible());
		
		
		
		
		
		

		
		
	}
	
	

}
