package clases;

import java.util.ArrayList;
import java.util.List;

public class Repartidor extends Usuario {
    private String zonaReparto;
    private EstadoRepartidor estado;
    private List<Pedido> pedidos;

    public Repartidor(String nombre, String email, int telefono, String zonaReparto) {
        super(nombre, email, telefono);
        this.zonaReparto = zonaReparto;
        this.estado = EstadoRepartidor.DISPONIBLE;
        this.pedidos = new ArrayList<>();
    }

    public String getZonaReparto() {
        return zonaReparto;
    }

    public void setZonaReparto(String zonaReparto) {
        this.zonaReparto = zonaReparto;
    }

    public EstadoRepartidor getEstado() {
        return estado;
    }

    public void setEstado(EstadoRepartidor estado) {
        this.estado = estado;
    }

    public boolean isDisponible() {
        return this.estado == EstadoRepartidor.DISPONIBLE;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}
