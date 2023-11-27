package senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.com.br.Projeto.Integrador.entitys.Pedidos;

public interface PedidosItensPedidosRepository extends JpaRepository<Pedidos, Long> {
}
