package senac.com.br.Projeto.Integrador.useCases.pedidos.impl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.com.br.Projeto.Integrador.entitys.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
