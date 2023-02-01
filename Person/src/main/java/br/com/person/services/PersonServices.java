package br.com.person.services;

import br.com.person.data.vo.v1.PersonVO;
import br.com.person.data.vo.v2.PersonVOV2;
import br.com.person.exceptions.ResourceNotFoundException;
import br.com.person.maper.DozerMapper;
import br.com.person.maper.PersonMapper;
import br.com.person.model.Person;
import br.com.person.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName()); // Log
    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonMapper mapper;

    public List<PersonVO> findAll(){
       logger.info("Listando pessoas");
       return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO finById(Long id){

       logger.info("Procurando uma pessoa");
       var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um registro para esse ID"));
       return DozerMapper.parseObject(entity, PersonVO.class);
    }


    // Todo Create
    public PersonVO create(PersonVO person){

        logger.info("Cadastrando pessoa");

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    // Todo Update
    public PersonVO update(PersonVO person){
        logger.info("Atualizando pessoa");
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um registro para esse ID"));
        entity.setPrimeiroNome(person.getPrimeiroNome());
        entity.setUltimoNome(person.getUltimoNome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }


    public void delete(Long id){
        logger.info("Delete pessoa");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um registro para esse ID"));
        repository.delete(entity);
    }


    // Todo Create - versão 2
    public PersonVOV2 createV2(PersonVOV2 person){
        logger.info("Cadastrando pessoa na versão 2");
        // Convertendo VO para Entidade
        var entity = mapper.converterVoToEntity(person);
        // Convertendo Entidadade para o VO
        var vo = mapper.converterEntityToVo(repository.save(entity));
        return vo;
    }

}
