package br.com.person.maper;

import br.com.person.data.vo.v2.PersonVOV2;
import br.com.person.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    // Convertendo VO para Entidade
    public PersonVOV2 converterEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setPrimeiroNome(person.getPrimeiroNome());
        vo.setUltimoNome(person.getUltimoNome());
        vo.setEndereco(person.getEndereco());
        vo.setGenero(person.getGenero());
        vo.setAniversario(new Date());
        return vo;
    }

    // Convertendo Entidadade para o VO
    public Person converterVoToEntity(PersonVOV2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setPrimeiroNome(person.getPrimeiroNome());
        entity.setUltimoNome(person.getUltimoNome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());
        return entity;
    }

}
