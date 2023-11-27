package senac.com.br.Projeto.Integrador.useCases.pedidos.impl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.com.br.Projeto.Integrador.entitys.Clientes;

public interface PedidosClientesRepository extends JpaRepository<Clientes, Long> {
}
