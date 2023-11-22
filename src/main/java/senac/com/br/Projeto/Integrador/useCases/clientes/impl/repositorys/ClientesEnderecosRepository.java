package senac.com.br.Projeto.Integrador.useCases.clientes.impl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import senac.com.br.Projeto.Integrador.entitys.Enderecos;

import java.util.List;

public interface ClientesEnderecosRepository extends JpaRepository<Enderecos, Long> {

    @Query("select a from enderecos a where a.cliente.id = :id")
    List<Enderecos> carregarEnderecoByClienteId(@Param("id")Long id);
}
