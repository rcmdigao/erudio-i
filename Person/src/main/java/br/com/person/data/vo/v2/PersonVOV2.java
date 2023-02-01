package br.com.person.data.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PersonVOV2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String endereco;
    private String genero;

    private Date aniversario;

    public PersonVOV2() {
    }

    public PersonVOV2(Long id, String primeiroNome, String ultimoNome, String endereco, String genero, Date aniversario) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.endereco = endereco;
        this.genero = genero;
        this.aniversario = aniversario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVOV2 personVO = (PersonVOV2) o;
        return Objects.equals(id, personVO.id) && Objects.equals(primeiroNome, personVO.primeiroNome) && Objects.equals(ultimoNome, personVO.ultimoNome) && Objects.equals(endereco, personVO.endereco) && Objects.equals(genero, personVO.genero) && Objects.equals(aniversario, personVO.aniversario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, primeiroNome, ultimoNome, endereco, genero, aniversario);
    }
}
