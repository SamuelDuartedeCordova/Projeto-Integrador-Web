package senac.com.br.Projeto.Integrador.useCases.enderecos;

import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.useCases.enderecos.domanis.EnderecosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.enderecos.domanis.EnderecosResponseDom;

import java.util.List;

public interface EnderecosBusiness {
    List<EnderecosResponseDom> carregarEndereco();
    EnderecosResponseDom criarEndereco(EnderecosRequestDom endereco) throws ProFutException;
    EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom endereco) throws ProFutException;
    void deletarEndereco(Long id);
}
