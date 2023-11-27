package senac.com.br.Projeto.Integrador.useCases.produtos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import senac.com.br.Projeto.Integrador.entitys.Produtos;
import senac.com.br.Projeto.Integrador.frameWork.annotions.Business;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.frameWork.utils.StringUtil;
import senac.com.br.Projeto.Integrador.useCases.produtos.ProdutosBusiness;
import senac.com.br.Projeto.Integrador.useCases.produtos.domanis.ProdutosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.produtos.domanis.ProdutosResponseDom;
import senac.com.br.Projeto.Integrador.useCases.produtos.impl.mappers.ProdutosMapper;
import senac.com.br.Projeto.Integrador.useCases.produtos.impl.repositorys.ProdutosRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Business
public class ProdutosBusinessImpl implements ProdutosBusiness {

    @Autowired
    private ProdutosRepository produtosRepository;

    @Override
    public List<ProdutosResponseDom> carregarProdutos() {

        List<Produtos> produtosList = produtosRepository.findAll();

        List<ProdutosResponseDom> out = produtosList.stream()
                .map(ProdutosMapper::produtosToProdutosResponseDom)
                .collect(Collectors.toList());

        return out;
    }

    @Override
    public ProdutosResponseDom criarProdutos(ProdutosRequestDom produtos) throws ProFutException {
        List<String> messages = this.validacaoProduto(produtos);

        if (!messages.isEmpty()){
            throw new ProFutException(messages);
        }
        Produtos produtosRetorno = ProdutosMapper.produtosRequestDomToProdutos(produtos);
        Produtos resultProdutos = produtosRepository.save(produtosRetorno);

        ProdutosResponseDom out = ProdutosMapper.produtosToProdutosResponseDom(resultProdutos);

        return out;
    }

    @Override
    public ProdutosResponseDom atualizarProdutos(Long id, ProdutosRequestDom produtos) throws ProFutException {
        List<String> messages = this.validacaoProduto(produtos);

        if (!messages.isEmpty()){
            throw new ProFutException(messages);
        }

        Optional<Produtos> produtosRetorno = produtosRepository.findById(id).map(record -> {
            record.setNome(produtos.getNome());
            record.setDescricao(produtos.getDescricao());

            return produtosRepository.save(record);
        });

        if (!produtosRetorno.isPresent()){
            throw new ProFutException("Produtos Informado não existe!");
        }

        ProdutosResponseDom out = ProdutosMapper.produtosToProdutosResponseDom(produtosRetorno.get());

        return out;
    }

    @Override
    public void deletarProdutos(Long id) {
        produtosRepository.deleteById(id);
    }

    private List<String> validacaoProduto(ProdutosRequestDom produtos){
        List<String> messages = new ArrayList<>();

        if(StringUtil.validarString(produtos.getNome())){
            messages.add("Produto informado não possui nome!");
        }
        if(StringUtil.validarString(produtos.getDescricao())){
            messages.add("Produto informado não possui descrição!");
        }

        return messages;
    }

}
