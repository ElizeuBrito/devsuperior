package com.devsuperior.clientescrud.services;

import com.devsuperior.clientescrud.dto.ClientDTO;
import com.devsuperior.clientescrud.entities.Client;
import com.devsuperior.clientescrud.repositories.ClientRepository;
import com.devsuperior.clientescrud.services.exceptions.DataBaseException;
import com.devsuperior.clientescrud.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Client ID " + id + " not found"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllClients(Pageable pageable) {
        Page<Client> clientsList = clientRepository.findAll(pageable);
        return clientsList.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client entity = new Client();
        copyClientDtoToClientEntity(clientDTO, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        try {
            Client entity = clientRepository.getReferenceById(id);
            copyClientDtoToClientEntity(clientDTO, entity);
            entity = clientRepository.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Client ID " + id + " not found");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client ID " + id + " not found");
        }
        try {
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Referential integrity fail (constraint violation)");
        }
    }

    private void copyClientDtoToClientEntity(ClientDTO clientDTO, Client entity) {
        entity.setName(clientDTO.getName());
        entity.setCpf(clientDTO.getCpf());
        entity.setIncome(clientDTO.getIncome());
        entity.setBirthDate(clientDTO.getBirthDate());
        entity.setChildren(clientDTO.getChildren());
    }
}
