package senac.com.br.Projeto.Integrador.useCases.clientes.domanis;

import java.util.List;

public class ClientesResponseDom {

    private Long id;
    private String nome;
    private String sobreNome;
    private String email;
    private String senha;

    private List<ClientesEnderecosResponseDom> enderecos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<ClientesEnderecosResponseDom> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<ClientesEnderecosResponseDom> enderecos) {
        this.enderecos = enderecos;
    }
}
