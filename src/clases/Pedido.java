package clases;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
	private int id;
	private LocalDate fechaDePedido;
	private EstadoPedido estado;
	private Cliente cliente;
	private Repartidor repartidor;
	private List<LineaPedido> lineasPedido;

	public Pedido(int id, Cliente cliente) {
		this.id = id;
		this.cliente = cliente;
		this.fechaDePedido = LocalDate.now();
		this.estado = EstadoPedido.PENDIENTE;
		this.lineasPedido = new ArrayList<>();
		this.repartidor = null;
	}

	public double CalcularTotal() {
		double total = 0.0;
		for (LineaPedido linea : lineasPedido) {
			total = total + linea.getSubtotal();
		}
		return total;
	}

	public void asignarRepartidor(Repartidor repartidor) {
		if (lineasPedido.isEmpty()) {
			throw new IllegalStateException("No se puede asignar un repartidor a un pedido sin productos");
		}

		if (!repartidor.isDisponible()) {
			throw new IllegalStateException("El repartidor no está disponible");
		}
		this.repartidor = repartidor;
		this.estado = EstadoPedido.EN_REPARTO;
		repartidor.setEstado(EstadoRepartidor.OCUPADO);
		repartidor.addPedido(this);
	}

	public void entregar() {

		if (this.estado != EstadoPedido.EN_REPARTO) {
			throw new IllegalStateException("no se puede entregar un pedido que no está en reparto");
		}
		this.estado = EstadoPedido.ENTREGADO;
		if (this.repartidor != null) {
			this.repartidor.setEstado(EstadoRepartidor.DISPONIBLE);
		}
	}

	public void addProducto(Producto producto, int cantidad) {
		for (LineaPedido linea : lineasPedido) {
			if (linea.getProducto().getNombre().equals(producto.getNombre())) {
				linea.setCantidad(linea.getCantidad() + cantidad);
				return;
			}
		}
		lineasPedido.add(new LineaPedido(producto, cantidad));
	}
	
	
	

}
