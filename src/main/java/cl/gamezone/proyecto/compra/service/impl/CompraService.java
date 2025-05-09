package cl.gamezone.proyecto.compra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gamezone.proyecto.compra.dto.CompraDTO;
import cl.gamezone.proyecto.compra.repository.ICompraRepository;



@Service
public class CompraService implements ICompraService {
    @Autowired
    ICompraRepository compraRepository;

    @Override
    public List<CompraDTO> getAll() {
        // TODO Auto-generated method stub
        return (List<CompraDTO>) compraRepository.findAll();
    }

    @Override
    public CompraDTO getById(Integer id) {
        // TODO Auto-generated method stub
        return compraRepository.findById(id).get();
    }

    @Override
    public CompraDTO deleteById(Integer id) {
        // TODO Auto-generated method stub
        compraRepository.deleteById(id);
        return null;
    }


    @Override
    public CompraDTO insert(CompraDTO compraDTO) {
        // TODO Auto-generated method stub
        return compraRepository.save(compraDTO);
    }

    @Override
    public CompraDTO update(CompraDTO compraDTO) {
        // TODO Auto-generated method stub
        return compraRepository.save(compraDTO);
    }
   

    
    }

