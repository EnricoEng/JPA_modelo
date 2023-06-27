package br.com.alura.loja.modelo;

import java.lang.annotation.Inherited;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorTotal;
    private LocalDate data = LocalDate.now();

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido") //mappedby pedido pois já havia relacionamento feito na entidade ItemPedido
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(){
    }

    public Pedido(Cliente cliente){
        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido item){
        item.setPedido(this);
        this.itens.add(item);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
