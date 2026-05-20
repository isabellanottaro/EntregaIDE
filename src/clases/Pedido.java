package clases;

import java.time.LocalDate;

public class Pedido {
	private int id;
	private LocalDate fechaDePedido;
	private EstadoPedido estado;
	private Cliente cliente;
	private Repartidor repartidor;
	private List<LineaPedido> lineasPedido;
	
	public Pedido (int id, Cliente cliente) {
		this.id=id;
		this.cliente=cliente;
		this.fechaDePedido=LocalDate.now();
		this.estado=EstadoPedido.PENDIENTE;
		this.lineasPedido=new ArrayList<>();
		this.repartidor=null;
		
	}
	
	
}
