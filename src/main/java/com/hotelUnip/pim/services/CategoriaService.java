package com.hotelUnip.pim.services;

import com.hotelUnip.pim.domain.Categoria;
import com.hotelUnip.pim.dto.CategoriaDTO;
import com.hotelUnip.pim.repositories.CategoriaRepository;
import com.hotelUnip.pim.security.UserSS;
import com.hotelUnip.pim.services.exceptions.AuthorizationException;
import com.hotelUnip.pim.services.exceptions.DataIntegrityException;
import com.hotelUnip.pim.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    @Autowired
    private S3Service s3Service;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Categoria não encontrada! Id: " + id + ",Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
      List<Categoria> list = repo.findAll();
      return list;
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
        Categoria newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);

        }
        catch (DataIntegrityViolationException e ){
            throw new DataIntegrityException("Não é possivel excluir uma categoria que contém quartos!");
        }

    }

    public Page<Categoria> findPage(Integer page,Integer linesPerPage,String orderBy,String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }

    public Categoria fromDto(CategoriaDTO objDto){
        return new Categoria(objDto.getId(), objDto.getNome(),objDto.getPrecoDiaria(),objDto.getDescricao());
    }

    private void updateData(Categoria newObj, Categoria obj){
        newObj.setNome(obj.getNome());
        newObj.setPrecoDiaria(obj.getPrecoDiaria());

    }

    public URI uploadCategoriaPicture(MultipartFile multipartFile,Integer obj){

        UserSS user = UserService.authenticated();
        if (user == null){
            throw new AuthorizationException("Acesso negado");
        }
        URI uri = s3Service.uploadFile(multipartFile);

        Categoria categoria = repo.getById(obj);
        categoria.setId(obj);
        categoria.setNome(categoria.getNome());
        categoria.setPrecoDiaria(categoria.getPrecoDiaria());
        categoria.setQuartos(categoria.getQuartos());
        categoria.setImageUrl(uri.toString());
        categoria.setDescricao(categoria.getDescricao());

        repo.save(categoria);
            return uri;
    }


}
