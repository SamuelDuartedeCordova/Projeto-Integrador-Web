package senac.com.br.Projeto.Integrador.useCases.enderecos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.enderecos.EnderecosService;
import senac.com.br.Projeto.Integrador.useCases.enderecos.domanis.EnderecosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.enderecos.domanis.EnderecosResponseDom;

import java.util.List;

@Service
public class EnderecosServiceImpl implements EnderecosService {

    @Autowired
    private EnderecosBusinessImpl enderecosBusiness;
    @Override
    public List<EnderecosResponseDom> carregarEndereco() {
        return enderecosBusiness.carregarEndereco();
    }

    @Override
    public EnderecosResponseDom criarEndereco(EnderecosRequestDom endereco) throws ProFutException {
        return enderecosBusiness.criarEndereco(endereco);
    }

    @Override
    public EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom endereco) throws ProFutException {
        return enderecosBusiness.atualizarEndereco(id, endereco);
    }

    @Override
    public void deletarEndereco(Long id) {
        enderecosBusiness.deletarEndereco(id);
    }
}
