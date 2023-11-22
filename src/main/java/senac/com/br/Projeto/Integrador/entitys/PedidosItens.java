package senac.com.br.Projeto.Integrador.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity(name = "pedido_itens")
@SQLDelete(sql = "UPDATE pedidos_itens SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at is null")
public class PedidosItens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private int quantidade;
    @Column
    private double valorUnitario;
    @Column
    private LocalDateTime deleted_at;
    @ManyToMany
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedidos pedidoId;
    @ManyToMany
    @JoinColumn(name = "produto_id", nullable = false)
    private Produtos produtoId;



}
