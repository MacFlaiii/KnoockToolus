package cl.gamezone.proyecto.direccion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gamezone.proyecto.direccion.dto.DireccionDTO;
import cl.gamezone.proyecto.direccion.repository.IDireccionRepository;

@Service
public class DireccionService implements IDireccionService {
    @Autowired
    IDireccionRepository direccionRepository;
    @Override
    public List<DireccionDTO> getAll() {
        // TODO Auto-generated method stub
        return (List<DireccionDTO>) direccionRepository.findAll();
    }

    @Override
    public DireccionDTO getById(Integer id) {
        // TODO Auto-generated method stub
        return direccionRepository.findById(id).get();
    }

    @Override
    public DireccionDTO deleteById(Integer id) {
        // TODO Auto-generated method stub
        direccionRepository.deleteById(id);
        return null;
    }

    @Override
    public DireccionDTO insert(DireccionDTO direccionDTO) {
        // TODO Auto-generated method stub
        return direccionRepository.save(direccionDTO);
    }

    @Override
    public DireccionDTO update(DireccionDTO direccionDTO) {
        // TODO Auto-generated method stub
        return direccionRepository.save(direccionDTO);
    }

}
