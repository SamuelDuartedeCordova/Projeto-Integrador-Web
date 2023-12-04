package senac.com.br.Projeto.Integrador.useCases.produtos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.produtos.ProdutosService;
import senac.com.br.Projeto.Integrador.useCases.produtos.domanis.ProdutosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.produtos.domanis.ProdutosResponseDom;

import java.util.List;

@Service
public class ProdutosServiceImpl implements ProdutosService {

    @Autowired
    private ProdutosBusinessImpl produtosBusiness;

    @Override
    public List<ProdutosResponseDom> carregarProdutos() {
        return produtosBusiness.carregarProdutos();
    }

    @Override
    public ProdutosResponseDom criarProdutos(ProdutosRequestDom produtos) throws ProFutException {
        return produtosBusiness.criarProdutos(produtos);
    }

    @Override
    public ProdutosResponseDom atualizarProdutos(Long id, ProdutosRequestDom produtos) throws ProFutException {
        return produtosBusiness.atualizarProdutos(id, produtos);
    }

    @Override
    public void deletarProdutos(Long id) {
        produtosBusiness.deletarProdutos(id);
    }
}
