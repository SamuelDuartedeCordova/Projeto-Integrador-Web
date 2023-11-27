package senac.com.br.Projeto.Integrador.useCases.pedidos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.entitys.Pedidos;
import senac.com.br.Projeto.Integrador.frameWork.annotions.Business;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.pedidos.PedidosBusiness;
import senac.com.br.Projeto.Integrador.useCases.pedidos.domanis.PedidosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.pedidos.domanis.PedidosResponseDom;
import senac.com.br.Projeto.Integrador.useCases.pedidos.impl.mappers.PedidosMapper;
import senac.com.br.Projeto.Integrador.useCases.pedidos.impl.repositorys.PedidosClientesRepository;
import senac.com.br.Projeto.Integrador.useCases.pedidos.impl.repositorys.PedidosRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Business
public class PedidosBusinessImpl implements PedidosBusiness {
    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private PedidosClientesRepository pedidosClientesRepository;


    @Override
    public List<PedidosResponseDom> carregarPedidos() {
        List<Pedidos> pedidosList = pedidosRepository.findAll();

        List<PedidosResponseDom> out = pedidosList.stream()
                .map(PedidosMapper::pedidosToPedidosResponseDom)
                .collect(Collectors.toList());

        return out;
    }

    @Override
    public PedidosResponseDom criarPedidos(PedidosRequestDom pedido) throws ProFutException {
        List<String> messages = this.validacaoPedido(pedido);

        if (!messages.isEmpty()){
            throw new ProFutException(messages);
        }

        Optional<Clientes> cliente = pedidosClientesRepository.findById(pedido.getClienteId());
        if (!cliente.isPresent()){
            throw new ProFutException("Cliente não encontrado");
        }

        Pedidos pedidoRetorno = pedidosRepository.save(PedidosMapper.pedidosRequestDomToPedidos(pedido, cliente.get()));

        return PedidosMapper.pedidosToPedidosResponseDom(pedidoRetorno);
    }

    @Override
    public PedidosResponseDom atualizarPedidos(Long id, PedidosRequestDom pedido) throws ProFutException {
        List<String> messages = this.validacaoPedido(pedido);

        if(!messages.isEmpty()){
            throw new ProFutException(messages);
        }

        Optional<Clientes> cliente = pedidosClientesRepository.findById(pedido.getClienteId());
        if(!cliente.isPresent()){
            throw new ProFutException("Cliente não encontrado");
        }

        Optional<Pedidos> pedidoRetorno = pedidosRepository.findById(id).map(record -> {
            record.setDataCriacao(pedido.getDataCriacao());
            record.setDataEntrega(pedido.getDataEntrega());
            record.setValorDesconto(pedido.getValorDesconto());
            record.setCliente(cliente.get());

            return pedidosRepository.save(record);
        });

        if(!pedidoRetorno.isPresent()){
            throw new ProFutException("pedido não encontrado!");
        }

        PedidosResponseDom out = PedidosMapper.pedidosToPedidosResponseDom(pedidoRetorno.get());

        return out;
    }

    @Override
    public void deletarPedido(Long id) {
        pedidosRepository.deleteById(id);
    }

    public List<String> validacaoPedido(PedidosRequestDom pedido) {
        List<String> messages = new ArrayList<>();

        if (pedido.getDataEntrega() == null){
            messages.add("Data de entrega não inserido ou invalido!");
        }
        if(pedido.getClienteId() == null || pedido.getClienteId() < 1) {
            messages.add("ClienteId não informado ou valor invalido!");
        }
        if (pedido.getEnderecoId() == null || pedido.getEnderecoId() < 1){
            messages.add("EnderecoId não informado ou valor invalido!");
        }

        return messages;
    }
}
