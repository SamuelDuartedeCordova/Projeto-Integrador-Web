package senac.com.br.Projeto.Integrador.useCases.produtos.impl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.com.br.Projeto.Integrador.entitys.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
