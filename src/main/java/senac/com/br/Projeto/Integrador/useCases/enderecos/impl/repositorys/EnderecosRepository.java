package senac.com.br.Projeto.Integrador.useCases.enderecos.impl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.com.br.Projeto.Integrador.entitys.Enderecos;

public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {
}
