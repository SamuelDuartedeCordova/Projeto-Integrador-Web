package senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.com.br.Projeto.Integrador.entitys.PedidosItens;

public interface PedidosItensRepository extends JpaRepository<PedidosItens, Long> {
}
