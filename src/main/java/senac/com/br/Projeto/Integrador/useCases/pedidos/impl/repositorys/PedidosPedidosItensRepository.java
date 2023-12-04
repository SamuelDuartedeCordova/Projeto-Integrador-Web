package senac.com.br.Projeto.Integrador.useCases.pedidos.impl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.com.br.Projeto.Integrador.entitys.PedidosItens;

@Repository
public interface PedidosPedidosItensRepository extends JpaRepository<PedidosItens, Long> {
}
