package senac.com.br.Projeto.Integrador.useCases.produtos.impl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.com.br.Projeto.Integrador.entitys.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
