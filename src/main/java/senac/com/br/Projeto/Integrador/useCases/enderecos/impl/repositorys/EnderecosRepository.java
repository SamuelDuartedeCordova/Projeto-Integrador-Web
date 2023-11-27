package senac.com.br.Projeto.Integrador.useCases.enderecos.impl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.com.br.Projeto.Integrador.entitys.Enderecos;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {
}
