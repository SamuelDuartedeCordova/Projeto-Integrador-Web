package senac.com.br.Projeto.Integrador.useCases.produtos;

import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.produtos.domanis.ProdutosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.produtos.domanis.ProdutosResponseDom;

import java.util.List;

public interface ProdutosBusiness {
    List<ProdutosResponseDom> carregarProdutos();
    ProdutosResponseDom criarProdutos(ProdutosRequestDom produtos) throws ProFutException;
    ProdutosResponseDom atualizarProdutos(Long id, ProdutosRequestDom produtos) throws ProFutException;
    void deletarProdutos(Long id);
}
