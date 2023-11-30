package senac.com.br.Projeto.Integrador.useCases.enderecos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import senac.com.br.Projeto.Integrador.entitys.Clientes;
import senac.com.br.Projeto.Integrador.entitys.Enderecos;
import senac.com.br.Projeto.Integrador.frameWork.annotions.Business;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.enderecos.EnderecosBusiness;
import senac.com.br.Projeto.Integrador.useCases.enderecos.domanis.EnderecosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.enderecos.domanis.EnderecosResponseDom;
import senac.com.br.Projeto.Integrador.useCases.enderecos.impl.mappers.EnderecosMapper;
import senac.com.br.Projeto.Integrador.useCases.enderecos.impl.repositorys.EnderecosClientesRepository;
import senac.com.br.Projeto.Integrador.useCases.enderecos.impl.repositorys.EnderecosRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Business
public class EnderecosBusinessImpl implements EnderecosBusiness {

    @Autowired
    private EnderecosRepository enderecosRepository;

    @Autowired
    private EnderecosClientesRepository enderecosClientesRepository;

    @Override
    public List<EnderecosResponseDom> carregarEndereco() {
        List<Enderecos> enderecosList = enderecosRepository.findAll();

        List<EnderecosResponseDom> out = enderecosList.stream()
                .map(EnderecosMapper::enderecosToEnderecosResponseDom)
                .collect(Collectors.toList());

        return out;

    }

    @Override
    public EnderecosResponseDom criarEndereco(EnderecosRequestDom endereco) throws ProFutException {
        List<String> messages = this.validacaoManutencaoEndereco(endereco);

        if(!messages.isEmpty()){
            throw new ProFutException(messages);
        }

        Optional<Clientes> cliente = enderecosClientesRepository.findById(endereco.getClienteId());
        if(!cliente.isPresent()){
            throw new ProFutException("Cliente não encontrado!");
        }

        Enderecos enderecoRetorno = enderecosRepository.save(EnderecosMapper.enderecosResquestDomToEnderecos(endereco, cliente.get()));

        return EnderecosMapper.enderecosToEnderecosResponseDom(enderecoRetorno);
    }

    @Override
    public EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom endereco) throws ProFutException {
        List<String> messages = this.validacaoManutencaoEndereco(endereco);

        if(!messages.isEmpty()){
            throw new ProFutException(messages);
        }

        Optional<Clientes> cliente = enderecosClientesRepository.findById(endereco.getClienteId());
        if(!cliente.isPresent()){
            throw new ProFutException("Cliente não encontrado");
        }

        Optional<Enderecos> enderecoRetorno = enderecosRepository.findById(id).map(record -> {
            record.setRua(endereco.getRua());
            record.setBairro(endereco.getBairro());
            record.setCidade(endereco.getCidade());
            record.setEstado(endereco.getEstado());
            record.setCliente(cliente.get());

            return enderecosRepository.save(record);
        });
        if(!enderecoRetorno.isPresent()){
            throw new ProFutException("Endereco não encontrado!");
        }

        EnderecosResponseDom out = EnderecosMapper.enderecosToEnderecosResponseDom(enderecoRetorno.get());

        return out;
    }

    @Override
    public void deletarEndereco(Long id) {
        enderecosRepository.deleteById(id);
    }

    @Override
    public EnderecosResponseDom carregarEnderecoById(Long id) throws ProFutException {
        Optional<Enderecos> enderecos = enderecosRepository.findById(id);

        if(!enderecos.isPresent()){
            throw new ProFutException("Endereco não encontrado!");
        }

        Enderecos enderecos1 = enderecos.get();
        EnderecosResponseDom out = EnderecosMapper.enderecosToEnderecosResponseDom(enderecos1);

        return out;
    }

    private List<String> validacaoManutencaoEndereco(EnderecosRequestDom endereco){
        List<String> messages = new ArrayList<>();

        if(endereco.getBairro() == null || endereco.getBairro() == ""){
            messages.add("Campo bairro não informado ou invalido!");
        }

        if(endereco.getRua() == null || endereco.getRua() == ""){
            messages.add("Campo rua não informado ou invalido!");
        }

        if(endereco.getCidade() == null || endereco.getCidade() == ""){
            messages.add("Campo cidade não informado ou invalido!");
        }

        if(endereco.getEstado() == null || endereco.getEstado() == ""){
            messages.add("Campo estado não informado ou invalido!");
        }
        if(endereco.getNumero() < 1){
            messages.add("Campo número não informado ou invalido!");
        }

        if(endereco.getClienteId() == null || endereco.getClienteId() < 1){
            messages.add("ClienteId não informado ou valor invalido!");
        }

        return messages;
    }
}
