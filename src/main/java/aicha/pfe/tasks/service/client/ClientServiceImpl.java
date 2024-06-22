package aicha.pfe.tasks.service.client;

import aicha.pfe.tasks.repository.ClientRepository;
import aicha.pfe.tasks.entity.Client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> retrieve() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client add(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client update(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public Client findClientByName(String name) {
        return clientRepository.findClientByName(name);
    }

}
