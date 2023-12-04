package senac.com.br.Projeto.Integrador.useCases.produtos.impl.mappers;

import senac.com.br.Projeto.Integrador.entitys.Produtos;
import senac.com.br.Projeto.Integrador.useCases.produtos.domanis.ProdutosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.produtos.domanis.ProdutosResponseDom;

public class ProdutosMapper {

    public static ProdutosResponseDom produtosToProdutosResponseDom(Produtos produtos){
        ProdutosResponseDom out = new ProdutosResponseDom();
        out.setId(produtos.getId());
        out.setNome(produtos.getNome());
        out.setDescricao(produtos.getDescricao());

        return out;
    }

    public static Produtos produtosRequestDomToProdutos(ProdutosRequestDom produtosRequestDom){
        Produtos out = new Produtos();
        out.setNome(produtosRequestDom.getNome());
        out.setDescricao(produtosRequestDom.getDescricao());

        return out;
    }
}
