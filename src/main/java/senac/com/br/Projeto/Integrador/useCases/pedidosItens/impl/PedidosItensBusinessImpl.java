package senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl;

import org.springframework.beans.factory.annotation.Autowired;
import senac.com.br.Projeto.Integrador.entitys.Pedidos;
import senac.com.br.Projeto.Integrador.entitys.PedidosItens;
import senac.com.br.Projeto.Integrador.entitys.Produtos;
import senac.com.br.Projeto.Integrador.frameWork.annotions.Business;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.PedidosItensBusiness;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.domanis.PedidosItensRequestDom;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.domanis.PedidosItensResponseDom;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl.mappers.PedidosItensMapper;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl.repositorys.PedidosItensPedidosRepository;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl.repositorys.PedidosItensProdutosRepository;
import senac.com.br.Projeto.Integrador.useCases.pedidosItens.impl.repositorys.PedidosItensRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Business
public class PedidosItensBusinessImpl implements PedidosItensBusiness {

    @Autowired
    private PedidosItensRepository pedidosItensRepository;

    @Autowired
    private PedidosItensPedidosRepository pedidosItensPedidosRepository;

    @Autowired
    private PedidosItensProdutosRepository pedidosItensProdutosRepository;

    @Override
    public List<PedidosItensResponseDom> carregarPedidosItens() {
        List<PedidosItens> pedidosItensList = pedidosItensRepository.findAll();

        List<PedidosItensResponseDom> out = pedidosItensList.stream()
                .map(PedidosItensMapper::pedidosItensToPedidosItensResponseDom)
                .collect(Collectors.toList());

        return out;
    }

    @Override
    public PedidosItensResponseDom criarPedidosItens(PedidosItensRequestDom pedidoItens) throws ProFutException {
        List<String> messages = this.validacaoPedidoItens(pedidoItens);

        if (!messages.isEmpty()){
            throw new ProFutException(messages);
        }

        Optional<Pedidos> pedido = pedidosItensPedidosRepository.findById(pedidoItens.getPedidoId());
        if (!pedido.isPresent()){
            throw new ProFutException("Cliente não encontrado");
        }
        Optional<Produtos> produto = pedidosItensProdutosRepository.findById(pedidoItens.getProdutoId());
        if(!produto.isPresent()){
            throw new ProFutException("Produto não encontrado");
        }

        PedidosItens pedidosItensRetorno = pedidosItensRepository.save(PedidosItensMapper.pedidosItensRequestDomToPedidosItens(pedidoItens, pedido.get(), produto.get()));

        return PedidosItensMapper.pedidosItensToPedidosItensResponseDom(pedidosItensRetorno);
    }

    @Override
    public PedidosItensResponseDom atualizarPedidosItens(Long id, PedidosItensRequestDom pedidosItens) throws ProFutException {
        List<String> messages = this.validacaoPedidoItens(pedidosItens);

        if(!messages.isEmpty()){
            throw new ProFutException(messages);
        }
        Optional<Pedidos> pedidos = pedidosItensPedidosRepository.findById(pedidosItens.getPedidoId());
        if (!pedidos.isPresent()){
            throw new ProFutException("Pedido não encontrado!");
        }
        Optional<Produtos> produtos = pedidosItensProdutosRepository.findById(pedidosItens.getProdutoId());
        if(!produtos.isPresent()){
            throw new ProFutException("Produto não encontrado");
        }
        Optional<PedidosItens> pedidosItensRetorno = pedidosItensRepository.findById(id).map(record -> {
            record.setQuantidade(pedidosItens.getQuantidade());
            record.setValorUnitario(pedidosItens.getValorUnitario());
            record.setPedidoId(pedidos.get());
            record.setProdutoId(produtos.get());

            return pedidosItensRepository.save(record);
        });
        if(pedidosItensRetorno.isPresent() == false){
            throw new ProFutException("Pedido item não encontrado!");
        }
        PedidosItensResponseDom out = PedidosItensMapper.pedidosItensToPedidosItensResponseDom(pedidosItensRetorno.get());

        return out;
    }

    @Override
    public void deletarPedidoItens(Long id) {
        pedidosItensRepository.deleteById(id);
    }


    public List<String> validacaoPedidoItens(PedidosItensRequestDom pedidoItens) {
        List<String> messages = new ArrayList<>();

        if (pedidoItens.getQuantidade() == null || pedidoItens.getQuantidade() < 1){
            messages.add("Quantidade não informado ou invalido!");
        }
        if(pedidoItens.getValorUnitario() == null || pedidoItens.getValorUnitario() < 1){
            messages.add("Valor unitario não informado ou invalido!");
        }
        if (pedidoItens.getPedidoId() == null || pedidoItens.getPedidoId() < 1){
            messages.add("PedidoId não informado ou valor invalido!");
        }
        if (pedidoItens.getProdutoId() == null || pedidoItens.getProdutoId() < 1){
            messages.add("ProdutoId não informado ou valor invalido!");
        }

        return messages;
    }
}
