package aicha.pfe.tasks.service.client;

import aicha.pfe.tasks.entity.Client;
import aicha.pfe.tasks.service.IService;


public interface IClientService extends IService<Client> {
    Client findClientByName(String name);
}
